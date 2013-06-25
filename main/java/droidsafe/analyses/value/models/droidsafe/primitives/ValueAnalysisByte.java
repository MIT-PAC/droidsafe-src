package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

public class ValueAnalysisByte extends ValueAnalysisModeledObject {

    byte value;

    public ValueAnalysisByte() {
        this.invalidated = false;
    }

    public ValueAnalysisByte(byte valueParam) {
        this.value = valueParam;
    }
}
