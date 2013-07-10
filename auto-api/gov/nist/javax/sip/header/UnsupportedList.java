package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Iterator;
import javax.sip.header.*;

public class UnsupportedList extends SIPHeaderList<Unsupported> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.836 -0400", hash_original_method = "CBBAF1558631750DDBDF9DAEDB7A572C", hash_generated_method = "8F7A7A782386B52882B87C6BD42B708B")
    public  UnsupportedList() {
        super(Unsupported.class, UnsupportedHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.837 -0400", hash_original_method = "586FD49C37A8AA9D6CC092649E8819BF", hash_generated_method = "FFAA339B9FDBD367C73CDDB7B7A21B80")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1024396380 = null; 
        UnsupportedList retval = new UnsupportedList();
        varB4EAC82CA7396A68D541C85D26508E83_1024396380 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1024396380.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1024396380;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.837 -0400", hash_original_field = "043C2460CDAFC725D54C2CA7401A9DF9", hash_generated_field = "127841856DFEDCF98BA424B546FA09BC")

    private static final long serialVersionUID = -4052610269407058661L;
}

