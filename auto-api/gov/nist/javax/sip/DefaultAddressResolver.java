package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.sip.address.Hop;
import gov.nist.core.net.AddressResolver;
import gov.nist.javax.sip.stack.HopImpl;
import gov.nist.javax.sip.stack.MessageProcessor;

public class DefaultAddressResolver implements AddressResolver {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.808 -0400", hash_original_method = "DF566229E3B5A08AB8CBD467E13866C4", hash_generated_method = "B6233FFF3B7153457116BC5E853882E0")
    @DSModeled(DSC.SAFE)
    public DefaultAddressResolver() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.809 -0400", hash_original_method = "A95D8B22A59B30AE2193C9FD49249FF0", hash_generated_method = "2A66FFE2AEF4DD5751BD7A1D6BE9FB9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Hop resolveAddress(Hop inputAddress) {
        dsTaint.addTaint(inputAddress.dsTaint);
        {
            boolean varACA6E6AF06869376955350ABA88D8C22_585865960 = (inputAddress.getPort()  != -1);
            {
                Hop var2F6BCB44684B0197AF12797702FD4C72_2073011051 = (new HopImpl(inputAddress.getHost(),
                    MessageProcessor.getDefaultPort(inputAddress.getTransport()),inputAddress.getTransport()));
            } //End block
        } //End collapsed parenthetic
        return (Hop)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if  (inputAddress.getPort()  != -1)
            //return inputAddress;
        //else {
            //return new HopImpl(inputAddress.getHost(),
                    //MessageProcessor.getDefaultPort(inputAddress.getTransport()),inputAddress.getTransport());
        //}
    }

    
}

