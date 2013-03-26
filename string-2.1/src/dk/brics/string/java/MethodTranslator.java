package dk.brics.string.java;

import java.util.List;

import soot.SootMethod;
import dk.brics.string.intermediate.Method;

/**
 * Translates the bodies of jimple-methods into intermediate form.
 * <p/>
 * This interface is used by {@link Jimple2Intermediate} to interact with
 * the {@link MethodTranslatorImpl} class.
 * <p/>
 * The diagram below indicates how the classes interact during
 * the translation of jimple code. An arrow indicates calls to methods 
 * declared in the specified interface, with the destination class
 * being the implementation that is used.
 * <pre>
 * {@link Jimple2Intermediate}
 *          |
 *          |  (interface: {@link MethodTranslator})
 *          V
 * {@link MethodTranslatorImpl}
 *          |
 *          |  (interface: {@link StatementTranslatorFacade})
 *          V
 * {@link StatementTranslatorFacadeImpl}
 *          | 
 *          |  (interface: {@link StatementTranslator})
 *          V 
 * {@link StatementTranslatorImpl}
 *          | 
 *          |  (interface: {@link MethodCallTranslator})
 *          V 
 * {@link CompositeMethodCallTranslator}
 *          |  
 *          +--&gt; {@link BuiltinMethodCallTranslator}
 *          +--&gt; {@link ResolverMethodCallTranslator}
 *          +--&gt; {@link ApplicationMethodCallTranslator}
 * </pre>
 * For completeness, there should be an additional arrow to {@link StatementTranslatorFacadeImpl} going upwards
 * from {@link StatementTranslatorImpl} and the method call translators, with the interface
 * {@link IntermediateFactory}, with another arrow to {@link Jimple2Intermediate} with the interface
 * {@link TranslationContext}.
 */
public interface MethodTranslator {
	/**
	 * Translates the body of the specified jimple-method, and stores
	 * the intermediate code in the appropriate intermediate {@link Method}.
	 * @param sootMethod a method from an application class.
	 * @return a new list of all the hotspots and associated information found in the method.
	 */
	List<HotspotInfo> translateMethod(SootMethod sootMethod, TranslationContext jt);
}
