package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.OrganizationHeader;

public class Organization extends SIPHeader implements OrganizationHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.574 -0500", hash_original_field = "DD7DE6DAF2CCCB3596A2E5B031D9F680", hash_generated_field = "BF1069295545422BFA1A0647DDAC00E1")

    private static final long serialVersionUID = -2775003113740192712L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.578 -0500", hash_original_field = "31E9A831E4D0696A4D40D066FD5E431A", hash_generated_field = "7B6519A46F5BF8862075151D042F1E20")

    protected String organization;

    /**
     * Default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.584 -0500", hash_original_method = "A22A45BA0A2B2678454705CA5BB968BD", hash_generated_method = "31BA1324E7F2B90B300FFF12A86A746C")
    
public Organization() {
        super(ORGANIZATION);
    }

    /**
     * Return encoding of value of the header.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.581 -0500", hash_original_method = "64094CFB244C647C5657F3E488B1D7D6", hash_generated_method = "DFD6F8FCBE676C5DD63A9C319CD53D2C")
    
public String encodeBody() {
        return organization;
    }

    /**
     * Get the organization field.
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.587 -0500", hash_original_method = "9435FCCFD7C054307D934681F7070D26", hash_generated_method = "F2D3B499E982D449130D084429540356")
    
public String getOrganization() {
        return organization;
    }

    /**
     * Set the organization member
     * @param o String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.590 -0500", hash_original_method = "525AB078049049253D355424AD5A3E65", hash_generated_method = "B1187D7450B6D65C83157AC88175AEBD")
    
public void setOrganization(String o) throws ParseException {
        if (o == null)
            throw new NullPointerException(
                "JAIN-SIP Exception,"
                    + " Organization, setOrganization(), the organization parameter is null");
        organization = o;
    }
}

