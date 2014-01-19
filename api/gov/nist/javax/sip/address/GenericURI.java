package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.address.URI;

public class GenericURI extends NetObject implements javax.sip.address.URI {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.235 -0500", hash_original_field = "24D4A7F49E816212A3A357A842DB8672", hash_generated_field = "EC361B7FD77B4BC364A1EB7C2877B905")

    private static final long serialVersionUID = 3237685256878068790L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.238 -0500", hash_original_field = "36AA02D68A45D3B9CBE2847D310878F6", hash_generated_field = "EEAFD83E34DAB045B8C66FD91A97048B")

    public static final String SIP = ParameterNames.SIP_URI_SCHEME;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.240 -0500", hash_original_field = "44A27EBA414BFD23572C8CE490FFDB01", hash_generated_field = "D788E10BE3C933BF303C8CC2B6AE6852")

    public static final String SIPS = ParameterNames.SIPS_URI_SCHEME;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.243 -0500", hash_original_field = "1C5934BFE5F23C7DCB2FB1E65845505C", hash_generated_field = "B9419126FB04B629003988675563E593")

    public static final String TEL = ParameterNames.TEL_URI_SCHEME;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.246 -0500", hash_original_field = "D104C1337470F36AA025365EB957B7D6", hash_generated_field = "33B083E54AD9AB28718C43BD92A5BF45")

    public static final String POSTDIAL = ParameterNames.POSTDIAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.248 -0500", hash_original_field = "4F833DA0B2EA492F72D2F4DF55E7A6E2", hash_generated_field = "DCED896575F535A60C867F6A2BB7A46D")

    public static final String PHONE_CONTEXT_TAG =
        ParameterNames.PHONE_CONTEXT_TAG;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.252 -0500", hash_original_field = "C6769006DFB5E1A378E4FAA30CA809DE", hash_generated_field = "D9810B9C1A17DB225FD610E39C79F114")

    public static final String ISUB = ParameterNames.ISUB;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.254 -0500", hash_original_field = "34038E5BEFCC81136653C76DB115C017", hash_generated_field = "65F9B05DBA88014AE89FA722A56F2E43")

    public static final String PROVIDER_TAG = ParameterNames.PROVIDER_TAG;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.256 -0500", hash_original_field = "EC8F33E45FD6053217E2485C59DC6361", hash_generated_field = "84466DD07DFFDD9FDE6D988F4E83ECAA")

    protected String uriString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.259 -0500", hash_original_field = "AF5A968572CEFDCD6FE22E7345201E0B", hash_generated_field = "24D7425D6BECD3F5F1DFFA7A7A9931FF")

    protected String scheme;

    /** Consturctor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.261 -0500", hash_original_method = "523B0443B4AA531D1FAD6DE404409AD6", hash_generated_method = "7A397D0EC2365EC6740C8983075150E7")
    
protected GenericURI() {
    }

    /** Constructor given the URI string
     * @param uriString The imbedded URI string.
     * @throws java.net.URISyntaxException When there is a syntaz error in the imbedded URI.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.264 -0500", hash_original_method = "7FD69531AE924D3F151616E62ADFB396", hash_generated_method = "069723F2E26C8C2CF64DB41BF553AB86")
    
public GenericURI(String uriString) throws ParseException {
        try {
            this.uriString = uriString;
            int i = uriString.indexOf(":");
            scheme = uriString.substring(0, i);
        } catch (Exception e) {
            throw new ParseException("GenericURI, Bad URI format", 0);
        }
    }

    /** Encode the URI.
     * @return The encoded URI
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.267 -0500", hash_original_method = "82D33A5986E24A5B49AA621812B7822B", hash_generated_method = "6ACECDECF32D7EA919CE921D804655ED")
    
public String encode() {
        return uriString;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.269 -0500", hash_original_method = "054F173715F55BDEA2A1E3378F0F2AB7", hash_generated_method = "E2B944096D31D338486A284F182BDE62")
    
public StringBuffer encode(StringBuffer buffer) {
        return buffer.append(uriString);
    }

    /** Encode this URI.
     * @return The encoded URI
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.272 -0500", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "0E38B803B5F7EA7FC3B7A952B8C48B78")
    
public String toString() {
        return this.encode();

    }

    /** Returns the value of the "scheme" of
     * this URI, for example "sip", "sips" or "tel".
     *
     * @return the scheme paramter of the URI
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.274 -0500", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "9D11AD0B611F352DC84C8E1A6B825617")
    
public String getScheme() {
        return scheme;
    }

    /** This method determines if this is a URI with a scheme of
     * "sip" or "sips".
     *
     * @return true if the scheme is "sip" or "sips", false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.277 -0500", hash_original_method = "B3806A07425B89767F09A244B77901C0", hash_generated_method = "1D9C5D1987C90B0E55B4B8AC3A9758A5")
    
public boolean isSipURI() {
        return this instanceof SipUri;
    }

    // @Override
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.279 -0500", hash_original_method = "7E429DD6D2D2C657A6046B8560CB3B06", hash_generated_method = "AFC175F8F03CECA339A5C6F7ED193A3C")
    
public boolean equals(Object that) {
        if (this==that) return true;
        else if (that instanceof URI) {
            final URI o = (URI) that;

            // This is not sufficient for equality; revert to String equality...
            // return this.getScheme().equalsIgnoreCase( o.getScheme() )
            return this.toString().equalsIgnoreCase( o.toString() );
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.281 -0500", hash_original_method = "52D4A3951B7E10EC34FBEDB345A7DD44", hash_generated_method = "77DCABADCE7CFE67B38F790E4FA97217")
    
public int hashCode() {
        return this.toString().hashCode();
    }
}

