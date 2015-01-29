package droidsafe.transforms.va;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.android.app.Project;
import droidsafe.utils.SootUtils;
import soot.Body;
import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.jimple.ArrayRef;
import soot.jimple.AssignStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.NewArrayExpr;
import soot.jimple.Stmt;
import soot.jimple.toolkits.pta.IAllocNode;

public class MethodInvokeTransform implements VATransform {

    public static int localID = 0;

    private final Logger logger = LoggerFactory.getLogger(MethodInvokeTransform.class);

    private Set<String> sigsOfInvokesToTransform;

    Set<Stmt> modified = new HashSet<Stmt>();    

    public MethodInvokeTransform() {

    }

    @Override
    public void tranformsInvoke(SootMethod containingMthd, SootMethod callee,
                                InvokeExpr invokeExpr, Stmt stmt, Body body) {

        if(!Project.v().isSrcClass(containingMthd.getDeclaringClass())){
            return;
        }

        if (modified.contains(stmt)) {
            return;
        }
        modified.add(stmt);

        try {
            
            boolean replaced = false;
            
            //get the method object va resolved fields
            InstanceInvokeExpr iie = (InstanceInvokeExpr)invokeExpr;
            Set<IAllocNode> methodNodes = (Set<IAllocNode>) PTABridge.v().getPTSetIns(iie.getBase());
            Set<String> classNames = new LinkedHashSet<String>();
            Set<String> mNames = new LinkedHashSet<String>();
            Set<String> temp = new LinkedHashSet<String>();

            SootClass methodClass = Scene.v().getSootClass("java.lang.reflect.Method");
            SootField dsDecClzNameField = methodClass.getFieldByName("dsDeclaringClassName"); 
            SootField nameField = methodClass.getFieldByName("name");

            for (IAllocNode node : methodNodes) {
                temp.clear();
                boolean classResolved = ValueAnalysis.v().getStringFieldValues(node, dsDecClzNameField, temp);
                classNames.addAll(temp);

                temp.clear();
                boolean mNameResolved = ValueAnalysis.v().getStringFieldValues(node, nameField, temp);
                mNames.addAll(temp);

                //do the best we can here, don't worry if unresolved                
            }

            //System.out.println(stmt + " " + SootUtils.getSourceLine(stmt));

            for (String className : classNames) {
                for (String mName : mNames) {
                    

                    //try to get the method from the class / name combination 
                    try {
                        SootMethod target = Scene.v().getSootClass(className).getMethodByName(mName);

                        //find number of args from new array created for var args
                        Unit current = body.getUnits().getPredOf(stmt);
                        NewArrayExpr newObjArgArrray = null;
                        while (true) {
                            if (current instanceof AssignStmt && ((AssignStmt)current).getRightOp() instanceof NewArrayExpr) {
                                newObjArgArrray = (NewArrayExpr)((AssignStmt)current).getRightOp();
                                break;
                            }
                                                        
                            if (body.getUnits().getFirst().equals(current))
                                break;
                            
                            current = body.getUnits().getPredOf(current);
                        }
                        
                        //System.out.println(newObjArgArrray);
                        
                        if (newObjArgArrray == null)
                            continue;
                        
                        int numArgs = ((IntConstant)newObjArgArrray.getSize()).value;
                        
                        //if method does not have some number of args, then skip
                        //System.out.println(numArgs + " " + target.getParameterCount());
                        
                        if (numArgs != target.getParameterCount())
                            continue;
                        
                        //System.out.println(className + " " + mName);

                        //create argument list
                        
                        //cast and array access
                        List<Value> args = new LinkedList<Value>();
                        List<Unit> methodCallStmts = new LinkedList<Unit>();
                        for (int i = 0; i < numArgs; i++) {
                            Local argLocal = Jimple.v().newLocal("_$methodinvoke_local_" + localID++, RefType.v("java.lang.Object"));
                            body.getLocals().add(argLocal);
                            
                            //local = obj[i]
                            
                            ArrayRef arrAccess = Jimple.v().newArrayRef(iie.getArg(1), IntConstant.v(i));
                            AssignStmt assign = Jimple.v().newAssignStmt(argLocal, arrAccess);
                            //add assignment                            
                            methodCallStmts.add(assign);
                            
                            //local2 = (param_type)local
                            
                            // add cast
                            Local castLocal = Jimple.v().newLocal("_$methodinvoke_local_" + localID++, target.getParameterType(i));
                            body.getLocals().add(castLocal);                            
                            AssignStmt cast = Jimple.v().newAssignStmt(castLocal, Jimple.v().newCastExpr(argLocal, target.getParameterType(i)));
                            methodCallStmts.add(cast);
                            
                            //add the casted local as an arg
                            args.add(castLocal);
                        }
                        
                        
                        //create method call and possible assignment                        
                        InvokeExpr invoke = Jimple.v().newVirtualInvokeExpr((Local)iie.getArg(0), target.makeRef(), args);
                        Stmt callStmt = null;
                        if (stmt instanceof AssignStmt) {
                            callStmt = Jimple.v().newAssignStmt(((AssignStmt)stmt).getLeftOp(), invoke);
                        } else {
                            callStmt = Jimple.v().newInvokeStmt(invoke);
                        }
                        
                        methodCallStmts.add(callStmt);
                        
                        body.getUnits().insertAfter(methodCallStmts, stmt);
                        logger.info("Created explicit call for reflection call, original line: {} added call {}", SootUtils.getSourceLocation(stmt), invoke);
                        replaced = true;
                    } catch (Exception e) {
                        //ambiguous method skip
                        logger.info("Problem with reflection transform", e);
                        continue;
                    }
                }
                
                if (replaced)
                    body.getUnits().remove(stmt);
            }

        } catch (Exception e) {
            //don't do anything if it breaks
            logger.info("Problem with reflection transform", e);
        }
    }

    @Override
    public Set<String> sigsOfInvokesToTransform() {
        if (sigsOfInvokesToTransform == null) {
            sigsOfInvokesToTransform = new HashSet<String>();           
            sigsOfInvokesToTransform.add( "<java.lang.reflect.Method: java.lang.Object invoke(java.lang.Object,java.lang.Object[])>");


        }
        return sigsOfInvokesToTransform;
    }

}
