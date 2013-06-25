package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

public class ValueAnalysisFloat extends ValueAnalysisModeledObject {

    float value;

    public ValueAnalysisFloat() {
        this.invalidated = true;
    }

    public ValueAnalysisFloat(float valueParam) {
        this.value = valueParam;
    }
}
