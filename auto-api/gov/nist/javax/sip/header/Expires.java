package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.*;

public class Expires extends SIPHeader implements javax.sip.header.ExpiresHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.961 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "E191433B1529B42724890251971016B1")

    protected int expires;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.961 -0400", hash_original_method = "0542B72E4A4F7744BB9DEA78B33603A7", hash_generated_method = "2BE5D43F7C2297EF5B98693F09A128A4")
    public  Expires() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.962 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "59578D87DBCD5E1CF506A4EFF0DD3CA0")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1185846342 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1185846342 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1185846342.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1185846342;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.962 -0400", hash_original_method = "D18BC4E3774CF43CFCD5002AEFE6A6EE", hash_generated_method = "813952505CCA81D858D9DC4C8A4199CC")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_683412261 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_683412261 = buffer.append(expires);
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_683412261.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_683412261;
        // ---------- Original Method ----------
        //return buffer.append(expires);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.963 -0400", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "5CF517AFDE6D393AE2C68DFCB4104863")
    public int getExpires() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1156396695 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1156396695;
        // ---------- Original Method ----------
        //return expires;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.963 -0400", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "1F94C2B6C4EFAB2003C10C5168D24F2A")
    public void setExpires(int expires) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad argument " + expires);
        this.expires = expires;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad argument " + expires);
        //this.expires = expires;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.963 -0400", hash_original_field = "2F10AFAED544B12D512EC416C57EE12B", hash_generated_field = "53BFCEBE88DAA1CC27A27399F3FE4701")

    private static long serialVersionUID = 3134344915465784267L;
}

