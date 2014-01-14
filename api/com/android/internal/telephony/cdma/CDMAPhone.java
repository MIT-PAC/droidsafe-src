package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.ActivityManagerNative;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.net.Uri;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Registrant;
import android.os.RegistrantList;
import android.os.SystemProperties;
import android.preference.PreferenceManager;
import android.provider.Telephony;
import android.telephony.CellLocation;
import android.telephony.PhoneNumberUtils;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.text.TextUtils;
import android.util.Log;

import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.CallTracker;
import com.android.internal.telephony.CommandException;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.IccException;
import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.IccPhoneBookInterfaceManager;
import com.android.internal.telephony.IccSmsInterfaceManager;
import com.android.internal.telephony.MccTable;
import com.android.internal.telephony.MmiCode;
import com.android.internal.telephony.OperatorInfo;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneBase;
import com.android.internal.telephony.PhoneNotifier;
import com.android.internal.telephony.PhoneProxy;
import com.android.internal.telephony.PhoneSubInfo;
import com.android.internal.telephony.ServiceStateTracker;
import com.android.internal.telephony.TelephonyIntents;
import com.android.internal.telephony.TelephonyProperties;
import com.android.internal.telephony.UUSInfo;
import com.android.internal.telephony.cat.CatService;

public class CDMAPhone extends PhoneBase {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.582 -0500", hash_original_method = "0987EB9B752C2AE0A39CB183394EC719", hash_generated_method = "BD516A911B886CE33B25F5EEA604FBDE")
    
private static boolean isIs683OtaSpDialStr(String dialStr) {
        int sysSelCodeInt;
        boolean isOtaspDialString = false;
        int dialStrLen = dialStr.length();

        if (dialStrLen == IS683A_FEATURE_CODE_NUM_DIGITS) {
            if (dialStr.equals(IS683A_FEATURE_CODE)) {
                isOtaspDialString = true;
            }
        } else {
            sysSelCodeInt = extractSelCodeFromOtaSpNum(dialStr);
            switch (sysSelCodeInt) {
                case IS683_CONST_800MHZ_A_BAND:
                case IS683_CONST_800MHZ_B_BAND:
                case IS683_CONST_1900MHZ_A_BLOCK:
                case IS683_CONST_1900MHZ_B_BLOCK:
                case IS683_CONST_1900MHZ_C_BLOCK:
                case IS683_CONST_1900MHZ_D_BLOCK:
                case IS683_CONST_1900MHZ_E_BLOCK:
                case IS683_CONST_1900MHZ_F_BLOCK:
                    isOtaspDialString = true;
                    break;
                default:
                    break;
            }
        }
        return isOtaspDialString;
    }
    /**
     * This function extracts the system selection code from the dial string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.585 -0500", hash_original_method = "A91F01B0D3E07B9BAFA73C694BEFBC5B", hash_generated_method = "B9D13965655950C2F38660C7F9171895")
    
private static int extractSelCodeFromOtaSpNum(String dialStr) {
        int dialStrLen = dialStr.length();
        int sysSelCodeInt = INVALID_SYSTEM_SELECTION_CODE;

        if ((dialStr.regionMatches(0, IS683A_FEATURE_CODE,
                                   0, IS683A_FEATURE_CODE_NUM_DIGITS)) &&
            (dialStrLen >= (IS683A_FEATURE_CODE_NUM_DIGITS +
                            IS683A_SYS_SEL_CODE_NUM_DIGITS))) {
                // Since we checked the condition above, the system selection code
                // extracted from dialStr will not cause any exception
                sysSelCodeInt = Integer.parseInt (
                                dialStr.substring (IS683A_FEATURE_CODE_NUM_DIGITS,
                                IS683A_FEATURE_CODE_NUM_DIGITS + IS683A_SYS_SEL_CODE_NUM_DIGITS));
        }
        if (DBG) Log.d(LOG_TAG, "extractSelCodeFromOtaSpNum " + sysSelCodeInt);
        return sysSelCodeInt;
    }

    /**
     * This function checks if the system selection code extracted from
     * the dial string "sysSelCodeInt' is the system selection code specified
     * in the carrier ota sp number schema "sch".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.588 -0500", hash_original_method = "68BC2FB84293153DDA759DD543D07116", hash_generated_method = "E9D95458346F1EDE704F92515B0B8589")
    
private static boolean
    checkOtaSpNumBasedOnSysSelCode (int sysSelCodeInt, String sch[]) {
        boolean isOtaSpNum = false;
        try {
            // Get how many number of system selection code ranges
            int selRc = Integer.parseInt((String)sch[1]);
            for (int i = 0; i < selRc; i++) {
                if (!TextUtils.isEmpty(sch[i+2]) && !TextUtils.isEmpty(sch[i+3])) {
                    int selMin = Integer.parseInt((String)sch[i+2]);
                    int selMax = Integer.parseInt((String)sch[i+3]);
                    // Check if the selection code extracted from the dial string falls
                    // within any of the range pairs specified in the schema.
                    if ((sysSelCodeInt >= selMin) && (sysSelCodeInt <= selMax)) {
                        isOtaSpNum = true;
                        break;
                    }
                }
            }
        } catch (NumberFormatException ex) {
            // If the carrier ota sp number schema is not correct, we still allow dial
            // and only log the error:
            Log.e(LOG_TAG, "checkOtaSpNumBasedOnSysSelCode, error", ex);
        }
        return isOtaSpNum;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.195 -0500", hash_original_field = "DB10E3AE28CC9996A816C3CCD7216A83", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.197 -0500", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.200 -0500", hash_original_field = "74934489B2E85CCAB931628AFA1EFD87", hash_generated_field = "E6DA1D723C3EE1AB56712584EA58C137")

    private static final int DEFAULT_ECM_EXIT_TIMER_VALUE = 300000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.202 -0500", hash_original_field = "61BD13ED0C0DA038D1A4CAA5E3932C4D", hash_generated_field = "DBE7E6AE93BA06B2FF1DBE92EBF7667B")

    static final String VM_COUNT_CDMA = "vm_count_key_cdma";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.204 -0500", hash_original_field = "B408A12041139C63061816F6DA9A26B8", hash_generated_field = "C50FD41AD9C8ECFDE260B639E8718D3D")

    private static final String VM_NUMBER_CDMA = "vm_number_key_cdma";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.209 -0500", hash_original_field = "5B7E705CBAEA08F072CADF20CE6F0D8A", hash_generated_field = "7149CAB7A993D6EFECE4128061F9865F")

    static final int RESTART_ECM_TIMER = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.212 -0500", hash_original_field = "21D74447C122A9B757F04D11303DF058", hash_generated_field = "0BF8B228276AC1D84F7C2766F8B74E6C")

    static final int CANCEL_ECM_TIMER = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.264 -0500", hash_original_field = "E124B1A36D5C4AD52F3AE3C0129E2EF4", hash_generated_field = "1B6AA95D9706EED43D662EF600D64CB5")

    static String PROPERTY_CDMA_HOME_OPERATOR_NUMERIC = "ro.cdma.home.operator.numeric";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.549 -0500", hash_original_field = "29C6831FDA9A4D4E4FC6067E5B7837E8", hash_generated_field = "8D504081DB72AA9930792378E569BE2E")

    private static final String IS683A_FEATURE_CODE = "*228";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.552 -0500", hash_original_field = "5B81D9D3C2C78BC9AFC3BBCAE6E9EB2A", hash_generated_field = "6B01468F83B67C83DBE6AEB2D62A09FF")

    private static final int IS683A_FEATURE_CODE_NUM_DIGITS = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.555 -0500", hash_original_field = "3348850D898D66C26F0EBDAF05519C46", hash_generated_field = "DA2F29DBADB6D87260FE5B4BED8B1598")

    private static final int IS683A_SYS_SEL_CODE_NUM_DIGITS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.557 -0500", hash_original_field = "5D490B0061E1E5EFF510945174BF8D37", hash_generated_field = "E358300F1015F9A17C96E8811D0A4AD9")

    private static final int IS683A_SYS_SEL_CODE_OFFSET = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.559 -0500", hash_original_field = "30EF32DF76374E29716C1BF9FD0EB4A8", hash_generated_field = "98531D0FD7604827F4C9BCEA781B49A3")

    private static final int IS683_CONST_800MHZ_A_BAND = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.562 -0500", hash_original_field = "323C2BB84CC9AF063AC334E65DC5D067", hash_generated_field = "0C7295C5D8889FCCE0C85B637D40E60C")

    private static final int IS683_CONST_800MHZ_B_BAND = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.564 -0500", hash_original_field = "5745FC4367EE843C5DDA1618C6700666", hash_generated_field = "489A1CED9728DCA2C0C1D3DFC6A97DA7")

    private static final int IS683_CONST_1900MHZ_A_BLOCK = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.567 -0500", hash_original_field = "BA331E691040335E695EEA723023546A", hash_generated_field = "CCF6ADEAC5D925D88FECCAAF8BA9CB9A")

    private static final int IS683_CONST_1900MHZ_B_BLOCK = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.569 -0500", hash_original_field = "16EB69045377908A809DBE19AF625271", hash_generated_field = "4A09DC42BBD46B04747F40997180D304")

    private static final int IS683_CONST_1900MHZ_C_BLOCK = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.572 -0500", hash_original_field = "AFAB70DD9018F0F4724ED7995F191CB0", hash_generated_field = "A402BF3C8CF075F873509D0D2B17E022")

    private static final int IS683_CONST_1900MHZ_D_BLOCK = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.575 -0500", hash_original_field = "2135F2C7CF28EB107B89B97D5186E2A9", hash_generated_field = "360201E7861089684816302DB16F5849")

    private static final int IS683_CONST_1900MHZ_E_BLOCK = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.577 -0500", hash_original_field = "97E47F14A15FCCFA4163F5729F2A411D", hash_generated_field = "D6596E49D61F4540FAE2D5DA6864F28B")

    private static final int IS683_CONST_1900MHZ_F_BLOCK = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.580 -0500", hash_original_field = "F20108D3EAEE046AD0B2C1206D9126A5", hash_generated_field = "0DE336CC04DA9F72A5B4A85D6CE8519B")

    private static final int INVALID_SYSTEM_SELECTION_CODE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.591 -0500", hash_original_field = "0D124AA50B5B2BA804CFE4C8250B6D29", hash_generated_field = "3B856449FB335591B969AF4271B7E4F3")

    // It separates by comma and/or whitespace.
    private static Pattern pOtaSpNumSchema = Pattern.compile("[,\\s]+");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.207 -0500", hash_original_field = "0E33BD936C9549C1C6DF9D467F2C275B", hash_generated_field = "EC3246CB1DC699CB7AAC1E49E6B00916")

    private String mVmNumber = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.214 -0500", hash_original_field = "FB56FB2CCEDB5FF40D60B0E1FF012DC7", hash_generated_field = "FDAB9DB3AAF59F09B62BB60232607A11")

    // Instance Variables
    CdmaCallTracker mCT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.216 -0500", hash_original_field = "97103F1B8DA1A01BC27456D6E3D45BD7", hash_generated_field = "97103F1B8DA1A01BC27456D6E3D45BD7")

    CdmaServiceStateTracker mSST;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.218 -0500", hash_original_field = "D1A76B98E2C9695E066872EF0F2A70D1", hash_generated_field = "D1A76B98E2C9695E066872EF0F2A70D1")

    ArrayList <CdmaMmiCode> mPendingMmis = new ArrayList<CdmaMmiCode>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.220 -0500", hash_original_field = "CC6C54ADD522D3CBE4AB79FC4C1AC885", hash_generated_field = "CC6C54ADD522D3CBE4AB79FC4C1AC885")

    RuimPhoneBookInterfaceManager mRuimPhoneBookInterfaceManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.222 -0500", hash_original_field = "52B0967754C377F16D6ECE26A27604BC", hash_generated_field = "52B0967754C377F16D6ECE26A27604BC")

    RuimSmsInterfaceManager mRuimSmsInterfaceManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.224 -0500", hash_original_field = "F066FAD7B5AEEA27E2872ED159BF1CA4", hash_generated_field = "F066FAD7B5AEEA27E2872ED159BF1CA4")

    PhoneSubInfo mSubInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.227 -0500", hash_original_field = "5D6E15ED8D3AB433E5BB540845A155BB", hash_generated_field = "5D6E15ED8D3AB433E5BB540845A155BB")

    EriManager mEriManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.229 -0500", hash_original_field = "33E56F28B2B8FE4608887A854590880D", hash_generated_field = "33E56F28B2B8FE4608887A854590880D")

    WakeLock mWakeLock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.231 -0500", hash_original_field = "8E0942E84D2F17846D93DF1A3D310CA4", hash_generated_field = "8E0942E84D2F17846D93DF1A3D310CA4")

    CatService mCcatService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.234 -0500", hash_original_field = "EB526E63A01A37CC4D784105E403202F", hash_generated_field = "962FB4C4696AA137E9F4B34F6067EBE9")

    private final RegistrantList mNvLoadedRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.236 -0500", hash_original_field = "B2BDE0FF3BB1B204BD56EB322DBBA7EB", hash_generated_field = "FDA1F534CB258FBCC142BC692B71ACD1")

    private final RegistrantList mEriFileLoadedRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.239 -0500", hash_original_field = "C4139812F6EDC44604620F9AEC973F71", hash_generated_field = "5B4BDBC7A862DE1A873EE80476741013")

    private final RegistrantList mEcmTimerResetRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.241 -0500", hash_original_field = "6FE3CE7006FABA1EAD2CD3F8A1DA785C", hash_generated_field = "36CAE22B3F2633DEA17E8581F7D08A13")

    //the emergency callback mode
    //keep track of if phone is in emergency callback mode
    private boolean mIsPhoneInEcmState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.243 -0500", hash_original_field = "916F032B0F8DD1730EC9DE9DA600589C", hash_generated_field = "1BDAC9D71123A8DEB653B2C84AF01BA0")

    private Registrant mEcmExitRespRegistrant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.245 -0500", hash_original_field = "87110AB01243FB897510B65582BCA335", hash_generated_field = "A314A9B894E97303A992D075673C95F0")

    protected String mImei;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.247 -0500", hash_original_field = "802D89AD0B9D3DF89A4EF610905A2C56", hash_generated_field = "86781DA86EE57C5A1DD8A1C30699806C")

    protected String mImeiSv;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.249 -0500", hash_original_field = "38306DCEF6A610A3EBA14E9F914F0D95", hash_generated_field = "D60FA66B4CDB744384FC242287466EE9")

    private String mEsn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.252 -0500", hash_original_field = "F3705E2C6BBFC28E6E83D2C20500578C", hash_generated_field = "4AF7BD5643CFD768CB253CD96C809185")

    private String mMeid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.254 -0500", hash_original_field = "8808B95D0C28D9ADB1A4E42988120037", hash_generated_field = "317DA458812FD117268BB82503CFDA82")

    private String mCarrierOtaSpNumSchema;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.000 -0400", hash_original_field = "5E0153DE5EDFE60861980DB630071DCD", hash_generated_field = "A9D48B4F37E6DEE9FEDDDBF0EA9949F0")

    private Runnable mExitEcmRunnable = new Runnable() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.000 -0400", hash_original_method = "F3DC5BFDA25D02344EBFE8F4AEC767D8", hash_generated_method = "13E58FFF08C64D739C7C2CEA1DFD40E8")
        @Override
        public void run() {
            exitEmergencyCallbackMode();
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.262 -0500", hash_original_field = "126D29D3ACD6141B3CF1C156D9BC8C27", hash_generated_field = "126D29D3ACD6141B3CF1C156D9BC8C27")

    Registrant mPostDialHandler;

    // Constructors
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.267 -0500", hash_original_method = "DAE6B8BFE7F70789DB7C3B99D4D5F7DA", hash_generated_method = "EBB8B8BCE7E9987230886B5CD942BC53")
    
public CDMAPhone(Context context, CommandsInterface ci, PhoneNotifier notifier) {
        super(notifier, context, ci, false);
        initSstIcc();
        init(context, notifier);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.269 -0500", hash_original_method = "467D4326BF1EF0C31B8D509189D4E2E0", hash_generated_method = "B857F076373E06F5283B81055EBF0CB3")
    
public CDMAPhone(Context context, CommandsInterface ci, PhoneNotifier notifier,
            boolean unitTestMode) {
        super(notifier, context, ci, unitTestMode);
        initSstIcc();
        init(context, notifier);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.272 -0500", hash_original_method = "1B7DFBB42AE4FBFECC004BFFF3CFFDDB", hash_generated_method = "F54425B6E5642350CB23F2494758C2EC")
    
protected void initSstIcc() {
        mSST = new CdmaServiceStateTracker(this);
        mIccRecords = new RuimRecords(this);
        mIccCard = new RuimCard(this, LOG_TAG, DBG);
        mIccFileHandler = new RuimFileHandler(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.275 -0500", hash_original_method = "8461B888D034831850AE73E07FC3F149", hash_generated_method = "C2E4DEDA1A816AD910C7B918EC724FF8")
    
protected void init(Context context, PhoneNotifier notifier) {
        mCM.setPhoneType(Phone.PHONE_TYPE_CDMA);
        mCT = new CdmaCallTracker(this);
        mSMS = new CdmaSMSDispatcher(this, mSmsStorageMonitor, mSmsUsageMonitor);
        mDataConnectionTracker = new CdmaDataConnectionTracker (this);
        mRuimPhoneBookInterfaceManager = new RuimPhoneBookInterfaceManager(this);
        mRuimSmsInterfaceManager = new RuimSmsInterfaceManager(this, mSMS);
        mSubInfo = new PhoneSubInfo(this);
        mEriManager = new EriManager(this, context, EriManager.ERI_FROM_XML);
        mCcatService = CatService.getInstance(mCM, mIccRecords, mContext,
                mIccFileHandler, mIccCard);

        mCM.registerForAvailable(this, EVENT_RADIO_AVAILABLE, null);
        mIccRecords.registerForRecordsLoaded(this, EVENT_RUIM_RECORDS_LOADED, null);
        mCM.registerForOffOrNotAvailable(this, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        mCM.registerForOn(this, EVENT_RADIO_ON, null);
        mCM.setOnSuppServiceNotification(this, EVENT_SSN, null);
        mSST.registerForNetworkAttached(this, EVENT_REGISTERED_TO_NETWORK, null);
        mCM.registerForNVReady(this, EVENT_NV_READY, null);
        mCM.setEmergencyCallbackMode(this, EVENT_EMERGENCY_CALLBACK_MODE_ENTER, null);

        PowerManager pm
            = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,LOG_TAG);

        //Change the system setting
        SystemProperties.set(TelephonyProperties.CURRENT_ACTIVE_PHONE,
                Integer.toString(Phone.PHONE_TYPE_CDMA));

        // This is needed to handle phone process crashes
        String inEcm=SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
        mIsPhoneInEcmState = inEcm.equals("true");
        if (mIsPhoneInEcmState) {
            // Send a message which will invoke handleExitEmergencyCallbackMode
            mCM.exitEmergencyCallbackMode(obtainMessage(EVENT_EXIT_EMERGENCY_CALLBACK_RESPONSE));
        }

        // get the string that specifies the carrier OTA Sp number
        mCarrierOtaSpNumSchema = SystemProperties.get(
                TelephonyProperties.PROPERTY_OTASP_NUM_SCHEMA,"");

        // Sets operator alpha property by retrieving from build-time system property
        String operatorAlpha = SystemProperties.get("ro.cdma.home.operator.alpha");
        setSystemProperty(PROPERTY_ICC_OPERATOR_ALPHA, operatorAlpha);

        // Sets operator numeric property by retrieving from build-time system property
        String operatorNumeric = SystemProperties.get(PROPERTY_CDMA_HOME_OPERATOR_NUMERIC);
        setSystemProperty(PROPERTY_ICC_OPERATOR_NUMERIC, operatorNumeric);

        // Sets iso country property by retrieving from build-time system property
        setIsoCountryProperty(operatorNumeric);

        // Sets current entry in the telephony carrier table
        updateCurrentCarrierInProvider(operatorNumeric);

        // Notify voicemails.
        notifier.notifyMessageWaitingChanged(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.278 -0500", hash_original_method = "9DE3C78959AC59CCA27F149210FA77A8", hash_generated_method = "35655D5B597F93CBC493649FED28C1FE")
    
@Override
    public void dispose() {
        synchronized(PhoneProxy.lockForRadioTechnologyChange) {
            super.dispose();
            log("dispose");

            //Unregister from all former registered events
            mIccRecords.unregisterForRecordsLoaded(this); //EVENT_RUIM_RECORDS_LOADED
            mCM.unregisterForAvailable(this); //EVENT_RADIO_AVAILABLE
            mCM.unregisterForOffOrNotAvailable(this); //EVENT_RADIO_OFF_OR_NOT_AVAILABLE
            mCM.unregisterForOn(this); //EVENT_RADIO_ON
            mCM.unregisterForNVReady(this); //EVENT_NV_READY
            mSST.unregisterForNetworkAttached(this); //EVENT_REGISTERED_TO_NETWORK
            mCM.unSetOnSuppServiceNotification(this);
            removeCallbacks(mExitEcmRunnable);

            mPendingMmis.clear();

            //Force all referenced classes to unregister their former registered events
            mCT.dispose();
            mDataConnectionTracker.dispose();
            mSST.dispose();
            mSMS.dispose();
            mIccFileHandler.dispose(); // instance of RuimFileHandler
            mIccRecords.dispose();
            mIccCard.dispose();
            mRuimPhoneBookInterfaceManager.dispose();
            mRuimSmsInterfaceManager.dispose();
            mSubInfo.dispose();
            mEriManager.dispose();
            mCcatService.dispose();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.281 -0500", hash_original_method = "EE2FF8AAD85928FB8E8B4233881FEB3A", hash_generated_method = "BD7A2FA0BBF699D3B9193B748991673A")
    
@Override
    public void removeReferences() {
        log("removeReferences");
        super.removeReferences();
        mRuimPhoneBookInterfaceManager = null;
        mRuimSmsInterfaceManager = null;
        mSMS = null;
        mSubInfo = null;
        mIccRecords = null;
        mIccFileHandler = null;
        mIccCard = null;
        mDataConnectionTracker = null;
        mCT = null;
        mSST = null;
        mEriManager = null;
        mCcatService = null;
        mExitEcmRunnable = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.284 -0500", hash_original_method = "717E537581BE31A7DC523FEE6B0DDE4B", hash_generated_method = "8D92CFDBD1467DC49F55E375F5AC343B")
    
@Override
    protected void finalize() {
        if(DBG) Log.d(LOG_TAG, "CDMAPhone finalized");
        if (mWakeLock.isHeld()) {
            Log.e(LOG_TAG, "UNEXPECTED; mWakeLock is held when finalizing.");
            mWakeLock.release();
        }
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.286 -0500", hash_original_method = "DA0F221C2247572C4D631280E4033E9A", hash_generated_method = "D478D89558ABAB62076DEF8330267072")
    
public ServiceState getServiceState() {
        return mSST.ss;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.287 -0500", hash_original_method = "79AFD9B845E4547B981131DAC9E3A14D", hash_generated_method = "42619EEC092A0EA3A9A304ABD8213F11")
    
public CallTracker getCallTracker() {
        return mCT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.289 -0500", hash_original_method = "8AEFB373111A9C8AD30F3E8C75C461D2", hash_generated_method = "72A05AA87A2A1A968094CFC764157F1B")
    
public Phone.State getState() {
        return mCT.state;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.292 -0500", hash_original_method = "BD481539215D5A66E62B4E6909625141", hash_generated_method = "0972DE88684B8D25204CEF316794F013")
    
public ServiceStateTracker getServiceStateTracker() {
        return mSST;
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.294 -0500", hash_original_method = "B0BDAF041F7F636A26D0F46F60D4BC7B", hash_generated_method = "AA51FD82F5726333F9B4D3200D4E03E6")
    
public String getPhoneName() {
        return "CDMA";
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.296 -0500", hash_original_method = "94F6AF6179535CBD756D5B387D52C3CA", hash_generated_method = "1902FF2FF065E51F91D20A98ADE8D79D")
    
public int getPhoneType() {
        return Phone.PHONE_TYPE_CDMA;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.299 -0500", hash_original_method = "F828A2F1845194FFD82C471D7E89F726", hash_generated_method = "77C77E61F0708363D6512B579327CA40")
    
public boolean canTransfer() {
        Log.e(LOG_TAG, "canTransfer: not possible in CDMA");
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.301 -0500", hash_original_method = "31E0316605311F71BD2BE82139C4C7B1", hash_generated_method = "E5244017494750982297D9D954AD63FC")
    
public CdmaCall getRingingCall() {
        return mCT.ringingCall;
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.303 -0500", hash_original_method = "E892EC268DCFDF5C9C27A7DDC7E00573", hash_generated_method = "6702E37291BD1A4A6BCF74E7D5962B7E")
    
public void setMute(boolean muted) {
        mCT.setMute(muted);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.305 -0500", hash_original_method = "FA6E824680C8944626A1A959DCEA6499", hash_generated_method = "3E1D6B8514C7CF066D919EF92B2E88D5")
    
public boolean getMute() {
        return mCT.getMute();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.308 -0500", hash_original_method = "593DDE28AC9DCA9096C93A9D0D1099FC", hash_generated_method = "7023B3B81E4B771108792E3072A0C464")
    
public void conference() throws CallStateException {
        // three way calls in CDMA will be handled by feature codes
        Log.e(LOG_TAG, "conference: not possible in CDMA");
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.310 -0500", hash_original_method = "F90799FAE99EB431CF7F205DFD6DDD5D", hash_generated_method = "6055537918F17796B50CB3C83FD7F646")
    
public void enableEnhancedVoicePrivacy(boolean enable, Message onComplete) {
        this.mCM.setPreferredVoicePrivacy(enable, onComplete);
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.313 -0500", hash_original_method = "5CE753EAA3145BBCA6A00800B2884B4E", hash_generated_method = "50261C01964349CB227E54FD89224F8E")
    
public void getEnhancedVoicePrivacy(Message onComplete) {
        this.mCM.getPreferredVoicePrivacy(onComplete);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.315 -0500", hash_original_method = "B9932A8A8BD16A4F0D461DDC6FDE6B49", hash_generated_method = "B80DF2078F3D95B23D221CA91BE45CDD")
    
public void clearDisconnected() {
        mCT.clearDisconnected();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.317 -0500", hash_original_method = "34BFC6F1F77B77A760EA5A249CE3FEFD", hash_generated_method = "64627D467DE5128C1A1ED158F42B7240")
    
public DataActivityState getDataActivityState() {
        DataActivityState ret = DataActivityState.NONE;

        if (mSST.getCurrentDataConnectionState() == ServiceState.STATE_IN_SERVICE) {

            switch (mDataConnectionTracker.getActivity()) {
                case DATAIN:
                    ret = DataActivityState.DATAIN;
                break;

                case DATAOUT:
                    ret = DataActivityState.DATAOUT;
                break;

                case DATAINANDOUT:
                    ret = DataActivityState.DATAINANDOUT;
                break;

                case DORMANT:
                    ret = DataActivityState.DORMANT;
                break;
            }
        }
        return ret;
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.320 -0500", hash_original_method = "FCBAE539BB72BE21647FF37299DC2B96", hash_generated_method = "FCBAE539BB72BE21647FF37299DC2B96")
    
void
    notifySignalStrength() {
        mNotifier.notifySignalStrength(this);
    }

    @DSSink({DSSinkKind.VOIP})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.322 -0500", hash_original_method = "3B6D00BA5404778271A196326B2492C1", hash_generated_method = "CAA95CA07251672ED466FAC9893CC7A5")
    
public Connection
    dial (String dialString) throws CallStateException {
        // Need to make sure dialString gets parsed properly
        String newDialString = PhoneNumberUtils.stripSeparators(dialString);
        return mCT.dial(newDialString);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.324 -0500", hash_original_method = "C4CAEF0C07F27C620A5D9B835D3227D9", hash_generated_method = "CEF32D41440CAE236C10FE1F88ABD641")
    
public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        throw new CallStateException("Sending UUS information NOT supported in CDMA!");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.327 -0500", hash_original_method = "46D9BC6E3280014832CD8FC523C20E6E", hash_generated_method = "C1C229BFE464B33E6EAAFB029141C168")
    
public SignalStrength getSignalStrength() {
        return mSST.mSignalStrength;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.329 -0500", hash_original_method = "391334830335544CEFDB5805671813C7", hash_generated_method = "C1C0792304B41B118C3E9C8409E3A97C")
    
public boolean
    getMessageWaitingIndicator() {
        return (getVoiceMessageCount() > 0);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.331 -0500", hash_original_method = "A1DC624417B44DF11F4CA5E5B97277AF", hash_generated_method = "BA3596B4153247FC16E7830D599AFB86")
    
public List<? extends MmiCode>
    getPendingMmiCodes() {
        return mPendingMmis;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.333 -0500", hash_original_method = "7C5A8D3C952528E3E4A994337305A33B", hash_generated_method = "A97D2D9EB04172E71FECA2867A9A3CE3")
    
public void registerForSuppServiceNotification(
            Handler h, int what, Object obj) {
        Log.e(LOG_TAG, "method registerForSuppServiceNotification is NOT supported in CDMA!");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.335 -0500", hash_original_method = "9F7E8D6F89A6C75F0A7653B179AA02CE", hash_generated_method = "935B6AEF74D0824867BFC8475C8EA0F6")
    
public CdmaCall getBackgroundCall() {
        return mCT.backgroundCall;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.337 -0500", hash_original_method = "99F7E880D5431452FB99636E33872BD4", hash_generated_method = "7F4303F8D4E44CA58296F22DA6511502")
    
public boolean handleInCallMmiCommands(String dialString) {
        Log.e(LOG_TAG, "method handleInCallMmiCommands is NOT supported in CDMA!");
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.339 -0500", hash_original_method = "F6112A9AE3405415322B12D2CA172B80", hash_generated_method = "F6112A9AE3405415322B12D2CA172B80")
    
boolean isInCall() {
        CdmaCall.State foregroundCallState = getForegroundCall().getState();
        CdmaCall.State backgroundCallState = getBackgroundCall().getState();
        CdmaCall.State ringingCallState = getRingingCall().getState();

        return (foregroundCallState.isAlive() || backgroundCallState.isAlive() || ringingCallState
                .isAlive());
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.342 -0500", hash_original_method = "573D1DDDB474C2914324D2DBB21AD4BF", hash_generated_method = "AAD0237C8CD407660AE46C519726D826")
    
public void
    setNetworkSelectionModeAutomatic(Message response) {
        Log.e(LOG_TAG, "method setNetworkSelectionModeAutomatic is NOT supported in CDMA!");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.344 -0500", hash_original_method = "7239EAF7B36D814AB7CF7CD5314FF0C2", hash_generated_method = "572159E9CD0341F0F6CEF8E5E72BACE6")
    
public void unregisterForSuppServiceNotification(Handler h) {
        Log.e(LOG_TAG, "method unregisterForSuppServiceNotification is NOT supported in CDMA!");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.346 -0500", hash_original_method = "C62CCD6CF2D9D7F7FA17BB7B58067AAC", hash_generated_method = "52AF5C8600DFA81FDF4490B3A5F0068E")
    
public void
    acceptCall() throws CallStateException {
        mCT.acceptCall();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.349 -0500", hash_original_method = "A64616985F0D82C6750D71CF8DADC6F4", hash_generated_method = "C876DE01453AEC50846B853D1624B6C4")
    
public void
    rejectCall() throws CallStateException {
        mCT.rejectCall();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.351 -0500", hash_original_method = "4BD56579DA53A7A8E0646A63E1978FC8", hash_generated_method = "EE9FD5B84F981002A80E9AC478CE174B")
    
public void
    switchHoldingAndActive() throws CallStateException {
        mCT.switchWaitingOrHoldingAndActive();
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.353 -0500", hash_original_method = "B121BB30C6EA08968FF3C722126FC795", hash_generated_method = "E9C5DE106FB8363AD195D3B54E36A3A0")
    
public String getLine1Number() {
        return mSST.getMdnNumber();
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.355 -0500", hash_original_method = "3BC6D82D8BFD82220414E9A1151516B0", hash_generated_method = "D22ED79E26C68D68C4F6ABE8D7C20700")
    
public String getCdmaPrlVersion(){
        return mSST.getPrlVersion();
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.357 -0500", hash_original_method = "5F3989DCB2E6CEB13D99C9EB5DB3E7E9", hash_generated_method = "4816CD932BFA5359E78AC580C464821A")
    
public String getCdmaMin() {
        return mSST.getCdmaMin();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.360 -0500", hash_original_method = "8703C344BAEB4A9DC4BE8D85F2A2B471", hash_generated_method = "59008254C444669D98FF3978EF9CD63D")
    
public boolean isMinInfoReady() {
        return mSST.isMinInfoReady();
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.362 -0500", hash_original_method = "4561349219664D3BF60D1FEC45B8BB02", hash_generated_method = "103B8D824B224D4E273316551BCB7BA4")
    
public void getCallWaiting(Message onComplete) {
        mCM.queryCallWaiting(CommandsInterface.SERVICE_CLASS_VOICE, onComplete);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.365 -0500", hash_original_method = "6583EBFAAE11F5B271B0C202AB11C3E9", hash_generated_method = "80FF770A1CF7676AE7FE5F84ACA216E2")
    
public void
    setRadioPower(boolean power) {
        mSST.setRadioPower(power);
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.367 -0500", hash_original_method = "A71BC42B8E5B39F885F4E0F3CDCE1523", hash_generated_method = "816C11434E161A0E39B3ACDB7F720F07")
    
public String getEsn() {
        return mEsn;
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.369 -0500", hash_original_method = "7E7AAA89C01F3229F1902E361A6CD86F", hash_generated_method = "C3ECA3DAB49A26D4050A805454C2E5AE")
    
public String getMeid() {
        return mMeid;
    }

    //returns MEID or ESN in CDMA
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.371 -0500", hash_original_method = "7766C412A244B7E9ACAC69FB73BBB546", hash_generated_method = "12B9F7E290D38B2457008D4145BA16DE")
    
public String getDeviceId() {
        String id = getMeid();
        if ((id == null) || id.matches("^0*$")) {
            Log.d(LOG_TAG, "getDeviceId(): MEID is not initialized use ESN");
            id = getEsn();
        }
        return id;
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.374 -0500", hash_original_method = "BA19C271165532D38DF9C2A2EC7580FC", hash_generated_method = "8E0288EBF47A6F95AEF52A3615EA559A")
    
public String getDeviceSvn() {
        Log.d(LOG_TAG, "getDeviceSvn(): return 0");
        return "0";
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.376 -0500", hash_original_method = "32994E1C8E091DA1F8318F6B29B65F50", hash_generated_method = "FB3C372299E8575AE6C112BBBE85907D")
    
public String getSubscriberId() {
        return mSST.getImsi();
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.378 -0500", hash_original_method = "FAD82CEAF9DD41800ADBC5F4734356D8", hash_generated_method = "A9DABCDEA80102C34F8B48AA17618E5A")
    
public String getImei() {
        Log.e(LOG_TAG, "IMEI is not available in CDMA");
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.380 -0500", hash_original_method = "3D81DB016065E96128526DD50CCAAE05", hash_generated_method = "5754D74FF715901E02B0033380EB13CB")
    
public boolean canConference() {
        Log.e(LOG_TAG, "canConference: not possible in CDMA");
        return false;
    }

    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.382 -0500", hash_original_method = "E38329BE2FF507326358BBAF596945E6", hash_generated_method = "AC8CC4104D0FCBE937A2BAB0898984B6")
    
public CellLocation getCellLocation() {
        return mSST.cellLoc;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.384 -0500", hash_original_method = "5D417D4C057D78BF0DEF3D949E557B3C", hash_generated_method = "BBA07BC770137735F45D482F3E51BBA7")
    
public CdmaCall getForegroundCall() {
        return mCT.foregroundCall;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.387 -0500", hash_original_method = "6287E103949DE4B29FC1760D95391284", hash_generated_method = "25D437E892D22A02ED1AAF37218DC2EF")
    
public void
    selectNetworkManually(OperatorInfo network,
            Message response) {
        Log.e(LOG_TAG, "selectNetworkManually: not possible in CDMA");
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.389 -0500", hash_original_method = "A54F4B18F21B3A39961648F4BDA2F061", hash_generated_method = "95390C406E6E2FA690715623B2F3AA59")
    
public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        mPostDialHandler = new Registrant(h, what, obj);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.391 -0500", hash_original_method = "3D832E28FC020C3451E1ECD577F7705D", hash_generated_method = "255B7B846A2B7030BCDC2D90A2156DB1")
    
public boolean handlePinMmi(String dialString) {
        CdmaMmiCode mmi = CdmaMmiCode.newFromDialString(dialString, this);

        if (mmi == null) {
            Log.e(LOG_TAG, "Mmi is NULL!");
            return false;
        } else if (mmi.isPukCommand()) {
            mPendingMmis.add(mmi);
            mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
            mmi.processCode();
            return true;
        }
        Log.e(LOG_TAG, "Unrecognized mmi!");
        return false;
    }

    /**
     * Removes the given MMI from the pending list and notifies registrants that
     * it is complete.
     *
     * @param mmi MMI that is done
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.393 -0500", hash_original_method = "574EFAE567BAC054324E4789AB0ACA21", hash_generated_method = "1670645142CBE11F3C7719961E4505B3")
    
void onMMIDone(CdmaMmiCode mmi) {
        /*
         * Only notify complete if it's on the pending list. Otherwise, it's
         * already been handled (eg, previously canceled).
         */
        if (mPendingMmis.remove(mmi)) {
            mMmiCompleteRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
        }
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.397 -0500", hash_original_method = "8885A01E1E8D54116E470B45B5958287", hash_generated_method = "41D10830F5B49D2FC803108757C8E33B")
    
public void setLine1Number(String alphaTag, String number, Message onComplete) {
        Log.e(LOG_TAG, "setLine1Number: not possible in CDMA");
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.399 -0500", hash_original_method = "9F48D83DEE90081423E43167EA0B9F32", hash_generated_method = "F937F6BCEBC9FA9F744B3A73B1E865C9")
    
public void setCallWaiting(boolean enable, Message onComplete) {
        Log.e(LOG_TAG, "method setCallWaiting is NOT supported in CDMA!");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.401 -0500", hash_original_method = "96CADC2872DB4F7FDEDEDD322815973F", hash_generated_method = "BE019B870DE311876CD1A9479D007B37")
    
public void updateServiceLocation() {
        mSST.enableSingleLocationUpdate();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.403 -0500", hash_original_method = "910AE5D7D70CC37EC2511A21C3761E3A", hash_generated_method = "9007A6C5DAD94BD2A91DDACD886335AD")
    
public void setDataRoamingEnabled(boolean enable) {
        mDataConnectionTracker.setDataOnRoamingEnabled(enable);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.405 -0500", hash_original_method = "610E8C97A082907006BA954BE534B9EC", hash_generated_method = "D8DEA96610A36E252ED25739D538E96D")
    
public void registerForCdmaOtaStatusChange(Handler h, int what, Object obj) {
        mCM.registerForCdmaOtaProvision(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.408 -0500", hash_original_method = "BBA791A1BBD0F6B3058E9616045D8082", hash_generated_method = "600C838CE833174A9AC36F08FF8A1C33")
    
public void unregisterForCdmaOtaStatusChange(Handler h) {
        mCM.unregisterForCdmaOtaProvision(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.410 -0500", hash_original_method = "832A3DCDB2173345E213F4FEE097F4C8", hash_generated_method = "944EDC6675150F1F360C10683A522512")
    
public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        mSST.registerForSubscriptionInfoReady(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.412 -0500", hash_original_method = "8678E3A1722432B3AEE20746D6239509", hash_generated_method = "ABD461EDEA984A8D307F2202B7DC424A")
    
public void unregisterForSubscriptionInfoReady(Handler h) {
        mSST.unregisterForSubscriptionInfoReady(h);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.414 -0500", hash_original_method = "9CC75D31629A3B23A63ED4AF8AC1CC3C", hash_generated_method = "B58336EB31033A3C650483BCF44A81E3")
    
public void setOnEcbModeExitResponse(Handler h, int what, Object obj) {
        mEcmExitRespRegistrant = new Registrant (h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.417 -0500", hash_original_method = "40447D9C1BA4AF14D98FB8C3ACDE2526", hash_generated_method = "39C1A351DA4CAE60C51D4452663408BF")
    
public void unsetOnEcbModeExitResponse(Handler h) {
        mEcmExitRespRegistrant.clear();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.419 -0500", hash_original_method = "0F8C6CFDB05E5D9DD9E146C1B344047B", hash_generated_method = "B0F146FA3E10AF8655F105DF208971D0")
    
public void registerForCallWaiting(Handler h, int what, Object obj) {
        mCT.registerForCallWaiting(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.421 -0500", hash_original_method = "0239428C6B544E5C48B7505010514559", hash_generated_method = "E8FDAF7BCF95A6C3D8B49D4871040667")
    
public void unregisterForCallWaiting(Handler h) {
        mCT.unregisterForCallWaiting(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.423 -0500", hash_original_method = "639F59C576968CC215A4C16BCF60725F", hash_generated_method = "8ECF6BD49DFF98471A188E007FFDAC1A")
    
public void
    getNeighboringCids(Message response) {
        /*
         * This is currently not implemented.  At least as of June
         * 2009, there is no neighbor cell information available for
         * CDMA because some party is resisting making this
         * information readily available.  Consequently, calling this
         * function can have no useful effect.  This situation may
         * (and hopefully will) change in the future.
         */
        if (response != null) {
            CommandException ce = new CommandException(
                    CommandException.Error.REQUEST_NOT_SUPPORTED);
            AsyncResult.forMessage(response).exception = ce;
            response.sendToTarget();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.426 -0500", hash_original_method = "872EFAB028EF9345A6D84A5CBF27D619", hash_generated_method = "3F192990C8073002EB1225F349D97DA8")
    
public DataState getDataConnectionState(String apnType) {
        DataState ret = DataState.DISCONNECTED;

        if (mSST == null) {
             // Radio Technology Change is ongoning, dispose() and removeReferences() have
             // already been called

             ret = DataState.DISCONNECTED;
        } else if (mSST.getCurrentDataConnectionState() != ServiceState.STATE_IN_SERVICE) {
            // If we're out of service, open TCP sockets may still work
            // but no data will flow
            ret = DataState.DISCONNECTED;
        } else if (mDataConnectionTracker.isApnTypeEnabled(apnType) == false ||
                mDataConnectionTracker.isApnTypeActive(apnType) == false) {
            ret = DataState.DISCONNECTED;
        } else {
            switch (mDataConnectionTracker.getState(apnType)) {
                case FAILED:
                case IDLE:
                    ret = DataState.DISCONNECTED;
                break;

                case CONNECTED:
                case DISCONNECTING:
                    if ( mCT.state != Phone.State.IDLE
                            && !mSST.isConcurrentVoiceAndDataAllowed()) {
                        ret = DataState.SUSPENDED;
                    } else {
                        ret = DataState.CONNECTED;
                    }
                break;

                case INITING:
                case CONNECTING:
                case SCANNING:
                    ret = DataState.CONNECTING;
                break;
            }
        }

        log("getDataConnectionState apnType=" + apnType + " ret=" + ret);
        return ret;
    }

    @DSSink({DSSinkKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.428 -0500", hash_original_method = "F7E968145C01057A311E794FEA9BAA95", hash_generated_method = "0496708406A10D9C0A87EFD82D6C5053")
    
public void sendUssdResponse(String ussdMessge) {
        Log.e(LOG_TAG, "sendUssdResponse: not possible in CDMA");
    }

    @DSSink({DSSinkKind.PHONE_CONNECTION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.431 -0500", hash_original_method = "98607162C44D8873925496654D522BF8", hash_generated_method = "A80C5B09DA17CC16D06DE98B01BF320A")
    
public void sendDtmf(char c) {
        if (!PhoneNumberUtils.is12Key(c)) {
            Log.e(LOG_TAG,
                    "sendDtmf called with invalid character '" + c + "'");
        } else {
            if (mCT.state ==  Phone.State.OFFHOOK) {
                mCM.sendDtmf(c, null);
            }
        }
    }

    @DSSink({DSSinkKind.PHONE_CONNECTION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.433 -0500", hash_original_method = "3FBA1333099AE68AF02019D712D23AB2", hash_generated_method = "D9801C8D2F605F56D81343C15291222C")
    
public void startDtmf(char c) {
        if (!PhoneNumberUtils.is12Key(c)) {
            Log.e(LOG_TAG,
                    "startDtmf called with invalid character '" + c + "'");
        } else {
            mCM.startDtmf(c, null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.436 -0500", hash_original_method = "3DAC039DE959EF34631E2B825CE1F213", hash_generated_method = "6AAF589BD7BAF018024B86F06E00F6CF")
    
public void stopDtmf() {
        mCM.stopDtmf(null);
    }

    @DSSink({DSSinkKind.PHONE_CONNECTION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.439 -0500", hash_original_method = "E3E7B97B548DE87ECFE3195659B23FF9", hash_generated_method = "53401FBA49ACD52054DF4F051D4AA9B3")
    
public void sendBurstDtmf(String dtmfString, int on, int off, Message onComplete) {
        boolean check = true;
        for (int itr = 0;itr < dtmfString.length(); itr++) {
            if (!PhoneNumberUtils.is12Key(dtmfString.charAt(itr))) {
                Log.e(LOG_TAG,
                        "sendDtmf called with invalid character '" + dtmfString.charAt(itr)+ "'");
                check = false;
                break;
            }
        }
        if ((mCT.state ==  Phone.State.OFFHOOK)&&(check)) {
            mCM.sendBurstDtmf(dtmfString, on, off, onComplete);
        }
     }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.441 -0500", hash_original_method = "FE0764939BCED80E9275F681708ABC99", hash_generated_method = "4E0E468AFBFD96239DA5F9318DC46D25")
    
public void getAvailableNetworks(Message response) {
        Log.e(LOG_TAG, "getAvailableNetworks: not possible in CDMA");
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.443 -0500", hash_original_method = "9C1B6A588127C991585EBB349A2379DB", hash_generated_method = "0B054564AF5D2E3BB4E0559DFBB599B9")
    
public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode, Message onComplete) {
        Log.e(LOG_TAG, "setOutgoingCallerIdDisplay: not possible in CDMA");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.445 -0500", hash_original_method = "85721F5820CF0128BD1EA66BA785E274", hash_generated_method = "E20D8DD4B2C4455D6BDD1A294D2C6018")
    
public void enableLocationUpdates() {
        mSST.enableLocationUpdates();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.448 -0500", hash_original_method = "E6FECC87DDBB4D4FE984E494757397E3", hash_generated_method = "B48F59D8CA25DC490DCA5F8946EC478C")
    
public void disableLocationUpdates() {
        mSST.disableLocationUpdates();
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.450 -0500", hash_original_method = "DAED77F9218E0449A772CA04214CC7F0", hash_generated_method = "DF9F743D65FEFF6BF334F9A94A48954F")
    
public void getDataCallList(Message response) {
        mCM.getDataCallList(response);
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.452 -0500", hash_original_method = "33CDF43696035DC3E16A234222A80D64", hash_generated_method = "0A4E3A1DD4AA9D90F0E17CE7435D79D6")
    
public boolean getDataRoamingEnabled() {
        return mDataConnectionTracker.getDataOnRoamingEnabled();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.454 -0500", hash_original_method = "63103D1CE9C7888BE66C8CE520564C7E", hash_generated_method = "3348F01B1BE6A390D1B7E60FC9671A08")
    
public void setVoiceMailNumber(String alphaTag,
                                   String voiceMailNumber,
                                   Message onComplete) {
        Message resp;
        mVmNumber = voiceMailNumber;
        resp = obtainMessage(EVENT_SET_VM_NUMBER_DONE, 0, 0, onComplete);
        mIccRecords.setVoiceMailNumber(alphaTag, mVmNumber, resp);
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.457 -0500", hash_original_method = "EC96491CC2681D27125B6B3540F74113", hash_generated_method = "66E2AC045A5CED920986497CC11EA312")
    
public String getVoiceMailNumber() {
        String number = null;
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        // TODO: The default value of voicemail number should be read from a system property

        // Read platform settings for dynamic voicemail number
        if (getContext().getResources().getBoolean(com.android.internal
                .R.bool.config_telephony_use_own_number_for_voicemail)) {
            number = sp.getString(VM_NUMBER_CDMA, getLine1Number());
        } else {
            number = sp.getString(VM_NUMBER_CDMA, "*86");
        }
        return number;
    }

    /* Returns Number of Voicemails
     * @hide
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.459 -0500", hash_original_method = "5D69EEC40343498AF4F71AD96BF8D875", hash_generated_method = "634BC73AAD052B6FFDE13C1144956E69")
    
public int getVoiceMessageCount() {
        int voicemailCount =  mIccRecords.getVoiceMessageCount();
        // If mRuimRecords.getVoiceMessageCount returns zero, then there is possibility
        // that phone was power cycled and would have lost the voicemail count.
        // So get the count from preferences.
        if (voicemailCount == 0) {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
            voicemailCount = sp.getInt(VM_COUNT_CDMA, 0);
        }
        return voicemailCount;
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.462 -0500", hash_original_method = "72DF9B0892372ADFAD7DE65056384F5E", hash_generated_method = "5ABBAA5204AA2515A230E6F79316A0CA")
    
public String getVoiceMailAlphaTag() {
        // TODO: Where can we get this value has to be clarified with QC.
        String ret = "";//TODO: Remove = "", if we know where to get this value.

        //ret = mSIMRecords.getVoiceMailAlphaTag();

        if (ret == null || ret.length() == 0) {
            return mContext.getText(
                com.android.internal.R.string.defaultVoiceMailAlphaTag).toString();
        }

        return ret;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.464 -0500", hash_original_method = "E23DBF1DA2409183D56D85932A9D038B", hash_generated_method = "47700AAF3EFC09BD827DF1B112E260CB")
    
public void getCallForwardingOption(int commandInterfaceCFReason, Message onComplete) {
        Log.e(LOG_TAG, "getCallForwardingOption: not possible in CDMA");
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.466 -0500", hash_original_method = "A636525DAEF6D9A554C143CAF44D5772", hash_generated_method = "D8B0FE2CAD8BE1BE781773E841633A21")
    
public void setCallForwardingOption(int commandInterfaceCFAction,
            int commandInterfaceCFReason,
            String dialingNumber,
            int timerSeconds,
            Message onComplete) {
        Log.e(LOG_TAG, "setCallForwardingOption: not possible in CDMA");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.468 -0500", hash_original_method = "C44463D6A0E6885F3CB7F2F8669CD319", hash_generated_method = "0F7F6BD0725DF7C66F28062C79CB28E8")
    
public void
    getOutgoingCallerIdDisplay(Message onComplete) {
        Log.e(LOG_TAG, "getOutgoingCallerIdDisplay: not possible in CDMA");
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.470 -0500", hash_original_method = "D57FAF7F6BF0B2A3D2D79072DE461E12", hash_generated_method = "3B7278EBA7881A3640C04377AFF63F5F")
    
public boolean
    getCallForwardingIndicator() {
        Log.e(LOG_TAG, "getCallForwardingIndicator: not possible in CDMA");
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.472 -0500", hash_original_method = "4D4FE78E3983A39BD949CCB232763B54", hash_generated_method = "D8CB41D17312C26E54C02A827E48C8FD")
    
public void explicitCallTransfer() {
        Log.e(LOG_TAG, "explicitCallTransfer: not possible in CDMA");
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.475 -0500", hash_original_method = "280CC3981F581DF1B137B098EEA6AAEB", hash_generated_method = "113378B77E6BCFA3915A61018A6D962F")
    
public String getLine1AlphaTag() {
        Log.e(LOG_TAG, "getLine1AlphaTag: not possible in CDMA");
        return null;
    }

    /**
     * Notify any interested party of a Phone state change  {@link Phone.State}
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.477 -0500", hash_original_method = "812A77A153EDB691C43A0B58CAFAA77A", hash_generated_method = "812A77A153EDB691C43A0B58CAFAA77A")
    
void notifyPhoneStateChanged() {
        mNotifier.notifyPhoneState(this);
    }

    /**
     * Notify registrants of a change in the call state. This notifies changes in {@link Call.State}
     * Use this when changes in the precise call state are needed, else use notifyPhoneStateChanged.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.479 -0500", hash_original_method = "3EB8461625C29B29FD6CB8E5D60B43F3", hash_generated_method = "12015DBC20468C486AF905F9802DB743")
    
void notifyPreciseCallStateChanged() {
        /* we'd love it if this was package-scoped*/
        super.notifyPreciseCallStateChangedP();
    }

     @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.481 -0500", hash_original_method = "73E7BFF04E4E9785E6146409272926BA", hash_generated_method = "73E7BFF04E4E9785E6146409272926BA")
    
void notifyServiceStateChanged(ServiceState ss) {
         super.notifyServiceStateChangedP(ss);
     }

     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.484 -0500", hash_original_method = "482FE18FBD1949DAF708F2E65940DE8F", hash_generated_method = "482FE18FBD1949DAF708F2E65940DE8F")
    
void notifyLocationChanged() {
         mNotifier.notifyCellLocation(this);
     }

    /*package*/ @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.486 -0500", hash_original_method = "292444BE96E352C8E8312B338E19EF02", hash_generated_method = "990C97FD08BF8064CCDF498BC93F23E9")
    
void notifyNewRingingConnection(Connection c) {
        /* we'd love it if this was package-scoped*/
        super.notifyNewRingingConnectionP(c);
    }

    /*package*/ @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.488 -0500", hash_original_method = "1858091673D3A4B62C058FCC91892C36", hash_generated_method = "1858091673D3A4B62C058FCC91892C36")
    
void notifyDisconnect(Connection cn) {
        mDisconnectRegistrants.notifyResult(cn);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.490 -0500", hash_original_method = "4DFA3B176AED92FABCFB596FBC88C127", hash_generated_method = "4DFA3B176AED92FABCFB596FBC88C127")
    
void notifyUnknownConnection() {
        mUnknownConnectionRegistrants.notifyResult(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.492 -0500", hash_original_method = "393DB826FD1453B6BE0DEA71B818C50D", hash_generated_method = "742040C6F7C571A789C7F99F9B5E48C4")
    
public boolean isInEmergencyCall() {
        return mCT.isInEmergencyCall();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.495 -0500", hash_original_method = "B4B2A6F2428B54DDD4A7791B2905A02A", hash_generated_method = "A17C94D74C67F7B0D379573EFC4ABE7E")
    
public boolean isInEcm() {
        return mIsPhoneInEcmState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.497 -0500", hash_original_method = "00543A79BC25C997F29F0DAD4E28E830", hash_generated_method = "097CC060FEE247ACDF2918B29A0467D4")
    
void sendEmergencyCallbackModeChange(){
        //Send an Intent
        Intent intent = new Intent(TelephonyIntents.ACTION_EMERGENCY_CALLBACK_MODE_CHANGED);
        intent.putExtra(PHONE_IN_ECM_STATE, mIsPhoneInEcmState);
        ActivityManagerNative.broadcastStickyIntent(intent,null);
        if (DBG) Log.d(LOG_TAG, "sendEmergencyCallbackModeChange");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.499 -0500", hash_original_method = "B67535D9EC35CAA35F8134AB61AC3782", hash_generated_method = "6016DC756D9B4E8ADFA03E610CD823E9")
    
@Override
    public void exitEmergencyCallbackMode() {
        if (mWakeLock.isHeld()) {
            mWakeLock.release();
        }
        // Send a message which will invoke handleExitEmergencyCallbackMode
        mCM.exitEmergencyCallbackMode(obtainMessage(EVENT_EXIT_EMERGENCY_CALLBACK_RESPONSE));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.502 -0500", hash_original_method = "379601A1C426F495327BF8B224FF5B5D", hash_generated_method = "67B035E276002C75108F1E21CDC37896")
    
private void handleEnterEmergencyCallbackMode(Message msg) {
        if (DBG) {
            Log.d(LOG_TAG, "handleEnterEmergencyCallbackMode,mIsPhoneInEcmState= "
                    + mIsPhoneInEcmState);
        }
        // if phone is not in Ecm mode, and it's changed to Ecm mode
        if (mIsPhoneInEcmState == false) {
            mIsPhoneInEcmState = true;
            // notify change
            sendEmergencyCallbackModeChange();
            setSystemProperty(TelephonyProperties.PROPERTY_INECM_MODE, "true");

            // Post this runnable so we will automatically exit
            // if no one invokes exitEmergencyCallbackMode() directly.
            long delayInMillis = SystemProperties.getLong(
                    TelephonyProperties.PROPERTY_ECM_EXIT_TIMER, DEFAULT_ECM_EXIT_TIMER_VALUE);
            postDelayed(mExitEcmRunnable, delayInMillis);
            // We don't want to go to sleep while in Ecm
            mWakeLock.acquire();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.505 -0500", hash_original_method = "DE92BF7F05810FB5E0BD1EEEAFEB4B90", hash_generated_method = "CCB2C780B4A3D904F371AAFD0241C191")
    
private void handleExitEmergencyCallbackMode(Message msg) {
        AsyncResult ar = (AsyncResult)msg.obj;
        if (DBG) {
            Log.d(LOG_TAG, "handleExitEmergencyCallbackMode,ar.exception , mIsPhoneInEcmState "
                    + ar.exception + mIsPhoneInEcmState);
        }
        // Remove pending exit Ecm runnable, if any
        removeCallbacks(mExitEcmRunnable);

        if (mEcmExitRespRegistrant != null) {
            mEcmExitRespRegistrant.notifyRegistrant(ar);
        }
        // if exiting ecm success
        if (ar.exception == null) {
            if (mIsPhoneInEcmState) {
                mIsPhoneInEcmState = false;
                setSystemProperty(TelephonyProperties.PROPERTY_INECM_MODE, "false");
            }
            // send an Intent
            sendEmergencyCallbackModeChange();
            // Re-initiate data connection
            mDataConnectionTracker.setInternalDataEnabled(true);
        }
    }

    /**
     * Handle to cancel or restart Ecm timer in emergency call back mode
     * if action is CANCEL_ECM_TIMER, cancel Ecm timer and notify apps the timer is canceled;
     * otherwise, restart Ecm timer and notify apps the timer is restarted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.507 -0500", hash_original_method = "C8EF6B60BE95B81385F7554432463CF1", hash_generated_method = "C8EF6B60BE95B81385F7554432463CF1")
    
void handleTimerInEmergencyCallbackMode(int action) {
        switch(action) {
        case CANCEL_ECM_TIMER:
            removeCallbacks(mExitEcmRunnable);
            mEcmTimerResetRegistrants.notifyResult(Boolean.TRUE);
            break;
        case RESTART_ECM_TIMER:
            long delayInMillis = SystemProperties.getLong(
                    TelephonyProperties.PROPERTY_ECM_EXIT_TIMER, DEFAULT_ECM_EXIT_TIMER_VALUE);
            postDelayed(mExitEcmRunnable, delayInMillis);
            mEcmTimerResetRegistrants.notifyResult(Boolean.FALSE);
            break;
        default:
            Log.e(LOG_TAG, "handleTimerInEmergencyCallbackMode, unsupported action " + action);
        }
    }

    /**
     * Registration point for Ecm timer reset
     * @param h handler to notify
     * @param what User-defined message code
     * @param obj placed in Message.obj
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.510 -0500", hash_original_method = "BEFF27391F370909F03A02FD6CE5C8E1", hash_generated_method = "EA0067382F4D2FDC5CE426FB5E7D1E58")
    
public void registerForEcmTimerReset(Handler h, int what, Object obj) {
        mEcmTimerResetRegistrants.addUnique(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.512 -0500", hash_original_method = "2652F35782787E1271AD631A33A0033B", hash_generated_method = "9D12A0FFB9E230DB7DBA276677DFC549")
    
public void unregisterForEcmTimerReset(Handler h) {
        mEcmTimerResetRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.517 -0500", hash_original_method = "69FA59CB460FF0A097B9F7F6B4D5A187", hash_generated_method = "F73F047102641555531D2226D09B55B1")
    
@Override
    public void handleMessage(Message msg) {
        AsyncResult ar;
        Message     onComplete;

        switch(msg.what) {
            case EVENT_RADIO_AVAILABLE: {
                mCM.getBasebandVersion(obtainMessage(EVENT_GET_BASEBAND_VERSION_DONE));

                mCM.getDeviceIdentity(obtainMessage(EVENT_GET_DEVICE_IDENTITY_DONE));
            }
            break;

            case EVENT_GET_BASEBAND_VERSION_DONE:{
                ar = (AsyncResult)msg.obj;

                if (ar.exception != null) {
                    break;
                }

                if (DBG) Log.d(LOG_TAG, "Baseband version: " + ar.result);
                setSystemProperty(TelephonyProperties.PROPERTY_BASEBAND_VERSION, (String)ar.result);
            }
            break;

            case EVENT_GET_DEVICE_IDENTITY_DONE:{
                ar = (AsyncResult)msg.obj;

                if (ar.exception != null) {
                    break;
                }
                String[] respId = (String[])ar.result;
                mImei = respId[0];
                mImeiSv = respId[1];
                mEsn  =  respId[2];
                mMeid =  respId[3];
            }
            break;

            case EVENT_EMERGENCY_CALLBACK_MODE_ENTER:{
                handleEnterEmergencyCallbackMode(msg);
            }
            break;

            case  EVENT_EXIT_EMERGENCY_CALLBACK_RESPONSE:{
                handleExitEmergencyCallbackMode(msg);
            }
            break;

            case EVENT_RUIM_RECORDS_LOADED:{
                Log.d(LOG_TAG, "Event EVENT_RUIM_RECORDS_LOADED Received");
                updateCurrentCarrierInProvider();
            }
            break;

            case EVENT_RADIO_OFF_OR_NOT_AVAILABLE:{
                Log.d(LOG_TAG, "Event EVENT_RADIO_OFF_OR_NOT_AVAILABLE Received");
            }
            break;

            case EVENT_RADIO_ON:{
                Log.d(LOG_TAG, "Event EVENT_RADIO_ON Received");
            }
            break;

            case EVENT_SSN:{
                Log.d(LOG_TAG, "Event EVENT_SSN Received");
            }
            break;

            case EVENT_REGISTERED_TO_NETWORK:{
                Log.d(LOG_TAG, "Event EVENT_REGISTERED_TO_NETWORK Received");
            }
            break;

            case EVENT_NV_READY:{
                Log.d(LOG_TAG, "Event EVENT_NV_READY Received");
                //Inform the Service State Tracker
                mNvLoadedRegistrants.notifyRegistrants();
                prepareEri();
            }
            break;

            case EVENT_SET_VM_NUMBER_DONE:{
                ar = (AsyncResult)msg.obj;
                if (IccException.class.isInstance(ar.exception)) {
                    storeVoiceMailNumber(mVmNumber);
                    ar.exception = null;
                }
                onComplete = (Message) ar.userObj;
                if (onComplete != null) {
                    AsyncResult.forMessage(onComplete, ar.result, ar.exception);
                    onComplete.sendToTarget();
                }
            }
            break;

            default:{
                super.handleMessage(msg);
            }
        }
    }

    /**
     * Retrieves the PhoneSubInfo of the CDMAPhone
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.519 -0500", hash_original_method = "4BF16EE42BDE3709043B0CD4BA1346D5", hash_generated_method = "2BAFF6EDDAB4B6CCB86F157BB9EE1177")
    
public PhoneSubInfo getPhoneSubInfo() {
        return mSubInfo;
    }

    /**
     * Retrieves the IccSmsInterfaceManager of the CDMAPhone
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.522 -0500", hash_original_method = "A5B3830D3022369CFD45112AC4A19D05", hash_generated_method = "0AD7628B9FEB9128AA01AE712631CDD6")
    
public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        return mRuimSmsInterfaceManager;
    }

    /**
     * Retrieves the IccPhoneBookInterfaceManager of the CDMAPhone
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.524 -0500", hash_original_method = "F4C16F1EDC7887AFA610A21C85E2FBBC", hash_generated_method = "255E4523524098FD6866F1C8FB9C86C1")
    
public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        return mRuimPhoneBookInterfaceManager;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.526 -0500", hash_original_method = "631C425442894A51F9E1215F7444839C", hash_generated_method = "AD5AC295A546F9CD98A224CE35493C45")
    
public void registerForNvLoaded(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mNvLoadedRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.528 -0500", hash_original_method = "FC47AF6104E2994A09ED5540AEE820A5", hash_generated_method = "6317D9B400D43A1D57C8BC69F5D1C1E2")
    
public void unregisterForNvLoaded(Handler h) {
        mNvLoadedRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.531 -0500", hash_original_method = "76D872D60E8DF5A817173A7970E48DAF", hash_generated_method = "ED4AEF4F5DE224F0DE5F10BCF4ED94A5")
    
public void registerForEriFileLoaded(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mEriFileLoadedRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.533 -0500", hash_original_method = "609ACFE0DF3AD88014ED023EE4CC2BBF", hash_generated_method = "30897C773D9591D7B96B53CCBED12785")
    
public void unregisterForEriFileLoaded(Handler h) {
        mEriFileLoadedRegistrants.remove(h);
    }

    // override for allowing access from other classes of this package
    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.535 -0500", hash_original_method = "C4157CB043EC8B3384F8270EB7DCD5BB", hash_generated_method = "A23F33679D922B6A305F95FDA36AFC9C")
    
public final void setSystemProperty(String property, String value) {
        super.setSystemProperty(property, value);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.537 -0500", hash_original_method = "515987807F65054AFA6AA9A268DDB599", hash_generated_method = "6444A67C7A7DD857ADA0E22CE9EE207B")
    
public IccFileHandler getIccFileHandler() {
        return this.mIccFileHandler;
    }

    /**
     * Activate or deactivate cell broadcast SMS.
     *
     * @param activate 0 = activate, 1 = deactivate
     * @param response Callback message is empty on completion
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.540 -0500", hash_original_method = "793C414C17B853DD540D3B3DFD8290DE", hash_generated_method = "EBC18B24C94B678AD7792C2FF9ED4B51")
    
public void activateCellBroadcastSms(int activate, Message response) {
        Log.e(LOG_TAG, "[CDMAPhone] activateCellBroadcastSms() is obsolete; use SmsManager");
        response.sendToTarget();
    }

    /**
     * Query the current configuration of cdma cell broadcast SMS.
     *
     * @param response Callback message is empty on completion
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.542 -0500", hash_original_method = "81E322CF525B990EC666DA306E1980A6", hash_generated_method = "CEEFE0E3442024686C2DA05EABDCB610")
    
public void getCellBroadcastSmsConfig(Message response) {
        Log.e(LOG_TAG, "[CDMAPhone] getCellBroadcastSmsConfig() is obsolete; use SmsManager");
        response.sendToTarget();
    }

    /**
     * Configure cdma cell broadcast SMS.
     *
     * @param response Callback message is empty on completion
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.544 -0500", hash_original_method = "718A796BA1FEFA7B8760E97D0CFF0F71", hash_generated_method = "287414991E365A4CF383918E8322DCED")
    
public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        Log.e(LOG_TAG, "[CDMAPhone] setCellBroadcastSmsConfig() is obsolete; use SmsManager");
        response.sendToTarget();
    }

    /**
     * Returns true if OTA Service Provisioning needs to be performed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.547 -0500", hash_original_method = "C10911F486938B4F93DC849B5E1085A3", hash_generated_method = "58FEB9B5BD3D673382BBA8109B73E7D7")
    
@Override
    public boolean needsOtaServiceProvisioning() {
        return mSST.getOtasp() != ServiceStateTracker.OTASP_NOT_NEEDED;
    }

    /**
     * The following function checks if a dial string is a carrier specified
     * OTASP number or not by checking against the OTASP number schema stored
     * in PROPERTY_OTASP_NUM_SCHEMA.
     *
     * Currently, there are 2 schemas for carriers to specify the OTASP number:
     * 1) Use system selection code:
     *    The schema is:
     *    SELC,the # of code pairs,min1,max1,min2,max2,...
     *    e.g "SELC,3,10,20,30,40,60,70" indicates that there are 3 pairs of
     *    selection codes, and they are {10,20}, {30,40} and {60,70} respectively.
     *
     * 2) Use feature code:
     *    The schema is:
     *    "FC,length of feature code,feature code".
     *     e.g "FC,2,*2" indicates that the length of the feature code is 2,
     *     and the code itself is "*2".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.594 -0500", hash_original_method = "2F4529BDEA4C79E5E2F449E50272F3AC", hash_generated_method = "9DF69ACE1D900389CAFBC50DAB16AEBE")
    
private boolean isCarrierOtaSpNum(String dialStr) {
        boolean isOtaSpNum = false;
        int sysSelCodeInt = extractSelCodeFromOtaSpNum(dialStr);
        if (sysSelCodeInt == INVALID_SYSTEM_SELECTION_CODE) {
            return isOtaSpNum;
        }
        // mCarrierOtaSpNumSchema is retrieved from PROPERTY_OTASP_NUM_SCHEMA:
        if (!TextUtils.isEmpty(mCarrierOtaSpNumSchema)) {
            Matcher m = pOtaSpNumSchema.matcher(mCarrierOtaSpNumSchema);
            if (DBG) {
                Log.d(LOG_TAG, "isCarrierOtaSpNum,schema" + mCarrierOtaSpNumSchema);
            }

            if (m.find()) {
                String sch[] = pOtaSpNumSchema.split(mCarrierOtaSpNumSchema);
                // If carrier uses system selection code mechanism
                if (!TextUtils.isEmpty(sch[0]) && sch[0].equals("SELC")) {
                    if (sysSelCodeInt!=INVALID_SYSTEM_SELECTION_CODE) {
                        isOtaSpNum=checkOtaSpNumBasedOnSysSelCode(sysSelCodeInt,sch);
                    } else {
                        if (DBG) {
                            Log.d(LOG_TAG, "isCarrierOtaSpNum,sysSelCodeInt is invalid");
                        }
                    }
                } else if (!TextUtils.isEmpty(sch[0]) && sch[0].equals("FC")) {
                    int fcLen =  Integer.parseInt((String)sch[1]);
                    String fc = (String)sch[2];
                    if (dialStr.regionMatches(0,fc,0,fcLen)) {
                        isOtaSpNum = true;
                    } else {
                        if (DBG) Log.d(LOG_TAG, "isCarrierOtaSpNum,not otasp number");
                    }
                } else {
                    if (DBG) {
                        Log.d(LOG_TAG, "isCarrierOtaSpNum,ota schema not supported" + sch[0]);
                    }
                }
            } else {
                if (DBG) {
                    Log.d(LOG_TAG, "isCarrierOtaSpNum,ota schema pattern not right" +
                          mCarrierOtaSpNumSchema);
                }
            }
        } else {
            if (DBG) Log.d(LOG_TAG, "isCarrierOtaSpNum,ota schema pattern empty");
        }
        return isOtaSpNum;
    }

    /**
     * isOTASPNumber: checks a given number against the IS-683A OTASP dial string and carrier
     * OTASP dial string.
     *
     * @param dialStr the number to look up.
     * @return true if the number is in IS-683A OTASP dial string or carrier OTASP dial string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.597 -0500", hash_original_method = "AE6C103DE6DE549189EC8F2DC89B4935", hash_generated_method = "A73E43305BABACE81C65AE941761E502")
    
@Override
    public  boolean isOtaSpNumber(String dialStr){
        boolean isOtaSpNum = false;
        String dialableStr = PhoneNumberUtils.extractNetworkPortionAlt(dialStr);
        if (dialableStr != null) {
            isOtaSpNum = isIs683OtaSpDialStr(dialableStr);
            if (isOtaSpNum == false) {
                isOtaSpNum = isCarrierOtaSpNum(dialableStr);
            }
        }
        if (DBG) Log.d(LOG_TAG, "isOtaSpNumber " + isOtaSpNum);
        return isOtaSpNum;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.599 -0500", hash_original_method = "CBAF5F4AF9A1C44FBA957D2F8ABDCEC2", hash_generated_method = "CF9B55FEA37590F0B1481A372CBA23C3")
    
@Override
    public int getCdmaEriIconIndex() {
        return getServiceState().getCdmaEriIconIndex();
    }

    /**
     * Returns the CDMA ERI icon mode,
     * 0 - ON
     * 1 - FLASHING
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.601 -0500", hash_original_method = "505B53637594CBFFA64F8CC821649187", hash_generated_method = "02C9763FBF6A555EAEE01406C54EB5BE")
    
@Override
    public int getCdmaEriIconMode() {
        return getServiceState().getCdmaEriIconMode();
    }

    /**
     * Returns the CDMA ERI text,
     */
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.603 -0500", hash_original_method = "FF25B4C2C2FD6DDBAFFF02AC278A249A", hash_generated_method = "D8D8ACA7316CBCE3E983DA2FC2D403D2")
    
@Override
    public String getCdmaEriText() {
        int roamInd = getServiceState().getCdmaRoamingIndicator();
        int defRoamInd = getServiceState().getCdmaDefaultRoamingIndicator();
        return mEriManager.getCdmaEriText(roamInd, defRoamInd);
    }

    /**
     * Store the voicemail number in preferences
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.605 -0500", hash_original_method = "1FA484546C7B73CA49B2C4AE64A8C83E", hash_generated_method = "6377B6D624485818A014047739069E85")
    
private void storeVoiceMailNumber(String number) {
        // Update the preference value of voicemail number
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(VM_NUMBER_CDMA, number);
        editor.apply();
    }

    /**
     * Sets PROPERTY_ICC_OPERATOR_ISO_COUNTRY property
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.608 -0500", hash_original_method = "04903824830A3F9FD2759E9C177CC0CB", hash_generated_method = "996E7D58CB5DD6EF618F015B0E8D0F8B")
    
private void setIsoCountryProperty(String operatorNumeric) {
        if (TextUtils.isEmpty(operatorNumeric)) {
            setSystemProperty(PROPERTY_ICC_OPERATOR_ISO_COUNTRY, "");
        } else {
            String iso = "";
            try {
                iso = MccTable.countryCodeForMcc(Integer.parseInt(
                        operatorNumeric.substring(0,3)));
            } catch (NumberFormatException ex) {
                Log.w(LOG_TAG, "countryCodeForMcc error" + ex);
            } catch (StringIndexOutOfBoundsException ex) {
                Log.w(LOG_TAG, "countryCodeForMcc error" + ex);
            }

            setSystemProperty(PROPERTY_ICC_OPERATOR_ISO_COUNTRY, iso);
        }
    }

    /**
     * Sets the "current" field in the telephony provider according to the
     * build-time operator numeric property
     *
     * @return true for success; false otherwise.
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.611 -0500", hash_original_method = "B076A318D7F3CB7E259ECDC99FDB3D0D", hash_generated_method = "0A44E08571681D07EC93C75BDC2D40E8")
    
boolean updateCurrentCarrierInProvider(String operatorNumeric) {
        if (!TextUtils.isEmpty(operatorNumeric)) {
            try {
                Uri uri = Uri.withAppendedPath(Telephony.Carriers.CONTENT_URI, "current");
                ContentValues map = new ContentValues();
                map.put(Telephony.Carriers.NUMERIC, operatorNumeric);
                log("updateCurrentCarrierInProvider from system: numeric=" + operatorNumeric);
                getContext().getContentResolver().insert(uri, map);

                // Updates MCC MNC device configuration information
                MccTable.updateMccMncConfiguration(this, operatorNumeric);

                return true;
            } catch (SQLException e) {
                Log.e(LOG_TAG, "Can't store current operator", e);
            }
        }
        return false;
    }

    /**
     * Sets the "current" field in the telephony provider according to the SIM's operator.
     * Implemented in {@link CDMALTEPhone} for CDMA/LTE devices.
     *
     * @return true for success; false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.613 -0500", hash_original_method = "A95BEE5F1920F9C579D7A59FC4DBB414", hash_generated_method = "A95BEE5F1920F9C579D7A59FC4DBB414")
    
boolean updateCurrentCarrierInProvider() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.616 -0500", hash_original_method = "5CB32743CEBF9A8556BB2E144A975CB3", hash_generated_method = "FA413FD5D3C204421DABD77D15181F36")
    
public void prepareEri() {
        mEriManager.loadEriFile();
        if(mEriManager.isEriFileLoaded()) {
            // when the ERI file is loaded
            log("ERI read, notify registrants");
            mEriFileLoadedRegistrants.notifyRegistrants();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.618 -0500", hash_original_method = "71144CF5C8B23350BF31931D81A1C3AC", hash_generated_method = "C838A64CC1C165468FDF6B51D48007A8")
    
public boolean isEriFileLoaded() {
        return mEriManager.isEriFileLoaded();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:01.620 -0500", hash_original_method = "CBB2DC533610D724567F0136955B7014", hash_generated_method = "7EC866153506768D1C17D5C471A273C5")
    
protected void log(String s) {
        if (DBG)
            Log.d(LOG_TAG, "[CDMAPhone] " + s);
    }
}

