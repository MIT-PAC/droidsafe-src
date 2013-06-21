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
    private Parcelable mSuperState;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.440 -0400", hash_original_method = "98DB61DECD5C8032FFDEFFDBC7A07300", hash_generated_method = "DDE4E11A79D0DBE3ACE7A957674D3B72")
    @DSModeled(DSC.SAFE)
    private AbsSavedState() {
        mSuperState = null;
        // ---------- Original Method ----------
        //mSuperState = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.440 -0400", hash_original_method = "D4C1FB84674D7B9566A2C16E0F6CE527", hash_generated_method = "5F0FA8413E7E018D1E9CC9ADB79B280A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.441 -0400", hash_original_method = "36C68CF6BE081F45C28577588985103D", hash_generated_method = "4F52F7492613CB50198D552E2FC71D86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AbsSavedState(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        Parcelable superState;
        superState = source.readParcelable(null);
        mSuperState = superState != null ? superState : EMPTY_STATE;
        // ---------- Original Method ----------
        //Parcelable superState = source.readParcelable(null);
        //mSuperState = superState != null ? superState : EMPTY_STATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.441 -0400", hash_original_method = "D1776F094204A2E68E2669C5D33A32E2", hash_generated_method = "9D6341ADE9960554403A9CA889EAEB2B")
    @DSModeled(DSC.SAFE)
    final public Parcelable getSuperState() {
        return (Parcelable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSuperState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.441 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.441 -0400", hash_original_method = "49F04AE9062C121AE76FFD8C13AF6818", hash_generated_method = "684ACE81CF571ADA15EF8AE8E418B2D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeParcelable(mSuperState, flags);
        // ---------- Original Method ----------
        //dest.writeParcelable(mSuperState, flags);
    }

    
    public static final AbsSavedState EMPTY_STATE = new AbsSavedState() {        
}; //Transformed anonymous class
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new Parcelable.Creator<AbsSavedState>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.441 -0400", hash_original_method = "332B0C76686B55CA74FEB51D34AF75F4", hash_generated_method = "019AB82DBFD2554FE9FC359FDCA341D0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.441 -0400", hash_original_method = "B087F2336A16D46F6C09A897DF492270", hash_generated_method = "AD1E6506CE5ADDBAB3E24CE36ADB1902")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AbsSavedState[] newArray(int size) {
            dsTaint.addTaint(size);
            AbsSavedState[] var7D79672E1136987592178D7985DC6FE4_1727298813 = (new AbsSavedState[size]);
            return (AbsSavedState[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AbsSavedState[size];
        }

        
}; //Transformed anonymous class
}

