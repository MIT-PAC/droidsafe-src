package org.apache.http.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.LangUtils;

public class BasicNameValuePair implements NameValuePair, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.216 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.216 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.217 -0400", hash_original_method = "9B16B3F0FD8B0C655E61EA7019E7F0C5", hash_generated_method = "E48C6861298E8FB66DFAFDD51480F8B0")
    public  BasicNameValuePair(final String name, final String value) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name may not be null");
        } 
        this.name = name;
        this.value = value;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.217 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "7841FF14A502F85C86C6623AE1677E6D")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1095710759 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1095710759 = this.name;
        varB4EAC82CA7396A68D541C85D26508E83_1095710759.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1095710759;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.218 -0400", hash_original_method = "ADE49245CA79B6D6B3F4663E953C8CD9", hash_generated_method = "0623CE2BB7406587E6FC2FBA13A6C4C0")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_1481452043 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1481452043 = this.value;
        varB4EAC82CA7396A68D541C85D26508E83_1481452043.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1481452043;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.218 -0400", hash_original_method = "93FF9F6BC44FD78A86FF56612368CE29", hash_generated_method = "8697E8F9619FADC8E0BC6971016E7CA0")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_845383711 = null; 
        int len = this.name.length();
        len += 1 + this.value.length();
        CharArrayBuffer buffer = new CharArrayBuffer(len);
        buffer.append(this.name);
        {
            buffer.append("=");
            buffer.append(this.value);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_845383711 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_845383711.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_845383711;
        
        
        
            
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.219 -0400", hash_original_method = "3849D74FE9AE53A80E5FA00389489FFC", hash_generated_method = "4D61C69485F38D824F63A069FEE1CF28")
    public boolean equals(final Object object) {
        {
            BasicNameValuePair that = (BasicNameValuePair) object;
            boolean var12460EC170C55F6123FCD61C93037C8D_2108037091 = (this.name.equals(that.name)
                  && LangUtils.equals(this.value, that.value));
        } 
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1411417905 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1411417905;
        
        
        
        
            
            
                  
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.219 -0400", hash_original_method = "A586BF0615CE91E5DB31F98DF42747A4", hash_generated_method = "3C6C82D26BFFC7A8C9DC54CF03E7CB61")
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.name);
        hash = LangUtils.hashCode(hash, this.value);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1609632645 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1609632645;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.220 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "DC3B5E7581C20626F6E173D94F18EC5D")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1683339421 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1683339421 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1683339421.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1683339421;
        
        
    }

    
}

