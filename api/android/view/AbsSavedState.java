package android.view;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;





public abstract class AbsSavedState implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.390 -0400", hash_original_field = "E79BC38E7D1FDBAAEC758443D630638F", hash_generated_field = "EEFC201B63925E4659FF4A1C55B1892F")

    private Parcelable mSuperState;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.391 -0400", hash_original_method = "98DB61DECD5C8032FFDEFFDBC7A07300", hash_generated_method = "DDE4E11A79D0DBE3ACE7A957674D3B72")
    private  AbsSavedState() {
        mSuperState = null;
        // ---------- Original Method ----------
        //mSuperState = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.392 -0400", hash_original_method = "D4C1FB84674D7B9566A2C16E0F6CE527", hash_generated_method = "B78349F4D2D30F55BAAE83411B92A1D5")
    protected  AbsSavedState(Parcelable superState) {
        if(superState == null)        
        {
            IllegalArgumentException var6F246C2A8E6FC55D4CCA5BECC17EDD84_259606751 = new IllegalArgumentException("superState must not be null");
            var6F246C2A8E6FC55D4CCA5BECC17EDD84_259606751.addTaint(taint);
            throw var6F246C2A8E6FC55D4CCA5BECC17EDD84_259606751;
        } //End block
        mSuperState = superState != EMPTY_STATE ? superState : null;
        // ---------- Original Method ----------
        //if (superState == null) {
            //throw new IllegalArgumentException("superState must not be null");
        //}
        //mSuperState = superState != EMPTY_STATE ? superState : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.393 -0400", hash_original_method = "36C68CF6BE081F45C28577588985103D", hash_generated_method = "1F1448DE724042946A6069EDBEA36A6E")
    protected  AbsSavedState(Parcel source) {
        addTaint(source.getTaint());
        Parcelable superState = source.readParcelable(null);
        mSuperState = superState != null ? superState : EMPTY_STATE;
        // ---------- Original Method ----------
        //Parcelable superState = source.readParcelable(null);
        //mSuperState = superState != null ? superState : EMPTY_STATE;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.393 -0400", hash_original_method = "D1776F094204A2E68E2669C5D33A32E2", hash_generated_method = "569DC03964E1C6FF767210656C364384")
    final public Parcelable getSuperState() {
Parcelable var24424C2D2EF752A9D21649F03626A4B3_1982536297 =         mSuperState;
        var24424C2D2EF752A9D21649F03626A4B3_1982536297.addTaint(taint);
        return var24424C2D2EF752A9D21649F03626A4B3_1982536297;
        // ---------- Original Method ----------
        //return mSuperState;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.393 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "1E03531E7A78936E54DDADCC724BF5F7")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1347853609 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1111589592 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1111589592;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.394 -0400", hash_original_method = "49F04AE9062C121AE76FFD8C13AF6818", hash_generated_method = "B89CCEE673445C1158793CC7051F939D")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeParcelable(mSuperState, flags);
        // ---------- Original Method ----------
        //dest.writeParcelable(mSuperState, flags);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.394 -0400", hash_original_field = "FDCEAE119BFC77E27CAD4C13F477CCAC", hash_generated_field = "23C63B06C45486E5E57AC4257D5F33FA")

    public static final AbsSavedState EMPTY_STATE = new AbsSavedState() {};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.394 -0400", hash_original_field = "D1A0D03493186A39A161E69FA2FF0334", hash_generated_field = "0833D3C2081B6D0D13E6946E8CE853EE")

    public static final Parcelable.Creator<AbsSavedState> CREATOR 
        = new Parcelable.Creator<AbsSavedState>() {
        
        public AbsSavedState createFromParcel(Parcel in) {
            Parcelable superState = in.readParcelable(null);
            if (superState != null) {
                throw new IllegalStateException("superState must be null");
            }
            return EMPTY_STATE;
        }

        public AbsSavedState[] newArray(int size) {
            return new AbsSavedState[size];
        }
    };
    // orphaned legacy method
    public AbsSavedState createFromParcel(Parcel in) {
            Parcelable superState = in.readParcelable(null);
            if (superState != null) {
                throw new IllegalStateException("superState must be null");
            }
            return EMPTY_STATE;
        }
    
    // orphaned legacy method
    public AbsSavedState[] newArray(int size) {
            return new AbsSavedState[size];
        }
    
}

