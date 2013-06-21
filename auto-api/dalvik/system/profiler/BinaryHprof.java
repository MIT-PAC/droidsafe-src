package dalvik.system.profiler;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class BinaryHprof {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.307 -0400", hash_original_method = "80509E592C23CBA2243E8CDCC0E26B12", hash_generated_method = "80509E592C23CBA2243E8CDCC0E26B12")
        public BinaryHprof ()
    {
    }


        public static final String readMagic(DataInputStream in) {
        try {
            byte[] bytes = new byte[512];
            for (int i = 0; i < bytes.length; i++) {
                byte b = in.readByte();
                if (b == '\0') {
                    String string = new String(bytes, 0, i, "UTF-8");
                    if (string.startsWith(MAGIC)) {
                        return string;
                    }
                    return null;
                }
                bytes[i] = b;
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    
    public static enum Tag {
        STRING_IN_UTF8(0x01, -ID_SIZE),
        LOAD_CLASS(0x02, 4 + ID_SIZE + 4 + ID_SIZE),
        UNLOAD_CLASS(0x03, 4),
        STACK_FRAME(0x04, ID_SIZE + ID_SIZE + ID_SIZE + ID_SIZE + 4 + 4),
        STACK_TRACE(0x05, -(4 + 4 + 4)),
        ALLOC_SITES(0x06, -(2 + 4 + 4 + 4 + 8 + 8 + 4)),
        HEAP_SUMMARY(0x07, 4 + 4 + 8 + 8),
        START_THREAD(0x0a, 4 + ID_SIZE + 4 + ID_SIZE + ID_SIZE + ID_SIZE),
        END_THREAD(0x0b, 4),
        HEAP_DUMP(0x0c, -0),
        HEAP_DUMP_SEGMENT(0x1c, -0),
        HEAP_DUMP_END(0x2c, 0),
        CPU_SAMPLES(0x0d, -(4 + 4)),
        CONTROL_SETTINGS(0x0e, 4 + 2);
        public final byte tag;
        public final int minimumSize;
        public final int maximumSize;
        private Tag(int tag, int size) {
            this.tag = (byte) tag;
            if (size > 0) {
                this.minimumSize = size;
                this.maximumSize = size;
            } else {
                this.minimumSize = -size;
                this.maximumSize = 0;
            }
        }
        private static final Map<Byte, Tag> BYTE_TO_TAG
                = new HashMap<Byte, Tag>();
        static {
            for (Tag v : Tag.values()) {
                BYTE_TO_TAG.put(v.tag, v);
            }
        }
        public static Tag get(byte tag) {
            return BYTE_TO_TAG.get(tag);
        }
        public String checkSize(int actual) {
            if (actual < minimumSize) {
                return "expected a minimial record size of " + minimumSize + " for " + this
                        + " but received " + actual;
            }
            if (maximumSize == 0) {
                return null;
            }
            if (actual > maximumSize) {
                return "expected a maximum record size of " + maximumSize + " for " + this
                        + " but received " + actual;
            }
            return null;
        }
    }

    
    public static enum ControlSettings {
        ALLOC_TRACES(0x01),
        CPU_SAMPLING(0x02);
        public final int bitmask;
        private ControlSettings(int bitmask) {
            this.bitmask = bitmask;
        }
    }

    
    public static final int ID_SIZE = 4;
    static String MAGIC = "JAVA PROFILE ";
}

