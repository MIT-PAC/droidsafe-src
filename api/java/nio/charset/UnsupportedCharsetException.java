package java.nio.charset;

// Droidsafe Imports
import droidsafe.annotations.*;





public class UnsupportedCharsetException extends IllegalArgumentException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.705 -0400", hash_original_field = "2016A4FE38556B6598C5FEB99F123C01", hash_generated_field = "294F0480F54B014FA8831418027DC6AA")

    private String charsetName;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.706 -0400", hash_original_method = "EF2B407E9854D147BA5248D252ABFDC1", hash_generated_method = "A83122F7BD490B03278E1192423B7D70")
    public  UnsupportedCharsetException(String charsetName) {
        super((charsetName != null) ? charsetName : "null");
        this.charsetName = charsetName;
        // ---------- Original Method ----------
        //this.charsetName = charsetName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.706 -0400", hash_original_method = "62D3F36CA78A6EC4185A2D1A05C169E6", hash_generated_method = "656B553631C2351E8647BFA037B41A74")
    public String getCharsetName() {
String var51D38528197C73FD97B2AD0E5CC1E13F_2110383639 =         charsetName;
        var51D38528197C73FD97B2AD0E5CC1E13F_2110383639.addTaint(taint);
        return var51D38528197C73FD97B2AD0E5CC1E13F_2110383639;
        // ---------- Original Method ----------
        //return charsetName;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.706 -0400", hash_original_field = "306060042C2FA3BA3344B7D103BE0E18", hash_generated_field = "355A963C969FC3135246825E305C339D")

    private static final long serialVersionUID = 1490765524727386367L;
}

