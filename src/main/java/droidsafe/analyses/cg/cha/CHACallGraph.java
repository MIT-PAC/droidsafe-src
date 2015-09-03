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

package droidsafe.analyses.cg.cha;

import java.io.File;
import java.io.FileWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.jgrapht.graph.DirectedMultigraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.AssignStmt;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.NewArrayExpr;
import soot.jimple.Stmt;
import droidsafe.analyses.cg.StmtEdge;
import droidsafe.analyses.cg.collapsedcg.CollaspedCallGraph.CallToTarget;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;

/**
 * This class represents a call tree built using on class hierarchy analysis 
 * (no pta results).
 * 
 * Conservatively iterate over all methods, meaning it assumes all methods are reachable
 * initially.
 * 
 * This call graph does not account for static initializer calls.
 * 
 * It has an option to ignore class from lib classes and methods, but probably don't want to run 
 * when including the api.  However, calls from app to lib methods are included always.
 * 
 * Errors are ignored, meaning the call graph could be incomplete.
 * 
 * @author mgordon
 *
 */
public class CHACallGraph {
    /** if true, then account for reflection in the call graph conservatively but use some
     * heuristics to reduce number of spurious edges */
    private final static boolean INCLUDE_REFLECTION = true;

    private final static Logger logger = LoggerFactory.getLogger(CHACallGraph.class);

    private static CHACallGraph v;

    private DirectedMultigraph<SootMethod, StmtEdge> callgraph;

    private Map<Stmt, Set<StmtEdge<SootMethod>>> stmtToEdges;

    private Set<StmtEdge<SootMethod>> reflectedEdges;

    private boolean includeAPI;

    private SootMethod methodInvoke;

    private SootClass runnableClass;

    private CHACallGraph(boolean includeAPI) {
        runnableClass = Scene.v().getSootClass("java.lang.Runnable");
        callgraph = new DirectedMultigraph<SootMethod, StmtEdge>(StmtEdge.class);
        stmtToEdges = new LinkedHashMap<Stmt, Set<StmtEdge<SootMethod>>>();
        reflectedEdges = new HashSet<StmtEdge<SootMethod>>();
        this.includeAPI = includeAPI;
        methodInvoke = Scene.v().getMethod("<java.lang.reflect.Method: java.lang.Object invoke(java.lang.Object,java.lang.Object[])>");
        createCG();
    }

    /**
     * Return the CHA call graph. 
     * 
     * @param includeAPI If true, include API calls and methods.
     */
    public static CHACallGraph v(boolean includeAPI) {
        if (v == null || v.includeAPI != includeAPI) {
            v = new CHACallGraph(includeAPI);
        }

        return v;
    }

    public static void reset() {
        v = null;
    }

    public void dumpEdges(String fname, boolean printReflectedEdges) {        
        try (FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + fname)) {
            for (StmtEdge<SootMethod> edge : callgraph.edgeSet()) {
                if (printReflectedEdges || (!isReflectedEdge(edge))) {
                    fw.write(edge + "\n");
                }
            }
        } catch (Exception e) {

        } 
    }

    private void createCG() {
        for (SootClass clz : Scene.v().getClasses()) {
            if (!includeAPI && API.v().isSystemClass(clz))
                continue;


            for (SootMethod method : clz.getMethods()) {


                if ((!includeAPI && API.v().isSystemMethod(method)) ||
                        !method.isConcrete() || method.isAbstract() || method.isPhantom())
                    continue;

                try {                   
                    callgraph.addVertex(method);

                    Body body = method.retrieveActiveBody();                

                    Iterator<Unit> units = body.getUnits().iterator();
                    while (units.hasNext()) {
                        Unit current = units.next();

                        //check if current is a call to api call we are interested in
                        if (!(current instanceof Stmt)) 
                            continue;

                        Stmt stmt = (Stmt)current;

                        if (stmt.containsInvokeExpr()) {
                            InvokeExpr invoke = stmt.getInvokeExpr();
                            boolean debug = "getPurchases".equals(invoke.getMethodRef().name());

                            if (debug) System.out.println("Found invoke: " + method + " " + invoke);
                            try {
                                Set<SootMethod> targets = SootUtils.getTargetsCHA(invoke);

                                for (SootMethod target : targets) {
                                    if (debug) System.out.println("Concrete target: " + target);
                                    addEdge(method, target, stmt);

                                    if (INCLUDE_REFLECTION && methodInvoke.equals(target)) {
                                        logger.debug("Found reflected invoke: {} {}", method, stmt);
                                        Set<SootMethod> refTargets = getReflectedInvokeTargets(method, body, stmt);
                                        for (SootMethod refTarget : refTargets) {
                                            StmtEdge<SootMethod> newEdge = addEdge(method, refTarget, stmt);
                                            reflectedEdges.add(newEdge);
                                        }
                                    }

                                    //account for edges through runnable calls to the api. connect them through api method
                                    Collection<SootMethod> throughUserRunnableTargets = accountForUserRunnables(stmt);
                                    for (SootMethod runnableTarget : throughUserRunnableTargets) {                                        
                                        addEdge(method, runnableTarget, stmt);                                        
                                    }
                                }
                            } catch (CannotFindMethodException e) {

                            }


                        }
                    }                   
                } catch (Exception e) {
                    logger.debug("Error during CHA call graph calculation: {}", e);
                }
            }
        }
    }

    private Collection<SootMethod> accountForUserRunnables(Stmt stmt) {
        //determine invoke is to api, and if so, see if any runnables are passed
        //if so, then add then class's run() method to the return list       
        Set<SootMethod> throughAPITargets = new LinkedHashSet<SootMethod>();

        InvokeExpr ie = stmt.getInvokeExpr();


        SootMethod concrete;
        try {
            concrete = SootUtils.resolve(stmt.getInvokeExpr().getMethodRef());
        } catch (CannotFindMethodException e1) {
            logger.debug("Cannot find concrete method for in accountForUserRunnables: {}", stmt);
            return throughAPITargets;
        }

        if (API.v().isSystemMethod(concrete)) {
            for (int i = 0; i < concrete.getParameterCount(); i++) {
                if (ie.getArg(i).getType() instanceof RefType) {
                    SootClass actualClass = ((RefType)ie.getArg(i).getType()).getSootClass();
                    //logger.debug("Found api call {} with param: {}", target, actualClass);
                    if (SootUtils.getParents(actualClass).contains(runnableClass)) {                            
                        try {
                            throughAPITargets.add(actualClass.getMethod("void run()"));
                        } catch (Exception e) {
                            logger.debug("Cannot retrieve run method for runnable {} passed in API call {}", actualClass, stmt);
                        }
                    }                        
                }
            }
        }

        return throughAPITargets;
    }

    private StmtEdge<SootMethod> addEdge(SootMethod source, SootMethod target, Stmt stmt) {
        callgraph.addVertex(target);
        StmtEdge<SootMethod> newEdge = new StmtEdge<SootMethod>(source, target, stmt, false);

        callgraph.addEdge(source, target, newEdge);

        if (!stmtToEdges.containsKey(stmt)) {
            stmtToEdges.put(stmt, new LinkedHashSet<StmtEdge<SootMethod>>());
        }

        stmtToEdges.get(stmt).add(newEdge);

        return newEdge;
    }

    private Set<SootMethod> getReflectedInvokeTargets(SootMethod containingM, Body body, Stmt stmt) {
        InvokeExpr ie = stmt.getInvokeExpr();

        Set<SootMethod> targets = new LinkedHashSet<SootMethod>();

        //find number of arguments 
        int numArgs = -1;
        Stmt defOfArgsArray = SootUtils.getPrevDef(body, stmt, ie.getArg(1));

        if (defOfArgsArray instanceof AssignStmt && 
                ((AssignStmt)defOfArgsArray).getRightOp() instanceof NewArrayExpr &&
                ((NewArrayExpr)((AssignStmt)defOfArgsArray).getRightOp()).getSize() instanceof IntConstant) {
            numArgs = ((IntConstant)((NewArrayExpr)((AssignStmt)defOfArgsArray).getRightOp()).getSize()).value;
        }


        //only include method in same top level package, with same number of args
        String packageName = containingM.getDeclaringClass().getPackageName();
        int secondDot = packageName.indexOf('.', packageName.indexOf('.') + 1);
        String topLevelPackage = "";

        if (secondDot >= 0) {
            topLevelPackage =  packageName.substring(0, secondDot);
        }

        logger.info("Found reflected invoke in {} with {} args and top level package {}", containingM, numArgs, topLevelPackage);

        for (SootClass clz : Scene.v().getClasses()) {
            if (clz.getPackageName().startsWith(topLevelPackage)) {
                for (SootMethod m : clz.getMethods()) {
                    if (m.getParameterCount() == numArgs || numArgs == -1) {
                        targets.add(m);
                    }
                }
            }
        }

        return targets;
    }

    public Set<StmtEdge> getSourcesForMethod(SootMethod method) {
        if (callgraph.containsVertex(method)) {
            return callgraph.incomingEdgesOf(method);
        } else
            return Collections.emptySet();

    }

    public Set<StmtEdge> getTargetsForMethod(SootMethod method) {
        if (callgraph.containsVertex(method)) {
            return callgraph.outgoingEdgesOf(method);
        } else
            return Collections.emptySet();
    }

    public Set<StmtEdge<SootMethod>> getTargetEdgesForStmt(Stmt stmt) {
        if (stmtToEdges.containsKey(stmt)) {
            return stmtToEdges.get(stmt);                
        } else
            return Collections.emptySet();
    }

    public Set<SootMethod> getTargetsForStmt(Stmt stmt) {
        if (stmtToEdges.containsKey(stmt)) {
            Set<StmtEdge<SootMethod>> edges =
                    stmtToEdges.get(stmt); 
            Set<SootMethod> targets = new LinkedHashSet<SootMethod>();
            for (StmtEdge<SootMethod> edge : edges) {
                targets.add(edge.getV2());
            }

            return targets;
        } else
            return Collections.emptySet();
    }

    public BreadthFirstIterator<SootMethod,StmtEdge> getBreadthFirstTraversalFrom(SootMethod startVertex) {
        BreadthFirstIterator<SootMethod,StmtEdge> bfi = 
                new BreadthFirstIterator<SootMethod,StmtEdge>(callgraph, startVertex);

        return bfi;
    }

    /**
     * Returns all system methods called from method, does not prune the list based
     * on API.v().isInterestingMethod().
     */
    public Set<SootMethod> getAPICallTargets(SootMethod method) {
        Set<StmtEdge> allTargets = getTargetsForMethod(method);
        Set<SootMethod> apiTargets = new LinkedHashSet<SootMethod>();
        for (StmtEdge<SootMethod> edge : allTargets) {
            if (API.v().isSystemMethod(edge.getV2()))
                apiTargets.add(edge.getV2());
        }

        return apiTargets;
    }

    /**
     * Return true if the edge was added as a result of a reflected call.
     */
    public boolean isReflectedEdge(StmtEdge<SootMethod> e) {
        return reflectedEdges.contains(e);
    }

    /**
     * Return true if all incoming (pred) edges to this method are reflected 
     * edges.   Good indicator that this is an entry method?
     */
    public boolean hasOnlyReflectedPreds(SootMethod m) {
        for (StmtEdge<SootMethod> e : getSourcesForMethod(m)) {
            if (!isReflectedEdge(e)) 
                return false;
        }

        //didn't find any non-reflected edges
        return true;
    }
}
