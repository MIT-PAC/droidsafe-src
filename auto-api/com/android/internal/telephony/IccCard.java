package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    protected String mLogTag;
    protected boolean mDbg;
    private IccCardStatus mIccCardStatus = null;
    protected State mState = null;
    protected PhoneBase mPhone;
    private RegistrantList mAbsentRegistrants = new RegistrantList();
    private RegistrantList mPinLockedRegistrants = new RegistrantList();
    private RegistrantList mNetworkLockedRegistrants = new RegistrantList();
    private boolean mDesiredPinLocked;
    private boolean mDesiredFdnEnabled;
    private boolean mIccPinLocked = true;
    private boolean mIccFdnEnabled = false;
    protected Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.254 -0400", hash_original_method = "4D8A280AC680F77EA465CFA0E90830BC", hash_generated_method = "7942542D9B3B43DFD2FAB5D0B2A49724")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            AsyncResult ar;
            int serviceClassX;
            serviceClassX = CommandsInterface.SERVICE_CLASS_VOICE +
                            CommandsInterface.SERVICE_CLASS_DATA +
                            CommandsInterface.SERVICE_CLASS_FAX;
            //Begin case EVENT_RADIO_OFF_OR_NOT_AVAILABLE 
            mState = null;
            //End case EVENT_RADIO_OFF_OR_NOT_AVAILABLE 
            //Begin case EVENT_RADIO_OFF_OR_NOT_AVAILABLE 
            updateStateProperty();
            //End case EVENT_RADIO_OFF_OR_NOT_AVAILABLE 
            //Begin case EVENT_RADIO_OFF_OR_NOT_AVAILABLE 
            broadcastIccStateChangedIntent(INTENT_VALUE_ICC_NOT_READY, null);
            //End case EVENT_RADIO_OFF_OR_NOT_AVAILABLE 
            //Begin case EVENT_ICC_READY 
            mPhone.mCM.getIccCardStatus(obtainMessage(EVENT_GET_ICC_STATUS_DONE));
            //End case EVENT_ICC_READY 
            //Begin case EVENT_ICC_READY 
            mPhone.mCM.queryFacilityLock (
                            CommandsInterface.CB_FACILITY_BA_SIM, "", serviceClassX,
                            obtainMessage(EVENT_QUERY_FACILITY_LOCK_DONE));
            //End case EVENT_ICC_READY 
            //Begin case EVENT_ICC_READY 
            mPhone.mCM.queryFacilityLock (
                            CommandsInterface.CB_FACILITY_BA_FD, "", serviceClassX,
                            obtainMessage(EVENT_QUERY_FACILITY_FDN_DONE));
            //End case EVENT_ICC_READY 
            //Begin case EVENT_ICC_LOCKED_OR_ABSENT 
            mPhone.mCM.getIccCardStatus(obtainMessage(EVENT_GET_ICC_STATUS_DONE));
            //End case EVENT_ICC_LOCKED_OR_ABSENT 
            //Begin case EVENT_ICC_LOCKED_OR_ABSENT 
            mPhone.mCM.queryFacilityLock (
                            CommandsInterface.CB_FACILITY_BA_SIM, "", serviceClassX,
                            obtainMessage(EVENT_QUERY_FACILITY_LOCK_DONE));
            //End case EVENT_ICC_LOCKED_OR_ABSENT 
            //Begin case EVENT_GET_ICC_STATUS_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_ICC_STATUS_DONE 
            //Begin case EVENT_GET_ICC_STATUS_DONE 
            getIccCardStatusDone(ar);
            //End case EVENT_GET_ICC_STATUS_DONE 
            //Begin case EVENT_PINPUK_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_PINPUK_DONE 
            //Begin case EVENT_PINPUK_DONE 
            AsyncResult.forMessage(((Message)ar.userObj)).exception
                                                        = ar.exception;
            //End case EVENT_PINPUK_DONE 
            //Begin case EVENT_PINPUK_DONE 
            mPhone.mCM.getIccCardStatus(
                        obtainMessage(EVENT_REPOLL_STATUS_DONE, ar.userObj));
            //End case EVENT_PINPUK_DONE 
            //Begin case EVENT_REPOLL_STATUS_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_REPOLL_STATUS_DONE 
            //Begin case EVENT_REPOLL_STATUS_DONE 
            getIccCardStatusDone(ar);
            //End case EVENT_REPOLL_STATUS_DONE 
            //Begin case EVENT_REPOLL_STATUS_DONE 
            ((Message)ar.userObj).sendToTarget();
            //End case EVENT_REPOLL_STATUS_DONE 
            //Begin case EVENT_QUERY_FACILITY_LOCK_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_QUERY_FACILITY_LOCK_DONE 
            //Begin case EVENT_QUERY_FACILITY_LOCK_DONE 
            onQueryFacilityLock(ar);
            //End case EVENT_QUERY_FACILITY_LOCK_DONE 
            //Begin case EVENT_QUERY_FACILITY_FDN_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_QUERY_FACILITY_FDN_DONE 
            //Begin case EVENT_QUERY_FACILITY_FDN_DONE 
            onQueryFdnEnabled(ar);
            //End case EVENT_QUERY_FACILITY_FDN_DONE 
            //Begin case EVENT_CHANGE_FACILITY_LOCK_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_CHANGE_FACILITY_LOCK_DONE 
            //Begin case EVENT_CHANGE_FACILITY_LOCK_DONE 
            {
                mIccPinLocked = mDesiredPinLocked;
                log( "EVENT_CHANGE_FACILITY_LOCK_DONE: " +
                                "mIccPinLocked= " + mIccPinLocked);
            } //End block
            //End case EVENT_CHANGE_FACILITY_LOCK_DONE 
            //Begin case EVENT_CHANGE_FACILITY_LOCK_DONE 
            AsyncResult.forMessage(((Message)ar.userObj)).exception
                                                        = ar.exception;
            //End case EVENT_CHANGE_FACILITY_LOCK_DONE 
            //Begin case EVENT_CHANGE_FACILITY_LOCK_DONE 
            ((Message)ar.userObj).sendToTarget();
            //End case EVENT_CHANGE_FACILITY_LOCK_DONE 
            //Begin case EVENT_CHANGE_FACILITY_FDN_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_CHANGE_FACILITY_FDN_DONE 
            //Begin case EVENT_CHANGE_FACILITY_FDN_DONE 
            {
                mIccFdnEnabled = mDesiredFdnEnabled;
                log("EVENT_CHANGE_FACILITY_FDN_DONE: " +
                                "mIccFdnEnabled=" + mIccFdnEnabled);
            } //End block
            //End case EVENT_CHANGE_FACILITY_FDN_DONE 
            //Begin case EVENT_CHANGE_FACILITY_FDN_DONE 
            AsyncResult.forMessage(((Message)ar.userObj)).exception
                                                        = ar.exception;
            //End case EVENT_CHANGE_FACILITY_FDN_DONE 
            //Begin case EVENT_CHANGE_FACILITY_FDN_DONE 
            ((Message)ar.userObj).sendToTarget();
            //End case EVENT_CHANGE_FACILITY_FDN_DONE 
            //Begin case EVENT_CHANGE_ICC_PASSWORD_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_CHANGE_ICC_PASSWORD_DONE 
            //Begin case EVENT_CHANGE_ICC_PASSWORD_DONE 
            AsyncResult.forMessage(((Message)ar.userObj)).exception
                                                        = ar.exception;
            //End case EVENT_CHANGE_ICC_PASSWORD_DONE 
            //Begin case EVENT_CHANGE_ICC_PASSWORD_DONE 
            ((Message)ar.userObj).sendToTarget();
            //End case EVENT_CHANGE_ICC_PASSWORD_DONE 
            //Begin case EVENT_ICC_STATUS_CHANGED 
            Log.d(mLogTag, "Received Event EVENT_ICC_STATUS_CHANGED");
            //End case EVENT_ICC_STATUS_CHANGED 
            //Begin case EVENT_ICC_STATUS_CHANGED 
            mPhone.mCM.getIccCardStatus(obtainMessage(EVENT_GET_ICC_STATUS_DONE));
            //End case EVENT_ICC_STATUS_CHANGED 
            //Begin case EVENT_CARD_REMOVED 
            onIccSwap(false);
            //End case EVENT_CARD_REMOVED 
            //Begin case EVENT_CARD_ADDED 
            onIccSwap(true);
            //End case EVENT_CARD_ADDED 
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.255 -0400", hash_original_method = "A83C78588609731AFA33B82B4815F4C9", hash_generated_method = "5F6E1FB5CFB70C3895DBB4678C3118A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IccCard(PhoneBase phone, String logTag, Boolean dbg) {
        dsTaint.addTaint(phone.dsTaint);
        dsTaint.addTaint(logTag);
        dsTaint.addTaint(dbg.dsTaint);
        mPhone.mCM.registerForIccStatusChanged(mHandler, EVENT_ICC_STATUS_CHANGED, null);
        // ---------- Original Method ----------
        //mPhone = phone;
        //mPhone.mCM.registerForIccStatusChanged(mHandler, EVENT_ICC_STATUS_CHANGED, null);
        //mLogTag = logTag;
        //mDbg = dbg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.255 -0400", hash_original_method = "B45586395D9726A6E3A7A444B2DA9D4A", hash_generated_method = "E5D897DFC132C7913F933035F2907B9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public State getState() {
        {
            {
                Object var665508131374E03DAE4229BE09CD1E54_972960139 = (mPhone.mCM.getRadioState());
            } //End collapsed parenthetic
        } //End block
        return (State)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.255 -0400", hash_original_method = "EF67D81D926CA0EC8F8754BC29C8826B", hash_generated_method = "8FB4003EBB7FCD2F2B0FD7E02F818470")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispose() {
        mPhone.mCM.unregisterForIccStatusChanged(mHandler);
        // ---------- Original Method ----------
        //mPhone.mCM.unregisterForIccStatusChanged(mHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.255 -0400", hash_original_method = "C148A728067D02A221BE75C987C5D733", hash_generated_method = "DA32AB009F09FF38C5F0C4E45A947EAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() {
        Log.d(mLogTag, "IccCard finalized");
        // ---------- Original Method ----------
        //if(mDbg) Log.d(mLogTag, "IccCard finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.255 -0400", hash_original_method = "45A4F957AA9A104F89D6FFEF5C13C9B4", hash_generated_method = "1378C63A426D950EE6DCBCDDCFAA0B63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForAbsent(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mAbsentRegistrants.add(r);
        {
            boolean var9D1D545BFB2ACC918D763D35EA51A235_1388393610 = (getState() == State.ABSENT);
            {
                r.notifyRegistrant();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mAbsentRegistrants.add(r);
        //if (getState() == State.ABSENT) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.256 -0400", hash_original_method = "A388490F008524959D490318F4B49030", hash_generated_method = "B84D131D6F8D668EFF38E46A82C5CD57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForAbsent(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mAbsentRegistrants.remove(h);
        // ---------- Original Method ----------
        //mAbsentRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.256 -0400", hash_original_method = "DD13D18C49861341C8AF8EABF1CC2E24", hash_generated_method = "0CD7FA118A3A32CA4011BDCC940059BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForNetworkLocked(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mNetworkLockedRegistrants.add(r);
        {
            boolean var2F3573EBEB4638AFD6B56CE330BB1FB4_345213475 = (getState() == State.NETWORK_LOCKED);
            {
                r.notifyRegistrant();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mNetworkLockedRegistrants.add(r);
        //if (getState() == State.NETWORK_LOCKED) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.256 -0400", hash_original_method = "5CEB6427435BFB9EC514E781B4093E7E", hash_generated_method = "86C95021EC47CCD19EA543067750F76F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForNetworkLocked(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mNetworkLockedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mNetworkLockedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.256 -0400", hash_original_method = "A158B3B1FDF0C70FEF29C25B6F4DD072", hash_generated_method = "791E9CEA83FE127735CB5132D397B0EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForLocked(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mPinLockedRegistrants.add(r);
        {
            boolean var4F041DD310E7150642EAFA2D007725C8_79993802 = (getState().isPinLocked());
            {
                r.notifyRegistrant();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mPinLockedRegistrants.add(r);
        //if (getState().isPinLocked()) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.256 -0400", hash_original_method = "5667345A02500557814700DAC5845BCA", hash_generated_method = "3238A33867E9C0E54F3927689BD2BC10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForLocked(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mPinLockedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mPinLockedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.257 -0400", hash_original_method = "ADEE02A4D2D0DF5B5C1110C0F3EF40D9", hash_generated_method = "405FFD2716D5B32F8EC7FF392667BCCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void supplyPin(String pin, Message onComplete) {
        dsTaint.addTaint(pin);
        dsTaint.addTaint(onComplete.dsTaint);
        mPhone.mCM.supplyIccPin(pin, mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
        // ---------- Original Method ----------
        //mPhone.mCM.supplyIccPin(pin, mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.257 -0400", hash_original_method = "F069297D525546A0218C2FB5A43E0287", hash_generated_method = "007676AACD004DAE377A9CD8E4659378")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void supplyPuk(String puk, String newPin, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(puk);
        dsTaint.addTaint(newPin);
        mPhone.mCM.supplyIccPuk(puk, newPin,
                mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
        // ---------- Original Method ----------
        //mPhone.mCM.supplyIccPuk(puk, newPin,
                //mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.257 -0400", hash_original_method = "35EFF2F2C787166AB4A51F303C9455F4", hash_generated_method = "997A630B401EFCB10356D0DDAD6E231A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void supplyPin2(String pin2, Message onComplete) {
        dsTaint.addTaint(pin2);
        dsTaint.addTaint(onComplete.dsTaint);
        mPhone.mCM.supplyIccPin2(pin2,
                mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
        // ---------- Original Method ----------
        //mPhone.mCM.supplyIccPin2(pin2,
                //mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.257 -0400", hash_original_method = "982062922CE016EAC29E809D9B066C8E", hash_generated_method = "3BC354B1F7A81AD2A8D2A8C98AC3763D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void supplyPuk2(String puk2, String newPin2, Message onComplete) {
        dsTaint.addTaint(puk2);
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(newPin2);
        mPhone.mCM.supplyIccPuk2(puk2, newPin2,
                mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
        // ---------- Original Method ----------
        //mPhone.mCM.supplyIccPuk2(puk2, newPin2,
                //mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.257 -0400", hash_original_method = "96497D4DFF6E2FE9CEEE26788CBD4E3F", hash_generated_method = "FF11D5560FABDD7145FCFC6659C54715")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void supplyNetworkDepersonalization(String pin, Message onComplete) {
        dsTaint.addTaint(pin);
        dsTaint.addTaint(onComplete.dsTaint);
        mPhone.mCM.supplyNetworkDepersonalization(pin,
                mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
        // ---------- Original Method ----------
        //mPhone.mCM.supplyNetworkDepersonalization(pin,
                //mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.257 -0400", hash_original_method = "BCA6EFC1210C838BF4CD916790946AA6", hash_generated_method = "A00530B202809B5ED469576EFE18C72F")
    @DSModeled(DSC.SAFE)
    public boolean getIccLockEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIccPinLocked;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.258 -0400", hash_original_method = "F2BBF6EB30564DA8841F6D4A48D01D80", hash_generated_method = "8928FBE0EE56586F1949AF911E293944")
    @DSModeled(DSC.SAFE)
    public boolean getIccFdnEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIccFdnEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.258 -0400", hash_original_method = "3DCE16ED303A66C1573E6E04CDCFB500", hash_generated_method = "D41ED8B9B192D8160DAD84CB4F38E0B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIccLockEnabled(boolean enabled,
             String password, Message onComplete) {
        dsTaint.addTaint(enabled);
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(password);
        int serviceClassX;
        serviceClassX = CommandsInterface.SERVICE_CLASS_VOICE +
                 CommandsInterface.SERVICE_CLASS_DATA +
                 CommandsInterface.SERVICE_CLASS_FAX;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.258 -0400", hash_original_method = "42161809775FC8FDBB38BE3E5058E399", hash_generated_method = "6243560B833EFBDF015360BE7EAE064D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIccFdnEnabled(boolean enabled,
             String password, Message onComplete) {
        dsTaint.addTaint(enabled);
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(password);
        int serviceClassX;
        serviceClassX = CommandsInterface.SERVICE_CLASS_VOICE +
                 CommandsInterface.SERVICE_CLASS_DATA +
                 CommandsInterface.SERVICE_CLASS_FAX +
                 CommandsInterface.SERVICE_CLASS_SMS;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.258 -0400", hash_original_method = "CFACBB8EE591380B6F953CA4501BCE4D", hash_generated_method = "EA017A8B4ED4FD5A3F972F5DC6FB6FAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void changeIccLockPassword(String oldPassword, String newPassword,
             Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(newPassword);
        dsTaint.addTaint(oldPassword);
        mPhone.mCM.changeIccPin(oldPassword, newPassword,
                 mHandler.obtainMessage(EVENT_CHANGE_ICC_PASSWORD_DONE, onComplete));
        // ---------- Original Method ----------
        //mPhone.mCM.changeIccPin(oldPassword, newPassword,
                 //mHandler.obtainMessage(EVENT_CHANGE_ICC_PASSWORD_DONE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.259 -0400", hash_original_method = "78AE6F1E64D3743DF4893D59C6AFA5E2", hash_generated_method = "336EAC55661AD17A224AB4B4132282C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void changeIccFdnPassword(String oldPassword, String newPassword,
             Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(newPassword);
        dsTaint.addTaint(oldPassword);
        mPhone.mCM.changeIccPin2(oldPassword, newPassword,
                 mHandler.obtainMessage(EVENT_CHANGE_ICC_PASSWORD_DONE, onComplete));
        // ---------- Original Method ----------
        //mPhone.mCM.changeIccPin2(oldPassword, newPassword,
                 //mHandler.obtainMessage(EVENT_CHANGE_ICC_PASSWORD_DONE, onComplete));
    }

    
    public abstract String getServiceProviderName();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.259 -0400", hash_original_method = "26BBB856B8138972809A4E6EC2BCC376", hash_generated_method = "4A1645AE835255FE7642245C74B88BD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void updateStateProperty() {
        mPhone.setSystemProperty(TelephonyProperties.PROPERTY_SIM_STATE, getState().toString());
        // ---------- Original Method ----------
        //mPhone.setSystemProperty(TelephonyProperties.PROPERTY_SIM_STATE, getState().toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.259 -0400", hash_original_method = "B8050A82EEEB3E75B61D0D7FED84BD4F", hash_generated_method = "C075136A8F14990B91F468855C77EECA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void getIccCardStatusDone(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.260 -0400", hash_original_method = "EDEEC41729C236C302C7B6E1F1DF026D", hash_generated_method = "836852A0ED21D135D9C63A0B415BF85C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleIccCardStatus(IccCardStatus newCardStatus) {
        dsTaint.addTaint(newCardStatus.dsTaint);
        boolean transitionedIntoPinLocked;
        boolean transitionedIntoAbsent;
        boolean transitionedIntoNetworkLocked;
        boolean transitionedIntoPermBlocked;
        boolean isIccCardRemoved;
        boolean isIccCardAdded;
        State oldState, newState;
        oldState = mState;
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
        } //End block
        {
            log("Notify SIM missing.");
            mAbsentRegistrants.notifyRegistrants();
            broadcastIccStateChangedIntent(INTENT_VALUE_ICC_ABSENT, null);
        } //End block
        {
            log("Notify SIM network locked.");
            mNetworkLockedRegistrants.notifyRegistrants();
            broadcastIccStateChangedIntent(INTENT_VALUE_ICC_LOCKED,
                  INTENT_VALUE_LOCKED_NETWORK);
        } //End block
        {
            log("Notify SIM permanently disabled.");
            broadcastIccStateChangedIntent(INTENT_VALUE_ICC_ABSENT,
                    INTENT_VALUE_ABSENT_ON_PERM_DISABLED);
        } //End block
        {
            mHandler.sendMessage(mHandler.obtainMessage(EVENT_CARD_REMOVED, null));
        } //End block
        {
            mHandler.sendMessage(mHandler.obtainMessage(EVENT_CARD_ADDED, null));
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.261 -0400", hash_original_method = "482C40D5983445C1A7C95EBEDC56AC82", hash_generated_method = "04204A965582B7DFF0E27640D1BC737A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onIccSwap(boolean isAdded) {
        dsTaint.addTaint(isAdded);
        DialogInterface.OnClickListener listener;
        listener = null;
        listener = new DialogInterface.OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.261 -0400", hash_original_method = "9D3F97D682E1929CAA7D6B8E66CF9703", hash_generated_method = "0E293DA1AB752E8D2073A40A3CF935D2")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(which);
                dsTaint.addTaint(dialog.dsTaint);
                {
                    log("Reboot due to SIM swap");
                    PowerManager pm;
                    pm = (PowerManager) mPhone.getContext()
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
        Resources r;
        r = Resources.getSystem();
        String title;
        title = r.getString(R.string.sim_added_title);
        title = r.getString(R.string.sim_removed_title);
        String message;
        message = r.getString(R.string.sim_added_message);
        message = r.getString(R.string.sim_removed_message);
        String buttonTxt;
        buttonTxt = r.getString(R.string.sim_restart_button);
        AlertDialog dialog;
        dialog = new AlertDialog.Builder(mPhone.getContext())
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(buttonTxt, listener)
            .create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        dialog.show();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.261 -0400", hash_original_method = "F212AE1E9E62E46B160458ACE7EF1DC3", hash_generated_method = "43FF40CDA7A1A766DA972DED48C64569")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onQueryFdnEnabled(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
        {
            log("Error in querying facility lock:" + ar.exception);
        } //End block
        int[] ints;
        ints = (int[])ar.result;
        {
            mIccFdnEnabled = (0!=ints[0]);
            log("Query facility lock : "  + mIccFdnEnabled);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.261 -0400", hash_original_method = "2D3A559A68B85B440A539D217592B783", hash_generated_method = "6B0E34C30689329088EE798B8245F793")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onQueryFacilityLock(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
        {
            log("Error in querying facility lock:" + ar.exception);
        } //End block
        int[] ints;
        ints = (int[])ar.result;
        {
            mIccPinLocked = (0!=ints[0]);
            log("Query facility lock : "  + mIccPinLocked);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.262 -0400", hash_original_method = "BEDA05141A25EA0E8449469A2D08AE66", hash_generated_method = "DF533FA2E6EF3F77EA41A5343D2AD719")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void broadcastIccStateChangedIntent(String value, String reason) {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(value);
        Intent intent;
        intent = new Intent(TelephonyIntents.ACTION_SIM_STATE_CHANGED);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        intent.putExtra(Phone.PHONE_NAME_KEY, mPhone.getPhoneName());
        intent.putExtra(INTENT_KEY_ICC_STATE, value);
        intent.putExtra(INTENT_KEY_LOCKED_REASON, reason);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.262 -0400", hash_original_method = "531282E014DCDC26F790CA6DADE3C8C6", hash_generated_method = "2F91F4C7CD68CE45B6152D824FDAC5F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public State getIccCardState() {
        {
            boolean var37EB664FE23E2FAE1F059F1BE9FE3DC1_1497441292 = (!mIccCardStatus.getCardState().isCardPresent());
        } //End collapsed parenthetic
        RadioState currentRadioState;
        currentRadioState = mPhone.mCM.getRadioState();
        {
            State csimState;
            csimState = getAppState(mIccCardStatus.getCdmaSubscriptionAppIndex());
            State usimState;
            usimState = getAppState(mIccCardStatus.getGsmUmtsSubscriptionAppIndex());
            log("USIM=" + usimState + " CSIM=" + csimState);
            {
                boolean var77E61B402E06F4B2589B17903F68887C_1094493405 = (mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE);
                {
                    State var55370511744D280B9A118D3BDEB96B4F_1843521395 = (getConsolidatedState(csimState, usimState, csimState));
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (State)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.263 -0400", hash_original_method = "809395990E0197CB644B1DF3288DB707", hash_generated_method = "D8A2A335F2F487CBBBBB48E57534724B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private State getAppState(int appIndex) {
        dsTaint.addTaint(appIndex);
        IccCardApplication app;
        {
            app = mIccCardStatus.getApplication(appIndex);
        } //End block
        {
            boolean varD79448EF50A427003D4C76CECD605C72_267243007 = (app.pin1.isPermBlocked());
        } //End collapsed parenthetic
        {
            boolean var1945F3B200D512171D5265F4A46FA51E_418759669 = (app.app_state.isPinRequired());
        } //End collapsed parenthetic
        {
            boolean var61EBE391DFCFAFB0FB7193188270151E_1227294234 = (app.app_state.isPukRequired());
        } //End collapsed parenthetic
        {
            boolean varA6084E236BBD4BA404CD38B01625DB98_574955684 = (app.app_state.isSubscriptionPersoEnabled());
        } //End collapsed parenthetic
        {
            boolean var0542E857D2243312200D238063975376_669335564 = (app.app_state.isAppReady());
        } //End collapsed parenthetic
        {
            boolean var6CCD9C0F390C721F8CA6FD75317DDB79_122564562 = (app.app_state.isAppNotReady());
        } //End collapsed parenthetic
        return (State)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.263 -0400", hash_original_method = "292BB37BE4996383C23DC23B1670D1D7", hash_generated_method = "6FA486BD6C1F62C300076DF637B1A85B")
    @DSModeled(DSC.SAFE)
    private State getConsolidatedState(State left, State right, State preferredState) {
        dsTaint.addTaint(left.dsTaint);
        dsTaint.addTaint(preferredState.dsTaint);
        dsTaint.addTaint(right.dsTaint);
        return (State)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.263 -0400", hash_original_method = "B5E8B5923B9BC39502C2387B1882FFE9", hash_generated_method = "272128D2E081836390698AAB352C3305")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isApplicationOnIcc(IccCardApplication.AppType type) {
        dsTaint.addTaint(type.dsTaint);
        {
            int i;
            i = 0;
            boolean var2346A46A01A4552FF6397DC9B45B0FA6_712740947 = (i < mIccCardStatus.getNumApplications());
            {
                IccCardApplication app;
                app = mIccCardStatus.getApplication(i);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.263 -0400", hash_original_method = "1BA9D03EECE1275906E702F57E19B9C4", hash_generated_method = "C5B15B662FBB076F9E13336B49506FC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasIccCard() {
        {
            boolean var5F1FEE56A00FEFA0965524059C0855DA_189265326 = (mIccCardStatus.getCardState().isCardPresent());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mIccCardStatus == null) {
            //return false;
        //} else {
            //return mIccCardStatus.getCardState().isCardPresent();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.264 -0400", hash_original_method = "8040171B9171EEC88FFD4AC75BEDD9D4", hash_generated_method = "C62F179D0C9E55B2082CC12E64F81079")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void log(String msg) {
        dsTaint.addTaint(msg);
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

    
    static public final String INTENT_KEY_ICC_STATE = "ss";
    static public final String INTENT_VALUE_ICC_NOT_READY = "NOT_READY";
    static public final String INTENT_VALUE_ICC_ABSENT = "ABSENT";
    static public final String INTENT_VALUE_ICC_LOCKED = "LOCKED";
    static public final String INTENT_VALUE_ICC_READY = "READY";
    static public final String INTENT_VALUE_ICC_IMSI = "IMSI";
    static public final String INTENT_VALUE_ICC_LOADED = "LOADED";
    static public final String INTENT_KEY_LOCKED_REASON = "reason";
    static public final String INTENT_VALUE_LOCKED_ON_PIN = "PIN";
    static public final String INTENT_VALUE_LOCKED_ON_PUK = "PUK";
    static public final String INTENT_VALUE_LOCKED_NETWORK = "NETWORK";
    static public final String INTENT_VALUE_ABSENT_ON_PERM_DISABLED = "PERM_DISABLED";
    protected static final int EVENT_ICC_LOCKED_OR_ABSENT = 1;
    private static final int EVENT_GET_ICC_STATUS_DONE = 2;
    protected static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = 3;
    private static final int EVENT_PINPUK_DONE = 4;
    private static final int EVENT_REPOLL_STATUS_DONE = 5;
    protected static final int EVENT_ICC_READY = 6;
    private static final int EVENT_QUERY_FACILITY_LOCK_DONE = 7;
    private static final int EVENT_CHANGE_FACILITY_LOCK_DONE = 8;
    private static final int EVENT_CHANGE_ICC_PASSWORD_DONE = 9;
    private static final int EVENT_QUERY_FACILITY_FDN_DONE = 10;
    private static final int EVENT_CHANGE_FACILITY_FDN_DONE = 11;
    private static final int EVENT_ICC_STATUS_CHANGED = 12;
    private static final int EVENT_CARD_REMOVED = 13;
    private static final int EVENT_CARD_ADDED = 14;
}

