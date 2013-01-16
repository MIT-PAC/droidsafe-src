package droidsafe.analyses.rcfg;

import soot.jimple.toolkits.callgraph.Edge;

public class OutputEvent {
	private Edge thisEdge;
	private Edge contextEdge;
	
	public Edge getThisEdge() {
		return thisEdge;
	}
	
	public void setThisEdge(Edge thisEdge) {
		this.thisEdge = thisEdge;
	}
	
	public Edge getContextEdge() {
		return contextEdge;
	}
	
	public void setContextEdge(Edge contextEdge) {
		this.contextEdge = contextEdge;
	}
	
	public String toString() {
		return "";
	}
}
