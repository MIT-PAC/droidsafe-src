package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class NativeCollation {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.657 -0400", hash_original_method = "16B47962CFF99F85D0E598C53BC7328E", hash_generated_method = "FF71B9CC7F83E39BD5165BFFBBD0AADB")
    private  NativeCollation() {
        // ---------- Original Method ----------
    }

    
        public static void closeCollator(int address) {
    }

    
        public static int compare(int address, String source, String target) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int getAttribute(int address, int type) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int getCollationElementIterator(int address, String source) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static String getRules(int address) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static byte[] getSortKey(int address, String source) {
        return {DSUtils.UNKNOWN_BYTE};
    }

    
        public static int openCollator(String locale) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int openCollatorFromRules(String rules, int normalizationMode, int collationStrength) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int safeClone(int address) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static void setAttribute(int address, int type, int value) {
    }

    
        public static void closeElements(int address) {
    }

    
        public static int getMaxExpansion(int address, int order) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int getOffset(int address) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int next(int address) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int previous(int address) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static void reset(int address) {
    }

    
        public static void setOffset(int address, int offset) {
    }

    
        public static void setText(int address, String source) {
    }

    
}

