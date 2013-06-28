package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.telephony.ServiceState;

public class RestrictedState {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.514 -0400", hash_original_field = "E6EDFC97A0AE32BF9220522E6C2D33E3", hash_generated_field = "DFF46A4E704B5BD370FD8E12EB30BC1D")

    private boolean mPsRestricted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.514 -0400", hash_original_field = "206918EB9802AE8B21DCEEE45F88820C", hash_generated_field = "27C327B1BC2163DCA045557BBFF3A8D9")

    private boolean mCsNormalRestricted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.514 -0400", hash_original_field = "F56C0A1580A1114D148F661D84EB9701", hash_generated_field = "583F06FC6145F09444B6E74F1AB437A2")

    private boolean mCsEmergencyRestricted;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.514 -0400", hash_original_method = "F727392B3D49E2225FED35B348D7580F", hash_generated_method = "A8B4A6FFAF3230A9E88A369FA2BA6744")
    public  RestrictedState() {
        setPsRestricted(false);
        setCsNormalRestricted(false);
        setCsEmergencyRestricted(false);
        // ---------- Original Method ----------
        //setPsRestricted(false);
        //setCsNormalRestricted(false);
        //setCsEmergencyRestricted(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.514 -0400", hash_original_method = "27DE2A90C603578F7F1B28DAC20D7FD4", hash_generated_method = "5EDC4446D159F9F100BFF111EDE92E39")
    public void setCsEmergencyRestricted(boolean csEmergencyRestricted) {
        mCsEmergencyRestricted = csEmergencyRestricted;
        // ---------- Original Method ----------
        //mCsEmergencyRestricted = csEmergencyRestricted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.514 -0400", hash_original_method = "E70F2CED961B3AE42815150E2A56A25A", hash_generated_method = "D36F3FB6578436A52417B06F15A3F559")
    public boolean isCsEmergencyRestricted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1847882731 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1847882731;
        // ---------- Original Method ----------
        //return mCsEmergencyRestricted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.515 -0400", hash_original_method = "ED07CBE0923251FA30E92E9584BA6081", hash_generated_method = "5F169B3D65E3795B3F157B4F56AFCEB2")
    public void setCsNormalRestricted(boolean csNormalRestricted) {
        mCsNormalRestricted = csNormalRestricted;
        // ---------- Original Method ----------
        //mCsNormalRestricted = csNormalRestricted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.515 -0400", hash_original_method = "7084FFBE63D8E09FA65D7F421E8A0E5B", hash_generated_method = "281C17986D2A1E81DB68AD9D8F0E5127")
    public boolean isCsNormalRestricted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_783672807 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_783672807;
        // ---------- Original Method ----------
        //return mCsNormalRestricted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.515 -0400", hash_original_method = "B4DDDAAC651436E7B51C408529D49F83", hash_generated_method = "B2F8AA07C1EB864385C4B23E12FD8407")
    public void setPsRestricted(boolean psRestricted) {
        mPsRestricted = psRestricted;
        // ---------- Original Method ----------
        //mPsRestricted = psRestricted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.515 -0400", hash_original_method = "D79EC17B35D08659B1A4F8082F3FAB11", hash_generated_method = "D6F026B01553C20EA124C11CE1E30CB8")
    public boolean isPsRestricted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_657453210 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_657453210;
        // ---------- Original Method ----------
        //return mPsRestricted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.515 -0400", hash_original_method = "4F1D7B7A2DBB2113F9985BF8231B2F2E", hash_generated_method = "10EFCD0E0F07248FFC59F48FF662980E")
    public boolean isCsRestricted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1972974800 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1972974800;
        // ---------- Original Method ----------
        //return mCsNormalRestricted && mCsEmergencyRestricted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.516 -0400", hash_original_method = "782C42F453BEB7FFF6E7C3BB3C51E5DF", hash_generated_method = "35D3ED20E697EA9ED1ECF40ED750CD2F")
    @Override
    public boolean equals(Object o) {
        RestrictedState s;
        try 
        {
            s = (RestrictedState) o;
        } //End block
        catch (ClassCastException ex)
        { }
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1982794584 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1982794584;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.516 -0400", hash_original_method = "845D0E6369A38FB89C7B9C67406A7898", hash_generated_method = "00466765992A70E2F35A776F50B03973")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1201698907 = null; //Variable for return #1
        String csString = "none";
        {
            csString = "all";
        } //End block
        {
            csString = "emergency";
        } //End block
        {
            csString = "normal call";
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1201698907 = "Restricted State CS: " + csString + " PS:" + mPsRestricted;
        varB4EAC82CA7396A68D541C85D26508E83_1201698907.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1201698907;
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

