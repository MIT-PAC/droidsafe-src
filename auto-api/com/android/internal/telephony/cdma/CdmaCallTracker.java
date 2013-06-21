package com.android.internal.telephony.cdma;

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
import android.telephony.PhoneNumberUtils;
import android.telephony.ServiceState;
import android.util.Log;
import android.os.SystemProperties;
import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.CallTracker;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.DriverCall;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.TelephonyProperties;
import java.util.ArrayList;
import java.util.List;

public final class CdmaCallTracker extends CallTracker {
    CdmaConnection connections[] = new CdmaConnection[MAX_CONNECTIONS];
    RegistrantList voiceCallEndedRegistrants = new RegistrantList();
    RegistrantList voiceCallStartedRegistrants = new RegistrantList();
    RegistrantList callWaitingRegistrants =  new RegistrantList();
    ArrayList<CdmaConnection> droppedDuringPoll
        = new ArrayList<CdmaConnection>(MAX_CONNECTIONS);
    CdmaCall ringingCall = new CdmaCall(this);
    CdmaCall foregroundCall = new CdmaCall(this);
    CdmaCall backgroundCall = new CdmaCall(this);
    CdmaConnection pendingMO;
    boolean hangupPendingMO;
    boolean pendingCallInEcm=false;
    boolean mIsInEmergencyCall = false;
    CDMAPhone phone;
    boolean desiredMute = false;
    int pendingCallClirMode;
    Phone.State state = Phone.State.IDLE;
    private boolean mIsEcmTimerCanceled = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.280 -0400", hash_original_method = "D7E78FBD4DB8C2DC376D4ABE79BA3592", hash_generated_method = "537B468237AF83045BD699627D95652A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CdmaCallTracker(CDMAPhone phone) {
        dsTaint.addTaint(phone.dsTaint);
        cm = phone.mCM;
        cm.registerForCallStateChanged(this, EVENT_CALL_STATE_CHANGE, null);
        cm.registerForOn(this, EVENT_RADIO_AVAILABLE, null);
        cm.registerForNotAvailable(this, EVENT_RADIO_NOT_AVAILABLE, null);
        cm.registerForCallWaitingInfo(this, EVENT_CALL_WAITING_INFO_CDMA, null);
        foregroundCall.setGeneric(false);
        // ---------- Original Method ----------
        //this.phone = phone;
        //cm = phone.mCM;
        //cm.registerForCallStateChanged(this, EVENT_CALL_STATE_CHANGE, null);
        //cm.registerForOn(this, EVENT_RADIO_AVAILABLE, null);
        //cm.registerForNotAvailable(this, EVENT_RADIO_NOT_AVAILABLE, null);
        //cm.registerForCallWaitingInfo(this, EVENT_CALL_WAITING_INFO_CDMA, null);
        //foregroundCall.setGeneric(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.284 -0400", hash_original_method = "2338338535849E159E02E311688F6BB3", hash_generated_method = "D5FF530FAE6148559B81D38F3B210670")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispose() {
        cm.unregisterForCallStateChanged(this);
        cm.unregisterForOn(this);
        cm.unregisterForNotAvailable(this);
        cm.unregisterForCallWaitingInfo(this);
        {
            CdmaConnection c = connections[0];
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
        //cm.unregisterForCallWaitingInfo(this);
        //for(CdmaConnection c : connections) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.284 -0400", hash_original_method = "73544050C1854D0258F226F7B919F554", hash_generated_method = "B58278D50A7470E880C8DDDBFC5E6BDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() {
        Log.d(LOG_TAG, "CdmaCallTracker finalized");
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "CdmaCallTracker finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.284 -0400", hash_original_method = "A19F9CA037C5D9E07B1DD2AD491B323A", hash_generated_method = "7C25EFFBF23A057173B8AE4B186A8609")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForVoiceCallStarted(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant(h, what, obj);
        voiceCallStartedRegistrants.add(r);
        {
            r.notifyRegistrant(new AsyncResult(null, null, null));
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //voiceCallStartedRegistrants.add(r);
        //if (state != Phone.State.IDLE) {
            //r.notifyRegistrant(new AsyncResult(null, null, null));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.285 -0400", hash_original_method = "3C910908B4B98998A7936D8F8AE4D170", hash_generated_method = "080D8A6C55C5F5E6022A9978B521C166")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForVoiceCallStarted(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        voiceCallStartedRegistrants.remove(h);
        // ---------- Original Method ----------
        //voiceCallStartedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.285 -0400", hash_original_method = "D7F70C00A904DE96D26BDF7C49F41DAA", hash_generated_method = "5DCF28D8516CF4D9576AAD84014793DB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.285 -0400", hash_original_method = "91176AF98778238DB3B453F2FC7D9448", hash_generated_method = "34FF2F021EB97611BF23342BD7861149")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForVoiceCallEnded(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        voiceCallEndedRegistrants.remove(h);
        // ---------- Original Method ----------
        //voiceCallEndedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.285 -0400", hash_original_method = "F34086F28C205DD5876302448C7FB8FC", hash_generated_method = "BF7D83AE4EF116A92D9B6DC779729659")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForCallWaiting(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        callWaitingRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //callWaitingRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.285 -0400", hash_original_method = "F71574762174031DAD3F3CD1050F608A", hash_generated_method = "2B0B44D726F5450829D3BA09DD98BE49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForCallWaiting(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        callWaitingRegistrants.remove(h);
        // ---------- Original Method ----------
        //callWaitingRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.286 -0400", hash_original_method = "B11C1D24F61F5A9ABEB7D187928BEC26", hash_generated_method = "0BF56C9614228D61B7B44ECA58BECD59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void fakeHoldForegroundBeforeDial() {
        List<Connection> connCopy;
        connCopy = (List<Connection>) foregroundCall.connections.clone();
        {
            int i, s;
            i = 0;
            s = connCopy.size();
            {
                CdmaConnection conn;
                conn = (CdmaConnection)connCopy.get(i);
                conn.fakeHoldBeforeDial();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //List<Connection> connCopy;
        //connCopy = (List<Connection>) foregroundCall.connections.clone();
        //for (int i = 0, s = connCopy.size() ; i < s ; i++) {
            //CdmaConnection conn = (CdmaConnection)connCopy.get(i);
            //conn.fakeHoldBeforeDial();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.286 -0400", hash_original_method = "FEC4E6BC08FD10A2C518984DAAD113C7", hash_generated_method = "CE8EA5640AACC5CD80A8F59E5FB6B0E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Connection dial(String dialString, int clirMode) throws CallStateException {
        dsTaint.addTaint(clirMode);
        dsTaint.addTaint(dialString);
        clearDisconnected();
        {
            boolean var37336DD64F87D8D8C5FEC219FB8725E9_516231649 = (!canDial());
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("cannot dial in current state");
            } //End block
        } //End collapsed parenthetic
        String inEcm;
        inEcm = SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
        boolean isPhoneInEcmMode;
        isPhoneInEcmMode = inEcm.equals("true");
        boolean isEmergencyCall;
        isEmergencyCall = PhoneNumberUtils.isLocalEmergencyNumber(dialString, phone.getContext());
        {
            handleEcmTimer(phone.CANCEL_ECM_TIMER);
        } //End block
        foregroundCall.setGeneric(false);
        {
            boolean varDDB23760708DF607FE68BBA82BCF4745_370993244 = (foregroundCall.getState() == CdmaCall.State.ACTIVE);
            {
                Connection var44405B44360BAD1A928DEFD83870BBF3_1460060786 = (dialThreeWay(dialString));
            } //End block
        } //End collapsed parenthetic
        pendingMO = new CdmaConnection(phone.getContext(), dialString, this, foregroundCall);
        hangupPendingMO = false;
        {
            boolean varE9C786784B3495FF438205BDA3869C7F_625227315 = (pendingMO.address == null || pendingMO.address.length() == 0
            || pendingMO.address.indexOf(PhoneNumberUtils.WILD) >= 0);
            {
                pendingMO.cause = Connection.DisconnectCause.INVALID_NUMBER;
                pollCallsWhenSafe();
            } //End block
            {
                setMute(false);
                disableDataCallInEmergencyCall(dialString);
                {
                    cm.dial(pendingMO.address, clirMode, obtainCompleteMessage());
                } //End block
                {
                    phone.exitEmergencyCallbackMode();
                    phone.setOnEcbModeExitResponse(this,EVENT_EXIT_ECM_RESPONSE_CDMA, null);
                    pendingCallInEcm=true;
                } //End block
            } //End block
        } //End collapsed parenthetic
        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.286 -0400", hash_original_method = "916DB4F3BDDE26A491E1178653223CEE", hash_generated_method = "2426D5D0B9C27177B35B86BF14B47A6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Connection dial(String dialString) throws CallStateException {
        dsTaint.addTaint(dialString);
        Connection varF27BA779A30C77135EDA83AB7524D1F4_559691376 = (dial(dialString, CommandsInterface.CLIR_DEFAULT));
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return dial(dialString, CommandsInterface.CLIR_DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.287 -0400", hash_original_method = "88840CD76FEAD0D0B90DCB96EA4A4A27", hash_generated_method = "597C829CA57EF40E1DD8A95C51654E52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Connection dialThreeWay(String dialString) {
        dsTaint.addTaint(dialString);
        {
            boolean var88B3B730B5A85C1DC3D65F3B8BB9AFF3_1486361787 = (!foregroundCall.isIdle());
            {
                disableDataCallInEmergencyCall(dialString);
                pendingMO = new CdmaConnection(phone.getContext(),
                                dialString, this, foregroundCall);
                cm.sendCDMAFeatureCode(pendingMO.address,
                obtainMessage(EVENT_THREE_WAY_DIAL_L2_RESULT_CDMA));
            } //End block
        } //End collapsed parenthetic
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!foregroundCall.isIdle()) {
            //disableDataCallInEmergencyCall(dialString);
            //pendingMO = new CdmaConnection(phone.getContext(),
                                //dialString, this, foregroundCall);
            //cm.sendCDMAFeatureCode(pendingMO.address,
                //obtainMessage(EVENT_THREE_WAY_DIAL_L2_RESULT_CDMA));
            //return pendingMO;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.287 -0400", hash_original_method = "A15B8A9C3B79A061845560CDFB3D1962", hash_generated_method = "521992140B86EB51B4589F9566DD4AD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void acceptCall() throws CallStateException {
        {
            boolean varC632C7B3E7E960D500E2F5ADC8B810C7_15700630 = (ringingCall.getState() == CdmaCall.State.INCOMING);
            {
                setMute(false);
                cm.acceptCall(obtainCompleteMessage());
            } //End block
            {
                boolean var6ABDCF912133D1B5B5A8B213BEB61799_625133869 = (ringingCall.getState() == CdmaCall.State.WAITING);
                {
                    CdmaConnection cwConn;
                    cwConn = (CdmaConnection)(ringingCall.getLatestConnection());
                    cwConn.updateParent(ringingCall, foregroundCall);
                    cwConn.onConnectedInOrOut();
                    updatePhoneState();
                    switchWaitingOrHoldingAndActive();
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new CallStateException("phone not ringing");
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (ringingCall.getState() == CdmaCall.State.INCOMING) {
            //Log.i("phone", "acceptCall: incoming...");
            //setMute(false);
            //cm.acceptCall(obtainCompleteMessage());
        //} else if (ringingCall.getState() == CdmaCall.State.WAITING) {
            //CdmaConnection cwConn = (CdmaConnection)(ringingCall.getLatestConnection());
            //cwConn.updateParent(ringingCall, foregroundCall);
            //cwConn.onConnectedInOrOut();
            //updatePhoneState();
            //switchWaitingOrHoldingAndActive();
        //} else {
            //throw new CallStateException("phone not ringing");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.287 -0400", hash_original_method = "9B02E01190499DD77CD223AD7831C55B", hash_generated_method = "A24D6A33B7F4BB2B430AE6060145DA56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void rejectCall() throws CallStateException {
        {
            boolean var2DE25B4C7BD786874002695E4305AD0A_1358899257 = (ringingCall.getState().isRinging());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.287 -0400", hash_original_method = "4E2E600B83947FE548823E8A00BDC609", hash_generated_method = "FF4ACF9844E9ECB8FC1852763EECAF10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void switchWaitingOrHoldingAndActive() throws CallStateException {
        {
            boolean varC632C7B3E7E960D500E2F5ADC8B810C7_545520750 = (ringingCall.getState() == CdmaCall.State.INCOMING);
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("cannot be in the incoming state");
            } //End block
            {
                boolean var648F610A170CD29A32E13B581B3027F2_982906381 = (foregroundCall.getConnections().size() > 1);
                {
                    flashAndSetGenericTrue();
                } //End block
                {
                    cm.sendCDMAFeatureCode("", obtainMessage(EVENT_SWITCH_RESULT));
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (ringingCall.getState() == CdmaCall.State.INCOMING) {
            //throw new CallStateException("cannot be in the incoming state");
        //} else if (foregroundCall.getConnections().size() > 1) {
            //flashAndSetGenericTrue();
        //} else {
            //cm.sendCDMAFeatureCode("", obtainMessage(EVENT_SWITCH_RESULT));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.288 -0400", hash_original_method = "B1073FCDB805CE663445BC5D803D76AA", hash_generated_method = "90ECDE91CEB46AEDFA1995478C6494BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void conference() throws CallStateException {
        flashAndSetGenericTrue();
        // ---------- Original Method ----------
        //flashAndSetGenericTrue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.288 -0400", hash_original_method = "B9B58214FE30DEB2D41379B25D88E6DD", hash_generated_method = "91DDF637F580C2F12D44ADB525F30440")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void explicitCallTransfer() throws CallStateException {
        cm.explicitCallTransfer(obtainCompleteMessage(EVENT_ECT_RESULT));
        // ---------- Original Method ----------
        //cm.explicitCallTransfer(obtainCompleteMessage(EVENT_ECT_RESULT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.288 -0400", hash_original_method = "89E1881B087BAA2C040FAFD444B532DA", hash_generated_method = "93C10D32BFEAACBDB937011534F3F686")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.288 -0400", hash_original_method = "885B69631C6ACC1E38924306F8EB7459", hash_generated_method = "21E7105F729464D90A072ADDDA7778B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean canConference() {
        boolean varA1CCEEF4312D253306B2C816C3DB70CE_39258079 = (foregroundCall.getState() == CdmaCall.State.ACTIVE
                && backgroundCall.getState() == CdmaCall.State.HOLDING
                && !backgroundCall.isFull()
                && !foregroundCall.isFull());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return foregroundCall.getState() == CdmaCall.State.ACTIVE
                //&& backgroundCall.getState() == CdmaCall.State.HOLDING
                //&& !backgroundCall.isFull()
                //&& !foregroundCall.isFull();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.289 -0400", hash_original_method = "DFFE89A6FC85DFAF69854FF09292A4CC", hash_generated_method = "EDC2BC0E7C99A47D8CA2668A6CAE8EE3")
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
                    || (foregroundCall.getState() == CdmaCall.State.ACTIVE)
                    || !backgroundCall.getState().isAlive());
        {
            log(String.format("canDial is false\n" +
                              "((serviceState=%d) != ServiceState.STATE_POWER_OFF)::=%s\n" +
                              "&& pendingMO == null::=%s\n" +
                              "&& !ringingCall.isRinging()::=%s\n" +
                              "&& !disableCall.equals(\"true\")::=%s\n" +
                              "&& (!foregroundCall.getState().isAlive()::=%s\n" +
                              "   || foregroundCall.getState() == CdmaCall.State.ACTIVE::=%s\n" +
                              "   ||!backgroundCall.getState().isAlive())::=%s)",
                    serviceState,
                    serviceState != ServiceState.STATE_POWER_OFF,
                    pendingMO == null,
                    !ringingCall.isRinging(),
                    !disableCall.equals("true"),
                    !foregroundCall.getState().isAlive(),
                    foregroundCall.getState() == CdmaCall.State.ACTIVE,
                    !backgroundCall.getState().isAlive()));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.289 -0400", hash_original_method = "F828A2F1845194FFD82C471D7E89F726", hash_generated_method = "00C12B560F9DEAF627ADCB3EDD357F60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean canTransfer() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "canTransfer: not possible in CDMA");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.289 -0400", hash_original_method = "3058DCAC5E1117AE07A379578E7C6A20", hash_generated_method = "F0E9C736A8A4591368CEECFAB84F530D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.289 -0400", hash_original_method = "89F67FF5AFAE8FAD9F556239F3E27159", hash_generated_method = "76A55C6D01E100391AE07C87C24C485E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Message obtainCompleteMessage() {
        Message var0A1D62473424F1503E7644788869EEA5_1621980613 = (obtainCompleteMessage(EVENT_OPERATION_COMPLETE));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return obtainCompleteMessage(EVENT_OPERATION_COMPLETE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.289 -0400", hash_original_method = "F527C5C3DD4F0176588A0C261AD76B7A", hash_generated_method = "1A38660C55DD6E6E19BAFB8AE685081A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Message obtainCompleteMessage(int what) {
        dsTaint.addTaint(what);
        lastRelevantPoll = null;
        needsPoll = true;
        log("obtainCompleteMessage: pendingOperations=" +
                pendingOperations + ", needsPoll=" + needsPoll);
        Message varC26248E20512DCE6AF1BDB5EAD201F8B_826677964 = (obtainMessage(what));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //pendingOperations++;
        //lastRelevantPoll = null;
        //needsPoll = true;
        //if (DBG_POLL) log("obtainCompleteMessage: pendingOperations=" +
                //pendingOperations + ", needsPoll=" + needsPoll);
        //return obtainMessage(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.290 -0400", hash_original_method = "179E11A88A956D6661DD344814FD0D33", hash_generated_method = "21D885F66B272BE8E1EC799AD882A619")
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
            //Log.e(LOG_TAG,"CdmaCallTracker.pendingOperations < 0");
            //pendingOperations = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.290 -0400", hash_original_method = "E4BBEB9CBA55B093A717754E6D30B945", hash_generated_method = "160C538379F5D33EA01FE5E7F87136F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updatePhoneState() {
        Phone.State oldState;
        oldState = state;
        {
            boolean varE4BD9FA258196C0B4AF6B5D416334169_2134056880 = (ringingCall.isRinging());
            {
                state = Phone.State.RINGING;
            } //End block
            {
                boolean var4C7AB8264C38A76EB062AB98EEF3EE82_1869017636 = (pendingMO != null ||
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
            log("update phone state, old=" + oldState + " new="+ state);
        } //End block
        {
            phone.notifyPhoneStateChanged();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.292 -0400", hash_original_method = "63502DE56EE8A86B2DF78F720505C320", hash_generated_method = "FAEF4F5701D2FB4CC9E26AD9CF333900")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void handlePollCalls(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
        List polledCalls;
        {
            polledCalls = (List)ar.result;
        } //End block
        {
            boolean varC4DBE3EAF9ED931A30C22A297B6E685B_258837405 = (isCommandExceptionRadioNotAvailable(ar.exception));
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
                CdmaConnection conn;
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
                        boolean varA12D38D4E3C5051B181541F930988B8A_1565776350 = (pendingMO != null && pendingMO.compareTo(dc));
                        {
                            log("poll: pendingMO=" + pendingMO);
                            connections[i] = pendingMO;
                            pendingMO.index = i;
                            pendingMO.update(dc);
                            pendingMO = null;
                            {
                                hangupPendingMO = false;
                                {
                                    handleEcmTimer(phone.RESTART_ECM_TIMER);
                                } //End block
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
                            {
                                log("pendingMo=" + pendingMO + ", dc=" + dc);
                            } //End block
                            newRinging = checkMtFindNewRinging(dc,i);
                            {
                                unknownConnectionAppeared = true;
                            } //End block
                            checkAndEnableDataCallAfterEmergencyCallDropped();
                        } //End block
                    } //End collapsed parenthetic
                    hasNonHangupStateChanged = true;
                } //End block
                {
                    int count;
                    count = foregroundCall.connections.size();
                    {
                        int n;
                        n = 0;
                        {
                            log("adding fgCall cn " + n + " to droppedDuringPoll");
                            CdmaConnection cn;
                            cn = (CdmaConnection)foregroundCall.connections.get(n);
                            droppedDuringPoll.add(cn);
                        } //End block
                    } //End collapsed parenthetic
                    count = ringingCall.connections.size();
                    {
                        int n;
                        n = 0;
                        {
                            log("adding rgCall cn " + n + " to droppedDuringPoll");
                            CdmaConnection cn;
                            cn = (CdmaConnection)ringingCall.connections.get(n);
                            droppedDuringPoll.add(cn);
                        } //End block
                    } //End collapsed parenthetic
                    foregroundCall.setGeneric(false);
                    ringingCall.setGeneric(false);
                    {
                        handleEcmTimer(phone.RESTART_ECM_TIMER);
                    } //End block
                    checkAndEnableDataCallAfterEmergencyCallDropped();
                    connections[i] = null;
                } //End block
                {
                    {
                        {
                            droppedDuringPoll.add(conn);
                            newRinging = checkMtFindNewRinging(dc,i);
                            {
                                unknownConnectionAppeared = true;
                            } //End block
                            checkAndEnableDataCallAfterEmergencyCallDropped();
                        } //End block
                    } //End block
                    {
                        boolean changed;
                        changed = conn.update(dc);
                        hasNonHangupStateChanged = hasNonHangupStateChanged || changed;
                    } //End block
                } //End block
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
            {
                pendingCallInEcm = false;
            } //End block
        } //End block
        {
            phone.notifyNewRingingConnection(newRinging);
        } //End block
        {
            int i;
            i = droppedDuringPoll.size() - 1;
            {
                CdmaConnection conn;
                conn = droppedDuringPoll.get(i);
                {
                    boolean var8064D1618E098621AFE888A1369217F2_349075462 = (conn.isIncoming() && conn.getConnectTime() == 0);
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
            boolean varA25616F2AD7C98E00F706161A5B687F7_627904903 = (droppedDuringPoll.size() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.293 -0400", hash_original_method = "CA7F8E55CA885F7D7A3A262DD3D03608", hash_generated_method = "DFDD995B79F635A06DB25625882A3D23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void hangup(CdmaConnection conn) throws CallStateException {
        dsTaint.addTaint(conn.dsTaint);
        {
            boolean var7B293A7D3CB476B7EF41E01A5B6DD8B4_468005657 = (conn.owner != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException ("CdmaConnection " + conn
                                    + "does not belong to CdmaCallTracker " + this);
            } //End block
        } //End collapsed parenthetic
        {
            log("hangup: set hangupPendingMO to true");
            hangupPendingMO = true;
        } //End block
        {
            boolean var7215D6E68D3558026AB7D731B4F5BDD0_992956969 = ((conn.getCall() == ringingCall)
                && (ringingCall.getState() == CdmaCall.State.WAITING));
            {
                conn.onLocalDisconnect();
                updatePhoneState();
                phone.notifyPreciseCallStateChanged();
            } //End block
            {
                try 
                {
                    cm.hangupConnection (conn.getCDMAIndex(), obtainCompleteMessage());
                } //End block
                catch (CallStateException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        conn.onHangupLocal();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.293 -0400", hash_original_method = "B6040BEA0CD88965F5BB741ECCA6B877", hash_generated_method = "28F23F0F83C35D5D99B386BA69889041")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void separate(CdmaConnection conn) throws CallStateException {
        dsTaint.addTaint(conn.dsTaint);
        {
            boolean var7B293A7D3CB476B7EF41E01A5B6DD8B4_1269746918 = (conn.owner != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException ("CdmaConnection " + conn
                                    + "does not belong to CdmaCallTracker " + this);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            cm.separateConnection (conn.getCDMAIndex(),
                obtainCompleteMessage(EVENT_SEPARATE_RESULT));
        } //End block
        catch (CallStateException ex)
        { }
        // ---------- Original Method ----------
        //if (conn.owner != this) {
            //throw new CallStateException ("CdmaConnection " + conn
                                    //+ "does not belong to CdmaCallTracker " + this);
        //}
        //try {
            //cm.separateConnection (conn.getCDMAIndex(),
                //obtainCompleteMessage(EVENT_SEPARATE_RESULT));
        //} catch (CallStateException ex) {
            //Log.w(LOG_TAG,"CdmaCallTracker WARN: separate() on absent connection "
                          //+ conn);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.293 -0400", hash_original_method = "8E7DA06B8727FE7EBCD155EA09819106", hash_generated_method = "CA89AD40243CEB287C301CF244F264F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setMute(boolean mute) {
        dsTaint.addTaint(mute);
        cm.setMute(desiredMute, null);
        // ---------- Original Method ----------
        //desiredMute = mute;
        //cm.setMute(desiredMute, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.293 -0400", hash_original_method = "11907D6A9C6D8F23B8C0FECA1425D0D1", hash_generated_method = "3229FE3A084EE46BBD7A13C15D060343")
    @DSModeled(DSC.SAFE)
     boolean getMute() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return desiredMute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.294 -0400", hash_original_method = "E9438EE2A649600B881089247D36F1D3", hash_generated_method = "87F58ADEF44D187F8C1F085AF0C89568")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void hangup(CdmaCall call) throws CallStateException {
        dsTaint.addTaint(call.dsTaint);
        {
            boolean varE4A326D5F85A22F10F9645DF8E94C259_889074045 = (call.getConnections().size() == 0);
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
                boolean var22C48955666B247FCD89E865FCE21904_1393780700 = (call.isDialingOrAlerting());
                {
                    {
                        log("(foregnd) hangup dialing or alerting...");
                    } //End block
                    hangup((CdmaConnection)(call.getConnections().get(0)));
                } //End block
                {
                    hangupForegroundResumeBackground();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varA4A4A8F760ECA28FD2366D22B56B66BD_1170114005 = (ringingCall.isRinging());
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
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("CdmaCall " + call +
                    "does not belong to CdmaCallTracker " + this);
        } //End block
        call.onHangupLocal();
        phone.notifyPreciseCallStateChanged();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.294 -0400", hash_original_method = "E840FBD61F8E6AF3DE802E32C39DD93E", hash_generated_method = "4AF2AF2C1AF283F2B3D66EB92EFBBE89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void hangupWaitingOrBackground() {
        log("hangupWaitingOrBackground");
        cm.hangupWaitingOrBackground(obtainCompleteMessage());
        // ---------- Original Method ----------
        //if (Phone.DEBUG_PHONE) log("hangupWaitingOrBackground");
        //cm.hangupWaitingOrBackground(obtainCompleteMessage());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.294 -0400", hash_original_method = "D10B26113142441F52E905015040129F", hash_generated_method = "939D43994EC933107D2D3D9C50AF847D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void hangupForegroundResumeBackground() {
        log("hangupForegroundResumeBackground");
        cm.hangupForegroundResumeBackground(obtainCompleteMessage());
        // ---------- Original Method ----------
        //if (Phone.DEBUG_PHONE) log("hangupForegroundResumeBackground");
        //cm.hangupForegroundResumeBackground(obtainCompleteMessage());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.294 -0400", hash_original_method = "46F42EF7B8FEEB9638F3768D6C678D5F", hash_generated_method = "F3C1E61DADCBC6CED9AA6467AA36760D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void hangupConnectionByIndex(CdmaCall call, int index) throws CallStateException {
        dsTaint.addTaint(call.dsTaint);
        dsTaint.addTaint(index);
        int count;
        count = call.connections.size();
        {
            int i;
            i = 0;
            {
                CdmaConnection cn;
                cn = (CdmaConnection)call.connections.get(i);
                {
                    boolean varD4890B27B1518CF37532B19255789636_1999180454 = (cn.getCDMAIndex() == index);
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
            //CdmaConnection cn = (CdmaConnection)call.connections.get(i);
            //if (cn.getCDMAIndex() == index) {
                //cm.hangupConnection(index, obtainCompleteMessage());
                //return;
            //}
        //}
        //throw new CallStateException("no gsm index found");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.295 -0400", hash_original_method = "C8ED8584ACDA74B40EBCC108129D9E6B", hash_generated_method = "F74C53BEC530E590BA975130E4033A45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void hangupAllConnections(CdmaCall call) throws CallStateException {
        dsTaint.addTaint(call.dsTaint);
        try 
        {
            int count;
            count = call.connections.size();
            {
                int i;
                i = 0;
                {
                    CdmaConnection cn;
                    cn = (CdmaConnection)call.connections.get(i);
                    cm.hangupConnection(cn.getCDMAIndex(), obtainCompleteMessage());
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (CallStateException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //int count = call.connections.size();
            //for (int i = 0; i < count; i++) {
                //CdmaConnection cn = (CdmaConnection)call.connections.get(i);
                //cm.hangupConnection(cn.getCDMAIndex(), obtainCompleteMessage());
            //}
        //} catch (CallStateException ex) {
            //Log.e(LOG_TAG, "hangupConnectionByIndex caught " + ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.295 -0400", hash_original_method = "DA3BA6D275DE18892F45915EBAE08DC8", hash_generated_method = "C7AC5C0B1EBE3B54BEFC69C81E237080")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CdmaConnection getConnectionByIndex(CdmaCall call, int index) throws CallStateException {
        dsTaint.addTaint(call.dsTaint);
        dsTaint.addTaint(index);
        int count;
        count = call.connections.size();
        {
            int i;
            i = 0;
            {
                CdmaConnection cn;
                cn = (CdmaConnection)call.connections.get(i);
                {
                    boolean varD4890B27B1518CF37532B19255789636_2131500361 = (cn.getCDMAIndex() == index);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (CdmaConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int count = call.connections.size();
        //for (int i = 0; i < count; i++) {
            //CdmaConnection cn = (CdmaConnection)call.connections.get(i);
            //if (cn.getCDMAIndex() == index) {
                //return cn;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.295 -0400", hash_original_method = "EB39E7AA8B070FEFE523D7C5104C422F", hash_generated_method = "F2B22B9C2961AD4C91E3828C52AE1EE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void flashAndSetGenericTrue() throws CallStateException {
        cm.sendCDMAFeatureCode("", obtainMessage(EVENT_SWITCH_RESULT));
        foregroundCall.setGeneric(true);
        phone.notifyPreciseCallStateChanged();
        // ---------- Original Method ----------
        //cm.sendCDMAFeatureCode("", obtainMessage(EVENT_SWITCH_RESULT));
        //foregroundCall.setGeneric(true);
        //phone.notifyPreciseCallStateChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.295 -0400", hash_original_method = "65CD53B5AAA831AF61B9937ED3D66C8B", hash_generated_method = "7BA4FBB17ED23263557C8C2DAC280B9A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.295 -0400", hash_original_method = "6E2D3B844106C3BA4166C29F96BB7EA0", hash_generated_method = "3D35CA8E198B65065816E56AAB25BAB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleRadioNotAvailable() {
        pollCallsWhenSafe();
        // ---------- Original Method ----------
        //pollCallsWhenSafe();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.296 -0400", hash_original_method = "8A157B3E162ABAFDC3219E193FD9AF9E", hash_generated_method = "0194192C3AAFF4A8704CEB5A96AF507B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void notifyCallWaitingInfo(CdmaCallWaitingNotification obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            callWaitingRegistrants.notifyRegistrants(new AsyncResult(null, obj, null));
        } //End block
        // ---------- Original Method ----------
        //if (callWaitingRegistrants != null) {
            //callWaitingRegistrants.notifyRegistrants(new AsyncResult(null, obj, null));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.296 -0400", hash_original_method = "8AEB0E73C414AF95EF44C542FCF55311", hash_generated_method = "4AC0308CD97D7340137BFBE07D54DD71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleCallWaitingInfo(CdmaCallWaitingNotification cw) {
        dsTaint.addTaint(cw.dsTaint);
        {
            boolean varF80A25201569015423B9C49F57AE8341_515684566 = (foregroundCall.connections.size() > 1);
            {
                foregroundCall.setGeneric(true);
            } //End block
        } //End collapsed parenthetic
        ringingCall.setGeneric(false);
        new CdmaConnection(phone.getContext(), cw, this, ringingCall);
        updatePhoneState();
        notifyCallWaitingInfo(cw);
        // ---------- Original Method ----------
        //if (foregroundCall.connections.size() > 1 ) {
            //foregroundCall.setGeneric(true);
        //}
        //ringingCall.setGeneric(false);
        //new CdmaConnection(phone.getContext(), cw, this, ringingCall);
        //updatePhoneState();
        //notifyCallWaitingInfo(cw);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.297 -0400", hash_original_method = "D1EB700FB6D9FD1E2DF39441FB36A7DD", hash_generated_method = "18D4D7B743E7F2193A0499C020229C31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        AsyncResult ar;
        //Begin case EVENT_POLL_CALLS_RESULT 
        {
            Log.d(LOG_TAG, "Event EVENT_POLL_CALLS_RESULT Received");
            ar = (AsyncResult)msg.obj;
            {
                log(
                            "handle EVENT_POLL_CALL_RESULT: set needsPoll=F");
                needsPoll = false;
                lastRelevantPoll = null;
                handlePollCalls((AsyncResult)msg.obj);
            } //End block
        } //End block
        //End case EVENT_POLL_CALLS_RESULT 
        //Begin case EVENT_OPERATION_COMPLETE 
        operationComplete();
        //End case EVENT_OPERATION_COMPLETE 
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
            int i, s;
            i = 0;
            s = droppedDuringPoll.size();
            {
                CdmaConnection conn;
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
        //Begin case EVENT_EXIT_ECM_RESPONSE_CDMA 
        {
            cm.dial(pendingMO.address, pendingCallClirMode, obtainCompleteMessage());
            pendingCallInEcm = false;
        } //End block
        //End case EVENT_EXIT_ECM_RESPONSE_CDMA 
        //Begin case EVENT_EXIT_ECM_RESPONSE_CDMA 
        phone.unsetOnEcbModeExitResponse(this);
        //End case EVENT_EXIT_ECM_RESPONSE_CDMA 
        //Begin case EVENT_CALL_WAITING_INFO_CDMA 
        ar = (AsyncResult)msg.obj;
        //End case EVENT_CALL_WAITING_INFO_CDMA 
        //Begin case EVENT_CALL_WAITING_INFO_CDMA 
        {
            handleCallWaitingInfo((CdmaCallWaitingNotification)ar.result);
            Log.d(LOG_TAG, "Event EVENT_CALL_WAITING_INFO_CDMA Received");
        } //End block
        //End case EVENT_CALL_WAITING_INFO_CDMA 
        //Begin case EVENT_THREE_WAY_DIAL_L2_RESULT_CDMA 
        ar = (AsyncResult)msg.obj;
        //End case EVENT_THREE_WAY_DIAL_L2_RESULT_CDMA 
        //Begin case EVENT_THREE_WAY_DIAL_L2_RESULT_CDMA 
        {
            pendingMO.onConnectedInOrOut();
            pendingMO = null;
        } //End block
        //End case EVENT_THREE_WAY_DIAL_L2_RESULT_CDMA 
        //Begin case default 
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("unexpected event not handled");
        } //End block
        //End case default 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.298 -0400", hash_original_method = "53D0BC70C94C51E4941A4869C727C1EF", hash_generated_method = "6B1D6DF8E3CA6A2F312BE71E0C6F9C1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleEcmTimer(int action) {
        dsTaint.addTaint(action);
        phone.handleTimerInEmergencyCallbackMode(action);
        //Begin case CDMAPhone.CANCEL_ECM_TIMER 
        mIsEcmTimerCanceled = true;
        //End case CDMAPhone.CANCEL_ECM_TIMER 
        //Begin case CDMAPhone.RESTART_ECM_TIMER 
        mIsEcmTimerCanceled = false;
        //End case CDMAPhone.RESTART_ECM_TIMER 
        // ---------- Original Method ----------
        //phone.handleTimerInEmergencyCallbackMode(action);
        //switch(action) {
        //case CDMAPhone.CANCEL_ECM_TIMER: mIsEcmTimerCanceled = true; break;
        //case CDMAPhone.RESTART_ECM_TIMER: mIsEcmTimerCanceled = false; break;
        //default:
            //Log.e(LOG_TAG, "handleEcmTimer, unsupported action " + action);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.298 -0400", hash_original_method = "E45025BA49DB75441FB058D043F13559", hash_generated_method = "C916808903B2C98F427056E3B6D15CD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void disableDataCallInEmergencyCall(String dialString) {
        dsTaint.addTaint(dialString);
        {
            boolean var325FA9D4EF820F6526AF47F3B166DBE6_949772862 = (PhoneNumberUtils.isLocalEmergencyNumber(dialString, phone.getContext()));
            {
                log("disableDataCallInEmergencyCall");
                mIsInEmergencyCall = true;
                phone.mDataConnectionTracker.setInternalDataEnabled(false);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (PhoneNumberUtils.isLocalEmergencyNumber(dialString, phone.getContext())) {
            //if (Phone.DEBUG_PHONE) log("disableDataCallInEmergencyCall");
            //mIsInEmergencyCall = true;
            //phone.mDataConnectionTracker.setInternalDataEnabled(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.298 -0400", hash_original_method = "4B192230440137F94B49778D22CB7CD2", hash_generated_method = "B2D047485B02976AF47E4C23F8C0A75E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkAndEnableDataCallAfterEmergencyCallDropped() {
        {
            mIsInEmergencyCall = false;
            String inEcm;
            inEcm = SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
            {
                log("checkAndEnableDataCallAfterEmergencyCallDropped,inEcm=" + inEcm);
            } //End block
            {
                boolean varF1938E19DDB5D7D21BFFF4FE8AA8EABF_1066688969 = (inEcm.compareTo("false") == 0);
                {
                    phone.mDataConnectionTracker.setInternalDataEnabled(true);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (mIsInEmergencyCall) {
            //mIsInEmergencyCall = false;
            //String inEcm=SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
            //if (Phone.DEBUG_PHONE) {
                //log("checkAndEnableDataCallAfterEmergencyCallDropped,inEcm=" + inEcm);
            //}
            //if (inEcm.compareTo("false") == 0) {
                //phone.mDataConnectionTracker.setInternalDataEnabled(true);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.299 -0400", hash_original_method = "D359964B058F5C9ECC2D15DB024983EF", hash_generated_method = "DD85910F84841C48E67FDEFA6497F2EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Connection checkMtFindNewRinging(DriverCall dc, int i) {
        dsTaint.addTaint(dc.dsTaint);
        dsTaint.addTaint(i);
        Connection newRinging;
        newRinging = null;
        connections[i] = new CdmaConnection(phone.getContext(), dc, this, i);
        {
            boolean var77F010D23417E833441F8B3A6431ABA1_14949580 = (connections[i].getCall() == ringingCall);
            {
                newRinging = connections[i];
                log("Notify new ring " + dc);
            } //End block
            {
                {
                    connections[i].connectTime = System.currentTimeMillis();
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Connection newRinging = null;
        //connections[i] = new CdmaConnection(phone.getContext(), dc, this, i);
        //if (connections[i].getCall() == ringingCall) {
            //newRinging = connections[i];
            //if (Phone.DEBUG_PHONE) log("Notify new ring " + dc);
        //} else {
            //Log.e(LOG_TAG,"Phantom call appeared " + dc);
            //if (dc.state != DriverCall.State.ALERTING
                //&& dc.state != DriverCall.State.DIALING) {
                //connections[i].connectTime = System.currentTimeMillis();
            //}
        //}
        //return newRinging;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.299 -0400", hash_original_method = "1842D0C2283B311B2A29E474687D9235", hash_generated_method = "56002BA48DDE6BAC9242AF53A4B90AC2")
    @DSModeled(DSC.SAFE)
     boolean isInEmergencyCall() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsInEmergencyCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.299 -0400", hash_original_method = "FF708F6402A7A18425D7FC72639DE93E", hash_generated_method = "CFACF329564E7EB13451811B7DE2FA73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void log(String msg) {
        dsTaint.addTaint(msg);
        Log.d(LOG_TAG, "[CdmaCallTracker] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CdmaCallTracker] " + msg);
    }

    
    static final String LOG_TAG = "CDMA";
    private static final boolean REPEAT_POLLING = false;
    private static final boolean DBG_POLL = false;
    static final int MAX_CONNECTIONS = 1;
    static final int MAX_CONNECTIONS_PER_CALL = 1;
}

