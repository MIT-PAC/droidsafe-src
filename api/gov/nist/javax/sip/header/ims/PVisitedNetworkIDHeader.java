package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;

import javax.sip.header.Header;
import javax.sip.header.Parameters;

public interface PVisitedNetworkIDHeader extends Parameters, Header {
    
    public final static String NAME = "P-Visited-Network-ID";
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setVisitedNetworkID(String networkID);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setVisitedNetworkID(Token networkID);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String getVisitedNetworkID();

}
