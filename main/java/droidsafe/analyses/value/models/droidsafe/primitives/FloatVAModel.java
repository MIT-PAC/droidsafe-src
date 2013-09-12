package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.PrimVAModel;

public class FloatVAModel extends PrimVAModel {

    float value;

    public FloatVAModel(float value) {
        this.value = value;
    }
    public String __ds__toString() {
        return "<va-modeled-float: {value: " + value + "}>";
    }
}
