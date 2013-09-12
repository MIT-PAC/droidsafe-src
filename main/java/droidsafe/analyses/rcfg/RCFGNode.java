package droidsafe.analyses.rcfg;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.PTAMethodInformation;

import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.Edge;

/**
 * A node in the forest of the rCFG.  This represents and input event (an entry point into
 * user code from the API), and the set of output events that could be called.  Output events 
 * are api calls that are interesting.
 * 
 * @author mgordon
 *
 */
public class RCFGNode implements PTAMethodInformation {
    /** The edge representing the Input Event entry point */
	private Edge entryEdge;
	/** The list of output events associated with the input event */
	private List<OutputEvent> outputEvents;
	/** the invoke expression that triggers the input event */
	private InvokeExpr invokeExpr;

	/** 
	 * Create a new RCFG Node with the given input event entry edge.
	 */
	public RCFGNode(Edge entryEdge) {
		outputEvents = new LinkedList<OutputEvent>();
		this.entryEdge = entryEdge;
		if (entryEdge.srcStmt().containsInvokeExpr())
		    invokeExpr = (InvokeExpr)entryEdge.srcStmt().getInvokeExpr();
		else
		    invokeExpr = null;
	}
	
	/**
	 * Return the call graph edge that defines the entry point of the rCFG.
	 */
	public Edge getEntryEdge() {
		return entryEdge;
	}
	
	/**
	 * Add a new output event to this input event rCFG node.
	 */
	public void addOutputEvent(OutputEvent e) {
		outputEvents.add(e);
	}

	/**
	 * Return the SootMethod for the entry point.
	 */
	public SootMethod getEntryPoint() {
		return entryEdge.tgt();
	}

	/**
	 * Return list of all output events for this node.
	 */
	public List<OutputEvent> getOutputEvents() {
		return outputEvents;
	}

	/**
	 * Return the string representation for this rCFG node.
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		str.append(getEntryPoint() + "\n");
		for (OutputEvent oe : outputEvents) {
			str.append("\t" + oe.toString().replaceAll("\n", "\n\t") + "\n");
		}
		
		return str.toString();
	}
	
	/**
	 * Return the return type of the IE method.
	 */
	public Type getReceiverType() {
	    return getReceiver().getType();
	}
	
	/**
	 * Return the type of argument i.
	 */
	public Type getArgumentType(int i) {
	    return getEntryPoint().getParameterType(i);
	}
	
	/**
	 * Return true if the input event should have a receiver object.
	 */
	public boolean hasReceiver() {
	    return invokeExpr != null && invokeExpr instanceof InstanceInvokeExpr;
	}
	
	
	/**
	 * If the input event has a receiver, the return the receiver value,
	 * otherwise return null;
	 */
	public Value getReceiver() {
	    if (!hasReceiver())
	        return null;
	    return ((InstanceInvokeExpr)invokeExpr).getBase();
	}
	
	/** 
	 * Return true if the receiver of the input event is a pointer.
	 * @return
	 */
	public boolean isReceiverPointer() {
	    Value rec = getReceiver();
	    if (rec == null)
	        return false;
	    
	    return GeoPTA.v().isPointer(rec);
	}
	
	/**
	 * Return the PT set as calculated by GeoPTA without context.
	 * @return
	 */
	public Set<AllocNode> getReceiverPTSet() {
	    if (isReceiverPointer()) 
	        return GeoPTA.v().getPTSetContextIns(getReceiver());
	    else
	        return null;
	}
	
	/**
	 * Return the argument for the IE at i. 
	 */
	public Value getArgValue(int i) {
	    return invokeExpr.getArg(i);
	}
	
	/**
	 * Is the argument for the IE at i a pointer?
	 */
	public boolean isArgPointer(int i) {
	    return GeoPTA.v().isPointer(getArgValue(i));
	}
	
	/**
	 * Return the number or args for the input event.
	 */
	public int getNumArgs() {
	    if (invokeExpr == null)
	        return 0;
	    
	    return invokeExpr.getArgCount();
	}
	
	/**
	 * For a pointer arg value at i, return the PTA result (insensitive). 
	 */
	public Set<AllocNode> getArgPTSet(int i) {
	    if (!isArgPointer(i))
	        return null;
	    
	    return GeoPTA.v().getPTSetContextIns(getArgValue(i));
	}
}
