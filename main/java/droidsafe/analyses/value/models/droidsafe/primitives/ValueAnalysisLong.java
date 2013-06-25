package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

public class ValueAnalysisLong extends ValueAnalysisModeledObject {

    long value;

    public ValueAnalysisLong() {
        this.invalidated = true;
    }

    public ValueAnalysisLong(long valueParam) {
        this.value = valueParam;
    }
}
