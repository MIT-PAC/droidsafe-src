package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.AddressImpl;

import java.text.ParseException;

import javax.sip.header.ExtensionHeader;



public class Path extends gov.nist.javax.sip.header.AddressParametersHeader implements PathHeader, SIPHeaderNamesIms, ExtensionHeader {

    /**
     * constructor
     * @param address address to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.801 -0500", hash_original_method = "1A5DC98D9C587097429AD2D82BB7A094", hash_generated_method = "BF2B77595313FDDAEB650B9C4C589AD1")
    
public Path(AddressImpl address) {
        super(NAME);
        this.address = address;
    }

    /**
     * default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.805 -0500", hash_original_method = "1037FC87002CAE3F016A3DA3F4CF1390", hash_generated_method = "A7FBED19E61D5686DE78CCC8163A8A82")
    
public Path()
    {
        // issued by Miguel Freitas
        super(NAME);

    }

    /** Encode into canonical form.
     *@return String containing the canonicaly encoded header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.808 -0500", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "D16B9D80B8A3FF76F7E29D31CF350BD3")
    
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
            retval.append(SEMICOLON + this.parameters.encode());
        return retval.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.812 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "014FE50D8A9A4F50DCF1C9E31F934432")
    
public void setValue(String value) throws ParseException {
        throw new ParseException(value,0);

    }

    
}

