package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UnsupportedCharsetException extends IllegalArgumentException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.059 -0400", hash_original_field = "2016A4FE38556B6598C5FEB99F123C01", hash_generated_field = "294F0480F54B014FA8831418027DC6AA")

    private String charsetName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.061 -0400", hash_original_method = "EF2B407E9854D147BA5248D252ABFDC1", hash_generated_method = "A83122F7BD490B03278E1192423B7D70")
    public  UnsupportedCharsetException(String charsetName) {
        super((charsetName != null) ? charsetName : "null");
        this.charsetName = charsetName;
        // ---------- Original Method ----------
        //this.charsetName = charsetName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.062 -0400", hash_original_method = "62D3F36CA78A6EC4185A2D1A05C169E6", hash_generated_method = "68845E0CB4F00F3CA9DDE6849BB5115D")
    public String getCharsetName() {
        String varB4EAC82CA7396A68D541C85D26508E83_119836038 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_119836038 = charsetName;
        varB4EAC82CA7396A68D541C85D26508E83_119836038.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_119836038;
        // ---------- Original Method ----------
        //return charsetName;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.062 -0400", hash_original_field = "306060042C2FA3BA3344B7D103BE0E18", hash_generated_field = "ABEA57C46303CDA4EDEB1E32B452C45A")

    private static long serialVersionUID = 1490765524727386367L;
}

