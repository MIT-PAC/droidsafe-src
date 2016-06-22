package objsenspark;

import java.util.HashMap;
import java.util.Map;
import soot.Scene;
import soot.SootClass;
import soot.jimple.spark.SparkEvaluator;

public class Main {

    public static void main(String[] args) {
        Config.v().init(args);
        // initial project directories and lib jar files
        Project.v().init();
        SootConfig.init();
        
        Scene.v().loadNecessaryClasses();
        
        Map<String,String> opts = new HashMap<String,String>();

        //build precise options for spark
        opts.put("merge-stringbuffer","false");   
        opts.put("string-constants","true");   
        opts.put("kobjsens", Integer.toString(Config.v().kobjsens));              
        
        SparkPTA pta = new SparkPTA(opts);        
        pta.run();
        System.out.println(SparkEvaluator.v().toString());
    }

}
