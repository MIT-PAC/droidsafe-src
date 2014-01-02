package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.AddressParametersHeader;

import java.text.ParseException;

import javax.sip.header.ExtensionHeader;



public class PAssertedIdentity extends AddressParametersHeader implements PAssertedIdentityHeader, SIPHeaderNamesIms, ExtensionHeader {



    /**
     * constructor
     * @param address address to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.001 -0500", hash_original_method = "4DB521A98546EC6C210A063C8DC8A3AB", hash_generated_method = "0DDB1E046253A1AC85647D9DA7F16054")
    
public PAssertedIdentity(AddressImpl address) {
        super(NAME);
        this.address = address;
    }

    /**
     * default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.004 -0500", hash_original_method = "7A9E6607376C61D3870CDBD630C80B00", hash_generated_method = "29ABC8EEBEF62BFE4F873E3FDD648087")
    
public PAssertedIdentity()
    {
        super(NAME);
    }

    /** Encode into canonical form.
     *@return String containing the canonicaly encoded header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.007 -0500", hash_original_method = "A02034091310C74B28639EFAE9360C33", hash_generated_method = "1A284CEE0323A19E2119CB64D978D10E")
    
public String encodeBody() {
        StringBuffer retval = new StringBuffer();
        if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            retval.append(LESS_THAN);
        }
        retval.append(address.encode());
        if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            retval.append(GREATER_THAN);
        }


        if (!parameters.isEmpty())
            retval.append(COMMA + this.parameters.encode());
        return retval.toString();
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.011 -0500", hash_original_method = "0E5911CB2B858F97AB1667F7876EAA3E", hash_generated_method = "D65CFBC94D96BD21425B515590201BAF")
    
public Object clone() {
        PAssertedIdentity retval = (PAssertedIdentity) super.clone();
        return retval;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.014 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "014FE50D8A9A4F50DCF1C9E31F934432")
    
public void setValue(String value) throws ParseException {
        throw new ParseException(value,0);

    }

    
}

