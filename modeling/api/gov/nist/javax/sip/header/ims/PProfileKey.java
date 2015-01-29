package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.AddressParametersHeader;

import java.text.ParseException;

import javax.sip.header.ExtensionHeader;

public class PProfileKey extends AddressParametersHeader implements PProfileKeyHeader, SIPHeaderNamesIms, ExtensionHeader {

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.714 -0500", hash_original_method = "62A39FCB1E97FABE3CE56B88DF28D500", hash_generated_method = "E6217F21E92E9525E5A60A2562FACB76")
    
public PProfileKey( ) {
        super(P_PROFILE_KEY);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.718 -0500", hash_original_method = "0A29E597AFEA61D9850CF327C87E8DD7", hash_generated_method = "D0053BEE604BC075CDF51CA20B2ADA3B")
    
public PProfileKey(AddressImpl address)
    {
        super(NAME);
        this.address = address;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.722 -0500", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "8FD50E9E96AB08D1A3DA8220C050A034")
    
@Override
    protected String encodeBody() {

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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.725 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "014FE50D8A9A4F50DCF1C9E31F934432")
    
public void setValue(String value) throws ParseException {
        throw new ParseException(value,0);

    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.730 -0500", hash_original_method = "9C9266054F44A0CD7DB49784A3A7D69D", hash_generated_method = "C8243591D7C5F9DB63E02C49461527A5")
    
public boolean equals(Object other)
    {
        return (other instanceof PProfileKey) && super.equals(other);

    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.733 -0500", hash_original_method = "38197786CF7CEF8229067A4B5205EC8C", hash_generated_method = "68016FA5C18470B1E9D06A907448617C")
    
public Object clone() {
        PProfileKey retval = (PProfileKey) super.clone();
        return retval;
    }
    
}

