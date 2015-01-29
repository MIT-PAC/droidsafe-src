package dk.brics.string.java;

import soot.SootMethod;
import soot.jimple.Stmt;
import soot.jimple.toolkits.annotation.nullcheck.NullnessAnalysis;

/**
 * Handles translation of statements when requested by {@link MethodTranslator}.
 * Ultimately, the translation is redelegeted to {@link StatementTranslatorImpl}.
 * <p/>
 * This interface hides the details of using the statement translator and assembling the created
 * statements to a control-flow graph.
 * @see StatementTranslatorFacadeImpl
 * @see #translateStatement(Stmt, SootMethod, NullnessAnalysis, TranslationContext)
 */
public interface StatementTranslatorFacade {
	
	/**
	 * Translates the specified Jimple-statement into intermediate code, and returns
	 * the entry- and exitpoint for the created graph.
	 * @param stmt the statement to translate.
	 * @param sootMethod the method whose body contains the statement.
	 * @return entry- and exitpoint for the in created graph.
	 */
	TranslatedStatement translateStatement(Stmt stmt, SootMethod sootMethod, NullnessAnalysis nullAnalysis, TranslationContext jt);

}
