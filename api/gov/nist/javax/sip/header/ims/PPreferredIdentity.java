package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.AddressParametersHeader;

import java.text.ParseException;

import javax.sip.header.ExtensionHeader;

public class PPreferredIdentity extends AddressParametersHeader implements PPreferredIdentityHeader, SIPHeaderNamesIms, ExtensionHeader {

    /**
     * constructor
     * @param address address to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.890 -0500", hash_original_method = "A7A18C7C290144143F0B066F971631B8", hash_generated_method = "A36D685B80156D23315E110B22B42B88")
    
public PPreferredIdentity(AddressImpl address) {
        super(NAME);
        this.address = address;
    }

    /**
     * default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.894 -0500", hash_original_method = "87907696BDC4EF5B0ECA8FC9DCAB5991", hash_generated_method = "B6B59C91235DAD0966DAABAAD7D50348")
    
public PPreferredIdentity() {
        super(P_PREFERRED_IDENTITY);
    }

    /** Encode into canonical form.
     * @return String containing the canonicaly encoded header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.897 -0500", hash_original_method = "2167C0D1D3C772E3CF273B6DCAFE6265", hash_generated_method = "1280E52145850A1DA713E9F5D7CFB6FB")
    
public String encodeBody() {
        StringBuffer retval = new StringBuffer();
        if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            retval.append(LESS_THAN);
        }
        retval.append(address.encode());
        if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            retval.append(GREATER_THAN);
        }

        return retval.toString();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.901 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "014FE50D8A9A4F50DCF1C9E31F934432")
    
public void setValue(String value) throws ParseException {
        throw new ParseException (value,0);

    }
    
}

