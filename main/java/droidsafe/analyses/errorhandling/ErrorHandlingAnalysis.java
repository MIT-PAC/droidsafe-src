package droidsafe.analyses.errorhandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.traverse.BreadthFirstIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.Hierarchy;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Trap;
import soot.Unit;
import soot.UnitBox;
import soot.jimple.Stmt;
import soot.toolkits.graph.ExceptionalUnitGraph;
import droidsafe.analyses.CatchBlocks;
import droidsafe.analyses.collapsedcg.CollaspedCallGraph;
import droidsafe.analyses.collapsedcg.StmtEdge;
import droidsafe.analyses.collapsedcg.CollaspedCallGraph.CallToTarget;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.main.Config;
import droidsafe.main.Main;
import droidsafe.utils.IDroidsafeProgressMonitor;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootMethodList;
import droidsafe.utils.SootUtils;

/**
 * 
 * 
 * @author mgordon
 *
 */
public class ErrorHandlingAnalysis {

    private static ErrorHandlingAnalysis v = null;
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandlingAnalysis.class);
    private Map<SootMethod, Set<SootClass>> connectionMethodToException = new HashMap<SootMethod, Set<SootClass>>();
    private SootMethodList connectionMethods = new SootMethodList();
    private SootMethodList uiMethods = new SootMethodList();
    private Set<Stmt> connectionCallsErrorsIgnored = new LinkedHashSet<Stmt>();
    private Set<Stmt> connectionCallsErrorsNotIgnored = new LinkedHashSet<Stmt>();
    private PrintStream out;
    
    private ErrorHandlingAnalysis() {
        // TODO Auto-generated constructor stub
    }

    public static ErrorHandlingAnalysis v() {
        if (v == null)
            v = new ErrorHandlingAnalysis();

        return v;
    }

    private void loadConnectionCalls() {
        try {
            FileReader fr = new FileReader(Config.v().getApacHome() + File.separator + "config-files" + File.separator +
                    "connection-calls.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;           
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("#"))
                    continue;

                String[] splitLine = line.split("\\|");
                if (splitLine.length != 3)
                    continue;

                //class, methodname, exception
                SootClass clz = null;
                SootClass ex = null;
                String methodName = splitLine[1];
                try {
                    clz = Scene.v().getSootClass(splitLine[0]);
                    ex = Scene.v().getSootClass(splitLine[2]);
                } catch (Exception e) {
                    logger.warn("Cannot find soot class for line in connection-calls.txt: {}", line);
                    continue;
                }

                //find all name matches in class / interface
                List<SootMethod> nameMatches = new LinkedList<SootMethod>();
                for (SootMethod m : clz.getMethods()) {
                    if (methodName.equals(m.getName())) { 
                        nameMatches.add(m);
                        if (!connectionMethodToException.containsKey(m))
                            connectionMethodToException.put(m, new HashSet<SootClass>());

                        connectionMethodToException.get(m).add(ex);
                        connectionMethods.addMethod(m);
                        logger.info("Adding connection method: {}", m);
                    }
                }

                if (nameMatches.isEmpty()) {
                    logger.warn("Could not find method in class/interface: {}", line);
                    continue;
                }
            }
            br.close(); 
        } catch (Exception e)  {
            logger.error("Error loading connection calls", e);            
        }
    }

    public void loadUICalls() {
        try {
            FileReader fr = new FileReader(Config.v().getApacHome() + File.separator + "config-files" + File.separator +
                    "ui-calls.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;           
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("#"))
                    continue;

                String[] splitLine = line.split("\\|");
                if (splitLine.length != 2)
                    continue;

                //class, methodname, exception
                SootClass clz = null;            
                String methodName = splitLine[1];
                try {
                    clz = Scene.v().getSootClass(splitLine[0]);                    
                } catch (Exception e) {
                    logger.warn("Cannot find soot class for line in ui-calls.txt: {}", line);
                    continue;
                }

                //find all name matches in class / interface
                List<SootMethod> nameMatches = new LinkedList<SootMethod>();
                for (SootMethod m : clz.getMethods()) {
                    if (methodName.equals(m.getName())) { 
                        nameMatches.add(m);                   
                        uiMethods.addMethod(m);
                        logger.info("Adding ui method: {}", m);
                    }
                }

                if (nameMatches.isEmpty()) {
                    logger.warn("Could not find method in class/interface: {}", line);
                    continue;
                }
            }
            br.close();  
        } catch (Exception e)  {
            logger.error("Error loading ui calls", e);            
        } 

    }

    public void run(IDroidsafeProgressMonitor monitor) {
        System.out.println("Error Handling Analysis...");
        
        //out = System.out;
        try {
            out = new PrintStream(new File(Project.v().getOutputDir() + File.separator + "connection-error-analysis.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            logger.error("Unable to create output file for error handling analysis");
        }

        //load connection calls
        loadConnectionCalls();
        //load ui calls
        loadUICalls();
        
        //run pta to build call graph        
        Main.afterTransformPrecise(monitor, false, 1);
        //create collapsed call graph (no api edges)
        CollaspedCallGraph.reset();
        CollaspedCallGraph.v();

        for (SootClass clz : Scene.v().getClasses()) {

            for (SootMethod method : clz.getMethods()) {
                if (API.v().isSystemMethod(method))
                    continue;

                if (method.isPhantom() || method.isAbstract() || !method.isConcrete())
                    continue;

                if (!PTABridge.v().isReachableMethod(method))
                    continue;


                Body body = method.getActiveBody();                
                Map<Unit, List<Trap>> unitToTraps = getUnitToTrapMap(body);

                for (Unit current : unitToTraps.keySet()) {

                    //check if current is a call to api call we are interested in
                    if (!(current instanceof Stmt)) 
                        continue;

                    Stmt stmt = (Stmt)current;
                    
                    //already determined this call is not ignored
                    if (connectionCallsErrorsNotIgnored.contains(stmt))
                        continue;

                    if (stmt.containsInvokeExpr()) {
                        Set<SootMethod> targets = PTABridge.v().getTargetsInsNoContext(stmt);

                        logger.info("Found invoke in try block: {}", stmt);
                        for (SootMethod target : targets) {
                            logger.info("\tTarget: {}", target);
                            if (connectionCallsErrorsNotIgnored.contains(stmt))
                                break;
                                
                            if (connectionMethods.containsPoly(target)) {
                                logger.info("\tConnection Method");
                                //for each trap, check if the exception is one we are interested in
                                for (Trap trap : unitToTraps.get(current)) {
                                    boolean exceptionMatch = false;
                                    for (SootClass ex : connectionMethodToException.get(connectionMethods.getMethod(target))) {
                                        if (Scene.v().getActiveHierarchy().isClassSubclassOfIncluding(ex, trap.getException())) {
                                            exceptionMatch = true;
                                            break;
                                        }
                                    }

                                    if (!exceptionMatch)
                                        continue;

                                    out.printf("Found connection call catch block: %s %s\n", method, stmt);

                                    if (connectionCallsErrorsNotIgnored.contains(stmt))
                                        break;
                                    
                                    //calculate all handler units
                                    List<Unit> handlerUnits = getAllUnitsForCatch(body, trap.getHandlerUnit());

                                    //see if anything reachable is a gui method or field access?
                                    if (handlerHasReachableUI(method, handlerUnits)) {
                                        out.printf("Connection call found, but has reachable UI call in handler: %s\n", stmt);
                                        //remember that this connection call did not ignore this error, and thus is never a candidate
                                        connectionCallsErrorsNotIgnored.add(stmt);
                                        //remove from candidates if a different error was ignored previously
                                        connectionCallsErrorsIgnored.remove(stmt);
                                        break;
                                    } else {
                                        //for now, this is a candidate for removal, since it does not have a ui call 
                                        // in this handler, and a ui call was not found in a previous handler (see check above)
                                        out.printf("** Connection call found with no reachable UI calls in handler: %s\n", stmt);
                                        connectionCallsErrorsIgnored.add(stmt);                                        
                                    }
                                }                            
                            }
                        }
                    }                                        
                }
            }
        }
        
        out.println("\nConnect calls with appropriate exceptions not reported to user: ");
                
        for (Stmt stmt : connectionCallsErrorsIgnored) {
            out.printf("%s %s\n", JimpleRelationships.v().getEnclosingMethod(stmt), stmt);
        }

        //for debugging
        writeAllAppClasses();
        out.close();
    }


    private boolean handlerHasReachableUI(SootMethod containingM, List<Unit> handlerUnits) {
        //check handler units directly for calls to ui
        //build list of directly reachable app methods from handler
        List<SootMethod> directlyCalledAppMethods = new LinkedList<SootMethod>();
        for (Unit handlerU : handlerUnits) {
            if (!(handlerU instanceof Stmt))
                continue;

            Stmt hStmt = (Stmt)handlerU;
            if (hStmt.containsInvokeExpr()) {
                Set<SootMethod> targets = PTABridge.v().getTargetsInsNoContext(hStmt);

                logger.info("Found invoke in catch block: {}", hStmt);
                for (SootMethod target : targets) {
                    logger.info("\tTarget: {}", target);

                    //is this a uiMethod?
                    if (uiMethods.containsPoly(target)) {
                        out.printf("Found ui method call in handler %s: %s\n",  containingM, hStmt);
                        return true;
                    }

                    //if not a system method, then an app method, and remember that it is reachable from handler
                    if (!API.v().isSystemMethod(target)) {
                        directlyCalledAppMethods.add(target);
                    }
                }
            }            
        }

        //handler does not have any ui calls directly

        Set<SootMethod> visited = new HashSet<SootMethod>();

        for (SootMethod directlyCalled : directlyCalledAppMethods) {
            BreadthFirstIterator<SootMethod,StmtEdge> bfi = 
                    CollaspedCallGraph.v().getBreadthFirstTraversalFrom(directlyCalled);

            while (bfi.hasNext()) {
                SootMethod current = bfi.next();

                if (visited.contains(current))
                    continue;

                visited.add(current);          

                if (uiMethods.containsPoly(current)) {
                    out.printf("Found reachable app method that implements ui method: %s\n", current);
                    return true;
                }
                
                for (CallToTarget apiCall : CollaspedCallGraph.v().getAPICallTargets(current)) {
                    if (uiMethods.containsPoly(apiCall.getTarget())) {
                        out.printf("Found call to ui method in reachable app method %s: %s\n",  current, apiCall.getStmt());
                        return true;
                    }
                }
            }
        }

        //nothing found
        return false;
    }

    private Map<Unit, List<Trap>> getUnitToTrapMap(Body body) {
        HashMap<Unit, List<Trap>> map = new HashMap<Unit, List<Trap>>();

        for (Trap trap : body.getTraps()) {
            Iterator<Unit> units = body.getUnits().iterator(trap.getBeginUnit());
            while (units.hasNext()) {
                Unit current = units.next();
                if (current == trap.getEndUnit())
                    break;

                if (!map.containsKey(current)) 
                    map.put(current, new LinkedList<Trap>());

                map.get(current).add(trap);
            }
        }        

        return map;
    }

    private void writeAllAppClasses() {
        for (SootClass clz : Scene.v().getClasses()) {
            if (clz.isApplicationClass() && Project.v().isSrcClass(clz.toString())) {
                SootUtils.writeByteCodeAndJimple(
                    Project.v().getOutputDir(), clz);
            }
        }
    }

    private List<Unit> getAllUnitsForCatch(Body body, Unit startCatch) {
        ExceptionalUnitGraph cfg = new ExceptionalUnitGraph(body);
        List<Unit> catchBlock = new LinkedList<Unit>();
        catchBlock.add(startCatch);

        //calculate reachable units to color instructions
        Set<Unit> reachableUnits = new HashSet<Unit>();
        getReachableUnits(cfg, startCatch, reachableUnits);

        for (Unit current : reachableUnits) {
            boolean allColored = true;
            for (Unit pred : cfg.getPredsOf(current)) {
                if (!reachableUnits.contains(pred)) {
                    allColored = false;
                    break;
                }
            }
            if (allColored) {
                catchBlock.add(current);
            }            
        }

        return catchBlock;
    }

    private void getReachableUnits(ExceptionalUnitGraph cfg, Unit current, Set<Unit> reachable) {
        if (reachable.contains(current)) 
            return;

        reachable.add(current);

        for (Unit next : cfg.getSuccsOf(current)) {
            getReachableUnits(cfg, next, reachable);
        }
    }
}
