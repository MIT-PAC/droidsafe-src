package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class ServiceState implements Parcelable {
    private int mState = STATE_OUT_OF_SERVICE;
    private boolean mRoaming;
    private String mOperatorAlphaLong;
    private String mOperatorAlphaShort;
    private String mOperatorNumeric;
    private boolean mIsManualNetworkSelection;
    private boolean mIsEmergencyOnly;
    private int mRadioTechnology;
    private boolean mCssIndicator;
    private int mNetworkId;
    private int mSystemId;
    private int mCdmaRoamingIndicator;
    private int mCdmaDefaultRoamingIndicator;
    private int mCdmaEriIconIndex;
    private int mCdmaEriIconMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.631 -0400", hash_original_method = "36476E21C74B3827A7B01BE12F666937", hash_generated_method = "A7807DEFF5E02F2472BD589AB7484EC5")
    @DSModeled(DSC.SAFE)
    public ServiceState() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.631 -0400", hash_original_method = "77F46968981D692048E5F6D63AA7A464", hash_generated_method = "0F39468222D45DC8403F1573C480F3AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServiceState(ServiceState s) {
        dsTaint.addTaint(s.dsTaint);
        copyFrom(s);
        // ---------- Original Method ----------
        //copyFrom(s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.632 -0400", hash_original_method = "E237E117068718AE5F81C4213860014E", hash_generated_method = "8D6DD11E628984D40CE3ED25DF967CAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServiceState(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        mState = in.readInt();
        mRoaming = in.readInt() != 0;
        mOperatorAlphaLong = in.readString();
        mOperatorAlphaShort = in.readString();
        mOperatorNumeric = in.readString();
        mIsManualNetworkSelection = in.readInt() != 0;
        mRadioTechnology = in.readInt();
        mCssIndicator = (in.readInt() != 0);
        mNetworkId = in.readInt();
        mSystemId = in.readInt();
        mCdmaRoamingIndicator = in.readInt();
        mCdmaDefaultRoamingIndicator = in.readInt();
        mCdmaEriIconIndex = in.readInt();
        mCdmaEriIconMode = in.readInt();
        mIsEmergencyOnly = in.readInt() != 0;
        // ---------- Original Method ----------
        //mState = in.readInt();
        //mRoaming = in.readInt() != 0;
        //mOperatorAlphaLong = in.readString();
        //mOperatorAlphaShort = in.readString();
        //mOperatorNumeric = in.readString();
        //mIsManualNetworkSelection = in.readInt() != 0;
        //mRadioTechnology = in.readInt();
        //mCssIndicator = (in.readInt() != 0);
        //mNetworkId = in.readInt();
        //mSystemId = in.readInt();
        //mCdmaRoamingIndicator = in.readInt();
        //mCdmaDefaultRoamingIndicator = in.readInt();
        //mCdmaEriIconIndex = in.readInt();
        //mCdmaEriIconMode = in.readInt();
        //mIsEmergencyOnly = in.readInt() != 0;
    }

    
        public static ServiceState newFromBundle(Bundle m) {
        ServiceState ret;
        ret = new ServiceState();
        ret.setFromNotifierBundle(m);
        return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.632 -0400", hash_original_method = "E04D2A000CEC20636ABEC5ED3DEE444A", hash_generated_method = "DF0296BA0B901B7C74615DD84091E3C8")
    @DSModeled(DSC.SAFE)
    protected void copyFrom(ServiceState s) {
        dsTaint.addTaint(s.dsTaint);
        mState = s.mState;
        mRoaming = s.mRoaming;
        mOperatorAlphaLong = s.mOperatorAlphaLong;
        mOperatorAlphaShort = s.mOperatorAlphaShort;
        mOperatorNumeric = s.mOperatorNumeric;
        mIsManualNetworkSelection = s.mIsManualNetworkSelection;
        mRadioTechnology = s.mRadioTechnology;
        mCssIndicator = s.mCssIndicator;
        mNetworkId = s.mNetworkId;
        mSystemId = s.mSystemId;
        mCdmaRoamingIndicator = s.mCdmaRoamingIndicator;
        mCdmaDefaultRoamingIndicator = s.mCdmaDefaultRoamingIndicator;
        mCdmaEriIconIndex = s.mCdmaEriIconIndex;
        mCdmaEriIconMode = s.mCdmaEriIconMode;
        mIsEmergencyOnly = s.mIsEmergencyOnly;
        // ---------- Original Method ----------
        //mState = s.mState;
        //mRoaming = s.mRoaming;
        //mOperatorAlphaLong = s.mOperatorAlphaLong;
        //mOperatorAlphaShort = s.mOperatorAlphaShort;
        //mOperatorNumeric = s.mOperatorNumeric;
        //mIsManualNetworkSelection = s.mIsManualNetworkSelection;
        //mRadioTechnology = s.mRadioTechnology;
        //mCssIndicator = s.mCssIndicator;
        //mNetworkId = s.mNetworkId;
        //mSystemId = s.mSystemId;
        //mCdmaRoamingIndicator = s.mCdmaRoamingIndicator;
        //mCdmaDefaultRoamingIndicator = s.mCdmaDefaultRoamingIndicator;
        //mCdmaEriIconIndex = s.mCdmaEriIconIndex;
        //mCdmaEriIconMode = s.mCdmaEriIconMode;
        //mIsEmergencyOnly = s.mIsEmergencyOnly;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.633 -0400", hash_original_method = "0314D3363C47B5602718344C30C07D2D", hash_generated_method = "5CD6F3C79048A4025CF15C8282D02417")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeInt(mState);
        out.writeInt(mRoaming ? 1 : 0);
        out.writeString(mOperatorAlphaLong);
        out.writeString(mOperatorAlphaShort);
        out.writeString(mOperatorNumeric);
        out.writeInt(mIsManualNetworkSelection ? 1 : 0);
        out.writeInt(mRadioTechnology);
        out.writeInt(mCssIndicator ? 1 : 0);
        out.writeInt(mNetworkId);
        out.writeInt(mSystemId);
        out.writeInt(mCdmaRoamingIndicator);
        out.writeInt(mCdmaDefaultRoamingIndicator);
        out.writeInt(mCdmaEriIconIndex);
        out.writeInt(mCdmaEriIconMode);
        out.writeInt(mIsEmergencyOnly ? 1 : 0);
        // ---------- Original Method ----------
        //out.writeInt(mState);
        //out.writeInt(mRoaming ? 1 : 0);
        //out.writeString(mOperatorAlphaLong);
        //out.writeString(mOperatorAlphaShort);
        //out.writeString(mOperatorNumeric);
        //out.writeInt(mIsManualNetworkSelection ? 1 : 0);
        //out.writeInt(mRadioTechnology);
        //out.writeInt(mCssIndicator ? 1 : 0);
        //out.writeInt(mNetworkId);
        //out.writeInt(mSystemId);
        //out.writeInt(mCdmaRoamingIndicator);
        //out.writeInt(mCdmaDefaultRoamingIndicator);
        //out.writeInt(mCdmaEriIconIndex);
        //out.writeInt(mCdmaEriIconMode);
        //out.writeInt(mIsEmergencyOnly ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.633 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.633 -0400", hash_original_method = "10E9373648D5DF4EE43B4904732E3886", hash_generated_method = "EAFA6E13B7668B98AAF6336330D54E32")
    @DSModeled(DSC.SAFE)
    public int getState() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.633 -0400", hash_original_method = "27B48B56BD1E05F31D9E74CC53E25407", hash_generated_method = "5280D29668A9F15E0335FD1E001CD3A1")
    @DSModeled(DSC.SAFE)
    public boolean getRoaming() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRoaming;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.634 -0400", hash_original_method = "3DFEB66E744CCF30AC3F0251BA213E84", hash_generated_method = "A0E3BFDC54B5C462B99519A19C00F7C2")
    @DSModeled(DSC.SAFE)
    public boolean isEmergencyOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsEmergencyOnly;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.634 -0400", hash_original_method = "83FC91D4D13183AA7E425917DAA84866", hash_generated_method = "8F9249CA4E310291A3F905BD72B80954")
    @DSModeled(DSC.SAFE)
    public int getCdmaRoamingIndicator() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mCdmaRoamingIndicator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.634 -0400", hash_original_method = "66A4F6EB11ADB385A490C7939EB92055", hash_generated_method = "B282C04F576AF7BA7B00D3A2BAE56000")
    @DSModeled(DSC.SAFE)
    public int getCdmaDefaultRoamingIndicator() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mCdmaDefaultRoamingIndicator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.634 -0400", hash_original_method = "A86147562C8C2CE9187BA7AFC3028DA0", hash_generated_method = "D98A8F9D3926591ECC0D9894FEC3615F")
    @DSModeled(DSC.SAFE)
    public int getCdmaEriIconIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mCdmaEriIconIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.635 -0400", hash_original_method = "637A5E08A8AA09E09B00A7308F96EA32", hash_generated_method = "74077C01CE158DED57FE2B0D19CE538B")
    @DSModeled(DSC.SAFE)
    public int getCdmaEriIconMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mCdmaEriIconMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.635 -0400", hash_original_method = "550CF77EB1CEA79355B2985E6B5A4349", hash_generated_method = "9628A4C80ACD1B646BDC8D1738E3CBDC")
    @DSModeled(DSC.SAFE)
    public String getOperatorAlphaLong() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mOperatorAlphaLong;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.635 -0400", hash_original_method = "86619391C7B398160E7B9E543643DBB4", hash_generated_method = "B1919A1233DA0802AE83F843620A1EBE")
    @DSModeled(DSC.SAFE)
    public String getOperatorAlphaShort() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mOperatorAlphaShort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.635 -0400", hash_original_method = "608E7A84F718D26C8A9F8E19A83C0931", hash_generated_method = "C80CD503C5ABB4177E2E48E62EE763C8")
    @DSModeled(DSC.SAFE)
    public String getOperatorNumeric() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mOperatorNumeric;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.635 -0400", hash_original_method = "233C7A13AF785DA7BC75C18AF3C8DB71", hash_generated_method = "600A3324DBDE88E9CB3FE3B2BDB5E599")
    @DSModeled(DSC.SAFE)
    public boolean getIsManualSelection() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsManualNetworkSelection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.636 -0400", hash_original_method = "4FC9291B326FDF96318315E16F56658C", hash_generated_method = "A5EF79AB196CA1BDDE6C015E324ED706")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var17E1E702D83D8892539663C4B4794A68_1569868254 = (((mState * 0x1234)
                + (mRoaming ? 1 : 0)
                + (mIsManualNetworkSelection ? 1 : 0)
                + ((null == mOperatorAlphaLong) ? 0 : mOperatorAlphaLong.hashCode())
                + ((null == mOperatorAlphaShort) ? 0 : mOperatorAlphaShort.hashCode())
                + ((null == mOperatorNumeric) ? 0 : mOperatorNumeric.hashCode())
                + mCdmaRoamingIndicator
                + mCdmaDefaultRoamingIndicator
                + (mIsEmergencyOnly ? 1 : 0))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((mState * 0x1234)
                //+ (mRoaming ? 1 : 0)
                //+ (mIsManualNetworkSelection ? 1 : 0)
                //+ ((null == mOperatorAlphaLong) ? 0 : mOperatorAlphaLong.hashCode())
                //+ ((null == mOperatorAlphaShort) ? 0 : mOperatorAlphaShort.hashCode())
                //+ ((null == mOperatorNumeric) ? 0 : mOperatorNumeric.hashCode())
                //+ mCdmaRoamingIndicator
                //+ mCdmaDefaultRoamingIndicator
                //+ (mIsEmergencyOnly ? 1 : 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.636 -0400", hash_original_method = "5AB9F404C745D33B000995514C8414B5", hash_generated_method = "1D295D17D4F446441975788D46EBDADF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        ServiceState s;
        try 
        {
            s = (ServiceState) o;
        } //End block
        catch (ClassCastException ex)
        { }
        boolean varEE276B99C43E5154F1BACA397993F41B_514913777 = ((mState == s.mState
                && mRoaming == s.mRoaming
                && mIsManualNetworkSelection == s.mIsManualNetworkSelection
                && equalsHandlesNulls(mOperatorAlphaLong, s.mOperatorAlphaLong)
                && equalsHandlesNulls(mOperatorAlphaShort, s.mOperatorAlphaShort)
                && equalsHandlesNulls(mOperatorNumeric, s.mOperatorNumeric)
                && equalsHandlesNulls(mRadioTechnology, s.mRadioTechnology)
                && equalsHandlesNulls(mCssIndicator, s.mCssIndicator)
                && equalsHandlesNulls(mNetworkId, s.mNetworkId)
                && equalsHandlesNulls(mSystemId, s.mSystemId)
                && equalsHandlesNulls(mCdmaRoamingIndicator, s.mCdmaRoamingIndicator)
                && equalsHandlesNulls(mCdmaDefaultRoamingIndicator,
                        s.mCdmaDefaultRoamingIndicator)
                && mIsEmergencyOnly == s.mIsEmergencyOnly));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static String radioTechnologyToString(int rt) {
        String rtString;
        switch(rt) {
            case 0:
                rtString = "Unknown";
                break;
            case 1:
                rtString = "GPRS";
                break;
            case 2:
                rtString = "EDGE";
                break;
            case 3:
                rtString = "UMTS";
                break;
            case 4:
                rtString = "CDMA-IS95A";
                break;
            case 5:
                rtString = "CDMA-IS95B";
                break;
            case 6:
                rtString = "1xRTT";
                break;
            case 7:
                rtString = "EvDo-rev.0";
                break;
            case 8:
                rtString = "EvDo-rev.A";
                break;
            case 9:
                rtString = "HSDPA";
                break;
            case 10:
                rtString = "HSUPA";
                break;
            case 11:
                rtString = "HSPA";
                break;
            case 12:
                rtString = "EvDo-rev.B";
                break;
            case 13:
                rtString = "eHRPD";
                break;
            case 14:
                rtString = "LTE";
                break;
            case 15:
                rtString = "HSPAP";
                break;
            default:
                rtString = "Unexpected";
                Log.w(LOG_TAG, "Unexpected radioTechnology=" + rt);
                break;
        }
        return rtString + ":" + rt;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.637 -0400", hash_original_method = "8261C946B0851B9612BB2224B1BDDEEE", hash_generated_method = "ACA2F6F0E3C51CC5D9E41EDC89CE3548")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String radioTechnology;
        radioTechnology = radioTechnologyToString(mRadioTechnology);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String radioTechnology = radioTechnologyToString(mRadioTechnology);
        //return (mState + " " + (mRoaming ? "roaming" : "home")
                //+ " " + mOperatorAlphaLong
                //+ " " + mOperatorAlphaShort
                //+ " " + mOperatorNumeric
                //+ " " + (mIsManualNetworkSelection ? "(manual)" : "")
                //+ " " + radioTechnology
                //+ " " + (mCssIndicator ? "CSS supported" : "CSS not supported")
                //+ " " + mNetworkId
                //+ " " + mSystemId
                //+ " RoamInd=" + mCdmaRoamingIndicator
                //+ " DefRoamInd=" + mCdmaDefaultRoamingIndicator
                //+ " EmergOnly=" + mIsEmergencyOnly);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.638 -0400", hash_original_method = "8ACC80A7889D35C4C641DEE09D896F76", hash_generated_method = "093CA9766EE0E015DB432255A47BE79A")
    @DSModeled(DSC.SAFE)
    private void setNullState(int state) {
        dsTaint.addTaint(state);
        mRoaming = false;
        mOperatorAlphaLong = null;
        mOperatorAlphaShort = null;
        mOperatorNumeric = null;
        mIsManualNetworkSelection = false;
        mRadioTechnology = 0;
        mCssIndicator = false;
        mNetworkId = -1;
        mSystemId = -1;
        mCdmaRoamingIndicator = -1;
        mCdmaDefaultRoamingIndicator = -1;
        mCdmaEriIconIndex = -1;
        mCdmaEriIconMode = -1;
        mIsEmergencyOnly = false;
        // ---------- Original Method ----------
        //mState = state;
        //mRoaming = false;
        //mOperatorAlphaLong = null;
        //mOperatorAlphaShort = null;
        //mOperatorNumeric = null;
        //mIsManualNetworkSelection = false;
        //mRadioTechnology = 0;
        //mCssIndicator = false;
        //mNetworkId = -1;
        //mSystemId = -1;
        //mCdmaRoamingIndicator = -1;
        //mCdmaDefaultRoamingIndicator = -1;
        //mCdmaEriIconIndex = -1;
        //mCdmaEriIconMode = -1;
        //mIsEmergencyOnly = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.638 -0400", hash_original_method = "638BC09D981AD6B06693C47D3D967201", hash_generated_method = "23CD066BEE1328B3FAF766CB48BCAE3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStateOutOfService() {
        setNullState(STATE_OUT_OF_SERVICE);
        // ---------- Original Method ----------
        //setNullState(STATE_OUT_OF_SERVICE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.638 -0400", hash_original_method = "D9FAF4EA3D294E58217DAB74F17C0351", hash_generated_method = "6564B9436096F301E0C8CC97A1ABB541")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStateOff() {
        setNullState(STATE_POWER_OFF);
        // ---------- Original Method ----------
        //setNullState(STATE_POWER_OFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.638 -0400", hash_original_method = "B2257FFBD3B79161D70D00C92F5BABD5", hash_generated_method = "B56E7E0D236E8A07C90D512EE3EFAB45")
    @DSModeled(DSC.SAFE)
    public void setState(int state) {
        dsTaint.addTaint(state);
        // ---------- Original Method ----------
        //mState = state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.639 -0400", hash_original_method = "78DC27B1781D6001A1042BE9E193D14B", hash_generated_method = "CDD189905AC0FF4AB76683249411BAFB")
    @DSModeled(DSC.SAFE)
    public void setRoaming(boolean roaming) {
        dsTaint.addTaint(roaming);
        // ---------- Original Method ----------
        //mRoaming = roaming;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.639 -0400", hash_original_method = "B2BA3AF9B92E65EA8B062AC201A0C0F0", hash_generated_method = "4C8B6F58AE328675B14E2732257A42B2")
    @DSModeled(DSC.SAFE)
    public void setEmergencyOnly(boolean emergencyOnly) {
        dsTaint.addTaint(emergencyOnly);
        // ---------- Original Method ----------
        //mIsEmergencyOnly = emergencyOnly;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.639 -0400", hash_original_method = "C5CC061ACF011623DDFD13C5F3F99CC3", hash_generated_method = "43282547305A7ADD5A4C4A8798D139DB")
    @DSModeled(DSC.SAFE)
    public void setCdmaRoamingIndicator(int roaming) {
        dsTaint.addTaint(roaming);
        // ---------- Original Method ----------
        //this.mCdmaRoamingIndicator = roaming;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.639 -0400", hash_original_method = "723EC448C9CB51F7110A335E414C4680", hash_generated_method = "DC4C2E23DA6BA5FC4959B1847E60416A")
    @DSModeled(DSC.SAFE)
    public void setCdmaDefaultRoamingIndicator(int roaming) {
        dsTaint.addTaint(roaming);
        // ---------- Original Method ----------
        //this.mCdmaDefaultRoamingIndicator = roaming;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.640 -0400", hash_original_method = "270DF85E703DBBACE36CF343B8162562", hash_generated_method = "2AABD04941E1E9F90060522C6D0601A8")
    @DSModeled(DSC.SAFE)
    public void setCdmaEriIconIndex(int index) {
        dsTaint.addTaint(index);
        // ---------- Original Method ----------
        //this.mCdmaEriIconIndex = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.640 -0400", hash_original_method = "B583E3E822650F1B5214B53503BF1241", hash_generated_method = "738361333EE124A3B72D808F4C5210D9")
    @DSModeled(DSC.SAFE)
    public void setCdmaEriIconMode(int mode) {
        dsTaint.addTaint(mode);
        // ---------- Original Method ----------
        //this.mCdmaEriIconMode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.640 -0400", hash_original_method = "AB95572079513DCF8B19D191A4DD2824", hash_generated_method = "0C119E999AE5122EB270374A49A5171F")
    @DSModeled(DSC.SAFE)
    public void setOperatorName(String longName, String shortName, String numeric) {
        dsTaint.addTaint(numeric);
        dsTaint.addTaint(longName);
        dsTaint.addTaint(shortName);
        // ---------- Original Method ----------
        //mOperatorAlphaLong = longName;
        //mOperatorAlphaShort = shortName;
        //mOperatorNumeric = numeric;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.640 -0400", hash_original_method = "2932DCDD0502DE94804E9827964069D2", hash_generated_method = "F7B3919037917999D72BE9A8CB88CFEE")
    @DSModeled(DSC.SAFE)
    public void setOperatorAlphaLong(String longName) {
        dsTaint.addTaint(longName);
        // ---------- Original Method ----------
        //mOperatorAlphaLong = longName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.641 -0400", hash_original_method = "C2D18251B53286CEC68F55BEC648A3A6", hash_generated_method = "B32708325A48CD84D115C8250BB5E2F7")
    @DSModeled(DSC.SAFE)
    public void setIsManualSelection(boolean isManual) {
        dsTaint.addTaint(isManual);
        // ---------- Original Method ----------
        //mIsManualNetworkSelection = isManual;
    }

    
        private static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.642 -0400", hash_original_method = "45F7665F0B17EC4A3962C47A86921C1E", hash_generated_method = "55A6E4B4BE5E52894E25F52726059825")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setFromNotifierBundle(Bundle m) {
        dsTaint.addTaint(m.dsTaint);
        mState = m.getInt("state");
        mRoaming = m.getBoolean("roaming");
        mOperatorAlphaLong = m.getString("operator-alpha-long");
        mOperatorAlphaShort = m.getString("operator-alpha-short");
        mOperatorNumeric = m.getString("operator-numeric");
        mIsManualNetworkSelection = m.getBoolean("manual");
        mRadioTechnology = m.getInt("radioTechnology");
        mCssIndicator = m.getBoolean("cssIndicator");
        mNetworkId = m.getInt("networkId");
        mSystemId = m.getInt("systemId");
        mCdmaRoamingIndicator = m.getInt("cdmaRoamingIndicator");
        mCdmaDefaultRoamingIndicator = m.getInt("cdmaDefaultRoamingIndicator");
        mIsEmergencyOnly = m.getBoolean("emergencyOnly");
        // ---------- Original Method ----------
        //mState = m.getInt("state");
        //mRoaming = m.getBoolean("roaming");
        //mOperatorAlphaLong = m.getString("operator-alpha-long");
        //mOperatorAlphaShort = m.getString("operator-alpha-short");
        //mOperatorNumeric = m.getString("operator-numeric");
        //mIsManualNetworkSelection = m.getBoolean("manual");
        //mRadioTechnology = m.getInt("radioTechnology");
        //mCssIndicator = m.getBoolean("cssIndicator");
        //mNetworkId = m.getInt("networkId");
        //mSystemId = m.getInt("systemId");
        //mCdmaRoamingIndicator = m.getInt("cdmaRoamingIndicator");
        //mCdmaDefaultRoamingIndicator = m.getInt("cdmaDefaultRoamingIndicator");
        //mIsEmergencyOnly = m.getBoolean("emergencyOnly");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.643 -0400", hash_original_method = "9BCA23D068820B6DD53DFB45DB9457FF", hash_generated_method = "65F3E08F402EFACB0DE90C2088491B32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fillInNotifierBundle(Bundle m) {
        dsTaint.addTaint(m.dsTaint);
        m.putInt("state", mState);
        m.putBoolean("roaming", Boolean.valueOf(mRoaming));
        m.putString("operator-alpha-long", mOperatorAlphaLong);
        m.putString("operator-alpha-short", mOperatorAlphaShort);
        m.putString("operator-numeric", mOperatorNumeric);
        m.putBoolean("manual", Boolean.valueOf(mIsManualNetworkSelection));
        m.putInt("radioTechnology", mRadioTechnology);
        m.putBoolean("cssIndicator", mCssIndicator);
        m.putInt("networkId", mNetworkId);
        m.putInt("systemId", mSystemId);
        m.putInt("cdmaRoamingIndicator", mCdmaRoamingIndicator);
        m.putInt("cdmaDefaultRoamingIndicator", mCdmaDefaultRoamingIndicator);
        m.putBoolean("emergencyOnly", Boolean.valueOf(mIsEmergencyOnly));
        // ---------- Original Method ----------
        //m.putInt("state", mState);
        //m.putBoolean("roaming", Boolean.valueOf(mRoaming));
        //m.putString("operator-alpha-long", mOperatorAlphaLong);
        //m.putString("operator-alpha-short", mOperatorAlphaShort);
        //m.putString("operator-numeric", mOperatorNumeric);
        //m.putBoolean("manual", Boolean.valueOf(mIsManualNetworkSelection));
        //m.putInt("radioTechnology", mRadioTechnology);
        //m.putBoolean("cssIndicator", mCssIndicator);
        //m.putInt("networkId", mNetworkId);
        //m.putInt("systemId", mSystemId);
        //m.putInt("cdmaRoamingIndicator", mCdmaRoamingIndicator);
        //m.putInt("cdmaDefaultRoamingIndicator", mCdmaDefaultRoamingIndicator);
        //m.putBoolean("emergencyOnly", Boolean.valueOf(mIsEmergencyOnly));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.643 -0400", hash_original_method = "C012C4DB079EEB33708722C3BF4101EF", hash_generated_method = "E38D505C96537A5B7F0162B848918F0B")
    @DSModeled(DSC.SAFE)
    public void setRadioTechnology(int state) {
        dsTaint.addTaint(state);
        // ---------- Original Method ----------
        //this.mRadioTechnology = state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.643 -0400", hash_original_method = "C1350CF85A5CAF49D330DF5D8BE50D5D", hash_generated_method = "1323C537ED4AF76B22FA304611028583")
    @DSModeled(DSC.SAFE)
    public void setCssIndicator(int css) {
        dsTaint.addTaint(css);
        this.mCssIndicator = (css != 0);
        // ---------- Original Method ----------
        //this.mCssIndicator = (css != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.643 -0400", hash_original_method = "A7D542E3F6857DF89C73ABBE482A1544", hash_generated_method = "C4F4E780CCEE684854EC7E73CC751CBD")
    @DSModeled(DSC.SAFE)
    public void setSystemAndNetworkId(int systemId, int networkId) {
        dsTaint.addTaint(networkId);
        dsTaint.addTaint(systemId);
        // ---------- Original Method ----------
        //this.mSystemId = systemId;
        //this.mNetworkId = networkId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.643 -0400", hash_original_method = "D4EB1377E20B241083847F14436F60D5", hash_generated_method = "D8E580682C2636E81C530B798C9FEC7E")
    @DSModeled(DSC.SAFE)
    public int getRadioTechnology() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mRadioTechnology;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.644 -0400", hash_original_method = "5F3502ED7337480E1E948E539B84EEE6", hash_generated_method = "2C602825ED0A17612FA00ADB6B150703")
    @DSModeled(DSC.SAFE)
    public int getCssIndicator() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mCssIndicator ? 1 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.644 -0400", hash_original_method = "909C93F66AD557988A123F548D8C31FC", hash_generated_method = "5F062E331A0EEB3F90F4CE6D7A3F5621")
    @DSModeled(DSC.SAFE)
    public int getNetworkId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mNetworkId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.644 -0400", hash_original_method = "E5E4F22C1EB64E5BA2863333F6C891A3", hash_generated_method = "9AF58D756F49E3460180162C1F9F75FB")
    @DSModeled(DSC.SAFE)
    public int getSystemId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mSystemId;
    }

    
    static final String LOG_TAG = "PHONE";
    public static final int STATE_IN_SERVICE = 0;
    public static final int STATE_OUT_OF_SERVICE = 1;
    public static final int STATE_EMERGENCY_ONLY = 2;
    public static final int STATE_POWER_OFF = 3;
    public static final int RADIO_TECHNOLOGY_UNKNOWN = 0;
    public static final int RADIO_TECHNOLOGY_GPRS = 1;
    public static final int RADIO_TECHNOLOGY_EDGE = 2;
    public static final int RADIO_TECHNOLOGY_UMTS = 3;
    public static final int RADIO_TECHNOLOGY_IS95A = 4;
    public static final int RADIO_TECHNOLOGY_IS95B = 5;
    public static final int RADIO_TECHNOLOGY_1xRTT = 6;
    public static final int RADIO_TECHNOLOGY_EVDO_0 = 7;
    public static final int RADIO_TECHNOLOGY_EVDO_A = 8;
    public static final int RADIO_TECHNOLOGY_HSDPA = 9;
    public static final int RADIO_TECHNOLOGY_HSUPA = 10;
    public static final int RADIO_TECHNOLOGY_HSPA = 11;
    public static final int RADIO_TECHNOLOGY_EVDO_B = 12;
    public static final int RADIO_TECHNOLOGY_EHRPD = 13;
    public static final int RADIO_TECHNOLOGY_LTE = 14;
    public static final int RADIO_TECHNOLOGY_HSPAP = 15;
    public static final int REGISTRATION_STATE_NOT_REGISTERED_AND_NOT_SEARCHING = 0;
    public static final int REGISTRATION_STATE_HOME_NETWORK = 1;
    public static final int REGISTRATION_STATE_NOT_REGISTERED_AND_SEARCHING = 2;
    public static final int REGISTRATION_STATE_REGISTRATION_DENIED = 3;
    public static final int REGISTRATION_STATE_UNKNOWN = 4;
    public static final int REGISTRATION_STATE_ROAMING = 5;
    public static final Parcelable.Creator<ServiceState> CREATOR = new Parcelable.Creator<ServiceState>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.644 -0400", hash_original_method = "8CB2CF1085CE8B72C4A34EE92896EB72", hash_generated_method = "9D56DB34C9FCDB38115582A8BB95F669")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ServiceState createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            ServiceState var507E1A44D2E7299599B514F7FA0BC35F_1154991162 = (new ServiceState(in));
            return (ServiceState)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ServiceState(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.645 -0400", hash_original_method = "EC02653A60FC5AF3A9F13EE38C19100C", hash_generated_method = "EDCA9DD4DD0E329F03BC747CDEDE051A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ServiceState[] newArray(int size) {
            dsTaint.addTaint(size);
            ServiceState[] var1ED4630204384C4CC1CDF38AB17FDBDD_498396378 = (new ServiceState[size]);
            return (ServiceState[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ServiceState[size];
        }

        
}; //Transformed anonymous class
}

