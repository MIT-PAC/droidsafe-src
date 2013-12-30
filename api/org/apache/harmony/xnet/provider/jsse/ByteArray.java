package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;






final class ByteArray {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.067 -0500", hash_original_field = "AB97A4156FC1CC1DAF26375194010FF1", hash_generated_field = "4E58ABB9D5068B90ACC1157BF07E4EBB")

    private  byte[] bytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.069 -0500", hash_original_field = "5A19588B577A4926772CAE314F19FADE", hash_generated_field = "38607001336EF9DE010EF92F750652A2")

    private  int hashCode;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.072 -0500", hash_original_method = "4AF9F563805F4ED44AAE8EE4F8A801D9", hash_generated_method = "4AF9F563805F4ED44AAE8EE4F8A801D9")
    
ByteArray(byte[] bytes) {
        this.bytes = bytes;
        this.hashCode = Arrays.hashCode(bytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.074 -0500", hash_original_method = "8BA9483852C95CF52834EFFEFBE67C86", hash_generated_method = "851304E2409C777BC00DDBBB294E80F0")
    
@Override public int hashCode() {
        return hashCode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.077 -0500", hash_original_method = "035A671466178159FCEA5052C8344F27", hash_generated_method = "79EBA8C552B7B5EA08711ADA9E10EF98")
    
@Override public boolean equals(Object o) {
        if (!(o instanceof ByteArray)) {
            return false;
        }
        ByteArray lhs = (ByteArray) o;
        return Arrays.equals(bytes, lhs.bytes);
    }

    
}

