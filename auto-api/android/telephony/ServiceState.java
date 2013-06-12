package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class ServiceState implements Parcelable {
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
    public static final Parcelable.Creator<ServiceState> CREATOR = new Parcelable.Creator<ServiceState>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.612 -0400", hash_original_method = "8CB2CF1085CE8B72C4A34EE92896EB72", hash_generated_method = "E29668FFA06F075501D86053986096DA")
        @DSModeled(DSC.SAFE)
        public ServiceState createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            return (ServiceState)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ServiceState(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.612 -0400", hash_original_method = "EC02653A60FC5AF3A9F13EE38C19100C", hash_generated_method = "16BC109F3A2298F36BF8B42D20DB467B")
        @DSModeled(DSC.SAFE)
        public ServiceState[] newArray(int size) {
            dsTaint.addTaint(size);
            return (ServiceState[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ServiceState[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.612 -0400", hash_original_method = "36476E21C74B3827A7B01BE12F666937", hash_generated_method = "16834AC1B3C50160349CA3611BD713CE")
    @DSModeled(DSC.SAFE)
    public ServiceState() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.612 -0400", hash_original_method = "77F46968981D692048E5F6D63AA7A464", hash_generated_method = "B377741AC4D66D2EFD95A43AB0DF6CEC")
    @DSModeled(DSC.SAFE)
    public ServiceState(ServiceState s) {
        dsTaint.addTaint(s.dsTaint);
        copyFrom(s);
        // ---------- Original Method ----------
        //copyFrom(s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.613 -0400", hash_original_method = "E237E117068718AE5F81C4213860014E", hash_generated_method = "AD782A10FF6B7F6FE70C858B287DD9C8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.613 -0400", hash_original_method = "6E7F8FDCB456B5F7602153AE8EC6838E", hash_generated_method = "37AAD6DF9A3A307FA4E62A57169C5DDB")
    public static ServiceState newFromBundle(Bundle m) {
        ServiceState ret;
        ret = new ServiceState();
        ret.setFromNotifierBundle(m);
        return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.613 -0400", hash_original_method = "E04D2A000CEC20636ABEC5ED3DEE444A", hash_generated_method = "A762FA2DFA54B1634152A1673CE0E03A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.613 -0400", hash_original_method = "0314D3363C47B5602718344C30C07D2D", hash_generated_method = "D55AD270B74720D06F1AE4DC7244B020")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.613 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.613 -0400", hash_original_method = "10E9373648D5DF4EE43B4904732E3886", hash_generated_method = "565A28BBBCB152C90FC7199BBB3224AB")
    @DSModeled(DSC.SAFE)
    public int getState() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.613 -0400", hash_original_method = "27B48B56BD1E05F31D9E74CC53E25407", hash_generated_method = "CCAB4D7FFFF9D105C3A71ED0A6144354")
    @DSModeled(DSC.SAFE)
    public boolean getRoaming() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRoaming;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.613 -0400", hash_original_method = "3DFEB66E744CCF30AC3F0251BA213E84", hash_generated_method = "5BBABDF9F5098FD7F698F38B16951E4F")
    @DSModeled(DSC.SAFE)
    public boolean isEmergencyOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsEmergencyOnly;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.613 -0400", hash_original_method = "83FC91D4D13183AA7E425917DAA84866", hash_generated_method = "25674B3F9620A94FE0B73FCE68C97A2F")
    @DSModeled(DSC.SAFE)
    public int getCdmaRoamingIndicator() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mCdmaRoamingIndicator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.613 -0400", hash_original_method = "66A4F6EB11ADB385A490C7939EB92055", hash_generated_method = "E28AC27558912B981F1FF91CFB2926AD")
    @DSModeled(DSC.SAFE)
    public int getCdmaDefaultRoamingIndicator() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mCdmaDefaultRoamingIndicator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.613 -0400", hash_original_method = "A86147562C8C2CE9187BA7AFC3028DA0", hash_generated_method = "9C13C3BA660FC43408BFD1ABFAA53ADC")
    @DSModeled(DSC.SAFE)
    public int getCdmaEriIconIndex() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mCdmaEriIconIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.614 -0400", hash_original_method = "637A5E08A8AA09E09B00A7308F96EA32", hash_generated_method = "FE2C60354FB1A15B1A6991F011125960")
    @DSModeled(DSC.SAFE)
    public int getCdmaEriIconMode() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mCdmaEriIconMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.614 -0400", hash_original_method = "550CF77EB1CEA79355B2985E6B5A4349", hash_generated_method = "C920D1612B0BF186E9D67BC9BC3C93EB")
    @DSModeled(DSC.SAFE)
    public String getOperatorAlphaLong() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mOperatorAlphaLong;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.614 -0400", hash_original_method = "86619391C7B398160E7B9E543643DBB4", hash_generated_method = "63EEDDD7A40688C6E031EC3D8351AD0C")
    @DSModeled(DSC.SAFE)
    public String getOperatorAlphaShort() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mOperatorAlphaShort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.614 -0400", hash_original_method = "608E7A84F718D26C8A9F8E19A83C0931", hash_generated_method = "D04919BCDB0448B03E1C54CFC16A587D")
    @DSModeled(DSC.SAFE)
    public String getOperatorNumeric() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mOperatorNumeric;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.617 -0400", hash_original_method = "233C7A13AF785DA7BC75C18AF3C8DB71", hash_generated_method = "8D556714B9BFE3C1E2AA5074AEC66216")
    @DSModeled(DSC.SAFE)
    public boolean getIsManualSelection() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsManualNetworkSelection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.618 -0400", hash_original_method = "4FC9291B326FDF96318315E16F56658C", hash_generated_method = "144060A8EAF6BC2EADF60D446A2C135F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var17E1E702D83D8892539663C4B4794A68_496243556 = (((mState * 0x1234)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.618 -0400", hash_original_method = "5AB9F404C745D33B000995514C8414B5", hash_generated_method = "B74C76EADFCE28312B7C12BDF344F88D")
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
        boolean varEE276B99C43E5154F1BACA397993F41B_1756734954 = ((mState == s.mState
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.618 -0400", hash_original_method = "1F98B5A7DF8A473B65EF18728E66E33F", hash_generated_method = "3342564FB32C3524D4DD0EC8938A96C6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.618 -0400", hash_original_method = "8261C946B0851B9612BB2224B1BDDEEE", hash_generated_method = "7F942603F279392D18386335C31A8ECA")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.619 -0400", hash_original_method = "8ACC80A7889D35C4C641DEE09D896F76", hash_generated_method = "1E6B2CB33CE89396672DC250293F38D8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.619 -0400", hash_original_method = "638BC09D981AD6B06693C47D3D967201", hash_generated_method = "850664D49ADAF485DE5A4C1CB0F004F4")
    @DSModeled(DSC.SAFE)
    public void setStateOutOfService() {
        setNullState(STATE_OUT_OF_SERVICE);
        // ---------- Original Method ----------
        //setNullState(STATE_OUT_OF_SERVICE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.619 -0400", hash_original_method = "D9FAF4EA3D294E58217DAB74F17C0351", hash_generated_method = "BC9292BE673321D6B30A5735D658C0D0")
    @DSModeled(DSC.SAFE)
    public void setStateOff() {
        setNullState(STATE_POWER_OFF);
        // ---------- Original Method ----------
        //setNullState(STATE_POWER_OFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.619 -0400", hash_original_method = "B2257FFBD3B79161D70D00C92F5BABD5", hash_generated_method = "8E5A339AD07F38798F59EF0C31ECF053")
    @DSModeled(DSC.SAFE)
    public void setState(int state) {
        dsTaint.addTaint(state);
        // ---------- Original Method ----------
        //mState = state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.619 -0400", hash_original_method = "78DC27B1781D6001A1042BE9E193D14B", hash_generated_method = "269AC869921E3A57930EF27DC9731EA5")
    @DSModeled(DSC.SAFE)
    public void setRoaming(boolean roaming) {
        dsTaint.addTaint(roaming);
        // ---------- Original Method ----------
        //mRoaming = roaming;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.619 -0400", hash_original_method = "B2BA3AF9B92E65EA8B062AC201A0C0F0", hash_generated_method = "9E9F137DC3461D8015731E5F8750AEA5")
    @DSModeled(DSC.SAFE)
    public void setEmergencyOnly(boolean emergencyOnly) {
        dsTaint.addTaint(emergencyOnly);
        // ---------- Original Method ----------
        //mIsEmergencyOnly = emergencyOnly;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.619 -0400", hash_original_method = "C5CC061ACF011623DDFD13C5F3F99CC3", hash_generated_method = "E3E6B1636BD3DC1ACD4A142B6DC349F0")
    @DSModeled(DSC.SAFE)
    public void setCdmaRoamingIndicator(int roaming) {
        dsTaint.addTaint(roaming);
        // ---------- Original Method ----------
        //this.mCdmaRoamingIndicator = roaming;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.619 -0400", hash_original_method = "723EC448C9CB51F7110A335E414C4680", hash_generated_method = "264DF8E6CABA487C8BDC8D656771696D")
    @DSModeled(DSC.SAFE)
    public void setCdmaDefaultRoamingIndicator(int roaming) {
        dsTaint.addTaint(roaming);
        // ---------- Original Method ----------
        //this.mCdmaDefaultRoamingIndicator = roaming;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.619 -0400", hash_original_method = "270DF85E703DBBACE36CF343B8162562", hash_generated_method = "F5CCD018622AFA4344897ADEDEFB6DEA")
    @DSModeled(DSC.SAFE)
    public void setCdmaEriIconIndex(int index) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(index);
        // ---------- Original Method ----------
        //this.mCdmaEriIconIndex = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.619 -0400", hash_original_method = "B583E3E822650F1B5214B53503BF1241", hash_generated_method = "A294B93B9BF77A659EFA1E37AC01AE7E")
    @DSModeled(DSC.SAFE)
    public void setCdmaEriIconMode(int mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mode);
        // ---------- Original Method ----------
        //this.mCdmaEriIconMode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.620 -0400", hash_original_method = "AB95572079513DCF8B19D191A4DD2824", hash_generated_method = "2B4A5E712B6D0135CC900E5B0A1743B9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.620 -0400", hash_original_method = "2932DCDD0502DE94804E9827964069D2", hash_generated_method = "AEBF157F73AA0CE8942FA637501A65D0")
    @DSModeled(DSC.SAFE)
    public void setOperatorAlphaLong(String longName) {
        dsTaint.addTaint(longName);
        // ---------- Original Method ----------
        //mOperatorAlphaLong = longName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.620 -0400", hash_original_method = "C2D18251B53286CEC68F55BEC648A3A6", hash_generated_method = "636766B44A50005C889BAF8AF799619D")
    @DSModeled(DSC.SAFE)
    public void setIsManualSelection(boolean isManual) {
        dsTaint.addTaint(isManual);
        // ---------- Original Method ----------
        //mIsManualNetworkSelection = isManual;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.620 -0400", hash_original_method = "BC145A1DE2472995676ED9A315FB0956", hash_generated_method = "171409CD29A7B7D5AD18DD4C394534AC")
    private static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.620 -0400", hash_original_method = "45F7665F0B17EC4A3962C47A86921C1E", hash_generated_method = "D090245D929EC6D2B3AC4E7D703BA6DB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.620 -0400", hash_original_method = "9BCA23D068820B6DD53DFB45DB9457FF", hash_generated_method = "A5E1F97B010220CA14D20B83475856D2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.620 -0400", hash_original_method = "C012C4DB079EEB33708722C3BF4101EF", hash_generated_method = "EC5F2D836EFC5058D2097D6F7DC3734F")
    @DSModeled(DSC.SAFE)
    public void setRadioTechnology(int state) {
        dsTaint.addTaint(state);
        // ---------- Original Method ----------
        //this.mRadioTechnology = state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.620 -0400", hash_original_method = "C1350CF85A5CAF49D330DF5D8BE50D5D", hash_generated_method = "0E74F9B169A34D3F78FCA9588B5DA709")
    @DSModeled(DSC.SAFE)
    public void setCssIndicator(int css) {
        dsTaint.addTaint(css);
        this.mCssIndicator = (css != 0);
        // ---------- Original Method ----------
        //this.mCssIndicator = (css != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.620 -0400", hash_original_method = "A7D542E3F6857DF89C73ABBE482A1544", hash_generated_method = "8F2B7FC6448E835FF29D2DE6AAA3B3CB")
    @DSModeled(DSC.SAFE)
    public void setSystemAndNetworkId(int systemId, int networkId) {
        dsTaint.addTaint(networkId);
        dsTaint.addTaint(systemId);
        // ---------- Original Method ----------
        //this.mSystemId = systemId;
        //this.mNetworkId = networkId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.621 -0400", hash_original_method = "D4EB1377E20B241083847F14436F60D5", hash_generated_method = "CC794F1E1E943C6D17B49E067CCB6CAD")
    @DSModeled(DSC.SAFE)
    public int getRadioTechnology() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mRadioTechnology;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.621 -0400", hash_original_method = "5F3502ED7337480E1E948E539B84EEE6", hash_generated_method = "4692C1AE1D58C8E863CA4BAC58247C6C")
    @DSModeled(DSC.SAFE)
    public int getCssIndicator() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mCssIndicator ? 1 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.621 -0400", hash_original_method = "909C93F66AD557988A123F548D8C31FC", hash_generated_method = "4FE5BA076D817461E8F44E1D5240DB90")
    @DSModeled(DSC.SAFE)
    public int getNetworkId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mNetworkId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.621 -0400", hash_original_method = "E5E4F22C1EB64E5BA2863333F6C891A3", hash_generated_method = "5AD8FA1F1322B3F6075B5AF1C2C5BB12")
    @DSModeled(DSC.SAFE)
    public int getSystemId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mSystemId;
    }

    
}


