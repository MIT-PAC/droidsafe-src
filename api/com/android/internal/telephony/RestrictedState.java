package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.annotations.*;





public class RestrictedState {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.589 -0400", hash_original_field = "E6EDFC97A0AE32BF9220522E6C2D33E3", hash_generated_field = "DFF46A4E704B5BD370FD8E12EB30BC1D")

    private boolean mPsRestricted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.589 -0400", hash_original_field = "206918EB9802AE8B21DCEEE45F88820C", hash_generated_field = "27C327B1BC2163DCA045557BBFF3A8D9")

    private boolean mCsNormalRestricted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.589 -0400", hash_original_field = "F56C0A1580A1114D148F661D84EB9701", hash_generated_field = "583F06FC6145F09444B6E74F1AB437A2")

    private boolean mCsEmergencyRestricted;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.589 -0400", hash_original_method = "F727392B3D49E2225FED35B348D7580F", hash_generated_method = "A8B4A6FFAF3230A9E88A369FA2BA6744")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.589 -0400", hash_original_method = "27DE2A90C603578F7F1B28DAC20D7FD4", hash_generated_method = "5EDC4446D159F9F100BFF111EDE92E39")
    public void setCsEmergencyRestricted(boolean csEmergencyRestricted) {
        mCsEmergencyRestricted = csEmergencyRestricted;
        // ---------- Original Method ----------
        //mCsEmergencyRestricted = csEmergencyRestricted;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.590 -0400", hash_original_method = "E70F2CED961B3AE42815150E2A56A25A", hash_generated_method = "6C782BABE8CC3426E5D0DCD6C56F3E2B")
    public boolean isCsEmergencyRestricted() {
        boolean varF56C0A1580A1114D148F661D84EB9701_1535508061 = (mCsEmergencyRestricted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2099943450 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2099943450;
        // ---------- Original Method ----------
        //return mCsEmergencyRestricted;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.590 -0400", hash_original_method = "ED07CBE0923251FA30E92E9584BA6081", hash_generated_method = "5F169B3D65E3795B3F157B4F56AFCEB2")
    public void setCsNormalRestricted(boolean csNormalRestricted) {
        mCsNormalRestricted = csNormalRestricted;
        // ---------- Original Method ----------
        //mCsNormalRestricted = csNormalRestricted;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.591 -0400", hash_original_method = "7084FFBE63D8E09FA65D7F421E8A0E5B", hash_generated_method = "38B19A5A5E242DCA0D1134692C8C446D")
    public boolean isCsNormalRestricted() {
        boolean var206918EB9802AE8B21DCEEE45F88820C_1926211526 = (mCsNormalRestricted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1991255720 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1991255720;
        // ---------- Original Method ----------
        //return mCsNormalRestricted;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.592 -0400", hash_original_method = "B4DDDAAC651436E7B51C408529D49F83", hash_generated_method = "B2F8AA07C1EB864385C4B23E12FD8407")
    public void setPsRestricted(boolean psRestricted) {
        mPsRestricted = psRestricted;
        // ---------- Original Method ----------
        //mPsRestricted = psRestricted;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.592 -0400", hash_original_method = "D79EC17B35D08659B1A4F8082F3FAB11", hash_generated_method = "849FD7175D2305D0BB4FDAB8ABEA61C2")
    public boolean isPsRestricted() {
        boolean varE6EDFC97A0AE32BF9220522E6C2D33E3_481398806 = (mPsRestricted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1178704646 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1178704646;
        // ---------- Original Method ----------
        //return mPsRestricted;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.592 -0400", hash_original_method = "4F1D7B7A2DBB2113F9985BF8231B2F2E", hash_generated_method = "12768E0377086B4734A83B3BFFDC106F")
    public boolean isCsRestricted() {
        boolean var5D53AE8838241AD53D888A398FF4ED65_943255413 = (mCsNormalRestricted && mCsEmergencyRestricted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_355848234 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_355848234;
        // ---------- Original Method ----------
        //return mCsNormalRestricted && mCsEmergencyRestricted;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.593 -0400", hash_original_method = "782C42F453BEB7FFF6E7C3BB3C51E5DF", hash_generated_method = "42B602FB8339536B2C4A7A127B9BEF3B")
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
            boolean var68934A3E9455FA72420237EB05902327_1229932939 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_581951159 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_581951159;
        } //End block
        if(o == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1867044032 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1881229571 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1881229571;
        } //End block
        boolean varD797C1077A25703804A895BD53177A37_374338200 = (mPsRestricted == s.mPsRestricted
        && mCsNormalRestricted == s.mCsNormalRestricted
        && mCsEmergencyRestricted == s.mCsEmergencyRestricted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1479613224 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1479613224;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.594 -0400", hash_original_method = "845D0E6369A38FB89C7B9C67406A7898", hash_generated_method = "4AEA3B61FD0870DF94E6B44B8F3263EC")
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
String var20EEAEA0C159354130FC98EE1D1D0548_805509009 =         "Restricted State CS: " + csString + " PS:" + mPsRestricted;
        var20EEAEA0C159354130FC98EE1D1D0548_805509009.addTaint(taint);
        return var20EEAEA0C159354130FC98EE1D1D0548_805509009;
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

