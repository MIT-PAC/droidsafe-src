package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.PrimVAModel;

public class ShortVAModel extends PrimVAModel {

    short value;

    public ShortVAModel(short value) {
        this.value = value;
    }

    public String __ds__toString() {
        return "<va-modeled-short: {value: " + value + "}>";
    }
}
