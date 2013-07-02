package gov.nist.core.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.sip.address.Hop;

public interface AddressResolver {

    
    public Hop resolveAddress( Hop hop);





}
