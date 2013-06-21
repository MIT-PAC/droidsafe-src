package android.net.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import java.text.ParseException;

public class SipManager {
    private ISipService mSipService;
    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.343 -0400", hash_original_method = "C37128DE517781FF4AF379CF096D6229", hash_generated_method = "D1EEBC93C00B56C57E4EBD15077EC09D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SipManager(Context context) {
        dsTaint.addTaint(context.dsTaint);
        createSipService();
        // ---------- Original Method ----------
        //mContext = context;
        //createSipService();
    }

    
        public static SipManager newInstance(Context context) {
        return (isApiSupported(context) ? new SipManager(context) : null);
    }

    
        public static boolean isApiSupported(Context context) {
        return context.getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_SIP);
    }

    
        public static boolean isVoipSupported(Context context) {
        return context.getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_SIP_VOIP) && isApiSupported(context);
    }

    
        public static boolean isSipWifiOnly(Context context) {
        return context.getResources().getBoolean(
                com.android.internal.R.bool.config_sip_wifi_only);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.344 -0400", hash_original_method = "78D0C1947CAE04BC8743510E34683CF6", hash_generated_method = "B081FD4C8C748236BBD7E49FB2231647")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void createSipService() {
        IBinder b;
        b = ServiceManager.getService(Context.SIP_SERVICE);
        mSipService = ISipService.Stub.asInterface(b);
        // ---------- Original Method ----------
        //IBinder b = ServiceManager.getService(Context.SIP_SERVICE);
        //mSipService = ISipService.Stub.asInterface(b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.344 -0400", hash_original_method = "52C02C16281ED39358E05D7A6D2BF025", hash_generated_method = "19AB165953F6889037EED263688CAC25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void open(SipProfile localProfile) throws SipException {
        dsTaint.addTaint(localProfile.dsTaint);
        try 
        {
            mSipService.open(localProfile);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("open()", e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mSipService.open(localProfile);
        //} catch (RemoteException e) {
            //throw new SipException("open()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.344 -0400", hash_original_method = "BDC8C921966B306282AD779760136C05", hash_generated_method = "03C8F1E7A0DF46FB632BDF87E55BAC88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void open(SipProfile localProfile,
            PendingIntent incomingCallPendingIntent,
            SipRegistrationListener listener) throws SipException {
        dsTaint.addTaint(incomingCallPendingIntent.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(localProfile.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "incomingCallPendingIntent cannot be null");
        } //End block
        try 
        {
            mSipService.open3(localProfile, incomingCallPendingIntent,
                    createRelay(listener, localProfile.getUriString()));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("open()", e);
        } //End block
        // ---------- Original Method ----------
        //if (incomingCallPendingIntent == null) {
            //throw new NullPointerException(
                    //"incomingCallPendingIntent cannot be null");
        //}
        //try {
            //mSipService.open3(localProfile, incomingCallPendingIntent,
                    //createRelay(listener, localProfile.getUriString()));
        //} catch (RemoteException e) {
            //throw new SipException("open()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.345 -0400", hash_original_method = "CFF28AE1062695240C0119F8DCC4A5F5", hash_generated_method = "514B1947B4D58A68D718C2206599F215")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRegistrationListener(String localProfileUri,
            SipRegistrationListener listener) throws SipException {
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(localProfileUri);
        try 
        {
            mSipService.setRegistrationListener(
                    localProfileUri, createRelay(listener, localProfileUri));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("setRegistrationListener()", e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mSipService.setRegistrationListener(
                    //localProfileUri, createRelay(listener, localProfileUri));
        //} catch (RemoteException e) {
            //throw new SipException("setRegistrationListener()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.345 -0400", hash_original_method = "44B0A789C05B858CACCF674C81E7AABD", hash_generated_method = "28B292AA5BB1072CFA06ABF038EDED22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close(String localProfileUri) throws SipException {
        dsTaint.addTaint(localProfileUri);
        try 
        {
            mSipService.close(localProfileUri);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("close()", e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mSipService.close(localProfileUri);
        //} catch (RemoteException e) {
            //throw new SipException("close()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.345 -0400", hash_original_method = "360E1B00872B2424D301125F3BB142C6", hash_generated_method = "5CAB3F8669C581B54A2B5F256F994189")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isOpened(String localProfileUri) throws SipException {
        dsTaint.addTaint(localProfileUri);
        try 
        {
            boolean var6A9CBC405D38097E35D3C30EC845ACA4_1993907996 = (mSipService.isOpened(localProfileUri));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("isOpened()", e);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mSipService.isOpened(localProfileUri);
        //} catch (RemoteException e) {
            //throw new SipException("isOpened()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.346 -0400", hash_original_method = "5A38205B94FE9DB78D17F700EB0D1FB0", hash_generated_method = "E044CDC4DEF2839020A437EA9205A39C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isRegistered(String localProfileUri) throws SipException {
        dsTaint.addTaint(localProfileUri);
        try 
        {
            boolean var2D5D5A8EF9B3BC2166F01EEE008C27C5_925735932 = (mSipService.isRegistered(localProfileUri));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("isRegistered()", e);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mSipService.isRegistered(localProfileUri);
        //} catch (RemoteException e) {
            //throw new SipException("isRegistered()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.346 -0400", hash_original_method = "AC6B9DFAF926B776E74C72D404923FC3", hash_generated_method = "BC10B4F76EED852BF41D5E51239E41F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipAudioCall makeAudioCall(SipProfile localProfile,
            SipProfile peerProfile, SipAudioCall.Listener listener, int timeout) throws SipException {
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(localProfile.dsTaint);
        dsTaint.addTaint(peerProfile.dsTaint);
        dsTaint.addTaint(timeout);
        {
            boolean var71F47E4046802A9F78B8CD8F59926173_2079010838 = (!isVoipSupported(mContext));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("VOIP API is not supported");
            } //End block
        } //End collapsed parenthetic
        SipAudioCall call;
        call = new SipAudioCall(mContext, localProfile);
        call.setListener(listener);
        SipSession s;
        s = createSipSession(localProfile, null);
        call.makeCall(peerProfile, s, timeout);
        return (SipAudioCall)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isVoipSupported(mContext)) {
            //throw new SipException("VOIP API is not supported");
        //}
        //SipAudioCall call = new SipAudioCall(mContext, localProfile);
        //call.setListener(listener);
        //SipSession s = createSipSession(localProfile, null);
        //call.makeCall(peerProfile, s, timeout);
        //return call;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.346 -0400", hash_original_method = "7876146B456607658E8063AE5100AB4E", hash_generated_method = "236D7DCF0ACAF03913636359C555264C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipAudioCall makeAudioCall(String localProfileUri,
            String peerProfileUri, SipAudioCall.Listener listener, int timeout) throws SipException {
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(peerProfileUri);
        dsTaint.addTaint(localProfileUri);
        dsTaint.addTaint(timeout);
        {
            boolean var71F47E4046802A9F78B8CD8F59926173_685914604 = (!isVoipSupported(mContext));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("VOIP API is not supported");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            SipAudioCall varA100EF02A50D4C6D7F114985A53E9E1B_1145068372 = (makeAudioCall(
                    new SipProfile.Builder(localProfileUri).build(),
                    new SipProfile.Builder(peerProfileUri).build(), listener,
                    timeout));
        } //End block
        catch (ParseException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("build SipProfile", e);
        } //End block
        return (SipAudioCall)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isVoipSupported(mContext)) {
            //throw new SipException("VOIP API is not supported");
        //}
        //try {
            //return makeAudioCall(
                    //new SipProfile.Builder(localProfileUri).build(),
                    //new SipProfile.Builder(peerProfileUri).build(), listener,
                    //timeout);
        //} catch (ParseException e) {
            //throw new SipException("build SipProfile", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.347 -0400", hash_original_method = "E0DC1BF0888BDAC076F0EBE49A950610", hash_generated_method = "809992DAF6D3AAF5C45EA87196186AB8")
    @DSModeled(DSC.SPEC)
    public SipAudioCall takeAudioCall(Intent incomingCallIntent,
            SipAudioCall.Listener listener) throws SipException {
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(incomingCallIntent.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot retrieve session with null intent");
        } //End block
        String callId;
        callId = getCallId(incomingCallIntent);
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Call ID missing in incoming call intent");
        } //End block
        String offerSd;
        offerSd = getOfferSessionDescription(incomingCallIntent);
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Session description missing in incoming "
                    + "call intent");
        } //End block
        try 
        {
            ISipSession session;
            session = mSipService.getPendingSession(callId);
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("No pending session for the call");
            } //End block
            SipAudioCall call;
            call = new SipAudioCall(
                    mContext, session.getLocalProfile());
            call.attachCall(new SipSession(session), offerSd);
            call.setListener(listener);
        } //End block
        catch (Throwable t)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("takeAudioCall()", t);
        } //End block
        return (SipAudioCall)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static boolean isIncomingCallIntent(Intent intent) {
        if (intent == null) return false;
        String callId = getCallId(intent);
        String offerSd = getOfferSessionDescription(intent);
        return ((callId != null) && (offerSd != null));
    }

    
        public static String getCallId(Intent incomingCallIntent) {
        return incomingCallIntent.getStringExtra(EXTRA_CALL_ID);
    }

    
        public static String getOfferSessionDescription(Intent incomingCallIntent) {
        return incomingCallIntent.getStringExtra(EXTRA_OFFER_SD);
    }

    
        public static Intent createIncomingCallBroadcast(String callId,
            String sessionDescription) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_CALL_ID, callId);
        intent.putExtra(EXTRA_OFFER_SD, sessionDescription);
        return intent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.351 -0400", hash_original_method = "686853C3DB5059E14B851E63F90D72E4", hash_generated_method = "E0EFE1DC1C089F429152E2FD07478BDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void register(SipProfile localProfile, int expiryTime,
            SipRegistrationListener listener) throws SipException {
        dsTaint.addTaint(expiryTime);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(localProfile.dsTaint);
        try 
        {
            ISipSession session;
            session = mSipService.createSession(localProfile,
                    createRelay(listener, localProfile.getUriString()));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException(
                        "SipService.createSession() returns null");
            } //End block
            session.register(expiryTime);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("register()", e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //ISipSession session = mSipService.createSession(localProfile,
                    //createRelay(listener, localProfile.getUriString()));
            //if (session == null) {
                //throw new SipException(
                        //"SipService.createSession() returns null");
            //}
            //session.register(expiryTime);
        //} catch (RemoteException e) {
            //throw new SipException("register()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.351 -0400", hash_original_method = "4CCD1E71A8A3F25E13404A132CF88582", hash_generated_method = "3726084DCF95645884DD9464F4E38121")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregister(SipProfile localProfile,
            SipRegistrationListener listener) throws SipException {
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(localProfile.dsTaint);
        try 
        {
            ISipSession session;
            session = mSipService.createSession(localProfile,
                    createRelay(listener, localProfile.getUriString()));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException(
                        "SipService.createSession() returns null");
            } //End block
            session.unregister();
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("unregister()", e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //ISipSession session = mSipService.createSession(localProfile,
                    //createRelay(listener, localProfile.getUriString()));
            //if (session == null) {
                //throw new SipException(
                        //"SipService.createSession() returns null");
            //}
            //session.unregister();
        //} catch (RemoteException e) {
            //throw new SipException("unregister()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.352 -0400", hash_original_method = "EDCDF2FC84E74B60CE6B84F2ED6BCA20", hash_generated_method = "1ED9C1CD9A1D7D61597373F603390955")
    @DSModeled(DSC.SPEC)
    public SipSession getSessionFor(Intent incomingCallIntent) throws SipException {
        dsTaint.addTaint(incomingCallIntent.dsTaint);
        try 
        {
            String callId;
            callId = getCallId(incomingCallIntent);
            ISipSession s;
            s = mSipService.getPendingSession(callId);
            SipSession var9FA9B1E3839F54C00161013E7E7E3993_1185293014 = (((s == null) ? null : new SipSession(s))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("getSessionFor()", e);
        } //End block
        return (SipSession)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //String callId = getCallId(incomingCallIntent);
            //ISipSession s = mSipService.getPendingSession(callId);
            //return ((s == null) ? null : new SipSession(s));
        //} catch (RemoteException e) {
            //throw new SipException("getSessionFor()", e);
        //}
    }

    
        private static ISipSessionListener createRelay(
            SipRegistrationListener listener, String uri) {
        return ((listener == null) ? null : new ListenerRelay(listener, uri));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.353 -0400", hash_original_method = "EE079117FAD2E68EE193F65B6013BB2B", hash_generated_method = "1640C7F000BA6512819EC6D6B917BBB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipSession createSipSession(SipProfile localProfile,
            SipSession.Listener listener) throws SipException {
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(localProfile.dsTaint);
        try 
        {
            ISipSession s;
            s = mSipService.createSession(localProfile, null);
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException(
                        "Failed to create SipSession; network unavailable?");
            } //End block
            SipSession varCDCFB365014C39D9D98E44B0522306FC_168637079 = (new SipSession(s, listener));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("createSipSession()", e);
        } //End block
        return (SipSession)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //ISipSession s = mSipService.createSession(localProfile, null);
            //if (s == null) {
                //throw new SipException(
                        //"Failed to create SipSession; network unavailable?");
            //}
            //return new SipSession(s, listener);
        //} catch (RemoteException e) {
            //throw new SipException("createSipSession()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.353 -0400", hash_original_method = "1735A7464BE0976B91AB92297644D35E", hash_generated_method = "204530AC9EFF3A791432E8DE6FA116A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipProfile[] getListOfProfiles() {
        try 
        {
            SipProfile[] varAC9164DE3718394EE076A5B1FD4FC72D_1736620620 = (mSipService.getListOfProfiles());
        } //End block
        catch (RemoteException e)
        {
            SipProfile[] var3E440E1452150A656D543771BF8CAC24_1464696375 = (new SipProfile[0]);
        } //End block
        return (SipProfile[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mSipService.getListOfProfiles();
        //} catch (RemoteException e) {
            //return new SipProfile[0];
        //}
    }

    
    private static class ListenerRelay extends SipSessionAdapter {
        private SipRegistrationListener mListener;
        private String mUri;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.353 -0400", hash_original_method = "EDC0C5FAD332557C083D99177F2D4EAD", hash_generated_method = "EC41E37C51F9432A2AE0A90DBEC96C3C")
        @DSModeled(DSC.SAFE)
        public ListenerRelay(SipRegistrationListener listener, String uri) {
            dsTaint.addTaint(listener.dsTaint);
            dsTaint.addTaint(uri);
            // ---------- Original Method ----------
            //mListener = listener;
            //mUri = uri;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.354 -0400", hash_original_method = "DB62FE45AF7F183C085E9ABCEE6AC21A", hash_generated_method = "220F70B3A443A5CC09D4AA39CF4EB4A5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String getUri(ISipSession session) {
            dsTaint.addTaint(session.dsTaint);
            try 
            {
                String varE40154AEFA0D3343351769FF65ADD7DD_1654747096 = (((session == null)
                        ? mUri
                        : session.getLocalProfile().getUriString())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            } //End block
            catch (Throwable e)
            { }
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //try {
                //return ((session == null)
                        //? mUri
                        //: session.getLocalProfile().getUriString());
            //} catch (Throwable e) {
                //Log.w(TAG, "getUri(): " + e);
                //return null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.354 -0400", hash_original_method = "5C196F3BA9DB038EA3DA210A6D75DA60", hash_generated_method = "AC2ED5B76DEF48B8F05EA5762DCF0259")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onRegistering(ISipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(session.dsTaint);
            mListener.onRegistering(getUri(session));
            // ---------- Original Method ----------
            //mListener.onRegistering(getUri(session));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.354 -0400", hash_original_method = "C7A68C57912DB0D6749A6AEEEB478950", hash_generated_method = "7D6862AEC2E5113C74471F778865E7A8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onRegistrationDone(ISipSession session, int duration) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(duration);
            dsTaint.addTaint(session.dsTaint);
            long expiryTime;
            expiryTime = duration;
            expiryTime += System.currentTimeMillis();
            mListener.onRegistrationDone(getUri(session), expiryTime);
            // ---------- Original Method ----------
            //long expiryTime = duration;
            //if (duration > 0) expiryTime += System.currentTimeMillis();
            //mListener.onRegistrationDone(getUri(session), expiryTime);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.354 -0400", hash_original_method = "0C0A3DDB18DA2EFA9B1E7F04C9F8EEEA", hash_generated_method = "BEE74DDCC020EFEC4E482C42E359AA33")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onRegistrationFailed(ISipSession session, int errorCode,
                String message) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(message);
            dsTaint.addTaint(session.dsTaint);
            dsTaint.addTaint(errorCode);
            mListener.onRegistrationFailed(getUri(session), errorCode, message);
            // ---------- Original Method ----------
            //mListener.onRegistrationFailed(getUri(session), errorCode, message);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.355 -0400", hash_original_method = "3FA96A1C02B279EF2B5BC0F9EDE11DE7", hash_generated_method = "253DFD6FA2698D25FF9E32BE0FE73BAD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onRegistrationTimeout(ISipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(session.dsTaint);
            mListener.onRegistrationFailed(getUri(session),
                    SipErrorCode.TIME_OUT, "registration timed out");
            // ---------- Original Method ----------
            //mListener.onRegistrationFailed(getUri(session),
                    //SipErrorCode.TIME_OUT, "registration timed out");
        }

        
    }


    
    public static final int INCOMING_CALL_RESULT_CODE = 101;
    public static final String EXTRA_CALL_ID = "android:sipCallID";
    public static final String EXTRA_OFFER_SD = "android:sipOfferSD";
    public static final String ACTION_SIP_SERVICE_UP =
            "android.net.sip.SIP_SERVICE_UP";
    public static final String ACTION_SIP_INCOMING_CALL =
            "com.android.phone.SIP_INCOMING_CALL";
    public static final String ACTION_SIP_ADD_PHONE =
            "com.android.phone.SIP_ADD_PHONE";
    public static final String ACTION_SIP_REMOVE_PHONE =
            "com.android.phone.SIP_REMOVE_PHONE";
    public static final String EXTRA_LOCAL_URI = "android:localSipUri";
    private static final String TAG = "SipManager";
}

