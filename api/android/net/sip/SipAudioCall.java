package android.net.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import android.content.Context;
import android.media.AudioManager;
import android.net.rtp.AudioCodec;
import android.net.rtp.AudioGroup;
import android.net.rtp.AudioStream;
import android.net.rtp.RtpStream;
import android.net.sip.SimpleSessionDescription.Media;
import android.net.wifi.WifiManager;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

public class SipAudioCall {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.747 -0500", hash_original_field = "ECB462AA564671EA5EFCA087712A5A7C", hash_generated_field = "D0852ADB59FF9D54A384553BA77A5784")

    private static final String TAG = SipAudioCall.class.getSimpleName();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.749 -0500", hash_original_field = "16462092A7EC43E575E1BDF56DEC13BA", hash_generated_field = "CCC05A0ED1E689C779F088E9A0792429")

    private static final boolean RELEASE_SOCKET = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.751 -0500", hash_original_field = "EC6EC6AA587C3573C503161D69ED4BFF", hash_generated_field = "445A359A7CC340C6BD7ACB8F708A8B97")

    private static final boolean DONT_RELEASE_SOCKET = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.753 -0500", hash_original_field = "3D1C80F0F6A8E614F60C55C8C0603803", hash_generated_field = "18742BBD994F08DAD92A46AC0B004C26")

    private static final int SESSION_TIMEOUT = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.756 -0500", hash_original_field = "383D42CF3FEF44B441215D1DB4C4B63A", hash_generated_field = "907233FE68538E2431423AFE28884944")

    private static final int TRANSFER_TIMEOUT = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.784 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.786 -0500", hash_original_field = "E42F615C81D0FDF1C15F82232CE018E9", hash_generated_field = "6E091E066D80096AB4790291B230BE96")

    private SipProfile mLocalProfile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.788 -0500", hash_original_field = "2754FAE65A5320C43C1BF27598A89A60", hash_generated_field = "484D72CF31DE6402790176EF95A4C8E2")

    private SipAudioCall.Listener mListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.790 -0500", hash_original_field = "4F7BD7FFC4045CD06D184609F092B8D2", hash_generated_field = "5A2B893C3FE2A9A2DE8E72D8792D353F")

    private SipSession mSipSession;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.792 -0500", hash_original_field = "C5708D44CDC13393AAAB7E0457BA3765", hash_generated_field = "7C9004090DB280D3DD75EC1A1184D119")

    private SipSession mTransferringSession;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.794 -0500", hash_original_field = "8169000539DBB0B35A7FA07E0AFD732E", hash_generated_field = "7C64D41119E982E471870E4C818DD2D6")

    private long mSessionId = System.currentTimeMillis();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.796 -0500", hash_original_field = "8CBEDB97683784B9A292B654984F2FCF", hash_generated_field = "9F59EE492C7A8D15690CB9BED1F25434")

    private String mPeerSd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.798 -0500", hash_original_field = "74789311E2C36C75790CF750A6FEBC45", hash_generated_field = "455D7DF5CAA0F63BF9C19FEC9C870ABC")

    private AudioStream mAudioStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.800 -0500", hash_original_field = "6CE25C655DCCCE37EC3F114FEE68EEC8", hash_generated_field = "62700614B1F5A2BE6501D87E3EA29746")

    private AudioGroup mAudioGroup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.803 -0500", hash_original_field = "59ACEF77EFD0EC60C0D8606E5CAC877F", hash_generated_field = "7E358D7A0A2BA24FEA1EEA744FA91417")

    private boolean mInCall = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.805 -0500", hash_original_field = "93BCE4CCC8B2BD665F63F2492636BEC7", hash_generated_field = "DAFCCC98CC29AFA37BE6BA4063A2F9C9")

    private boolean mMuted = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.807 -0500", hash_original_field = "44045DE9FC23169FAD612CD8B0C6C91F", hash_generated_field = "2F42C58AE349901E944BC55F3F826C78")

    private boolean mHold = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.809 -0500", hash_original_field = "3F776EB43D8E03946A31C3CFA9E91EFF", hash_generated_field = "B20041B31BF3C63BEA61010725B48956")

    private SipProfile mPendingCallRequest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.811 -0500", hash_original_field = "C126C2044EE6DE6A2333B2BC3DCC20FA", hash_generated_field = "AA909A8A1E3B0EDD8AADADB48D5C730C")

    private WifiManager mWm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.813 -0500", hash_original_field = "6D952A3E87BF58B0C4C00E14844278EA", hash_generated_field = "1064E8BF494EAE96395CFD56F6281589")

    private WifiManager.WifiLock mWifiHighPerfLock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.815 -0500", hash_original_field = "6301366819F80C78E95378B21983B4FD", hash_generated_field = "6408008D03AC8F90F3CE0B460908E415")

    private int mErrorCode = SipErrorCode.NO_ERROR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.817 -0500", hash_original_field = "2134AAACFB6EDFBE79ABBE45636CB43E", hash_generated_field = "CBCF3C2AB9532780C0A69F6C63B81E66")

    private String mErrorMessage;

    /**
     * Creates a call object with the local SIP profile.
     * @param context the context for accessing system services such as
     *        ringtone, audio, WIFI etc
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.820 -0500", hash_original_method = "E52D3B9BC90DBBDF3C179757863C5D97", hash_generated_method = "69E91BDD0248A2C32E6AD5564234BB81")
    
public SipAudioCall(Context context, SipProfile localProfile) {
        mContext = context;
        mLocalProfile = localProfile;
        mWm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    }

    /**
     * Sets the listener to listen to the audio call events. The method calls
     * {@link #setListener setListener(listener, false)}.
     *
     * @param listener to listen to the audio call events of this object
     * @see #setListener(Listener, boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.822 -0500", hash_original_method = "624C526ACE340C91B4AE00384193A96D", hash_generated_method = "DB7607906465AD6E43DAE61C401A9904")
    @DSVerified("Calling callbacks ")
    @DSSpec(DSCat.PHONE_CALL)
public void setListener(SipAudioCall.Listener listener) {
        setListener(listener, false);
    }

    /**
     * Sets the listener to listen to the audio call events. A
     * {@link SipAudioCall} can only hold one listener at a time. Subsequent
     * calls to this method override the previous listener.
     *
     * @param listener to listen to the audio call events of this object
     * @param callbackImmediately set to true if the caller wants to be called
     *      back immediately on the current state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.825 -0500", hash_original_method = "7FD2357D0901F6F1D08ACBD882A0FD6F", hash_generated_method = "24A40599EF26E0E62B11B908766CB98F")
    @DSVerified("Calling callbacks ")
    @DSSpec(DSCat.PHONE_CALL)
public void setListener(SipAudioCall.Listener listener,
            boolean callbackImmediately) {
        mListener = listener;
        try {
            if ((listener == null) || !callbackImmediately) {
                // do nothing
            } else if (mErrorCode != SipErrorCode.NO_ERROR) {
                listener.onError(this, mErrorCode, mErrorMessage);
            } else if (mInCall) {
                if (mHold) {
                    listener.onCallHeld(this);
                } else {
                    listener.onCallEstablished(this);
                }
            } else {
                int state = getState();
                switch (state) {
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
                        
                    default:
                        listener.onCallBusy(this);
                        listener.onCallEnded(this);
                        listener.onChanged(this);
                        
                }
            }
        } catch (Throwable t) {
            Log.e(TAG, "setListener()", t);
        }
    }

    /**
     * Checks if the call is established.
     *
     * @return true if the call is established
     */
    @DSComment("Sip phone call")
    @DSSpec(DSCat.PHONE_CALL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.827 -0500", hash_original_method = "5739155C46DD20825CE1C589327CD281", hash_generated_method = "FD6A0C45A3EF0F6AAB79922CBDEFCDCE")
    
public boolean isInCall() {
        synchronized (this) {
            return mInCall;
        }
    }

    /**
     * Checks if the call is on hold.
     *
     * @return true if the call is on hold
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.829 -0500", hash_original_method = "2FD69B096455E1B51D801F19A8DBFD35", hash_generated_method = "259D9284B9E32D040665E61DB462A055")
    
public boolean isOnHold() {
        synchronized (this) {
            return mHold;
        }
    }

    /**
     * Closes this object. This object is not usable after being closed.
     */
    @DSComment("Sip phone call")
    @DSSpec(DSCat.PHONE_CALL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.831 -0500", hash_original_method = "597B95CEB5AFD05C977FB508D047C50E", hash_generated_method = "5A3337BA0DCEE457132408A727907816")
    
public void close() {
        close(true);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.834 -0500", hash_original_method = "AA0DE56AB4C8CE099E885498EC0B29F9", hash_generated_method = "D1ABD1DE0C1AD1E949134E832F826DF0")
    
private synchronized void close(boolean closeRtp) {
        if (closeRtp) stopCall(RELEASE_SOCKET);

        mInCall = false;
        mHold = false;
        mSessionId = System.currentTimeMillis();
        mErrorCode = SipErrorCode.NO_ERROR;
        mErrorMessage = null;

        if (mSipSession != null) {
            mSipSession.setListener(null);
            mSipSession = null;
        }
    }

    /**
     * Gets the local SIP profile.
     *
     * @return the local SIP profile
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.836 -0500", hash_original_method = "A61765ACD427BC1BAFB034CDA7289AED", hash_generated_method = "CAF41BC7A8412FBE9764D57E21929224")
    
public SipProfile getLocalProfile() {
        synchronized (this) {
            return mLocalProfile;
        }
    }

    /**
     * Gets the peer's SIP profile.
     *
     * @return the peer's SIP profile
     */
    @DSComment("Sip phone call")
    @DSSpec(DSCat.PHONE_CALL)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.839 -0500", hash_original_method = "35C9BB243C8C9C83D8B1884AE3FDA6C7", hash_generated_method = "996CEED17CF24A8F2536B81E8CCF7F1A")
    
public SipProfile getPeerProfile() {
        synchronized (this) {
            return (mSipSession == null) ? null : mSipSession.getPeerProfile();
        }
    }

    /**
     * Gets the state of the {@link SipSession} that carries this call.
     * The value returned must be one of the states in {@link SipSession.State}.
     *
     * @return the session state
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.841 -0500", hash_original_method = "6859CB7872625AC40861B5EFD6D7E2DC", hash_generated_method = "45677BDFAFE85EF5E3629BFBD2D85BB6")
    
public int getState() {
        synchronized (this) {
            if (mSipSession == null) return SipSession.State.READY_TO_CALL;
            return mSipSession.getState();
        }
    }

    /**
     * Gets the {@link SipSession} that carries this call.
     *
     * @return the session object that carries this call
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.843 -0500", hash_original_method = "9DD9B38A5D2A310FA14C467CD9F0FD11", hash_generated_method = "55724D3251FACEE43B78680C366E936A")
    
public SipSession getSipSession() {
        synchronized (this) {
            return mSipSession;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.846 -0500", hash_original_method = "88FD57B0E3684A7BA74DB8405E64F4E3", hash_generated_method = "0C73D2B17900478CB2681908082D5C55")
    
private synchronized void transferToNewSession() {
        if (mTransferringSession == null) return;
        SipSession origin = mSipSession;
        mSipSession = mTransferringSession;
        mTransferringSession = null;

        // stop the replaced call.
        if (mAudioStream != null) {
            mAudioStream.join(null);
        } else {
            try {
                mAudioStream = new AudioStream(InetAddress.getByName(
                        getLocalIp()));
            } catch (Throwable t) {
                Log.i(TAG, "transferToNewSession(): " + t);
            }
        }
        if (origin != null) origin.endCall();
        startAudio();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.485 -0400", hash_original_method = "5E0B84D644E5F5257B7A32D95C62CBE3", hash_generated_method = "126C0A87209BC520FD4BA9B979A58122")
    private SipSession.Listener createListener() {
SipSession.Listener var471FDD296ED6D8C124DBA353D5A605DC_349773066 =         new SipSession.Listener() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.849 -0500", hash_original_method = "0B4EFC2EA5E0F3FF31D08EEDE61256FC", hash_generated_method = "934D46ABAA520ADDB8B948C4F6E88F33")
            
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

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.852 -0500", hash_original_method = "FA01AFE96119E691A320DB4A08849437", hash_generated_method = "469B0682A3651260C60042169E4904DB")
            
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

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.855 -0500", hash_original_method = "7370CA2F33F803A4BC98509DFD10599B", hash_generated_method = "0591381D9746C0DAF08F1A3BA369B472")
            
@Override
            public void onRinging(SipSession session,
                    SipProfile peerProfile, String sessionDescription) {
                // this callback is triggered only for reinvite.
                synchronized (SipAudioCall.this) {
                    if ((mSipSession == null) || !mInCall
                            || !session.getCallId().equals(
                                    mSipSession.getCallId())) {
                        // should not happen
                        session.endCall();
                        return;
                    }

                    // session changing request
                    try {
                        String answer = createAnswer(sessionDescription).encode();
                        mSipSession.answerCall(answer, SESSION_TIMEOUT);
                    } catch (Throwable e) {
                        Log.e(TAG, "onRinging()", e);
                        session.endCall();
                    }
                }
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.858 -0500", hash_original_method = "40BF40985539E4127A37E81035B80A7A", hash_generated_method = "463E931E15303B240FD980C6E42A7489")
            
@Override
            public void onCallEstablished(SipSession session,
                    String sessionDescription) {
                mPeerSd = sessionDescription;
                Log.v(TAG, "onCallEstablished()" + mPeerSd);

                // TODO: how to notify the UI that the remote party is changed
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

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.860 -0500", hash_original_method = "1DE904A1CABA70AB1A25A453A4094AFC", hash_generated_method = "8598A5DF10F1EA75CA3CCFE2DB47811D")
            
@Override
            public void onCallEnded(SipSession session) {
                Log.d(TAG, "sip call ended: " + session + " mSipSession:" + mSipSession);
                // reset the trasnferring session if it is the one.
                if (session == mTransferringSession) {
                    mTransferringSession = null;
                    return;
                }
                // or ignore the event if the original session is being
                // transferred to the new one.
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

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.863 -0500", hash_original_method = "3CC4E6D954281F2D5FD31AADF17A6DC9", hash_generated_method = "6E21C973B61D45AE37A568F4B9EF2721")
            
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

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.867 -0500", hash_original_method = "16D7065ED36A3B723322ABAA4FB7FA22", hash_generated_method = "D52076037FB1847612B6CCF8426EF46E")
            
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

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.869 -0500", hash_original_method = "F58D9162CF10989F568AF55ED18D4C89", hash_generated_method = "C3B4B94005C7D682878E7244D0E0003D")
            
@Override
            public void onError(SipSession session, int errorCode,
                    String message) {
                SipAudioCall.this.onError(errorCode, message);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.872 -0500", hash_original_method = "20558DF6BFC1217A7001B14AA50A9A03", hash_generated_method = "00F337E7A8D4BB5D48DB86C5F75373E2")
            
@Override
            public void onRegistering(SipSession session) {
                // irrelevant
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.874 -0500", hash_original_method = "43D598AFE19AB6009363638DB64C1F7B", hash_generated_method = "E489A8C49C7B45ABAFC8746DEE008AAC")
            
@Override
            public void onRegistrationTimeout(SipSession session) {
                // irrelevant
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.877 -0500", hash_original_method = "E69FEDA3BC0AF93EB01ADFD4BE332B13", hash_generated_method = "0D3468B5B7E4740D97774018A8335B68")
            
@Override
            public void onRegistrationFailed(SipSession session, int errorCode,
                    String message) {
                // irrelevant
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.880 -0500", hash_original_method = "7504CEF239C11FEA532F08720FD2042B", hash_generated_method = "D20F392F04F2CF823E6D4B0F9A3C0B70")
            
@Override
            public void onRegistrationDone(SipSession session, int duration) {
                // irrelevant
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.883 -0500", hash_original_method = "5F9A92DE1F30C09A899AB4EFC4F87B6D", hash_generated_method = "C93DA63D423263AA2CBCA456EDE2CB32")
            
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
        var471FDD296ED6D8C124DBA353D5A605DC_349773066.addTaint(getTaint());
        return var471FDD296ED6D8C124DBA353D5A605DC_349773066;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.890 -0500", hash_original_method = "20EC585B752C6E63355D5D35BEA59116", hash_generated_method = "B065157F6D47410321EA14DD917AD090")
    
private void onError(int errorCode, String message) {
        Log.d(TAG, "sip session error: "
                + SipErrorCode.toString(errorCode) + ": " + message);
        mErrorCode = errorCode;
        mErrorMessage = message;
        Listener listener = mListener;
        if (listener != null) {
            try {
                listener.onError(this, errorCode, message);
            } catch (Throwable t) {
                Log.i(TAG, "onError(): " + t);
            }
        }
        synchronized (this) {
            if ((errorCode == SipErrorCode.DATA_CONNECTION_LOST)
                    || !isInCall()) {
                close(true);
            }
        }
    }

    /**
     * Attaches an incoming call to this call object.
     *
     * @param session the session that receives the incoming call
     * @param sessionDescription the session description of the incoming call
     * @throws SipException if the SIP service fails to attach this object to
     *        the session or VOIP API is not supported by the device
     * @see SipManager#isVoipSupported
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.892 -0500", hash_original_method = "9D47ECE9B5A5E502049A76A2D5CF7D58", hash_generated_method = "0DCAFC3A7A241B92057F01231D3EE9FC")
    
public void attachCall(SipSession session, String sessionDescription)
            throws SipException {
        if (!SipManager.isVoipSupported(mContext)) {
            throw new SipException("VOIP API is not supported");
        }

        synchronized (this) {
            mSipSession = session;
            mPeerSd = sessionDescription;
            Log.v(TAG, "attachCall()" + mPeerSd);
            try {
                session.setListener(createListener());
            } catch (Throwable e) {
                Log.e(TAG, "attachCall()", e);
                throwSipException(e);
            }
        }
    }

    /**
     * Initiates an audio call to the specified profile. The attempt will be
     * timed out if the call is not established within {@code timeout} seconds
     * and {@link Listener#onError onError(SipAudioCall, SipErrorCode.TIME_OUT, String)}
     * will be called.
     *
     * @param peerProfile the SIP profile to make the call to
     * @param sipSession the {@link SipSession} for carrying out the call
     * @param timeout the timeout value in seconds. Default value (defined by
     *        SIP protocol) is used if {@code timeout} is zero or negative.
     * @see Listener#onError
     * @throws SipException if the SIP service fails to create a session for the
     *        call or VOIP API is not supported by the device
     * @see SipManager#isVoipSupported
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.895 -0500", hash_original_method = "CDFD7E26E80EFA4595D6BD4E5712D0C4", hash_generated_method = "5E42044AB3897BA1C9D2618970F8C699")
    @DSVerified
    @DSSpec(DSCat.PHONE_CALL)
public void makeCall(SipProfile peerProfile, SipSession sipSession,
            int timeout) throws SipException {
        if (!SipManager.isVoipSupported(mContext)) {
            throw new SipException("VOIP API is not supported");
        }

        synchronized (this) {
            mSipSession = sipSession;
            try {
                mAudioStream = new AudioStream(InetAddress.getByName(
                        getLocalIp()));
                sipSession.setListener(createListener());
                sipSession.makeCall(peerProfile, createOffer().encode(),
                        timeout);
            } catch (IOException e) {
                throw new SipException("makeCall()", e);
            }
        }
    }

    /**
     * Ends a call.
     * @throws SipException if the SIP service fails to end the call
     */
    @DSComment("Sip phone call")
    @DSSpec(DSCat.PHONE_CALL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.897 -0500", hash_original_method = "DFE2EF72B1133A207E3F57586EB6C6EB", hash_generated_method = "60E43B2B816DEC8474962F7293A78A26")
    
public void endCall() throws SipException {
        synchronized (this) {
            stopCall(RELEASE_SOCKET);
            mInCall = false;

            // perform the above local ops first and then network op
            if (mSipSession != null) mSipSession.endCall();
        }
    }

    /**
     * Puts a call on hold.  When succeeds, {@link Listener#onCallHeld} is
     * called. The attempt will be timed out if the call is not established
     * within {@code timeout} seconds and
     * {@link Listener#onError onError(SipAudioCall, SipErrorCode.TIME_OUT, String)}
     * will be called.
     *
     * @param timeout the timeout value in seconds. Default value (defined by
     *        SIP protocol) is used if {@code timeout} is zero or negative.
     * @see Listener#onError
     * @throws SipException if the SIP service fails to hold the call
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.900 -0500", hash_original_method = "83B252D66EF8BD3A5BE285DBF75AA925", hash_generated_method = "F756AE4C22D01EA7EA4F4AD27ABB9670")
    
public void holdCall(int timeout) throws SipException {
        synchronized (this) {
            if (mHold) return;
            if (mSipSession == null) {
                throw new SipException("Not in a call to hold call");
            }
            mSipSession.changeCall(createHoldOffer().encode(), timeout);
            mHold = true;
            setAudioGroupMode();
        }
    }

    /**
     * Answers a call. The attempt will be timed out if the call is not
     * established within {@code timeout} seconds and
     * {@link Listener#onError onError(SipAudioCall, SipErrorCode.TIME_OUT, String)}
     * will be called.
     *
     * @param timeout the timeout value in seconds. Default value (defined by
     *        SIP protocol) is used if {@code timeout} is zero or negative.
     * @see Listener#onError
     * @throws SipException if the SIP service fails to answer the call
     */
    @DSComment("Sip phone call")
    @DSSpec(DSCat.PHONE_CALL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.902 -0500", hash_original_method = "7A338589242F74847BFE21BB083282FF", hash_generated_method = "26F4AC03CB1B6276F79ACC554680607E")
    
public void answerCall(int timeout) throws SipException {
        synchronized (this) {
            if (mSipSession == null) {
                throw new SipException("No call to answer");
            }
            try {
                mAudioStream = new AudioStream(InetAddress.getByName(
                        getLocalIp()));
                mSipSession.answerCall(createAnswer(mPeerSd).encode(), timeout);
            } catch (IOException e) {
                throw new SipException("answerCall()", e);
            }
        }
    }

    /**
     * Continues a call that's on hold. When succeeds,
     * {@link Listener#onCallEstablished} is called. The attempt will be timed
     * out if the call is not established within {@code timeout} seconds and
     * {@link Listener#onError onError(SipAudioCall, SipErrorCode.TIME_OUT, String)}
     * will be called.
     *
     * @param timeout the timeout value in seconds. Default value (defined by
     *        SIP protocol) is used if {@code timeout} is zero or negative.
     * @see Listener#onError
     * @throws SipException if the SIP service fails to unhold the call
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.904 -0500", hash_original_method = "FE14EBF8C515C93259E0563DEA133194", hash_generated_method = "AA7EFB37D5FE49D6AB43A76E13687B49")
    
public void continueCall(int timeout) throws SipException {
        synchronized (this) {
            if (!mHold) return;
            mSipSession.changeCall(createContinueOffer().encode(), timeout);
            mHold = false;
            setAudioGroupMode();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.906 -0500", hash_original_method = "0D8E98137E8907FA474D9700B196F628", hash_generated_method = "F31C8E0FB66AAA25B5BE186D0BBE5E5E")
    
private SimpleSessionDescription createOffer() {
        SimpleSessionDescription offer =
                new SimpleSessionDescription(mSessionId, getLocalIp());
        AudioCodec[] codecs = AudioCodec.getCodecs();
        Media media = offer.newMedia(
                "audio", mAudioStream.getLocalPort(), 1, "RTP/AVP");
        for (AudioCodec codec : AudioCodec.getCodecs()) {
            media.setRtpPayload(codec.type, codec.rtpmap, codec.fmtp);
        }
        media.setRtpPayload(127, "telephone-event/8000", "0-15");
        return offer;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.910 -0500", hash_original_method = "7AC71E8F4C8E41998B13EFBED71D93BD", hash_generated_method = "5BE9B4EC5A53056BB8D22C579F0987D0")
    
private SimpleSessionDescription createAnswer(String offerSd) {
        if (TextUtils.isEmpty(offerSd)) return createOffer();
        SimpleSessionDescription offer =
                new SimpleSessionDescription(offerSd);
        SimpleSessionDescription answer =
                new SimpleSessionDescription(mSessionId, getLocalIp());
        AudioCodec codec = null;
        for (Media media : offer.getMedia()) {
            if ((codec == null) && (media.getPort() > 0)
                    && "audio".equals(media.getType())
                    && "RTP/AVP".equals(media.getProtocol())) {
                // Find the first audio codec we supported.
                for (int type : media.getRtpPayloadTypes()) {
                    codec = AudioCodec.getCodec(type, media.getRtpmap(type),
                            media.getFmtp(type));
                    if (codec != null) {
                        break;
                    }
                }
                if (codec != null) {
                    Media reply = answer.newMedia(
                            "audio", mAudioStream.getLocalPort(), 1, "RTP/AVP");
                    reply.setRtpPayload(codec.type, codec.rtpmap, codec.fmtp);

                    // Check if DTMF is supported in the same media.
                    for (int type : media.getRtpPayloadTypes()) {
                        String rtpmap = media.getRtpmap(type);
                        if ((type != codec.type) && (rtpmap != null)
                                && rtpmap.startsWith("telephone-event")) {
                            reply.setRtpPayload(
                                    type, rtpmap, media.getFmtp(type));
                        }
                    }

                    // Handle recvonly and sendonly.
                    if (media.getAttribute("recvonly") != null) {
                        answer.setAttribute("sendonly", "");
                    } else if(media.getAttribute("sendonly") != null) {
                        answer.setAttribute("recvonly", "");
                    } else if(offer.getAttribute("recvonly") != null) {
                        answer.setAttribute("sendonly", "");
                    } else if(offer.getAttribute("sendonly") != null) {
                        answer.setAttribute("recvonly", "");
                    }
                    continue;
                }
            }
            // Reject the media.
            Media reply = answer.newMedia(
                    media.getType(), 0, 1, media.getProtocol());
            for (String format : media.getFormats()) {
                reply.setFormat(format, null);
            }
        }
        if (codec == null) {
            throw new IllegalStateException("Reject SDP: no suitable codecs");
        }
        return answer;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.912 -0500", hash_original_method = "B99EA71C05B29A1F5EF342AB2FDD525C", hash_generated_method = "CEC42E4577DBB5AC1FEF22454C89E0F1")
    
private SimpleSessionDescription createHoldOffer() {
        SimpleSessionDescription offer = createContinueOffer();
        offer.setAttribute("sendonly", "");
        return offer;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.915 -0500", hash_original_method = "71EB52827AB306B4A3579086FF868817", hash_generated_method = "D7903CB59D6AF82615A8C665CAB4ED8F")
    
private SimpleSessionDescription createContinueOffer() {
        SimpleSessionDescription offer =
                new SimpleSessionDescription(mSessionId, getLocalIp());
        Media media = offer.newMedia(
                "audio", mAudioStream.getLocalPort(), 1, "RTP/AVP");
        AudioCodec codec = mAudioStream.getCodec();
        media.setRtpPayload(codec.type, codec.rtpmap, codec.fmtp);
        int dtmfType = mAudioStream.getDtmfType();
        if (dtmfType != -1) {
            media.setRtpPayload(dtmfType, "telephone-event/8000", "0-15");
        }
        return offer;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.917 -0500", hash_original_method = "9511FA94EBBE4D902AF961AAA5743C5F", hash_generated_method = "7082D71768A9E983E4176C4E8ADEA499")
    
private void grabWifiHighPerfLock() {
        if (mWifiHighPerfLock == null) {
            Log.v(TAG, "acquire wifi high perf lock");
            mWifiHighPerfLock = ((WifiManager)
                    mContext.getSystemService(Context.WIFI_SERVICE))
                    .createWifiLock(WifiManager.WIFI_MODE_FULL_HIGH_PERF, TAG);
            mWifiHighPerfLock.acquire();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.919 -0500", hash_original_method = "94C077E9D4A3B70D9C34E2292E80901C", hash_generated_method = "7CE0BDE3036B28BE29C5EF5060234744")
    
private void releaseWifiHighPerfLock() {
        if (mWifiHighPerfLock != null) {
            Log.v(TAG, "release wifi high perf lock");
            mWifiHighPerfLock.release();
            mWifiHighPerfLock = null;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.921 -0500", hash_original_method = "FC1EDAFB978C2E10313819704C8134E2", hash_generated_method = "3995CD253293D570183EA884E01EC4C6")
    
private boolean isWifiOn() {
        return (mWm.getConnectionInfo().getBSSID() == null) ? false : true;
    }

    /** Toggles mute. */
    @DSComment("Sip phone call")
    @DSSpec(DSCat.PHONE_CALL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.924 -0500", hash_original_method = "91407CCBE269ED4E5C3C36CDEC2695DD", hash_generated_method = "50396E262A97339209C9B2C8CDF9F361")
    
public void toggleMute() {
        synchronized (this) {
            mMuted = !mMuted;
            setAudioGroupMode();
        }
    }

    /**
     * Checks if the call is muted.
     *
     * @return true if the call is muted
     */
    @DSComment("Sip phone call")
    @DSSpec(DSCat.PHONE_CALL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.926 -0500", hash_original_method = "CF2F318ECC83A27F31B207A7653E2463", hash_generated_method = "4E76D8C24BA709E7E5DC0EDE2CF31391")
    
public boolean isMuted() {
        synchronized (this) {
            return mMuted;
        }
    }

    /**
     * Puts the device to speaker mode.
     * <p class="note"><strong>Note:</strong> Requires the
     *   {@link android.Manifest.permission#MODIFY_AUDIO_SETTINGS} permission.</p>
     *
     * @param speakerMode set true to enable speaker mode; false to disable
     */
    @DSComment("Sip phone call")
    @DSSpec(DSCat.PHONE_CALL)
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.928 -0500", hash_original_method = "8238959D9236D29164DC3B2B6875AEBE", hash_generated_method = "FFDC17446A86A64C24D10EABB9704266")
    
public void setSpeakerMode(boolean speakerMode) {
        synchronized (this) {
            ((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                    .setSpeakerphoneOn(speakerMode);
            setAudioGroupMode();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.930 -0500", hash_original_method = "1B6C9A8A7DE7A949D0CD2E188D6FBBDC", hash_generated_method = "7CE9BD647031F8943EB0E2073490FFA1")
    
private boolean isSpeakerOn() {
        return ((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                .isSpeakerphoneOn();
    }

    /**
     * Sends a DTMF code. According to <a href="http://tools.ietf.org/html/rfc2833">RFC 2883</a>,
     * event 0--9 maps to decimal
     * value 0--9, '*' to 10, '#' to 11, event 'A'--'D' to 12--15, and event
     * flash to 16. Currently, event flash is not supported.
     *
     * @param code the DTMF code to send. Value 0 to 15 (inclusive) are valid
     *        inputs.
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.933 -0500", hash_original_method = "5FC4A2324FC6DD99D16BF2BD98355D7B", hash_generated_method = "F6F0B09859D5F33E88782A14F5B94A7F")
    
public void sendDtmf(int code) {
        sendDtmf(code, null);
    }

    /**
     * Sends a DTMF code. According to <a href="http://tools.ietf.org/html/rfc2833">RFC 2883</a>,
     * event 0--9 maps to decimal
     * value 0--9, '*' to 10, '#' to 11, event 'A'--'D' to 12--15, and event
     * flash to 16. Currently, event flash is not supported.
     *
     * @param code the DTMF code to send. Value 0 to 15 (inclusive) are valid
     *        inputs.
     * @param result the result message to send when done
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.935 -0500", hash_original_method = "7A09CE165EA90677044F14874DA9275F", hash_generated_method = "90769E5544110EF09B509FA6D9318E52")
    
public void sendDtmf(int code, Message result) {
        synchronized (this) {
            AudioGroup audioGroup = getAudioGroup();
            if ((audioGroup != null) && (mSipSession != null)
                    && (SipSession.State.IN_CALL == getState())) {
                Log.v(TAG, "send DTMF: " + code);
                audioGroup.sendDtmf(code);
            }
            if (result != null) result.sendToTarget();
        }
    }

    /**
     * Gets the {@link AudioStream} object used in this call. The object
     * represents the RTP stream that carries the audio data to and from the
     * peer. The object may not be created before the call is established. And
     * it is undefined after the call ends or the {@link #close} method is
     * called.
     *
     * @return the {@link AudioStream} object or null if the RTP stream has not
     *      yet been set up
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.937 -0500", hash_original_method = "974213146461E5146ED1F54CFC83DFBA", hash_generated_method = "8AF3B686950FBA027647529ACC3A5140")
    
public AudioStream getAudioStream() {
        synchronized (this) {
            return mAudioStream;
        }
    }

    /**
     * Gets the {@link AudioGroup} object which the {@link AudioStream} object
     * joins. The group object may not exist before the call is established.
     * Also, the {@code AudioStream} may change its group during a call (e.g.,
     * after the call is held/un-held). Finally, the {@code AudioGroup} object
     * returned by this method is undefined after the call ends or the
     * {@link #close} method is called. If a group object is set by
     * {@link #setAudioGroup(AudioGroup)}, then this method returns that object.
     *
     * @return the {@link AudioGroup} object or null if the RTP stream has not
     *      yet been set up
     * @see #getAudioStream
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.939 -0500", hash_original_method = "BB542D10B17F9F4E162984482435ECE8", hash_generated_method = "D1AE3173CEFCA1C9440BFAAB128BFD82")
    
public AudioGroup getAudioGroup() {
        synchronized (this) {
            if (mAudioGroup != null) return mAudioGroup;
            return ((mAudioStream == null) ? null : mAudioStream.getGroup());
        }
    }

    /**
     * Sets the {@link AudioGroup} object which the {@link AudioStream} object
     * joins. If {@code audioGroup} is null, then the {@code AudioGroup} object
     * will be dynamically created when needed. Note that the mode of the
     * {@code AudioGroup} is not changed according to the audio settings (i.e.,
     * hold, mute, speaker phone) of this object. This is mainly used to merge
     * multiple {@code SipAudioCall} objects to form a conference call. The
     * settings of the first object (that merges others) override others'.
     *
     * @see #getAudioStream
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.942 -0500", hash_original_method = "59C2E1D195E6E28B792310EB7C59BD4B", hash_generated_method = "7069199ECF27E42E6A18DA5FE854544C")
    
public void setAudioGroup(AudioGroup group) {
        synchronized (this) {
            if ((mAudioStream != null) && (mAudioStream.getGroup() != null)) {
                mAudioStream.join(group);
            }
            mAudioGroup = group;
        }
    }

    /**
     * Starts the audio for the established call. This method should be called
     * after {@link Listener#onCallEstablished} is called.
     * <p class="note"><strong>Note:</strong> Requires the
     *   {@link android.Manifest.permission#RECORD_AUDIO},
     *   {@link android.Manifest.permission#ACCESS_WIFI_STATE} and
     *   {@link android.Manifest.permission#WAKE_LOCK} permissions.</p>
     */
    @DSComment("Sip phone call")
    @DSSpec(DSCat.PHONE_CALL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.944 -0500", hash_original_method = "4F615D2FF52BC5640F885A620AAE1B91", hash_generated_method = "762E9079DFC855F10467D29157BF7540")
    
public void startAudio() {
        try {
            startAudioInternal();
        } catch (UnknownHostException e) {
            onError(SipErrorCode.PEER_NOT_REACHABLE, e.getMessage());
        } catch (Throwable e) {
            onError(SipErrorCode.CLIENT_ERROR, e.getMessage());
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.948 -0500", hash_original_method = "29EB701080CA01C59CC1BB8E207AC1D7", hash_generated_method = "EA3BFAF85BE5FC369B110AA087A55582")
    
private synchronized void startAudioInternal() throws UnknownHostException {
        if (mPeerSd == null) {
            Log.v(TAG, "startAudioInternal() mPeerSd = null");
            throw new IllegalStateException("mPeerSd = null");
        }

        stopCall(DONT_RELEASE_SOCKET);
        mInCall = true;

        // Run exact the same logic in createAnswer() to setup mAudioStream.
        SimpleSessionDescription offer =
                new SimpleSessionDescription(mPeerSd);
        AudioStream stream = mAudioStream;
        AudioCodec codec = null;
        for (Media media : offer.getMedia()) {
            if ((codec == null) && (media.getPort() > 0)
                    && "audio".equals(media.getType())
                    && "RTP/AVP".equals(media.getProtocol())) {
                // Find the first audio codec we supported.
                for (int type : media.getRtpPayloadTypes()) {
                    codec = AudioCodec.getCodec(
                            type, media.getRtpmap(type), media.getFmtp(type));
                    if (codec != null) {
                        break;
                    }
                }

                if (codec != null) {
                    // Associate with the remote host.
                    String address = media.getAddress();
                    if (address == null) {
                        address = offer.getAddress();
                    }
                    stream.associate(InetAddress.getByName(address),
                            media.getPort());

                    stream.setDtmfType(-1);
                    stream.setCodec(codec);
                    // Check if DTMF is supported in the same media.
                    for (int type : media.getRtpPayloadTypes()) {
                        String rtpmap = media.getRtpmap(type);
                        if ((type != codec.type) && (rtpmap != null)
                                && rtpmap.startsWith("telephone-event")) {
                            stream.setDtmfType(type);
                        }
                    }

                    // Handle recvonly and sendonly.
                    if (mHold) {
                        stream.setMode(RtpStream.MODE_NORMAL);
                    } else if (media.getAttribute("recvonly") != null) {
                        stream.setMode(RtpStream.MODE_SEND_ONLY);
                    } else if(media.getAttribute("sendonly") != null) {
                        stream.setMode(RtpStream.MODE_RECEIVE_ONLY);
                    } else if(offer.getAttribute("recvonly") != null) {
                        stream.setMode(RtpStream.MODE_SEND_ONLY);
                    } else if(offer.getAttribute("sendonly") != null) {
                        stream.setMode(RtpStream.MODE_RECEIVE_ONLY);
                    } else {
                        stream.setMode(RtpStream.MODE_NORMAL);
                    }
                    break;
                }
            }
        }
        if (codec == null) {
            throw new IllegalStateException("Reject SDP: no suitable codecs");
        }

        if (isWifiOn()) grabWifiHighPerfLock();

        // AudioGroup logic:
        AudioGroup audioGroup = getAudioGroup();
        if (mHold) {
            // don't create an AudioGroup here; doing so will fail if
            // there's another AudioGroup out there that's active
        } else {
            if (audioGroup == null) audioGroup = new AudioGroup();
            stream.join(audioGroup);
        }
        setAudioGroupMode();
    }
    
    public static class Listener {
        
        @DSComment("potential callback called inside method")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.502 -0400", hash_original_method = "5575F820891B6AD64AFC44C76A4BA5AF", hash_generated_method = "5575F820891B6AD64AFC44C76A4BA5AF")
        @DSVerified    
        public Listener ()
        {
            //Synthesized constructor
        }
        /**
         * Called when the call object is ready to make another call.
         * The default implementation calls {@link #onChanged}.
         *
         * @param call the call object that is ready to make another call
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.759 -0500", hash_original_method = "1692051440F2E30BB9552F9991C2F337", hash_generated_method = "11E668ECFDA3B77B737AC61A09899A92")
        @DSVerified
        @DSSpec(DSCat.PHONE_CALL)
public void onReadyToCall(SipAudioCall call) {
            onChanged(call);
        }

        /**
         * Called when a request is sent out to initiate a new call.
         * The default implementation calls {@link #onChanged}.
         *
         * @param call the call object that carries out the audio call
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.761 -0500", hash_original_method = "F61EC18A6F9190266BB417D94187D91F", hash_generated_method = "A2F25A849A146D828EA39EF638EF651C")
        @DSVerified
        @DSSpec(DSCat.PHONE_CALL)
public void onCalling(SipAudioCall call) {
            onChanged(call);
        }

        /**
         * Called when a new call comes in.
         * The default implementation calls {@link #onChanged}.
         *
         * @param call the call object that carries out the audio call
         * @param caller the SIP profile of the caller
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.763 -0500", hash_original_method = "80FA944D90A47A92553C0DDAF9805E5E", hash_generated_method = "2216F8741C0D3E0F7248E17820ED8C16")
        @DSVerified
        @DSSpec(DSCat.PHONE_CALL)
public void onRinging(SipAudioCall call, SipProfile caller) {
            onChanged(call);
        }

        /**
         * Called when a RINGING response is received for the INVITE request
         * sent. The default implementation calls {@link #onChanged}.
         *
         * @param call the call object that carries out the audio call
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.765 -0500", hash_original_method = "F638A746C099264E58AA2EF34946D274", hash_generated_method = "85C5171B79693998CB064F2B1EBC9370")
        @DSVerified
        @DSSpec(DSCat.PHONE_CALL)
public void onRingingBack(SipAudioCall call) {
            onChanged(call);
        }

        /**
         * Called when the session is established.
         * The default implementation calls {@link #onChanged}.
         *
         * @param call the call object that carries out the audio call
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.767 -0500", hash_original_method = "ED0948473C3573D4349DE4B81266B2ED", hash_generated_method = "B29327434525E3AE5D606811D905F286")
        @DSVerified
        @DSSpec(DSCat.PHONE_CALL)
public void onCallEstablished(SipAudioCall call) {
            onChanged(call);
        }

        /**
         * Called when the session is terminated.
         * The default implementation calls {@link #onChanged}.
         *
         * @param call the call object that carries out the audio call
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.770 -0500", hash_original_method = "87752713DF39DD8F370DBCB68CD08A8A", hash_generated_method = "1745C01EC15FF64CFAC097B664847063")
        @DSVerified
        @DSSpec(DSCat.PHONE_CALL)
public void onCallEnded(SipAudioCall call) {
            onChanged(call);
        }

        /**
         * Called when the peer is busy during session initialization.
         * The default implementation calls {@link #onChanged}.
         *
         * @param call the call object that carries out the audio call
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.772 -0500", hash_original_method = "A1C8D07F76B181730B1462483C996C45", hash_generated_method = "47FB9647763A344B26BEEAA4798D4E1D")
        @DSVerified
        @DSSpec(DSCat.PHONE_CALL)
public void onCallBusy(SipAudioCall call) {
            onChanged(call);
        }

        /**
         * Called when the call is on hold.
         * The default implementation calls {@link #onChanged}.
         *
         * @param call the call object that carries out the audio call
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.774 -0500", hash_original_method = "901B34C07D0BCB3C3E5EC60CF9AA74AD", hash_generated_method = "37DA2E50BF4BFD1E75192F716647973B")
        @DSVerified
        @DSSpec(DSCat.PHONE_CALL)
public void onCallHeld(SipAudioCall call) {
            onChanged(call);
        }

        /**
         * Called when an error occurs. The default implementation is no op.
         *
         * @param call the call object that carries out the audio call
         * @param errorCode error code of this error
         * @param errorMessage error message
         * @see SipErrorCode
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.777 -0500", hash_original_method = "43C9D48E22A0172861A5C1A464B2052F", hash_generated_method = "906E4C73DD296925B03F12293E1E5F56")
        @DSVerified
        @DSSpec(DSCat.PHONE_CALL)
public void onError(SipAudioCall call, int errorCode,
                String errorMessage) {
            // no-op
        }

        /**
         * Called when an event occurs and the corresponding callback is not
         * overridden. The default implementation is no op. Error events are
         * not re-directed to this callback and are handled in {@link #onError}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.780 -0500", hash_original_method = "06CD8F9D0FA40D0750F021E4FF896790", hash_generated_method = "1D21261A8AAFC730014FD4AC6F0A67F7")
        @DSVerified
        @DSSpec(DSCat.PHONE_CALL)
public void onChanged(SipAudioCall call) {
            // no-op
        }
        
    }

    // set audio group mode based on current audio configuration
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.950 -0500", hash_original_method = "1498B4B4889D09E5AF0E80BDDCC19CDB", hash_generated_method = "0E9C6EBC082541BE26AC849B2D3F9FB2")
    
private void setAudioGroupMode() {
        AudioGroup audioGroup = getAudioGroup();
        if (audioGroup != null) {
            if (mHold) {
                audioGroup.setMode(AudioGroup.MODE_ON_HOLD);
            } else if (mMuted) {
                audioGroup.setMode(AudioGroup.MODE_MUTED);
            } else if (isSpeakerOn()) {
                audioGroup.setMode(AudioGroup.MODE_ECHO_SUPPRESSION);
            } else {
                audioGroup.setMode(AudioGroup.MODE_NORMAL);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.952 -0500", hash_original_method = "CC3F94229D0F8EEA9220358FBB15354E", hash_generated_method = "CF8959E971F00E833BC56607C43E6869")
    
private void stopCall(boolean releaseSocket) {
        Log.d(TAG, "stop audiocall");
        releaseWifiHighPerfLock();
        if (mAudioStream != null) {
            mAudioStream.join(null);

            if (releaseSocket) {
                mAudioStream.release();
                mAudioStream = null;
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.954 -0500", hash_original_method = "B878A2570A0CCD8ECF14B79C9C36E090", hash_generated_method = "CA7432B876AC7951F9DEED259E1DBA7F")
    
private String getLocalIp() {
        return mSipSession.getLocalIp();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.957 -0500", hash_original_method = "16DFE4C58B2AE1A5BAAA6CDCCC648429", hash_generated_method = "9CCC718C5B190BBFF32579842470FEB4")
    
private void throwSipException(Throwable throwable) throws SipException {
        if (throwable instanceof SipException) {
            throw (SipException) throwable;
        } else {
            throw new SipException("", throwable);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.959 -0500", hash_original_method = "7E510B007B6231BC910990588CC742B2", hash_generated_method = "FDEBF340292A237B489ACC5BDF9B6D51")
    
private SipProfile getPeerProfile(SipSession session) {
        return session.getPeerProfile();
    }
}

