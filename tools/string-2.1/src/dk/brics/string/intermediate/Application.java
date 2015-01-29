package dk.brics.string.intermediate;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import dk.brics.string.intermediate.operations.AliasAnalysis;
import dk.brics.string.intermediate.operations.OperationAssertionAnalysis;
import dk.brics.string.intermediate.operations.Intermediate2Dot;
import dk.brics.string.intermediate.operations.ReachingDefinitions;

/**
 * The root of an intermediate program. The application contains {@link Method} objects,
 * which in turn contain {@link Statement} objects. The application is responsible
 * for creating new variables and fields when requested, and must distribute unique keys
 * to variables, methods, and statements.
 * <p/>
 * A robust structure of an intermediate program is strictly enforced by these classes.
 * The following invariants are enforced (some only when assertion are enabled):
 * <ul>
 * <li>A method belongs to exactly one application.
 * <li>A statement belongs to exactly one method (after it has been added).
 * <li>A statement <i>S</i>'s successor will list <i>S</i> as a predecessor (and vice versa).
 * <li>A statement does not list the same successor or predecessor twice (implemented as a list but works like a set).
 * <li>Methods like {@link Method#getCallSites()} and {@link Field#getFieldAssignments()} always work, and require no assistance from outside
 *      this package.
 * <li>Field variables are only used in {@link FieldReference} and {@link FieldAssignment} statements.
 * </ul>
 */
public class Application {

    private Set<Method> methods = new HashSet<Method>();
    private Set<Field> fields = new HashSet<Field>();
    
    private int nextMethodKey = 0;
    private int nextStatementKey = 0;
    private int nextVariableKey = 0;
    
    /**
     * Constructs a new application from an array of methods.
     * This will iterate all statements to find all fields used by the applicaton.
     */
    public Application() {
    }
    
    /**
     * Creates a new local variable.
     * @param type type of the variable
     * @return a new variable
     */
    public Variable createVariable(VariableType type) {
        return new Variable(nextVariableKey++, type);
    }
    
    /**
     * Creates a new field.
     * @param type type of the field
     * @param isStatic whether the field is static
     * @return a new field
     */
    public Field createField(VariableType type, boolean isStatic) {
        Field field = new Field(createVariable(type), isStatic);
        fields.add(field);
        return field;
    }
    
    void addStatement(Statement stm) {
        stm.setKey(nextStatementKey++);
    }
    
    /**
     * Adds a method to this application.
     * @exception IllegalStateException if the method has already been added to an application.
     * @param method a method not already added to an application.
     * @return the method's key
     */
    int addMethod(Method method) {
        methods.add(method);
        return nextMethodKey++;
    }
    
    /**
     * Returns a read-only view of the methods in this application.
     * @return an unmodifiable set of methods, backed by the application.
     */
    public Set<Method> getMethods() {
        return Collections.unmodifiableSet(methods);
    }
    
    /**
     * Returns a read-only view of the fields in the entire application.
     * @return a read-only set, backed by the application.
     */
    public Set<Field> getFields() {
        return Collections.unmodifiableSet(fields);
    }

    /**
     * Returns Graphviz representation of this application.
     */
    public String toDot(ReachingDefinitions rd, AliasAnalysis aa, Set<Statement> hotspots) {
        return Intermediate2Dot.convert(this, rd, aa, hotspots);
    }
    
    /**
     * Returns Graphviz representation of this application.
     */
    public String toDot(ReachingDefinitions rd, AliasAnalysis aa, OperationAssertionAnalysis ass, Set<Statement> hotspots) {
        return Intermediate2Dot.convert(this, rd, aa, ass, hotspots);
    }
}
