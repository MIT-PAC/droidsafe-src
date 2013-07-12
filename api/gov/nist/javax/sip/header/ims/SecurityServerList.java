package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.SIPHeaderList;
import gov.nist.javax.sip.header.ims.SecurityServer;

public class SecurityServerList extends SIPHeaderList<SecurityServer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.206 -0400", hash_original_method = "DDC555D009CE8B153DA6D33D8F867563", hash_generated_method = "744A6F9CF502C67EBD2705F91696A76E")
    public  SecurityServerList() {
        super(SecurityServer.class, SecurityServerHeader.NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.206 -0400", hash_original_method = "DB9A46F7231A313671C09010ADA9A7C3", hash_generated_method = "2F70EF1FDCB661BD7FB3215F7A1731A1")
    public Object clone() {
        SecurityServerList retval = new SecurityServerList();
Object varF627329B9209466293A1BF71D9AF7B2B_1281702178 =         retval.clonehlist(this.hlist);
        varF627329B9209466293A1BF71D9AF7B2B_1281702178.addTaint(taint);
        return varF627329B9209466293A1BF71D9AF7B2B_1281702178;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.206 -0400", hash_original_field = "DA5AA60986249AC34031EC85612912C9", hash_generated_field = "FA2EA3141868868D79B17D55AFCB33DF")

    private static final long serialVersionUID = -1392066520803180238L;
}

