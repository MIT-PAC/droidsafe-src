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
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.AnySubType;
import soot.ArrayType;
import soot.G;
import soot.Local;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.paddle.PaddleTransformer;
import soot.jimple.spark.SparkTransformer;
import soot.jimple.spark.geom.dataRep.CallsiteContextVar;
import soot.jimple.spark.geom.geomPA.CgEdge;
import soot.jimple.spark.geom.geomPA.GeomPointsTo;
import soot.jimple.spark.geom.geomPA.IVarAbstraction;
import soot.jimple.spark.geom.helper.ContextTranslator;
import soot.jimple.spark.geom.helper.Obj_1cfa_extractor;
import soot.jimple.spark.pag.AllocDotField;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.LocalVarNode;
import soot.jimple.spark.pag.MethodPAG;
import soot.jimple.spark.pag.Node;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.options.PaddleOptions;

import com.google.common.collect.HashBiMap;

import droidsafe.android.app.Project;
import droidsafe.main.Config;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;
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
    private final static Logger logger = LoggerFactory.getLogger(GeoPTA.class);
    private GeomPointsTo ptsProvider;
    private CallGraph callGraph;
    /** bimap of new expressions to their alloc node representation */
    private HashBiMap<Object, AllocNode> newToAllocNodeMap;
    private static GeoPTA v;


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

    private GeoPTA() {
        ptsProvider = (GeomPointsTo)Scene.v().getPointsToAnalysis();
        ContextTranslator.build_1cfa_map(ptsProvider);
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
        /*
    		for (IVarAbstraction ivar : ptsProvider.pointers) {
    			if (ivar == null || ivar.get_all_points_to_objects() == null)
    				continue;
    			for (AllocNode an : ivar.get_all_points_to_objects()) {
    				if (!newToAllocNodeMap.containsValue(an)) {
    					newToAllocNodeMap.put(an.getNewExpr(), an);
    				}
    			}
    		}*/

        for (IVarAbstraction ivar : ptsProvider.allocations) {
            //allocations in the pta don't have context and are not pointer
            //they just wrap the underlying allocnode
            AllocNode obj = (AllocNode)ivar.getWrappedNode();
            newToAllocNodeMap.put(obj.getNewExpr(), obj);
            /*
    			if (ivar == null || ivar.get_all_points_to_objects() == null)
    				continue;
    			for (AllocNode an : ivar.get_all_points_to_objects()) {
    				if (!newToAllocNodeMap.containsValue(an)) {
    					newToAllocNodeMap.put(an.getNewExpr(), an);
    				}
    			}
             */
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
    public boolean isPointer(Value v) {
        if (!(v.getType() instanceof RefLikeType)) 
            return false;

        if (v instanceof Local && getInternalNode(v) != null)
            return true;

        //might need more stuff here.

        return false;
    }

    /**
     * Return true if the value is a pointer in the pointer assignment graph.
     */
    public IVarAbstraction getInternalNode(Value v) {
        if (v instanceof Local) {
            LocalVarNode node = ptsProvider.findLocalVarNode(v);
            IVarAbstraction internalNode = ptsProvider.findInternalNode(node);
            return internalNode;
        } else if (v instanceof SootField) {
            Utils.logErrorAndExit(logger, "Unknown type for pointer: {}", v.getClass());
        }

        Utils.logErrorAndExit(logger, "Unknown type for pointer: {}", v.getClass());
        return null;
    }

    /**
     * For a given pointer in the context, return all the types that the objects pointed to 
     * by the pointer can realize.
     */
    public Set<Type> getTypes(Value v, Edge context) {
        Set<Type> types = new LinkedHashSet<Type>();

        for (AllocNode node : getPTSet(v, context)) {
            types.add(node.getType());
        }

        return types;
    }

    /**
     * v used only for error reporting
     */
    private Set<AllocNode> getPTSet(Node sparkNode, IVarAbstraction ivar, Edge context, Value v) {
        Set<AllocNode> allocNodes = new LinkedHashSet<AllocNode>();

        try {
            if (context == null) 
                Utils.logErrorAndExit(logger, "Null context edge for pta query.");


            if (ivar == null) 
                Utils.logErrorAndExit(logger, "Error getting internal PTA node for {} of {}.", ivar);


            //don't really know why this is needed, sometimes maybe the internal analysis
            //delegates some nodes
            ivar = ivar.getRepresentative();
            CgEdge cgEdge = ptsProvider.getInternalEdgeFromSootEdge(context);
            if (cgEdge == null) {
                //static initializer, no call edge, return context insenstive pta set
                allocNodes = ivar.get_all_points_to_objects();
            } else {
                //not a static initializer, regular call
                if (sparkNode instanceof LocalVarNode) {
                    long l = cgEdge.map_offset;
                    long r = l + ptsProvider.max_context_size_block[cgEdge.s];

                    Obj_1cfa_extractor contextObjsVisitor = new Obj_1cfa_extractor();
                    ivar.get_all_context_sensitive_objects(l, r, contextObjsVisitor);

                    for (CallsiteContextVar ccv : contextObjsVisitor.outList) {
                        //this var assignment here seems to denote if the alloc can be included 
                        //in further searches, so once we grab, make sure to say it is no
                        //longer in another queue.
                        //ccv.inQ = false;
                        allocNodes.add((AllocNode)ccv.var);
                    }
                } else if (sparkNode == null) {
                    logger.info("Null sparkNode for ivar query: {} in {}", ivar, context);
                } else {
                    Utils.logErrorAndExit(logger, "Unknown type of spark node for points to query for value v {}, ivar {} spark node {}.", 
                        v, ivar, sparkNode);
                }

                if (allocNodes.isEmpty()) {
                    logger.debug("empty getPTSet query: v {} (ivar {}) with context {}.", v, ivar, context);
                    /*Set<AllocNode> noContext = ivar.get_all_points_to_objects();
    		for (AllocNode node : noContext) {
    			allocNodes.add(node);
    		}*/
                }
            }
        } catch (Exception e) {
            logger.info("Some sort of error getting points to set for {} in {}", v, context.tgt(), e);
        }
        return allocNodes;
    }

    public Set<AllocNode> getPTSet(Node sparkNode, Edge context) {
        IVarAbstraction ivar = ptsProvider.consG.get(sparkNode);
        return getPTSet(sparkNode, ivar, context, null);
    }

    /**
     * Given a value that is a pointer, and a context edge from the call graph, 
     * return the points to set of allocation nodes that can be pointed to in the
     * context.
     */
    public Set<AllocNode> getPTSet(Value v, Edge context) {
        //logger.info("Querying pt set for: {} in {}", v, context);
        IVarAbstraction ivar = getInternalNode(v);
        if (ivar == null) {
            //nothing known about this pointer:
            return new HashSet<AllocNode>();
        }
        Node sparkNode = ivar.getWrappedNode();

        return getPTSet(sparkNode, ivar, context, v);
    }

    /**
     * Given a pointer value, return the context insensitive points to set.
     */
    public Set<AllocNode> getPTSetContextIns(Value v) {
        Set<AllocNode> allocNodes = new LinkedHashSet<AllocNode>();

        if (!isPointer(v))
            return allocNodes;

        try {
            IVarAbstraction ivar = getInternalNode(v);
            Node sparkNode = ivar.getWrappedNode();
            ivar = ivar.getRepresentative();

            Set<AllocNode> fromPTA = ivar.get_all_points_to_objects();
            if (fromPTA != null)
                allocNodes.addAll(fromPTA);

        } catch (Exception e) {
            logger.info("Some sort of error getting context insensitive points to set for {}", v);
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
     * 
     * If the method cannot be found, then throw a specialized exception.
     */
    public Set<SootMethod> resolveVirtualInvoke(InstanceInvokeExpr invoke, Edge context) 
            throws CannotFindMethodException {
        Set<SootMethod> methods = new HashSet<SootMethod>();

        Set<AllocNode> allocs = null;
        //get either the context sensitive or insensitive result based on the context param 
        if (context == null) 
            allocs = getPTSetContextIns(invoke.getBase());
        else
            allocs = getPTSet(invoke.getBase(), context);

        //loop over alloc nodes and resolve the concrete dispatch for each, placing in the set
        for (AllocNode an : allocs) {
            Type t = an.getType();
            //some type that we don't understand, so throw that we cannot find the method
            if ( t instanceof AnySubType ||
                    t instanceof ArrayType ) {
                throw new CannotFindMethodException(t, invoke.getMethod());
            }

            methods.add(SootUtils.resolveConcreteDispatch( ((RefType)t).getSootClass(), 
                invoke.getMethod()));
        }

        return methods;
    }

    public void dumpPTA() {
        dumpPTA(System.out);
    }

    public void dumpPTA(String fileName) {	
        try {
            dumpPTA(new PrintStream(fileName));
        }
        catch (FileNotFoundException e) {

        }
    }

    /**
     * Print out all points to sets.
     */
    public void dumpPTA(PrintStream file) {

        file.print("======================= dumpPTA ()=====================================\n");
        //Vector<CallsiteContextVar> outList = new Vector<CallsiteContextVar>();
        for ( IVarAbstraction pn : ptsProvider.pointers ) {
            IVarAbstraction orig = pn;
            pn = pn.getRepresentative();
            Node v = pn.getWrappedNode();

            /*if ( pn != pn.getRepresentative() )
    				continue;*/

            int method = ptsProvider.getMappedMethodID(v);
            SootMethod pointerMethod = ptsProvider.getSootMethodFromID(method);
            /*
    				if (pointerMethod == null)
    				continue;
             */

            //System.out.println(pn);

            file.println(v);

            if (pn.getWrappedNode() != orig.getWrappedNode())
                file.println("Original: " + orig.getWrappedNode());

            file.println(v);

            if (v instanceof AllocDotField) 
                file.printf("\tAlloc dot field\n");			

            if ( v instanceof LocalVarNode ) {
                // We map the local pointer to its 1-cfa versions
                LocalVarNode lvn = (LocalVarNode)v;
                SootMethod sm = lvn.getMethod();
                int sm_int = ptsProvider.getIDFromSootMethod(sm);
                LinkedList<CgEdge> edges = ptsProvider.getCallEdgesInto(sm_int);

                for ( Iterator<CgEdge> it = edges.iterator(); it.hasNext(); ) {
                    CgEdge p = it.next();
                    if (p.sootEdge == null)
                        continue;

                    long l = p.map_offset;
                    long r = l + ptsProvider.max_context_size_block[p.s];


                    file.printf("%s (%s)->\n %s %s\n", p.sootEdge.getSrc(), p.sootEdge.srcUnit(), p.sootEdge.getTgt(), p.sootEdge.hashCode());

                    Obj_1cfa_extractor contextObjsVisitor = new Obj_1cfa_extractor();
                    pn.get_all_context_sensitive_objects(l, r, contextObjsVisitor);

                    for ( CallsiteContextVar cobj : contextObjsVisitor.outList ) {
                        //cobj.inQ = false;
                        if (cobj != null && cobj.var != null)
                            file.printf( "%s: %s\n", cobj.var.getClass(), cobj.var);
                        else 
                            file.printf( "%s: %s\n", cobj, "No Var");
                    }

                }
            }
            else {
                Obj_1cfa_extractor contextObjsVisitor = new Obj_1cfa_extractor();
                pn.get_all_context_sensitive_objects(1, soot.jimple.spark.geom.geomPA.Constants.MAX_CONTEXTS, contextObjsVisitor);

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

    private static void setPaddlePointsToAnalysis() {
        logger.info("[paddle] Starting analysis ...");

        //System.out.println(System.getProperty("java.library.path"));

        HashMap<String, String> opt = new HashMap<String, String>();
        opt.put("enabled","true");
        opt.put("verbose","false");
        opt.put("bdd","true");
        opt.put("backend","javabdd");
        opt.put("context","kcfa");
        opt.put("k","2");
        //opt.put("context-heap","true");
        opt.put("propagator","auto");
        opt.put("conf","ofcg");
        opt.put("order","32");
        opt.put("q","auto");
        opt.put("set-impl","double");
        opt.put("double-set-old","hybrid");
        opt.put("double-set-new","hybrid");
        opt.put("pre-jimplify","false");
        opt.put("verbosegc", "false");
        opt.put("all-reachable","false");
        opt.put("on-fly-cg", "true");
        opt.put("set-impl", "double");
        opt.put("verbose", "true");
        opt.put("implicit-entry", "false");

        PaddleTransformer pt = new PaddleTransformer();
        PaddleOptions paddle_opt = new PaddleOptions(opt);
        pt.setup(paddle_opt);
        pt.solve(paddle_opt);
        soot.jimple.paddle.Results.v().makeStandardSootResults();


        logger.info("[paddle] Done!");
    }

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

                /*
    				if (!visitedMethods.contains(edge.src()))
    					fw.write(getMethodDotLabel(edge.src()));
    				if (!visitedMethods.contains(edge.tgt()))
    					fw.write(getMethodDotLabel(edge.tgt()));

    				visitedMethods.add(edge.src());
    				visitedMethods.add(edge.tgt());
                 */
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
            System.exit(1);
        }
    }

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
                    if (p.is_obsoleted == false ) {
                        allCSEdges.add(p.sootEdge);
                    }
                }
                p = p.next;
            }
        }
        return allCSEdges;
    }
}
