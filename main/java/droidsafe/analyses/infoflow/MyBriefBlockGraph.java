package droidsafe.analyses.infoflow;

import java.util.Set;

import soot.Body;
import soot.Unit;
import soot.jimple.Stmt;
import soot.toolkits.graph.BriefBlockGraph;
import soot.toolkits.graph.BriefUnitGraph;
import soot.toolkits.graph.UnitGraph;

class MyBriefBlockGraph extends BriefBlockGraph {
    public MyBriefBlockGraph(Body body) {
        super(body);
    }

    public MyBriefBlockGraph(BriefUnitGraph unitGraph) {
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
