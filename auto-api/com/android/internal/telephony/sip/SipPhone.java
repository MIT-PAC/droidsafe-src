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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.177 -0400", hash_original_field = "43C9EE3B0858C8409700F8BE9A7CDE24", hash_generated_field = "06E85CBF753C72DF06700CA0D6B37C3F")

    private SipCall ringingCall = new SipCall();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.177 -0400", hash_original_field = "924189678017C6A548527B5A9F52A27F", hash_generated_field = "320FA68B59E86E885480BDC328D988A1")

    private SipCall foregroundCall = new SipCall();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.177 -0400", hash_original_field = "ACF2C40F82F49E1E79919E82F6B27E7B", hash_generated_field = "E67497BDFFD17E2A0DB124112854785A")

    private SipCall backgroundCall = new SipCall();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.177 -0400", hash_original_field = "80F32E3FB2E35C029C679D5FD2362781", hash_generated_field = "E80E46E58FFD30634B7E3BE2973B3395")

    private SipManager mSipManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.177 -0400", hash_original_field = "7DEA788680409024329A69AD3554F7DD", hash_generated_field = "7EAF540B0EC7BBB66B1BAC42709185BB")

    private SipProfile mProfile;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.178 -0400", hash_original_method = "6A0F0B835E49D28418FC90D67BF66C10", hash_generated_method = "169BB17A1C22728C771E38A1BFCFAA31")
      SipPhone(Context context, PhoneNotifier notifier, SipProfile profile) {
        super(context, notifier);
        Log.d(LOG_TAG, "new SipPhone: " + profile.getUriString());
        ringingCall = new SipCall();
        foregroundCall = new SipCall();
        backgroundCall = new SipCall();
        mProfile = profile;
        mSipManager = SipManager.newInstance(context);
        addTaint(notifier.getTaint());
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(LOG_TAG, "new SipPhone: " + profile.getUriString());
        //ringingCall = new SipCall();
        //foregroundCall = new SipCall();
        //backgroundCall = new SipCall();
        //mProfile = profile;
        //mSipManager = SipManager.newInstance(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.179 -0400", hash_original_method = "0022E344F588A86EC51D8DF12CB4CABD", hash_generated_method = "546F3F61C155CE0F75FC377DD67B81EF")
    @Override
    public boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_1522978513 = (o == this);
        } //End collapsed parenthetic
        SipPhone that;
        that = (SipPhone) o;
        boolean var45CE97710469451C578ABB40487B4EE8_1495535740 = (mProfile.getUriString().equals(that.mProfile.getUriString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_292274874 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_292274874;
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (!(o instanceof SipPhone)) return false;
        //SipPhone that = (SipPhone) o;
        //return mProfile.getUriString().equals(that.mProfile.getUriString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.180 -0400", hash_original_method = "87B6F28FD5B3DEC2F08CA48119477808", hash_generated_method = "D6F0FA55282B49536DFC25CDA9B8221E")
    public String getPhoneName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1591713916 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1591713916 = "SIP:" + getUriString(mProfile);
        varB4EAC82CA7396A68D541C85D26508E83_1591713916.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1591713916;
        // ---------- Original Method ----------
        //return "SIP:" + getUriString(mProfile);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.180 -0400", hash_original_method = "AD1E8A0332F840602A7373ACA5D5D1A0", hash_generated_method = "058DDCD31936A1B6482FE76D0447ECA9")
    public String getSipUri() {
        String varB4EAC82CA7396A68D541C85D26508E83_188548557 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_188548557 = mProfile.getUriString();
        varB4EAC82CA7396A68D541C85D26508E83_188548557.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_188548557;
        // ---------- Original Method ----------
        //return mProfile.getUriString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.190 -0400", hash_original_method = "D3C5F9763476A8D0E8037A369F8C496C", hash_generated_method = "12DC883EAB552E4E0AFB246B21EA777B")
    public boolean equals(SipPhone phone) {
        boolean varB170C7409F6B913400034BFCA292A56F_1583215841 = (getSipUri().equals(phone.getSipUri()));
        addTaint(phone.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1818047790 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1818047790;
        // ---------- Original Method ----------
        //return getSipUri().equals(phone.getSipUri());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.191 -0400", hash_original_method = "520B082FC4D55C78B63B25D36AD6E406", hash_generated_method = "D00105AC92EAC014F48BD046E9784030")
    public boolean canTake(Object incomingCall) {
        {
            {
                boolean varE01C4545931A62F4FC941738A7A28D5F_1372753832 = (ringingCall.getState().isAlive());
            } //End collapsed parenthetic
            {
                boolean var5F3F3054BBF953B9D43A6A67CF0D2F18_694694680 = (foregroundCall.getState().isAlive()
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
                    boolean varAFFEC3E610279996536BBDBBD3DBA5A6_1249344347 = (localUri.equals(mProfile.getUriString()));
                    {
                        boolean makeCallWait;
                        makeCallWait = foregroundCall.getState().isAlive();
                        ringingCall.initIncomingCall(sipAudioCall, makeCallWait);
                        {
                            boolean var83E8B86F2BE04FBC6538BB9432DC8A6D_1904171559 = (sipAudioCall.getState()
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
        addTaint(incomingCall.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2113173811 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2113173811;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.192 -0400", hash_original_method = "4D3FC14BD1B17CB217053014BC4D74B6", hash_generated_method = "3B288A9F94BA49BA20D61E9146DFBCD5")
    public void acceptCall() throws CallStateException {
        {
            {
                boolean varE0C61107F4B1A5D76C43D42CFA8103F3_1022552344 = ((ringingCall.getState() == Call.State.INCOMING) ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.192 -0400", hash_original_method = "F60D4B1A0C339762A597DB11EC122CEA", hash_generated_method = "D1EF979FDD7FC97E5EF665BE732B63DB")
    public void rejectCall() throws CallStateException {
        {
            {
                boolean var442D0F0D7EEA6963AE66B13292492B00_277500885 = (ringingCall.getState().isRinging());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.192 -0400", hash_original_method = "01C657A55270F6B259EE4CA2295CF206", hash_generated_method = "9583B0D7568DA52ECE17835FF1AA85EB")
    public Connection dial(String dialString) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_1765450805 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1765450805 = dialInternal(dialString);
        } //End block
        addTaint(dialString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1765450805.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1765450805;
        // ---------- Original Method ----------
        //synchronized (SipPhone.class) {
            //return dialInternal(dialString);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.228 -0400", hash_original_method = "E69019A31CF45F3F0FFB8952555ADD38", hash_generated_method = "CB4B93D3A187E139762BAB6CF811F10C")
    private Connection dialInternal(String dialString) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_221560066 = null; //Variable for return #1
        clearDisconnected();
        {
            boolean var37336DD64F87D8D8C5FEC219FB8725E9_209831122 = (!canDial());
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("cannot dial in current state");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varC33489E5DEA37065C5D9027B98F53E39_1090494730 = (foregroundCall.getState() == SipCall.State.ACTIVE);
            {
                switchHoldingAndActive();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAA5B136BDA3FB7DD22D11F146CB8E62A_1754490623 = (foregroundCall.getState() != SipCall.State.IDLE);
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("cannot dial in current state");
            } //End block
        } //End collapsed parenthetic
        foregroundCall.setMute(false);
        try 
        {
            Connection c;
            c = foregroundCall.dial(dialString);
            varB4EAC82CA7396A68D541C85D26508E83_221560066 = c;
        } //End block
        catch (SipException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new CallStateException("dial error: " + e);
        } //End block
        addTaint(dialString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_221560066.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_221560066;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.229 -0400", hash_original_method = "04453A8FBCEE87A03C8D7EC224934C23", hash_generated_method = "540E076F6774D195762021374EEE46E9")
    public void switchHoldingAndActive() throws CallStateException {
        Log.d(LOG_TAG, " ~~~~~~  switch fg and bg");
        {
            foregroundCall.switchWith(backgroundCall);
            {
                boolean varA0AFA2B7E4A73D22BA12DB013063960D_2027118415 = (backgroundCall.getState().isAlive());
                backgroundCall.hold();
            } //End collapsed parenthetic
            {
                boolean var63B388EA3D8161389B434AC6220A05EB_1253016136 = (foregroundCall.getState().isAlive());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.229 -0400", hash_original_method = "EF99002349D3FD6EFA7BC51A1FE3E619", hash_generated_method = "BE11E289DF21FE0E0FD756FFA515D2B8")
    public boolean canConference() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_707836398 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_707836398;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.230 -0400", hash_original_method = "5DC11CA56E4A18B2CAABC2999FA181D0", hash_generated_method = "31EAE79114E4E08888FDFC18C0B7137C")
    public void conference() throws CallStateException {
        {
            {
                boolean varA1285B741C70BDCFD1DA6690E8723FC5_501226298 = ((foregroundCall.getState() != SipCall.State.ACTIVE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.230 -0400", hash_original_method = "0BA61BE71F93F0627212F9F9B5CF61C9", hash_generated_method = "A57E181C80CE334156A9B0F6BCE8F2D0")
    public void conference(Call that) throws CallStateException {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("expect " + SipCall.class
                        + ", cannot merge with " + that.getClass());
            } //End block
            foregroundCall.merge((SipCall) that);
        } //End block
        addTaint(that.getTaint());
        // ---------- Original Method ----------
        //synchronized (SipPhone.class) {
            //if (!(that instanceof SipCall)) {
                //throw new CallStateException("expect " + SipCall.class
                        //+ ", cannot merge with " + that.getClass());
            //}
            //foregroundCall.merge((SipCall) that);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.231 -0400", hash_original_method = "FB85D9DE1C816CCA93C5FDAD3D9D0A31", hash_generated_method = "B523CCC800DFFD9036E365DA9B758703")
    public boolean canTransfer() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1037381914 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1037381914;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.232 -0400", hash_original_method = "6F3E620B44779BFD9D290EDD6A721C13", hash_generated_method = "1802EA65B8D1F27F1F2A77F464C12952")
    public void explicitCallTransfer() throws CallStateException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.232 -0400", hash_original_method = "D9CD8A34486E399CFA818246637B2970", hash_generated_method = "10069112F50F91D6CB32445A67763FB6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.233 -0400", hash_original_method = "D682F8DE86633D8037AE8DB7A99E0997", hash_generated_method = "6D2E3C50B022BFC96C16A0942CB81F42")
    public void sendDtmf(char c) {
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_927276291 = (!PhoneNumberUtils.is12Key(c));
            {
                boolean var63B388EA3D8161389B434AC6220A05EB_1473946571 = (foregroundCall.getState().isAlive());
                {
                    {
                        foregroundCall.sendDtmf(c);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(c);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.236 -0400", hash_original_method = "C805BAC519448AC91DEA3466C2A972EF", hash_generated_method = "B0730A36B4482F54F75A080F0C3A3B42")
    public void startDtmf(char c) {
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_805877692 = (!PhoneNumberUtils.is12Key(c));
            {
                sendDtmf(c);
            } //End block
        } //End collapsed parenthetic
        addTaint(c);
        // ---------- Original Method ----------
        //if (!PhoneNumberUtils.is12Key(c)) {
            //Log.e(LOG_TAG,
                //"startDtmf called with invalid character '" + c + "'");
        //} else {
            //sendDtmf(c);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.236 -0400", hash_original_method = "1D5D5FD426DB2358E4E86A174C44532E", hash_generated_method = "28A2AD6EB5F0534AB0CED744A3051E3F")
    public void stopDtmf() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.236 -0400", hash_original_method = "9189F1384120EC6E17589215617F3507", hash_generated_method = "FC98764535C47C26D37CAD332C70ED81")
    public void sendBurstDtmf(String dtmfString) {
        addTaint(dtmfString.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SipPhone] sendBurstDtmf() is a CDMA method");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.242 -0400", hash_original_method = "0D09CB6308056457AD1772B2CC5B82FC", hash_generated_method = "C77A6C0124D697FB86089997222C4675")
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.243 -0400", hash_original_method = "56612EF91DCB9A3808F62E57BF0F81E1", hash_generated_method = "2C0642AA3E03137941721F3C03DDB4F0")
    public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode,
                                           Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        addTaint(commandInterfaceCLIRMode);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.243 -0400", hash_original_method = "14E36FB03F40D4635F36E46C38B086BD", hash_generated_method = "70097558DD3E9A395DC3205B46BB4114")
    public void getCallWaiting(Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.243 -0400", hash_original_method = "80F9B6F2C3F4CA6200C97C4377273E17", hash_generated_method = "09886D350A4FBA76C7FD0C69B3160FBC")
    public void setCallWaiting(boolean enable, Message onComplete) {
        addTaint(enable);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "call waiting not supported");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.246 -0400", hash_original_method = "6F81D9304F797B487FC34D43FAF41E44", hash_generated_method = "6460E809D25C2872BE4C9D5E90D54D8F")
    @Override
    public void setEchoSuppressionEnabled(boolean enabled) {
        {
            foregroundCall.setAudioGroupMode();
        } //End block
        addTaint(enabled);
        // ---------- Original Method ----------
        //synchronized (SipPhone.class) {
            //foregroundCall.setAudioGroupMode();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.257 -0400", hash_original_method = "79AC444E8066EFF34D5F76D19E8CCACC", hash_generated_method = "FA0D62EBB9B3488AEB271C49BB96D62F")
    public void setMute(boolean muted) {
        {
            foregroundCall.setMute(muted);
        } //End block
        addTaint(muted);
        // ---------- Original Method ----------
        //synchronized (SipPhone.class) {
            //foregroundCall.setMute(muted);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.258 -0400", hash_original_method = "8292EC8FC0222DDB10381F21089BC299", hash_generated_method = "3B495751C0ADC2920558F65C0D55DE7E")
    public boolean getMute() {
        boolean var0736EE6D751830E03BA1FD8749498A0A_474844335 = ((foregroundCall.getState().isAlive()
                ? foregroundCall.getMute()
                : backgroundCall.getMute())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1706343286 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1706343286;
        // ---------- Original Method ----------
        //return (foregroundCall.getState().isAlive()
                //? foregroundCall.getMute()
                //: backgroundCall.getMute());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.259 -0400", hash_original_method = "9DE1B547D23B96DA44E5E5850535D15C", hash_generated_method = "CD715E3E105EE5CA2625BE4DD4EF1A31")
    public Call getForegroundCall() {
        Call varB4EAC82CA7396A68D541C85D26508E83_1061748315 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1061748315 = foregroundCall;
        varB4EAC82CA7396A68D541C85D26508E83_1061748315.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1061748315;
        // ---------- Original Method ----------
        //return foregroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.259 -0400", hash_original_method = "EADE59B65D242AA2A5BCB126522780FD", hash_generated_method = "10FBB0EE3B76CAE6266CBAD20453FABC")
    public Call getBackgroundCall() {
        Call varB4EAC82CA7396A68D541C85D26508E83_1182163547 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1182163547 = backgroundCall;
        varB4EAC82CA7396A68D541C85D26508E83_1182163547.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1182163547;
        // ---------- Original Method ----------
        //return backgroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.263 -0400", hash_original_method = "3A1E9C8D795C10065E3EA9FCAA0EB60D", hash_generated_method = "84B613A2B1AC16A11060456B9822C01D")
    public Call getRingingCall() {
        Call varB4EAC82CA7396A68D541C85D26508E83_882069145 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_882069145 = ringingCall;
        varB4EAC82CA7396A68D541C85D26508E83_882069145.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_882069145;
        // ---------- Original Method ----------
        //return ringingCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.271 -0400", hash_original_method = "88DBA8231EA7F3BE9C495A0C37514173", hash_generated_method = "3456A2EBC58B77CB801847CF467D4A61")
    public ServiceState getServiceState() {
        ServiceState varB4EAC82CA7396A68D541C85D26508E83_1263549632 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1263549632 = super.getServiceState();
        varB4EAC82CA7396A68D541C85D26508E83_1263549632.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1263549632;
        // ---------- Original Method ----------
        //return super.getServiceState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.272 -0400", hash_original_method = "AE09BA0335289F025B1DDE67D4558A7A", hash_generated_method = "696D381A95484C35B29FA45F123F25CC")
    private String getUriString(SipProfile p) {
        String varB4EAC82CA7396A68D541C85D26508E83_2012256496 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2012256496 = p.getUserName() + "@" + getSipDomain(p);
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2012256496.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2012256496;
        // ---------- Original Method ----------
        //return p.getUserName() + "@" + getSipDomain(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.273 -0400", hash_original_method = "CF1C8708B65050BDE73A571BB1592129", hash_generated_method = "4E07E987D5633C9FCB3204765F6739BB")
    private String getSipDomain(SipProfile p) {
        String varB4EAC82CA7396A68D541C85D26508E83_1342592951 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1015763911 = null; //Variable for return #2
        String domain;
        domain = p.getSipDomain();
        {
            boolean var58ED1E8F1C86F4A4907BDF2FED167062_2071335122 = (domain.endsWith(":5060"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1342592951 = domain.substring(0, domain.length() - 5);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1015763911 = domain;
            } //End block
        } //End collapsed parenthetic
        addTaint(p.getTaint());
        String varA7E53CE21691AB073D9660D615818899_2060684259; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2060684259 = varB4EAC82CA7396A68D541C85D26508E83_1342592951;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2060684259 = varB4EAC82CA7396A68D541C85D26508E83_1015763911;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2060684259.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2060684259;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.274 -0400", hash_original_method = "00F055312A0CF21C4F0B5574B16ECF8F", hash_generated_method = "00F055312A0CF21C4F0B5574B16ECF8F")
        public SipCall ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.284 -0400", hash_original_method = "077C3D2ABFDDE04A697972D273B811AD", hash_generated_method = "AFC116FB336DFDAE16FA5C7A5CE7B964")
         void reset() {
            connections.clear();
            setState(Call.State.IDLE);
            // ---------- Original Method ----------
            //connections.clear();
            //setState(Call.State.IDLE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.284 -0400", hash_original_method = "375D19E8671ADDF3312252661F52306D", hash_generated_method = "5AF6FE1AFA7E6D8A76884E046E0A4732")
         void switchWith(SipCall that) {
            {
                SipCall tmp;
                tmp = new SipCall();
                tmp.takeOver(this);
                this.takeOver(that);
                that.takeOver(tmp);
            } //End block
            addTaint(that.getTaint());
            // ---------- Original Method ----------
            //synchronized (SipPhone.class) {
                //SipCall tmp = new SipCall();
                //tmp.takeOver(this);
                //this.takeOver(that);
                //that.takeOver(tmp);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.311 -0400", hash_original_method = "1E912254ED378DFE25D6B6FABA0CA461", hash_generated_method = "FA24B4345B8F5AA285BB5F76E6ABB4FE")
        private void takeOver(SipCall that) {
            connections = that.connections;
            state = that.state;
            {
                Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_77184594 = (connections).iterator();
                varE43AC770406DBA1185F3DAFDE696E6A3_77184594.hasNext();
                Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_77184594.next();
                {
                    ((SipConnection) c).changeOwner(this);
                } //End block
            } //End collapsed parenthetic
            addTaint(that.getTaint());
            // ---------- Original Method ----------
            //connections = that.connections;
            //state = that.state;
            //for (Connection c : connections) {
                //((SipConnection) c).changeOwner(this);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.322 -0400", hash_original_method = "BB25C6B7E2DC41EA59445495652EDD92", hash_generated_method = "331F4B67765EE65E27F1AC2AD4AF598A")
        @Override
        public Phone getPhone() {
            Phone varB4EAC82CA7396A68D541C85D26508E83_1310611810 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1310611810 = SipPhone.this;
            varB4EAC82CA7396A68D541C85D26508E83_1310611810.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1310611810;
            // ---------- Original Method ----------
            //return SipPhone.this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.324 -0400", hash_original_method = "B38C364E01AF490301B03DAE11EB1509", hash_generated_method = "D357F114B1F5231253FECE579B2539C4")
        @Override
        public List<Connection> getConnections() {
            List<Connection> varB4EAC82CA7396A68D541C85D26508E83_595150512 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_595150512 = connections;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_595150512.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_595150512;
            // ---------- Original Method ----------
            //synchronized (SipPhone.class) {
                //return connections;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.324 -0400", hash_original_method = "B9E3A4EF80D99D71D1AE567F3438F945", hash_generated_method = "0F61B854F6D35B0E7CCE00B0D0ADB6C6")
         Connection dial(String originalNumber) throws SipException {
            Connection varB4EAC82CA7396A68D541C85D26508E83_412054993 = null; //Variable for return #1
            String calleeSipUri;
            calleeSipUri = originalNumber;
            {
                boolean var48F7791BB77ABFAC0D24C5A43EB83BC0_1861292882 = (!calleeSipUri.contains("@"));
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
                varB4EAC82CA7396A68D541C85D26508E83_412054993 = c;
            } //End block
            catch (ParseException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("dial", e);
            } //End block
            addTaint(originalNumber.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_412054993.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_412054993;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.465 -0400", hash_original_method = "F3785C840BD99E8D755659453D00493E", hash_generated_method = "90F8B05F81506A6F4985FEEF4682EE6E")
        @Override
        public void hangup() throws CallStateException {
            {
                {
                    boolean var8998223C0389365AC10BB9EB481CFC6F_353014395 = (state.isAlive());
                    {
                        Log.d(LOG_TAG, "hang up call: " + getState()
                            + ": " + this + " on phone " + getPhone());
                        setState(State.DISCONNECTING);
                        CallStateException excp;
                        excp = null;
                        {
                            Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_576091983 = (connections).iterator();
                            varE43AC770406DBA1185F3DAFDE696E6A3_576091983.hasNext();
                            Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_576091983.next();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.469 -0400", hash_original_method = "03E5A9484BF2B2B8056B6450938A40D7", hash_generated_method = "2CB8B7D1E8802DC18665BAAF1367214C")
         void initIncomingCall(SipAudioCall sipAudioCall, boolean makeCallWait) {
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
            addTaint(sipAudioCall.getTaint());
            addTaint(makeCallWait);
            // ---------- Original Method ----------
            //SipProfile callee = sipAudioCall.getPeerProfile();
            //SipConnection c = new SipConnection(this, callee);
            //connections.add(c);
            //Call.State newState = makeCallWait ? State.WAITING : State.INCOMING;
            //c.initIncomingCall(sipAudioCall, newState);
            //setState(newState);
            //notifyNewRingingConnectionP(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.474 -0400", hash_original_method = "F8072C3AD3C86AEC184FDD0C13B73AA0", hash_generated_method = "D7F0174B5C634AAAD4965899108AA01C")
         void rejectCall() throws CallStateException {
            hangup();
            // ---------- Original Method ----------
            //hangup();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.475 -0400", hash_original_method = "B2C3B5FE3154049893EC854E60F79D8F", hash_generated_method = "F907E56975C2C7F428B1BA47BC5C892D")
         void acceptCall() throws CallStateException {
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("acceptCall() in a non-ringing call");
            } //End block
            {
                boolean var9C09519F85FF3FA6D687EF8338B33839_2050842318 = (connections.size() != 1);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.475 -0400", hash_original_method = "1B6C9A8A7DE7A949D0CD2E188D6FBBDC", hash_generated_method = "BD8A79E08641E4197975B9480073F7CF")
        private boolean isSpeakerOn() {
            boolean var65FC9098A8240679D54D31921AD18341_1358242757 = (((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                    .isSpeakerphoneOn());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_651546116 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_651546116;
            // ---------- Original Method ----------
            //return ((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                    //.isSpeakerphoneOn();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.477 -0400", hash_original_method = "AEEC2C5B8263135991756BF729F3B501", hash_generated_method = "A5E0813C7680E8EC071912A313FE4E3C")
         void setAudioGroupMode() {
            AudioGroup audioGroup;
            audioGroup = getAudioGroup();
            int mode;
            mode = audioGroup.getMode();
            {
                audioGroup.setMode(AudioGroup.MODE_ON_HOLD);
            } //End block
            {
                boolean varF8A7F4F0125E77611C619BF6F6178B3E_1432074007 = (getMute());
                {
                    audioGroup.setMode(AudioGroup.MODE_MUTED);
                } //End block
                {
                    boolean var43978F0EAC26602D234D59271C57818C_1555662496 = (isSpeakerOn());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.505 -0400", hash_original_method = "A3EB25D5FFDA71466ECC0EEF32C97EE3", hash_generated_method = "37EBAD8DFB88771DCC1C83B153F6D50A")
         void hold() throws CallStateException {
            setState(State.HOLDING);
            {
                Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_1095935611 = (connections).iterator();
                varE43AC770406DBA1185F3DAFDE696E6A3_1095935611.hasNext();
                Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_1095935611.next();
                ((SipConnection) c).hold();
            } //End collapsed parenthetic
            setAudioGroupMode();
            // ---------- Original Method ----------
            //setState(State.HOLDING);
            //for (Connection c : connections) ((SipConnection) c).hold();
            //setAudioGroupMode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.530 -0400", hash_original_method = "9A7CCBA25036980309C5282A2982C0B2", hash_generated_method = "46B9F43EFBEBDA34D7D53F1BD51FBDEB")
         void unhold() throws CallStateException {
            setState(State.ACTIVE);
            AudioGroup audioGroup;
            audioGroup = new AudioGroup();
            {
                Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_1401951734 = (connections).iterator();
                varE43AC770406DBA1185F3DAFDE696E6A3_1401951734.hasNext();
                Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_1401951734.next();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.565 -0400", hash_original_method = "7DDE83D6F9C645A60E86EBEFB92BE589", hash_generated_method = "39825D5A7CA1103D35A883A096385028")
         void setMute(boolean muted) {
            {
                Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_2029474308 = (connections).iterator();
                varE43AC770406DBA1185F3DAFDE696E6A3_2029474308.hasNext();
                Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_2029474308.next();
                {
                    ((SipConnection) c).setMute(muted);
                } //End block
            } //End collapsed parenthetic
            addTaint(muted);
            // ---------- Original Method ----------
            //for (Connection c : connections) {
                //((SipConnection) c).setMute(muted);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.566 -0400", hash_original_method = "B414CA4B3846B73054EF059A06E7BBBE", hash_generated_method = "65FDBFD53D4195C14AE9C2C65844FF99")
         boolean getMute() {
            {
                boolean var9D37F75EA12D86F1A0D608B063CA8508_1138579652 = (connections.isEmpty());
                Object var30144DAD28DB69F770D2D62A9F08E471_1792024180 = (((SipConnection) connections.get(0)).getMute());
            } //End flattened ternary
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_61521563 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_61521563;
            // ---------- Original Method ----------
            //return connections.isEmpty()
                    //? false
                    //: ((SipConnection) connections.get(0)).getMute();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.604 -0400", hash_original_method = "C6685F4BB929C317D55EF29FDD744317", hash_generated_method = "63316935E52092D4E57A5DCAAB9D9F5C")
         void merge(SipCall that) throws CallStateException {
            AudioGroup audioGroup;
            audioGroup = getAudioGroup();
            Connection[] cc;
            cc = that.connections.toArray(
                    new Connection[that.connections.size()]);
            {
                Iterator<Connection> var16A6B749ACBB853D545509F9EB1B6960_118005510 = (cc).iterator();
                var16A6B749ACBB853D545509F9EB1B6960_118005510.hasNext();
                Connection c = var16A6B749ACBB853D545509F9EB1B6960_118005510.next();
                {
                    SipConnection conn;
                    conn = (SipConnection) c;
                    add(conn);
                    {
                        boolean var0F3E8D2D4CC8A5C0357E07264342DA94_313799071 = (conn.getState() == Call.State.HOLDING);
                        {
                            conn.unhold(audioGroup);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            that.setState(Call.State.IDLE);
            addTaint(that.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.607 -0400", hash_original_method = "C804E92B54898C48FBC0803D66022DE0", hash_generated_method = "12EA54E0D632107809067D4B7A471CCD")
        private void add(SipConnection conn) {
            SipCall call;
            call = conn.getCall();
            {
                boolean varB8F4F262BFDCEFC335F4E56671E9F1DA_214375547 = (call == this);
            } //End collapsed parenthetic
            call.connections.remove(conn);
            connections.add(conn);
            conn.changeOwner(this);
            addTaint(conn.getTaint());
            // ---------- Original Method ----------
            //SipCall call = conn.getCall();
            //if (call == this) return;
            //if (call != null) call.connections.remove(conn);
            //connections.add(conn);
            //conn.changeOwner(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.608 -0400", hash_original_method = "994C45B8BD8978A705E69F1BE351A00B", hash_generated_method = "1FD2B146910BB84D3518A07B86A7D37E")
         void sendDtmf(char c) {
            AudioGroup audioGroup;
            audioGroup = getAudioGroup();
            audioGroup.sendDtmf(convertDtmf(c));
            addTaint(c);
            // ---------- Original Method ----------
            //AudioGroup audioGroup = getAudioGroup();
            //if (audioGroup == null) return;
            //audioGroup.sendDtmf(convertDtmf(c));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.608 -0400", hash_original_method = "C4229E0DAB0B84D6720429F368FEF1C3", hash_generated_method = "33EC10E30F10CAEFBCF14524572BA0EF")
        private int convertDtmf(char c) {
            int code;
            code = c - '0';
            {
                //Begin case default 
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "invalid DTMF char: " + (int) c);
                //End case default 
            } //End block
            addTaint(c);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_986555684 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_986555684;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.617 -0400", hash_original_method = "A20E6ED570A38BE2669CFE3ED9219E0D", hash_generated_method = "FCDE0DF59BA2F85CBAA4E2866169FE95")
        @Override
        protected void setState(State newState) {
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
            addTaint(newState.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.617 -0400", hash_original_method = "9B48819375B09AF6C57EC0D05234CB41", hash_generated_method = "990CC098C4D7C3DE6BBB9AAC0FCC900A")
         void onConnectionStateChanged(SipConnection conn) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                setState(conn.getState());
            } //End block
            addTaint(conn.getTaint());
            // ---------- Original Method ----------
            //if (state != State.ACTIVE) {
                //setState(conn.getState());
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.674 -0400", hash_original_method = "67A791C264A58046C696AC400E0B1106", hash_generated_method = "4142F6377B1BDFC80A77C48CC50662CD")
         void onConnectionEnded(SipConnection conn) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean allConnectionsDisconnected;
                allConnectionsDisconnected = true;
                Log.d(LOG_TAG, "---check connections: "
                        + connections.size());
                {
                    Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_824469841 = (connections).iterator();
                    varE43AC770406DBA1185F3DAFDE696E6A3_824469841.hasNext();
                    Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_824469841.next();
                    {
                        Log.d(LOG_TAG, "   state=" + c.getState() + ": "
                            + c);
                        {
                            boolean varCAA7A57C3F38B59482436E96FBF861E4_2104133096 = (c.getState() != State.DISCONNECTED);
                            {
                                allConnectionsDisconnected = false;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                setState(State.DISCONNECTED);
            } //End block
            notifyDisconnectP(conn);
            addTaint(conn.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.680 -0400", hash_original_method = "3BDED5D4E6618481393AD33B1F728E6A", hash_generated_method = "724EC38B855E373C16B585AFC25DD09C")
        private AudioGroup getAudioGroup() {
            AudioGroup varB4EAC82CA7396A68D541C85D26508E83_1561430334 = null; //Variable for return #1
            AudioGroup varB4EAC82CA7396A68D541C85D26508E83_549247563 = null; //Variable for return #2
            {
                boolean var9D37F75EA12D86F1A0D608B063CA8508_499316288 = (connections.isEmpty());
                varB4EAC82CA7396A68D541C85D26508E83_1561430334 = null;
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_549247563 = ((SipConnection) connections.get(0)).getAudioGroup();
            AudioGroup varA7E53CE21691AB073D9660D615818899_1761109433; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1761109433 = varB4EAC82CA7396A68D541C85D26508E83_1561430334;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1761109433 = varB4EAC82CA7396A68D541C85D26508E83_549247563;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1761109433.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1761109433;
            // ---------- Original Method ----------
            //if (connections.isEmpty()) return null;
            //return ((SipConnection) connections.get(0)).getAudioGroup();
        }

        
    }


    
    private class SipConnection extends SipConnectionBase {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.682 -0400", hash_original_field = "4AA3D5C224CE197897B9C6F17BF367CD", hash_generated_field = "D7165953848BB574FCA583AB16464D4F")

        private SipCall mOwner;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.682 -0400", hash_original_field = "DF701BED26C9A6E82B434D3ADA19F19A", hash_generated_field = "D1359B5A0587476130FC171DA764AC68")

        private SipAudioCall mSipAudioCall;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.682 -0400", hash_original_field = "9E8FCF5D95B61569BEBFA55673940468", hash_generated_field = "DFC050C51766232BD82C770760A2DF3D")

        private Call.State mState = Call.State.IDLE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.682 -0400", hash_original_field = "6F401FEEE3A56ED571384DFAB76AA449", hash_generated_field = "06F960DE9AD1B3C2161E1D3DDDEEE930")

        private SipProfile mPeer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.682 -0400", hash_original_field = "44366EF9F63882F1E47C480ECB6765BD", hash_generated_field = "EC5248A9D1818320AA647E3B388AFC57")

        private String mOriginalNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.682 -0400", hash_original_field = "08E4E08A45FD9BD63A8B432D59B0CB98", hash_generated_field = "CEABB36F0D8DD49AB2FFAD188EF64025")

        private boolean mIncoming = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.696 -0400", hash_original_field = "AC67C5E32EF946C45E856E56B7F86834", hash_generated_field = "21DD7635064A7B44D35C5D5770F685A6")

        private SipAudioCallAdapter mAdapter = new SipAudioCallAdapter() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.684 -0400", hash_original_method = "B8BAADEA0DE266294E2369B45E53A7F4", hash_generated_method = "F842BBDDFD950AC1AAF8B1ED6A31C24A")
            @Override
            protected void onCallEnded(DisconnectCause cause) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                {
                    boolean var3317223ED0C152EA0F03D574707E1DAC_1063074218 = (getDisconnectCause() != DisconnectCause.LOCAL);
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
                addTaint(cause.getTaint());
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.687 -0400", hash_original_method = "52733E1CC76DBF11A64B0250C617E7AC", hash_generated_method = "F34A5EF95CCC3389960527B60C4F7AE9")
            @Override
            public void onCallEstablished(SipAudioCall call) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                onChanged(call);
                call.startAudio();
                addTaint(call.getTaint());
                // ---------- Original Method ----------
                //onChanged(call);
                //if (mState == Call.State.ACTIVE) call.startAudio();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.688 -0400", hash_original_method = "AC053A33592EEF445C9BE357836B4C16", hash_generated_method = "A5F097A8319E3CB02B505B72B427FB45")
            @Override
            public void onCallHeld(SipAudioCall call) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                onChanged(call);
                call.startAudio();
                addTaint(call.getTaint());
                // ---------- Original Method ----------
                //onChanged(call);
                //if (mState == Call.State.HOLDING) call.startAudio();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.692 -0400", hash_original_method = "9E9163C05D7336A6FE9DFAB379443860", hash_generated_method = "384B9F93A14788B7E77D7EEF68D593DD")
            @Override
            public void onChanged(SipAudioCall call) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                {
                    Call.State newState;
                    newState = getCallStateFrom(call);
                    {
                        setState(mOwner.getState());
                    } //End block
                    {
                        {
                            {
                                boolean varD8866BE17E7C5DE27AE1021BF41F371D_221814970 = (ringingCall.getState() == Call.State.WAITING);
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
                addTaint(call.getTaint());
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.696 -0400", hash_original_method = "C52D3E5DC20D7F0420DDF7517152D94F", hash_generated_method = "22119F567079DA28DBBFC4AA0120E473")
            @Override
            protected void onError(DisconnectCause cause) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                Log.d(LOG_TAG, "SIP error: " + cause);
                onCallEnded(cause);
                addTaint(cause.getTaint());
                // ---------- Original Method ----------
                //if (DEBUG) Log.d(LOG_TAG, "SIP error: " + cause);
                //onCallEnded(cause);
            }

            
};
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.697 -0400", hash_original_method = "EB041B636E30FA2F3190616100DC4B14", hash_generated_method = "D02AEE3D5DDE08332E361E5B938B30A9")
        public  SipConnection(SipCall owner, SipProfile callee,
                String originalNumber) {
            super(originalNumber);
            mOwner = owner;
            mPeer = callee;
            mOriginalNumber = originalNumber;
            // ---------- Original Method ----------
            //mOwner = owner;
            //mPeer = callee;
            //mOriginalNumber = originalNumber;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.706 -0400", hash_original_method = "0957F2328B233DD414C835AB48AD0504", hash_generated_method = "F22895157E71840C75F8BC0F1E6A9DB8")
        public  SipConnection(SipCall owner, SipProfile callee) {
            this(owner, callee, getUriString(callee));
            addTaint(owner.getTaint());
            addTaint(callee.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.706 -0400", hash_original_method = "57E4C10F499E8E36FDDCF5DF3794947E", hash_generated_method = "1CC968E06C3B073B2F4114861295FFBA")
        @Override
        public String getCnapName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1162422752 = null; //Variable for return #1
            String displayName;
            displayName = mPeer.getDisplayName();
            varB4EAC82CA7396A68D541C85D26508E83_1162422752 = TextUtils.isEmpty(displayName) ? null
                                                  : displayName;
            varB4EAC82CA7396A68D541C85D26508E83_1162422752.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1162422752;
            // ---------- Original Method ----------
            //String displayName = mPeer.getDisplayName();
            //return TextUtils.isEmpty(displayName) ? null
                                                  //: displayName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.707 -0400", hash_original_method = "6B6F8D6F29C0FEAF9C52CC30010D6FE2", hash_generated_method = "E89AB0C1D056C8FCB8D358E2B1475678")
        @Override
        public int getNumberPresentation() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_840376579 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_840376579;
            // ---------- Original Method ----------
            //return Connection.PRESENTATION_ALLOWED;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.707 -0400", hash_original_method = "14BDBA500BD81C7014F8447F04B9333E", hash_generated_method = "C343C83C3F139AA3E8AD1000032FDE5F")
         void initIncomingCall(SipAudioCall sipAudioCall, Call.State newState) {
            setState(newState);
            mSipAudioCall = sipAudioCall;
            sipAudioCall.setListener(mAdapter);
            mIncoming = true;
            addTaint(newState.getTaint());
            // ---------- Original Method ----------
            //setState(newState);
            //mSipAudioCall = sipAudioCall;
            //sipAudioCall.setListener(mAdapter);
            //mIncoming = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.707 -0400", hash_original_method = "62A265BABD2EF644B89898FE1DF3E037", hash_generated_method = "E88D0586F9497F58EC7DB8C51FD62A85")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.708 -0400", hash_original_method = "5D5AACCF3178F43A37FA6476F3FA2309", hash_generated_method = "F4F212B9E8EECDAFB8ECD3B21BCA89BD")
         void changeOwner(SipCall owner) {
            mOwner = owner;
            // ---------- Original Method ----------
            //mOwner = owner;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.712 -0400", hash_original_method = "81195A6CBC9B38EAFBB5618CD4E171CB", hash_generated_method = "D2957CC81A9FF3ADEC276CA4DFFC6D20")
         AudioGroup getAudioGroup() {
            AudioGroup varB4EAC82CA7396A68D541C85D26508E83_269122555 = null; //Variable for return #1
            AudioGroup varB4EAC82CA7396A68D541C85D26508E83_970624957 = null; //Variable for return #2
            varB4EAC82CA7396A68D541C85D26508E83_269122555 = null;
            varB4EAC82CA7396A68D541C85D26508E83_970624957 = mSipAudioCall.getAudioGroup();
            AudioGroup varA7E53CE21691AB073D9660D615818899_412638024; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_412638024 = varB4EAC82CA7396A68D541C85D26508E83_269122555;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_412638024 = varB4EAC82CA7396A68D541C85D26508E83_970624957;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_412638024.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_412638024;
            // ---------- Original Method ----------
            //if (mSipAudioCall == null) return null;
            //return mSipAudioCall.getAudioGroup();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.712 -0400", hash_original_method = "766A0FDDBD2B3A4E947C7E8FBAB0F165", hash_generated_method = "93C009E595843D9B5B39352F3D675F51")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.713 -0400", hash_original_method = "DDAA74ADB7976F32813665FE128238CD", hash_generated_method = "BD6ABA7F7127C0C77F83B3BF0D8D517A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.713 -0400", hash_original_method = "F77273A2CD584255814B6B238AF1477E", hash_generated_method = "3DE8BD0BBE2A340A0377B97A1F53C91E")
         void unhold(AudioGroup audioGroup) throws CallStateException {
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
            addTaint(audioGroup.getTaint());
            // ---------- Original Method ----------
            //mSipAudioCall.setAudioGroup(audioGroup);
            //setState(Call.State.ACTIVE);
            //try {
                //mSipAudioCall.continueCall(TIMEOUT_HOLD_CALL);
            //} catch (SipException e) {
                //throw new CallStateException("unhold(): " + e);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.717 -0400", hash_original_method = "91B9A79444A0C09E86ABE6F5C7C89706", hash_generated_method = "7D53E50AB890180848D729F10E64D3BF")
         void setMute(boolean muted) {
            {
                boolean var6B5DA206A9FAB2FBF22E68E89DEB93FC_1762149959 = ((mSipAudioCall != null) && (muted != mSipAudioCall.isMuted()));
                {
                    mSipAudioCall.toggleMute();
                } //End block
            } //End collapsed parenthetic
            addTaint(muted);
            // ---------- Original Method ----------
            //if ((mSipAudioCall != null) && (muted != mSipAudioCall.isMuted())) {
                //mSipAudioCall.toggleMute();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.717 -0400", hash_original_method = "E20C6A660C2E35A5253ACCD901B5D855", hash_generated_method = "5D1D4827FEE05D442E0E1F2E385D5717")
         boolean getMute() {
            {
                Object var6F96A3C795A4C1621DD07938C9161660_1000205618 = (mSipAudioCall.isMuted());
            } //End flattened ternary
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_935796023 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_935796023;
            // ---------- Original Method ----------
            //return (mSipAudioCall == null) ? false
                                           //: mSipAudioCall.isMuted();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.721 -0400", hash_original_method = "1833AE90ADB0C663418065E2EE17BAF0", hash_generated_method = "F7BF78C03975EEB51BBB5EBAECE9F1D9")
        @Override
        protected void setState(Call.State state) {
            super.setState(state);
            mState = state;
            // ---------- Original Method ----------
            //if (state == mState) return;
            //super.setState(state);
            //mState = state;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.721 -0400", hash_original_method = "0D6E90F055C537B49BE3263741E0D2AC", hash_generated_method = "178854231B924C58886BE09436573DFA")
        @Override
        public Call.State getState() {
            Call.State varB4EAC82CA7396A68D541C85D26508E83_887846829 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_887846829 = mState;
            varB4EAC82CA7396A68D541C85D26508E83_887846829.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_887846829;
            // ---------- Original Method ----------
            //return mState;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.722 -0400", hash_original_method = "0C9900F417D1D38623450F6C44261C8A", hash_generated_method = "D2D1F4A5142F53ECABEF583A0D98712C")
        @Override
        public boolean isIncoming() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_505106761 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_505106761;
            // ---------- Original Method ----------
            //return mIncoming;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.722 -0400", hash_original_method = "FE0C81270397910192F7BF8C9CDDDAB6", hash_generated_method = "83CFF069527180AAE46E3C026C5AA9D0")
        @Override
        public String getAddress() {
            String varB4EAC82CA7396A68D541C85D26508E83_628535398 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_628535398 = mOriginalNumber;
            varB4EAC82CA7396A68D541C85D26508E83_628535398.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_628535398;
            // ---------- Original Method ----------
            //return mOriginalNumber;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.722 -0400", hash_original_method = "710C86DFEBE06A4514867B4563DB846F", hash_generated_method = "C1B73CD4F64B30823405174DC36519D8")
        @Override
        public SipCall getCall() {
            SipCall varB4EAC82CA7396A68D541C85D26508E83_251227273 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_251227273 = mOwner;
            varB4EAC82CA7396A68D541C85D26508E83_251227273.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_251227273;
            // ---------- Original Method ----------
            //return mOwner;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.729 -0400", hash_original_method = "925322092199D63FE2A7CC7A8AD6AC9C", hash_generated_method = "3CD36B26C5D39050C8B996D0F4A39879")
        @Override
        protected Phone getPhone() {
            Phone varB4EAC82CA7396A68D541C85D26508E83_1537406138 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1537406138 = mOwner.getPhone();
            varB4EAC82CA7396A68D541C85D26508E83_1537406138.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1537406138;
            // ---------- Original Method ----------
            //return mOwner.getPhone();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.735 -0400", hash_original_method = "B35A599F4014F0A4981FF871F70F4B98", hash_generated_method = "39BD6AA2D786041AC09E3C3FF846D304")
        @Override
        public void hangup() throws CallStateException {
            {
                Log.d(LOG_TAG, "hangup conn: " + mPeer.getUriString()
                        + ": " + mState + ": on phone "
                        + getPhone().getPhoneName());
                {
                    boolean var7A71802BC1B1F87328893952D19337CA_1387110570 = (!mState.isAlive());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.749 -0400", hash_original_method = "7B400982296D21B9968B9808849E5473", hash_generated_method = "9BF188E56B5A25A625754CD0B3EB7868")
        @Override
        public void separate() throws CallStateException {
            {
                SipCall call;
                boolean var9F2100AEF9AB3C51A66873B7B7B06C45_440688990 = ((getPhone() == SipPhone.this));
                call = (SipCall) SipPhone.this.getBackgroundCall();
                call = (SipCall) SipPhone.this.getForegroundCall();
                {
                    boolean var06B2F1D0FB9C9B434F76B9D96A375019_355625879 = (call.getState() != Call.State.IDLE);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.750 -0400", hash_original_method = "3AB54838416D4A721CFBD2C180A6FF7A", hash_generated_method = "3AB54838416D4A721CFBD2C180A6FF7A")
        public SipAudioCallAdapter ()
        {
            //Synthesized constructor
        }


        protected abstract void onCallEnded(Connection.DisconnectCause cause);

        
        protected abstract void onError(Connection.DisconnectCause cause);

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.752 -0400", hash_original_method = "FAC45A8F53047AFBBF88628CAD98E6D5", hash_generated_method = "A5848E407AAF0106D276C2FB2ED18D01")
        @Override
        public void onCallEnded(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            onCallEnded(call.isInCall()
                    ? Connection.DisconnectCause.NORMAL
                    : Connection.DisconnectCause.INCOMING_MISSED);
            addTaint(call.getTaint());
            // ---------- Original Method ----------
            //onCallEnded(call.isInCall()
                    //? Connection.DisconnectCause.NORMAL
                    //: Connection.DisconnectCause.INCOMING_MISSED);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.752 -0400", hash_original_method = "5FEE35421FE68DCB9D837EF94FC0CC79", hash_generated_method = "1BB9F92D03E2291554F0BCFEE0A95811")
        @Override
        public void onCallBusy(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            onCallEnded(Connection.DisconnectCause.BUSY);
            addTaint(call.getTaint());
            // ---------- Original Method ----------
            //onCallEnded(Connection.DisconnectCause.BUSY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.753 -0400", hash_original_method = "7EFF641046EACBCFF45AD18624210100", hash_generated_method = "42C4EE7DD422BC289DAC47A015928959")
        @Override
        public void onError(SipAudioCall call, int errorCode,
                String errorMessage) {
            //DSFIXME:  CODE0009: Possible callback target function detected
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
            addTaint(call.getTaint());
            addTaint(errorCode);
            addTaint(errorMessage.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.753 -0400", hash_original_field = "976523C589B0B5F84D4530AFB1044D93", hash_generated_field = "71F7148CFC829A5A8E1F7DF4C5808550")

    private static String LOG_TAG = "SipPhone";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.753 -0400", hash_original_field = "BC4FF4C62A62F66D6D2E0A35B84DD24A", hash_generated_field = "14C18EBA74F36E4DA6BB1F58245F971E")

    private static boolean DEBUG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.753 -0400", hash_original_field = "E41B978FAF3B339183EF17F3067BF0E9", hash_generated_field = "8E2E945F2215660B81C3D903A858D97E")

    private static int TIMEOUT_MAKE_CALL = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.753 -0400", hash_original_field = "F955123D19BAEE32317A2241EE79907C", hash_generated_field = "FB63AC1959935C00B04E063E14E95990")

    private static int TIMEOUT_ANSWER_CALL = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.753 -0400", hash_original_field = "B3BD5D4BD687697B138A2662DACEECFF", hash_generated_field = "6F2DF632573CBF96B27EF0923A1C7A95")

    private static int TIMEOUT_HOLD_CALL = 15;
}

