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
    private Context mContext;
    private SipProfile mLocalProfile;
    private SipAudioCall.Listener mListener;
    private SipSession mSipSession;
    private SipSession mTransferringSession;
    private long mSessionId = System.currentTimeMillis();
    private String mPeerSd;
    private AudioStream mAudioStream;
    private AudioGroup mAudioGroup;
    private boolean mInCall = false;
    private boolean mMuted = false;
    private boolean mHold = false;
    private SipProfile mPendingCallRequest;
    private WifiManager mWm;
    private WifiManager.WifiLock mWifiHighPerfLock;
    private int mErrorCode = SipErrorCode.NO_ERROR;
    private String mErrorMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.233 -0400", hash_original_method = "E52D3B9BC90DBBDF3C179757863C5D97", hash_generated_method = "BAA2D5F06EA8CAFE599CBC0B94FF582D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipAudioCall(Context context, SipProfile localProfile) {
        dsTaint.addTaint(localProfile.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        mWm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        // ---------- Original Method ----------
        //mContext = context;
        //mLocalProfile = localProfile;
        //mWm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.234 -0400", hash_original_method = "624C526ACE340C91B4AE00384193A96D", hash_generated_method = "2D8076F55F51622D8D0132C1A121336D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setListener(SipAudioCall.Listener listener) {
        dsTaint.addTaint(listener.dsTaint);
        setListener(listener, false);
        // ---------- Original Method ----------
        //setListener(listener, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.234 -0400", hash_original_method = "7FD2357D0901F6F1D08ACBD882A0FD6F", hash_generated_method = "5875E1E45590391C7F5F1F4E4E7705DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setListener(SipAudioCall.Listener listener,
            boolean callbackImmediately) {
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(callbackImmediately);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.235 -0400", hash_original_method = "5739155C46DD20825CE1C589327CD281", hash_generated_method = "EAE5BA53355E95C6126AD862D9D994CB")
    @DSModeled(DSC.SAFE)
    public boolean isInCall() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mInCall;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.235 -0400", hash_original_method = "2FD69B096455E1B51D801F19A8DBFD35", hash_generated_method = "D440E88E0328630CB098F1C99D5473A3")
    @DSModeled(DSC.SAFE)
    public boolean isOnHold() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mHold;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.235 -0400", hash_original_method = "597B95CEB5AFD05C977FB508D047C50E", hash_generated_method = "21668DF8FDBDBCA1A469227829ADE78B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        close(true);
        // ---------- Original Method ----------
        //close(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.235 -0400", hash_original_method = "AA0DE56AB4C8CE099E885498EC0B29F9", hash_generated_method = "06365FA1D81FBE069D591FFEADE9D272")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void close(boolean closeRtp) {
        dsTaint.addTaint(closeRtp);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.236 -0400", hash_original_method = "A61765ACD427BC1BAFB034CDA7289AED", hash_generated_method = "A53CC4C9F38C10EE9192F04018CC8AE1")
    @DSModeled(DSC.SAFE)
    public SipProfile getLocalProfile() {
        return (SipProfile)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mLocalProfile;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.236 -0400", hash_original_method = "35C9BB243C8C9C83D8B1884AE3FDA6C7", hash_generated_method = "43EF9B3AC752D9A683F0EA3BAD348246")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipProfile getPeerProfile() {
        {
            {
                Object varA5C4FD905C6B717199D021ABF681E09C_520880782 = (mSipSession.getPeerProfile());
            } //End flattened ternary
        } //End block
        return (SipProfile)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return (mSipSession == null) ? null : mSipSession.getPeerProfile();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.236 -0400", hash_original_method = "6859CB7872625AC40861B5EFD6D7E2DC", hash_generated_method = "EDB5DB8C3AA2CE8EA427F127D218B7A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getState() {
        {
            int var7BB3A2E3BA586BA005C2A26D50A17E95_1572755865 = (mSipSession.getState());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mSipSession == null) return SipSession.State.READY_TO_CALL;
            //return mSipSession.getState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.237 -0400", hash_original_method = "9DD9B38A5D2A310FA14C467CD9F0FD11", hash_generated_method = "04B93343F12DCE045320624EE5F2E5FD")
    @DSModeled(DSC.SAFE)
    public SipSession getSipSession() {
        return (SipSession)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mSipSession;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.237 -0400", hash_original_method = "88FD57B0E3684A7BA74DB8405E64F4E3", hash_generated_method = "7E9142EFC3A48EF43498CBCA168E0552")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.244 -0400", hash_original_method = "5E0B84D644E5F5257B7A32D95C62CBE3", hash_generated_method = "196FA0BAF22457942583B4F0D3747534")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SipSession.Listener createListener() {
        SipSession.Listener var404E87923645C9D0A85410B30545F083_930537761 = (new SipSession.Listener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.238 -0400", hash_original_method = "0B4EFC2EA5E0F3FF31D08EEDE61256FC", hash_generated_method = "EAE78CE1EF83F44A72CA5176350C6FAF")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onCalling(SipSession session) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(session.dsTaint);
                Log.d(TAG, "calling... " + session);
                Listener listener;
                listener = mListener;
                {
                    try 
                    {
                        listener.onCalling(SipAudioCall.this);
                    } //End block
                    catch (Throwable t)
                    { }
                } //End block
                // ---------- Original Method ----------
                //Log.d(TAG, "calling... " + session);
                //Listener listener = mListener;
                //if (listener != null) {
                    //try {
                        //listener.onCalling(SipAudioCall.this);
                    //} catch (Throwable t) {
                        //Log.i(TAG, "onCalling(): " + t);
                    //}
                //}
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.238 -0400", hash_original_method = "FA01AFE96119E691A320DB4A08849437", hash_generated_method = "7715FA2C685D13527E77BB55AF4A0795")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onRingingBack(SipSession session) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(session.dsTaint);
                Log.d(TAG, "sip call ringing back: " + session);
                Listener listener;
                listener = mListener;
                {
                    try 
                    {
                        listener.onRingingBack(SipAudioCall.this);
                    } //End block
                    catch (Throwable t)
                    { }
                } //End block
                // ---------- Original Method ----------
                //Log.d(TAG, "sip call ringing back: " + session);
                //Listener listener = mListener;
                //if (listener != null) {
                    //try {
                        //listener.onRingingBack(SipAudioCall.this);
                    //} catch (Throwable t) {
                        //Log.i(TAG, "onRingingBack(): " + t);
                    //}
                //}
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.238 -0400", hash_original_method = "7370CA2F33F803A4BC98509DFD10599B", hash_generated_method = "956B1771838009234614BFF9BF57CB65")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onRinging(SipSession session,
                    SipProfile peerProfile, String sessionDescription) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(session.dsTaint);
                dsTaint.addTaint(sessionDescription);
                dsTaint.addTaint(peerProfile.dsTaint);
                {
                    Object varB1F89F60EBA82B1A17CC5047A6AF7D09_1481743810 = (SipAudioCall.this);
                    {
                        {
                            boolean varA5F8D091711C7601E4F61AE93FF7C992_922178597 = ((mSipSession == null) || !mInCall
                            || !session.getCallId().equals(
                                    mSipSession.getCallId()));
                            {
                                session.endCall();
                            } //End block
                        } //End collapsed parenthetic
                        try 
                        {
                            String answer;
                            answer = createAnswer(sessionDescription).encode();
                            mSipSession.answerCall(answer, SESSION_TIMEOUT);
                        } //End block
                        catch (Throwable e)
                        {
                            session.endCall();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                // ---------- Original Method ----------
                //synchronized (SipAudioCall.this) {
                    //if ((mSipSession == null) || !mInCall
                            //|| !session.getCallId().equals(
                                    //mSipSession.getCallId())) {
                        //session.endCall();
                        //return;
                    //}
                    //try {
                        //String answer = createAnswer(sessionDescription).encode();
                        //mSipSession.answerCall(answer, SESSION_TIMEOUT);
                    //} catch (Throwable e) {
                        //Log.e(TAG, "onRinging()", e);
                        //session.endCall();
                    //}
                //}
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.239 -0400", hash_original_method = "40BF40985539E4127A37E81035B80A7A", hash_generated_method = "3B0A3EFBBF27FDD37013D3E8FD1DE1CB")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onCallEstablished(SipSession session,
                    String sessionDescription) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(session.dsTaint);
                dsTaint.addTaint(sessionDescription);
                mPeerSd = sessionDescription;
                {
                    transferToNewSession();
                } //End block
                Listener listener;
                listener = mListener;
                {
                    try 
                    {
                        {
                            listener.onCallHeld(SipAudioCall.this);
                        } //End block
                        {
                            listener.onCallEstablished(SipAudioCall.this);
                        } //End block
                    } //End block
                    catch (Throwable t)
                    { }
                } //End block
                // ---------- Original Method ----------
                //mPeerSd = sessionDescription;
                //Log.v(TAG, "onCallEstablished()" + mPeerSd);
                //if ((mTransferringSession != null)
                        //&& (session == mTransferringSession)) {
                    //transferToNewSession();
                    //return;
                //}
                //Listener listener = mListener;
                //if (listener != null) {
                    //try {
                        //if (mHold) {
                            //listener.onCallHeld(SipAudioCall.this);
                        //} else {
                            //listener.onCallEstablished(SipAudioCall.this);
                        //}
                    //} catch (Throwable t) {
                        //Log.i(TAG, "onCallEstablished(): " + t);
                    //}
                //}
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.240 -0400", hash_original_method = "1DE904A1CABA70AB1A25A453A4094AFC", hash_generated_method = "7414886A8820B937E145218460FDA71F")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onCallEnded(SipSession session) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(session.dsTaint);
                Log.d(TAG, "sip call ended: " + session + " mSipSession:" + mSipSession);
                {
                    mTransferringSession = null;
                } //End block
                Listener listener;
                listener = mListener;
                {
                    try 
                    {
                        listener.onCallEnded(SipAudioCall.this);
                    } //End block
                    catch (Throwable t)
                    { }
                } //End block
                close();
                // ---------- Original Method ----------
                //Log.d(TAG, "sip call ended: " + session + " mSipSession:" + mSipSession);
                //if (session == mTransferringSession) {
                    //mTransferringSession = null;
                    //return;
                //}
                //if ((mTransferringSession != null) ||
                    //(session != mSipSession)) return;
                //Listener listener = mListener;
                //if (listener != null) {
                    //try {
                        //listener.onCallEnded(SipAudioCall.this);
                    //} catch (Throwable t) {
                        //Log.i(TAG, "onCallEnded(): " + t);
                    //}
                //}
                //close();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.241 -0400", hash_original_method = "3CC4E6D954281F2D5FD31AADF17A6DC9", hash_generated_method = "4785056124CEAF39BD0F08F91BD9BB5F")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onCallBusy(SipSession session) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(session.dsTaint);
                Log.d(TAG, "sip call busy: " + session);
                Listener listener;
                listener = mListener;
                {
                    try 
                    {
                        listener.onCallBusy(SipAudioCall.this);
                    } //End block
                    catch (Throwable t)
                    { }
                } //End block
                close(false);
                // ---------- Original Method ----------
                //Log.d(TAG, "sip call busy: " + session);
                //Listener listener = mListener;
                //if (listener != null) {
                    //try {
                        //listener.onCallBusy(SipAudioCall.this);
                    //} catch (Throwable t) {
                        //Log.i(TAG, "onCallBusy(): " + t);
                    //}
                //}
                //close(false);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.242 -0400", hash_original_method = "16D7065ED36A3B723322ABAA4FB7FA22", hash_generated_method = "DF38FD26D43614EF750627A343A987FC")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onCallChangeFailed(SipSession session, int errorCode,
                    String message) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(message);
                dsTaint.addTaint(session.dsTaint);
                dsTaint.addTaint(errorCode);
                Log.d(TAG, "sip call change failed: " + message);
                mErrorCode = errorCode;
                mErrorMessage = message;
                Listener listener;
                listener = mListener;
                {
                    try 
                    {
                        listener.onError(SipAudioCall.this, mErrorCode,
                                message);
                    } //End block
                    catch (Throwable t)
                    { }
                } //End block
                // ---------- Original Method ----------
                //Log.d(TAG, "sip call change failed: " + message);
                //mErrorCode = errorCode;
                //mErrorMessage = message;
                //Listener listener = mListener;
                //if (listener != null) {
                    //try {
                        //listener.onError(SipAudioCall.this, mErrorCode,
                                //message);
                    //} catch (Throwable t) {
                        //Log.i(TAG, "onCallBusy(): " + t);
                    //}
                //}
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.243 -0400", hash_original_method = "F58D9162CF10989F568AF55ED18D4C89", hash_generated_method = "B11DA1B5AC3C7C8D2954C65B7C709025")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onError(SipSession session, int errorCode,
                    String message) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(message);
                dsTaint.addTaint(session.dsTaint);
                dsTaint.addTaint(errorCode);
                SipAudioCall.this.onError(errorCode, message);
                // ---------- Original Method ----------
                //SipAudioCall.this.onError(errorCode, message);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.243 -0400", hash_original_method = "20558DF6BFC1217A7001B14AA50A9A03", hash_generated_method = "F7182FB22DFE31295F172CE181DF69CE")
            @DSModeled(DSC.SAFE)
            @Override
            public void onRegistering(SipSession session) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(session.dsTaint);
                // ---------- Original Method ----------
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.243 -0400", hash_original_method = "43D598AFE19AB6009363638DB64C1F7B", hash_generated_method = "2F8C8E20FE133528426D427F1677C676")
            @DSModeled(DSC.SAFE)
            @Override
            public void onRegistrationTimeout(SipSession session) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(session.dsTaint);
                // ---------- Original Method ----------
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.243 -0400", hash_original_method = "E69FEDA3BC0AF93EB01ADFD4BE332B13", hash_generated_method = "362A825A0CAC9FD343B33C5EB2DC01E2")
            @DSModeled(DSC.SAFE)
            @Override
            public void onRegistrationFailed(SipSession session, int errorCode,
                    String message) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(message);
                dsTaint.addTaint(session.dsTaint);
                dsTaint.addTaint(errorCode);
                // ---------- Original Method ----------
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.244 -0400", hash_original_method = "7504CEF239C11FEA532F08720FD2042B", hash_generated_method = "9A0EF04CFE05084D1703BC6D9D8F865E")
            @DSModeled(DSC.SAFE)
            @Override
            public void onRegistrationDone(SipSession session, int duration) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(duration);
                dsTaint.addTaint(session.dsTaint);
                // ---------- Original Method ----------
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.244 -0400", hash_original_method = "5F9A92DE1F30C09A899AB4EFC4F87B6D", hash_generated_method = "04A59924F1FFBE2C6C0AAF10363B9158")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onCallTransferring(SipSession newSession,
                    String sessionDescription) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(sessionDescription);
                dsTaint.addTaint(newSession.dsTaint);
                mTransferringSession = newSession;
                try 
                {
                    {
                        newSession.makeCall(newSession.getPeerProfile(),
                                createOffer().encode(), TRANSFER_TIMEOUT);
                    } //End block
                    {
                        String answer;
                        answer = createAnswer(sessionDescription).encode();
                        newSession.answerCall(answer, SESSION_TIMEOUT);
                    } //End block
                } //End block
                catch (Throwable e)
                {
                    newSession.endCall();
                } //End block
                // ---------- Original Method ----------
                //Log.v(TAG, "onCallTransferring mSipSession:"
                        //+ mSipSession + " newSession:" + newSession);
                //mTransferringSession = newSession;
                //try {
                    //if (sessionDescription == null) {
                        //newSession.makeCall(newSession.getPeerProfile(),
                                //createOffer().encode(), TRANSFER_TIMEOUT);
                    //} else {
                        //String answer = createAnswer(sessionDescription).encode();
                        //newSession.answerCall(answer, SESSION_TIMEOUT);
                    //}
                //} catch (Throwable e) {
                    //Log.e(TAG, "onCallTransferring()", e);
                    //newSession.endCall();
                //}
            }
});
        return (SipSession.Listener)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.245 -0400", hash_original_method = "20EC585B752C6E63355D5D35BEA59116", hash_generated_method = "5C2348A0F558F5E6CF97F1839BB73E85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onError(int errorCode, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(errorCode);
        Log.d(TAG, "sip session error: "
                + SipErrorCode.toString(errorCode) + ": " + message);
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
                boolean var064562D536C7718FFB44A98A20F35A97_528196380 = ((errorCode == SipErrorCode.DATA_CONNECTION_LOST)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.246 -0400", hash_original_method = "9D47ECE9B5A5E502049A76A2D5CF7D58", hash_generated_method = "11816BD5DAEE44CC4D6121898BA70959")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void attachCall(SipSession session, String sessionDescription) throws SipException {
        dsTaint.addTaint(session.dsTaint);
        dsTaint.addTaint(sessionDescription);
        {
            boolean var7C2B3BAF12F2B803CD1155B57592C3F4_2011684172 = (!SipManager.isVoipSupported(mContext));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("VOIP API is not supported");
            } //End block
        } //End collapsed parenthetic
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.246 -0400", hash_original_method = "CDFD7E26E80EFA4595D6BD4E5712D0C4", hash_generated_method = "44B7854705F59E9CBC81A8CB8E72ADF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void makeCall(SipProfile peerProfile, SipSession sipSession,
            int timeout) throws SipException {
        dsTaint.addTaint(peerProfile.dsTaint);
        dsTaint.addTaint(sipSession.dsTaint);
        dsTaint.addTaint(timeout);
        {
            boolean var7C2B3BAF12F2B803CD1155B57592C3F4_30046145 = (!SipManager.isVoipSupported(mContext));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("VOIP API is not supported");
            } //End block
        } //End collapsed parenthetic
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.246 -0400", hash_original_method = "DFE2EF72B1133A207E3F57586EB6C6EB", hash_generated_method = "FD6EAFD348EC9F0D54324F4AF9C63DE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.247 -0400", hash_original_method = "83B252D66EF8BD3A5BE285DBF75AA925", hash_generated_method = "6B61C7A3D913A673380D4BADFEBAE00F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void holdCall(int timeout) throws SipException {
        dsTaint.addTaint(timeout);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Not in a call to hold call");
            } //End block
            mSipSession.changeCall(createHoldOffer().encode(), timeout);
            mHold = true;
            setAudioGroupMode();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.247 -0400", hash_original_method = "7A338589242F74847BFE21BB083282FF", hash_generated_method = "C867C3014BF937D0F2EECE34A47CC81F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void answerCall(int timeout) throws SipException {
        dsTaint.addTaint(timeout);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.247 -0400", hash_original_method = "FE14EBF8C515C93259E0563DEA133194", hash_generated_method = "02BBE22FEB990507CCF161069FB202E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void continueCall(int timeout) throws SipException {
        dsTaint.addTaint(timeout);
        {
            mSipSession.changeCall(createContinueOffer().encode(), timeout);
            mHold = false;
            setAudioGroupMode();
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (!mHold) return;
            //mSipSession.changeCall(createContinueOffer().encode(), timeout);
            //mHold = false;
            //setAudioGroupMode();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.258 -0400", hash_original_method = "0D8E98137E8907FA474D9700B196F628", hash_generated_method = "4E7B61CD40800C442CC143871A969DD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SimpleSessionDescription createOffer() {
        SimpleSessionDescription offer;
        offer = new SimpleSessionDescription(mSessionId, getLocalIp());
        AudioCodec[] codecs;
        codecs = AudioCodec.getCodecs();
        Media media;
        media = offer.newMedia(
                "audio", mAudioStream.getLocalPort(), 1, "RTP/AVP");
        {
            Iterator<AudioCodec> var4995EB2E009FA819F0BA5649530B0E18_1853776257 = (AudioCodec.getCodecs()).iterator();
            var4995EB2E009FA819F0BA5649530B0E18_1853776257.hasNext();
            AudioCodec codec = var4995EB2E009FA819F0BA5649530B0E18_1853776257.next();
            {
                media.setRtpPayload(codec.type, codec.rtpmap, codec.fmtp);
            } //End block
        } //End collapsed parenthetic
        media.setRtpPayload(127, "telephone-event/8000", "0-15");
        return (SimpleSessionDescription)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.278 -0400", hash_original_method = "7AC71E8F4C8E41998B13EFBED71D93BD", hash_generated_method = "ABE52BA358FAABDAEBBEA86DD710AC04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SimpleSessionDescription createAnswer(String offerSd) {
        dsTaint.addTaint(offerSd);
        {
            boolean varD57F5D9EDEEED5EBFB37D3EA7E739880_1874526071 = (TextUtils.isEmpty(offerSd));
            SimpleSessionDescription varA136E92E85E49CF874F67935521341ED_116462835 = (createOffer());
        } //End collapsed parenthetic
        SimpleSessionDescription offer;
        offer = new SimpleSessionDescription(offerSd);
        SimpleSessionDescription answer;
        answer = new SimpleSessionDescription(mSessionId, getLocalIp());
        AudioCodec codec;
        codec = null;
        {
            Iterator<Media> var92D5C607FF46DDCEC64602EAAB1497EB_1038263249 = (offer.getMedia()).iterator();
            var92D5C607FF46DDCEC64602EAAB1497EB_1038263249.hasNext();
            Media media = var92D5C607FF46DDCEC64602EAAB1497EB_1038263249.next();
            {
                {
                    boolean var2DE1D53623224D4AB7ECC9712B740291_987596534 = ((codec == null) && (media.getPort() > 0)
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
                                        boolean varCB957CD13AB208B86C56E8825962C086_1317354754 = ((type != codec.type) && (rtpmap != null)
                                && rtpmap.startsWith("telephone-event"));
                                        {
                                            reply.setRtpPayload(
                                    type, rtpmap, media.getFmtp(type));
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                            {
                                boolean var1A79B2A4B05C87BBB8B68D2C2016DC16_1855438946 = (media.getAttribute("recvonly") != null);
                                {
                                    answer.setAttribute("sendonly", "");
                                } //End block
                                {
                                    boolean varB3F7193C3333B0079507F79363D4A8B4_1991494217 = (media.getAttribute("sendonly") != null);
                                    {
                                        answer.setAttribute("recvonly", "");
                                    } //End block
                                    {
                                        boolean varB5C9A82246237C19E1097CE6E5634727_1015915248 = (offer.getAttribute("recvonly") != null);
                                        {
                                            answer.setAttribute("sendonly", "");
                                        } //End block
                                        {
                                            boolean var6DC296E0183F0D6A7813976666F92608_1969784946 = (offer.getAttribute("sendonly") != null);
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
        return (SimpleSessionDescription)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.279 -0400", hash_original_method = "B99EA71C05B29A1F5EF342AB2FDD525C", hash_generated_method = "085EC568C6258D8BC85299B493222829")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SimpleSessionDescription createHoldOffer() {
        SimpleSessionDescription offer;
        offer = createContinueOffer();
        offer.setAttribute("sendonly", "");
        return (SimpleSessionDescription)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SimpleSessionDescription offer = createContinueOffer();
        //offer.setAttribute("sendonly", "");
        //return offer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.279 -0400", hash_original_method = "71EB52827AB306B4A3579086FF868817", hash_generated_method = "0D9980B11B7B18F34139252C1A3E422C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SimpleSessionDescription createContinueOffer() {
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
        return (SimpleSessionDescription)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.279 -0400", hash_original_method = "9511FA94EBBE4D902AF961AAA5743C5F", hash_generated_method = "1678A407CDD83AD87374506DBEA7F6F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.280 -0400", hash_original_method = "94C077E9D4A3B70D9C34E2292E80901C", hash_generated_method = "8F7F811C1A6F870FF7B54E76DC4FE6D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.280 -0400", hash_original_method = "FC1EDAFB978C2E10313819704C8134E2", hash_generated_method = "68B0DE4649CE8781570D6E00E886C930")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isWifiOn() {
        {
            boolean varA39A642AAD196AE2FD89489CCF53E246_1634114470 = ((mWm.getConnectionInfo().getBSSID() == null));
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mWm.getConnectionInfo().getBSSID() == null) ? false : true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.280 -0400", hash_original_method = "91407CCBE269ED4E5C3C36CDEC2695DD", hash_generated_method = "6BCC9B5174D08C2ED8FA25D85C24B9D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.280 -0400", hash_original_method = "CF2F318ECC83A27F31B207A7653E2463", hash_generated_method = "DF8D3F4EB324FC6F70E5415DB5A57610")
    @DSModeled(DSC.SAFE)
    public boolean isMuted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mMuted;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.281 -0400", hash_original_method = "8238959D9236D29164DC3B2B6875AEBE", hash_generated_method = "B2549FB44C7A9B7EED54BBA75AB02F32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSpeakerMode(boolean speakerMode) {
        dsTaint.addTaint(speakerMode);
        {
            ((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                    .setSpeakerphoneOn(speakerMode);
            setAudioGroupMode();
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                    //.setSpeakerphoneOn(speakerMode);
            //setAudioGroupMode();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.281 -0400", hash_original_method = "1B6C9A8A7DE7A949D0CD2E188D6FBBDC", hash_generated_method = "20F2356EED9A16DD4E75817BCD483130")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isSpeakerOn() {
        boolean varB3D6950D5F301C704C02A4854CB7D217_826621884 = (((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                .isSpeakerphoneOn());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                //.isSpeakerphoneOn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.281 -0400", hash_original_method = "5FC4A2324FC6DD99D16BF2BD98355D7B", hash_generated_method = "C8D7FF2A2AD2704CD0086DEB6C62D153")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendDtmf(int code) {
        dsTaint.addTaint(code);
        sendDtmf(code, null);
        // ---------- Original Method ----------
        //sendDtmf(code, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.282 -0400", hash_original_method = "7A09CE165EA90677044F14874DA9275F", hash_generated_method = "DC89B8989710D45740E6E33CA917269E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendDtmf(int code, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(code);
        {
            AudioGroup audioGroup;
            audioGroup = getAudioGroup();
            {
                boolean var40B0A392B41D3543A13A1EBA207462F2_1326896379 = ((audioGroup != null) && (mSipSession != null)
                    && (SipSession.State.IN_CALL == getState()));
                {
                    audioGroup.sendDtmf(code);
                } //End block
            } //End collapsed parenthetic
            result.sendToTarget();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.282 -0400", hash_original_method = "974213146461E5146ED1F54CFC83DFBA", hash_generated_method = "4440A397BC07D187C1FAC670B5199691")
    @DSModeled(DSC.SAFE)
    public AudioStream getAudioStream() {
        return (AudioStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mAudioStream;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.282 -0400", hash_original_method = "BB542D10B17F9F4E162984482435ECE8", hash_generated_method = "3F8B7FE5F36FD2A746A9CBB7AE9DC0F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AudioGroup getAudioGroup() {
        {
            AudioGroup varA11A6F5AC85B01AA4ED6F0AC85B2A1FA_1287311110 = (((mAudioStream == null) ? null : mAudioStream.getGroup())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        } //End block
        return (AudioGroup)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mAudioGroup != null) return mAudioGroup;
            //return ((mAudioStream == null) ? null : mAudioStream.getGroup());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.283 -0400", hash_original_method = "59C2E1D195E6E28B792310EB7C59BD4B", hash_generated_method = "FAB62BB92E8C72AE2CB10BFE37E255B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAudioGroup(AudioGroup group) {
        dsTaint.addTaint(group.dsTaint);
        {
            {
                boolean varBF4F994E1BAFD5371D1A8FD1902D3F31_39517936 = ((mAudioStream != null) && (mAudioStream.getGroup() != null));
                {
                    mAudioStream.join(group);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if ((mAudioStream != null) && (mAudioStream.getGroup() != null)) {
                //mAudioStream.join(group);
            //}
            //mAudioGroup = group;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.283 -0400", hash_original_method = "4F615D2FF52BC5640F885A620AAE1B91", hash_generated_method = "ED5FF7F74B4910A94D893D435B061A8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.306 -0400", hash_original_method = "29EB701080CA01C59CC1BB8E207AC1D7", hash_generated_method = "F07200E133C201C5D4D5F7EB8DCAAAD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
            Iterator<Media> var92D5C607FF46DDCEC64602EAAB1497EB_92613533 = (offer.getMedia()).iterator();
            var92D5C607FF46DDCEC64602EAAB1497EB_92613533.hasNext();
            Media media = var92D5C607FF46DDCEC64602EAAB1497EB_92613533.next();
            {
                {
                    boolean var2DE1D53623224D4AB7ECC9712B740291_226247897 = ((codec == null) && (media.getPort() > 0)
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
                                        boolean varCB957CD13AB208B86C56E8825962C086_59161957 = ((type != codec.type) && (rtpmap != null)
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
                                boolean var1A79B2A4B05C87BBB8B68D2C2016DC16_1414685701 = (media.getAttribute("recvonly") != null);
                                {
                                    stream.setMode(RtpStream.MODE_SEND_ONLY);
                                } //End block
                                {
                                    boolean varB3F7193C3333B0079507F79363D4A8B4_1826102670 = (media.getAttribute("sendonly") != null);
                                    {
                                        stream.setMode(RtpStream.MODE_RECEIVE_ONLY);
                                    } //End block
                                    {
                                        boolean varB5C9A82246237C19E1097CE6E5634727_358453499 = (offer.getAttribute("recvonly") != null);
                                        {
                                            stream.setMode(RtpStream.MODE_SEND_ONLY);
                                        } //End block
                                        {
                                            boolean var6DC296E0183F0D6A7813976666F92608_1309380328 = (offer.getAttribute("sendonly") != null);
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
            boolean var79EFADA71B0A2CB2BF111DF46116166C_2062471711 = (isWifiOn());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.307 -0400", hash_original_method = "1498B4B4889D09E5AF0E80BDDCC19CDB", hash_generated_method = "82FC49E59032F98FFA2FE3A685BD86AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                boolean var2602BD244D0DEA007155D10632BD8565_1088869530 = (isSpeakerOn());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.307 -0400", hash_original_method = "CC3F94229D0F8EEA9220358FBB15354E", hash_generated_method = "77082348E12045BA10ABF16EDBCEC16A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void stopCall(boolean releaseSocket) {
        dsTaint.addTaint(releaseSocket);
        Log.d(TAG, "stop audiocall");
        releaseWifiHighPerfLock();
        {
            mAudioStream.join(null);
            {
                mAudioStream.release();
                mAudioStream = null;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.307 -0400", hash_original_method = "B878A2570A0CCD8ECF14B79C9C36E090", hash_generated_method = "656AD0A52E672C9C49A8E212FFBB25D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getLocalIp() {
        String varDA2CC7D277531035CDB2AE11E0D5B541_1911769943 = (mSipSession.getLocalIp());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSipSession.getLocalIp();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.308 -0400", hash_original_method = "16DFE4C58B2AE1A5BAAA6CDCCC648429", hash_generated_method = "B1429DC1AA9E41B6DFF2E315E887DBA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void throwSipException(Throwable throwable) throws SipException {
        dsTaint.addTaint(throwable.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw (SipException) throwable;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("", throwable);
        } //End block
        // ---------- Original Method ----------
        //if (throwable instanceof SipException) {
            //throw (SipException) throwable;
        //} else {
            //throw new SipException("", throwable);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.308 -0400", hash_original_method = "7E510B007B6231BC910990588CC742B2", hash_generated_method = "83B70A09433777A42FC46AB68E8DF992")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SipProfile getPeerProfile(SipSession session) {
        dsTaint.addTaint(session.dsTaint);
        SipProfile varAEF56ACA525EA7DF3332987597D1E156_654091371 = (session.getPeerProfile());
        return (SipProfile)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return session.getPeerProfile();
    }

    
    public static class Listener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.308 -0400", hash_original_method = "926C6F0FEA0BD66B8F2ADD2E3C0DFCB9", hash_generated_method = "926C6F0FEA0BD66B8F2ADD2E3C0DFCB9")
                public Listener ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.308 -0400", hash_original_method = "1692051440F2E30BB9552F9991C2F337", hash_generated_method = "7FBF5BE75BDBFEC107A6019A6F8DF8AB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onReadyToCall(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(call.dsTaint);
            onChanged(call);
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.308 -0400", hash_original_method = "F61EC18A6F9190266BB417D94187D91F", hash_generated_method = "2AC7189746E9A4DEAC54523A0EA4F5DB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onCalling(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(call.dsTaint);
            onChanged(call);
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.309 -0400", hash_original_method = "80FA944D90A47A92553C0DDAF9805E5E", hash_generated_method = "37D74FA17B89E1269B5261262E466199")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onRinging(SipAudioCall call, SipProfile caller) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(caller.dsTaint);
            dsTaint.addTaint(call.dsTaint);
            onChanged(call);
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.309 -0400", hash_original_method = "F638A746C099264E58AA2EF34946D274", hash_generated_method = "0C45C2585A217DF9D01424B3B8E11E73")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onRingingBack(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(call.dsTaint);
            onChanged(call);
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.309 -0400", hash_original_method = "ED0948473C3573D4349DE4B81266B2ED", hash_generated_method = "D49401B1DA5C92963D6B3FF440821413")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onCallEstablished(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(call.dsTaint);
            onChanged(call);
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.310 -0400", hash_original_method = "87752713DF39DD8F370DBCB68CD08A8A", hash_generated_method = "94109A0F89D16E42A86ADB0A675EA6CA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onCallEnded(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(call.dsTaint);
            onChanged(call);
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.310 -0400", hash_original_method = "A1C8D07F76B181730B1462483C996C45", hash_generated_method = "2D238233B1822DDAAF3E552C169EAFC7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onCallBusy(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(call.dsTaint);
            onChanged(call);
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.310 -0400", hash_original_method = "901B34C07D0BCB3C3E5EC60CF9AA74AD", hash_generated_method = "6A5951C7DBFF29353805C36A82CAFA5C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onCallHeld(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(call.dsTaint);
            onChanged(call);
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.310 -0400", hash_original_method = "43C9D48E22A0172861A5C1A464B2052F", hash_generated_method = "D07206C886E49C4240DFB7343283129F")
        @DSModeled(DSC.SAFE)
        public void onError(SipAudioCall call, int errorCode,
                String errorMessage) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(errorMessage);
            dsTaint.addTaint(call.dsTaint);
            dsTaint.addTaint(errorCode);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.311 -0400", hash_original_method = "06CD8F9D0FA40D0750F021E4FF896790", hash_generated_method = "DEF1FAB57D937757CA7759B88D2874FD")
        @DSModeled(DSC.SAFE)
        public void onChanged(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(call.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    private static final String TAG = SipAudioCall.class.getSimpleName();
    private static final boolean RELEASE_SOCKET = true;
    private static final boolean DONT_RELEASE_SOCKET = false;
    private static final int SESSION_TIMEOUT = 5;
    private static final int TRANSFER_TIMEOUT = 15;
}

