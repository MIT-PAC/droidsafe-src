package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.HostPort;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.parser.Parser;

import java.text.ParseException;

import javax.sip.header.ToHeader;

public final class To extends AddressParametersHeader implements javax.sip.header.ToHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.629 -0500", hash_original_field = "BCB305DCC140369E76ADF6A37B48EF9D", hash_generated_field = "4A9712AFAA43552733CBA4D2014F2688")

    private static final long serialVersionUID = -4057413800584586316L;

    /**
     * default Constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.634 -0500", hash_original_method = "7CFB3ABB21EF244A9FD6E54AD9CC5173", hash_generated_method = "4828F1DE18A86B8D31FB2CBCD9275ED5")
    
public To() {
        super(TO,true);
    }

    /**
     * Generate a TO header from a FROM header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.639 -0500", hash_original_method = "10EA715D50A25194DE35700E69984D3D", hash_generated_method = "CDD45A112A925D806458FA23F19EB086")
    
public To(From from) {
        super(TO);
        setAddress(from.address);
        setParameters(from.parameters);
    }

    /**
     * Encode the header into a String.
     *
     * @since 1.0
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.643 -0500", hash_original_method = "DA29AB595B7A4A125EF99100FA337502", hash_generated_method = "EB7FE71751A7FA292A28A3D6E4687565")
    
public String encode() {
        return headerName + COLON + SP + encodeBody() + NEWLINE;
    }

    /**
     * Encode the header content into a String.
     *
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.649 -0500", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "BBFCFD2AD6BD270AD38D8FE87FD0572B")
    
protected String encodeBody() {
        return encodeBody(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.653 -0500", hash_original_method = "6379DF107AEAFFCF06677344FE0DDDB5", hash_generated_method = "932257641A19D2FD850F5F0B874FA342")
    
protected StringBuffer encodeBody(StringBuffer buffer) {
        if (address != null) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.658 -0500", hash_original_method = "465066D205BCB0CD35C4F9A4E5087389", hash_generated_method = "90E5A59A06C0924D7B9CB5E9EC6FC0CB")
    
public HostPort getHostPort() {
        if (address == null)
            return null;
        return address.getHostPort();
    }

    /**
     * Get the display name from the address.
     *
     * @return Display name
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.662 -0500", hash_original_method = "3C83E52D0C85786FBC54CBD0510A4886", hash_generated_method = "6818546234C420EFC6B2CAD2241ADBCC")
    
public String getDisplayName() {
        if (address == null)
            return null;
        return address.getDisplayName();
    }

    /**
     * Get the tag parameter from the address parm list.
     *
     * @return tag field
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.666 -0500", hash_original_method = "2057D1C8F1E8BB8C55512212A4FDB01D", hash_generated_method = "9945763A633BC90164CA1E50733EA0E1")
    
public String getTag() {
        if (parameters == null)
            return null;
        return getParameter(ParameterNames.TAG);

    }

    /**
     * Boolean function
     *
     * @return true if the Tag exist
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.671 -0500", hash_original_method = "DE9D34178B7493C9CBB9357375B774A4", hash_generated_method = "5CDCFD1DE90C9FD3F8E244657445913A")
    
public boolean hasTag() {
        if (parameters == null)
            return false;
        return hasParameter(ParameterNames.TAG);

    }

    /**
     * remove Tag member
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.676 -0500", hash_original_method = "EECFB5B736A479D5AC464F374A1DB439", hash_generated_method = "B7F78D9D6D58D321E732A0E021694A65")
    
public void removeTag() {
            if (parameters != null)
                parameters.delete(ParameterNames.TAG);

    }

    /**
     * Set the tag member. This should remain empty for the initial request in
     * a dialog.
     *
     * @param t - tag String to set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.680 -0500", hash_original_method = "8317B37B8D85C50DB928305D5320BE87", hash_generated_method = "0C6257D2CFC36163BA311F48058932FF")
    
public void setTag(String t) throws ParseException {
        // JvB: check that it is a valid token
        Parser.checkToken(t);
        this.setParameter(ParameterNames.TAG, t);
    }

    /**
     * Get the user@host port string.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.684 -0500", hash_original_method = "ED5A65C9FFE9E87462C7980633990418", hash_generated_method = "4769D39B7038AC11EDF2E88B688F79BE")
    
public String getUserAtHostPort() {
        if (address == null)
            return null;
        return address.getUserAtHostPort();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.688 -0500", hash_original_method = "A8E3E290BA3A80BEE74A86D8FFE8EF4A", hash_generated_method = "0E453414A7A0023E449D3188EF9C1868")
    
public boolean equals(Object other) {
        return toTaintBoolean(toTaintInt(other instanceof ToHeader) + getTaintInt() + other.getTaintInt());
    }
}

