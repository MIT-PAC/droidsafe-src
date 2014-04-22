/* Soot - a J*va Optimization Framework
 * Copyright (C) 1997-1999 Raja Vallee-Rai
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

/*
 * Modified by the Sable Research Group and others 1997-1999.  
 * See the 'credits' file distributed with Soot for the complete list of
 * contributors.  (Soot is distributed at http://www.sable.mcgill.ca/soot)
 */

/* Reference Version: $SootVersion: 1.beta.6.dev.51 $ */

package droidsafe.experiment;

import soot.*;
import soot.jimple.*;
import soot.tagkit.Tag;
import soot.util.*;
import java.io.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
   Example to instrument a classfile to produce goto counts. 
 */
public class CheckPointInserter
{    
    public static void main(String[] args) 
    {
        if(args.length == 0)
        {
            System.out.println("Syntax: java ashes.examples.countgotos.Main [soot options]");
            System.exit(0);
        }            
        
        PackManager.v().getPack("jtp").add(new Transform("jtp.instrumenter", InvokeInstrumenter.v()));

	// Just in case, resolve the PrintStream and System SootClasses.
        Scene.v().addBasicClass("java.io.PrintStream",SootClass.SIGNATURES);
        Scene.v().addBasicClass("java.lang.System",SootClass.SIGNATURES);
        Scene.v().addBasicClass("java.util.List",SootClass.SIGNATURES);
        Scene.v().addBasicClass("java.util.LinkedList",SootClass.SIGNATURES);
        Scene.v().addBasicClass("droidsafe.instrumentation.CheckPoint", SootClass.SIGNATURES);
        Scene.v().addBasicClass("droidsafe.instrumentation.ListWrapper", SootClass.SIGNATURES);
        soot.Main.main(args);
    }
}

/**
    InstrumentClass example.
    
    Instruments the given class to print out the number of Jimple goto 
    statements executed.

    To enable this class, enable the given PackAdjuster by compiling it 
    separately, into the soot package.
 */

class InvokeInstrumenter extends BodyTransformer
{
    private static final Logger logger = LoggerFactory.getLogger(InvokeInstrumenter.class);
    private static InvokeInstrumenter instance = new InvokeInstrumenter();
    private InvokeInstrumenter() {
        
    }

    public static InvokeInstrumenter v() { return instance; }
    
    /**
     * This method is called by soot framework to perform method transformation.
     * 
     * Currently, the following transformations are done:
     * 1. insert checkpoint at the function entrance
     * 2. insert a checkpoint at before a function invoke
     * 3. insert a checkpoint after a function invoke
     * 
     * These transformations are needed to assist with the transformation
     */
    protected void internalTransform(Body body, String phaseName, Map options)
    {
       
        SootClass sClass = body.getMethod().getDeclaringClass();
        
        String className = sClass.getName();
        if (className.contains("droidsafe.experiment")) {
            return;
        }

        if (className.contains("droidsafe.instrumentation")) {
            return;
        }

        soot.Scene.v().addBasicClass("android.instrumentation.ListWrapper");
        soot.Scene.v().addBasicClass("android.instrumentation.CheckPoint");

        Chain<Unit> units = body.getUnits();
        boolean insertParamList = true;

        // Add code to increase goto counter each time a goto is encountered
        Local tmpLocal = Jimple.v().newLocal("droidsafeInstrTmp", RefType.v("java.lang.String"));
        body.getLocals().addLast(tmpLocal);
        
        Local argListLocal = Jimple.v().newLocal("droidsafeArgList", RefType.v("droidsafe.instrumentation.ListWrapper"));
        if (insertParamList)
            body.getLocals().addLast(argListLocal);

        SootMethod beforeInvokeMethod = Scene.v().getMethod(
                "<droidsafe.instrumentation.CheckPoint: void beforeMethodInvoke(java.lang.Object,java.lang.String)>");

        SootMethod afterInvokeMethod = Scene.v().getMethod(
                "<droidsafe.instrumentation.CheckPoint: void afterMethodInvoke(java.lang.Object,java.lang.String,droidsafe.instrumentation.ListWrapper)>");

        SootMethod insideMethodMethod = Scene.v().getMethod(
                "<droidsafe.instrumentation.CheckPoint: void insideMethod(java.lang.Object,java.lang.String,droidsafe.instrumentation.ListWrapper)>");

        SootMethod listInitMethod =  
                Scene.v().getMethod("<droidsafe.instrumentation.ListWrapper: void <init>()>");

        SootMethod listClearMethod =  
                Scene.v().getMethod("<droidsafe.instrumentation.ListWrapper: void clear()>");
        
        SootMethod listAddMethod =  
                Scene.v().getMethod("<droidsafe.instrumentation.ListWrapper: void add(java.lang.Object)>");
        
        SootMethod listAddDoubleMethod =  
                Scene.v().getMethod("<droidsafe.instrumentation.ListWrapper: void add(double)>");

        SootMethod listAddIntegerMethod =  
                Scene.v().getMethod("<droidsafe.instrumentation.ListWrapper: void add(int)>");

        Expr newListExpr = Jimple.v().newNewExpr(RefType.v("droidsafe.instrumentation.ListWrapper"));

        SootMethod myMethod = body.getMethod();
        
        SootClass sootClass = Scene.v().getSootClass("droidsafe.instrumentation.CheckPoint");
        
        for (Tag tag: sootClass.getTags()) {
            logger.info("tag {} => {}/{} ", tag, tag.getName(), tag.getClass().getName());
        }
       
        Chain<Unit> methodEntryList = new HashChain<Unit>();
        // clear argument list
        methodEntryList.add(Jimple.v().newAssignStmt(argListLocal, newListExpr));
        methodEntryList.add(Jimple.v().newInvokeStmt(
                Jimple.v().newSpecialInvokeExpr(argListLocal, listInitMethod.makeRef())));

        methodEntryList.add(Jimple.v().newAssignStmt(tmpLocal, StringConstant.v(myMethod.toString())));

        //body.getParameterLocal(arg0)
        // This loop deals with method entry (= symbol)
        Iterator<Unit> stmtIt = units.snapshotIterator();
        Stmt firstStatement = null;
        while(stmtIt.hasNext()){
            Stmt stmt = (Stmt) stmtIt.next();

            logger.info("{} ", stmt);
            // first instrution that is not parameter assignment
            if (!(stmt instanceof IdentityStmt)) {
                Expr insideMethodExpr = Jimple.v().newStaticInvokeExpr(
                        insideMethodMethod.makeRef(), NullConstant.v(), tmpLocal, argListLocal);

                Stmt insideMethodStmt = Jimple.v().newInvokeStmt(insideMethodExpr);
                
                methodEntryList.addLast(insideMethodStmt);
                
                logger.info("Insert at inst {} ", stmt);
                logger.info("{} ", methodEntryList);
                firstStatement = stmt;
                //units.insertBefore(methodEntryList, stmt);
                break;
            }
            //collecting arguments
            /*
            Value argValue = stmt.getDefBoxes().get(0).getValue();
            Expr addArgExpr;
            
            if ((argValue.getType() instanceof RefType) ||
                    (argValue.getType() instanceof ArrayType)) {
                addArgExpr = Jimple.v().newVirtualInvokeExpr(
                        argListLocal, listAddMethod.makeRef(), argValue);    

                methodEntryList.addLast(Jimple.v().newInvokeStmt(addArgExpr));
            }
            else if (argValue.getType() instanceof IntegerType) {
                addArgExpr = Jimple.v().newVirtualInvokeExpr(
                        argListLocal, listAddIntegerMethod.makeRef(), argValue);
                methodEntryList.addLast(Jimple.v().newInvokeStmt(addArgExpr));
            }   
            else if (argValue.getType() instanceof DoubleType) {
                addArgExpr = Jimple.v().newVirtualInvokeExpr(
                        argListLocal, listAddDoubleMethod.makeRef(), argValue);
                methodEntryList.addLast(Jimple.v().newInvokeStmt(addArgExpr));
            }
            */
        }
        
        
        // This loop deals with invoke statements (+|- symbols)
        stmtIt = units.snapshotIterator();
        while(stmtIt.hasNext())
        {
            Stmt stmt = (Stmt) stmtIt.next();

            if (!stmt.containsInvokeExpr())
                continue;

            InvokeExpr invokeExpr = (InvokeExpr)stmt.getInvokeExpr();
            Type type = invokeExpr.getType();
            SootMethod method = invokeExpr.getMethod();

            logger.debug("invokestemt: {}, type:{}, method:{}", invokeExpr, type, method);
            if (stmt instanceof InvokeStmt) {
                ValueBox valueBox = ((InvokeStmt)(stmt)).getInvokeExprBox();
                logger.debug("invokeexprbox: {} ", valueBox);
            }

            List<ValueBox> useBoxes = invokeExpr.getUseBoxes();

            if (useBoxes.size() == 0)
            {
                logger.info("methd call has no uses {} ", invokeExpr);
                continue;
            }
            Value callerObject = useBoxes.get(0).getValue();
            Value callerObjectForBeforeInvoke = callerObject;
            Value callerObjectForAfterInvoke = callerObject;

            boolean specialInvoke = false;
            if (invokeExpr instanceof SpecialInvokeExpr) {
                callerObjectForBeforeInvoke = NullConstant.v();
                specialInvoke = true;
            }

            if (invokeExpr instanceof StaticInvokeExpr) {
                callerObjectForBeforeInvoke = NullConstant.v();
                callerObjectForAfterInvoke = NullConstant.v();
            }

            Stmt strAssign = Jimple.v().newAssignStmt(tmpLocal, StringConstant.v(method.toString()));
            units.insertBefore(strAssign, stmt);

            Expr beforeInvokeExpr;
            beforeInvokeExpr = Jimple.v().newStaticInvokeExpr(
                    beforeInvokeMethod.makeRef(), callerObjectForBeforeInvoke, tmpLocal);

            Stmt beforeInvokeStmt = Jimple.v().newInvokeStmt(beforeInvokeExpr);
            units.insertBefore(beforeInvokeStmt, stmt); 

            Chain<Unit> postInvokeList = new HashChain<Unit>();
            // clear argument list
            // postInvokeList.addLast(Jimple.v().newAssignStmt(argListLocal, newListExpr));
            /*
            postInvokeList.addLast(Jimple.v().newInvokeStmt(
                    Jimple.v().newSpecialInvokeExpr(argListLocal, listInitMethod.makeRef())));
            */

            postInvokeList.addLast(Jimple.v().newInvokeStmt(
                    Jimple.v().newVirtualInvokeExpr(argListLocal, 
                            listClearMethod.makeRef())));

            Value listLocal = NullConstant.v();

            if (invokeExpr.getArgCount() > 0) {

                for (Value argValue: invokeExpr.getArgs()) {
                    Expr addArgExpr;
                    if ((argValue.getType() instanceof RefType) ||
                            (argValue.getType() instanceof ArrayType)) {
                        addArgExpr = Jimple.v().newVirtualInvokeExpr(
                                argListLocal, listAddMethod.makeRef(), argValue);    

                        postInvokeList.addLast(Jimple.v().newInvokeStmt(addArgExpr));
                    }
                    else if (argValue.getType() instanceof IntegerType) {
                        addArgExpr = Jimple.v().newVirtualInvokeExpr(
                                argListLocal, listAddIntegerMethod.makeRef(), argValue);
                        postInvokeList.addLast(Jimple.v().newInvokeStmt(addArgExpr));
                    }   
                    else if (argValue.getType() instanceof DoubleType) {
                        addArgExpr = Jimple.v().newVirtualInvokeExpr(
                                argListLocal, listAddDoubleMethod.makeRef(), argValue);
                        postInvokeList.addLast(Jimple.v().newInvokeStmt(addArgExpr));
                    }
                }
            }

            if (!specialInvoke && insertParamList)
                listLocal = argListLocal;

            Expr afterInvokeExpr = Jimple.v().newStaticInvokeExpr(
                    afterInvokeMethod.makeRef(), callerObjectForAfterInvoke, tmpLocal, listLocal);

            Stmt afterInvokeStmt = Jimple.v().newInvokeStmt(afterInvokeExpr);

            units.insertAfter(afterInvokeStmt, stmt); 

            if (insertParamList)
                units.insertAfter(postInvokeList, stmt);

            // we are going to inert instruction before and after the current one
            //logger.info("use boxes: {} ", useBoxes);
        }
        
        //defer until here so that the chain does not alter
        if (firstStatement != null) {
            units.insertAfter(methodEntryList, firstStatement);
        }
        
        
    }
}

