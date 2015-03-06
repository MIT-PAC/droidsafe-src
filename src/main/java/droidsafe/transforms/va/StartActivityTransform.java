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

package droidsafe.transforms.va;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.value.primitives.StringVAModel;
import droidsafe.analyses.value.ImplicitIntentModel;
import droidsafe.analyses.value.IntentUtils;
import droidsafe.analyses.value.RefVAModel;
import droidsafe.analyses.value.ResolvedExplicitIntent;
import droidsafe.analyses.value.UnresolvedIntent;
import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.analyses.value.VAModel;
import droidsafe.analyses.value.UnknownVAModel;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.android.system.AndroidComponents;
import droidsafe.reports.ICCMap;
import droidsafe.stats.IntentResolutionStats;
import droidsafe.transforms.objsensclone.ClassCloner;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.Stmt;
import soot.jimple.spark.pag.ObjectSensitiveAllocNode;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.ArrayType;
import soot.Local;
import soot.MethodContext;
import soot.MethodOrMethodContext;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Unit;
import soot.Value;

/**
 * @author dpetters
 * @author mgordon
 */

class StartActivityTransform implements VATransform {

    public static int localID = 0;

    private final Logger logger = LoggerFactory.getLogger(StartActivityTransform.class);

    private Set<String> sigsOfInvokesToTransform;

    Set<Stmt> modified = new HashSet<Stmt>();

    public StartActivityTransform() {
        //get all activities

    }


    @Override

    public void tranformsInvoke(SootMethod containingMthd, SootMethod callee, InvokeExpr invoke, Stmt stmt, Body body) { 

        if(!Project.v().isSrcClass(containingMthd.getDeclaringClass())){
            return;
        }

        if (modified.contains(stmt)) {
            return;
        }
        modified.add(stmt);

        IntentResolutionStats.v().intentCalls++;

        SootMethod setIntentMethod = Scene.v().getMethod("<android.app.Activity: void setIntent(android.content.Intent)>");
        logger.info("Found startActivity in {}: {}", containingMthd, stmt);

        Value intentArg = invoke.getArg(0);

        Set<IAllocNode> intentNodes;

        if (intentArg.getType() instanceof RefType) 
            intentNodes = (Set<IAllocNode>)PTABridge.v().getPTSetIns(intentArg);
        else if (intentArg.getType() instanceof ArrayType) {
            //array argument for startActivities
            intentNodes = new LinkedHashSet<IAllocNode>();
            for (IAllocNode array : PTABridge.v().getPTSetIns(intentArg)) {
                intentNodes.addAll((Set<IAllocNode>)PTABridge.v().getPTSetOfArrayElement(array));
            }
        } else
            return;

        boolean allIntentsNodeResolved = true;
        boolean noInAppTarget = false;
        Set<SootField> inAppTargets = new HashSet<SootField>();

        boolean allResolvedExplicitIntentsFoundTargets = true;

        for (IAllocNode intentNode : intentNodes) {  
            logger.info("AllocNode: {}", intentNode);
            IntentResolutionStats.v().intentObjects++;
            Set<SootField> targetHarnessFields = 
                    IntentUtils.v().getIntentTargetHarnessFields(AndroidComponents.ACTIVITY, stmt, callee, intentNode);

            //if we don't have a resolved explicit intent or if we have a resolved explicit intent with 
            //no in app target, then we don't have all resolved in app explicit
            if (IntentUtils.v().getIntentModel(intentNode) instanceof UnresolvedIntent) {
                allIntentsNodeResolved = false;
                logger.info("Unresolved Intent");
            } else {
                //resolved

                if (IntentUtils.v().getIntentModel(intentNode) instanceof ImplicitIntentModel) {
                    IntentResolutionStats.v().resolvedImplictIntents++;
                    logger.info("Implicit intent");
                } else {
                    IntentResolutionStats.v().resolvedExplicitIntents++;
                    logger.info("Explicit intent");
                }

                if (targetHarnessFields.isEmpty()) {
                    noInAppTarget = true;
                }            
            }

            inAppTargets.addAll(targetHarnessFields);

            //if we don't have a resolved explicit intent or if we have a resolved explicit intent with 
            //no in app target, then we don't have all resolved in app explicit
            if (!(IntentUtils.v().getIntentModel(intentNode) instanceof ResolvedExplicitIntent) ||
                    targetHarnessFields.isEmpty()) 
                allResolvedExplicitIntentsFoundTargets = false;

            for (SootField activityField : targetHarnessFields ) {
                logger.info("Harness field: {}", activityField);
                if (activityField == null || !(activityField.getType() instanceof RefType) || 
                        !Hierarchy.inheritsFromAndroidActivity(((RefType)activityField.getType()).getSootClass()))
                    continue;

                if (callee.getSubSignature().contains("startActivityForResult"))
                    setResultTransform(containingMthd, invoke, activityField, intentNode);

                logger.info("Adding setIntent call in " + JimpleRelationships.v().getEnclosingMethod(stmt));
                //call set intent on these activities with local   

                //create local and add to body
                Local local = Jimple.v().newLocal("_$setIntent_local_" + localID++, activityField.getType());
                body.getLocals().add(local);

                //set field of activity to local [local = harness.activityfield]
                //set local to field
                Stmt localAssign = Jimple.v().newAssignStmt
                        (local, Jimple.v().newStaticFieldRef(activityField.makeRef()));
                body.getUnits().insertBefore(localAssign, stmt);

                //call setActivity on local with local arg from start activity
                List<Value> args = new LinkedList<Value>();
                //this will work for both startActivity and startActivityForResult
                args.add(intentArg);
                Stmt setIntentCall = 
                        Jimple.v().newInvokeStmt(Jimple.v().newVirtualInvokeExpr
                            (local, setIntentMethod.makeRef(), args));

                body.getUnits().insertAfter(setIntentCall, localAssign);
                //ignore making output events for this call we add
                RCFG.v().ignoreInvokeForOutputEvents(setIntentCall);
                try  {
                    //register in report of icc
                    if (activityField.getType() instanceof RefType) {
                        SootClass target  = ((RefType)activityField.getType()).getSootClass();
                        SootMethod resolved = Scene.v().getActiveHierarchy().resolveConcreteDispatch(target, setIntentMethod);
                        ICCMap.v().addInfo(containingMthd.getDeclaringClass(), 
                            target, 
                            stmt, resolved);
                    }
                } catch (Exception e) {
                    logger.warn("Issue resolve method for target in startActivityTransform:", e);
                }
            }
        }

        if (allResolvedExplicitIntentsFoundTargets) { 
            //if all resolved explicit intents in app, the ignore the start activity call
            logger.debug("Ignoring invoke of startActivity: {} in {}", stmt, containingMthd);
            RCFG.v().ignoreInvokeForOutputEvents(stmt);
        }

        if (allIntentsNodeResolved) {
            IntentResolutionStats.v().callsWithResolvedIntents++;
            if (noInAppTarget)
                IntentResolutionStats.v().callsTargetNotInApp++;
            IntentResolutionStats.v().inAppComponentsTotalTargets += inAppTargets.size();
        } else {
            IntentResolutionStats.v().callsWithUnresolvedIntent++;
        }
    }

    /**
     * setResult calls in target of startActivityForResult will be transformed to call the 
     * onActivityResult of the caller activity.  This links the proper intent to the onActivityResult intent 
     * argument.
     */
    private void setResultTransform(SootMethod caller, InvokeExpr startActivtyForResult, 
                                    SootField targetActivityField, IAllocNode intentNode) {
        //setResult(arg) -> onActivityResult(startActivityForResult.arg1, arg, getIntent())
        //setResult(arg0, arg1) -> onActivityResult(startActivityForResult.arg1, arg0, arg1)

        SootClass callerClass = caller.getDeclaringClass();
        SootField callerFieldInHarness = IntentUtils.v().getHarnessFldForClsString(callerClass.getName());
        if (callerFieldInHarness == null) {
            logger.error("Could not find harness field for calling activity {} of startActivityForResult", callerClass);
            return;
        }

        logger.info("Found caller for startActivity for result, class: {}, field: {}", callerClass, callerFieldInHarness);

        //Find the alloc nodes that are associated with the caller activity's field in the harness
        Set<IAllocNode>callerContexts = 
                (Set<IAllocNode>) PTABridge.v().getPTSetIns(Jimple.v().newStaticFieldRef(targetActivityField.makeRef()));

        SootMethod setResult2 = Scene.v().getMethod("<android.app.Activity: void setResult(int,android.content.Intent)>");
        SootMethod setResult1 = Scene.v().getMethod("<android.app.Activity: void setResult(int)>");
        SootMethod onActivityResult = Scene.v().getMethod("<android.app.Activity: void onActivityResult(int,int,android.content.Intent)>");
        SootMethod getIntent = Scene.v().getMethod("<android.app.Activity: android.content.Intent getIntent()>");

        for (IAllocNode node : callerContexts) {
            if (!(node instanceof ObjectSensitiveAllocNode)) 
                continue;                        
            ObjectSensitiveAllocNode osan = (ObjectSensitiveAllocNode) node;

            //find all calls to setResult(int, Intent) on node            
            MethodOrMethodContext mc2 = MethodContext.v(setResult2, osan);

            Iterator<Edge> edges2 = Scene.v().getCallGraph().edgesInto(mc2);
            while (edges2.hasNext()) { 
                //for each call to setIntent(int, Intent) create statements to call onActivityResult
                Edge call = edges2.next();
                SootMethod setResultCallerMethod = call.src();
                Stmt callStmt = call.srcStmt();

                Local callerActFieldLocal = 
                        Jimple.v().newLocal("_$setResult_local_" + localID++, callerFieldInHarness.getType());
                setResultCallerMethod.getActiveBody().getLocals().add(callerActFieldLocal);
                Stmt setActField = 
                        Jimple.v().newAssignStmt(callerActFieldLocal, Jimple.v().newStaticFieldRef(callerFieldInHarness.makeRef()));

                List<Value> args = new LinkedList<Value>();
                //hopefully the request code will be handled by the default modeling of startActivityForResult's call to onActivityResult
                args.add(IntConstant.v(0));
                args.add(callStmt.getInvokeExpr().getArg(0));
                args.add(callStmt.getInvokeExpr().getArg(1));

                Stmt onActcall = 
                        Jimple.v().newInvokeStmt(Jimple.v().newVirtualInvokeExpr(callerActFieldLocal, onActivityResult.makeRef(), args));

                List<Unit> toInsert = new LinkedList<Unit>();
                toInsert.add(setActField);
                toInsert.add(onActcall);

                //insert call to onActivityResult here                
                setResultCallerMethod.getActiveBody().getUnits().insertAfter(toInsert, (Unit)callStmt);
                logger.info("Inserting call to onActivityResult(int, int, Intent) for setResult(int, Intent) in {} in {} in {}",
                    callStmt, setResultCallerMethod, osan);
            }

            //find all calls to setResult(int) on node            
            MethodOrMethodContext mc1 = MethodContext.v(setResult1, osan);

            Iterator<Edge> edges1 = Scene.v().getCallGraph().edgesInto(mc1);
            while (edges1.hasNext()) {                
                Edge call = edges1.next();
                SootMethod setResultCallerMethod = call.src();
                Stmt callStmt = call.srcStmt();

                List<Unit> toInsert = new LinkedList<Unit>();

                Local callerActFieldLocal = 
                        Jimple.v().newLocal("_$setResult_local_" + localID++, callerFieldInHarness.getType());
                setResultCallerMethod.getActiveBody().getLocals().add(callerActFieldLocal);
                Stmt setActField = 
                        Jimple.v().newAssignStmt(callerActFieldLocal, Jimple.v().newStaticFieldRef(callerFieldInHarness.makeRef()));
                toInsert.add(setActField);

                Local getIntentLocal =
                        Jimple.v().newLocal("_$setResult_getIntent_local_" + localID++, getIntent.getReturnType());
                setResultCallerMethod.getActiveBody().getLocals().add(getIntentLocal);

                Stmt getIntentLocalAssign = 
                        Jimple.v().newAssignStmt(getIntentLocal, 
                            Jimple.v().newVirtualInvokeExpr(setResultCallerMethod.getActiveBody().getThisLocal(),
                                getIntent.makeRef()));

                toInsert.add(getIntentLocalAssign);

                List<Value> args = new LinkedList<Value>();
                //hopefully the request code will be handled by the default modeling of startActivityForResult's call to onActivityResult
                args.add(IntConstant.v(0));
                args.add(callStmt.getInvokeExpr().getArg(0));
                args.add(getIntentLocal);

                Stmt onActcall = 
                        Jimple.v().newInvokeStmt(Jimple.v().newVirtualInvokeExpr(callerActFieldLocal, onActivityResult.makeRef(), args));

                toInsert.add(onActcall);

                //insert call to onActivityResult here                
                setResultCallerMethod.getActiveBody().getUnits().insertAfter(toInsert, (Unit)callStmt);
                logger.info("Inserting call to onActivityResult(int, int, Intent) for setResult(int) in {} in {} in {}",
                    callStmt, setResultCallerMethod, osan);
            }

        }        
    }

    @Override
    public Set<String> sigsOfInvokesToTransform() {
        if (sigsOfInvokesToTransform == null) {
            sigsOfInvokesToTransform = new HashSet<String>();
            sigsOfInvokesToTransform.add("<android.app.Activity: void startActivity(android.content.Intent)>");
            sigsOfInvokesToTransform.add("<android.app.Activity: void startActivity(android.content.Intent,android.os.Bundle)>");
            sigsOfInvokesToTransform.add("<android.app.Activity: void startActivityForResult(android.content.Intent,int)>");
            sigsOfInvokesToTransform.add("<android.app.Activity: void startActivityForResult(android.content.Intent,int,android.os.Bundle)>");
            sigsOfInvokesToTransform.add("<android.app.Activity: void startActivityIfNeeded(android.content.Intent,int)>");
            sigsOfInvokesToTransform.add("<android.app.Activity: void startActivityIfNeeded(android.content.Intent,int,android.os.Bundle)>");

            sigsOfInvokesToTransform.add("<android.content.Context: void startActivity(android.content.Intent)>");
            sigsOfInvokesToTransform.add("<android.app.ContexImpl: void startActivity(android.content.Intent)>");
            sigsOfInvokesToTransform.add("<android.app.Service: void startActivity(android.content.Intent)>");
            sigsOfInvokesToTransform.add("<android.app.Application: void startActivity(android.content.Intent)>");

            sigsOfInvokesToTransform.add("<android.app.Fragment: void startActivity(android.content.Intent)>");
            sigsOfInvokesToTransform.add("<android.app.Fragment: void startActivityForResult(android.content.Intent,int)>");
            sigsOfInvokesToTransform.add("<android.content.ContextWrapper: void startActivity(android.content.Intent)>");

            sigsOfInvokesToTransform.add( "<android.app.Activity: void startActivities(android.content.Intent[])>");
            sigsOfInvokesToTransform.add( "<android.content.Context: void startActivities(android.content.Intent[])>");
            sigsOfInvokesToTransform.add( "<android.app.ContextImpl: void startActivities(android.content.Intent[])>");
            sigsOfInvokesToTransform.add( "<android.content.ContextWrapper: void startActivities(android.content.Intent[])>");


        }
        return sigsOfInvokesToTransform;
    }


}
