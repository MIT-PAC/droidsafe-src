package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

import javax.sip.ListeningPoint;
import javax.sip.header.ContactHeader;
import javax.sip.header.ViaHeader;

public interface ListeningPointExt extends ListeningPoint {

    

    ContactHeader createContactHeader() ;

    
    public void sendHeartbeat(String ipAddress, int port) throws IOException ;
    
    
    public ViaHeader createViaHeader();


}
