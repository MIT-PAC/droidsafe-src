package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.Registrant;
import android.os.RegistrantList;
import com.android.internal.telephony.gsm.UsimServiceTable;
import com.android.internal.telephony.ims.IsimRecords;

public abstract class IccRecords extends Handler implements IccConstants {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.648 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "4FEA837943E73EF5CB83661843F1AD15")

    protected PhoneBase phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.648 -0400", hash_original_field = "CE6AFE5880E7B99FB7769A5C06B95D63", hash_generated_field = "22088B3C6368949A409041586EB96D9E")

    protected RegistrantList recordsLoadedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.648 -0400", hash_original_field = "E161FE645247DA83BCE97B5DE98BEEBF", hash_generated_field = "09A069789AB8CC5E0817A1B6DEEBBCC0")

    protected int recordsToLoad;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.648 -0400", hash_original_field = "2997832A50D1A4B04AAED3D387CB11EB", hash_generated_field = "A9FC3B8D9025A6D655B1A245F81835AF")

    protected AdnRecordCache adnCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.648 -0400", hash_original_field = "BBE3651789C4BB33B521BB2F87B237BF", hash_generated_field = "E4CF9D2DBB2C21800A07826757FEB9B0")

    protected boolean recordsRequested = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.648 -0400", hash_original_field = "2DFEEFF34F62C450D96BDFD96863E5A5", hash_generated_field = "F5E4A116DF27CA0BDE1E4A1CB0E22F6A")

    public String iccid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.648 -0400", hash_original_field = "9FED76153FCC769323CBB901DE63A870", hash_generated_field = "5C261783F0E29513E72DA191E0CBD1DB")

    protected String msisdn = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.648 -0400", hash_original_field = "890A475C33FD7C1D348B7A9A80EB21F5", hash_generated_field = "0B179531BA861A08DEFFA1E2E66BDF2A")

    protected String msisdnTag = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.648 -0400", hash_original_field = "E3974F920DCB77694F80FDAA5EBEB79E", hash_generated_field = "760EF44D51C8320E0DD1D03B12165BCC")

    protected String voiceMailNum = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.648 -0400", hash_original_field = "044DF6C56B24C9F9148EE8CC28DD8B09", hash_generated_field = "3D08C9D153D4ED67FDD6E0612B5AE420")

    protected String voiceMailTag = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.648 -0400", hash_original_field = "9B76A960DB55CAF2D7C4CC734CF5F6CB", hash_generated_field = "3482F8713524A55F29C12AF4AD641DD3")

    protected String newVoiceMailNum = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.648 -0400", hash_original_field = "6885D8033A2CCFF86222E57337165FAA", hash_generated_field = "4E2A41B898A0A4294DB38CFEF3EA873E")

    protected String newVoiceMailTag = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.648 -0400", hash_original_field = "059C65B0163D9CF7CB4755ECB9DB0056", hash_generated_field = "275EC46FCEC8F62EFF931553B34C25AE")

    protected boolean isVoiceMailFixed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.648 -0400", hash_original_field = "BEE4BB250EB0A68C6642995D72FFC69A", hash_generated_field = "DC5C95C7056BF4E6F2662FF614EC5E3F")

    protected int countVoiceMessages = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.648 -0400", hash_original_field = "66357039C59208F4E88759A5FA57C6F5", hash_generated_field = "2C7829D7768AD355C84D545BEB2749F8")

    protected int mncLength = UNINITIALIZED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.648 -0400", hash_original_field = "8445B678D7C12BE3600B159E51F2A448", hash_generated_field = "66E6641F6EA793F9A67124859D71DFA8")

    protected int mailboxIndex = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.648 -0400", hash_original_field = "6CCC6A0A81B997B5773B6FEF31BFA04C", hash_generated_field = "614AE5456A5CBA179622A79E1C91F21D")

    protected String spn;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.662 -0400", hash_original_method = "5D0BAB896645CD4136C27B68F12971AB", hash_generated_method = "4E782A19F0AA85E8CF9B90DE560EC0CB")
    public  IccRecords(PhoneBase p) {
        this.phone = p;
        // ---------- Original Method ----------
        //this.phone = p;
    }

    
    public abstract void dispose();

    
    protected abstract void onRadioOffOrNotAvailable();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.663 -0400", hash_original_method = "6A785FD128F813B36570564C326DA1E7", hash_generated_method = "B9F52DD2FEC14D0A395609BA892B206D")
    public AdnRecordCache getAdnCache() {
        AdnRecordCache varB4EAC82CA7396A68D541C85D26508E83_756252095 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_756252095 = adnCache;
        varB4EAC82CA7396A68D541C85D26508E83_756252095.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_756252095;
        // ---------- Original Method ----------
        //return adnCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.663 -0400", hash_original_method = "AA2893BF07782D58CCB881014444CA75", hash_generated_method = "1D0FE5EAC5412F2CBDBBF56D22189AEC")
    public void registerForRecordsLoaded(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r;
        r = new Registrant(h, what, obj);
        recordsLoadedRegistrants.add(r);
        {
            r.notifyRegistrant(new AsyncResult(null, null, null));
        } //End block
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //recordsLoadedRegistrants.add(r);
        //if (recordsToLoad == 0 && recordsRequested == true) {
            //r.notifyRegistrant(new AsyncResult(null, null, null));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.663 -0400", hash_original_method = "85BD367933BB3DFE6ECA4F2F00438354", hash_generated_method = "A418D778B35933284B666DF380254CC2")
    public void unregisterForRecordsLoaded(Handler h) {
        recordsLoadedRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //recordsLoadedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.664 -0400", hash_original_method = "2D99B4210681FA66696D3EA5B94D1A66", hash_generated_method = "796539039EF4B9F6CFFE995DEFE54A80")
    public String getIMSI() {
        String varB4EAC82CA7396A68D541C85D26508E83_1863305642 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1863305642 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1863305642.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1863305642;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.676 -0400", hash_original_method = "9D42E73ED1AA846035EF94EBFAAEA8F6", hash_generated_method = "E71F3F0F5A82F32E5B3C0C67C4C3CA2F")
    public String getMsisdnNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1307183443 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1307183443 = msisdn;
        varB4EAC82CA7396A68D541C85D26508E83_1307183443.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1307183443;
        // ---------- Original Method ----------
        //return msisdn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.677 -0400", hash_original_method = "6AA4F1E114DCD6F9D0799C96D9A882F0", hash_generated_method = "3EE95CC1384B4E69D501B2C2BDF14CD9")
    public void setMsisdnNumber(String alphaTag, String number,
            Message onComplete) {
        msisdn = number;
        msisdnTag = alphaTag;
        log("Set MSISDN: " + msisdnTag +" " + msisdn);
        AdnRecord adn;
        adn = new AdnRecord(msisdnTag, msisdn);
        new AdnRecordLoader(phone).updateEF(adn, EF_MSISDN, EF_EXT1, 1, null,
                obtainMessage(EVENT_SET_MSISDN_DONE, onComplete));
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //msisdn = number;
        //msisdnTag = alphaTag;
        //if(DBG) log("Set MSISDN: " + msisdnTag +" " + msisdn);
        //AdnRecord adn = new AdnRecord(msisdnTag, msisdn);
        //new AdnRecordLoader(phone).updateEF(adn, EF_MSISDN, EF_EXT1, 1, null,
                //obtainMessage(EVENT_SET_MSISDN_DONE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.678 -0400", hash_original_method = "E32EFED28CC433860D178485CFB4EEE4", hash_generated_method = "BF64108CD332A67151D5AF4701D71CB7")
    public String getMsisdnAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1677756850 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1677756850 = msisdnTag;
        varB4EAC82CA7396A68D541C85D26508E83_1677756850.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1677756850;
        // ---------- Original Method ----------
        //return msisdnTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.682 -0400", hash_original_method = "77FFC0D98CD3CB2629C7F6A7D27E6FFF", hash_generated_method = "1A10200DCBA64817ED23397F532B6131")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1527386267 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1527386267 = voiceMailNum;
        varB4EAC82CA7396A68D541C85D26508E83_1527386267.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1527386267;
        // ---------- Original Method ----------
        //return voiceMailNum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.682 -0400", hash_original_method = "C90FEC698C502FA0146C0D3760005061", hash_generated_method = "26DA72F193132F476B582FE2A3749E5D")
    public String getServiceProviderName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2092950800 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2092950800 = spn;
        varB4EAC82CA7396A68D541C85D26508E83_2092950800.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2092950800;
        // ---------- Original Method ----------
        //return spn;
    }

    
    public abstract void setVoiceMailNumber(String alphaTag, String voiceNumber,
            Message onComplete);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.686 -0400", hash_original_method = "5A91F4662DCD8CEE6B5E6A046B7A4ABC", hash_generated_method = "F741B465155224534EA34C171F4AC7FC")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1462389696 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1462389696 = voiceMailTag;
        varB4EAC82CA7396A68D541C85D26508E83_1462389696.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1462389696;
        // ---------- Original Method ----------
        //return voiceMailTag;
    }

    
    public abstract void setVoiceMessageWaiting(int line, int countWaiting);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.687 -0400", hash_original_method = "2B603A0C333C2CCE42826636EDAB70FC", hash_generated_method = "BC1EEDE00B22F411A2C63C65F0F6021D")
    public boolean getVoiceMessageWaiting() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_903380581 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_903380581;
        // ---------- Original Method ----------
        //return countVoiceMessages != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.701 -0400", hash_original_method = "E7F9312CD80A2D040F1A458CAC0EDAD1", hash_generated_method = "DD9F2DBB2A49EEADB57CA4064286BD99")
    public int getVoiceMessageCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_864205153 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_864205153;
        // ---------- Original Method ----------
        //return countVoiceMessages;
    }

    
    public abstract void onRefresh(boolean fileChanged, int[] fileList);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.705 -0400", hash_original_method = "4C58BD1C1A36FD4BA9D906F07C4CE729", hash_generated_method = "849B7256A8CBA9D3AA3171F4AFE7915E")
    public boolean getRecordsLoaded() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_668304681 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_668304681;
        // ---------- Original Method ----------
        //if (recordsToLoad == 0 && recordsRequested == true) {
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.705 -0400", hash_original_method = "49E7794891C738A256F21E277C3A3E98", hash_generated_method = "7EEFBC69A45E045C7384406F9773A0F1")
    @Override
    public void handleMessage(Message msg) {
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
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected abstract void onRecordLoaded();

    
    protected abstract void onAllRecordsLoaded();

    
    public abstract int getDisplayRule(String plmn);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.714 -0400", hash_original_method = "CF0496644C3B01F406F298A44D1902AC", hash_generated_method = "79C9FF509FF4F726380725A881B88E66")
    public boolean isCspPlmnEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1566032252 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1566032252;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.714 -0400", hash_original_method = "9AAC604385E70B59FD0C2282B5610980", hash_generated_method = "CE086B7733875472FB222667F69092D1")
    public String getOperatorNumeric() {
        String varB4EAC82CA7396A68D541C85D26508E83_1241637100 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1241637100 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1241637100.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1241637100;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.714 -0400", hash_original_method = "2E5510735E3E74118CEEB63E6C24CB4C", hash_generated_method = "9BFB42B53FE46B0166B4BA4EBA20585F")
    public boolean getVoiceCallForwardingFlag() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1600760493 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1600760493;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.715 -0400", hash_original_method = "C3DD6C998A7A28E21EC84968A9C4D811", hash_generated_method = "63517DD32CDF7652FFE9B51B2847F051")
    public void setVoiceCallForwardingFlag(int line, boolean enable) {
        addTaint(line);
        addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.715 -0400", hash_original_method = "964BBC8F82C6DDB6B82192B110CE37ED", hash_generated_method = "F9C7B173DA2452EF5431B80EC161A21A")
    public boolean isProvisioned() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_330785353 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_330785353;
        // ---------- Original Method ----------
        //return true;
    }

    
    protected abstract void log(String s);

    
    protected abstract void loge(String s);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.726 -0400", hash_original_method = "F728AE330C688766112F3603C63CB40C", hash_generated_method = "1381870128C31B406EA626F146CABFFF")
    public IsimRecords getIsimRecords() {
        IsimRecords varB4EAC82CA7396A68D541C85D26508E83_1481266840 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1481266840 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1481266840.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1481266840;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.728 -0400", hash_original_method = "EA614E93014D97DC1971866BFCB21C89", hash_generated_method = "9A6B9FF9BC49BD32712E02176917CB9A")
    public UsimServiceTable getUsimServiceTable() {
        UsimServiceTable varB4EAC82CA7396A68D541C85D26508E83_2021509630 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2021509630 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2021509630.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2021509630;
        // ---------- Original Method ----------
        //return null;
    }

    
    public interface IccRecordLoaded {
        String getEfName();
        void onRecordLoaded(AsyncResult ar);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.729 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "D751668EF011EB030075908D0A6ACFD9")

    protected static boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.729 -0400", hash_original_field = "EF27A672194BF2DDB7CBC8D0535D8953", hash_generated_field = "7F624F9C97836A0AD18782D516565CC6")

    protected static int UNINITIALIZED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.729 -0400", hash_original_field = "94E61C192E6109B85BABEC62149624F0", hash_generated_field = "F647170503A90B6C98D3E778091DD72B")

    protected static int UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.729 -0400", hash_original_field = "EFFB07E9493825FFF5E2ADA97E52DB66", hash_generated_field = "AF17253D4301675EA2F752A47B4BB138")

    protected static int SPN_RULE_SHOW_SPN = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.729 -0400", hash_original_field = "F99FB3994E948E7784AB738BF033D56D", hash_generated_field = "6104CBF876991F987B329E96026592A3")

    protected static int SPN_RULE_SHOW_PLMN = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.729 -0400", hash_original_field = "E775C0820692BDD407C8D22F0A74404C", hash_generated_field = "7DAB2BBCBED7765DE05F254AD2618117")

    protected static int EVENT_SET_MSISDN_DONE = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.729 -0400", hash_original_field = "0A972FE25242FB826FD44BF5DFB0C4FC", hash_generated_field = "CA143425A6D690BC70A39E8E55BD298C")

    public static final int EVENT_GET_ICC_RECORD_DONE = 100;
}

