package dk.brics.string.java;

import java.util.LinkedList;
import java.util.List;

import soot.Local;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.ValueBox;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.ParameterRef;
import soot.jimple.Stmt;
import soot.jimple.toolkits.annotation.nullcheck.NullnessAnalysis;
import dk.brics.automaton.Automaton;
import dk.brics.string.intermediate.Field;
import dk.brics.string.intermediate.Hotspot;
import dk.brics.string.intermediate.Method;
import dk.brics.string.intermediate.Statement;
import dk.brics.string.intermediate.Variable;
import dk.brics.string.intermediate.VariableType;
import dk.brics.string.util.Pair;

/**
 * Acts as the middle-man between {@link MethodTranslator} and {@link StatementTranslatorImpl}.
 * <p/>
 * {@link StatementTranslatorImpl} requires a large facade implementation to use ({@link IntermediateFactory}),
 * and the method translator wants a simple-to-use statement translator.
 * This class satisfies both by acting as a facade pattern in both directions.
 */
public class StatementTranslatorFacadeImpl implements IntermediateFactory, StatementTranslatorFacade {
	
	private StatementTranslator methodBodyTranslator;
	private SootMethod sootMethod;
	
	private List<HotspotValueBoxPair> currentHotspots = new LinkedList<HotspotValueBoxPair>();
	
	/** Holds all the statements added in the current translation */
	private List<Statement> currentStatements = new LinkedList<Statement>();
	
	private VariableManager variableManager;
	private TranslationContext jt;
	private Stmt sootStatement;
	
	private NullnessAnalysis nullAnalysis;
	private ControlFlowBuilder cfgBuilder;
	private Method intermediateMethod;
	
	public StatementTranslatorFacadeImpl(StatementTranslator translator) {
		this.methodBodyTranslator = translator;
	}
    
	public TranslatedStatement translateStatement(Stmt stmt, SootMethod sootMethod,
			NullnessAnalysis nullAnalysis, TranslationContext jt) {
		this.jt = jt;
		this.sootStatement = stmt;
		this.sootMethod = sootMethod;
        this.intermediateMethod = jt.getMethod(sootMethod);
		this.nullAnalysis = nullAnalysis;
		this.variableManager = jt.getVariableManager();
		this.cfgBuilder = new ControlFlowBuilder(intermediateMethod);
		currentHotspots.clear();
		currentStatements.clear();
		
		methodBodyTranslator.translateStatement(stmt, this);
		
		Pair<Statement, Statement> pair = cfgBuilder.finish();
		
		// prepare the result
		TranslatedStatement translated = new TranslatedStatement(pair.getFirst(), pair.getSecond());
		
		// add the hotspots we found
		translated.getHotspots().addAll(currentHotspots);
		
		// add all the statements in a list
		translated.getStatements().addAll(currentStatements);
		
		return translated;
	}

    public void addHotspot(Variable var, ValueBox box) {
        Variable hotspotValue = createVariable(var.getType());
        Hotspot hot = new Hotspot(hotspotValue, var);
        currentHotspots.add(new HotspotValueBoxPair(hot, box));
        addStatement(hot);
    }
    
	public void startBranch() {
		cfgBuilder.startBranch();
	}
	public void useBranch() {
    	cfgBuilder.useBranch();
	}
	public void endBranch() {
    	cfgBuilder.endBranch();
	}
	public void addStatement(Statement s) {
        cfgBuilder.addStatement(s);
        currentStatements.add(s);
	}
	public Variable getLocal(Local local) {
		return variableManager.getLocal(local);
	}
	public Variable createVariable(VariableType type) {
		return variableManager.createVariable(type);
	}
	public Variable getNothing() {
		return variableManager.getNothing();
	}
	public Field getField(SootField field) {
		return variableManager.getField(field);
	}
	
	public Method getMethod(SootMethod method) {
		return jt.getMethod(method);
	}
	public Variable getParameter(ParameterRef ref) {
		return jt.getParameter(sootMethod, ref);
	}
	public List<SootMethod> getTargetsOf(InstanceInvokeExpr expr) {
		return jt.getTargetsOf(expr);
	}
	public Method getToStringMethod(SootClass c) {
		return jt.getToStringMethod(c);
	}
	public boolean isHotspot(ValueBox expr) {
		return jt.isHotspot(expr);
	}
	public boolean canBeNull(Local local) {
		return !nullAnalysis.isAlwaysNonNullBefore(sootStatement, local);
	}
	public void setExpressionVariable(ValueBox value, Variable variable) {
	    jt.setExpressionVariable(value.getValue(), variable);
	}
    public Automaton getFieldType(SootField field) {
        return jt.getFieldType(field);
    }
    public Automaton getMethodReturnType(SootMethod method) {
        return jt.getMethodReturnType(method);
    }
    public Automaton getParameterType(ParameterRef ref) {
        return jt.getParameterType(sootMethod, ref.getIndex());
    }
    public boolean isSubtypeOf(SootClass a, SootClass b) {
    	return jt.isSubtypeOf(a,b);
    }
    public VariableType fromSootType(Type type) {
    	return jt.fromSootType(type);
    }
	
	
}
