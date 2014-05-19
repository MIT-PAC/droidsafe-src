package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.EnumMap;

import android.os.Parcel;
import android.os.Parcelable;

public class NetworkInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.878 -0500", hash_original_field = "EACD41AB63A4037588D1A4AEABDB3BF8", hash_generated_field = "2F62E12883E62B29FD64F8F884A9218D")

    private static final EnumMap<DetailedState, State> stateMap =
        new EnumMap<DetailedState, State>(DetailedState.class);
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.412 -0400", hash_original_field = "4CAF625EAE81111F5604B0284353A2B1", hash_generated_field = "9C8FE6125F397F95C40575756C429932")

    public static final Creator<NetworkInfo> CREATOR =
        new Creator<NetworkInfo>() {
            @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.957 -0500", hash_original_method = "0B6AA9EC9A683520A8AF839D35CAC874", hash_generated_method = "B51726411CE650B90D80BB590E1E30AF")
        
public NetworkInfo createFromParcel(Parcel in) {
                int netType = in.readInt();
                int subtype = in.readInt();
                String typeName = in.readString();
                String subtypeName = in.readString();
                NetworkInfo netInfo = new NetworkInfo(netType, subtype, typeName, subtypeName);
                netInfo.mState = State.valueOf(in.readString());
                netInfo.mDetailedState = DetailedState.valueOf(in.readString());
                netInfo.mIsFailover = in.readInt() != 0;
                netInfo.mIsAvailable = in.readInt() != 0;
                netInfo.mIsRoaming = in.readInt() != 0;
                netInfo.mReason = in.readString();
                netInfo.mExtraInfo = in.readString();
                return netInfo;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.960 -0500", hash_original_method = "9A2EB2ACF1CC41952210E6F655C997AD", hash_generated_method = "1348AB3096C5E10931426184D5CCAE02")
        
public NetworkInfo[] newArray(int size) {
                return new NetworkInfo[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.880 -0500", hash_original_field = "DA9EFA3C01E2AE9028200C499AD621FC", hash_generated_field = "60BE94F590B2B55E7F16606AE64523A2")

    private int mNetworkType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.883 -0500", hash_original_field = "87044EEB61F52059EE0F0B5DBC4059CD", hash_generated_field = "298DC32990AD7D1E2E5F1AB561C62F4A")

    private int mSubtype;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.885 -0500", hash_original_field = "CB0D66DE5EBD007735DEC643F0667D66", hash_generated_field = "FB6356289394679804A962555AC4BF63")

    private String mTypeName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.887 -0500", hash_original_field = "7594C6B10BABCE6AC24D1E045C55700D", hash_generated_field = "C7263A00155379E7E78A982D8C2EFEF0")

    private String mSubtypeName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.888 -0500", hash_original_field = "0694514E375602E38DB31901C14A005D", hash_generated_field = "169FB36AA020AE19D2F764883C54F88A")

    private State mState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.890 -0500", hash_original_field = "B44DD8D2C4291C8B09AF1249B8E9DF18", hash_generated_field = "5D3769B046F00AA6EC620B80C5E89776")

    private DetailedState mDetailedState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.892 -0500", hash_original_field = "9E1DC384E07D434791BB93D42EBB3641", hash_generated_field = "39AA00EB7CB7F96F2E1FD2E750C189C0")

    private String mReason;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.894 -0500", hash_original_field = "B75CDF75557539EAA9AC86A766BA132C", hash_generated_field = "C6E1689A4C75399B973F7EB992CC83CB")

    private String mExtraInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.897 -0500", hash_original_field = "A0080CFF2083734DC1AA03C8A95198CE", hash_generated_field = "96403C157B820CF4FD7B8E52CFA57C58")

    private boolean mIsFailover;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.899 -0500", hash_original_field = "CBFF0E6ABCE37A71593B61FA36CDEF5B", hash_generated_field = "415253C847AEA7AA130149990C917780")

    private boolean mIsRoaming;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.901 -0500", hash_original_field = "818E509D1F61DDC8EA18E4C9F9D24B8C", hash_generated_field = "1E1A6AFD166B7DDFDBDBE32EDA8635C7")

    private boolean mIsAvailable;

    /**
     * @param type network type
     * @deprecated
     * @hide because this constructor was only meant for internal use (and
     * has now been superseded by the package-private constructor below).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.904 -0500", hash_original_method = "E0E0B5DCE71AAA01C628F35001B06F62", hash_generated_method = "EAE77BE532EDDF70C863124182A4BE4A")
    
public NetworkInfo(int type) {}

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.907 -0500", hash_original_method = "D80B4D4DAAC5235D04ECA009868EE265", hash_generated_method = "9154056635D86F1F12B38BECACC914C5")
    
public NetworkInfo(int type, int subtype, String typeName, String subtypeName) {
        if (!ConnectivityManager.isNetworkTypeValid(type)) {
            throw new IllegalArgumentException("Invalid network type: " + type);
        }
        mNetworkType = type;
        mSubtype = subtype;
        mTypeName = typeName;
        mSubtypeName = subtypeName;
        setDetailedState(DetailedState.IDLE, null, null);
        mState = State.UNKNOWN;
        mIsAvailable = false; // until we're told otherwise, assume unavailable
        mIsRoaming = false;
    }

    /** {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.909 -0500", hash_original_method = "5A3F7321AA4C57E32E1DFB9D40F8D226", hash_generated_method = "151F6EC40C3D1B5FD8600563DD5A6094")
    
public NetworkInfo(NetworkInfo source) {
        if (source != null) {
            mNetworkType = source.mNetworkType;
            mSubtype = source.mSubtype;
            mTypeName = source.mTypeName;
            mSubtypeName = source.mSubtypeName;
            mState = source.mState;
            mDetailedState = source.mDetailedState;
            mReason = source.mReason;
            mExtraInfo = source.mExtraInfo;
            mIsFailover = source.mIsFailover;
            mIsRoaming = source.mIsRoaming;
            mIsAvailable = source.mIsAvailable;
        }
    }

    /**
     * Reports the type of network (currently mobile or Wi-Fi) to which the
     * info in this object pertains.
     * @return the network type
     */
    @DSComment("Only getActiveNetworkInfo() is important")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.911 -0500", hash_original_method = "96E8498F657AF6E41693B86C8B8439F4", hash_generated_method = "12140614F0FA586F324EFC620CF61C60")
    
public int getType() {
        synchronized (this) {
            return mNetworkType;
        }
    }

    /**
     * Return a network-type-specific integer describing the subtype
     * of the network.
     * @return the network subtype
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.913 -0500", hash_original_method = "9F9664F87EC47D562C2DFD7EF2768060", hash_generated_method = "F7EDDADCEDAFB936492F75E6A9C474D6")
    
public int getSubtype() {
        synchronized (this) {
            return mSubtype;
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.915 -0500", hash_original_method = "0924F80CBAE8411743081929219BD54E", hash_generated_method = "0924F80CBAE8411743081929219BD54E")
    
void setSubtype(int subtype, String subtypeName) {
        synchronized (this) {
            mSubtype = subtype;
            mSubtypeName = subtypeName;
        }
    }

    /**
     * Return a human-readable name describe the type of the network,
     * for example "WIFI" or "MOBILE".
     * @return the name of the network type
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.917 -0500", hash_original_method = "55AF35A663CF7527013DF4B2AE75FC8F", hash_generated_method = "AC133991089D02159E3531697222933A")
    
public String getTypeName() {
        synchronized (this) {
            return mTypeName;
        }
    }

    /**
     * Return a human-readable name describing the subtype of the network.
     * @return the name of the network subtype
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.920 -0500", hash_original_method = "0043E0CF1F933E5EC5CD97392CA0E5B0", hash_generated_method = "F6F74B76F3FBAEECF2D7DD5FDACFDAC7")
    
public String getSubtypeName() {
        synchronized (this) {
            return mSubtypeName;
        }
    }

    /**
     * Indicates whether network connectivity exists or is in the process
     * of being established. This is good for applications that need to
     * do anything related to the network other than read or write data.
     * For the latter, call {@link #isConnected()} instead, which guarantees
     * that the network is fully usable.
     * @return {@code true} if network connectivity exists or is in the process
     * of being established, {@code false} otherwise.
     */
    @DSComment("Only getActiveNetworkInfo() is important")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.922 -0500", hash_original_method = "4340B79C926146F86A68CF1464A26E93", hash_generated_method = "2C9C2AC95481D3AC51881A7D7A326BC6")
    
public boolean isConnectedOrConnecting() {
        synchronized (this) {
            return mState == State.CONNECTED || mState == State.CONNECTING;
        }
    }

    /**
     * Indicates whether network connectivity exists and it is possible to establish
     * connections and pass data.
     * @return {@code true} if network connectivity exists, {@code false} otherwise.
     */
    @DSComment("Only getActiveNetworkInfo() is important")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.924 -0500", hash_original_method = "E81AE1BB2B0829AC31FE0D849F294E67", hash_generated_method = "8EECB83E305F4FE069A5F2CEC7520E99")
    
public boolean isConnected() {
        synchronized (this) {
            return mState == State.CONNECTED;
        }
    }

    /**
     * Indicates whether network connectivity is possible. A network is unavailable
     * when a persistent or semi-persistent condition prevents the possibility
     * of connecting to that network. Examples include
     * <ul>
     * <li>The device is out of the coverage area for any network of this type.</li>
     * <li>The device is on a network other than the home network (i.e., roaming), and
     * data roaming has been disabled.</li>
     * <li>The device's radio is turned off, e.g., because airplane mode is enabled.</li>
     * </ul>
     * @return {@code true} if the network is available, {@code false} otherwise
     */
    @DSComment("Only getActiveNetworkInfo() is important")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.926 -0500", hash_original_method = "4897D1CF0EA563D6DA8C578331010914", hash_generated_method = "79476FFD25CA18C7F81E6A8C7C8DCF12")
    
public boolean isAvailable() {
        synchronized (this) {
            return mIsAvailable;
        }
    }

    /**
     * Sets if the network is available, ie, if the connectivity is possible.
     * @param isAvailable the new availability value.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.928 -0500", hash_original_method = "939E32860F0B0F06BDBD0E17663153C9", hash_generated_method = "3853FF40AB0CDEE35B7A2D6FC18940F6")
    
public void setIsAvailable(boolean isAvailable) {
        synchronized (this) {
            mIsAvailable = isAvailable;
        }
    }

    /**
     * Indicates whether the current attempt to connect to the network
     * resulted from the ConnectivityManager trying to fail over to this
     * network following a disconnect from another network.
     * @return {@code true} if this is a failover attempt, {@code false}
     * otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.930 -0500", hash_original_method = "9C5319745C341BE120FE9E801220DA42", hash_generated_method = "994301D6487D5333EF062580A7A1ACF0")
    
public boolean isFailover() {
        synchronized (this) {
            return mIsFailover;
        }
    }

    /**
     * Set the failover boolean.
     * @param isFailover {@code true} to mark the current connection attempt
     * as a failover.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.932 -0500", hash_original_method = "F833C30ECD57DCF99CA2522188FA2C07", hash_generated_method = "83CAE6793C0FBEA648F70A6D584626E3")
    
public void setFailover(boolean isFailover) {
        synchronized (this) {
            mIsFailover = isFailover;
        }
    }

    /**
     * Indicates whether the device is currently roaming on this network.
     * When {@code true}, it suggests that use of data on this network
     * may incur extra costs.
     * @return {@code true} if roaming is in effect, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.934 -0500", hash_original_method = "AB8A93C3EDB3BBC79E3580DBDAC7F9AC", hash_generated_method = "CB7CF90420E6503B59619E05264570CD")
    
public boolean isRoaming() {
        synchronized (this) {
            return mIsRoaming;
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.936 -0500", hash_original_method = "B7D7748403F63EB4650DEC0BB363124A", hash_generated_method = "B7D7748403F63EB4650DEC0BB363124A")
    
void setRoaming(boolean isRoaming) {
        synchronized (this) {
            mIsRoaming = isRoaming;
        }
    }

    /**
     * Reports the current coarse-grained state of the network.
     * @return the coarse-grained state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.938 -0500", hash_original_method = "7B78C01516FA6C80A9332B33D7F2C1E4", hash_generated_method = "472E9E698CFA6CC178C52E6705DF06A2")
    
public State getState() {
        synchronized (this) {
            return mState;
        }
    }

    /**
     * Reports the current fine-grained state of the network.
     * @return the fine-grained state
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSSpec(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.940 -0500", hash_original_method = "EF299E7A8E902EE5662452C8EC565B0C", hash_generated_method = "061FCDC7F5E040ECCA6F4ED8FF0403D3")
    
public DetailedState getDetailedState() {
        synchronized (this) {
            return mDetailedState;
        }
    }

    /**
     * Sets the fine-grained state of the network.
     * @param detailedState the {@link DetailedState}.
     * @param reason a {@code String} indicating the reason for the state change,
     * if one was supplied. May be {@code null}.
     * @param extraInfo an optional {@code String} providing addditional network state
     * information passed up from the lower networking layers.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.943 -0500", hash_original_method = "F9B4E8192C3BAB2B942149B3B4357918", hash_generated_method = "6E1F1256CC0908BC6BAD7EADBFEB2A62")
    
public void setDetailedState(DetailedState detailedState, String reason, String extraInfo) {
        synchronized (this) {
            this.mDetailedState = detailedState;
            this.mState = stateMap.get(detailedState);
            this.mReason = reason;
            this.mExtraInfo = extraInfo;
        }
    }

    /**
     * Report the reason an attempt to establish connectivity failed,
     * if one is available.
     * @return the reason for failure, or null if not available
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.945 -0500", hash_original_method = "788F68C9DAC18237AEDF0C4BED188B0D", hash_generated_method = "B6A9CC282648BE1583E2C5365A01C4FF")
    
public String getReason() {
        synchronized (this) {
            return mReason;
        }
    }

    /**
     * Report the extra information about the network state, if any was
     * provided by the lower networking layers.,
     * if one is available.
     * @return the extra information, or null if not available
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.947 -0500", hash_original_method = "74D0311B373A7BB37462D7229B3CD3F9", hash_generated_method = "9CB31D64DF097D60A610ACE07788F4CD")
    
public String getExtraInfo() {
        synchronized (this) {
            return mExtraInfo;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.949 -0500", hash_original_method = "AD77F99801D246295506D70C39DE289C", hash_generated_method = "3EFFCE1A061D40DC507257F509A32317")
    
@Override
    public String toString() {
        synchronized (this) {
            StringBuilder builder = new StringBuilder("NetworkInfo: ");
            builder.append("type: ").append(getTypeName()).append("[").append(getSubtypeName()).
            append("], state: ").append(mState).append("/").append(mDetailedState).
            append(", reason: ").append(mReason == null ? "(unspecified)" : mReason).
            append(", extra: ").append(mExtraInfo == null ? "(none)" : mExtraInfo).
            append(", roaming: ").append(mIsRoaming).
            append(", failover: ").append(mIsFailover).
            append(", isAvailable: ").append(mIsAvailable);
            return builder.toString();
        }
    }
    
    public enum State {
        CONNECTING, CONNECTED, SUSPENDED, DISCONNECTING, DISCONNECTED, UNKNOWN
    }
    
    public enum DetailedState {
        IDLE,
        SCANNING,
        CONNECTING,
        AUTHENTICATING,
        OBTAINING_IPADDR,
        CONNECTED,
        SUSPENDED,
        DISCONNECTING,
        DISCONNECTED,
        FAILED,
        BLOCKED
    }

    /**
     * Implement the Parcelable interface
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.951 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
    static {
        stateMap.put(DetailedState.IDLE, State.DISCONNECTED);
        stateMap.put(DetailedState.SCANNING, State.DISCONNECTED);
        stateMap.put(DetailedState.CONNECTING, State.CONNECTING);
        stateMap.put(DetailedState.AUTHENTICATING, State.CONNECTING);
        stateMap.put(DetailedState.OBTAINING_IPADDR, State.CONNECTING);
        stateMap.put(DetailedState.CONNECTED, State.CONNECTED);
        stateMap.put(DetailedState.SUSPENDED, State.SUSPENDED);
        stateMap.put(DetailedState.DISCONNECTING, State.DISCONNECTING);
        stateMap.put(DetailedState.DISCONNECTED, State.DISCONNECTED);
        stateMap.put(DetailedState.FAILED, State.DISCONNECTED);
        stateMap.put(DetailedState.BLOCKED, State.DISCONNECTED);
    }

    /**
     * Implement the Parcelable interface.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.954 -0500", hash_original_method = "EF9852F5CC5A1C9C509E333ACBA9ED14", hash_generated_method = "27F929FE8F722F8C0BED645C5C745CAE")
    
public void writeToParcel(Parcel dest, int flags) {
        synchronized (this) {
            dest.writeInt(mNetworkType);
            dest.writeInt(mSubtype);
            dest.writeString(mTypeName);
            dest.writeString(mSubtypeName);
            dest.writeString(mState.name());
            dest.writeString(mDetailedState.name());
            dest.writeInt(mIsFailover ? 1 : 0);
            dest.writeInt(mIsAvailable ? 1 : 0);
            dest.writeInt(mIsRoaming ? 1 : 0);
            dest.writeString(mReason);
            dest.writeString(mExtraInfo);
        }
    }
}

