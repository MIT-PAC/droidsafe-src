package droidsafe.analyses.pta;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
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
import soot.MethodContext;
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
import soot.jimple.Stmt;
import soot.jimple.VirtualInvokeExpr;
import soot.jimple.spark.SparkTransformer;
import soot.jimple.spark.geom.dataMgr.Obj_full_extractor;
import soot.jimple.spark.geom.geomPA.GeomPointsTo;
import soot.jimple.spark.geom.geomPA.GeomQueries;
import soot.jimple.spark.geom.geomPA.IVarAbstraction;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.MethodPAG;
import soot.jimple.spark.pag.Node;
import soot.jimple.spark.pag.ObjectSensitiveAllocNode;
import soot.jimple.spark.pag.PAG;
import soot.jimple.spark.sets.HashPointsToSet;
import soot.jimple.spark.sets.P2SetVisitor;
import soot.jimple.spark.sets.PointsToSetInternal;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.callgraph.ReachableMethods;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.toolkits.scalar.Pair;
import soot.util.queue.QueueReader;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.main.Config;
import droidsafe.transforms.objsensclone.ObjectSensitivityCloner;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;

/**
 * A PTA bridge for the SPARK points to analysis.  Right now the analysis is context insensitive.
 * 
 * @author mgordon
 *
 */
public class SparkPTA extends PTABridge {
    
    public static final int K = 2;
    
    /** Logger field */
    private static final Logger logger = LoggerFactory.getLogger(SparkPTA.class);
    /** bimap of new expressions to their alloc node representation */
    private HashBiMap<Object, AllocNode> newToAllocNodeMap;
    /** all method reachable from the harness main */
    private Set<SootMethod> reachableMethods;
    /** add method + contexts that are reachable */
    private Set<MethodOrMethodContext> reachableMethodContexts;
    /** underlying pta */
    private PAG ptsProvider;

    private HashMap<SootMethod, Set<MethodOrMethodContext>> methodToContexts;

    private Set<AllocNode> allAllocNodes;
    
    /** comma separated list of classes in which no matter what the length of k
     * for object sensitivity, we want to limit the depth of the object sensitivity 
     * to one.
     */
    private static final String  LIMIT_DEPTH_TO_ONE = 
            "java.lang.Throwable,java.math.BigInt,java.math.BigInteger,"+
             "android.graphics.Rect,android.view.MotionEvent,android.view.KeyEvent,android.graphics.Point";
    
    public SparkPTA(Map<String,String> opts) {
        super(opts);
    }

    @Override
    protected void releaseInternal() {
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
        reachableMethods = new LinkedHashSet<SootMethod>();
        reachableMethodContexts = new LinkedHashSet<MethodOrMethodContext>();
        methodToContexts = new HashMap<SootMethod, Set<MethodOrMethodContext>>();

        QueueReader<MethodOrMethodContext> qr = Scene.v().getReachableMethods().listener();

        long totalIndegree = 0;

        while (qr.hasNext()) {
            MethodOrMethodContext momc = qr.next();

            reachableMethods.add(momc.method());
            
            reachableMethodContexts.add(momc);

            //System.out.println("SparkPTA Reachable MOMC: " + momc);
            
            if (!methodToContexts.containsKey(momc.method()))
                methodToContexts.put(momc.method(), new LinkedHashSet<MethodOrMethodContext>());
            
            methodToContexts.get(momc.method()).add(momc);
            
            Iterator<Edge> iterator = callGraph.edgesInto(momc);
            while (iterator.hasNext()) {
                totalIndegree++;
                Edge e = iterator.next();
                
                // System.out.println("\tEdge: " + e + "\n");
            }
        }

        QueueReader<Edge> edges = callGraph.listener();
        /*
        while (edges.hasNext()) {
            System.out.println("SparkPTA cg edge: " + edges.next());
        }*/
        

        System.out.println("Size of reachable methods: " + reachableMethods.size());
        System.out.println("Alloc Nodes: " + newToAllocNodeMap.size());
        System.out.println("Average Contexts per Method: " + 
                (((double)reachableMethodContexts.size()) / ((double)reachableMethods.size())));
        System.out.println("Number of obj sens nodes: " + ObjectSensitiveAllocNode.numberOfObjSensNodes());
        
        if (Config.v().dumpPta){
            dumpPTA(Project.v().getOutputDir() + File.separator +"pta.txt");
        }

        if (Config.v().dumpCallGraph) {
            dumpCallGraph(Project.v().getOutputDir() + File.separator + "callgraph.dot");
        }

        if (Config.v().statsRun)
            new SparkPTAStats().writeStats();
    }

    public CallGraph getCallGraph() {
        return callGraph;
    }
    
    
    public Set<MethodOrMethodContext> getMethodContexts(SootMethod method) {
        if (!methodToContexts.containsKey(method)) {
            return Collections.<MethodOrMethodContext>emptySet();
        }
        
        return methodToContexts.get(method);
    }
    
    /**
     * Given a new expression (Jimple NewExpr or String) return the corresponding AllocNode.
     */
    public IAllocNode getAllocNode(Object newExpr, Context context) {
        AllocNode insens = null;
        if (newExpr instanceof NewMultiArrayExpr) {
            NewMultiArrayExpr newArr = (NewMultiArrayExpr)newExpr;
            ArrayType type = (ArrayType)newArr.getType();
            Integer i = type.numDimensions;
            Pair pair = new Pair(newArr, i);
            insens = (AllocNode) newToAllocNodeMap.get(pair);
        } else {
            if (!newToAllocNodeMap.containsKey(newExpr)) {
                System.out.println("Not in new -> alloc map: " + newExpr);
                return null;
            }
            insens = (AllocNode) newToAllocNodeMap.get(newExpr);
        }
        
        if (context != null) {
            return insens.context(context);
        } else {
            return insens;
        }
            
    }

    /**
     * Return a set of all allocnodes in the program.
     */
    public Set<? extends IAllocNode> getAllAllocNodes() {
        return allAllocNodes;
    }

    /**
     * Given a Spark AllocNode return the corresponding new expression (Jimple NewExpr or String) 
     */
    public Object getNewExpr(IAllocNode an) {
        return newToAllocNodeMap.inverse().get((AllocNode) an);
    }


    @Override
    public boolean isLegalCast(Type objType, Type refType) {
        return ptsProvider.getTypeManager().castNeverFails(objType, refType);
    }

    @Override
    public Set<MethodOrMethodContext> getReachableMethodContexts() {
        return reachableMethodContexts;
    }
    
    @Override
    public Set<SootMethod> getReachableMethods() {
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

        for (IAllocNode node : getPTSet(val)) {
            types.add(node.getType());
        }

        return types;
    }

    @Override
    public Set<Type> getTypes(Value val, Context context) {
        Set<Type> types = new LinkedHashSet<Type>();

        for (IAllocNode node : getPTSet(val, context)) {
            types.add(node.getType());
        }

        return types;
    }

    @Override
    public Set<? extends IAllocNode> getPTSet(Value val) {
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
                return (Set<? extends IAllocNode>) allocNodes;
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


    public Set<? extends IAllocNode> getPTSetOfArrayElement(IAllocNode allocNode) {
        final Set<AllocNode> ptSet = new HashSet<AllocNode>();

        HashPointsToSet pointsToSet = new HashPointsToSet(allocNode.getType(), ptsProvider);
        pointsToSet.add((AllocNode) allocNode);

        ((PointsToSetInternal)ptsProvider.reachingObjectsOfArrayElement(pointsToSet)).forall(new P2SetVisitor() {
            @Override
            public void visit(Node node) {
                ptSet.add((AllocNode)node);
            }
        });

        return (Set<? extends IAllocNode>) ptSet;
    }

    @Override
    public Set<? extends IAllocNode> getPTSet(IAllocNode node, final SootField f) {
        if (f.isStatic()) {
            logger.error("Cannot call getPTSet(node, field) with static field: {}", f);
            droidsafe.main.Main.exit(1);
        }

        final Set<AllocNode> allocNodes = new HashSet<AllocNode>();

        HashPointsToSet pointsToSet = new HashPointsToSet(node.getType(), ptsProvider);
        pointsToSet.add((AllocNode) node);

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
        return (Set<? extends IAllocNode>) allocNodes;
    }

    private void checkContext(Context context) {
        if (!(context instanceof AllocNode)) {
            logger.error("Invalid context type for spark object sensitivity: " + context);
            droidsafe.main.Main.exit(1);
        }
            
    }
    
    @Override
    public Set<? extends IAllocNode> getPTSet(Value val, Context context) {
        
        if (context == null)
            return getPTSet(val);
        
        checkContext(context);

        final Set<AllocNode> allocNodes = new HashSet<AllocNode>();
        PointsToSetInternal pts = null;

        try {
            if (val instanceof InstanceFieldRef) {
                final InstanceFieldRef ifr = (InstanceFieldRef)val;
                pts = (PointsToSetInternal)ptsProvider.reachingObjects(context, (Local)ifr.getBase(), ifr.getField());
            } else if (val instanceof ArrayRef) {
                ArrayRef arrayRef = (ArrayRef)val;
                pts = (PointsToSetInternal)ptsProvider.reachingObjectsOfArrayElement
                        (ptsProvider.reachingObjects(context, (Local)arrayRef.getBase()));
            } else if (val instanceof Local){            
                 pts = (PointsToSetInternal)ptsProvider.reachingObjects(context, (Local)val);
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
    public Collection<SootMethod> resolveInvoke(InvokeExpr invoke, Context context) 
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
    public Map<IAllocNode,SootMethod> resolveInstanceInvokeMap(InstanceInvokeExpr invoke) 
            throws CannotFindMethodException {
        return resolveInstanceInvokeMap(invoke, null);
    }

    /**
     * Use the PTA to resolve the set of method that an instance invoke could call.  In this 
     * version, use the 1cfa context result.  Return a map of each alloc node to its
     * target method.
     */
    public Map<IAllocNode,SootMethod> resolveInstanceInvokeMap(InstanceInvokeExpr invoke, Context context) 
            throws CannotFindMethodException {
        Set<? extends IAllocNode> allocs = null;
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
    private Map<IAllocNode, SootMethod> internalResolveInstanceInvokeMap(Set<? extends IAllocNode> allocs, 
        InstanceInvokeExpr invoke, Context context) throws CannotFindMethodException {
        Map<IAllocNode, SootMethod> methods = new LinkedHashMap<IAllocNode, SootMethod>();

        //loop over alloc nodes and resolve the concrete dispatch for each, placing in the set
        for (IAllocNode an : allocs) {
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
    public void dumpPTAForContext(PrintStream file, Context sootContext) {
        // TODO Auto-generated method stub

    }

    @Override
    public void dumpCallGraph(String fileStr) {
        // TODO Auto-generated method stub

    }
    
    private void countNode(Map<SootClass, Integer> nodeCount, AllocNode node) {
        SootClass clz = null;
        if (node.getType() instanceof RefType) {
            clz = ((RefType)node.getType()).getSootClass();
        } else if (node.getType() instanceof ArrayType && 
                ((ArrayType)node.getType()).getArrayElementType() instanceof RefType) {
            clz = ((RefType)((ArrayType)node.getType()).getArrayElementType()).getSootClass();
        }
        
        if (clz != null) {
            if (!nodeCount.containsKey(clz)) {
                nodeCount.put(clz, 0);
            }
            
            nodeCount.put(clz, nodeCount.get(clz) + 1);
        }
    }
    

    /**
     * Create the bi map of NewExpr <-> AllocNode
     */
    private void createNewToAllocMap() {
        newToAllocNodeMap = HashBiMap.create();
        allAllocNodes = new LinkedHashSet<AllocNode>();
            
        Map<SootClass,Integer> nodeCount = new LinkedHashMap<SootClass,Integer>();

        int realSize = 0; 

        for (AllocNode node : ptsProvider.getAllocNodes()) {
            newToAllocNodeMap.put(node.getNewExpr(), node);
            realSize ++;
            allAllocNodes.add(node);
        
            //countNode(nodeCount, node);
        
            for (Map.Entry<Context, AllocNode> entry : node.getContextNodeMap().entrySet()) {
                allAllocNodes.add(entry.getValue());
                //countNode(nodeCount, node);
            }
        }

        
        System.out.println("Alloc node size (insensitive objects): " + realSize);
        
        /* used to print a sorted list of alloc nodes created
        Map<SootClass, Integer> sortedNodeCount = SootUtils.sortByValue(nodeCount);
        for (Map.Entry<SootClass, Integer> entry : sortedNodeCount.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
        */
    }

    /**
     * Run context insensitive spark analysis.
     */
    void setSparkPointsToAnalysis() {
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
        
  
        
        opt.put("simulate-natives","false");      
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
        
        opt.put("merge-stringbuffer","false");   
        opt.put("string-constants","true");   

        opt.put("kobjsens", Integer.toString(K));

        opt.put("obj-sens-no-context-list", 
                LIMIT_DEPTH_TO_ONE);
        
        //now overwrite options with options that are passed in
        for (Map.Entry<String, String> entry : opts.entrySet()) {
            opt.put(entry.getKey(), entry.getValue());
        }
        
        /*
        //some context sensitivity
        opt.put("cs-demand", "false");
        opt.put("lazy-pts", "true");
        opt.put("passes", "10");
        opt.put("traversal", "75000");
         */

        SparkTransformer.v().transform("",opt);


        logger.info("[spark] Done!");
    }
}
