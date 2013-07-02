package org.apache.commons.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;

public class HexDump {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.337 -0400", hash_original_method = "DD2FEACFBC451CD61B40E6EB3CDE5668", hash_generated_method = "2D5FB889EB2962854AC6D6EEEAC5CD2F")
    public  HexDump() {
        super();
        
    }

    
    @DSModeled(DSC.SAFE)
    public static void dump(byte[] data, long offset,
                            OutputStream stream, int index) throws IOException, ArrayIndexOutOfBoundsException,
            IllegalArgumentException {
        if (index < 0 || index >= data.length) {
            throw new ArrayIndexOutOfBoundsException(
                    "illegal index: " + index + " into array of length "
                    + data.length);
        }
        if (stream == null) {
            throw new IllegalArgumentException("cannot write to nullstream");
        }
        long display_offset = offset + index;
        StringBuilder buffer = new StringBuilder(74);
        for (int j = index; j < data.length; j += 16) {
            int chars_read = data.length - j;
            if (chars_read > 16) {
                chars_read = 16;
            }
            dump(buffer, display_offset).append(' ');
            for (int k = 0; k < 16; k++) {
                if (k < chars_read) {
                    dump(buffer, data[k + j]);
                } else {
                    buffer.append("  ");
                }
                buffer.append(' ');
            }
            for (int k = 0; k < chars_read; k++) {
                if (data[k + j] >= ' ' && data[k + j] < 127) {
                    buffer.append((char) data[k + j]);
                } else {
                    buffer.append('.');
                }
            }
            buffer.append(EOL);
            stream.write(buffer.toString().getBytes());
            stream.flush();
            buffer.setLength(0);
            display_offset += chars_read;
        }
    }

    
    @DSModeled(DSC.SAFE)
    private static StringBuilder dump(StringBuilder _lbuffer, long value) {
        for (int j = 0; j < 8; j++) {
            _lbuffer
                    .append(_hexcodes[(int) (value >> _shifts[j]) & 15]);
        }
        return _lbuffer;
    }

    
    @DSModeled(DSC.SAFE)
    private static StringBuilder dump(StringBuilder _cbuffer, byte value) {
        for (int j = 0; j < 2; j++) {
            _cbuffer.append(_hexcodes[value >> _shifts[j + 6] & 15]);
        }
        return _cbuffer;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.338 -0400", hash_original_field = "619A4408A01F7F66FF2E685DB5C06BCC", hash_generated_field = "A7F0DD505858F5926B10790A390B4BA5")

    public static final String EOL =
            System.getProperty("line.separator");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.338 -0400", hash_original_field = "3F7F231B8DA48C853BB81FF3F4CE12F5", hash_generated_field = "B8FA09A9F521E192770D2BBBC2317DC7")

    private static final char[] _hexcodes = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'
            };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.338 -0400", hash_original_field = "27A3C131835C3B6CA802321ED3F58CCF", hash_generated_field = "B4BAE99288E9B5FBB7D8F781B2DFB5E4")

    private static final int[] _shifts = {
                28, 24, 20, 16, 12, 8, 4, 0
            };
}

