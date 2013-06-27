package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class MediaRange extends SIPObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.102 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "07EA10A7183817BDD507DF1E4B45BF61")

    protected String type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.102 -0400", hash_original_field = "2E282B0D23D6EC55185CAEB87B41C0E0", hash_generated_field = "D2D46B7267A80714A8F9897271A241D8")

    protected String subtype;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.102 -0400", hash_original_method = "A8D138215FF2330241D1163A7469BE2F", hash_generated_method = "94D7E99B7301CFEA2E8CC360FD81F551")
    public  MediaRange() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.103 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "E4E05A1D15D18D03EB23DCCE8F194FA3")
    public String getType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1389572743 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1389572743 = type;
        varB4EAC82CA7396A68D541C85D26508E83_1389572743.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1389572743;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.104 -0400", hash_original_method = "F553636983A7698A0C67E9F36C861E72", hash_generated_method = "17344207A81DD12C9F4EE3BA51AE15E6")
    public String getSubtype() {
        String varB4EAC82CA7396A68D541C85D26508E83_1988011624 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1988011624 = subtype;
        varB4EAC82CA7396A68D541C85D26508E83_1988011624.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1988011624;
        // ---------- Original Method ----------
        //return subtype;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.104 -0400", hash_original_method = "1F9FAB648DA6511C86522C3730D40F12", hash_generated_method = "3A963E148C8DEA20E44FBC8909AF4438")
    public void setType(String t) {
        type = t;
        // ---------- Original Method ----------
        //type = t;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.104 -0400", hash_original_method = "3A0BB05139828A93AF0155E2224A9877", hash_generated_method = "8F25E54D9A9BC590C1B963D060DAD10B")
    public void setSubtype(String s) {
        subtype = s;
        // ---------- Original Method ----------
        //subtype = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.105 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "FD286758B3165D273997996A98F46C25")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1775472537 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1775472537 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1775472537.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1775472537;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.105 -0400", hash_original_method = "65E8BB72BD507B7E1F69F2EFA7F6C332", hash_generated_method = "023BEFCB367E9821C57747926A634416")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_575360991 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_575360991 = buffer.append(type)
                .append(SLASH)
                .append(subtype);
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_575360991.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_575360991;
        // ---------- Original Method ----------
        //return buffer.append(type)
                //.append(SLASH)
                //.append(subtype);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.105 -0400", hash_original_field = "28543EEEEEA7165D9CAE0C91318BC23B", hash_generated_field = "591204D0F462EF7B5732362E5B5BA945")

    private static long serialVersionUID = -6297125815438079210L;
}

