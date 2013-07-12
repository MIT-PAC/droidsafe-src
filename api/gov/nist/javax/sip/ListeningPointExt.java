package gov.nist.javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import javax.sip.ListeningPoint;
import javax.sip.header.ContactHeader;
import javax.sip.header.ViaHeader;

public interface ListeningPointExt extends ListeningPoint {

    

    ContactHeader createContactHeader() ;

    
    public void sendHeartbeat(String ipAddress, int port) throws IOException ;
    
    
    public ViaHeader createViaHeader();


}
