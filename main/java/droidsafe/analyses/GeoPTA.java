package droidsafe.analyses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.AnySubType;
import soot.ArrayType;
import soot.Context;
import soot.G;
import soot.Local;
import soot.PointsToSet;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.CastExpr;
import soot.jimple.ClassConstant;
import soot.jimple.DynamicInvokeExpr;
import soot.jimple.Expr;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InterfaceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.NewExpr;
import soot.jimple.NewMultiArrayExpr;
import soot.jimple.NullConstant;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.StaticFieldRef;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.VirtualInvokeExpr;
import soot.jimple.spark.SparkTransformer;
import soot.jimple.spark.geom.dataRep.CallsiteContextVar;
import soot.jimple.spark.geom.dataRep.IntervalContextVar;
import soot.jimple.spark.geom.geomE.FullSensitiveNode;
import soot.jimple.spark.geom.geomPA.CgEdge;
import soot.jimple.spark.geom.geomPA.GeomPointsTo;
import soot.jimple.spark.geom.geomPA.GeomQueries;
import soot.jimple.spark.geom.geomPA.IVarAbstraction;
import soot.jimple.spark.geom.helper.ContextTranslator;
import soot.jimple.spark.geom.helper.Obj_1cfa_extractor;
import soot.jimple.spark.geom.helper.Obj_full_extractor;
import soot.jimple.spark.geom.helper.PtSensVisitor;
import soot.jimple.spark.pag.AllocDotField;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.ArrayElement;
import soot.jimple.spark.pag.ContextVarNode;
import soot.jimple.spark.pag.GlobalVarNode;
import soot.jimple.spark.pag.LocalVarNode;
import soot.jimple.spark.pag.MethodPAG;
import soot.jimple.spark.pag.Node;
import soot.jimple.spark.pag.VarNode;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.options.PaddleOptions;
import soot.toolkits.scalar.Pair;
import soot.jimple.ArrayRef;
import soot.jimple.FieldRef;
import soot.jimple.spark.pag.FieldRefNode;
import soot.jimple.spark.sets.EmptyPointsToSet;
import soot.jimple.spark.sets.P2SetVisitor;
import soot.jimple.spark.sets.PointsToSetInternal;

import com.google.common.collect.HashBiMap;
import org.apache.commons.io.*;
import org.apache.commons.io.output.NullOutputStream;

import droidsafe.android.app.Project;
import droidsafe.main.Config;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;
import droidsafe.utils.Utils;

/**
 * Configure and run the Soot Spark PTA.  This class assumes the soot 
 * class path has been set, the appropriate classes have been loaded, 
 * and the entry points have been defined.
 * 
 * @author mgordon
 *
 */
public class GeoPTA {
    /** Logger field */
    private static final Logger logger = LoggerFactory.getLogger(GeoPTA.class);
    /** internal soot geometric points to analysis object */
    private GeomPointsTo ptsProvider;
    /** internal soot call graph */
    private CallGraph callGraph;
    /** bimap of new expressions to their alloc node representation */
    private HashBiMap<Object, AllocNode> newToAllocNodeMap;
    /** singleton of this analysis */
    private static GeoPTA v;
    /** Full context query interface */
    private GeomQueries queries;
    /** object to reuse for full sensitive queries */
    private Obj_full_extractor objFull;

    public static final Set<AllocNode> EMPTY_PTA_SET = Collections.<AllocNode>emptySet();

    /**
     * Reset the PTA and get it ready for another run.
     */
    public static void release() {
        v = null;
        Scene.v().releaseCallGraph();
        Scene.v().releasePointsToAnalysis();

        G.v().MethodPAG_methodToPag = new HashMap<SootMethod, MethodPAG>();

        ContextTranslator.pts_1cfa_map = null;
        ContextTranslator.objs_1cfa_map = null;

        System.gc();
        System.gc();
    }

    /**
     * Return the instance of the PTA.
     */
    public static GeoPTA v() {
        return v;
    }

    /**
     * Runs Soot's geometric PTA and resolve the context.
     */
    public static void run() {
        //don't print crap to screen!
        G.v().out = new PrintStream(NullOutputStream.NULL_OUTPUT_STREAM);
        Scene.v().loadDynamicClasses();

        setGeomPointsToAnalysis();
        

        v = new GeoPTA();
        
        //other passes can print crap now
        G.v().out = System.out;
    }

    /**
     * Private constructor.
     */
    private GeoPTA() {
        ptsProvider = (GeomPointsTo)Scene.v().getPointsToAnalysis();
        
        //update the underlying soot call graph to prune unrealizeable edges
        ptsProvider.updateSootData();
        
        //cache the call graph
        callGraph = Scene.v().getCallGraph();
        
        queries = new GeomQueries(ptsProvider);
        objFull = new Obj_full_extractor();
        //ContextTranslator.build_1cfa_map(ptsProvider);

        createNewToAllocMap();

        if (Config.v().dumpPta){
            dumpPTA(Project.v().getOutputDir() + File.separator +"pta.txt");
        }

        if (Config.v().dumpCallGraph) {
            dumpCallGraph(Project.v().getOutputDir() + File.separator + "callgraph.dot");
        }
    }

    /**
     * Return true if it is legal to cast objType to the refType.  False if not.
     */
    public boolean isLegalCast(Type objType, Type refType) {
        return ptsProvider.castNeverFails(objType, refType);
    }
    
    /**
     * Return true is this method is a valid method to use for a context sensitive search.
     */
    public boolean isValidMethod(SootMethod sm) {
        return ptsProvider.isValidMethod(sm);
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

    /**
     * Create the bi map of NewExpr <-> AllocNode
     */
    private void createNewToAllocMap() {
        newToAllocNodeMap = HashBiMap.create(ptsProvider.consG.keySet().size());

        //try a few different ways to find all allocnodes

        for (Node node : ptsProvider.consG.keySet()) {
            if (node instanceof AllocNode) {
                AllocNode an = (AllocNode)node;
                newToAllocNodeMap.put(an.getNewExpr(), an);
            } 
        }

        for (IVarAbstraction ivar : ptsProvider.allocations) {
            //allocations in the pta don't have context and are not pointer
            //they just wrap the underlying allocnode
            AllocNode obj = (AllocNode)ivar.getWrappedNode();
            newToAllocNodeMap.put(obj.getNewExpr(), obj);
        }
        
    }

    /**
     * Return list of all reachable methods as calculated by pta.
     */
    public Set<SootMethod> getAllReachableMethods() {
        return ptsProvider.getAllReachableMethods();
    }

    /**
     * Return true if this value is a pointer that is represented in the 
     * PTA graph.
     */
    public boolean isPointer(Value val) {
        if (!(val.getType() instanceof RefLikeType)) 
            return false;

        //now see if it is tracked by the PTA
        if (getInternalNode(val) != null)
            return true;

        return false;
    }

    
    /**
     * Return the internal node representation for the value (local, fieldref, or array ref)
     * in the pointer assignment graph.  
     */
    public IVarAbstraction getInternalNode(Value val) {
        Node node = null;
        
        if (val instanceof Local) {
            node = ptsProvider.findLocalVarNode(val);
        } else if (val instanceof InstanceFieldRef) {
            node = ptsProvider.findLocalVarNode((Local) ((InstanceFieldRef)val).getBase());    
        } else if (val instanceof StaticFieldRef) {
           SootField field = ((FieldRef)val).getField();
           node = ptsProvider.findGlobalVarNode(field); 
        } else if (val instanceof ArrayRef) {
            ArrayRef arf = (ArrayRef) val;
            node = ptsProvider.findLocalVarNode((Local) arf.getBase());
        }

        if (node == null) {
            return null;
        }
        
        IVarAbstraction internalNode = ptsProvider.findInternalNode(node);
        internalNode = internalNode.getRepresentative();
        return internalNode;
    }

    /**
     * For a given pointer in the context, return all the types that the objects pointed to 
     * by the pointer can realize.
     */
    public Set<Type> getTypesEntryPointContext(Value val, Edge context) {
        Set<Type> types = new LinkedHashSet<Type>();

        for (AllocNode node : getPTSetEventContext(val, context)) {
            types.add(node.getType());
        }

        return types;
    }

   
    /** 
     * Return the 1CFA context query for reference and 1CFA context edge.
     */
    public Set<AllocNode> getPTSet1CFA(Value val, Edge context) {
        try {
            //if the context does not make sense, use the insensitive version
            if (context == null || context.srcStmt() == null)
                return getPTSetContextIns(val);

            if (ptsProvider.getInternalEdgeFromSootEdge(context) == null) {
                //System.out.println("Edge not in geo: " + context);
                return getPTSetContextIns(val);
            }

            final Set<AllocNode> allocNodes = new HashSet<AllocNode>();
            PointsToSetInternal pts = null;

            if (val instanceof InstanceFieldRef) {
                InstanceFieldRef ifr = (InstanceFieldRef)val;
                pts = (PointsToSetInternal)ptsProvider.reachingObjects(context.srcStmt(), 
                    (Local)ifr.getBase(), ifr.getField());
            } else if (val instanceof ArrayRef) {
                ArrayRef arrayRef = (ArrayRef)val;

                PointsToSet baseSet = ptsProvider.reachingObjects(context.srcStmt(), 
                    (Local) arrayRef.getBase());

                pts = (PointsToSetInternal)ptsProvider.reachingObjectsOfArrayElement(baseSet);
            } else if (val instanceof Local) {
                pts = (PointsToSetInternal)ptsProvider.reachingObjects(context.srcStmt(), (Local)val);
            } else if (val instanceof StaticFieldRef) {
                SootField field = ((StaticFieldRef)val).getField();
                pts = (PointsToSetInternal)ptsProvider.reachingObjects(field);
            } else if (val instanceof NullConstant) {
                return allocNodes;
            } else {
                logger.error("Unknown reference type for 1cfa search: {} {}", val, val.getClass());
                droidsafe.main.Main.exit(1);
            }

            //visit internal points to set and grab all allocnodes        
            pts.forall(new P2SetVisitor() {
                public void visit(Node n) {
                    allocNodes.add((AllocNode)n);
                }
            });

            return allocNodes;
        } catch (Exception ee) {
            logger.info("Some error in 1CFA search.  Falling back to insensitive search." , ee);
            return getPTSetContextIns(val);
        }
    }
    
    /**
     * Given a value that is a pointer, and a context edge from the call graph, 
     * return the points to set of allocation nodes that can be pointed to in the
     * context.
     */
    public Set<AllocNode> getPTSetEventContext(Value val, Edge context) {
      // return getPTSetContextIns(val);
      
        if (val instanceof Local) {
            Set<AllocNode> allocNodes = new HashSet<AllocNode>();
            LocalVarNode vn = ptsProvider.findLocalVarNode((Local)val);
            objFull.prepare();
            
            if (vn != null && vn.getMethod() != null && getAllReachableMethods().contains(vn.getMethod()) && 
                    queries.contexsByAnyCallEdge(context, (Local)val, objFull) ) {
                objFull.finish();
            } else {
                return getPTSetContextIns(val);
            }
            for ( IntervalContextVar icv : objFull.icvList ) {
                allocNodes.add((AllocNode)icv.var);
            }
            
            return allocNodes;
        } else if (val instanceof InstanceFieldRef && ((InstanceFieldRef)val).getBase() instanceof Local) {
            Set<AllocNode> allocNodes = new HashSet<AllocNode>();
            InstanceFieldRef ifr = (InstanceFieldRef) val;
            Local base = (Local)ifr.getBase();
            
            LocalVarNode vn = ptsProvider.findLocalVarNode(base);
            objFull.prepare();
            
            if (vn != null && vn.getMethod() != null && getAllReachableMethods().contains(vn.getMethod()) && 
                    queries.contextsByAnyCallEdge(context, base, ifr.getField(), objFull) ) {
                objFull.finish();
            } else {
                return getPTSetContextIns(val);
            }
            for ( IntervalContextVar icv : objFull.icvList ) {
                allocNodes.add((AllocNode)icv.var);
            }
            
            return allocNodes;
        } else if (val instanceof ArrayRef && ((ArrayRef)val).getBase() instanceof Local) {
            Set<AllocNode> allocNodes = new HashSet<AllocNode>();
            ArrayRef ifr = (ArrayRef) val;
            Local base = (Local)ifr.getBase();
            
            LocalVarNode vn = ptsProvider.findLocalVarNode(base);
            objFull.prepare();
            
            if (vn != null && vn.getMethod() != null && getAllReachableMethods().contains(vn.getMethod()) && 
                    queries.contextsByAnyCallEdge(context, base, ArrayElement.v(), objFull) ) {
                objFull.finish();
            } else {
                return getPTSetContextIns(val);
            }
            for ( IntervalContextVar icv : objFull.icvList ) {
                allocNodes.add((AllocNode)icv.var);
            }
            
            return allocNodes;
        }
        else {
            return getPTSetContextIns(val);
        }
    }
    
    /**
     * Content Insensitive query of field reference with allocnode and field. 
     */
    public Set<AllocNode> getPTSetContextIns(AllocNode node, SootField field) {
        final Set<AllocNode> allocNodes = new HashSet<AllocNode>();

        PointsToSetInternal pts = (PointsToSetInternal)ptsProvider.reachingObjects(node, field);

        //visit internal points to set and grab all allocnodes        
        pts.forall(new P2SetVisitor() {
            public void visit(Node n) {
                allocNodes.add((AllocNode)n);
            }
        });

        return allocNodes;
    }
    
    /**
     * Given a pointer value, return the context insensitive points to set.
     */
    public Set<AllocNode> getPTSetContextIns(Value val) {
               
        final Set<AllocNode> allocNodes = new HashSet<AllocNode>();
        PointsToSetInternal pts = null;
        
        try {
            //for an instance field ref, we first have to perform a search of alloc nodes for the
            //base, then for each base, on the field
            if (val instanceof InstanceFieldRef) {
                InstanceFieldRef ifr = (InstanceFieldRef)val;
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

    /**
     * Given an invoke expression, resolve the targets of the method.  Perform a pta virtual method resolution
     * for instance invokes, and use an insensitive search.
     */
    public Collection<SootMethod> resolveInvokeContextIns(InvokeExpr invoke) 
        throws CannotFindMethodException {
        if (invoke instanceof StaticInvokeExpr) {
            Set<SootMethod> ret = new HashSet<SootMethod>();
            ret.add(((StaticInvokeExpr)invoke).getMethod());
            return ret;
        } else if (invoke instanceof DynamicInvokeExpr) {
            logger.error("Should not see dynamic invoke expr: {}", invoke);
            droidsafe.main.Main.exit(1);
        } else if (invoke instanceof InstanceInvokeExpr) {
            return resolveInstanceInvokeContextIns((InstanceInvokeExpr)invoke);
        }
        
        return Collections.emptySet();
    }
    
    /**
     * Given an invoke expression, resolve the targets of the method.  Perform a pta virtual method resolution
     * for instance invokes, and use an event context search.
     */
    public Collection<SootMethod> resolveInvokeEventContext(InvokeExpr invoke, Edge context) 
            throws CannotFindMethodException {
        if (invoke instanceof StaticInvokeExpr) {
            Set<SootMethod> ret = new HashSet<SootMethod>();
            ret.add(((StaticInvokeExpr)invoke).getMethod());
            return ret;
        } else if (invoke instanceof DynamicInvokeExpr) {
            logger.error("Should not see dynamic invoke expr: {}", invoke);
            droidsafe.main.Main.exit(1);
        } else if (invoke instanceof InstanceInvokeExpr) {
            return resolveInstanceInvokeEventContext((InstanceInvokeExpr)invoke, context);
        }
        
        return Collections.emptySet();
    }
    
    /**
     * Given an invoke expression, resolve the targets of the method.  Perform a pta virtual method resolution
     * for instance invokes, and use a 1cfa search.
     */
    public Collection<SootMethod> resolveInvoke1CFA(InvokeExpr invoke, Edge context) 
            throws CannotFindMethodException {
        if (invoke instanceof StaticInvokeExpr) {
            Set<SootMethod> ret = new HashSet<SootMethod>();
            ret.add(((StaticInvokeExpr)invoke).getMethod());
            return ret;
        } else if (invoke instanceof DynamicInvokeExpr) {
            logger.error("Should not see dynamic invoke expr: {}", invoke);
            droidsafe.main.Main.exit(1);
        } else if (invoke instanceof InstanceInvokeExpr) {
            return resolveInstanceInvokeMap1CFA((InstanceInvokeExpr)invoke, context).values();
        }
        
        return Collections.emptySet();
    }
    
    /**
     * Use the PTA to resolve the set of methods that an instance invoke could call.  In this
     * version, use the context insensitive PTA result.
     * 
     * If the method cannot be found, then throw a specialized exception.
     */
    public Collection<SootMethod> resolveInstanceInvokeContextIns(InstanceInvokeExpr invoke) 
            throws CannotFindMethodException {
        return resolveInstanceInvokeMapContextIns(invoke).values();
    }

    /**
     * Use the PTA to resolve the set of method that an instance invoke could call.  In this 
     * version, use the context insensitive result.  Return a map of each alloc node to its
     * target method.
     */
    public Map<AllocNode,SootMethod> resolveInstanceInvokeMapContextIns(InstanceInvokeExpr invoke) 
        throws CannotFindMethodException {
        return resolveInstanceInvokeMap1CFA(invoke, null);
    }
    
    /**
     * Use the PTA to resolve the set of method that an instance invoke could call.  In this 
     * version, use the 1cfa context result.  Return a map of each alloc node to its
     * target method.
     */
    public Map<AllocNode,SootMethod> resolveInstanceInvokeMap1CFA(InstanceInvokeExpr invoke, Edge context) 
        throws CannotFindMethodException {
        Set<AllocNode> allocs = null;
        //get either the context sensitive or insensitive result based on the context param 
        if (context == null) 
            allocs = getPTSetContextIns(invoke.getBase());
        else
            allocs = getPTSet1CFA(invoke.getBase(), context);
        
        return internalResolveInstanceInvokeMap(allocs, invoke, context);
    }
    
    /**
     * 
     */
    private Map<AllocNode, SootMethod> internalResolveInstanceInvokeMap(Set<AllocNode> allocs, 
        InstanceInvokeExpr invoke, Edge context) throws CannotFindMethodException {
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
    
    /**
     * Use the PTA to resolve the set of methods that an instance invoke could call.  Use the 
     * parameter edge as the context to query the context sensitive PTA result for the receiver.
     * Return a map of the allocnode to the resolved method.
     * 
     * If the method cannot be found, then throw a specialized exception.
     */
    public Map<AllocNode, SootMethod> resolveInstanceInvokeMapEventContext(InstanceInvokeExpr invoke, Edge context) 
            throws CannotFindMethodException {
        Set<AllocNode> allocs = null;
        //get either the context sensitive or insensitive result based on the context param 
        if (context == null) 
            allocs = getPTSetContextIns(invoke.getBase());
        else
            allocs = getPTSetEventContext(invoke.getBase(), context);
        
        return internalResolveInstanceInvokeMap(allocs, invoke, context);
    }
    

    /**
     * Use the PTA to resolve the set of methods that an instance invoke could call.  Use the 
     * parameter edge as the context to query the context sensitive PTA result for the receiver.
     * 
     * If the method cannot be found, then throw a specialized exception.
     */
    public Collection<SootMethod> resolveInstanceInvokeEventContext(InstanceInvokeExpr invoke, Edge context) 
            throws CannotFindMethodException {
       return resolveInstanceInvokeMapEventContext(invoke, context).values();
    }
    
    /**
     * The Geometric PTA has its own internal call graph edge IR that mirrors the soot call graph edge.
     * Use this method to retrieve the internal geo call graph edge from a soot edge.
     */
    public CgEdge getInternalEdgeFromSootEdge(Edge edge) {
        return ptsProvider.getInternalEdgeFromSootEdge(edge);
    }

    /**
     * Dump the PTA to system.out.
     */
    public void dumpPTA() {
        dumpPTA(System.out);
    }

    /**
     * Dump the pta to a give file name.
     */
    public void dumpPTA(String fileName) {
        try {
            dumpPTA(new PrintStream(fileName));
        }
        catch (FileNotFoundException e) {

        }
    }

    /** 
     * Given a specific context, a soot edge, dump the pta analysis results only for that context (but
     * considering all references in the program).
     */
    public void dumpPTAForContext(PrintStream file, Edge sootContext) {
        file.printf("== dumpPTA for %s ==\n", sootContext);

        CgEdge context = ptsProvider.getInternalEdgeFromSootEdge(sootContext);

        for ( IVarAbstraction pn : ptsProvider.pointers ) {
            IVarAbstraction orig = pn;
            pn = pn.getRepresentative();
            Node val = pn.getWrappedNode();

            if ( val instanceof LocalVarNode ) {
                // We map the local pointer to its 1-cfa versions
                LocalVarNode lvn = (LocalVarNode)val;
                SootMethod sm = lvn.getMethod();

                long l = context.map_offset;
                long r = l + ptsProvider.max_context_size_block[context.s];


                file.printf("%s: %s \n", sm, val);

                Obj_1cfa_extractor contextObjsVisitor = new Obj_1cfa_extractor();
                pn.get_all_context_sensitive_objects(l, r, contextObjsVisitor);

                for ( CallsiteContextVar cobj : contextObjsVisitor.outList ) {
                    //cobj.inQ = false;
                    if (cobj != null && cobj.var != null)
                        file.printf( "%s: %s\n", cobj.var.getClass(), cobj.var);
                    else 
                        file.printf( "%s: %s\n", cobj, "No Var");
                }
            }  else {
                Obj_1cfa_extractor contextObjsVisitor = new Obj_1cfa_extractor();
                pn.get_all_context_sensitive_objects(1, soot.jimple.spark.geom.geomPA.Constants.MAX_CONTEXTS, 
                    contextObjsVisitor);

                for ( CallsiteContextVar cobj : contextObjsVisitor.outList ) {
                    //cobj.inQ = false;
                    if (cobj != null)
                        file.print( " " + cobj.getNumber() );
                }
                file.println();
            }
            file.println();
        }
        file.print("======================= dumpPTA () Done =====================================\n");
    }

    private void testField(final PrintStream file) {
        for ( SootMethod sm : ptsProvider.getAllReachableMethods() ) {
            //          if (sm.isJavaLibraryMethod())
            //              continue;
            if (!sm.isConcrete())
                continue;
            if (!sm.hasActiveBody()) {
                sm.retrieveActiveBody();
            }
            if ( !ptsProvider.isValidMethod(sm) )
                continue;


            // We first gather all the memory access expressions
            for (Iterator stmts = sm.getActiveBody().getUnits().iterator(); stmts.hasNext();) {
                Stmt st = (Stmt) stmts.next();

                if ( !(st instanceof AssignStmt) ) continue;

                AssignStmt a = (AssignStmt) st;
                final Value lValue = a.getLeftOp();
                final Value rValue = a.getRightOp();

                InstanceFieldRef ifr = null;

                if (lValue instanceof InstanceFieldRef) {
                    // Def statement
                    ifr = (InstanceFieldRef)lValue;
                }
                else if ( rValue instanceof InstanceFieldRef ) {
                    // Use statement
                    ifr = (InstanceFieldRef)rValue;
                }

                if (ifr != null) {
                    file.println(sm);
                    file.println(st);
                    file.println(ifr);
                    
                    final SootField field = ifr.getField();

                    LocalVarNode vn = ptsProvider.findLocalVarNode((Local) ifr.getBase());
                    if ( vn == null ) continue;
                    
                    // Spark
                    vn.getP2Set().forall(new P2SetVisitor() {
                        
                        @Override
                        public void visit(Node n) {
                            PointsToSetInternal pts = (PointsToSetInternal)ptsProvider.reachingObjects((AllocNode)n, field);
                            pts.forall(new P2SetVisitor() {
                                @Override
                                public void visit(Node n) {
                                    file.println(" Visitor: " + n);
                                }
                            });
                        }
                    });
                }
                file.println();
            }
        }
    }
    
    /**
     * Print out all points to sets.
     */
    public void dumpPTA(final PrintStream file) {

        file.print("======================= dumpPTA ()=====================================\n");
        //Vector<CallsiteContextVar> outList = new Vector<CallsiteContextVar>();
        for ( IVarAbstraction pn : ptsProvider.pointers ) {
            IVarAbstraction orig = pn;
            pn = pn.getRepresentative();
            Node val = pn.getWrappedNode();


            int method = ptsProvider.getMappedMethodID(val);
            SootMethod pointerMethod = ptsProvider.getSootMethodFromID(method);

            //System.out.println(pn);

            file.println(val);

            if (pn.getWrappedNode() != orig.getWrappedNode())
                file.println("Original: " + orig.getWrappedNode());

            if ( val instanceof LocalVarNode ) {
                // We map the local pointer to its 1-cfa versions
                LocalVarNode lvn = (LocalVarNode)val;
                SootMethod sm = lvn.getMethod();
                int sm_int = ptsProvider.getIDFromSootMethod(sm);
                LinkedList<CgEdge> edges = ptsProvider.getCallEdgesInto(sm_int);

                for ( Iterator<CgEdge> it = edges.iterator(); it.hasNext(); ) {
                    CgEdge p = it.next();
                    if (p.sootEdge == null)
                        continue;

                    long l = p.map_offset;
                    long r = l + ptsProvider.max_context_size_block[p.s];


                    file.printf("%s (%s)->\n %s %s\n", p.sootEdge.getSrc(), p.sootEdge.srcUnit(), 
                        p.sootEdge.getTgt(), p.sootEdge.hashCode());

                    Obj_1cfa_extractor contextObjsVisitor = new Obj_1cfa_extractor();
                    pn.get_all_context_sensitive_objects(l, r, contextObjsVisitor);

                    for ( CallsiteContextVar cobj : contextObjsVisitor.outList ) {
                        //cobj.inQ = false;
                        if (cobj != null && cobj.var != null)
                            file.printf( "%s: %s %s\n", cobj.var.getClass(), cobj.var, cobj.var.hashCode());
                        else 
                            file.printf( "%s: %s\n", cobj, "No Var");
                    }

                }
            }
            else {
                if (val instanceof AllocDotField) {
                    
                    AllocDotField adf = (AllocDotField)val;
                    file.printf("\tAlloc dot field: %s %s\n", adf.getBase(), adf.getField());
                    Set<AllocNode> allocNodes = pn.get_all_points_to_objects();
                    for (AllocNode node : allocNodes) {
                        file.println(" " + node);
                    }
                   
                    adf.getP2Set().forall(new P2SetVisitor() {
                        @Override
                        public void visit(Node n) {
                            file.printf(" Visitor: " + n);
                        }
                    });
                } 
                Obj_1cfa_extractor contextObjsVisitor = new Obj_1cfa_extractor();
                pn.get_all_context_sensitive_objects(1, 
                    soot.jimple.spark.geom.geomPA.Constants.MAX_CONTEXTS, contextObjsVisitor);

                for ( CallsiteContextVar cobj : contextObjsVisitor.outList ) {
                    //cobj.inQ = false;
                    if (cobj != null)
                        file.println( " " + cobj.var );
                }
                file.println();
            }

            file.println();
        }
        file.print("======================= dumpPTA () Done =====================================\n");
        testField(file);
    }

    /**
     * Run the geometric context sensitive PTA.
     */
    static void setGeomPointsToAnalysis() {
        logger.info("[GeomPTA] Starting analysis ...");

        HashMap<String, String> opt = new HashMap<String, String>();
        opt.put("geom-pta","true");
        opt.put("geom-encoding", "geom");
        opt.put("geom-worklist", "PQ");
        opt.put("geom-eval", "0");
        opt.put("geom-trans", "false");
        opt.put("geom-frac-base", "40");
        opt.put("geom-blocking", "true");
        opt.put("geom-runs", "1");
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

        SparkTransformer.v().transform("",opt);

        logger.info("[GeomPTA] Done!");
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
        opt.put("cs-demand", "true");
        opt.put("lazy-pts", "true");
        opt.put("passes", "10");
        opt.put("traversal", "75000");

        SparkTransformer.v().transform("",opt);


        logger.info("[spark] Done!");
    }

    /**
     * Dump a dot representation of the call graph to the given file.  
     */
    public void dumpCallGraph(String fileStr) {
        FileWriter fw;
        try {
            fw = new FileWriter(fileStr);

            fw.write("digraph CallGraph {\n");

            //get the harness main and all the edges in the call graph
            //from it, and for each edge to an entry point, create and populate
            //the rCFG node
            Set<Edge> edges = getAllCallGraphEdges();
            //Set<SootMethod> visitedMethods = new LinkedHashSet<SootMethod>();
            Map<SootMethod, Set<SootMethod>> visitedEdges = new HashMap<SootMethod, Set<SootMethod>>();
            Map<String, Set<SootMethod>> packageSubgraphs = new HashMap<String, Set<SootMethod>>();

            for (Edge edge : edges) {
                if (!visitedEdges.containsKey(edge.src()))
                    visitedEdges.put(edge.src(), new HashSet<SootMethod>());

                if (!visitedEdges.get(edge.src()).contains(edge.tgt())) {
                    fw.write(edge.src().hashCode() + "->" + edge.tgt().hashCode() + ";\n");
                    visitedEdges.get(edge.src()).add(edge.tgt());
                }

                String srcPackage = edge.src().getDeclaringClass().getJavaPackageName();
                if (srcPackage == null || srcPackage.equals("")) 
                    srcPackage = "No.Package"; 

                if (!packageSubgraphs.containsKey(srcPackage)) {
                    packageSubgraphs.put(srcPackage, new HashSet<SootMethod>());
                }
                packageSubgraphs.get(srcPackage).add(edge.src());

                String tgtPackage = edge.tgt().getDeclaringClass().getJavaPackageName();
                if (tgtPackage == null || tgtPackage.equals("")) 
                    tgtPackage = "No.Package"; 
                if (!packageSubgraphs.containsKey(tgtPackage)) {
                    packageSubgraphs.put(tgtPackage, new HashSet<SootMethod>());
                }
                packageSubgraphs.get(tgtPackage).add(edge.tgt());

            }

            for (String pack : packageSubgraphs.keySet()) {

                fw.write("subgraph " + pack.replace('.', '_') + "{\n");
                fw.write("label = \"" + pack + "\";\n");
                fw.write("color=blue;\n");
                for (SootMethod m : packageSubgraphs.get(pack)) {
                    fw.write(getMethodDotLabel(m));
                }
                fw.write("}\n");
            }

            fw.write("}");
            fw.close();
        } catch (IOException e) {
            logger.error("Error writing call graph dot file");
            droidsafe.main.Main.exit(1);
        }
    }

    /**
     * Return dot label for methods for dot call graph generation.
     */
    private String getMethodDotLabel(SootMethod m) {
        StringBuffer buf = new StringBuffer();
        buf.append(m.hashCode() + " [label=\"");
        buf.append(m.getDeclaringClass() + "\\n");
        buf.append(m.getSubSignature() + "\"");
        if (m.isNative())
            buf.append(",color=red,style=filled");
        buf.append("];\n");
        return buf.toString();
    }

    /**
     * Return a set of all SootEdges of the call graph that the context sensitive
     * has not obsoleted.  
     */
    public Set<Edge> getAllCallGraphEdges() {
        Set<Edge> allCSEdges = new LinkedHashSet<Edge>();
        int n_func = ptsProvider.n_func;

        for (int i = 0; i < n_func; ++i) {
            if ( !ptsProvider.isReachableMethod(i) )
                continue;

            CgEdge p = ptsProvider.getCallEgesOutFrom(i);
            while (p != null) {
                if ( p.sootEdge != null ) {
                    allCSEdges.add(p.sootEdge);
                }
                p = p.next;
            }
        }
        return allCSEdges;
    }
    
    /**
     * Return the source location tag for an allocation node.
     */
    public SourceLocationTag getSourceTag(AllocNode node) {
        Object newObject = getNewExpr(node);
        
        if (! (newObject instanceof Expr)) {
            return null;
        }
        
        Expr newExpr = (Expr)newObject;
        
        Stmt stmt = JimpleRelationships.v().getEnclosingStmt(newExpr);
        
        return SootUtils.getSourceLocation(stmt, 
            JimpleRelationships.v().getEnclosingMethod(stmt).getDeclaringClass()); 
    }
}
