package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.AddressImpl;

import javax.sip.header.RouteHeader;

public class Route extends AddressParametersHeader implements javax.sip.header.RouteHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.656 -0500", hash_original_field = "F8DC85A0AD0D626F0F9A280EED3C4B95", hash_generated_field = "CDE0CEB85AD3435FE4139286512ECD09")

    private static final long serialVersionUID = 5683577362998368846L;

    /** Default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.660 -0500", hash_original_method = "B9CE287F547A57CF29833C977E422F42", hash_generated_method = "E7DDB49436889CB1A25CF544B2324647")
    
public Route() {
        super(NAME);
    }

    /** Default constructor given an address.
     *
     *@param address -- address of this header.
     *
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.663 -0500", hash_original_method = "D97B9DA75E98466FFB5CFE28F884D630", hash_generated_method = "8DB8B4D4C9DA5D2E6A4D48FEEE0032DA")
    
public Route(AddressImpl address) {
        super(NAME);
        this.address = address;
    }

    /**
     * Hashcode so this header can be inserted into a set.
     *
     *@return the hashcode of the encoded address.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.666 -0500", hash_original_method = "42825E09BC1306330D357AEB56059051", hash_generated_method = "3039FDC69ACED93BB6E674CC45E0D9B3")
    
public int hashCode() {
        return this.address.getHostPort().encode().toLowerCase().hashCode();
    }

    /**
     * Encode into canonical form.
     * Acknowledgement: contains a bug fix for a bug reported by
     * Laurent Schwizer
     *
     *@return a canonical encoding of the header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.669 -0500", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "74B066602ECC20A74FD97E770D65E8BD")
    
public String encodeBody() {
        return encodeBody(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.672 -0500", hash_original_method = "2891D97F5EA93E20B16E0A9272FB4B2C", hash_generated_method = "815335E1664AB3D6D6D0841CC89652D9")
    
protected StringBuffer encodeBody(StringBuffer buffer) {
        boolean addrFlag = address.getAddressType() == AddressImpl.NAME_ADDR;
        if (!addrFlag) {
            buffer.append('<');
            address.encode(buffer);
            buffer.append('>');
        } else {
            address.encode(buffer);
        }
        if (!parameters.isEmpty()) {
            buffer.append(SEMICOLON);
            parameters.encode(buffer);
        }
        return buffer;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.676 -0500", hash_original_method = "53DB62040F48266C1BBF2CE5E963ACD1", hash_generated_method = "2FF666C4833E6ABC53B065B9BD0A5DF9")
    
public boolean equals(Object other) {
        return (other instanceof RouteHeader) && super.equals(other);
    }
}

