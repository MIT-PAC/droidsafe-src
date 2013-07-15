package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.961 -0400", hash_original_field = "2565E483715F30971B59A5D44D37906E", hash_generated_field = "716BB86B5900AA12E51F40C44C703D1A")

    GsmConnection connections[] = new GsmConnection[MAX_CONNECTIONS];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.961 -0400", hash_original_field = "8A0F3DEC66CFEEB2ECB457E5EA849D37", hash_generated_field = "D5D06964BBEC51B3D32BF2A900BC948B")

    RegistrantList voiceCallEndedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.961 -0400", hash_original_field = "CDE5B90F2260D3DC8A84E35500B6775B", hash_generated_field = "A661D5B9F6F26D0E5672FF445A016D80")

    RegistrantList voiceCallStartedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.961 -0400", hash_original_field = "27AA92BBC7150E23D93BC9CA4B0E465E", hash_generated_field = "6259F14BEC37C0C21BE48F9CE7762FC4")

    ArrayList<GsmConnection> droppedDuringPoll = new ArrayList<GsmConnection>(MAX_CONNECTIONS);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.962 -0400", hash_original_field = "B2247305C4B8A31C2B4E650071B1B3BF", hash_generated_field = "56A224E06C0E72AE349815A9683F7814")

    GsmCall ringingCall = new GsmCall(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.962 -0400", hash_original_field = "88561F1701B495B398AB84B0E4C67EBA", hash_generated_field = "80691ED64FA1F03FBF32700B990EA539")

    GsmCall foregroundCall = new GsmCall(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.962 -0400", hash_original_field = "F61B2CF2D5B2C43DC5DBB8B1382E52DB", hash_generated_field = "A38ADB338808573C1F23A56E253D4F91")

    GsmCall backgroundCall = new GsmCall(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.962 -0400", hash_original_field = "FFF3375B9BFF76918F491666B68949AD", hash_generated_field = "2F30437FCDD818EF97D2AA98F8F5EC0A")

    GsmConnection pendingMO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.962 -0400", hash_original_field = "1A8ABF13D702402EE54BFD56E4804126", hash_generated_field = "02C3359C89BD9A3EFAD64C6344B66724")

    boolean hangupPendingMO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.962 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "690DC9441FA6BD04E0472B4DF9E035F8")

    GSMPhone phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.962 -0400", hash_original_field = "B262B2D3199ADD4E02EA2C990EA1FE1C", hash_generated_field = "9D75FD49CDE6D2073BBD4C557B93C735")

    boolean desiredMute = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.962 -0400", hash_original_field = "2A29A007EEA18F3490433A6FDFAFB956", hash_generated_field = "40E232559DDE23609D651E7B63760E6C")

    Phone.State state = Phone.State.IDLE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.963 -0400", hash_original_method = "22EA361F37F32F253874F064459157A8", hash_generated_method = "54B77D153BFCBE16C1C823434C7FC046")
      GsmCallTracker(GSMPhone phone) {
        this.phone = phone;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.963 -0400", hash_original_method = "FC4B042AA431A9477437EAA2E6A7E3DB", hash_generated_method = "DD554E1F5A1BDDC43DB7DEDF159DDE3D")
    public void dispose() {
        cm.unregisterForCallStateChanged(this);
        cm.unregisterForOn(this);
        cm.unregisterForNotAvailable(this);
for(GsmConnection c : connections)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.963 -0400", hash_original_method = "865768B4EC6A5A664005D55855DE8CD7", hash_generated_method = "6A1448BDD14ADEB0FF56B2BB2A4D0313")
    protected void finalize() {
        Log.d(LOG_TAG, "GsmCallTracker finalized");
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "GsmCallTracker finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.964 -0400", hash_original_method = "74524BAB538005AE6F8AB18E196FEB02", hash_generated_method = "1D6E0C22A91939C1AB4D3D5A43AA0F74")
    public void registerForVoiceCallStarted(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        Registrant r = new Registrant(h, what, obj);
        voiceCallStartedRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //voiceCallStartedRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.964 -0400", hash_original_method = "3C910908B4B98998A7936D8F8AE4D170", hash_generated_method = "9B599ABCA06C3CB11CC100B15D3B63CA")
    public void unregisterForVoiceCallStarted(Handler h) {
        addTaint(h.getTaint());
        voiceCallStartedRegistrants.remove(h);
        // ---------- Original Method ----------
        //voiceCallStartedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.964 -0400", hash_original_method = "D7F70C00A904DE96D26BDF7C49F41DAA", hash_generated_method = "F39032696EB04762CD7CB95E9F29536E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.965 -0400", hash_original_method = "91176AF98778238DB3B453F2FC7D9448", hash_generated_method = "F7797E359E79D0A4733AB0A2C469DA29")
    public void unregisterForVoiceCallEnded(Handler h) {
        addTaint(h.getTaint());
        voiceCallEndedRegistrants.remove(h);
        // ---------- Original Method ----------
        //voiceCallEndedRegistrants.remove(h);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.965 -0400", hash_original_method = "4204FB660E281B4690A876C95432F574", hash_generated_method = "A75C901EFF83B466BC0A38EC27756759")
    private void fakeHoldForegroundBeforeDial() {
        List<Connection> connCopy;
        connCopy = (List<Connection>) foregroundCall.connections.clone();
for(int i = 0, s = connCopy.size();i < s;i++)
        {
            GsmConnection conn = (GsmConnection)connCopy.get(i);
            conn.fakeHoldBeforeDial();
        } //End block
        // ---------- Original Method ----------
        //List<Connection> connCopy;
        //connCopy = (List<Connection>) foregroundCall.connections.clone();
        //for (int i = 0, s = connCopy.size() ; i < s ; i++) {
            //GsmConnection conn = (GsmConnection)connCopy.get(i);
            //conn.fakeHoldBeforeDial();
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.966 -0400", hash_original_method = "BBA59EE5F024CF032CB3FE359D476C6C", hash_generated_method = "5443489DAFAD3044122C48B306307CF2")
     Connection dial(String dialString, int clirMode, UUSInfo uusInfo) throws CallStateException {
        addTaint(uusInfo.getTaint());
        addTaint(clirMode);
        clearDisconnected();
    if(!canDial())        
        {
            CallStateException var9E415163F1883D794EA7CDA9658E5AEC_398260609 = new CallStateException("cannot dial in current state");
            var9E415163F1883D794EA7CDA9658E5AEC_398260609.addTaint(taint);
            throw var9E415163F1883D794EA7CDA9658E5AEC_398260609;
        } //End block
    if(foregroundCall.getState() == GsmCall.State.ACTIVE)        
        {
            switchWaitingOrHoldingAndActive();
            fakeHoldForegroundBeforeDial();
        } //End block
    if(foregroundCall.getState() != GsmCall.State.IDLE)        
        {
            CallStateException var9E415163F1883D794EA7CDA9658E5AEC_1597642194 = new CallStateException("cannot dial in current state");
            var9E415163F1883D794EA7CDA9658E5AEC_1597642194.addTaint(taint);
            throw var9E415163F1883D794EA7CDA9658E5AEC_1597642194;
        } //End block
        pendingMO = new GsmConnection(phone.getContext(), dialString, this, foregroundCall);
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
            cm.dial(pendingMO.address, clirMode, uusInfo, obtainCompleteMessage());
        } //End block
        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
Connection var14BF1C8BBB47038F78C99A232B009337_1207716502 =         pendingMO;
        var14BF1C8BBB47038F78C99A232B009337_1207716502.addTaint(taint);
        return var14BF1C8BBB47038F78C99A232B009337_1207716502;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.967 -0400", hash_original_method = "890AB92FDE9FE4C57A1E95495C075681", hash_generated_method = "621ECD6F6C539B4D47142936FB7A38BF")
     Connection dial(String dialString) throws CallStateException {
        addTaint(dialString.getTaint());
Connection var94E034C85B48B62249C140B682519A00_2046191175 =         dial(dialString, CommandsInterface.CLIR_DEFAULT, null);
        var94E034C85B48B62249C140B682519A00_2046191175.addTaint(taint);
        return var94E034C85B48B62249C140B682519A00_2046191175;
        // ---------- Original Method ----------
        //return dial(dialString, CommandsInterface.CLIR_DEFAULT, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.967 -0400", hash_original_method = "2869CC3BF5EF49E3F89EEEBD1A0C3021", hash_generated_method = "BB81512B57967AD1B0FD417CFC0BDA3D")
     Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        addTaint(uusInfo.getTaint());
        addTaint(dialString.getTaint());
Connection var598D81C3CFA9F27F1859C4E612C50BA6_1281152364 =         dial(dialString, CommandsInterface.CLIR_DEFAULT, uusInfo);
        var598D81C3CFA9F27F1859C4E612C50BA6_1281152364.addTaint(taint);
        return var598D81C3CFA9F27F1859C4E612C50BA6_1281152364;
        // ---------- Original Method ----------
        //return dial(dialString, CommandsInterface.CLIR_DEFAULT, uusInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.967 -0400", hash_original_method = "EC4F7F51F5F0A4F61E0068E2B7BE6FF2", hash_generated_method = "999750526C2A504D4A125C20D4B88375")
     Connection dial(String dialString, int clirMode) throws CallStateException {
        addTaint(clirMode);
        addTaint(dialString.getTaint());
Connection var9A8CCC4DE57DB8AA6DEA33B3FE886131_1792151388 =         dial(dialString, clirMode, null);
        var9A8CCC4DE57DB8AA6DEA33B3FE886131_1792151388.addTaint(taint);
        return var9A8CCC4DE57DB8AA6DEA33B3FE886131_1792151388;
        // ---------- Original Method ----------
        //return dial(dialString, clirMode, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.968 -0400", hash_original_method = "6B4B3AB5A2A59FF5FB364E6A16F49177", hash_generated_method = "CCB1C3092580F66C0D01CD55CF9F25AF")
     void acceptCall() throws CallStateException {
    if(ringingCall.getState() == GsmCall.State.INCOMING)        
        {
            setMute(false);
            cm.acceptCall(obtainCompleteMessage());
        } //End block
        else
    if(ringingCall.getState() == GsmCall.State.WAITING)        
        {
            setMute(false);
            switchWaitingOrHoldingAndActive();
        } //End block
        else
        {
            CallStateException var566A6D1258D88782F935EBCAFFB89CEC_468230762 = new CallStateException("phone not ringing");
            var566A6D1258D88782F935EBCAFFB89CEC_468230762.addTaint(taint);
            throw var566A6D1258D88782F935EBCAFFB89CEC_468230762;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.968 -0400", hash_original_method = "9B02E01190499DD77CD223AD7831C55B", hash_generated_method = "04542DF762E92AE60A0C1FA501785B7F")
     void rejectCall() throws CallStateException {
    if(ringingCall.getState().isRinging())        
        {
            cm.rejectCall(obtainCompleteMessage());
        } //End block
        else
        {
            CallStateException var566A6D1258D88782F935EBCAFFB89CEC_156229288 = new CallStateException("phone not ringing");
            var566A6D1258D88782F935EBCAFFB89CEC_156229288.addTaint(taint);
            throw var566A6D1258D88782F935EBCAFFB89CEC_156229288;
        } //End block
        // ---------- Original Method ----------
        //if (ringingCall.getState().isRinging()) {
            //cm.rejectCall(obtainCompleteMessage());
        //} else {
            //throw new CallStateException("phone not ringing");
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.968 -0400", hash_original_method = "F087D3CDA5FED1EA3EF910AA070D114E", hash_generated_method = "F160EC9F93FA203AC117771008CA9550")
     void switchWaitingOrHoldingAndActive() throws CallStateException {
    if(ringingCall.getState() == GsmCall.State.INCOMING)        
        {
            CallStateException varE42FEAD21291D7FDB488D92CAF81155C_939559235 = new CallStateException("cannot be in the incoming state");
            varE42FEAD21291D7FDB488D92CAF81155C_939559235.addTaint(taint);
            throw varE42FEAD21291D7FDB488D92CAF81155C_939559235;
        } //End block
        else
        {
            cm.switchWaitingOrHoldingAndActive(
                    obtainCompleteMessage(EVENT_SWITCH_RESULT));
        } //End block
        // ---------- Original Method ----------
        //if (ringingCall.getState() == GsmCall.State.INCOMING) {
            //throw new CallStateException("cannot be in the incoming state");
        //} else {
            //cm.switchWaitingOrHoldingAndActive(
                    //obtainCompleteMessage(EVENT_SWITCH_RESULT));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.969 -0400", hash_original_method = "21B7458D194C157C186B70ABA7C7D274", hash_generated_method = "25B6942AE32BFB6C44A786C1B8AF0EFE")
     void conference() throws CallStateException {
        cm.conference(obtainCompleteMessage(EVENT_CONFERENCE_RESULT));
        // ---------- Original Method ----------
        //cm.conference(obtainCompleteMessage(EVENT_CONFERENCE_RESULT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.969 -0400", hash_original_method = "B9B58214FE30DEB2D41379B25D88E6DD", hash_generated_method = "91DDF637F580C2F12D44ADB525F30440")
     void explicitCallTransfer() throws CallStateException {
        cm.explicitCallTransfer(obtainCompleteMessage(EVENT_ECT_RESULT));
        // ---------- Original Method ----------
        //cm.explicitCallTransfer(obtainCompleteMessage(EVENT_ECT_RESULT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.969 -0400", hash_original_method = "89E1881B087BAA2C040FAFD444B532DA", hash_generated_method = "93C10D32BFEAACBDB937011534F3F686")
     void clearDisconnected() {
        internalClearDisconnected();
        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
        // ---------- Original Method ----------
        //internalClearDisconnected();
        //updatePhoneState();
        //phone.notifyPreciseCallStateChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.969 -0400", hash_original_method = "C3AFF7137220AE966ED90D221261BE5A", hash_generated_method = "06BA53B6A9BC1A4146808AE8DAF5B1DB")
     boolean canConference() {
        boolean varB2F4BAB074D7A5AAFDDD713E1EDB8DD2_589206171 = (foregroundCall.getState() == GsmCall.State.ACTIVE
                && backgroundCall.getState() == GsmCall.State.HOLDING
                && !backgroundCall.isFull()
                && !foregroundCall.isFull());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1462375209 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1462375209;
        // ---------- Original Method ----------
        //return foregroundCall.getState() == GsmCall.State.ACTIVE
                //&& backgroundCall.getState() == GsmCall.State.HOLDING
                //&& !backgroundCall.isFull()
                //&& !foregroundCall.isFull();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.970 -0400", hash_original_method = "808FE91E5748A2C0F0CF7B9BCBDBAE36", hash_generated_method = "5C559D756848592F66E43DFCDECBEE48")
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
                    || !backgroundCall.getState().isAlive());
        boolean var2CB9DF9898E55FD0AD829DC202DDBD1C_716266310 = (ret);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1045354556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1045354556;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.970 -0400", hash_original_method = "E4A32A086AF9F2037148F022098D94F1", hash_generated_method = "0CD554328408E6E486FFAAEF4D7DAD6B")
     boolean canTransfer() {
        boolean varFBCF729B6C39E33DAF200EC821E6E350_1140946470 = (foregroundCall.getState() == GsmCall.State.ACTIVE
                && backgroundCall.getState() == GsmCall.State.HOLDING);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_146324192 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_146324192;
        // ---------- Original Method ----------
        //return foregroundCall.getState() == GsmCall.State.ACTIVE
                //&& backgroundCall.getState() == GsmCall.State.HOLDING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.970 -0400", hash_original_method = "3058DCAC5E1117AE07A379578E7C6A20", hash_generated_method = "F0E9C736A8A4591368CEECFAB84F530D")
    private void internalClearDisconnected() {
        ringingCall.clearDisconnected();
        foregroundCall.clearDisconnected();
        backgroundCall.clearDisconnected();
        // ---------- Original Method ----------
        //ringingCall.clearDisconnected();
        //foregroundCall.clearDisconnected();
        //backgroundCall.clearDisconnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.970 -0400", hash_original_method = "89F67FF5AFAE8FAD9F556239F3E27159", hash_generated_method = "2BF024570E2F2D0D6E52765A11E37AD6")
    private Message obtainCompleteMessage() {
Message varA06F2757B7CF455962BF6FB3E43CCFD1_1376401063 =         obtainCompleteMessage(EVENT_OPERATION_COMPLETE);
        varA06F2757B7CF455962BF6FB3E43CCFD1_1376401063.addTaint(taint);
        return varA06F2757B7CF455962BF6FB3E43CCFD1_1376401063;
        // ---------- Original Method ----------
        //return obtainCompleteMessage(EVENT_OPERATION_COMPLETE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.971 -0400", hash_original_method = "F527C5C3DD4F0176588A0C261AD76B7A", hash_generated_method = "6E522272DF7EA29C4154B7F9200E6363")
    private Message obtainCompleteMessage(int what) {
        addTaint(what);
        pendingOperations++;
        lastRelevantPoll = null;
        needsPoll = true;
    if(DBG_POLL)        
        log("obtainCompleteMessage: pendingOperations=" +
                pendingOperations + ", needsPoll=" + needsPoll);
Message var7D44CBDF570B5CB81D544F0887CE90C1_285252556 =         obtainMessage(what);
        var7D44CBDF570B5CB81D544F0887CE90C1_285252556.addTaint(taint);
        return var7D44CBDF570B5CB81D544F0887CE90C1_285252556;
        // ---------- Original Method ----------
        //pendingOperations++;
        //lastRelevantPoll = null;
        //needsPoll = true;
        //if (DBG_POLL) log("obtainCompleteMessage: pendingOperations=" +
                //pendingOperations + ", needsPoll=" + needsPoll);
        //return obtainMessage(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.971 -0400", hash_original_method = "58BAF8F27C1747875766F27864D59E66", hash_generated_method = "C98F29AD9F95B9780910FA5D5B64F04B")
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
            //Log.e(LOG_TAG,"GsmCallTracker.pendingOperations < 0");
            //pendingOperations = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.972 -0400", hash_original_method = "23DAEFAFA1E8C13E9726BBC375E8DDCB", hash_generated_method = "0D5E938C05714F3C133BA4510A54FA9B")
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
    if(state != oldState)        
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.977 -0400", hash_original_method = "A78B57299010875BB723A4D535396EB8", hash_generated_method = "6744D2B03B2CAF9CF9D1F19D2101B1C7")
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
            GsmConnection conn = connections[i];
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
                    connections[i] = new GsmConnection(phone.getContext(), dc, this, i);
    if(connections[i].getCall() == ringingCall)                    
                    {
                        newRinging = connections[i];
                    } //End block
                    else
                    {
    if(dc.state != DriverCall.State.ALERTING
                                && dc.state != DriverCall.State.DIALING)                        
                        {
                            connections[i].connectTime = System.currentTimeMillis();
                        } //End block
                        unknownConnectionAppeared = true;
                    } //End block
                } //End block
                hasNonHangupStateChanged = true;
            } //End block
            else
    if(conn != null && dc == null)            
            {
                droppedDuringPoll.add(conn);
                connections[i] = null;
            } //End block
            else
    if(conn != null && dc != null && !conn.compareTo(dc))            
            {
                droppedDuringPoll.add(conn);
                connections[i] = new GsmConnection (phone.getContext(), dc, this, i);
    if(connections[i].getCall() == ringingCall)                
                {
                    newRinging = connections[i];
                } //End block
                hasNonHangupStateChanged = true;
            } //End block
            else
    if(conn != null && dc != null)            
            {
                boolean changed;
                changed = conn.update(dc);
                hasNonHangupStateChanged = hasNonHangupStateChanged || changed;
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
        } //End block
    if(newRinging != null)        
        {
            phone.notifyNewRingingConnection(newRinging);
        } //End block
for(int i = droppedDuringPoll.size() - 1;i >= 0;i--)
        {
            GsmConnection conn = droppedDuringPoll.get(i);
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
    if(conn.cause ==
                Connection.DisconnectCause.INVALID_NUMBER)            
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.979 -0400", hash_original_method = "6E2D3B844106C3BA4166C29F96BB7EA0", hash_generated_method = "3D35CA8E198B65065816E56AAB25BAB7")
    private void handleRadioNotAvailable() {
        pollCallsWhenSafe();
        // ---------- Original Method ----------
        //pollCallsWhenSafe();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.980 -0400", hash_original_method = "91645E150D46BD14FDADA00369A88470", hash_generated_method = "613E53D18EA18D59533084AADE05CE56")
    private void dumpState() {
        List l;
        l = ringingCall.getConnections();
for(int i = 0, s = l.size();i < s;i++)
        {
        } //End block
        l = foregroundCall.getConnections();
for(int i = 0, s = l.size();i < s;i++)
        {
        } //End block
        l = backgroundCall.getConnections();
for(int i = 0, s = l.size();i < s;i++)
        {
        } //End block
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.981 -0400", hash_original_method = "9804562F218584F49F1000DB30741809", hash_generated_method = "2C648517129E5EEF76993E69C1F21BD4")
     void hangup(GsmConnection conn) throws CallStateException {
        addTaint(conn.getTaint());
    if(conn.owner != this)        
        {
            CallStateException varE5187875DC96E44BF01258365E075DD3_851778673 = new CallStateException ("GsmConnection " + conn
                                    + "does not belong to GsmCallTracker " + this);
            varE5187875DC96E44BF01258365E075DD3_851778673.addTaint(taint);
            throw varE5187875DC96E44BF01258365E075DD3_851778673;
        } //End block
    if(conn == pendingMO)        
        {
    if(Phone.DEBUG_PHONE)            
            log("hangup: set hangupPendingMO to true");
            hangupPendingMO = true;
        } //End block
        else
        {
            try 
            {
                cm.hangupConnection (conn.getGSMIndex(), obtainCompleteMessage());
            } //End block
            catch (CallStateException ex)
            {
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.981 -0400", hash_original_method = "47E4845D8AA8A793249B2C364233C700", hash_generated_method = "47588577081EA4878569456A35128235")
     void separate(GsmConnection conn) throws CallStateException {
        addTaint(conn.getTaint());
    if(conn.owner != this)        
        {
            CallStateException varE5187875DC96E44BF01258365E075DD3_2025893041 = new CallStateException ("GsmConnection " + conn
                                    + "does not belong to GsmCallTracker " + this);
            varE5187875DC96E44BF01258365E075DD3_2025893041.addTaint(taint);
            throw varE5187875DC96E44BF01258365E075DD3_2025893041;
        } //End block
        try 
        {
            cm.separateConnection (conn.getGSMIndex(),
                obtainCompleteMessage(EVENT_SEPARATE_RESULT));
        } //End block
        catch (CallStateException ex)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.982 -0400", hash_original_method = "8E7DA06B8727FE7EBCD155EA09819106", hash_generated_method = "09D97CBFA339BB68260AAF45EF5FD946")
     void setMute(boolean mute) {
        desiredMute = mute;
        cm.setMute(desiredMute, null);
        // ---------- Original Method ----------
        //desiredMute = mute;
        //cm.setMute(desiredMute, null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.982 -0400", hash_original_method = "11907D6A9C6D8F23B8C0FECA1425D0D1", hash_generated_method = "AF532EC920844D5E9B8B3C515131BA17")
     boolean getMute() {
        boolean var8C4FD417B21794EC88BA7D0D7F766EFA_1548855892 = (desiredMute);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_672275529 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_672275529;
        // ---------- Original Method ----------
        //return desiredMute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.983 -0400", hash_original_method = "2269CD2B285766A5A3A0163535ACAF72", hash_generated_method = "4AB402C34EDB0286A03685F4FF3B152F")
     void hangup(GsmCall call) throws CallStateException {
        addTaint(call.getTaint());
    if(call.getConnections().size() == 0)        
        {
            CallStateException var7CA8A13B34F3A8E0BB05065301525BCE_741627703 = new CallStateException("no connections in call");
            var7CA8A13B34F3A8E0BB05065301525BCE_741627703.addTaint(taint);
            throw var7CA8A13B34F3A8E0BB05065301525BCE_741627703;
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
                hangup((GsmConnection)(call.getConnections().get(0)));
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
            RuntimeException var697A06C8794E8BAC5D1529FE82AEAC7C_151145598 = new RuntimeException ("GsmCall " + call +
                    "does not belong to GsmCallTracker " + this);
            var697A06C8794E8BAC5D1529FE82AEAC7C_151145598.addTaint(taint);
            throw var697A06C8794E8BAC5D1529FE82AEAC7C_151145598;
        } //End block
        call.onHangupLocal();
        phone.notifyPreciseCallStateChanged();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.984 -0400", hash_original_method = "E840FBD61F8E6AF3DE802E32C39DD93E", hash_generated_method = "71FDB30D1F27C61E34ADE7E6DB4F8FE8")
     void hangupWaitingOrBackground() {
    if(Phone.DEBUG_PHONE)        
        log("hangupWaitingOrBackground");
        cm.hangupWaitingOrBackground(obtainCompleteMessage());
        // ---------- Original Method ----------
        //if (Phone.DEBUG_PHONE) log("hangupWaitingOrBackground");
        //cm.hangupWaitingOrBackground(obtainCompleteMessage());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.984 -0400", hash_original_method = "D10B26113142441F52E905015040129F", hash_generated_method = "777D99ECDB3D6E9138E0EBC648830F13")
     void hangupForegroundResumeBackground() {
    if(Phone.DEBUG_PHONE)        
        log("hangupForegroundResumeBackground");
        cm.hangupForegroundResumeBackground(obtainCompleteMessage());
        // ---------- Original Method ----------
        //if (Phone.DEBUG_PHONE) log("hangupForegroundResumeBackground");
        //cm.hangupForegroundResumeBackground(obtainCompleteMessage());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.985 -0400", hash_original_method = "5F5FEE0C434961483150E08A4EE95AC6", hash_generated_method = "A0EC502BA933B7143884E1D33FB3510B")
     void hangupConnectionByIndex(GsmCall call, int index) throws CallStateException {
        addTaint(index);
        addTaint(call.getTaint());
        int count = call.connections.size();
for(int i = 0;i < count;i++)
        {
            GsmConnection cn = (GsmConnection)call.connections.get(i);
    if(cn.getGSMIndex() == index)            
            {
                cm.hangupConnection(index, obtainCompleteMessage());
                return;
            } //End block
        } //End block
        CallStateException var1FF6C7272361548DF4B718F88E457962_843533332 = new CallStateException("no gsm index found");
        var1FF6C7272361548DF4B718F88E457962_843533332.addTaint(taint);
        throw var1FF6C7272361548DF4B718F88E457962_843533332;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.985 -0400", hash_original_method = "F41FC136282F9A01160C0582CC307C0B", hash_generated_method = "5EF67C43478469289EE4DF74EA81BB79")
     void hangupAllConnections(GsmCall call) throws CallStateException {
        addTaint(call.getTaint());
        try 
        {
            int count = call.connections.size();
for(int i = 0;i < count;i++)
            {
                GsmConnection cn = (GsmConnection)call.connections.get(i);
                cm.hangupConnection(cn.getGSMIndex(), obtainCompleteMessage());
            } //End block
        } //End block
        catch (CallStateException ex)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.986 -0400", hash_original_method = "A13EE98B51441FF2D592407455BBCDEE", hash_generated_method = "7EA867F4A78A3D64FB23BACB7C4E6207")
     GsmConnection getConnectionByIndex(GsmCall call, int index) throws CallStateException {
        addTaint(index);
        addTaint(call.getTaint());
        int count = call.connections.size();
for(int i = 0;i < count;i++)
        {
            GsmConnection cn = (GsmConnection)call.connections.get(i);
    if(cn.getGSMIndex() == index)            
            {
GsmConnection varDCCFDFA3C846990C7CD62841D6F23059_371066800 =                 cn;
                varDCCFDFA3C846990C7CD62841D6F23059_371066800.addTaint(taint);
                return varDCCFDFA3C846990C7CD62841D6F23059_371066800;
            } //End block
        } //End block
GsmConnection var540C13E9E156B687226421B24F2DF178_620811568 =         null;
        var540C13E9E156B687226421B24F2DF178_620811568.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_620811568;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.986 -0400", hash_original_method = "65CD53B5AAA831AF61B9937ED3D66C8B", hash_generated_method = "7E127D5BC61DED7227EA6A406C554850")
    private Phone.SuppService getFailedService(int what) {
        addTaint(what);
switch(what){
        case EVENT_SWITCH_RESULT:
Phone.SuppService varE22DD80AE4A37137D78E9AD8129DDDE5_94442343 =         Phone.SuppService.SWITCH;
        varE22DD80AE4A37137D78E9AD8129DDDE5_94442343.addTaint(taint);
        return varE22DD80AE4A37137D78E9AD8129DDDE5_94442343;
        case EVENT_CONFERENCE_RESULT:
Phone.SuppService var5C5B8916362367E090BABE152AC535D8_445317537 =         Phone.SuppService.CONFERENCE;
        var5C5B8916362367E090BABE152AC535D8_445317537.addTaint(taint);
        return var5C5B8916362367E090BABE152AC535D8_445317537;
        case EVENT_SEPARATE_RESULT:
Phone.SuppService var344A7C631A306D913F88C3977DA00F12_1611008184 =         Phone.SuppService.SEPARATE;
        var344A7C631A306D913F88C3977DA00F12_1611008184.addTaint(taint);
        return var344A7C631A306D913F88C3977DA00F12_1611008184;
        case EVENT_ECT_RESULT:
Phone.SuppService var3A80E047DEE6FAD19C2D6A342608C348_1495095964 =         Phone.SuppService.TRANSFER;
        var3A80E047DEE6FAD19C2D6A342608C348_1495095964.addTaint(taint);
        return var3A80E047DEE6FAD19C2D6A342608C348_1495095964;
}Phone.SuppService varCF97A101D0A9E76722DC33F7967766DE_404064817 =         Phone.SuppService.UNKNOWN;
        varCF97A101D0A9E76722DC33F7967766DE_404064817.addTaint(taint);
        return varCF97A101D0A9E76722DC33F7967766DE_404064817;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.988 -0400", hash_original_method = "3557310B73CAAA9AAFCC17D1978C55CA", hash_generated_method = "BF0233865F94EFFF2461B2A29B995CA7")
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        AsyncResult ar;
switch(msg.what){
        case EVENT_POLL_CALLS_RESULT:
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
        break;
        case EVENT_OPERATION_COMPLETE:
        ar = (AsyncResult)msg.obj;
        operationComplete();
        break;
        case EVENT_SWITCH_RESULT:
        case EVENT_CONFERENCE_RESULT:
        case EVENT_SEPARATE_RESULT:
        case EVENT_ECT_RESULT:
        ar = (AsyncResult)msg.obj;
    if(ar.exception != null)        
        {
            phone.notifySuppServiceFailed(getFailedService(msg.what));
        } //End block
        operationComplete();
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
    if(causeCode == CallFailCause.NO_CIRCUIT_AVAIL ||
                    causeCode == CallFailCause.TEMPORARY_FAILURE ||
                    causeCode == CallFailCause.SWITCHING_CONGESTION ||
                    causeCode == CallFailCause.CHANNEL_NOT_AVAIL ||
                    causeCode == CallFailCause.QOS_NOT_AVAIL ||
                    causeCode == CallFailCause.BEARER_NOT_AVAIL ||
                    causeCode == CallFailCause.ERROR_UNSPECIFIED)        
        {
            GsmCellLocation loc = ((GsmCellLocation)phone.getCellLocation());
            EventLog.writeEvent(EventLogTags.CALL_DROP,
                            causeCode, loc != null ? loc.getCid() : -1,
                            TelephonyManager.getDefault().getNetworkType());
        } //End block
for(int i = 0, s =  droppedDuringPoll.size();i < s;i++)
        {
            GsmConnection conn = droppedDuringPoll.get(i);
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
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.989 -0400", hash_original_method = "00058CA5481BD8963FA4008BDE768325", hash_generated_method = "7C9F625D9D70A23C2BBD1D39BEB4B679")
    protected void log(String msg) {
        addTaint(msg.getTaint());
        Log.d(LOG_TAG, "[GsmCallTracker] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[GsmCallTracker] " + msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.989 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.989 -0400", hash_original_field = "CC792B139E86B59BF5644A291C349001", hash_generated_field = "A7B75AEFB3EF53E7FDD36572121557CF")

    private static final boolean REPEAT_POLLING = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.989 -0400", hash_original_field = "BA76C0C87FE0928477EB48E458A4151B", hash_generated_field = "5105F543721DFE6C6FC4422BBF3A00CF")

    private static final boolean DBG_POLL = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.990 -0400", hash_original_field = "CE6EEE9244EB55C9202207A9FE613260", hash_generated_field = "8F753ACD7835834D546EB26D1C62262A")

    static final int MAX_CONNECTIONS = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.990 -0400", hash_original_field = "ADB34849263F54DFDF2785DA896C5FFD", hash_generated_field = "8D4E679A45FC623FADF51D1315B81097")

    static final int MAX_CONNECTIONS_PER_CALL = 5;
}

