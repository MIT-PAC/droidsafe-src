package java.nio.charset;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class UnsupportedCharsetException extends IllegalArgumentException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.041 -0400", hash_original_field = "2016A4FE38556B6598C5FEB99F123C01", hash_generated_field = "294F0480F54B014FA8831418027DC6AA")

    private String charsetName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.041 -0400", hash_original_method = "EF2B407E9854D147BA5248D252ABFDC1", hash_generated_method = "A83122F7BD490B03278E1192423B7D70")
    public  UnsupportedCharsetException(String charsetName) {
        super((charsetName != null) ? charsetName : "null");
        this.charsetName = charsetName;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.042 -0400", hash_original_method = "62D3F36CA78A6EC4185A2D1A05C169E6", hash_generated_method = "179189D055504C1CB7B58FC299FAAC95")
    public String getCharsetName() {
        String varB4EAC82CA7396A68D541C85D26508E83_655047219 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_655047219 = charsetName;
        varB4EAC82CA7396A68D541C85D26508E83_655047219.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_655047219;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.042 -0400", hash_original_field = "306060042C2FA3BA3344B7D103BE0E18", hash_generated_field = "355A963C969FC3135246825E305C339D")

    private static final long serialVersionUID = 1490765524727386367L;
}

