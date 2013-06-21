package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.EventObject;

public class IOExceptionEvent extends EventObject {
    private String mHost;
    private int mPort;
    private String mTransport;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.231 -0400", hash_original_method = "B65431E37A5EA3D43D49DD68F5D308D7", hash_generated_method = "BE9C23A987A0EC193366112C16F74307")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IOExceptionEvent(Object source, String host, int port,
            String transport) {
        super(source);
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(source.dsTaint);
        dsTaint.addTaint(transport);
        // ---------- Original Method ----------
        //mHost = host;
        //mPort = port;
        //mTransport = transport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.232 -0400", hash_original_method = "B21C2297C1E60D4D2D92DDE75D931874", hash_generated_method = "68C433D1B5A102629AAF54FA94700A37")
    @DSModeled(DSC.SAFE)
    public String getHost() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.232 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "989B279AB861DC9FDC85B5020F096FDA")
    @DSModeled(DSC.SAFE)
    public int getPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.232 -0400", hash_original_method = "CC293D4A58B4AE34EE1EAFE01D7A0F93", hash_generated_method = "D95E969B150D38FF6663AFA6892DE8AE")
    @DSModeled(DSC.SAFE)
    public String getTransport() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTransport;
    }

    
}

