package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import android.util.Log;

public class ApnContext {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.577 -0500", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "5F5E7D64B04175B8FA820B2440F700FC")

    protected static final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.574 -0500", hash_original_field = "B23F1213336A6A9687543ED87A15B656", hash_generated_field = "ECDEFF9B6CB4BCFAFA2FE8B349514FEA")

    public  String LOG_TAG;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.580 -0500", hash_original_field = "B0A863D1AC6C9BBFF7822E3133909DCC", hash_generated_field = "E6D70564297809B18BA965DA7C073C2C")

    private  String mApnType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.582 -0500", hash_original_field = "0060A1604C723C476FE80C0CA051224B", hash_generated_field = "8314DAC98A967D1AB7A1CD299AD174DC")

    private DataConnectionTracker.State mState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.584 -0500", hash_original_field = "AA26CE8157BAF4028334246260079124", hash_generated_field = "CC4F30E279FD0801D82BAEF762A46736")

    private ArrayList<ApnSetting> mWaitingApns = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.587 -0500", hash_original_field = "9E131B63493E328E8259BBC6DCAAD77A", hash_generated_field = "B5157DDA21B34763981CBBE88F87086B")

    private AtomicInteger mWaitingApnsPermanentFailureCountDown;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.589 -0500", hash_original_field = "2054EB63740ABDC30216347FAB06645D", hash_generated_field = "86A7EB1C5FF99A38BD88921D61EE85B9")

    private ApnSetting mApnSetting;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.591 -0500", hash_original_field = "75547A706E7CDC7AD9FCAF765698D548", hash_generated_field = "75547A706E7CDC7AD9FCAF765698D548")

    DataConnection mDataConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.593 -0500", hash_original_field = "B625B818D1D9F9AC9BEE968DD70B8D50", hash_generated_field = "B625B818D1D9F9AC9BEE968DD70B8D50")

    DataConnectionAc mDataConnectionAc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.595 -0500", hash_original_field = "9E1DC384E07D434791BB93D42EBB3641", hash_generated_field = "9E1DC384E07D434791BB93D42EBB3641")

    String mReason;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.598 -0500", hash_original_field = "F0B5227E84C28EFE9FA32D974847CDB6", hash_generated_field = "F0B5227E84C28EFE9FA32D974847CDB6")

    AtomicBoolean mDataEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.600 -0500", hash_original_field = "2313F72A8363449D009651AB772FE607", hash_generated_field = "2313F72A8363449D009651AB772FE607")

    AtomicBoolean mDependencyMet;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.603 -0500", hash_original_method = "8C9BAC99AF1ADE19DD4F445DDF3FD177", hash_generated_method = "FA8191A6839B76DBA58D0DF5CAB09EFC")
    
public ApnContext(String apnType, String logTag) {
        mApnType = apnType;
        mState = DataConnectionTracker.State.IDLE;
        setReason(Phone.REASON_DATA_ENABLED);
        mDataEnabled = new AtomicBoolean(false);
        mDependencyMet = new AtomicBoolean(true);
        mWaitingApnsPermanentFailureCountDown = new AtomicInteger(0);
        LOG_TAG = logTag;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.606 -0500", hash_original_method = "0F76476B5A4DDD20A8502B6237356474", hash_generated_method = "404D87534D9D6DFDB599986D9136CBCD")
    
public String getApnType() {
        return mApnType;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.609 -0500", hash_original_method = "D5BD92E96A7D4915CF46215470E9C147", hash_generated_method = "F145C487474C22A69650797E15C94A84")
    
public synchronized DataConnection getDataConnection() {
        return mDataConnection;
    }

    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.611 -0500", hash_original_method = "DF99AB9AA9AC235054504D7946927384", hash_generated_method = "F00681E3D65D505BC484107E966B0BDC")
    
public synchronized void setDataConnection(DataConnection dataConnection) {
        mDataConnection = dataConnection;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.614 -0500", hash_original_method = "5BBBEC6A4F77592BB47CD138BBF3A7B6", hash_generated_method = "3A587714334DB694F4AADAE7B1B5285E")
    
public synchronized DataConnectionAc getDataConnectionAc() {
        return mDataConnectionAc;
    }

    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.616 -0500", hash_original_method = "68AD8513BB7965F642E8B7E782864662", hash_generated_method = "8AB43152D3BA28A37C1A119942B7D86C")
    
public synchronized void setDataConnectionAc(DataConnectionAc dcac) {
        if (dcac != null) {
            dcac.addApnContextSync(this);
        } else {
            if (mDataConnectionAc != null) mDataConnectionAc.removeApnContextSync(this);
        }
        mDataConnectionAc = dcac;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.619 -0500", hash_original_method = "2BB406053D6E60D1A0AB6AAF52F2E2C8", hash_generated_method = "79B5AE2F0E940A9A251BE86E13D477B9")
    
public synchronized ApnSetting getApnSetting() {
        return mApnSetting;
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.621 -0500", hash_original_method = "C7A08CF02723304D4F2917AE84902158", hash_generated_method = "0101C626A636BF108B6000EAAEB92CC8")
    
public synchronized void setApnSetting(ApnSetting apnSetting) {
        mApnSetting = apnSetting;
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.624 -0500", hash_original_method = "87360F576DD9D6135C262B5A31FCEAAD", hash_generated_method = "19215258C040B9E43058894B69FE56CF")
    
public synchronized void setWaitingApns(ArrayList<ApnSetting> waitingApns) {
        mWaitingApns = waitingApns;
        mWaitingApnsPermanentFailureCountDown.set(mWaitingApns.size());
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.627 -0500", hash_original_method = "BB542F2E9EBFB107E0306A16FFD4893E", hash_generated_method = "6056CBF86CD8C31D706AF32B0CD7909A")
    
public int getWaitingApnsPermFailCount() {
        return mWaitingApnsPermanentFailureCountDown.get();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.629 -0500", hash_original_method = "40A5E79AB68275438A57C310C588D046", hash_generated_method = "790ACCBDE65D3668A5ECF68B9F126F3B")
    
public void decWaitingApnsPermFailCount() {
        mWaitingApnsPermanentFailureCountDown.decrementAndGet();
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.633 -0500", hash_original_method = "8169EBCA601DA0905CCE375C31CE1E4C", hash_generated_method = "A3548EA292AAEEF602F75177AF1F794F")
    
public synchronized ApnSetting getNextWaitingApn() {
        ArrayList<ApnSetting> list = mWaitingApns;
        ApnSetting apn = null;

        if (list != null) {
            if (!list.isEmpty()) {
                apn = list.get(0);
            }
        }
        return apn;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.635 -0500", hash_original_method = "FA48084F5C2F8120BB5134F54AC68EF9", hash_generated_method = "AD82635712C61C925B22A49A4BF3163C")
    
public synchronized void removeNextWaitingApn() {
        if ((mWaitingApns != null) && (!mWaitingApns.isEmpty())) {
            mWaitingApns.remove(0);
        }
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.637 -0500", hash_original_method = "3EEE20ABAF340D832C1A12335FDE6C3B", hash_generated_method = "0C2653FA62790458AA1255D1F53409DB")
    
public synchronized ArrayList<ApnSetting> getWaitingApns() {
        return mWaitingApns;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.640 -0500", hash_original_method = "8BACD1B14114CBCD433A2ADD2EEA6670", hash_generated_method = "41A6BC3D91659BE9375A85C677A4B237")
    
public synchronized void setState(DataConnectionTracker.State s) {
        if (DBG) {
            log("setState: " + s + " for type " + mApnType + ", previous state:" + mState);
        }

        mState = s;

        if (mState == DataConnectionTracker.State.FAILED) {
            if (mWaitingApns != null) {
                mWaitingApns.clear(); // when teardown the connection and set to IDLE
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.642 -0500", hash_original_method = "CA444B740CFD8145F25D1C527A80F346", hash_generated_method = "FC50C32BE9832956495646CF0445354D")
    
public synchronized DataConnectionTracker.State getState() {
        return mState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.645 -0500", hash_original_method = "3A4C9A84D96082354CB400C523CD6FA7", hash_generated_method = "F756C99C9B94C7791C8F73F0A4D4DCBC")
    
public boolean isDisconnected() {
        DataConnectionTracker.State currentState = getState();
        return ((currentState == DataConnectionTracker.State.IDLE) ||
                    currentState == DataConnectionTracker.State.FAILED);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.648 -0500", hash_original_method = "8C307D0C19BB4E3FFA53F46CA299668C", hash_generated_method = "91C70B724680E1069A170F07A3E70EE1")
    
public synchronized void setReason(String reason) {
        if (DBG) {
            log("set reason as " + reason + ", for type " + mApnType + ",current state " + mState);
        }
        mReason = reason;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.650 -0500", hash_original_method = "2809EBE4FEE36399CFA439CAAE81BBAE", hash_generated_method = "03C2A6500E0CD509D7AF782E38E4C6E9")
    
public synchronized String getReason() {
        return mReason;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.653 -0500", hash_original_method = "3DA6D3F7F95DCB338B24FC0B5F96F559", hash_generated_method = "AD480065D2538EB36934ED9975FAB3B3")
    
public boolean isReady() {
        return mDataEnabled.get() && mDependencyMet.get();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.655 -0500", hash_original_method = "B2C9522D54285815DBD14240ADC4089E", hash_generated_method = "1846DDF243E46B16BBD4E2CF6EACFC21")
    
public void setEnabled(boolean enabled) {
        if (DBG) {
            log("set enabled as " + enabled + ", for type " +
                    mApnType + ", current state is " + mDataEnabled.get());
        }
        mDataEnabled.set(enabled);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.658 -0500", hash_original_method = "87E23337C7941EB7C82B165656BD6001", hash_generated_method = "D1E78725A93889D29952D317E7F53CA4")
    
public boolean isEnabled() {
        return mDataEnabled.get();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.660 -0500", hash_original_method = "6EC044B2F5DDFA155CCF046B06C94163", hash_generated_method = "F2C7BC760E8982DD7C966EC32AFD52BE")
    
public void setDependencyMet(boolean met) {
        if (DBG) {
            log("set mDependencyMet as " + met + ", for type " + mApnType +
                    ", current state is " + mDependencyMet.get());
        }
        mDependencyMet.set(met);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.663 -0500", hash_original_method = "0BCF198B460FB01FAD42E5667908EAA7", hash_generated_method = "53C8FAA7C1157222FCA8E53EB189B98E")
    
public boolean getDependencyMet() {
       return mDependencyMet.get();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.665 -0500", hash_original_method = "0156798C320A34D339E0A5D3C1FA955E", hash_generated_method = "D842E461153BAB33A66C7DDEFC823492")
    
@Override
    public String toString() {
        return "state=" + getState() + " apnType=" + mApnType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.667 -0500", hash_original_method = "8B2618456D835BC7B38E6BD456997814", hash_generated_method = "1D09CFADFD18FA3EF1402E75C813F8EF")
    
protected void log(String s) {
        Log.d(LOG_TAG, "[ApnContext] " + s);
    }
}

