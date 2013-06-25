package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

public class ValueAnalysisInt extends ValueAnalysisModeledObject {

    int value;

    public ValueAnalysisInt() {
        this.invalidated = false;
    }

    public ValueAnalysisInt(int valueParam) {
        this.value = valueParam;
    }
}
