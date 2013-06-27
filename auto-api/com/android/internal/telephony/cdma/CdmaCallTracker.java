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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.366 -0400", hash_original_field = "C58F53C459878D89B341FB80EA845365", hash_generated_field = "6A689CEE5AFC02EE7871982A34436F33")

    CdmaConnection connections[] = new CdmaConnection[MAX_CONNECTIONS];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.366 -0400", hash_original_field = "8A0F3DEC66CFEEB2ECB457E5EA849D37", hash_generated_field = "D5D06964BBEC51B3D32BF2A900BC948B")

    RegistrantList voiceCallEndedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.366 -0400", hash_original_field = "CDE5B90F2260D3DC8A84E35500B6775B", hash_generated_field = "A661D5B9F6F26D0E5672FF445A016D80")

    RegistrantList voiceCallStartedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.366 -0400", hash_original_field = "64CA897868DAA4175C07D9B00CA5A6F5", hash_generated_field = "3D70A22464952A3DA788ACD133F18F18")

    RegistrantList callWaitingRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.366 -0400", hash_original_field = "FC84CE24FEB0A9E7F05DBB7000558261", hash_generated_field = "A29022524411F1FE9FAA91E8C50F5273")

    ArrayList<CdmaConnection> droppedDuringPoll = new ArrayList<CdmaConnection>(MAX_CONNECTIONS);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.366 -0400", hash_original_field = "0619E76BCFD69B42BEE8BE2B7FD7B9BD", hash_generated_field = "4BBDA18FC07012B464497A7036E9A64A")

    CdmaCall ringingCall = new CdmaCall(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.366 -0400", hash_original_field = "07FC128BE6CC33337F9DAFFBF9A07F18", hash_generated_field = "0CD0B75B3735614AF877856265E67CC2")

    CdmaCall foregroundCall = new CdmaCall(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.366 -0400", hash_original_field = "D855CF3B69C3475BF5A643D82E27F8C2", hash_generated_field = "1378E8D8E46107C480B8A53E811982F8")

    CdmaCall backgroundCall = new CdmaCall(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.366 -0400", hash_original_field = "FFF3375B9BFF76918F491666B68949AD", hash_generated_field = "2DB35562B0BF54F2C81F690DFDF249EA")

    CdmaConnection pendingMO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.366 -0400", hash_original_field = "1A8ABF13D702402EE54BFD56E4804126", hash_generated_field = "02C3359C89BD9A3EFAD64C6344B66724")

    boolean hangupPendingMO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.366 -0400", hash_original_field = "5FBB09530AC5F254B2B994A0BEBD3EE3", hash_generated_field = "2E8EE5EFDD4628948AC6D63D5B84BCF2")

    boolean pendingCallInEcm = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.366 -0400", hash_original_field = "123254AC1D49AFA1C4F58BABA1AE7779", hash_generated_field = "BC28D21C00A5A62F4E1E102DA65D0E68")

    boolean mIsInEmergencyCall = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.366 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "F2FC592D71DA2BCBED04F0F797B7B907")

    CDMAPhone phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.366 -0400", hash_original_field = "B262B2D3199ADD4E02EA2C990EA1FE1C", hash_generated_field = "9D75FD49CDE6D2073BBD4C557B93C735")

    boolean desiredMute = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.366 -0400", hash_original_field = "DBE99956F51C5D22A6E661875847A04F", hash_generated_field = "27174E0D68E2766EF4C51C4E944D5755")

    int pendingCallClirMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.366 -0400", hash_original_field = "2A29A007EEA18F3490433A6FDFAFB956", hash_generated_field = "40E232559DDE23609D651E7B63760E6C")

    Phone.State state = Phone.State.IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.366 -0400", hash_original_field = "9523AEECAD03B3078CD81B79CF3CBE20", hash_generated_field = "B4B1C0C1B427A1CEF2D1461193F5A876")

    private boolean mIsEcmTimerCanceled = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.367 -0400", hash_original_method = "D7E78FBD4DB8C2DC376D4ABE79BA3592", hash_generated_method = "B09BDF1A72EC50C995F9CEB1AB13E5B7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.429 -0400", hash_original_method = "2338338535849E159E02E311688F6BB3", hash_generated_method = "D5FF530FAE6148559B81D38F3B210670")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.430 -0400", hash_original_method = "73544050C1854D0258F226F7B919F554", hash_generated_method = "B58278D50A7470E880C8DDDBFC5E6BDE")
    @Override
    protected void finalize() {
        Log.d(LOG_TAG, "CdmaCallTracker finalized");
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "CdmaCallTracker finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.430 -0400", hash_original_method = "A19F9CA037C5D9E07B1DD2AD491B323A", hash_generated_method = "E8FF861720649380FE899807DE14A6CB")
    public void registerForVoiceCallStarted(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r;
        r = new Registrant(h, what, obj);
        voiceCallStartedRegistrants.add(r);
        {
            r.notifyRegistrant(new AsyncResult(null, null, null));
        } //End block
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //voiceCallStartedRegistrants.add(r);
        //if (state != Phone.State.IDLE) {
            //r.notifyRegistrant(new AsyncResult(null, null, null));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.430 -0400", hash_original_method = "3C910908B4B98998A7936D8F8AE4D170", hash_generated_method = "C25468CA1FE95BD597B1C8B73561A3E0")
    public void unregisterForVoiceCallStarted(Handler h) {
        voiceCallStartedRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //voiceCallStartedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.431 -0400", hash_original_method = "D7F70C00A904DE96D26BDF7C49F41DAA", hash_generated_method = "518F8D06300E35240567EC2598D34AFE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.432 -0400", hash_original_method = "91176AF98778238DB3B453F2FC7D9448", hash_generated_method = "471B41EFF418ACA24812A09760D0C9B8")
    public void unregisterForVoiceCallEnded(Handler h) {
        voiceCallEndedRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //voiceCallEndedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.432 -0400", hash_original_method = "F34086F28C205DD5876302448C7FB8FC", hash_generated_method = "EA4F4DEEC820CD881A0281B8924994F2")
    public void registerForCallWaiting(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r;
        r = new Registrant (h, what, obj);
        callWaitingRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //callWaitingRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.432 -0400", hash_original_method = "F71574762174031DAD3F3CD1050F608A", hash_generated_method = "5207E0CF2F711A00DA2B81DEF1358818")
    public void unregisterForCallWaiting(Handler h) {
        callWaitingRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //callWaitingRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.433 -0400", hash_original_method = "B11C1D24F61F5A9ABEB7D187928BEC26", hash_generated_method = "0BF56C9614228D61B7B44ECA58BECD59")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.457 -0400", hash_original_method = "FEC4E6BC08FD10A2C518984DAAD113C7", hash_generated_method = "ABC75D409247C450D51D56BDDFB16664")
     Connection dial(String dialString, int clirMode) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_1425021473 = null; //Variable for return #1
        Connection varB4EAC82CA7396A68D541C85D26508E83_1062425017 = null; //Variable for return #2
        clearDisconnected();
        {
            boolean var37336DD64F87D8D8C5FEC219FB8725E9_1255715118 = (!canDial());
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
            boolean varDDB23760708DF607FE68BBA82BCF4745_225753870 = (foregroundCall.getState() == CdmaCall.State.ACTIVE);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1425021473 = dialThreeWay(dialString);
            } //End block
        } //End collapsed parenthetic
        pendingMO = new CdmaConnection(phone.getContext(), dialString, this, foregroundCall);
        hangupPendingMO = false;
        {
            boolean varE9C786784B3495FF438205BDA3869C7F_880113519 = (pendingMO.address == null || pendingMO.address.length() == 0
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
                    pendingCallClirMode=clirMode;
                    pendingCallInEcm=true;
                } //End block
            } //End block
        } //End collapsed parenthetic
        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
        varB4EAC82CA7396A68D541C85D26508E83_1062425017 = pendingMO;
        Connection varA7E53CE21691AB073D9660D615818899_565110087; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_565110087 = varB4EAC82CA7396A68D541C85D26508E83_1425021473;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_565110087 = varB4EAC82CA7396A68D541C85D26508E83_1062425017;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_565110087.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_565110087;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.458 -0400", hash_original_method = "916DB4F3BDDE26A491E1178653223CEE", hash_generated_method = "824F4A2D382184EB6554C6DF009FB389")
     Connection dial(String dialString) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_1467961954 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1467961954 = dial(dialString, CommandsInterface.CLIR_DEFAULT);
        addTaint(dialString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1467961954.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1467961954;
        // ---------- Original Method ----------
        //return dial(dialString, CommandsInterface.CLIR_DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.458 -0400", hash_original_method = "88840CD76FEAD0D0B90DCB96EA4A4A27", hash_generated_method = "9EB5C51FB5DCF70D613FEB5E1FB8243B")
    private Connection dialThreeWay(String dialString) {
        Connection varB4EAC82CA7396A68D541C85D26508E83_470149225 = null; //Variable for return #1
        Connection varB4EAC82CA7396A68D541C85D26508E83_1114699195 = null; //Variable for return #2
        {
            boolean var88B3B730B5A85C1DC3D65F3B8BB9AFF3_232530376 = (!foregroundCall.isIdle());
            {
                disableDataCallInEmergencyCall(dialString);
                pendingMO = new CdmaConnection(phone.getContext(),
                                dialString, this, foregroundCall);
                cm.sendCDMAFeatureCode(pendingMO.address,
                obtainMessage(EVENT_THREE_WAY_DIAL_L2_RESULT_CDMA));
                varB4EAC82CA7396A68D541C85D26508E83_470149225 = pendingMO;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1114699195 = null;
        Connection varA7E53CE21691AB073D9660D615818899_1863717142; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1863717142 = varB4EAC82CA7396A68D541C85D26508E83_470149225;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1863717142 = varB4EAC82CA7396A68D541C85D26508E83_1114699195;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1863717142.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1863717142;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.459 -0400", hash_original_method = "A15B8A9C3B79A061845560CDFB3D1962", hash_generated_method = "D97EB5D2342A23022FBC7D76FB2A432F")
     void acceptCall() throws CallStateException {
        {
            boolean varC632C7B3E7E960D500E2F5ADC8B810C7_138914066 = (ringingCall.getState() == CdmaCall.State.INCOMING);
            {
                setMute(false);
                cm.acceptCall(obtainCompleteMessage());
            } //End block
            {
                boolean var6ABDCF912133D1B5B5A8B213BEB61799_1564043627 = (ringingCall.getState() == CdmaCall.State.WAITING);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.459 -0400", hash_original_method = "9B02E01190499DD77CD223AD7831C55B", hash_generated_method = "D59C7D51FBD8C6C38393811CF68D3AA6")
     void rejectCall() throws CallStateException {
        {
            boolean var2DE25B4C7BD786874002695E4305AD0A_2013583030 = (ringingCall.getState().isRinging());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.460 -0400", hash_original_method = "4E2E600B83947FE548823E8A00BDC609", hash_generated_method = "21D9B2DF0BE8EE50EB4CC21F99A97395")
     void switchWaitingOrHoldingAndActive() throws CallStateException {
        {
            boolean varC632C7B3E7E960D500E2F5ADC8B810C7_180949821 = (ringingCall.getState() == CdmaCall.State.INCOMING);
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("cannot be in the incoming state");
            } //End block
            {
                boolean var648F610A170CD29A32E13B581B3027F2_205862271 = (foregroundCall.getConnections().size() > 1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.460 -0400", hash_original_method = "B1073FCDB805CE663445BC5D803D76AA", hash_generated_method = "90ECDE91CEB46AEDFA1995478C6494BA")
     void conference() throws CallStateException {
        flashAndSetGenericTrue();
        // ---------- Original Method ----------
        //flashAndSetGenericTrue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.460 -0400", hash_original_method = "B9B58214FE30DEB2D41379B25D88E6DD", hash_generated_method = "91DDF637F580C2F12D44ADB525F30440")
     void explicitCallTransfer() throws CallStateException {
        cm.explicitCallTransfer(obtainCompleteMessage(EVENT_ECT_RESULT));
        // ---------- Original Method ----------
        //cm.explicitCallTransfer(obtainCompleteMessage(EVENT_ECT_RESULT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.537 -0400", hash_original_method = "89E1881B087BAA2C040FAFD444B532DA", hash_generated_method = "93C10D32BFEAACBDB937011534F3F686")
     void clearDisconnected() {
        internalClearDisconnected();
        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
        // ---------- Original Method ----------
        //internalClearDisconnected();
        //updatePhoneState();
        //phone.notifyPreciseCallStateChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.543 -0400", hash_original_method = "885B69631C6ACC1E38924306F8EB7459", hash_generated_method = "7C287288A4A2CEFDDB8C3DCE746FFB8F")
     boolean canConference() {
        boolean varA1CCEEF4312D253306B2C816C3DB70CE_1978880098 = (foregroundCall.getState() == CdmaCall.State.ACTIVE
                && backgroundCall.getState() == CdmaCall.State.HOLDING
                && !backgroundCall.isFull()
                && !foregroundCall.isFull());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_128498019 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_128498019;
        // ---------- Original Method ----------
        //return foregroundCall.getState() == CdmaCall.State.ACTIVE
                //&& backgroundCall.getState() == CdmaCall.State.HOLDING
                //&& !backgroundCall.isFull()
                //&& !foregroundCall.isFull();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.543 -0400", hash_original_method = "DFFE89A6FC85DFAF69854FF09292A4CC", hash_generated_method = "C5CBEA3026503675A5C048DAE499A942")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1807057030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1807057030;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.544 -0400", hash_original_method = "F828A2F1845194FFD82C471D7E89F726", hash_generated_method = "2981850BF150B3CA588503AC73EB118C")
     boolean canTransfer() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1166109552 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1166109552;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "canTransfer: not possible in CDMA");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.544 -0400", hash_original_method = "3058DCAC5E1117AE07A379578E7C6A20", hash_generated_method = "F0E9C736A8A4591368CEECFAB84F530D")
    private void internalClearDisconnected() {
        ringingCall.clearDisconnected();
        foregroundCall.clearDisconnected();
        backgroundCall.clearDisconnected();
        // ---------- Original Method ----------
        //ringingCall.clearDisconnected();
        //foregroundCall.clearDisconnected();
        //backgroundCall.clearDisconnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.544 -0400", hash_original_method = "89F67FF5AFAE8FAD9F556239F3E27159", hash_generated_method = "8965A47C9E8F6FCB6F7712EE44ABB232")
    private Message obtainCompleteMessage() {
        Message varB4EAC82CA7396A68D541C85D26508E83_471764143 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_471764143 = obtainCompleteMessage(EVENT_OPERATION_COMPLETE);
        varB4EAC82CA7396A68D541C85D26508E83_471764143.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_471764143;
        // ---------- Original Method ----------
        //return obtainCompleteMessage(EVENT_OPERATION_COMPLETE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.557 -0400", hash_original_method = "F527C5C3DD4F0176588A0C261AD76B7A", hash_generated_method = "AC6BE51F8503C7662404754704F0F6C8")
    private Message obtainCompleteMessage(int what) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1666669343 = null; //Variable for return #1
        lastRelevantPoll = null;
        needsPoll = true;
        log("obtainCompleteMessage: pendingOperations=" +
                pendingOperations + ", needsPoll=" + needsPoll);
        varB4EAC82CA7396A68D541C85D26508E83_1666669343 = obtainMessage(what);
        addTaint(what);
        varB4EAC82CA7396A68D541C85D26508E83_1666669343.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1666669343;
        // ---------- Original Method ----------
        //pendingOperations++;
        //lastRelevantPoll = null;
        //needsPoll = true;
        //if (DBG_POLL) log("obtainCompleteMessage: pendingOperations=" +
                //pendingOperations + ", needsPoll=" + needsPoll);
        //return obtainMessage(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.557 -0400", hash_original_method = "179E11A88A956D6661DD344814FD0D33", hash_generated_method = "21D885F66B272BE8E1EC799AD882A619")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.558 -0400", hash_original_method = "E4BBEB9CBA55B093A717754E6D30B945", hash_generated_method = "DAB02DF4EDD86F5763DE33BFC572824B")
    private void updatePhoneState() {
        Phone.State oldState;
        oldState = state;
        {
            boolean varE4BD9FA258196C0B4AF6B5D416334169_685106613 = (ringingCall.isRinging());
            {
                state = Phone.State.RINGING;
            } //End block
            {
                boolean var4C7AB8264C38A76EB062AB98EEF3EE82_502754236 = (pendingMO != null ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.581 -0400", hash_original_method = "63502DE56EE8A86B2DF78F720505C320", hash_generated_method = "7CE0DFCF63A1507A3875532837A64DAC")
    protected void handlePollCalls(AsyncResult ar) {
        List polledCalls;
        {
            polledCalls = (List)ar.result;
        } //End block
        {
            boolean varC4DBE3EAF9ED931A30C22A297B6E685B_942136386 = (isCommandExceptionRadioNotAvailable(ar.exception));
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
                        boolean varA12D38D4E3C5051B181541F930988B8A_593944878 = (pendingMO != null && pendingMO.compareTo(dc));
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
                    boolean var8064D1618E098621AFE888A1369217F2_447310147 = (conn.isIncoming() && conn.getConnectTime() == 0);
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
            boolean varA25616F2AD7C98E00F706161A5B687F7_364127487 = (droppedDuringPoll.size() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.606 -0400", hash_original_method = "CA7F8E55CA885F7D7A3A262DD3D03608", hash_generated_method = "2A1AB81A3E5CF528CE0A641F7443F7CF")
     void hangup(CdmaConnection conn) throws CallStateException {
        {
            boolean var7B293A7D3CB476B7EF41E01A5B6DD8B4_941282247 = (conn.owner != this);
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
            boolean var7215D6E68D3558026AB7D731B4F5BDD0_1547075979 = ((conn.getCall() == ringingCall)
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
        addTaint(conn.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.607 -0400", hash_original_method = "B6040BEA0CD88965F5BB741ECCA6B877", hash_generated_method = "0B151664CB4982E86BCFB1E4F78130EA")
     void separate(CdmaConnection conn) throws CallStateException {
        {
            boolean var7B293A7D3CB476B7EF41E01A5B6DD8B4_107797124 = (conn.owner != this);
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
        addTaint(conn.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.607 -0400", hash_original_method = "8E7DA06B8727FE7EBCD155EA09819106", hash_generated_method = "09D97CBFA339BB68260AAF45EF5FD946")
     void setMute(boolean mute) {
        desiredMute = mute;
        cm.setMute(desiredMute, null);
        // ---------- Original Method ----------
        //desiredMute = mute;
        //cm.setMute(desiredMute, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.608 -0400", hash_original_method = "11907D6A9C6D8F23B8C0FECA1425D0D1", hash_generated_method = "3B207523B00ED230B042B7CD74146831")
     boolean getMute() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1105172128 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1105172128;
        // ---------- Original Method ----------
        //return desiredMute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.609 -0400", hash_original_method = "E9438EE2A649600B881089247D36F1D3", hash_generated_method = "1F46866C7FFF3AFF612711119BA3A3FB")
     void hangup(CdmaCall call) throws CallStateException {
        {
            boolean varE4A326D5F85A22F10F9645DF8E94C259_1482461881 = (call.getConnections().size() == 0);
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
                boolean var22C48955666B247FCD89E865FCE21904_905127811 = (call.isDialingOrAlerting());
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
                boolean varA4A4A8F760ECA28FD2366D22B56B66BD_1438114122 = (ringingCall.isRinging());
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
        addTaint(call.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.624 -0400", hash_original_method = "E840FBD61F8E6AF3DE802E32C39DD93E", hash_generated_method = "4AF2AF2C1AF283F2B3D66EB92EFBBE89")
     void hangupWaitingOrBackground() {
        log("hangupWaitingOrBackground");
        cm.hangupWaitingOrBackground(obtainCompleteMessage());
        // ---------- Original Method ----------
        //if (Phone.DEBUG_PHONE) log("hangupWaitingOrBackground");
        //cm.hangupWaitingOrBackground(obtainCompleteMessage());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.624 -0400", hash_original_method = "D10B26113142441F52E905015040129F", hash_generated_method = "939D43994EC933107D2D3D9C50AF847D")
     void hangupForegroundResumeBackground() {
        log("hangupForegroundResumeBackground");
        cm.hangupForegroundResumeBackground(obtainCompleteMessage());
        // ---------- Original Method ----------
        //if (Phone.DEBUG_PHONE) log("hangupForegroundResumeBackground");
        //cm.hangupForegroundResumeBackground(obtainCompleteMessage());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.628 -0400", hash_original_method = "46F42EF7B8FEEB9638F3768D6C678D5F", hash_generated_method = "7C04BE74E2F0FB220F6707CF0A47971D")
     void hangupConnectionByIndex(CdmaCall call, int index) throws CallStateException {
        int count;
        count = call.connections.size();
        {
            int i;
            i = 0;
            {
                CdmaConnection cn;
                cn = (CdmaConnection)call.connections.get(i);
                {
                    boolean varD4890B27B1518CF37532B19255789636_483686144 = (cn.getCDMAIndex() == index);
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
            //CdmaConnection cn = (CdmaConnection)call.connections.get(i);
            //if (cn.getCDMAIndex() == index) {
                //cm.hangupConnection(index, obtainCompleteMessage());
                //return;
            //}
        //}
        //throw new CallStateException("no gsm index found");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.629 -0400", hash_original_method = "C8ED8584ACDA74B40EBCC108129D9E6B", hash_generated_method = "BB04D8FCC360BB528433051B8741B929")
     void hangupAllConnections(CdmaCall call) throws CallStateException {
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
        addTaint(call.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.639 -0400", hash_original_method = "DA3BA6D275DE18892F45915EBAE08DC8", hash_generated_method = "404D52B77DD182889B6A88016E9D13A2")
     CdmaConnection getConnectionByIndex(CdmaCall call, int index) throws CallStateException {
        CdmaConnection varB4EAC82CA7396A68D541C85D26508E83_1269451430 = null; //Variable for return #1
        CdmaConnection varB4EAC82CA7396A68D541C85D26508E83_863945890 = null; //Variable for return #2
        int count;
        count = call.connections.size();
        {
            int i;
            i = 0;
            {
                CdmaConnection cn;
                cn = (CdmaConnection)call.connections.get(i);
                {
                    boolean varD4890B27B1518CF37532B19255789636_789189699 = (cn.getCDMAIndex() == index);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1269451430 = cn;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_863945890 = null;
        addTaint(call.getTaint());
        addTaint(index);
        CdmaConnection varA7E53CE21691AB073D9660D615818899_200782956; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_200782956 = varB4EAC82CA7396A68D541C85D26508E83_1269451430;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_200782956 = varB4EAC82CA7396A68D541C85D26508E83_863945890;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_200782956.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_200782956;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.650 -0400", hash_original_method = "EB39E7AA8B070FEFE523D7C5104C422F", hash_generated_method = "F2B22B9C2961AD4C91E3828C52AE1EE4")
    private void flashAndSetGenericTrue() throws CallStateException {
        cm.sendCDMAFeatureCode("", obtainMessage(EVENT_SWITCH_RESULT));
        foregroundCall.setGeneric(true);
        phone.notifyPreciseCallStateChanged();
        // ---------- Original Method ----------
        //cm.sendCDMAFeatureCode("", obtainMessage(EVENT_SWITCH_RESULT));
        //foregroundCall.setGeneric(true);
        //phone.notifyPreciseCallStateChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.655 -0400", hash_original_method = "65CD53B5AAA831AF61B9937ED3D66C8B", hash_generated_method = "8B94E33BD1C88113B4FAD61D99987843")
    private Phone.SuppService getFailedService(int what) {
        Phone.SuppService varB4EAC82CA7396A68D541C85D26508E83_2125495470 = null; //Variable for return #1
        Phone.SuppService varB4EAC82CA7396A68D541C85D26508E83_1946749667 = null; //Variable for return #2
        Phone.SuppService varB4EAC82CA7396A68D541C85D26508E83_808858260 = null; //Variable for return #3
        Phone.SuppService varB4EAC82CA7396A68D541C85D26508E83_387364070 = null; //Variable for return #4
        Phone.SuppService varB4EAC82CA7396A68D541C85D26508E83_853116019 = null; //Variable for return #5
        //Begin case EVENT_SWITCH_RESULT 
        varB4EAC82CA7396A68D541C85D26508E83_2125495470 = Phone.SuppService.SWITCH;
        //End case EVENT_SWITCH_RESULT 
        //Begin case EVENT_CONFERENCE_RESULT 
        varB4EAC82CA7396A68D541C85D26508E83_1946749667 = Phone.SuppService.CONFERENCE;
        //End case EVENT_CONFERENCE_RESULT 
        //Begin case EVENT_SEPARATE_RESULT 
        varB4EAC82CA7396A68D541C85D26508E83_808858260 = Phone.SuppService.SEPARATE;
        //End case EVENT_SEPARATE_RESULT 
        //Begin case EVENT_ECT_RESULT 
        varB4EAC82CA7396A68D541C85D26508E83_387364070 = Phone.SuppService.TRANSFER;
        //End case EVENT_ECT_RESULT 
        varB4EAC82CA7396A68D541C85D26508E83_853116019 = Phone.SuppService.UNKNOWN;
        addTaint(what);
        Phone.SuppService varA7E53CE21691AB073D9660D615818899_1760399645; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1760399645 = varB4EAC82CA7396A68D541C85D26508E83_2125495470;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1760399645 = varB4EAC82CA7396A68D541C85D26508E83_1946749667;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1760399645 = varB4EAC82CA7396A68D541C85D26508E83_808858260;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1760399645 = varB4EAC82CA7396A68D541C85D26508E83_387364070;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1760399645 = varB4EAC82CA7396A68D541C85D26508E83_853116019;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1760399645.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1760399645;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.656 -0400", hash_original_method = "6E2D3B844106C3BA4166C29F96BB7EA0", hash_generated_method = "3D35CA8E198B65065816E56AAB25BAB7")
    private void handleRadioNotAvailable() {
        pollCallsWhenSafe();
        // ---------- Original Method ----------
        //pollCallsWhenSafe();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.656 -0400", hash_original_method = "8A157B3E162ABAFDC3219E193FD9AF9E", hash_generated_method = "934C88622A150E066610041A3B8D15C7")
    private void notifyCallWaitingInfo(CdmaCallWaitingNotification obj) {
        {
            callWaitingRegistrants.notifyRegistrants(new AsyncResult(null, obj, null));
        } //End block
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //if (callWaitingRegistrants != null) {
            //callWaitingRegistrants.notifyRegistrants(new AsyncResult(null, obj, null));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.656 -0400", hash_original_method = "8AEB0E73C414AF95EF44C542FCF55311", hash_generated_method = "EECF3E06EF6F001A1BD2B9FA7A28D970")
    private void handleCallWaitingInfo(CdmaCallWaitingNotification cw) {
        {
            boolean varF80A25201569015423B9C49F57AE8341_989004191 = (foregroundCall.connections.size() > 1);
            {
                foregroundCall.setGeneric(true);
            } //End block
        } //End collapsed parenthetic
        ringingCall.setGeneric(false);
        new CdmaConnection(phone.getContext(), cw, this, ringingCall);
        updatePhoneState();
        notifyCallWaitingInfo(cw);
        addTaint(cw.getTaint());
        // ---------- Original Method ----------
        //if (foregroundCall.connections.size() > 1 ) {
            //foregroundCall.setGeneric(true);
        //}
        //ringingCall.setGeneric(false);
        //new CdmaConnection(phone.getContext(), cw, this, ringingCall);
        //updatePhoneState();
        //notifyCallWaitingInfo(cw);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.659 -0400", hash_original_method = "D1EB700FB6D9FD1E2DF39441FB36A7DD", hash_generated_method = "03C8CC972A9753291596C5D79512903F")
    public void handleMessage(Message msg) {
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
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.672 -0400", hash_original_method = "53D0BC70C94C51E4941A4869C727C1EF", hash_generated_method = "AB928354D921018BDB8E7CC54AA63F30")
    private void handleEcmTimer(int action) {
        phone.handleTimerInEmergencyCallbackMode(action);
        //Begin case CDMAPhone.CANCEL_ECM_TIMER 
        mIsEcmTimerCanceled = true;
        //End case CDMAPhone.CANCEL_ECM_TIMER 
        //Begin case CDMAPhone.RESTART_ECM_TIMER 
        mIsEcmTimerCanceled = false;
        //End case CDMAPhone.RESTART_ECM_TIMER 
        addTaint(action);
        // ---------- Original Method ----------
        //phone.handleTimerInEmergencyCallbackMode(action);
        //switch(action) {
        //case CDMAPhone.CANCEL_ECM_TIMER: mIsEcmTimerCanceled = true; break;
        //case CDMAPhone.RESTART_ECM_TIMER: mIsEcmTimerCanceled = false; break;
        //default:
            //Log.e(LOG_TAG, "handleEcmTimer, unsupported action " + action);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.674 -0400", hash_original_method = "E45025BA49DB75441FB058D043F13559", hash_generated_method = "72E938477E6719AE6CFC0CFE762199F5")
    private void disableDataCallInEmergencyCall(String dialString) {
        {
            boolean var325FA9D4EF820F6526AF47F3B166DBE6_1310497477 = (PhoneNumberUtils.isLocalEmergencyNumber(dialString, phone.getContext()));
            {
                log("disableDataCallInEmergencyCall");
                mIsInEmergencyCall = true;
                phone.mDataConnectionTracker.setInternalDataEnabled(false);
            } //End block
        } //End collapsed parenthetic
        addTaint(dialString.getTaint());
        // ---------- Original Method ----------
        //if (PhoneNumberUtils.isLocalEmergencyNumber(dialString, phone.getContext())) {
            //if (Phone.DEBUG_PHONE) log("disableDataCallInEmergencyCall");
            //mIsInEmergencyCall = true;
            //phone.mDataConnectionTracker.setInternalDataEnabled(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.677 -0400", hash_original_method = "4B192230440137F94B49778D22CB7CD2", hash_generated_method = "BDE51D3E6C2EA0575B305EE3F89FBF5E")
    private void checkAndEnableDataCallAfterEmergencyCallDropped() {
        {
            mIsInEmergencyCall = false;
            String inEcm;
            inEcm = SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
            {
                log("checkAndEnableDataCallAfterEmergencyCallDropped,inEcm=" + inEcm);
            } //End block
            {
                boolean varF1938E19DDB5D7D21BFFF4FE8AA8EABF_1026163800 = (inEcm.compareTo("false") == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.694 -0400", hash_original_method = "D359964B058F5C9ECC2D15DB024983EF", hash_generated_method = "BC12FCD4BD6C785E3E34799117F2C200")
    private Connection checkMtFindNewRinging(DriverCall dc, int i) {
        Connection varB4EAC82CA7396A68D541C85D26508E83_2002682016 = null; //Variable for return #1
        Connection newRinging;
        newRinging = null;
        connections[i] = new CdmaConnection(phone.getContext(), dc, this, i);
        {
            boolean var77F010D23417E833441F8B3A6431ABA1_1855742307 = (connections[i].getCall() == ringingCall);
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
        varB4EAC82CA7396A68D541C85D26508E83_2002682016 = newRinging;
        addTaint(dc.getTaint());
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_2002682016.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2002682016;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.695 -0400", hash_original_method = "1842D0C2283B311B2A29E474687D9235", hash_generated_method = "9D1915EB0F0C290CA32FD446DCF31EB5")
     boolean isInEmergencyCall() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_583980234 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_583980234;
        // ---------- Original Method ----------
        //return mIsInEmergencyCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.695 -0400", hash_original_method = "FF708F6402A7A18425D7FC72639DE93E", hash_generated_method = "F0C8DCFB659F32D7C1DB873DA97A6356")
    protected void log(String msg) {
        Log.d(LOG_TAG, "[CdmaCallTracker] " + msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CdmaCallTracker] " + msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.695 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "3985FC5365F0E17AC0BA70F3DC93B852")

    static String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.695 -0400", hash_original_field = "CC792B139E86B59BF5644A291C349001", hash_generated_field = "F8A73D277C72A0CE9C2EB7E2C37AB4EF")

    private static boolean REPEAT_POLLING = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.695 -0400", hash_original_field = "BA76C0C87FE0928477EB48E458A4151B", hash_generated_field = "AF4E2F29C7D0C5C24239F77C6471B21A")

    private static boolean DBG_POLL = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.695 -0400", hash_original_field = "5D8CCE6E8CAE49F3DAE5020BF6731533", hash_generated_field = "698C49ADEF2D62546806883BCB9357AE")

    static int MAX_CONNECTIONS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.695 -0400", hash_original_field = "109C1DEC6EE2198ED540651FC4E6F2F6", hash_generated_field = "D13C9B2BD15487F3D965E7C9AA40CE73")

    static int MAX_CONNECTIONS_PER_CALL = 1;
}

