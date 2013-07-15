package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.telephony.ServiceState;

public class RestrictedState {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.009 -0400", hash_original_field = "E6EDFC97A0AE32BF9220522E6C2D33E3", hash_generated_field = "DFF46A4E704B5BD370FD8E12EB30BC1D")

    private boolean mPsRestricted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.009 -0400", hash_original_field = "206918EB9802AE8B21DCEEE45F88820C", hash_generated_field = "27C327B1BC2163DCA045557BBFF3A8D9")

    private boolean mCsNormalRestricted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.009 -0400", hash_original_field = "F56C0A1580A1114D148F661D84EB9701", hash_generated_field = "583F06FC6145F09444B6E74F1AB437A2")

    private boolean mCsEmergencyRestricted;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.009 -0400", hash_original_method = "F727392B3D49E2225FED35B348D7580F", hash_generated_method = "A8B4A6FFAF3230A9E88A369FA2BA6744")
    public  RestrictedState() {
        setPsRestricted(false);
        setCsNormalRestricted(false);
        setCsEmergencyRestricted(false);
        // ---------- Original Method ----------
        //setPsRestricted(false);
        //setCsNormalRestricted(false);
        //setCsEmergencyRestricted(false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.009 -0400", hash_original_method = "27DE2A90C603578F7F1B28DAC20D7FD4", hash_generated_method = "5EDC4446D159F9F100BFF111EDE92E39")
    public void setCsEmergencyRestricted(boolean csEmergencyRestricted) {
        mCsEmergencyRestricted = csEmergencyRestricted;
        // ---------- Original Method ----------
        //mCsEmergencyRestricted = csEmergencyRestricted;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.009 -0400", hash_original_method = "E70F2CED961B3AE42815150E2A56A25A", hash_generated_method = "5C9B7645317EF6E17E55EF4A211B2D52")
    public boolean isCsEmergencyRestricted() {
        boolean varF56C0A1580A1114D148F661D84EB9701_1594330265 = (mCsEmergencyRestricted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1707425065 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1707425065;
        // ---------- Original Method ----------
        //return mCsEmergencyRestricted;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.010 -0400", hash_original_method = "ED07CBE0923251FA30E92E9584BA6081", hash_generated_method = "5F169B3D65E3795B3F157B4F56AFCEB2")
    public void setCsNormalRestricted(boolean csNormalRestricted) {
        mCsNormalRestricted = csNormalRestricted;
        // ---------- Original Method ----------
        //mCsNormalRestricted = csNormalRestricted;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.010 -0400", hash_original_method = "7084FFBE63D8E09FA65D7F421E8A0E5B", hash_generated_method = "6A03CB69FD21541077040667445A9159")
    public boolean isCsNormalRestricted() {
        boolean var206918EB9802AE8B21DCEEE45F88820C_1985757451 = (mCsNormalRestricted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_382070823 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_382070823;
        // ---------- Original Method ----------
        //return mCsNormalRestricted;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.010 -0400", hash_original_method = "B4DDDAAC651436E7B51C408529D49F83", hash_generated_method = "B2F8AA07C1EB864385C4B23E12FD8407")
    public void setPsRestricted(boolean psRestricted) {
        mPsRestricted = psRestricted;
        // ---------- Original Method ----------
        //mPsRestricted = psRestricted;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.010 -0400", hash_original_method = "D79EC17B35D08659B1A4F8082F3FAB11", hash_generated_method = "166804A44D07734141AF64B9BBC493E3")
    public boolean isPsRestricted() {
        boolean varE6EDFC97A0AE32BF9220522E6C2D33E3_1055851877 = (mPsRestricted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2138045326 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2138045326;
        // ---------- Original Method ----------
        //return mPsRestricted;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.010 -0400", hash_original_method = "4F1D7B7A2DBB2113F9985BF8231B2F2E", hash_generated_method = "F7C09587325B0DD1EAD52E99BAD4EFCE")
    public boolean isCsRestricted() {
        boolean var5D53AE8838241AD53D888A398FF4ED65_619835268 = (mCsNormalRestricted && mCsEmergencyRestricted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_862994581 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_862994581;
        // ---------- Original Method ----------
        //return mCsNormalRestricted && mCsEmergencyRestricted;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.010 -0400", hash_original_method = "782C42F453BEB7FFF6E7C3BB3C51E5DF", hash_generated_method = "8A4D17FC95C2569074D74FFCD3FEBD49")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        RestrictedState s;
        try 
        {
            s = (RestrictedState) o;
        } //End block
        catch (ClassCastException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_854493518 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_933795611 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_933795611;
        } //End block
    if(o == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_2038439584 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1358118829 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1358118829;
        } //End block
        boolean varD797C1077A25703804A895BD53177A37_1722381529 = (mPsRestricted == s.mPsRestricted
        && mCsNormalRestricted == s.mCsNormalRestricted
        && mCsEmergencyRestricted == s.mCsEmergencyRestricted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_708238468 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_708238468;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.011 -0400", hash_original_method = "845D0E6369A38FB89C7B9C67406A7898", hash_generated_method = "93F17E9306121DD28985D76D19D13D82")
    @Override
    public String toString() {
        String csString = "none";
    if(mCsEmergencyRestricted && mCsNormalRestricted)        
        {
            csString = "all";
        } //End block
        else
    if(mCsEmergencyRestricted && !mCsNormalRestricted)        
        {
            csString = "emergency";
        } //End block
        else
    if(!mCsEmergencyRestricted && mCsNormalRestricted)        
        {
            csString = "normal call";
        } //End block
String var20EEAEA0C159354130FC98EE1D1D0548_2062432611 =         "Restricted State CS: " + csString + " PS:" + mPsRestricted;
        var20EEAEA0C159354130FC98EE1D1D0548_2062432611.addTaint(taint);
        return var20EEAEA0C159354130FC98EE1D1D0548_2062432611;
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

