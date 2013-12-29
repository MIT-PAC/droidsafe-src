package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.address.URI;
import javax.sip.header.ProxyAuthenticateHeader;






public class ProxyAuthenticate extends AuthenticationHeader implements ProxyAuthenticateHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:53.054 -0500", hash_original_field = "E7F54878DCE0AAC522CC5C0A23B21F1D", hash_generated_field = "08ABAB95072FCF7B3E4A2200DCD67ACD")

    private static final long serialVersionUID = 3826145955463251116L;

    /**
     * Default Constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:53.055 -0500", hash_original_method = "B80D256AA9E947492E2C0A1F4B8ED695", hash_generated_method = "D3A7B8A928A18C52D613156AA542DCD4")
    public ProxyAuthenticate() {
        super(NAME);
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.AuthenticationHeader#getURI()
     *
     * @since 1.2 this method is deprecated, uri is not a valid paramter for this header
     * Fail silently for backwards compatibility
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:53.056 -0500", hash_original_method = "415F36F94D5D5AF0B0B417563353646C", hash_generated_method = "9CD9E8CBB3E8DE9C3106F82ACE4168F0")
    public URI getURI() {
        return null;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.AuthenticationHeader#setURI(javax.sip.address.URI)
     *
     * @since 1.2 this method is deprecated, uri is not a valid paramter for this header
     * Fail silently for backwards compatibility
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:53.057 -0500", hash_original_method = "4B2EBAFE6DAB8E15456CC1135D4262EB", hash_generated_method = "A689FA9B74FE57B530103C2D77990F19")
    public void setURI(URI uri) {
        // empty, fail silently
    }
}

