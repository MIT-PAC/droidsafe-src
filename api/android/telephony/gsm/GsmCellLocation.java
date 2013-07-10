package android.telephony.gsm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Bundle;
import android.telephony.CellLocation;

public class GsmCellLocation extends CellLocation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.453 -0400", hash_original_field = "B2F9C701F6B9FA98A906A1D27571667E", hash_generated_field = "E1DF72766EAA7700CC09E2EF71762BF7")

    private int mLac;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.453 -0400", hash_original_field = "47909A4A63C9D0DF4D400D36305EA002", hash_generated_field = "6613038ECFEA58ECF70AB91998D5EB03")

    private int mCid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.453 -0400", hash_original_field = "865B7932A3A776B1F3AFFD84DFC3DDFF", hash_generated_field = "EC9E5D02BA114935D10D39D2FABA270A")

    private int mPsc;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.454 -0400", hash_original_method = "666EDAF57125B4E49F0CA8BF9D68AAC9", hash_generated_method = "5DBE3D4937998589F506A0C5FBEECDA8")
    public  GsmCellLocation() {
        mLac = -1;
        mCid = -1;
        mPsc = -1;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.454 -0400", hash_original_method = "C24176B61861DC93124341EFD3884687", hash_generated_method = "13083EADD6AE07C87E9A55AA22608BCF")
    public  GsmCellLocation(Bundle bundle) {
        mLac = bundle.getInt("lac", mLac);
        mCid = bundle.getInt("cid", mCid);
        mPsc = bundle.getInt("psc", mPsc);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.455 -0400", hash_original_method = "9D27DA83295DE88E54D1A14DE01D13B2", hash_generated_method = "8D305E6F231940679ED6BD3DC427F855")
    public int getLac() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_527279334 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_527279334;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.456 -0400", hash_original_method = "03F3B6133F275A943C2D43BD3469FDB7", hash_generated_method = "0C9B3B47EC766C231C1E4DB9E9A93E9D")
    public int getCid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1722097647 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1722097647;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.456 -0400", hash_original_method = "0E29DC7205E312820087B8B417C09B13", hash_generated_method = "163B0412082B079CF0B002FAD008F871")
    public int getPsc() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1320026990 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1320026990;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.457 -0400", hash_original_method = "FCA91E5B63933202A24477E6F48B3BA4", hash_generated_method = "BB933A23AF5B88892C1519E997FF80C3")
    public void setStateInvalid() {
        mLac = -1;
        mCid = -1;
        mPsc = -1;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.457 -0400", hash_original_method = "7E7A76E42558C43BF4B90F38BACF91D2", hash_generated_method = "40F58B370039924C8421676095F63887")
    public void setLacAndCid(int lac, int cid) {
        mLac = lac;
        mCid = cid;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.458 -0400", hash_original_method = "C81AA559E9201CC662BD56FE57EC5612", hash_generated_method = "FBA4344E835EEEB4D9AAE7A0BA923E04")
    public void setPsc(int psc) {
        mPsc = psc;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.458 -0400", hash_original_method = "01808FF7591EA9C272F4AD513B525DCA", hash_generated_method = "643EC4E46A9170742999B2A80B522E69")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1857452871 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1857452871;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.126 -0400", hash_original_method = "A65316AC0F6A2A4C5019C1501720E22E", hash_generated_method = "DE1100069A2FE3488789164DE76E2E0F")
    @Override
    public boolean equals(Object o) {
        GsmCellLocation s = null;
        try 
        {
            s = (GsmCellLocation)o;
        } 
        catch (ClassCastException ex)
        { }
        boolean var5848B7138A7FC4EE07B45FD1B33E0121_116967673 = (equalsHandlesNulls(mLac, s.mLac) && equalsHandlesNulls(mCid, s.mCid)
            && equalsHandlesNulls(mPsc, s.mPsc));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_336751656 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_336751656;
        
        
        
            
        
            
        
        
            
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.459 -0400", hash_original_method = "ECC0B1700594AB1E58D4785492DA1471", hash_generated_method = "29D73A738E9E3A39570D97B794085FF8")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_717602255 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_717602255 = "["+ mLac + "," + mCid + "," + mPsc + "]";
        varB4EAC82CA7396A68D541C85D26508E83_717602255.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_717602255;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.459 -0400", hash_original_method = "B1833CAE05CF94C17F526310C03CDC81", hash_generated_method = "E95A18F0550C66C1C56C7DFC21D1992B")
    public void fillInNotifierBundle(Bundle m) {
        m.putInt("lac", mLac);
        m.putInt("cid", mCid);
        m.putInt("psc", mPsc);
        addTaint(m.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.459 -0400", hash_original_method = "4AB62BA2C67CFF55264B23F8CEEE7482", hash_generated_method = "82B8DBEFE548CDE399E4EFE5430837AB")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1862609754 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1862609754;
        
        
    }

    
}

