package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class SIPDuplicateHeaderException extends ParseException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.901 -0400", hash_original_field = "801C5528BD97282F366DB1FF3EE2BF49", hash_generated_field = "DEA203A7A81C763AC07A6499FA517016")

    protected SIPHeader sipHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.901 -0400", hash_original_field = "6637F26A1693081920A4A68C1290C2FB", hash_generated_field = "86237427033BC6809F24E6EB9253E570")

    protected SIPMessage sipMessage;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.901 -0400", hash_original_method = "C7110F542E7C86523593AC1F47E9C6EF", hash_generated_method = "CBF45538ABCFE5E246A21B260CF0E645")
    public  SIPDuplicateHeaderException(String msg) {
        super(msg, 0);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.902 -0400", hash_original_method = "33B1FEC769A0D2DAFD3ECF3DA486EB50", hash_generated_method = "3C6902239E474E8107677DB24AADF5BD")
    public SIPMessage getSIPMessage() {
SIPMessage var006DC6DF9CC2CC6E46939D16E61A6E31_847130505 =         sipMessage;
        var006DC6DF9CC2CC6E46939D16E61A6E31_847130505.addTaint(taint);
        return var006DC6DF9CC2CC6E46939D16E61A6E31_847130505;
        // ---------- Original Method ----------
        //return sipMessage;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.902 -0400", hash_original_method = "41260058ED6F5F8ADF876F4D655653A8", hash_generated_method = "954B9C0D527B7C0A525F0A25F16397A1")
    public SIPHeader getSIPHeader() {
SIPHeader varB3FE6E532AA276CD9F05CF1EACFB0558_1662998754 =         sipHeader;
        varB3FE6E532AA276CD9F05CF1EACFB0558_1662998754.addTaint(taint);
        return varB3FE6E532AA276CD9F05CF1EACFB0558_1662998754;
        // ---------- Original Method ----------
        //return sipHeader;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.903 -0400", hash_original_method = "E64CE5D80349BACB9139631838659CEE", hash_generated_method = "54A8AC61F5E0FDF2C9E9E70D47DD6023")
    public void setSIPHeader(SIPHeader sipHeader) {
        this.sipHeader = sipHeader;
        // ---------- Original Method ----------
        //this.sipHeader = sipHeader;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.903 -0400", hash_original_method = "04933E08E06609AAF868A53B1081ADDB", hash_generated_method = "F27364F03913DE15CDB0E9D8906CEC34")
    public void setSIPMessage(SIPMessage sipMessage) {
        this.sipMessage = sipMessage;
        // ---------- Original Method ----------
        //this.sipMessage = sipMessage;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.903 -0400", hash_original_field = "06E6651D79E2B19475C2D41DF9ADA393", hash_generated_field = "1CF6B23B11C04227AE0D306881B8A32C")

    private static final long serialVersionUID = 8241107266407879291L;
}

