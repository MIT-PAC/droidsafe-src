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
        return (address + source.getTaintInt() + target.getTaintInt());
    }
    
    public static int getAttribute(int address, int type) {
        return address + type;
    }
    
    public static int getCollationElementIterator(int address, String source) {
        return address + source.getTaintInt();
    }
    
    public static String getRules(int address) {
    	return new String();
    }
    
    public static byte[] getSortKey(int address, String source) {
        byte[] bytes = new byte[10];
        bytes[0] = (byte)(address + source.getTaintInt());
        return bytes;
    }
    
    public static int openCollator(String locale) {
        return locale.getTaintInt();
    }
    
    public static int openCollatorFromRules(String rules, int normalizationMode, int collationStrength) {
        return rules.getTaintInt() + normalizationMode + collationStrength;
    }
    
    public static int safeClone(int address) {
        return address;
    }
    
    public static void setAttribute(int address, int type, int value) {
    }
    
    public static void closeElements(int address) {
    }
    
    public static int getMaxExpansion(int address, int order) {
        return address + order;
    }
    
    public static int getOffset(int address) {
        return address;
    }
    
    public static int next(int address) {
        return address;
    }
    
    public static int previous(int address) {
        return address;
    }
    
    public static void reset(int address) {
    }
    
    public static void setOffset(int address, int offset) {
    }
    
    public static void setText(int address, String source) {
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:08.600 -0500", hash_original_method = "16B47962CFF99F85D0E598C53BC7328E", hash_generated_method = "5509F5737819DB87F3C8389561825DA9")
    
private NativeCollation() {
    }
    
}

