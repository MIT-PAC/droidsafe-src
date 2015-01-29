package objsenspark;

import soot.Scene;

public class Main {

    public static void main(String[] args) {
        Config.v().init(args);
        // initial project directories and lib jar files
        Project.v().init();
        SootConfig.init();
        Scene.v().loadNecessaryClasses();
        SparkPTA pta = new SparkPTA();
        pta.run();
    }

}
