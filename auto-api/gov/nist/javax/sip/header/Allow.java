package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;

public final class Allow extends SIPHeader implements javax.sip.header.AllowHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.882 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.882 -0400", hash_original_method = "473413697039914FAE978B5460F14DD9", hash_generated_method = "4D31534EA8011D7FF178B53A73A728AA")
    public  Allow() {
        super(ALLOW);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.883 -0400", hash_original_method = "07DC0232E600446B62A81ACF6B5528CD", hash_generated_method = "8A73E6FD8CDE43ABC63EE34599FECCC8")
    public  Allow(String m) {
        super(ALLOW);
        method = m;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.884 -0400", hash_original_method = "A65B682B0B822D8527FBE88A2FCA60FC", hash_generated_method = "AB926646E53C1013CB2AC3F8F2CADF91")
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_1398778673 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1398778673 = method;
        varB4EAC82CA7396A68D541C85D26508E83_1398778673.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1398778673;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.885 -0400", hash_original_method = "78C1F544F0B2D71B62F1C06FF7335973", hash_generated_method = "FFB02806EF69152178684BFF9A7F00F7")
    public void setMethod(String method) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception"
                    + ", Allow, setMethod(), the method parameter is null.");
        this.method = method;
        
        
            
                
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.885 -0400", hash_original_method = "48A673DBBFEBFCB1D74A4ACDDDC3C6AB", hash_generated_method = "15643C90DC7777E2700F8B36E1B1BBB0")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1975471326 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1975471326 = method;
        varB4EAC82CA7396A68D541C85D26508E83_1975471326.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1975471326;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.885 -0400", hash_original_field = "E2D8B8EAC99520FEE5D7EF6F1AA6DA96", hash_generated_field = "85C85A2237A84342C80D2A96596481BF")

    private static final long serialVersionUID = -3105079479020693930L;
}

