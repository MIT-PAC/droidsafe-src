package droidsafe.analyses.rcfg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.utils.Utils;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.Edge;

public class OutputEvent {
	private final static Logger logger = LoggerFactory.getLogger(OutputEvent.class);
	/** the cg edge from caller to API */
	private Edge thisEdge;
	/** the cg context edge from previous caller to caller */
	private Edge contextEdge;
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
	}
	
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
	
	public SootMethod getTarget() {
		return thisEdge.tgt();
	}
	
	public int getArgs() {
		return getTarget().getParameterCount();
	}
	
	public String toString() {
		return getTarget().toString();
	}
}
