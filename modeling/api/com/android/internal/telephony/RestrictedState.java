package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class RestrictedState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.841 -0500", hash_original_field = "EBCF5A218343A6E650E6B0B7F607421E", hash_generated_field = "DFF46A4E704B5BD370FD8E12EB30BC1D")

    private boolean mPsRestricted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.843 -0500", hash_original_field = "1AE8FA720E2F920C25B87E6EA76EFAC8", hash_generated_field = "27C327B1BC2163DCA045557BBFF3A8D9")

    private boolean mCsNormalRestricted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.846 -0500", hash_original_field = "5E12DB35406872DEC6087EB4239EF97D", hash_generated_field = "583F06FC6145F09444B6E74F1AB437A2")

    private boolean mCsEmergencyRestricted;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.848 -0500", hash_original_method = "F727392B3D49E2225FED35B348D7580F", hash_generated_method = "CD3C8AED478562F9B2580B8D9C0AB7E4")
    
public RestrictedState() {
        setPsRestricted(false);
        setCsNormalRestricted(false);
        setCsEmergencyRestricted(false);
    }

    /**
     * @param csEmergencyRestricted the csEmergencyRestricted to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.851 -0500", hash_original_method = "27DE2A90C603578F7F1B28DAC20D7FD4", hash_generated_method = "D21351B46981F2D8CE4C51C73B8A635B")
    
public void setCsEmergencyRestricted(boolean csEmergencyRestricted) {
        mCsEmergencyRestricted = csEmergencyRestricted;
    }

    /**
     * @return the csEmergencyRestricted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.853 -0500", hash_original_method = "E70F2CED961B3AE42815150E2A56A25A", hash_generated_method = "45311176E433587585D515C7090452B9")
    
public boolean isCsEmergencyRestricted() {
        return mCsEmergencyRestricted;
    }

    /**
     * @param csNormalRestricted the csNormalRestricted to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.856 -0500", hash_original_method = "ED07CBE0923251FA30E92E9584BA6081", hash_generated_method = "DC9A14E6A85E1FC2588620E3384F80F5")
    
public void setCsNormalRestricted(boolean csNormalRestricted) {
        mCsNormalRestricted = csNormalRestricted;
    }

    /**
     * @return the csNormalRestricted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.858 -0500", hash_original_method = "7084FFBE63D8E09FA65D7F421E8A0E5B", hash_generated_method = "ED40086829CA1FFE1841C511F17B35D2")
    
public boolean isCsNormalRestricted() {
        return mCsNormalRestricted;
    }

    /**
     * @param psRestricted the psRestricted to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.861 -0500", hash_original_method = "B4DDDAAC651436E7B51C408529D49F83", hash_generated_method = "71F305C7557525FD5F9AE29F3C05FBEE")
    
public void setPsRestricted(boolean psRestricted) {
        mPsRestricted = psRestricted;
    }

    /**
     * @return the psRestricted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.863 -0500", hash_original_method = "D79EC17B35D08659B1A4F8082F3FAB11", hash_generated_method = "04995E61EA8BDE8FDF242D1C20C39C07")
    
public boolean isPsRestricted() {
        return mPsRestricted;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.865 -0500", hash_original_method = "4F1D7B7A2DBB2113F9985BF8231B2F2E", hash_generated_method = "BCD4B326A2FCF0CD84BD84018D58B1A0")
    
public boolean isCsRestricted() {
        return mCsNormalRestricted && mCsEmergencyRestricted;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.868 -0500", hash_original_method = "782C42F453BEB7FFF6E7C3BB3C51E5DF", hash_generated_method = "6C14735EBD9731D0BF0F9232BE8DCB3A")
    
@Override
    public boolean equals (Object o) {
        RestrictedState s;

        try {
            s = (RestrictedState) o;
        } catch (ClassCastException ex) {
            return false;
        }

        if (o == null) {
            return false;
        }

        return mPsRestricted == s.mPsRestricted
        && mCsNormalRestricted == s.mCsNormalRestricted
        && mCsEmergencyRestricted == s.mCsEmergencyRestricted;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.871 -0500", hash_original_method = "845D0E6369A38FB89C7B9C67406A7898", hash_generated_method = "11081E9454E6AB52E292A7C378A60628")
    
@Override
    public String toString() {
        String csString = "none";

        if (mCsEmergencyRestricted && mCsNormalRestricted) {
            csString = "all";
        } else if (mCsEmergencyRestricted && !mCsNormalRestricted) {
            csString = "emergency";
        } else if (!mCsEmergencyRestricted && mCsNormalRestricted) {
            csString = "normal call";
        }

        return  "Restricted State CS: " + csString + " PS:" + mPsRestricted;
    }
    
}

