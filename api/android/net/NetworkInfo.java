package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcelable;
import android.os.Parcel;
import java.util.EnumMap;

public class NetworkInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.397 -0400", hash_original_field = "9761905E68D80D41E55047BFA13A52C2", hash_generated_field = "60BE94F590B2B55E7F16606AE64523A2")

    private int mNetworkType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.397 -0400", hash_original_field = "3E33CBB2BE8C82106CDB44B0EFDD93E0", hash_generated_field = "298DC32990AD7D1E2E5F1AB561C62F4A")

    private int mSubtype;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.397 -0400", hash_original_field = "CE4901BF2E25E3548E50E5819FEF91BA", hash_generated_field = "FB6356289394679804A962555AC4BF63")

    private String mTypeName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.398 -0400", hash_original_field = "BE463DB514BCF1747F76DECDC515D7A7", hash_generated_field = "C7263A00155379E7E78A982D8C2EFEF0")

    private String mSubtypeName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.398 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "169FB36AA020AE19D2F764883C54F88A")

    private State mState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.398 -0400", hash_original_field = "7AA188D94D7AB9DFB39067D3C50A37F7", hash_generated_field = "5D3769B046F00AA6EC620B80C5E89776")

    private DetailedState mDetailedState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.398 -0400", hash_original_field = "D37183730F43F82EAD5FD0BEC18C215E", hash_generated_field = "39AA00EB7CB7F96F2E1FD2E750C189C0")

    private String mReason;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.398 -0400", hash_original_field = "AB5938C15B75B0ACE1172055173084EA", hash_generated_field = "C6E1689A4C75399B973F7EB992CC83CB")

    private String mExtraInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.398 -0400", hash_original_field = "67C0330E7720D27F15F181055D5B6CE3", hash_generated_field = "96403C157B820CF4FD7B8E52CFA57C58")

    private boolean mIsFailover;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.398 -0400", hash_original_field = "3DD278D5834239FCC85223B1B62442BF", hash_generated_field = "415253C847AEA7AA130149990C917780")

    private boolean mIsRoaming;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.398 -0400", hash_original_field = "6887DF0A12AC03D170DEA4FF85865F1A", hash_generated_field = "1E1A6AFD166B7DDFDBDBE32EDA8635C7")

    private boolean mIsAvailable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.398 -0400", hash_original_method = "E0E0B5DCE71AAA01C628F35001B06F62", hash_generated_method = "EFE69ABEC541A13B58B9BCC4C8E2BBA7")
    public  NetworkInfo(int type) {
        addTaint(type);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.400 -0400", hash_original_method = "D80B4D4DAAC5235D04ECA009868EE265", hash_generated_method = "344934C9E51743F0C47B42CD9435C650")
    public  NetworkInfo(int type, int subtype, String typeName, String subtypeName) {
        if(!ConnectivityManager.isNetworkTypeValid(type))        
        {
            IllegalArgumentException varB82C5650C253FF436D0B98CF8352B97A_344105534 = new IllegalArgumentException("Invalid network type: " + type);
            varB82C5650C253FF436D0B98CF8352B97A_344105534.addTaint(taint);
            throw varB82C5650C253FF436D0B98CF8352B97A_344105534;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.402 -0400", hash_original_method = "5A3F7321AA4C57E32E1DFB9D40F8D226", hash_generated_method = "F690B14894160AC70373D2F5628CD992")
    public  NetworkInfo(NetworkInfo source) {
        if(source != null)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.403 -0400", hash_original_method = "96E8498F657AF6E41693B86C8B8439F4", hash_generated_method = "369FE78B908B09F29C2755FDBC7D4E6C")
    public int getType() {
        synchronized
(this)        {
            int var9761905E68D80D41E55047BFA13A52C2_24447977 = (mNetworkType);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_277187716 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_277187716;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mNetworkType;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.403 -0400", hash_original_method = "9F9664F87EC47D562C2DFD7EF2768060", hash_generated_method = "31194D5478C234D51AC48252D27BA5C1")
    public int getSubtype() {
        synchronized
(this)        {
            int var3E33CBB2BE8C82106CDB44B0EFDD93E0_1019678390 = (mSubtype);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_36155049 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_36155049;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mSubtype;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.404 -0400", hash_original_method = "0924F80CBAE8411743081929219BD54E", hash_generated_method = "FFD0DA7ED7EB63893B066E00941541C9")
     void setSubtype(int subtype, String subtypeName) {
        synchronized
(this)        {
            mSubtype = subtype;
            mSubtypeName = subtypeName;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //mSubtype = subtype;
            //mSubtypeName = subtypeName;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.404 -0400", hash_original_method = "55AF35A663CF7527013DF4B2AE75FC8F", hash_generated_method = "9EA57C8754AB3DF144B035BA683B23C9")
    public String getTypeName() {
        synchronized
(this)        {
String varFAA2BB965482198826C78279705D19C6_780619574 =             mTypeName;
            varFAA2BB965482198826C78279705D19C6_780619574.addTaint(taint);
            return varFAA2BB965482198826C78279705D19C6_780619574;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mTypeName;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.404 -0400", hash_original_method = "0043E0CF1F933E5EC5CD97392CA0E5B0", hash_generated_method = "9C2C034D498302EA8FB30838E3323A80")
    public String getSubtypeName() {
        synchronized
(this)        {
String var9853BDE3D68EC39045135DFC6FA71950_223398304 =             mSubtypeName;
            var9853BDE3D68EC39045135DFC6FA71950_223398304.addTaint(taint);
            return var9853BDE3D68EC39045135DFC6FA71950_223398304;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mSubtypeName;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.405 -0400", hash_original_method = "4340B79C926146F86A68CF1464A26E93", hash_generated_method = "A49CBE0DA1F2F33432143A550489A646")
    public boolean isConnectedOrConnecting() {
        synchronized
(this)        {
            boolean varB324F4670688A6CD0D8E99F228C71679_1562205484 = (mState == State.CONNECTED || mState == State.CONNECTING);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1512535526 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1512535526;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mState == State.CONNECTED || mState == State.CONNECTING;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.405 -0400", hash_original_method = "E81AE1BB2B0829AC31FE0D849F294E67", hash_generated_method = "3E56CA132619EDA8C9D04175092C49AC")
    public boolean isConnected() {
        synchronized
(this)        {
            boolean var9AF15D6357C65A0FC1482C9882B8DDA6_1503346300 = (mState == State.CONNECTED);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2033814766 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2033814766;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mState == State.CONNECTED;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.405 -0400", hash_original_method = "4897D1CF0EA563D6DA8C578331010914", hash_generated_method = "98192227FA96317AEB1945971D145B34")
    public boolean isAvailable() {
        synchronized
(this)        {
            boolean var6887DF0A12AC03D170DEA4FF85865F1A_1950858635 = (mIsAvailable);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_166896320 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_166896320;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mIsAvailable;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.406 -0400", hash_original_method = "939E32860F0B0F06BDBD0E17663153C9", hash_generated_method = "03778C8E21993ADE9A96CC553A347AE7")
    public void setIsAvailable(boolean isAvailable) {
        synchronized
(this)        {
            mIsAvailable = isAvailable;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //mIsAvailable = isAvailable;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.406 -0400", hash_original_method = "9C5319745C341BE120FE9E801220DA42", hash_generated_method = "2F784EF5581918CDAF4AAFEBFAC5EB28")
    public boolean isFailover() {
        synchronized
(this)        {
            boolean var67C0330E7720D27F15F181055D5B6CE3_1964086266 = (mIsFailover);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1525628655 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1525628655;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mIsFailover;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.407 -0400", hash_original_method = "F833C30ECD57DCF99CA2522188FA2C07", hash_generated_method = "91F2D1762787A05AAC8F1342F228A08A")
    public void setFailover(boolean isFailover) {
        synchronized
(this)        {
            mIsFailover = isFailover;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //mIsFailover = isFailover;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.407 -0400", hash_original_method = "AB8A93C3EDB3BBC79E3580DBDAC7F9AC", hash_generated_method = "A289D7F0B54B0982C6D6199AF93E8554")
    public boolean isRoaming() {
        synchronized
(this)        {
            boolean var3DD278D5834239FCC85223B1B62442BF_1022546227 = (mIsRoaming);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1790495083 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1790495083;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mIsRoaming;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.408 -0400", hash_original_method = "B7D7748403F63EB4650DEC0BB363124A", hash_generated_method = "8498442A61A5A37E78537547B58EB68D")
     void setRoaming(boolean isRoaming) {
        synchronized
(this)        {
            mIsRoaming = isRoaming;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //mIsRoaming = isRoaming;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.408 -0400", hash_original_method = "7B78C01516FA6C80A9332B33D7F2C1E4", hash_generated_method = "698F2FA925B2965D25FBBDE38F97B261")
    public State getState() {
        synchronized
(this)        {
State var8B975C85F13BECB9FD4D21A5F3C8A56D_1183293741 =             mState;
            var8B975C85F13BECB9FD4D21A5F3C8A56D_1183293741.addTaint(taint);
            return var8B975C85F13BECB9FD4D21A5F3C8A56D_1183293741;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mState;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.408 -0400", hash_original_method = "EF299E7A8E902EE5662452C8EC565B0C", hash_generated_method = "A110B21C46749EC07C6361DCB1D433E6")
    public DetailedState getDetailedState() {
        synchronized
(this)        {
DetailedState var824FE49BF4029232CF22A03E7D5285D6_703343392 =             mDetailedState;
            var824FE49BF4029232CF22A03E7D5285D6_703343392.addTaint(taint);
            return var824FE49BF4029232CF22A03E7D5285D6_703343392;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mDetailedState;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.409 -0400", hash_original_method = "F9B4E8192C3BAB2B942149B3B4357918", hash_generated_method = "150DE1F5E762DF8A96EC3EBD63BF8B11")
    public void setDetailedState(DetailedState detailedState, String reason, String extraInfo) {
        synchronized
(this)        {
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.409 -0400", hash_original_method = "788F68C9DAC18237AEDF0C4BED188B0D", hash_generated_method = "5DD21E16ED419DD672251D4FE6F9B80C")
    public String getReason() {
        synchronized
(this)        {
String var59DFD2A70B3F2D6B9D7CBF9B5624B087_1234679236 =             mReason;
            var59DFD2A70B3F2D6B9D7CBF9B5624B087_1234679236.addTaint(taint);
            return var59DFD2A70B3F2D6B9D7CBF9B5624B087_1234679236;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mReason;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.410 -0400", hash_original_method = "74D0311B373A7BB37462D7229B3CD3F9", hash_generated_method = "C8872FB08D6C2B8F46D440CAE9ECB8EF")
    public String getExtraInfo() {
        synchronized
(this)        {
String var8C566785696787B06C7B09BA315043CE_1016338902 =             mExtraInfo;
            var8C566785696787B06C7B09BA315043CE_1016338902.addTaint(taint);
            return var8C566785696787B06C7B09BA315043CE_1016338902;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mExtraInfo;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.410 -0400", hash_original_method = "AD77F99801D246295506D70C39DE289C", hash_generated_method = "E66124BE6C681FEFCECB0B7D42C0ADC4")
    @Override
    public String toString() {
        synchronized
(this)        {
            StringBuilder builder = new StringBuilder("NetworkInfo: ");
            builder.append("type: ").append(getTypeName()).append("[").append(getSubtypeName()).
            append("], state: ").append(mState).append("/").append(mDetailedState).
            append(", reason: ").append(mReason == null ? "(unspecified)" : mReason).
            append(", extra: ").append(mExtraInfo == null ? "(none)" : mExtraInfo).
            append(", roaming: ").append(mIsRoaming).
            append(", failover: ").append(mIsFailover).
            append(", isAvailable: ").append(mIsAvailable);
String varF4CF030572656354ACFDF83FEE21D7A6_898918148 =             builder.toString();
            varF4CF030572656354ACFDF83FEE21D7A6_898918148.addTaint(taint);
            return varF4CF030572656354ACFDF83FEE21D7A6_898918148;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.411 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "23FD66E174BE71BB22D98804EE2562AC")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1530363441 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1841003638 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1841003638;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.411 -0400", hash_original_method = "EF9852F5CC5A1C9C509E333ACBA9ED14", hash_generated_method = "AAA1CE22A6902C6CCD845A91BBD53F7D")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        synchronized
(this)        {
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.412 -0400", hash_original_field = "BC9C17C6DAFAAB8182342F0EAA1A83D8", hash_generated_field = "2F62E12883E62B29FD64F8F884A9218D")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.412 -0400", hash_original_field = "4CAF625EAE81111F5604B0284353A2B1", hash_generated_field = "9C8FE6125F397F95C40575756C429932")

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

