package org.bouncycastle.util.io.pem;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class PemHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.899 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.899 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.899 -0400", hash_original_method = "4509DA5CCC6D5B482BEA6C1D7CD04168", hash_generated_method = "7833D43EC03F2988C72B201F1918A3BB")
    public  PemHeader(String name, String value) {
        this.name = name;
        this.value = value;
        // ---------- Original Method ----------
        //this.name = name;
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.900 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "E3E96D447269DA5CD4F69A447F0A657A")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_292257632 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_292257632 = name;
        varB4EAC82CA7396A68D541C85D26508E83_292257632.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_292257632;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.900 -0400", hash_original_method = "CFCF943D36987E569CAB72593E604904", hash_generated_method = "9E33AB3C03945B9CD568ED420A51E842")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_829347178 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_829347178 = value;
        varB4EAC82CA7396A68D541C85D26508E83_829347178.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_829347178;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.904 -0400", hash_original_method = "D2F99D4FA1F9F9DCD18FFC2807839B4D", hash_generated_method = "310D0C29E3982CFD658CD68E5010E161")
    public int hashCode() {
        int varC70158E9C1B434721E06B7892EBB3099_1343861462 = (getHashCode(this.name) + 31 * getHashCode(this.value));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_271991237 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_271991237;
        // ---------- Original Method ----------
        //return getHashCode(this.name) + 31 * getHashCode(this.value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.904 -0400", hash_original_method = "008350332C23D1093274CD2597D3DC3D", hash_generated_method = "9D173E021493667575BB7DAEAD565B49")
    public boolean equals(Object o) {
        PemHeader other;
        other = (PemHeader)o;
        boolean var10EA29FD093456A46D621A5643069AF2_376146008 = (other == this || (isEqual(this.name, other.name) && isEqual(this.value, other.value)));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1726601019 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1726601019;
        // ---------- Original Method ----------
        //if (!(o instanceof PemHeader))
        //{
            //return false;
        //}
        //PemHeader other = (PemHeader)o;
        //return other == this || (isEqual(this.name, other.name) && isEqual(this.value, other.value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.904 -0400", hash_original_method = "552BFCCB5F897360ADAD8A79D56E72F9", hash_generated_method = "00313A4DA717085D3CCADC439CB06F44")
    private int getHashCode(String s) {
        int varCC059AF02BE126811FEBD373717A473C_263595570 = (s.hashCode());
        addTaint(s.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1461956651 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1461956651;
        // ---------- Original Method ----------
        //if (s == null)
        //{
            //return 1;
        //}
        //return s.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.905 -0400", hash_original_method = "56C7E9071A8414DCCD1359B9AFE0CC30", hash_generated_method = "1B9E74AA5D0B121C994CE91D12914EA3")
    private boolean isEqual(String s1, String s2) {
        boolean varD27A4BC068AEDBEFAE6028FE88C4B046_1544737510 = (s1.equals(s2));
        addTaint(s1.getTaint());
        addTaint(s2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1889133486 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1889133486;
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

