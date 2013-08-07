package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.sip.header.ProxyRequireHeader;






public class ProxyRequireList extends SIPHeaderList<ProxyRequire> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.766 -0400", hash_original_method = "029C98C6EA119F5ED189F5C1632A9558", hash_generated_method = "2056F217F92BE2216FB0A4CD03CA3055")
    public  ProxyRequireList() {
        super(ProxyRequire.class, ProxyRequireHeader.NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.766 -0400", hash_original_method = "013E28988AF93ED240675D60306569D5", hash_generated_method = "6605E84F579A1EA90E1D2D3AF1D463B2")
    public Object clone() {
        ProxyRequireList retval = new ProxyRequireList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_890521039 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_890521039.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_890521039;
        // ---------- Original Method ----------
        //ProxyRequireList retval = new ProxyRequireList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.766 -0400", hash_original_field = "1A2A1D3686B95721391BC268C1B09305", hash_generated_field = "210395FBA80388CA1983FDB080800955")

    private static final long serialVersionUID = 5648630649476486042L;
}

