package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import static android.Manifest.permission.READ_PHONE_STATE;
import android.app.ActivityManagerNative;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.Power;
import android.os.PowerManager;
import android.os.Registrant;
import android.os.RegistrantList;
import android.util.Log;
import android.view.WindowManager;
import com.android.internal.telephony.PhoneBase;
import com.android.internal.telephony.CommandsInterface.RadioState;
import com.android.internal.telephony.gsm.SIMRecords;
import android.os.SystemProperties;
import com.android.internal.R;

public abstract class IccCard {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.726 -0400", hash_original_field = "503F6607C959C61B036C1484733875DB", hash_generated_field = "621F1F8A1A73F0186C3B2A8FD458DBF8")

    protected String mLogTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.726 -0400", hash_original_field = "44ACAC101472BE8FC80671CD461C5D61", hash_generated_field = "05625C1A8AEC158E47E651E2912A02BB")

    protected boolean mDbg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.726 -0400", hash_original_field = "DE32B65E7EE0B55BC712321AEEA728A8", hash_generated_field = "9B1F8CAC61F695F54D4232EE65554395")

    private IccCardStatus mIccCardStatus = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.726 -0400", hash_original_field = "1D598FE22B106935C0C063CC508FA455", hash_generated_field = "B2CB76BA7B9E699C7A661DE6BE3920DB")

    protected State mState = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.726 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "C5284483C4CF8ED630A2E2607ED30E12")

    protected PhoneBase mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.726 -0400", hash_original_field = "4E7FCC656AA6F8FBB8616A81CB62D667", hash_generated_field = "BB4D0C0D6F697E88C9F5A7A0E99C541E")

    private RegistrantList mAbsentRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.727 -0400", hash_original_field = "6710CED66CE3362B59772BAE61AD7DD9", hash_generated_field = "7FBB4558DC3714EECB6D5E802875936C")

    private RegistrantList mPinLockedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.727 -0400", hash_original_field = "B9AB100E7FC5A76FFBE28B818830C025", hash_generated_field = "810D4E60FCDB2F59BE3AFC34BFC4D065")

    private RegistrantList mNetworkLockedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.727 -0400", hash_original_field = "1445211AF5BB90E5C392311CE390CE34", hash_generated_field = "6F5CD85185F4F8603950244B00F7B22C")

    private boolean mDesiredPinLocked;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.727 -0400", hash_original_field = "4E6FF6737A71D42C0FAB7F364606445B", hash_generated_field = "4055529E8474844347F470FAB93250EC")

    private boolean mDesiredFdnEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.727 -0400", hash_original_field = "843C2F0DC295527B0EA88ECB15133B30", hash_generated_field = "4F01E642146FEA0D727EF809A7BAFF77")

    private boolean mIccPinLocked = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.727 -0400", hash_original_field = "BF434A14237EBD649B50D12B7DBD86B8", hash_generated_field = "385C08A9E0809A77275EED9469D8B1F1")

    private boolean mIccFdnEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.729 -0400", hash_original_field = "8DDBBF399F5C4180FC40887A4067CEFE", hash_generated_field = "33F47C802D626FE59E34A5FF2AE3F321")

    protected Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.729 -0400", hash_original_method = "4D8A280AC680F77EA465CFA0E90830BC", hash_generated_method = "628A259BA249F1A1D0ECF617B0AD4CA9")
        @Override
        public void handleMessage(Message msg) {
            AsyncResult ar;
            int serviceClassX;
            serviceClassX = CommandsInterface.SERVICE_CLASS_VOICE +
                            CommandsInterface.SERVICE_CLASS_DATA +
                            CommandsInterface.SERVICE_CLASS_FAX;
            
            mState = null;
            
            
            updateStateProperty();
            
            
            broadcastIccStateChangedIntent(INTENT_VALUE_ICC_NOT_READY, null);
            
            
            mPhone.mCM.getIccCardStatus(obtainMessage(EVENT_GET_ICC_STATUS_DONE));
            
            
            mPhone.mCM.queryFacilityLock (
                            CommandsInterface.CB_FACILITY_BA_SIM, "", serviceClassX,
                            obtainMessage(EVENT_QUERY_FACILITY_LOCK_DONE));
            
            
            mPhone.mCM.queryFacilityLock (
                            CommandsInterface.CB_FACILITY_BA_FD, "", serviceClassX,
                            obtainMessage(EVENT_QUERY_FACILITY_FDN_DONE));
            
            
            mPhone.mCM.getIccCardStatus(obtainMessage(EVENT_GET_ICC_STATUS_DONE));
            
            
            mPhone.mCM.queryFacilityLock (
                            CommandsInterface.CB_FACILITY_BA_SIM, "", serviceClassX,
                            obtainMessage(EVENT_QUERY_FACILITY_LOCK_DONE));
            
            
            ar = (AsyncResult)msg.obj;
            
            
            getIccCardStatusDone(ar);
            
            
            ar = (AsyncResult)msg.obj;
            
            
            AsyncResult.forMessage(((Message)ar.userObj)).exception
                                                        = ar.exception;
            
            
            mPhone.mCM.getIccCardStatus(
                        obtainMessage(EVENT_REPOLL_STATUS_DONE, ar.userObj));
            
            
            ar = (AsyncResult)msg.obj;
            
            
            getIccCardStatusDone(ar);
            
            
            ((Message)ar.userObj).sendToTarget();
            
            
            ar = (AsyncResult)msg.obj;
            
            
            onQueryFacilityLock(ar);
            
            
            ar = (AsyncResult)msg.obj;
            
            
            onQueryFdnEnabled(ar);
            
            
            ar = (AsyncResult)msg.obj;
            
            
            {
                mIccPinLocked = mDesiredPinLocked;
                log( "EVENT_CHANGE_FACILITY_LOCK_DONE: " +
                                "mIccPinLocked= " + mIccPinLocked);
            } 
            
            
            AsyncResult.forMessage(((Message)ar.userObj)).exception
                                                        = ar.exception;
            
            
            ((Message)ar.userObj).sendToTarget();
            
            
            ar = (AsyncResult)msg.obj;
            
            
            {
                mIccFdnEnabled = mDesiredFdnEnabled;
                log("EVENT_CHANGE_FACILITY_FDN_DONE: " +
                                "mIccFdnEnabled=" + mIccFdnEnabled);
            } 
            
            
            AsyncResult.forMessage(((Message)ar.userObj)).exception
                                                        = ar.exception;
            
            
            ((Message)ar.userObj).sendToTarget();
            
            
            ar = (AsyncResult)msg.obj;
            
            
            AsyncResult.forMessage(((Message)ar.userObj)).exception
                                                        = ar.exception;
            
            
            ((Message)ar.userObj).sendToTarget();
            
            
            Log.d(mLogTag, "Received Event EVENT_ICC_STATUS_CHANGED");
            
            
            mPhone.mCM.getIccCardStatus(obtainMessage(EVENT_GET_ICC_STATUS_DONE));
            
            
            onIccSwap(false);
            
            
            onIccSwap(true);
            
            addTaint(msg.getTaint());
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.730 -0400", hash_original_method = "A83C78588609731AFA33B82B4815F4C9", hash_generated_method = "67B5BD0EE12240734C95456487DA84CE")
    public  IccCard(PhoneBase phone, String logTag, Boolean dbg) {
        mPhone = phone;
        mPhone.mCM.registerForIccStatusChanged(mHandler, EVENT_ICC_STATUS_CHANGED, null);
        mLogTag = logTag;
        mDbg = dbg;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.731 -0400", hash_original_method = "B45586395D9726A6E3A7A444B2DA9D4A", hash_generated_method = "EF179E652E069F3AB18CCBD391E9AAE0")
    public State getState() {
        State varB4EAC82CA7396A68D541C85D26508E83_1562467820 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_1815036930 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_809712314 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_1797287594 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_1411046289 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_69329251 = null; 
        {
            {
                Object var665508131374E03DAE4229BE09CD1E54_159766074 = (mPhone.mCM.getRadioState());
                
                varB4EAC82CA7396A68D541C85D26508E83_1562467820 = State.UNKNOWN;
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1815036930 = State.UNKNOWN;
                
                
                varB4EAC82CA7396A68D541C85D26508E83_809712314 = State.READY;
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1797287594 = State.ABSENT;
                
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1411046289 = mState;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_69329251 = State.UNKNOWN;
        State varA7E53CE21691AB073D9660D615818899_788007143; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_788007143 = varB4EAC82CA7396A68D541C85D26508E83_1562467820;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_788007143 = varB4EAC82CA7396A68D541C85D26508E83_1815036930;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_788007143 = varB4EAC82CA7396A68D541C85D26508E83_809712314;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_788007143 = varB4EAC82CA7396A68D541C85D26508E83_1797287594;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_788007143 = varB4EAC82CA7396A68D541C85D26508E83_1411046289;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_788007143 = varB4EAC82CA7396A68D541C85D26508E83_69329251;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_788007143.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_788007143;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.732 -0400", hash_original_method = "EF67D81D926CA0EC8F8754BC29C8826B", hash_generated_method = "8FB4003EBB7FCD2F2B0FD7E02F818470")
    public void dispose() {
        mPhone.mCM.unregisterForIccStatusChanged(mHandler);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.732 -0400", hash_original_method = "C148A728067D02A221BE75C987C5D733", hash_generated_method = "DA32AB009F09FF38C5F0C4E45A947EAB")
    protected void finalize() {
        Log.d(mLogTag, "IccCard finalized");
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.733 -0400", hash_original_method = "45A4F957AA9A104F89D6FFEF5C13C9B4", hash_generated_method = "3A2599D5D125580CC85F8231740323FF")
    public void registerForAbsent(Handler h, int what, Object obj) {
        
        Registrant r = new Registrant (h, what, obj);
        mAbsentRegistrants.add(r);
        {
            boolean var9D1D545BFB2ACC918D763D35EA51A235_45207241 = (getState() == State.ABSENT);
            {
                r.notifyRegistrant();
            } 
        } 
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.733 -0400", hash_original_method = "A388490F008524959D490318F4B49030", hash_generated_method = "1943DB3B866D01B93B4514E5831169F3")
    public void unregisterForAbsent(Handler h) {
        mAbsentRegistrants.remove(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.733 -0400", hash_original_method = "DD13D18C49861341C8AF8EABF1CC2E24", hash_generated_method = "07C34E4F9158F9F40E0CA3EC2375AB9D")
    public void registerForNetworkLocked(Handler h, int what, Object obj) {
        
        Registrant r = new Registrant (h, what, obj);
        mNetworkLockedRegistrants.add(r);
        {
            boolean var2F3573EBEB4638AFD6B56CE330BB1FB4_2126344723 = (getState() == State.NETWORK_LOCKED);
            {
                r.notifyRegistrant();
            } 
        } 
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.734 -0400", hash_original_method = "5CEB6427435BFB9EC514E781B4093E7E", hash_generated_method = "B75B86B8FD071EE3C5E9889CF4FB8D3C")
    public void unregisterForNetworkLocked(Handler h) {
        mNetworkLockedRegistrants.remove(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.734 -0400", hash_original_method = "A158B3B1FDF0C70FEF29C25B6F4DD072", hash_generated_method = "7134595698B847831E5521A8098BEE71")
    public void registerForLocked(Handler h, int what, Object obj) {
        
        Registrant r = new Registrant (h, what, obj);
        mPinLockedRegistrants.add(r);
        {
            boolean var4F041DD310E7150642EAFA2D007725C8_2118910306 = (getState().isPinLocked());
            {
                r.notifyRegistrant();
            } 
        } 
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.734 -0400", hash_original_method = "5667345A02500557814700DAC5845BCA", hash_generated_method = "2AC03AF538A32A18D598A6271B836CDD")
    public void unregisterForLocked(Handler h) {
        mPinLockedRegistrants.remove(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.735 -0400", hash_original_method = "ADEE02A4D2D0DF5B5C1110C0F3EF40D9", hash_generated_method = "D05AE6ADB4D9B2B969F70ED3A669186E")
    public void supplyPin(String pin, Message onComplete) {
        mPhone.mCM.supplyIccPin(pin, mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
        addTaint(pin.getTaint());
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.735 -0400", hash_original_method = "F069297D525546A0218C2FB5A43E0287", hash_generated_method = "E4EE9E4E2F7F9AEB25C5EA85D7646FFE")
    public void supplyPuk(String puk, String newPin, Message onComplete) {
        mPhone.mCM.supplyIccPuk(puk, newPin,
                mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
        addTaint(puk.getTaint());
        addTaint(newPin.getTaint());
        addTaint(onComplete.getTaint());
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.735 -0400", hash_original_method = "35EFF2F2C787166AB4A51F303C9455F4", hash_generated_method = "23342709D52898C81EDF643DC2337E3A")
    public void supplyPin2(String pin2, Message onComplete) {
        mPhone.mCM.supplyIccPin2(pin2,
                mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
        addTaint(pin2.getTaint());
        addTaint(onComplete.getTaint());
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.735 -0400", hash_original_method = "982062922CE016EAC29E809D9B066C8E", hash_generated_method = "F18BE459A210D03198DAFB3923570AB3")
    public void supplyPuk2(String puk2, String newPin2, Message onComplete) {
        mPhone.mCM.supplyIccPuk2(puk2, newPin2,
                mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
        addTaint(puk2.getTaint());
        addTaint(newPin2.getTaint());
        addTaint(onComplete.getTaint());
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.736 -0400", hash_original_method = "96497D4DFF6E2FE9CEEE26788CBD4E3F", hash_generated_method = "12AD4854EE8B1FA1060EE1819A28EE88")
    public void supplyNetworkDepersonalization(String pin, Message onComplete) {
        mPhone.mCM.supplyNetworkDepersonalization(pin,
                mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
        addTaint(pin.getTaint());
        addTaint(onComplete.getTaint());
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.736 -0400", hash_original_method = "BCA6EFC1210C838BF4CD916790946AA6", hash_generated_method = "1149DA1872DC2B6317BFB0297FA773D1")
    public boolean getIccLockEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_803592406 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_803592406;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.736 -0400", hash_original_method = "F2BBF6EB30564DA8841F6D4A48D01D80", hash_generated_method = "CFDB16D396D47350C30F8B8931AA7F49")
    public boolean getIccFdnEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1952738526 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1952738526;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.737 -0400", hash_original_method = "3DCE16ED303A66C1573E6E04CDCFB500", hash_generated_method = "544FD5010B449443910D20362F86013F")
    public void setIccLockEnabled(boolean enabled,
             String password, Message onComplete) {
        int serviceClassX;
        serviceClassX = CommandsInterface.SERVICE_CLASS_VOICE +
                 CommandsInterface.SERVICE_CLASS_DATA +
                 CommandsInterface.SERVICE_CLASS_FAX;
        mDesiredPinLocked = enabled;
        mPhone.mCM.setFacilityLock(CommandsInterface.CB_FACILITY_BA_SIM,
                 enabled, password, serviceClassX,
                 mHandler.obtainMessage(EVENT_CHANGE_FACILITY_LOCK_DONE, onComplete));
        addTaint(password.getTaint());
        addTaint(onComplete.getTaint());
        
        
        
                 
                 
        
        
                 
                 
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.737 -0400", hash_original_method = "42161809775FC8FDBB38BE3E5058E399", hash_generated_method = "57AE8798CB4A2225FE017AF10A1C4C38")
    public void setIccFdnEnabled(boolean enabled,
             String password, Message onComplete) {
        int serviceClassX;
        serviceClassX = CommandsInterface.SERVICE_CLASS_VOICE +
                 CommandsInterface.SERVICE_CLASS_DATA +
                 CommandsInterface.SERVICE_CLASS_FAX +
                 CommandsInterface.SERVICE_CLASS_SMS;
        mDesiredFdnEnabled = enabled;
        mPhone.mCM.setFacilityLock(CommandsInterface.CB_FACILITY_BA_FD,
                 enabled, password, serviceClassX,
                 mHandler.obtainMessage(EVENT_CHANGE_FACILITY_FDN_DONE, onComplete));
        addTaint(password.getTaint());
        addTaint(onComplete.getTaint());
        
        
        
                 
                 
                 
        
        
                 
                 
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.738 -0400", hash_original_method = "CFACBB8EE591380B6F953CA4501BCE4D", hash_generated_method = "EAD131B57FCC5B057053D037C1DA7A30")
    public void changeIccLockPassword(String oldPassword, String newPassword,
             Message onComplete) {
        mPhone.mCM.changeIccPin(oldPassword, newPassword,
                 mHandler.obtainMessage(EVENT_CHANGE_ICC_PASSWORD_DONE, onComplete));
        addTaint(oldPassword.getTaint());
        addTaint(newPassword.getTaint());
        addTaint(onComplete.getTaint());
        
        
                 
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.738 -0400", hash_original_method = "78AE6F1E64D3743DF4893D59C6AFA5E2", hash_generated_method = "BC416E50D02810623466A946D3E528B7")
    public void changeIccFdnPassword(String oldPassword, String newPassword,
             Message onComplete) {
        mPhone.mCM.changeIccPin2(oldPassword, newPassword,
                 mHandler.obtainMessage(EVENT_CHANGE_ICC_PASSWORD_DONE, onComplete));
        addTaint(oldPassword.getTaint());
        addTaint(newPassword.getTaint());
        addTaint(onComplete.getTaint());
        
        
                 
    }

    
    public abstract String getServiceProviderName();

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.738 -0400", hash_original_method = "26BBB856B8138972809A4E6EC2BCC376", hash_generated_method = "4A1645AE835255FE7642245C74B88BD6")
    protected void updateStateProperty() {
        mPhone.setSystemProperty(TelephonyProperties.PROPERTY_SIM_STATE, getState().toString());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.738 -0400", hash_original_method = "B8050A82EEEB3E75B61D0D7FED84BD4F", hash_generated_method = "6E95396EDB57B48B75EF0D41DBD0630D")
    private void getIccCardStatusDone(AsyncResult ar) {
        handleIccCardStatus((IccCardStatus) ar.result);
        addTaint(ar.getTaint());
        
        
            
                    
                    
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.740 -0400", hash_original_method = "EDEEC41729C236C302C7B6E1F1DF026D", hash_generated_method = "4B28FA79992BDB137094C9E1454B5C93")
    private void handleIccCardStatus(IccCardStatus newCardStatus) {
        boolean transitionedIntoPinLocked;
        boolean transitionedIntoAbsent;
        boolean transitionedIntoNetworkLocked;
        boolean transitionedIntoPermBlocked;
        boolean isIccCardRemoved;
        boolean isIccCardAdded;
        State oldState;
        State newState;
        oldState = mState;
        mIccCardStatus = newCardStatus;
        newState = getIccCardState();
        mState = newState;
        updateStateProperty();
        transitionedIntoPinLocked = (
                 (oldState != State.PIN_REQUIRED && newState == State.PIN_REQUIRED)
              || (oldState != State.PUK_REQUIRED && newState == State.PUK_REQUIRED));
        transitionedIntoAbsent = (oldState != State.ABSENT && newState == State.ABSENT);
        transitionedIntoNetworkLocked = (oldState != State.NETWORK_LOCKED
                && newState == State.NETWORK_LOCKED);
        transitionedIntoPermBlocked = (oldState != State.PERM_DISABLED
                && newState == State.PERM_DISABLED);
        isIccCardRemoved = (oldState != null &&
                        oldState.iccCardExist() && newState == State.ABSENT);
        isIccCardAdded = (oldState == State.ABSENT &&
                        newState != null && newState.iccCardExist());
        {
            log("Notify SIM pin or puk locked.");
            mPinLockedRegistrants.notifyRegistrants();
            broadcastIccStateChangedIntent(INTENT_VALUE_ICC_LOCKED,
                    (newState == State.PIN_REQUIRED) ?
                       INTENT_VALUE_LOCKED_ON_PIN : INTENT_VALUE_LOCKED_ON_PUK);
        } 
        {
            log("Notify SIM missing.");
            mAbsentRegistrants.notifyRegistrants();
            broadcastIccStateChangedIntent(INTENT_VALUE_ICC_ABSENT, null);
        } 
        {
            log("Notify SIM network locked.");
            mNetworkLockedRegistrants.notifyRegistrants();
            broadcastIccStateChangedIntent(INTENT_VALUE_ICC_LOCKED,
                  INTENT_VALUE_LOCKED_NETWORK);
        } 
        {
            log("Notify SIM permanently disabled.");
            broadcastIccStateChangedIntent(INTENT_VALUE_ICC_ABSENT,
                    INTENT_VALUE_ABSENT_ON_PERM_DISABLED);
        } 
        {
            mHandler.sendMessage(mHandler.obtainMessage(EVENT_CARD_REMOVED, null));
        } 
        {
            mHandler.sendMessage(mHandler.obtainMessage(EVENT_CARD_ADDED, null));
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.742 -0400", hash_original_method = "482C40D5983445C1A7C95EBEDC56AC82", hash_generated_method = "318079C0D419C283A47E804226ED16EB")
    private void onIccSwap(boolean isAdded) {
        DialogInterface.OnClickListener listener = null;
        listener = new DialogInterface.OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.742 -0400", hash_original_method = "9D3F97D682E1929CAA7D6B8E66CF9703", hash_generated_method = "48F09861718B1B637B6F038E7C38D0D1")
            @Override
            public void onClick(DialogInterface dialog, int which) {
                
                {
                    log("Reboot due to SIM swap");
                    PowerManager pm = (PowerManager) mPhone.getContext()
                    .getSystemService(Context.POWER_SERVICE);
                    pm.reboot("SIM is added.");
                } 
                addTaint(dialog.getTaint());
                addTaint(which);
                
                
                    
                    
                    
                    
                
            }
};
        Resources r = Resources.getSystem();
        String title;
        title = r.getString(R.string.sim_added_title);
        title = r.getString(R.string.sim_removed_title);
        String message;
        message = r.getString(R.string.sim_added_message);
        message = r.getString(R.string.sim_removed_message);
        String buttonTxt = r.getString(R.string.sim_restart_button);
        AlertDialog dialog = new AlertDialog.Builder(mPhone.getContext())
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(buttonTxt, listener)
            .create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        dialog.show();
        addTaint(isAdded);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.744 -0400", hash_original_method = "F212AE1E9E62E46B160458ACE7EF1DC3", hash_generated_method = "CC96BC7FAEBA8C284B6F78707DCD3494")
    private void onQueryFdnEnabled(AsyncResult ar) {
        {
            log("Error in querying facility lock:" + ar.exception);
        } 
        int[] ints = (int[])ar.result;
        {
            mIccFdnEnabled = (0!=ints[0]);
            log("Query facility lock : "  + mIccFdnEnabled);
        } 
        addTaint(ar.getTaint());
        
        
            
            
        
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.745 -0400", hash_original_method = "2D3A559A68B85B440A539D217592B783", hash_generated_method = "0AF594FB62C585AF490FF5938FD1F6FE")
    private void onQueryFacilityLock(AsyncResult ar) {
        {
            log("Error in querying facility lock:" + ar.exception);
        } 
        int[] ints = (int[])ar.result;
        {
            mIccPinLocked = (0!=ints[0]);
            log("Query facility lock : "  + mIccPinLocked);
        } 
        addTaint(ar.getTaint());
        
        
            
            
        
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.745 -0400", hash_original_method = "BEDA05141A25EA0E8449469A2D08AE66", hash_generated_method = "1C97739B1E1810658065D0A36CBAA5C8")
    public void broadcastIccStateChangedIntent(String value, String reason) {
        Intent intent = new Intent(TelephonyIntents.ACTION_SIM_STATE_CHANGED);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        intent.putExtra(Phone.PHONE_NAME_KEY, mPhone.getPhoneName());
        intent.putExtra(INTENT_KEY_ICC_STATE, value);
        intent.putExtra(INTENT_KEY_LOCKED_REASON, reason);
        log("Broadcasting intent ACTION_SIM_STATE_CHANGED " +  value
                + " reason " + reason);
        ActivityManagerNative.broadcastStickyIntent(intent, READ_PHONE_STATE);
        addTaint(value.getTaint());
        addTaint(reason.getTaint());
        
        
        
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.747 -0400", hash_original_method = "531282E014DCDC26F790CA6DADE3C8C6", hash_generated_method = "8623C5277FC402A6768754B8410684EC")
    public State getIccCardState() {
        State varB4EAC82CA7396A68D541C85D26508E83_808281646 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_22624863 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_1840896540 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_443287001 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_2020352605 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_350741746 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_380624981 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_808281646 = IccCard.State.ABSENT;
        } 
        {
            boolean var37EB664FE23E2FAE1F059F1BE9FE3DC1_1487289559 = (!mIccCardStatus.getCardState().isCardPresent());
            {
                varB4EAC82CA7396A68D541C85D26508E83_22624863 = IccCard.State.ABSENT;
            } 
        } 
        RadioState currentRadioState = mPhone.mCM.getRadioState();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1840896540 = IccCard.State.NOT_READY;
        } 
        {
            State csimState = getAppState(mIccCardStatus.getCdmaSubscriptionAppIndex());
            State usimState = getAppState(mIccCardStatus.getGsmUmtsSubscriptionAppIndex());
            log("USIM=" + usimState + " CSIM=" + csimState);
            {
                boolean var77E61B402E06F4B2589B17903F68887C_587226138 = (mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_443287001 = getConsolidatedState(csimState, usimState, csimState);
                } 
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_2020352605 = csimState;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_350741746 = usimState;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_380624981 = IccCard.State.ABSENT;
        State varA7E53CE21691AB073D9660D615818899_1764286803; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1764286803 = varB4EAC82CA7396A68D541C85D26508E83_808281646;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1764286803 = varB4EAC82CA7396A68D541C85D26508E83_22624863;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1764286803 = varB4EAC82CA7396A68D541C85D26508E83_1840896540;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1764286803 = varB4EAC82CA7396A68D541C85D26508E83_443287001;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_1764286803 = varB4EAC82CA7396A68D541C85D26508E83_2020352605;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_1764286803 = varB4EAC82CA7396A68D541C85D26508E83_350741746;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1764286803 = varB4EAC82CA7396A68D541C85D26508E83_380624981;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1764286803.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1764286803;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.748 -0400", hash_original_method = "809395990E0197CB644B1DF3288DB707", hash_generated_method = "FFEEB0E6EB8D5225A727B9BCE40EAC09")
    private State getAppState(int appIndex) {
        State varB4EAC82CA7396A68D541C85D26508E83_1140501932 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_174830782 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_1051139931 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_1805813271 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_2116314081 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_1474971242 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_1032944142 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_3026866 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_1385963429 = null; 
        IccCardApplication app;
        {
            app = mIccCardStatus.getApplication(appIndex);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1140501932 = IccCard.State.ABSENT;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_174830782 = IccCard.State.ABSENT;
        } 
        {
            boolean varD79448EF50A427003D4C76CECD605C72_1990382628 = (app.pin1.isPermBlocked());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1051139931 = IccCard.State.PERM_DISABLED;
            } 
        } 
        {
            boolean var1945F3B200D512171D5265F4A46FA51E_220219677 = (app.app_state.isPinRequired());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1805813271 = IccCard.State.PIN_REQUIRED;
            } 
        } 
        {
            boolean var61EBE391DFCFAFB0FB7193188270151E_611780260 = (app.app_state.isPukRequired());
            {
                varB4EAC82CA7396A68D541C85D26508E83_2116314081 = IccCard.State.PUK_REQUIRED;
            } 
        } 
        {
            boolean varA6084E236BBD4BA404CD38B01625DB98_605862525 = (app.app_state.isSubscriptionPersoEnabled());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1474971242 = IccCard.State.NETWORK_LOCKED;
            } 
        } 
        {
            boolean var0542E857D2243312200D238063975376_546265316 = (app.app_state.isAppReady());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1032944142 = IccCard.State.READY;
            } 
        } 
        {
            boolean var6CCD9C0F390C721F8CA6FD75317DDB79_2092699321 = (app.app_state.isAppNotReady());
            {
                varB4EAC82CA7396A68D541C85D26508E83_3026866 = IccCard.State.NOT_READY;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1385963429 = IccCard.State.NOT_READY;
        addTaint(appIndex);
        State varA7E53CE21691AB073D9660D615818899_928772456; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_928772456 = varB4EAC82CA7396A68D541C85D26508E83_1140501932;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_928772456 = varB4EAC82CA7396A68D541C85D26508E83_174830782;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_928772456 = varB4EAC82CA7396A68D541C85D26508E83_1051139931;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_928772456 = varB4EAC82CA7396A68D541C85D26508E83_1805813271;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_928772456 = varB4EAC82CA7396A68D541C85D26508E83_2116314081;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_928772456 = varB4EAC82CA7396A68D541C85D26508E83_1474971242;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_928772456 = varB4EAC82CA7396A68D541C85D26508E83_1032944142;
                break;
            case 8: 
                varA7E53CE21691AB073D9660D615818899_928772456 = varB4EAC82CA7396A68D541C85D26508E83_3026866;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_928772456 = varB4EAC82CA7396A68D541C85D26508E83_1385963429;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_928772456.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_928772456;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.750 -0400", hash_original_method = "292BB37BE4996383C23DC23B1670D1D7", hash_generated_method = "0967111C8C9555A735D517E5C2D5E99D")
    private State getConsolidatedState(State left, State right, State preferredState) {
        State varB4EAC82CA7396A68D541C85D26508E83_271235761 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_530657095 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_380221384 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_1726355802 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_1963196132 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_993309618 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_160071318 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_271235761 = left;
        varB4EAC82CA7396A68D541C85D26508E83_530657095 = right;
        {
            varB4EAC82CA7396A68D541C85D26508E83_380221384 = State.READY;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1726355802 = IccCard.State.NOT_READY;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1963196132 = left;
        varB4EAC82CA7396A68D541C85D26508E83_993309618 = right;
        varB4EAC82CA7396A68D541C85D26508E83_160071318 = preferredState;
        addTaint(left.getTaint());
        addTaint(right.getTaint());
        addTaint(preferredState.getTaint());
        State varA7E53CE21691AB073D9660D615818899_1762029420; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1762029420 = varB4EAC82CA7396A68D541C85D26508E83_271235761;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1762029420 = varB4EAC82CA7396A68D541C85D26508E83_530657095;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1762029420 = varB4EAC82CA7396A68D541C85D26508E83_380221384;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1762029420 = varB4EAC82CA7396A68D541C85D26508E83_1726355802;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_1762029420 = varB4EAC82CA7396A68D541C85D26508E83_1963196132;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_1762029420 = varB4EAC82CA7396A68D541C85D26508E83_993309618;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1762029420 = varB4EAC82CA7396A68D541C85D26508E83_160071318;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1762029420.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1762029420;
        
        
        
        
            
        
        
            
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.751 -0400", hash_original_method = "B5E8B5923B9BC39502C2387B1882FFE9", hash_generated_method = "F93913724E9DA505357C9C57B00A702D")
    public boolean isApplicationOnIcc(IccCardApplication.AppType type) {
        {
            int i = 0;
            boolean var2346A46A01A4552FF6397DC9B45B0FA6_199388480 = (i < mIccCardStatus.getNumApplications());
            {
                IccCardApplication app = mIccCardStatus.getApplication(i);
            } 
        } 
        addTaint(type.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_399239644 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_399239644;
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.751 -0400", hash_original_method = "1BA9D03EECE1275906E702F57E19B9C4", hash_generated_method = "F8B1B8BF64DE31B7BC70D24F62384A66")
    public boolean hasIccCard() {
        {
            boolean var5F1FEE56A00FEFA0965524059C0855DA_1766203083 = (mIccCardStatus.getCardState().isCardPresent());
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_491395255 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_491395255;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.752 -0400", hash_original_method = "8040171B9171EEC88FFD4AC75BEDD9D4", hash_generated_method = "623DE00DDDF8C6544CC3EC79B4218C86")
    private void log(String msg) {
        Log.d(mLogTag, "[IccCard] " + msg);
        addTaint(msg.getTaint());
        
        
    }

    
    public enum State {
        UNKNOWN,
        ABSENT,
        PIN_REQUIRED,
        PUK_REQUIRED,
        NETWORK_LOCKED,
        READY,
        NOT_READY,
        PERM_DISABLED;
        public boolean isPinLocked() {
            return ((this == PIN_REQUIRED) || (this == PUK_REQUIRED));
        }
        public boolean iccCardExist() {
            return ((this == PIN_REQUIRED) || (this == PUK_REQUIRED)
                    || (this == NETWORK_LOCKED) || (this == READY)
                    || (this == PERM_DISABLED));
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.752 -0400", hash_original_field = "4E8D0274A2974A4104009ED903CA7DF6", hash_generated_field = "13296FAB897D65BFBDA3BB2C514373EF")

    static public final String INTENT_KEY_ICC_STATE = "ss";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.752 -0400", hash_original_field = "415E0FF726B9974E357FB6FFD5403327", hash_generated_field = "559004855AF26038D1301B2EB2A81958")

    static public final String INTENT_VALUE_ICC_NOT_READY = "NOT_READY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "A698CB27956FF8C110377324B7929A28", hash_generated_field = "09E173E394E5D91B9D74B048E28CDA40")

    static public final String INTENT_VALUE_ICC_ABSENT = "ABSENT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "6CE86164A5E1A9E092A8E0A5B9DED311", hash_generated_field = "B9ECAC99CC48A7FA1E2E4234F2D4F8DD")

    static public final String INTENT_VALUE_ICC_LOCKED = "LOCKED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "D6153E40940FA2E2661254B4416303B4", hash_generated_field = "299CBCB1408043E9A327CC84FDCBEEB1")

    static public final String INTENT_VALUE_ICC_READY = "READY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "F4914C0EE6491535F1EC45D22E8DEED2", hash_generated_field = "B11FF3A7F190CFA1F78B0A44A9BC2F7F")

    static public final String INTENT_VALUE_ICC_IMSI = "IMSI";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "ABBD1334DF4188600B92AC80B86F8DE3", hash_generated_field = "5A47219824FC4CE98A1CDF755912F5D3")

    static public final String INTENT_VALUE_ICC_LOADED = "LOADED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "EFADDC467AAB577159B8395EF08A71E4", hash_generated_field = "B52DE1E639231C806713539135C0EC44")

    static public final String INTENT_KEY_LOCKED_REASON = "reason";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "F4281583CA82139E6D5B4ED808D7371B", hash_generated_field = "8CB239DD07ED9D2B9354AF9790A52085")

    static public final String INTENT_VALUE_LOCKED_ON_PIN = "PIN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "5308AEA1C22392C049E02997D987CC31", hash_generated_field = "9D4E8CF5E08E88C5263AD804A1CC2E40")

    static public final String INTENT_VALUE_LOCKED_ON_PUK = "PUK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "0E8D2CB33D7F1323388E2E9E64C40DF4", hash_generated_field = "E414FAB7F3419E8267A72ED727E98329")

    static public final String INTENT_VALUE_LOCKED_NETWORK = "NETWORK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "EC74C91AB18DA5EB7F83CDB921DE4FAE", hash_generated_field = "1AC6CFB4E094233EA40DDF5454436669")

    static public final String INTENT_VALUE_ABSENT_ON_PERM_DISABLED = "PERM_DISABLED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "DF3208C608C8153D3ED7FF08E95ABEAD", hash_generated_field = "BB00981FA4DDC48E77E3446841ED578B")

    protected static final int EVENT_ICC_LOCKED_OR_ABSENT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "D4E84F7920E0975E27CBE7069F5CFBF8", hash_generated_field = "6A530CAC29AE5BD3085335985B2810BD")

    private static final int EVENT_GET_ICC_STATUS_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "726D8DA480BD0D2C8D1177303E93D4C0", hash_generated_field = "A5743C4EFFAC98F496715C592912CE53")

    protected static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "93DA8E59C4139915F236D3ED564C0914", hash_generated_field = "A8FC0B827122F18799DB60E3B856F9C1")

    private static final int EVENT_PINPUK_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "0A2D0AB9EF09FB4BF143B595A70FCC7C", hash_generated_field = "242135FAED9E4D8578354B9454EB35C3")

    private static final int EVENT_REPOLL_STATUS_DONE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "7711A73FCB7752619A0750B474C480F0", hash_generated_field = "D730302ED7BCEEDF4EEB2F6802EE57FD")

    protected static final int EVENT_ICC_READY = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "47663F5B966A9E46338F0BB331FD5A17", hash_generated_field = "F4D6932778576F707B7936043C92F42A")

    private static final int EVENT_QUERY_FACILITY_LOCK_DONE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "99009BA3BF30CF722936C81F997BC5B6", hash_generated_field = "E362BB0C36E7DC31306182774E294D5E")

    private static final int EVENT_CHANGE_FACILITY_LOCK_DONE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "5D770D7915D16CFC9643E79BD347C3AA", hash_generated_field = "97EFE391ADDE4F597A8812D5755BC729")

    private static final int EVENT_CHANGE_ICC_PASSWORD_DONE = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "DCF6C78CAED9FD3FCC33C8D43C378FF0", hash_generated_field = "0DB4D493C14133032F82ADA18DCB4118")

    private static final int EVENT_QUERY_FACILITY_FDN_DONE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "605FAA42EB0E0BFB73A948B47A066901", hash_generated_field = "9C46342A37891DB5C8514A911C636E35")

    private static final int EVENT_CHANGE_FACILITY_FDN_DONE = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "8CB1C0D04994FA3BFB96074A15C85D58", hash_generated_field = "11BCA9CD0D4020ECA2009590B4FB03A5")

    private static final int EVENT_ICC_STATUS_CHANGED = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "FB7E9591376FC5D385C90334A6B74395", hash_generated_field = "67A04E786502FED24B042568D76A6216")

    private static final int EVENT_CARD_REMOVED = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.753 -0400", hash_original_field = "2DA616E9DFA974F9578E475C34C23EEE", hash_generated_field = "E825A176BF633732EFFA825E7EFB90AA")

    private static final int EVENT_CARD_ADDED = 14;
}

