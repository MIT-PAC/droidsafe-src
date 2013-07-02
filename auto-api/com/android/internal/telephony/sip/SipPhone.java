package com.android.internal.telephony.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.209 -0400", hash_original_field = "43C9EE3B0858C8409700F8BE9A7CDE24", hash_generated_field = "06E85CBF753C72DF06700CA0D6B37C3F")

    private SipCall ringingCall = new SipCall();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.209 -0400", hash_original_field = "924189678017C6A548527B5A9F52A27F", hash_generated_field = "320FA68B59E86E885480BDC328D988A1")

    private SipCall foregroundCall = new SipCall();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.209 -0400", hash_original_field = "ACF2C40F82F49E1E79919E82F6B27E7B", hash_generated_field = "E67497BDFFD17E2A0DB124112854785A")

    private SipCall backgroundCall = new SipCall();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.209 -0400", hash_original_field = "80F32E3FB2E35C029C679D5FD2362781", hash_generated_field = "E80E46E58FFD30634B7E3BE2973B3395")

    private SipManager mSipManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.209 -0400", hash_original_field = "7DEA788680409024329A69AD3554F7DD", hash_generated_field = "7EAF540B0EC7BBB66B1BAC42709185BB")

    private SipProfile mProfile;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.210 -0400", hash_original_method = "6A0F0B835E49D28418FC90D67BF66C10", hash_generated_method = "169BB17A1C22728C771E38A1BFCFAA31")
      SipPhone(Context context, PhoneNotifier notifier, SipProfile profile) {
        super(context, notifier);
        Log.d(LOG_TAG, "new SipPhone: " + profile.getUriString());
        ringingCall = new SipCall();
        foregroundCall = new SipCall();
        backgroundCall = new SipCall();
        mProfile = profile;
        mSipManager = SipManager.newInstance(context);
        addTaint(notifier.getTaint());
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.211 -0400", hash_original_method = "0022E344F588A86EC51D8DF12CB4CABD", hash_generated_method = "2AC364358522569C086215B1D349618D")
    @Override
    public boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_1405545804 = (o == this);
        } 
        SipPhone that = (SipPhone) o;
        boolean var45CE97710469451C578ABB40487B4EE8_946291380 = (mProfile.getUriString().equals(that.mProfile.getUriString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1487086972 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1487086972;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.211 -0400", hash_original_method = "87B6F28FD5B3DEC2F08CA48119477808", hash_generated_method = "3646189848BD58942A7CB6EC52DA2B71")
    public String getPhoneName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1079928340 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1079928340 = "SIP:" + getUriString(mProfile);
        varB4EAC82CA7396A68D541C85D26508E83_1079928340.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1079928340;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.211 -0400", hash_original_method = "AD1E8A0332F840602A7373ACA5D5D1A0", hash_generated_method = "6530782783D81164D9632B25CC39AA6E")
    public String getSipUri() {
        String varB4EAC82CA7396A68D541C85D26508E83_1957236090 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1957236090 = mProfile.getUriString();
        varB4EAC82CA7396A68D541C85D26508E83_1957236090.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1957236090;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.212 -0400", hash_original_method = "D3C5F9763476A8D0E8037A369F8C496C", hash_generated_method = "39F36FC937DE5A778724AC1FE45FCC66")
    public boolean equals(SipPhone phone) {
        boolean varB170C7409F6B913400034BFCA292A56F_1147398218 = (getSipUri().equals(phone.getSipUri()));
        addTaint(phone.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2061230704 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2061230704;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.212 -0400", hash_original_method = "520B082FC4D55C78B63B25D36AD6E406", hash_generated_method = "517C2497C88011310F78F92C09B1E378")
    public boolean canTake(Object incomingCall) {
        {
            {
                boolean varE01C4545931A62F4FC941738A7A28D5F_1832446883 = (ringingCall.getState().isAlive());
            } 
            {
                boolean var5F3F3054BBF953B9D43A6A67CF0D2F18_156381260 = (foregroundCall.getState().isAlive()
                    && backgroundCall.getState().isAlive());
            } 
            try 
            {
                SipAudioCall sipAudioCall = (SipAudioCall) incomingCall;
                Log.d(LOG_TAG, "+++ taking call from: "
                        + sipAudioCall.getPeerProfile().getUriString());
                String localUri = sipAudioCall.getLocalProfile().getUriString();
                {
                    boolean varAFFEC3E610279996536BBDBBD3DBA5A6_1447619726 = (localUri.equals(mProfile.getUriString()));
                    {
                        boolean makeCallWait = foregroundCall.getState().isAlive();
                        ringingCall.initIncomingCall(sipAudioCall, makeCallWait);
                        {
                            boolean var83E8B86F2BE04FBC6538BB9432DC8A6D_951348645 = (sipAudioCall.getState()
                            != SipSession.State.INCOMING_CALL);
                            {
                                Log.d(LOG_TAG, "    call cancelled !!");
                                ringingCall.reset();
                            } 
                        } 
                    } 
                } 
            } 
            catch (Exception e)
            {
                ringingCall.reset();
            } 
        } 
        addTaint(incomingCall.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_270637416 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_270637416;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.213 -0400", hash_original_method = "4D3FC14BD1B17CB217053014BC4D74B6", hash_generated_method = "CFE8AD9944C949BDB5720AA2C2AA916A")
    public void acceptCall() throws CallStateException {
        {
            {
                boolean varE0C61107F4B1A5D76C43D42CFA8103F3_1456145798 = ((ringingCall.getState() == Call.State.INCOMING) ||
                    (ringingCall.getState() == Call.State.WAITING));
                {
                    Log.d(LOG_TAG, "acceptCall");
                    ringingCall.setMute(false);
                    ringingCall.acceptCall();
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new CallStateException("phone not ringing");
                } 
            } 
        } 
        
        
            
                    
                
                
                
            
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.214 -0400", hash_original_method = "F60D4B1A0C339762A597DB11EC122CEA", hash_generated_method = "1177A4BB05916C97B3A9A0714EAE737F")
    public void rejectCall() throws CallStateException {
        {
            {
                boolean var442D0F0D7EEA6963AE66B13292492B00_1648314713 = (ringingCall.getState().isRinging());
                {
                    Log.d(LOG_TAG, "rejectCall");
                    ringingCall.rejectCall();
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new CallStateException("phone not ringing");
                } 
            } 
        } 
        
        
            
                
                
            
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.215 -0400", hash_original_method = "01C657A55270F6B259EE4CA2295CF206", hash_generated_method = "8446171054658FAB1039698C934CBDF7")
    public Connection dial(String dialString) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_1425466349 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1425466349 = dialInternal(dialString);
        } 
        addTaint(dialString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1425466349.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1425466349;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.215 -0400", hash_original_method = "E69019A31CF45F3F0FFB8952555ADD38", hash_generated_method = "B6D81A2F54177562E3403F791317D824")
    private Connection dialInternal(String dialString) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_136432238 = null; 
        clearDisconnected();
        {
            boolean var37336DD64F87D8D8C5FEC219FB8725E9_361166479 = (!canDial());
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("cannot dial in current state");
            } 
        } 
        {
            boolean varC33489E5DEA37065C5D9027B98F53E39_1076657344 = (foregroundCall.getState() == SipCall.State.ACTIVE);
            {
                switchHoldingAndActive();
            } 
        } 
        {
            boolean varAA5B136BDA3FB7DD22D11F146CB8E62A_648184605 = (foregroundCall.getState() != SipCall.State.IDLE);
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("cannot dial in current state");
            } 
        } 
        foregroundCall.setMute(false);
        try 
        {
            Connection c = foregroundCall.dial(dialString);
            varB4EAC82CA7396A68D541C85D26508E83_136432238 = c;
        } 
        catch (SipException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new CallStateException("dial error: " + e);
        } 
        addTaint(dialString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_136432238.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_136432238;
        
        
        
            
        
        
            
        
        
            
        
        
        
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.216 -0400", hash_original_method = "04453A8FBCEE87A03C8D7EC224934C23", hash_generated_method = "2E3F6CF88F80D43A66B2D05B1C86184A")
    public void switchHoldingAndActive() throws CallStateException {
        Log.d(LOG_TAG, " ~~~~~~  switch fg and bg");
        {
            foregroundCall.switchWith(backgroundCall);
            {
                boolean varA0AFA2B7E4A73D22BA12DB013063960D_1881059549 = (backgroundCall.getState().isAlive());
                backgroundCall.hold();
            } 
            {
                boolean var63B388EA3D8161389B434AC6220A05EB_313892665 = (foregroundCall.getState().isAlive());
                foregroundCall.unhold();
            } 
        } 
        
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.217 -0400", hash_original_method = "EF99002349D3FD6EFA7BC51A1FE3E619", hash_generated_method = "17D71EBFFA33201E231325284ED57E58")
    public boolean canConference() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_316712262 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_316712262;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.217 -0400", hash_original_method = "5DC11CA56E4A18B2CAABC2999FA181D0", hash_generated_method = "9D5AB93B90BF1C2F121A92DF5807CFB3")
    public void conference() throws CallStateException {
        {
            {
                boolean varA1285B741C70BDCFD1DA6690E8723FC5_2032409026 = ((foregroundCall.getState() != SipCall.State.ACTIVE)
                    || (foregroundCall.getState() != SipCall.State.ACTIVE));
                {
                    if (DroidSafeAndroidRuntime.control) throw new CallStateException("wrong state to merge calls: fg="
                        + foregroundCall.getState() + ", bg="
                        + backgroundCall.getState());
                } 
            } 
            foregroundCall.merge(backgroundCall);
        } 
        
        
            
                    
                
                        
                        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.218 -0400", hash_original_method = "0BA61BE71F93F0627212F9F9B5CF61C9", hash_generated_method = "A57E181C80CE334156A9B0F6BCE8F2D0")
    public void conference(Call that) throws CallStateException {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("expect " + SipCall.class
                        + ", cannot merge with " + that.getClass());
            } 
            foregroundCall.merge((SipCall) that);
        } 
        addTaint(that.getTaint());
        
        
            
                
                        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.218 -0400", hash_original_method = "FB85D9DE1C816CCA93C5FDAD3D9D0A31", hash_generated_method = "4DFB3570894F546712C58BC236029158")
    public boolean canTransfer() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_529589030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_529589030;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.218 -0400", hash_original_method = "6F3E620B44779BFD9D290EDD6A721C13", hash_generated_method = "1802EA65B8D1F27F1F2A77F464C12952")
    public void explicitCallTransfer() throws CallStateException {
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.218 -0400", hash_original_method = "D9CD8A34486E399CFA818246637B2970", hash_generated_method = "10069112F50F91D6CB32445A67763FB6")
    public void clearDisconnected() {
        {
            ringingCall.clearDisconnected();
            foregroundCall.clearDisconnected();
            backgroundCall.clearDisconnected();
            updatePhoneState();
            notifyPreciseCallStateChanged();
        } 
        
        
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.219 -0400", hash_original_method = "D682F8DE86633D8037AE8DB7A99E0997", hash_generated_method = "5D76E319F0629904D5C920E404DE11E2")
    public void sendDtmf(char c) {
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_956286958 = (!PhoneNumberUtils.is12Key(c));
            {
                boolean var63B388EA3D8161389B434AC6220A05EB_630857450 = (foregroundCall.getState().isAlive());
                {
                    {
                        foregroundCall.sendDtmf(c);
                    } 
                } 
            } 
        } 
        addTaint(c);
        
        
            
                    
        
            
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.219 -0400", hash_original_method = "C805BAC519448AC91DEA3466C2A972EF", hash_generated_method = "43DBF00E381D00AA5294782798554E49")
    public void startDtmf(char c) {
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_1104314473 = (!PhoneNumberUtils.is12Key(c));
            {
                sendDtmf(c);
            } 
        } 
        addTaint(c);
        
        
            
                
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.219 -0400", hash_original_method = "1D5D5FD426DB2358E4E86A174C44532E", hash_generated_method = "28A2AD6EB5F0534AB0CED744A3051E3F")
    public void stopDtmf() {
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.220 -0400", hash_original_method = "9189F1384120EC6E17589215617F3507", hash_generated_method = "FC98764535C47C26D37CAD332C70ED81")
    public void sendBurstDtmf(String dtmfString) {
        addTaint(dtmfString.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.220 -0400", hash_original_method = "0D09CB6308056457AD1772B2CC5B82FC", hash_generated_method = "C77A6C0124D697FB86089997222C4675")
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        addTaint(onComplete.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.220 -0400", hash_original_method = "56612EF91DCB9A3808F62E57BF0F81E1", hash_generated_method = "2C0642AA3E03137941721F3C03DDB4F0")
    public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode,
                                           Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        addTaint(commandInterfaceCLIRMode);
        addTaint(onComplete.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.220 -0400", hash_original_method = "14E36FB03F40D4635F36E46C38B086BD", hash_generated_method = "70097558DD3E9A395DC3205B46BB4114")
    public void getCallWaiting(Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        addTaint(onComplete.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.221 -0400", hash_original_method = "80F9B6F2C3F4CA6200C97C4377273E17", hash_generated_method = "09886D350A4FBA76C7FD0C69B3160FBC")
    public void setCallWaiting(boolean enable, Message onComplete) {
        addTaint(enable);
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.221 -0400", hash_original_method = "6F81D9304F797B487FC34D43FAF41E44", hash_generated_method = "6460E809D25C2872BE4C9D5E90D54D8F")
    @Override
    public void setEchoSuppressionEnabled(boolean enabled) {
        {
            foregroundCall.setAudioGroupMode();
        } 
        addTaint(enabled);
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.221 -0400", hash_original_method = "79AC444E8066EFF34D5F76D19E8CCACC", hash_generated_method = "FA0D62EBB9B3488AEB271C49BB96D62F")
    public void setMute(boolean muted) {
        {
            foregroundCall.setMute(muted);
        } 
        addTaint(muted);
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.221 -0400", hash_original_method = "8292EC8FC0222DDB10381F21089BC299", hash_generated_method = "CBE1F5A0118792C81ED4F6279BEFF541")
    public boolean getMute() {
        boolean var0736EE6D751830E03BA1FD8749498A0A_2140707248 = ((foregroundCall.getState().isAlive()
                ? foregroundCall.getMute()
                : backgroundCall.getMute())); 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_174348410 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_174348410;
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.222 -0400", hash_original_method = "9DE1B547D23B96DA44E5E5850535D15C", hash_generated_method = "45030E18E21F26D17D7DF3D9CA712DF9")
    public Call getForegroundCall() {
        Call varB4EAC82CA7396A68D541C85D26508E83_1040871099 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1040871099 = foregroundCall;
        varB4EAC82CA7396A68D541C85D26508E83_1040871099.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1040871099;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.222 -0400", hash_original_method = "EADE59B65D242AA2A5BCB126522780FD", hash_generated_method = "F58D84E90C21836FF206B727ED4BFA10")
    public Call getBackgroundCall() {
        Call varB4EAC82CA7396A68D541C85D26508E83_2053132370 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2053132370 = backgroundCall;
        varB4EAC82CA7396A68D541C85D26508E83_2053132370.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2053132370;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.223 -0400", hash_original_method = "3A1E9C8D795C10065E3EA9FCAA0EB60D", hash_generated_method = "CD498EBB48D248E1EDB01530C3C36E01")
    public Call getRingingCall() {
        Call varB4EAC82CA7396A68D541C85D26508E83_1213290136 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1213290136 = ringingCall;
        varB4EAC82CA7396A68D541C85D26508E83_1213290136.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1213290136;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.223 -0400", hash_original_method = "88DBA8231EA7F3BE9C495A0C37514173", hash_generated_method = "F33397BF525E38383E1035A85FEF45E3")
    public ServiceState getServiceState() {
        ServiceState varB4EAC82CA7396A68D541C85D26508E83_223966881 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_223966881 = super.getServiceState();
        varB4EAC82CA7396A68D541C85D26508E83_223966881.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_223966881;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.224 -0400", hash_original_method = "AE09BA0335289F025B1DDE67D4558A7A", hash_generated_method = "2490BD9DD24B3C0E272AD73A122D45C5")
    private String getUriString(SipProfile p) {
        String varB4EAC82CA7396A68D541C85D26508E83_733958391 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_733958391 = p.getUserName() + "@" + getSipDomain(p);
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_733958391.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_733958391;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.224 -0400", hash_original_method = "CF1C8708B65050BDE73A571BB1592129", hash_generated_method = "0CBCC61986A89F1CF9FA69AAC111A5FF")
    private String getSipDomain(SipProfile p) {
        String varB4EAC82CA7396A68D541C85D26508E83_1627276670 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1717069323 = null; 
        String domain = p.getSipDomain();
        {
            boolean var58ED1E8F1C86F4A4907BDF2FED167062_869602762 = (domain.endsWith(":5060"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1627276670 = domain.substring(0, domain.length() - 5);
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1717069323 = domain;
            } 
        } 
        addTaint(p.getTaint());
        String varA7E53CE21691AB073D9660D615818899_32991623; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_32991623 = varB4EAC82CA7396A68D541C85D26508E83_1627276670;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_32991623 = varB4EAC82CA7396A68D541C85D26508E83_1717069323;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_32991623.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_32991623;
        
        
        
            
        
            
        
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.225 -0400", hash_original_method = "00F055312A0CF21C4F0B5574B16ECF8F", hash_generated_method = "00F055312A0CF21C4F0B5574B16ECF8F")
        public SipCall ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.225 -0400", hash_original_method = "077C3D2ABFDDE04A697972D273B811AD", hash_generated_method = "AFC116FB336DFDAE16FA5C7A5CE7B964")
         void reset() {
            connections.clear();
            setState(Call.State.IDLE);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.226 -0400", hash_original_method = "375D19E8671ADDF3312252661F52306D", hash_generated_method = "79013DFB2C9530684A67D2A95700D59C")
         void switchWith(SipCall that) {
            {
                SipCall tmp = new SipCall();
                tmp.takeOver(this);
                this.takeOver(that);
                that.takeOver(tmp);
            } 
            addTaint(that.getTaint());
            
            
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.232 -0400", hash_original_method = "1E912254ED378DFE25D6B6FABA0CA461", hash_generated_method = "BB8591B7E12CB23A7909E92204EF996C")
        private void takeOver(SipCall that) {
            connections = that.connections;
            state = that.state;
            {
                Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_334977901 = (connections).iterator();
                varE43AC770406DBA1185F3DAFDE696E6A3_334977901.hasNext();
                Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_334977901.next();
                {
                    ((SipConnection) c).changeOwner(this);
                } 
            } 
            addTaint(that.getTaint());
            
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.233 -0400", hash_original_method = "BB25C6B7E2DC41EA59445495652EDD92", hash_generated_method = "CBBC317FDBA03F956F421879B28200FA")
        @Override
        public Phone getPhone() {
            Phone varB4EAC82CA7396A68D541C85D26508E83_411429980 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_411429980 = SipPhone.this;
            varB4EAC82CA7396A68D541C85D26508E83_411429980.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_411429980;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.234 -0400", hash_original_method = "B38C364E01AF490301B03DAE11EB1509", hash_generated_method = "DCBFE06FA40498FCAB1036522EA29DAE")
        @Override
        public List<Connection> getConnections() {
            List<Connection> varB4EAC82CA7396A68D541C85D26508E83_774567054 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_774567054 = connections;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_774567054.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_774567054;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.235 -0400", hash_original_method = "B9E3A4EF80D99D71D1AE567F3438F945", hash_generated_method = "9890756D138E1644089906028AA4D8F5")
         Connection dial(String originalNumber) throws SipException {
            Connection varB4EAC82CA7396A68D541C85D26508E83_967808568 = null; 
            String calleeSipUri = originalNumber;
            {
                boolean var48F7791BB77ABFAC0D24C5A43EB83BC0_97620235 = (!calleeSipUri.contains("@"));
                {
                    String replaceStr = Pattern.quote(mProfile.getUserName() + "@");
                    calleeSipUri = mProfile.getUriString().replaceFirst(replaceStr,
                        calleeSipUri + "@");
                } 
            } 
            try 
            {
                SipProfile callee = new SipProfile.Builder(calleeSipUri).build();
                SipConnection c = new SipConnection(this, callee,
                        originalNumber);
                c.dial();
                connections.add(c);
                setState(Call.State.DIALING);
                varB4EAC82CA7396A68D541C85D26508E83_967808568 = c;
            } 
            catch (ParseException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("dial", e);
            } 
            addTaint(originalNumber.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_967808568.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_967808568;
            
            
            
                
                
                        
            
            
                
                        
                
                        
                
                
                
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.253 -0400", hash_original_method = "F3785C840BD99E8D755659453D00493E", hash_generated_method = "56A7AC44F2A3378DE80D8366140BD179")
        @Override
        public void hangup() throws CallStateException {
            {
                {
                    boolean var8998223C0389365AC10BB9EB481CFC6F_1084206378 = (state.isAlive());
                    {
                        Log.d(LOG_TAG, "hang up call: " + getState()
                            + ": " + this + " on phone " + getPhone());
                        setState(State.DISCONNECTING);
                        CallStateException excp = null;
                        {
                            Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_185506046 = (connections).iterator();
                            varE43AC770406DBA1185F3DAFDE696E6A3_185506046.hasNext();
                            Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_185506046.next();
                            {
                                try 
                                {
                                    c.hangup();
                                } 
                                catch (CallStateException e)
                                {
                                    excp = e;
                                } 
                            } 
                        } 
                        if (DroidSafeAndroidRuntime.control) throw excp;
                    } 
                    {
                        Log.d(LOG_TAG, "hang up dead call: " + getState()
                            + ": " + this + " on phone " + getPhone());
                    } 
                } 
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.253 -0400", hash_original_method = "03E5A9484BF2B2B8056B6450938A40D7", hash_generated_method = "C787867A0CBB820334ADBA5BDE40D2A0")
         void initIncomingCall(SipAudioCall sipAudioCall, boolean makeCallWait) {
            SipProfile callee = sipAudioCall.getPeerProfile();
            SipConnection c = new SipConnection(this, callee);
            connections.add(c);
            Call.State newState;
            newState = State.WAITING;
            newState = State.INCOMING;
            c.initIncomingCall(sipAudioCall, newState);
            setState(newState);
            notifyNewRingingConnectionP(c);
            addTaint(sipAudioCall.getTaint());
            addTaint(makeCallWait);
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.253 -0400", hash_original_method = "F8072C3AD3C86AEC184FDD0C13B73AA0", hash_generated_method = "D7F0174B5C634AAAD4965899108AA01C")
         void rejectCall() throws CallStateException {
            hangup();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.254 -0400", hash_original_method = "B2C3B5FE3154049893EC854E60F79D8F", hash_generated_method = "D18932923E014CE8F2FEA722DA401194")
         void acceptCall() throws CallStateException {
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("acceptCall() in a non-ringing call");
            } 
            {
                boolean var9C09519F85FF3FA6D687EF8338B33839_1943066546 = (connections.size() != 1);
                {
                    if (DroidSafeAndroidRuntime.control) throw new CallStateException("acceptCall() in a conf call");
                } 
            } 
            ((SipConnection) connections.get(0)).acceptCall();
            
            
                
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.254 -0400", hash_original_method = "1B6C9A8A7DE7A949D0CD2E188D6FBBDC", hash_generated_method = "E5DAC700025BD5D5018E5E6B22461D2D")
        private boolean isSpeakerOn() {
            boolean var65FC9098A8240679D54D31921AD18341_1640855130 = (((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                    .isSpeakerphoneOn());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1965979997 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1965979997;
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.255 -0400", hash_original_method = "AEEC2C5B8263135991756BF729F3B501", hash_generated_method = "4EF197BEA7953E9D286C36568D5D7261")
         void setAudioGroupMode() {
            AudioGroup audioGroup = getAudioGroup();
            int mode = audioGroup.getMode();
            {
                audioGroup.setMode(AudioGroup.MODE_ON_HOLD);
            } 
            {
                boolean varF8A7F4F0125E77611C619BF6F6178B3E_246089276 = (getMute());
                {
                    audioGroup.setMode(AudioGroup.MODE_MUTED);
                } 
                {
                    boolean var43978F0EAC26602D234D59271C57818C_168673310 = (isSpeakerOn());
                    {
                        audioGroup.setMode(AudioGroup.MODE_ECHO_SUPPRESSION);
                    } 
                    {
                        audioGroup.setMode(AudioGroup.MODE_NORMAL);
                    } 
                } 
            } 
            Log.d(LOG_TAG, String.format(
                    "audioGroup mode change: %d --> %d", mode,
                    audioGroup.getMode()));
            
            
            
            
            
                
            
                
            
                
            
                
            
            
                    
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.259 -0400", hash_original_method = "A3EB25D5FFDA71466ECC0EEF32C97EE3", hash_generated_method = "8DA26198FD37A4BD008A53D43E60A395")
         void hold() throws CallStateException {
            setState(State.HOLDING);
            {
                Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_1600001035 = (connections).iterator();
                varE43AC770406DBA1185F3DAFDE696E6A3_1600001035.hasNext();
                Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_1600001035.next();
                ((SipConnection) c).hold();
            } 
            setAudioGroupMode();
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.264 -0400", hash_original_method = "9A7CCBA25036980309C5282A2982C0B2", hash_generated_method = "E709E82AA0E6000293B5716CF178C496")
         void unhold() throws CallStateException {
            setState(State.ACTIVE);
            AudioGroup audioGroup = new AudioGroup();
            {
                Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_1074425009 = (connections).iterator();
                varE43AC770406DBA1185F3DAFDE696E6A3_1074425009.hasNext();
                Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_1074425009.next();
                {
                    ((SipConnection) c).unhold(audioGroup);
                } 
            } 
            setAudioGroupMode();
            
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.272 -0400", hash_original_method = "7DDE83D6F9C645A60E86EBEFB92BE589", hash_generated_method = "826263FF16E183379165A473C8B06DC5")
         void setMute(boolean muted) {
            {
                Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_1312274887 = (connections).iterator();
                varE43AC770406DBA1185F3DAFDE696E6A3_1312274887.hasNext();
                Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_1312274887.next();
                {
                    ((SipConnection) c).setMute(muted);
                } 
            } 
            addTaint(muted);
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.273 -0400", hash_original_method = "B414CA4B3846B73054EF059A06E7BBBE", hash_generated_method = "85A93B3C100A153D11E160A8C0174833")
         boolean getMute() {
            {
                boolean var9D37F75EA12D86F1A0D608B063CA8508_311027683 = (connections.isEmpty());
                Object var30144DAD28DB69F770D2D62A9F08E471_1888850838 = (((SipConnection) connections.get(0)).getMute());
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_618662107 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_618662107;
            
            
                    
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.280 -0400", hash_original_method = "C6685F4BB929C317D55EF29FDD744317", hash_generated_method = "427711B5DA917864AFF575BCBC4E8B31")
         void merge(SipCall that) throws CallStateException {
            AudioGroup audioGroup = getAudioGroup();
            Connection[] cc = that.connections.toArray(
                    new Connection[that.connections.size()]);
            {
                Connection c = cc[0];
                {
                    SipConnection conn = (SipConnection) c;
                    add(conn);
                    {
                        boolean var0F3E8D2D4CC8A5C0357E07264342DA94_570010847 = (conn.getState() == Call.State.HOLDING);
                        {
                            conn.unhold(audioGroup);
                        } 
                    } 
                } 
            } 
            that.setState(Call.State.IDLE);
            addTaint(that.getTaint());
            
            
            
                    
            
                
                
                
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.280 -0400", hash_original_method = "C804E92B54898C48FBC0803D66022DE0", hash_generated_method = "5D86A55C8B4BEA3C0DEF857CEFAFD26F")
        private void add(SipConnection conn) {
            SipCall call = conn.getCall();
            {
                boolean varB8F4F262BFDCEFC335F4E56671E9F1DA_3095157 = (call == this);
            } 
            call.connections.remove(conn);
            connections.add(conn);
            conn.changeOwner(this);
            addTaint(conn.getTaint());
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.281 -0400", hash_original_method = "994C45B8BD8978A705E69F1BE351A00B", hash_generated_method = "BC66848070E19266A361AFF219A3D3E0")
         void sendDtmf(char c) {
            AudioGroup audioGroup = getAudioGroup();
            audioGroup.sendDtmf(convertDtmf(c));
            addTaint(c);
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.281 -0400", hash_original_method = "C4229E0DAB0B84D6720429F368FEF1C3", hash_generated_method = "49F7C203EC243C2979C54F9C0BD12AEB")
        private int convertDtmf(char c) {
            int code = c - '0';
            {
                
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "invalid DTMF char: " + (int) c);
                
            } 
            addTaint(c);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_254469064 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_254469064;
            
            
            
                
                    
                    
                    
                    
                    
                    
                    
                        
                                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.282 -0400", hash_original_method = "A20E6ED570A38BE2669CFE3ED9219E0D", hash_generated_method = "FCDE0DF59BA2F85CBAA4E2866169FE95")
        @Override
        protected void setState(State newState) {
            {
                {
                    state = newState;
                    SipPhone.this.startRingbackTone();
                } 
                {
                    SipPhone.this.stopRingbackTone();
                } 
                state = newState;
                updatePhoneState();
                notifyPreciseCallStateChanged();
            } 
            addTaint(newState.getTaint());
            
            
                
                        
                        
                
                    
                    
                
                    
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.282 -0400", hash_original_method = "9B48819375B09AF6C57EC0D05234CB41", hash_generated_method = "990CC098C4D7C3DE6BBB9AAC0FCC900A")
         void onConnectionStateChanged(SipConnection conn) {
            
            {
                setState(conn.getState());
            } 
            addTaint(conn.getTaint());
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.290 -0400", hash_original_method = "67A791C264A58046C696AC400E0B1106", hash_generated_method = "0E8DC5F1DD7923F808ED800912E47FF5")
         void onConnectionEnded(SipConnection conn) {
            
            {
                boolean allConnectionsDisconnected = true;
                Log.d(LOG_TAG, "---check connections: "
                        + connections.size());
                {
                    Iterator<Connection> varE43AC770406DBA1185F3DAFDE696E6A3_407628002 = (connections).iterator();
                    varE43AC770406DBA1185F3DAFDE696E6A3_407628002.hasNext();
                    Connection c = varE43AC770406DBA1185F3DAFDE696E6A3_407628002.next();
                    {
                        Log.d(LOG_TAG, "   state=" + c.getState() + ": "
                            + c);
                        {
                            boolean varCAA7A57C3F38B59482436E96FBF861E4_1704249100 = (c.getState() != State.DISCONNECTED);
                            {
                                allConnectionsDisconnected = false;
                            } 
                        } 
                    } 
                } 
                setState(State.DISCONNECTED);
            } 
            notifyDisconnectP(conn);
            addTaint(conn.getTaint());
            
            
                
                
                        
                
                    
                            
                    
                        
                        
                    
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.292 -0400", hash_original_method = "3BDED5D4E6618481393AD33B1F728E6A", hash_generated_method = "CC76872DABA9C96F9B261FC647C87641")
        private AudioGroup getAudioGroup() {
            AudioGroup varB4EAC82CA7396A68D541C85D26508E83_349237310 = null; 
            AudioGroup varB4EAC82CA7396A68D541C85D26508E83_139049719 = null; 
            {
                boolean var9D37F75EA12D86F1A0D608B063CA8508_1643561772 = (connections.isEmpty());
                varB4EAC82CA7396A68D541C85D26508E83_349237310 = null;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_139049719 = ((SipConnection) connections.get(0)).getAudioGroup();
            AudioGroup varA7E53CE21691AB073D9660D615818899_982476935; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_982476935 = varB4EAC82CA7396A68D541C85D26508E83_349237310;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_982476935 = varB4EAC82CA7396A68D541C85D26508E83_139049719;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_982476935.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_982476935;
            
            
            
        }

        
    }


    
    private class SipConnection extends SipConnectionBase {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.293 -0400", hash_original_field = "4AA3D5C224CE197897B9C6F17BF367CD", hash_generated_field = "D7165953848BB574FCA583AB16464D4F")

        private SipCall mOwner;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.293 -0400", hash_original_field = "DF701BED26C9A6E82B434D3ADA19F19A", hash_generated_field = "D1359B5A0587476130FC171DA764AC68")

        private SipAudioCall mSipAudioCall;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.293 -0400", hash_original_field = "9E8FCF5D95B61569BEBFA55673940468", hash_generated_field = "DFC050C51766232BD82C770760A2DF3D")

        private Call.State mState = Call.State.IDLE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.293 -0400", hash_original_field = "6F401FEEE3A56ED571384DFAB76AA449", hash_generated_field = "06F960DE9AD1B3C2161E1D3DDDEEE930")

        private SipProfile mPeer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.293 -0400", hash_original_field = "44366EF9F63882F1E47C480ECB6765BD", hash_generated_field = "EC5248A9D1818320AA647E3B388AFC57")

        private String mOriginalNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.293 -0400", hash_original_field = "08E4E08A45FD9BD63A8B432D59B0CB98", hash_generated_field = "CEABB36F0D8DD49AB2FFAD188EF64025")

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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.300 -0400", hash_original_method = "EB041B636E30FA2F3190616100DC4B14", hash_generated_method = "D02AEE3D5DDE08332E361E5B938B30A9")
        public  SipConnection(SipCall owner, SipProfile callee,
                String originalNumber) {
            super(originalNumber);
            mOwner = owner;
            mPeer = callee;
            mOriginalNumber = originalNumber;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.301 -0400", hash_original_method = "0957F2328B233DD414C835AB48AD0504", hash_generated_method = "F22895157E71840C75F8BC0F1E6A9DB8")
        public  SipConnection(SipCall owner, SipProfile callee) {
            this(owner, callee, getUriString(callee));
            addTaint(owner.getTaint());
            addTaint(callee.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.301 -0400", hash_original_method = "57E4C10F499E8E36FDDCF5DF3794947E", hash_generated_method = "83A3D9228CE7439028CB891F63ADE5D9")
        @Override
        public String getCnapName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1750809282 = null; 
            String displayName = mPeer.getDisplayName();
            varB4EAC82CA7396A68D541C85D26508E83_1750809282 = TextUtils.isEmpty(displayName) ? null
                                                  : displayName;
            varB4EAC82CA7396A68D541C85D26508E83_1750809282.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1750809282;
            
            
            
                                                  
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.302 -0400", hash_original_method = "6B6F8D6F29C0FEAF9C52CC30010D6FE2", hash_generated_method = "9763E81FEF907D2882196F9CF7442E4D")
        @Override
        public int getNumberPresentation() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_890425203 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_890425203;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.302 -0400", hash_original_method = "14BDBA500BD81C7014F8447F04B9333E", hash_generated_method = "C343C83C3F139AA3E8AD1000032FDE5F")
         void initIncomingCall(SipAudioCall sipAudioCall, Call.State newState) {
            setState(newState);
            mSipAudioCall = sipAudioCall;
            sipAudioCall.setListener(mAdapter);
            mIncoming = true;
            addTaint(newState.getTaint());
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.302 -0400", hash_original_method = "62A265BABD2EF644B89898FE1DF3E037", hash_generated_method = "E88D0586F9497F58EC7DB8C51FD62A85")
         void acceptCall() throws CallStateException {
            try 
            {
                mSipAudioCall.answerCall(TIMEOUT_ANSWER_CALL);
            } 
            catch (SipException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("acceptCall(): " + e);
            } 
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.303 -0400", hash_original_method = "5D5AACCF3178F43A37FA6476F3FA2309", hash_generated_method = "F4F212B9E8EECDAFB8ECD3B21BCA89BD")
         void changeOwner(SipCall owner) {
            mOwner = owner;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.303 -0400", hash_original_method = "81195A6CBC9B38EAFBB5618CD4E171CB", hash_generated_method = "4F7A77AEE8A65260AEFBF9D071AD6C5C")
         AudioGroup getAudioGroup() {
            AudioGroup varB4EAC82CA7396A68D541C85D26508E83_1954661185 = null; 
            AudioGroup varB4EAC82CA7396A68D541C85D26508E83_1194637538 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1954661185 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1194637538 = mSipAudioCall.getAudioGroup();
            AudioGroup varA7E53CE21691AB073D9660D615818899_735497723; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_735497723 = varB4EAC82CA7396A68D541C85D26508E83_1954661185;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_735497723 = varB4EAC82CA7396A68D541C85D26508E83_1194637538;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_735497723.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_735497723;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.304 -0400", hash_original_method = "766A0FDDBD2B3A4E947C7E8FBAB0F165", hash_generated_method = "93C009E595843D9B5B39352F3D675F51")
         void dial() throws SipException {
            setState(Call.State.DIALING);
            mSipAudioCall = mSipManager.makeAudioCall(mProfile, mPeer, null,
                    TIMEOUT_MAKE_CALL);
            mSipAudioCall.setListener(mAdapter);
            
            
            
                    
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.304 -0400", hash_original_method = "DDAA74ADB7976F32813665FE128238CD", hash_generated_method = "BD6ABA7F7127C0C77F83B3BF0D8D517A")
         void hold() throws CallStateException {
            setState(Call.State.HOLDING);
            try 
            {
                mSipAudioCall.holdCall(TIMEOUT_HOLD_CALL);
            } 
            catch (SipException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("hold(): " + e);
            } 
            
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.305 -0400", hash_original_method = "F77273A2CD584255814B6B238AF1477E", hash_generated_method = "3DE8BD0BBE2A340A0377B97A1F53C91E")
         void unhold(AudioGroup audioGroup) throws CallStateException {
            mSipAudioCall.setAudioGroup(audioGroup);
            setState(Call.State.ACTIVE);
            try 
            {
                mSipAudioCall.continueCall(TIMEOUT_HOLD_CALL);
            } 
            catch (SipException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new CallStateException("unhold(): " + e);
            } 
            addTaint(audioGroup.getTaint());
            
            
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.306 -0400", hash_original_method = "91B9A79444A0C09E86ABE6F5C7C89706", hash_generated_method = "4D1AD2A714D5A0A03613A134D8F03272")
         void setMute(boolean muted) {
            {
                boolean var6B5DA206A9FAB2FBF22E68E89DEB93FC_1787383570 = ((mSipAudioCall != null) && (muted != mSipAudioCall.isMuted()));
                {
                    mSipAudioCall.toggleMute();
                } 
            } 
            addTaint(muted);
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.307 -0400", hash_original_method = "E20C6A660C2E35A5253ACCD901B5D855", hash_generated_method = "1AC316493A3F2A9D42771F69C06D3454")
         boolean getMute() {
            {
                Object var6F96A3C795A4C1621DD07938C9161660_1237059123 = (mSipAudioCall.isMuted());
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1154827805 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1154827805;
            
            
                                           
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.307 -0400", hash_original_method = "1833AE90ADB0C663418065E2EE17BAF0", hash_generated_method = "F7BF78C03975EEB51BBB5EBAECE9F1D9")
        @Override
        protected void setState(Call.State state) {
            super.setState(state);
            mState = state;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.308 -0400", hash_original_method = "0D6E90F055C537B49BE3263741E0D2AC", hash_generated_method = "E08D358002590618A2A7062EAFE89B3A")
        @Override
        public Call.State getState() {
            Call.State varB4EAC82CA7396A68D541C85D26508E83_1586786406 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1586786406 = mState;
            varB4EAC82CA7396A68D541C85D26508E83_1586786406.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1586786406;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.309 -0400", hash_original_method = "0C9900F417D1D38623450F6C44261C8A", hash_generated_method = "90D8A6E511AFDA25A3CE44B3C36AA6A0")
        @Override
        public boolean isIncoming() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_170741332 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_170741332;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.309 -0400", hash_original_method = "FE0C81270397910192F7BF8C9CDDDAB6", hash_generated_method = "F04FF5B807B1256AD0287DAE12A79103")
        @Override
        public String getAddress() {
            String varB4EAC82CA7396A68D541C85D26508E83_1178257707 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1178257707 = mOriginalNumber;
            varB4EAC82CA7396A68D541C85D26508E83_1178257707.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1178257707;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.310 -0400", hash_original_method = "710C86DFEBE06A4514867B4563DB846F", hash_generated_method = "48795D2FEA8E180E4C4AE2C9A21C52BA")
        @Override
        public SipCall getCall() {
            SipCall varB4EAC82CA7396A68D541C85D26508E83_298249362 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_298249362 = mOwner;
            varB4EAC82CA7396A68D541C85D26508E83_298249362.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_298249362;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.310 -0400", hash_original_method = "925322092199D63FE2A7CC7A8AD6AC9C", hash_generated_method = "8B41FD40B9C33391292E1FA9A354CBD7")
        @Override
        protected Phone getPhone() {
            Phone varB4EAC82CA7396A68D541C85D26508E83_1069591192 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1069591192 = mOwner.getPhone();
            varB4EAC82CA7396A68D541C85D26508E83_1069591192.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1069591192;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.311 -0400", hash_original_method = "B35A599F4014F0A4981FF871F70F4B98", hash_generated_method = "64F328835B67BF354DBA34FC1933A790")
        @Override
        public void hangup() throws CallStateException {
            {
                Log.d(LOG_TAG, "hangup conn: " + mPeer.getUriString()
                        + ": " + mState + ": on phone "
                        + getPhone().getPhoneName());
                {
                    boolean var7A71802BC1B1F87328893952D19337CA_817276588 = (!mState.isAlive());
                } 
                try 
                {
                    SipAudioCall sipAudioCall = mSipAudioCall;
                    {
                        sipAudioCall.setListener(null);
                        sipAudioCall.endCall();
                    } 
                } 
                catch (SipException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new CallStateException("hangup(): " + e);
                } 
                finally 
                {
                    mAdapter.onCallEnded(((mState == Call.State.INCOMING)
                            || (mState == Call.State.WAITING))
                            ? DisconnectCause.INCOMING_REJECTED
                            : DisconnectCause.LOCAL);
                } 
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.311 -0400", hash_original_method = "7B400982296D21B9968B9808849E5473", hash_generated_method = "D3452833312B206A61C774C6D92FAD16")
        @Override
        public void separate() throws CallStateException {
            {
                SipCall call;
                boolean var9F2100AEF9AB3C51A66873B7B7B06C45_1772655402 = ((getPhone() == SipPhone.this));
                call = (SipCall) SipPhone.this.getBackgroundCall();
                call = (SipCall) SipPhone.this.getForegroundCall();
                {
                    boolean var06B2F1D0FB9C9B434F76B9D96A375019_2111198991 = (call.getState() != Call.State.IDLE);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new CallStateException(
                            "cannot put conn back to a call in non-idle state: "
                            + call.getState());
                    } 
                } 
                Log.d(LOG_TAG, "separate conn: "
                        + mPeer.getUriString() + " from " + mOwner + " back to "
                        + call);
                Phone originalPhone = getPhone();
                AudioGroup audioGroup = call.getAudioGroup();
                call.add(this);
                mSipAudioCall.setAudioGroup(audioGroup);
                originalPhone.switchHoldingAndActive();
                call = (SipCall) SipPhone.this.getForegroundCall();
                mSipAudioCall.startAudio();
                call.onConnectionStateChanged(this);
            } 
            
            
        }

        
    }


    
    private abstract class SipAudioCallAdapter extends SipAudioCall.Listener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.311 -0400", hash_original_method = "3AB54838416D4A721CFBD2C180A6FF7A", hash_generated_method = "3AB54838416D4A721CFBD2C180A6FF7A")
        public SipAudioCallAdapter ()
        {
            
        }


        protected abstract void onCallEnded(Connection.DisconnectCause cause);

        
        protected abstract void onError(Connection.DisconnectCause cause);

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.312 -0400", hash_original_method = "FAC45A8F53047AFBBF88628CAD98E6D5", hash_generated_method = "A5848E407AAF0106D276C2FB2ED18D01")
        @Override
        public void onCallEnded(SipAudioCall call) {
            
            onCallEnded(call.isInCall()
                    ? Connection.DisconnectCause.NORMAL
                    : Connection.DisconnectCause.INCOMING_MISSED);
            addTaint(call.getTaint());
            
            
                    
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.312 -0400", hash_original_method = "5FEE35421FE68DCB9D837EF94FC0CC79", hash_generated_method = "1BB9F92D03E2291554F0BCFEE0A95811")
        @Override
        public void onCallBusy(SipAudioCall call) {
            
            onCallEnded(Connection.DisconnectCause.BUSY);
            addTaint(call.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.313 -0400", hash_original_method = "7EFF641046EACBCFF45AD18624210100", hash_generated_method = "42C4EE7DD422BC289DAC47A015928959")
        @Override
        public void onError(SipAudioCall call, int errorCode,
                String errorMessage) {
            
            
            onError(Connection.DisconnectCause.SERVER_UNREACHABLE);
            
            
            onError(Connection.DisconnectCause.NUMBER_UNREACHABLE);
            
            
            onError(Connection.DisconnectCause.INVALID_NUMBER);
            
            
            onError(Connection.DisconnectCause.TIMED_OUT);
            
            
            onError(Connection.DisconnectCause.LOST_SIGNAL);
            
            
            onError(Connection.DisconnectCause.INVALID_CREDENTIALS);
            
            
            onError(Connection.DisconnectCause.OUT_OF_NETWORK);
            
            
            onError(Connection.DisconnectCause.SERVER_ERROR);
            
            
            onError(Connection.DisconnectCause.ERROR_UNSPECIFIED);
            
            addTaint(call.getTaint());
            addTaint(errorCode);
            addTaint(errorMessage.getTaint());
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.313 -0400", hash_original_field = "976523C589B0B5F84D4530AFB1044D93", hash_generated_field = "7A17420CA7320CD6991D9BB201E6C8AD")

    private static final String LOG_TAG = "SipPhone";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.313 -0400", hash_original_field = "BC4FF4C62A62F66D6D2E0A35B84DD24A", hash_generated_field = "0DA17BC1AEF6DBF011A4A750F5A71D57")

    private static final boolean DEBUG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.313 -0400", hash_original_field = "E41B978FAF3B339183EF17F3067BF0E9", hash_generated_field = "EB405364424B606CEA103C767EA0ADA3")

    private static final int TIMEOUT_MAKE_CALL = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.313 -0400", hash_original_field = "F955123D19BAEE32317A2241EE79907C", hash_generated_field = "973EB4EC28EADF6B6F1C1FDB9D5440C9")

    private static final int TIMEOUT_ANSWER_CALL = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.313 -0400", hash_original_field = "B3BD5D4BD687697B138A2662DACEECFF", hash_generated_field = "2FA826CBF5F1C3318478B665E6C65585")

    private static final int TIMEOUT_HOLD_CALL = 15;
}

