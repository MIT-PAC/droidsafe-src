package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.ViaHeader;

public interface ViaHeaderExt extends ViaHeader {
    
    public String getSentByField();
    
    public String getSentProtocolField();
}
