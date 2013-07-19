package android.net.wifi;

// Droidsafe Imports
import android.os.Parcel;
import android.os.Parcelable;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

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
    @DSModeled(DSC.SAFE)
    public static boolean isValidState(SupplicantState state) {
        return state != UNINITIALIZED && state != INVALID;
    }
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
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return 0;
    }
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name());
    }
    public static final Creator<SupplicantState> CREATOR =
        new Creator<SupplicantState>() {
            public SupplicantState createFromParcel(Parcel in) {
                return SupplicantState.valueOf(in.readString());
            }
            public SupplicantState[] newArray(int size) {
                return new SupplicantState[size];
            }
        };
}
