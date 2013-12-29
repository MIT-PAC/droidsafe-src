package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.ims.WWWAuthenticateHeaderIms;

import javax.sip.address.URI;
import javax.sip.header.WWWAuthenticateHeader;






public class WWWAuthenticate extends AuthenticationHeader implements WWWAuthenticateHeader, WWWAuthenticateHeaderIms {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.851 -0500", hash_original_field = "6F5A2526EE94A9827536BD8029A62CE8", hash_generated_field = "DB4C47D141CA98A5189ECDA08C3E0BC7")

    private static final long serialVersionUID = 115378648697363486L;

    /**
     * Default Constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.852 -0500", hash_original_method = "C9FB367FC796E0822ABA8EEBFAE5F2CF", hash_generated_method = "057E821B1D76403A27A40A2FEAB47EEB")
    public WWWAuthenticate() {
        super(NAME);
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.AuthenticationHeader#getURI()
     *
     * @since 1.2 this method is deprecated, uri is not a valid paramter for this header
     * Fail silently for backwards compatibility
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.853 -0500", hash_original_method = "415F36F94D5D5AF0B0B417563353646C", hash_generated_method = "9CD9E8CBB3E8DE9C3106F82ACE4168F0")
    public URI getURI() {
        return null;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.AuthenticationHeader#setURI(javax.sip.address.URI)
     *
     * @since 1.2 this method is deprecated, uri is not a valid paramter for this header
     * Fail silently for backwards compatibility
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.854 -0500", hash_original_method = "4B2EBAFE6DAB8E15456CC1135D4262EB", hash_generated_method = "A689FA9B74FE57B530103C2D77990F19")
    public void setURI(URI uri) {
        // empty, fail silently
    }
}

