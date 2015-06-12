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

package droidsafe.transforms;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.Local;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.Value;
import soot.ValueBox;
import soot.jimple.AssignStmt;
import soot.jimple.CastExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.StaticFieldRef;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.util.Chain;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.system.API;
import droidsafe.main.Config;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.DroidsafeExecutionStatus;
import droidsafe.utils.IDroidsafeProgressMonitor;
import droidsafe.utils.SootUtils;
import droidsafe.main.Main;

/**
 * 
 * 
 * @author mgordon
 *
 */
public class InsertUnmodeledObjects {
    private final static Logger logger = LoggerFactory.getLogger(InsertUnmodeledObjects.class);
    /** Static singleton */
    private static InsertUnmodeledObjects v;
    private static final int NUM_PASSES = 5;
    private boolean firstRun = true;

    private InsertUnmodeledObjects() {
        // TODO Auto-generated constructor stub
    }

    /**
     * return static singleton
     */
    public static InsertUnmodeledObjects v() {
        if (v == null)
            v = new InsertUnmodeledObjects();

        return v;
    }

    /**
     * Run transformation to insert dummy object with UNKNOWN taint at all api method that return a 
     * reference with an empty points to set.
     */
    public void run(IDroidsafeProgressMonitor monitor) {
        try {
            
            if (Config.v().multipassfb) {
                for (int i = 0; i < NUM_PASSES; i++) {        
                    //run pta first
                    Main.afterTransformPrecise(monitor, false, 2); 
                    
                    int numChanges = findAPICallsWithNullReturnValues();
                    firstRun = false;
                    System.out.printf("Ran fallback API object insertion phase %d with %d objects created.\n", 
                        i, numChanges);    
                    
                    if (numChanges == 0)
                        break;
                }                
            } else {
                //single pass of fallback modeling to insert unmodeled objects
                
                //run pta
                Main.afterTransformPrecise(monitor, false, 2); 
                
                findAPICallsWithNullReturnValues();
                firstRun = false;
            }
            
            //find fields of components created in harness main that reference other user components
            //and that are null in the pta, and force an assignment to the appropriate field in the harness 
            fixUpUserRefsToComponents();
        } catch (Exception e) {
            //keep working but report error to console
            logger.warn("Error during InsertUnmodeledObjects.  Continuing...", e);
        }
    }

    private void fixUpUserRefsToComponents() throws Exception {
        //for each created component in the main
        int localID = 0;

        for (SootClass created : Harness.v().getCreatedClasses()) {
            if (created.isInterface() || !Hierarchy.isAndroidComponentClass(created))
                continue;

            //find fields that reference other classes that are user and components
            for (SootField fieldOfComp : created.getFields()) {
                if (!(fieldOfComp.getType() instanceof RefType))
                    continue;
                SootClass refClass = ((RefType)fieldOfComp.getType()).getSootClass();

                //System.out.println("Searching " + refClass);


                if (refClass.isInterface() || API.v().isSystemClass(refClass) || 
                        !Hierarchy.isAndroidComponentClass(refClass) ||
                        !Harness.v().getCreatedClasses().contains(refClass))
                    continue;

                SootField fieldOfMain = Harness.v().getFieldForCreatedClass(created);
                StaticFieldRef sfr = Jimple.v().newStaticFieldRef(fieldOfMain.makeRef());

                //System.out.println("Field in main: " + fieldOfMain);
                //System.out.println("Field of comp: " + fieldOfComp);

                //find all allocnodes of created
                boolean oneEmpty = false;

                for (IAllocNode node : PTABridge.v().getPTSetIns(sfr)) {

                    if (fieldOfComp.isStatic()) {
                        if (PTABridge.v().getPTSetIns(Jimple.v().newStaticFieldRef(fieldOfComp.makeRef())).isEmpty()) {
                            oneEmpty = true;
                            break;
                        }
                    } else {
                        if (PTABridge.v().getPTSet(node, fieldOfComp).isEmpty()) {
                            oneEmpty = true;
                            break;
                        }
                    }
                }

                if (!oneEmpty)
                    continue;

                SootField otherFieldOfMain = Harness.v().getFieldForCreatedClass(refClass);   

                //System.out.printf("%s.%s = %s\n", fieldOfMain, fieldOfComp, otherFieldOfMain);

                //if we are here, we found a component field of a component that is possibly null
                //so add an explicit assignment

                //fieldOfMain.fieldofComp = anotherFieldOfMain

                //l = fieldOfMain
                localID++;
                Local l = Jimple.v().newLocal("_$comp_link_l_" + localID, fieldOfMain.getType());
                Harness.v().addLocalToMain(l);
                AssignStmt assign1 = Jimple.v().newAssignStmt(l, sfr);
                Harness.v().addStmtToEndOfMainLoop(assign1);

                //r = otherfieldofMain
                Local r = Jimple.v().newLocal("_$comp_link_r" + localID, fieldOfComp.getType());
                Harness.v().addLocalToMain(r);
                AssignStmt assign2 = Jimple.v().newAssignStmt(r, Jimple.v().newStaticFieldRef(otherFieldOfMain.makeRef()));
                Harness.v().addStmtToEndOfMainLoop(assign2);

                //l.fieldOfComp = r  

                AssignStmt assign3;
                if (fieldOfComp.isStatic()) {
                    assign3 = Jimple.v().newAssignStmt(Jimple.v().newStaticFieldRef(fieldOfComp.makeRef()), r);
                } else {
                    assign3 = Jimple.v().newAssignStmt(
                        Jimple.v().newInstanceFieldRef(l, fieldOfComp.makeRef()), 
                        r);
                }
                Harness.v().addStmtToEndOfMainLoop(assign3);

            }
        }



        //if the field has null pt set, then create explicit assignment at end of main
        //between static ref's field and static ref for class

    }

    /**
     * Search all reachable methods in user code for api calls that return a value with an empty pt set.
     */
    private int findAPICallsWithNullReturnValues() throws Exception {
        List<SootClass> classes = new LinkedList<SootClass>();
        classes.addAll(Scene.v().getClasses());
        int numChanges = 0;
        
        for (SootClass clz : classes) {

            for (SootMethod method : clz.getMethods()) {
                if (API.v().isSystemMethod(method))
                    continue;

                if (method.isPhantom() || method.isAbstract() || !method.isConcrete())
                    continue;

                if (!PTABridge.v().isReachableMethod(method))
                    continue;

                boolean DEBUG = false;//"<com.devuni.ads.AdsManager: com.devuni.ads.BaseProvider getProvider(int)>".equals(method.getSignature());

                Body body = method.getActiveBody();
                StmtBody stmtBody = (StmtBody)body;
                Chain units = stmtBody.getUnits();
                Iterator stmtIt = units.snapshotIterator();

                while (stmtIt.hasNext()) {
                    Stmt stmt = (Stmt)stmtIt.next();

                    if (stmt instanceof AssignStmt) {
                        AssignStmt assign = (AssignStmt) stmt;
                        if (assign.getRightOp() instanceof InvokeExpr) {
                            boolean hasAPITarget = false;
                            InvokeExpr invoke = (InvokeExpr)assign.getRightOp();

                            //don't care if the return type is a primitive
                            if (!(invoke.getMethodRef().returnType() instanceof RefLikeType))
                                continue;            


                            Collection<SootMethod> targets = PTABridge.v().getTargetsInsNoContext(stmt);
                            for (SootMethod target : targets) 
                                if (API.v().isSystemMethod(target)) {
                                    hasAPITarget = true;
                                    break;
                                }


                            if (hasAPITarget) {
                                //we have a method that could target the api, now see if the return value has 
                                //anything in its pt set
                                Set<AllocNode> nodes = (Set<AllocNode>) PTABridge.v().getPTSetIns(assign.getLeftOp());
                                if (DEBUG) {
                                    System.out.println(stmt);
                                    for (AllocNode node : nodes) {
                                        System.out.println(node);
                                    }
                                }
                                
                                if (nodes.isEmpty()) {
                                    if (addUnmodeledObject(assign, method, DEBUG)) {
                                        numChanges++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return numChanges;
    }

    private Type findCast(SootMethod method, Stmt start, Value v) {
        Body body = method.getActiveBody();
        StmtBody stmtBody = (StmtBody)body;
        Chain units = stmtBody.getUnits();
        Iterator stmtIt = units.iterator(start);

        while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt)stmtIt.next();

            if (stmt.branches())
                return null;

            for (ValueBox vb : stmt.getUseBoxes()) {
                if (vb.getValue() instanceof CastExpr) {
                    CastExpr ce = (CastExpr)vb.getValue();
                    if (ce.getOp().equals(v)) {
                        logger.info("Found cast of {} in {} to {}", v, method, ce.getCastType());
                        return ce.getCastType();
                    }
                }
            }
        }

        return null;
    }

    /**
     * Insert assignment to the dummy object from the dummy class's field that corresponds to 
     * the type of the return value of the rhs of the assignment.
     */
    private boolean addUnmodeledObject(AssignStmt stmt, SootMethod method, boolean DEBUG) {
        InvokeExpr invoke = stmt.getInvokeExpr();
        SootMethodRef target = invoke.getMethodRef();
        Body body = method.getActiveBody();
        boolean madeChange = false;

        //try to find a cast to narrow type
        Type castType = findCast(method, stmt, stmt.getLeftOp());
        Type returnType = target.returnType();
        Type type;

        if (castType != null) {
            if (!SootUtils.isSubTypeOfIncluding(castType, returnType)) {
                logger.info("Could not use cast type because not child of return type {} {}", castType, returnType);
                type = returnType;
            } else {
                type = castType;
            }            
        } else 
            type = returnType;


        Value newObj = UnmodeledGeneratedClasses.v().getSootFieldForType(type);
        if (DEBUG) {
            System.out.println(type);
            System.out.println(newObj);
        }

        if (newObj instanceof StaticFieldRef && stmt.getLeftOp() instanceof Local) {
            StaticFieldRef fr = (StaticFieldRef)newObj;

            //insert assignment statement 
            //assign.getLeft() = fr;
            Stmt insertMe = Jimple.v().newAssignStmt(stmt.getLeftOp(), fr);
            body.getUnits().insertAfter(insertMe, stmt);
            logger.info("Inserting object with {} after {} for {}", insertMe, stmt, method);
            if (DEBUG) System.out.printf("Inserting object with %s after %s for %s", insertMe, stmt, method);
            madeChange = true;
        }
         
        return madeChange;
    }
}
