package dk.brics.string.java;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import soot.ValueBox;
import soot.jimple.FieldRef;
import dk.brics.string.external.FieldResolution;
import dk.brics.string.external.Resolver;
import dk.brics.string.intermediate.StringInit;
import dk.brics.string.intermediate.Variable;
import dk.brics.string.intermediate.VariableType;

public class ResolverFieldReferenceTranslator implements FieldReferenceTranslator {
    private List<Resolver> resolvers = new LinkedList<Resolver>();
    
    public ResolverFieldReferenceTranslator(Collection<? extends Resolver> resolvers) {
        this.resolvers.addAll(resolvers);
    }
    
    public boolean translateFieldAssignment(FieldRef leftSide, Variable rightSide, IntermediateFactory factory) {
        return false;
    }
    public Variable translateFieldRef(FieldRef reference, ValueBox box, IntermediateFactory factory) {
        // only non-application fields may be resolved
        if (reference.getField().getDeclaringClass().isApplicationClass())
            return null;
        
        // only immutable fields can be resolved
        if (factory.fromSootType(reference.getField().getType()) != VariableType.STRING)
            return null;
        
        for (Resolver resolver : resolvers) {
            FieldResolution resolution = resolver.resolveField(reference);
            if (resolution == null)
                continue;
            
            Variable result = factory.createVariable(VariableType.STRING);
            factory.addStatement(new StringInit(result, resolution.getAutomaton()));
            return result;
        }
        return null;
    }
}
