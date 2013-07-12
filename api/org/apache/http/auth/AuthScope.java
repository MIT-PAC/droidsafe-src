package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Locale;
import org.apache.http.util.LangUtils;

public class AuthScope {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.056 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

    private String scheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.057 -0400", hash_original_field = "B94B7EF7F17D2394D6FBDF458DADC7B0", hash_generated_field = "423219CE3C0BBAF771E5E09A9E9F4AB6")

    private String realm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.057 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.057 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.059 -0400", hash_original_method = "DA242C23FF99C9B0BDF7227FEE464070", hash_generated_method = "425E439BA455FE442B587FF3E57AEC1C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.060 -0400", hash_original_method = "C3D4A92B6459D8B60217C4D554CBE13A", hash_generated_method = "A31C06783FADB727571D64269E0C17A1")
    public  AuthScope(final String host, int port, final String realm) {
        this(host, port, realm, ANY_SCHEME);
        addTaint(realm.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.061 -0400", hash_original_method = "00099B5ABB2589DBB04B6BC1AD6C4CF5", hash_generated_method = "98E09137C9CB97718C9197275F9CE349")
    public  AuthScope(final String host, int port) {
        this(host, port, ANY_REALM, ANY_SCHEME);
        addTaint(port);
        addTaint(host.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.062 -0400", hash_original_method = "20C18D8617332347FA916FFE36E3E911", hash_generated_method = "7122B7612F966017D737C5295661C345")
    public  AuthScope(final AuthScope authscope) {
        super();
    if(authscope == null)        
        {
            IllegalArgumentException var22538AF4DFFCFCE404BB493BAEC4BDD8_1944905491 = new IllegalArgumentException("Scope may not be null");
            var22538AF4DFFCFCE404BB493BAEC4BDD8_1944905491.addTaint(taint);
            throw var22538AF4DFFCFCE404BB493BAEC4BDD8_1944905491;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.062 -0400", hash_original_method = "052AA62CF2AFB76178CB036EF4B7BAB4", hash_generated_method = "6CBEFC799544FE4D570504D086B48C28")
    public String getHost() {
String var66CBD60FD8EB006652E02A446703F8AC_1198072236 =         this.host;
        var66CBD60FD8EB006652E02A446703F8AC_1198072236.addTaint(taint);
        return var66CBD60FD8EB006652E02A446703F8AC_1198072236;
        // ---------- Original Method ----------
        //return this.host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.063 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "24BB0170CA37E9A9D21B31698649770C")
    public int getPort() {
        int var02075052AFB1BA5EC4413B52BC401B14_19432304 = (this.port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2066134055 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2066134055;
        // ---------- Original Method ----------
        //return this.port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.063 -0400", hash_original_method = "5D06D5B53E6C13036F29936602C7EB58", hash_generated_method = "3EF8E3BEA2B3AC1274BBB249F9B13D6E")
    public String getRealm() {
String varE5D7E56F4E58F69800590B650DF8A269_39970700 =         this.realm;
        varE5D7E56F4E58F69800590B650DF8A269_39970700.addTaint(taint);
        return varE5D7E56F4E58F69800590B650DF8A269_39970700;
        // ---------- Original Method ----------
        //return this.realm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.063 -0400", hash_original_method = "76031D31C1CA528B8F038117D6808811", hash_generated_method = "7B93E81DE68DDDC2D59B1C2F36BA75D1")
    public String getScheme() {
String varBF26C0D1E8CB9E7F67A307E664136E8F_695886047 =         this.scheme;
        varBF26C0D1E8CB9E7F67A307E664136E8F_695886047.addTaint(taint);
        return varBF26C0D1E8CB9E7F67A307E664136E8F_695886047;
        // ---------- Original Method ----------
        //return this.scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.064 -0400", hash_original_method = "1AE5BF6F5B5937D7D318302FFD2D6934", hash_generated_method = "3449F4A62B52B5050D3D11E846BB7802")
    public int match(final AuthScope that) {
        addTaint(that.getTaint());
        int factor = 0;
    if(LangUtils.equals(this.scheme, that.scheme))        
        {
            factor += 1;
        } //End block
        else
        {
    if(this.scheme != ANY_SCHEME && that.scheme != ANY_SCHEME)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_16057353 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_717721183 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_717721183;
            } //End block
        } //End block
    if(LangUtils.equals(this.realm, that.realm))        
        {
            factor += 2;
        } //End block
        else
        {
    if(this.realm != ANY_REALM && that.realm != ANY_REALM)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1115927635 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098693931 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098693931;
            } //End block
        } //End block
    if(this.port == that.port)        
        {
            factor += 4;
        } //End block
        else
        {
    if(this.port != ANY_PORT && that.port != ANY_PORT)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1890854793 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_835495495 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_835495495;
            } //End block
        } //End block
    if(LangUtils.equals(this.host, that.host))        
        {
            factor += 8;
        } //End block
        else
        {
    if(this.host != ANY_HOST && that.host != ANY_HOST)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_130588306 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594660724 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594660724;
            } //End block
        } //End block
        int var742F32C65FFD18B766FA307F8DE2D47D_668111083 = (factor);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_239695983 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_239695983;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.065 -0400", hash_original_method = "DED1E319CFFFF5B0653C6B0D046D4EB9", hash_generated_method = "7ACEEC3F85F67552DE4CFE786AF278EB")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(o == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1111614443 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1565087757 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1565087757;
        } //End block
    if(o == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1196953405 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1944961643 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1944961643;
        } //End block
    if(!(o instanceof AuthScope))        
        {
            boolean varDBD7B5E32CCD38E45E29A8227EF381FE_1506313048 = (super.equals(o));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_582278323 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_582278323;
        } //End block
        AuthScope that = (AuthScope) o;
        boolean varBC936FA7E3F12CB16B76BE7BAAC3525F_1139331064 = (LangUtils.equals(this.host, that.host) 
          && this.port == that.port
          && LangUtils.equals(this.realm, that.realm)
          && LangUtils.equals(this.scheme, that.scheme));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2048400993 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2048400993;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.066 -0400", hash_original_method = "AA52C08879A8120A7A68C6044F6A755A", hash_generated_method = "612E4C68AA9208287B40F15521F25594")
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
    if(this.scheme != null)        
        {
            buffer.append(this.scheme.toUpperCase(Locale.ENGLISH));
            buffer.append(' ');
        } //End block
    if(this.realm != null)        
        {
            buffer.append('\'');
            buffer.append(this.realm);
            buffer.append('\'');
        } //End block
        else
        {
            buffer.append("<any realm>");
        } //End block
    if(this.host != null)        
        {
            buffer.append('@');
            buffer.append(this.host);
    if(this.port >= 0)            
            {
                buffer.append(':');
                buffer.append(this.port);
            } //End block
        } //End block
String varD03843288D33B9E1D3062E25339ECF6D_2136777181 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_2136777181.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_2136777181;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.067 -0400", hash_original_method = "5969A15C4BB29A6E888D795486A04627", hash_generated_method = "03D235CCE6119ED9EE85B4532CF89823")
    @Override
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.host);
        hash = LangUtils.hashCode(hash, this.port);
        hash = LangUtils.hashCode(hash, this.realm);
        hash = LangUtils.hashCode(hash, this.scheme);
        int var0800FC577294C34E0B28AD2839435945_98450449 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620772157 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620772157;
        // ---------- Original Method ----------
        //int hash = LangUtils.HASH_SEED;
        //hash = LangUtils.hashCode(hash, this.host);
        //hash = LangUtils.hashCode(hash, this.port);
        //hash = LangUtils.hashCode(hash, this.realm);
        //hash = LangUtils.hashCode(hash, this.scheme);
        //return hash;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.067 -0400", hash_original_field = "B6FC2F498E91FE65D6AEF96FC51C59F7", hash_generated_field = "D702123867AF990F6D94A9795015E375")

    public static final String ANY_HOST = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.067 -0400", hash_original_field = "5BFCB087B1E0361AF400331ECECDB43B", hash_generated_field = "B342D0F622AFA6308B997D5F9CC5C96D")

    public static final int ANY_PORT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.067 -0400", hash_original_field = "FA9272D3FD7BC1B3E49379FBBD748A12", hash_generated_field = "4FF0C9DE993EF66ABB8920A251A0BCFA")

    public static final String ANY_REALM = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.067 -0400", hash_original_field = "714E0E61EF23BC80C07C1E6932CA7840", hash_generated_field = "24A3DF5B5E858CFA3B8D1432195721A1")

    public static final String ANY_SCHEME = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.067 -0400", hash_original_field = "AEB3A4279F5CC4AD37515131A6CBE7DE", hash_generated_field = "77020956665DD00DF81FBCE72560DA45")

    public static final AuthScope ANY = new AuthScope(ANY_HOST, ANY_PORT, ANY_REALM, ANY_SCHEME);
}

