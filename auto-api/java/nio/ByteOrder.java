package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class ByteOrder {
    private String name;
    public boolean needsSwap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.491 -0400", hash_original_method = "B317EBC8D5650E5C34B265838B9D3EC5", hash_generated_method = "811E308AC774151CDB5D614032761341")
    @DSModeled(DSC.SAFE)
    private ByteOrder(String name, boolean needsSwap) {
        dsTaint.addTaint(needsSwap);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
        //this.name = name;
        //this.needsSwap = needsSwap;
    }

    
        private static boolean isLittleEndian() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static ByteOrder nativeOrder() {
        return NATIVE_ORDER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.491 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "07B6DEDCDA0BCBF94ECA7AFA0C3C49FD")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    private static final ByteOrder NATIVE_ORDER;
    public static final ByteOrder BIG_ENDIAN;
    public static final ByteOrder LITTLE_ENDIAN;
    static {
        boolean isLittleEndian = isLittleEndian();
        BIG_ENDIAN = new ByteOrder("BIG_ENDIAN", isLittleEndian);
        LITTLE_ENDIAN = new ByteOrder("LITTLE_ENDIAN", !isLittleEndian);
        NATIVE_ORDER = isLittleEndian ? LITTLE_ENDIAN : BIG_ENDIAN;
    }
    
}

