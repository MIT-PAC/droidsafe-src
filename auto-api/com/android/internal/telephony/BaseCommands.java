package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.os.RegistrantList;
import android.os.Registrant;
import android.os.Handler;
import android.os.AsyncResult;
import android.os.SystemProperties;
import android.util.Log;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BaseCommands implements CommandsInterface {
    protected Context mContext;
    protected RadioState mState = RadioState.RADIO_UNAVAILABLE;
    protected RadioState mSimState = RadioState.RADIO_UNAVAILABLE;
    protected RadioState mRuimState = RadioState.RADIO_UNAVAILABLE;
    protected RadioState mNvState = RadioState.RADIO_UNAVAILABLE;
    protected Object mStateMonitor = new Object();
    protected RegistrantList mRadioStateChangedRegistrants = new RegistrantList();
    protected RegistrantList mOnRegistrants = new RegistrantList();
    protected RegistrantList mAvailRegistrants = new RegistrantList();
    protected RegistrantList mOffOrNotAvailRegistrants = new RegistrantList();
    protected RegistrantList mNotAvailRegistrants = new RegistrantList();
    protected RegistrantList mSIMReadyRegistrants = new RegistrantList();
    protected RegistrantList mSIMLockedRegistrants = new RegistrantList();
    protected RegistrantList mRUIMReadyRegistrants = new RegistrantList();
    protected RegistrantList mRUIMLockedRegistrants = new RegistrantList();
    protected RegistrantList mNVReadyRegistrants = new RegistrantList();
    protected RegistrantList mCallStateRegistrants = new RegistrantList();
    protected RegistrantList mVoiceNetworkStateRegistrants = new RegistrantList();
    protected RegistrantList mDataNetworkStateRegistrants = new RegistrantList();
    protected RegistrantList mRadioTechnologyChangedRegistrants = new RegistrantList();
    protected RegistrantList mIccStatusChangedRegistrants = new RegistrantList();
    protected RegistrantList mVoicePrivacyOnRegistrants = new RegistrantList();
    protected RegistrantList mVoicePrivacyOffRegistrants = new RegistrantList();
    protected Registrant mUnsolOemHookRawRegistrant;
    protected RegistrantList mOtaProvisionRegistrants = new RegistrantList();
    protected RegistrantList mCallWaitingInfoRegistrants = new RegistrantList();
    protected RegistrantList mDisplayInfoRegistrants = new RegistrantList();
    protected RegistrantList mSignalInfoRegistrants = new RegistrantList();
    protected RegistrantList mNumberInfoRegistrants = new RegistrantList();
    protected RegistrantList mRedirNumInfoRegistrants = new RegistrantList();
    protected RegistrantList mLineControlInfoRegistrants = new RegistrantList();
    protected RegistrantList mT53ClirInfoRegistrants = new RegistrantList();
    protected RegistrantList mT53AudCntrlInfoRegistrants = new RegistrantList();
    protected RegistrantList mRingbackToneRegistrants = new RegistrantList();
    protected RegistrantList mResendIncallMuteRegistrants = new RegistrantList();
    protected RegistrantList mCdmaSubscriptionChangedRegistrants = new RegistrantList();
    protected RegistrantList mCdmaPrlChangedRegistrants = new RegistrantList();
    protected RegistrantList mExitEmergencyCallbackModeRegistrants = new RegistrantList();
    protected RegistrantList mRilConnectedRegistrants = new RegistrantList();
    protected RegistrantList mIccRefreshRegistrants = new RegistrantList();
    protected Registrant mGsmSmsRegistrant;
    protected Registrant mCdmaSmsRegistrant;
    protected Registrant mNITZTimeRegistrant;
    protected Registrant mSignalStrengthRegistrant;
    protected Registrant mUSSDRegistrant;
    protected Registrant mSmsOnSimRegistrant;
    protected Registrant mSmsStatusRegistrant;
    protected Registrant mSsnRegistrant;
    protected Registrant mCatSessionEndRegistrant;
    protected Registrant mCatProCmdRegistrant;
    protected Registrant mCatEventRegistrant;
    protected Registrant mCatCallSetUpRegistrant;
    protected Registrant mIccSmsFullRegistrant;
    protected Registrant mEmergencyCallbackModeRegistrant;
    protected Registrant mRingRegistrant;
    protected Registrant mRestrictedStateRegistrant;
    protected Registrant mGsmBroadcastSmsRegistrant;
    protected int mPreferredNetworkType;
    protected int mCdmaSubscription;
    protected int mPhoneType;
    protected int mRilVersion = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.719 -0400", hash_original_method = "01B446908FD885F92167357142764DD4", hash_generated_method = "B021C7D99635BBB1F4CF96A7A0EFB2F1")
    @DSModeled(DSC.SAFE)
    public BaseCommands(Context context) {
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.720 -0400", hash_original_method = "9B72FF4B03FA7DBB789195860BAD353E", hash_generated_method = "25B7FBE5AB09D805635471C38B1AAC86")
    @DSModeled(DSC.SAFE)
    public RadioState getRadioState() {
        return (RadioState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.720 -0400", hash_original_method = "683B910DC6B22521B92A68335EE5839B", hash_generated_method = "C10BF6E5656850ED2F00CF2BB27F2707")
    @DSModeled(DSC.SAFE)
    public RadioState getSimState() {
        return (RadioState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSimState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.720 -0400", hash_original_method = "109C4CEB2CE04AD161352D599FB1B09F", hash_generated_method = "218A37C174B2C08A83BB6A1BFCD224FA")
    @DSModeled(DSC.SAFE)
    public RadioState getRuimState() {
        return (RadioState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRuimState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.721 -0400", hash_original_method = "903DF1C2B5F50A021347F02D35C70B16", hash_generated_method = "4FAAE301055E3F12F42184DF75491576")
    @DSModeled(DSC.SAFE)
    public RadioState getNvState() {
        return (RadioState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mNvState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.721 -0400", hash_original_method = "BA48B5E0F5DAB3A06803759CD1341873", hash_generated_method = "9BB8C5D33DF8ECE6B1617B97EEAD4F21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForRadioStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        {
            mRadioStateChangedRegistrants.add(r);
            r.notifyRegistrant();
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //synchronized (mStateMonitor) {
            //mRadioStateChangedRegistrants.add(r);
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.721 -0400", hash_original_method = "5BE66114299D36CCAFF9DF2B86730E54", hash_generated_method = "6D6E5A55B2578BBA7310C897076DE347")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForRadioStateChanged(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        {
            mRadioStateChangedRegistrants.remove(h);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mRadioStateChangedRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.722 -0400", hash_original_method = "08D5A7DF41ADD1C0423FEF7DAFFF25BD", hash_generated_method = "394293EC237B7CE141F042B65C6487DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForOn(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        {
            mOnRegistrants.add(r);
            {
                boolean varC432C946EB5D571635B857CCF1AC273D_496596830 = (mState.isOn());
                {
                    r.notifyRegistrant(new AsyncResult(null, null, null));
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //synchronized (mStateMonitor) {
            //mOnRegistrants.add(r);
            //if (mState.isOn()) {
                //r.notifyRegistrant(new AsyncResult(null, null, null));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.722 -0400", hash_original_method = "DAE1468F1869D31101D72670C27E98BE", hash_generated_method = "4E5EE175C96E7B2457F2DDD0B2919E10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForOn(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        {
            mOnRegistrants.remove(h);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mOnRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.722 -0400", hash_original_method = "B002A9DBB8C7C11A31C2582BB5EE1874", hash_generated_method = "0264233220B4E74FCA7395861329F8A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForAvailable(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        {
            mAvailRegistrants.add(r);
            {
                boolean var125377391E8A2F9B6DF662CC52B1DC3C_486239398 = (mState.isAvailable());
                {
                    r.notifyRegistrant(new AsyncResult(null, null, null));
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //synchronized (mStateMonitor) {
            //mAvailRegistrants.add(r);
            //if (mState.isAvailable()) {
                //r.notifyRegistrant(new AsyncResult(null, null, null));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.722 -0400", hash_original_method = "1CA2372C2986DE46A59E6A0B2684AC78", hash_generated_method = "73F3B215ED546E6C2C0FC5E506CC7A32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForAvailable(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        {
            mAvailRegistrants.remove(h);
        } //End block
        // ---------- Original Method ----------
        //synchronized(mStateMonitor) {
            //mAvailRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.723 -0400", hash_original_method = "29C83058E2196992ACCCDF2436EB895F", hash_generated_method = "B36C71F684AA417FB719CEAD18CC29CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForNotAvailable(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        {
            mNotAvailRegistrants.add(r);
            {
                boolean varD36E632F0E0B6691B3B97AF15E031B66_810636240 = (!mState.isAvailable());
                {
                    r.notifyRegistrant(new AsyncResult(null, null, null));
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //synchronized (mStateMonitor) {
            //mNotAvailRegistrants.add(r);
            //if (!mState.isAvailable()) {
                //r.notifyRegistrant(new AsyncResult(null, null, null));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.723 -0400", hash_original_method = "CBA6674D64F15D2FCB61961545603AC0", hash_generated_method = "2171B45B36FF37E36A75E2F8D1589703")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForNotAvailable(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        {
            mNotAvailRegistrants.remove(h);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mNotAvailRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.723 -0400", hash_original_method = "7D79215F701EB0E62714361F42A7E5B1", hash_generated_method = "07FEEB71BEC79B7220906AECD601D7D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForOffOrNotAvailable(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        {
            mOffOrNotAvailRegistrants.add(r);
            {
                boolean var31C4C6E13480922D49199FF94A7DDE48_861238569 = (mState == RadioState.RADIO_OFF || !mState.isAvailable());
                {
                    r.notifyRegistrant(new AsyncResult(null, null, null));
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //synchronized (mStateMonitor) {
            //mOffOrNotAvailRegistrants.add(r);
            //if (mState == RadioState.RADIO_OFF || !mState.isAvailable()) {
                //r.notifyRegistrant(new AsyncResult(null, null, null));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.723 -0400", hash_original_method = "46989C4094561DAD50220FCBDDA75AA6", hash_generated_method = "A440E0A306FB7B5B289E6CFEF95F677B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForOffOrNotAvailable(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        {
            mOffOrNotAvailRegistrants.remove(h);
        } //End block
        // ---------- Original Method ----------
        //synchronized(mStateMonitor) {
            //mOffOrNotAvailRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.724 -0400", hash_original_method = "CC4432751ADD65730712EA705F22C3CD", hash_generated_method = "74EDAA96E13918359950323079DEAEDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForSIMReady(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        {
            mSIMReadyRegistrants.add(r);
            {
                boolean varB1F49383AD10BFFD2293060B5333102C_1344461973 = (mSimState.isSIMReady());
                {
                    r.notifyRegistrant(new AsyncResult(null, null, null));
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //synchronized (mStateMonitor) {
            //mSIMReadyRegistrants.add(r);
            //if (mSimState.isSIMReady()) {
                //r.notifyRegistrant(new AsyncResult(null, null, null));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.724 -0400", hash_original_method = "AB19D2A11305E45A98335C636B50C33B", hash_generated_method = "DD9401ED937385B54370969CED0919B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForSIMReady(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        {
            mSIMReadyRegistrants.remove(h);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mSIMReadyRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.724 -0400", hash_original_method = "2C12645510D08A28B5398079ECA6EB3E", hash_generated_method = "3DD4892706F4E1066142B59138CA8D07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForRUIMReady(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        {
            mRUIMReadyRegistrants.add(r);
            {
                boolean varDA1934D636D9BE382DB58F17EF4E0175_772889667 = (mRuimState.isRUIMReady());
                {
                    r.notifyRegistrant(new AsyncResult(null, null, null));
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //synchronized (mStateMonitor) {
            //mRUIMReadyRegistrants.add(r);
            //if (mRuimState.isRUIMReady()) {
                //r.notifyRegistrant(new AsyncResult(null, null, null));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.724 -0400", hash_original_method = "5D1587722234669A56B255A4AE24EE40", hash_generated_method = "32675BC28DAF88343501633B95B1D369")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForRUIMReady(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        {
            mRUIMReadyRegistrants.remove(h);
        } //End block
        // ---------- Original Method ----------
        //synchronized(mStateMonitor) {
            //mRUIMReadyRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.725 -0400", hash_original_method = "AC5C11E970C3FC3CF3AF902D98D61BFC", hash_generated_method = "A3C382AFC7CEB3259ABE0C1FA15A2D56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForNVReady(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        {
            mNVReadyRegistrants.add(r);
            {
                boolean var695FD0EFB66918705B8196B52B61E089_1600134487 = (mNvState.isNVReady());
                {
                    r.notifyRegistrant(new AsyncResult(null, null, null));
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //synchronized (mStateMonitor) {
            //mNVReadyRegistrants.add(r);
            //if (mNvState.isNVReady()) {
                //r.notifyRegistrant(new AsyncResult(null, null, null));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.725 -0400", hash_original_method = "0163F455801DEEBEEE15E264968FFDFB", hash_generated_method = "281B6E04395D3CCBCADFBBEB738A0553")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForNVReady(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        {
            mNVReadyRegistrants.remove(h);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mNVReadyRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.725 -0400", hash_original_method = "B685FFCB0EF7DE87E1299EB2C0D91FF5", hash_generated_method = "A11711A3DEF56E005E310021C0EF43BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForSIMLockedOrAbsent(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        {
            mSIMLockedRegistrants.add(r);
            {
                r.notifyRegistrant(new AsyncResult(null, null, null));
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //synchronized (mStateMonitor) {
            //mSIMLockedRegistrants.add(r);
            //if (mSimState == RadioState.SIM_LOCKED_OR_ABSENT) {
                //r.notifyRegistrant(new AsyncResult(null, null, null));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.726 -0400", hash_original_method = "9E4C5688CACB9B43620D9767F5ED2831", hash_generated_method = "592F7B49061FD152AC8B884ECC9A9349")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForSIMLockedOrAbsent(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        {
            mSIMLockedRegistrants.remove(h);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mSIMLockedRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.726 -0400", hash_original_method = "B883F560C1A8BD25AD0100160D6BFB3E", hash_generated_method = "A7D5E9E6678F7CB07506033E25C0DE88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForRUIMLockedOrAbsent(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        {
            mRUIMLockedRegistrants.add(r);
            {
                r.notifyRegistrant(new AsyncResult(null, null, null));
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //synchronized (mStateMonitor) {
            //mRUIMLockedRegistrants.add(r);
            //if (mRuimState == RadioState.RUIM_LOCKED_OR_ABSENT) {
                //r.notifyRegistrant(new AsyncResult(null, null, null));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.726 -0400", hash_original_method = "F7619224FDBBC62B94132C1DE98F9FAE", hash_generated_method = "D945FFADFFD79E346CEE8EC74105D846")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForRUIMLockedOrAbsent(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        {
            mRUIMLockedRegistrants.remove(h);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mRUIMLockedRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.727 -0400", hash_original_method = "F8B2EAE479ED91D774CA562E26158F6A", hash_generated_method = "269228785DCC3EEBB6B77275F4EA19D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForCallStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mCallStateRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mCallStateRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.727 -0400", hash_original_method = "E52D1B8D1DC6759546B1451A8AF3B3CF", hash_generated_method = "CC18A41F78D0C8CBA022B6762FEFB516")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForCallStateChanged(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCallStateRegistrants.remove(h);
        // ---------- Original Method ----------
        //mCallStateRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.727 -0400", hash_original_method = "98A3778C7EF08FDD67D8F92B137CAB51", hash_generated_method = "DB63936C7E3D9F050566480A569148DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForVoiceNetworkStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mVoiceNetworkStateRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mVoiceNetworkStateRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.728 -0400", hash_original_method = "234E1E4E00B04837A43F108E250B7BAF", hash_generated_method = "37AEC2623FE4F80E58371EEA4D590E1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForVoiceNetworkStateChanged(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mVoiceNetworkStateRegistrants.remove(h);
        // ---------- Original Method ----------
        //mVoiceNetworkStateRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.729 -0400", hash_original_method = "4B5CEB601891F006C0B3F4D5219F87E4", hash_generated_method = "5EB91A25990F82F5F683FADB24A76F0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForDataNetworkStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mDataNetworkStateRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mDataNetworkStateRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.729 -0400", hash_original_method = "B36E31BF0B8FB61A85A55463809AD286", hash_generated_method = "A0566CB0D7D7C6745DF1134D52EBB615")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForDataNetworkStateChanged(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mDataNetworkStateRegistrants.remove(h);
        // ---------- Original Method ----------
        //mDataNetworkStateRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.729 -0400", hash_original_method = "BDED847FB928F6304C85EAE7BEEAA6C9", hash_generated_method = "A6E6474E656B4F33BC8C3239E240F144")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForRadioTechnologyChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mRadioTechnologyChangedRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mRadioTechnologyChangedRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.730 -0400", hash_original_method = "836C826B4F0456A82E6FAC645FFBE7BB", hash_generated_method = "FF32274D79A77C6B9B9B624DED2DC494")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForRadioTechnologyChanged(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mRadioTechnologyChangedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mRadioTechnologyChangedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.730 -0400", hash_original_method = "95A4334EE1F2766E4CCE86BA1BBC52D8", hash_generated_method = "A8469F8C395032B76F8CB9FD8434486B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForIccStatusChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mIccStatusChangedRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mIccStatusChangedRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.730 -0400", hash_original_method = "9A6E8063793F2864B53A6581C25E75A7", hash_generated_method = "C3BB4B31AFC65231C9F6EDAD40CD7C1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForIccStatusChanged(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mIccStatusChangedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mIccStatusChangedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.730 -0400", hash_original_method = "7CF6E9042288CF5BCC8A41B33E0FC1FA", hash_generated_method = "330E8001AB1F79D109E9BF529298B30E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnNewGsmSms(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mGsmSmsRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mGsmSmsRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.730 -0400", hash_original_method = "72321487D3788873BF3F462EC89D1700", hash_generated_method = "2E6077801CD9969885D9AC7B96576469")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unSetOnNewGsmSms(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mGsmSmsRegistrant.clear();
        // ---------- Original Method ----------
        //mGsmSmsRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.731 -0400", hash_original_method = "9A78052D6944BA613BED064A1FCE96FC", hash_generated_method = "FFDC6E76BEAA955C778C49F573685D0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnNewCdmaSms(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCdmaSmsRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mCdmaSmsRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.731 -0400", hash_original_method = "DD82A350612B8F1A5930420947333FBB", hash_generated_method = "5E5EED476BF37FD85F4A378BDD71B06E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unSetOnNewCdmaSms(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCdmaSmsRegistrant.clear();
        // ---------- Original Method ----------
        //mCdmaSmsRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.731 -0400", hash_original_method = "33C97215793324BA09B0AC1C1CB62DDA", hash_generated_method = "7587BA46091D292AD4F4B8308A75E410")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnNewGsmBroadcastSms(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mGsmBroadcastSmsRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mGsmBroadcastSmsRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.731 -0400", hash_original_method = "E9BA47BA240C655456D09F99640997E5", hash_generated_method = "4F5C0A89C7765836F33871A06FE8FE03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unSetOnNewGsmBroadcastSms(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mGsmBroadcastSmsRegistrant.clear();
        // ---------- Original Method ----------
        //mGsmBroadcastSmsRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.732 -0400", hash_original_method = "0C74AFDE10017540B93B7C27C178AD12", hash_generated_method = "8CDA36F229DE3A1205450B877AB87B1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnSmsOnSim(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mSmsOnSimRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mSmsOnSimRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.732 -0400", hash_original_method = "4BFC1B363FF8A6E9FA34FFCCC3CD985B", hash_generated_method = "A4A8884D5369C82BB733606460A34C1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unSetOnSmsOnSim(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mSmsOnSimRegistrant.clear();
        // ---------- Original Method ----------
        //mSmsOnSimRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.732 -0400", hash_original_method = "11EEFE2847E162D5587C8E576D844178", hash_generated_method = "5AAB78FD5A22D10391275E239C72CC5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnSmsStatus(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mSmsStatusRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mSmsStatusRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.732 -0400", hash_original_method = "04CADE4525B4CE9C767EB33D42E2733D", hash_generated_method = "9B13F874D1C8ADA277409E49AD5EDDA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unSetOnSmsStatus(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mSmsStatusRegistrant.clear();
        // ---------- Original Method ----------
        //mSmsStatusRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.732 -0400", hash_original_method = "BC3FAB2490D1A217545C1F22508EF51F", hash_generated_method = "EB5D4B69D03D07D3A062BD9E22BB2D7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnSignalStrengthUpdate(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mSignalStrengthRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mSignalStrengthRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.733 -0400", hash_original_method = "1D4E93C65FCE9EA625F7FEE880958248", hash_generated_method = "A0705F68C9AE0A0C880FACB7C95D4226")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unSetOnSignalStrengthUpdate(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mSignalStrengthRegistrant.clear();
        // ---------- Original Method ----------
        //mSignalStrengthRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.733 -0400", hash_original_method = "B93626E61216BE05ADCBA600BD7F638F", hash_generated_method = "699E10F026BB039098FB95C1D9E36C96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnNITZTime(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mNITZTimeRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mNITZTimeRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.733 -0400", hash_original_method = "71E2E923C47A5EE8EAC4F6876E00C1CF", hash_generated_method = "64F50C4D7F8239DB77381475E0E473B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unSetOnNITZTime(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mNITZTimeRegistrant.clear();
        // ---------- Original Method ----------
        //mNITZTimeRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.733 -0400", hash_original_method = "B95EC97639ED908B13D752A2F13F6C7D", hash_generated_method = "0C8CD22A356403E9BB4FC58F252632AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnUSSD(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mUSSDRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mUSSDRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.733 -0400", hash_original_method = "466A12DF4A4A0EB8A1AA727D5C05C698", hash_generated_method = "EF44DB2AFF0A3E5E0CA61EB1331E3A8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unSetOnUSSD(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mUSSDRegistrant.clear();
        // ---------- Original Method ----------
        //mUSSDRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.734 -0400", hash_original_method = "8D0E51584543A1B70BDE99B5C9D8170F", hash_generated_method = "C9C70B49EF8E6E6A701E39BB8BAD5221")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnSuppServiceNotification(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mSsnRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mSsnRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.734 -0400", hash_original_method = "04E80546CB98E014EC8E47E6045C2AF5", hash_generated_method = "D31FEF3A8BE7ACAAD03790E55DDAD00B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unSetOnSuppServiceNotification(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mSsnRegistrant.clear();
        // ---------- Original Method ----------
        //mSsnRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.734 -0400", hash_original_method = "6C58C9A1E016A05F52E2E9DA6EEAE5BF", hash_generated_method = "F97AF9B0D10372F480D76B2493C86CA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnCatSessionEnd(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCatSessionEndRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mCatSessionEndRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.734 -0400", hash_original_method = "17A9937977241978E29E1F3DF9376CD7", hash_generated_method = "2D1DC1985D31936DA981590CF12A4CA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unSetOnCatSessionEnd(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCatSessionEndRegistrant.clear();
        // ---------- Original Method ----------
        //mCatSessionEndRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.734 -0400", hash_original_method = "D06ACD9FCA890DD319CAD0E6F7424AE6", hash_generated_method = "66DD438778F4770BCA90605D8866B054")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnCatProactiveCmd(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCatProCmdRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mCatProCmdRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.734 -0400", hash_original_method = "39B4BC08A3AA39DBF2A794BF5A29A6E7", hash_generated_method = "00CB367F0E558EFD3525ABD808466F54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unSetOnCatProactiveCmd(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCatProCmdRegistrant.clear();
        // ---------- Original Method ----------
        //mCatProCmdRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.735 -0400", hash_original_method = "C195D512833847BDA6BB456AF1EEA3B4", hash_generated_method = "0CDC10A7977592795658573E83F4F5A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnCatEvent(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCatEventRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mCatEventRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.735 -0400", hash_original_method = "86C985017D9E368A998E97DBE619C9A6", hash_generated_method = "1B6282BBEDC1F1C0A88CB0716393058D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unSetOnCatEvent(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCatEventRegistrant.clear();
        // ---------- Original Method ----------
        //mCatEventRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.735 -0400", hash_original_method = "F9248546B0B94A00BBD09A54A068232C", hash_generated_method = "945D02AF0BDA5869C38259CF06A0AF04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnCatCallSetUp(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCatCallSetUpRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mCatCallSetUpRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.735 -0400", hash_original_method = "F6D53B8DEDF633EF9F4DE137121098A9", hash_generated_method = "5F0CD6D61E42AB36D49D6B1FC6B5AEBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unSetOnCatCallSetUp(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCatCallSetUpRegistrant.clear();
        // ---------- Original Method ----------
        //mCatCallSetUpRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.735 -0400", hash_original_method = "CEFBB5FD27FBF0DBAFAF8D4D6CE13FCD", hash_generated_method = "03EEC57862CB0B02CA5637410DE80CD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnIccSmsFull(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mIccSmsFullRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mIccSmsFullRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.735 -0400", hash_original_method = "D81168F17A138BA5FBA6935B53E34C2B", hash_generated_method = "BE2208E4E2FFA8096914FD8C761BE963")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unSetOnIccSmsFull(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mIccSmsFullRegistrant.clear();
        // ---------- Original Method ----------
        //mIccSmsFullRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.735 -0400", hash_original_method = "A200936B8F975752C35A9946FF5C3971", hash_generated_method = "978352039D125ACBDCC700BC8D1608CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForIccRefresh(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mIccRefreshRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mIccRefreshRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.736 -0400", hash_original_method = "EBD003897DB6B5AFBE1C90F6779BE273", hash_generated_method = "B88E687555E7A28869926B88DC61F387")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnIccRefresh(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        registerForIccRefresh(h, what, obj);
        // ---------- Original Method ----------
        //registerForIccRefresh(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.736 -0400", hash_original_method = "B609D137446E0B07BA45D584DFD22E03", hash_generated_method = "D14D5091B726138B45151FFC64BB6189")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEmergencyCallbackMode(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mEmergencyCallbackModeRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mEmergencyCallbackModeRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.736 -0400", hash_original_method = "ABCF42C92E2736F7BB23B78C79C740F8", hash_generated_method = "C3A6261F8A51C05F15FC70EECDE66C4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForIccRefresh(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mIccRefreshRegistrants.remove(h);
        // ---------- Original Method ----------
        //mIccRefreshRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.736 -0400", hash_original_method = "59DD40F71F856C45DA56522E074542F9", hash_generated_method = "60205802707C1AACF31DBF0E01867656")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unsetOnIccRefresh(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        unregisterForIccRefresh(h);
        // ---------- Original Method ----------
        //unregisterForIccRefresh(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.736 -0400", hash_original_method = "8CCA793687CAB6E48BC4AA126090CB63", hash_generated_method = "B14ED19827B6E7023820A55947014DFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnCallRing(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mRingRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mRingRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.736 -0400", hash_original_method = "0FA0F9BD0056AE1CB836D67BF674653F", hash_generated_method = "8BC6BC75BE404B6298A90B53A4CA0B1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unSetOnCallRing(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mRingRegistrant.clear();
        // ---------- Original Method ----------
        //mRingRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.736 -0400", hash_original_method = "66886B702ABE8C8A8A8DA809F8864E28", hash_generated_method = "EDF3A825CFCC9D534FB7193822099326")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForInCallVoicePrivacyOn(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mVoicePrivacyOnRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mVoicePrivacyOnRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.737 -0400", hash_original_method = "88FA771B173FBD911A63B00DE113B65C", hash_generated_method = "9D2EA794EC8D2316D02BE73339B4705E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForInCallVoicePrivacyOn(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mVoicePrivacyOnRegistrants.remove(h);
        // ---------- Original Method ----------
        //mVoicePrivacyOnRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.737 -0400", hash_original_method = "0B5424223CA275A3C5522DC295A616C4", hash_generated_method = "B9977DA719A4C7A8FF7E78D743AEBB5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForInCallVoicePrivacyOff(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mVoicePrivacyOffRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mVoicePrivacyOffRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.737 -0400", hash_original_method = "B6E776E83D138F03FEB9EA861FA40286", hash_generated_method = "987E3CC22292EAB47B0DCF87013DFC8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForInCallVoicePrivacyOff(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mVoicePrivacyOffRegistrants.remove(h);
        // ---------- Original Method ----------
        //mVoicePrivacyOffRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.737 -0400", hash_original_method = "5582113CD84EF18DC77145673CEF3805", hash_generated_method = "610C0C35AE919D733F96C603CABD2EFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnRestrictedStateChanged(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mRestrictedStateRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mRestrictedStateRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.737 -0400", hash_original_method = "5B907CCB9E561B2BE570362A93E2C20B", hash_generated_method = "CE68040866C4B72BC7044BABB8F586CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unSetOnRestrictedStateChanged(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mRestrictedStateRegistrant.clear();
        // ---------- Original Method ----------
        //mRestrictedStateRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.737 -0400", hash_original_method = "79DF5BB64C5088A6DDB6F272CE7B24F1", hash_generated_method = "DDB8267BACC5CA2CB9FD7A1C4D13828A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForDisplayInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mDisplayInfoRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mDisplayInfoRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.738 -0400", hash_original_method = "E2A72B7F5933EC1681F428F18D2E3B34", hash_generated_method = "4C6423EFA4A4EE4DF5E4524EFB789AD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForDisplayInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mDisplayInfoRegistrants.remove(h);
        // ---------- Original Method ----------
        //mDisplayInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.738 -0400", hash_original_method = "9BA2D7AA1768E0B6D41C51CBB7D2703D", hash_generated_method = "9B60EB64DE69FC5D79EE2017FE63EC49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForCallWaitingInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mCallWaitingInfoRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mCallWaitingInfoRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.738 -0400", hash_original_method = "FB5DFAB4742CFF0D938DB8F68F07D307", hash_generated_method = "B6C9BE39D4E0CF001ADBBF7B7D4D96B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForCallWaitingInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCallWaitingInfoRegistrants.remove(h);
        // ---------- Original Method ----------
        //mCallWaitingInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.738 -0400", hash_original_method = "8157808DA0C2AB05798E28DF7F48B26A", hash_generated_method = "4A42D0E021068DFF90FE36D1F021BD06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForSignalInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mSignalInfoRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mSignalInfoRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.738 -0400", hash_original_method = "023EEE600D5AEC21A0C3A38A31A02F7B", hash_generated_method = "3FCE5593280C0F81CD58EEAF52B17269")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnUnsolOemHookRaw(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mUnsolOemHookRawRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mUnsolOemHookRawRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.738 -0400", hash_original_method = "B838AB3AB572CDA21BA8AB62D1043E1A", hash_generated_method = "6EB084328AE054CB78F8BB52F5E7AB77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unSetOnUnsolOemHookRaw(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mUnsolOemHookRawRegistrant.clear();
        // ---------- Original Method ----------
        //mUnsolOemHookRawRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.738 -0400", hash_original_method = "FBD3C31CDF21A461B92CD6532FEB56B0", hash_generated_method = "38ED792F54FD40B89CE6CE40A514636C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForSignalInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mSignalInfoRegistrants.remove(h);
        // ---------- Original Method ----------
        //mSignalInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.739 -0400", hash_original_method = "FE7848C889A71C1D52EEFBC3A5A5348D", hash_generated_method = "4E6D0D17493F3D8FA6617AAB6886D174")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForCdmaOtaProvision(Handler h,int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mOtaProvisionRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mOtaProvisionRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.739 -0400", hash_original_method = "AB18EE6BF73A37B52EA253A91CB20B0C", hash_generated_method = "BAF3566B1797CBB3FFA8BF188B232B69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForCdmaOtaProvision(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mOtaProvisionRegistrants.remove(h);
        // ---------- Original Method ----------
        //mOtaProvisionRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.739 -0400", hash_original_method = "30DBB41A5641384CBA2903733EB0CBD5", hash_generated_method = "F25CCD57F88C14C4732CD0456C3B4BC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForNumberInfo(Handler h,int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mNumberInfoRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mNumberInfoRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.739 -0400", hash_original_method = "D4F64543EBE672B1B0DCB72B7F1C49BF", hash_generated_method = "AE043B6B36348569F47582D393235C80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForNumberInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mNumberInfoRegistrants.remove(h);
        // ---------- Original Method ----------
        //mNumberInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.739 -0400", hash_original_method = "CC4E070A6851C62B1452697B8CB637B7", hash_generated_method = "38D3DC88FE9281EA3BAB5C8DE04E26E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForRedirectedNumberInfo(Handler h,int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mRedirNumInfoRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mRedirNumInfoRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.739 -0400", hash_original_method = "74D412781A2F86280EE77A31B77394EF", hash_generated_method = "C9914866007657F08C1E0C7754574503")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForRedirectedNumberInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mRedirNumInfoRegistrants.remove(h);
        // ---------- Original Method ----------
        //mRedirNumInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.740 -0400", hash_original_method = "DD58771B0A7A96A346281B999DA3057A", hash_generated_method = "B3E018BD0391DFC46E12EF4F6A0D81F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForLineControlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mLineControlInfoRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mLineControlInfoRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.740 -0400", hash_original_method = "068928B7A17337EC34F57926DDEBA1C3", hash_generated_method = "C53CF5F7DD58C989A0BB1760AD092F40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForLineControlInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mLineControlInfoRegistrants.remove(h);
        // ---------- Original Method ----------
        //mLineControlInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.740 -0400", hash_original_method = "9F4D1AFFEF8F9FA5D4778DB89C674FB3", hash_generated_method = "1E2EF58B187ED4160C0686B7DECF5BA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerFoT53ClirlInfo(Handler h,int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mT53ClirInfoRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mT53ClirInfoRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.740 -0400", hash_original_method = "814EFF5BC3C88040487B5EAFB470F77D", hash_generated_method = "2E1FE2803B8D3DF0207EFCC163650A8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForT53ClirInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mT53ClirInfoRegistrants.remove(h);
        // ---------- Original Method ----------
        //mT53ClirInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.740 -0400", hash_original_method = "8DE8707DBC07257BD950DE59918A2503", hash_generated_method = "75BC0A1F392602F677917E5462AC6C68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForT53AudioControlInfo(Handler h,int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mT53AudCntrlInfoRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mT53AudCntrlInfoRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.740 -0400", hash_original_method = "1211535609DA01F7ECA596E2B136A338", hash_generated_method = "898B7646072F3AFE524F79309D9E9DC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForT53AudioControlInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mT53AudCntrlInfoRegistrants.remove(h);
        // ---------- Original Method ----------
        //mT53AudCntrlInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.740 -0400", hash_original_method = "2D9C6817A422E1F1364DE24FB7D91AF7", hash_generated_method = "7F7BA2A0F0CBA8ED7AAFBE0EA2A04795")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForRingbackTone(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mRingbackToneRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mRingbackToneRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.741 -0400", hash_original_method = "F4C16CBC87D51F6E30E1C3D8F75EE8C0", hash_generated_method = "B07E50D37FA50052D38632B6F4CAB0E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForRingbackTone(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mRingbackToneRegistrants.remove(h);
        // ---------- Original Method ----------
        //mRingbackToneRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.743 -0400", hash_original_method = "DB3523E7FBDC2E46BB6C1DB462AA57D5", hash_generated_method = "C414AFF947815FBEE63382C6F63EEB52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForResendIncallMute(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mResendIncallMuteRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mResendIncallMuteRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.743 -0400", hash_original_method = "2A2F187C5BCDF7811DB17C690EF5A1E4", hash_generated_method = "548D690F5A9DFE749007C1A7EA1B7B2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForResendIncallMute(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mResendIncallMuteRegistrants.remove(h);
        // ---------- Original Method ----------
        //mResendIncallMuteRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.744 -0400", hash_original_method = "1CB550350E2118EA5DDBC3DA5F8BB474", hash_generated_method = "0FABB4A0201BFD846FC1F7AEA6FC6127")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void registerForCdmaSubscriptionChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mCdmaSubscriptionChangedRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mCdmaSubscriptionChangedRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.744 -0400", hash_original_method = "7C70EFDA99D4F1952D617116BAD22B13", hash_generated_method = "1DF4421E364CAD93879B75937C01E042")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void unregisterForCdmaSubscriptionChanged(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCdmaSubscriptionChangedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mCdmaSubscriptionChangedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.744 -0400", hash_original_method = "F2C3D1E241ED9A5D51FF055B13B3E9E2", hash_generated_method = "8B53C1AFEE7CD02B82B631BE17160F94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void registerForCdmaPrlChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mCdmaPrlChangedRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mCdmaPrlChangedRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.744 -0400", hash_original_method = "BF3AB10D2A3E0AB38BFCD9D12CDB5334", hash_generated_method = "E42907D2C3EC2F594B71DC3A9A87BC37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void unregisterForCdmaPrlChanged(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCdmaPrlChangedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mCdmaPrlChangedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.744 -0400", hash_original_method = "0716736C7FBF358A30A0A4F7C12EEF60", hash_generated_method = "A066ECEA17416658C6DE1DBAE14481CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void registerForExitEmergencyCallbackMode(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mExitEmergencyCallbackModeRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mExitEmergencyCallbackModeRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.744 -0400", hash_original_method = "C2E40B70802C2BB799E08EA528BF2439", hash_generated_method = "3FE5770AD9E6B943FDAEDD9719A49E95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void unregisterForExitEmergencyCallbackMode(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mExitEmergencyCallbackModeRegistrants.remove(h);
        // ---------- Original Method ----------
        //mExitEmergencyCallbackModeRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.745 -0400", hash_original_method = "A1D8B314CFB1D3E12BFA58A9A280A374", hash_generated_method = "C962B526709CEB8166D01A00E83BFB7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void registerForRilConnected(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Log.d(LOG_TAG, "registerForRilConnected h=" + h + " w=" + what);
        Registrant r;
        r = new Registrant (h, what, obj);
        mRilConnectedRegistrants.add(r);
        {
            Log.d(LOG_TAG, "Notifying: ril connected mRilVersion=" + mRilVersion);
            r.notifyRegistrant(new AsyncResult(null, new Integer(mRilVersion), null));
        } //End block
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "registerForRilConnected h=" + h + " w=" + what);
        //Registrant r = new Registrant (h, what, obj);
        //mRilConnectedRegistrants.add(r);
        //if (mRilVersion != -1) {
            //Log.d(LOG_TAG, "Notifying: ril connected mRilVersion=" + mRilVersion);
            //r.notifyRegistrant(new AsyncResult(null, new Integer(mRilVersion), null));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.745 -0400", hash_original_method = "676479F86CF5300F7E3A79F357120869", hash_generated_method = "2FF7F1133D6E2C63D124D0E4E3BB81C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void unregisterForRilConnected(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mRilConnectedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mRilConnectedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.745 -0400", hash_original_method = "9E4D177DE2C4D1C0BCFAAE47CCC59231", hash_generated_method = "4213F91204D502CD576FBCFFBFDC54D6")
    @DSModeled(DSC.SAFE)
    @Override
    public void setCurrentPreferredNetworkType() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.746 -0400", hash_original_method = "DCDD085282B6C088E7A0852C995BCBF3", hash_generated_method = "31B0E9B1C78B7715C62A46107EF6A4FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setRadioState(RadioState newState) {
        dsTaint.addTaint(newState.dsTaint);
        RadioState oldState;
        {
            oldState = mState;
            {
                boolean varA57A6B192324CD4F622370C1B7316512_1320968552 = (mState.getType() == 0);
                {
                    mSimState = mState;
                    mRuimState = mState;
                    mNvState = mState;
                } //End block
                {
                    boolean varCAB862CEBBE694F190D9E62B19124DBF_210739441 = (mState.getType() == 1);
                    {
                        mSimState = mState;
                    } //End block
                    {
                        boolean var59416DBBACB1B592D2F68B808359CB11_56051154 = (mState.getType() == 2);
                        {
                            mRuimState = mState;
                        } //End block
                        {
                            boolean var2A783CC55430BA7655D0F25D3D461C7C_909123690 = (mState.getType() == 3);
                            {
                                mNvState = mState;
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            mRadioStateChangedRegistrants.notifyRegistrants();
            {
                boolean varA7C84CF67F878FDAE5D11A9DF79D83E4_618642588 = (mState.isAvailable() && !oldState.isAvailable());
                {
                    Log.d(LOG_TAG,"Notifying: radio available");
                    mAvailRegistrants.notifyRegistrants();
                    onRadioAvailable();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var2FDB5B444B83DEA6EEDE92CD58322DD3_1315611567 = (!mState.isAvailable() && oldState.isAvailable());
                {
                    Log.d(LOG_TAG,"Notifying: radio not available");
                    mNotAvailRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean varBED0583E86066F1EE3861BEB93E78641_1113811548 = (mState.isSIMReady() && !oldState.isSIMReady());
                {
                    Log.d(LOG_TAG,"Notifying: SIM ready");
                    mSIMReadyRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                Log.d(LOG_TAG,"Notifying: SIM locked or absent");
                mSIMLockedRegistrants.notifyRegistrants();
            } //End block
            {
                boolean var39C5C9CEC8C4BE8D25675984775135FC_2127136756 = (mState.isRUIMReady() && !oldState.isRUIMReady());
                {
                    Log.d(LOG_TAG,"Notifying: RUIM ready");
                    mRUIMReadyRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                Log.d(LOG_TAG,"Notifying: RUIM locked or absent");
                mRUIMLockedRegistrants.notifyRegistrants();
            } //End block
            {
                boolean var85390FFEEBD9C40A5358749E0561D5D5_827237261 = (mState.isNVReady() && !oldState.isNVReady());
                {
                    Log.d(LOG_TAG,"Notifying: NV ready");
                    mNVReadyRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var4CF30BAD139D8BB63CF4DF108535EC21_115023042 = (mState.isOn() && !oldState.isOn());
                {
                    Log.d(LOG_TAG,"Notifying: Radio On");
                    mOnRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var5338AF0F053F3978DA8435D4833C9E0E_627838859 = ((!mState.isOn() || !mState.isAvailable())
                && !((!oldState.isOn() || !oldState.isAvailable())));
                {
                    Log.d(LOG_TAG,"Notifying: radio off or not available");
                    mOffOrNotAvailRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean varCADB0698B59858BBBF6DEB48B866760C_222253128 = (mState.isGsm() && oldState.isCdma());
                {
                    Log.d(LOG_TAG,"Notifying: radio technology change CDMA to GSM");
                    mRadioTechnologyChangedRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var2B349370EAB2BB60D253C16B0E5DDDF4_146469310 = (mState.isGsm() && !oldState.isOn() && (mPhoneType == Phone.PHONE_TYPE_CDMA));
                {
                    Log.d(LOG_TAG,"Notifying: radio technology change CDMA OFF to GSM");
                    mRadioTechnologyChangedRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var779580E04A970D1A62D66948CB7F983C_167958029 = (mState.isCdma() && oldState.isGsm());
                {
                    Log.d(LOG_TAG,"Notifying: radio technology change GSM to CDMA");
                    mRadioTechnologyChangedRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var907406491902A72484AB8EDF8CEBEE8C_669359947 = (mState.isCdma() && !oldState.isOn() && (mPhoneType == Phone.PHONE_TYPE_GSM));
                {
                    Log.d(LOG_TAG,"Notifying: radio technology change GSM OFF to CDMA");
                    mRadioTechnologyChangedRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.746 -0400", hash_original_method = "1193518C5021D5365FC51C472C5050CB", hash_generated_method = "69A42F2EFF74FEEABD1AC7F929142872")
    @DSModeled(DSC.SAFE)
    protected void onRadioAvailable() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
        private static String getProcCmdLine() {
        String cmdline = "";
        FileInputStream is = null;
        try {
            is = new FileInputStream("/proc/cmdline");
            byte [] buffer = new byte[2048];
            int count = is.read(buffer);
            if (count > 0) {
                cmdline = new String(buffer, 0, count);
            }
        } catch (IOException e) {
            Log.d(LOG_TAG, "No /proc/cmdline exception=" + e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
        }
        Log.d(LOG_TAG, "/proc/cmdline=" + cmdline);
        return cmdline;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.747 -0400", hash_original_method = "5CCABDB2C29BD5F7AE98CB3F70B855A8", hash_generated_method = "1762BB9B88E1103EBF5B052320A0F92B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getLteOnCdmaMode() {
        int var338D796EC42E4804395F013DC2CD8CD5_1546071126 = (getLteOnCdmaModeStatic());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getLteOnCdmaModeStatic();
    }

    
        public static int getLteOnCdmaModeStatic() {
        int retVal;
        int curVal;
        String productType = "";
        curVal = SystemProperties.getInt(TelephonyProperties.PROPERTY_LTE_ON_CDMA_DEVICE,
                    Phone.LTE_ON_CDMA_UNKNOWN);
        retVal = curVal;
        if (retVal == Phone.LTE_ON_CDMA_UNKNOWN) {
            Matcher matcher = sProductTypePattern.matcher(sKernelCmdLine);
            if (matcher.find()) {
                productType = matcher.group(1);
                if (sLteOnCdmaProductType.equals(productType)) {
                    retVal = Phone.LTE_ON_CDMA_TRUE;
                } else {
                    retVal = Phone.LTE_ON_CDMA_FALSE;
                }
            } else {
                retVal = Phone.LTE_ON_CDMA_FALSE;
            }
        }
        Log.d(LOG_TAG, "getLteOnCdmaMode=" + retVal + " curVal=" + curVal +
                " product_type='" + productType +
                "' lteOnCdmaProductType='" + sLteOnCdmaProductType + "'");
        return retVal;
    }

    
    static final String LOG_TAG = "RILB";
    private static final String sKernelCmdLine = getProcCmdLine();
    private static final Pattern sProductTypePattern =
        Pattern.compile("\\sproduct_type\\s*=\\s*(\\w+)");
    private static final String sLteOnCdmaProductType =
        SystemProperties.get(TelephonyProperties.PROPERTY_LTE_ON_CDMA_PRODUCT_TYPE, "");
}

