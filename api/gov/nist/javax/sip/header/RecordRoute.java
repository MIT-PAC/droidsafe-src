package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.AddressImpl;





public class RecordRoute extends AddressParametersHeader implements javax.sip.header.RecordRouteHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.745 -0500", hash_original_field = "0CC8C4545E3BD3FC39865092180091DE", hash_generated_field = "E1824FFE4050EC4E12856745910C83B9")

    private static final long serialVersionUID = 2388023364181727205L;

    /**
     * constructor
     * @param address address to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.748 -0500", hash_original_method = "1784D193E15A9C55742286FE08847141", hash_generated_method = "68762B3923E88A894D1DBB8B8DE01A1E")
    
public RecordRoute(AddressImpl address) {
        super(NAME);
        this.address = address;
    }

    /**
     * default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.751 -0500", hash_original_method = "F63822F670C4D20D985D1B2C470568FD", hash_generated_method = "17F61CC6B71508A7BB61DE330A2E0A08")
    
public RecordRoute() {
        super(RECORD_ROUTE);

    }

    /** Encode into canonical form.
     *@return String containing the canonicaly encoded header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.753 -0500", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "74B066602ECC20A74FD97E770D65E8BD")
    
public String encodeBody() {
        return encodeBody(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.757 -0500", hash_original_method = "1F2E3BF90793586E89EB2C500039787C", hash_generated_method = "D688FF255C0C6D223FE1C295ADDB811F")
    
protected StringBuffer encodeBody(StringBuffer buffer) {
        if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            buffer.append(LESS_THAN);
        }
        address.encode(buffer);
        if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            buffer.append(GREATER_THAN);
        }

        if (!parameters.isEmpty()) {
            buffer.append(SEMICOLON);
            this.parameters.encode(buffer);
        }
        return buffer;
    }
}

