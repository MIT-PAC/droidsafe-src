package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.336 -0400", hash_original_field = "503F6607C959C61B036C1484733875DB", hash_generated_field = "621F1F8A1A73F0186C3B2A8FD458DBF8")

    protected String mLogTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.336 -0400", hash_original_field = "44ACAC101472BE8FC80671CD461C5D61", hash_generated_field = "05625C1A8AEC158E47E651E2912A02BB")

    protected boolean mDbg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.336 -0400", hash_original_field = "DE32B65E7EE0B55BC712321AEEA728A8", hash_generated_field = "9B1F8CAC61F695F54D4232EE65554395")

    private IccCardStatus mIccCardStatus = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.336 -0400", hash_original_field = "1D598FE22B106935C0C063CC508FA455", hash_generated_field = "B2CB76BA7B9E699C7A661DE6BE3920DB")

    protected State mState = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.336 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "C5284483C4CF8ED630A2E2607ED30E12")

    protected PhoneBase mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.336 -0400", hash_original_field = "4E7FCC656AA6F8FBB8616A81CB62D667", hash_generated_field = "BB4D0C0D6F697E88C9F5A7A0E99C541E")

    private RegistrantList mAbsentRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.336 -0400", hash_original_field = "6710CED66CE3362B59772BAE61AD7DD9", hash_generated_field = "7FBB4558DC3714EECB6D5E802875936C")

    private RegistrantList mPinLockedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.336 -0400", hash_original_field = "B9AB100E7FC5A76FFBE28B818830C025", hash_generated_field = "810D4E60FCDB2F59BE3AFC34BFC4D065")

    private RegistrantList mNetworkLockedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.336 -0400", hash_original_field = "1445211AF5BB90E5C392311CE390CE34", hash_generated_field = "6F5CD85185F4F8603950244B00F7B22C")

    private boolean mDesiredPinLocked;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.336 -0400", hash_original_field = "4E6FF6737A71D42C0FAB7F364606445B", hash_generated_field = "4055529E8474844347F470FAB93250EC")

    private boolean mDesiredFdnEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.337 -0400", hash_original_field = "843C2F0DC295527B0EA88ECB15133B30", hash_generated_field = "4F01E642146FEA0D727EF809A7BAFF77")

    private boolean mIccPinLocked = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.337 -0400", hash_original_field = "BF434A14237EBD649B50D12B7DBD86B8", hash_generated_field = "385C08A9E0809A77275EED9469D8B1F1")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.337 -0400", hash_original_method = "A83C78588609731AFA33B82B4815F4C9", hash_generated_method = "67B5BD0EE12240734C95456487DA84CE")
    public  IccCard(PhoneBase phone, String logTag, Boolean dbg) {
        mPhone = phone;
        mPhone.mCM.registerForIccStatusChanged(mHandler, EVENT_ICC_STATUS_CHANGED, null);
        mLogTag = logTag;
        mDbg = dbg;
        // ---------- Original Method ----------
        //mPhone = phone;
        //mPhone.mCM.registerForIccStatusChanged(mHandler, EVENT_ICC_STATUS_CHANGED, null);
        //mLogTag = logTag;
        //mDbg = dbg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.338 -0400", hash_original_method = "B45586395D9726A6E3A7A444B2DA9D4A", hash_generated_method = "E14D2F763CBDE5C9BB2CB5844268BF53")
    public State getState() {
    if(mState == null)        
        {
switch(mPhone.mCM.getRadioState()){
            case RADIO_OFF:
            case RADIO_UNAVAILABLE:
            case SIM_NOT_READY:
            case RUIM_NOT_READY:
State var4770D84E0C6F67F8CE04CBDC149857AC_1861529637 =             State.UNKNOWN;
            var4770D84E0C6F67F8CE04CBDC149857AC_1861529637.addTaint(taint);
            return var4770D84E0C6F67F8CE04CBDC149857AC_1861529637;
            case SIM_LOCKED_OR_ABSENT:
            case RUIM_LOCKED_OR_ABSENT:
State var4770D84E0C6F67F8CE04CBDC149857AC_1078668032 =             State.UNKNOWN;
            var4770D84E0C6F67F8CE04CBDC149857AC_1078668032.addTaint(taint);
            return var4770D84E0C6F67F8CE04CBDC149857AC_1078668032;
            case SIM_READY:
            case RUIM_READY:
            case NV_READY:
State var6409814A64BE3687CEC3A7AF97CABF0F_455021101 =             State.READY;
            var6409814A64BE3687CEC3A7AF97CABF0F_455021101.addTaint(taint);
            return var6409814A64BE3687CEC3A7AF97CABF0F_455021101;
            case NV_NOT_READY:
State var6CFD911D61EE1CB04A4DE674D6400D59_1489567203 =             State.ABSENT;
            var6CFD911D61EE1CB04A4DE674D6400D59_1489567203.addTaint(taint);
            return var6CFD911D61EE1CB04A4DE674D6400D59_1489567203;
}
        } //End block
        else
        {
State var8B975C85F13BECB9FD4D21A5F3C8A56D_2083094549 =             mState;
            var8B975C85F13BECB9FD4D21A5F3C8A56D_2083094549.addTaint(taint);
            return var8B975C85F13BECB9FD4D21A5F3C8A56D_2083094549;
        } //End block
State var4770D84E0C6F67F8CE04CBDC149857AC_1781692272 =         State.UNKNOWN;
        var4770D84E0C6F67F8CE04CBDC149857AC_1781692272.addTaint(taint);
        return var4770D84E0C6F67F8CE04CBDC149857AC_1781692272;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.338 -0400", hash_original_method = "EF67D81D926CA0EC8F8754BC29C8826B", hash_generated_method = "8FB4003EBB7FCD2F2B0FD7E02F818470")
    public void dispose() {
        mPhone.mCM.unregisterForIccStatusChanged(mHandler);
        // ---------- Original Method ----------
        //mPhone.mCM.unregisterForIccStatusChanged(mHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.338 -0400", hash_original_method = "C148A728067D02A221BE75C987C5D733", hash_generated_method = "075B2DD258946BBD2F1ED4568E67D027")
    protected void finalize() {
    if(mDbg)        
        Log.d(mLogTag, "IccCard finalized");
        // ---------- Original Method ----------
        //if(mDbg) Log.d(mLogTag, "IccCard finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.339 -0400", hash_original_method = "45A4F957AA9A104F89D6FFEF5C13C9B4", hash_generated_method = "419651D566BEF7CA5A430E53CA2810EB")
    public void registerForAbsent(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        Registrant r = new Registrant (h, what, obj);
        mAbsentRegistrants.add(r);
    if(getState() == State.ABSENT)        
        {
            r.notifyRegistrant();
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mAbsentRegistrants.add(r);
        //if (getState() == State.ABSENT) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.339 -0400", hash_original_method = "A388490F008524959D490318F4B49030", hash_generated_method = "66FC903E19FC06F23B54C0169321B9F6")
    public void unregisterForAbsent(Handler h) {
        addTaint(h.getTaint());
        mAbsentRegistrants.remove(h);
        // ---------- Original Method ----------
        //mAbsentRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.339 -0400", hash_original_method = "DD13D18C49861341C8AF8EABF1CC2E24", hash_generated_method = "826627162F515175B05924DDF22D8557")
    public void registerForNetworkLocked(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        Registrant r = new Registrant (h, what, obj);
        mNetworkLockedRegistrants.add(r);
    if(getState() == State.NETWORK_LOCKED)        
        {
            r.notifyRegistrant();
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mNetworkLockedRegistrants.add(r);
        //if (getState() == State.NETWORK_LOCKED) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.340 -0400", hash_original_method = "5CEB6427435BFB9EC514E781B4093E7E", hash_generated_method = "7DFB72ED84F9CCDD81A7238D28F7A6EB")
    public void unregisterForNetworkLocked(Handler h) {
        addTaint(h.getTaint());
        mNetworkLockedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mNetworkLockedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.340 -0400", hash_original_method = "A158B3B1FDF0C70FEF29C25B6F4DD072", hash_generated_method = "B0AEE7C3CBC49D12C94D01C35C07DBCB")
    public void registerForLocked(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        Registrant r = new Registrant (h, what, obj);
        mPinLockedRegistrants.add(r);
    if(getState().isPinLocked())        
        {
            r.notifyRegistrant();
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mPinLockedRegistrants.add(r);
        //if (getState().isPinLocked()) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.340 -0400", hash_original_method = "5667345A02500557814700DAC5845BCA", hash_generated_method = "4120B15D3085B4081E351EA59521ADBF")
    public void unregisterForLocked(Handler h) {
        addTaint(h.getTaint());
        mPinLockedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mPinLockedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.341 -0400", hash_original_method = "ADEE02A4D2D0DF5B5C1110C0F3EF40D9", hash_generated_method = "8001FA15675F55ED71882B9D09693A6E")
    public void supplyPin(String pin, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(pin.getTaint());
        mPhone.mCM.supplyIccPin(pin, mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
        // ---------- Original Method ----------
        //mPhone.mCM.supplyIccPin(pin, mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.341 -0400", hash_original_method = "F069297D525546A0218C2FB5A43E0287", hash_generated_method = "6C4B332D320CB80099C34321333EC54B")
    public void supplyPuk(String puk, String newPin, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(newPin.getTaint());
        addTaint(puk.getTaint());
        mPhone.mCM.supplyIccPuk(puk, newPin,
                mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
        // ---------- Original Method ----------
        //mPhone.mCM.supplyIccPuk(puk, newPin,
                //mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.341 -0400", hash_original_method = "35EFF2F2C787166AB4A51F303C9455F4", hash_generated_method = "75BBF5125FE3936953DDFEEA8E7F2019")
    public void supplyPin2(String pin2, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(pin2.getTaint());
        mPhone.mCM.supplyIccPin2(pin2,
                mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
        // ---------- Original Method ----------
        //mPhone.mCM.supplyIccPin2(pin2,
                //mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.342 -0400", hash_original_method = "982062922CE016EAC29E809D9B066C8E", hash_generated_method = "3FD2710E1D191E6F5553ECD82AE860A2")
    public void supplyPuk2(String puk2, String newPin2, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(newPin2.getTaint());
        addTaint(puk2.getTaint());
        mPhone.mCM.supplyIccPuk2(puk2, newPin2,
                mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
        // ---------- Original Method ----------
        //mPhone.mCM.supplyIccPuk2(puk2, newPin2,
                //mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.342 -0400", hash_original_method = "96497D4DFF6E2FE9CEEE26788CBD4E3F", hash_generated_method = "FDBF1AFB05FA4F18733CCB7FD465D8B5")
    public void supplyNetworkDepersonalization(String pin, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(pin.getTaint());
        mPhone.mCM.supplyNetworkDepersonalization(pin,
                mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
        // ---------- Original Method ----------
        //mPhone.mCM.supplyNetworkDepersonalization(pin,
                //mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.342 -0400", hash_original_method = "BCA6EFC1210C838BF4CD916790946AA6", hash_generated_method = "912E76BE560A0DDE6E9DC645753D71CC")
    public boolean getIccLockEnabled() {
        boolean var98241A760904A8071026171FB5F891EF_1537214631 = (mIccPinLocked);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_557220205 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_557220205;
        // ---------- Original Method ----------
        //return mIccPinLocked;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.343 -0400", hash_original_method = "F2BBF6EB30564DA8841F6D4A48D01D80", hash_generated_method = "75EF38D476865F39FF68CB5327539A42")
    public boolean getIccFdnEnabled() {
        boolean var5D26F052B120A0C24B0BF31105E0F878_1550469319 = (mIccFdnEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1279109263 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1279109263;
        // ---------- Original Method ----------
        //return mIccFdnEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.343 -0400", hash_original_method = "3DCE16ED303A66C1573E6E04CDCFB500", hash_generated_method = "BA6CF6BF8D5EF11AFC0CDF6D777A26D1")
    public void setIccLockEnabled(boolean enabled,
             String password, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(password.getTaint());
        int serviceClassX;
        serviceClassX = CommandsInterface.SERVICE_CLASS_VOICE +
                 CommandsInterface.SERVICE_CLASS_DATA +
                 CommandsInterface.SERVICE_CLASS_FAX;
        mDesiredPinLocked = enabled;
        mPhone.mCM.setFacilityLock(CommandsInterface.CB_FACILITY_BA_SIM,
                 enabled, password, serviceClassX,
                 mHandler.obtainMessage(EVENT_CHANGE_FACILITY_LOCK_DONE, onComplete));
        // ---------- Original Method ----------
        //int serviceClassX;
        //serviceClassX = CommandsInterface.SERVICE_CLASS_VOICE +
                 //CommandsInterface.SERVICE_CLASS_DATA +
                 //CommandsInterface.SERVICE_CLASS_FAX;
        //mDesiredPinLocked = enabled;
        //mPhone.mCM.setFacilityLock(CommandsInterface.CB_FACILITY_BA_SIM,
                 //enabled, password, serviceClassX,
                 //mHandler.obtainMessage(EVENT_CHANGE_FACILITY_LOCK_DONE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.344 -0400", hash_original_method = "42161809775FC8FDBB38BE3E5058E399", hash_generated_method = "D0A2DD0481010FBA4E181787F9FEF062")
    public void setIccFdnEnabled(boolean enabled,
             String password, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(password.getTaint());
        int serviceClassX;
        serviceClassX = CommandsInterface.SERVICE_CLASS_VOICE +
                 CommandsInterface.SERVICE_CLASS_DATA +
                 CommandsInterface.SERVICE_CLASS_FAX +
                 CommandsInterface.SERVICE_CLASS_SMS;
        mDesiredFdnEnabled = enabled;
        mPhone.mCM.setFacilityLock(CommandsInterface.CB_FACILITY_BA_FD,
                 enabled, password, serviceClassX,
                 mHandler.obtainMessage(EVENT_CHANGE_FACILITY_FDN_DONE, onComplete));
        // ---------- Original Method ----------
        //int serviceClassX;
        //serviceClassX = CommandsInterface.SERVICE_CLASS_VOICE +
                 //CommandsInterface.SERVICE_CLASS_DATA +
                 //CommandsInterface.SERVICE_CLASS_FAX +
                 //CommandsInterface.SERVICE_CLASS_SMS;
        //mDesiredFdnEnabled = enabled;
        //mPhone.mCM.setFacilityLock(CommandsInterface.CB_FACILITY_BA_FD,
                 //enabled, password, serviceClassX,
                 //mHandler.obtainMessage(EVENT_CHANGE_FACILITY_FDN_DONE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.344 -0400", hash_original_method = "CFACBB8EE591380B6F953CA4501BCE4D", hash_generated_method = "6320C2DAD0235FB8D91A0679FCC35E2C")
    public void changeIccLockPassword(String oldPassword, String newPassword,
             Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(newPassword.getTaint());
        addTaint(oldPassword.getTaint());
        mPhone.mCM.changeIccPin(oldPassword, newPassword,
                 mHandler.obtainMessage(EVENT_CHANGE_ICC_PASSWORD_DONE, onComplete));
        // ---------- Original Method ----------
        //mPhone.mCM.changeIccPin(oldPassword, newPassword,
                 //mHandler.obtainMessage(EVENT_CHANGE_ICC_PASSWORD_DONE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.344 -0400", hash_original_method = "78AE6F1E64D3743DF4893D59C6AFA5E2", hash_generated_method = "9465CC749FC05080AFCA8448D724A2BE")
    public void changeIccFdnPassword(String oldPassword, String newPassword,
             Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(newPassword.getTaint());
        addTaint(oldPassword.getTaint());
        mPhone.mCM.changeIccPin2(oldPassword, newPassword,
                 mHandler.obtainMessage(EVENT_CHANGE_ICC_PASSWORD_DONE, onComplete));
        // ---------- Original Method ----------
        //mPhone.mCM.changeIccPin2(oldPassword, newPassword,
                 //mHandler.obtainMessage(EVENT_CHANGE_ICC_PASSWORD_DONE, onComplete));
    }

    
    public abstract String getServiceProviderName();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.345 -0400", hash_original_method = "26BBB856B8138972809A4E6EC2BCC376", hash_generated_method = "4A1645AE835255FE7642245C74B88BD6")
    protected void updateStateProperty() {
        mPhone.setSystemProperty(TelephonyProperties.PROPERTY_SIM_STATE, getState().toString());
        // ---------- Original Method ----------
        //mPhone.setSystemProperty(TelephonyProperties.PROPERTY_SIM_STATE, getState().toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.345 -0400", hash_original_method = "B8050A82EEEB3E75B61D0D7FED84BD4F", hash_generated_method = "12BBA13D839834AB35ED613287238E93")
    private void getIccCardStatusDone(AsyncResult ar) {
        addTaint(ar.getTaint());
    if(ar.exception != null)        
        {
            return;
        } //End block
        handleIccCardStatus((IccCardStatus) ar.result);
        // ---------- Original Method ----------
        //if (ar.exception != null) {
            //Log.e(mLogTag,"Error getting ICC status. "
                    //+ "RIL_REQUEST_GET_ICC_STATUS should "
                    //+ "never return an error", ar.exception);
            //return;
        //}
        //handleIccCardStatus((IccCardStatus) ar.result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.347 -0400", hash_original_method = "EDEEC41729C236C302C7B6E1F1DF026D", hash_generated_method = "6CC5058578E0D0A7FBA992335C683E15")
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
    if(transitionedIntoPinLocked)        
        {
    if(mDbg)            
            log("Notify SIM pin or puk locked.");
            mPinLockedRegistrants.notifyRegistrants();
            broadcastIccStateChangedIntent(INTENT_VALUE_ICC_LOCKED,
                    (newState == State.PIN_REQUIRED) ?
                       INTENT_VALUE_LOCKED_ON_PIN : INTENT_VALUE_LOCKED_ON_PUK);
        } //End block
        else
    if(transitionedIntoAbsent)        
        {
    if(mDbg)            
            log("Notify SIM missing.");
            mAbsentRegistrants.notifyRegistrants();
            broadcastIccStateChangedIntent(INTENT_VALUE_ICC_ABSENT, null);
        } //End block
        else
    if(transitionedIntoNetworkLocked)        
        {
    if(mDbg)            
            log("Notify SIM network locked.");
            mNetworkLockedRegistrants.notifyRegistrants();
            broadcastIccStateChangedIntent(INTENT_VALUE_ICC_LOCKED,
                  INTENT_VALUE_LOCKED_NETWORK);
        } //End block
        else
    if(transitionedIntoPermBlocked)        
        {
    if(mDbg)            
            log("Notify SIM permanently disabled.");
            broadcastIccStateChangedIntent(INTENT_VALUE_ICC_ABSENT,
                    INTENT_VALUE_ABSENT_ON_PERM_DISABLED);
        } //End block
    if(isIccCardRemoved)        
        {
            mHandler.sendMessage(mHandler.obtainMessage(EVENT_CARD_REMOVED, null));
        } //End block
        else
    if(isIccCardAdded)        
        {
            mHandler.sendMessage(mHandler.obtainMessage(EVENT_CARD_ADDED, null));
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.348 -0400", hash_original_method = "482C40D5983445C1A7C95EBEDC56AC82", hash_generated_method = "B509E0B2F3B300F4D599576F13AFE3ED")
    private void onIccSwap(boolean isAdded) {
        addTaint(isAdded);
        DialogInterface.OnClickListener listener = null;
        listener = new DialogInterface.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.348 -0400", hash_original_method = "9D3F97D682E1929CAA7D6B8E66CF9703", hash_generated_method = "E441E8D126BF80A46D375A9FCECC9070")
        @Override
        public void onClick(DialogInterface dialog, int which) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(which);
            addTaint(dialog.getTaint());
    if(which == DialogInterface.BUTTON_POSITIVE)            
            {
    if(mDbg)                
                log("Reboot due to SIM swap");
                PowerManager pm = (PowerManager) mPhone.getContext()
                    .getSystemService(Context.POWER_SERVICE);
                pm.reboot("SIM is added.");
            } //End block
            // ---------- Original Method ----------
            //if (which == DialogInterface.BUTTON_POSITIVE) {
                    //if (mDbg) log("Reboot due to SIM swap");
                    //PowerManager pm = (PowerManager) mPhone.getContext()
                    //.getSystemService(Context.POWER_SERVICE);
                    //pm.reboot("SIM is added.");
                //}
        }
};
        Resources r = Resources.getSystem();
        String title = (isAdded) ? r.getString(R.string.sim_added_title) :
            r.getString(R.string.sim_removed_title);
        String message = (isAdded) ? r.getString(R.string.sim_added_message) :
            r.getString(R.string.sim_removed_message);
        String buttonTxt = r.getString(R.string.sim_restart_button);
        AlertDialog dialog = new AlertDialog.Builder(mPhone.getContext())
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(buttonTxt, listener)
            .create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        dialog.show();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.349 -0400", hash_original_method = "F212AE1E9E62E46B160458ACE7EF1DC3", hash_generated_method = "C1618104C226E70BB89FF9F27F1D5817")
    private void onQueryFdnEnabled(AsyncResult ar) {
        addTaint(ar.getTaint());
    if(ar.exception != null)        
        {
    if(mDbg)            
            log("Error in querying facility lock:" + ar.exception);
            return;
        } //End block
        int[] ints = (int[])ar.result;
    if(ints.length != 0)        
        {
            mIccFdnEnabled = (0!=ints[0]);
    if(mDbg)            
            log("Query facility lock : "  + mIccFdnEnabled);
        } //End block
        else
        {
        } //End block
        // ---------- Original Method ----------
        //if(ar.exception != null) {
            //if(mDbg) log("Error in querying facility lock:" + ar.exception);
            //return;
        //}
        //int[] ints = (int[])ar.result;
        //if(ints.length != 0) {
            //mIccFdnEnabled = (0!=ints[0]);
            //if(mDbg) log("Query facility lock : "  + mIccFdnEnabled);
        //} else {
            //Log.e(mLogTag, "[IccCard] Bogus facility lock response");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.349 -0400", hash_original_method = "2D3A559A68B85B440A539D217592B783", hash_generated_method = "962868FC56D4AD77F6BF1F114BE8574E")
    private void onQueryFacilityLock(AsyncResult ar) {
        addTaint(ar.getTaint());
    if(ar.exception != null)        
        {
    if(mDbg)            
            log("Error in querying facility lock:" + ar.exception);
            return;
        } //End block
        int[] ints = (int[])ar.result;
    if(ints.length != 0)        
        {
            mIccPinLocked = (0!=ints[0]);
    if(mDbg)            
            log("Query facility lock : "  + mIccPinLocked);
        } //End block
        else
        {
        } //End block
        // ---------- Original Method ----------
        //if(ar.exception != null) {
            //if (mDbg) log("Error in querying facility lock:" + ar.exception);
            //return;
        //}
        //int[] ints = (int[])ar.result;
        //if(ints.length != 0) {
            //mIccPinLocked = (0!=ints[0]);
            //if(mDbg) log("Query facility lock : "  + mIccPinLocked);
        //} else {
            //Log.e(mLogTag, "[IccCard] Bogus facility lock response");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.350 -0400", hash_original_method = "BEDA05141A25EA0E8449469A2D08AE66", hash_generated_method = "2A4E1D8989E44D785D46D0FE0CDBA4A9")
    public void broadcastIccStateChangedIntent(String value, String reason) {
        addTaint(reason.getTaint());
        addTaint(value.getTaint());
        Intent intent = new Intent(TelephonyIntents.ACTION_SIM_STATE_CHANGED);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        intent.putExtra(Phone.PHONE_NAME_KEY, mPhone.getPhoneName());
        intent.putExtra(INTENT_KEY_ICC_STATE, value);
        intent.putExtra(INTENT_KEY_LOCKED_REASON, reason);
    if(mDbg)        
        log("Broadcasting intent ACTION_SIM_STATE_CHANGED " +  value
                + " reason " + reason);
        ActivityManagerNative.broadcastStickyIntent(intent, READ_PHONE_STATE);
        // ---------- Original Method ----------
        //Intent intent = new Intent(TelephonyIntents.ACTION_SIM_STATE_CHANGED);
        //intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        //intent.putExtra(Phone.PHONE_NAME_KEY, mPhone.getPhoneName());
        //intent.putExtra(INTENT_KEY_ICC_STATE, value);
        //intent.putExtra(INTENT_KEY_LOCKED_REASON, reason);
        //if(mDbg) log("Broadcasting intent ACTION_SIM_STATE_CHANGED " +  value
                //+ " reason " + reason);
        //ActivityManagerNative.broadcastStickyIntent(intent, READ_PHONE_STATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.350 -0400", hash_original_method = "531282E014DCDC26F790CA6DADE3C8C6", hash_generated_method = "C877E460BC8719B85C9B0D4EE7DFECD0")
    public State getIccCardState() {
    if(mIccCardStatus == null)        
        {
State varFCEDD57BF48360BF7820E13AE787AB2E_1485862774 =             IccCard.State.ABSENT;
            varFCEDD57BF48360BF7820E13AE787AB2E_1485862774.addTaint(taint);
            return varFCEDD57BF48360BF7820E13AE787AB2E_1485862774;
        } //End block
    if(!mIccCardStatus.getCardState().isCardPresent())        
        {
State varFCEDD57BF48360BF7820E13AE787AB2E_998885749 =             IccCard.State.ABSENT;
            varFCEDD57BF48360BF7820E13AE787AB2E_998885749.addTaint(taint);
            return varFCEDD57BF48360BF7820E13AE787AB2E_998885749;
        } //End block
        RadioState currentRadioState = mPhone.mCM.getRadioState();
    if(currentRadioState == RadioState.RADIO_OFF         ||
            currentRadioState == RadioState.RADIO_UNAVAILABLE ||
            currentRadioState == RadioState.SIM_NOT_READY     ||
            currentRadioState == RadioState.RUIM_NOT_READY    ||
            currentRadioState == RadioState.NV_NOT_READY      ||
            currentRadioState == RadioState.NV_READY)        
        {
State var02D409DFF15E9D7C28B89B1EDC402D16_1819226861 =             IccCard.State.NOT_READY;
            var02D409DFF15E9D7C28B89B1EDC402D16_1819226861.addTaint(taint);
            return var02D409DFF15E9D7C28B89B1EDC402D16_1819226861;
        } //End block
    if(currentRadioState == RadioState.SIM_LOCKED_OR_ABSENT  ||
            currentRadioState == RadioState.SIM_READY             ||
            currentRadioState == RadioState.RUIM_LOCKED_OR_ABSENT ||
            currentRadioState == RadioState.RUIM_READY)        
        {
            State csimState = getAppState(mIccCardStatus.getCdmaSubscriptionAppIndex());
            State usimState = getAppState(mIccCardStatus.getGsmUmtsSubscriptionAppIndex());
    if(mDbg)            
            log("USIM=" + usimState + " CSIM=" + csimState);
    if(mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE)            
            {
State varC70F0ED3658B18459C5481615BDF9123_47513910 =                 getConsolidatedState(csimState, usimState, csimState);
                varC70F0ED3658B18459C5481615BDF9123_47513910.addTaint(taint);
                return varC70F0ED3658B18459C5481615BDF9123_47513910;
            } //End block
    if(currentRadioState == RadioState.RUIM_LOCKED_OR_ABSENT ||
                currentRadioState == RadioState.RUIM_READY)            
            {
State varF6BDC09C9BF42060DFE76EF373C0511C_1808242494 =                 csimState;
                varF6BDC09C9BF42060DFE76EF373C0511C_1808242494.addTaint(taint);
                return varF6BDC09C9BF42060DFE76EF373C0511C_1808242494;
            } //End block
State var1EB83541F5404B37E217C1B56F0DA8C0_777657573 =             usimState;
            var1EB83541F5404B37E217C1B56F0DA8C0_777657573.addTaint(taint);
            return var1EB83541F5404B37E217C1B56F0DA8C0_777657573;
        } //End block
State varFCEDD57BF48360BF7820E13AE787AB2E_491629187 =         IccCard.State.ABSENT;
        varFCEDD57BF48360BF7820E13AE787AB2E_491629187.addTaint(taint);
        return varFCEDD57BF48360BF7820E13AE787AB2E_491629187;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.352 -0400", hash_original_method = "809395990E0197CB644B1DF3288DB707", hash_generated_method = "F992D3437F94703EE32F7690B23728AF")
    private State getAppState(int appIndex) {
        addTaint(appIndex);
        IccCardApplication app;
    if(appIndex >= 0 && appIndex < IccCardStatus.CARD_MAX_APPS)        
        {
            app = mIccCardStatus.getApplication(appIndex);
        } //End block
        else
        {
State varFCEDD57BF48360BF7820E13AE787AB2E_250629315 =             IccCard.State.ABSENT;
            varFCEDD57BF48360BF7820E13AE787AB2E_250629315.addTaint(taint);
            return varFCEDD57BF48360BF7820E13AE787AB2E_250629315;
        } //End block
    if(app == null)        
        {
State varFCEDD57BF48360BF7820E13AE787AB2E_436981614 =             IccCard.State.ABSENT;
            varFCEDD57BF48360BF7820E13AE787AB2E_436981614.addTaint(taint);
            return varFCEDD57BF48360BF7820E13AE787AB2E_436981614;
        } //End block
    if(app.pin1.isPermBlocked())        
        {
State var6324888BBA94EA63A4B1C5882456F969_634426299 =             IccCard.State.PERM_DISABLED;
            var6324888BBA94EA63A4B1C5882456F969_634426299.addTaint(taint);
            return var6324888BBA94EA63A4B1C5882456F969_634426299;
        } //End block
    if(app.app_state.isPinRequired())        
        {
State var88D534A38D0FF0A4E450C30A5AB5C60E_501469295 =             IccCard.State.PIN_REQUIRED;
            var88D534A38D0FF0A4E450C30A5AB5C60E_501469295.addTaint(taint);
            return var88D534A38D0FF0A4E450C30A5AB5C60E_501469295;
        } //End block
    if(app.app_state.isPukRequired())        
        {
State var35831D7DA794BA943EBE88B29052DB16_859834820 =             IccCard.State.PUK_REQUIRED;
            var35831D7DA794BA943EBE88B29052DB16_859834820.addTaint(taint);
            return var35831D7DA794BA943EBE88B29052DB16_859834820;
        } //End block
    if(app.app_state.isSubscriptionPersoEnabled())        
        {
State varC6F56ED76E89AB56CDF9095B5484343E_602550537 =             IccCard.State.NETWORK_LOCKED;
            varC6F56ED76E89AB56CDF9095B5484343E_602550537.addTaint(taint);
            return varC6F56ED76E89AB56CDF9095B5484343E_602550537;
        } //End block
    if(app.app_state.isAppReady())        
        {
State var9F689D628ADD856BBA513DAF5BD74808_538776617 =             IccCard.State.READY;
            var9F689D628ADD856BBA513DAF5BD74808_538776617.addTaint(taint);
            return var9F689D628ADD856BBA513DAF5BD74808_538776617;
        } //End block
    if(app.app_state.isAppNotReady())        
        {
State var02D409DFF15E9D7C28B89B1EDC402D16_1478271858 =             IccCard.State.NOT_READY;
            var02D409DFF15E9D7C28B89B1EDC402D16_1478271858.addTaint(taint);
            return var02D409DFF15E9D7C28B89B1EDC402D16_1478271858;
        } //End block
State var02D409DFF15E9D7C28B89B1EDC402D16_879521334 =         IccCard.State.NOT_READY;
        var02D409DFF15E9D7C28B89B1EDC402D16_879521334.addTaint(taint);
        return var02D409DFF15E9D7C28B89B1EDC402D16_879521334;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.353 -0400", hash_original_method = "292BB37BE4996383C23DC23B1670D1D7", hash_generated_method = "DF536A31BE2F10EEC061DFC2375BEDBF")
    private State getConsolidatedState(State left, State right, State preferredState) {
        addTaint(preferredState.getTaint());
        addTaint(right.getTaint());
        addTaint(left.getTaint());
    if(right == IccCard.State.ABSENT)        
        {
State var2F9EA7A95FCD838AD3645B4D4006360C_761608771 =         left;
        var2F9EA7A95FCD838AD3645B4D4006360C_761608771.addTaint(taint);
        return var2F9EA7A95FCD838AD3645B4D4006360C_761608771;
        }
    if(left == IccCard.State.ABSENT)        
        {
State varA94968893C3CAA62B2C64D402B416B0C_876595875 =         right;
        varA94968893C3CAA62B2C64D402B416B0C_876595875.addTaint(taint);
        return varA94968893C3CAA62B2C64D402B416B0C_876595875;
        }
    if((left == IccCard.State.READY) && (right == IccCard.State.READY))        
        {
State var6409814A64BE3687CEC3A7AF97CABF0F_1299244680 =             State.READY;
            var6409814A64BE3687CEC3A7AF97CABF0F_1299244680.addTaint(taint);
            return var6409814A64BE3687CEC3A7AF97CABF0F_1299244680;
        } //End block
    if(((right == IccCard.State.NOT_READY) && (left == IccCard.State.READY)) ||
            ((left == IccCard.State.NOT_READY) && (right == IccCard.State.READY)))        
        {
State var02D409DFF15E9D7C28B89B1EDC402D16_1372872754 =             IccCard.State.NOT_READY;
            var02D409DFF15E9D7C28B89B1EDC402D16_1372872754.addTaint(taint);
            return var02D409DFF15E9D7C28B89B1EDC402D16_1372872754;
        } //End block
    if(right == IccCard.State.NOT_READY)        
        {
State var2F9EA7A95FCD838AD3645B4D4006360C_1839863707 =         left;
        var2F9EA7A95FCD838AD3645B4D4006360C_1839863707.addTaint(taint);
        return var2F9EA7A95FCD838AD3645B4D4006360C_1839863707;
        }
    if(left == IccCard.State.NOT_READY)        
        {
State varA94968893C3CAA62B2C64D402B416B0C_1893175304 =         right;
        varA94968893C3CAA62B2C64D402B416B0C_1893175304.addTaint(taint);
        return varA94968893C3CAA62B2C64D402B416B0C_1893175304;
        }
State varC05083034437F20EEDDA0D9EAD73A16E_139254501 =         preferredState;
        varC05083034437F20EEDDA0D9EAD73A16E_139254501.addTaint(taint);
        return varC05083034437F20EEDDA0D9EAD73A16E_139254501;
        // ---------- Original Method ----------
        //if (right == IccCard.State.ABSENT) return left;
        //if (left == IccCard.State.ABSENT) return right;
        //if ((left == IccCard.State.READY) && (right == IccCard.State.READY)) {
            //return State.READY;
        //}
        //if (((right == IccCard.State.NOT_READY) && (left == IccCard.State.READY)) ||
            //((left == IccCard.State.NOT_READY) && (right == IccCard.State.READY))) {
            //return IccCard.State.NOT_READY;
        //}
        //if (right == IccCard.State.NOT_READY) return left;
        //if (left == IccCard.State.NOT_READY) return right;
        //return preferredState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.353 -0400", hash_original_method = "B5E8B5923B9BC39502C2387B1882FFE9", hash_generated_method = "D2E17475C946E8CB877D0914BE679316")
    public boolean isApplicationOnIcc(IccCardApplication.AppType type) {
        addTaint(type.getTaint());
    if(mIccCardStatus == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1146754392 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_268125270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_268125270;
        }
for(int i = 0;i < mIccCardStatus.getNumApplications();i++)
        {
            IccCardApplication app = mIccCardStatus.getApplication(i);
    if(app != null && app.app_type == type)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_609662613 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_64158401 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_64158401;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_322863649 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1879782461 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1879782461;
        // ---------- Original Method ----------
        //if (mIccCardStatus == null) return false;
        //for (int i = 0 ; i < mIccCardStatus.getNumApplications(); i++) {
            //IccCardApplication app = mIccCardStatus.getApplication(i);
            //if (app != null && app.app_type == type) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.354 -0400", hash_original_method = "1BA9D03EECE1275906E702F57E19B9C4", hash_generated_method = "728C70730B4C77A137DE0C5EEE1B1838")
    public boolean hasIccCard() {
    if(mIccCardStatus == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_828254653 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1065749361 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1065749361;
        } //End block
        else
        {
            boolean var8186A778FCD91F082221143CB585D5EE_1524511507 = (mIccCardStatus.getCardState().isCardPresent());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1433401279 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1433401279;
        } //End block
        // ---------- Original Method ----------
        //if (mIccCardStatus == null) {
            //return false;
        //} else {
            //return mIccCardStatus.getCardState().isCardPresent();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.354 -0400", hash_original_method = "8040171B9171EEC88FFD4AC75BEDD9D4", hash_generated_method = "6A5F7CE3BCB8CBDBACEED6AFEC446263")
    private void log(String msg) {
        addTaint(msg.getTaint());
        Log.d(mLogTag, "[IccCard] " + msg);
        // ---------- Original Method ----------
        //Log.d(mLogTag, "[IccCard] " + msg);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.355 -0400", hash_original_field = "4E8D0274A2974A4104009ED903CA7DF6", hash_generated_field = "13296FAB897D65BFBDA3BB2C514373EF")

    static public final String INTENT_KEY_ICC_STATE = "ss";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.355 -0400", hash_original_field = "415E0FF726B9974E357FB6FFD5403327", hash_generated_field = "559004855AF26038D1301B2EB2A81958")

    static public final String INTENT_VALUE_ICC_NOT_READY = "NOT_READY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.355 -0400", hash_original_field = "A698CB27956FF8C110377324B7929A28", hash_generated_field = "09E173E394E5D91B9D74B048E28CDA40")

    static public final String INTENT_VALUE_ICC_ABSENT = "ABSENT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.355 -0400", hash_original_field = "6CE86164A5E1A9E092A8E0A5B9DED311", hash_generated_field = "B9ECAC99CC48A7FA1E2E4234F2D4F8DD")

    static public final String INTENT_VALUE_ICC_LOCKED = "LOCKED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.355 -0400", hash_original_field = "D6153E40940FA2E2661254B4416303B4", hash_generated_field = "299CBCB1408043E9A327CC84FDCBEEB1")

    static public final String INTENT_VALUE_ICC_READY = "READY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.355 -0400", hash_original_field = "F4914C0EE6491535F1EC45D22E8DEED2", hash_generated_field = "B11FF3A7F190CFA1F78B0A44A9BC2F7F")

    static public final String INTENT_VALUE_ICC_IMSI = "IMSI";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.355 -0400", hash_original_field = "ABBD1334DF4188600B92AC80B86F8DE3", hash_generated_field = "5A47219824FC4CE98A1CDF755912F5D3")

    static public final String INTENT_VALUE_ICC_LOADED = "LOADED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.355 -0400", hash_original_field = "EFADDC467AAB577159B8395EF08A71E4", hash_generated_field = "B52DE1E639231C806713539135C0EC44")

    static public final String INTENT_KEY_LOCKED_REASON = "reason";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.355 -0400", hash_original_field = "F4281583CA82139E6D5B4ED808D7371B", hash_generated_field = "8CB239DD07ED9D2B9354AF9790A52085")

    static public final String INTENT_VALUE_LOCKED_ON_PIN = "PIN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.356 -0400", hash_original_field = "5308AEA1C22392C049E02997D987CC31", hash_generated_field = "9D4E8CF5E08E88C5263AD804A1CC2E40")

    static public final String INTENT_VALUE_LOCKED_ON_PUK = "PUK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.356 -0400", hash_original_field = "0E8D2CB33D7F1323388E2E9E64C40DF4", hash_generated_field = "E414FAB7F3419E8267A72ED727E98329")

    static public final String INTENT_VALUE_LOCKED_NETWORK = "NETWORK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.356 -0400", hash_original_field = "EC74C91AB18DA5EB7F83CDB921DE4FAE", hash_generated_field = "1AC6CFB4E094233EA40DDF5454436669")

    static public final String INTENT_VALUE_ABSENT_ON_PERM_DISABLED = "PERM_DISABLED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.356 -0400", hash_original_field = "DF3208C608C8153D3ED7FF08E95ABEAD", hash_generated_field = "BB00981FA4DDC48E77E3446841ED578B")

    protected static final int EVENT_ICC_LOCKED_OR_ABSENT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.356 -0400", hash_original_field = "D4E84F7920E0975E27CBE7069F5CFBF8", hash_generated_field = "6A530CAC29AE5BD3085335985B2810BD")

    private static final int EVENT_GET_ICC_STATUS_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.356 -0400", hash_original_field = "726D8DA480BD0D2C8D1177303E93D4C0", hash_generated_field = "A5743C4EFFAC98F496715C592912CE53")

    protected static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.357 -0400", hash_original_field = "93DA8E59C4139915F236D3ED564C0914", hash_generated_field = "A8FC0B827122F18799DB60E3B856F9C1")

    private static final int EVENT_PINPUK_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.357 -0400", hash_original_field = "0A2D0AB9EF09FB4BF143B595A70FCC7C", hash_generated_field = "242135FAED9E4D8578354B9454EB35C3")

    private static final int EVENT_REPOLL_STATUS_DONE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.357 -0400", hash_original_field = "7711A73FCB7752619A0750B474C480F0", hash_generated_field = "D730302ED7BCEEDF4EEB2F6802EE57FD")

    protected static final int EVENT_ICC_READY = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.357 -0400", hash_original_field = "47663F5B966A9E46338F0BB331FD5A17", hash_generated_field = "F4D6932778576F707B7936043C92F42A")

    private static final int EVENT_QUERY_FACILITY_LOCK_DONE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.357 -0400", hash_original_field = "99009BA3BF30CF722936C81F997BC5B6", hash_generated_field = "E362BB0C36E7DC31306182774E294D5E")

    private static final int EVENT_CHANGE_FACILITY_LOCK_DONE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.357 -0400", hash_original_field = "5D770D7915D16CFC9643E79BD347C3AA", hash_generated_field = "97EFE391ADDE4F597A8812D5755BC729")

    private static final int EVENT_CHANGE_ICC_PASSWORD_DONE = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.357 -0400", hash_original_field = "DCF6C78CAED9FD3FCC33C8D43C378FF0", hash_generated_field = "0DB4D493C14133032F82ADA18DCB4118")

    private static final int EVENT_QUERY_FACILITY_FDN_DONE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.357 -0400", hash_original_field = "605FAA42EB0E0BFB73A948B47A066901", hash_generated_field = "9C46342A37891DB5C8514A911C636E35")

    private static final int EVENT_CHANGE_FACILITY_FDN_DONE = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.358 -0400", hash_original_field = "8CB1C0D04994FA3BFB96074A15C85D58", hash_generated_field = "11BCA9CD0D4020ECA2009590B4FB03A5")

    private static final int EVENT_ICC_STATUS_CHANGED = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.358 -0400", hash_original_field = "FB7E9591376FC5D385C90334A6B74395", hash_generated_field = "67A04E786502FED24B042568D76A6216")

    private static final int EVENT_CARD_REMOVED = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.358 -0400", hash_original_field = "2DA616E9DFA974F9578E475C34C23EEE", hash_generated_field = "E825A176BF633732EFFA825E7EFB90AA")

    private static final int EVENT_CARD_ADDED = 14;
}

