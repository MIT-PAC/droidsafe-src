package droidsafe.analyses.rcfg;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.pta.PTAMethodInformation;
import soot.Context;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.pta.IAllocNode;

/**
 * A node in the forest of the rCFG.  This represents and input event (an entry point into
 * user code from the API), and the set of output events that could be called.  Output events 
 * are api calls that are interesting.
 * 
 * @author mgordon
 *
 */
public class RCFGNode implements PTAMethodInformation {
    /** logger object */
    private static final Logger logger = LoggerFactory.getLogger(RCFGNode.class);
    /** The edge representing the Input Event entry point */
	private Edge eventEdge;
	/** The list of output events associated with the input event */
	private Map<Edge, OutputEvent> outputEvents;
	/** the invoke expression that triggers the input event */
	private InvokeExpr invokeExpr;

	/** 
	 * Create a new RCFG Node with the given input event entry edge.
	 */
	public RCFGNode(Edge eventEdge) {
		outputEvents = new LinkedHashMap<Edge, OutputEvent>();
		this.eventEdge = eventEdge;
		if (eventEdge.srcStmt() != null && eventEdge.srcStmt().containsInvokeExpr())
		    invokeExpr = (InvokeExpr)eventEdge.srcStmt().getInvokeExpr();
		else
		    invokeExpr = null;
	}
	
	/**
	 * Return the context of the entry method that is called.
	 */
	public Edge getEdge() {
	    return eventEdge;
	}
	
	/**
	 * Add a new output event to this input event rCFG node.
	 */
	public void addOutputEvent(Edge edge, OutputEvent oe) {
	    if (outputEvents.containsKey(edge)) {
	        logger.error("Creating OutputEvent with Edge already in RCFGNode");
	        droidsafe.main.Main.exit(1);
	    }
	    
		outputEvents.put(edge, oe);
		logger.debug("Found output event: {}", edge);
	}

	
	/**
	 * Does the rcfg node contain an output event for the given edge
	 */
	public boolean hasOutputEventEdge(Edge e) {
	    return outputEvents.containsKey(e);
	}
	
	/**
	 * Return the output event associated with the edge.
	 */
	public OutputEvent getOutputEvent(Edge e) {
	    return outputEvents.get(e);
	}
	
	/**
	 * Return the SootMethod for the entry point.
	 */
	public SootMethod getEntryPoint() {
		return eventEdge.tgt();
	}

	/**
	 * Return list of all output events for this node.
	 */
	public Collection<OutputEvent> getOutputEvents() {
		return outputEvents.values();
	}

	/**
	 * Return the invoke expression that calls this input event (api -> app code).
	 */
	public InvokeExpr getInvokeExpr() {
	    return invokeExpr;
	}
	
	/**
	 * Return the string representation for this rCFG node.
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		str.append(getEntryPoint() + "\n");
		for (OutputEvent oe : getOutputEvents()) {
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
	    
	    return PTABridge.v().isPointer(rec);
	}
	
	/**
	 * Return the PT set as calculated by GeoPTA without context.
	 * @return
	 */
	public Set<IAllocNode> getReceiverPTSet() {
	    if (isReceiverPointer()) 
	        return (Set<IAllocNode>)PTABridge.v().getPTSet(getReceiver(), getEdge().srcCtxt());
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
	    return PTABridge.v().isPointer(getArgValue(i));
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
	public Set<? extends IAllocNode> getArgPTSet(int i) {
	    if (!isArgPointer(i))
	        return null;
	    
	    return PTABridge.v().getPTSet(getArgValue(i), getEdge().srcCtxt());
	}
}
