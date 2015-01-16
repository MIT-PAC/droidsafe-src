package droidsafe.stats;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.transforms.APICallSpecialization;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.Constant;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.NewExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.util.Chain;

public class FindAPICallsWithNonLocalEffects {
	private final static Logger logger = LoggerFactory.getLogger(FindAPICallsWithNonLocalEffects.class);
	
    private FileWriter fw;
    private Map<ReceiverTarget, Set<IAllocNode>> receiverToReturns;
    private Map<ReceiverTarget, Set<IAllocNode>> receiverToArgs;

    public FindAPICallsWithNonLocalEffects() {
        try {
            fw = new FileWriter(Project.v().getOutputDir() + File.separator +"non-local-api-methods.txt");
        } catch (IOException e) {

        }

        receiverToReturns = new HashMap<ReceiverTarget, Set<IAllocNode>>();
        receiverToArgs = new HashMap<ReceiverTarget, Set<IAllocNode>>();

    }

    public void run() {
        int nonLocals = 0;

        for (SootMethod method : PTABridge.v().getReachableMethods()) {
            if (API.v().isSystemMethod(method)) 
                continue;

            if (method.isAbstract() || method.isPhantom() || !method.isConcrete())
                continue;

            StmtBody stmtBody = null;
            try {
            	stmtBody = (StmtBody)method.retrieveActiveBody();
            }
            catch (Exception ex) {
            	logger.info("Exception retrieving method body {}", ex);
            	continue;
            }

            // get body's unit as a chain
            Chain<Unit> units = stmtBody.getUnits();
            // get a snapshot iterator of the unit since we are going to
            // mutate the chain when iterating over it.
            Iterator<Unit> stmtIt = units.snapshotIterator();

            while (stmtIt.hasNext()) {
                Stmt stmt = (Stmt)stmtIt.next();
                if (!stmt.containsInvokeExpr())
                    continue;

                InvokeExpr invoke = stmt.getInvokeExpr();

                try {
                    //for nonlocals
                    boolean found = false;
                    for (SootMethod target : PTABridge.v().getTargetsInsNoContext(method, stmt)) {
                        if (!API.v().isSystemMethod(target))
                            continue;

                        SootClass targetClass = target.getDeclaringClass();

                        if (stmt instanceof AssignStmt) {
                            if (nonLocalRef(targetClass, ((AssignStmt)stmt).getLeftOp(),
                                method, invoke, target))
                                found = true;
                        }

                        for (Value arg : invoke.getArgs()) {
                            if (nonLocalRef(targetClass, arg,
                                method, invoke, target))
                                found = true;
                        }

                    }
                    if (found)
                        nonLocals ++;


                    //for calculating receiver -> return alloc map
                    if (invoke instanceof InstanceInvokeExpr && (stmt instanceof AssignStmt)) {
                        Value returnVal = ((AssignStmt)stmt).getLeftOp();

                        if (returnVal.getType() instanceof RefType && !(returnVal instanceof Constant)) {

                            Set<IAllocNode> returnNodes = new HashSet<IAllocNode>();
                            for (IAllocNode an : (Set<IAllocNode>) PTABridge.v().getPTSetIns(returnVal)) {
                                if (!(an.getNewExpr() instanceof NewExpr))
                                    continue;
                                SootClass enclosingC =  ((NewExpr)an.getNewExpr()).getBaseType().getSootClass();


                                if (!PTABridge.v().shouldIgnoreForStats(enclosingC))
                                    returnNodes.add(an);
                            }


                            Set<IAllocNode> argNodes = new HashSet<IAllocNode>();
                            //now for args:
                                for (Value arg : invoke.getArgs()) {
                                    if (!(arg.getType() instanceof RefType) || arg instanceof Constant)
                                        continue;
                                    for (IAllocNode an : PTABridge.v().getPTSetIns(arg)) {
                                        if (!(an.getNewExpr() instanceof NewExpr))
                                            continue;
                                        SootClass enclosingC =  ((NewExpr)an.getNewExpr()).getBaseType().getSootClass();


                                        if (!PTABridge.v().shouldIgnoreForStats(enclosingC))
                                            argNodes.add(an);
                                    }
                                }

                                //cull return node

                                for (SootMethod target : PTABridge.v().getTargetsInsNoContext(method, stmt)) {
                                    for (IAllocNode receiver : PTABridge.v().getPTSetIns(((InstanceInvokeExpr)invoke).getBase())) {
                                        if (!target.equals(Scene.v().getActiveHierarchy().resolveConcreteDispatch(
                                            SootUtils.getCallingTypeForReceiver((RefLikeType)receiver.getType()), 
                                            invoke.getMethod())))
                                            continue;

                                        if (!(receiver.getNewExpr() instanceof NewExpr))
                                            continue;

                                        SootClass receiverClass = ((NewExpr)receiver.getNewExpr()).getBaseType().getSootClass();

                                        if (PTABridge.v().shouldIgnoreForStats(receiverClass))
                                            continue;


                                        if (!API.v().isSystemMethod(target) || !API.v().isSystemClass(receiverClass)) 
                                            continue;

                                        ReceiverTarget recTar = new ReceiverTarget(receiver, target); 

                                        if (!receiverToReturns.containsKey(recTar)) 
                                            receiverToReturns.put(recTar, new HashSet<IAllocNode>());

                                        receiverToReturns.get(recTar).addAll(returnNodes);


                                        if (!receiverToArgs.containsKey(recTar)) 
                                            receiverToArgs.put(recTar, new HashSet<IAllocNode>());

                                        receiverToArgs.get(recTar).addAll(argNodes);

                                    }
                                }
                        }
                    }

                } catch (Exception e) {
                    //ignore
                    e.printStackTrace();
                }
            }



        }
        try {
            findReceiverReturnArgsIntersections();  
            System.out.println("Non Local API Calls:" + nonLocals);
            fw.close();
        } catch (Exception e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void findReceiverReturnArgsIntersections() throws Exception {
        int intersections = 0;
        Set<ReceiverTarget> receiverTargets = new HashSet<ReceiverTarget>();
        receiverTargets.addAll(receiverToReturns.keySet());

        Set<ReceiverTarget> completed = new HashSet<ReceiverTarget>();
        for (ReceiverTarget recTar : receiverTargets) {

            for (ReceiverTarget otherRecTar : receiverToReturns.keySet()) {
                if (completed.contains(recTar))
                    continue;

                if (!recTar.receiver.equals(otherRecTar.receiver)) {
                    Set<IAllocNode> intersection = new HashSet<IAllocNode>(receiverToReturns.get(recTar));
                    intersection.retainAll(receiverToReturns.get(otherRecTar));

                    if (!intersection.isEmpty()) {
                        //found something!
                        fw.write(String.format("%s.%s and %s.%s share return allocnode.\n", recTar.receiver, recTar.target, otherRecTar.receiver, otherRecTar.target));
                        intersections++;
                    }
                }
            }
            completed.add(recTar);
        }

        receiverTargets = new HashSet<ReceiverTarget>();
        receiverTargets.addAll(receiverToArgs.keySet());
        completed = new HashSet<ReceiverTarget>();

        for (ReceiverTarget recTar : receiverTargets) {
            for (ReceiverTarget otherRecTar : receiverToArgs.keySet()) {
                if (completed.contains(recTar))
                    continue;

                if (!recTar.receiver.equals(otherRecTar.receiver)) {
                    Set<IAllocNode> intersection = new HashSet<IAllocNode>(receiverToArgs.get(recTar));
                    intersection.retainAll(receiverToArgs.get(otherRecTar));

                    if (!intersection.isEmpty()) {
                        //found something!
                        fw.write(String.format("%s.%s and %s.%s share args allocnode.\n", recTar.receiver, recTar.target, otherRecTar.receiver, otherRecTar.target));
                        intersections++;
                    }
                }
            }
            completed.add(recTar);
        }

        System.out.println("Intersections of arg / return calls on API with different receivers: " + intersections);
    }

    private boolean nonLocalRef(SootClass targetClass, Value v, SootMethod caller, 
                                InvokeExpr invoke, SootMethod callee) throws Exception {
        if (!(v.getType() instanceof RefType) || v instanceof Constant)
            return false;

        boolean found = false;

        //check non local and not app
        for (IAllocNode an : PTABridge.v().getPTSetIns(v)) {
            if (!(an.getNewExpr() instanceof NewExpr))
                continue;

            SootMethod enclosingM =  
                    JimpleRelationships.v().getEnclosingMethod((NewExpr)an.getNewExpr());
            SootClass enclosingC = enclosingM.getDeclaringClass();


            if (!enclosingC.equals(targetClass) &&
                    !Scene.v().getActiveHierarchy().isClassSuperclassOf(enclosingC, targetClass) && 
                    API.v().isSystemMethod(enclosingM) &&
                    !PTABridge.v().shouldIgnoreForStats(enclosingC) &&
                    !PTABridge.v().shouldIgnoreForStats(targetClass)) {
                //TODO: DO NOT WRITE FOR NOW, ALREADY INSPECTED OUTPUT
                //fw.write(String.format("%s calls %s with %s and returns / arg from %s\n\n", 
                //caller, callee, invoke, enclosingC));
                found = true;
            }
        }

        return found;
    }

    class ReceiverTarget {
        IAllocNode receiver;
        SootMethod target;

        public ReceiverTarget(IAllocNode receiver, SootMethod target) {
            super();
            this.receiver = receiver;
            this.target = target;
        }


        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((receiver == null) ? 0 : receiver.hashCode());
            result = prime * result + ((target == null) ? 0 : target.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            ReceiverTarget other = (ReceiverTarget) obj;
            if (!getOuterType().equals(other.getOuterType())) return false;
            if (receiver == null) {
                if (other.receiver != null) return false;
            } else if (!receiver.equals(other.receiver)) return false;
            if (target == null) {
                if (other.target != null) return false;
            } else if (!target.equals(other.target)) return false;
            return true;
        }
        private FindAPICallsWithNonLocalEffects getOuterType() {
            return FindAPICallsWithNonLocalEffects.this;
        }


    }
}
