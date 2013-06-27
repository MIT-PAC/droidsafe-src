package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class FactoryConfigurationError extends Error {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.040 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "70BD42A5533D521458BB067703B0D3E8")

    private Exception exception;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.041 -0400", hash_original_method = "6620C9D65D7B9B8AED04F1E2286BE37D", hash_generated_method = "3197EEE679B539DCD98F16DC71478ECF")
    public  FactoryConfigurationError() {
        this.exception = null;
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.042 -0400", hash_original_method = "48F1E682C4A714972A38A39D612B5275", hash_generated_method = "9DC941C2231A2F72CA371472EF0C1DF4")
    public  FactoryConfigurationError(String msg) {
        super(msg);
        this.exception = null;
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.042 -0400", hash_original_method = "50F0E936640865FC69642EB9E9B7DACD", hash_generated_method = "DECEA99A83213F9667E844B2E4FA90A5")
    public  FactoryConfigurationError(Exception e) {
        super(e.toString());
        this.exception = e;
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.042 -0400", hash_original_method = "6DA0E2DE853AFE92CEEE23D7625EA5CB", hash_generated_method = "71461E7E24A718322463F62D96ED3685")
    public  FactoryConfigurationError(Exception e, String msg) {
        super(msg);
        this.exception = e;
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.050 -0400", hash_original_method = "3CFCD04CF304E9364ADFC7DBDB377B80", hash_generated_method = "12A426ABE82F8586053439C072F8C61C")
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_718192951 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1610097651 = null; //Variable for return #2
        String message;
        message = super.getMessage ();
        {
            varB4EAC82CA7396A68D541C85D26508E83_718192951 = exception.getMessage();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1610097651 = message;
        String varA7E53CE21691AB073D9660D615818899_266886975; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_266886975 = varB4EAC82CA7396A68D541C85D26508E83_718192951;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_266886975 = varB4EAC82CA7396A68D541C85D26508E83_1610097651;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_266886975.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_266886975;
        // ---------- Original Method ----------
        //String message = super.getMessage ();
        //if (message == null && exception != null) {
            //return exception.getMessage();
        //}
        //return message;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.052 -0400", hash_original_method = "DEACD8BC5F5C015493740DB375DC8E7E", hash_generated_method = "0F92553D44BCAD1C0ECEED294557CE4A")
    public Exception getException() {
        Exception varB4EAC82CA7396A68D541C85D26508E83_1454060524 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1454060524 = exception;
        varB4EAC82CA7396A68D541C85D26508E83_1454060524.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1454060524;
        // ---------- Original Method ----------
        //return exception;
    }

    
}

