package javax.xml.transform;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class TransformerFactoryConfigurationError extends Error {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.920 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "70BD42A5533D521458BB067703B0D3E8")

    private Exception exception;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.921 -0400", hash_original_method = "B5236C2B50936EBB19164E0470E786D0", hash_generated_method = "4FA1D40EBB8466CB6249FD2FE24764E4")
    public  TransformerFactoryConfigurationError() {
        this.exception = null;
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.921 -0400", hash_original_method = "A106770FA0B10D144DFE1AE3A1F6A82D", hash_generated_method = "3F380E70518C6138A017B769855F4F92")
    public  TransformerFactoryConfigurationError(String msg) {
        super(msg);
        this.exception = null;
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.921 -0400", hash_original_method = "F49E93B07FF8266081C24B5E6A3F5360", hash_generated_method = "3A733ED36B8D74FA3EFA3777A0AFBF3A")
    public  TransformerFactoryConfigurationError(Exception e) {
        super(e.toString());
        this.exception = e;
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.922 -0400", hash_original_method = "1312292D5A501DBED2FE9598863C16EA", hash_generated_method = "60F950D5D4DD7B2457277A80A1BA125A")
    public  TransformerFactoryConfigurationError(Exception e, String msg) {
        super(msg);
        this.exception = e;
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.935 -0400", hash_original_method = "87F4B9D5A318C1C88AAC3D2F1A6663D7", hash_generated_method = "F037D998ACC7682E7A7E50A6D722A7B2")
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1066576494 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_782083252 = null; //Variable for return #2
        String message;
        message = super.getMessage();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1066576494 = exception.getMessage();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_782083252 = message;
        String varA7E53CE21691AB073D9660D615818899_1598269072; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1598269072 = varB4EAC82CA7396A68D541C85D26508E83_1066576494;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1598269072 = varB4EAC82CA7396A68D541C85D26508E83_782083252;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1598269072.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1598269072;
        // ---------- Original Method ----------
        //String message = super.getMessage();
        //if ((message == null) && (exception != null)) {
            //return exception.getMessage();
        //}
        //return message;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.936 -0400", hash_original_method = "DEACD8BC5F5C015493740DB375DC8E7E", hash_generated_method = "F6BC552B382DAF68A980D80C284F92EA")
    public Exception getException() {
        Exception varB4EAC82CA7396A68D541C85D26508E83_25516566 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_25516566 = exception;
        varB4EAC82CA7396A68D541C85D26508E83_25516566.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_25516566;
        // ---------- Original Method ----------
        //return exception;
    }

    
}

