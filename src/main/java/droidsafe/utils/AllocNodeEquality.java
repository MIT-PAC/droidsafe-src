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

import soot.jimple.spark.pag.ContextElement;
import soot.jimple.spark.pag.ObjectSensitiveAllocNode;
import soot.jimple.toolkits.pta.IAllocNode;

// Equality on alloc nodes that compares the content instead of the identity. Used in ParameterizedHashMap or 
// ParameterizedLinkedHashMap when a map on alloc nodes needs to be queried when additional pta runs were done
// after map creation.
public class AllocNodeEquality implements Equality {
    
    static AllocNodeEquality v; 
    
    public static AllocNodeEquality v() {
        if (v == null)
            v = new AllocNodeEquality();
        return v;
    }
    
    @Override
    public int hashCode(Object obj) {
        if (obj instanceof IAllocNode) {
            IAllocNode allocNode = (IAllocNode) obj;
            if (allocNode instanceof ObjectSensitiveAllocNode) {
                ObjectSensitiveAllocNode osan = (ObjectSensitiveAllocNode) allocNode;
                int n = osan.numContextElements();
                if (n == 0)
                    return 0;
                int result = 1;
                for (int i = 0; i < n; i++) {
                    ContextElement element = osan.getContextElement(i);
                    result = 31 * result + (element == null ? 0 : hashCode(element));
                }
                return result;
            }
            Object newExpr = allocNode.getNewExpr();
            return ((newExpr == null) ? 0 : newExpr.hashCode());
        }
        return obj.hashCode();
    }

    @Override
    public boolean equals(Object obj, Object other) {
        if (obj == other) return true;
        if (other == null) return false;
        if (obj.getClass() != other.getClass()) return false;
        if (obj instanceof IAllocNode) {
            IAllocNode allocNode = (IAllocNode) obj;
            IAllocNode otherAllocNode = (IAllocNode) other;
            if (allocNode instanceof ObjectSensitiveAllocNode) {
                ObjectSensitiveAllocNode osan = (ObjectSensitiveAllocNode) allocNode;
                ObjectSensitiveAllocNode otherOsan = (ObjectSensitiveAllocNode) otherAllocNode;
                if (osan.numContextElements() != otherOsan.numContextElements())
                    return false;
                for (int i = 0; i < osan.numContextElements(); i++) {
                    Object o1 = osan.getContextElement(i);
                    Object o2 = otherOsan.getContextElement(i);
                    if (!(o1==null ? o2==null : equals(o1, o2)))
                        return false;                
                }
                return true;
            }
            Object newExpr = allocNode.getNewExpr();
            Object otherNewExpr = otherAllocNode.getNewExpr();
            if (newExpr == null) {
                if (otherNewExpr != null) return false;
            } else if (!newExpr.equals(otherNewExpr)) return false;
            return true;
        }
        return obj.equals(other);
    }

}
