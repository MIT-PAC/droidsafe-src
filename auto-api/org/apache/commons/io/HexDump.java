package org.apache.commons.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;

public class HexDump {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.734 -0400", hash_original_method = "DD2FEACFBC451CD61B40E6EB3CDE5668", hash_generated_method = "2D5FB889EB2962854AC6D6EEEAC5CD2F")
    public  HexDump() {
        super();
        // ---------- Original Method ----------
    }

    
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

    
        private static StringBuilder dump(StringBuilder _lbuffer, long value) {
        for (int j = 0; j < 8; j++) {
            _lbuffer
                    .append(_hexcodes[(int) (value >> _shifts[j]) & 15]);
        }
        return _lbuffer;
    }

    
        private static StringBuilder dump(StringBuilder _cbuffer, byte value) {
        for (int j = 0; j < 2; j++) {
            _cbuffer.append(_hexcodes[value >> _shifts[j + 6] & 15]);
        }
        return _cbuffer;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.744 -0400", hash_original_field = "619A4408A01F7F66FF2E685DB5C06BCC", hash_generated_field = "A7F0DD505858F5926B10790A390B4BA5")

    public static final String EOL =
            System.getProperty("line.separator");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.744 -0400", hash_original_field = "3F7F231B8DA48C853BB81FF3F4CE12F5", hash_generated_field = "84105A8314BB9B7A769FD233AB965CA3")

    private static char[] _hexcodes = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.744 -0400", hash_original_field = "27A3C131835C3B6CA802321ED3F58CCF", hash_generated_field = "56ED9621A60D25C81D401A3BA4A5E5D7")

    private static int[] _shifts = ;
}

