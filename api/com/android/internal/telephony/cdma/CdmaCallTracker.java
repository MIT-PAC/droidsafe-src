package com.android.internal.telephony.cdma;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.269 -0400", hash_original_field = "C58F53C459878D89B341FB80EA845365", hash_generated_field = "6A689CEE5AFC02EE7871982A34436F33")

    CdmaConnection connections[] = new CdmaConnection[MAX_CONNECTIONS];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.269 -0400", hash_original_field = "8A0F3DEC66CFEEB2ECB457E5EA849D37", hash_generated_field = "D5D06964BBEC51B3D32BF2A900BC948B")

    RegistrantList voiceCallEndedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.270 -0400", hash_original_field = "CDE5B90F2260D3DC8A84E35500B6775B", hash_generated_field = "A661D5B9F6F26D0E5672FF445A016D80")

    RegistrantList voiceCallStartedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.270 -0400", hash_original_field = "64CA897868DAA4175C07D9B00CA5A6F5", hash_generated_field = "3D70A22464952A3DA788ACD133F18F18")

    RegistrantList callWaitingRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.270 -0400", hash_original_field = "FC84CE24FEB0A9E7F05DBB7000558261", hash_generated_field = "A29022524411F1FE9FAA91E8C50F5273")

    ArrayList<CdmaConnection> droppedDuringPoll = new ArrayList<CdmaConnection>(MAX_CONNECTIONS);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.270 -0400", hash_original_field = "0619E76BCFD69B42BEE8BE2B7FD7B9BD", hash_generated_field = "4BBDA18FC07012B464497A7036E9A64A")

    CdmaCall ringingCall = new CdmaCall(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.270 -0400", hash_original_field = "07FC128BE6CC33337F9DAFFBF9A07F18", hash_generated_field = "0CD0B75B3735614AF877856265E67CC2")

    CdmaCall foregroundCall = new CdmaCall(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.270 -0400", hash_original_field = "D855CF3B69C3475BF5A643D82E27F8C2", hash_generated_field = "1378E8D8E46107C480B8A53E811982F8")

    CdmaCall backgroundCall = new CdmaCall(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.270 -0400", hash_original_field = "FFF3375B9BFF76918F491666B68949AD", hash_generated_field = "2DB35562B0BF54F2C81F690DFDF249EA")

    CdmaConnection pendingMO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.270 -0400", hash_original_field = "1A8ABF13D702402EE54BFD56E4804126", hash_generated_field = "02C3359C89BD9A3EFAD64C6344B66724")

    boolean hangupPendingMO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.270 -0400", hash_original_field = "5FBB09530AC5F254B2B994A0BEBD3EE3", hash_generated_field = "2E8EE5EFDD4628948AC6D63D5B84BCF2")

    boolean pendingCallInEcm = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.270 -0400", hash_original_field = "123254AC1D49AFA1C4F58BABA1AE7779", hash_generated_field = "BC28D21C00A5A62F4E1E102DA65D0E68")

    boolean mIsInEmergencyCall = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.270 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "F2FC592D71DA2BCBED04F0F797B7B907")

    CDMAPhone phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.270 -0400", hash_original_field = "B262B2D3199ADD4E02EA2C990EA1FE1C", hash_generated_field = "9D75FD49CDE6D2073BBD4C557B93C735")

    boolean desiredMute = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.270 -0400", hash_original_field = "DBE99956F51C5D22A6E661875847A04F", hash_generated_field = "27174E0D68E2766EF4C51C4E944D5755")

    int pendingCallClirMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.270 -0400", hash_original_field = "2A29A007EEA18F3490433A6FDFAFB956", hash_generated_field = "40E232559DDE23609D651E7B63760E6C")

    Phone.State state = Phone.State.IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.270 -0400", hash_original_field = "9523AEECAD03B3078CD81B79CF3CBE20", hash_generated_field = "B4B1C0C1B427A1CEF2D1461193F5A876")

    private boolean mIsEcmTimerCanceled = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.271 -0400", hash_original_method = "D7E78FBD4DB8C2DC376D4ABE79BA3592", hash_generated_method = "B09BDF1A72EC50C995F9CEB1AB13E5B7")
      CdmaCallTracker(CDMAPhone phone) {
        this.phone = phone;
        cm = phone.mCM;
        cm.registerForCallStateChanged(this, EVENT_CALL_STATE_CHANGE, null);
        cm.registerForOn(this, EVENT_RADIO_AVAILABLE, null);
        cm.registerForNotAvailable(this, EVENT_RADIO_NOT_AVAILABLE, null);
        cm.registerForCallWaitingInfo(this, EVENT_CALL_WAITING_INFO_CDMA, null);
        foregroundCall.setGeneric(false);
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.276 -0400", hash_original_method = "2338338535849E159E02E311688F6BB3", hash_generated_method = "D5FF530FAE6148559B81D38F3B210670")
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
                } 
                catch (CallStateException ex)
                { }
            } 
        } 
        try 
        {
            hangup(pendingMO);
        } 
        catch (CallStateException ex)
        { }
        clearDisconnected();
        
        
        
        
        
        
            
                
            
                
            
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.277 -0400", hash_original_method = "73544050C1854D0258F226F7B919F554", hash_generated_method = "B58278D50A7470E880C8DDDBFC5E6BDE")
    @Override
    protected void finalize() {
        Log.d(LOG_TAG, "CdmaCallTracker finalized");
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.277 -0400", hash_original_method = "A19F9CA037C5D9E07B1DD2AD491B323A", hash_generated_method = "0830F369841E477ABA71AF9FEC26F143")
    public void registerForVoiceCallStarted(Handler h, int what, Object obj) {
        
        Registrant r = new Registrant(h, what, obj);
        voiceCallStartedRegistrants.add(r);
        {
            r.notifyRegistrant(new AsyncResult(null, null, null));
        } 
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.278 -0400", hash_original_method = "3C910908B4B98998A7936D8F8AE4D170", hash_generated_method = "C25468CA1FE95BD597B1C8B73561A3E0")
    public void unregisterForVoiceCallStarted(Handler h) {
        voiceCallStartedRegistrants.remove(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.278 -0400", hash_original_method = "D7F70C00A904DE96D26BDF7C49F41DAA", hash_generated_method = "D2DCBB28172AA64C19EC56DC2A40AA2D")
    public void registerForVoiceCallEnded(Handler h, int what, Object obj) {
        
        Registrant r = new Registrant(h, what, obj);
        voiceCallEndedRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.278 -0400", hash_original_method = "91176AF98778238DB3B453F2FC7D9448", hash_generated_method = "471B41EFF418ACA24812A09760D0C9B8")
    public void unregisterForVoiceCallEnded(Handler h) {
        voiceCallEndedRegistrants.remove(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.278 -0400", hash_original_method = "F34086F28C205DD5876302448C7FB8FC", hash_generated_method = "B8F84101337552C26C562C7746638748")
    public void registerForCallWaiting(Handler h, int what, Object obj) {
        
        Registrant r = new Registrant (h, what, obj);
        callWaitingRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.279 -0400", hash_original_method = "F71574762174031DAD3F3CD1050F608A", hash_generated_method = "5207E0CF2F711A00DA2B81DEF1358818")
    public void unregisterForCallWaiting(Handler h) {
        callWaitingRegistrants.remove(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.279 -0400", hash_original_method = "B11C1D24F61F5A9ABEB7D187928BEC26", hash_generated_method = "B4E3E1DBFA1B2EACAD7AAB98B64CC1BF")
    private void fakeHoldForegroundBeforeDial() {
        List<Connection> connCopy;
        connCopy = (List<Connection>) foregroundCall.connections.clone();
        {
            int i = 0;
            int s = connCopy.size();
            {
                CdmaConnection conn = (CdmaConnection)connCopy.get(i);
                conn.fakeHoldBeforeDial();
            } 
        } 
        
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.293 -0400", hash_original_method = "FEC4E6BC08FD10A2C518984DAAD113C7", hash_generated_method = "7EB11BC51490B620079C4454672BB8E3")
     Connection dial(String dialString, int clirMode) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_882631443 = null; 
        Connection varB4EAC82CA7396A68D541C85D26508E83_916055820 = null; 
        clearDisconnected();
        {
            boolean var37336DD64F87D8D8C5FEC219FB8725E9_1639688455 = (!canDial());
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("cannot dial in current state");
            } 
        } 
        String inEcm = SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
        boolean isPhoneInEcmMode = inEcm.equals("true");
        boolean isEmergencyCall = PhoneNumberUtils.isLocalEmergencyNumber(dialString, phone.getContext());
        {
            handleEcmTimer(phone.CANCEL_ECM_TIMER);
        } 
        foregroundCall.setGeneric(false);
        {
            boolean varDDB23760708DF607FE68BBA82BCF4745_986097311 = (foregroundCall.getState() == CdmaCall.State.ACTIVE);
            {
                varB4EAC82CA7396A68D541C85D26508E83_882631443 = dialThreeWay(dialString);
            } 
        } 
        pendingMO = new CdmaConnection(phone.getContext(), dialString, this, foregroundCall);
        hangupPendingMO = false;
        {
            boolean varE9C786784B3495FF438205BDA3869C7F_1858284948 = (pendingMO.address == null || pendingMO.address.length() == 0
            || pendingMO.address.indexOf(PhoneNumberUtils.WILD) >= 0);
            {
                pendingMO.cause = Connection.DisconnectCause.INVALID_NUMBER;
                pollCallsWhenSafe();
            } 
            {
                setMute(false);
                disableDataCallInEmergencyCall(dialString);
                {
                    cm.dial(pendingMO.address, clirMode, obtainCompleteMessage());
                } 
                {
                    phone.exitEmergencyCallbackMode();
                    phone.setOnEcbModeExitResponse(this,EVENT_EXIT_ECM_RESPONSE_CDMA, null);
                    pendingCallClirMode=clirMode;
                    pendingCallInEcm=true;
                } 
            } 
        } 
        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
        varB4EAC82CA7396A68D541C85D26508E83_916055820 = pendingMO;
        Connection varA7E53CE21691AB073D9660D615818899_1434799289; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1434799289 = varB4EAC82CA7396A68D541C85D26508E83_882631443;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1434799289 = varB4EAC82CA7396A68D541C85D26508E83_916055820;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1434799289.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1434799289;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.294 -0400", hash_original_method = "916DB4F3BDDE26A491E1178653223CEE", hash_generated_method = "68CA528F9C634AFC8B9D26F0F3BFBCBF")
     Connection dial(String dialString) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_199221767 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_199221767 = dial(dialString, CommandsInterface.CLIR_DEFAULT);
        addTaint(dialString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_199221767.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_199221767;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.295 -0400", hash_original_method = "88840CD76FEAD0D0B90DCB96EA4A4A27", hash_generated_method = "A308B71CEC2DA4B098F4816A6EF2232F")
    private Connection dialThreeWay(String dialString) {
        Connection varB4EAC82CA7396A68D541C85D26508E83_1657870816 = null; 
        Connection varB4EAC82CA7396A68D541C85D26508E83_1312454465 = null; 
        {
            boolean var88B3B730B5A85C1DC3D65F3B8BB9AFF3_1245756276 = (!foregroundCall.isIdle());
            {
                disableDataCallInEmergencyCall(dialString);
                pendingMO = new CdmaConnection(phone.getContext(),
                                dialString, this, foregroundCall);
                cm.sendCDMAFeatureCode(pendingMO.address,
                obtainMessage(EVENT_THREE_WAY_DIAL_L2_RESULT_CDMA));
                varB4EAC82CA7396A68D541C85D26508E83_1657870816 = pendingMO;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1312454465 = null;
        Connection varA7E53CE21691AB073D9660D615818899_884349702; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_884349702 = varB4EAC82CA7396A68D541C85D26508E83_1657870816;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_884349702 = varB4EAC82CA7396A68D541C85D26508E83_1312454465;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_884349702.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_884349702;
        
        
            
            
                                
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.295 -0400", hash_original_method = "A15B8A9C3B79A061845560CDFB3D1962", hash_generated_method = "021D9B09CC834A475AFD86FDD98E7688")
     void acceptCall() throws CallStateException {
        {
            boolean varC632C7B3E7E960D500E2F5ADC8B810C7_1594854991 = (ringingCall.getState() == CdmaCall.State.INCOMING);
            {
                setMute(false);
                cm.acceptCall(obtainCompleteMessage());
            } 
            {
                boolean var6ABDCF912133D1B5B5A8B213BEB61799_1800716191 = (ringingCall.getState() == CdmaCall.State.WAITING);
                {
                    CdmaConnection cwConn = (CdmaConnection)(ringingCall.getLatestConnection());
                    cwConn.updateParent(ringingCall, foregroundCall);
                    cwConn.onConnectedInOrOut();
                    updatePhoneState();
                    switchWaitingOrHoldingAndActive();
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new CallStateException("phone not ringing");
                } 
            } 
        } 
        
        
            
            
            
        
            
            
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.296 -0400", hash_original_method = "9B02E01190499DD77CD223AD7831C55B", hash_generated_method = "BC83E4AF14337C2A38F0006803162F6F")
     void rejectCall() throws CallStateException {
        {
            boolean var2DE25B4C7BD786874002695E4305AD0A_440452761 = (ringingCall.getState().isRinging());
            {
                cm.rejectCall(obtainCompleteMessage());
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("phone not ringing");
            } 
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.297 -0400", hash_original_method = "4E2E600B83947FE548823E8A00BDC609", hash_generated_method = "644C50F3FB90482B7DDD23BA1CD965AB")
     void switchWaitingOrHoldingAndActive() throws CallStateException {
        {
            boolean varC632C7B3E7E960D500E2F5ADC8B810C7_947796228 = (ringingCall.getState() == CdmaCall.State.INCOMING);
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("cannot be in the incoming state");
            } 
            {
                boolean var648F610A170CD29A32E13B581B3027F2_1400250609 = (foregroundCall.getConnections().size() > 1);
                {
                    flashAndSetGenericTrue();
                } 
                {
                    cm.sendCDMAFeatureCode("", obtainMessage(EVENT_SWITCH_RESULT));
                } 
            } 
        } 
        
        
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.297 -0400", hash_original_method = "B1073FCDB805CE663445BC5D803D76AA", hash_generated_method = "90ECDE91CEB46AEDFA1995478C6494BA")
     void conference() throws CallStateException {
        flashAndSetGenericTrue();
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.297 -0400", hash_original_method = "B9B58214FE30DEB2D41379B25D88E6DD", hash_generated_method = "91DDF637F580C2F12D44ADB525F30440")
     void explicitCallTransfer() throws CallStateException {
        cm.explicitCallTransfer(obtainCompleteMessage(EVENT_ECT_RESULT));
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.298 -0400", hash_original_method = "89E1881B087BAA2C040FAFD444B532DA", hash_generated_method = "93C10D32BFEAACBDB937011534F3F686")
     void clearDisconnected() {
        internalClearDisconnected();
        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
        
        
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.298 -0400", hash_original_method = "885B69631C6ACC1E38924306F8EB7459", hash_generated_method = "146B17A4690E31284BC8358446EF8DB7")
     boolean canConference() {
        boolean varA1CCEEF4312D253306B2C816C3DB70CE_1503176204 = (foregroundCall.getState() == CdmaCall.State.ACTIVE
                && backgroundCall.getState() == CdmaCall.State.HOLDING
                && !backgroundCall.isFull()
                && !foregroundCall.isFull());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_733403270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_733403270;
        
        
                
                
                
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.298 -0400", hash_original_method = "DFFE89A6FC85DFAF69854FF09292A4CC", hash_generated_method = "4CA806D1BD29DBC6E87739679D200D60")
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
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_529290949 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_529290949;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.299 -0400", hash_original_method = "F828A2F1845194FFD82C471D7E89F726", hash_generated_method = "D5230E9F9607560D7EBAE9D483D436D9")
     boolean canTransfer() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_533226454 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_533226454;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.299 -0400", hash_original_method = "3058DCAC5E1117AE07A379578E7C6A20", hash_generated_method = "F0E9C736A8A4591368CEECFAB84F530D")
    private void internalClearDisconnected() {
        ringingCall.clearDisconnected();
        foregroundCall.clearDisconnected();
        backgroundCall.clearDisconnected();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.299 -0400", hash_original_method = "89F67FF5AFAE8FAD9F556239F3E27159", hash_generated_method = "EF8C12B3A35694A1BFD2444D4CEE739A")
    private Message obtainCompleteMessage() {
        Message varB4EAC82CA7396A68D541C85D26508E83_1838199843 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1838199843 = obtainCompleteMessage(EVENT_OPERATION_COMPLETE);
        varB4EAC82CA7396A68D541C85D26508E83_1838199843.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1838199843;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.299 -0400", hash_original_method = "F527C5C3DD4F0176588A0C261AD76B7A", hash_generated_method = "6CA5471F3961B490FCEDF50651478CF0")
    private Message obtainCompleteMessage(int what) {
        Message varB4EAC82CA7396A68D541C85D26508E83_140269195 = null; 
        lastRelevantPoll = null;
        needsPoll = true;
        log("obtainCompleteMessage: pendingOperations=" +
                pendingOperations + ", needsPoll=" + needsPoll);
        varB4EAC82CA7396A68D541C85D26508E83_140269195 = obtainMessage(what);
        addTaint(what);
        varB4EAC82CA7396A68D541C85D26508E83_140269195.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_140269195;
        
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.300 -0400", hash_original_method = "179E11A88A956D6661DD344814FD0D33", hash_generated_method = "21D885F66B272BE8E1EC799AD882A619")
    private void operationComplete() {
        log("operationComplete: pendingOperations=" +
                pendingOperations + ", needsPoll=" + needsPoll);
        {
            lastRelevantPoll = obtainMessage(EVENT_POLL_CALLS_RESULT);
            cm.getCurrentCalls(lastRelevantPoll);
        } 
        {
            pendingOperations = 0;
        } 
        
        
        
                
        
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.300 -0400", hash_original_method = "E4BBEB9CBA55B093A717754E6D30B945", hash_generated_method = "E91AEE989485AE07C941BE8B3921677F")
    private void updatePhoneState() {
        Phone.State oldState = state;
        {
            boolean varE4BD9FA258196C0B4AF6B5D416334169_1308437894 = (ringingCall.isRinging());
            {
                state = Phone.State.RINGING;
            } 
            {
                boolean var4C7AB8264C38A76EB062AB98EEF3EE82_782063738 = (pendingMO != null ||
                !(foregroundCall.isIdle() && backgroundCall.isIdle()));
                {
                    state = Phone.State.OFFHOOK;
                } 
                {
                    state = Phone.State.IDLE;
                } 
            } 
        } 
        {
            voiceCallEndedRegistrants.notifyRegistrants(
                new AsyncResult(null, null, null));
        } 
        {
            voiceCallStartedRegistrants.notifyRegistrants (
                    new AsyncResult(null, null, null));
        } 
        {
            log("update phone state, old=" + oldState + " new="+ state);
        } 
        {
            phone.notifyPhoneStateChanged();
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.303 -0400", hash_original_method = "63502DE56EE8A86B2DF78F720505C320", hash_generated_method = "C692BAFB76F26F079D4280DE17431F4B")
    protected void handlePollCalls(AsyncResult ar) {
        List polledCalls;
        {
            polledCalls = (List)ar.result;
        } 
        {
            boolean varC4DBE3EAF9ED931A30C22A297B6E685B_1733998458 = (isCommandExceptionRadioNotAvailable(ar.exception));
            {
                polledCalls = new ArrayList();
            } 
            {
                pollCallsAfterDelay();
            } 
        } 
        Connection newRinging = null;
        boolean hasNonHangupStateChanged = false;
        boolean needsPollDelay = false;
        boolean unknownConnectionAppeared = false;
        {
            int i = 0;
            int curDC = 0;
            int dcSize = polledCalls.size();
            {
                CdmaConnection conn = connections[i];
                DriverCall dc = null;
                {
                    dc = (DriverCall) polledCalls.get(curDC);
                    {
                        dc = null;
                    } 
                } 
                log("poll: conn[i=" + i + "]=" +
                    conn+", dc=" + dc);
                {
                    {
                        boolean varA12D38D4E3C5051B181541F930988B8A_1616778104 = (pendingMO != null && pendingMO.compareTo(dc));
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
                                } 
                                try 
                                {
                                    log(
                                    "poll: hangupPendingMO, hangup conn " + i);
                                    hangup(connections[i]);
                                } 
                                catch (CallStateException ex)
                                { }
                            } 
                        } 
                        {
                            {
                                log("pendingMo=" + pendingMO + ", dc=" + dc);
                            } 
                            newRinging = checkMtFindNewRinging(dc,i);
                            {
                                unknownConnectionAppeared = true;
                            } 
                            checkAndEnableDataCallAfterEmergencyCallDropped();
                        } 
                    } 
                    hasNonHangupStateChanged = true;
                } 
                {
                    int count = foregroundCall.connections.size();
                    {
                        int n = 0;
                        {
                            log("adding fgCall cn " + n + " to droppedDuringPoll");
                            CdmaConnection cn = (CdmaConnection)foregroundCall.connections.get(n);
                            droppedDuringPoll.add(cn);
                        } 
                    } 
                    count = ringingCall.connections.size();
                    {
                        int n = 0;
                        {
                            log("adding rgCall cn " + n + " to droppedDuringPoll");
                            CdmaConnection cn = (CdmaConnection)ringingCall.connections.get(n);
                            droppedDuringPoll.add(cn);
                        } 
                    } 
                    foregroundCall.setGeneric(false);
                    ringingCall.setGeneric(false);
                    {
                        handleEcmTimer(phone.RESTART_ECM_TIMER);
                    } 
                    checkAndEnableDataCallAfterEmergencyCallDropped();
                    connections[i] = null;
                } 
                {
                    {
                        {
                            droppedDuringPoll.add(conn);
                            newRinging = checkMtFindNewRinging(dc,i);
                            {
                                unknownConnectionAppeared = true;
                            } 
                            checkAndEnableDataCallAfterEmergencyCallDropped();
                        } 
                    } 
                    {
                        boolean changed;
                        changed = conn.update(dc);
                        hasNonHangupStateChanged = hasNonHangupStateChanged || changed;
                    } 
                } 
                {
                    {
                        {
                            needsPollDelay = true;
                        } 
                    } 
                } 
            } 
        } 
        {
            Log.d(LOG_TAG,"Pending MO dropped before poll fg state:"
                            + foregroundCall.getState());
            droppedDuringPoll.add(pendingMO);
            pendingMO = null;
            hangupPendingMO = false;
            {
                pendingCallInEcm = false;
            } 
        } 
        {
            phone.notifyNewRingingConnection(newRinging);
        } 
        {
            int i = droppedDuringPoll.size() - 1;
            {
                CdmaConnection conn = droppedDuringPoll.get(i);
                {
                    boolean var8064D1618E098621AFE888A1369217F2_761124967 = (conn.isIncoming() && conn.getConnectTime() == 0);
                    {
                        Connection.DisconnectCause cause;
                        {
                            cause = Connection.DisconnectCause.INCOMING_REJECTED;
                        } 
                        {
                            cause = Connection.DisconnectCause.INCOMING_MISSED;
                        } 
                        {
                            log("missed/rejected call, conn.cause=" + conn.cause);
                            log("setting cause to " + cause);
                        } 
                        droppedDuringPoll.remove(i);
                        conn.onDisconnect(cause);
                    } 
                    {
                        droppedDuringPoll.remove(i);
                        conn.onDisconnect(Connection.DisconnectCause.LOCAL);
                    } 
                    {
                        droppedDuringPoll.remove(i);
                        conn.onDisconnect(Connection.DisconnectCause.INVALID_NUMBER);
                    } 
                } 
            } 
        } 
        {
            boolean varA25616F2AD7C98E00F706161A5B687F7_1575006347 = (droppedDuringPoll.size() > 0);
            {
                cm.getLastCallFailCause(
                obtainNoPollCompleteMessage(EVENT_GET_LAST_CALL_FAIL_CAUSE));
            } 
        } 
        {
            pollCallsAfterDelay();
        } 
        {
            internalClearDisconnected();
        } 
        updatePhoneState();
        {
            phone.notifyUnknownConnection();
        } 
        {
            phone.notifyPreciseCallStateChanged();
        } 
        addTaint(ar.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.307 -0400", hash_original_method = "CA7F8E55CA885F7D7A3A262DD3D03608", hash_generated_method = "8D8FEDE533EFA98513B912F55875A470")
     void hangup(CdmaConnection conn) throws CallStateException {
        {
            boolean var7B293A7D3CB476B7EF41E01A5B6DD8B4_1644743250 = (conn.owner != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException ("CdmaConnection " + conn
                                    + "does not belong to CdmaCallTracker " + this);
            } 
        } 
        {
            log("hangup: set hangupPendingMO to true");
            hangupPendingMO = true;
        } 
        {
            boolean var7215D6E68D3558026AB7D731B4F5BDD0_314557483 = ((conn.getCall() == ringingCall)
                && (ringingCall.getState() == CdmaCall.State.WAITING));
            {
                conn.onLocalDisconnect();
                updatePhoneState();
                phone.notifyPreciseCallStateChanged();
            } 
            {
                try 
                {
                    cm.hangupConnection (conn.getCDMAIndex(), obtainCompleteMessage());
                } 
                catch (CallStateException ex)
                { }
            } 
        } 
        conn.onHangupLocal();
        addTaint(conn.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.308 -0400", hash_original_method = "B6040BEA0CD88965F5BB741ECCA6B877", hash_generated_method = "EDA07D694FF7AE287B74D5B98248162C")
     void separate(CdmaConnection conn) throws CallStateException {
        {
            boolean var7B293A7D3CB476B7EF41E01A5B6DD8B4_194537685 = (conn.owner != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException ("CdmaConnection " + conn
                                    + "does not belong to CdmaCallTracker " + this);
            } 
        } 
        try 
        {
            cm.separateConnection (conn.getCDMAIndex(),
                obtainCompleteMessage(EVENT_SEPARATE_RESULT));
        } 
        catch (CallStateException ex)
        { }
        addTaint(conn.getTaint());
        
        
            
                                    
        
        
            
                
        
            
                          
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.309 -0400", hash_original_method = "8E7DA06B8727FE7EBCD155EA09819106", hash_generated_method = "09D97CBFA339BB68260AAF45EF5FD946")
     void setMute(boolean mute) {
        desiredMute = mute;
        cm.setMute(desiredMute, null);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.310 -0400", hash_original_method = "11907D6A9C6D8F23B8C0FECA1425D0D1", hash_generated_method = "0785A021BD75FFD6A841E76B8682ADB7")
     boolean getMute() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_388691073 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_388691073;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.311 -0400", hash_original_method = "E9438EE2A649600B881089247D36F1D3", hash_generated_method = "A175568380FBF4210F3A56D014A0D79F")
     void hangup(CdmaCall call) throws CallStateException {
        {
            boolean varE4A326D5F85A22F10F9645DF8E94C259_1541821121 = (call.getConnections().size() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("no connections in call");
            } 
        } 
        {
            log("(ringing) hangup waiting or background");
            cm.hangupWaitingOrBackground(obtainCompleteMessage());
        } 
        {
            {
                boolean var22C48955666B247FCD89E865FCE21904_91749699 = (call.isDialingOrAlerting());
                {
                    {
                        log("(foregnd) hangup dialing or alerting...");
                    } 
                    hangup((CdmaConnection)(call.getConnections().get(0)));
                } 
                {
                    hangupForegroundResumeBackground();
                } 
            } 
        } 
        {
            {
                boolean varA4A4A8F760ECA28FD2366D22B56B66BD_1808222541 = (ringingCall.isRinging());
                {
                    {
                        log("hangup all conns in background call");
                    } 
                    hangupAllConnections(call);
                } 
                {
                    hangupWaitingOrBackground();
                } 
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("CdmaCall " + call +
                    "does not belong to CdmaCallTracker " + this);
        } 
        call.onHangupLocal();
        phone.notifyPreciseCallStateChanged();
        addTaint(call.getTaint());
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.314 -0400", hash_original_method = "E840FBD61F8E6AF3DE802E32C39DD93E", hash_generated_method = "4AF2AF2C1AF283F2B3D66EB92EFBBE89")
     void hangupWaitingOrBackground() {
        log("hangupWaitingOrBackground");
        cm.hangupWaitingOrBackground(obtainCompleteMessage());
        
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.317 -0400", hash_original_method = "D10B26113142441F52E905015040129F", hash_generated_method = "939D43994EC933107D2D3D9C50AF847D")
     void hangupForegroundResumeBackground() {
        log("hangupForegroundResumeBackground");
        cm.hangupForegroundResumeBackground(obtainCompleteMessage());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.320 -0400", hash_original_method = "46F42EF7B8FEEB9638F3768D6C678D5F", hash_generated_method = "58A800A70134D08F7C2CF9E54A126AA3")
     void hangupConnectionByIndex(CdmaCall call, int index) throws CallStateException {
        int count = call.connections.size();
        {
            int i = 0;
            {
                CdmaConnection cn = (CdmaConnection)call.connections.get(i);
                {
                    boolean varD4890B27B1518CF37532B19255789636_832112178 = (cn.getCDMAIndex() == index);
                    {
                        cm.hangupConnection(index, obtainCompleteMessage());
                    } 
                } 
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw new CallStateException("no gsm index found");
        addTaint(call.getTaint());
        addTaint(index);
        
        
        
            
            
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.321 -0400", hash_original_method = "C8ED8584ACDA74B40EBCC108129D9E6B", hash_generated_method = "6E99574A0949FE45E51BB8C84F383315")
     void hangupAllConnections(CdmaCall call) throws CallStateException {
        try 
        {
            int count = call.connections.size();
            {
                int i = 0;
                {
                    CdmaConnection cn = (CdmaConnection)call.connections.get(i);
                    cm.hangupConnection(cn.getCDMAIndex(), obtainCompleteMessage());
                } 
            } 
        } 
        catch (CallStateException ex)
        { }
        addTaint(call.getTaint());
        
        
            
            
                
                
            
        
            
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.325 -0400", hash_original_method = "DA3BA6D275DE18892F45915EBAE08DC8", hash_generated_method = "ED3C0BA1D7E424CC9153B8E0926AAA0B")
     CdmaConnection getConnectionByIndex(CdmaCall call, int index) throws CallStateException {
        CdmaConnection varB4EAC82CA7396A68D541C85D26508E83_524800197 = null; 
        CdmaConnection varB4EAC82CA7396A68D541C85D26508E83_72812418 = null; 
        int count = call.connections.size();
        {
            int i = 0;
            {
                CdmaConnection cn = (CdmaConnection)call.connections.get(i);
                {
                    boolean varD4890B27B1518CF37532B19255789636_617960706 = (cn.getCDMAIndex() == index);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_524800197 = cn;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_72812418 = null;
        addTaint(call.getTaint());
        addTaint(index);
        CdmaConnection varA7E53CE21691AB073D9660D615818899_1862069405; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1862069405 = varB4EAC82CA7396A68D541C85D26508E83_524800197;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1862069405 = varB4EAC82CA7396A68D541C85D26508E83_72812418;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1862069405.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1862069405;
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.327 -0400", hash_original_method = "EB39E7AA8B070FEFE523D7C5104C422F", hash_generated_method = "F2B22B9C2961AD4C91E3828C52AE1EE4")
    private void flashAndSetGenericTrue() throws CallStateException {
        cm.sendCDMAFeatureCode("", obtainMessage(EVENT_SWITCH_RESULT));
        foregroundCall.setGeneric(true);
        phone.notifyPreciseCallStateChanged();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.336 -0400", hash_original_method = "65CD53B5AAA831AF61B9937ED3D66C8B", hash_generated_method = "550BEF38F261823B8BC2F14DD181DC92")
    private Phone.SuppService getFailedService(int what) {
        Phone.SuppService varB4EAC82CA7396A68D541C85D26508E83_2070204624 = null; 
        Phone.SuppService varB4EAC82CA7396A68D541C85D26508E83_1174842236 = null; 
        Phone.SuppService varB4EAC82CA7396A68D541C85D26508E83_1513103218 = null; 
        Phone.SuppService varB4EAC82CA7396A68D541C85D26508E83_796072577 = null; 
        Phone.SuppService varB4EAC82CA7396A68D541C85D26508E83_897161131 = null; 
        
        varB4EAC82CA7396A68D541C85D26508E83_2070204624 = Phone.SuppService.SWITCH;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1174842236 = Phone.SuppService.CONFERENCE;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1513103218 = Phone.SuppService.SEPARATE;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_796072577 = Phone.SuppService.TRANSFER;
        
        varB4EAC82CA7396A68D541C85D26508E83_897161131 = Phone.SuppService.UNKNOWN;
        addTaint(what);
        Phone.SuppService varA7E53CE21691AB073D9660D615818899_898914801; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_898914801 = varB4EAC82CA7396A68D541C85D26508E83_2070204624;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_898914801 = varB4EAC82CA7396A68D541C85D26508E83_1174842236;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_898914801 = varB4EAC82CA7396A68D541C85D26508E83_1513103218;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_898914801 = varB4EAC82CA7396A68D541C85D26508E83_796072577;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_898914801 = varB4EAC82CA7396A68D541C85D26508E83_897161131;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_898914801.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_898914801;
        
        
            
                
            
                
            
                
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.340 -0400", hash_original_method = "6E2D3B844106C3BA4166C29F96BB7EA0", hash_generated_method = "3D35CA8E198B65065816E56AAB25BAB7")
    private void handleRadioNotAvailable() {
        pollCallsWhenSafe();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.343 -0400", hash_original_method = "8A157B3E162ABAFDC3219E193FD9AF9E", hash_generated_method = "934C88622A150E066610041A3B8D15C7")
    private void notifyCallWaitingInfo(CdmaCallWaitingNotification obj) {
        {
            callWaitingRegistrants.notifyRegistrants(new AsyncResult(null, obj, null));
        } 
        addTaint(obj.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.344 -0400", hash_original_method = "8AEB0E73C414AF95EF44C542FCF55311", hash_generated_method = "01DA11FE0FDC08A142C27A7F70C404B5")
    private void handleCallWaitingInfo(CdmaCallWaitingNotification cw) {
        {
            boolean varF80A25201569015423B9C49F57AE8341_48833761 = (foregroundCall.connections.size() > 1);
            {
                foregroundCall.setGeneric(true);
            } 
        } 
        ringingCall.setGeneric(false);
        new CdmaConnection(phone.getContext(), cw, this, ringingCall);
        updatePhoneState();
        notifyCallWaitingInfo(cw);
        addTaint(cw.getTaint());
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.346 -0400", hash_original_method = "D1EB700FB6D9FD1E2DF39441FB36A7DD", hash_generated_method = "6C3568C96B395EFBB1AD51D10648CB51")
    public void handleMessage(Message msg) {
        AsyncResult ar;
        
        {
            Log.d(LOG_TAG, "Event EVENT_POLL_CALLS_RESULT Received");
            ar = (AsyncResult)msg.obj;
            {
                log(
                            "handle EVENT_POLL_CALL_RESULT: set needsPoll=F");
                needsPoll = false;
                lastRelevantPoll = null;
                handlePollCalls((AsyncResult)msg.obj);
            } 
        } 
        
        
        operationComplete();
        
        
        int causeCode;
        
        
        ar = (AsyncResult)msg.obj;
        
        
        operationComplete();
        
        
        {
            causeCode = CallFailCause.NORMAL_CLEARING;
        } 
        {
            causeCode = ((int[])ar.result)[0];
        } 
        
        
        {
            int i = 0;
            int s = droppedDuringPoll.size();
            {
                CdmaConnection conn = droppedDuringPoll.get(i);
                conn.onRemoteDisconnect(causeCode);
            } 
        } 
        
        
        updatePhoneState();
        
        
        phone.notifyPreciseCallStateChanged();
        
        
        droppedDuringPoll.clear();
        
        
        pollCallsWhenSafe();
        
        
        handleRadioAvailable();
        
        
        handleRadioNotAvailable();
        
        
        {
            cm.dial(pendingMO.address, pendingCallClirMode, obtainCompleteMessage());
            pendingCallInEcm = false;
        } 
        
        
        phone.unsetOnEcbModeExitResponse(this);
        
        
        ar = (AsyncResult)msg.obj;
        
        
        {
            handleCallWaitingInfo((CdmaCallWaitingNotification)ar.result);
            Log.d(LOG_TAG, "Event EVENT_CALL_WAITING_INFO_CDMA Received");
        } 
        
        
        ar = (AsyncResult)msg.obj;
        
        
        {
            pendingMO.onConnectedInOrOut();
            pendingMO = null;
        } 
        
        
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("unexpected event not handled");
        } 
        
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.349 -0400", hash_original_method = "53D0BC70C94C51E4941A4869C727C1EF", hash_generated_method = "AB928354D921018BDB8E7CC54AA63F30")
    private void handleEcmTimer(int action) {
        phone.handleTimerInEmergencyCallbackMode(action);
        
        mIsEcmTimerCanceled = true;
        
        
        mIsEcmTimerCanceled = false;
        
        addTaint(action);
        
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.351 -0400", hash_original_method = "E45025BA49DB75441FB058D043F13559", hash_generated_method = "BE3F732B6A86B057C6CD9C31DCBA3A81")
    private void disableDataCallInEmergencyCall(String dialString) {
        {
            boolean var325FA9D4EF820F6526AF47F3B166DBE6_1704965177 = (PhoneNumberUtils.isLocalEmergencyNumber(dialString, phone.getContext()));
            {
                log("disableDataCallInEmergencyCall");
                mIsInEmergencyCall = true;
                phone.mDataConnectionTracker.setInternalDataEnabled(false);
            } 
        } 
        addTaint(dialString.getTaint());
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.352 -0400", hash_original_method = "4B192230440137F94B49778D22CB7CD2", hash_generated_method = "6355145AB0AE9747F1CE27BA73586A3E")
    private void checkAndEnableDataCallAfterEmergencyCallDropped() {
        {
            mIsInEmergencyCall = false;
            String inEcm = SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
            {
                log("checkAndEnableDataCallAfterEmergencyCallDropped,inEcm=" + inEcm);
            } 
            {
                boolean varF1938E19DDB5D7D21BFFF4FE8AA8EABF_37831720 = (inEcm.compareTo("false") == 0);
                {
                    phone.mDataConnectionTracker.setInternalDataEnabled(true);
                } 
            } 
        } 
        
        
            
            
            
                
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.354 -0400", hash_original_method = "D359964B058F5C9ECC2D15DB024983EF", hash_generated_method = "EED684B3AF6E00C2C4BC67A5294440A1")
    private Connection checkMtFindNewRinging(DriverCall dc, int i) {
        Connection varB4EAC82CA7396A68D541C85D26508E83_827030684 = null; 
        Connection newRinging = null;
        connections[i] = new CdmaConnection(phone.getContext(), dc, this, i);
        {
            boolean var77F010D23417E833441F8B3A6431ABA1_2042501770 = (connections[i].getCall() == ringingCall);
            {
                newRinging = connections[i];
                log("Notify new ring " + dc);
            } 
            {
                {
                    connections[i].connectTime = System.currentTimeMillis();
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_827030684 = newRinging;
        varB4EAC82CA7396A68D541C85D26508E83_827030684.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_827030684;
        
        
        
        
            
            
        
            
            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.355 -0400", hash_original_method = "1842D0C2283B311B2A29E474687D9235", hash_generated_method = "256D7CB90EC79DC0D1D3A3701B9F75EA")
     boolean isInEmergencyCall() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1047868665 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1047868665;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.356 -0400", hash_original_method = "FF708F6402A7A18425D7FC72639DE93E", hash_generated_method = "F0C8DCFB659F32D7C1DB873DA97A6356")
    protected void log(String msg) {
        Log.d(LOG_TAG, "[CdmaCallTracker] " + msg);
        addTaint(msg.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.356 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.357 -0400", hash_original_field = "CC792B139E86B59BF5644A291C349001", hash_generated_field = "A7B75AEFB3EF53E7FDD36572121557CF")

    private static final boolean REPEAT_POLLING = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.357 -0400", hash_original_field = "BA76C0C87FE0928477EB48E458A4151B", hash_generated_field = "5105F543721DFE6C6FC4422BBF3A00CF")

    private static final boolean DBG_POLL = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.357 -0400", hash_original_field = "5D8CCE6E8CAE49F3DAE5020BF6731533", hash_generated_field = "3D5BB3B6A3F2D8A508B231AB505DE10A")

    static final int MAX_CONNECTIONS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.357 -0400", hash_original_field = "109C1DEC6EE2198ED540651FC4E6F2F6", hash_generated_field = "50E5124FACE9F1EADB0A251AF8BCB55D")

    static final int MAX_CONNECTIONS_PER_CALL = 1;
}

