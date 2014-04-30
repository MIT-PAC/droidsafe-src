package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.HostPort;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.parser.Parser;

import java.text.ParseException;

import javax.sip.header.FromHeader;

public final class From extends AddressParametersHeader implements javax.sip.header.FromHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.044 -0500", hash_original_field = "A6DB7A44F7E7A7BE19A33A449E86AF2D", hash_generated_field = "7ED5DA8E48C4652B9F8E070E997B9D31")

    private static final long serialVersionUID = -6312727234330643892L;

    /** Default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.047 -0500", hash_original_method = "A8AF16A2B82DF0D28539600E0CD03867", hash_generated_method = "899EB84ED191678A55E747A0C61E3112")
    
public From() {
        super(NAME);
    }

    /** Generate a FROM header from a TO header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.050 -0500", hash_original_method = "DD530C3FC2E9C76342F91D9F2F4B8C8E", hash_generated_method = "D620273F7B152F7D8EE0967C6F534CE4")
    
public From(To to) {
        super(NAME);
        address = to.address;
        parameters = to.parameters;
    }

    /**
     * Encode the header content into a String.
     *
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.053 -0500", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "BBFCFD2AD6BD270AD38D8FE87FD0572B")
    
protected String encodeBody() {
        return encodeBody(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.057 -0500", hash_original_method = "27E6A85D53E8FED6E5ECB6F24D4DAAA6", hash_generated_method = "EB806B97F0789C11630B55200487A7C3")
    
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
            parameters.encode(buffer);
        }
        return buffer;
    }

    /**
     * Conveniance accessor function to get the hostPort field from the address.
     * Warning -- this assumes that the embedded URI is a SipURL.
     *
     * @return hostport field
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.060 -0500", hash_original_method = "44C2A950FA90F046EF96B0A5F25DEA38", hash_generated_method = "F596BC5BA68B5CC2EC3CBFF9B1755A33")
    
public HostPort getHostPort() {
        return address.getHostPort();
    }

    /**
     * Get the display name from the address.
     * @return Display name
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.064 -0500", hash_original_method = "0AF5B36A8F5D506032669B65B9CFDD39", hash_generated_method = "00EBF039D8E78F649651183BA6D3C490")
    
public String getDisplayName() {
        return address.getDisplayName();
    }

    /**
     * Get the tag parameter from the address parm list.
     * @return tag field
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.067 -0500", hash_original_method = "2057D1C8F1E8BB8C55512212A4FDB01D", hash_generated_method = "9945763A633BC90164CA1E50733EA0E1")
    
public String getTag() {
        if (parameters == null)
            return null;
        return getParameter(ParameterNames.TAG);
    }

    /** Boolean function
     * @return true if the Tag exist
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.070 -0500", hash_original_method = "17DACA856A7B157094F93A364689CD76", hash_generated_method = "5FEE795E274CE971D1548A2E27611C70")
    
public boolean hasTag() {
        return hasParameter(ParameterNames.TAG);
    }

    /** remove Tag member
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.073 -0500", hash_original_method = "6CBAE502E931683D712FFCD149457FE9", hash_generated_method = "AEA9EF3D50FD5C61970AB9102DFCAECA")
    
public void removeTag() {
        parameters.delete(ParameterNames.TAG);
    }

    /**
     * Set the address member
     * @param address Address to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.076 -0500", hash_original_method = "2BC13538206715D5DC8E4E386607DAE6", hash_generated_method = "7CB616AD61728605D303C8C9C5C31DE1")
    
public void setAddress(javax.sip.address.Address address) {
        this.address = (AddressImpl) address;
    }

    /**
     * Set the tag member
     * @param t tag to set. From tags are mandatory.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.079 -0500", hash_original_method = "8317B37B8D85C50DB928305D5320BE87", hash_generated_method = "0C6257D2CFC36163BA311F48058932FF")
    
public void setTag(String t) throws ParseException {
        // JvB: check that it is a valid token
        Parser.checkToken(t);
        this.setParameter(ParameterNames.TAG, t);
    }

    /** Get the user@host port string.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.082 -0500", hash_original_method = "37555C718EB6A285C8BC30DC0A9F7E97", hash_generated_method = "FF62FFC9174490B7EC3222717FBC762B")
    
public String getUserAtHostPort() {
        return address.getUserAtHostPort();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.085 -0500", hash_original_method = "C3BE149D6ECB953ABC4DB66247B816D2", hash_generated_method = "8586D6FF257803C0F8A46ED14DA2DCAC")
    
public boolean equals(Object other) {
        return (other instanceof FromHeader) && super.equals(other);
    }
}

