package android.telephony.gsm;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Bundle;
import android.telephony.CellLocation;





public class GsmCellLocation extends CellLocation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.259 -0400", hash_original_field = "B2F9C701F6B9FA98A906A1D27571667E", hash_generated_field = "E1DF72766EAA7700CC09E2EF71762BF7")

    private int mLac;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.259 -0400", hash_original_field = "47909A4A63C9D0DF4D400D36305EA002", hash_generated_field = "6613038ECFEA58ECF70AB91998D5EB03")

    private int mCid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.260 -0400", hash_original_field = "865B7932A3A776B1F3AFFD84DFC3DDFF", hash_generated_field = "EC9E5D02BA114935D10D39D2FABA270A")

    private int mPsc;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.260 -0400", hash_original_method = "666EDAF57125B4E49F0CA8BF9D68AAC9", hash_generated_method = "5DBE3D4937998589F506A0C5FBEECDA8")
    public  GsmCellLocation() {
        mLac = -1;
        mCid = -1;
        mPsc = -1;
        // ---------- Original Method ----------
        //mLac = -1;
        //mCid = -1;
        //mPsc = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.261 -0400", hash_original_method = "C24176B61861DC93124341EFD3884687", hash_generated_method = "13083EADD6AE07C87E9A55AA22608BCF")
    public  GsmCellLocation(Bundle bundle) {
        mLac = bundle.getInt("lac", mLac);
        mCid = bundle.getInt("cid", mCid);
        mPsc = bundle.getInt("psc", mPsc);
        // ---------- Original Method ----------
        //mLac = bundle.getInt("lac", mLac);
        //mCid = bundle.getInt("cid", mCid);
        //mPsc = bundle.getInt("psc", mPsc);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.261 -0400", hash_original_method = "9D27DA83295DE88E54D1A14DE01D13B2", hash_generated_method = "DD8356ADD4E641629A6C0009119EC701")
    public int getLac() {
        int varB2F9C701F6B9FA98A906A1D27571667E_1969812159 = (mLac);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2076762021 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2076762021;
        // ---------- Original Method ----------
        //return mLac;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.262 -0400", hash_original_method = "03F3B6133F275A943C2D43BD3469FDB7", hash_generated_method = "F694F0871CC2B07AAFC1E489566A8C28")
    public int getCid() {
        int var47909A4A63C9D0DF4D400D36305EA002_563271563 = (mCid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_875839006 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_875839006;
        // ---------- Original Method ----------
        //return mCid;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.262 -0400", hash_original_method = "0E29DC7205E312820087B8B417C09B13", hash_generated_method = "87F0FC0791C7183012F72492BD86EAEE")
    public int getPsc() {
        int var865B7932A3A776B1F3AFFD84DFC3DDFF_554663902 = (mPsc);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_635217610 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_635217610;
        // ---------- Original Method ----------
        //return mPsc;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.263 -0400", hash_original_method = "FCA91E5B63933202A24477E6F48B3BA4", hash_generated_method = "BB933A23AF5B88892C1519E997FF80C3")
    public void setStateInvalid() {
        mLac = -1;
        mCid = -1;
        mPsc = -1;
        // ---------- Original Method ----------
        //mLac = -1;
        //mCid = -1;
        //mPsc = -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.264 -0400", hash_original_method = "7E7A76E42558C43BF4B90F38BACF91D2", hash_generated_method = "40F58B370039924C8421676095F63887")
    public void setLacAndCid(int lac, int cid) {
        mLac = lac;
        mCid = cid;
        // ---------- Original Method ----------
        //mLac = lac;
        //mCid = cid;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.264 -0400", hash_original_method = "C81AA559E9201CC662BD56FE57EC5612", hash_generated_method = "FBA4344E835EEEB4D9AAE7A0BA923E04")
    public void setPsc(int psc) {
        mPsc = psc;
        // ---------- Original Method ----------
        //mPsc = psc;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.265 -0400", hash_original_method = "01808FF7591EA9C272F4AD513B525DCA", hash_generated_method = "F1A5C5C9EF8258AA7175554A855B9BAF")
    @Override
    public int hashCode() {
        int var867E4B3A2DBFC27EEC994A90ACF3674B_642858275 = (mLac ^ mCid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_331621092 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_331621092;
        // ---------- Original Method ----------
        //return mLac ^ mCid;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.266 -0400", hash_original_method = "A65316AC0F6A2A4C5019C1501720E22E", hash_generated_method = "8B4F622331BD10C72BC93FE7CD5E72BB")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        GsmCellLocation s;
        try 
        {
            s = (GsmCellLocation)o;
        } //End block
        catch (ClassCastException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_1461008434 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2021949840 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2021949840;
        } //End block
        if(o == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_545214963 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_5372617 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_5372617;
        } //End block
        boolean var7A26B01A6E5D99B47BC75E96674FC0E4_1554676808 = (equalsHandlesNulls(mLac, s.mLac) && equalsHandlesNulls(mCid, s.mCid)
            && equalsHandlesNulls(mPsc, s.mPsc));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_280535008 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_280535008;
        // ---------- Original Method ----------
        //GsmCellLocation s;
        //try {
            //s = (GsmCellLocation)o;
        //} catch (ClassCastException ex) {
            //return false;
        //}
        //if (o == null) {
            //return false;
        //}
        //return equalsHandlesNulls(mLac, s.mLac) && equalsHandlesNulls(mCid, s.mCid)
            //&& equalsHandlesNulls(mPsc, s.mPsc);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.267 -0400", hash_original_method = "ECC0B1700594AB1E58D4785492DA1471", hash_generated_method = "FBBC4EF8BD4FE60B2A049FF3A40FEE25")
    @Override
    public String toString() {
String varF33E5A404114ABDA40FB2431CC5ECD4B_1481956726 =         "["+ mLac + "," + mCid + "," + mPsc + "]";
        varF33E5A404114ABDA40FB2431CC5ECD4B_1481956726.addTaint(taint);
        return varF33E5A404114ABDA40FB2431CC5ECD4B_1481956726;
        // ---------- Original Method ----------
        //return "["+ mLac + "," + mCid + "," + mPsc + "]";
    }

    
    @DSModeled(DSC.BAN)
    private static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.269 -0400", hash_original_method = "B1833CAE05CF94C17F526310C03CDC81", hash_generated_method = "5CC1544C195D5AEBE9619676F0E85FB8")
    public void fillInNotifierBundle(Bundle m) {
        addTaint(m.getTaint());
        m.putInt("lac", mLac);
        m.putInt("cid", mCid);
        m.putInt("psc", mPsc);
        // ---------- Original Method ----------
        //m.putInt("lac", mLac);
        //m.putInt("cid", mCid);
        //m.putInt("psc", mPsc);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.270 -0400", hash_original_method = "4AB62BA2C67CFF55264B23F8CEEE7482", hash_generated_method = "82480DC33D1CE757028DC116E1817963")
    public boolean isEmpty() {
        boolean varA4BAC2586B510062364329D68E1FF9DE_1045194711 = ((mLac == -1 && mCid == -1 && mPsc == -1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2085603537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2085603537;
        // ---------- Original Method ----------
        //return (mLac == -1 && mCid == -1 && mPsc == -1);
    }

    
}

