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
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Trap;
import soot.Unit;
import soot.UnitBox;
import soot.jimple.Stmt;
import soot.jimple.ThrowStmt;
import soot.jimple.internal.JThrowStmt;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.CHATransformer;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.pta.IAllocNode;
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
    private SootClass throwableClass;
    private int DEPTH_LIMIT = 50;

    private ErrorHandlingAnalysis() {
        throwableClass = Scene.v().getSootClass("java.lang.Throwable");
    }

    public static ErrorHandlingAnalysis v() {
        if (v == null)
            v = new ErrorHandlingAnalysis();

        return v;
    }
    
    public void runCHA() {
        CHATransformer.v().transform();
        CallGraph cg = Scene.v().getCallGraph();
        
        //patch reflection invokes?
        
        //maybe just don't count methods without preds?
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

    public void run(IDroidsafeProgressMonitor monitor) {
        System.out.println("Error Handling Analysis...");

        //out = System.out;
        try {
            out = new PrintStream(new File(Project.v().getOutputDir() + File.separator + "connection-error-analysis.txt"));
        } catch (FileNotFoundException e) {
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

                logger.info("ErrorHandlingAnalysis inspecting: {}", method);
                Body body = method.getActiveBody();                
                
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
                        Set<SootMethod> targets = PTABridge.v().getTargetsInsNoContext(stmt);                        
                        for (SootMethod target : targets) {                            
                            if (connectionCallsErrorsNotIgnored.contains(stmt))
                                break;

                            if (connectionMethods.containsPoly(target)) {
                                logger.info("Found invoke in try block of connection method: {} {} {}", method, stmt, target);

                                //for each trap, check if the exception is one we are interested in
                                for (SootClass ex : connectionMethodToException.get(connectionMethods.getMethod(target))) {
                                    List<List<Unit>> allHandlerUnits = new LinkedList<List<Unit>>();
                                    if (findAllHandlers(body, ex, stmt, allHandlerUnits, new HashSet<StmtAndException>(), 0)) {
                                        //completed search
                                        for (List<Unit> handlerUnits : allHandlerUnits) {
                                            out.printf("Found connection call catch block: %s %s\n", method, stmt);

                                            if (connectionCallsErrorsNotIgnored.contains(stmt))
                                                break;

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
                                    } else {
                                        //reached recursion depth limit
                                        out.printf("Connection call found, but reached recursion depth when traversing callgraph: %s\n", stmt);
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
     * return false if we have reached the depth limit for recursion. 
     */
    private boolean findAllHandlers(Body body, SootClass exception, Stmt stmt, List<List<Unit>> allHandlerUnits,
                                 Set<StmtAndException> visited, int depth) {
        //TODO: run time exceptions??  unchecked?
        
        //check for already visited statements, limit recursion
        if (depth > DEPTH_LIMIT)
            return false;
        
        StmtAndException probe = new StmtAndException(stmt, exception);
        if (visited.contains(probe))
            return true;
        
        visited.add(probe);
        
        Map<Unit, List<Trap>> unitToTraps = getUnitToTrapMap(body);
        Trap firstTrap = null;

        if (unitToTraps.get(stmt) != null) {
            for (Trap trap : unitToTraps.get(stmt)) {                                                                        
                if (Scene.v().getActiveHierarchy().isClassSubclassOfIncluding(exception, trap.getException())) {
                    firstTrap = trap;
                    break;
                }
            }
        }        
        
        if (firstTrap == null) {        
            //could not find a trap in enclosing method for this exception
            //need to search up the stack...
            //find all calling statements
            for (StmtEdge<SootMethod> se : CollaspedCallGraph.v().getSourcesForMethod(body.getMethod())) {
                if (se.getV1().isConcrete())
                    if (!findAllHandlers(se.getV1().getActiveBody(), exception, se.getStmt(), 
                        allHandlerUnits, visited, depth + 1))
                        return false;
            }
        } else {  
            List<Unit> trapUnits = getAllUnitsForCatch(body, firstTrap.getHandlerUnit());                        
            
            //add the found trap in this method to the list of handlers bodies 
            allHandlerUnits.add(trapUnits);
            
            //check to see if there are any possible thrown exceptions, track each throw the stack
            return processThrownExceptions(body, trapUnits, allHandlerUnits, visited, depth);
        }
        
        return true;
    }

    /**
     * Given a list of units that represents the units of a trap (catch block), scan 
     * the trap units for "throw" statements.  Use the pta to return the possible classes
     * thrown by all the throw statements of the trap.
     * 
     * For each throw statement, recursively call findAllHandlers, to find the handlers for the 
     * throw. Add the handler units to the passed around list of units.
     * 
     * Return false if we have exceeded the recursion depth limit during our search
     */
    private boolean processThrownExceptions(Body body, List<Unit> trapUnits, List<List<Unit>> allHandlerUnits, 
                                          Set<StmtAndException> visited, int depth) {       
        for (Unit current : trapUnits) {
            if (current instanceof ThrowStmt) {
                ThrowStmt throwStmt = (ThrowStmt) current;
                //use the points to analysis to find the type of the thrown op
                if (PTABridge.v().isPointer(throwStmt.getOp())) {
                    Set<AllocNode> nodes = (Set<AllocNode>)PTABridge.v().getPTSetIns(throwStmt.getOp());
                    for (AllocNode node : nodes) {
                        if (node.getType() instanceof RefType) {
                            SootClass clz = ((RefType)node.getType()).getSootClass();
                            if (Scene.v().getActiveHierarchy().isClassSubclassOfIncluding(clz, throwableClass)) {
                                if (!findAllHandlers(body, clz, throwStmt, allHandlerUnits, visited, depth + 1))
                                    return false;
                            }
                        }
                    }
                }
            }            
        }  
        
        return true;
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

    //assume the list of traps in jimple keeps the static ordering for multiple catch blocks
    static Map<Unit, List<Trap>> getUnitToTrapMap(Body body) {
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

    static List<Unit> getAllUnitsForCatch(Body body, Unit startCatch) {
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

    static void getReachableUnits(ExceptionalUnitGraph cfg, Unit current, Set<Unit> reachable) {
        if (reachable.contains(current)) 
            return;

        reachable.add(current);

        for (Unit next : cfg.getSuccsOf(current)) {
            getReachableUnits(cfg, next, reachable);
        }
    }
    
    class StmtAndException {
        Stmt stmt;
        SootClass exception;
        
        StmtAndException(Stmt s, SootClass e) {
            this.stmt = s;
            this.exception = e;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((exception == null) ? 0 : exception.hashCode());
            result = prime * result + ((stmt == null) ? 0 : stmt.hashCode());
            return result;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            StmtAndException other = (StmtAndException) obj;
            if (!getOuterType().equals(other.getOuterType())) return false;
            if (exception == null) {
                if (other.exception != null) return false;
            } else if (!exception.equals(other.exception)) return false;
            if (stmt == null) {
                if (other.stmt != null) return false;
            } else if (!stmt.equals(other.stmt)) return false;
            return true;
        }
        private ErrorHandlingAnalysis getOuterType() {
            return ErrorHandlingAnalysis.this;
        }                
    }
    
}

