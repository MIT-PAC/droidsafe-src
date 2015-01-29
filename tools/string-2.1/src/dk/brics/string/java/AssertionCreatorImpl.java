package dk.brics.string.java;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import soot.BooleanType;
import soot.IntType;
import soot.Local;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.AbstractJimpleValueSwitch;
import soot.jimple.AndExpr;
import soot.jimple.BinopExpr;
import soot.jimple.ConditionExpr;
import soot.jimple.DefinitionStmt;
import soot.jimple.EqExpr;
import soot.jimple.GeExpr;
import soot.jimple.GtExpr;
import soot.jimple.IfStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.LeExpr;
import soot.jimple.LtExpr;
import soot.jimple.NeExpr;
import soot.jimple.OrExpr;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.VirtualInvokeExpr;
import soot.toolkits.scalar.LocalDefs;
import dk.brics.automaton.Automaton;
import dk.brics.string.intermediate.AssertAliases;
import dk.brics.string.intermediate.AssertBinaryOp;
import dk.brics.string.intermediate.AssertUnaryOp;
import dk.brics.string.intermediate.Method;
import dk.brics.string.intermediate.Statement;
import dk.brics.string.intermediate.Variable;
import dk.brics.string.intermediate.VariableType;
import dk.brics.string.stringoperations.AssertContainedInOther;
import dk.brics.string.stringoperations.AssertContainsOther;
import dk.brics.string.stringoperations.AssertEmpty;
import dk.brics.string.stringoperations.AssertEndsWith;
import dk.brics.string.stringoperations.AssertEquals;
import dk.brics.string.stringoperations.AssertHasLength;
import dk.brics.string.stringoperations.AssertHasNotLength;
import dk.brics.string.stringoperations.AssertInLanguage;
import dk.brics.string.stringoperations.AssertNotEmpty;
import dk.brics.string.stringoperations.AssertNotEquals;
import dk.brics.string.stringoperations.AssertPrefixOf;
import dk.brics.string.stringoperations.AssertStartsWith;
import dk.brics.string.stringoperations.AssertSuffixOf;
import dk.brics.string.stringoperations.Basic;
import dk.brics.string.stringoperations.BinaryOperation;
import dk.brics.string.stringoperations.UnaryOperation;
import dk.brics.string.util.Pair;

public class AssertionCreatorImpl implements AssertionCreator {
    
    private ControlFlowBuilder builder;
    private LocalDefs definitions;
    private TranslationContext context;
    private Method method;
    private SootMethod sootMethod;
    private Set<Value> active = new HashSet<Value>();
    private Map<Stmt, TranslatedStatement> statements;
    
    private void prepare(AssertionContext assertionContext) {
        this.statements = assertionContext.getStatementTranslations();
        this.definitions = assertionContext.getLocalDefinitions();
        this.context = assertionContext.getTranslationContext();
        this.sootMethod = assertionContext.getMethod();
        this.method = context.getMethod(sootMethod);
        this.active.clear();	
    }

    public AssertionBranches createAssertions(IfStmt branch, AssertionContext assertionContext) {
    	prepare(assertionContext);
        ConditionExpr expr = (ConditionExpr)branch.getCondition();
        
        // do the positive branch
        builder = new ControlFlowBuilder(method);
        assertBoolean(expr, branch, true);
        Pair<Statement,Statement> pair = builder.finish();
        AssertionBranch whenTrue = new AssertionBranch(pair.getFirst(), pair.getSecond());
        
        // do the negative branch
        builder = new ControlFlowBuilder(method);
        assertBoolean(expr, branch, false);
        pair = builder.finish();
        AssertionBranch whenFalse = new AssertionBranch(pair.getFirst(), pair.getSecond());
        
        return new AssertionBranches(whenFalse, whenTrue);
    }
    
    public AssertionBranch createSwitchAssertions(ValueBox variable, int value, Unit switchStart, AssertionContext assertionContext) {
    	prepare(assertionContext);
    	
    	builder = new ControlFlowBuilder(method);
    	assertInteger(variable.getValue(), switchStart, Relation.EQUAL, value);
    	Pair<Statement,Statement> pair = builder.finish();
    	
    	return new AssertionBranch(pair.getFirst(), pair.getSecond());
    }
    
    public AssertionBranch createSwitchDefaultAssertions(ValueBox variable, List<Integer> skippedValues, Unit switchStart, AssertionContext assertionContext) {
    	prepare(assertionContext);
    	
    	builder = new ControlFlowBuilder(method);
    	for (int value : skippedValues) {
    		assertInteger(variable.getValue(), switchStart, Relation.NOT_EQUAL, value);
    	}
    	Pair<Statement,Statement> pair = builder.finish();
    	
    	return new AssertionBranch(pair.getFirst(), pair.getSecond());
    }
    
    /** Asserts that the specified expression evaluates to the given boolean value */
    private void assertBoolean(Value value, Unit unit, boolean b) {
        assertWithVisitor(value, new BooleanVisitor(b, unit));
    }
    /** Asserts that the specified expression evaluates to an integer with the specified relation to the given integer */
    private void assertInteger(Value value, Unit unit, Relation rel, int i) {
        assertWithVisitor(value, new IntegerVisitor(unit, i, rel));
    }
    private void assertWithVisitor(Value value, AssertionVisitor visitor) {
        if (active.contains(value))
            return;
        active.add(value);
        value.apply(visitor);
        active.remove(value); 
    }
    
    private boolean isBoolean(Type type) {
        return type instanceof BooleanType;
    }
    
//    private boolean isString(Type type) {
//        return type.equals(RefType.v("java.lang.String"));
//    }
    
    /** Returns true if the type is <tt>int</tt>, (not long, short, byte, etc) */
    private boolean isInteger(Type type) {
        return type instanceof IntType;
    }
    
    private class AssertionVisitor extends AbstractJimpleValueSwitch {
        Unit unit;

        public AssertionVisitor(Unit unit) {
            this.unit = unit;
        }

        void makeBinaryAssertion(Variable first, Variable second, BinaryOperation op) {
            if (first == null || second == null)
                return;
            builder.addStatement(new AssertBinaryOp(statements.get(unit).getLast(), first, second, op));
        }
        void makeAliasAssertion(Variable first, Variable second, boolean aliases) {
            if (first == null || second == null)
                return;
            builder.addStatement(new AssertAliases(statements.get(unit).getLast(), first, second, aliases));
        }
        void makeUnaryAssertion(Variable var, UnaryOperation op) {
            if (var == null)
                return;
            builder.addStatement(new AssertUnaryOp(statements.get(unit).getLast(), var, op));
        }
        Variable getBase(InstanceInvokeExpr expr) {
            return context.getExpressionVariable(expr.getBase());
        }
        Variable getArgument(InvokeExpr expr, int index) {
            return context.getExpressionVariable(expr.getArg(index));
        }
    }
    
    private class BooleanVisitor extends AssertionVisitor {
        private boolean expected;
        
        public BooleanVisitor(boolean expected, Unit unit) {
            super(unit);
            this.expected = expected;
        }


        @Override
        public void caseLocal(Local v) {
            builder.startBranch();
            boolean found = false;
            for (Unit definition : definitions.getDefsOfAt(v, unit)) {
                if (definition instanceof DefinitionStmt) {
                    found = true;
                    assertBoolean(((DefinitionStmt)definition).getRightOp(), definition, expected);
                    builder.useBranch();
                }
            }
            if (!found) {
                builder.useBranch();
            }
            builder.endBranch();
        }
        
        @Override
        public void caseAndExpr(AndExpr v) {
            if (expected == true) {
                assertBoolean(v.getOp1(), unit, true);
                assertBoolean(v.getOp2(), unit, true);
            } else {
                builder.startBranch();
                assertBoolean(v.getOp1(), unit, false);
                builder.useBranch();
                assertBoolean(v.getOp2(), unit, false);
                builder.useBranch();
                builder.endBranch();
            }
        }
        @Override
        public void caseOrExpr(OrExpr v) {
            if (expected == true) {
                builder.startBranch();
                assertBoolean(v.getOp1(), unit, true);
                builder.useBranch();
                assertBoolean(v.getOp2(), unit, true);
                builder.useBranch();
                builder.endBranch();
            } else {
                assertBoolean(v.getOp1(), unit, false);
                assertBoolean(v.getOp2(), unit, false);
            }
        }
        @Override
        public void caseLeExpr(LeExpr v) {
            assertComparison(v, Relation.LESS_EQ);
        }
        @Override
        public void caseLtExpr(LtExpr v) {
            assertComparison(v, Relation.LESS);
        }
        @Override
        public void caseGeExpr(GeExpr v) {
            assertComparison(v, Relation.GREATER_EQ);
        }
        @Override
        public void caseGtExpr(GtExpr v) {
            assertComparison(v, Relation.GREATER);
        }
        @Override
        public void caseNeExpr(NeExpr v) {
            assertComparison(v, Relation.NOT_EQUAL);
        }
        @Override
        public void caseEqExpr(EqExpr v) {
            assertComparison(v, Relation.EQUAL);
        }
        /** Returns true if the relation is == or != */
        private boolean isAbsolute(Relation r) {
            return r == Relation.EQUAL || r == Relation.NOT_EQUAL;
        }
        private void assertComparison(BinopExpr v, Relation relation) {
            relation = negateUnless(relation, expected);
            // bool == const
            if (isAbsolute(relation) && isBoolean(v.getOp1().getType()) && v.getOp2() instanceof IntConstant) {
                int i2 = ((IntConstant)v.getOp2()).value;
                assertBoolean(v.getOp1(), unit, (i2 == 1) == (relation == Relation.EQUAL));
            }
            // eg. f(x) <= const or f(x) == const
            else if (isInteger(v.getOp1().getType()) && v.getOp2() instanceof IntConstant) {
                int i2 = ((IntConstant)v.getOp2()).value;
                assertInteger(v.getOp1(), unit, relation, i2);
            }
            // eg. const <= f(x) or const == f(x)
            else if (v.getOp1() instanceof IntConstant && isInteger(v.getOp2().getType())) {
                int i1 = ((IntConstant)v.getOp1()).value;
                assertInteger(v.getOp2(), unit, commute(relation), i1);
            }
            
            // string == string
            // char == char
            // etc.
            if (isAbsolute(relation)) {
                boolean equals = relation == Relation.EQUAL;
                VariableType lefttype = context.fromSootType(v.getOp1().getType());
                VariableType righttype = context.fromSootType(v.getOp2().getType());
                if (lefttype.leastUpperBound(VariableType.NONE) != VariableType.NONE 
                    && righttype.leastUpperBound(VariableType.NONE) != VariableType.NONE) {
                    Variable left = context.getExpressionVariable(v.getOp1());
                    Variable right = context.getExpressionVariable(v.getOp2());
                    if (equals == true) {
                        makeBinaryAssertion(left, right, new AssertEquals());
                        makeBinaryAssertion(right, left, new AssertEquals());
                        // assert aliases as well
                        if (lefttype.mightBeUsefulMutable() && righttype.mightBeUsefulMutable()) {
                        	makeAliasAssertion(left, right, true);
                        }
                    }
                    else if (equals == false && lefttype == VariableType.PRIMITIVE && righttype == VariableType.PRIMITIVE) {
                        // only primitive types may get a negative assertion here, since references
                        // may refer to different objects with same contents
                        makeBinaryAssertion(left, right, new AssertNotEquals());
                        makeBinaryAssertion(right, left, new AssertNotEquals());
                    }
                    else if (equals == false && lefttype.mightBeUsefulMutable() && righttype.mightBeUsefulMutable()) {
                    	// assert that the variables are not aliases
                    	// their contents cannot be asserted here, though
                    	makeAliasAssertion(left, right, false);
                    }
                }
            }
        }
        @Override
        public void caseVirtualInvokeExpr(VirtualInvokeExpr v) {
            instanceInvokeExpr(v);
        }
        @Override
        public void caseSpecialInvokeExpr(SpecialInvokeExpr v) {
            instanceInvokeExpr(v);
        }
        private void instanceInvokeExpr(InstanceInvokeExpr v) {
            SootMethodRef m = v.getMethodRef();
            if (m.getSignature().equals("<java.lang.String: boolean contains(java.lang.CharSequence)>")) {
                if (expected == true) {
                    Variable base = getBase(v);
                    Variable arg = getArgument(v, 0);
                    makeBinaryAssertion(base, arg, new AssertContainsOther());
                    makeBinaryAssertion(arg, base, new AssertContainedInOther());
                }
            }
            else if (m.getSignature().equals("<java.lang.String: boolean equals(java.lang.Object)>")) {
                Variable base = getBase(v);
                Variable arg = getArgument(v, 0);
                if (expected == true) {
                    makeBinaryAssertion(base, arg, new AssertEquals());
                    makeBinaryAssertion(arg, base, new AssertEquals());
                } else {
                    makeBinaryAssertion(base, arg, new AssertNotEquals());
                    makeBinaryAssertion(arg, base, new AssertNotEquals());
                }
            }
            else if (m.getSignature().equals("<java.lang.String: boolean startsWith(java.lang.String)>")) {
                if (expected == true) {
                    Variable base = getBase(v);
                    Variable arg = getArgument(v, 0);
                    makeBinaryAssertion(base, arg, new AssertStartsWith());
                    makeBinaryAssertion(arg, base, new AssertPrefixOf());
                } else {
                    // TODO negated startsWith assertions [note: it is sound to ignore this]
                }
            }
            else if (m.getSignature().equals("<java.lang.String: boolean endsWith(java.lang.String)>")) {
                if (expected == true) {
                    Variable base = getBase(v);
                    Variable arg = getArgument(v, 0);
                    makeBinaryAssertion(base, arg, new AssertEndsWith());
                    makeBinaryAssertion(arg, base, new AssertSuffixOf());
                } else {
                    // TODO negated endsWith assertions [note: it is sound to ignore this]
                }
            }
            else if (m.getSignature().equals("<java.lang.String: boolean isEmpty()>")) {
                Variable base = getBase(v);
                if (expected == true) {
                    makeUnaryAssertion(base, new AssertEmpty());
                } else {
                    makeUnaryAssertion(base, new AssertNotEmpty());
                }
            }
            else if (m.getSignature().equals("<java.lang.String: boolean contentEquals(java.lang.StringBuffer)>") 
                    || m.getSignature().equals("<java.lang.String: boolean contentEquals(java.lang.CharSequence)>")) {
                Variable base = getBase(v);
                Variable arg = getArgument(v, 0);
                if (expected == true) {
                    makeBinaryAssertion(base, arg, new AssertEquals());
                    makeBinaryAssertion(arg, base, new AssertEquals());
                } else {
                    makeBinaryAssertion(base, arg, new AssertNotEquals());
                    makeBinaryAssertion(arg, base, new AssertNotEquals());
                }
            }
        }
        
        @Override
        public void caseStaticInvokeExpr(StaticInvokeExpr v) {
            SootMethodRef m = v.getMethodRef();
            if (m.getSignature().equals("<java.lang.Character: boolean isDigit(char)>")) {
            	Variable base = getArgument(v, 0);
            	if (expected == true) {
            		makeUnaryAssertion(base, new AssertInLanguage(Basic.getUnicodeDigits()));
            	} else {
            		makeUnaryAssertion(base, new AssertInLanguage(Basic.getUnicodeDigits().complement()));
            	}
            }
            else if (m.getSignature().equals("<java.lang.Character: boolean isLetter(char)>")) {
            	Variable base = getArgument(v, 0);
            	if (expected == true) {
            		makeUnaryAssertion(base, new AssertInLanguage(Basic.getUnicodeLetters()));
            	} else {
            		makeUnaryAssertion(base, new AssertInLanguage(Basic.getUnicodeLetters().complement()));
            	}
            }
            else if (m.getSignature().equals("<java.lang.Character: boolean isLetterOrDigit(char)>")) {
            	Variable base = getArgument(v, 0);
            	if (expected == true) {
            		makeUnaryAssertion(base, new AssertInLanguage(Basic.getUnicodeLettersAndDigits()));
            	} else {
            		makeUnaryAssertion(base, new AssertInLanguage(Basic.getUnicodeLettersAndDigits().complement()));
            	}
            }
            else if (m.getSignature().equals("<java.lang.Character: boolean isLowerCase(char)>")) {
            	Variable base = getArgument(v, 0);
            	if (expected == true) {
            		makeUnaryAssertion(base, new AssertInLanguage(Basic.getUnicodeLowerCase()));
            	} else {
            		makeUnaryAssertion(base, new AssertInLanguage(Basic.getUnicodeLowerCase().complement()));
            	}
            }
            else if (m.getSignature().equals("<java.lang.Character: boolean isTitleCase(char)>")) {
            	Variable base = getArgument(v, 0);
            	if (expected == true) {
            		makeUnaryAssertion(base, new AssertInLanguage(Basic.getUnicodeTitleCase()));
            	} else {
            		makeUnaryAssertion(base, new AssertInLanguage(Basic.getUnicodeTitleCase().complement()));
            	}
            }
            else if (m.getSignature().equals("<java.lang.Character: boolean isUpperCase(char)>")) {
            	Variable base = getArgument(v, 0);
            	if (expected == true) {
            		makeUnaryAssertion(base, new AssertInLanguage(Basic.getUnicodeUpperCase()));
            	} else {
            		makeUnaryAssertion(base, new AssertInLanguage(Basic.getUnicodeUpperCase().complement()));
            	}
            }
            else if (m.getSignature().equals("<java.lang.Character: boolean isSpaceChar(char)>")) {
            	Variable base = getArgument(v, 0);
            	if (expected == true) {
            		makeUnaryAssertion(base, new AssertInLanguage(Basic.getUnicodeSpaceChars()));
            	} else {
            		makeUnaryAssertion(base, new AssertInLanguage(Basic.getUnicodeSpaceChars().complement()));
            	}
            }
            else if (m.getSignature().equals("<java.lang.Character: boolean isWhitespace(char)>")) {
            	Variable base = getArgument(v, 0);
            	if (expected == true) {
            		makeUnaryAssertion(base, new AssertInLanguage(Basic.getUnicodeWhitespace()));
            	} else {
            		makeUnaryAssertion(base, new AssertInLanguage(Basic.getUnicodeWhitespace().complement()));
            	}
            }
        }
    }
    
    
    enum Relation {
        EQUAL,
        NOT_EQUAL,
        GREATER,
        LESS,
        GREATER_EQ,
        LESS_EQ,
    }
    private Relation negate(Relation r) {
        switch (r) {
        case EQUAL: return Relation.NOT_EQUAL;
        case NOT_EQUAL: return Relation.EQUAL;
        case GREATER: return Relation.LESS_EQ;
        case LESS: return Relation.GREATER_EQ;
        case GREATER_EQ: return Relation.LESS;
        case LESS_EQ: return Relation.GREATER;
        default: 
            throw new IllegalArgumentException("Unknown integer relation: " + r);
        }
    }
    /**
     * Swaps the left/right sides of the relation, so for example, LESS becomes GREATER,
     * and LESS_EQ becomes GREATER_EQ.
     */
    private Relation commute(Relation r) {
        switch (r) {
        case EQUAL: return Relation.EQUAL;
        case NOT_EQUAL: return Relation.NOT_EQUAL;
        case GREATER: return Relation.LESS;
        case GREATER_EQ: return Relation.LESS_EQ;
        case LESS: return Relation.GREATER;
        case LESS_EQ: return Relation.LESS;
        default: 
            throw new IllegalArgumentException("Unknown integer relation: " + r);
        }
    }
    
    /**
     * If the boolean is false, then the relation is negated, otherwise, it
     * is returned as it is.
     */
    Relation negateUnless(Relation r, boolean expected) {
        if (expected == true)
            return r;
        else
            return negate(r);
    }
    
    /**
     * Asserts that the visited statement expression has the specified relation to the specified integer constant.
     * For example, is the relation is GREATER and the integer is 6, then this asserts that the visited expression
     * evalutates to something GREATER THAN 6. 
     */
    private class IntegerVisitor extends AssertionVisitor {
        private int expected;
        private Relation relation;
        
        public IntegerVisitor(Unit unit, int expected, Relation relation) {
            super(unit);
            this.expected = expected;
            this.relation = relation;
        }
        @Override
        public void caseLocal(Local v) {
        	// assert the variable itself in case it is used (important for switch statements on a char)
        	if (expected >= Character.MIN_VALUE && expected <= Character.MAX_VALUE) {
        		if (relation == Relation.EQUAL) {
        			makeUnaryAssertion(context.getExpressionVariable(v), new AssertInLanguage(Automaton.makeChar((char)expected)));
        		}
        		if (relation == Relation.NOT_EQUAL) {
        			makeUnaryAssertion(context.getExpressionVariable(v), new AssertInLanguage(Automaton.makeChar((char)expected).complement()));
        		}
        	}
        	
        	// backtrack to find more assertions
            builder.startBranch();
            boolean found = false;
            for (Unit definition : definitions.getDefsOfAt(v, unit)) {
                if (definition instanceof DefinitionStmt) {
                    found = true;
                    assertInteger(((DefinitionStmt)definition).getRightOp(), definition, relation, expected);
                    builder.useBranch();
                }
            }
            if (!found) {
                builder.useBranch();
            }
            builder.endBranch();
        }
        
        @Override
        public void caseVirtualInvokeExpr(VirtualInvokeExpr v) {
            handleInvoke(v);
        }
        @Override
        public void caseSpecialInvokeExpr(SpecialInvokeExpr v) {
            handleInvoke(v);
        }
        private void handleInvoke(InstanceInvokeExpr v) {
            SootMethodRef m = v.getMethodRef();
            if (m.getSignature().equals("<java.lang.String: int length()>")) {
                switch (relation) {
                case EQUAL:
                    makeUnaryAssertion(getBase(v), new AssertHasLength(expected, expected));
                    break;
                case NOT_EQUAL:
                    makeUnaryAssertion(getBase(v), new AssertHasNotLength(expected, expected));
                    break;
                case GREATER:
                    makeUnaryAssertion(getBase(v), new AssertHasNotLength(0, expected));
                    break;
                case GREATER_EQ:
                    makeUnaryAssertion(getBase(v), new AssertHasNotLength(0, expected-1));
                    break;
                case LESS:
                    makeUnaryAssertion(getBase(v), new AssertHasLength(0, expected-1));
                    break;
                case LESS_EQ:
                    makeUnaryAssertion(getBase(v), new AssertHasLength(0, expected));
                    break;
                }
            }
        }
    }
    
}
