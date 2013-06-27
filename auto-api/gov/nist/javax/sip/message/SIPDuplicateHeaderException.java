package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class SIPDuplicateHeaderException extends ParseException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.792 -0400", hash_original_field = "801C5528BD97282F366DB1FF3EE2BF49", hash_generated_field = "DEA203A7A81C763AC07A6499FA517016")

    protected SIPHeader sipHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.793 -0400", hash_original_field = "6637F26A1693081920A4A68C1290C2FB", hash_generated_field = "86237427033BC6809F24E6EB9253E570")

    protected SIPMessage sipMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.793 -0400", hash_original_method = "C7110F542E7C86523593AC1F47E9C6EF", hash_generated_method = "CBF45538ABCFE5E246A21B260CF0E645")
    public  SIPDuplicateHeaderException(String msg) {
        super(msg, 0);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.793 -0400", hash_original_method = "33B1FEC769A0D2DAFD3ECF3DA486EB50", hash_generated_method = "E858471816F2508746AE1EA1C894F8D5")
    public SIPMessage getSIPMessage() {
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_1072584859 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1072584859 = sipMessage;
        varB4EAC82CA7396A68D541C85D26508E83_1072584859.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1072584859;
        // ---------- Original Method ----------
        //return sipMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.802 -0400", hash_original_method = "41260058ED6F5F8ADF876F4D655653A8", hash_generated_method = "A255F6FDFBCCF40D20E6B86E58C8EC40")
    public SIPHeader getSIPHeader() {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1766334800 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1766334800 = sipHeader;
        varB4EAC82CA7396A68D541C85D26508E83_1766334800.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1766334800;
        // ---------- Original Method ----------
        //return sipHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.805 -0400", hash_original_method = "E64CE5D80349BACB9139631838659CEE", hash_generated_method = "54A8AC61F5E0FDF2C9E9E70D47DD6023")
    public void setSIPHeader(SIPHeader sipHeader) {
        this.sipHeader = sipHeader;
        // ---------- Original Method ----------
        //this.sipHeader = sipHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.806 -0400", hash_original_method = "04933E08E06609AAF868A53B1081ADDB", hash_generated_method = "F27364F03913DE15CDB0E9D8906CEC34")
    public void setSIPMessage(SIPMessage sipMessage) {
        this.sipMessage = sipMessage;
        // ---------- Original Method ----------
        //this.sipMessage = sipMessage;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.806 -0400", hash_original_field = "06E6651D79E2B19475C2D41DF9ADA393", hash_generated_field = "30A17F2D1E5A8D1B3D39948772076DF9")

    private static long serialVersionUID = 8241107266407879291L;
}

