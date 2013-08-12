package dalvik.system;

// Droidsafe Imports
import droidsafe.annotations.*;





public final class VMRuntime {
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.854 -0400", hash_original_method = "33A03FA36AA2C869C23BC2B48A2B01BF", hash_generated_method = "7F5477CE47831425632DC95401495DBA")
    private  VMRuntime() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    public static VMRuntime getRuntime() {
        return THE_ONE;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.800 -0400", hash_original_method = "2960BD7EBD269C359C23EB7E2C183AE6", hash_generated_method = "2D5C10CC3D28CEC7E78CF04874E61B1D")
    public String[] properties() {
    	String[] props = new String[0];
    	return props;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.800 -0400", hash_original_method = "ACD1BDE0C9D7AA5A704C76C5A226A571", hash_generated_method = "3F7EFD902B37074211328DCB58E5B9CE")
    public String bootClassPath() {
    	return new String();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.801 -0400", hash_original_method = "F880EBCB28C92D3EB2F8227CAD3AB51E", hash_generated_method = "A63F2018F96FFCB76D226498854F0584")
    public String classPath() {
    	return new String();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.801 -0400", hash_original_method = "91B638A4E83CB522FD5F0DBC3B106E1F", hash_generated_method = "0FC91AF110114BAEF0A2D2BE50FBA59C")
    public String vmVersion() {
    	return new String();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.855 -0400", hash_original_method = "A53C7C5E8A86B0A14FF3A91D5B112A95", hash_generated_method = "C96E2A9EC444161F6BCD18BCDC210F15")
    public float getTargetHeapUtilization() {
        float var546ADE640B6EDFBC8A086EF31347E768_85774206 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_85774206;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.855 -0400", hash_original_method = "F170D2A35A1238A4622F6C568D71821B", hash_generated_method = "0BAA28D5580495532F2FE60648C2D6CC")
    public float setTargetHeapUtilization(float newTarget) {
        addTaint(newTarget);
        if(newTarget <= 0.0 || newTarget >= 1.0)        
        {
            IllegalArgumentException varE9D0E9601FDADDC4175B20E492D198EA_1812347296 = new IllegalArgumentException(newTarget +
                    " out of range (0,1)");
            varE9D0E9601FDADDC4175B20E492D198EA_1812347296.addTaint(taint);
            throw varE9D0E9601FDADDC4175B20E492D198EA_1812347296;
        } //End block
        synchronized
(this)        {
            float oldTarget = getTargetHeapUtilization();
            nativeSetTargetHeapUtilization(newTarget);
            float var026C01A31A0D69AD963D62F9A9A5A059_262434728 = (oldTarget);
                        float var546ADE640B6EDFBC8A086EF31347E768_2022024542 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_2022024542;
        } //End block
        // ---------- Original Method ----------
        //if (newTarget <= 0.0 || newTarget >= 1.0) {
            //throw new IllegalArgumentException(newTarget +
                    //" out of range (0,1)");
        //}
        //synchronized (this) {
            //float oldTarget = getTargetHeapUtilization();
            //nativeSetTargetHeapUtilization(newTarget);
            //return oldTarget;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.855 -0400", hash_original_method = "C39A30D8892B0E36B74298597ED5FBE9", hash_generated_method = "EA21A7B0162E01E5EA792CC7A6CE2370")
    public void setTargetSdkVersion(int targetSdkVersion) {
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.855 -0400", hash_original_method = "923B1334376C4F437A073246F9A10510", hash_generated_method = "B5B89CA086A35A2083EC0A0D8AA0F074")
    @Deprecated
    public long getMinimumHeapSize() {
        long varCFCD208495D565EF66E7DFF9F98764DA_574016448 = (0);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1805222173 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1805222173;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.855 -0400", hash_original_method = "CEB5420B7859E2786C7813E3E643E566", hash_generated_method = "939032B3BBAA0CDA5F87B5E0138BDC14")
    @Deprecated
    public long setMinimumHeapSize(long size) {
        addTaint(size);
        long varCFCD208495D565EF66E7DFF9F98764DA_1784499073 = (0);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1433685608 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1433685608;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.855 -0400", hash_original_method = "7E7FC96AF2763DCE3DA2004144A94138", hash_generated_method = "C3FE825593A165B12ADFD8E36D4D78F4")
    @Deprecated
    public void gcSoftReferences() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.855 -0400", hash_original_method = "3F466C6AD532878D6C4CCB4CF518C455", hash_generated_method = "8EB14B4D72CA777DA01382AEBEEFF1B9")
    @Deprecated
    public void runFinalizationSync() {
        System.runFinalization();
        // ---------- Original Method ----------
        //System.runFinalization();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.855 -0400", hash_original_method = "1BC492CFAAC06440005836321EF40EC6", hash_generated_method = "2A4500EED54D06B53CF090EFE1949B33")
    private void nativeSetTargetHeapUtilization(float newTarget) {
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.856 -0400", hash_original_method = "0DBB3F3440DA26D4CDE5B1A71A1243C2", hash_generated_method = "76443DD38298374EB31F1F4206666737")
    @Deprecated
    public boolean trackExternalAllocation(long size) {
        addTaint(size);
        boolean varB326B5062B2F0E69046810717534CB09_1305927435 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_741351968 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_741351968;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.856 -0400", hash_original_method = "22330635CB403C3ADB4BC9A546866054", hash_generated_method = "CE2AEFA646DA82A51D36B8F06ED1BFAC")
    @Deprecated
    public void trackExternalFree(long size) {
        addTaint(size);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.856 -0400", hash_original_method = "A946C3EA36CF5D407B19BD7EB5F84EAB", hash_generated_method = "63E62E0D4801A91891C2289A87044983")
    @Deprecated
    public long getExternalBytesAllocated() {
        long varCFCD208495D565EF66E7DFF9F98764DA_1168757812 = (0);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1420274802 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1420274802;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.856 -0400", hash_original_method = "2166D40B30A2B78A2A8578391CF70C71", hash_generated_method = "5CE41E3C314575546051C1FC068CDF23")
    public void startJitCompilation() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.856 -0400", hash_original_method = "988710BD2A10AD89943FF29F774B18B3", hash_generated_method = "5394F4F9494DB803D576EA0E55AE138D")
    public void disableJitCompilation() {
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.814 -0400", hash_original_method = "8EBD5DB8B6D587374B3055052FBB49F5", hash_generated_method = "320B737E55AF8DBCC23875D982D400A7")
    public Object newNonMovableArray(Class<?> componentType, int length) {
    	taint.addTaint(length);
    	taint.addTaint(componentType.taint);
    	return new Object();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.856 -0400", hash_original_method = "F2F9C5A5D8870A09D65982DFE8B619AA", hash_generated_method = "5D3CF82E2F5EECD43E253822BAF31A6B")
    public long addressOf(Object array) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_751142300 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_751142300;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.856 -0400", hash_original_method = "008D98C2BCE518EEA7FDC1071598BCD6", hash_generated_method = "EEB37EDD5B5B9071347315008085CFAF")
    public void clearGrowthLimit() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.856 -0400", hash_original_method = "FD10061FB9DFD564FAB6BA17DFE98F77", hash_generated_method = "E8B5A4E418AE7B4344F9BE83A99BC2C6")
    public boolean isDebuggerActive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1157197785 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1157197785;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.856 -0400", hash_original_field = "BE97E66CF27F33E333158EB7DAA93C92", hash_generated_field = "894A31B8E254C688D0C13EABA3654B94")

    private static final VMRuntime THE_ONE = new VMRuntime();
}

