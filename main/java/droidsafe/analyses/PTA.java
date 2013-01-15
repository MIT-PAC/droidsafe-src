package droidsafe.analyses;

import java.util.HashMap;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.app.EntryPoints;
import droidsafe.android.app.Harness;

import soot.MethodOrMethodContext;
import soot.Scene;
import soot.SootMethod;
import soot.jimple.paddle.PaddleTransformer;
import soot.jimple.spark.SparkTransformer;
import soot.jimple.spark.geom.geomPA.GeomPointsTo;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Targets;
import soot.options.PaddleOptions;
import soot.options.SparkOptions;

/**
 * Configure and run the Soot Spark PTA.  This class assumes the soot 
 * class path has been set, the appropriate classes have been loaded, 
 * and the entry points have been defined.
 * 
 * @author mgordon
 *
 */
public class PTA {
	private final static Logger logger = LoggerFactory.getLogger(PTA.class);
	public static GeomPointsTo gPTA;
	
	public static String ALGORITHM = "geo";
	
	public static void run() {
		Scene.v().loadDynamicClasses();
		if (ALGORITHM.equals("paddle"))
			setPaddlePointsToAnalysis();
		else if (ALGORITHM.equals("spark"))
			setSparkPointsToAnalysis();
		else if (ALGORITHM.equals("geo")) 
			setGeomPointsToAnalysis();
	
		/*
		SootMethod src = Harness.v().getMain();
		CallGraph cg = Scene.v().getCallGraph();

		Iterator<MethodOrMethodContext> targets = new Targets(cg.edgesOutOf(src));
		while (targets.hasNext()) {
			SootMethod tgt = (SootMethod)targets.next();
			System.out.println(src + " may call " + tgt);
		}
		*/
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
