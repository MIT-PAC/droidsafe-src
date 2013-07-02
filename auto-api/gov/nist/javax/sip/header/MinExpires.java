package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.*;
import javax.sip.header.*;

public class MinExpires extends SIPHeader implements MinExpiresHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.813 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "E191433B1529B42724890251971016B1")

    protected int expires;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.813 -0400", hash_original_method = "E220E899B716906991999B2A4C081552", hash_generated_method = "CD25F29B29CDBECA1004AA69954293B5")
    public  MinExpires() {
        super(NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.814 -0400", hash_original_method = "D42EEF06048E7D77F00EA781D2005D33", hash_generated_method = "B44353382063DC1152BB46BE7281E707")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1415732894 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1415732894 = Integer.toString(expires);
        varB4EAC82CA7396A68D541C85D26508E83_1415732894.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1415732894;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.814 -0400", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "C28E07FE1FD5A320AF493C6D6DB6674F")
    public int getExpires() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828451815 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828451815;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.814 -0400", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "1F94C2B6C4EFAB2003C10C5168D24F2A")
    public void setExpires(int expires) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad argument " + expires);
        this.expires = expires;
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.814 -0400", hash_original_field = "D2AF3D0B8A0546A777A14BAF32F484A1", hash_generated_field = "54DFFD072C6FF45C93B222EE008E242A")

    private static final long serialVersionUID = 7001828209606095801L;
}

