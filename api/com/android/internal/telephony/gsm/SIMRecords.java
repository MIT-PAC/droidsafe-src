package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC;

import java.util.ArrayList;

import android.os.AsyncResult;
import android.os.Message;
import android.util.Log;

import com.android.internal.telephony.AdnRecord;
import com.android.internal.telephony.AdnRecordCache;
import com.android.internal.telephony.AdnRecordLoader;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.IccRecords;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.IccVmFixedException;
import com.android.internal.telephony.IccVmNotSupportedException;
import com.android.internal.telephony.MccTable;
import com.android.internal.telephony.PhoneBase;
import com.android.internal.telephony.SmsMessageBase;

public class SIMRecords extends IccRecords {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.231 -0500", hash_original_field = "28DECCA9F494133CD6F61BCA99A50ECA", hash_generated_field = "BD940BC52C3AB14198F71CB81F0E8FEB")

    protected static final String LOG_TAG = "GSM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.233 -0500", hash_original_field = "F003A67298FEA5C7DE4698E0CE8A0AED", hash_generated_field = "B1BDA8481E03A540852BC755DA2091B9")

    private static final boolean CRASH_RIL = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.237 -0500", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "5F5E7D64B04175B8FA820B2440F700FC")

    protected static final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.271 -0500", hash_original_field = "FF9D2AABA00294FFD3F1031D7F44FFEF", hash_generated_field = "4BC8C664721513107BEE5A19549F8DCC")

    // Bitmasks for SPN display rules.
    static final int SPN_RULE_SHOW_SPN  = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.273 -0500", hash_original_field = "7560ACBAECDE29EC5F4840E2A25ABFB5", hash_generated_field = "9615ED2E5048F60365ECFB661BB5CFF2")

    static final int SPN_RULE_SHOW_PLMN = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.276 -0500", hash_original_field = "1778206DB5AEFBC5312737901B0CA66F", hash_generated_field = "A4822F16D7D0722C09B349753F0A1C53")

    static final int TAG_SPDI = 0xA3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.279 -0500", hash_original_field = "B73E033A7782514A14C74B39FF22CC2C", hash_generated_field = "C2D6252AE5B1E2BC23E6E6BEB3130A64")

    static final int TAG_SPDI_PLMN_LIST = 0x80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.281 -0500", hash_original_field = "15E3AC4E522BBD29EF21E910E9211153", hash_generated_field = "743085D93FE3601EDCC832FB91368066")

    static final int TAG_FULL_NETWORK_NAME = 0x43;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.283 -0500", hash_original_field = "F81170B402133C19EF2F480F955C5792", hash_generated_field = "F9C22C8E909AE3B47754DE26713168A6")

    static final int TAG_SHORT_NETWORK_NAME = 0x45;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.286 -0500", hash_original_field = "AF7D820C9882CA4161F2E63BFA39C7D6", hash_generated_field = "F76787922EB6AA2178B7A042FE279FE9")

    static final int CFF_UNCONDITIONAL_ACTIVE = 0x0a;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.288 -0500", hash_original_field = "D4B60654B366A98D11BC3DDE21FB0558", hash_generated_field = "E898789BE36EE5CC895C4580678DC3EE")

    static final int CFF_UNCONDITIONAL_DEACTIVE = 0x05;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.290 -0500", hash_original_field = "C94255CF7F1D393937B730C57AC009F9", hash_generated_field = "6D646CF1330D172C697FBE463F3E20DD")

    static final int CFF_LINE1_MASK = 0x0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.293 -0500", hash_original_field = "2A13E2B2E73861D8B30974A128D0835E", hash_generated_field = "21B7855A8A75A6C0FBA7800A32927557")

    static final int CFF_LINE1_RESET = 0xf0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.296 -0500", hash_original_field = "37E3F0B2B093F56A6628CC1DB70939D8", hash_generated_field = "DED73EE7FF558B0A8BCE28EA6F50AA32")

    private static final int CPHS_SST_MBN_MASK = 0x30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.299 -0500", hash_original_field = "FF32931B37D590CD051CC8C554DF3C79", hash_generated_field = "90E2112308FC996159B6715487610C17")

    private static final int CPHS_SST_MBN_ENABLED = 0x30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.301 -0500", hash_original_field = "A681E352E0DA24A188F01FFE9600E712", hash_generated_field = "CA9D8FD5F6DA4FDAFDD2818A884111C6")

    private static final int EVENT_SIM_READY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.304 -0500", hash_original_field = "10087FBC454048F6857D29E457AA7109", hash_generated_field = "C65DF4AD1462685EBC499AE583280BAA")

    private static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.306 -0500", hash_original_field = "A3787692598C90EEB9BB8751A6BB6448", hash_generated_field = "C1B81CA82D779018C72F133549599B37")

    protected static final int EVENT_GET_IMSI_DONE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.309 -0500", hash_original_field = "05AF41A22306EAC31176CEF154970A56", hash_generated_field = "FA13D8118051BEADD1DF91D4EC1C2052")

    protected static final int EVENT_GET_ICCID_DONE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.311 -0500", hash_original_field = "FCC521E30904BA22DBBC34ADD08E9F59", hash_generated_field = "AC488F40D96E33B7A9106EEA894C7BD2")

    private static final int EVENT_GET_MBI_DONE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.313 -0500", hash_original_field = "F51D2E86AF26199181D41D7C51B65A47", hash_generated_field = "EDE69B90FE5CC250E0B91ECDBE9DE9D1")

    private static final int EVENT_GET_MBDN_DONE = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.316 -0500", hash_original_field = "29A9A313E56905AC30F99E837AEFF58A", hash_generated_field = "1ABA989B0F3362D2C70EEB5A70C87F0D")

    private static final int EVENT_GET_MWIS_DONE = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.318 -0500", hash_original_field = "73E337CD4EAF293666258F3494A6CA28", hash_generated_field = "5165FAAB5F7CD18E9D5F96D2818657FA")

    private static final int EVENT_GET_VOICE_MAIL_INDICATOR_CPHS_DONE = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.321 -0500", hash_original_field = "1C1A5EC0B947289196D54FFDE08AFE85", hash_generated_field = "AF8D9BB0B036F882F1D0C816581372A7")

    protected static final int EVENT_GET_AD_DONE = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.324 -0500", hash_original_field = "5DB9E9F96903E12B59F316757B50C47F", hash_generated_field = "7E6BDAACDB02FB8DBDE5B121D1D96B80")

    protected static final int EVENT_GET_MSISDN_DONE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.327 -0500", hash_original_field = "5DFE5E848686F582944CF58BAD524057", hash_generated_field = "16316F56D2B66BC0712FA6DCCB623FD8")

    private static final int EVENT_GET_CPHS_MAILBOX_DONE = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.329 -0500", hash_original_field = "38A4A1A335CFE5AD4331279BD371B61B", hash_generated_field = "A9380C4C24D6B84D11AA10394A8A4655")

    private static final int EVENT_GET_SPN_DONE = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.332 -0500", hash_original_field = "4E56DC5D4426CE9A363A3862FEC40999", hash_generated_field = "23B20EDB29F4E6ACE5BC6B6E3131138F")

    private static final int EVENT_GET_SPDI_DONE = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.334 -0500", hash_original_field = "15AA3092CA793CDB56928C20738F9662", hash_generated_field = "7C08F6997CDB1F95B53292AC6E4DA474")

    private static final int EVENT_UPDATE_DONE = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.336 -0500", hash_original_field = "FA01AF460CE1B51F4FF6FB82F392F220", hash_generated_field = "A297125EDFFC4F42969DFEF4BE44F8AC")

    private static final int EVENT_GET_PNN_DONE = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.339 -0500", hash_original_field = "B743885265DAB5D09BDC2BEFB25E3659", hash_generated_field = "9BD29131ACB6B8193EA3976774320615")

    protected static final int EVENT_GET_SST_DONE = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.342 -0500", hash_original_field = "AD72AFE5B9E35372F16AAC21BF8094B0", hash_generated_field = "9F464D691ED618E65FF918987EFF9274")

    private static final int EVENT_GET_ALL_SMS_DONE = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.344 -0500", hash_original_field = "0057316DE67FB54EBC04012E8D29CE0E", hash_generated_field = "961A7A4D60E11CE78834F70BC49A219A")

    private static final int EVENT_MARK_SMS_READ_DONE = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.347 -0500", hash_original_field = "45C395D16B3B0E5B4FA3772E0E695472", hash_generated_field = "F05CD6C947B2B1AA00E5D1063F179FDF")

    private static final int EVENT_SET_MBDN_DONE = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.350 -0500", hash_original_field = "7851073062ED5718CD8F507155EA6BE7", hash_generated_field = "32F13C0B04E96171B7B8D712BBC53B0A")

    private static final int EVENT_SMS_ON_SIM = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.353 -0500", hash_original_field = "7516B891086644A58E10A683B9447161", hash_generated_field = "18FB3B701347968BBB3DB68B7D9FA9E0")

    private static final int EVENT_GET_SMS_DONE = 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.356 -0500", hash_original_field = "334F51570C8AB5EB3A5C1F6B83DE692B", hash_generated_field = "778675A2DDF2BB258371DC2061683859")

    private static final int EVENT_GET_CFF_DONE = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.358 -0500", hash_original_field = "28E20ABDF1F2418B9A5C67BC29287BE5", hash_generated_field = "5818D0009EC83D0304F736A07B44ED18")

    private static final int EVENT_SET_CPHS_MAILBOX_DONE = 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.361 -0500", hash_original_field = "7648D8868618EE38D6BE9F5890316656", hash_generated_field = "8D3AD55D8107BA8230AA0810AF1F7304")

    private static final int EVENT_GET_INFO_CPHS_DONE = 26;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.363 -0500", hash_original_field = "E2368DE3EB59B8A65CA3D274EDE6D991", hash_generated_field = "BE715D1FD0CE243424B798654ACC75BA")

    private static final int EVENT_SET_MSISDN_DONE = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.366 -0500", hash_original_field = "6FBA9AD27CF1ACADB0659849FC486567", hash_generated_field = "0FDD8C86CA2531BA62F4A95521E434F5")

    private static final int EVENT_SIM_REFRESH = 31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.369 -0500", hash_original_field = "5B81C2F6074098DCB804164ED810C2C2", hash_generated_field = "F29A42DEBAB245F7C058BE162E7F91ED")

    private static final int EVENT_GET_CFIS_DONE = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.371 -0500", hash_original_field = "6A71C9F166908901C32E5C975CACD84B", hash_generated_field = "3DCE777E62AE6095ECB53822D16E8FE9")

    private static final int EVENT_GET_CSP_CPHS_DONE = 33;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.375 -0500", hash_original_field = "B9ECAB4950A7427602CA16ED0EC47A6E", hash_generated_field = "7E3BF9E363667067579B2DD88404B9BE")

    private static final String[] MCCMNC_CODES_HAVING_3DIGITS_MNC = {
        "405025", "405026", "405027", "405028", "405029", "405030", "405031", "405032",
        "405033", "405034", "405035", "405036", "405037", "405038", "405039", "405040",
        "405041", "405042", "405043", "405044", "405045", "405046", "405047", "405750",
        "405751", "405752", "405753", "405754", "405755", "405756", "405799", "405800",
        "405801", "405802", "405803", "405804", "405805", "405806", "405807", "405808",
        "405809", "405810", "405811", "405812", "405813", "405814", "405815", "405816",
        "405817", "405818", "405819", "405820", "405821", "405822", "405823", "405824",
        "405825", "405826", "405827", "405828", "405829", "405830", "405831", "405832",
        "405833", "405834", "405835", "405836", "405837", "405838", "405839", "405840",
        "405841", "405842", "405843", "405844", "405845", "405846", "405847", "405848",
        "405849", "405850", "405851", "405852", "405853", "405875", "405876", "405877",
        "405878", "405879", "405880", "405881", "405882", "405883", "405884", "405885",
        "405886", "405908", "405909", "405910", "405911", "405925", "405926", "405927",
        "405928", "405929", "405932"
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.239 -0500", hash_original_field = "3D45F4DC7928ADFBE49F3906732C5FDD", hash_generated_field = "3D45F4DC7928ADFBE49F3906732C5FDD")

    VoiceMailConstants mVmConfig;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.241 -0500", hash_original_field = "1D5FAB34B5B1DFA2FF0C72EB8EB1417D", hash_generated_field = "1D5FAB34B5B1DFA2FF0C72EB8EB1417D")

    SpnOverride mSpnOverride;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.243 -0500", hash_original_field = "1B2A50BA8BC9B280A0E4FF57E262E0FD", hash_generated_field = "C8FB6D75F33BBB165F89E1184AF1DAB5")

    private String imsi;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.245 -0500", hash_original_field = "942C9EFD2090625730E786516C1A092C", hash_generated_field = "F3670A331578D3C800D2A8879CDAE6A2")

    private boolean callForwardingEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.247 -0500", hash_original_field = "C5EEDCB51D765166F34F8B9F080236F0", hash_generated_field = "71EE1DCA9A91F37B8070C2DE70EBC3CC")

    private Get_Spn_Fsm_State spnState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.250 -0500", hash_original_field = "9A76D09F568A9E20D6E4DCD265ECDA77", hash_generated_field = "B94C656CABFD2A097CE8CA776F9B3D25")

    private byte[] mCphsInfo = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.252 -0500", hash_original_field = "3B0DBAF5E1453033DE8A23FEF66CB6CF", hash_generated_field = "3B0DBAF5E1453033DE8A23FEF66CB6CF")

    boolean mCspPlmnEnabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.254 -0500", hash_original_field = "531BEBDA8DE453FA3ED736DAC070C337", hash_generated_field = "531BEBDA8DE453FA3ED736DAC070C337")

    byte[] efMWIS = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.256 -0500", hash_original_field = "F7BA255CC3AE0058E8CFC095600F245B", hash_generated_field = "F7BA255CC3AE0058E8CFC095600F245B")

    byte[] efCPHS_MWI =null;
    
    private enum Get_Spn_Fsm_State {
        IDLE,               
        INIT,               
        READ_SPN_3GPP,      
        READ_SPN_CPHS,      
        READ_SPN_SHORT_CPHS 
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.258 -0500", hash_original_field = "27C9B421032889367442E38FD625EA3E", hash_generated_field = "27C9B421032889367442E38FD625EA3E")

    byte[] mEfCff = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.261 -0500", hash_original_field = "4CFC3799ACD516937F814E469F055B3D", hash_generated_field = "4CFC3799ACD516937F814E469F055B3D")

    byte[] mEfCfis = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.263 -0500", hash_original_field = "677DC81727BE9252421E71F32EAE57E6", hash_generated_field = "677DC81727BE9252421E71F32EAE57E6")

    int spnDisplayCondition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.265 -0500", hash_original_field = "9CBD8D86B3B910D521D7CFC4F4B05AE6", hash_generated_field = "9CBD8D86B3B910D521D7CFC4F4B05AE6")

    ArrayList<String> spdiNetworks = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.266 -0500", hash_original_field = "FC170B0C5C20481C238409EFCB48A036", hash_generated_field = "FC170B0C5C20481C238409EFCB48A036")

    String pnnHomeName = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.268 -0500", hash_original_field = "433C8C040DD36FD17B8409B23AF92316", hash_generated_field = "433C8C040DD36FD17B8409B23AF92316")

    UsimServiceTable mUsimServiceTable;

    // ***** Constructor

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.378 -0500", hash_original_method = "AA8710B4BBDFAECA42DF87898B5E71E9", hash_generated_method = "EE8003AA09C21029482A87185502A28F")
    
public SIMRecords(PhoneBase p) {
        super(p);

        adnCache = new AdnRecordCache(phone);

        mVmConfig = new VoiceMailConstants();
        mSpnOverride = new SpnOverride();

        recordsRequested = false;  // No load request is made till SIM ready

        // recordsToLoad is set to 0 because no requests are made yet
        recordsToLoad = 0;

        p.mCM.registerForSIMReady(this, EVENT_SIM_READY, null);
        p.mCM.registerForOffOrNotAvailable(
                        this, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        p.mCM.setOnSmsOnSim(this, EVENT_SMS_ON_SIM, null);
        p.mCM.registerForIccRefresh(this, EVENT_SIM_REFRESH, null);

        // Start off by setting empty state
        onRadioOffOrNotAvailable();

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.380 -0500", hash_original_method = "60B34C0CDC881E5C8D40C8AAD990557F", hash_generated_method = "9FCFC84168E4EB6F4374CD0CB638A8C2")
    
@Override
    public void dispose() {
        //Unregister for all events
        phone.mCM.unregisterForSIMReady(this);
        phone.mCM.unregisterForOffOrNotAvailable( this);
        phone.mCM.unregisterForIccRefresh(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.383 -0500", hash_original_method = "D676C6F3D2367DC0A4942786FE826692", hash_generated_method = "8FC9E83F78C99852762B9D254E29E4B6")
    
protected void finalize() {
        if(DBG) Log.d(LOG_TAG, "SIMRecords finalized");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.385 -0500", hash_original_method = "1C495E4F05849546A87C14B5D6E64BED", hash_generated_method = "59E2C64E87789C34D75CE236A3CC909D")
    
protected void onRadioOffOrNotAvailable() {
        imsi = null;
        msisdn = null;
        voiceMailNum = null;
        countVoiceMessages = 0;
        mncLength = UNINITIALIZED;
        iccid = null;
        // -1 means no EF_SPN found; treat accordingly.
        spnDisplayCondition = -1;
        efMWIS = null;
        efCPHS_MWI = null;
        spdiNetworks = null;
        pnnHomeName = null;

        adnCache.reset();

        phone.setSystemProperty(PROPERTY_ICC_OPERATOR_NUMERIC, null);
        phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ALPHA, null);
        phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ISO_COUNTRY, null);

        // recordsRequested is set to false indicating that the SIM
        // read requests made so far are not valid. This is set to
        // true only when fresh set of read requests are made.
        recordsRequested = false;
    }

    //***** Public Methods

    /**
     * {@inheritDoc}
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.387 -0500", hash_original_method = "3D26DD60574339032566256F631F5DB8", hash_generated_method = "30902BBBDE8901613FD04AFCBCDF5D8D")
    
@Override
    public String getIMSI() {
        return imsi;
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.390 -0500", hash_original_method = "9D42E73ED1AA846035EF94EBFAAEA8F6", hash_generated_method = "F1138A33B43D1F97901AB603D4F79F76")
    
public String getMsisdnNumber() {
        return msisdn;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.393 -0500", hash_original_method = "F96F62208A76C85F8691E193053EFC74", hash_generated_method = "92490C5A0963DA62E05967DBBA236143")
    
@Override
    public UsimServiceTable getUsimServiceTable() {
        return mUsimServiceTable;
    }

    /**
     * Set subscriber number to SIM record
     *
     * The subscriber number is stored in EF_MSISDN (TS 51.011)
     *
     * When the operation is complete, onComplete will be sent to its handler
     *
     * @param alphaTag alpha-tagging of the dailing nubmer (up to 10 characters)
     * @param number dailing nubmer (up to 20 digits)
     *        if the number starts with '+', then set to international TOA
     * @param onComplete
     *        onComplete.obj will be an AsyncResult
     *        ((AsyncResult)onComplete.obj).exception == null on success
     *        ((AsyncResult)onComplete.obj).exception != null on fail
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.395 -0500", hash_original_method = "7B16D051528D70BC1665C409BE0B92A5", hash_generated_method = "4AEE8957B7B7125B152DF3AEAF514BAE")
    
public void setMsisdnNumber(String alphaTag, String number,
            Message onComplete) {

        msisdn = number;
        msisdnTag = alphaTag;

        if(DBG) log("Set MSISDN: " + msisdnTag + " " + /*msisdn*/ "xxxxxxx");

        AdnRecord adn = new AdnRecord(msisdnTag, msisdn);

        new AdnRecordLoader(phone).updateEF(adn, EF_MSISDN, EF_EXT1, 1, null,
                obtainMessage(EVENT_SET_MSISDN_DONE, onComplete));
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.398 -0500", hash_original_method = "E32EFED28CC433860D178485CFB4EEE4", hash_generated_method = "1B4AFE5064CD03ADA2B3761686668224")
    
public String getMsisdnAlphaTag() {
        return msisdnTag;
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.400 -0500", hash_original_method = "77FFC0D98CD3CB2629C7F6A7D27E6FFF", hash_generated_method = "CFF64DE092E5BFF9A940C028E585122B")
    
public String getVoiceMailNumber() {
        return voiceMailNum;
    }

    /**
     * Set voice mail number to SIM record
     *
     * The voice mail number can be stored either in EF_MBDN (TS 51.011) or
     * EF_MAILBOX_CPHS (CPHS 4.2)
     *
     * If EF_MBDN is available, store the voice mail number to EF_MBDN
     *
     * If EF_MAILBOX_CPHS is enabled, store the voice mail number to EF_CHPS
     *
     * So the voice mail number will be stored in both EFs if both are available
     *
     * Return error only if both EF_MBDN and EF_MAILBOX_CPHS fail.
     *
     * When the operation is complete, onComplete will be sent to its handler
     *
     * @param alphaTag alpha-tagging of the dailing nubmer (upto 10 characters)
     * @param voiceNumber dailing nubmer (upto 20 digits)
     *        if the number is start with '+', then set to international TOA
     * @param onComplete
     *        onComplete.obj will be an AsyncResult
     *        ((AsyncResult)onComplete.obj).exception == null on success
     *        ((AsyncResult)onComplete.obj).exception != null on fail
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.402 -0500", hash_original_method = "BBA59ED68AB83B35B5A29C09BCF3BE4C", hash_generated_method = "C25DDBEECFAA986E4C59B6841BBBEF19")
    
public void setVoiceMailNumber(String alphaTag, String voiceNumber,
            Message onComplete) {
        if (isVoiceMailFixed) {
            AsyncResult.forMessage((onComplete)).exception =
                    new IccVmFixedException("Voicemail number is fixed by operator");
            onComplete.sendToTarget();
            return;
        }

        newVoiceMailNum = voiceNumber;
        newVoiceMailTag = alphaTag;

        AdnRecord adn = new AdnRecord(newVoiceMailTag, newVoiceMailNum);

        if (mailboxIndex != 0 && mailboxIndex != 0xff) {

            new AdnRecordLoader(phone).updateEF(adn, EF_MBDN, EF_EXT6,
                    mailboxIndex, null,
                    obtainMessage(EVENT_SET_MBDN_DONE, onComplete));

        } else if (isCphsMailboxEnabled()) {

            new AdnRecordLoader(phone).updateEF(adn, EF_MAILBOX_CPHS,
                    EF_EXT1, 1, null,
                    obtainMessage(EVENT_SET_CPHS_MAILBOX_DONE, onComplete));

        } else {
            AsyncResult.forMessage((onComplete)).exception =
                    new IccVmNotSupportedException("Update SIM voice mailbox error");
            onComplete.sendToTarget();
        }
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.405 -0500", hash_original_method = "5A91F4662DCD8CEE6B5E6A046B7A4ABC", hash_generated_method = "6D7368A0D77DC432B7AD7E84B26C6DBA")
    
public String getVoiceMailAlphaTag()
    {
        return voiceMailTag;
    }

    /**
     * Sets the SIM voice message waiting indicator records
     * @param line GSM Subscriber Profile Number, one-based. Only '1' is supported
     * @param countWaiting The number of messages waiting, if known. Use
     *                     -1 to indicate that an unknown number of
     *                      messages are waiting
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.408 -0500", hash_original_method = "75BFE4AFE8A3A09F4E38976A214FAF70", hash_generated_method = "E591197387BD229505C3BC1B3FF420C5")
    
public void
    setVoiceMessageWaiting(int line, int countWaiting) {
        if (line != 1) {
            // only profile 1 is supported
            return;
        }

        // range check
        if (countWaiting < 0) {
            countWaiting = -1;
        } else if (countWaiting > 0xff) {
            // TS 23.040 9.2.3.24.2
            // "The value 255 shall be taken to mean 255 or greater"
            countWaiting = 0xff;
        }

        countVoiceMessages = countWaiting;

        phone.notifyMessageWaitingIndicator();

        try {
            if (efMWIS != null) {
                // TS 51.011 10.3.45

                // lsb of byte 0 is 'voicemail' status
                efMWIS[0] = (byte)((efMWIS[0] & 0xfe)
                                    | (countVoiceMessages == 0 ? 0 : 1));

                // byte 1 is the number of voice messages waiting
                if (countWaiting < 0) {
                    // The spec does not define what this should be
                    // if we don't know the count
                    efMWIS[1] = 0;
                } else {
                    efMWIS[1] = (byte) countWaiting;
                }

                phone.getIccFileHandler().updateEFLinearFixed(
                    EF_MWIS, 1, efMWIS, null,
                    obtainMessage (EVENT_UPDATE_DONE, EF_MWIS));
            }

            if (efCPHS_MWI != null) {
                    // Refer CPHS4_2.WW6 B4.2.3
                efCPHS_MWI[0] = (byte)((efCPHS_MWI[0] & 0xf0)
                            | (countVoiceMessages == 0 ? 0x5 : 0xa));

                phone.getIccFileHandler().updateEFTransparent(
                    EF_VOICE_MAIL_INDICATOR_CPHS, efCPHS_MWI,
                    obtainMessage (EVENT_UPDATE_DONE, EF_VOICE_MAIL_INDICATOR_CPHS));
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            Log.w(LOG_TAG,
                "Error saving voice mail state to SIM. Probably malformed SIM record", ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.410 -0500", hash_original_method = "2A8D94361FF074096EDCA291A7FA986D", hash_generated_method = "11A08D604E28D1B060A36949FF3CD94A")
    
@Override
    public boolean getVoiceCallForwardingFlag() {
        return callForwardingEnabled;
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.413 -0500", hash_original_method = "141082A6B47AB008F9D1AEFE7E7266B0", hash_generated_method = "B1A8F8FF2E8606037EE573FE9A83727A")
    
@Override
    public void setVoiceCallForwardingFlag(int line, boolean enable) {

        if (line != 1) return; // only line 1 is supported

        callForwardingEnabled = enable;

        phone.notifyCallForwardingIndicator();

        try {
            if (mEfCfis != null) {
                // lsb is of byte 1 is voice status
                if (enable) {
                    mEfCfis[1] |= 1;
                } else {
                    mEfCfis[1] &= 0xfe;
                }

                // TODO: Should really update other fields in EF_CFIS, eg,
                // dialing number.  We don't read or use it right now.

                phone.getIccFileHandler().updateEFLinearFixed(
                        EF_CFIS, 1, mEfCfis, null,
                        obtainMessage (EVENT_UPDATE_DONE, EF_CFIS));
            }

            if (mEfCff != null) {
                if (enable) {
                    mEfCff[0] = (byte) ((mEfCff[0] & CFF_LINE1_RESET)
                            | CFF_UNCONDITIONAL_ACTIVE);
                } else {
                    mEfCff[0] = (byte) ((mEfCff[0] & CFF_LINE1_RESET)
                            | CFF_UNCONDITIONAL_DEACTIVE);
                }

                phone.getIccFileHandler().updateEFTransparent(
                        EF_CFF_CPHS, mEfCff,
                        obtainMessage (EVENT_UPDATE_DONE, EF_CFF_CPHS));
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            Log.w(LOG_TAG,
                    "Error saving call fowarding flag to SIM. "
                            + "Probably malformed SIM record", ex);

        }
    }

    /**
     * Called by STK Service when REFRESH is received.
     * @param fileChanged indicates whether any files changed
     * @param fileList if non-null, a list of EF files that changed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.416 -0500", hash_original_method = "3729AD4A21CE0EDB3800382FBE3F87EC", hash_generated_method = "D5A422FE651FB498A1CB1A101ADA4D7D")
    
public void onRefresh(boolean fileChanged, int[] fileList) {
        if (fileChanged) {
            // A future optimization would be to inspect fileList and
            // only reload those files that we care about.  For now,
            // just re-fetch all SIM records that we cache.
            fetchSimRecords();
        }
    }

    /**
     * {@inheritDoc}
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.418 -0500", hash_original_method = "7E03E5ED77A0C757F38448793B936037", hash_generated_method = "AAE9B0A11E77036A447B96185EFC9D28")
    
@Override
    public String getOperatorNumeric() {
        if (imsi == null) {
            Log.d(LOG_TAG, "getOperatorNumeric: IMSI == null");
            return null;
        }
        if (mncLength == UNINITIALIZED || mncLength == UNKNOWN) {
            Log.d(LOG_TAG, "getSIMOperatorNumeric: bad mncLength");
            return null;
        }

        // Length = length of MCC + length of MNC
        // length of mcc = 3 (TS 23.003 Section 2.2)
        return imsi.substring(0, 3 + mncLength);
    }

    // ***** Overridden from Handler
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.430 -0500", hash_original_method = "5FA65278BC21B747191DBEA87B814DA9", hash_generated_method = "B529690C6062B0B4AFDF86419451D74A")
    
public void handleMessage(Message msg) {
        AsyncResult ar;
        AdnRecord adn;

        byte data[];

        boolean isRecordLoadResponse = false;

        try { switch (msg.what) {
            case EVENT_SIM_READY:
                onSimReady();
            break;

            case EVENT_RADIO_OFF_OR_NOT_AVAILABLE:
                onRadioOffOrNotAvailable();
            break;

            /* IO events */
            case EVENT_GET_IMSI_DONE:
                isRecordLoadResponse = true;

                ar = (AsyncResult)msg.obj;

                if (ar.exception != null) {
                    Log.e(LOG_TAG, "Exception querying IMSI, Exception:" + ar.exception);
                    break;
                }

                imsi = (String) ar.result;

                // IMSI (MCC+MNC+MSIN) is at least 6 digits, but not more
                // than 15 (and usually 15).
                if (imsi != null && (imsi.length() < 6 || imsi.length() > 15)) {
                    Log.e(LOG_TAG, "invalid IMSI " + imsi);
                    imsi = null;
                }

                Log.d(LOG_TAG, "IMSI: " + /* imsi.substring(0, 6) +*/ "xxxxxxx");

                if (((mncLength == UNKNOWN) || (mncLength == 2)) &&
                        ((imsi != null) && (imsi.length() >= 6))) {
                    String mccmncCode = imsi.substring(0, 6);
                    for (String mccmnc : MCCMNC_CODES_HAVING_3DIGITS_MNC) {
                        if (mccmnc.equals(mccmncCode)) {
                            mncLength = 3;
                            break;
                        }
                    }
                }

                if (mncLength == UNKNOWN) {
                    // the SIM has told us all it knows, but it didn't know the mnc length.
                    // guess using the mcc
                    try {
                        int mcc = Integer.parseInt(imsi.substring(0,3));
                        mncLength = MccTable.smallestDigitsMccForMnc(mcc);
                    } catch (NumberFormatException e) {
                        mncLength = UNKNOWN;
                        Log.e(LOG_TAG, "SIMRecords: Corrupt IMSI!");
                    }
                }

                if (mncLength != UNKNOWN && mncLength != UNINITIALIZED) {
                    // finally have both the imsi and the mncLength and can parse the imsi properly
                    MccTable.updateMccMncConfiguration(phone, imsi.substring(0, 3 + mncLength));
                }
                phone.mIccCard.broadcastIccStateChangedIntent(
                        SimCard.INTENT_VALUE_ICC_IMSI, null);
            break;

            case EVENT_GET_MBI_DONE:
                boolean isValidMbdn;
                isRecordLoadResponse = true;

                ar = (AsyncResult)msg.obj;
                data = (byte[]) ar.result;

                isValidMbdn = false;
                if (ar.exception == null) {
                    // Refer TS 51.011 Section 10.3.44 for content details
                    Log.d(LOG_TAG, "EF_MBI: " +
                            IccUtils.bytesToHexString(data));

                    // Voice mail record number stored first
                    mailboxIndex = (int)data[0] & 0xff;

                    // check if dailing numbe id valid
                    if (mailboxIndex != 0 && mailboxIndex != 0xff) {
                        Log.d(LOG_TAG, "Got valid mailbox number for MBDN");
                        isValidMbdn = true;
                    }
                }

                // one more record to load
                recordsToLoad += 1;

                if (isValidMbdn) {
                    // Note: MBDN was not included in NUM_OF_SIM_RECORDS_LOADED
                    new AdnRecordLoader(phone).loadFromEF(EF_MBDN, EF_EXT6,
                            mailboxIndex, obtainMessage(EVENT_GET_MBDN_DONE));
                } else {
                    // If this EF not present, try mailbox as in CPHS standard
                    // CPHS (CPHS4_2.WW6) is a european standard.
                    new AdnRecordLoader(phone).loadFromEF(EF_MAILBOX_CPHS,
                            EF_EXT1, 1,
                            obtainMessage(EVENT_GET_CPHS_MAILBOX_DONE));
                }

                break;
            case EVENT_GET_CPHS_MAILBOX_DONE:
            case EVENT_GET_MBDN_DONE:
                //Resetting the voice mail number and voice mail tag to null
                //as these should be updated from the data read from EF_MBDN.
                //If they are not reset, incase of invalid data/exception these
                //variables are retaining their previous values and are
                //causing invalid voice mailbox info display to user.
                voiceMailNum = null;
                voiceMailTag = null;
                isRecordLoadResponse = true;

                ar = (AsyncResult)msg.obj;

                if (ar.exception != null) {

                    Log.d(LOG_TAG, "Invalid or missing EF"
                        + ((msg.what == EVENT_GET_CPHS_MAILBOX_DONE) ? "[MAILBOX]" : "[MBDN]"));

                    // Bug #645770 fall back to CPHS
                    // FIXME should use SST to decide

                    if (msg.what == EVENT_GET_MBDN_DONE) {
                        //load CPHS on fail...
                        // FIXME right now, only load line1's CPHS voice mail entry

                        recordsToLoad += 1;
                        new AdnRecordLoader(phone).loadFromEF(
                                EF_MAILBOX_CPHS, EF_EXT1, 1,
                                obtainMessage(EVENT_GET_CPHS_MAILBOX_DONE));
                    }
                    break;
                }

                adn = (AdnRecord)ar.result;

                Log.d(LOG_TAG, "VM: " + adn +
                        ((msg.what == EVENT_GET_CPHS_MAILBOX_DONE) ? " EF[MAILBOX]" : " EF[MBDN]"));

                if (adn.isEmpty() && msg.what == EVENT_GET_MBDN_DONE) {
                    // Bug #645770 fall back to CPHS
                    // FIXME should use SST to decide
                    // FIXME right now, only load line1's CPHS voice mail entry
                    recordsToLoad += 1;
                    new AdnRecordLoader(phone).loadFromEF(
                            EF_MAILBOX_CPHS, EF_EXT1, 1,
                            obtainMessage(EVENT_GET_CPHS_MAILBOX_DONE));

                    break;
                }

                voiceMailNum = adn.getNumber();
                voiceMailTag = adn.getAlphaTag();
            break;

            case EVENT_GET_MSISDN_DONE:
                isRecordLoadResponse = true;

                ar = (AsyncResult)msg.obj;

                if (ar.exception != null) {
                    Log.d(LOG_TAG, "Invalid or missing EF[MSISDN]");
                    break;
                }

                adn = (AdnRecord)ar.result;

                msisdn = adn.getNumber();
                msisdnTag = adn.getAlphaTag();

                Log.d(LOG_TAG, "MSISDN: " + /*msisdn*/ "xxxxxxx");
            break;

            case EVENT_SET_MSISDN_DONE:
                isRecordLoadResponse = false;
                ar = (AsyncResult)msg.obj;

                if (ar.userObj != null) {
                    AsyncResult.forMessage(((Message) ar.userObj)).exception
                            = ar.exception;
                    ((Message) ar.userObj).sendToTarget();
                }
                break;

            case EVENT_GET_MWIS_DONE:
                isRecordLoadResponse = true;

                ar = (AsyncResult)msg.obj;
                data = (byte[])ar.result;

                if (ar.exception != null) {
                    break;
                }

                Log.d(LOG_TAG, "EF_MWIS: " +
                   IccUtils.bytesToHexString(data));

                efMWIS = data;

                if ((data[0] & 0xff) == 0xff) {
                    Log.d(LOG_TAG, "SIMRecords: Uninitialized record MWIS");
                    break;
                }

                // Refer TS 51.011 Section 10.3.45 for the content description
                boolean voiceMailWaiting = ((data[0] & 0x01) != 0);
                countVoiceMessages = data[1] & 0xff;

                if (voiceMailWaiting && countVoiceMessages == 0) {
                    // Unknown count = -1
                    countVoiceMessages = -1;
                }

                phone.notifyMessageWaitingIndicator();
            break;

            case EVENT_GET_VOICE_MAIL_INDICATOR_CPHS_DONE:
                isRecordLoadResponse = true;

                ar = (AsyncResult)msg.obj;
                data = (byte[])ar.result;

                if (ar.exception != null) {
                    break;
                }

                efCPHS_MWI = data;

                // Use this data if the EF[MWIS] exists and
                // has been loaded

                if (efMWIS == null) {
                    int indicator = (int)(data[0] & 0xf);

                    // Refer CPHS4_2.WW6 B4.2.3
                    if (indicator == 0xA) {
                        // Unknown count = -1
                        countVoiceMessages = -1;
                    } else if (indicator == 0x5) {
                        countVoiceMessages = 0;
                    }

                    phone.notifyMessageWaitingIndicator();
                }
            break;

            case EVENT_GET_ICCID_DONE:
                isRecordLoadResponse = true;

                ar = (AsyncResult)msg.obj;
                data = (byte[])ar.result;

                if (ar.exception != null) {
                    break;
                }

                iccid = IccUtils.bcdToString(data, 0, data.length);

                Log.d(LOG_TAG, "iccid: " + iccid);

            break;

            case EVENT_GET_AD_DONE:
                try {
                    isRecordLoadResponse = true;

                    ar = (AsyncResult)msg.obj;
                    data = (byte[])ar.result;

                    if (ar.exception != null) {
                        break;
                    }

                    Log.d(LOG_TAG, "EF_AD: " +
                            IccUtils.bytesToHexString(data));

                    if (data.length < 3) {
                        Log.d(LOG_TAG, "SIMRecords: Corrupt AD data on SIM");
                        break;
                    }

                    if (data.length == 3) {
                        Log.d(LOG_TAG, "SIMRecords: MNC length not present in EF_AD");
                        break;
                    }

                    mncLength = (int)data[3] & 0xf;

                    if (mncLength == 0xf) {
                        mncLength = UNKNOWN;
                    }
                } finally {
                    if (((mncLength == UNINITIALIZED) || (mncLength == UNKNOWN) ||
                            (mncLength == 2)) && ((imsi != null) && (imsi.length() >= 6))) {
                        String mccmncCode = imsi.substring(0, 6);
                        for (String mccmnc : MCCMNC_CODES_HAVING_3DIGITS_MNC) {
                            if (mccmnc.equals(mccmncCode)) {
                                mncLength = 3;
                                break;
                            }
                        }
                    }

                    if (mncLength == UNKNOWN || mncLength == UNINITIALIZED) {
                        if (imsi != null) {
                            try {
                                int mcc = Integer.parseInt(imsi.substring(0,3));

                                mncLength = MccTable.smallestDigitsMccForMnc(mcc);
                            } catch (NumberFormatException e) {
                                mncLength = UNKNOWN;
                                Log.e(LOG_TAG, "SIMRecords: Corrupt IMSI!");
                            }
                        } else {
                            // Indicate we got this info, but it didn't contain the length.
                            mncLength = UNKNOWN;

                            Log.d(LOG_TAG, "SIMRecords: MNC length not present in EF_AD");
                        }
                    }
                    if (imsi != null && mncLength != UNKNOWN) {
                        // finally have both imsi and the length of the mnc and can parse
                        // the imsi properly
                        MccTable.updateMccMncConfiguration(phone, imsi.substring(0, 3 + mncLength));
                    }
                }
            break;

            case EVENT_GET_SPN_DONE:
                isRecordLoadResponse = true;
                ar = (AsyncResult) msg.obj;
                getSpnFsm(false, ar);
            break;

            case EVENT_GET_CFF_DONE:
                isRecordLoadResponse = true;

                ar = (AsyncResult) msg.obj;
                data = (byte[]) ar.result;

                if (ar.exception != null) {
                    break;
                }

                Log.d(LOG_TAG, "EF_CFF_CPHS: " +
                        IccUtils.bytesToHexString(data));
                mEfCff = data;

                if (mEfCfis == null) {
                    callForwardingEnabled =
                        ((data[0] & CFF_LINE1_MASK) == CFF_UNCONDITIONAL_ACTIVE);

                    phone.notifyCallForwardingIndicator();
                }
                break;

            case EVENT_GET_SPDI_DONE:
                isRecordLoadResponse = true;

                ar = (AsyncResult)msg.obj;
                data = (byte[])ar.result;

                if (ar.exception != null) {
                    break;
                }

                parseEfSpdi(data);
            break;

            case EVENT_UPDATE_DONE:
                ar = (AsyncResult)msg.obj;
                if (ar.exception != null) {
                    Log.i(LOG_TAG, "SIMRecords update failed", ar.exception);
                }
            break;

            case EVENT_GET_PNN_DONE:
                isRecordLoadResponse = true;

                ar = (AsyncResult)msg.obj;
                data = (byte[])ar.result;

                if (ar.exception != null) {
                    break;
                }

                SimTlv tlv = new SimTlv(data, 0, data.length);

                for ( ; tlv.isValidObject() ; tlv.nextObject()) {
                    if (tlv.getTag() == TAG_FULL_NETWORK_NAME) {
                        pnnHomeName
                            = IccUtils.networkNameToString(
                                tlv.getData(), 0, tlv.getData().length);
                        break;
                    }
                }
            break;

            case EVENT_GET_ALL_SMS_DONE:
                isRecordLoadResponse = true;

                ar = (AsyncResult)msg.obj;
                if (ar.exception != null)
                    break;

                handleSmses((ArrayList) ar.result);
                break;

            case EVENT_MARK_SMS_READ_DONE:
                Log.i("ENF", "marked read: sms " + msg.arg1);
                break;

            case EVENT_SMS_ON_SIM:
                isRecordLoadResponse = false;

                ar = (AsyncResult)msg.obj;

                int[] index = (int[])ar.result;

                if (ar.exception != null || index.length != 1) {
                    Log.e(LOG_TAG, "[SIMRecords] Error on SMS_ON_SIM with exp "
                            + ar.exception + " length " + index.length);
                } else {
                    Log.d(LOG_TAG, "READ EF_SMS RECORD index=" + index[0]);
                    phone.getIccFileHandler().loadEFLinearFixed(EF_SMS,index[0],
                            obtainMessage(EVENT_GET_SMS_DONE));
                }
                break;

            case EVENT_GET_SMS_DONE:
                isRecordLoadResponse = false;
                ar = (AsyncResult)msg.obj;
                if (ar.exception == null) {
                    handleSms((byte[])ar.result);
                } else {
                    Log.e(LOG_TAG, "[SIMRecords] Error on GET_SMS with exp "
                            + ar.exception);
                }
                break;
            case EVENT_GET_SST_DONE:
                isRecordLoadResponse = true;

                ar = (AsyncResult)msg.obj;
                data = (byte[])ar.result;

                if (ar.exception != null) {
                    break;
                }

                mUsimServiceTable = new UsimServiceTable(data);
                if (DBG) log("SST: " + mUsimServiceTable);
                break;

            case EVENT_GET_INFO_CPHS_DONE:
                isRecordLoadResponse = true;

                ar = (AsyncResult)msg.obj;

                if (ar.exception != null) {
                    break;
                }

                mCphsInfo = (byte[])ar.result;

                if (DBG) log("iCPHS: " + IccUtils.bytesToHexString(mCphsInfo));
            break;

            case EVENT_SET_MBDN_DONE:
                isRecordLoadResponse = false;
                ar = (AsyncResult)msg.obj;

                if (ar.exception == null) {
                    voiceMailNum = newVoiceMailNum;
                    voiceMailTag = newVoiceMailTag;
                }

                if (isCphsMailboxEnabled()) {
                    adn = new AdnRecord(voiceMailTag, voiceMailNum);
                    Message onCphsCompleted = (Message) ar.userObj;

                    /* write to cphs mailbox whenever it is available but
                    * we only need notify caller once if both updating are
                    * successful.
                    *
                    * so if set_mbdn successful, notify caller here and set
                    * onCphsCompleted to null
                    */
                    if (ar.exception == null && ar.userObj != null) {
                        AsyncResult.forMessage(((Message) ar.userObj)).exception
                                = null;
                        ((Message) ar.userObj).sendToTarget();

                        if (DBG) log("Callback with MBDN successful.");

                        onCphsCompleted = null;
                    }

                    new AdnRecordLoader(phone).
                            updateEF(adn, EF_MAILBOX_CPHS, EF_EXT1, 1, null,
                            obtainMessage(EVENT_SET_CPHS_MAILBOX_DONE,
                                    onCphsCompleted));
                } else {
                    if (ar.userObj != null) {
                        AsyncResult.forMessage(((Message) ar.userObj)).exception
                                = ar.exception;
                        ((Message) ar.userObj).sendToTarget();
                    }
                }
                break;
            case EVENT_SET_CPHS_MAILBOX_DONE:
                isRecordLoadResponse = false;
                ar = (AsyncResult)msg.obj;
                if(ar.exception == null) {
                    voiceMailNum = newVoiceMailNum;
                    voiceMailTag = newVoiceMailTag;
                } else {
                    if (DBG) log("Set CPHS MailBox with exception: "
                            + ar.exception);
                }
                if (ar.userObj != null) {
                    if (DBG) log("Callback with CPHS MB successful.");
                    AsyncResult.forMessage(((Message) ar.userObj)).exception
                            = ar.exception;
                    ((Message) ar.userObj).sendToTarget();
                }
                break;
            case EVENT_SIM_REFRESH:
                isRecordLoadResponse = false;
                ar = (AsyncResult)msg.obj;
		if (DBG) log("Sim REFRESH with exception: " + ar.exception);
                if (ar.exception == null) {
                    handleSimRefresh((int[])(ar.result));
                }
                break;
            case EVENT_GET_CFIS_DONE:
                isRecordLoadResponse = true;

                ar = (AsyncResult)msg.obj;
                data = (byte[])ar.result;

                if (ar.exception != null) {
                    break;
                }

                Log.d(LOG_TAG, "EF_CFIS: " +
                   IccUtils.bytesToHexString(data));

                mEfCfis = data;

                // Refer TS 51.011 Section 10.3.46 for the content description
                callForwardingEnabled = ((data[1] & 0x01) != 0);

                phone.notifyCallForwardingIndicator();
                break;

            case EVENT_GET_CSP_CPHS_DONE:
                isRecordLoadResponse = true;

                ar = (AsyncResult)msg.obj;

                if (ar.exception != null) {
                    Log.e(LOG_TAG,"Exception in fetching EF_CSP data " + ar.exception);
                    break;
                }

                data = (byte[])ar.result;

                Log.i(LOG_TAG,"EF_CSP: " + IccUtils.bytesToHexString(data));
                handleEfCspData(data);
                break;

            default:
                super.handleMessage(msg);   // IccRecords handles generic record load responses

        }}catch (RuntimeException exc) {
            // I don't want these exceptions to be fatal
            Log.w(LOG_TAG, "Exception parsing SIM record", exc);
        } finally {
            // Count up record load responses even if they are fails
            if (isRecordLoadResponse) {
                onRecordLoaded();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.433 -0500", hash_original_method = "E530DF481CB4FAA0037A4FE4ABD87373", hash_generated_method = "4D94A14859D0BFF89C8EDCF35A923FF8")
    
private void handleFileUpdate(int efid) {
        switch(efid) {
            case EF_MBDN:
                recordsToLoad++;
                new AdnRecordLoader(phone).loadFromEF(EF_MBDN, EF_EXT6,
                        mailboxIndex, obtainMessage(EVENT_GET_MBDN_DONE));
                break;
            case EF_MAILBOX_CPHS:
                recordsToLoad++;
                new AdnRecordLoader(phone).loadFromEF(EF_MAILBOX_CPHS, EF_EXT1,
                        1, obtainMessage(EVENT_GET_CPHS_MAILBOX_DONE));
                break;
            case EF_CSP_CPHS:
                recordsToLoad++;
                Log.i(LOG_TAG, "[CSP] SIM Refresh for EF_CSP_CPHS");
                phone.getIccFileHandler().loadEFTransparent(EF_CSP_CPHS,
                        obtainMessage(EVENT_GET_CSP_CPHS_DONE));
                break;
            default:
                // For now, fetch all records if this is not a
                // voicemail number.
                // TODO: Handle other cases, instead of fetching all.
                adnCache.reset();
                fetchSimRecords();
                break;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.436 -0500", hash_original_method = "CBD0F454D52453FACC84E0D26FD9E162", hash_generated_method = "EC796316EA205550D38813FE2E0DD1B3")
    
private void handleSimRefresh(int[] result) {
        if (result == null || result.length == 0) {
	    if (DBG) log("handleSimRefresh without input");
            return;
        }

        switch ((result[0])) {
            case CommandsInterface.SIM_REFRESH_FILE_UPDATED:
 		if (DBG) log("handleSimRefresh with SIM_REFRESH_FILE_UPDATED");
                // result[1] contains the EFID of the updated file.
                int efid = result[1];
                handleFileUpdate(efid);
                break;
            case CommandsInterface.SIM_REFRESH_INIT:
		if (DBG) log("handleSimRefresh with SIM_REFRESH_INIT");
                // need to reload all files (that we care about)
                adnCache.reset();
                fetchSimRecords();
                break;
            case CommandsInterface.SIM_REFRESH_RESET:
		if (DBG) log("handleSimRefresh with SIM_REFRESH_RESET");
                phone.mCM.setRadioPower(false, null);
                /* Note: no need to call setRadioPower(true).  Assuming the desired
                * radio power state is still ON (as tracked by ServiceStateTracker),
                * ServiceStateTracker will call setRadioPower when it receives the
                * RADIO_STATE_CHANGED notification for the power off.  And if the
                * desired power state has changed in the interim, we don't want to
                * override it with an unconditional power on.
                */
                break;
            default:
                // unknown refresh operation
		if (DBG) log("handleSimRefresh with unknown operation");
                break;
        }
    }

    /**
     * Dispatch 3GPP format message. Overridden for CDMA/LTE phones by
     * {@link com.android.internal.telephony.cdma.CdmaLteUiccRecords}
     * to send messages to the secondary 3GPP format SMS dispatcher.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.439 -0500", hash_original_method = "0F425E7BAA03121C5111F3872E01B168", hash_generated_method = "E7C8DC00233FA93D4E0D108F61BEA24F")
    
protected int dispatchGsmMessage(SmsMessageBase message) {
        return phone.mSMS.dispatchMessage(message);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.441 -0500", hash_original_method = "3974DFF11A620863F24401AEED15BD51", hash_generated_method = "F856310924EA4D479EF65BE2B179A60C")
    
private void handleSms(byte[] ba) {
        if (ba[0] != 0)
            Log.d("ENF", "status : " + ba[0]);

        // 3GPP TS 51.011 v5.0.0 (20011-12)  10.5.3
        // 3 == "received by MS from network; message to be read"
        if (ba[0] == 3) {
            int n = ba.length;

            // Note: Data may include trailing FF's.  That's OK; message
            // should still parse correctly.
            byte[] pdu = new byte[n - 1];
            System.arraycopy(ba, 1, pdu, 0, n - 1);
            SmsMessage message = SmsMessage.createFromPdu(pdu);

            dispatchGsmMessage(message);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.444 -0500", hash_original_method = "AAB2EB039B628CD9C66D57B4359C7EA6", hash_generated_method = "6DB8CC3865EAE6752FC24EB5A8D7D9B8")
    
private void handleSmses(ArrayList messages) {
        int count = messages.size();

        for (int i = 0; i < count; i++) {
            byte[] ba = (byte[]) messages.get(i);

            if (ba[0] != 0)
                Log.i("ENF", "status " + i + ": " + ba[0]);

            // 3GPP TS 51.011 v5.0.0 (20011-12)  10.5.3
            // 3 == "received by MS from network; message to be read"

            if (ba[0] == 3) {
                int n = ba.length;

                // Note: Data may include trailing FF's.  That's OK; message
                // should still parse correctly.
                byte[] pdu = new byte[n - 1];
                System.arraycopy(ba, 1, pdu, 0, n - 1);
                SmsMessage message = SmsMessage.createFromPdu(pdu);

                dispatchGsmMessage(message);

                // 3GPP TS 51.011 v5.0.0 (20011-12)  10.5.3
                // 1 == "received by MS from network; message read"

                ba[0] = 1;

                if (false) { // XXX writing seems to crash RdoServD
                    phone.getIccFileHandler().updateEFLinearFixed(EF_SMS,
                            i, ba, null, obtainMessage(EVENT_MARK_SMS_READ_DONE, i));
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.447 -0500", hash_original_method = "2DE8400081AD5D0DFDE4A5A335B40E41", hash_generated_method = "D8E946DB0A645DD4D333D59ECF7B2054")
    
protected void onRecordLoaded() {
        // One record loaded successfully or failed, In either case
        // we need to update the recordsToLoad count
        recordsToLoad -= 1;

        if (recordsToLoad == 0 && recordsRequested == true) {
            onAllRecordsLoaded();
        } else if (recordsToLoad < 0) {
            Log.e(LOG_TAG, "SIMRecords: recordsToLoad <0, programmer error suspected");
            recordsToLoad = 0;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.449 -0500", hash_original_method = "66CB4A941BE4FC702CDC8E50BFF0F26C", hash_generated_method = "0D40C6D195D713F756C87CD9B49606A7")
    
protected void onAllRecordsLoaded() {
        Log.d(LOG_TAG, "SIMRecords: record load complete");

        String operator = getOperatorNumeric();

        // Some fields require more than one SIM record to set

        phone.setSystemProperty(PROPERTY_ICC_OPERATOR_NUMERIC, operator);

        if (imsi != null) {
            phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ISO_COUNTRY,
                    MccTable.countryCodeForMcc(Integer.parseInt(imsi.substring(0,3))));
        }
        else {
            Log.e("SIM", "[SIMRecords] onAllRecordsLoaded: imsi is NULL!");
        }

        setVoiceMailByCountry(operator);
        setSpnFromConfig(operator);

        recordsLoadedRegistrants.notifyRegistrants(
            new AsyncResult(null, null, null));
        phone.mIccCard.broadcastIccStateChangedIntent(
                SimCard.INTENT_VALUE_ICC_LOADED, null);
    }

    //***** Private methods

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.451 -0500", hash_original_method = "F5FC22B4152F67EB826E6610A6C9072B", hash_generated_method = "A7EFF23B87E7835FF9D502719AEAA0F1")
    
private void setSpnFromConfig(String carrier) {
        if (mSpnOverride.containsCarrier(carrier)) {
            spn = mSpnOverride.getSpn(carrier);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.453 -0500", hash_original_method = "0A1C3646AC6E538340751C4EFB011D4A", hash_generated_method = "64200EBB6E30D739BD0576D48D1DFDB7")
    
private void setVoiceMailByCountry (String spn) {
        if (mVmConfig.containsCarrier(spn)) {
            isVoiceMailFixed = true;
            voiceMailNum = mVmConfig.getVoiceMailNumber(spn);
            voiceMailTag = mVmConfig.getVoiceMailTag(spn);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.456 -0500", hash_original_method = "9A96815ED791357C0C0DD55806DDDE67", hash_generated_method = "32E7D415627D42C07B5E630FEB6A16FF")
    
public void onSimReady() {
        /* broadcast intent SIM_READY here so that we can make sure
          READY is sent before IMSI ready
        */
        phone.mIccCard.broadcastIccStateChangedIntent(
                SimCard.INTENT_VALUE_ICC_READY, null);

        fetchSimRecords();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.460 -0500", hash_original_method = "267620266787F01EC9F0E5E0AE15B613", hash_generated_method = "307F2B177BAC716DA00D6466BC08BED6")
    
protected void fetchSimRecords() {
        recordsRequested = true;
        IccFileHandler iccFh = phone.getIccFileHandler();

        Log.v(LOG_TAG, "SIMRecords:fetchSimRecords " + recordsToLoad);

        phone.mCM.getIMSI(obtainMessage(EVENT_GET_IMSI_DONE));
        recordsToLoad++;

        iccFh.loadEFTransparent(EF_ICCID, obtainMessage(EVENT_GET_ICCID_DONE));
        recordsToLoad++;

        // FIXME should examine EF[MSISDN]'s capability configuration
        // to determine which is the voice/data/fax line
        new AdnRecordLoader(phone).loadFromEF(EF_MSISDN, EF_EXT1, 1,
                    obtainMessage(EVENT_GET_MSISDN_DONE));
        recordsToLoad++;

        // Record number is subscriber profile
        iccFh.loadEFLinearFixed(EF_MBI, 1, obtainMessage(EVENT_GET_MBI_DONE));
        recordsToLoad++;

        iccFh.loadEFTransparent(EF_AD, obtainMessage(EVENT_GET_AD_DONE));
        recordsToLoad++;

        // Record number is subscriber profile
        iccFh.loadEFLinearFixed(EF_MWIS, 1, obtainMessage(EVENT_GET_MWIS_DONE));
        recordsToLoad++;

        // Also load CPHS-style voice mail indicator, which stores
        // the same info as EF[MWIS]. If both exist, both are updated
        // but the EF[MWIS] data is preferred
        // Please note this must be loaded after EF[MWIS]
        iccFh.loadEFTransparent(
                EF_VOICE_MAIL_INDICATOR_CPHS,
                obtainMessage(EVENT_GET_VOICE_MAIL_INDICATOR_CPHS_DONE));
        recordsToLoad++;

        // Same goes for Call Forward Status indicator: fetch both
        // EF[CFIS] and CPHS-EF, with EF[CFIS] preferred.
        iccFh.loadEFLinearFixed(EF_CFIS, 1, obtainMessage(EVENT_GET_CFIS_DONE));
        recordsToLoad++;
        iccFh.loadEFTransparent(EF_CFF_CPHS, obtainMessage(EVENT_GET_CFF_DONE));
        recordsToLoad++;

        getSpnFsm(true, null);

        iccFh.loadEFTransparent(EF_SPDI, obtainMessage(EVENT_GET_SPDI_DONE));
        recordsToLoad++;

        iccFh.loadEFLinearFixed(EF_PNN, 1, obtainMessage(EVENT_GET_PNN_DONE));
        recordsToLoad++;

        iccFh.loadEFTransparent(EF_SST, obtainMessage(EVENT_GET_SST_DONE));
        recordsToLoad++;

        iccFh.loadEFTransparent(EF_INFO_CPHS, obtainMessage(EVENT_GET_INFO_CPHS_DONE));
        recordsToLoad++;

        iccFh.loadEFTransparent(EF_CSP_CPHS,obtainMessage(EVENT_GET_CSP_CPHS_DONE));
        recordsToLoad++;

        // XXX should seek instead of examining them all
        if (false) { // XXX
            iccFh.loadEFLinearFixedAll(EF_SMS, obtainMessage(EVENT_GET_ALL_SMS_DONE));
            recordsToLoad++;
        }

        if (CRASH_RIL) {
            String sms = "0107912160130310f20404d0110041007030208054832b0120"
                         + "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
                         + "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
                         + "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
                         + "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
                         + "ffffffffffffffffffffffffffffff";
            byte[] ba = IccUtils.hexStringToBytes(sms);

            iccFh.updateEFLinearFixed(EF_SMS, 1, ba, null,
                            obtainMessage(EVENT_MARK_SMS_READ_DONE, 1));
        }
    }

    /**
     * Returns the SpnDisplayRule based on settings on the SIM and the
     * specified plmn (currently-registered PLMN).  See TS 22.101 Annex A
     * and TS 51.011 10.3.11 for details.
     *
     * If the SPN is not found on the SIM, the rule is always PLMN_ONLY.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.464 -0500", hash_original_method = "409DDAA47064BEED68B0319934A64CD2", hash_generated_method = "06A868A91D8AC4D7D5B235F1B42741D9")
    
@Override
    public int getDisplayRule(String plmn) {
        int rule;
        if (spn == null || spnDisplayCondition == -1) {
            // EF_SPN was not found on the SIM, or not yet loaded.  Just show ONS.
            rule = SPN_RULE_SHOW_PLMN;
        } else if (isOnMatchingPlmn(plmn)) {
            rule = SPN_RULE_SHOW_SPN;
            if ((spnDisplayCondition & 0x01) == 0x01) {
                // ONS required when registered to HPLMN or PLMN in EF_SPDI
                rule |= SPN_RULE_SHOW_PLMN;
            }
        } else {
            rule = SPN_RULE_SHOW_PLMN;
            if ((spnDisplayCondition & 0x02) == 0x00) {
                // SPN required if not registered to HPLMN or PLMN in EF_SPDI
                rule |= SPN_RULE_SHOW_SPN;
            }
        }
        return rule;
    }

    /**
     * Checks if plmn is HPLMN or on the spdiNetworks list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.466 -0500", hash_original_method = "94EB8BB16DAD2AA5FAF871DB9935C4E1", hash_generated_method = "B10CFC01F79C16B123A0B139BF2068B3")
    
private boolean isOnMatchingPlmn(String plmn) {
        if (plmn == null) return false;

        if (plmn.equals(getOperatorNumeric())) {
            return true;
        }

        if (spdiNetworks != null) {
            for (String spdiNet : spdiNetworks) {
                if (plmn.equals(spdiNet)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Finite State Machine to load Service Provider Name , which can be stored
     * in either EF_SPN (3GPP), EF_SPN_CPHS, or EF_SPN_SHORT_CPHS (CPHS4.2)
     *
     * After starting, FSM will search SPN EFs in order and stop after finding
     * the first valid SPN
     *
     * @param start set true only for initialize loading
     * @param ar the AsyncResult from loadEFTransparent
     *        ar.exception holds exception in error
     *        ar.result is byte[] for data in success
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.472 -0500", hash_original_method = "CF95CAB3FC09F3005867C57538604F5A", hash_generated_method = "CE61E9CA1F81FE2E2EBDD8CBB353B0EF")
    
private void getSpnFsm(boolean start, AsyncResult ar) {
        byte[] data;

        if (start) {
            spnState = Get_Spn_Fsm_State.INIT;
        }

        switch(spnState){
            case INIT:
                spn = null;

                phone.getIccFileHandler().loadEFTransparent( EF_SPN,
                        obtainMessage(EVENT_GET_SPN_DONE));
                recordsToLoad++;

                spnState = Get_Spn_Fsm_State.READ_SPN_3GPP;
                break;
            case READ_SPN_3GPP:
                if (ar != null && ar.exception == null) {
                    data = (byte[]) ar.result;
                    spnDisplayCondition = 0xff & data[0];
                    spn = IccUtils.adnStringFieldToString(data, 1, data.length - 1);

                    if (DBG) log("Load EF_SPN: " + spn
                            + " spnDisplayCondition: " + spnDisplayCondition);
                    phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ALPHA, spn);

                    spnState = Get_Spn_Fsm_State.IDLE;
                } else {
                    phone.getIccFileHandler().loadEFTransparent( EF_SPN_CPHS,
                            obtainMessage(EVENT_GET_SPN_DONE));
                    recordsToLoad++;

                    spnState = Get_Spn_Fsm_State.READ_SPN_CPHS;

                    // See TS 51.011 10.3.11.  Basically, default to
                    // show PLMN always, and SPN also if roaming.
                    spnDisplayCondition = -1;
                }
                break;
            case READ_SPN_CPHS:
                if (ar != null && ar.exception == null) {
                    data = (byte[]) ar.result;
                    spn = IccUtils.adnStringFieldToString(
                            data, 0, data.length - 1 );

                    if (DBG) log("Load EF_SPN_CPHS: " + spn);
                    phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ALPHA, spn);

                    spnState = Get_Spn_Fsm_State.IDLE;
                } else {
                    phone.getIccFileHandler().loadEFTransparent(
                            EF_SPN_SHORT_CPHS, obtainMessage(EVENT_GET_SPN_DONE));
                    recordsToLoad++;

                    spnState = Get_Spn_Fsm_State.READ_SPN_SHORT_CPHS;
                }
                break;
            case READ_SPN_SHORT_CPHS:
                if (ar != null && ar.exception == null) {
                    data = (byte[]) ar.result;
                    spn = IccUtils.adnStringFieldToString(
                            data, 0, data.length - 1);

                    if (DBG) log("Load EF_SPN_SHORT_CPHS: " + spn);
                    phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ALPHA, spn);
                }else {
                    if (DBG) log("No SPN loaded in either CHPS or 3GPP");
                }

                spnState = Get_Spn_Fsm_State.IDLE;
                break;
            default:
                spnState = Get_Spn_Fsm_State.IDLE;
        }
    }

    /**
     * Parse TS 51.011 EF[SPDI] record
     * This record contains the list of numeric network IDs that
     * are treated specially when determining SPN display
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.474 -0500", hash_original_method = "2AE095A71557CBF993C4F4933FD42467", hash_generated_method = "3DABC7C5ED360ECCBE47B7A30DD7BCCC")
    
private void
    parseEfSpdi(byte[] data) {
        SimTlv tlv = new SimTlv(data, 0, data.length);

        byte[] plmnEntries = null;

        for ( ; tlv.isValidObject() ; tlv.nextObject()) {
            // Skip SPDI tag, if existant
            if (tlv.getTag() == TAG_SPDI) {
              tlv = new SimTlv(tlv.getData(), 0, tlv.getData().length);
            }
            // There should only be one TAG_SPDI_PLMN_LIST
            if (tlv.getTag() == TAG_SPDI_PLMN_LIST) {
                plmnEntries = tlv.getData();
                break;
            }
        }

        if (plmnEntries == null) {
            return;
        }

        spdiNetworks = new ArrayList<String>(plmnEntries.length / 3);

        for (int i = 0 ; i + 2 < plmnEntries.length ; i += 3) {
            String plmnCode;
            plmnCode = IccUtils.bcdToString(plmnEntries, i, 3);

            // Valid operator codes are 5 or 6 digits
            if (plmnCode.length() >= 5) {
                log("EF_SPDI network: " + plmnCode);
                spdiNetworks.add(plmnCode);
            }
        }
    }

    /**
     * check to see if Mailbox Number is allocated and activated in CPHS SST
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.477 -0500", hash_original_method = "3EE42FFEB0B4A779D022FF2A029DBC31", hash_generated_method = "70E7CFC37DE77752A72E077AC8BCF1AA")
    
private boolean isCphsMailboxEnabled() {
        if (mCphsInfo == null)  return false;
        return ((mCphsInfo[1] & CPHS_SST_MBN_MASK) == CPHS_SST_MBN_ENABLED );
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.479 -0500", hash_original_method = "A8BE9816664C9DE6B42ACDFC7DA8D2D5", hash_generated_method = "4754820FD049BF126C2515BFBC2B0C33")
    
protected void log(String s) {
        Log.d(LOG_TAG, "[SIMRecords] " + s);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.481 -0500", hash_original_method = "747DCE9A0C1CA0D85263EB0A5CECAE60", hash_generated_method = "F09ECF95E6B1DAA041331D16BD7B7DCD")
    
protected void loge(String s) {
        Log.e(LOG_TAG, "[SIMRecords] " + s);
    }

    /**
     * Return true if "Restriction of menu options for manual PLMN selection"
     * bit is set or EF_CSP data is unavailable, return false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.484 -0500", hash_original_method = "545A7868DCB44F353BBAB91C69F027BF", hash_generated_method = "B42758890B055B88E8A59DAD553803B2")
    
public boolean isCspPlmnEnabled() {
        return mCspPlmnEnabled;
    }

    /**
     * Parse EF_CSP data and check if
     * "Restriction of menu options for manual PLMN selection" is
     * Enabled/Disabled
     *
     * @param data EF_CSP hex data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:33.487 -0500", hash_original_method = "5509D297F6B8CC0BD321C284BD8D086E", hash_generated_method = "1EE4C2A44C632B03EB2CD5B26F7BAC3B")
    
private void handleEfCspData(byte[] data) {
        // As per spec CPHS4_2.WW6, CPHS B.4.7.1, EF_CSP contains CPHS defined
        // 18 bytes (i.e 9 service groups info) and additional data specific to
        // operator. The valueAddedServicesGroup is not part of standard
        // services. This is operator specific and can be programmed any where.
        // Normally this is programmed as 10th service after the standard
        // services.
        int usedCspGroups = data.length / 2;
        // This is the "Servive Group Number" of "Value Added Services Group".
        byte valueAddedServicesGroup = (byte)0xC0;

        mCspPlmnEnabled = true;
        for (int i = 0; i < usedCspGroups; i++) {
             if (data[2 * i] == valueAddedServicesGroup) {
                 Log.i(LOG_TAG, "[CSP] found ValueAddedServicesGroup, value "
                       + data[(2 * i) + 1]);
                 if ((data[(2 * i) + 1] & 0x80) == 0x80) {
                     // Bit 8 is for
                     // "Restriction of menu options for manual PLMN selection".
                     // Operator Selection menu should be enabled.
                     mCspPlmnEnabled = true;
                 } else {
                     mCspPlmnEnabled = false;
                     // Operator Selection menu should be disabled.
                     // Operator Selection Mode should be set to Automatic.
                     Log.i(LOG_TAG,"[CSP] Set Automatic Network Selection");
                     phone.setNetworkSelectionModeAutomatic(null);
                 }
                 return;
             }
        }

        Log.w(LOG_TAG, "[CSP] Value Added Service Group (0xC0), not found!");
    }
}

