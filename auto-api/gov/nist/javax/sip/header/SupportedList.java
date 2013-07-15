package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.header.*;

public class SupportedList extends SIPHeaderList<Supported> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.731 -0400", hash_original_method = "C97E7EF6FC87A3A068AC23349CE0B329", hash_generated_method = "9D8330A8D22F00AA1938D1F30E872420")
    public  SupportedList() {
        super(Supported.class, SupportedHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.735 -0400", hash_original_method = "45CDCD8BD327539AF66457D00250AD24", hash_generated_method = "77EF55ED50D9E4A8370104BA548BE4AA")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1203354805 = null; 
        SupportedList retval = new SupportedList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1203354805 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1203354805.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1203354805;
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.735 -0400", hash_original_field = "0C172D453BA0BA79FBC9C11E860BD33B", hash_generated_field = "C52F2E011560C6C75D9803CFE79F0EF9")

    private static final long serialVersionUID = -4539299544895602367L;
}

