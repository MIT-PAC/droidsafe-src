/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package droidsafe.analyses.errorhandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Arrays;
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
import soot.Local;
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
import soot.jimple.ReturnStmt;
import soot.jimple.ReturnVoidStmt;
import soot.jimple.Stmt;
import soot.jimple.ThrowStmt;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.scalar.SimpleLocalDefs;
import droidsafe.analyses.CatchBlocks;
import droidsafe.analyses.cg.StmtEdge;
import droidsafe.analyses.cg.cha.CHACallGraph;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.main.Config;
import droidsafe.main.Main;
import droidsafe.transforms.NativeMethodBuilder;
import droidsafe.transforms.objsensclone.CloneInheritedMethods;
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
    private Set<Stmt> connectionCallsSuccessForwardHasUI = new LinkedHashSet<Stmt>();
    private Set<Stmt> connectionCallsSuccessForwardNoUI = new LinkedHashSet<Stmt>();
    private Set<Stmt> connectionCallsSuccessBackwardHasUI = new LinkedHashSet<Stmt>();
    private Set<Stmt> connectionCallsSuccessBackwardNoUI = new LinkedHashSet<Stmt>();  
    private PrintStream out;
    private SootClass throwableClass;   
    private final int DEPTH_LIMIT = 120; 
    private SootClass runnableClass;
    private boolean DEBUG = false;
    
    private Set<SootClass> ADD_TYPE_SENSITIVITY_TO_CHILDREN;
    
    private void initAddTypeSensList() {
        HashSet<SootClass> addTypeSens = new HashSet<SootClass>();
        
        addTypeSens.add(Scene.v().getSootClass("android.os.AsyncTask"));
        
        ADD_TYPE_SENSITIVITY_TO_CHILDREN = addTypeSens;
    }    

    private ErrorHandlingAnalysis() {
        throwableClass = Scene.v().getSootClass("java.lang.Throwable");
        runnableClass = Scene.v().getSootClass("java.lang.Runnable");
        initAddTypeSensList();
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
    
    private void cloneInheritedMethodsForUserClasses() {
        for (SootClass clz : Scene.v().getClasses()) {
            boolean hasInterestingParent = false;
            for (SootClass parent : SootUtils.getParents(clz)) {
                if (ADD_TYPE_SENSITIVITY_TO_CHILDREN.contains(parent)) {
                    hasInterestingParent = true;
                    break;
                }
            }
            
            if (hasInterestingParent && !API.v().isSystemClass(clz)) {
                CloneInheritedMethods cim = new CloneInheritedMethods(clz, true, false);
                System.out.println("Adding type sensitivity to " + clz);
                cim.transform();
            }
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
        
        cloneInheritedMethodsForUserClasses();
        System.out.println("Done cloning inherited methods...");
        
        JimpleRelationships.reset();
        
        CHACallGraph.v(false);
        System.out.println("Done calculating callgraph (CHA)...");

        //CHACallGraph.v(false).dumpEdges("cha-callgraph-no-reflection.txt", false);

        for (SootClass clz : Scene.v().getClasses()) {

            for (SootMethod method : clz.getMethods()) {
                if (API.v().isSystemMethod(method))
                    continue;

                if (method.isPhantom() || method.isAbstract() || !method.isConcrete())
                    continue;

                boolean debug = "onServiceConnected".equals(method.getName());
                
                //DEBUG = method.getSignature().equals("<com.google.android.gms.internal.ck$a$a: void onDestroy()>");
                if (DEBUG) System.out.println("DEBUG");

                logger.debug("ErrorHandlingAnalysis inspecting: {}", method);
                
                try {
                    Body body = method.retrieveActiveBody();                

                    Iterator<Unit> unitIt = body.getUnits().snapshotIterator();
                                      
                    while (unitIt.hasNext()) {
                        Unit current = unitIt.next(); 
                                
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

                                if (connectionMethods.containsPoly(target)) {
                                    logger.debug("Found invoke in try block of connection method: {} {} {}", method, stmt, target);
                                                                                                         
                                    //for each trap, check if the exception is one we are interested in
                                    Set<SootMethod> backwardVisitedMethods = new HashSet<SootMethod>();
                                    
                                    for (SootClass ex : connectionMethodToException.get(connectionMethods.getMethod(target))) {                                        
                                        if (connectionCallsErrorsNotIgnored.contains(stmt) || connectionCallsErrorsUnknown.contains(stmt))
                                            break;
                                       
                                        if (DEBUG) System.out.println("==== " + target + " " + ex);
                                        
                                        int retValue = 
                                                findAndTestAllHandlers(body, ex, stmt, new HashSet<StmtAndException>(),
                                                    new HashMap<StmtAndException, Integer>(), backwardVisitedMethods, 
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
                                    
                                    if (DEBUG) System.out.println("Forward Search");
                                    
                                    //search forward to model success path
                                    boolean foundUIOnSuccessForward = 
                                            successSearchFromMethod(body, stmt, 0 , new HashSet<SootMethod>());
                                    if (foundUIOnSuccessForward) {
                                        connectionCallsSuccessForwardHasUI.add(stmt);
                                        connectionCallsSuccessForwardNoUI.remove(stmt);
                                    } else if (!connectionCallsSuccessForwardHasUI.contains(stmt)) {
                                        connectionCallsSuccessForwardNoUI.add(stmt);                                        
                                    }    
                                    
                                    //search backwards starting at each method that we visited in the
                                    //error handling search
                                    if (DEBUG) System.out.printf("====== Starting success search backwards from %s %s\n", stmt, method);
                                    
                                    boolean foundUIOnSuccessBackward = 
                                            successSearchBackward(method, stmt, backwardVisitedMethods, 
                                                new HashSet<SootMethod>(), 0);
                                    
                                    if (foundUIOnSuccessBackward) {
                                        connectionCallsSuccessBackwardHasUI.add(stmt);
                                        connectionCallsSuccessBackwardNoUI.remove(stmt);
                                    } else if (!connectionCallsSuccessBackwardHasUI.contains(stmt)) {
                                        connectionCallsSuccessBackwardNoUI.add(stmt);                                        
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

        out.println("Call with errors unhandled (with appropriate exceptions not reported to user): " + 
                connectionCallsErrorsIgnored.size());

        for (Stmt stmt : connectionCallsErrorsIgnored) {
            InvokeExpr invoke = stmt.getInvokeExpr();

            out.printf("%s from %s\n", formatMethod(invoke.getMethodRef()), formatMethod(JimpleRelationships.v().getEnclosingMethod(stmt)));
        }

        out.println("\nCalls with error handling unknown (either recursion depth reached or unknown thrown exception type): " +
                connectionCallsErrorsUnknown.size());

        for (Stmt stmt : connectionCallsErrorsUnknown) {
            InvokeExpr invoke = stmt.getInvokeExpr();

            out.printf("%s from %s\n", formatMethod(invoke.getMethodRef()), formatMethod(JimpleRelationships.v().getEnclosingMethod(stmt)));
        }


        out.println("\nCalls with errors handled (trigger possible ui call): " +
                connectionCallsErrorsNotIgnored.size());

        for (Stmt stmt : connectionCallsErrorsNotIgnored) {
            InvokeExpr invoke = stmt.getInvokeExpr();

            out.printf("%s from %s\n", formatMethod(invoke.getMethodRef()), formatMethod(JimpleRelationships.v().getEnclosingMethod(stmt)));
        }

        
        out.println("\nCalls with UI effect (UI call) on success forward path: " +
                connectionCallsSuccessForwardHasUI.size());

        for (Stmt stmt : connectionCallsSuccessForwardHasUI) {
            InvokeExpr invoke = stmt.getInvokeExpr();

            out.printf("%s from %s\n", formatMethod(invoke.getMethodRef()), formatMethod(JimpleRelationships.v().getEnclosingMethod(stmt)));
        }
        
        out.println("\nCalls with NO UI effect (UI call) on success forward path: " +
                connectionCallsSuccessForwardNoUI.size());

        for (Stmt stmt : connectionCallsSuccessForwardNoUI) {
            InvokeExpr invoke = stmt.getInvokeExpr();

            out.printf("%s from %s\n", formatMethod(invoke.getMethodRef()), formatMethod(JimpleRelationships.v().getEnclosingMethod(stmt)));
        }
        
        //backward success
        out.println("\nCalls with UI effect (UI call) on success backward path: " +
                connectionCallsSuccessBackwardHasUI.size());

        for (Stmt stmt : connectionCallsSuccessBackwardHasUI) {
            InvokeExpr invoke = stmt.getInvokeExpr();

            out.printf("%s from %s\n", formatMethod(invoke.getMethodRef()), formatMethod(JimpleRelationships.v().getEnclosingMethod(stmt)));
        }
        
        out.println("\nCalls with NO UI effect (UI call) on success backward path: " +
                connectionCallsSuccessBackwardNoUI.size());

        for (Stmt stmt : connectionCallsSuccessBackwardNoUI) {
            InvokeExpr invoke = stmt.getInvokeExpr();

            out.printf("%s from %s\n", formatMethod(invoke.getMethodRef()), formatMethod(JimpleRelationships.v().getEnclosingMethod(stmt)));
        }

        if (Config.v().debug) {
            soot.options.Options.v().set_ignore_resolution_errors(false);
            writeAllAppClasses();
        }
        out.close();
    }
    
    
    private boolean successSearchBackward(SootMethod method, Stmt callingStmt, Set<SootMethod> visitedOnErrorHandling, 
                                          Set<SootMethod> visiting, int depth) {
        if (API.v().isSystemMethod(method)) {
            logger.debug("Not traversing into system call.");
            return false;
        }

        if (depth > DEPTH_LIMIT) {
            logger.debug("Reached recursion depth.");
            if (DEBUG) System.out.println("Reached recursion depth");
            //decided that if we reach recursion depth the probably the ui call is unrelated.
            return false;
        }
        
        if (visiting.contains(method))
            return false;
        
        visiting.add(method);
        
        if (DEBUG) System.out.println("Visiting on success backwards: " + method);
             
        //find all statement reachable from callingStmt
        for (Stmt reachable : SootUtils.getReachableStmts(method, callingStmt)) {
            if (reachable.containsInvokeExpr()) {
                if (DEBUG) System.out.println("\tFound reachable call stmt: " + reachable);
                try {
                    //get targets of invoke expr
                    Set<StmtEdge<SootMethod>> targetEdges = CHACallGraph.v(false).getTargetEdgesForStmt(reachable);

                    //check called method for thrown exceptions
                    for (StmtEdge<SootMethod> stmtEdge : targetEdges) {
                        SootMethod target = stmtEdge.getV2();

                        //ignore reflection edges?
                        if (CHACallGraph.v(false).isReflectedEdge(stmtEdge))
                            continue;
                        
                        if (uiMethods.containsPoly(target)) {
                            logger.debug("In success search backwards, found ui method call in {}: {}\n",  method, reachable);
                            if (DEBUG) System.out.printf("Success search backwards: %s calls %s\n", method, reachable);
                            return true;
                        }
                    }
                } catch (Exception e) {
                    logger.debug("Error in backward success search, ignoring", e);
                }
            }
        }
        
        //recurse for all callers
        for (StmtEdge<SootMethod> edge : CHACallGraph.v(false).getSourcesForMethod(method)) {
            //ignore reflected edges
            if (CHACallGraph.v(false).isReflectedEdge(edge))
                continue;
            
            //don't visit anything that was not visited on the error handling path
            //used to stop backward search when the paths "converge"
            if (!visitedOnErrorHandling.contains(edge.getV1()))
                continue;
            
            boolean retValue = successSearchBackward(edge.getV1(), edge.getStmt(), visitedOnErrorHandling,
                visiting, depth + 1);
            
            if (retValue)
                return true;
        }
        
        return false;
    }
    
    
    /**
     * 
     *
     * @param body
     *
     * @param connectionStmt If not null, then it is the start of a search, and a connection call statement
     * defines the trap units we should ignore, otherwise it is null
     *
     * @return True if a UI method is found on the success path, false if no ui method found
     */
    private boolean successSearchFromMethod(Body body, Stmt connectionStmt, int depth, Set<SootMethod> visiting) {
        if (API.v().isSystemMethod(body.getMethod())) {
            logger.debug("Not traversing into system call.");
            return false;
        }

        if (depth > DEPTH_LIMIT) {
            logger.debug("Reached recursion depth.");
            if (DEBUG) System.out.println("Reached recursion depth");
            //decided that if we reach recursion depth the probably the ui call is unrelated.
            return false;
        }
        
        
        if (visiting.contains(body.getMethod()))
            return false;
        
        visiting.add(body.getMethod());
        
        if (DEBUG) System.out.println("Looking at method: " + body.getMethod());
        
        //find all traps for connection statement, discount all statements in those traps
        Set<Unit> unitsInTrap = new HashSet<Unit>();
        Map<Unit, List<Trap>> unitToTraps = getUnitToTrapMap(body);

        if (unitToTraps.get(connectionStmt) != null) {
            for (Trap trap : unitToTraps.get(connectionStmt)) {   
                Collection<Unit> trapUnits = getAllUnitsForCatch(body, trap.getHandlerUnit());
                unitsInTrap.addAll(trapUnits);
            }
        }
        
        //for each call statement that is not in a handler, start search from there for ui calls
        Iterator<Unit> unitIt = body.getUnits().snapshotIterator();                          
        while (unitIt.hasNext()) {
            Unit currentU = unitIt.next(); 
            
            //ignore units in handler of connection statement
            if (unitsInTrap.contains(currentU))
                continue;
            
            //check if current is a call to api call we are interested in
            if (!(currentU instanceof Stmt)) 
                continue;

            Stmt stmt = (Stmt)currentU;
            
            if (stmt.containsInvokeExpr()) {
                try {
                    //get targets of invoke expr
                    Set<StmtEdge<SootMethod>> targetEdges = CHACallGraph.v(false).getTargetEdgesForStmt(stmt);

                    //check called method for thrown exceptions
                    for (StmtEdge<SootMethod> stmtEdge : targetEdges) {
                        SootMethod target = stmtEdge.getV2();

                        //ignore reflection edges?
                        if (CHACallGraph.v(false).isReflectedEdge(stmtEdge))
                            continue;
                        
                        if (uiMethods.containsPoly(target)) {
                            logger.debug("In success search, found ui method call in {}: {}\n",  body.getMethod(), stmt);
                            if (DEBUG) System.out.printf("Success search: %s calls %s\n", body.getMethod(), stmt);
                            return true;
                        } else if (target.isConcrete()) {
                            Body targetBody = null;
                            try {
                                targetBody = target.retrieveActiveBody();
                            } catch (Exception e) {
                                continue;
                            }
                            if (DEBUG) System.out.println("Recursing edge: " + stmtEdge);
                            boolean recurseVal = successSearchFromMethod(targetBody, null, depth + 1, visiting); 
                            if (recurseVal) {
                                return true;
                            }
                        }
                    }
                } catch (Exception e) {
                    //ignore retrieving active body exception
                    logger.debug("Exception: ", e);
                }
            }
        }
        
        //didn't find a ui method
        return false;
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
                                       Map<StmtAndException, Integer> visited, Set<SootMethod> visitedBackwardMethods, 
                                       int depth, 
                                       Stack<StmtEdge<SootMethod>> stack,
                                       boolean debug) {        

        logger.debug("findAndTestAllHandlers: depth {} method {} stmt {} exception {}", depth, body.getMethod(), stmt, exception);          

        StmtAndException probe = new StmtAndException(stmt, exception);
        
        visitedBackwardMethods.add(body.getMethod());

        if (visited.containsKey(probe)) {
            logger.debug("Already visited: {} {}", stmt, exception);
            return visited.get(probe).intValue();
        }

        //currently visiting this stmt and exception higher in recursion depth, so just 
        //return that we have not found anything on this path
        if (visiting.contains(probe)) {
            logger.debug("Currently visiting: {} {}", stmt, exception);
            return 1;
        }

        visiting.add(probe);

        //limit recursion
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
                logger.debug("Testing trap: trap type {}, exception type {}", trap.getException(), exception);
                if (Scene.v().getActiveHierarchy().isClassSubclassOfIncluding(exception, trap.getException())) {
                    firstTrap = trap;
                    break;
                }
            }
        }        

        if (firstTrap == null) {    
            logger.debug("Could not find local handler...");
            //could not find a trap in enclosing method for this exception
            //need to search up the stack...
            //find all calling statements

            Set<StmtEdge> srcEdges = CHACallGraph.v(false).getSourcesForMethod(body.getMethod());           

            //if only reflected edges and overrides api method
            SootMethod method = body.getMethod();

            if (isThreadRun(method)  || (CHACallGraph.v(false).hasOnlyReflectedPreds(method) &&
                    droidsafe.android.app.Hierarchy.isImplementedSystemMethod(method))) {                
                //no preds, so this exception is not handled and can cause a crash, 
                //so we label that as handled...
                logger.debug("No preds and is an implemented system method, so handles by app exit: {}", method);
                visited.put(probe, -1);
                visiting.remove(probe);              
                return -1;
            }

            for (StmtEdge<SootMethod> se : srcEdges) {
                //if the stack is not empty then we are going down a called path from a catch
                //so make sure we are going back up it
                logger.debug("SrcEdge: {}", se);
                if (!stack.isEmpty()) logger.debug("stack peek: {} ", stack.peek());
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
                        Stack<StmtEdge<SootMethod>> newStack = new Stack<StmtEdge<SootMethod>>();
                        newStack.addAll(stack);

                        if (!newStack.isEmpty()) newStack.pop();

                        int recurseReturn = findAndTestAllHandlers(se.getV1().getActiveBody(), exception, se.getStmt(), 
                            visiting, visited, visitedBackwardMethods, depth + 1, newStack, debug);

                        if (recurseReturn < 1) {
                            visited.put(probe, recurseReturn);
                            visiting.remove(probe);
                            return recurseReturn;
                        }
                    }
                }
            }
        } else {  
            logger.debug("Found trap: {}, first statement {}", firstTrap.getException(), firstTrap.getHandlerUnit());
            Collection<Unit> trapUnits = getAllUnitsForCatch(body, firstTrap.getHandlerUnit());                        
            
            for (Unit u : trapUnits) {
                logger.debug("\t{}", u);
            }
            
            //check to see if there are any possible thrown exceptions, track each throw the stack            
            int retValue =  searchForward(body, trapUnits.iterator(), visiting, visited, visitedBackwardMethods, 
                new HashSet<Body>(), depth, stack, debug);
            logger.debug("back from processThrownExceptions: {}", retValue);
            visited.put(probe, retValue);
            visiting.remove(probe);
            return retValue;
        }

        visited.put(probe, 1);
        visiting.remove(probe);
        return 1;
    }

   
    
    /**
     * Who knows at this point.
     */
    private int searchForward(Body body, Iterator<Unit> trapUnits, 
                                        Set<StmtAndException> findTestVisiting,
                                        Map<StmtAndException, Integer> findTestvisited, 
                                        Set<SootMethod> visitedBackwardMethods,
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
        //TODO, this needs to change
        if (processThrownVisiting.contains(body))
            return 1;

        processThrownVisiting.add(body);

        while (trapUnits.hasNext()) {
            Unit currentU = trapUnits.next(); 
            Stmt current = (Stmt)currentU;

            logger.debug("Reachable statement: {}", current);
            
            if (current.containsInvokeExpr()) {
                try {
                    //get targets of invoke expr
                    Set<StmtEdge<SootMethod>> targetEdges = CHACallGraph.v(false).getTargetEdgesForStmt(current);

                    //check called method for thrown exceptions
                    for (StmtEdge<SootMethod> stmtEdge : targetEdges) {
                        SootMethod target = stmtEdge.getV2();

                        
                        if (uiMethods.containsPoly(target)) {
                            logger.debug("Found ui method call in handler {}: {}\n",  body.getMethod(), current);
                            return -1;
                        } else if (target.isConcrete()) {
                            Body targetBody = null;
                            try {
                                targetBody = target.retrieveActiveBody();
                            } catch (Exception e) {
                                continue;
                            }

                            Stack<StmtEdge<SootMethod>> newStack = new Stack<StmtEdge<SootMethod>>();
                            newStack.addAll(stack);
                            newStack.push(stmtEdge);

                            int recurseVal = searchForward(targetBody, targetBody.getUnits().snapshotIterator(), 
                                findTestVisiting, findTestvisited, visitedBackwardMethods, processThrownVisiting, depth+1, newStack, debug);                         

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
                                    findTestvisited, visitedBackwardMethods, depth + 1, stack, debug);

                                if (recurseVal < 1)
                                    return recurseVal;
                            }
                        }
                    } 
                } catch (Exception e) {
                    //ignore retrieving active body exception
                    logger.debug("Exception: ", e);
                }
            } else if (current instanceof ThrowStmt) {
                ThrowStmt throwStmt = (ThrowStmt) current;

                logger.debug("Found throw: {} in {}", throwStmt, body.getMethod());

                //search backwards for last def of op of throw
                Stmt lastDefOfThrownOp = SootUtils.getPrevDef(body, throwStmt, throwStmt.getOp());
                logger.debug("lastDefOfThrownOp: {}", lastDefOfThrownOp);
                Collection<SootClass> reThrownTypes = null;

                if (lastDefOfThrownOp == null) {
                    //something we don't handle
                    logger.debug("Unknown last def of thrown exception: {}", lastDefOfThrownOp);
                    /*
                    return 0;
                    */
                    //just use the type of the op
                    reThrownTypes = new LinkedHashSet<SootClass>();
                    reThrownTypes.add(((RefType)throwStmt.getOp().getType()).getSootClass());                    
                } else if (lastDefOfThrownOp instanceof IdentityStmt &&
                        ((IdentityStmt)lastDefOfThrownOp).getRightOp() instanceof CaughtExceptionRef) {
                    //rethrowing caught exception, use exception type of the search that got us here.
                    reThrownTypes = getPossibleThrownExceptions(body, getTryBlockForFirstTrapUnit(body, (IdentityStmt)lastDefOfThrownOp));
                } else if (lastDefOfThrownOp instanceof AssignStmt &&
                        ((AssignStmt)lastDefOfThrownOp).getRightOp() instanceof NewExpr) {
                    //last def is an assignment to a new object
                    //grab class from type of new expression
                    Type type = ((NewExpr)((AssignStmt)lastDefOfThrownOp).getRightOp()).getType();
                    reThrownTypes = new LinkedHashSet<SootClass>();
                    if (type instanceof RefType) {
                        reThrownTypes.add(((RefType)type).getSootClass());
                    }                                        
                } else {
                    logger.debug("Unknown last def of thrown exception: {}", lastDefOfThrownOp);
                }

                //don't know the type
                if (reThrownTypes == null) {
                    logger.debug("Don't know type of re-thrown exception");
                    return 0;
                }

                for (SootClass reThrownType : reThrownTypes) {
                    if (!Scene.v().getActiveHierarchy().isClassSubclassOfIncluding(reThrownType, throwableClass)) {
                        logger.debug("Class of rethrown exception is not an exception type: {}", reThrownType);
                    }

                    //stack does not change because we are not changing the called method, just start looking for 
                    //exceptions                
                    int recurseVal = findAndTestAllHandlers(body, reThrownType, throwStmt, findTestVisiting, 
                        findTestvisited, visitedBackwardMethods, depth + 1, stack, debug);

                    if (recurseVal < 1)
                        return recurseVal;
                }

            }            
        }  

        return 1;
    }

    private Set<SootClass> getPossibleThrownExceptions(Body containingBody, List<Unit> units) {
        //loop over all units and see what they could possibly throw
        //so really all we care about is throw statment and method calls (the exceptions declared to be throws)
        Set<SootClass> possibleThrown = new LinkedHashSet<SootClass>();

        UnitGraph unitGraph  = new ExceptionalUnitGraph(containingBody);
        SimpleLocalDefs simpleLocalDefs = new SimpleLocalDefs(unitGraph);

        for (Unit u : units) {
            Stmt stmt = (Stmt)u;

            if (stmt instanceof ThrowStmt) {
                ThrowStmt throwStmt = (ThrowStmt)stmt;
                if (!(throwStmt.getOp() instanceof Local)) {
                    logger.debug("Op of throw is not Local: {}", throwStmt.getOp());
                    continue;
                    //return null;
                }

                List<Unit> defUnits = simpleLocalDefs.getDefsOfAt((Local)throwStmt.getOp(), throwStmt);

                for (Unit def : defUnits) {
                    if (def instanceof AssignStmt &&
                            ((AssignStmt)def).getRightOp() instanceof NewExpr &&
                            ((NewExpr)((AssignStmt)def).getRightOp()).getType() instanceof RefType) {
                        //last def is an assignment to a new object
                        //grab class from type of new expression
                        logger.debug("Found def of throw, assignment to new: {}", def);
                        Type type = ((NewExpr)((AssignStmt)def).getRightOp()).getType();                      
                        possibleThrown.add(((RefType)type).getSootClass());
                    } else if (def instanceof IdentityStmt &&
                            ((IdentityStmt)def).getRightOp() instanceof CaughtExceptionRef) {
                        //last def is another @caughtexception
                        logger.debug("Found def of throw, caught exception: {}", def);
                        possibleThrown.addAll(getPossibleThrownExceptions(containingBody, getTryBlockForFirstTrapUnit(containingBody, (IdentityStmt)def)));
                    } else {
                        logger.debug("Don't support def of thrown exception op: {}", def);
                        return null;
                    }
                }   

            } else if (stmt.containsInvokeExpr()) {
              //methods
                InvokeExpr invoke = stmt.getInvokeExpr();
                
                for (SootMethod target : CHACallGraph.v(false).getTargetsForStmt(stmt)) {
                    for (SootClass throwsEx : target.getExceptions()) {
                        SootClass concrete = throwsEx;
                        
                        if (throwsEx.isAbstract() || throwsEx.isInterface())
                            concrete = SootUtils.getCloseConcrete(throwsEx);
                            
                        possibleThrown.add(concrete);
                        /*
                        //add all concrete plus the type
                      //don't really know the type, be conservative and for method calls find all implementors and subclasses
                        List<SootClass> compatibleClasses;
                        if (throwsEx.isInterface()) {
                            compatibleClasses = Scene.v().getActiveHierarchy().getImplementersOf(throwsEx);
                        } else {
                            compatibleClasses = Scene.v().getActiveHierarchy().getSubclassesOfIncluding(throwsEx);
                        }
                        
                        for (SootClass cc : compatibleClasses) {
                            if (cc.isConcrete() && !cc.isInterface()) {
                                possibleThrown.add(cc);
                            }
                        }
                        */
                    }
                }
            }
        }

        return possibleThrown;
    }


    private List<Unit> getTryBlockForFirstTrapUnit(Body b, IdentityStmt u) {
        List<Unit> tryUnits = new LinkedList<Unit>();
        boolean foundGTOneTrap = false;
        for (Trap trap : b.getTraps()) {
            if (trap.getHandlerUnit().equals(u)) {
                foundGTOneTrap = true;                
                Iterator<Unit> unitsIt = b.getUnits().iterator(trap.getBeginUnit(), b.getUnits().getPredOf(trap.getEndUnit()));
                while (unitsIt.hasNext()) {
                    tryUnits.add(unitsIt.next());
                }                
                
            }
        }
        if (!foundGTOneTrap)
            logger.debug("Could not find try block for trap first unit: {} in {}", u, b.getMethod()); 
        logger.debug("Found associated try");
        for (Unit c : tryUnits) {
            logger.debug("{}", c);
        }
        return tryUnits;
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

    static Collection<Unit> getAllUnitsForCatch(Body body, Unit startCatch) {
        ExceptionalUnitGraph cfg = new ExceptionalUnitGraph(body);
        List<Unit> catchBlock = new LinkedList<Unit>();
        catchBlock.add(startCatch);

        //calculate reachable units to color instructions
        Set<Unit> reachableUnits = new HashSet<Unit>();
        getReachableUnits(cfg, startCatch, reachableUnits);

        for (Unit current : reachableUnits) {
            boolean allColored = true;
            for (Unit pred : cfg.getUnexceptionalPredsOf(current)) {
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

        //logger.debug("Adding reachable unit: {}", current);
        reachable.add(current);

        for (Unit next : cfg.getUnexceptionalSuccsOf(current)) {
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

    boolean isThreadRun(SootMethod method) {
        return (SootUtils.getParents(method.getDeclaringClass()).contains(runnableClass)) && 
                "void run()".equals(method.getSubSignature());    
    }

}

