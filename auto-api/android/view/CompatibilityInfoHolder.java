package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.res.CompatibilityInfo;

public class CompatibilityInfoHolder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.486 -0400", hash_original_field = "48414DA28CAA8025116815C1D231436A", hash_generated_field = "5A8F1066A37F831BD10CAF4B8FC9C285")

    private volatile CompatibilityInfo mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.486 -0400", hash_original_method = "97B7CCDD2675E63E6068438C6851DDC9", hash_generated_method = "97B7CCDD2675E63E6068438C6851DDC9")
    public CompatibilityInfoHolder ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.496 -0400", hash_original_method = "0EA4FD6EEBB493F77BF170E078055D26", hash_generated_method = "F074811ACFB0CC960979BA964C851E80")
    public void set(CompatibilityInfo compatInfo) {
        {
            boolean var3EE8481B2300119DEB88AF81D648D927_1982612337 = (compatInfo != null && (compatInfo.isScalingRequired()
                || !compatInfo.supportsScreen()));
            {
                mCompatInfo = compatInfo;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.496 -0400", hash_original_method = "2844201B11A6D03D93C5B2DA2F70B8EA", hash_generated_method = "F0A11CF7629A509D566B074DC2E14235")
    public CompatibilityInfo get() {
        CompatibilityInfo varB4EAC82CA7396A68D541C85D26508E83_686204350 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_686204350 = mCompatInfo;
        varB4EAC82CA7396A68D541C85D26508E83_686204350.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_686204350;
        // ---------- Original Method ----------
        //return mCompatInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.497 -0400", hash_original_method = "1E806FB90B93A5B9B671B556A0C9FEA7", hash_generated_method = "72BFA7FAC016517C019DB74EDFE6BE78")
    public CompatibilityInfo getIfNeeded() {
        CompatibilityInfo varB4EAC82CA7396A68D541C85D26508E83_860360278 = null; //Variable for return #1
        CompatibilityInfo varB4EAC82CA7396A68D541C85D26508E83_461316983 = null; //Variable for return #2
        CompatibilityInfo ci;
        ci = mCompatInfo;
        {
            varB4EAC82CA7396A68D541C85D26508E83_860360278 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_461316983 = ci;
        CompatibilityInfo varA7E53CE21691AB073D9660D615818899_8800195; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_8800195 = varB4EAC82CA7396A68D541C85D26508E83_860360278;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_8800195 = varB4EAC82CA7396A68D541C85D26508E83_461316983;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_8800195.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_8800195;
        // ---------- Original Method ----------
        //CompatibilityInfo ci = mCompatInfo;
        //if (ci == null || ci  == CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO) {
            //return null;
        //}
        //return ci;
    }

    
}

