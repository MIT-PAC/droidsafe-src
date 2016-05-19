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

import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.reports.AnalysisReport;
import droidsafe.utils.JimpleRelationships;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.BodyTransformer;
import soot.jimple.AssignStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.spark.pag.ObjectSensitiveAllocNode;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.jimple.toolkits.pta.IClassConstantNode;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.StringConstant;
import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.util.Chain;

/**
 * Tranformer called on all application classes that will find all invocations of Class.getName on class constants and 
 * replace them with the string name of the class.
 * 
 * @author dpetters
 */

public class ClassGetNameToClassString extends BodyTransformer {
    private static int LOCAL_ID = 0;
    private static final String LOCAL_PREFIX = "_$CLASSGETNAME_TO_CLASSNAMESTR_LOCAL";
    /** logger object */
    private static final Logger logger = LoggerFactory.getLogger(ClassGetNameToClassString.class);
    /**
     * Call this pass on all application classes in the project.
     */
    public static void run() {
        ClassGetNameToClassString transformer = new ClassGetNameToClassString();
        for (SootClass clz : Scene.v().getClasses()) {
            for (SootMethod meth : clz.getMethods()) {
                if (meth.isConcrete())
                	try {
                		transformer.transform(meth.retrieveActiveBody());
                	}
                	catch (Exception ex) {
                		logger.info("Exception retrieving method body {}", ex);
                		continue;
                	}
            }
        }
    }

    protected void internalTransform(Body b, String phaseName, Map options)  {
        StmtBody stmtBody = (StmtBody)b;
        // get body's unit as a chain
        Chain units = stmtBody.getUnits();
        // get a snapshot iterator of the unit since we are going to mutate the chain when iterating over it.
        Iterator stmtIt = units.snapshotIterator();

        while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt)stmtIt.next();
            if (!stmt.containsInvokeExpr()) {
                continue;
            }
            //see if we should perform any outright replacements, and if so, don't do a jsa injection
            if (replaceClassGetNameWithClassString(b.getMethod(), stmtBody, units, stmt))
                continue;
        }
    }

    private boolean replaceClassGetNameWithClassString(SootMethod caller, StmtBody stmtBody, Chain units, Stmt stmt) {
        if (!(stmt instanceof AssignStmt) || !(((AssignStmt)stmt).getRightOp() instanceof InvokeExpr))
            return false;

        AssignStmt assign = (AssignStmt)stmt;
        InvokeExpr invoke = (InvokeExpr)assign.getRightOp();
        try {
            Set<SootMethod> targets = PTABridge.v().getTargetsInsNoContext(JimpleRelationships.v().getEnclosingMethod(stmt), stmt);

            if (targets.size() != 1)
                return false;

            SootMethod target = targets.iterator().next();

            //replace java.lang.Class.getName() with a string constant if possible
            if ("<java.lang.Class: java.lang.String getName()>".equals(target.getSignature())) {
                logger.info("Found Class.getName() call {}", stmt);
                InstanceInvokeExpr iie = (InstanceInvokeExpr) invoke;
                Set<? extends IAllocNode> nodes = PTABridge.v().getPTSetIns(iie.getBase());
                for(IAllocNode node : nodes) {
                    if (!(node instanceof IClassConstantNode) && 
                            !((node instanceof ObjectSensitiveAllocNode) && 
                                    ((ObjectSensitiveAllocNode)node).getContextElement(0) instanceof IClassConstantNode)) {
                        logger.info("Not class constant: {}", node);
                        if (!API.v().isSystemMethod(caller)) {
                        	AnalysisReport.v().addEntry("Class.getName() could not be resolved.", stmt, AnalysisReport.Level.HIGH);
                        }
                        return false;
                    }
                }

                // add a local variable
                Local newLocal = Jimple.v().newLocal(LOCAL_PREFIX + LOCAL_ID++, RefType.v("java.lang.String"));
                stmtBody.getLocals().add(newLocal);

                Set<String> nameStrings = new LinkedHashSet<String>();
                
                for (IAllocNode node : nodes) {
                    IClassConstantNode ccNode;
                    if (node instanceof IClassConstantNode)
                        ccNode = ((IClassConstantNode)node);
                    else {
                        ccNode = (IClassConstantNode)((ObjectSensitiveAllocNode)node).getContextElement(0);
                    }
                        
                    String name =                    
                            ccNode.getClassConstant().getValue().replace("/", ".");
                    nameStrings.add(name);
                }
                
                for (String name : nameStrings) {                
                    StringConstant sc = StringConstant.v(name);
                    JSAResultInjection.trackedStringConstants.add(sc);
                    AssignStmt localAssign = Jimple.v().newAssignStmt(newLocal, sc);
                    units.insertBefore(localAssign, stmt);
                    assign.setRightOp(newLocal);
                    logger.info("Replacing class.getName() with string {} {}", stmt, name);

                }
                
                return true;
            }

        } catch (Exception e) {
            logger.error("Something wrong, ignoring: ", e);
        }

        return false;
    }
}
