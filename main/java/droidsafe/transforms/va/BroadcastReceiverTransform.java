package droidsafe.transforms.va;

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

import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.value.IntentUtils;
import droidsafe.analyses.value.VAUtils;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.android.system.AndroidComponents;
import droidsafe.reports.ICCMap;
import droidsafe.reports.UnresolvedICC;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;
import soot.Body;
import soot.Local;
import soot.MethodOrMethodContext;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Value;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.NullConstant;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.toolkits.pta.IAllocNode;

public class BroadcastReceiverTransform implements VATransform {

    private Map<String, Set<SootClass>> filterActionsToClass;
    /** Set of receivers with unresolved filters, must deliver all broadcasts to them */
    private Set<SootClass> receiversWithUnresolvedFilters;
    private final Logger logger = LoggerFactory.getLogger(BroadcastReceiverTransform.class);
    private Set<String> sigsOfInvokesToTransform;
    private Set<Stmt> modified = new HashSet<Stmt>();
    public static int localID = 0;

    public BroadcastReceiverTransform() {
        //search for all calls to registerReceiver
        filterActionsToClass = new HashMap<String, Set<SootClass>>();
        receiversWithUnresolvedFilters = new HashSet<SootClass>();
        buildMapOfActions();

    }

    private void buildMapOfActions() {
        for (SootMethod containingMthd : PTABridge.v().getReachableMethods()) {
            // filter out abstract, not concrete, phantom and stub methods
            if (containingMthd.isAbstract() 
                    || !containingMthd.isConcrete() 
                    || containingMthd.isPhantom() 
                    || SootUtils.isRuntimeStubMethod(containingMthd))
                continue;

            // iterate over the containing method's body statements
            StmtBody stmtBody = (StmtBody)containingMthd.getActiveBody();
            Iterator stmtIt = stmtBody.getUnits().snapshotIterator();
            while (stmtIt.hasNext()) {
                Stmt stmt = (Stmt)stmtIt.next();

                if (!stmt.containsInvokeExpr())
                    continue;
                InvokeExpr invokeExpr = (InvokeExpr)stmt.getInvokeExpr();

                for (SootMethod callee : PTABridge.v().getTargetsInsNoContext(containingMthd, stmt)) {                        
                    if (sigsOfRegisterReceiver().contains(callee.getSignature())) {
                        //arg 0 classes -> string of arg 1 intent filters
                        List<String> actions = new LinkedList<String>();

                        boolean resolved = VAUtils.<String>getAnyVAValuesForField(
                            (Set<IAllocNode>)PTABridge.v().getPTSetIns(invokeExpr.getArg(1)), 
                            "mActions", actions);

                        //build list of BroadcastReceiver classes that could be referenced in the 0th argument
                        //these are the receivers we are registering
                        List<SootClass> brs = new LinkedList<SootClass>();
                        for (IAllocNode node : PTABridge.v().getPTSetIns(invokeExpr.getArg(0))) {
                            if (node.getType() instanceof RefType) {
                                SootClass clz = ((RefType)node.getType()).getSootClass(); 
                                brs.add(clz);

                            }
                        }

                        if (resolved) {//intent resolved
                            for (String action : actions) {
                                //associate with sootclass of arg 0
                                for (SootClass clz : brs) {
                                    if (!filterActionsToClass.containsKey(action)) {
                                        filterActionsToClass.put(action, new HashSet<SootClass>());
                                    }
                                    filterActionsToClass.get(action).add(clz);
                                    logger.info("Mapping BroadcastReceiver: {} -> {}", action, clz);
                                }
                            }
                        } else {
                            //intent unresolved
                            for (SootClass clz : brs) {
                                receiversWithUnresolvedFilters.add(clz);
                                logger.info("BroadcastReceiver with unresolved IntentFiler: {}", clz);
                            }                       
                        }

                    }
                } 
            }                
        }
    }

    @Override
    public void tranformsInvoke(SootMethod containingMthd, SootMethod callee,
                                InvokeExpr invoke, Stmt stmt, Body body) {

        if(!Project.v().isSrcClass(containingMthd.getDeclaringClass())){
            return;
        }

        if (modified.contains(stmt)) {
            return;
        }
        modified.add(stmt);

        SootMethod onReceive = Scene.v().getMethod("<android.content.BroadcastReceiver: void onReceive(android.content.Context,android.content.Intent)>");

        Value intentArg = invoke.getArg(0);

        Set<IAllocNode> intentNodes;

        intentNodes = (Set<IAllocNode>)PTABridge.v().getPTSetIns(intentArg);

        //find actions strings of intents

        List<String> intentActions = new LinkedList<String>(); 
        boolean resolved = VAUtils.<String>getAnyVAValuesForField(intentNodes, "mAction", intentActions);
        //did we find in app targets for all broadcast calls?
        boolean foundAllTargets = true;
        Set<SootClass> classTargets = new LinkedHashSet<SootClass>();

        //calculate target for Intent based on action
        if (resolved) {
            classTargets.addAll(receiversWithUnresolvedFilters);
            for (String action : intentActions) {                                
                if (!filterActionsToClass.containsKey(action)) {
                    foundAllTargets = false;
                    continue;
                } 

                classTargets.addAll(filterActionsToClass.get(action));                
            }

        } else {
            //not resolved add all broadcast receivers
            for (SootClass clz : Harness.v().getCreatedClasses()) {
                if (Hierarchy.inheritsFromAndroidComponent(AndroidComponents.BROADCAST_RECEIVER, clz)) {
                    classTargets.add(clz);
                }
            }
        }

        for (SootClass target : classTargets) {
            SootField brField = Harness.v().getFieldForCreatedClass(target);
            if (brField == null) {
                logger.error("Cannot find harness field for BroadcastReceiver: {}", target);
                continue;
            }

            logger.info("Adding onReceive call in {} to {}", JimpleRelationships.v().getEnclosingMethod(stmt), brField);
            //call set intent on these activities with local   

            //create local and add to body
            Local local = Jimple.v().newLocal("_$broadcastreceiver_local_" + localID++, brField.getType());
            body.getLocals().add(local);

            //set field of component to local [local = harness.activityfield]
            //set local to field
            Stmt localAssign = Jimple.v().newAssignStmt
                    (local, Jimple.v().newStaticFieldRef(brField.makeRef()));
            body.getUnits().insertBefore(localAssign, stmt);


            List<Value> args = new LinkedList<Value>();
            //context?
            args.add(((InstanceInvokeExpr)invoke).getBase());
            args.add(intentArg);
            Stmt onReceiveCall = 
                    Jimple.v().newInvokeStmt(Jimple.v().newVirtualInvokeExpr
                        (local, onReceive.makeRef(), args));

            body.getUnits().insertAfter(onReceiveCall, localAssign);
            //ignore making output events for this call we add
            RCFG.v().ignoreInvokeForOutputEvents(onReceiveCall);

            //report in ICC json report
            SootMethod resolvedMethod = Scene.v().getActiveHierarchy().resolveConcreteDispatch(target, onReceive);
            ICCMap.v().addInfo(containingMthd.getDeclaringClass(), target, stmt, resolvedMethod);

        }
        
        if (resolved && foundAllTargets) {
            //intent was resolved and we found all in-app targets for values resolved
            RCFG.v().ignoreInvokeForOutputEvents(stmt);
        } else {
            UnresolvedICC.v().addInfo(stmt, callee, "Unresolved Intent value");
        }
    }

    @Override
    public Set<String> sigsOfInvokesToTransform() {
        if (sigsOfInvokesToTransform == null) {
            sigsOfInvokesToTransform = new HashSet<String>();

            sigsOfInvokesToTransform.add("<android.content.Context: void sendBroadcast(android.content.Intent)>");
            sigsOfInvokesToTransform.add("<android.content.Context: void sendBroadcast(android.content.Intent,java.lang.String)>");
            sigsOfInvokesToTransform.add("<android.content.Context: void sendOrderedBroadcast(android.content.Intent,java.lang.String)>");
            sigsOfInvokesToTransform.add("<android.content.Context: void sendOrderedBroadcast(android.content.Intent,java.lang.String,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle)>");
            sigsOfInvokesToTransform.add("<android.content.Context: void sendStickyBroadcast(android.content.Intent)>");
            sigsOfInvokesToTransform.add("<android.content.Context: void sendStickyOrderedBroadcast(android.content.Intent,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle)>");

            sigsOfInvokesToTransform.add("<android.content.ContextWrapper: void sendBroadcast(android.content.Intent)>");
            sigsOfInvokesToTransform.add("<android.content.ContextWrapper: void sendBroadcast(android.content.Intent,java.lang.String)>");
            sigsOfInvokesToTransform.add("<android.content.ContextWrapper: void sendOrderedBroadcast(android.content.Intent,java.lang.String)>");
            sigsOfInvokesToTransform.add("<android.content.ContextWrapper: void sendOrderedBroadcast(android.content.Intent,java.lang.String,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle)>");
            sigsOfInvokesToTransform.add("<android.content.ContextWrapper: void sendStickyBroadcast(android.content.Intent)>");
            sigsOfInvokesToTransform.add("<android.content.ContextWrapper: void sendStickyOrderedBroadcast(android.content.Intent,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle)>");

            sigsOfInvokesToTransform.add("<android.app.ContextImpl: void sendBroadcast(android.content.Intent)>");
            sigsOfInvokesToTransform.add("<android.app.ContextImpl: void sendBroadcast(android.content.Intent,java.lang.String)>");
            sigsOfInvokesToTransform.add("<android.app.ContextImpl: void sendOrderedBroadcast(android.content.Intent,java.lang.String)>");
            sigsOfInvokesToTransform.add("<android.app.ContextImpl: void sendOrderedBroadcast(android.content.Intent,java.lang.String,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle)>");
            sigsOfInvokesToTransform.add("<android.app.ContextImpl: void sendStickyBroadcast(android.content.Intent)>");
            sigsOfInvokesToTransform.add("<android.app.ContextImpl: void sendStickyOrderedBroadcast(android.content.Intent,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle)>");

        }
        return sigsOfInvokesToTransform;

    }

    private Set<String> sigsOfRegisterReceiver() {
        Set<String> sigs = new HashSet<String>();

        sigs.add("<android.content.Context: android.content.Intent registerReceiver(android.content.BroadcastReceiver,android.content.IntentFilter)>");
        sigs.add("<android.content.Context: android.content.Intent registerReceiver(android.content.BroadcastReceiver,android.content.IntentFilter,java.lang.String,android.os.Handler)>");
        sigs.add("<android.content.ContextWrapper: android.content.Intent registerReceiver(android.content.BroadcastReceiver,android.content.IntentFilter)>");
        sigs.add("<android.content.ContextWrapper: android.content.Intent registerReceiver(android.content.BroadcastReceiver,android.content.IntentFilter,java.lang.String,android.os.Handler)>");
        sigs.add("<android.app.ContextImpl: android.content.Intent registerReceiver(android.content.BroadcastReceiver,android.content.IntentFilter)>");
        sigs.add("<android.app.ContextImpl: android.content.Intent registerReceiver(android.content.BroadcastReceiver,android.content.IntentFilter,java.lang.String,android.os.Handler)>");

        return sigs;
    }
}
