package droidsafe.main;

import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.analyses.EntryPointCGEdges;
import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.infoflow.InformationFlowAnalysis;
import droidsafe.analyses.infoflow.InjectedSourceFlows;
import droidsafe.analyses.infoflow.InterproceduralControlFlowGraph;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.RCFGToSSL;
import droidsafe.analyses.RequiredModeling;
import droidsafe.analyses.strings.JSAStrings;
import droidsafe.analyses.strings.JSAUtils;

import droidsafe.android.app.EntryPoints;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Project;
import droidsafe.android.app.resources.Resources;
import droidsafe.android.app.TagImplementedSystemMethods;
import droidsafe.android.system.API;
import droidsafe.android.system.Permissions;

import droidsafe.transforms.AddAllocsForAPICalls;
import droidsafe.transforms.InsertDSTaintAllocs;
import droidsafe.transforms.IntegrateXMLLayouts;
import droidsafe.transforms.LocalForStringConstantArguments;
import droidsafe.transforms.ResolveStringConstants;
import droidsafe.transforms.ScalarAppOptimizations;

import droidsafe.utils.SootUtils;

import java.io.File;
import java.io.IOException;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Scene;

import soot.SootClass;

import soot.SootMethod;

/**
 * Main entry class for DroidSafe analysis.
 * 
 * @author mgordon
 * @author dpetters
 * 
 */
public class Main {
    /** logger field */
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * Entry point of DroidSafe Tool.
     * 
     */
    public static void main(String[] args) {
        logger.info("Starting DroidSafe Run");
        // grab command line args and set some globals
        Config.v().init(args);
        // initial project directories and lib jar files
        Project.v().init();
        // configure soot and soot classpath
        SootConfig.init();
        // load the api classes and modeling classes
        API.v().init();
        // load the application classes
        Project.v().loadClasses();
        // create the permissions map
        Permissions.init();

        logger.info("Creating locals for all string constant arguments.");
        LocalForStringConstantArguments.run();

        logger.info("Calling scalar optimizations.");
        ScalarAppOptimizations.run();

        logger.info("Create tags for the overriden system methods in user code.");
        TagImplementedSystemMethods.run();

        logger.info("Resolving resources and Manifest.");

        Resources.resolveManifest(Config.v().APP_ROOT_DIR);

        logger.info("Finding entry points in user code.");
        EntryPoints.v().calculate();

        logger.info("Creating Harness.");
        Harness.create();

        logger.info("Setting Harness Main as entry point.");
        setHarnessMainAsEntryPoint();

        // The JSA analysis fails if it follows AddAllocsForAPICalls.run()
        if (Config.v().runStringAnalysis) {
            jsaAnalysis();
        }

        logger.info("Inserting DSTaintObject allocations at each new expression...");
        InsertDSTaintAllocs.run();
        
        AddAllocsForAPICalls.run();

        logger.info("Starting PTA...");
        GeoPTA.run();

        logger.info("Incorporating XML layout information");
        IntegrateXMLLayouts.run();
        
        logger.info("Resolving String Constants");
        ResolveStringConstants.run(Config.v().APP_ROOT_DIR);

        System.exit(-1);
        
        // all transforms should be done by here!
        logger.info("Restarting PTA...");
        GeoPTA.release();
        GeoPTA.run();

        // write jimple txt files for all classes so we can analzye them
        // all transforms should be done by here.
        if (Config.v().writeJimpleAppClasses) {
            writeAllAppClasses();
        }

        RCFG.generate();
       
        logger.info("Starting Attribute Modeling");
        ValueAnalysis.run();
        logger.info("Finished Attribute Modeling");

        // print out what modeling is required for this application
        RequiredModeling.run();


        if (Config.v().infoFlow) {
            logger.info("Starting Information Flow Analysis...");
            InjectedSourceFlows.run();
            InterproceduralControlFlowGraph.run();
            InformationFlowAnalysis.run();

            String infoFlowDotFile = Config.v().infoFlowDotFile;
            if (infoFlowDotFile != null) {
                try {
                    String infoFlowDotMethod = Config.v().infoFlowDotMethod;
                    if (infoFlowDotMethod != null) {
                        InformationFlowAnalysis.exportDotGraph
                        (Scene.v().getMethod(infoFlowDotMethod),infoFlowDotFile);
                    } else {
                        InformationFlowAnalysis.exportDotGraph(infoFlowDotFile);
                    }
                } catch (IOException exp) {
                    logger.error(exp.toString());
                }
            }
            logger.info("Finished Information Flow Analysis...");
        }

        if (Config.v().target.equals("specdump")) {
            RCFGToSSL.run();

        } else if (Config.v().target.equals("confcheck")) {
            logger.error("Not implemented yet!");
        }

        // System.out.print(RCFG.v().toString());
    }
   
    /**
     * Run the JSA analysis
     */ 
    private static void jsaAnalysis() {
        JSAStrings.init(Config.v());
        JSAUtils.setUpHotspots();
        JSAStrings.run();
        // Debugging.
        JSAStrings.v().log();
    }

    /**
     * Set's harness as entry point for Soot.  Run after EntryPoints.
     */
    private static void setHarnessMainAsEntryPoint() {
        List<SootMethod> entryPoints = new LinkedList<SootMethod>();
        entryPoints.add(Harness.v().getMain());
        Scene.v().setEntryPoints(entryPoints);
        // Scene.v().setMainClass(Harness.v().getHarnessClass());
    }

    /**
     * Dump jimple files for all application classes.
     */
    private static void writeAllAppClasses() {
        for (SootClass clz : Scene.v().getClasses()) {
            if (clz.isApplicationClass() /* && Project.v().isSrcClass(clz.toString()) */) {
                SootUtils.writeByteCodeAndJimple(
                    Project.v().getOutputDir() + File.separator + clz.toString(), clz);
            }
        }
    }

}
