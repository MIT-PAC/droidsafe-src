package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.header.*;

public class ProxyRequireList extends SIPHeaderList<ProxyRequire> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.945 -0400", hash_original_method = "029C98C6EA119F5ED189F5C1632A9558", hash_generated_method = "2056F217F92BE2216FB0A4CD03CA3055")
    public  ProxyRequireList() {
        super(ProxyRequire.class, ProxyRequireHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.946 -0400", hash_original_method = "013E28988AF93ED240675D60306569D5", hash_generated_method = "AFF44889AF68DF95B4362055B7A63981")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_823797200 = null; 
        ProxyRequireList retval = new ProxyRequireList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_823797200 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_823797200.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_823797200;
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.946 -0400", hash_original_field = "1A2A1D3686B95721391BC268C1B09305", hash_generated_field = "210395FBA80388CA1983FDB080800955")

    private static final long serialVersionUID = 5648630649476486042L;
}

