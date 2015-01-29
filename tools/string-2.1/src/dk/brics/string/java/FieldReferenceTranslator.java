package dk.brics.string.java;

import soot.ValueBox;
import soot.jimple.FieldRef;
import dk.brics.string.intermediate.Variable;

public interface FieldReferenceTranslator {
    Variable translateFieldRef(FieldRef reference, ValueBox box, IntermediateFactory factory);
    boolean translateFieldAssignment(FieldRef leftSide, Variable rightSide, IntermediateFactory factory);
}
