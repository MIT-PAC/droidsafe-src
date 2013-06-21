package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.telephony.ServiceState;

public class RestrictedState {
    private boolean mPsRestricted;
    private boolean mCsNormalRestricted;
    private boolean mCsEmergencyRestricted;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.234 -0400", hash_original_method = "F727392B3D49E2225FED35B348D7580F", hash_generated_method = "A8B4A6FFAF3230A9E88A369FA2BA6744")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RestrictedState() {
        setPsRestricted(false);
        setCsNormalRestricted(false);
        setCsEmergencyRestricted(false);
        // ---------- Original Method ----------
        //setPsRestricted(false);
        //setCsNormalRestricted(false);
        //setCsEmergencyRestricted(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.234 -0400", hash_original_method = "27DE2A90C603578F7F1B28DAC20D7FD4", hash_generated_method = "3201A9A2F5D7F62845493C0C9DAF8C8D")
    @DSModeled(DSC.SAFE)
    public void setCsEmergencyRestricted(boolean csEmergencyRestricted) {
        dsTaint.addTaint(csEmergencyRestricted);
        // ---------- Original Method ----------
        //mCsEmergencyRestricted = csEmergencyRestricted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.234 -0400", hash_original_method = "E70F2CED961B3AE42815150E2A56A25A", hash_generated_method = "F7D1476CDEA2007C0E8FE7DF49557CCC")
    @DSModeled(DSC.SAFE)
    public boolean isCsEmergencyRestricted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCsEmergencyRestricted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.235 -0400", hash_original_method = "ED07CBE0923251FA30E92E9584BA6081", hash_generated_method = "C55ADFC847D05424638F007AD8C1E9A8")
    @DSModeled(DSC.SAFE)
    public void setCsNormalRestricted(boolean csNormalRestricted) {
        dsTaint.addTaint(csNormalRestricted);
        // ---------- Original Method ----------
        //mCsNormalRestricted = csNormalRestricted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.235 -0400", hash_original_method = "7084FFBE63D8E09FA65D7F421E8A0E5B", hash_generated_method = "C4C7F74AA624CB7961CA3167A47C539E")
    @DSModeled(DSC.SAFE)
    public boolean isCsNormalRestricted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCsNormalRestricted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.235 -0400", hash_original_method = "B4DDDAAC651436E7B51C408529D49F83", hash_generated_method = "99020EF316457A4FB557F9F7583BA4D1")
    @DSModeled(DSC.SAFE)
    public void setPsRestricted(boolean psRestricted) {
        dsTaint.addTaint(psRestricted);
        // ---------- Original Method ----------
        //mPsRestricted = psRestricted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.235 -0400", hash_original_method = "D79EC17B35D08659B1A4F8082F3FAB11", hash_generated_method = "A16E965BA10676F9D50BCC5EA38DE47C")
    @DSModeled(DSC.SAFE)
    public boolean isPsRestricted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPsRestricted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.235 -0400", hash_original_method = "4F1D7B7A2DBB2113F9985BF8231B2F2E", hash_generated_method = "B8B95E207BB8AEF5E9557CE9578BFF7B")
    @DSModeled(DSC.SAFE)
    public boolean isCsRestricted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCsNormalRestricted && mCsEmergencyRestricted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.236 -0400", hash_original_method = "782C42F453BEB7FFF6E7C3BB3C51E5DF", hash_generated_method = "2D27E3E72075657971B112253822C84F")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        RestrictedState s;
        try 
        {
            s = (RestrictedState) o;
        } //End block
        catch (ClassCastException ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //RestrictedState s;
        //try {
            //s = (RestrictedState) o;
        //} catch (ClassCastException ex) {
            //return false;
        //}
        //if (o == null) {
            //return false;
        //}
        //return mPsRestricted == s.mPsRestricted
        //&& mCsNormalRestricted == s.mCsNormalRestricted
        //&& mCsEmergencyRestricted == s.mCsEmergencyRestricted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.236 -0400", hash_original_method = "845D0E6369A38FB89C7B9C67406A7898", hash_generated_method = "990AF649B16C8846602233E6A1432F9A")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        String csString;
        csString = "none";
        {
            csString = "all";
        } //End block
        {
            csString = "emergency";
        } //End block
        {
            csString = "normal call";
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String csString = "none";
        //if (mCsEmergencyRestricted && mCsNormalRestricted) {
            //csString = "all";
        //} else if (mCsEmergencyRestricted && !mCsNormalRestricted) {
            //csString = "emergency";
        //} else if (!mCsEmergencyRestricted && mCsNormalRestricted) {
            //csString = "normal call";
        //}
        //return  "Restricted State CS: " + csString + " PS:" + mPsRestricted;
    }

    
}

