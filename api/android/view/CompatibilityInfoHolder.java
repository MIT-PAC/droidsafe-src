package android.view;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.res.CompatibilityInfo;





public class CompatibilityInfoHolder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.445 -0400", hash_original_field = "48414DA28CAA8025116815C1D231436A", hash_generated_field = "5A8F1066A37F831BD10CAF4B8FC9C285")

    private volatile CompatibilityInfo mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.445 -0400", hash_original_method = "97B7CCDD2675E63E6068438C6851DDC9", hash_generated_method = "97B7CCDD2675E63E6068438C6851DDC9")
    public CompatibilityInfoHolder ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.445 -0400", hash_original_method = "0EA4FD6EEBB493F77BF170E078055D26", hash_generated_method = "6564ADF735AFCB392A405944BF73FBB5")
    public void set(CompatibilityInfo compatInfo) {
        if(compatInfo != null && (compatInfo.isScalingRequired()
                || !compatInfo.supportsScreen()))        
        {
            mCompatInfo = compatInfo;
        } //End block
        else
        {
            mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
        } //End block
        // ---------- Original Method ----------
        //if (compatInfo != null && (compatInfo.isScalingRequired()
                //|| !compatInfo.supportsScreen())) {
            //mCompatInfo = compatInfo;
        //} else {
            //mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.445 -0400", hash_original_method = "2844201B11A6D03D93C5B2DA2F70B8EA", hash_generated_method = "7A874CC6602462534BC86CC418A4028A")
    public CompatibilityInfo get() {
CompatibilityInfo var5C7BB020D03894C4FC0ACB3E6855BCC6_479626948 =         mCompatInfo;
        var5C7BB020D03894C4FC0ACB3E6855BCC6_479626948.addTaint(taint);
        return var5C7BB020D03894C4FC0ACB3E6855BCC6_479626948;
        // ---------- Original Method ----------
        //return mCompatInfo;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.445 -0400", hash_original_method = "1E806FB90B93A5B9B671B556A0C9FEA7", hash_generated_method = "3F2CAEB993B7823D8E03FFE6FA6760FD")
    public CompatibilityInfo getIfNeeded() {
        CompatibilityInfo ci = mCompatInfo;
        if(ci == null || ci  == CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO)        
        {
CompatibilityInfo var540C13E9E156B687226421B24F2DF178_1635387865 =             null;
            var540C13E9E156B687226421B24F2DF178_1635387865.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1635387865;
        } //End block
CompatibilityInfo var0BA32E04A96EC8453514C24E083CE952_1541108018 =         ci;
        var0BA32E04A96EC8453514C24E083CE952_1541108018.addTaint(taint);
        return var0BA32E04A96EC8453514C24E083CE952_1541108018;
        // ---------- Original Method ----------
        //CompatibilityInfo ci = mCompatInfo;
        //if (ci == null || ci  == CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO) {
            //return null;
        //}
        //return ci;
    }

    
}

