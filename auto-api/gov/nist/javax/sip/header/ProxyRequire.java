package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.*;

public class ProxyRequire extends SIPHeader implements ProxyRequireHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.220 -0400", hash_original_field = "7215DE10AF39CFD62967156F13524AEE", hash_generated_field = "EA9E843EF6C95A0999AD8B5523E0E7B3")

    protected String optionTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.220 -0400", hash_original_method = "313262BBE47BF259092F8848A4D13338", hash_generated_method = "8A94E0C1BEC1D37D30D767A123DE1038")
    public  ProxyRequire() {
        super(PROXY_REQUIRE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.223 -0400", hash_original_method = "3BC392B937FA3D9900D8752B431D0DD9", hash_generated_method = "F3EFD4D914FF90D265B07632E0366FF6")
    public  ProxyRequire(String s) {
        super(PROXY_REQUIRE);
        optionTag = s;
        // ---------- Original Method ----------
        //optionTag = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.227 -0400", hash_original_method = "9C711BE19A8C0E0A7CB116A3F753C6F0", hash_generated_method = "47E89685D24FF2CD2899F4433AFE0F09")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_133275172 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_133275172 = optionTag;
        varB4EAC82CA7396A68D541C85D26508E83_133275172.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_133275172;
        // ---------- Original Method ----------
        //return optionTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.228 -0400", hash_original_method = "DE0D7BEB729218B451469620CB6256C4", hash_generated_method = "0DE3328C2A246D88C84BE17D43BB56D5")
    public void setOptionTag(String optionTag) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("JAIN-SIP Exception, ProxyRequire, setOptionTag(), the optionTag parameter is null");
        this.optionTag = optionTag;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException("JAIN-SIP Exception, ProxyRequire, setOptionTag(), the optionTag parameter is null");
        //this.optionTag = optionTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.228 -0400", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "67155285830246C6A9F5864C24B507CA")
    public String getOptionTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_882381713 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_882381713 = optionTag;
        varB4EAC82CA7396A68D541C85D26508E83_882381713.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_882381713;
        // ---------- Original Method ----------
        //return optionTag;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.228 -0400", hash_original_field = "975F50328F4FE764CD0D0C999A356DC0", hash_generated_field = "BF79FE227AB1BC2E7445E864E1C13DD2")

    private static long serialVersionUID = -3269274234851067893L;
}

