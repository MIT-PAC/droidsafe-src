package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.Registrant;
import android.os.RegistrantList;

import com.android.internal.telephony.gsm.UsimServiceTable;
import com.android.internal.telephony.ims.IsimRecords;






public abstract class IccRecords extends Handler implements IccConstants {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.245 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "4FEA837943E73EF5CB83661843F1AD15")

    protected PhoneBase phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.245 -0400", hash_original_field = "CE6AFE5880E7B99FB7769A5C06B95D63", hash_generated_field = "22088B3C6368949A409041586EB96D9E")

    protected RegistrantList recordsLoadedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.245 -0400", hash_original_field = "E161FE645247DA83BCE97B5DE98BEEBF", hash_generated_field = "09A069789AB8CC5E0817A1B6DEEBBCC0")

    protected int recordsToLoad;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.245 -0400", hash_original_field = "2997832A50D1A4B04AAED3D387CB11EB", hash_generated_field = "A9FC3B8D9025A6D655B1A245F81835AF")

    protected AdnRecordCache adnCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.245 -0400", hash_original_field = "BBE3651789C4BB33B521BB2F87B237BF", hash_generated_field = "E4CF9D2DBB2C21800A07826757FEB9B0")

    protected boolean recordsRequested = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.245 -0400", hash_original_field = "2DFEEFF34F62C450D96BDFD96863E5A5", hash_generated_field = "F5E4A116DF27CA0BDE1E4A1CB0E22F6A")

    public String iccid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.245 -0400", hash_original_field = "9FED76153FCC769323CBB901DE63A870", hash_generated_field = "5C261783F0E29513E72DA191E0CBD1DB")

    protected String msisdn = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.245 -0400", hash_original_field = "890A475C33FD7C1D348B7A9A80EB21F5", hash_generated_field = "0B179531BA861A08DEFFA1E2E66BDF2A")

    protected String msisdnTag = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.246 -0400", hash_original_field = "E3974F920DCB77694F80FDAA5EBEB79E", hash_generated_field = "760EF44D51C8320E0DD1D03B12165BCC")

    protected String voiceMailNum = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.246 -0400", hash_original_field = "044DF6C56B24C9F9148EE8CC28DD8B09", hash_generated_field = "3D08C9D153D4ED67FDD6E0612B5AE420")

    protected String voiceMailTag = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.246 -0400", hash_original_field = "9B76A960DB55CAF2D7C4CC734CF5F6CB", hash_generated_field = "3482F8713524A55F29C12AF4AD641DD3")

    protected String newVoiceMailNum = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.246 -0400", hash_original_field = "6885D8033A2CCFF86222E57337165FAA", hash_generated_field = "4E2A41B898A0A4294DB38CFEF3EA873E")

    protected String newVoiceMailTag = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.246 -0400", hash_original_field = "059C65B0163D9CF7CB4755ECB9DB0056", hash_generated_field = "275EC46FCEC8F62EFF931553B34C25AE")

    protected boolean isVoiceMailFixed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.246 -0400", hash_original_field = "BEE4BB250EB0A68C6642995D72FFC69A", hash_generated_field = "DC5C95C7056BF4E6F2662FF614EC5E3F")

    protected int countVoiceMessages = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.246 -0400", hash_original_field = "66357039C59208F4E88759A5FA57C6F5", hash_generated_field = "2C7829D7768AD355C84D545BEB2749F8")

    protected int mncLength = UNINITIALIZED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.246 -0400", hash_original_field = "8445B678D7C12BE3600B159E51F2A448", hash_generated_field = "66E6641F6EA793F9A67124859D71DFA8")

    protected int mailboxIndex = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.246 -0400", hash_original_field = "6CCC6A0A81B997B5773B6FEF31BFA04C", hash_generated_field = "614AE5456A5CBA179622A79E1C91F21D")

    protected String spn;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.247 -0400", hash_original_method = "5D0BAB896645CD4136C27B68F12971AB", hash_generated_method = "4E782A19F0AA85E8CF9B90DE560EC0CB")
    public  IccRecords(PhoneBase p) {
        this.phone = p;
        // ---------- Original Method ----------
        //this.phone = p;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void dispose();

    
    @DSModeled(DSC.SAFE)
    protected abstract void onRadioOffOrNotAvailable();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.248 -0400", hash_original_method = "6A785FD128F813B36570564C326DA1E7", hash_generated_method = "AAA656E1480C63A59FB3CDAF9217D98D")
    public AdnRecordCache getAdnCache() {
AdnRecordCache var4ED98ED4BD77B968DC13FD5EAEE1ABE5_1213133390 =         adnCache;
        var4ED98ED4BD77B968DC13FD5EAEE1ABE5_1213133390.addTaint(taint);
        return var4ED98ED4BD77B968DC13FD5EAEE1ABE5_1213133390;
        // ---------- Original Method ----------
        //return adnCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.248 -0400", hash_original_method = "AA2893BF07782D58CCB881014444CA75", hash_generated_method = "BCC2B350C285779830E5A26E644C99FF")
    public void registerForRecordsLoaded(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        Registrant r = new Registrant(h, what, obj);
        recordsLoadedRegistrants.add(r);
        if(recordsToLoad == 0 && recordsRequested == true)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.249 -0400", hash_original_method = "85BD367933BB3DFE6ECA4F2F00438354", hash_generated_method = "FFD9E7C07D6CC8612DD165A8E6FCEC93")
    public void unregisterForRecordsLoaded(Handler h) {
        addTaint(h.getTaint());
        recordsLoadedRegistrants.remove(h);
        // ---------- Original Method ----------
        //recordsLoadedRegistrants.remove(h);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.249 -0400", hash_original_method = "2D99B4210681FA66696D3EA5B94D1A66", hash_generated_method = "84D939417D770EAE42EF53DE1FA50AAB")
    public String getIMSI() {
String var540C13E9E156B687226421B24F2DF178_2045256484 =         null;
        var540C13E9E156B687226421B24F2DF178_2045256484.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2045256484;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.249 -0400", hash_original_method = "9D42E73ED1AA846035EF94EBFAAEA8F6", hash_generated_method = "F76F68B661FEE9FD237FB75FA2A09D62")
    public String getMsisdnNumber() {
String var98EB500E04B2E653D67441C7876346A8_2057031109 =         msisdn;
        var98EB500E04B2E653D67441C7876346A8_2057031109.addTaint(taint);
        return var98EB500E04B2E653D67441C7876346A8_2057031109;
        // ---------- Original Method ----------
        //return msisdn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.250 -0400", hash_original_method = "6AA4F1E114DCD6F9D0799C96D9A882F0", hash_generated_method = "13D12B4F0E480E37095EBB90CFF1B24E")
    public void setMsisdnNumber(String alphaTag, String number,
            Message onComplete) {
        addTaint(onComplete.getTaint());
        msisdn = number;
        msisdnTag = alphaTag;
        if(DBG)        
        log("Set MSISDN: " + msisdnTag +" " + msisdn);
        AdnRecord adn = new AdnRecord(msisdnTag, msisdn);
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.250 -0400", hash_original_method = "E32EFED28CC433860D178485CFB4EEE4", hash_generated_method = "057FCE2B43C86AD2633FCFB033793B71")
    public String getMsisdnAlphaTag() {
String varC96C703C1B21896256515C79C6D4E9E0_275477810 =         msisdnTag;
        varC96C703C1B21896256515C79C6D4E9E0_275477810.addTaint(taint);
        return varC96C703C1B21896256515C79C6D4E9E0_275477810;
        // ---------- Original Method ----------
        //return msisdnTag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.251 -0400", hash_original_method = "77FFC0D98CD3CB2629C7F6A7D27E6FFF", hash_generated_method = "E4A7DFBE55B446A6998135DDD5A14C8A")
    public String getVoiceMailNumber() {
String var44EE7E1B561BBC95B6BC657CD14BC65B_780904334 =         voiceMailNum;
        var44EE7E1B561BBC95B6BC657CD14BC65B_780904334.addTaint(taint);
        return var44EE7E1B561BBC95B6BC657CD14BC65B_780904334;
        // ---------- Original Method ----------
        //return voiceMailNum;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.251 -0400", hash_original_method = "C90FEC698C502FA0146C0D3760005061", hash_generated_method = "327A3BBA9F81BDF127FF02AC02A1900B")
    public String getServiceProviderName() {
String var45568158EF0C540A1756B7B70BA9D156_1447635608 =         spn;
        var45568158EF0C540A1756B7B70BA9D156_1447635608.addTaint(taint);
        return var45568158EF0C540A1756B7B70BA9D156_1447635608;
        // ---------- Original Method ----------
        //return spn;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void setVoiceMailNumber(String alphaTag, String voiceNumber,
            Message onComplete);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.251 -0400", hash_original_method = "5A91F4662DCD8CEE6B5E6A046B7A4ABC", hash_generated_method = "C1A2DD41ABB5DD4DEE4F0DC61A8C5124")
    public String getVoiceMailAlphaTag() {
String var1EB462B75D8B935982B4AE1475F7B8DA_552556596 =         voiceMailTag;
        var1EB462B75D8B935982B4AE1475F7B8DA_552556596.addTaint(taint);
        return var1EB462B75D8B935982B4AE1475F7B8DA_552556596;
        // ---------- Original Method ----------
        //return voiceMailTag;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void setVoiceMessageWaiting(int line, int countWaiting);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.252 -0400", hash_original_method = "2B603A0C333C2CCE42826636EDAB70FC", hash_generated_method = "26DF685D6D3E316FA1E3C894D1FBE71A")
    public boolean getVoiceMessageWaiting() {
        boolean var1B4A0414ACDECE5FA211338E2DCC557C_117269419 = (countVoiceMessages != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1233243934 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1233243934;
        // ---------- Original Method ----------
        //return countVoiceMessages != 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.252 -0400", hash_original_method = "E7F9312CD80A2D040F1A458CAC0EDAD1", hash_generated_method = "74A6B3C25244FC97C58F1FF955C6C6FC")
    public int getVoiceMessageCount() {
        int var5B28E5DDF9BF49AEC54D23CA586EEF5F_1719375571 = (countVoiceMessages);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1923167486 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1923167486;
        // ---------- Original Method ----------
        //return countVoiceMessages;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void onRefresh(boolean fileChanged, int[] fileList);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.253 -0400", hash_original_method = "4C58BD1C1A36FD4BA9D906F07C4CE729", hash_generated_method = "E50E7A7005717D3C7373FA83E991279C")
    public boolean getRecordsLoaded() {
        if(recordsToLoad == 0 && recordsRequested == true)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_289010324 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1378642310 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1378642310;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_331915188 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1316506115 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1316506115;
        } //End block
        // ---------- Original Method ----------
        //if (recordsToLoad == 0 && recordsRequested == true) {
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.254 -0400", hash_original_method = "49E7794891C738A256F21E277C3A3E98", hash_generated_method = "99680DAE96A48AC1006B052AB1C0345C")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
switch(msg.what){
        case EVENT_GET_ICC_RECORD_DONE:
        try 
        {
            AsyncResult ar = (AsyncResult) msg.obj;
            IccRecordLoaded recordLoaded = (IccRecordLoaded) ar.userObj;
            if(DBG)            
            log(recordLoaded.getEfName() + " LOADED");
            if(ar.exception != null)            
            {
                loge("Record Load Exception: " + ar.exception);
            } //End block
            else
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
        break;
        default:
        super.handleMessage(msg);
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void onRecordLoaded();

    
    @DSModeled(DSC.SAFE)
    protected abstract void onAllRecordsLoaded();

    
    @DSModeled(DSC.SAFE)
    public abstract int getDisplayRule(String plmn);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.255 -0400", hash_original_method = "CF0496644C3B01F406F298A44D1902AC", hash_generated_method = "C5ED6D65436DD679943C2AF1D7FC9DD6")
    public boolean isCspPlmnEnabled() {
        boolean var68934A3E9455FA72420237EB05902327_1945316238 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2051291835 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2051291835;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.255 -0400", hash_original_method = "9AAC604385E70B59FD0C2282B5610980", hash_generated_method = "D1C793E30B703A654E5325142147DAE8")
    public String getOperatorNumeric() {
String var540C13E9E156B687226421B24F2DF178_1369680717 =         null;
        var540C13E9E156B687226421B24F2DF178_1369680717.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1369680717;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.256 -0400", hash_original_method = "2E5510735E3E74118CEEB63E6C24CB4C", hash_generated_method = "622957C7136007D168F9200A40EDAF6C")
    public boolean getVoiceCallForwardingFlag() {
        boolean var68934A3E9455FA72420237EB05902327_1056592059 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_774256856 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_774256856;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.256 -0400", hash_original_method = "C3DD6C998A7A28E21EC84968A9C4D811", hash_generated_method = "8041BF51A09C772195BC7BF6F8F56431")
    public void setVoiceCallForwardingFlag(int line, boolean enable) {
        addTaint(enable);
        addTaint(line);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.256 -0400", hash_original_method = "964BBC8F82C6DDB6B82192B110CE37ED", hash_generated_method = "5D55D909B1B935A59A722AC0C8927CAF")
    public boolean isProvisioned() {
        boolean varB326B5062B2F0E69046810717534CB09_603539078 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1672991501 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1672991501;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void log(String s);

    
    @DSModeled(DSC.SAFE)
    protected abstract void loge(String s);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.257 -0400", hash_original_method = "F728AE330C688766112F3603C63CB40C", hash_generated_method = "F58AF9131E7139C7C0009950EAD990B0")
    public IsimRecords getIsimRecords() {
IsimRecords var540C13E9E156B687226421B24F2DF178_1442920481 =         null;
        var540C13E9E156B687226421B24F2DF178_1442920481.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1442920481;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.257 -0400", hash_original_method = "EA614E93014D97DC1971866BFCB21C89", hash_generated_method = "824231BAED8B9018D25BBC869E3060FE")
    public UsimServiceTable getUsimServiceTable() {
UsimServiceTable var540C13E9E156B687226421B24F2DF178_1805569054 =         null;
        var540C13E9E156B687226421B24F2DF178_1805569054.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1805569054;
        // ---------- Original Method ----------
        //return null;
    }

    
    public interface IccRecordLoaded {
        String getEfName();
        void onRecordLoaded(AsyncResult ar);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.257 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "5F5E7D64B04175B8FA820B2440F700FC")

    protected static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.257 -0400", hash_original_field = "EF27A672194BF2DDB7CBC8D0535D8953", hash_generated_field = "8B6AA5DF16E5C850121B000B6D8B8D16")

    protected static final int UNINITIALIZED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.257 -0400", hash_original_field = "94E61C192E6109B85BABEC62149624F0", hash_generated_field = "6BA747F5F6BD077EF3A8E77E98D221F5")

    protected static final int UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.257 -0400", hash_original_field = "EFFB07E9493825FFF5E2ADA97E52DB66", hash_generated_field = "3DE22AF8463CED644F8E2D74104B8D6F")

    protected static final int SPN_RULE_SHOW_SPN = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.257 -0400", hash_original_field = "F99FB3994E948E7784AB738BF033D56D", hash_generated_field = "2E2F4B40667BB48FB273B4095F5E6A8B")

    protected static final int SPN_RULE_SHOW_PLMN = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.257 -0400", hash_original_field = "E775C0820692BDD407C8D22F0A74404C", hash_generated_field = "154CF877331315935C82771B08D9BDA4")

    protected static final int EVENT_SET_MSISDN_DONE = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.257 -0400", hash_original_field = "0A972FE25242FB826FD44BF5DFB0C4FC", hash_generated_field = "CA143425A6D690BC70A39E8E55BD298C")

    public static final int EVENT_GET_ICC_RECORD_DONE = 100;
}

