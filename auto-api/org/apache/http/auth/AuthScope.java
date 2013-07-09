package org.apache.http.auth;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Locale;
import org.apache.http.util.LangUtils;

public class AuthScope {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.608 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

    private String scheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.608 -0400", hash_original_field = "B94B7EF7F17D2394D6FBDF458DADC7B0", hash_generated_field = "423219CE3C0BBAF771E5E09A9E9F4AB6")

    private String realm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.608 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.608 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.609 -0400", hash_original_method = "DA242C23FF99C9B0BDF7227FEE464070", hash_generated_method = "425E439BA455FE442B587FF3E57AEC1C")
    public  AuthScope(final String host, int port, 
        final String realm, final String scheme) {
        this.host =   (host == null)   ? ANY_HOST: host.toLowerCase(Locale.ENGLISH);
        this.port =   (port < 0)       ? ANY_PORT: port;
        this.realm =  (realm == null)  ? ANY_REALM: realm;
        this.scheme = (scheme == null) ? ANY_SCHEME: scheme.toUpperCase(Locale.ENGLISH);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.610 -0400", hash_original_method = "C3D4A92B6459D8B60217C4D554CBE13A", hash_generated_method = "6F87BB653D5C3C8F35FB870751EBBD90")
    public  AuthScope(final String host, int port, final String realm) {
        this(host, port, realm, ANY_SCHEME);
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(realm.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.610 -0400", hash_original_method = "00099B5ABB2589DBB04B6BC1AD6C4CF5", hash_generated_method = "5FF81C734C357BD22484F5C3037EB3C4")
    public  AuthScope(final String host, int port) {
        this(host, port, ANY_REALM, ANY_SCHEME);
        addTaint(host.getTaint());
        addTaint(port);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.612 -0400", hash_original_method = "20C18D8617332347FA916FFE36E3E911", hash_generated_method = "2FBB5B397D655690DD778D5980373292")
    public  AuthScope(final AuthScope authscope) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Scope may not be null");
        } 
        this.host = authscope.getHost();
        this.port = authscope.getPort();
        this.realm = authscope.getRealm();
        this.scheme = authscope.getScheme();
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.615 -0400", hash_original_method = "052AA62CF2AFB76178CB036EF4B7BAB4", hash_generated_method = "FF2607AC73A3BA47945F4D48282D5A5B")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1916826214 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1916826214 = this.host;
        varB4EAC82CA7396A68D541C85D26508E83_1916826214.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1916826214;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.615 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "F75741D504A496DED21BE552748D62F8")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1097079209 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1097079209;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.616 -0400", hash_original_method = "5D06D5B53E6C13036F29936602C7EB58", hash_generated_method = "3EAC0360B8C2F88D47412608A775E5A5")
    public String getRealm() {
        String varB4EAC82CA7396A68D541C85D26508E83_997627851 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_997627851 = this.realm;
        varB4EAC82CA7396A68D541C85D26508E83_997627851.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_997627851;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.616 -0400", hash_original_method = "76031D31C1CA528B8F038117D6808811", hash_generated_method = "43B85A69CE4CE659BED7C53C4F784746")
    public String getScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_263461561 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_263461561 = this.scheme;
        varB4EAC82CA7396A68D541C85D26508E83_263461561.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_263461561;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.617 -0400", hash_original_method = "1AE5BF6F5B5937D7D318302FFD2D6934", hash_generated_method = "08BCAC6107B4C3D4A09E52165DAA0B85")
    public int match(final AuthScope that) {
        int factor = 0;
        {
            boolean var9B8A419034CE12F89AAC168980C8B2C4_185379758 = (LangUtils.equals(this.scheme, that.scheme));
            {
                factor += 1;
            } 
        } 
        {
            boolean varAFF2B081C3940E7D459759792385F9FE_1144958698 = (LangUtils.equals(this.realm, that.realm));
            {
                factor += 2;
            } 
        } 
        {
            factor += 4;
        } 
        {
            boolean varA6DCD534944540519757791467FB47BC_711688834 = (LangUtils.equals(this.host, that.host));
            {
                factor += 8;
            } 
        } 
        addTaint(that.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_409770152 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_409770152;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.618 -0400", hash_original_method = "DED1E319CFFFF5B0653C6B0D046D4EB9", hash_generated_method = "A78C026357BE9D4B323428D65CF5735F")
    @Override
    public boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_1998664278 = (o == this);
        } 
        {
            boolean var9501E992D125EB696047CB10C697FF94_947804680 = (super.equals(o));
        } 
        AuthScope that = (AuthScope) o;
        boolean varAD29532AAEE69F0F82ECC94841E9FD28_184104491 = (LangUtils.equals(this.host, that.host) 
          && this.port == that.port
          && LangUtils.equals(this.realm, that.realm)
          && LangUtils.equals(this.scheme, that.scheme));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1457691089 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1457691089;
        
        
            
        
        
            
        
        
            
        
        
        
        
          
          
          
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.618 -0400", hash_original_method = "AA52C08879A8120A7A68C6044F6A755A", hash_generated_method = "40A18895075F3F597D3CAF12B59A9518")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1578355462 = null; 
        StringBuffer buffer = new StringBuffer();
        {
            buffer.append(this.scheme.toUpperCase(Locale.ENGLISH));
            buffer.append(' ');
        } 
        {
            buffer.append('\'');
            buffer.append(this.realm);
            buffer.append('\'');
        } 
        {
            buffer.append("<any realm>");
        } 
        {
            buffer.append('@');
            buffer.append(this.host);
            {
                buffer.append(':');
                buffer.append(this.port);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1578355462 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1578355462.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1578355462;
        
        
        
            
            
        
        
            
            
            
        
            
        
        
            
            
            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.619 -0400", hash_original_method = "5969A15C4BB29A6E888D795486A04627", hash_generated_method = "108802D4A87200DAEA0E1046BD758B5E")
    @Override
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.host);
        hash = LangUtils.hashCode(hash, this.port);
        hash = LangUtils.hashCode(hash, this.realm);
        hash = LangUtils.hashCode(hash, this.scheme);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1048754000 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1048754000;
        
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.619 -0400", hash_original_field = "B6FC2F498E91FE65D6AEF96FC51C59F7", hash_generated_field = "D702123867AF990F6D94A9795015E375")

    public static final String ANY_HOST = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.619 -0400", hash_original_field = "5BFCB087B1E0361AF400331ECECDB43B", hash_generated_field = "B342D0F622AFA6308B997D5F9CC5C96D")

    public static final int ANY_PORT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.619 -0400", hash_original_field = "FA9272D3FD7BC1B3E49379FBBD748A12", hash_generated_field = "4FF0C9DE993EF66ABB8920A251A0BCFA")

    public static final String ANY_REALM = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.619 -0400", hash_original_field = "714E0E61EF23BC80C07C1E6932CA7840", hash_generated_field = "24A3DF5B5E858CFA3B8D1432195721A1")

    public static final String ANY_SCHEME = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.619 -0400", hash_original_field = "AEB3A4279F5CC4AD37515131A6CBE7DE", hash_generated_field = "77020956665DD00DF81FBCE72560DA45")

    public static final AuthScope ANY = new AuthScope(ANY_HOST, ANY_PORT, ANY_REALM, ANY_SCHEME);
}

