package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Locale;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.LangUtils;

public final class HttpHost implements Cloneable {
    public static final String DEFAULT_SCHEME_NAME = "http";
    protected final String hostname;
    protected final String lcHostname;
    protected final int port;
    protected final String schemeName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.025 -0400", hash_original_method = "3BB513ACF90DB4E8549AF0CC3A6C9663", hash_generated_method = "D8D73746F7696D012F271AD562BD1ACD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpHost(final String hostname, int port, final String scheme) {
        super();
        dsTaint.addTaint(port);
        dsTaint.addTaint(scheme);
        dsTaint.addTaint(hostname);
        {
            throw new IllegalArgumentException("Host name may not be null");
        } //End block
        this.lcHostname = hostname.toLowerCase(Locale.ENGLISH);
        {
            this.schemeName = scheme.toLowerCase(Locale.ENGLISH);
        } //End block
        {
            this.schemeName = DEFAULT_SCHEME_NAME;
        } //End block
        // ---------- Original Method ----------
        //if (hostname == null) {
            //throw new IllegalArgumentException("Host name may not be null");
        //}
        //this.hostname   = hostname;
        //this.lcHostname = hostname.toLowerCase(Locale.ENGLISH);
        //if (scheme != null) {
            //this.schemeName = scheme.toLowerCase(Locale.ENGLISH);
        //} else {
            //this.schemeName = DEFAULT_SCHEME_NAME;
        //}
        //this.port = port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.025 -0400", hash_original_method = "6AFEA0EBFC8A407A29450DC5B1D95F74", hash_generated_method = "7C28B638CD78DF374ACFEC1B28CA56C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpHost(final String hostname, int port) {
        this(hostname, port, null);
        dsTaint.addTaint(port);
        dsTaint.addTaint(hostname);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.025 -0400", hash_original_method = "9E22BC6A820AFDDBFC5B86A2EC17A27A", hash_generated_method = "C2E625E395A0DA20507B28A201D76781")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpHost(final String hostname) {
        this(hostname, -1, null);
        dsTaint.addTaint(hostname);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.025 -0400", hash_original_method = "C44D4CD5D948E031A838C102F3C3F056", hash_generated_method = "83180FD7EABD2CBD6CA612233C89A40D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpHost(final HttpHost httphost) {
        this(httphost.hostname, httphost.port, httphost.schemeName);
        dsTaint.addTaint(httphost.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.025 -0400", hash_original_method = "FF0006634ABBE2C97788D559B23C884A", hash_generated_method = "BD6A31CAD43AB1B61F38DC11FB2F84A5")
    @DSModeled(DSC.SAFE)
    public String getHostName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.hostname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.025 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "0DE7CFBC08BEC3A0B2068FD7D05676CF")
    @DSModeled(DSC.SAFE)
    public int getPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.025 -0400", hash_original_method = "C6F0B2E3DB0F6FEAB7513E486FF6DA80", hash_generated_method = "7F454F50079BF8A01BA0FB3408A91459")
    @DSModeled(DSC.SAFE)
    public String getSchemeName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.schemeName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.025 -0400", hash_original_method = "FE8B35DF3D2B1A5F77A96BBF48284914", hash_generated_method = "D8445500352CD17D23DF3C8D560F4D4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toURI() {
        CharArrayBuffer buffer;
        buffer = new CharArrayBuffer(32);
        buffer.append(this.schemeName);
        buffer.append("://");
        buffer.append(this.hostname);
        {
            buffer.append(':');
            buffer.append(Integer.toString(this.port));
        } //End block
        String varAD28D02EB1C6982A5710D014292E1955_1236385091 = (buffer.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.026 -0400", hash_original_method = "6DDBCACEAF7453CD975901EB7FA152DA", hash_generated_method = "5E89395BB3CC42AE595F231DC2F790E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toHostString() {
        CharArrayBuffer buffer;
        buffer = new CharArrayBuffer(32);
        buffer.append(this.hostname);
        {
            buffer.append(':');
            buffer.append(Integer.toString(this.port));
        } //End block
        String varAD28D02EB1C6982A5710D014292E1955_867749765 = (buffer.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //CharArrayBuffer buffer = new CharArrayBuffer(32);
        //buffer.append(this.hostname);
        //if (this.port != -1) {
            //buffer.append(':');
            //buffer.append(Integer.toString(this.port));
        //}
        //return buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.026 -0400", hash_original_method = "C17018EEDA4C922BB5D288F6A26A7D04", hash_generated_method = "236D32C26EBE80FB17491917D6FCFB1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var7847BF486FD16069EFC78DA90F571C4E_526601754 = (toURI());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return toURI();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.026 -0400", hash_original_method = "C7D67D79CD52B2E28D96292DEF9F8BD7", hash_generated_method = "E6459F04CF6C518DB2F8DDFC851B3351")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(final Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            HttpHost that;
            that = (HttpHost) obj;
            boolean varE7D414753A20D356FCE7EE06F85D327D_476890472 = (this.lcHostname.equals(that.lcHostname) 
                && this.port == that.port
                && this.schemeName.equals(that.schemeName));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (obj == null) return false;
        //if (this == obj) return true;
        //if (obj instanceof HttpHost) {
            //HttpHost that = (HttpHost) obj;
            //return this.lcHostname.equals(that.lcHostname) 
                //&& this.port == that.port
                //&& this.schemeName.equals(that.schemeName);
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.026 -0400", hash_original_method = "148EB8E2858B696FB463985EE3E49929", hash_generated_method = "B968F27220BB57D31553FFF3397095FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        int hash;
        hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.lcHostname);
        hash = LangUtils.hashCode(hash, this.port);
        hash = LangUtils.hashCode(hash, this.schemeName);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int hash = LangUtils.HASH_SEED;
        //hash = LangUtils.hashCode(hash, this.lcHostname);
        //hash = LangUtils.hashCode(hash, this.port);
        //hash = LangUtils.hashCode(hash, this.schemeName);
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.026 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "5200832C3C1E0384169B789E13F0C351")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() throws CloneNotSupportedException {
        Object var234434AAD2BC7C43140CB7A97B63D24C_281249487 = (super.clone());
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}


