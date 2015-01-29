package dk.brics.string.java;

import java.util.List;

import soot.Unit;
import soot.ValueBox;
import soot.jimple.IfStmt;

/**
 * Analyzes the conditions of <tt>if</tt> and <tt>switch</tt> statements and produces corresponding assertion statement for the intermediate program.
 * 
 * @author Asger
 *
 */
public interface AssertionCreator {
    /**
     * Creates assertions that must hold when the if statement's condition is true and false, respectively.
     * The assertions should be added to the intermediate factory using its 
     * {@link IntermediateFactory#addStatement(dk.brics.string.intermediate.Statement) addStatement} method.
     * @param context the <b>ACME Assertion Creation Kit&trade;</b> toolbox of useful stuff!
     * @return assertions for when the condition is true or false, respectively
     */
    AssertionBranches createAssertions(IfStmt branch, AssertionContext context);
    
    /**
     * Creates assertions that must hold when a switch statement branches to the specified
     * case block.
     * <p/>
     * Fall-through from another case block should <i>not</i> be taken into account. The assertions may assume
     * that this particular case was chosen first-hand.
     * @param variable the expression <tt>x</tt> as used in <tt>switch(x) {...}</tt>.
     * @param value the <tt>y</tt> as used in <tt>case y: ...</tt>
     * @param switchStart the start of the switch statement
     * @param context see {@link AssertionContext}
     * @return assertions that hold when this particular switch case is chosen 
     */
    AssertionBranch createSwitchAssertions(ValueBox variable, int value, Unit switchStart, AssertionContext context);
    
    /**
     * Creates assertions that must hold when a switch statement branches to the default block.
     * <p/>
     * Fall-through from a case block should <i>not</i> be taken into account. The assertions may assume
     * that none of the case blocks were executed.
     * @param variable the expression <tt>x</tt> as used in <tt>switch(x) {...}</tt>.
     * @param skippedValues a list with all the <tt>case</tt> values in the switch
     * @param switchStart the start of the switch statement
     * @param context see {@link AssertionContext}
     * @return assertions that hold when the default case is chosen
     */
    AssertionBranch createSwitchDefaultAssertions(ValueBox variable, List<Integer> skippedValues, Unit switchStart, AssertionContext context);
}
