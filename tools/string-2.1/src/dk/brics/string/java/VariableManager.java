package dk.brics.string.java;

import java.util.HashMap;
import java.util.Map;

import soot.Local;
import soot.SootField;
import dk.brics.string.intermediate.Application;
import dk.brics.string.intermediate.Field;
import dk.brics.string.intermediate.Variable;
import dk.brics.string.intermediate.VariableType;

/**
 * Keeps a mapping from soot locals and fields, to their corresponding intermediate locals and fields.
 */
public class VariableManager {
	
	private Application application;
	private Variable nothingVar;
	private Map<Local, Variable> locals = new HashMap<Local, Variable>();
	private Map<SootField, Field> fields = new HashMap<SootField, Field>();
	private TranslationContext jt;
	
	public VariableManager(Application application, TranslationContext jt) {
		this.application = application;
		this.nothingVar = application.createVariable(VariableType.NONE);
		this.jt = jt;
	}
	
	public Variable createVariable(VariableType type) {
	    return application.createVariable(type);
	}
	
	public Variable getNothing() {
		return nothingVar;
	}
	
	public Variable getLocal(Local local) {
		Variable var = locals.get(local);
		if (var == null) {
			var = application.createVariable(jt.fromSootType(local.getType()));
			locals.put(local, var);
		}
		return var;
	}
	
	public Field getField(SootField sootField) {
		Field field = fields.get(sootField);
		if (field == null) {
			VariableType type = jt.fromSootType(sootField.getType());
			field = application.createField(type, sootField.isStatic());
			fields.put(sootField, field);
		}
		return field;
	}
}
