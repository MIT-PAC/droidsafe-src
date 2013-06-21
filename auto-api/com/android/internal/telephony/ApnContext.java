package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ApnContext {
    public String LOG_TAG;
    private String mApnType;
    private DataConnectionTracker.State mState;
    private ArrayList<ApnSetting> mWaitingApns = null;
    private AtomicInteger mWaitingApnsPermanentFailureCountDown;
    private ApnSetting mApnSetting;
    DataConnection mDataConnection;
    DataConnectionAc mDataConnectionAc;
    String mReason;
    AtomicBoolean mDataEnabled;
    AtomicBoolean mDependencyMet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.670 -0400", hash_original_method = "8C9BAC99AF1ADE19DD4F445DDF3FD177", hash_generated_method = "99E2C8722101B063C0FE1CFC365642DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ApnContext(String apnType, String logTag) {
        dsTaint.addTaint(apnType);
        dsTaint.addTaint(logTag);
        mState = DataConnectionTracker.State.IDLE;
        setReason(Phone.REASON_DATA_ENABLED);
        mDataEnabled = new AtomicBoolean(false);
        mDependencyMet = new AtomicBoolean(true);
        mWaitingApnsPermanentFailureCountDown = new AtomicInteger(0);
        // ---------- Original Method ----------
        //mApnType = apnType;
        //mState = DataConnectionTracker.State.IDLE;
        //setReason(Phone.REASON_DATA_ENABLED);
        //mDataEnabled = new AtomicBoolean(false);
        //mDependencyMet = new AtomicBoolean(true);
        //mWaitingApnsPermanentFailureCountDown = new AtomicInteger(0);
        //LOG_TAG = logTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.670 -0400", hash_original_method = "0F76476B5A4DDD20A8502B6237356474", hash_generated_method = "CF482F11410F519A9BE9C39D390D25B3")
    @DSModeled(DSC.SAFE)
    public String getApnType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mApnType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.671 -0400", hash_original_method = "D5BD92E96A7D4915CF46215470E9C147", hash_generated_method = "831191981D7BFBFB3474371287E8B0AD")
    @DSModeled(DSC.SAFE)
    public synchronized DataConnection getDataConnection() {
        return (DataConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDataConnection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.671 -0400", hash_original_method = "DF99AB9AA9AC235054504D7946927384", hash_generated_method = "855022607BC9D33C7638CC0093E3051E")
    @DSModeled(DSC.SAFE)
    public synchronized void setDataConnection(DataConnection dataConnection) {
        dsTaint.addTaint(dataConnection.dsTaint);
        // ---------- Original Method ----------
        //mDataConnection = dataConnection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.671 -0400", hash_original_method = "5BBBEC6A4F77592BB47CD138BBF3A7B6", hash_generated_method = "BE47275B5E92D4D54BCA42DC30F37E29")
    @DSModeled(DSC.SAFE)
    public synchronized DataConnectionAc getDataConnectionAc() {
        return (DataConnectionAc)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDataConnectionAc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.671 -0400", hash_original_method = "68AD8513BB7965F642E8B7E782864662", hash_generated_method = "FAB5B7CBD4832A5EC25C7BEDAD3B4FD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setDataConnectionAc(DataConnectionAc dcac) {
        dsTaint.addTaint(dcac.dsTaint);
        {
            dcac.addApnContextSync(this);
        } //End block
        {
            mDataConnectionAc.removeApnContextSync(this);
        } //End block
        // ---------- Original Method ----------
        //if (dcac != null) {
            //dcac.addApnContextSync(this);
        //} else {
            //if (mDataConnectionAc != null) mDataConnectionAc.removeApnContextSync(this);
        //}
        //mDataConnectionAc = dcac;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.671 -0400", hash_original_method = "2BB406053D6E60D1A0AB6AAF52F2E2C8", hash_generated_method = "7FC28F8235F22C0154110B49623A4961")
    @DSModeled(DSC.SAFE)
    public synchronized ApnSetting getApnSetting() {
        return (ApnSetting)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mApnSetting;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.672 -0400", hash_original_method = "C7A08CF02723304D4F2917AE84902158", hash_generated_method = "4EE74131C892634058CA4F86420FC73C")
    @DSModeled(DSC.SAFE)
    public synchronized void setApnSetting(ApnSetting apnSetting) {
        dsTaint.addTaint(apnSetting.dsTaint);
        // ---------- Original Method ----------
        //mApnSetting = apnSetting;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.672 -0400", hash_original_method = "87360F576DD9D6135C262B5A31FCEAAD", hash_generated_method = "2FBE8367587B64DB442A723ACBE23266")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setWaitingApns(ArrayList<ApnSetting> waitingApns) {
        dsTaint.addTaint(waitingApns.dsTaint);
        mWaitingApnsPermanentFailureCountDown.set(mWaitingApns.size());
        // ---------- Original Method ----------
        //mWaitingApns = waitingApns;
        //mWaitingApnsPermanentFailureCountDown.set(mWaitingApns.size());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.672 -0400", hash_original_method = "BB542F2E9EBFB107E0306A16FFD4893E", hash_generated_method = "A7F2491E911C4092C59A9426635BB85C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getWaitingApnsPermFailCount() {
        int var193D103C55CE01DA57C107C86191C6F5_1733450233 = (mWaitingApnsPermanentFailureCountDown.get());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWaitingApnsPermanentFailureCountDown.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.672 -0400", hash_original_method = "40A5E79AB68275438A57C310C588D046", hash_generated_method = "CECEABB4ABA114E566E71501B6ACBBDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void decWaitingApnsPermFailCount() {
        mWaitingApnsPermanentFailureCountDown.decrementAndGet();
        // ---------- Original Method ----------
        //mWaitingApnsPermanentFailureCountDown.decrementAndGet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.673 -0400", hash_original_method = "8169EBCA601DA0905CCE375C31CE1E4C", hash_generated_method = "490153A0D5DC72CEB4420F39116E0F6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized ApnSetting getNextWaitingApn() {
        ArrayList<ApnSetting> list;
        list = mWaitingApns;
        ApnSetting apn;
        apn = null;
        {
            {
                boolean varAC8BEC89D66DF335A471492F884B50EF_1645035049 = (!list.isEmpty());
                {
                    apn = list.get(0);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (ApnSetting)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ArrayList<ApnSetting> list = mWaitingApns;
        //ApnSetting apn = null;
        //if (list != null) {
            //if (!list.isEmpty()) {
                //apn = list.get(0);
            //}
        //}
        //return apn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.673 -0400", hash_original_method = "FA48084F5C2F8120BB5134F54AC68EF9", hash_generated_method = "69E937A9AFD5F038FC5C273C0C0B2C47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void removeNextWaitingApn() {
        {
            boolean var834ADE254106658EC390E81F21C5C471_1471048762 = ((mWaitingApns != null) && (!mWaitingApns.isEmpty()));
            {
                mWaitingApns.remove(0);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if ((mWaitingApns != null) && (!mWaitingApns.isEmpty())) {
            //mWaitingApns.remove(0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.673 -0400", hash_original_method = "3EEE20ABAF340D832C1A12335FDE6C3B", hash_generated_method = "FFCB7AD926F7538296267FE39FE38B5C")
    @DSModeled(DSC.SAFE)
    public synchronized ArrayList<ApnSetting> getWaitingApns() {
        return (ArrayList<ApnSetting>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWaitingApns;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.673 -0400", hash_original_method = "8BACD1B14114CBCD433A2ADD2EEA6670", hash_generated_method = "8842E6983A6D57D499F88F84F9E78528")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setState(DataConnectionTracker.State s) {
        dsTaint.addTaint(s.dsTaint);
        {
            log("setState: " + s + " for type " + mApnType + ", previous state:" + mState);
        } //End block
        {
            {
                mWaitingApns.clear();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (DBG) {
            //log("setState: " + s + " for type " + mApnType + ", previous state:" + mState);
        //}
        //mState = s;
        //if (mState == DataConnectionTracker.State.FAILED) {
            //if (mWaitingApns != null) {
                //mWaitingApns.clear(); 
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.674 -0400", hash_original_method = "CA444B740CFD8145F25D1C527A80F346", hash_generated_method = "8705410B4263140A89766E28A70AF520")
    @DSModeled(DSC.SAFE)
    public synchronized DataConnectionTracker.State getState() {
        return (DataConnectionTracker.State)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.674 -0400", hash_original_method = "3A4C9A84D96082354CB400C523CD6FA7", hash_generated_method = "4161D66D9AF865E67E715492401C5A0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDisconnected() {
        DataConnectionTracker.State currentState;
        currentState = getState();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //DataConnectionTracker.State currentState = getState();
        //return ((currentState == DataConnectionTracker.State.IDLE) ||
                    //currentState == DataConnectionTracker.State.FAILED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.674 -0400", hash_original_method = "8C307D0C19BB4E3FFA53F46CA299668C", hash_generated_method = "715353C013DDDD573FC47A669B224E02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setReason(String reason) {
        dsTaint.addTaint(reason);
        {
            log("set reason as " + reason + ", for type " + mApnType + ",current state " + mState);
        } //End block
        // ---------- Original Method ----------
        //if (DBG) {
            //log("set reason as " + reason + ", for type " + mApnType + ",current state " + mState);
        //}
        //mReason = reason;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.674 -0400", hash_original_method = "2809EBE4FEE36399CFA439CAAE81BBAE", hash_generated_method = "31C43F28749CACEF58E5EA105D65E24B")
    @DSModeled(DSC.SAFE)
    public synchronized String getReason() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mReason;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.674 -0400", hash_original_method = "3DA6D3F7F95DCB338B24FC0B5F96F559", hash_generated_method = "C290CA3477C8E467911F79F2112ACAAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isReady() {
        boolean varDC59533A891B68C5D0FAC37BBA1F9C39_49021867 = (mDataEnabled.get() && mDependencyMet.get());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDataEnabled.get() && mDependencyMet.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.675 -0400", hash_original_method = "B2C9522D54285815DBD14240ADC4089E", hash_generated_method = "23BC1718D1FD11BD25B7D54876BE99F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        {
            log("set enabled as " + enabled + ", for type " +
                    mApnType + ", current state is " + mDataEnabled.get());
        } //End block
        mDataEnabled.set(enabled);
        // ---------- Original Method ----------
        //if (DBG) {
            //log("set enabled as " + enabled + ", for type " +
                    //mApnType + ", current state is " + mDataEnabled.get());
        //}
        //mDataEnabled.set(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.675 -0400", hash_original_method = "87E23337C7941EB7C82B165656BD6001", hash_generated_method = "7EEE743EFB73CAD44EBEC0768E197FF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEnabled() {
        boolean varF5EDE0CB46AF03D0A778EF15D368E936_1388936839 = (mDataEnabled.get());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDataEnabled.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.675 -0400", hash_original_method = "6EC044B2F5DDFA155CCF046B06C94163", hash_generated_method = "CC3B2B00FF28D6477451C9D4D01B69E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDependencyMet(boolean met) {
        dsTaint.addTaint(met);
        {
            log("set mDependencyMet as " + met + ", for type " + mApnType +
                    ", current state is " + mDependencyMet.get());
        } //End block
        mDependencyMet.set(met);
        // ---------- Original Method ----------
        //if (DBG) {
            //log("set mDependencyMet as " + met + ", for type " + mApnType +
                    //", current state is " + mDependencyMet.get());
        //}
        //mDependencyMet.set(met);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.675 -0400", hash_original_method = "0BCF198B460FB01FAD42E5667908EAA7", hash_generated_method = "19E8DA295022755515258332D4E2CAEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getDependencyMet() {
        boolean var2AF03CB7BB5A1ABF0023FF01686F7BF3_1621874230 = (mDependencyMet.get());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDependencyMet.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.675 -0400", hash_original_method = "0156798C320A34D339E0A5D3C1FA955E", hash_generated_method = "3C8193740C3102FE16495AFD557B6F64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var9131A13E488A078FE574D020E41DEBCE_1097812228 = ("state=" + getState() + " apnType=" + mApnType);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "state=" + getState() + " apnType=" + mApnType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.676 -0400", hash_original_method = "8B2618456D835BC7B38E6BD456997814", hash_generated_method = "1F601A3E1F6FEFF4520596B8D0971AE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void log(String s) {
        dsTaint.addTaint(s);
        Log.d(LOG_TAG, "[ApnContext] " + s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[ApnContext] " + s);
    }

    
    protected static final boolean DBG = true;
}

