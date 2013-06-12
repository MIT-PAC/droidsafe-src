package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.Registrant;
import android.os.RegistrantList;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;

public abstract class ServiceStateTracker extends Handler {
    protected CommandsInterface cm;
    public ServiceState ss;
    protected ServiceState newSS;
    public SignalStrength mSignalStrength;
    public RestrictedState mRestrictedState = new RestrictedState();
    static public final int OTASP_UNINITIALIZED = 0;
    static public final int OTASP_UNKNOWN = 1;
    static public final int OTASP_NEEDED = 2;
    static public final int OTASP_NOT_NEEDED = 3;
    protected int[] pollingContext;
    protected boolean mDesiredPowerState;
    protected int mRadioTechnology = 0;
    protected int mNewRadioTechnology = 0;
    protected boolean dontPollSignalStrength = false;
    protected RegistrantList mRoamingOnRegistrants = new RegistrantList();
    protected RegistrantList mRoamingOffRegistrants = new RegistrantList();
    protected RegistrantList mAttachedRegistrants = new RegistrantList();
    protected RegistrantList mDetachedRegistrants = new RegistrantList();
    protected RegistrantList mNetworkAttachedRegistrants = new RegistrantList();
    protected RegistrantList mPsRestrictEnabledRegistrants = new RegistrantList();
    protected RegistrantList mPsRestrictDisabledRegistrants = new RegistrantList();
    private boolean mPendingRadioPowerOffAfterDataOff = false;
    private int mPendingRadioPowerOffAfterDataOffTag = 0;
    protected  static final boolean DBG = true;
    protected static final int POLL_PERIOD_MILLIS = 20 * 1000;
    public static final int DEFAULT_GPRS_CHECK_PERIOD_MILLIS = 60 * 1000;
    protected static final int EVENT_RADIO_STATE_CHANGED               = 1;
    protected static final int EVENT_NETWORK_STATE_CHANGED             = 2;
    protected static final int EVENT_GET_SIGNAL_STRENGTH               = 3;
    protected static final int EVENT_POLL_STATE_REGISTRATION           = 4;
    protected static final int EVENT_POLL_STATE_GPRS                   = 5;
    protected static final int EVENT_POLL_STATE_OPERATOR               = 6;
    protected static final int EVENT_POLL_SIGNAL_STRENGTH              = 10;
    protected static final int EVENT_NITZ_TIME                         = 11;
    protected static final int EVENT_SIGNAL_STRENGTH_UPDATE            = 12;
    protected static final int EVENT_RADIO_AVAILABLE                   = 13;
    protected static final int EVENT_POLL_STATE_NETWORK_SELECTION_MODE = 14;
    protected static final int EVENT_GET_LOC_DONE                      = 15;
    protected static final int EVENT_SIM_RECORDS_LOADED                = 16;
    protected static final int EVENT_SIM_READY                         = 17;
    protected static final int EVENT_LOCATION_UPDATES_ENABLED          = 18;
    protected static final int EVENT_GET_PREFERRED_NETWORK_TYPE        = 19;
    protected static final int EVENT_SET_PREFERRED_NETWORK_TYPE        = 20;
    protected static final int EVENT_RESET_PREFERRED_NETWORK_TYPE      = 21;
    protected static final int EVENT_CHECK_REPORT_GPRS                 = 22;
    protected static final int EVENT_RESTRICTED_STATE_CHANGED          = 23;
    protected static final int EVENT_POLL_STATE_REGISTRATION_CDMA      = 24;
    protected static final int EVENT_POLL_STATE_OPERATOR_CDMA          = 25;
    protected static final int EVENT_RUIM_READY                        = 26;
    protected static final int EVENT_RUIM_RECORDS_LOADED               = 27;
    protected static final int EVENT_POLL_SIGNAL_STRENGTH_CDMA         = 28;
    protected static final int EVENT_GET_SIGNAL_STRENGTH_CDMA          = 29;
    protected static final int EVENT_NETWORK_STATE_CHANGED_CDMA        = 30;
    protected static final int EVENT_GET_LOC_DONE_CDMA                 = 31;
    protected static final int EVENT_SIGNAL_STRENGTH_UPDATE_CDMA       = 32;
    protected static final int EVENT_NV_LOADED                         = 33;
    protected static final int EVENT_POLL_STATE_CDMA_SUBSCRIPTION      = 34;
    protected static final int EVENT_NV_READY                          = 35;
    protected static final int EVENT_ERI_FILE_LOADED                   = 36;
    protected static final int EVENT_OTA_PROVISION_STATUS_CHANGE       = 37;
    protected static final int EVENT_SET_RADIO_POWER_OFF               = 38;
    protected static final String TIMEZONE_PROPERTY = "persist.sys.timezone";
    protected static final String[] GMT_COUNTRY_CODES = {
        "bf", 
        "ci", 
        "eh", 
        "fo", 
        "gh", 
        "gm", 
        "gn", 
        "gw", 
        "ie", 
        "lr", 
        "is", 
        "ma", 
        "ml", 
        "mr", 
        "pt", 
        "sl", 
        "sn", 
        "st", 
        "tg", 
        "uk", 
    };
    protected static final String REGISTRATION_DENIED_GEN  = "General";
    protected static final String REGISTRATION_DENIED_AUTH = "Authentication Failure";
    private boolean mWantContinuousLocationUpdates;
    private boolean mWantSingleLocationUpdate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.412 -0400", hash_original_method = "9FCBDF2ED872770289A466CFAFBF2272", hash_generated_method = "28CFCE853CC3B4B0BF02806A2261DA06")
    @DSModeled(DSC.SAFE)
    public ServiceStateTracker() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.412 -0400", hash_original_method = "34F755352C02DF9FD9E8CDE125547BA1", hash_generated_method = "F894F9435A87C5914153C34A172C697F")
    @DSModeled(DSC.SAFE)
    public boolean getDesiredPowerState() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDesiredPowerState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.412 -0400", hash_original_method = "37CB7B52ED49DF56B69CEDC0A8B6FEA7", hash_generated_method = "4299D6AC7A9CBBE00E0605EA72E4D83A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForRoamingOn(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant(h, what, obj);
        mRoamingOnRegistrants.add(r);
        {
            boolean var6B533A2F88E9E352757F2AD33C409A0E_1571828727 = (ss.getRoaming());
            {
                r.notifyRegistrant();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mRoamingOnRegistrants.add(r);
        //if (ss.getRoaming()) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.412 -0400", hash_original_method = "14E5206D7B7C852E20FD1241EAC246C6", hash_generated_method = "C0E14EC1CD201DEE201972DA50235BB3")
    @DSModeled(DSC.SAFE)
    public void unregisterForRoamingOn(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mRoamingOnRegistrants.remove(h);
        // ---------- Original Method ----------
        //mRoamingOnRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.412 -0400", hash_original_method = "13A5A77104C9ACCD9C28F87D910D95FA", hash_generated_method = "5AC786C5510D939427684D5BF3F68EFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForRoamingOff(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant(h, what, obj);
        mRoamingOffRegistrants.add(r);
        {
            boolean var19F81E00C9957D9B9E336DB1ADF15A6A_1552819763 = (!ss.getRoaming());
            {
                r.notifyRegistrant();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mRoamingOffRegistrants.add(r);
        //if (!ss.getRoaming()) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.412 -0400", hash_original_method = "D1DD4EA819F10675CB2C3CAADBABF939", hash_generated_method = "DDBE46A5ECBAAC313EFF53F279264CC6")
    @DSModeled(DSC.SAFE)
    public void unregisterForRoamingOff(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mRoamingOffRegistrants.remove(h);
        // ---------- Original Method ----------
        //mRoamingOffRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.412 -0400", hash_original_method = "7FC24E85162575F4AD0EC1D2B7D4DA9A", hash_generated_method = "1CBF8A4874CAC820A16CD73172578D69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reRegisterNetwork(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        cm.getPreferredNetworkType(
                obtainMessage(EVENT_GET_PREFERRED_NETWORK_TYPE, onComplete));
        // ---------- Original Method ----------
        //cm.getPreferredNetworkType(
                //obtainMessage(EVENT_GET_PREFERRED_NETWORK_TYPE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.412 -0400", hash_original_method = "58B5CA04F87B88A9C6B403E745D26733", hash_generated_method = "84927752E44E484A5DC0A308C731AA04")
    @DSModeled(DSC.SAFE)
    public void setRadioPower(boolean power) {
        dsTaint.addTaint(power);
        setPowerStateToDesired();
        // ---------- Original Method ----------
        //mDesiredPowerState = power;
        //setPowerStateToDesired();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.412 -0400", hash_original_method = "7C68C47F455301AB5237FB081DD87707", hash_generated_method = "040DBCC5B0544F147D9890AEC0FD26D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enableSingleLocationUpdate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mWantSingleLocationUpdate = true;
        cm.setLocationUpdates(true, obtainMessage(EVENT_LOCATION_UPDATES_ENABLED));
        // ---------- Original Method ----------
        //if (mWantSingleLocationUpdate || mWantContinuousLocationUpdates) return;
        //mWantSingleLocationUpdate = true;
        //cm.setLocationUpdates(true, obtainMessage(EVENT_LOCATION_UPDATES_ENABLED));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.412 -0400", hash_original_method = "5E0DE008FDA53D6E066E09E5FF8905A8", hash_generated_method = "1603E1212124B886FD3FBA1AF919F01C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enableLocationUpdates() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mWantContinuousLocationUpdates = true;
        cm.setLocationUpdates(true, obtainMessage(EVENT_LOCATION_UPDATES_ENABLED));
        // ---------- Original Method ----------
        //if (mWantSingleLocationUpdate || mWantContinuousLocationUpdates) return;
        //mWantContinuousLocationUpdates = true;
        //cm.setLocationUpdates(true, obtainMessage(EVENT_LOCATION_UPDATES_ENABLED));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.412 -0400", hash_original_method = "F0181FD0DF80A6AAF51E269E67B33EC8", hash_generated_method = "07CF4B24698D1374665CC266F9BFD1C9")
    @DSModeled(DSC.SAFE)
    protected void disableSingleLocationUpdate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mWantSingleLocationUpdate = false;
        {
            cm.setLocationUpdates(false, null);
        } //End block
        // ---------- Original Method ----------
        //mWantSingleLocationUpdate = false;
        //if (!mWantSingleLocationUpdate && !mWantContinuousLocationUpdates) {
            //cm.setLocationUpdates(false, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.412 -0400", hash_original_method = "70DFFFF4880D84ACE04FFF62B87B40F7", hash_generated_method = "F79E12637D4128AA39B858021B8D5C43")
    @DSModeled(DSC.SAFE)
    public void disableLocationUpdates() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mWantContinuousLocationUpdates = false;
        {
            cm.setLocationUpdates(false, null);
        } //End block
        // ---------- Original Method ----------
        //mWantContinuousLocationUpdates = false;
        //if (!mWantSingleLocationUpdate && !mWantContinuousLocationUpdates) {
            //cm.setLocationUpdates(false, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.413 -0400", hash_original_method = "85B887C2BDF2CF10C0119B00ACC95929", hash_generated_method = "9991CFD884782565B3BAB7A28FF22B11")
    @DSModeled(DSC.SAFE)
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        //Begin case EVENT_SET_RADIO_POWER_OFF 
        {
            {
                log("EVENT_SET_RADIO_OFF, turn radio off now.");
                hangupAndPowerOff();
                mPendingRadioPowerOffAfterDataOffTag += 1;
                mPendingRadioPowerOffAfterDataOff = false;
            } //End block
            {
                log("EVENT_SET_RADIO_OFF is stale arg1=" + msg.arg1 +
                                "!= tag=" + mPendingRadioPowerOffAfterDataOffTag);
            } //End block
        } //End block
        //End case EVENT_SET_RADIO_POWER_OFF 
        //Begin case default 
        log("Unhandled message with number: " + msg.what);
        //End case default 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected abstract Phone getPhone();

    
    protected abstract void handlePollStateResult(int what, AsyncResult ar);

    
    protected abstract void updateSpnDisplay();

    
    protected abstract void setPowerStateToDesired();

    
    protected abstract void log(String s);

    
    protected abstract void loge(String s);

    
    public abstract int getCurrentDataConnectionState();

    
    public abstract boolean isConcurrentVoiceAndDataAllowed();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.413 -0400", hash_original_method = "1B39DC11812BAED5F6DBE7D3309539B9", hash_generated_method = "D1976FCE3A031D159ABBDBF852E73408")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForDataConnectionAttached(Handler h, int what, Object obj) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant(h, what, obj);
        mAttachedRegistrants.add(r);
        {
            boolean var916199C9AC52A481129DA297D39E2DE2_1048769073 = (getCurrentDataConnectionState() == ServiceState.STATE_IN_SERVICE);
            {
                r.notifyRegistrant();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mAttachedRegistrants.add(r);
        //if (getCurrentDataConnectionState() == ServiceState.STATE_IN_SERVICE) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.413 -0400", hash_original_method = "522E6F692E8A34CBC0692BA5B00B104A", hash_generated_method = "8255F2B02564062B2503B9A97F2035F6")
    @DSModeled(DSC.SAFE)
    public void unregisterForDataConnectionAttached(Handler h) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mAttachedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mAttachedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.413 -0400", hash_original_method = "77B8D4D5781330742D00786669C25585", hash_generated_method = "6D07C21385335F38E3D503A2B1D26ED1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForDataConnectionDetached(Handler h, int what, Object obj) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant(h, what, obj);
        mDetachedRegistrants.add(r);
        {
            boolean varB071BB11532F4DC1D052EC4F3C54F2CC_1214177844 = (getCurrentDataConnectionState() != ServiceState.STATE_IN_SERVICE);
            {
                r.notifyRegistrant();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mDetachedRegistrants.add(r);
        //if (getCurrentDataConnectionState() != ServiceState.STATE_IN_SERVICE) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.413 -0400", hash_original_method = "EDB8FFB895F180442CD81D10E9DCB320", hash_generated_method = "0AC4E96D31F5F734EFC1ADF8A838FCAC")
    @DSModeled(DSC.SAFE)
    public void unregisterForDataConnectionDetached(Handler h) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mDetachedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mDetachedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.413 -0400", hash_original_method = "076CF7EAC62798919AFD2DB28A5B16ED", hash_generated_method = "7DFED021FF227D1ACDC01ACEABB10ADF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForNetworkAttached(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant(h, what, obj);
        mNetworkAttachedRegistrants.add(r);
        {
            boolean var90E428A9AC79F870ED42DBCBC7F55DFE_377928070 = (ss.getState() == ServiceState.STATE_IN_SERVICE);
            {
                r.notifyRegistrant();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mNetworkAttachedRegistrants.add(r);
        //if (ss.getState() == ServiceState.STATE_IN_SERVICE) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.413 -0400", hash_original_method = "724BCD9A17C4DC5B22474701A65D5E92", hash_generated_method = "4521D3C8D44F180D7A7AAA8A247A1352")
    @DSModeled(DSC.SAFE)
    public void unregisterForNetworkAttached(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mNetworkAttachedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mNetworkAttachedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.413 -0400", hash_original_method = "32627558F162EE4DAA643B6ABADEA2AE", hash_generated_method = "ED048772F96C27BD66B6538FFCB44E6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForPsRestrictedEnabled(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant(h, what, obj);
        mPsRestrictEnabledRegistrants.add(r);
        {
            boolean varEBAAA70B69E09997F2347E79FB42F56D_496983391 = (mRestrictedState.isPsRestricted());
            {
                r.notifyRegistrant();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mPsRestrictEnabledRegistrants.add(r);
        //if (mRestrictedState.isPsRestricted()) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.413 -0400", hash_original_method = "9066DA15695A4B8D83C2DCD56A112C2B", hash_generated_method = "F9169A6272C65F67C7EB061B4D64DA81")
    @DSModeled(DSC.SAFE)
    public void unregisterForPsRestrictedEnabled(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mPsRestrictEnabledRegistrants.remove(h);
        // ---------- Original Method ----------
        //mPsRestrictEnabledRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.413 -0400", hash_original_method = "80FC2224C82FF97B7F6C95DA27C6509B", hash_generated_method = "D922D134CE511DDA6C4ADEED75EA5C5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForPsRestrictedDisabled(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant(h, what, obj);
        mPsRestrictDisabledRegistrants.add(r);
        {
            boolean varEBAAA70B69E09997F2347E79FB42F56D_632255629 = (mRestrictedState.isPsRestricted());
            {
                r.notifyRegistrant();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mPsRestrictDisabledRegistrants.add(r);
        //if (mRestrictedState.isPsRestricted()) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.413 -0400", hash_original_method = "3E796B0EF9A5478F633347EEDEC69A91", hash_generated_method = "15DBBE2E96ECF72DC6C934EA2BB7A1F3")
    @DSModeled(DSC.SAFE)
    public void unregisterForPsRestrictedDisabled(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mPsRestrictDisabledRegistrants.remove(h);
        // ---------- Original Method ----------
        //mPsRestrictDisabledRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.414 -0400", hash_original_method = "4017CCA25B6B957B00970913316AB84B", hash_generated_method = "F0AD1F93F96070AC7291BFA730FD5343")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void powerOffRadioSafely(DataConnectionTracker dcTracker) {
        dsTaint.addTaint(dcTracker.dsTaint);
        {
            {
                {
                    boolean var99A479C28B03EC3D42BC3A0E80AA9F99_1564546731 = (dcTracker.isDisconnected());
                    {
                        dcTracker.cleanUpAllConnections(Phone.REASON_RADIO_TURNED_OFF);
                        log("Data disconnected, turn off radio right away.");
                        hangupAndPowerOff();
                    } //End block
                    {
                        dcTracker.cleanUpAllConnections(Phone.REASON_RADIO_TURNED_OFF);
                        Message msg;
                        msg = Message.obtain(this);
                        msg.what = EVENT_SET_RADIO_POWER_OFF;
                        msg.arg1 = ++mPendingRadioPowerOffAfterDataOffTag;
                        {
                            boolean varD2C2C41FD51EAA93475820526F295E88_1257160175 = (sendMessageDelayed(msg, 30000));
                            {
                                log("Wait upto 30s for data to disconnect, then turn off radio.");
                                mPendingRadioPowerOffAfterDataOff = true;
                            } //End block
                            {
                                log("Cannot send delayed Msg, turn off radio right away.");
                                hangupAndPowerOff();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.414 -0400", hash_original_method = "67059C8AF83909E1964C0331470598CC", hash_generated_method = "8A242E0D90C9D1B217ADAE95CF339C52")
    @DSModeled(DSC.SAFE)
    public boolean processPendingRadioPowerOffAfterDataOff() {
        {
            {
                log("Process pending request to turn radio off.");
                mPendingRadioPowerOffAfterDataOffTag += 1;
                hangupAndPowerOff();
                mPendingRadioPowerOffAfterDataOff = false;
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized(this) {
            //if (mPendingRadioPowerOffAfterDataOff) {
                //if (DBG) log("Process pending request to turn radio off.");
                //mPendingRadioPowerOffAfterDataOffTag += 1;
                //hangupAndPowerOff();
                //mPendingRadioPowerOffAfterDataOff = false;
                //return true;
            //}
            //return false;
        //}
    }

    
    protected abstract void hangupAndPowerOff();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.414 -0400", hash_original_method = "CCBC34A7562606F2023BFC5649B6E19A", hash_generated_method = "A711342147F9C1C083600AA065B1CF91")
    @DSModeled(DSC.SAFE)
    protected void cancelPollState() {
        pollingContext = new int[1];
        // ---------- Original Method ----------
        //pollingContext = new int[1];
    }

    
}


