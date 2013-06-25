package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

public class ValueAnalysisShort extends ValueAnalysisModeledObject {

    short value;

    public ValueAnalysisShort() {
        this.invalidated = true;
    }

    public ValueAnalysisShort(short valueParam) {
        this.value = valueParam;
    }
}
