package com.android.internal.telephony.cdma;

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
import android.util.Log;

import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.CallTracker;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.DriverCall;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.TelephonyProperties;

public final class CdmaCallTracker extends CallTracker {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.664 -0500", hash_original_field = "DB10E3AE28CC9996A816C3CCD7216A83", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.666 -0500", hash_original_field = "C0E75EBA000DEBDBEC9BEF2F1AD73912", hash_generated_field = "A7B75AEFB3EF53E7FDD36572121557CF")

    private static final boolean REPEAT_POLLING = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.669 -0500", hash_original_field = "83EC3F78C66627469DFE7766D8BC2B63", hash_generated_field = "5105F543721DFE6C6FC4422BBF3A00CF")

    private static final boolean DBG_POLL = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.672 -0500", hash_original_field = "8687A18135CDCE52A057265B20651AFF", hash_generated_field = "3D5BB3B6A3F2D8A508B231AB505DE10A")

    static final int MAX_CONNECTIONS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.674 -0500", hash_original_field = "7ED5FB0B00FB656A373A1FE348FE2FBB", hash_generated_field = "50E5124FACE9F1EADB0A251AF8BCB55D")

    static final int MAX_CONNECTIONS_PER_CALL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.676 -0500", hash_original_field = "6A689CEE5AFC02EE7871982A34436F33", hash_generated_field = "8778DA83769DA6B7C7A4F54B9D0B49D2")

    //***** Instance Variables

    CdmaConnection connections[] = new CdmaConnection[MAX_CONNECTIONS];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.678 -0500", hash_original_field = "D5D06964BBEC51B3D32BF2A900BC948B", hash_generated_field = "D5D06964BBEC51B3D32BF2A900BC948B")

    RegistrantList voiceCallEndedRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.680 -0500", hash_original_field = "A661D5B9F6F26D0E5672FF445A016D80", hash_generated_field = "A661D5B9F6F26D0E5672FF445A016D80")

    RegistrantList voiceCallStartedRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.682 -0500", hash_original_field = "3D70A22464952A3DA788ACD133F18F18", hash_generated_field = "3D70A22464952A3DA788ACD133F18F18")

    RegistrantList callWaitingRegistrants =  new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.685 -0500", hash_original_field = "A29022524411F1FE9FAA91E8C50F5273", hash_generated_field = "A29022524411F1FE9FAA91E8C50F5273")

    ArrayList<CdmaConnection> droppedDuringPoll
        = new ArrayList<CdmaConnection>(MAX_CONNECTIONS);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.687 -0500", hash_original_field = "4BBDA18FC07012B464497A7036E9A64A", hash_generated_field = "4BBDA18FC07012B464497A7036E9A64A")

    CdmaCall ringingCall = new CdmaCall(this);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.689 -0500", hash_original_field = "0CD0B75B3735614AF877856265E67CC2", hash_generated_field = "0CD0B75B3735614AF877856265E67CC2")

    CdmaCall foregroundCall = new CdmaCall(this);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.692 -0500", hash_original_field = "1378E8D8E46107C480B8A53E811982F8", hash_generated_field = "1378E8D8E46107C480B8A53E811982F8")

    CdmaCall backgroundCall = new CdmaCall(this);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.695 -0500", hash_original_field = "2DB35562B0BF54F2C81F690DFDF249EA", hash_generated_field = "2DB35562B0BF54F2C81F690DFDF249EA")

    CdmaConnection pendingMO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.697 -0500", hash_original_field = "02C3359C89BD9A3EFAD64C6344B66724", hash_generated_field = "02C3359C89BD9A3EFAD64C6344B66724")

    boolean hangupPendingMO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.699 -0500", hash_original_field = "2E8EE5EFDD4628948AC6D63D5B84BCF2", hash_generated_field = "2E8EE5EFDD4628948AC6D63D5B84BCF2")

    boolean pendingCallInEcm=false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.701 -0500", hash_original_field = "BC28D21C00A5A62F4E1E102DA65D0E68", hash_generated_field = "BC28D21C00A5A62F4E1E102DA65D0E68")

    boolean mIsInEmergencyCall = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.703 -0500", hash_original_field = "F2FC592D71DA2BCBED04F0F797B7B907", hash_generated_field = "F2FC592D71DA2BCBED04F0F797B7B907")

    CDMAPhone phone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.705 -0500", hash_original_field = "9D75FD49CDE6D2073BBD4C557B93C735", hash_generated_field = "9D75FD49CDE6D2073BBD4C557B93C735")

    boolean desiredMute = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.707 -0500", hash_original_field = "27174E0D68E2766EF4C51C4E944D5755", hash_generated_field = "27174E0D68E2766EF4C51C4E944D5755")

    int pendingCallClirMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.710 -0500", hash_original_field = "40E232559DDE23609D651E7B63760E6C", hash_generated_field = "40E232559DDE23609D651E7B63760E6C")

    Phone.State state = Phone.State.IDLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.712 -0500", hash_original_field = "42A7493F9C995CAD89B391816B271217", hash_generated_field = "B4B1C0C1B427A1CEF2D1461193F5A876")

    private boolean mIsEcmTimerCanceled = false;

//    boolean needsPoll;

    //***** Events

    //***** Constructors
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.715 -0500", hash_original_method = "D7E78FBD4DB8C2DC376D4ABE79BA3592", hash_generated_method = "D7E78FBD4DB8C2DC376D4ABE79BA3592")
    
CdmaCallTracker(CDMAPhone phone) {
        this.phone = phone;
        cm = phone.mCM;
        cm.registerForCallStateChanged(this, EVENT_CALL_STATE_CHANGE, null);
        cm.registerForOn(this, EVENT_RADIO_AVAILABLE, null);
        cm.registerForNotAvailable(this, EVENT_RADIO_NOT_AVAILABLE, null);
        cm.registerForCallWaitingInfo(this, EVENT_CALL_WAITING_INFO_CDMA, null);
        foregroundCall.setGeneric(false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.717 -0500", hash_original_method = "2338338535849E159E02E311688F6BB3", hash_generated_method = "8026639319EA7D7D538CAA88FAC5DA9B")
    
public void dispose() {
        cm.unregisterForCallStateChanged(this);
        cm.unregisterForOn(this);
        cm.unregisterForNotAvailable(this);
        cm.unregisterForCallWaitingInfo(this);
        for(CdmaConnection c : connections) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.721 -0500", hash_original_method = "73544050C1854D0258F226F7B919F554", hash_generated_method = "C470172F982ABBA31D01D9E31C6B3D79")
    
@Override
    protected void finalize() {
        Log.d(LOG_TAG, "CdmaCallTracker finalized");
    }

    //***** Instance Methods

    //***** Public Methods
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.723 -0500", hash_original_method = "A19F9CA037C5D9E07B1DD2AD491B323A", hash_generated_method = "78183CFD9993C1DBB9A4301F1D3A7472")
    
public void registerForVoiceCallStarted(Handler h, int what, Object obj) {
        Registrant r = new Registrant(h, what, obj);
        voiceCallStartedRegistrants.add(r);
        // Notify if in call when registering
        if (state != Phone.State.IDLE) {
            r.notifyRegistrant(new AsyncResult(null, null, null));
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.725 -0500", hash_original_method = "3C910908B4B98998A7936D8F8AE4D170", hash_generated_method = "90C53E0CBF7A9C3668641394B500053A")
    
public void unregisterForVoiceCallStarted(Handler h) {
        voiceCallStartedRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.727 -0500", hash_original_method = "D7F70C00A904DE96D26BDF7C49F41DAA", hash_generated_method = "EA8657688A790592CA2BF7644170F3D6")
    
public void registerForVoiceCallEnded(Handler h, int what, Object obj) {
        Registrant r = new Registrant(h, what, obj);
        voiceCallEndedRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.729 -0500", hash_original_method = "91176AF98778238DB3B453F2FC7D9448", hash_generated_method = "BC9403E0CD3C928D209E83809DDE4C4E")
    
public void unregisterForVoiceCallEnded(Handler h) {
        voiceCallEndedRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.732 -0500", hash_original_method = "F34086F28C205DD5876302448C7FB8FC", hash_generated_method = "79A93FEA3EE7351D10239BCCD58C5E9D")
    
public void registerForCallWaiting(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        callWaitingRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.734 -0500", hash_original_method = "F71574762174031DAD3F3CD1050F608A", hash_generated_method = "D37312F44CB7035FC4084870E0DC07EF")
    
public void unregisterForCallWaiting(Handler h) {
        callWaitingRegistrants.remove(h);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.736 -0500", hash_original_method = "B11C1D24F61F5A9ABEB7D187928BEC26", hash_generated_method = "028DCC8F83F806C4F951FBA15447674D")
    
private void
    fakeHoldForegroundBeforeDial() {
        List<Connection> connCopy;

        // We need to make a copy here, since fakeHoldBeforeDial()
        // modifies the lists, and we don't want to reverse the order
        connCopy = (List<Connection>) foregroundCall.connections.clone();

        for (int i = 0, s = connCopy.size() ; i < s ; i++) {
            CdmaConnection conn = (CdmaConnection)connCopy.get(i);

            conn.fakeHoldBeforeDial();
        }
    }

    /**
     * clirMode is one of the CLIR_ constants
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.739 -0500", hash_original_method = "FEC4E6BC08FD10A2C518984DAAD113C7", hash_generated_method = "1588BDF5754148DC78081AD24F221FCD")
    
Connection
    dial (String dialString, int clirMode) throws CallStateException {
        // note that this triggers call state changed notif
        clearDisconnected();

        if (!canDial()) {
            throw new CallStateException("cannot dial in current state");
        }

        String inEcm=SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
        boolean isPhoneInEcmMode = inEcm.equals("true");
        boolean isEmergencyCall =
                PhoneNumberUtils.isLocalEmergencyNumber(dialString, phone.getContext());

        // Cancel Ecm timer if a second emergency call is originating in Ecm mode
        if (isPhoneInEcmMode && isEmergencyCall) {
            handleEcmTimer(phone.CANCEL_ECM_TIMER);
        }

        // We are initiating a call therefore even if we previously
        // didn't know the state (i.e. Generic was true) we now know
        // and therefore can set Generic to false.
        foregroundCall.setGeneric(false);

        // The new call must be assigned to the foreground call.
        // That call must be idle, so place anything that's
        // there on hold
        if (foregroundCall.getState() == CdmaCall.State.ACTIVE) {
            return dialThreeWay(dialString);
        }

        pendingMO = new CdmaConnection(phone.getContext(), dialString, this, foregroundCall);
        hangupPendingMO = false;

        if (pendingMO.address == null || pendingMO.address.length() == 0
            || pendingMO.address.indexOf(PhoneNumberUtils.WILD) >= 0) {
            // Phone number is invalid
            pendingMO.cause = Connection.DisconnectCause.INVALID_NUMBER;

            // handlePollCalls() will notice this call not present
            // and will mark it as dropped.
            pollCallsWhenSafe();
        } else {
            // Always unmute when initiating a new call
            setMute(false);

            // Check data call
            disableDataCallInEmergencyCall(dialString);

            // In Ecm mode, if another emergency call is dialed, Ecm mode will not exit.
            if(!isPhoneInEcmMode || (isPhoneInEcmMode && isEmergencyCall)) {
                cm.dial(pendingMO.address, clirMode, obtainCompleteMessage());
            } else {
                phone.exitEmergencyCallbackMode();
                phone.setOnEcbModeExitResponse(this,EVENT_EXIT_ECM_RESPONSE_CDMA, null);
                pendingCallClirMode=clirMode;
                pendingCallInEcm=true;
            }
        }

        updatePhoneState();
        phone.notifyPreciseCallStateChanged();

        return pendingMO;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.742 -0500", hash_original_method = "916DB4F3BDDE26A491E1178653223CEE", hash_generated_method = "916DB4F3BDDE26A491E1178653223CEE")
    
Connection
    dial (String dialString) throws CallStateException {
        return dial(dialString, CommandsInterface.CLIR_DEFAULT);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.745 -0500", hash_original_method = "88840CD76FEAD0D0B90DCB96EA4A4A27", hash_generated_method = "30E30D8F19F28E82625A92DF4695ABBC")
    
private Connection
    dialThreeWay (String dialString) {
        if (!foregroundCall.isIdle()) {
            // Check data call
            disableDataCallInEmergencyCall(dialString);

            // Attach the new connection to foregroundCall
            pendingMO = new CdmaConnection(phone.getContext(),
                                dialString, this, foregroundCall);
            cm.sendCDMAFeatureCode(pendingMO.address,
                obtainMessage(EVENT_THREE_WAY_DIAL_L2_RESULT_CDMA));
            return pendingMO;
        }
        return null;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.748 -0500", hash_original_method = "A15B8A9C3B79A061845560CDFB3D1962", hash_generated_method = "9628ED37CC3A69F6AD179A03E35B5D7F")
    
void
    acceptCall() throws CallStateException {
        if (ringingCall.getState() == CdmaCall.State.INCOMING) {
            Log.i("phone", "acceptCall: incoming...");
            // Always unmute when answering a new call
            setMute(false);
            cm.acceptCall(obtainCompleteMessage());
        } else if (ringingCall.getState() == CdmaCall.State.WAITING) {
            CdmaConnection cwConn = (CdmaConnection)(ringingCall.getLatestConnection());

            // Since there is no network response for supplimentary
            // service for CDMA, we assume call waiting is answered.
            // ringing Call state change to idle is in CdmaCall.detach
            // triggered by updateParent.
            cwConn.updateParent(ringingCall, foregroundCall);
            cwConn.onConnectedInOrOut();
            updatePhoneState();
            switchWaitingOrHoldingAndActive();
        } else {
            throw new CallStateException("phone not ringing");
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.751 -0500", hash_original_method = "9B02E01190499DD77CD223AD7831C55B", hash_generated_method = "159188A7D123B2C37B5B4116F07A42E0")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.753 -0500", hash_original_method = "4E2E600B83947FE548823E8A00BDC609", hash_generated_method = "FBEEF82AA24D8E5869DB130B1C5155CD")
    
void
    switchWaitingOrHoldingAndActive() throws CallStateException {
        // Should we bother with this check?
        if (ringingCall.getState() == CdmaCall.State.INCOMING) {
            throw new CallStateException("cannot be in the incoming state");
        } else if (foregroundCall.getConnections().size() > 1) {
            flashAndSetGenericTrue();
        } else {
            // Send a flash command to CDMA network for putting the other party on hold.
            // For CDMA networks which do not support this the user would just hear a beep
            // from the network. For CDMA networks which do support it will put the other
            // party on hold.
            cm.sendCDMAFeatureCode("", obtainMessage(EVENT_SWITCH_RESULT));
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.756 -0500", hash_original_method = "B1073FCDB805CE663445BC5D803D76AA", hash_generated_method = "F8BCEA4E8B3CB91F30D58DEB594FFF78")
    
void
    conference() throws CallStateException {
        // Should we be checking state?
        flashAndSetGenericTrue();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.758 -0500", hash_original_method = "B9B58214FE30DEB2D41379B25D88E6DD", hash_generated_method = "B9B58214FE30DEB2D41379B25D88E6DD")
    
void
    explicitCallTransfer() throws CallStateException {
        cm.explicitCallTransfer(obtainCompleteMessage(EVENT_ECT_RESULT));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.760 -0500", hash_original_method = "89E1881B087BAA2C040FAFD444B532DA", hash_generated_method = "89E1881B087BAA2C040FAFD444B532DA")
    
void
    clearDisconnected() {
        internalClearDisconnected();

        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.763 -0500", hash_original_method = "885B69631C6ACC1E38924306F8EB7459", hash_generated_method = "885B69631C6ACC1E38924306F8EB7459")
    
boolean
    canConference() {
        return foregroundCall.getState() == CdmaCall.State.ACTIVE
                && backgroundCall.getState() == CdmaCall.State.HOLDING
                && !backgroundCall.isFull()
                && !foregroundCall.isFull();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.765 -0500", hash_original_method = "DFFE89A6FC85DFAF69854FF09292A4CC", hash_generated_method = "DFFE89A6FC85DFAF69854FF09292A4CC")
    
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
                    || (foregroundCall.getState() == CdmaCall.State.ACTIVE)
                    || !backgroundCall.getState().isAlive());

        if (!ret) {
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
        }
        return ret;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.767 -0500", hash_original_method = "F828A2F1845194FFD82C471D7E89F726", hash_generated_method = "F828A2F1845194FFD82C471D7E89F726")
    
boolean
    canTransfer() {
        Log.e(LOG_TAG, "canTransfer: not possible in CDMA");
        return false;
    }

    //***** Private Instance Methods

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.769 -0500", hash_original_method = "3058DCAC5E1117AE07A379578E7C6A20", hash_generated_method = "9EAF3135810EB7776F7263823E069660")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.772 -0500", hash_original_method = "89F67FF5AFAE8FAD9F556239F3E27159", hash_generated_method = "805FDE0EC1A77B26DA5992514EDF2DAB")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.774 -0500", hash_original_method = "F527C5C3DD4F0176588A0C261AD76B7A", hash_generated_method = "E21B90D8FFA2C73529233B2579E8CE52")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.777 -0500", hash_original_method = "179E11A88A956D6661DD344814FD0D33", hash_generated_method = "D7248FD5C0CAD7AF1FBA9E72CA812D4F")
    
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
            Log.e(LOG_TAG,"CdmaCallTracker.pendingOperations < 0");
            pendingOperations = 0;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.780 -0500", hash_original_method = "E4BBEB9CBA55B093A717754E6D30B945", hash_generated_method = "142EF9AA83C1CCB33DCBB91CE86B2AB7")
    
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
        if (Phone.DEBUG_PHONE) {
            log("update phone state, old=" + oldState + " new="+ state);
        }
        if (state != oldState) {
            phone.notifyPhoneStateChanged();
        }
    }

    // ***** Overwritten from CallTracker

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.787 -0500", hash_original_method = "63502DE56EE8A86B2DF78F720505C320", hash_generated_method = "6722EB5075ACDEB542DE14906A4A3A3F")
    
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
            CdmaConnection conn = connections[i];
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
                        // Re-start Ecm timer when an uncompleted emergency call ends
                        if (mIsEcmTimerCanceled) {
                            handleEcmTimer(phone.RESTART_ECM_TIMER);
                        }

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
                    if (Phone.DEBUG_PHONE) {
                        log("pendingMo=" + pendingMO + ", dc=" + dc);
                    }
                    // find if the MT call is a new ring or unknown connection
                    newRinging = checkMtFindNewRinging(dc,i);
                    if (newRinging == null) {
                        unknownConnectionAppeared = true;
                    }
                    checkAndEnableDataCallAfterEmergencyCallDropped();
                }
                hasNonHangupStateChanged = true;
            } else if (conn != null && dc == null) {
                // This case means the RIL has no more active call anymore and
                // we need to clean up the foregroundCall and ringingCall.
                // Loop through foreground call connections as
                // it contains the known logical connections.
                int count = foregroundCall.connections.size();
                for (int n = 0; n < count; n++) {
                    if (Phone.DEBUG_PHONE) log("adding fgCall cn " + n + " to droppedDuringPoll");
                    CdmaConnection cn = (CdmaConnection)foregroundCall.connections.get(n);
                    droppedDuringPoll.add(cn);
                }
                count = ringingCall.connections.size();
                // Loop through ringing call connections as
                // it may contain the known logical connections.
                for (int n = 0; n < count; n++) {
                    if (Phone.DEBUG_PHONE) log("adding rgCall cn " + n + " to droppedDuringPoll");
                    CdmaConnection cn = (CdmaConnection)ringingCall.connections.get(n);
                    droppedDuringPoll.add(cn);
                }
                foregroundCall.setGeneric(false);
                ringingCall.setGeneric(false);

                // Re-start Ecm timer when the connected emergency call ends
                if (mIsEcmTimerCanceled) {
                    handleEcmTimer(phone.RESTART_ECM_TIMER);
                }
                // If emergency call is not going through while dialing
                checkAndEnableDataCallAfterEmergencyCallDropped();

                // Dropped connections are removed from the CallTracker
                // list but kept in the Call list
                connections[i] = null;
            } else if (conn != null && dc != null) { /* implicit conn.compareTo(dc) */
                // Call collision case
                if (conn.isIncoming != dc.isMT) {
                    if (dc.isMT == true){
                        // Mt call takes precedence than Mo,drops Mo
                        droppedDuringPoll.add(conn);
                        // find if the MT call is a new ring or unknown connection
                        newRinging = checkMtFindNewRinging(dc,i);
                        if (newRinging == null) {
                            unknownConnectionAppeared = true;
                        }
                        checkAndEnableDataCallAfterEmergencyCallDropped();
                    } else {
                        // Call info stored in conn is not consistent with the call info from dc.
                        // We should follow the rule of MT calls taking precedence over MO calls
                        // when there is conflict, so here we drop the call info from dc and
                        // continue to use the call info from conn, and only take a log.
                        Log.e(LOG_TAG,"Error in RIL, Phantom call appeared " + dc);
                    }
                } else {
                    boolean changed;
                    changed = conn.update(dc);
                    hasNonHangupStateChanged = hasNonHangupStateChanged || changed;
                }
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
            if( pendingCallInEcm) {
                pendingCallInEcm = false;
            }
        }

        if (newRinging != null) {
            phone.notifyNewRingingConnection(newRinging);
        }

        // clear the "local hangup" and "missed/rejected call"
        // cases from the "dropped during poll" list
        // These cases need no "last call fail" reason
        for (int i = droppedDuringPoll.size() - 1; i >= 0 ; i--) {
            CdmaConnection conn = droppedDuringPoll.get(i);

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
            } else if (conn.cause == Connection.DisconnectCause.INVALID_NUMBER) {
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

    //***** Called from CdmaConnection
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.790 -0500", hash_original_method = "CA7F8E55CA885F7D7A3A262DD3D03608", hash_generated_method = "32D326C0F023261C0B289ABEC9139820")
    
void
    hangup (CdmaConnection conn) throws CallStateException {
        if (conn.owner != this) {
            throw new CallStateException ("CdmaConnection " + conn
                                    + "does not belong to CdmaCallTracker " + this);
        }

        if (conn == pendingMO) {
            // We're hanging up an outgoing call that doesn't have it's
            // GSM index assigned yet

            if (Phone.DEBUG_PHONE) log("hangup: set hangupPendingMO to true");
            hangupPendingMO = true;
        } else if ((conn.getCall() == ringingCall)
                && (ringingCall.getState() == CdmaCall.State.WAITING)) {
            // Handle call waiting hang up case.
            //
            // The ringingCall state will change to IDLE in CdmaCall.detach
            // if the ringing call connection size is 0. We don't specifically
            // set the ringing call state to IDLE here to avoid a race condition
            // where a new call waiting could get a hang up from an old call
            // waiting ringingCall.
            //
            // PhoneApp does the call log itself since only PhoneApp knows
            // the hangup reason is user ignoring or timing out. So conn.onDisconnect()
            // is not called here. Instead, conn.onLocalDisconnect() is called.
            conn.onLocalDisconnect();
            updatePhoneState();
            phone.notifyPreciseCallStateChanged();
            return;
        } else {
            try {
                cm.hangupConnection (conn.getCDMAIndex(), obtainCompleteMessage());
            } catch (CallStateException ex) {
                // Ignore "connection not found"
                // Call may have hung up already
                Log.w(LOG_TAG,"CdmaCallTracker WARN: hangup() on absent connection "
                                + conn);
            }
        }

        conn.onHangupLocal();
    }

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.793 -0500", hash_original_method = "B6040BEA0CD88965F5BB741ECCA6B877", hash_generated_method = "A06604AB24FFBAE744262B82DDD832BD")
    
void
    separate (CdmaConnection conn) throws CallStateException {
        if (conn.owner != this) {
            throw new CallStateException ("CdmaConnection " + conn
                                    + "does not belong to CdmaCallTracker " + this);
        }
        try {
            cm.separateConnection (conn.getCDMAIndex(),
                obtainCompleteMessage(EVENT_SEPARATE_RESULT));
        } catch (CallStateException ex) {
            // Ignore "connection not found"
            // Call may have hung up already
            Log.w(LOG_TAG,"CdmaCallTracker WARN: separate() on absent connection "
                          + conn);
        }
    }

    //***** Called from CDMAPhone

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.795 -0500", hash_original_method = "8E7DA06B8727FE7EBCD155EA09819106", hash_generated_method = "8E7DA06B8727FE7EBCD155EA09819106")
    
void
    setMute(boolean mute) {
        desiredMute = mute;
        cm.setMute(desiredMute, null);
    }

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.797 -0500", hash_original_method = "11907D6A9C6D8F23B8C0FECA1425D0D1", hash_generated_method = "11907D6A9C6D8F23B8C0FECA1425D0D1")
    
boolean
    getMute() {
        return desiredMute;
    }

    //***** Called from CdmaCall

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.800 -0500", hash_original_method = "E9438EE2A649600B881089247D36F1D3", hash_generated_method = "E9438EE2A649600B881089247D36F1D3")
    
void
    hangup (CdmaCall call) throws CallStateException {
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
                hangup((CdmaConnection)(call.getConnections().get(0)));
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
            throw new RuntimeException ("CdmaCall " + call +
                    "does not belong to CdmaCallTracker " + this);
        }

        call.onHangupLocal();
        phone.notifyPreciseCallStateChanged();
    }

    /* package */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.802 -0500", hash_original_method = "E840FBD61F8E6AF3DE802E32C39DD93E", hash_generated_method = "E840FBD61F8E6AF3DE802E32C39DD93E")
    
void hangupWaitingOrBackground() {
        if (Phone.DEBUG_PHONE) log("hangupWaitingOrBackground");
        cm.hangupWaitingOrBackground(obtainCompleteMessage());
    }

    /* package */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.805 -0500", hash_original_method = "D10B26113142441F52E905015040129F", hash_generated_method = "D10B26113142441F52E905015040129F")
    
void hangupForegroundResumeBackground() {
        if (Phone.DEBUG_PHONE) log("hangupForegroundResumeBackground");
        cm.hangupForegroundResumeBackground(obtainCompleteMessage());
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.807 -0500", hash_original_method = "46F42EF7B8FEEB9638F3768D6C678D5F", hash_generated_method = "46F42EF7B8FEEB9638F3768D6C678D5F")
    
void hangupConnectionByIndex(CdmaCall call, int index)
            throws CallStateException {
        int count = call.connections.size();
        for (int i = 0; i < count; i++) {
            CdmaConnection cn = (CdmaConnection)call.connections.get(i);
            if (cn.getCDMAIndex() == index) {
                cm.hangupConnection(index, obtainCompleteMessage());
                return;
            }
        }

        throw new CallStateException("no gsm index found");
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.809 -0500", hash_original_method = "C8ED8584ACDA74B40EBCC108129D9E6B", hash_generated_method = "C8ED8584ACDA74B40EBCC108129D9E6B")
    
void hangupAllConnections(CdmaCall call) throws CallStateException{
        try {
            int count = call.connections.size();
            for (int i = 0; i < count; i++) {
                CdmaConnection cn = (CdmaConnection)call.connections.get(i);
                cm.hangupConnection(cn.getCDMAIndex(), obtainCompleteMessage());
            }
        } catch (CallStateException ex) {
            Log.e(LOG_TAG, "hangupConnectionByIndex caught " + ex);
        }
    }

    /* package */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.812 -0500", hash_original_method = "DA3BA6D275DE18892F45915EBAE08DC8", hash_generated_method = "DA3BA6D275DE18892F45915EBAE08DC8")
    
CdmaConnection getConnectionByIndex(CdmaCall call, int index)
            throws CallStateException {
        int count = call.connections.size();
        for (int i = 0; i < count; i++) {
            CdmaConnection cn = (CdmaConnection)call.connections.get(i);
            if (cn.getCDMAIndex() == index) {
                return cn;
            }
        }

        return null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.814 -0500", hash_original_method = "EB39E7AA8B070FEFE523D7C5104C422F", hash_generated_method = "952A288DE63B2D8E63BC4A8DAEFEBFCF")
    
private void flashAndSetGenericTrue() throws CallStateException {
        cm.sendCDMAFeatureCode("", obtainMessage(EVENT_SWITCH_RESULT));

        // Set generic to true because in CDMA it is not known what
        // the status of the call is after a call waiting is answered,
        // 3 way call merged or a switch between calls.
        foregroundCall.setGeneric(true);
        phone.notifyPreciseCallStateChanged();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.816 -0500", hash_original_method = "65CD53B5AAA831AF61B9937ED3D66C8B", hash_generated_method = "1B5E0158171E6616D923AB0254C22598")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.819 -0500", hash_original_method = "6E2D3B844106C3BA4166C29F96BB7EA0", hash_generated_method = "7EA909082D0F3A766A83D359A75C4FD3")
    
private void handleRadioNotAvailable() {
        // handlePollCalls will clear out its
        // call list when it gets the CommandException
        // error result from this
        pollCallsWhenSafe();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.823 -0500", hash_original_method = "8A157B3E162ABAFDC3219E193FD9AF9E", hash_generated_method = "9C64105F2EFF3511A73662BA5F99F8BA")
    
private void notifyCallWaitingInfo(CdmaCallWaitingNotification obj) {
        if (callWaitingRegistrants != null) {
            callWaitingRegistrants.notifyRegistrants(new AsyncResult(null, obj, null));
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.825 -0500", hash_original_method = "8AEB0E73C414AF95EF44C542FCF55311", hash_generated_method = "2E28B2A83EFD60C49DEC2CDBCDEA905C")
    
private void handleCallWaitingInfo (CdmaCallWaitingNotification cw) {
        // Check how many connections in foregroundCall.
        // If the connection in foregroundCall is more
        // than one, then the connection information is
        // not reliable anymore since it means either
        // call waiting is connected or 3 way call is
        // dialed before, so set generic.
        if (foregroundCall.connections.size() > 1 ) {
            foregroundCall.setGeneric(true);
        }

        // Create a new CdmaConnection which attaches itself to ringingCall.
        ringingCall.setGeneric(false);
        new CdmaConnection(phone.getContext(), cw, this, ringingCall);
        updatePhoneState();

        // Finally notify application
        notifyCallWaitingInfo(cw);
    }
    //****** Overridden from Handler

    @DSSafe(DSCat.IPC_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.829 -0500", hash_original_method = "D1EB700FB6D9FD1E2DF39441FB36A7DD", hash_generated_method = "46996E77C662E1737BAE7325001DAED7")
    
public void
    handleMessage (Message msg) {
        AsyncResult ar;

        switch (msg.what) {
            case EVENT_POLL_CALLS_RESULT:{
                Log.d(LOG_TAG, "Event EVENT_POLL_CALLS_RESULT Received");
                ar = (AsyncResult)msg.obj;

                if(msg == lastRelevantPoll) {
                    if(DBG_POLL) log(
                            "handle EVENT_POLL_CALL_RESULT: set needsPoll=F");
                    needsPoll = false;
                    lastRelevantPoll = null;
                    handlePollCalls((AsyncResult)msg.obj);
                }
            }
            break;

            case EVENT_OPERATION_COMPLETE:
                operationComplete();
            break;

            case EVENT_SWITCH_RESULT:
                 // In GSM call operationComplete() here which gets the
                 // current call list. But in CDMA there is no list so
                 // there is nothing to do.
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

                for (int i = 0, s =  droppedDuringPoll.size()
                        ; i < s ; i++
                ) {
                    CdmaConnection conn = droppedDuringPoll.get(i);

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

            case EVENT_EXIT_ECM_RESPONSE_CDMA:
               //no matter the result, we still do the same here
               if (pendingCallInEcm) {
                   cm.dial(pendingMO.address, pendingCallClirMode, obtainCompleteMessage());
                   pendingCallInEcm = false;
               }
               phone.unsetOnEcbModeExitResponse(this);
            break;

            case EVENT_CALL_WAITING_INFO_CDMA:
               ar = (AsyncResult)msg.obj;
               if (ar.exception == null) {
                   handleCallWaitingInfo((CdmaCallWaitingNotification)ar.result);
                   Log.d(LOG_TAG, "Event EVENT_CALL_WAITING_INFO_CDMA Received");
               }
            break;

            case EVENT_THREE_WAY_DIAL_L2_RESULT_CDMA:
                ar = (AsyncResult)msg.obj;
                if (ar.exception == null) {
                    // Assume 3 way call is connected
                    pendingMO.onConnectedInOrOut();
                    pendingMO = null;
                }
            break;

            default:{
               throw new RuntimeException("unexpected event not handled");
            }
        }
    }

    /**
     * Handle Ecm timer to be canceled or re-started
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.832 -0500", hash_original_method = "53D0BC70C94C51E4941A4869C727C1EF", hash_generated_method = "C6205B9368136494AA6E18F1D039A277")
    
private void handleEcmTimer(int action) {
        phone.handleTimerInEmergencyCallbackMode(action);
        switch(action) {
        case CDMAPhone.CANCEL_ECM_TIMER: mIsEcmTimerCanceled = true; break;
        case CDMAPhone.RESTART_ECM_TIMER: mIsEcmTimerCanceled = false; break;
        default:
            Log.e(LOG_TAG, "handleEcmTimer, unsupported action " + action);
        }
    }

    /**
     * Disable data call when emergency call is connected
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.834 -0500", hash_original_method = "E45025BA49DB75441FB058D043F13559", hash_generated_method = "70809E6D41784C91458DFE99BB274D58")
    
private void disableDataCallInEmergencyCall(String dialString) {
        if (PhoneNumberUtils.isLocalEmergencyNumber(dialString, phone.getContext())) {
            if (Phone.DEBUG_PHONE) log("disableDataCallInEmergencyCall");
            mIsInEmergencyCall = true;
            phone.mDataConnectionTracker.setInternalDataEnabled(false);
        }
    }

    /**
     * Check and enable data call after an emergency call is dropped if it's
     * not in ECM
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.837 -0500", hash_original_method = "4B192230440137F94B49778D22CB7CD2", hash_generated_method = "EF578A8F193603212D59FEC332ACDBA1")
    
private void checkAndEnableDataCallAfterEmergencyCallDropped() {
        if (mIsInEmergencyCall) {
            mIsInEmergencyCall = false;
            String inEcm=SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
            if (Phone.DEBUG_PHONE) {
                log("checkAndEnableDataCallAfterEmergencyCallDropped,inEcm=" + inEcm);
            }
            if (inEcm.compareTo("false") == 0) {
                // Re-initiate data connection
                phone.mDataConnectionTracker.setInternalDataEnabled(true);
            }
        }
    }

    /**
     * Check the MT call to see if it's a new ring or
     * a unknown connection.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.840 -0500", hash_original_method = "D359964B058F5C9ECC2D15DB024983EF", hash_generated_method = "0D8C7939C3B1DDE90D4DB882655A0701")
    
private Connection checkMtFindNewRinging(DriverCall dc, int i) {

        Connection newRinging = null;

        connections[i] = new CdmaConnection(phone.getContext(), dc, this, i);
        // it's a ringing call
        if (connections[i].getCall() == ringingCall) {
            newRinging = connections[i];
            if (Phone.DEBUG_PHONE) log("Notify new ring " + dc);
        } else {
            // Something strange happened: a call which is neither
            // a ringing call nor the one we created. It could be the
            // call collision result from RIL
            Log.e(LOG_TAG,"Phantom call appeared " + dc);
            // If it's a connected call, set the connect time so that
            // it's non-zero.  It may not be accurate, but at least
            // it won't appear as a Missed Call.
            if (dc.state != DriverCall.State.ALERTING
                && dc.state != DriverCall.State.DIALING) {
                connections[i].connectTime = System.currentTimeMillis();
            }
        }
        return newRinging;
    }

    /**
     * Check if current call is in emergency call
     *
     * @return true if it is in emergency call
     *         false if it is not in emergency call
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.842 -0500", hash_original_method = "1842D0C2283B311B2A29E474687D9235", hash_generated_method = "1842D0C2283B311B2A29E474687D9235")
    
boolean isInEmergencyCall() {
        return mIsInEmergencyCall;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:58.844 -0500", hash_original_method = "FF708F6402A7A18425D7FC72639DE93E", hash_generated_method = "59056F0A087C6863B1CF7F9D449DB1C6")
    
protected void log(String msg) {
        Log.d(LOG_TAG, "[CdmaCallTracker] " + msg);
    }
}

