package com.android.internal.telephony.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import java.text.ParseException;
import java.util.List;
import java.util.regex.Pattern;

public class SipPhone extends SipPhoneBase {
    private SipCall ringingCall = new SipCall();
    private SipCall foregroundCall = new SipCall();
    private SipCall backgroundCall = new SipCall();
    private SipManager mSipManager;
    private SipProfile mProfile;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.267 -0400", hash_original_method = "6A0F0B835E49D28418FC90D67BF66C10", hash_generated_method = "2AE8F1FFE6DE5A5BF5EDC30E574DB198")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SipPhone(Context context, PhoneNotifier notifier, SipProfile profile) {
        super(context, notifier);
        dsTaint.addTaint(notifier.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(profile.dsTaint);
        Log.d(LOG_TAG, "new SipPhone: " + profile.getUriString());
        ringingCall = new SipCall();
        foregroundCall = new SipCall();
        backgroundCall = new SipCall();
        mSipManager = SipManager.newInstance(context);
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(LOG_TAG, "new SipPhone: " + profile.getUriString());
        //ringingCall = new SipCall();
        //foregroundCall = new SipCall();
        //backgroundCall = new SipCall();
        //mProfile = profile;
        //mSipManager = SipManager.newInstance(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.267 -0400", hash_original_method = "0022E344F588A86EC51D8DF12CB4CABD", hash_generated_method = "0C36E4BA261BAD54C76C5AA7571639E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_1707426298 = (o == this);
        } //End collapsed parenthetic
        SipPhone that;
        that = (SipPhone) o;
        boolean var45CE97710469451C578ABB40487B4EE8_1580063276 = (mProfile.getUriString().equals(that.mProfile.getUriString()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (!(o instanceof SipPhone)) return false;
        //SipPhone that = (SipPhone) o;
        //return mProfile.getUriString().equals(that.mProfile.getUriString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.268 -0400", hash_original_method = "87B6F28FD5B3DEC2F08CA48119477808", hash_generated_method = "5B510BE007BAB25B2F40F771CB4BC9E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPhoneName() {
        String var8C7EF0796A13E4CBF3CAAC060C40CB68_1910615934 = ("SIP:" + getUriString(mProfile));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "SIP:" + getUriString(mProfile);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.268 -0400", hash_original_method = "AD1E8A0332F840602A7373ACA5D5D1A0", hash_generated_method = "98AB1A54D3CE53CBD869FB1DED4DD16F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSipUri() {
        String var2A70BC160D0426F04D895659D471A43F_1807549046 = (mProfile.getUriString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mProfile.getUriString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.268 -0400", hash_original_method = "D3C5F9763476A8D0E8037A369F8C496C", hash_generated_method = "43F168A48E1EE4EB5FD043A9260A833B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(SipPhone phone) {
        dsTaint.addTaint(phone.dsTaint);
        boolean varB170C7409F6B913400034BFCA292A56F_128158214 = (getSipUri().equals(phone.getSipUri()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getSipUri().equals(phone.getSipUri());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.268 -0400", hash_original_method = "520B082FC4D55C78B63B25D36AD6E406", hash_generated_method = "6B037CA4492AA722C538004BA816DFF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canTake(Object incomingCall) {
        dsTaint.addTaint(incomingCall.dsTaint);
        {
            {
                boolean varE01C4545931A62F4FC941738A7A28D5F_962384320 = (ringingCall.getState().isAlive());
            } //End collapsed parenthetic
            {
                boolean var5F3F3054BBF953B9D43A6A67CF0D2F18_74586458 = (foregroundCall.getState().isAlive()
                    && backgroundCall.getState().isAlive());
            } //End collapsed parenthetic
            try 
            {
                SipAudioCall sipAudioCall;
                sipAudioCall = (SipAudioCall) incomingCall;
                Log.d(LOG_TAG, "+++ taking call from: "
                        + sipAudioCall.getPeerProfile().getUriString());
                String localUri;
                localUri = sipAudioCall.getLocalProfile().getUriString();
                {
                    boolean varAFFEC3E610279996536BBDBBD3DBA5A6_1263280834 = (localUri.equals(mProfile.getUriString()));
                    {
                        boolean makeCallWait;
                        makeCallWait = foregroundCall.getState().isAlive();
                        ringingCall.initIncomingCall(sipAudioCall, makeCallWait);
                        {
                            boolean var83E8B86F2BE04FBC6538BB9432DC8A6D_324061938 = (sipAudioCall.getState()
                            != SipSession.State.INCOMING_CALL);
                            {
                                Log.d(LOG_TAG, "    call cancelled !!");
                                ringingCall.reset();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (Exception e)
            {
                ringingCall.reset();
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.269 -0400", hash_original_method = "4D3FC14BD1B17CB217053014BC4D74B6", hash_generated_method = "66592E6B0D189895D940CFB3C1FF0184")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void acceptCall() throws CallStateException {
        {
            {
                boolean varE0C61107F4B1A5D76C43D42CFA8103F3_1585416749 = ((ringingCall.getState() == Call.State.INCOMING) ||
                    (ringingCall.getState() == Call.State.WAITING));
                {
                    Log.d(LOG_TAG, "acceptCall");
                    ringingCall.setMute(false);
                    ringingCall.acceptCall();
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new CallStateException("phone not ringing");
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (SipPhone.class) {
            //if ((ringingCall.getState() == Call.State.INCOMING) ||
                    //(ringingCall.getState() == Call.State.WAITING)) {
                //if (DEBUG) Log.d(LOG_TAG, "acceptCall");
                //ringingCall.setMute(false);
                //ringingCall.acceptCall();
            //} else {
                //throw new CallStateException("phone not ringing");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.269 -0400", hash_original_method = "F60D4B1A0C339762A597DB11EC122CEA", hash_generated_method = "4BB8A7E8E57128A9F5DFD7C02FDAC034")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void rejectCall() throws CallStateException {
        {
            {
                boolean var442D0F0D7EEA6963AE66B13292492B00_999106569 = (ringingCall.getState().isRinging());
                {
                    Log.d(LOG_TAG, "rejectCall");
                    ringingCall.rejectCall();
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new CallStateException("phone not ringing");
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (SipPhone.class) {
            //if (ringingCall.getState().isRinging()) {
                //if (DEBUG) Log.d(LOG_TAG, "rejectCall");
                //ringingCall.rejectCall();
            //} else {
                //throw new CallStateException("phone not ringing");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.269 -0400", hash_original_method = "01C657A55270F6B259EE4CA2295CF206", hash_generated_method = "0043880B9149BBF6C5751C390FB486D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Connection dial(String dialString) throws CallStateException {
        dsTaint.addTaint(dialString);
        {
            Connection var87FF1277636E22F4543AB89DB43FB1F6_294597797 = (dialInternal(dialString));
        } //End block
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (SipPhone.class) {
            //return dialInternal(dialString);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.270 -0400", hash_original_method = "E69019A31CF45F3F0FFB8952555ADD38", hash_generated_method = "514AFA3A47D70F0EC9E341D7B2C2DE8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Connection dialInternal(String dialString) throws CallStateException {
        dsTaint.addTaint(dialString);
        clearDisconnected();
        {
            boolean var37336DD64F87D8D8C5FEC219FB8725E9_2094003542 = (!canDial());
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("cannot dial in current state");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varC33489E5DEA37065C5D9027B98F53E39_177226810 = (foregroundCall.getState() == SipCall.State.ACTIVE);
            {
                switchHoldingAndActive();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAA5B136BDA3FB7DD22D11F146CB8E62A_748141418 = (foregroundCall.getState() != SipCall.State.IDLE);
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("cannot dial in current state");
            } //End block
        } //End collapsed parenthetic
        foregroundCall.setMute(false);
        try 
        {
            Connection c;
            c = foregroundCall.dial(dialString);
        } //End block
        catch (SipException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new CallStateException("dial error: " + e);
        } //End block
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //clearDisconnected();
        //if (!canDial()) {
            //throw new CallStateException("cannot dial in current state");
        //}
        //if (foregroundCall.getState() == SipCall.State.ACTIVE) {
            //switchHoldingAndActive();
        //}
        //if (foregroundCall.getState() != SipCall.State.IDLE) {
            //throw new CallStateException("cannot dial in current state");
        //}
        //foregroundCall.setMute(false);
        //try {
            //Connection c = foregroundCall.dial(dialString);
            //return c;
        //} catch (SipException e) {
            //Log.e(LOG_TAG, "dial()", e);
            //throw new CallStateException("dial error: " + e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.270 -0400", hash_original_method = "04453A8FBCEE87A03C8D7EC224934C23", hash_generated_method = "F8C077F66998C7C70695B84BBEF59357")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void switchHoldingAndActive() throws CallStateException {
        Log.d(LOG_TAG, " ~~~~~~  switch fg and bg");
        {
            foregroundCall.switchWith(backgroundCall);
            {
                boolean varA0AFA2B7E4A73D22BA12DB013063960D_654663154 = (backgroundCall.getState().isAlive());
                backgroundCall.hold();
            } //End collapsed parenthetic
            {
                boolean var63B388EA3D8161389B434AC6220A05EB_171379617 = (foregroundCall.getState().isAlive());
                foregroundCall.unhold();
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(LOG_TAG, " ~~~~~~  switch fg and bg");
        //synchronized (SipPhone.class) {
            //foregroundCall.switchWith(backgroundCall);
            //if (backgroundCall.getState().isAlive()) backgroundCall.hold();
            //if (foregroundCall.getState().isAlive()) foregroundCall.unhold();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.270 -0400", hash_original_method = "EF99002349D3FD6EFA7BC51A1FE3E619", hash_generated_method = "31A7B907049EAA0BE1F807AB1F45CB6E")
    @DSModeled(DSC.SAFE)
    public boolean canConference() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.270 -0400", hash_original_method = "5DC11CA56E4A18B2CAABC2999FA181D0", hash_generated_method = "865651B4D5987F6819ED388642F9B056")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void conference() throws CallStateException {
        {
            {
                boolean varA1285B741C70BDCFD1DA6690E8723FC5_648390605 = ((foregroundCall.getState() != SipCall.State.ACTIVE)
                    || (foregroundCall.getState() != SipCall.State.ACTIVE));
                {
                    if (DroidSafeAndroidRuntime.control) throw new CallStateException("wrong state to merge calls: fg="
                        + foregroundCall.getState() + ", bg="
                        + backgroundCall.getState());
                } //End block
            } //End collapsed parenthetic
            foregroundCall.merge(backgroundCall);
        } //End block
        // ---------- Original Method ----------
        //synchronized (SipPhone.class) {
            //if ((foregroundCall.getState() != SipCall.State.ACTIVE)
                    //|| (foregroundCall.getState() != SipCall.State.ACTIVE)) {
                //throw new CallStateException("wrong state to merge calls: fg="
                        //+ foregroundCall.getState() + ", bg="
                        //+ backgroundCall.getState());
            //}
            //foregroundCall.merge(backgroundCall);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.271 -0400", hash_original_method = "0BA61BE71F93F0627212F9F9B5CF61C9", hash_generated_method = "DAD71542B3DE8F70337D48B10D86BD43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void conference(Call that) throws CallStateException {
        dsTaint.addTaint(that.dsTaint);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("expect " + SipCall.class
                        + ", cannot merge with " + that.getClass());
            } //End block
            foregroundCall.merge((SipCall) that);
        } //End block
        // ---------- Original Method ----------
        //synchronized (SipPhone.class) {
            //if (!(that instanceof SipCall)) {
                //throw new CallStateException("expect " + SipCall.class
                        //+ ", cannot merge with " + that.getClass());
            //}
            //foregroundCall.merge((SipCall) that);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.271 -0400", hash_original_method = "FB85D9DE1C816CCA93C5FDAD3D9D0A31", hash_generated_method = "ED6B3FB8CABF3DC97330819B1EF40C69")
    @DSModeled(DSC.SAFE)
    public boolean canTransfer() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.271 -0400", hash_original_method = "6F3E620B44779BFD9D290EDD6A721C13", hash_generated_method = "1802EA65B8D1F27F1F2A77F464C12952")
    @DSModeled(DSC.SAFE)
    public void explicitCallTransfer() throws CallStateException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.271 -0400", hash_original_method = "D9CD8A34486E399CFA818246637B2970", hash_generated_method = "10069112F50F91D6CB32445A67763FB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearDisconnected() {
        {
            ringingCall.clearDisconnected();
            foregroundCall.clearDisconnected();
            backgroundCall.clearDisconnected();
            updatePhoneState();
            notifyPreciseCallStateChanged();
        } //End block
        // ---------- Original Method ----------
        //synchronized (SipPhone.class) {
            //ringingCall.clearDisconnected();
            //foregroundCall.clearDisconnected();
            //backgroundCall.clearDisconnected();
            //updatePhoneState();
            //notifyPreciseCallStateChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.272 -0400", hash_original_method = "D682F8DE86633D8037AE8DB7A99E0997", hash_generated_method = "88669E28A7CBA37BF42348010A83250F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendDtmf(char c) {
        dsTaint.addTaint(c);
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_1424621254 = (!PhoneNumberUtils.is12Key(c));
            {
                boolean var63B388EA3D8161389B434AC6220A05EB_116115902 = (foregroundCall.getState().isAlive());
                {
                    {
                        foregroundCall.sendDtmf(c);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!PhoneNumberUtils.is12Key(c)) {
            //Log.e(LOG_TAG,
                    //"sendDtmf called with invalid character '" + c + "'");
        //} else if (foregroundCall.getState().isAlive()) {
            //synchronized (SipPhone.class) {
                //foregroundCall.sendDtmf(c);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.272 -0400", hash_original_method = "C805BAC519448AC91DEA3466C2A972EF", hash_generated_method = "211955EB21EEF1D05348F639650886F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startDtmf(char c) {
        dsTaint.addTaint(c);
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_1398279995 = (!PhoneNumberUtils.is12Key(c));
            {
                sendDtmf(c);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!PhoneNumberUtils.is12Key(c)) {
            //Log.e(LOG_TAG,
                //"startDtmf called with invalid character '" + c + "'");
        //} else {
            //sendDtmf(c);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.272 -0400", hash_original_method = "1D5D5FD426DB2358E4E86A174C44532E", hash_generated_method = "28A2AD6EB5F0534AB0CED744A3051E3F")
    @DSModeled(DSC.SAFE)
    public void stopDtmf() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.272 -0400", hash_original_method = "9189F1384120EC6E17589215617F3507", hash_generated_method = "078FA0E7F3569F4F04B27882C1812BCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendBurstDtmf(String dtmfString) {
        dsTaint.addTaint(dtmfString);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SipPhone] sendBurstDtmf() is a CDMA method");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.272 -0400", hash_original_method = "0D09CB6308056457AD1772B2CC5B82FC", hash_generated_method = "49C3C316E17691685BD0BB52ED3BE560")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.273 -0400", hash_original_method = "56612EF91DCB9A3808F62E57BF0F81E1", hash_generated_method = "772B57AF907EBFB55627FCD4E496D351")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode,
                                           Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(commandInterfaceCLIRMode);
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.273 -0400", hash_original_method = "14E36FB03F40D4635F36E46C38B086BD", hash_generated_method = "18045A4B94DA66E9FA0194BA5258BBA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getCallWaiting(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.273 -0400", hash_original_method = "80F9B6F2C3F4CA6200C97C4377273E17", hash_generated_method = "C63AB8DC7513C3A28F60817181EB2BDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCallWaiting(boolean enable, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(enable);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "call waiting not supported");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.273 -0400", hash_original_method = "6F81D9304F797B487FC34D43FAF41E44", hash_generated_method = "1ABD259CB10A83252776FB00487FDC6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEchoSuppressionEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        {
            foregroundCall.setAudioGroupMode();
        } //End block
        // ---------- Original Method ----------
        //synchronized (SipPhone.class) {
            //foregroundCall.setAudioGroupMode();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.273 -0400", hash_original_method = "79AC444E8066EFF34D5F76D19E8CCACC", hash_generated_method = "DD3CB7A80F9EE768B50FADE708B11E9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMute(boolean muted) {
        dsTaint.addTaint(muted);
        {
            foregroundCall.setMute(muted);
        } //End block
        // ---------- Original Method ----------
        //synchronized (SipPhone.class) {
            //foregroundCall.setMute(muted);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.274 -0400", hash_original_method = "8292EC8FC0222DDB10381F21089BC299", hash_generated_method = "3D4E398A0855EC7A1EA08E27293538E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getMute() {
        boolean var0736EE6D751830E03BA1FD8749498A0A_895918002 = ((foregroundCall.getState().isAlive()
                ? foregroundCall.getMute()
                : backgroundCall.getMute())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (foregroundCall.getState().isAlive()
                //? foregroundCall.getMute()
                //: backgroundCall.getMute());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.274 -0400", hash_original_method = "9DE1B547D23B96DA44E5E5850535D15C", hash_generated_method = "5100879878ADCD00CE61F8F34FD628A5")
    @DSModeled(DSC.SAFE)
    public Call getForegroundCall() {
        return (Call)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return foregroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.274 -0400", hash_original_method = "EADE59B65D242AA2A5BCB126522780FD", hash_generated_method = "3825A9044A4D1907C557991E9AF82C65")
    @DSModeled(DSC.SAFE)
    public Call getBackgroundCall() {
        return (Call)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return backgroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.274 -0400", hash_original_method = "3A1E9C8D795C10065E3EA9FCAA0EB60D", hash_generated_method = "F82E4F2B29D6CF86E407A901D3C0B464")
    @DSModeled(DSC.SAFE)
    public Call getRingingCall() {
        return (Call)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ringingCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.274 -0400", hash_original_method = "88DBA8231EA7F3BE9C495A0C37514173", hash_generated_method = "C67C319DDCECA9FF91F8B33EA9D62D21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServiceState getServiceState() {
        ServiceState var1F4D7B3B14DA4E5C6F4D6EA82024F8E9_214963131 = (super.getServiceState());
        return (ServiceState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return super.getServiceState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.275 -0400", hash_original_method = "AE09BA0335289F025B1DDE67D4558A7A", hash_generated_method = "89CF1091CBFBB17A963E2551DADE9BBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getUriString(SipProfile p) {
        dsTaint.addTaint(p.dsTaint);
        String var9EC8EA2F3F10D690322CE52F0256D2F6_1608446499 = (p.getUserName() + "@" + getSipDomain(p));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return p.getUserName() + "@" + getSipDomain(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.275 -0400", hash_original_method = "CF1C8708B65050BDE73A571BB1592129", hash_generated_method = "8F8D26D879FEEAFC1A8EF40153FCD351")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getSipDomain(SipProfile p) {
        dsTaint.addTaint(p.dsTaint);
        String domain;
        domain = p.getSipDomain();
        {
            boolean var58ED1E8F1C86F4A4907BDF2FED167062_924317090 = (domain.endsWith(":5060"));
            {
                String var8A663816B41244D1053230D0F8B4110E_1554299896 = (domain.substring(0, domain.length() - 5));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String domain = p.getSipDomain();
        //if (domain.endsWith(":5060")) {
            //return domain.substring(0, domain.length() - 5);
        //} else {
            //return domain;
        //}
    }

    
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

    
    private class SipCall extends SipCallBase {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.275 -0400", hash_original_method = "5212DB67137ED9C517B8CE314FF341ED", hash_generated_method = "5212DB67137ED9C517B8CE314FF341ED")
                public SipCall ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.275 -0400", hash_original_method = "077C3D2ABFDDE04A697972D273B811AD", hash_generated_method = "AFC116FB336DFDAE16FA5C7A5CE7B964")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void reset() {
            connections.clear();
            setState(Call.State.IDLE);
            // ---------- Original Method ----------
            //connections.clear();
            //setState(Call.State.IDLE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.276 -0400", hash_original_method = "375D19E8671ADDF3312252661F52306D", hash_generated_method = "54CFAD7F6A0308226B2CD7832AE5EEEE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void switchWith(SipCall that) {
            dsTaint.addTaint(that.dsTaint);
            {
                SipCall tmp;
                tmp = new SipCall();
                tmp.takeOver(this);
                this.takeOver(that);
                that.takeOver(tmp);
            } //End block
            // ---------- Original Method ----------
            //synchronized (SipPhone.class) {
                //SipCall tmp = new SipCall();
                //tmp.takeOver(this);
                //this.takeOver(that);
                //that.takeOver(tmp);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.280 -0400", hash_original_method = "1E912254ED378DFE25D6B6FABA0CA461", hash_generated_method = "F3098461348C969F88BE005FE4CF18B4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void takeOver(SipCall that) {
            dsTaint.addTaint(that.dsTaint);
            connections = that.connections;
            state = that.state;
            {
                Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_1267340195 = (connections).iterator();
                varE43AC770406DBA1185F3DAFDE696E6A3_1267340195.hasNext();
                Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_1267340195.next();
                {
                    ((SipConnection) c).changeOwner(this);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //connections = that.connections;
            //state = that.state;
            //for (Connection c : connections) {
                //((SipConnection) c).changeOwner(this);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.281 -0400", hash_original_method = "BB25C6B7E2DC41EA59445495652EDD92", hash_generated_method = "25B56EDAA12CAE1B3EACCC8389BA6A21")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Phone getPhone() {
            Phone varF387D9D394FE674F2CBD2DABABFE75F5_1296288498 = (SipPhone.this);
            return (Phone)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return SipPhone.this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.282 -0400", hash_original_method = "B38C364E01AF490301B03DAE11EB1509", hash_generated_method = "A8E1277B825D4DBEF1A56CAF9F16E5DC")
        @DSModeled(DSC.SAFE)
        @Override
        public List<Connection> getConnections() {
            return (List<Connection>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (SipPhone.class) {
                //return connections;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.283 -0400", hash_original_method = "B9E3A4EF80D99D71D1AE567F3438F945", hash_generated_method = "9D0D29356FF02E244251FA827BCB9019")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Connection dial(String originalNumber) throws SipException {
            dsTaint.addTaint(originalNumber);
            String calleeSipUri;
            calleeSipUri = originalNumber;
            {
                boolean var48F7791BB77ABFAC0D24C5A43EB83BC0_295391539 = (!calleeSipUri.contains("@"));
                {
                    String replaceStr;
                    replaceStr = Pattern.quote(mProfile.getUserName() + "@");
                    calleeSipUri = mProfile.getUriString().replaceFirst(replaceStr,
                        calleeSipUri + "@");
                } //End block
            } //End collapsed parenthetic
            try 
            {
                SipProfile callee;
                callee = new SipProfile.Builder(calleeSipUri).build();
                SipConnection c;
                c = new SipConnection(this, callee,
                        originalNumber);
                c.dial();
                connections.add(c);
                setState(Call.State.DIALING);
            } //End block
            catch (ParseException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("dial", e);
            } //End block
            return (Connection)dsTaint.getTaint();
            // ---------- Original Method ----------
            //String calleeSipUri = originalNumber;
            //if (!calleeSipUri.contains("@")) {
                //String replaceStr = Pattern.quote(mProfile.getUserName() + "@");
                //calleeSipUri = mProfile.getUriString().replaceFirst(replaceStr,
                        //calleeSipUri + "@");
            //}
            //try {
                //SipProfile callee =
                        //new SipProfile.Builder(calleeSipUri).build();
                //SipConnection c = new SipConnection(this, callee,
                        //originalNumber);
                //c.dial();
                //connections.add(c);
                //setState(Call.State.DIALING);
                //return c;
            //} catch (ParseException e) {
                //throw new SipException("dial", e);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.310 -0400", hash_original_method = "F3785C840BD99E8D755659453D00493E", hash_generated_method = "030F0BBBC22D2AED31188D93DC2DCA6A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void hangup() throws CallStateException {
            {
                {
                    boolean var8998223C0389365AC10BB9EB481CFC6F_1178154827 = (state.isAlive());
                    {
                        Log.d(LOG_TAG, "hang up call: " + getState()
                            + ": " + this + " on phone " + getPhone());
                        setState(State.DISCONNECTING);
                        CallStateException excp;
                        excp = null;
                        {
                            Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_711432227 = (connections).iterator();
                            varE43AC770406DBA1185F3DAFDE696E6A3_711432227.hasNext();
                            Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_711432227.next();
                            {
                                try 
                                {
                                    c.hangup();
                                } //End block
                                catch (CallStateException e)
                                {
                                    excp = e;
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                        if (DroidSafeAndroidRuntime.control) throw excp;
                    } //End block
                    {
                        Log.d(LOG_TAG, "hang up dead call: " + getState()
                            + ": " + this + " on phone " + getPhone());
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.311 -0400", hash_original_method = "03E5A9484BF2B2B8056B6450938A40D7", hash_generated_method = "312184BE480B5741046C475685DEE050")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void initIncomingCall(SipAudioCall sipAudioCall, boolean makeCallWait) {
            dsTaint.addTaint(sipAudioCall.dsTaint);
            dsTaint.addTaint(makeCallWait);
            SipProfile callee;
            callee = sipAudioCall.getPeerProfile();
            SipConnection c;
            c = new SipConnection(this, callee);
            connections.add(c);
            Call.State newState;
            newState = State.WAITING;
            newState = State.INCOMING;
            c.initIncomingCall(sipAudioCall, newState);
            setState(newState);
            notifyNewRingingConnectionP(c);
            // ---------- Original Method ----------
            //SipProfile callee = sipAudioCall.getPeerProfile();
            //SipConnection c = new SipConnection(this, callee);
            //connections.add(c);
            //Call.State newState = makeCallWait ? State.WAITING : State.INCOMING;
            //c.initIncomingCall(sipAudioCall, newState);
            //setState(newState);
            //notifyNewRingingConnectionP(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.311 -0400", hash_original_method = "F8072C3AD3C86AEC184FDD0C13B73AA0", hash_generated_method = "D7F0174B5C634AAAD4965899108AA01C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void rejectCall() throws CallStateException {
            hangup();
            // ---------- Original Method ----------
            //hangup();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.312 -0400", hash_original_method = "B2C3B5FE3154049893EC854E60F79D8F", hash_generated_method = "E55DB739CDAF064CD62542814CB585F2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void acceptCall() throws CallStateException {
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("acceptCall() in a non-ringing call");
            } //End block
            {
                boolean var9C09519F85FF3FA6D687EF8338B33839_2030983691 = (connections.size() != 1);
                {
                    if (DroidSafeAndroidRuntime.control) throw new CallStateException("acceptCall() in a conf call");
                } //End block
            } //End collapsed parenthetic
            ((SipConnection) connections.get(0)).acceptCall();
            // ---------- Original Method ----------
            //if (this != ringingCall) {
                //throw new CallStateException("acceptCall() in a non-ringing call");
            //}
            //if (connections.size() != 1) {
                //throw new CallStateException("acceptCall() in a conf call");
            //}
            //((SipConnection) connections.get(0)).acceptCall();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.312 -0400", hash_original_method = "1B6C9A8A7DE7A949D0CD2E188D6FBBDC", hash_generated_method = "4EB0A501868B0A2711654E9A3A72CE59")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean isSpeakerOn() {
            boolean var65FC9098A8240679D54D31921AD18341_1049653115 = (((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                    .isSpeakerphoneOn());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return ((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                    //.isSpeakerphoneOn();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.313 -0400", hash_original_method = "AEEC2C5B8263135991756BF729F3B501", hash_generated_method = "462B376B6C46623C7C1B25886BF69321")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void setAudioGroupMode() {
            AudioGroup audioGroup;
            audioGroup = getAudioGroup();
            int mode;
            mode = audioGroup.getMode();
            {
                audioGroup.setMode(AudioGroup.MODE_ON_HOLD);
            } //End block
            {
                boolean varF8A7F4F0125E77611C619BF6F6178B3E_844382124 = (getMute());
                {
                    audioGroup.setMode(AudioGroup.MODE_MUTED);
                } //End block
                {
                    boolean var43978F0EAC26602D234D59271C57818C_1943168573 = (isSpeakerOn());
                    {
                        audioGroup.setMode(AudioGroup.MODE_ECHO_SUPPRESSION);
                    } //End block
                    {
                        audioGroup.setMode(AudioGroup.MODE_NORMAL);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            Log.d(LOG_TAG, String.format(
                    "audioGroup mode change: %d --> %d", mode,
                    audioGroup.getMode()));
            // ---------- Original Method ----------
            //AudioGroup audioGroup = getAudioGroup();
            //if (audioGroup == null) return;
            //int mode = audioGroup.getMode();
            //if (state == State.HOLDING) {
                //audioGroup.setMode(AudioGroup.MODE_ON_HOLD);
            //} else if (getMute()) {
                //audioGroup.setMode(AudioGroup.MODE_MUTED);
            //} else if (isSpeakerOn()) {
                //audioGroup.setMode(AudioGroup.MODE_ECHO_SUPPRESSION);
            //} else {
                //audioGroup.setMode(AudioGroup.MODE_NORMAL);
            //}
            //if (DEBUG) Log.d(LOG_TAG, String.format(
                    //"audioGroup mode change: %d --> %d", mode,
                    //audioGroup.getMode()));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.317 -0400", hash_original_method = "A3EB25D5FFDA71466ECC0EEF32C97EE3", hash_generated_method = "B7220A90C2B753989EC6E8FA6200246F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void hold() throws CallStateException {
            setState(State.HOLDING);
            {
                Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_945057481 = (connections).iterator();
                varE43AC770406DBA1185F3DAFDE696E6A3_945057481.hasNext();
                Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_945057481.next();
                ((SipConnection) c).hold();
            } //End collapsed parenthetic
            setAudioGroupMode();
            // ---------- Original Method ----------
            //setState(State.HOLDING);
            //for (Connection c : connections) ((SipConnection) c).hold();
            //setAudioGroupMode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.323 -0400", hash_original_method = "9A7CCBA25036980309C5282A2982C0B2", hash_generated_method = "7F43293F790F37553124A993D0CD70F7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void unhold() throws CallStateException {
            setState(State.ACTIVE);
            AudioGroup audioGroup;
            audioGroup = new AudioGroup();
            {
                Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_156877613 = (connections).iterator();
                varE43AC770406DBA1185F3DAFDE696E6A3_156877613.hasNext();
                Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_156877613.next();
                {
                    ((SipConnection) c).unhold(audioGroup);
                } //End block
            } //End collapsed parenthetic
            setAudioGroupMode();
            // ---------- Original Method ----------
            //setState(State.ACTIVE);
            //AudioGroup audioGroup = new AudioGroup();
            //for (Connection c : connections) {
                //((SipConnection) c).unhold(audioGroup);
            //}
            //setAudioGroupMode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.334 -0400", hash_original_method = "7DDE83D6F9C645A60E86EBEFB92BE589", hash_generated_method = "1174ED1D0380F38E68B18DF38E5FF244")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void setMute(boolean muted) {
            dsTaint.addTaint(muted);
            {
                Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_1922918248 = (connections).iterator();
                varE43AC770406DBA1185F3DAFDE696E6A3_1922918248.hasNext();
                Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_1922918248.next();
                {
                    ((SipConnection) c).setMute(muted);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //for (Connection c : connections) {
                //((SipConnection) c).setMute(muted);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.336 -0400", hash_original_method = "B414CA4B3846B73054EF059A06E7BBBE", hash_generated_method = "AB790D9F4B7B03CCAF71F8A0D0D13FBF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean getMute() {
            {
                boolean var9D37F75EA12D86F1A0D608B063CA8508_542080432 = (connections.isEmpty());
                Object var30144DAD28DB69F770D2D62A9F08E471_1175866841 = (((SipConnection) connections.get(0)).getMute());
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return connections.isEmpty()
                    //? false
                    //: ((SipConnection) connections.get(0)).getMute();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.345 -0400", hash_original_method = "C6685F4BB929C317D55EF29FDD744317", hash_generated_method = "F1EE3BA193B0973407D5CA505C4A36EE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void merge(SipCall that) throws CallStateException {
            dsTaint.addTaint(that.dsTaint);
            AudioGroup audioGroup;
            audioGroup = getAudioGroup();
            Connection[] cc;
            cc = that.connections.toArray(
                    new Connection[that.connections.size()]);
            {
                Connection c = cc[0];
                {
                    SipConnection conn;
                    conn = (SipConnection) c;
                    add(conn);
                    {
                        boolean var0F3E8D2D4CC8A5C0357E07264342DA94_1827437026 = (conn.getState() == Call.State.HOLDING);
                        {
                            conn.unhold(audioGroup);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            that.setState(Call.State.IDLE);
            // ---------- Original Method ----------
            //AudioGroup audioGroup = getAudioGroup();
            //Connection[] cc = that.connections.toArray(
                    //new Connection[that.connections.size()]);
            //for (Connection c : cc) {
                //SipConnection conn = (SipConnection) c;
                //add(conn);
                //if (conn.getState() == Call.State.HOLDING) {
                    //conn.unhold(audioGroup);
                //}
            //}
            //that.setState(Call.State.IDLE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.346 -0400", hash_original_method = "C804E92B54898C48FBC0803D66022DE0", hash_generated_method = "A3F9F481B553C36322521493C4767B5F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void add(SipConnection conn) {
            dsTaint.addTaint(conn.dsTaint);
            SipCall call;
            call = conn.getCall();
            {
                boolean varB8F4F262BFDCEFC335F4E56671E9F1DA_1125785052 = (call == this);
            } //End collapsed parenthetic
            call.connections.remove(conn);
            connections.add(conn);
            conn.changeOwner(this);
            // ---------- Original Method ----------
            //SipCall call = conn.getCall();
            //if (call == this) return;
            //if (call != null) call.connections.remove(conn);
            //connections.add(conn);
            //conn.changeOwner(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.346 -0400", hash_original_method = "994C45B8BD8978A705E69F1BE351A00B", hash_generated_method = "E75B6CEB9B1A6804B59F69C1F615F8BA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void sendDtmf(char c) {
            dsTaint.addTaint(c);
            AudioGroup audioGroup;
            audioGroup = getAudioGroup();
            audioGroup.sendDtmf(convertDtmf(c));
            // ---------- Original Method ----------
            //AudioGroup audioGroup = getAudioGroup();
            //if (audioGroup == null) return;
            //audioGroup.sendDtmf(convertDtmf(c));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.347 -0400", hash_original_method = "C4229E0DAB0B84D6720429F368FEF1C3", hash_generated_method = "90C5AE865CAAC9802C974FB9CE44DC18")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int convertDtmf(char c) {
            dsTaint.addTaint(c);
            int code;
            code = c - '0';
            {
                //Begin case default 
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "invalid DTMF char: " + (int) c);
                //End case default 
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int code = c - '0';
            //if ((code < 0) || (code > 9)) {
                //switch (c) {
                    //case '*': return 10;
                    //case '#': return 11;
                    //case 'A': return 12;
                    //case 'B': return 13;
                    //case 'C': return 14;
                    //case 'D': return 15;
                    //default:
                        //throw new IllegalArgumentException(
                                //"invalid DTMF char: " + (int) c);
                //}
            //}
            //return code;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.347 -0400", hash_original_method = "A20E6ED570A38BE2669CFE3ED9219E0D", hash_generated_method = "C2E1FD10995B649D9E2D401627D812B8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void setState(State newState) {
            dsTaint.addTaint(newState.dsTaint);
            {
                {
                    state = newState;
                    SipPhone.this.startRingbackTone();
                } //End block
                {
                    SipPhone.this.stopRingbackTone();
                } //End block
                state = newState;
                updatePhoneState();
                notifyPreciseCallStateChanged();
            } //End block
            // ---------- Original Method ----------
            //if (state != newState) {
                //if (DEBUG) Log.v(LOG_TAG, "+***+ call state changed: " + state
                        //+ " --> " + newState + ": " + this + ": on phone "
                        //+ getPhone() + " " + connections.size());
                //if (newState == Call.State.ALERTING) {
                    //state = newState; 
                    //SipPhone.this.startRingbackTone();
                //} else if (state == Call.State.ALERTING) {
                    //SipPhone.this.stopRingbackTone();
                //}
                //state = newState;
                //updatePhoneState();
                //notifyPreciseCallStateChanged();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.347 -0400", hash_original_method = "9B48819375B09AF6C57EC0D05234CB41", hash_generated_method = "C3A0A9A4104DFD05AE2202E6BFB9712B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void onConnectionStateChanged(SipConnection conn) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(conn.dsTaint);
            {
                setState(conn.getState());
            } //End block
            // ---------- Original Method ----------
            //if (state != State.ACTIVE) {
                //setState(conn.getState());
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.356 -0400", hash_original_method = "67A791C264A58046C696AC400E0B1106", hash_generated_method = "0FA09FDC2278264294F5F37C0BB1999C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void onConnectionEnded(SipConnection conn) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(conn.dsTaint);
            {
                boolean allConnectionsDisconnected;
                allConnectionsDisconnected = true;
                Log.d(LOG_TAG, "---check connections: "
                        + connections.size());
                {
                    Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_1623116284 = (connections).iterator();
                    varE43AC770406DBA1185F3DAFDE696E6A3_1623116284.hasNext();
                    Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_1623116284.next();
                    {
                        Log.d(LOG_TAG, "   state=" + c.getState() + ": "
                            + c);
                        {
                            boolean varCAA7A57C3F38B59482436E96FBF861E4_605748753 = (c.getState() != State.DISCONNECTED);
                            {
                                allConnectionsDisconnected = false;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                setState(State.DISCONNECTED);
            } //End block
            notifyDisconnectP(conn);
            // ---------- Original Method ----------
            //if (state != State.DISCONNECTED) {
                //boolean allConnectionsDisconnected = true;
                //if (DEBUG) Log.d(LOG_TAG, "---check connections: "
                        //+ connections.size());
                //for (Connection c : connections) {
                    //if (DEBUG) Log.d(LOG_TAG, "   state=" + c.getState() + ": "
                            //+ c);
                    //if (c.getState() != State.DISCONNECTED) {
                        //allConnectionsDisconnected = false;
                        //break;
                    //}
                //}
                //if (allConnectionsDisconnected) setState(State.DISCONNECTED);
            //}
            //notifyDisconnectP(conn);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.364 -0400", hash_original_method = "3BDED5D4E6618481393AD33B1F728E6A", hash_generated_method = "2AB57517ABF75F5A020A8F67F98A4516")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private AudioGroup getAudioGroup() {
            {
                boolean var9D37F75EA12D86F1A0D608B063CA8508_476212117 = (connections.isEmpty());
            } //End collapsed parenthetic
            AudioGroup varF9B826AB28D8AA3672D45309F7F1567D_935198376 = (((SipConnection) connections.get(0)).getAudioGroup());
            return (AudioGroup)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (connections.isEmpty()) return null;
            //return ((SipConnection) connections.get(0)).getAudioGroup();
        }

        
    }


    
    private class SipConnection extends SipConnectionBase {
        private SipCall mOwner;
        private SipAudioCall mSipAudioCall;
        private Call.State mState = Call.State.IDLE;
        private SipProfile mPeer;
        private String mOriginalNumber;
        private boolean mIncoming = false;
        private SipAudioCallAdapter mAdapter = new SipAudioCallAdapter() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.367 -0400", hash_original_method = "B8BAADEA0DE266294E2369B45E53A7F4", hash_generated_method = "2A3216711DAD587857C42F9D31B75300")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            protected void onCallEnded(DisconnectCause cause) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(cause.dsTaint);
                {
                    boolean var3317223ED0C152EA0F03D574707E1DAC_298879117 = (getDisconnectCause() != DisconnectCause.LOCAL);
                    {
                        setDisconnectCause(cause);
                    } //End block
                } //End collapsed parenthetic
                {
                    setState(Call.State.DISCONNECTED);
                    SipAudioCall sipAudioCall;
                    sipAudioCall = mSipAudioCall;
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
                    } //End block
                    mOwner.onConnectionEnded(SipConnection.this);
                } //End block
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.368 -0400", hash_original_method = "52733E1CC76DBF11A64B0250C617E7AC", hash_generated_method = "5FEF7C91A26A8D5646DF9803B8C66220")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onCallEstablished(SipAudioCall call) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(call.dsTaint);
                onChanged(call);
                call.startAudio();
                // ---------- Original Method ----------
                //onChanged(call);
                //if (mState == Call.State.ACTIVE) call.startAudio();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.368 -0400", hash_original_method = "AC053A33592EEF445C9BE357836B4C16", hash_generated_method = "F39A82FFED0E081A092F374F34A1D22C")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onCallHeld(SipAudioCall call) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(call.dsTaint);
                onChanged(call);
                call.startAudio();
                // ---------- Original Method ----------
                //onChanged(call);
                //if (mState == Call.State.HOLDING) call.startAudio();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.369 -0400", hash_original_method = "9E9163C05D7336A6FE9DFAB379443860", hash_generated_method = "6EC4C2FAF9ECA5B1985AEC2DD056D1ED")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onChanged(SipAudioCall call) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(call.dsTaint);
                {
                    Call.State newState;
                    newState = getCallStateFrom(call);
                    {
                        setState(mOwner.getState());
                    } //End block
                    {
                        {
                            {
                                boolean varD8866BE17E7C5DE27AE1021BF41F371D_588575637 = (ringingCall.getState() == Call.State.WAITING);
                                {
                                    try 
                                    {
                                        switchHoldingAndActive();
                                    } //End block
                                    catch (CallStateException e)
                                    {
                                        onCallEnded(DisconnectCause.LOCAL);
                                    } //End block
                                } //End block
                            } //End collapsed parenthetic
                            foregroundCall.switchWith(ringingCall);
                        } //End block
                        setState(newState);
                    } //End block
                    mOwner.onConnectionStateChanged(SipConnection.this);
                } //End block
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.370 -0400", hash_original_method = "C52D3E5DC20D7F0420DDF7517152D94F", hash_generated_method = "246229440E45642A03E678F367F9EDB3")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            protected void onError(DisconnectCause cause) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(cause.dsTaint);
                Log.d(LOG_TAG, "SIP error: " + cause);
                onCallEnded(cause);
                // ---------- Original Method ----------
                //if (DEBUG) Log.d(LOG_TAG, "SIP error: " + cause);
                //onCallEnded(cause);
            }

            
}; //Transformed anonymous class
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.370 -0400", hash_original_method = "EB041B636E30FA2F3190616100DC4B14", hash_generated_method = "C81FD0C15D89D76F0B2A51AB91B50F1F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SipConnection(SipCall owner, SipProfile callee,
                String originalNumber) {
            super(originalNumber);
            dsTaint.addTaint(originalNumber);
            dsTaint.addTaint(owner.dsTaint);
            dsTaint.addTaint(callee.dsTaint);
            // ---------- Original Method ----------
            //mOwner = owner;
            //mPeer = callee;
            //mOriginalNumber = originalNumber;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.371 -0400", hash_original_method = "0957F2328B233DD414C835AB48AD0504", hash_generated_method = "B44EDB68EA2B13E68B00905F757DF0AE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SipConnection(SipCall owner, SipProfile callee) {
            this(owner, callee, getUriString(callee));
            dsTaint.addTaint(owner.dsTaint);
            dsTaint.addTaint(callee.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.373 -0400", hash_original_method = "57E4C10F499E8E36FDDCF5DF3794947E", hash_generated_method = "D11BD911F5E6DAA8A0C951AED5AB024D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String getCnapName() {
            String displayName;
            displayName = mPeer.getDisplayName();
            {
                boolean var02C40A7DE5016C5F8DE44FC4B2A33BB5_752333207 = (TextUtils.isEmpty(displayName));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //String displayName = mPeer.getDisplayName();
            //return TextUtils.isEmpty(displayName) ? null
                                                  //: displayName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.373 -0400", hash_original_method = "6B6F8D6F29C0FEAF9C52CC30010D6FE2", hash_generated_method = "15A583D18305CA197A26A69A2B43151A")
        @DSModeled(DSC.SAFE)
        @Override
        public int getNumberPresentation() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return Connection.PRESENTATION_ALLOWED;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.373 -0400", hash_original_method = "14BDBA500BD81C7014F8447F04B9333E", hash_generated_method = "60D4E7FDE26414B6C1C871BCC60E1B99")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void initIncomingCall(SipAudioCall sipAudioCall, Call.State newState) {
            dsTaint.addTaint(sipAudioCall.dsTaint);
            dsTaint.addTaint(newState.dsTaint);
            setState(newState);
            sipAudioCall.setListener(mAdapter);
            mIncoming = true;
            // ---------- Original Method ----------
            //setState(newState);
            //mSipAudioCall = sipAudioCall;
            //sipAudioCall.setListener(mAdapter);
            //mIncoming = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.373 -0400", hash_original_method = "62A265BABD2EF644B89898FE1DF3E037", hash_generated_method = "E88D0586F9497F58EC7DB8C51FD62A85")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void acceptCall() throws CallStateException {
            try 
            {
                mSipAudioCall.answerCall(TIMEOUT_ANSWER_CALL);
            } //End block
            catch (SipException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("acceptCall(): " + e);
            } //End block
            // ---------- Original Method ----------
            //try {
                //mSipAudioCall.answerCall(TIMEOUT_ANSWER_CALL);
            //} catch (SipException e) {
                //throw new CallStateException("acceptCall(): " + e);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.374 -0400", hash_original_method = "5D5AACCF3178F43A37FA6476F3FA2309", hash_generated_method = "EE565D9DBA5243AE49F6E9E8DCE2E72D")
        @DSModeled(DSC.SAFE)
         void changeOwner(SipCall owner) {
            dsTaint.addTaint(owner.dsTaint);
            // ---------- Original Method ----------
            //mOwner = owner;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.374 -0400", hash_original_method = "81195A6CBC9B38EAFBB5618CD4E171CB", hash_generated_method = "BFCC52CA5CF0BBDB0FFAF5954CF5C3D2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         AudioGroup getAudioGroup() {
            AudioGroup var981546C43EB8613D6CBA3E1D77BDCD49_1099814502 = (mSipAudioCall.getAudioGroup());
            return (AudioGroup)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (mSipAudioCall == null) return null;
            //return mSipAudioCall.getAudioGroup();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.374 -0400", hash_original_method = "766A0FDDBD2B3A4E947C7E8FBAB0F165", hash_generated_method = "93C009E595843D9B5B39352F3D675F51")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void dial() throws SipException {
            setState(Call.State.DIALING);
            mSipAudioCall = mSipManager.makeAudioCall(mProfile, mPeer, null,
                    TIMEOUT_MAKE_CALL);
            mSipAudioCall.setListener(mAdapter);
            // ---------- Original Method ----------
            //setState(Call.State.DIALING);
            //mSipAudioCall = mSipManager.makeAudioCall(mProfile, mPeer, null,
                    //TIMEOUT_MAKE_CALL);
            //mSipAudioCall.setListener(mAdapter);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.374 -0400", hash_original_method = "DDAA74ADB7976F32813665FE128238CD", hash_generated_method = "BD6ABA7F7127C0C77F83B3BF0D8D517A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void hold() throws CallStateException {
            setState(Call.State.HOLDING);
            try 
            {
                mSipAudioCall.holdCall(TIMEOUT_HOLD_CALL);
            } //End block
            catch (SipException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("hold(): " + e);
            } //End block
            // ---------- Original Method ----------
            //setState(Call.State.HOLDING);
            //try {
                //mSipAudioCall.holdCall(TIMEOUT_HOLD_CALL);
            //} catch (SipException e) {
                //throw new CallStateException("hold(): " + e);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.375 -0400", hash_original_method = "F77273A2CD584255814B6B238AF1477E", hash_generated_method = "47B5B9EC6E2A41FAB3BB761EF2C66DE0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void unhold(AudioGroup audioGroup) throws CallStateException {
            dsTaint.addTaint(audioGroup.dsTaint);
            mSipAudioCall.setAudioGroup(audioGroup);
            setState(Call.State.ACTIVE);
            try 
            {
                mSipAudioCall.continueCall(TIMEOUT_HOLD_CALL);
            } //End block
            catch (SipException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("unhold(): " + e);
            } //End block
            // ---------- Original Method ----------
            //mSipAudioCall.setAudioGroup(audioGroup);
            //setState(Call.State.ACTIVE);
            //try {
                //mSipAudioCall.continueCall(TIMEOUT_HOLD_CALL);
            //} catch (SipException e) {
                //throw new CallStateException("unhold(): " + e);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.375 -0400", hash_original_method = "91B9A79444A0C09E86ABE6F5C7C89706", hash_generated_method = "EC697E7D4831B951F4473E9E482CC50C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void setMute(boolean muted) {
            dsTaint.addTaint(muted);
            {
                boolean var6B5DA206A9FAB2FBF22E68E89DEB93FC_1310811480 = ((mSipAudioCall != null) && (muted != mSipAudioCall.isMuted()));
                {
                    mSipAudioCall.toggleMute();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if ((mSipAudioCall != null) && (muted != mSipAudioCall.isMuted())) {
                //mSipAudioCall.toggleMute();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.375 -0400", hash_original_method = "E20C6A660C2E35A5253ACCD901B5D855", hash_generated_method = "0A5143B3444D6B5D97147A98FBBBFF26")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean getMute() {
            {
                Object var6F96A3C795A4C1621DD07938C9161660_150724564 = (mSipAudioCall.isMuted());
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return (mSipAudioCall == null) ? false
                                           //: mSipAudioCall.isMuted();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.376 -0400", hash_original_method = "1833AE90ADB0C663418065E2EE17BAF0", hash_generated_method = "34DFB3F02E010CF7552C84FD9FB51EBB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void setState(Call.State state) {
            dsTaint.addTaint(state.dsTaint);
            super.setState(state);
            // ---------- Original Method ----------
            //if (state == mState) return;
            //super.setState(state);
            //mState = state;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.376 -0400", hash_original_method = "0D6E90F055C537B49BE3263741E0D2AC", hash_generated_method = "5DCCD7D0B2CD28780EC95C32E6DE12F5")
        @DSModeled(DSC.SAFE)
        @Override
        public Call.State getState() {
            return (Call.State)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mState;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.376 -0400", hash_original_method = "0C9900F417D1D38623450F6C44261C8A", hash_generated_method = "D147B00860F69EC578792AD3104CA1DC")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean isIncoming() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mIncoming;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.376 -0400", hash_original_method = "FE0C81270397910192F7BF8C9CDDDAB6", hash_generated_method = "87B64435ED83886F7FABEB9466A14613")
        @DSModeled(DSC.SAFE)
        @Override
        public String getAddress() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mOriginalNumber;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.376 -0400", hash_original_method = "710C86DFEBE06A4514867B4563DB846F", hash_generated_method = "8E21E8928DE08CACD93D4766FAE643A7")
        @DSModeled(DSC.SAFE)
        @Override
        public SipCall getCall() {
            return (SipCall)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mOwner;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.377 -0400", hash_original_method = "925322092199D63FE2A7CC7A8AD6AC9C", hash_generated_method = "D8D5BEFF00B112607F22ACC2C0730D8F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Phone getPhone() {
            Phone var7DA41FBE381F160D1FEBDCD933026CFD_1559637329 = (mOwner.getPhone());
            return (Phone)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mOwner.getPhone();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.377 -0400", hash_original_method = "B35A599F4014F0A4981FF871F70F4B98", hash_generated_method = "B8E878E23A94165A6D69A731FBD5DE3C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void hangup() throws CallStateException {
            {
                Log.d(LOG_TAG, "hangup conn: " + mPeer.getUriString()
                        + ": " + mState + ": on phone "
                        + getPhone().getPhoneName());
                {
                    boolean var7A71802BC1B1F87328893952D19337CA_1064931978 = (!mState.isAlive());
                } //End collapsed parenthetic
                try 
                {
                    SipAudioCall sipAudioCall;
                    sipAudioCall = mSipAudioCall;
                    {
                        sipAudioCall.setListener(null);
                        sipAudioCall.endCall();
                    } //End block
                } //End block
                catch (SipException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new CallStateException("hangup(): " + e);
                } //End block
                finally 
                {
                    mAdapter.onCallEnded(((mState == Call.State.INCOMING)
                            || (mState == Call.State.WAITING))
                            ? DisconnectCause.INCOMING_REJECTED
                            : DisconnectCause.LOCAL);
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.378 -0400", hash_original_method = "7B400982296D21B9968B9808849E5473", hash_generated_method = "24F58FB1540E982C340F0C1580FFB632")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void separate() throws CallStateException {
            {
                SipCall call;
                boolean var9F2100AEF9AB3C51A66873B7B7B06C45_1424030671 = ((getPhone() == SipPhone.this));
                call = (SipCall) SipPhone.this.getBackgroundCall();
                call = (SipCall) SipPhone.this.getForegroundCall();
                {
                    boolean var06B2F1D0FB9C9B434F76B9D96A375019_244372152 = (call.getState() != Call.State.IDLE);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new CallStateException(
                            "cannot put conn back to a call in non-idle state: "
                            + call.getState());
                    } //End block
                } //End collapsed parenthetic
                Log.d(LOG_TAG, "separate conn: "
                        + mPeer.getUriString() + " from " + mOwner + " back to "
                        + call);
                Phone originalPhone;
                originalPhone = getPhone();
                AudioGroup audioGroup;
                audioGroup = call.getAudioGroup();
                call.add(this);
                mSipAudioCall.setAudioGroup(audioGroup);
                originalPhone.switchHoldingAndActive();
                call = (SipCall) SipPhone.this.getForegroundCall();
                mSipAudioCall.startAudio();
                call.onConnectionStateChanged(this);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private abstract class SipAudioCallAdapter extends SipAudioCall.Listener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.378 -0400", hash_original_method = "613D704D5B1AB2BED309B6FD053B43BE", hash_generated_method = "613D704D5B1AB2BED309B6FD053B43BE")
                public SipAudioCallAdapter ()
        {
        }


        protected abstract void onCallEnded(Connection.DisconnectCause cause);

        
        protected abstract void onError(Connection.DisconnectCause cause);

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.378 -0400", hash_original_method = "FAC45A8F53047AFBBF88628CAD98E6D5", hash_generated_method = "FF6C878FE5ED047A8D2CBC19C8BA9988")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onCallEnded(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(call.dsTaint);
            onCallEnded(call.isInCall()
                    ? Connection.DisconnectCause.NORMAL
                    : Connection.DisconnectCause.INCOMING_MISSED);
            // ---------- Original Method ----------
            //onCallEnded(call.isInCall()
                    //? Connection.DisconnectCause.NORMAL
                    //: Connection.DisconnectCause.INCOMING_MISSED);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.379 -0400", hash_original_method = "5FEE35421FE68DCB9D837EF94FC0CC79", hash_generated_method = "ACEA278234D4414B1891CBB1A5CF090F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onCallBusy(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(call.dsTaint);
            onCallEnded(Connection.DisconnectCause.BUSY);
            // ---------- Original Method ----------
            //onCallEnded(Connection.DisconnectCause.BUSY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.379 -0400", hash_original_method = "7EFF641046EACBCFF45AD18624210100", hash_generated_method = "E4BE85C21E201FB2D4799240FB3846ED")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onError(SipAudioCall call, int errorCode,
                String errorMessage) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(errorMessage);
            dsTaint.addTaint(call.dsTaint);
            dsTaint.addTaint(errorCode);
            //Begin case SipErrorCode.SERVER_UNREACHABLE 
            onError(Connection.DisconnectCause.SERVER_UNREACHABLE);
            //End case SipErrorCode.SERVER_UNREACHABLE 
            //Begin case SipErrorCode.PEER_NOT_REACHABLE 
            onError(Connection.DisconnectCause.NUMBER_UNREACHABLE);
            //End case SipErrorCode.PEER_NOT_REACHABLE 
            //Begin case SipErrorCode.INVALID_REMOTE_URI 
            onError(Connection.DisconnectCause.INVALID_NUMBER);
            //End case SipErrorCode.INVALID_REMOTE_URI 
            //Begin case SipErrorCode.TIME_OUT SipErrorCode.TRANSACTION_TERMINTED 
            onError(Connection.DisconnectCause.TIMED_OUT);
            //End case SipErrorCode.TIME_OUT SipErrorCode.TRANSACTION_TERMINTED 
            //Begin case SipErrorCode.DATA_CONNECTION_LOST 
            onError(Connection.DisconnectCause.LOST_SIGNAL);
            //End case SipErrorCode.DATA_CONNECTION_LOST 
            //Begin case SipErrorCode.INVALID_CREDENTIALS 
            onError(Connection.DisconnectCause.INVALID_CREDENTIALS);
            //End case SipErrorCode.INVALID_CREDENTIALS 
            //Begin case SipErrorCode.CROSS_DOMAIN_AUTHENTICATION 
            onError(Connection.DisconnectCause.OUT_OF_NETWORK);
            //End case SipErrorCode.CROSS_DOMAIN_AUTHENTICATION 
            //Begin case SipErrorCode.SERVER_ERROR 
            onError(Connection.DisconnectCause.SERVER_ERROR);
            //End case SipErrorCode.SERVER_ERROR 
            //Begin case SipErrorCode.SOCKET_ERROR SipErrorCode.CLIENT_ERROR default 
            onError(Connection.DisconnectCause.ERROR_UNSPECIFIED);
            //End case SipErrorCode.SOCKET_ERROR SipErrorCode.CLIENT_ERROR default 
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static final String LOG_TAG = "SipPhone";
    private static final boolean DEBUG = true;
    private static final int TIMEOUT_MAKE_CALL = 15;
    private static final int TIMEOUT_ANSWER_CALL = 8;
    private static final int TIMEOUT_HOLD_CALL = 15;
}

