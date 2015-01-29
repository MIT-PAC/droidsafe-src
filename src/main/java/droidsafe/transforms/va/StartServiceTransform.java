package droidsafe.transforms.va;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.value.ImplicitIntentModel;
import droidsafe.analyses.value.IntentUtils;
import droidsafe.analyses.value.ResolvedExplicitIntent;
import droidsafe.analyses.value.UnresolvedIntent;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.app.Project;
import droidsafe.android.system.AndroidComponents;
import droidsafe.reports.ICCMap;
import droidsafe.stats.IntentResolutionStats;
import droidsafe.utils.JimpleRelationships;
import soot.ArrayType;
import soot.Body;
import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Value;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.Stmt;
import soot.jimple.toolkits.pta.IAllocNode;

public class StartServiceTransform implements VATransform {

    public static int localID = 0;

    private final Logger logger = LoggerFactory.getLogger(StartServiceTransform.class);

    private Set<String> sigsOfInvokesToTransform;

    Set<Stmt> modified = new HashSet<Stmt>();

    public StartServiceTransform() {
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

        SootMethod onStartCommand = Scene.v().getMethod("<android.app.Service: int onStartCommand(android.content.Intent,int,int)>");
        SootMethod onStart = Scene.v().getMethod("<android.app.Service: void onStart(android.content.Intent,int)>");

        Value intentArg = invoke.getArg(0);

        Set<IAllocNode> intentNodes;

        intentNodes = (Set<IAllocNode>)PTABridge.v().getPTSetIns(intentArg);

        boolean allResolvedExplicitIntentsFoundTargets = true;
        boolean allIntentsNodeResolved = true;
        boolean noInAppTarget = false;
        Set<SootField> inAppTargets = new HashSet<SootField>();
        
                      
        for (IAllocNode intentNode : intentNodes) {
            IntentResolutionStats.v().intentObjects++;
            Set<SootField> targetHarnessFields = 
                    IntentUtils.v().getIntentTargetHarnessFields(AndroidComponents.SERVICE, stmt, callee, intentNode);
                              
            if (IntentUtils.v().getIntentModel(intentNode) instanceof UnresolvedIntent) {
                allIntentsNodeResolved = false;
            } else {
                //resolved
                if (IntentUtils.v().getIntentModel(intentNode) instanceof ImplicitIntentModel) {
                    IntentResolutionStats.v().resolvedImplictIntents++;
                } else {
                    IntentResolutionStats.v().resolvedExplicitIntents++;
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
            
            for (SootField serviceField : targetHarnessFields) {
                if (!(serviceField.getType() instanceof RefType))
                    continue;           

                if (!Hierarchy.inheritsFromAndroidService(((RefType)serviceField.getType()).getSootClass()))
                    continue;

                logger.info("Adding onStartCommand call in {} to {}", JimpleRelationships.v().getEnclosingMethod(stmt), serviceField);
                //call set intent on these activities with local   

                //create local and add to body
                Local local = Jimple.v().newLocal("_$startservice_local_" + localID++, serviceField.getType());
                body.getLocals().add(local);

                //set field of component to local [local = harness.activityfield]
                //set local to field
                Stmt localAssign = Jimple.v().newAssignStmt
                        (local, Jimple.v().newStaticFieldRef(serviceField.makeRef()));
                body.getUnits().insertBefore(localAssign, stmt);


                List<Value> args = new LinkedList<Value>();

                args.add(intentArg);
                args.add(IntConstant.v(0));
                args.add(IntConstant.v(0));
                Stmt onStartCall = 
                        Jimple.v().newInvokeStmt(Jimple.v().newVirtualInvokeExpr
                            (local, onStartCommand.makeRef(), args));

                body.getUnits().insertAfter(onStartCall, localAssign);
                //ignore making output events for this call we add
                RCFG.v().ignoreInvokeForOutputEvents(onStartCall);

                //now add the call to onStart()

                args = new LinkedList<Value>();

                args.add(intentArg);
                args.add(IntConstant.v(0));
                Stmt onStartDepCall = 
                        Jimple.v().newInvokeStmt(Jimple.v().newVirtualInvokeExpr
                            (local, onStart.makeRef(), args));

                body.getUnits().insertAfter(onStartDepCall, onStartCall);
                //ignore making output events for this call we add
                RCFG.v().ignoreInvokeForOutputEvents(onStartDepCall);

                //add to icc report 

                SootClass target = ((RefType)serviceField.getType()).getSootClass(); 
                SootMethod resolved = Scene.v().getActiveHierarchy().resolveConcreteDispatch(target, onStartCommand);

                ICCMap.v().addInfo(containingMthd.getDeclaringClass(), 
                    target, stmt, resolved);          

                resolved = Scene.v().getActiveHierarchy().resolveConcreteDispatch(target, onStart);
                ICCMap.v().addInfo(containingMthd.getDeclaringClass(),
                    target, stmt, resolved);

            }
        }
        
        if (allResolvedExplicitIntentsFoundTargets) { 
            //if all resolved explicit intents in app, the ignore the start activity call          
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

    @Override
    public Set<String> sigsOfInvokesToTransform() {
        if (sigsOfInvokesToTransform == null) {
            sigsOfInvokesToTransform = new HashSet<String>();
            sigsOfInvokesToTransform.add("<android.content.Context: android.content.ComponentName startService(android.content.Intent)>");
            sigsOfInvokesToTransform.add("<android.app.ContextImpl: android.content.ComponentName startService(android.content.Intent)>");
            sigsOfInvokesToTransform.add("<android.content.ContextWrapper: android.content.ComponentName startService(android.content.Intent)>");
        }
        return sigsOfInvokesToTransform;
    }

}
