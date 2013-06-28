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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.996 -0400", hash_original_method = "DF566229E3B5A08AB8CBD467E13866C4", hash_generated_method = "B6233FFF3B7153457116BC5E853882E0")
    public  DefaultAddressResolver() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.997 -0400", hash_original_method = "A95D8B22A59B30AE2193C9FD49249FF0", hash_generated_method = "D3D6A44FE7CA5A43C09F280745A810F2")
    public Hop resolveAddress(Hop inputAddress) {
        Hop varB4EAC82CA7396A68D541C85D26508E83_573422996 = null; //Variable for return #1
        Hop varB4EAC82CA7396A68D541C85D26508E83_386145214 = null; //Variable for return #2
        {
            boolean varACA6E6AF06869376955350ABA88D8C22_2053284753 = (inputAddress.getPort()  != -1);
            varB4EAC82CA7396A68D541C85D26508E83_573422996 = inputAddress;
            {
                varB4EAC82CA7396A68D541C85D26508E83_386145214 = new HopImpl(inputAddress.getHost(),
                    MessageProcessor.getDefaultPort(inputAddress.getTransport()),inputAddress.getTransport());
            } //End block
        } //End collapsed parenthetic
        addTaint(inputAddress.getTaint());
        Hop varA7E53CE21691AB073D9660D615818899_1734621005; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1734621005 = varB4EAC82CA7396A68D541C85D26508E83_573422996;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1734621005 = varB4EAC82CA7396A68D541C85D26508E83_386145214;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1734621005.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1734621005;
        // ---------- Original Method ----------
        //if  (inputAddress.getPort()  != -1)
            //return inputAddress;
        //else {
            //return new HopImpl(inputAddress.getHost(),
                    //MessageProcessor.getDefaultPort(inputAddress.getTransport()),inputAddress.getTransport());
        //}
    }

    
}

