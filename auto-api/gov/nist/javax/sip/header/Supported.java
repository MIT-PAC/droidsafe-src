package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.*;

public class Supported extends SIPHeader implements SupportedHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.721 -0400", hash_original_field = "7215DE10AF39CFD62967156F13524AEE", hash_generated_field = "EA9E843EF6C95A0999AD8B5523E0E7B3")

    protected String optionTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.722 -0400", hash_original_method = "5230DF363A4CA66C4A13E103BCE72C7C", hash_generated_method = "3C8D784CD22FBCF471BE0C5853D91DD1")
    public  Supported() {
        super(SIPHeaderNames.SUPPORTED);
        optionTag = null;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.722 -0400", hash_original_method = "22E9310B7938D206E4E2944ECFF36AB1", hash_generated_method = "ECAB293A06845B6630EB2733D29358A7")
    public  Supported(String option_tag) {
        super(SIPHeaderNames.SUPPORTED);
        optionTag = option_tag;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.723 -0400", hash_original_method = "6B2B571AE4F377CE25FA9B4608683BF5", hash_generated_method = "AC65FDC747B8526D95C0600261FE025B")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_173841203 = null; 
        String retval = headerName + COLON;
        retval += SP + optionTag;
        retval += NEWLINE;
        varB4EAC82CA7396A68D541C85D26508E83_173841203 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_173841203.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_173841203;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.724 -0400", hash_original_method = "CAE88651ED9FF39412B77E9D96C77B38", hash_generated_method = "3CA599FE6FF3858459A85AB8F19AA4B1")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_689296663 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_689296663 = optionTag != null ? optionTag : "";
        varB4EAC82CA7396A68D541C85D26508E83_689296663.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_689296663;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.725 -0400", hash_original_method = "0B1E7641398A7F9C5ED01BA7A61C72A2", hash_generated_method = "7F7B837816A1B7C663AE6594B53BF59E")
    public void setOptionTag(String optionTag) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, Supported, "
                    + "setOptionTag(), the optionTag parameter is null");
        this.optionTag = optionTag;
        
        
            
                
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.726 -0400", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "28CC56A8CBA2DD2359EE17D5F59297AF")
    public String getOptionTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_2038567944 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2038567944 = optionTag;
        varB4EAC82CA7396A68D541C85D26508E83_2038567944.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2038567944;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.726 -0400", hash_original_field = "88CC963820AD961ACCC8118304ED55D8", hash_generated_field = "D3D7272B6F01E32B817268E9A8B320BF")

    private static final long serialVersionUID = -7679667592702854542L;
}

