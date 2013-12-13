package droidsafe.analyses.pta;

import java.io.File;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.output.NullOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.HashBiMap;

import soot.AnySubType;
import soot.ArrayType;
import soot.Context;
import soot.G;
import soot.Local;
import soot.MethodOrMethodContext;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Value;

import java.util.List;

import soot.jimple.ArrayRef;
import soot.jimple.DynamicInvokeExpr;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InterfaceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.NewMultiArrayExpr;
import soot.jimple.NullConstant;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.StaticFieldRef;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.VirtualInvokeExpr;
import soot.jimple.spark.SparkTransformer;
import soot.jimple.spark.geom.dataMgr.Obj_full_extractor;
import soot.jimple.spark.geom.geomPA.GeomPointsTo;
import soot.jimple.spark.geom.geomPA.GeomQueries;
import soot.jimple.spark.geom.geomPA.IVarAbstraction;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.Node;
import soot.jimple.spark.pag.PAG;
import soot.jimple.spark.sets.HashPointsToSet;
import soot.jimple.spark.sets.P2SetVisitor;
import soot.jimple.spark.sets.PointsToSetInternal;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.callgraph.ReachableMethods;
import soot.toolkits.scalar.Pair;
import soot.util.queue.QueueReader;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Project;
import droidsafe.main.Config;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;

/**
 * A PTA bridge for the SPARK points to analysis.  Right now the analysis is context insensitive.
 * 
 * @author mgordon
 *
 */
public class SparkPTA extends PTABridge {
    /** Logger field */
    private static final Logger logger = LoggerFactory.getLogger(SparkPTA.class);
    /** internal soot call graph */
    private CallGraph callGraph;
    /** bimap of new expressions to their alloc node representation */
    private HashBiMap<Object, AllocNode> newToAllocNodeMap;
    /** all method reachable from the harness main */
    private Set<SootMethod> reachableMethods;
    /** underlying pta */
    private PAG ptsProvider;
    
    public SparkPTA() {
        
    }

    @Override
    protected void releaseInternal() {
        // nothing to do?
    }

    @Override
    protected void runInternal() {
      //don't print crap to screen!
        G.v().out = new PrintStream(NullOutputStream.NULL_OUTPUT_STREAM);
        Scene.v().loadDynamicClasses();

        setSparkPointsToAnalysis();
        
        //other passes can print crap now
        G.v().out = System.out;
       
        ptsProvider = (PAG)Scene.v().getPointsToAnalysis();
          
        //cache the call graph
        callGraph = Scene.v().getCallGraph();
        
        createNewToAllocMap();
        
        //fill reachable methods map
        reachableMethods = new HashSet<SootMethod>();
       
        QueueReader<MethodOrMethodContext> qr = Scene.v().getReachableMethods().listener();
       
        while (qr.hasNext()) {
            MethodOrMethodContext momc = qr.next();
            if (momc instanceof SootMethod) {
                reachableMethods.add((SootMethod)momc);
            }
        }
        
        System.out.println("Size of reachable methods: " + reachableMethods.size());
        System.out.println("Alloc Nodes: " + newToAllocNodeMap.size());
        
        if (Config.v().dumpPta){
            dumpPTA(Project.v().getOutputDir() + File.separator +"pta.txt");
        }

        if (Config.v().dumpCallGraph) {
            dumpCallGraph(Project.v().getOutputDir() + File.separator + "callgraph.dot");
        }
    }

    /**
     * Given a new expression (Jimple NewExpr or String) return the corresponding AllocNode.
     */
    public AllocNode getAllocNode(Object newExpr) {
        if (newExpr instanceof NewMultiArrayExpr) {
            NewMultiArrayExpr newArr = (NewMultiArrayExpr)newExpr;
            ArrayType type = (ArrayType)newArr.getType();
            Integer i = type.numDimensions;
            Pair pair = new Pair(newArr, i);
            return newToAllocNodeMap.get(pair);
        } else
            return newToAllocNodeMap.get(newExpr);
    }

    /**
     * Return a set of all allocnodes in the program.
     */
    public Set<AllocNode> getAllAllocNodes() {
        return Collections.unmodifiableSet(newToAllocNodeMap.values());
    }

    /**
     * Given a Spark AllocNode return the corresponding new expression (Jimple NewExpr or String) 
     */
    public Object getNewExpr(AllocNode an) {
        return newToAllocNodeMap.inverse().get(an);
    }

    
    @Override
    public boolean isLegalCast(Type objType, Type refType) {
        return ptsProvider.getTypeManager().castNeverFails(objType, refType);
    }
    
    @Override
    public Set<SootMethod> getAllReachableMethods() {
        return reachableMethods;
    }

    @Override
    public boolean isReachableMethod(SootMethod method) {
        return reachableMethods.contains(method);
    }

    @Override
    public boolean isPointer(Value val) {
        return (ptsProvider.findGlobalVarNode(val) != null || ptsProvider.findLocalVarNode(val) != null);
    }

    @Override
    public Set<Type> getTypes(Value val) {
        Set<Type> types = new LinkedHashSet<Type>();

        for (AllocNode node : getPTSet(val)) {
            types.add(node.getType());
        }

        return types;
    }

    @Override
    public Set<Type> getTypes(Value val, PTAContext context) {
        Set<Type> types = new LinkedHashSet<Type>();

        for (AllocNode node : getPTSet(val, context)) {
            types.add(node.getType());
        }

        return types;
    }

    @Override
    public Set<AllocNode> getPTSet(Value val) {
        final Set<AllocNode> allocNodes = new HashSet<AllocNode>();
        PointsToSetInternal pts = null;
        
        try {
            if (val instanceof InstanceFieldRef) {
                final InstanceFieldRef ifr = (InstanceFieldRef)val;
                pts = (PointsToSetInternal)ptsProvider.reachingObjects((Local)ifr.getBase(), ifr.getField());
            } else if (val instanceof ArrayRef) {
                ArrayRef arrayRef = (ArrayRef)val;
                pts = (PointsToSetInternal)ptsProvider.reachingObjectsOfArrayElement
                        (ptsProvider.reachingObjects((Local)arrayRef.getBase()));
            } else if (val instanceof Local){            
                 pts = (PointsToSetInternal)ptsProvider.reachingObjects((Local)val);
            } else if (val instanceof StaticFieldRef) {
                SootField field = ((StaticFieldRef)val).getField();
                pts = (PointsToSetInternal)ptsProvider.reachingObjects(field);
            } else if (val instanceof NullConstant) {
                return allocNodes;
            } else {
                logger.error("Unknown reference type for insenstive search: {} {}", val, val.getClass());
                droidsafe.main.Main.exit(1);
            }
            
            //visit internal points to set and grab all allocnodes        
            pts.forall(new P2SetVisitor() {
                public void visit(Node n) {
                    allocNodes.add((AllocNode)n);
                }
            });
            
        } catch (Exception e) {
            logger.info("Some sort of error getting context insensitive points to set for {}", val, e);
            //e.printStackTrace();
        }

        return allocNodes;
    }
    
    
    public Set<AllocNode> getPTSetOfArrayElement(AllocNode allocNode) {
        final Set<AllocNode> ptSet = new HashSet<AllocNode>();
        
        HashPointsToSet pointsToSet = new HashPointsToSet(allocNode.getType(), ptsProvider);
        pointsToSet.add(allocNode);
        
                ((PointsToSetInternal)ptsProvider.reachingObjectsOfArrayElement(pointsToSet)).forall(new P2SetVisitor() {
            @Override
            public void visit(Node node) {
                ptSet.add((AllocNode)node);
            }
        });
        
        return ptSet;
    }

    @Override
    public Set<AllocNode> getPTSet(AllocNode node, final SootField f) {
        if (f.isStatic()) {
            logger.error("Cannot call getPTSet(node, field) with static field: {}", f);
            droidsafe.main.Main.exit(1);
        }
        
        final Set<AllocNode> allocNodes = new HashSet<AllocNode>();
        
        HashPointsToSet pointsToSet = new HashPointsToSet(node.getType(), ptsProvider);
        pointsToSet.add(node);
        
        ((PointsToSetInternal)ptsProvider.reachingObjects(pointsToSet, f)).forall(new P2SetVisitor() {
            @Override
            public void visit(Node node) {
                allocNodes.add((AllocNode)node);
            }
        }); 
       
/*
        PointsToSetInternal bases = (PointsToSetInternal)ptsProvider.getSetFactory().newSet(node.getType(), ptsProvider);
        bases.add(node);
        
        final PointsToSetInternal pts = ptsProvider.getSetFactory().newSet( 
            (f instanceof SootField) ? ((SootField)f).getType() : null, ptsProvider );
        bases.forall( new P2SetVisitor() {
            public final void visit( Node n ) {
                Node nDotF = ((AllocNode) n).dot( f );
                if(nDotF != null) pts.addAll( nDotF.getP2Set(), null );
            }} );
        
        //visit internal points to set and grab all allocnodes        
        pts.forall(new P2SetVisitor() {
            public void visit(Node n) {
                allocNodes.add((AllocNode)n);
            }
        });
*/
        return allocNodes;
    }

    @Override
    /** Ignore context for now */
    public Set<AllocNode> getPTSet(Value val, PTAContext context) {
        return getPTSet(val);
        /*
        //can't handle event context in spark
        if (context.getType() == ContextType.EVENT_CONTEXT) {
            return getPTSet(val);
        } else if (context.getType() != ContextType.ONE_CFA) {
            logger.error("Invalid context type for spark query: {}", context.getType());
            droidsafe.main.Main.exit(1);
        }
        
        Context sparkContext = context.getContext().srcCtxt();
        
        final Set<AllocNode> allocNodes = new HashSet<AllocNode>();
        PointsToSetInternal pts = null;
        
        try {
            if (val instanceof InstanceFieldRef) {
                final InstanceFieldRef ifr = (InstanceFieldRef)val;
                pts = (PointsToSetInternal)ptsProvider.reachingObjects(sparkContext, (Local)ifr.getBase(), ifr.getField());
            } else if (val instanceof ArrayRef) {
                ArrayRef arrayRef = (ArrayRef)val;
                pts = (PointsToSetInternal)ptsProvider.reachingObjectsOfArrayElement
                        (ptsProvider.reachingObjects(sparkContext, (Local)arrayRef.getBase()));
            } else if (val instanceof Local){            
                 pts = (PointsToSetInternal)ptsProvider.reachingObjects(sparkContext, (Local)val);
            } else if (val instanceof StaticFieldRef) {
                SootField field = ((StaticFieldRef)val).getField();
                pts = (PointsToSetInternal)ptsProvider.reachingObjects(field);
            } else if (val instanceof NullConstant) {
                return allocNodes;
            } else {
                logger.error("Unknown reference type for insenstive search: {} {}", val, val.getClass());
                droidsafe.main.Main.exit(1);
            }
            
            //visit internal points to set and grab all allocnodes        
            pts.forall(new P2SetVisitor() {
                public void visit(Node n) {
                    allocNodes.add((AllocNode)n);
                }
            });
            
        } catch (Exception e) {
            logger.info("Some sort of error getting context insensitive points to set for {}", val, e);
            //e.printStackTrace();
        }

        return allocNodes;
        */
    }
    
    /**
     * Given an invoke expression, resolve the targets of the method.  Perform a pta virtual method resolution
     * for instance invokes, and use an insensitive search.
     */
    public Collection<SootMethod> resolveInvoke(InvokeExpr invoke) 
        throws CannotFindMethodException {
        if (invoke instanceof StaticInvokeExpr) {
            Set<SootMethod> ret = new HashSet<SootMethod>();
            ret.add(((StaticInvokeExpr)invoke).getMethod());
            return ret;
        } else if (invoke instanceof DynamicInvokeExpr) {
            logger.error("Should not see dynamic invoke expr: {}", invoke);
            droidsafe.main.Main.exit(1);
        } else if (invoke instanceof InstanceInvokeExpr) {
            return resolveInstanceInvoke((InstanceInvokeExpr)invoke);
        }
        
        return Collections.emptySet();
    }
    
    @Override
    public Collection<SootMethod> resolveInvoke(InvokeExpr invoke, PTAContext context) 
            throws CannotFindMethodException {
        if (invoke instanceof StaticInvokeExpr) {
            Set<SootMethod> ret = new HashSet<SootMethod>();
            ret.add(((StaticInvokeExpr)invoke).getMethod());
            return ret;
        } else if (invoke instanceof DynamicInvokeExpr) {
            logger.error("Should not see dynamic invoke expr: {}", invoke);
            droidsafe.main.Main.exit(1);
        } else if (invoke instanceof InstanceInvokeExpr) {
            return resolveInstanceInvokeMap((InstanceInvokeExpr)invoke, context).values();
        }          
        return Collections.emptySet();
    }

    /**
     * Use the PTA to resolve the set of method that an instance invoke could call.  In this 
     * version, use the context insensitive result.  Return a map of each alloc node to its
     * target method.
     */
    public Map<AllocNode,SootMethod> resolveInstanceInvokeMap(InstanceInvokeExpr invoke) 
        throws CannotFindMethodException {
        return resolveInstanceInvokeMap(invoke, null);
    }
    
    /**
     * Use the PTA to resolve the set of method that an instance invoke could call.  In this 
     * version, use the 1cfa context result.  Return a map of each alloc node to its
     * target method.
     */
    public Map<AllocNode,SootMethod> resolveInstanceInvokeMap(InstanceInvokeExpr invoke, PTAContext context) 
        throws CannotFindMethodException {
        Set<AllocNode> allocs = null;
        //get either the context sensitive or insensitive result based on the context param 
        if (context == null) 
            allocs = getPTSet(invoke.getBase());
        else
            allocs = getPTSet(invoke.getBase(), context);
        
        return internalResolveInstanceInvokeMap(allocs, invoke, context);
    }

    /**
     * 
     */
    private Map<AllocNode, SootMethod> internalResolveInstanceInvokeMap(Set<AllocNode> allocs, 
        InstanceInvokeExpr invoke, PTAContext context) throws CannotFindMethodException {
        Map<AllocNode, SootMethod> methods = new LinkedHashMap<AllocNode, SootMethod>();
        
      //loop over alloc nodes and resolve the concrete dispatch for each, placing in the set
        for (AllocNode an : allocs) {
            if (invoke instanceof SpecialInvokeExpr) {
                SootMethod resolved = SootUtils.resolveSpecialDispatch((SpecialInvokeExpr)invoke); 
                methods.put(an, resolved);
            } else if (invoke instanceof VirtualInvokeExpr || invoke instanceof InterfaceInvokeExpr) {
                Type t = an.getType();
                SootClass clz = null;
                //some type that we don't understand, so throw that we cannot find the method
                if ( t instanceof AnySubType ) {
                    throw new CannotFindMethodException(t, invoke.getMethod());
                } else if (t instanceof ArrayType) {
                    //if array type then we have to get a reference to the Object class
                    //because in java one can invoke methods of Object on arrays
                    clz = Scene.v().getSootClass("java.lang.Object");
                } else {
                    //normal reference type, just get the soot class
                    clz = ((RefType)t).getSootClass();
                }   
                
                methods.put(an, SootUtils.resolveConcreteDispatch(clz, invoke.getMethod()));
            } else {
                logger.error("Unknown invoke expression type encountered when resolving InstanceInvoke {}", invoke);
                droidsafe.main.Main.exit(1);
            }
            
            
        }

        return methods;
    }

    @Override
    public void dumpPTA() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dumpPTA(String fileName) {
        // TODO Auto-generated method stub

    }

    @Override
    public void dumpPTAForContext(PrintStream file, PTAContext sootContext) {
        // TODO Auto-generated method stub

    }

    @Override
    public void dumpCallGraph(String fileStr) {
        // TODO Auto-generated method stub

    }
    
    /**
     * Create the bi map of NewExpr <-> AllocNode
     */
    private void createNewToAllocMap() {
        newToAllocNodeMap = HashBiMap.create();
        
        for (AllocNode node : ptsProvider.getAllocNodes()) {
            newToAllocNodeMap.put(node.getNewExpr(), node);
        }
        
        
    }

    /**
     * Run context insensitive spark analysis.
     */
    static void setSparkPointsToAnalysis() {
        logger.info("[spark] Starting analysis ...");

        HashMap<String, String> opt = new HashMap<String, String>();
        opt.put("enabled","true");
        opt.put("verbose","false");
        opt.put("ignore-types","false");          
        opt.put("force-gc","false");            
        opt.put("pre-jimplify","false");          
        opt.put("vta","false");                   
        opt.put("rta","false");                   
        opt.put("field-based","false");           
        opt.put("types-for-sites","false");        
        opt.put("merge-stringbuffer","false");   
        opt.put("string-constants","true");     
        opt.put("simulate-natives","true");      
        opt.put("simple-edges-bidirectional","false");
        opt.put("on-fly-cg","true");            
        opt.put("simplify-offline","false");    
        opt.put("simplify-sccs","false");        
        opt.put("ignore-types-for-sccs","false");
        opt.put("propagator","worklist");
        opt.put("set-impl","double");
        opt.put("double-set-old","hybrid");         
        opt.put("double-set-new","hybrid");
        opt.put("dump-html","false");           
        opt.put("dump-pag","false");             
        opt.put("dump-solution","false");        
        opt.put("topo-sort","false");           
        opt.put("dump-types","true");             
        opt.put("class-method-var","true");     
        opt.put("dump-answer","false");          
        opt.put("add-tags","false");             
        opt.put("set-mass","false");
        
        //some context sensitivity
        opt.put("cs-demand", "false");
        opt.put("lazy-pts", "true");
        opt.put("passes", "10");
        opt.put("traversal", "75000");

        SparkTransformer.v().transform("",opt);


        logger.info("[spark] Done!");
    }
}
