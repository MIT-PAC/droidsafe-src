package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;

public class Unsupported extends SIPHeader implements javax.sip.header.UnsupportedHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.727 -0400", hash_original_field = "7215DE10AF39CFD62967156F13524AEE", hash_generated_field = "EA9E843EF6C95A0999AD8B5523E0E7B3")

    protected String optionTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.727 -0400", hash_original_method = "7F4BD1C3AF5762ECCF124F3A56ADDC67", hash_generated_method = "20CE9BE220E1B76B99762452ADA57ECB")
    public  Unsupported() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.727 -0400", hash_original_method = "91BBA837F044D0A0A4874364E40F6125", hash_generated_method = "2C85D3B90F3F77053ABDF107887B68AA")
    public  Unsupported(String ot) {
        super(NAME);
        optionTag = ot;
        // ---------- Original Method ----------
        //optionTag = ot;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.728 -0400", hash_original_method = "9C711BE19A8C0E0A7CB116A3F753C6F0", hash_generated_method = "D8DE5973FD04B077DC97DCEF23028172")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1993208569 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1993208569 = optionTag;
        varB4EAC82CA7396A68D541C85D26508E83_1993208569.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1993208569;
        // ---------- Original Method ----------
        //return optionTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.729 -0400", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "5B6AEDB343EC38B8B08775147D93273A")
    public String getOptionTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1111187266 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1111187266 = optionTag;
        varB4EAC82CA7396A68D541C85D26508E83_1111187266.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1111187266;
        // ---------- Original Method ----------
        //return optionTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.729 -0400", hash_original_method = "3B18B091D01592A1C9601DEA63572A7E", hash_generated_method = "96990F04B1B76560F6A534E83E476B8F")
    public void setOptionTag(String o) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " Unsupported, setOptionTag(), The option tag parameter is null");
        optionTag = o;
        // ---------- Original Method ----------
        //if (o == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ " Unsupported, setOptionTag(), The option tag parameter is null");
        //optionTag = o;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.729 -0400", hash_original_field = "729B4B74845ACBCF4C5028ED87BE3471", hash_generated_field = "4D2A15B293A01E56DA05C71B2480D6D7")

    private static long serialVersionUID = -2479414149440236199L;
}

