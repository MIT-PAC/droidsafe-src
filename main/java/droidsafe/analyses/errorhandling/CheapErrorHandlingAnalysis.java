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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Trap;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.AssignStmt;
import soot.jimple.FieldRef;
import soot.jimple.Stmt;
import soot.jimple.ThrowStmt;
import soot.jimple.toolkits.callgraph.CHATransformer;
import soot.jimple.toolkits.callgraph.CallGraph;
import droidsafe.analyses.cg.StmtEdge;
import droidsafe.analyses.cg.cha.CHACallGraph;
import droidsafe.analyses.cg.collapsedcg.CollaspedCallGraph;
import droidsafe.analyses.errorhandling.ErrorHandlingAnalysis.StmtAndException;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.main.Config;
import droidsafe.main.Main;
import droidsafe.utils.IDroidsafeProgressMonitor;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootMethodList;
import droidsafe.utils.SootUtils;

public class CheapErrorHandlingAnalysis {     
    private static CheapErrorHandlingAnalysis v = null;
    private static final Logger logger = LoggerFactory.getLogger(CheapErrorHandlingAnalysis.class);
    private Map<SootMethod, Set<SootClass>> connectionMethodToException = new HashMap<SootMethod, Set<SootClass>>();
    private SootMethodList connectionMethods = new SootMethodList();
    private SootMethodList uiMethods = new SootMethodList();
    private Set<Stmt> connectionCallsErrorsIgnored = new LinkedHashSet<Stmt>();
    private Set<Stmt> connectionCallsErrorsNotIgnored = new LinkedHashSet<Stmt>();
    private PrintStream out;
    private SootClass throwableClass;
    private int DEPTH_LIMIT = 50;

    private CheapErrorHandlingAnalysis() {
        throwableClass = Scene.v().getSootClass("java.lang.Throwable");
    }

    public static CheapErrorHandlingAnalysis v() {
        if (v == null)
            v = new CheapErrorHandlingAnalysis();

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
                if (!Scene.v().containsClass(splitLine[0])) {
                    logger.warn("Cannot find soot class for method packag in line in ui-calls.txt: {}", line);
                    continue;
                }

                clz = Scene.v().getSootClass(splitLine[0]);  


                SootClass ex = null;
                if (!Scene.v().containsClass(splitLine[2])) {
                    logger.warn("Cannot find soot class for exception in line in ui-calls.txt: {}", line);
                    continue;
                }

                ex = Scene.v().getSootClass(splitLine[2]);  

                String methodName = splitLine[1];

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

    public void run(IDroidsafeProgressMonitor monitor) {
        System.out.println("Error Handling Analysis...");

        JimpleRelationships.reset();
        CHACallGraph.v(false);

        //out = System.out;
        try {
            out = new PrintStream(new File(Project.v().getOutputDir() + File.separator + "connection-error-analysis.txt"));
        } catch (FileNotFoundException e) {
            logger.error("Unable to create output file for error handling analysis");
        }

        //load connection calls
        loadConnectionCalls(); 
        loadUICalls();

        for (SootClass clz : Scene.v().getClasses()) {

            for (SootMethod method : clz.getMethods()) {
                if (API.v().isSystemMethod(method))
                    continue;

                if (method.isPhantom() || method.isAbstract() || !method.isConcrete())
                    continue;

                try {

                    logger.info("CheapErrorHandlingAnalysis inspecting: {}", method);


                    Body body = method.retrieveActiveBody();                

                    Iterator<Unit> units = body.getUnits().iterator();
                    while (units.hasNext()) {
                        Unit current = units.next();

                        //check if current is a call to api call we are interested in
                        if (!(current instanceof Stmt)) 
                            continue;

                        Stmt stmt = (Stmt)current;

                        //already determined this call is not ignored
                        if (connectionCallsErrorsNotIgnored.contains(stmt))
                            continue;

                        if (stmt.containsInvokeExpr()) {
                            //find possible targets of invoke                        
                            Set<SootMethod> targets = SootUtils.getTargetsCHA(stmt.getInvokeExpr());

                            for (SootMethod target : targets) {                            
                                if (connectionCallsErrorsNotIgnored.contains(stmt))
                                    break;

                                if (connectionMethods.containsPoly(target)) {
                                    logger.info("Found invoke in try block of connection method: {} {} {}", method, stmt, target);

                                    //for each trap, check if the exception is one we are interested in
                                    for (SootClass ex : connectionMethodToException.get(connectionMethods.getMethod(target))) {
                                        List<Unit> handlerUnits = findLocalHandler(body, ex, stmt);
                                        if (handlerUnits != null) {
                                            //found a local handler

                                            //see if anything reachable is a gui method or field access?
                                            if (exceptionHandled(method, handlerUnits)) {
                                                out.printf("Connection call found, but error handled: %s %s\n", stmt, method);
                                                //remember that this connection call did not ignore this error, and thus is never a candidate
                                                connectionCallsErrorsNotIgnored.add(stmt);
                                                //remove from candidates if a different error was ignored previously
                                                connectionCallsErrorsIgnored.remove(stmt);                                          
                                            } else {
                                                //for now, this is a candidate for removal, since it does not have a ui call 
                                                // in this handler, and a ui call was not found in a previous handler (see check above)
                                                out.printf("** Connection call found with nothing interesting in handler: %s %s\n", stmt, method);
                                                connectionCallsErrorsIgnored.add(stmt);                                        
                                            }

                                        } else {
                                            //did not find a local handler
                                            out.printf("Connection call found, but did not find local handler: %s %s\n", stmt, method);
                                            //remember we could not complete the search, and thus is never a candidate
                                            connectionCallsErrorsNotIgnored.add(stmt);
                                            //remove from candidates if a different error was ignored previously
                                            connectionCallsErrorsIgnored.remove(stmt);
                                        }
                                    }
                                }
                            }
                        }                                        
                    }
                } catch (Exception e) {
                    logger.warn("Error analyzing method in cheap error analysis: {}", method);
                }
            }
        }

        out.println("\nConnect calls with appropriate exceptions not reported to user: ");

        for (Stmt stmt : connectionCallsErrorsIgnored) {
            out.printf("%s %s\n", JimpleRelationships.v().getEnclosingMethod(stmt), stmt);
        }

        if (Config.v().debug)
            writeAllAppClasses();
        out.close();
    }

    /**
     * Return true if exception is handled (see definition in method)
     * Return false if no patterns found that indicate a handled exception.
     */
    private boolean exceptionHandled(SootMethod method, List<Unit> handlerUnits) {
        //find:
        //throw statement
        //ui call statements
        //field assignments

        for (Unit u : handlerUnits) {
            Stmt stmt = (Stmt)u;

            //find throw expressions
            if (stmt instanceof ThrowStmt) {
                out.printf("Found throw statement in handler %s: %s\n",  method, stmt);
                return true;
            }

            //check for field references
            for (ValueBox vb : stmt.getUseAndDefBoxes()) {
                Value value = vb.getValue();
                if (value instanceof FieldRef) {
                    out.printf("Found field reference handler %s: %s\n",  method, stmt);
                    return true;
                }
            }

            //no ui calls
            if (stmt.containsInvokeExpr()) {
                Set<SootMethod> targets = SootUtils.getTargetsCHA(stmt.getInvokeExpr());

                for (SootMethod target : targets) {
                    if (uiMethods.containsPoly(target)) {
                        out.printf("Found ui method call in handler %s: %s\n",  method, stmt);
                        return true;                    
                    }
                }
            }

        }

        return false;
    }

    /**
     * return null if we cannot find the handler locally
     */
    private List<Unit> findLocalHandler(Body body, SootClass exception, Stmt stmt) {

        Map<Unit, List<Trap>> unitToTraps = ErrorHandlingAnalysis.getUnitToTrapMap(body);

        if (unitToTraps.get(stmt) != null) {
            for (Trap trap : unitToTraps.get(stmt)) {                                                                        
                if (Scene.v().getActiveHierarchy().isClassSubclassOfIncluding(exception, trap.getException())) {
                    //found trap
                    List<Unit >handlerUnits = ErrorHandlingAnalysis.getAllUnitsForCatch(body, trap.getHandlerUnit());                        

                    return handlerUnits;
                }
            }
        }        

        return null;
    }


    private void writeAllAppClasses() {
        for (SootClass clz : Scene.v().getClasses()) {
            if (!API.v().isSystemClass(clz)) {
                SootUtils.writeByteCodeAndJimple(
                    Project.v().getOutputDir(), clz);
            }
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
                if (!Scene.v().containsClass(splitLine[0])) {
                    logger.warn("Cannot find soot class for line in ui-calls.txt: {}", line);
                    continue;
                }

                clz = Scene.v().getSootClass(splitLine[0]);                    

                //find all name matches in class / interface
                List<SootMethod> nameMatches = new LinkedList<SootMethod>();
                for (SootMethod m : clz.getMethods()) {
                    if (methodName.equals(m.getName())) { 
                        nameMatches.add(m);
                    }
                }

                if (nameMatches.isEmpty()) {
                    nameMatches = SootUtils.findPossibleInheritedMethods(clz, methodName);
                    logger.info("Could not find method in class/interface {}, so getting inheritied methods {}", line, nameMatches);
                }

                for (SootMethod m : nameMatches) {
                    logger.info("Adding ui method: {}", m);
                    uiMethods.addMethod(m);
                }
            }
            br.close();  
        } catch (Exception e)  {
            logger.error("Error loading ui calls", e);            
        } 

    }
}
