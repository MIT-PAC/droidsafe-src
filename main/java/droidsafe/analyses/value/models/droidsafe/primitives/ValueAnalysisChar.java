package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

public class ValueAnalysisChar extends ValueAnalysisModeledObject {

    char value;

    public ValueAnalysisChar() {
        this.invalidated = false;
    }

    public ValueAnalysisChar(char valueParam) {
        this.value = valueParam;
    }
}
