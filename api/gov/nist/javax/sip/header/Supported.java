package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.*;

public class Supported extends SIPHeader implements SupportedHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.563 -0400", hash_original_field = "7215DE10AF39CFD62967156F13524AEE", hash_generated_field = "EA9E843EF6C95A0999AD8B5523E0E7B3")

    protected String optionTag;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.564 -0400", hash_original_method = "5230DF363A4CA66C4A13E103BCE72C7C", hash_generated_method = "3C8D784CD22FBCF471BE0C5853D91DD1")
    public  Supported() {
        super(SIPHeaderNames.SUPPORTED);
        optionTag = null;
        // ---------- Original Method ----------
        //optionTag = null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.564 -0400", hash_original_method = "22E9310B7938D206E4E2944ECFF36AB1", hash_generated_method = "ECAB293A06845B6630EB2733D29358A7")
    public  Supported(String option_tag) {
        super(SIPHeaderNames.SUPPORTED);
        optionTag = option_tag;
        // ---------- Original Method ----------
        //optionTag = option_tag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.565 -0400", hash_original_method = "6B2B571AE4F377CE25FA9B4608683BF5", hash_generated_method = "1D5C294B9A80E8184BC6D81668479C2B")
    public String encode() {
        String retval = headerName + COLON;
        if(optionTag != null)        
        retval += SP + optionTag;
        retval += NEWLINE;
String varF9E19AD6135C970F387F77C6F3DE4477_1794446787 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1794446787.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1794446787;
        // ---------- Original Method ----------
        //String retval = headerName + COLON;
        //if (optionTag != null)
            //retval += SP + optionTag;
        //retval += NEWLINE;
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.565 -0400", hash_original_method = "CAE88651ED9FF39412B77E9D96C77B38", hash_generated_method = "0A901259D210FEE52FC29BA4BADCC920")
    public String encodeBody() {
String var56B3DB389127F26D443FD310DF817C38_899183754 =         optionTag != null ? optionTag : "";
        var56B3DB389127F26D443FD310DF817C38_899183754.addTaint(taint);
        return var56B3DB389127F26D443FD310DF817C38_899183754;
        // ---------- Original Method ----------
        //return optionTag != null ? optionTag : "";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.566 -0400", hash_original_method = "0B1E7641398A7F9C5ED01BA7A61C72A2", hash_generated_method = "C12BF39DADC2372CC6BE7886B60BEF5C")
    public void setOptionTag(String optionTag) throws ParseException {
        if(optionTag == null)        
        {
        NullPointerException var980042347821B45924426B3F23ECF892_19301617 = new NullPointerException(
                "JAIN-SIP Exception, Supported, "
                    + "setOptionTag(), the optionTag parameter is null");
        var980042347821B45924426B3F23ECF892_19301617.addTaint(taint);
        throw var980042347821B45924426B3F23ECF892_19301617;
        }
        this.optionTag = optionTag;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, Supported, "
                    //+ "setOptionTag(), the optionTag parameter is null");
        //this.optionTag = optionTag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.566 -0400", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "56E1186AFE08B594BA9F1FF4943F1C8C")
    public String getOptionTag() {
String var05FAD6E650FDF64778D62F7CDA67F749_536162705 =         optionTag;
        var05FAD6E650FDF64778D62F7CDA67F749_536162705.addTaint(taint);
        return var05FAD6E650FDF64778D62F7CDA67F749_536162705;
        // ---------- Original Method ----------
        //return optionTag;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.566 -0400", hash_original_field = "88CC963820AD961ACCC8118304ED55D8", hash_generated_field = "D3D7272B6F01E32B817268E9A8B320BF")

    private static final long serialVersionUID = -7679667592702854542L;
}

