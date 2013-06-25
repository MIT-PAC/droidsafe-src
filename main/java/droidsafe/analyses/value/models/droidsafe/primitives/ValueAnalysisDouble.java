package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

public class ValueAnalysisDouble extends ValueAnalysisModeledObject {

    double value;

    public ValueAnalysisDouble() {
        this.invalidated = true;
    }

    public ValueAnalysisDouble(double valueParam) {
        this.value = valueParam;
    }
}
