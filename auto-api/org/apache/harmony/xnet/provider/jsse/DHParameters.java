package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DHParameters {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.884 -0400", hash_original_method = "808CB0297624A41B24EE6EECFB636C09", hash_generated_method = "808CB0297624A41B24EE6EECFB636C09")
    public DHParameters ()
    {
        //Synthesized constructor
    }


        public static byte[] getPrime() {
        return prime;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.885 -0400", hash_original_field = "F4CCA7E9B059F7B0810A83F444F38F8A", hash_generated_field = "A774C48B8B96AAA5E63098DCD36D323F")

    private static byte[] prime512 = new byte[] { (byte) 0xF5, (byte) 0x2A, (byte) 0xFF,
            (byte) 0x3C, (byte) 0xE1, (byte) 0xB1, (byte) 0x29, (byte) 0x40,
            (byte) 0x18, (byte) 0x11, (byte) 0x8D, (byte) 0x7C, (byte) 0x84,
            (byte) 0xA7, (byte) 0x0A, (byte) 0x72, (byte) 0xD6, (byte) 0x86,
            (byte) 0xC4, (byte) 0x03, (byte) 0x19, (byte) 0xC8, (byte) 0x07,
            (byte) 0x29, (byte) 0x7A, (byte) 0xCA, (byte) 0x95, (byte) 0x0C,
            (byte) 0xD9, (byte) 0x96, (byte) 0x9F, (byte) 0xAB, (byte) 0xD0,
            (byte) 0x0A, (byte) 0x50, (byte) 0x9B, (byte) 0x02, (byte) 0x46,
            (byte) 0xD3, (byte) 0x08, (byte) 0x3D, (byte) 0x66, (byte) 0xA4,
            (byte) 0x5D, (byte) 0x41, (byte) 0x9F, (byte) 0x9C, (byte) 0x7C,
            (byte) 0xBD, (byte) 0x89, (byte) 0x4B, (byte) 0x22, (byte) 0x19,
            (byte) 0x26, (byte) 0xBA, (byte) 0xAB, (byte) 0xA2, (byte) 0x5E,
            (byte) 0xC3, (byte) 0x55, (byte) 0xE9, (byte) 0x2A, (byte) 0x05,
            (byte) 0x5F };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.885 -0400", hash_original_field = "5A8CCCF39F1DAAAAE10AE3EA05562660", hash_generated_field = "4BD9D5307F569DE872E78F82C3590F4A")

    private static byte[] primeGroup1 = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.885 -0400", hash_original_field = "5C1CE63351F7C68E10B270BCDB3B60CC", hash_generated_field = "B64A7C46E43D3F2E0EAFEF04157CFA2C")

    private static byte[] primeGroup2 = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.886 -0400", hash_original_field = "10F12151EF41361B91EE3FC1065E14D2", hash_generated_field = "E308A45DAEAECF2B8BCC430FCFA81CB6")

    private static byte[] prime;
    static {
        prime = prime512;
    }
    
}

