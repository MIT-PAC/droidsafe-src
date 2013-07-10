package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.util.Log;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ApnContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.285 -0400", hash_original_field = "E352FA068E2A15ACE6EF763778B80C2C", hash_generated_field = "ECDEFF9B6CB4BCFAFA2FE8B349514FEA")

    public String LOG_TAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.285 -0400", hash_original_field = "1649910D3595E6DCD0252C6C47D15EBC", hash_generated_field = "E6D70564297809B18BA965DA7C073C2C")

    private String mApnType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.285 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "8314DAC98A967D1AB7A1CD299AD174DC")

    private DataConnectionTracker.State mState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.285 -0400", hash_original_field = "9450E2D6C5C971C3BE800D082DCF817D", hash_generated_field = "CC4F30E279FD0801D82BAEF762A46736")

    private ArrayList<ApnSetting> mWaitingApns = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.285 -0400", hash_original_field = "9C7B1A41BAC9744FC3B3E9DA2C71FA1A", hash_generated_field = "B5157DDA21B34763981CBBE88F87086B")

    private AtomicInteger mWaitingApnsPermanentFailureCountDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.285 -0400", hash_original_field = "11CD2CABD2F9CDD0C3FC108CE2938E2B", hash_generated_field = "86A7EB1C5FF99A38BD88921D61EE85B9")

    private ApnSetting mApnSetting;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.285 -0400", hash_original_field = "BB620BF7EFE0F557E73EC5E4AF5A9422", hash_generated_field = "75547A706E7CDC7AD9FCAF765698D548")

    DataConnection mDataConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.285 -0400", hash_original_field = "7C12FFD31CACF16872743A547483233E", hash_generated_field = "B625B818D1D9F9AC9BEE968DD70B8D50")

    DataConnectionAc mDataConnectionAc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.285 -0400", hash_original_field = "D37183730F43F82EAD5FD0BEC18C215E", hash_generated_field = "9E1DC384E07D434791BB93D42EBB3641")

    String mReason;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.285 -0400", hash_original_field = "907943D2CA4CBBC2F0E9BB598EF05E6E", hash_generated_field = "F0B5227E84C28EFE9FA32D974847CDB6")

    AtomicBoolean mDataEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.285 -0400", hash_original_field = "73F9A71C73FA325E80F22EFF3F6E9382", hash_generated_field = "2313F72A8363449D009651AB772FE607")

    AtomicBoolean mDependencyMet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.285 -0400", hash_original_method = "8C9BAC99AF1ADE19DD4F445DDF3FD177", hash_generated_method = "9584A5048EC03175EAF3E0AB116D26B9")
    public  ApnContext(String apnType, String logTag) {
        mApnType = apnType;
        mState = DataConnectionTracker.State.IDLE;
        setReason(Phone.REASON_DATA_ENABLED);
        mDataEnabled = new AtomicBoolean(false);
        mDependencyMet = new AtomicBoolean(true);
        mWaitingApnsPermanentFailureCountDown = new AtomicInteger(0);
        LOG_TAG = logTag;
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.286 -0400", hash_original_method = "0F76476B5A4DDD20A8502B6237356474", hash_generated_method = "C47F02FC41844D3030C5CA5BAF355C08")
    public String getApnType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1755106436 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1755106436 = mApnType;
        varB4EAC82CA7396A68D541C85D26508E83_1755106436.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1755106436;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.287 -0400", hash_original_method = "D5BD92E96A7D4915CF46215470E9C147", hash_generated_method = "998DE8305A97428D0B6DF2688B401826")
    public synchronized DataConnection getDataConnection() {
        DataConnection varB4EAC82CA7396A68D541C85D26508E83_807891407 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_807891407 = mDataConnection;
        varB4EAC82CA7396A68D541C85D26508E83_807891407.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_807891407;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.287 -0400", hash_original_method = "DF99AB9AA9AC235054504D7946927384", hash_generated_method = "A407EBF6D7D499CA05EFD164B9F07CF3")
    public synchronized void setDataConnection(DataConnection dataConnection) {
        mDataConnection = dataConnection;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.287 -0400", hash_original_method = "5BBBEC6A4F77592BB47CD138BBF3A7B6", hash_generated_method = "C32B8174299CADEFF339D26649F29189")
    public synchronized DataConnectionAc getDataConnectionAc() {
        DataConnectionAc varB4EAC82CA7396A68D541C85D26508E83_1942728691 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1942728691 = mDataConnectionAc;
        varB4EAC82CA7396A68D541C85D26508E83_1942728691.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1942728691;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.288 -0400", hash_original_method = "68AD8513BB7965F642E8B7E782864662", hash_generated_method = "DD5CCD70242554357C9E6498BDEE2FA4")
    public synchronized void setDataConnectionAc(DataConnectionAc dcac) {
        {
            dcac.addApnContextSync(this);
        } 
        {
            mDataConnectionAc.removeApnContextSync(this);
        } 
        mDataConnectionAc = dcac;
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.288 -0400", hash_original_method = "2BB406053D6E60D1A0AB6AAF52F2E2C8", hash_generated_method = "E6D3DA18C2A59346BEBC1DD93B7CCD39")
    public synchronized ApnSetting getApnSetting() {
        ApnSetting varB4EAC82CA7396A68D541C85D26508E83_498812577 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_498812577 = mApnSetting;
        varB4EAC82CA7396A68D541C85D26508E83_498812577.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_498812577;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.288 -0400", hash_original_method = "C7A08CF02723304D4F2917AE84902158", hash_generated_method = "339FAA179B3F5AFAA3CBA867B9C33852")
    public synchronized void setApnSetting(ApnSetting apnSetting) {
        mApnSetting = apnSetting;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.289 -0400", hash_original_method = "87360F576DD9D6135C262B5A31FCEAAD", hash_generated_method = "2CCEFA0F6C716F41E221B15C64D33F33")
    public synchronized void setWaitingApns(ArrayList<ApnSetting> waitingApns) {
        mWaitingApns = waitingApns;
        mWaitingApnsPermanentFailureCountDown.set(mWaitingApns.size());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.289 -0400", hash_original_method = "BB542F2E9EBFB107E0306A16FFD4893E", hash_generated_method = "EB022FB243E21507D2E84B80CD131F67")
    public int getWaitingApnsPermFailCount() {
        int var193D103C55CE01DA57C107C86191C6F5_647921553 = (mWaitingApnsPermanentFailureCountDown.get());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1418557708 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1418557708;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.289 -0400", hash_original_method = "40A5E79AB68275438A57C310C588D046", hash_generated_method = "CECEABB4ABA114E566E71501B6ACBBDF")
    public void decWaitingApnsPermFailCount() {
        mWaitingApnsPermanentFailureCountDown.decrementAndGet();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.290 -0400", hash_original_method = "8169EBCA601DA0905CCE375C31CE1E4C", hash_generated_method = "0FA156B6708F3600B2A1832C45B26D1E")
    public synchronized ApnSetting getNextWaitingApn() {
        ApnSetting varB4EAC82CA7396A68D541C85D26508E83_1932969003 = null; 
        ArrayList<ApnSetting> list = mWaitingApns;
        ApnSetting apn = null;
        {
            {
                boolean varAC8BEC89D66DF335A471492F884B50EF_716276579 = (!list.isEmpty());
                {
                    apn = list.get(0);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1932969003 = apn;
        varB4EAC82CA7396A68D541C85D26508E83_1932969003.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1932969003;
        
        
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.290 -0400", hash_original_method = "FA48084F5C2F8120BB5134F54AC68EF9", hash_generated_method = "EA1AB69DB5CEF3B447F3BB6A334AD9AC")
    public synchronized void removeNextWaitingApn() {
        {
            boolean var834ADE254106658EC390E81F21C5C471_372870683 = ((mWaitingApns != null) && (!mWaitingApns.isEmpty()));
            {
                mWaitingApns.remove(0);
            } 
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.291 -0400", hash_original_method = "3EEE20ABAF340D832C1A12335FDE6C3B", hash_generated_method = "5EA21EFE5FB5FA12D723D682DE708A50")
    public synchronized ArrayList<ApnSetting> getWaitingApns() {
        ArrayList<ApnSetting> varB4EAC82CA7396A68D541C85D26508E83_1716551498 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1716551498 = mWaitingApns;
        varB4EAC82CA7396A68D541C85D26508E83_1716551498.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1716551498;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.291 -0400", hash_original_method = "8BACD1B14114CBCD433A2ADD2EEA6670", hash_generated_method = "FBB051E4D9B6DCCB189BAD3F5FA6859D")
    public synchronized void setState(DataConnectionTracker.State s) {
        {
            log("setState: " + s + " for type " + mApnType + ", previous state:" + mState);
        } 
        mState = s;
        {
            {
                mWaitingApns.clear();
            } 
        } 
        
        
            
        
        
        
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.292 -0400", hash_original_method = "CA444B740CFD8145F25D1C527A80F346", hash_generated_method = "EF92219C061F1A2B17899D270BEAE990")
    public synchronized DataConnectionTracker.State getState() {
        DataConnectionTracker.State varB4EAC82CA7396A68D541C85D26508E83_1634035166 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1634035166 = mState;
        varB4EAC82CA7396A68D541C85D26508E83_1634035166.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1634035166;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.293 -0400", hash_original_method = "3A4C9A84D96082354CB400C523CD6FA7", hash_generated_method = "720B77EF802A6641B713DC2875E8D7BA")
    public boolean isDisconnected() {
        DataConnectionTracker.State currentState = getState();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_611415670 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_611415670;
        
        
        
                    
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.293 -0400", hash_original_method = "8C307D0C19BB4E3FFA53F46CA299668C", hash_generated_method = "98DB46045A94B3ECA798D81CA4804D7D")
    public synchronized void setReason(String reason) {
        {
            log("set reason as " + reason + ", for type " + mApnType + ",current state " + mState);
        } 
        mReason = reason;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.294 -0400", hash_original_method = "2809EBE4FEE36399CFA439CAAE81BBAE", hash_generated_method = "66530F9CCDA2251BBCBBB487ADF998C0")
    public synchronized String getReason() {
        String varB4EAC82CA7396A68D541C85D26508E83_1951802594 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1951802594 = mReason;
        varB4EAC82CA7396A68D541C85D26508E83_1951802594.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1951802594;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.294 -0400", hash_original_method = "3DA6D3F7F95DCB338B24FC0B5F96F559", hash_generated_method = "F8C331DADB53C3C390AA4E19872FF70C")
    public boolean isReady() {
        boolean varDC59533A891B68C5D0FAC37BBA1F9C39_1467610103 = (mDataEnabled.get() && mDependencyMet.get());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1616424695 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1616424695;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.294 -0400", hash_original_method = "B2C9522D54285815DBD14240ADC4089E", hash_generated_method = "348A180FEBE9E517A1423BA07594F4E1")
    public void setEnabled(boolean enabled) {
        {
            log("set enabled as " + enabled + ", for type " +
                    mApnType + ", current state is " + mDataEnabled.get());
        } 
        mDataEnabled.set(enabled);
        addTaint(enabled);
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.295 -0400", hash_original_method = "87E23337C7941EB7C82B165656BD6001", hash_generated_method = "AF25411D3B04481DCA19F52F260C5FBA")
    public boolean isEnabled() {
        boolean varF5EDE0CB46AF03D0A778EF15D368E936_2021225772 = (mDataEnabled.get());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1036670366 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1036670366;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.295 -0400", hash_original_method = "6EC044B2F5DDFA155CCF046B06C94163", hash_generated_method = "461DABF2251FD9610B969ED20D6DD2F1")
    public void setDependencyMet(boolean met) {
        {
            log("set mDependencyMet as " + met + ", for type " + mApnType +
                    ", current state is " + mDependencyMet.get());
        } 
        mDependencyMet.set(met);
        addTaint(met);
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.295 -0400", hash_original_method = "0BCF198B460FB01FAD42E5667908EAA7", hash_generated_method = "622C558E78469848FA73CAEAB4E90CC0")
    public boolean getDependencyMet() {
        boolean var2AF03CB7BB5A1ABF0023FF01686F7BF3_998577817 = (mDependencyMet.get());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1764731035 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1764731035;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.296 -0400", hash_original_method = "0156798C320A34D339E0A5D3C1FA955E", hash_generated_method = "9C519A03AF6225466EFDBF6FD00783E3")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1757282323 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1757282323 = "state=" + getState() + " apnType=" + mApnType;
        varB4EAC82CA7396A68D541C85D26508E83_1757282323.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1757282323;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.296 -0400", hash_original_method = "8B2618456D835BC7B38E6BD456997814", hash_generated_method = "6C0B375EA076A39B7D4484A98C7A49C3")
    protected void log(String s) {
        Log.d(LOG_TAG, "[ApnContext] " + s);
        addTaint(s.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.296 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "5F5E7D64B04175B8FA820B2440F700FC")

    protected static final boolean DBG = true;
}

