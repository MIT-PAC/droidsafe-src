package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.Registrant;
import android.os.RegistrantList;

import com.android.internal.telephony.gsm.UsimServiceTable;
import com.android.internal.telephony.ims.IsimRecords;

public abstract class IccRecords extends Handler implements IccConstants {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.907 -0500", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "5F5E7D64B04175B8FA820B2440F700FC")

    protected static final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.949 -0500", hash_original_field = "21299C5686260F13B1BCE2AC27E847C9", hash_generated_field = "AE900C33DD6B641C78C31FABD997315E")

    // Markers for mncLength
    protected static final int UNINITIALIZED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.951 -0500", hash_original_field = "A8F66825F9B3BFFF84E8E21A24CF617F", hash_generated_field = "6BA747F5F6BD077EF3A8E77E98D221F5")

    protected static final int UNKNOWN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.955 -0500", hash_original_field = "FF9D2AABA00294FFD3F1031D7F44FFEF", hash_generated_field = "3DE22AF8463CED644F8E2D74104B8D6F")

    protected static final int SPN_RULE_SHOW_SPN  = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.957 -0500", hash_original_field = "7560ACBAECDE29EC5F4840E2A25ABFB5", hash_generated_field = "2E2F4B40667BB48FB273B4095F5E6A8B")

    protected static final int SPN_RULE_SHOW_PLMN = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.960 -0500", hash_original_field = "E2368DE3EB59B8A65CA3D274EDE6D991", hash_generated_field = "154CF877331315935C82771B08D9BDA4")

    protected static final int EVENT_SET_MSISDN_DONE = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.962 -0500", hash_original_field = "BBE09FB0A1384394EA660A33F8763578", hash_generated_field = "CA143425A6D690BC70A39E8E55BD298C")

    public static final int EVENT_GET_ICC_RECORD_DONE = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.910 -0500", hash_original_field = "4D74BFF297E0DF8FA98FF6D8A8DBA78C", hash_generated_field = "4FEA837943E73EF5CB83661843F1AD15")

    protected PhoneBase phone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.912 -0500", hash_original_field = "D5A7E97BE96C9C8F7D963EEFD36476DC", hash_generated_field = "22088B3C6368949A409041586EB96D9E")

    protected RegistrantList recordsLoadedRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.914 -0500", hash_original_field = "77AFF45EACBE77E644F0B845E350E857", hash_generated_field = "09A069789AB8CC5E0817A1B6DEEBBCC0")

    protected int recordsToLoad;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.917 -0500", hash_original_field = "55862F1A6AE254D83723842B05A3358C", hash_generated_field = "A9FC3B8D9025A6D655B1A245F81835AF")

    protected AdnRecordCache adnCache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.920 -0500", hash_original_field = "922737CBA319CC7B88DDC3491D8C5F7F", hash_generated_field = "E4CF9D2DBB2C21800A07826757FEB9B0")

    protected boolean recordsRequested = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.922 -0500", hash_original_field = "750890BB0A587A24B8DD9EFF3E2AE9E2", hash_generated_field = "F5E4A116DF27CA0BDE1E4A1CB0E22F6A")

    public String iccid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.924 -0500", hash_original_field = "0A3790B148FA29FB87F103B4FA7603FD", hash_generated_field = "5C261783F0E29513E72DA191E0CBD1DB")

    protected String msisdn = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.926 -0500", hash_original_field = "6AAD354834CF04E34D2CA267FB45D444", hash_generated_field = "0B179531BA861A08DEFFA1E2E66BDF2A")

    protected String msisdnTag = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.928 -0500", hash_original_field = "E4E252C1130B219B6526D38737EAD5A7", hash_generated_field = "760EF44D51C8320E0DD1D03B12165BCC")

    protected String voiceMailNum = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.931 -0500", hash_original_field = "E2DDF276CB10DCC1AA7F7C5C096E06E6", hash_generated_field = "3D08C9D153D4ED67FDD6E0612B5AE420")

    protected String voiceMailTag = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.933 -0500", hash_original_field = "A25DD59AD16F4FCE91C2D6B680C82B0C", hash_generated_field = "3482F8713524A55F29C12AF4AD641DD3")

    protected String newVoiceMailNum = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.935 -0500", hash_original_field = "18B634B69ED362D16FC053EC8F5FFD08", hash_generated_field = "4E2A41B898A0A4294DB38CFEF3EA873E")

    protected String newVoiceMailTag = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.938 -0500", hash_original_field = "80040447CB80E22879FA700360EFED55", hash_generated_field = "275EC46FCEC8F62EFF931553B34C25AE")

    protected boolean isVoiceMailFixed = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.940 -0500", hash_original_field = "D8EBE7C66D549CD9EA279C8D04C91021", hash_generated_field = "DC5C95C7056BF4E6F2662FF614EC5E3F")

    protected int countVoiceMessages = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.942 -0500", hash_original_field = "69D87A38626ACB608E08F8AA53D800C1", hash_generated_field = "2C7829D7768AD355C84D545BEB2749F8")

    protected int mncLength = UNINITIALIZED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.944 -0500", hash_original_field = "CE889CE639595760DFC112B752E6B3A6", hash_generated_field = "66E6641F6EA793F9A67124859D71DFA8")

    protected int mailboxIndex = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.947 -0500", hash_original_field = "8C2775E85580ECA14E3C8FA11932EA8B", hash_generated_field = "614AE5456A5CBA179622A79E1C91F21D")

    protected String spn;

    // ***** Constructor

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.967 -0500", hash_original_method = "5D0BAB896645CD4136C27B68F12971AB", hash_generated_method = "9996CDA7FEE386CE7151FAE05B5E343A")
    
public IccRecords(PhoneBase p) {
        this.phone = p;
    }

    /**
     * Call when the IccRecords object is no longer going to be used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.969 -0500", hash_original_method = "05AD4FCF8399ECA695874E7F9126B120", hash_generated_method = "3A65586585D1609461086331A61384A4")
    
public abstract void dispose();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.971 -0500", hash_original_method = "758F039A900656878509DDA234D7AEB8", hash_generated_method = "6BEE21FF2E8E14B94D8570914FC779E5")
    
protected abstract void onRadioOffOrNotAvailable();

    //***** Public Methods
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.973 -0500", hash_original_method = "6A785FD128F813B36570564C326DA1E7", hash_generated_method = "F54AB348B8B82CC266C9D70F9FD31DA4")
    
public AdnRecordCache getAdnCache() {
        return adnCache;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.975 -0500", hash_original_method = "AA2893BF07782D58CCB881014444CA75", hash_generated_method = "17F0CA7301775EC314FC7705A7BEEDFF")
    
public void registerForRecordsLoaded(Handler h, int what, Object obj) {
        Registrant r = new Registrant(h, what, obj);
        recordsLoadedRegistrants.add(r);

        if (recordsToLoad == 0 && recordsRequested == true) {
            r.notifyRegistrant(new AsyncResult(null, null, null));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.978 -0500", hash_original_method = "85BD367933BB3DFE6ECA4F2F00438354", hash_generated_method = "8936C15E6F49F51C551A6E5ED8483FA5")
    
public void unregisterForRecordsLoaded(Handler h) {
        recordsLoadedRegistrants.remove(h);
    }

    /**
     * Get the International Mobile Subscriber ID (IMSI) on a SIM
     * for GSM, UMTS and like networks. Default is null if IMSI is
     * not supported or unavailable.
     *
     * @return null if SIM is not yet ready or unavailable
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.980 -0500", hash_original_method = "2D99B4210681FA66696D3EA5B94D1A66", hash_generated_method = "D07FF8ECA1A43CBFAF7B5B8FA1903995")
    
public String getIMSI() {
        return null;
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.983 -0500", hash_original_method = "9D42E73ED1AA846035EF94EBFAAEA8F6", hash_generated_method = "F1138A33B43D1F97901AB603D4F79F76")
    
public String getMsisdnNumber() {
        return msisdn;
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
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.986 -0500", hash_original_method = "6AA4F1E114DCD6F9D0799C96D9A882F0", hash_generated_method = "F9884145EEFFA59931DF15AC99970FF3")
    
public void setMsisdnNumber(String alphaTag, String number,
            Message onComplete) {

        msisdn = number;
        msisdnTag = alphaTag;

        if(DBG) log("Set MSISDN: " + msisdnTag +" " + msisdn);

        AdnRecord adn = new AdnRecord(msisdnTag, msisdn);

        new AdnRecordLoader(phone).updateEF(adn, EF_MSISDN, EF_EXT1, 1, null,
                obtainMessage(EVENT_SET_MSISDN_DONE, onComplete));
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.988 -0500", hash_original_method = "E32EFED28CC433860D178485CFB4EEE4", hash_generated_method = "1B4AFE5064CD03ADA2B3761686668224")
    
public String getMsisdnAlphaTag() {
        return msisdnTag;
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.990 -0500", hash_original_method = "77FFC0D98CD3CB2629C7F6A7D27E6FFF", hash_generated_method = "CFF64DE092E5BFF9A940C028E585122B")
    
public String getVoiceMailNumber() {
        return voiceMailNum;
    }

    /**
     * Return Service Provider Name stored in SIM (EF_SPN=0x6F46) or in RUIM (EF_RUIM_SPN=0x6F41)
     * @return null if SIM is not yet ready or no RUIM entry
     */
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.992 -0500", hash_original_method = "C90FEC698C502FA0146C0D3760005061", hash_generated_method = "86648868F5CF7F08E9B681F75C8A0EED")
    
public String getServiceProviderName() {
        return spn;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.994 -0500", hash_original_method = "B638882B098C0F8D29E9D1ED501CAF0A", hash_generated_method = "1CA2E9F1D5405A39710B0CFD2EC97F44")
    
public abstract void setVoiceMailNumber(String alphaTag, String voiceNumber,
            Message onComplete);

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.997 -0500", hash_original_method = "5A91F4662DCD8CEE6B5E6A046B7A4ABC", hash_generated_method = "6D7368A0D77DC432B7AD7E84B26C6DBA")
    
public String getVoiceMailAlphaTag() {
        return voiceMailTag;
    }

    /**
     * Sets the SIM voice message waiting indicator records
     * @param line GSM Subscriber Profile Number, one-based. Only '1' is supported
     * @param countWaiting The number of messages waiting, if known. Use
     *                     -1 to indicate that an unknown number of
     *                      messages are waiting
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.999 -0500", hash_original_method = "1C930D2082A0CD4DAC835AD954B87B66", hash_generated_method = "5E6412F071B6EE5A7D26588BA641BAC1")
    
public abstract void setVoiceMessageWaiting(int line, int countWaiting);

    /** @return  true if there are messages waiting, false otherwise. */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.002 -0500", hash_original_method = "2B603A0C333C2CCE42826636EDAB70FC", hash_generated_method = "C9243707B25847389D532C5A4935E3B8")
    
public boolean getVoiceMessageWaiting() {
        return countVoiceMessages != 0;
    }

    /**
     * Returns number of voice messages waiting, if available
     * If not available (eg, on an older CPHS SIM) -1 is returned if
     * getVoiceMessageWaiting() is true
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.005 -0500", hash_original_method = "E7F9312CD80A2D040F1A458CAC0EDAD1", hash_generated_method = "E64BBB2EF71825FBED23550C0B065816")
    
public int getVoiceMessageCount() {
        return countVoiceMessages;
    }

    /**
     * Called by STK Service when REFRESH is received.
     * @param fileChanged indicates whether any files changed
     * @param fileList if non-null, a list of EF files that changed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.007 -0500", hash_original_method = "1A8BE3F2EEDF2F450368A84B6C569597", hash_generated_method = "53C1D839F8D4BF79B9779AC211E0821C")
    
public abstract void onRefresh(boolean fileChanged, int[] fileList);

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.009 -0500", hash_original_method = "4C58BD1C1A36FD4BA9D906F07C4CE729", hash_generated_method = "2DE8597787F0514D4E7C8099C0FD095B")
    
public boolean getRecordsLoaded() {
        if (recordsToLoad == 0 && recordsRequested == true) {
            return true;
        } else {
            return false;
        }
    }

    //***** Overridden from Handler
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.013 -0500", hash_original_method = "49E7794891C738A256F21E277C3A3E98", hash_generated_method = "E777D1CEC7B1BA9D11C31F97DD888320")
    
@Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case EVENT_GET_ICC_RECORD_DONE:
                try {
                    AsyncResult ar = (AsyncResult) msg.obj;
                    IccRecordLoaded recordLoaded = (IccRecordLoaded) ar.userObj;
                    if (DBG) log(recordLoaded.getEfName() + " LOADED");

                    if (ar.exception != null) {
                        loge("Record Load Exception: " + ar.exception);
                    } else {
                        recordLoaded.onRecordLoaded(ar);
                    }
                }catch (RuntimeException exc) {
                    // I don't want these exceptions to be fatal
                    loge("Exception parsing SIM record: " + exc);
                } finally {
                    // Count up record load responses even if they are fails
                    onRecordLoaded();
                }
                break;

            default:
                super.handleMessage(msg);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.015 -0500", hash_original_method = "320A9A80BB80D8452D8F2FFF6B74E1B3", hash_generated_method = "7FCE748796CD970A45612A80C286E1FA")
    
protected abstract void onRecordLoaded();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.017 -0500", hash_original_method = "CDD7963A7A43DF2856E69DF8940397D9", hash_generated_method = "9B8169421B1B38FADA767FBE0A7C7204")
    
protected abstract void onAllRecordsLoaded();

    /**
     * Returns the SpnDisplayRule based on settings on the SIM and the
     * specified plmn (currently-registered PLMN).  See TS 22.101 Annex A
     * and TS 51.011 10.3.11 for details.
     *
     * If the SPN is not found on the SIM, the rule is always PLMN_ONLY.
     * Generally used for GSM/UMTS and the like SIMs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.019 -0500", hash_original_method = "D7880C6FFFC18637BE120D07ABC14C2D", hash_generated_method = "4A0B68BE784AF4A1FDC256565D467950")
    
public abstract int getDisplayRule(String plmn);

    /**
     * Return true if "Restriction of menu options for manual PLMN selection"
     * bit is set or EF_CSP data is unavailable, return false otherwise.
     * Generally used for GSM/UMTS and the like SIMs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.021 -0500", hash_original_method = "CF0496644C3B01F406F298A44D1902AC", hash_generated_method = "831598F77309DEFA8057E9B44FF5E7E4")
    
public boolean isCspPlmnEnabled() {
        return false;
    }

    /**
     * Returns the 5 or 6 digit MCC/MNC of the operator that
     * provided the SIM card. Returns null of SIM is not yet ready
     * or is not valid for the type of IccCard. Generally used for
     * GSM/UMTS and the like SIMS
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.023 -0500", hash_original_method = "9AAC604385E70B59FD0C2282B5610980", hash_generated_method = "1740F4A1C31AFBDD107474BA66B0ED09")
    
public String getOperatorNumeric() {
        return null;
    }
    
    public interface IccRecordLoaded {
        String getEfName();
        void onRecordLoaded(AsyncResult ar);
    }

    /**
     * Get the current Voice call forwarding flag for GSM/UMTS and the like SIMs
     *
     * @return true if enabled
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.026 -0500", hash_original_method = "2E5510735E3E74118CEEB63E6C24CB4C", hash_generated_method = "ECB5C300527CA9DF7B638E841845ACC4")
    
public boolean getVoiceCallForwardingFlag() {
        return false;
    }

    /**
     * Set the voice call forwarding flag for GSM/UMTS and the like SIMs
     *
     * @param line to enable/disable
     * @param enable
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.028 -0500", hash_original_method = "C3DD6C998A7A28E21EC84968A9C4D811", hash_generated_method = "913FDB8F1314674327D57E1E312DE543")
    
public void setVoiceCallForwardingFlag(int line, boolean enable) {
    }

    /**
     * Indicates wether SIM is in provisioned state or not.
     * Overridden only if SIM can be dynamically provisioned via OTA.
     *
     * @return true if provisioned
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.031 -0500", hash_original_method = "964BBC8F82C6DDB6B82192B110CE37ED", hash_generated_method = "836E2BBF562E1BDEFA3FCF6F29311A52")
    
public boolean isProvisioned () {
        return true;
    }

    /**
     * Write string to log file
     *
     * @param s is the string to write
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.033 -0500", hash_original_method = "48DBEBE9679DD6022C78E9B6D9D15841", hash_generated_method = "43827D28600B8F0847D532E80E30A990")
    
protected abstract void log(String s);

    /**
     * Write error string to log file.
     *
     * @param s is the string to write
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.035 -0500", hash_original_method = "8503C48BD28DECE909202E8D31B4BECE", hash_generated_method = "98998146AAEFC08A350487078A6888FB")
    
protected abstract void loge(String s);

    /**
     * Return an interface to retrieve the ISIM records for IMS, if available.
     * @return the interface to retrieve the ISIM records, or null if not supported
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.037 -0500", hash_original_method = "F728AE330C688766112F3603C63CB40C", hash_generated_method = "F38716A79F5F207C64B6480E1897599F")
    
public IsimRecords getIsimRecords() {
        return null;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.040 -0500", hash_original_method = "EA614E93014D97DC1971866BFCB21C89", hash_generated_method = "E6E534FEEFC1CCE8640124F46C5DCEAD")
    
public UsimServiceTable getUsimServiceTable() {
        return null;
    }
}

