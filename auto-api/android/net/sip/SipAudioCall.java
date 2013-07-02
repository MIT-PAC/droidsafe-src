package android.net.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.922 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.922 -0400", hash_original_field = "FF1CB71BAB47D197D74F995BD9E7A803", hash_generated_field = "6E091E066D80096AB4790291B230BE96")

    private SipProfile mLocalProfile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.922 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "484D72CF31DE6402790176EF95A4C8E2")

    private SipAudioCall.Listener mListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.922 -0400", hash_original_field = "5A8516A00FC44EAD1FB2DF747AF176E7", hash_generated_field = "5A2B893C3FE2A9A2DE8E72D8792D353F")

    private SipSession mSipSession;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.922 -0400", hash_original_field = "696E4247B1C62891017C76DE2748F81D", hash_generated_field = "7C9004090DB280D3DD75EC1A1184D119")

    private SipSession mTransferringSession;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.922 -0400", hash_original_field = "B3D763F81031D116F4DDEFDCF2440B42", hash_generated_field = "7C64D41119E982E471870E4C818DD2D6")

    private long mSessionId = System.currentTimeMillis();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.922 -0400", hash_original_field = "489C27793E1C7DC00D4CE97B79831AE1", hash_generated_field = "9F59EE492C7A8D15690CB9BED1F25434")

    private String mPeerSd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.922 -0400", hash_original_field = "EED3B14E87D1A2B42EF2AAD48A1AE22C", hash_generated_field = "455D7DF5CAA0F63BF9C19FEC9C870ABC")

    private AudioStream mAudioStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.922 -0400", hash_original_field = "32C0A4CC3DE7ACB3907A60677CD6CE22", hash_generated_field = "62700614B1F5A2BE6501D87E3EA29746")

    private AudioGroup mAudioGroup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.922 -0400", hash_original_field = "DC811F268DA137B5E8B4F29600FBE75A", hash_generated_field = "7E358D7A0A2BA24FEA1EEA744FA91417")

    private boolean mInCall = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.922 -0400", hash_original_field = "1BC50C90C4537359FC1A482E47241617", hash_generated_field = "DAFCCC98CC29AFA37BE6BA4063A2F9C9")

    private boolean mMuted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.922 -0400", hash_original_field = "361220807CF04190F95695EA0129F31B", hash_generated_field = "2F42C58AE349901E944BC55F3F826C78")

    private boolean mHold = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.922 -0400", hash_original_field = "0AB50DE2E26B9721C5B5325D428A43AF", hash_generated_field = "B20041B31BF3C63BEA61010725B48956")

    private SipProfile mPendingCallRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.922 -0400", hash_original_field = "40E135D566C7D45C48786027486A41F9", hash_generated_field = "AA909A8A1E3B0EDD8AADADB48D5C730C")

    private WifiManager mWm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.922 -0400", hash_original_field = "0A13C2715EDB39FB8407B99856966C2F", hash_generated_field = "1064E8BF494EAE96395CFD56F6281589")

    private WifiManager.WifiLock mWifiHighPerfLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.922 -0400", hash_original_field = "617AB537A3FB63945C0DB8523A8EAAA5", hash_generated_field = "6408008D03AC8F90F3CE0B460908E415")

    private int mErrorCode = SipErrorCode.NO_ERROR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.922 -0400", hash_original_field = "DDF57A354F36667F5635F5344D9C8DEA", hash_generated_field = "CBCF3C2AB9532780C0A69F6C63B81E66")

    private String mErrorMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.923 -0400", hash_original_method = "E52D3B9BC90DBBDF3C179757863C5D97", hash_generated_method = "756A0602EA41970B104F8D81707C3875")
    public  SipAudioCall(Context context, SipProfile localProfile) {
        mContext = context;
        mLocalProfile = localProfile;
        mWm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.923 -0400", hash_original_method = "624C526ACE340C91B4AE00384193A96D", hash_generated_method = "E7DA8685A5B756184F077349FF0925E0")
    public void setListener(SipAudioCall.Listener listener) {
        setListener(listener, false);
        addTaint(listener.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.924 -0400", hash_original_method = "7FD2357D0901F6F1D08ACBD882A0FD6F", hash_generated_method = "63C6217C197E009A5EB00E2D69A92BF8")
    public void setListener(SipAudioCall.Listener listener,
            boolean callbackImmediately) {
        mListener = listener;
        try 
        {
            {
                listener.onError(this, mErrorCode, mErrorMessage);
            } 
            {
                {
                    listener.onCallHeld(this);
                } 
                {
                    listener.onCallEstablished(this);
                } 
            } 
            {
                int state = getState();
                
                listener.onReadyToCall(this);
                
                
                listener.onRinging(this, getPeerProfile());
                
                
                listener.onCalling(this);
                
                
                listener.onRingingBack(this);
                
            } 
        } 
        catch (Throwable t)
        { }
        addTaint(callbackImmediately);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.925 -0400", hash_original_method = "5739155C46DD20825CE1C589327CD281", hash_generated_method = "7D419F4A0BCD1B5E36D71DBBC5626D71")
    public boolean isInCall() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_512333227 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_512333227;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.925 -0400", hash_original_method = "2FD69B096455E1B51D801F19A8DBFD35", hash_generated_method = "B9CDCC0F00973F78340DAEE0935975CC")
    public boolean isOnHold() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2002779498 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2002779498;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.926 -0400", hash_original_method = "597B95CEB5AFD05C977FB508D047C50E", hash_generated_method = "21668DF8FDBDBCA1A469227829ADE78B")
    public void close() {
        close(true);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.927 -0400", hash_original_method = "AA0DE56AB4C8CE099E885498EC0B29F9", hash_generated_method = "53AB711578130E3994931AD6FBA6F105")
    private synchronized void close(boolean closeRtp) {
        stopCall(RELEASE_SOCKET);
        mInCall = false;
        mHold = false;
        mSessionId = System.currentTimeMillis();
        mErrorCode = SipErrorCode.NO_ERROR;
        mErrorMessage = null;
        {
            mSipSession.setListener(null);
            mSipSession = null;
        } 
        addTaint(closeRtp);
        
        
        
        
        
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.927 -0400", hash_original_method = "A61765ACD427BC1BAFB034CDA7289AED", hash_generated_method = "937F918477709AF4C2953576536C2A34")
    public SipProfile getLocalProfile() {
        SipProfile varB4EAC82CA7396A68D541C85D26508E83_297225088 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_297225088 = mLocalProfile;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_297225088.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_297225088;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.928 -0400", hash_original_method = "35C9BB243C8C9C83D8B1884AE3FDA6C7", hash_generated_method = "D2C9EE0993C46BACAAD59ECC5F91DB03")
    public SipProfile getPeerProfile() {
        SipProfile varB4EAC82CA7396A68D541C85D26508E83_577308211 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_577308211 = (mSipSession == null) ? null : mSipSession.getPeerProfile();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_577308211.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_577308211;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.929 -0400", hash_original_method = "6859CB7872625AC40861B5EFD6D7E2DC", hash_generated_method = "1288B2538A4893064E464EB5DB2B7DFD")
    public int getState() {
        {
            int var7BB3A2E3BA586BA005C2A26D50A17E95_1887008568 = (mSipSession.getState());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_923670315 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_923670315;
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.929 -0400", hash_original_method = "9DD9B38A5D2A310FA14C467CD9F0FD11", hash_generated_method = "36E8152BCC04521DFE6F15C189E50027")
    public SipSession getSipSession() {
        SipSession varB4EAC82CA7396A68D541C85D26508E83_965472898 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_965472898 = mSipSession;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_965472898.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_965472898;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.930 -0400", hash_original_method = "88FD57B0E3684A7BA74DB8405E64F4E3", hash_generated_method = "2BEBA42A63404A06AA073850F448E1AA")
    private synchronized void transferToNewSession() {
        SipSession origin = mSipSession;
        mSipSession = mTransferringSession;
        mTransferringSession = null;
        {
            mAudioStream.join(null);
        } 
        {
            try 
            {
                mAudioStream = new AudioStream(InetAddress.getByName(
                        getLocalIp()));
            } 
            catch (Throwable t)
            { }
        } 
        origin.endCall();
        startAudio();
        
        
        
        
        
        
            
        
            
                
                        
            
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.931 -0400", hash_original_method = "5E0B84D644E5F5257B7A32D95C62CBE3", hash_generated_method = "2830201D1B70307CF566F5532CC37BA2")
    private SipSession.Listener createListener() {
        SipSession.Listener varB4EAC82CA7396A68D541C85D26508E83_461572059 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_461572059 = new SipSession.Listener() {
            @Override
            public void onCalling(SipSession session) {
                Log.d(TAG, "calling... " + session);
                Listener listener = mListener;
                if (listener != null) {
                    try {
                        listener.onCalling(SipAudioCall.this);
                    } catch (Throwable t) {
                        Log.i(TAG, "onCalling(): " + t);
                    }
                }
            }
            @Override
            public void onRingingBack(SipSession session) {
                Log.d(TAG, "sip call ringing back: " + session);
                Listener listener = mListener;
                if (listener != null) {
                    try {
                        listener.onRingingBack(SipAudioCall.this);
                    } catch (Throwable t) {
                        Log.i(TAG, "onRingingBack(): " + t);
                    }
                }
            }
            @Override
            public void onRinging(SipSession session,
                    SipProfile peerProfile, String sessionDescription) {
                synchronized (SipAudioCall.this) {
                    if ((mSipSession == null) || !mInCall
                            || !session.getCallId().equals(
                                    mSipSession.getCallId())) {
                        session.endCall();
                        return;
                    }
                    try {
                        String answer = createAnswer(sessionDescription).encode();
                        mSipSession.answerCall(answer, SESSION_TIMEOUT);
                    } catch (Throwable e) {
                        Log.e(TAG, "onRinging()", e);
                        session.endCall();
                    }
                }
            }
            @Override
            public void onCallEstablished(SipSession session,
                    String sessionDescription) {
                mPeerSd = sessionDescription;
                Log.v(TAG, "onCallEstablished()" + mPeerSd);
                if ((mTransferringSession != null)
                        && (session == mTransferringSession)) {
                    transferToNewSession();
                    return;
                }
                Listener listener = mListener;
                if (listener != null) {
                    try {
                        if (mHold) {
                            listener.onCallHeld(SipAudioCall.this);
                        } else {
                            listener.onCallEstablished(SipAudioCall.this);
                        }
                    } catch (Throwable t) {
                        Log.i(TAG, "onCallEstablished(): " + t);
                    }
                }
            }
            @Override
            public void onCallEnded(SipSession session) {
                Log.d(TAG, "sip call ended: " + session + " mSipSession:" + mSipSession);
                if (session == mTransferringSession) {
                    mTransferringSession = null;
                    return;
                }
                if ((mTransferringSession != null) ||
                    (session != mSipSession)) return;
                Listener listener = mListener;
                if (listener != null) {
                    try {
                        listener.onCallEnded(SipAudioCall.this);
                    } catch (Throwable t) {
                        Log.i(TAG, "onCallEnded(): " + t);
                    }
                }
                close();
            }
            @Override
            public void onCallBusy(SipSession session) {
                Log.d(TAG, "sip call busy: " + session);
                Listener listener = mListener;
                if (listener != null) {
                    try {
                        listener.onCallBusy(SipAudioCall.this);
                    } catch (Throwable t) {
                        Log.i(TAG, "onCallBusy(): " + t);
                    }
                }
                close(false);
            }
            @Override
            public void onCallChangeFailed(SipSession session, int errorCode,
                    String message) {
                Log.d(TAG, "sip call change failed: " + message);
                mErrorCode = errorCode;
                mErrorMessage = message;
                Listener listener = mListener;
                if (listener != null) {
                    try {
                        listener.onError(SipAudioCall.this, mErrorCode,
                                message);
                    } catch (Throwable t) {
                        Log.i(TAG, "onCallBusy(): " + t);
                    }
                }
            }
            @Override
            public void onError(SipSession session, int errorCode,
                    String message) {
                SipAudioCall.this.onError(errorCode, message);
            }
            @Override
            public void onRegistering(SipSession session) {
            }
            @Override
            public void onRegistrationTimeout(SipSession session) {
            }
            @Override
            public void onRegistrationFailed(SipSession session, int errorCode,
                    String message) {
            }
            @Override
            public void onRegistrationDone(SipSession session, int duration) {
            }
            @Override
            public void onCallTransferring(SipSession newSession,
                    String sessionDescription) {
                Log.v(TAG, "onCallTransferring mSipSession:"
                        + mSipSession + " newSession:" + newSession);
                mTransferringSession = newSession;
                try {
                    if (sessionDescription == null) {
                        newSession.makeCall(newSession.getPeerProfile(),
                                createOffer().encode(), TRANSFER_TIMEOUT);
                    } else {
                        String answer = createAnswer(sessionDescription).encode();
                        newSession.answerCall(answer, SESSION_TIMEOUT);
                    }
                } catch (Throwable e) {
                    Log.e(TAG, "onCallTransferring()", e);
                    newSession.endCall();
                }
            }
        };
        varB4EAC82CA7396A68D541C85D26508E83_461572059.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_461572059;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.931 -0400", hash_original_method = "20EC585B752C6E63355D5D35BEA59116", hash_generated_method = "EC0A6D7C3EB3D62F843642B867EC4C45")
    private void onError(int errorCode, String message) {
        Log.d(TAG, "sip session error: "
                + SipErrorCode.toString(errorCode) + ": " + message);
        mErrorCode = errorCode;
        mErrorMessage = message;
        Listener listener = mListener;
        {
            try 
            {
                listener.onError(this, errorCode, message);
            } 
            catch (Throwable t)
            { }
        } 
        {
            {
                boolean var064562D536C7718FFB44A98A20F35A97_516494506 = ((errorCode == SipErrorCode.DATA_CONNECTION_LOST)
                    || !isInCall());
                {
                    close(true);
                } 
            } 
        } 
        
        
                
        
        
        
        
            
                
            
                
            
        
        
            
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.932 -0400", hash_original_method = "9D47ECE9B5A5E502049A76A2D5CF7D58", hash_generated_method = "1881F770BA68E7B4A860F16DB84D2B27")
    public void attachCall(SipSession session, String sessionDescription) throws SipException {
        {
            boolean var7C2B3BAF12F2B803CD1155B57592C3F4_634926313 = (!SipManager.isVoipSupported(mContext));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("VOIP API is not supported");
            } 
        } 
        {
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.932 -0400", hash_original_method = "CDFD7E26E80EFA4595D6BD4E5712D0C4", hash_generated_method = "6E0186D5443A01FFA3AF7DE24BA79F27")
    public void makeCall(SipProfile peerProfile, SipSession sipSession,
            int timeout) throws SipException {
        {
            boolean var7C2B3BAF12F2B803CD1155B57592C3F4_172503686 = (!SipManager.isVoipSupported(mContext));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("VOIP API is not supported");
            } 
        } 
        {
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
                if (DroidSafeAndroidRuntime.control) throw new SipException("makeCall()", e);
            } 
        } 
        addTaint(peerProfile.getTaint());
        addTaint(timeout);
        
        
            
        
        
            
            
                
                        
                
                
                        
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.933 -0400", hash_original_method = "DFE2EF72B1133A207E3F57586EB6C6EB", hash_generated_method = "FD6EAFD348EC9F0D54324F4AF9C63DE1")
    public void endCall() throws SipException {
        {
            stopCall(RELEASE_SOCKET);
            mInCall = false;
            mSipSession.endCall();
        } 
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.933 -0400", hash_original_method = "83B252D66EF8BD3A5BE285DBF75AA925", hash_generated_method = "BFC2FF9378D0553FC64277330524FA98")
    public void holdCall(int timeout) throws SipException {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Not in a call to hold call");
            } 
            mSipSession.changeCall(createHoldOffer().encode(), timeout);
            mHold = true;
            setAudioGroupMode();
        } 
        addTaint(timeout);
        
        
            
            
                
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.934 -0400", hash_original_method = "7A338589242F74847BFE21BB083282FF", hash_generated_method = "D4AA0DDF92CF6A8DE62BA5105EB80D12")
    public void answerCall(int timeout) throws SipException {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("No call to answer");
            } 
            try 
            {
                mAudioStream = new AudioStream(InetAddress.getByName(
                        getLocalIp()));
                mSipSession.answerCall(createAnswer(mPeerSd).encode(), timeout);
            } 
            catch (IOException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("answerCall()", e);
            } 
        } 
        addTaint(timeout);
        
        
            
                
            
            
                
                        
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.934 -0400", hash_original_method = "FE14EBF8C515C93259E0563DEA133194", hash_generated_method = "B98A027A40C4291CE9EE30E7C8FCBFF2")
    public void continueCall(int timeout) throws SipException {
        {
            mSipSession.changeCall(createContinueOffer().encode(), timeout);
            mHold = false;
            setAudioGroupMode();
        } 
        addTaint(timeout);
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.941 -0400", hash_original_method = "0D8E98137E8907FA474D9700B196F628", hash_generated_method = "D6EA4C843C9CF74FAF93C1E92679E2CC")
    private SimpleSessionDescription createOffer() {
        SimpleSessionDescription varB4EAC82CA7396A68D541C85D26508E83_1947165051 = null; 
        SimpleSessionDescription offer = new SimpleSessionDescription(mSessionId, getLocalIp());
        AudioCodec[] codecs = AudioCodec.getCodecs();
        Media media = offer.newMedia(
                "audio", mAudioStream.getLocalPort(), 1, "RTP/AVP");
        {
            AudioCodec codec = AudioCodec.getCodecs()[0];
            {
                media.setRtpPayload(codec.type, codec.rtpmap, codec.fmtp);
            } 
        } 
        media.setRtpPayload(127, "telephone-event/8000", "0-15");
        varB4EAC82CA7396A68D541C85D26508E83_1947165051 = offer;
        varB4EAC82CA7396A68D541C85D26508E83_1947165051.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1947165051;
        
        
                
        
        
                
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.957 -0400", hash_original_method = "7AC71E8F4C8E41998B13EFBED71D93BD", hash_generated_method = "4B34FBE7B4003436512AA18B8D3F2D17")
    private SimpleSessionDescription createAnswer(String offerSd) {
        SimpleSessionDescription varB4EAC82CA7396A68D541C85D26508E83_219417049 = null; 
        SimpleSessionDescription varB4EAC82CA7396A68D541C85D26508E83_663666964 = null; 
        {
            boolean varD57F5D9EDEEED5EBFB37D3EA7E739880_188140087 = (TextUtils.isEmpty(offerSd));
            varB4EAC82CA7396A68D541C85D26508E83_219417049 = createOffer();
        } 
        SimpleSessionDescription offer = new SimpleSessionDescription(offerSd);
        SimpleSessionDescription answer = new SimpleSessionDescription(mSessionId, getLocalIp());
        AudioCodec codec = null;
        {
            Media media = offer.getMedia()[0];
            {
                {
                    boolean var2DE1D53623224D4AB7ECC9712B740291_1463694029 = ((codec == null) && (media.getPort() > 0)
                    && "audio".equals(media.getType())
                    && "RTP/AVP".equals(media.getProtocol()));
                    {
                        {
                            int type = media.getRtpPayloadTypes()[0];
                            {
                                codec = AudioCodec.getCodec(type, media.getRtpmap(type),
                            media.getFmtp(type));
                            } 
                        } 
                        {
                            Media reply = answer.newMedia(
                            "audio", mAudioStream.getLocalPort(), 1, "RTP/AVP");
                            reply.setRtpPayload(codec.type, codec.rtpmap, codec.fmtp);
                            {
                                int type = media.getRtpPayloadTypes()[0];
                                {
                                    String rtpmap = media.getRtpmap(type);
                                    {
                                        boolean varCB957CD13AB208B86C56E8825962C086_1531272825 = ((type != codec.type) && (rtpmap != null)
                                && rtpmap.startsWith("telephone-event"));
                                        {
                                            reply.setRtpPayload(
                                    type, rtpmap, media.getFmtp(type));
                                        } 
                                    } 
                                } 
                            } 
                            {
                                boolean var1A79B2A4B05C87BBB8B68D2C2016DC16_615835330 = (media.getAttribute("recvonly") != null);
                                {
                                    answer.setAttribute("sendonly", "");
                                } 
                                {
                                    boolean varB3F7193C3333B0079507F79363D4A8B4_1866403179 = (media.getAttribute("sendonly") != null);
                                    {
                                        answer.setAttribute("recvonly", "");
                                    } 
                                    {
                                        boolean varB5C9A82246237C19E1097CE6E5634727_1969567545 = (offer.getAttribute("recvonly") != null);
                                        {
                                            answer.setAttribute("sendonly", "");
                                        } 
                                        {
                                            boolean var6DC296E0183F0D6A7813976666F92608_1675594129 = (offer.getAttribute("sendonly") != null);
                                            {
                                                answer.setAttribute("recvonly", "");
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
                Media reply = answer.newMedia(
                    media.getType(), 0, 1, media.getProtocol());
                {
                    String format = media.getFormats()[0];
                    {
                        reply.setFormat(format, null);
                    } 
                } 
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Reject SDP: no suitable codecs");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_663666964 = answer;
        addTaint(offerSd.getTaint());
        SimpleSessionDescription varA7E53CE21691AB073D9660D615818899_1168433562; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1168433562 = varB4EAC82CA7396A68D541C85D26508E83_219417049;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1168433562 = varB4EAC82CA7396A68D541C85D26508E83_663666964;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1168433562.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1168433562;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.958 -0400", hash_original_method = "B99EA71C05B29A1F5EF342AB2FDD525C", hash_generated_method = "C75B11B87219BE3D371E44816C82B74A")
    private SimpleSessionDescription createHoldOffer() {
        SimpleSessionDescription varB4EAC82CA7396A68D541C85D26508E83_706933326 = null; 
        SimpleSessionDescription offer = createContinueOffer();
        offer.setAttribute("sendonly", "");
        varB4EAC82CA7396A68D541C85D26508E83_706933326 = offer;
        varB4EAC82CA7396A68D541C85D26508E83_706933326.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_706933326;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.960 -0400", hash_original_method = "71EB52827AB306B4A3579086FF868817", hash_generated_method = "6199E75D622164C439AF778E45A13BC0")
    private SimpleSessionDescription createContinueOffer() {
        SimpleSessionDescription varB4EAC82CA7396A68D541C85D26508E83_1908992730 = null; 
        SimpleSessionDescription offer = new SimpleSessionDescription(mSessionId, getLocalIp());
        Media media = offer.newMedia(
                "audio", mAudioStream.getLocalPort(), 1, "RTP/AVP");
        AudioCodec codec = mAudioStream.getCodec();
        media.setRtpPayload(codec.type, codec.rtpmap, codec.fmtp);
        int dtmfType = mAudioStream.getDtmfType();
        {
            media.setRtpPayload(dtmfType, "telephone-event/8000", "0-15");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1908992730 = offer;
        varB4EAC82CA7396A68D541C85D26508E83_1908992730.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1908992730;
        
        
                
        
                
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.961 -0400", hash_original_method = "9511FA94EBBE4D902AF961AAA5743C5F", hash_generated_method = "1678A407CDD83AD87374506DBEA7F6F9")
    private void grabWifiHighPerfLock() {
        {
            mWifiHighPerfLock = ((WifiManager)
                    mContext.getSystemService(Context.WIFI_SERVICE))
                    .createWifiLock(WifiManager.WIFI_MODE_FULL_HIGH_PERF, TAG);
            mWifiHighPerfLock.acquire();
        } 
        
        
            
            
                    
                    
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.961 -0400", hash_original_method = "94C077E9D4A3B70D9C34E2292E80901C", hash_generated_method = "8F7F811C1A6F870FF7B54E76DC4FE6D4")
    private void releaseWifiHighPerfLock() {
        {
            mWifiHighPerfLock.release();
            mWifiHighPerfLock = null;
        } 
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.962 -0400", hash_original_method = "FC1EDAFB978C2E10313819704C8134E2", hash_generated_method = "597B24114EC16AFAED3748B3A98C39D7")
    private boolean isWifiOn() {
        {
            boolean varA39A642AAD196AE2FD89489CCF53E246_667789470 = ((mWm.getConnectionInfo().getBSSID() == null));
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_874650281 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_874650281;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.962 -0400", hash_original_method = "91407CCBE269ED4E5C3C36CDEC2695DD", hash_generated_method = "6BCC9B5174D08C2ED8FA25D85C24B9D8")
    public void toggleMute() {
        {
            mMuted = !mMuted;
            setAudioGroupMode();
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.963 -0400", hash_original_method = "CF2F318ECC83A27F31B207A7653E2463", hash_generated_method = "44DB31D0248E8E272C836BF0996168AB")
    public boolean isMuted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_244784685 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_244784685;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.963 -0400", hash_original_method = "8238959D9236D29164DC3B2B6875AEBE", hash_generated_method = "AA47DBB812A0EAA3C21C3633BEA23FD3")
    public void setSpeakerMode(boolean speakerMode) {
        {
            ((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                    .setSpeakerphoneOn(speakerMode);
            setAudioGroupMode();
        } 
        addTaint(speakerMode);
        
        
            
                    
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.964 -0400", hash_original_method = "1B6C9A8A7DE7A949D0CD2E188D6FBBDC", hash_generated_method = "C48668B3D783017D6303A4588371C71B")
    private boolean isSpeakerOn() {
        boolean varB3D6950D5F301C704C02A4854CB7D217_668651754 = (((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                .isSpeakerphoneOn());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_89184373 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_89184373;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.964 -0400", hash_original_method = "5FC4A2324FC6DD99D16BF2BD98355D7B", hash_generated_method = "384D48BD48775F53CEE2226794747204")
    public void sendDtmf(int code) {
        sendDtmf(code, null);
        addTaint(code);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.964 -0400", hash_original_method = "7A09CE165EA90677044F14874DA9275F", hash_generated_method = "334F56A4ECC9C197C0F773DC69B05A1D")
    public void sendDtmf(int code, Message result) {
        {
            AudioGroup audioGroup = getAudioGroup();
            {
                boolean var40B0A392B41D3543A13A1EBA207462F2_2092904064 = ((audioGroup != null) && (mSipSession != null)
                    && (SipSession.State.IN_CALL == getState()));
                {
                    audioGroup.sendDtmf(code);
                } 
            } 
            result.sendToTarget();
        } 
        addTaint(code);
        addTaint(result.getTaint());
        
        
            
            
                    
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.965 -0400", hash_original_method = "974213146461E5146ED1F54CFC83DFBA", hash_generated_method = "2361B0F730662480DFC40F12384B8108")
    public AudioStream getAudioStream() {
        AudioStream varB4EAC82CA7396A68D541C85D26508E83_1091284804 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1091284804 = mAudioStream;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1091284804.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1091284804;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.966 -0400", hash_original_method = "BB542D10B17F9F4E162984482435ECE8", hash_generated_method = "4E2454B9E0129805778116B8930038B0")
    public AudioGroup getAudioGroup() {
        AudioGroup varB4EAC82CA7396A68D541C85D26508E83_556035840 = null; 
        AudioGroup varB4EAC82CA7396A68D541C85D26508E83_1918726366 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_556035840 = mAudioGroup;
            varB4EAC82CA7396A68D541C85D26508E83_1918726366 = ((mAudioStream == null) ? null : mAudioStream.getGroup());
        } 
        AudioGroup varA7E53CE21691AB073D9660D615818899_270041210; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_270041210 = varB4EAC82CA7396A68D541C85D26508E83_556035840;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_270041210 = varB4EAC82CA7396A68D541C85D26508E83_1918726366;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_270041210.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_270041210;
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.966 -0400", hash_original_method = "59C2E1D195E6E28B792310EB7C59BD4B", hash_generated_method = "1373C94EECC858321F0339B891EEB2FF")
    public void setAudioGroup(AudioGroup group) {
        {
            {
                boolean varBF4F994E1BAFD5371D1A8FD1902D3F31_1504772877 = ((mAudioStream != null) && (mAudioStream.getGroup() != null));
                {
                    mAudioStream.join(group);
                } 
            } 
            mAudioGroup = group;
        } 
        
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.966 -0400", hash_original_method = "4F615D2FF52BC5640F885A620AAE1B91", hash_generated_method = "ED5FF7F74B4910A94D893D435B061A8A")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.981 -0400", hash_original_method = "29EB701080CA01C59CC1BB8E207AC1D7", hash_generated_method = "57F7968EA8052B678C2DF97C13579473")
    private synchronized void startAudioInternal() throws UnknownHostException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("mPeerSd = null");
        } 
        stopCall(DONT_RELEASE_SOCKET);
        mInCall = true;
        SimpleSessionDescription offer = new SimpleSessionDescription(mPeerSd);
        AudioStream stream = mAudioStream;
        AudioCodec codec = null;
        {
            Media media = offer.getMedia()[0];
            {
                {
                    boolean var2DE1D53623224D4AB7ECC9712B740291_1171594271 = ((codec == null) && (media.getPort() > 0)
                    && "audio".equals(media.getType())
                    && "RTP/AVP".equals(media.getProtocol()));
                    {
                        {
                            int type = media.getRtpPayloadTypes()[0];
                            {
                                codec = AudioCodec.getCodec(
                            type, media.getRtpmap(type), media.getFmtp(type));
                            } 
                        } 
                        {
                            String address = media.getAddress();
                            {
                                address = offer.getAddress();
                            } 
                            stream.associate(InetAddress.getByName(address),
                            media.getPort());
                            stream.setDtmfType(-1);
                            stream.setCodec(codec);
                            {
                                int type = media.getRtpPayloadTypes()[0];
                                {
                                    String rtpmap = media.getRtpmap(type);
                                    {
                                        boolean varCB957CD13AB208B86C56E8825962C086_2141837569 = ((type != codec.type) && (rtpmap != null)
                                && rtpmap.startsWith("telephone-event"));
                                        {
                                            stream.setDtmfType(type);
                                        } 
                                    } 
                                } 
                            } 
                            {
                                stream.setMode(RtpStream.MODE_NORMAL);
                            } 
                            {
                                boolean var1A79B2A4B05C87BBB8B68D2C2016DC16_1688248153 = (media.getAttribute("recvonly") != null);
                                {
                                    stream.setMode(RtpStream.MODE_SEND_ONLY);
                                } 
                                {
                                    boolean varB3F7193C3333B0079507F79363D4A8B4_653791677 = (media.getAttribute("sendonly") != null);
                                    {
                                        stream.setMode(RtpStream.MODE_RECEIVE_ONLY);
                                    } 
                                    {
                                        boolean varB5C9A82246237C19E1097CE6E5634727_640011453 = (offer.getAttribute("recvonly") != null);
                                        {
                                            stream.setMode(RtpStream.MODE_SEND_ONLY);
                                        } 
                                        {
                                            boolean var6DC296E0183F0D6A7813976666F92608_1383751106 = (offer.getAttribute("sendonly") != null);
                                            {
                                                stream.setMode(RtpStream.MODE_RECEIVE_ONLY);
                                            } 
                                            {
                                                stream.setMode(RtpStream.MODE_NORMAL);
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Reject SDP: no suitable codecs");
        } 
        {
            boolean var79EFADA71B0A2CB2BF111DF46116166C_1006521316 = (isWifiOn());
            grabWifiHighPerfLock();
        } 
        AudioGroup audioGroup = getAudioGroup();
        {
            audioGroup = new AudioGroup();
            stream.join(audioGroup);
        } 
        setAudioGroupMode();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.982 -0400", hash_original_method = "1498B4B4889D09E5AF0E80BDDCC19CDB", hash_generated_method = "8544A5FBF4DB9DFD98842A61BF95CCF7")
    private void setAudioGroupMode() {
        AudioGroup audioGroup = getAudioGroup();
        {
            {
                audioGroup.setMode(AudioGroup.MODE_ON_HOLD);
            } 
            {
                audioGroup.setMode(AudioGroup.MODE_MUTED);
            } 
            {
                boolean var2602BD244D0DEA007155D10632BD8565_1703717460 = (isSpeakerOn());
                {
                    audioGroup.setMode(AudioGroup.MODE_ECHO_SUPPRESSION);
                } 
                {
                    audioGroup.setMode(AudioGroup.MODE_NORMAL);
                } 
            } 
        } 
        
        
        
            
                
            
                
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.982 -0400", hash_original_method = "CC3F94229D0F8EEA9220358FBB15354E", hash_generated_method = "BE55396D5EB5E613B955E66D33430687")
    private void stopCall(boolean releaseSocket) {
        Log.d(TAG, "stop audiocall");
        releaseWifiHighPerfLock();
        {
            mAudioStream.join(null);
            {
                mAudioStream.release();
                mAudioStream = null;
            } 
        } 
        addTaint(releaseSocket);
        
        
        
        
            
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.983 -0400", hash_original_method = "B878A2570A0CCD8ECF14B79C9C36E090", hash_generated_method = "1E6946F39E65C41090BCD0FFED5F1826")
    private String getLocalIp() {
        String varB4EAC82CA7396A68D541C85D26508E83_308183192 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_308183192 = mSipSession.getLocalIp();
        varB4EAC82CA7396A68D541C85D26508E83_308183192.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_308183192;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.983 -0400", hash_original_method = "16DFE4C58B2AE1A5BAAA6CDCCC648429", hash_generated_method = "BAA3BC8BA8F67A976D690BF1553071AA")
    private void throwSipException(Throwable throwable) throws SipException {
        {
            if (DroidSafeAndroidRuntime.control) throw (SipException) throwable;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("", throwable);
        } 
        addTaint(throwable.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.984 -0400", hash_original_method = "7E510B007B6231BC910990588CC742B2", hash_generated_method = "BCF975D149B9A0F618ED05C4ABB6A4F2")
    private SipProfile getPeerProfile(SipSession session) {
        SipProfile varB4EAC82CA7396A68D541C85D26508E83_537085506 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_537085506 = session.getPeerProfile();
        addTaint(session.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_537085506.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_537085506;
        
        
    }

    
    public static class Listener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.984 -0400", hash_original_method = "5575F820891B6AD64AFC44C76A4BA5AF", hash_generated_method = "5575F820891B6AD64AFC44C76A4BA5AF")
        public Listener ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.985 -0400", hash_original_method = "1692051440F2E30BB9552F9991C2F337", hash_generated_method = "681E26A2739242A9D63FF759B46E653A")
        public void onReadyToCall(SipAudioCall call) {
            
            onChanged(call);
            addTaint(call.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.985 -0400", hash_original_method = "F61EC18A6F9190266BB417D94187D91F", hash_generated_method = "3FB12AA2981168B5F1013C1CEF50BEA8")
        public void onCalling(SipAudioCall call) {
            
            onChanged(call);
            addTaint(call.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.985 -0400", hash_original_method = "80FA944D90A47A92553C0DDAF9805E5E", hash_generated_method = "4BF961064F3314259FB2EF61A715E8BF")
        public void onRinging(SipAudioCall call, SipProfile caller) {
            
            onChanged(call);
            addTaint(call.getTaint());
            addTaint(caller.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.986 -0400", hash_original_method = "F638A746C099264E58AA2EF34946D274", hash_generated_method = "4D3B2FE2967DB1946A5990F71BDD2520")
        public void onRingingBack(SipAudioCall call) {
            
            onChanged(call);
            addTaint(call.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.986 -0400", hash_original_method = "ED0948473C3573D4349DE4B81266B2ED", hash_generated_method = "DCFFE0B96954D895CA056EB96F3BAF73")
        public void onCallEstablished(SipAudioCall call) {
            
            onChanged(call);
            addTaint(call.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.986 -0400", hash_original_method = "87752713DF39DD8F370DBCB68CD08A8A", hash_generated_method = "5156AB39C05D9114636340AE842915CD")
        public void onCallEnded(SipAudioCall call) {
            
            onChanged(call);
            addTaint(call.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.986 -0400", hash_original_method = "A1C8D07F76B181730B1462483C996C45", hash_generated_method = "3A1159D43C0A1D06461C3B8A1CC51CD7")
        public void onCallBusy(SipAudioCall call) {
            
            onChanged(call);
            addTaint(call.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.987 -0400", hash_original_method = "901B34C07D0BCB3C3E5EC60CF9AA74AD", hash_generated_method = "EE7EEE7CDFBD824AB37AAC2DC20BF50E")
        public void onCallHeld(SipAudioCall call) {
            
            onChanged(call);
            addTaint(call.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.987 -0400", hash_original_method = "43C9D48E22A0172861A5C1A464B2052F", hash_generated_method = "EC54DFFDF24E7D35AE6C02667BE089A9")
        public void onError(SipAudioCall call, int errorCode,
                String errorMessage) {
            
            addTaint(call.getTaint());
            addTaint(errorCode);
            addTaint(errorMessage.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.987 -0400", hash_original_method = "06CD8F9D0FA40D0750F021E4FF896790", hash_generated_method = "5344D2CA13D23FE27CDA3E3AB1CBFDF1")
        public void onChanged(SipAudioCall call) {
            
            addTaint(call.getTaint());
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.987 -0400", hash_original_field = "B17C5B5C226E77B1666B9A31569420CB", hash_generated_field = "D0852ADB59FF9D54A384553BA77A5784")

    private static final String TAG = SipAudioCall.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.987 -0400", hash_original_field = "D0777547C9B1B5A66E95FC635B9FC11E", hash_generated_field = "CCC05A0ED1E689C779F088E9A0792429")

    private static final boolean RELEASE_SOCKET = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.987 -0400", hash_original_field = "3C98DA88265BAAAA0955009025FCEB1D", hash_generated_field = "445A359A7CC340C6BD7ACB8F708A8B97")

    private static final boolean DONT_RELEASE_SOCKET = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.988 -0400", hash_original_field = "5BC2C71FEA4432FD2C437C92A488A140", hash_generated_field = "18742BBD994F08DAD92A46AC0B004C26")

    private static final int SESSION_TIMEOUT = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.988 -0400", hash_original_field = "4F64C4E74B140C5A69D76BBF65C5177F", hash_generated_field = "907233FE68538E2431423AFE28884944")

    private static final int TRANSFER_TIMEOUT = 15;
    
      
}

