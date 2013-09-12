package droidsafe.analyses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
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
import soot.jimple.Expr;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.NewExpr;
import soot.jimple.NullConstant;
import soot.jimple.StaticFieldRef;
import soot.jimple.Stmt;
import soot.jimple.spark.SparkTransformer;
import soot.jimple.spark.geom.dataRep.CallsiteContextVar;
import soot.jimple.spark.geom.dataRep.IntervalContextVar;
import soot.jimple.spark.geom.geomE.FullSensitiveNode;
import soot.jimple.spark.geom.geomPA.CgEdge;
import soot.jimple.spark.geom.geomPA.GeomPointsTo;
import soot.jimple.spark.geom.geomPA.IVarAbstraction;
import soot.jimple.spark.geom.helper.ContextTranslator;
import soot.jimple.spark.geom.helper.Obj_1cfa_extractor;
import soot.jimple.spark.geom.helper.Obj_full_extractor;
import soot.jimple.spark.pag.AllocDotField;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.ArrayElement;
import soot.jimple.spark.pag.ContextVarNode;
import soot.jimple.spark.pag.GlobalVarNode;
import soot.jimple.spark.pag.LocalVarNode;
import soot.jimple.spark.pag.MethodPAG;
import soot.jimple.spark.pag.Node;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.options.PaddleOptions;
import soot.jimple.ArrayRef;
import soot.jimple.FieldRef;
import soot.jimple.spark.pag.FieldRefNode;
import soot.jimple.spark.sets.EmptyPointsToSet;
import soot.jimple.spark.sets.P2SetVisitor;
import soot.jimple.spark.sets.PointsToSetInternal;

import com.google.common.collect.HashBiMap;

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
        Scene.v().loadDynamicClasses();

        setGeomPointsToAnalysis();


        v = new GeoPTA();
    }

    /**
     * Private constructor.
     */
    private GeoPTA() {
        ptsProvider = (GeomPointsTo)Scene.v().getPointsToAnalysis();
        //ContextTranslator.build_1cfa_map(ptsProvider);
        callGraph = Scene.v().getCallGraph();
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
    public Set<Type> getTypes(Value val, Edge context) {
        Set<Type> types = new LinkedHashSet<Type>();

        for (AllocNode node : getPTSet(val, context)) {
            types.add(node.getType());
        }

        return types;
    }

    /**
     * Perform a context sensitive search of the PTA result for an instance field.  First
     * search for base reference and then for each object pointed to by base, search the field reference.
     */
    private Set<AllocNode> getPTSet(Local local, SootField field, Edge context) {
        final Set<AllocNode> allocNodes = new LinkedHashSet<AllocNode>();
        
        if (!(field.getType() instanceof RefLikeType)) {
            logger.error("Querying PTA for instance field that is not a reference type: {}.{}", local, field);
            droidsafe.main.Main.exit(1);
        }
        
        PointsToSetInternal reachingObj = (PointsToSetInternal)
                ptsProvider.reachingObjects(context.srcStmt(), local, field);
        
        reachingObj.forall(new P2SetVisitor() {
            public void visit(Node n) {
                allocNodes.add((AllocNode)n);
            }
        });
        
        return allocNodes;
        
        
        /*
        final SootField field = val.getField();
        
        LocalVarNode vn = ptsProvider.findLocalVarNode((Local) val.getBase());
        
        IVarAbstraction ivar = ptsProvider.findInternalNode(vn);
        
        if ( ivar == null ) {
            return allocNodes;
        }
        
        CgEdge cgEdge = ptsProvider.getInternalEdgeFromSootEdge(context);

        Set<AllocNode> baseNodes = getGlobalorLocalPTSet(vn, ivar, context, val);

        for (AllocNode baseNode : baseNodes) {
            IVarAbstraction padf = ptsProvider.findAndInsertInstanceField(baseNode, field);
            padf = padf.getRepresentative();
            
            if (padf instanceof FullSensitiveNode && ((FullSensitiveNode)padf).pt_objs == null) 
                continue;
            
            //TODO: Is this correct???
            if (cgEdge == null) {
                allocNodes.addAll(padf.get_all_points_to_objects());
            } else {
                long l = cgEdge.map_offset;
                long r = l + ptsProvider.max_context_size_block[cgEdge.s];
                
                Obj_full_extractor contextObjsVisitor = new Obj_full_extractor();
                contextObjsVisitor.prepare();
                padf.get_all_context_sensitive_objects(l, r, contextObjsVisitor);
                contextObjsVisitor.finish();

                for (IntervalContextVar icv : contextObjsVisitor.icvList) {
                    //check here is the CCV is null because in the underlying analysis, it 
                    //sometimes adds nulls to the context search, don't know why but 
                    //only seems to happen in rare circumstances, might need to investigate more.
                    if (icv != null) {    
                        allocNodes.add((AllocNode)icv.var);
                    } else {
                        logger.info("Null callsite context var found during PTA search (continuing): {} in {}", 
                            val, context);
                    }
                }
            }
        }

        
        return allocNodes;
        */
    }

    private Set<AllocNode> getArrayRefPTSet(ArrayRef val, Edge context) {
        Set<AllocNode> allocNodes = new LinkedHashSet<AllocNode>();
        
        LocalVarNode vn = ptsProvider.findLocalVarNode((Local) val.getBase());
        
        IVarAbstraction ivar = ptsProvider.findInternalNode(vn);
        
        if ( ivar == null ) {
            return allocNodes;
        }

        Set<AllocNode> baseNodes = getGlobalorLocalPTSet(vn, ivar, context, val);

        for (AllocNode baseNode : baseNodes) {
            IVarAbstraction padf = ptsProvider.findAndInsertInstanceField(baseNode, ArrayElement.v());
            allocNodes.addAll(padf.get_all_points_to_objects());
        }

        return allocNodes;
    }
    
    
    private Set<AllocNode> getPTSet(SootField field) {
        final Set<AllocNode> allocNodes = new LinkedHashSet<AllocNode>();
        
        PointsToSetInternal pti = (PointsToSetInternal)ptsProvider.reachingObjects(field);
        
        pti.forall(new P2SetVisitor() {
            public void visit(Node n) {
                allocNodes.add((AllocNode)n);
            }
        });
        
        return allocNodes;
    }
    
    private Set<AllocNode> getPTSet(Local local, Edge context) {
        final Set<AllocNode> allocNodes = new LinkedHashSet<AllocNode>();

        Context c = context.srcStmt();
        LocalVarNode vn = ptsProvider.findLocalVarNode(local);
       
        
        // We first lookup the cache
        ContextVarNode cvn = vn.context(c);
      /*  if ( cvn != null ) {
            return cvn.getP2Set();
        }*/
        
        cvn = ptsProvider.makeContextVarNode(vn, c);            // The points-to vector is set to empty at start
       
        
        // Otherwise we create a new points-to vector
        IVarAbstraction pn = ptsProvider.consG.get(vn);
        pn = pn.getRepresentative();
        if ( pn == null ) {
            // The enclosing method of this pointer is obsoleted
            return EMPTY_PTA_SET;
        }
        

        
        CgEdge myEdge = ptsProvider.getInternalEdgeFromSootEdge(context);
        //System.out.println("Geometry: " + myEdge.map_offset + " " + ptsProvider.max_context_size_block[myEdge.s]);
        long low = myEdge.map_offset;
        long high = low + ptsProvider.max_context_size_block[myEdge.s];
        
        PointsToSetInternal ptset = cvn.makeP2Set();
        
        for ( AllocNode an : pn.get_all_points_to_objects() ) {
            if ( pn.pointer_interval_points_to(low, high, an) ) {
                ptset.add(an);
                allocNodes.add(an);
            }
        }
        
        return allocNodes;
    }
    
    /**
     * Perform a context sensitive search on a given global or local that does not require a 
     * search of a base value.
     */
    private Set<AllocNode> getGlobalorLocalPTSet(Node sparkNode, IVarAbstraction ivar, Edge context, Value val) {
        Set<AllocNode> allocNodes = new LinkedHashSet<AllocNode>();

        try {
            if (context == null) {
                logger.error("Null context edge for pta query.");
                droidsafe.main.Main.exit(1);
            }

            if (ivar == null) { 
                logger.error("Error getting internal PTA node for {} of {}.", ivar);
                droidsafe.main.Main.exit(1);
            }

            //don't really know why this is needed, sometimes maybe the internal analysis
            //delegates some nodes
            ivar = ivar.getRepresentative();
            CgEdge cgEdge = ptsProvider.getInternalEdgeFromSootEdge(context);
            //System.out.println("  Geo Context: " + context + " " + cgEdge);
            if (cgEdge == null) {
                //static initializer, no call edge, return context insenstive pta set
                allocNodes = ivar.get_all_points_to_objects();
            } else {
                //not a static initializer, regular call
                if (sparkNode != null) {
                    long l = cgEdge.map_offset;
                    long r = l + ptsProvider.max_context_size_block[cgEdge.s];
                    System.out.println("  L: " + l + ", R: " + r);
    
                    Obj_full_extractor contextObjsVisitor = new Obj_full_extractor();
                    contextObjsVisitor.prepare();
                    ivar.get_all_context_sensitive_objects(l, r, contextObjsVisitor);
                    contextObjsVisitor.finish();

                    for (IntervalContextVar icv : contextObjsVisitor.icvList) {
                        //check here is the CCV is null because in the underlying analysis, it 
                        //sometimes adds nulls to the context search, don't know why but 
                        //only seems to happen in rare circumstances, might need to investigate more.
                        if (icv != null) {    
                            System.out.println("  Added L: " + icv.L + ", R: " + icv.R);
                            allocNodes.add((AllocNode)icv.var);
                        } else {
                            logger.info("Null callsite context var found during PTA search (continuing): {} in {}", 
                                val, context);
                        }
                    }
                
                } else {
                    logger.info("Null sparkNode for ivar query: {} in {}", ivar, context);
                } 
                
                if (allocNodes.isEmpty()) {
                    logger.debug("empty getPTSet query: v {} (ivar {}) with context {}.", val, ivar, context);
                }
            }
        } catch (Exception e) {
            logger.info("Some sort of error getting points to set for {} in {}", val, context, e);
        }
        return allocNodes;
    }

    /**
     * Given a value that is a pointer, and a context edge from the call graph, 
     * return the points to set of allocation nodes that can be pointed to in the
     * context.
     */
    public Set<AllocNode> getPTSet(Value val, Edge context) {
        //until we fix the full context search, we return the insensitive result
        return getPTSetContextIns(val);
        /*
        //logger.info("Querying pt set for: {} in {}", v, context);
        
        //if the context does not make sense, use the insensitive version
        if (context == null || context.srcUnit() == null)
            return getPTSetContextIns(val);
        
        //handle instance field refs and arrays specially, need to find base and then field
        if (val instanceof InstanceFieldRef) {
            InstanceFieldRef ifr = (InstanceFieldRef) val;
            return getPTSet((Local)ifr.getBase(), ifr.getField(), context);
        } else if (val instanceof ArrayRef) {
            return getArrayRefPTSet((ArrayRef)val, context);
        }
            
        //single search
        Node node = null;
        if (val instanceof Local) {
            return getPTSet((Local)val, context);
            //node = ptsProvider.findLocalVarNode(val);
        } else if (val instanceof StaticFieldRef) {
           SootField field = ((FieldRef)val).getField();
           return getPTSet(field);
           //node = ptsProvider.findGlobalVarNode(field);                    
        } 
        
        logger.error("Unknown value for PTA query: {}", val);
        droidsafe.main.Main.exit(1);
        return EMPTY_PTA_SET;
         */
        
        /*
        if (node == null) {
            logger.info("Cannot find spark node for: {} {}", val, val.getClass());
            return EMPTY_PTA_SET;
        }
        
        IVarAbstraction internalNode = ptsProvider.findInternalNode(node);
        if (internalNode == null) {
            logger.info("Cannot find internal geom node for value: {}", val); 
            return EMPTY_PTA_SET;
        }
        
        Node sparkNode = internalNode.getWrappedNode();

        return getGlobalorLocalPTSet(sparkNode, internalNode, context, val);
        */
    }

    /**
     * Perform a context ins search for a field given a base node.
     */
    public Set<AllocNode> getPTSetContextIns(AllocNode baseNode, SootField field) {
        Set<AllocNode> allocNodes = new LinkedHashSet<AllocNode>();
        
        if (!(field.getType() instanceof RefLikeType)) {
            logger.error("Querying PTA on a field that is not a reference");
            droidsafe.main.Main.exit(1);
        }
        
        IVarAbstraction fieldVar = ptsProvider.findAndInsertInstanceField(baseNode, field);
        //fieldVar = fieldVar.getRepresentative();
        Set<AllocNode> fromPTA = fieldVar.get_all_points_to_objects();
        allocNodes.addAll(fromPTA);
        
        return allocNodes;
    }
    
    private Set<AllocNode> getPTSetContextIns(Local local, SootField field) {
        final Set<AllocNode> allocNodes = new LinkedHashSet<AllocNode>();
        
        PointsToSetInternal ptsi = (PointsToSetInternal)ptsProvider.reachingObjects(local, field);
        
        ptsi.forall(new P2SetVisitor() {
            public void visit(Node node) {
                allocNodes.add((AllocNode)node);
            }
        });
        
        return allocNodes;
    }
    
    /**
     * Given a pointer value, return the context insensitive points to set.
     */
    public Set<AllocNode> getPTSetContextIns(Value val) {
        final Set<AllocNode> allocNodes = new LinkedHashSet<AllocNode>();
        
        if (!isPointer(val))
            return allocNodes;
        
        try {
            //for an instance field ref, we first have to perform a search of alloc nodes for the
            //base, then for each base, on the field
            if (val instanceof InstanceFieldRef) {
                InstanceFieldRef ifr = (InstanceFieldRef)val;
                return getPTSetContextIns((Local)ifr.getBase(), ifr.getField()); 
                /*
                Set<AllocNode> baseNodes = getPTSetContextIns(((InstanceFieldRef)val).getBase());
                SootField field = ((InstanceFieldRef)val).getField();
                for (AllocNode baseNode : baseNodes) {
                    allocNodes.addAll(getPTSetContextIns(baseNode, field));
                } 
                */               
            } else if (val instanceof ArrayRef) {
                Set<AllocNode> baseNodes = getPTSetContextIns(((ArrayRef)val).getBase());
                for (AllocNode baseNode : baseNodes) {
                    IVarAbstraction fieldVar = ptsProvider.findAndInsertInstanceField(baseNode, ArrayElement.v());
                    Set<AllocNode> fromPTA = fieldVar.get_all_points_to_objects();
                    allocNodes.addAll(fromPTA);
                }
            } else {            
                IVarAbstraction ivar = getInternalNode(val);
                ivar = ivar.getRepresentative();

                Set<AllocNode> fromPTA = ivar.get_all_points_to_objects();
                if (fromPTA != null)
                    allocNodes.addAll(fromPTA);
            }
            
        } catch (Exception e) {
            logger.info("Some sort of error getting context insensitive points to set for {}", val);
            //e.printStackTrace();
        }

        return allocNodes;
    }

    /**
     * Use the PTA to resolve the set of methods that an instance invoke could call.  In this
     * version, use the context insensitive PTA result.
     * 
     * If the method cannot be found, then throw a specialized exception.
     */
    public Set<SootMethod> resolveVirtualInvoke(InstanceInvokeExpr invoke) 
            throws CannotFindMethodException {
        return resolveVirtualInvoke(invoke, null);
    }

    /**
     * Use the PTA to resolve the set of methods that an instance invoke could call.  Use the 
     * parameter edge as the context to query the context sensitive PTA result for the receiver.
     * Return a map of the allocnode to the resolved method.
     * 
     * If the method cannot be found, then throw a specialized exception.
     */
    public Map<AllocNode, SootMethod> resolveVirtualInvokeMap(InstanceInvokeExpr invoke, Edge context) 
            throws CannotFindMethodException {
        Map<AllocNode, SootMethod> methods = new LinkedHashMap<AllocNode, SootMethod>();

        Set<AllocNode> allocs = null;
        //get either the context sensitive or insensitive result based on the context param 
        if (context == null) 
            allocs = getPTSetContextIns(invoke.getBase());
        else
            allocs = getPTSet(invoke.getBase(), context);

        //loop over alloc nodes and resolve the concrete dispatch for each, placing in the set
        for (AllocNode an : allocs) {
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
            
        }

        return methods;
    }
    

    /**
     * Use the PTA to resolve the set of methods that an instance invoke could call.  Use the 
     * parameter edge as the context to query the context sensitive PTA result for the receiver.
     * 
     * If the method cannot be found, then throw a specialized exception.
     */
    public Set<SootMethod> resolveVirtualInvoke(InstanceInvokeExpr invoke, Edge context) 
            throws CannotFindMethodException {
        Set<SootMethod> methods = new LinkedHashSet<SootMethod>();

        Set<AllocNode> allocs = null;
        //get either the context sensitive or insensitive result based on the context param 
        if (context == null) 
            allocs = getPTSetContextIns(invoke.getBase());
        else
            allocs = getPTSet(invoke.getBase(), context);

        //loop over alloc nodes and resolve the concrete dispatch for each, placing in the set
        for (AllocNode an : allocs) {
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
            
            methods.add(SootUtils.resolveConcreteDispatch(clz, invoke.getMethod()));
        }

        return methods;
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
