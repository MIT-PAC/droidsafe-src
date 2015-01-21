package droidsafe.analyses.errorhandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.jgrapht.traverse.BreadthFirstIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.Hierarchy;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Trap;
import soot.Type;
import soot.Unit;
import soot.UnitBox;
import soot.Value;
import soot.ValueBox;
import soot.jimple.AssignStmt;
import soot.jimple.CaughtExceptionRef;
import soot.jimple.IdentityStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.NewExpr;
import soot.jimple.Stmt;
import soot.jimple.ThrowStmt;
import soot.toolkits.graph.ExceptionalUnitGraph;
import droidsafe.analyses.CatchBlocks;
import droidsafe.analyses.cg.StmtEdge;
import droidsafe.analyses.cg.cha.CHACallGraph;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.main.Config;
import droidsafe.main.Main;
import droidsafe.transforms.NativeMethodBuilder;
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
    private Set<Stmt> connectionCallsErrorsUnknown = new LinkedHashSet<Stmt>();
    private PrintStream out;
    private SootClass throwableClass;   
    private int DEPTH_LIMIT = 70;

    private ErrorHandlingAnalysis() {
        throwableClass = Scene.v().getSootClass("java.lang.Throwable");
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
                        logger.debug("Adding connection method: {}", m);
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
                    logger.debug("Could not find method in class/interface {}, so getting inheritied methods {}", line, nameMatches);
                }

                for (SootMethod m : nameMatches) {
                    logger.debug("Adding ui method: {}", m);
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

        JimpleRelationships.reset();
        CHACallGraph.v(false);
        
                

        for (SootClass clz : Scene.v().getClasses()) {

            for (SootMethod method : clz.getMethods()) {
                if (API.v().isSystemMethod(method))
                    continue;

                if (method.isPhantom() || method.isAbstract() || !method.isConcrete())
                    continue;

                boolean debug = "onServiceConnected".equals(method.getName());


                logger.debug("ErrorHandlingAnalysis inspecting: {}", method);
                try {
                    Body body = method.retrieveActiveBody();                

                    Iterator<Unit> units = body.getUnits().iterator();
                    while (units.hasNext()) {
                        Unit current = units.next();

                        //check if current is a call to api call we are interested in
                        if (!(current instanceof Stmt)) 
                            continue;

                        Stmt stmt = (Stmt)current;

                        //already determined this call is not ignored
                        if (connectionCallsErrorsNotIgnored.contains(stmt) || connectionCallsErrorsUnknown.contains(stmt))
                            continue;

                        if (stmt.containsInvokeExpr()) {
                            Set<SootMethod> targets = CHACallGraph.v(false).getTargetsForStmt(stmt); 

                            for (SootMethod target : targets) {                            
                                if (connectionCallsErrorsNotIgnored.contains(stmt) || connectionCallsErrorsUnknown.contains(stmt))
                                    break;

                                if (connectionMethods.containsPoly(target)) {
                                    logger.debug("Found invoke in try block of connection method: {} {} {}", method, stmt, target);

                                    //for each trap, check if the exception is one we are interested in
                                    for (SootClass ex : connectionMethodToException.get(connectionMethods.getMethod(target))) {
                                        int retValue = 
                                                findAndTestAllHandlers(body, ex, stmt, new HashSet<StmtAndException>(),
                                                    new HashMap<StmtAndException, Integer>(), 
                                                    0, new Stack<StmtEdge<SootMethod>>(), debug);

                                        switch (retValue) {
                                            case -1:
                                                logger.debug("Connection call found, but has reachable UI call in handler: {}\n", stmt);
                                                //remember we could not complete the search, and thus is never a candidate
                                                connectionCallsErrorsNotIgnored.add(stmt);
                                                //remove from candidates if a different error was ignored previously
                                                connectionCallsErrorsIgnored.remove(stmt);
                                                break;
                                            case 0:
                                                logger.debug("Connection call found, but cannot classify: {}\n", stmt);
                                                //remember we could not complete the search, and thus is never a candidate
                                                connectionCallsErrorsUnknown.add(stmt);
                                                //remove from candidates if a different error was ignored previously
                                                connectionCallsErrorsIgnored.remove(stmt);                                                                                                                                              
                                                break;                                                
                                            case 1:
                                                //for now, this is a candidate for removal, since it does not have a ui call 
                                                // in this handler, and a ui call was not found in a previous handler (see check above)
                                                logger.debug("** Connection call found with no reachable UI calls in handler: {}\n", stmt);
                                                connectionCallsErrorsIgnored.add(stmt);        
                                                break;
                                        }
                                    }
                                }
                            }
                        }                                        
                    }
                } catch (Exception e) {
                    logger.debug("Error during error handling analysis", e);
                }
            }
        }

        out.println("Connect calls unhandled (with appropriate exceptions not reported to user): " + 
                connectionCallsErrorsIgnored.size());

        for (Stmt stmt : connectionCallsErrorsIgnored) {
            InvokeExpr invoke = stmt.getInvokeExpr();

            out.printf("%s from %s\n", formatMethod(invoke.getMethodRef()), formatMethod(JimpleRelationships.v().getEnclosingMethod(stmt)));
        }

        out.println("\nConnect calls with handling unknown (either recursion depth reached or unknown thrown exception type): " +
                connectionCallsErrorsUnknown.size());

        for (Stmt stmt : connectionCallsErrorsUnknown) {
            InvokeExpr invoke = stmt.getInvokeExpr();

            out.printf("%s from %s\n", formatMethod(invoke.getMethodRef()), formatMethod(JimpleRelationships.v().getEnclosingMethod(stmt)));
        }


        out.println("\nConnect calls handled (trigger possible ui call): " +
                connectionCallsErrorsNotIgnored.size());

        for (Stmt stmt : connectionCallsErrorsNotIgnored) {
            InvokeExpr invoke = stmt.getInvokeExpr();

            out.printf("%s from %s\n", formatMethod(invoke.getMethodRef()), formatMethod(JimpleRelationships.v().getEnclosingMethod(stmt)));
        }


        if (Config.v().debug)
            writeAllAppClasses();
        out.close();
    }

    private String formatMethod(SootMethodRef ref) {
        return formatByteCodeSignature(SootUtils.getBytecodeSignature(ref));
    }
    
    
    private String formatMethod(SootMethod method) {
        return formatByteCodeSignature(method.getBytecodeSignature());
    }

    private String formatByteCodeSignature(String byteCodeSignature) {
       
        byteCodeSignature =  byteCodeSignature.substring(1, byteCodeSignature.length() - 1);
        String classSig = byteCodeSignature.substring(0, byteCodeSignature.indexOf(": "));
        classSig = classSig.replace('.', '/');

        String methodSig = byteCodeSignature.substring(byteCodeSignature.indexOf(": ") + 2);

        return classSig + "." + methodSig;
    }

    /**
     * return 1 if we did not find any ui calls in handlers
     * return 0 if we reached recursion depth or some other unknown issue and we cannot find all handlers
     * return -1 if we found a ui handler
     */
    private int findAndTestAllHandlers(Body body, SootClass exception, Stmt stmt, Set<StmtAndException> visiting,
                                       Map<StmtAndException, Integer> visited, int depth, 
                                       Stack<StmtEdge<SootMethod>> stack,
                                       boolean debug) {        

        logger.debug("findAndTestAllHandlers: depth {} method {} stmt {} exception {}", depth, body.getMethod(), stmt, exception);          

        StmtAndException probe = new StmtAndException(stmt, exception);

        if (visited.containsKey(probe))
            return visited.get(probe).intValue();

        //currently visiting this stmt and exception higher in recursion depth, so just 
        //return that we have not found anything on this path
        if (visiting.contains(probe)) {
            return 1;
        }

        visiting.add(probe);

        //check for already visited statements, limit recursion
        if (depth > DEPTH_LIMIT) {
            logger.debug("Reached depth limit in findAllHandlers");
            visited.put(probe, 0);
            visiting.remove(probe);
            return 0;
        }

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
            
            Set<StmtEdge> srcEdges = CHACallGraph.v(false).getSourcesForMethod(body.getMethod());           
            
            //if only reflected edges and overrides api method
            SootMethod method = body.getMethod();
            
            if (CHACallGraph.v(false).hasOnlyReflectedPreds(method) &&
                    droidsafe.android.app.Hierarchy.isImplementedSystemMethod(method)) {                
                //no preds, so this exception is not handled and can cause a crash, 
                //so we label that as handled...
                visited.put(probe, -1);
                visiting.remove(probe);
                return -1;
            }
                    
            for (StmtEdge<SootMethod> se : srcEdges) {
                //if the stack is not empty then we are going down a called path from a catch
                //so make sure we are going back up it
                if (!stack.isEmpty() && !stack.peek().equals(se))
                    continue;
                    
                if (CHACallGraph.v(false).isReflectedEdge(se)) {
                    //pred is the result of a reflected call
                    //TODO: HACK!
                    // for now assume that exceptions through reflected calls are not handled, so ignore them                    
                } else {
                    //not a reflected edge
                    if (se.getV1().isConcrete()) {
                        logger.debug("recursing through edge: {}", se);
                        
                        //pop the stack since we are going back up in the stack
                        if (!stack.isEmpty()) stack.pop();
                        
                        int recurseReturn = findAndTestAllHandlers(se.getV1().getActiveBody(), exception, se.getStmt(), 
                            visiting, visited, depth + 1, stack, debug);

                        if (recurseReturn < 1) {
                            visited.put(probe, recurseReturn);
                            visiting.remove(probe);
                            return recurseReturn;
                        }
                    }
                }
            }
        } else {  
            List<Unit> trapUnits = getAllUnitsForCatch(body, firstTrap.getHandlerUnit());                        

            //check to see if there are any possible thrown exceptions, track each throw the stack            
            int retValue =  processThrownExceptions(body, exception, trapUnits, visiting, visited, new HashSet<Body>(), depth, stack, debug);
            visited.put(probe, retValue);
            visiting.remove(probe);
            return retValue;
        }

        visited.put(probe, 1);
        visiting.remove(probe);
        return 1;
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
    private int processThrownExceptions(Body body, SootClass exceptionClass, Collection<Unit> trapUnits, 
                                        Set<StmtAndException> findTestVisiting,
                                        Map<StmtAndException, Integer> findTestvisited, 
                                        Set<Body> processThrownVisiting, int depth, 
                                        Stack<StmtEdge<SootMethod>> stack, boolean debug) {

        logger.debug("processThrownExceptions: depth {} method {}", depth, body.getMethod()); 

        if (API.v().isSystemMethod(body.getMethod())) {
            logger.debug("Not traversing into system call.");
            return 1;
        }

        if (depth > DEPTH_LIMIT) {
            logger.debug("Reached recursion depth.");
            return 0;
        }

        //visiting this body in the current process thrown exception search
        if (processThrownVisiting.contains(body))
            return 1;
        
        processThrownVisiting.add(body);
        
        for (Unit currentU : trapUnits) {
            Stmt current = (Stmt)currentU;

            if (current.containsInvokeExpr()) {
                try {
                    //get targets of invoke expr
                    Set<StmtEdge<SootMethod>> targetEdges = CHACallGraph.v(false).getTargetEdgesForStmt(current);
                    
                    //check called method for thrown exceptions
                    for (StmtEdge<SootMethod> stmtEdge : targetEdges) {
                        SootMethod target = stmtEdge.getV2();
                        
                        //check for called api call
                        //is this a uiMethod?
                        if (uiMethods.containsPoly(target)) {
                            logger.debug("Found ui method call in handler {}: {}\n",  body.getMethod(), current);
                            return -1;
                        } else if (target.isConcrete()) {                                                       
                            Body targetBody = target.retrieveActiveBody();
                            stack.push(stmtEdge);
                            
                            int recurseVal = processThrownExceptions(targetBody, null, targetBody.getUnits(), 
                                findTestVisiting, findTestvisited, processThrownVisiting, depth+1, stack, debug);

                            if (recurseVal < 1)
                                return recurseVal;
                        } else if (target.isNative() || NativeMethodBuilder.v().wasNativeAppMethod(target)) {
                            //native method invoke
                            for (SootClass throwsEx : target.getExceptions()) {
                                //for each exception declared throws by the native method
                                //see if it is handled
                                logger.debug("Found call to native method {} that throws exception: {}", current.getInvokeExpr(), throwsEx);
                                //stack does not change, staying in method
                                int recurseVal = findAndTestAllHandlers(body, throwsEx, current, findTestVisiting,                                     
                                    findTestvisited, depth + 1, stack, debug);

                                if (recurseVal < 1)
                                    return recurseVal;
                            }
                        }
                    } 
                } catch (Exception e) {
                    //ignore retrieving active body exception
                }
            } else if (current instanceof ThrowStmt) {
                ThrowStmt throwStmt = (ThrowStmt) current;

                logger.debug("Found throw: {} in {}", throwStmt, body.getMethod());

                //search backwards for last def of op of throw
                Stmt lastDefOfThrownOp = SootUtils.getPrevDef(body, throwStmt, throwStmt.getOp());
                logger.debug("lastDefOfThrownOp: {}", lastDefOfThrownOp);
                SootClass reThrownType = null;

                if (lastDefOfThrownOp == null) {
                    //something we don't handle
                    logger.debug("Unknown last def of thrown exception: {}", lastDefOfThrownOp);
                    return 0;
                } else if (lastDefOfThrownOp instanceof IdentityStmt &&
                        ((IdentityStmt)lastDefOfThrownOp).getRightOp() instanceof CaughtExceptionRef) {
                    //rethrowing caught exception, use exception type of the search that got us here.
                    reThrownType = exceptionClass;
                } else if (lastDefOfThrownOp instanceof AssignStmt &&
                        ((AssignStmt)lastDefOfThrownOp).getRightOp() instanceof NewExpr) {
                    //last def is an assignment to a new object
                    //grab class from type of new expression
                    Type type = ((NewExpr)((AssignStmt)lastDefOfThrownOp).getRightOp()).getType();
                    if (type instanceof RefType) {
                        reThrownType = ((RefType)type).getSootClass();
                    }                                        
                } else {
                    logger.debug("Unknown last def of thrown exception: {}", lastDefOfThrownOp);
                }

                //don't know the type
                if (reThrownType == null) {
                    logger.debug("Don't know type of re-thrown exception");
                    return 0;
                }

                if (!Scene.v().getActiveHierarchy().isClassSubclassOfIncluding(reThrownType, throwableClass)) {
                    logger.debug("Class of rethrown exception is not an exception type: {}", reThrownType);
                }

                //stack does not change because we are not changing the called method, just start looking for 
                //exceptions                
                int recurseVal = findAndTestAllHandlers(body, reThrownType, throwStmt, findTestVisiting, 
                    findTestvisited, depth + 1, stack, debug);

                if (recurseVal < 1)
                    return recurseVal;

            }            
        }  

        return 1;
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

