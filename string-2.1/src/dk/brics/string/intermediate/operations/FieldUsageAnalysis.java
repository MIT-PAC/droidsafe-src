package dk.brics.string.intermediate.operations;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import dk.brics.string.intermediate.Call;
import dk.brics.string.intermediate.Field;
import dk.brics.string.intermediate.FieldStatement;
import dk.brics.string.intermediate.Method;
import dk.brics.string.intermediate.Statement;
import dk.brics.string.util.MultiMap;

/**
 * Finds the set of fields that each method reads and/or modifies.
 * <p/>
 * Formally, a method reads the field <tt>F</tt> if it contains a reference to <tt>F</tt>,
 * or a call to a method that reads <tt>F</tt>. Likewise, it assigns to <tt>F</tt> if it
 * contains an assignment to <tt>F</tt>, or a call to a method that assigns to <tt>F</tt>.
 */
public class FieldUsageAnalysis {
	
	private MultiMap<Method, Field> uses = new MultiMap<Method, Field>();
	
	public FieldUsageAnalysis(Collection<? extends Method> methods) {
		// find non-transitive usage
		for (Method method : methods) {
			for (Statement statement : method.getStatements()) {
				if (statement instanceof FieldStatement) {
				    FieldStatement stm = (FieldStatement)statement;
					Field field = stm.getField();
					uses.add(method, field);
				}
			}
		}
		
		// apply transitive closure
		// TODO does the cubic framework provide a faster solution to this??
		Set<Method> methodQueue = new HashSet<Method>();
		methodQueue.addAll(methods);
		while (!methodQueue.isEmpty()) {
			// pop a method from the queue
			Iterator<Method> it = methodQueue.iterator();
			Method method = it.next();
			it.remove();
			
			// add defined fields backwards to all callers
			Set<Field> use = uses.getView(method);
			for (Call call : method.getCallSites()) {
				Method callerMethod = call.getMethod();
				if (callerMethod == method)
					continue;
				
				boolean changed = uses.addAll(callerMethod, use);
				
				if (changed) {
					methodQueue.add(callerMethod);
				}
			}
		}
	}
	
	/**
	 * Returns the set of fields that may be read and/or modified
	 * as a result of invoking the method. 
	 * @param method a method
	 * @return an unmodifiable set
	 */
	public Set<Field> getUsedFields(Method method) {
	    return uses.getView(method);
	}
}
