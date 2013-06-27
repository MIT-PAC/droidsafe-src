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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.165 -0400", hash_original_field = "820EB5B696EA2A657C0DB1E258DC7D81", hash_generated_field = "EDF057DBE0A02042DBF83073757034E9")

    protected CommandsInterface cm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.165 -0400", hash_original_field = "3691308F2A4C2F6983F2880D32E29C84", hash_generated_field = "D607C471A1606B559A4F0C28A47BFD3A")

    public ServiceState ss;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.165 -0400", hash_original_field = "93999A138D8028B1B9E67CC0A3354563", hash_generated_field = "37638718D876F5421AD103383236AD22")

    protected ServiceState newSS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.165 -0400", hash_original_field = "E2C92BDB5B4E8A7DEDB542A89E12D094", hash_generated_field = "6D9902C068708E16DB7D3B6602B19CEF")

    public SignalStrength mSignalStrength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.165 -0400", hash_original_field = "89FC8327CE692B536819A20EE7A690EC", hash_generated_field = "F7D70BE82B631DDA8C3B56EF51FC91C4")

    public RestrictedState mRestrictedState = new RestrictedState();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.165 -0400", hash_original_field = "BB0063501B8846C194E64D27D44252B0", hash_generated_field = "971B063549A1138EC166910CD0B92E16")

    protected int[] pollingContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.165 -0400", hash_original_field = "C89D1AF0AEE8D0A2CF4FED65DAD30DE6", hash_generated_field = "6E0D0EEFBE55BC60F19FC7A47D2CF7A7")

    protected boolean mDesiredPowerState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.165 -0400", hash_original_field = "46F8921073F465F4E6A53F53FB3CC508", hash_generated_field = "0A6EAD8C7AE319D00ACC22C825C0E499")

    protected int mRadioTechnology = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.165 -0400", hash_original_field = "B8E8F5A57D823D60611735C4F5895E48", hash_generated_field = "F7B2E1EBB85BC053B9BECA60685DE78D")

    protected int mNewRadioTechnology = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.165 -0400", hash_original_field = "9FFCE7874852A8B3875A82A05563253C", hash_generated_field = "5F48A53F7B00B7BD0B14FCC83E25F1EC")

    protected boolean dontPollSignalStrength = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.165 -0400", hash_original_field = "94FA3100E083FF09EA8F625390F6DAFC", hash_generated_field = "3AD1304D1BA317277BBEE277F670A472")

    protected RegistrantList mRoamingOnRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.165 -0400", hash_original_field = "0051145150E7AA7F6E89800F1075B480", hash_generated_field = "7819DA14832792F71F719B742BCE9053")

    protected RegistrantList mRoamingOffRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.165 -0400", hash_original_field = "91A48951E79DD388FCC9CB820ADF00AE", hash_generated_field = "43D459080479D457B519BE0CE58EC773")

    protected RegistrantList mAttachedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.166 -0400", hash_original_field = "CDF1AAEFB08F60370633C1B7A33646FF", hash_generated_field = "B91229A5B50E80471AB407D94A8C22E0")

    protected RegistrantList mDetachedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.166 -0400", hash_original_field = "47FB42C6DDFD82D84A2D2B4CA1DEBF5A", hash_generated_field = "EC72819D10D4558220CC871EE1200506")

    protected RegistrantList mNetworkAttachedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.166 -0400", hash_original_field = "47274B22A05638E8C769F02DBC0B12BD", hash_generated_field = "177DDA8A6143F9FC217FCFE37BE4DE91")

    protected RegistrantList mPsRestrictEnabledRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.166 -0400", hash_original_field = "428282B5696411D181BC95503FCB2D51", hash_generated_field = "405B74B0B32B65F041BDD15D3756D948")

    protected RegistrantList mPsRestrictDisabledRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.166 -0400", hash_original_field = "BFB79692D4F405A20EC17E43F82839FB", hash_generated_field = "F73F9BC9D0BE82CE2BBEA28FFA11B4CC")

    private boolean mPendingRadioPowerOffAfterDataOff = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.166 -0400", hash_original_field = "1772E09AA0937CC30147757472377C56", hash_generated_field = "B8B4B877F9363010C47672B0C1475CA5")

    private int mPendingRadioPowerOffAfterDataOffTag = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.166 -0400", hash_original_field = "DBD352CA77B5AD318E43449A32D114AE", hash_generated_field = "AFC29418D745D3A6E97E0A67D746937B")

    private boolean mWantContinuousLocationUpdates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.166 -0400", hash_original_field = "AA41B1B75D4E1A40BD1637DAD5FC4D4A", hash_generated_field = "F3EAD7378CDAA1419A8D11AA1EFE6677")

    private boolean mWantSingleLocationUpdate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.166 -0400", hash_original_method = "9FCBDF2ED872770289A466CFAFBF2272", hash_generated_method = "EC17C25E196F47AE6D11EE4EF45CB92F")
    public  ServiceStateTracker() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.166 -0400", hash_original_method = "34F755352C02DF9FD9E8CDE125547BA1", hash_generated_method = "4AAB3F3134E902B10DF89EF866E343B2")
    public boolean getDesiredPowerState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1885994288 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1885994288;
        // ---------- Original Method ----------
        //return mDesiredPowerState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.169 -0400", hash_original_method = "37CB7B52ED49DF56B69CEDC0A8B6FEA7", hash_generated_method = "C7A900FE140BBDBAB69ECDCA8F09D265")
    public void registerForRoamingOn(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r;
        r = new Registrant(h, what, obj);
        mRoamingOnRegistrants.add(r);
        {
            boolean var6B533A2F88E9E352757F2AD33C409A0E_1922370421 = (ss.getRoaming());
            {
                r.notifyRegistrant();
            } //End block
        } //End collapsed parenthetic
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mRoamingOnRegistrants.add(r);
        //if (ss.getRoaming()) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.172 -0400", hash_original_method = "14E5206D7B7C852E20FD1241EAC246C6", hash_generated_method = "24B07A5FF61AA8E027EE9D80DB32604E")
    public void unregisterForRoamingOn(Handler h) {
        mRoamingOnRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mRoamingOnRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.176 -0400", hash_original_method = "13A5A77104C9ACCD9C28F87D910D95FA", hash_generated_method = "54AB45D79ED060A4F8DC4A58191386C9")
    public void registerForRoamingOff(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r;
        r = new Registrant(h, what, obj);
        mRoamingOffRegistrants.add(r);
        {
            boolean var19F81E00C9957D9B9E336DB1ADF15A6A_673068888 = (!ss.getRoaming());
            {
                r.notifyRegistrant();
            } //End block
        } //End collapsed parenthetic
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mRoamingOffRegistrants.add(r);
        //if (!ss.getRoaming()) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.177 -0400", hash_original_method = "D1DD4EA819F10675CB2C3CAADBABF939", hash_generated_method = "64646A4D002DB5BE3FB11D719657AC68")
    public void unregisterForRoamingOff(Handler h) {
        mRoamingOffRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mRoamingOffRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.179 -0400", hash_original_method = "7FC24E85162575F4AD0EC1D2B7D4DA9A", hash_generated_method = "D5EF4C5811FF145DED25A071115EED26")
    public void reRegisterNetwork(Message onComplete) {
        cm.getPreferredNetworkType(
                obtainMessage(EVENT_GET_PREFERRED_NETWORK_TYPE, onComplete));
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //cm.getPreferredNetworkType(
                //obtainMessage(EVENT_GET_PREFERRED_NETWORK_TYPE, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.182 -0400", hash_original_method = "58B5CA04F87B88A9C6B403E745D26733", hash_generated_method = "92BDBC4BB37F973F511A951B7426B3A8")
    public void setRadioPower(boolean power) {
        mDesiredPowerState = power;
        setPowerStateToDesired();
        // ---------- Original Method ----------
        //mDesiredPowerState = power;
        //setPowerStateToDesired();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.183 -0400", hash_original_method = "7C68C47F455301AB5237FB081DD87707", hash_generated_method = "EE5088C444C475D5E949D87B5C4756D4")
    public void enableSingleLocationUpdate() {
        mWantSingleLocationUpdate = true;
        cm.setLocationUpdates(true, obtainMessage(EVENT_LOCATION_UPDATES_ENABLED));
        // ---------- Original Method ----------
        //if (mWantSingleLocationUpdate || mWantContinuousLocationUpdates) return;
        //mWantSingleLocationUpdate = true;
        //cm.setLocationUpdates(true, obtainMessage(EVENT_LOCATION_UPDATES_ENABLED));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.183 -0400", hash_original_method = "5E0DE008FDA53D6E066E09E5FF8905A8", hash_generated_method = "03AF5F0E497F7B20D8197459C34369B2")
    public void enableLocationUpdates() {
        mWantContinuousLocationUpdates = true;
        cm.setLocationUpdates(true, obtainMessage(EVENT_LOCATION_UPDATES_ENABLED));
        // ---------- Original Method ----------
        //if (mWantSingleLocationUpdate || mWantContinuousLocationUpdates) return;
        //mWantContinuousLocationUpdates = true;
        //cm.setLocationUpdates(true, obtainMessage(EVENT_LOCATION_UPDATES_ENABLED));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.183 -0400", hash_original_method = "F0181FD0DF80A6AAF51E269E67B33EC8", hash_generated_method = "AE19223D8747C69C8DA37A2452628D75")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.184 -0400", hash_original_method = "70DFFFF4880D84ACE04FFF62B87B40F7", hash_generated_method = "2B9EEED76CEF199D302CF09FEF708D21")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.184 -0400", hash_original_method = "85B887C2BDF2CF10C0119B00ACC95929", hash_generated_method = "B8739D8B2E692B9FA5C1F71B225BE987")
    @Override
    public void handleMessage(Message msg) {
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
        addTaint(msg.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.194 -0400", hash_original_method = "1B39DC11812BAED5F6DBE7D3309539B9", hash_generated_method = "91F12351BB2D9B51206CA12D03B19907")
    public void registerForDataConnectionAttached(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r;
        r = new Registrant(h, what, obj);
        mAttachedRegistrants.add(r);
        {
            boolean var916199C9AC52A481129DA297D39E2DE2_662375275 = (getCurrentDataConnectionState() == ServiceState.STATE_IN_SERVICE);
            {
                r.notifyRegistrant();
            } //End block
        } //End collapsed parenthetic
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mAttachedRegistrants.add(r);
        //if (getCurrentDataConnectionState() == ServiceState.STATE_IN_SERVICE) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.194 -0400", hash_original_method = "522E6F692E8A34CBC0692BA5B00B104A", hash_generated_method = "5481C623114BC010E8BAB1614228EACE")
    public void unregisterForDataConnectionAttached(Handler h) {
        mAttachedRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mAttachedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.195 -0400", hash_original_method = "77B8D4D5781330742D00786669C25585", hash_generated_method = "F53827345065BE3140F6E5C0FC7F7EA5")
    public void registerForDataConnectionDetached(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r;
        r = new Registrant(h, what, obj);
        mDetachedRegistrants.add(r);
        {
            boolean varB071BB11532F4DC1D052EC4F3C54F2CC_453142181 = (getCurrentDataConnectionState() != ServiceState.STATE_IN_SERVICE);
            {
                r.notifyRegistrant();
            } //End block
        } //End collapsed parenthetic
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mDetachedRegistrants.add(r);
        //if (getCurrentDataConnectionState() != ServiceState.STATE_IN_SERVICE) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.195 -0400", hash_original_method = "EDB8FFB895F180442CD81D10E9DCB320", hash_generated_method = "FED2461D0B9B4154519B4FA214E6A3D6")
    public void unregisterForDataConnectionDetached(Handler h) {
        mDetachedRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mDetachedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.197 -0400", hash_original_method = "076CF7EAC62798919AFD2DB28A5B16ED", hash_generated_method = "01EAC75A61E460F04B784C8F719E79F9")
    public void registerForNetworkAttached(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r;
        r = new Registrant(h, what, obj);
        mNetworkAttachedRegistrants.add(r);
        {
            boolean var90E428A9AC79F870ED42DBCBC7F55DFE_804267224 = (ss.getState() == ServiceState.STATE_IN_SERVICE);
            {
                r.notifyRegistrant();
            } //End block
        } //End collapsed parenthetic
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mNetworkAttachedRegistrants.add(r);
        //if (ss.getState() == ServiceState.STATE_IN_SERVICE) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.198 -0400", hash_original_method = "724BCD9A17C4DC5B22474701A65D5E92", hash_generated_method = "51EFBB8F73B661DA9B2AE7E2399AE80F")
    public void unregisterForNetworkAttached(Handler h) {
        mNetworkAttachedRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mNetworkAttachedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.198 -0400", hash_original_method = "32627558F162EE4DAA643B6ABADEA2AE", hash_generated_method = "C78BCEFD44F30F2273259B9468A8D982")
    public void registerForPsRestrictedEnabled(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r;
        r = new Registrant(h, what, obj);
        mPsRestrictEnabledRegistrants.add(r);
        {
            boolean varEBAAA70B69E09997F2347E79FB42F56D_775956357 = (mRestrictedState.isPsRestricted());
            {
                r.notifyRegistrant();
            } //End block
        } //End collapsed parenthetic
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mPsRestrictEnabledRegistrants.add(r);
        //if (mRestrictedState.isPsRestricted()) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.199 -0400", hash_original_method = "9066DA15695A4B8D83C2DCD56A112C2B", hash_generated_method = "6ACF0B135D10A3BEBFA794D64D441F31")
    public void unregisterForPsRestrictedEnabled(Handler h) {
        mPsRestrictEnabledRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mPsRestrictEnabledRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.206 -0400", hash_original_method = "80FC2224C82FF97B7F6C95DA27C6509B", hash_generated_method = "2C46EF51A5BF457E73244B04FC437F6A")
    public void registerForPsRestrictedDisabled(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r;
        r = new Registrant(h, what, obj);
        mPsRestrictDisabledRegistrants.add(r);
        {
            boolean varEBAAA70B69E09997F2347E79FB42F56D_90022065 = (mRestrictedState.isPsRestricted());
            {
                r.notifyRegistrant();
            } //End block
        } //End collapsed parenthetic
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //mPsRestrictDisabledRegistrants.add(r);
        //if (mRestrictedState.isPsRestricted()) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.206 -0400", hash_original_method = "3E796B0EF9A5478F633347EEDEC69A91", hash_generated_method = "7E24E5D5CC7A58D0A633DCB7DF91DA45")
    public void unregisterForPsRestrictedDisabled(Handler h) {
        mPsRestrictDisabledRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mPsRestrictDisabledRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.218 -0400", hash_original_method = "4017CCA25B6B957B00970913316AB84B", hash_generated_method = "BBE86565FCC5A8FEF92BE7B0F638F412")
    public void powerOffRadioSafely(DataConnectionTracker dcTracker) {
        {
            {
                {
                    boolean var99A479C28B03EC3D42BC3A0E80AA9F99_2099757846 = (dcTracker.isDisconnected());
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
                            boolean varD2C2C41FD51EAA93475820526F295E88_437704781 = (sendMessageDelayed(msg, 30000));
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
        addTaint(dcTracker.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.218 -0400", hash_original_method = "67059C8AF83909E1964C0331470598CC", hash_generated_method = "4B6EFF1AB8D3588DD7A8BCA8F3FEEA9C")
    public boolean processPendingRadioPowerOffAfterDataOff() {
        {
            {
                log("Process pending request to turn radio off.");
                mPendingRadioPowerOffAfterDataOffTag += 1;
                hangupAndPowerOff();
                mPendingRadioPowerOffAfterDataOff = false;
            } //End block
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_391573914 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_391573914;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.219 -0400", hash_original_method = "CCBC34A7562606F2023BFC5649B6E19A", hash_generated_method = "F6D15879E1DF2FFC771820A47AF4ACD6")
    protected void cancelPollState() {
        pollingContext = new int[1];
        // ---------- Original Method ----------
        //pollingContext = new int[1];
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.219 -0400", hash_original_field = "51CA201FB6DAC9DEAB7E580C7C4599CD", hash_generated_field = "5FE34011A6194BC6286A035D997282EE")

    static public final int OTASP_UNINITIALIZED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.219 -0400", hash_original_field = "8D4E28BFCA39106CB17DE0E87186DD1D", hash_generated_field = "061A5F4CDB2510482DF40014FA069CCD")

    static public final int OTASP_UNKNOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.219 -0400", hash_original_field = "380263A3A57EA3826A4CD8E6E8F37840", hash_generated_field = "6654A3F1BBBF982EA7C9094DDBE96306")

    static public final int OTASP_NEEDED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.219 -0400", hash_original_field = "CD237A46E8E4E4E94E94F43E843D23CC", hash_generated_field = "8614A164E69549BC084DFCFF1DBAF5E0")

    static public final int OTASP_NOT_NEEDED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.219 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "D751668EF011EB030075908D0A6ACFD9")

    protected static boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.219 -0400", hash_original_field = "6BF55DF2C3DDC179A396035256FD9221", hash_generated_field = "7A08EC5E731F26F0D664A8F740AABBC9")

    protected static int POLL_PERIOD_MILLIS = 20 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.219 -0400", hash_original_field = "78DBFEDA4D4BF3B7443050756EB706DA", hash_generated_field = "CAFDA3BCC51A0F86441922B04B913066")

    public static final int DEFAULT_GPRS_CHECK_PERIOD_MILLIS = 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.219 -0400", hash_original_field = "58A49A2EE32C928380ED31C83C5B2EC8", hash_generated_field = "350FD9102CAF659B7747742CC8B397D0")

    protected static int EVENT_RADIO_STATE_CHANGED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.219 -0400", hash_original_field = "144ACBA3985CD8981FD3593A6B5D2D1D", hash_generated_field = "CE86A48B2A35208A041DE402F5164761")

    protected static int EVENT_NETWORK_STATE_CHANGED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.219 -0400", hash_original_field = "C1D21D82E85131B6342B2E8C35FFD311", hash_generated_field = "5884FFF40D6A54AE5E406BD87DBF330C")

    protected static int EVENT_GET_SIGNAL_STRENGTH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.219 -0400", hash_original_field = "5E11D6B3712C373638C7DC07E9117EDC", hash_generated_field = "BC2292392D4F7E7AD02E8069F9D178F0")

    protected static int EVENT_POLL_STATE_REGISTRATION = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.219 -0400", hash_original_field = "6D8A478D52EE2A1150B8A9E475A88EAA", hash_generated_field = "65327E772DAF60BEACBB9D89394BF9DF")

    protected static int EVENT_POLL_STATE_GPRS = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.219 -0400", hash_original_field = "1A7489055DF4012458D860FD4BF5340A", hash_generated_field = "286A207EB3BBD766E960BFECDCC91AAC")

    protected static int EVENT_POLL_STATE_OPERATOR = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.219 -0400", hash_original_field = "234DDA4105A1A5D4DFFFC47B06E66124", hash_generated_field = "C369A606CADB10A0C04BCFDC46DF544F")

    protected static int EVENT_POLL_SIGNAL_STRENGTH = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "7B1ECC232C01880E0930A56E3C1ABC68", hash_generated_field = "2F6819A976B479832DCEBE69C26C757D")

    protected static int EVENT_NITZ_TIME = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "28D66DAF312C36CC60B647D0393EDD7E", hash_generated_field = "C70C8C1FA2E6C5AB6E0E86B7FA6BFD88")

    protected static int EVENT_SIGNAL_STRENGTH_UPDATE = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "7B097FA5AA997D42E55523C39AECEEF8", hash_generated_field = "B99AE7FBD871D12B989D724A9B333CF0")

    protected static int EVENT_RADIO_AVAILABLE = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "36CDA17540A5AD5FD9B083A26AAA7471", hash_generated_field = "8CEEDFA8C8A5EFD150B79F11BC817893")

    protected static int EVENT_POLL_STATE_NETWORK_SELECTION_MODE = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "D0DADBE488E1BA8F45D788BA2DC4AC75", hash_generated_field = "CD384A5E66EEB09C071814049C21A562")

    protected static int EVENT_GET_LOC_DONE = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "F68742559028F845BFE7D13EBA5751DD", hash_generated_field = "218D1B2A167266D71C6FB2F6113827C6")

    protected static int EVENT_SIM_RECORDS_LOADED = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "A1EDB104CFF4FBF30AD3BC27A5F14562", hash_generated_field = "559C856596F6AF32AB8C2EA8486FB596")

    protected static int EVENT_SIM_READY = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "456C2A1D2A5FB1D1C3819626B6EFDCEE", hash_generated_field = "051B10377C3C414F190F54D26F82809A")

    protected static int EVENT_LOCATION_UPDATES_ENABLED = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "E8A7882DF66AE1E27E12AD3A08D092A1", hash_generated_field = "95C3D32108745A8936E88A7310F72F6E")

    protected static int EVENT_GET_PREFERRED_NETWORK_TYPE = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "D9038D73472214352F7569FEE902D600", hash_generated_field = "C097E0D26687BABDC44ABB4DF7C1A848")

    protected static int EVENT_SET_PREFERRED_NETWORK_TYPE = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "EF75756A9124C20026ADB52F3BC3743E", hash_generated_field = "4E452276F95659EBB2401148CE32EEAA")

    protected static int EVENT_RESET_PREFERRED_NETWORK_TYPE = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "43CF528FB09DD7EFCD1B61A775F594FD", hash_generated_field = "771163109FAEE1B0EF7A799ECB5D1328")

    protected static int EVENT_CHECK_REPORT_GPRS = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "2AA267D0A323593CD1CA3C7444986A54", hash_generated_field = "06E6EC84FA23788C47DA82E2B7ED125E")

    protected static int EVENT_RESTRICTED_STATE_CHANGED = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "FD95EB0AECC43FFA6050A98AF3C2EE90", hash_generated_field = "CEF5E55922B73BB786C3C0E1407B1AF4")

    protected static int EVENT_POLL_STATE_REGISTRATION_CDMA = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "5F40B645BDC5D903ABB1FBE57AB8BA00", hash_generated_field = "2D874009FDD5B29A9CAA7ADE80925E95")

    protected static int EVENT_POLL_STATE_OPERATOR_CDMA = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "FCDC288C8DD9DA602685A3D118DA503A", hash_generated_field = "E7F95B636F4B419A56CC827DC4AAFB31")

    protected static int EVENT_RUIM_READY = 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "5E36C591812341019D3FF3A29F08FCFE", hash_generated_field = "EDE31807BB0A78F9A9A0750135F04858")

    protected static int EVENT_RUIM_RECORDS_LOADED = 27;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "2D00CAB165A571F7589CF9F83C5EA213", hash_generated_field = "41B24C1BF3646C36CAF78B80DE0EECB5")

    protected static int EVENT_POLL_SIGNAL_STRENGTH_CDMA = 28;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "946A40AF78EED39BD8DB7D38C4BFFAE2", hash_generated_field = "56854AE8172A885EEA76A80E5A51571C")

    protected static int EVENT_GET_SIGNAL_STRENGTH_CDMA = 29;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "54419F9118916A11707BE55567CEDECC", hash_generated_field = "CA44D4580A79162B7D8AA0213913F9CF")

    protected static int EVENT_NETWORK_STATE_CHANGED_CDMA = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "17E86D606DFED9D8BFF6C122A265BC6A", hash_generated_field = "46B1071130FDA9731FAC5F60A293220B")

    protected static int EVENT_GET_LOC_DONE_CDMA = 31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "A977A61CEA6E94D010243037642806B9", hash_generated_field = "01C2DE91B7B1A9DB48252EDF396697D2")

    protected static int EVENT_SIGNAL_STRENGTH_UPDATE_CDMA = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "A78705E8A240F79C8D1EB7ECAA134866", hash_generated_field = "8EABB18AB4BCB8135DA45BB369CB71F1")

    protected static int EVENT_NV_LOADED = 33;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.220 -0400", hash_original_field = "8C1E46C8B871332FCDA90DD29613196F", hash_generated_field = "272FF924287A18F4810BBD19DD2EAF7D")

    protected static int EVENT_POLL_STATE_CDMA_SUBSCRIPTION = 34;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.221 -0400", hash_original_field = "C3264374EB9635E23D3957E2281DDC19", hash_generated_field = "5870393F5FA5427F89D6940B63C29F1E")

    protected static int EVENT_NV_READY = 35;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.221 -0400", hash_original_field = "B0D2B4E0CCB2E901F61861112D19B96D", hash_generated_field = "4842E34A9A97B129E387265700D2FAD0")

    protected static int EVENT_ERI_FILE_LOADED = 36;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.221 -0400", hash_original_field = "752417F69C02C3FDBBDC5696D2EFDAF6", hash_generated_field = "E927FDCD9560F0CA0C67442383A1D8E3")

    protected static int EVENT_OTA_PROVISION_STATUS_CHANGE = 37;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.221 -0400", hash_original_field = "582C08CC54C0A238033C84A23400C894", hash_generated_field = "28EE19F39A94D941D1C1662DAA71E9EE")

    protected static int EVENT_SET_RADIO_POWER_OFF = 38;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.221 -0400", hash_original_field = "342108F0890003052FD169B722D9F042", hash_generated_field = "0673E82551B552DD7FF94F74D61B40CA")

    protected static String TIMEZONE_PROPERTY = "persist.sys.timezone";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.221 -0400", hash_original_field = "FEB626B722603D8513941D982AD115BE", hash_generated_field = "E2451D5F33FB29B05E138E7585AF5CD0")

    protected static String[] GMT_COUNTRY_CODES = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.221 -0400", hash_original_field = "1126E0564DBD3C324F4E6F6E2FC4381C", hash_generated_field = "012B716641A8E2574033A7A5746E9FBC")

    protected static String REGISTRATION_DENIED_GEN = "General";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.221 -0400", hash_original_field = "895CB5A605E703B50BEE3B0DDECD7281", hash_generated_field = "B7E4470CFBA8C6F031AA408721CF40D1")

    protected static String REGISTRATION_DENIED_AUTH = "Authentication Failure";
}

