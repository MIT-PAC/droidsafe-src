package android.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcelable;
import android.os.Parcel;
import java.util.EnumMap;

public class NetworkInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.350 -0400", hash_original_field = "9761905E68D80D41E55047BFA13A52C2", hash_generated_field = "60BE94F590B2B55E7F16606AE64523A2")

    private int mNetworkType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.350 -0400", hash_original_field = "3E33CBB2BE8C82106CDB44B0EFDD93E0", hash_generated_field = "298DC32990AD7D1E2E5F1AB561C62F4A")

    private int mSubtype;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.350 -0400", hash_original_field = "CE4901BF2E25E3548E50E5819FEF91BA", hash_generated_field = "FB6356289394679804A962555AC4BF63")

    private String mTypeName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.350 -0400", hash_original_field = "BE463DB514BCF1747F76DECDC515D7A7", hash_generated_field = "C7263A00155379E7E78A982D8C2EFEF0")

    private String mSubtypeName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.350 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "169FB36AA020AE19D2F764883C54F88A")

    private State mState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.350 -0400", hash_original_field = "7AA188D94D7AB9DFB39067D3C50A37F7", hash_generated_field = "5D3769B046F00AA6EC620B80C5E89776")

    private DetailedState mDetailedState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.350 -0400", hash_original_field = "D37183730F43F82EAD5FD0BEC18C215E", hash_generated_field = "39AA00EB7CB7F96F2E1FD2E750C189C0")

    private String mReason;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.350 -0400", hash_original_field = "AB5938C15B75B0ACE1172055173084EA", hash_generated_field = "C6E1689A4C75399B973F7EB992CC83CB")

    private String mExtraInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.350 -0400", hash_original_field = "67C0330E7720D27F15F181055D5B6CE3", hash_generated_field = "96403C157B820CF4FD7B8E52CFA57C58")

    private boolean mIsFailover;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.350 -0400", hash_original_field = "3DD278D5834239FCC85223B1B62442BF", hash_generated_field = "415253C847AEA7AA130149990C917780")

    private boolean mIsRoaming;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.350 -0400", hash_original_field = "6887DF0A12AC03D170DEA4FF85865F1A", hash_generated_field = "1E1A6AFD166B7DDFDBDBE32EDA8635C7")

    private boolean mIsAvailable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.350 -0400", hash_original_method = "E0E0B5DCE71AAA01C628F35001B06F62", hash_generated_method = "EFE69ABEC541A13B58B9BCC4C8E2BBA7")
    public  NetworkInfo(int type) {
        addTaint(type);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.351 -0400", hash_original_method = "D80B4D4DAAC5235D04ECA009868EE265", hash_generated_method = "3962861E781BE553773451C3D129C8F9")
    public  NetworkInfo(int type, int subtype, String typeName, String subtypeName) {
        {
            boolean var0BB46F15A21E680BDCAF3097C1FB24EA_989150573 = (!ConnectivityManager.isNetworkTypeValid(type));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid network type: " + type);
            } 
        } 
        mNetworkType = type;
        mSubtype = subtype;
        mTypeName = typeName;
        mSubtypeName = subtypeName;
        setDetailedState(DetailedState.IDLE, null, null);
        mState = State.UNKNOWN;
        mIsAvailable = false;
        mIsRoaming = false;
        
        
            
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.351 -0400", hash_original_method = "5A3F7321AA4C57E32E1DFB9D40F8D226", hash_generated_method = "FEDEE894BB4870AB0B84DE6890191D9C")
    public  NetworkInfo(NetworkInfo source) {
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
        } 
        
        
            
            
            
            
            
            
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.352 -0400", hash_original_method = "96E8498F657AF6E41693B86C8B8439F4", hash_generated_method = "B59277A93746915F19BD5AE2C06DB836")
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_798055560 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_798055560;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.352 -0400", hash_original_method = "9F9664F87EC47D562C2DFD7EF2768060", hash_generated_method = "4FE2202ABA0AFDADB1A44ADC3C146275")
    public int getSubtype() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_964887049 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_964887049;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.353 -0400", hash_original_method = "0924F80CBAE8411743081929219BD54E", hash_generated_method = "5203D71A0D99A82039A74CFC0CF88141")
     void setSubtype(int subtype, String subtypeName) {
        {
            mSubtype = subtype;
            mSubtypeName = subtypeName;
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.354 -0400", hash_original_method = "55AF35A663CF7527013DF4B2AE75FC8F", hash_generated_method = "82A016D5D3B9197A1C6102FA5820ACA4")
    public String getTypeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1801395146 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1801395146 = mTypeName;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1801395146.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1801395146;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.354 -0400", hash_original_method = "0043E0CF1F933E5EC5CD97392CA0E5B0", hash_generated_method = "7AFD6116B7F1D6C7EABB99EDD55F2124")
    public String getSubtypeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1695367020 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1695367020 = mSubtypeName;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1695367020.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1695367020;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.355 -0400", hash_original_method = "4340B79C926146F86A68CF1464A26E93", hash_generated_method = "7B41B7093CF6B70231C127DE8F1A5971")
    public boolean isConnectedOrConnecting() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_216703921 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_216703921;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.355 -0400", hash_original_method = "E81AE1BB2B0829AC31FE0D849F294E67", hash_generated_method = "685E011ECBDE4F86A343EF317C2603EE")
    public boolean isConnected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_966001725 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_966001725;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.355 -0400", hash_original_method = "4897D1CF0EA563D6DA8C578331010914", hash_generated_method = "97407093BBAF39BDA81EAAEA294DD78D")
    public boolean isAvailable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_377073798 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_377073798;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.356 -0400", hash_original_method = "939E32860F0B0F06BDBD0E17663153C9", hash_generated_method = "494943E9448F6678D72678AF576E9179")
    public void setIsAvailable(boolean isAvailable) {
        {
            mIsAvailable = isAvailable;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.356 -0400", hash_original_method = "9C5319745C341BE120FE9E801220DA42", hash_generated_method = "F7FB9681DD432C0D17B3FE74B4ED951F")
    public boolean isFailover() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1304703438 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1304703438;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.356 -0400", hash_original_method = "F833C30ECD57DCF99CA2522188FA2C07", hash_generated_method = "3FB3BFCF0243C5AE1A93B4F46BBEFDC5")
    public void setFailover(boolean isFailover) {
        {
            mIsFailover = isFailover;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.357 -0400", hash_original_method = "AB8A93C3EDB3BBC79E3580DBDAC7F9AC", hash_generated_method = "2949C5D1E7010E2CF0EB2AE0FC9F5DAD")
    public boolean isRoaming() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1342407499 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1342407499;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.357 -0400", hash_original_method = "B7D7748403F63EB4650DEC0BB363124A", hash_generated_method = "5CDC213386E9363800D608AEB0FB16F2")
     void setRoaming(boolean isRoaming) {
        {
            mIsRoaming = isRoaming;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.357 -0400", hash_original_method = "7B78C01516FA6C80A9332B33D7F2C1E4", hash_generated_method = "75DC47A0CDB8AE11B151D4526B7952C5")
    public State getState() {
        State varB4EAC82CA7396A68D541C85D26508E83_662919798 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_662919798 = mState;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_662919798.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_662919798;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.358 -0400", hash_original_method = "EF299E7A8E902EE5662452C8EC565B0C", hash_generated_method = "1378C873F2B99A3460C0D75289EF2674")
    public DetailedState getDetailedState() {
        DetailedState varB4EAC82CA7396A68D541C85D26508E83_1032356930 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1032356930 = mDetailedState;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1032356930.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1032356930;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.358 -0400", hash_original_method = "F9B4E8192C3BAB2B942149B3B4357918", hash_generated_method = "E71EAA3D48085C0A311AA5180CC511DE")
    public void setDetailedState(DetailedState detailedState, String reason, String extraInfo) {
        {
            this.mDetailedState = detailedState;
            this.mState = stateMap.get(detailedState);
            this.mReason = reason;
            this.mExtraInfo = extraInfo;
        } 
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.359 -0400", hash_original_method = "788F68C9DAC18237AEDF0C4BED188B0D", hash_generated_method = "57377A49E709B1D7CFC86B973C0174BC")
    public String getReason() {
        String varB4EAC82CA7396A68D541C85D26508E83_1085741263 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1085741263 = mReason;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1085741263.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1085741263;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.359 -0400", hash_original_method = "74D0311B373A7BB37462D7229B3CD3F9", hash_generated_method = "FBE99A68E084D98B5E99207897A0489D")
    public String getExtraInfo() {
        String varB4EAC82CA7396A68D541C85D26508E83_1848151765 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1848151765 = mExtraInfo;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1848151765.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1848151765;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.360 -0400", hash_original_method = "AD77F99801D246295506D70C39DE289C", hash_generated_method = "933E088F1D18C708C7524651C27DC778")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2092390328 = null; 
        {
            StringBuilder builder = new StringBuilder("NetworkInfo: ");
            builder.append("type: ").append(getTypeName()).append("[").append(getSubtypeName()).
            append("], state: ").append(mState).append("/").append(mDetailedState).
            append(", reason: ").append(mReason == null ? "(unspecified)" : mReason).
            append(", extra: ").append(mExtraInfo == null ? "(none)" : mExtraInfo).
            append(", roaming: ").append(mIsRoaming).
            append(", failover: ").append(mIsFailover).
            append(", isAvailable: ").append(mIsAvailable);
            varB4EAC82CA7396A68D541C85D26508E83_2092390328 = builder.toString();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2092390328.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2092390328;
        
        
            
            
            
            
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.361 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "B50739380297DF34E75D4BD231E9B642")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_518789885 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_518789885;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.362 -0400", hash_original_method = "EF9852F5CC5A1C9C509E333ACBA9ED14", hash_generated_method = "A4D8A7352ED2C7B64B074447678BE1FC")
    public void writeToParcel(Parcel dest, int flags) {
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
        } 
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
            
            
            
            
            
            
            
            
            
            
            
        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.362 -0400", hash_original_field = "BC9C17C6DAFAAB8182342F0EAA1A83D8", hash_generated_field = "2F62E12883E62B29FD64F8F884A9218D")

    private static final EnumMap<DetailedState, State> stateMap = new EnumMap<DetailedState, State>(DetailedState.class);
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.362 -0400", hash_original_field = "4CAF625EAE81111F5604B0284353A2B1", hash_generated_field = "9C8FE6125F397F95C40575756C429932")

    public static final Creator<NetworkInfo> CREATOR =
        new Creator<NetworkInfo>() {
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

            public NetworkInfo[] newArray(int size) {
                return new NetworkInfo[size];
            }
        };
}

