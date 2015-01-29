package dk.brics.string.java;

import java.util.LinkedList;
import java.util.List;

import soot.ValueBox;
import soot.jimple.FieldRef;
import dk.brics.string.intermediate.Variable;

public class CompositeFieldReferenceTranslator implements FieldReferenceTranslator {
    private List<FieldReferenceTranslator> children = new LinkedList<FieldReferenceTranslator>();
    
    public CompositeFieldReferenceTranslator(FieldReferenceTranslator ... children) {
        for (FieldReferenceTranslator child : children) {
            this.children.add(child);
        }
    }
    
    public boolean translateFieldAssignment(FieldRef leftSide,
            Variable rightSide, IntermediateFactory factory) {
        for (FieldReferenceTranslator child : children) {
            if (child.translateFieldAssignment(leftSide, rightSide, factory)) {
                return true;
            }
        }
        return false;
    }
    public Variable translateFieldRef(FieldRef reference, ValueBox box,
            IntermediateFactory factory) {
        for (FieldReferenceTranslator child : children) {
            Variable result = child.translateFieldRef(reference, box, factory);
            if (result != null)
                return result;
        }
        return null;
    }
}
