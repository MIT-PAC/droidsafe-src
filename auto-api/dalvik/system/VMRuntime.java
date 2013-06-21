package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class VMRuntime {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.293 -0400", hash_original_method = "33A03FA36AA2C869C23BC2B48A2B01BF", hash_generated_method = "7F5477CE47831425632DC95401495DBA")
    @DSModeled(DSC.SAFE)
    private VMRuntime() {
        // ---------- Original Method ----------
    }

    
        public static VMRuntime getRuntime() {
        return THE_ONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.295 -0400", hash_original_method = "2960BD7EBD269C359C23EB7E2C183AE6", hash_generated_method = "4A08877D5494431DCE2B9A37F740D9D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] properties() {
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.296 -0400", hash_original_method = "ACD1BDE0C9D7AA5A704C76C5A226A571", hash_generated_method = "67388711D482CA1E62FC7F1FD81EFD77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String bootClassPath() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.296 -0400", hash_original_method = "F880EBCB28C92D3EB2F8227CAD3AB51E", hash_generated_method = "FE135F664150B1E3295E2DA1E4CB5D80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String classPath() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.297 -0400", hash_original_method = "91B638A4E83CB522FD5F0DBC3B106E1F", hash_generated_method = "BA3EDF83F83DE3B6D0472E93A091778C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String vmVersion() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.297 -0400", hash_original_method = "A53C7C5E8A86B0A14FF3A91D5B112A95", hash_generated_method = "F81088C59BE33688F6E39CC64FFC8779")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTargetHeapUtilization() {
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.298 -0400", hash_original_method = "F170D2A35A1238A4622F6C568D71821B", hash_generated_method = "2B15CCDBF523890A6078561A49C73512")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float setTargetHeapUtilization(float newTarget) {
        dsTaint.addTaint(newTarget);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(newTarget +
                    " out of range (0,1)");
        } //End block
        {
            float oldTarget;
            oldTarget = getTargetHeapUtilization();
            nativeSetTargetHeapUtilization(newTarget);
        } //End block
        return dsTaint.getTaintFloat();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.298 -0400", hash_original_method = "C39A30D8892B0E36B74298597ED5FBE9", hash_generated_method = "891CA43E4B7B45ADFC423647C2E0AAE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTargetSdkVersion(int targetSdkVersion) {
        dsTaint.addTaint(targetSdkVersion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.298 -0400", hash_original_method = "923B1334376C4F437A073246F9A10510", hash_generated_method = "D8C6D00DD09EBF930BC38AEAF79A1049")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public long getMinimumHeapSize() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.298 -0400", hash_original_method = "CEB5420B7859E2786C7813E3E643E566", hash_generated_method = "F7915B8C8EFBFF05678DF78AF46B136D")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public long setMinimumHeapSize(long size) {
        dsTaint.addTaint(size);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.298 -0400", hash_original_method = "7E7FC96AF2763DCE3DA2004144A94138", hash_generated_method = "C3FE825593A165B12ADFD8E36D4D78F4")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void gcSoftReferences() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.298 -0400", hash_original_method = "3F466C6AD532878D6C4CCB4CF518C455", hash_generated_method = "8EB14B4D72CA777DA01382AEBEEFF1B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void runFinalizationSync() {
        System.runFinalization();
        // ---------- Original Method ----------
        //System.runFinalization();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.299 -0400", hash_original_method = "1BC492CFAAC06440005836321EF40EC6", hash_generated_method = "99DA0575A70081B677F7DD42F037A684")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetTargetHeapUtilization(float newTarget) {
        dsTaint.addTaint(newTarget);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.299 -0400", hash_original_method = "0DBB3F3440DA26D4CDE5B1A71A1243C2", hash_generated_method = "B901DFC3BB069347236E6A6C3010E732")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public boolean trackExternalAllocation(long size) {
        dsTaint.addTaint(size);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.299 -0400", hash_original_method = "22330635CB403C3ADB4BC9A546866054", hash_generated_method = "68485E5FFB0FD3CF5684CBB659CA7286")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void trackExternalFree(long size) {
        dsTaint.addTaint(size);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.299 -0400", hash_original_method = "A946C3EA36CF5D407B19BD7EB5F84EAB", hash_generated_method = "3371D322B3F4EC28A184BEAA1453CE18")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public long getExternalBytesAllocated() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.299 -0400", hash_original_method = "2166D40B30A2B78A2A8578391CF70C71", hash_generated_method = "5CE41E3C314575546051C1FC068CDF23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startJitCompilation() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.299 -0400", hash_original_method = "988710BD2A10AD89943FF29F774B18B3", hash_generated_method = "5394F4F9494DB803D576EA0E55AE138D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void disableJitCompilation() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.300 -0400", hash_original_method = "8EBD5DB8B6D587374B3055052FBB49F5", hash_generated_method = "694F5088AFD35260D4C48EF29D3D4B17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object newNonMovableArray(Class<?> componentType, int length) {
        dsTaint.addTaint(length);
        dsTaint.addTaint(componentType.dsTaint);
        return (Object)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.300 -0400", hash_original_method = "F2F9C5A5D8870A09D65982DFE8B619AA", hash_generated_method = "F32AA7B2AA8BF4497BA117723F1324EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long addressOf(Object array) {
        dsTaint.addTaint(array.dsTaint);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.300 -0400", hash_original_method = "008D98C2BCE518EEA7FDC1071598BCD6", hash_generated_method = "EEB37EDD5B5B9071347315008085CFAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearGrowthLimit() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.300 -0400", hash_original_method = "FD10061FB9DFD564FAB6BA17DFE98F77", hash_generated_method = "D6097A2E47F8870CC2DE19D822F19D0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDebuggerActive() {
        return dsTaint.getTaintBoolean();
    }

    
    private static final VMRuntime THE_ONE = new VMRuntime();
}

