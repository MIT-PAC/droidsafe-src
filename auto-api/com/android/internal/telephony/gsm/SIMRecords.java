package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC;
import android.content.Context;
import android.os.AsyncResult;
import android.os.Message;
import android.os.SystemProperties;
import android.util.Log;
import com.android.internal.telephony.AdnRecord;
import com.android.internal.telephony.AdnRecordCache;
import com.android.internal.telephony.AdnRecordLoader;
import com.android.internal.telephony.BaseCommands;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.IccRecords;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.IccVmFixedException;
import com.android.internal.telephony.IccVmNotSupportedException;
import com.android.internal.telephony.MccTable;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneBase;
import com.android.internal.telephony.SmsMessageBase;
import java.util.ArrayList;

public class SIMRecords extends IccRecords {
    VoiceMailConstants mVmConfig;
    SpnOverride mSpnOverride;
    private String imsi;
    private boolean callForwardingEnabled;
    private Get_Spn_Fsm_State spnState;
    private byte[] mCphsInfo = null;
    boolean mCspPlmnEnabled = true;
    byte[] efMWIS = null;
    byte[] efCPHS_MWI =null;
    byte[] mEfCff = null;
    byte[] mEfCfis = null;
    int spnDisplayCondition;
    ArrayList<String> spdiNetworks = null;
    String pnnHomeName = null;
    UsimServiceTable mUsimServiceTable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.231 -0400", hash_original_method = "AA8710B4BBDFAECA42DF87898B5E71E9", hash_generated_method = "74F4478037E4DB8420D904D92E12657E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIMRecords(PhoneBase p) {
        super(p);
        dsTaint.addTaint(p.dsTaint);
        adnCache = new AdnRecordCache(phone);
        mVmConfig = new VoiceMailConstants();
        mSpnOverride = new SpnOverride();
        recordsRequested = false;
        recordsToLoad = 0;
        p.mCM.registerForSIMReady(this, EVENT_SIM_READY, null);
        p.mCM.registerForOffOrNotAvailable(
                        this, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        p.mCM.setOnSmsOnSim(this, EVENT_SMS_ON_SIM, null);
        p.mCM.registerForIccRefresh(this, EVENT_SIM_REFRESH, null);
        onRadioOffOrNotAvailable();
        // ---------- Original Method ----------
        //adnCache = new AdnRecordCache(phone);
        //mVmConfig = new VoiceMailConstants();
        //mSpnOverride = new SpnOverride();
        //recordsRequested = false;
        //recordsToLoad = 0;
        //p.mCM.registerForSIMReady(this, EVENT_SIM_READY, null);
        //p.mCM.registerForOffOrNotAvailable(
                        //this, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        //p.mCM.setOnSmsOnSim(this, EVENT_SMS_ON_SIM, null);
        //p.mCM.registerForIccRefresh(this, EVENT_SIM_REFRESH, null);
        //onRadioOffOrNotAvailable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.232 -0400", hash_original_method = "60B34C0CDC881E5C8D40C8AAD990557F", hash_generated_method = "3EA07F3E006CA7F93EFE786B4B31CD0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dispose() {
        phone.mCM.unregisterForSIMReady(this);
        phone.mCM.unregisterForOffOrNotAvailable( this);
        phone.mCM.unregisterForIccRefresh(this);
        // ---------- Original Method ----------
        //phone.mCM.unregisterForSIMReady(this);
        //phone.mCM.unregisterForOffOrNotAvailable( this);
        //phone.mCM.unregisterForIccRefresh(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.232 -0400", hash_original_method = "D676C6F3D2367DC0A4942786FE826692", hash_generated_method = "6E2BC99A5C88DFAF422E2B6A62A301F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() {
        Log.d(LOG_TAG, "SIMRecords finalized");
        // ---------- Original Method ----------
        //if(DBG) Log.d(LOG_TAG, "SIMRecords finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.232 -0400", hash_original_method = "1C495E4F05849546A87C14B5D6E64BED", hash_generated_method = "DFF28017DADF7D467DB4EC42F6547305")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onRadioOffOrNotAvailable() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        imsi = null;
        msisdn = null;
        voiceMailNum = null;
        countVoiceMessages = 0;
        mncLength = UNINITIALIZED;
        iccid = null;
        spnDisplayCondition = -1;
        efMWIS = null;
        efCPHS_MWI = null;
        spdiNetworks = null;
        pnnHomeName = null;
        adnCache.reset();
        phone.setSystemProperty(PROPERTY_ICC_OPERATOR_NUMERIC, null);
        phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ALPHA, null);
        phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ISO_COUNTRY, null);
        recordsRequested = false;
        // ---------- Original Method ----------
        //imsi = null;
        //msisdn = null;
        //voiceMailNum = null;
        //countVoiceMessages = 0;
        //mncLength = UNINITIALIZED;
        //iccid = null;
        //spnDisplayCondition = -1;
        //efMWIS = null;
        //efCPHS_MWI = null;
        //spdiNetworks = null;
        //pnnHomeName = null;
        //adnCache.reset();
        //phone.setSystemProperty(PROPERTY_ICC_OPERATOR_NUMERIC, null);
        //phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ALPHA, null);
        //phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ISO_COUNTRY, null);
        //recordsRequested = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.232 -0400", hash_original_method = "3D26DD60574339032566256F631F5DB8", hash_generated_method = "56387EE6C410A72EC508A1C9CAFA8F76")
    @DSModeled(DSC.SAFE)
    @Override
    public String getIMSI() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return imsi;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.233 -0400", hash_original_method = "9D42E73ED1AA846035EF94EBFAAEA8F6", hash_generated_method = "F765AACA026CA58BC955AF124B888331")
    @DSModeled(DSC.SAFE)
    public String getMsisdnNumber() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return msisdn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.233 -0400", hash_original_method = "F96F62208A76C85F8691E193053EFC74", hash_generated_method = "29EAEBBD34AB3CB3CA5EB07374938EB6")
    @DSModeled(DSC.SAFE)
    @Override
    public UsimServiceTable getUsimServiceTable() {
        return (UsimServiceTable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mUsimServiceTable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.233 -0400", hash_original_method = "7B16D051528D70BC1665C409BE0B92A5", hash_generated_method = "F95A0759B5A0373569EB676882DD7712")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMsisdnNumber(String alphaTag, String number,
            Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(number);
        dsTaint.addTaint(alphaTag);
        msisdn = number;
        msisdnTag = alphaTag;
        log("Set MSISDN: " + msisdnTag + " " +  "xxxxxxx");
        AdnRecord adn;
        adn = new AdnRecord(msisdnTag, msisdn);
        new AdnRecordLoader(phone).updateEF(adn, EF_MSISDN, EF_EXT1, 1, null,
                obtainMessage(EVENT_SET_MSISDN_DONE, onComplete));
        // ---------- Original Method ----------
        //msisdn = number;
        //msisdnTag = alphaTag;
        //if(DBG) log("Set MSISDN: " + msisdnTag + " " +  "xxxxxxx");
        //AdnRecord adn = new AdnRecord(msisdnTag, msisdn);
        //new AdnRecordLoader(phone).updateEF(adn, EF_MSISDN, EF_EXT1, 1, null,
                //obtainMessage(EVENT_SET_MSISDN_DONE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.233 -0400", hash_original_method = "E32EFED28CC433860D178485CFB4EEE4", hash_generated_method = "2FBFE97AFF5B83DB3F125BBF157C3945")
    @DSModeled(DSC.SAFE)
    public String getMsisdnAlphaTag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return msisdnTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.233 -0400", hash_original_method = "77FFC0D98CD3CB2629C7F6A7D27E6FFF", hash_generated_method = "02654A5E479E12E9B21BB8230BBC222B")
    @DSModeled(DSC.SAFE)
    public String getVoiceMailNumber() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return voiceMailNum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.234 -0400", hash_original_method = "BBA59ED68AB83B35B5A29C09BCF3BE4C", hash_generated_method = "8E6489AB6775A52C9CAD17CFB75C8A20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVoiceMailNumber(String alphaTag, String voiceNumber,
            Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(alphaTag);
        dsTaint.addTaint(voiceNumber);
        {
            AsyncResult.forMessage((onComplete)).exception =
                    new IccVmFixedException("Voicemail number is fixed by operator");
            onComplete.sendToTarget();
        } //End block
        newVoiceMailNum = voiceNumber;
        newVoiceMailTag = alphaTag;
        AdnRecord adn;
        adn = new AdnRecord(newVoiceMailTag, newVoiceMailNum);
        {
            new AdnRecordLoader(phone).updateEF(adn, EF_MBDN, EF_EXT6,
                    mailboxIndex, null,
                    obtainMessage(EVENT_SET_MBDN_DONE, onComplete));
        } //End block
        {
            boolean var49EDB32946FB23439D4ABEF334DBE8F4_1344412801 = (isCphsMailboxEnabled());
            {
                new AdnRecordLoader(phone).updateEF(adn, EF_MAILBOX_CPHS,
                    EF_EXT1, 1, null,
                    obtainMessage(EVENT_SET_CPHS_MAILBOX_DONE, onComplete));
            } //End block
            {
                AsyncResult.forMessage((onComplete)).exception =
                    new IccVmNotSupportedException("Update SIM voice mailbox error");
                onComplete.sendToTarget();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.234 -0400", hash_original_method = "5A91F4662DCD8CEE6B5E6A046B7A4ABC", hash_generated_method = "586746FD3FBF4D64F8B3797B80A4E8F4")
    @DSModeled(DSC.SAFE)
    public String getVoiceMailAlphaTag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return voiceMailTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.235 -0400", hash_original_method = "75BFE4AFE8A3A09F4E38976A214FAF70", hash_generated_method = "D47FB692BB9B2FD6B5987B29A835C95B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVoiceMessageWaiting(int line, int countWaiting) {
        dsTaint.addTaint(countWaiting);
        dsTaint.addTaint(line);
        {
            countWaiting = -1;
        } //End block
        {
            countWaiting = 0xff;
        } //End block
        countVoiceMessages = countWaiting;
        phone.notifyMessageWaitingIndicator();
        try 
        {
            {
                efMWIS[0] = (byte)((efMWIS[0] & 0xfe)
                                    | (countVoiceMessages == 0 ? 0 : 1));
                {
                    efMWIS[1] = 0;
                } //End block
                {
                    efMWIS[1] = (byte) countWaiting;
                } //End block
                phone.getIccFileHandler().updateEFLinearFixed(
                    EF_MWIS, 1, efMWIS, null,
                    obtainMessage (EVENT_UPDATE_DONE, EF_MWIS));
            } //End block
            {
                efCPHS_MWI[0] = (byte)((efCPHS_MWI[0] & 0xf0)
                            | (countVoiceMessages == 0 ? 0x5 : 0xa));
                phone.getIccFileHandler().updateEFTransparent(
                    EF_VOICE_MAIL_INDICATOR_CPHS, efCPHS_MWI,
                    obtainMessage (EVENT_UPDATE_DONE, EF_VOICE_MAIL_INDICATOR_CPHS));
            } //End block
        } //End block
        catch (ArrayIndexOutOfBoundsException ex)
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.235 -0400", hash_original_method = "2A8D94361FF074096EDCA291A7FA986D", hash_generated_method = "388BEDFBBD1FC6A7AC94E1EC0D5A1360")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean getVoiceCallForwardingFlag() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return callForwardingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.235 -0400", hash_original_method = "141082A6B47AB008F9D1AEFE7E7266B0", hash_generated_method = "A023DBADD652C440B1B1284CAE166E70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setVoiceCallForwardingFlag(int line, boolean enable) {
        dsTaint.addTaint(enable);
        dsTaint.addTaint(line);
        phone.notifyCallForwardingIndicator();
        try 
        {
            {
                {
                    mEfCfis[1] |= 1;
                } //End block
                {
                    mEfCfis[1] &= 0xfe;
                } //End block
                phone.getIccFileHandler().updateEFLinearFixed(
                        EF_CFIS, 1, mEfCfis, null,
                        obtainMessage (EVENT_UPDATE_DONE, EF_CFIS));
            } //End block
            {
                {
                    mEfCff[0] = (byte) ((mEfCff[0] & CFF_LINE1_RESET)
                            | CFF_UNCONDITIONAL_ACTIVE);
                } //End block
                {
                    mEfCff[0] = (byte) ((mEfCff[0] & CFF_LINE1_RESET)
                            | CFF_UNCONDITIONAL_DEACTIVE);
                } //End block
                phone.getIccFileHandler().updateEFTransparent(
                        EF_CFF_CPHS, mEfCff,
                        obtainMessage (EVENT_UPDATE_DONE, EF_CFF_CPHS));
            } //End block
        } //End block
        catch (ArrayIndexOutOfBoundsException ex)
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.236 -0400", hash_original_method = "3729AD4A21CE0EDB3800382FBE3F87EC", hash_generated_method = "273301E422BCA2CC3BDB5743EF178575")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onRefresh(boolean fileChanged, int[] fileList) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(fileList[0]);
        dsTaint.addTaint(fileChanged);
        {
            fetchSimRecords();
        } //End block
        // ---------- Original Method ----------
        //if (fileChanged) {
            //fetchSimRecords();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.236 -0400", hash_original_method = "7E03E5ED77A0C757F38448793B936037", hash_generated_method = "120CB826F4121FA6A5E2B041127C626B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getOperatorNumeric() {
        {
            Log.d(LOG_TAG, "getOperatorNumeric: IMSI == null");
        } //End block
        {
            Log.d(LOG_TAG, "getSIMOperatorNumeric: bad mncLength");
        } //End block
        String varDFCFCEB39881F05734139F91F9B3FBA0_687414788 = (imsi.substring(0, 3 + mncLength));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (imsi == null) {
            //Log.d(LOG_TAG, "getOperatorNumeric: IMSI == null");
            //return null;
        //}
        //if (mncLength == UNINITIALIZED || mncLength == UNKNOWN) {
            //Log.d(LOG_TAG, "getSIMOperatorNumeric: bad mncLength");
            //return null;
        //}
        //return imsi.substring(0, 3 + mncLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.775 -0400", hash_original_method = "5FA65278BC21B747191DBEA87B814DA9", hash_generated_method = "5E0AAF298E217C3093FC5E8990A5619B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        AsyncResult ar;
        AdnRecord adn;
        byte data[];
        boolean isRecordLoadResponse;
        isRecordLoadResponse = false;
        try 
        {
            //Begin case EVENT_SIM_READY 
            onSimReady();
            //End case EVENT_SIM_READY 
            //Begin case EVENT_RADIO_OFF_OR_NOT_AVAILABLE 
            onRadioOffOrNotAvailable();
            //End case EVENT_RADIO_OFF_OR_NOT_AVAILABLE 
            //Begin case EVENT_GET_IMSI_DONE 
            isRecordLoadResponse = true;
            //End case EVENT_GET_IMSI_DONE 
            //Begin case EVENT_GET_IMSI_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_IMSI_DONE 
            //Begin case EVENT_GET_IMSI_DONE 
            imsi = (String) ar.result;
            //End case EVENT_GET_IMSI_DONE 
            //Begin case EVENT_GET_IMSI_DONE 
            {
                boolean var830EA25F7AEDECBD15578DB21CAE52BA_1855817704 = (imsi != null && (imsi.length() < 6 || imsi.length() > 15));
                {
                    imsi = null;
                } //End block
            } //End collapsed parenthetic
            //End case EVENT_GET_IMSI_DONE 
            //Begin case EVENT_GET_IMSI_DONE 
            Log.d(LOG_TAG, "IMSI: " +  "xxxxxxx");
            //End case EVENT_GET_IMSI_DONE 
            //Begin case EVENT_GET_IMSI_DONE 
            {
                boolean varAA3845750DE6743614D7EDB45EFDA541_1906269663 = (((mncLength == UNKNOWN) || (mncLength == 2)) &&
                        ((imsi != null) && (imsi.length() >= 6)));
                {
                    String mccmncCode;
                    mccmncCode = imsi.substring(0, 6);
                    {
                        String mccmnc = MCCMNC_CODES_HAVING_3DIGITS_MNC[0];
                        {
                            {
                                boolean var7D3F2C7003F88A96589D9955600C8CFE_754375526 = (mccmnc.equals(mccmncCode));
                                {
                                    mncLength = 3;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            //End case EVENT_GET_IMSI_DONE 
            //Begin case EVENT_GET_IMSI_DONE 
            {
                try 
                {
                    int mcc;
                    mcc = Integer.parseInt(imsi.substring(0,3));
                    mncLength = MccTable.smallestDigitsMccForMnc(mcc);
                } //End block
                catch (NumberFormatException e)
                {
                    mncLength = UNKNOWN;
                } //End block
            } //End block
            //End case EVENT_GET_IMSI_DONE 
            //Begin case EVENT_GET_IMSI_DONE 
            {
                MccTable.updateMccMncConfiguration(phone, imsi.substring(0, 3 + mncLength));
            } //End block
            //End case EVENT_GET_IMSI_DONE 
            //Begin case EVENT_GET_IMSI_DONE 
            phone.mIccCard.broadcastIccStateChangedIntent(
                        SimCard.INTENT_VALUE_ICC_IMSI, null);
            //End case EVENT_GET_IMSI_DONE 
            //Begin case EVENT_GET_MBI_DONE 
            boolean isValidMbdn;
            //End case EVENT_GET_MBI_DONE 
            //Begin case EVENT_GET_MBI_DONE 
            isRecordLoadResponse = true;
            //End case EVENT_GET_MBI_DONE 
            //Begin case EVENT_GET_MBI_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_MBI_DONE 
            //Begin case EVENT_GET_MBI_DONE 
            data = (byte[]) ar.result;
            //End case EVENT_GET_MBI_DONE 
            //Begin case EVENT_GET_MBI_DONE 
            isValidMbdn = false;
            //End case EVENT_GET_MBI_DONE 
            //Begin case EVENT_GET_MBI_DONE 
            {
                Log.d(LOG_TAG, "EF_MBI: " +
                            IccUtils.bytesToHexString(data));
                mailboxIndex = (int)data[0] & 0xff;
                {
                    Log.d(LOG_TAG, "Got valid mailbox number for MBDN");
                    isValidMbdn = true;
                } //End block
            } //End block
            //End case EVENT_GET_MBI_DONE 
            //Begin case EVENT_GET_MBI_DONE 
            recordsToLoad += 1;
            //End case EVENT_GET_MBI_DONE 
            //Begin case EVENT_GET_MBI_DONE 
            {
                new AdnRecordLoader(phone).loadFromEF(EF_MBDN, EF_EXT6,
                            mailboxIndex, obtainMessage(EVENT_GET_MBDN_DONE));
            } //End block
            {
                new AdnRecordLoader(phone).loadFromEF(EF_MAILBOX_CPHS,
                            EF_EXT1, 1,
                            obtainMessage(EVENT_GET_CPHS_MAILBOX_DONE));
            } //End block
            //End case EVENT_GET_MBI_DONE 
            //Begin case EVENT_GET_CPHS_MAILBOX_DONE EVENT_GET_MBDN_DONE 
            voiceMailNum = null;
            //End case EVENT_GET_CPHS_MAILBOX_DONE EVENT_GET_MBDN_DONE 
            //Begin case EVENT_GET_CPHS_MAILBOX_DONE EVENT_GET_MBDN_DONE 
            voiceMailTag = null;
            //End case EVENT_GET_CPHS_MAILBOX_DONE EVENT_GET_MBDN_DONE 
            //Begin case EVENT_GET_CPHS_MAILBOX_DONE EVENT_GET_MBDN_DONE 
            isRecordLoadResponse = true;
            //End case EVENT_GET_CPHS_MAILBOX_DONE EVENT_GET_MBDN_DONE 
            //Begin case EVENT_GET_CPHS_MAILBOX_DONE EVENT_GET_MBDN_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_CPHS_MAILBOX_DONE EVENT_GET_MBDN_DONE 
            //Begin case EVENT_GET_CPHS_MAILBOX_DONE EVENT_GET_MBDN_DONE 
            {
                Log.d(LOG_TAG, "Invalid or missing EF"
                        + ((msg.what == EVENT_GET_CPHS_MAILBOX_DONE) ? "[MAILBOX]" : "[MBDN]"));
                {
                    recordsToLoad += 1;
                    new AdnRecordLoader(phone).loadFromEF(
                                EF_MAILBOX_CPHS, EF_EXT1, 1,
                                obtainMessage(EVENT_GET_CPHS_MAILBOX_DONE));
                } //End block
            } //End block
            //End case EVENT_GET_CPHS_MAILBOX_DONE EVENT_GET_MBDN_DONE 
            //Begin case EVENT_GET_CPHS_MAILBOX_DONE EVENT_GET_MBDN_DONE 
            adn = (AdnRecord)ar.result;
            //End case EVENT_GET_CPHS_MAILBOX_DONE EVENT_GET_MBDN_DONE 
            //Begin case EVENT_GET_CPHS_MAILBOX_DONE EVENT_GET_MBDN_DONE 
            Log.d(LOG_TAG, "VM: " + adn +
                        ((msg.what == EVENT_GET_CPHS_MAILBOX_DONE) ? " EF[MAILBOX]" : " EF[MBDN]"));
            //End case EVENT_GET_CPHS_MAILBOX_DONE EVENT_GET_MBDN_DONE 
            //Begin case EVENT_GET_CPHS_MAILBOX_DONE EVENT_GET_MBDN_DONE 
            {
                boolean var6E610A8EE073A016325ACA342BC92511_1351467550 = (adn.isEmpty() && msg.what == EVENT_GET_MBDN_DONE);
                {
                    recordsToLoad += 1;
                    new AdnRecordLoader(phone).loadFromEF(
                            EF_MAILBOX_CPHS, EF_EXT1, 1,
                            obtainMessage(EVENT_GET_CPHS_MAILBOX_DONE));
                } //End block
            } //End collapsed parenthetic
            //End case EVENT_GET_CPHS_MAILBOX_DONE EVENT_GET_MBDN_DONE 
            //Begin case EVENT_GET_CPHS_MAILBOX_DONE EVENT_GET_MBDN_DONE 
            voiceMailNum = adn.getNumber();
            //End case EVENT_GET_CPHS_MAILBOX_DONE EVENT_GET_MBDN_DONE 
            //Begin case EVENT_GET_CPHS_MAILBOX_DONE EVENT_GET_MBDN_DONE 
            voiceMailTag = adn.getAlphaTag();
            //End case EVENT_GET_CPHS_MAILBOX_DONE EVENT_GET_MBDN_DONE 
            //Begin case EVENT_GET_MSISDN_DONE 
            isRecordLoadResponse = true;
            //End case EVENT_GET_MSISDN_DONE 
            //Begin case EVENT_GET_MSISDN_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_MSISDN_DONE 
            //Begin case EVENT_GET_MSISDN_DONE 
            {
                Log.d(LOG_TAG, "Invalid or missing EF[MSISDN]");
            } //End block
            //End case EVENT_GET_MSISDN_DONE 
            //Begin case EVENT_GET_MSISDN_DONE 
            adn = (AdnRecord)ar.result;
            //End case EVENT_GET_MSISDN_DONE 
            //Begin case EVENT_GET_MSISDN_DONE 
            msisdn = adn.getNumber();
            //End case EVENT_GET_MSISDN_DONE 
            //Begin case EVENT_GET_MSISDN_DONE 
            msisdnTag = adn.getAlphaTag();
            //End case EVENT_GET_MSISDN_DONE 
            //Begin case EVENT_GET_MSISDN_DONE 
            Log.d(LOG_TAG, "MSISDN: " +  "xxxxxxx");
            //End case EVENT_GET_MSISDN_DONE 
            //Begin case EVENT_SET_MSISDN_DONE 
            isRecordLoadResponse = false;
            //End case EVENT_SET_MSISDN_DONE 
            //Begin case EVENT_SET_MSISDN_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_SET_MSISDN_DONE 
            //Begin case EVENT_SET_MSISDN_DONE 
            {
                AsyncResult.forMessage(((Message) ar.userObj)).exception
                            = ar.exception;
                ((Message) ar.userObj).sendToTarget();
            } //End block
            //End case EVENT_SET_MSISDN_DONE 
            //Begin case EVENT_GET_MWIS_DONE 
            isRecordLoadResponse = true;
            //End case EVENT_GET_MWIS_DONE 
            //Begin case EVENT_GET_MWIS_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_MWIS_DONE 
            //Begin case EVENT_GET_MWIS_DONE 
            data = (byte[])ar.result;
            //End case EVENT_GET_MWIS_DONE 
            //Begin case EVENT_GET_MWIS_DONE 
            Log.d(LOG_TAG, "EF_MWIS: " +
                   IccUtils.bytesToHexString(data));
            //End case EVENT_GET_MWIS_DONE 
            //Begin case EVENT_GET_MWIS_DONE 
            efMWIS = data;
            //End case EVENT_GET_MWIS_DONE 
            //Begin case EVENT_GET_MWIS_DONE 
            {
                Log.d(LOG_TAG, "SIMRecords: Uninitialized record MWIS");
            } //End block
            //End case EVENT_GET_MWIS_DONE 
            //Begin case EVENT_GET_MWIS_DONE 
            boolean voiceMailWaiting;
            voiceMailWaiting = ((data[0] & 0x01) != 0);
            //End case EVENT_GET_MWIS_DONE 
            //Begin case EVENT_GET_MWIS_DONE 
            countVoiceMessages = data[1] & 0xff;
            //End case EVENT_GET_MWIS_DONE 
            //Begin case EVENT_GET_MWIS_DONE 
            {
                countVoiceMessages = -1;
            } //End block
            //End case EVENT_GET_MWIS_DONE 
            //Begin case EVENT_GET_MWIS_DONE 
            phone.notifyMessageWaitingIndicator();
            //End case EVENT_GET_MWIS_DONE 
            //Begin case EVENT_GET_VOICE_MAIL_INDICATOR_CPHS_DONE 
            isRecordLoadResponse = true;
            //End case EVENT_GET_VOICE_MAIL_INDICATOR_CPHS_DONE 
            //Begin case EVENT_GET_VOICE_MAIL_INDICATOR_CPHS_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_VOICE_MAIL_INDICATOR_CPHS_DONE 
            //Begin case EVENT_GET_VOICE_MAIL_INDICATOR_CPHS_DONE 
            data = (byte[])ar.result;
            //End case EVENT_GET_VOICE_MAIL_INDICATOR_CPHS_DONE 
            //Begin case EVENT_GET_VOICE_MAIL_INDICATOR_CPHS_DONE 
            efCPHS_MWI = data;
            //End case EVENT_GET_VOICE_MAIL_INDICATOR_CPHS_DONE 
            //Begin case EVENT_GET_VOICE_MAIL_INDICATOR_CPHS_DONE 
            {
                int indicator;
                indicator = (int)(data[0] & 0xf);
                {
                    countVoiceMessages = -1;
                } //End block
                {
                    countVoiceMessages = 0;
                } //End block
                phone.notifyMessageWaitingIndicator();
            } //End block
            //End case EVENT_GET_VOICE_MAIL_INDICATOR_CPHS_DONE 
            //Begin case EVENT_GET_ICCID_DONE 
            isRecordLoadResponse = true;
            //End case EVENT_GET_ICCID_DONE 
            //Begin case EVENT_GET_ICCID_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_ICCID_DONE 
            //Begin case EVENT_GET_ICCID_DONE 
            data = (byte[])ar.result;
            //End case EVENT_GET_ICCID_DONE 
            //Begin case EVENT_GET_ICCID_DONE 
            iccid = IccUtils.bcdToString(data, 0, data.length);
            //End case EVENT_GET_ICCID_DONE 
            //Begin case EVENT_GET_ICCID_DONE 
            Log.d(LOG_TAG, "iccid: " + iccid);
            //End case EVENT_GET_ICCID_DONE 
            //Begin case EVENT_GET_AD_DONE 
            try 
            {
                isRecordLoadResponse = true;
                ar = (AsyncResult)msg.obj;
                data = (byte[])ar.result;
                Log.d(LOG_TAG, "EF_AD: " +
                            IccUtils.bytesToHexString(data));
                {
                    Log.d(LOG_TAG, "SIMRecords: Corrupt AD data on SIM");
                } //End block
                {
                    Log.d(LOG_TAG, "SIMRecords: MNC length not present in EF_AD");
                } //End block
                mncLength = (int)data[3] & 0xf;
                {
                    mncLength = UNKNOWN;
                } //End block
            } //End block
            finally 
            {
                {
                    boolean varA6967A0FC894379A31A07978EEE8D097_15735849 = (((mncLength == UNINITIALIZED) || (mncLength == UNKNOWN) ||
                            (mncLength == 2)) && ((imsi != null) && (imsi.length() >= 6)));
                    {
                        String mccmncCode;
                        mccmncCode = imsi.substring(0, 6);
                        {
                            Iterator<String> varC240E69CE119782E8F47CC07C68C68DD_2101085496 = (MCCMNC_CODES_HAVING_3DIGITS_MNC).iterator();
                            varC240E69CE119782E8F47CC07C68C68DD_2101085496.hasNext();
                            String mccmnc = varC240E69CE119782E8F47CC07C68C68DD_2101085496.next();
                            {
                                {
                                    boolean var84BDA82F133A3C6DFBD3E95E8608ED9C_962889922 = (mccmnc.equals(mccmncCode));
                                    {
                                        mncLength = 3;
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    {
                        try 
                        {
                            int mcc;
                            mcc = Integer.parseInt(imsi.substring(0,3));
                            mncLength = MccTable.smallestDigitsMccForMnc(mcc);
                        } //End block
                        catch (NumberFormatException e)
                        {
                            mncLength = UNKNOWN;
                        } //End block
                    } //End block
                    {
                        mncLength = UNKNOWN;
                        Log.d(LOG_TAG, "SIMRecords: MNC length not present in EF_AD");
                    } //End block
                } //End block
                {
                    MccTable.updateMccMncConfiguration(phone, imsi.substring(0, 3 + mncLength));
                } //End block
            } //End block
            //End case EVENT_GET_AD_DONE 
            //Begin case EVENT_GET_SPN_DONE 
            isRecordLoadResponse = true;
            //End case EVENT_GET_SPN_DONE 
            //Begin case EVENT_GET_SPN_DONE 
            ar = (AsyncResult) msg.obj;
            //End case EVENT_GET_SPN_DONE 
            //Begin case EVENT_GET_SPN_DONE 
            getSpnFsm(false, ar);
            //End case EVENT_GET_SPN_DONE 
            //Begin case EVENT_GET_CFF_DONE 
            isRecordLoadResponse = true;
            //End case EVENT_GET_CFF_DONE 
            //Begin case EVENT_GET_CFF_DONE 
            ar = (AsyncResult) msg.obj;
            //End case EVENT_GET_CFF_DONE 
            //Begin case EVENT_GET_CFF_DONE 
            data = (byte[]) ar.result;
            //End case EVENT_GET_CFF_DONE 
            //Begin case EVENT_GET_CFF_DONE 
            Log.d(LOG_TAG, "EF_CFF_CPHS: " +
                        IccUtils.bytesToHexString(data));
            //End case EVENT_GET_CFF_DONE 
            //Begin case EVENT_GET_CFF_DONE 
            mEfCff = data;
            //End case EVENT_GET_CFF_DONE 
            //Begin case EVENT_GET_CFF_DONE 
            {
                callForwardingEnabled =
                        ((data[0] & CFF_LINE1_MASK) == CFF_UNCONDITIONAL_ACTIVE);
                phone.notifyCallForwardingIndicator();
            } //End block
            //End case EVENT_GET_CFF_DONE 
            //Begin case EVENT_GET_SPDI_DONE 
            isRecordLoadResponse = true;
            //End case EVENT_GET_SPDI_DONE 
            //Begin case EVENT_GET_SPDI_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_SPDI_DONE 
            //Begin case EVENT_GET_SPDI_DONE 
            data = (byte[])ar.result;
            //End case EVENT_GET_SPDI_DONE 
            //Begin case EVENT_GET_SPDI_DONE 
            parseEfSpdi(data);
            //End case EVENT_GET_SPDI_DONE 
            //Begin case EVENT_UPDATE_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_UPDATE_DONE 
            //Begin case EVENT_GET_PNN_DONE 
            isRecordLoadResponse = true;
            //End case EVENT_GET_PNN_DONE 
            //Begin case EVENT_GET_PNN_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_PNN_DONE 
            //Begin case EVENT_GET_PNN_DONE 
            data = (byte[])ar.result;
            //End case EVENT_GET_PNN_DONE 
            //Begin case EVENT_GET_PNN_DONE 
            SimTlv tlv;
            tlv = new SimTlv(data, 0, data.length);
            //End case EVENT_GET_PNN_DONE 
            //Begin case EVENT_GET_PNN_DONE 
            {
                boolean varCB644CCA004D571A2231D5557A3D0712_956912182 = (tlv.isValidObject());
                tlv.nextObject();
                {
                    {
                        boolean varA602311CA9E7B0FBD63424EF01DC038B_627504537 = (tlv.getTag() == TAG_FULL_NETWORK_NAME);
                        {
                            pnnHomeName
                            = IccUtils.networkNameToString(
                                tlv.getData(), 0, tlv.getData().length);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            //End case EVENT_GET_PNN_DONE 
            //Begin case EVENT_GET_ALL_SMS_DONE 
            isRecordLoadResponse = true;
            //End case EVENT_GET_ALL_SMS_DONE 
            //Begin case EVENT_GET_ALL_SMS_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_ALL_SMS_DONE 
            //Begin case EVENT_GET_ALL_SMS_DONE 
            handleSmses((ArrayList) ar.result);
            //End case EVENT_GET_ALL_SMS_DONE 
            //Begin case EVENT_SMS_ON_SIM 
            isRecordLoadResponse = false;
            //End case EVENT_SMS_ON_SIM 
            //Begin case EVENT_SMS_ON_SIM 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_SMS_ON_SIM 
            //Begin case EVENT_SMS_ON_SIM 
            int[] index;
            index = (int[])ar.result;
            //End case EVENT_SMS_ON_SIM 
            //Begin case EVENT_SMS_ON_SIM 
            {
                Log.d(LOG_TAG, "READ EF_SMS RECORD index=" + index[0]);
                phone.getIccFileHandler().loadEFLinearFixed(EF_SMS,index[0],
                            obtainMessage(EVENT_GET_SMS_DONE));
            } //End block
            //End case EVENT_SMS_ON_SIM 
            //Begin case EVENT_GET_SMS_DONE 
            isRecordLoadResponse = false;
            //End case EVENT_GET_SMS_DONE 
            //Begin case EVENT_GET_SMS_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_SMS_DONE 
            //Begin case EVENT_GET_SMS_DONE 
            {
                handleSms((byte[])ar.result);
            } //End block
            //End case EVENT_GET_SMS_DONE 
            //Begin case EVENT_GET_SST_DONE 
            isRecordLoadResponse = true;
            //End case EVENT_GET_SST_DONE 
            //Begin case EVENT_GET_SST_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_SST_DONE 
            //Begin case EVENT_GET_SST_DONE 
            data = (byte[])ar.result;
            //End case EVENT_GET_SST_DONE 
            //Begin case EVENT_GET_SST_DONE 
            mUsimServiceTable = new UsimServiceTable(data);
            //End case EVENT_GET_SST_DONE 
            //Begin case EVENT_GET_SST_DONE 
            log("SST: " + mUsimServiceTable);
            //End case EVENT_GET_SST_DONE 
            //Begin case EVENT_GET_INFO_CPHS_DONE 
            isRecordLoadResponse = true;
            //End case EVENT_GET_INFO_CPHS_DONE 
            //Begin case EVENT_GET_INFO_CPHS_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_INFO_CPHS_DONE 
            //Begin case EVENT_GET_INFO_CPHS_DONE 
            mCphsInfo = (byte[])ar.result;
            //End case EVENT_GET_INFO_CPHS_DONE 
            //Begin case EVENT_GET_INFO_CPHS_DONE 
            log("iCPHS: " + IccUtils.bytesToHexString(mCphsInfo));
            //End case EVENT_GET_INFO_CPHS_DONE 
            //Begin case EVENT_SET_MBDN_DONE 
            isRecordLoadResponse = false;
            //End case EVENT_SET_MBDN_DONE 
            //Begin case EVENT_SET_MBDN_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_SET_MBDN_DONE 
            //Begin case EVENT_SET_MBDN_DONE 
            {
                voiceMailNum = newVoiceMailNum;
                voiceMailTag = newVoiceMailTag;
            } //End block
            //End case EVENT_SET_MBDN_DONE 
            //Begin case EVENT_SET_MBDN_DONE 
            {
                boolean varDB6C50FA3E4BE068EAA8443655261A1E_1303273223 = (isCphsMailboxEnabled());
                {
                    adn = new AdnRecord(voiceMailTag, voiceMailNum);
                    Message onCphsCompleted;
                    onCphsCompleted = (Message) ar.userObj;
                    {
                        AsyncResult.forMessage(((Message) ar.userObj)).exception
                                = null;
                        ((Message) ar.userObj).sendToTarget();
                        log("Callback with MBDN successful.");
                        onCphsCompleted = null;
                    } //End block
                    new AdnRecordLoader(phone).
                            updateEF(adn, EF_MAILBOX_CPHS, EF_EXT1, 1, null,
                            obtainMessage(EVENT_SET_CPHS_MAILBOX_DONE,
                                    onCphsCompleted));
                } //End block
                {
                    {
                        AsyncResult.forMessage(((Message) ar.userObj)).exception
                                = ar.exception;
                        ((Message) ar.userObj).sendToTarget();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            //End case EVENT_SET_MBDN_DONE 
            //Begin case EVENT_SET_CPHS_MAILBOX_DONE 
            isRecordLoadResponse = false;
            //End case EVENT_SET_CPHS_MAILBOX_DONE 
            //Begin case EVENT_SET_CPHS_MAILBOX_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_SET_CPHS_MAILBOX_DONE 
            //Begin case EVENT_SET_CPHS_MAILBOX_DONE 
            {
                voiceMailNum = newVoiceMailNum;
                voiceMailTag = newVoiceMailTag;
            } //End block
            {
                log("Set CPHS MailBox with exception: "
                            + ar.exception);
            } //End block
            //End case EVENT_SET_CPHS_MAILBOX_DONE 
            //Begin case EVENT_SET_CPHS_MAILBOX_DONE 
            {
                log("Callback with CPHS MB successful.");
                AsyncResult.forMessage(((Message) ar.userObj)).exception
                            = ar.exception;
                ((Message) ar.userObj).sendToTarget();
            } //End block
            //End case EVENT_SET_CPHS_MAILBOX_DONE 
            //Begin case EVENT_SIM_REFRESH 
            isRecordLoadResponse = false;
            //End case EVENT_SIM_REFRESH 
            //Begin case EVENT_SIM_REFRESH 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_SIM_REFRESH 
            //Begin case EVENT_SIM_REFRESH 
            log("Sim REFRESH with exception: " + ar.exception);
            //End case EVENT_SIM_REFRESH 
            //Begin case EVENT_SIM_REFRESH 
            {
                handleSimRefresh((int[])(ar.result));
            } //End block
            //End case EVENT_SIM_REFRESH 
            //Begin case EVENT_GET_CFIS_DONE 
            isRecordLoadResponse = true;
            //End case EVENT_GET_CFIS_DONE 
            //Begin case EVENT_GET_CFIS_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_CFIS_DONE 
            //Begin case EVENT_GET_CFIS_DONE 
            data = (byte[])ar.result;
            //End case EVENT_GET_CFIS_DONE 
            //Begin case EVENT_GET_CFIS_DONE 
            Log.d(LOG_TAG, "EF_CFIS: " +
                   IccUtils.bytesToHexString(data));
            //End case EVENT_GET_CFIS_DONE 
            //Begin case EVENT_GET_CFIS_DONE 
            mEfCfis = data;
            //End case EVENT_GET_CFIS_DONE 
            //Begin case EVENT_GET_CFIS_DONE 
            callForwardingEnabled = ((data[1] & 0x01) != 0);
            //End case EVENT_GET_CFIS_DONE 
            //Begin case EVENT_GET_CFIS_DONE 
            phone.notifyCallForwardingIndicator();
            //End case EVENT_GET_CFIS_DONE 
            //Begin case EVENT_GET_CSP_CPHS_DONE 
            isRecordLoadResponse = true;
            //End case EVENT_GET_CSP_CPHS_DONE 
            //Begin case EVENT_GET_CSP_CPHS_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_CSP_CPHS_DONE 
            //Begin case EVENT_GET_CSP_CPHS_DONE 
            data = (byte[])ar.result;
            //End case EVENT_GET_CSP_CPHS_DONE 
            //Begin case EVENT_GET_CSP_CPHS_DONE 
            handleEfCspData(data);
            //End case EVENT_GET_CSP_CPHS_DONE 
            //Begin case default 
            super.handleMessage(msg);
            //End case default 
        } //End block
        catch (RuntimeException exc)
        { }
        finally 
        {
            {
                onRecordLoaded();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.777 -0400", hash_original_method = "E530DF481CB4FAA0037A4FE4ABD87373", hash_generated_method = "CDE69C80EB4E54942D0E7B8D65EE533D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleFileUpdate(int efid) {
        dsTaint.addTaint(efid);
        //Begin case EF_MBDN 
        new AdnRecordLoader(phone).loadFromEF(EF_MBDN, EF_EXT6,
                        mailboxIndex, obtainMessage(EVENT_GET_MBDN_DONE));
        //End case EF_MBDN 
        //Begin case EF_MAILBOX_CPHS 
        new AdnRecordLoader(phone).loadFromEF(EF_MAILBOX_CPHS, EF_EXT1,
                        1, obtainMessage(EVENT_GET_CPHS_MAILBOX_DONE));
        //End case EF_MAILBOX_CPHS 
        //Begin case EF_CSP_CPHS 
        phone.getIccFileHandler().loadEFTransparent(EF_CSP_CPHS,
                        obtainMessage(EVENT_GET_CSP_CPHS_DONE));
        //End case EF_CSP_CPHS 
        //Begin case default 
        adnCache.reset();
        //End case default 
        //Begin case default 
        fetchSimRecords();
        //End case default 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.777 -0400", hash_original_method = "CBD0F454D52453FACC84E0D26FD9E162", hash_generated_method = "C1B1381059692D4DE542F4CC891949A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleSimRefresh(int[] result) {
        dsTaint.addTaint(result[0]);
        {
            log("handleSimRefresh without input");
        } //End block
        //Begin case CommandsInterface.SIM_REFRESH_FILE_UPDATED 
        log("handleSimRefresh with SIM_REFRESH_FILE_UPDATED");
        //End case CommandsInterface.SIM_REFRESH_FILE_UPDATED 
        //Begin case CommandsInterface.SIM_REFRESH_FILE_UPDATED 
        int efid;
        efid = result[1];
        //End case CommandsInterface.SIM_REFRESH_FILE_UPDATED 
        //Begin case CommandsInterface.SIM_REFRESH_FILE_UPDATED 
        handleFileUpdate(efid);
        //End case CommandsInterface.SIM_REFRESH_FILE_UPDATED 
        //Begin case CommandsInterface.SIM_REFRESH_INIT 
        log("handleSimRefresh with SIM_REFRESH_INIT");
        //End case CommandsInterface.SIM_REFRESH_INIT 
        //Begin case CommandsInterface.SIM_REFRESH_INIT 
        adnCache.reset();
        //End case CommandsInterface.SIM_REFRESH_INIT 
        //Begin case CommandsInterface.SIM_REFRESH_INIT 
        fetchSimRecords();
        //End case CommandsInterface.SIM_REFRESH_INIT 
        //Begin case CommandsInterface.SIM_REFRESH_RESET 
        log("handleSimRefresh with SIM_REFRESH_RESET");
        //End case CommandsInterface.SIM_REFRESH_RESET 
        //Begin case CommandsInterface.SIM_REFRESH_RESET 
        phone.mCM.setRadioPower(false, null);
        //End case CommandsInterface.SIM_REFRESH_RESET 
        //Begin case default 
        log("handleSimRefresh with unknown operation");
        //End case default 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.777 -0400", hash_original_method = "0F425E7BAA03121C5111F3872E01B168", hash_generated_method = "8BF8B14F498B51A393BE66079A1C812F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int dispatchGsmMessage(SmsMessageBase message) {
        dsTaint.addTaint(message.dsTaint);
        int varA522FA72751E3B8CCDC974402CB11ED3_232132545 = (phone.mSMS.dispatchMessage(message));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return phone.mSMS.dispatchMessage(message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.778 -0400", hash_original_method = "3974DFF11A620863F24401AEED15BD51", hash_generated_method = "045CB1E366012E773F61B2651ADE2D08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleSms(byte[] ba) {
        dsTaint.addTaint(ba[0]);
        Log.d("ENF", "status : " + ba[0]);
        {
            int n;
            n = ba.length;
            byte[] pdu;
            pdu = new byte[n - 1];
            System.arraycopy(ba, 1, pdu, 0, n - 1);
            SmsMessage message;
            message = SmsMessage.createFromPdu(pdu);
            dispatchGsmMessage(message);
        } //End block
        // ---------- Original Method ----------
        //if (ba[0] != 0)
            //Log.d("ENF", "status : " + ba[0]);
        //if (ba[0] == 3) {
            //int n = ba.length;
            //byte[] pdu = new byte[n - 1];
            //System.arraycopy(ba, 1, pdu, 0, n - 1);
            //SmsMessage message = SmsMessage.createFromPdu(pdu);
            //dispatchGsmMessage(message);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.778 -0400", hash_original_method = "AAB2EB039B628CD9C66D57B4359C7EA6", hash_generated_method = "C995BE7C91EDDCEC7925B1167DE273CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleSmses(ArrayList messages) {
        dsTaint.addTaint(messages.dsTaint);
        int count;
        count = messages.size();
        {
            int i;
            i = 0;
            {
                byte[] ba;
                ba = (byte[]) messages.get(i);
                {
                    int n;
                    n = ba.length;
                    byte[] pdu;
                    pdu = new byte[n - 1];
                    System.arraycopy(ba, 1, pdu, 0, n - 1);
                    SmsMessage message;
                    message = SmsMessage.createFromPdu(pdu);
                    dispatchGsmMessage(message);
                    ba[0] = 1;
                    {
                        phone.getIccFileHandler().updateEFLinearFixed(EF_SMS,
                            i, ba, null, obtainMessage(EVENT_MARK_SMS_READ_DONE, i));
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.778 -0400", hash_original_method = "2DE8400081AD5D0DFDE4A5A335B40E41", hash_generated_method = "15D741D51610FD01EF0C6B9D8351E8E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onRecordLoaded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        recordsToLoad -= 1;
        {
            onAllRecordsLoaded();
        } //End block
        {
            recordsToLoad = 0;
        } //End block
        // ---------- Original Method ----------
        //recordsToLoad -= 1;
        //if (recordsToLoad == 0 && recordsRequested == true) {
            //onAllRecordsLoaded();
        //} else if (recordsToLoad < 0) {
            //Log.e(LOG_TAG, "SIMRecords: recordsToLoad <0, programmer error suspected");
            //recordsToLoad = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.779 -0400", hash_original_method = "66CB4A941BE4FC702CDC8E50BFF0F26C", hash_generated_method = "D90773C7A1418372C2757D5F6B4C90D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onAllRecordsLoaded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Log.d(LOG_TAG, "SIMRecords: record load complete");
        String operator;
        operator = getOperatorNumeric();
        phone.setSystemProperty(PROPERTY_ICC_OPERATOR_NUMERIC, operator);
        {
            phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ISO_COUNTRY,
                    MccTable.countryCodeForMcc(Integer.parseInt(imsi.substring(0,3))));
        } //End block
        setVoiceMailByCountry(operator);
        setSpnFromConfig(operator);
        recordsLoadedRegistrants.notifyRegistrants(
            new AsyncResult(null, null, null));
        phone.mIccCard.broadcastIccStateChangedIntent(
                SimCard.INTENT_VALUE_ICC_LOADED, null);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "SIMRecords: record load complete");
        //String operator = getOperatorNumeric();
        //phone.setSystemProperty(PROPERTY_ICC_OPERATOR_NUMERIC, operator);
        //if (imsi != null) {
            //phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ISO_COUNTRY,
                    //MccTable.countryCodeForMcc(Integer.parseInt(imsi.substring(0,3))));
        //}
        //else {
            //Log.e("SIM", "[SIMRecords] onAllRecordsLoaded: imsi is NULL!");
        //}
        //setVoiceMailByCountry(operator);
        //setSpnFromConfig(operator);
        //recordsLoadedRegistrants.notifyRegistrants(
            //new AsyncResult(null, null, null));
        //phone.mIccCard.broadcastIccStateChangedIntent(
                //SimCard.INTENT_VALUE_ICC_LOADED, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.780 -0400", hash_original_method = "F5FC22B4152F67EB826E6610A6C9072B", hash_generated_method = "0F5DC54691D00A482157B0CEC1887CDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setSpnFromConfig(String carrier) {
        dsTaint.addTaint(carrier);
        {
            boolean var421905470EB904055FD073228F381009_1962766709 = (mSpnOverride.containsCarrier(carrier));
            {
                spn = mSpnOverride.getSpn(carrier);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mSpnOverride.containsCarrier(carrier)) {
            //spn = mSpnOverride.getSpn(carrier);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.780 -0400", hash_original_method = "0A1C3646AC6E538340751C4EFB011D4A", hash_generated_method = "E6A44864F8EA05141D10EAE923FDE308")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setVoiceMailByCountry(String spn) {
        dsTaint.addTaint(spn);
        {
            boolean var78FA3AAD64E283DFCBDA5E9AF5AFA96F_1877092651 = (mVmConfig.containsCarrier(spn));
            {
                isVoiceMailFixed = true;
                voiceMailNum = mVmConfig.getVoiceMailNumber(spn);
                voiceMailTag = mVmConfig.getVoiceMailTag(spn);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mVmConfig.containsCarrier(spn)) {
            //isVoiceMailFixed = true;
            //voiceMailNum = mVmConfig.getVoiceMailNumber(spn);
            //voiceMailTag = mVmConfig.getVoiceMailTag(spn);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.781 -0400", hash_original_method = "9A96815ED791357C0C0DD55806DDDE67", hash_generated_method = "F27FE7CD305FE9A5DC0CE32EB9377D86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onSimReady() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        phone.mIccCard.broadcastIccStateChangedIntent(
                SimCard.INTENT_VALUE_ICC_READY, null);
        fetchSimRecords();
        // ---------- Original Method ----------
        //phone.mIccCard.broadcastIccStateChangedIntent(
                //SimCard.INTENT_VALUE_ICC_READY, null);
        //fetchSimRecords();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.781 -0400", hash_original_method = "267620266787F01EC9F0E5E0AE15B613", hash_generated_method = "E89C138DE28C99B785301355932F0F70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void fetchSimRecords() {
        recordsRequested = true;
        IccFileHandler iccFh;
        iccFh = phone.getIccFileHandler();
        phone.mCM.getIMSI(obtainMessage(EVENT_GET_IMSI_DONE));
        iccFh.loadEFTransparent(EF_ICCID, obtainMessage(EVENT_GET_ICCID_DONE));
        new AdnRecordLoader(phone).loadFromEF(EF_MSISDN, EF_EXT1, 1,
                    obtainMessage(EVENT_GET_MSISDN_DONE));
        iccFh.loadEFLinearFixed(EF_MBI, 1, obtainMessage(EVENT_GET_MBI_DONE));
        iccFh.loadEFTransparent(EF_AD, obtainMessage(EVENT_GET_AD_DONE));
        iccFh.loadEFLinearFixed(EF_MWIS, 1, obtainMessage(EVENT_GET_MWIS_DONE));
        iccFh.loadEFTransparent(
                EF_VOICE_MAIL_INDICATOR_CPHS,
                obtainMessage(EVENT_GET_VOICE_MAIL_INDICATOR_CPHS_DONE));
        iccFh.loadEFLinearFixed(EF_CFIS, 1, obtainMessage(EVENT_GET_CFIS_DONE));
        iccFh.loadEFTransparent(EF_CFF_CPHS, obtainMessage(EVENT_GET_CFF_DONE));
        getSpnFsm(true, null);
        iccFh.loadEFTransparent(EF_SPDI, obtainMessage(EVENT_GET_SPDI_DONE));
        iccFh.loadEFLinearFixed(EF_PNN, 1, obtainMessage(EVENT_GET_PNN_DONE));
        iccFh.loadEFTransparent(EF_SST, obtainMessage(EVENT_GET_SST_DONE));
        iccFh.loadEFTransparent(EF_INFO_CPHS, obtainMessage(EVENT_GET_INFO_CPHS_DONE));
        iccFh.loadEFTransparent(EF_CSP_CPHS,obtainMessage(EVENT_GET_CSP_CPHS_DONE));
        {
            iccFh.loadEFLinearFixedAll(EF_SMS, obtainMessage(EVENT_GET_ALL_SMS_DONE));
        } //End block
        {
            String sms;
            sms = "0107912160130310f20404d0110041007030208054832b0120"
                         + "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
                         + "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
                         + "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
                         + "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
                         + "ffffffffffffffffffffffffffffff";
            byte[] ba;
            ba = IccUtils.hexStringToBytes(sms);
            iccFh.updateEFLinearFixed(EF_SMS, 1, ba, null,
                            obtainMessage(EVENT_MARK_SMS_READ_DONE, 1));
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.783 -0400", hash_original_method = "409DDAA47064BEED68B0319934A64CD2", hash_generated_method = "E635442F14BCC95DAAEE0103BCFDC980")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getDisplayRule(String plmn) {
        dsTaint.addTaint(plmn);
        int rule;
        {
            rule = SPN_RULE_SHOW_PLMN;
        } //End block
        {
            boolean var93D8A656618E8CC215C13DA82B4B7F6B_1928099338 = (isOnMatchingPlmn(plmn));
            {
                rule = SPN_RULE_SHOW_SPN;
                {
                    rule |= SPN_RULE_SHOW_PLMN;
                } //End block
            } //End block
            {
                rule = SPN_RULE_SHOW_PLMN;
                {
                    rule |= SPN_RULE_SHOW_SPN;
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int rule;
        //if (spn == null || spnDisplayCondition == -1) {
            //rule = SPN_RULE_SHOW_PLMN;
        //} else if (isOnMatchingPlmn(plmn)) {
            //rule = SPN_RULE_SHOW_SPN;
            //if ((spnDisplayCondition & 0x01) == 0x01) {
                //rule |= SPN_RULE_SHOW_PLMN;
            //}
        //} else {
            //rule = SPN_RULE_SHOW_PLMN;
            //if ((spnDisplayCondition & 0x02) == 0x00) {
                //rule |= SPN_RULE_SHOW_SPN;
            //}
        //}
        //return rule;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.789 -0400", hash_original_method = "94EB8BB16DAD2AA5FAF871DB9935C4E1", hash_generated_method = "1331167E419EDBAF2F2D0C9D24275498")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isOnMatchingPlmn(String plmn) {
        dsTaint.addTaint(plmn);
        {
            boolean var0FF98638333814881B939E2E997568A8_1178145902 = (plmn.equals(getOperatorNumeric()));
        } //End collapsed parenthetic
        {
            {
                Iterator<String> var2DB1354A1A9DE1AE97AA82A80F522F26_1027002414 = (spdiNetworks).iterator();
                var2DB1354A1A9DE1AE97AA82A80F522F26_1027002414.hasNext();
                String spdiNet = var2DB1354A1A9DE1AE97AA82A80F522F26_1027002414.next();
                {
                    {
                        boolean var41CE6775E09518F8198A5D804233075F_1976371886 = (plmn.equals(spdiNet));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (plmn == null) return false;
        //if (plmn.equals(getOperatorNumeric())) {
            //return true;
        //}
        //if (spdiNetworks != null) {
            //for (String spdiNet : spdiNetworks) {
                //if (plmn.equals(spdiNet)) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.790 -0400", hash_original_method = "CF95CAB3FC09F3005867C57538604F5A", hash_generated_method = "0355EF3368EC1FEC75A72551AA20A3FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void getSpnFsm(boolean start, AsyncResult ar) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(ar.dsTaint);
        byte[] data;
        {
            spnState = Get_Spn_Fsm_State.INIT;
        } //End block
        //Begin case INIT 
        spn = null;
        //End case INIT 
        //Begin case INIT 
        phone.getIccFileHandler().loadEFTransparent( EF_SPN,
                        obtainMessage(EVENT_GET_SPN_DONE));
        //End case INIT 
        //Begin case INIT 
        spnState = Get_Spn_Fsm_State.READ_SPN_3GPP;
        //End case INIT 
        //Begin case READ_SPN_3GPP 
        {
            data = (byte[]) ar.result;
            spnDisplayCondition = 0xff & data[0];
            spn = IccUtils.adnStringFieldToString(data, 1, data.length - 1);
            log("Load EF_SPN: " + spn
                            + " spnDisplayCondition: " + spnDisplayCondition);
            phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ALPHA, spn);
            spnState = Get_Spn_Fsm_State.IDLE;
        } //End block
        {
            phone.getIccFileHandler().loadEFTransparent( EF_SPN_CPHS,
                            obtainMessage(EVENT_GET_SPN_DONE));
            spnState = Get_Spn_Fsm_State.READ_SPN_CPHS;
            spnDisplayCondition = -1;
        } //End block
        //End case READ_SPN_3GPP 
        //Begin case READ_SPN_CPHS 
        {
            data = (byte[]) ar.result;
            spn = IccUtils.adnStringFieldToString(
                            data, 0, data.length - 1 );
            log("Load EF_SPN_CPHS: " + spn);
            phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ALPHA, spn);
            spnState = Get_Spn_Fsm_State.IDLE;
        } //End block
        {
            phone.getIccFileHandler().loadEFTransparent(
                            EF_SPN_SHORT_CPHS, obtainMessage(EVENT_GET_SPN_DONE));
            spnState = Get_Spn_Fsm_State.READ_SPN_SHORT_CPHS;
        } //End block
        //End case READ_SPN_CPHS 
        //Begin case READ_SPN_SHORT_CPHS 
        {
            data = (byte[]) ar.result;
            spn = IccUtils.adnStringFieldToString(
                            data, 0, data.length - 1);
            log("Load EF_SPN_SHORT_CPHS: " + spn);
            phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ALPHA, spn);
        } //End block
        {
            log("No SPN loaded in either CHPS or 3GPP");
        } //End block
        //End case READ_SPN_SHORT_CPHS 
        //Begin case READ_SPN_SHORT_CPHS 
        spnState = Get_Spn_Fsm_State.IDLE;
        //End case READ_SPN_SHORT_CPHS 
        //Begin case default 
        spnState = Get_Spn_Fsm_State.IDLE;
        //End case default 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.790 -0400", hash_original_method = "2AE095A71557CBF993C4F4933FD42467", hash_generated_method = "3C859C52F1A77FBFB09E05D282422146")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseEfSpdi(byte[] data) {
        dsTaint.addTaint(data[0]);
        SimTlv tlv;
        tlv = new SimTlv(data, 0, data.length);
        byte[] plmnEntries;
        plmnEntries = null;
        {
            boolean varD6DAE705252AE64CA27B233F668D159C_259558667 = (tlv.isValidObject());
            tlv.nextObject();
            {
                {
                    boolean var06676F894B0CE0AFE5FFB22891957C33_356329835 = (tlv.getTag() == TAG_SPDI);
                    {
                        tlv = new SimTlv(tlv.getData(), 0, tlv.getData().length);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var737E9541DB57851299264A8B92818535_1147317549 = (tlv.getTag() == TAG_SPDI_PLMN_LIST);
                    {
                        plmnEntries = tlv.getData();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        spdiNetworks = new ArrayList<String>(plmnEntries.length / 3);
        {
            int i;
            i = 0;
            i += 3;
            {
                String plmnCode;
                plmnCode = IccUtils.bcdToString(plmnEntries, i, 3);
                {
                    boolean var2A08EE5A8A72F3C48E7EDA0361A465D4_940422803 = (plmnCode.length() >= 5);
                    {
                        log("EF_SPDI network: " + plmnCode);
                        spdiNetworks.add(plmnCode);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.791 -0400", hash_original_method = "3EE42FFEB0B4A779D022FF2A029DBC31", hash_generated_method = "D2F20606E3F67548B2D330B56442430F")
    @DSModeled(DSC.SAFE)
    private boolean isCphsMailboxEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mCphsInfo == null)  return false;
        //return ((mCphsInfo[1] & CPHS_SST_MBN_MASK) == CPHS_SST_MBN_ENABLED );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.791 -0400", hash_original_method = "A8BE9816664C9DE6B42ACDFC7DA8D2D5", hash_generated_method = "9414F9217A22A101729458EF9BAADBC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void log(String s) {
        dsTaint.addTaint(s);
        Log.d(LOG_TAG, "[SIMRecords] " + s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[SIMRecords] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.791 -0400", hash_original_method = "747DCE9A0C1CA0D85263EB0A5CECAE60", hash_generated_method = "AAD830E7CFC152901321526ABE7CA35A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void loge(String s) {
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SIMRecords] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.791 -0400", hash_original_method = "545A7868DCB44F353BBAB91C69F027BF", hash_generated_method = "923D8621150D8C8AC401D3C80D38255B")
    @DSModeled(DSC.SAFE)
    public boolean isCspPlmnEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCspPlmnEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.791 -0400", hash_original_method = "5509D297F6B8CC0BD321C284BD8D086E", hash_generated_method = "6222317FACFB157B2EC56E26448FCE80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleEfCspData(byte[] data) {
        dsTaint.addTaint(data[0]);
        int usedCspGroups;
        usedCspGroups = data.length / 2;
        byte valueAddedServicesGroup;
        valueAddedServicesGroup = (byte)0xC0;
        mCspPlmnEnabled = true;
        {
            int i;
            i = 0;
            {
                {
                    {
                        mCspPlmnEnabled = true;
                    } //End block
                    {
                        mCspPlmnEnabled = false;
                        phone.setNetworkSelectionModeAutomatic(null);
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private enum Get_Spn_Fsm_State {
        IDLE,               
        INIT,               
        READ_SPN_3GPP,      
        READ_SPN_CPHS,      
        READ_SPN_SHORT_CPHS 
    }

    
    protected static final String LOG_TAG = "GSM";
    private static final boolean CRASH_RIL = false;
    protected static final boolean DBG = true;
    static final int SPN_RULE_SHOW_SPN  = 0x01;
    static final int SPN_RULE_SHOW_PLMN = 0x02;
    static final int TAG_SPDI = 0xA3;
    static final int TAG_SPDI_PLMN_LIST = 0x80;
    static final int TAG_FULL_NETWORK_NAME = 0x43;
    static final int TAG_SHORT_NETWORK_NAME = 0x45;
    static final int CFF_UNCONDITIONAL_ACTIVE = 0x0a;
    static final int CFF_UNCONDITIONAL_DEACTIVE = 0x05;
    static final int CFF_LINE1_MASK = 0x0f;
    static final int CFF_LINE1_RESET = 0xf0;
    private static final int CPHS_SST_MBN_MASK = 0x30;
    private static final int CPHS_SST_MBN_ENABLED = 0x30;
    private static final int EVENT_SIM_READY = 1;
    private static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = 2;
    protected static final int EVENT_GET_IMSI_DONE = 3;
    protected static final int EVENT_GET_ICCID_DONE = 4;
    private static final int EVENT_GET_MBI_DONE = 5;
    private static final int EVENT_GET_MBDN_DONE = 6;
    private static final int EVENT_GET_MWIS_DONE = 7;
    private static final int EVENT_GET_VOICE_MAIL_INDICATOR_CPHS_DONE = 8;
    protected static final int EVENT_GET_AD_DONE = 9;
    protected static final int EVENT_GET_MSISDN_DONE = 10;
    private static final int EVENT_GET_CPHS_MAILBOX_DONE = 11;
    private static final int EVENT_GET_SPN_DONE = 12;
    private static final int EVENT_GET_SPDI_DONE = 13;
    private static final int EVENT_UPDATE_DONE = 14;
    private static final int EVENT_GET_PNN_DONE = 15;
    protected static final int EVENT_GET_SST_DONE = 17;
    private static final int EVENT_GET_ALL_SMS_DONE = 18;
    private static final int EVENT_MARK_SMS_READ_DONE = 19;
    private static final int EVENT_SET_MBDN_DONE = 20;
    private static final int EVENT_SMS_ON_SIM = 21;
    private static final int EVENT_GET_SMS_DONE = 22;
    private static final int EVENT_GET_CFF_DONE = 24;
    private static final int EVENT_SET_CPHS_MAILBOX_DONE = 25;
    private static final int EVENT_GET_INFO_CPHS_DONE = 26;
    private static final int EVENT_SET_MSISDN_DONE = 30;
    private static final int EVENT_SIM_REFRESH = 31;
    private static final int EVENT_GET_CFIS_DONE = 32;
    private static final int EVENT_GET_CSP_CPHS_DONE = 33;
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
}

