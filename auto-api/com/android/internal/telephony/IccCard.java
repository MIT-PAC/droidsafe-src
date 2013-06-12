package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    protected Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.085 -0400", hash_original_method = "4D8A280AC680F77EA465CFA0E90830BC", hash_generated_method = "DA3B3E66E94775EA8AE646B8C004A13F")
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.086 -0400", hash_original_method = "A83C78588609731AFA33B82B4815F4C9", hash_generated_method = "2F0D31885D22C0C1BAA9C945255BFA83")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.086 -0400", hash_original_method = "B45586395D9726A6E3A7A444B2DA9D4A", hash_generated_method = "E2FA77BBD0E850D7B3AC7C37C883A242")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public State getState() {
        {
            {
                Object var665508131374E03DAE4229BE09CD1E54_1330065948 = (mPhone.mCM.getRadioState());
            } //End collapsed parenthetic
        } //End block
        return (State)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.086 -0400", hash_original_method = "EF67D81D926CA0EC8F8754BC29C8826B", hash_generated_method = "4EC53D2AE51F2CD04D8BD50D37849868")
    @DSModeled(DSC.SAFE)
    public void dispose() {
        mPhone.mCM.unregisterForIccStatusChanged(mHandler);
        // ---------- Original Method ----------
        //mPhone.mCM.unregisterForIccStatusChanged(mHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.086 -0400", hash_original_method = "C148A728067D02A221BE75C987C5D733", hash_generated_method = "766D8E1FA00AD24061C550BC8C237145")
    @DSModeled(DSC.SAFE)
    protected void finalize() {
        Log.d(mLogTag, "IccCard finalized");
        // ---------- Original Method ----------
        //if(mDbg) Log.d(mLogTag, "IccCard finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.086 -0400", hash_original_method = "45A4F957AA9A104F89D6FFEF5C13C9B4", hash_generated_method = "49DA2047C94BE37D72EAED6A149D3596")
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
            boolean var9D1D545BFB2ACC918D763D35EA51A235_1144530650 = (getState() == State.ABSENT);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.086 -0400", hash_original_method = "A388490F008524959D490318F4B49030", hash_generated_method = "592FE5CBB66AFB95B510209B20CB5C0F")
    @DSModeled(DSC.SAFE)
    public void unregisterForAbsent(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mAbsentRegistrants.remove(h);
        // ---------- Original Method ----------
        //mAbsentRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.086 -0400", hash_original_method = "DD13D18C49861341C8AF8EABF1CC2E24", hash_generated_method = "5E867C3EFDE9DE353A2752386BC3935E")
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
            boolean var2F3573EBEB4638AFD6B56CE330BB1FB4_820025635 = (getState() == State.NETWORK_LOCKED);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.086 -0400", hash_original_method = "5CEB6427435BFB9EC514E781B4093E7E", hash_generated_method = "F5A44D85CF4405802B335FABB4BF941D")
    @DSModeled(DSC.SAFE)
    public void unregisterForNetworkLocked(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mNetworkLockedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mNetworkLockedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.086 -0400", hash_original_method = "A158B3B1FDF0C70FEF29C25B6F4DD072", hash_generated_method = "5E699693968F743FECD13FDC9BF062B2")
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
            boolean var4F041DD310E7150642EAFA2D007725C8_875371131 = (getState().isPinLocked());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.087 -0400", hash_original_method = "5667345A02500557814700DAC5845BCA", hash_generated_method = "2E83D1C7D8F5B743E89F2CF17A969E20")
    @DSModeled(DSC.SAFE)
    public void unregisterForLocked(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mPinLockedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mPinLockedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.087 -0400", hash_original_method = "ADEE02A4D2D0DF5B5C1110C0F3EF40D9", hash_generated_method = "6D6C4798FE2185428ED32560715D5331")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void supplyPin(String pin, Message onComplete) {
        dsTaint.addTaint(pin);
        dsTaint.addTaint(onComplete.dsTaint);
        mPhone.mCM.supplyIccPin(pin, mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
        // ---------- Original Method ----------
        //mPhone.mCM.supplyIccPin(pin, mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.087 -0400", hash_original_method = "F069297D525546A0218C2FB5A43E0287", hash_generated_method = "193EFBD51B2BC571B1AEC22EF11450DF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.087 -0400", hash_original_method = "35EFF2F2C787166AB4A51F303C9455F4", hash_generated_method = "646E7BEE00813723B01C4FE844ECDE48")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.087 -0400", hash_original_method = "982062922CE016EAC29E809D9B066C8E", hash_generated_method = "DDF896D759892B3C390080AFF681C5B6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.087 -0400", hash_original_method = "96497D4DFF6E2FE9CEEE26788CBD4E3F", hash_generated_method = "B40F61D52352604895B8C6E570D316D0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.087 -0400", hash_original_method = "BCA6EFC1210C838BF4CD916790946AA6", hash_generated_method = "45C72123C3122EBAA54772F7DA461F7C")
    @DSModeled(DSC.SAFE)
    public boolean getIccLockEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIccPinLocked;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.087 -0400", hash_original_method = "F2BBF6EB30564DA8841F6D4A48D01D80", hash_generated_method = "959292609F420AD9DFBC612E256FBC20")
    @DSModeled(DSC.SAFE)
    public boolean getIccFdnEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIccFdnEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.087 -0400", hash_original_method = "3DCE16ED303A66C1573E6E04CDCFB500", hash_generated_method = "407287955F042DDE29A2482D296E8499")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.089 -0400", hash_original_method = "42161809775FC8FDBB38BE3E5058E399", hash_generated_method = "F7F6957285842AE6DCB7EA496751426C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.089 -0400", hash_original_method = "CFACBB8EE591380B6F953CA4501BCE4D", hash_generated_method = "9C2BBA006C64FE01130F6DFC86096E0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void changeIccLockPassword(String oldPassword, String newPassword,
             Message onComplete) {
        dsTaint.addTaint(newPassword);
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(oldPassword);
        mPhone.mCM.changeIccPin(oldPassword, newPassword,
                 mHandler.obtainMessage(EVENT_CHANGE_ICC_PASSWORD_DONE, onComplete));
        // ---------- Original Method ----------
        //mPhone.mCM.changeIccPin(oldPassword, newPassword,
                 //mHandler.obtainMessage(EVENT_CHANGE_ICC_PASSWORD_DONE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.089 -0400", hash_original_method = "78AE6F1E64D3743DF4893D59C6AFA5E2", hash_generated_method = "E8FBF8301DDF7E56DE47A17C19EB263E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void changeIccFdnPassword(String oldPassword, String newPassword,
             Message onComplete) {
        dsTaint.addTaint(newPassword);
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(oldPassword);
        mPhone.mCM.changeIccPin2(oldPassword, newPassword,
                 mHandler.obtainMessage(EVENT_CHANGE_ICC_PASSWORD_DONE, onComplete));
        // ---------- Original Method ----------
        //mPhone.mCM.changeIccPin2(oldPassword, newPassword,
                 //mHandler.obtainMessage(EVENT_CHANGE_ICC_PASSWORD_DONE, onComplete));
    }

    
    public abstract String getServiceProviderName();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.089 -0400", hash_original_method = "26BBB856B8138972809A4E6EC2BCC376", hash_generated_method = "D951B18617A71013C77331E81E4B22D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void updateStateProperty() {
        mPhone.setSystemProperty(TelephonyProperties.PROPERTY_SIM_STATE, getState().toString());
        // ---------- Original Method ----------
        //mPhone.setSystemProperty(TelephonyProperties.PROPERTY_SIM_STATE, getState().toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.089 -0400", hash_original_method = "B8050A82EEEB3E75B61D0D7FED84BD4F", hash_generated_method = "67D82C8035110DA7CF0A925D6FB77A7C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.089 -0400", hash_original_method = "EDEEC41729C236C302C7B6E1F1DF026D", hash_generated_method = "A8EDC9CC3C4BB49859EED61529E62C9A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.090 -0400", hash_original_method = "482C40D5983445C1A7C95EBEDC56AC82", hash_generated_method = "763CBCB3BB69D82EA8FD05E0A6EB89DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onIccSwap(boolean isAdded) {
        dsTaint.addTaint(isAdded);
        DialogInterface.OnClickListener listener;
        listener = null;
        listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    if (mDbg) log("Reboot due to SIM swap");
                    PowerManager pm = (PowerManager) mPhone.getContext()
                    .getSystemService(Context.POWER_SERVICE);
                    pm.reboot("SIM is added.");
                }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.090 -0400", hash_original_method = "F212AE1E9E62E46B160458ACE7EF1DC3", hash_generated_method = "3FA5E498186364ADAE69831CC02C7725")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.090 -0400", hash_original_method = "2D3A559A68B85B440A539D217592B783", hash_generated_method = "F96366EA81D8C0F4A835FA90ACD4161E")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.090 -0400", hash_original_method = "BEDA05141A25EA0E8449469A2D08AE66", hash_generated_method = "A65A6D55C2744504FC7B8D3A4B0360A4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.090 -0400", hash_original_method = "531282E014DCDC26F790CA6DADE3C8C6", hash_generated_method = "6051C0671E1BA2A4C0BB2D46AFB66E5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public State getIccCardState() {
        {
            boolean var37EB664FE23E2FAE1F059F1BE9FE3DC1_478798081 = (!mIccCardStatus.getCardState().isCardPresent());
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
                boolean var77E61B402E06F4B2589B17903F68887C_1246613952 = (mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE);
                {
                    State var55370511744D280B9A118D3BDEB96B4F_539947794 = (getConsolidatedState(csimState, usimState, csimState));
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (State)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.091 -0400", hash_original_method = "809395990E0197CB644B1DF3288DB707", hash_generated_method = "0744F914C740532A3C147853243EF785")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private State getAppState(int appIndex) {
        dsTaint.addTaint(appIndex);
        IccCardApplication app;
        {
            app = mIccCardStatus.getApplication(appIndex);
        } //End block
        {
            boolean varD79448EF50A427003D4C76CECD605C72_2141309361 = (app.pin1.isPermBlocked());
        } //End collapsed parenthetic
        {
            boolean var1945F3B200D512171D5265F4A46FA51E_767629772 = (app.app_state.isPinRequired());
        } //End collapsed parenthetic
        {
            boolean var61EBE391DFCFAFB0FB7193188270151E_1728338810 = (app.app_state.isPukRequired());
        } //End collapsed parenthetic
        {
            boolean varA6084E236BBD4BA404CD38B01625DB98_213559237 = (app.app_state.isSubscriptionPersoEnabled());
        } //End collapsed parenthetic
        {
            boolean var0542E857D2243312200D238063975376_1421102780 = (app.app_state.isAppReady());
        } //End collapsed parenthetic
        {
            boolean var6CCD9C0F390C721F8CA6FD75317DDB79_1653231202 = (app.app_state.isAppNotReady());
        } //End collapsed parenthetic
        return (State)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.091 -0400", hash_original_method = "292BB37BE4996383C23DC23B1670D1D7", hash_generated_method = "9438AB9B186E8A0AB7FB68AFD0F3FC41")
    @DSModeled(DSC.SAFE)
    private State getConsolidatedState(State left, State right, State preferredState) {
        dsTaint.addTaint(left.dsTaint);
        dsTaint.addTaint(right.dsTaint);
        dsTaint.addTaint(preferredState.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.091 -0400", hash_original_method = "B5E8B5923B9BC39502C2387B1882FFE9", hash_generated_method = "B3A517F59D8B541AEAD554CCFACA68D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isApplicationOnIcc(IccCardApplication.AppType type) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(type.dsTaint);
        {
            int i;
            i = 0;
            boolean var2346A46A01A4552FF6397DC9B45B0FA6_1583543266 = (i < mIccCardStatus.getNumApplications());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.091 -0400", hash_original_method = "1BA9D03EECE1275906E702F57E19B9C4", hash_generated_method = "E91A29779B15CA350FF4CE0E3026175B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasIccCard() {
        {
            boolean var5F1FEE56A00FEFA0965524059C0855DA_1006810817 = (mIccCardStatus.getCardState().isCardPresent());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mIccCardStatus == null) {
            //return false;
        //} else {
            //return mIccCardStatus.getCardState().isCardPresent();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.091 -0400", hash_original_method = "8040171B9171EEC88FFD4AC75BEDD9D4", hash_generated_method = "F86FA600123A3F4A18968165A1ADD8A8")
    @DSModeled(DSC.SAFE)
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

    
}


