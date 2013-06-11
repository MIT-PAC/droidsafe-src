package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.Registrant;
import android.os.RegistrantList;
import com.android.internal.telephony.gsm.UsimServiceTable;
import com.android.internal.telephony.ims.IsimRecords;

public abstract class IccRecords extends Handler implements IccConstants {
    protected static final boolean DBG = true;
    protected PhoneBase phone;
    protected RegistrantList recordsLoadedRegistrants = new RegistrantList();
    protected int recordsToLoad;
    protected AdnRecordCache adnCache;
    protected boolean recordsRequested = false;
    public String iccid;
    protected String msisdn = null;
    protected String msisdnTag = null;
    protected String voiceMailNum = null;
    protected String voiceMailTag = null;
    protected String newVoiceMailNum = null;
    protected String newVoiceMailTag = null;
    protected boolean isVoiceMailFixed = false;
    protected int countVoiceMessages = 0;
    protected int mncLength = UNINITIALIZED;
    protected int mailboxIndex = 0;
    protected String spn;
    protected static final int UNINITIALIZED = -1;
    protected static final int UNKNOWN = 0;
    protected static final int SPN_RULE_SHOW_SPN  = 0x01;
    protected static final int SPN_RULE_SHOW_PLMN = 0x02;
    protected static final int EVENT_SET_MSISDN_DONE = 30;
    public static final int EVENT_GET_ICC_RECORD_DONE = 100;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.139 -0400", hash_original_method = "5D0BAB896645CD4136C27B68F12971AB", hash_generated_method = "EACABDB3148F0351DE51AB2ED74F1842")
    @DSModeled(DSC.SAFE)
    public IccRecords(PhoneBase p) {
        dsTaint.addTaint(p.dsTaint);
        // ---------- Original Method ----------
        //this.phone = p;
    }

    
    public abstract void dispose();

    
    protected abstract void onRadioOffOrNotAvailable();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.139 -0400", hash_original_method = "6A785FD128F813B36570564C326DA1E7", hash_generated_method = "B141C102AF99176BAEF84EE97825CC61")
    @DSModeled(DSC.SAFE)
    public AdnRecordCache getAdnCache() {
        return (AdnRecordCache)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return adnCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.139 -0400", hash_original_method = "AA2893BF07782D58CCB881014444CA75", hash_generated_method = "6FE350FDE1283519E9F61F2833B29A6A")
    @DSModeled(DSC.SAFE)
    public void registerForRecordsLoaded(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant(h, what, obj);
        recordsLoadedRegistrants.add(r);
        {
            r.notifyRegistrant(new AsyncResult(null, null, null));
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //recordsLoadedRegistrants.add(r);
        //if (recordsToLoad == 0 && recordsRequested == true) {
            //r.notifyRegistrant(new AsyncResult(null, null, null));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.139 -0400", hash_original_method = "85BD367933BB3DFE6ECA4F2F00438354", hash_generated_method = "57766B5E3490AEB4E212AD93AC11635C")
    @DSModeled(DSC.SAFE)
    public void unregisterForRecordsLoaded(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        recordsLoadedRegistrants.remove(h);
        // ---------- Original Method ----------
        //recordsLoadedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.139 -0400", hash_original_method = "2D99B4210681FA66696D3EA5B94D1A66", hash_generated_method = "2A2D90447E1053302970080376A63EEF")
    @DSModeled(DSC.SAFE)
    public String getIMSI() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.139 -0400", hash_original_method = "9D42E73ED1AA846035EF94EBFAAEA8F6", hash_generated_method = "B9E9FCA0145E22EDFC1C932A00CC9EFD")
    @DSModeled(DSC.SAFE)
    public String getMsisdnNumber() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return msisdn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.140 -0400", hash_original_method = "6AA4F1E114DCD6F9D0799C96D9A882F0", hash_generated_method = "1B9ECA3DB8C4A6B9C02EF663BAAE9960")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMsisdnNumber(String alphaTag, String number,
            Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(number);
        dsTaint.addTaint(alphaTag);
        log("Set MSISDN: " + msisdnTag +" " + msisdn);
        AdnRecord adn;
        adn = new AdnRecord(msisdnTag, msisdn);
        new AdnRecordLoader(phone).updateEF(adn, EF_MSISDN, EF_EXT1, 1, null,
                obtainMessage(EVENT_SET_MSISDN_DONE, onComplete));
        // ---------- Original Method ----------
        //msisdn = number;
        //msisdnTag = alphaTag;
        //if(DBG) log("Set MSISDN: " + msisdnTag +" " + msisdn);
        //AdnRecord adn = new AdnRecord(msisdnTag, msisdn);
        //new AdnRecordLoader(phone).updateEF(adn, EF_MSISDN, EF_EXT1, 1, null,
                //obtainMessage(EVENT_SET_MSISDN_DONE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.140 -0400", hash_original_method = "E32EFED28CC433860D178485CFB4EEE4", hash_generated_method = "1A89B95B699812DBC4364F6B2E39B576")
    @DSModeled(DSC.SAFE)
    public String getMsisdnAlphaTag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return msisdnTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.140 -0400", hash_original_method = "77FFC0D98CD3CB2629C7F6A7D27E6FFF", hash_generated_method = "5B4211F0EF645AB63EE8763DF9478B36")
    @DSModeled(DSC.SAFE)
    public String getVoiceMailNumber() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return voiceMailNum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.140 -0400", hash_original_method = "C90FEC698C502FA0146C0D3760005061", hash_generated_method = "A9195F8C5297B0BB013E9C291BF646C2")
    @DSModeled(DSC.SAFE)
    public String getServiceProviderName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return spn;
    }

    
    public abstract void setVoiceMailNumber(String alphaTag, String voiceNumber,
            Message onComplete);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.140 -0400", hash_original_method = "5A91F4662DCD8CEE6B5E6A046B7A4ABC", hash_generated_method = "E85FA05F2DC4D5EAAC6001C2122A764A")
    @DSModeled(DSC.SAFE)
    public String getVoiceMailAlphaTag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return voiceMailTag;
    }

    
    public abstract void setVoiceMessageWaiting(int line, int countWaiting);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.140 -0400", hash_original_method = "2B603A0C333C2CCE42826636EDAB70FC", hash_generated_method = "53A2FF5BA33A52DB9C049A02AD6117B3")
    @DSModeled(DSC.SAFE)
    public boolean getVoiceMessageWaiting() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return countVoiceMessages != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.140 -0400", hash_original_method = "E7F9312CD80A2D040F1A458CAC0EDAD1", hash_generated_method = "4086012FE2E896F643F8F8DAC4749693")
    @DSModeled(DSC.SAFE)
    public int getVoiceMessageCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return countVoiceMessages;
    }

    
    public abstract void onRefresh(boolean fileChanged, int[] fileList);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.140 -0400", hash_original_method = "4C58BD1C1A36FD4BA9D906F07C4CE729", hash_generated_method = "3D99C74A9D3A539AD96A9CC7CAC60535")
    @DSModeled(DSC.SAFE)
    public boolean getRecordsLoaded() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (recordsToLoad == 0 && recordsRequested == true) {
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.140 -0400", hash_original_method = "49E7794891C738A256F21E277C3A3E98", hash_generated_method = "8BB8469CD02C6ECAB0DEBB6F691A51CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        //Begin case EVENT_GET_ICC_RECORD_DONE 
        try 
        {
            AsyncResult ar;
            ar = (AsyncResult) msg.obj;
            IccRecordLoaded recordLoaded;
            recordLoaded = (IccRecordLoaded) ar.userObj;
            log(recordLoaded.getEfName() + " LOADED");
            {
                loge("Record Load Exception: " + ar.exception);
            } //End block
            {
                recordLoaded.onRecordLoaded(ar);
            } //End block
        } //End block
        catch (RuntimeException exc)
        {
            loge("Exception parsing SIM record: " + exc);
        } //End block
        finally 
        {
            onRecordLoaded();
        } //End block
        //End case EVENT_GET_ICC_RECORD_DONE 
        //Begin case default 
        super.handleMessage(msg);
        //End case default 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected abstract void onRecordLoaded();

    
    protected abstract void onAllRecordsLoaded();

    
    public abstract int getDisplayRule(String plmn);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.140 -0400", hash_original_method = "CF0496644C3B01F406F298A44D1902AC", hash_generated_method = "3AF169E77FEEB22281C4FC571E027276")
    @DSModeled(DSC.SAFE)
    public boolean isCspPlmnEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.140 -0400", hash_original_method = "9AAC604385E70B59FD0C2282B5610980", hash_generated_method = "9AF8A620AE38331B7BB1E759E1CF92EA")
    @DSModeled(DSC.SAFE)
    public String getOperatorNumeric() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.140 -0400", hash_original_method = "2E5510735E3E74118CEEB63E6C24CB4C", hash_generated_method = "EFD339E3A2B048799CBCD46712ECABC5")
    @DSModeled(DSC.SAFE)
    public boolean getVoiceCallForwardingFlag() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.140 -0400", hash_original_method = "C3DD6C998A7A28E21EC84968A9C4D811", hash_generated_method = "72DAB5E64574DE82011325FD71D5FE4C")
    @DSModeled(DSC.SAFE)
    public void setVoiceCallForwardingFlag(int line, boolean enable) {
        dsTaint.addTaint(enable);
        dsTaint.addTaint(line);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.140 -0400", hash_original_method = "964BBC8F82C6DDB6B82192B110CE37ED", hash_generated_method = "F86F471E481C62295B860B2D9D78E5C6")
    @DSModeled(DSC.SAFE)
    public boolean isProvisioned() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    protected abstract void log(String s);

    
    protected abstract void loge(String s);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.140 -0400", hash_original_method = "F728AE330C688766112F3603C63CB40C", hash_generated_method = "A7C1A4CB1ACB31193C1E5A4EF2088F9F")
    @DSModeled(DSC.SAFE)
    public IsimRecords getIsimRecords() {
        return (IsimRecords)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.140 -0400", hash_original_method = "EA614E93014D97DC1971866BFCB21C89", hash_generated_method = "9DE35927D0B5D24A43485D41AD5500D4")
    @DSModeled(DSC.SAFE)
    public UsimServiceTable getUsimServiceTable() {
        return (UsimServiceTable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    public interface IccRecordLoaded {
        String getEfName();
        void onRecordLoaded(AsyncResult ar);
    }
    
}


