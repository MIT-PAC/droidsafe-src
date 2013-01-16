package droidsafe.analyses;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.app.EntryPoints;
import droidsafe.android.app.Harness;

import soot.MethodOrMethodContext;
import soot.Scene;
import soot.SootMethod;
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
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Targets;
import soot.options.PaddleOptions;
import soot.options.SparkOptions;
import soot.util.queue.QueueReader;

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
	private GeomPointsTo gPTA;
	
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
		gPTA = (GeomPointsTo)Scene.v().getPointsToAnalysis();
	}
	
	static void dumpPTA() {

		GeomPointsTo ptsProvider = (GeomPointsTo)Scene.v().getPointsToAnalysis();
		GeomEvaluator eval = new GeomEvaluator(ptsProvider, System.out);
		//eval.reportBasicMetrics();

		ZArrayNumberer<CallsiteContextVar> ct_sens_objs = new ZArrayNumberer<CallsiteContextVar>();
		Vector<CallsiteContextVar> outList = new Vector<CallsiteContextVar>();
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


		for ( IVarAbstraction pn : ptsProvider.pointers ) {
			pn = pn.getRepresentative();
			Node v = pn.getWrappedNode();

			if ( pn != pn.getRepresentative() )
				continue;

			int method = ptsProvider.getMappedMethodID(v);
			SootMethod pointerMethod = ptsProvider.getSootMethodFromID(method);

			if (pointerMethod == null)
				continue;

			System.out.println(pn);
			System.out.println(v);

			pn.print_context_sensitive_points_to(System.out);

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

					long l = p.map_offset;
					long r = l + ptsProvider.max_context_size_block[p.s];
					file.printf("%s (%s)->\n %s\n", p.sootEdge.getSrc(), p.sootEdge.srcUnit(), p.sootEdge.getTgt());

					file.print( pn.get_all_context_sensitive_objects(l, r, ct_sens_objs, outList) );

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
		opt.put("ignore-types","false");          
		opt.put("force-gc","false");            
		opt.put("pre-jimplify","false");          
		opt.put("vta","false");                   
		opt.put("rta","false");                   
		opt.put("field-based","false");           
		opt.put("types-for-sites","false");        
		opt.put("merge-stringbuffer","true");   
		opt.put("string-constants","false");     
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
		opt.put("merge-stringbuffer","true");   
		opt.put("string-constants","false");     
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
