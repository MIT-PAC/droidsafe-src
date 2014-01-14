package android.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Bundle;
import android.telephony.CellLocation;

public class GsmCellLocation extends CellLocation {

    /**
     * Test whether two objects hold the same data values or both are null
     *
     * @param a first obj
     * @param b second obj
     * @return true if two objects equal or both are null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:43.707 -0500", hash_original_method = "BC145A1DE2472995676ED9A315FB0956", hash_generated_method = "171409CD29A7B7D5AD18DD4C394534AC")
    
private static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:43.572 -0500", hash_original_field = "DD653ED27FEE3ABB69B8731CF5FBE1FA", hash_generated_field = "E1DF72766EAA7700CC09E2EF71762BF7")

    private int mLac;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:43.582 -0500", hash_original_field = "3FDE358D194E184A7314E5F9932F2066", hash_generated_field = "6613038ECFEA58ECF70AB91998D5EB03")

    private int mCid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:43.589 -0500", hash_original_field = "DCD75389F80E9394B7B52A1B1EFB37AD", hash_generated_field = "EC9E5D02BA114935D10D39D2FABA270A")

    private int mPsc;

    /**
     * Empty constructor.  Initializes the LAC and CID to -1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:43.598 -0500", hash_original_method = "666EDAF57125B4E49F0CA8BF9D68AAC9", hash_generated_method = "FC813C922246E650DA4FDE16B8D8F10A")
    
public GsmCellLocation() {
        mLac = -1;
        mCid = -1;
        mPsc = -1;
    }

    /**
     * Initialize the object from a bundle.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:43.609 -0500", hash_original_method = "C24176B61861DC93124341EFD3884687", hash_generated_method = "C57FFB0E757E667CC454DE2D973702B2")
    
public GsmCellLocation(Bundle bundle) {
        mLac = bundle.getInt("lac", mLac);
        mCid = bundle.getInt("cid", mCid);
        mPsc = bundle.getInt("psc", mPsc);
    }

    /**
     * @return gsm location area code, -1 if unknown, 0xffff max legal value
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:43.617 -0500", hash_original_method = "9D27DA83295DE88E54D1A14DE01D13B2", hash_generated_method = "A18DED515734753DC64C50C9F3494A83")
    
public int getLac() {
        return mLac;
    }

    /**
     * @return gsm cell id, -1 if unknown, 0xffff max legal value
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:43.634 -0500", hash_original_method = "03F3B6133F275A943C2D43BD3469FDB7", hash_generated_method = "ED491AA69C7D5EA58049D948836E075E")
    
public int getCid() {
        return mCid;
    }

    /**
     * On a UMTS network, returns the primary scrambling code of the serving
     * cell.
     *
     * @return primary scrambling code for UMTS, -1 if unknown or GSM
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:43.643 -0500", hash_original_method = "0E29DC7205E312820087B8B417C09B13", hash_generated_method = "27709C0F99A78EF49BB7521467E3693E")
    
public int getPsc() {
        return mPsc;
    }

    /**
     * Invalidate this object.  The location area code and the cell id are set to -1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:43.652 -0500", hash_original_method = "FCA91E5B63933202A24477E6F48B3BA4", hash_generated_method = "B4AFECC2E27CD408B1DFA69598AF30BC")
    
public void setStateInvalid() {
        mLac = -1;
        mCid = -1;
        mPsc = -1;
    }

    /**
     * Set the location area code and the cell id.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:43.659 -0500", hash_original_method = "7E7A76E42558C43BF4B90F38BACF91D2", hash_generated_method = "B29BB2C39A6A3E1563886EA5958B3748")
    
public void setLacAndCid(int lac, int cid) {
        mLac = lac;
        mCid = cid;
    }

    /**
     * Set the primary scrambling code.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:43.667 -0500", hash_original_method = "C81AA559E9201CC662BD56FE57EC5612", hash_generated_method = "BCC0F5B93C9B191B9EBF4A4253F64DC3")
    
public void setPsc(int psc) {
        mPsc = psc;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:43.676 -0500", hash_original_method = "01808FF7591EA9C272F4AD513B525DCA", hash_generated_method = "4CC437BB0D8859A48174A1D7CA5BD802")
    
@Override
    public int hashCode() {
        return mLac ^ mCid;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:43.687 -0500", hash_original_method = "A65316AC0F6A2A4C5019C1501720E22E", hash_generated_method = "81ADE2CDDADB9394E165117ECC023AB2")
    
@Override
    public boolean equals(Object o) {
        GsmCellLocation s;

        try {
            s = (GsmCellLocation)o;
        } catch (ClassCastException ex) {
            return false;
        }

        if (o == null) {
            return false;
        }

        return equalsHandlesNulls(mLac, s.mLac) && equalsHandlesNulls(mCid, s.mCid)
            && equalsHandlesNulls(mPsc, s.mPsc);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:43.697 -0500", hash_original_method = "ECC0B1700594AB1E58D4785492DA1471", hash_generated_method = "FDEE863DDC078BD27B817D7A6E7D672F")
    
@Override
    public String toString() {
        return "["+ mLac + "," + mCid + "," + mPsc + "]";
    }

    /**
     * Set intent notifier Bundle based on service state
     *
     * @param m intent notifier Bundle
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:43.718 -0500", hash_original_method = "B1833CAE05CF94C17F526310C03CDC81", hash_generated_method = "4062AC33E6E6F5A61EE3E47E82302200")
    
public void fillInNotifierBundle(Bundle m) {
        m.putInt("lac", mLac);
        m.putInt("cid", mCid);
        m.putInt("psc", mPsc);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:43.731 -0500", hash_original_method = "4AB62BA2C67CFF55264B23F8CEEE7482", hash_generated_method = "BB243673581817E8F66F7615EFE4F49A")
    
public boolean isEmpty() {
        return (mLac == -1 && mCid == -1 && mPsc == -1);
    }
    
}

