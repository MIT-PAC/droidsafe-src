package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Locale;
import org.apache.http.util.LangUtils;

public class AuthScope {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.801 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

    private String scheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.801 -0400", hash_original_field = "B94B7EF7F17D2394D6FBDF458DADC7B0", hash_generated_field = "423219CE3C0BBAF771E5E09A9E9F4AB6")

    private String realm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.801 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.802 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.807 -0400", hash_original_method = "DA242C23FF99C9B0BDF7227FEE464070", hash_generated_method = "425E439BA455FE442B587FF3E57AEC1C")
    public  AuthScope(final String host, int port, 
        final String realm, final String scheme) {
        this.host =   (host == null)   ? ANY_HOST: host.toLowerCase(Locale.ENGLISH);
        this.port =   (port < 0)       ? ANY_PORT: port;
        this.realm =  (realm == null)  ? ANY_REALM: realm;
        this.scheme = (scheme == null) ? ANY_SCHEME: scheme.toUpperCase(Locale.ENGLISH);
        // ---------- Original Method ----------
        //this.host =   (host == null)   ? ANY_HOST: host.toLowerCase(Locale.ENGLISH);
        //this.port =   (port < 0)       ? ANY_PORT: port;
        //this.realm =  (realm == null)  ? ANY_REALM: realm;
        //this.scheme = (scheme == null) ? ANY_SCHEME: scheme.toUpperCase(Locale.ENGLISH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.807 -0400", hash_original_method = "C3D4A92B6459D8B60217C4D554CBE13A", hash_generated_method = "6F87BB653D5C3C8F35FB870751EBBD90")
    public  AuthScope(final String host, int port, final String realm) {
        this(host, port, realm, ANY_SCHEME);
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(realm.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.808 -0400", hash_original_method = "00099B5ABB2589DBB04B6BC1AD6C4CF5", hash_generated_method = "5FF81C734C357BD22484F5C3037EB3C4")
    public  AuthScope(final String host, int port) {
        this(host, port, ANY_REALM, ANY_SCHEME);
        addTaint(host.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.813 -0400", hash_original_method = "20C18D8617332347FA916FFE36E3E911", hash_generated_method = "2FBB5B397D655690DD778D5980373292")
    public  AuthScope(final AuthScope authscope) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Scope may not be null");
        } //End block
        this.host = authscope.getHost();
        this.port = authscope.getPort();
        this.realm = authscope.getRealm();
        this.scheme = authscope.getScheme();
        // ---------- Original Method ----------
        //if (authscope == null) {
            //throw new IllegalArgumentException("Scope may not be null");
        //}
        //this.host = authscope.getHost();
        //this.port = authscope.getPort();
        //this.realm = authscope.getRealm();
        //this.scheme = authscope.getScheme();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.814 -0400", hash_original_method = "052AA62CF2AFB76178CB036EF4B7BAB4", hash_generated_method = "58DC18EFE4214E1586AB10AFBD3EB5ED")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1102452044 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1102452044 = this.host;
        varB4EAC82CA7396A68D541C85D26508E83_1102452044.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1102452044;
        // ---------- Original Method ----------
        //return this.host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.816 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "AB3C79659EE4361D7152C75E22EC1AA8")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1257850328 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1257850328;
        // ---------- Original Method ----------
        //return this.port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.817 -0400", hash_original_method = "5D06D5B53E6C13036F29936602C7EB58", hash_generated_method = "C8A0C585F72E0A66F4ED790A2E1CD864")
    public String getRealm() {
        String varB4EAC82CA7396A68D541C85D26508E83_783276001 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_783276001 = this.realm;
        varB4EAC82CA7396A68D541C85D26508E83_783276001.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_783276001;
        // ---------- Original Method ----------
        //return this.realm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.825 -0400", hash_original_method = "76031D31C1CA528B8F038117D6808811", hash_generated_method = "50D7021E020702D3423CBFFF7D710B10")
    public String getScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_216455301 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_216455301 = this.scheme;
        varB4EAC82CA7396A68D541C85D26508E83_216455301.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_216455301;
        // ---------- Original Method ----------
        //return this.scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.834 -0400", hash_original_method = "1AE5BF6F5B5937D7D318302FFD2D6934", hash_generated_method = "659E3C82EADCC3A56EB2B13A31EE98BD")
    public int match(final AuthScope that) {
        int factor;
        factor = 0;
        {
            boolean var9B8A419034CE12F89AAC168980C8B2C4_1315209940 = (LangUtils.equals(this.scheme, that.scheme));
            {
                factor += 1;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAFF2B081C3940E7D459759792385F9FE_1060559456 = (LangUtils.equals(this.realm, that.realm));
            {
                factor += 2;
            } //End block
        } //End collapsed parenthetic
        {
            factor += 4;
        } //End block
        {
            boolean varA6DCD534944540519757791467FB47BC_1284841991 = (LangUtils.equals(this.host, that.host));
            {
                factor += 8;
            } //End block
        } //End collapsed parenthetic
        addTaint(that.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1315167403 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1315167403;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.835 -0400", hash_original_method = "DED1E319CFFFF5B0653C6B0D046D4EB9", hash_generated_method = "F9C96A6623669A6507BD9E7BAA1976AC")
    @Override
    public boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_727988518 = (o == this);
        } //End collapsed parenthetic
        {
            boolean var9501E992D125EB696047CB10C697FF94_975934346 = (super.equals(o));
        } //End block
        AuthScope that;
        that = (AuthScope) o;
        boolean varAD29532AAEE69F0F82ECC94841E9FD28_1539588427 = (LangUtils.equals(this.host, that.host) 
          && this.port == that.port
          && LangUtils.equals(this.realm, that.realm)
          && LangUtils.equals(this.scheme, that.scheme));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_694144002 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_694144002;
        // ---------- Original Method ----------
        //if (o == null) {
            //return false;
        //}
        //if (o == this) {
            //return true;
        //}
        //if (!(o instanceof AuthScope)) {
            //return super.equals(o);
        //}
        //AuthScope that = (AuthScope) o;
        //return 
        //LangUtils.equals(this.host, that.host) 
          //&& this.port == that.port
          //&& LangUtils.equals(this.realm, that.realm)
          //&& LangUtils.equals(this.scheme, that.scheme);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.843 -0400", hash_original_method = "AA52C08879A8120A7A68C6044F6A755A", hash_generated_method = "84ECA71ABD253624BF3E1B9719C30F2A")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1662899836 = null; //Variable for return #1
        StringBuffer buffer;
        buffer = new StringBuffer();
        {
            buffer.append(this.scheme.toUpperCase(Locale.ENGLISH));
            buffer.append(' ');
        } //End block
        {
            buffer.append('\'');
            buffer.append(this.realm);
            buffer.append('\'');
        } //End block
        {
            buffer.append("<any realm>");
        } //End block
        {
            buffer.append('@');
            buffer.append(this.host);
            {
                buffer.append(':');
                buffer.append(this.port);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1662899836 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1662899836.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1662899836;
        // ---------- Original Method ----------
        //StringBuffer buffer = new StringBuffer();
        //if (this.scheme != null) {
            //buffer.append(this.scheme.toUpperCase(Locale.ENGLISH));
            //buffer.append(' ');
        //}
        //if (this.realm != null) {
            //buffer.append('\'');
            //buffer.append(this.realm);
            //buffer.append('\'');
        //} else {
            //buffer.append("<any realm>");
        //}
        //if (this.host != null) {
            //buffer.append('@');
            //buffer.append(this.host);
            //if (this.port >= 0) {
                //buffer.append(':');
                //buffer.append(this.port);
            //}
        //}
        //return buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.846 -0400", hash_original_method = "5969A15C4BB29A6E888D795486A04627", hash_generated_method = "1B6FEEFAE4A8D95FD54E8F149D4245EC")
    @Override
    public int hashCode() {
        int hash;
        hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.host);
        hash = LangUtils.hashCode(hash, this.port);
        hash = LangUtils.hashCode(hash, this.realm);
        hash = LangUtils.hashCode(hash, this.scheme);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1281707981 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1281707981;
        // ---------- Original Method ----------
        //int hash = LangUtils.HASH_SEED;
        //hash = LangUtils.hashCode(hash, this.host);
        //hash = LangUtils.hashCode(hash, this.port);
        //hash = LangUtils.hashCode(hash, this.realm);
        //hash = LangUtils.hashCode(hash, this.scheme);
        //return hash;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.846 -0400", hash_original_field = "B6FC2F498E91FE65D6AEF96FC51C59F7", hash_generated_field = "D702123867AF990F6D94A9795015E375")

    public static final String ANY_HOST = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.846 -0400", hash_original_field = "5BFCB087B1E0361AF400331ECECDB43B", hash_generated_field = "B342D0F622AFA6308B997D5F9CC5C96D")

    public static final int ANY_PORT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.846 -0400", hash_original_field = "FA9272D3FD7BC1B3E49379FBBD748A12", hash_generated_field = "4FF0C9DE993EF66ABB8920A251A0BCFA")

    public static final String ANY_REALM = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.846 -0400", hash_original_field = "714E0E61EF23BC80C07C1E6932CA7840", hash_generated_field = "24A3DF5B5E858CFA3B8D1432195721A1")

    public static final String ANY_SCHEME = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.846 -0400", hash_original_field = "AEB3A4279F5CC4AD37515131A6CBE7DE", hash_generated_field = "77020956665DD00DF81FBCE72560DA45")

    public static final AuthScope ANY = new AuthScope(ANY_HOST, ANY_PORT, ANY_REALM, ANY_SCHEME);
}

