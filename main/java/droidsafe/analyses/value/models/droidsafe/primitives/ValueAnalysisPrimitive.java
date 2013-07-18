package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

public class ValueAnalysisPrimitive extends ValueAnalysisModeledObject {

    boolean value;

    public ValueAnalysisPrimitive() {
        this.__ds__invalidated = false;
    }

    @Override
    public String toString(){
        return this.__ds__toString();
    }
}
