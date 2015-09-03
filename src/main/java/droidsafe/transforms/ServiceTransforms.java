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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import soot.Context;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.system.API;
import soot.MethodOrMethodContext;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.ValueBox;
import soot.jimple.ClassConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.spark.pag.ObjectSensitiveAllocNode;

public class ServiceTransforms {

    private static ServiceTransforms v = null;

    private SimpleGraph<SootClass, DefaultEdge> serviceConns; 
    
    private Set<SootMethod> bindServiceMethods;
    private Set<String> bindServiceMethodSubSigs;

    private ServiceTransforms() {
        // TODO Auto-generated constructor stub
        serviceConns = new SimpleGraph<SootClass, DefaultEdge>(DefaultEdge.class);
        
        bindServiceMethods = new HashSet<SootMethod>();
        bindServiceMethodSubSigs = new HashSet<String>();
        SootClass contextImpl = Scene.v().getSootClass("android.app.ContextImpl");
        SootMethod bindService = contextImpl.getMethodByName("bindService");
        bindServiceMethods.add(bindService);
        SootClass contextWrapper = Scene.v().getSootClass("android.content.ContextWrapper");
        bindServiceMethods.add(contextWrapper.getMethodByName("bindService"));
        
        bindServiceMethodSubSigs = new HashSet<String>();
        for (SootMethod m : bindServiceMethods) 
            bindServiceMethodSubSigs.add(m.getSubSignature());
        
    }

    public static ServiceTransforms v() {
        if (v == null)
            v = new ServiceTransforms();

        return v;
    }

    public void run() {
        //create graph of links between services and other components
        buildConnectionGraph();

        //for each class in connection graph
        //find messenger or handlers 
    }

    private SootClass findTargetOfBind(StmtBody body, Stmt bindServiceCall) {
        SootClass lastComponentClassConstant = null;
        Iterator stmts = body.getUnits().iterator(body.getUnits().getFirst(), bindServiceCall);
        while (stmts.hasNext()) {
            Stmt stmt = (Stmt)stmts.next();
            
            for (ValueBox vb : stmt.getUseBoxes()) {
                System.out.println(vb.getValue() + " " + vb.getValue().getClass());
                if (vb.getValue() instanceof ClassConstant) {
                    ClassConstant cc = (ClassConstant) vb.getValue();
                    SootClass ccClz = Scene.v().getSootClass(cc.getValue().replaceAll("/", "."));
                    if (!API.v().isSystemClass(ccClz) && Hierarchy.isAndroidComponentClass(ccClz))
                        lastComponentClassConstant = ccClz;
                    
                }       
            }          
        }
        
        return lastComponentClassConstant;
    }
    
    private void buildConnectionGraph() {
        //find bindService calls classes from PTA
       
        for (SootClass clz : Scene.v().getClasses()) {
            if (clz.isInterface() || API.v().isSystemClass(clz) || !Hierarchy.isAndroidComponentClass(clz))
                continue;
            
            for (SootMethod method : clz.getMethods()) {
                if (!method.isConcrete() || method.isAbstract())
                    continue;
                
                //we have a user component class
                // iterate over the containing method's body statements
                StmtBody stmtBody = (StmtBody)method.getActiveBody();
                Iterator stmtIt = stmtBody.getUnits().snapshotIterator();
                while (stmtIt.hasNext()) {
                    Stmt stmt = (Stmt)stmtIt.next();

                    // we only transform invoke expressions
                    if (!stmt.containsInvokeExpr())
                        continue;
                    InvokeExpr invokeExpr = (InvokeExpr)stmt.getInvokeExpr();
                    
                    //System.out.println(invokeExpr.getMethodRef().getSubSignature());
                    
                    if (bindServiceMethodSubSigs.contains(invokeExpr.getMethodRef().getSubSignature().toString())) {
                        //found bind service call!
                        System.out.println("Found " + invokeExpr + " in " + method);
                        SootClass bindTarget = findTargetOfBind(stmtBody, stmt);
                        System.out.println(bindTarget + "\n");
                        if (bindTarget != null) {
                            serviceConns.addVertex(bindTarget);
                            serviceConns.addVertex(clz);
                            serviceConns.addEdge(clz, bindTarget);
                        }
                    }
                }
            }
        } 
    }

}
