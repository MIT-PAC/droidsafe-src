package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.PrimVAModel;

public class LongVAModel extends PrimVAModel {

    long value;

    public LongVAModel(long value) {
        this.value = value;
    }

    public String __ds__toString() {
        return "<va-modeled-long: {value: " + value + "}>";
    }
}
