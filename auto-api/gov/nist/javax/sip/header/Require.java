package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.*;

public class Require extends SIPHeader implements RequireHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.338 -0400", hash_original_field = "7215DE10AF39CFD62967156F13524AEE", hash_generated_field = "EA9E843EF6C95A0999AD8B5523E0E7B3")

    protected String optionTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.339 -0400", hash_original_method = "7D717471F4A5D7EAD23BC013F4963192", hash_generated_method = "FB2DC2E91D950F6C620B24801FE2D28F")
    public  Require() {
        super(REQUIRE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.348 -0400", hash_original_method = "BECC14DD123F4F96D2EA3BD4716F0CF2", hash_generated_method = "575C009F91F2FEFD0A3860B3360F0E6E")
    public  Require(String s) {
        super(REQUIRE);
        optionTag = s;
        // ---------- Original Method ----------
        //optionTag = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.348 -0400", hash_original_method = "9C711BE19A8C0E0A7CB116A3F753C6F0", hash_generated_method = "2DC538516D9C7F5501D7F9B93E1E8EB8")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_784880039 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_784880039 = optionTag;
        varB4EAC82CA7396A68D541C85D26508E83_784880039.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_784880039;
        // ---------- Original Method ----------
        //return optionTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.349 -0400", hash_original_method = "61D4CA895F679FC1977776F5CD42A467", hash_generated_method = "AC3D9923543B67CCFC6B21773EF16E72")
    public void setOptionTag(String optionTag) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, Require, "
                    + "setOptionTag(), the optionTag parameter is null");
        this.optionTag = optionTag;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, Require, "
                    //+ "setOptionTag(), the optionTag parameter is null");
        //this.optionTag = optionTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.349 -0400", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "30B6F784B9372E6B5396D1017FCA53C1")
    public String getOptionTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1310757486 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1310757486 = optionTag;
        varB4EAC82CA7396A68D541C85D26508E83_1310757486.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1310757486;
        // ---------- Original Method ----------
        //return optionTag;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.349 -0400", hash_original_field = "F3891BC8B68B30AE726482A3676916A5", hash_generated_field = "1BF9654895DA4559C05993BAFF91498E")

    private static long serialVersionUID = -3743425404884053281L;
}

