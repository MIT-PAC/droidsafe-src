package dk.brics.string.intermediate.operations;

import java.util.HashMap;
import java.util.LinkedList;

import dk.brics.string.intermediate.FieldAssignment;
import dk.brics.string.intermediate.Method;
import dk.brics.string.intermediate.Return;
import dk.brics.string.intermediate.Statement;

/**
 * To get a sound analysis for fields containing mutable types, 
 * we must use a flow insensitive analysis or use the hack 
 * implemented by this class. 
 * 
 * If fields containing mutable fields are handled in another
 * way, then this phase can safely be removed
 * 
 * @author Bárður
 *
 */
public class HandleFieldAssignment {

	public HandleFieldAssignment(Method[] methods) {
		for (Method m : methods) {
			LinkedList<FieldAssignment> assigns = new LinkedList<FieldAssignment>();
			for (Statement s : m.getStatements()) {
				if (s instanceof FieldAssignment) {
					FieldAssignment assign = (FieldAssignment)s;
					if (assign.getTo().getType().mightBeUsefulMutable()) {
						assigns.add(assign);
					}
				}
			}
			if (!assigns.isEmpty()) {
				for (Return r : m.getReturns()) {
					LinkedList<FieldAssignment> copiedAssigns = new LinkedList<FieldAssignment>();
					for (FieldAssignment assign : assigns) {
						FieldAssignment copiedAssign = new FieldAssignment(assign.getField(), assign.getFrom());
						m.addStatement(copiedAssign);
						if (!copiedAssigns.isEmpty()) {
							FieldAssignment pred = copiedAssigns.getLast();
							pred.addSucc(copiedAssign);
						}
						copiedAssigns.add(copiedAssign);
					}
					if (!copiedAssigns.isEmpty()) {
						HashMap<Integer,Statement> predsMap = new HashMap<Integer,Statement>();
						int counter = 0;
						for (Statement pred : r.getPreds()) {
							predsMap.put(counter, pred);
							counter++;
						}
						Statement first = copiedAssigns.getFirst();
						for (int i=0; i<predsMap.size(); i++) {
							Statement pred = predsMap.get(i);
							pred.getSuccs().remove(r);
							pred.addSucc(first);
							r.getPreds().remove(pred);
						}
						copiedAssigns.getLast().addSucc(r);
					}
				}
			}
		}
	}
}
