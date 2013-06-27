package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.*;

public class Expires extends SIPHeader implements javax.sip.header.ExpiresHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.943 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "E191433B1529B42724890251971016B1")

    protected int expires;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.944 -0400", hash_original_method = "0542B72E4A4F7744BB9DEA78B33603A7", hash_generated_method = "2BE5D43F7C2297EF5B98693F09A128A4")
    public  Expires() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.944 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "FCFC36F27B9B51F5B11942B0F9A8124C")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_9711910 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_9711910 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_9711910.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_9711910;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.945 -0400", hash_original_method = "D18BC4E3774CF43CFCD5002AEFE6A6EE", hash_generated_method = "42ADB696405B809116207E52FF2CEB56")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1240791986 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1240791986 = buffer.append(expires);
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1240791986.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1240791986;
        // ---------- Original Method ----------
        //return buffer.append(expires);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.945 -0400", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "4D95DDA829B51C6288D6CA3E99DD7DB6")
    public int getExpires() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_402186822 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_402186822;
        // ---------- Original Method ----------
        //return expires;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.945 -0400", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "1F94C2B6C4EFAB2003C10C5168D24F2A")
    public void setExpires(int expires) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad argument " + expires);
        this.expires = expires;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad argument " + expires);
        //this.expires = expires;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.945 -0400", hash_original_field = "2F10AFAED544B12D512EC416C57EE12B", hash_generated_field = "53BFCEBE88DAA1CC27A27399F3FE4701")

    private static long serialVersionUID = 3134344915465784267L;
}

