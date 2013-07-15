package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class SIPDuplicateHeaderException extends ParseException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.751 -0400", hash_original_field = "801C5528BD97282F366DB1FF3EE2BF49", hash_generated_field = "DEA203A7A81C763AC07A6499FA517016")

    protected SIPHeader sipHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.751 -0400", hash_original_field = "6637F26A1693081920A4A68C1290C2FB", hash_generated_field = "86237427033BC6809F24E6EB9253E570")

    protected SIPMessage sipMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.752 -0400", hash_original_method = "C7110F542E7C86523593AC1F47E9C6EF", hash_generated_method = "CBF45538ABCFE5E246A21B260CF0E645")
    public  SIPDuplicateHeaderException(String msg) {
        super(msg, 0);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.752 -0400", hash_original_method = "33B1FEC769A0D2DAFD3ECF3DA486EB50", hash_generated_method = "FFCEBE49D80EEFC818268ECD3FD448BE")
    public SIPMessage getSIPMessage() {
SIPMessage var006DC6DF9CC2CC6E46939D16E61A6E31_1729086306 =         sipMessage;
        var006DC6DF9CC2CC6E46939D16E61A6E31_1729086306.addTaint(taint);
        return var006DC6DF9CC2CC6E46939D16E61A6E31_1729086306;
        // ---------- Original Method ----------
        //return sipMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.752 -0400", hash_original_method = "41260058ED6F5F8ADF876F4D655653A8", hash_generated_method = "A313C8BA4F9FD8CA71593B42A40F6C4D")
    public SIPHeader getSIPHeader() {
SIPHeader varB3FE6E532AA276CD9F05CF1EACFB0558_126851899 =         sipHeader;
        varB3FE6E532AA276CD9F05CF1EACFB0558_126851899.addTaint(taint);
        return varB3FE6E532AA276CD9F05CF1EACFB0558_126851899;
        // ---------- Original Method ----------
        //return sipHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.753 -0400", hash_original_method = "E64CE5D80349BACB9139631838659CEE", hash_generated_method = "54A8AC61F5E0FDF2C9E9E70D47DD6023")
    public void setSIPHeader(SIPHeader sipHeader) {
        this.sipHeader = sipHeader;
        // ---------- Original Method ----------
        //this.sipHeader = sipHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.753 -0400", hash_original_method = "04933E08E06609AAF868A53B1081ADDB", hash_generated_method = "F27364F03913DE15CDB0E9D8906CEC34")
    public void setSIPMessage(SIPMessage sipMessage) {
        this.sipMessage = sipMessage;
        // ---------- Original Method ----------
        //this.sipMessage = sipMessage;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.753 -0400", hash_original_field = "06E6651D79E2B19475C2D41DF9ADA393", hash_generated_field = "1CF6B23B11C04227AE0D306881B8A32C")

    private static final long serialVersionUID = 8241107266407879291L;
}

