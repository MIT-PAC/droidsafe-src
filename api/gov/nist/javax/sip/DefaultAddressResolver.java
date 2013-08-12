package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.core.net.AddressResolver;
import gov.nist.javax.sip.stack.HopImpl;
import gov.nist.javax.sip.stack.MessageProcessor;

import javax.sip.address.Hop;



public class DefaultAddressResolver implements AddressResolver {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.827 -0400", hash_original_method = "DF566229E3B5A08AB8CBD467E13866C4", hash_generated_method = "B6233FFF3B7153457116BC5E853882E0")
    public  DefaultAddressResolver() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.827 -0400", hash_original_method = "A95D8B22A59B30AE2193C9FD49249FF0", hash_generated_method = "8F27B55B1B39256556B352784339F08C")
    public Hop resolveAddress(Hop inputAddress) {
        addTaint(inputAddress.getTaint());
        if(inputAddress.getPort()  != -1)        
        {
Hop var400A226661A9805AE36255F1984B015D_662013084 =         inputAddress;
        var400A226661A9805AE36255F1984B015D_662013084.addTaint(taint);
        return var400A226661A9805AE36255F1984B015D_662013084;
        }
        else
        {
Hop var5A59C93626D10D515A9DA42C848AF5AA_1479925031 =             new HopImpl(inputAddress.getHost(),
                    MessageProcessor.getDefaultPort(inputAddress.getTransport()),inputAddress.getTransport());
            var5A59C93626D10D515A9DA42C848AF5AA_1479925031.addTaint(taint);
            return var5A59C93626D10D515A9DA42C848AF5AA_1479925031;
        } //End block
        // ---------- Original Method ----------
        //if  (inputAddress.getPort()  != -1)
            //return inputAddress;
        //else {
            //return new HopImpl(inputAddress.getHost(),
                    //MessageProcessor.getDefaultPort(inputAddress.getTransport()),inputAddress.getTransport());
        //}
    }

    
}

