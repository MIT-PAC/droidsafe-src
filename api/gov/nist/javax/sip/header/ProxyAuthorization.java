package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.ProxyAuthorizationHeader;






public class ProxyAuthorization extends AuthenticationHeader implements ProxyAuthorizationHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:53.535 -0500", hash_original_field = "E834C8FD63A0563AA15EA31AE1CC8E4A", hash_generated_field = "BA6BF9CE8BFECE5A05580B2B32C52A19")

    private static final long serialVersionUID = -6374966905199799098L;

    /** default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:53.536 -0500", hash_original_method = "4D6EF56A1C3453732D0F9A353B9A4089", hash_generated_method = "ABED2B00634C03B09E688587CE8F6409")
    public ProxyAuthorization() {
        super(PROXY_AUTHORIZATION);
    }
}

