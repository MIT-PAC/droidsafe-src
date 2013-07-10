package org.bouncycastle.util.io.pem;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class PemHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.353 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.353 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.354 -0400", hash_original_method = "4509DA5CCC6D5B482BEA6C1D7CD04168", hash_generated_method = "7833D43EC03F2988C72B201F1918A3BB")
    public  PemHeader(String name, String value) {
        this.name = name;
        this.value = value;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.355 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "F15F196DD9E2CCFF718B701C05053E2D")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_968662581 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_968662581 = name;
        varB4EAC82CA7396A68D541C85D26508E83_968662581.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_968662581;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.356 -0400", hash_original_method = "CFCF943D36987E569CAB72593E604904", hash_generated_method = "A8956300D9EC40D1827A4019C3197F8E")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_2110070608 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2110070608 = value;
        varB4EAC82CA7396A68D541C85D26508E83_2110070608.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2110070608;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.356 -0400", hash_original_method = "D2F99D4FA1F9F9DCD18FFC2807839B4D", hash_generated_method = "8554B6E63F764A0DDECFD5792180708F")
    public int hashCode() {
        int varC70158E9C1B434721E06B7892EBB3099_665795492 = (getHashCode(this.name) + 31 * getHashCode(this.value));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1829537318 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1829537318;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.357 -0400", hash_original_method = "008350332C23D1093274CD2597D3DC3D", hash_generated_method = "8030FA23F03A07A3EF1BD62D2AF362E0")
    public boolean equals(Object o) {
        PemHeader other = (PemHeader)o;
        boolean var10EA29FD093456A46D621A5643069AF2_673532694 = (other == this || (isEqual(this.name, other.name) && isEqual(this.value, other.value)));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1554167467 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1554167467;
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.358 -0400", hash_original_method = "552BFCCB5F897360ADAD8A79D56E72F9", hash_generated_method = "6531D1FA0D6AD509B330E3F999756A71")
    private int getHashCode(String s) {
        int varCC059AF02BE126811FEBD373717A473C_703837200 = (s.hashCode());
        addTaint(s.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_409186820 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_409186820;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.359 -0400", hash_original_method = "56C7E9071A8414DCCD1359B9AFE0CC30", hash_generated_method = "30059435570B9FE8F81AE3DBB4C593B2")
    private boolean isEqual(String s1, String s2) {
        boolean varD27A4BC068AEDBEFAE6028FE88C4B046_1372883454 = (s1.equals(s2));
        addTaint(s1.getTaint());
        addTaint(s2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2098099189 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2098099189;
        
        
        
            
        
        
        
            
        
        
    }

    
}

