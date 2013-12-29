package org.apache.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.LangUtils;






public final class HttpHost implements Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.590 -0500", hash_original_field = "9BF4E3E79F15BE75A8F5E6E2CD7571EC", hash_generated_field = "BC4AB09F492BB8FF3AF2DDEA94F3ED6C")

    public static final String DEFAULT_SCHEME_NAME = "http";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.591 -0500", hash_original_field = "6B66041FD39815DF98C48C22668D1653", hash_generated_field = "A498A0C52EAEC26516CFC120F651D2CE")

    protected  String hostname;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.592 -0500", hash_original_field = "B263AFE63A8DB63DA16BB370A2803C23", hash_generated_field = "21E874C75AB8261C3E938826C2C646D0")

    protected  String lcHostname;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.593 -0500", hash_original_field = "5A948EF636511EF149269A68FE278AED", hash_generated_field = "C021A045CC358C8C262F3483738B3278")

    protected  int port;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.593 -0500", hash_original_field = "55C363940FB6D931F5BB0704D4C8E745", hash_generated_field = "B9EB89391FD6A47F6CAEEA8A1467B77A")

    protected  String schemeName;


    /**
     * Creates a new {@link HttpHost HttpHost}, specifying all values.
     * Constructor for HttpHost.
     *   
     * @param hostname  the hostname (IP or DNS name)
     * @param port      the port number.
     *                  <code>-1</code> indicates the scheme default port.
     * @param scheme    the name of the scheme.
     *                  <code>null</code> indicates the
     *                  {@link #DEFAULT_SCHEME_NAME default scheme}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.595 -0500", hash_original_method = "3BB513ACF90DB4E8549AF0CC3A6C9663", hash_generated_method = "DDB92D1A90B493FCB9963A75CA3795B3")
    public HttpHost(final String hostname, int port, final String scheme) {
        super();
        if (hostname == null) {
            throw new IllegalArgumentException("Host name may not be null");
        }
        this.hostname   = hostname;
        this.lcHostname = hostname.toLowerCase(Locale.ENGLISH);
        if (scheme != null) {
            this.schemeName = scheme.toLowerCase(Locale.ENGLISH);
        } else {
            this.schemeName = DEFAULT_SCHEME_NAME;
        }
        this.port = port;
    }

    /**
     * Creates a new {@link HttpHost HttpHost}, with default scheme.
     *   
     * @param hostname  the hostname (IP or DNS name)
     * @param port      the port number.
     *                  <code>-1</code> indicates the scheme default port.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.595 -0500", hash_original_method = "6AFEA0EBFC8A407A29450DC5B1D95F74", hash_generated_method = "CF02B670CFA2D36CED326D1FA6B98066")
    public HttpHost(final String hostname, int port) {
        this(hostname, port, null);
    }
    
    /**
     * Creates a new {@link HttpHost HttpHost}, with default scheme and port.
     *   
     * @param hostname  the hostname (IP or DNS name)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.596 -0500", hash_original_method = "9E22BC6A820AFDDBFC5B86A2EC17A27A", hash_generated_method = "F5BC021A88F3FDE67745484AFA00A2AC")
    public HttpHost(final String hostname) {
        this(hostname, -1, null);
    }
    
    /**
     * Copy constructor for {@link HttpHost HttpHost}.
     * 
     * @param httphost the HTTP host to copy details from
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.597 -0500", hash_original_method = "C44D4CD5D948E031A838C102F3C3F056", hash_generated_method = "80A317A6D66D882803FBFD1E92B72C9D")
    public HttpHost (final HttpHost httphost) {
        this(httphost.hostname, httphost.port, httphost.schemeName);
    }

    /**
     * Returns the host name.
     * 
     * @return the host name (IP or DNS name)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.598 -0500", hash_original_method = "FF0006634ABBE2C97788D559B23C884A", hash_generated_method = "1990813A386F67A8FC0A02079ED98F7E")
    public String getHostName() {
        return this.hostname;
    }

    /**
     * Returns the port.
     * 
     * @return the host port, or <code>-1</code> if not set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.599 -0500", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "2827709310D4A6354CC4E0B95B5C1D5F")
    public int getPort() {
        return this.port;
    }

    /**
     * Returns the scheme name.
     *
     * @return the scheme name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.600 -0500", hash_original_method = "C6F0B2E3DB0F6FEAB7513E486FF6DA80", hash_generated_method = "CCEA0EC5D17487D4524965A686A7ACE2")
    public String getSchemeName() {
        return this.schemeName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.141 -0400", hash_original_method = "FE8B35DF3D2B1A5F77A96BBF48284914", hash_generated_method = "80451F027FD1B2D488F4621B1F988A16")
    public String toURI() {
        CharArrayBuffer buffer = new CharArrayBuffer(32);
        buffer.append(this.schemeName);
        buffer.append("://");
        buffer.append(this.hostname);
        if(this.port != -1)        
        {
            buffer.append(':');
            buffer.append(Integer.toString(this.port));
        } //End block
String varD03843288D33B9E1D3062E25339ECF6D_30388163 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_30388163.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_30388163;
        // ---------- Original Method ----------
        //CharArrayBuffer buffer = new CharArrayBuffer(32);
        //buffer.append(this.schemeName);
        //buffer.append("://");
        //buffer.append(this.hostname);
        //if (this.port != -1) {
            //buffer.append(':');
            //buffer.append(Integer.toString(this.port));
        //}
        //return buffer.toString();
    }


    /**
     * Obtains the host string, without scheme prefix.
     *
     * @return  the host string, for example <code>localhost:8080</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.601 -0500", hash_original_method = "6DDBCACEAF7453CD975901EB7FA152DA", hash_generated_method = "22695AA06A08FA30FFFAAE4F39AE1461")
    public String toHostString() {
        CharArrayBuffer buffer = new CharArrayBuffer(32);        
        buffer.append(this.hostname);
        if (this.port != -1) {
            buffer.append(':');
            buffer.append(Integer.toString(this.port));
        }
        return buffer.toString();
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.602 -0500", hash_original_method = "C17018EEDA4C922BB5D288F6A26A7D04", hash_generated_method = "BBFC3CB8ED9DDB21B444E0C38EA803A2")
    public String toString() {
        return toURI();
    }    
    

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.603 -0500", hash_original_method = "C7D67D79CD52B2E28D96292DEF9F8BD7", hash_generated_method = "736BF8AEC171F9FBC2FB4CEFF68CDCDD")
    public boolean equals(final Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (obj instanceof HttpHost) {
            HttpHost that = (HttpHost) obj;
            return this.lcHostname.equals(that.lcHostname) 
                && this.port == that.port
                && this.schemeName.equals(that.schemeName);
        } else {
            return false;
        }
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.604 -0500", hash_original_method = "148EB8E2858B696FB463985EE3E49929", hash_generated_method = "5CC230FA866671FEBA01647849308F46")
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.lcHostname);
        hash = LangUtils.hashCode(hash, this.port);
        hash = LangUtils.hashCode(hash, this.schemeName);
        return hash;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.604 -0500", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "587F7AA34F50D42D8C2635621B97F7C1")
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

