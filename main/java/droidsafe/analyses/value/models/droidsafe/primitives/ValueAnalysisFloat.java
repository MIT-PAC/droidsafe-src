package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

public class ValueAnalysisFloat extends ValueAnalysisModeledPrimitive {

    float value;

    public ValueAnalysisFloat() {
        this.__ds__invalidated = true;
    }

    public ValueAnalysisFloat(float valueParam) {
        this.value = valueParam;
    }
}
