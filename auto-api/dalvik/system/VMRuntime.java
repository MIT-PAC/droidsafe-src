package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class VMRuntime {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.018 -0400", hash_original_method = "33A03FA36AA2C869C23BC2B48A2B01BF", hash_generated_method = "7F5477CE47831425632DC95401495DBA")
    private  VMRuntime() {
        // ---------- Original Method ----------
    }

    
        public static VMRuntime getRuntime() {
        return THE_ONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.018 -0400", hash_original_method = "2960BD7EBD269C359C23EB7E2C183AE6", hash_generated_method = "2D5C10CC3D28CEC7E78CF04874E61B1D")
    public String[] properties() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.018 -0400", hash_original_method = "ACD1BDE0C9D7AA5A704C76C5A226A571", hash_generated_method = "3F7EFD902B37074211328DCB58E5B9CE")
    public String bootClassPath() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.018 -0400", hash_original_method = "F880EBCB28C92D3EB2F8227CAD3AB51E", hash_generated_method = "A63F2018F96FFCB76D226498854F0584")
    public String classPath() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.019 -0400", hash_original_method = "91B638A4E83CB522FD5F0DBC3B106E1F", hash_generated_method = "0FC91AF110114BAEF0A2D2BE50FBA59C")
    public String vmVersion() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.019 -0400", hash_original_method = "A53C7C5E8A86B0A14FF3A91D5B112A95", hash_generated_method = "95AD026989A0A37B4A11AB454A140D59")
    public float getTargetHeapUtilization() {
        float var546ADE640B6EDFBC8A086EF31347E768_1889778511 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1889778511;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.019 -0400", hash_original_method = "F170D2A35A1238A4622F6C568D71821B", hash_generated_method = "A66AEEBE5DFDA293BFC424069A6E2004")
    public float setTargetHeapUtilization(float newTarget) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(newTarget +
                    " out of range (0,1)");
        } //End block
        {
            float oldTarget;
            oldTarget = getTargetHeapUtilization();
            nativeSetTargetHeapUtilization(newTarget);
        } //End block
        addTaint(newTarget);
        float var546ADE640B6EDFBC8A086EF31347E768_1488403438 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1488403438;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.019 -0400", hash_original_method = "C39A30D8892B0E36B74298597ED5FBE9", hash_generated_method = "EA21A7B0162E01E5EA792CC7A6CE2370")
    public void setTargetSdkVersion(int targetSdkVersion) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.019 -0400", hash_original_method = "923B1334376C4F437A073246F9A10510", hash_generated_method = "E1AF128AC7ECC934C96BE4DF19673875")
    @Deprecated
    public long getMinimumHeapSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2022336966 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2022336966;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.020 -0400", hash_original_method = "CEB5420B7859E2786C7813E3E643E566", hash_generated_method = "FDC9FC531BC1467DE4F42EF8FD83EFC1")
    @Deprecated
    public long setMinimumHeapSize(long size) {
        addTaint(size);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_671901410 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_671901410;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.020 -0400", hash_original_method = "7E7FC96AF2763DCE3DA2004144A94138", hash_generated_method = "C3FE825593A165B12ADFD8E36D4D78F4")
    @Deprecated
    public void gcSoftReferences() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.020 -0400", hash_original_method = "3F466C6AD532878D6C4CCB4CF518C455", hash_generated_method = "8EB14B4D72CA777DA01382AEBEEFF1B9")
    @Deprecated
    public void runFinalizationSync() {
        System.runFinalization();
        // ---------- Original Method ----------
        //System.runFinalization();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.020 -0400", hash_original_method = "1BC492CFAAC06440005836321EF40EC6", hash_generated_method = "2A4500EED54D06B53CF090EFE1949B33")
    private void nativeSetTargetHeapUtilization(float newTarget) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.037 -0400", hash_original_method = "0DBB3F3440DA26D4CDE5B1A71A1243C2", hash_generated_method = "379F95A48C00529F61228D61E8BB93F9")
    @Deprecated
    public boolean trackExternalAllocation(long size) {
        addTaint(size);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_395143204 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_395143204;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.038 -0400", hash_original_method = "22330635CB403C3ADB4BC9A546866054", hash_generated_method = "CE2AEFA646DA82A51D36B8F06ED1BFAC")
    @Deprecated
    public void trackExternalFree(long size) {
        addTaint(size);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.038 -0400", hash_original_method = "A946C3EA36CF5D407B19BD7EB5F84EAB", hash_generated_method = "3ED6B15E0F18462301C5B108FA2780C4")
    @Deprecated
    public long getExternalBytesAllocated() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_354781236 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_354781236;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.038 -0400", hash_original_method = "2166D40B30A2B78A2A8578391CF70C71", hash_generated_method = "5CE41E3C314575546051C1FC068CDF23")
    public void startJitCompilation() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.038 -0400", hash_original_method = "988710BD2A10AD89943FF29F774B18B3", hash_generated_method = "5394F4F9494DB803D576EA0E55AE138D")
    public void disableJitCompilation() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.038 -0400", hash_original_method = "8EBD5DB8B6D587374B3055052FBB49F5", hash_generated_method = "320B737E55AF8DBCC23875D982D400A7")
    public Object newNonMovableArray(Class<?> componentType, int length) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.039 -0400", hash_original_method = "F2F9C5A5D8870A09D65982DFE8B619AA", hash_generated_method = "8F436AA337E78FE419A9B3D49D2883B3")
    public long addressOf(Object array) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1243407896 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1243407896;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.039 -0400", hash_original_method = "008D98C2BCE518EEA7FDC1071598BCD6", hash_generated_method = "EEB37EDD5B5B9071347315008085CFAF")
    public void clearGrowthLimit() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.039 -0400", hash_original_method = "FD10061FB9DFD564FAB6BA17DFE98F77", hash_generated_method = "5090475A66845E3602BE4EBE2B251D2E")
    public boolean isDebuggerActive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1371452791 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1371452791;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.039 -0400", hash_original_field = "BE97E66CF27F33E333158EB7DAA93C92", hash_generated_field = "22DCC5B92FF9EF6C0DE09743C1AA033D")

    private static VMRuntime THE_ONE = new VMRuntime();
}

