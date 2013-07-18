package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

public class ValueAnalysisShort extends ValueAnalysisModeledPrimitive {

    short value;

    public ValueAnalysisShort() {
        this.__ds__invalidated = true;
    }

    public ValueAnalysisShort(short valueParam) {
        this.value = valueParam;
    }
}
