package droidsafe.analyses.rcfg;

import java.util.Formatter;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.GeoPTA;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.utils.Utils;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.DynamicInvokeExpr;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.Stmt;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.Node;
import soot.jimple.toolkits.callgraph.Edge;

/**
 * 
 * 
 * @author mgordon
 *
 */
public class OutputEvent {
	private final static Logger logger = LoggerFactory.getLogger(OutputEvent.class);
	/** the cg edge from caller to API */
	private Edge thisEdge;
	/** the cg context edge from previous caller to caller */
	private Edge contextEdge;
	/** The invoke expression call to an API method */
	private InvokeExpr invokeExpr;
		
	public OutputEvent(Edge thisEdge, Edge contextEdge) {
		this.thisEdge = thisEdge;
		this.contextEdge = contextEdge;
		
		setInvoke();
	}
	
	/*
	 * Try to grab the invoke expression from the context
	 */
	private void setInvoke() {
		Unit context = thisEdge.srcUnit();
		invokeExpr = null;
		
		for (Object vb : context.getUseAndDefBoxes()) {
			Value value = ((ValueBox)vb).getValue();
			
			if (value instanceof InvokeExpr) {
				InvokeExpr ie = (InvokeExpr)value;
				if (Hierarchy.v().canResolveTo(ie.getMethodRef(), this.getTarget())) {
					if (invokeExpr != null)
						Utils.ERROR_AND_EXIT(logger, "Found multiple matches for calling context in context statement {}.", context);
					invokeExpr = ie;
				}
			}
		}
		
		if (invokeExpr == null) 
			Utils.ERROR_AND_EXIT(logger, "Cannot find context invoke expr in context: {}.", context);
		
		//do some checks for things we might not fully understand yet.
		if (invokeExpr instanceof DynamicInvokeExpr) {
			Utils.ERROR_AND_EXIT(logger, "Do not understand type of invoke expr: {}", invokeExpr.getClass());
		}
	}
	
	/** 
	 * Return the number of args in the invoke expression.
	 */
	public int getNumArgs() {
		return invokeExpr.getArgCount();
	}
	
	/**
	 * Return true if the method call has a receiver.
	 * @return
	 */
	public boolean hasReceiver() {
		return (invokeExpr instanceof InstanceInvokeExpr); 
	}
	
	
	/**
	 * Return the value of the receiver, probably a field or local variable.
	 */
	public Value getReceiver() {
		if (!hasReceiver()) {
			Utils.ERROR_AND_EXIT(logger, "Trying to get receiver for output event without one: {}.", this.toString());
		}
		
		return ((InstanceInvokeExpr)invokeExpr).getBase();
	}
	
	public Edge getThisEdge() {
		return thisEdge;
	}
	
	public void setThisEdge(Edge thisEdge) {
		this.thisEdge = thisEdge;
	}
	
	/**
	 * Return the points to set of the receiver (if it exists) in the context of this
	 * output event.
	 */
	public Set<AllocNode> getReceiverPTSet() {
		return GeoPTA.v().getPTSet(getReceiver(), contextEdge);
	}
	
	/**
	 * Return the points to set for the pointer argument at index i.
	 */
	public Set<AllocNode> getArgPTSet(int i) {
		Value v = getArgValue(i);
		return GeoPTA.v().getPTSet(v, contextEdge);
	}
	
	public Edge getContextEdge() {
		return contextEdge;
	}
	
	public void setContextEdge(Edge contextEdge) {
		this.contextEdge = contextEdge;
	}
	
	public SootMethod getTarget() {
		return thisEdge.tgt();
	}
	
	/**
	 * Return the argument expression for the call to the API method.
	 */
	public Value getArgValue(int i) {
		if (i > getNumArgs()) 
			Utils.ERROR_AND_EXIT(logger, "Trying to invalid argument {} for output event {}.", i, getTarget());
		
		return invokeExpr.getArg(i);
	}
	
	/**
	 * Return true if arg i value is a pointer in the PT graph.
	 */
	public boolean isArgPointer(int i) {
		return GeoPTA.v().isPointer(getArgValue(i));
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		Formatter formatter = new Formatter(str, Locale.US);
		str.append(getTarget() + "\n");
		
		if (hasReceiver()) {
			formatter.format("\tReceiver: %s (%s)\n", getReceiver(), getReceiver().getClass());
			str.append("\t\tPT Set:\n");
			for (AllocNode node : getReceiverPTSet()) {
				formatter.format("\t\tNode: %s (%s)\n", node, node.getClass());
			}
			for (int i = 0; i < getNumArgs(); i++) {
				if (isArgPointer(i)) {
					str.append("\tArg " + i + "\n");
					Set<AllocNode> nodes = getArgPTSet(i);
					for (AllocNode node : nodes) 
						formatter.format("\t\tNode: %s (%s)\n", node, node.getClass());
				} else {
					formatter.format("\tArg %d: %s\n", i, getArgValue(i).getClass());
				}
			}
		}
		formatter.close();
		return str.toString();
	}
}
