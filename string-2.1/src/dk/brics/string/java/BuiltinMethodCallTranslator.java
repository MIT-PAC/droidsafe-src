package dk.brics.string.java;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import soot.ArrayType;
import soot.BooleanType;
import soot.CharType;
import soot.IntType;
import soot.Local;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.ValueBox;
import soot.jimple.Constant;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.StringConstant;
import dk.brics.automaton.Automaton;
import dk.brics.automaton.RegExp;
import dk.brics.string.intermediate.ArrayAddAll;
import dk.brics.string.intermediate.ArrayAssignment;
import dk.brics.string.intermediate.ArrayNew;
import dk.brics.string.intermediate.ArrayWriteArray;
import dk.brics.string.intermediate.ArrayWriteElement;
import dk.brics.string.intermediate.BasicBinaryOp;
import dk.brics.string.intermediate.BasicUnaryOp;
import dk.brics.string.intermediate.Call;
import dk.brics.string.intermediate.Method;
import dk.brics.string.intermediate.PrimitiveInit;
import dk.brics.string.intermediate.StringAssignment;
import dk.brics.string.intermediate.StringBufferAppend;
import dk.brics.string.intermediate.StringBufferAppendChar;
import dk.brics.string.intermediate.StringBufferBinaryOp;
import dk.brics.string.intermediate.StringBufferInit;
import dk.brics.string.intermediate.StringBufferPrepend;
import dk.brics.string.intermediate.StringBufferUnaryOp;
import dk.brics.string.intermediate.StringConcat;
import dk.brics.string.intermediate.StringFromArray;
import dk.brics.string.intermediate.StringFromStringBuffer;
import dk.brics.string.intermediate.StringInit;
import dk.brics.string.intermediate.Variable;
import dk.brics.string.intermediate.VariableType;
import dk.brics.string.stringoperations.Basic;
import dk.brics.string.stringoperations.BinaryOperation;
import dk.brics.string.stringoperations.BooleanToString;
import dk.brics.string.stringoperations.CharAt1;
import dk.brics.string.stringoperations.CharAt2;
import dk.brics.string.stringoperations.Contains;
import dk.brics.string.stringoperations.Delete;
import dk.brics.string.stringoperations.DeleteCharAt;
import dk.brics.string.stringoperations.Insert;
import dk.brics.string.stringoperations.Postfix;
import dk.brics.string.stringoperations.Postfix2;
import dk.brics.string.stringoperations.Prefix;
import dk.brics.string.stringoperations.Replace1;
import dk.brics.string.stringoperations.Replace2;
import dk.brics.string.stringoperations.Replace3;
import dk.brics.string.stringoperations.Replace4;
import dk.brics.string.stringoperations.Replace5;
import dk.brics.string.stringoperations.Replace6;
import dk.brics.string.stringoperations.Reverse;
import dk.brics.string.stringoperations.SetCharAt1;
import dk.brics.string.stringoperations.SetCharAt2;
import dk.brics.string.stringoperations.SetLength;
import dk.brics.string.stringoperations.Split;
import dk.brics.string.stringoperations.Substring;
import dk.brics.string.stringoperations.Substring2;
import dk.brics.string.stringoperations.ToLowerCase;
import dk.brics.string.stringoperations.ToUpperCase;
import dk.brics.string.stringoperations.Trim;
import dk.brics.string.stringoperations.UnaryOperation;

/**
 * Translates calls to methods declared in {@link String}, {@link StringBuffer}, {@link StringBuilder}, and {@link Object} into
 * statements, modelling them as precisely as possible.
 */
public class BuiltinMethodCallTranslator implements MethodCallTranslator {

	private static final Automaton ARRAY_OBJECT_AUTOMATON = new RegExp("\"[Ljava.lang.String;@\"[0-9a-f]+").toAutomaton();
	private static final Automaton UNSIGNED_HEX_AUTOMATON = new RegExp("0|[1-9a-f][0-9a-f]*").toAutomaton();
	private static final Automaton UNSIGNED_OCTAL_AUTOMATON = new RegExp("0|[1-7][0-7]*").toAutomaton();
	private static final Automaton UNSIGNED_BINARY_AUTOMATON = new RegExp("0|1[01]*").toAutomaton();
	
	/**
	 * List of collection types we trust. Invoking a constructor on a
	 * collection-type not in this list will produce a corrupt collection.
	 * <p/>
	 * Note that this ONLY affects constructor call! Collections returned by
	 * eg. Collections.unmodifiableList() may be considered valid even though
	 * its type is not in this list.
	 */
	private static final String[] TRUSTED_COLLECTIONS = {
		"java.util.ArrayList",
		"java.util.Vector",
		"java.util.LinkedList",
		"java.util.HashSet",
		"java.util.LinkedHashSet",
		"java.util.TreeSet"
	};
	private static final Set<String> trustedCollections;
	static {
		Set<String> set = new HashSet<String>();
		for (String s : TRUSTED_COLLECTIONS) {
			set.add(s);
		}
		trustedCollections = Collections.unmodifiableSet(set);
	}
	
	/**
	 * List of StringBuffer methods that have no side-effects and return uninteresting objects. This technique only works
	 * because all overloads of a pure method in StringBuffer are pure.
	 * <p/>
	 * Does *not* include those declared in Object, but does include those inherited from interfaces.
	 */
	private static final String STRING_BUFFER_IGNORED_METHODS = 
		"capacity|charAt|codePointAt|codePointBefore|codePointCount|ensureCapacity|getChars|indexOf|"
	+	"lastIndexOf|length|offsetByCodePoints|subSequence|trimToSize"
	;
	
	/**
	 * Accepts names of StringBuffer methods that have no side-effects and return uninteresting objects.
	 */
	private static final Automaton STRING_BUFFER_IGNORED_METHODS_AUTO = new RegExp(STRING_BUFFER_IGNORED_METHODS).toAutomaton();
	
	public Variable translateMethodCall(InstanceInvokeExpr expr, SootMethod target, Variable callee, List<Variable> arguments, IntermediateFactory factory) {
		String methodName = target.getName();
		int numArgs = arguments.size();
		SootClass declaringClass = target.getDeclaringClass();
		
		//
		//	STRING
		//
		if (isString(declaringClass)) {
			// String.toString()
            if (methodName.equals("toString") && numArgs == 0) {
                return callee;
                
            // String.intern()
            } else if (methodName.equals("intern") && numArgs == 0) {
                return callee;
                
            // String.concat(String)	[explicit, not invoked by + operator]
            } else if (methodName.equals("concat") && numArgs == 1 && isString(target.getParameterType(0))) {
                // translate the argument
                Variable rvar = arguments.get(0);
                Variable result = factory.createVariable(VariableType.STRING);
                factory.addStatement(new StringConcat(result, callee, rvar));
                return result;
                
            // String.replace(char,char)
            } else if (methodName.equals("replace") && numArgs == 2 &&
                    isChar(target.getParameterType(0)) &&
                    isChar(target.getParameterType(1))) {
                Integer arg1 = trackInteger(expr.getArg(0));
                Integer arg2 = trackInteger(expr.getArg(1));
                UnaryOperation op;
                if (arg1 != null) {
                    if (arg2 != null) {
                        op = new Replace1((char) arg1.intValue(), (char) arg2.intValue());
                    } else {
                        op = new Replace2((char) arg1.intValue());
                    }
                } else {
                    if (arg2 != null) {
                        op = new Replace3((char) arg2.intValue());
                    } else {
                        op = new Replace4();
                    }
                }
                
                Variable temp = factory.createVariable(VariableType.STRINGBUFFER);
                Variable result = factory.createVariable(VariableType.STRING);
                factory.addStatement(new StringBufferInit(temp, callee));
                factory.addStatement(new StringBufferUnaryOp(temp, op));
                factory.addStatement(new StringFromStringBuffer(result, temp));
                return result;
                
            // String.replace(CharSequence, CharSequence)
            } else if (methodName.equals("replace") && numArgs == 2 &&
                    isCharSequence(target.getParameterType(0)) &&
                    isCharSequence(target.getParameterType(1))) {
                String arg1 = trackString(expr.getArg(0));
                String arg2 = trackString(expr.getArg(1));
                Variable result = factory.createVariable(VariableType.STRING);
                
                // if either argument is unknown, give up.	[TODO make this better]
                if (arg1 == null || arg2 == null) {
                	factory.addStatement(new StringInit(result, Basic.makeAnyString()));
                	return result;
                }
                
                Replace6 rep = new Replace6(arg1, arg2);
                Variable temp = factory.createVariable(VariableType.STRINGBUFFER);
                factory.addStatement(new StringBufferInit(temp, callee));
                factory.addStatement(new StringBufferUnaryOp(temp, rep));
                factory.addStatement(new StringFromStringBuffer(result, temp));
                return result;
                
            // String.trim()
            } else if (methodName.equals("trim") && numArgs == 0) {
                UnaryOperation op = new Trim();
                Variable temp = factory.createVariable(VariableType.STRINGBUFFER);
                Variable result = factory.createVariable(VariableType.STRING);
                factory.addStatement(new StringBufferInit(temp, callee));
                factory.addStatement(new StringBufferUnaryOp(temp, op));
                factory.addStatement(new StringFromStringBuffer(result, temp));
                return result;
            
            // String.substring(int)		[this method returns a suffix of the string, starting at the specified index]
            } else if (methodName.equals("substring") && numArgs == 1) {
                UnaryOperation op;
                Integer arg1 = trackInteger(expr.getArg(0));
                if (arg1 != null) {
                    op = new Postfix2(arg1.intValue());
                } else {
                    op = new Postfix();
                }

                Variable temp = factory.createVariable(VariableType.STRINGBUFFER);
                Variable result = factory.createVariable(VariableType.STRING);
                factory.addStatement(new StringBufferInit(temp, callee));
                factory.addStatement(new StringBufferUnaryOp(temp, op));
                factory.addStatement(new StringFromStringBuffer(result, temp));
                return result;
            
            // String.substring(int,int)
            } else if (methodName.equals("substring") && numArgs == 2) {
                UnaryOperation op;
                Integer arg1 = trackInteger(expr.getArg(0));
                Integer arg2 = trackInteger(expr.getArg(1));
                if (arg1 != null && arg2 != null) {
                    op = new Substring2(arg1.intValue(),arg2.intValue());
                } else if (arg1 != null && arg1.intValue() == 0) {
                    op = new Prefix();
                } else {
                    op = new Substring();
                }
                Variable temp = factory.createVariable(VariableType.STRINGBUFFER);
                Variable result = factory.createVariable(VariableType.STRING);
                factory.addStatement(new StringBufferInit(temp, callee));
                factory.addStatement(new StringBufferUnaryOp(temp, op));
                factory.addStatement(new StringFromStringBuffer(result, temp));
                return result;
            
            // String.toLowerCase()
            } else if (methodName.equals("toLowerCase") && numArgs == 0) {
                UnaryOperation op = new ToLowerCase();
                Variable temp = factory.createVariable(VariableType.STRINGBUFFER);
                Variable result = factory.createVariable(VariableType.STRING);
                factory.addStatement(new StringBufferInit(temp, callee));
                factory.addStatement(new StringBufferUnaryOp(temp, op));
                factory.addStatement(new StringFromStringBuffer(result, temp));
                return result;
            
            // String.toUpperCase()
            } else if (methodName.equals("toUpperCase") && numArgs == 0) {
                UnaryOperation op = new ToUpperCase();
                Variable temp = factory.createVariable(VariableType.STRINGBUFFER);
                Variable result = factory.createVariable(VariableType.STRING);
                factory.addStatement(new StringBufferInit(temp, callee));
                factory.addStatement(new StringBufferUnaryOp(temp, op));
                factory.addStatement(new StringFromStringBuffer(result, temp));
                return result;
            
            // String.split(String)
            } else if (methodName.equals("split") && numArgs == 1) {
                Variable result = factory.createVariable(VariableType.ARRAY);
                factory.addStatement(new BasicUnaryOp(result, callee, new Split()));
                return result;
            
            // String.charAt(int)
            } else if (methodName.equals("charAt") && numArgs == 1) {
                UnaryOperation op;
                Integer arg = trackInteger(expr.getArg(0));
                if (arg != null) {
                    op = new CharAt1(arg);
                } else {
                    op = new CharAt2();
                }
                Variable result = factory.createVariable(VariableType.PRIMITIVE);
                factory.addStatement(new BasicUnaryOp(result, callee, op));
                return result;
                
            // String.contains(CharSequence)
            } else if (methodName.equals("contains") && numArgs == 1) {
                // this is experimental stuff. it is working, but probably not that useful
                Variable result = factory.createVariable(VariableType.PRIMITIVE);
                factory.addStatement(new BasicBinaryOp(result, callee, arguments.get(0), new Contains()));
                return result;
            
            
            // String.contentEquals(CharSequence) and String.contentEquals(StringBuffer)
            } else if (methodName.equals("contentEquals") && numArgs == 1) {
                // we can't say anything meaningful except the argument is NOT corrupted
                // (the argument will be considered corrupted if we do not handle it here)
                Variable result = factory.createVariable(VariableType.PRIMITIVE);
                factory.addStatement(new PrimitiveInit(result, Basic.getBinaryBooleans()));
                return result;
            }
            
            // String.toCharArray()
            else if (methodName.equals("toCharArray") && numArgs == 0) {
                Variable result = factory.createVariable(VariableType.ARRAY);
                factory.addStatement(new ArrayNew(result));
                Variable charAt = factory.createVariable(VariableType.PRIMITIVE);
                factory.addStatement(new BasicUnaryOp(charAt, callee, new CharAt2()));
                factory.addStatement(new ArrayWriteElement(result, charAt));
                return result;
            }
            
			
        	return null;
			
		}
		
		//
		//		STRINGBUFFER
		//
		else if (isBufferOrBuilder(declaringClass)) {
			if (methodName.equals("toString") && numArgs == 0) {
				Variable result = factory.createVariable(VariableType.STRING);
                factory.addStatement(new StringFromStringBuffer(result, callee));
                return result;
            } 
            // StringBuffer.append(<any type>)
            else if (methodName.equals("append") && numArgs == 1) {
                Variable rvar = valueOf(expr.getArgBox(0), arguments.get(0), 10, target.getParameterType(0), factory);
                factory.addStatement(new StringBufferAppend(callee, rvar));
                return callee;
            } 
            // StringBuffer.insert(int, <any type>)
            else if (methodName.equals("insert") && numArgs == 2 &&
                    isInt(target.getParameterType(0))) {
                Integer pos = trackInteger(expr.getArg(0));
                Variable rvar = valueOf(expr.getArgBox(1), arguments.get(1), 10, target.getParameterType(0), factory);
                if (pos != null && pos.intValue() == 0) {
                	factory.addStatement(new StringBufferPrepend(callee, rvar));
                } else {
                	factory.addStatement(new StringBufferBinaryOp(callee, new Insert(), rvar));
                }
                return callee;
            } 
            // StringBuffer.delete(int,int)
            else if (methodName.equals("delete") && numArgs == 2) {
                UnaryOperation op = new Delete();
                factory.addStatement(new StringBufferUnaryOp(callee, op));
                return callee;
            } 
            // StringBuffer.deleteCharAt(int)
            else if (methodName.equals("deleteCharAt") && numArgs == 1) {
                UnaryOperation op = new DeleteCharAt();
                factory.addStatement(new StringBufferUnaryOp(callee, op));
                return callee;
            } 
            // StringBuffer.replace(int start, int end, String replacement)
            else if (methodName.equals("replace") && numArgs == 3) {
                BinaryOperation op = new Replace5();
                Variable rvar = valueOf(expr.getArgBox(2), arguments.get(2), 10, target.getParameterType(2), factory);
                factory.addStatement(new StringBufferBinaryOp(callee, op, rvar));
                return callee;
            } 
            // StringBuffer.reverse()
            else if (methodName.equals("reverse") && numArgs == 0) {
                UnaryOperation op = new Reverse();
                factory.addStatement(new StringBufferUnaryOp(callee, op));
                return callee;
            } 
            // StringBuffer.setCharAt(int, char)	[NOTE: This method returns void]
            else if (methodName.equals("setCharAt") && numArgs == 2) {
                Integer c = trackInteger(expr.getArg(1));
                if (c == null) {
                    UnaryOperation op = new SetCharAt2();
                    factory.addStatement(new StringBufferUnaryOp(callee, op));
                } else {
                    UnaryOperation op = new SetCharAt1((char) c.intValue());
                    factory.addStatement(new StringBufferUnaryOp(callee, op));
                }
                return factory.getNothing();
            } 
            // StringBuffer.setLength(int)			[NOTE: This method returns void]
            else if (methodName.equals("setLength") && numArgs == 1) {
                UnaryOperation op = new SetLength();
                factory.addStatement(new StringBufferUnaryOp(callee, op));
                return factory.getNothing();// returns void
            } 
            // StringBuffer.substring(int)			[NOTE: Returns a string]
            else if (methodName.equals("substring") && numArgs == 1) {
                UnaryOperation op = new Postfix();

                Variable result = factory.createVariable(VariableType.STRING);
                
                // clone the stringbuffer
                Variable clone = makeStringBufferClone(callee, factory);
                
                // perform the substring operation on the clone
                factory.addStatement(new StringBufferUnaryOp(clone, op));
                
                // now put the clone's value back into the result variable
                factory.addStatement(new StringFromStringBuffer(result, clone));
                
                return result;
            }  
            // StringBuffer.substring(int,int)		[NOTE: Returns a string]
            else if (methodName.equals("substring") && numArgs == 2) {
                UnaryOperation op;
                Integer arg1 = trackInteger(expr.getArg(0));
                if (arg1 != null && arg1.intValue() == 0) {
                    op = new Prefix();
                } else {
                    op = new Substring();
                }
                
                Variable result = factory.createVariable(VariableType.STRING);
                
                // clone the stringbuffer
                Variable clone = makeStringBufferClone(callee, factory);
                
                // perform the substring operation on the clone
                factory.addStatement(new StringBufferUnaryOp(clone, op));
                
                // now put the clone's value back into the result variable
                factory.addStatement(new StringFromStringBuffer(result, clone));
                
                return result;
            }
			
            else if (STRING_BUFFER_IGNORED_METHODS_AUTO.run(methodName)) {
            	// A method without side-effects. Just return something.
            	return factory.createVariable(factory.fromSootType(target.getReturnType()));
            }
			
			System.err.println("Unknown StringBuffer method: " + target.getSignature());
		}
		
		//
		//	WRAPPERS
		//
		else if (isWrapperClass(declaringClass)) {
			if (methodName.equals("toString") && numArgs == 0) {
				Automaton typeAuto = Automatons.fromType(declaringClass.getName());
				if (typeAuto == null)
					throw new RuntimeException("Unknown wrapper class " + declaringClass.getName());
				
				Variable result = factory.createVariable(VariableType.STRING);
				factory.addStatement(new StringInit(result, typeAuto));
				return result;
			}
			
			//System.err.println("Unknown wrapper method: " + target.getSignature());
		}
		
		//
		//	OBJECT
		//
		else if (isObjectClass(declaringClass)) {
			if (methodName.equals("equals") || methodName.equals("hashCode") || methodName.equals("getClass")) {
				// no side-effects
				return factory.createVariable(factory.fromSootType(target.getReturnType()));
			}
		}
		
		return null;
	}
	
	public Variable translateAbstractMethodCall(InstanceInvokeExpr expr,
			SootMethod target, Variable callee, List<Variable> arguments,
			IntermediateFactory factory) {
		SootClass declaringClass = target.getDeclaringClass();
		String methodName = target.getName();
		int numArgs = expr.getArgCount();
		
		//
		//	COLLECTIONS
		//
		if (factory.isSubtypeOf(declaringClass, Scene.v().getSootClass("java.util.Collection"))) {
			// add(String)
			if (methodName.equals("add") && numArgs == 1 && isString(expr.getArg(0).getType())) {
				factory.addStatement(new ArrayWriteElement(callee, arguments.get(0)));
				return anybool(factory);
				// note: if a non-string object was inserted, this method returns null
				// so the collection gets corrupted as it should
			}
			// add(int,String)
			else if (methodName.equals("add") && numArgs == 2 && isInt(expr.getArg(0).getType()) && isString(expr.getArg(1).getType())) {
				factory.addStatement(new ArrayWriteElement(callee, arguments.get(1)));
				return anybool(factory);
			}
			// addAll(<known collection>)
			else if (methodName.equals("addAll") && numArgs == 1 && factory.fromSootType(expr.getArg(0).getType()) == VariableType.ARRAY) {
				factory.addStatement(new ArrayWriteArray(callee, arguments.get(0)));
				return anybool(factory);
			}
			// addAll(int,<known collection>)
			else if (methodName.equals("addAll") && numArgs == 2 && isInt(expr.getArg(0).getType()) && factory.fromSootType(expr.getArg(1).getType()) == VariableType.ARRAY) {
				factory.addStatement(new ArrayWriteArray(callee, arguments.get(1)));
				return anybool(factory);
			}
			// clear()
			else if (methodName.equals("clear") && numArgs == 0) {
				// TODO Collection.clear()
				// for now just say no side-effects. this is sound.
				return factory.getNothing();
			}
			// set(int,String)
			else if (methodName.equals("set") && numArgs == 2 && isInt(expr.getArg(0).getType()) && isString(expr.getArg(1).getType())) {
				// note: List.set returns the element previously at the position
				
				// get the old element
				Variable old = factory.createVariable(VariableType.STRING);
				factory.addStatement(new StringFromArray(old, callee));
				
				// insert the new element
				factory.addStatement(new ArrayWriteElement(callee, arguments.get(1)));
				
				return old;
			}
			// get(int)
			else if (methodName.equals("get") && numArgs == 1 && isInt(expr.getArg(0).getType())) {
				Variable result = factory.createVariable(VariableType.STRING);
				factory.addStatement(new StringFromArray(result, callee));
				return result;
			}
			// iterator()
			else if (methodName.equals("iterator") && numArgs == 0) {
				// changes to the collection might reflect on the iterator
				// and vice versa (eg using ListIterator.add)
				return callee;
			}
			// listIterator()
			else if (methodName.equals("listIterator") && numArgs == 0) {
				// changes to the collection might reflect on the iterator
				// and vice versa (eg using ListIterator.add)
				return callee;
			}
			// methods without side-effects returning booleans
			else if (methodName.equals("contains")
					|| methodName.equals("containsAll")
					|| methodName.equals("isEmpty")) {
				return anybool(factory);
			}
			// remove() and removeAll() are just identity operations for now
			else if (methodName.equals("remove")
					|| methodName.equals("removeAll")) {
				return anybool(factory);
			}
			// size() 
			else if (methodName.equals("size")) {
				return factory.getNothing();
			}
			else if (methodName.equals("toArray") && numArgs == 0) {
				Variable result = factory.createVariable(VariableType.ARRAY);
				factory.addStatement(new ArrayNew(result));
				factory.addStatement(new ArrayAddAll(result, callee));
				return result;
			}
			else if (methodName.equals("toArray") && numArgs == 1) {
				Variable result = factory.createVariable(VariableType.ARRAY);
				
				// the elements MIGHT be stored into the argument
				factory.startBranch();
				// 1) not stored in argument
				{
					factory.addStatement(new ArrayNew(result));
					factory.useBranch();
				}
				// 2) stored in argument
				{
					// note: existing elements in the array may remain
					// in particular if the array is larger than the collection,
					// the exceeding elements are unchanged, so do not clear the array here
					factory.addStatement(new ArrayAssignment(result, arguments.get(0)));
					factory.useBranch();
				}
				factory.endBranch();
				
				factory.addStatement(new ArrayAddAll(result, callee));
				
				return result;
			}
		}
		
		//
		// ITERATORS
		//
		else if (factory.isSubtypeOf(declaringClass, Scene.v().getSootClass("java.util.Iterator"))) {
			if (methodName.equals("hasNext") && numArgs == 0) {
				return anybool(factory); // no side-effects
			}
			else if (methodName.equals("hasPrevious") && numArgs == 0) {
				return anybool(factory); // no side-effects
			}
			else if ((methodName.equals("next") || methodName.equals("previous")) && numArgs == 0) {
				Variable result = factory.createVariable(VariableType.STRING);
				factory.addStatement(new StringFromArray(result, callee));
				return result;
			}
			else if (methodName.equals("remove") && numArgs == 1) {
				return anybool(factory); // just prevent corruption
			}
			else if (methodName.equals("add") && numArgs == 1 && isString(expr.getArg(0).getType())) {
				factory.addStatement(new ArrayWriteElement(callee, arguments.get(0)));
				return factory.getNothing();
			}
			else if (methodName.equals("set") && numArgs == 1 && isString(expr.getArg(0).getType())) {
				factory.addStatement(new ArrayWriteElement(callee, arguments.get(0)));
				return factory.getNothing();
			}
			else if (methodName.equals("nextIndex") && numArgs == 0) {
				return factory.getNothing();
			}
			else if (methodName.equals("previousIndex") && numArgs == 0) {
				return factory.getNothing();
			}
		}
		
		return null;
	}
	
	private Variable anybool(IntermediateFactory factory) {
		Variable var = factory.createVariable(VariableType.PRIMITIVE);
		factory.addStatement(new PrimitiveInit(var, Basic.getBinaryBooleans()));
		return var;
	}
	
	public Variable translateStaticMethodCall(InvokeExpr expr, List<Variable> arguments, IntermediateFactory factory) {
		SootMethod method = expr.getMethod();
		SootClass declaringClass = method.getDeclaringClass();
		String methodName = method.getName();
		int numArgs = arguments.size();
		String className = declaringClass.getName();
		
		if (isString(declaringClass)) {
			if (methodName.equals("valueOf") && numArgs == 1) {
				return valueOf(expr.getArgBox(0), arguments.get(0), 10, method.getParameterType(0), factory);
			}
		}
		else if (isWrapperClass(declaringClass) && methodName.equals("toString") && numArgs == 1) {
			return valueOf(expr.getArgBox(0), arguments.get(0), 10, method.getParameterType(0), factory);
			// make sure wrapper classes try the remaining else-ifs
			// do not nest methodName.equals("toString") in an inner if here
		} 
		
		else if (className.equals("java.lang.Integer")) {
			if (methodName.equals("toHexString") && numArgs == 1) {
				Integer arg = trackInteger(expr.getArg(0));
				if (arg != null) {
					return makeStringConstant(Integer.toHexString(arg), factory);
				}
				return makeStringVariable(UNSIGNED_HEX_AUTOMATON, factory);
			}
			
			else if (methodName.equals("toOctalString") && numArgs == 1) {
				Integer arg = trackInteger(expr.getArg(0));
				if (arg != null) {
					return makeStringConstant(Integer.toOctalString(arg), factory);
				}
				return makeStringVariable(UNSIGNED_OCTAL_AUTOMATON, factory);
			}
			
			else if (methodName.equals("toBinaryString") && numArgs == 1) {
				Integer arg = trackInteger(expr.getArg(0));
				if (arg != null) {
					return makeStringConstant(Integer.toBinaryString(arg), factory);
				}
				return makeStringVariable(UNSIGNED_BINARY_AUTOMATON, factory);
			}
		}
		
		else if (className.equals("java.util.Arrays")) {
			if (methodName.equals("asList")) {
				return arguments.get(0);
			}
			else if (methodName.equals("equals")) {
				return anybool(factory);
			}
			else if (methodName.equals("binarySearch") 
					|| methodName.equals("deepHashCode") 
					|| methodName.equals("hashCode") 
					|| methodName.equals("sort")) {
				return factory.getNothing();
			}
		}
		
		else if (className.equals("java.util.Collections")) {
			if (methodName.equals("unmodifiableList") && numArgs == 1) {
				// the returned collection is immutable but right now it can still get corrupt
				// TODO add immunity to protect immutable collections
				return arguments.get(0);
			}
			else if (methodName.equals("unmodifiableSet") && numArgs == 1) {
				return arguments.get(0);
			}
			else if (methodName.equals("unmodifiableCollection") && numArgs == 1) {
				return arguments.get(0);
			}
			else if (methodName.equals("unmodifiableSortedSet") && numArgs == 1) {
				return arguments.get(0);
			}
			else if (methodName.equals("synchronizedList") && numArgs == 1) {
				return arguments.get(0);
			}
			else if (methodName.equals("synchronizedSet") && numArgs == 1) {
				return arguments.get(0);
			}
			else if (methodName.equals("synchronizedCollection") && numArgs == 1) {
				return arguments.get(0);
			}
			else if (methodName.equals("synchronizedSortedSet") && numArgs == 1) {
				return arguments.get(0);
			}
			else if (methodName.equals("swap") && numArgs == 2) {
				return factory.getNothing(); // language is unaffected
			}
			else if (methodName.equals("sort")) {
				return factory.getNothing();
			}
			else if (methodName.equals("shuffle")) {
				return factory.getNothing();
			}
			else if (methodName.equals("rotate")) {
				return factory.getNothing();
			}
			else if (methodName.equals("reverse")) {
				return factory.getNothing();
			}
			else if (methodName.equals("singleton") && numArgs == 1 && isString(expr.getArg(0).getType())) {
				Variable v = factory.createVariable(VariableType.ARRAY);
				factory.addStatement(new ArrayNew(v));
				factory.addStatement(new ArrayWriteElement(v, arguments.get(0)));
				return v;
			}
			else if (methodName.equals("singletonList") && numArgs == 1 && isString(expr.getArg(0).getType())) {
				Variable v = factory.createVariable(VariableType.ARRAY);
				factory.addStatement(new ArrayNew(v));
				factory.addStatement(new ArrayWriteElement(v, arguments.get(0)));
				return v;
			}
		}
		
		return null;
	}
	
	public boolean translateConstructorCall(InstanceInvokeExpr expr, Variable callee, List<Variable> arguments, IntermediateFactory factory) {
		SootMethod method = expr.getMethod();
		SootClass declaringClass = method.getDeclaringClass();
		int numArgs = arguments.size();
		
		if (isString(declaringClass)) {
			// new String()
			if (numArgs == 0) {
				factory.addStatement(new StringInit(callee, Basic.makeEmptyString()));
				return true;
			}
			
			// new String(String)
			if (numArgs == 1 && isString(method.getParameterType(0))) {
                factory.addStatement(new StringAssignment(callee, arguments.get(0)));
                return true;
			}   
			
			// new String(StringBuffer); new String(StringBuilder)
            if (numArgs == 1 && isBufferOrBuilder(method.getParameterType(0))) {
				factory.addStatement(new StringFromStringBuffer(callee, arguments.get(0)));
                return true;
            }
			
        	// unsupported constructor
        	// make any string. this is slightly better than returning false,
        	// because here we can guarantee that the arguments are not corrupted.
            factory.addStatement(new StringInit(callee, Basic.makeAnyString()));
		}
		else if (isBufferOrBuilder(declaringClass)) {
			// new StringBuffer(); new StringBuffer(int capacity)
			if (numArgs == 0 || (numArgs == 1 && isInt(method.getParameterType(0)))) {
				Variable empty = factory.createVariable(VariableType.STRING);
				factory.addStatement(new StringInit(empty, Basic.makeEmptyString()));
				factory.addStatement(new StringBufferInit(callee, empty));
				return true;
			}
			
			// new StringBuffer(String)
			if (numArgs == 1 && isString(method.getParameterType(0))) {
				factory.addStatement(new StringBufferInit(callee, arguments.get(0)));
				return true;
			}
			
			// new StringBuffer(CharSequence)
			if (numArgs == 1 && isCharSequence(method.getParameterType(0))) {
				// use the valueOf of the CharSequence, which will be its ToString-method, or
				// in case we know the argument is a StringBuffer/String/Array, we can use its language
				// directly
				Variable value = valueOf(expr.getArgBox(0), arguments.get(0), 10, method.getParameterType(0), factory);
				factory.addStatement(new StringBufferInit(callee, value));
				return true;
			}
		}
		// known collection type
		else if (trustedCollections.contains(declaringClass.getName())) {
			if (expr.getArgCount() == 0) {
				factory.addStatement(new ArrayNew(callee));
				return true;
			}
			//TODO more constructors
		}
		
		
		return false;
	}
	
	/**
	 * Returns a variable with the possible strings returned by <tt>valueOf</tt> with the specified argument.
	 * @param box the jimple-expression containing the argument.
	 * @param argument variable holding the argument (it has already been evaluated).
	 * @param radix for integers, this is the base of the number system. Unused for other types.
	 * @param type type of the formal parameter. This identifies which overload of <tt>valueOf</tt> is being called.
	 * @return a variable holding the possible return values
	 */
	private Variable valueOf(ValueBox box, Variable argument, int radix, Type type, IntermediateFactory factory) {
        // determine whether the value might be null
        boolean canBeNull = false;
        
        Value val = box.getValue();
        
        // only referene-types can be null
        // we only consider locals, because only locals and constants may occur, 
        // 		and null-constants are treated by valueOfNonNull (ironically)
        // do not consider strings here, since we assign them to the string "null" instead of null
        // note: use RefLikeType to include arrays -- RefType only includes declared types
        if (val instanceof Local && val.getType() instanceof RefLikeType && !(isString(val.getType()))) {
        	canBeNull = factory.canBeNull((Local)val);
        }
        
        if (canBeNull) {
        	Variable resultVar = factory.createVariable(VariableType.STRING);
        	
        	// if the variable might be null, split the graph in two, one for the case
        	// where it is non-null, and one where it is null.
        	// both branches should assign to 'resultVar' so we can return a variable
        	factory.startBranch();
        	
        	// not null
        	Variable notNull = valueOfNonNull(box, argument, radix, type, factory);
        	factory.addStatement(new StringAssignment(resultVar, notNull));
        	factory.useBranch();
        	
        	// null
        	factory.addStatement(new StringInit(resultVar, Automatons.getNull()));
        	factory.useBranch();
        	
        	factory.endBranch();
        	
        	return resultVar;
        } else {
        	return valueOfNonNull(box, argument, radix, type, factory);
        }
	}
	
	/**
	 * Like {@link #valueOf}, except this assumes the argument is not a variable with value <tt>null</tt>, at runtime.
	 * The argument may, however, be a <tt>null</tt>-constant.
	 */
    private Variable valueOfNonNull(ValueBox box, Variable argument, int radix, Type type, IntermediateFactory factory) {
        // don't create a new variable if the type is STRING
        if (argument.getType() == VariableType.STRING)
        	return argument;
        
        Value val = box.getValue();
        Variable result = factory.createVariable(VariableType.STRING);
        switch (argument.getType()) {
        case STRINGBUFFER:
        	if (isStringBuffer(val.getType()) || isStringBuilder(val.getType())) {
        		factory.addStatement(new StringFromStringBuffer(result, argument));
        	} else {
        		// if the type implements Appendable, we can't really know its value
        		factory.addStatement(new StringInit(result, Basic.makeAnyString()));
        	}
        	break;
        	
        case ARRAY:
        	if (val.getType() instanceof ArrayType) {	// the argument's type only says it *might* be an array
        		// TODO because of covariant arrays, we might not actually know it is a String array??
        		factory.addStatement(new StringInit(result, ARRAY_OBJECT_AUTOMATON));
        	} else {
        		factory.addStatement(new StringInit(result, Basic.makeAnyString()));
        	}
        	break;
        	
        case OBJECT:
        	factory.addStatement(new StringInit(result, Basic.makeAnyString()));
        	break;
        	
        case NULL:
        	factory.addStatement(new StringInit(result, Automatons.getNull()));
        	break;
        	
        case NONE:
            if (val instanceof Constant) {
            	String s = constantToString((Constant) val, radix, type);
            	if (s != null)
            		factory.addStatement(new StringInit(result, Basic.makeConstString(s)));
            	else
            		factory.addStatement(new StringInit(result, Basic.makeAnyString()));
                
            } else if (radix == 10 && Automatons.fromType(type.toString()) != null) { // TODO: handle radix!=10
            	
            	factory.addStatement(new StringInit(result, Automatons.fromType(type.toString())));
            	
            } else if (val.getType() instanceof RefType) {
                // Call the corresponding toString method
                Method tostring_method = factory.getToStringMethod(((RefType) val.getType()).getSootClass());
                if (tostring_method != null && !isInterface(val.getType())) {
                	factory.addStatement(new Call(result, tostring_method, new Variable[0]));
                } else {
                	factory.addStatement(new StringInit(result, Basic.makeAnyString()));
                }
            } else { // If all else fails, give any string
            	factory.addStatement(new StringInit(result, Basic.makeAnyString())); // not currently reachable, but good to have here
            }
            
            break;
            
        case PRIMITIVE:
            // TODO: If type is another primitive type, add a UnaryOp to extract this primitive type as a boolean, int, etc.
            if (val instanceof Constant) {
                // NOTE: This for char-variables, this does the same as the if-clause below, but is a bit more efficient
                factory.addStatement(new StringInit(result, Basic.makeConstString(constantToString((Constant) val, radix, type))));
                
            } else if (type.equals(CharType.v())) {
                // create a string buffer, append the char, convert it to a string and return that
                Variable tmp = factory.createVariable(VariableType.STRINGBUFFER);
                factory.addStatement(new StringBufferInit(tmp, makeStringConstant("", factory)));
                factory.addStatement(new StringBufferAppendChar(tmp, argument));
                factory.addStatement(new StringFromStringBuffer(result, tmp));
            
            } else if (type.equals(BooleanType.v())) {
                // use a BooleanToString operation
                factory.addStatement(new BasicUnaryOp(result, argument, new BooleanToString()));
                
            } else if (radix == 10 && Automatons.fromType(type.toString()) != null) { // TODO: handle radix!=10
                // unknown primitive type. use the known automaton for this type
                factory.addStatement(new StringInit(result, Automatons.fromType(type.toString())));
                
            } else {
                factory.addStatement(new StringInit(result, Basic.makeAnyString())); // not currently reachable, but good to have here
            }
            break;
            
        default:
        	throw new RuntimeException("Unknown variable type: " + argument.getType());
        } // end switch
        
        return result;
    }
	
    /**
     * Returns whether the specified type is an interface type.
     */
    private boolean isInterface(Type type) {
    	if (type instanceof RefType) {
    		return ((RefType)type).getSootClass().isInterface();
    	}
		return false;
	}
    
    /**
     * Converts a constant to a string, according to the <tt>toString</tt> method of
     * the type's wrapper object. For example, <tt>Integer.toString</tt> is used to convert
     * integers.
     * @param c the constant to convert to a string
     * @param radix for integers, this is the base of the number system. Unused for other types.
     * @param type the static type of the constant. This may differ from <tt>c</tt>'s type; 
     * 			for example because booleans are treated as integer constants.
     * @return result of <tt>toString</tt> of the specified constant.
     */
	private String constantToString(Constant c, int radix, Type type) {
    	String s;
    	if (c instanceof soot.jimple.NullConstant) {
            s = "null";
            
        } else if (c instanceof soot.jimple.IntConstant) {
            int value = ((soot.jimple.IntConstant) c).value;
            
            // booleans and chars are treated as integer constants, so we must check
            // which overload of valueOf was invoked, to see how it is converted to a string
            if (type instanceof BooleanType)
            	s = (value == 0) ? "false":"true";
            else if (type instanceof CharType)
            	s = "" + (char)value;
            else
            	s = Integer.toString(value, radix);
            
        } else if (c instanceof soot.jimple.LongConstant) {
            long value = ((soot.jimple.LongConstant) c).value;
            s = Long.toString(value, radix);
            
        } else if (c instanceof soot.jimple.DoubleConstant) {
            double value = ((soot.jimple.DoubleConstant) c).value;
            s = Double.toString(value);
            
        } else if (c instanceof soot.jimple.FloatConstant) {
            float value = ((soot.jimple.FloatConstant) c).value;
            s = Float.toString(value);
            
        } else if (c instanceof soot.jimple.StringConstant) {
            s = ((soot.jimple.StringConstant) c).value;
            
        } else if (c instanceof soot.jimple.ClassConstant) {
        	return null; // simulating this takes a lot of code
        	// this currently works, but gives the <any string> language
        	// TODO class constants
        } else {
            throw new RuntimeException("unexpected Soot constant kind");
        }
        return s;
    }

	/**
     * Checks whether the given type is <code>java.lang.CharSequence</code>.
     */
    private boolean isCharSequence(Type t) {
        return t.equals(RefType.v("java.lang.CharSequence"));
    }
    
//	/**
//     * Checks whether the given class is <code>java.lang.CharSequence</code>.
//     */
//    private boolean isCharSequence(SootClass c) {
//        return c.getName().equals("java.lang.CharSequence");
//    }

    /**
     * Checks whether the given type is <code>String</code>.
     */
    private boolean isString(Type t) {
        return t.equals(RefType.v("java.lang.String"));
    }

    /**
     * Checks whether the given class is <code>String</code>.
     */
    private boolean isString(SootClass c) {
        return c.getName().equals("java.lang.String");
    }
    
    private boolean isBufferOrBuilder(Type t) {
    	return isStringBuffer(t) || isStringBuilder(t);
    }

    private boolean isBufferOrBuilder(SootClass t) {
    	return isStringBuffer(t) || isStringBuilder(t);
    }
    
//    private boolean isObjectClass(Type t) {
//    	return t.equals(RefType.v("java.lang.Object"));
//    }

    private boolean isObjectClass(SootClass c) {
    	return c.getName().equals("java.lang.Object");
    }
    
//    /**
//     * Checks whether the given type is <code>Collection</code>.
//     */
//    private boolean isCollection(Type t) {
//        return t.equals(RefType.v("java.util.Collection"));
//    }
//    
//    /**
//     * Checks whether the given type is <code>List</code>.
//     */
//    private boolean isList(Type t) {
//        return t.equals(RefType.v("java.util.List"));
//    }
//    
//    /**
//     * Checks whether the given type is <code>Set</code>.
//     */
//    private boolean isSet(Type t) {
//        return t.equals(RefType.v("java.util.Set"));
//    }
    
    /**
     * Checks whether the given type is <code>StringBuffer</code>.
     */
    private boolean isStringBuffer(Type t) {
        return t.equals(RefType.v("java.lang.StringBuffer"));
    }

    /**
     * Checks whether the given class is <code>StringBuffer</code>.
     */
    private boolean isStringBuffer(SootClass c) {
        return c.getName().equals("java.lang.StringBuffer");
    }

    /**
     * Checks whether the given type is <code>StringBuilder</code>.
     */
    private boolean isStringBuilder(Type t) {
        return t.equals(RefType.v("java.lang.StringBuilder"));
    }

    /**
     * Checks whether the given class is <code>StringBuilder</code>.
     */
    private boolean isStringBuilder(SootClass c) {
        return c.getName().equals("java.lang.StringBuilder");
    }
    
//    /**
//     * Checks whether the given class is <code>Appendable</code>.
//     */
//    private boolean isAppendable(SootClass c) {
//    	return c.getName().equals("java.lang.Appendable");
//    }

    /**
     * Checks whether the given type is <code>int</code>.
     */
    private boolean isInt(Type t) {
        return t.equals(IntType.v());
    }

    /**
     * Checks whether the given type is <code>char</code>.
     */
    private boolean isChar(Type t) {
        return t.equals(CharType.v());
    }

    /**
     * Checks whether the given class is a standard wrapper class.
     */
    private boolean isWrapperClass(SootClass c) {
        return c.getName().equals("java.lang.Boolean")
                || c.getName().equals("java.lang.Byte")
                || c.getName().equals("java.lang.Character")
                || c.getName().equals("java.lang.Double")
                || c.getName().equals("java.lang.Float")
                || c.getName().equals("java.lang.Integer")
                || c.getName().equals("java.lang.Long")
                || c.getName().equals("java.lang.Short");
    }
	

    /**
     * Attempts to find a constant string value. Returns null if unable to determine constant
     */
    private String trackString(Value val) {
        if (val instanceof StringConstant) {
            return ((StringConstant) val).value;
        }
        return null;
    }

    /**
     * Attempts to find constant integer (or char) value.
     * Returns null if unable to determine constant.
     */
    private Integer trackInteger(Value val) {
        if (val instanceof IntConstant) {
            return ((IntConstant) val).value;
        }
        // TODO: make some more intelligent tracking of integers
        return null;
    }
	

    /**
     * Creates a clone of the stringbuffer in the specified variable, such that the
     * two variables are <i>not</i> aliases, and the clone may be modified without
     * polluting the original stringbuffer.
     * @param buffer variable holding the stringbuffer to clone
     * @return a new variable holding a new stringbuffer
     */
    private Variable makeStringBufferClone(Variable buffer, IntermediateFactory factory) {
    	if (buffer == null || buffer.getType() != VariableType.STRINGBUFFER) {
    		throw new IllegalArgumentException("Can only clone STRINGBUFFER variables");
    	}
    	// get the current possible values of the buffer
    	Variable currentValue = factory.createVariable(VariableType.STRING);
    	factory.addStatement(new StringFromStringBuffer(currentValue, buffer));
    	
    	// create a new string buffer with this initial value
    	Variable clone = factory.createVariable(VariableType.STRINGBUFFER);
    	factory.addStatement(new StringBufferInit(clone, currentValue));
    	
    	return clone;
    }

    private Variable makeStringVariable(Automaton auto, IntermediateFactory factory) {
    	Variable var = factory.createVariable(VariableType.STRING);
    	factory.addStatement(new StringInit(var, auto));
    	return var;
    }
    private Variable makeStringConstant(String value, IntermediateFactory factory) {
    	Variable var = factory.createVariable(VariableType.STRING);
    	factory.addStatement(new StringInit(var, Automaton.makeString(value)));
    	return var;
    }
    
}
