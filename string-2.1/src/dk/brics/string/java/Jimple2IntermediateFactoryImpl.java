package dk.brics.string.java;

import java.util.Collection;
import java.util.Collections;

import dk.brics.string.MethodNameTaintAnalysisStrategy;
import dk.brics.string.external.ExternalVisibility;
import dk.brics.string.external.Resolver;

public class Jimple2IntermediateFactoryImpl implements Jimple2IntermediateFactory {
	
	private StatementTranslator methodBodyTranslator;
	private MethodCallTranslator methodCallTranslator;
	private FieldReferenceTranslator fieldReferenceTranslator;
	private MethodTranslator methodTranslator;
	private StatementTranslatorFacade statementTranslator;
	private ExternalVisibility externallyVisible;
	private TaintAnalysisStrategy taintAnalysisStrategy;
	private Collection<? extends Resolver> resolvers;
	private StaticStringTypes staticStringTypes;
	
	public Jimple2IntermediateFactoryImpl(ExternalVisibility ext, Collection<? extends Resolver> resolvers) {
		externallyVisible = ext;
		taintAnalysisStrategy = new MethodNameTaintAnalysisStrategy(Collections.<String>emptyList());
		this.resolvers = resolvers;
        this.staticStringTypes = new StaticStringTypesNull();
		init();
	}
	public Jimple2IntermediateFactoryImpl(ExternalVisibility ext, TaintAnalysisStrategy taint, Collection<? extends Resolver> resolvers) {
		externallyVisible = ext;
		taintAnalysisStrategy = taint;
		this.resolvers = resolvers;
		this.staticStringTypes = new StaticStringTypesNull();
		init();
	}
    public Jimple2IntermediateFactoryImpl(ExternalVisibility ext, 
            TaintAnalysisStrategy taint,
            StaticStringTypes stringTypes,
            Collection<? extends Resolver> resolvers) {
        externallyVisible = ext;
        taintAnalysisStrategy = taint;
        this.resolvers = resolvers;
        this.staticStringTypes = stringTypes;
        init();
    }
	
	
	private void init() {
		methodCallTranslator = new CompositeMethodCallTranslator(
				new BuiltinMethodCallTranslator(),
				new ResolverMethodCallTranslator(resolvers),
				new ApplicationMethodCallTranslator());
		fieldReferenceTranslator = new CompositeFieldReferenceTranslator(
		        new ResolverFieldReferenceTranslator(resolvers),
		        new ApplicationFieldReferenceTranslator());
		methodBodyTranslator = new StatementTranslatorImpl(methodCallTranslator, fieldReferenceTranslator);
		statementTranslator = new StatementTranslatorFacadeImpl(methodBodyTranslator);
		methodTranslator = new MethodTranslatorImpl(statementTranslator);
	}
	
	public MethodTranslator getMethodTranslator() {
		return methodTranslator;
	}

	public StatementTranslatorFacade getStatementTranslatorFacade() {
		return statementTranslator;
	}

	public ExternalVisibility getExternallyVisible() {
		return externallyVisible;
	}

	public TaintAnalysisStrategy getTaintAnalysisStrategy() {
		return taintAnalysisStrategy;
	}
	
	public Collection<? extends Resolver> getResolvers() {
		return resolvers;
	}
	
	public StaticStringTypes getStaticStringTypes() {
	    return staticStringTypes;
	}
	
}
