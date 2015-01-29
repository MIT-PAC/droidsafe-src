package dk.brics.string.java;

import java.util.Collection;

import dk.brics.string.external.ExternalVisibility;
import dk.brics.string.external.Resolver;

/**
 * A configuration for the jimple-to-intermediate translation. Used by the
 * constructor of {@link Jimple2Intermediate}.
 */
public interface Jimple2IntermediateFactory {
	MethodTranslator getMethodTranslator();
	TaintAnalysisStrategy getTaintAnalysisStrategy();
	ExternalVisibility getExternallyVisible();
	StaticStringTypes getStaticStringTypes();
	Collection<? extends Resolver> getResolvers();
}
