package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.498 -0400", hash_original_field = "A6D54253A6E7A5BF5CFC7DB47F269D57", hash_generated_field = "3D45F4DC7928ADFBE49F3906732C5FDD")

    VoiceMailConstants mVmConfig;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.498 -0400", hash_original_field = "E040FD05576717C9CA830E49D86F56E5", hash_generated_field = "1D5FAB34B5B1DFA2FF0C72EB8EB1417D")

    SpnOverride mSpnOverride;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.498 -0400", hash_original_field = "2A3E692FB30211EBAAAF0E3BF2F7B04D", hash_generated_field = "C8FB6D75F33BBB165F89E1184AF1DAB5")

    private String imsi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.498 -0400", hash_original_field = "D3724EA3C1583660418AAE7549D15B6B", hash_generated_field = "F3670A331578D3C800D2A8879CDAE6A2")

    private boolean callForwardingEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.498 -0400", hash_original_field = "7A58A9F6FCDF3B6856A0262D5FF72428", hash_generated_field = "71EE1DCA9A91F37B8070C2DE70EBC3CC")

    private Get_Spn_Fsm_State spnState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.498 -0400", hash_original_field = "CC93CCB29A5FE37184AD950A48100507", hash_generated_field = "B94C656CABFD2A097CE8CA776F9B3D25")

    private byte[] mCphsInfo = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.499 -0400", hash_original_field = "1D3682655094CF36E1E3298A4C25ED91", hash_generated_field = "3B0DBAF5E1453033DE8A23FEF66CB6CF")

    boolean mCspPlmnEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.499 -0400", hash_original_field = "D2C36B26FA6DBE28216F0234CF7213CA", hash_generated_field = "531BEBDA8DE453FA3ED736DAC070C337")

    byte[] efMWIS = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.499 -0400", hash_original_field = "95FFAD26D850D5EC0F2B1F6AAE5CD8CE", hash_generated_field = "F7BA255CC3AE0058E8CFC095600F245B")

    byte[] efCPHS_MWI = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.499 -0400", hash_original_field = "58264A603FE1A26D9B3DD780DF8AAC91", hash_generated_field = "27C9B421032889367442E38FD625EA3E")

    byte[] mEfCff = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.499 -0400", hash_original_field = "D6E9B336B4F61EEF8DC3ED94B6E2429B", hash_generated_field = "4CFC3799ACD516937F814E469F055B3D")

    byte[] mEfCfis = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.499 -0400", hash_original_field = "6E8DE6542D284DA95B6DF2FA3E03574A", hash_generated_field = "677DC81727BE9252421E71F32EAE57E6")

    int spnDisplayCondition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.499 -0400", hash_original_field = "E2A1ABC58A408D18FA38B6BF738C77C8", hash_generated_field = "9CBD8D86B3B910D521D7CFC4F4B05AE6")

    ArrayList<String> spdiNetworks = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.499 -0400", hash_original_field = "C79C429F0ECF3DC640C19EFC7DA64CD0", hash_generated_field = "FC170B0C5C20481C238409EFCB48A036")

    String pnnHomeName = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.499 -0400", hash_original_field = "06F1EF4000599F31B6960C354731E5E3", hash_generated_field = "433C8C040DD36FD17B8409B23AF92316")

    UsimServiceTable mUsimServiceTable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.500 -0400", hash_original_method = "AA8710B4BBDFAECA42DF87898B5E71E9", hash_generated_method = "D005D82C1991AC0FAA07E39A19A0D741")
    public  SIMRecords(PhoneBase p) {
        super(p);
        addTaint(p.getTaint());
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.500 -0400", hash_original_method = "60B34C0CDC881E5C8D40C8AAD990557F", hash_generated_method = "3EA07F3E006CA7F93EFE786B4B31CD0A")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.500 -0400", hash_original_method = "D676C6F3D2367DC0A4942786FE826692", hash_generated_method = "35C5FCD8B031F81FC9AEB8B01B34AD1B")
    protected void finalize() {
    if(DBG)        
        Log.d(LOG_TAG, "SIMRecords finalized");
        // ---------- Original Method ----------
        //if(DBG) Log.d(LOG_TAG, "SIMRecords finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.502 -0400", hash_original_method = "1C495E4F05849546A87C14B5D6E64BED", hash_generated_method = "DFF28017DADF7D467DB4EC42F6547305")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.503 -0400", hash_original_method = "3D26DD60574339032566256F631F5DB8", hash_generated_method = "8F0B09BE495CA805214ED7DBABC48145")
    @Override
    public String getIMSI() {
String var7E6C08CD026D24533A35AD442337F3B6_1480098468 =         imsi;
        var7E6C08CD026D24533A35AD442337F3B6_1480098468.addTaint(taint);
        return var7E6C08CD026D24533A35AD442337F3B6_1480098468;
        // ---------- Original Method ----------
        //return imsi;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.503 -0400", hash_original_method = "9D42E73ED1AA846035EF94EBFAAEA8F6", hash_generated_method = "FD485CC9B7C1A235FC39025D3659A131")
    public String getMsisdnNumber() {
String var98EB500E04B2E653D67441C7876346A8_1436815686 =         msisdn;
        var98EB500E04B2E653D67441C7876346A8_1436815686.addTaint(taint);
        return var98EB500E04B2E653D67441C7876346A8_1436815686;
        // ---------- Original Method ----------
        //return msisdn;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.503 -0400", hash_original_method = "F96F62208A76C85F8691E193053EFC74", hash_generated_method = "F8CC020FC727E91A95AE46747D81FECC")
    @Override
    public UsimServiceTable getUsimServiceTable() {
UsimServiceTable varA1A437D900A7A3D6B8B13150EDD0F8C9_1291576203 =         mUsimServiceTable;
        varA1A437D900A7A3D6B8B13150EDD0F8C9_1291576203.addTaint(taint);
        return varA1A437D900A7A3D6B8B13150EDD0F8C9_1291576203;
        // ---------- Original Method ----------
        //return mUsimServiceTable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.504 -0400", hash_original_method = "7B16D051528D70BC1665C409BE0B92A5", hash_generated_method = "27A458BA8AC16390D605AD9FB84E1F07")
    public void setMsisdnNumber(String alphaTag, String number,
            Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(number.getTaint());
        addTaint(alphaTag.getTaint());
        msisdn = number;
        msisdnTag = alphaTag;
    if(DBG)        
        log("Set MSISDN: " + msisdnTag + " " +  "xxxxxxx");
        AdnRecord adn = new AdnRecord(msisdnTag, msisdn);
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.504 -0400", hash_original_method = "E32EFED28CC433860D178485CFB4EEE4", hash_generated_method = "4068CC2005B75DABF6FF256CECC2A6C4")
    public String getMsisdnAlphaTag() {
String varC96C703C1B21896256515C79C6D4E9E0_983564929 =         msisdnTag;
        varC96C703C1B21896256515C79C6D4E9E0_983564929.addTaint(taint);
        return varC96C703C1B21896256515C79C6D4E9E0_983564929;
        // ---------- Original Method ----------
        //return msisdnTag;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.505 -0400", hash_original_method = "77FFC0D98CD3CB2629C7F6A7D27E6FFF", hash_generated_method = "A54C094924C5A034F4286E40D5DDFA64")
    public String getVoiceMailNumber() {
String var44EE7E1B561BBC95B6BC657CD14BC65B_74948197 =         voiceMailNum;
        var44EE7E1B561BBC95B6BC657CD14BC65B_74948197.addTaint(taint);
        return var44EE7E1B561BBC95B6BC657CD14BC65B_74948197;
        // ---------- Original Method ----------
        //return voiceMailNum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.505 -0400", hash_original_method = "BBA59ED68AB83B35B5A29C09BCF3BE4C", hash_generated_method = "17681FBC023DB97D89703CF9D0EF4A38")
    public void setVoiceMailNumber(String alphaTag, String voiceNumber,
            Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(voiceNumber.getTaint());
        addTaint(alphaTag.getTaint());
    if(isVoiceMailFixed)        
        {
            AsyncResult.forMessage((onComplete)).exception =
                    new IccVmFixedException("Voicemail number is fixed by operator");
            onComplete.sendToTarget();
            return;
        } //End block
        newVoiceMailNum = voiceNumber;
        newVoiceMailTag = alphaTag;
        AdnRecord adn = new AdnRecord(newVoiceMailTag, newVoiceMailNum);
    if(mailboxIndex != 0 && mailboxIndex != 0xff)        
        {
            new AdnRecordLoader(phone).updateEF(adn, EF_MBDN, EF_EXT6,
                    mailboxIndex, null,
                    obtainMessage(EVENT_SET_MBDN_DONE, onComplete));
        } //End block
        else
    if(isCphsMailboxEnabled())        
        {
            new AdnRecordLoader(phone).updateEF(adn, EF_MAILBOX_CPHS,
                    EF_EXT1, 1, null,
                    obtainMessage(EVENT_SET_CPHS_MAILBOX_DONE, onComplete));
        } //End block
        else
        {
            AsyncResult.forMessage((onComplete)).exception =
                    new IccVmNotSupportedException("Update SIM voice mailbox error");
            onComplete.sendToTarget();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.506 -0400", hash_original_method = "5A91F4662DCD8CEE6B5E6A046B7A4ABC", hash_generated_method = "4CDE5AAFB54079079A4FC3F598E68F75")
    public String getVoiceMailAlphaTag() {
String var1EB462B75D8B935982B4AE1475F7B8DA_2023903571 =         voiceMailTag;
        var1EB462B75D8B935982B4AE1475F7B8DA_2023903571.addTaint(taint);
        return var1EB462B75D8B935982B4AE1475F7B8DA_2023903571;
        // ---------- Original Method ----------
        //return voiceMailTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.507 -0400", hash_original_method = "75BFE4AFE8A3A09F4E38976A214FAF70", hash_generated_method = "2F9886DEA462F59E525D19DF8EC79F6E")
    public void setVoiceMessageWaiting(int line, int countWaiting) {
        addTaint(line);
    if(line != 1)        
        {
            return;
        } //End block
    if(countWaiting < 0)        
        {
            countWaiting = -1;
        } //End block
        else
    if(countWaiting > 0xff)        
        {
            countWaiting = 0xff;
        } //End block
        countVoiceMessages = countWaiting;
        phone.notifyMessageWaitingIndicator();
        try 
        {
    if(efMWIS != null)            
            {
                efMWIS[0] = (byte)((efMWIS[0] & 0xfe)
                                    | (countVoiceMessages == 0 ? 0 : 1));
    if(countWaiting < 0)                
                {
                    efMWIS[1] = 0;
                } //End block
                else
                {
                    efMWIS[1] = (byte) countWaiting;
                } //End block
                phone.getIccFileHandler().updateEFLinearFixed(
                    EF_MWIS, 1, efMWIS, null,
                    obtainMessage (EVENT_UPDATE_DONE, EF_MWIS));
            } //End block
    if(efCPHS_MWI != null)            
            {
                efCPHS_MWI[0] = (byte)((efCPHS_MWI[0] & 0xf0)
                            | (countVoiceMessages == 0 ? 0x5 : 0xa));
                phone.getIccFileHandler().updateEFTransparent(
                    EF_VOICE_MAIL_INDICATOR_CPHS, efCPHS_MWI,
                    obtainMessage (EVENT_UPDATE_DONE, EF_VOICE_MAIL_INDICATOR_CPHS));
            } //End block
        } //End block
        catch (ArrayIndexOutOfBoundsException ex)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.508 -0400", hash_original_method = "2A8D94361FF074096EDCA291A7FA986D", hash_generated_method = "852B205E01DA66F0550F7EC54E1D7B33")
    @Override
    public boolean getVoiceCallForwardingFlag() {
        boolean varD3724EA3C1583660418AAE7549D15B6B_1996913794 = (callForwardingEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1810472580 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1810472580;
        // ---------- Original Method ----------
        //return callForwardingEnabled;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.509 -0400", hash_original_method = "141082A6B47AB008F9D1AEFE7E7266B0", hash_generated_method = "143CA58C7ACBB4AF31F06B668F7781D1")
    @Override
    public void setVoiceCallForwardingFlag(int line, boolean enable) {
        addTaint(line);
    if(line != 1)        
        return;
        callForwardingEnabled = enable;
        phone.notifyCallForwardingIndicator();
        try 
        {
    if(mEfCfis != null)            
            {
    if(enable)                
                {
                    mEfCfis[1] |= 1;
                } //End block
                else
                {
                    mEfCfis[1] &= 0xfe;
                } //End block
                phone.getIccFileHandler().updateEFLinearFixed(
                        EF_CFIS, 1, mEfCfis, null,
                        obtainMessage (EVENT_UPDATE_DONE, EF_CFIS));
            } //End block
    if(mEfCff != null)            
            {
    if(enable)                
                {
                    mEfCff[0] = (byte) ((mEfCff[0] & CFF_LINE1_RESET)
                            | CFF_UNCONDITIONAL_ACTIVE);
                } //End block
                else
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
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.509 -0400", hash_original_method = "3729AD4A21CE0EDB3800382FBE3F87EC", hash_generated_method = "FB2E11D8C5262225A0975154FE9E69F0")
    public void onRefresh(boolean fileChanged, int[] fileList) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(fileList[0]);
        addTaint(fileChanged);
    if(fileChanged)        
        {
            fetchSimRecords();
        } //End block
        // ---------- Original Method ----------
        //if (fileChanged) {
            //fetchSimRecords();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.509 -0400", hash_original_method = "7E03E5ED77A0C757F38448793B936037", hash_generated_method = "E5DA0E0A5D3210222B7060718D014A2D")
    @Override
    public String getOperatorNumeric() {
    if(imsi == null)        
        {
            Log.d(LOG_TAG, "getOperatorNumeric: IMSI == null");
String var540C13E9E156B687226421B24F2DF178_978032994 =             null;
            var540C13E9E156B687226421B24F2DF178_978032994.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_978032994;
        } //End block
    if(mncLength == UNINITIALIZED || mncLength == UNKNOWN)        
        {
            Log.d(LOG_TAG, "getSIMOperatorNumeric: bad mncLength");
String var540C13E9E156B687226421B24F2DF178_261278789 =             null;
            var540C13E9E156B687226421B24F2DF178_261278789.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_261278789;
        } //End block
String var0F857FEA33A34E9B69DCBF8027B96239_216261945 =         imsi.substring(0, 3 + mncLength);
        var0F857FEA33A34E9B69DCBF8027B96239_216261945.addTaint(taint);
        return var0F857FEA33A34E9B69DCBF8027B96239_216261945;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.522 -0400", hash_original_method = "5FA65278BC21B747191DBEA87B814DA9", hash_generated_method = "B4AAC3D957D41999A0BFF741F1A9D31B")
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        AsyncResult ar;
        AdnRecord adn;
        byte data[];
        boolean isRecordLoadResponse = false;
        try 
        {
switch(msg.what){
            case EVENT_SIM_READY:
            onSimReady();
            break;
            case EVENT_RADIO_OFF_OR_NOT_AVAILABLE:
            onRadioOffOrNotAvailable();
            break;
            case EVENT_GET_IMSI_DONE:
            isRecordLoadResponse = true;
            ar = (AsyncResult)msg.obj;
    if(ar.exception != null)            
            {
                break;
            } //End block
            imsi = (String) ar.result;
    if(imsi != null && (imsi.length() < 6 || imsi.length() > 15))            
            {
                imsi = null;
            } //End block
            Log.d(LOG_TAG, "IMSI: " +  "xxxxxxx");
    if(((mncLength == UNKNOWN) || (mncLength == 2)) &&
                        ((imsi != null) && (imsi.length() >= 6)))            
            {
                String mccmncCode = imsi.substring(0, 6);
for(String mccmnc : MCCMNC_CODES_HAVING_3DIGITS_MNC)
                {
    if(mccmnc.equals(mccmncCode))                    
                    {
                        mncLength = 3;
                        break;
                    } //End block
                } //End block
            } //End block
    if(mncLength == UNKNOWN)            
            {
                try 
                {
                    int mcc = Integer.parseInt(imsi.substring(0,3));
                    mncLength = MccTable.smallestDigitsMccForMnc(mcc);
                } //End block
                catch (NumberFormatException e)
                {
                    mncLength = UNKNOWN;
                } //End block
            } //End block
    if(mncLength != UNKNOWN && mncLength != UNINITIALIZED)            
            {
                MccTable.updateMccMncConfiguration(phone, imsi.substring(0, 3 + mncLength));
            } //End block
            phone.mIccCard.broadcastIccStateChangedIntent(
                        SimCard.INTENT_VALUE_ICC_IMSI, null);
            break;
            case EVENT_GET_MBI_DONE:
            boolean isValidMbdn;
            isRecordLoadResponse = true;
            ar = (AsyncResult)msg.obj;
            data = (byte[]) ar.result;
            isValidMbdn = false;
    if(ar.exception == null)            
            {
                Log.d(LOG_TAG, "EF_MBI: " +
                            IccUtils.bytesToHexString(data));
                mailboxIndex = (int)data[0] & 0xff;
    if(mailboxIndex != 0 && mailboxIndex != 0xff)                
                {
                    Log.d(LOG_TAG, "Got valid mailbox number for MBDN");
                    isValidMbdn = true;
                } //End block
            } //End block
            recordsToLoad += 1;
    if(isValidMbdn)            
            {
                new AdnRecordLoader(phone).loadFromEF(EF_MBDN, EF_EXT6,
                            mailboxIndex, obtainMessage(EVENT_GET_MBDN_DONE));
            } //End block
            else
            {
                new AdnRecordLoader(phone).loadFromEF(EF_MAILBOX_CPHS,
                            EF_EXT1, 1,
                            obtainMessage(EVENT_GET_CPHS_MAILBOX_DONE));
            } //End block
            break;
            case EVENT_GET_CPHS_MAILBOX_DONE:
            case EVENT_GET_MBDN_DONE:
            voiceMailNum = null;
            voiceMailTag = null;
            isRecordLoadResponse = true;
            ar = (AsyncResult)msg.obj;
    if(ar.exception != null)            
            {
                Log.d(LOG_TAG, "Invalid or missing EF"
                        + ((msg.what == EVENT_GET_CPHS_MAILBOX_DONE) ? "[MAILBOX]" : "[MBDN]"));
    if(msg.what == EVENT_GET_MBDN_DONE)                
                {
                    recordsToLoad += 1;
                    new AdnRecordLoader(phone).loadFromEF(
                                EF_MAILBOX_CPHS, EF_EXT1, 1,
                                obtainMessage(EVENT_GET_CPHS_MAILBOX_DONE));
                } //End block
                break;
            } //End block
            adn = (AdnRecord)ar.result;
            Log.d(LOG_TAG, "VM: " + adn +
                        ((msg.what == EVENT_GET_CPHS_MAILBOX_DONE) ? " EF[MAILBOX]" : " EF[MBDN]"));
    if(adn.isEmpty() && msg.what == EVENT_GET_MBDN_DONE)            
            {
                recordsToLoad += 1;
                new AdnRecordLoader(phone).loadFromEF(
                            EF_MAILBOX_CPHS, EF_EXT1, 1,
                            obtainMessage(EVENT_GET_CPHS_MAILBOX_DONE));
                break;
            } //End block
            voiceMailNum = adn.getNumber();
            voiceMailTag = adn.getAlphaTag();
            break;
            case EVENT_GET_MSISDN_DONE:
            isRecordLoadResponse = true;
            ar = (AsyncResult)msg.obj;
    if(ar.exception != null)            
            {
                Log.d(LOG_TAG, "Invalid or missing EF[MSISDN]");
                break;
            } //End block
            adn = (AdnRecord)ar.result;
            msisdn = adn.getNumber();
            msisdnTag = adn.getAlphaTag();
            Log.d(LOG_TAG, "MSISDN: " +  "xxxxxxx");
            break;
            case EVENT_SET_MSISDN_DONE:
            isRecordLoadResponse = false;
            ar = (AsyncResult)msg.obj;
    if(ar.userObj != null)            
            {
                AsyncResult.forMessage(((Message) ar.userObj)).exception
                            = ar.exception;
                ((Message) ar.userObj).sendToTarget();
            } //End block
            break;
            case EVENT_GET_MWIS_DONE:
            isRecordLoadResponse = true;
            ar = (AsyncResult)msg.obj;
            data = (byte[])ar.result;
    if(ar.exception != null)            
            {
                break;
            } //End block
            Log.d(LOG_TAG, "EF_MWIS: " +
                   IccUtils.bytesToHexString(data));
            efMWIS = data;
    if((data[0] & 0xff) == 0xff)            
            {
                Log.d(LOG_TAG, "SIMRecords: Uninitialized record MWIS");
                break;
            } //End block
            boolean voiceMailWaiting = ((data[0] & 0x01) != 0);
            countVoiceMessages = data[1] & 0xff;
    if(voiceMailWaiting && countVoiceMessages == 0)            
            {
                countVoiceMessages = -1;
            } //End block
            phone.notifyMessageWaitingIndicator();
            break;
            case EVENT_GET_VOICE_MAIL_INDICATOR_CPHS_DONE:
            isRecordLoadResponse = true;
            ar = (AsyncResult)msg.obj;
            data = (byte[])ar.result;
    if(ar.exception != null)            
            {
                break;
            } //End block
            efCPHS_MWI = data;
    if(efMWIS == null)            
            {
                int indicator = (int)(data[0] & 0xf);
    if(indicator == 0xA)                
                {
                    countVoiceMessages = -1;
                } //End block
                else
    if(indicator == 0x5)                
                {
                    countVoiceMessages = 0;
                } //End block
                phone.notifyMessageWaitingIndicator();
            } //End block
            break;
            case EVENT_GET_ICCID_DONE:
            isRecordLoadResponse = true;
            ar = (AsyncResult)msg.obj;
            data = (byte[])ar.result;
    if(ar.exception != null)            
            {
                break;
            } //End block
            iccid = IccUtils.bcdToString(data, 0, data.length);
            Log.d(LOG_TAG, "iccid: " + iccid);
            break;
            case EVENT_GET_AD_DONE:
            try 
            {
                isRecordLoadResponse = true;
                ar = (AsyncResult)msg.obj;
                data = (byte[])ar.result;
    if(ar.exception != null)                
                {
                    break;
                } //End block
                Log.d(LOG_TAG, "EF_AD: " +
                            IccUtils.bytesToHexString(data));
    if(data.length < 3)                
                {
                    Log.d(LOG_TAG, "SIMRecords: Corrupt AD data on SIM");
                    break;
                } //End block
    if(data.length == 3)                
                {
                    Log.d(LOG_TAG, "SIMRecords: MNC length not present in EF_AD");
                    break;
                } //End block
                mncLength = (int)data[3] & 0xf;
    if(mncLength == 0xf)                
                {
                    mncLength = UNKNOWN;
                } //End block
            } //End block
            finally 
            {
    if(((mncLength == UNINITIALIZED) || (mncLength == UNKNOWN) ||
                            (mncLength == 2)) && ((imsi != null) && (imsi.length() >= 6)))                
                {
                    String mccmncCode = imsi.substring(0, 6);
for(String mccmnc : MCCMNC_CODES_HAVING_3DIGITS_MNC)
                    {
    if(mccmnc.equals(mccmncCode))                        
                        {
                            mncLength = 3;
                            break;
                        } //End block
                    } //End block
                } //End block
    if(mncLength == UNKNOWN || mncLength == UNINITIALIZED)                
                {
    if(imsi != null)                    
                    {
                        try 
                        {
                            int mcc = Integer.parseInt(imsi.substring(0,3));
                            mncLength = MccTable.smallestDigitsMccForMnc(mcc);
                        } //End block
                        catch (NumberFormatException e)
                        {
                            mncLength = UNKNOWN;
                        } //End block
                    } //End block
                    else
                    {
                        mncLength = UNKNOWN;
                        Log.d(LOG_TAG, "SIMRecords: MNC length not present in EF_AD");
                    } //End block
                } //End block
    if(imsi != null && mncLength != UNKNOWN)                
                {
                    MccTable.updateMccMncConfiguration(phone, imsi.substring(0, 3 + mncLength));
                } //End block
            } //End block
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
    if(ar.exception != null)            
            {
                break;
            } //End block
            Log.d(LOG_TAG, "EF_CFF_CPHS: " +
                        IccUtils.bytesToHexString(data));
            mEfCff = data;
    if(mEfCfis == null)            
            {
                callForwardingEnabled =
                        ((data[0] & CFF_LINE1_MASK) == CFF_UNCONDITIONAL_ACTIVE);
                phone.notifyCallForwardingIndicator();
            } //End block
            break;
            case EVENT_GET_SPDI_DONE:
            isRecordLoadResponse = true;
            ar = (AsyncResult)msg.obj;
            data = (byte[])ar.result;
    if(ar.exception != null)            
            {
                break;
            } //End block
            parseEfSpdi(data);
            break;
            case EVENT_UPDATE_DONE:
            ar = (AsyncResult)msg.obj;
    if(ar.exception != null)            
            {
            } //End block
            break;
            case EVENT_GET_PNN_DONE:
            isRecordLoadResponse = true;
            ar = (AsyncResult)msg.obj;
            data = (byte[])ar.result;
    if(ar.exception != null)            
            {
                break;
            } //End block
            SimTlv tlv = new SimTlv(data, 0, data.length);
for(;tlv.isValidObject();tlv.nextObject())
            {
    if(tlv.getTag() == TAG_FULL_NETWORK_NAME)                
                {
                    pnnHomeName
                            = IccUtils.networkNameToString(
                                tlv.getData(), 0, tlv.getData().length);
                    break;
                } //End block
            } //End block
            break;
            case EVENT_GET_ALL_SMS_DONE:
            isRecordLoadResponse = true;
            ar = (AsyncResult)msg.obj;
    if(ar.exception != null)            
            break;
            handleSmses((ArrayList) ar.result);
            break;
            case EVENT_MARK_SMS_READ_DONE:
            break;
            case EVENT_SMS_ON_SIM:
            isRecordLoadResponse = false;
            ar = (AsyncResult)msg.obj;
            int[] index = (int[])ar.result;
    if(ar.exception != null || index.length != 1)            
            {
            } //End block
            else
            {
                Log.d(LOG_TAG, "READ EF_SMS RECORD index=" + index[0]);
                phone.getIccFileHandler().loadEFLinearFixed(EF_SMS,index[0],
                            obtainMessage(EVENT_GET_SMS_DONE));
            } //End block
            break;
            case EVENT_GET_SMS_DONE:
            isRecordLoadResponse = false;
            ar = (AsyncResult)msg.obj;
    if(ar.exception == null)            
            {
                handleSms((byte[])ar.result);
            } //End block
            else
            {
            } //End block
            break;
            case EVENT_GET_SST_DONE:
            isRecordLoadResponse = true;
            ar = (AsyncResult)msg.obj;
            data = (byte[])ar.result;
    if(ar.exception != null)            
            {
                break;
            } //End block
            mUsimServiceTable = new UsimServiceTable(data);
    if(DBG)            
            log("SST: " + mUsimServiceTable);
            break;
            case EVENT_GET_INFO_CPHS_DONE:
            isRecordLoadResponse = true;
            ar = (AsyncResult)msg.obj;
    if(ar.exception != null)            
            {
                break;
            } //End block
            mCphsInfo = (byte[])ar.result;
    if(DBG)            
            log("iCPHS: " + IccUtils.bytesToHexString(mCphsInfo));
            break;
            case EVENT_SET_MBDN_DONE:
            isRecordLoadResponse = false;
            ar = (AsyncResult)msg.obj;
    if(ar.exception == null)            
            {
                voiceMailNum = newVoiceMailNum;
                voiceMailTag = newVoiceMailTag;
            } //End block
    if(isCphsMailboxEnabled())            
            {
                adn = new AdnRecord(voiceMailTag, voiceMailNum);
                Message onCphsCompleted = (Message) ar.userObj;
    if(ar.exception == null && ar.userObj != null)                
                {
                    AsyncResult.forMessage(((Message) ar.userObj)).exception
                                = null;
                    ((Message) ar.userObj).sendToTarget();
    if(DBG)                    
                    log("Callback with MBDN successful.");
                    onCphsCompleted = null;
                } //End block
                new AdnRecordLoader(phone).
                            updateEF(adn, EF_MAILBOX_CPHS, EF_EXT1, 1, null,
                            obtainMessage(EVENT_SET_CPHS_MAILBOX_DONE,
                                    onCphsCompleted));
            } //End block
            else
            {
    if(ar.userObj != null)                
                {
                    AsyncResult.forMessage(((Message) ar.userObj)).exception
                                = ar.exception;
                    ((Message) ar.userObj).sendToTarget();
                } //End block
            } //End block
            break;
            case EVENT_SET_CPHS_MAILBOX_DONE:
            isRecordLoadResponse = false;
            ar = (AsyncResult)msg.obj;
    if(ar.exception == null)            
            {
                voiceMailNum = newVoiceMailNum;
                voiceMailTag = newVoiceMailTag;
            } //End block
            else
            {
    if(DBG)                
                log("Set CPHS MailBox with exception: "
                            + ar.exception);
            } //End block
    if(ar.userObj != null)            
            {
    if(DBG)                
                log("Callback with CPHS MB successful.");
                AsyncResult.forMessage(((Message) ar.userObj)).exception
                            = ar.exception;
                ((Message) ar.userObj).sendToTarget();
            } //End block
            break;
            case EVENT_SIM_REFRESH:
            isRecordLoadResponse = false;
            ar = (AsyncResult)msg.obj;
    if(DBG)            
            log("Sim REFRESH with exception: " + ar.exception);
    if(ar.exception == null)            
            {
                handleSimRefresh((int[])(ar.result));
            } //End block
            break;
            case EVENT_GET_CFIS_DONE:
            isRecordLoadResponse = true;
            ar = (AsyncResult)msg.obj;
            data = (byte[])ar.result;
    if(ar.exception != null)            
            {
                break;
            } //End block
            Log.d(LOG_TAG, "EF_CFIS: " +
                   IccUtils.bytesToHexString(data));
            mEfCfis = data;
            callForwardingEnabled = ((data[1] & 0x01) != 0);
            phone.notifyCallForwardingIndicator();
            break;
            case EVENT_GET_CSP_CPHS_DONE:
            isRecordLoadResponse = true;
            ar = (AsyncResult)msg.obj;
    if(ar.exception != null)            
            {
                break;
            } //End block
            data = (byte[])ar.result;
            handleEfCspData(data);
            break;
            default:
            super.handleMessage(msg);
}
        } //End block
        catch (RuntimeException exc)
        {
        } //End block
        finally 
        {
    if(isRecordLoadResponse)            
            {
                onRecordLoaded();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.523 -0400", hash_original_method = "E530DF481CB4FAA0037A4FE4ABD87373", hash_generated_method = "C3B313B63E3F12189A4CDF66E93DCE86")
    private void handleFileUpdate(int efid) {
        addTaint(efid);
switch(efid){
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
        phone.getIccFileHandler().loadEFTransparent(EF_CSP_CPHS,
                        obtainMessage(EVENT_GET_CSP_CPHS_DONE));
        break;
        default:
        adnCache.reset();
        fetchSimRecords();
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.524 -0400", hash_original_method = "CBD0F454D52453FACC84E0D26FD9E162", hash_generated_method = "80882B17264C014710039CD446D1C93A")
    private void handleSimRefresh(int[] result) {
        addTaint(result[0]);
    if(result == null || result.length == 0)        
        {
    if(DBG)            
            log("handleSimRefresh without input");
            return;
        } //End block
switch((result[0])){
        case CommandsInterface.SIM_REFRESH_FILE_UPDATED:
    if(DBG)        
        log("handleSimRefresh with SIM_REFRESH_FILE_UPDATED");
        int efid = result[1];
        handleFileUpdate(efid);
        break;
        case CommandsInterface.SIM_REFRESH_INIT:
    if(DBG)        
        log("handleSimRefresh with SIM_REFRESH_INIT");
        adnCache.reset();
        fetchSimRecords();
        break;
        case CommandsInterface.SIM_REFRESH_RESET:
    if(DBG)        
        log("handleSimRefresh with SIM_REFRESH_RESET");
        phone.mCM.setRadioPower(false, null);
        break;
        default:
    if(DBG)        
        log("handleSimRefresh with unknown operation");
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.524 -0400", hash_original_method = "0F425E7BAA03121C5111F3872E01B168", hash_generated_method = "22D802A4C020001C84EE75563007E719")
    protected int dispatchGsmMessage(SmsMessageBase message) {
        addTaint(message.getTaint());
        int varE5ED295C769EEBC0A65C2734AD107BE1_1441421372 = (phone.mSMS.dispatchMessage(message));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1144180234 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1144180234;
        // ---------- Original Method ----------
        //return phone.mSMS.dispatchMessage(message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.524 -0400", hash_original_method = "3974DFF11A620863F24401AEED15BD51", hash_generated_method = "FA5DCD697E2FA086363FE66F548A39A1")
    private void handleSms(byte[] ba) {
        addTaint(ba[0]);
    if(ba[0] != 0)        
        Log.d("ENF", "status : " + ba[0]);
    if(ba[0] == 3)        
        {
            int n = ba.length;
            byte[] pdu = new byte[n - 1];
            System.arraycopy(ba, 1, pdu, 0, n - 1);
            SmsMessage message = SmsMessage.createFromPdu(pdu);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.525 -0400", hash_original_method = "AAB2EB039B628CD9C66D57B4359C7EA6", hash_generated_method = "D78663D134398CF2EC83AD2893E17F31")
    private void handleSmses(ArrayList messages) {
        addTaint(messages.getTaint());
        int count = messages.size();
for(int i = 0;i < count;i++)
        {
            byte[] ba = (byte[]) messages.get(i);
    if(ba[0] != 0){ }    if(ba[0] == 3)            
            {
                int n = ba.length;
                byte[] pdu = new byte[n - 1];
                System.arraycopy(ba, 1, pdu, 0, n - 1);
                SmsMessage message = SmsMessage.createFromPdu(pdu);
                dispatchGsmMessage(message);
                ba[0] = 1;
    if(false)                
                {
                    phone.getIccFileHandler().updateEFLinearFixed(EF_SMS,
                            i, ba, null, obtainMessage(EVENT_MARK_SMS_READ_DONE, i));
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.525 -0400", hash_original_method = "2DE8400081AD5D0DFDE4A5A335B40E41", hash_generated_method = "C104623C9674E8CB54610FBF96F1D2A1")
    protected void onRecordLoaded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        recordsToLoad -= 1;
    if(recordsToLoad == 0 && recordsRequested == true)        
        {
            onAllRecordsLoaded();
        } //End block
        else
    if(recordsToLoad < 0)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.525 -0400", hash_original_method = "66CB4A941BE4FC702CDC8E50BFF0F26C", hash_generated_method = "6C07A1C855C3E96F544C2F489525F323")
    protected void onAllRecordsLoaded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Log.d(LOG_TAG, "SIMRecords: record load complete");
        String operator = getOperatorNumeric();
        phone.setSystemProperty(PROPERTY_ICC_OPERATOR_NUMERIC, operator);
    if(imsi != null)        
        {
            phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ISO_COUNTRY,
                    MccTable.countryCodeForMcc(Integer.parseInt(imsi.substring(0,3))));
        } //End block
        else
        {
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.525 -0400", hash_original_method = "F5FC22B4152F67EB826E6610A6C9072B", hash_generated_method = "BB334338599B6594E2EAD946A566C2B6")
    private void setSpnFromConfig(String carrier) {
        addTaint(carrier.getTaint());
    if(mSpnOverride.containsCarrier(carrier))        
        {
            spn = mSpnOverride.getSpn(carrier);
        } //End block
        // ---------- Original Method ----------
        //if (mSpnOverride.containsCarrier(carrier)) {
            //spn = mSpnOverride.getSpn(carrier);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.525 -0400", hash_original_method = "0A1C3646AC6E538340751C4EFB011D4A", hash_generated_method = "02885CD3E9F7FBF827794AA8BF44D7C1")
    private void setVoiceMailByCountry(String spn) {
        addTaint(spn.getTaint());
    if(mVmConfig.containsCarrier(spn))        
        {
            isVoiceMailFixed = true;
            voiceMailNum = mVmConfig.getVoiceMailNumber(spn);
            voiceMailTag = mVmConfig.getVoiceMailTag(spn);
        } //End block
        // ---------- Original Method ----------
        //if (mVmConfig.containsCarrier(spn)) {
            //isVoiceMailFixed = true;
            //voiceMailNum = mVmConfig.getVoiceMailNumber(spn);
            //voiceMailTag = mVmConfig.getVoiceMailTag(spn);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.526 -0400", hash_original_method = "9A96815ED791357C0C0DD55806DDDE67", hash_generated_method = "F27FE7CD305FE9A5DC0CE32EB9377D86")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.526 -0400", hash_original_method = "267620266787F01EC9F0E5E0AE15B613", hash_generated_method = "A2F14013CDFFA5E63A3C308096AACE35")
    protected void fetchSimRecords() {
        recordsRequested = true;
        IccFileHandler iccFh = phone.getIccFileHandler();
        phone.mCM.getIMSI(obtainMessage(EVENT_GET_IMSI_DONE));
        recordsToLoad++;
        iccFh.loadEFTransparent(EF_ICCID, obtainMessage(EVENT_GET_ICCID_DONE));
        recordsToLoad++;
        new AdnRecordLoader(phone).loadFromEF(EF_MSISDN, EF_EXT1, 1,
                    obtainMessage(EVENT_GET_MSISDN_DONE));
        recordsToLoad++;
        iccFh.loadEFLinearFixed(EF_MBI, 1, obtainMessage(EVENT_GET_MBI_DONE));
        recordsToLoad++;
        iccFh.loadEFTransparent(EF_AD, obtainMessage(EVENT_GET_AD_DONE));
        recordsToLoad++;
        iccFh.loadEFLinearFixed(EF_MWIS, 1, obtainMessage(EVENT_GET_MWIS_DONE));
        recordsToLoad++;
        iccFh.loadEFTransparent(
                EF_VOICE_MAIL_INDICATOR_CPHS,
                obtainMessage(EVENT_GET_VOICE_MAIL_INDICATOR_CPHS_DONE));
        recordsToLoad++;
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
    if(false)        
        {
            iccFh.loadEFLinearFixedAll(EF_SMS, obtainMessage(EVENT_GET_ALL_SMS_DONE));
            recordsToLoad++;
        } //End block
    if(CRASH_RIL)        
        {
            String sms = "0107912160130310f20404d0110041007030208054832b0120"
                         + "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
                         + "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
                         + "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
                         + "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
                         + "ffffffffffffffffffffffffffffff";
            byte[] ba = IccUtils.hexStringToBytes(sms);
            iccFh.updateEFLinearFixed(EF_SMS, 1, ba, null,
                            obtainMessage(EVENT_MARK_SMS_READ_DONE, 1));
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.526 -0400", hash_original_method = "409DDAA47064BEED68B0319934A64CD2", hash_generated_method = "83B60E7B87F69A8521BD8C1460E1CF5C")
    @Override
    public int getDisplayRule(String plmn) {
        addTaint(plmn.getTaint());
        int rule;
    if(spn == null || spnDisplayCondition == -1)        
        {
            rule = SPN_RULE_SHOW_PLMN;
        } //End block
        else
    if(isOnMatchingPlmn(plmn))        
        {
            rule = SPN_RULE_SHOW_SPN;
    if((spnDisplayCondition & 0x01) == 0x01)            
            {
                rule |= SPN_RULE_SHOW_PLMN;
            } //End block
        } //End block
        else
        {
            rule = SPN_RULE_SHOW_PLMN;
    if((spnDisplayCondition & 0x02) == 0x00)            
            {
                rule |= SPN_RULE_SHOW_SPN;
            } //End block
        } //End block
        int var981C1E7B3795DA18687613FBD66D4954_986309498 = (rule);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1251790232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1251790232;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.527 -0400", hash_original_method = "94EB8BB16DAD2AA5FAF871DB9935C4E1", hash_generated_method = "501BCAD97BC9448785A60FC08EA494CC")
    private boolean isOnMatchingPlmn(String plmn) {
        addTaint(plmn.getTaint());
    if(plmn == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1599643914 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_504622746 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_504622746;
        }
    if(plmn.equals(getOperatorNumeric()))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1992273244 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_908944161 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_908944161;
        } //End block
    if(spdiNetworks != null)        
        {
for(String spdiNet : spdiNetworks)
            {
    if(plmn.equals(spdiNet))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_672167930 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1666979931 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1666979931;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_645784473 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_783076555 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_783076555;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.528 -0400", hash_original_method = "CF95CAB3FC09F3005867C57538604F5A", hash_generated_method = "618218F0500E0D20D01152A58D4597FF")
    private void getSpnFsm(boolean start, AsyncResult ar) {
        addTaint(ar.getTaint());
        addTaint(start);
        byte[] data;
    if(start)        
        {
            spnState = Get_Spn_Fsm_State.INIT;
        } //End block
switch(spnState){
        case INIT:
        spn = null;
        phone.getIccFileHandler().loadEFTransparent( EF_SPN,
                        obtainMessage(EVENT_GET_SPN_DONE));
        recordsToLoad++;
        spnState = Get_Spn_Fsm_State.READ_SPN_3GPP;
        break;
        case READ_SPN_3GPP:
    if(ar != null && ar.exception == null)        
        {
            data = (byte[]) ar.result;
            spnDisplayCondition = 0xff & data[0];
            spn = IccUtils.adnStringFieldToString(data, 1, data.length - 1);
    if(DBG)            
            log("Load EF_SPN: " + spn
                            + " spnDisplayCondition: " + spnDisplayCondition);
            phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ALPHA, spn);
            spnState = Get_Spn_Fsm_State.IDLE;
        } //End block
        else
        {
            phone.getIccFileHandler().loadEFTransparent( EF_SPN_CPHS,
                            obtainMessage(EVENT_GET_SPN_DONE));
            recordsToLoad++;
            spnState = Get_Spn_Fsm_State.READ_SPN_CPHS;
            spnDisplayCondition = -1;
        } //End block
        break;
        case READ_SPN_CPHS:
    if(ar != null && ar.exception == null)        
        {
            data = (byte[]) ar.result;
            spn = IccUtils.adnStringFieldToString(
                            data, 0, data.length - 1 );
    if(DBG)            
            log("Load EF_SPN_CPHS: " + spn);
            phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ALPHA, spn);
            spnState = Get_Spn_Fsm_State.IDLE;
        } //End block
        else
        {
            phone.getIccFileHandler().loadEFTransparent(
                            EF_SPN_SHORT_CPHS, obtainMessage(EVENT_GET_SPN_DONE));
            recordsToLoad++;
            spnState = Get_Spn_Fsm_State.READ_SPN_SHORT_CPHS;
        } //End block
        break;
        case READ_SPN_SHORT_CPHS:
    if(ar != null && ar.exception == null)        
        {
            data = (byte[]) ar.result;
            spn = IccUtils.adnStringFieldToString(
                            data, 0, data.length - 1);
    if(DBG)            
            log("Load EF_SPN_SHORT_CPHS: " + spn);
            phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ALPHA, spn);
        } //End block
        else
        {
    if(DBG)            
            log("No SPN loaded in either CHPS or 3GPP");
        } //End block
        spnState = Get_Spn_Fsm_State.IDLE;
        break;
        default:
        spnState = Get_Spn_Fsm_State.IDLE;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.528 -0400", hash_original_method = "2AE095A71557CBF993C4F4933FD42467", hash_generated_method = "8FC3C052C453977E287D2826F58C8599")
    private void parseEfSpdi(byte[] data) {
        addTaint(data[0]);
        SimTlv tlv = new SimTlv(data, 0, data.length);
        byte[] plmnEntries = null;
for(;tlv.isValidObject();tlv.nextObject())
        {
    if(tlv.getTag() == TAG_SPDI)            
            {
                tlv = new SimTlv(tlv.getData(), 0, tlv.getData().length);
            } //End block
    if(tlv.getTag() == TAG_SPDI_PLMN_LIST)            
            {
                plmnEntries = tlv.getData();
                break;
            } //End block
        } //End block
    if(plmnEntries == null)        
        {
            return;
        } //End block
        spdiNetworks = new ArrayList<String>(plmnEntries.length / 3);
for(int i = 0;i + 2 < plmnEntries.length;i += 3)
        {
            String plmnCode;
            plmnCode = IccUtils.bcdToString(plmnEntries, i, 3);
    if(plmnCode.length() >= 5)            
            {
                log("EF_SPDI network: " + plmnCode);
                spdiNetworks.add(plmnCode);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.528 -0400", hash_original_method = "3EE42FFEB0B4A779D022FF2A029DBC31", hash_generated_method = "AC743444500D273EE488674F6928BAE5")
    private boolean isCphsMailboxEnabled() {
    if(mCphsInfo == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1467317512 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_767555743 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_767555743;
        }
        boolean varE23B3FF493A708924D170B3D94CFC53B_1306632758 = (((mCphsInfo[1] & CPHS_SST_MBN_MASK) == CPHS_SST_MBN_ENABLED ));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1222023368 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1222023368;
        // ---------- Original Method ----------
        //if (mCphsInfo == null)  return false;
        //return ((mCphsInfo[1] & CPHS_SST_MBN_MASK) == CPHS_SST_MBN_ENABLED );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.528 -0400", hash_original_method = "A8BE9816664C9DE6B42ACDFC7DA8D2D5", hash_generated_method = "DFC61A3F683036C888A3088317B9D82F")
    protected void log(String s) {
        addTaint(s.getTaint());
        Log.d(LOG_TAG, "[SIMRecords] " + s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[SIMRecords] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.529 -0400", hash_original_method = "747DCE9A0C1CA0D85263EB0A5CECAE60", hash_generated_method = "9369A1FBEE7E35E0523A47E129631C96")
    protected void loge(String s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SIMRecords] " + s);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.529 -0400", hash_original_method = "545A7868DCB44F353BBAB91C69F027BF", hash_generated_method = "5A038018F68ED2C715A920EF4B22DCA1")
    public boolean isCspPlmnEnabled() {
        boolean varB70AE412AC2324E79674A75FFD9621A7_395740140 = (mCspPlmnEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1502955815 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1502955815;
        // ---------- Original Method ----------
        //return mCspPlmnEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.529 -0400", hash_original_method = "5509D297F6B8CC0BD321C284BD8D086E", hash_generated_method = "3F741EEBD44B640720C904CB0B2AA058")
    private void handleEfCspData(byte[] data) {
        addTaint(data[0]);
        int usedCspGroups = data.length / 2;
        byte valueAddedServicesGroup = (byte)0xC0;
        mCspPlmnEnabled = true;
for(int i = 0;i < usedCspGroups;i++)
        {
    if(data[2 * i] == valueAddedServicesGroup)            
            {
    if((data[(2 * i) + 1] & 0x80) == 0x80)                
                {
                    mCspPlmnEnabled = true;
                } //End block
                else
                {
                    mCspPlmnEnabled = false;
                    phone.setNetworkSelectionModeAutomatic(null);
                } //End block
                return;
            } //End block
        } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.529 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "BD940BC52C3AB14198F71CB81F0E8FEB")

    protected static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.529 -0400", hash_original_field = "BD51237ADEE637D214609A89D91C6B3D", hash_generated_field = "B1BDA8481E03A540852BC755DA2091B9")

    private static final boolean CRASH_RIL = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.529 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "5F5E7D64B04175B8FA820B2440F700FC")

    protected static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.529 -0400", hash_original_field = "EFFB07E9493825FFF5E2ADA97E52DB66", hash_generated_field = "415E874A6EA7F4409F1FD3738AF676C5")

    static final int SPN_RULE_SHOW_SPN = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.529 -0400", hash_original_field = "F99FB3994E948E7784AB738BF033D56D", hash_generated_field = "9615ED2E5048F60365ECFB661BB5CFF2")

    static final int SPN_RULE_SHOW_PLMN = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.529 -0400", hash_original_field = "81FFA7042D4CD8556CFB9D17E2D56708", hash_generated_field = "A4822F16D7D0722C09B349753F0A1C53")

    static final int TAG_SPDI = 0xA3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.529 -0400", hash_original_field = "5B55D09E701D389C1CD5414433547D53", hash_generated_field = "C2D6252AE5B1E2BC23E6E6BEB3130A64")

    static final int TAG_SPDI_PLMN_LIST = 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.529 -0400", hash_original_field = "EE4E9897FB11D4CA652E750FCA253418", hash_generated_field = "743085D93FE3601EDCC832FB91368066")

    static final int TAG_FULL_NETWORK_NAME = 0x43;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.529 -0400", hash_original_field = "A7C298598F035F582F2994CA0184ED57", hash_generated_field = "F9C22C8E909AE3B47754DE26713168A6")

    static final int TAG_SHORT_NETWORK_NAME = 0x45;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.529 -0400", hash_original_field = "A4DE335C8AB9D5CD22553519B84FC5E5", hash_generated_field = "F76787922EB6AA2178B7A042FE279FE9")

    static final int CFF_UNCONDITIONAL_ACTIVE = 0x0a;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.529 -0400", hash_original_field = "B0E74EF7AE31DF824A2D801FE88BE298", hash_generated_field = "E898789BE36EE5CC895C4580678DC3EE")

    static final int CFF_UNCONDITIONAL_DEACTIVE = 0x05;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.529 -0400", hash_original_field = "69BFCC7071EF603B4043F9190D9A95E1", hash_generated_field = "6D646CF1330D172C697FBE463F3E20DD")

    static final int CFF_LINE1_MASK = 0x0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.529 -0400", hash_original_field = "D32DF44EE00F04F24CD371F2B902BB93", hash_generated_field = "21B7855A8A75A6C0FBA7800A32927557")

    static final int CFF_LINE1_RESET = 0xf0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.529 -0400", hash_original_field = "42940E3334CBA3BAA9F1A0F7C2D979F2", hash_generated_field = "DED73EE7FF558B0A8BCE28EA6F50AA32")

    private static final int CPHS_SST_MBN_MASK = 0x30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "0FA35357C28858D0DF2D19D905ED912E", hash_generated_field = "90E2112308FC996159B6715487610C17")

    private static final int CPHS_SST_MBN_ENABLED = 0x30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "F15D5CBB2043757AB5313BDD33D4BBC7", hash_generated_field = "CA9D8FD5F6DA4FDAFDD2818A884111C6")

    private static final int EVENT_SIM_READY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "B41D6834011DAA4DB1A6AC940ADFA38E", hash_generated_field = "C65DF4AD1462685EBC499AE583280BAA")

    private static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "1C7B2408ABBFF84C0AE773B343AAE081", hash_generated_field = "C1B81CA82D779018C72F133549599B37")

    protected static final int EVENT_GET_IMSI_DONE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "448E89735034CA52094210C2C3805091", hash_generated_field = "FA13D8118051BEADD1DF91D4EC1C2052")

    protected static final int EVENT_GET_ICCID_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "32C87913BB9A9B8C0E774950157E52E2", hash_generated_field = "AC488F40D96E33B7A9106EEA894C7BD2")

    private static final int EVENT_GET_MBI_DONE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "3E3F251CEC6926A6D2E784E6B7DAAEF0", hash_generated_field = "EDE69B90FE5CC250E0B91ECDBE9DE9D1")

    private static final int EVENT_GET_MBDN_DONE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "7248BB1DD465A3F59F510A80078BB34B", hash_generated_field = "1ABA989B0F3362D2C70EEB5A70C87F0D")

    private static final int EVENT_GET_MWIS_DONE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "370CB56A39D5391291430562D9A723EE", hash_generated_field = "5165FAAB5F7CD18E9D5F96D2818657FA")

    private static final int EVENT_GET_VOICE_MAIL_INDICATOR_CPHS_DONE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "C924AEAB30A16AD11ED99D61AA5708C4", hash_generated_field = "AF8D9BB0B036F882F1D0C816581372A7")

    protected static final int EVENT_GET_AD_DONE = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "16E2029513C20709A62FF531D3DD5014", hash_generated_field = "7E6BDAACDB02FB8DBDE5B121D1D96B80")

    protected static final int EVENT_GET_MSISDN_DONE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "31D8AABE5416BED99B19A990923D8C0E", hash_generated_field = "16316F56D2B66BC0712FA6DCCB623FD8")

    private static final int EVENT_GET_CPHS_MAILBOX_DONE = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "BD1F2474793DBD794A60F38D867722DC", hash_generated_field = "A9380C4C24D6B84D11AA10394A8A4655")

    private static final int EVENT_GET_SPN_DONE = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "6C5AAA199C42018DFEBF9DB3106941D8", hash_generated_field = "23B20EDB29F4E6ACE5BC6B6E3131138F")

    private static final int EVENT_GET_SPDI_DONE = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "529053860FA14F8B31FBDEC20F5F5B03", hash_generated_field = "7C08F6997CDB1F95B53292AC6E4DA474")

    private static final int EVENT_UPDATE_DONE = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "221898CECF6E8C9F50998ADFEF8B06D1", hash_generated_field = "A297125EDFFC4F42969DFEF4BE44F8AC")

    private static final int EVENT_GET_PNN_DONE = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "1E3C0E257296800F8D76872CD2E55387", hash_generated_field = "9BD29131ACB6B8193EA3976774320615")

    protected static final int EVENT_GET_SST_DONE = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "3B79516072415E285E9DD48ECF8C32E3", hash_generated_field = "9F464D691ED618E65FF918987EFF9274")

    private static final int EVENT_GET_ALL_SMS_DONE = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "5EB21554FBD2F493FD526FF035BA3944", hash_generated_field = "961A7A4D60E11CE78834F70BC49A219A")

    private static final int EVENT_MARK_SMS_READ_DONE = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "E456F51692CD77EC7FABB0627F1E741E", hash_generated_field = "F05CD6C947B2B1AA00E5D1063F179FDF")

    private static final int EVENT_SET_MBDN_DONE = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "7040E283E3C6429991BBA3AAE2DFC6BA", hash_generated_field = "32F13C0B04E96171B7B8D712BBC53B0A")

    private static final int EVENT_SMS_ON_SIM = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "17E27DF4CEFFF43554FD32CB85BD7662", hash_generated_field = "18FB3B701347968BBB3DB68B7D9FA9E0")

    private static final int EVENT_GET_SMS_DONE = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "3D7336F8F10AF2644854C342FE6A5B62", hash_generated_field = "778675A2DDF2BB258371DC2061683859")

    private static final int EVENT_GET_CFF_DONE = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "60FC5DEEB2B572B1AF1F2074AB4AF616", hash_generated_field = "5818D0009EC83D0304F736A07B44ED18")

    private static final int EVENT_SET_CPHS_MAILBOX_DONE = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "B179DBEA5D80A114C092309538D3A988", hash_generated_field = "8D3AD55D8107BA8230AA0810AF1F7304")

    private static final int EVENT_GET_INFO_CPHS_DONE = 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "E775C0820692BDD407C8D22F0A74404C", hash_generated_field = "BE715D1FD0CE243424B798654ACC75BA")

    private static final int EVENT_SET_MSISDN_DONE = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "44F3B6DB71F91630605B5A6876BFD3A4", hash_generated_field = "0FDD8C86CA2531BA62F4A95521E434F5")

    private static final int EVENT_SIM_REFRESH = 31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "4A3450DC04C4C053A9A850983E872C19", hash_generated_field = "F29A42DEBAB245F7C058BE162E7F91ED")

    private static final int EVENT_GET_CFIS_DONE = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.530 -0400", hash_original_field = "B0A927A61DAD1AD86AB00D245EB2C803", hash_generated_field = "3DCE777E62AE6095ECB53822D16E8FE9")

    private static final int EVENT_GET_CSP_CPHS_DONE = 33;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.531 -0400", hash_original_field = "1B81364A8EB1E2266EAA74C0C5553905", hash_generated_field = "7E3BF9E363667067579B2DD88404B9BE")

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

