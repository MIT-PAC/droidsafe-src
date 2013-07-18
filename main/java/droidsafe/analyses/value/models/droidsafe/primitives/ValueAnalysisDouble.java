package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

public class ValueAnalysisDouble extends ValueAnalysisPrimitive {

    double value;

    public ValueAnalysisDouble() {
        this.__ds__invalidated = true;
    }

    public ValueAnalysisDouble(double valueParam) {
        this.value = valueParam;
    }
}
