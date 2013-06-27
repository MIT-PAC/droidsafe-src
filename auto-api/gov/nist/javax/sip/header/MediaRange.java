package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class MediaRange extends SIPObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.076 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "07EA10A7183817BDD507DF1E4B45BF61")

    protected String type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.076 -0400", hash_original_field = "2E282B0D23D6EC55185CAEB87B41C0E0", hash_generated_field = "D2D46B7267A80714A8F9897271A241D8")

    protected String subtype;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.082 -0400", hash_original_method = "A8D138215FF2330241D1163A7469BE2F", hash_generated_method = "94D7E99B7301CFEA2E8CC360FD81F551")
    public  MediaRange() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.082 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "F1C66565AF23AF19053C2C9060E0CFF1")
    public String getType() {
        String varB4EAC82CA7396A68D541C85D26508E83_697750890 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_697750890 = type;
        varB4EAC82CA7396A68D541C85D26508E83_697750890.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_697750890;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.083 -0400", hash_original_method = "F553636983A7698A0C67E9F36C861E72", hash_generated_method = "96235589A4CE89C717DE3EFA54C9E0D7")
    public String getSubtype() {
        String varB4EAC82CA7396A68D541C85D26508E83_324894855 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_324894855 = subtype;
        varB4EAC82CA7396A68D541C85D26508E83_324894855.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_324894855;
        // ---------- Original Method ----------
        //return subtype;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.083 -0400", hash_original_method = "1F9FAB648DA6511C86522C3730D40F12", hash_generated_method = "3A963E148C8DEA20E44FBC8909AF4438")
    public void setType(String t) {
        type = t;
        // ---------- Original Method ----------
        //type = t;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.083 -0400", hash_original_method = "3A0BB05139828A93AF0155E2224A9877", hash_generated_method = "8F25E54D9A9BC590C1B963D060DAD10B")
    public void setSubtype(String s) {
        subtype = s;
        // ---------- Original Method ----------
        //subtype = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.089 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "880F0762D361C994E4CFCA886D2E8FD7")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_452963015 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_452963015 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_452963015.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_452963015;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.090 -0400", hash_original_method = "65E8BB72BD507B7E1F69F2EFA7F6C332", hash_generated_method = "2E77F2197F5109FF14F17697D06CE3D9")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_322625492 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_322625492 = buffer.append(type)
                .append(SLASH)
                .append(subtype);
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_322625492.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_322625492;
        // ---------- Original Method ----------
        //return buffer.append(type)
                //.append(SLASH)
                //.append(subtype);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.090 -0400", hash_original_field = "28543EEEEEA7165D9CAE0C91318BC23B", hash_generated_field = "591204D0F462EF7B5732362E5B5BA945")

    private static long serialVersionUID = -6297125815438079210L;
}

