package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.ProxyRequireHeader;

public class ProxyRequireList extends SIPHeaderList<ProxyRequire> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.532 -0500", hash_original_field = "4110172A587E9CF7DC46A40DB4BEF1DC", hash_generated_field = "210395FBA80388CA1983FDB080800955")

    private static final long serialVersionUID = 5648630649476486042L;

    /** Default Constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.538 -0500", hash_original_method = "029C98C6EA119F5ED189F5C1632A9558", hash_generated_method = "B849ED7812D8467803C50B14D6D6C492")
    
public ProxyRequireList() {
        super(ProxyRequire.class, ProxyRequireHeader.NAME);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.535 -0500", hash_original_method = "013E28988AF93ED240675D60306569D5", hash_generated_method = "EDA60B2660F6B20FCC2D7A3ACFFEC8B2")
    
public Object clone() {
        ProxyRequireList retval = new ProxyRequireList();
        retval.clonehlist(this.hlist);
        return retval;
    }
}

