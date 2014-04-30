package android.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class ServiceState implements Parcelable {

    /**
     * Create a new ServiceState from a intent notifier Bundle
     *
     * This method is used by PhoneStateIntentReceiver and maybe by
     * external applications.
     *
     * @param m Bundle from intent notifier
     * @return newly created ServiceState
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.172 -0500", hash_original_method = "6E7F8FDCB456B5F7602153AE8EC6838E", hash_generated_method = "37AAD6DF9A3A307FA4E62A57169C5DDB")
    
public static ServiceState newFromBundle(Bundle m) {
        ServiceState ret;
        ret = new ServiceState();
        ret.setFromNotifierBundle(m);
        return ret;
    }

    /**
     * Convert radio technology to String
     *
     * @param radioTechnology
     * @return String representation of the RAT
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.247 -0500", hash_original_method = "1F98B5A7DF8A473B65EF18728E66E33F", hash_generated_method = "3342564FB32C3524D4DD0EC8938A96C6")
    
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

    /**
     * Test whether two objects hold the same data values or both are null.
     *
     * @param a first obj
     * @param b second obj
     * @return true if two objects equal or both are null
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.293 -0500", hash_original_method = "BC145A1DE2472995676ED9A315FB0956", hash_generated_method = "171409CD29A7B7D5AD18DD4C394534AC")
    
private static boolean equalsHandlesNulls (Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.035 -0500", hash_original_field = "F4446E751DD7D5E85FE650192A5E7AE4", hash_generated_field = "90DFE6F4299DB554E753A7D7707C6EC5")

    static final String LOG_TAG = "PHONE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.039 -0500", hash_original_field = "91145666AB18F7D872AA197E89F2E164", hash_generated_field = "D4DA810B4309B0137A4C6CA6DD383CFC")

    public static final int STATE_IN_SERVICE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.042 -0500", hash_original_field = "137B7E1190703C9A7C4F01F0DFD57772", hash_generated_field = "6165D29D905D19750F0A9DE22A8A53C2")

    public static final int STATE_OUT_OF_SERVICE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.045 -0500", hash_original_field = "C47339BE108F5549BC339D43398781D4", hash_generated_field = "433D04CF22E8C23923507689C0477A99")

    public static final int STATE_EMERGENCY_ONLY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.049 -0500", hash_original_field = "C227E79790015B43321D815C3BBD85EF", hash_generated_field = "18C40DF24AF984CE9874FCC6875A6343")

    public static final int STATE_POWER_OFF = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.052 -0500", hash_original_field = "AE9470DA82A0EBC535D5F8B254B6C872", hash_generated_field = "073774D0E0B3B4C0BC93F4FC47BDC640")

    /** @hide */
    public static final int RADIO_TECHNOLOGY_UNKNOWN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.055 -0500", hash_original_field = "ABC22599F07A3ADBA3F7964624F4128C", hash_generated_field = "53DCC682B5BBB9CB75BA97796B6561BB")

    public static final int RADIO_TECHNOLOGY_GPRS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.059 -0500", hash_original_field = "56552077F3A7BB23089B2AD5FE643851", hash_generated_field = "5121DC59CF8D156F977EF7336A301147")

    public static final int RADIO_TECHNOLOGY_EDGE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.062 -0500", hash_original_field = "2C5A928C009997823E807E3D513D6A6C", hash_generated_field = "0BA1F4B56C3B9BE3C2DA28D833330E22")

    public static final int RADIO_TECHNOLOGY_UMTS = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.066 -0500", hash_original_field = "09360C6E7F6AD197B491F8E7F5080762", hash_generated_field = "0516074D7A82B12EB0195842FAE4AA93")

    public static final int RADIO_TECHNOLOGY_IS95A = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.069 -0500", hash_original_field = "BAE663ABB74ED9F17EB3E2130258474F", hash_generated_field = "FA32FC0EB67EB73FF6D37F90F71F2BE9")

    public static final int RADIO_TECHNOLOGY_IS95B = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.072 -0500", hash_original_field = "AE1F63233D961D4F44B95A29F710B197", hash_generated_field = "66F083504B1C50230E428A2D44E6EAE8")

    public static final int RADIO_TECHNOLOGY_1xRTT = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.076 -0500", hash_original_field = "AB1645B69F972563AA4D06CB16990E61", hash_generated_field = "138AB1199C355BEEBF16B22133EDD699")

    public static final int RADIO_TECHNOLOGY_EVDO_0 = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.079 -0500", hash_original_field = "12A071B41E64CB74C5A3F1B2E861FBEF", hash_generated_field = "AE4AC5BF82EAD16952B8A2F30BA99473")

    public static final int RADIO_TECHNOLOGY_EVDO_A = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.083 -0500", hash_original_field = "58B0A6C5D97F329C61AC8E2E2975AAF5", hash_generated_field = "45E9F5C5A9A8C6710E88D5C13A6AA5CF")

    public static final int RADIO_TECHNOLOGY_HSDPA = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.086 -0500", hash_original_field = "EA98BBE3CC7019592D6D95247D14E76E", hash_generated_field = "8C916E1E972FAC33F453251906BB8618")

    public static final int RADIO_TECHNOLOGY_HSUPA = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.090 -0500", hash_original_field = "3E6C438A9ADD79431507BB81FABFB12A", hash_generated_field = "0F990CDC0C2D85778ED991166928E3F8")

    public static final int RADIO_TECHNOLOGY_HSPA = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.093 -0500", hash_original_field = "F04C2E1B9CF4A5B57F1F4C906AA2664A", hash_generated_field = "57BEAE7316A82F5B4FDA5AC5B1D0BA04")

    public static final int RADIO_TECHNOLOGY_EVDO_B = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.096 -0500", hash_original_field = "2BA26B5A408BBA565E53079A4ACC932A", hash_generated_field = "5468C0680D39ACC0465B47E045D6B87A")

    public static final int RADIO_TECHNOLOGY_EHRPD = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.100 -0500", hash_original_field = "2D299ABCFD5EB4AEA8CADAFC2444AD5D", hash_generated_field = "B333A72E9303D6192C5A5F65A354E0A7")

    public static final int RADIO_TECHNOLOGY_LTE = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.103 -0500", hash_original_field = "D7039F17C006B38A2753411C657DEBF2", hash_generated_field = "0DF2145AB4059C4274A4A33D95DEEEC3")

    public static final int RADIO_TECHNOLOGY_HSPAP = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.106 -0500", hash_original_field = "EB87BD7771CB5C799B329BF7CFC8DD58", hash_generated_field = "A988B65CD531264C07313ACE1BB311BF")

    /** @hide */
    public static final int REGISTRATION_STATE_NOT_REGISTERED_AND_NOT_SEARCHING = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.110 -0500", hash_original_field = "583CF2F2CAB4BC68D706F960EFC55EA6", hash_generated_field = "C717A5D9CF6EE32D24A631EC9B6FE25B")

    public static final int REGISTRATION_STATE_HOME_NETWORK = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.114 -0500", hash_original_field = "42F7F9641F435DB4FA982B3EE6C85136", hash_generated_field = "7BE02B1F7C64616DF35D4FF714C54BEB")

    public static final int REGISTRATION_STATE_NOT_REGISTERED_AND_SEARCHING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.117 -0500", hash_original_field = "F5EEC4B9504FD343C36A6023C1E9BA94", hash_generated_field = "9D96B09C8D1C9077BD74743C9DD9D3B1")

    public static final int REGISTRATION_STATE_REGISTRATION_DENIED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.120 -0500", hash_original_field = "E1BB0B4EDC35D7B614D0BD9662A00973", hash_generated_field = "4D4527A5261773B620CB1F75A5825BDF")

    public static final int REGISTRATION_STATE_UNKNOWN = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.123 -0500", hash_original_field = "A2A676D70C625B9AE460684C571ABA6E", hash_generated_field = "5DEAE742B946B04BF20D07D152314109")

    public static final int REGISTRATION_STATE_ROAMING = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.549 -0400", hash_original_field = "2BABBC683D40DD9B077BB89204C6FFF8", hash_generated_field = "26E35B0BD5EE8B6AA0A817986D304020")

    public static final Parcelable.Creator<ServiceState> CREATOR =
            new Parcelable.Creator<ServiceState>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.197 -0500", hash_original_method = "8CB2CF1085CE8B72C4A34EE92896EB72", hash_generated_method = "B25977DFF69AD999F6142B6D8C68A27E")
        
public ServiceState createFromParcel(Parcel in) {
            return new ServiceState(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.199 -0500", hash_original_method = "EC02653A60FC5AF3A9F13EE38C19100C", hash_generated_method = "B2C9FD1AB385D5E5AA1D753BC0E21F86")
        
public ServiceState[] newArray(int size) {
            return new ServiceState[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.127 -0500", hash_original_field = "C14776D1C836D0E963F3F09F9928F141", hash_generated_field = "F60690C16A904EA5E0E01BA5DAB95D57")

    private int mState = STATE_OUT_OF_SERVICE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.130 -0500", hash_original_field = "443BCEF3EEBE54B39D5E3E92FF87E1E4", hash_generated_field = "02055DCC177C93D9A52A736D58C166FD")

    private boolean mRoaming;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.132 -0500", hash_original_field = "F070343C1D389B0EA88A97E58F6C86AE", hash_generated_field = "728600C6907FD62C9C9028803BDD260B")

    private String mOperatorAlphaLong;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.136 -0500", hash_original_field = "805D4F49FEA40A614748807F4CDBE672", hash_generated_field = "F4F9F83BCAA92805A0BB009F68ED6C5A")

    private String mOperatorAlphaShort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.139 -0500", hash_original_field = "50435CB95FD42AFC6425FE29C47D98B1", hash_generated_field = "7893BD126D717D1D8D6ABD0FF8E0AD30")

    private String mOperatorNumeric;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.142 -0500", hash_original_field = "7AC63706E0543C78693471F966AB2A26", hash_generated_field = "BFC5A115AB0CEA3AEFC065878943AA07")

    private boolean mIsManualNetworkSelection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.145 -0500", hash_original_field = "E215E34359029F23BEE387597286299A", hash_generated_field = "17239629CA9846328F98C386EA8B54F9")

    private boolean mIsEmergencyOnly;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.148 -0500", hash_original_field = "46D422AD1DCC805B97FA6603FE275902", hash_generated_field = "379C3FB6918D9CCD707AC84835B3C555")

    private int mRadioTechnology;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.151 -0500", hash_original_field = "413A7B9BBBE23A1546C6FFC094F94C22", hash_generated_field = "88C8AAE6E96FE73CBCA20071BE474E4F")

    private boolean mCssIndicator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.154 -0500", hash_original_field = "35D9C3886ADE4E969F0372275377C2D8", hash_generated_field = "7A5A39D03C1616F994D4D06922BB67CA")

    private int mNetworkId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.157 -0500", hash_original_field = "F9196D24BC9605AF858C36A8631E2909", hash_generated_field = "C8F6488FFC51AAE029241A3B484EA04F")

    private int mSystemId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.160 -0500", hash_original_field = "41EA00DAB7BF7C2AC94D0B2DFB1A4004", hash_generated_field = "C6E763F1BBE4C6A164F28127EDC3B603")

    private int mCdmaRoamingIndicator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.163 -0500", hash_original_field = "4B4BB686CEEEAB83A0D74CEAEDA67C62", hash_generated_field = "34026AB57B68A48734A85797E3F4BF65")

    private int mCdmaDefaultRoamingIndicator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.165 -0500", hash_original_field = "2AEB50DBEDA7A9E1C8A122FCEC43E162", hash_generated_field = "72D211FC0E1391121ACC384DA733167F")

    private int mCdmaEriIconIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.168 -0500", hash_original_field = "B72C7E4145A0BC67FFB3120F53CC882B", hash_generated_field = "3596AD8B1E2941E9C5CC4FA8BF8A2655")

    private int mCdmaEriIconMode;

    /**
     * Empty constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.176 -0500", hash_original_method = "36476E21C74B3827A7B01BE12F666937", hash_generated_method = "E1C15B4F542AD467405E97DA0D1B729E")
    
public ServiceState() {
    }

    /**
     * Copy constructors
     *
     * @param s Source service state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.180 -0500", hash_original_method = "77F46968981D692048E5F6D63AA7A464", hash_generated_method = "02CF1EB6C301739F911877F5F666CDEE")
    
public ServiceState(ServiceState s) {
        copyFrom(s);
    }

    /**
     * Construct a ServiceState object from the given parcel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.186 -0500", hash_original_method = "E237E117068718AE5F81C4213860014E", hash_generated_method = "EC8549F6CD04C333D2B4BB4092FBBE60")
    
public ServiceState(Parcel in) {
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.183 -0500", hash_original_method = "E04D2A000CEC20636ABEC5ED3DEE444A", hash_generated_method = "AA0D5F8A025AB81FD723076F70E18FC7")
    
protected void copyFrom(ServiceState s) {
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.190 -0500", hash_original_method = "0314D3363C47B5602718344C30C07D2D", hash_generated_method = "070CAE174F56D6D3B4C1E01CD5AA5B94")
    
public void writeToParcel(Parcel out, int flags) {
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.193 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /**
     * Get current service state of phone
     *
     * @see #STATE_IN_SERVICE
     * @see #STATE_OUT_OF_SERVICE
     * @see #STATE_EMERGENCY_ONLY
     * @see #STATE_POWER_OFF
     */
    @DSSpec(DSCat.PHONE_STATE)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.206 -0500", hash_original_method = "10E9373648D5DF4EE43B4904732E3886", hash_generated_method = "4C50D1866B5E804CF0B05EFBD6788B97")
    
public int getState() {
        return mState;
    }

    /**
     * Get current roaming indicator of phone
     * (note: not just decoding from TS 27.007 7.2)
     *
     * @return true if TS 27.007 7.2 roaming is true
     *              and ONS is different from SPN
     *
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.209 -0500", hash_original_method = "27B48B56BD1E05F31D9E74CC53E25407", hash_generated_method = "CC0583C9CA1287F8D242AB48312C845D")
    
public boolean getRoaming() {
        return mRoaming;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.212 -0500", hash_original_method = "3DFEB66E744CCF30AC3F0251BA213E84", hash_generated_method = "3FFB84B91DBDF94C8DDD59D3A6C8895D")
    
public boolean isEmergencyOnly() {
        return mIsEmergencyOnly;
    }

    /**
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.215 -0500", hash_original_method = "83FC91D4D13183AA7E425917DAA84866", hash_generated_method = "55CDB0D2B5EECF7B91A4F3482629015C")
    
public int getCdmaRoamingIndicator(){
        return this.mCdmaRoamingIndicator;
    }

    /**
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.218 -0500", hash_original_method = "66A4F6EB11ADB385A490C7939EB92055", hash_generated_method = "02B13842F295C9D0F74173E0177EC54D")
    
public int getCdmaDefaultRoamingIndicator(){
        return this.mCdmaDefaultRoamingIndicator;
    }

    /**
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.221 -0500", hash_original_method = "A86147562C8C2CE9187BA7AFC3028DA0", hash_generated_method = "815BDCF6E5DD57192CA54D7505B8BC0B")
    
public int getCdmaEriIconIndex() {
        return this.mCdmaEriIconIndex;
    }

    /**
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.224 -0500", hash_original_method = "637A5E08A8AA09E09B00A7308F96EA32", hash_generated_method = "F017A7B00345E00DDEAEF7841A32DBF4")
    
public int getCdmaEriIconMode() {
        return this.mCdmaEriIconMode;
    }

    /**
     * Get current registered operator name in long alphanumeric format.
     *
     * In GSM/UMTS, long format can be up to 16 characters long.
     * In CDMA, returns the ERI text, if set. Otherwise, returns the ONS.
     *
     * @return long name of operator, null if unregistered or unknown
     */
    @DSSpec(DSCat.PHONE_STATE)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.227 -0500", hash_original_method = "550CF77EB1CEA79355B2985E6B5A4349", hash_generated_method = "DCCAC5F4BADF15C4277416570E2E2717")
    
public String getOperatorAlphaLong() {
        return mOperatorAlphaLong;
    }

    /**
     * Get current registered operator name in short alphanumeric format.
     *
     * In GSM/UMTS, short format can be up to 8 characters long.
     *
     * @return short name of operator, null if unregistered or unknown
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.230 -0500", hash_original_method = "86619391C7B398160E7B9E543643DBB4", hash_generated_method = "362808BE7F7349D19E875163AF7F8F42")
    
public String getOperatorAlphaShort() {
        return mOperatorAlphaShort;
    }

    /**
     * Get current registered operator numeric id.
     *
     * In GSM/UMTS, numeric format is 3 digit country code plus 2 or 3 digit
     * network code.
     *
     * @return numeric format of operator, null if unregistered or unknown
     */
    /*
     * The country code can be decoded using
     * {@link com.android.internal.telephony.MccTable#countryCodeForMcc(int)}.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.233 -0500", hash_original_method = "608E7A84F718D26C8A9F8E19A83C0931", hash_generated_method = "F97365A18373FE64A7A630F546A3515D")
    
public String getOperatorNumeric() {
        return mOperatorNumeric;
    }

    /**
     * Get current network selection mode.
     *
     * @return true if manual mode, false if automatic mode
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.236 -0500", hash_original_method = "233C7A13AF785DA7BC75C18AF3C8DB71", hash_generated_method = "2372D1A6AC89F39DC0E4479843C88867")
    
public boolean getIsManualSelection() {
        return mIsManualNetworkSelection;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.239 -0500", hash_original_method = "4FC9291B326FDF96318315E16F56658C", hash_generated_method = "F9EFFECF731973F7E348F99BB27D2AC8")
    
@Override
    public int hashCode() {
        return ((mState * 0x1234)
                + (mRoaming ? 1 : 0)
                + (mIsManualNetworkSelection ? 1 : 0)
                + ((null == mOperatorAlphaLong) ? 0 : mOperatorAlphaLong.hashCode())
                + ((null == mOperatorAlphaShort) ? 0 : mOperatorAlphaShort.hashCode())
                + ((null == mOperatorNumeric) ? 0 : mOperatorNumeric.hashCode())
                + mCdmaRoamingIndicator
                + mCdmaDefaultRoamingIndicator
                + (mIsEmergencyOnly ? 1 : 0));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.242 -0500", hash_original_method = "5AB9F404C745D33B000995514C8414B5", hash_generated_method = "A336175F8CFA90A35992C40CC699E5E8")
    
@Override
    public boolean equals (Object o) {
        ServiceState s;

        try {
            s = (ServiceState) o;
        } catch (ClassCastException ex) {
            return false;
        }

        if (o == null) {
            return false;
        }

        return (mState == s.mState
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
                && mIsEmergencyOnly == s.mIsEmergencyOnly);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.250 -0500", hash_original_method = "8261C946B0851B9612BB2224B1BDDEEE", hash_generated_method = "5C0308D8B835085CC67933DCD6C0B9DC")
    
@Override
    public String toString() {
        String radioTechnology = radioTechnologyToString(mRadioTechnology);

        return (mState + " " + (mRoaming ? "roaming" : "home")
                + " " + mOperatorAlphaLong
                + " " + mOperatorAlphaShort
                + " " + mOperatorNumeric
                + " " + (mIsManualNetworkSelection ? "(manual)" : "")
                + " " + radioTechnology
                + " " + (mCssIndicator ? "CSS supported" : "CSS not supported")
                + " " + mNetworkId
                + " " + mSystemId
                + " RoamInd=" + mCdmaRoamingIndicator
                + " DefRoamInd=" + mCdmaDefaultRoamingIndicator
                + " EmergOnly=" + mIsEmergencyOnly);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.255 -0500", hash_original_method = "8ACC80A7889D35C4C641DEE09D896F76", hash_generated_method = "16CC1D863B940F520A00568F6F3AF0E1")
    
private void setNullState(int state) {
        mState = state;
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
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.257 -0500", hash_original_method = "638BC09D981AD6B06693C47D3D967201", hash_generated_method = "21E4A4D79A1C93CE54CD6D427D0A66D5")
    
public void setStateOutOfService() {
        setNullState(STATE_OUT_OF_SERVICE);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.260 -0500", hash_original_method = "D9FAF4EA3D294E58217DAB74F17C0351", hash_generated_method = "75B629D0CE1D03D4AE5A4B7656F6E5F5")
    
public void setStateOff() {
        setNullState(STATE_POWER_OFF);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.263 -0500", hash_original_method = "B2257FFBD3B79161D70D00C92F5BABD5", hash_generated_method = "EFE99E2A60D45952DF5CBB378D53BB18")
    
public void setState(int state) {
        mState = state;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.266 -0500", hash_original_method = "78DC27B1781D6001A1042BE9E193D14B", hash_generated_method = "FC867E2D0ECA34C157EDC50CE3759EC5")
    
public void setRoaming(boolean roaming) {
        mRoaming = roaming;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.269 -0500", hash_original_method = "B2BA3AF9B92E65EA8B062AC201A0C0F0", hash_generated_method = "D70314BD45620FBB689B7B6FDC58D3DB")
    
public void setEmergencyOnly(boolean emergencyOnly) {
        mIsEmergencyOnly = emergencyOnly;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.272 -0500", hash_original_method = "C5CC061ACF011623DDFD13C5F3F99CC3", hash_generated_method = "5655247251BEC416FFBCB5A90D324A24")
    
public void setCdmaRoamingIndicator(int roaming) {
        this.mCdmaRoamingIndicator = roaming;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.275 -0500", hash_original_method = "723EC448C9CB51F7110A335E414C4680", hash_generated_method = "6EA4AFF73D6D25E200CA900DA6FCCA32")
    
public void setCdmaDefaultRoamingIndicator (int roaming) {
        this.mCdmaDefaultRoamingIndicator = roaming;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.278 -0500", hash_original_method = "270DF85E703DBBACE36CF343B8162562", hash_generated_method = "0065A6517EE1735BAF3C08D6606E967F")
    
public void setCdmaEriIconIndex(int index) {
        this.mCdmaEriIconIndex = index;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.281 -0500", hash_original_method = "B583E3E822650F1B5214B53503BF1241", hash_generated_method = "475DD30F27855D9C9DA293A29B07C9F7")
    
public void setCdmaEriIconMode(int mode) {
        this.mCdmaEriIconMode = mode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.284 -0500", hash_original_method = "AB95572079513DCF8B19D191A4DD2824", hash_generated_method = "CC764FB0B2FF3E0EFF7120173EE3F4C6")
    
public void setOperatorName(String longName, String shortName, String numeric) {
        mOperatorAlphaLong = longName;
        mOperatorAlphaShort = shortName;
        mOperatorNumeric = numeric;
    }

    /**
     * In CDMA, mOperatorAlphaLong can be set from the ERI text.
     * This is done from the CDMAPhone and not from the CdmaServiceStateTracker.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.286 -0500", hash_original_method = "2932DCDD0502DE94804E9827964069D2", hash_generated_method = "77F89177E23479CBB694A1718BC34E63")
    
public void setOperatorAlphaLong(String longName) {
        mOperatorAlphaLong = longName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.289 -0500", hash_original_method = "C2D18251B53286CEC68F55BEC648A3A6", hash_generated_method = "739442EE45971D3560C54D288D858414")
    
public void setIsManualSelection(boolean isManual) {
        mIsManualNetworkSelection = isManual;
    }

    /**
     * Set ServiceState based on intent notifier map.
     *
     * @param m intent notifier map
     * @hide
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.296 -0500", hash_original_method = "45F7665F0B17EC4A3962C47A86921C1E", hash_generated_method = "83187F5C478428947D78544D1672D3CA")
    
private void setFromNotifierBundle(Bundle m) {
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
    }

    /**
     * Set intent notifier Bundle based on service state.
     *
     * @param m intent notifier Bundle
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.300 -0500", hash_original_method = "9BCA23D068820B6DD53DFB45DB9457FF", hash_generated_method = "4DCAA6F929DA376DF7A4284EEB73B52E")
    
public void fillInNotifierBundle(Bundle m) {
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
    }

    //***** CDMA
    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.303 -0500", hash_original_method = "C012C4DB079EEB33708722C3BF4101EF", hash_generated_method = "2E6B87B0AC11A4E1547C807B79A8DF9F")
    
public void setRadioTechnology(int state) {
        this.mRadioTechnology = state;
    }

    /** @hide */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.306 -0500", hash_original_method = "C1350CF85A5CAF49D330DF5D8BE50D5D", hash_generated_method = "B0FC9535B19CE7C5DAC57DB8CB8A30B7")
    
public void setCssIndicator(int css) {
        this.mCssIndicator = (css != 0);
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.309 -0500", hash_original_method = "A7D542E3F6857DF89C73ABBE482A1544", hash_generated_method = "F2A58B351C0D5013A47FA51F9E28301B")
    
public void setSystemAndNetworkId(int systemId, int networkId) {
        this.mSystemId = systemId;
        this.mNetworkId = networkId;
    }

    /** @hide */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.312 -0500", hash_original_method = "D4EB1377E20B241083847F14436F60D5", hash_generated_method = "6EEB42EC4DDC5EDA4ECEC65062412920")
    
public int getRadioTechnology() {
        return this.mRadioTechnology;
    }

    /** @hide */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.315 -0500", hash_original_method = "5F3502ED7337480E1E948E539B84EEE6", hash_generated_method = "161CF8434587677DABD0ECD505F5A2EA")
    
public int getCssIndicator() {
        return this.mCssIndicator ? 1 : 0;
    }

    /** @hide */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.318 -0500", hash_original_method = "909C93F66AD557988A123F548D8C31FC", hash_generated_method = "3C8DAA33B7EF9A3BB4D25A7A63500EE0")
    
public int getNetworkId() {
        return this.mNetworkId;
    }

    /** @hide */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:54.321 -0500", hash_original_method = "E5E4F22C1EB64E5BA2863333F6C891A3", hash_generated_method = "318DA97F6722F5CBE558371991B6EC9C")
    
public int getSystemId() {
        return this.mSystemId;
    }
    // orphaned legacy method
    public ServiceState createFromParcel(Parcel in) {
            return new ServiceState(in);
        }
    
    // orphaned legacy method
    public ServiceState[] newArray(int size) {
            return new ServiceState[size];
        }
    
}

