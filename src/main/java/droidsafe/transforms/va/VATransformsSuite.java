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

import droidsafe.analyses.pta.PTABridge;
import droidsafe.reports.UnresolvedICC;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.toolkits.callgraph.Edge;
import soot.util.Chain;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.system.API;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;
import soot.Context;
import soot.MethodOrMethodContext;
import soot.SootMethod;


/**
 * @author mgordon
 * @author dpetters
 */
public class VATransformsSuite  {
    private List<VATransform> transforms = Arrays.asList(
        new StartActivityTransform(),
        new ServiceBindTransform(),
        new StartServiceTransform(),
        new BroadcastReceiverTransform(),
        new ContentProviderTransform(),
        new NewInstanceTransform(),
        new MethodInvokeTransform()
            );

    // enforce singleton pattern
    private VATransformsSuite() {}
    
    private static VATransformsSuite v;
    
    public static VATransformsSuite v() {
        if (v == null)
            v = new VATransformsSuite();
        return v;
    }

    public static void run() {             
        v().visitMethodContexts();
    }

    public List<VATransform> getTransforms() {
        return transforms;
    }
    

    public void visitMethodContexts() {
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

                // we only transform invoke expressions
                if (!stmt.containsInvokeExpr())
                    continue;
                InvokeExpr invokeExpr = (InvokeExpr)stmt.getInvokeExpr();

                for (VATransform transform : transforms) { 
                    for (SootMethod callee : PTABridge.v().getTargetsInsNoContext(containingMthd, stmt)) {
                        if (isInvokeCandidateForTransform(transform, callee)) {
                            transform.tranformsInvoke(containingMthd, callee, invokeExpr, stmt, stmtBody);
                        }
                    } 
                }     
                
            }
        }
    }

    /**
     * @return   true if the name of the method of the invoke is a possible candidate for the transformation
     *           false otherwise
     */
    private boolean isInvokeCandidateForTransform(VATransform transform, SootMethod method) {
        return transform.sigsOfInvokesToTransform().contains(method.getSignature());
    }
}
