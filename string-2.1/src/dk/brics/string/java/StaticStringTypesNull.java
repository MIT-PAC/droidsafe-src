package dk.brics.string.java;

import soot.SootField;
import soot.SootMethod;
import dk.brics.automaton.Automaton;

/**
 * Defines no static string types.
 * 
 * @author Asger
 *
 */
public class StaticStringTypesNull implements StaticStringTypes {
    public Automaton getFieldType(SootField field) {
        return null;
    }
    public Automaton getMethodReturnType(SootMethod method) {
        return null;
    }
    public Automaton getParameterType(SootMethod method, int paramIndex) {
        return null;
    }
}
