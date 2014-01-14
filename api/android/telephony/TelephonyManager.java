package android.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.List;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;

import com.android.internal.telephony.IPhoneSubInfo;
import com.android.internal.telephony.ITelephony;
import com.android.internal.telephony.ITelephonyRegistry;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneFactory;
import com.android.internal.telephony.TelephonyProperties;

public class TelephonyManager {

    /** @hide
    /* @deprecated - use getSystemService as described above */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.790 -0500", hash_original_method = "4756E71C626071838F541663B9D55856", hash_generated_method = "A0AD3490DD42A596900C87367D4C9808")
    
public static TelephonyManager getDefault() {
        return sInstance;
    }

    /**
     * Return general class of network type, such as "3G" or "4G". In cases
     * where classification is contentious, this method is conservative.
     *
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.087 -0500", hash_original_method = "FF9AEE5B15128D984AF27D921556D2E2", hash_generated_method = "6595A990C2739F8F18B3F0F0727B267C")
    
public static int getNetworkClass(int networkType) {
        switch (networkType) {
            case NETWORK_TYPE_GPRS:
            case NETWORK_TYPE_EDGE:
            case NETWORK_TYPE_CDMA:
            case NETWORK_TYPE_1xRTT:
            case NETWORK_TYPE_IDEN:
                return NETWORK_CLASS_2_G;
            case NETWORK_TYPE_UMTS:
            case NETWORK_TYPE_EVDO_0:
            case NETWORK_TYPE_EVDO_A:
            case NETWORK_TYPE_HSDPA:
            case NETWORK_TYPE_HSUPA:
            case NETWORK_TYPE_HSPA:
            case NETWORK_TYPE_EVDO_B:
            case NETWORK_TYPE_EHRPD:
            case NETWORK_TYPE_HSPAP:
                return NETWORK_CLASS_3_G;
            case NETWORK_TYPE_LTE:
                return NETWORK_CLASS_4_G;
            default:
                return NETWORK_CLASS_UNKNOWN;
        }
    }

    /** {@hide} */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.099 -0500", hash_original_method = "16F509F126A872299A1C262559222D5E", hash_generated_method = "A6761E784015C0E03C3DD0D41D1E2EED")
    
public static String getNetworkTypeName(int type) {
        switch (type) {
            case NETWORK_TYPE_GPRS:
                return "GPRS";
            case NETWORK_TYPE_EDGE:
                return "EDGE";
            case NETWORK_TYPE_UMTS:
                return "UMTS";
            case NETWORK_TYPE_HSDPA:
                return "HSDPA";
            case NETWORK_TYPE_HSUPA:
                return "HSUPA";
            case NETWORK_TYPE_HSPA:
                return "HSPA";
            case NETWORK_TYPE_CDMA:
                return "CDMA";
            case NETWORK_TYPE_EVDO_0:
                return "CDMA - EvDo rev. 0";
            case NETWORK_TYPE_EVDO_A:
                return "CDMA - EvDo rev. A";
            case NETWORK_TYPE_EVDO_B:
                return "CDMA - EvDo rev. B";
            case NETWORK_TYPE_1xRTT:
                return "CDMA - 1xRTT";
            case NETWORK_TYPE_LTE:
                return "LTE";
            case NETWORK_TYPE_EHRPD:
                return "CDMA - eHRPD";
            case NETWORK_TYPE_IDEN:
                return "iDEN";
            case NETWORK_TYPE_HSPAP:
                return "HSPA+";
            default:
                return "UNKNOWN";
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.739 -0500", hash_original_field = "E78A2F6C254983780CF19276F7D66042", hash_generated_field = "FED661308A0D1EFA713B1ED05D1D257D")

    private static final String TAG = "TelephonyManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.746 -0500", hash_original_field = "CEF70F4829B188D89E37229D281B99F4", hash_generated_field = "BB35128711B5DD286691A47454B04C39")

    private static Context sContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.752 -0500", hash_original_field = "6F494F2F02C51FFE18E7119824439D93", hash_generated_field = "582B8A11F267D0FC2F0A8BFE9E1B0E41")

    private static ITelephonyRegistry sRegistry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.774 -0500", hash_original_field = "168BF9201624300441BE6F41CBD9ECC0", hash_generated_field = "255012CF538DDDD1C9746B5789864EE9")

    private static TelephonyManager sInstance = new TelephonyManager();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.798 -0500", hash_original_field = "C2148C54676B07A6995FF9653FF27F9F", hash_generated_field = "36AA3BD8CCFDC1F68C412E68D6A42804")

    // Broadcast Intent actions
    //

    /**
     * Broadcast intent action indicating that the call state (cellular)
     * on the device has changed.
     *
     * <p>
     * The {@link #EXTRA_STATE} extra indicates the new call state.
     * If the new state is RINGING, a second extra
     * {@link #EXTRA_INCOMING_NUMBER} provides the incoming phone number as
     * a String.
     *
     * <p class="note">
     * Requires the READ_PHONE_STATE permission.
     *
     * <p class="note">
     * This was a {@link android.content.Context#sendStickyBroadcast sticky}
     * broadcast in version 1.0, but it is no longer sticky.
     * Instead, use {@link #getCallState} to synchronously query the current call state.
     *
     * @see #EXTRA_STATE
     * @see #EXTRA_INCOMING_NUMBER
     * @see #getCallState
     */
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PHONE_STATE_CHANGED =
            "android.intent.action.PHONE_STATE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.805 -0500", hash_original_field = "BE5EF6558BB85924A0B78700E6D5AB5E", hash_generated_field = "ECA9CAE1305E7DD998C16171D7CBF2B3")

    public static final String EXTRA_STATE = Phone.STATE_KEY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.813 -0500", hash_original_field = "B57C3230E91FDF584C0A238F1541AD2D", hash_generated_field = "644A2D46020DA7007B4595269AC70D14")

    public static final String EXTRA_STATE_IDLE = Phone.State.IDLE.toString();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.820 -0500", hash_original_field = "6C71EC3FC75BB13632A017F151D06304", hash_generated_field = "5BA124B52973008E7CC271EAC7C7A168")

    public static final String EXTRA_STATE_RINGING = Phone.State.RINGING.toString();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.827 -0500", hash_original_field = "DAF70E5BEBD3937479ED201D17BEB5D2", hash_generated_field = "AB0B945EFBEE7E5F54BE15055E7F173C")

    public static final String EXTRA_STATE_OFFHOOK = Phone.State.OFFHOOK.toString();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.833 -0500", hash_original_field = "C9F371A370D76AD2DBBF42D4B43BC508", hash_generated_field = "A350D7682844B18DAE260769F2227CF5")

    public static final String EXTRA_INCOMING_NUMBER = "incoming_number";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.878 -0500", hash_original_field = "BE7CCB2929536F5E37337438EB3CEA40", hash_generated_field = "78804DFF38A537862AA01355F9EAEE2D")

    public static final int PHONE_TYPE_NONE = Phone.PHONE_TYPE_NONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.885 -0500", hash_original_field = "EF5DAB8C23A656F59014E2DBDFD7ABB8", hash_generated_field = "D056262BD19D9D2B6080E6C65F89AAFE")

    public static final int PHONE_TYPE_GSM = Phone.PHONE_TYPE_GSM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.892 -0500", hash_original_field = "FF8983E8BC732CFA021B31D7C5027EA1", hash_generated_field = "CA3A5930619F40D3AB8D9ED99A87151C")

    public static final int PHONE_TYPE_CDMA = Phone.PHONE_TYPE_CDMA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.899 -0500", hash_original_field = "2F8864B2C063380C89385BFB91DF8BE6", hash_generated_field = "4B9088F6BA66C5DDA4BF5641DA27C4CE")

    public static final int PHONE_TYPE_SIP = Phone.PHONE_TYPE_SIP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.958 -0500", hash_original_field = "65F6D36CE26155FD9EBB59D8A36A90D0", hash_generated_field = "3ADBC2EDBBFD9CFE0BB915AD0B7AB259")

    public static final int NETWORK_TYPE_UNKNOWN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.965 -0500", hash_original_field = "E5A42B01A635460DF4B68698657B8D4A", hash_generated_field = "DF4F111D7D9CAFAE4BFDC86FEE1390B0")

    public static final int NETWORK_TYPE_GPRS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.971 -0500", hash_original_field = "CD19498EA143F1DF206BBAC5848500F9", hash_generated_field = "AFA157BE025D28F2633E52B67F5FF45D")

    public static final int NETWORK_TYPE_EDGE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.978 -0500", hash_original_field = "C1131610D06E3702965468D76F8E0E7A", hash_generated_field = "4EE60A58FF3A6A827BAE8B3660FDDBEA")

    public static final int NETWORK_TYPE_UMTS = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.984 -0500", hash_original_field = "23246F6D01FC4CAA65D629E0E1228308", hash_generated_field = "17247A089138DB194E3C3689EB8D2C09")

    public static final int NETWORK_TYPE_CDMA = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.990 -0500", hash_original_field = "00F08459C9F2791C9CFA7030C2673CA7", hash_generated_field = "7059F2E3BF3949FC65A081A768BD3451")

    public static final int NETWORK_TYPE_EVDO_0 = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.996 -0500", hash_original_field = "0F3D91C92B1233B82C9A060E425E5EFC", hash_generated_field = "7F0F0403315A2164D626A0BC52B06414")

    public static final int NETWORK_TYPE_EVDO_A = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.002 -0500", hash_original_field = "411565879BA9DB00E3AAB0CEAFDBA0D5", hash_generated_field = "CB357E9EDD52F69601CAE2082846D5E3")

    public static final int NETWORK_TYPE_1xRTT = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.008 -0500", hash_original_field = "0066A68B5F7AB9F2FF29EDCCFDB50EDC", hash_generated_field = "89CA7CBDC236075D3DF613C9FF78C239")

    public static final int NETWORK_TYPE_HSDPA = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.014 -0500", hash_original_field = "0446AAE8A9F85A65AB59DCB619302875", hash_generated_field = "A2B013A8B7DBC1B768FDA8801DD88687")

    public static final int NETWORK_TYPE_HSUPA = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.021 -0500", hash_original_field = "BEB65E650BC97C579B530799700A8902", hash_generated_field = "685F9ECE7B6483CF2B967E0CA7312169")

    public static final int NETWORK_TYPE_HSPA = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.027 -0500", hash_original_field = "4394A0BCD77CEA64A0189E574829C51E", hash_generated_field = "60079AE9B8FCBC7ADE140290C5E3832B")

    public static final int NETWORK_TYPE_IDEN = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.033 -0500", hash_original_field = "21066B4DF8EC91A0CBFC1DDAF31AF081", hash_generated_field = "05A463A291C68559D8A2DA4399EC93B8")

    public static final int NETWORK_TYPE_EVDO_B = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.039 -0500", hash_original_field = "35E5E2E9F00D96BFD5A56B7E77334554", hash_generated_field = "897972FB0146052AF9FE6A13C387063A")

    public static final int NETWORK_TYPE_LTE = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.045 -0500", hash_original_field = "11858BDDDE86FC6CF4EB97CB236C5DB5", hash_generated_field = "3B80988B27EA0BE6E633061C7CF1BE85")

    public static final int NETWORK_TYPE_EHRPD = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.051 -0500", hash_original_field = "CB356ADA9DCFAE87D68E2598BF48D944", hash_generated_field = "BD0BA401891F25C620F3110BD2DB15BC")

    public static final int NETWORK_TYPE_HSPAP = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.064 -0500", hash_original_field = "1A47440CE807DA9E65E824FD36B94B51", hash_generated_field = "7C7BEF03A11ED6F5B236D02E3AC76BB3")

    public static final int NETWORK_CLASS_UNKNOWN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.069 -0500", hash_original_field = "24E2C7B9133F108C152CBD7B48AB63EE", hash_generated_field = "952EAD66C73882790E8632EBDE3D0EEB")

    public static final int NETWORK_CLASS_2_G = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.075 -0500", hash_original_field = "D1999BA8C1FD270A3A964031F5A06B4D", hash_generated_field = "16C334B31519B49DB6ACD1DE6C14E392")

    public static final int NETWORK_CLASS_3_G = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.081 -0500", hash_original_field = "8B7CAB488A0949B22E94FBB452920C5B", hash_generated_field = "0D5564D633DC921137687C883E4D0F99")

    public static final int NETWORK_CLASS_4_G = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.105 -0500", hash_original_field = "79C92681D277DA1CE2BC3366A8EF66E8", hash_generated_field = "536F712A44A5C4A5B4EC320A507F030C")

    //
    // SIM Card
    //
    //

    /** SIM card state: Unknown. Signifies that the SIM is in transition
     *  between states. For example, when the user inputs the SIM pin
     *  under PIN_REQUIRED state, a query for sim status returns
     *  this state before turning to SIM_STATE_READY. */
    public static final int SIM_STATE_UNKNOWN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.111 -0500", hash_original_field = "5607F554084763231CFC963DD286C4F1", hash_generated_field = "FE661F33A2994BC3BF316C87CD05115C")

    public static final int SIM_STATE_ABSENT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.117 -0500", hash_original_field = "F72CA1B3BC173CF283286CE09CB45997", hash_generated_field = "6C48EE683A7E78D23C00B92717DE5A22")

    public static final int SIM_STATE_PIN_REQUIRED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.123 -0500", hash_original_field = "D0BF5309F670FADBE2AA7DA247B3DD66", hash_generated_field = "ABE24381CD34E62691DD2C4E93ED4A19")

    public static final int SIM_STATE_PUK_REQUIRED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.129 -0500", hash_original_field = "3FDE15753F3F8DBE6030F9CC600F9A10", hash_generated_field = "6EE0D9233BAFEC27F9B3BFDB79237527")

    public static final int SIM_STATE_NETWORK_LOCKED = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.134 -0500", hash_original_field = "FD6A66749C6B60D817E73C9A03E31BFD", hash_generated_field = "52957824F7E9EFEE70E933C4483F3560")

    public static final int SIM_STATE_READY = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.238 -0500", hash_original_field = "2A6BC04425994A98D3E5E6ABFD903390", hash_generated_field = "880051CE2B272E830BA1E1C9C8EDFDAD")

    public static final int CALL_STATE_IDLE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.245 -0500", hash_original_field = "75ECA88C19EC322E3549ADC2FE6A7692", hash_generated_field = "EBF7E79274B936572A44F5AC97C350E9")

    public static final int CALL_STATE_RINGING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.251 -0500", hash_original_field = "CF933E4CF1588871034C9DF7A42CEE7B", hash_generated_field = "F1553B4E51E8E01AAC1228FBFF50DED7")

    public static final int CALL_STATE_OFFHOOK = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.261 -0500", hash_original_field = "7C7C6F5A008D0DF7BE85D8971C96C54A", hash_generated_field = "6303BB7C9E2B830338C1836586DB6697")

    public static final int DATA_ACTIVITY_NONE = 0x00000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.266 -0500", hash_original_field = "F7D38EC09FB5C2D82FC7CA8AAEF48C70", hash_generated_field = "AC92BAFF5B1AACED092C2AF469A8CBD3")

    public static final int DATA_ACTIVITY_IN = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.272 -0500", hash_original_field = "3E05B91AE02170AEA63C38EEEC09FB7D", hash_generated_field = "63CF83921BA898885E2AD57DC2D97303")

    public static final int DATA_ACTIVITY_OUT = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.278 -0500", hash_original_field = "34D0B34A679232D790D9230CB63930E2", hash_generated_field = "E7682DD7C56FD243525F5233E80F53E4")

    public static final int DATA_ACTIVITY_INOUT = DATA_ACTIVITY_IN | DATA_ACTIVITY_OUT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.285 -0500", hash_original_field = "8657C692CEBAB92F7D1D804E9C88A275", hash_generated_field = "0A134B76AF6D9DF50656A5FE58BE98FF")

    public static final int DATA_ACTIVITY_DORMANT = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.295 -0500", hash_original_field = "BD11926368494120FB898338630DC21B", hash_generated_field = "FF8D51C8FEAAD0B22B077E1A375AC594")

    public static final int DATA_UNKNOWN        = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.301 -0500", hash_original_field = "6FB63E4EB91174AF84F1E0E65D7AC5C8", hash_generated_field = "C4C0880CDDF6725DBFD4E7B67714DE9B")

    public static final int DATA_DISCONNECTED   = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.306 -0500", hash_original_field = "BCCFF6014A533254D161D7ABEF259863", hash_generated_field = "FF9CE223A769E6D3636143EA9AC19C2B")

    public static final int DATA_CONNECTING     = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.312 -0500", hash_original_field = "9D7D1A1BB9F0856E3E8D90F0CCACA5C8", hash_generated_field = "794BB976A412F225595FC4181FE3FC75")

    public static final int DATA_CONNECTED      = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.317 -0500", hash_original_field = "2CF3E819F634983173A5EBF6879DBA56", hash_generated_field = "DC6EB947ED9360ECC33AC98BE7B1AAB6")

    public static final int DATA_SUSPENDED      = 3;
    
    public TelephonyManager(Context context) {
        if (sContext == null) {
            Context appContext = context.getApplicationContext();
            if (appContext != null) {
                sContext = appContext;
            } else {
                sContext = context;
            }
            /*
            sRegistry = ITelephonyRegistry.Stub.asInterface(ServiceManager.getService(
                    "telephony.registry"));
           */
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.767 -0500", hash_original_method = "8E4DE1903A24C15F73A151ACA155A108", hash_generated_method = "4098016423379C34E8ADBEB412A76B9D")
    
private TelephonyManager() {
    }

    //
    //
    // Device Info
    //
    //

    /**
     * Returns the software version number for the device, for example,
     * the IMEI/SV for GSM phones. Return null if the software version is
     * not available.
     *
     * <p>Requires Permission:
     *   {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
     */
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.840 -0500", hash_original_method = "CBA2DB54A66B89F7737C894703CB092B", hash_generated_method = "4B3F28EB7BBCF026D7BC40CDFD72EF88")
    
public String getDeviceSoftwareVersion() {
        try {
            return getSubscriberInfo().getDeviceSvn();
        } catch (RemoteException ex) {
            return null;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    /**
     * Returns the unique device ID, for example, the IMEI for GSM and the MEID
     * or ESN for CDMA phones. Return null if device ID is not available.
     *
     * <p>Requires Permission:
     *   {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
     */
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.846 -0500", hash_original_method = "D15182A782B2311FD9923C2371701B25", hash_generated_method = "EC5736B5E669E36CBA199401F68D88A2")
    
public String getDeviceId() {
        try {
            return getSubscriberInfo().getDeviceId();
        } catch (RemoteException ex) {
            return null;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    /**
     * Returns the current location of the device.
     * Return null if current location is not available.
     *
     * <p>Requires Permission:
     * {@link android.Manifest.permission#ACCESS_COARSE_LOCATION ACCESS_COARSE_LOCATION} or
     * {@link android.Manifest.permission#ACCESS_COARSE_LOCATION ACCESS_FINE_LOCATION}.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.853 -0500", hash_original_method = "5E61A73DD3A54D24C69E0825B273DC95", hash_generated_method = "8456E3874ECABC389A45AB7E1DB5DEB4")
    
public CellLocation getCellLocation() {
        try {
            Bundle bundle = getITelephony().getCellLocation();
            CellLocation cl = CellLocation.newFromBundle(bundle);
            if (cl.isEmpty())
                return null;
            return cl;
        } catch (RemoteException ex) {
            return null;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    /**
     * Enables location update notifications.  {@link PhoneStateListener#onCellLocationChanged
     * PhoneStateListener.onCellLocationChanged} will be called on location updates.
     *
     * <p>Requires Permission: {@link android.Manifest.permission#CONTROL_LOCATION_UPDATES
     * CONTROL_LOCATION_UPDATES}
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.859 -0500", hash_original_method = "6D04BBFB8BC88B77ECB40D44848A65EA", hash_generated_method = "C3391902E936AED3FBB146CD84977AE5")
    
public void enableLocationUpdates() {
        try {
            getITelephony().enableLocationUpdates();
        } catch (RemoteException ex) {
        } catch (NullPointerException ex) {
        }
    }

    /**
     * Disables location update notifications.  {@link PhoneStateListener#onCellLocationChanged
     * PhoneStateListener.onCellLocationChanged} will be called on location updates.
     *
     * <p>Requires Permission: {@link android.Manifest.permission#CONTROL_LOCATION_UPDATES
     * CONTROL_LOCATION_UPDATES}
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.866 -0500", hash_original_method = "3CD4D10099672E02B38D45C520AD59E4", hash_generated_method = "91E0211BE85B991424EA2BF192E06C3D")
    
public void disableLocationUpdates() {
        try {
            getITelephony().disableLocationUpdates();
        } catch (RemoteException ex) {
        } catch (NullPointerException ex) {
        }
    }

    /**
     * Returns the neighboring cell information of the device.
     *
     * @return List of NeighboringCellInfo or null if info unavailable.
     *
     * <p>Requires Permission:
     * (@link android.Manifest.permission#ACCESS_COARSE_UPDATES}
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.872 -0500", hash_original_method = "1B24CD9B4799B0CFE847058C4CF4C5E3", hash_generated_method = "E7AF9314CBB193A5C355EE7B79DD4437")
    
public List<NeighboringCellInfo> getNeighboringCellInfo() {
        try {
            return getITelephony().getNeighboringCellInfo();
        } catch (RemoteException ex) {
            return null;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    /**
     * Returns the current phone type.
     * TODO: This is a last minute change and hence hidden.
     *
     * @see #PHONE_TYPE_NONE
     * @see #PHONE_TYPE_GSM
     * @see #PHONE_TYPE_CDMA
     * @see #PHONE_TYPE_SIP
     *
     * {@hide}
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.906 -0500", hash_original_method = "7EF6D35F0DE2C86E385132A28BC64E8B", hash_generated_method = "FEAD3512309BA280F2B9472016CBE2B5")
    
public int getCurrentPhoneType() {
        try{
            ITelephony telephony = getITelephony();
            if (telephony != null) {
                return telephony.getActivePhoneType();
            } else {
                // This can happen when the ITelephony interface is not up yet.
                return getPhoneTypeFromProperty();
            }
        } catch (RemoteException ex) {
            // This shouldn't happen in the normal case, as a backup we
            // read from the system property.
            return getPhoneTypeFromProperty();
        } catch (NullPointerException ex) {
            // This shouldn't happen in the normal case, as a backup we
            // read from the system property.
            return getPhoneTypeFromProperty();
        }
    }

    /**
     * Returns a constant indicating the device phone type.  This
     * indicates the type of radio used to transmit voice calls.
     *
     * @see #PHONE_TYPE_NONE
     * @see #PHONE_TYPE_GSM
     * @see #PHONE_TYPE_CDMA
     * @see #PHONE_TYPE_SIP
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.912 -0500", hash_original_method = "0A507D7BB3876FB6AE8B7F4B411CB7D0", hash_generated_method = "209F232F05BC666F99D63133A53C0273")
    
public int getPhoneType() {
        if (!isVoiceCapable()) {
            return PHONE_TYPE_NONE;
        }
        return getCurrentPhoneType();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.918 -0500", hash_original_method = "AFA495B3EA5295146DEDE68ACDCEDE97", hash_generated_method = "6BB314B8E3DD871A064B13D3286AA881")
    
private int getPhoneTypeFromProperty() {
        int type =
            SystemProperties.getInt(TelephonyProperties.CURRENT_ACTIVE_PHONE,
                    getPhoneTypeFromNetworkType());
        return type;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.928 -0500", hash_original_method = "64BB8AD229481F016ED315B563697438", hash_generated_method = "C759AF23EEC4E0F4CE5744A480AA5ECD")
    
private int getPhoneTypeFromNetworkType() {
        // When the system property CURRENT_ACTIVE_PHONE, has not been set,
        // use the system property for default network type.
        // This is a fail safe, and can only happen at first boot.
        int mode = SystemProperties.getInt("ro.telephony.default_network", -1);
        if (mode == -1)
            return PHONE_TYPE_NONE;
        return PhoneFactory.getPhoneType(mode);
    }
    //
    //
    // Current Network
    //
    //

    /**
     * Returns the alphabetic name of current registered operator.
     * <p>
     * Availability: Only when user is registered to a network. Result may be
     * unreliable on CDMA networks (use {@link #getPhoneType()} to determine if
     * on a CDMA network).
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.935 -0500", hash_original_method = "832612984320BCC9B2F167CB90709724", hash_generated_method = "672EA881CE48DF4044DDF5A0EF8FB5E1")
    
public String getNetworkOperatorName() {
        return SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ALPHA);
    }

    /**
     * Returns the numeric name (MCC+MNC) of current registered operator.
     * <p>
     * Availability: Only when user is registered to a network. Result may be
     * unreliable on CDMA networks (use {@link #getPhoneType()} to determine if
     * on a CDMA network).
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.941 -0500", hash_original_method = "C6C0AA4A9611C88887AD0284C9B9779A", hash_generated_method = "5F651E5454C364F70695229B3B5F8920")
    
public String getNetworkOperator() {
        return SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC);
    }

    /**
     * Returns true if the device is considered roaming on the current
     * network, for GSM purposes.
     * <p>
     * Availability: Only when user registered to a network.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.946 -0500", hash_original_method = "B6A17594C3960A6046C8BF4D54C6D185", hash_generated_method = "C91E1A33144C8380907E54D251A06FAA")
    
public boolean isNetworkRoaming() {
        return "true".equals(SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISROAMING));
    }

    /**
     * Returns the ISO country code equivalent of the current registered
     * operator's MCC (Mobile Country Code).
     * <p>
     * Availability: Only when user is registered to a network. Result may be
     * unreliable on CDMA networks (use {@link #getPhoneType()} to determine if
     * on a CDMA network).
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.952 -0500", hash_original_method = "DDFD7BDCC0E0CF0AD038335E60C4F613", hash_generated_method = "0A7F58F540543DB55415BB62138DB372")
    
public String getNetworkCountryIso() {
        return SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY);
    }

    /**
     * Returns a constant indicating the radio technology (network type)
     * currently in use on the device for data transmission.
     * @return the network type
     *
     * @see #NETWORK_TYPE_UNKNOWN
     * @see #NETWORK_TYPE_GPRS
     * @see #NETWORK_TYPE_EDGE
     * @see #NETWORK_TYPE_UMTS
     * @see #NETWORK_TYPE_HSDPA
     * @see #NETWORK_TYPE_HSUPA
     * @see #NETWORK_TYPE_HSPA
     * @see #NETWORK_TYPE_CDMA
     * @see #NETWORK_TYPE_EVDO_0
     * @see #NETWORK_TYPE_EVDO_A
     * @see #NETWORK_TYPE_EVDO_B
     * @see #NETWORK_TYPE_1xRTT
     * @see #NETWORK_TYPE_IDEN
     * @see #NETWORK_TYPE_LTE
     * @see #NETWORK_TYPE_EHRPD
     * @see #NETWORK_TYPE_HSPAP
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.057 -0500", hash_original_method = "E55284324A887F7771FC58B52617EFF6", hash_generated_method = "E3D747BC90735F4578869FF651020079")
    
public int getNetworkType() {
        try{
            ITelephony telephony = getITelephony();
            if (telephony != null) {
                return telephony.getNetworkType();
            } else {
                // This can happen when the ITelephony interface is not up yet.
                return NETWORK_TYPE_UNKNOWN;
            }
        } catch(RemoteException ex) {
            // This shouldn't happen in the normal case
            return NETWORK_TYPE_UNKNOWN;
        } catch (NullPointerException ex) {
            // This could happen before phone restarts due to crashing
            return NETWORK_TYPE_UNKNOWN;
        }
    }

    /**
     * Returns a string representation of the radio technology (network type)
     * currently in use on the device.
     * @return the name of the radio technology
     *
     * @hide pending API council review
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.092 -0500", hash_original_method = "2CF054408BF0643DB5F15627D9964227", hash_generated_method = "A19480A3C59628EF195ADFC2376BBE31")
    
public String getNetworkTypeName() {
        return getNetworkTypeName(getNetworkType());
    }

    /**
     * @return true if a ICC card is present
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.139 -0500", hash_original_method = "B54BEBEEDA1D514B6ED30035D8F7A17F", hash_generated_method = "94056A5527CA13EC18D88D7F54E966B4")
    
public boolean hasIccCard() {
        try {
            return getITelephony().hasIccCard();
        } catch (RemoteException ex) {
            // Assume no ICC card if remote exception which shouldn't happen
            return false;
        } catch (NullPointerException ex) {
            // This could happen before phone restarts due to crashing
            return false;
        }
    }

    /**
     * Returns a constant indicating the state of the
     * device SIM card.
     *
     * @see #SIM_STATE_UNKNOWN
     * @see #SIM_STATE_ABSENT
     * @see #SIM_STATE_PIN_REQUIRED
     * @see #SIM_STATE_PUK_REQUIRED
     * @see #SIM_STATE_NETWORK_LOCKED
     * @see #SIM_STATE_READY
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.145 -0500", hash_original_method = "09E0380F50AC76521F62251E25C950EA", hash_generated_method = "CE608D46AECF2BEE5A33124C8812763F")
    
public int getSimState() {
        String prop = SystemProperties.get(TelephonyProperties.PROPERTY_SIM_STATE);
        if ("ABSENT".equals(prop)) {
            return SIM_STATE_ABSENT;
        }
        else if ("PIN_REQUIRED".equals(prop)) {
            return SIM_STATE_PIN_REQUIRED;
        }
        else if ("PUK_REQUIRED".equals(prop)) {
            return SIM_STATE_PUK_REQUIRED;
        }
        else if ("NETWORK_LOCKED".equals(prop)) {
            return SIM_STATE_NETWORK_LOCKED;
        }
        else if ("READY".equals(prop)) {
            return SIM_STATE_READY;
        }
        else {
            return SIM_STATE_UNKNOWN;
        }
    }

    /**
     * Returns the MCC+MNC (mobile country code + mobile network code) of the
     * provider of the SIM. 5 or 6 decimal digits.
     * <p>
     * Availability: SIM state must be {@link #SIM_STATE_READY}
     *
     * @see #getSimState
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.150 -0500", hash_original_method = "31C6D14DB3E72FC3C1A0B120DB42F405", hash_generated_method = "8BCF1599F401E43ADA81847C5B34982D")
    
public String getSimOperator() {
        return SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC);
    }

    /**
     * Returns the Service Provider Name (SPN).
     * <p>
     * Availability: SIM state must be {@link #SIM_STATE_READY}
     *
     * @see #getSimState
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.155 -0500", hash_original_method = "FF7B2BB8165B4DA3F4CA04B0E402231E", hash_generated_method = "7FB69BE64001A3D1A9BEF5F7FBCD4CAB")
    
public String getSimOperatorName() {
        return SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA);
    }

    /**
     * Returns the ISO country code equivalent for the SIM provider's country code.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.160 -0500", hash_original_method = "86E21142AD28646E6483CDE3D9BD89F9", hash_generated_method = "2C6B56621FE6DB5CA7D229252A67A40A")
    
public String getSimCountryIso() {
        return SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY);
    }

    /**
     * Returns the serial number of the SIM, if applicable. Return null if it is
     * unavailable.
     * <p>
     * Requires Permission:
     *   {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
     */
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.166 -0500", hash_original_method = "2017CBA66707D72E2F76A9954FAEDD18", hash_generated_method = "E95EBC17FC14D391B501F19C429D7A92")
    
public String getSimSerialNumber() {
        try {
            return getSubscriberInfo().getIccSerialNumber();
        } catch (RemoteException ex) {
            return null;
        } catch (NullPointerException ex) {
            // This could happen before phone restarts due to crashing
            return null;
        }
    }

    /**
     * Return if the current radio is LTE on CDMA. This
     * is a tri-state return value as for a period of time
     * the mode may be unknown.
     *
     * @return {@link Phone#LTE_ON_CDMA_UNKNOWN}, {@link Phone#LTE_ON_CDMA_FALSE}
     * or {@link Phone#LTE_ON_CDMA_TRUE}
     *
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.172 -0500", hash_original_method = "EA3A591F5FC8CB370CDC207E1A4A9D6A", hash_generated_method = "32B4ED8038DC54553745D813FCE5C023")
    
public int getLteOnCdmaMode() {
        try {
            return getITelephony().getLteOnCdmaMode();
        } catch (RemoteException ex) {
            // Assume no ICC card if remote exception which shouldn't happen
            return Phone.LTE_ON_CDMA_UNKNOWN;
        } catch (NullPointerException ex) {
            // This could happen before phone restarts due to crashing
            return Phone.LTE_ON_CDMA_UNKNOWN;
        }
    }

    //
    //
    // Subscriber Info
    //
    //

    /**
     * Returns the unique subscriber ID, for example, the IMSI for a GSM phone.
     * Return null if it is unavailable.
     * <p>
     * Requires Permission:
     *   {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
     */
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.176 -0500", hash_original_method = "E78B911A34E3B997234FCD2FE0581326", hash_generated_method = "EF06E0A4123D41A5131FC5BAE98F1805")
    
public String getSubscriberId() {
        try {
            return getSubscriberInfo().getSubscriberId();
        } catch (RemoteException ex) {
            return null;
        } catch (NullPointerException ex) {
            // This could happen before phone restarts due to crashing
            return null;
        }
    }

    /**
     * Returns the phone number string for line 1, for example, the MSISDN
     * for a GSM phone. Return null if it is unavailable.
     * <p>
     * Requires Permission:
     *   {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
     */
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.181 -0500", hash_original_method = "EE92449D081C56B70CB6173E1BAAB538", hash_generated_method = "614F1ED5FB9AEA69175D3301C79A05B3")
    
public String getLine1Number() {
        try {
            return getSubscriberInfo().getLine1Number();
        } catch (RemoteException ex) {
            return null;
        } catch (NullPointerException ex) {
            // This could happen before phone restarts due to crashing
            return null;
        }
    }

    /**
     * Returns the alphabetic identifier associated with the line 1 number.
     * Return null if it is unavailable.
     * <p>
     * Requires Permission:
     *   {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
     * @hide
     * nobody seems to call this.
     */
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.187 -0500", hash_original_method = "7B70034F9FC00AD85A334A6B1881279C", hash_generated_method = "3834A5B6D7235DDEF33C1A530C09F387")
    
public String getLine1AlphaTag() {
        try {
            return getSubscriberInfo().getLine1AlphaTag();
        } catch (RemoteException ex) {
            return null;
        } catch (NullPointerException ex) {
            // This could happen before phone restarts due to crashing
            return null;
        }
    }

    /**
     * Returns the MSISDN string.
     * for a GSM phone. Return null if it is unavailable.
     * <p>
     * Requires Permission:
     *   {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
     *
     * @hide
     */
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.192 -0500", hash_original_method = "FE1089A80F0C63E9B1494FCF93B412E1", hash_generated_method = "B4170A6221EF104C900C9FD31335166A")
    
public String getMsisdn() {
        try {
            return getSubscriberInfo().getMsisdn();
        } catch (RemoteException ex) {
            return null;
        } catch (NullPointerException ex) {
            // This could happen before phone restarts due to crashing
            return null;
        }
    }

    /**
     * Returns the voice mail number. Return null if it is unavailable.
     * <p>
     * Requires Permission:
     *   {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
     */
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.197 -0500", hash_original_method = "8E528B053F49E44E27934FB8B1D79754", hash_generated_method = "C92B62E70A7614CEFA650212DCB845E4")
    
public String getVoiceMailNumber() {
        try {
            return getSubscriberInfo().getVoiceMailNumber();
        } catch (RemoteException ex) {
            return null;
        } catch (NullPointerException ex) {
            // This could happen before phone restarts due to crashing
            return null;
        }
    }

    /**
     * Returns the complete voice mail number. Return null if it is unavailable.
     * <p>
     * Requires Permission:
     *   {@link android.Manifest.permission#CALL_PRIVILEGED CALL_PRIVILEGED}
     *
     * @hide
     */
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.202 -0500", hash_original_method = "6E4CD5DF61F1B6B4D99C4D48EBD42C25", hash_generated_method = "222CD2AB53F1EB0A64D3B3A6D0B0B82C")
    
public String getCompleteVoiceMailNumber() {
        try {
            return getSubscriberInfo().getCompleteVoiceMailNumber();
        } catch (RemoteException ex) {
            return null;
        } catch (NullPointerException ex) {
            // This could happen before phone restarts due to crashing
            return null;
        }
    }

    /**
     * Returns the voice mail count. Return 0 if unavailable.
     * <p>
     * Requires Permission:
     *   {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.207 -0500", hash_original_method = "8799C29F83D6241F3339A57C480A2568", hash_generated_method = "E5740134B1823260FAD1CC0568B3B22C")
    
public int getVoiceMessageCount() {
        try {
            return getITelephony().getVoiceMessageCount();
        } catch (RemoteException ex) {
            return 0;
        } catch (NullPointerException ex) {
            // This could happen before phone restarts due to crashing
            return 0;
        }
    }

    /**
     * Retrieves the alphabetic identifier associated with the voice
     * mail number.
     * <p>
     * Requires Permission:
     *   {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
     */
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.213 -0500", hash_original_method = "FCB9C7AA008FFD71198739B23DB8A42C", hash_generated_method = "EFA7073DC9C2570EE5531A941C4524C7")
    
public String getVoiceMailAlphaTag() {
        try {
            return getSubscriberInfo().getVoiceMailAlphaTag();
        } catch (RemoteException ex) {
            return null;
        } catch (NullPointerException ex) {
            // This could happen before phone restarts due to crashing
            return null;
        }
    }

    /**
     * Returns the IMS private user identity (IMPI) that was loaded from the ISIM.
     * @return the IMPI, or null if not present or not loaded
     * @hide
     */
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.218 -0500", hash_original_method = "2827FC9BCC152817C9894DF874687A19", hash_generated_method = "A3EE07A3EEABAF912AB4C7241F97969B")
    
public String getIsimImpi() {
        try {
            return getSubscriberInfo().getIsimImpi();
        } catch (RemoteException ex) {
            return null;
        } catch (NullPointerException ex) {
            // This could happen before phone restarts due to crashing
            return null;
        }
    }

    /**
     * Returns the IMS home network domain name that was loaded from the ISIM.
     * @return the IMS domain name, or null if not present or not loaded
     * @hide
     */
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.223 -0500", hash_original_method = "F4F2A7557A78EB2E07FE0C129F86CDF8", hash_generated_method = "98BCC71DB72EAD629D771B1C58D2D522")
    
public String getIsimDomain() {
        try {
            return getSubscriberInfo().getIsimDomain();
        } catch (RemoteException ex) {
            return null;
        } catch (NullPointerException ex) {
            // This could happen before phone restarts due to crashing
            return null;
        }
    }

    /**
     * Returns the IMS public user identities (IMPU) that were loaded from the ISIM.
     * @return an array of IMPU strings, with one IMPU per string, or null if
     *      not present or not loaded
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.228 -0500", hash_original_method = "87EA21FFDB592BB220CD2250977D3D81", hash_generated_method = "624218E871D88DF362B812B664CB12F3")
    
public String[] getIsimImpu() {
        try {
            return getSubscriberInfo().getIsimImpu();
        } catch (RemoteException ex) {
            return null;
        } catch (NullPointerException ex) {
            // This could happen before phone restarts due to crashing
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.233 -0500", hash_original_method = "0499CDF49B310038A9BEEA0F802EAB63", hash_generated_method = "1DC4804D8392A597FEECC0EE6EE070BB")
    
private IPhoneSubInfo getSubscriberInfo() {
        // get it each time because that process crashes a lot
        return IPhoneSubInfo.Stub.asInterface(ServiceManager.getService("iphonesubinfo"));
    }

    /**
     * Returns a constant indicating the call state (cellular) on the device.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.256 -0500", hash_original_method = "74E55F6F5CD1551C04A2C40DCD1EBD15", hash_generated_method = "948CE01916B7B2925AC03958AADAA000")
    
public int getCallState() {
        try {
            return getITelephony().getCallState();
        } catch (RemoteException ex) {
            // the phone process is restarting.
            return CALL_STATE_IDLE;
        } catch (NullPointerException ex) {
          // the phone process is restarting.
          return CALL_STATE_IDLE;
      }
    }

    /**
     * Returns a constant indicating the type of activity on a data connection
     * (cellular).
     *
     * @see #DATA_ACTIVITY_NONE
     * @see #DATA_ACTIVITY_IN
     * @see #DATA_ACTIVITY_OUT
     * @see #DATA_ACTIVITY_INOUT
     * @see #DATA_ACTIVITY_DORMANT
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.290 -0500", hash_original_method = "59E4B9880A04B49AB5E7CF82F18425E1", hash_generated_method = "23C559F761F833FD07960D57214B29B6")
    
public int getDataActivity() {
        try {
            return getITelephony().getDataActivity();
        } catch (RemoteException ex) {
            // the phone process is restarting.
            return DATA_ACTIVITY_NONE;
        } catch (NullPointerException ex) {
          // the phone process is restarting.
          return DATA_ACTIVITY_NONE;
      }
    }

    /**
     * Returns a constant indicating the current data connection state
     * (cellular).
     *
     * @see #DATA_DISCONNECTED
     * @see #DATA_CONNECTING
     * @see #DATA_CONNECTED
     * @see #DATA_SUSPENDED
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.323 -0500", hash_original_method = "37205A4CB7441E0871F6B86EF9BDA019", hash_generated_method = "03295D49837EC74F2BB726B50B6F324F")
    
public int getDataState() {
        try {
            return getITelephony().getDataState();
        } catch (RemoteException ex) {
            // the phone process is restarting.
            return DATA_DISCONNECTED;
        } catch (NullPointerException ex) {
            return DATA_DISCONNECTED;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.328 -0500", hash_original_method = "7D101ED42BB684AED8CB9AC1B352231C", hash_generated_method = "CC0FA3E85FCC5F3458CE2B3B809EB12D")
    
private ITelephony getITelephony() {
        return ITelephony.Stub.asInterface(ServiceManager.getService(Context.TELEPHONY_SERVICE));
    }
    
    public void listen(PhoneStateListener listener, int events) {/* removed for compilation
        String pkgForDebug = sContext != null ? sContext.getPackageName() : "<unknown>";
        try {
            Boolean notifyNow = (getITelephony() != null);
            sRegistry.listen(pkgForDebug, listener.callback, events, notifyNow);
        } catch (RemoteException ex) {
            // system process dead
        } catch (NullPointerException ex) {
            // system process dead
            }*/
    }

    /**
     * Returns the CDMA ERI icon index to display
     *
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.338 -0500", hash_original_method = "94E639A6342206A666A9E9E564D3D41F", hash_generated_method = "6D80711F8A350F00805ED30C8073A1C6")
    
public int getCdmaEriIconIndex() {
        try {
            return getITelephony().getCdmaEriIconIndex();
        } catch (RemoteException ex) {
            // the phone process is restarting.
            return -1;
        } catch (NullPointerException ex) {
            return -1;
        }
    }

    /**
     * Returns the CDMA ERI icon mode,
     * 0 - ON
     * 1 - FLASHING
     *
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.343 -0500", hash_original_method = "6E310C99A0183EA336ABBF86E9A26569", hash_generated_method = "741CFF34A81E7FB38EF61F13C57054EB")
    
public int getCdmaEriIconMode() {
        try {
            return getITelephony().getCdmaEriIconMode();
        } catch (RemoteException ex) {
            // the phone process is restarting.
            return -1;
        } catch (NullPointerException ex) {
            return -1;
        }
    }

    /**
     * Returns the CDMA ERI text,
     *
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.348 -0500", hash_original_method = "70A8AFAFA7F0416F83BF728E9A3EFD1C", hash_generated_method = "D02A3BC8470C61B34765C107FD6420E7")
    
public String getCdmaEriText() {
        try {
            return getITelephony().getCdmaEriText();
        } catch (RemoteException ex) {
            // the phone process is restarting.
            return null;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    /**
     * @return true if the current device is "voice capable".
     * <p>
     * "Voice capable" means that this device supports circuit-switched
     * (i.e. voice) phone calls over the telephony network, and is allowed
     * to display the in-call UI while a cellular voice call is active.
     * This will be false on "data only" devices which can't make voice
     * calls and don't support any in-call UI.
     * <p>
     * Note: the meaning of this flag is subtly different from the
     * PackageManager.FEATURE_TELEPHONY system feature, which is available
     * on any device with a telephony radio, even if the device is
     * data-only.
     *
     * @hide pending API review
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.354 -0500", hash_original_method = "691764E468F6F648007F4B86271FE09B", hash_generated_method = "0A662AE5BA1F48BBD563E24A5E323AB4")
    
public boolean isVoiceCapable() {
        if (sContext == null) return true;
        return sContext.getResources().getBoolean(
                com.android.internal.R.bool.config_voice_capable);
    }

    /**
     * @return true if the current device supports sms service.
     * <p>
     * If true, this means that the device supports both sending and
     * receiving sms via the telephony network.
     * <p>
     * Note: Voicemail waiting sms, cell broadcasting sms, and MMS are
     *       disabled when device doesn't support sms.
     *
     * @hide pending API review
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:45.358 -0500", hash_original_method = "FA08C86737C7918898577956B7BAC60B", hash_generated_method = "EC6E189A4CC3209116A478022E852E6D")
    
public boolean isSmsCapable() {
        if (sContext == null) return true;
        return sContext.getResources().getBoolean(
                com.android.internal.R.bool.config_sms_capable);
    }
}

