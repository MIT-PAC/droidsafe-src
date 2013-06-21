package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private boolean mWantContinuousLocationUpdates;
    private boolean mWantSingleLocationUpdate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.420 -0400", hash_original_method = "9FCBDF2ED872770289A466CFAFBF2272", hash_generated_method = "EC17C25E196F47AE6D11EE4EF45CB92F")
    @DSModeled(DSC.SAFE)
    public ServiceStateTracker() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.420 -0400", hash_original_method = "34F755352C02DF9FD9E8CDE125547BA1", hash_generated_method = "DED302936AE341FD91837D62F72D4EA2")
    @DSModeled(DSC.SAFE)
    public boolean getDesiredPowerState() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDesiredPowerState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.421 -0400", hash_original_method = "37CB7B52ED49DF56B69CEDC0A8B6FEA7", hash_generated_method = "218C0DAC64A802F84550DFBC9A5CDB44")
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
            boolean var6B533A2F88E9E352757F2AD33C409A0E_1220068785 = (ss.getRoaming());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.421 -0400", hash_original_method = "14E5206D7B7C852E20FD1241EAC246C6", hash_generated_method = "1B3001F5CDC41C9EC3F79BF2EC8DB459")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForRoamingOn(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mRoamingOnRegistrants.remove(h);
        // ---------- Original Method ----------
        //mRoamingOnRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.421 -0400", hash_original_method = "13A5A77104C9ACCD9C28F87D910D95FA", hash_generated_method = "8E43F76651BC46969C397071B23D754B")
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
            boolean var19F81E00C9957D9B9E336DB1ADF15A6A_1844324121 = (!ss.getRoaming());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.421 -0400", hash_original_method = "D1DD4EA819F10675CB2C3CAADBABF939", hash_generated_method = "46D26F06722F7B01C153CD968ED570C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForRoamingOff(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mRoamingOffRegistrants.remove(h);
        // ---------- Original Method ----------
        //mRoamingOffRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.421 -0400", hash_original_method = "7FC24E85162575F4AD0EC1D2B7D4DA9A", hash_generated_method = "2205C5D0D2BC5C4E99E068104CFEF00A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reRegisterNetwork(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        cm.getPreferredNetworkType(
                obtainMessage(EVENT_GET_PREFERRED_NETWORK_TYPE, onComplete));
        // ---------- Original Method ----------
        //cm.getPreferredNetworkType(
                //obtainMessage(EVENT_GET_PREFERRED_NETWORK_TYPE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.421 -0400", hash_original_method = "58B5CA04F87B88A9C6B403E745D26733", hash_generated_method = "403579A68C28458A793FDD25FC1BACE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRadioPower(boolean power) {
        dsTaint.addTaint(power);
        setPowerStateToDesired();
        // ---------- Original Method ----------
        //mDesiredPowerState = power;
        //setPowerStateToDesired();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.422 -0400", hash_original_method = "7C68C47F455301AB5237FB081DD87707", hash_generated_method = "EE5088C444C475D5E949D87B5C4756D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enableSingleLocationUpdate() {
        mWantSingleLocationUpdate = true;
        cm.setLocationUpdates(true, obtainMessage(EVENT_LOCATION_UPDATES_ENABLED));
        // ---------- Original Method ----------
        //if (mWantSingleLocationUpdate || mWantContinuousLocationUpdates) return;
        //mWantSingleLocationUpdate = true;
        //cm.setLocationUpdates(true, obtainMessage(EVENT_LOCATION_UPDATES_ENABLED));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.422 -0400", hash_original_method = "5E0DE008FDA53D6E066E09E5FF8905A8", hash_generated_method = "03AF5F0E497F7B20D8197459C34369B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enableLocationUpdates() {
        mWantContinuousLocationUpdates = true;
        cm.setLocationUpdates(true, obtainMessage(EVENT_LOCATION_UPDATES_ENABLED));
        // ---------- Original Method ----------
        //if (mWantSingleLocationUpdate || mWantContinuousLocationUpdates) return;
        //mWantContinuousLocationUpdates = true;
        //cm.setLocationUpdates(true, obtainMessage(EVENT_LOCATION_UPDATES_ENABLED));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.422 -0400", hash_original_method = "F0181FD0DF80A6AAF51E269E67B33EC8", hash_generated_method = "AE19223D8747C69C8DA37A2452628D75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void disableSingleLocationUpdate() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.422 -0400", hash_original_method = "70DFFFF4880D84ACE04FFF62B87B40F7", hash_generated_method = "2B9EEED76CEF199D302CF09FEF708D21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void disableLocationUpdates() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.423 -0400", hash_original_method = "85B887C2BDF2CF10C0119B00ACC95929", hash_generated_method = "86B2A4EA346468F6B35552280256C5B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.424 -0400", hash_original_method = "1B39DC11812BAED5F6DBE7D3309539B9", hash_generated_method = "2AB469B692176A309E0E85E61117EAAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForDataConnectionAttached(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant(h, what, obj);
        mAttachedRegistrants.add(r);
        {
            boolean var916199C9AC52A481129DA297D39E2DE2_558853273 = (getCurrentDataConnectionState() == ServiceState.STATE_IN_SERVICE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.424 -0400", hash_original_method = "522E6F692E8A34CBC0692BA5B00B104A", hash_generated_method = "F164AB25ED2A694128AD734EA50F2A5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForDataConnectionAttached(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mAttachedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mAttachedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.424 -0400", hash_original_method = "77B8D4D5781330742D00786669C25585", hash_generated_method = "6EDC5B03AA6AC154F5E7E340B9C6E0D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForDataConnectionDetached(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant(h, what, obj);
        mDetachedRegistrants.add(r);
        {
            boolean varB071BB11532F4DC1D052EC4F3C54F2CC_245891130 = (getCurrentDataConnectionState() != ServiceState.STATE_IN_SERVICE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.424 -0400", hash_original_method = "EDB8FFB895F180442CD81D10E9DCB320", hash_generated_method = "3EE7BE8EB8D23A65A599D390CA9B2AF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForDataConnectionDetached(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mDetachedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mDetachedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.424 -0400", hash_original_method = "076CF7EAC62798919AFD2DB28A5B16ED", hash_generated_method = "D973D05BB15EDC79D6367B41631E6628")
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
            boolean var90E428A9AC79F870ED42DBCBC7F55DFE_265013909 = (ss.getState() == ServiceState.STATE_IN_SERVICE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.425 -0400", hash_original_method = "724BCD9A17C4DC5B22474701A65D5E92", hash_generated_method = "CD6A549E1C3E5BC7BA194E4C7CC8093F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForNetworkAttached(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mNetworkAttachedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mNetworkAttachedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.425 -0400", hash_original_method = "32627558F162EE4DAA643B6ABADEA2AE", hash_generated_method = "DF5EDECFAC0CB646F13B1DAFD13B931E")
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
            boolean varEBAAA70B69E09997F2347E79FB42F56D_303825929 = (mRestrictedState.isPsRestricted());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.425 -0400", hash_original_method = "9066DA15695A4B8D83C2DCD56A112C2B", hash_generated_method = "140C54AFB0CA625A070EFE9FA9C578C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForPsRestrictedEnabled(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mPsRestrictEnabledRegistrants.remove(h);
        // ---------- Original Method ----------
        //mPsRestrictEnabledRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.425 -0400", hash_original_method = "80FC2224C82FF97B7F6C95DA27C6509B", hash_generated_method = "E47CF9909A3D270EFC7782F5414E6DCC")
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
            boolean varEBAAA70B69E09997F2347E79FB42F56D_488800012 = (mRestrictedState.isPsRestricted());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.425 -0400", hash_original_method = "3E796B0EF9A5478F633347EEDEC69A91", hash_generated_method = "89F314D3C17F3E66C83D0D858AD2952A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForPsRestrictedDisabled(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mPsRestrictDisabledRegistrants.remove(h);
        // ---------- Original Method ----------
        //mPsRestrictDisabledRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.426 -0400", hash_original_method = "4017CCA25B6B957B00970913316AB84B", hash_generated_method = "474413788041769452649BFDBE4B04E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void powerOffRadioSafely(DataConnectionTracker dcTracker) {
        dsTaint.addTaint(dcTracker.dsTaint);
        {
            {
                {
                    boolean var99A479C28B03EC3D42BC3A0E80AA9F99_1440194688 = (dcTracker.isDisconnected());
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
                            boolean varD2C2C41FD51EAA93475820526F295E88_649233361 = (sendMessageDelayed(msg, 30000));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.426 -0400", hash_original_method = "67059C8AF83909E1964C0331470598CC", hash_generated_method = "C76747A0A09224C08AC51A45DDFDD996")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.426 -0400", hash_original_method = "CCBC34A7562606F2023BFC5649B6E19A", hash_generated_method = "F6D15879E1DF2FFC771820A47AF4ACD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void cancelPollState() {
        pollingContext = new int[1];
        // ---------- Original Method ----------
        //pollingContext = new int[1];
    }

    
    static public final int OTASP_UNINITIALIZED = 0;
    static public final int OTASP_UNKNOWN = 1;
    static public final int OTASP_NEEDED = 2;
    static public final int OTASP_NOT_NEEDED = 3;
    protected static final boolean DBG = true;
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
}

