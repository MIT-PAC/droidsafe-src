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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.734 -0400", hash_original_field = "E352FA068E2A15ACE6EF763778B80C2C", hash_generated_field = "ECDEFF9B6CB4BCFAFA2FE8B349514FEA")

    public String LOG_TAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.734 -0400", hash_original_field = "1649910D3595E6DCD0252C6C47D15EBC", hash_generated_field = "E6D70564297809B18BA965DA7C073C2C")

    private String mApnType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.734 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "8314DAC98A967D1AB7A1CD299AD174DC")

    private DataConnectionTracker.State mState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.734 -0400", hash_original_field = "9450E2D6C5C971C3BE800D082DCF817D", hash_generated_field = "CC4F30E279FD0801D82BAEF762A46736")

    private ArrayList<ApnSetting> mWaitingApns = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.734 -0400", hash_original_field = "9C7B1A41BAC9744FC3B3E9DA2C71FA1A", hash_generated_field = "B5157DDA21B34763981CBBE88F87086B")

    private AtomicInteger mWaitingApnsPermanentFailureCountDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.734 -0400", hash_original_field = "11CD2CABD2F9CDD0C3FC108CE2938E2B", hash_generated_field = "86A7EB1C5FF99A38BD88921D61EE85B9")

    private ApnSetting mApnSetting;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.734 -0400", hash_original_field = "BB620BF7EFE0F557E73EC5E4AF5A9422", hash_generated_field = "75547A706E7CDC7AD9FCAF765698D548")

    DataConnection mDataConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.734 -0400", hash_original_field = "7C12FFD31CACF16872743A547483233E", hash_generated_field = "B625B818D1D9F9AC9BEE968DD70B8D50")

    DataConnectionAc mDataConnectionAc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.734 -0400", hash_original_field = "D37183730F43F82EAD5FD0BEC18C215E", hash_generated_field = "9E1DC384E07D434791BB93D42EBB3641")

    String mReason;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.734 -0400", hash_original_field = "907943D2CA4CBBC2F0E9BB598EF05E6E", hash_generated_field = "F0B5227E84C28EFE9FA32D974847CDB6")

    AtomicBoolean mDataEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.734 -0400", hash_original_field = "73F9A71C73FA325E80F22EFF3F6E9382", hash_generated_field = "2313F72A8363449D009651AB772FE607")

    AtomicBoolean mDependencyMet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.735 -0400", hash_original_method = "8C9BAC99AF1ADE19DD4F445DDF3FD177", hash_generated_method = "9584A5048EC03175EAF3E0AB116D26B9")
    public  ApnContext(String apnType, String logTag) {
        mApnType = apnType;
        mState = DataConnectionTracker.State.IDLE;
        setReason(Phone.REASON_DATA_ENABLED);
        mDataEnabled = new AtomicBoolean(false);
        mDependencyMet = new AtomicBoolean(true);
        mWaitingApnsPermanentFailureCountDown = new AtomicInteger(0);
        LOG_TAG = logTag;
        // ---------- Original Method ----------
        //mApnType = apnType;
        //mState = DataConnectionTracker.State.IDLE;
        //setReason(Phone.REASON_DATA_ENABLED);
        //mDataEnabled = new AtomicBoolean(false);
        //mDependencyMet = new AtomicBoolean(true);
        //mWaitingApnsPermanentFailureCountDown = new AtomicInteger(0);
        //LOG_TAG = logTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.751 -0400", hash_original_method = "0F76476B5A4DDD20A8502B6237356474", hash_generated_method = "4DB93EDB709A9C943F5A4488E0B37FC4")
    public String getApnType() {
        String varB4EAC82CA7396A68D541C85D26508E83_573207279 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_573207279 = mApnType;
        varB4EAC82CA7396A68D541C85D26508E83_573207279.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_573207279;
        // ---------- Original Method ----------
        //return mApnType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.752 -0400", hash_original_method = "D5BD92E96A7D4915CF46215470E9C147", hash_generated_method = "F2C8E24B030AE4DABA75B7D5A30991CD")
    public synchronized DataConnection getDataConnection() {
        DataConnection varB4EAC82CA7396A68D541C85D26508E83_480053873 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_480053873 = mDataConnection;
        varB4EAC82CA7396A68D541C85D26508E83_480053873.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_480053873;
        // ---------- Original Method ----------
        //return mDataConnection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.752 -0400", hash_original_method = "DF99AB9AA9AC235054504D7946927384", hash_generated_method = "A407EBF6D7D499CA05EFD164B9F07CF3")
    public synchronized void setDataConnection(DataConnection dataConnection) {
        mDataConnection = dataConnection;
        // ---------- Original Method ----------
        //mDataConnection = dataConnection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.752 -0400", hash_original_method = "5BBBEC6A4F77592BB47CD138BBF3A7B6", hash_generated_method = "29AB004F601908E30055C8C2184373E2")
    public synchronized DataConnectionAc getDataConnectionAc() {
        DataConnectionAc varB4EAC82CA7396A68D541C85D26508E83_184072483 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_184072483 = mDataConnectionAc;
        varB4EAC82CA7396A68D541C85D26508E83_184072483.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_184072483;
        // ---------- Original Method ----------
        //return mDataConnectionAc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.753 -0400", hash_original_method = "68AD8513BB7965F642E8B7E782864662", hash_generated_method = "DD5CCD70242554357C9E6498BDEE2FA4")
    public synchronized void setDataConnectionAc(DataConnectionAc dcac) {
        {
            dcac.addApnContextSync(this);
        } //End block
        {
            mDataConnectionAc.removeApnContextSync(this);
        } //End block
        mDataConnectionAc = dcac;
        // ---------- Original Method ----------
        //if (dcac != null) {
            //dcac.addApnContextSync(this);
        //} else {
            //if (mDataConnectionAc != null) mDataConnectionAc.removeApnContextSync(this);
        //}
        //mDataConnectionAc = dcac;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.753 -0400", hash_original_method = "2BB406053D6E60D1A0AB6AAF52F2E2C8", hash_generated_method = "495643EC7638733CD323F8AF38AD37E8")
    public synchronized ApnSetting getApnSetting() {
        ApnSetting varB4EAC82CA7396A68D541C85D26508E83_766760648 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_766760648 = mApnSetting;
        varB4EAC82CA7396A68D541C85D26508E83_766760648.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_766760648;
        // ---------- Original Method ----------
        //return mApnSetting;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.753 -0400", hash_original_method = "C7A08CF02723304D4F2917AE84902158", hash_generated_method = "339FAA179B3F5AFAA3CBA867B9C33852")
    public synchronized void setApnSetting(ApnSetting apnSetting) {
        mApnSetting = apnSetting;
        // ---------- Original Method ----------
        //mApnSetting = apnSetting;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.754 -0400", hash_original_method = "87360F576DD9D6135C262B5A31FCEAAD", hash_generated_method = "2CCEFA0F6C716F41E221B15C64D33F33")
    public synchronized void setWaitingApns(ArrayList<ApnSetting> waitingApns) {
        mWaitingApns = waitingApns;
        mWaitingApnsPermanentFailureCountDown.set(mWaitingApns.size());
        // ---------- Original Method ----------
        //mWaitingApns = waitingApns;
        //mWaitingApnsPermanentFailureCountDown.set(mWaitingApns.size());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.754 -0400", hash_original_method = "BB542F2E9EBFB107E0306A16FFD4893E", hash_generated_method = "8DDEDA78F100537A1C667B617C622AB8")
    public int getWaitingApnsPermFailCount() {
        int var193D103C55CE01DA57C107C86191C6F5_1077095665 = (mWaitingApnsPermanentFailureCountDown.get());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_676612035 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_676612035;
        // ---------- Original Method ----------
        //return mWaitingApnsPermanentFailureCountDown.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.754 -0400", hash_original_method = "40A5E79AB68275438A57C310C588D046", hash_generated_method = "CECEABB4ABA114E566E71501B6ACBBDF")
    public void decWaitingApnsPermFailCount() {
        mWaitingApnsPermanentFailureCountDown.decrementAndGet();
        // ---------- Original Method ----------
        //mWaitingApnsPermanentFailureCountDown.decrementAndGet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.755 -0400", hash_original_method = "8169EBCA601DA0905CCE375C31CE1E4C", hash_generated_method = "F8C9E6A7EDC23447784BE5533DE018B1")
    public synchronized ApnSetting getNextWaitingApn() {
        ApnSetting varB4EAC82CA7396A68D541C85D26508E83_537701327 = null; //Variable for return #1
        ArrayList<ApnSetting> list;
        list = mWaitingApns;
        ApnSetting apn;
        apn = null;
        {
            {
                boolean varAC8BEC89D66DF335A471492F884B50EF_1278809323 = (!list.isEmpty());
                {
                    apn = list.get(0);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_537701327 = apn;
        varB4EAC82CA7396A68D541C85D26508E83_537701327.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_537701327;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.755 -0400", hash_original_method = "FA48084F5C2F8120BB5134F54AC68EF9", hash_generated_method = "60E228344CA280F7B69858D5E3D1B964")
    public synchronized void removeNextWaitingApn() {
        {
            boolean var834ADE254106658EC390E81F21C5C471_848218954 = ((mWaitingApns != null) && (!mWaitingApns.isEmpty()));
            {
                mWaitingApns.remove(0);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if ((mWaitingApns != null) && (!mWaitingApns.isEmpty())) {
            //mWaitingApns.remove(0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.763 -0400", hash_original_method = "3EEE20ABAF340D832C1A12335FDE6C3B", hash_generated_method = "27F0DDC3BA404945F7A09F43D6345202")
    public synchronized ArrayList<ApnSetting> getWaitingApns() {
        ArrayList<ApnSetting> varB4EAC82CA7396A68D541C85D26508E83_1184656647 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1184656647 = mWaitingApns;
        varB4EAC82CA7396A68D541C85D26508E83_1184656647.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1184656647;
        // ---------- Original Method ----------
        //return mWaitingApns;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.778 -0400", hash_original_method = "8BACD1B14114CBCD433A2ADD2EEA6670", hash_generated_method = "FBB051E4D9B6DCCB189BAD3F5FA6859D")
    public synchronized void setState(DataConnectionTracker.State s) {
        {
            log("setState: " + s + " for type " + mApnType + ", previous state:" + mState);
        } //End block
        mState = s;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.778 -0400", hash_original_method = "CA444B740CFD8145F25D1C527A80F346", hash_generated_method = "2AA9231B74B66E0236E6B5B0789E9C49")
    public synchronized DataConnectionTracker.State getState() {
        DataConnectionTracker.State varB4EAC82CA7396A68D541C85D26508E83_954915592 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_954915592 = mState;
        varB4EAC82CA7396A68D541C85D26508E83_954915592.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_954915592;
        // ---------- Original Method ----------
        //return mState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.779 -0400", hash_original_method = "3A4C9A84D96082354CB400C523CD6FA7", hash_generated_method = "82CDF5298653A3CB1E6120F0CC7F701F")
    public boolean isDisconnected() {
        DataConnectionTracker.State currentState;
        currentState = getState();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1425703968 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1425703968;
        // ---------- Original Method ----------
        //DataConnectionTracker.State currentState = getState();
        //return ((currentState == DataConnectionTracker.State.IDLE) ||
                    //currentState == DataConnectionTracker.State.FAILED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.779 -0400", hash_original_method = "8C307D0C19BB4E3FFA53F46CA299668C", hash_generated_method = "98DB46045A94B3ECA798D81CA4804D7D")
    public synchronized void setReason(String reason) {
        {
            log("set reason as " + reason + ", for type " + mApnType + ",current state " + mState);
        } //End block
        mReason = reason;
        // ---------- Original Method ----------
        //if (DBG) {
            //log("set reason as " + reason + ", for type " + mApnType + ",current state " + mState);
        //}
        //mReason = reason;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.786 -0400", hash_original_method = "2809EBE4FEE36399CFA439CAAE81BBAE", hash_generated_method = "058EA2AC198C7B01CEE65A910123F68E")
    public synchronized String getReason() {
        String varB4EAC82CA7396A68D541C85D26508E83_1830952277 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1830952277 = mReason;
        varB4EAC82CA7396A68D541C85D26508E83_1830952277.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1830952277;
        // ---------- Original Method ----------
        //return mReason;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.786 -0400", hash_original_method = "3DA6D3F7F95DCB338B24FC0B5F96F559", hash_generated_method = "0D56E1F296EED222BD1B38F9BC877B24")
    public boolean isReady() {
        boolean varDC59533A891B68C5D0FAC37BBA1F9C39_2069565958 = (mDataEnabled.get() && mDependencyMet.get());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_638515718 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_638515718;
        // ---------- Original Method ----------
        //return mDataEnabled.get() && mDependencyMet.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.786 -0400", hash_original_method = "B2C9522D54285815DBD14240ADC4089E", hash_generated_method = "348A180FEBE9E517A1423BA07594F4E1")
    public void setEnabled(boolean enabled) {
        {
            log("set enabled as " + enabled + ", for type " +
                    mApnType + ", current state is " + mDataEnabled.get());
        } //End block
        mDataEnabled.set(enabled);
        addTaint(enabled);
        // ---------- Original Method ----------
        //if (DBG) {
            //log("set enabled as " + enabled + ", for type " +
                    //mApnType + ", current state is " + mDataEnabled.get());
        //}
        //mDataEnabled.set(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.790 -0400", hash_original_method = "87E23337C7941EB7C82B165656BD6001", hash_generated_method = "1568BE706A6973ECEF54DC91FA20211B")
    public boolean isEnabled() {
        boolean varF5EDE0CB46AF03D0A778EF15D368E936_1795268409 = (mDataEnabled.get());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_595382348 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_595382348;
        // ---------- Original Method ----------
        //return mDataEnabled.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.791 -0400", hash_original_method = "6EC044B2F5DDFA155CCF046B06C94163", hash_generated_method = "461DABF2251FD9610B969ED20D6DD2F1")
    public void setDependencyMet(boolean met) {
        {
            log("set mDependencyMet as " + met + ", for type " + mApnType +
                    ", current state is " + mDependencyMet.get());
        } //End block
        mDependencyMet.set(met);
        addTaint(met);
        // ---------- Original Method ----------
        //if (DBG) {
            //log("set mDependencyMet as " + met + ", for type " + mApnType +
                    //", current state is " + mDependencyMet.get());
        //}
        //mDependencyMet.set(met);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.791 -0400", hash_original_method = "0BCF198B460FB01FAD42E5667908EAA7", hash_generated_method = "80A02F27DFA313B1F0B0A336CD7208E3")
    public boolean getDependencyMet() {
        boolean var2AF03CB7BB5A1ABF0023FF01686F7BF3_1659203816 = (mDependencyMet.get());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_77501351 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_77501351;
        // ---------- Original Method ----------
        //return mDependencyMet.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.792 -0400", hash_original_method = "0156798C320A34D339E0A5D3C1FA955E", hash_generated_method = "3BF01377A906D5712917023DC1502A61")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_918078309 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_918078309 = "state=" + getState() + " apnType=" + mApnType;
        varB4EAC82CA7396A68D541C85D26508E83_918078309.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_918078309;
        // ---------- Original Method ----------
        //return "state=" + getState() + " apnType=" + mApnType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.792 -0400", hash_original_method = "8B2618456D835BC7B38E6BD456997814", hash_generated_method = "6C0B375EA076A39B7D4484A98C7A49C3")
    protected void log(String s) {
        Log.d(LOG_TAG, "[ApnContext] " + s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[ApnContext] " + s);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.792 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "D751668EF011EB030075908D0A6ACFD9")

    protected static boolean DBG = true;
}

