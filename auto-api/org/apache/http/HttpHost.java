package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Locale;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.LangUtils;

public final class HttpHost implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.454 -0400", hash_original_field = "0897ACF49C7C1EA9F76EFE59187AA046", hash_generated_field = "A498A0C52EAEC26516CFC120F651D2CE")

    protected String hostname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.454 -0400", hash_original_field = "4B6994488E849D2EABC750D4A1DC0438", hash_generated_field = "21E874C75AB8261C3E938826C2C646D0")

    protected String lcHostname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.454 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "C021A045CC358C8C262F3483738B3278")

    protected int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.455 -0400", hash_original_field = "018FE739B0B3B7545BA70D6D8A1BE0A6", hash_generated_field = "B9EB89391FD6A47F6CAEEA8A1467B77A")

    protected String schemeName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.455 -0400", hash_original_method = "3BB513ACF90DB4E8549AF0CC3A6C9663", hash_generated_method = "7550050F92148A0CFB7E7FBFE848942C")
    public  HttpHost(final String hostname, int port, final String scheme) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Host name may not be null");
        } //End block
        this.hostname   = hostname;
        this.lcHostname = hostname.toLowerCase(Locale.ENGLISH);
        {
            this.schemeName = scheme.toLowerCase(Locale.ENGLISH);
        } //End block
        {
            this.schemeName = DEFAULT_SCHEME_NAME;
        } //End block
        this.port = port;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.457 -0400", hash_original_method = "6AFEA0EBFC8A407A29450DC5B1D95F74", hash_generated_method = "24935D5A997E9A729086469D1EC83238")
    public  HttpHost(final String hostname, int port) {
        this(hostname, port, null);
        addTaint(hostname.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.457 -0400", hash_original_method = "9E22BC6A820AFDDBFC5B86A2EC17A27A", hash_generated_method = "71E490F3361A1782307D755E40D7D695")
    public  HttpHost(final String hostname) {
        this(hostname, -1, null);
        addTaint(hostname.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.457 -0400", hash_original_method = "C44D4CD5D948E031A838C102F3C3F056", hash_generated_method = "2BC334727B51F49C4C42C8286E32572D")
    public  HttpHost(final HttpHost httphost) {
        this(httphost.hostname, httphost.port, httphost.schemeName);
        addTaint(httphost.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.461 -0400", hash_original_method = "FF0006634ABBE2C97788D559B23C884A", hash_generated_method = "C56D1D58D642908380A307893300FEC5")
    public String getHostName() {
        String varB4EAC82CA7396A68D541C85D26508E83_661665323 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_661665323 = this.hostname;
        varB4EAC82CA7396A68D541C85D26508E83_661665323.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_661665323;
        // ---------- Original Method ----------
        //return this.hostname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.472 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "A2C46A8B00CBD7821C838DEEE24AB328")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1604195598 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1604195598;
        // ---------- Original Method ----------
        //return this.port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.472 -0400", hash_original_method = "C6F0B2E3DB0F6FEAB7513E486FF6DA80", hash_generated_method = "73AF872E703D3C5E027CC14EBDEBD57F")
    public String getSchemeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_418849049 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_418849049 = this.schemeName;
        varB4EAC82CA7396A68D541C85D26508E83_418849049.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_418849049;
        // ---------- Original Method ----------
        //return this.schemeName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.473 -0400", hash_original_method = "FE8B35DF3D2B1A5F77A96BBF48284914", hash_generated_method = "C07C65B78449EE745BC6B90520ECDBCC")
    public String toURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_880109197 = null; //Variable for return #1
        CharArrayBuffer buffer;
        buffer = new CharArrayBuffer(32);
        buffer.append(this.schemeName);
        buffer.append("://");
        buffer.append(this.hostname);
        {
            buffer.append(':');
            buffer.append(Integer.toString(this.port));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_880109197 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_880109197.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_880109197;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.478 -0400", hash_original_method = "6DDBCACEAF7453CD975901EB7FA152DA", hash_generated_method = "BA25FD47372648EBCFE4D6B74A1B5164")
    public String toHostString() {
        String varB4EAC82CA7396A68D541C85D26508E83_192262121 = null; //Variable for return #1
        CharArrayBuffer buffer;
        buffer = new CharArrayBuffer(32);
        buffer.append(this.hostname);
        {
            buffer.append(':');
            buffer.append(Integer.toString(this.port));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_192262121 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_192262121.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_192262121;
        // ---------- Original Method ----------
        //CharArrayBuffer buffer = new CharArrayBuffer(32);
        //buffer.append(this.hostname);
        //if (this.port != -1) {
            //buffer.append(':');
            //buffer.append(Integer.toString(this.port));
        //}
        //return buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.479 -0400", hash_original_method = "C17018EEDA4C922BB5D288F6A26A7D04", hash_generated_method = "ADF610E7E2292D97F88FE08BCF624AA9")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2022783240 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2022783240 = toURI();
        varB4EAC82CA7396A68D541C85D26508E83_2022783240.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2022783240;
        // ---------- Original Method ----------
        //return toURI();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.479 -0400", hash_original_method = "C7D67D79CD52B2E28D96292DEF9F8BD7", hash_generated_method = "1647BDD57CE7DF547AE583824111EC70")
    public boolean equals(final Object obj) {
        {
            HttpHost that;
            that = (HttpHost) obj;
            boolean varE7D414753A20D356FCE7EE06F85D327D_1247309915 = (this.lcHostname.equals(that.lcHostname) 
                && this.port == that.port
                && this.schemeName.equals(that.schemeName));
        } //End block
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1303598949 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1303598949;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.488 -0400", hash_original_method = "148EB8E2858B696FB463985EE3E49929", hash_generated_method = "510A2BDF280D475580378D97D3D72E83")
    public int hashCode() {
        int hash;
        hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.lcHostname);
        hash = LangUtils.hashCode(hash, this.port);
        hash = LangUtils.hashCode(hash, this.schemeName);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_677006062 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_677006062;
        // ---------- Original Method ----------
        //int hash = LangUtils.HASH_SEED;
        //hash = LangUtils.hashCode(hash, this.lcHostname);
        //hash = LangUtils.hashCode(hash, this.port);
        //hash = LangUtils.hashCode(hash, this.schemeName);
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.488 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "0A23E3D5581F74AC7A377402C05C9D69")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_258411803 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_258411803 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_258411803.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_258411803;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.488 -0400", hash_original_field = "FDEFA474EEB9B01BE6ECDD1CD4865451", hash_generated_field = "BC4AB09F492BB8FF3AF2DDEA94F3ED6C")

    public static final String DEFAULT_SCHEME_NAME = "http";
}

