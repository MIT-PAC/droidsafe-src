package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class AbsSavedState implements Parcelable {
    public static final AbsSavedState EMPTY_STATE = new AbsSavedState() {        
}; //Transformed anonymous class
    private Parcelable mSuperState;
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new Parcelable.Creator<AbsSavedState>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:05:29.259 -0400", hash_original_method = "332B0C76686B55CA74FEB51D34AF75F4", hash_generated_method = "66F430856A0893D734D8EB6A915ABEBD")
        @DSModeled(DSC.SAFE)
        public AbsSavedState createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            Parcelable superState;
            superState = in.readParcelable(null);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("superState must be null");
            } //End block
            return (AbsSavedState)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Parcelable superState = in.readParcelable(null);
            //if (superState != null) {
                //throw new IllegalStateException("superState must be null");
            //}
            //return EMPTY_STATE;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:05:29.281 -0400", hash_original_method = "B087F2336A16D46F6C09A897DF492270", hash_generated_method = "3966E4430AEA0B49375C5FC55319438B")
        @DSModeled(DSC.SAFE)
        public AbsSavedState[] newArray(int size) {
            dsTaint.addTaint(size);
            return (AbsSavedState[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AbsSavedState[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:05:29.297 -0400", hash_original_method = "98DB61DECD5C8032FFDEFFDBC7A07300", hash_generated_method = "0C68B25E8AE1C7E3810F2FB1DBA6DB17")
    @DSModeled(DSC.SAFE)
    private AbsSavedState() {
        mSuperState = null;
        // ---------- Original Method ----------
        //mSuperState = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:05:29.306 -0400", hash_original_method = "D4C1FB84674D7B9566A2C16E0F6CE527", hash_generated_method = "FCBAA46A109E18CC651E15B1F5437475")
    @DSModeled(DSC.SAFE)
    protected AbsSavedState(Parcelable superState) {
        dsTaint.addTaint(superState.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("superState must not be null");
        } //End block
        mSuperState = superState != EMPTY_STATE ? superState : null;
        // ---------- Original Method ----------
        //if (superState == null) {
            //throw new IllegalArgumentException("superState must not be null");
        //}
        //mSuperState = superState != EMPTY_STATE ? superState : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:05:29.316 -0400", hash_original_method = "36C68CF6BE081F45C28577588985103D", hash_generated_method = "D4250712C57BD02D4842E66D1401A050")
    @DSModeled(DSC.SAFE)
    protected AbsSavedState(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        Parcelable superState;
        superState = source.readParcelable(null);
        mSuperState = superState != null ? superState : EMPTY_STATE;
        // ---------- Original Method ----------
        //Parcelable superState = source.readParcelable(null);
        //mSuperState = superState != null ? superState : EMPTY_STATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:05:29.333 -0400", hash_original_method = "D1776F094204A2E68E2669C5D33A32E2", hash_generated_method = "0D807B766304681FE5E36A09401BF386")
    @DSModeled(DSC.SAFE)
    final public Parcelable getSuperState() {
        return (Parcelable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSuperState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:05:29.339 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:05:29.347 -0400", hash_original_method = "49F04AE9062C121AE76FFD8C13AF6818", hash_generated_method = "150F0AD625DCF5D7423631CA0E7C3887")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeParcelable(mSuperState, flags);
        // ---------- Original Method ----------
        //dest.writeParcelable(mSuperState, flags);
    }

    
}


