package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DHParameters {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.700 -0400", hash_original_method = "808CB0297624A41B24EE6EECFB636C09", hash_generated_method = "808CB0297624A41B24EE6EECFB636C09")
    public DHParameters ()
    {
        //Synthesized constructor
    }


        public static byte[] getPrime() {
        return prime;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.701 -0400", hash_original_field = "F4CCA7E9B059F7B0810A83F444F38F8A", hash_generated_field = "A774C48B8B96AAA5E63098DCD36D323F")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.701 -0400", hash_original_field = "5A8CCCF39F1DAAAAE10AE3EA05562660", hash_generated_field = "E84D0BD2C59E053701D27F642EE57F73")

    private static byte[] primeGroup1 = { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xC9,
            (byte) 0x0F, (byte) 0xDA, (byte) 0xA2, (byte) 0x21, (byte) 0x68,
            (byte) 0xC2, (byte) 0x34, (byte) 0xC4, (byte) 0xC6, (byte) 0x62,
            (byte) 0x8B, (byte) 0x80, (byte) 0xDC, (byte) 0x1C, (byte) 0xD1,
            (byte) 0x29, (byte) 0x02, (byte) 0x4E, (byte) 0x08, (byte) 0x8A,
            (byte) 0x67, (byte) 0xCC, (byte) 0x74, (byte) 0x02, (byte) 0x0B,
            (byte) 0xBE, (byte) 0xA6, (byte) 0x3B, (byte) 0x13, (byte) 0x9B,
            (byte) 0x22, (byte) 0x51, (byte) 0x4A, (byte) 0x08, (byte) 0x79,
            (byte) 0x8E, (byte) 0x34, (byte) 0x04, (byte) 0xDD, (byte) 0xEF,
            (byte) 0x95, (byte) 0x19, (byte) 0xB3, (byte) 0xCD, (byte) 0x3A,
            (byte) 0x43, (byte) 0x1B, (byte) 0x30, (byte) 0x2B, (byte) 0x0A,
            (byte) 0x6D, (byte) 0xF2, (byte) 0x5F, (byte) 0x14, (byte) 0x37,
            (byte) 0x4F, (byte) 0xE1, (byte) 0x35, (byte) 0x6D, (byte) 0x6D,
            (byte) 0x51, (byte) 0xC2, (byte) 0x45, (byte) 0xE4, (byte) 0x85,
            (byte) 0xB5, (byte) 0x76, (byte) 0x62, (byte) 0x5E, (byte) 0x7E,
            (byte) 0xC6, (byte) 0xF4, (byte) 0x4C, (byte) 0x42, (byte) 0xE9,
            (byte) 0xA6, (byte) 0x3A, (byte) 0x36, (byte) 0x20, (byte) 0xFF,
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
            (byte) 0xFF, (byte) 0xFF };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.704 -0400", hash_original_field = "5C1CE63351F7C68E10B270BCDB3B60CC", hash_generated_field = "70AC00DE5475B939FD9562176AA240C7")

    private static byte[] primeGroup2 = { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xC9,
            (byte) 0x0F, (byte) 0xDA, (byte) 0xA2, (byte) 0x21, (byte) 0x68,
            (byte) 0xC2, (byte) 0x34, (byte) 0xC4, (byte) 0xC6, (byte) 0x62,
            (byte) 0x8B, (byte) 0x80, (byte) 0xDC, (byte) 0x1C, (byte) 0xD1,
            (byte) 0x29, (byte) 0x02, (byte) 0x4E, (byte) 0x08, (byte) 0x8A,
            (byte) 0x67, (byte) 0xCC, (byte) 0x74, (byte) 0x02, (byte) 0x0B,
            (byte) 0xBE, (byte) 0xA6, (byte) 0x3B, (byte) 0x13, (byte) 0x9B,
            (byte) 0x22, (byte) 0x51, (byte) 0x4A, (byte) 0x08, (byte) 0x79,
            (byte) 0x8E, (byte) 0x34, (byte) 0x04, (byte) 0xDD, (byte) 0xEF,
            (byte) 0x95, (byte) 0x19, (byte) 0xB3, (byte) 0xCD, (byte) 0x3A,
            (byte) 0x43, (byte) 0x1B, (byte) 0x30, (byte) 0x2B, (byte) 0x0A,
            (byte) 0x6D, (byte) 0xF2, (byte) 0x5F, (byte) 0x14, (byte) 0x37,
            (byte) 0x4F, (byte) 0xE1, (byte) 0x35, (byte) 0x6D, (byte) 0x6D,
            (byte) 0x51, (byte) 0xC2, (byte) 0x45, (byte) 0xE4, (byte) 0x85,
            (byte) 0xB5, (byte) 0x76, (byte) 0x62, (byte) 0x5E, (byte) 0x7E,
            (byte) 0xC6, (byte) 0xF4, (byte) 0x4C, (byte) 0x42, (byte) 0xE9,
            (byte) 0xA6, (byte) 0x37, (byte) 0xED, (byte) 0x6B, (byte) 0x0B,
            (byte) 0xFF, (byte) 0x5C, (byte) 0xB6, (byte) 0xF4, (byte) 0x06,
            (byte) 0xB7, (byte) 0xED, (byte) 0xEE, (byte) 0x38, (byte) 0x6B,
            (byte) 0xFB, (byte) 0x5A, (byte) 0x89, (byte) 0x9F, (byte) 0xA5,
            (byte) 0xAE, (byte) 0x9F, (byte) 0x24, (byte) 0x11, (byte) 0x7C,
            (byte) 0x4B, (byte) 0x1F, (byte) 0xE6, (byte) 0x49, (byte) 0x28,
            (byte) 0x66, (byte) 0x51, (byte) 0xEC, (byte) 0xE6, (byte) 0x53,
            (byte) 0x81, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.704 -0400", hash_original_field = "10F12151EF41361B91EE3FC1065E14D2", hash_generated_field = "E308A45DAEAECF2B8BCC430FCFA81CB6")

    private static byte[] prime;
    static {
        prime = prime512;
    }
    
}

