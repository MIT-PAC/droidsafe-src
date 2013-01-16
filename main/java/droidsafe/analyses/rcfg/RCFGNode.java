package droidsafe.analyses.rcfg;

import java.util.List;

import soot.SootMethod;
import soot.jimple.toolkits.callgraph.Edge;

public class RCFGNode {
	private Edge entryEdge;
	
	private List<OutputEvent> outputEvents;

	public RCFGNode(Edge entryEdge) {
		this.entryEdge = entryEdge;
	}
	
	public Edge getEntryEdge() {
		return entryEdge;
	}

	public void setEntryEdge(Edge entryEdge) {
		this.entryEdge = entryEdge;
	}
	
	public void addOutputEvent(OutputEvent e) {
		outputEvents.add(e);
	}
	
}
