package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class DERNull extends ASN1Null {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.042 -0400", hash_original_method = "99B54E5156DA58D37DF99A37E5693124", hash_generated_method = "4766F3DC44E05384E805FB26F1BF2111")
    protected  DERNull() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.042 -0400", hash_original_method = "ACDC3B7B82E2509D0E7268C448CC95AD", hash_generated_method = "AEEDAD60664E9B0995CB3B1D1775FE40")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(NULL, zeroBytes);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeEncoded(NULL, zeroBytes);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.042 -0400", hash_original_field = "FA0EF8F5F09AAABF4107EAA5562CD236", hash_generated_field = "BCDA123C54265156D82C94A2B76E09D3")

    public static final DERNull INSTANCE = new DERNull();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.042 -0400", hash_original_field = "10B04CBE17851A4A2AF266555C8AEAE5", hash_generated_field = "185855B00CAA5048208561E87384F3F7")

    private static byte[] zeroBytes = new byte[0];
}

