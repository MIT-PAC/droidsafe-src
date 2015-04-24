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

import java.util.Set;

import soot.Body;
import soot.Context;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.SootMethod;

/**
 * @author mgordon
 * @author dpetters
 */
public interface VATransform {
    /**
     * transforms the invokeExpr if the signature of the method it calls (callee, as resolved by PTA) matches one that 
     * of the ones returned by sigsOfInvokesToTransform
     */
    public void tranformsInvoke(SootMethod containingMthd, SootMethod callee, InvokeExpr invokeExpr, Stmt stmt, Body body);

    /**
     * @return set of string method signatures. Matching invokeExpr will be transformed by this transformation
     */
    public Set<String> sigsOfInvokesToTransform();
}
