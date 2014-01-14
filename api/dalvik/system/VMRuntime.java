package dalvik.system;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class VMRuntime {

    /**
     * Returns the object that represents the VM instance's Dalvik-specific
     * runtime environment.
     *
     * @return the runtime object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.059 -0500", hash_original_method = "CBA2B68727D1F6F9168A66453269BED7", hash_generated_method = "B3FF717E7D00C98A9C1EB7ECEBF6367C")
    
public static VMRuntime getRuntime() {
        return THE_ONE;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.054 -0500", hash_original_field = "6108CD8BBAD4D69277D78C6C5769CAC1", hash_generated_field = "894A31B8E254C688D0C13EABA3654B94")

    private static final VMRuntime THE_ONE = new VMRuntime();

    /**
     * Prevents this class from being instantiated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.057 -0500", hash_original_method = "33A03FA36AA2C869C23BC2B48A2B01BF", hash_generated_method = "756025D690F3417AC1E320794E486242")
    
private VMRuntime() {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.800 -0400", hash_original_method = "2960BD7EBD269C359C23EB7E2C183AE6", hash_generated_method = "2D5C10CC3D28CEC7E78CF04874E61B1D")
    public String[] properties() {
    	String[] props = new String[0];
    	return props;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.800 -0400", hash_original_method = "ACD1BDE0C9D7AA5A704C76C5A226A571", hash_generated_method = "3F7EFD902B37074211328DCB58E5B9CE")
    public String bootClassPath() {
    	return new String();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.801 -0400", hash_original_method = "F880EBCB28C92D3EB2F8227CAD3AB51E", hash_generated_method = "A63F2018F96FFCB76D226498854F0584")
    public String classPath() {
    	return new String();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.801 -0400", hash_original_method = "91B638A4E83CB522FD5F0DBC3B106E1F", hash_generated_method = "0FC91AF110114BAEF0A2D2BE50FBA59C")
    public String vmVersion() {
    	return new String();
    }

    /**
     * Gets the current ideal heap utilization, represented as a number
     * between zero and one.  After a GC happens, the Dalvik heap may
     * be resized so that (size of live objects) / (size of heap) is
     * equal to this number.
     *
     * @return the current ideal heap utilization
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.079 -0500", hash_original_method = "A53C7C5E8A86B0A14FF3A91D5B112A95", hash_generated_method = "04E8E12A216710B02A37D7C8CF9C6330")
    
    public float getTargetHeapUtilization(){
    	//Formerly a native method
    	return getTaintFloat();
    }

    /**
     * Sets the current ideal heap utilization, represented as a number
     * between zero and one.  After a GC happens, the Dalvik heap may
     * be resized so that (size of live objects) / (size of heap) is
     * equal to this number.
     *
     * <p>This is only a hint to the garbage collector and may be ignored.
     *
     * @param newTarget the new suggested ideal heap utilization.
     *                  This value may be adjusted internally.
     * @return the previous ideal heap utilization
     * @throws IllegalArgumentException if newTarget is &lt;= 0.0 or &gt;= 1.0
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.081 -0500", hash_original_method = "F170D2A35A1238A4622F6C568D71821B", hash_generated_method = "63D4DE5166AF6144484EDCE804D08415")
    
public float setTargetHeapUtilization(float newTarget) {
        if (newTarget <= 0.0 || newTarget >= 1.0) {
            throw new IllegalArgumentException(newTarget +
                    " out of range (0,1)");
        }
        /* Synchronize to make sure that only one thread gets
         * a given "old" value if both update at the same time.
         * Allows for reliable save-and-restore semantics.
         */
        synchronized (this) {
            float oldTarget = getTargetHeapUtilization();
            nativeSetTargetHeapUtilization(newTarget);
            return oldTarget;
        }
    }

    /**
     * Sets the target SDK version. Should only be called before the
     * app starts to run, because it may change the VM's behavior in
     * dangerous ways. Use 0 to mean "current" (since callers won't
     * necessarily know the actual current SDK version, and the
     * allocated version numbers start at 1).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.085 -0500", hash_original_method = "C39A30D8892B0E36B74298597ED5FBE9", hash_generated_method = "A4BF180AF10C8672A4771D8D1BA6BFDF")
    
    public void setTargetSdkVersion(int targetSdkVersion){
    	//Formerly a native method
    	addTaint(targetSdkVersion);
    }

    /**
     * This method exists for binary compatibility.  It was part of a
     * heap sizing API which was removed in Honeycomb.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.088 -0500", hash_original_method = "923B1334376C4F437A073246F9A10510", hash_generated_method = "744B0BA307BEFA7C92952F34F23E8D69")
    
@Deprecated
    public long getMinimumHeapSize() {
        return 0;
    }

    /**
     * This method exists for binary compatibility.  It was part of a
     * heap sizing API which was removed in Honeycomb.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.091 -0500", hash_original_method = "CEB5420B7859E2786C7813E3E643E566", hash_generated_method = "F536C31D9AE833438A6B6BE8C37140D4")
    
@Deprecated
    public long setMinimumHeapSize(long size) {
        return 0;
    }

    /**
     * This method exists for binary compatibility.  It used to
     * perform a garbage collection that cleared SoftReferences.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.093 -0500", hash_original_method = "7E7FC96AF2763DCE3DA2004144A94138", hash_generated_method = "9796C302A4192B7DCB46D87DA5E6D425")
    
@Deprecated
    public void gcSoftReferences() {}

    /**
     * This method exists for binary compatibility.  It is equivalent
     * to {@link System#runFinalization}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.096 -0500", hash_original_method = "3F466C6AD532878D6C4CCB4CF518C455", hash_generated_method = "1C9F5BB8A2B98711006F5F671786C000")
    
@Deprecated
    public void runFinalizationSync() {
        System.runFinalization();
    }

    /**
     * Implements setTargetHeapUtilization().
     *
     * @param newTarget the new suggested ideal heap utilization.
     *                  This value may be adjusted internally.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.100 -0500", hash_original_method = "1BC492CFAAC06440005836321EF40EC6", hash_generated_method = "E8E53714CB7D45FC31B5E152CC74A9F2")
    
    private void nativeSetTargetHeapUtilization(float newTarget){
    	//Formerly a native method
    	addTaint(newTarget);
    }

    /**
     * This method exists for binary compatibility.  It was part of
     * the external allocation API which was removed in Honeycomb.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.102 -0500", hash_original_method = "0DBB3F3440DA26D4CDE5B1A71A1243C2", hash_generated_method = "FBD310130D4B9C224C0895282A9E3E5C")
    
@Deprecated
    public boolean trackExternalAllocation(long size) {
        return true;
    }

    /**
     * This method exists for binary compatibility.  It was part of
     * the external allocation API which was removed in Honeycomb.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.104 -0500", hash_original_method = "22330635CB403C3ADB4BC9A546866054", hash_generated_method = "CF14B3DEA7D6CA29CBA2485ECD24310A")
    
@Deprecated
    public void trackExternalFree(long size) {}

    /**
     * This method exists for binary compatibility.  It was part of
     * the external allocation API which was removed in Honeycomb.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.106 -0500", hash_original_method = "A946C3EA36CF5D407B19BD7EB5F84EAB", hash_generated_method = "AE5DF6FFEE4F14850B5D5B2EDB525C5E")
    
@Deprecated
    public long getExternalBytesAllocated() {
        return 0;
    }

    /**
     * Tells the VM to enable the JIT compiler. If the VM does not have a JIT
     * implementation, calling this method should have no effect.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.110 -0500", hash_original_method = "2166D40B30A2B78A2A8578391CF70C71", hash_generated_method = "29BDC10AADFD96C19F029D1714A554B1")
    
    public void startJitCompilation(){
    	//Formerly a native method
    }

    /**
     * Tells the VM to disable the JIT compiler. If the VM does not have a JIT
     * implementation, calling this method should have no effect.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.114 -0500", hash_original_method = "988710BD2A10AD89943FF29F774B18B3", hash_generated_method = "CA353D2A388EF4A594B5C454D32C0CAC")
    
    public void disableJitCompilation(){
    	//Formerly a native method
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.814 -0400", hash_original_method = "8EBD5DB8B6D587374B3055052FBB49F5", hash_generated_method = "320B737E55AF8DBCC23875D982D400A7")
    public Object newNonMovableArray(Class<?> componentType, int length) {
    	taint.addTaint(length);
    	taint.addTaint(componentType.taint);
    	return new Object();
    }

    /**
     * Returns the address of array[0]. This differs from using JNI in that JNI might lie and
     * give you the address of a copy of the array when in forcecopy mode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.123 -0500", hash_original_method = "F2F9C5A5D8870A09D65982DFE8B619AA", hash_generated_method = "5E3094D0ACFCB5350E53B25A2B650DD8")
    
    public long addressOf(Object array){
    	//Formerly a native method
    	addTaint(array.getTaint());
    	return getTaintLong();
    }

    /**
     * Removes any growth limits, allowing the application to allocate
     * up to the maximum heap size.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.127 -0500", hash_original_method = "008D98C2BCE518EEA7FDC1071598BCD6", hash_generated_method = "ABFD836FB1AE1F876C0489EF4E0B4791")
    
    public void clearGrowthLimit(){
    	//Formerly a native method
    }

    /**
     * Returns true if either a Java debugger or native debugger is active.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.130 -0500", hash_original_method = "FD10061FB9DFD564FAB6BA17DFE98F77", hash_generated_method = "7DBF5BD38DA526086B79259046E6CD8E")
    
    public boolean isDebuggerActive(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

}

