package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

public class ValueAnalysisInt extends ValueAnalysisModeledObject {

    int value;

    public ValueAnalysisInt() {
        this.__ds__invalidated = false;
    }

    public ValueAnalysisInt(int valueParam) {
        this.value = valueParam;
    }

    @Override
    public int hashCode() {
      return this.value;
    }

    @Override
    public boolean equals(Object obj) {
       if (obj == this) {
           return true;
                        }
       if (obj == null || obj.getClass() != this.getClass())
           return false;
      
       ValueAnalysisInt valueAnalysisInt = (ValueAnalysisInt)obj;
       return valueAnalysisInt.value == this.value;
    }
}
