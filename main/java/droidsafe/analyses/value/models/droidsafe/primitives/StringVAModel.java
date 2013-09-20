package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.PrimVAModel;

public class StringVAModel extends PrimVAModel {

    String value;

    public StringVAModel(String value) {
        this.value = value;
    }

    public String __ds__toString() {
        return "<va-modeled-string: {value: " + value + "}>";
    }
}
