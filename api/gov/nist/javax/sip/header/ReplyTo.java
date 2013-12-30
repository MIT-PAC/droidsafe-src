package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.HostPort;
import gov.nist.javax.sip.address.AddressImpl;

import javax.sip.header.ReplyToHeader;






public final class ReplyTo extends AddressParametersHeader implements ReplyToHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.378 -0500", hash_original_field = "3A5B4FE5B18CE7B5DAE5AAAFFDB6AD99", hash_generated_field = "236E3B2333C15B09CBC94B2F5B379AB6")

    private static final long serialVersionUID = -9103698729465531373L;

    /** Default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.381 -0500", hash_original_method = "39A6C3CE738448740A75D288CF2B6517", hash_generated_method = "215C0EB654E39530A8A56A4BBF05A692")
    
public ReplyTo() {
        super(NAME);
    }

    /** Default constructor given an address.
     *
     *@param address -- address of this header.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.384 -0500", hash_original_method = "FAB557ADCBC2DA51C11496316EFDCBFF", hash_generated_method = "F600F35BBABEE3B678FE2707B34999FC")
    
public ReplyTo(AddressImpl address) {
        super(NAME);
        this.address = address;
    }

    /**
     * Encode the header into a String.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.387 -0500", hash_original_method = "DA29AB595B7A4A125EF99100FA337502", hash_generated_method = "EB7FE71751A7FA292A28A3D6E4687565")
    
public String encode() {
        return headerName + COLON + SP + encodeBody() + NEWLINE;
    }

    /**
     * Encode the header content into a String.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.390 -0500", hash_original_method = "248CC4EEE70871BA210925CAD15B2704", hash_generated_method = "2D09E4D3F3C30F555B778BB8390517E8")
    
public String encodeBody() {
        String retval = "";
        if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            retval += LESS_THAN;
        }
        retval += address.encode();
        if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            retval += GREATER_THAN;
        }
        if (!parameters.isEmpty()) {
            retval += SEMICOLON + parameters.encode();
        }
        return retval;
    }

    /**
     * Conveniance accessor function to get the hostPort field from the address
     * @return HostPort
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.393 -0500", hash_original_method = "44C2A950FA90F046EF96B0A5F25DEA38", hash_generated_method = "F596BC5BA68B5CC2EC3CBFF9B1755A33")
    
public HostPort getHostPort() {
        return address.getHostPort();
    }

    /**
     * Get the display name from the address.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.396 -0500", hash_original_method = "0AF5B36A8F5D506032669B65B9CFDD39", hash_generated_method = "00EBF039D8E78F649651183BA6D3C490")
    
public String getDisplayName() {
        return address.getDisplayName();
    }
}

