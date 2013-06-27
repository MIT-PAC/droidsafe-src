package org.bouncycastle.util.io.pem;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class PemHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.917 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.918 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.918 -0400", hash_original_method = "4509DA5CCC6D5B482BEA6C1D7CD04168", hash_generated_method = "7833D43EC03F2988C72B201F1918A3BB")
    public  PemHeader(String name, String value) {
        this.name = name;
        this.value = value;
        // ---------- Original Method ----------
        //this.name = name;
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.919 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "BE21874FFA6B17CF4699D6D33F768660")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_294307913 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_294307913 = name;
        varB4EAC82CA7396A68D541C85D26508E83_294307913.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_294307913;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.919 -0400", hash_original_method = "CFCF943D36987E569CAB72593E604904", hash_generated_method = "B5E4EAAA8B7648ABE6C1B1353D998A65")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_149761539 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_149761539 = value;
        varB4EAC82CA7396A68D541C85D26508E83_149761539.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_149761539;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.928 -0400", hash_original_method = "D2F99D4FA1F9F9DCD18FFC2807839B4D", hash_generated_method = "A6DF14C650AD79A6E97B86CDA84321E5")
    public int hashCode() {
        int varC70158E9C1B434721E06B7892EBB3099_811834449 = (getHashCode(this.name) + 31 * getHashCode(this.value));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_559733817 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_559733817;
        // ---------- Original Method ----------
        //return getHashCode(this.name) + 31 * getHashCode(this.value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.935 -0400", hash_original_method = "008350332C23D1093274CD2597D3DC3D", hash_generated_method = "BAF8878F815183C107601770D74A461A")
    public boolean equals(Object o) {
        PemHeader other;
        other = (PemHeader)o;
        boolean var10EA29FD093456A46D621A5643069AF2_176396232 = (other == this || (isEqual(this.name, other.name) && isEqual(this.value, other.value)));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_784018461 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_784018461;
        // ---------- Original Method ----------
        //if (!(o instanceof PemHeader))
        //{
            //return false;
        //}
        //PemHeader other = (PemHeader)o;
        //return other == this || (isEqual(this.name, other.name) && isEqual(this.value, other.value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.935 -0400", hash_original_method = "552BFCCB5F897360ADAD8A79D56E72F9", hash_generated_method = "0F48C66603956D4542E6D9B200E3A23F")
    private int getHashCode(String s) {
        int varCC059AF02BE126811FEBD373717A473C_1115555253 = (s.hashCode());
        addTaint(s.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1478604852 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1478604852;
        // ---------- Original Method ----------
        //if (s == null)
        //{
            //return 1;
        //}
        //return s.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.936 -0400", hash_original_method = "56C7E9071A8414DCCD1359B9AFE0CC30", hash_generated_method = "0CD2036C1F64214A3D5A99C6AF8C7013")
    private boolean isEqual(String s1, String s2) {
        boolean varD27A4BC068AEDBEFAE6028FE88C4B046_1616532721 = (s1.equals(s2));
        addTaint(s1.getTaint());
        addTaint(s2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_25783698 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_25783698;
        // ---------- Original Method ----------
        //if (s1 == s2)
        //{
            //return true;
        //}
        //if (s1 == null || s2 == null)
        //{
            //return false;
        //}
        //return s1.equals(s2);
    }

    
}

