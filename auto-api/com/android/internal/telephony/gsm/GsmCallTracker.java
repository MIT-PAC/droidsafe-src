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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.860 -0400", hash_original_field = "2565E483715F30971B59A5D44D37906E", hash_generated_field = "716BB86B5900AA12E51F40C44C703D1A")

    GsmConnection connections[] = new GsmConnection[MAX_CONNECTIONS];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.860 -0400", hash_original_field = "8A0F3DEC66CFEEB2ECB457E5EA849D37", hash_generated_field = "D5D06964BBEC51B3D32BF2A900BC948B")

    RegistrantList voiceCallEndedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.860 -0400", hash_original_field = "CDE5B90F2260D3DC8A84E35500B6775B", hash_generated_field = "A661D5B9F6F26D0E5672FF445A016D80")

    RegistrantList voiceCallStartedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.860 -0400", hash_original_field = "27AA92BBC7150E23D93BC9CA4B0E465E", hash_generated_field = "6259F14BEC37C0C21BE48F9CE7762FC4")

    ArrayList<GsmConnection> droppedDuringPoll = new ArrayList<GsmConnection>(MAX_CONNECTIONS);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.860 -0400", hash_original_field = "B2247305C4B8A31C2B4E650071B1B3BF", hash_generated_field = "56A224E06C0E72AE349815A9683F7814")

    GsmCall ringingCall = new GsmCall(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.860 -0400", hash_original_field = "88561F1701B495B398AB84B0E4C67EBA", hash_generated_field = "80691ED64FA1F03FBF32700B990EA539")

    GsmCall foregroundCall = new GsmCall(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.860 -0400", hash_original_field = "F61B2CF2D5B2C43DC5DBB8B1382E52DB", hash_generated_field = "A38ADB338808573C1F23A56E253D4F91")

    GsmCall backgroundCall = new GsmCall(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.860 -0400", hash_original_field = "FFF3375B9BFF76918F491666B68949AD", hash_generated_field = "2F30437FCDD818EF97D2AA98F8F5EC0A")

    GsmConnection pendingMO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.860 -0400", hash_original_field = "1A8ABF13D702402EE54BFD56E4804126", hash_generated_field = "02C3359C89BD9A3EFAD64C6344B66724")

    boolean hangupPendingMO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.860 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "690DC9441FA6BD04E0472B4DF9E035F8")

    GSMPhone phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.860 -0400", hash_original_field = "B262B2D3199ADD4E02EA2C990EA1FE1C", hash_generated_field = "9D75FD49CDE6D2073BBD4C557B93C735")

    boolean desiredMute = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.860 -0400", hash_original_field = "2A29A007EEA18F3490433A6FDFAFB956", hash_generated_field = "40E232559DDE23609D651E7B63760E6C")

    Phone.State state = Phone.State.IDLE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.873 -0400", hash_original_method = "22EA361F37F32F253874F064459157A8", hash_generated_method = "54B77D153BFCBE16C1C823434C7FC046")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.899 -0400", hash_original_method = "FC4B042AA431A9477437EAA2E6A7E3DB", hash_generated_method = "FA76742A53A7AE4FED2611B2F090A166")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.900 -0400", hash_original_method = "865768B4EC6A5A664005D55855DE8CD7", hash_generated_method = "6A1448BDD14ADEB0FF56B2BB2A4D0313")
    protected void finalize() {
        Log.d(LOG_TAG, "GsmCallTracker finalized");
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "GsmCallTracker finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.900 -0400", hash_original_method = "74524BAB538005AE6F8AB18E196FEB02", hash_generated_method = "685C7544D8D4A5AC7A0CA69A84D7D4CD")
    public void registerForVoiceCallStarted(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r;
        r = new Registrant(h, what, obj);
        voiceCallStartedRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //voiceCallStartedRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.900 -0400", hash_original_method = "3C910908B4B98998A7936D8F8AE4D170", hash_generated_method = "C25468CA1FE95BD597B1C8B73561A3E0")
    public void unregisterForVoiceCallStarted(Handler h) {
        voiceCallStartedRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //voiceCallStartedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.905 -0400", hash_original_method = "D7F70C00A904DE96D26BDF7C49F41DAA", hash_generated_method = "518F8D06300E35240567EC2598D34AFE")
    public void registerForVoiceCallEnded(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r;
        r = new Registrant(h, what, obj);
        voiceCallEndedRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //voiceCallEndedRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.905 -0400", hash_original_method = "91176AF98778238DB3B453F2FC7D9448", hash_generated_method = "471B41EFF418ACA24812A09760D0C9B8")
    public void unregisterForVoiceCallEnded(Handler h) {
        voiceCallEndedRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //voiceCallEndedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.910 -0400", hash_original_method = "4204FB660E281B4690A876C95432F574", hash_generated_method = "B16D5D0A7AB157E261023B3DF58417A0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.911 -0400", hash_original_method = "BBA59EE5F024CF032CB3FE359D476C6C", hash_generated_method = "EBE082A076F1EEC49E9A6C1FA4350835")
     Connection dial(String dialString, int clirMode, UUSInfo uusInfo) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_665093481 = null; //Variable for return #1
        clearDisconnected();
        {
            boolean var37336DD64F87D8D8C5FEC219FB8725E9_1881411969 = (!canDial());
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("cannot dial in current state");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var0E756393CADA3C09E6B9AC103D5D995B_1171812137 = (foregroundCall.getState() == GsmCall.State.ACTIVE);
            {
                switchWaitingOrHoldingAndActive();
                fakeHoldForegroundBeforeDial();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var123C908F6092967F2402C8E6F98D6087_1320183725 = (foregroundCall.getState() != GsmCall.State.IDLE);
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("cannot dial in current state");
            } //End block
        } //End collapsed parenthetic
        pendingMO = new GsmConnection(phone.getContext(), dialString, this, foregroundCall);
        hangupPendingMO = false;
        {
            boolean varE9C786784B3495FF438205BDA3869C7F_1398354131 = (pendingMO.address == null || pendingMO.address.length() == 0
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
        varB4EAC82CA7396A68D541C85D26508E83_665093481 = pendingMO;
        addTaint(clirMode);
        addTaint(uusInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_665093481.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_665093481;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.917 -0400", hash_original_method = "890AB92FDE9FE4C57A1E95495C075681", hash_generated_method = "66BCB0C920D173B39EEA750AF3BBBD7E")
     Connection dial(String dialString) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_2140155425 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2140155425 = dial(dialString, CommandsInterface.CLIR_DEFAULT, null);
        addTaint(dialString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2140155425.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2140155425;
        // ---------- Original Method ----------
        //return dial(dialString, CommandsInterface.CLIR_DEFAULT, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.917 -0400", hash_original_method = "2869CC3BF5EF49E3F89EEEBD1A0C3021", hash_generated_method = "256BD434C9C630FD8E63D3E85ABE59C1")
     Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_1670553146 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1670553146 = dial(dialString, CommandsInterface.CLIR_DEFAULT, uusInfo);
        addTaint(dialString.getTaint());
        addTaint(uusInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1670553146.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1670553146;
        // ---------- Original Method ----------
        //return dial(dialString, CommandsInterface.CLIR_DEFAULT, uusInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.922 -0400", hash_original_method = "EC4F7F51F5F0A4F61E0068E2B7BE6FF2", hash_generated_method = "49C0AEC93FA2374FDB8E90D4EF9B4F8E")
     Connection dial(String dialString, int clirMode) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_122914474 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_122914474 = dial(dialString, clirMode, null);
        addTaint(dialString.getTaint());
        addTaint(clirMode);
        varB4EAC82CA7396A68D541C85D26508E83_122914474.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_122914474;
        // ---------- Original Method ----------
        //return dial(dialString, clirMode, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.929 -0400", hash_original_method = "6B4B3AB5A2A59FF5FB364E6A16F49177", hash_generated_method = "C9CC4B9C8EDCBE92319F7E746116FC61")
     void acceptCall() throws CallStateException {
        {
            boolean varEDDD3B2A3AC11C08EDA20432FF1C332B_2042119511 = (ringingCall.getState() == GsmCall.State.INCOMING);
            {
                setMute(false);
                cm.acceptCall(obtainCompleteMessage());
            } //End block
            {
                boolean var58438C7CA573DDF61E32D15003EFB49D_50234031 = (ringingCall.getState() == GsmCall.State.WAITING);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.930 -0400", hash_original_method = "9B02E01190499DD77CD223AD7831C55B", hash_generated_method = "AFC41620AD2957E4F7B54EC56D2309C8")
     void rejectCall() throws CallStateException {
        {
            boolean var2DE25B4C7BD786874002695E4305AD0A_1407326029 = (ringingCall.getState().isRinging());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.930 -0400", hash_original_method = "F087D3CDA5FED1EA3EF910AA070D114E", hash_generated_method = "8678B086E395CE907CD03F1E0387D521")
     void switchWaitingOrHoldingAndActive() throws CallStateException {
        {
            boolean varEDDD3B2A3AC11C08EDA20432FF1C332B_1247985910 = (ringingCall.getState() == GsmCall.State.INCOMING);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.930 -0400", hash_original_method = "21B7458D194C157C186B70ABA7C7D274", hash_generated_method = "25B6942AE32BFB6C44A786C1B8AF0EFE")
     void conference() throws CallStateException {
        cm.conference(obtainCompleteMessage(EVENT_CONFERENCE_RESULT));
        // ---------- Original Method ----------
        //cm.conference(obtainCompleteMessage(EVENT_CONFERENCE_RESULT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.931 -0400", hash_original_method = "B9B58214FE30DEB2D41379B25D88E6DD", hash_generated_method = "91DDF637F580C2F12D44ADB525F30440")
     void explicitCallTransfer() throws CallStateException {
        cm.explicitCallTransfer(obtainCompleteMessage(EVENT_ECT_RESULT));
        // ---------- Original Method ----------
        //cm.explicitCallTransfer(obtainCompleteMessage(EVENT_ECT_RESULT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.936 -0400", hash_original_method = "89E1881B087BAA2C040FAFD444B532DA", hash_generated_method = "93C10D32BFEAACBDB937011534F3F686")
     void clearDisconnected() {
        internalClearDisconnected();
        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
        // ---------- Original Method ----------
        //internalClearDisconnected();
        //updatePhoneState();
        //phone.notifyPreciseCallStateChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.937 -0400", hash_original_method = "C3AFF7137220AE966ED90D221261BE5A", hash_generated_method = "F712D1491F1CD9966A31483925FE75A1")
     boolean canConference() {
        boolean var78F41FEE2FA482AD87767611C0E1F98D_1225912313 = (foregroundCall.getState() == GsmCall.State.ACTIVE
                && backgroundCall.getState() == GsmCall.State.HOLDING
                && !backgroundCall.isFull()
                && !foregroundCall.isFull());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1749839281 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1749839281;
        // ---------- Original Method ----------
        //return foregroundCall.getState() == GsmCall.State.ACTIVE
                //&& backgroundCall.getState() == GsmCall.State.HOLDING
                //&& !backgroundCall.isFull()
                //&& !foregroundCall.isFull();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.942 -0400", hash_original_method = "808FE91E5748A2C0F0CF7B9BCBDBAE36", hash_generated_method = "1A4955343C2BCFFB25D654B894C41D3C")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1979099751 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1979099751;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.942 -0400", hash_original_method = "E4A32A086AF9F2037148F022098D94F1", hash_generated_method = "A66DA87E5D63B5E3E2274421129BDAAB")
     boolean canTransfer() {
        boolean varE2A225D3277C2D536901962ABDFBA11D_145845794 = (foregroundCall.getState() == GsmCall.State.ACTIVE
                && backgroundCall.getState() == GsmCall.State.HOLDING);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1853127721 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1853127721;
        // ---------- Original Method ----------
        //return foregroundCall.getState() == GsmCall.State.ACTIVE
                //&& backgroundCall.getState() == GsmCall.State.HOLDING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.943 -0400", hash_original_method = "3058DCAC5E1117AE07A379578E7C6A20", hash_generated_method = "F0E9C736A8A4591368CEECFAB84F530D")
    private void internalClearDisconnected() {
        ringingCall.clearDisconnected();
        foregroundCall.clearDisconnected();
        backgroundCall.clearDisconnected();
        // ---------- Original Method ----------
        //ringingCall.clearDisconnected();
        //foregroundCall.clearDisconnected();
        //backgroundCall.clearDisconnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.947 -0400", hash_original_method = "89F67FF5AFAE8FAD9F556239F3E27159", hash_generated_method = "AA6C86CA4AB0B4BD4542134335013A73")
    private Message obtainCompleteMessage() {
        Message varB4EAC82CA7396A68D541C85D26508E83_1226629688 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1226629688 = obtainCompleteMessage(EVENT_OPERATION_COMPLETE);
        varB4EAC82CA7396A68D541C85D26508E83_1226629688.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1226629688;
        // ---------- Original Method ----------
        //return obtainCompleteMessage(EVENT_OPERATION_COMPLETE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.949 -0400", hash_original_method = "F527C5C3DD4F0176588A0C261AD76B7A", hash_generated_method = "05AD0E932C1B1DE1D5F67BDE1E76ED37")
    private Message obtainCompleteMessage(int what) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1496915024 = null; //Variable for return #1
        lastRelevantPoll = null;
        needsPoll = true;
        log("obtainCompleteMessage: pendingOperations=" +
                pendingOperations + ", needsPoll=" + needsPoll);
        varB4EAC82CA7396A68D541C85D26508E83_1496915024 = obtainMessage(what);
        addTaint(what);
        varB4EAC82CA7396A68D541C85D26508E83_1496915024.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1496915024;
        // ---------- Original Method ----------
        //pendingOperations++;
        //lastRelevantPoll = null;
        //needsPoll = true;
        //if (DBG_POLL) log("obtainCompleteMessage: pendingOperations=" +
                //pendingOperations + ", needsPoll=" + needsPoll);
        //return obtainMessage(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.949 -0400", hash_original_method = "58BAF8F27C1747875766F27864D59E66", hash_generated_method = "2D3BA89F26E49E2281B9F182A50C4977")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.955 -0400", hash_original_method = "23DAEFAFA1E8C13E9726BBC375E8DDCB", hash_generated_method = "FB53AEC785DFFEEE93C2F1DD4FCA42CC")
    private void updatePhoneState() {
        Phone.State oldState;
        oldState = state;
        {
            boolean varE4BD9FA258196C0B4AF6B5D416334169_1291311441 = (ringingCall.isRinging());
            {
                state = Phone.State.RINGING;
            } //End block
            {
                boolean var4C7AB8264C38A76EB062AB98EEF3EE82_1333473721 = (pendingMO != null ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.973 -0400", hash_original_method = "A78B57299010875BB723A4D535396EB8", hash_generated_method = "64CB6A999AE45B1A77E7B123D30DAB72")
    protected void handlePollCalls(AsyncResult ar) {
        List polledCalls;
        {
            polledCalls = (List)ar.result;
        } //End block
        {
            boolean varC4DBE3EAF9ED931A30C22A297B6E685B_1228787386 = (isCommandExceptionRadioNotAvailable(ar.exception));
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
                        boolean varA12D38D4E3C5051B181541F930988B8A_1032454808 = (pendingMO != null && pendingMO.compareTo(dc));
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
                                boolean var1A7DB31704BA2A2212C3A4154703B0F3_2011534969 = (connections[i].getCall() == ringingCall);
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
                    boolean varC2404C6DFC902F1EC0F3E92AD8CACF6A_1532526191 = (conn != null && dc != null && !conn.compareTo(dc));
                    {
                        droppedDuringPoll.add(conn);
                        connections[i] = new GsmConnection (phone.getContext(), dc, this, i);
                        {
                            boolean varD5FA4DA71F757DFE67753F4F7656FF67_1851757997 = (connections[i].getCall() == ringingCall);
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
                    boolean var8064D1618E098621AFE888A1369217F2_1295242711 = (conn.isIncoming() && conn.getConnectTime() == 0);
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
            boolean varA25616F2AD7C98E00F706161A5B687F7_2043981290 = (droppedDuringPoll.size() > 0);
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
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.974 -0400", hash_original_method = "6E2D3B844106C3BA4166C29F96BB7EA0", hash_generated_method = "3D35CA8E198B65065816E56AAB25BAB7")
    private void handleRadioNotAvailable() {
        pollCallsWhenSafe();
        // ---------- Original Method ----------
        //pollCallsWhenSafe();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.975 -0400", hash_original_method = "91645E150D46BD14FDADA00369A88470", hash_generated_method = "C073A964DB607782C688002C3269E68F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.979 -0400", hash_original_method = "9804562F218584F49F1000DB30741809", hash_generated_method = "3909C238ED1DEF401069A222533BC50B")
     void hangup(GsmConnection conn) throws CallStateException {
        {
            boolean var7B293A7D3CB476B7EF41E01A5B6DD8B4_1778232396 = (conn.owner != this);
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
        addTaint(conn.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.981 -0400", hash_original_method = "47E4845D8AA8A793249B2C364233C700", hash_generated_method = "AA51D326B8A95F7CC6CECE9FBAA65542")
     void separate(GsmConnection conn) throws CallStateException {
        {
            boolean var7B293A7D3CB476B7EF41E01A5B6DD8B4_1205203943 = (conn.owner != this);
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
        addTaint(conn.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.981 -0400", hash_original_method = "8E7DA06B8727FE7EBCD155EA09819106", hash_generated_method = "09D97CBFA339BB68260AAF45EF5FD946")
     void setMute(boolean mute) {
        desiredMute = mute;
        cm.setMute(desiredMute, null);
        // ---------- Original Method ----------
        //desiredMute = mute;
        //cm.setMute(desiredMute, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.990 -0400", hash_original_method = "11907D6A9C6D8F23B8C0FECA1425D0D1", hash_generated_method = "84F6220ECB7927CED373AEDC5C07A68A")
     boolean getMute() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1875399804 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1875399804;
        // ---------- Original Method ----------
        //return desiredMute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.991 -0400", hash_original_method = "2269CD2B285766A5A3A0163535ACAF72", hash_generated_method = "F5B5C334F7CDFF7874B35D98E72323AA")
     void hangup(GsmCall call) throws CallStateException {
        {
            boolean varE4A326D5F85A22F10F9645DF8E94C259_2054033514 = (call.getConnections().size() == 0);
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
                boolean var22C48955666B247FCD89E865FCE21904_1936994458 = (call.isDialingOrAlerting());
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
                boolean varA4A4A8F760ECA28FD2366D22B56B66BD_2085392200 = (ringingCall.isRinging());
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
        addTaint(call.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.992 -0400", hash_original_method = "E840FBD61F8E6AF3DE802E32C39DD93E", hash_generated_method = "4AF2AF2C1AF283F2B3D66EB92EFBBE89")
     void hangupWaitingOrBackground() {
        log("hangupWaitingOrBackground");
        cm.hangupWaitingOrBackground(obtainCompleteMessage());
        // ---------- Original Method ----------
        //if (Phone.DEBUG_PHONE) log("hangupWaitingOrBackground");
        //cm.hangupWaitingOrBackground(obtainCompleteMessage());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.992 -0400", hash_original_method = "D10B26113142441F52E905015040129F", hash_generated_method = "939D43994EC933107D2D3D9C50AF847D")
     void hangupForegroundResumeBackground() {
        log("hangupForegroundResumeBackground");
        cm.hangupForegroundResumeBackground(obtainCompleteMessage());
        // ---------- Original Method ----------
        //if (Phone.DEBUG_PHONE) log("hangupForegroundResumeBackground");
        //cm.hangupForegroundResumeBackground(obtainCompleteMessage());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.993 -0400", hash_original_method = "5F5FEE0C434961483150E08A4EE95AC6", hash_generated_method = "EBA603D91901697877D232B0356A7123")
     void hangupConnectionByIndex(GsmCall call, int index) throws CallStateException {
        int count;
        count = call.connections.size();
        {
            int i;
            i = 0;
            {
                GsmConnection cn;
                cn = (GsmConnection)call.connections.get(i);
                {
                    boolean var6C5E404038FAF2293FAD72C57927DF35_790759122 = (cn.getGSMIndex() == index);
                    {
                        cm.hangupConnection(index, obtainCompleteMessage());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new CallStateException("no gsm index found");
        addTaint(call.getTaint());
        addTaint(index);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.993 -0400", hash_original_method = "F41FC136282F9A01160C0582CC307C0B", hash_generated_method = "18C06BEE67F84883EA7EAADB39634AC3")
     void hangupAllConnections(GsmCall call) throws CallStateException {
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
        addTaint(call.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.994 -0400", hash_original_method = "A13EE98B51441FF2D592407455BBCDEE", hash_generated_method = "844E482078A0DD63E3E3A49C6E5837BB")
     GsmConnection getConnectionByIndex(GsmCall call, int index) throws CallStateException {
        GsmConnection varB4EAC82CA7396A68D541C85D26508E83_1483782891 = null; //Variable for return #1
        GsmConnection varB4EAC82CA7396A68D541C85D26508E83_187785144 = null; //Variable for return #2
        int count;
        count = call.connections.size();
        {
            int i;
            i = 0;
            {
                GsmConnection cn;
                cn = (GsmConnection)call.connections.get(i);
                {
                    boolean var6C5E404038FAF2293FAD72C57927DF35_1292252100 = (cn.getGSMIndex() == index);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1483782891 = cn;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_187785144 = null;
        addTaint(call.getTaint());
        addTaint(index);
        GsmConnection varA7E53CE21691AB073D9660D615818899_1272746696; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1272746696 = varB4EAC82CA7396A68D541C85D26508E83_1483782891;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1272746696 = varB4EAC82CA7396A68D541C85D26508E83_187785144;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1272746696.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1272746696;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.005 -0400", hash_original_method = "65CD53B5AAA831AF61B9937ED3D66C8B", hash_generated_method = "5E01A6E93C7E7E3C519C0ECBF86E72E3")
    private Phone.SuppService getFailedService(int what) {
        Phone.SuppService varB4EAC82CA7396A68D541C85D26508E83_1588191645 = null; //Variable for return #1
        Phone.SuppService varB4EAC82CA7396A68D541C85D26508E83_1533940133 = null; //Variable for return #2
        Phone.SuppService varB4EAC82CA7396A68D541C85D26508E83_655285410 = null; //Variable for return #3
        Phone.SuppService varB4EAC82CA7396A68D541C85D26508E83_1731644271 = null; //Variable for return #4
        Phone.SuppService varB4EAC82CA7396A68D541C85D26508E83_1154063372 = null; //Variable for return #5
        //Begin case EVENT_SWITCH_RESULT 
        varB4EAC82CA7396A68D541C85D26508E83_1588191645 = Phone.SuppService.SWITCH;
        //End case EVENT_SWITCH_RESULT 
        //Begin case EVENT_CONFERENCE_RESULT 
        varB4EAC82CA7396A68D541C85D26508E83_1533940133 = Phone.SuppService.CONFERENCE;
        //End case EVENT_CONFERENCE_RESULT 
        //Begin case EVENT_SEPARATE_RESULT 
        varB4EAC82CA7396A68D541C85D26508E83_655285410 = Phone.SuppService.SEPARATE;
        //End case EVENT_SEPARATE_RESULT 
        //Begin case EVENT_ECT_RESULT 
        varB4EAC82CA7396A68D541C85D26508E83_1731644271 = Phone.SuppService.TRANSFER;
        //End case EVENT_ECT_RESULT 
        varB4EAC82CA7396A68D541C85D26508E83_1154063372 = Phone.SuppService.UNKNOWN;
        addTaint(what);
        Phone.SuppService varA7E53CE21691AB073D9660D615818899_1206353074; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1206353074 = varB4EAC82CA7396A68D541C85D26508E83_1588191645;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1206353074 = varB4EAC82CA7396A68D541C85D26508E83_1533940133;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1206353074 = varB4EAC82CA7396A68D541C85D26508E83_655285410;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1206353074 = varB4EAC82CA7396A68D541C85D26508E83_1731644271;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1206353074 = varB4EAC82CA7396A68D541C85D26508E83_1154063372;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1206353074.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1206353074;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.015 -0400", hash_original_method = "3557310B73CAAA9AAFCC17D1978C55CA", hash_generated_method = "9D024A93D646C2AAC972247C284FD7F9")
    public void handleMessage(Message msg) {
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
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.021 -0400", hash_original_method = "00058CA5481BD8963FA4008BDE768325", hash_generated_method = "10A0FB8B64A5B32F3BCE599328075463")
    protected void log(String msg) {
        Log.d(LOG_TAG, "[GsmCallTracker] " + msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[GsmCallTracker] " + msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.021 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "D3C0B237A982707BF0906F1B27E7321D")

    static String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.021 -0400", hash_original_field = "CC792B139E86B59BF5644A291C349001", hash_generated_field = "F8A73D277C72A0CE9C2EB7E2C37AB4EF")

    private static boolean REPEAT_POLLING = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.021 -0400", hash_original_field = "BA76C0C87FE0928477EB48E458A4151B", hash_generated_field = "AF4E2F29C7D0C5C24239F77C6471B21A")

    private static boolean DBG_POLL = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.021 -0400", hash_original_field = "CE6EEE9244EB55C9202207A9FE613260", hash_generated_field = "79294DA6D69E1E4D4A83AE22E45A7B8F")

    static int MAX_CONNECTIONS = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.021 -0400", hash_original_field = "ADB34849263F54DFDF2785DA896C5FFD", hash_generated_field = "77F27DCE8AFCD8D8B52CF72E87089BA7")

    static int MAX_CONNECTIONS_PER_CALL = 5;
}

