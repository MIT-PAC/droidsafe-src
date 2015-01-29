package dk.brics.string.java;

import java.util.ArrayList;
import java.util.List;

import soot.ArrayType;
import soot.Local;
import soot.RefType;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.ValueBox;
import soot.jimple.ArrayRef;
import soot.jimple.AssignStmt;
import soot.jimple.BreakpointStmt;
import soot.jimple.CastExpr;
import soot.jimple.DefinitionStmt;
import soot.jimple.EnterMonitorStmt;
import soot.jimple.EqExpr;
import soot.jimple.ExitMonitorStmt;
import soot.jimple.FieldRef;
import soot.jimple.GotoStmt;
import soot.jimple.IdentityStmt;
import soot.jimple.IfStmt;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.IntConstant;
import soot.jimple.InterfaceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.LookupSwitchStmt;
import soot.jimple.NeExpr;
import soot.jimple.NewArrayExpr;
import soot.jimple.NewExpr;
import soot.jimple.NewMultiArrayExpr;
import soot.jimple.NopStmt;
import soot.jimple.NullConstant;
import soot.jimple.ParameterRef;
import soot.jimple.RetStmt;
import soot.jimple.ReturnStmt;
import soot.jimple.ReturnVoidStmt;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.StaticFieldRef;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtSwitch;
import soot.jimple.StringConstant;
import soot.jimple.TableSwitchStmt;
import soot.jimple.ThrowStmt;
import soot.jimple.VirtualInvokeExpr;
import dk.brics.automaton.Automaton;
import dk.brics.string.intermediate.ArrayAddAll;
import dk.brics.string.intermediate.ArrayAssignment;
import dk.brics.string.intermediate.ArrayCorrupt;
import dk.brics.string.intermediate.ArrayFromArray;
import dk.brics.string.intermediate.ArrayNew;
import dk.brics.string.intermediate.ArrayWriteArray;
import dk.brics.string.intermediate.ArrayWriteElement;
import dk.brics.string.intermediate.Hotspot;
import dk.brics.string.intermediate.ObjectAssignment;
import dk.brics.string.intermediate.ObjectCorrupt;
import dk.brics.string.intermediate.PrimitiveAssignment;
import dk.brics.string.intermediate.PrimitiveFromArray;
import dk.brics.string.intermediate.PrimitiveInit;
import dk.brics.string.intermediate.Return;
import dk.brics.string.intermediate.Statement;
import dk.brics.string.intermediate.StringAssignment;
import dk.brics.string.intermediate.StringBufferAssignment;
import dk.brics.string.intermediate.StringBufferCorrupt;
import dk.brics.string.intermediate.StringBufferInit;
import dk.brics.string.intermediate.StringFromArray;
import dk.brics.string.intermediate.StringInit;
import dk.brics.string.intermediate.Variable;
import dk.brics.string.intermediate.VariableType;
import dk.brics.string.stringoperations.Basic;

/**
 * Translates Jimple-expressions and -statements into {@link Statement}s in intermediate form.
 * <p/>
 * This interface requires an implementation of the {@link IntermediateFactory} facade,
 * which is currently provided by the {@link StatementTranslatorFacadeImpl}.
 * <p/>
 * Note that this class is also responsible for creating {@link Hotspot} statements for each
 * <tt>ValueBox</tt> marked as a hotspot. {@link IntermediateFactory#isHotspot} defines what
 * is a hotspot.
 */
public class StatementTranslatorImpl extends ExprAnswerVisitor<ValueBox, Variable> implements StmtSwitch, StatementTranslator {
	
	private IntermediateFactory factory;
	private MethodCallTranslator methodCallTranslator;
	private FieldReferenceTranslator fieldReferenceTranslator;

	public StatementTranslatorImpl(MethodCallTranslator methodCalls, FieldReferenceTranslator fields) {
		this.methodCallTranslator = methodCalls;
		this.fieldReferenceTranslator = fields;
	}
	
	private Variable makeVariable(VariableType type) {
		return factory.createVariable(type);
	}
	private void addStatement(Statement stm) {
		factory.addStatement(stm);
	}
	
	private VariableType getType(Type type) {
		return factory.fromSootType(type);
	}
	
	private void assignNull(Variable to) {
		switch (to.getType()) {
		case STRING:
			addStatement(new StringInit(to, Automatons.getNull()));
			break;
			
		case STRINGBUFFER:
			// make a string buffer with the empty language of possible strings
			Variable temp = makeVariable(VariableType.STRING);
			addStatement(new StringBufferInit(to, temp));
			break;
			
		case ARRAY:
			// make an array with the empty language of possible strings, by not writing any strings to it
			addStatement(new ArrayNew(to));
			break;
			
		case PRIMITIVE:
		    assert false;
		    break;
			
		default:
			break; // XXX add ObjectNull-statement?? this ensures that the variable is not an alias of another variable anymore 
		}
	}
	
	private void assignValue(Variable to, Variable from) {
		// ignore uninteresting assignments 
		if ((to.getType() == VariableType.NONE || to.getType() == VariableType.NULL) && (from.getType() == VariableType.NONE || from.getType() == VariableType.NULL))
			return;
		
		if (from.getType() == VariableType.NULL) {
			assignNull(to);
			return;
		}
		
		if (to.getType() == VariableType.NONE) {
		    return;
		}
		
		// useful error checking
		if (to.getType().cannotBeAliasOf(from.getType()))
			throw new RuntimeException("Cannot assign from " + from.getType() + " to " + to.getType());
		
		switch (from.getType()) {
		case STRING:
			addStatement(new StringAssignment(to, from));
			break;
			
		case STRINGBUFFER:
			addStatement(new StringBufferAssignment(to, from));
			break;
			
		case ARRAY:
			addStatement(new ArrayAssignment(to, from));
			break;
			
		case PRIMITIVE:
		    addStatement(new PrimitiveAssignment(to, from));
		    break;
			
		default:
			addStatement(new ObjectAssignment(to, from));
		}
	}
	
	/**
	 * Corrupts the object pointed to by the specified variable, if that
	 * object is mutable.
	 */
	private void corruptIfMutable(Variable var) {
		if (var.getType() == VariableType.NONE || var.getType() == VariableType.NULL) // we don't care if this object is corrupted
			return;
		switch (var.getType()) {
		case STRING:
		case PRIMITIVE:
			break;
		case STRINGBUFFER:
			addStatement(new StringBufferCorrupt(var));
			break;
		case ARRAY:
			addStatement(new ArrayCorrupt(var));
			break;
		default:
			addStatement(new ObjectCorrupt(var));
		}
	}
	
	private Variable makeAnyStringVariable() {
		Variable v = makeVariable(VariableType.STRING);
		addStatement(new StringInit(v, Basic.makeAnyString()));
		return v;
	}
	private Variable makeConstantStringVariable(String value) {
		Variable v = makeVariable(VariableType.STRING);
		addStatement(new StringInit(v, Automaton.makeString(value)));
		return v;
	}
    private Variable makeConstantCharVariable(char value) {
        Variable v = makeVariable(VariableType.STRING);
        addStatement(new StringInit(v, Automaton.makeChar(value)));
        return v;
    }
    private Variable makeAutomatonVariable(Automaton automaton) {
        Variable v = makeVariable(VariableType.STRING);
        addStatement(new StringInit(v, automaton));
        return v;
    }
	
	/**
	 * Returns a variable that may contain any non-corrupt value of the specified type.
	 */
	private Variable getAnyValueOf(VariableType type) {
		if (type == VariableType.NONE)
			return getNothing();
		Variable v = makeVariable(type);
		assignAnyValue(v);
		return v;
	}
	
	/**
	 * Assigns an unknown value to the specified variable. 
	 */
	private void assignAnyValue(Variable v) {
		switch (v.getType()) {
		case STRING:
			addStatement(new StringInit(v, Basic.makeAnyString()));
			break;
		case STRINGBUFFER:
			addStatement(new StringBufferInit(v, makeAnyStringVariable()));
			break;
		case ARRAY:
			addStatement(new ArrayNew(v));
			addStatement(new ArrayWriteElement(v, makeAnyStringVariable()));
			break;
		case PRIMITIVE:
		    addStatement(new PrimitiveInit(v, Automaton.makeAnyChar()));
		    break;
		default:
			// no initialization necessary of uncertain objects
		}
	}
	
	/**
	 * Returns a variable of type <tt>NONE</tt>.
	 */
	private Variable getNothing() {
		return factory.getNothing();
	}
	
	/**
	 * Translates the expression contained in the specified value box, and returns
	 * a variable holding the result. This should always be used instead of <tt>applyTo</tt>
	 * directly, since this also takes care of creating hotspots.
	 * @param box the jimple expression to translate
	 * @return a variable holding the result
	 */
	private Variable translateExpression(ValueBox box) {
		Variable result = applyTo(box.getValue(), box);
		
		if (factory.isHotspot(box)) {
		    factory.addHotspot(result, box);
		}
		
		factory.setExpressionVariable(box, result);
		
		return result;
	}
	
	/* (non-Javadoc)
	 * @see dk.brics.string.java.StatementTranslator#translateStatement(soot.jimple.Stmt, dk.brics.string.java.IntermediateFactory)
	 */
	public void translateStatement(Stmt statement, IntermediateFactory factory) {
		this.factory = factory;
		statement.apply(this);
	}
	
	//
	//		VISITOR METHODS
	//
	
	@Override
	public Variable caseLocal(Local v, ValueBox box) {
		return factory.getLocal(v);
	}
	
	@Override
	public Variable caseArrayRef(ArrayRef v, ValueBox box) {
		// read something from an array
		Variable arrayObject = translateExpression(v.getBaseBox());
		VariableType innerType = getType(v.getType());
		
		if (innerType == VariableType.NONE)
			return getNothing();
		
		Variable result = makeVariable(innerType);
		switch (innerType) {
		case STRINGBUFFER:
			addStatement(new StringBufferCorrupt(result));
			break;
			
		case ARRAY:
			addStatement(new ArrayFromArray(result, arrayObject));
			break;
			
		case PRIMITIVE:
		    addStatement(new PrimitiveFromArray(result, arrayObject));
		    break;
			
		default:
			addStatement(new StringFromArray(result, arrayObject));
		}
		
		return result;
	}
	
	@Override
	public Variable caseCastExpr(CastExpr v, ValueBox box) {
		Variable operand = translateExpression(v.getOpBox());
		VariableType castTo = getType(v.getCastType());
		
		// whatever comes out of the cast must satisfy both the operand's type and the casted type
		VariableType resultType = operand.getType().greatestLowerBound(castTo);
		if (resultType == VariableType.NONE) {
			return getNothing();
		}
		
		// upgrade the result to the casted type
		// other parts of the translation can use the additional information
		Variable result;
		if (resultType == operand.getType()) {
			result = operand;
		} else {
			result = factory.createVariable(resultType);
			assignValue(result, operand);
		}
		
		return result;
	}
	
	@Override
	public Variable caseInterfaceInvokeExpr(InterfaceInvokeExpr v, ValueBox box) {
		return invokeExpr(v, box);
	}
	
	@Override
	public Variable caseVirtualInvokeExpr(VirtualInvokeExpr v, ValueBox box) {
		return invokeExpr(v, box);
	}
	
	@Override
	public Variable caseSpecialInvokeExpr(SpecialInvokeExpr v, ValueBox box) {
		Variable callee = translateExpression(v.getBaseBox());

		// evaluate all arguments
		List<Variable> arguments = new ArrayList<Variable>();
		for (int i=0; i<v.getArgCount(); i++) {
			arguments.add(translateExpression(v.getArgBox(i)));
		}
		
		// if the called class could not be found (ie a phantom class), treat it as a corrupt call
		if (v.getMethodRef().declaringClass().isPhantom()) {
		    return handlePhantomInvocation(v, arguments);
		}
		
        SootMethod method = v.getMethod();
		
		// Is this a constructor call?
		if (method.getName().equals("<init>")) {
			return handleConstructor(v, callee, arguments);
		}
		
		// try to handle it as an abstract method call. even though we know the exact target,
		// this is the correct thing to do according to the MethodCallTranslator interface.
		Variable result = methodCallTranslator.translateAbstractMethodCall(v, method, callee, arguments, factory);
		if (result != null)
			return result;
		
		// Otherwise just handle it as a normal call with only one possible target
		result = makeVariable(getType(v.getMethod().getReturnType()));
		handleInvocationTarget(result, v, method, callee, arguments);
		
        // if the called method was annotated, use the static type instead
        Automaton staticType = factory.getMethodReturnType(v.getMethod());
        if (staticType != null)
            return makeAutomatonVariable(staticType);
        else
            return result;
	}
	
	private Variable handleConstructor(SpecialInvokeExpr expr, Variable callee, List<Variable> arguments) {
		if (methodCallTranslator.translateConstructorCall(expr, callee, arguments, factory)) {
			return getNothing();
		}
		// Do some worst-case handling otherwise
		// corrupt callee and all arguments
		corruptIfMutable(callee);
		for (Variable arg : arguments) {
			corruptIfMutable(arg);
		}
		return getNothing();
	}
	
	private Variable invokeExpr(InstanceInvokeExpr v, ValueBox box) {
        // evaluate all arguments
        List<Variable> arguments = new ArrayList<Variable>();
        for (int i=0; i<v.getArgCount(); i++) {
            arguments.add(translateExpression(v.getArgBox(i)));
        }
        
        // if we are calling a phantom method, just corrupt everything involved
	    if (v.getMethodRef().declaringClass().isPhantom()) {
	        return handlePhantomInvocation(v, arguments);
	    }
		
	    SootMethod method = v.getMethod();
		Variable callee = translateExpression(v.getBaseBox());
		
		// Special case: clone() on an array or collection
		if (method.getName().equals("clone") && method.getParameterCount() == 0 && callee.getType() == VariableType.ARRAY) {
			return handleArrayClone(callee);
		}
		
		// try to translate the abstract call
		Variable r2 = methodCallTranslator.translateAbstractMethodCall(v, v.getMethod(), callee, arguments, factory);
		if (r2 != null)
			return r2;
		
		// find the possible implementations that get called
		List<SootMethod> targets = factory.getTargetsOf(v);
		
		if (targets.size() == 0) {
		    // try to translate the abstract method call. A resolver could know something useful.
		    Variable result = methodCallTranslator.translateMethodCall(v, method, callee, arguments, factory);
		    
		    if (result != null)
		        return result;
		}
        
        // create a variable with the result
        VariableType returnType = getType(method.getReturnType());
        Variable result = makeVariable(returnType);
        
        // split the control-flow graph for each possible target
		factory.startBranch();
		
		// if no targets can be seen, we will assume it is a corrupting call (externally implemented)
		// TODO: Externally extended/implemented classes should be made more explicit with a strategy interface
		// TODO: Resolvers never get a chance to resolve this type of method call.
		//       For example, HttpServletRequest.getRequestURI() because its implementation is dynamically loaded.
		if (targets.size() == 0) {
			handleCorruptInvocation(result, callee.getType(), callee, arguments);
			factory.useBranch();
		}
		
		for (SootMethod target : targets) {
			handleInvocationTarget(result, v, target, callee, arguments);
			factory.useBranch();
		}
		
		factory.endBranch();
		
		// if the called method was annotated, use the static type instead
        Automaton staticType = factory.getMethodReturnType(v.getMethod());
		if (staticType != null)
		    return makeAutomatonVariable(staticType);
		else
		    return result;
	}
	
	/**
	 * Creates statements for an invocation to a known method implementation.
	 * @param result where to store the result (has type <tt>NONE</tt> if method returns <tt>void</tt>).
	 * @param v the invocation expression
	 * @param target method implementation being called; may differ from <tt>v.getMethod()</tt>.
	 * @param callee variable holding the object being called on
	 * @param arguments variables holding the method call's arguments
	 */
	private void handleInvocationTarget(Variable result, InstanceInvokeExpr v, SootMethod target, Variable callee, List<Variable> arguments) {
		Variable goodResult = methodCallTranslator.translateMethodCall(v, target, callee, arguments, factory);
		if (goodResult != null) {
			assignValue(result, goodResult);
		} else {
			// if the method declaring the method might be an interesting mutable type,
			// corrupt the callee
			VariableType declaringClass = factory.fromSootType(target.getDeclaringClass().getType());
			handleCorruptInvocation(result, declaringClass, callee, arguments);
		}
	}
	
	/**
	 * Creates statements corresponding to an invocation to an unknown method, thus corrupting every variable involved.
	 * @param result where to store the (corrupt) result
	 * @param declaringClass the type of the class declaring the method (on a best-known basis)
	 * @param callee variable holding the object being called on
	 * @param arguments variables holding the method call's arguments
	 */
	private void handleCorruptInvocation(Variable result, VariableType declaringClass, Variable callee, List<Variable> arguments) {
		if (declaringClass.mightBeUsefulMutable()) {
			corruptIfMutable(callee);
		}
		
		// corrupt all arguments
		for (Variable arg : arguments) {
			corruptIfMutable(arg);
		}
		
		// give the result any corrupt value
		assignAnyValue(result);
		corruptIfMutable(result);
	}
	
	private Variable handlePhantomInvocation(InvokeExpr exp, List<Variable> arguments) {
	    Variable result = makeVariable(getType(exp.getType()));
	    for (Variable arg : arguments) {
	        corruptIfMutable(arg);
	    }
        assignAnyValue(result);
        corruptIfMutable(result);
	    return result;
	}
	
	/**
	 * Creates statements that simulate <tt>String[].clone()</tt>.
	 * <p/>
	 * Cannot currently be handled by method call translators, because it is 
	 * really <tt>Object.clone()</tt> being called, followed by a typecast (which is invisible in Java).
	 */
	private Variable handleArrayClone(Variable callee) {
		Variable result = factory.createVariable(VariableType.ARRAY);
		factory.addStatement(new ArrayAddAll(result, callee));
		return result;
	}
	
	@Override
	public Variable caseNewExpr(NewExpr v, ValueBox box) {
		return makeVariable(getType(v.getBaseType()));
	}
	
	@Override
	public Variable caseNewArrayExpr(NewArrayExpr v, ValueBox box) {
		return handleArrayNew(v.getBaseType());
	}
	
	@Override
	public Variable caseNewMultiArrayExpr(NewMultiArrayExpr v, ValueBox box) {
		return handleArrayNew(v.getBaseType());
	}
    
    private Variable handleArrayNew(Type type) {
        if (getType(type) == VariableType.NONE)  // arrays of uninteresting types may be ignored
            return getNothing();
        
        // dig out the element type
        Type elementType = type;
        while (elementType instanceof ArrayType) {
            elementType = ((ArrayType)elementType).getElementType();
        }
        
        Variable var = makeVariable(VariableType.ARRAY);
        if (elementType instanceof RefType) {
            // object arrays are filled with null initially
            addStatement(new ArrayWriteElement(var, makeConstantStringVariable("null"))); 
        } else {
            // primitive arrays are filled zeros initially
            addStatement(new ArrayWriteElement(var, makeConstantCharVariable('\0')));
        }
        return var;
    }
	
	@Override
	public Variable caseNullConstant(NullConstant v, ValueBox box) {
		return makeVariable(VariableType.NULL);
	}
	
	@Override
	public Variable caseParameterRef(ParameterRef v, ValueBox box) {
	    Automaton staticType = factory.getParameterType(v);
	    if (staticType != null) {
	        return makeAutomatonVariable(staticType);
	    }
		return factory.getParameter(v);
	}
	
	@Override
	public Variable caseStaticInvokeExpr(StaticInvokeExpr v, ValueBox box) {
	    Variable result = null;
	    
	    // find the static string return type, if it has one
	    Automaton staticReturn = factory.getMethodReturnType(v.getMethod());
	    if (staticReturn != null) {
	        result = makeAutomatonVariable(staticReturn);
	    }
	    
		// evaluate all arguments
		List<Variable> arguments = new ArrayList<Variable>();
		for (int i=0; i<v.getArgCount(); i++) {
			arguments.add(translateExpression(v.getArgBox(i)));
		}
        
		// translate the method call (if possible)
		Variable goodResult = methodCallTranslator.translateStaticMethodCall(v, arguments, factory);
		if (result == null) {
		    result = goodResult;
		}
		if (goodResult != null) {
			return result;
		}
		
		// Do some worst-case handling otherwise
		// corrupt all arguments
		for (Variable arg : arguments) {
			corruptIfMutable(arg);
		}
		
		// create a return-value that can have any value and is corrupt
		if (result == null) {
		    result = getAnyValueOf(VariableType.OBJECT);
	        corruptIfMutable(result);
		}
		
		return result;
	}
	
	@Override
	public Variable caseStringConstant(StringConstant v, ValueBox box) {
		return makeConstantStringVariable(v.value);
	}
	
	@Override
	public Variable caseIntConstant(IntConstant v, ValueBox question) {
	    Variable result = makeVariable(VariableType.PRIMITIVE);
	    if (v.value >= Character.MIN_VALUE && v.value <= Character.MAX_VALUE) {
	        addStatement(new PrimitiveInit(result, Automaton.makeChar((char)v.value)));
	    } else {
	        addStatement(new PrimitiveInit(result, Automaton.makeAnyChar()));
	    }
	    return result;
	}
	
	@Override
	public Variable caseInstanceFieldRef(InstanceFieldRef v, ValueBox box) {
		return handleFieldRef(v, box);
	}
	
	@Override
	public Variable caseStaticFieldRef(StaticFieldRef v, ValueBox box) {
	    return handleFieldRef(v, box);
	}
	
	private Variable handleFieldRef(FieldRef v, ValueBox box) {
	    VariableType type = factory.fromSootType(v.getType());
        if (type == VariableType.NONE)
            return getNothing();
        
        // if the field is @Type annotated, create a variable with its static type 
        if (factory.fromSootType(v.getType()) == VariableType.STRING) {
            Automaton staticType = factory.getFieldType(v.getField());
            if (staticType != null) {
                return makeAutomatonVariable(staticType);
            }
        }
        
        Variable result = fieldReferenceTranslator.translateFieldRef(v, box, factory);
        if (result != null) {
            return result;
        }
        
        result = getAnyValueOf(type);
        corruptIfMutable(result);
        return result;
	}
	
	@Override
	public Variable caseEqExpr(EqExpr v, ValueBox question) {
	    translateExpression(v.getOp1Box());
	    translateExpression(v.getOp2Box());
	    return getAnyValueOf(VariableType.PRIMITIVE);
	}
	@Override
	public Variable caseNeExpr(NeExpr v, ValueBox question) {
	    translateExpression(v.getOp1Box());
	    translateExpression(v.getOp2Box());
	    return getAnyValueOf(VariableType.PRIMITIVE);
	}
	
	@Override
	public Variable defaultExpr(Object v, ValueBox box) {
		return getNothing();
	}
	
	
	//
	//	STATEMENTS 
	//

	public void caseAssignStmt(AssignStmt stmt) {
		assignment(stmt);
	}
	public void caseIdentityStmt(IdentityStmt stmt) {
		assignment(stmt);
	}
	public void assignment(DefinitionStmt stmt) {
		Variable result = translateExpression(stmt.getRightOpBox());
		
		if (result.getType() == VariableType.NONE) {
			return; // no need to track this object
		}
		
		// assign to a local variable?
		if (stmt.getLeftOp() instanceof Local) {
			Variable lefthandSide = factory.getLocal((Local)stmt.getLeftOp());
			assignValue(lefthandSide, result);
		
		// assign to a field?
		} else if (stmt.getLeftOp() instanceof FieldRef) {
			FieldRef ref = (FieldRef)stmt.getLeftOp();
			
			// delegate the translation
			fieldReferenceTranslator.translateFieldAssignment(ref, result, factory);
		
		// assign into an array slot?
		} else if (stmt.getLeftOp() instanceof ArrayRef) {
			ArrayRef left = (ArrayRef)stmt.getLeftOp();
			Value array = left.getBase();
			if (array instanceof Local) {
				Local arrayLocal = (Local)array;
				Variable arrayVariable = factory.getLocal(arrayLocal);
				
				switch (result.getType()) {
				case STRING:
				case PRIMITIVE:
					addStatement(new ArrayWriteElement(arrayVariable, result));
					break;
					
				case ARRAY:
					addStatement(new ArrayWriteArray(arrayVariable, result));
					break;
					
				default:
					corruptIfMutable(result);
					corruptIfMutable(arrayVariable);
					break;
				}
			} else {
				// we are probably storing a string into a field of type array
				// just ignore it; we don't track mutable arrays anyway
				corruptIfMutable(result);
			}
		
		// assign to what!?
		} else {
			throw new RuntimeException("Unknown left-hand side " + stmt.getClass().getCanonicalName());
		}
	}
	
	public void caseInvokeStmt(InvokeStmt stmt) {
		translateExpression(stmt.getInvokeExprBox());
	}
	public void caseReturnStmt(ReturnStmt stmt) {
		Variable returnValue = translateExpression(stmt.getOpBox());
		addStatement(new Return(returnValue));
	}
	public void caseReturnVoidStmt(ReturnVoidStmt stmt) {
		addStatement(new Return(getNothing()));
	}
	
	public void defaultCase(Object obj) {
	}
	
	/* ASSERTION-RELAVANT STATEMENTS */
	public void caseIfStmt(IfStmt stmt) {
	    // translate this so assertions can use the expressions we evaluate
	    translateExpression(stmt.getConditionBox());
    }
	public void caseLookupSwitchStmt(LookupSwitchStmt stmt) {
		translateExpression(stmt.getKeyBox());
	}
    
	/* IGNORED STATEMENTS */
	public void caseBreakpointStmt(BreakpointStmt stmt) {
	}
	public void caseEnterMonitorStmt(EnterMonitorStmt stmt) {
	}
	public void caseExitMonitorStmt(ExitMonitorStmt stmt) {
	}
	public void caseGotoStmt(GotoStmt stmt) {
	}
	public void caseNopStmt(NopStmt stmt) {
	}
	public void caseRetStmt(RetStmt stmt) {
	}
	public void caseTableSwitchStmt(TableSwitchStmt stmt) {
	}
	public void caseThrowStmt(ThrowStmt stmt) {
	}
}
