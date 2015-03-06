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

package droidsafe.utils;

import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.jimple.SpecialInvokeExpr;

/**
 * Used to denote that a method cannot be found during a search.  Most prominently used to 
 * denote that a method cannot be found for an instance invoke expression (a virtual call).
 * 
 * @author mgordon
 *
 */
public class CannotFindMethodException extends Exception {
    /** serialization id */
    private static final long serialVersionUID = 1L;

    /**
     * Create new exception with clz and method that cannot be found.
     */
    public CannotFindMethodException(SootClass clz, SootMethod method) {
        super(String.format("Cannot find or resolve %s in %s.", method, clz));
    }
    
    /**
     * Create new exception with clz and method that cannot be found.
     */
    public CannotFindMethodException(SootClass clz, SootMethodRef method) {
        super(String.format("Cannot find or resolve %s in %s.", method, clz));
    }
    
    /**
     * Create new exception for a special invoke.
     */
    public CannotFindMethodException(SpecialInvokeExpr invoke, SootMethod method) {
        super(String.format("Cannot find or resolve %s in %s.", invoke, method));
    }
    
    /**
     * Create new exception with type and method that cannot be found (for a receiver)
     */
    public CannotFindMethodException(Type t, SootMethod method) {
        super(String.format("Cannot find or resolve method %s with type of receiver %s.", method,
            t));
    }
}
