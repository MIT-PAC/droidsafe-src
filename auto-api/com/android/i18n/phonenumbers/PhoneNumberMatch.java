package com.android.i18n.phonenumbers;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;
import java.util.Arrays;

public final class PhoneNumberMatch {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.629 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "B252D65F8AC1E6F23CF7A89AB309103A")

    private int start;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.629 -0400", hash_original_field = "86C8EF5116F9F2D53104EB36EE5FEBD4", hash_generated_field = "6456B20A1E1CCB2639ECC7BC4AF85249")

    private String rawString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.629 -0400", hash_original_field = "B1BC248A7FF2B2E95569F56DE68615DF", hash_generated_field = "DFCB3B49B2D60B2C16CC443A648E9AFE")

    private PhoneNumber number;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.630 -0400", hash_original_method = "24CA5CFFCC859FAC59BD892D4A4B2393", hash_generated_method = "90E4FAF9A569BB9DBF263DA575D17BAC")
      PhoneNumberMatch(int start, String rawString, PhoneNumber number) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Start index must be >= 0.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        this.start = start;
        this.rawString = rawString;
        this.number = number;
        
        
      
    
        
      
    
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.630 -0400", hash_original_method = "3AF6887A924E6E03501A94FECACFA30D", hash_generated_method = "CB3BDF0FE5367C2EAC5A14F6A44DCA5B")
    public PhoneNumber number() {
        PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_646038756 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_646038756 = number;
        varB4EAC82CA7396A68D541C85D26508E83_646038756.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_646038756;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.631 -0400", hash_original_method = "5948F380AB147474B7B360324D01D8A7", hash_generated_method = "FFD6397CB563411F811F75D731656326")
    public int start() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003840686 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003840686;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.631 -0400", hash_original_method = "7D10A3C1D28519413DA457C01967C482", hash_generated_method = "892E6BDBEC62849502C768252F113052")
    public int end() {
        int varB24BA409889D2DF54BA645250444F1AF_1683514761 = (start + rawString.length());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1855543708 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1855543708;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.631 -0400", hash_original_method = "9FB54278FE2075E29BA0E55156E431DE", hash_generated_method = "34658FEF4166546EFBCA9C148A871950")
    public String rawString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1927376005 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1927376005 = rawString;
        varB4EAC82CA7396A68D541C85D26508E83_1927376005.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1927376005;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.632 -0400", hash_original_method = "13786FFFFB16751EA6F3DAD6D70C98CC", hash_generated_method = "E72DAD048D2C44EE3103E2042D032A17")
    @Override
    public int hashCode() {
        int var68DAC3103D3FDE3551F375601B10A6D7_200035896 = (Arrays.hashCode(new Object[]{start, rawString, number}));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_680287088 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_680287088;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.632 -0400", hash_original_method = "38076D29780FBE1507C47919C30AB86E", hash_generated_method = "AD7AB0900518EB09A39EF9FAD8ABC62B")
    @Override
    public boolean equals(Object obj) {
        PhoneNumberMatch other = (PhoneNumberMatch) obj;
        boolean var543198B8CD21F9CD3A16350E5A2DC427_801181939 = (rawString.equals(other.rawString) && (start == other.start) &&
        number.equals(other.number));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1730819260 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1730819260;
        
        
      
    
        
      
    
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.633 -0400", hash_original_method = "9E681ADFB274F0FD80239D8E6C0D9096", hash_generated_method = "42213C0F4F9FBACE1083211E2B9B6CD3")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_726971948 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_726971948 = "PhoneNumberMatch [" + start() + "," + end() + ") " + rawString;
        varB4EAC82CA7396A68D541C85D26508E83_726971948.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_726971948;
        
        
    }

    
}

