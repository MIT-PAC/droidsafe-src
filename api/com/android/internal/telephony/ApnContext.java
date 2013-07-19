package com.android.internal.telephony;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import android.util.Log;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ApnContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.974 -0400", hash_original_field = "E352FA068E2A15ACE6EF763778B80C2C", hash_generated_field = "ECDEFF9B6CB4BCFAFA2FE8B349514FEA")

    public String LOG_TAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.974 -0400", hash_original_field = "1649910D3595E6DCD0252C6C47D15EBC", hash_generated_field = "E6D70564297809B18BA965DA7C073C2C")

    private String mApnType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.974 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "8314DAC98A967D1AB7A1CD299AD174DC")

    private DataConnectionTracker.State mState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.974 -0400", hash_original_field = "9450E2D6C5C971C3BE800D082DCF817D", hash_generated_field = "CC4F30E279FD0801D82BAEF762A46736")

    private ArrayList<ApnSetting> mWaitingApns = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.975 -0400", hash_original_field = "9C7B1A41BAC9744FC3B3E9DA2C71FA1A", hash_generated_field = "B5157DDA21B34763981CBBE88F87086B")

    private AtomicInteger mWaitingApnsPermanentFailureCountDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.975 -0400", hash_original_field = "11CD2CABD2F9CDD0C3FC108CE2938E2B", hash_generated_field = "86A7EB1C5FF99A38BD88921D61EE85B9")

    private ApnSetting mApnSetting;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.975 -0400", hash_original_field = "BB620BF7EFE0F557E73EC5E4AF5A9422", hash_generated_field = "75547A706E7CDC7AD9FCAF765698D548")

    DataConnection mDataConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.975 -0400", hash_original_field = "7C12FFD31CACF16872743A547483233E", hash_generated_field = "B625B818D1D9F9AC9BEE968DD70B8D50")

    DataConnectionAc mDataConnectionAc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.975 -0400", hash_original_field = "D37183730F43F82EAD5FD0BEC18C215E", hash_generated_field = "9E1DC384E07D434791BB93D42EBB3641")

    String mReason;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.975 -0400", hash_original_field = "907943D2CA4CBBC2F0E9BB598EF05E6E", hash_generated_field = "F0B5227E84C28EFE9FA32D974847CDB6")

    AtomicBoolean mDataEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.975 -0400", hash_original_field = "73F9A71C73FA325E80F22EFF3F6E9382", hash_generated_field = "2313F72A8363449D009651AB772FE607")

    AtomicBoolean mDependencyMet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.975 -0400", hash_original_method = "8C9BAC99AF1ADE19DD4F445DDF3FD177", hash_generated_method = "9584A5048EC03175EAF3E0AB116D26B9")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.975 -0400", hash_original_method = "0F76476B5A4DDD20A8502B6237356474", hash_generated_method = "C0BB98DD396D2FB1F35F567CBA1EEBF9")
    public String getApnType() {
String var80D7660CB31A9AF6DF37738C3944B4BE_1644068557 =         mApnType;
        var80D7660CB31A9AF6DF37738C3944B4BE_1644068557.addTaint(taint);
        return var80D7660CB31A9AF6DF37738C3944B4BE_1644068557;
        // ---------- Original Method ----------
        //return mApnType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.975 -0400", hash_original_method = "D5BD92E96A7D4915CF46215470E9C147", hash_generated_method = "D830AF79BBBE6EFD11062CC3A4B4D35C")
    public synchronized DataConnection getDataConnection() {
DataConnection var0464E315B56DA2350F6061D92D2F59D5_1308403190 =         mDataConnection;
        var0464E315B56DA2350F6061D92D2F59D5_1308403190.addTaint(taint);
        return var0464E315B56DA2350F6061D92D2F59D5_1308403190;
        // ---------- Original Method ----------
        //return mDataConnection;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.975 -0400", hash_original_method = "DF99AB9AA9AC235054504D7946927384", hash_generated_method = "A407EBF6D7D499CA05EFD164B9F07CF3")
    public synchronized void setDataConnection(DataConnection dataConnection) {
        mDataConnection = dataConnection;
        // ---------- Original Method ----------
        //mDataConnection = dataConnection;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.976 -0400", hash_original_method = "5BBBEC6A4F77592BB47CD138BBF3A7B6", hash_generated_method = "768D65443B0A541454CB4B9529A61B3A")
    public synchronized DataConnectionAc getDataConnectionAc() {
DataConnectionAc var062D8583CC775F31D4371CA799B78162_1605845018 =         mDataConnectionAc;
        var062D8583CC775F31D4371CA799B78162_1605845018.addTaint(taint);
        return var062D8583CC775F31D4371CA799B78162_1605845018;
        // ---------- Original Method ----------
        //return mDataConnectionAc;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.976 -0400", hash_original_method = "68AD8513BB7965F642E8B7E782864662", hash_generated_method = "3094EF900E22E925AF2D7C49FCA8D595")
    public synchronized void setDataConnectionAc(DataConnectionAc dcac) {
        if(dcac != null)        
        {
            dcac.addApnContextSync(this);
        } //End block
        else
        {
            if(mDataConnectionAc != null)            
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.976 -0400", hash_original_method = "2BB406053D6E60D1A0AB6AAF52F2E2C8", hash_generated_method = "2086D5440EA93478781338BC947E9F42")
    public synchronized ApnSetting getApnSetting() {
ApnSetting var5F0035327B16970F87641EA787C7DFEA_812937098 =         mApnSetting;
        var5F0035327B16970F87641EA787C7DFEA_812937098.addTaint(taint);
        return var5F0035327B16970F87641EA787C7DFEA_812937098;
        // ---------- Original Method ----------
        //return mApnSetting;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.976 -0400", hash_original_method = "C7A08CF02723304D4F2917AE84902158", hash_generated_method = "339FAA179B3F5AFAA3CBA867B9C33852")
    public synchronized void setApnSetting(ApnSetting apnSetting) {
        mApnSetting = apnSetting;
        // ---------- Original Method ----------
        //mApnSetting = apnSetting;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.976 -0400", hash_original_method = "87360F576DD9D6135C262B5A31FCEAAD", hash_generated_method = "2CCEFA0F6C716F41E221B15C64D33F33")
    public synchronized void setWaitingApns(ArrayList<ApnSetting> waitingApns) {
        mWaitingApns = waitingApns;
        mWaitingApnsPermanentFailureCountDown.set(mWaitingApns.size());
        // ---------- Original Method ----------
        //mWaitingApns = waitingApns;
        //mWaitingApnsPermanentFailureCountDown.set(mWaitingApns.size());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.976 -0400", hash_original_method = "BB542F2E9EBFB107E0306A16FFD4893E", hash_generated_method = "D6ECD043784F6F8AD1A82B5BAC57C720")
    public int getWaitingApnsPermFailCount() {
        int var08B17E89835C4163BB512998F27A6D52_1802854090 = (mWaitingApnsPermanentFailureCountDown.get());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1595955600 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1595955600;
        // ---------- Original Method ----------
        //return mWaitingApnsPermanentFailureCountDown.get();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.976 -0400", hash_original_method = "40A5E79AB68275438A57C310C588D046", hash_generated_method = "CECEABB4ABA114E566E71501B6ACBBDF")
    public void decWaitingApnsPermFailCount() {
        mWaitingApnsPermanentFailureCountDown.decrementAndGet();
        // ---------- Original Method ----------
        //mWaitingApnsPermanentFailureCountDown.decrementAndGet();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.977 -0400", hash_original_method = "8169EBCA601DA0905CCE375C31CE1E4C", hash_generated_method = "A57E0F53289E4703F758BE5C718273B0")
    public synchronized ApnSetting getNextWaitingApn() {
        ArrayList<ApnSetting> list = mWaitingApns;
        ApnSetting apn = null;
        if(list != null)        
        {
            if(!list.isEmpty())            
            {
                apn = list.get(0);
            } //End block
        } //End block
ApnSetting var01A54A38EEF0967D304A8B3F91C82FE0_1067729519 =         apn;
        var01A54A38EEF0967D304A8B3F91C82FE0_1067729519.addTaint(taint);
        return var01A54A38EEF0967D304A8B3F91C82FE0_1067729519;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.977 -0400", hash_original_method = "FA48084F5C2F8120BB5134F54AC68EF9", hash_generated_method = "D7EB0C75529F436FB9AEB7FE372F7599")
    public synchronized void removeNextWaitingApn() {
        if((mWaitingApns != null) && (!mWaitingApns.isEmpty()))        
        {
            mWaitingApns.remove(0);
        } //End block
        // ---------- Original Method ----------
        //if ((mWaitingApns != null) && (!mWaitingApns.isEmpty())) {
            //mWaitingApns.remove(0);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.977 -0400", hash_original_method = "3EEE20ABAF340D832C1A12335FDE6C3B", hash_generated_method = "6699F25BE37B1B7A186104EE2B5CC57F")
    public synchronized ArrayList<ApnSetting> getWaitingApns() {
ArrayList<ApnSetting> var2EB2A36DE5330F22DFCB107B459341D5_2142277218 =         mWaitingApns;
        var2EB2A36DE5330F22DFCB107B459341D5_2142277218.addTaint(taint);
        return var2EB2A36DE5330F22DFCB107B459341D5_2142277218;
        // ---------- Original Method ----------
        //return mWaitingApns;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.977 -0400", hash_original_method = "8BACD1B14114CBCD433A2ADD2EEA6670", hash_generated_method = "EE673A447F8385597DC2F340F11D6EA7")
    public synchronized void setState(DataConnectionTracker.State s) {
        if(DBG)        
        {
            log("setState: " + s + " for type " + mApnType + ", previous state:" + mState);
        } //End block
        mState = s;
        if(mState == DataConnectionTracker.State.FAILED)        
        {
            if(mWaitingApns != null)            
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.977 -0400", hash_original_method = "CA444B740CFD8145F25D1C527A80F346", hash_generated_method = "FF9AAFC7E98004EE5D7EAED7A6E1A045")
    public synchronized DataConnectionTracker.State getState() {
DataConnectionTracker.State var8B975C85F13BECB9FD4D21A5F3C8A56D_1197557504 =         mState;
        var8B975C85F13BECB9FD4D21A5F3C8A56D_1197557504.addTaint(taint);
        return var8B975C85F13BECB9FD4D21A5F3C8A56D_1197557504;
        // ---------- Original Method ----------
        //return mState;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.977 -0400", hash_original_method = "3A4C9A84D96082354CB400C523CD6FA7", hash_generated_method = "34005723BBE9D7D2DCD83997FB654F14")
    public boolean isDisconnected() {
        DataConnectionTracker.State currentState = getState();
        boolean var898A2A912E238FC4B394F7EA9D7A2EF9_1917871378 = (((currentState == DataConnectionTracker.State.IDLE) ||
                    currentState == DataConnectionTracker.State.FAILED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_341858173 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_341858173;
        // ---------- Original Method ----------
        //DataConnectionTracker.State currentState = getState();
        //return ((currentState == DataConnectionTracker.State.IDLE) ||
                    //currentState == DataConnectionTracker.State.FAILED);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.977 -0400", hash_original_method = "8C307D0C19BB4E3FFA53F46CA299668C", hash_generated_method = "C577C12C5267D7B0594AAC8ECBDADB99")
    public synchronized void setReason(String reason) {
        if(DBG)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.978 -0400", hash_original_method = "2809EBE4FEE36399CFA439CAAE81BBAE", hash_generated_method = "72049F69BC940FCCB35396F0FC5A45F1")
    public synchronized String getReason() {
String var59DFD2A70B3F2D6B9D7CBF9B5624B087_1482084501 =         mReason;
        var59DFD2A70B3F2D6B9D7CBF9B5624B087_1482084501.addTaint(taint);
        return var59DFD2A70B3F2D6B9D7CBF9B5624B087_1482084501;
        // ---------- Original Method ----------
        //return mReason;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.978 -0400", hash_original_method = "3DA6D3F7F95DCB338B24FC0B5F96F559", hash_generated_method = "D4AA206F50ECE1F4CCA2FFE9A8DC21C3")
    public boolean isReady() {
        boolean varC4FA3A4411CC615F2E6422278735901F_1567155833 = (mDataEnabled.get() && mDependencyMet.get());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1567152807 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1567152807;
        // ---------- Original Method ----------
        //return mDataEnabled.get() && mDependencyMet.get();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.978 -0400", hash_original_method = "B2C9522D54285815DBD14240ADC4089E", hash_generated_method = "71C9AD97816CB66D361F0B1289F85615")
    public void setEnabled(boolean enabled) {
        addTaint(enabled);
        if(DBG)        
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.984 -0400", hash_original_method = "87E23337C7941EB7C82B165656BD6001", hash_generated_method = "F39099927426512B65D6243242F9A6C1")
    public boolean isEnabled() {
        boolean var20748B0A0AEC204B077E615BA25577C3_1848590115 = (mDataEnabled.get());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1715326879 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1715326879;
        // ---------- Original Method ----------
        //return mDataEnabled.get();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.985 -0400", hash_original_method = "6EC044B2F5DDFA155CCF046B06C94163", hash_generated_method = "97F4A8A75085608471FAD70C7BF8D029")
    public void setDependencyMet(boolean met) {
        addTaint(met);
        if(DBG)        
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.985 -0400", hash_original_method = "0BCF198B460FB01FAD42E5667908EAA7", hash_generated_method = "DF4B16B139DE5F01B5B130DE1BBEF1C9")
    public boolean getDependencyMet() {
        boolean varD5B154EE48E29C282CA900E786460189_1471002684 = (mDependencyMet.get());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_233118518 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_233118518;
        // ---------- Original Method ----------
        //return mDependencyMet.get();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.985 -0400", hash_original_method = "0156798C320A34D339E0A5D3C1FA955E", hash_generated_method = "8AF53D3FCE9A6DA66EBE5C9AA83C1811")
    @Override
    public String toString() {
String varEACD79003F07A7E42C9C09F7AE3B320F_355265201 =         "state=" + getState() + " apnType=" + mApnType;
        varEACD79003F07A7E42C9C09F7AE3B320F_355265201.addTaint(taint);
        return varEACD79003F07A7E42C9C09F7AE3B320F_355265201;
        // ---------- Original Method ----------
        //return "state=" + getState() + " apnType=" + mApnType;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.985 -0400", hash_original_method = "8B2618456D835BC7B38E6BD456997814", hash_generated_method = "770E03B1A4B1D996042EC8C8BF7B0E80")
    protected void log(String s) {
        addTaint(s.getTaint());
        Log.d(LOG_TAG, "[ApnContext] " + s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[ApnContext] " + s);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.985 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "5F5E7D64B04175B8FA820B2440F700FC")

    protected static final boolean DBG = true;
}

