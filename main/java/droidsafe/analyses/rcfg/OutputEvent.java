package droidsafe.analyses.rcfg;

import java.util.Formatter;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.DynamicInvokeExpr;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.StringConstantNode;
import soot.jimple.toolkits.callgraph.Edge;
import droidsafe.analyses.GeoPTA;
import droidsafe.utils.SourceLocationTag;
import droidsafe.utils.Utils;

/**
 * This class represents an API call in the rCFG.  It is associated with an rCFG node (an input event).  
 * Each output event currently has an underlying soot method, a context edge, a calling edge, and possibly a 
 * receiver.  
 * 
 * @author mgordon
 *
 */
public class OutputEvent {
    /** logger field */
	private final static Logger logger = LoggerFactory.getLogger(OutputEvent.class);
	/** the cg edge from caller to API */
	private Edge thisEdge;
	/** the cg context edge from previous caller to caller */
	private Edge contextEdge;
	/** The invoke expression call to an API method, might be null EX finalize*/
	private InvokeExpr invokeExpr;
	/** The parent RFCG Node */
	private RCFGNode parent;
	private SourceLocationTag linesTag = null;
	/** The specific receiver node that triggers this output event */
	private AllocNode receiverNode;
	
	/**
	 * Create an output event from an edge, context edge, ... 
	 */
	public OutputEvent(Edge thisEdge, Edge contextEdge, RCFGNode parent, 
	                   AllocNode receiverNode, SourceLocationTag ln) {
		this.thisEdge = thisEdge;
		this.contextEdge = contextEdge;
		this.parent = parent;
		this.receiverNode = receiverNode;
		this.linesTag = ln;
		
		setInvoke();
	}
	
	/**
	 * Try to grab the invoke expression from the context
	 */
	private void setInvoke() {
		Unit context = thisEdge.srcUnit();
		invokeExpr = null;
		
		if (context == null) {
			return;
		}
		
		for (Object vb : context.getUseAndDefBoxes()) {
			Value value = ((ValueBox)vb).getValue();
			
			if (value instanceof InvokeExpr) {
				InvokeExpr ie = (InvokeExpr)value;
				logger.debug("Found invoke in output event {} matches {}?", ie, this.getTarget());
				//old check that does not work for threads since start calls run...
				//if (Hierarchy.v().canResolveTo(ie.getMethodRef(), this.getTarget())) 
				if (invokeExpr != null)
					Utils.logErrorAndExit(logger, "Found multiple matches for calling context in context statement {}.",
					    context);
				invokeExpr = ie;
			}
		}
		
		if (invokeExpr == null) {
			logger.error("Cannot find context invoke expr in context: {}.", context);
			System.exit(1);
		}
		if (invokeExpr instanceof SpecialInvokeExpr && !hasReceiver()) {
			logger.error("Found special invoke expr without a receiver {}", invokeExpr);
			System.exit(1);
		}
		
		//ever instance invoke should have a receiver, unless something wrong with user code or with modeling or with
		//PTA
		if (hasReceiver() != (invokeExpr instanceof InstanceInvokeExpr)) {
			logger.info("Presence of receiver is wrong for invoke expr type: {} and {} receiver (line {}).", 
			    invokeExpr, hasReceiver(), linesTag);
		}
		
		//do some checks for things we might not fully understand yet.
		if (invokeExpr instanceof DynamicInvokeExpr) {
			Utils.logErrorAndExit(logger, "Do not understand type of invoke expr: {}", invokeExpr.getClass());
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
		return receiverNode != null; 
	}
	
	
	/**
	 * Return the value of the receiver, probably a field or local variable.
	 */
	public Value getReceiver() {
		if (!hasReceiver()) {
			logger.error("Trying to get receiver for output event without one: {}.", this.toString());
			System.exit(1);
		}
		
		return ((InstanceInvokeExpr)invokeExpr).getBase();
	}
	
	/**
	 * Return the edge that called this input event's method.
	 */
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
	public AllocNode getReceiverAlloc() {
		getReceiver();
		
		return receiverNode; 
	}
	
	/**
	 * Return the type in the points to set of the receiver.
	 */
	public Type getReceiverType() {
		return receiverNode.getType();
	}
	
	/**
	 * Return the type of the value for the argument, does not look 
	 * at the points to set.
	 */
	public Type getArgumentType(int i) {
		return getArgValue(i).getType();
	}
	
	/**
	 * Return the points to set for the pointer argument at index i.
	 */
	public Set<AllocNode> getArgPTSet(int i) {
		Value v = getArgValue(i);
		return GeoPTA.v().getPTSet(v, contextEdge);
	}
	
	/**
	 * Return the context edge.
	 */
	public Edge getContextEdge() {
		return contextEdge;
	}
	
	/**
	 * Set the context edge.
	 */
	public void setContextEdge(Edge contextEdge) {
		this.contextEdge = contextEdge;
	}
	
	/**
	 * Get the target soot method of this output event.
	 * @return
	 */
	public SootMethod getTarget() {
		return thisEdge.tgt();
	}
	
	/**
	 * Return the argument expression for the call to the API method.
	 */
	public Value getArgValue(int i) {
		if (i > getNumArgs()) 
			Utils.logErrorAndExit(logger, "Trying to invalid argument {} for output event {}.", i, getTarget());
		
		return invokeExpr.getArg(i);
	}
	
	/**
	 * Return true if arg i value is a pointer in the PT graph.
	 */
	public boolean isArgPointer(int i) {
		return GeoPTA.v().isPointer(getArgValue(i));
	}
	
	/**
	 * Return the enclosing RCFGNode.
	 */
	public RCFGNode getParent() {
		return parent;
	}
	
	/** 
	 * Get the source location tag for this output event.
	 */
	public SourceLocationTag getSourceLocationTag() {
		return linesTag;
	}
	
	/**
	 * Return a string representation of the OutputEvent.
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		Formatter formatter = new Formatter(str, Locale.US);
		str.append(getTarget() + "\n");
		
		if (hasReceiver()) {
			formatter.format("\tReceiver: %s (%s)\n", getReceiver(), getReceiver().getClass());
			str.append("\t\tPT Set:\n");
			
			formatter.format("\t\tNode: %s (%s)\n", receiverNode, receiverNode.getClass());
			
			for (int i = 0; i < getNumArgs(); i++) {
				if (isArgPointer(i)) {
					Set<AllocNode> nodes = getArgPTSet(i);
					formatter.format("\tArg %d (size %d)\n", i, nodes.size());
					for (AllocNode node : nodes) {
						if (node instanceof StringConstantNode) {
							formatter.format("\t\tString Constant: %s %s\n", node, ((StringConstantNode)node).getString());
						} else {
							formatter.format("\t\tNode: %s (%s), New expr: %s (%s)\n", node, node.getClass(), node.getNewExpr(), 
								node.getNewExpr().getClass());
						}
					}
				} else {
					formatter.format("\tArg %d: %s (%s)\n", i, getArgValue(i).getClass(), getArgValue(i));
				}
			}
		}
		formatter.close();
		return str.toString();
	}
}
