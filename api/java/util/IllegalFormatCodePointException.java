package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;






public class IllegalFormatCodePointException extends IllegalFormatException implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.924 -0500", hash_original_field = "76E211968EB608EC9B9A9792BB3EE77B", hash_generated_field = "CA23A340A271E932968B5D7D53D04890")

    private static final long serialVersionUID = 19080630L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.926 -0500", hash_original_field = "0AF4C3E60D89F741481DEC8F5DE5264F", hash_generated_field = "50AD48E12B8BEBE82F0051066582ABE2")


    private  int c;

    /**
     * Constructs a new {@code IllegalFormatCodePointException} which is
     * specified by the invalid Unicode code point.
     *
     * @param c
     *           the invalid Unicode code point.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.929 -0500", hash_original_method = "EC5D1DD50821B22662FE61EFD96C533A", hash_generated_method = "202A540A28DC620266DE82CA6597C4B9")
    
public IllegalFormatCodePointException(int c) {
        this.c = c;
    }

    /**
     * Returns the invalid Unicode code point.
     *
     * @return the invalid Unicode code point.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.931 -0500", hash_original_method = "D5B710B3F21DF9B84478D362C18B2C11", hash_generated_method = "3D186FA967EE924486A47F724539C263")
    
public int getCodePoint() {
        return c;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.934 -0500", hash_original_method = "D74EDE3BF1A0D3C4B575CB0DB2BFF88F", hash_generated_method = "06B23DFB85682ACA4F776BB49368A799")
    
@Override
    public String getMessage() {
        return Integer.toHexString(c);
    }
}

