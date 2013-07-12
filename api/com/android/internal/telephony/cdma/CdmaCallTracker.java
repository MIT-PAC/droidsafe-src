package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.007 -0400", hash_original_field = "C58F53C459878D89B341FB80EA845365", hash_generated_field = "6A689CEE5AFC02EE7871982A34436F33")

    CdmaConnection connections[] = new CdmaConnection[MAX_CONNECTIONS];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.007 -0400", hash_original_field = "8A0F3DEC66CFEEB2ECB457E5EA849D37", hash_generated_field = "D5D06964BBEC51B3D32BF2A900BC948B")

    RegistrantList voiceCallEndedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.007 -0400", hash_original_field = "CDE5B90F2260D3DC8A84E35500B6775B", hash_generated_field = "A661D5B9F6F26D0E5672FF445A016D80")

    RegistrantList voiceCallStartedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.007 -0400", hash_original_field = "64CA897868DAA4175C07D9B00CA5A6F5", hash_generated_field = "3D70A22464952A3DA788ACD133F18F18")

    RegistrantList callWaitingRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.007 -0400", hash_original_field = "FC84CE24FEB0A9E7F05DBB7000558261", hash_generated_field = "A29022524411F1FE9FAA91E8C50F5273")

    ArrayList<CdmaConnection> droppedDuringPoll = new ArrayList<CdmaConnection>(MAX_CONNECTIONS);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.008 -0400", hash_original_field = "0619E76BCFD69B42BEE8BE2B7FD7B9BD", hash_generated_field = "4BBDA18FC07012B464497A7036E9A64A")

    CdmaCall ringingCall = new CdmaCall(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.008 -0400", hash_original_field = "07FC128BE6CC33337F9DAFFBF9A07F18", hash_generated_field = "0CD0B75B3735614AF877856265E67CC2")

    CdmaCall foregroundCall = new CdmaCall(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.008 -0400", hash_original_field = "D855CF3B69C3475BF5A643D82E27F8C2", hash_generated_field = "1378E8D8E46107C480B8A53E811982F8")

    CdmaCall backgroundCall = new CdmaCall(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.008 -0400", hash_original_field = "FFF3375B9BFF76918F491666B68949AD", hash_generated_field = "2DB35562B0BF54F2C81F690DFDF249EA")

    CdmaConnection pendingMO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.008 -0400", hash_original_field = "1A8ABF13D702402EE54BFD56E4804126", hash_generated_field = "02C3359C89BD9A3EFAD64C6344B66724")

    boolean hangupPendingMO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.008 -0400", hash_original_field = "5FBB09530AC5F254B2B994A0BEBD3EE3", hash_generated_field = "2E8EE5EFDD4628948AC6D63D5B84BCF2")

    boolean pendingCallInEcm = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.008 -0400", hash_original_field = "123254AC1D49AFA1C4F58BABA1AE7779", hash_generated_field = "BC28D21C00A5A62F4E1E102DA65D0E68")

    boolean mIsInEmergencyCall = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.008 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "F2FC592D71DA2BCBED04F0F797B7B907")

    CDMAPhone phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.008 -0400", hash_original_field = "B262B2D3199ADD4E02EA2C990EA1FE1C", hash_generated_field = "9D75FD49CDE6D2073BBD4C557B93C735")

    boolean desiredMute = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.008 -0400", hash_original_field = "DBE99956F51C5D22A6E661875847A04F", hash_generated_field = "27174E0D68E2766EF4C51C4E944D5755")

    int pendingCallClirMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.008 -0400", hash_original_field = "2A29A007EEA18F3490433A6FDFAFB956", hash_generated_field = "40E232559DDE23609D651E7B63760E6C")

    Phone.State state = Phone.State.IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.008 -0400", hash_original_field = "9523AEECAD03B3078CD81B79CF3CBE20", hash_generated_field = "B4B1C0C1B427A1CEF2D1461193F5A876")

    private boolean mIsEcmTimerCanceled = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.009 -0400", hash_original_method = "D7E78FBD4DB8C2DC376D4ABE79BA3592", hash_generated_method = "B09BDF1A72EC50C995F9CEB1AB13E5B7")
      CdmaCallTracker(CDMAPhone phone) {
        this.phone = phone;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.009 -0400", hash_original_method = "2338338535849E159E02E311688F6BB3", hash_generated_method = "99C4F86851782734DAD63FF89717F794")
    public void dispose() {
        cm.unregisterForCallStateChanged(this);
        cm.unregisterForOn(this);
        cm.unregisterForNotAvailable(this);
        cm.unregisterForCallWaitingInfo(this);
for(CdmaConnection c : connections)
        {
            try 
            {
    if(c != null)                
                hangup(c);
            } //End block
            catch (CallStateException ex)
            {
            } //End block
        } //End block
        try 
        {
    if(pendingMO != null)            
            hangup(pendingMO);
        } //End block
        catch (CallStateException ex)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.010 -0400", hash_original_method = "73544050C1854D0258F226F7B919F554", hash_generated_method = "B58278D50A7470E880C8DDDBFC5E6BDE")
    @Override
    protected void finalize() {
        Log.d(LOG_TAG, "CdmaCallTracker finalized");
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "CdmaCallTracker finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.010 -0400", hash_original_method = "A19F9CA037C5D9E07B1DD2AD491B323A", hash_generated_method = "E27CAF9935D2468457687BCD0D4A34D3")
    public void registerForVoiceCallStarted(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        Registrant r = new Registrant(h, what, obj);
        voiceCallStartedRegistrants.add(r);
    if(state != Phone.State.IDLE)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.011 -0400", hash_original_method = "3C910908B4B98998A7936D8F8AE4D170", hash_generated_method = "9B599ABCA06C3CB11CC100B15D3B63CA")
    public void unregisterForVoiceCallStarted(Handler h) {
        addTaint(h.getTaint());
        voiceCallStartedRegistrants.remove(h);
        // ---------- Original Method ----------
        //voiceCallStartedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.011 -0400", hash_original_method = "D7F70C00A904DE96D26BDF7C49F41DAA", hash_generated_method = "F39032696EB04762CD7CB95E9F29536E")
    public void registerForVoiceCallEnded(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        Registrant r = new Registrant(h, what, obj);
        voiceCallEndedRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //voiceCallEndedRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.011 -0400", hash_original_method = "91176AF98778238DB3B453F2FC7D9448", hash_generated_method = "F7797E359E79D0A4733AB0A2C469DA29")
    public void unregisterForVoiceCallEnded(Handler h) {
        addTaint(h.getTaint());
        voiceCallEndedRegistrants.remove(h);
        // ---------- Original Method ----------
        //voiceCallEndedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.012 -0400", hash_original_method = "F34086F28C205DD5876302448C7FB8FC", hash_generated_method = "A98A58DF19DE8E652FEE2AF1FBC4E9B6")
    public void registerForCallWaiting(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        Registrant r = new Registrant (h, what, obj);
        callWaitingRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //callWaitingRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.012 -0400", hash_original_method = "F71574762174031DAD3F3CD1050F608A", hash_generated_method = "05F955562F027DF842DDD74BC13A260B")
    public void unregisterForCallWaiting(Handler h) {
        addTaint(h.getTaint());
        callWaitingRegistrants.remove(h);
        // ---------- Original Method ----------
        //callWaitingRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.012 -0400", hash_original_method = "B11C1D24F61F5A9ABEB7D187928BEC26", hash_generated_method = "9AB3F2F39380BAE5E0A799C34165AB19")
    private void fakeHoldForegroundBeforeDial() {
        List<Connection> connCopy;
        connCopy = (List<Connection>) foregroundCall.connections.clone();
for(int i = 0, s = connCopy.size();i < s;i++)
        {
            CdmaConnection conn = (CdmaConnection)connCopy.get(i);
            conn.fakeHoldBeforeDial();
        } //End block
        // ---------- Original Method ----------
        //List<Connection> connCopy;
        //connCopy = (List<Connection>) foregroundCall.connections.clone();
        //for (int i = 0, s = connCopy.size() ; i < s ; i++) {
            //CdmaConnection conn = (CdmaConnection)connCopy.get(i);
            //conn.fakeHoldBeforeDial();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.013 -0400", hash_original_method = "FEC4E6BC08FD10A2C518984DAAD113C7", hash_generated_method = "849DE3DC8FB6F709B51E457E1CFAF5D2")
     Connection dial(String dialString, int clirMode) throws CallStateException {
        clearDisconnected();
    if(!canDial())        
        {
            CallStateException var9E415163F1883D794EA7CDA9658E5AEC_1368375881 = new CallStateException("cannot dial in current state");
            var9E415163F1883D794EA7CDA9658E5AEC_1368375881.addTaint(taint);
            throw var9E415163F1883D794EA7CDA9658E5AEC_1368375881;
        } //End block
        String inEcm = SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
        boolean isPhoneInEcmMode = inEcm.equals("true");
        boolean isEmergencyCall = PhoneNumberUtils.isLocalEmergencyNumber(dialString, phone.getContext());
    if(isPhoneInEcmMode && isEmergencyCall)        
        {
            handleEcmTimer(phone.CANCEL_ECM_TIMER);
        } //End block
        foregroundCall.setGeneric(false);
    if(foregroundCall.getState() == CdmaCall.State.ACTIVE)        
        {
Connection var0D0173C65DF18B64351D0649B2D04417_1247572956 =             dialThreeWay(dialString);
            var0D0173C65DF18B64351D0649B2D04417_1247572956.addTaint(taint);
            return var0D0173C65DF18B64351D0649B2D04417_1247572956;
        } //End block
        pendingMO = new CdmaConnection(phone.getContext(), dialString, this, foregroundCall);
        hangupPendingMO = false;
    if(pendingMO.address == null || pendingMO.address.length() == 0
            || pendingMO.address.indexOf(PhoneNumberUtils.WILD) >= 0)        
        {
            pendingMO.cause = Connection.DisconnectCause.INVALID_NUMBER;
            pollCallsWhenSafe();
        } //End block
        else
        {
            setMute(false);
            disableDataCallInEmergencyCall(dialString);
    if(!isPhoneInEcmMode || (isPhoneInEcmMode && isEmergencyCall))            
            {
                cm.dial(pendingMO.address, clirMode, obtainCompleteMessage());
            } //End block
            else
            {
                phone.exitEmergencyCallbackMode();
                phone.setOnEcbModeExitResponse(this,EVENT_EXIT_ECM_RESPONSE_CDMA, null);
                pendingCallClirMode=clirMode;
                pendingCallInEcm=true;
            } //End block
        } //End block
        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
Connection var14BF1C8BBB47038F78C99A232B009337_843092751 =         pendingMO;
        var14BF1C8BBB47038F78C99A232B009337_843092751.addTaint(taint);
        return var14BF1C8BBB47038F78C99A232B009337_843092751;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.014 -0400", hash_original_method = "916DB4F3BDDE26A491E1178653223CEE", hash_generated_method = "F6EFC371AE6CD6CA884505EB14EE19D0")
     Connection dial(String dialString) throws CallStateException {
        addTaint(dialString.getTaint());
Connection varE8109EC8026230EB0B66EDCCD607E699_767260115 =         dial(dialString, CommandsInterface.CLIR_DEFAULT);
        varE8109EC8026230EB0B66EDCCD607E699_767260115.addTaint(taint);
        return varE8109EC8026230EB0B66EDCCD607E699_767260115;
        // ---------- Original Method ----------
        //return dial(dialString, CommandsInterface.CLIR_DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.014 -0400", hash_original_method = "88840CD76FEAD0D0B90DCB96EA4A4A27", hash_generated_method = "A8B874DCD92D34DF9A8F75CEE8997CE5")
    private Connection dialThreeWay(String dialString) {
    if(!foregroundCall.isIdle())        
        {
            disableDataCallInEmergencyCall(dialString);
            pendingMO = new CdmaConnection(phone.getContext(),
                                dialString, this, foregroundCall);
            cm.sendCDMAFeatureCode(pendingMO.address,
                obtainMessage(EVENT_THREE_WAY_DIAL_L2_RESULT_CDMA));
Connection var14BF1C8BBB47038F78C99A232B009337_1921834255 =             pendingMO;
            var14BF1C8BBB47038F78C99A232B009337_1921834255.addTaint(taint);
            return var14BF1C8BBB47038F78C99A232B009337_1921834255;
        } //End block
Connection var540C13E9E156B687226421B24F2DF178_512642123 =         null;
        var540C13E9E156B687226421B24F2DF178_512642123.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_512642123;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.015 -0400", hash_original_method = "A15B8A9C3B79A061845560CDFB3D1962", hash_generated_method = "5663B4E2F197B22DC5AE1E216038AEF9")
     void acceptCall() throws CallStateException {
    if(ringingCall.getState() == CdmaCall.State.INCOMING)        
        {
            setMute(false);
            cm.acceptCall(obtainCompleteMessage());
        } //End block
        else
    if(ringingCall.getState() == CdmaCall.State.WAITING)        
        {
            CdmaConnection cwConn = (CdmaConnection)(ringingCall.getLatestConnection());
            cwConn.updateParent(ringingCall, foregroundCall);
            cwConn.onConnectedInOrOut();
            updatePhoneState();
            switchWaitingOrHoldingAndActive();
        } //End block
        else
        {
            CallStateException var566A6D1258D88782F935EBCAFFB89CEC_313113936 = new CallStateException("phone not ringing");
            var566A6D1258D88782F935EBCAFFB89CEC_313113936.addTaint(taint);
            throw var566A6D1258D88782F935EBCAFFB89CEC_313113936;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.015 -0400", hash_original_method = "9B02E01190499DD77CD223AD7831C55B", hash_generated_method = "B3A9E1F20F7DEB6BE659AB5F9906F239")
     void rejectCall() throws CallStateException {
    if(ringingCall.getState().isRinging())        
        {
            cm.rejectCall(obtainCompleteMessage());
        } //End block
        else
        {
            CallStateException var566A6D1258D88782F935EBCAFFB89CEC_583639467 = new CallStateException("phone not ringing");
            var566A6D1258D88782F935EBCAFFB89CEC_583639467.addTaint(taint);
            throw var566A6D1258D88782F935EBCAFFB89CEC_583639467;
        } //End block
        // ---------- Original Method ----------
        //if (ringingCall.getState().isRinging()) {
            //cm.rejectCall(obtainCompleteMessage());
        //} else {
            //throw new CallStateException("phone not ringing");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.015 -0400", hash_original_method = "4E2E600B83947FE548823E8A00BDC609", hash_generated_method = "2B52835E40BE557A1CE1B6DC5E8314F0")
     void switchWaitingOrHoldingAndActive() throws CallStateException {
    if(ringingCall.getState() == CdmaCall.State.INCOMING)        
        {
            CallStateException varE42FEAD21291D7FDB488D92CAF81155C_766016091 = new CallStateException("cannot be in the incoming state");
            varE42FEAD21291D7FDB488D92CAF81155C_766016091.addTaint(taint);
            throw varE42FEAD21291D7FDB488D92CAF81155C_766016091;
        } //End block
        else
    if(foregroundCall.getConnections().size() > 1)        
        {
            flashAndSetGenericTrue();
        } //End block
        else
        {
            cm.sendCDMAFeatureCode("", obtainMessage(EVENT_SWITCH_RESULT));
        } //End block
        // ---------- Original Method ----------
        //if (ringingCall.getState() == CdmaCall.State.INCOMING) {
            //throw new CallStateException("cannot be in the incoming state");
        //} else if (foregroundCall.getConnections().size() > 1) {
            //flashAndSetGenericTrue();
        //} else {
            //cm.sendCDMAFeatureCode("", obtainMessage(EVENT_SWITCH_RESULT));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.016 -0400", hash_original_method = "B1073FCDB805CE663445BC5D803D76AA", hash_generated_method = "90ECDE91CEB46AEDFA1995478C6494BA")
     void conference() throws CallStateException {
        flashAndSetGenericTrue();
        // ---------- Original Method ----------
        //flashAndSetGenericTrue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.016 -0400", hash_original_method = "B9B58214FE30DEB2D41379B25D88E6DD", hash_generated_method = "91DDF637F580C2F12D44ADB525F30440")
     void explicitCallTransfer() throws CallStateException {
        cm.explicitCallTransfer(obtainCompleteMessage(EVENT_ECT_RESULT));
        // ---------- Original Method ----------
        //cm.explicitCallTransfer(obtainCompleteMessage(EVENT_ECT_RESULT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.016 -0400", hash_original_method = "89E1881B087BAA2C040FAFD444B532DA", hash_generated_method = "93C10D32BFEAACBDB937011534F3F686")
     void clearDisconnected() {
        internalClearDisconnected();
        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
        // ---------- Original Method ----------
        //internalClearDisconnected();
        //updatePhoneState();
        //phone.notifyPreciseCallStateChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.017 -0400", hash_original_method = "885B69631C6ACC1E38924306F8EB7459", hash_generated_method = "7ADCF2F5BCFAF8CA6C24C1605E49D9C9")
     boolean canConference() {
        boolean varB56B5C49D7206233B27CE5D29642483D_936038305 = (foregroundCall.getState() == CdmaCall.State.ACTIVE
                && backgroundCall.getState() == CdmaCall.State.HOLDING
                && !backgroundCall.isFull()
                && !foregroundCall.isFull());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_244513774 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_244513774;
        // ---------- Original Method ----------
        //return foregroundCall.getState() == CdmaCall.State.ACTIVE
                //&& backgroundCall.getState() == CdmaCall.State.HOLDING
                //&& !backgroundCall.isFull()
                //&& !foregroundCall.isFull();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.018 -0400", hash_original_method = "DFFE89A6FC85DFAF69854FF09292A4CC", hash_generated_method = "6A3FE74BAB90362CEEC71604CB273A80")
     boolean canDial() {
        boolean ret;
        int serviceState = phone.getServiceState().getState();
        String disableCall = SystemProperties.get(
                TelephonyProperties.PROPERTY_DISABLE_CALL, "false");
        ret = (serviceState != ServiceState.STATE_POWER_OFF)
                && pendingMO == null
                && !ringingCall.isRinging()
                && !disableCall.equals("true")
                && (!foregroundCall.getState().isAlive()
                    || (foregroundCall.getState() == CdmaCall.State.ACTIVE)
                    || !backgroundCall.getState().isAlive());
    if(!ret)        
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
        boolean var2CB9DF9898E55FD0AD829DC202DDBD1C_1229830913 = (ret);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1221098773 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1221098773;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.018 -0400", hash_original_method = "F828A2F1845194FFD82C471D7E89F726", hash_generated_method = "6E099C171800712A17C09F987CBAC181")
     boolean canTransfer() {
        boolean var68934A3E9455FA72420237EB05902327_1958035971 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1726392510 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1726392510;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "canTransfer: not possible in CDMA");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.018 -0400", hash_original_method = "3058DCAC5E1117AE07A379578E7C6A20", hash_generated_method = "F0E9C736A8A4591368CEECFAB84F530D")
    private void internalClearDisconnected() {
        ringingCall.clearDisconnected();
        foregroundCall.clearDisconnected();
        backgroundCall.clearDisconnected();
        // ---------- Original Method ----------
        //ringingCall.clearDisconnected();
        //foregroundCall.clearDisconnected();
        //backgroundCall.clearDisconnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.018 -0400", hash_original_method = "89F67FF5AFAE8FAD9F556239F3E27159", hash_generated_method = "830712EAB23B61FE102AE8CD199A9238")
    private Message obtainCompleteMessage() {
Message varA06F2757B7CF455962BF6FB3E43CCFD1_1053016930 =         obtainCompleteMessage(EVENT_OPERATION_COMPLETE);
        varA06F2757B7CF455962BF6FB3E43CCFD1_1053016930.addTaint(taint);
        return varA06F2757B7CF455962BF6FB3E43CCFD1_1053016930;
        // ---------- Original Method ----------
        //return obtainCompleteMessage(EVENT_OPERATION_COMPLETE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.019 -0400", hash_original_method = "F527C5C3DD4F0176588A0C261AD76B7A", hash_generated_method = "8FAD23C65D41B805A4486AF3CB9F86F6")
    private Message obtainCompleteMessage(int what) {
        addTaint(what);
        pendingOperations++;
        lastRelevantPoll = null;
        needsPoll = true;
    if(DBG_POLL)        
        log("obtainCompleteMessage: pendingOperations=" +
                pendingOperations + ", needsPoll=" + needsPoll);
Message var7D44CBDF570B5CB81D544F0887CE90C1_1435866789 =         obtainMessage(what);
        var7D44CBDF570B5CB81D544F0887CE90C1_1435866789.addTaint(taint);
        return var7D44CBDF570B5CB81D544F0887CE90C1_1435866789;
        // ---------- Original Method ----------
        //pendingOperations++;
        //lastRelevantPoll = null;
        //needsPoll = true;
        //if (DBG_POLL) log("obtainCompleteMessage: pendingOperations=" +
                //pendingOperations + ", needsPoll=" + needsPoll);
        //return obtainMessage(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.019 -0400", hash_original_method = "179E11A88A956D6661DD344814FD0D33", hash_generated_method = "4DAF9902539F0654FF72510A53A2A5A9")
    private void operationComplete() {
        pendingOperations--;
    if(DBG_POLL)        
        log("operationComplete: pendingOperations=" +
                pendingOperations + ", needsPoll=" + needsPoll);
    if(pendingOperations == 0 && needsPoll)        
        {
            lastRelevantPoll = obtainMessage(EVENT_POLL_CALLS_RESULT);
            cm.getCurrentCalls(lastRelevantPoll);
        } //End block
        else
    if(pendingOperations < 0)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.021 -0400", hash_original_method = "E4BBEB9CBA55B093A717754E6D30B945", hash_generated_method = "FEB6DD46BE681E0D2220A6EEC91E4B0C")
    private void updatePhoneState() {
        Phone.State oldState = state;
    if(ringingCall.isRinging())        
        {
            state = Phone.State.RINGING;
        } //End block
        else
    if(pendingMO != null ||
                !(foregroundCall.isIdle() && backgroundCall.isIdle()))        
        {
            state = Phone.State.OFFHOOK;
        } //End block
        else
        {
            state = Phone.State.IDLE;
        } //End block
    if(state == Phone.State.IDLE && oldState != state)        
        {
            voiceCallEndedRegistrants.notifyRegistrants(
                new AsyncResult(null, null, null));
        } //End block
        else
    if(oldState == Phone.State.IDLE && oldState != state)        
        {
            voiceCallStartedRegistrants.notifyRegistrants (
                    new AsyncResult(null, null, null));
        } //End block
    if(Phone.DEBUG_PHONE)        
        {
            log("update phone state, old=" + oldState + " new="+ state);
        } //End block
    if(state != oldState)        
        {
            phone.notifyPhoneStateChanged();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.028 -0400", hash_original_method = "63502DE56EE8A86B2DF78F720505C320", hash_generated_method = "6E790D96BF927AD05504AD16F034F463")
    protected void handlePollCalls(AsyncResult ar) {
        addTaint(ar.getTaint());
        List polledCalls;
    if(ar.exception == null)        
        {
            polledCalls = (List)ar.result;
        } //End block
        else
    if(isCommandExceptionRadioNotAvailable(ar.exception))        
        {
            polledCalls = new ArrayList();
        } //End block
        else
        {
            pollCallsAfterDelay();
            return;
        } //End block
        Connection newRinging = null;
        boolean hasNonHangupStateChanged = false;
        boolean needsPollDelay = false;
        boolean unknownConnectionAppeared = false;
for(int i = 0, curDC = 0, dcSize = polledCalls.size();i < connections.length;i++)
        {
            CdmaConnection conn = connections[i];
            DriverCall dc = null;
    if(curDC < dcSize)            
            {
                dc = (DriverCall) polledCalls.get(curDC);
    if(dc.index == i+1)                
                {
                    curDC++;
                } //End block
                else
                {
                    dc = null;
                } //End block
            } //End block
    if(DBG_POLL)            
            log("poll: conn[i=" + i + "]=" +
                    conn+", dc=" + dc);
    if(conn == null && dc != null)            
            {
    if(pendingMO != null && pendingMO.compareTo(dc))                
                {
    if(DBG_POLL)                    
                    log("poll: pendingMO=" + pendingMO);
                    connections[i] = pendingMO;
                    pendingMO.index = i;
                    pendingMO.update(dc);
                    pendingMO = null;
    if(hangupPendingMO)                    
                    {
                        hangupPendingMO = false;
    if(mIsEcmTimerCanceled)                        
                        {
                            handleEcmTimer(phone.RESTART_ECM_TIMER);
                        } //End block
                        try 
                        {
    if(Phone.DEBUG_PHONE)                            
                            log(
                                    "poll: hangupPendingMO, hangup conn " + i);
                            hangup(connections[i]);
                        } //End block
                        catch (CallStateException ex)
                        {
                        } //End block
                        return;
                    } //End block
                } //End block
                else
                {
    if(Phone.DEBUG_PHONE)                    
                    {
                        log("pendingMo=" + pendingMO + ", dc=" + dc);
                    } //End block
                    newRinging = checkMtFindNewRinging(dc,i);
    if(newRinging == null)                    
                    {
                        unknownConnectionAppeared = true;
                    } //End block
                    checkAndEnableDataCallAfterEmergencyCallDropped();
                } //End block
                hasNonHangupStateChanged = true;
            } //End block
            else
    if(conn != null && dc == null)            
            {
                int count = foregroundCall.connections.size();
for(int n = 0;n < count;n++)
                {
    if(Phone.DEBUG_PHONE)                    
                    log("adding fgCall cn " + n + " to droppedDuringPoll");
                    CdmaConnection cn = (CdmaConnection)foregroundCall.connections.get(n);
                    droppedDuringPoll.add(cn);
                } //End block
                count = ringingCall.connections.size();
for(int n = 0;n < count;n++)
                {
    if(Phone.DEBUG_PHONE)                    
                    log("adding rgCall cn " + n + " to droppedDuringPoll");
                    CdmaConnection cn = (CdmaConnection)ringingCall.connections.get(n);
                    droppedDuringPoll.add(cn);
                } //End block
                foregroundCall.setGeneric(false);
                ringingCall.setGeneric(false);
    if(mIsEcmTimerCanceled)                
                {
                    handleEcmTimer(phone.RESTART_ECM_TIMER);
                } //End block
                checkAndEnableDataCallAfterEmergencyCallDropped();
                connections[i] = null;
            } //End block
            else
    if(conn != null && dc != null)            
            {
    if(conn.isIncoming != dc.isMT)                
                {
    if(dc.isMT == true)                    
                    {
                        droppedDuringPoll.add(conn);
                        newRinging = checkMtFindNewRinging(dc,i);
    if(newRinging == null)                        
                        {
                            unknownConnectionAppeared = true;
                        } //End block
                        checkAndEnableDataCallAfterEmergencyCallDropped();
                    } //End block
                    else
                    {
                    } //End block
                } //End block
                else
                {
                    boolean changed;
                    changed = conn.update(dc);
                    hasNonHangupStateChanged = hasNonHangupStateChanged || changed;
                } //End block
            } //End block
    if(REPEAT_POLLING)            
            {
    if(dc != null)                
                {
    if((dc.state == DriverCall.State.DIALING
                            )
                        || (dc.state == DriverCall.State.ALERTING
                            )
                        || (dc.state == DriverCall.State.INCOMING
                            )
                        || (dc.state == DriverCall.State.WAITING
                            ))                    
                    {
                        needsPollDelay = true;
                    } //End block
                } //End block
            } //End block
        } //End block
    if(pendingMO != null)        
        {
            Log.d(LOG_TAG,"Pending MO dropped before poll fg state:"
                            + foregroundCall.getState());
            droppedDuringPoll.add(pendingMO);
            pendingMO = null;
            hangupPendingMO = false;
    if(pendingCallInEcm)            
            {
                pendingCallInEcm = false;
            } //End block
        } //End block
    if(newRinging != null)        
        {
            phone.notifyNewRingingConnection(newRinging);
        } //End block
for(int i = droppedDuringPoll.size() - 1;i >= 0;i--)
        {
            CdmaConnection conn = droppedDuringPoll.get(i);
    if(conn.isIncoming() && conn.getConnectTime() == 0)            
            {
                Connection.DisconnectCause cause;
    if(conn.cause == Connection.DisconnectCause.LOCAL)                
                {
                    cause = Connection.DisconnectCause.INCOMING_REJECTED;
                } //End block
                else
                {
                    cause = Connection.DisconnectCause.INCOMING_MISSED;
                } //End block
    if(Phone.DEBUG_PHONE)                
                {
                    log("missed/rejected call, conn.cause=" + conn.cause);
                    log("setting cause to " + cause);
                } //End block
                droppedDuringPoll.remove(i);
                conn.onDisconnect(cause);
            } //End block
            else
    if(conn.cause == Connection.DisconnectCause.LOCAL)            
            {
                droppedDuringPoll.remove(i);
                conn.onDisconnect(Connection.DisconnectCause.LOCAL);
            } //End block
            else
    if(conn.cause == Connection.DisconnectCause.INVALID_NUMBER)            
            {
                droppedDuringPoll.remove(i);
                conn.onDisconnect(Connection.DisconnectCause.INVALID_NUMBER);
            } //End block
        } //End block
    if(droppedDuringPoll.size() > 0)        
        {
            cm.getLastCallFailCause(
                obtainNoPollCompleteMessage(EVENT_GET_LAST_CALL_FAIL_CAUSE));
        } //End block
    if(needsPollDelay)        
        {
            pollCallsAfterDelay();
        } //End block
    if(newRinging != null || hasNonHangupStateChanged)        
        {
            internalClearDisconnected();
        } //End block
        updatePhoneState();
    if(unknownConnectionAppeared)        
        {
            phone.notifyUnknownConnection();
        } //End block
    if(hasNonHangupStateChanged || newRinging != null)        
        {
            phone.notifyPreciseCallStateChanged();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.031 -0400", hash_original_method = "CA7F8E55CA885F7D7A3A262DD3D03608", hash_generated_method = "A0E547083DC38927985A44513BC7C4C8")
     void hangup(CdmaConnection conn) throws CallStateException {
        addTaint(conn.getTaint());
    if(conn.owner != this)        
        {
            CallStateException var2CBEFEAE783A82F1D7BA506523E68F2B_475978351 = new CallStateException ("CdmaConnection " + conn
                                    + "does not belong to CdmaCallTracker " + this);
            var2CBEFEAE783A82F1D7BA506523E68F2B_475978351.addTaint(taint);
            throw var2CBEFEAE783A82F1D7BA506523E68F2B_475978351;
        } //End block
    if(conn == pendingMO)        
        {
    if(Phone.DEBUG_PHONE)            
            log("hangup: set hangupPendingMO to true");
            hangupPendingMO = true;
        } //End block
        else
    if((conn.getCall() == ringingCall)
                && (ringingCall.getState() == CdmaCall.State.WAITING))        
        {
            conn.onLocalDisconnect();
            updatePhoneState();
            phone.notifyPreciseCallStateChanged();
            return;
        } //End block
        else
        {
            try 
            {
                cm.hangupConnection (conn.getCDMAIndex(), obtainCompleteMessage());
            } //End block
            catch (CallStateException ex)
            {
            } //End block
        } //End block
        conn.onHangupLocal();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.031 -0400", hash_original_method = "B6040BEA0CD88965F5BB741ECCA6B877", hash_generated_method = "4DDB14786A2098975A1228162C1A4F12")
     void separate(CdmaConnection conn) throws CallStateException {
        addTaint(conn.getTaint());
    if(conn.owner != this)        
        {
            CallStateException var2CBEFEAE783A82F1D7BA506523E68F2B_1641725846 = new CallStateException ("CdmaConnection " + conn
                                    + "does not belong to CdmaCallTracker " + this);
            var2CBEFEAE783A82F1D7BA506523E68F2B_1641725846.addTaint(taint);
            throw var2CBEFEAE783A82F1D7BA506523E68F2B_1641725846;
        } //End block
        try 
        {
            cm.separateConnection (conn.getCDMAIndex(),
                obtainCompleteMessage(EVENT_SEPARATE_RESULT));
        } //End block
        catch (CallStateException ex)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.032 -0400", hash_original_method = "8E7DA06B8727FE7EBCD155EA09819106", hash_generated_method = "09D97CBFA339BB68260AAF45EF5FD946")
     void setMute(boolean mute) {
        desiredMute = mute;
        cm.setMute(desiredMute, null);
        // ---------- Original Method ----------
        //desiredMute = mute;
        //cm.setMute(desiredMute, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.032 -0400", hash_original_method = "11907D6A9C6D8F23B8C0FECA1425D0D1", hash_generated_method = "6475B01210118667B5CE173E568F3A69")
     boolean getMute() {
        boolean var8C4FD417B21794EC88BA7D0D7F766EFA_1619459106 = (desiredMute);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_400721275 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_400721275;
        // ---------- Original Method ----------
        //return desiredMute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.033 -0400", hash_original_method = "E9438EE2A649600B881089247D36F1D3", hash_generated_method = "A92C1EE0F52103B31D79790119EFF20A")
     void hangup(CdmaCall call) throws CallStateException {
        addTaint(call.getTaint());
    if(call.getConnections().size() == 0)        
        {
            CallStateException var7CA8A13B34F3A8E0BB05065301525BCE_1514338248 = new CallStateException("no connections in call");
            var7CA8A13B34F3A8E0BB05065301525BCE_1514338248.addTaint(taint);
            throw var7CA8A13B34F3A8E0BB05065301525BCE_1514338248;
        } //End block
    if(call == ringingCall)        
        {
    if(Phone.DEBUG_PHONE)            
            log("(ringing) hangup waiting or background");
            cm.hangupWaitingOrBackground(obtainCompleteMessage());
        } //End block
        else
    if(call == foregroundCall)        
        {
    if(call.isDialingOrAlerting())            
            {
    if(Phone.DEBUG_PHONE)                
                {
                    log("(foregnd) hangup dialing or alerting...");
                } //End block
                hangup((CdmaConnection)(call.getConnections().get(0)));
            } //End block
            else
            {
                hangupForegroundResumeBackground();
            } //End block
        } //End block
        else
    if(call == backgroundCall)        
        {
    if(ringingCall.isRinging())            
            {
    if(Phone.DEBUG_PHONE)                
                {
                    log("hangup all conns in background call");
                } //End block
                hangupAllConnections(call);
            } //End block
            else
            {
                hangupWaitingOrBackground();
            } //End block
        } //End block
        else
        {
            RuntimeException var8E9EC94AF4906F8A59FD035228DE17CE_711256151 = new RuntimeException ("CdmaCall " + call +
                    "does not belong to CdmaCallTracker " + this);
            var8E9EC94AF4906F8A59FD035228DE17CE_711256151.addTaint(taint);
            throw var8E9EC94AF4906F8A59FD035228DE17CE_711256151;
        } //End block
        call.onHangupLocal();
        phone.notifyPreciseCallStateChanged();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.034 -0400", hash_original_method = "E840FBD61F8E6AF3DE802E32C39DD93E", hash_generated_method = "71FDB30D1F27C61E34ADE7E6DB4F8FE8")
     void hangupWaitingOrBackground() {
    if(Phone.DEBUG_PHONE)        
        log("hangupWaitingOrBackground");
        cm.hangupWaitingOrBackground(obtainCompleteMessage());
        // ---------- Original Method ----------
        //if (Phone.DEBUG_PHONE) log("hangupWaitingOrBackground");
        //cm.hangupWaitingOrBackground(obtainCompleteMessage());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.034 -0400", hash_original_method = "D10B26113142441F52E905015040129F", hash_generated_method = "777D99ECDB3D6E9138E0EBC648830F13")
     void hangupForegroundResumeBackground() {
    if(Phone.DEBUG_PHONE)        
        log("hangupForegroundResumeBackground");
        cm.hangupForegroundResumeBackground(obtainCompleteMessage());
        // ---------- Original Method ----------
        //if (Phone.DEBUG_PHONE) log("hangupForegroundResumeBackground");
        //cm.hangupForegroundResumeBackground(obtainCompleteMessage());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.034 -0400", hash_original_method = "46F42EF7B8FEEB9638F3768D6C678D5F", hash_generated_method = "E9AFB3B8610B66FB4B2F3EDC3B725357")
     void hangupConnectionByIndex(CdmaCall call, int index) throws CallStateException {
        addTaint(index);
        addTaint(call.getTaint());
        int count = call.connections.size();
for(int i = 0;i < count;i++)
        {
            CdmaConnection cn = (CdmaConnection)call.connections.get(i);
    if(cn.getCDMAIndex() == index)            
            {
                cm.hangupConnection(index, obtainCompleteMessage());
                return;
            } //End block
        } //End block
        CallStateException var1FF6C7272361548DF4B718F88E457962_94014452 = new CallStateException("no gsm index found");
        var1FF6C7272361548DF4B718F88E457962_94014452.addTaint(taint);
        throw var1FF6C7272361548DF4B718F88E457962_94014452;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.035 -0400", hash_original_method = "C8ED8584ACDA74B40EBCC108129D9E6B", hash_generated_method = "E6FC6FB46600305EE771FE87B5AE51C4")
     void hangupAllConnections(CdmaCall call) throws CallStateException {
        addTaint(call.getTaint());
        try 
        {
            int count = call.connections.size();
for(int i = 0;i < count;i++)
            {
                CdmaConnection cn = (CdmaConnection)call.connections.get(i);
                cm.hangupConnection(cn.getCDMAIndex(), obtainCompleteMessage());
            } //End block
        } //End block
        catch (CallStateException ex)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.035 -0400", hash_original_method = "DA3BA6D275DE18892F45915EBAE08DC8", hash_generated_method = "BBF9FDAEB91E0517741BF8430475679E")
     CdmaConnection getConnectionByIndex(CdmaCall call, int index) throws CallStateException {
        addTaint(index);
        addTaint(call.getTaint());
        int count = call.connections.size();
for(int i = 0;i < count;i++)
        {
            CdmaConnection cn = (CdmaConnection)call.connections.get(i);
    if(cn.getCDMAIndex() == index)            
            {
CdmaConnection varDCCFDFA3C846990C7CD62841D6F23059_84945072 =                 cn;
                varDCCFDFA3C846990C7CD62841D6F23059_84945072.addTaint(taint);
                return varDCCFDFA3C846990C7CD62841D6F23059_84945072;
            } //End block
        } //End block
CdmaConnection var540C13E9E156B687226421B24F2DF178_1932669545 =         null;
        var540C13E9E156B687226421B24F2DF178_1932669545.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1932669545;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.035 -0400", hash_original_method = "EB39E7AA8B070FEFE523D7C5104C422F", hash_generated_method = "F2B22B9C2961AD4C91E3828C52AE1EE4")
    private void flashAndSetGenericTrue() throws CallStateException {
        cm.sendCDMAFeatureCode("", obtainMessage(EVENT_SWITCH_RESULT));
        foregroundCall.setGeneric(true);
        phone.notifyPreciseCallStateChanged();
        // ---------- Original Method ----------
        //cm.sendCDMAFeatureCode("", obtainMessage(EVENT_SWITCH_RESULT));
        //foregroundCall.setGeneric(true);
        //phone.notifyPreciseCallStateChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.036 -0400", hash_original_method = "65CD53B5AAA831AF61B9937ED3D66C8B", hash_generated_method = "E489F1507A0FEEB6ECDF7A14200F8F57")
    private Phone.SuppService getFailedService(int what) {
        addTaint(what);
switch(what){
        case EVENT_SWITCH_RESULT:
Phone.SuppService varE22DD80AE4A37137D78E9AD8129DDDE5_1385170256 =         Phone.SuppService.SWITCH;
        varE22DD80AE4A37137D78E9AD8129DDDE5_1385170256.addTaint(taint);
        return varE22DD80AE4A37137D78E9AD8129DDDE5_1385170256;
        case EVENT_CONFERENCE_RESULT:
Phone.SuppService var5C5B8916362367E090BABE152AC535D8_1467921541 =         Phone.SuppService.CONFERENCE;
        var5C5B8916362367E090BABE152AC535D8_1467921541.addTaint(taint);
        return var5C5B8916362367E090BABE152AC535D8_1467921541;
        case EVENT_SEPARATE_RESULT:
Phone.SuppService var344A7C631A306D913F88C3977DA00F12_1715792950 =         Phone.SuppService.SEPARATE;
        var344A7C631A306D913F88C3977DA00F12_1715792950.addTaint(taint);
        return var344A7C631A306D913F88C3977DA00F12_1715792950;
        case EVENT_ECT_RESULT:
Phone.SuppService var3A80E047DEE6FAD19C2D6A342608C348_1722578909 =         Phone.SuppService.TRANSFER;
        var3A80E047DEE6FAD19C2D6A342608C348_1722578909.addTaint(taint);
        return var3A80E047DEE6FAD19C2D6A342608C348_1722578909;
}Phone.SuppService varCF97A101D0A9E76722DC33F7967766DE_808567779 =         Phone.SuppService.UNKNOWN;
        varCF97A101D0A9E76722DC33F7967766DE_808567779.addTaint(taint);
        return varCF97A101D0A9E76722DC33F7967766DE_808567779;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.036 -0400", hash_original_method = "6E2D3B844106C3BA4166C29F96BB7EA0", hash_generated_method = "3D35CA8E198B65065816E56AAB25BAB7")
    private void handleRadioNotAvailable() {
        pollCallsWhenSafe();
        // ---------- Original Method ----------
        //pollCallsWhenSafe();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.036 -0400", hash_original_method = "8A157B3E162ABAFDC3219E193FD9AF9E", hash_generated_method = "56D50D87F0BD244AB844F179DC9669FD")
    private void notifyCallWaitingInfo(CdmaCallWaitingNotification obj) {
        addTaint(obj.getTaint());
    if(callWaitingRegistrants != null)        
        {
            callWaitingRegistrants.notifyRegistrants(new AsyncResult(null, obj, null));
        } //End block
        // ---------- Original Method ----------
        //if (callWaitingRegistrants != null) {
            //callWaitingRegistrants.notifyRegistrants(new AsyncResult(null, obj, null));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.036 -0400", hash_original_method = "8AEB0E73C414AF95EF44C542FCF55311", hash_generated_method = "64D97BF275CB00A21BC4AF2757ACAFD3")
    private void handleCallWaitingInfo(CdmaCallWaitingNotification cw) {
        addTaint(cw.getTaint());
    if(foregroundCall.connections.size() > 1)        
        {
            foregroundCall.setGeneric(true);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.038 -0400", hash_original_method = "D1EB700FB6D9FD1E2DF39441FB36A7DD", hash_generated_method = "EDA91AE6E79E4A8F2F38E4AB141D4A83")
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        AsyncResult ar;
switch(msg.what){
        case EVENT_POLL_CALLS_RESULT:
        {
            Log.d(LOG_TAG, "Event EVENT_POLL_CALLS_RESULT Received");
            ar = (AsyncResult)msg.obj;
    if(msg == lastRelevantPoll)            
            {
    if(DBG_POLL)                
                log(
                            "handle EVENT_POLL_CALL_RESULT: set needsPoll=F");
                needsPoll = false;
                lastRelevantPoll = null;
                handlePollCalls((AsyncResult)msg.obj);
            } //End block
        } //End block
        break;
        case EVENT_OPERATION_COMPLETE:
        operationComplete();
        break;
        case EVENT_SWITCH_RESULT:
        break;
        case EVENT_GET_LAST_CALL_FAIL_CAUSE:
        int causeCode;
        ar = (AsyncResult)msg.obj;
        operationComplete();
    if(ar.exception != null)        
        {
            causeCode = CallFailCause.NORMAL_CLEARING;
        } //End block
        else
        {
            causeCode = ((int[])ar.result)[0];
        } //End block
for(int i = 0, s =  droppedDuringPoll.size();i < s;i++)
        {
            CdmaConnection conn = droppedDuringPoll.get(i);
            conn.onRemoteDisconnect(causeCode);
        } //End block
        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
        droppedDuringPoll.clear();
        break;
        case EVENT_REPOLL_AFTER_DELAY:
        case EVENT_CALL_STATE_CHANGE:
        pollCallsWhenSafe();
        break;
        case EVENT_RADIO_AVAILABLE:
        handleRadioAvailable();
        break;
        case EVENT_RADIO_NOT_AVAILABLE:
        handleRadioNotAvailable();
        break;
        case EVENT_EXIT_ECM_RESPONSE_CDMA:
    if(pendingCallInEcm)        
        {
            cm.dial(pendingMO.address, pendingCallClirMode, obtainCompleteMessage());
            pendingCallInEcm = false;
        } //End block
        phone.unsetOnEcbModeExitResponse(this);
        break;
        case EVENT_CALL_WAITING_INFO_CDMA:
        ar = (AsyncResult)msg.obj;
    if(ar.exception == null)        
        {
            handleCallWaitingInfo((CdmaCallWaitingNotification)ar.result);
            Log.d(LOG_TAG, "Event EVENT_CALL_WAITING_INFO_CDMA Received");
        } //End block
        break;
        case EVENT_THREE_WAY_DIAL_L2_RESULT_CDMA:
        ar = (AsyncResult)msg.obj;
    if(ar.exception == null)        
        {
            pendingMO.onConnectedInOrOut();
            pendingMO = null;
        } //End block
        break;
        default:
        {
            RuntimeException var1F26AA1784701DB7B59508D786B99B94_786351748 = new RuntimeException("unexpected event not handled");
            var1F26AA1784701DB7B59508D786B99B94_786351748.addTaint(taint);
            throw var1F26AA1784701DB7B59508D786B99B94_786351748;
        } //End block
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.038 -0400", hash_original_method = "53D0BC70C94C51E4941A4869C727C1EF", hash_generated_method = "995B6294B11CCF29EC04DAAC7C70E58D")
    private void handleEcmTimer(int action) {
        addTaint(action);
        phone.handleTimerInEmergencyCallbackMode(action);
switch(action){
        case CDMAPhone.CANCEL_ECM_TIMER:
        mIsEcmTimerCanceled = true;
        break;
        case CDMAPhone.RESTART_ECM_TIMER:
        mIsEcmTimerCanceled = false;
        break;
        default:
}
        // ---------- Original Method ----------
        //phone.handleTimerInEmergencyCallbackMode(action);
        //switch(action) {
        //case CDMAPhone.CANCEL_ECM_TIMER: mIsEcmTimerCanceled = true; break;
        //case CDMAPhone.RESTART_ECM_TIMER: mIsEcmTimerCanceled = false; break;
        //default:
            //Log.e(LOG_TAG, "handleEcmTimer, unsupported action " + action);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.039 -0400", hash_original_method = "E45025BA49DB75441FB058D043F13559", hash_generated_method = "2A099C8EF9D96CBDF8F3E011E007AF99")
    private void disableDataCallInEmergencyCall(String dialString) {
        addTaint(dialString.getTaint());
    if(PhoneNumberUtils.isLocalEmergencyNumber(dialString, phone.getContext()))        
        {
    if(Phone.DEBUG_PHONE)            
            log("disableDataCallInEmergencyCall");
            mIsInEmergencyCall = true;
            phone.mDataConnectionTracker.setInternalDataEnabled(false);
        } //End block
        // ---------- Original Method ----------
        //if (PhoneNumberUtils.isLocalEmergencyNumber(dialString, phone.getContext())) {
            //if (Phone.DEBUG_PHONE) log("disableDataCallInEmergencyCall");
            //mIsInEmergencyCall = true;
            //phone.mDataConnectionTracker.setInternalDataEnabled(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.039 -0400", hash_original_method = "4B192230440137F94B49778D22CB7CD2", hash_generated_method = "D8F1131BD32CE99E8C00BAE82AA1B732")
    private void checkAndEnableDataCallAfterEmergencyCallDropped() {
    if(mIsInEmergencyCall)        
        {
            mIsInEmergencyCall = false;
            String inEcm = SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
    if(Phone.DEBUG_PHONE)            
            {
                log("checkAndEnableDataCallAfterEmergencyCallDropped,inEcm=" + inEcm);
            } //End block
    if(inEcm.compareTo("false") == 0)            
            {
                phone.mDataConnectionTracker.setInternalDataEnabled(true);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.040 -0400", hash_original_method = "D359964B058F5C9ECC2D15DB024983EF", hash_generated_method = "AD34449245BAB73935AC635B76D0DE3A")
    private Connection checkMtFindNewRinging(DriverCall dc, int i) {
        Connection newRinging = null;
        connections[i] = new CdmaConnection(phone.getContext(), dc, this, i);
    if(connections[i].getCall() == ringingCall)        
        {
            newRinging = connections[i];
    if(Phone.DEBUG_PHONE)            
            log("Notify new ring " + dc);
        } //End block
        else
        {
    if(dc.state != DriverCall.State.ALERTING
                && dc.state != DriverCall.State.DIALING)            
            {
                connections[i].connectTime = System.currentTimeMillis();
            } //End block
        } //End block
Connection var94D414EAF654DC6D341716982125A4F3_478927189 =         newRinging;
        var94D414EAF654DC6D341716982125A4F3_478927189.addTaint(taint);
        return var94D414EAF654DC6D341716982125A4F3_478927189;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.041 -0400", hash_original_method = "1842D0C2283B311B2A29E474687D9235", hash_generated_method = "86E4F5566FEBDAD7E96A66879053E7B1")
     boolean isInEmergencyCall() {
        boolean var2A38944C11BF5A57D2726A92DC4FCE09_1365096593 = (mIsInEmergencyCall);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2111181673 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2111181673;
        // ---------- Original Method ----------
        //return mIsInEmergencyCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.041 -0400", hash_original_method = "FF708F6402A7A18425D7FC72639DE93E", hash_generated_method = "C1AD46F8C6B7AF0D4AC495360BF711BE")
    protected void log(String msg) {
        addTaint(msg.getTaint());
        Log.d(LOG_TAG, "[CdmaCallTracker] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CdmaCallTracker] " + msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.041 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.041 -0400", hash_original_field = "CC792B139E86B59BF5644A291C349001", hash_generated_field = "A7B75AEFB3EF53E7FDD36572121557CF")

    private static final boolean REPEAT_POLLING = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.041 -0400", hash_original_field = "BA76C0C87FE0928477EB48E458A4151B", hash_generated_field = "5105F543721DFE6C6FC4422BBF3A00CF")

    private static final boolean DBG_POLL = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.041 -0400", hash_original_field = "5D8CCE6E8CAE49F3DAE5020BF6731533", hash_generated_field = "3D5BB3B6A3F2D8A508B231AB505DE10A")

    static final int MAX_CONNECTIONS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.041 -0400", hash_original_field = "109C1DEC6EE2198ED540651FC4E6F2F6", hash_generated_field = "50E5124FACE9F1EADB0A251AF8BCB55D")

    static final int MAX_CONNECTIONS_PER_CALL = 1;
}

