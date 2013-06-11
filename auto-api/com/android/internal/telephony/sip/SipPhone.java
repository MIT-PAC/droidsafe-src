package com.android.internal.telephony.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final String LOG_TAG = "SipPhone";
    private static final boolean DEBUG = true;
    private static final int TIMEOUT_MAKE_CALL = 15;
    private static final int TIMEOUT_ANSWER_CALL = 8;
    private static final int TIMEOUT_HOLD_CALL = 15;
    private SipCall ringingCall = new SipCall();
    private SipCall foregroundCall = new SipCall();
    private SipCall backgroundCall = new SipCall();
    private SipManager mSipManager;
    private SipProfile mProfile;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.455 -0400", hash_original_method = "6A0F0B835E49D28418FC90D67BF66C10", hash_generated_method = "419237B3D3B5E4EB9DD1436CBA4D0246")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.455 -0400", hash_original_method = "0022E344F588A86EC51D8DF12CB4CABD", hash_generated_method = "51329CFEE3C9AC7C34DA2920EC198C7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        SipPhone that;
        that = (SipPhone) o;
        boolean var45CE97710469451C578ABB40487B4EE8_606527733 = (mProfile.getUriString().equals(that.mProfile.getUriString()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (!(o instanceof SipPhone)) return false;
        //SipPhone that = (SipPhone) o;
        //return mProfile.getUriString().equals(that.mProfile.getUriString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.455 -0400", hash_original_method = "87B6F28FD5B3DEC2F08CA48119477808", hash_generated_method = "75EB26D533054BF2ECDE94E82097E909")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPhoneName() {
        String var8C7EF0796A13E4CBF3CAAC060C40CB68_1146503835 = ("SIP:" + getUriString(mProfile));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "SIP:" + getUriString(mProfile);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.456 -0400", hash_original_method = "AD1E8A0332F840602A7373ACA5D5D1A0", hash_generated_method = "58F67165CBA62589FF15245AD6A27582")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSipUri() {
        String var2A70BC160D0426F04D895659D471A43F_627411752 = (mProfile.getUriString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mProfile.getUriString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.456 -0400", hash_original_method = "D3C5F9763476A8D0E8037A369F8C496C", hash_generated_method = "BEE719DF290F6B46398F5DD4E16EE5FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(SipPhone phone) {
        dsTaint.addTaint(phone.dsTaint);
        boolean varB170C7409F6B913400034BFCA292A56F_1115480609 = (getSipUri().equals(phone.getSipUri()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getSipUri().equals(phone.getSipUri());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.456 -0400", hash_original_method = "520B082FC4D55C78B63B25D36AD6E406", hash_generated_method = "6D7781C5FE85464CB414D922DA6841E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canTake(Object incomingCall) {
        dsTaint.addTaint(incomingCall.dsTaint);
        {
            {
                boolean varE01C4545931A62F4FC941738A7A28D5F_820301486 = (ringingCall.getState().isAlive());
            } //End collapsed parenthetic
            {
                boolean var5F3F3054BBF953B9D43A6A67CF0D2F18_1044079762 = (foregroundCall.getState().isAlive()
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
                    boolean varAFFEC3E610279996536BBDBBD3DBA5A6_340484019 = (localUri.equals(mProfile.getUriString()));
                    {
                        boolean makeCallWait;
                        makeCallWait = foregroundCall.getState().isAlive();
                        ringingCall.initIncomingCall(sipAudioCall, makeCallWait);
                        {
                            boolean var83E8B86F2BE04FBC6538BB9432DC8A6D_1523762377 = (sipAudioCall.getState()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.456 -0400", hash_original_method = "4D3FC14BD1B17CB217053014BC4D74B6", hash_generated_method = "7C8F1DFD2473B9C6E14A65CCA31CC215")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void acceptCall() throws CallStateException {
        {
            {
                boolean varE0C61107F4B1A5D76C43D42CFA8103F3_173255858 = ((ringingCall.getState() == Call.State.INCOMING) ||
                    (ringingCall.getState() == Call.State.WAITING));
                {
                    Log.d(LOG_TAG, "acceptCall");
                    ringingCall.setMute(false);
                    ringingCall.acceptCall();
                } //End block
                {
                    throw new CallStateException("phone not ringing");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.456 -0400", hash_original_method = "F60D4B1A0C339762A597DB11EC122CEA", hash_generated_method = "8759C05C6194A7BE3C5A0C5825EEE339")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void rejectCall() throws CallStateException {
        {
            {
                boolean var442D0F0D7EEA6963AE66B13292492B00_1647501520 = (ringingCall.getState().isRinging());
                {
                    Log.d(LOG_TAG, "rejectCall");
                    ringingCall.rejectCall();
                } //End block
                {
                    throw new CallStateException("phone not ringing");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.456 -0400", hash_original_method = "01C657A55270F6B259EE4CA2295CF206", hash_generated_method = "63C7F7560F4641A25BB8305617628602")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Connection dial(String dialString) throws CallStateException {
        dsTaint.addTaint(dialString);
        {
            Connection var87FF1277636E22F4543AB89DB43FB1F6_1892816945 = (dialInternal(dialString));
        } //End block
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (SipPhone.class) {
            //return dialInternal(dialString);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.456 -0400", hash_original_method = "E69019A31CF45F3F0FFB8952555ADD38", hash_generated_method = "0D4B63707C9EBB4EC0B330170D97161B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Connection dialInternal(String dialString) throws CallStateException {
        dsTaint.addTaint(dialString);
        clearDisconnected();
        {
            boolean var37336DD64F87D8D8C5FEC219FB8725E9_663041995 = (!canDial());
            {
                throw new CallStateException("cannot dial in current state");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varC33489E5DEA37065C5D9027B98F53E39_908539881 = (foregroundCall.getState() == SipCall.State.ACTIVE);
            {
                switchHoldingAndActive();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAA5B136BDA3FB7DD22D11F146CB8E62A_1719543902 = (foregroundCall.getState() != SipCall.State.IDLE);
            {
                throw new CallStateException("cannot dial in current state");
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
            throw new CallStateException("dial error: " + e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.457 -0400", hash_original_method = "04453A8FBCEE87A03C8D7EC224934C23", hash_generated_method = "1BC7EE73AB5CA584149CA723062D19E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void switchHoldingAndActive() throws CallStateException {
        Log.d(LOG_TAG, " ~~~~~~  switch fg and bg");
        {
            foregroundCall.switchWith(backgroundCall);
            {
                boolean varA0AFA2B7E4A73D22BA12DB013063960D_579469274 = (backgroundCall.getState().isAlive());
                backgroundCall.hold();
            } //End collapsed parenthetic
            {
                boolean var63B388EA3D8161389B434AC6220A05EB_1689557094 = (foregroundCall.getState().isAlive());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.457 -0400", hash_original_method = "EF99002349D3FD6EFA7BC51A1FE3E619", hash_generated_method = "CDDEA2705D41B7FEDE3129F95062271D")
    @DSModeled(DSC.SAFE)
    public boolean canConference() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.457 -0400", hash_original_method = "5DC11CA56E4A18B2CAABC2999FA181D0", hash_generated_method = "33C92C7228FF9897470CF1D1C216C720")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void conference() throws CallStateException {
        {
            {
                boolean varA1285B741C70BDCFD1DA6690E8723FC5_401781630 = ((foregroundCall.getState() != SipCall.State.ACTIVE)
                    || (foregroundCall.getState() != SipCall.State.ACTIVE));
                {
                    throw new CallStateException("wrong state to merge calls: fg="
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.457 -0400", hash_original_method = "0BA61BE71F93F0627212F9F9B5CF61C9", hash_generated_method = "50593117DEA971BCBEDDE44D944F14F4")
    @DSModeled(DSC.SAFE)
    public void conference(Call that) throws CallStateException {
        dsTaint.addTaint(that.dsTaint);
        {
            {
                throw new CallStateException("expect " + SipCall.class
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.457 -0400", hash_original_method = "FB85D9DE1C816CCA93C5FDAD3D9D0A31", hash_generated_method = "C303D1ABEFD7787341DA22FCA0414699")
    @DSModeled(DSC.SAFE)
    public boolean canTransfer() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.457 -0400", hash_original_method = "6F3E620B44779BFD9D290EDD6A721C13", hash_generated_method = "DCFB96201D37A825C0DADBECAC6A73C6")
    @DSModeled(DSC.SAFE)
    public void explicitCallTransfer() throws CallStateException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.457 -0400", hash_original_method = "D9CD8A34486E399CFA818246637B2970", hash_generated_method = "6DBD8344C06C9CBEF6A78C93D6102D69")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.457 -0400", hash_original_method = "D682F8DE86633D8037AE8DB7A99E0997", hash_generated_method = "32550012C5BAF0DADE27FCA2D4C7BE31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendDtmf(char c) {
        dsTaint.addTaint(c);
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_1940994268 = (!PhoneNumberUtils.is12Key(c));
            {
                boolean var63B388EA3D8161389B434AC6220A05EB_1937758046 = (foregroundCall.getState().isAlive());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.457 -0400", hash_original_method = "C805BAC519448AC91DEA3466C2A972EF", hash_generated_method = "DE32426C7BAB2A123FFFE9D7769163D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startDtmf(char c) {
        dsTaint.addTaint(c);
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_1018270737 = (!PhoneNumberUtils.is12Key(c));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.457 -0400", hash_original_method = "1D5D5FD426DB2358E4E86A174C44532E", hash_generated_method = "1C519E3E039E8CE3CD2853471AAB4FFF")
    @DSModeled(DSC.SAFE)
    public void stopDtmf() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.457 -0400", hash_original_method = "9189F1384120EC6E17589215617F3507", hash_generated_method = "219271AF201C02AD74EF7EC35CE321AA")
    @DSModeled(DSC.SAFE)
    public void sendBurstDtmf(String dtmfString) {
        dsTaint.addTaint(dtmfString);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SipPhone] sendBurstDtmf() is a CDMA method");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.457 -0400", hash_original_method = "0D09CB6308056457AD1772B2CC5B82FC", hash_generated_method = "7841A4BFF1552D8160D56D6A7133DA75")
    @DSModeled(DSC.SAFE)
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.457 -0400", hash_original_method = "56612EF91DCB9A3808F62E57BF0F81E1", hash_generated_method = "0F4E9E6DAABD63AB833FB865DEDEC3EC")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.457 -0400", hash_original_method = "14E36FB03F40D4635F36E46C38B086BD", hash_generated_method = "CC903DA58C1CB085F1A0DF15849D79EA")
    @DSModeled(DSC.SAFE)
    public void getCallWaiting(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.457 -0400", hash_original_method = "80F9B6F2C3F4CA6200C97C4377273E17", hash_generated_method = "D272586165658DBF044495F3DD90004C")
    @DSModeled(DSC.SAFE)
    public void setCallWaiting(boolean enable, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(enable);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "call waiting not supported");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.457 -0400", hash_original_method = "6F81D9304F797B487FC34D43FAF41E44", hash_generated_method = "5E87DD62A594349A8990C90D69EE0C32")
    @DSModeled(DSC.SAFE)
    @Override
    public void setEchoSuppressionEnabled(boolean enabled) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(enabled);
        {
            foregroundCall.setAudioGroupMode();
        } //End block
        // ---------- Original Method ----------
        //synchronized (SipPhone.class) {
            //foregroundCall.setAudioGroupMode();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.458 -0400", hash_original_method = "79AC444E8066EFF34D5F76D19E8CCACC", hash_generated_method = "960459536C144C12A33BBB493EEDF7C1")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.458 -0400", hash_original_method = "8292EC8FC0222DDB10381F21089BC299", hash_generated_method = "C6B476785D7926DC9393D2AEC8178621")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getMute() {
        boolean var0736EE6D751830E03BA1FD8749498A0A_1411931871 = ((foregroundCall.getState().isAlive()
                ? foregroundCall.getMute()
                : backgroundCall.getMute())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (foregroundCall.getState().isAlive()
                //? foregroundCall.getMute()
                //: backgroundCall.getMute());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.458 -0400", hash_original_method = "9DE1B547D23B96DA44E5E5850535D15C", hash_generated_method = "EF3093F16ABDE65E48634B4CC829ABAB")
    @DSModeled(DSC.SAFE)
    public Call getForegroundCall() {
        return (Call)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return foregroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.458 -0400", hash_original_method = "EADE59B65D242AA2A5BCB126522780FD", hash_generated_method = "E18F4A771AF34B51FC5E289730BA810F")
    @DSModeled(DSC.SAFE)
    public Call getBackgroundCall() {
        return (Call)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return backgroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.458 -0400", hash_original_method = "3A1E9C8D795C10065E3EA9FCAA0EB60D", hash_generated_method = "234C830FABD2381CB09FB496C83DDA06")
    @DSModeled(DSC.SAFE)
    public Call getRingingCall() {
        return (Call)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ringingCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.458 -0400", hash_original_method = "88DBA8231EA7F3BE9C495A0C37514173", hash_generated_method = "0E5ED0F191322368E9B2AEB557E8F22D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServiceState getServiceState() {
        ServiceState var1F4D7B3B14DA4E5C6F4D6EA82024F8E9_1573742989 = (super.getServiceState());
        return (ServiceState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return super.getServiceState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.458 -0400", hash_original_method = "AE09BA0335289F025B1DDE67D4558A7A", hash_generated_method = "D2CB69F1173BC4C72A46992A235FC011")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getUriString(SipProfile p) {
        dsTaint.addTaint(p.dsTaint);
        String var9EC8EA2F3F10D690322CE52F0256D2F6_403326506 = (p.getUserName() + "@" + getSipDomain(p));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return p.getUserName() + "@" + getSipDomain(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.458 -0400", hash_original_method = "CF1C8708B65050BDE73A571BB1592129", hash_generated_method = "B7ECE4462AFD84E15AFBD273607BB534")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getSipDomain(SipProfile p) {
        dsTaint.addTaint(p.dsTaint);
        String domain;
        domain = p.getSipDomain();
        {
            boolean var58ED1E8F1C86F4A4907BDF2FED167062_1505127532 = (domain.endsWith(":5060"));
            {
                String var8A663816B41244D1053230D0F8B4110E_913507575 = (domain.substring(0, domain.length() - 5));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.458 -0400", hash_original_method = "0DB04D989DB8A0D8D42E47E87513600C", hash_generated_method = "E289371A5283105F701FC3DB40500131")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.458 -0400", hash_original_method = "077C3D2ABFDDE04A697972D273B811AD", hash_generated_method = "B65263E1B85D1EA72379F71EFA708CF0")
        @DSModeled(DSC.SAFE)
         void reset() {
            connections.clear();
            setState(Call.State.IDLE);
            // ---------- Original Method ----------
            //connections.clear();
            //setState(Call.State.IDLE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.458 -0400", hash_original_method = "375D19E8671ADDF3312252661F52306D", hash_generated_method = "03B73DBD20FBC31B76E97E710A1D17E5")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.458 -0400", hash_original_method = "1E912254ED378DFE25D6B6FABA0CA461", hash_generated_method = "6BE582ADCF0CE9A262BB1F3D2A84BBC4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void takeOver(SipCall that) {
            dsTaint.addTaint(that.dsTaint);
            connections = that.connections;
            state = that.state;
            {
                Iterator<Connection> seatecAstronomy42 = connections.iterator();
                seatecAstronomy42.hasNext();
                Connection c = seatecAstronomy42.next();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.458 -0400", hash_original_method = "BB25C6B7E2DC41EA59445495652EDD92", hash_generated_method = "4EE9374DD601EA31AFA30F3956F9FAEB")
        @DSModeled(DSC.SAFE)
        @Override
        public Phone getPhone() {
            return (Phone)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return SipPhone.this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.458 -0400", hash_original_method = "B38C364E01AF490301B03DAE11EB1509", hash_generated_method = "6EBCD9AE9E47477538352220A915E2B2")
        @DSModeled(DSC.SAFE)
        @Override
        public List<Connection> getConnections() {
            return (List<Connection>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (SipPhone.class) {
                //return connections;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.458 -0400", hash_original_method = "B9E3A4EF80D99D71D1AE567F3438F945", hash_generated_method = "E3CBE4DA89EC6EB3BFD96FF5027231D5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Connection dial(String originalNumber) throws SipException {
            dsTaint.addTaint(originalNumber);
            String calleeSipUri;
            calleeSipUri = originalNumber;
            {
                boolean var48F7791BB77ABFAC0D24C5A43EB83BC0_1613740312 = (!calleeSipUri.contains("@"));
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
                throw new SipException("dial", e);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.459 -0400", hash_original_method = "F3785C840BD99E8D755659453D00493E", hash_generated_method = "501462CB77631238A6E657E6847120DB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void hangup() throws CallStateException {
            {
                {
                    boolean var8998223C0389365AC10BB9EB481CFC6F_992863340 = (state.isAlive());
                    {
                        Log.d(LOG_TAG, "hang up call: " + getState()
                            + ": " + this + " on phone " + getPhone());
                        setState(State.DISCONNECTING);
                        CallStateException excp;
                        excp = null;
                        {
                            Iterator<Connection> seatecAstronomy42 = connections.iterator();
                            seatecAstronomy42.hasNext();
                            Connection c = seatecAstronomy42.next();
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
                        throw excp;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.459 -0400", hash_original_method = "03E5A9484BF2B2B8056B6450938A40D7", hash_generated_method = "E96865722AA53799D9751294EAE76315")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.459 -0400", hash_original_method = "F8072C3AD3C86AEC184FDD0C13B73AA0", hash_generated_method = "1FC949685C5E5E963BFEF84CBA75FF11")
        @DSModeled(DSC.SAFE)
         void rejectCall() throws CallStateException {
            hangup();
            // ---------- Original Method ----------
            //hangup();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.459 -0400", hash_original_method = "B2C3B5FE3154049893EC854E60F79D8F", hash_generated_method = "884BAB15AEA2BD144C350D85BC6BA68F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void acceptCall() throws CallStateException {
            {
                throw new CallStateException("acceptCall() in a non-ringing call");
            } //End block
            {
                boolean var9C09519F85FF3FA6D687EF8338B33839_1563056835 = (connections.size() != 1);
                {
                    throw new CallStateException("acceptCall() in a conf call");
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.459 -0400", hash_original_method = "1B6C9A8A7DE7A949D0CD2E188D6FBBDC", hash_generated_method = "0EB5F5189497AA78E599F4A6DD697959")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean isSpeakerOn() {
            boolean var65FC9098A8240679D54D31921AD18341_498754104 = (((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                    .isSpeakerphoneOn());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return ((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                    //.isSpeakerphoneOn();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.459 -0400", hash_original_method = "AEEC2C5B8263135991756BF729F3B501", hash_generated_method = "67DB87776B0961256920AD5DBC9E85E3")
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
                boolean varF8A7F4F0125E77611C619BF6F6178B3E_1502053540 = (getMute());
                {
                    audioGroup.setMode(AudioGroup.MODE_MUTED);
                } //End block
                {
                    boolean var43978F0EAC26602D234D59271C57818C_1366635318 = (isSpeakerOn());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.459 -0400", hash_original_method = "A3EB25D5FFDA71466ECC0EEF32C97EE3", hash_generated_method = "51059DE31B1753DD496464B3DDC73EE6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void hold() throws CallStateException {
            setState(State.HOLDING);
            {
                Iterator<Connection> seatecAstronomy42 = connections.iterator();
                seatecAstronomy42.hasNext();
                Connection c = seatecAstronomy42.next();
                ((SipConnection) c).hold();
            } //End collapsed parenthetic
            setAudioGroupMode();
            // ---------- Original Method ----------
            //setState(State.HOLDING);
            //for (Connection c : connections) ((SipConnection) c).hold();
            //setAudioGroupMode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.459 -0400", hash_original_method = "9A7CCBA25036980309C5282A2982C0B2", hash_generated_method = "091C8B22047A609C5AA2E83FCD4967ED")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void unhold() throws CallStateException {
            setState(State.ACTIVE);
            AudioGroup audioGroup;
            audioGroup = new AudioGroup();
            {
                Iterator<Connection> seatecAstronomy42 = connections.iterator();
                seatecAstronomy42.hasNext();
                Connection c = seatecAstronomy42.next();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.459 -0400", hash_original_method = "7DDE83D6F9C645A60E86EBEFB92BE589", hash_generated_method = "3A864B5710CE867DFB16AA1A3D8555DB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void setMute(boolean muted) {
            dsTaint.addTaint(muted);
            {
                Iterator<Connection> seatecAstronomy42 = connections.iterator();
                seatecAstronomy42.hasNext();
                Connection c = seatecAstronomy42.next();
                {
                    ((SipConnection) c).setMute(muted);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //for (Connection c : connections) {
                //((SipConnection) c).setMute(muted);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.460 -0400", hash_original_method = "B414CA4B3846B73054EF059A06E7BBBE", hash_generated_method = "563CA4F24BA45289A9D702662DDEFD50")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean getMute() {
            {
                boolean var9D37F75EA12D86F1A0D608B063CA8508_1708910815 = (connections.isEmpty());
                Object var30144DAD28DB69F770D2D62A9F08E471_1172048608 = (((SipConnection) connections.get(0)).getMute());
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return connections.isEmpty()
                    //? false
                    //: ((SipConnection) connections.get(0)).getMute();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.460 -0400", hash_original_method = "C6685F4BB929C317D55EF29FDD744317", hash_generated_method = "9D04B950F49EE3FB6F809BBB6968DB72")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void merge(SipCall that) throws CallStateException {
            dsTaint.addTaint(that.dsTaint);
            AudioGroup audioGroup;
            audioGroup = getAudioGroup();
            Connection[] cc;
            cc = that.connections.toArray(
                    new Connection[that.connections.size()]);
            {
                Iterator<Connection> seatecAstronomy42 = cc.iterator();
                seatecAstronomy42.hasNext();
                Connection c = seatecAstronomy42.next();
                {
                    SipConnection conn;
                    conn = (SipConnection) c;
                    add(conn);
                    {
                        boolean var0F3E8D2D4CC8A5C0357E07264342DA94_540562250 = (conn.getState() == Call.State.HOLDING);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.460 -0400", hash_original_method = "C804E92B54898C48FBC0803D66022DE0", hash_generated_method = "D5F8B9D9D4E556F8FEA0E0F7E65536D0")
        @DSModeled(DSC.SAFE)
        private void add(SipConnection conn) {
            dsTaint.addTaint(conn.dsTaint);
            SipCall call;
            call = conn.getCall();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.460 -0400", hash_original_method = "994C45B8BD8978A705E69F1BE351A00B", hash_generated_method = "5295F1E77D9BECC6CD0B46041EE81F72")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.460 -0400", hash_original_method = "C4229E0DAB0B84D6720429F368FEF1C3", hash_generated_method = "774AE951C027BEA8D96B275FBC27C02E")
        @DSModeled(DSC.SAFE)
        private int convertDtmf(char c) {
            dsTaint.addTaint(c);
            int code;
            code = c - '0';
            {
                //Begin case default 
                throw new IllegalArgumentException(
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.460 -0400", hash_original_method = "A20E6ED570A38BE2669CFE3ED9219E0D", hash_generated_method = "764D6AFAA264F9AA8066384A00B3DA47")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.460 -0400", hash_original_method = "9B48819375B09AF6C57EC0D05234CB41", hash_generated_method = "AC3A251D7796FD7C1C8F63E5FC4A5926")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.460 -0400", hash_original_method = "67A791C264A58046C696AC400E0B1106", hash_generated_method = "457D7C5DAA73B4907C032EFF85BC383A")
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
                    Iterator<Connection> seatecAstronomy42 = connections.iterator();
                    seatecAstronomy42.hasNext();
                    Connection c = seatecAstronomy42.next();
                    {
                        Log.d(LOG_TAG, "   state=" + c.getState() + ": "
                            + c);
                        {
                            boolean varCAA7A57C3F38B59482436E96FBF861E4_1100132932 = (c.getState() != State.DISCONNECTED);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.461 -0400", hash_original_method = "3BDED5D4E6618481393AD33B1F728E6A", hash_generated_method = "ED3659BB0A617D029F020E710821ACCC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private AudioGroup getAudioGroup() {
            {
                boolean var9D37F75EA12D86F1A0D608B063CA8508_1250768925 = (connections.isEmpty());
            } //End collapsed parenthetic
            AudioGroup varF9B826AB28D8AA3672D45309F7F1567D_433288961 = (((SipConnection) connections.get(0)).getAudioGroup());
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.461 -0400", hash_original_method = "B8BAADEA0DE266294E2369B45E53A7F4", hash_generated_method = "F882A6BB75158644BECEF4D0213F3631")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            protected void onCallEnded(DisconnectCause cause) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(cause.dsTaint);
                {
                    boolean var3317223ED0C152EA0F03D574707E1DAC_1027391205 = (getDisconnectCause() != DisconnectCause.LOCAL);
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.461 -0400", hash_original_method = "52733E1CC76DBF11A64B0250C617E7AC", hash_generated_method = "0DE2B2557032D6348102F6477F8D2E2F")
            @DSModeled(DSC.SAFE)
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.461 -0400", hash_original_method = "AC053A33592EEF445C9BE357836B4C16", hash_generated_method = "ADC4B4C2630148B83CB5A782F5201C10")
            @DSModeled(DSC.SAFE)
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.461 -0400", hash_original_method = "9E9163C05D7336A6FE9DFAB379443860", hash_generated_method = "DEACF2098C53A3985597EF572E39742E")
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
                                boolean varD8866BE17E7C5DE27AE1021BF41F371D_614176197 = (ringingCall.getState() == Call.State.WAITING);
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.461 -0400", hash_original_method = "C52D3E5DC20D7F0420DDF7517152D94F", hash_generated_method = "7E4613D7D26D849C37C85C1E4C8930A3")
            @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.461 -0400", hash_original_method = "EB041B636E30FA2F3190616100DC4B14", hash_generated_method = "77F78880FDB279812A7CB1D445B3F3AB")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.461 -0400", hash_original_method = "0957F2328B233DD414C835AB48AD0504", hash_generated_method = "89A393EFEFD018A07ABD1802EED900A3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SipConnection(SipCall owner, SipProfile callee) {
            this(owner, callee, getUriString(callee));
            dsTaint.addTaint(owner.dsTaint);
            dsTaint.addTaint(callee.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.461 -0400", hash_original_method = "57E4C10F499E8E36FDDCF5DF3794947E", hash_generated_method = "1E80E584818CBCD56DFFE43BFBE5044C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String getCnapName() {
            String displayName;
            displayName = mPeer.getDisplayName();
            {
                boolean var02C40A7DE5016C5F8DE44FC4B2A33BB5_1245613800 = (TextUtils.isEmpty(displayName));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //String displayName = mPeer.getDisplayName();
            //return TextUtils.isEmpty(displayName) ? null
                                                  //: displayName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.461 -0400", hash_original_method = "6B6F8D6F29C0FEAF9C52CC30010D6FE2", hash_generated_method = "4DD604397203B26AEA7D0D71974C134E")
        @DSModeled(DSC.SAFE)
        @Override
        public int getNumberPresentation() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return Connection.PRESENTATION_ALLOWED;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.462 -0400", hash_original_method = "14BDBA500BD81C7014F8447F04B9333E", hash_generated_method = "C62469055C60A2ECBCD49281D10ECB00")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.462 -0400", hash_original_method = "62A265BABD2EF644B89898FE1DF3E037", hash_generated_method = "9E45C9BDDC1675A557A7162208B18D7A")
        @DSModeled(DSC.SAFE)
         void acceptCall() throws CallStateException {
            try 
            {
                mSipAudioCall.answerCall(TIMEOUT_ANSWER_CALL);
            } //End block
            catch (SipException e)
            {
                throw new CallStateException("acceptCall(): " + e);
            } //End block
            // ---------- Original Method ----------
            //try {
                //mSipAudioCall.answerCall(TIMEOUT_ANSWER_CALL);
            //} catch (SipException e) {
                //throw new CallStateException("acceptCall(): " + e);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.462 -0400", hash_original_method = "5D5AACCF3178F43A37FA6476F3FA2309", hash_generated_method = "F15B99B6E9AE4CD52EB7A73E4E63BBD6")
        @DSModeled(DSC.SAFE)
         void changeOwner(SipCall owner) {
            dsTaint.addTaint(owner.dsTaint);
            // ---------- Original Method ----------
            //mOwner = owner;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.462 -0400", hash_original_method = "81195A6CBC9B38EAFBB5618CD4E171CB", hash_generated_method = "DC7569CDFE3F709AC886C27FC367122E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         AudioGroup getAudioGroup() {
            AudioGroup var981546C43EB8613D6CBA3E1D77BDCD49_1914762605 = (mSipAudioCall.getAudioGroup());
            return (AudioGroup)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (mSipAudioCall == null) return null;
            //return mSipAudioCall.getAudioGroup();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.462 -0400", hash_original_method = "766A0FDDBD2B3A4E947C7E8FBAB0F165", hash_generated_method = "075ABB04D9D1D10AED860B7A3EFD8312")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.462 -0400", hash_original_method = "DDAA74ADB7976F32813665FE128238CD", hash_generated_method = "619269D843E933C495228D00F4B26C6A")
        @DSModeled(DSC.SAFE)
         void hold() throws CallStateException {
            setState(Call.State.HOLDING);
            try 
            {
                mSipAudioCall.holdCall(TIMEOUT_HOLD_CALL);
            } //End block
            catch (SipException e)
            {
                throw new CallStateException("hold(): " + e);
            } //End block
            // ---------- Original Method ----------
            //setState(Call.State.HOLDING);
            //try {
                //mSipAudioCall.holdCall(TIMEOUT_HOLD_CALL);
            //} catch (SipException e) {
                //throw new CallStateException("hold(): " + e);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.462 -0400", hash_original_method = "F77273A2CD584255814B6B238AF1477E", hash_generated_method = "1F8A1A783D96FB8B7E5CCA909581AA36")
        @DSModeled(DSC.SAFE)
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
                throw new CallStateException("unhold(): " + e);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.462 -0400", hash_original_method = "91B9A79444A0C09E86ABE6F5C7C89706", hash_generated_method = "C86E5527C0580FC8BF401CD14225FE31")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void setMute(boolean muted) {
            dsTaint.addTaint(muted);
            {
                boolean var6B5DA206A9FAB2FBF22E68E89DEB93FC_1670285066 = ((mSipAudioCall != null) && (muted != mSipAudioCall.isMuted()));
                {
                    mSipAudioCall.toggleMute();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if ((mSipAudioCall != null) && (muted != mSipAudioCall.isMuted())) {
                //mSipAudioCall.toggleMute();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.462 -0400", hash_original_method = "E20C6A660C2E35A5253ACCD901B5D855", hash_generated_method = "FB0AB9B4E4E783369E696EBFCF3C8B2F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean getMute() {
            {
                Object var6F96A3C795A4C1621DD07938C9161660_2009547898 = (mSipAudioCall.isMuted());
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return (mSipAudioCall == null) ? false
                                           //: mSipAudioCall.isMuted();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.462 -0400", hash_original_method = "1833AE90ADB0C663418065E2EE17BAF0", hash_generated_method = "29E527997963B0FA375F6D3EDD9D5875")
        @DSModeled(DSC.SAFE)
        @Override
        protected void setState(Call.State state) {
            dsTaint.addTaint(state.dsTaint);
            super.setState(state);
            // ---------- Original Method ----------
            //if (state == mState) return;
            //super.setState(state);
            //mState = state;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.462 -0400", hash_original_method = "0D6E90F055C537B49BE3263741E0D2AC", hash_generated_method = "2C45A968130953684F50AE217B2A2914")
        @DSModeled(DSC.SAFE)
        @Override
        public Call.State getState() {
            return (Call.State)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mState;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.462 -0400", hash_original_method = "0C9900F417D1D38623450F6C44261C8A", hash_generated_method = "4AEB2E923985640C434D2854E56077BB")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean isIncoming() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mIncoming;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.462 -0400", hash_original_method = "FE0C81270397910192F7BF8C9CDDDAB6", hash_generated_method = "0829E466223E4FD478A58B68FE81CBE1")
        @DSModeled(DSC.SAFE)
        @Override
        public String getAddress() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mOriginalNumber;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.462 -0400", hash_original_method = "710C86DFEBE06A4514867B4563DB846F", hash_generated_method = "F4B83AD98C6C5BD9FF0A20689080C256")
        @DSModeled(DSC.SAFE)
        @Override
        public SipCall getCall() {
            return (SipCall)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mOwner;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.462 -0400", hash_original_method = "925322092199D63FE2A7CC7A8AD6AC9C", hash_generated_method = "74D42066AF41CF3290BAA47D19E2F2EC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Phone getPhone() {
            Phone var7DA41FBE381F160D1FEBDCD933026CFD_988936261 = (mOwner.getPhone());
            return (Phone)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mOwner.getPhone();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.463 -0400", hash_original_method = "B35A599F4014F0A4981FF871F70F4B98", hash_generated_method = "F4A2514BA528DFA620FE68A2D790C91A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void hangup() throws CallStateException {
            {
                Log.d(LOG_TAG, "hangup conn: " + mPeer.getUriString()
                        + ": " + mState + ": on phone "
                        + getPhone().getPhoneName());
                {
                    boolean var7A71802BC1B1F87328893952D19337CA_788668200 = (!mState.isAlive());
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
                    throw new CallStateException("hangup(): " + e);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.463 -0400", hash_original_method = "7B400982296D21B9968B9808849E5473", hash_generated_method = "C797AA9AE9C97B94B4829B4BECC0E278")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void separate() throws CallStateException {
            {
                SipCall call;
                boolean var9F2100AEF9AB3C51A66873B7B7B06C45_1298644362 = ((getPhone() == SipPhone.this));
                call = (SipCall) SipPhone.this.getBackgroundCall();
                call = (SipCall) SipPhone.this.getForegroundCall();
                {
                    boolean var06B2F1D0FB9C9B434F76B9D96A375019_1262870848 = (call.getState() != Call.State.IDLE);
                    {
                        throw new CallStateException(
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
        
        protected abstract void onCallEnded(Connection.DisconnectCause cause);

        
        protected abstract void onError(Connection.DisconnectCause cause);

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.463 -0400", hash_original_method = "FAC45A8F53047AFBBF88628CAD98E6D5", hash_generated_method = "02F1D23939EE6E8B3CFA1F5F3AF0F7FF")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.463 -0400", hash_original_method = "5FEE35421FE68DCB9D837EF94FC0CC79", hash_generated_method = "D7396E1876DF6E02072C4B37BD5F094D")
        @DSModeled(DSC.SAFE)
        @Override
        public void onCallBusy(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(call.dsTaint);
            onCallEnded(Connection.DisconnectCause.BUSY);
            // ---------- Original Method ----------
            //onCallEnded(Connection.DisconnectCause.BUSY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.463 -0400", hash_original_method = "7EFF641046EACBCFF45AD18624210100", hash_generated_method = "63A864EC0F96B072E853EF48DBADCC57")
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


    
}


