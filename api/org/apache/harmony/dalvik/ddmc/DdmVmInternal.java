package org.apache.harmony.dalvik.ddmc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class DdmVmInternal {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.062 -0400", hash_original_method = "D0F76540C42EA165AE45A0473185E42C", hash_generated_method = "25D97099B63C10431BD47D09A2644BA5")
    private  DdmVmInternal() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static void threadNotify(boolean enable) {
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean heapInfoNotify(int when) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_14218202 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_14218202;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean heapSegmentNotify(int when, int what,
        boolean isNative) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1093062549 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1093062549;
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] getThreadStats() {
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_319188016 = {DSUtils.UNKNOWN_BYTE};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_319188016;
    }

    
    @DSModeled(DSC.SAFE)
    public static StackTraceElement[] getStackTraceById(int threadId) {
    	StackTraceElement[] ste = new StackTraceElement[]{new StackTraceElement()};
    	ste[0].taint.addTaint(threadId);
    	return ste;
    }

    
    @DSModeled(DSC.SAFE)
    public static void enableRecentAllocations(boolean enable) {
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean getRecentAllocationStatus() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_13685764 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_13685764;
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] getRecentAllocations() {
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_125459604 = {DSUtils.UNKNOWN_BYTE};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_125459604;
    }

    
}

