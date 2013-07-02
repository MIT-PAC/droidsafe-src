package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.*;

public class Require extends SIPHeader implements RequireHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.111 -0400", hash_original_field = "7215DE10AF39CFD62967156F13524AEE", hash_generated_field = "EA9E843EF6C95A0999AD8B5523E0E7B3")

    protected String optionTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.111 -0400", hash_original_method = "7D717471F4A5D7EAD23BC013F4963192", hash_generated_method = "FB2DC2E91D950F6C620B24801FE2D28F")
    public  Require() {
        super(REQUIRE);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.112 -0400", hash_original_method = "BECC14DD123F4F96D2EA3BD4716F0CF2", hash_generated_method = "575C009F91F2FEFD0A3860B3360F0E6E")
    public  Require(String s) {
        super(REQUIRE);
        optionTag = s;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.112 -0400", hash_original_method = "9C711BE19A8C0E0A7CB116A3F753C6F0", hash_generated_method = "E7CFB80BD9089D24AE24925AF2C47EEE")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1752007709 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1752007709 = optionTag;
        varB4EAC82CA7396A68D541C85D26508E83_1752007709.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1752007709;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.113 -0400", hash_original_method = "61D4CA895F679FC1977776F5CD42A467", hash_generated_method = "AC3D9923543B67CCFC6B21773EF16E72")
    public void setOptionTag(String optionTag) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, Require, "
                    + "setOptionTag(), the optionTag parameter is null");
        this.optionTag = optionTag;
        
        
            
                
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.113 -0400", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "C77CF5AA36EC80E32581C92205D46B7E")
    public String getOptionTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1493285254 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1493285254 = optionTag;
        varB4EAC82CA7396A68D541C85D26508E83_1493285254.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1493285254;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.113 -0400", hash_original_field = "F3891BC8B68B30AE726482A3676916A5", hash_generated_field = "771FB76C670B9496D76C78920521C071")

    private static final long serialVersionUID = -3743425404884053281L;
}

