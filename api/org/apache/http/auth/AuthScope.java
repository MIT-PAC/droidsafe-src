package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

import org.apache.http.util.LangUtils;

public class AuthScope {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.568 -0500", hash_original_field = "A5EEF3672EE4AEEBEA87D2F88BB57B57", hash_generated_field = "D702123867AF990F6D94A9795015E375")

    public static final String ANY_HOST = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.571 -0500", hash_original_field = "ED2A54AEED519AF4AC9D9C01464C74FF", hash_generated_field = "B342D0F622AFA6308B997D5F9CC5C96D")

    public static final int ANY_PORT = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.573 -0500", hash_original_field = "FA6112921FE0969A0856947CB395C36D", hash_generated_field = "4FF0C9DE993EF66ABB8920A251A0BCFA")

    public static final String ANY_REALM = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.577 -0500", hash_original_field = "9330F67D0AD3A43442C7675E4AB52448", hash_generated_field = "24A3DF5B5E858CFA3B8D1432195721A1")

    public static final String ANY_SCHEME = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.579 -0500", hash_original_field = "54AC13CECEC66984A987BCF372099C6A", hash_generated_field = "77020956665DD00DF81FBCE72560DA45")

    public static final AuthScope ANY = new AuthScope(ANY_HOST, ANY_PORT, ANY_REALM, ANY_SCHEME);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.582 -0500", hash_original_field = "AF5A968572CEFDCD6FE22E7345201E0B", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

    private  String scheme;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.584 -0500", hash_original_field = "00F291C913146128BACCE631F6C1551D", hash_generated_field = "423219CE3C0BBAF771E5E09A9E9F4AB6")

    private  String realm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.587 -0500", hash_original_field = "3EBF9FC23C14AE1E55EAA4D77C46C987", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private  String host;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.590 -0500", hash_original_field = "5A948EF636511EF149269A68FE278AED", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private  int port;
        
    /** Creates a new credentials scope for the given 
     * <tt>host</tt>, <tt>port</tt>, <tt>realm</tt>, and 
     * <tt>authentication scheme</tt>.
     * 
     * @param host the host the credentials apply to. May be set
     *   to <tt>null</tt> if credenticals are applicable to
     *   any host. 
     * @param port the port the credentials apply to. May be set
     *   to negative value if credenticals are applicable to
     *   any port. 
     * @param realm the realm the credentials apply to. May be set 
     *   to <tt>null</tt> if credenticals are applicable to
     *   any realm. 
     * @param scheme the authentication scheme the credentials apply to. 
     *   May be set to <tt>null</tt> if credenticals are applicable to
     *   any authentication scheme. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.592 -0500", hash_original_method = "DA242C23FF99C9B0BDF7227FEE464070", hash_generated_method = "3CBB7DDB76DB05FA8A66E3DEA0C7FF6C")
    
public AuthScope(final String host, int port, 
        final String realm, final String scheme)
    {
        this.host =   (host == null)   ? ANY_HOST: host.toLowerCase(Locale.ENGLISH);
        this.port =   (port < 0)       ? ANY_PORT: port;
        this.realm =  (realm == null)  ? ANY_REALM: realm;
        this.scheme = (scheme == null) ? ANY_SCHEME: scheme.toUpperCase(Locale.ENGLISH);
    }
    
    /** Creates a new credentials scope for the given 
     * <tt>host</tt>, <tt>port</tt>, <tt>realm</tt>, and any
     * authentication scheme.
     * 
     * @param host the host the credentials apply to. May be set
     *   to <tt>null</tt> if credenticals are applicable to
     *   any host. 
     * @param port the port the credentials apply to. May be set
     *   to negative value if credenticals are applicable to
     *   any port. 
     * @param realm the realm the credentials apply to. May be set 
     *   to <tt>null</tt> if credenticals are applicable to
     *   any realm. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.595 -0500", hash_original_method = "C3D4A92B6459D8B60217C4D554CBE13A", hash_generated_method = "1D376316D1205516ABEA16C475D4BC2B")
    
public AuthScope(final String host, int port, final String realm) {
        this(host, port, realm, ANY_SCHEME);
    }
    
    /** Creates a new credentials scope for the given 
     * <tt>host</tt>, <tt>port</tt>, any realm name, and any
     * authentication scheme.
     * 
     * @param host the host the credentials apply to. May be set
     *   to <tt>null</tt> if credenticals are applicable to
     *   any host. 
     * @param port the port the credentials apply to. May be set
     *   to negative value if credenticals are applicable to
     *   any port. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.598 -0500", hash_original_method = "00099B5ABB2589DBB04B6BC1AD6C4CF5", hash_generated_method = "75BA9D77046CF6409D4CBE0F95B882A5")
    
public AuthScope(final String host, int port) {
        this(host, port, ANY_REALM, ANY_SCHEME);
    }
    
    /** 
     * Creates a copy of the given credentials scope.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.601 -0500", hash_original_method = "20C18D8617332347FA916FFE36E3E911", hash_generated_method = "7E2AC3F4E75A651E0CFEEF3C2B877105")
    
public AuthScope(final AuthScope authscope) {
        super();
        if (authscope == null) {
            throw new IllegalArgumentException("Scope may not be null");
        }
        this.host = authscope.getHost();
        this.port = authscope.getPort();
        this.realm = authscope.getRealm();
        this.scheme = authscope.getScheme();
    }
    
    /**
     * @return the host
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.603 -0500", hash_original_method = "052AA62CF2AFB76178CB036EF4B7BAB4", hash_generated_method = "C50FCE23852EDA3AF845FEC4AC445DA3")
    
public String getHost() {
        return this.host;
    }

    /**
     * @return the port
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.605 -0500", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "2827709310D4A6354CC4E0B95B5C1D5F")
    
public int getPort() {
        return this.port;
    }

    /**
     * @return the realm name
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.607 -0500", hash_original_method = "5D06D5B53E6C13036F29936602C7EB58", hash_generated_method = "06A1CF67AE4C3AB70EB62E8D95F7D3D9")
    
public String getRealm() {
        return this.realm;
    }

    /**
     * @return the scheme type
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.609 -0500", hash_original_method = "76031D31C1CA528B8F038117D6808811", hash_generated_method = "8C187E31064D5FC7E4CBD4735C1E35F0")
    
public String getScheme() {
        return this.scheme;
    }

    /**
     * Tests if the authentication scopes match. 
     * 
     * @return the match factor. Negative value signifies no match. 
     *    Non-negative signifies a match. The greater the returned value 
     *    the closer the match.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.613 -0500", hash_original_method = "1AE5BF6F5B5937D7D318302FFD2D6934", hash_generated_method = "2017076DD1149CD12BD726DA5A426F75")
    
public int match(final AuthScope that) {
        int factor = 0;
        if (LangUtils.equals(this.scheme, that.scheme)) {
            factor += 1;
        } else {
            if (this.scheme != ANY_SCHEME && that.scheme != ANY_SCHEME) {
                return -1;
            }
        }
        if (LangUtils.equals(this.realm, that.realm)) {
            factor += 2;
        } else {
            if (this.realm != ANY_REALM && that.realm != ANY_REALM) {
                return -1;
            }
        }
        if (this.port == that.port) {
            factor += 4;
        } else {
            if (this.port != ANY_PORT && that.port != ANY_PORT) {
                return -1;
            }
        }
        if (LangUtils.equals(this.host, that.host)) {
            factor += 8;
        } else {
            if (this.host != ANY_HOST && that.host != ANY_HOST) {
                return -1;
            }
        }
        return factor;
    }

    /**
     * @see java.lang.Object#equals(Object)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.615 -0500", hash_original_method = "DED1E319CFFFF5B0653C6B0D046D4EB9", hash_generated_method = "DC363FAEAD00A731377147419762C4AD")
    
@Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof AuthScope)) {
            return super.equals(o);
        }
        AuthScope that = (AuthScope) o;
        return 
        LangUtils.equals(this.host, that.host) 
          && this.port == that.port
          && LangUtils.equals(this.realm, that.realm)
          && LangUtils.equals(this.scheme, that.scheme);
    }

    /**
     * @see java.lang.Object#toString()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.618 -0500", hash_original_method = "AA52C08879A8120A7A68C6044F6A755A", hash_generated_method = "30AE26B8763C7672EA6ED3EAF23EED6C")
    
@Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        if (this.scheme != null) {
            buffer.append(this.scheme.toUpperCase(Locale.ENGLISH));
            buffer.append(' ');
        }
        if (this.realm != null) {
            buffer.append('\'');
            buffer.append(this.realm);
            buffer.append('\'');
        } else {
            buffer.append("<any realm>");
        }
        if (this.host != null) {
            buffer.append('@');
            buffer.append(this.host);
            if (this.port >= 0) {
                buffer.append(':');
                buffer.append(this.port);
            }
        }
        return buffer.toString();
    }
    
    /**
     * @see java.lang.Object#hashCode()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.621 -0500", hash_original_method = "5969A15C4BB29A6E888D795486A04627", hash_generated_method = "38FA94DBD3436012B0D8C65177284D73")
    
@Override
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.host);
        hash = LangUtils.hashCode(hash, this.port);
        hash = LangUtils.hashCode(hash, this.realm);
        hash = LangUtils.hashCode(hash, this.scheme);
        return hash;
    }
}

