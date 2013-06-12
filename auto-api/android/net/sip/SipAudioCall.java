package android.net.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final String TAG = SipAudioCall.class.getSimpleName();
    private static final boolean RELEASE_SOCKET = true;
    private static final boolean DONT_RELEASE_SOCKET = false;
    private static final int SESSION_TIMEOUT = 5;
    private static final int TRANSFER_TIMEOUT = 15;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.313 -0400", hash_original_method = "E52D3B9BC90DBBDF3C179757863C5D97", hash_generated_method = "0828D03282740EC73388B351356C7301")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipAudioCall(Context context, SipProfile localProfile) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(localProfile.dsTaint);
        mWm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        // ---------- Original Method ----------
        //mContext = context;
        //mLocalProfile = localProfile;
        //mWm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.313 -0400", hash_original_method = "624C526ACE340C91B4AE00384193A96D", hash_generated_method = "A65D49DD85852510496364169DE50805")
    @DSModeled(DSC.SAFE)
    public void setListener(SipAudioCall.Listener listener) {
        dsTaint.addTaint(listener.dsTaint);
        setListener(listener, false);
        // ---------- Original Method ----------
        //setListener(listener, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.314 -0400", hash_original_method = "7FD2357D0901F6F1D08ACBD882A0FD6F", hash_generated_method = "A431048ADFEEB3C70BAB03E42E8F1EAE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.314 -0400", hash_original_method = "5739155C46DD20825CE1C589327CD281", hash_generated_method = "4C6CF703FC217C2A1C8EA511F5CC9236")
    @DSModeled(DSC.SAFE)
    public boolean isInCall() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mInCall;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.314 -0400", hash_original_method = "2FD69B096455E1B51D801F19A8DBFD35", hash_generated_method = "DF32EDF88F8BC8772BEC4309D2AD7628")
    @DSModeled(DSC.SAFE)
    public boolean isOnHold() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mHold;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.314 -0400", hash_original_method = "597B95CEB5AFD05C977FB508D047C50E", hash_generated_method = "A4457C768D2DAB5B8F0A10B78F58C99E")
    @DSModeled(DSC.SAFE)
    public void close() {
        close(true);
        // ---------- Original Method ----------
        //close(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.314 -0400", hash_original_method = "AA0DE56AB4C8CE099E885498EC0B29F9", hash_generated_method = "4DC08FD784A9CD2E6B206A3A392263D4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.314 -0400", hash_original_method = "A61765ACD427BC1BAFB034CDA7289AED", hash_generated_method = "EE008804A68286B73F313E8344DA5FB9")
    @DSModeled(DSC.SAFE)
    public SipProfile getLocalProfile() {
        return (SipProfile)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mLocalProfile;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.314 -0400", hash_original_method = "35C9BB243C8C9C83D8B1884AE3FDA6C7", hash_generated_method = "9F4F24D6ED944A77309ED48F20543AFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipProfile getPeerProfile() {
        {
            {
                Object varA5C4FD905C6B717199D021ABF681E09C_1938492236 = (mSipSession.getPeerProfile());
            } //End flattened ternary
        } //End block
        return (SipProfile)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return (mSipSession == null) ? null : mSipSession.getPeerProfile();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.315 -0400", hash_original_method = "6859CB7872625AC40861B5EFD6D7E2DC", hash_generated_method = "4CA0E24DE15F757CB8FC72E55455BCD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getState() {
        {
            int var7BB3A2E3BA586BA005C2A26D50A17E95_1238175405 = (mSipSession.getState());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mSipSession == null) return SipSession.State.READY_TO_CALL;
            //return mSipSession.getState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.315 -0400", hash_original_method = "9DD9B38A5D2A310FA14C467CD9F0FD11", hash_generated_method = "F99E309E219A7A4E5047A8528D971C14")
    @DSModeled(DSC.SAFE)
    public SipSession getSipSession() {
        return (SipSession)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mSipSession;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.315 -0400", hash_original_method = "88FD57B0E3684A7BA74DB8405E64F4E3", hash_generated_method = "6EE76D2923A2A56955E43DEC581233B9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.315 -0400", hash_original_method = "5E0B84D644E5F5257B7A32D95C62CBE3", hash_generated_method = "AC4CE9195CA3B29C0398BD260DBB1409")
    @DSModeled(DSC.SAFE)
    private SipSession.Listener createListener() {
        return (SipSession.Listener)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.316 -0400", hash_original_method = "20EC585B752C6E63355D5D35BEA59116", hash_generated_method = "D9FFDB76977ECF9167279784F2155B70")
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
                boolean var064562D536C7718FFB44A98A20F35A97_721862667 = ((errorCode == SipErrorCode.DATA_CONNECTION_LOST)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.316 -0400", hash_original_method = "9D47ECE9B5A5E502049A76A2D5CF7D58", hash_generated_method = "17A5C4299B564B14B7C1C19DA589D0EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void attachCall(SipSession session, String sessionDescription) throws SipException {
        dsTaint.addTaint(session.dsTaint);
        dsTaint.addTaint(sessionDescription);
        {
            boolean var7C2B3BAF12F2B803CD1155B57592C3F4_786130934 = (!SipManager.isVoipSupported(mContext));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.316 -0400", hash_original_method = "CDFD7E26E80EFA4595D6BD4E5712D0C4", hash_generated_method = "693874EFAF0B6E53D0DB470B2BBB16EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void makeCall(SipProfile peerProfile, SipSession sipSession,
            int timeout) throws SipException {
        dsTaint.addTaint(peerProfile.dsTaint);
        dsTaint.addTaint(sipSession.dsTaint);
        dsTaint.addTaint(timeout);
        {
            boolean var7C2B3BAF12F2B803CD1155B57592C3F4_56689602 = (!SipManager.isVoipSupported(mContext));
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
                throw new SipException("makeCall()", e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.316 -0400", hash_original_method = "DFE2EF72B1133A207E3F57586EB6C6EB", hash_generated_method = "64AC15B715818E612545873A9CE2F8C2")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.316 -0400", hash_original_method = "83B252D66EF8BD3A5BE285DBF75AA925", hash_generated_method = "F1EF70BE40372B91E8DB15513D4C910B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void holdCall(int timeout) throws SipException {
        dsTaint.addTaint(timeout);
        {
        	 mSipSession.changeCall(createHoldOffer().encode(), timeout);
             mHold = true;
             setAudioGroupMode();
            {
                throw new SipException("Not in a call to hold call");
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.317 -0400", hash_original_method = "7A338589242F74847BFE21BB083282FF", hash_generated_method = "377C2F483BFA5B53169BDF3C0869D06B")
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
                throw new SipException("answerCall()", e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.317 -0400", hash_original_method = "FE14EBF8C515C93259E0563DEA133194", hash_generated_method = "FBED913E25E32E8E5F83891CB91700B2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.317 -0400", hash_original_method = "0D8E98137E8907FA474D9700B196F628", hash_generated_method = "A226F1B640CD97CAD19EB8D37E9CD2A2")
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
            AudioCodec codec = AudioCodec.getCodecs()[0];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.318 -0400", hash_original_method = "7AC71E8F4C8E41998B13EFBED71D93BD", hash_generated_method = "398D0D2EA07E03A63EE4481A06B7E796")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SimpleSessionDescription createAnswer(String offerSd) {
        dsTaint.addTaint(offerSd);
        {
            boolean varD57F5D9EDEEED5EBFB37D3EA7E739880_1868803968 = (TextUtils.isEmpty(offerSd));
            SimpleSessionDescription varA136E92E85E49CF874F67935521341ED_404737317 = (createOffer());
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
                    boolean var2DE1D53623224D4AB7ECC9712B740291_1763570943 = ((codec == null) && (media.getPort() > 0)
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
                                        boolean varCB957CD13AB208B86C56E8825962C086_1310545511 = ((type != codec.type) && (rtpmap != null)
                                && rtpmap.startsWith("telephone-event"));
                                        {
                                            reply.setRtpPayload(
                                    type, rtpmap, media.getFmtp(type));
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                            {
                                boolean var1A79B2A4B05C87BBB8B68D2C2016DC16_531973355 = (media.getAttribute("recvonly") != null);
                                {
                                    answer.setAttribute("sendonly", "");
                                } //End block
                                {
                                    boolean varB3F7193C3333B0079507F79363D4A8B4_1147023982 = (media.getAttribute("sendonly") != null);
                                    {
                                        answer.setAttribute("recvonly", "");
                                    } //End block
                                    {
                                        boolean varB5C9A82246237C19E1097CE6E5634727_883918475 = (offer.getAttribute("recvonly") != null);
                                        {
                                            answer.setAttribute("sendonly", "");
                                        } //End block
                                        {
                                            boolean var6DC296E0183F0D6A7813976666F92608_1881849537 = (offer.getAttribute("sendonly") != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.318 -0400", hash_original_method = "B99EA71C05B29A1F5EF342AB2FDD525C", hash_generated_method = "49C35D4DB9CC34E00092610C04AE3681")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.318 -0400", hash_original_method = "71EB52827AB306B4A3579086FF868817", hash_generated_method = "E656F4956C5D0CC15AEB05A7145E145C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.318 -0400", hash_original_method = "9511FA94EBBE4D902AF961AAA5743C5F", hash_generated_method = "2A2ECB439E91FD6E736B263974975E40")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.318 -0400", hash_original_method = "94C077E9D4A3B70D9C34E2292E80901C", hash_generated_method = "CA63550A8E58A776E485CA19A1C8E315")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.319 -0400", hash_original_method = "FC1EDAFB978C2E10313819704C8134E2", hash_generated_method = "68A902E8912628E6294E617411B6990C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isWifiOn() {
        {
            boolean varA39A642AAD196AE2FD89489CCF53E246_1973582614 = ((mWm.getConnectionInfo().getBSSID() == null));
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mWm.getConnectionInfo().getBSSID() == null) ? false : true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.319 -0400", hash_original_method = "91407CCBE269ED4E5C3C36CDEC2695DD", hash_generated_method = "A716E6094A4A7B5CD8A35D65CF469377")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.319 -0400", hash_original_method = "CF2F318ECC83A27F31B207A7653E2463", hash_generated_method = "97CAC69E3B3AAF1CF2D2A7185E8AFC61")
    @DSModeled(DSC.SAFE)
    public boolean isMuted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mMuted;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.319 -0400", hash_original_method = "8238959D9236D29164DC3B2B6875AEBE", hash_generated_method = "F1C897E7674EF3F231F5345B51628997")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.319 -0400", hash_original_method = "1B6C9A8A7DE7A949D0CD2E188D6FBBDC", hash_generated_method = "D0F579FAEC623485544524A2328986EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isSpeakerOn() {
        boolean varB3D6950D5F301C704C02A4854CB7D217_353567852 = (((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                .isSpeakerphoneOn());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE))
                //.isSpeakerphoneOn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.319 -0400", hash_original_method = "5FC4A2324FC6DD99D16BF2BD98355D7B", hash_generated_method = "E1DFAA5624D8106B2D6432ED83EBC1A3")
    @DSModeled(DSC.SAFE)
    public void sendDtmf(int code) {
        dsTaint.addTaint(code);
        sendDtmf(code, null);
        // ---------- Original Method ----------
        //sendDtmf(code, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.319 -0400", hash_original_method = "7A09CE165EA90677044F14874DA9275F", hash_generated_method = "C5D725030E855FB39DCF2B562658908F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendDtmf(int code, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(code);
        {
            AudioGroup audioGroup;
            audioGroup = getAudioGroup();
            {
                boolean var40B0A392B41D3543A13A1EBA207462F2_1208033120 = ((audioGroup != null) && (mSipSession != null)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.320 -0400", hash_original_method = "974213146461E5146ED1F54CFC83DFBA", hash_generated_method = "24DCAAAC1E869B272E0D86675AADCA0C")
    @DSModeled(DSC.SAFE)
    public AudioStream getAudioStream() {
        return (AudioStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mAudioStream;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.320 -0400", hash_original_method = "BB542D10B17F9F4E162984482435ECE8", hash_generated_method = "A7CEAE69637D8A0F9E8917F4725B6AA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AudioGroup getAudioGroup() {
        {
            AudioGroup varA11A6F5AC85B01AA4ED6F0AC85B2A1FA_984069308 = (((mAudioStream == null) ? null : mAudioStream.getGroup())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        } //End block
        return (AudioGroup)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mAudioGroup != null) return mAudioGroup;
            //return ((mAudioStream == null) ? null : mAudioStream.getGroup());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.320 -0400", hash_original_method = "59C2E1D195E6E28B792310EB7C59BD4B", hash_generated_method = "6A995D2DF6698B53F266F35FAD9A7D6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAudioGroup(AudioGroup group) {
        dsTaint.addTaint(group.dsTaint);
        {
            {
                boolean varBF4F994E1BAFD5371D1A8FD1902D3F31_1123599040 = ((mAudioStream != null) && (mAudioStream.getGroup() != null));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.320 -0400", hash_original_method = "4F615D2FF52BC5640F885A620AAE1B91", hash_generated_method = "D4B916BDA70B127630BC0D70AE94911D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.321 -0400", hash_original_method = "29EB701080CA01C59CC1BB8E207AC1D7", hash_generated_method = "34F210C654F6900BB8C4DF6E1F9A68C1")
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
            Media media = offer.getMedia()[0];
            {
                {
                    boolean var2DE1D53623224D4AB7ECC9712B740291_967505107 = ((codec == null) && (media.getPort() > 0)
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
                                        boolean varCB957CD13AB208B86C56E8825962C086_58439944 = ((type != codec.type) && (rtpmap != null)
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
                                boolean var1A79B2A4B05C87BBB8B68D2C2016DC16_808937975 = (media.getAttribute("recvonly") != null);
                                {
                                    stream.setMode(RtpStream.MODE_SEND_ONLY);
                                } //End block
                                {
                                    boolean varB3F7193C3333B0079507F79363D4A8B4_1025420889 = (media.getAttribute("sendonly") != null);
                                    {
                                        stream.setMode(RtpStream.MODE_RECEIVE_ONLY);
                                    } //End block
                                    {
                                        boolean varB5C9A82246237C19E1097CE6E5634727_858853897 = (offer.getAttribute("recvonly") != null);
                                        {
                                            stream.setMode(RtpStream.MODE_SEND_ONLY);
                                        } //End block
                                        {
                                            boolean var6DC296E0183F0D6A7813976666F92608_1206644560 = (offer.getAttribute("sendonly") != null);
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
            boolean var79EFADA71B0A2CB2BF111DF46116166C_219312072 = (isWifiOn());
            grabWifiHighPerfLock();
        } //End collapsed parenthetic
        AudioGroup audioGroup;
        audioGroup = getAudioGroup();
        {
            audioGroup = new AudioGroup();
            stream.join(audioGroup);
        } //End block
        setAudioGroupMode();
        {
            throw new IllegalStateException("Reject SDP: no suitable codecs");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.321 -0400", hash_original_method = "1498B4B4889D09E5AF0E80BDDCC19CDB", hash_generated_method = "1269B0893F17B35BF031FD90BF36F8CC")
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
                boolean var2602BD244D0DEA007155D10632BD8565_1311848414 = (isSpeakerOn());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.321 -0400", hash_original_method = "CC3F94229D0F8EEA9220358FBB15354E", hash_generated_method = "89FAC8A6E876C354A91A181DEA0CE0A0")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.321 -0400", hash_original_method = "B878A2570A0CCD8ECF14B79C9C36E090", hash_generated_method = "F4F946131EFCC4CAA16AB1668CD8CAA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getLocalIp() {
        String varDA2CC7D277531035CDB2AE11E0D5B541_1373565585 = (mSipSession.getLocalIp());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSipSession.getLocalIp();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.321 -0400", hash_original_method = "16DFE4C58B2AE1A5BAAA6CDCCC648429", hash_generated_method = "E34F37B59FFD060DFF2CC0E72BDB4274")
    @DSModeled(DSC.SAFE)
    private void throwSipException(Throwable throwable) throws SipException {
        dsTaint.addTaint(throwable.dsTaint);
        {
        	if (DroidSafeAndroidRuntime.control) throw (SipException) throwable;
        } //End block
        {
            throw new SipException("", throwable);
        } //End block
        // ---------- Original Method ----------
        //if (throwable instanceof SipException) {
            //throw (SipException) throwable;
        //} else {
            //throw new SipException("", throwable);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.321 -0400", hash_original_method = "7E510B007B6231BC910990588CC742B2", hash_generated_method = "0846C28BD2D018D021BC4192D935EFCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SipProfile getPeerProfile(SipSession session) {
        dsTaint.addTaint(session.dsTaint);
        SipProfile varAEF56ACA525EA7DF3332987597D1E156_445339923 = (session.getPeerProfile());
        return (SipProfile)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return session.getPeerProfile();
    }

    
    public static class Listener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.322 -0400", hash_original_method = "1692051440F2E30BB9552F9991C2F337", hash_generated_method = "4A3BC79AC12A6E29CB5CD10BF49FCA80")
        @DSModeled(DSC.SAFE)
        public void onReadyToCall(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(call.dsTaint);
            onChanged(call);
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.322 -0400", hash_original_method = "F61EC18A6F9190266BB417D94187D91F", hash_generated_method = "AEEE6489BB09E1F94F2FC884CFC84613")
        @DSModeled(DSC.SAFE)
        public void onCalling(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(call.dsTaint);
            onChanged(call);
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.322 -0400", hash_original_method = "80FA944D90A47A92553C0DDAF9805E5E", hash_generated_method = "CDA0E93184ABE9DFCF5ACF7ABAD21EB0")
        @DSModeled(DSC.SAFE)
        public void onRinging(SipAudioCall call, SipProfile caller) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(caller.dsTaint);
            dsTaint.addTaint(call.dsTaint);
            onChanged(call);
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.322 -0400", hash_original_method = "F638A746C099264E58AA2EF34946D274", hash_generated_method = "6B78BB9424D887BBB6BA1A1107AFDE1D")
        @DSModeled(DSC.SAFE)
        public void onRingingBack(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(call.dsTaint);
            onChanged(call);
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.322 -0400", hash_original_method = "ED0948473C3573D4349DE4B81266B2ED", hash_generated_method = "2A4DAD857ECB056428A3E56DF2966C7A")
        @DSModeled(DSC.SAFE)
        public void onCallEstablished(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(call.dsTaint);
            onChanged(call);
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.322 -0400", hash_original_method = "87752713DF39DD8F370DBCB68CD08A8A", hash_generated_method = "87BDF398C0E6098A9BDC878EC4422A79")
        @DSModeled(DSC.SAFE)
        public void onCallEnded(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(call.dsTaint);
            onChanged(call);
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.322 -0400", hash_original_method = "A1C8D07F76B181730B1462483C996C45", hash_generated_method = "A3707467146B388696D75713A6E8BDE7")
        @DSModeled(DSC.SAFE)
        public void onCallBusy(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(call.dsTaint);
            onChanged(call);
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.322 -0400", hash_original_method = "901B34C07D0BCB3C3E5EC60CF9AA74AD", hash_generated_method = "8BB815FC511188042A5B4DE6759CA0D8")
        @DSModeled(DSC.SAFE)
        public void onCallHeld(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(call.dsTaint);
            onChanged(call);
            // ---------- Original Method ----------
            //onChanged(call);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.322 -0400", hash_original_method = "43C9D48E22A0172861A5C1A464B2052F", hash_generated_method = "1782C72C3BAA4681F921BCF0565D9EF1")
        @DSModeled(DSC.SAFE)
        public void onError(SipAudioCall call, int errorCode,
                String errorMessage) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(errorMessage);
            dsTaint.addTaint(call.dsTaint);
            dsTaint.addTaint(errorCode);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.323 -0400", hash_original_method = "06CD8F9D0FA40D0750F021E4FF896790", hash_generated_method = "6F3BC3ECE656280BE101FC02C2143F9B")
        @DSModeled(DSC.SAFE)
        public void onChanged(SipAudioCall call) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(call.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
}


