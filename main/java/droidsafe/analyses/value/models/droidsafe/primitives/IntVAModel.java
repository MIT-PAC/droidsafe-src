package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.PrimVAModel;

public class IntVAModel extends PrimVAModel {

    public int value;

    public IntVAModel(int value) {
        this.value = value;
    }

    public String __ds__toString() {
        return "<va-modeled-int: {value: " + value + "}>";
    }
}
