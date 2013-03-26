package dk.brics.string.java;

import soot.jimple.Stmt;

/**
 * Translates individual jimple-statements into intermediate code, which is put into
 * an {@link IntermediateFactory}. See {@link StatementTranslatorImpl}.
 * @see StatementTranslatorFacade
 * @see #translateStatement(Stmt, IntermediateFactory)
 */
public interface StatementTranslator {

	/**
	 * Translates the specified statement into intermediate code, using
	 * the specified factory. The results of the translation exist only in
	 * the side-effects imposed by method calls to the factory.
	 * @param statement the jimple statement to translate.
	 * @param factory the factory to produce intermediate code with.
	 */
	void translateStatement(Stmt statement, IntermediateFactory factory);

}