package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

public class ValueAnalysisByte extends ValueAnalysisPrimitive {

    byte value;

    public ValueAnalysisByte() {
        this.__ds__invalidated = false;
    }

    public ValueAnalysisByte(byte valueParam) {
        this.value = valueParam;
    }
}
