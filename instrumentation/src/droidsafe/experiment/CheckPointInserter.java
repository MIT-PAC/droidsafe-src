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

import dk.brics.string.intermediate.StringType;

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
    private SootMethod beforeInvokeMethod;
    private SootMethod afterInvokeMethod;
    private InvokeInstrumenter() {
        
    }

    public static InvokeInstrumenter v() { return instance; }
    
    protected void internalTransform(Body body, String phaseName, Map options)
    {
        /*
        int a = 0;
        int b = 1;
        if (a != b)
            return;
        */
        
        SootClass sClass = body.getMethod().getDeclaringClass();
        
        String className = sClass.getName();
        if (className.contains("droidsafe.experiment")) {
            return;
        }

        if (className.contains("droidsafe.instrumentation")) {
            return;
        }

        SootMethod myMethod = body.getMethod();
        if (myMethod.getSignature().matches(".*\\$\\d.*")) {
            logger.warn("Skipping annonymous stuff");
            return;
        }
        soot.Scene.v().addBasicClass("android.instrumentation.ListWrapper");
        soot.Scene.v().addBasicClass("android.instrumentation.CheckPoint");

        Chain<Unit> units = body.getUnits();
        boolean insertParamList = false;

        // Add code to increase goto counter each time a goto is encountered
        Local tmpLocal = Jimple.v().newLocal("droidsafeInstrTmp", RefType.v("java.lang.String"));
        body.getLocals().addLast(tmpLocal);
        
        Local argListLocal = Jimple.v().newLocal("droidsafeArgList", RefType.v("droidsafe.instrumentation.ListWrapper"));
        if (insertParamList)
            body.getLocals().addLast(argListLocal);

        SootClass sootClass = Scene.v().getSootClass("droidsafe.instrumentation.CheckPoint");
        
        for (Tag tag: sootClass.getTags()) {
            logger.info("tag {} ", tag);
        }
        for (SootMethod method: sootClass.getMethods()) {
            logger.info("CheckPoint method: {}", method);
        }
        
        beforeInvokeMethod = Scene.v().getMethod(
                "<droidsafe.instrumentation.CheckPoint: void beforeMethodInvoke(java.lang.Object,java.lang.String)>");

        afterInvokeMethod = Scene.v().getMethod(
                "<droidsafe.instrumentation.CheckPoint: void afterMethodInvoke(java.lang.Object,java.lang.String)>");

//                "<droidsafe.instrumentation.CheckPoint: void afterMethodInvoke(java.lang.Object,java.lang.String,droidsafe.instrumentation.ListWrapper)>");

        SootMethod listCreateMethod =  
                Scene.v().getMethod("<droidsafe.instrumentation.ListWrapper: void <init>()>");

        SootMethod listClearMethod =  
                Scene.v().getMethod("<droidsafe.instrumentation.ListWrapper: void clear()>");
        
        SootMethod listAddMethod =  
                Scene.v().getMethod("<droidsafe.instrumentation.ListWrapper: void add(java.lang.Object)>");

        Iterator<Unit> stmtIt = units.snapshotIterator();
        
        Expr newListExpr = Jimple.v().newNewExpr(RefType.v("droidsafe.instrumentation.ListWrapper"));


        boolean firstInvoke = true;

        while(stmtIt.hasNext())
        {
            Stmt s = (Stmt) stmtIt.next();

            if (!s.containsInvokeExpr())
                continue;
            
            InvokeExpr invokeExpr = (InvokeExpr)s.getInvokeExpr();
            Type type = invokeExpr.getType();
            SootMethod method = invokeExpr.getMethod();
            
            logger.debug("invokestemt: {}, type:{}, method:{}", invokeExpr, type, method);
            if (s instanceof InvokeStmt) {
                ValueBox valueBox = ((InvokeStmt)(s)).getInvokeExprBox();
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

            boolean specialInvoke = false;
            if (invokeExpr instanceof SpecialInvokeExpr || invokeExpr instanceof StaticInvokeExpr) {
                logger.debug("Skip special invoke");
                callerObjectForBeforeInvoke = NullConstant.v();

                callerObject = callerObjectForBeforeInvoke; 
                specialInvoke = true;
            }
            
            Stmt strAssign = Jimple.v().newAssignStmt(tmpLocal, StringConstant.v(method.toString()));
            units.insertBefore(strAssign, s);
            
            Expr beforeInvokeExpr;
            beforeInvokeExpr = Jimple.v().newStaticInvokeExpr(
                    beforeInvokeMethod.makeRef(), callerObjectForBeforeInvoke, tmpLocal);
      
            Stmt beforeInvokeStmt = Jimple.v().newInvokeStmt(beforeInvokeExpr);
            units.insertBefore(beforeInvokeStmt, s); 
                        
            Chain<Unit> postInvokeList = new HashChain<Unit>();
            // clear argument list
            postInvokeList.addLast(Jimple.v().newAssignStmt(argListLocal, newListExpr));
            postInvokeList.addLast(Jimple.v().newInvokeStmt(
                    Jimple.v().newSpecialInvokeExpr(argListLocal, listCreateMethod.makeRef())));

            firstInvoke = false;

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
                    /*
                else if (argValue.getType() instanceof PrimType) {
                    PrimType primType = (PrimType)argValue.getType();
                    addArgExpr = Jimple.v().newVirtualInvokeExpr(
                        argListLocal, listAddMethod.makeRef(), argValue.
                }
                     */
                }   
            }
            
            if (!specialInvoke && insertParamList)
                listLocal = argListLocal;

            Expr afterInvokeExpr = Jimple.v().newStaticInvokeExpr(
                    afterInvokeMethod.makeRef(), callerObject, tmpLocal);

            Stmt afterInvokeStmt = Jimple.v().newInvokeStmt(afterInvokeExpr);

            units.insertAfter(afterInvokeStmt, s); 

            if (!specialInvoke && insertParamList)
                units.insertAfter(postInvokeList, s);


            // we are going to inert instruction before and after the current one
            //logger.info("use boxes: {} ", useBoxes);
        }
    }
}

