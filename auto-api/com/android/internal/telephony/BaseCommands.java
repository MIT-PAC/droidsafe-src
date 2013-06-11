package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    static final String LOG_TAG = "RILB";
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
    private static final String sKernelCmdLine = getProcCmdLine();
    private static final Pattern sProductTypePattern =
        Pattern.compile("\\sproduct_type\\s*=\\s*(\\w+)");
    private static final String sLteOnCdmaProductType =
        SystemProperties.get(TelephonyProperties.PROPERTY_LTE_ON_CDMA_PRODUCT_TYPE, "");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.587 -0400", hash_original_method = "01B446908FD885F92167357142764DD4", hash_generated_method = "40A701DFE93C6AAA641F24B7BB2608AB")
    @DSModeled(DSC.SAFE)
    public BaseCommands(Context context) {
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.587 -0400", hash_original_method = "9B72FF4B03FA7DBB789195860BAD353E", hash_generated_method = "D2FAB8DB9C8680E76E186421757821BC")
    @DSModeled(DSC.SAFE)
    public RadioState getRadioState() {
        return (RadioState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.587 -0400", hash_original_method = "683B910DC6B22521B92A68335EE5839B", hash_generated_method = "568013A52BBA425CBD206555D18F7FB8")
    @DSModeled(DSC.SAFE)
    public RadioState getSimState() {
        return (RadioState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSimState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.587 -0400", hash_original_method = "109C4CEB2CE04AD161352D599FB1B09F", hash_generated_method = "137D29F8C9BC1310CA876DDF5226E99F")
    @DSModeled(DSC.SAFE)
    public RadioState getRuimState() {
        return (RadioState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRuimState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.587 -0400", hash_original_method = "903DF1C2B5F50A021347F02D35C70B16", hash_generated_method = "8C2D4C21B4349023F00F583F84AA665F")
    @DSModeled(DSC.SAFE)
    public RadioState getNvState() {
        return (RadioState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mNvState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.587 -0400", hash_original_method = "BA48B5E0F5DAB3A06803759CD1341873", hash_generated_method = "3CFF4CD620D566E74F95963F553CAA21")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.587 -0400", hash_original_method = "5BE66114299D36CCAFF9DF2B86730E54", hash_generated_method = "0125C75F93FBF73560174880D6063C0B")
    @DSModeled(DSC.SAFE)
    public void unregisterForRadioStateChanged(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        {
            mRadioStateChangedRegistrants.remove(h);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mRadioStateChangedRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.587 -0400", hash_original_method = "08D5A7DF41ADD1C0423FEF7DAFFF25BD", hash_generated_method = "FA27965A2DD2B22355579F4ECE66A75C")
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
                boolean varC432C946EB5D571635B857CCF1AC273D_500815551 = (mState.isOn());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.587 -0400", hash_original_method = "DAE1468F1869D31101D72670C27E98BE", hash_generated_method = "9ECEEF324ACDD1B00A51920F58D77B44")
    @DSModeled(DSC.SAFE)
    public void unregisterForOn(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        {
            mOnRegistrants.remove(h);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mOnRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.588 -0400", hash_original_method = "B002A9DBB8C7C11A31C2582BB5EE1874", hash_generated_method = "E1DE436A61B227887A663E8C19DFE200")
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
                boolean var125377391E8A2F9B6DF662CC52B1DC3C_1713585166 = (mState.isAvailable());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.588 -0400", hash_original_method = "1CA2372C2986DE46A59E6A0B2684AC78", hash_generated_method = "AE73B05EEEBA2D45EE04490F669FC333")
    @DSModeled(DSC.SAFE)
    public void unregisterForAvailable(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        {
            mAvailRegistrants.remove(h);
        } //End block
        // ---------- Original Method ----------
        //synchronized(mStateMonitor) {
            //mAvailRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.588 -0400", hash_original_method = "29C83058E2196992ACCCDF2436EB895F", hash_generated_method = "DFBC515AF795CE50B00A57237828CA76")
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
                boolean varD36E632F0E0B6691B3B97AF15E031B66_1055597835 = (!mState.isAvailable());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.588 -0400", hash_original_method = "CBA6674D64F15D2FCB61961545603AC0", hash_generated_method = "82404B2FC09B6E240B10D9B6B39FE260")
    @DSModeled(DSC.SAFE)
    public void unregisterForNotAvailable(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        {
            mNotAvailRegistrants.remove(h);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mNotAvailRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.588 -0400", hash_original_method = "7D79215F701EB0E62714361F42A7E5B1", hash_generated_method = "7417095734BA27BACC43BB3B438B332D")
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
                boolean var31C4C6E13480922D49199FF94A7DDE48_2002156243 = (mState == RadioState.RADIO_OFF || !mState.isAvailable());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.588 -0400", hash_original_method = "46989C4094561DAD50220FCBDDA75AA6", hash_generated_method = "69EA2ABD0AB9180EB0CA259A7D489D29")
    @DSModeled(DSC.SAFE)
    public void unregisterForOffOrNotAvailable(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        {
            mOffOrNotAvailRegistrants.remove(h);
        } //End block
        // ---------- Original Method ----------
        //synchronized(mStateMonitor) {
            //mOffOrNotAvailRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.588 -0400", hash_original_method = "CC4432751ADD65730712EA705F22C3CD", hash_generated_method = "5F54A41CCBC7955DFAE95589DB37DA31")
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
                boolean varB1F49383AD10BFFD2293060B5333102C_725228896 = (mSimState.isSIMReady());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.588 -0400", hash_original_method = "AB19D2A11305E45A98335C636B50C33B", hash_generated_method = "96CAD7A17A51F3A664B29F01C7EB85A3")
    @DSModeled(DSC.SAFE)
    public void unregisterForSIMReady(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        {
            mSIMReadyRegistrants.remove(h);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mSIMReadyRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.588 -0400", hash_original_method = "2C12645510D08A28B5398079ECA6EB3E", hash_generated_method = "6E0CCEC970D67FC3F3140E55753C6EA9")
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
                boolean varDA1934D636D9BE382DB58F17EF4E0175_2103485637 = (mRuimState.isRUIMReady());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.588 -0400", hash_original_method = "5D1587722234669A56B255A4AE24EE40", hash_generated_method = "7363827EFD87518C6BE3ABD7D8834F31")
    @DSModeled(DSC.SAFE)
    public void unregisterForRUIMReady(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        {
            mRUIMReadyRegistrants.remove(h);
        } //End block
        // ---------- Original Method ----------
        //synchronized(mStateMonitor) {
            //mRUIMReadyRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.588 -0400", hash_original_method = "AC5C11E970C3FC3CF3AF902D98D61BFC", hash_generated_method = "543C46821DCE68EE55DBE8BFC41E6413")
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
                boolean var695FD0EFB66918705B8196B52B61E089_1968559631 = (mNvState.isNVReady());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.589 -0400", hash_original_method = "0163F455801DEEBEEE15E264968FFDFB", hash_generated_method = "8A2D30BD1A9F2C526F6E3BF08867F246")
    @DSModeled(DSC.SAFE)
    public void unregisterForNVReady(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        {
            mNVReadyRegistrants.remove(h);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mNVReadyRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.589 -0400", hash_original_method = "B685FFCB0EF7DE87E1299EB2C0D91FF5", hash_generated_method = "6DC89B7FBF23E27AD67697CCEFAA8C34")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.589 -0400", hash_original_method = "9E4C5688CACB9B43620D9767F5ED2831", hash_generated_method = "C776CB93173FA55974C7464B68B0144E")
    @DSModeled(DSC.SAFE)
    public void unregisterForSIMLockedOrAbsent(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        {
            mSIMLockedRegistrants.remove(h);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mSIMLockedRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.589 -0400", hash_original_method = "B883F560C1A8BD25AD0100160D6BFB3E", hash_generated_method = "5FDC9F5364AAEC80304D26C3130B828D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.589 -0400", hash_original_method = "F7619224FDBBC62B94132C1DE98F9FAE", hash_generated_method = "FD2A36A3CED64559D0CB7E19EFB80A28")
    @DSModeled(DSC.SAFE)
    public void unregisterForRUIMLockedOrAbsent(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        {
            mRUIMLockedRegistrants.remove(h);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mRUIMLockedRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.589 -0400", hash_original_method = "F8B2EAE479ED91D774CA562E26158F6A", hash_generated_method = "B0F289549C956D39C6C714731660C1D1")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.589 -0400", hash_original_method = "E52D1B8D1DC6759546B1451A8AF3B3CF", hash_generated_method = "C4D33C6C5461494E7BD42034C22D591B")
    @DSModeled(DSC.SAFE)
    public void unregisterForCallStateChanged(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mCallStateRegistrants.remove(h);
        // ---------- Original Method ----------
        //mCallStateRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.589 -0400", hash_original_method = "98A3778C7EF08FDD67D8F92B137CAB51", hash_generated_method = "161817035C73B34E0F130ABD76C61368")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.589 -0400", hash_original_method = "234E1E4E00B04837A43F108E250B7BAF", hash_generated_method = "3FEE53E73B3375A38C0465BF9025B775")
    @DSModeled(DSC.SAFE)
    public void unregisterForVoiceNetworkStateChanged(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mVoiceNetworkStateRegistrants.remove(h);
        // ---------- Original Method ----------
        //mVoiceNetworkStateRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.589 -0400", hash_original_method = "4B5CEB601891F006C0B3F4D5219F87E4", hash_generated_method = "348B71ADC40CA6ADF92B07C4701F1EB5")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.589 -0400", hash_original_method = "B36E31BF0B8FB61A85A55463809AD286", hash_generated_method = "27DBC9EEDFB220B9F93EE4DCE6FDD2D0")
    @DSModeled(DSC.SAFE)
    public void unregisterForDataNetworkStateChanged(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mDataNetworkStateRegistrants.remove(h);
        // ---------- Original Method ----------
        //mDataNetworkStateRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.589 -0400", hash_original_method = "BDED847FB928F6304C85EAE7BEEAA6C9", hash_generated_method = "D12892BC4E71C86C1E9889D375A96711")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.589 -0400", hash_original_method = "836C826B4F0456A82E6FAC645FFBE7BB", hash_generated_method = "837803605915FB6CBA4BCA029AF565E8")
    @DSModeled(DSC.SAFE)
    public void unregisterForRadioTechnologyChanged(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mRadioTechnologyChangedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mRadioTechnologyChangedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.589 -0400", hash_original_method = "95A4334EE1F2766E4CCE86BA1BBC52D8", hash_generated_method = "5262932192650DE7EFC87299D844B41C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.589 -0400", hash_original_method = "9A6E8063793F2864B53A6581C25E75A7", hash_generated_method = "6BC425CD28C78EC92AC2EBC3E1FD72C5")
    @DSModeled(DSC.SAFE)
    public void unregisterForIccStatusChanged(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mIccStatusChangedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mIccStatusChangedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.590 -0400", hash_original_method = "7CF6E9042288CF5BCC8A41B33E0FC1FA", hash_generated_method = "A27D174C227BB7D0FC244E2DD4142F85")
    @DSModeled(DSC.SAFE)
    public void setOnNewGsmSms(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mGsmSmsRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mGsmSmsRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.590 -0400", hash_original_method = "72321487D3788873BF3F462EC89D1700", hash_generated_method = "797903389C8775BC4521A3A314A0ED1D")
    @DSModeled(DSC.SAFE)
    public void unSetOnNewGsmSms(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mGsmSmsRegistrant.clear();
        // ---------- Original Method ----------
        //mGsmSmsRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.590 -0400", hash_original_method = "9A78052D6944BA613BED064A1FCE96FC", hash_generated_method = "046753EA3B8F1AEECA2C6FEA6AA5AEA4")
    @DSModeled(DSC.SAFE)
    public void setOnNewCdmaSms(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCdmaSmsRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mCdmaSmsRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.590 -0400", hash_original_method = "DD82A350612B8F1A5930420947333FBB", hash_generated_method = "E58DED9788FF4A8317CDD99136418E25")
    @DSModeled(DSC.SAFE)
    public void unSetOnNewCdmaSms(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCdmaSmsRegistrant.clear();
        // ---------- Original Method ----------
        //mCdmaSmsRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.590 -0400", hash_original_method = "33C97215793324BA09B0AC1C1CB62DDA", hash_generated_method = "CE3D784B9BC9ABF097C5071A6D02EC07")
    @DSModeled(DSC.SAFE)
    public void setOnNewGsmBroadcastSms(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mGsmBroadcastSmsRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mGsmBroadcastSmsRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.590 -0400", hash_original_method = "E9BA47BA240C655456D09F99640997E5", hash_generated_method = "56B9A2B4D4552B2646086754271845D4")
    @DSModeled(DSC.SAFE)
    public void unSetOnNewGsmBroadcastSms(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mGsmBroadcastSmsRegistrant.clear();
        // ---------- Original Method ----------
        //mGsmBroadcastSmsRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.590 -0400", hash_original_method = "0C74AFDE10017540B93B7C27C178AD12", hash_generated_method = "A843D14CC5F739BD55E838CCBD3667C2")
    @DSModeled(DSC.SAFE)
    public void setOnSmsOnSim(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mSmsOnSimRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mSmsOnSimRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.590 -0400", hash_original_method = "4BFC1B363FF8A6E9FA34FFCCC3CD985B", hash_generated_method = "291EFF494EA4267AEE83842FFE791881")
    @DSModeled(DSC.SAFE)
    public void unSetOnSmsOnSim(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mSmsOnSimRegistrant.clear();
        // ---------- Original Method ----------
        //mSmsOnSimRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.590 -0400", hash_original_method = "11EEFE2847E162D5587C8E576D844178", hash_generated_method = "95F6511CC1FC6447BC50948F3BB8BE3A")
    @DSModeled(DSC.SAFE)
    public void setOnSmsStatus(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mSmsStatusRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mSmsStatusRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.590 -0400", hash_original_method = "04CADE4525B4CE9C767EB33D42E2733D", hash_generated_method = "A745CBCA689D7AFA113DDB3FEDBCE8BF")
    @DSModeled(DSC.SAFE)
    public void unSetOnSmsStatus(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mSmsStatusRegistrant.clear();
        // ---------- Original Method ----------
        //mSmsStatusRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.590 -0400", hash_original_method = "BC3FAB2490D1A217545C1F22508EF51F", hash_generated_method = "0C0468CE303703E8E1FAF3F67DEEEE01")
    @DSModeled(DSC.SAFE)
    public void setOnSignalStrengthUpdate(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mSignalStrengthRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mSignalStrengthRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.590 -0400", hash_original_method = "1D4E93C65FCE9EA625F7FEE880958248", hash_generated_method = "1E724EE83F213C81A18E4877DB90FAB9")
    @DSModeled(DSC.SAFE)
    public void unSetOnSignalStrengthUpdate(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mSignalStrengthRegistrant.clear();
        // ---------- Original Method ----------
        //mSignalStrengthRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.590 -0400", hash_original_method = "B93626E61216BE05ADCBA600BD7F638F", hash_generated_method = "E3CA111D2ABB9D944C39722938066B0E")
    @DSModeled(DSC.SAFE)
    public void setOnNITZTime(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mNITZTimeRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mNITZTimeRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.590 -0400", hash_original_method = "71E2E923C47A5EE8EAC4F6876E00C1CF", hash_generated_method = "B14EBF7D7A2EA2574904CB3932864B9F")
    @DSModeled(DSC.SAFE)
    public void unSetOnNITZTime(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mNITZTimeRegistrant.clear();
        // ---------- Original Method ----------
        //mNITZTimeRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.590 -0400", hash_original_method = "B95EC97639ED908B13D752A2F13F6C7D", hash_generated_method = "6E15F269F344B13339D9AC4DD5C2C9C1")
    @DSModeled(DSC.SAFE)
    public void setOnUSSD(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mUSSDRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mUSSDRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.590 -0400", hash_original_method = "466A12DF4A4A0EB8A1AA727D5C05C698", hash_generated_method = "72A7DDCC5D2A9B50E16A31689CAF0031")
    @DSModeled(DSC.SAFE)
    public void unSetOnUSSD(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mUSSDRegistrant.clear();
        // ---------- Original Method ----------
        //mUSSDRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.590 -0400", hash_original_method = "8D0E51584543A1B70BDE99B5C9D8170F", hash_generated_method = "6DD48DEC3ADBF7AB08751C4016DCD1CB")
    @DSModeled(DSC.SAFE)
    public void setOnSuppServiceNotification(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mSsnRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mSsnRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.591 -0400", hash_original_method = "04E80546CB98E014EC8E47E6045C2AF5", hash_generated_method = "FBBC881F078B7B5F7A634FAD9DC06AC9")
    @DSModeled(DSC.SAFE)
    public void unSetOnSuppServiceNotification(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mSsnRegistrant.clear();
        // ---------- Original Method ----------
        //mSsnRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.591 -0400", hash_original_method = "6C58C9A1E016A05F52E2E9DA6EEAE5BF", hash_generated_method = "67A7AE26A159904BFADB94E08A49FC3C")
    @DSModeled(DSC.SAFE)
    public void setOnCatSessionEnd(Handler h, int what, Object obj) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCatSessionEndRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mCatSessionEndRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.591 -0400", hash_original_method = "17A9937977241978E29E1F3DF9376CD7", hash_generated_method = "46E3A012D78317332E413663318C7D1A")
    @DSModeled(DSC.SAFE)
    public void unSetOnCatSessionEnd(Handler h) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(h.dsTaint);
        mCatSessionEndRegistrant.clear();
        // ---------- Original Method ----------
        //mCatSessionEndRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.591 -0400", hash_original_method = "D06ACD9FCA890DD319CAD0E6F7424AE6", hash_generated_method = "9D64339C31A0287A7EEF3DA996423B10")
    @DSModeled(DSC.SAFE)
    public void setOnCatProactiveCmd(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCatProCmdRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mCatProCmdRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.591 -0400", hash_original_method = "39B4BC08A3AA39DBF2A794BF5A29A6E7", hash_generated_method = "E732147D388254DEFEF9AF6D024CB44E")
    @DSModeled(DSC.SAFE)
    public void unSetOnCatProactiveCmd(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCatProCmdRegistrant.clear();
        // ---------- Original Method ----------
        //mCatProCmdRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.591 -0400", hash_original_method = "C195D512833847BDA6BB456AF1EEA3B4", hash_generated_method = "B7FE3089966B0FD53A297CD0CAF74206")
    @DSModeled(DSC.SAFE)
    public void setOnCatEvent(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCatEventRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mCatEventRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.591 -0400", hash_original_method = "86C985017D9E368A998E97DBE619C9A6", hash_generated_method = "0BA1AED342B6F90134E0A287EB3815F3")
    @DSModeled(DSC.SAFE)
    public void unSetOnCatEvent(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCatEventRegistrant.clear();
        // ---------- Original Method ----------
        //mCatEventRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.591 -0400", hash_original_method = "F9248546B0B94A00BBD09A54A068232C", hash_generated_method = "C7BE4AD2C34FFB00C4687ACE38707113")
    @DSModeled(DSC.SAFE)
    public void setOnCatCallSetUp(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCatCallSetUpRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mCatCallSetUpRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.591 -0400", hash_original_method = "F6D53B8DEDF633EF9F4DE137121098A9", hash_generated_method = "35A7C867FD5931DB5E5C5D557FDBBABF")
    @DSModeled(DSC.SAFE)
    public void unSetOnCatCallSetUp(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCatCallSetUpRegistrant.clear();
        // ---------- Original Method ----------
        //mCatCallSetUpRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.591 -0400", hash_original_method = "CEFBB5FD27FBF0DBAFAF8D4D6CE13FCD", hash_generated_method = "3957909EB25E9AA4025794F194B7E3A3")
    @DSModeled(DSC.SAFE)
    public void setOnIccSmsFull(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mIccSmsFullRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mIccSmsFullRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.591 -0400", hash_original_method = "D81168F17A138BA5FBA6935B53E34C2B", hash_generated_method = "2576ECE624F0DB1EB97993C540E8C1E4")
    @DSModeled(DSC.SAFE)
    public void unSetOnIccSmsFull(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mIccSmsFullRegistrant.clear();
        // ---------- Original Method ----------
        //mIccSmsFullRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.591 -0400", hash_original_method = "A200936B8F975752C35A9946FF5C3971", hash_generated_method = "118C81D17D15D64DED1248568E7308A6")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.591 -0400", hash_original_method = "EBD003897DB6B5AFBE1C90F6779BE273", hash_generated_method = "A1DB60CC5BD2509204CD7747BB199437")
    @DSModeled(DSC.SAFE)
    public void setOnIccRefresh(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        registerForIccRefresh(h, what, obj);
        // ---------- Original Method ----------
        //registerForIccRefresh(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.591 -0400", hash_original_method = "B609D137446E0B07BA45D584DFD22E03", hash_generated_method = "7645D79B406C89B02B631BC59AF10438")
    @DSModeled(DSC.SAFE)
    public void setEmergencyCallbackMode(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mEmergencyCallbackModeRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mEmergencyCallbackModeRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.591 -0400", hash_original_method = "ABCF42C92E2736F7BB23B78C79C740F8", hash_generated_method = "C9AB21F280962A8DC5AD30F17A273256")
    @DSModeled(DSC.SAFE)
    public void unregisterForIccRefresh(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mIccRefreshRegistrants.remove(h);
        // ---------- Original Method ----------
        //mIccRefreshRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.591 -0400", hash_original_method = "59DD40F71F856C45DA56522E074542F9", hash_generated_method = "B0C6823816032C9748E55E875333712C")
    @DSModeled(DSC.SAFE)
    public void unsetOnIccRefresh(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        unregisterForIccRefresh(h);
        // ---------- Original Method ----------
        //unregisterForIccRefresh(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.591 -0400", hash_original_method = "8CCA793687CAB6E48BC4AA126090CB63", hash_generated_method = "E2EE677C3505665EB15EAC24A21FC25A")
    @DSModeled(DSC.SAFE)
    public void setOnCallRing(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mRingRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mRingRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.591 -0400", hash_original_method = "0FA0F9BD0056AE1CB836D67BF674653F", hash_generated_method = "799F95024D28F8EED94AA80A566FD429")
    @DSModeled(DSC.SAFE)
    public void unSetOnCallRing(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mRingRegistrant.clear();
        // ---------- Original Method ----------
        //mRingRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.592 -0400", hash_original_method = "66886B702ABE8C8A8A8DA809F8864E28", hash_generated_method = "22920A150FA709A37EBEBF1DB610A393")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.592 -0400", hash_original_method = "88FA771B173FBD911A63B00DE113B65C", hash_generated_method = "BD19C672C6F6CC8706C9B54025B07664")
    @DSModeled(DSC.SAFE)
    public void unregisterForInCallVoicePrivacyOn(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mVoicePrivacyOnRegistrants.remove(h);
        // ---------- Original Method ----------
        //mVoicePrivacyOnRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.592 -0400", hash_original_method = "0B5424223CA275A3C5522DC295A616C4", hash_generated_method = "21E60CD97E6C1B3D376DD9496BCDB2D2")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.592 -0400", hash_original_method = "B6E776E83D138F03FEB9EA861FA40286", hash_generated_method = "57ABE261FE95CAFA06F5B229F2AB04C2")
    @DSModeled(DSC.SAFE)
    public void unregisterForInCallVoicePrivacyOff(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mVoicePrivacyOffRegistrants.remove(h);
        // ---------- Original Method ----------
        //mVoicePrivacyOffRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.592 -0400", hash_original_method = "5582113CD84EF18DC77145673CEF3805", hash_generated_method = "7385D25E2A94B83EB460678D3DE1F382")
    @DSModeled(DSC.SAFE)
    public void setOnRestrictedStateChanged(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mRestrictedStateRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mRestrictedStateRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.592 -0400", hash_original_method = "5B907CCB9E561B2BE570362A93E2C20B", hash_generated_method = "F19686AB22C5CC5FEDE95E3EC2C7FBCC")
    @DSModeled(DSC.SAFE)
    public void unSetOnRestrictedStateChanged(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mRestrictedStateRegistrant.clear();
        // ---------- Original Method ----------
        //mRestrictedStateRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.592 -0400", hash_original_method = "79DF5BB64C5088A6DDB6F272CE7B24F1", hash_generated_method = "46FBB4E068797B99D03D764F71FD1524")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.592 -0400", hash_original_method = "E2A72B7F5933EC1681F428F18D2E3B34", hash_generated_method = "4EA411084510CB7310698F0DF0B7928D")
    @DSModeled(DSC.SAFE)
    public void unregisterForDisplayInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mDisplayInfoRegistrants.remove(h);
        // ---------- Original Method ----------
        //mDisplayInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.592 -0400", hash_original_method = "9BA2D7AA1768E0B6D41C51CBB7D2703D", hash_generated_method = "986967B3DB96B16917D6BFEB9F5E93C6")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.592 -0400", hash_original_method = "FB5DFAB4742CFF0D938DB8F68F07D307", hash_generated_method = "7327CEE56FE0BE8B7498305331BE4D78")
    @DSModeled(DSC.SAFE)
    public void unregisterForCallWaitingInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mCallWaitingInfoRegistrants.remove(h);
        // ---------- Original Method ----------
        //mCallWaitingInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.592 -0400", hash_original_method = "8157808DA0C2AB05798E28DF7F48B26A", hash_generated_method = "EF45E494988E2CA5A9EE4BC3B15BBAA7")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.592 -0400", hash_original_method = "023EEE600D5AEC21A0C3A38A31A02F7B", hash_generated_method = "2323AF58414A97CAD7584378F8A2662C")
    @DSModeled(DSC.SAFE)
    public void setOnUnsolOemHookRaw(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mUnsolOemHookRawRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mUnsolOemHookRawRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.592 -0400", hash_original_method = "B838AB3AB572CDA21BA8AB62D1043E1A", hash_generated_method = "1BC4A124B29B5AF71EF81F82067F966F")
    @DSModeled(DSC.SAFE)
    public void unSetOnUnsolOemHookRaw(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mUnsolOemHookRawRegistrant.clear();
        // ---------- Original Method ----------
        //mUnsolOemHookRawRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.592 -0400", hash_original_method = "FBD3C31CDF21A461B92CD6532FEB56B0", hash_generated_method = "C753B1508DA57C1F07F9C1E4DEB241C7")
    @DSModeled(DSC.SAFE)
    public void unregisterForSignalInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mSignalInfoRegistrants.remove(h);
        // ---------- Original Method ----------
        //mSignalInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.592 -0400", hash_original_method = "FE7848C889A71C1D52EEFBC3A5A5348D", hash_generated_method = "F2D11F0FFEBBA619458FA38338555A86")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.592 -0400", hash_original_method = "AB18EE6BF73A37B52EA253A91CB20B0C", hash_generated_method = "444754449481D881E53AFA479626CA2B")
    @DSModeled(DSC.SAFE)
    public void unregisterForCdmaOtaProvision(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mOtaProvisionRegistrants.remove(h);
        // ---------- Original Method ----------
        //mOtaProvisionRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.592 -0400", hash_original_method = "30DBB41A5641384CBA2903733EB0CBD5", hash_generated_method = "A796AD5C59F8ABB86898BB5E12D5BB1C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.593 -0400", hash_original_method = "D4F64543EBE672B1B0DCB72B7F1C49BF", hash_generated_method = "ED7FCDBB086E8EE341B3CAD5EEF319BD")
    @DSModeled(DSC.SAFE)
    public void unregisterForNumberInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mNumberInfoRegistrants.remove(h);
        // ---------- Original Method ----------
        //mNumberInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.593 -0400", hash_original_method = "CC4E070A6851C62B1452697B8CB637B7", hash_generated_method = "DE03E912539AFB455D83DB3B6750B0E3")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.593 -0400", hash_original_method = "74D412781A2F86280EE77A31B77394EF", hash_generated_method = "C74658F6E728624FF72F50F31EFA1F3C")
    @DSModeled(DSC.SAFE)
    public void unregisterForRedirectedNumberInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mRedirNumInfoRegistrants.remove(h);
        // ---------- Original Method ----------
        //mRedirNumInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.593 -0400", hash_original_method = "DD58771B0A7A96A346281B999DA3057A", hash_generated_method = "6E0D5EDFD6C7B2EACBE2C839BB71BFE8")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.593 -0400", hash_original_method = "068928B7A17337EC34F57926DDEBA1C3", hash_generated_method = "4A6B613A7EADBEEE690F992123187844")
    @DSModeled(DSC.SAFE)
    public void unregisterForLineControlInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mLineControlInfoRegistrants.remove(h);
        // ---------- Original Method ----------
        //mLineControlInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.593 -0400", hash_original_method = "9F4D1AFFEF8F9FA5D4778DB89C674FB3", hash_generated_method = "F50AAFF5BEB1BCBFA93FA0D07C1F5E92")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.593 -0400", hash_original_method = "814EFF5BC3C88040487B5EAFB470F77D", hash_generated_method = "60A354E4171FE18D40C9A78C9818A02C")
    @DSModeled(DSC.SAFE)
    public void unregisterForT53ClirInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mT53ClirInfoRegistrants.remove(h);
        // ---------- Original Method ----------
        //mT53ClirInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.593 -0400", hash_original_method = "8DE8707DBC07257BD950DE59918A2503", hash_generated_method = "359ADB34507982B4ED2B9BF70DA845B1")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.593 -0400", hash_original_method = "1211535609DA01F7ECA596E2B136A338", hash_generated_method = "64A57E43243D7AED25AD9A35C5FDA537")
    @DSModeled(DSC.SAFE)
    public void unregisterForT53AudioControlInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mT53AudCntrlInfoRegistrants.remove(h);
        // ---------- Original Method ----------
        //mT53AudCntrlInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.593 -0400", hash_original_method = "2D9C6817A422E1F1364DE24FB7D91AF7", hash_generated_method = "141758C627D40C7438904B3D0495AA94")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.593 -0400", hash_original_method = "F4C16CBC87D51F6E30E1C3D8F75EE8C0", hash_generated_method = "1FB47B3212FD8360AE457B4E26D2C38A")
    @DSModeled(DSC.SAFE)
    public void unregisterForRingbackTone(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mRingbackToneRegistrants.remove(h);
        // ---------- Original Method ----------
        //mRingbackToneRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.593 -0400", hash_original_method = "DB3523E7FBDC2E46BB6C1DB462AA57D5", hash_generated_method = "7E8234318AE965ACDAE04B731C5A5817")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.593 -0400", hash_original_method = "2A2F187C5BCDF7811DB17C690EF5A1E4", hash_generated_method = "2B8E508A50BE523873D8F4382042A24C")
    @DSModeled(DSC.SAFE)
    public void unregisterForResendIncallMute(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mResendIncallMuteRegistrants.remove(h);
        // ---------- Original Method ----------
        //mResendIncallMuteRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.593 -0400", hash_original_method = "1CB550350E2118EA5DDBC3DA5F8BB474", hash_generated_method = "5E4029656EA481C62F3592EDDCF9C51C")
    @DSModeled(DSC.SAFE)
    @Override
    public void registerForCdmaSubscriptionChanged(Handler h, int what, Object obj) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.593 -0400", hash_original_method = "7C70EFDA99D4F1952D617116BAD22B13", hash_generated_method = "26566080BA64783A3AF168A94915D257")
    @DSModeled(DSC.SAFE)
    @Override
    public void unregisterForCdmaSubscriptionChanged(Handler h) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mCdmaSubscriptionChangedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mCdmaSubscriptionChangedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.593 -0400", hash_original_method = "F2C3D1E241ED9A5D51FF055B13B3E9E2", hash_generated_method = "C2390451947820FE714631BC36CDED02")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.594 -0400", hash_original_method = "BF3AB10D2A3E0AB38BFCD9D12CDB5334", hash_generated_method = "576B22F44694553939C85BA63D8DA8A2")
    @DSModeled(DSC.SAFE)
    @Override
    public void unregisterForCdmaPrlChanged(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mCdmaPrlChangedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mCdmaPrlChangedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.594 -0400", hash_original_method = "0716736C7FBF358A30A0A4F7C12EEF60", hash_generated_method = "4D4EBC78534F0DC7CA3784FD931F3D7E")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.594 -0400", hash_original_method = "C2E40B70802C2BB799E08EA528BF2439", hash_generated_method = "BB0AD3D484B071FA4F30121D34E596AF")
    @DSModeled(DSC.SAFE)
    @Override
    public void unregisterForExitEmergencyCallbackMode(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mExitEmergencyCallbackModeRegistrants.remove(h);
        // ---------- Original Method ----------
        //mExitEmergencyCallbackModeRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.594 -0400", hash_original_method = "A1D8B314CFB1D3E12BFA58A9A280A374", hash_generated_method = "0E866868EBA61736753CC472B88A8D3C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.594 -0400", hash_original_method = "676479F86CF5300F7E3A79F357120869", hash_generated_method = "B778761E64C1C5DB80907DCC617229EC")
    @DSModeled(DSC.SAFE)
    @Override
    public void unregisterForRilConnected(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mRilConnectedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mRilConnectedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.594 -0400", hash_original_method = "9E4D177DE2C4D1C0BCFAAE47CCC59231", hash_generated_method = "1247114EFCF4DCF7E1D9D3C92677100D")
    @DSModeled(DSC.SAFE)
    @Override
    public void setCurrentPreferredNetworkType() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.595 -0400", hash_original_method = "DCDD085282B6C088E7A0852C995BCBF3", hash_generated_method = "A0522F76F7ABEE3444473B06E211C1E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setRadioState(RadioState newState) {
        dsTaint.addTaint(newState.dsTaint);
        RadioState oldState;
        {
            oldState = mState;
            {
                boolean varA57A6B192324CD4F622370C1B7316512_555137738 = (mState.getType() == 0);
                {
                    mSimState = mState;
                    mRuimState = mState;
                    mNvState = mState;
                } //End block
                {
                    boolean varCAB862CEBBE694F190D9E62B19124DBF_1834788206 = (mState.getType() == 1);
                    {
                        mSimState = mState;
                    } //End block
                    {
                        boolean var59416DBBACB1B592D2F68B808359CB11_1876929055 = (mState.getType() == 2);
                        {
                            mRuimState = mState;
                        } //End block
                        {
                            boolean var2A783CC55430BA7655D0F25D3D461C7C_1942614042 = (mState.getType() == 3);
                            {
                                mNvState = mState;
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            mRadioStateChangedRegistrants.notifyRegistrants();
            {
                boolean varA7C84CF67F878FDAE5D11A9DF79D83E4_1294869712 = (mState.isAvailable() && !oldState.isAvailable());
                {
                    Log.d(LOG_TAG,"Notifying: radio available");
                    mAvailRegistrants.notifyRegistrants();
                    onRadioAvailable();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var2FDB5B444B83DEA6EEDE92CD58322DD3_805249049 = (!mState.isAvailable() && oldState.isAvailable());
                {
                    Log.d(LOG_TAG,"Notifying: radio not available");
                    mNotAvailRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean varBED0583E86066F1EE3861BEB93E78641_253727369 = (mState.isSIMReady() && !oldState.isSIMReady());
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
                boolean var39C5C9CEC8C4BE8D25675984775135FC_425900028 = (mState.isRUIMReady() && !oldState.isRUIMReady());
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
                boolean var85390FFEEBD9C40A5358749E0561D5D5_413826802 = (mState.isNVReady() && !oldState.isNVReady());
                {
                    Log.d(LOG_TAG,"Notifying: NV ready");
                    mNVReadyRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var4CF30BAD139D8BB63CF4DF108535EC21_2076508839 = (mState.isOn() && !oldState.isOn());
                {
                    Log.d(LOG_TAG,"Notifying: Radio On");
                    mOnRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var5338AF0F053F3978DA8435D4833C9E0E_278557166 = ((!mState.isOn() || !mState.isAvailable())
                && !((!oldState.isOn() || !oldState.isAvailable())));
                {
                    Log.d(LOG_TAG,"Notifying: radio off or not available");
                    mOffOrNotAvailRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean varCADB0698B59858BBBF6DEB48B866760C_1887515563 = (mState.isGsm() && oldState.isCdma());
                {
                    Log.d(LOG_TAG,"Notifying: radio technology change CDMA to GSM");
                    mRadioTechnologyChangedRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var2B349370EAB2BB60D253C16B0E5DDDF4_967594912 = (mState.isGsm() && !oldState.isOn() && (mPhoneType == Phone.PHONE_TYPE_CDMA));
                {
                    Log.d(LOG_TAG,"Notifying: radio technology change CDMA OFF to GSM");
                    mRadioTechnologyChangedRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var779580E04A970D1A62D66948CB7F983C_336412101 = (mState.isCdma() && oldState.isGsm());
                {
                    Log.d(LOG_TAG,"Notifying: radio technology change GSM to CDMA");
                    mRadioTechnologyChangedRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var907406491902A72484AB8EDF8CEBEE8C_1824539657 = (mState.isCdma() && !oldState.isOn() && (mPhoneType == Phone.PHONE_TYPE_GSM));
                {
                    Log.d(LOG_TAG,"Notifying: radio technology change GSM OFF to CDMA");
                    mRadioTechnologyChangedRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.595 -0400", hash_original_method = "1193518C5021D5365FC51C472C5050CB", hash_generated_method = "5264BDA2A4BD83D4194EB4412463954C")
    @DSModeled(DSC.SAFE)
    protected void onRadioAvailable() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.595 -0400", hash_original_method = "D7EE75A618128C9318B9442F75114245", hash_generated_method = "68F5FDDC7050CC9BDCB38E211A91DAE1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.595 -0400", hash_original_method = "5CCABDB2C29BD5F7AE98CB3F70B855A8", hash_generated_method = "4D4ECEC1CB9640F6E30D32A1734E2D9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getLteOnCdmaMode() {
        int var338D796EC42E4804395F013DC2CD8CD5_238644025 = (getLteOnCdmaModeStatic());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getLteOnCdmaModeStatic();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.595 -0400", hash_original_method = "117B0F65A4F71D7CB8099C9B5AF007F4", hash_generated_method = "CB8FACC6544B771BBF4B08A2CBD9D377")
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

    
}


