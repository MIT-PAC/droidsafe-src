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

package checks;

import java.util.Iterator;

import soot.Body;
import soot.PrimType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.VoidType;
import soot.jimple.NullConstant;
import soot.jimple.ReturnStmt;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.util.Chain;

public class MethodsAlwaysReturnNull {

    public static void run() {
        for (SootClass clz : Scene.v().getClasses()) {
            for (SootMethod method : clz.getMethods()) {
                if (!method.isConcrete() || method.isAbstract()) 
                    continue;
                
                if (method.getReturnType() instanceof PrimType ||
                        method.getReturnType() instanceof VoidType)
                    continue;
                
                method.retrieveActiveBody();

                Body body = method.getActiveBody();
                StmtBody stmtBody = (StmtBody)body;
                Chain units = stmtBody.getUnits();
                Iterator stmtIt = units.iterator();

                int returns = 0;
                int returnNull = 0;
                
                while (stmtIt.hasNext()) {
                    Stmt stmt = (Stmt)stmtIt.next();

                    if (stmt instanceof ReturnStmt) {
                        returns++;
                        
                        if (((ReturnStmt)stmt).getOp() instanceof NullConstant)
                            returnNull++;
                    }
                }
                
                if (returns > 0 && returns == returnNull)
                    System.out.println("Only return null: " + method);
            }
        }
        
    }

}
