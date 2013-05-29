package dk.brics.string.java;

import java.util.HashMap;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.AutomatonProvider;
import dk.brics.automaton.RegExp;

/**
 * Provides automatons for common Java types. All automatons
 * are defined to accept the possible output of a <tt>toString</tt> method,
 * so integer literals like <tt>-0</tt> and float literals <tt>.45</tt> are <i>not</i>
 * accepted!
 */
public class Automatons implements AutomatonProvider {
	private static Automaton intAuto;
	private static Automaton uintAuto;
	private static Automaton floatAuto;
	private static Automaton booleanAuto;
	private static Automaton nullAuto;
	private static Automaton charAuto;

	private static HashMap<String, Automaton> automatonMap = new HashMap<String, Automaton>();;

	static {
    intAuto = new RegExp("0|-?[1-9][0-9]*").toAutomaton();
    intAuto.setInfo("<int>");
		uintAuto = new RegExp("0|[1-9][0-9]*").toAutomaton();
                uintAuto.setInfo("<uint>");
		floatAuto =  new RegExp("<int>\".\"(0|[0-9]*[1-9])(E<int>)?|NaN|Infinity|-Infinity").toAutomaton(new Automatons());
                floatAuto.setInfo("<float>");
		booleanAuto = new RegExp("true|false").toAutomaton();
                booleanAuto.setInfo("<boolean>");
		nullAuto = Automaton.makeString("null");
                nullAuto.setInfo("<null>");
		charAuto = Automaton.makeAnyChar();

		automatonMap.put("int", intAuto);
		automatonMap.put("long", intAuto);
		automatonMap.put("short", intAuto);
		automatonMap.put("byte", intAuto);
		automatonMap.put("float", floatAuto);
		automatonMap.put("double", floatAuto);
		automatonMap.put("boolean", booleanAuto);
		automatonMap.put("char", charAuto);
		
		automatonMap.put("java.lang.Integer", intAuto);
		automatonMap.put("java.lang.Long", intAuto);
		automatonMap.put("java.lang.Short", intAuto);
		automatonMap.put("java.lang.Byte", intAuto);
		automatonMap.put("java.lang.Float", floatAuto);
		automatonMap.put("java.lang.Double", floatAuto);
		automatonMap.put("java.lang.Boolean", booleanAuto);
		automatonMap.put("java.lang.Character", charAuto);
	}
	
	public Automaton getAutomaton(String name) {
		if (name.equals("int")) {
			return intAuto;
		} else if (name.equals("uint")) {
			return uintAuto;
		} else if (name.equals("float")) {
			return floatAuto;
		} else if (name.equals("boolean")) {
			return booleanAuto;
		} else if (name.equals("null")) {
			return nullAuto;
		}
		return null;
	}

	/**
         * Gets an automaton accepting the possible return values
         * of <tt>Integer.toString()</tt>, <tt>Long.toString()</tt>, <tt>Byte.toString()</tt>
         * and <tt>Short.toString()</tt>.
         * Does not accept the string <tt>"null"</tt>.
         * <p/>
         * Integer literals like <tt>-0</tt> and <tt>034</tt> are not accepted,
         * because such literals cannot be returned by the <tt>toString</tt> method.
         */
	public static Automaton getInteger() {
		return intAuto;
	}

	/**
         * Gets an automaton accepting the possible return values
         * of <tt>Integer.toString()</tt> and <tt>Long.toString()</tt>
         * for non-negative integers.
         * Does not accept the string <tt>"null"</tt>.
         * <p/>
         * Integer literals like <tt>034</tt> are not accepted,
         * because such literals cannot be returned by the <tt>toString</tt> method.
         */
	public static Automaton getUnsignedInteger() {
		return uintAuto;
	}

	/**
         * Gets an automaton accepting the possible return values
         * of <tt>Float.toString()</tt> and <tt>Double.toString()</tt>.
         * Does not accept the string <tt>"null"</tt>.
         * <p/>
         * Note that this includes the strings <tt>"NaN"</tt>, <tt>"Infinity"</tt>
         * and <tt>"-Infinity"</tt> (without the quotes).
         */
	public static Automaton getFloat() {
		return floatAuto;
	}

	/**
         * Gets an automaton accepting the possible return values
         * of <tt>Boolean.toString()</tt>, which are the strings <tt>"true"</tt> and <tt>"false"</tt>.
         * Does not accept the string <tt>"null"</tt>.
         */
	public static Automaton getBoolean() {
		return booleanAuto;
	}

	/**
         * Gets an automaton accepting only the string <tt>"null"</tt>.
         */
	public static Automaton getNull() {
		return nullAuto;
	}

	/**
         * Gets an automaton accepting values of the specified type converted to a string.
         * @param name name of a primitive type or a wrapper type. For example, <tt>int</tt> or <tt>java.lang.Boolean</tt>.
         * @return an automaton accepting values of the specified type converted to a string, or <tt>null</tt> if the
         * 		name was not a primitive or wrapper type.
         */
	public static Automaton fromType(String name) {
		return automatonMap.get(name);
	}

}
