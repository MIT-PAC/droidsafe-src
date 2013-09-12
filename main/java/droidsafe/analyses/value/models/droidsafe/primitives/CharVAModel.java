package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.PrimVAModel;

public class CharVAModel extends PrimVAModel {

    char value;

    public CharVAModel(char value) {
        this.value = value;
    }

    public String __ds__toString() {
        return "<va-modeled-char: {value: " + value + "}>";
    }
}
