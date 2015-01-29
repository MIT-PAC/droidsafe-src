package dk.brics.string.java;

import java.util.Map;

import soot.SootMethod;
import soot.jimple.Stmt;
import soot.toolkits.scalar.LocalDefs;

public class AssertionContext {
	private TranslationContext context;
	private LocalDefs definitions;
	private Map<Stmt, TranslatedStatement> translations;
	private SootMethod method;
	
	
	public AssertionContext(TranslationContext context, LocalDefs definitions,
			Map<Stmt, TranslatedStatement> translations, SootMethod method) {
		this.context = context;
		this.definitions = definitions;
		this.translations = translations;
		this.method = method;
	}
	
	public SootMethod getMethod() {
		return method;
	}
	public void setMethod(SootMethod method) {
		this.method = method;
	}
	public TranslationContext getTranslationContext() {
		return context;
	}

	public void setContext(TranslationContext context) {
		this.context = context;
	}

	public LocalDefs getLocalDefinitions() {
		return definitions;
	}

	public void setDefinitions(LocalDefs definitions) {
		this.definitions = definitions;
	}

	public Map<Stmt, TranslatedStatement> getStatementTranslations() {
		return translations;
	}

	public void setTranslations(Map<Stmt, TranslatedStatement> translations) {
		this.translations = translations;
	}
	
	
}
