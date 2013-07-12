package android.net.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.media.AudioManager;
import android.net.rtp.AudioCodec;
import android.net.rtp.AudioGroup;
import android.net.rtp.AudioStream;
import android.net.rtp.RtpStream;
import android.net.sip.SimpleSessionDescription.Media;
import android.net.wifi.WifiManager;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SipAudioCall {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.279 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.279 -0400", hash_original_field = "FF1CB71BAB47D197D74F995BD9E7A803", hash_generated_field = "6E091E066D80096AB4790291B230BE96")

    private SipProfile mLocalProfile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.279 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "484D72CF31DE6402790176EF95A4C8E2")

    private SipAudioCall.Listener mListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.279 -0400", hash_original_field = "5A8516A00FC44EAD1FB2DF747AF176E7", hash_generated_field = "5A2B893C3FE2A9A2DE8E72D8792D353F")

    private SipSession mSipSession;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.279 -0400", hash_original_field = "696E4247B1C62891017C76DE2748F81D", hash_generated_field = "7C9004090DB280D3DD75EC1A1184D119")

    private SipSession mTransferringSession;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.279 -0400", hash_original_field = "B3D763F81031D116F4DDEFDCF2440B42", hash_generated_field = "7C64D41119E982E471870E4C818DD2D6")

    private long mSessionId = System.currentTimeMillis();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.279 -0400", hash_original_field = "489C27793E1C7DC00D4CE97B79831AE1", hash_generated_field = "9F59EE492C7A8D15690CB9BED1F25434")

    private String mPeerSd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.279 -0400", hash_original_field = "EED3B14E87D1A2B42EF2AAD48A1AE22C", hash_generated_field = "455D7DF5CAA0F63BF9C19FEC9C870ABC")

    private AudioStream mAudioStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.279 -0400", hash_original_field = "32C0A4CC3DE7ACB3907A60677CD6CE22", hash_generated_field = "62700614B1F5A2BE6501D87E3EA29746")

    private AudioGroup mAudioGroup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.279 -0400", hash_original_field = "DC811F268DA137B5E8B4F29600FBE75A", hash_generated_field = "7E358D7A0A2BA24FEA1EEA744FA91417")

    private boolean mInCall = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.279 -0400", hash_original_field = "1BC50C90C4537359FC1A482E47241617", hash_generated_field = "DAFCCC98CC29AFA37BE6BA4063A2F9C9")

    private boolean mMuted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.279 -0400", hash_original_field = "361220807CF04190F95695EA0129F31B", hash_generated_field = "2F42C58AE349901E944BC55F3F826C78")

    private boolean mHold = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.279 -0400", hash_original_field = "0AB50DE2E26B9721C5B5325D428A43AF", hash_generated_field = "B20041B31BF3C63BEA61010725B48956")

    private SipProfile mPendingCallRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.279 -0400", hash_original_field = "40E135D566C7D45C48786027486A41F9", hash_generated_field = "AA909A8A1E3B0EDD8AADADB48D5C730C")

    private WifiManager mWm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.279 -0400", hash_original_field = "0A13C2715EDB39FB8407B99856966C2F", hash_generated_field = "1064E8BF494EAE96395CFD56F6281589")

    private WifiManager.WifiLock mWifiHighPerfLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.279 -0400", hash_original_field = "617AB537A3FB63945C0DB8523A8EAAA5", hash_generated_field = "6408008D03AC8F90F3CE0B460908E415")

    private int mErrorCode = SipErrorCode.NO_ERROR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.280 -0400", hash_original_field = "DDF57A354F36667F5635F5344D9C8DEA", hash_generated_field = "CBCF3C2AB9532780C0A69F6C63B81E66")

    private String mErrorMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.280 -0400", hash_original_method = "E52D3B9BC90DBBDF3C179757863C5D97", hash_generated_method = "756A0602EA41970B104F8D81707C3875")
    public  SipAudioCall(Context context, SipProfile localProfile) {
        mContext = context;
        mLocalProfile = localProfile;
        mWm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.280 -0400", hash_original_method = "624C526ACE340C91B4AE00384193A96D", hash_generated_method = "B9E9FB4AE9D04DBD4B75E26C1D98D9F5")
    public void setListener(SipAudioCall.Listener listener) {
        addTaint(listener.getTaint());
        setListener(listener, false);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.281 -0400", hash_original_method = "7FD2357D0901F6F1D08ACBD882A0FD6F", hash_generated_method = "557DEFC1291601FA55CC52554394A562")
    public void setListener(SipAudioCall.Listener listener,
            boolean callbackImmediately) {
        addTaint(callbackImmediately);
        mListener = listener;
        try 
        {
    if((listener == null) || !callbackImmediately)            
            {
            } 
            else
    if(mErrorCode != SipErrorCode.NO_ERROR)            
            {
                listener.onError(this, mErrorCode, mErrorMessage);
            } 
            else
    if(mInCall)            
            {
    if(mHold)                
                {
                    listener.onCallHeld(this);
                } 
                else
                {
                    listener.onCallEstablished(this);
                } 
            } 
            else
            {
                int state = getState();
switch(state){
                case SipSession.State.READY_TO_CALL:
                listener.onReadyToCall(this);
                break;
                case SipSession.State.INCOMING_CALL:
                listener.onRinging(this, getPeerProfile());
                break;
                case SipSession.State.OUTGOING_CALL:
                listener.onCalling(this);
                break;
                case SipSession.State.OUTGOING_CALL_RING_BACK:
                listener.onRingingBack(this);
                break;
}
            } 
        } 
        catch (Throwable t)
        {
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.281 -0400", hash_original_method = "5739155C46DD20825CE1C589327CD281", hash_generated_method = "D8FB1E21FD941CB6E9CB63AEB8E66B87")
    public boolean isInCall() {
        synchronized
(this)        {
            boolean var029969C04EB46A7AE3BF4D86DDAFBBE9_163595196 = (mInCall);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_99573723 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_99573723;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.281 -0400", hash_original_method = "2FD69B096455E1B51D801F19A8DBFD35", hash_generated_method = "4A8F7FD0360C11AD8600419C236C3EE9")
    public boolean isOnHold() {
        synchronized
(this)        {
            boolean var27ED35B893B6B9D6977636C4667DE0BF_1255726212 = (mHold);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_326512738 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_326512738;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.282 -0400", hash_original_method = "597B95CEB5AFD05C977FB508D047C50E", hash_generated_method = "21668DF8FDBDBCA1A469227829ADE78B")
    public void close() {
        close(true);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.282 -0400", hash_original_method = "AA0DE56AB4C8CE099E885498EC0B29F9", hash_generated_method = "19DA3E5282345ECE79D0817ED58E4AFE")
    private synchronized void close(boolean closeRtp) {
        addTaint(closeRtp);
    if(closeRtp)        
        stopCall(RELEASE_SOCKET);
        mInCall = false;
        mHold = false;
        mSessionId = System.currentTimeMillis();
        mErrorCode = SipErrorCode.NO_ERROR;
        mErrorMessage = null;
    if(mSipSession != null)        
        {
            mSipSession.setListener(null);
            mSipSession = null;
        } 
        
        
        
        
        
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.282 -0400", hash_original_method = "A61765ACD427BC1BAFB034CDA7289AED", hash_generated_method = "4C43228FE85993411C06ADE533F519C3")
    public SipProfile getLocalProfile() {
        synchronized
(this)        {
SipProfile var435CC30651DB1BF41891A0CDD6107277_498183144 =             mLocalProfile;
            var435CC30651DB1BF41891A0CDD6107277_498183144.addTaint(taint);
            return var435CC30651DB1BF41891A0CDD6107277_498183144;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.283 -0400", hash_original_method = "35C9BB243C8C9C83D8B1884AE3FDA6C7", hash_generated_method = "4FFB8854DB6C50C79E9739D2F4040218")
    public SipProfile getPeerProfile() {
        synchronized
(this)        {
SipProfile var1F5B6E206EF352601A1166F3159D4E4E_52229583 =             (mSipSession == null) ? null : mSipSession.getPeerProfile();
            var1F5B6E206EF352601A1166F3159D4E4E_52229583.addTaint(taint);
            return var1F5B6E206EF352601A1166F3159D4E4E_52229583;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.283 -0400", hash_original_method = "6859CB7872625AC40861B5EFD6D7E2DC", hash_generated_method = "ED5E6CA3BF7F73079D3B7C6CD278D9EA")
    public int getState() {
        synchronized
(this)        {
    if(mSipSession == null)            
            {
            int varB29DC7B021E518F7608AC91700D3FFA9_1608617356 = (SipSession.State.READY_TO_CALL);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_121967276 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_121967276;
            }
            int var8CEF1F27D8AE093B3E141AB7E6C7E59D_485200781 = (mSipSession.getState());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_200411733 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_200411733;
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.283 -0400", hash_original_method = "9DD9B38A5D2A310FA14C467CD9F0FD11", hash_generated_method = "A951FEBEAC85DCDA6053D7AC45880E3B")
    public SipSession getSipSession() {
        synchronized
(this)        {
SipSession varC0E7CBD9D248459FA598C4FAB18B8428_2067705405 =             mSipSession;
            varC0E7CBD9D248459FA598C4FAB18B8428_2067705405.addTaint(taint);
            return varC0E7CBD9D248459FA598C4FAB18B8428_2067705405;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.284 -0400", hash_original_method = "88FD57B0E3684A7BA74DB8405E64F4E3", hash_generated_method = "4FB06C75E0E7EC9D1A84E901B9A067C0")
    private synchronized void transferToNewSession() {
    if(mTransferringSession == null)        
        return;
        SipSession origin = mSipSession;
        mSipSession = mTransferringSession;
        mTransferringSession = null;
    if(mAudioStream != null)        
        {
            mAudioStream.join(null);
        } 
        else
        {
            try 
            {
                mAudioStream = new AudioStream(InetAddress.getByName(
                        getLocalIp()));
            } 
            catch (Throwable t)
            {
            } 
        } 
    if(origin != null)        
        origin.endCall();
        startAudio();
        
        
        
        
        
        
            
        
            
                
                        
            
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.290 -0400", hash_original_method = "5E0B84D644E5F5257B7A32D95C62CBE3", hash_generated_method = "5D2F565A33D9866ADB13C9CA6C4CB72C")
    private SipSession.Listener createListener() {
SipSession.Listener var471FDD296ED6D8C124DBA353D5A605DC_85907350 =         new SipSession.Listener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.287 -0400", hash_original_method = "0B4EFC2EA5E0F3FF31D08EEDE61256FC", hash_generated_method = "5202870B0DE4A45D21019912E0E67697")
        @Override
        public void onCalling(SipSession session) {
            
            addTaint(session.getTaint());
            Log.d(TAG, "calling... " + session);
            Listener listener = mListener;
    if(listener != null)            
            {
                try 
                {
                    listener.onCalling(SipAudioCall.this);
                } 
                catch (Throwable t)
                {
                } 
            } 
            
            
            
            
                    
                        
                    
                        
                    
                
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.287 -0400", hash_original_method = "FA01AFE96119E691A320DB4A08849437", hash_generated_method = "9BA159F9DD1889EB9859EC9A43AAFC4E")
        @Override
        public void onRingingBack(SipSession session) {
            
            addTaint(session.getTaint());
            Log.d(TAG, "sip call ringing back: " + session);
            Listener listener = mListener;
    if(listener != null)            
            {
                try 
                {
                    listener.onRingingBack(SipAudioCall.this);
                } 
                catch (Throwable t)
                {
                } 
            } 
            
            
            
            
                    
                        
                    
                        
                    
                
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.287 -0400", hash_original_method = "7370CA2F33F803A4BC98509DFD10599B", hash_generated_method = "E6157A92F7DB0003E885EEF890DE95E4")
        @Override
        public void onRinging(SipSession session,
                    SipProfile peerProfile, String sessionDescription) {
            
            addTaint(sessionDescription.getTaint());
            addTaint(peerProfile.getTaint());
            addTaint(session.getTaint());
            synchronized
(SipAudioCall.this)            {
    if((mSipSession == null) || !mInCall
                            || !session.getCallId().equals(
                                    mSipSession.getCallId()))                
                {
                    session.endCall();
                    return;
                } 
                try 
                {
                    String answer = createAnswer(sessionDescription).encode();
                    mSipSession.answerCall(answer, SESSION_TIMEOUT);
                } 
                catch (Throwable e)
                {
                    session.endCall();
                } 
            } 
            
            
                    
                            
                                    
                        
                        
                    
                    
                        
                        
                    
                        
                        
                    
                
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.288 -0400", hash_original_method = "40BF40985539E4127A37E81035B80A7A", hash_generated_method = "A21F153074FA3366CBF54F1E85DFEAB2")
        @Override
        public void onCallEstablished(SipSession session,
                    String sessionDescription) {
            
            addTaint(sessionDescription.getTaint());
            addTaint(session.getTaint());
            mPeerSd = sessionDescription;
    if((mTransferringSession != null)
                        && (session == mTransferringSession))            
            {
                transferToNewSession();
                return;
            } 
            Listener listener = mListener;
    if(listener != null)            
            {
                try 
                {
    if(mHold)                    
                    {
                        listener.onCallHeld(SipAudioCall.this);
                    } 
                    else
                    {
                        listener.onCallEstablished(SipAudioCall.this);
                    } 
                } 
                catch (Throwable t)
                {
                } 
            } 
            
            
            
            
                        
                    
                    
                
            
            
                    
                        
                            
                        
                            
                        
                    
                        
                    
                
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.288 -0400", hash_original_method = "1DE904A1CABA70AB1A25A453A4094AFC", hash_generated_method = "A450206D97EDFDDDE88414E7D8BEB597")
        @Override
        public void onCallEnded(SipSession session) {
            
            addTaint(session.getTaint());
            Log.d(TAG, "sip call ended: " + session + " mSipSession:" + mSipSession);
    if(session == mTransferringSession)            
            {
                mTransferringSession = null;
                return;
            } 
    if((mTransferringSession != null) ||
                    (session != mSipSession))            
            return;
            Listener listener = mListener;
    if(listener != null)            
            {
                try 
                {
                    listener.onCallEnded(SipAudioCall.this);
                } 
                catch (Throwable t)
                {
                } 
            } 
            close();
            
            
            
                    
                    
                
            
                    
            
            
                    
                        
                    
                        
                    
                
            
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.289 -0400", hash_original_method = "3CC4E6D954281F2D5FD31AADF17A6DC9", hash_generated_method = "11462D591CE55AB7CB25CF3742988779")
        @Override
        public void onCallBusy(SipSession session) {
            
            addTaint(session.getTaint());
            Log.d(TAG, "sip call busy: " + session);
            Listener listener = mListener;
    if(listener != null)            
            {
                try 
                {
                    listener.onCallBusy(SipAudioCall.this);
                } 
                catch (Throwable t)
                {
                } 
            } 
            close(false);
            
            
            
            
                    
                        
                    
                        
                    
                
            
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.289 -0400", hash_original_method = "16D7065ED36A3B723322ABAA4FB7FA22", hash_generated_method = "BB5DA898AFA1A9FC460707DFD96278EB")
        @Override
        public void onCallChangeFailed(SipSession session, int errorCode,
                    String message) {
            
            addTaint(message.getTaint());
            addTaint(errorCode);
            addTaint(session.getTaint());
            Log.d(TAG, "sip call change failed: " + message);
            mErrorCode = errorCode;
            mErrorMessage = message;
            Listener listener = mListener;
    if(listener != null)            
            {
                try 
                {
                    listener.onError(SipAudioCall.this, mErrorCode,
                                message);
                } 
                catch (Throwable t)
                {
                } 
            } 
            
            
            
            
            
            
                    
                        
                                
                    
                        
                    
                
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.289 -0400", hash_original_method = "F58D9162CF10989F568AF55ED18D4C89", hash_generated_method = "87C07FE4E8C14A3E09B742E2A4FECA2C")
        @Override
        public void onError(SipSession session, int errorCode,
                    String message) {
            
            addTaint(message.getTaint());
            addTaint(errorCode);
            addTaint(session.getTaint());
            SipAudioCall.this.onError(errorCode, message);
            
            
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.289 -0400", hash_original_method = "20558DF6BFC1217A7001B14AA50A9A03", hash_generated_method = "F300F8563E2587C43E9A378D2BD8E08B")
        @Override
        public void onRegistering(SipSession session) {
            
            addTaint(session.getTaint());
            
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.289 -0400", hash_original_method = "43D598AFE19AB6009363638DB64C1F7B", hash_generated_method = "86A86E3C8876E69F7313F986859C72AD")
        @Override
        public void onRegistrationTimeout(SipSession session) {
            
            addTaint(session.getTaint());
            
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.290 -0400", hash_original_method = "E69FEDA3BC0AF93EB01ADFD4BE332B13", hash_generated_method = "3AEC36D4EFA6F63878CA08B8E3AF5556")
        @Override
        public void onRegistrationFailed(SipSession session, int errorCode,
                    String message) {
            
            addTaint(message.getTaint());
            addTaint(errorCode);
            addTaint(session.getTaint());
            
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.290 -0400", hash_original_method = "7504CEF239C11FEA532F08720FD2042B", hash_generated_method = "CAF2CF01272249C84CB83D8CFB4868BD")
        @Override
        public void onRegistrationDone(SipSession session, int duration) {
            
            addTaint(duration);
            addTaint(session.getTaint());
            
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.290 -0400", hash_original_method = "5F9A92DE1F30C09A899AB4EFC4F87B6D", hash_generated_method = "F5D8488E0997CB696B463C4487D5AA10")
        @Override
        public void onCallTransferring(SipSession newSession,
                    String sessionDescription) {
            
            addTaint(sessionDescription.getTaint());
            addTaint(newSession.getTaint());
            mTransferringSession = newSession;
            try 
            {
    if(sessionDescription == null)                
                {
                    newSession.makeCall(newSession.getPeerProfile(),
                                createOffer().encode(), TRANSFER_TIMEOUT);
                } 
                else
                {
                    String answer = createAnswer(sessionDescription).encode();
                    newSession.answerCall(answer, SESSION_TIMEOUT);
                } 
            } 
            catch (Throwable e)
            {
                newSession.endCall();
            } 
            
            
                        
            
            
                    
                        
                                
                    
                        
                        
                    
                
                    
                    
                
        }
};
        var471FDD296ED6D8C124DBA353D5A605DC_85907350.addTaint(taint);
        return var471FDD296ED6D8C124DBA353D5A605DC_85907350;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.291 -0400", hash_original_method = "20EC585B752C6E63355D5D35BEA59116", hash_generated_method = "F995E802C90C8314AA9BF9146DCAA7D8")
    private void onError(int errorCode, String message) {
        Log.d(TAG, "sip session error: "
                + SipErrorCode.toString(errorCode) + ": " + message);
        mErrorCode = errorCode;
        mErrorMessage = message;
        Listener listener = mListener;
    if(listener != null)        
        {
            try 
            {
                listener.onError(this, errorCode, message);
            } 
            catch (Throwable t)
            {
            } 
        } 
        synchronized
(this)        {
    if((errorCode == SipErrorCode.DATA_CONNECTION_LOST)
                    || !isInCall())            
            {
                close(true);
            } 
        } 
        
        
                
        
        
        
        
            
                
            
                
            
        
        
            
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.291 -0400", hash_original_method = "9D47ECE9B5A5E502049A76A2D5CF7D58", hash_generated_method = "50828C6B7329EF137AE2A6692C86163A")
    public void attachCall(SipSession session, String sessionDescription) throws SipException {
    if(!SipManager.isVoipSupported(mContext))        
        {
            SipException var8139D71B537813371F04348D0E0BAE9A_1096662208 = new SipException("VOIP API is not supported");
            var8139D71B537813371F04348D0E0BAE9A_1096662208.addTaint(taint);
            throw var8139D71B537813371F04348D0E0BAE9A_1096662208;
        } 
        synchronized
(this)        {
            mSipSession = session;
            mPeerSd = sessionDescription;
            try 
            {
                session.setListener(createListener());
            } 
            catch (Throwable e)
            {
                throwSipException(e);
            } 
        } 
        
        
            
        
        
            
            
            
            
                
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.292 -0400", hash_original_method = "CDFD7E26E80EFA4595D6BD4E5712D0C4", hash_generated_method = "83F904B26E4719D0862668A9C2083F39")
    public void makeCall(SipProfile peerProfile, SipSession sipSession,
            int timeout) throws SipException {
        addTaint(timeout);
        addTaint(peerProfile.getTaint());
    if(!SipManager.isVoipSupported(mContext))        
        {
            SipException var8139D71B537813371F04348D0E0BAE9A_1429360680 = new SipException("VOIP API is not supported");
            var8139D71B537813371F04348D0E0BAE9A_1429360680.addTaint(taint);
            throw var8139D71B537813371F04348D0E0BAE9A_1429360680;
        } 
        synchronized
(this)        {
            mSipSession = sipSession;
            try 
            {
                mAudioStream = new AudioStream(InetAddress.getByName(
                        getLocalIp()));
                sipSession.setListener(createListener());
                sipSession.makeCall(peerProfile, createOffer().encode(),
                        timeout);
            } 
            catch (IOException e)
            {
                SipException varD52E1E6302BE50931CCBD6D638ECDB3D_1097887343 = new SipException("makeCall()", e);
                varD52E1E6302BE50931CCBD6D638ECDB3D_1097887343.addTaint(taint);
                throw varD52E1E6302BE50931CCBD6D638ECDB3D_1097887343;
            } 
        } 
        
        
            
        
        
            
            
                
                        
                
                
                        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.292 -0400", hash_original_method = "DFE2EF72B1133A207E3F57586EB6C6EB", hash_generated_method = "96300DA689C3366FBDE5C9E994D71D66")
    public void endCall() throws SipException {
        synchronized
(this)        {
            stopCall(RELEASE_SOCKET);
            mInCall = false;
    if(mSipSession != null)            
            mSipSession.endCall();
        } 
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.293 -0400", hash_original_method = "83B252D66EF8BD3A5BE285DBF75AA925", hash_generated_method = "834BAD1A1B928734684A6E1553A53B05")
    public void holdCall(int timeout) throws SipException {
        addTaint(timeout);
        synchronized
(this)        {
    if(mHold)            
            return;
    if(mSipSession == null)            
            {
                SipException varD54DFA089F8D2841097BE663B9D68A62_499922698 = new SipException("Not in a call to hold call");
                varD54DFA089F8D2841097BE663B9D68A62_499922698.addTaint(taint);
                throw varD54DFA089F8D2841097BE663B9D68A62_499922698;
            } 
            mSipSession.changeCall(createHoldOffer().encode(), timeout);
            mHold = true;
            setAudioGroupMode();
        } 
        
        
            
            
                
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.293 -0400", hash_original_method = "7A338589242F74847BFE21BB083282FF", hash_generated_method = "400538F195781ED3999996A861567639")
    public void answerCall(int timeout) throws SipException {
        addTaint(timeout);
        synchronized
(this)        {
    if(mSipSession == null)            
            {
                SipException var651640E4FC6E2248161543E83AEB05BC_1362285865 = new SipException("No call to answer");
                var651640E4FC6E2248161543E83AEB05BC_1362285865.addTaint(taint);
                throw var651640E4FC6E2248161543E83AEB05BC_1362285865;
            } 
            try 
            {
                mAudioStream = new AudioStream(InetAddress.getByName(
                        getLocalIp()));
                mSipSession.answerCall(createAnswer(mPeerSd).encode(), timeout);
            } 
            catch (IOException e)
            {
                SipException var4404AF18DB5E424A2998226EFEAA184B_786551771 = new SipException("answerCall()", e);
                var4404AF18DB5E424A2998226EFEAA184B_786551771.addTaint(taint);
                throw var4404AF18DB5E424A2998226EFEAA184B_786551771;
            } 
        } 
        
        
            
                
            
            
                
                        
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.294 -0400", hash_original_method = "FE14EBF8C515C93259E0563DEA133194", hash_generated_method = "9C15B0B71E04573355873D8E5CC610D8")
    public void continueCall(int timeout) throws SipException {
        addTaint(timeout);
        synchronized
(this)        {
    if(!mHold)            
            return;
            mSipSession.changeCall(createContinueOffer().encode(), timeout);
            mHold = false;
            setAudioGroupMode();
        } 
        
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.294 -0400", hash_original_method = "0D8E98137E8907FA474D9700B196F628", hash_generated_method = "8E7EAAA75818D06F5B8B26341CE73DA9")
    private SimpleSessionDescription createOffer() {
        SimpleSessionDescription offer = new SimpleSessionDescription(mSessionId, getLocalIp());
        AudioCodec[] codecs = AudioCodec.getCodecs();
        Media media = offer.newMedia(
                "audio", mAudioStream.getLocalPort(), 1, "RTP/AVP");
for(AudioCodec codec : AudioCodec.getCodecs())
        {
            media.setRtpPayload(codec.type, codec.rtpmap, codec.fmtp);
        } 
        media.setRtpPayload(127, "telephone-event/8000", "0-15");
SimpleSessionDescription varB15AE9D99DEF4F854AE55C3D652AFE1B_1615658033 =         offer;
        varB15AE9D99DEF4F854AE55C3D652AFE1B_1615658033.addTaint(taint);
        return varB15AE9D99DEF4F854AE55C3D652AFE1B_1615658033;
        
        
                
        
        
                
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.295 -0400", hash_original_method = "7AC71E8F4C8E41998B13EFBED71D93BD", hash_generated_method = "C38BE53DA3CFBE9AAA3059158907EC3C")
    private SimpleSessionDescription createAnswer(String offerSd) {
        addTaint(offerSd.getTaint());
    if(TextUtils.isEmpty(offerSd))        
        {
SimpleSessionDescription var75B8119AF2E32D0B1EEBC0D47AD981F0_1132669214 =         createOffer();
        var75B8119AF2E32D0B1EEBC0D47AD981F0_1132669214.addTaint(taint);
        return var75B8119AF2E32D0B1EEBC0D47AD981F0_1132669214;
        }
        SimpleSessionDescription offer = new SimpleSessionDescription(offerSd);
        SimpleSessionDescription answer = new SimpleSessionDescription(mSessionId, getLocalIp());
        AudioCodec codec = null;
for(Media media : offer.getMedia())
        {
    if((codec == null) && (media.getPort() > 0)
                    && "audio".equals(media.getType())
                    && "RTP/AVP".equals(media.getProtocol()))            
            {
for(int type : media.getRtpPayloadTypes())
                {
                    codec = AudioCodec.getCodec(type, media.getRtpmap(type),
                            media.getFmtp(type));
    if(codec != null)                    
                    {
                        break;
                    } 
                } 
    if(codec != null)                
                {
                    Media reply = answer.newMedia(
                            "audio", mAudioStream.getLocalPort(), 1, "RTP/AVP");
                    reply.setRtpPayload(codec.type, codec.rtpmap, codec.fmtp);
for(int type : media.getRtpPayloadTypes())
                    {
                        String rtpmap = media.getRtpmap(type);
    if((type != codec.type) && (rtpmap != null)
                                && rtpmap.startsWith("telephone-event"))                        
                        {
                            reply.setRtpPayload(
                                    type, rtpmap, media.getFmtp(type));
                        } 
                    } 
    if(media.getAttribute("recvonly") != null)                    
                    {
                        answer.setAttribute("sendonly", "");
                    } 
                    else
    if(media.getAttribute("sendonly") != null)                    
                    {
                        answer.setAttribute("recvonly", "");
                    } 
                    else
    if(offer.getAttribute("recvonly") != null)                    
                    {
                        answer.setAttribute("sendonly", "");
                    } 
                    else
    if(offer.getAttribute("sendonly") != null)                    
                    {
                        answer.setAttribute("recvonly", "");
                    } 
                    continue;
                } 
            } 
            Media reply = answer.newMedia(
                    media.getType(), 0, 1, media.getProtocol());
for(String format : media.getFormats())
            {
                reply.setFormat(format, null);
            } 
        } 
    if(codec == null)        
        {
            IllegalStateException varEC5D299EF1FCD2AEECCD4977E52E73B2_1511135214 = new IllegalStateException("Reject SDP: no suitable codecs");
            varEC5D299EF1FCD2AEECCD4977E52E73B2_1511135214.addTaint(taint);
            throw varEC5D299EF1FCD2AEECCD4977E52E73B2_1511135214;
        } 
SimpleSessionDescription var5F54B2A44CB8DC27B659B464640CF0FE_1277730396 =         answer;
        var5F54B2A44CB8DC27B659B464640CF0FE_1277730396.addTaint(taint);
        return var5F54B2A44CB8DC27B659B464640CF0FE_1277730396;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.295 -0400", hash_original_method = "B99EA71C05B29A1F5EF342AB2FDD525C", hash_generated_method = "23AF18B94D5731CDC3C4ECD879249743")
    private SimpleSessionDescription createHoldOffer() {
        SimpleSessionDescription offer = createContinueOffer();
        offer.setAttribute("sendonly", "");
SimpleSessionDescription varB15AE9D99DEF4F854AE55C3D652AFE1B_877280368 =         offer;
        varB15AE9D99DEF4F854AE55C3D652AFE1B_877280368.addTaint(taint);
        return varB15AE9D99DEF4F854AE55C3D652AFE1B_877280368;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.295 -0400", hash_original_method = "71EB52827AB306B4A3579086FF868817", hash_generated_method = "3B3190855EC0EC2FB79F973FD1A19F23")
    private SimpleSessionDescription createContinueOffer() {
        SimpleSessionDescription offer = new SimpleSessionDescription(mSessionId, getLocalIp());
        Media media = offer.newMedia(
                "audio", mAudioStream.getLocalPort(), 1, "RTP/AVP");
        AudioCodec codec = mAudioStream.getCodec();
        media.setRtpPayload(codec.type, codec.rtpmap, codec.fmtp);
        int dtmfType = mAudioStream.getDtmfType();
    if(dtmfType != -1)        
        {
            media.setRtpPayload(dtmfType, "telephone-event/8000", "0-15");
        } 
SimpleSessionDescription varB15AE9D99DEF4F854AE55C3D652AFE1B_843451003 =         offer;
        varB15AE9D99DEF4F854AE55C3D652AFE1B_843451003.addTaint(taint);
        return varB15AE9D99DEF4F854AE55C3D652AFE1B_843451003;
        
        
                
        
                
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.296 -0400", hash_original_method = "9511FA94EBBE4D902AF961AAA5743C5F", hash_generated_method = "B81FE6FC27EB0DCE871C7AEE98355E8C")
    private void grabWifiHighPerfLock() {
    if(mWifiHighPerfLock == null)        
        {
            mWifiHighPerfLock = ((WifiManager)
                    mContext.getSystemService(Context.WIFI_SERVICE))
                    .createWifiLock(WifiManager.WIFI_MODE_FULL_HIGH_PERF, TAG);
            mWifiHighPerfLock.acquire();
        } 
        
        
            
            
                    
                    
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.296 -0400", hash_original_method = "94C077E9D4A3B70D9C34E2292E80901C", hash_generated_method = "DC752C46CA2E029893BF23FC531D2597")
    private void releaseWifiHighPerfLock() {
    if(mWifiHighPerfLock != null)        
        {
            mWifiHighPerfLock.release();
            mWifiHighPerfLock = null;
        } 
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.296 -0400", hash_original_method = "FC1EDAFB978C2E10313819704C8134E2", hash_generated_method = "92A7BCD26CB0F833EF5ECEC24B460E13")
    private boolean isWifiOn() {
        boolean varB83845AFE4A2BD54D45EEA5B632B56C3_12587772 = ((mWm.getConnectionInfo().getBSSID() == null) ? false : true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1981965223 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1981965223;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.296 -0400", hash_original_method = "91407CCBE269ED4E5C3C36CDEC2695DD", hash_generated_method = "64CC2F06F6ED94B5D70819871DF93516")
    public void toggleMute() {
        synchronized
(this)        {
            mMuted = !mMuted;
            setAudioGroupMode();
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.296 -0400", hash_original_method = "CF2F318ECC83A27F31B207A7653E2463", hash_generated_method = "BE7CD781973A7EA77FCF43A7BF5CDFD9")
    public boolean isMuted() {
        synchronized
(this)        {
            boolean varD10511B84B44B96C59D297B21CF3F1BF_2034321995 = (mMuted);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_550979144 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_550979144;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.296 -0400", hash_original_method = "8238959D9236D29164DC3B2B6875AEBE", hash_generated_method = "568591DB5B2DC30323365A7730E2A1CF")
    public void setSpeakerMode(boolean speakerMode) {
        addTaint(speakerMode);
        synchronized
(this)        {
            ((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                    .setSpeakerphoneOn(speakerMode);
            setAudioGroupMode();
        } 
        
        
            
                    
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.297 -0400", hash_original_method = "1B6C9A8A7DE7A949D0CD2E188D6FBBDC", hash_generated_method = "0E0F997095DC4531A40CEB5D9DB229B7")
    private boolean isSpeakerOn() {
        boolean var4E5753886FDAE4B2B5EBD4B29ED7355F_1393628009 = (((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                .isSpeakerphoneOn());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1752215627 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1752215627;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.297 -0400", hash_original_method = "5FC4A2324FC6DD99D16BF2BD98355D7B", hash_generated_method = "01A6B357F212196B4A2AAA5D87288C68")
    public void sendDtmf(int code) {
        addTaint(code);
        sendDtmf(code, null);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.297 -0400", hash_original_method = "7A09CE165EA90677044F14874DA9275F", hash_generated_method = "14EF2FA47FAC2D903381E7FF9F531794")
    public void sendDtmf(int code, Message result) {
        addTaint(result.getTaint());
        addTaint(code);
        synchronized
(this)        {
            AudioGroup audioGroup = getAudioGroup();
    if((audioGroup != null) && (mSipSession != null)
                    && (SipSession.State.IN_CALL == getState()))            
            {
                audioGroup.sendDtmf(code);
            } 
    if(result != null)            
            result.sendToTarget();
        } 
        
        
            
            
                    
                
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.297 -0400", hash_original_method = "974213146461E5146ED1F54CFC83DFBA", hash_generated_method = "5A04C7ECF6C0F5EC48047FB1A6D58C87")
    public AudioStream getAudioStream() {
        synchronized
(this)        {
AudioStream var7989BA78C9201E5975DDDFB7EFFDB611_580881728 =             mAudioStream;
            var7989BA78C9201E5975DDDFB7EFFDB611_580881728.addTaint(taint);
            return var7989BA78C9201E5975DDDFB7EFFDB611_580881728;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.297 -0400", hash_original_method = "BB542D10B17F9F4E162984482435ECE8", hash_generated_method = "F1D4FD599D25DC52F0F703A89C5D54CC")
    public AudioGroup getAudioGroup() {
        synchronized
(this)        {
    if(mAudioGroup != null)            
            {
AudioGroup var386B5FD88A7AE01E79AA5CED784288E9_180629942 =             mAudioGroup;
            var386B5FD88A7AE01E79AA5CED784288E9_180629942.addTaint(taint);
            return var386B5FD88A7AE01E79AA5CED784288E9_180629942;
            }
AudioGroup varC72C554806D9F24F64BE7554224D6C80_1926966345 =             ((mAudioStream == null) ? null : mAudioStream.getGroup());
            varC72C554806D9F24F64BE7554224D6C80_1926966345.addTaint(taint);
            return varC72C554806D9F24F64BE7554224D6C80_1926966345;
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.297 -0400", hash_original_method = "59C2E1D195E6E28B792310EB7C59BD4B", hash_generated_method = "77600E9C134D4524F1EB8A1CC766C2DD")
    public void setAudioGroup(AudioGroup group) {
        synchronized
(this)        {
    if((mAudioStream != null) && (mAudioStream.getGroup() != null))            
            {
                mAudioStream.join(group);
            } 
            mAudioGroup = group;
        } 
        
        
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.298 -0400", hash_original_method = "4F615D2FF52BC5640F885A620AAE1B91", hash_generated_method = "ED5FF7F74B4910A94D893D435B061A8A")
    public void startAudio() {
        try 
        {
            startAudioInternal();
        } 
        catch (UnknownHostException e)
        {
            onError(SipErrorCode.PEER_NOT_REACHABLE, e.getMessage());
        } 
        catch (Throwable e)
        {
            onError(SipErrorCode.CLIENT_ERROR, e.getMessage());
        } 
        
        
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.299 -0400", hash_original_method = "29EB701080CA01C59CC1BB8E207AC1D7", hash_generated_method = "6BD99D8E295B3A125275F8A1BE627A1B")
    private synchronized void startAudioInternal() throws UnknownHostException {
    if(mPeerSd == null)        
        {
            IllegalStateException var709D027B8F80A3D995BD37DFB9CB6EF1_662268385 = new IllegalStateException("mPeerSd = null");
            var709D027B8F80A3D995BD37DFB9CB6EF1_662268385.addTaint(taint);
            throw var709D027B8F80A3D995BD37DFB9CB6EF1_662268385;
        } 
        stopCall(DONT_RELEASE_SOCKET);
        mInCall = true;
        SimpleSessionDescription offer = new SimpleSessionDescription(mPeerSd);
        AudioStream stream = mAudioStream;
        AudioCodec codec = null;
for(Media media : offer.getMedia())
        {
    if((codec == null) && (media.getPort() > 0)
                    && "audio".equals(media.getType())
                    && "RTP/AVP".equals(media.getProtocol()))            
            {
for(int type : media.getRtpPayloadTypes())
                {
                    codec = AudioCodec.getCodec(
                            type, media.getRtpmap(type), media.getFmtp(type));
    if(codec != null)                    
                    {
                        break;
                    } 
                } 
    if(codec != null)                
                {
                    String address = media.getAddress();
    if(address == null)                    
                    {
                        address = offer.getAddress();
                    } 
                    stream.associate(InetAddress.getByName(address),
                            media.getPort());
                    stream.setDtmfType(-1);
                    stream.setCodec(codec);
for(int type : media.getRtpPayloadTypes())
                    {
                        String rtpmap = media.getRtpmap(type);
    if((type != codec.type) && (rtpmap != null)
                                && rtpmap.startsWith("telephone-event"))                        
                        {
                            stream.setDtmfType(type);
                        } 
                    } 
    if(mHold)                    
                    {
                        stream.setMode(RtpStream.MODE_NORMAL);
                    } 
                    else
    if(media.getAttribute("recvonly") != null)                    
                    {
                        stream.setMode(RtpStream.MODE_SEND_ONLY);
                    } 
                    else
    if(media.getAttribute("sendonly") != null)                    
                    {
                        stream.setMode(RtpStream.MODE_RECEIVE_ONLY);
                    } 
                    else
    if(offer.getAttribute("recvonly") != null)                    
                    {
                        stream.setMode(RtpStream.MODE_SEND_ONLY);
                    } 
                    else
    if(offer.getAttribute("sendonly") != null)                    
                    {
                        stream.setMode(RtpStream.MODE_RECEIVE_ONLY);
                    } 
                    else
                    {
                        stream.setMode(RtpStream.MODE_NORMAL);
                    } 
                    break;
                } 
            } 
        } 
    if(codec == null)        
        {
            IllegalStateException varEC5D299EF1FCD2AEECCD4977E52E73B2_470254518 = new IllegalStateException("Reject SDP: no suitable codecs");
            varEC5D299EF1FCD2AEECCD4977E52E73B2_470254518.addTaint(taint);
            throw varEC5D299EF1FCD2AEECCD4977E52E73B2_470254518;
        } 
    if(isWifiOn())        
        grabWifiHighPerfLock();
        AudioGroup audioGroup = getAudioGroup();
    if(mHold)        
        {
        } 
        else
        {
    if(audioGroup == null)            
            audioGroup = new AudioGroup();
            stream.join(audioGroup);
        } 
        setAudioGroupMode();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.300 -0400", hash_original_method = "1498B4B4889D09E5AF0E80BDDCC19CDB", hash_generated_method = "2A94F17834DC5B458B0EB44E45278920")
    private void setAudioGroupMode() {
        AudioGroup audioGroup = getAudioGroup();
    if(audioGroup != null)        
        {
    if(mHold)            
            {
                audioGroup.setMode(AudioGroup.MODE_ON_HOLD);
            } 
            else
    if(mMuted)            
            {
                audioGroup.setMode(AudioGroup.MODE_MUTED);
            } 
            else
    if(isSpeakerOn())            
            {
                audioGroup.setMode(AudioGroup.MODE_ECHO_SUPPRESSION);
            } 
            else
            {
                audioGroup.setMode(AudioGroup.MODE_NORMAL);
            } 
        } 
        
        
        
            
                
            
                
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.300 -0400", hash_original_method = "CC3F94229D0F8EEA9220358FBB15354E", hash_generated_method = "7A8FC348A47EAD95F5D19B680D113E03")
    private void stopCall(boolean releaseSocket) {
        addTaint(releaseSocket);
        Log.d(TAG, "stop audiocall");
        releaseWifiHighPerfLock();
    if(mAudioStream != null)        
        {
            mAudioStream.join(null);
    if(releaseSocket)            
            {
                mAudioStream.release();
                mAudioStream = null;
            } 
        } 
        
        
        
        
            
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.301 -0400", hash_original_method = "B878A2570A0CCD8ECF14B79C9C36E090", hash_generated_method = "D99C3C3CEE98FF369A8F65DE6F40F7F6")
    private String getLocalIp() {
String varD6B92870042BA5D27310C46B2B2CE35E_1010855833 =         mSipSession.getLocalIp();
        varD6B92870042BA5D27310C46B2B2CE35E_1010855833.addTaint(taint);
        return varD6B92870042BA5D27310C46B2B2CE35E_1010855833;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.301 -0400", hash_original_method = "16DFE4C58B2AE1A5BAAA6CDCCC648429", hash_generated_method = "66786D114EA659906C7E3E5DB531ACF3")
    private void throwSipException(Throwable throwable) throws SipException {
        addTaint(throwable.getTaint());
    if(throwable instanceof SipException)        
        {
            SipException varAD35909301F1824BA85A4A40DFDDA95D_308108242 = (SipException) throwable;
            varAD35909301F1824BA85A4A40DFDDA95D_308108242.addTaint(taint);
            throw varAD35909301F1824BA85A4A40DFDDA95D_308108242;
        } 
        else
        {
            SipException var445FAF0EC3C30FD0CF976DE496EC5D17_1850938826 = new SipException("", throwable);
            var445FAF0EC3C30FD0CF976DE496EC5D17_1850938826.addTaint(taint);
            throw var445FAF0EC3C30FD0CF976DE496EC5D17_1850938826;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.302 -0400", hash_original_method = "7E510B007B6231BC910990588CC742B2", hash_generated_method = "DFC8619DDBDB331CDF53F178BD1AB91D")
    private SipProfile getPeerProfile(SipSession session) {
        addTaint(session.getTaint());
SipProfile var2F59EF1259AA7295B0FD1FC865223FC6_1987812644 =         session.getPeerProfile();
        var2F59EF1259AA7295B0FD1FC865223FC6_1987812644.addTaint(taint);
        return var2F59EF1259AA7295B0FD1FC865223FC6_1987812644;
        
        
    }

    
    public static class Listener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.302 -0400", hash_original_method = "5575F820891B6AD64AFC44C76A4BA5AF", hash_generated_method = "5575F820891B6AD64AFC44C76A4BA5AF")
        public Listener ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.302 -0400", hash_original_method = "1692051440F2E30BB9552F9991C2F337", hash_generated_method = "1437C4BAACEE991D53E3D4C693468728")
        public void onReadyToCall(SipAudioCall call) {
            
            addTaint(call.getTaint());
            onChanged(call);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.302 -0400", hash_original_method = "F61EC18A6F9190266BB417D94187D91F", hash_generated_method = "D2F254533972267BD38ABBA599C28EF8")
        public void onCalling(SipAudioCall call) {
            
            addTaint(call.getTaint());
            onChanged(call);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.303 -0400", hash_original_method = "80FA944D90A47A92553C0DDAF9805E5E", hash_generated_method = "9B19093F854AD2AE0774BCA056F55F98")
        public void onRinging(SipAudioCall call, SipProfile caller) {
            
            addTaint(caller.getTaint());
            addTaint(call.getTaint());
            onChanged(call);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.303 -0400", hash_original_method = "F638A746C099264E58AA2EF34946D274", hash_generated_method = "4A1AC351FB7D4E94521BD7D9D2684A3A")
        public void onRingingBack(SipAudioCall call) {
            
            addTaint(call.getTaint());
            onChanged(call);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.303 -0400", hash_original_method = "ED0948473C3573D4349DE4B81266B2ED", hash_generated_method = "D7B8C7B3FFA9BBE461FD8F86B99AA0D1")
        public void onCallEstablished(SipAudioCall call) {
            
            addTaint(call.getTaint());
            onChanged(call);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.303 -0400", hash_original_method = "87752713DF39DD8F370DBCB68CD08A8A", hash_generated_method = "464E5D70533433713271DCF20E04B9AC")
        public void onCallEnded(SipAudioCall call) {
            
            addTaint(call.getTaint());
            onChanged(call);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.303 -0400", hash_original_method = "A1C8D07F76B181730B1462483C996C45", hash_generated_method = "12D57F08446B4CC7CCF3C1A68173F58D")
        public void onCallBusy(SipAudioCall call) {
            
            addTaint(call.getTaint());
            onChanged(call);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.304 -0400", hash_original_method = "901B34C07D0BCB3C3E5EC60CF9AA74AD", hash_generated_method = "46366D093626E901F9AECFA7125D47C9")
        public void onCallHeld(SipAudioCall call) {
            
            addTaint(call.getTaint());
            onChanged(call);
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.304 -0400", hash_original_method = "43C9D48E22A0172861A5C1A464B2052F", hash_generated_method = "190602BC25E5C472D84A293D38E76700")
        public void onError(SipAudioCall call, int errorCode,
                String errorMessage) {
            
            addTaint(errorMessage.getTaint());
            addTaint(errorCode);
            addTaint(call.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.304 -0400", hash_original_method = "06CD8F9D0FA40D0750F021E4FF896790", hash_generated_method = "5344D2CA13D23FE27CDA3E3AB1CBFDF1")
        public void onChanged(SipAudioCall call) {
            
            addTaint(call.getTaint());
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.304 -0400", hash_original_field = "B17C5B5C226E77B1666B9A31569420CB", hash_generated_field = "D0852ADB59FF9D54A384553BA77A5784")

    private static final String TAG = SipAudioCall.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.304 -0400", hash_original_field = "D0777547C9B1B5A66E95FC635B9FC11E", hash_generated_field = "CCC05A0ED1E689C779F088E9A0792429")

    private static final boolean RELEASE_SOCKET = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.304 -0400", hash_original_field = "3C98DA88265BAAAA0955009025FCEB1D", hash_generated_field = "445A359A7CC340C6BD7ACB8F708A8B97")

    private static final boolean DONT_RELEASE_SOCKET = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.304 -0400", hash_original_field = "5BC2C71FEA4432FD2C437C92A488A140", hash_generated_field = "18742BBD994F08DAD92A46AC0B004C26")

    private static final int SESSION_TIMEOUT = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.304 -0400", hash_original_field = "4F64C4E74B140C5A69D76BBF65C5177F", hash_generated_field = "907233FE68538E2431423AFE28884944")

    private static final int TRANSFER_TIMEOUT = 15;
}

