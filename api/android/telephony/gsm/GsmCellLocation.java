package android.telephony.gsm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Bundle;
import android.telephony.CellLocation;

public class GsmCellLocation extends CellLocation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.741 -0400", hash_original_field = "B2F9C701F6B9FA98A906A1D27571667E", hash_generated_field = "E1DF72766EAA7700CC09E2EF71762BF7")

    private int mLac;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.741 -0400", hash_original_field = "47909A4A63C9D0DF4D400D36305EA002", hash_generated_field = "6613038ECFEA58ECF70AB91998D5EB03")

    private int mCid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.742 -0400", hash_original_field = "865B7932A3A776B1F3AFFD84DFC3DDFF", hash_generated_field = "EC9E5D02BA114935D10D39D2FABA270A")

    private int mPsc;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.742 -0400", hash_original_method = "666EDAF57125B4E49F0CA8BF9D68AAC9", hash_generated_method = "5DBE3D4937998589F506A0C5FBEECDA8")
    public  GsmCellLocation() {
        mLac = -1;
        mCid = -1;
        mPsc = -1;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.743 -0400", hash_original_method = "C24176B61861DC93124341EFD3884687", hash_generated_method = "13083EADD6AE07C87E9A55AA22608BCF")
    public  GsmCellLocation(Bundle bundle) {
        mLac = bundle.getInt("lac", mLac);
        mCid = bundle.getInt("cid", mCid);
        mPsc = bundle.getInt("psc", mPsc);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.743 -0400", hash_original_method = "9D27DA83295DE88E54D1A14DE01D13B2", hash_generated_method = "9CD626D3B7E761B74975832D2EC44050")
    public int getLac() {
        int varB2F9C701F6B9FA98A906A1D27571667E_2081994543 = (mLac);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_861891885 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_861891885;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.744 -0400", hash_original_method = "03F3B6133F275A943C2D43BD3469FDB7", hash_generated_method = "C38C5EBA86C63B3ED00FF673DBA0E0E9")
    public int getCid() {
        int var47909A4A63C9D0DF4D400D36305EA002_607902683 = (mCid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625517039 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625517039;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.744 -0400", hash_original_method = "0E29DC7205E312820087B8B417C09B13", hash_generated_method = "8A927D3DD3250D8C1B07B25C6E32A613")
    public int getPsc() {
        int var865B7932A3A776B1F3AFFD84DFC3DDFF_1543528397 = (mPsc);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288155429 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288155429;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.744 -0400", hash_original_method = "FCA91E5B63933202A24477E6F48B3BA4", hash_generated_method = "BB933A23AF5B88892C1519E997FF80C3")
    public void setStateInvalid() {
        mLac = -1;
        mCid = -1;
        mPsc = -1;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.745 -0400", hash_original_method = "7E7A76E42558C43BF4B90F38BACF91D2", hash_generated_method = "40F58B370039924C8421676095F63887")
    public void setLacAndCid(int lac, int cid) {
        mLac = lac;
        mCid = cid;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.746 -0400", hash_original_method = "C81AA559E9201CC662BD56FE57EC5612", hash_generated_method = "FBA4344E835EEEB4D9AAE7A0BA923E04")
    public void setPsc(int psc) {
        mPsc = psc;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.746 -0400", hash_original_method = "01808FF7591EA9C272F4AD513B525DCA", hash_generated_method = "868F032E064A1E1CA8AF510990129805")
    @Override
    public int hashCode() {
        int var867E4B3A2DBFC27EEC994A90ACF3674B_1298460573 = (mLac ^ mCid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_192866344 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_192866344;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.747 -0400", hash_original_method = "A65316AC0F6A2A4C5019C1501720E22E", hash_generated_method = "82FD64C540AC6607B16D76DFA675688F")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        GsmCellLocation s;
        try 
        {
            s = (GsmCellLocation)o;
        } 
        catch (ClassCastException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_168141537 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_385120342 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_385120342;
        } 
    if(o == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1225986645 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1024298358 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1024298358;
        } 
        boolean var7A26B01A6E5D99B47BC75E96674FC0E4_2089259080 = (equalsHandlesNulls(mLac, s.mLac) && equalsHandlesNulls(mCid, s.mCid)
            && equalsHandlesNulls(mPsc, s.mPsc));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1762546041 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1762546041;
        
        
        
            
        
            
        
        
            
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.748 -0400", hash_original_method = "ECC0B1700594AB1E58D4785492DA1471", hash_generated_method = "54AFB8252274B4FB48C29433B6700713")
    @Override
    public String toString() {
String varF33E5A404114ABDA40FB2431CC5ECD4B_1263840189 =         "["+ mLac + "," + mCid + "," + mPsc + "]";
        varF33E5A404114ABDA40FB2431CC5ECD4B_1263840189.addTaint(taint);
        return varF33E5A404114ABDA40FB2431CC5ECD4B_1263840189;
        
        
    }

    
        private static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.749 -0400", hash_original_method = "B1833CAE05CF94C17F526310C03CDC81", hash_generated_method = "5CC1544C195D5AEBE9619676F0E85FB8")
    public void fillInNotifierBundle(Bundle m) {
        addTaint(m.getTaint());
        m.putInt("lac", mLac);
        m.putInt("cid", mCid);
        m.putInt("psc", mPsc);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.750 -0400", hash_original_method = "4AB62BA2C67CFF55264B23F8CEEE7482", hash_generated_method = "1F1BE98834EE118445ACB5B080557EE6")
    public boolean isEmpty() {
        boolean varA4BAC2586B510062364329D68E1FF9DE_1737568464 = ((mLac == -1 && mCid == -1 && mPsc == -1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1715939740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1715939740;
        
        
    }

    
}

