package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.*;

public class ProxyRequireList extends SIPHeaderList<ProxyRequire> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.755 -0400", hash_original_method = "029C98C6EA119F5ED189F5C1632A9558", hash_generated_method = "2056F217F92BE2216FB0A4CD03CA3055")
    public  ProxyRequireList() {
        super(ProxyRequire.class, ProxyRequireHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.755 -0400", hash_original_method = "013E28988AF93ED240675D60306569D5", hash_generated_method = "C7690CDCFA9BF28F9C4A7A709A4D561C")
    public Object clone() {
        ProxyRequireList retval = new ProxyRequireList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_1458186698 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1458186698.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1458186698;
        // ---------- Original Method ----------
        //ProxyRequireList retval = new ProxyRequireList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.755 -0400", hash_original_field = "1A2A1D3686B95721391BC268C1B09305", hash_generated_field = "210395FBA80388CA1983FDB080800955")

    private static final long serialVersionUID = 5648630649476486042L;
}

