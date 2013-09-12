package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.PrimVAModel;

public class DoubleVAModel extends PrimVAModel {

    double value;

    public DoubleVAModel(double value) {
        this.value = value;
    }

    public String __ds__toString() {
        return "<va-modeled-double: {value: " + value + "}>";
    }
}
