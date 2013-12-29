package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.AddressImpl;





public final class ReferTo extends AddressParametersHeader implements javax.sip.header.ReferToHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:53.823 -0500", hash_original_field = "74B5FA62F74F424393A547ACF12A4F0F", hash_generated_field = "F4CFDA8E2513677F950180F2D0A8DF68")

    private static final long serialVersionUID = -1666700428440034851L;

    /** default Constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:53.824 -0500", hash_original_method = "3600BA21C1DE3615470645CB07A3B945", hash_generated_method = "6124093DDFC9F10B0F3A8F5F595CE287")
    public ReferTo() {
        super(NAME);
    }

    /**
     * Encode the header content into a String.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:53.825 -0500", hash_original_method = "264DF371DD142B0CCD6F6ECE44A7BFB6", hash_generated_method = "293E3E92EE6F12C01ED80607A408DDB1")
    protected String encodeBody() {
        if (address == null)
            return null;
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
}

