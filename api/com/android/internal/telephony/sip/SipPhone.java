package com.android.internal.telephony.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;
import java.util.List;
import java.util.regex.Pattern;

import android.content.Context;
import android.media.AudioManager;
import android.net.rtp.AudioGroup;
import android.net.sip.SipAudioCall;
import android.net.sip.SipErrorCode;
import android.net.sip.SipException;
import android.net.sip.SipManager;
import android.net.sip.SipProfile;
import android.net.sip.SipSession;
import android.os.AsyncResult;
import android.os.Message;
import android.telephony.PhoneNumberUtils;
import android.telephony.ServiceState;
import android.text.TextUtils;
import android.util.Log;

import com.android.internal.telephony.Call;
import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneNotifier;

public class SipPhone extends SipPhoneBase {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.514 -0500", hash_original_method = "0DB04D989DB8A0D8D42E47E87513600C", hash_generated_method = "E289371A5283105F701FC3DB40500131")
    
private static Call.State getCallStateFrom(SipAudioCall sipAudioCall) {
        if (sipAudioCall.isOnHold()) return Call.State.HOLDING;
        int sessionState = sipAudioCall.getState();
        switch (sessionState) {
            case SipSession.State.READY_TO_CALL:            return Call.State.IDLE;
            case SipSession.State.INCOMING_CALL:
            case SipSession.State.INCOMING_CALL_ANSWERING:  return Call.State.INCOMING;
            case SipSession.State.OUTGOING_CALL:            return Call.State.DIALING;
            case SipSession.State.OUTGOING_CALL_RING_BACK:  return Call.State.ALERTING;
            case SipSession.State.OUTGOING_CALL_CANCELING:  return Call.State.DISCONNECTING;
            case SipSession.State.IN_CALL:                  return Call.State.ACTIVE;
            default:
                Log.w(LOG_TAG, "illegal connection state: " + sessionState);
                return Call.State.DISCONNECTED;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.248 -0500", hash_original_field = "A4494B158A8DFAE7DB1E7482E9D0EFF9", hash_generated_field = "7A17420CA7320CD6991D9BB201E6C8AD")

    private static final String LOG_TAG = "SipPhone";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.251 -0500", hash_original_field = "9C97D618612CFF386E7AF19655372855", hash_generated_field = "0DA17BC1AEF6DBF011A4A750F5A71D57")

    private static final boolean DEBUG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.254 -0500", hash_original_field = "F16304FD0BB7F4835824F6B17B7DBF5A", hash_generated_field = "EB405364424B606CEA103C767EA0ADA3")

    private static final int TIMEOUT_MAKE_CALL = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.256 -0500", hash_original_field = "CEED7B588CDC8C80E78A5752611F6F97", hash_generated_field = "973EB4EC28EADF6B6F1C1FDB9D5440C9")

    private static final int TIMEOUT_ANSWER_CALL = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.259 -0500", hash_original_field = "1DE376D7917EB5D6102CF987AE7402BC", hash_generated_field = "2FA826CBF5F1C3318478B665E6C65585")

    private static final int TIMEOUT_HOLD_CALL = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.261 -0500", hash_original_field = "7B797512F31164FA4DE203E15564C5F1", hash_generated_field = "39007EC66C104E82818FD4633C4E3BC5")

    // A call that is ringing or (call) waiting
    private SipCall ringingCall = new SipCall();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.263 -0500", hash_original_field = "26316B8D5D3F5EF783BF1C740AA5A7CD", hash_generated_field = "320FA68B59E86E885480BDC328D988A1")

    private SipCall foregroundCall = new SipCall();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.266 -0500", hash_original_field = "7527896753F879B02BBAD29684D00E88", hash_generated_field = "E67497BDFFD17E2A0DB124112854785A")

    private SipCall backgroundCall = new SipCall();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.268 -0500", hash_original_field = "4E20C8C51E3C0F6E0559CD6629AF54B8", hash_generated_field = "E80E46E58FFD30634B7E3BE2973B3395")

    private SipManager mSipManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.270 -0500", hash_original_field = "722BF7ED2C06388ADB438E216144A8A4", hash_generated_field = "7EAF540B0EC7BBB66B1BAC42709185BB")

    private SipProfile mProfile;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.273 -0500", hash_original_method = "6A0F0B835E49D28418FC90D67BF66C10", hash_generated_method = "6A0F0B835E49D28418FC90D67BF66C10")
    
SipPhone (Context context, PhoneNotifier notifier, SipProfile profile) {
        super(context, notifier);

        if (DEBUG) Log.d(LOG_TAG, "new SipPhone: " + profile.getUriString());
        ringingCall = new SipCall();
        foregroundCall = new SipCall();
        backgroundCall = new SipCall();
        mProfile = profile;
        mSipManager = SipManager.newInstance(context);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.276 -0500", hash_original_method = "0022E344F588A86EC51D8DF12CB4CABD", hash_generated_method = "CB5BB21E6B2D536B2839DB62B7013C7D")
    
@Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof SipPhone)) return false;
        SipPhone that = (SipPhone) o;
        return mProfile.getUriString().equals(that.mProfile.getUriString());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.279 -0500", hash_original_method = "87B6F28FD5B3DEC2F08CA48119477808", hash_generated_method = "EB1BECFCE806AC75CD1E703D6B169E78")
    
public String getPhoneName() {
        return "SIP:" + getUriString(mProfile);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.281 -0500", hash_original_method = "AD1E8A0332F840602A7373ACA5D5D1A0", hash_generated_method = "35D0D62D3FD01BFB49322E12E6001BF2")
    
public String getSipUri() {
        return mProfile.getUriString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.283 -0500", hash_original_method = "D3C5F9763476A8D0E8037A369F8C496C", hash_generated_method = "5F4569D3DF7F76DD854FA19338CCE4F7")
    
public boolean equals(SipPhone phone) {
        return getSipUri().equals(phone.getSipUri());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.286 -0500", hash_original_method = "520B082FC4D55C78B63B25D36AD6E406", hash_generated_method = "D78A7F58FF4B5F2CABF86F6A96B88178")
    
public boolean canTake(Object incomingCall) {
        synchronized (SipPhone.class) {
            if (!(incomingCall instanceof SipAudioCall)) return false;
            if (ringingCall.getState().isAlive()) return false;

            // FIXME: is it true that we cannot take any incoming call if
            // both foreground and background are active
            if (foregroundCall.getState().isAlive()
                    && backgroundCall.getState().isAlive()) {
                return false;
            }

            try {
                SipAudioCall sipAudioCall = (SipAudioCall) incomingCall;
                if (DEBUG) Log.d(LOG_TAG, "+++ taking call from: "
                        + sipAudioCall.getPeerProfile().getUriString());
                String localUri = sipAudioCall.getLocalProfile().getUriString();
                if (localUri.equals(mProfile.getUriString())) {
                    boolean makeCallWait = foregroundCall.getState().isAlive();
                    ringingCall.initIncomingCall(sipAudioCall, makeCallWait);
                    if (sipAudioCall.getState()
                            != SipSession.State.INCOMING_CALL) {
                        // Peer cancelled the call!
                        if (DEBUG) Log.d(LOG_TAG, "    call cancelled !!");
                        ringingCall.reset();
                    }
                    return true;
                }
            } catch (Exception e) {
                // Peer may cancel the call at any time during the time we hook
                // up ringingCall with sipAudioCall. Clean up ringingCall when
                // that happens.
                ringingCall.reset();
            }
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.288 -0500", hash_original_method = "4D3FC14BD1B17CB217053014BC4D74B6", hash_generated_method = "DD2D2BC4291CA1D4ABC3FD9AE4EED905")
    
public void acceptCall() throws CallStateException {
        synchronized (SipPhone.class) {
            if ((ringingCall.getState() == Call.State.INCOMING) ||
                    (ringingCall.getState() == Call.State.WAITING)) {
                if (DEBUG) Log.d(LOG_TAG, "acceptCall");
                // Always unmute when answering a new call
                ringingCall.setMute(false);
                ringingCall.acceptCall();
            } else {
                throw new CallStateException("phone not ringing");
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.291 -0500", hash_original_method = "F60D4B1A0C339762A597DB11EC122CEA", hash_generated_method = "8D82386EDCE5F18B4524471948A1820C")
    
public void rejectCall() throws CallStateException {
        synchronized (SipPhone.class) {
            if (ringingCall.getState().isRinging()) {
                if (DEBUG) Log.d(LOG_TAG, "rejectCall");
                ringingCall.rejectCall();
            } else {
                throw new CallStateException("phone not ringing");
            }
        }
    }

    @DSSink({DSSinkKind.VOIP})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.293 -0500", hash_original_method = "01C657A55270F6B259EE4CA2295CF206", hash_generated_method = "FA32FA1AE5696C5FE1894B7E6482448D")
    
public Connection dial(String dialString) throws CallStateException {
        synchronized (SipPhone.class) {
            return dialInternal(dialString);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.296 -0500", hash_original_method = "E69019A31CF45F3F0FFB8952555ADD38", hash_generated_method = "E65C26A805F1C7116FB7B1CF1811FACE")
    
private Connection dialInternal(String dialString)
            throws CallStateException {
        clearDisconnected();

        if (!canDial()) {
            throw new CallStateException("cannot dial in current state");
        }
        if (foregroundCall.getState() == SipCall.State.ACTIVE) {
            switchHoldingAndActive();
        }
        if (foregroundCall.getState() != SipCall.State.IDLE) {
            //we should have failed in !canDial() above before we get here
            throw new CallStateException("cannot dial in current state");
        }

        foregroundCall.setMute(false);
        try {
            Connection c = foregroundCall.dial(dialString);
            return c;
        } catch (SipException e) {
            Log.e(LOG_TAG, "dial()", e);
            throw new CallStateException("dial error: " + e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.298 -0500", hash_original_method = "04453A8FBCEE87A03C8D7EC224934C23", hash_generated_method = "4AA7F4AF132E96CD3EDACD6383830120")
    
public void switchHoldingAndActive() throws CallStateException {
        if (DEBUG) Log.d(LOG_TAG, " ~~~~~~  switch fg and bg");
        synchronized (SipPhone.class) {
            foregroundCall.switchWith(backgroundCall);
            if (backgroundCall.getState().isAlive()) backgroundCall.hold();
            if (foregroundCall.getState().isAlive()) foregroundCall.unhold();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.301 -0500", hash_original_method = "EF99002349D3FD6EFA7BC51A1FE3E619", hash_generated_method = "9ABE129A8149A3F4C1B6ED89B5BF6E82")
    
public boolean canConference() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.303 -0500", hash_original_method = "5DC11CA56E4A18B2CAABC2999FA181D0", hash_generated_method = "CD8CB738A668C2BC19965F28A7707C7D")
    
public void conference() throws CallStateException {
        synchronized (SipPhone.class) {
            if ((foregroundCall.getState() != SipCall.State.ACTIVE)
                    || (foregroundCall.getState() != SipCall.State.ACTIVE)) {
                throw new CallStateException("wrong state to merge calls: fg="
                        + foregroundCall.getState() + ", bg="
                        + backgroundCall.getState());
            }
            foregroundCall.merge(backgroundCall);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.306 -0500", hash_original_method = "0BA61BE71F93F0627212F9F9B5CF61C9", hash_generated_method = "311D411D52F01198406E2A5F0BDA25D4")
    
public void conference(Call that) throws CallStateException {
        synchronized (SipPhone.class) {
            if (!(that instanceof SipCall)) {
                throw new CallStateException("expect " + SipCall.class
                        + ", cannot merge with " + that.getClass());
            }
            foregroundCall.merge((SipCall) that);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.309 -0500", hash_original_method = "FB85D9DE1C816CCA93C5FDAD3D9D0A31", hash_generated_method = "EA02045786C579926E9CDBE0DBD400A0")
    
public boolean canTransfer() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.311 -0500", hash_original_method = "6F3E620B44779BFD9D290EDD6A721C13", hash_generated_method = "E1E3C466E63369C7BCA55C401983DB99")
    
public void explicitCallTransfer() throws CallStateException {
        //mCT.explicitCallTransfer();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.313 -0500", hash_original_method = "D9CD8A34486E399CFA818246637B2970", hash_generated_method = "61134104979C4BC16E6837BE3F9025F7")
    
public void clearDisconnected() {
        synchronized (SipPhone.class) {
            ringingCall.clearDisconnected();
            foregroundCall.clearDisconnected();
            backgroundCall.clearDisconnected();

            updatePhoneState();
            notifyPreciseCallStateChanged();
        }
    }

    @DSSink({DSSinkKind.PHONE_CONNECTION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.316 -0500", hash_original_method = "D682F8DE86633D8037AE8DB7A99E0997", hash_generated_method = "71E579D230ECBDFF5EA1BDA265FE754F")
    
public void sendDtmf(char c) {
        if (!PhoneNumberUtils.is12Key(c)) {
            Log.e(LOG_TAG,
                    "sendDtmf called with invalid character '" + c + "'");
        } else if (foregroundCall.getState().isAlive()) {
            synchronized (SipPhone.class) {
                foregroundCall.sendDtmf(c);
            }
        }
    }

    @DSSink({DSSinkKind.PHONE_CONNECTION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.318 -0500", hash_original_method = "C805BAC519448AC91DEA3466C2A972EF", hash_generated_method = "3E8F3639ECB30CC2093F655E611D9E91")
    
public void startDtmf(char c) {
        if (!PhoneNumberUtils.is12Key(c)) {
            Log.e(LOG_TAG,
                "startDtmf called with invalid character '" + c + "'");
        } else {
            sendDtmf(c);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.320 -0500", hash_original_method = "1D5D5FD426DB2358E4E86A174C44532E", hash_generated_method = "1612D5E3E75CF3F024A4DEB9F2FC49F1")
    
public void stopDtmf() {
        // no op
    }

    @DSSink({DSSinkKind.PHONE_CONNECTION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.322 -0500", hash_original_method = "9189F1384120EC6E17589215617F3507", hash_generated_method = "770AB5477E5F0392E2ED8097C9DDC91B")
    
public void sendBurstDtmf(String dtmfString) {
        Log.e(LOG_TAG, "[SipPhone] sendBurstDtmf() is a CDMA method");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.325 -0500", hash_original_method = "0D09CB6308056457AD1772B2CC5B82FC", hash_generated_method = "2E69485E2850A2291928908360932232")
    
public void getOutgoingCallerIdDisplay(Message onComplete) {
        // FIXME: what to reply?
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.327 -0500", hash_original_method = "56612EF91DCB9A3808F62E57BF0F81E1", hash_generated_method = "7AFD122FA2BC9CD6164587737EE63933")
    
public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode,
                                           Message onComplete) {
        // FIXME: what's this for SIP?
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.329 -0500", hash_original_method = "14E36FB03F40D4635F36E46C38B086BD", hash_generated_method = "960EFB71F628E591F47FB4BDBB797CF5")
    
public void getCallWaiting(Message onComplete) {
        // FIXME: what to reply?
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.332 -0500", hash_original_method = "80F9B6F2C3F4CA6200C97C4377273E17", hash_generated_method = "4631119FE18EC577B1297D9E9EBAC877")
    
public void setCallWaiting(boolean enable, Message onComplete) {
        // FIXME: what to reply?
        Log.e(LOG_TAG, "call waiting not supported");
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.334 -0500", hash_original_method = "6F81D9304F797B487FC34D43FAF41E44", hash_generated_method = "38DE648A23798D93856C2EC37C37C1D0")
    
@Override
    public void setEchoSuppressionEnabled(boolean enabled) {
        // TODO: Remove the enabled argument. We should check the speakerphone
        // state with AudioManager instead of keeping a state here so the
        // method with a state argument is redundant. Also rename the method
        // to something like onSpeaerphoneStateChanged(). Echo suppression may
        // not be available on every device.
        synchronized (SipPhone.class) {
            foregroundCall.setAudioGroupMode();
        }
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.336 -0500", hash_original_method = "79AC444E8066EFF34D5F76D19E8CCACC", hash_generated_method = "E234D4A8EADDF41EC687CC06045722EC")
    
public void setMute(boolean muted) {
        synchronized (SipPhone.class) {
            foregroundCall.setMute(muted);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.338 -0500", hash_original_method = "8292EC8FC0222DDB10381F21089BC299", hash_generated_method = "8783E8468DEAEB83A3503561FDDA447D")
    
public boolean getMute() {
        return (foregroundCall.getState().isAlive()
                ? foregroundCall.getMute()
                : backgroundCall.getMute());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.341 -0500", hash_original_method = "9DE1B547D23B96DA44E5E5850535D15C", hash_generated_method = "DA89C20EB11E24E643339FDFF963F2BD")
    
public Call getForegroundCall() {
        return foregroundCall;
    }
    
    private class SipCall extends SipCallBase {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.303 -0400", hash_original_method = "00F055312A0CF21C4F0B5574B16ECF8F", hash_generated_method = "00F055312A0CF21C4F0B5574B16ECF8F")
        public SipCall ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.355 -0500", hash_original_method = "077C3D2ABFDDE04A697972D273B811AD", hash_generated_method = "077C3D2ABFDDE04A697972D273B811AD")
        
void reset() {
            connections.clear();
            setState(Call.State.IDLE);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.358 -0500", hash_original_method = "375D19E8671ADDF3312252661F52306D", hash_generated_method = "375D19E8671ADDF3312252661F52306D")
        
void switchWith(SipCall that) {
            synchronized (SipPhone.class) {
                SipCall tmp = new SipCall();
                tmp.takeOver(this);
                this.takeOver(that);
                that.takeOver(tmp);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.360 -0500", hash_original_method = "1E912254ED378DFE25D6B6FABA0CA461", hash_generated_method = "B41B30BBC1C36EA1222B1A8722D18D58")
        
private void takeOver(SipCall that) {
            connections = that.connections;
            state = that.state;
            for (Connection c : connections) {
                ((SipConnection) c).changeOwner(this);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.364 -0500", hash_original_method = "BB25C6B7E2DC41EA59445495652EDD92", hash_generated_method = "4800A8462B39091F2314050683152083")
        
@Override
        public Phone getPhone() {
            return SipPhone.this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.366 -0500", hash_original_method = "B38C364E01AF490301B03DAE11EB1509", hash_generated_method = "6886A44E5534151CE831B17E8F916AC8")
        
@Override
        public List<Connection> getConnections() {
            synchronized (SipPhone.class) {
                // FIXME should return Collections.unmodifiableList();
                return connections;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.369 -0500", hash_original_method = "B9E3A4EF80D99D71D1AE567F3438F945", hash_generated_method = "B9E3A4EF80D99D71D1AE567F3438F945")
        
Connection dial(String originalNumber) throws SipException {
            String calleeSipUri = originalNumber;
            if (!calleeSipUri.contains("@")) {
                String replaceStr = Pattern.quote(mProfile.getUserName() + "@");
                calleeSipUri = mProfile.getUriString().replaceFirst(replaceStr,
                        calleeSipUri + "@");
            }
            try {
                SipProfile callee =
                        new SipProfile.Builder(calleeSipUri).build();
                SipConnection c = new SipConnection(this, callee,
                        originalNumber);
                c.dial();
                connections.add(c);
                setState(Call.State.DIALING);
                return c;
            } catch (ParseException e) {
                throw new SipException("dial", e);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.372 -0500", hash_original_method = "F3785C840BD99E8D755659453D00493E", hash_generated_method = "3A9DFC761A931CCDEE5BFD6EC076091B")
        
@Override
        public void hangup() throws CallStateException {
            synchronized (SipPhone.class) {
                if (state.isAlive()) {
                    if (DEBUG) Log.d(LOG_TAG, "hang up call: " + getState()
                            + ": " + this + " on phone " + getPhone());
                    setState(State.DISCONNECTING);
                    CallStateException excp = null;
                    for (Connection c : connections) {
                        try {
                            c.hangup();
                        } catch (CallStateException e) {
                            excp = e;
                        }
                    }
                    if (excp != null) throw excp;
                } else {
                    if (DEBUG) Log.d(LOG_TAG, "hang up dead call: " + getState()
                            + ": " + this + " on phone " + getPhone());
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.374 -0500", hash_original_method = "03E5A9484BF2B2B8056B6450938A40D7", hash_generated_method = "03E5A9484BF2B2B8056B6450938A40D7")
        
void initIncomingCall(SipAudioCall sipAudioCall, boolean makeCallWait) {
            SipProfile callee = sipAudioCall.getPeerProfile();
            SipConnection c = new SipConnection(this, callee);
            connections.add(c);

            Call.State newState = makeCallWait ? State.WAITING : State.INCOMING;
            c.initIncomingCall(sipAudioCall, newState);

            setState(newState);
            notifyNewRingingConnectionP(c);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.376 -0500", hash_original_method = "F8072C3AD3C86AEC184FDD0C13B73AA0", hash_generated_method = "F8072C3AD3C86AEC184FDD0C13B73AA0")
        
void rejectCall() throws CallStateException {
            hangup();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.378 -0500", hash_original_method = "B2C3B5FE3154049893EC854E60F79D8F", hash_generated_method = "B2C3B5FE3154049893EC854E60F79D8F")
        
void acceptCall() throws CallStateException {
            if (this != ringingCall) {
                throw new CallStateException("acceptCall() in a non-ringing call");
            }
            if (connections.size() != 1) {
                throw new CallStateException("acceptCall() in a conf call");
            }
            ((SipConnection) connections.get(0)).acceptCall();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.381 -0500", hash_original_method = "1B6C9A8A7DE7A949D0CD2E188D6FBBDC", hash_generated_method = "7CE9BD647031F8943EB0E2073490FFA1")
        
private boolean isSpeakerOn() {
            return ((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                    .isSpeakerphoneOn();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.383 -0500", hash_original_method = "AEEC2C5B8263135991756BF729F3B501", hash_generated_method = "AEEC2C5B8263135991756BF729F3B501")
        
void setAudioGroupMode() {
            AudioGroup audioGroup = getAudioGroup();
            if (audioGroup == null) return;
            int mode = audioGroup.getMode();
            if (state == State.HOLDING) {
                audioGroup.setMode(AudioGroup.MODE_ON_HOLD);
            } else if (getMute()) {
                audioGroup.setMode(AudioGroup.MODE_MUTED);
            } else if (isSpeakerOn()) {
                audioGroup.setMode(AudioGroup.MODE_ECHO_SUPPRESSION);
            } else {
                audioGroup.setMode(AudioGroup.MODE_NORMAL);
            }
            if (DEBUG) Log.d(LOG_TAG, String.format(
                    "audioGroup mode change: %d --> %d", mode,
                    audioGroup.getMode()));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.386 -0500", hash_original_method = "A3EB25D5FFDA71466ECC0EEF32C97EE3", hash_generated_method = "A3EB25D5FFDA71466ECC0EEF32C97EE3")
        
void hold() throws CallStateException {
            setState(State.HOLDING);
            for (Connection c : connections) ((SipConnection) c).hold();
            setAudioGroupMode();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.388 -0500", hash_original_method = "9A7CCBA25036980309C5282A2982C0B2", hash_generated_method = "9A7CCBA25036980309C5282A2982C0B2")
        
void unhold() throws CallStateException {
            setState(State.ACTIVE);
            AudioGroup audioGroup = new AudioGroup();
            for (Connection c : connections) {
                ((SipConnection) c).unhold(audioGroup);
            }
            setAudioGroupMode();
        }

        @DSSink({DSSinkKind.SYSTEM_SETTINGS})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.391 -0500", hash_original_method = "7DDE83D6F9C645A60E86EBEFB92BE589", hash_generated_method = "7DDE83D6F9C645A60E86EBEFB92BE589")
        
void setMute(boolean muted) {
            for (Connection c : connections) {
                ((SipConnection) c).setMute(muted);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.393 -0500", hash_original_method = "B414CA4B3846B73054EF059A06E7BBBE", hash_generated_method = "B414CA4B3846B73054EF059A06E7BBBE")
        
boolean getMute() {
            return connections.isEmpty()
                    ? false
                    : ((SipConnection) connections.get(0)).getMute();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.395 -0500", hash_original_method = "C6685F4BB929C317D55EF29FDD744317", hash_generated_method = "20689562728233B97445620CFC3658B1")
        
void merge(SipCall that) throws CallStateException {
            AudioGroup audioGroup = getAudioGroup();

            // copy to an array to avoid concurrent modification as connections
            // in that.connections will be removed in add(SipConnection).
            Connection[] cc = that.connections.toArray(
                    new Connection[that.connections.size()]);
            for (Connection c : cc) {
                SipConnection conn = (SipConnection) c;
                add(conn);
                if (conn.getState() == Call.State.HOLDING) {
                    conn.unhold(audioGroup);
                }
            }
            that.setState(Call.State.IDLE);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.398 -0500", hash_original_method = "C804E92B54898C48FBC0803D66022DE0", hash_generated_method = "0B92BF74E2AC2744B24F104BCD509E74")
        
private void add(SipConnection conn) {
            SipCall call = conn.getCall();
            if (call == this) return;
            if (call != null) call.connections.remove(conn);

            connections.add(conn);
            conn.changeOwner(this);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.400 -0500", hash_original_method = "994C45B8BD8978A705E69F1BE351A00B", hash_generated_method = "994C45B8BD8978A705E69F1BE351A00B")
        
void sendDtmf(char c) {
            AudioGroup audioGroup = getAudioGroup();
            if (audioGroup == null) return;
            audioGroup.sendDtmf(convertDtmf(c));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.404 -0500", hash_original_method = "C4229E0DAB0B84D6720429F368FEF1C3", hash_generated_method = "482E416984DA12BF956FCC8650406A9C")
        
private int convertDtmf(char c) {
            int code = c - '0';
            if ((code < 0) || (code > 9)) {
                switch (c) {
                    case '*': return 10;
                    case '#': return 11;
                    case 'A': return 12;
                    case 'B': return 13;
                    case 'C': return 14;
                    case 'D': return 15;
                    default:
                        throw new IllegalArgumentException(
                                "invalid DTMF char: " + (int) c);
                }
            }
            return code;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.406 -0500", hash_original_method = "A20E6ED570A38BE2669CFE3ED9219E0D", hash_generated_method = "20109966897A4E95F9DB1D63E5DA2977")
        
@Override
        protected void setState(State newState) {
            if (state != newState) {
                if (DEBUG) Log.v(LOG_TAG, "+***+ call state changed: " + state
                        + " --> " + newState + ": " + this + ": on phone "
                        + getPhone() + " " + connections.size());

                if (newState == Call.State.ALERTING) {
                    state = newState; // need in ALERTING to enable ringback
                    SipPhone.this.startRingbackTone();
                } else if (state == Call.State.ALERTING) {
                    SipPhone.this.stopRingbackTone();
                }
                state = newState;
                updatePhoneState();
                notifyPreciseCallStateChanged();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.409 -0500", hash_original_method = "9B48819375B09AF6C57EC0D05234CB41", hash_generated_method = "BE6109CA1E4BDB65895200C643FBE4B1")
        
void onConnectionStateChanged(SipConnection conn) {
            // this can be called back when a conf call is formed
            if (state != State.ACTIVE) {
                setState(conn.getState());
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.411 -0500", hash_original_method = "67A791C264A58046C696AC400E0B1106", hash_generated_method = "D7CEDC5504DD1A2FC15DDFB97A2A2E82")
        
void onConnectionEnded(SipConnection conn) {
            // set state to DISCONNECTED only when all conns are disconnected
            if (state != State.DISCONNECTED) {
                boolean allConnectionsDisconnected = true;
                if (DEBUG) Log.d(LOG_TAG, "---check connections: "
                        + connections.size());
                for (Connection c : connections) {
                    if (DEBUG) Log.d(LOG_TAG, "   state=" + c.getState() + ": "
                            + c);
                    if (c.getState() != State.DISCONNECTED) {
                        allConnectionsDisconnected = false;
                        break;
                    }
                }
                if (allConnectionsDisconnected) setState(State.DISCONNECTED);
            }
            notifyDisconnectP(conn);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.414 -0500", hash_original_method = "3BDED5D4E6618481393AD33B1F728E6A", hash_generated_method = "E71AFDEF4C462B3F0B44E4C834866B3A")
        
private AudioGroup getAudioGroup() {
            if (connections.isEmpty()) return null;
            return ((SipConnection) connections.get(0)).getAudioGroup();
        }
        
    }
    
    private class SipConnection extends SipConnectionBase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.420 -0500", hash_original_field = "401A0DD1C8C53C72FFABFCEEE4434BF7", hash_generated_field = "D7165953848BB574FCA583AB16464D4F")

        private SipCall mOwner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.423 -0500", hash_original_field = "2344A847B81308841F673AA2C93047DC", hash_generated_field = "D1359B5A0587476130FC171DA764AC68")

        private SipAudioCall mSipAudioCall;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.425 -0500", hash_original_field = "E21E85E6E71F71501C3A5F85C0994E10", hash_generated_field = "DFC050C51766232BD82C770760A2DF3D")

        private Call.State mState = Call.State.IDLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.427 -0500", hash_original_field = "E533D3F3D649AADBC31700FAB7C1E39F", hash_generated_field = "06F960DE9AD1B3C2161E1D3DDDEEE930")

        private SipProfile mPeer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.430 -0500", hash_original_field = "D8071D2C08069AF0C8224B282F7B7E83", hash_generated_field = "EC5248A9D1818320AA647E3B388AFC57")

        private String mOriginalNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.433 -0500", hash_original_field = "C777672FBFA0099E3EA9AF4660C21357", hash_generated_field = "CEABB36F0D8DD49AB2FFAD188EF64025")

        private boolean mIncoming = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.299 -0400", hash_original_field = "AC67C5E32EF946C45E856E56B7F86834", hash_generated_field = "244547A11EB2D0F43D69ADE82125A7FA")

        private SipAudioCallAdapter mAdapter = new SipAudioCallAdapter() {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.295 -0400", hash_original_method = "B8BAADEA0DE266294E2369B45E53A7F4", hash_generated_method = "44D1590CD550569A3F447EA35B336364")
            @Override
            protected void onCallEnded(DisconnectCause cause) {
                
                {
                    boolean var3317223ED0C152EA0F03D574707E1DAC_1172811185 = (getDisconnectCause() != DisconnectCause.LOCAL);
                    {
                        setDisconnectCause(cause);
                    } 
                } 
                {
                    setState(Call.State.DISCONNECTED);
                    SipAudioCall sipAudioCall = mSipAudioCall;
                    mSipAudioCall = null;
                    String sessionState;
                    sessionState = "";
                    sessionState = (sipAudioCall.getState() + ", ");
                    Log.d(LOG_TAG, "--- connection ended: "
                            + mPeer.getUriString() + ": " + sessionState
                            + "cause: " + getDisconnectCause() + ", on phone "
                            + getPhone());
                    {
                        sipAudioCall.setListener(null);
                        sipAudioCall.close();
                    } 
                    mOwner.onConnectionEnded(SipConnection.this);
                } 
                addTaint(cause.getTaint());
                
            }
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.295 -0400", hash_original_method = "52733E1CC76DBF11A64B0250C617E7AC", hash_generated_method = "F34A5EF95CCC3389960527B60C4F7AE9")
            @Override
            public void onCallEstablished(SipAudioCall call) {
                
                onChanged(call);
                call.startAudio();
                addTaint(call.getTaint());
                
            }
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.296 -0400", hash_original_method = "AC053A33592EEF445C9BE357836B4C16", hash_generated_method = "A5F097A8319E3CB02B505B72B427FB45")
            @Override
            public void onCallHeld(SipAudioCall call) {
                
                onChanged(call);
                call.startAudio();
                addTaint(call.getTaint());
                
            }
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.298 -0400", hash_original_method = "9E9163C05D7336A6FE9DFAB379443860", hash_generated_method = "819342FBC5A8298A2BD476438672EE18")
            @Override
            public void onChanged(SipAudioCall call) {
                
                {
                    Call.State newState = getCallStateFrom(call);
                    {
                        setState(mOwner.getState());
                    } 
                    {
                        {
                            {
                                boolean varD8866BE17E7C5DE27AE1021BF41F371D_921518053 = (ringingCall.getState() == Call.State.WAITING);
                                {
                                    try 
                                    {
                                        switchHoldingAndActive();
                                    } 
                                    catch (CallStateException e)
                                    {
                                        onCallEnded(DisconnectCause.LOCAL);
                                    } 
                                } 
                            } 
                            foregroundCall.switchWith(ringingCall);
                        } 
                        setState(newState);
                    } 
                    mOwner.onConnectionStateChanged(SipConnection.this);
                } 
                addTaint(call.getTaint());
                
            }
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.299 -0400", hash_original_method = "C52D3E5DC20D7F0420DDF7517152D94F", hash_generated_method = "22119F567079DA28DBBFC4AA0120E473")
            @Override
            protected void onError(DisconnectCause cause) {
                
                Log.d(LOG_TAG, "SIP error: " + cause);
                onCallEnded(cause);
                addTaint(cause.getTaint());
                
            }
            
};

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.456 -0500", hash_original_method = "EB041B636E30FA2F3190616100DC4B14", hash_generated_method = "59BDCC54105D73C7BD670F58B10AE3A1")
        
public SipConnection(SipCall owner, SipProfile callee,
                String originalNumber) {
            super(originalNumber);
            mOwner = owner;
            mPeer = callee;
            mOriginalNumber = originalNumber;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.459 -0500", hash_original_method = "0957F2328B233DD414C835AB48AD0504", hash_generated_method = "C5A9A4E0ECA7B5B024B4C118D68BAF12")
        
public SipConnection(SipCall owner, SipProfile callee) {
            this(owner, callee, getUriString(callee));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.461 -0500", hash_original_method = "57E4C10F499E8E36FDDCF5DF3794947E", hash_generated_method = "E630DD13B22D26F108FC88EA99E6BD0F")
        
@Override
        public String getCnapName() {
            String displayName = mPeer.getDisplayName();
            return TextUtils.isEmpty(displayName) ? null
                                                  : displayName;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.464 -0500", hash_original_method = "6B6F8D6F29C0FEAF9C52CC30010D6FE2", hash_generated_method = "D026768E436A13D9AA73255E630C5233")
        
@Override
        public int getNumberPresentation() {
            return Connection.PRESENTATION_ALLOWED;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.466 -0500", hash_original_method = "14BDBA500BD81C7014F8447F04B9333E", hash_generated_method = "436B67AC1F0DBE2B5AD91CE6C6517C86")
        
void initIncomingCall(SipAudioCall sipAudioCall, Call.State newState) {
            setState(newState);
            mSipAudioCall = sipAudioCall;
            sipAudioCall.setListener(mAdapter); // call back to set state
            mIncoming = true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.468 -0500", hash_original_method = "62A265BABD2EF644B89898FE1DF3E037", hash_generated_method = "62A265BABD2EF644B89898FE1DF3E037")
        
void acceptCall() throws CallStateException {
            try {
                mSipAudioCall.answerCall(TIMEOUT_ANSWER_CALL);
            } catch (SipException e) {
                throw new CallStateException("acceptCall(): " + e);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.470 -0500", hash_original_method = "5D5AACCF3178F43A37FA6476F3FA2309", hash_generated_method = "5D5AACCF3178F43A37FA6476F3FA2309")
        
void changeOwner(SipCall owner) {
            mOwner = owner;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.472 -0500", hash_original_method = "81195A6CBC9B38EAFBB5618CD4E171CB", hash_generated_method = "81195A6CBC9B38EAFBB5618CD4E171CB")
        
AudioGroup getAudioGroup() {
            if (mSipAudioCall == null) return null;
            return mSipAudioCall.getAudioGroup();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.475 -0500", hash_original_method = "766A0FDDBD2B3A4E947C7E8FBAB0F165", hash_generated_method = "766A0FDDBD2B3A4E947C7E8FBAB0F165")
        
void dial() throws SipException {
            setState(Call.State.DIALING);
            mSipAudioCall = mSipManager.makeAudioCall(mProfile, mPeer, null,
                    TIMEOUT_MAKE_CALL);
            mSipAudioCall.setListener(mAdapter);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.478 -0500", hash_original_method = "DDAA74ADB7976F32813665FE128238CD", hash_generated_method = "DDAA74ADB7976F32813665FE128238CD")
        
void hold() throws CallStateException {
            setState(Call.State.HOLDING);
            try {
                mSipAudioCall.holdCall(TIMEOUT_HOLD_CALL);
            } catch (SipException e) {
                throw new CallStateException("hold(): " + e);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.480 -0500", hash_original_method = "F77273A2CD584255814B6B238AF1477E", hash_generated_method = "F77273A2CD584255814B6B238AF1477E")
        
void unhold(AudioGroup audioGroup) throws CallStateException {
            mSipAudioCall.setAudioGroup(audioGroup);
            setState(Call.State.ACTIVE);
            try {
                mSipAudioCall.continueCall(TIMEOUT_HOLD_CALL);
            } catch (SipException e) {
                throw new CallStateException("unhold(): " + e);
            }
        }

        @DSSink({DSSinkKind.SYSTEM_SETTINGS})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.483 -0500", hash_original_method = "91B9A79444A0C09E86ABE6F5C7C89706", hash_generated_method = "91B9A79444A0C09E86ABE6F5C7C89706")
        
void setMute(boolean muted) {
            if ((mSipAudioCall != null) && (muted != mSipAudioCall.isMuted())) {
                mSipAudioCall.toggleMute();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.486 -0500", hash_original_method = "E20C6A660C2E35A5253ACCD901B5D855", hash_generated_method = "E20C6A660C2E35A5253ACCD901B5D855")
        
boolean getMute() {
            return (mSipAudioCall == null) ? false
                                           : mSipAudioCall.isMuted();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.488 -0500", hash_original_method = "1833AE90ADB0C663418065E2EE17BAF0", hash_generated_method = "C4BB41D3FFBD9053C9CD6518F8810982")
        
@Override
        protected void setState(Call.State state) {
            if (state == mState) return;
            super.setState(state);
            mState = state;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.491 -0500", hash_original_method = "0D6E90F055C537B49BE3263741E0D2AC", hash_generated_method = "32D6655516EB2361915CA2482EE8D73C")
        
@Override
        public Call.State getState() {
            return mState;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.493 -0500", hash_original_method = "0C9900F417D1D38623450F6C44261C8A", hash_generated_method = "C1D44166F56D721C698EDD5BE6743AEA")
        
@Override
        public boolean isIncoming() {
            return mIncoming;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.496 -0500", hash_original_method = "FE0C81270397910192F7BF8C9CDDDAB6", hash_generated_method = "8E73A5B153876129B8518AC7D7A7942D")
        
@Override
        public String getAddress() {
            // Phone app uses this to query caller ID. Return the original dial
            // number (which may be a PSTN number) instead of the peer's SIP
            // URI.
            return mOriginalNumber;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.498 -0500", hash_original_method = "710C86DFEBE06A4514867B4563DB846F", hash_generated_method = "3EF10E59AC0160FDB6CBB85FF1F4F598")
        
@Override
        public SipCall getCall() {
            return mOwner;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.501 -0500", hash_original_method = "925322092199D63FE2A7CC7A8AD6AC9C", hash_generated_method = "697082C4F61B5FB7236C4BF9545391EB")
        
@Override
        protected Phone getPhone() {
            return mOwner.getPhone();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.504 -0500", hash_original_method = "B35A599F4014F0A4981FF871F70F4B98", hash_generated_method = "FD050E9BA53B9E44407E7DD414608088")
        
@Override
        public void hangup() throws CallStateException {
            synchronized (SipPhone.class) {
                if (DEBUG) Log.d(LOG_TAG, "hangup conn: " + mPeer.getUriString()
                        + ": " + mState + ": on phone "
                        + getPhone().getPhoneName());
                if (!mState.isAlive()) return;
                try {
                    SipAudioCall sipAudioCall = mSipAudioCall;
                    if (sipAudioCall != null) {
                        sipAudioCall.setListener(null);
                        sipAudioCall.endCall();
                    }
                } catch (SipException e) {
                    throw new CallStateException("hangup(): " + e);
                } finally {
                    mAdapter.onCallEnded(((mState == Call.State.INCOMING)
                            || (mState == Call.State.WAITING))
                            ? DisconnectCause.INCOMING_REJECTED
                            : DisconnectCause.LOCAL);
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.507 -0500", hash_original_method = "7B400982296D21B9968B9808849E5473", hash_generated_method = "71F5A3B27B21E3BFE8CA55D2A49E99D2")
        
@Override
        public void separate() throws CallStateException {
            synchronized (SipPhone.class) {
                SipCall call = (getPhone() == SipPhone.this)
                        ? (SipCall) SipPhone.this.getBackgroundCall()
                        : (SipCall) SipPhone.this.getForegroundCall();
                if (call.getState() != Call.State.IDLE) {
                    throw new CallStateException(
                            "cannot put conn back to a call in non-idle state: "
                            + call.getState());
                }
                if (DEBUG) Log.d(LOG_TAG, "separate conn: "
                        + mPeer.getUriString() + " from " + mOwner + " back to "
                        + call);

                // separate the AudioGroup and connection from the original call
                Phone originalPhone = getPhone();
                AudioGroup audioGroup = call.getAudioGroup(); // may be null
                call.add(this);
                mSipAudioCall.setAudioGroup(audioGroup);

                // put the original call to bg; and the separated call becomes
                // fg if it was in bg
                originalPhone.switchHoldingAndActive();

                // start audio and notify the phone app of the state change
                call = (SipCall) SipPhone.this.getForegroundCall();
                mSipAudioCall.startAudio();
                call.onConnectionStateChanged(this);
            }
        }
        
    }
    
    private abstract class SipAudioCallAdapter extends SipAudioCall.Listener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.316 -0400", hash_original_method = "3AB54838416D4A721CFBD2C180A6FF7A", hash_generated_method = "3AB54838416D4A721CFBD2C180A6FF7A")
        public SipAudioCallAdapter ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.517 -0500", hash_original_method = "6DB2782AEE356F3E870B5C073A0DC3F1", hash_generated_method = "181D9C85EBE44B42E0C314C0DFBD59CE")
        
protected abstract void onCallEnded(Connection.DisconnectCause cause);
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.520 -0500", hash_original_method = "AAA8B40816A52C167686551FC0FF9145", hash_generated_method = "1931B7B73CB6EC4AE564133F5D572FC8")
        
protected abstract void onError(Connection.DisconnectCause cause);

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.524 -0500", hash_original_method = "FAC45A8F53047AFBBF88628CAD98E6D5", hash_generated_method = "EE3FA9AC1F828E3D761D0366729EA3DA")
        
@Override
        public void onCallEnded(SipAudioCall call) {
            onCallEnded(call.isInCall()
                    ? Connection.DisconnectCause.NORMAL
                    : Connection.DisconnectCause.INCOMING_MISSED);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.526 -0500", hash_original_method = "5FEE35421FE68DCB9D837EF94FC0CC79", hash_generated_method = "5ACEA95169D6BAAE5A88507BC148670B")
        
@Override
        public void onCallBusy(SipAudioCall call) {
            onCallEnded(Connection.DisconnectCause.BUSY);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.530 -0500", hash_original_method = "7EFF641046EACBCFF45AD18624210100", hash_generated_method = "F9351D95E323BAA522E53522C47F8FDF")
        
@Override
        public void onError(SipAudioCall call, int errorCode,
                String errorMessage) {
            switch (errorCode) {
                case SipErrorCode.SERVER_UNREACHABLE:
                    onError(Connection.DisconnectCause.SERVER_UNREACHABLE);
                    break;
                case SipErrorCode.PEER_NOT_REACHABLE:
                    onError(Connection.DisconnectCause.NUMBER_UNREACHABLE);
                    break;
                case SipErrorCode.INVALID_REMOTE_URI:
                    onError(Connection.DisconnectCause.INVALID_NUMBER);
                    break;
                case SipErrorCode.TIME_OUT:
                case SipErrorCode.TRANSACTION_TERMINTED:
                    onError(Connection.DisconnectCause.TIMED_OUT);
                    break;
                case SipErrorCode.DATA_CONNECTION_LOST:
                    onError(Connection.DisconnectCause.LOST_SIGNAL);
                    break;
                case SipErrorCode.INVALID_CREDENTIALS:
                    onError(Connection.DisconnectCause.INVALID_CREDENTIALS);
                    break;
                case SipErrorCode.CROSS_DOMAIN_AUTHENTICATION:
                    onError(Connection.DisconnectCause.OUT_OF_NETWORK);
                    break;
                case SipErrorCode.SERVER_ERROR:
                    onError(Connection.DisconnectCause.SERVER_ERROR);
                    break;
                case SipErrorCode.SOCKET_ERROR:
                case SipErrorCode.CLIENT_ERROR:
                default:
                    Log.w(LOG_TAG, "error: " + SipErrorCode.toString(errorCode)
                            + ": " + errorMessage);
                    onError(Connection.DisconnectCause.ERROR_UNSPECIFIED);
            }
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.343 -0500", hash_original_method = "EADE59B65D242AA2A5BCB126522780FD", hash_generated_method = "B62D2405146B4C7A3CE1330ED4C88554")
    
public Call getBackgroundCall() {
        return backgroundCall;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.345 -0500", hash_original_method = "3A1E9C8D795C10065E3EA9FCAA0EB60D", hash_generated_method = "8EFB037BD8F1CA936FC8C7B33540AB8E")
    
public Call getRingingCall() {
        return ringingCall;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.348 -0500", hash_original_method = "88DBA8231EA7F3BE9C495A0C37514173", hash_generated_method = "2BA133B1067BEAD5EF644C370A3BFF91")
    
public ServiceState getServiceState() {
        // FIXME: we may need to provide this when data connectivity is lost
        // or when server is down
        return super.getServiceState();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.350 -0500", hash_original_method = "AE09BA0335289F025B1DDE67D4558A7A", hash_generated_method = "A3FEAC57B455D046BB3F8CE1FB92FBEE")
    
private String getUriString(SipProfile p) {
        // SipProfile.getUriString() may contain "SIP:" and port
        return p.getUserName() + "@" + getSipDomain(p);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:25.353 -0500", hash_original_method = "CF1C8708B65050BDE73A571BB1592129", hash_generated_method = "AB88EB49425040A81BE888418D0FA3F6")
    
private String getSipDomain(SipProfile p) {
        String domain = p.getSipDomain();
        // TODO: move this to SipProfile
        if (domain.endsWith(":5060")) {
            return domain.substring(0, domain.length() - 5);
        } else {
            return domain;
        }
    }
}

