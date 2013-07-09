package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

public class ValueAnalysisBoolean extends ValueAnalysisModeledObject {

    boolean value;

    public ValueAnalysisBoolean() {
        this.__ds__invalidated = false;
    }

    public ValueAnalysisBoolean(boolean valueParam) {
        this.value = valueParam;
    }
}
