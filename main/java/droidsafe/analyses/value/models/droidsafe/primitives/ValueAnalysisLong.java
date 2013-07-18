package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

public class ValueAnalysisLong extends ValueAnalysisModeledPrimitive {

    long value;

    public ValueAnalysisLong() {
        this.__ds__invalidated = true;
    }

    public ValueAnalysisLong(long valueParam) {
        this.value = valueParam;
    }
}
