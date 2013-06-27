package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;
import gov.nist.javax.sip.header.ims.SecurityServer;

public class SecurityServerList extends SIPHeaderList<SecurityServer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.652 -0400", hash_original_method = "DDC555D009CE8B153DA6D33D8F867563", hash_generated_method = "744A6F9CF502C67EBD2705F91696A76E")
    public  SecurityServerList() {
        super(SecurityServer.class, SecurityServerHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.653 -0400", hash_original_method = "DB9A46F7231A313671C09010ADA9A7C3", hash_generated_method = "25CDF71F8A82C5469DE51DF9A677691B")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1715353310 = null; //Variable for return #1
        SecurityServerList retval;
        retval = new SecurityServerList();
        varB4EAC82CA7396A68D541C85D26508E83_1715353310 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1715353310.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1715353310;
        // ---------- Original Method ----------
        //SecurityServerList retval = new SecurityServerList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.653 -0400", hash_original_field = "DA5AA60986249AC34031EC85612912C9", hash_generated_field = "FF2FC72CF1175C68749E7EB1947ED18B")

    private static long serialVersionUID = -1392066520803180238L;
}

