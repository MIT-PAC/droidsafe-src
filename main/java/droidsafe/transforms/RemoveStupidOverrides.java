package droidsafe.transforms;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.AssignStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.internal.JIdentityStmt;
import soot.jimple.internal.JInvokeStmt;
import soot.jimple.internal.JReturnStmt;
import soot.jimple.internal.JReturnVoidStmt;
import soot.util.Chain;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.main.Main;
import droidsafe.utils.SootUtils;

/**
 * Remove methods in all classes' code that are overrides and do nothing but call the super method.
 * 
 * This class is helpful for simplifying the code, and enabling other transformations.
 * 
 * @author mgordon
 *
 */
public class RemoveStupidOverrides {
    /** logger field */
    private static final Logger logger = LoggerFactory.getLogger(RemoveStupidOverrides.class);

    /**
     * Do nothing.
     */
    private RemoveStupidOverrides() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Call this on all methods in scene
     */
    public static void run() {
        RemoveStupidOverrides transformer = new RemoveStupidOverrides();
        for (SootClass clz : Scene.v().getClasses()) {
            String clzName = clz.getName();
            // Do not touch lang classes
            if (!clzName.startsWith("java.lang")) {
                SootMethod[] methods = clz.getMethods().toArray(new SootMethod[0]);
                for (SootMethod meth : methods) {                    
                    if (meth.isConcrete() && !meth.isStatic() && !meth.isConstructor())
                        try {
                            transformer.removeMethodIfStupid(clz, meth);
                        } catch (Exception e) {
                            logger.debug("Error in RemoveStupidOverrides. Ignoring...", e);
                        }
                }
            }
        }
    }

    /**
     * Remove a method if all it does is call the super method with the same args.
     */
    private void removeMethodIfStupid(SootClass clz, SootMethod method) {
        //System.out.printf("Inspecting %s\n", method);

        /*
        //method overrides an app method?  Might want to do this for all overrides?
        if (!Hierarchy.v().isImplementedSystemMethod(method))
            return;

        //find ancestor method: is it a system call?
        boolean foundSystemAncestor = false;
        List<SootClass> ancestors = SootUtils.getAncestorList(clz);
        for (SootClass ancestor : ancestors) {
            //we have found the closest overriding method...
            if (ancestor.declaresMethod(method.getSubSignature())) {
                //if a system method, then we have found  
                if (API.v().isSystemClass(ancestor))
                    foundSystemAncestor = true;
                else  
                    break;
            }
        }

        //if 
        if (!foundSystemAncestor)
            return;
         */

        StmtBody stmtBody = null;
        try {
        	stmtBody = (StmtBody)method.retrieveActiveBody();
        }
        catch (Exception ex) {
        	logger.info("Exception retrieving method body {}", ex);
        	return;
        }


        // get body's unit as a chain
        Unit[] units = stmtBody.getUnits().toArray(new Unit[0]);

        //all stmts 0 .. n-2 are identity
        for (int i = 0; i < units.length - 2; i++) 
            if (!(units[i] instanceof JIdentityStmt)) {
                //System.out.printf("Found non identity statement: %s\n", units[i]);
                return;
            }

        //2nd to last statement is a special invoke of same method from super on the this reference
        boolean foundSpecialInvoke = false;
        if ((units[units.length - 2] instanceof Stmt) && ((Stmt)units[units.length -2]).containsInvokeExpr()) {
            InvokeExpr invoke = ((Stmt)units[units.length -2]).getInvokeExpr();
            if (invoke instanceof SpecialInvokeExpr &&
                    method.getSubSignature().equals(invoke.getMethodRef().getSubSignature()) &&
                    ((SpecialInvokeExpr) invoke).getBase().equals(stmtBody.getThisLocal())) {
                //check that each arg for the super call is the argument from this method, in the right order
                for (int i = 0; i < invoke.getArgCount(); i++) {
                    if (!invoke.getArg(i).equals(stmtBody.getParameterLocal(i)))
                        return;
                }
                foundSpecialInvoke = true;
            }
        }

        if (!foundSpecialInvoke) {
            //System.out.printf("Could not find special invoke at n-2: %s\n", units[units.length - 2]);
            return;
        }

        //one return statement
        boolean correctReturn = false;
        //return statement does not return
        if ((units[units.length -1] instanceof JReturnVoidStmt) && units[units.length - 2] instanceof JInvokeStmt) {
            correctReturn = true;
        }
        
        //if we are returning a value, make sure it is the value assigned from the previous assignement/
        //that calls the super
        if ((units[units.length -1] instanceof JReturnStmt) && units[units.length - 2] instanceof AssignStmt) {
            if (((AssignStmt)units[units.length - 2] ).getLeftOp().
                    equals(((JReturnStmt)units[units.length -1]).getOp())) {
                correctReturn = true;
            } 
        }


        if (!correctReturn) {
            //System.out.printf("Something wrong with final 2 stmts: %s %s\n", units[units.length - 2],
            //    units[units.length - 1]);            
            return;
        }
        

        //if we get here, we can remove the method
        logger.info("Removing stupid override {}", method);
        //System.out.printf("Removing stupid override %s\n", method);
        clz.removeMethod(method);
    }
}
