package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

public class ValueAnalysisChar extends ValueAnalysisPrimitive {

    char value;

    public ValueAnalysisChar() {
        this.__ds__invalidated = false;
    }

    public ValueAnalysisChar(char valueParam) {
        this.value = valueParam;
    }
}
