package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.net.AddressResolver;
import gov.nist.javax.sip.stack.HopImpl;
import gov.nist.javax.sip.stack.MessageProcessor;

import javax.sip.address.Hop;



public class DefaultAddressResolver implements AddressResolver {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:57.139 -0500", hash_original_method = "DF566229E3B5A08AB8CBD467E13866C4", hash_generated_method = "B406D79324664E28CC70541D3A8B451C")
    public DefaultAddressResolver() {

    }
    /*
     * (non-Javadoc)
     * @see gov.nist.core.net.AddressResolver#resolveAddress(javax.sip.address.Hop)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:57.140 -0500", hash_original_method = "A95D8B22A59B30AE2193C9FD49249FF0", hash_generated_method = "482C241EC7188086C78AF00360938E5E")
    public Hop resolveAddress(Hop inputAddress) {
        if  (inputAddress.getPort()  != -1)
            return inputAddress;
        else {
            return new HopImpl(inputAddress.getHost(),
                    MessageProcessor.getDefaultPort(inputAddress.getTransport()),inputAddress.getTransport());
        }
    }

    
}

