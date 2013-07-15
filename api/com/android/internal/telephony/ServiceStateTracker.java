package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.Registrant;
import android.os.RegistrantList;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;

public abstract class ServiceStateTracker extends Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.372 -0400", hash_original_field = "820EB5B696EA2A657C0DB1E258DC7D81", hash_generated_field = "EDF057DBE0A02042DBF83073757034E9")

    protected CommandsInterface cm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.372 -0400", hash_original_field = "3691308F2A4C2F6983F2880D32E29C84", hash_generated_field = "D607C471A1606B559A4F0C28A47BFD3A")

    public ServiceState ss;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.372 -0400", hash_original_field = "93999A138D8028B1B9E67CC0A3354563", hash_generated_field = "37638718D876F5421AD103383236AD22")

    protected ServiceState newSS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.372 -0400", hash_original_field = "E2C92BDB5B4E8A7DEDB542A89E12D094", hash_generated_field = "6D9902C068708E16DB7D3B6602B19CEF")

    public SignalStrength mSignalStrength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.372 -0400", hash_original_field = "89FC8327CE692B536819A20EE7A690EC", hash_generated_field = "F7D70BE82B631DDA8C3B56EF51FC91C4")

    public RestrictedState mRestrictedState = new RestrictedState();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.372 -0400", hash_original_field = "BB0063501B8846C194E64D27D44252B0", hash_generated_field = "971B063549A1138EC166910CD0B92E16")

    protected int[] pollingContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.372 -0400", hash_original_field = "C89D1AF0AEE8D0A2CF4FED65DAD30DE6", hash_generated_field = "6E0D0EEFBE55BC60F19FC7A47D2CF7A7")

    protected boolean mDesiredPowerState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.372 -0400", hash_original_field = "46F8921073F465F4E6A53F53FB3CC508", hash_generated_field = "0A6EAD8C7AE319D00ACC22C825C0E499")

    protected int mRadioTechnology = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.372 -0400", hash_original_field = "B8E8F5A57D823D60611735C4F5895E48", hash_generated_field = "F7B2E1EBB85BC053B9BECA60685DE78D")

    protected int mNewRadioTechnology = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.372 -0400", hash_original_field = "9FFCE7874852A8B3875A82A05563253C", hash_generated_field = "5F48A53F7B00B7BD0B14FCC83E25F1EC")

    protected boolean dontPollSignalStrength = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.372 -0400", hash_original_field = "94FA3100E083FF09EA8F625390F6DAFC", hash_generated_field = "3AD1304D1BA317277BBEE277F670A472")

    protected RegistrantList mRoamingOnRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.373 -0400", hash_original_field = "0051145150E7AA7F6E89800F1075B480", hash_generated_field = "7819DA14832792F71F719B742BCE9053")

    protected RegistrantList mRoamingOffRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.373 -0400", hash_original_field = "91A48951E79DD388FCC9CB820ADF00AE", hash_generated_field = "43D459080479D457B519BE0CE58EC773")

    protected RegistrantList mAttachedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.373 -0400", hash_original_field = "CDF1AAEFB08F60370633C1B7A33646FF", hash_generated_field = "B91229A5B50E80471AB407D94A8C22E0")

    protected RegistrantList mDetachedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.373 -0400", hash_original_field = "47FB42C6DDFD82D84A2D2B4CA1DEBF5A", hash_generated_field = "EC72819D10D4558220CC871EE1200506")

    protected RegistrantList mNetworkAttachedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.373 -0400", hash_original_field = "47274B22A05638E8C769F02DBC0B12BD", hash_generated_field = "177DDA8A6143F9FC217FCFE37BE4DE91")

    protected RegistrantList mPsRestrictEnabledRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.373 -0400", hash_original_field = "428282B5696411D181BC95503FCB2D51", hash_generated_field = "405B74B0B32B65F041BDD15D3756D948")

    protected RegistrantList mPsRestrictDisabledRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.373 -0400", hash_original_field = "BFB79692D4F405A20EC17E43F82839FB", hash_generated_field = "F73F9BC9D0BE82CE2BBEA28FFA11B4CC")

    private boolean mPendingRadioPowerOffAfterDataOff = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.373 -0400", hash_original_field = "1772E09AA0937CC30147757472377C56", hash_generated_field = "B8B4B877F9363010C47672B0C1475CA5")

    private int mPendingRadioPowerOffAfterDataOffTag = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.373 -0400", hash_original_field = "DBD352CA77B5AD318E43449A32D114AE", hash_generated_field = "AFC29418D745D3A6E97E0A67D746937B")

    private boolean mWantContinuousLocationUpdates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.373 -0400", hash_original_field = "AA41B1B75D4E1A40BD1637DAD5FC4D4A", hash_generated_field = "F3EAD7378CDAA1419A8D11AA1EFE6677")

    private boolean mWantSingleLocationUpdate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.373 -0400", hash_original_method = "9FCBDF2ED872770289A466CFAFBF2272", hash_generated_method = "EC17C25E196F47AE6D11EE4EF45CB92F")
    public  ServiceStateTracker() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.374 -0400", hash_original_method = "34F755352C02DF9FD9E8CDE125547BA1", hash_generated_method = "5F21128ECA585D33E8E9E59C7C15056C")
    public boolean getDesiredPowerState() {
        boolean varC89D1AF0AEE8D0A2CF4FED65DAD30DE6_1369310093 = (mDesiredPowerState);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1159036022 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1159036022;
        // ---------- Original Method ----------
        //return mDesiredPowerState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.374 -0400", hash_original_method = "37CB7B52ED49DF56B69CEDC0A8B6FEA7", hash_generated_method = "ADE4FA416F0EA751327702B4338E232E")
    public void registerForRoamingOn(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        Registrant r = new Registrant(h, what, obj);
        mRoamingOnRegistrants.add(r);
    if(ss.getRoaming())        
        {
            r.notifyRegistrant();
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mRoamingOnRegistrants.add(r);
        //if (ss.getRoaming()) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.375 -0400", hash_original_method = "14E5206D7B7C852E20FD1241EAC246C6", hash_generated_method = "7B0E8ABD8DC07994B7A9E1EE187339C5")
    public void unregisterForRoamingOn(Handler h) {
        addTaint(h.getTaint());
        mRoamingOnRegistrants.remove(h);
        // ---------- Original Method ----------
        //mRoamingOnRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.376 -0400", hash_original_method = "13A5A77104C9ACCD9C28F87D910D95FA", hash_generated_method = "F6BF2CB6A240C1E6A14F701AD82A7B2D")
    public void registerForRoamingOff(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        Registrant r = new Registrant(h, what, obj);
        mRoamingOffRegistrants.add(r);
    if(!ss.getRoaming())        
        {
            r.notifyRegistrant();
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mRoamingOffRegistrants.add(r);
        //if (!ss.getRoaming()) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.376 -0400", hash_original_method = "D1DD4EA819F10675CB2C3CAADBABF939", hash_generated_method = "397CA0B434CB1A23785E285D6904FC55")
    public void unregisterForRoamingOff(Handler h) {
        addTaint(h.getTaint());
        mRoamingOffRegistrants.remove(h);
        // ---------- Original Method ----------
        //mRoamingOffRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.377 -0400", hash_original_method = "7FC24E85162575F4AD0EC1D2B7D4DA9A", hash_generated_method = "A025CD7209F12FD16EE0E0841DA61E18")
    public void reRegisterNetwork(Message onComplete) {
        addTaint(onComplete.getTaint());
        cm.getPreferredNetworkType(
                obtainMessage(EVENT_GET_PREFERRED_NETWORK_TYPE, onComplete));
        // ---------- Original Method ----------
        //cm.getPreferredNetworkType(
                //obtainMessage(EVENT_GET_PREFERRED_NETWORK_TYPE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.377 -0400", hash_original_method = "58B5CA04F87B88A9C6B403E745D26733", hash_generated_method = "92BDBC4BB37F973F511A951B7426B3A8")
    public void setRadioPower(boolean power) {
        mDesiredPowerState = power;
        setPowerStateToDesired();
        // ---------- Original Method ----------
        //mDesiredPowerState = power;
        //setPowerStateToDesired();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.378 -0400", hash_original_method = "7C68C47F455301AB5237FB081DD87707", hash_generated_method = "A64305A3C5AE0A15B7CF187088C81618")
    public void enableSingleLocationUpdate() {
    if(mWantSingleLocationUpdate || mWantContinuousLocationUpdates)        
        return;
        mWantSingleLocationUpdate = true;
        cm.setLocationUpdates(true, obtainMessage(EVENT_LOCATION_UPDATES_ENABLED));
        // ---------- Original Method ----------
        //if (mWantSingleLocationUpdate || mWantContinuousLocationUpdates) return;
        //mWantSingleLocationUpdate = true;
        //cm.setLocationUpdates(true, obtainMessage(EVENT_LOCATION_UPDATES_ENABLED));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.378 -0400", hash_original_method = "5E0DE008FDA53D6E066E09E5FF8905A8", hash_generated_method = "5EFDEA145548F7C6421C58FEF1199223")
    public void enableLocationUpdates() {
    if(mWantSingleLocationUpdate || mWantContinuousLocationUpdates)        
        return;
        mWantContinuousLocationUpdates = true;
        cm.setLocationUpdates(true, obtainMessage(EVENT_LOCATION_UPDATES_ENABLED));
        // ---------- Original Method ----------
        //if (mWantSingleLocationUpdate || mWantContinuousLocationUpdates) return;
        //mWantContinuousLocationUpdates = true;
        //cm.setLocationUpdates(true, obtainMessage(EVENT_LOCATION_UPDATES_ENABLED));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.378 -0400", hash_original_method = "F0181FD0DF80A6AAF51E269E67B33EC8", hash_generated_method = "13587F63A9CDB9E1532CC6B19C05B013")
    protected void disableSingleLocationUpdate() {
        mWantSingleLocationUpdate = false;
    if(!mWantSingleLocationUpdate && !mWantContinuousLocationUpdates)        
        {
            cm.setLocationUpdates(false, null);
        } //End block
        // ---------- Original Method ----------
        //mWantSingleLocationUpdate = false;
        //if (!mWantSingleLocationUpdate && !mWantContinuousLocationUpdates) {
            //cm.setLocationUpdates(false, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.379 -0400", hash_original_method = "70DFFFF4880D84ACE04FFF62B87B40F7", hash_generated_method = "3D7F68D0C9994935E6BCCD955EC76188")
    public void disableLocationUpdates() {
        mWantContinuousLocationUpdates = false;
    if(!mWantSingleLocationUpdate && !mWantContinuousLocationUpdates)        
        {
            cm.setLocationUpdates(false, null);
        } //End block
        // ---------- Original Method ----------
        //mWantContinuousLocationUpdates = false;
        //if (!mWantSingleLocationUpdate && !mWantContinuousLocationUpdates) {
            //cm.setLocationUpdates(false, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.379 -0400", hash_original_method = "85B887C2BDF2CF10C0119B00ACC95929", hash_generated_method = "D9226C69CCF7580B2D9A616F1D5CBC6F")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
switch(msg.what){
        case EVENT_SET_RADIO_POWER_OFF:
        synchronized
(this)        {
    if(mPendingRadioPowerOffAfterDataOff &&
                            (msg.arg1 == mPendingRadioPowerOffAfterDataOffTag))            
            {
    if(DBG)                
                log("EVENT_SET_RADIO_OFF, turn radio off now.");
                hangupAndPowerOff();
                mPendingRadioPowerOffAfterDataOffTag += 1;
                mPendingRadioPowerOffAfterDataOff = false;
            } //End block
            else
            {
                log("EVENT_SET_RADIO_OFF is stale arg1=" + msg.arg1 +
                                "!= tag=" + mPendingRadioPowerOffAfterDataOffTag);
            } //End block
        } //End block
        break;
        default:
        log("Unhandled message with number: " + msg.what);
        break;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.381 -0400", hash_original_method = "1B39DC11812BAED5F6DBE7D3309539B9", hash_generated_method = "C14A1F409C724F127F50A916261E12D8")
    public void registerForDataConnectionAttached(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        Registrant r = new Registrant(h, what, obj);
        mAttachedRegistrants.add(r);
    if(getCurrentDataConnectionState() == ServiceState.STATE_IN_SERVICE)        
        {
            r.notifyRegistrant();
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mAttachedRegistrants.add(r);
        //if (getCurrentDataConnectionState() == ServiceState.STATE_IN_SERVICE) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.381 -0400", hash_original_method = "522E6F692E8A34CBC0692BA5B00B104A", hash_generated_method = "0228F11F54DF21E5EAE442F3DFB7E637")
    public void unregisterForDataConnectionAttached(Handler h) {
        addTaint(h.getTaint());
        mAttachedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mAttachedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.381 -0400", hash_original_method = "77B8D4D5781330742D00786669C25585", hash_generated_method = "6272E6A8D8CA37566CC3134340416198")
    public void registerForDataConnectionDetached(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        Registrant r = new Registrant(h, what, obj);
        mDetachedRegistrants.add(r);
    if(getCurrentDataConnectionState() != ServiceState.STATE_IN_SERVICE)        
        {
            r.notifyRegistrant();
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mDetachedRegistrants.add(r);
        //if (getCurrentDataConnectionState() != ServiceState.STATE_IN_SERVICE) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.382 -0400", hash_original_method = "EDB8FFB895F180442CD81D10E9DCB320", hash_generated_method = "339DDA0B6A0646C1EC551F1E5E32A252")
    public void unregisterForDataConnectionDetached(Handler h) {
        addTaint(h.getTaint());
        mDetachedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mDetachedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.382 -0400", hash_original_method = "076CF7EAC62798919AFD2DB28A5B16ED", hash_generated_method = "1ED6C802DED30FA20EEA0E4E5C06A9C9")
    public void registerForNetworkAttached(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        Registrant r = new Registrant(h, what, obj);
        mNetworkAttachedRegistrants.add(r);
    if(ss.getState() == ServiceState.STATE_IN_SERVICE)        
        {
            r.notifyRegistrant();
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mNetworkAttachedRegistrants.add(r);
        //if (ss.getState() == ServiceState.STATE_IN_SERVICE) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.382 -0400", hash_original_method = "724BCD9A17C4DC5B22474701A65D5E92", hash_generated_method = "D99859EEA20F834B51D579FE8C1E10C2")
    public void unregisterForNetworkAttached(Handler h) {
        addTaint(h.getTaint());
        mNetworkAttachedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mNetworkAttachedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.383 -0400", hash_original_method = "32627558F162EE4DAA643B6ABADEA2AE", hash_generated_method = "B428C745ED18AC6B285C69485F0337B9")
    public void registerForPsRestrictedEnabled(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        Registrant r = new Registrant(h, what, obj);
        mPsRestrictEnabledRegistrants.add(r);
    if(mRestrictedState.isPsRestricted())        
        {
            r.notifyRegistrant();
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mPsRestrictEnabledRegistrants.add(r);
        //if (mRestrictedState.isPsRestricted()) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.383 -0400", hash_original_method = "9066DA15695A4B8D83C2DCD56A112C2B", hash_generated_method = "BDEE252955A662FCAAFCAEF3308662EC")
    public void unregisterForPsRestrictedEnabled(Handler h) {
        addTaint(h.getTaint());
        mPsRestrictEnabledRegistrants.remove(h);
        // ---------- Original Method ----------
        //mPsRestrictEnabledRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.383 -0400", hash_original_method = "80FC2224C82FF97B7F6C95DA27C6509B", hash_generated_method = "F4E4BF88E6F7056F80653A9AF3F1E4DF")
    public void registerForPsRestrictedDisabled(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        Registrant r = new Registrant(h, what, obj);
        mPsRestrictDisabledRegistrants.add(r);
    if(mRestrictedState.isPsRestricted())        
        {
            r.notifyRegistrant();
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mPsRestrictDisabledRegistrants.add(r);
        //if (mRestrictedState.isPsRestricted()) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.384 -0400", hash_original_method = "3E796B0EF9A5478F633347EEDEC69A91", hash_generated_method = "0E77F3FE97D43173ED8E4F975A49C3F9")
    public void unregisterForPsRestrictedDisabled(Handler h) {
        addTaint(h.getTaint());
        mPsRestrictDisabledRegistrants.remove(h);
        // ---------- Original Method ----------
        //mPsRestrictDisabledRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.385 -0400", hash_original_method = "4017CCA25B6B957B00970913316AB84B", hash_generated_method = "5A0431E11F22D66A5C1D231C170E7A34")
    public void powerOffRadioSafely(DataConnectionTracker dcTracker) {
        addTaint(dcTracker.getTaint());
        synchronized
(this)        {
    if(!mPendingRadioPowerOffAfterDataOff)            
            {
    if(dcTracker.isDisconnected())                
                {
                    dcTracker.cleanUpAllConnections(Phone.REASON_RADIO_TURNED_OFF);
    if(DBG)                    
                    log("Data disconnected, turn off radio right away.");
                    hangupAndPowerOff();
                } //End block
                else
                {
                    dcTracker.cleanUpAllConnections(Phone.REASON_RADIO_TURNED_OFF);
                    Message msg = Message.obtain(this);
                    msg.what = EVENT_SET_RADIO_POWER_OFF;
                    msg.arg1 = ++mPendingRadioPowerOffAfterDataOffTag;
    if(sendMessageDelayed(msg, 30000))                    
                    {
    if(DBG)                        
                        log("Wait upto 30s for data to disconnect, then turn off radio.");
                        mPendingRadioPowerOffAfterDataOff = true;
                    } //End block
                    else
                    {
                        log("Cannot send delayed Msg, turn off radio right away.");
                        hangupAndPowerOff();
                    } //End block
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.385 -0400", hash_original_method = "67059C8AF83909E1964C0331470598CC", hash_generated_method = "E3227FB4AA91ABF44EE1CB591824E9C8")
    public boolean processPendingRadioPowerOffAfterDataOff() {
        synchronized
(this)        {
    if(mPendingRadioPowerOffAfterDataOff)            
            {
    if(DBG)                
                log("Process pending request to turn radio off.");
                mPendingRadioPowerOffAfterDataOffTag += 1;
                hangupAndPowerOff();
                mPendingRadioPowerOffAfterDataOff = false;
                boolean varB326B5062B2F0E69046810717534CB09_1852946815 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_389023553 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_389023553;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1693839676 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_801705426 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_801705426;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.386 -0400", hash_original_method = "CCBC34A7562606F2023BFC5649B6E19A", hash_generated_method = "F6D15879E1DF2FFC771820A47AF4ACD6")
    protected void cancelPollState() {
        pollingContext = new int[1];
        // ---------- Original Method ----------
        //pollingContext = new int[1];
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.386 -0400", hash_original_field = "51CA201FB6DAC9DEAB7E580C7C4599CD", hash_generated_field = "5FE34011A6194BC6286A035D997282EE")

    static public final int OTASP_UNINITIALIZED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.386 -0400", hash_original_field = "8D4E28BFCA39106CB17DE0E87186DD1D", hash_generated_field = "061A5F4CDB2510482DF40014FA069CCD")

    static public final int OTASP_UNKNOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.386 -0400", hash_original_field = "380263A3A57EA3826A4CD8E6E8F37840", hash_generated_field = "6654A3F1BBBF982EA7C9094DDBE96306")

    static public final int OTASP_NEEDED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.386 -0400", hash_original_field = "CD237A46E8E4E4E94E94F43E843D23CC", hash_generated_field = "8614A164E69549BC084DFCFF1DBAF5E0")

    static public final int OTASP_NOT_NEEDED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.386 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "5F5E7D64B04175B8FA820B2440F700FC")

    protected static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.386 -0400", hash_original_field = "6BF55DF2C3DDC179A396035256FD9221", hash_generated_field = "600CA2D504BDCE1FC8FF6ACEDB6B81F2")

    protected static final int POLL_PERIOD_MILLIS = 20 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.386 -0400", hash_original_field = "78DBFEDA4D4BF3B7443050756EB706DA", hash_generated_field = "CAFDA3BCC51A0F86441922B04B913066")

    public static final int DEFAULT_GPRS_CHECK_PERIOD_MILLIS = 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.386 -0400", hash_original_field = "58A49A2EE32C928380ED31C83C5B2EC8", hash_generated_field = "84F69B7023F3359922BD3CC5318F83C8")

    protected static final int EVENT_RADIO_STATE_CHANGED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.386 -0400", hash_original_field = "144ACBA3985CD8981FD3593A6B5D2D1D", hash_generated_field = "A203F2C8F335EED40920E45E27930517")

    protected static final int EVENT_NETWORK_STATE_CHANGED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.386 -0400", hash_original_field = "C1D21D82E85131B6342B2E8C35FFD311", hash_generated_field = "0F5187904AB494740610933B7B24E098")

    protected static final int EVENT_GET_SIGNAL_STRENGTH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.386 -0400", hash_original_field = "5E11D6B3712C373638C7DC07E9117EDC", hash_generated_field = "6DC87F88388E9F34877717BC87290432")

    protected static final int EVENT_POLL_STATE_REGISTRATION = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.386 -0400", hash_original_field = "6D8A478D52EE2A1150B8A9E475A88EAA", hash_generated_field = "CFA1BF7A01F64321D84160EE0DD20193")

    protected static final int EVENT_POLL_STATE_GPRS = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.386 -0400", hash_original_field = "1A7489055DF4012458D860FD4BF5340A", hash_generated_field = "125C9CAF2F3F289BCA2D6EB5BC0CCC27")

    protected static final int EVENT_POLL_STATE_OPERATOR = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.386 -0400", hash_original_field = "234DDA4105A1A5D4DFFFC47B06E66124", hash_generated_field = "7434403186731242CE130CD89185F174")

    protected static final int EVENT_POLL_SIGNAL_STRENGTH = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.386 -0400", hash_original_field = "7B1ECC232C01880E0930A56E3C1ABC68", hash_generated_field = "C6D65E6A3263D9BB61F378BADEB0C31D")

    protected static final int EVENT_NITZ_TIME = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.386 -0400", hash_original_field = "28D66DAF312C36CC60B647D0393EDD7E", hash_generated_field = "BF0DF9DD10925CCA481DD852B565D16D")

    protected static final int EVENT_SIGNAL_STRENGTH_UPDATE = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.386 -0400", hash_original_field = "7B097FA5AA997D42E55523C39AECEEF8", hash_generated_field = "859D0C28ED4D9909418342822317EB13")

    protected static final int EVENT_RADIO_AVAILABLE = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "36CDA17540A5AD5FD9B083A26AAA7471", hash_generated_field = "F0CD5A6BC9F15EC8D4EF87A1E926AA24")

    protected static final int EVENT_POLL_STATE_NETWORK_SELECTION_MODE = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "D0DADBE488E1BA8F45D788BA2DC4AC75", hash_generated_field = "D1B8A022CD444D16ED15A87ACB0D8953")

    protected static final int EVENT_GET_LOC_DONE = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "F68742559028F845BFE7D13EBA5751DD", hash_generated_field = "C8CC37BBD393478378E5DB64A00D9694")

    protected static final int EVENT_SIM_RECORDS_LOADED = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "A1EDB104CFF4FBF30AD3BC27A5F14562", hash_generated_field = "6114AB1E66A6A5EF4B51D860608C43C1")

    protected static final int EVENT_SIM_READY = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "456C2A1D2A5FB1D1C3819626B6EFDCEE", hash_generated_field = "ACA75011B0DF066527FB8285BC14A82E")

    protected static final int EVENT_LOCATION_UPDATES_ENABLED = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "E8A7882DF66AE1E27E12AD3A08D092A1", hash_generated_field = "DA6739779A294821F19D69B1209C859D")

    protected static final int EVENT_GET_PREFERRED_NETWORK_TYPE = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "D9038D73472214352F7569FEE902D600", hash_generated_field = "DBA80FBEBF820852D812B9F21CA6C757")

    protected static final int EVENT_SET_PREFERRED_NETWORK_TYPE = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "EF75756A9124C20026ADB52F3BC3743E", hash_generated_field = "3688983F97AF1690FB74520E416D9D00")

    protected static final int EVENT_RESET_PREFERRED_NETWORK_TYPE = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "43CF528FB09DD7EFCD1B61A775F594FD", hash_generated_field = "7ABE32AA461749D2ACE4ED0BAC995178")

    protected static final int EVENT_CHECK_REPORT_GPRS = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "2AA267D0A323593CD1CA3C7444986A54", hash_generated_field = "13EA2B3AA7DECD0D61B6256F92C98577")

    protected static final int EVENT_RESTRICTED_STATE_CHANGED = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "FD95EB0AECC43FFA6050A98AF3C2EE90", hash_generated_field = "518D4C82ADF07EC2A7D85DAC04FBA81A")

    protected static final int EVENT_POLL_STATE_REGISTRATION_CDMA = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "5F40B645BDC5D903ABB1FBE57AB8BA00", hash_generated_field = "F063B5ADC5AE2DBDCDB9E1C910F75628")

    protected static final int EVENT_POLL_STATE_OPERATOR_CDMA = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "FCDC288C8DD9DA602685A3D118DA503A", hash_generated_field = "76F1DF043AB5BCCD7071F11CD4B3AC88")

    protected static final int EVENT_RUIM_READY = 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "5E36C591812341019D3FF3A29F08FCFE", hash_generated_field = "70D8F3A7C3F69F2A3505963EDC584DC0")

    protected static final int EVENT_RUIM_RECORDS_LOADED = 27;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "2D00CAB165A571F7589CF9F83C5EA213", hash_generated_field = "1D235673840F2B8537332AF8A9067118")

    protected static final int EVENT_POLL_SIGNAL_STRENGTH_CDMA = 28;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "946A40AF78EED39BD8DB7D38C4BFFAE2", hash_generated_field = "AE453819021BE93009DE15E100B55C9F")

    protected static final int EVENT_GET_SIGNAL_STRENGTH_CDMA = 29;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "54419F9118916A11707BE55567CEDECC", hash_generated_field = "31A9EA70B75498FCE50AAA182FBE8697")

    protected static final int EVENT_NETWORK_STATE_CHANGED_CDMA = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "17E86D606DFED9D8BFF6C122A265BC6A", hash_generated_field = "C6F07CD8E10392E467160421C286E913")

    protected static final int EVENT_GET_LOC_DONE_CDMA = 31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "A977A61CEA6E94D010243037642806B9", hash_generated_field = "9242A030126539BF7414AD7D2C54FB4D")

    protected static final int EVENT_SIGNAL_STRENGTH_UPDATE_CDMA = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "A78705E8A240F79C8D1EB7ECAA134866", hash_generated_field = "2714AE73CD2DE6067C276393254A4F49")

    protected static final int EVENT_NV_LOADED = 33;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "8C1E46C8B871332FCDA90DD29613196F", hash_generated_field = "77107C8CD65F04BDC51A0240BBB6C584")

    protected static final int EVENT_POLL_STATE_CDMA_SUBSCRIPTION = 34;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.387 -0400", hash_original_field = "C3264374EB9635E23D3957E2281DDC19", hash_generated_field = "97BF373F74AA7E6EF39F07CAC5B107C6")

    protected static final int EVENT_NV_READY = 35;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.388 -0400", hash_original_field = "B0D2B4E0CCB2E901F61861112D19B96D", hash_generated_field = "1FA37EFA5B59783A4CA17CBE2EB53364")

    protected static final int EVENT_ERI_FILE_LOADED = 36;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.388 -0400", hash_original_field = "752417F69C02C3FDBBDC5696D2EFDAF6", hash_generated_field = "38B46743C5C80444E6BF77B51381C7DB")

    protected static final int EVENT_OTA_PROVISION_STATUS_CHANGE = 37;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.388 -0400", hash_original_field = "582C08CC54C0A238033C84A23400C894", hash_generated_field = "E7ED1B06C237E08C2D6170BEBC38359D")

    protected static final int EVENT_SET_RADIO_POWER_OFF = 38;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.388 -0400", hash_original_field = "342108F0890003052FD169B722D9F042", hash_generated_field = "9741BEB9C7E685D363E6CB738BA59228")

    protected static final String TIMEZONE_PROPERTY = "persist.sys.timezone";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.388 -0400", hash_original_field = "FEB626B722603D8513941D982AD115BE", hash_generated_field = "FADC0352E688A4C90454821FF38946F6")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.388 -0400", hash_original_field = "1126E0564DBD3C324F4E6F6E2FC4381C", hash_generated_field = "944ED8C68A3508C953CED23EE840EF9B")

    protected static final String REGISTRATION_DENIED_GEN = "General";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.388 -0400", hash_original_field = "895CB5A605E703B50BEE3B0DDECD7281", hash_generated_field = "268AF97C81B9E7D55F2E3C79FB200A3E")

    protected static final String REGISTRATION_DENIED_AUTH = "Authentication Failure";
}

