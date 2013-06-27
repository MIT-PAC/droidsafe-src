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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.551 -0400", hash_original_field = "9761905E68D80D41E55047BFA13A52C2", hash_generated_field = "60BE94F590B2B55E7F16606AE64523A2")

    private int mNetworkType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.552 -0400", hash_original_field = "3E33CBB2BE8C82106CDB44B0EFDD93E0", hash_generated_field = "298DC32990AD7D1E2E5F1AB561C62F4A")

    private int mSubtype;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.552 -0400", hash_original_field = "CE4901BF2E25E3548E50E5819FEF91BA", hash_generated_field = "FB6356289394679804A962555AC4BF63")

    private String mTypeName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.552 -0400", hash_original_field = "BE463DB514BCF1747F76DECDC515D7A7", hash_generated_field = "C7263A00155379E7E78A982D8C2EFEF0")

    private String mSubtypeName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.552 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "169FB36AA020AE19D2F764883C54F88A")

    private State mState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.552 -0400", hash_original_field = "7AA188D94D7AB9DFB39067D3C50A37F7", hash_generated_field = "5D3769B046F00AA6EC620B80C5E89776")

    private DetailedState mDetailedState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.552 -0400", hash_original_field = "D37183730F43F82EAD5FD0BEC18C215E", hash_generated_field = "39AA00EB7CB7F96F2E1FD2E750C189C0")

    private String mReason;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.552 -0400", hash_original_field = "AB5938C15B75B0ACE1172055173084EA", hash_generated_field = "C6E1689A4C75399B973F7EB992CC83CB")

    private String mExtraInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.552 -0400", hash_original_field = "67C0330E7720D27F15F181055D5B6CE3", hash_generated_field = "96403C157B820CF4FD7B8E52CFA57C58")

    private boolean mIsFailover;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.552 -0400", hash_original_field = "3DD278D5834239FCC85223B1B62442BF", hash_generated_field = "415253C847AEA7AA130149990C917780")

    private boolean mIsRoaming;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.558 -0400", hash_original_field = "6887DF0A12AC03D170DEA4FF85865F1A", hash_generated_field = "1E1A6AFD166B7DDFDBDBE32EDA8635C7")

    private boolean mIsAvailable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.558 -0400", hash_original_method = "E0E0B5DCE71AAA01C628F35001B06F62", hash_generated_method = "EFE69ABEC541A13B58B9BCC4C8E2BBA7")
    public  NetworkInfo(int type) {
        addTaint(type);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.560 -0400", hash_original_method = "D80B4D4DAAC5235D04ECA009868EE265", hash_generated_method = "A90766CB4F08B63FDD41854BB12462DF")
    public  NetworkInfo(int type, int subtype, String typeName, String subtypeName) {
        {
            boolean var0BB46F15A21E680BDCAF3097C1FB24EA_1273321944 = (!ConnectivityManager.isNetworkTypeValid(type));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid network type: " + type);
            } //End block
        } //End collapsed parenthetic
        mNetworkType = type;
        mSubtype = subtype;
        mTypeName = typeName;
        mSubtypeName = subtypeName;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.598 -0400", hash_original_method = "5A3F7321AA4C57E32E1DFB9D40F8D226", hash_generated_method = "FEDEE894BB4870AB0B84DE6890191D9C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.598 -0400", hash_original_method = "96E8498F657AF6E41693B86C8B8439F4", hash_generated_method = "2158B5E4898828F0E38CF41F7767E70A")
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1331962861 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1331962861;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mNetworkType;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.599 -0400", hash_original_method = "9F9664F87EC47D562C2DFD7EF2768060", hash_generated_method = "6ED7587FBAC5C740FF58663ADE9A594E")
    public int getSubtype() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897122944 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897122944;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mSubtype;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.599 -0400", hash_original_method = "0924F80CBAE8411743081929219BD54E", hash_generated_method = "5203D71A0D99A82039A74CFC0CF88141")
     void setSubtype(int subtype, String subtypeName) {
        {
            mSubtype = subtype;
            mSubtypeName = subtypeName;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //mSubtype = subtype;
            //mSubtypeName = subtypeName;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.600 -0400", hash_original_method = "55AF35A663CF7527013DF4B2AE75FC8F", hash_generated_method = "F9F62BF6F4BCDC2A49673EFD55EEB5A8")
    public String getTypeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1422375862 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1422375862 = mTypeName;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1422375862.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1422375862;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mTypeName;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.607 -0400", hash_original_method = "0043E0CF1F933E5EC5CD97392CA0E5B0", hash_generated_method = "C52715DE40BB98906EED81C680629CB0")
    public String getSubtypeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_346090829 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_346090829 = mSubtypeName;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_346090829.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_346090829;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mSubtypeName;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.614 -0400", hash_original_method = "4340B79C926146F86A68CF1464A26E93", hash_generated_method = "B36F5D062D3B3FD105566304467E5E7F")
    public boolean isConnectedOrConnecting() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1586172957 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1586172957;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mState == State.CONNECTED || mState == State.CONNECTING;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.614 -0400", hash_original_method = "E81AE1BB2B0829AC31FE0D849F294E67", hash_generated_method = "8D6DBAE1F625E6CA7C4D7C5700BAE20A")
    public boolean isConnected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1092737332 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1092737332;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mState == State.CONNECTED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.615 -0400", hash_original_method = "4897D1CF0EA563D6DA8C578331010914", hash_generated_method = "F1C7DDD6D0B4675EF3574DAC8D088782")
    public boolean isAvailable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_575210400 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_575210400;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mIsAvailable;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.615 -0400", hash_original_method = "939E32860F0B0F06BDBD0E17663153C9", hash_generated_method = "494943E9448F6678D72678AF576E9179")
    public void setIsAvailable(boolean isAvailable) {
        {
            mIsAvailable = isAvailable;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //mIsAvailable = isAvailable;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.616 -0400", hash_original_method = "9C5319745C341BE120FE9E801220DA42", hash_generated_method = "7C0774FFF984A355C33CEEBD94CAC977")
    public boolean isFailover() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1217781235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1217781235;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mIsFailover;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.616 -0400", hash_original_method = "F833C30ECD57DCF99CA2522188FA2C07", hash_generated_method = "3FB3BFCF0243C5AE1A93B4F46BBEFDC5")
    public void setFailover(boolean isFailover) {
        {
            mIsFailover = isFailover;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //mIsFailover = isFailover;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.631 -0400", hash_original_method = "AB8A93C3EDB3BBC79E3580DBDAC7F9AC", hash_generated_method = "67765C44061DBF68157C3EB8320254B0")
    public boolean isRoaming() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1451667196 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1451667196;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mIsRoaming;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.632 -0400", hash_original_method = "B7D7748403F63EB4650DEC0BB363124A", hash_generated_method = "5CDC213386E9363800D608AEB0FB16F2")
     void setRoaming(boolean isRoaming) {
        {
            mIsRoaming = isRoaming;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //mIsRoaming = isRoaming;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.633 -0400", hash_original_method = "7B78C01516FA6C80A9332B33D7F2C1E4", hash_generated_method = "8A323670430653031D0C9487BBBC1C4E")
    public State getState() {
        State varB4EAC82CA7396A68D541C85D26508E83_1878128915 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1878128915 = mState;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1878128915.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1878128915;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mState;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.633 -0400", hash_original_method = "EF299E7A8E902EE5662452C8EC565B0C", hash_generated_method = "DDDA7AC730EDCB61B99BC75BDC5B6BCF")
    public DetailedState getDetailedState() {
        DetailedState varB4EAC82CA7396A68D541C85D26508E83_1083610002 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1083610002 = mDetailedState;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1083610002.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1083610002;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mDetailedState;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.651 -0400", hash_original_method = "F9B4E8192C3BAB2B942149B3B4357918", hash_generated_method = "E71EAA3D48085C0A311AA5180CC511DE")
    public void setDetailedState(DetailedState detailedState, String reason, String extraInfo) {
        {
            this.mDetailedState = detailedState;
            this.mState = stateMap.get(detailedState);
            this.mReason = reason;
            this.mExtraInfo = extraInfo;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //this.mDetailedState = detailedState;
            //this.mState = stateMap.get(detailedState);
            //this.mReason = reason;
            //this.mExtraInfo = extraInfo;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.655 -0400", hash_original_method = "788F68C9DAC18237AEDF0C4BED188B0D", hash_generated_method = "CE2E2E14FCFFBC827852E2CB6AE50454")
    public String getReason() {
        String varB4EAC82CA7396A68D541C85D26508E83_327375734 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_327375734 = mReason;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_327375734.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_327375734;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mReason;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.656 -0400", hash_original_method = "74D0311B373A7BB37462D7229B3CD3F9", hash_generated_method = "A0FB67836CF4FB1BD0F43074CE5DA607")
    public String getExtraInfo() {
        String varB4EAC82CA7396A68D541C85D26508E83_434336311 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_434336311 = mExtraInfo;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_434336311.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_434336311;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mExtraInfo;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.667 -0400", hash_original_method = "AD77F99801D246295506D70C39DE289C", hash_generated_method = "1F09F7D06938958917FF0356E4DDFDA0")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1346227373 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1346227373 = builder.toString();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1346227373.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1346227373;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.697 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E8AA94BB7DB0EA9CAA9C884EA8EB20EF")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1546167129 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1546167129;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.700 -0400", hash_original_method = "EF9852F5CC5A1C9C509E333ACBA9ED14", hash_generated_method = "A4D8A7352ED2C7B64B074447678BE1FC")
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
        } //End block
        addTaint(dest.getTaint());
        addTaint(flags);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.700 -0400", hash_original_field = "BC9C17C6DAFAAB8182342F0EAA1A83D8", hash_generated_field = "102F3F0F4E5688512B3F5BD380D11090")

    private static EnumMap<DetailedState, State> stateMap = new EnumMap<DetailedState, State>(DetailedState.class);
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.700 -0400", hash_original_field = "4CAF625EAE81111F5604B0284353A2B1", hash_generated_field = "9C8FE6125F397F95C40575756C429932")

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

