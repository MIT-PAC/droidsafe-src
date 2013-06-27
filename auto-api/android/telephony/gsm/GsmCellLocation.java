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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.675 -0400", hash_original_field = "B2F9C701F6B9FA98A906A1D27571667E", hash_generated_field = "E1DF72766EAA7700CC09E2EF71762BF7")

    private int mLac;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.675 -0400", hash_original_field = "47909A4A63C9D0DF4D400D36305EA002", hash_generated_field = "6613038ECFEA58ECF70AB91998D5EB03")

    private int mCid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.675 -0400", hash_original_field = "865B7932A3A776B1F3AFFD84DFC3DDFF", hash_generated_field = "EC9E5D02BA114935D10D39D2FABA270A")

    private int mPsc;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.676 -0400", hash_original_method = "666EDAF57125B4E49F0CA8BF9D68AAC9", hash_generated_method = "5DBE3D4937998589F506A0C5FBEECDA8")
    public  GsmCellLocation() {
        mLac = -1;
        mCid = -1;
        mPsc = -1;
        // ---------- Original Method ----------
        //mLac = -1;
        //mCid = -1;
        //mPsc = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.676 -0400", hash_original_method = "C24176B61861DC93124341EFD3884687", hash_generated_method = "13083EADD6AE07C87E9A55AA22608BCF")
    public  GsmCellLocation(Bundle bundle) {
        mLac = bundle.getInt("lac", mLac);
        mCid = bundle.getInt("cid", mCid);
        mPsc = bundle.getInt("psc", mPsc);
        // ---------- Original Method ----------
        //mLac = bundle.getInt("lac", mLac);
        //mCid = bundle.getInt("cid", mCid);
        //mPsc = bundle.getInt("psc", mPsc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.677 -0400", hash_original_method = "9D27DA83295DE88E54D1A14DE01D13B2", hash_generated_method = "66913773B10982857B0B40DEAC84DF59")
    public int getLac() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_274332861 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_274332861;
        // ---------- Original Method ----------
        //return mLac;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.677 -0400", hash_original_method = "03F3B6133F275A943C2D43BD3469FDB7", hash_generated_method = "77BDE72D9DF286A4B992A63D5859B878")
    public int getCid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003560751 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003560751;
        // ---------- Original Method ----------
        //return mCid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.677 -0400", hash_original_method = "0E29DC7205E312820087B8B417C09B13", hash_generated_method = "AE8D61CA866D9E055A80EAE78BAAF095")
    public int getPsc() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_451003474 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_451003474;
        // ---------- Original Method ----------
        //return mPsc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.680 -0400", hash_original_method = "FCA91E5B63933202A24477E6F48B3BA4", hash_generated_method = "BB933A23AF5B88892C1519E997FF80C3")
    public void setStateInvalid() {
        mLac = -1;
        mCid = -1;
        mPsc = -1;
        // ---------- Original Method ----------
        //mLac = -1;
        //mCid = -1;
        //mPsc = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.686 -0400", hash_original_method = "7E7A76E42558C43BF4B90F38BACF91D2", hash_generated_method = "40F58B370039924C8421676095F63887")
    public void setLacAndCid(int lac, int cid) {
        mLac = lac;
        mCid = cid;
        // ---------- Original Method ----------
        //mLac = lac;
        //mCid = cid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.687 -0400", hash_original_method = "C81AA559E9201CC662BD56FE57EC5612", hash_generated_method = "FBA4344E835EEEB4D9AAE7A0BA923E04")
    public void setPsc(int psc) {
        mPsc = psc;
        // ---------- Original Method ----------
        //mPsc = psc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.687 -0400", hash_original_method = "01808FF7591EA9C272F4AD513B525DCA", hash_generated_method = "60A8DE28D5874BA5202F72036A4D6F6D")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_768584337 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_768584337;
        // ---------- Original Method ----------
        //return mLac ^ mCid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.704 -0400", hash_original_method = "A65316AC0F6A2A4C5019C1501720E22E", hash_generated_method = "9F182DAB62E537B5D664F472973C751E")
    @Override
    public boolean equals(Object o) {
        GsmCellLocation s;
        try 
        {
            s = (GsmCellLocation)o;
        } //End block
        catch (ClassCastException ex)
        { }
        boolean var5848B7138A7FC4EE07B45FD1B33E0121_1932554337 = (equalsHandlesNulls(mLac, s.mLac) && equalsHandlesNulls(mCid, s.mCid)
            && equalsHandlesNulls(mPsc, s.mPsc));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1071096503 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1071096503;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.704 -0400", hash_original_method = "ECC0B1700594AB1E58D4785492DA1471", hash_generated_method = "D98653DD201316AF0F2A440774BC92FA")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_982732587 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_982732587 = "["+ mLac + "," + mCid + "," + mPsc + "]";
        varB4EAC82CA7396A68D541C85D26508E83_982732587.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_982732587;
        // ---------- Original Method ----------
        //return "["+ mLac + "," + mCid + "," + mPsc + "]";
    }

    
        private static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.705 -0400", hash_original_method = "B1833CAE05CF94C17F526310C03CDC81", hash_generated_method = "E95A18F0550C66C1C56C7DFC21D1992B")
    public void fillInNotifierBundle(Bundle m) {
        m.putInt("lac", mLac);
        m.putInt("cid", mCid);
        m.putInt("psc", mPsc);
        addTaint(m.getTaint());
        // ---------- Original Method ----------
        //m.putInt("lac", mLac);
        //m.putInt("cid", mCid);
        //m.putInt("psc", mPsc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.706 -0400", hash_original_method = "4AB62BA2C67CFF55264B23F8CEEE7482", hash_generated_method = "A51D33898C5AB7232D085F46F2B887B9")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_554379497 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_554379497;
        // ---------- Original Method ----------
        //return (mLac == -1 && mCid == -1 && mPsc == -1);
    }

    
}

