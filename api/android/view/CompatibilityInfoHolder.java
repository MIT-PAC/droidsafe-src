package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.res.CompatibilityInfo;

public class CompatibilityInfoHolder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.534 -0400", hash_original_field = "48414DA28CAA8025116815C1D231436A", hash_generated_field = "5A8F1066A37F831BD10CAF4B8FC9C285")

    private volatile CompatibilityInfo mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.534 -0400", hash_original_method = "97B7CCDD2675E63E6068438C6851DDC9", hash_generated_method = "97B7CCDD2675E63E6068438C6851DDC9")
    public CompatibilityInfoHolder ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.535 -0400", hash_original_method = "0EA4FD6EEBB493F77BF170E078055D26", hash_generated_method = "6564ADF735AFCB392A405944BF73FBB5")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.535 -0400", hash_original_method = "2844201B11A6D03D93C5B2DA2F70B8EA", hash_generated_method = "BC474C2EDEA75CEA442C952BF991BAFE")
    public CompatibilityInfo get() {
CompatibilityInfo var5C7BB020D03894C4FC0ACB3E6855BCC6_820333559 =         mCompatInfo;
        var5C7BB020D03894C4FC0ACB3E6855BCC6_820333559.addTaint(taint);
        return var5C7BB020D03894C4FC0ACB3E6855BCC6_820333559;
        // ---------- Original Method ----------
        //return mCompatInfo;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.535 -0400", hash_original_method = "1E806FB90B93A5B9B671B556A0C9FEA7", hash_generated_method = "47BE718AB14378C2102E3AED29F59EE1")
    public CompatibilityInfo getIfNeeded() {
        CompatibilityInfo ci = mCompatInfo;
    if(ci == null || ci  == CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO)        
        {
CompatibilityInfo var540C13E9E156B687226421B24F2DF178_1737301519 =             null;
            var540C13E9E156B687226421B24F2DF178_1737301519.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1737301519;
        } //End block
CompatibilityInfo var0BA32E04A96EC8453514C24E083CE952_1615023663 =         ci;
        var0BA32E04A96EC8453514C24E083CE952_1615023663.addTaint(taint);
        return var0BA32E04A96EC8453514C24E083CE952_1615023663;
        // ---------- Original Method ----------
        //CompatibilityInfo ci = mCompatInfo;
        //if (ci == null || ci  == CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO) {
            //return null;
        //}
        //return ci;
    }

    
}

