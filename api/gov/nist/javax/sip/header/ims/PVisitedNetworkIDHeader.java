package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.core.Token;

import javax.sip.header.Header;
import javax.sip.header.Parameters;

public interface PVisitedNetworkIDHeader extends Parameters, Header {

    
    public final static String NAME = "P-Visited-Network-ID";


    
    public void setVisitedNetworkID(String networkID);

    
    public void setVisitedNetworkID(Token networkID);

    
    public String getVisitedNetworkID();

}
