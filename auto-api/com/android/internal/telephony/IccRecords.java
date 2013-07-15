package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.Registrant;
import android.os.RegistrantList;
import com.android.internal.telephony.gsm.UsimServiceTable;
import com.android.internal.telephony.ims.IsimRecords;

public abstract class IccRecords extends Handler implements IccConstants {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.012 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "4FEA837943E73EF5CB83661843F1AD15")

    protected PhoneBase phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.012 -0400", hash_original_field = "CE6AFE5880E7B99FB7769A5C06B95D63", hash_generated_field = "22088B3C6368949A409041586EB96D9E")

    protected RegistrantList recordsLoadedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.012 -0400", hash_original_field = "E161FE645247DA83BCE97B5DE98BEEBF", hash_generated_field = "09A069789AB8CC5E0817A1B6DEEBBCC0")

    protected int recordsToLoad;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.012 -0400", hash_original_field = "2997832A50D1A4B04AAED3D387CB11EB", hash_generated_field = "A9FC3B8D9025A6D655B1A245F81835AF")

    protected AdnRecordCache adnCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.012 -0400", hash_original_field = "BBE3651789C4BB33B521BB2F87B237BF", hash_generated_field = "E4CF9D2DBB2C21800A07826757FEB9B0")

    protected boolean recordsRequested = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.012 -0400", hash_original_field = "2DFEEFF34F62C450D96BDFD96863E5A5", hash_generated_field = "F5E4A116DF27CA0BDE1E4A1CB0E22F6A")

    public String iccid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.013 -0400", hash_original_field = "9FED76153FCC769323CBB901DE63A870", hash_generated_field = "5C261783F0E29513E72DA191E0CBD1DB")

    protected String msisdn = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.013 -0400", hash_original_field = "890A475C33FD7C1D348B7A9A80EB21F5", hash_generated_field = "0B179531BA861A08DEFFA1E2E66BDF2A")

    protected String msisdnTag = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.013 -0400", hash_original_field = "E3974F920DCB77694F80FDAA5EBEB79E", hash_generated_field = "760EF44D51C8320E0DD1D03B12165BCC")

    protected String voiceMailNum = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.013 -0400", hash_original_field = "044DF6C56B24C9F9148EE8CC28DD8B09", hash_generated_field = "3D08C9D153D4ED67FDD6E0612B5AE420")

    protected String voiceMailTag = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.013 -0400", hash_original_field = "9B76A960DB55CAF2D7C4CC734CF5F6CB", hash_generated_field = "3482F8713524A55F29C12AF4AD641DD3")

    protected String newVoiceMailNum = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.013 -0400", hash_original_field = "6885D8033A2CCFF86222E57337165FAA", hash_generated_field = "4E2A41B898A0A4294DB38CFEF3EA873E")

    protected String newVoiceMailTag = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.013 -0400", hash_original_field = "059C65B0163D9CF7CB4755ECB9DB0056", hash_generated_field = "275EC46FCEC8F62EFF931553B34C25AE")

    protected boolean isVoiceMailFixed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.013 -0400", hash_original_field = "BEE4BB250EB0A68C6642995D72FFC69A", hash_generated_field = "DC5C95C7056BF4E6F2662FF614EC5E3F")

    protected int countVoiceMessages = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.013 -0400", hash_original_field = "66357039C59208F4E88759A5FA57C6F5", hash_generated_field = "2C7829D7768AD355C84D545BEB2749F8")

    protected int mncLength = UNINITIALIZED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.013 -0400", hash_original_field = "8445B678D7C12BE3600B159E51F2A448", hash_generated_field = "66E6641F6EA793F9A67124859D71DFA8")

    protected int mailboxIndex = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.013 -0400", hash_original_field = "6CCC6A0A81B997B5773B6FEF31BFA04C", hash_generated_field = "614AE5456A5CBA179622A79E1C91F21D")

    protected String spn;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.013 -0400", hash_original_method = "5D0BAB896645CD4136C27B68F12971AB", hash_generated_method = "4E782A19F0AA85E8CF9B90DE560EC0CB")
    public  IccRecords(PhoneBase p) {
        this.phone = p;
        
        
    }

    
    public abstract void dispose();

    
    protected abstract void onRadioOffOrNotAvailable();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.014 -0400", hash_original_method = "6A785FD128F813B36570564C326DA1E7", hash_generated_method = "C75767526D5B62D6DA36A94919C5A916")
    public AdnRecordCache getAdnCache() {
        AdnRecordCache varB4EAC82CA7396A68D541C85D26508E83_1014692916 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1014692916 = adnCache;
        varB4EAC82CA7396A68D541C85D26508E83_1014692916.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1014692916;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.014 -0400", hash_original_method = "AA2893BF07782D58CCB881014444CA75", hash_generated_method = "B4BA3289934EE166A4C91924968F639F")
    public void registerForRecordsLoaded(Handler h, int what, Object obj) {
        
        Registrant r = new Registrant(h, what, obj);
        recordsLoadedRegistrants.add(r);
        {
            r.notifyRegistrant(new AsyncResult(null, null, null));
        } 
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.015 -0400", hash_original_method = "85BD367933BB3DFE6ECA4F2F00438354", hash_generated_method = "A418D778B35933284B666DF380254CC2")
    public void unregisterForRecordsLoaded(Handler h) {
        recordsLoadedRegistrants.remove(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.016 -0400", hash_original_method = "2D99B4210681FA66696D3EA5B94D1A66", hash_generated_method = "5303C9AE31661E18E8D1A819A612DF80")
    public String getIMSI() {
        String varB4EAC82CA7396A68D541C85D26508E83_1708815147 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1708815147 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1708815147.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1708815147;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.018 -0400", hash_original_method = "9D42E73ED1AA846035EF94EBFAAEA8F6", hash_generated_method = "B09E007EA4AB472156512860918C7B2D")
    public String getMsisdnNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1703792677 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1703792677 = msisdn;
        varB4EAC82CA7396A68D541C85D26508E83_1703792677.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1703792677;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.018 -0400", hash_original_method = "6AA4F1E114DCD6F9D0799C96D9A882F0", hash_generated_method = "ACC5E47B0F53007B6F83BB4BB750ECB5")
    public void setMsisdnNumber(String alphaTag, String number,
            Message onComplete) {
        msisdn = number;
        msisdnTag = alphaTag;
        log("Set MSISDN: " + msisdnTag +" " + msisdn);
        AdnRecord adn = new AdnRecord(msisdnTag, msisdn);
        new AdnRecordLoader(phone).updateEF(adn, EF_MSISDN, EF_EXT1, 1, null,
                obtainMessage(EVENT_SET_MSISDN_DONE, onComplete));
        addTaint(onComplete.getTaint());
        
        
        
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.020 -0400", hash_original_method = "E32EFED28CC433860D178485CFB4EEE4", hash_generated_method = "F7BC802FD93ED4D1D6867065B2327EB9")
    public String getMsisdnAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1537003045 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1537003045 = msisdnTag;
        varB4EAC82CA7396A68D541C85D26508E83_1537003045.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1537003045;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.021 -0400", hash_original_method = "77FFC0D98CD3CB2629C7F6A7D27E6FFF", hash_generated_method = "83517A40012007395A969B1F7CCD3373")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1250678383 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1250678383 = voiceMailNum;
        varB4EAC82CA7396A68D541C85D26508E83_1250678383.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1250678383;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.021 -0400", hash_original_method = "C90FEC698C502FA0146C0D3760005061", hash_generated_method = "5AAF6128C6366F63FC6EC9C7DB35EF71")
    public String getServiceProviderName() {
        String varB4EAC82CA7396A68D541C85D26508E83_193405797 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_193405797 = spn;
        varB4EAC82CA7396A68D541C85D26508E83_193405797.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_193405797;
        
        
    }

    
    public abstract void setVoiceMailNumber(String alphaTag, String voiceNumber,
            Message onComplete);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.022 -0400", hash_original_method = "5A91F4662DCD8CEE6B5E6A046B7A4ABC", hash_generated_method = "E206B652792E48C9D67843BACE140608")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1724570736 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1724570736 = voiceMailTag;
        varB4EAC82CA7396A68D541C85D26508E83_1724570736.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1724570736;
        
        
    }

    
    public abstract void setVoiceMessageWaiting(int line, int countWaiting);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.023 -0400", hash_original_method = "2B603A0C333C2CCE42826636EDAB70FC", hash_generated_method = "68F75E82E2A5D626B5EA14036B43A068")
    public boolean getVoiceMessageWaiting() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_983163077 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_983163077;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.023 -0400", hash_original_method = "E7F9312CD80A2D040F1A458CAC0EDAD1", hash_generated_method = "85D51C1F483B95093B2EFE3C2EDE67E2")
    public int getVoiceMessageCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1427883275 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1427883275;
        
        
    }

    
    public abstract void onRefresh(boolean fileChanged, int[] fileList);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.023 -0400", hash_original_method = "4C58BD1C1A36FD4BA9D906F07C4CE729", hash_generated_method = "2F976D6388B4BA64D353BEA573A190F3")
    public boolean getRecordsLoaded() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2077224127 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2077224127;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.024 -0400", hash_original_method = "49E7794891C738A256F21E277C3A3E98", hash_generated_method = "80AEC7A00202470781BD26782A2788A0")
    @Override
    public void handleMessage(Message msg) {
        
        try 
        {
            AsyncResult ar = (AsyncResult) msg.obj;
            IccRecordLoaded recordLoaded = (IccRecordLoaded) ar.userObj;
            log(recordLoaded.getEfName() + " LOADED");
            {
                loge("Record Load Exception: " + ar.exception);
            } 
            {
                recordLoaded.onRecordLoaded(ar);
            } 
        } 
        catch (RuntimeException exc)
        {
            loge("Exception parsing SIM record: " + exc);
        } 
        finally 
        {
            onRecordLoaded();
        } 
        
        
        super.handleMessage(msg);
        
        addTaint(msg.getTaint());
        
        
    }

    
    protected abstract void onRecordLoaded();

    
    protected abstract void onAllRecordsLoaded();

    
    public abstract int getDisplayRule(String plmn);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.025 -0400", hash_original_method = "CF0496644C3B01F406F298A44D1902AC", hash_generated_method = "89059B7D9A2D53C2E8C2CF840DF6365A")
    public boolean isCspPlmnEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_504286168 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_504286168;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.025 -0400", hash_original_method = "9AAC604385E70B59FD0C2282B5610980", hash_generated_method = "0DB6B4E98E60BA9F9278BC52B1A42C1D")
    public String getOperatorNumeric() {
        String varB4EAC82CA7396A68D541C85D26508E83_895920628 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_895920628 = null;
        varB4EAC82CA7396A68D541C85D26508E83_895920628.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_895920628;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.025 -0400", hash_original_method = "2E5510735E3E74118CEEB63E6C24CB4C", hash_generated_method = "E3FE7D3503123A4791288592746540AD")
    public boolean getVoiceCallForwardingFlag() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1172094130 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1172094130;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.025 -0400", hash_original_method = "C3DD6C998A7A28E21EC84968A9C4D811", hash_generated_method = "63517DD32CDF7652FFE9B51B2847F051")
    public void setVoiceCallForwardingFlag(int line, boolean enable) {
        addTaint(line);
        addTaint(enable);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.026 -0400", hash_original_method = "964BBC8F82C6DDB6B82192B110CE37ED", hash_generated_method = "0D9C8961043EAE0E0273D0A1CF45177E")
    public boolean isProvisioned() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1919312869 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1919312869;
        
        
    }

    
    protected abstract void log(String s);

    
    protected abstract void loge(String s);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.026 -0400", hash_original_method = "F728AE330C688766112F3603C63CB40C", hash_generated_method = "7B4B6EF60A9DCD99A3C0FEA176531F21")
    public IsimRecords getIsimRecords() {
        IsimRecords varB4EAC82CA7396A68D541C85D26508E83_1376652477 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1376652477 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1376652477.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1376652477;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.027 -0400", hash_original_method = "EA614E93014D97DC1971866BFCB21C89", hash_generated_method = "0CE26B7437845B5049D88778D9E53153")
    public UsimServiceTable getUsimServiceTable() {
        UsimServiceTable varB4EAC82CA7396A68D541C85D26508E83_1961308541 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1961308541 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1961308541.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1961308541;
        
        
    }

    
    public interface IccRecordLoaded {
        String getEfName();
        void onRecordLoaded(AsyncResult ar);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.027 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "5F5E7D64B04175B8FA820B2440F700FC")

    protected static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.027 -0400", hash_original_field = "EF27A672194BF2DDB7CBC8D0535D8953", hash_generated_field = "8B6AA5DF16E5C850121B000B6D8B8D16")

    protected static final int UNINITIALIZED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.027 -0400", hash_original_field = "94E61C192E6109B85BABEC62149624F0", hash_generated_field = "6BA747F5F6BD077EF3A8E77E98D221F5")

    protected static final int UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.027 -0400", hash_original_field = "EFFB07E9493825FFF5E2ADA97E52DB66", hash_generated_field = "3DE22AF8463CED644F8E2D74104B8D6F")

    protected static final int SPN_RULE_SHOW_SPN = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.027 -0400", hash_original_field = "F99FB3994E948E7784AB738BF033D56D", hash_generated_field = "2E2F4B40667BB48FB273B4095F5E6A8B")

    protected static final int SPN_RULE_SHOW_PLMN = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.027 -0400", hash_original_field = "E775C0820692BDD407C8D22F0A74404C", hash_generated_field = "154CF877331315935C82771B08D9BDA4")

    protected static final int EVENT_SET_MSISDN_DONE = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.027 -0400", hash_original_field = "0A972FE25242FB826FD44BF5DFB0C4FC", hash_generated_field = "CA143425A6D690BC70A39E8E55BD298C")

    public static final int EVENT_GET_ICC_RECORD_DONE = 100;
}

