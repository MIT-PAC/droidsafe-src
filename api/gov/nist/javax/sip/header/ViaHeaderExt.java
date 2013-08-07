package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.sip.header.ViaHeader;

public interface ViaHeaderExt extends ViaHeader {
    
    public String getSentByField();
    
    public String getSentProtocolField();
}
