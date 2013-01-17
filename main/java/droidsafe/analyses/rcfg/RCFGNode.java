package droidsafe.analyses.rcfg;

import java.util.LinkedList;
import java.util.List;

import soot.SootMethod;
import soot.jimple.toolkits.callgraph.Edge;

public class RCFGNode {
	private Edge entryEdge;
	
	private List<OutputEvent> outputEvents;

	public RCFGNode(Edge entryEdge) {
		outputEvents = new LinkedList<OutputEvent>();
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
	
	public SootMethod getEntryPoint() {
		return entryEdge.tgt();
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		str.append(getEntryPoint() + "\n");
		for (OutputEvent oe : outputEvents) {
			str.append("\t" + oe.toString().replaceAll("\n", "\n\t") + "\n");
		}
		
		return str.toString();
	}
}
