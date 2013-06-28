package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class MediaRange extends SIPObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.789 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "07EA10A7183817BDD507DF1E4B45BF61")

    protected String type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.789 -0400", hash_original_field = "2E282B0D23D6EC55185CAEB87B41C0E0", hash_generated_field = "D2D46B7267A80714A8F9897271A241D8")

    protected String subtype;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.789 -0400", hash_original_method = "A8D138215FF2330241D1163A7469BE2F", hash_generated_method = "94D7E99B7301CFEA2E8CC360FD81F551")
    public  MediaRange() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.790 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "B58504D499E14AD53936052E62D1BCFF")
    public String getType() {
        String varB4EAC82CA7396A68D541C85D26508E83_337343283 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_337343283 = type;
        varB4EAC82CA7396A68D541C85D26508E83_337343283.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_337343283;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.790 -0400", hash_original_method = "F553636983A7698A0C67E9F36C861E72", hash_generated_method = "2DACBD4B657586FAD70CBEDB32DFA852")
    public String getSubtype() {
        String varB4EAC82CA7396A68D541C85D26508E83_1199743025 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1199743025 = subtype;
        varB4EAC82CA7396A68D541C85D26508E83_1199743025.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1199743025;
        // ---------- Original Method ----------
        //return subtype;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.791 -0400", hash_original_method = "1F9FAB648DA6511C86522C3730D40F12", hash_generated_method = "3A963E148C8DEA20E44FBC8909AF4438")
    public void setType(String t) {
        type = t;
        // ---------- Original Method ----------
        //type = t;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.791 -0400", hash_original_method = "3A0BB05139828A93AF0155E2224A9877", hash_generated_method = "8F25E54D9A9BC590C1B963D060DAD10B")
    public void setSubtype(String s) {
        subtype = s;
        // ---------- Original Method ----------
        //subtype = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.791 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "C7F45428C54F1BC1414991EBB827A07A")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1745774398 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1745774398 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1745774398.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1745774398;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.792 -0400", hash_original_method = "65E8BB72BD507B7E1F69F2EFA7F6C332", hash_generated_method = "32654A33E1AAB4FCBB9665367082BC27")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1703766435 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1703766435 = buffer.append(type)
                .append(SLASH)
                .append(subtype);
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1703766435.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1703766435;
        // ---------- Original Method ----------
        //return buffer.append(type)
                //.append(SLASH)
                //.append(subtype);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.792 -0400", hash_original_field = "28543EEEEEA7165D9CAE0C91318BC23B", hash_generated_field = "3BDB1FA41CCA61D52855E12BDAC970C8")

    private static final long serialVersionUID = -6297125815438079210L;
}

