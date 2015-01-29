package dalvik.system.profiler;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class BinaryHprof {

    /**
     * Returns the file's magic value as a String if found, otherwise null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.303 -0500", hash_original_method = "61CB88820073366C14C36F5A2569814F", hash_generated_method = "7D268822285759A7379C078F51F43CDF")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.297 -0500", hash_original_field = "4C0795C0A939AE0238A0C6B9E149787C", hash_generated_field = "8349BBEB77016752FBF2456D191A1A2F")

    public static final int ID_SIZE = 4;
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.306 -0500", hash_original_field = "C26F073E58DC5C007884B060320F9888", hash_generated_field = "15A181EFB49DE6689AD9E2D055EF9D56")

        public  byte tag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.308 -0500", hash_original_field = "F9C82337597E99B795BA005CA377DE24", hash_generated_field = "E90D651047975E15CF469F83E4A07DBE")

        public  int minimumSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.311 -0500", hash_original_field = "3B2E03B648ADD645927E4F8A923F302D", hash_generated_field = "3E89F12D59565D8767909D87EBE870D5")

        public  int maximumSize;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.315 -0500", hash_original_method = "20A9335AD25AC12DE629BEE6EC4927A9", hash_generated_method = "8EDCD2693AC763165D8BFDE473E035FD")
            
private Tag(int tag, int size) {
            this.tag = (byte) tag;
            if (size > 0) {
                // fixed size, max and min the same
                this.minimumSize = size;
                this.maximumSize = size;
            } else {
                // only minimum bound
                this.minimumSize = -size;
                this.maximumSize = 0;
            }
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.318 -0500", hash_original_field = "B64B75FF702546B30DF2E0F7D3776497", hash_generated_field = "6B09058F91885EB1EE8E9D1B4BCCB6D0")

        private static final Map<Byte, Tag> BYTE_TO_TAG
                = new HashMap<Byte, Tag>();
        static {
            for (Tag v : Tag.values()) {
                BYTE_TO_TAG.put(v.tag, v);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.320 -0500", hash_original_method = "11789F2186F6F0135167D441B4582303", hash_generated_method = "A7A179643D566160BDF9A5DA3C110E03")
            
public static Tag get(byte tag) {
            return BYTE_TO_TAG.get(tag);
        }

        /**
         * Returns null if the actual size meets expectations, or a
         * String error message if not.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.323 -0500", hash_original_method = "1B6C09AD0427EF95355AB3C916EF6822", hash_generated_method = "293BBAAE63E6421CC2C1A13B172ADBFA")
            
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.328 -0500", hash_original_field = "24C81C32E60A87991A7246FE6D41B544", hash_generated_field = "9F0E391B0FF0D91D2C233A214B961BB3")

        public  int bitmask;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.331 -0500", hash_original_method = "CC29A6BB8696C667CE93E47C5C68F8E0", hash_generated_method = "31B4E61E459470A9DE162D5E5E3CF184")
            
private ControlSettings(int bitmask) {
            this.bitmask = bitmask;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.300 -0500", hash_original_field = "E7AA641A39A04D37736CD13C8EEF9C32", hash_generated_field = "D7189B99CFC6CE5EBE348FB248539A4B")

    static String MAGIC = "JAVA PROFILE ";
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.871 -0400", hash_original_method = "5337F4C002A0025B40CFBFFF348D94A9", hash_generated_method = "5337F4C002A0025B40CFBFFF348D94A9")
    public BinaryHprof ()
    {
        //Synthesized constructor
    }
}

