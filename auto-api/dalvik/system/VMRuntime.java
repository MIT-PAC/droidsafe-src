package dalvik.system;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation


public final class VMRuntime {
    private static final VMRuntime THE_ONE = new VMRuntime();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.346 -0400", hash_original_method = "33A03FA36AA2C869C23BC2B48A2B01BF", hash_generated_method = "37952D1686BBC3B4795FA4DE71DC9223")
    @DSModeled(DSC.SAFE)
    private VMRuntime() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.346 -0400", hash_original_method = "CBA2B68727D1F6F9168A66453269BED7", hash_generated_method = "B3FF717E7D00C98A9C1EB7ECEBF6367C")
    public static VMRuntime getRuntime() {
        return THE_ONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.346 -0400", hash_original_method = "2960BD7EBD269C359C23EB7E2C183AE6", hash_generated_method = "E609EA176DEC6ADBBC1583B20CD36352")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] properties() {
    	return new String[] { dsTaint.getTaintString() };
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.346 -0400", hash_original_method = "ACD1BDE0C9D7AA5A704C76C5A226A571", hash_generated_method = "EF926ABE32EED166AD27A3431128A3FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String bootClassPath() {
    	return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.346 -0400", hash_original_method = "F880EBCB28C92D3EB2F8227CAD3AB51E", hash_generated_method = "8A31D21F95906F8ADC4E3FCD942EA314")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String classPath() {
    	return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.346 -0400", hash_original_method = "91B638A4E83CB522FD5F0DBC3B106E1F", hash_generated_method = "A3ECDD09DAA704219477E8B957B7B9F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String vmVersion() {
    	return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.346 -0400", hash_original_method = "A53C7C5E8A86B0A14FF3A91D5B112A95", hash_generated_method = "5C1DD0F16ECEF6D40F424B03E3812BD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTargetHeapUtilization() {
    	return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.346 -0400", hash_original_method = "F170D2A35A1238A4622F6C568D71821B", hash_generated_method = "9A8FBE377B86C7B42A361798F150E19C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.346 -0400", hash_original_method = "C39A30D8892B0E36B74298597ED5FBE9", hash_generated_method = "CC134688010EFD7063A1B0276248AAEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTargetSdkVersion(int targetSdkVersion) {
        dsTaint.addTaint(targetSdkVersion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.346 -0400", hash_original_method = "923B1334376C4F437A073246F9A10510", hash_generated_method = "86053CE2CDBD2B4E3CEE206650D19981")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public long getMinimumHeapSize() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.346 -0400", hash_original_method = "CEB5420B7859E2786C7813E3E643E566", hash_generated_method = "4AB49EBDCD517D35608F0175AEA3F514")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public long setMinimumHeapSize(long size) {
        dsTaint.addTaint(size);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.346 -0400", hash_original_method = "7E7FC96AF2763DCE3DA2004144A94138", hash_generated_method = "A307A135C3742701E22A520FF196F040")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void gcSoftReferences() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.347 -0400", hash_original_method = "3F466C6AD532878D6C4CCB4CF518C455", hash_generated_method = "331245A1ACF9EB919CBA8E41936ABC03")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void runFinalizationSync() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        System.runFinalization();
        // ---------- Original Method ----------
        //System.runFinalization();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.347 -0400", hash_original_method = "1BC492CFAAC06440005836321EF40EC6", hash_generated_method = "B26F7EF2E1C0AA8168B382DC3DFB0A4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetTargetHeapUtilization(float newTarget) {
        dsTaint.addTaint(newTarget);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.347 -0400", hash_original_method = "0DBB3F3440DA26D4CDE5B1A71A1243C2", hash_generated_method = "0F74B3C3AE484290CFD3AC64A44F3FA4")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public boolean trackExternalAllocation(long size) {
        dsTaint.addTaint(size);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.347 -0400", hash_original_method = "22330635CB403C3ADB4BC9A546866054", hash_generated_method = "874C84B137E1F96EF905CCFC1E452ACC")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void trackExternalFree(long size) {
        dsTaint.addTaint(size);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.347 -0400", hash_original_method = "A946C3EA36CF5D407B19BD7EB5F84EAB", hash_generated_method = "192178D3FF12F8223001356561C1FC62")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public long getExternalBytesAllocated() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.347 -0400", hash_original_method = "2166D40B30A2B78A2A8578391CF70C71", hash_generated_method = "ADD1F1398CA3036B95B96CE3E5DD6199")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startJitCompilation() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.347 -0400", hash_original_method = "988710BD2A10AD89943FF29F774B18B3", hash_generated_method = "21C5E3F3B99CC3DB6E0B87FF623F6E34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void disableJitCompilation() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.347 -0400", hash_original_method = "8EBD5DB8B6D587374B3055052FBB49F5", hash_generated_method = "AB46D429CF56641C0F3729E67A2E5C54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object newNonMovableArray(Class<?> componentType, int length) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(length);
        dsTaint.addTaint(componentType.dsTaint);
        return dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.347 -0400", hash_original_method = "F2F9C5A5D8870A09D65982DFE8B619AA", hash_generated_method = "AEDF2880710AB5DCE27407D8D7324166")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long addressOf(Object array) {
        dsTaint.addTaint(array.dsTaint);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.347 -0400", hash_original_method = "008D98C2BCE518EEA7FDC1071598BCD6", hash_generated_method = "B679282553D262F60B689AA9692896BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearGrowthLimit() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.347 -0400", hash_original_method = "FD10061FB9DFD564FAB6BA17DFE98F77", hash_generated_method = "3CBA895E1C58E9A072084AEAAF64B515")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDebuggerActive() {
    	return dsTaint.getTaintBoolean();
    }

    
}


