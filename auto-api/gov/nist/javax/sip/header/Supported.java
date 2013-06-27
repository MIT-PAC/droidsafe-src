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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.806 -0400", hash_original_field = "7215DE10AF39CFD62967156F13524AEE", hash_generated_field = "EA9E843EF6C95A0999AD8B5523E0E7B3")

    protected String optionTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.808 -0400", hash_original_method = "5230DF363A4CA66C4A13E103BCE72C7C", hash_generated_method = "3C8D784CD22FBCF471BE0C5853D91DD1")
    public  Supported() {
        super(SIPHeaderNames.SUPPORTED);
        optionTag = null;
        // ---------- Original Method ----------
        //optionTag = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.808 -0400", hash_original_method = "22E9310B7938D206E4E2944ECFF36AB1", hash_generated_method = "ECAB293A06845B6630EB2733D29358A7")
    public  Supported(String option_tag) {
        super(SIPHeaderNames.SUPPORTED);
        optionTag = option_tag;
        // ---------- Original Method ----------
        //optionTag = option_tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.809 -0400", hash_original_method = "6B2B571AE4F377CE25FA9B4608683BF5", hash_generated_method = "778A1C153FFABE47B582F20AE4CBEF6E")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_12073812 = null; //Variable for return #1
        String retval;
        retval = headerName + COLON;
        retval += SP + optionTag;
        retval += NEWLINE;
        varB4EAC82CA7396A68D541C85D26508E83_12073812 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_12073812.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_12073812;
        // ---------- Original Method ----------
        //String retval = headerName + COLON;
        //if (optionTag != null)
            //retval += SP + optionTag;
        //retval += NEWLINE;
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.817 -0400", hash_original_method = "CAE88651ED9FF39412B77E9D96C77B38", hash_generated_method = "252EED7F20842D4497D52DE681B60353")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_925075780 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_925075780 = optionTag != null ? optionTag : "";
        varB4EAC82CA7396A68D541C85D26508E83_925075780.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_925075780;
        // ---------- Original Method ----------
        //return optionTag != null ? optionTag : "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.831 -0400", hash_original_method = "0B1E7641398A7F9C5ED01BA7A61C72A2", hash_generated_method = "7F7B837816A1B7C663AE6594B53BF59E")
    public void setOptionTag(String optionTag) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, Supported, "
                    + "setOptionTag(), the optionTag parameter is null");
        this.optionTag = optionTag;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, Supported, "
                    //+ "setOptionTag(), the optionTag parameter is null");
        //this.optionTag = optionTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.832 -0400", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "AA98D9A3A9462FD0F420EF2C46EAB71C")
    public String getOptionTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1979879657 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1979879657 = optionTag;
        varB4EAC82CA7396A68D541C85D26508E83_1979879657.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1979879657;
        // ---------- Original Method ----------
        //return optionTag;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.832 -0400", hash_original_field = "88CC963820AD961ACCC8118304ED55D8", hash_generated_field = "35EF35880700F714B5E096D965FC75AB")

    private static long serialVersionUID = -7679667592702854542L;
}

