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

package droidsafe.reports;

import soot.SootClass;
import soot.SootMethod;
import soot.jimple.Stmt;

import com.google.gson.annotations.SerializedName;

import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;

public abstract class SourceContent {
    
    @SerializedName("src-loc")
    SourceLocationTag src_loc;
    
    protected void setSource(Stmt genStmt) {
        SootMethod method = JimpleRelationships.v().getEnclosingMethod(genStmt);
        src_loc = SootUtils.getSourceLocation(genStmt);
    }
    
    protected void setSource(SootMethod method) {
        src_loc = SootUtils.getMethodLocation(method);
    }
    
    protected void setSource(SourceLocationTag slt) {
        this.src_loc = slt;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((src_loc == null) ? 0 : src_loc.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        SourceContent other = (SourceContent) obj;
        if (src_loc == null) {
            if (other.src_loc != null) return false;
        } else if (!src_loc.equals(other.src_loc)) return false;
        return true;
    }
    
    
}