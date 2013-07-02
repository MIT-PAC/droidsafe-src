package org.apache.harmony.security.utils;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class Array {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.325 -0400", hash_original_method = "27C967B98A825ABE55DF7CE292BE2D15", hash_generated_method = "8F496C8B0F35FBBE27EB4065BD3777B5")
    private  Array() {
        
    }

    
    @DSModeled(DSC.SAFE)
    public static String getBytesAsString(byte[] data) {
        StringBuilder result = new StringBuilder(data.length * 3);
        for (int i = 0; i < data.length; ++i) {
            result.append(Byte.toHexString(data[i], false));
            result.append(' ');
        }
        return result.toString();
    }

    
    @DSModeled(DSC.SAFE)
    public static String toString(byte[] array, String prefix) {
        final String[] offsetPrefix = {
                "",
                "000",
                "00",
                "0",
                ""
        };
        StringBuilder sb = new StringBuilder();
        StringBuilder charForm = new StringBuilder();
        int i=0;
        for (i=0; i<array.length; i++) {
            if (i%16 == 0) {
                sb.append(prefix);
                String offset = Integer.toHexString(i);
                sb.append(offsetPrefix[offset.length()]);
                sb.append(offset);
                charForm.delete(0, charForm.length());
            }
            sb.append(' ');
            sb.append(Byte.toHexString(array[i], false));
            int currentByte = (0xff & array[i]);
            char currentChar = (char)(currentByte & 0xffff);
            charForm.append(
                    (Character.isISOControl(currentChar) ? '.' : currentChar));
            if ((i+1)%8 == 0) {
                sb.append(' ');
            }
            if ((i+1)%16 == 0) {
                sb.append(' ');
                sb.append(charForm.toString());
                sb.append('\n');
            }
        }
        if (i%16 != 0) {
            int ws2add = 16 - i%16;
            for (int j=0; j<ws2add; j++) {
                sb.append("   ");
            }
            if (ws2add > 8) {
                sb.append(' ');
            }
            sb.append("  ");
            sb.append(charForm.toString());
            sb.append('\n');
        }
        return sb.toString();
    }

    
}

