package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.res.CompatibilityInfo;





public class CompatibilityInfoHolder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:26.220 -0500", hash_original_field = "E5B566789C44F2CF56BA88B943058EF6", hash_generated_field = "5A8F1066A37F831BD10CAF4B8FC9C285")

    private volatile CompatibilityInfo mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.445 -0400", hash_original_method = "97B7CCDD2675E63E6068438C6851DDC9", hash_generated_method = "97B7CCDD2675E63E6068438C6851DDC9")
    public CompatibilityInfoHolder ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:26.221 -0500", hash_original_method = "0EA4FD6EEBB493F77BF170E078055D26", hash_generated_method = "DA47424005D0B51DB4B3A6A1336D3F46")
    public void set(CompatibilityInfo compatInfo) {
        if (compatInfo != null && (compatInfo.isScalingRequired()
                || !compatInfo.supportsScreen())) {
            mCompatInfo = compatInfo;
        } else {
            mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:26.222 -0500", hash_original_method = "2844201B11A6D03D93C5B2DA2F70B8EA", hash_generated_method = "972BCA8FA8DA67067CC9D73237125234")
    public CompatibilityInfo get() {
        return mCompatInfo;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:26.223 -0500", hash_original_method = "1E806FB90B93A5B9B671B556A0C9FEA7", hash_generated_method = "A2ED4AD7815C5D418E93D7C3AA5E4870")
    public CompatibilityInfo getIfNeeded() {
        CompatibilityInfo ci = mCompatInfo;
        if (ci == null || ci  == CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO) {
            return null;
        }
        return ci;
    }

    
}

