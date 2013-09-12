package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.PrimVAModel;

public class BooleanVAModel extends PrimVAModel {

    boolean value;

    public BooleanVAModel(boolean value) {
        this.value = value;
    }

    public String __ds__toString() {
        return "<va-modeled-boolean: {value: " + value + "}>";
    }
}
