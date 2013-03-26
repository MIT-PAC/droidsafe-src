package dk.brics.string.java;

import soot.ValueBox;
import soot.jimple.FieldRef;
import dk.brics.string.intermediate.Field;
import dk.brics.string.intermediate.FieldAssignment;
import dk.brics.string.intermediate.FieldReference;
import dk.brics.string.intermediate.Variable;
import dk.brics.string.intermediate.VariableType;

public class ApplicationFieldReferenceTranslator implements FieldReferenceTranslator {
    public Variable translateFieldRef(FieldRef reference, ValueBox box, IntermediateFactory factory) {
        // handle only fields declared in application classes
        if (!reference.getField().getDeclaringClass().isApplicationClass()) {
            return null;
        }

        VariableType type = factory.fromSootType(reference.getType());
        Variable var = factory.createVariable(type);
        Field field = factory.getField(reference.getField());
        factory.addStatement(new FieldReference(field, var));
        
        return var;
    }
    
    public boolean translateFieldAssignment(FieldRef leftSide, Variable rightSide, IntermediateFactory factory) {
        if (!leftSide.getField().getDeclaringClass().isApplicationClass()) {
            return false;
        }
        
        factory.addStatement(new FieldAssignment(factory.getField(leftSide.getField()), rightSide));
        
        return true;
    }
}
