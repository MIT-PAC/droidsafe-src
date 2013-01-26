package droidsafe.analyses.rcfg;

import java.util.Formatter;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.GeoPTA;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;
import droidsafe.utils.Utils;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.DynamicInvokeExpr;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.Stmt;
import soot.jimple.StringConstant;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.Node;
import soot.jimple.spark.pag.StringConstantNode;
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
	/** The parent RFCG Node */
	private RCFGNode parent;	
	private SourceLocationTag linesTag = null;
	
	public OutputEvent(Edge thisEdge, Edge contextEdge, RCFGNode parent, SourceLocationTag ln) {
		this.thisEdge = thisEdge;
		this.contextEdge = contextEdge;
		this.parent = parent;
		this.linesTag = ln;
		
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
				logger.debug("Found invoke in output event {} matches {}?", ie, this.getTarget());
				//old check that does not work for threads since start calls run...
				//if (Hierarchy.v().canResolveTo(ie.getMethodRef(), this.getTarget())) 
				if (invokeExpr != null)
					Utils.ERROR_AND_EXIT(logger, "Found multiple matches for calling context in context statement {}.", context);
				invokeExpr = ie;
			}
		}
		
		if (invokeExpr == null) {
			logger.error("Cannot find context invoke expr in context: {}.", context);
			System.exit(1);
		}
		
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
	 * Return all of the types possible in the points to set of the receiver.
	 */
	public Set<Type> getReceiverTypes() {
		return GeoPTA.v().getTypes(getReceiver(), contextEdge);		
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
	
	public RCFGNode getParent() {
		return parent;
	}
	
	public SourceLocationTag getSourceLocationTag() {
		return linesTag;
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
