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

import java.util.Set;

import soot.Body;
import soot.Unit;
import soot.jimple.Stmt;
import soot.toolkits.graph.BriefBlockGraph;
import soot.toolkits.graph.BriefUnitGraph;
import soot.toolkits.graph.UnitGraph;

class InfoBriefBlockGraph extends BriefBlockGraph {
    public InfoBriefBlockGraph(Body body) {
        super(body);
    }

    public InfoBriefBlockGraph(BriefUnitGraph unitGraph) {
        super(unitGraph);
    }

    protected Set<Unit> computeLeaders(UnitGraph unitGraph) {
        Set<Unit> leaders = super.computeLeaders(unitGraph);
        for (Unit curr : unitGraph.getBody().getUnits()) {
            if (((Stmt)curr).containsInvokeExpr()) {
                for (Unit succ : unitGraph.getSuccsOf(curr)) {
                    leaders.add(succ);
                }
            }
        }
        return leaders;
    }
}
