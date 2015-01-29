package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

import android.app.ActivityManagerNative;
import android.app.IActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.net.wifi.WifiManager;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RegistrantList;
import android.os.SystemProperties;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.telephony.ServiceState;
import android.text.TextUtils;
import android.util.Log;

import com.android.internal.R;
import com.android.internal.telephony.gsm.UsimServiceTable;
import com.android.internal.telephony.ims.IsimRecords;
import com.android.internal.telephony.test.SimulatedRadioControl;

public abstract class PhoneBase extends Handler implements Phone {

    /**
     * Common error logger method for unexpected calls to CDMA-only methods.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.722 -0500", hash_original_method = "5895E0F86D6993EE4A5D0827268FD313", hash_generated_method = "45BE346C5C047BF18D7AEBD9932E3EB9")
    
private static void logUnexpectedCdmaMethodCall(String name)
    {
        Log.e(LOG_TAG, "Error! " + name + "() in PhoneBase should not be " +
                "called, CDMAPhone inactive.");
    }

    /**
     * Common error logger method for unexpected calls to GSM/WCDMA-only methods.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.727 -0500", hash_original_method = "AD520BE59382A2059D08B3D3D1300653", hash_generated_method = "F781D30AB7A8E1058AC9D8944D576049")
    
private static void logUnexpectedGsmMethodCall(String name) {
        Log.e(LOG_TAG, "Error! " + name + "() in PhoneBase should not be " +
                "called, GSMPhone inactive.");
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.228 -0500", hash_original_field = "F4446E751DD7D5E85FE650192A5E7AE4", hash_generated_field = "4A57918A348D50A14B9C302A7B5E80AE")

    private static final String LOG_TAG = "PHONE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.231 -0500", hash_original_field = "8F859C7BC8BA9F3C885E9F7F5FE6F39E", hash_generated_field = "F62F4824E5D90C8C9780C2AB171AAEE3")

    private static final boolean LOCAL_DEBUG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.233 -0500", hash_original_field = "3AF75CEC0306CC7CC71CCB74E9EB3D9E", hash_generated_field = "30999E1536B998C0CCCADFCA2E186A73")

    public static final String NETWORK_SELECTION_KEY = "network_selection_key";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.235 -0500", hash_original_field = "5D632F848145CE317FDD05AD57D2A1E6", hash_generated_field = "4D95278747E96EA0717A9759EEFCE875")

    public static final String NETWORK_SELECTION_NAME_KEY = "network_selection_name_key";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.238 -0500", hash_original_field = "6AB34D59703118EE6BDD5C01E2B7F87C", hash_generated_field = "CFD39C473C87BFA4C5B1110D352F768C")

    public static final String DATA_DISABLED_ON_BOOT_KEY = "disabled_on_boot_key";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.241 -0500", hash_original_field = "F4FC90376B14FC702EDDAA7CF08A18D2", hash_generated_field = "F58D8D37E826F12A67E2A3F288013066")

    protected static final int EVENT_RADIO_AVAILABLE             = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.243 -0500", hash_original_field = "F14BE7202D62A027165F4E156CDD0410", hash_generated_field = "914F5932DA87031C3BD38F173AD82C6C")

    protected static final int EVENT_SSN                         = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.246 -0500", hash_original_field = "2FA815C87C810885238A0E0EC33AF57C", hash_generated_field = "9B6C9718F0C8C627151CE283AB5AB3C2")

    protected static final int EVENT_SIM_RECORDS_LOADED          = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.249 -0500", hash_original_field = "12D3C284CE3B6982EA05249B60622349", hash_generated_field = "CFD312476C2A4C418231A8C9824FB332")

    protected static final int EVENT_MMI_DONE                    = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.251 -0500", hash_original_field = "422B8D15983D56ABD2CF4EB55D5433B7", hash_generated_field = "411538EAFB0AB12810979C6A4B3D08EA")

    protected static final int EVENT_RADIO_ON                    = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.255 -0500", hash_original_field = "D5F78D32C21A3DF84407A4ECD496685B", hash_generated_field = "A9FE15AC0003E179C4D212C4A530D275")

    protected static final int EVENT_GET_BASEBAND_VERSION_DONE   = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.257 -0500", hash_original_field = "C867AB621FE6A5BA918A7DD830B15D82", hash_generated_field = "3E57A8B14586139C14EA8450AD43475D")

    protected static final int EVENT_USSD                        = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.260 -0500", hash_original_field = "DBA06349BACF12B45D6D0F961D3DF19F", hash_generated_field = "29A355AF2121A0E9E4E7253B2E0856DC")

    protected static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE  = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.262 -0500", hash_original_field = "CC681AE1B0F5BA3B17F128ABD3DD0E68", hash_generated_field = "2CBF0A719C2EB443AB09CD6CBC65F370")

    protected static final int EVENT_GET_IMEI_DONE               = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.265 -0500", hash_original_field = "973446F28BAE0527240B91B3B716B726", hash_generated_field = "F67A856F5863C22B88E923DCB07E66DD")

    protected static final int EVENT_GET_IMEISV_DONE             = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.268 -0500", hash_original_field = "BC2A907B8D209BEC800454D6FB542F3E", hash_generated_field = "3D4A99BE365809A5EB1E511AD6BB5B53")

    protected static final int EVENT_GET_SIM_STATUS_DONE         = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.271 -0500", hash_original_field = "D94DB32664FE973425B2247D41CB2E45", hash_generated_field = "DB3857DB2D26E19635E63A8698AC1EF9")

    protected static final int EVENT_SET_CALL_FORWARD_DONE       = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.274 -0500", hash_original_field = "6A066E7AD04F3DF33B6E8BF1AF0FE3BC", hash_generated_field = "97F3C1FF5F112F459B560C8BD4FBD0DD")

    protected static final int EVENT_GET_CALL_FORWARD_DONE       = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.276 -0500", hash_original_field = "37D2FB39B148064A995297CA8D2C1AA0", hash_generated_field = "8C959D0AE67E3090BAF042BF196FC32E")

    protected static final int EVENT_CALL_RING                   = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.279 -0500", hash_original_field = "3AF9DA192D56B114C214652D5DA9B6F9", hash_generated_field = "8999C19E2089FB0CACED02CBFCC703E9")

    protected static final int EVENT_CALL_RING_CONTINUE          = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.281 -0500", hash_original_field = "6386FE653C0175D40DB2B5A2B8F8B474", hash_generated_field = "D1920332392EF7C47688F70C5AA7584E")

    // we can save the values.
    protected static final int EVENT_SET_NETWORK_MANUAL_COMPLETE    = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.284 -0500", hash_original_field = "F17180DC905B50812A3ED01EF0762619", hash_generated_field = "1870B5B507D5E8786B16A58E221DD746")

    protected static final int EVENT_SET_NETWORK_AUTOMATIC_COMPLETE = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.287 -0500", hash_original_field = "54322BAC3783E8B66945E30C42366664", hash_generated_field = "FD21C21324B661C6024ED1187C7875E6")

    protected static final int EVENT_SET_CLIR_COMPLETE              = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.290 -0500", hash_original_field = "98B3907855D93C47FC60BA1A65892414", hash_generated_field = "81455D0AA37A30A4A32EC86BBBBBED44")

    protected static final int EVENT_REGISTERED_TO_NETWORK          = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.293 -0500", hash_original_field = "0CC2A71B1BB72FDAD6CCF33DF2CEF1B9", hash_generated_field = "075B4E9B1E591EA88F80A50CF77DB9EF")

    protected static final int EVENT_SET_VM_NUMBER_DONE             = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.295 -0500", hash_original_field = "74F2142A837DD469CD1D85A52C8D92D7", hash_generated_field = "92C4385C14905F645AF238D78D5E792E")

    protected static final int EVENT_GET_DEVICE_IDENTITY_DONE       = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.298 -0500", hash_original_field = "CEAC7E412177FB182EFC4FAC72E84B54", hash_generated_field = "15D1C2EE172DF30CB817174BCF200282")

    protected static final int EVENT_RUIM_RECORDS_LOADED            = 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.301 -0500", hash_original_field = "227E01D5A0B3836E16EC51538B36FB24", hash_generated_field = "CEC5A5A926313E5BA6C82EC3BBD42934")

    protected static final int EVENT_NV_READY                       = 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.303 -0500", hash_original_field = "D7F0FA02498911185144A14D9759D74A", hash_generated_field = "DE3F8C6D550D91C6EE475636A277AB01")

    protected static final int EVENT_SET_ENHANCED_VP                = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.306 -0500", hash_original_field = "0FBEC1202F38DDADE990901160399411", hash_generated_field = "8BB3FE9B4018C1F340AE0CD3F8D2A7A2")

    protected static final int EVENT_EMERGENCY_CALLBACK_MODE_ENTER  = 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.309 -0500", hash_original_field = "8BE26B55D6B443A4621399573950A145", hash_generated_field = "F0E3A8092FBCD429DAB23C8999220D9D")

    protected static final int EVENT_EXIT_EMERGENCY_CALLBACK_RESPONSE = 26;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.312 -0500", hash_original_field = "348E797FDEF5CEF4801B5F3998A2F7DB", hash_generated_field = "9A1A5B75F1AB4B2786E10ADC52774587")

    public static final String CLIR_KEY = "clir_key";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.314 -0500", hash_original_field = "32F1164AC10FA708F9D7538403572D09", hash_generated_field = "23F928F88F407C390580E9819551272F")

    public static final String DNS_SERVER_CHECK_DISABLED_KEY = "dns_server_check_disabled_key";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.317 -0500", hash_original_field = "EAEF1CB084A589584AD85062F49626AA", hash_generated_field = "0AC6FF61658A415C5960AD3646988614")

    public CommandsInterface mCM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.319 -0500", hash_original_field = "EDF9FD023E3EC405801399BC9A3FA1A5", hash_generated_field = "198CC7CC33D8E2C02C5C9590CB5AD311")

    protected IccFileHandler mIccFileHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.321 -0500", hash_original_field = "8A6DB45685594C6B3CA56D072EAE88A2", hash_generated_field = "8A6DB45685594C6B3CA56D072EAE88A2")

    boolean mDnsCheckDisabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.324 -0500", hash_original_field = "E7877F04C397F8E0819ED20A3796CF35", hash_generated_field = "12EFF52E123F190477A6BAA0D7E8BFC7")

    public DataConnectionTracker mDataConnectionTracker;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.327 -0500", hash_original_field = "7012C269E9F9BA8E17E0D6E257D14593", hash_generated_field = "7012C269E9F9BA8E17E0D6E257D14593")

    boolean mDoesRilSendMultipleCallRing;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.329 -0500", hash_original_field = "6DF77C84901D61F939B98BC5F13EC488", hash_generated_field = "6DF77C84901D61F939B98BC5F13EC488")

    int mCallRingContinueToken;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.331 -0500", hash_original_field = "8B2C85FE062C8E1E1BE9A9671BFD773E", hash_generated_field = "8B2C85FE062C8E1E1BE9A9671BFD773E")

    int mCallRingDelay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.333 -0500", hash_original_field = "299EA3F874F34A3E5DE0F57E2E70327D", hash_generated_field = "7AC2DAF64A3A2115F12FB6B4AC4A0E0E")

    public boolean mIsTheCurrentActivePhone = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.336 -0500", hash_original_field = "5B4D36755C5058654DC5817A0531A0FC", hash_generated_field = "5B4D36755C5058654DC5817A0531A0FC")

    boolean mIsVoiceCapable = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.338 -0500", hash_original_field = "B60FC624535C672B435037929B1B89ED", hash_generated_field = "373EB9ACD432C91447EB4C9C52571686")

    public IccRecords mIccRecords;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.340 -0500", hash_original_field = "E0B97767FED7FCADBCF9913F2AB42D0E", hash_generated_field = "FDCA805CE2E645965D8424F392885596")

    public IccCard mIccCard;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.344 -0500", hash_original_field = "40C5FE763CD0DA8792343485D3B16A35", hash_generated_field = "FFF9200D373C7FEFEF20A4999EB8139A")

    public SmsStorageMonitor mSmsStorageMonitor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.346 -0500", hash_original_field = "B88437611BF4E79FB598B275895AAF70", hash_generated_field = "7806E0DA87D41123DEDBE3D402001152")

    public SmsUsageMonitor mSmsUsageMonitor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.348 -0500", hash_original_field = "05202A019E2B8080A62E7346181FA81B", hash_generated_field = "1CCDFDF0949A05986349192A62052DA8")

    public SMSDispatcher mSMS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.353 -0500", hash_original_field = "890FBCA3520C5B41328ABFA0F40A6A1A", hash_generated_field = "54C243033BEBCE89872AA38C79850516")

    protected final RegistrantList mPreciseCallStateRegistrants
            = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.356 -0500", hash_original_field = "2B043E8701967485D8AAC80C41E4E11A", hash_generated_field = "101691E4380D6E13B925179B8832B960")

    protected final RegistrantList mNewRingingConnectionRegistrants
            = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.358 -0500", hash_original_field = "2866F7DF86FD508F173D18388D8F6B4E", hash_generated_field = "716CB74230EA386C1645F6ADE899B5ED")

    protected final RegistrantList mIncomingRingRegistrants
            = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.362 -0500", hash_original_field = "2A36E7E42A6C5E501AB46004AB875EF8", hash_generated_field = "21C4CB3D67106CE269A374EF938B2488")

    protected final RegistrantList mDisconnectRegistrants
            = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.364 -0500", hash_original_field = "CCC27A61B9920925658995D1CBEFFC05", hash_generated_field = "CCBE3B1F1C3C43B0D0455394A23A5711")

    protected final RegistrantList mServiceStateRegistrants
            = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.366 -0500", hash_original_field = "C03C7266C40BF8471927BCFA66B50EB3", hash_generated_field = "772992E80B305C05B30F1419725B97CD")

    protected final RegistrantList mMmiCompleteRegistrants
            = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.369 -0500", hash_original_field = "B8D96E3CBB478CC278906C8B52FF9D78", hash_generated_field = "114239A2A412532ACC57B1CDDF1CD841")

    protected final RegistrantList mMmiRegistrants
            = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.371 -0500", hash_original_field = "672538DC587B45E3B7CACD4D2327BCFA", hash_generated_field = "1506E6C74D88F0FEE5B24B1D055AAE0A")

    protected final RegistrantList mUnknownConnectionRegistrants
            = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.374 -0500", hash_original_field = "C4A97F1A356D9B1B4158FD36D3E2F9C8", hash_generated_field = "D49D8AF4024090CFDB28FE746E4D9BC6")

    protected final RegistrantList mSuppServiceFailedRegistrants
            = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.377 -0500", hash_original_field = "4C6A73D1D5351706C43659B423CF9288", hash_generated_field = "D741950DD4D297A5A97E2573D2099374")

    protected Looper mLooper;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.379 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.382 -0500", hash_original_field = "0964CE85AC17C66896F5F3E80F31F06C", hash_generated_field = "0DBF65814173CE16A85F1AA98BDF5F5E")

    protected PhoneNotifier mNotifier;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.384 -0500", hash_original_field = "38C7B43C5FEA9C0527C3EEE9851D2E77", hash_generated_field = "3A8866AF6F9DF724308515FF86538AAE")

    protected SimulatedRadioControl mSimulatedRadioControl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.387 -0500", hash_original_field = "F1D2CE7105A6C577055D5D2EA9384903", hash_generated_field = "F1D2CE7105A6C577055D5D2EA9384903")

    boolean mUnitTestMode;

    /**
     * Constructs a PhoneBase in normal (non-unit test) mode.
     *
     * @param context Context object from hosting application
     * @param notifier An instance of DefaultPhoneNotifier,
     * unless unit testing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.390 -0500", hash_original_method = "0B01EDD7CFA10DA565A9E13F0B7F18B5", hash_generated_method = "53A229DC10D610846BFAAF9AFC0754F8")
    
protected PhoneBase(PhoneNotifier notifier, Context context, CommandsInterface ci) {
        this(notifier, context, ci, false);
    }

    /**
     * Constructs a PhoneBase in normal (non-unit test) mode.
     *
     * @param context Context object from hosting application
     * @param notifier An instance of DefaultPhoneNotifier,
     * unless unit testing.
     * @param unitTestMode when true, prevents notifications
     * of state change events
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.394 -0500", hash_original_method = "0B181FBA64FE5D093F6319BFF754183A", hash_generated_method = "A8E601BFAA886A5F4AA36EC0E2B40A6D")
    
protected PhoneBase(PhoneNotifier notifier, Context context, CommandsInterface ci,
            boolean unitTestMode) {
        this.mNotifier = notifier;
        this.mContext = context;
        mLooper = Looper.myLooper();
        mCM = ci;

        setPropertiesByCarrier();

        setUnitTestMode(unitTestMode);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        mDnsCheckDisabled = sp.getBoolean(DNS_SERVER_CHECK_DISABLED_KEY, false);
        mCM.setOnCallRing(this, EVENT_CALL_RING, null);

        /* "Voice capable" means that this device supports circuit-switched
        * (i.e. voice) phone calls over the telephony network, and is allowed
        * to display the in-call UI while a cellular voice call is active.
        * This will be false on "data only" devices which can't make voice
        * calls and don't support any in-call UI.
        */
        mIsVoiceCapable = mContext.getResources().getBoolean(
                com.android.internal.R.bool.config_voice_capable);

        /**
         *  Some RIL's don't always send RIL_UNSOL_CALL_RING so it needs
         *  to be generated locally. Ideally all ring tones should be loops
         * and this wouldn't be necessary. But to minimize changes to upper
         * layers it is requested that it be generated by lower layers.
         *
         * By default old phones won't have the property set but do generate
         * the RIL_UNSOL_CALL_RING so the default if there is no property is
         * true.
         */
        mDoesRilSendMultipleCallRing = SystemProperties.getBoolean(
                TelephonyProperties.PROPERTY_RIL_SENDS_MULTIPLE_CALL_RING, true);
        Log.d(LOG_TAG, "mDoesRilSendMultipleCallRing=" + mDoesRilSendMultipleCallRing);

        mCallRingDelay = SystemProperties.getInt(
                TelephonyProperties.PROPERTY_CALL_RING_DELAY, 3000);
        Log.d(LOG_TAG, "mCallRingDelay=" + mCallRingDelay);

        // Initialize device storage and outgoing SMS usage monitors for SMSDispatchers.
        mSmsStorageMonitor = new SmsStorageMonitor(this);
        mSmsUsageMonitor = new SmsUsageMonitor(context.getContentResolver());
    }

    /**
     * Set a system property, unless we're in unit test mode
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.351 -0500", hash_original_method = "5E4CE6B07EFCD29EE81659A348140E39", hash_generated_method = "9808DF1E164C091DB66A3AD2321F94F1")
    
public void
    setSystemProperty(String property, String value) {
        if(getUnitTestMode()) {
            return;
        }
        SystemProperties.set(property, value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.396 -0500", hash_original_method = "E6D9767A803FC78FE4F21E8C0AA16E1B", hash_generated_method = "85C729A04BB96B33711342634F1C756A")
    
public void dispose() {
        synchronized(PhoneProxy.lockForRadioTechnologyChange) {
            mCM.unSetOnCallRing(this);
            // Must cleanup all connectionS and needs to use sendMessage!
            mDataConnectionTracker.cleanUpAllConnections(null);
            mIsTheCurrentActivePhone = false;
            // Dispose the SMS usage and storage monitors
            mSmsStorageMonitor.dispose();
            mSmsUsageMonitor.dispose();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.399 -0500", hash_original_method = "AD2C393D4007178071128FB79D198E7A", hash_generated_method = "DA69EF427707ECCEBDC9EAB73351BF48")
    
public void removeReferences() {
        mSmsStorageMonitor = null;
        mSmsUsageMonitor = null;
    }

    /**
     * When overridden the derived class needs to call
     * super.handleMessage(msg) so this method has a
     * a chance to process the message.
     *
     * @param msg
     */
    @DSSafe(DSCat.IPC_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.402 -0500", hash_original_method = "DB16D19FE7C055C53AF6F04667B938A9", hash_generated_method = "AFE90A228BEE91992CFA75B0112F77B3")
    
@Override
    public void handleMessage(Message msg) {
        AsyncResult ar;

        switch(msg.what) {
            case EVENT_CALL_RING:
                Log.d(LOG_TAG, "Event EVENT_CALL_RING Received state=" + getState());
                ar = (AsyncResult)msg.obj;
                if (ar.exception == null) {
                    Phone.State state = getState();
                    if ((!mDoesRilSendMultipleCallRing)
                            && ((state == Phone.State.RINGING) || (state == Phone.State.IDLE))) {
                        mCallRingContinueToken += 1;
                        sendIncomingCallRingNotification(mCallRingContinueToken);
                    } else {
                        notifyIncomingRing();
                    }
                }
                break;

            case EVENT_CALL_RING_CONTINUE:
                Log.d(LOG_TAG, "Event EVENT_CALL_RING_CONTINUE Received stat=" + getState());
                if (getState() == Phone.State.RINGING) {
                    sendIncomingCallRingNotification(msg.arg1);
                }
                break;

            default:
                throw new RuntimeException("unexpected event not handled");
        }
    }

    // Inherited documentation suffices.
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.405 -0500", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "BA026F6873AF9B17E96AB49AFB6CEE03")
    
public Context getContext() {
        return mContext;
    }

    /**
     * Disables the DNS check (i.e., allows "0.0.0.0").
     * Useful for lab testing environment.
     * @param b true disables the check, false enables.
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.407 -0500", hash_original_method = "6B58AC4FFDA912638B2751BFF719D57B", hash_generated_method = "A1AADD4979134DFE0110F94D1FB8F29B")
    
public void disableDnsCheck(boolean b) {
        mDnsCheckDisabled = b;
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(DNS_SERVER_CHECK_DISABLED_KEY, b);
        editor.apply();
    }

    /**
     * Returns true if the DNS check is currently disabled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.410 -0500", hash_original_method = "26E6CAA04D711DCC258BDCDD2AAE1C53", hash_generated_method = "F996D3B163886D22A9F935383A7B295C")
    
public boolean isDnsCheckDisabled() {
        return mDnsCheckDisabled;
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.412 -0500", hash_original_method = "97FD2D9125201743A42C7236EAF94A65", hash_generated_method = "A94B96E78F0A0347F30AF6526EF16A16")
    
public void registerForPreciseCallStateChanged(Handler h, int what, Object obj) {
        checkCorrectThread(h);

        mPreciseCallStateRegistrants.addUnique(h, what, obj);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.414 -0500", hash_original_method = "3468093E0DED2950A146A2A89C89E0C9", hash_generated_method = "FDC3D55D1BFAE6A8385A767C32C0FF58")
    
public void unregisterForPreciseCallStateChanged(Handler h) {
        mPreciseCallStateRegistrants.remove(h);
    }

    /**
     * Subclasses of Phone probably want to replace this with a
     * version scoped to their packages
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.417 -0500", hash_original_method = "7D1AEC63A120FA3D327FCF14A278BC6F", hash_generated_method = "3B10659442D6A160E222633562AC871A")
    
protected void notifyPreciseCallStateChangedP() {
        AsyncResult ar = new AsyncResult(null, this, null);
        mPreciseCallStateRegistrants.notifyRegistrants(ar);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.420 -0500", hash_original_method = "B9AA4FF50180EB9A48B29DB9F5910CE4", hash_generated_method = "3CE73CC040F5C320E4FD4DE690D48E4B")
    
public void registerForUnknownConnection(Handler h, int what, Object obj) {
        checkCorrectThread(h);

        mUnknownConnectionRegistrants.addUnique(h, what, obj);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.423 -0500", hash_original_method = "75B09E3F4F0ED781C6A40D2F37829CA0", hash_generated_method = "BD5327EF52C4CF7A002AE39E22DBED13")
    
public void unregisterForUnknownConnection(Handler h) {
        mUnknownConnectionRegistrants.remove(h);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.425 -0500", hash_original_method = "AD1FA3FDB645CF1FEF5A2946EFD96B38", hash_generated_method = "AA3B577855444FBAFCFB3B5231DD6B35")
    
public void registerForNewRingingConnection(
            Handler h, int what, Object obj) {
        checkCorrectThread(h);

        mNewRingingConnectionRegistrants.addUnique(h, what, obj);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.428 -0500", hash_original_method = "058A0D079EFCE83305D698FFA7B5D825", hash_generated_method = "9FEC1CB36BB4F33B9F12607CD63C08CA")
    
public void unregisterForNewRingingConnection(Handler h) {
        mNewRingingConnectionRegistrants.remove(h);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.430 -0500", hash_original_method = "0EC65AF661091C788FEAC732E62723E6", hash_generated_method = "76820024290780BF387DCB04C1007110")
    
public void registerForInCallVoicePrivacyOn(Handler h, int what, Object obj){
        mCM.registerForInCallVoicePrivacyOn(h,what,obj);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.433 -0500", hash_original_method = "AAF2DABAA6CCE680F9F5730540C91C97", hash_generated_method = "9834E5719DC0585690E2BB53B874B167")
    
public void unregisterForInCallVoicePrivacyOn(Handler h){
        mCM.unregisterForInCallVoicePrivacyOn(h);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.435 -0500", hash_original_method = "5EF015768DAEEB9D8933F39BF43636FD", hash_generated_method = "B99A1A97800220CFCE63FA7274C79C5D")
    
public void registerForInCallVoicePrivacyOff(Handler h, int what, Object obj){
        mCM.registerForInCallVoicePrivacyOff(h,what,obj);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.437 -0500", hash_original_method = "D5B23AF1D1217C6A3E1625439D35B2E2", hash_generated_method = "AE7C02E26F2D8BB025499B93B98F6C63")
    
public void unregisterForInCallVoicePrivacyOff(Handler h){
        mCM.unregisterForInCallVoicePrivacyOff(h);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.440 -0500", hash_original_method = "50A4B0D73C58D3A2BE8105C1A17D2698", hash_generated_method = "2F55700A3AB56E80384757D82C234B62")
    
public void registerForIncomingRing(
            Handler h, int what, Object obj) {
        checkCorrectThread(h);

        mIncomingRingRegistrants.addUnique(h, what, obj);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.442 -0500", hash_original_method = "92E2BA35AB0B11C010FD1FF2A8E6A65B", hash_generated_method = "7E9FCEA1CFFAA20AAC7F41B4DF8DC145")
    
public void unregisterForIncomingRing(Handler h) {
        mIncomingRingRegistrants.remove(h);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.445 -0500", hash_original_method = "2053ED9D2D7BD498A1C704AFBEE337C3", hash_generated_method = "FA8E417788BDCE6B22205F78CF301EAF")
    
public void registerForDisconnect(Handler h, int what, Object obj) {
        checkCorrectThread(h);

        mDisconnectRegistrants.addUnique(h, what, obj);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.447 -0500", hash_original_method = "77A19CF742BA6691CDA7407600B4E7F3", hash_generated_method = "40542560B801C05F3F3A70521293C0A0")
    
public void unregisterForDisconnect(Handler h) {
        mDisconnectRegistrants.remove(h);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.450 -0500", hash_original_method = "D574E9C9A24655069A0054F4E3538F49", hash_generated_method = "E9C9209F02ED64437BA44AC98D474EEA")
    
public void registerForSuppServiceFailed(Handler h, int what, Object obj) {
        checkCorrectThread(h);

        mSuppServiceFailedRegistrants.addUnique(h, what, obj);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.453 -0500", hash_original_method = "C86C69890AF660CD858A7F262F783D04", hash_generated_method = "4025A8A91AE5BB76880EDBCC0534B385")
    
public void unregisterForSuppServiceFailed(Handler h) {
        mSuppServiceFailedRegistrants.remove(h);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.455 -0500", hash_original_method = "04A8F1C35CFA7005AF5258C29F5FFE2B", hash_generated_method = "9F833887229FD122986F3B7DF0F51D25")
    
public void registerForMmiInitiate(Handler h, int what, Object obj) {
        checkCorrectThread(h);

        mMmiRegistrants.addUnique(h, what, obj);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.457 -0500", hash_original_method = "338E9AA4432AD835C97CF49233FF5692", hash_generated_method = "32EDE7D55FADA14F9D004D9D66798DD8")
    
public void unregisterForMmiInitiate(Handler h) {
        mMmiRegistrants.remove(h);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.459 -0500", hash_original_method = "61BE6CB4DF9A0C652F1BC7F7AD4D4CCB", hash_generated_method = "FBF524B390652CE785701004BAA273E4")
    
public void registerForMmiComplete(Handler h, int what, Object obj) {
        checkCorrectThread(h);

        mMmiCompleteRegistrants.addUnique(h, what, obj);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.461 -0500", hash_original_method = "FE25021AB6559853BB3705423F117C85", hash_generated_method = "1E03AAD21C13F781E5A144EB3394F9BC")
    
public void unregisterForMmiComplete(Handler h) {
        checkCorrectThread(h);

        mMmiCompleteRegistrants.remove(h);
    }

    /**
     * Method to retrieve the saved operator id from the Shared Preferences
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.464 -0500", hash_original_method = "764E722E685D5D307BCF00BDB294F564", hash_generated_method = "429291A4D4B490626B3FAD3D970FB70C")
    
private String getSavedNetworkSelection() {
        // open the shared preferences and search with our key.
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        return sp.getString(NETWORK_SELECTION_KEY, "");
    }

    /**
     * Method to restore the previously saved operator id, or reset to
     * automatic selection, all depending upon the value in the shared
     * preferences.
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.467 -0500", hash_original_method = "29F19DECCCFC42207CFA8F3911C2D799", hash_generated_method = "A260D676EFD94837369A8D3B7D3A9240")
    
public void restoreSavedNetworkSelection(Message response) {
        // retrieve the operator id
        String networkSelection = getSavedNetworkSelection();

        // set to auto if the id is empty, otherwise select the network.
        if (TextUtils.isEmpty(networkSelection)) {
            mCM.setNetworkSelectionModeAutomatic(response);
        } else {
            mCM.setNetworkSelectionModeManual(networkSelection, response);
        }
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.469 -0500", hash_original_method = "347AF2D7A75CED9B3C82A500C1FA5AD6", hash_generated_method = "CFA1059D67850691A7CD3AF4302D0A95")
    
public void setUnitTestMode(boolean f) {
        mUnitTestMode = f;
    }

    // Inherited documentation suffices.
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.471 -0500", hash_original_method = "958D127406A24370C06699E6AB687F2A", hash_generated_method = "55A0AAFE3E7B38CDE71BB6590DB6F410")
    
public boolean getUnitTestMode() {
        return mUnitTestMode;
    }

    /**
     * To be invoked when a voice call Connection disconnects.
     *
     * Subclasses of Phone probably want to replace this with a
     * version scoped to their packages
     */
    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.474 -0500", hash_original_method = "80E90CBCA9EDC240B4F0091FF8E28C26", hash_generated_method = "6FFC2CB8CDB822E7569AF3FAC79979E8")
    
protected void notifyDisconnectP(Connection cn) {
        AsyncResult ar = new AsyncResult(null, cn, null);
        mDisconnectRegistrants.notifyRegistrants(ar);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.476 -0500", hash_original_method = "BD17CCC0601D2F340E3F675C1E59C4B9", hash_generated_method = "F6FF8685AA56A07436E11C6CA561251F")
    
public void registerForServiceStateChanged(
            Handler h, int what, Object obj) {
        checkCorrectThread(h);

        mServiceStateRegistrants.add(h, what, obj);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.478 -0500", hash_original_method = "5AFF1BE54185C9B4577A75EFF0396B68", hash_generated_method = "38CCC54F85C8824B27D7D8D54BC0F001")
    
public void unregisterForServiceStateChanged(Handler h) {
        mServiceStateRegistrants.remove(h);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.480 -0500", hash_original_method = "6C50CDA22F8E02023B34911844DFEED2", hash_generated_method = "5479F8464AC73F9C9FE18C527ECF235A")
    
public void registerForRingbackTone(Handler h, int what, Object obj) {
        mCM.registerForRingbackTone(h,what,obj);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.483 -0500", hash_original_method = "475301C04BE08B381350355879425A76", hash_generated_method = "5BCD3F3ACA833DB19B59AD1867820CBD")
    
public void unregisterForRingbackTone(Handler h) {
        mCM.unregisterForRingbackTone(h);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.485 -0500", hash_original_method = "6FE1177D9BF24D9A41C1BE1AD2A93980", hash_generated_method = "715EB988B51DFFBCC7894774843528B8")
    
public void registerForResendIncallMute(Handler h, int what, Object obj) {
        mCM.registerForResendIncallMute(h,what,obj);
    }

    // Inherited documentation suffices.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.487 -0500", hash_original_method = "1E28EF1EEBC2208F47A83D89926DE82E", hash_generated_method = "FB1DD56A8F8A3788995DA915DB47028A")
    
public void unregisterForResendIncallMute(Handler h) {
        mCM.unregisterForResendIncallMute(h);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.489 -0500", hash_original_method = "F34715D262D40C908422031B6920D016", hash_generated_method = "182ABABC87167C154B96D174C59EEEBC")
    
public void setEchoSuppressionEnabled(boolean enabled) {
        // no need for regular phone
    }

    /**
     * Subclasses of Phone probably want to replace this with a
     * version scoped to their packages
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.492 -0500", hash_original_method = "D42B19E1304E0F299FEED69470ACF7B6", hash_generated_method = "B58CF43EE6CC448824FDB673ACB4FAFB")
    
protected void notifyServiceStateChangedP(ServiceState ss) {
        AsyncResult ar = new AsyncResult(null, ss, null);
        mServiceStateRegistrants.notifyRegistrants(ar);

        mNotifier.notifyServiceState(this);
    }

    // Inherited documentation suffices.
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.494 -0500", hash_original_method = "6C132AD700E1EDF5A17434649EDA0F2C", hash_generated_method = "1B341469E2739AC56956596EFA017F5F")
    
public SimulatedRadioControl getSimulatedRadioControl() {
        return mSimulatedRadioControl;
    }

    /**
     * Verifies the current thread is the same as the thread originally
     * used in the initialization of this instance. Throws RuntimeException
     * if not.
     *
     * @exception RuntimeException if the current thread is not
     * the thread that originally obtained this PhoneBase instance.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.496 -0500", hash_original_method = "930052C83226AF8DE91A3B058305558F", hash_generated_method = "CCA9DF7A73C9D116FC06A3AAA0D508BC")
    
private void checkCorrectThread(Handler h) {
        if (h.getLooper() != mLooper) {
            throw new RuntimeException(
                    "com.android.internal.telephony.Phone must be used from within one thread");
        }
    }

    /**
     * Set the properties by matching the carrier string in
     * a string-array resource
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.500 -0500", hash_original_method = "FDCB651DF17FF9811415182F19CE1B4C", hash_generated_method = "12227064E0EB2B766DBEC91AE4DDE84B")
    
private void setPropertiesByCarrier() {
        String carrier = SystemProperties.get("ro.carrier");

        if (null == carrier || 0 == carrier.length() || "unknown".equals(carrier)) {
            return;
        }

        CharSequence[] carrierLocales = mContext.
                getResources().getTextArray(R.array.carrier_properties);

        for (int i = 0; i < carrierLocales.length; i+=3) {
            String c = carrierLocales[i].toString();
            if (carrier.equals(c)) {
                String l = carrierLocales[i+1].toString();

                String language = l.substring(0, 2);
                String country = "";
                if (l.length() >=5) {
                    country = l.substring(3, 5);
                }
                setSystemLocale(language, country, false);

                if (!country.isEmpty()) {
                    try {
                        Settings.Secure.getInt(mContext.getContentResolver(),
                                Settings.Secure.WIFI_COUNTRY_CODE);
                    } catch (Settings.SettingNotFoundException e) {
                        // note this is not persisting
                        WifiManager wM = (WifiManager)
                                mContext.getSystemService(Context.WIFI_SERVICE);
                        wM.setCountryCode(country, false);
                    }
                }
                return;
            }
        }
    }

    /**
     * Utility code to set the system locale if it's not set already
     * @param language Two character language code desired
     * @param country Two character country code desired
     * @param fromMcc Indicating whether the locale is set according to MCC table.
     *                This flag wil be ignored by default implementation.
     *                TODO: Use a source enumeration so that source of the locale
     *                      can be prioritized.
     *
     *  {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.504 -0500", hash_original_method = "B1CAAC16126A906DDE46004E33C276B7", hash_generated_method = "9ADC7528E0DD8EFCC63F781A5085FBF5")
    
public void setSystemLocale(String language, String country, boolean fromMcc) {
        String l = SystemProperties.get("persist.sys.language");
        String c = SystemProperties.get("persist.sys.country");

        if (null == language) {
            return; // no match possible
        }
        language = language.toLowerCase();
        if (null == country) {
            country = "";
        }
        country = country.toUpperCase();

        if((null == l || 0 == l.length()) && (null == c || 0 == c.length())) {
            try {
                // try to find a good match
                String[] locales = mContext.getAssets().getLocales();
                final int N = locales.length;
                String bestMatch = null;
                for(int i = 0; i < N; i++) {
                    // only match full (lang + country) locales
                    if (locales[i]!=null && locales[i].length() >= 5 &&
                            locales[i].substring(0,2).equals(language)) {
                        if (locales[i].substring(3,5).equals(country)) {
                            bestMatch = locales[i];
                            break;
                        } else if (null == bestMatch) {
                            bestMatch = locales[i];
                        }
                    }
                }
                if (null != bestMatch) {
                    IActivityManager am = ActivityManagerNative.getDefault();
                    Configuration config = am.getConfiguration();
                    config.locale = new Locale(bestMatch.substring(0,2),
                                               bestMatch.substring(3,5));
                    config.userSetLocale = true;
                    am.updateConfiguration(config);
                }
            } catch (Exception e) {
                // Intentionally left blank
            }
        }
    }

    /**
     * Get state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.506 -0500", hash_original_method = "502079E2ACA7CA0EEFDB1EF80684F490", hash_generated_method = "F19F663E7181F9948BFEF37A7B8DF846")
    
public abstract Phone.State getState();

    /**
     * Retrieves the IccFileHandler of the Phone instance
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.509 -0500", hash_original_method = "BF92A0F8A51D1099AB491A95592785BD", hash_generated_method = "E2D89DDC80711BA95C1FBCD42B9F305C")
    
public abstract IccFileHandler getIccFileHandler();

    /*
     * Retrieves the Handler of the Phone instance
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.511 -0500", hash_original_method = "B77EA67F9749FFFAEC203B31F557B343", hash_generated_method = "070F292BEB227B3FD9A3378365FC8550")
    
public Handler getHandler() {
        return this;
    }

    /**
    * Retrieves the ServiceStateTracker of the phone instance.
    */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.514 -0500", hash_original_method = "E9813275B540C23EC4ABDDE1F3F36487", hash_generated_method = "4747569852371ECC08714EF417C2BF01")
    
public ServiceStateTracker getServiceStateTracker() {
        return null;
    }

    /**
    * Get call tracker
    */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.516 -0500", hash_original_method = "A2CFF60AF23DAF5B5D13432A0E634448", hash_generated_method = "10AFE703FAC5B03D21F6219AB381338C")
    
public CallTracker getCallTracker() {
        return null;
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.519 -0500", hash_original_method = "E12359725DA3BA4F59BA85FD7E4F143C", hash_generated_method = "4500E21976FE997592042902BA61B896")
    
@Override
    public IccCard getIccCard() {
        return mIccCard;
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.521 -0500", hash_original_method = "26C3C4C321ACD0FC593701A52D49E497", hash_generated_method = "C8FF3CC6782971CF8F1BDA13B158ABC2")
    
@Override
    public String getIccSerialNumber() {
        return mIccRecords.iccid;
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.524 -0500", hash_original_method = "9078EC96DE8D2AE9C16B88E94341FB99", hash_generated_method = "6AC51C06892772481890ED650A7181E0")
    
@Override
    public boolean getIccRecordsLoaded() {
        return mIccRecords.getRecordsLoaded();
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.527 -0500", hash_original_method = "1B6614D059F66BD820665EDAF3DE7F9F", hash_generated_method = "1BE9A185FD23AE024866E090192247C5")
    
@Override
    public boolean getMessageWaitingIndicator() {
        return mIccRecords.getVoiceMessageWaiting();
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.530 -0500", hash_original_method = "EAA51813A27C6D01EBD0F8DD0837A86A", hash_generated_method = "53DD988D37559747AC40A9BFD1F48ABC")
    
@Override
    public boolean getCallForwardingIndicator() {
        return mIccRecords.getVoiceCallForwardingFlag();
    }

    /**
     *  Query the status of the CDMA roaming preference
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.532 -0500", hash_original_method = "93DCD756C677180103F6D6F7873E6AE7", hash_generated_method = "619F66B310F8BA5B8A73F45F1B9C6347")
    
public void queryCdmaRoamingPreference(Message response) {
        mCM.queryCdmaRoamingPreference(response);
    }

    /**
     *  Set the status of the CDMA roaming preference
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.534 -0500", hash_original_method = "D1AE94805C952F3809EAEE65E7FED134", hash_generated_method = "10D012E5E5FBAF677A0C102422BD0F5C")
    
public void setCdmaRoamingPreference(int cdmaRoamingType, Message response) {
        mCM.setCdmaRoamingPreference(cdmaRoamingType, response);
    }

    /**
     *  Set the status of the CDMA subscription mode
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.536 -0500", hash_original_method = "532B78C8CD74E377483500017A27260E", hash_generated_method = "1826B078864B8FBB9C6EF7B9A6D9AF5C")
    
public void setCdmaSubscription(int cdmaSubscriptionType, Message response) {
        mCM.setCdmaSubscriptionSource(cdmaSubscriptionType, response);
    }

    /**
     *  Set the preferred Network Type: Global, CDMA only or GSM/UMTS only
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.539 -0500", hash_original_method = "EA18BAD07370F2F495FB68EDF5CD8C8E", hash_generated_method = "65853BD94A4F091C14BDA5AFA7C76A7B")
    
public void setPreferredNetworkType(int networkType, Message response) {
        mCM.setPreferredNetworkType(networkType, response);
    }

    @DSSource({DSSourceKind.LOCATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.542 -0500", hash_original_method = "379A4BC143905A2FA132EF757E52297F", hash_generated_method = "964A3A7FA8B49FA6E5C9C1F03E577710")
    
public void getPreferredNetworkType(Message response) {
        mCM.getPreferredNetworkType(response);
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.544 -0500", hash_original_method = "1E1783F8116903E275F3EB4645F9C2EE", hash_generated_method = "165B3CB4503AFECAC25EDEEE69F68D90")
    
public void getSmscAddress(Message result) {
        mCM.getSmscAddress(result);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.547 -0500", hash_original_method = "4D63BDB7F30F381F077564B4D4894249", hash_generated_method = "F260D13EFFD439D5BD29426D0D2EB174")
    
public void setSmscAddress(String address, Message result) {
        mCM.setSmscAddress(address, result);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.549 -0500", hash_original_method = "63C869993C8085EA489C8231FED76E37", hash_generated_method = "0D7E317A2957841F0DA82348331A9B4F")
    
public void setTTYMode(int ttyMode, Message onComplete) {
        mCM.setTTYMode(ttyMode, onComplete);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.552 -0500", hash_original_method = "2CF2C1C8F165F7A0D032A77B44E87766", hash_generated_method = "B3BCAE472D7F1569F1042D87CC117361")
    
public void queryTTYMode(Message onComplete) {
        mCM.queryTTYMode(onComplete);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.554 -0500", hash_original_method = "5E8CBEA5609C7848D9FB026D7FBB8ABD", hash_generated_method = "26BB793141C296134A8859E5E0612325")
    
public void enableEnhancedVoicePrivacy(boolean enable, Message onComplete) {
        // This function should be overridden by the class CDMAPhone. Not implemented in GSMPhone.
        logUnexpectedCdmaMethodCall("enableEnhancedVoicePrivacy");
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.556 -0500", hash_original_method = "33AF0BA0508B34DC6251B1288B05B827", hash_generated_method = "86E38601F0AF337ADC828BAB86676B58")
    
public void getEnhancedVoicePrivacy(Message onComplete) {
        // This function should be overridden by the class CDMAPhone. Not implemented in GSMPhone.
        logUnexpectedCdmaMethodCall("getEnhancedVoicePrivacy");
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.559 -0500", hash_original_method = "89D25AC6FB0D0D55BD65CF567206F30D", hash_generated_method = "CA290AE501597B06E487E7022320D540")
    
public void setBandMode(int bandMode, Message response) {
        mCM.setBandMode(bandMode, response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.561 -0500", hash_original_method = "83F6C692B5B60F1074FC39097E38CED5", hash_generated_method = "5E1C0805B4BBE16503FB19DA63680055")
    
public void queryAvailableBandMode(Message response) {
        mCM.queryAvailableBandMode(response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.564 -0500", hash_original_method = "13F8DD451E5397866EEA2E2D05CD7BB9", hash_generated_method = "7A13D081B257FEDC61E62A5A193BE11B")
    
public void invokeOemRilRequestRaw(byte[] data, Message response) {
        mCM.invokeOemRilRequestRaw(data, response);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.566 -0500", hash_original_method = "FF2E1FA4CC9C1321FDC1F9CFA6F4625A", hash_generated_method = "B4D9B3D9704406E0A9B6A256347A64AB")
    
public void invokeOemRilRequestStrings(String[] strings, Message response) {
        mCM.invokeOemRilRequestStrings(strings, response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.569 -0500", hash_original_method = "FF7C38607D5C4F28572FCAAA94A2F244", hash_generated_method = "62F85AE106DE69FEDC94A1E670CA7C6F")
    
public void notifyDataActivity() {
        mNotifier.notifyDataActivity(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.571 -0500", hash_original_method = "CD8E1DAAFB356590CE946A9A3EFA7BF6", hash_generated_method = "E38D9F8A15AC40271DAE9B6F8B66BEBD")
    
public void notifyMessageWaitingIndicator() {
        // Do not notify voice mail waiting if device doesn't support voice
        if (!mIsVoiceCapable)
            return;

        // This function is added to send the notification to DefaultPhoneNotifier.
        mNotifier.notifyMessageWaitingChanged(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.574 -0500", hash_original_method = "B949430324D30DD706A09A11AE93C217", hash_generated_method = "831793F061DEFC7A7CB5F71BA7B6EC47")
    
public void notifyDataConnection(String reason, String apnType,
            Phone.DataState state) {
        mNotifier.notifyDataConnection(this, reason, apnType, state);
    }

    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.576 -0500", hash_original_method = "FACBD8427065A5D42D63A885B3F07753", hash_generated_method = "20BC0402924C3425040E654BB9153BD1")
    
public void notifyDataConnection(String reason, String apnType) {
        mNotifier.notifyDataConnection(this, reason, apnType, getDataConnectionState(apnType));
    }

    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.578 -0500", hash_original_method = "0547766DA98E44E8B89F2461696DDA6A", hash_generated_method = "1577B4D1E6249A33123E4F5C4D58C60D")
    
public void notifyDataConnection(String reason) {
        String types[] = getActiveApnTypes();
        for (String apnType : types) {
            mNotifier.notifyDataConnection(this, reason, apnType, getDataConnectionState(apnType));
        }
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.581 -0500", hash_original_method = "68DB92920F159FB7A2995379683DC8DE", hash_generated_method = "F42B4AE14EED29A6B727F0CC164BCF1B")
    
public void notifyOtaspChanged(int otaspMode) {
        mNotifier.notifyOtaspChanged(this, otaspMode);
    }

    /**
     * @return true if a mobile originating emergency call is active
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.583 -0500", hash_original_method = "EBE7791CDB6F228DD3645706A64042D5", hash_generated_method = "E000B28F5A262BF5794A7D6F670BF08C")
    
public boolean isInEmergencyCall() {
        return false;
    }

    /**
     * @return true if we are in the emergency call back mode. This is a period where
     * the phone should be using as little power as possible and be ready to receive an
     * incoming call from the emergency operator.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.586 -0500", hash_original_method = "2D052AB13CFF7511C3F5373523EDFF5B", hash_generated_method = "B46015E80650720AD97F41DA58246D0C")
    
public boolean isInEcm() {
        return false;
    }

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.589 -0500", hash_original_method = "1BE6182806EBB577CA32C99B64FB39FA", hash_generated_method = "ED1B0EB943CE9724358AF3758FCFE781")
    
public abstract String getPhoneName();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.592 -0500", hash_original_method = "499DD3E62BC2C72F13412D61A0862C5A", hash_generated_method = "282C338128CE2C8CBA7CE01D63BCC199")
    
public abstract int getPhoneType();

    /** @hide */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.595 -0500", hash_original_method = "91CE395C2B1A59CCA21CB689DCBFE10B", hash_generated_method = "60C6D0F959938E47B0AA65917C6B616E")
    
public int getVoiceMessageCount(){
        return 0;
    }

    /**
     * Returns the CDMA ERI icon index to display
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.597 -0500", hash_original_method = "A48905F669D5C197EA0EF66127013B06", hash_generated_method = "E3D3EE100A44D89A46CD6FBB228B00BD")
    
public int getCdmaEriIconIndex() {
        logUnexpectedCdmaMethodCall("getCdmaEriIconIndex");
        return -1;
    }

    /**
     * Returns the CDMA ERI icon mode,
     * 0 - ON
     * 1 - FLASHING
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.600 -0500", hash_original_method = "F2685CF828A9991D177F425CEE905936", hash_generated_method = "16908EA3AB22BC92CD53A485656495F0")
    
public int getCdmaEriIconMode() {
        logUnexpectedCdmaMethodCall("getCdmaEriIconMode");
        return -1;
    }

    /**
     * Returns the CDMA ERI text,
     */
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.602 -0500", hash_original_method = "B9212A70F84EE88792E9F77579D252EB", hash_generated_method = "7BBD25E6328E94D2F8DE5B9ADC97919F")
    
public String getCdmaEriText() {
        logUnexpectedCdmaMethodCall("getCdmaEriText");
        return "GSM nw, no ERI";
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.604 -0500", hash_original_method = "31C17E46EDF55F22A4F7752D6C0E6244", hash_generated_method = "1735217B4F9248B02E85DACFF90AAD07")
    
public String getCdmaMin() {
        // This function should be overridden by the class CDMAPhone. Not implemented in GSMPhone.
        logUnexpectedCdmaMethodCall("getCdmaMin");
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.607 -0500", hash_original_method = "5ED51837BFBC47DED520188DB45BE3ED", hash_generated_method = "AC6DB0D01A6DB34A98EA5F89572FA5F9")
    
public boolean isMinInfoReady() {
        // This function should be overridden by the class CDMAPhone. Not implemented in GSMPhone.
        logUnexpectedCdmaMethodCall("isMinInfoReady");
        return false;
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.610 -0500", hash_original_method = "A959C6A3260B45047463EF5F7B599FA2", hash_generated_method = "349B4B5045B1766041D3E401016A1821")
    
public String getCdmaPrlVersion(){
        //  This function should be overridden by the class CDMAPhone. Not implemented in GSMPhone.
        logUnexpectedCdmaMethodCall("getCdmaPrlVersion");
        return null;
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.612 -0500", hash_original_method = "2891F3B114A0E9671C3D7B6F8CA784DA", hash_generated_method = "CDF3EF1BC21E8E230A01D1865C5B4F17")
    
public void sendBurstDtmf(String dtmfString, int on, int off, Message onComplete) {
        // This function should be overridden by the class CDMAPhone. Not implemented in GSMPhone.
        logUnexpectedCdmaMethodCall("sendBurstDtmf");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.615 -0500", hash_original_method = "1233D801AF5BD64366571B89C874921A", hash_generated_method = "D7E3ACC6864C653343603BD3CEBC1AC2")
    
public void exitEmergencyCallbackMode() {
        // This function should be overridden by the class CDMAPhone. Not implemented in GSMPhone.
        logUnexpectedCdmaMethodCall("exitEmergencyCallbackMode");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.617 -0500", hash_original_method = "A559D3AF3D26E6025D0072F9A69D12D5", hash_generated_method = "2DD35AFCFC0134397E31D599670A4483")
    
public void registerForCdmaOtaStatusChange(Handler h, int what, Object obj) {
        // This function should be overridden by the class CDMAPhone. Not implemented in GSMPhone.
        logUnexpectedCdmaMethodCall("registerForCdmaOtaStatusChange");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.620 -0500", hash_original_method = "ECF4F8F98FA1956C40263AEBA8AA4F0E", hash_generated_method = "73057769EF6E6AF185C1F14A89088E49")
    
public void unregisterForCdmaOtaStatusChange(Handler h) {
        // This function should be overridden by the class CDMAPhone. Not implemented in GSMPhone.
        logUnexpectedCdmaMethodCall("unregisterForCdmaOtaStatusChange");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.622 -0500", hash_original_method = "D0126A4408C76F0C8443237E283C8B7B", hash_generated_method = "D0FE67194AFAC2D289B0F3BB213CA733")
    
public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        // This function should be overridden by the class CDMAPhone. Not implemented in GSMPhone.
        logUnexpectedCdmaMethodCall("registerForSubscriptionInfoReady");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.624 -0500", hash_original_method = "87FC8275C239D995B7197317524E9D40", hash_generated_method = "A1E27E53689B34FB6CFFD2F6163FBCE6")
    
public void unregisterForSubscriptionInfoReady(Handler h) {
        // This function should be overridden by the class CDMAPhone. Not implemented in GSMPhone.
        logUnexpectedCdmaMethodCall("unregisterForSubscriptionInfoReady");
    }

    /**
     * Returns true if OTA Service Provisioning needs to be performed.
     * If not overridden return false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.627 -0500", hash_original_method = "08A6E4B71FA09531A80AE7640F0ED8FC", hash_generated_method = "C7ABB7C754D0B803110DDF18481BA4D9")
    
public boolean needsOtaServiceProvisioning() {
        return false;
    }

    /**
     * Return true if number is an OTASP number.
     * If not overridden return false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.629 -0500", hash_original_method = "A73C77982F42451CD95F88A8474FB403", hash_generated_method = "64101C448BD2FD9B335C556F0C4C5BC3")
    
public  boolean isOtaSpNumber(String dialStr) {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.632 -0500", hash_original_method = "663CEDCAC596E020E0D8D3DEB84218C7", hash_generated_method = "5A787F39C776B8582D22CE666556D62F")
    
public void registerForCallWaiting(Handler h, int what, Object obj){
        // This function should be overridden by the class CDMAPhone. Not implemented in GSMPhone.
        logUnexpectedCdmaMethodCall("registerForCallWaiting");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.634 -0500", hash_original_method = "6A9877CFE858A21BAD2DF20E221EE6F8", hash_generated_method = "C0B531ED4EDAA03CCB10E461F8D59C00")
    
public void unregisterForCallWaiting(Handler h){
        // This function should be overridden by the class CDMAPhone. Not implemented in GSMPhone.
        logUnexpectedCdmaMethodCall("unregisterForCallWaiting");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.637 -0500", hash_original_method = "DCA99E7B790465429FB14A326BDABF1A", hash_generated_method = "310E0ABBDBAE39E3A63F0992A670C254")
    
public void registerForEcmTimerReset(Handler h, int what, Object obj) {
        // This function should be overridden by the class CDMAPhone. Not implemented in GSMPhone.
        logUnexpectedCdmaMethodCall("registerForEcmTimerReset");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.640 -0500", hash_original_method = "7FC556E6839E1551B3AA1598A94EB641", hash_generated_method = "C285DFF9BD7590EF7D583FD315F85AE4")
    
public void unregisterForEcmTimerReset(Handler h) {
        // This function should be overridden by the class CDMAPhone. Not implemented in GSMPhone.
        logUnexpectedCdmaMethodCall("unregisterForEcmTimerReset");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.643 -0500", hash_original_method = "9EA1B9B633F04B4B40F6D988C6C6EAE0", hash_generated_method = "EB0B0DB45D5F7BFD54BAFDB8B8FED187")
    
public void registerForSignalInfo(Handler h, int what, Object obj) {
        mCM.registerForSignalInfo(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.645 -0500", hash_original_method = "490F0951818D5A292B4D850AA9A9557C", hash_generated_method = "E9B84A1C8F0AB47469FE64777A5A0C6C")
    
public void unregisterForSignalInfo(Handler h) {
        mCM.unregisterForSignalInfo(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.647 -0500", hash_original_method = "9A93FB64A77E8F3AD75482A91959C175", hash_generated_method = "63E942E0C89D52F4B0F228F1546C0CA6")
    
public void registerForDisplayInfo(Handler h, int what, Object obj) {
        mCM.registerForDisplayInfo(h, what, obj);
    }

     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.650 -0500", hash_original_method = "1D7139AB5835E964A2112E0A96A55533", hash_generated_method = "C583A9CB92A41D85148E3564D6439706")
    
public void unregisterForDisplayInfo(Handler h) {
         mCM.unregisterForDisplayInfo(h);
     }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.652 -0500", hash_original_method = "735A13B0D1CB0B503F36D15D851EF79F", hash_generated_method = "B293BC0762C28A79EEDF8DA3FD4E54F3")
    
public void registerForNumberInfo(Handler h, int what, Object obj) {
        mCM.registerForNumberInfo(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.655 -0500", hash_original_method = "6DBE3FA0B44D5F0F3EA0C4D2C4C9DEA2", hash_generated_method = "B191FC3720E45260EE57C2BC3D72C78A")
    
public void unregisterForNumberInfo(Handler h) {
        mCM.unregisterForNumberInfo(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.658 -0500", hash_original_method = "D3A5B2415D3398E5BAA61633747135F3", hash_generated_method = "D7836D58C7E2F0B76CCB638AA7443066")
    
public void registerForRedirectedNumberInfo(Handler h, int what, Object obj) {
        mCM.registerForRedirectedNumberInfo(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.661 -0500", hash_original_method = "FEE62A9F06FB60B95297A2B9A46AFB0E", hash_generated_method = "4AEAB09EE793880B8658545A6CDD0EC2")
    
public void unregisterForRedirectedNumberInfo(Handler h) {
        mCM.unregisterForRedirectedNumberInfo(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.663 -0500", hash_original_method = "73B61604D8C534BA3038C74FC6F1FC84", hash_generated_method = "0CDE180C2401092D57B3E8F5F18FA7FF")
    
public void registerForLineControlInfo(Handler h, int what, Object obj) {
        mCM.registerForLineControlInfo( h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.666 -0500", hash_original_method = "5D4E66E94B3A48B485E9B9F7921C3B01", hash_generated_method = "F182AA8F36E419275155F4A2AFDB7631")
    
public void unregisterForLineControlInfo(Handler h) {
        mCM.unregisterForLineControlInfo(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.668 -0500", hash_original_method = "590438B1B11ADBD08E7A44131058572B", hash_generated_method = "A7B7F182187495FB803750DCE9D2189E")
    
public void registerFoT53ClirlInfo(Handler h, int what, Object obj) {
        mCM.registerFoT53ClirlInfo(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.670 -0500", hash_original_method = "034ED9AF183776C78D98034D25F265A2", hash_generated_method = "D01633A4B7CC9567685C680E78AA4FC2")
    
public void unregisterForT53ClirInfo(Handler h) {
        mCM.unregisterForT53ClirInfo(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.673 -0500", hash_original_method = "66D030845270A8F126DBBDF302E2A141", hash_generated_method = "C0B91E9129F671A371049A9AFB7560EF")
    
public void registerForT53AudioControlInfo(Handler h, int what, Object obj) {
        mCM.registerForT53AudioControlInfo( h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.676 -0500", hash_original_method = "C4F9238B8E9649490800210FA099DE0F", hash_generated_method = "5B414A89A01DC436533ADEF5623E6E05")
    
public void unregisterForT53AudioControlInfo(Handler h) {
        mCM.unregisterForT53AudioControlInfo(h);
    }

     @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.679 -0500", hash_original_method = "815749C135EEAFF1973468BF7BE05E75", hash_generated_method = "D95BE6ACEA836C34CDCB27C2450C08D2")
    
public void setOnEcbModeExitResponse(Handler h, int what, Object obj){
         // This function should be overridden by the class CDMAPhone. Not implemented in GSMPhone.
         logUnexpectedCdmaMethodCall("setOnEcbModeExitResponse");
     }

     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.681 -0500", hash_original_method = "ECE14734C7F2F497945A22923EF26B0A", hash_generated_method = "442083DA9295B5DBC20A6D321F009B84")
    
public void unsetOnEcbModeExitResponse(Handler h){
        // This function should be overridden by the class CDMAPhone. Not implemented in GSMPhone.
         logUnexpectedCdmaMethodCall("unsetOnEcbModeExitResponse");
     }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.684 -0500", hash_original_method = "04CB7EBB1F2C2F5A1F94C891E246EC01", hash_generated_method = "9D299C28DBB6FC9BFE52EECC7AFBC0D1")
    
public String[] getActiveApnTypes() {
        return mDataConnectionTracker.getActiveApnTypes();
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.686 -0500", hash_original_method = "D30362481D576467EFD2166079686420", hash_generated_method = "244589E8374575BC97DFD5FFE49ACE88")
    
public String getActiveApnHost(String apnType) {
        return mDataConnectionTracker.getActiveApnString(apnType);
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.688 -0500", hash_original_method = "C11066F2623E480AC3C630C6CBD36058", hash_generated_method = "AB8126C22240EE8471D5600526EEDFFF")
    
public LinkProperties getLinkProperties(String apnType) {
        return mDataConnectionTracker.getLinkProperties(apnType);
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.691 -0500", hash_original_method = "035A2689990E07C724064B64E344B05A", hash_generated_method = "96BB22BCF7D4D3876808D7085E00A8C0")
    
public LinkCapabilities getLinkCapabilities(String apnType) {
        return mDataConnectionTracker.getLinkCapabilities(apnType);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.693 -0500", hash_original_method = "8FC26686EA9F953DFAC2E032B4ED9578", hash_generated_method = "FF750DFD6CFA361EEE85AA0852400079")
    
public int enableApnType(String type) {
        return mDataConnectionTracker.enableApnType(type);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.696 -0500", hash_original_method = "EEF84E670D69A41297DD287EFE00D426", hash_generated_method = "2AA28A9D58F0D922A5EC3986AF5A5906")
    
public int disableApnType(String type) {
        return mDataConnectionTracker.disableApnType(type);
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.698 -0500", hash_original_method = "0E7DDF56B2AD7D089B639A5A4C8707B8", hash_generated_method = "6EF5CFF1987C347DE7F4EEC7D620CB51")
    
public boolean isDataConnectivityPossible() {
        return isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.700 -0500", hash_original_method = "D1C4C7300A786DB2DE96913E45D224C3", hash_generated_method = "B7899DCF5E177E5A8EEED45A7156982E")
    
public boolean isDataConnectivityPossible(String apnType) {
        return ((mDataConnectionTracker != null) &&
                (mDataConnectionTracker.isDataPossible(apnType)));
    }

    /**
     * Notify registrants of a new ringing Connection.
     * Subclasses of Phone probably want to replace this with a
     * version scoped to their packages
     */
    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.704 -0500", hash_original_method = "78C210B796AC9661779AB486B8F70A37", hash_generated_method = "486D4F98E48E8CC01D31B91CD4B954C5")
    
protected void notifyNewRingingConnectionP(Connection cn) {
        if (!mIsVoiceCapable)
            return;
        AsyncResult ar = new AsyncResult(null, cn, null);
        mNewRingingConnectionRegistrants.notifyRegistrants(ar);
    }

    /**
     * Notify registrants of a RING event.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.707 -0500", hash_original_method = "E77A37BE6BEB7ED310F1875BE08F1BE3", hash_generated_method = "2080C7DA7AE6CCC7CD8D2101216AD2F0")
    
private void notifyIncomingRing() {
        if (!mIsVoiceCapable)
            return;
        AsyncResult ar = new AsyncResult(null, this, null);
        mIncomingRingRegistrants.notifyRegistrants(ar);
    }

    /**
     * Send the incoming call Ring notification if conditions are right.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.709 -0500", hash_original_method = "E1A10981C368CA09B703B9716F98BBE5", hash_generated_method = "D1AD4B0F56216C5B38E7CBD9AC091AFE")
    
private void sendIncomingCallRingNotification(int token) {
        if (mIsVoiceCapable && !mDoesRilSendMultipleCallRing &&
                (token == mCallRingContinueToken)) {
            Log.d(LOG_TAG, "Sending notifyIncomingRing");
            notifyIncomingRing();
            sendMessageDelayed(
                    obtainMessage(EVENT_CALL_RING_CONTINUE, token, 0), mCallRingDelay);
        } else {
            Log.d(LOG_TAG, "Ignoring ring notification request,"
                    + " mDoesRilSendMultipleCallRing=" + mDoesRilSendMultipleCallRing
                    + " token=" + token
                    + " mCallRingContinueToken=" + mCallRingContinueToken
                    + " mIsVoiceCapable=" + mIsVoiceCapable);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.712 -0500", hash_original_method = "3242BA07687ED62C3518200E2F9FB53F", hash_generated_method = "050D61F69CBAFCE596A8AA872A196AF6")
    
public boolean isCspPlmnEnabled() {
        // This function should be overridden by the class GSMPhone.
        // Not implemented in CDMAPhone.
        logUnexpectedGsmMethodCall("isCspPlmnEnabled");
        return false;
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.714 -0500", hash_original_method = "B1975F1CE49D1493C79D22CB0A320E47", hash_generated_method = "374DFC8A642333CD41AACCB17F565F76")
    
public IsimRecords getIsimRecords() {
        Log.e(LOG_TAG, "getIsimRecords() is only supported on LTE devices");
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.716 -0500", hash_original_method = "0D543BE7AD53581775829ADD7A6346BC", hash_generated_method = "E27A17463A995F2A748B9C37743A6F1D")
    
public void requestIsimAuthentication(String nonce, Message result) {
        Log.e(LOG_TAG, "requestIsimAuthentication() is only supported on LTE devices");
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.718 -0500", hash_original_method = "60A69213567A9812671ADC8B66C5585F", hash_generated_method = "14691208C2A506182C19ADE3E0F2C529")
    
public String getMsisdn() {
        logUnexpectedGsmMethodCall("getMsisdn");
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.724 -0500", hash_original_method = "3916B54807B55A36DB6B185AF3F43F9B", hash_generated_method = "3DFF080B12E10D8217B8AF23718A4F98")
    
public DataState getDataConnectionState() {
        return getDataConnectionState(APN_TYPE_DEFAULT);
    }

    // Called by SimRecords which is constructed with a PhoneBase instead of a GSMPhone.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.730 -0500", hash_original_method = "3E0F86392A957104B8FBDE9CC6F59C4C", hash_generated_method = "A49BE8634DF9B1C2DD511D01E520C7C8")
    
public void notifyCallForwardingIndicator() {
        // This function should be overridden by the class GSMPhone. Not implemented in CDMAPhone.
        Log.e(LOG_TAG, "Error! This function should never be executed, inactive CDMAPhone.");
    }

    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.732 -0500", hash_original_method = "920CBD0242A41CC292CB0CFE1F874523", hash_generated_method = "8B0F221A7F4D8B381B69BD63CFF8A5C5")
    
public void notifyDataConnectionFailed(String reason, String apnType) {
        mNotifier.notifyDataConnectionFailed(this, reason, apnType);
    }

    /**
     * {@inheritDoc}
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.735 -0500", hash_original_method = "1FC25F07E17A01F63F573F1677883F29", hash_generated_method = "A5111B1BC1E3C2FBAAF64ED78AB0E69A")
    
@Override
    public int getLteOnCdmaMode() {
        return mCM.getLteOnCdmaMode();
    }

    /**
     * Sets the SIM voice message waiting indicator records.
     * @param line GSM Subscriber Profile Number, one-based. Only '1' is supported
     * @param countWaiting The number of messages waiting, if known. Use
     *                     -1 to indicate that an unknown number of
     *                      messages are waiting
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.737 -0500", hash_original_method = "B0657B144D34E1997F6D522B080186C1", hash_generated_method = "66CDF6AB5C378243CB5E9CA14A325B60")
    
@Override
    public void setVoiceMessageWaiting(int line, int countWaiting) {
        mIccRecords.setVoiceMessageWaiting(line, countWaiting);
    }

    /**
     * Gets the USIM service table from the UICC, if present and available.
     * @return an interface to the UsimServiceTable record, or null if not available
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:20.740 -0500", hash_original_method = "099D11C8CFE57EFDDC5741548A2AEB3D", hash_generated_method = "0670986D5525E46337523EBE06C81B07")
    
@Override
    public UsimServiceTable getUsimServiceTable() {
        return mIccRecords.getUsimServiceTable();
    }
}

