package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.*;

public class ProxyRequire extends SIPHeader implements ProxyRequireHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.940 -0400", hash_original_field = "7215DE10AF39CFD62967156F13524AEE", hash_generated_field = "EA9E843EF6C95A0999AD8B5523E0E7B3")

    protected String optionTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.941 -0400", hash_original_method = "313262BBE47BF259092F8848A4D13338", hash_generated_method = "8A94E0C1BEC1D37D30D767A123DE1038")
    public  ProxyRequire() {
        super(PROXY_REQUIRE);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.941 -0400", hash_original_method = "3BC392B937FA3D9900D8752B431D0DD9", hash_generated_method = "F3EFD4D914FF90D265B07632E0366FF6")
    public  ProxyRequire(String s) {
        super(PROXY_REQUIRE);
        optionTag = s;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.941 -0400", hash_original_method = "9C711BE19A8C0E0A7CB116A3F753C6F0", hash_generated_method = "80A6BF2C894D9763FFA0A2A4475E6E2C")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_767372404 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_767372404 = optionTag;
        varB4EAC82CA7396A68D541C85D26508E83_767372404.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_767372404;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.942 -0400", hash_original_method = "DE0D7BEB729218B451469620CB6256C4", hash_generated_method = "0DE3328C2A246D88C84BE17D43BB56D5")
    public void setOptionTag(String optionTag) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("JAIN-SIP Exception, ProxyRequire, setOptionTag(), the optionTag parameter is null");
        this.optionTag = optionTag;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.942 -0400", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "CB1E899EFE7AC287E90EF8AC719CC191")
    public String getOptionTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_473382638 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_473382638 = optionTag;
        varB4EAC82CA7396A68D541C85D26508E83_473382638.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_473382638;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.942 -0400", hash_original_field = "975F50328F4FE764CD0D0C999A356DC0", hash_generated_field = "EA994B24C6A518D84FF4C741C559C547")

    private static final long serialVersionUID = -3269274234851067893L;
}

