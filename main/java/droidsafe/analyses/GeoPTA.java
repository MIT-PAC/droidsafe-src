package droidsafe.analyses;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.pattern.Util;

import droidsafe.android.app.EntryPoints;
import droidsafe.android.app.Harness;
import droidsafe.utils.Utils;

import soot.Local;
import soot.MethodOrMethodContext;
import soot.Scene;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.jimple.paddle.PaddleTransformer;
import soot.jimple.spark.SparkTransformer;
import soot.jimple.spark.geom.geomPA.CallsiteContextVar;
import soot.jimple.spark.geom.geomPA.CgEdge;
import soot.jimple.spark.geom.geomPA.GeomEvaluator;
import soot.jimple.spark.geom.geomPA.GeomPointsTo;
import soot.jimple.spark.geom.geomPA.IVarAbstraction;
import soot.jimple.spark.geom.geomPA.ZArrayNumberer;
import soot.jimple.spark.pag.AllocDotField;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.LocalVarNode;
import soot.jimple.spark.pag.Node;
import soot.jimple.spark.pag.VarNode;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.callgraph.Targets;
import soot.options.PaddleOptions;
import soot.options.SparkOptions;
import soot.util.queue.QueueReader;
import soot.RefLikeType;

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
	/** list of all objects that are context sensitive for resolution */
	private ZArrayNumberer<CallsiteContextVar> ct_sens_objs;
	private CallGraph callGraph;
	
	private static GeoPTA v;
	
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
		callGraph = Scene.v().getCallGraph();
		resolveContext();
		//dumpPTA();
	}


	private void resolveContext() {
		ct_sens_objs = new ZArrayNumberer<CallsiteContextVar>();
		CallsiteContextVar context_obj = null;

		for ( IVarAbstraction pobj : ptsProvider.allocations ) {
			AllocNode obj = (AllocNode)pobj.getWrappedNode();
			SootMethod sm = obj.getMethod();

			if ( sm == null ) {
				context_obj = new CallsiteContextVar(null, obj);
				ct_sens_objs.add(context_obj);
			}
			else {
				int sm_int = ptsProvider.getIDFromSootMethod(sm);
				if ( ptsProvider.isReachableMethod(sm_int) ) {
					// We also temporarily build the 1cfa object
					List<CgEdge> edges = ptsProvider.getCallEdgesInto(sm_int);

					for ( CgEdge ce : edges ) {
						context_obj = new CallsiteContextVar(ce, obj);
						ct_sens_objs.add(context_obj);
					}
				}
			}
		}
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
			IVarAbstraction internalNode = ptsProvider.getInternalNode(node);
			return internalNode;
		} else if (v instanceof SootField) {
			Utils.ERROR_AND_EXIT(logger, "Unknown type for pointer: {}", v.getClass());
		}
		
		Utils.ERROR_AND_EXIT(logger, "Unknown type for pointer: {}", v.getClass());
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
				Utils.ERROR_AND_EXIT(logger, "Null context edge for pta query.");


			if (ivar == null) 
				Utils.ERROR_AND_EXIT(logger, "Error getting internal PTA node for {} of {}.", ivar, ivar.getClass());


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

					Vector<CallsiteContextVar> outList = new Vector<CallsiteContextVar>();
					ivar.get_all_context_sensitive_objects(l, r, ct_sens_objs, outList);

					for (CallsiteContextVar ccv : outList) {
						//this var assignment here seems to denote if the alloc can be included 
						//in further searches, so once we grab, make sure to say it is no
						//longer in another queue.
						ccv.inQ = false;
						allocNodes.add((AllocNode)ccv.var);
					}
				} else if (sparkNode == null) {
					logger.info("Null sparkNode for ivar query: {} in {}", ivar, context);
				} else {
					Utils.ERROR_AND_EXIT(logger, "Unknown type of spark node for points to query for value v {}, ivar {} spark node {}.", 
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
			logger.error("Some sort of error getting points to set for {} in {}", v, context.tgt(), e);
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
		Node sparkNode = ivar.getWrappedNode();
		
		return getPTSet(sparkNode, ivar, context, v);
	}
	
	/**
	 * Print out all points to sets.
	 */
	public void dumpPTA() {
		Vector<CallsiteContextVar> outList = new Vector<CallsiteContextVar>();
		
		for ( IVarAbstraction pn : ptsProvider.pointers ) {
			pn = pn.getRepresentative();
			Node v = pn.getWrappedNode();

			if ( pn != pn.getRepresentative() )
				continue;

			int method = ptsProvider.getMappedMethodID(v);
			SootMethod pointerMethod = ptsProvider.getSootMethodFromID(method);

			if (pointerMethod == null)
				continue;

			//System.out.println(pn);
			System.out.println(v);

			if (v instanceof AllocDotField) 
				System.out.printf("\tAlloc dot field\n");

			PrintStream file = System.out;

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
					
					pn.get_all_context_sensitive_objects(l, r, ct_sens_objs, outList);

					for ( CallsiteContextVar cobj : outList ) {
						cobj.inQ = false;
						file.printf( "%s: %s\n", cobj.var.getClass(), cobj.var);
					}

				}
			}
			else {
				file.print( pn.get_all_context_sensitive_objects(1, GeomPointsTo.MAX_CONTEXTS, ct_sens_objs, outList) );

				for ( CallsiteContextVar cobj : outList ) {
					cobj.inQ = false;
					file.print( " " + cobj.getNumber() );
				}
				file.println();
			}

			System.out.println();
		}
	}

	static void setGeomPointsToAnalysis() {
		logger.info("[GeomPTA] Starting analysis ...");
		
		HashMap opt = new HashMap();
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
		opt.put("ignore-types","true");          
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
				
		HashMap opt = new HashMap();
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
		
		HashMap opt = new HashMap();
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
	
	
}
