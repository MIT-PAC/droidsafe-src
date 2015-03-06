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

package droidsafe.analyses.infoflow;

import java.util.HashSet;
import java.util.Set;

import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;

import droidsafe.main.Config;

class ObjectUtils {
    SootField taint;
    Set<SootMethod> addTaints;
    Set<SootMethod> getTaints;
    Set<SootMethod> toTaints;

    ObjectUtils() {
        SootClass klass = Scene.v().getSootClass("java.lang.Object");
        if (Config.v().strict) {
            assert klass != null;
        }
        taint = klass.getFieldByName("taint");
        if (Config.v().strict) {
            assert taint != null;
        }
        addTaints = new HashSet<SootMethod>();
        getTaints = new HashSet<SootMethod>();
        toTaints = new HashSet<SootMethod>();
        for (SootMethod method : klass.getMethods()) {
            if (method.getName().startsWith("addTaint")) {
                addTaints.add(method);
            } else if (method.getName().startsWith("getTaint")) {
                getTaints.add(method);
            } else if (method.getName().startsWith("toTaint")) {
                toTaints.add(method);
            }
        }
    }

    boolean isAddTaint(SootMethod method) {
        return addTaints.contains(method);
    }

    boolean isGetTaint(SootMethod method) {
        return getTaints.contains(method);
    }

    boolean isToTaint(SootMethod method) {
        return toTaints.contains(method);
    }
}
