package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class Authenticator {

    /**
     * Invokes the methods of the registered
     * authenticator to get the authentication info.
     *
     * @return password authentication info or {@code null} if no authenticator
     *         exists.
     * @param rAddr
     *            address of the connection that requests authentication.
     * @param rPort
     *            port of the connection that requests authentication.
     * @param rProtocol
     *            protocol of the connection that requests authentication.
     * @param rPrompt
     *            realm of the connection that requests authentication.
     * @param rScheme
     *            scheme of the connection that requests authentication.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.381 -0500", hash_original_method = "CADE37F941AEDF2CA8074F527733BC85", hash_generated_method = "C6239C78BBC23A99499107C161EE981F")
    
public static synchronized PasswordAuthentication requestPasswordAuthentication(
            InetAddress rAddr, int rPort, String rProtocol, String rPrompt,
            String rScheme) {
        if (thisAuthenticator == null) {
            return null;
        }
        // set the requester info so it knows what it is requesting
        // authentication for
        thisAuthenticator.addr = rAddr;
        thisAuthenticator.port = rPort;
        thisAuthenticator.protocol = rProtocol;
        thisAuthenticator.prompt = rPrompt;
        thisAuthenticator.scheme = rScheme;
        thisAuthenticator.rt = RequestorType.SERVER;

        // returns the authentication info obtained by the registered
        // Authenticator
        return thisAuthenticator.getPasswordAuthentication();
    }

    /**
     * Sets {@code a} as the default authenticator. It will be called whenever
     * the realm that the URL is pointing to requires authorization.
     *
     * @param a
     *            authenticator which has to be set as default.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.383 -0500", hash_original_method = "424CC0F4D1951D4DFFFEDB35F76EDAF0", hash_generated_method = "FD7965A393E75C031B48B68C9E70E6A0")
    
public static void setDefault(Authenticator a) {
        thisAuthenticator = a;
    }

    /**
     * Invokes the methods of the registered
     * authenticator to get the authentication info.
     *
     * @return password authentication info or {@code null} if no authenticator
     *         exists.
     * @param rHost
     *            host name of the connection that requests authentication.
     * @param rAddr
     *            address of the connection that requests authentication.
     * @param rPort
     *            port of the connection that requests authentication.
     * @param rProtocol
     *            protocol of the connection that requests authentication.
     * @param rPrompt
     *            realm of the connection that requests authentication.
     * @param rScheme
     *            scheme of the connection that requests authentication.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.387 -0500", hash_original_method = "4B8CE254A1E6A8204BDB9A98BF2A6E25", hash_generated_method = "5922B9D38DD29158BE16384EFFF19B76")
    
public static synchronized PasswordAuthentication requestPasswordAuthentication(
            String rHost, InetAddress rAddr, int rPort, String rProtocol,
            String rPrompt, String rScheme) {
        if (thisAuthenticator == null) {
            return null;
        }
        // set the requester info so it knows what it is requesting
        // authentication for
        thisAuthenticator.host = rHost;
        thisAuthenticator.addr = rAddr;
        thisAuthenticator.port = rPort;
        thisAuthenticator.protocol = rProtocol;
        thisAuthenticator.prompt = rPrompt;
        thisAuthenticator.scheme = rScheme;
        thisAuthenticator.rt = RequestorType.SERVER;

        // returns the authentication info obtained by the registered
        // Authenticator
        return thisAuthenticator.getPasswordAuthentication();
    }

    /**
     * Invokes the methods of the registered
     * authenticator to get the authentication info.
     *
     * @return password authentication info or {@code null} if no authenticator
     *         exists.
     * @param rHost
     *            host name of the connection that requests authentication.
     * @param rAddr
     *            address of the connection that requests authentication.
     * @param rPort
     *            port of the connection that requests authentication.
     * @param rProtocol
     *            protocol of the connection that requests authentication.
     * @param rPrompt
     *            realm of the connection that requests authentication.
     * @param rScheme
     *            scheme of the connection that requests authentication.
     * @param rURL
     *            url of the connection that requests authentication.
     * @param reqType
     *            requestor type of the connection that requests authentication.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.392 -0500", hash_original_method = "25D7603D6297D124EA5AA0C2763B256C", hash_generated_method = "ED6264275AC7BADD311204943E5CB9B1")
    
public static PasswordAuthentication requestPasswordAuthentication(
            String rHost, InetAddress rAddr, int rPort, String rProtocol,
            String rPrompt, String rScheme, URL rURL,
            Authenticator.RequestorType reqType) {
        if (thisAuthenticator == null) {
            return null;
        }
        // sets the requester info so it knows what it is requesting
        // authentication for
        thisAuthenticator.host = rHost;
        thisAuthenticator.addr = rAddr;
        thisAuthenticator.port = rPort;
        thisAuthenticator.protocol = rProtocol;
        thisAuthenticator.prompt = rPrompt;
        thisAuthenticator.scheme = rScheme;
        thisAuthenticator.url = rURL;
        thisAuthenticator.rt = reqType;

        // returns the authentication info obtained by the registered
        // Authenticator
        return thisAuthenticator.getPasswordAuthentication();

    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.340 -0500", hash_original_field = "7DF19A1406300A0629E6264A3E049ADD", hash_generated_field = "8E8E0EE210D2CBD416C2EDF43F2EB51A")

    private static Authenticator thisAuthenticator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.343 -0500", hash_original_field = "89C4DBD92A7C11049D6E45F6CB08BF15", hash_generated_field = "0600E962B7B6CE9DE248036206873A5F")

    private static final NetPermission requestPasswordAuthenticationPermission = new NetPermission(
            "requestPasswordAuthentication");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.346 -0500", hash_original_field = "EDDBBE48E58DA24336A50FD25FE39727", hash_generated_field = "21B565F35E37E56DBE475EE1E023C013")

    private static final NetPermission setDefaultAuthenticatorPermission = new NetPermission(
            "setDefaultAuthenticator");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.348 -0500", hash_original_field = "3EBF9FC23C14AE1E55EAA4D77C46C987", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.350 -0500", hash_original_field = "AD87F1710B0BBE13E418BD36FE4E24C7", hash_generated_field = "0B6CE69CF925D6E46B22FFB8B45B7F59")

    private InetAddress addr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.353 -0500", hash_original_field = "5A948EF636511EF149269A68FE278AED", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.356 -0500", hash_original_field = "DE3F28962485CE99CA97D0A480B93596", hash_generated_field = "512C13BA7A4120A610964F395EA31E91")

    private String protocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.358 -0500", hash_original_field = "E39008C8C5530C4D0AB35F720027C03F", hash_generated_field = "73A8FB617E5E6FEE69E01BC210863E4D")

    private String prompt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.360 -0500", hash_original_field = "AF5A968572CEFDCD6FE22E7345201E0B", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

    private String scheme;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.362 -0500", hash_original_field = "D0C59163767519DDC23EEDD08636971F", hash_generated_field = "4E8909F55682E93D265FDB05DA0C8C95")

    private URL url;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.364 -0500", hash_original_field = "6EFED99F32589679AD2AB542684C660F", hash_generated_field = "9714F053F4B331A2C144544CF89DAA37")

    private RequestorType rt;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.275 -0400", hash_original_method = "B4C23A0C6FE3AF9F3FBB3DA6EF5F723C", hash_generated_method = "B4C23A0C6FE3AF9F3FBB3DA6EF5F723C")
    public Authenticator ()
    {
        //Synthesized constructor
    }

    /**
     * Returns the collected username and password for authorization. The
     * subclass has to override this method to return a value different to the
     * default which is {@code null}.
     * <p>
     * Returns {@code null} by default.
     *
     * @return collected password authentication data.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.367 -0500", hash_original_method = "3093C4DCBD758CB1DB7C3B81720996CD", hash_generated_method = "990E67815C527B59AFE038DE5CB758DC")
    
protected PasswordAuthentication getPasswordAuthentication() {
        return null;
    }

    /**
     * Returns the port of the connection that requests authorization.
     *
     * @return port of the connection.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.369 -0500", hash_original_method = "DC9C52EAA515BAD6BDD0FA3590432E35", hash_generated_method = "730ACD6054AF4C272F4E4AF6E4DD8105")
    
protected final int getRequestingPort() {
        return this.port;
    }

    /**
     * Returns the address of the connection that requests authorization or
     * {@code null} if unknown.
     *
     * @return address of the connection.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.371 -0500", hash_original_method = "2B14AF242379C7938332ECF0E248EB1C", hash_generated_method = "CD99276B12DA2C56EDB08C62B35F5E1C")
    
protected final InetAddress getRequestingSite() {
        return this.addr;
    }

    /**
     * Returns the realm (prompt string) of the connection that requests
     * authorization.
     *
     * @return prompt string of the connection.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.374 -0500", hash_original_method = "77C5C0A5F58C3B05E3A20169E90243A2", hash_generated_method = "F074DE81732331E46E74B26DA743590F")
    
protected final String getRequestingPrompt() {
        return this.prompt;
    }

    /**
     * Returns the protocol of the connection that requests authorization.
     *
     * @return protocol of the connection.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.376 -0500", hash_original_method = "0EEBE945906182A6ED15FB53AC64D909", hash_generated_method = "61BF34E8C7F5D453553F6BE074F9A7C7")
    
protected final String getRequestingProtocol() {
        return this.protocol;
    }

    /**
     * Returns the scheme of the connection that requests authorization, for
     * example HTTP Basic Authentication.
     *
     * @return scheme of the connection.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.378 -0500", hash_original_method = "09F9AD99062E3C7EFE932F710107733C", hash_generated_method = "F194417B903B7A98FCCCD4FF971A5E4D")
    
protected final String getRequestingScheme() {
        return this.scheme;
    }
    
    public enum RequestorType {
        PROXY,
        SERVER
    }

    /**
     * Returns the host name of the connection that requests authentication or
     * {@code null} if unknown.
     *
     * @return name of the requesting host or {@code null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.389 -0500", hash_original_method = "8CC1A8E4CE78153F4006F6F40BA275CE", hash_generated_method = "6DC214D91EE00F756D4E801D49E32D71")
    
protected final String getRequestingHost() {
        return host;
    }

    /**
     * Returns the URL of the authentication request.
     *
     * @return authentication request url.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.394 -0500", hash_original_method = "3D575AEF6CE8C91A17FF3C39D0168781", hash_generated_method = "0DD03FD0569DF624B2CEE947408548AB")
    
protected URL getRequestingURL() {
        return url;
    }

    /**
     * Returns the type of this request, it can be {@code PROXY} or {@code SERVER}.
     *
     * @return RequestorType of the authentication request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.397 -0500", hash_original_method = "55F670A5333D0DDAF23FC0CC5542C3C2", hash_generated_method = "F3A6A4027CB8D6A7844043D1B23BA2A8")
    
protected Authenticator.RequestorType getRequestorType() {
        return rt;
    }
}

