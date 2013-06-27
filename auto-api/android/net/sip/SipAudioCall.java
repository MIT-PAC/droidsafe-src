package android.net.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.557 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.557 -0400", hash_original_field = "FF1CB71BAB47D197D74F995BD9E7A803", hash_generated_field = "6E091E066D80096AB4790291B230BE96")

    private SipProfile mLocalProfile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.557 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "484D72CF31DE6402790176EF95A4C8E2")

    private SipAudioCall.Listener mListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.557 -0400", hash_original_field = "5A8516A00FC44EAD1FB2DF747AF176E7", hash_generated_field = "5A2B893C3FE2A9A2DE8E72D8792D353F")

    private SipSession mSipSession;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.557 -0400", hash_original_field = "696E4247B1C62891017C76DE2748F81D", hash_generated_field = "7C9004090DB280D3DD75EC1A1184D119")

    private SipSession mTransferringSession;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.558 -0400", hash_original_field = "B3D763F81031D116F4DDEFDCF2440B42", hash_generated_field = "7C64D41119E982E471870E4C818DD2D6")

    private long mSessionId = System.currentTimeMillis();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.558 -0400", hash_original_field = "489C27793E1C7DC00D4CE97B79831AE1", hash_generated_field = "9F59EE492C7A8D15690CB9BED1F25434")

    private String mPeerSd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.558 -0400", hash_original_field = "EED3B14E87D1A2B42EF2AAD48A1AE22C", hash_generated_field = "455D7DF5CAA0F63BF9C19FEC9C870ABC")

    private AudioStream mAudioStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.558 -0400", hash_original_field = "32C0A4CC3DE7ACB3907A60677CD6CE22", hash_generated_field = "62700614B1F5A2BE6501D87E3EA29746")

    private AudioGroup mAudioGroup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.558 -0400", hash_original_field = "DC811F268DA137B5E8B4F29600FBE75A", hash_generated_field = "7E358D7A0A2BA24FEA1EEA744FA91417")

    private boolean mInCall = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.558 -0400", hash_original_field = "1BC50C90C4537359FC1A482E47241617", hash_generated_field = "DAFCCC98CC29AFA37BE6BA4063A2F9C9")

    private boolean mMuted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.558 -0400", hash_original_field = "361220807CF04190F95695EA0129F31B", hash_generated_field = "2F42C58AE349901E944BC55F3F826C78")

    private boolean mHold = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.558 -0400", hash_original_field = "0AB50DE2E26B9721C5B5325D428A43AF", hash_generated_field = "B20041B31BF3C63BEA61010725B48956")

    private SipProfile mPendingCallRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.558 -0400", hash_original_field = "40E135D566C7D45C48786027486A41F9", hash_generated_field = "AA909A8A1E3B0EDD8AADADB48D5C730C")

    private WifiManager mWm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.558 -0400", hash_original_field = "0A13C2715EDB39FB8407B99856966C2F", hash_generated_field = "1064E8BF494EAE96395CFD56F6281589")

    private WifiManager.WifiLock mWifiHighPerfLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.558 -0400", hash_original_field = "617AB537A3FB63945C0DB8523A8EAAA5", hash_generated_field = "6408008D03AC8F90F3CE0B460908E415")

    private int mErrorCode = SipErrorCode.NO_ERROR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.558 -0400", hash_original_field = "DDF57A354F36667F5635F5344D9C8DEA", hash_generated_field = "CBCF3C2AB9532780C0A69F6C63B81E66")

    private String mErrorMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.567 -0400", hash_original_method = "E52D3B9BC90DBBDF3C179757863C5D97", hash_generated_method = "756A0602EA41970B104F8D81707C3875")
    public  SipAudioCall(Context context, SipProfile localProfile) {
        mContext = context;
        mLocalProfile = localProfile;
        mWm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        // ---------- Original Method ----------
        //mContext = context;
        //mLocalProfile = localProfile;
        //mWm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.568 -0400", hash_original_method = "624C526ACE340C91B4AE00384193A96D", hash_generated_method = "E7DA8685A5B756184F077349FF0925E0")
    public void setListener(SipAudioCall.Listener listener) {
        setListener(listener, false);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //setListener(listener, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.569 -0400", hash_original_method = "7FD2357D0901F6F1D08ACBD882A0FD6F", hash_generated_method = "C0C6E0F979A92169DF336CF239061F16")
    public void setListener(SipAudioCall.Listener listener,
            boolean callbackImmediately) {
        mListener = listener;
        try 
        {
            {
                listener.onError(this, mErrorCode, mErrorMessage);
            } //End block
            {
                {
                    listener.onCallHeld(this);
                } //End block
                {
                    listener.onCallEstablished(this);
                } //End block
            } //End block
            {
                int state;
                state = getState();
                //Begin case SipSession.State.READY_TO_CALL 
                listener.onReadyToCall(this);
                //End case SipSession.State.READY_TO_CALL 
                //Begin case SipSession.State.INCOMING_CALL 
                listener.onRinging(this, getPeerProfile());
                //End case SipSession.State.INCOMING_CALL 
                //Begin case SipSession.State.OUTGOING_CALL 
                listener.onCalling(this);
                //End case SipSession.State.OUTGOING_CALL 
                //Begin case SipSession.State.OUTGOING_CALL_RING_BACK 
                listener.onRingingBack(this);
                //End case SipSession.State.OUTGOING_CALL_RING_BACK 
            } //End block
        } //End block
        catch (Throwable t)
        { }
        addTaint(callbackImmediately);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.585 -0400", hash_original_method = "5739155C46DD20825CE1C589327CD281", hash_generated_method = "0AE0E5F62BDAFC989D82248EF98E1476")
    public boolean isInCall() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1075010007 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1075010007;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mInCall;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.585 -0400", hash_original_method = "2FD69B096455E1B51D801F19A8DBFD35", hash_generated_method = "A8329E50D804E3DEB97EDA9C7CF3DBD6")
    public boolean isOnHold() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_69012993 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_69012993;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mHold;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.586 -0400", hash_original_method = "597B95CEB5AFD05C977FB508D047C50E", hash_generated_method = "21668DF8FDBDBCA1A469227829ADE78B")
    public void close() {
        close(true);
        // ---------- Original Method ----------
        //close(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.589 -0400", hash_original_method = "AA0DE56AB4C8CE099E885498EC0B29F9", hash_generated_method = "53AB711578130E3994931AD6FBA6F105")
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
        } //End block
        addTaint(closeRtp);
        // ---------- Original Method ----------
        //if (closeRtp) stopCall(RELEASE_SOCKET);
        //mInCall = false;
        //mHold = false;
        //mSessionId = System.currentTimeMillis();
        //mErrorCode = SipErrorCode.NO_ERROR;
        //mErrorMessage = null;
        //if (mSipSession != null) {
            //mSipSession.setListener(null);
            //mSipSession = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.603 -0400", hash_original_method = "A61765ACD427BC1BAFB034CDA7289AED", hash_generated_method = "5CC34277E8DD9BD260980F985E139788")
    public SipProfile getLocalProfile() {
        SipProfile varB4EAC82CA7396A68D541C85D26508E83_1488908833 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1488908833 = mLocalProfile;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1488908833.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1488908833;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mLocalProfile;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.604 -0400", hash_original_method = "35C9BB243C8C9C83D8B1884AE3FDA6C7", hash_generated_method = "80058234B82F1B4FFF2DAB60D248D20D")
    public SipProfile getPeerProfile() {
        SipProfile varB4EAC82CA7396A68D541C85D26508E83_668166273 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_668166273 = (mSipSession == null) ? null : mSipSession.getPeerProfile();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_668166273.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_668166273;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return (mSipSession == null) ? null : mSipSession.getPeerProfile();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.605 -0400", hash_original_method = "6859CB7872625AC40861B5EFD6D7E2DC", hash_generated_method = "A153EDF200D0C69F62868A914B4DA543")
    public int getState() {
        {
            int var7BB3A2E3BA586BA005C2A26D50A17E95_1537722985 = (mSipSession.getState());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1878305484 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1878305484;
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mSipSession == null) return SipSession.State.READY_TO_CALL;
            //return mSipSession.getState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.610 -0400", hash_original_method = "9DD9B38A5D2A310FA14C467CD9F0FD11", hash_generated_method = "FF306CE6CDA612E03E4ACD97EFE7B4F1")
    public SipSession getSipSession() {
        SipSession varB4EAC82CA7396A68D541C85D26508E83_1583428139 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1583428139 = mSipSession;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1583428139.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1583428139;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mSipSession;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.627 -0400", hash_original_method = "88FD57B0E3684A7BA74DB8405E64F4E3", hash_generated_method = "7E9142EFC3A48EF43498CBCA168E0552")
    private synchronized void transferToNewSession() {
        SipSession origin;
        origin = mSipSession;
        mSipSession = mTransferringSession;
        mTransferringSession = null;
        {
            mAudioStream.join(null);
        } //End block
        {
            try 
            {
                mAudioStream = new AudioStream(InetAddress.getByName(
                        getLocalIp()));
            } //End block
            catch (Throwable t)
            { }
        } //End block
        origin.endCall();
        startAudio();
        // ---------- Original Method ----------
        //if (mTransferringSession == null) return;
        //SipSession origin = mSipSession;
        //mSipSession = mTransferringSession;
        //mTransferringSession = null;
        //if (mAudioStream != null) {
            //mAudioStream.join(null);
        //} else {
            //try {
                //mAudioStream = new AudioStream(InetAddress.getByName(
                        //getLocalIp()));
            //} catch (Throwable t) {
                //Log.i(TAG, "transferToNewSession(): " + t);
            //}
        //}
        //if (origin != null) origin.endCall();
        //startAudio();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.628 -0400", hash_original_method = "5E0B84D644E5F5257B7A32D95C62CBE3", hash_generated_method = "5C0D7DC5EA97EF877096012A50FEDF02")
    private SipSession.Listener createListener() {
        SipSession.Listener varB4EAC82CA7396A68D541C85D26508E83_1241239328 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1241239328 = new SipSession.Listener() {
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
        varB4EAC82CA7396A68D541C85D26508E83_1241239328.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1241239328;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.634 -0400", hash_original_method = "20EC585B752C6E63355D5D35BEA59116", hash_generated_method = "46940F8F98EA37839BAA225B81C1CED9")
    private void onError(int errorCode, String message) {
        Log.d(TAG, "sip session error: "
                + SipErrorCode.toString(errorCode) + ": " + message);
        mErrorCode = errorCode;
        mErrorMessage = message;
        Listener listener;
        listener = mListener;
        {
            try 
            {
                listener.onError(this, errorCode, message);
            } //End block
            catch (Throwable t)
            { }
        } //End block
        {
            {
                boolean var064562D536C7718FFB44A98A20F35A97_506441464 = ((errorCode == SipErrorCode.DATA_CONNECTION_LOST)
                    || !isInCall());
                {
                    close(true);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //Log.d(TAG, "sip session error: "
                //+ SipErrorCode.toString(errorCode) + ": " + message);
        //mErrorCode = errorCode;
        //mErrorMessage = message;
        //Listener listener = mListener;
        //if (listener != null) {
            //try {
                //listener.onError(this, errorCode, message);
            //} catch (Throwable t) {
                //Log.i(TAG, "onError(): " + t);
            //}
        //}
        //synchronized (this) {
            //if ((errorCode == SipErrorCode.DATA_CONNECTION_LOST)
                    //|| !isInCall()) {
                //close(true);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.651 -0400", hash_original_method = "9D47ECE9B5A5E502049A76A2D5CF7D58", hash_generated_method = "A12C909D26A96C930DCD379596BA682A")
    public void attachCall(SipSession session, String sessionDescription) throws SipException {
        {
            boolean var7C2B3BAF12F2B803CD1155B57592C3F4_1997640168 = (!SipManager.isVoipSupported(mContext));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("VOIP API is not supported");
            } //End block
        } //End collapsed parenthetic
        {
            mSipSession = session;
            mPeerSd = sessionDescription;
            try 
            {
                session.setListener(createListener());
            } //End block
            catch (Throwable e)
            {
                throwSipException(e);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (!SipManager.isVoipSupported(mContext)) {
            //throw new SipException("VOIP API is not supported");
        //}
        //synchronized (this) {
            //mSipSession = session;
            //mPeerSd = sessionDescription;
            //Log.v(TAG, "attachCall()" + mPeerSd);
            //try {
                //session.setListener(createListener());
            //} catch (Throwable e) {
                //Log.e(TAG, "attachCall()", e);
                //throwSipException(e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.653 -0400", hash_original_method = "CDFD7E26E80EFA4595D6BD4E5712D0C4", hash_generated_method = "B96645C51ED3EF75C4CEEB215073A564")
    public void makeCall(SipProfile peerProfile, SipSession sipSession,
            int timeout) throws SipException {
        {
            boolean var7C2B3BAF12F2B803CD1155B57592C3F4_1313289260 = (!SipManager.isVoipSupported(mContext));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("VOIP API is not supported");
            } //End block
        } //End collapsed parenthetic
        {
            mSipSession = sipSession;
            try 
            {
                mAudioStream = new AudioStream(InetAddress.getByName(
                        getLocalIp()));
                sipSession.setListener(createListener());
                sipSession.makeCall(peerProfile, createOffer().encode(),
                        timeout);
            } //End block
            catch (IOException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("makeCall()", e);
            } //End block
        } //End block
        addTaint(peerProfile.getTaint());
        addTaint(timeout);
        // ---------- Original Method ----------
        //if (!SipManager.isVoipSupported(mContext)) {
            //throw new SipException("VOIP API is not supported");
        //}
        //synchronized (this) {
            //mSipSession = sipSession;
            //try {
                //mAudioStream = new AudioStream(InetAddress.getByName(
                        //getLocalIp()));
                //sipSession.setListener(createListener());
                //sipSession.makeCall(peerProfile, createOffer().encode(),
                        //timeout);
            //} catch (IOException e) {
                //throw new SipException("makeCall()", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.657 -0400", hash_original_method = "DFE2EF72B1133A207E3F57586EB6C6EB", hash_generated_method = "FD6EAFD348EC9F0D54324F4AF9C63DE1")
    public void endCall() throws SipException {
        {
            stopCall(RELEASE_SOCKET);
            mInCall = false;
            mSipSession.endCall();
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //stopCall(RELEASE_SOCKET);
            //mInCall = false;
            //if (mSipSession != null) mSipSession.endCall();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.658 -0400", hash_original_method = "83B252D66EF8BD3A5BE285DBF75AA925", hash_generated_method = "BFC2FF9378D0553FC64277330524FA98")
    public void holdCall(int timeout) throws SipException {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Not in a call to hold call");
            } //End block
            mSipSession.changeCall(createHoldOffer().encode(), timeout);
            mHold = true;
            setAudioGroupMode();
        } //End block
        addTaint(timeout);
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mHold) return;
            //if (mSipSession == null) {
                //throw new SipException("Not in a call to hold call");
            //}
            //mSipSession.changeCall(createHoldOffer().encode(), timeout);
            //mHold = true;
            //setAudioGroupMode();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.676 -0400", hash_original_method = "7A338589242F74847BFE21BB083282FF", hash_generated_method = "D4AA0DDF92CF6A8DE62BA5105EB80D12")
    public void answerCall(int timeout) throws SipException {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("No call to answer");
            } //End block
            try 
            {
                mAudioStream = new AudioStream(InetAddress.getByName(
                        getLocalIp()));
                mSipSession.answerCall(createAnswer(mPeerSd).encode(), timeout);
            } //End block
            catch (IOException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("answerCall()", e);
            } //End block
        } //End block
        addTaint(timeout);
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mSipSession == null) {
                //throw new SipException("No call to answer");
            //}
            //try {
                //mAudioStream = new AudioStream(InetAddress.getByName(
                        //getLocalIp()));
                //mSipSession.answerCall(createAnswer(mPeerSd).encode(), timeout);
            //} catch (IOException e) {
                //throw new SipException("answerCall()", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.690 -0400", hash_original_method = "FE14EBF8C515C93259E0563DEA133194", hash_generated_method = "B98A027A40C4291CE9EE30E7C8FCBFF2")
    public void continueCall(int timeout) throws SipException {
        {
            mSipSession.changeCall(createContinueOffer().encode(), timeout);
            mHold = false;
            setAudioGroupMode();
        } //End block
        addTaint(timeout);
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (!mHold) return;
            //mSipSession.changeCall(createContinueOffer().encode(), timeout);
            //mHold = false;
            //setAudioGroupMode();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.765 -0400", hash_original_method = "0D8E98137E8907FA474D9700B196F628", hash_generated_method = "D44BEDA8507E36C6D4B2CAFCE900734C")
    private SimpleSessionDescription createOffer() {
        SimpleSessionDescription varB4EAC82CA7396A68D541C85D26508E83_1376529995 = null; //Variable for return #1
        SimpleSessionDescription offer;
        offer = new SimpleSessionDescription(mSessionId, getLocalIp());
        AudioCodec[] codecs;
        codecs = AudioCodec.getCodecs();
        Media media;
        media = offer.newMedia(
                "audio", mAudioStream.getLocalPort(), 1, "RTP/AVP");
        {
            AudioCodec codec = AudioCodec.getCodecs()[0];
            {
                media.setRtpPayload(codec.type, codec.rtpmap, codec.fmtp);
            } //End block
        } //End collapsed parenthetic
        media.setRtpPayload(127, "telephone-event/8000", "0-15");
        varB4EAC82CA7396A68D541C85D26508E83_1376529995 = offer;
        varB4EAC82CA7396A68D541C85D26508E83_1376529995.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1376529995;
        // ---------- Original Method ----------
        //SimpleSessionDescription offer =
                //new SimpleSessionDescription(mSessionId, getLocalIp());
        //AudioCodec[] codecs = AudioCodec.getCodecs();
        //Media media = offer.newMedia(
                //"audio", mAudioStream.getLocalPort(), 1, "RTP/AVP");
        //for (AudioCodec codec : AudioCodec.getCodecs()) {
            //media.setRtpPayload(codec.type, codec.rtpmap, codec.fmtp);
        //}
        //media.setRtpPayload(127, "telephone-event/8000", "0-15");
        //return offer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.022 -0400", hash_original_method = "7AC71E8F4C8E41998B13EFBED71D93BD", hash_generated_method = "67E960F1A53445D1353605C6C30F4203")
    private SimpleSessionDescription createAnswer(String offerSd) {
        SimpleSessionDescription varB4EAC82CA7396A68D541C85D26508E83_1168800811 = null; //Variable for return #1
        SimpleSessionDescription varB4EAC82CA7396A68D541C85D26508E83_1663944379 = null; //Variable for return #2
        {
            boolean varD57F5D9EDEEED5EBFB37D3EA7E739880_453816722 = (TextUtils.isEmpty(offerSd));
            varB4EAC82CA7396A68D541C85D26508E83_1168800811 = createOffer();
        } //End collapsed parenthetic
        SimpleSessionDescription offer;
        offer = new SimpleSessionDescription(offerSd);
        SimpleSessionDescription answer;
        answer = new SimpleSessionDescription(mSessionId, getLocalIp());
        AudioCodec codec;
        codec = null;
        {
            Media media = offer.getMedia()[0];
            {
                {
                    boolean var2DE1D53623224D4AB7ECC9712B740291_1592572829 = ((codec == null) && (media.getPort() > 0)
                    && "audio".equals(media.getType())
                    && "RTP/AVP".equals(media.getProtocol()));
                    {
                        {
                            int type = media.getRtpPayloadTypes()[0];
                            {
                                codec = AudioCodec.getCodec(type, media.getRtpmap(type),
                            media.getFmtp(type));
                            } //End block
                        } //End collapsed parenthetic
                        {
                            Media reply;
                            reply = answer.newMedia(
                            "audio", mAudioStream.getLocalPort(), 1, "RTP/AVP");
                            reply.setRtpPayload(codec.type, codec.rtpmap, codec.fmtp);
                            {
                                int type = media.getRtpPayloadTypes()[0];
                                {
                                    String rtpmap;
                                    rtpmap = media.getRtpmap(type);
                                    {
                                        boolean varCB957CD13AB208B86C56E8825962C086_1483002708 = ((type != codec.type) && (rtpmap != null)
                                && rtpmap.startsWith("telephone-event"));
                                        {
                                            reply.setRtpPayload(
                                    type, rtpmap, media.getFmtp(type));
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                            {
                                boolean var1A79B2A4B05C87BBB8B68D2C2016DC16_50772610 = (media.getAttribute("recvonly") != null);
                                {
                                    answer.setAttribute("sendonly", "");
                                } //End block
                                {
                                    boolean varB3F7193C3333B0079507F79363D4A8B4_966672106 = (media.getAttribute("sendonly") != null);
                                    {
                                        answer.setAttribute("recvonly", "");
                                    } //End block
                                    {
                                        boolean varB5C9A82246237C19E1097CE6E5634727_2062279683 = (offer.getAttribute("recvonly") != null);
                                        {
                                            answer.setAttribute("sendonly", "");
                                        } //End block
                                        {
                                            boolean var6DC296E0183F0D6A7813976666F92608_1549576898 = (offer.getAttribute("sendonly") != null);
                                            {
                                                answer.setAttribute("recvonly", "");
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                Media reply;
                reply = answer.newMedia(
                    media.getType(), 0, 1, media.getProtocol());
                {
                    String format = media.getFormats()[0];
                    {
                        reply.setFormat(format, null);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Reject SDP: no suitable codecs");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1663944379 = answer;
        addTaint(offerSd.getTaint());
        SimpleSessionDescription varA7E53CE21691AB073D9660D615818899_204784862; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_204784862 = varB4EAC82CA7396A68D541C85D26508E83_1168800811;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_204784862 = varB4EAC82CA7396A68D541C85D26508E83_1663944379;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_204784862.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_204784862;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.053 -0400", hash_original_method = "B99EA71C05B29A1F5EF342AB2FDD525C", hash_generated_method = "1736FE3DE49FCE9C209B3E7DC382B067")
    private SimpleSessionDescription createHoldOffer() {
        SimpleSessionDescription varB4EAC82CA7396A68D541C85D26508E83_848168744 = null; //Variable for return #1
        SimpleSessionDescription offer;
        offer = createContinueOffer();
        offer.setAttribute("sendonly", "");
        varB4EAC82CA7396A68D541C85D26508E83_848168744 = offer;
        varB4EAC82CA7396A68D541C85D26508E83_848168744.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_848168744;
        // ---------- Original Method ----------
        //SimpleSessionDescription offer = createContinueOffer();
        //offer.setAttribute("sendonly", "");
        //return offer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.055 -0400", hash_original_method = "71EB52827AB306B4A3579086FF868817", hash_generated_method = "CD88DB3162EB925CBAA765F2B8A8D83D")
    private SimpleSessionDescription createContinueOffer() {
        SimpleSessionDescription varB4EAC82CA7396A68D541C85D26508E83_1650386380 = null; //Variable for return #1
        SimpleSessionDescription offer;
        offer = new SimpleSessionDescription(mSessionId, getLocalIp());
        Media media;
        media = offer.newMedia(
                "audio", mAudioStream.getLocalPort(), 1, "RTP/AVP");
        AudioCodec codec;
        codec = mAudioStream.getCodec();
        media.setRtpPayload(codec.type, codec.rtpmap, codec.fmtp);
        int dtmfType;
        dtmfType = mAudioStream.getDtmfType();
        {
            media.setRtpPayload(dtmfType, "telephone-event/8000", "0-15");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1650386380 = offer;
        varB4EAC82CA7396A68D541C85D26508E83_1650386380.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1650386380;
        // ---------- Original Method ----------
        //SimpleSessionDescription offer =
                //new SimpleSessionDescription(mSessionId, getLocalIp());
        //Media media = offer.newMedia(
                //"audio", mAudioStream.getLocalPort(), 1, "RTP/AVP");
        //AudioCodec codec = mAudioStream.getCodec();
        //media.setRtpPayload(codec.type, codec.rtpmap, codec.fmtp);
        //int dtmfType = mAudioStream.getDtmfType();
        //if (dtmfType != -1) {
            //media.setRtpPayload(dtmfType, "telephone-event/8000", "0-15");
        //}
        //return offer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.065 -0400", hash_original_method = "9511FA94EBBE4D902AF961AAA5743C5F", hash_generated_method = "1678A407CDD83AD87374506DBEA7F6F9")
    private void grabWifiHighPerfLock() {
        {
            mWifiHighPerfLock = ((WifiManager)
                    mContext.getSystemService(Context.WIFI_SERVICE))
                    .createWifiLock(WifiManager.WIFI_MODE_FULL_HIGH_PERF, TAG);
            mWifiHighPerfLock.acquire();
        } //End block
        // ---------- Original Method ----------
        //if (mWifiHighPerfLock == null) {
            //Log.v(TAG, "acquire wifi high perf lock");
            //mWifiHighPerfLock = ((WifiManager)
                    //mContext.getSystemService(Context.WIFI_SERVICE))
                    //.createWifiLock(WifiManager.WIFI_MODE_FULL_HIGH_PERF, TAG);
            //mWifiHighPerfLock.acquire();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.066 -0400", hash_original_method = "94C077E9D4A3B70D9C34E2292E80901C", hash_generated_method = "8F7F811C1A6F870FF7B54E76DC4FE6D4")
    private void releaseWifiHighPerfLock() {
        {
            mWifiHighPerfLock.release();
            mWifiHighPerfLock = null;
        } //End block
        // ---------- Original Method ----------
        //if (mWifiHighPerfLock != null) {
            //Log.v(TAG, "release wifi high perf lock");
            //mWifiHighPerfLock.release();
            //mWifiHighPerfLock = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.067 -0400", hash_original_method = "FC1EDAFB978C2E10313819704C8134E2", hash_generated_method = "5E8849729759B144E98B0C699A27551E")
    private boolean isWifiOn() {
        {
            boolean varA39A642AAD196AE2FD89489CCF53E246_231460082 = ((mWm.getConnectionInfo().getBSSID() == null));
        } //End flattened ternary
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1399475497 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1399475497;
        // ---------- Original Method ----------
        //return (mWm.getConnectionInfo().getBSSID() == null) ? false : true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.100 -0400", hash_original_method = "91407CCBE269ED4E5C3C36CDEC2695DD", hash_generated_method = "6BCC9B5174D08C2ED8FA25D85C24B9D8")
    public void toggleMute() {
        {
            mMuted = !mMuted;
            setAudioGroupMode();
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //mMuted = !mMuted;
            //setAudioGroupMode();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.100 -0400", hash_original_method = "CF2F318ECC83A27F31B207A7653E2463", hash_generated_method = "E3128C8F91EF11E2A6CF78E57F5108A8")
    public boolean isMuted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_783700593 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_783700593;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mMuted;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.102 -0400", hash_original_method = "8238959D9236D29164DC3B2B6875AEBE", hash_generated_method = "AA47DBB812A0EAA3C21C3633BEA23FD3")
    public void setSpeakerMode(boolean speakerMode) {
        {
            ((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                    .setSpeakerphoneOn(speakerMode);
            setAudioGroupMode();
        } //End block
        addTaint(speakerMode);
        // ---------- Original Method ----------
        //synchronized (this) {
            //((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                    //.setSpeakerphoneOn(speakerMode);
            //setAudioGroupMode();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.103 -0400", hash_original_method = "1B6C9A8A7DE7A949D0CD2E188D6FBBDC", hash_generated_method = "12447B8DF7E2E6A0445190B56D7D6AE3")
    private boolean isSpeakerOn() {
        boolean varB3D6950D5F301C704C02A4854CB7D217_943337120 = (((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                .isSpeakerphoneOn());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_950557410 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_950557410;
        // ---------- Original Method ----------
        //return ((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                //.isSpeakerphoneOn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.104 -0400", hash_original_method = "5FC4A2324FC6DD99D16BF2BD98355D7B", hash_generated_method = "384D48BD48775F53CEE2226794747204")
    public void sendDtmf(int code) {
        sendDtmf(code, null);
        addTaint(code);
        // ---------- Original Method ----------
        //sendDtmf(code, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.105 -0400", hash_original_method = "7A09CE165EA90677044F14874DA9275F", hash_generated_method = "BCDCC450E8C22FE167BDA91A9E4565A3")
    public void sendDtmf(int code, Message result) {
        {
            AudioGroup audioGroup;
            audioGroup = getAudioGroup();
            {
                boolean var40B0A392B41D3543A13A1EBA207462F2_1846856993 = ((audioGroup != null) && (mSipSession != null)
                    && (SipSession.State.IN_CALL == getState()));
                {
                    audioGroup.sendDtmf(code);
                } //End block
            } //End collapsed parenthetic
            result.sendToTarget();
        } //End block
        addTaint(code);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //synchronized (this) {
            //AudioGroup audioGroup = getAudioGroup();
            //if ((audioGroup != null) && (mSipSession != null)
                    //&& (SipSession.State.IN_CALL == getState())) {
                //Log.v(TAG, "send DTMF: " + code);
                //audioGroup.sendDtmf(code);
            //}
            //if (result != null) result.sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.114 -0400", hash_original_method = "974213146461E5146ED1F54CFC83DFBA", hash_generated_method = "461B11B4B7888B759339D76A4095FD4E")
    public AudioStream getAudioStream() {
        AudioStream varB4EAC82CA7396A68D541C85D26508E83_1258589005 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1258589005 = mAudioStream;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1258589005.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1258589005;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mAudioStream;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.116 -0400", hash_original_method = "BB542D10B17F9F4E162984482435ECE8", hash_generated_method = "6886684E8B2294640B3E2E01F17FD651")
    public AudioGroup getAudioGroup() {
        AudioGroup varB4EAC82CA7396A68D541C85D26508E83_670411288 = null; //Variable for return #1
        AudioGroup varB4EAC82CA7396A68D541C85D26508E83_1030369513 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_670411288 = mAudioGroup;
            varB4EAC82CA7396A68D541C85D26508E83_1030369513 = ((mAudioStream == null) ? null : mAudioStream.getGroup());
        } //End block
        AudioGroup varA7E53CE21691AB073D9660D615818899_657994111; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_657994111 = varB4EAC82CA7396A68D541C85D26508E83_670411288;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_657994111 = varB4EAC82CA7396A68D541C85D26508E83_1030369513;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_657994111.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_657994111;
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mAudioGroup != null) return mAudioGroup;
            //return ((mAudioStream == null) ? null : mAudioStream.getGroup());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.125 -0400", hash_original_method = "59C2E1D195E6E28B792310EB7C59BD4B", hash_generated_method = "8DBCCB7B3C43204970E6AABFE5B4432F")
    public void setAudioGroup(AudioGroup group) {
        {
            {
                boolean varBF4F994E1BAFD5371D1A8FD1902D3F31_1338940572 = ((mAudioStream != null) && (mAudioStream.getGroup() != null));
                {
                    mAudioStream.join(group);
                } //End block
            } //End collapsed parenthetic
            mAudioGroup = group;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if ((mAudioStream != null) && (mAudioStream.getGroup() != null)) {
                //mAudioStream.join(group);
            //}
            //mAudioGroup = group;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.126 -0400", hash_original_method = "4F615D2FF52BC5640F885A620AAE1B91", hash_generated_method = "ED5FF7F74B4910A94D893D435B061A8A")
    public void startAudio() {
        try 
        {
            startAudioInternal();
        } //End block
        catch (UnknownHostException e)
        {
            onError(SipErrorCode.PEER_NOT_REACHABLE, e.getMessage());
        } //End block
        catch (Throwable e)
        {
            onError(SipErrorCode.CLIENT_ERROR, e.getMessage());
        } //End block
        // ---------- Original Method ----------
        //try {
            //startAudioInternal();
        //} catch (UnknownHostException e) {
            //onError(SipErrorCode.PEER_NOT_REACHABLE, e.getMessage());
        //} catch (Throwable e) {
            //onError(SipErrorCode.CLIENT_ERROR, e.getMessage());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.358 -0400", hash_original_method = "29EB701080CA01C59CC1BB8E207AC1D7", hash_generated_method = "1C07B9BF4F66B20AB18794349783966A")
    private synchronized void startAudioInternal() throws UnknownHostException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("mPeerSd = null");
        } //End block
        stopCall(DONT_RELEASE_SOCKET);
        mInCall = true;
        SimpleSessionDescription offer;
        offer = new SimpleSessionDescription(mPeerSd);
        AudioStream stream;
        stream = mAudioStream;
        AudioCodec codec;
        codec = null;
        {
            Media media = offer.getMedia()[0];
            {
                {
                    boolean var2DE1D53623224D4AB7ECC9712B740291_159094868 = ((codec == null) && (media.getPort() > 0)
                    && "audio".equals(media.getType())
                    && "RTP/AVP".equals(media.getProtocol()));
                    {
                        {
                            int type = media.getRtpPayloadTypes()[0];
                            {
                                codec = AudioCodec.getCodec(
                            type, media.getRtpmap(type), media.getFmtp(type));
                            } //End block
                        } //End collapsed parenthetic
                        {
                            String address;
                            address = media.getAddress();
                            {
                                address = offer.getAddress();
                            } //End block
                            stream.associate(InetAddress.getByName(address),
                            media.getPort());
                            stream.setDtmfType(-1);
                            stream.setCodec(codec);
                            {
                                int type = media.getRtpPayloadTypes()[0];
                                {
                                    String rtpmap;
                                    rtpmap = media.getRtpmap(type);
                                    {
                                        boolean varCB957CD13AB208B86C56E8825962C086_941845674 = ((type != codec.type) && (rtpmap != null)
                                && rtpmap.startsWith("telephone-event"));
                                        {
                                            stream.setDtmfType(type);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                            {
                                stream.setMode(RtpStream.MODE_NORMAL);
                            } //End block
                            {
                                boolean var1A79B2A4B05C87BBB8B68D2C2016DC16_536815174 = (media.getAttribute("recvonly") != null);
                                {
                                    stream.setMode(RtpStream.MODE_SEND_ONLY);
                                } //End block
                                {
                                    boolean varB3F7193C3333B0079507F79363D4A8B4_2103747870 = (media.getAttribute("sendonly") != null);
                                    {
                                        stream.setMode(RtpStream.MODE_RECEIVE_ONLY);
                                    } //End block
                                    {
                                        boolean varB5C9A82246237C19E1097CE6E5634727_772887336 = (offer.getAttribute("recvonly") != null);
                                        {
                                            stream.setMode(RtpStream.MODE_SEND_ONLY);
                                        } //End block
                                        {
                                            boolean var6DC296E0183F0D6A7813976666F92608_229281610 = (offer.getAttribute("sendonly") != null);
                                            {
                                                stream.setMode(RtpStream.MODE_RECEIVE_ONLY);
                                            } //End block
                                            {
                                                stream.setMode(RtpStream.MODE_NORMAL);
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Reject SDP: no suitable codecs");
        } //End block
        {
            boolean var79EFADA71B0A2CB2BF111DF46116166C_244480723 = (isWifiOn());
            grabWifiHighPerfLock();
        } //End collapsed parenthetic
        AudioGroup audioGroup;
        audioGroup = getAudioGroup();
        {
            audioGroup = new AudioGroup();
            stream.join(audioGroup);
        } //End block
        setAudioGroupMode();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.361 -0400", hash_original_method = "1498B4B4889D09E5AF0E80BDDCC19CDB", hash_generated_method = "9F4DBECAFDCF1B6B04AAA961B62D2656")
    private void setAudioGroupMode() {
        AudioGroup audioGroup;
        audioGroup = getAudioGroup();
        {
            {
                audioGroup.setMode(AudioGroup.MODE_ON_HOLD);
            } //End block
            {
                audioGroup.setMode(AudioGroup.MODE_MUTED);
            } //End block
            {
                boolean var2602BD244D0DEA007155D10632BD8565_1257349549 = (isSpeakerOn());
                {
                    audioGroup.setMode(AudioGroup.MODE_ECHO_SUPPRESSION);
                } //End block
                {
                    audioGroup.setMode(AudioGroup.MODE_NORMAL);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //AudioGroup audioGroup = getAudioGroup();
        //if (audioGroup != null) {
            //if (mHold) {
                //audioGroup.setMode(AudioGroup.MODE_ON_HOLD);
            //} else if (mMuted) {
                //audioGroup.setMode(AudioGroup.MODE_MUTED);
            //} else if (isSpeakerOn()) {
                //audioGroup.setMode(AudioGroup.MODE_ECHO_SUPPRESSION);
            //} else {
                //audioGroup.setMode(AudioGroup.MODE_NORMAL);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.365 -0400", hash_original_method = "CC3F94229D0F8EEA9220358FBB15354E", hash_generated_method = "BE55396D5EB5E613B955E66D33430687")
    private void stopCall(boolean releaseSocket) {
        Log.d(TAG, "stop audiocall");
        releaseWifiHighPerfLock();
        {
            mAudioStream.join(null);
            {
                mAudioStream.release();
                mAudioStream = null;
            } //End block
        } //End block
        addTaint(releaseSocket);
        // ---------- Original Method ----------
        //Log.d(TAG, "stop audiocall");
        //releaseWifiHighPerfLock();
        //if (mAudioStream != null) {
            //mAudioStream.join(null);
            //if (releaseSocket) {
                //mAudioStream.release();
                //mAudioStream = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.378 -0400", hash_original_method = "B878A2570A0CCD8ECF14B79C9C36E090", hash_generated_method = "27272BF7450A8389237D27E842987D5F")
    private String getLocalIp() {
        String varB4EAC82CA7396A68D541C85D26508E83_1512715331 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1512715331 = mSipSession.getLocalIp();
        varB4EAC82CA7396A68D541C85D26508E83_1512715331.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1512715331;
        // ---------- Original Method ----------
        //return mSipSession.getLocalIp();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.379 -0400", hash_original_method = "16DFE4C58B2AE1A5BAAA6CDCCC648429", hash_generated_method = "BAA3BC8BA8F67A976D690BF1553071AA")
    private void throwSipException(Throwable throwable) throws SipException {
        {
            if (DroidSafeAndroidRuntime.control) throw (SipException) throwable;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("", throwable);
        } //End block
        addTaint(throwable.getTaint());
        // ---------- Original Method ----------
        //if (throwable instanceof SipException) {
            //throw (SipException) throwable;
        //} else {
            //throw new SipException("", throwable);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.380 -0400", hash_original_method = "7E510B007B6231BC910990588CC742B2", hash_generated_method = "68BFF218ECFC4131A640010CC3B5AFDB")
    private SipProfile getPeerProfile(SipSession session) {
        SipProfile varB4EAC82CA7396A68D541C85D26508E83_990302107 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_990302107 = session.getPeerProfile();
        addTaint(session.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_990302107.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_990302107;
        // ---------- Original Method ----------
        //return session.getPeerProfile();
    }

    
    public static class Listener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.380 -0400", hash_original_method = "5575F820891B6AD64AFC44C76A4BA5AF", hash_generated_method = "5575F820891B6AD64AFC44C76A4BA5AF")
        public Listener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.381 -0400", hash_original_method = "1692051440F2E30BB9552F9991C2F337", hash_generated_method = "681E26A2739242A9D63FF759B46E653A")
        public void onReadyToCall(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            onChanged(call);
            addTaint(call.getTaint());
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.381 -0400", hash_original_method = "F61EC18A6F9190266BB417D94187D91F", hash_generated_method = "3FB12AA2981168B5F1013C1CEF50BEA8")
        public void onCalling(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            onChanged(call);
            addTaint(call.getTaint());
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.397 -0400", hash_original_method = "80FA944D90A47A92553C0DDAF9805E5E", hash_generated_method = "4BF961064F3314259FB2EF61A715E8BF")
        public void onRinging(SipAudioCall call, SipProfile caller) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            onChanged(call);
            addTaint(call.getTaint());
            addTaint(caller.getTaint());
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.397 -0400", hash_original_method = "F638A746C099264E58AA2EF34946D274", hash_generated_method = "4D3B2FE2967DB1946A5990F71BDD2520")
        public void onRingingBack(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            onChanged(call);
            addTaint(call.getTaint());
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.398 -0400", hash_original_method = "ED0948473C3573D4349DE4B81266B2ED", hash_generated_method = "DCFFE0B96954D895CA056EB96F3BAF73")
        public void onCallEstablished(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            onChanged(call);
            addTaint(call.getTaint());
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.398 -0400", hash_original_method = "87752713DF39DD8F370DBCB68CD08A8A", hash_generated_method = "5156AB39C05D9114636340AE842915CD")
        public void onCallEnded(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            onChanged(call);
            addTaint(call.getTaint());
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.399 -0400", hash_original_method = "A1C8D07F76B181730B1462483C996C45", hash_generated_method = "3A1159D43C0A1D06461C3B8A1CC51CD7")
        public void onCallBusy(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            onChanged(call);
            addTaint(call.getTaint());
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.400 -0400", hash_original_method = "901B34C07D0BCB3C3E5EC60CF9AA74AD", hash_generated_method = "EE7EEE7CDFBD824AB37AAC2DC20BF50E")
        public void onCallHeld(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            onChanged(call);
            addTaint(call.getTaint());
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.404 -0400", hash_original_method = "43C9D48E22A0172861A5C1A464B2052F", hash_generated_method = "EC54DFFDF24E7D35AE6C02667BE089A9")
        public void onError(SipAudioCall call, int errorCode,
                String errorMessage) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(call.getTaint());
            addTaint(errorCode);
            addTaint(errorMessage.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.404 -0400", hash_original_method = "06CD8F9D0FA40D0750F021E4FF896790", hash_generated_method = "5344D2CA13D23FE27CDA3E3AB1CBFDF1")
        public void onChanged(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(call.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.404 -0400", hash_original_field = "B17C5B5C226E77B1666B9A31569420CB", hash_generated_field = "E0430FF6A51E058584C56BBCE8DC4DC5")

    private static String TAG = SipAudioCall.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.404 -0400", hash_original_field = "D0777547C9B1B5A66E95FC635B9FC11E", hash_generated_field = "D1F0A621D38E363CBB131F004B014715")

    private static boolean RELEASE_SOCKET = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.405 -0400", hash_original_field = "3C98DA88265BAAAA0955009025FCEB1D", hash_generated_field = "C82263A6A8B5F2673D4C44E26141D57C")

    private static boolean DONT_RELEASE_SOCKET = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.405 -0400", hash_original_field = "5BC2C71FEA4432FD2C437C92A488A140", hash_generated_field = "FBBE1FF0E880FFF0900E20AE57CC42BC")

    private static int SESSION_TIMEOUT = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.405 -0400", hash_original_field = "4F64C4E74B140C5A69D76BBF65C5177F", hash_generated_field = "0A5923085FE97246C320F940B414AA47")

    private static int TRANSFER_TIMEOUT = 15;
}

