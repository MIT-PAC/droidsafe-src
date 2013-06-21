package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcelable;
import android.os.Parcel;
import java.util.EnumMap;

public class NetworkInfo implements Parcelable {
    private int mNetworkType;
    private int mSubtype;
    private String mTypeName;
    private String mSubtypeName;
    private State mState;
    private DetailedState mDetailedState;
    private String mReason;
    private String mExtraInfo;
    private boolean mIsFailover;
    private boolean mIsRoaming;
    private boolean mIsAvailable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.075 -0400", hash_original_method = "E0E0B5DCE71AAA01C628F35001B06F62", hash_generated_method = "7D0C4C7DEC9D3A7A75269617932083A9")
    @DSModeled(DSC.SAFE)
    public NetworkInfo(int type) {
        dsTaint.addTaint(type);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.076 -0400", hash_original_method = "D80B4D4DAAC5235D04ECA009868EE265", hash_generated_method = "5D2CA9C9FE09A139E2897A2E1CC23D0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkInfo(int type, int subtype, String typeName, String subtypeName) {
        dsTaint.addTaint(typeName);
        dsTaint.addTaint(subtype);
        dsTaint.addTaint(subtypeName);
        dsTaint.addTaint(type);
        {
            boolean var0BB46F15A21E680BDCAF3097C1FB24EA_22322978 = (!ConnectivityManager.isNetworkTypeValid(type));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid network type: " + type);
            } //End block
        } //End collapsed parenthetic
        setDetailedState(DetailedState.IDLE, null, null);
        mState = State.UNKNOWN;
        mIsAvailable = false;
        mIsRoaming = false;
        // ---------- Original Method ----------
        //if (!ConnectivityManager.isNetworkTypeValid(type)) {
            //throw new IllegalArgumentException("Invalid network type: " + type);
        //}
        //mNetworkType = type;
        //mSubtype = subtype;
        //mTypeName = typeName;
        //mSubtypeName = subtypeName;
        //setDetailedState(DetailedState.IDLE, null, null);
        //mState = State.UNKNOWN;
        //mIsAvailable = false;
        //mIsRoaming = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.076 -0400", hash_original_method = "5A3F7321AA4C57E32E1DFB9D40F8D226", hash_generated_method = "225188A2289DDCF3C09959C7D14EB15F")
    @DSModeled(DSC.SAFE)
    public NetworkInfo(NetworkInfo source) {
        dsTaint.addTaint(source.dsTaint);
        {
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
        } //End block
        // ---------- Original Method ----------
        //if (source != null) {
            //mNetworkType = source.mNetworkType;
            //mSubtype = source.mSubtype;
            //mTypeName = source.mTypeName;
            //mSubtypeName = source.mSubtypeName;
            //mState = source.mState;
            //mDetailedState = source.mDetailedState;
            //mReason = source.mReason;
            //mExtraInfo = source.mExtraInfo;
            //mIsFailover = source.mIsFailover;
            //mIsRoaming = source.mIsRoaming;
            //mIsAvailable = source.mIsAvailable;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.076 -0400", hash_original_method = "96E8498F657AF6E41693B86C8B8439F4", hash_generated_method = "FA1C70C931326BECA6F9A2F4F3EAADFD")
    @DSModeled(DSC.SAFE)
    public int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mNetworkType;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.077 -0400", hash_original_method = "9F9664F87EC47D562C2DFD7EF2768060", hash_generated_method = "E1FC7064E7FAE261F14FB7E3835F8DBF")
    @DSModeled(DSC.SAFE)
    public int getSubtype() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mSubtype;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.077 -0400", hash_original_method = "0924F80CBAE8411743081929219BD54E", hash_generated_method = "90C43ABD7F44486E5B28E9AE1F065293")
    @DSModeled(DSC.SAFE)
     void setSubtype(int subtype, String subtypeName) {
        dsTaint.addTaint(subtype);
        dsTaint.addTaint(subtypeName);
        // ---------- Original Method ----------
        //synchronized (this) {
            //mSubtype = subtype;
            //mSubtypeName = subtypeName;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.077 -0400", hash_original_method = "55AF35A663CF7527013DF4B2AE75FC8F", hash_generated_method = "2BE44DDBC7CAEB60F3415C6FE1722FFC")
    @DSModeled(DSC.SAFE)
    public String getTypeName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mTypeName;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.078 -0400", hash_original_method = "0043E0CF1F933E5EC5CD97392CA0E5B0", hash_generated_method = "DB856F36C410EA831830AD78C9A96E51")
    @DSModeled(DSC.SAFE)
    public String getSubtypeName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mSubtypeName;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.078 -0400", hash_original_method = "4340B79C926146F86A68CF1464A26E93", hash_generated_method = "8BE447FC645F5ECAE6DBE25337E5E9C1")
    @DSModeled(DSC.SAFE)
    public boolean isConnectedOrConnecting() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mState == State.CONNECTED || mState == State.CONNECTING;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.078 -0400", hash_original_method = "E81AE1BB2B0829AC31FE0D849F294E67", hash_generated_method = "748CBD532E195256D088A2B5B00B8D5F")
    @DSModeled(DSC.SAFE)
    public boolean isConnected() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mState == State.CONNECTED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.078 -0400", hash_original_method = "4897D1CF0EA563D6DA8C578331010914", hash_generated_method = "7B3F882D841EA4F1E8F3AE3F12A4C137")
    @DSModeled(DSC.SAFE)
    public boolean isAvailable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mIsAvailable;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.079 -0400", hash_original_method = "939E32860F0B0F06BDBD0E17663153C9", hash_generated_method = "C4BDAA63FB603BE512F69D7933079F78")
    @DSModeled(DSC.SAFE)
    public void setIsAvailable(boolean isAvailable) {
        dsTaint.addTaint(isAvailable);
        // ---------- Original Method ----------
        //synchronized (this) {
            //mIsAvailable = isAvailable;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.079 -0400", hash_original_method = "9C5319745C341BE120FE9E801220DA42", hash_generated_method = "2F757CEE9089B42C7692B2A4CE8F876A")
    @DSModeled(DSC.SAFE)
    public boolean isFailover() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mIsFailover;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.079 -0400", hash_original_method = "F833C30ECD57DCF99CA2522188FA2C07", hash_generated_method = "D7B3C50EF8D6A25507253DBF83C22509")
    @DSModeled(DSC.SAFE)
    public void setFailover(boolean isFailover) {
        dsTaint.addTaint(isFailover);
        // ---------- Original Method ----------
        //synchronized (this) {
            //mIsFailover = isFailover;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.079 -0400", hash_original_method = "AB8A93C3EDB3BBC79E3580DBDAC7F9AC", hash_generated_method = "6EC03BD3A726B8CED89407CB17FE494B")
    @DSModeled(DSC.SAFE)
    public boolean isRoaming() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mIsRoaming;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.080 -0400", hash_original_method = "B7D7748403F63EB4650DEC0BB363124A", hash_generated_method = "62985A981A6AE3A30221040248EEF4AB")
    @DSModeled(DSC.SAFE)
     void setRoaming(boolean isRoaming) {
        dsTaint.addTaint(isRoaming);
        // ---------- Original Method ----------
        //synchronized (this) {
            //mIsRoaming = isRoaming;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.080 -0400", hash_original_method = "7B78C01516FA6C80A9332B33D7F2C1E4", hash_generated_method = "3A805A0B89D0ED22A712C5D74A2BAE74")
    @DSModeled(DSC.SAFE)
    public State getState() {
        return (State)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mState;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.080 -0400", hash_original_method = "EF299E7A8E902EE5662452C8EC565B0C", hash_generated_method = "AA45E5B1DCB90D57A6879E7412FC7AD2")
    @DSModeled(DSC.SAFE)
    public DetailedState getDetailedState() {
        return (DetailedState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mDetailedState;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.080 -0400", hash_original_method = "F9B4E8192C3BAB2B942149B3B4357918", hash_generated_method = "DF1B1BBC129D71F12F9490160C0CE58A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDetailedState(DetailedState detailedState, String reason, String extraInfo) {
        dsTaint.addTaint(detailedState.dsTaint);
        dsTaint.addTaint(reason);
        dsTaint.addTaint(extraInfo);
        {
            this.mState = stateMap.get(detailedState);
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //this.mDetailedState = detailedState;
            //this.mState = stateMap.get(detailedState);
            //this.mReason = reason;
            //this.mExtraInfo = extraInfo;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.081 -0400", hash_original_method = "788F68C9DAC18237AEDF0C4BED188B0D", hash_generated_method = "3B6AA06137FA60DE41C70563021C6CE4")
    @DSModeled(DSC.SAFE)
    public String getReason() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mReason;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.081 -0400", hash_original_method = "74D0311B373A7BB37462D7229B3CD3F9", hash_generated_method = "AF91553741AF91F23E4351B1F38C9FB5")
    @DSModeled(DSC.SAFE)
    public String getExtraInfo() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mExtraInfo;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.082 -0400", hash_original_method = "AD77F99801D246295506D70C39DE289C", hash_generated_method = "4263082D122B4119F88AFEAD847D4FE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        {
            StringBuilder builder;
            builder = new StringBuilder("NetworkInfo: ");
            builder.append("type: ").append(getTypeName()).append("[").append(getSubtypeName()).
            append("], state: ").append(mState).append("/").append(mDetailedState).
            append(", reason: ").append(mReason == null ? "(unspecified)" : mReason).
            append(", extra: ").append(mExtraInfo == null ? "(none)" : mExtraInfo).
            append(", roaming: ").append(mIsRoaming).
            append(", failover: ").append(mIsFailover).
            append(", isAvailable: ").append(mIsAvailable);
            String varCEB98099F8B5AF9267E3A4873F9FB1DE_1164080598 = (builder.toString());
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //synchronized (this) {
            //StringBuilder builder = new StringBuilder("NetworkInfo: ");
            //builder.append("type: ").append(getTypeName()).append("[").append(getSubtypeName()).
            //append("], state: ").append(mState).append("/").append(mDetailedState).
            //append(", reason: ").append(mReason == null ? "(unspecified)" : mReason).
            //append(", extra: ").append(mExtraInfo == null ? "(none)" : mExtraInfo).
            //append(", roaming: ").append(mIsRoaming).
            //append(", failover: ").append(mIsFailover).
            //append(", isAvailable: ").append(mIsAvailable);
            //return builder.toString();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.082 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.083 -0400", hash_original_method = "EF9852F5CC5A1C9C509E333ACBA9ED14", hash_generated_method = "1E02196B7A839EBF61DF1601B33F9458")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        {
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
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //dest.writeInt(mNetworkType);
            //dest.writeInt(mSubtype);
            //dest.writeString(mTypeName);
            //dest.writeString(mSubtypeName);
            //dest.writeString(mState.name());
            //dest.writeString(mDetailedState.name());
            //dest.writeInt(mIsFailover ? 1 : 0);
            //dest.writeInt(mIsAvailable ? 1 : 0);
            //dest.writeInt(mIsRoaming ? 1 : 0);
            //dest.writeString(mReason);
            //dest.writeString(mExtraInfo);
        //}
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

    
    private static final EnumMap<DetailedState, State> stateMap =
        new EnumMap<DetailedState, State>(DetailedState.class);
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
    
    public static final Creator<NetworkInfo> CREATOR = new Creator<NetworkInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.083 -0400", hash_original_method = "0B6AA9EC9A683520A8AF839D35CAC874", hash_generated_method = "F9AEE8CC8B67AF2F383DE10694DDF17B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NetworkInfo createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            int netType;
            netType = in.readInt();
            int subtype;
            subtype = in.readInt();
            String typeName;
            typeName = in.readString();
            String subtypeName;
            subtypeName = in.readString();
            NetworkInfo netInfo;
            netInfo = new NetworkInfo(netType, subtype, typeName, subtypeName);
            netInfo.mState = State.valueOf(in.readString());
            netInfo.mDetailedState = DetailedState.valueOf(in.readString());
            netInfo.mIsFailover = in.readInt() != 0;
            netInfo.mIsAvailable = in.readInt() != 0;
            netInfo.mIsRoaming = in.readInt() != 0;
            netInfo.mReason = in.readString();
            netInfo.mExtraInfo = in.readString();
            return (NetworkInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //int netType = in.readInt();
            //int subtype = in.readInt();
            //String typeName = in.readString();
            //String subtypeName = in.readString();
            //NetworkInfo netInfo = new NetworkInfo(netType, subtype, typeName, subtypeName);
            //netInfo.mState = State.valueOf(in.readString());
            //netInfo.mDetailedState = DetailedState.valueOf(in.readString());
            //netInfo.mIsFailover = in.readInt() != 0;
            //netInfo.mIsAvailable = in.readInt() != 0;
            //netInfo.mIsRoaming = in.readInt() != 0;
            //netInfo.mReason = in.readString();
            //netInfo.mExtraInfo = in.readString();
            //return netInfo;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.084 -0400", hash_original_method = "9A2EB2ACF1CC41952210E6F655C997AD", hash_generated_method = "80C4B91527088A81758519EF2BDAC0E3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NetworkInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            NetworkInfo[] var391111D5042366A977E1C5D6DE4BC662_1429786805 = (new NetworkInfo[size]);
            return (NetworkInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NetworkInfo[size];
        }

        
}; //Transformed anonymous class
}

