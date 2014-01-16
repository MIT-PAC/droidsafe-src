package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SSLParameters {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.150 -0500", hash_original_field = "5634EAE1575A171F6E1026AFC44C93D6", hash_generated_field = "411F1A5A89267DD4FA4546E0300DEE75")

    private String[] cipherSuites;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.153 -0500", hash_original_field = "7D0D65262FBB39DD68DC575C10184699", hash_generated_field = "DC671C4B6787E3B95959CD8B3344C9E7")

    private String[] protocols;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.155 -0500", hash_original_field = "B35FBDEA02B1CB012F402100CF353291", hash_generated_field = "D1808204922229004297FAD1D2005F13")

    private boolean needClientAuth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.157 -0500", hash_original_field = "560610576305DE35A7AB29BAD9BBDF71", hash_generated_field = "3F96E6A31CF0EB182354E75513AE65DF")

    private boolean wantClientAuth;

    /**
     * The default SSLParameters constructor. Cipher suites and
     * protocols are initialized to null and client authentication
     * options are initialized to false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.160 -0500", hash_original_method = "022ED5C9FE213591085C06A06ECFC7AA", hash_generated_method = "D8AAAAD2ED74A48ABFD89E669FBE2085")
    
public SSLParameters() {}

    /**
     * A SSLParameters constructor that allows the values for the
     * initial cipher suites array to be provided. Other values
     * default as specified in {@link #SSLParameters()}.
     *
     * @param cipherSuites An array of cipherSuites that is cloned for
     * use within the SSLParameters, or null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.162 -0500", hash_original_method = "A6B6F0535750EB460CCEE975AE95DC3A", hash_generated_method = "92BB05E0792B49A6FFB723743162333F")
    
public SSLParameters(String[] cipherSuites) {
        setCipherSuites(cipherSuites);
    }

    /**
     * A SSLParameters constructor that allows the values for initial
     * cipher suites and protocols arrays to be provided. Other values
     * default as specified in {@link #SSLParameters()}.
     *
     * @param cipherSuites An array of cipher names that is cloned for
     * use within the SSLParameters, or null.
     * @param protocols An array of protocol names that is cloned for
     * use within the SSLParameters, or null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.165 -0500", hash_original_method = "C1FFBB4FE86E468D8BAF1D7971E89CFD", hash_generated_method = "E4A799B99111282051651E91CC64DCF5")
    
public SSLParameters(String[] cipherSuites,
                         String[] protocols) {
        setCipherSuites(cipherSuites);
        setProtocols(protocols);
    }

    /**
     * Returns a copy of the cipher suites, or null if none have been
     * specified.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.167 -0500", hash_original_method = "4A4F1106EE48461B88F50C671836AAA1", hash_generated_method = "FD30555C3E201135B1513809C5273D60")
    
public String[] getCipherSuites() {
        if (cipherSuites == null) {
            return null;
        }
        return cipherSuites.clone();
    }

    /**
     * Sets the cipher suites to a copy of the input, or null
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.169 -0500", hash_original_method = "9E670D049040F6D0CEE95ADCC5A2BB8E", hash_generated_method = "053B0128F67433F0A151D5CA41C4CC53")
    
public void setCipherSuites(String[] cipherSuites) {
        this.cipherSuites = ((cipherSuites == null)
                             ? null
                             : cipherSuites.clone());
    }

    /**
     * Returns a copy of the protocols, or null if none have been
     * specified.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.171 -0500", hash_original_method = "4DAE6AE8C86EF57BE9BF60BD0F445F08", hash_generated_method = "AB882CCD2AD470372C7D7B261FE0FB8F")
    
public String[] getProtocols() {
        if (protocols == null) {
            return null;
        }
        return protocols.clone();
    }

    /**
     * Sets the protocols to a copy of the input, or null
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.174 -0500", hash_original_method = "EF8F568BAE6FA22D6783DD8D622D3566", hash_generated_method = "0CD6642FB9F05A58166EFC7478C6075B")
    
public void setProtocols(String[] protocols) {
        this.protocols = ((protocols == null)
                             ? null
                             : protocols.clone());
    }

    /**
     * Returns true if a server requires authentication from a client
     * during handshaking. If this returns true, {@link
     * #getWantClientAuth} will return false.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.176 -0500", hash_original_method = "0562A9D6063DDE1E14D46646F3CBBD06", hash_generated_method = "8C7AC36BF0CBD51C2B7ABE20875E1D7E")
    
public boolean getNeedClientAuth () {
        return needClientAuth;
    }

    /**
     * Sets whether or not to a server needs client authentication.
     * After calling this, #getWantClientAuth() will return false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.178 -0500", hash_original_method = "22A4FDEF203263AAF8FD895025373324", hash_generated_method = "615D8D60D0C58231C402751C30B54568")
    
public void setNeedClientAuth (boolean needClientAuth) {
        this.needClientAuth = needClientAuth;
        this.wantClientAuth = false;
    }

    /**
     * Returns true if a server optionally wants to authenticate a
     * client during handshaking. If this returns true, {@link
     * #getNeedClientAuth} will return false.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.180 -0500", hash_original_method = "B012F9400DE611969BC8B2969D6766E0", hash_generated_method = "4FCD8CBF74DFCB44AAAF6A45D8039EDC")
    
public boolean getWantClientAuth () {
        return wantClientAuth;
    }

    /**
     * Sets whether or not to a server wants client authentication.
     * After calling this, #getNeedClientAuth() will return false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.183 -0500", hash_original_method = "363F6F59B4A070AED132C2E96BCCEA5B", hash_generated_method = "B26768A32D4925C9EC0A8ED7629E0AC4")
    
public void setWantClientAuth (boolean wantClientAuth) {
        this.wantClientAuth = wantClientAuth;
        this.needClientAuth = false;
    }
    
}

