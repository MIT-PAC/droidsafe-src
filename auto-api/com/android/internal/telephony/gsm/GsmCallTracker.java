package com.android.internal.telephony.gsm;

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
import android.os.SystemProperties;
import android.telephony.PhoneNumberUtils;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.EventLog;
import android.util.Log;
import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.CallTracker;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.DriverCall;
import com.android.internal.telephony.EventLogTags;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.TelephonyProperties;
import com.android.internal.telephony.UUSInfo;
import com.android.internal.telephony.gsm.CallFailCause;
import com.android.internal.telephony.gsm.GSMPhone;
import com.android.internal.telephony.gsm.GsmCall;
import com.android.internal.telephony.gsm.GsmConnection;
import java.util.List;
import java.util.ArrayList;

public final class GsmCallTracker extends CallTracker {
    GsmConnection connections[] = new GsmConnection[MAX_CONNECTIONS];
    RegistrantList voiceCallEndedRegistrants = new RegistrantList();
    RegistrantList voiceCallStartedRegistrants = new RegistrantList();
    ArrayList<GsmConnection> droppedDuringPoll
        = new ArrayList<GsmConnection>(MAX_CONNECTIONS);
    GsmCall ringingCall = new GsmCall(this);
    GsmCall foregroundCall = new GsmCall(this);
    GsmCall backgroundCall = new GsmCall(this);
    GsmConnection pendingMO;
    boolean hangupPendingMO;
    GSMPhone phone;
    boolean desiredMute = false;
    Phone.State state = Phone.State.IDLE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.228 -0400", hash_original_method = "22EA361F37F32F253874F064459157A8", hash_generated_method = "8AAD4415DAE01BB908827BD96CCB7674")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     GsmCallTracker(GSMPhone phone) {
        dsTaint.addTaint(phone.dsTaint);
        cm = phone.mCM;
        cm.registerForCallStateChanged(this, EVENT_CALL_STATE_CHANGE, null);
        cm.registerForOn(this, EVENT_RADIO_AVAILABLE, null);
        cm.registerForNotAvailable(this, EVENT_RADIO_NOT_AVAILABLE, null);
        // ---------- Original Method ----------
        //this.phone = phone;
        //cm = phone.mCM;
        //cm.registerForCallStateChanged(this, EVENT_CALL_STATE_CHANGE, null);
        //cm.registerForOn(this, EVENT_RADIO_AVAILABLE, null);
        //cm.registerForNotAvailable(this, EVENT_RADIO_NOT_AVAILABLE, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.232 -0400", hash_original_method = "FC4B042AA431A9477437EAA2E6A7E3DB", hash_generated_method = "FA76742A53A7AE4FED2611B2F090A166")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispose() {
        cm.unregisterForCallStateChanged(this);
        cm.unregisterForOn(this);
        cm.unregisterForNotAvailable(this);
        {
            GsmConnection c = connections[0];
            {
                try 
                {
                    hangup(c);
                } //End block
                catch (CallStateException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        try 
        {
            hangup(pendingMO);
        } //End block
        catch (CallStateException ex)
        { }
        clearDisconnected();
        // ---------- Original Method ----------
        //cm.unregisterForCallStateChanged(this);
        //cm.unregisterForOn(this);
        //cm.unregisterForNotAvailable(this);
        //for(GsmConnection c : connections) {
            //try {
                //if(c != null) hangup(c);
            //} catch (CallStateException ex) {
                //Log.e(LOG_TAG, "unexpected error on hangup during dispose");
            //}
        //}
        //try {
            //if(pendingMO != null) hangup(pendingMO);
        //} catch (CallStateException ex) {
            //Log.e(LOG_TAG, "unexpected error on hangup during dispose");
        //}
        //clearDisconnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.233 -0400", hash_original_method = "865768B4EC6A5A664005D55855DE8CD7", hash_generated_method = "6A1448BDD14ADEB0FF56B2BB2A4D0313")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() {
        Log.d(LOG_TAG, "GsmCallTracker finalized");
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "GsmCallTracker finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.233 -0400", hash_original_method = "74524BAB538005AE6F8AB18E196FEB02", hash_generated_method = "7C39E258632B8226E75D3A3B4545F624")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForVoiceCallStarted(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant(h, what, obj);
        voiceCallStartedRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //voiceCallStartedRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.233 -0400", hash_original_method = "3C910908B4B98998A7936D8F8AE4D170", hash_generated_method = "080D8A6C55C5F5E6022A9978B521C166")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForVoiceCallStarted(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        voiceCallStartedRegistrants.remove(h);
        // ---------- Original Method ----------
        //voiceCallStartedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.233 -0400", hash_original_method = "D7F70C00A904DE96D26BDF7C49F41DAA", hash_generated_method = "5DCF28D8516CF4D9576AAD84014793DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForVoiceCallEnded(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant(h, what, obj);
        voiceCallEndedRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //voiceCallEndedRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.234 -0400", hash_original_method = "91176AF98778238DB3B453F2FC7D9448", hash_generated_method = "34FF2F021EB97611BF23342BD7861149")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForVoiceCallEnded(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        voiceCallEndedRegistrants.remove(h);
        // ---------- Original Method ----------
        //voiceCallEndedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.234 -0400", hash_original_method = "4204FB660E281B4690A876C95432F574", hash_generated_method = "B16D5D0A7AB157E261023B3DF58417A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void fakeHoldForegroundBeforeDial() {
        List<Connection> connCopy;
        connCopy = (List<Connection>) foregroundCall.connections.clone();
        {
            int i, s;
            i = 0;
            s = connCopy.size();
            {
                GsmConnection conn;
                conn = (GsmConnection)connCopy.get(i);
                conn.fakeHoldBeforeDial();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //List<Connection> connCopy;
        //connCopy = (List<Connection>) foregroundCall.connections.clone();
        //for (int i = 0, s = connCopy.size() ; i < s ; i++) {
            //GsmConnection conn = (GsmConnection)connCopy.get(i);
            //conn.fakeHoldBeforeDial();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.234 -0400", hash_original_method = "BBA59EE5F024CF032CB3FE359D476C6C", hash_generated_method = "42429AF6E3A9CF15CE3B866C643D6F71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Connection dial(String dialString, int clirMode, UUSInfo uusInfo) throws CallStateException {
        dsTaint.addTaint(uusInfo.dsTaint);
        dsTaint.addTaint(clirMode);
        dsTaint.addTaint(dialString);
        clearDisconnected();
        {
            boolean var37336DD64F87D8D8C5FEC219FB8725E9_218405004 = (!canDial());
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("cannot dial in current state");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var0E756393CADA3C09E6B9AC103D5D995B_343962439 = (foregroundCall.getState() == GsmCall.State.ACTIVE);
            {
                switchWaitingOrHoldingAndActive();
                fakeHoldForegroundBeforeDial();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var123C908F6092967F2402C8E6F98D6087_56138725 = (foregroundCall.getState() != GsmCall.State.IDLE);
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("cannot dial in current state");
            } //End block
        } //End collapsed parenthetic
        pendingMO = new GsmConnection(phone.getContext(), dialString, this, foregroundCall);
        hangupPendingMO = false;
        {
            boolean varE9C786784B3495FF438205BDA3869C7F_1783066659 = (pendingMO.address == null || pendingMO.address.length() == 0
            || pendingMO.address.indexOf(PhoneNumberUtils.WILD) >= 0);
            {
                pendingMO.cause = Connection.DisconnectCause.INVALID_NUMBER;
                pollCallsWhenSafe();
            } //End block
            {
                setMute(false);
                cm.dial(pendingMO.address, clirMode, uusInfo, obtainCompleteMessage());
            } //End block
        } //End collapsed parenthetic
        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.234 -0400", hash_original_method = "890AB92FDE9FE4C57A1E95495C075681", hash_generated_method = "038B80522AA96C220A56BB52B0C9EA89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Connection dial(String dialString) throws CallStateException {
        dsTaint.addTaint(dialString);
        Connection var34D34FF3550F28A68F53F0F4CF11F3DA_1743235284 = (dial(dialString, CommandsInterface.CLIR_DEFAULT, null));
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return dial(dialString, CommandsInterface.CLIR_DEFAULT, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.235 -0400", hash_original_method = "2869CC3BF5EF49E3F89EEEBD1A0C3021", hash_generated_method = "A37AE81FC3C6387AEEF2A7A5D3F08CB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        dsTaint.addTaint(uusInfo.dsTaint);
        dsTaint.addTaint(dialString);
        Connection varB027E3F1692F7331B2A18ABBF994536D_1878329017 = (dial(dialString, CommandsInterface.CLIR_DEFAULT, uusInfo));
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return dial(dialString, CommandsInterface.CLIR_DEFAULT, uusInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.235 -0400", hash_original_method = "EC4F7F51F5F0A4F61E0068E2B7BE6FF2", hash_generated_method = "8F1D9E9EC1CEF5ED818D19FE4EE1F1BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Connection dial(String dialString, int clirMode) throws CallStateException {
        dsTaint.addTaint(clirMode);
        dsTaint.addTaint(dialString);
        Connection var536AA2A65C5EFBE8B13B3284A3301488_336942167 = (dial(dialString, clirMode, null));
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return dial(dialString, clirMode, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.235 -0400", hash_original_method = "6B4B3AB5A2A59FF5FB364E6A16F49177", hash_generated_method = "16CB9CFF1E86F06510851383D1AB4E45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void acceptCall() throws CallStateException {
        {
            boolean varEDDD3B2A3AC11C08EDA20432FF1C332B_1998940338 = (ringingCall.getState() == GsmCall.State.INCOMING);
            {
                setMute(false);
                cm.acceptCall(obtainCompleteMessage());
            } //End block
            {
                boolean var58438C7CA573DDF61E32D15003EFB49D_204636126 = (ringingCall.getState() == GsmCall.State.WAITING);
                {
                    setMute(false);
                    switchWaitingOrHoldingAndActive();
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new CallStateException("phone not ringing");
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (ringingCall.getState() == GsmCall.State.INCOMING) {
            //Log.i("phone", "acceptCall: incoming...");
            //setMute(false);
            //cm.acceptCall(obtainCompleteMessage());
        //} else if (ringingCall.getState() == GsmCall.State.WAITING) {
            //setMute(false);
            //switchWaitingOrHoldingAndActive();
        //} else {
            //throw new CallStateException("phone not ringing");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.235 -0400", hash_original_method = "9B02E01190499DD77CD223AD7831C55B", hash_generated_method = "7C3240A5303725B9CA2BCE6F9288EF0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void rejectCall() throws CallStateException {
        {
            boolean var2DE25B4C7BD786874002695E4305AD0A_373969786 = (ringingCall.getState().isRinging());
            {
                cm.rejectCall(obtainCompleteMessage());
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("phone not ringing");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (ringingCall.getState().isRinging()) {
            //cm.rejectCall(obtainCompleteMessage());
        //} else {
            //throw new CallStateException("phone not ringing");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.236 -0400", hash_original_method = "F087D3CDA5FED1EA3EF910AA070D114E", hash_generated_method = "939B8EF0C3C7F3D0E239C2630C629A69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void switchWaitingOrHoldingAndActive() throws CallStateException {
        {
            boolean varEDDD3B2A3AC11C08EDA20432FF1C332B_1215516132 = (ringingCall.getState() == GsmCall.State.INCOMING);
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("cannot be in the incoming state");
            } //End block
            {
                cm.switchWaitingOrHoldingAndActive(
                    obtainCompleteMessage(EVENT_SWITCH_RESULT));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (ringingCall.getState() == GsmCall.State.INCOMING) {
            //throw new CallStateException("cannot be in the incoming state");
        //} else {
            //cm.switchWaitingOrHoldingAndActive(
                    //obtainCompleteMessage(EVENT_SWITCH_RESULT));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.236 -0400", hash_original_method = "21B7458D194C157C186B70ABA7C7D274", hash_generated_method = "25B6942AE32BFB6C44A786C1B8AF0EFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void conference() throws CallStateException {
        cm.conference(obtainCompleteMessage(EVENT_CONFERENCE_RESULT));
        // ---------- Original Method ----------
        //cm.conference(obtainCompleteMessage(EVENT_CONFERENCE_RESULT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.236 -0400", hash_original_method = "B9B58214FE30DEB2D41379B25D88E6DD", hash_generated_method = "91DDF637F580C2F12D44ADB525F30440")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void explicitCallTransfer() throws CallStateException {
        cm.explicitCallTransfer(obtainCompleteMessage(EVENT_ECT_RESULT));
        // ---------- Original Method ----------
        //cm.explicitCallTransfer(obtainCompleteMessage(EVENT_ECT_RESULT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.236 -0400", hash_original_method = "89E1881B087BAA2C040FAFD444B532DA", hash_generated_method = "93C10D32BFEAACBDB937011534F3F686")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void clearDisconnected() {
        internalClearDisconnected();
        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
        // ---------- Original Method ----------
        //internalClearDisconnected();
        //updatePhoneState();
        //phone.notifyPreciseCallStateChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.236 -0400", hash_original_method = "C3AFF7137220AE966ED90D221261BE5A", hash_generated_method = "72820BA4A94324676497A7FF873F30D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean canConference() {
        boolean var78F41FEE2FA482AD87767611C0E1F98D_1035421742 = (foregroundCall.getState() == GsmCall.State.ACTIVE
                && backgroundCall.getState() == GsmCall.State.HOLDING
                && !backgroundCall.isFull()
                && !foregroundCall.isFull());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return foregroundCall.getState() == GsmCall.State.ACTIVE
                //&& backgroundCall.getState() == GsmCall.State.HOLDING
                //&& !backgroundCall.isFull()
                //&& !foregroundCall.isFull();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.237 -0400", hash_original_method = "808FE91E5748A2C0F0CF7B9BCBDBAE36", hash_generated_method = "D8B1ABEFCDBC26A423F6FC45139FB115")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean canDial() {
        boolean ret;
        int serviceState;
        serviceState = phone.getServiceState().getState();
        String disableCall;
        disableCall = SystemProperties.get(
                TelephonyProperties.PROPERTY_DISABLE_CALL, "false");
        ret = (serviceState != ServiceState.STATE_POWER_OFF)
                && pendingMO == null
                && !ringingCall.isRinging()
                && !disableCall.equals("true")
                && (!foregroundCall.getState().isAlive()
                    || !backgroundCall.getState().isAlive());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean ret;
        //int serviceState = phone.getServiceState().getState();
        //String disableCall = SystemProperties.get(
                //TelephonyProperties.PROPERTY_DISABLE_CALL, "false");
        //ret = (serviceState != ServiceState.STATE_POWER_OFF)
                //&& pendingMO == null
                //&& !ringingCall.isRinging()
                //&& !disableCall.equals("true")
                //&& (!foregroundCall.getState().isAlive()
                    //|| !backgroundCall.getState().isAlive());
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.237 -0400", hash_original_method = "E4A32A086AF9F2037148F022098D94F1", hash_generated_method = "DA4A330082F82A5003E1DE6C014C3FB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean canTransfer() {
        boolean varE2A225D3277C2D536901962ABDFBA11D_1317736278 = (foregroundCall.getState() == GsmCall.State.ACTIVE
                && backgroundCall.getState() == GsmCall.State.HOLDING);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return foregroundCall.getState() == GsmCall.State.ACTIVE
                //&& backgroundCall.getState() == GsmCall.State.HOLDING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.237 -0400", hash_original_method = "3058DCAC5E1117AE07A379578E7C6A20", hash_generated_method = "F0E9C736A8A4591368CEECFAB84F530D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void internalClearDisconnected() {
        ringingCall.clearDisconnected();
        foregroundCall.clearDisconnected();
        backgroundCall.clearDisconnected();
        // ---------- Original Method ----------
        //ringingCall.clearDisconnected();
        //foregroundCall.clearDisconnected();
        //backgroundCall.clearDisconnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.237 -0400", hash_original_method = "89F67FF5AFAE8FAD9F556239F3E27159", hash_generated_method = "8AAA465577A59F19AD56F6B679D71400")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Message obtainCompleteMessage() {
        Message var0A1D62473424F1503E7644788869EEA5_488405073 = (obtainCompleteMessage(EVENT_OPERATION_COMPLETE));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return obtainCompleteMessage(EVENT_OPERATION_COMPLETE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.237 -0400", hash_original_method = "F527C5C3DD4F0176588A0C261AD76B7A", hash_generated_method = "F06DF67ED01380AED3333DB57FCCEFA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Message obtainCompleteMessage(int what) {
        dsTaint.addTaint(what);
        lastRelevantPoll = null;
        needsPoll = true;
        log("obtainCompleteMessage: pendingOperations=" +
                pendingOperations + ", needsPoll=" + needsPoll);
        Message varC26248E20512DCE6AF1BDB5EAD201F8B_315531863 = (obtainMessage(what));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //pendingOperations++;
        //lastRelevantPoll = null;
        //needsPoll = true;
        //if (DBG_POLL) log("obtainCompleteMessage: pendingOperations=" +
                //pendingOperations + ", needsPoll=" + needsPoll);
        //return obtainMessage(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.238 -0400", hash_original_method = "58BAF8F27C1747875766F27864D59E66", hash_generated_method = "2D3BA89F26E49E2281B9F182A50C4977")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void operationComplete() {
        log("operationComplete: pendingOperations=" +
                pendingOperations + ", needsPoll=" + needsPoll);
        {
            lastRelevantPoll = obtainMessage(EVENT_POLL_CALLS_RESULT);
            cm.getCurrentCalls(lastRelevantPoll);
        } //End block
        {
            pendingOperations = 0;
        } //End block
        // ---------- Original Method ----------
        //pendingOperations--;
        //if (DBG_POLL) log("operationComplete: pendingOperations=" +
                //pendingOperations + ", needsPoll=" + needsPoll);
        //if (pendingOperations == 0 && needsPoll) {
            //lastRelevantPoll = obtainMessage(EVENT_POLL_CALLS_RESULT);
            //cm.getCurrentCalls(lastRelevantPoll);
        //} else if (pendingOperations < 0) {
            //Log.e(LOG_TAG,"GsmCallTracker.pendingOperations < 0");
            //pendingOperations = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.238 -0400", hash_original_method = "23DAEFAFA1E8C13E9726BBC375E8DDCB", hash_generated_method = "32032DBB4988769F29D79868325E48F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updatePhoneState() {
        Phone.State oldState;
        oldState = state;
        {
            boolean varE4BD9FA258196C0B4AF6B5D416334169_977659614 = (ringingCall.isRinging());
            {
                state = Phone.State.RINGING;
            } //End block
            {
                boolean var4C7AB8264C38A76EB062AB98EEF3EE82_1288092370 = (pendingMO != null ||
                !(foregroundCall.isIdle() && backgroundCall.isIdle()));
                {
                    state = Phone.State.OFFHOOK;
                } //End block
                {
                    state = Phone.State.IDLE;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            voiceCallEndedRegistrants.notifyRegistrants(
                new AsyncResult(null, null, null));
        } //End block
        {
            voiceCallStartedRegistrants.notifyRegistrants (
                    new AsyncResult(null, null, null));
        } //End block
        {
            phone.notifyPhoneStateChanged();
        } //End block
        // ---------- Original Method ----------
        //Phone.State oldState = state;
        //if (ringingCall.isRinging()) {
            //state = Phone.State.RINGING;
        //} else if (pendingMO != null ||
                //!(foregroundCall.isIdle() && backgroundCall.isIdle())) {
            //state = Phone.State.OFFHOOK;
        //} else {
            //state = Phone.State.IDLE;
        //}
        //if (state == Phone.State.IDLE && oldState != state) {
            //voiceCallEndedRegistrants.notifyRegistrants(
                //new AsyncResult(null, null, null));
        //} else if (oldState == Phone.State.IDLE && oldState != state) {
            //voiceCallStartedRegistrants.notifyRegistrants (
                    //new AsyncResult(null, null, null));
        //}
        //if (state != oldState) {
            //phone.notifyPhoneStateChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.240 -0400", hash_original_method = "A78B57299010875BB723A4D535396EB8", hash_generated_method = "7565AF133E7DEB5800B4E983E3CD3CE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void handlePollCalls(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
        List polledCalls;
        {
            polledCalls = (List)ar.result;
        } //End block
        {
            boolean varC4DBE3EAF9ED931A30C22A297B6E685B_832136028 = (isCommandExceptionRadioNotAvailable(ar.exception));
            {
                polledCalls = new ArrayList();
            } //End block
            {
                pollCallsAfterDelay();
            } //End block
        } //End collapsed parenthetic
        Connection newRinging;
        newRinging = null;
        boolean hasNonHangupStateChanged;
        hasNonHangupStateChanged = false;
        boolean needsPollDelay;
        needsPollDelay = false;
        boolean unknownConnectionAppeared;
        unknownConnectionAppeared = false;
        {
            int i, curDC, dcSize;
            i = 0;
            curDC = 0;
            dcSize = polledCalls.size();
            {
                GsmConnection conn;
                conn = connections[i];
                DriverCall dc;
                dc = null;
                {
                    dc = (DriverCall) polledCalls.get(curDC);
                    {
                        dc = null;
                    } //End block
                } //End block
                log("poll: conn[i=" + i + "]=" +
                    conn+", dc=" + dc);
                {
                    {
                        boolean varA12D38D4E3C5051B181541F930988B8A_1335180874 = (pendingMO != null && pendingMO.compareTo(dc));
                        {
                            log("poll: pendingMO=" + pendingMO);
                            connections[i] = pendingMO;
                            pendingMO.index = i;
                            pendingMO.update(dc);
                            pendingMO = null;
                            {
                                hangupPendingMO = false;
                                try 
                                {
                                    log(
                                    "poll: hangupPendingMO, hangup conn " + i);
                                    hangup(connections[i]);
                                } //End block
                                catch (CallStateException ex)
                                { }
                            } //End block
                        } //End block
                        {
                            connections[i] = new GsmConnection(phone.getContext(), dc, this, i);
                            {
                                boolean var1A7DB31704BA2A2212C3A4154703B0F3_1261473900 = (connections[i].getCall() == ringingCall);
                                {
                                    newRinging = connections[i];
                                } //End block
                                {
                                    {
                                        connections[i].connectTime = System.currentTimeMillis();
                                    } //End block
                                    unknownConnectionAppeared = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    hasNonHangupStateChanged = true;
                } //End block
                {
                    droppedDuringPoll.add(conn);
                    connections[i] = null;
                } //End block
                {
                    boolean varC2404C6DFC902F1EC0F3E92AD8CACF6A_1999869302 = (conn != null && dc != null && !conn.compareTo(dc));
                    {
                        droppedDuringPoll.add(conn);
                        connections[i] = new GsmConnection (phone.getContext(), dc, this, i);
                        {
                            boolean varD5FA4DA71F757DFE67753F4F7656FF67_1813289500 = (connections[i].getCall() == ringingCall);
                            {
                                newRinging = connections[i];
                            } //End block
                        } //End collapsed parenthetic
                        hasNonHangupStateChanged = true;
                    } //End block
                    {
                        boolean changed;
                        changed = conn.update(dc);
                        hasNonHangupStateChanged = hasNonHangupStateChanged || changed;
                    } //End block
                } //End collapsed parenthetic
                {
                    {
                        {
                            needsPollDelay = true;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            Log.d(LOG_TAG,"Pending MO dropped before poll fg state:"
                            + foregroundCall.getState());
            droppedDuringPoll.add(pendingMO);
            pendingMO = null;
            hangupPendingMO = false;
        } //End block
        {
            phone.notifyNewRingingConnection(newRinging);
        } //End block
        {
            int i;
            i = droppedDuringPoll.size() - 1;
            {
                GsmConnection conn;
                conn = droppedDuringPoll.get(i);
                {
                    boolean var8064D1618E098621AFE888A1369217F2_971529645 = (conn.isIncoming() && conn.getConnectTime() == 0);
                    {
                        Connection.DisconnectCause cause;
                        {
                            cause = Connection.DisconnectCause.INCOMING_REJECTED;
                        } //End block
                        {
                            cause = Connection.DisconnectCause.INCOMING_MISSED;
                        } //End block
                        {
                            log("missed/rejected call, conn.cause=" + conn.cause);
                            log("setting cause to " + cause);
                        } //End block
                        droppedDuringPoll.remove(i);
                        conn.onDisconnect(cause);
                    } //End block
                    {
                        droppedDuringPoll.remove(i);
                        conn.onDisconnect(Connection.DisconnectCause.LOCAL);
                    } //End block
                    {
                        droppedDuringPoll.remove(i);
                        conn.onDisconnect(Connection.DisconnectCause.INVALID_NUMBER);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA25616F2AD7C98E00F706161A5B687F7_1370008358 = (droppedDuringPoll.size() > 0);
            {
                cm.getLastCallFailCause(
                obtainNoPollCompleteMessage(EVENT_GET_LAST_CALL_FAIL_CAUSE));
            } //End block
        } //End collapsed parenthetic
        {
            pollCallsAfterDelay();
        } //End block
        {
            internalClearDisconnected();
        } //End block
        updatePhoneState();
        {
            phone.notifyUnknownConnection();
        } //End block
        {
            phone.notifyPreciseCallStateChanged();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.240 -0400", hash_original_method = "6E2D3B844106C3BA4166C29F96BB7EA0", hash_generated_method = "3D35CA8E198B65065816E56AAB25BAB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleRadioNotAvailable() {
        pollCallsWhenSafe();
        // ---------- Original Method ----------
        //pollCallsWhenSafe();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.241 -0400", hash_original_method = "91645E150D46BD14FDADA00369A88470", hash_generated_method = "C073A964DB607782C688002C3269E68F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dumpState() {
        List l;
        l = ringingCall.getConnections();
        {
            int i, s;
            i = 0;
            s = l.size();
        } //End collapsed parenthetic
        l = foregroundCall.getConnections();
        {
            int i, s;
            i = 0;
            s = l.size();
        } //End collapsed parenthetic
        l = backgroundCall.getConnections();
        {
            int i, s;
            i = 0;
            s = l.size();
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //List l;
        //Log.i(LOG_TAG,"Phone State:" + state);
        //Log.i(LOG_TAG,"Ringing call: " + ringingCall.toString());
        //l = ringingCall.getConnections();
        //for (int i = 0, s = l.size(); i < s; i++) {
            //Log.i(LOG_TAG,l.get(i).toString());
        //}
        //Log.i(LOG_TAG,"Foreground call: " + foregroundCall.toString());
        //l = foregroundCall.getConnections();
        //for (int i = 0, s = l.size(); i < s; i++) {
            //Log.i(LOG_TAG,l.get(i).toString());
        //}
        //Log.i(LOG_TAG,"Background call: " + backgroundCall.toString());
        //l = backgroundCall.getConnections();
        //for (int i = 0, s = l.size(); i < s; i++) {
            //Log.i(LOG_TAG,l.get(i).toString());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.241 -0400", hash_original_method = "9804562F218584F49F1000DB30741809", hash_generated_method = "D2D6D8FEECEBD7525A54D6CACA7B4816")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void hangup(GsmConnection conn) throws CallStateException {
        dsTaint.addTaint(conn.dsTaint);
        {
            boolean var7B293A7D3CB476B7EF41E01A5B6DD8B4_2058897134 = (conn.owner != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException ("GsmConnection " + conn
                                    + "does not belong to GsmCallTracker " + this);
            } //End block
        } //End collapsed parenthetic
        {
            log("hangup: set hangupPendingMO to true");
            hangupPendingMO = true;
        } //End block
        {
            try 
            {
                cm.hangupConnection (conn.getGSMIndex(), obtainCompleteMessage());
            } //End block
            catch (CallStateException ex)
            { }
        } //End block
        conn.onHangupLocal();
        // ---------- Original Method ----------
        //if (conn.owner != this) {
            //throw new CallStateException ("GsmConnection " + conn
                                    //+ "does not belong to GsmCallTracker " + this);
        //}
        //if (conn == pendingMO) {
            //if (Phone.DEBUG_PHONE) log("hangup: set hangupPendingMO to true");
            //hangupPendingMO = true;
        //} else {
            //try {
                //cm.hangupConnection (conn.getGSMIndex(), obtainCompleteMessage());
            //} catch (CallStateException ex) {
                //Log.w(LOG_TAG,"GsmCallTracker WARN: hangup() on absent connection "
                                //+ conn);
            //}
        //}
        //conn.onHangupLocal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.241 -0400", hash_original_method = "47E4845D8AA8A793249B2C364233C700", hash_generated_method = "3C7F90E914BB051E4B9775866F2FA544")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void separate(GsmConnection conn) throws CallStateException {
        dsTaint.addTaint(conn.dsTaint);
        {
            boolean var7B293A7D3CB476B7EF41E01A5B6DD8B4_2034404123 = (conn.owner != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException ("GsmConnection " + conn
                                    + "does not belong to GsmCallTracker " + this);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            cm.separateConnection (conn.getGSMIndex(),
                obtainCompleteMessage(EVENT_SEPARATE_RESULT));
        } //End block
        catch (CallStateException ex)
        { }
        // ---------- Original Method ----------
        //if (conn.owner != this) {
            //throw new CallStateException ("GsmConnection " + conn
                                    //+ "does not belong to GsmCallTracker " + this);
        //}
        //try {
            //cm.separateConnection (conn.getGSMIndex(),
                //obtainCompleteMessage(EVENT_SEPARATE_RESULT));
        //} catch (CallStateException ex) {
            //Log.w(LOG_TAG,"GsmCallTracker WARN: separate() on absent connection "
                          //+ conn);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.241 -0400", hash_original_method = "8E7DA06B8727FE7EBCD155EA09819106", hash_generated_method = "CA89AD40243CEB287C301CF244F264F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setMute(boolean mute) {
        dsTaint.addTaint(mute);
        cm.setMute(desiredMute, null);
        // ---------- Original Method ----------
        //desiredMute = mute;
        //cm.setMute(desiredMute, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.241 -0400", hash_original_method = "11907D6A9C6D8F23B8C0FECA1425D0D1", hash_generated_method = "3229FE3A084EE46BBD7A13C15D060343")
    @DSModeled(DSC.SAFE)
     boolean getMute() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return desiredMute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.242 -0400", hash_original_method = "2269CD2B285766A5A3A0163535ACAF72", hash_generated_method = "6842FE4A7B789E8EFA2940A4EAE64855")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void hangup(GsmCall call) throws CallStateException {
        dsTaint.addTaint(call.dsTaint);
        {
            boolean varE4A326D5F85A22F10F9645DF8E94C259_1606336537 = (call.getConnections().size() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("no connections in call");
            } //End block
        } //End collapsed parenthetic
        {
            log("(ringing) hangup waiting or background");
            cm.hangupWaitingOrBackground(obtainCompleteMessage());
        } //End block
        {
            {
                boolean var22C48955666B247FCD89E865FCE21904_675200750 = (call.isDialingOrAlerting());
                {
                    {
                        log("(foregnd) hangup dialing or alerting...");
                    } //End block
                    hangup((GsmConnection)(call.getConnections().get(0)));
                } //End block
                {
                    hangupForegroundResumeBackground();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varA4A4A8F760ECA28FD2366D22B56B66BD_956838906 = (ringingCall.isRinging());
                {
                    {
                        log("hangup all conns in background call");
                    } //End block
                    hangupAllConnections(call);
                } //End block
                {
                    hangupWaitingOrBackground();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("GsmCall " + call +
                    "does not belong to GsmCallTracker " + this);
        } //End block
        call.onHangupLocal();
        phone.notifyPreciseCallStateChanged();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.242 -0400", hash_original_method = "E840FBD61F8E6AF3DE802E32C39DD93E", hash_generated_method = "4AF2AF2C1AF283F2B3D66EB92EFBBE89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void hangupWaitingOrBackground() {
        log("hangupWaitingOrBackground");
        cm.hangupWaitingOrBackground(obtainCompleteMessage());
        // ---------- Original Method ----------
        //if (Phone.DEBUG_PHONE) log("hangupWaitingOrBackground");
        //cm.hangupWaitingOrBackground(obtainCompleteMessage());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.242 -0400", hash_original_method = "D10B26113142441F52E905015040129F", hash_generated_method = "939D43994EC933107D2D3D9C50AF847D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void hangupForegroundResumeBackground() {
        log("hangupForegroundResumeBackground");
        cm.hangupForegroundResumeBackground(obtainCompleteMessage());
        // ---------- Original Method ----------
        //if (Phone.DEBUG_PHONE) log("hangupForegroundResumeBackground");
        //cm.hangupForegroundResumeBackground(obtainCompleteMessage());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.242 -0400", hash_original_method = "5F5FEE0C434961483150E08A4EE95AC6", hash_generated_method = "4FD227836BC56455A72B7E6BEC5E85AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void hangupConnectionByIndex(GsmCall call, int index) throws CallStateException {
        dsTaint.addTaint(call.dsTaint);
        dsTaint.addTaint(index);
        int count;
        count = call.connections.size();
        {
            int i;
            i = 0;
            {
                GsmConnection cn;
                cn = (GsmConnection)call.connections.get(i);
                {
                    boolean var6C5E404038FAF2293FAD72C57927DF35_63027721 = (cn.getGSMIndex() == index);
                    {
                        cm.hangupConnection(index, obtainCompleteMessage());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new CallStateException("no gsm index found");
        // ---------- Original Method ----------
        //int count = call.connections.size();
        //for (int i = 0; i < count; i++) {
            //GsmConnection cn = (GsmConnection)call.connections.get(i);
            //if (cn.getGSMIndex() == index) {
                //cm.hangupConnection(index, obtainCompleteMessage());
                //return;
            //}
        //}
        //throw new CallStateException("no gsm index found");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.243 -0400", hash_original_method = "F41FC136282F9A01160C0582CC307C0B", hash_generated_method = "6405B9F19D98A43E5D12311C91BDC801")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void hangupAllConnections(GsmCall call) throws CallStateException {
        dsTaint.addTaint(call.dsTaint);
        try 
        {
            int count;
            count = call.connections.size();
            {
                int i;
                i = 0;
                {
                    GsmConnection cn;
                    cn = (GsmConnection)call.connections.get(i);
                    cm.hangupConnection(cn.getGSMIndex(), obtainCompleteMessage());
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (CallStateException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //int count = call.connections.size();
            //for (int i = 0; i < count; i++) {
                //GsmConnection cn = (GsmConnection)call.connections.get(i);
                //cm.hangupConnection(cn.getGSMIndex(), obtainCompleteMessage());
            //}
        //} catch (CallStateException ex) {
            //Log.e(LOG_TAG, "hangupConnectionByIndex caught " + ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.243 -0400", hash_original_method = "A13EE98B51441FF2D592407455BBCDEE", hash_generated_method = "7981D69CDAE5E0A9D9E05DB6C5089B5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     GsmConnection getConnectionByIndex(GsmCall call, int index) throws CallStateException {
        dsTaint.addTaint(call.dsTaint);
        dsTaint.addTaint(index);
        int count;
        count = call.connections.size();
        {
            int i;
            i = 0;
            {
                GsmConnection cn;
                cn = (GsmConnection)call.connections.get(i);
                {
                    boolean var6C5E404038FAF2293FAD72C57927DF35_1944543230 = (cn.getGSMIndex() == index);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (GsmConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int count = call.connections.size();
        //for (int i = 0; i < count; i++) {
            //GsmConnection cn = (GsmConnection)call.connections.get(i);
            //if (cn.getGSMIndex() == index) {
                //return cn;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.243 -0400", hash_original_method = "65CD53B5AAA831AF61B9937ED3D66C8B", hash_generated_method = "7BA4FBB17ED23263557C8C2DAC280B9A")
    @DSModeled(DSC.SAFE)
    private Phone.SuppService getFailedService(int what) {
        dsTaint.addTaint(what);
        return (Phone.SuppService)dsTaint.getTaint();
        // ---------- Original Method ----------
        //switch (what) {
            //case EVENT_SWITCH_RESULT:
                //return Phone.SuppService.SWITCH;
            //case EVENT_CONFERENCE_RESULT:
                //return Phone.SuppService.CONFERENCE;
            //case EVENT_SEPARATE_RESULT:
                //return Phone.SuppService.SEPARATE;
            //case EVENT_ECT_RESULT:
                //return Phone.SuppService.TRANSFER;
        //}
        //return Phone.SuppService.UNKNOWN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.245 -0400", hash_original_method = "3557310B73CAAA9AAFCC17D1978C55CA", hash_generated_method = "9EDB5BF565419B113EB457DDC1AF8340")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        AsyncResult ar;
        //Begin case EVENT_POLL_CALLS_RESULT 
        ar = (AsyncResult)msg.obj;
        //End case EVENT_POLL_CALLS_RESULT 
        //Begin case EVENT_POLL_CALLS_RESULT 
        {
            log(
                            "handle EVENT_POLL_CALL_RESULT: set needsPoll=F");
            needsPoll = false;
            lastRelevantPoll = null;
            handlePollCalls((AsyncResult)msg.obj);
        } //End block
        //End case EVENT_POLL_CALLS_RESULT 
        //Begin case EVENT_OPERATION_COMPLETE 
        ar = (AsyncResult)msg.obj;
        //End case EVENT_OPERATION_COMPLETE 
        //Begin case EVENT_OPERATION_COMPLETE 
        operationComplete();
        //End case EVENT_OPERATION_COMPLETE 
        //Begin case EVENT_SWITCH_RESULT EVENT_CONFERENCE_RESULT EVENT_SEPARATE_RESULT EVENT_ECT_RESULT 
        ar = (AsyncResult)msg.obj;
        //End case EVENT_SWITCH_RESULT EVENT_CONFERENCE_RESULT EVENT_SEPARATE_RESULT EVENT_ECT_RESULT 
        //Begin case EVENT_SWITCH_RESULT EVENT_CONFERENCE_RESULT EVENT_SEPARATE_RESULT EVENT_ECT_RESULT 
        {
            phone.notifySuppServiceFailed(getFailedService(msg.what));
        } //End block
        //End case EVENT_SWITCH_RESULT EVENT_CONFERENCE_RESULT EVENT_SEPARATE_RESULT EVENT_ECT_RESULT 
        //Begin case EVENT_SWITCH_RESULT EVENT_CONFERENCE_RESULT EVENT_SEPARATE_RESULT EVENT_ECT_RESULT 
        operationComplete();
        //End case EVENT_SWITCH_RESULT EVENT_CONFERENCE_RESULT EVENT_SEPARATE_RESULT EVENT_ECT_RESULT 
        //Begin case EVENT_GET_LAST_CALL_FAIL_CAUSE 
        int causeCode;
        //End case EVENT_GET_LAST_CALL_FAIL_CAUSE 
        //Begin case EVENT_GET_LAST_CALL_FAIL_CAUSE 
        ar = (AsyncResult)msg.obj;
        //End case EVENT_GET_LAST_CALL_FAIL_CAUSE 
        //Begin case EVENT_GET_LAST_CALL_FAIL_CAUSE 
        operationComplete();
        //End case EVENT_GET_LAST_CALL_FAIL_CAUSE 
        //Begin case EVENT_GET_LAST_CALL_FAIL_CAUSE 
        {
            causeCode = CallFailCause.NORMAL_CLEARING;
        } //End block
        {
            causeCode = ((int[])ar.result)[0];
        } //End block
        //End case EVENT_GET_LAST_CALL_FAIL_CAUSE 
        //Begin case EVENT_GET_LAST_CALL_FAIL_CAUSE 
        {
            GsmCellLocation loc;
            loc = ((GsmCellLocation)phone.getCellLocation());
            EventLog.writeEvent(EventLogTags.CALL_DROP,
                            causeCode, loc != null ? loc.getCid() : -1,
                            TelephonyManager.getDefault().getNetworkType());
        } //End block
        //End case EVENT_GET_LAST_CALL_FAIL_CAUSE 
        //Begin case EVENT_GET_LAST_CALL_FAIL_CAUSE 
        {
            int i, s;
            i = 0;
            s = droppedDuringPoll.size();
            {
                GsmConnection conn;
                conn = droppedDuringPoll.get(i);
                conn.onRemoteDisconnect(causeCode);
            } //End block
        } //End collapsed parenthetic
        //End case EVENT_GET_LAST_CALL_FAIL_CAUSE 
        //Begin case EVENT_GET_LAST_CALL_FAIL_CAUSE 
        updatePhoneState();
        //End case EVENT_GET_LAST_CALL_FAIL_CAUSE 
        //Begin case EVENT_GET_LAST_CALL_FAIL_CAUSE 
        phone.notifyPreciseCallStateChanged();
        //End case EVENT_GET_LAST_CALL_FAIL_CAUSE 
        //Begin case EVENT_GET_LAST_CALL_FAIL_CAUSE 
        droppedDuringPoll.clear();
        //End case EVENT_GET_LAST_CALL_FAIL_CAUSE 
        //Begin case EVENT_REPOLL_AFTER_DELAY EVENT_CALL_STATE_CHANGE 
        pollCallsWhenSafe();
        //End case EVENT_REPOLL_AFTER_DELAY EVENT_CALL_STATE_CHANGE 
        //Begin case EVENT_RADIO_AVAILABLE 
        handleRadioAvailable();
        //End case EVENT_RADIO_AVAILABLE 
        //Begin case EVENT_RADIO_NOT_AVAILABLE 
        handleRadioNotAvailable();
        //End case EVENT_RADIO_NOT_AVAILABLE 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.245 -0400", hash_original_method = "00058CA5481BD8963FA4008BDE768325", hash_generated_method = "B0052EC81B596994444F6D8EE8AE0023")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void log(String msg) {
        dsTaint.addTaint(msg);
        Log.d(LOG_TAG, "[GsmCallTracker] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[GsmCallTracker] " + msg);
    }

    
    static final String LOG_TAG = "GSM";
    private static final boolean REPEAT_POLLING = false;
    private static final boolean DBG_POLL = false;
    static final int MAX_CONNECTIONS = 7;
    static final int MAX_CONNECTIONS_PER_CALL = 5;
}

