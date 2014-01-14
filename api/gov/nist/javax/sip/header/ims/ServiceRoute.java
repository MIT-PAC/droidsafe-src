package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.AddressImpl;

import java.text.ParseException;

import javax.sip.header.ExtensionHeader;

public class ServiceRoute extends gov.nist.javax.sip.header.AddressParametersHeader implements ServiceRouteHeader, SIPHeaderNamesIms, ExtensionHeader {

    /**
     * constructor
     * @param address address to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.384 -0500", hash_original_method = "9637595E6ECE05066933FE4B9C7C7011", hash_generated_method = "2FE1D8D9EB2221419016AFD5984EB565")
    
public ServiceRoute(AddressImpl address) {
        super(NAME);
        this.address = address;
    }

    /**
     * default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.388 -0500", hash_original_method = "DFE1A15880B80307A8195E7AA915629C", hash_generated_method = "B5AFD475FF0665ED6A60C95F14F88ADA")
    
public ServiceRoute() {
        super(SERVICE_ROUTE);
    }

    /** Encode into canonical form.
     *@return String containing the canonicaly encoded header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.391 -0500", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "D16B9D80B8A3FF76F7E29D31CF350BD3")
    
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

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.394 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "014FE50D8A9A4F50DCF1C9E31F934432")
    
public void setValue(String value) throws ParseException {
        throw new ParseException (value,0);

    }
    
}

