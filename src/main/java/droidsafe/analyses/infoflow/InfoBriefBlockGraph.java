package droidsafe.analyses.infoflow;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringEscapeUtils;

import soot.Body;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.Stmt;
import soot.toolkits.graph.Block;
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
    
    public String toString(SootMethod method, Block start) {
		Map<Block, Integer> blockNumbers = new HashMap<Block, Integer>();
		StringBuilder sb = new StringBuilder("digraph " + method.getName() + "CFG {\n");
		
		// generate the nodes
		int bIdx = 0;
		int instOff = 0;
		for (Block b : this) {
			blockNumbers.put(b, bIdx);
			sb.append("  bb");
			sb.append(bIdx);
			sb.append(" [shape=none, margin=0, label=<\n");
			if (b.equals(start))
				sb.append("    <table bgcolor=\"#FF6666\" border=\"0\" cellborder=\"1\" cellspacing=\"0\" cellpadding=\"4\">\n");
			else
				sb.append("    <table border=\"0\" cellborder=\"1\" cellspacing=\"0\" cellpadding=\"4\">\n");
			int idx = b.getIndexInMethod();
			for (Unit unit : b) {
				sb.append("      <tr><td align=\"left\">");
				sb.append(idx+instOff);
				sb.append("</td><td align=\"left\">");
				sb.append(StringEscapeUtils.escapeHtml4(unit.toString()));
				sb.append("</td></tr>\n");
				instOff++;
			}
			instOff--;
			sb.append("    </table>>];\n");
			bIdx++;
		}
		
		// generate the edges
		for (Block b : this) {
			int bFrom = blockNumbers.containsKey(b) ? blockNumbers.get(b) : blockNumbers.size();
			for (Block succ : getSuccsOf(b)) {
				int bTo = blockNumbers.containsKey(succ) ? blockNumbers.get(succ) : blockNumbers.size();
				sb.append("  bb");
				sb.append(bFrom);
				sb.append(" -> bb");
				sb.append(bTo);
				sb.append(";\n");
			}
		}
		
		sb.append("}");
		return sb.toString();
	}
	
	public void toDotFile(SootMethod method, File destDir, String prefix, Block start) throws IOException {
		if (!destDir.exists()) {
			if (!destDir.mkdirs())
				throw new IOException("could not create directory " + destDir);
		} else if (!destDir.isDirectory()) {
			throw new IOException(destDir + " exists, but is a file");
		}
		
		String className = method.getDeclaringClass().getName();
		try (PrintWriter fileOut = new PrintWriter(new File(destDir,
				className + "." + method.getName() + "." + start.getIndexInMethod() 
				+ prefix + ".dot"))) {
			fileOut.println(this.toString(method, start));
		}
	}

}
