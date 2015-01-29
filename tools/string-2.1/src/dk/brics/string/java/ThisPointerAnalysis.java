package dk.brics.string.java;

import java.util.HashSet;
import java.util.Set;

import soot.Local;
import soot.Unit;
import soot.Value;
import soot.jimple.DefinitionStmt;
import soot.jimple.Stmt;
import soot.jimple.ThisRef;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.scalar.ForwardFlowAnalysis;

/**
 * Determines which variables definitely refer to <tt>this</tt> at each program point.
 * <p/>
 * This class has been well tested, but is currently unused.
 */
public class ThisPointerAnalysis extends ForwardFlowAnalysis<Unit, Set<Local>> {
	
	public ThisPointerAnalysis(ExceptionalUnitGraph g) {
		super(g);
		doAnalysis();
	}
	
	public Set<Local> getThisLocalsBefore(Stmt stmt) {
		return super.getFlowBefore(stmt);
	}
	public Set<Local> getThisLocalsAfter(Stmt stmt) {
		return super.getFlowAfter(stmt);
	}
	
	@Override
	protected void flowThrough(Set<Local> in, Unit node, Set<Local> out) {
		out.clear();
		out.addAll(in);
		
		Stmt stmt = (Stmt)node;
		if (!(stmt instanceof DefinitionStmt)) {
			return;
		}
		
		DefinitionStmt def = (DefinitionStmt)stmt;
		Value left = def.getLeftOp();
		if (!(left instanceof Local)) {
			return;
		}
		
		Local local = (Local)left;
		
		Value right = def.getRightOp();
		if (right instanceof ThisRef) {
			out.add(local);
		} else if (right instanceof Local && in.contains(right)) {
			out.add(local);
		} else {
			out.remove(local);
		}
	}
	
	@Override
	protected void copy(Set<Local> source, Set<Local> dest) {
		dest.clear();
		dest.addAll(source);
	}

	@Override
	protected Set<Local> entryInitialFlow() {
		return new HashSet<Local>();
	}
	
	@Override
	protected void merge(Set<Local> in1, Set<Local> in2, Set<Local> out) {
		out.clear();
		out.addAll(in1);
		out.retainAll(in2);
	}
	
	@Override
	protected Set<Local> newInitialFlow() {
		return new HashSet<Local>();
	}
	
}
