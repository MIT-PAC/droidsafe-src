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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.948 -0400", hash_original_field = "43C9EE3B0858C8409700F8BE9A7CDE24", hash_generated_field = "06E85CBF753C72DF06700CA0D6B37C3F")

    private SipCall ringingCall = new SipCall();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.948 -0400", hash_original_field = "924189678017C6A548527B5A9F52A27F", hash_generated_field = "320FA68B59E86E885480BDC328D988A1")

    private SipCall foregroundCall = new SipCall();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.948 -0400", hash_original_field = "ACF2C40F82F49E1E79919E82F6B27E7B", hash_generated_field = "E67497BDFFD17E2A0DB124112854785A")

    private SipCall backgroundCall = new SipCall();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.948 -0400", hash_original_field = "80F32E3FB2E35C029C679D5FD2362781", hash_generated_field = "E80E46E58FFD30634B7E3BE2973B3395")

    private SipManager mSipManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.948 -0400", hash_original_field = "7DEA788680409024329A69AD3554F7DD", hash_generated_field = "7EAF540B0EC7BBB66B1BAC42709185BB")

    private SipProfile mProfile;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.949 -0400", hash_original_method = "6A0F0B835E49D28418FC90D67BF66C10", hash_generated_method = "169BB17A1C22728C771E38A1BFCFAA31")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.956 -0400", hash_original_method = "0022E344F588A86EC51D8DF12CB4CABD", hash_generated_method = "7E9C7D5EDAF355F25BEFB12B4C4E8D59")
    @Override
    public boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_663785290 = (o == this);
        } //End collapsed parenthetic
        SipPhone that;
        that = (SipPhone) o;
        boolean var45CE97710469451C578ABB40487B4EE8_453557090 = (mProfile.getUriString().equals(that.mProfile.getUriString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_392496104 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_392496104;
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (!(o instanceof SipPhone)) return false;
        //SipPhone that = (SipPhone) o;
        //return mProfile.getUriString().equals(that.mProfile.getUriString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.957 -0400", hash_original_method = "87B6F28FD5B3DEC2F08CA48119477808", hash_generated_method = "E3513F5A4C8835CDA46206C9CEE994A6")
    public String getPhoneName() {
        String varB4EAC82CA7396A68D541C85D26508E83_377926077 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_377926077 = "SIP:" + getUriString(mProfile);
        varB4EAC82CA7396A68D541C85D26508E83_377926077.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_377926077;
        // ---------- Original Method ----------
        //return "SIP:" + getUriString(mProfile);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.958 -0400", hash_original_method = "AD1E8A0332F840602A7373ACA5D5D1A0", hash_generated_method = "A6C50099759606224F6551A294942106")
    public String getSipUri() {
        String varB4EAC82CA7396A68D541C85D26508E83_1756727780 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1756727780 = mProfile.getUriString();
        varB4EAC82CA7396A68D541C85D26508E83_1756727780.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1756727780;
        // ---------- Original Method ----------
        //return mProfile.getUriString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.959 -0400", hash_original_method = "D3C5F9763476A8D0E8037A369F8C496C", hash_generated_method = "739FF83D3723EB53F6110FFCFB3F3553")
    public boolean equals(SipPhone phone) {
        boolean varB170C7409F6B913400034BFCA292A56F_793188464 = (getSipUri().equals(phone.getSipUri()));
        addTaint(phone.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1741245915 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1741245915;
        // ---------- Original Method ----------
        //return getSipUri().equals(phone.getSipUri());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.971 -0400", hash_original_method = "520B082FC4D55C78B63B25D36AD6E406", hash_generated_method = "82E7465EC69476DDC977798AB3278ED9")
    public boolean canTake(Object incomingCall) {
        {
            {
                boolean varE01C4545931A62F4FC941738A7A28D5F_3132344 = (ringingCall.getState().isAlive());
            } //End collapsed parenthetic
            {
                boolean var5F3F3054BBF953B9D43A6A67CF0D2F18_1089199849 = (foregroundCall.getState().isAlive()
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
                    boolean varAFFEC3E610279996536BBDBBD3DBA5A6_1987576999 = (localUri.equals(mProfile.getUriString()));
                    {
                        boolean makeCallWait;
                        makeCallWait = foregroundCall.getState().isAlive();
                        ringingCall.initIncomingCall(sipAudioCall, makeCallWait);
                        {
                            boolean var83E8B86F2BE04FBC6538BB9432DC8A6D_1680555954 = (sipAudioCall.getState()
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_843281768 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_843281768;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.974 -0400", hash_original_method = "4D3FC14BD1B17CB217053014BC4D74B6", hash_generated_method = "0911F750315BB19059A540A2346CB2B9")
    public void acceptCall() throws CallStateException {
        {
            {
                boolean varE0C61107F4B1A5D76C43D42CFA8103F3_684506029 = ((ringingCall.getState() == Call.State.INCOMING) ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.975 -0400", hash_original_method = "F60D4B1A0C339762A597DB11EC122CEA", hash_generated_method = "D15A7D7806B0BF97647F0F39817464D2")
    public void rejectCall() throws CallStateException {
        {
            {
                boolean var442D0F0D7EEA6963AE66B13292492B00_638587424 = (ringingCall.getState().isRinging());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.984 -0400", hash_original_method = "01C657A55270F6B259EE4CA2295CF206", hash_generated_method = "8279C27EA98252EB0DBF29508A5EE982")
    public Connection dial(String dialString) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_1265732057 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1265732057 = dialInternal(dialString);
        } //End block
        addTaint(dialString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1265732057.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1265732057;
        // ---------- Original Method ----------
        //synchronized (SipPhone.class) {
            //return dialInternal(dialString);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.986 -0400", hash_original_method = "E69019A31CF45F3F0FFB8952555ADD38", hash_generated_method = "44CC92D212BCC1DC50611C9A1BB0016E")
    private Connection dialInternal(String dialString) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_754542202 = null; //Variable for return #1
        clearDisconnected();
        {
            boolean var37336DD64F87D8D8C5FEC219FB8725E9_1521936422 = (!canDial());
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("cannot dial in current state");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varC33489E5DEA37065C5D9027B98F53E39_1942169741 = (foregroundCall.getState() == SipCall.State.ACTIVE);
            {
                switchHoldingAndActive();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAA5B136BDA3FB7DD22D11F146CB8E62A_866835092 = (foregroundCall.getState() != SipCall.State.IDLE);
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("cannot dial in current state");
            } //End block
        } //End collapsed parenthetic
        foregroundCall.setMute(false);
        try 
        {
            Connection c;
            c = foregroundCall.dial(dialString);
            varB4EAC82CA7396A68D541C85D26508E83_754542202 = c;
        } //End block
        catch (SipException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new CallStateException("dial error: " + e);
        } //End block
        addTaint(dialString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_754542202.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_754542202;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.986 -0400", hash_original_method = "04453A8FBCEE87A03C8D7EC224934C23", hash_generated_method = "7A87D86064F79FA21688128971E3FE6C")
    public void switchHoldingAndActive() throws CallStateException {
        Log.d(LOG_TAG, " ~~~~~~  switch fg and bg");
        {
            foregroundCall.switchWith(backgroundCall);
            {
                boolean varA0AFA2B7E4A73D22BA12DB013063960D_1777166039 = (backgroundCall.getState().isAlive());
                backgroundCall.hold();
            } //End collapsed parenthetic
            {
                boolean var63B388EA3D8161389B434AC6220A05EB_1158906632 = (foregroundCall.getState().isAlive());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.987 -0400", hash_original_method = "EF99002349D3FD6EFA7BC51A1FE3E619", hash_generated_method = "FF4E2886ED88BEBB361D3AF894A60B8C")
    public boolean canConference() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_524013472 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_524013472;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.987 -0400", hash_original_method = "5DC11CA56E4A18B2CAABC2999FA181D0", hash_generated_method = "BC577CFE5B78CB4EBACC510049727661")
    public void conference() throws CallStateException {
        {
            {
                boolean varA1285B741C70BDCFD1DA6690E8723FC5_1341630694 = ((foregroundCall.getState() != SipCall.State.ACTIVE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.994 -0400", hash_original_method = "0BA61BE71F93F0627212F9F9B5CF61C9", hash_generated_method = "A57E181C80CE334156A9B0F6BCE8F2D0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.995 -0400", hash_original_method = "FB85D9DE1C816CCA93C5FDAD3D9D0A31", hash_generated_method = "D0F7DA74CDC1FD0A1B469BF19C35CEED")
    public boolean canTransfer() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_809830251 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_809830251;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.995 -0400", hash_original_method = "6F3E620B44779BFD9D290EDD6A721C13", hash_generated_method = "1802EA65B8D1F27F1F2A77F464C12952")
    public void explicitCallTransfer() throws CallStateException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.996 -0400", hash_original_method = "D9CD8A34486E399CFA818246637B2970", hash_generated_method = "10069112F50F91D6CB32445A67763FB6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.996 -0400", hash_original_method = "D682F8DE86633D8037AE8DB7A99E0997", hash_generated_method = "1162DEBEA77B251F524EBA5F3839809D")
    public void sendDtmf(char c) {
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_369554764 = (!PhoneNumberUtils.is12Key(c));
            {
                boolean var63B388EA3D8161389B434AC6220A05EB_918164729 = (foregroundCall.getState().isAlive());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.996 -0400", hash_original_method = "C805BAC519448AC91DEA3466C2A972EF", hash_generated_method = "FB02694B253B6627F7B0D7C14AD1E5C3")
    public void startDtmf(char c) {
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_1867642064 = (!PhoneNumberUtils.is12Key(c));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.004 -0400", hash_original_method = "1D5D5FD426DB2358E4E86A174C44532E", hash_generated_method = "28A2AD6EB5F0534AB0CED744A3051E3F")
    public void stopDtmf() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.005 -0400", hash_original_method = "9189F1384120EC6E17589215617F3507", hash_generated_method = "FC98764535C47C26D37CAD332C70ED81")
    public void sendBurstDtmf(String dtmfString) {
        addTaint(dtmfString.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SipPhone] sendBurstDtmf() is a CDMA method");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.011 -0400", hash_original_method = "0D09CB6308056457AD1772B2CC5B82FC", hash_generated_method = "C77A6C0124D697FB86089997222C4675")
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.011 -0400", hash_original_method = "56612EF91DCB9A3808F62E57BF0F81E1", hash_generated_method = "2C0642AA3E03137941721F3C03DDB4F0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.012 -0400", hash_original_method = "14E36FB03F40D4635F36E46C38B086BD", hash_generated_method = "70097558DD3E9A395DC3205B46BB4114")
    public void getCallWaiting(Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.012 -0400", hash_original_method = "80F9B6F2C3F4CA6200C97C4377273E17", hash_generated_method = "09886D350A4FBA76C7FD0C69B3160FBC")
    public void setCallWaiting(boolean enable, Message onComplete) {
        addTaint(enable);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "call waiting not supported");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.012 -0400", hash_original_method = "6F81D9304F797B487FC34D43FAF41E44", hash_generated_method = "6460E809D25C2872BE4C9D5E90D54D8F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.012 -0400", hash_original_method = "79AC444E8066EFF34D5F76D19E8CCACC", hash_generated_method = "FA0D62EBB9B3488AEB271C49BB96D62F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.036 -0400", hash_original_method = "8292EC8FC0222DDB10381F21089BC299", hash_generated_method = "360215403E227D0FCEC5D62C438965DA")
    public boolean getMute() {
        boolean var0736EE6D751830E03BA1FD8749498A0A_76079226 = ((foregroundCall.getState().isAlive()
                ? foregroundCall.getMute()
                : backgroundCall.getMute())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_242822372 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_242822372;
        // ---------- Original Method ----------
        //return (foregroundCall.getState().isAlive()
                //? foregroundCall.getMute()
                //: backgroundCall.getMute());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.038 -0400", hash_original_method = "9DE1B547D23B96DA44E5E5850535D15C", hash_generated_method = "AAA729C3E7EB12E65B2E8BFA75908AE2")
    public Call getForegroundCall() {
        Call varB4EAC82CA7396A68D541C85D26508E83_1368768640 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1368768640 = foregroundCall;
        varB4EAC82CA7396A68D541C85D26508E83_1368768640.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1368768640;
        // ---------- Original Method ----------
        //return foregroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.038 -0400", hash_original_method = "EADE59B65D242AA2A5BCB126522780FD", hash_generated_method = "EECA824A1FDBC27987D59B7EB173D8B3")
    public Call getBackgroundCall() {
        Call varB4EAC82CA7396A68D541C85D26508E83_537716229 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_537716229 = backgroundCall;
        varB4EAC82CA7396A68D541C85D26508E83_537716229.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_537716229;
        // ---------- Original Method ----------
        //return backgroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.044 -0400", hash_original_method = "3A1E9C8D795C10065E3EA9FCAA0EB60D", hash_generated_method = "0F69792C3AA3B845BEC6CE2A8E09F2CB")
    public Call getRingingCall() {
        Call varB4EAC82CA7396A68D541C85D26508E83_532853380 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_532853380 = ringingCall;
        varB4EAC82CA7396A68D541C85D26508E83_532853380.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_532853380;
        // ---------- Original Method ----------
        //return ringingCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.045 -0400", hash_original_method = "88DBA8231EA7F3BE9C495A0C37514173", hash_generated_method = "67E376E5CC0CFE5E0578C18B6CC88E70")
    public ServiceState getServiceState() {
        ServiceState varB4EAC82CA7396A68D541C85D26508E83_104729607 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_104729607 = super.getServiceState();
        varB4EAC82CA7396A68D541C85D26508E83_104729607.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_104729607;
        // ---------- Original Method ----------
        //return super.getServiceState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.045 -0400", hash_original_method = "AE09BA0335289F025B1DDE67D4558A7A", hash_generated_method = "273A5210D2777AD49CD729F5B00383F5")
    private String getUriString(SipProfile p) {
        String varB4EAC82CA7396A68D541C85D26508E83_1085431280 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1085431280 = p.getUserName() + "@" + getSipDomain(p);
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1085431280.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1085431280;
        // ---------- Original Method ----------
        //return p.getUserName() + "@" + getSipDomain(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.046 -0400", hash_original_method = "CF1C8708B65050BDE73A571BB1592129", hash_generated_method = "0111E41F98BA5C05B8156A81FD27542F")
    private String getSipDomain(SipProfile p) {
        String varB4EAC82CA7396A68D541C85D26508E83_162528090 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1826771911 = null; //Variable for return #2
        String domain;
        domain = p.getSipDomain();
        {
            boolean var58ED1E8F1C86F4A4907BDF2FED167062_1915637564 = (domain.endsWith(":5060"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_162528090 = domain.substring(0, domain.length() - 5);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1826771911 = domain;
            } //End block
        } //End collapsed parenthetic
        addTaint(p.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1509636880; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1509636880 = varB4EAC82CA7396A68D541C85D26508E83_162528090;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1509636880 = varB4EAC82CA7396A68D541C85D26508E83_1826771911;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1509636880.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1509636880;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.051 -0400", hash_original_method = "00F055312A0CF21C4F0B5574B16ECF8F", hash_generated_method = "00F055312A0CF21C4F0B5574B16ECF8F")
        public SipCall ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.051 -0400", hash_original_method = "077C3D2ABFDDE04A697972D273B811AD", hash_generated_method = "AFC116FB336DFDAE16FA5C7A5CE7B964")
         void reset() {
            connections.clear();
            setState(Call.State.IDLE);
            // ---------- Original Method ----------
            //connections.clear();
            //setState(Call.State.IDLE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.051 -0400", hash_original_method = "375D19E8671ADDF3312252661F52306D", hash_generated_method = "5AF6FE1AFA7E6D8A76884E046E0A4732")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.082 -0400", hash_original_method = "1E912254ED378DFE25D6B6FABA0CA461", hash_generated_method = "2B73645FC1BE284E92D5FFD4B6E1981E")
        private void takeOver(SipCall that) {
            connections = that.connections;
            state = that.state;
            {
                Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_983738984 = (connections).iterator();
                varE43AC770406DBA1185F3DAFDE696E6A3_983738984.hasNext();
                Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_983738984.next();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.089 -0400", hash_original_method = "BB25C6B7E2DC41EA59445495652EDD92", hash_generated_method = "5A136529C60CACEA2B749AE2CBF97E9A")
        @Override
        public Phone getPhone() {
            Phone varB4EAC82CA7396A68D541C85D26508E83_1269546215 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1269546215 = SipPhone.this;
            varB4EAC82CA7396A68D541C85D26508E83_1269546215.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1269546215;
            // ---------- Original Method ----------
            //return SipPhone.this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.095 -0400", hash_original_method = "B38C364E01AF490301B03DAE11EB1509", hash_generated_method = "1092E80358B3C5E274F2687C9052B89A")
        @Override
        public List<Connection> getConnections() {
            List<Connection> varB4EAC82CA7396A68D541C85D26508E83_2097688856 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_2097688856 = connections;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_2097688856.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2097688856;
            // ---------- Original Method ----------
            //synchronized (SipPhone.class) {
                //return connections;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.103 -0400", hash_original_method = "B9E3A4EF80D99D71D1AE567F3438F945", hash_generated_method = "A3AF529308624DC73B9E7266951B4D9B")
         Connection dial(String originalNumber) throws SipException {
            Connection varB4EAC82CA7396A68D541C85D26508E83_11736191 = null; //Variable for return #1
            String calleeSipUri;
            calleeSipUri = originalNumber;
            {
                boolean var48F7791BB77ABFAC0D24C5A43EB83BC0_2050513239 = (!calleeSipUri.contains("@"));
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
                varB4EAC82CA7396A68D541C85D26508E83_11736191 = c;
            } //End block
            catch (ParseException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("dial", e);
            } //End block
            addTaint(originalNumber.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_11736191.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_11736191;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.249 -0400", hash_original_method = "F3785C840BD99E8D755659453D00493E", hash_generated_method = "9FB02817875E7654F2FFCA5CA504DA0F")
        @Override
        public void hangup() throws CallStateException {
            {
                {
                    boolean var8998223C0389365AC10BB9EB481CFC6F_1666771970 = (state.isAlive());
                    {
                        Log.d(LOG_TAG, "hang up call: " + getState()
                            + ": " + this + " on phone " + getPhone());
                        setState(State.DISCONNECTING);
                        CallStateException excp;
                        excp = null;
                        {
                            Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_82719753 = (connections).iterator();
                            varE43AC770406DBA1185F3DAFDE696E6A3_82719753.hasNext();
                            Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_82719753.next();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.250 -0400", hash_original_method = "03E5A9484BF2B2B8056B6450938A40D7", hash_generated_method = "2CB8B7D1E8802DC18665BAAF1367214C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.251 -0400", hash_original_method = "F8072C3AD3C86AEC184FDD0C13B73AA0", hash_generated_method = "D7F0174B5C634AAAD4965899108AA01C")
         void rejectCall() throws CallStateException {
            hangup();
            // ---------- Original Method ----------
            //hangup();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.252 -0400", hash_original_method = "B2C3B5FE3154049893EC854E60F79D8F", hash_generated_method = "5A91FE1B596FD95AB2749EA2EC9CDC50")
         void acceptCall() throws CallStateException {
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("acceptCall() in a non-ringing call");
            } //End block
            {
                boolean var9C09519F85FF3FA6D687EF8338B33839_1352527961 = (connections.size() != 1);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.252 -0400", hash_original_method = "1B6C9A8A7DE7A949D0CD2E188D6FBBDC", hash_generated_method = "BA04109087E37D0CAF9B29C519E1B6DB")
        private boolean isSpeakerOn() {
            boolean var65FC9098A8240679D54D31921AD18341_911862657 = (((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                    .isSpeakerphoneOn());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_866462072 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_866462072;
            // ---------- Original Method ----------
            //return ((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                    //.isSpeakerphoneOn();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.256 -0400", hash_original_method = "AEEC2C5B8263135991756BF729F3B501", hash_generated_method = "9148E46703EF7F50EBEB802B38B1161F")
         void setAudioGroupMode() {
            AudioGroup audioGroup;
            audioGroup = getAudioGroup();
            int mode;
            mode = audioGroup.getMode();
            {
                audioGroup.setMode(AudioGroup.MODE_ON_HOLD);
            } //End block
            {
                boolean varF8A7F4F0125E77611C619BF6F6178B3E_1566858885 = (getMute());
                {
                    audioGroup.setMode(AudioGroup.MODE_MUTED);
                } //End block
                {
                    boolean var43978F0EAC26602D234D59271C57818C_111589049 = (isSpeakerOn());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.303 -0400", hash_original_method = "A3EB25D5FFDA71466ECC0EEF32C97EE3", hash_generated_method = "0D14A187666B954D165561D53DB27A44")
         void hold() throws CallStateException {
            setState(State.HOLDING);
            {
                Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_1022591884 = (connections).iterator();
                varE43AC770406DBA1185F3DAFDE696E6A3_1022591884.hasNext();
                Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_1022591884.next();
                ((SipConnection) c).hold();
            } //End collapsed parenthetic
            setAudioGroupMode();
            // ---------- Original Method ----------
            //setState(State.HOLDING);
            //for (Connection c : connections) ((SipConnection) c).hold();
            //setAudioGroupMode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.352 -0400", hash_original_method = "9A7CCBA25036980309C5282A2982C0B2", hash_generated_method = "EA2FD7DBDDFF5E450133105FE2F836FA")
         void unhold() throws CallStateException {
            setState(State.ACTIVE);
            AudioGroup audioGroup;
            audioGroup = new AudioGroup();
            {
                Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_1366789809 = (connections).iterator();
                varE43AC770406DBA1185F3DAFDE696E6A3_1366789809.hasNext();
                Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_1366789809.next();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.396 -0400", hash_original_method = "7DDE83D6F9C645A60E86EBEFB92BE589", hash_generated_method = "01028AA93CFAF7C5A7572DD26D3B341B")
         void setMute(boolean muted) {
            {
                Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_1239939992 = (connections).iterator();
                varE43AC770406DBA1185F3DAFDE696E6A3_1239939992.hasNext();
                Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_1239939992.next();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.397 -0400", hash_original_method = "B414CA4B3846B73054EF059A06E7BBBE", hash_generated_method = "7B6E3177DBCF992AAB800E2EC0C1012F")
         boolean getMute() {
            {
                boolean var9D37F75EA12D86F1A0D608B063CA8508_520328857 = (connections.isEmpty());
                Object var30144DAD28DB69F770D2D62A9F08E471_1221776093 = (((SipConnection) connections.get(0)).getMute());
            } //End flattened ternary
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1656832724 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1656832724;
            // ---------- Original Method ----------
            //return connections.isEmpty()
                    //? false
                    //: ((SipConnection) connections.get(0)).getMute();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.441 -0400", hash_original_method = "C6685F4BB929C317D55EF29FDD744317", hash_generated_method = "C1287F2B0A367EF813F7896327460AAA")
         void merge(SipCall that) throws CallStateException {
            AudioGroup audioGroup;
            audioGroup = getAudioGroup();
            Connection[] cc;
            cc = that.connections.toArray(
                    new Connection[that.connections.size()]);
            {
                Iterator<Connection> var16A6B749ACBB853D545509F9EB1B6960_1842026484 = (cc).iterator();
                var16A6B749ACBB853D545509F9EB1B6960_1842026484.hasNext();
                Connection c = var16A6B749ACBB853D545509F9EB1B6960_1842026484.next();
                {
                    SipConnection conn;
                    conn = (SipConnection) c;
                    add(conn);
                    {
                        boolean var0F3E8D2D4CC8A5C0357E07264342DA94_743285904 = (conn.getState() == Call.State.HOLDING);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.441 -0400", hash_original_method = "C804E92B54898C48FBC0803D66022DE0", hash_generated_method = "573B42E9C62032DB470919B86A783C91")
        private void add(SipConnection conn) {
            SipCall call;
            call = conn.getCall();
            {
                boolean varB8F4F262BFDCEFC335F4E56671E9F1DA_1708539262 = (call == this);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.455 -0400", hash_original_method = "994C45B8BD8978A705E69F1BE351A00B", hash_generated_method = "1FD2B146910BB84D3518A07B86A7D37E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.455 -0400", hash_original_method = "C4229E0DAB0B84D6720429F368FEF1C3", hash_generated_method = "D62FEC15EEDE7B98FF40AC005932E6EE")
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
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1777888665 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1777888665;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.457 -0400", hash_original_method = "A20E6ED570A38BE2669CFE3ED9219E0D", hash_generated_method = "FCDE0DF59BA2F85CBAA4E2866169FE95")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.457 -0400", hash_original_method = "9B48819375B09AF6C57EC0D05234CB41", hash_generated_method = "990CC098C4D7C3DE6BBB9AAC0FCC900A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.601 -0400", hash_original_method = "67A791C264A58046C696AC400E0B1106", hash_generated_method = "64FA8DA5F090A74B3BE37449A7CA4260")
         void onConnectionEnded(SipConnection conn) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean allConnectionsDisconnected;
                allConnectionsDisconnected = true;
                Log.d(LOG_TAG, "---check connections: "
                        + connections.size());
                {
                    Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_2147096439 = (connections).iterator();
                    varE43AC770406DBA1185F3DAFDE696E6A3_2147096439.hasNext();
                    Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_2147096439.next();
                    {
                        Log.d(LOG_TAG, "   state=" + c.getState() + ": "
                            + c);
                        {
                            boolean varCAA7A57C3F38B59482436E96FBF861E4_606091417 = (c.getState() != State.DISCONNECTED);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.601 -0400", hash_original_method = "3BDED5D4E6618481393AD33B1F728E6A", hash_generated_method = "AD99542F986764145E5C621AD9E7BBD2")
        private AudioGroup getAudioGroup() {
            AudioGroup varB4EAC82CA7396A68D541C85D26508E83_635736740 = null; //Variable for return #1
            AudioGroup varB4EAC82CA7396A68D541C85D26508E83_659064220 = null; //Variable for return #2
            {
                boolean var9D37F75EA12D86F1A0D608B063CA8508_650480262 = (connections.isEmpty());
                varB4EAC82CA7396A68D541C85D26508E83_635736740 = null;
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_659064220 = ((SipConnection) connections.get(0)).getAudioGroup();
            AudioGroup varA7E53CE21691AB073D9660D615818899_1336219666; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1336219666 = varB4EAC82CA7396A68D541C85D26508E83_635736740;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1336219666 = varB4EAC82CA7396A68D541C85D26508E83_659064220;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1336219666.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1336219666;
            // ---------- Original Method ----------
            //if (connections.isEmpty()) return null;
            //return ((SipConnection) connections.get(0)).getAudioGroup();
        }

        
    }


    
    private class SipConnection extends SipConnectionBase {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.602 -0400", hash_original_field = "4AA3D5C224CE197897B9C6F17BF367CD", hash_generated_field = "D7165953848BB574FCA583AB16464D4F")

        private SipCall mOwner;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.602 -0400", hash_original_field = "DF701BED26C9A6E82B434D3ADA19F19A", hash_generated_field = "D1359B5A0587476130FC171DA764AC68")

        private SipAudioCall mSipAudioCall;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.602 -0400", hash_original_field = "9E8FCF5D95B61569BEBFA55673940468", hash_generated_field = "DFC050C51766232BD82C770760A2DF3D")

        private Call.State mState = Call.State.IDLE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.602 -0400", hash_original_field = "6F401FEEE3A56ED571384DFAB76AA449", hash_generated_field = "06F960DE9AD1B3C2161E1D3DDDEEE930")

        private SipProfile mPeer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.602 -0400", hash_original_field = "44366EF9F63882F1E47C480ECB6765BD", hash_generated_field = "EC5248A9D1818320AA647E3B388AFC57")

        private String mOriginalNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.602 -0400", hash_original_field = "08E4E08A45FD9BD63A8B432D59B0CB98", hash_generated_field = "CEABB36F0D8DD49AB2FFAD188EF64025")

        private boolean mIncoming = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.618 -0400", hash_original_field = "AC67C5E32EF946C45E856E56B7F86834", hash_generated_field = "EC83C5CCA382A6A1930BC3EC797C0EB2")

        private SipAudioCallAdapter mAdapter = new SipAudioCallAdapter() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.616 -0400", hash_original_method = "B8BAADEA0DE266294E2369B45E53A7F4", hash_generated_method = "8BAF3ABFF87964A8B1C1BC1EAD855A5E")
            @Override
            protected void onCallEnded(DisconnectCause cause) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                {
                    boolean var3317223ED0C152EA0F03D574707E1DAC_450923937 = (getDisconnectCause() != DisconnectCause.LOCAL);
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.616 -0400", hash_original_method = "52733E1CC76DBF11A64B0250C617E7AC", hash_generated_method = "F34A5EF95CCC3389960527B60C4F7AE9")
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.617 -0400", hash_original_method = "AC053A33592EEF445C9BE357836B4C16", hash_generated_method = "A5F097A8319E3CB02B505B72B427FB45")
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.618 -0400", hash_original_method = "9E9163C05D7336A6FE9DFAB379443860", hash_generated_method = "44CC71C3464880F2A98246E1A30EEDF6")
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
                                boolean varD8866BE17E7C5DE27AE1021BF41F371D_574927276 = (ringingCall.getState() == Call.State.WAITING);
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.618 -0400", hash_original_method = "C52D3E5DC20D7F0420DDF7517152D94F", hash_generated_method = "22119F567079DA28DBBFC4AA0120E473")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.619 -0400", hash_original_method = "EB041B636E30FA2F3190616100DC4B14", hash_generated_method = "D02AEE3D5DDE08332E361E5B938B30A9")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.619 -0400", hash_original_method = "0957F2328B233DD414C835AB48AD0504", hash_generated_method = "F22895157E71840C75F8BC0F1E6A9DB8")
        public  SipConnection(SipCall owner, SipProfile callee) {
            this(owner, callee, getUriString(callee));
            addTaint(owner.getTaint());
            addTaint(callee.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.619 -0400", hash_original_method = "57E4C10F499E8E36FDDCF5DF3794947E", hash_generated_method = "AE2C1284363AE3CA8E69C7C87135ECFE")
        @Override
        public String getCnapName() {
            String varB4EAC82CA7396A68D541C85D26508E83_657687517 = null; //Variable for return #1
            String displayName;
            displayName = mPeer.getDisplayName();
            varB4EAC82CA7396A68D541C85D26508E83_657687517 = TextUtils.isEmpty(displayName) ? null
                                                  : displayName;
            varB4EAC82CA7396A68D541C85D26508E83_657687517.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_657687517;
            // ---------- Original Method ----------
            //String displayName = mPeer.getDisplayName();
            //return TextUtils.isEmpty(displayName) ? null
                                                  //: displayName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.636 -0400", hash_original_method = "6B6F8D6F29C0FEAF9C52CC30010D6FE2", hash_generated_method = "19EE3A5CB77C3344B181A0ACF049BBDE")
        @Override
        public int getNumberPresentation() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617553876 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617553876;
            // ---------- Original Method ----------
            //return Connection.PRESENTATION_ALLOWED;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.637 -0400", hash_original_method = "14BDBA500BD81C7014F8447F04B9333E", hash_generated_method = "C343C83C3F139AA3E8AD1000032FDE5F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.637 -0400", hash_original_method = "62A265BABD2EF644B89898FE1DF3E037", hash_generated_method = "E88D0586F9497F58EC7DB8C51FD62A85")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.638 -0400", hash_original_method = "5D5AACCF3178F43A37FA6476F3FA2309", hash_generated_method = "F4F212B9E8EECDAFB8ECD3B21BCA89BD")
         void changeOwner(SipCall owner) {
            mOwner = owner;
            // ---------- Original Method ----------
            //mOwner = owner;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.639 -0400", hash_original_method = "81195A6CBC9B38EAFBB5618CD4E171CB", hash_generated_method = "6920903FBB8DDBFBA95522A074A6AECA")
         AudioGroup getAudioGroup() {
            AudioGroup varB4EAC82CA7396A68D541C85D26508E83_1115134755 = null; //Variable for return #1
            AudioGroup varB4EAC82CA7396A68D541C85D26508E83_1655384747 = null; //Variable for return #2
            varB4EAC82CA7396A68D541C85D26508E83_1115134755 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1655384747 = mSipAudioCall.getAudioGroup();
            AudioGroup varA7E53CE21691AB073D9660D615818899_930589837; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_930589837 = varB4EAC82CA7396A68D541C85D26508E83_1115134755;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_930589837 = varB4EAC82CA7396A68D541C85D26508E83_1655384747;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_930589837.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_930589837;
            // ---------- Original Method ----------
            //if (mSipAudioCall == null) return null;
            //return mSipAudioCall.getAudioGroup();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.649 -0400", hash_original_method = "766A0FDDBD2B3A4E947C7E8FBAB0F165", hash_generated_method = "93C009E595843D9B5B39352F3D675F51")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.649 -0400", hash_original_method = "DDAA74ADB7976F32813665FE128238CD", hash_generated_method = "BD6ABA7F7127C0C77F83B3BF0D8D517A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.649 -0400", hash_original_method = "F77273A2CD584255814B6B238AF1477E", hash_generated_method = "3DE8BD0BBE2A340A0377B97A1F53C91E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.650 -0400", hash_original_method = "91B9A79444A0C09E86ABE6F5C7C89706", hash_generated_method = "1E73771C2214E7FFD56C0FF3C68E3880")
         void setMute(boolean muted) {
            {
                boolean var6B5DA206A9FAB2FBF22E68E89DEB93FC_966129016 = ((mSipAudioCall != null) && (muted != mSipAudioCall.isMuted()));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.650 -0400", hash_original_method = "E20C6A660C2E35A5253ACCD901B5D855", hash_generated_method = "671841AB93658E6E745FFE72D563EA22")
         boolean getMute() {
            {
                Object var6F96A3C795A4C1621DD07938C9161660_1308149176 = (mSipAudioCall.isMuted());
            } //End flattened ternary
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1109051223 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1109051223;
            // ---------- Original Method ----------
            //return (mSipAudioCall == null) ? false
                                           //: mSipAudioCall.isMuted();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.670 -0400", hash_original_method = "1833AE90ADB0C663418065E2EE17BAF0", hash_generated_method = "F7BF78C03975EEB51BBB5EBAECE9F1D9")
        @Override
        protected void setState(Call.State state) {
            super.setState(state);
            mState = state;
            // ---------- Original Method ----------
            //if (state == mState) return;
            //super.setState(state);
            //mState = state;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.672 -0400", hash_original_method = "0D6E90F055C537B49BE3263741E0D2AC", hash_generated_method = "6A3CA2E2F7F0C9F1E0D172CD78EE9A01")
        @Override
        public Call.State getState() {
            Call.State varB4EAC82CA7396A68D541C85D26508E83_1182984647 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1182984647 = mState;
            varB4EAC82CA7396A68D541C85D26508E83_1182984647.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1182984647;
            // ---------- Original Method ----------
            //return mState;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.672 -0400", hash_original_method = "0C9900F417D1D38623450F6C44261C8A", hash_generated_method = "49106FCE5EABED24FFA26C14A76CB577")
        @Override
        public boolean isIncoming() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1651721087 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1651721087;
            // ---------- Original Method ----------
            //return mIncoming;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.672 -0400", hash_original_method = "FE0C81270397910192F7BF8C9CDDDAB6", hash_generated_method = "E11700BC051974554FF4A73175EDABF8")
        @Override
        public String getAddress() {
            String varB4EAC82CA7396A68D541C85D26508E83_1043467307 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1043467307 = mOriginalNumber;
            varB4EAC82CA7396A68D541C85D26508E83_1043467307.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1043467307;
            // ---------- Original Method ----------
            //return mOriginalNumber;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.673 -0400", hash_original_method = "710C86DFEBE06A4514867B4563DB846F", hash_generated_method = "6D262EFA6E880B5156588F3472579D25")
        @Override
        public SipCall getCall() {
            SipCall varB4EAC82CA7396A68D541C85D26508E83_82871679 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_82871679 = mOwner;
            varB4EAC82CA7396A68D541C85D26508E83_82871679.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_82871679;
            // ---------- Original Method ----------
            //return mOwner;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.673 -0400", hash_original_method = "925322092199D63FE2A7CC7A8AD6AC9C", hash_generated_method = "C0A8E5468D9D58BB74C14924507BE9B7")
        @Override
        protected Phone getPhone() {
            Phone varB4EAC82CA7396A68D541C85D26508E83_300691052 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_300691052 = mOwner.getPhone();
            varB4EAC82CA7396A68D541C85D26508E83_300691052.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_300691052;
            // ---------- Original Method ----------
            //return mOwner.getPhone();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.676 -0400", hash_original_method = "B35A599F4014F0A4981FF871F70F4B98", hash_generated_method = "E6EB0D2B2C9B0E6114CCE16A9E462CC1")
        @Override
        public void hangup() throws CallStateException {
            {
                Log.d(LOG_TAG, "hangup conn: " + mPeer.getUriString()
                        + ": " + mState + ": on phone "
                        + getPhone().getPhoneName());
                {
                    boolean var7A71802BC1B1F87328893952D19337CA_1259837646 = (!mState.isAlive());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.688 -0400", hash_original_method = "7B400982296D21B9968B9808849E5473", hash_generated_method = "0E0762BE503598DEBFFD7BAFC2E48E86")
        @Override
        public void separate() throws CallStateException {
            {
                SipCall call;
                boolean var9F2100AEF9AB3C51A66873B7B7B06C45_642671681 = ((getPhone() == SipPhone.this));
                call = (SipCall) SipPhone.this.getBackgroundCall();
                call = (SipCall) SipPhone.this.getForegroundCall();
                {
                    boolean var06B2F1D0FB9C9B434F76B9D96A375019_1854506826 = (call.getState() != Call.State.IDLE);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.688 -0400", hash_original_method = "3AB54838416D4A721CFBD2C180A6FF7A", hash_generated_method = "3AB54838416D4A721CFBD2C180A6FF7A")
        public SipAudioCallAdapter ()
        {
            //Synthesized constructor
        }


        protected abstract void onCallEnded(Connection.DisconnectCause cause);

        
        protected abstract void onError(Connection.DisconnectCause cause);

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.689 -0400", hash_original_method = "FAC45A8F53047AFBBF88628CAD98E6D5", hash_generated_method = "A5848E407AAF0106D276C2FB2ED18D01")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.689 -0400", hash_original_method = "5FEE35421FE68DCB9D837EF94FC0CC79", hash_generated_method = "1BB9F92D03E2291554F0BCFEE0A95811")
        @Override
        public void onCallBusy(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            onCallEnded(Connection.DisconnectCause.BUSY);
            addTaint(call.getTaint());
            // ---------- Original Method ----------
            //onCallEnded(Connection.DisconnectCause.BUSY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.692 -0400", hash_original_method = "7EFF641046EACBCFF45AD18624210100", hash_generated_method = "42C4EE7DD422BC289DAC47A015928959")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.692 -0400", hash_original_field = "976523C589B0B5F84D4530AFB1044D93", hash_generated_field = "71F7148CFC829A5A8E1F7DF4C5808550")

    private static String LOG_TAG = "SipPhone";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.692 -0400", hash_original_field = "BC4FF4C62A62F66D6D2E0A35B84DD24A", hash_generated_field = "14C18EBA74F36E4DA6BB1F58245F971E")

    private static boolean DEBUG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.693 -0400", hash_original_field = "E41B978FAF3B339183EF17F3067BF0E9", hash_generated_field = "8E2E945F2215660B81C3D903A858D97E")

    private static int TIMEOUT_MAKE_CALL = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.693 -0400", hash_original_field = "F955123D19BAEE32317A2241EE79907C", hash_generated_field = "FB63AC1959935C00B04E063E14E95990")

    private static int TIMEOUT_ANSWER_CALL = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.693 -0400", hash_original_field = "B3BD5D4BD687697B138A2662DACEECFF", hash_generated_field = "6F2DF632573CBF96B27EF0923A1C7A95")

    private static int TIMEOUT_HOLD_CALL = 15;
}

