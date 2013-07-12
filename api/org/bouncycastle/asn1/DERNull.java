package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class DERNull extends ASN1Null {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.092 -0400", hash_original_method = "99B54E5156DA58D37DF99A37E5693124", hash_generated_method = "4766F3DC44E05384E805FB26F1BF2111")
    protected  DERNull() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.092 -0400", hash_original_method = "ACDC3B7B82E2509D0E7268C448CC95AD", hash_generated_method = "FA67DDB49B43779873195BDBFD4BBF42")
     void encode(
        DEROutputStream  out) throws IOException {
        addTaint(out.getTaint());
        out.writeEncoded(NULL, zeroBytes);
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.092 -0400", hash_original_field = "FA0EF8F5F09AAABF4107EAA5562CD236", hash_generated_field = "BCDA123C54265156D82C94A2B76E09D3")

    public static final DERNull INSTANCE = new DERNull();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.092 -0400", hash_original_field = "10B04CBE17851A4A2AF266555C8AEAE5", hash_generated_field = "934335CBA6DEFFFB24BA758BD29A9D23")

    private static final byte[] zeroBytes = new byte[0];
}

