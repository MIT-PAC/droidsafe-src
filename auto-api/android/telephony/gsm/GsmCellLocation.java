package android.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.telephony.CellLocation;

public class GsmCellLocation extends CellLocation {
    private int mLac;
    private int mCid;
    private int mPsc;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.918 -0400", hash_original_method = "666EDAF57125B4E49F0CA8BF9D68AAC9", hash_generated_method = "5DBE3D4937998589F506A0C5FBEECDA8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.920 -0400", hash_original_method = "C24176B61861DC93124341EFD3884687", hash_generated_method = "C6BCBE78F651DEB05F2C17C0B44BAC66")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.920 -0400", hash_original_method = "9D27DA83295DE88E54D1A14DE01D13B2", hash_generated_method = "31F966061BC352DBD246C1AFA076CE12")
    @DSModeled(DSC.SAFE)
    public int getLac() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLac;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.921 -0400", hash_original_method = "03F3B6133F275A943C2D43BD3469FDB7", hash_generated_method = "7DD277FA79EC9AB2362BF784406D1A21")
    @DSModeled(DSC.SAFE)
    public int getCid() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.921 -0400", hash_original_method = "0E29DC7205E312820087B8B417C09B13", hash_generated_method = "F05582F11BB788BADDB3833E437C2DC6")
    @DSModeled(DSC.SAFE)
    public int getPsc() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPsc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.922 -0400", hash_original_method = "FCA91E5B63933202A24477E6F48B3BA4", hash_generated_method = "BB933A23AF5B88892C1519E997FF80C3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.922 -0400", hash_original_method = "7E7A76E42558C43BF4B90F38BACF91D2", hash_generated_method = "035DEC988A86272055B5119C6460AF5B")
    @DSModeled(DSC.SAFE)
    public void setLacAndCid(int lac, int cid) {
        dsTaint.addTaint(cid);
        dsTaint.addTaint(lac);
        // ---------- Original Method ----------
        //mLac = lac;
        //mCid = cid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.922 -0400", hash_original_method = "C81AA559E9201CC662BD56FE57EC5612", hash_generated_method = "2BD21CF020E63572915AAF5FCFFD39C7")
    @DSModeled(DSC.SAFE)
    public void setPsc(int psc) {
        dsTaint.addTaint(psc);
        // ---------- Original Method ----------
        //mPsc = psc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.923 -0400", hash_original_method = "01808FF7591EA9C272F4AD513B525DCA", hash_generated_method = "B1DB0FE25B81BBB2310FA3957A8A9285")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLac ^ mCid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.923 -0400", hash_original_method = "A65316AC0F6A2A4C5019C1501720E22E", hash_generated_method = "C94328D9CBDF63F09A89D8BFE83AF3CD")
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
        boolean var5848B7138A7FC4EE07B45FD1B33E0121_400127254 = (equalsHandlesNulls(mLac, s.mLac) && equalsHandlesNulls(mCid, s.mCid)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.923 -0400", hash_original_method = "ECC0B1700594AB1E58D4785492DA1471", hash_generated_method = "3499E36A5DCD0BB8A12B20972954C4EF")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "["+ mLac + "," + mCid + "," + mPsc + "]";
    }

    
        private static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.924 -0400", hash_original_method = "B1833CAE05CF94C17F526310C03CDC81", hash_generated_method = "8584058855758C97FCB61EBC51457DA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.924 -0400", hash_original_method = "4AB62BA2C67CFF55264B23F8CEEE7482", hash_generated_method = "DD724E59ECECC715EC98D941DEFD7424")
    @DSModeled(DSC.SAFE)
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mLac == -1 && mCid == -1 && mPsc == -1);
    }

    
}

