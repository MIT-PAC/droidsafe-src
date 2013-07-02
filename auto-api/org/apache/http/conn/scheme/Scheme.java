package org.apache.http.conn.scheme;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Locale;
import org.apache.http.util.LangUtils;

public final class Scheme {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.316 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.316 -0400", hash_original_field = "29ADE661BC5B8F8B761C72AAE89589BE", hash_generated_field = "EE0A679D7069D3BF51EFF346308E2FC4")

    private SocketFactory socketFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.316 -0400", hash_original_field = "AD9869ADBCCEEFF5A73F8163B0777153", hash_generated_field = "FC0F8278C90053902D318AF538EA40AF")

    private int defaultPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.316 -0400", hash_original_field = "9442E6482C63DEF4C35BC13B704C52E2", hash_generated_field = "656433D6E22132E512C250C9ABEE8490")

    private boolean layered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.316 -0400", hash_original_field = "40419C36198E2BF68491607F3BBDC619", hash_generated_field = "A7CB93AD593788A74C76D77C24510B38")

    private String stringRep;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.317 -0400", hash_original_method = "FC3EBEAFEA712CD3115701A02487AC2E", hash_generated_method = "A608D30D93F6507F6FF6A6D9A7087CDE")
    public  Scheme(final String name,
                  final SocketFactory factory,
                  final int port) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Scheme name may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Socket factory may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Port is invalid: " + port);
        } 
        this.name = name.toLowerCase(Locale.ENGLISH);
        this.socketFactory = factory;
        this.defaultPort = port;
        this.layered = (factory instanceof LayeredSocketFactory);
        
        
            
                
        
        
            
                
        
        
            
                
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.317 -0400", hash_original_method = "CA86BB3AB3ACF92C5C19618DD925F5A0", hash_generated_method = "540CFFE0D4E364083A64C36631206D4F")
    public final int getDefaultPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1813366783 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1813366783;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.318 -0400", hash_original_method = "8D53BDBBDB5B8DACC183C2C5A3A2FE13", hash_generated_method = "10984645D3A84E0779BD00BC273DDB1D")
    public final SocketFactory getSocketFactory() {
        SocketFactory varB4EAC82CA7396A68D541C85D26508E83_892666446 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_892666446 = socketFactory;
        varB4EAC82CA7396A68D541C85D26508E83_892666446.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_892666446;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.318 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "DA3BF63A1FF47B7767743534848F032A")
    public final String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1458737567 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1458737567 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1458737567.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1458737567;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.318 -0400", hash_original_method = "9614A7277DEC14D06C0E4E046469A079", hash_generated_method = "58964532215F8C18A1DD584271DDE5FB")
    public final boolean isLayered() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2115009866 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2115009866;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.319 -0400", hash_original_method = "64F6A6BD8BE8E9634AE7594AC6F06F64", hash_generated_method = "9E86BA2265926EA5B2BE9B026741E858")
    public final int resolvePort(int port) {
        addTaint(port);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1201658895 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1201658895;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.319 -0400", hash_original_method = "DC9B71D58EF4666028CCB60CC7379DF5", hash_generated_method = "B6140BED9C5A1541C2394E7E7F6D0476")
    @Override
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1628961712 = null; 
        {
            StringBuilder buffer = new StringBuilder();
            buffer.append(this.name);
            buffer.append(':');
            buffer.append(Integer.toString(this.defaultPort));
            stringRep = buffer.toString();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1628961712 = stringRep;
        varB4EAC82CA7396A68D541C85D26508E83_1628961712.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1628961712;
        
        
            
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.321 -0400", hash_original_method = "62FA4DFF9313BF5A320239E33F35F300", hash_generated_method = "14ABF6C95FA2492E7145A0C8C4295588")
    @Override
    public final boolean equals(Object obj) {
        Scheme s = (Scheme) obj;
        boolean var815103F6CF63892700C652AA1AF81A32_81724738 = ((name.equals(s.name) &&
                defaultPort == s.defaultPort &&
                layered == s.layered &&
                socketFactory.equals(s.socketFactory)
                ));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_184313878 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_184313878;
        
        
        
        
        
        
                
                
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.322 -0400", hash_original_method = "D2A22011D07817D724D5F16905D145B4", hash_generated_method = "037703FFCC842F437C00BB241DB81BE3")
    @Override
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.defaultPort);
        hash = LangUtils.hashCode(hash, this.name);
        hash = LangUtils.hashCode(hash, this.layered);
        hash = LangUtils.hashCode(hash, this.socketFactory);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2053355407 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2053355407;
        
        
        
        
        
        
        
    }

    
}

