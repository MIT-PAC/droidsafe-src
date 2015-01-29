package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

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

public final class GsmCallTracker extends CallTracker {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.753 -0500", hash_original_field = "28DECCA9F494133CD6F61BCA99A50ECA", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.756 -0500", hash_original_field = "C0E75EBA000DEBDBEC9BEF2F1AD73912", hash_generated_field = "A7B75AEFB3EF53E7FDD36572121557CF")

    private static final boolean REPEAT_POLLING = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.758 -0500", hash_original_field = "83EC3F78C66627469DFE7766D8BC2B63", hash_generated_field = "5105F543721DFE6C6FC4422BBF3A00CF")

    private static final boolean DBG_POLL = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.761 -0500", hash_original_field = "8D863E4CB214E9DBB9114D0D3213AA44", hash_generated_field = "8F753ACD7835834D546EB26D1C62262A")

    static final int MAX_CONNECTIONS = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.763 -0500", hash_original_field = "52B40FE79FE111A3C839C839C72C70DE", hash_generated_field = "8D4E679A45FC623FADF51D1315B81097")

    static final int MAX_CONNECTIONS_PER_CALL = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.766 -0500", hash_original_field = "716BB86B5900AA12E51F40C44C703D1A", hash_generated_field = "43F0085160520CE2894AFC6A877AA860")

    //***** Instance Variables
    GsmConnection connections[] = new GsmConnection[MAX_CONNECTIONS];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.768 -0500", hash_original_field = "D5D06964BBEC51B3D32BF2A900BC948B", hash_generated_field = "D5D06964BBEC51B3D32BF2A900BC948B")

    RegistrantList voiceCallEndedRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.770 -0500", hash_original_field = "A661D5B9F6F26D0E5672FF445A016D80", hash_generated_field = "A661D5B9F6F26D0E5672FF445A016D80")

    RegistrantList voiceCallStartedRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.773 -0500", hash_original_field = "6259F14BEC37C0C21BE48F9CE7762FC4", hash_generated_field = "6259F14BEC37C0C21BE48F9CE7762FC4")

    ArrayList<GsmConnection> droppedDuringPoll
        = new ArrayList<GsmConnection>(MAX_CONNECTIONS);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.775 -0500", hash_original_field = "56A224E06C0E72AE349815A9683F7814", hash_generated_field = "56A224E06C0E72AE349815A9683F7814")

    GsmCall ringingCall = new GsmCall(this);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.777 -0500", hash_original_field = "80691ED64FA1F03FBF32700B990EA539", hash_generated_field = "80691ED64FA1F03FBF32700B990EA539")

    GsmCall foregroundCall = new GsmCall(this);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.780 -0500", hash_original_field = "A38ADB338808573C1F23A56E253D4F91", hash_generated_field = "A38ADB338808573C1F23A56E253D4F91")

    GsmCall backgroundCall = new GsmCall(this);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.783 -0500", hash_original_field = "2F30437FCDD818EF97D2AA98F8F5EC0A", hash_generated_field = "2F30437FCDD818EF97D2AA98F8F5EC0A")

    GsmConnection pendingMO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.785 -0500", hash_original_field = "02C3359C89BD9A3EFAD64C6344B66724", hash_generated_field = "02C3359C89BD9A3EFAD64C6344B66724")

    boolean hangupPendingMO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.787 -0500", hash_original_field = "690DC9441FA6BD04E0472B4DF9E035F8", hash_generated_field = "690DC9441FA6BD04E0472B4DF9E035F8")

    GSMPhone phone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.790 -0500", hash_original_field = "9D75FD49CDE6D2073BBD4C557B93C735", hash_generated_field = "9D75FD49CDE6D2073BBD4C557B93C735")

    boolean desiredMute = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.792 -0500", hash_original_field = "40E232559DDE23609D651E7B63760E6C", hash_generated_field = "40E232559DDE23609D651E7B63760E6C")

    Phone.State state = Phone.State.IDLE;

    //***** Events

    //***** Constructors

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.796 -0500", hash_original_method = "22EA361F37F32F253874F064459157A8", hash_generated_method = "22EA361F37F32F253874F064459157A8")
    
GsmCallTracker (GSMPhone phone) {
        this.phone = phone;
        cm = phone.mCM;

        cm.registerForCallStateChanged(this, EVENT_CALL_STATE_CHANGE, null);

        cm.registerForOn(this, EVENT_RADIO_AVAILABLE, null);
        cm.registerForNotAvailable(this, EVENT_RADIO_NOT_AVAILABLE, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.798 -0500", hash_original_method = "FC4B042AA431A9477437EAA2E6A7E3DB", hash_generated_method = "D5726EFDBF23675C61232CD5039E6C27")
    
public void dispose() {
        //Unregister for all events
        cm.unregisterForCallStateChanged(this);
        cm.unregisterForOn(this);
        cm.unregisterForNotAvailable(this);

        for(GsmConnection c : connections) {
            try {
                if(c != null) hangup(c);
            } catch (CallStateException ex) {
                Log.e(LOG_TAG, "unexpected error on hangup during dispose");
            }
        }

        try {
            if(pendingMO != null) hangup(pendingMO);
        } catch (CallStateException ex) {
            Log.e(LOG_TAG, "unexpected error on hangup during dispose");
        }

        clearDisconnected();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.800 -0500", hash_original_method = "865768B4EC6A5A664005D55855DE8CD7", hash_generated_method = "CEC8A3635E307D76984D2D973D7278BE")
    
protected void finalize() {
        Log.d(LOG_TAG, "GsmCallTracker finalized");
    }

    //***** Instance Methods

    //***** Public Methods
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.803 -0500", hash_original_method = "74524BAB538005AE6F8AB18E196FEB02", hash_generated_method = "8F5D1576E81F7A3BBFE22CABE96E6E8C")
    
public void registerForVoiceCallStarted(Handler h, int what, Object obj) {
        Registrant r = new Registrant(h, what, obj);
        voiceCallStartedRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.805 -0500", hash_original_method = "3C910908B4B98998A7936D8F8AE4D170", hash_generated_method = "90C53E0CBF7A9C3668641394B500053A")
    
public void unregisterForVoiceCallStarted(Handler h) {
        voiceCallStartedRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.808 -0500", hash_original_method = "D7F70C00A904DE96D26BDF7C49F41DAA", hash_generated_method = "EA8657688A790592CA2BF7644170F3D6")
    
public void registerForVoiceCallEnded(Handler h, int what, Object obj) {
        Registrant r = new Registrant(h, what, obj);
        voiceCallEndedRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.812 -0500", hash_original_method = "91176AF98778238DB3B453F2FC7D9448", hash_generated_method = "BC9403E0CD3C928D209E83809DDE4C4E")
    
public void unregisterForVoiceCallEnded(Handler h) {
        voiceCallEndedRegistrants.remove(h);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.815 -0500", hash_original_method = "4204FB660E281B4690A876C95432F574", hash_generated_method = "F6B2537CA15B1848642EEBA128CA1CF3")
    
private void
    fakeHoldForegroundBeforeDial() {
        List<Connection> connCopy;

        // We need to make a copy here, since fakeHoldBeforeDial()
        // modifies the lists, and we don't want to reverse the order
        connCopy = (List<Connection>) foregroundCall.connections.clone();

        for (int i = 0, s = connCopy.size() ; i < s ; i++) {
            GsmConnection conn = (GsmConnection)connCopy.get(i);

            conn.fakeHoldBeforeDial();
        }
    }

    /**
     * clirMode is one of the CLIR_ constants
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.818 -0500", hash_original_method = "BBA59EE5F024CF032CB3FE359D476C6C", hash_generated_method = "8DB54C506971CC8EA63AB5837929A57E")
    
Connection
    dial (String dialString, int clirMode, UUSInfo uusInfo) throws CallStateException {
        // note that this triggers call state changed notif
        clearDisconnected();

        if (!canDial()) {
            throw new CallStateException("cannot dial in current state");
        }

        // The new call must be assigned to the foreground call.
        // That call must be idle, so place anything that's
        // there on hold
        if (foregroundCall.getState() == GsmCall.State.ACTIVE) {
            // this will probably be done by the radio anyway
            // but the dial might fail before this happens
            // and we need to make sure the foreground call is clear
            // for the newly dialed connection
            switchWaitingOrHoldingAndActive();

            // Fake local state so that
            // a) foregroundCall is empty for the newly dialed connection
            // b) hasNonHangupStateChanged remains false in the
            // next poll, so that we don't clear a failed dialing call
            fakeHoldForegroundBeforeDial();
        }

        if (foregroundCall.getState() != GsmCall.State.IDLE) {
            //we should have failed in !canDial() above before we get here
            throw new CallStateException("cannot dial in current state");
        }

        pendingMO = new GsmConnection(phone.getContext(), dialString, this, foregroundCall);
        hangupPendingMO = false;

        if (pendingMO.address == null || pendingMO.address.length() == 0
            || pendingMO.address.indexOf(PhoneNumberUtils.WILD) >= 0
        ) {
            // Phone number is invalid
            pendingMO.cause = Connection.DisconnectCause.INVALID_NUMBER;

            // handlePollCalls() will notice this call not present
            // and will mark it as dropped.
            pollCallsWhenSafe();
        } else {
            // Always unmute when initiating a new call
            setMute(false);

            cm.dial(pendingMO.address, clirMode, uusInfo, obtainCompleteMessage());
        }

        updatePhoneState();
        phone.notifyPreciseCallStateChanged();

        return pendingMO;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.820 -0500", hash_original_method = "890AB92FDE9FE4C57A1E95495C075681", hash_generated_method = "890AB92FDE9FE4C57A1E95495C075681")
    
Connection
    dial(String dialString) throws CallStateException {
        return dial(dialString, CommandsInterface.CLIR_DEFAULT, null);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.823 -0500", hash_original_method = "2869CC3BF5EF49E3F89EEEBD1A0C3021", hash_generated_method = "2869CC3BF5EF49E3F89EEEBD1A0C3021")
    
Connection
    dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        return dial(dialString, CommandsInterface.CLIR_DEFAULT, uusInfo);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.825 -0500", hash_original_method = "EC4F7F51F5F0A4F61E0068E2B7BE6FF2", hash_generated_method = "EC4F7F51F5F0A4F61E0068E2B7BE6FF2")
    
Connection
    dial(String dialString, int clirMode) throws CallStateException {
        return dial(dialString, clirMode, null);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.828 -0500", hash_original_method = "6B4B3AB5A2A59FF5FB364E6A16F49177", hash_generated_method = "C3131A8C7C8724CACF948C2B55B1F91E")
    
void
    acceptCall () throws CallStateException {
        // FIXME if SWITCH fails, should retry with ANSWER
        // in case the active/holding call disappeared and this
        // is no longer call waiting

        if (ringingCall.getState() == GsmCall.State.INCOMING) {
            Log.i("phone", "acceptCall: incoming...");
            // Always unmute when answering a new call
            setMute(false);
            cm.acceptCall(obtainCompleteMessage());
        } else if (ringingCall.getState() == GsmCall.State.WAITING) {
            setMute(false);
            switchWaitingOrHoldingAndActive();
        } else {
            throw new CallStateException("phone not ringing");
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.830 -0500", hash_original_method = "9B02E01190499DD77CD223AD7831C55B", hash_generated_method = "159188A7D123B2C37B5B4116F07A42E0")
    
void
    rejectCall () throws CallStateException {
        // AT+CHLD=0 means "release held or UDUB"
        // so if the phone isn't ringing, this could hang up held
        if (ringingCall.getState().isRinging()) {
            cm.rejectCall(obtainCompleteMessage());
        } else {
            throw new CallStateException("phone not ringing");
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.833 -0500", hash_original_method = "F087D3CDA5FED1EA3EF910AA070D114E", hash_generated_method = "F809A75279E83893BAA9E64F90C9CD42")
    
void
    switchWaitingOrHoldingAndActive() throws CallStateException {
        // Should we bother with this check?
        if (ringingCall.getState() == GsmCall.State.INCOMING) {
            throw new CallStateException("cannot be in the incoming state");
        } else {
            cm.switchWaitingOrHoldingAndActive(
                    obtainCompleteMessage(EVENT_SWITCH_RESULT));
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.835 -0500", hash_original_method = "21B7458D194C157C186B70ABA7C7D274", hash_generated_method = "21B7458D194C157C186B70ABA7C7D274")
    
void
    conference() throws CallStateException {
        cm.conference(obtainCompleteMessage(EVENT_CONFERENCE_RESULT));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.837 -0500", hash_original_method = "B9B58214FE30DEB2D41379B25D88E6DD", hash_generated_method = "B9B58214FE30DEB2D41379B25D88E6DD")
    
void
    explicitCallTransfer() throws CallStateException {
        cm.explicitCallTransfer(obtainCompleteMessage(EVENT_ECT_RESULT));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.840 -0500", hash_original_method = "89E1881B087BAA2C040FAFD444B532DA", hash_generated_method = "89E1881B087BAA2C040FAFD444B532DA")
    
void
    clearDisconnected() {
        internalClearDisconnected();

        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.844 -0500", hash_original_method = "C3AFF7137220AE966ED90D221261BE5A", hash_generated_method = "C3AFF7137220AE966ED90D221261BE5A")
    
boolean
    canConference() {
        return foregroundCall.getState() == GsmCall.State.ACTIVE
                && backgroundCall.getState() == GsmCall.State.HOLDING
                && !backgroundCall.isFull()
                && !foregroundCall.isFull();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.846 -0500", hash_original_method = "808FE91E5748A2C0F0CF7B9BCBDBAE36", hash_generated_method = "808FE91E5748A2C0F0CF7B9BCBDBAE36")
    
boolean
    canDial() {
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

        return ret;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.849 -0500", hash_original_method = "E4A32A086AF9F2037148F022098D94F1", hash_generated_method = "E4A32A086AF9F2037148F022098D94F1")
    
boolean
    canTransfer() {
        return foregroundCall.getState() == GsmCall.State.ACTIVE
                && backgroundCall.getState() == GsmCall.State.HOLDING;
    }

    //***** Private Instance Methods

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.851 -0500", hash_original_method = "3058DCAC5E1117AE07A379578E7C6A20", hash_generated_method = "9EAF3135810EB7776F7263823E069660")
    
private void
    internalClearDisconnected() {
        ringingCall.clearDisconnected();
        foregroundCall.clearDisconnected();
        backgroundCall.clearDisconnected();
    }

    /**
     * Obtain a message to use for signalling "invoke getCurrentCalls() when
     * this operation and all other pending operations are complete
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.853 -0500", hash_original_method = "89F67FF5AFAE8FAD9F556239F3E27159", hash_generated_method = "805FDE0EC1A77B26DA5992514EDF2DAB")
    
private Message
    obtainCompleteMessage() {
        return obtainCompleteMessage(EVENT_OPERATION_COMPLETE);
    }

    /**
     * Obtain a message to use for signalling "invoke getCurrentCalls() when
     * this operation and all other pending operations are complete
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.856 -0500", hash_original_method = "F527C5C3DD4F0176588A0C261AD76B7A", hash_generated_method = "E21B90D8FFA2C73529233B2579E8CE52")
    
private Message
    obtainCompleteMessage(int what) {
        pendingOperations++;
        lastRelevantPoll = null;
        needsPoll = true;

        if (DBG_POLL) log("obtainCompleteMessage: pendingOperations=" +
                pendingOperations + ", needsPoll=" + needsPoll);

        return obtainMessage(what);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.859 -0500", hash_original_method = "58BAF8F27C1747875766F27864D59E66", hash_generated_method = "040C48E549D85C321C4BE4E13C79F760")
    
private void
    operationComplete() {
        pendingOperations--;

        if (DBG_POLL) log("operationComplete: pendingOperations=" +
                pendingOperations + ", needsPoll=" + needsPoll);

        if (pendingOperations == 0 && needsPoll) {
            lastRelevantPoll = obtainMessage(EVENT_POLL_CALLS_RESULT);
            cm.getCurrentCalls(lastRelevantPoll);
        } else if (pendingOperations < 0) {
            // this should never happen
            Log.e(LOG_TAG,"GsmCallTracker.pendingOperations < 0");
            pendingOperations = 0;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.862 -0500", hash_original_method = "23DAEFAFA1E8C13E9726BBC375E8DDCB", hash_generated_method = "500C692465A094B90644B9AFEBD6639F")
    
private void
    updatePhoneState() {
        Phone.State oldState = state;

        if (ringingCall.isRinging()) {
            state = Phone.State.RINGING;
        } else if (pendingMO != null ||
                !(foregroundCall.isIdle() && backgroundCall.isIdle())) {
            state = Phone.State.OFFHOOK;
        } else {
            state = Phone.State.IDLE;
        }

        if (state == Phone.State.IDLE && oldState != state) {
            voiceCallEndedRegistrants.notifyRegistrants(
                new AsyncResult(null, null, null));
        } else if (oldState == Phone.State.IDLE && oldState != state) {
            voiceCallStartedRegistrants.notifyRegistrants (
                    new AsyncResult(null, null, null));
        }

        if (state != oldState) {
            phone.notifyPhoneStateChanged();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.868 -0500", hash_original_method = "A78B57299010875BB723A4D535396EB8", hash_generated_method = "C2E95A955D89D76048CA5C3E76472651")
    
protected void
    handlePollCalls(AsyncResult ar) {
        List polledCalls;

        if (ar.exception == null) {
            polledCalls = (List)ar.result;
        } else if (isCommandExceptionRadioNotAvailable(ar.exception)) {
            // just a dummy empty ArrayList to cause the loop
            // to hang up all the calls
            polledCalls = new ArrayList();
        } else {
            // Radio probably wasn't ready--try again in a bit
            // But don't keep polling if the channel is closed
            pollCallsAfterDelay();
            return;
        }

        Connection newRinging = null; //or waiting
        boolean hasNonHangupStateChanged = false;   // Any change besides
                                                    // a dropped connection
        boolean needsPollDelay = false;
        boolean unknownConnectionAppeared = false;

        for (int i = 0, curDC = 0, dcSize = polledCalls.size()
                ; i < connections.length; i++) {
            GsmConnection conn = connections[i];
            DriverCall dc = null;

            // polledCall list is sparse
            if (curDC < dcSize) {
                dc = (DriverCall) polledCalls.get(curDC);

                if (dc.index == i+1) {
                    curDC++;
                } else {
                    dc = null;
                }
            }

            if (DBG_POLL) log("poll: conn[i=" + i + "]=" +
                    conn+", dc=" + dc);

            if (conn == null && dc != null) {
                // Connection appeared in CLCC response that we don't know about
                if (pendingMO != null && pendingMO.compareTo(dc)) {

                    if (DBG_POLL) log("poll: pendingMO=" + pendingMO);

                    // It's our pending mobile originating call
                    connections[i] = pendingMO;
                    pendingMO.index = i;
                    pendingMO.update(dc);
                    pendingMO = null;

                    // Someone has already asked to hangup this call
                    if (hangupPendingMO) {
                        hangupPendingMO = false;
                        try {
                            if (Phone.DEBUG_PHONE) log(
                                    "poll: hangupPendingMO, hangup conn " + i);
                            hangup(connections[i]);
                        } catch (CallStateException ex) {
                            Log.e(LOG_TAG, "unexpected error on hangup");
                        }

                        // Do not continue processing this poll
                        // Wait for hangup and repoll
                        return;
                    }
                } else {
                    connections[i] = new GsmConnection(phone.getContext(), dc, this, i);

                    // it's a ringing call
                    if (connections[i].getCall() == ringingCall) {
                        newRinging = connections[i];
                    } else {
                        // Something strange happened: a call appeared
                        // which is neither a ringing call or one we created.
                        // Either we've crashed and re-attached to an existing
                        // call, or something else (eg, SIM) initiated the call.

                        Log.i(LOG_TAG,"Phantom call appeared " + dc);

                        // If it's a connected call, set the connect time so that
                        // it's non-zero.  It may not be accurate, but at least
                        // it won't appear as a Missed Call.
                        if (dc.state != DriverCall.State.ALERTING
                                && dc.state != DriverCall.State.DIALING) {
                            connections[i].connectTime = System.currentTimeMillis();
                        }

                        unknownConnectionAppeared = true;
                    }
                }
                hasNonHangupStateChanged = true;
            } else if (conn != null && dc == null) {
                // Connection missing in CLCC response that we were
                // tracking.
                droppedDuringPoll.add(conn);
                // Dropped connections are removed from the CallTracker
                // list but kept in the GsmCall list
                connections[i] = null;
            } else if (conn != null && dc != null && !conn.compareTo(dc)) {
                // Connection in CLCC response does not match what
                // we were tracking. Assume dropped call and new call

                droppedDuringPoll.add(conn);
                connections[i] = new GsmConnection (phone.getContext(), dc, this, i);

                if (connections[i].getCall() == ringingCall) {
                    newRinging = connections[i];
                } // else something strange happened
                hasNonHangupStateChanged = true;
            } else if (conn != null && dc != null) { /* implicit conn.compareTo(dc) */
                boolean changed;
                changed = conn.update(dc);
                hasNonHangupStateChanged = hasNonHangupStateChanged || changed;
            }

            if (REPEAT_POLLING) {
                if (dc != null) {
                    // FIXME with RIL, we should not need this anymore
                    if ((dc.state == DriverCall.State.DIALING
                            /*&& cm.getOption(cm.OPTION_POLL_DIALING)*/)
                        || (dc.state == DriverCall.State.ALERTING
                            /*&& cm.getOption(cm.OPTION_POLL_ALERTING)*/)
                        || (dc.state == DriverCall.State.INCOMING
                            /*&& cm.getOption(cm.OPTION_POLL_INCOMING)*/)
                        || (dc.state == DriverCall.State.WAITING
                            /*&& cm.getOption(cm.OPTION_POLL_WAITING)*/)
                    ) {
                        // Sometimes there's no unsolicited notification
                        // for state transitions
                        needsPollDelay = true;
                    }
                }
            }
        }

        // This is the first poll after an ATD.
        // We expect the pending call to appear in the list
        // If it does not, we land here
        if (pendingMO != null) {
            Log.d(LOG_TAG,"Pending MO dropped before poll fg state:"
                            + foregroundCall.getState());

            droppedDuringPoll.add(pendingMO);
            pendingMO = null;
            hangupPendingMO = false;
        }

        if (newRinging != null) {
            phone.notifyNewRingingConnection(newRinging);
        }

        // clear the "local hangup" and "missed/rejected call"
        // cases from the "dropped during poll" list
        // These cases need no "last call fail" reason
        for (int i = droppedDuringPoll.size() - 1; i >= 0 ; i--) {
            GsmConnection conn = droppedDuringPoll.get(i);

            if (conn.isIncoming() && conn.getConnectTime() == 0) {
                // Missed or rejected call
                Connection.DisconnectCause cause;
                if (conn.cause == Connection.DisconnectCause.LOCAL) {
                    cause = Connection.DisconnectCause.INCOMING_REJECTED;
                } else {
                    cause = Connection.DisconnectCause.INCOMING_MISSED;
                }

                if (Phone.DEBUG_PHONE) {
                    log("missed/rejected call, conn.cause=" + conn.cause);
                    log("setting cause to " + cause);
                }
                droppedDuringPoll.remove(i);
                conn.onDisconnect(cause);
            } else if (conn.cause == Connection.DisconnectCause.LOCAL) {
                // Local hangup
                droppedDuringPoll.remove(i);
                conn.onDisconnect(Connection.DisconnectCause.LOCAL);
            } else if (conn.cause ==
                Connection.DisconnectCause.INVALID_NUMBER) {
                droppedDuringPoll.remove(i);
                conn.onDisconnect(Connection.DisconnectCause.INVALID_NUMBER);
            }
        }

        // Any non-local disconnects: determine cause
        if (droppedDuringPoll.size() > 0) {
            cm.getLastCallFailCause(
                obtainNoPollCompleteMessage(EVENT_GET_LAST_CALL_FAIL_CAUSE));
        }

        if (needsPollDelay) {
            pollCallsAfterDelay();
        }

        // Cases when we can no longer keep disconnected Connection's
        // with their previous calls
        // 1) the phone has started to ring
        // 2) A Call/Connection object has changed state...
        //    we may have switched or held or answered (but not hung up)
        if (newRinging != null || hasNonHangupStateChanged) {
            internalClearDisconnected();
        }

        updatePhoneState();

        if (unknownConnectionAppeared) {
            phone.notifyUnknownConnection();
        }

        if (hasNonHangupStateChanged || newRinging != null) {
            phone.notifyPreciseCallStateChanged();
        }

        //dumpState();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.872 -0500", hash_original_method = "6E2D3B844106C3BA4166C29F96BB7EA0", hash_generated_method = "7EA909082D0F3A766A83D359A75C4FD3")
    
private void
    handleRadioNotAvailable() {
        // handlePollCalls will clear out its
        // call list when it gets the CommandException
        // error result from this
        pollCallsWhenSafe();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.876 -0500", hash_original_method = "91645E150D46BD14FDADA00369A88470", hash_generated_method = "83E49DD574DDBDCBA3B9E29939E5F323")
    
private void
    dumpState() {
        List l;

        Log.i(LOG_TAG,"Phone State:" + state);

        Log.i(LOG_TAG,"Ringing call: " + ringingCall.toString());

        l = ringingCall.getConnections();
        for (int i = 0, s = l.size(); i < s; i++) {
            Log.i(LOG_TAG,l.get(i).toString());
        }

        Log.i(LOG_TAG,"Foreground call: " + foregroundCall.toString());

        l = foregroundCall.getConnections();
        for (int i = 0, s = l.size(); i < s; i++) {
            Log.i(LOG_TAG,l.get(i).toString());
        }

        Log.i(LOG_TAG,"Background call: " + backgroundCall.toString());

        l = backgroundCall.getConnections();
        for (int i = 0, s = l.size(); i < s; i++) {
            Log.i(LOG_TAG,l.get(i).toString());
        }

    }

    //***** Called from GsmConnection

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.879 -0500", hash_original_method = "9804562F218584F49F1000DB30741809", hash_generated_method = "6818F9DDE06916C7C2342418B18D4F24")
    
void
    hangup (GsmConnection conn) throws CallStateException {
        if (conn.owner != this) {
            throw new CallStateException ("GsmConnection " + conn
                                    + "does not belong to GsmCallTracker " + this);
        }

        if (conn == pendingMO) {
            // We're hanging up an outgoing call that doesn't have it's
            // GSM index assigned yet

            if (Phone.DEBUG_PHONE) log("hangup: set hangupPendingMO to true");
            hangupPendingMO = true;
        } else {
            try {
                cm.hangupConnection (conn.getGSMIndex(), obtainCompleteMessage());
            } catch (CallStateException ex) {
                // Ignore "connection not found"
                // Call may have hung up already
                Log.w(LOG_TAG,"GsmCallTracker WARN: hangup() on absent connection "
                                + conn);
            }
        }

        conn.onHangupLocal();
    }

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.881 -0500", hash_original_method = "47E4845D8AA8A793249B2C364233C700", hash_generated_method = "F61A224D1529C4BA178EE2A51D57176D")
    
void
    separate (GsmConnection conn) throws CallStateException {
        if (conn.owner != this) {
            throw new CallStateException ("GsmConnection " + conn
                                    + "does not belong to GsmCallTracker " + this);
        }
        try {
            cm.separateConnection (conn.getGSMIndex(),
                obtainCompleteMessage(EVENT_SEPARATE_RESULT));
        } catch (CallStateException ex) {
            // Ignore "connection not found"
            // Call may have hung up already
            Log.w(LOG_TAG,"GsmCallTracker WARN: separate() on absent connection "
                          + conn);
        }
    }

    //***** Called from GSMPhone

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.884 -0500", hash_original_method = "8E7DA06B8727FE7EBCD155EA09819106", hash_generated_method = "8E7DA06B8727FE7EBCD155EA09819106")
    
void
    setMute(boolean mute) {
        desiredMute = mute;
        cm.setMute(desiredMute, null);
    }

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.886 -0500", hash_original_method = "11907D6A9C6D8F23B8C0FECA1425D0D1", hash_generated_method = "11907D6A9C6D8F23B8C0FECA1425D0D1")
    
boolean
    getMute() {
        return desiredMute;
    }

    //***** Called from GsmCall

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.889 -0500", hash_original_method = "2269CD2B285766A5A3A0163535ACAF72", hash_generated_method = "2269CD2B285766A5A3A0163535ACAF72")
    
void
    hangup (GsmCall call) throws CallStateException {
        if (call.getConnections().size() == 0) {
            throw new CallStateException("no connections in call");
        }

        if (call == ringingCall) {
            if (Phone.DEBUG_PHONE) log("(ringing) hangup waiting or background");
            cm.hangupWaitingOrBackground(obtainCompleteMessage());
        } else if (call == foregroundCall) {
            if (call.isDialingOrAlerting()) {
                if (Phone.DEBUG_PHONE) {
                    log("(foregnd) hangup dialing or alerting...");
                }
                hangup((GsmConnection)(call.getConnections().get(0)));
            } else {
                hangupForegroundResumeBackground();
            }
        } else if (call == backgroundCall) {
            if (ringingCall.isRinging()) {
                if (Phone.DEBUG_PHONE) {
                    log("hangup all conns in background call");
                }
                hangupAllConnections(call);
            } else {
                hangupWaitingOrBackground();
            }
        } else {
            throw new RuntimeException ("GsmCall " + call +
                    "does not belong to GsmCallTracker " + this);
        }

        call.onHangupLocal();
        phone.notifyPreciseCallStateChanged();
    }

    /* package */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.892 -0500", hash_original_method = "E840FBD61F8E6AF3DE802E32C39DD93E", hash_generated_method = "E840FBD61F8E6AF3DE802E32C39DD93E")
    
void hangupWaitingOrBackground() {
        if (Phone.DEBUG_PHONE) log("hangupWaitingOrBackground");
        cm.hangupWaitingOrBackground(obtainCompleteMessage());
    }

    /* package */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.894 -0500", hash_original_method = "D10B26113142441F52E905015040129F", hash_generated_method = "D10B26113142441F52E905015040129F")
    
void hangupForegroundResumeBackground() {
        if (Phone.DEBUG_PHONE) log("hangupForegroundResumeBackground");
        cm.hangupForegroundResumeBackground(obtainCompleteMessage());
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.896 -0500", hash_original_method = "5F5FEE0C434961483150E08A4EE95AC6", hash_generated_method = "5F5FEE0C434961483150E08A4EE95AC6")
    
void hangupConnectionByIndex(GsmCall call, int index)
            throws CallStateException {
        int count = call.connections.size();
        for (int i = 0; i < count; i++) {
            GsmConnection cn = (GsmConnection)call.connections.get(i);
            if (cn.getGSMIndex() == index) {
                cm.hangupConnection(index, obtainCompleteMessage());
                return;
            }
        }

        throw new CallStateException("no gsm index found");
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.899 -0500", hash_original_method = "F41FC136282F9A01160C0582CC307C0B", hash_generated_method = "F41FC136282F9A01160C0582CC307C0B")
    
void hangupAllConnections(GsmCall call) throws CallStateException{
        try {
            int count = call.connections.size();
            for (int i = 0; i < count; i++) {
                GsmConnection cn = (GsmConnection)call.connections.get(i);
                cm.hangupConnection(cn.getGSMIndex(), obtainCompleteMessage());
            }
        } catch (CallStateException ex) {
            Log.e(LOG_TAG, "hangupConnectionByIndex caught " + ex);
        }
    }

    /* package */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.902 -0500", hash_original_method = "A13EE98B51441FF2D592407455BBCDEE", hash_generated_method = "A13EE98B51441FF2D592407455BBCDEE")
    
GsmConnection getConnectionByIndex(GsmCall call, int index)
            throws CallStateException {
        int count = call.connections.size();
        for (int i = 0; i < count; i++) {
            GsmConnection cn = (GsmConnection)call.connections.get(i);
            if (cn.getGSMIndex() == index) {
                return cn;
            }
        }

        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.905 -0500", hash_original_method = "65CD53B5AAA831AF61B9937ED3D66C8B", hash_generated_method = "1B5E0158171E6616D923AB0254C22598")
    
private Phone.SuppService getFailedService(int what) {
        switch (what) {
            case EVENT_SWITCH_RESULT:
                return Phone.SuppService.SWITCH;
            case EVENT_CONFERENCE_RESULT:
                return Phone.SuppService.CONFERENCE;
            case EVENT_SEPARATE_RESULT:
                return Phone.SuppService.SEPARATE;
            case EVENT_ECT_RESULT:
                return Phone.SuppService.TRANSFER;
        }
        return Phone.SuppService.UNKNOWN;
    }

    //****** Overridden from Handler

    @DSSafe(DSCat.IPC_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.910 -0500", hash_original_method = "3557310B73CAAA9AAFCC17D1978C55CA", hash_generated_method = "2854BAE6CD3971C47DEFF31D97451B9A")
    
public void
    handleMessage (Message msg) {
        AsyncResult ar;

        switch (msg.what) {
            case EVENT_POLL_CALLS_RESULT:
                ar = (AsyncResult)msg.obj;

                if (msg == lastRelevantPoll) {
                    if (DBG_POLL) log(
                            "handle EVENT_POLL_CALL_RESULT: set needsPoll=F");
                    needsPoll = false;
                    lastRelevantPoll = null;
                    handlePollCalls((AsyncResult)msg.obj);
                }
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
                if (ar.exception != null) {
                    phone.notifySuppServiceFailed(getFailedService(msg.what));
                }
                operationComplete();
            break;

            case EVENT_GET_LAST_CALL_FAIL_CAUSE:
                int causeCode;
                ar = (AsyncResult)msg.obj;

                operationComplete();

                if (ar.exception != null) {
                    // An exception occurred...just treat the disconnect
                    // cause as "normal"
                    causeCode = CallFailCause.NORMAL_CLEARING;
                    Log.i(LOG_TAG,
                            "Exception during getLastCallFailCause, assuming normal disconnect");
                } else {
                    causeCode = ((int[])ar.result)[0];
                }
                // Log the causeCode if its not normal
                if (causeCode == CallFailCause.NO_CIRCUIT_AVAIL ||
                    causeCode == CallFailCause.TEMPORARY_FAILURE ||
                    causeCode == CallFailCause.SWITCHING_CONGESTION ||
                    causeCode == CallFailCause.CHANNEL_NOT_AVAIL ||
                    causeCode == CallFailCause.QOS_NOT_AVAIL ||
                    causeCode == CallFailCause.BEARER_NOT_AVAIL ||
                    causeCode == CallFailCause.ERROR_UNSPECIFIED) {
                    GsmCellLocation loc = ((GsmCellLocation)phone.getCellLocation());
                    EventLog.writeEvent(EventLogTags.CALL_DROP,
                            causeCode, loc != null ? loc.getCid() : -1,
                            TelephonyManager.getDefault().getNetworkType());
                }

                for (int i = 0, s =  droppedDuringPoll.size()
                        ; i < s ; i++
                ) {
                    GsmConnection conn = droppedDuringPoll.get(i);

                    conn.onRemoteDisconnect(causeCode);
                }

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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.912 -0500", hash_original_method = "00058CA5481BD8963FA4008BDE768325", hash_generated_method = "2131660EC1804F4F18F5969CEDDBB092")
    
protected void log(String msg) {
        Log.d(LOG_TAG, "[GsmCallTracker] " + msg);
    }
}

