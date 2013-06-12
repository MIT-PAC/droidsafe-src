package android.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Bundle;
import android.telephony.CellLocation;

public class GsmCellLocation extends CellLocation {
    private int mLac;
    private int mCid;
    private int mPsc;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.448 -0400", hash_original_method = "666EDAF57125B4E49F0CA8BF9D68AAC9", hash_generated_method = "04B5B07E90CC3937D8101AFEFEF5B51F")
    @DSModeled(DSC.SAFE)
    public GsmCellLocation() {
        mLac = -1;
        mCid = -1;
        mPsc = -1;
        // ---------- Original Method ----------
        //mLac = -1;
        //mCid = -1;
        //mPsc = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.448 -0400", hash_original_method = "C24176B61861DC93124341EFD3884687", hash_generated_method = "F6308155BB31651D0F993368B6239717")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GsmCellLocation(Bundle bundle) {
        dsTaint.addTaint(bundle.dsTaint);
        mLac = bundle.getInt("lac", mLac);
        mCid = bundle.getInt("cid", mCid);
        mPsc = bundle.getInt("psc", mPsc);
        // ---------- Original Method ----------
        //mLac = bundle.getInt("lac", mLac);
        //mCid = bundle.getInt("cid", mCid);
        //mPsc = bundle.getInt("psc", mPsc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.449 -0400", hash_original_method = "9D27DA83295DE88E54D1A14DE01D13B2", hash_generated_method = "67F80F104B867AD5651918656726F997")
    @DSModeled(DSC.SAFE)
    public int getLac() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLac;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.449 -0400", hash_original_method = "03F3B6133F275A943C2D43BD3469FDB7", hash_generated_method = "65CA93899720A1C6A6CB7BF878491579")
    @DSModeled(DSC.SAFE)
    public int getCid() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.449 -0400", hash_original_method = "0E29DC7205E312820087B8B417C09B13", hash_generated_method = "743EA09B94A176CE9E7E174C559E0F71")
    @DSModeled(DSC.SAFE)
    public int getPsc() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPsc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.449 -0400", hash_original_method = "FCA91E5B63933202A24477E6F48B3BA4", hash_generated_method = "7289530CA76A7F10AE9984E694842B4A")
    @DSModeled(DSC.SAFE)
    public void setStateInvalid() {
        mLac = -1;
        mCid = -1;
        mPsc = -1;
        // ---------- Original Method ----------
        //mLac = -1;
        //mCid = -1;
        //mPsc = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.449 -0400", hash_original_method = "7E7A76E42558C43BF4B90F38BACF91D2", hash_generated_method = "816D90016861F8EE23E3F7F2FA9FF960")
    @DSModeled(DSC.SAFE)
    public void setLacAndCid(int lac, int cid) {
        dsTaint.addTaint(cid);
        dsTaint.addTaint(lac);
        // ---------- Original Method ----------
        //mLac = lac;
        //mCid = cid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.449 -0400", hash_original_method = "C81AA559E9201CC662BD56FE57EC5612", hash_generated_method = "889D13ECD3DEB96C394641C06FC64F17")
    @DSModeled(DSC.SAFE)
    public void setPsc(int psc) {
        dsTaint.addTaint(psc);
        // ---------- Original Method ----------
        //mPsc = psc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.449 -0400", hash_original_method = "01808FF7591EA9C272F4AD513B525DCA", hash_generated_method = "165F1B9227F04850DA47C6049FADBF27")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLac ^ mCid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.449 -0400", hash_original_method = "A65316AC0F6A2A4C5019C1501720E22E", hash_generated_method = "0E8D2B078BA19EADBEB70613EBA224AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        GsmCellLocation s;
        try 
        {
            s = (GsmCellLocation)o;
        } //End block
        catch (ClassCastException ex)
        { }
        boolean var5848B7138A7FC4EE07B45FD1B33E0121_635512617 = (equalsHandlesNulls(mLac, s.mLac) && equalsHandlesNulls(mCid, s.mCid)
            && equalsHandlesNulls(mPsc, s.mPsc));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.449 -0400", hash_original_method = "ECC0B1700594AB1E58D4785492DA1471", hash_generated_method = "DE60D8BCD988D5C96336990DFC9B5B76")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "["+ mLac + "," + mCid + "," + mPsc + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.449 -0400", hash_original_method = "BC145A1DE2472995676ED9A315FB0956", hash_generated_method = "171409CD29A7B7D5AD18DD4C394534AC")
    private static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.449 -0400", hash_original_method = "B1833CAE05CF94C17F526310C03CDC81", hash_generated_method = "C4F794A39E80DFEFE7B059C55F5310D5")
    @DSModeled(DSC.SAFE)
    public void fillInNotifierBundle(Bundle m) {
        dsTaint.addTaint(m.dsTaint);
        m.putInt("lac", mLac);
        m.putInt("cid", mCid);
        m.putInt("psc", mPsc);
        // ---------- Original Method ----------
        //m.putInt("lac", mLac);
        //m.putInt("cid", mCid);
        //m.putInt("psc", mPsc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.449 -0400", hash_original_method = "4AB62BA2C67CFF55264B23F8CEEE7482", hash_generated_method = "53931B1E8BB4B0144E26CB9545B772C5")
    @DSModeled(DSC.SAFE)
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mLac == -1 && mCid == -1 && mPsc == -1);
    }

    
}


