package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class IllegalCharsetNameException extends IllegalArgumentException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.655 -0400", hash_original_field = "2016A4FE38556B6598C5FEB99F123C01", hash_generated_field = "294F0480F54B014FA8831418027DC6AA")

    private String charsetName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.655 -0400", hash_original_method = "363E701FA2AE5454AC2A0E287832EEC6", hash_generated_method = "BE871CB47977F4E2161BE7EB36CE861E")
    public  IllegalCharsetNameException(String charsetName) {
        super((charsetName != null) ? charsetName : "null");
        this.charsetName = charsetName;
        // ---------- Original Method ----------
        //this.charsetName = charsetName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.656 -0400", hash_original_method = "62D3F36CA78A6EC4185A2D1A05C169E6", hash_generated_method = "B39D181DA4354F103E04C0FC0DD7B941")
    public String getCharsetName() {
String var51D38528197C73FD97B2AD0E5CC1E13F_259724574 =         charsetName;
        var51D38528197C73FD97B2AD0E5CC1E13F_259724574.addTaint(taint);
        return var51D38528197C73FD97B2AD0E5CC1E13F_259724574;
        // ---------- Original Method ----------
        //return charsetName;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.656 -0400", hash_original_field = "A0EFB0ED18D9D9E1373041665F58419A", hash_generated_field = "410F92043C1AB694FD9D990E16248912")

    private static final long serialVersionUID = 1457525358470002989L;
}

