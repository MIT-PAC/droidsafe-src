package droidsafe.analyses.value.models.droidsafe.primitives;

import droidsafe.analyses.value.PrimVAModel;

public class ByteVAModel extends PrimVAModel {

    byte value;

    public ByteVAModel(byte value) {
        this.value = value;
    }
 
    public String __ds__toString() {
        return "<va-modeled-byte: {value: " + value + "}>";
    }


}
