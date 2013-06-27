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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.979 -0400", hash_original_field = "A6D54253A6E7A5BF5CFC7DB47F269D57", hash_generated_field = "3D45F4DC7928ADFBE49F3906732C5FDD")

    VoiceMailConstants mVmConfig;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.979 -0400", hash_original_field = "E040FD05576717C9CA830E49D86F56E5", hash_generated_field = "1D5FAB34B5B1DFA2FF0C72EB8EB1417D")

    SpnOverride mSpnOverride;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.980 -0400", hash_original_field = "2A3E692FB30211EBAAAF0E3BF2F7B04D", hash_generated_field = "C8FB6D75F33BBB165F89E1184AF1DAB5")

    private String imsi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.980 -0400", hash_original_field = "D3724EA3C1583660418AAE7549D15B6B", hash_generated_field = "F3670A331578D3C800D2A8879CDAE6A2")

    private boolean callForwardingEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.988 -0400", hash_original_field = "7A58A9F6FCDF3B6856A0262D5FF72428", hash_generated_field = "71EE1DCA9A91F37B8070C2DE70EBC3CC")

    private Get_Spn_Fsm_State spnState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.988 -0400", hash_original_field = "CC93CCB29A5FE37184AD950A48100507", hash_generated_field = "B94C656CABFD2A097CE8CA776F9B3D25")

    private byte[] mCphsInfo = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.988 -0400", hash_original_field = "1D3682655094CF36E1E3298A4C25ED91", hash_generated_field = "3B0DBAF5E1453033DE8A23FEF66CB6CF")

    boolean mCspPlmnEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.988 -0400", hash_original_field = "D2C36B26FA6DBE28216F0234CF7213CA", hash_generated_field = "531BEBDA8DE453FA3ED736DAC070C337")

    byte[] efMWIS = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.988 -0400", hash_original_field = "95FFAD26D850D5EC0F2B1F6AAE5CD8CE", hash_generated_field = "F7BA255CC3AE0058E8CFC095600F245B")

    byte[] efCPHS_MWI = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.988 -0400", hash_original_field = "58264A603FE1A26D9B3DD780DF8AAC91", hash_generated_field = "27C9B421032889367442E38FD625EA3E")

    byte[] mEfCff = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.988 -0400", hash_original_field = "D6E9B336B4F61EEF8DC3ED94B6E2429B", hash_generated_field = "4CFC3799ACD516937F814E469F055B3D")

    byte[] mEfCfis = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.988 -0400", hash_original_field = "6E8DE6542D284DA95B6DF2FA3E03574A", hash_generated_field = "677DC81727BE9252421E71F32EAE57E6")

    int spnDisplayCondition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.988 -0400", hash_original_field = "E2A1ABC58A408D18FA38B6BF738C77C8", hash_generated_field = "9CBD8D86B3B910D521D7CFC4F4B05AE6")

    ArrayList<String> spdiNetworks = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.988 -0400", hash_original_field = "C79C429F0ECF3DC640C19EFC7DA64CD0", hash_generated_field = "FC170B0C5C20481C238409EFCB48A036")

    String pnnHomeName = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.988 -0400", hash_original_field = "06F1EF4000599F31B6960C354731E5E3", hash_generated_field = "433C8C040DD36FD17B8409B23AF92316")

    UsimServiceTable mUsimServiceTable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.989 -0400", hash_original_method = "AA8710B4BBDFAECA42DF87898B5E71E9", hash_generated_method = "F453B0793EE78A6C0F14E38E4EB7DEBF")
    public  SIMRecords(PhoneBase p) {
        super(p);
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
        addTaint(p.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.989 -0400", hash_original_method = "60B34C0CDC881E5C8D40C8AAD990557F", hash_generated_method = "3EA07F3E006CA7F93EFE786B4B31CD0A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.990 -0400", hash_original_method = "D676C6F3D2367DC0A4942786FE826692", hash_generated_method = "6E2BC99A5C88DFAF422E2B6A62A301F5")
    protected void finalize() {
        Log.d(LOG_TAG, "SIMRecords finalized");
        // ---------- Original Method ----------
        //if(DBG) Log.d(LOG_TAG, "SIMRecords finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.990 -0400", hash_original_method = "1C495E4F05849546A87C14B5D6E64BED", hash_generated_method = "DFF28017DADF7D467DB4EC42F6547305")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.991 -0400", hash_original_method = "3D26DD60574339032566256F631F5DB8", hash_generated_method = "6840ABBBBED416DFFEF4744661EF4117")
    @Override
    public String getIMSI() {
        String varB4EAC82CA7396A68D541C85D26508E83_976776495 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_976776495 = imsi;
        varB4EAC82CA7396A68D541C85D26508E83_976776495.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_976776495;
        // ---------- Original Method ----------
        //return imsi;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.991 -0400", hash_original_method = "9D42E73ED1AA846035EF94EBFAAEA8F6", hash_generated_method = "569B1211C4CA84BABD3E5F8D8B674C3A")
    public String getMsisdnNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_315345127 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_315345127 = msisdn;
        varB4EAC82CA7396A68D541C85D26508E83_315345127.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_315345127;
        // ---------- Original Method ----------
        //return msisdn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.006 -0400", hash_original_method = "F96F62208A76C85F8691E193053EFC74", hash_generated_method = "703BE6FC3D585163518BB0A64E0ADBFA")
    @Override
    public UsimServiceTable getUsimServiceTable() {
        UsimServiceTable varB4EAC82CA7396A68D541C85D26508E83_746027370 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_746027370 = mUsimServiceTable;
        varB4EAC82CA7396A68D541C85D26508E83_746027370.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_746027370;
        // ---------- Original Method ----------
        //return mUsimServiceTable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.010 -0400", hash_original_method = "7B16D051528D70BC1665C409BE0B92A5", hash_generated_method = "A75C95348D3AA470A858F3911D181A5C")
    public void setMsisdnNumber(String alphaTag, String number,
            Message onComplete) {
        msisdn = number;
        msisdnTag = alphaTag;
        log("Set MSISDN: " + msisdnTag + " " +  "xxxxxxx");
        AdnRecord adn;
        adn = new AdnRecord(msisdnTag, msisdn);
        new AdnRecordLoader(phone).updateEF(adn, EF_MSISDN, EF_EXT1, 1, null,
                obtainMessage(EVENT_SET_MSISDN_DONE, onComplete));
        addTaint(alphaTag.getTaint());
        addTaint(number.getTaint());
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //msisdn = number;
        //msisdnTag = alphaTag;
        //if(DBG) log("Set MSISDN: " + msisdnTag + " " +  "xxxxxxx");
        //AdnRecord adn = new AdnRecord(msisdnTag, msisdn);
        //new AdnRecordLoader(phone).updateEF(adn, EF_MSISDN, EF_EXT1, 1, null,
                //obtainMessage(EVENT_SET_MSISDN_DONE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.010 -0400", hash_original_method = "E32EFED28CC433860D178485CFB4EEE4", hash_generated_method = "F42B42CFC9D846A940B526B105ADF185")
    public String getMsisdnAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_439098199 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_439098199 = msisdnTag;
        varB4EAC82CA7396A68D541C85D26508E83_439098199.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_439098199;
        // ---------- Original Method ----------
        //return msisdnTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.011 -0400", hash_original_method = "77FFC0D98CD3CB2629C7F6A7D27E6FFF", hash_generated_method = "67FE64836C46A75F54500B2BBD4863F6")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1860793659 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1860793659 = voiceMailNum;
        varB4EAC82CA7396A68D541C85D26508E83_1860793659.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1860793659;
        // ---------- Original Method ----------
        //return voiceMailNum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.018 -0400", hash_original_method = "BBA59ED68AB83B35B5A29C09BCF3BE4C", hash_generated_method = "9F98F087FCF17C1ECB1CE9374D2E58F0")
    public void setVoiceMailNumber(String alphaTag, String voiceNumber,
            Message onComplete) {
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
            boolean var49EDB32946FB23439D4ABEF334DBE8F4_1366287682 = (isCphsMailboxEnabled());
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
        addTaint(alphaTag.getTaint());
        addTaint(voiceNumber.getTaint());
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.023 -0400", hash_original_method = "5A91F4662DCD8CEE6B5E6A046B7A4ABC", hash_generated_method = "5DA94CEF8496F22D9568A33C4C1BC88D")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1273633001 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1273633001 = voiceMailTag;
        varB4EAC82CA7396A68D541C85D26508E83_1273633001.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1273633001;
        // ---------- Original Method ----------
        //return voiceMailTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.033 -0400", hash_original_method = "75BFE4AFE8A3A09F4E38976A214FAF70", hash_generated_method = "ED2C812C930BC414206CF263F8543B3E")
    public void setVoiceMessageWaiting(int line, int countWaiting) {
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
        addTaint(line);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.033 -0400", hash_original_method = "2A8D94361FF074096EDCA291A7FA986D", hash_generated_method = "97B914DEC81E9EFB9076FB8D2A96D886")
    @Override
    public boolean getVoiceCallForwardingFlag() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_695813225 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_695813225;
        // ---------- Original Method ----------
        //return callForwardingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.036 -0400", hash_original_method = "141082A6B47AB008F9D1AEFE7E7266B0", hash_generated_method = "7D470D879E0BE633F0C906E6A355A40F")
    @Override
    public void setVoiceCallForwardingFlag(int line, boolean enable) {
        callForwardingEnabled = enable;
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
        addTaint(line);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.049 -0400", hash_original_method = "3729AD4A21CE0EDB3800382FBE3F87EC", hash_generated_method = "7912B183DD2EB642356E1DD30C60FE60")
    public void onRefresh(boolean fileChanged, int[] fileList) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            fetchSimRecords();
        } //End block
        addTaint(fileChanged);
        addTaint(fileList[0]);
        // ---------- Original Method ----------
        //if (fileChanged) {
            //fetchSimRecords();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.050 -0400", hash_original_method = "7E03E5ED77A0C757F38448793B936037", hash_generated_method = "0FB3A69A4F75398451C3E9AAEE605048")
    @Override
    public String getOperatorNumeric() {
        String varB4EAC82CA7396A68D541C85D26508E83_830130964 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1035324595 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_197939122 = null; //Variable for return #3
        {
            Log.d(LOG_TAG, "getOperatorNumeric: IMSI == null");
            varB4EAC82CA7396A68D541C85D26508E83_830130964 = null;
        } //End block
        {
            Log.d(LOG_TAG, "getSIMOperatorNumeric: bad mncLength");
            varB4EAC82CA7396A68D541C85D26508E83_1035324595 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_197939122 = imsi.substring(0, 3 + mncLength);
        String varA7E53CE21691AB073D9660D615818899_1448693502; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1448693502 = varB4EAC82CA7396A68D541C85D26508E83_830130964;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1448693502 = varB4EAC82CA7396A68D541C85D26508E83_1035324595;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1448693502 = varB4EAC82CA7396A68D541C85D26508E83_197939122;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1448693502.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1448693502;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.898 -0400", hash_original_method = "5FA65278BC21B747191DBEA87B814DA9", hash_generated_method = "C2B0B34A340D6E01C3F88AE73FE0E5FB")
    public void handleMessage(Message msg) {
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
                boolean var830EA25F7AEDECBD15578DB21CAE52BA_1439517216 = (imsi != null && (imsi.length() < 6 || imsi.length() > 15));
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
                boolean varAA3845750DE6743614D7EDB45EFDA541_1680469315 = (((mncLength == UNKNOWN) || (mncLength == 2)) &&
                        ((imsi != null) && (imsi.length() >= 6)));
                {
                    String mccmncCode;
                    mccmncCode = imsi.substring(0, 6);
                    {
                        Iterator<String> varC240E69CE119782E8F47CC07C68C68DD_54870652 = (MCCMNC_CODES_HAVING_3DIGITS_MNC).iterator();
                        varC240E69CE119782E8F47CC07C68C68DD_54870652.hasNext();
                        String mccmnc = varC240E69CE119782E8F47CC07C68C68DD_54870652.next();
                        {
                            {
                                boolean var7D3F2C7003F88A96589D9955600C8CFE_1000838218 = (mccmnc.equals(mccmncCode));
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
                boolean var6E610A8EE073A016325ACA342BC92511_1631739897 = (adn.isEmpty() && msg.what == EVENT_GET_MBDN_DONE);
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
                    boolean varA6967A0FC894379A31A07978EEE8D097_1564192928 = (((mncLength == UNINITIALIZED) || (mncLength == UNKNOWN) ||
                            (mncLength == 2)) && ((imsi != null) && (imsi.length() >= 6)));
                    {
                        String mccmncCode;
                        mccmncCode = imsi.substring(0, 6);
                        {
                            Iterator<String> varC240E69CE119782E8F47CC07C68C68DD_336117518 = (MCCMNC_CODES_HAVING_3DIGITS_MNC).iterator();
                            varC240E69CE119782E8F47CC07C68C68DD_336117518.hasNext();
                            String mccmnc = varC240E69CE119782E8F47CC07C68C68DD_336117518.next();
                            {
                                {
                                    boolean var84BDA82F133A3C6DFBD3E95E8608ED9C_256256669 = (mccmnc.equals(mccmncCode));
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
                boolean varCB644CCA004D571A2231D5557A3D0712_1016460699 = (tlv.isValidObject());
                tlv.nextObject();
                {
                    {
                        boolean varA602311CA9E7B0FBD63424EF01DC038B_1902070626 = (tlv.getTag() == TAG_FULL_NETWORK_NAME);
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
                boolean varDB6C50FA3E4BE068EAA8443655261A1E_358839640 = (isCphsMailboxEnabled());
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
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.906 -0400", hash_original_method = "E530DF481CB4FAA0037A4FE4ABD87373", hash_generated_method = "CF925A38E53DE3280062F2C1678C27C7")
    private void handleFileUpdate(int efid) {
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
        addTaint(efid);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.907 -0400", hash_original_method = "CBD0F454D52453FACC84E0D26FD9E162", hash_generated_method = "6FA8F74BD3BFA67E6AD6437DE3804BA2")
    private void handleSimRefresh(int[] result) {
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
        addTaint(result[0]);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.914 -0400", hash_original_method = "0F425E7BAA03121C5111F3872E01B168", hash_generated_method = "B671F703805483FAC3828B6FAE9E193D")
    protected int dispatchGsmMessage(SmsMessageBase message) {
        int varA522FA72751E3B8CCDC974402CB11ED3_1723500726 = (phone.mSMS.dispatchMessage(message));
        addTaint(message.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966283546 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966283546;
        // ---------- Original Method ----------
        //return phone.mSMS.dispatchMessage(message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.914 -0400", hash_original_method = "3974DFF11A620863F24401AEED15BD51", hash_generated_method = "52F58C3496E57259FC9D443F0BA831D6")
    private void handleSms(byte[] ba) {
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
        addTaint(ba[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.915 -0400", hash_original_method = "AAB2EB039B628CD9C66D57B4359C7EA6", hash_generated_method = "265B3FB9AE199BB56542E8602D16387D")
    private void handleSmses(ArrayList messages) {
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
        addTaint(messages.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.916 -0400", hash_original_method = "2DE8400081AD5D0DFDE4A5A335B40E41", hash_generated_method = "15D741D51610FD01EF0C6B9D8351E8E7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.923 -0400", hash_original_method = "66CB4A941BE4FC702CDC8E50BFF0F26C", hash_generated_method = "D90773C7A1418372C2757D5F6B4C90D6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.923 -0400", hash_original_method = "F5FC22B4152F67EB826E6610A6C9072B", hash_generated_method = "478A9A18C9C3DE91040133EE861B6561")
    private void setSpnFromConfig(String carrier) {
        {
            boolean var421905470EB904055FD073228F381009_1757083831 = (mSpnOverride.containsCarrier(carrier));
            {
                spn = mSpnOverride.getSpn(carrier);
            } //End block
        } //End collapsed parenthetic
        addTaint(carrier.getTaint());
        // ---------- Original Method ----------
        //if (mSpnOverride.containsCarrier(carrier)) {
            //spn = mSpnOverride.getSpn(carrier);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.939 -0400", hash_original_method = "0A1C3646AC6E538340751C4EFB011D4A", hash_generated_method = "D2B7D95123868E95A23FB96A819BA528")
    private void setVoiceMailByCountry(String spn) {
        {
            boolean var78FA3AAD64E283DFCBDA5E9AF5AFA96F_1554578655 = (mVmConfig.containsCarrier(spn));
            {
                isVoiceMailFixed = true;
                voiceMailNum = mVmConfig.getVoiceMailNumber(spn);
                voiceMailTag = mVmConfig.getVoiceMailTag(spn);
            } //End block
        } //End collapsed parenthetic
        addTaint(spn.getTaint());
        // ---------- Original Method ----------
        //if (mVmConfig.containsCarrier(spn)) {
            //isVoiceMailFixed = true;
            //voiceMailNum = mVmConfig.getVoiceMailNumber(spn);
            //voiceMailTag = mVmConfig.getVoiceMailTag(spn);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.940 -0400", hash_original_method = "9A96815ED791357C0C0DD55806DDDE67", hash_generated_method = "F27FE7CD305FE9A5DC0CE32EB9377D86")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.941 -0400", hash_original_method = "267620266787F01EC9F0E5E0AE15B613", hash_generated_method = "E89C138DE28C99B785301355932F0F70")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.942 -0400", hash_original_method = "409DDAA47064BEED68B0319934A64CD2", hash_generated_method = "E0022522B43A7D15B8640910B46153C2")
    @Override
    public int getDisplayRule(String plmn) {
        int rule;
        {
            rule = SPN_RULE_SHOW_PLMN;
        } //End block
        {
            boolean var93D8A656618E8CC215C13DA82B4B7F6B_1841953722 = (isOnMatchingPlmn(plmn));
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
        addTaint(plmn.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1555960532 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1555960532;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.996 -0400", hash_original_method = "94EB8BB16DAD2AA5FAF871DB9935C4E1", hash_generated_method = "5F9A78E224C3F8E53D6702B6668F3BE1")
    private boolean isOnMatchingPlmn(String plmn) {
        {
            boolean var0FF98638333814881B939E2E997568A8_1534488063 = (plmn.equals(getOperatorNumeric()));
        } //End collapsed parenthetic
        {
            {
                Iterator<String> var2DB1354A1A9DE1AE97AA82A80F522F26_1989588059 = (spdiNetworks).iterator();
                var2DB1354A1A9DE1AE97AA82A80F522F26_1989588059.hasNext();
                String spdiNet = var2DB1354A1A9DE1AE97AA82A80F522F26_1989588059.next();
                {
                    {
                        boolean var41CE6775E09518F8198A5D804233075F_1615974777 = (plmn.equals(spdiNet));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(plmn.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2058991763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2058991763;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.999 -0400", hash_original_method = "CF95CAB3FC09F3005867C57538604F5A", hash_generated_method = "0694F46C0760348BD60538CF2BA8A465")
    private void getSpnFsm(boolean start, AsyncResult ar) {
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
        addTaint(start);
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.006 -0400", hash_original_method = "2AE095A71557CBF993C4F4933FD42467", hash_generated_method = "145842F502C4E4CD23F9900EB6F318AA")
    private void parseEfSpdi(byte[] data) {
        SimTlv tlv;
        tlv = new SimTlv(data, 0, data.length);
        byte[] plmnEntries;
        plmnEntries = null;
        {
            boolean varD6DAE705252AE64CA27B233F668D159C_601195513 = (tlv.isValidObject());
            tlv.nextObject();
            {
                {
                    boolean var06676F894B0CE0AFE5FFB22891957C33_1985029740 = (tlv.getTag() == TAG_SPDI);
                    {
                        tlv = new SimTlv(tlv.getData(), 0, tlv.getData().length);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var737E9541DB57851299264A8B92818535_232704213 = (tlv.getTag() == TAG_SPDI_PLMN_LIST);
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
                    boolean var2A08EE5A8A72F3C48E7EDA0361A465D4_1707091898 = (plmnCode.length() >= 5);
                    {
                        log("EF_SPDI network: " + plmnCode);
                        spdiNetworks.add(plmnCode);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(data[0]);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.007 -0400", hash_original_method = "3EE42FFEB0B4A779D022FF2A029DBC31", hash_generated_method = "23E8E92548A56E5310E8AA8CE97DC4B0")
    private boolean isCphsMailboxEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1309552159 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1309552159;
        // ---------- Original Method ----------
        //if (mCphsInfo == null)  return false;
        //return ((mCphsInfo[1] & CPHS_SST_MBN_MASK) == CPHS_SST_MBN_ENABLED );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.007 -0400", hash_original_method = "A8BE9816664C9DE6B42ACDFC7DA8D2D5", hash_generated_method = "80BD34BE1E1004B1AFCEA0216220D37A")
    protected void log(String s) {
        Log.d(LOG_TAG, "[SIMRecords] " + s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[SIMRecords] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.007 -0400", hash_original_method = "747DCE9A0C1CA0D85263EB0A5CECAE60", hash_generated_method = "9369A1FBEE7E35E0523A47E129631C96")
    protected void loge(String s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SIMRecords] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.007 -0400", hash_original_method = "545A7868DCB44F353BBAB91C69F027BF", hash_generated_method = "6E4C88BAB13E2CD03F552F93742F08FB")
    public boolean isCspPlmnEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_618413871 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_618413871;
        // ---------- Original Method ----------
        //return mCspPlmnEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.008 -0400", hash_original_method = "5509D297F6B8CC0BD321C284BD8D086E", hash_generated_method = "9EF46C0E7828B182C8C8A9AC1D11E8AB")
    private void handleEfCspData(byte[] data) {
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
        addTaint(data[0]);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.008 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "122B20F52DE0D566691CB293C46EE900")

    protected static String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.008 -0400", hash_original_field = "BD51237ADEE637D214609A89D91C6B3D", hash_generated_field = "CB2BF79D9AEB2D899725B2F716957D2C")

    private static boolean CRASH_RIL = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.008 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "D751668EF011EB030075908D0A6ACFD9")

    protected static boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.008 -0400", hash_original_field = "EFFB07E9493825FFF5E2ADA97E52DB66", hash_generated_field = "DDB86E0F4E670E15CF6F8EB01CDF6493")

    static int SPN_RULE_SHOW_SPN = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.008 -0400", hash_original_field = "F99FB3994E948E7784AB738BF033D56D", hash_generated_field = "F044C57BE2C2408E47AC45E441C607BF")

    static int SPN_RULE_SHOW_PLMN = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.008 -0400", hash_original_field = "81FFA7042D4CD8556CFB9D17E2D56708", hash_generated_field = "1A9582F0707591AB7F4698E44A68181C")

    static int TAG_SPDI = 0xA3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.008 -0400", hash_original_field = "5B55D09E701D389C1CD5414433547D53", hash_generated_field = "C8E5ED81E8B16B23D4186831554611AB")

    static int TAG_SPDI_PLMN_LIST = 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.008 -0400", hash_original_field = "EE4E9897FB11D4CA652E750FCA253418", hash_generated_field = "082C09197B98DDA34C5477579714A8FB")

    static int TAG_FULL_NETWORK_NAME = 0x43;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.008 -0400", hash_original_field = "A7C298598F035F582F2994CA0184ED57", hash_generated_field = "F522E2E3CE5A9958029166B188579A82")

    static int TAG_SHORT_NETWORK_NAME = 0x45;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.008 -0400", hash_original_field = "A4DE335C8AB9D5CD22553519B84FC5E5", hash_generated_field = "01C4CC2440AFD7382FE428E35C270DFB")

    static int CFF_UNCONDITIONAL_ACTIVE = 0x0a;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.008 -0400", hash_original_field = "B0E74EF7AE31DF824A2D801FE88BE298", hash_generated_field = "7DBD73890AC33E39B160EC08AB875D56")

    static int CFF_UNCONDITIONAL_DEACTIVE = 0x05;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.008 -0400", hash_original_field = "69BFCC7071EF603B4043F9190D9A95E1", hash_generated_field = "4CDCEEE68185A1853E3A9873A7AAEBC9")

    static int CFF_LINE1_MASK = 0x0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.008 -0400", hash_original_field = "D32DF44EE00F04F24CD371F2B902BB93", hash_generated_field = "56844074047F5F2617772A6F2EDD33A3")

    static int CFF_LINE1_RESET = 0xf0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.008 -0400", hash_original_field = "42940E3334CBA3BAA9F1A0F7C2D979F2", hash_generated_field = "514C6184FA5FFBB14E94C55904ED9795")

    private static int CPHS_SST_MBN_MASK = 0x30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.008 -0400", hash_original_field = "0FA35357C28858D0DF2D19D905ED912E", hash_generated_field = "0E543B78AA0F69D0BC0BC276D388A921")

    private static int CPHS_SST_MBN_ENABLED = 0x30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.009 -0400", hash_original_field = "F15D5CBB2043757AB5313BDD33D4BBC7", hash_generated_field = "7346256AB076ABC3EDF7EB2B7905664F")

    private static int EVENT_SIM_READY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.009 -0400", hash_original_field = "B41D6834011DAA4DB1A6AC940ADFA38E", hash_generated_field = "7BCF1FFF9022E22F04BC0FDC1FAA6FD5")

    private static int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.029 -0400", hash_original_field = "1C7B2408ABBFF84C0AE773B343AAE081", hash_generated_field = "ED68E40A1C990775573EC4497C233665")

    protected static int EVENT_GET_IMSI_DONE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.029 -0400", hash_original_field = "448E89735034CA52094210C2C3805091", hash_generated_field = "E6FC683304020AB5C050A0886A6E5B50")

    protected static int EVENT_GET_ICCID_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.029 -0400", hash_original_field = "32C87913BB9A9B8C0E774950157E52E2", hash_generated_field = "F3EAA05D5484B166AF7B8653372A3CD0")

    private static int EVENT_GET_MBI_DONE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.029 -0400", hash_original_field = "3E3F251CEC6926A6D2E784E6B7DAAEF0", hash_generated_field = "17BCCFFBFDBE059B1FB22C98918ED3E3")

    private static int EVENT_GET_MBDN_DONE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.029 -0400", hash_original_field = "7248BB1DD465A3F59F510A80078BB34B", hash_generated_field = "E726DB385FE32A496B50B1526A70BEFA")

    private static int EVENT_GET_MWIS_DONE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.029 -0400", hash_original_field = "370CB56A39D5391291430562D9A723EE", hash_generated_field = "F0747DDDF06034BE553C36699AA9812D")

    private static int EVENT_GET_VOICE_MAIL_INDICATOR_CPHS_DONE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.029 -0400", hash_original_field = "C924AEAB30A16AD11ED99D61AA5708C4", hash_generated_field = "1E50443C230905CE95A5D2416D01C8D1")

    protected static int EVENT_GET_AD_DONE = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.029 -0400", hash_original_field = "16E2029513C20709A62FF531D3DD5014", hash_generated_field = "E94A0EE24EA5FD74E400C7CE94630F1F")

    protected static int EVENT_GET_MSISDN_DONE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.029 -0400", hash_original_field = "31D8AABE5416BED99B19A990923D8C0E", hash_generated_field = "6E93B9D00D59D54D5C3CB165DAE2C64A")

    private static int EVENT_GET_CPHS_MAILBOX_DONE = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.029 -0400", hash_original_field = "BD1F2474793DBD794A60F38D867722DC", hash_generated_field = "1BBE85C2AFBDD448AF1B3B024B4E94CE")

    private static int EVENT_GET_SPN_DONE = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.030 -0400", hash_original_field = "6C5AAA199C42018DFEBF9DB3106941D8", hash_generated_field = "A0279C3D00F5C25D6C120AEF0FCECEC7")

    private static int EVENT_GET_SPDI_DONE = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.030 -0400", hash_original_field = "529053860FA14F8B31FBDEC20F5F5B03", hash_generated_field = "B0B78B92D79876F59FE3B5A8E316C0E4")

    private static int EVENT_UPDATE_DONE = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.030 -0400", hash_original_field = "221898CECF6E8C9F50998ADFEF8B06D1", hash_generated_field = "925973ED5457F95D459E85F099AAEE66")

    private static int EVENT_GET_PNN_DONE = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.030 -0400", hash_original_field = "1E3C0E257296800F8D76872CD2E55387", hash_generated_field = "00CE47005B4DE2ED0049E52758A5C603")

    protected static int EVENT_GET_SST_DONE = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.030 -0400", hash_original_field = "3B79516072415E285E9DD48ECF8C32E3", hash_generated_field = "1E34B501E28E4512D34E6566C6DC5F9E")

    private static int EVENT_GET_ALL_SMS_DONE = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.030 -0400", hash_original_field = "5EB21554FBD2F493FD526FF035BA3944", hash_generated_field = "19C1026B8F804F62066BB3602553F56D")

    private static int EVENT_MARK_SMS_READ_DONE = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.030 -0400", hash_original_field = "E456F51692CD77EC7FABB0627F1E741E", hash_generated_field = "2E96C317A429ADDCCD834DB76AEC4794")

    private static int EVENT_SET_MBDN_DONE = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.030 -0400", hash_original_field = "7040E283E3C6429991BBA3AAE2DFC6BA", hash_generated_field = "011CEFC8FA7227226413ACE63F73A982")

    private static int EVENT_SMS_ON_SIM = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.030 -0400", hash_original_field = "17E27DF4CEFFF43554FD32CB85BD7662", hash_generated_field = "2E17A31BF2AA6CC5E5F0D8A7BA22651E")

    private static int EVENT_GET_SMS_DONE = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.030 -0400", hash_original_field = "3D7336F8F10AF2644854C342FE6A5B62", hash_generated_field = "D7909EC1A88E3D3ED7DCDE35D5CEFEA6")

    private static int EVENT_GET_CFF_DONE = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.030 -0400", hash_original_field = "60FC5DEEB2B572B1AF1F2074AB4AF616", hash_generated_field = "1E7A5C7D54DDFE5A1728DE2BF4556F88")

    private static int EVENT_SET_CPHS_MAILBOX_DONE = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.030 -0400", hash_original_field = "B179DBEA5D80A114C092309538D3A988", hash_generated_field = "1A97DE321FCD36D31BBE1083FB238805")

    private static int EVENT_GET_INFO_CPHS_DONE = 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.030 -0400", hash_original_field = "E775C0820692BDD407C8D22F0A74404C", hash_generated_field = "C01BA6872B08834CB3086979CD931EA1")

    private static int EVENT_SET_MSISDN_DONE = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.030 -0400", hash_original_field = "44F3B6DB71F91630605B5A6876BFD3A4", hash_generated_field = "140300D784859496BD719C91C95E8DAF")

    private static int EVENT_SIM_REFRESH = 31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.030 -0400", hash_original_field = "4A3450DC04C4C053A9A850983E872C19", hash_generated_field = "665BC9FB734DCF495D7B385CC8F547B4")

    private static int EVENT_GET_CFIS_DONE = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.030 -0400", hash_original_field = "B0A927A61DAD1AD86AB00D245EB2C803", hash_generated_field = "BB374D02727C27AB0849A3E57F77A666")

    private static int EVENT_GET_CSP_CPHS_DONE = 33;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.030 -0400", hash_original_field = "1B81364A8EB1E2266EAA74C0C5553905", hash_generated_field = "341396DEB003F5ABFA5D5489D5B17EE5")

    private static String[] MCCMNC_CODES_HAVING_3DIGITS_MNC = {
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

