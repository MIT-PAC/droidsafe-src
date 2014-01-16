package libcore.icu;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public final class NativeCollation {
    
    public static void closeCollator(int address) {
    }
    
    public static int compare(int address, String source, String target) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464475977 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464475977;
    }
    
    public static int getAttribute(int address, int type) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132251266 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132251266;
    }
    
    public static int getCollationElementIterator(int address, String source) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235712035 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235712035;
    }
    
    public static String getRules(int address) {
    	return new String();
    }
    
    public static byte[] getSortKey(int address, String source) {
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1322335140 = {DSUtils.UNKNOWN_BYTE};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1322335140;
    }
    
    public static int openCollator(String locale) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962390541 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962390541;
    }
    
    public static int openCollatorFromRules(String rules, int normalizationMode, int collationStrength) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_458425759 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_458425759;
    }
    
    public static int safeClone(int address) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1347696940 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1347696940;
    }
    
    public static void setAttribute(int address, int type, int value) {
    }
    
    public static void closeElements(int address) {
    }
    
    public static int getMaxExpansion(int address, int order) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599955914 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599955914;
    }
    
    public static int getOffset(int address) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_245441809 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_245441809;
    }
    
    public static int next(int address) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_662922028 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_662922028;
    }
    
    public static int previous(int address) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_333053362 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_333053362;
    }
    
    public static void reset(int address) {
    }
    
    public static void setOffset(int address, int offset) {
    }
    
    public static void setText(int address, String source) {
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:08.600 -0500", hash_original_method = "16B47962CFF99F85D0E598C53BC7328E", hash_generated_method = "5509F5737819DB87F3C8389561825DA9")
    
private NativeCollation() {
    }
    
}

