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

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.android.app.Project;
import droidsafe.transforms.UnmodeledGeneratedClasses;
import soot.Body;
import soot.Local;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.StaticFieldRef;
import soot.jimple.Stmt;
import soot.jimple.toolkits.pta.IAllocNode;

public class NewInstanceTransform implements VATransform {

    public static int localID = 0;

    private final Logger logger = LoggerFactory.getLogger(NewInstanceTransform.class);

    private Set<String> sigsOfInvokesToTransform;

    Set<Stmt> modified = new HashSet<Stmt>();    

    public NewInstanceTransform () {

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
            if (!(stmt instanceof AssignStmt))
                return;
            
            boolean replaced = false;
            
            AssignStmt origAssign = (AssignStmt)stmt;
            
            //get the method object va resolved fields
            InstanceInvokeExpr iie = (InstanceInvokeExpr)invokeExpr;
            Set<IAllocNode> classNodes = (Set<IAllocNode>) PTABridge.v().getPTSetIns(iie.getBase());

            SootClass methodClass = Scene.v().getSootClass("java.lang.Class");
            SootField clzNameField = methodClass.getFieldByName("dsClassName"); 

            Set<String> classNames = new LinkedHashSet<String>();
            Set<String> temp = new LinkedHashSet<String>();

            for (IAllocNode node : classNodes) {
                temp.clear();
                ValueAnalysis.v().getStringFieldValues(node, clzNameField, temp);
                classNames.addAll(temp);
            }

            for (String cName : classNames) {
                try { 
                    //use cloner to create class
                    SootClass clz = Scene.v().getSootClass(cName);
                    
                    Value newObj = UnmodeledGeneratedClasses.v().getSootFieldForType(clz.getType());
                        
                    if (newObj instanceof StaticFieldRef && origAssign.getLeftOp() instanceof Local) {
                        StaticFieldRef fr = (StaticFieldRef)newObj;

                        //insert assignment statement 
                        //assign.getLeft() = fr;
                        Stmt insertMe = Jimple.v().newAssignStmt(origAssign.getLeftOp(), fr);
                        body.getUnits().insertAfter(insertMe, stmt);
                        logger.info("Inserting object for Class.newInstance with {} after {} for {}", insertMe, stmt, clz);
                        replaced = true;
                    }
                    
                    //set assignment lval to field of dummies
                } catch (Exception e) {
                    logger.info("Problem", e);
                }
            }

            if (replaced) {
                body.getUnits().remove(stmt);
            }
            
        } catch (Exception e) {
            logger.info("Problem", e);
        }
    }

    @Override
    public Set<String> sigsOfInvokesToTransform() {
        if (sigsOfInvokesToTransform == null) {
            sigsOfInvokesToTransform = new HashSet<String>();           
            sigsOfInvokesToTransform.add( "<java.lang.Class: java.lang.Object newInstance()>");
        }
        return sigsOfInvokesToTransform;
    }


}
