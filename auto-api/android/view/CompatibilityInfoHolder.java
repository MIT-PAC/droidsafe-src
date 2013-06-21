package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.res.CompatibilityInfo;

public class CompatibilityInfoHolder {
    private volatile CompatibilityInfo mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.448 -0400", hash_original_method = "6B1F3EC4157497C154C32DB041CFA7C3", hash_generated_method = "6B1F3EC4157497C154C32DB041CFA7C3")
        public CompatibilityInfoHolder ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.448 -0400", hash_original_method = "0EA4FD6EEBB493F77BF170E078055D26", hash_generated_method = "A55D669C626FDC52A870C3FE0AB6CED1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void set(CompatibilityInfo compatInfo) {
        dsTaint.addTaint(compatInfo.dsTaint);
        {
            boolean var3EE8481B2300119DEB88AF81D648D927_340527752 = (compatInfo != null && (compatInfo.isScalingRequired()
                || !compatInfo.supportsScreen()));
            {
                mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (compatInfo != null && (compatInfo.isScalingRequired()
                //|| !compatInfo.supportsScreen())) {
            //mCompatInfo = compatInfo;
        //} else {
            //mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.448 -0400", hash_original_method = "2844201B11A6D03D93C5B2DA2F70B8EA", hash_generated_method = "6DB5F4EAC945F8584595ADD99DBDEC5C")
    @DSModeled(DSC.SAFE)
    public CompatibilityInfo get() {
        return (CompatibilityInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCompatInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.448 -0400", hash_original_method = "1E806FB90B93A5B9B671B556A0C9FEA7", hash_generated_method = "28D200E0830222D88019DE47B2C9604D")
    @DSModeled(DSC.SAFE)
    public CompatibilityInfo getIfNeeded() {
        CompatibilityInfo ci;
        ci = mCompatInfo;
        return (CompatibilityInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //CompatibilityInfo ci = mCompatInfo;
        //if (ci == null || ci  == CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO) {
            //return null;
        //}
        //return ci;
    }

    
}

