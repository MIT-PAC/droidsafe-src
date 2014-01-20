package android.net.wifi;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public enum SupplicantState implements Parcelable {
    DISCONNECTED,
    INTERFACE_DISABLED,
    INACTIVE,
    SCANNING,
    AUTHENTICATING,
    ASSOCIATING,
    ASSOCIATED,
    FOUR_WAY_HANDSHAKE,
    GROUP_HANDSHAKE,
    COMPLETED,
    DORMANT,
    UNINITIALIZED,
    INVALID;

    /**
     * Returns {@code true} if the supplicant state is valid and {@code false}
     * otherwise.
     * @param state The supplicant state
     * @return {@code true} if the supplicant state is valid and {@code false}
     * otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.317 -0500", hash_original_method = "395CF8A648E197D9B9F9798A49DF4041", hash_generated_method = "118B92046FA12FA795C847FBB7099AE5")
        
public static boolean isValidState(SupplicantState state) {
        return state != UNINITIALIZED && state != INVALID;
    }

    /* Supplicant associating or authenticating is considered a handshake state */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.320 -0500", hash_original_method = "0936DB4F8E30F4E1D3370706859F46B3", hash_generated_method = "CA8CB1732BFB1828178082E03C9E5A65")
        
static boolean isHandshakeState(SupplicantState state) {
        switch(state) {
            case AUTHENTICATING:
            case ASSOCIATING:
            case ASSOCIATED:
            case FOUR_WAY_HANDSHAKE:
            case GROUP_HANDSHAKE:
                return true;
            case COMPLETED:
            case DISCONNECTED:
            case INTERFACE_DISABLED:
            case INACTIVE:
            case SCANNING:
            case DORMANT:
            case UNINITIALIZED:
            case INVALID:
                return false;
            default:
                throw new IllegalArgumentException("Unknown supplicant state");
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.323 -0500", hash_original_method = "A4F0348D390153A3F5D8FAA5CE09DCF2", hash_generated_method = "BF3CDF66A003D34E6785F3C5F5DCD820")
        
static boolean isConnecting(SupplicantState state) {
        switch(state) {
            case AUTHENTICATING:
            case ASSOCIATING:
            case ASSOCIATED:
            case FOUR_WAY_HANDSHAKE:
            case GROUP_HANDSHAKE:
            case COMPLETED:
                return true;
            case DISCONNECTED:
            case INTERFACE_DISABLED:
            case INACTIVE:
            case SCANNING:
            case DORMANT:
            case UNINITIALIZED:
            case INVALID:
                return false;
            default:
                throw new IllegalArgumentException("Unknown supplicant state");
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.325 -0500", hash_original_method = "4062759FD37A40F63149C525AA386A4D", hash_generated_method = "D0B414E15990914D92705A1FA24CB7F0")
        
static boolean isDriverActive(SupplicantState state) {
        switch(state) {
            case DISCONNECTED:
            case DORMANT:
            case INACTIVE:
            case AUTHENTICATING:
            case ASSOCIATING:
            case ASSOCIATED:
            case SCANNING:
            case FOUR_WAY_HANDSHAKE:
            case GROUP_HANDSHAKE:
            case COMPLETED:
                return true;
            case INTERFACE_DISABLED:
            case UNINITIALIZED:
            case INVALID:
                return false;
            default:
                throw new IllegalArgumentException("Unknown supplicant state");
        }
    }

    /** Implement the Parcelable interface {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.327 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
        return 0;
    }

    /** Implement the Parcelable interface {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.329 -0500", hash_original_method = "272133CA4250EC34CCFD7F34753D74AF", hash_generated_method = "AAE49704E72C06699CB09FD7CBA7E2BB")
        
public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name());
    }
    public static final Creator<SupplicantState> CREATOR =
        new Creator<SupplicantState>() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.332 -0500", hash_original_method = "AB789E2EA8C8DEE56C8B15C9CBCC7999", hash_generated_method = "5A76E63EE55157824634B36973DA6411")
            
public SupplicantState createFromParcel(Parcel in) {
                return SupplicantState.valueOf(in.readString());
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.335 -0500", hash_original_method = "A0DAB5F9E2DB7F2B7EF0D963DF6400D0", hash_generated_method = "7F59477D1008180E967EAA349062BFC2")
            
public SupplicantState[] newArray(int size) {
                return new SupplicantState[size];
            }
        };
}
