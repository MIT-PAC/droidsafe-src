package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.*;

public class Supported extends SIPHeader implements SupportedHeader {
    protected String optionTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.427 -0400", hash_original_method = "5230DF363A4CA66C4A13E103BCE72C7C", hash_generated_method = "3C8D784CD22FBCF471BE0C5853D91DD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Supported() {
        super(SIPHeaderNames.SUPPORTED);
        optionTag = null;
        // ---------- Original Method ----------
        //optionTag = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.427 -0400", hash_original_method = "22E9310B7938D206E4E2944ECFF36AB1", hash_generated_method = "DFBA0ACFC3AA3E3FFC7670C7C5DBA71A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Supported(String option_tag) {
        super(SIPHeaderNames.SUPPORTED);
        dsTaint.addTaint(option_tag);
        // ---------- Original Method ----------
        //optionTag = option_tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.427 -0400", hash_original_method = "6B2B571AE4F377CE25FA9B4608683BF5", hash_generated_method = "A6A940E59C1D4923A02339B33FA7E15F")
    @DSModeled(DSC.SAFE)
    public String encode() {
        String retval;
        retval = headerName + COLON;
        retval += SP + optionTag;
        retval += NEWLINE;
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String retval = headerName + COLON;
        //if (optionTag != null)
            //retval += SP + optionTag;
        //retval += NEWLINE;
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.427 -0400", hash_original_method = "CAE88651ED9FF39412B77E9D96C77B38", hash_generated_method = "100CAFACE5596D29405924874F5DD883")
    @DSModeled(DSC.SAFE)
    public String encodeBody() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return optionTag != null ? optionTag : "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.427 -0400", hash_original_method = "0B1E7641398A7F9C5ED01BA7A61C72A2", hash_generated_method = "633931C6C9AB11A343C98CC42D41451D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOptionTag(String optionTag) throws ParseException {
        dsTaint.addTaint(optionTag);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, Supported, "
                    + "setOptionTag(), the optionTag parameter is null");
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, Supported, "
                    //+ "setOptionTag(), the optionTag parameter is null");
        //this.optionTag = optionTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.428 -0400", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "6F5E99C222699AC771B9EB87EA1363E2")
    @DSModeled(DSC.SAFE)
    public String getOptionTag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return optionTag;
    }

    
    private static final long serialVersionUID = -7679667592702854542L;
}

