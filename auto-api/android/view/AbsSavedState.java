package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class AbsSavedState implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.815 -0400", hash_original_field = "E79BC38E7D1FDBAAEC758443D630638F", hash_generated_field = "EEFC201B63925E4659FF4A1C55B1892F")

    private Parcelable mSuperState;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.815 -0400", hash_original_method = "98DB61DECD5C8032FFDEFFDBC7A07300", hash_generated_method = "DDE4E11A79D0DBE3ACE7A957674D3B72")
    private  AbsSavedState() {
        mSuperState = null;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.815 -0400", hash_original_method = "D4C1FB84674D7B9566A2C16E0F6CE527", hash_generated_method = "BADC7F5D8A2E07C5A8D8049522509A87")
    protected  AbsSavedState(Parcelable superState) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("superState must not be null");
        } 
        mSuperState = superState != EMPTY_STATE ? superState : null;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.816 -0400", hash_original_method = "36C68CF6BE081F45C28577588985103D", hash_generated_method = "3C9AD94B7CAFD8F4678D1ED086B4680D")
    protected  AbsSavedState(Parcel source) {
        Parcelable superState = source.readParcelable(null);
        mSuperState = superState != null ? superState : EMPTY_STATE;
        addTaint(source.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.817 -0400", hash_original_method = "D1776F094204A2E68E2669C5D33A32E2", hash_generated_method = "A17808A3DA32F8DCF575FBC1242A4FEC")
    final public Parcelable getSuperState() {
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_905194675 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_905194675 = mSuperState;
        varB4EAC82CA7396A68D541C85D26508E83_905194675.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_905194675;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.817 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "C4F6AD3E35E73503152CFBC390741DCB")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1632117385 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1632117385;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.817 -0400", hash_original_method = "49F04AE9062C121AE76FFD8C13AF6818", hash_generated_method = "C38593A2809611A9A3F197A8BF2F840F")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mSuperState, flags);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.817 -0400", hash_original_field = "FDCEAE119BFC77E27CAD4C13F477CCAC", hash_generated_field = "23C63B06C45486E5E57AC4257D5F33FA")

    public static final AbsSavedState EMPTY_STATE = new AbsSavedState() {};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.817 -0400", hash_original_field = "D1A0D03493186A39A161E69FA2FF0334", hash_generated_field = "0833D3C2081B6D0D13E6946E8CE853EE")

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
    
}

