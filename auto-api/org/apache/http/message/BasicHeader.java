package org.apache.http.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;

public class BasicHeader implements Header, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.915 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.915 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.915 -0400", hash_original_method = "2FB38EAD7D5E85502A5A04936633433A", hash_generated_method = "BB65EDD64E2DB1C6D12A4CC9EE3596BA")
    public  BasicHeader(final String name, final String value) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name may not be null");
        } 
        this.name = name;
        this.value = value;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.916 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "F186F0C2AD3BF9570472281707B00EA8")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_494662955 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_494662955 = this.name;
        varB4EAC82CA7396A68D541C85D26508E83_494662955.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_494662955;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.917 -0400", hash_original_method = "ADE49245CA79B6D6B3F4663E953C8CD9", hash_generated_method = "36DF83EA3B41BBB28C2ECB7F28A66AA4")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_1219383869 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1219383869 = this.value;
        varB4EAC82CA7396A68D541C85D26508E83_1219383869.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1219383869;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.917 -0400", hash_original_method = "F969228997B8CD2234867EA0CA894312", hash_generated_method = "E03DC9A6F64E1D4B64A4D17EE8983650")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1769580495 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1769580495 = BasicLineFormatter.DEFAULT.formatHeader(null, this).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1769580495.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1769580495;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.918 -0400", hash_original_method = "4A0D34AA034E5A375AA25DFEEA935661", hash_generated_method = "B14C6BF40AE49DF95F002C3B87A59434")
    public HeaderElement[] getElements() throws ParseException {
        HeaderElement[] varB4EAC82CA7396A68D541C85D26508E83_56133673 = null; 
        HeaderElement[] varB4EAC82CA7396A68D541C85D26508E83_964182416 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_56133673 = BasicHeaderValueParser.parseElements(this.value, null);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_964182416 = new HeaderElement[] {};
        } 
        HeaderElement[] varA7E53CE21691AB073D9660D615818899_1233081904; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1233081904 = varB4EAC82CA7396A68D541C85D26508E83_56133673;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1233081904 = varB4EAC82CA7396A68D541C85D26508E83_964182416;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1233081904.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1233081904;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.919 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "4752810705F1BE391421124BF6B49F90")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1998327727 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1998327727 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1998327727.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1998327727;
        
        
    }

    
}

