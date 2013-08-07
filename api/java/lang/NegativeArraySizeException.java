package java.lang;

// Droidsafe Imports
import droidsafe.annotations.*;





public class NegativeArraySizeException extends RuntimeException {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.356 -0400", hash_original_method = "D33CED1C2CC51E1A27A91F713183A870", hash_generated_method = "AAB9A11ADDB53662AAA6D6FF71C8894C")
    public  NegativeArraySizeException() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.356 -0400", hash_original_method = "8AAF2E9F34B5796377EDFC62134DFEB6", hash_generated_method = "4C405883FAC3ED31CDDEA2D11953EAE0")
    public  NegativeArraySizeException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.356 -0400", hash_original_field = "F60F45D6F3B06578BA8D5007B337988F", hash_generated_field = "E540D2C0CDF6C49ADF14B99D1098B08E")

    private static final long serialVersionUID = -8960118058596991861L;
}

