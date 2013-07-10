package org.apache.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Locale;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.LangUtils;

public final class HttpHost implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.451 -0400", hash_original_field = "0897ACF49C7C1EA9F76EFE59187AA046", hash_generated_field = "A498A0C52EAEC26516CFC120F651D2CE")

    protected String hostname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.451 -0400", hash_original_field = "4B6994488E849D2EABC750D4A1DC0438", hash_generated_field = "21E874C75AB8261C3E938826C2C646D0")

    protected String lcHostname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.451 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "C021A045CC358C8C262F3483738B3278")

    protected int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.451 -0400", hash_original_field = "018FE739B0B3B7545BA70D6D8A1BE0A6", hash_generated_field = "B9EB89391FD6A47F6CAEEA8A1467B77A")

    protected String schemeName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.451 -0400", hash_original_method = "3BB513ACF90DB4E8549AF0CC3A6C9663", hash_generated_method = "7550050F92148A0CFB7E7FBFE848942C")
    public  HttpHost(final String hostname, int port, final String scheme) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Host name may not be null");
        } 
        this.hostname   = hostname;
        this.lcHostname = hostname.toLowerCase(Locale.ENGLISH);
        {
            this.schemeName = scheme.toLowerCase(Locale.ENGLISH);
        } 
        {
            this.schemeName = DEFAULT_SCHEME_NAME;
        } 
        this.port = port;
        
        
            
        
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.451 -0400", hash_original_method = "6AFEA0EBFC8A407A29450DC5B1D95F74", hash_generated_method = "24935D5A997E9A729086469D1EC83238")
    public  HttpHost(final String hostname, int port) {
        this(hostname, port, null);
        addTaint(hostname.getTaint());
        addTaint(port);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.452 -0400", hash_original_method = "9E22BC6A820AFDDBFC5B86A2EC17A27A", hash_generated_method = "71E490F3361A1782307D755E40D7D695")
    public  HttpHost(final String hostname) {
        this(hostname, -1, null);
        addTaint(hostname.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.452 -0400", hash_original_method = "C44D4CD5D948E031A838C102F3C3F056", hash_generated_method = "2BC334727B51F49C4C42C8286E32572D")
    public  HttpHost(final HttpHost httphost) {
        this(httphost.hostname, httphost.port, httphost.schemeName);
        addTaint(httphost.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.453 -0400", hash_original_method = "FF0006634ABBE2C97788D559B23C884A", hash_generated_method = "AC62A580BEE147C3678C1F2CF609B72B")
    public String getHostName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1013516313 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1013516313 = this.hostname;
        varB4EAC82CA7396A68D541C85D26508E83_1013516313.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1013516313;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.453 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "E7EA0C8DE2518BC93C0B35CD5EC22A21")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_516529367 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_516529367;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.454 -0400", hash_original_method = "C6F0B2E3DB0F6FEAB7513E486FF6DA80", hash_generated_method = "06358C712030A88615A00D12E710CD22")
    public String getSchemeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2016116216 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2016116216 = this.schemeName;
        varB4EAC82CA7396A68D541C85D26508E83_2016116216.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2016116216;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.454 -0400", hash_original_method = "FE8B35DF3D2B1A5F77A96BBF48284914", hash_generated_method = "B120BDCEBAE128131C9A15CC309C56E2")
    public String toURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_1837041849 = null; 
        CharArrayBuffer buffer = new CharArrayBuffer(32);
        buffer.append(this.schemeName);
        buffer.append("://");
        buffer.append(this.hostname);
        {
            buffer.append(':');
            buffer.append(Integer.toString(this.port));
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1837041849 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1837041849.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1837041849;
        
        
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.455 -0400", hash_original_method = "6DDBCACEAF7453CD975901EB7FA152DA", hash_generated_method = "7AE043239C02A0333AECA6C181407F17")
    public String toHostString() {
        String varB4EAC82CA7396A68D541C85D26508E83_478349681 = null; 
        CharArrayBuffer buffer = new CharArrayBuffer(32);
        buffer.append(this.hostname);
        {
            buffer.append(':');
            buffer.append(Integer.toString(this.port));
        } 
        varB4EAC82CA7396A68D541C85D26508E83_478349681 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_478349681.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_478349681;
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.456 -0400", hash_original_method = "C17018EEDA4C922BB5D288F6A26A7D04", hash_generated_method = "D2F8CE454CC667D48E0FFD726CEAC5F0")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_707660728 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_707660728 = toURI();
        varB4EAC82CA7396A68D541C85D26508E83_707660728.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_707660728;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.457 -0400", hash_original_method = "C7D67D79CD52B2E28D96292DEF9F8BD7", hash_generated_method = "FD4F148A3B7ACA5483CC5FE973EE2887")
    public boolean equals(final Object obj) {
        {
            HttpHost that = (HttpHost) obj;
            boolean varE7D414753A20D356FCE7EE06F85D327D_815185953 = (this.lcHostname.equals(that.lcHostname) 
                && this.port == that.port
                && this.schemeName.equals(that.schemeName));
        } 
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_46635962 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_46635962;
        
        
        
        
            
            
                
                
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.457 -0400", hash_original_method = "148EB8E2858B696FB463985EE3E49929", hash_generated_method = "0D963E6C928CEFE1AE1680BD298F56F3")
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.lcHostname);
        hash = LangUtils.hashCode(hash, this.port);
        hash = LangUtils.hashCode(hash, this.schemeName);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_852643017 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_852643017;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.458 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "C3531E6AAE782B6B606114E2EA041CC9")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_880185832 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_880185832 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_880185832.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_880185832;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.458 -0400", hash_original_field = "FDEFA474EEB9B01BE6ECDD1CD4865451", hash_generated_field = "BC4AB09F492BB8FF3AF2DDEA94F3ED6C")

    public static final String DEFAULT_SCHEME_NAME = "http";
}

