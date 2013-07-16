package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class NativeCollation {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.703 -0400", hash_original_method = "16B47962CFF99F85D0E598C53BC7328E", hash_generated_method = "FF71B9CC7F83E39BD5165BFFBBD0AADB")
    private  NativeCollation() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static void closeCollator(int address) {
    }

    
    @DSModeled(DSC.SAFE)
    public static int compare(int address, String source, String target) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464475977 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464475977;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getAttribute(int address, int type) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132251266 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132251266;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getCollationElementIterator(int address, String source) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235712035 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235712035;
    }

    
    @DSModeled(DSC.SAFE)
    public static String getRules(int address) {
    	return new String();
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] getSortKey(int address, String source) {
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1322335140 = {DSUtils.UNKNOWN_BYTE};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1322335140;
    }

    
    @DSModeled(DSC.SAFE)
    public static int openCollator(String locale) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962390541 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962390541;
    }

    
    @DSModeled(DSC.SAFE)
    public static int openCollatorFromRules(String rules, int normalizationMode, int collationStrength) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_458425759 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_458425759;
    }

    
    @DSModeled(DSC.SAFE)
    public static int safeClone(int address) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1347696940 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1347696940;
    }

    
    @DSModeled(DSC.SAFE)
    public static void setAttribute(int address, int type, int value) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void closeElements(int address) {
    }

    
    @DSModeled(DSC.SAFE)
    public static int getMaxExpansion(int address, int order) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599955914 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599955914;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getOffset(int address) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_245441809 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_245441809;
    }

    
    @DSModeled(DSC.SAFE)
    public static int next(int address) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_662922028 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_662922028;
    }

    
    @DSModeled(DSC.SAFE)
    public static int previous(int address) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_333053362 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_333053362;
    }

    
    @DSModeled(DSC.SAFE)
    public static void reset(int address) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void setOffset(int address, int offset) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void setText(int address, String source) {
    }

    
}

