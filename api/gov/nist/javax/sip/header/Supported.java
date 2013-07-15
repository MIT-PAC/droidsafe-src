package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.*;

public class Supported extends SIPHeader implements SupportedHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.493 -0400", hash_original_field = "7215DE10AF39CFD62967156F13524AEE", hash_generated_field = "EA9E843EF6C95A0999AD8B5523E0E7B3")

    protected String optionTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.494 -0400", hash_original_method = "5230DF363A4CA66C4A13E103BCE72C7C", hash_generated_method = "3C8D784CD22FBCF471BE0C5853D91DD1")
    public  Supported() {
        super(SIPHeaderNames.SUPPORTED);
        optionTag = null;
        // ---------- Original Method ----------
        //optionTag = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.495 -0400", hash_original_method = "22E9310B7938D206E4E2944ECFF36AB1", hash_generated_method = "ECAB293A06845B6630EB2733D29358A7")
    public  Supported(String option_tag) {
        super(SIPHeaderNames.SUPPORTED);
        optionTag = option_tag;
        // ---------- Original Method ----------
        //optionTag = option_tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.495 -0400", hash_original_method = "6B2B571AE4F377CE25FA9B4608683BF5", hash_generated_method = "C7B48742A2789BE24F65BE841035E394")
    public String encode() {
        String retval = headerName + COLON;
    if(optionTag != null)        
        retval += SP + optionTag;
        retval += NEWLINE;
String varF9E19AD6135C970F387F77C6F3DE4477_960577998 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_960577998.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_960577998;
        // ---------- Original Method ----------
        //String retval = headerName + COLON;
        //if (optionTag != null)
            //retval += SP + optionTag;
        //retval += NEWLINE;
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.496 -0400", hash_original_method = "CAE88651ED9FF39412B77E9D96C77B38", hash_generated_method = "AC6AEEBB5381499B9044245CB7E51E00")
    public String encodeBody() {
String var56B3DB389127F26D443FD310DF817C38_1049467969 =         optionTag != null ? optionTag : "";
        var56B3DB389127F26D443FD310DF817C38_1049467969.addTaint(taint);
        return var56B3DB389127F26D443FD310DF817C38_1049467969;
        // ---------- Original Method ----------
        //return optionTag != null ? optionTag : "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.496 -0400", hash_original_method = "0B1E7641398A7F9C5ED01BA7A61C72A2", hash_generated_method = "DB41C1468F69166539484D240FF39C6E")
    public void setOptionTag(String optionTag) throws ParseException {
    if(optionTag == null)        
        {
        NullPointerException var980042347821B45924426B3F23ECF892_383384466 = new NullPointerException(
                "JAIN-SIP Exception, Supported, "
                    + "setOptionTag(), the optionTag parameter is null");
        var980042347821B45924426B3F23ECF892_383384466.addTaint(taint);
        throw var980042347821B45924426B3F23ECF892_383384466;
        }
        this.optionTag = optionTag;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, Supported, "
                    //+ "setOptionTag(), the optionTag parameter is null");
        //this.optionTag = optionTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.496 -0400", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "A1D9E5214CD5865DFC1527F6BF2D5FFF")
    public String getOptionTag() {
String var05FAD6E650FDF64778D62F7CDA67F749_918904999 =         optionTag;
        var05FAD6E650FDF64778D62F7CDA67F749_918904999.addTaint(taint);
        return var05FAD6E650FDF64778D62F7CDA67F749_918904999;
        // ---------- Original Method ----------
        //return optionTag;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.496 -0400", hash_original_field = "88CC963820AD961ACCC8118304ED55D8", hash_generated_field = "D3D7272B6F01E32B817268E9A8B320BF")

    private static final long serialVersionUID = -7679667592702854542L;
}

