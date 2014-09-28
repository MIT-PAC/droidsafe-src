package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class AbsSavedState implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.406 -0500", hash_original_field = "6145E0F80353A475CC55492C0FF63B95", hash_generated_field = "23C63B06C45486E5E57AC4257D5F33FA")

    public static final AbsSavedState EMPTY_STATE = new AbsSavedState() {};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.394 -0400", hash_original_field = "D1A0D03493186A39A161E69FA2FF0334", hash_generated_field = "0833D3C2081B6D0D13E6946E8CE853EE")

    public static final Parcelable.Creator<AbsSavedState> CREATOR 
        = new Parcelable.Creator<AbsSavedState>() {
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.426 -0500", hash_original_method = "332B0C76686B55CA74FEB51D34AF75F4", hash_generated_method = "1D98158E68DE928EE5E3060CEA2B8762")
        
public AbsSavedState createFromParcel(Parcel in) {
            Parcelable superState = in.readParcelable(null);
            if (superState != null) {
                throw new IllegalStateException("superState must be null");
            }
            return EMPTY_STATE;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.429 -0500", hash_original_method = "B087F2336A16D46F6C09A897DF492270", hash_generated_method = "F40C768D43C1F055E822326A23AD9B9C")
        
public AbsSavedState[] newArray(int size) {
            return new AbsSavedState[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.408 -0500", hash_original_field = "D5DA1F3A7CD37F6DE3D20850965E56F6", hash_generated_field = "EEFC201B63925E4659FF4A1C55B1892F")

    private  Parcelable mSuperState;

    /**
     * Constructor used to make the EMPTY_STATE singleton
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.411 -0500", hash_original_method = "98DB61DECD5C8032FFDEFFDBC7A07300", hash_generated_method = "81ACCF327F7B487F640981502C2E553B")
    
private AbsSavedState() {
        mSuperState = null;
    }

    /**
     * Constructor called by derived classes when creating their SavedState objects
     * 
     * @param superState The state of the superclass of this view
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.413 -0500", hash_original_method = "D4C1FB84674D7B9566A2C16E0F6CE527", hash_generated_method = "DCCCB39C104037BA5146A8F704DA4356")
    
protected AbsSavedState(Parcelable superState) {
        if (superState == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        mSuperState = superState != EMPTY_STATE ? superState : null;
    }

    /**
     * Constructor used when reading from a parcel. Reads the state of the superclass.
     * 
     * @param source
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.416 -0500", hash_original_method = "36C68CF6BE081F45C28577588985103D", hash_generated_method = "83DFDCCC104CD8F4F4D70A57E053B2A2")
    
protected AbsSavedState(Parcel source) {
        // FIXME need class loader
        Parcelable superState = source.readParcelable(null);
         
        mSuperState = superState != null ? superState : EMPTY_STATE;
    }

    @DSComment("Data serialization/deserialization")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.418 -0500", hash_original_method = "D1776F094204A2E68E2669C5D33A32E2", hash_generated_method = "AF464EED3716AECE0A66502BB0592F8F")
    
final public Parcelable getSuperState() {
        return mSuperState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.420 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSComment("Data serialization/deserialization")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.423 -0500", hash_original_method = "49F04AE9062C121AE76FFD8C13AF6818", hash_generated_method = "59DEDCCB266A692EC97DC26A98166A87")
    @DSVerified
     
public void writeToParcel(Parcel dest, int flags) {
         dest.writeParcelable(mSuperState, flags);
    }
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

