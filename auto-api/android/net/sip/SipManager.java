package android.net.sip;

// Droidsafe Imports
import java.text.ParseException;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class SipManager {
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
    private ISipService mSipService;
    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.337 -0400", hash_original_method = "C37128DE517781FF4AF379CF096D6229", hash_generated_method = "275FC3F434744511B8C1B8532834C002")
    @DSModeled(DSC.SAFE)
    private SipManager(Context context) {
        dsTaint.addTaint(context.dsTaint);
        createSipService();
        // ---------- Original Method ----------
        //mContext = context;
        //createSipService();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.337 -0400", hash_original_method = "66F422A1F07B1EF61355B4A646F6CF3A", hash_generated_method = "652CF5553FF8C8C60050A97610D1CFC0")
    public static SipManager newInstance(Context context) {
        return (isApiSupported(context) ? new SipManager(context) : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.337 -0400", hash_original_method = "3DFE3DD93360D391D61344F06E56E68A", hash_generated_method = "EE9DBC42532266034E02F6C7CB27EDC1")
    public static boolean isApiSupported(Context context) {
        return context.getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_SIP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.337 -0400", hash_original_method = "2F1F4217686C723813009E2E078B2257", hash_generated_method = "0FBB255CA3773D98A3FCEEF44B21219C")
    public static boolean isVoipSupported(Context context) {
        return context.getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_SIP_VOIP) && isApiSupported(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.337 -0400", hash_original_method = "B035E9969048B9A33AAF34D9AA865F8C", hash_generated_method = "8EFF349340EF5493E8744793A91FA890")
    public static boolean isSipWifiOnly(Context context) {
        return context.getResources().getBoolean(
                com.android.internal.R.bool.config_sip_wifi_only);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.337 -0400", hash_original_method = "78D0C1947CAE04BC8743510E34683CF6", hash_generated_method = "38C665CF5B1CB128C25E838ECBE626E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void createSipService() {
        IBinder b;
        b = ServiceManager.getService(Context.SIP_SERVICE);
        mSipService = ISipService.Stub.asInterface(b);
        // ---------- Original Method ----------
        //IBinder b = ServiceManager.getService(Context.SIP_SERVICE);
        //mSipService = ISipService.Stub.asInterface(b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.338 -0400", hash_original_method = "52C02C16281ED39358E05D7A6D2BF025", hash_generated_method = "5838D12335B4A0F41EAAA8F2171D2945")
    @DSModeled(DSC.SAFE)
    public void open(SipProfile localProfile) throws SipException {
        dsTaint.addTaint(localProfile.dsTaint);
        try 
        {
            mSipService.open(localProfile);
        } //End block
        catch (RemoteException e)
        {
            throw new SipException("open()", e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mSipService.open(localProfile);
        //} catch (RemoteException e) {
            //throw new SipException("open()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.338 -0400", hash_original_method = "BDC8C921966B306282AD779760136C05", hash_generated_method = "0FCC00271E6FEAE6BFF25A91FEC0580A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void open(SipProfile localProfile,
            PendingIntent incomingCallPendingIntent,
            SipRegistrationListener listener) throws SipException {
        dsTaint.addTaint(incomingCallPendingIntent.dsTaint);
        dsTaint.addTaint(localProfile.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        {
           if (DroidSafeAndroidRuntime.control)  throw new NullPointerException(
                    "incomingCallPendingIntent cannot be null");
        } //End block
        try 
        {
            mSipService.open3(localProfile, incomingCallPendingIntent,
                    createRelay(listener, localProfile.getUriString()));
        } //End block
        catch (RemoteException e)
        {
            throw new SipException("open()", e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.338 -0400", hash_original_method = "CFF28AE1062695240C0119F8DCC4A5F5", hash_generated_method = "D206D3B8A6CBD9F18DDA4E7A7B7E654A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRegistrationListener(String localProfileUri,
            SipRegistrationListener listener) throws SipException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(localProfileUri);
        try 
        {
            mSipService.setRegistrationListener(
                    localProfileUri, createRelay(listener, localProfileUri));
        } //End block
        catch (RemoteException e)
        {
            throw new SipException("setRegistrationListener()", e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mSipService.setRegistrationListener(
                    //localProfileUri, createRelay(listener, localProfileUri));
        //} catch (RemoteException e) {
            //throw new SipException("setRegistrationListener()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.338 -0400", hash_original_method = "44B0A789C05B858CACCF674C81E7AABD", hash_generated_method = "BB42926BEB00FB59871484B35829664D")
    @DSModeled(DSC.SAFE)
    public void close(String localProfileUri) throws SipException {
        dsTaint.addTaint(localProfileUri);
        try 
        {
            mSipService.close(localProfileUri);
        } //End block
        catch (RemoteException e)
        {
            throw new SipException("close()", e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mSipService.close(localProfileUri);
        //} catch (RemoteException e) {
            //throw new SipException("close()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.338 -0400", hash_original_method = "360E1B00872B2424D301125F3BB142C6", hash_generated_method = "D2962A4C1B50AED6CA1C5F1C74F2FBDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isOpened(String localProfileUri) throws SipException {
        dsTaint.addTaint(localProfileUri);
        try 
        {
            boolean var6A9CBC405D38097E35D3C30EC845ACA4_1847703740 = (mSipService.isOpened(localProfileUri));
        } //End block
        catch (RemoteException e)
        {
            throw new SipException("isOpened()", e);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mSipService.isOpened(localProfileUri);
        //} catch (RemoteException e) {
            //throw new SipException("isOpened()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.338 -0400", hash_original_method = "5A38205B94FE9DB78D17F700EB0D1FB0", hash_generated_method = "66A96C6B0866DABFB94D204A9145B3FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isRegistered(String localProfileUri) throws SipException {
        dsTaint.addTaint(localProfileUri);
        try 
        {
            boolean var2D5D5A8EF9B3BC2166F01EEE008C27C5_1311093530 = (mSipService.isRegistered(localProfileUri));
        } //End block
        catch (RemoteException e)
        {
            throw new SipException("isRegistered()", e);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mSipService.isRegistered(localProfileUri);
        //} catch (RemoteException e) {
            //throw new SipException("isRegistered()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.339 -0400", hash_original_method = "AC6B9DFAF926B776E74C72D404923FC3", hash_generated_method = "85B246D412D8D32EACBE8120B88FAE8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipAudioCall makeAudioCall(SipProfile localProfile,
            SipProfile peerProfile, SipAudioCall.Listener listener, int timeout) throws SipException {
        dsTaint.addTaint(localProfile.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(peerProfile.dsTaint);
        dsTaint.addTaint(timeout);
        {
            boolean var71F47E4046802A9F78B8CD8F59926173_966384662 = (!isVoipSupported(mContext));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.339 -0400", hash_original_method = "7876146B456607658E8063AE5100AB4E", hash_generated_method = "C13016A2EF6E51C4A5922C7F192B0AFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipAudioCall makeAudioCall(String localProfileUri,
            String peerProfileUri, SipAudioCall.Listener listener, int timeout) throws SipException {
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(localProfileUri);
        dsTaint.addTaint(peerProfileUri);
        dsTaint.addTaint(timeout);
        {
            boolean var71F47E4046802A9F78B8CD8F59926173_1128271583 = (!isVoipSupported(mContext));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("VOIP API is not supported");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            SipAudioCall varA100EF02A50D4C6D7F114985A53E9E1B_1969681001 = (makeAudioCall(
                    new SipProfile.Builder(localProfileUri).build(),
                    new SipProfile.Builder(peerProfileUri).build(), listener,
                    timeout));
        } //End block
        catch (ParseException e)
        {
            throw new SipException("build SipProfile", e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.339 -0400", hash_original_method = "E0DC1BF0888BDAC076F0EBE49A950610", hash_generated_method = "C420B129ADB919B76BCC63EEEC78BAAF")
    @DSModeled(DSC.SPEC)
    public SipAudioCall takeAudioCall(Intent incomingCallIntent,
            SipAudioCall.Listener listener) throws SipException {
        dsTaint.addTaint(incomingCallIntent.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
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
            if (DroidSafeAndroidRuntime.control)  throw new SipException("Session description missing in incoming "
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
            throw new SipException("takeAudioCall()", t);
        } //End block
        return (SipAudioCall)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.339 -0400", hash_original_method = "C6D368F9A631ACABA788A2C236A29B4D", hash_generated_method = "B538328CDE3330B9B227E3BE8EDDED53")
    public static boolean isIncomingCallIntent(Intent intent) {
        if (intent == null) return false;
        String callId = getCallId(intent);
        String offerSd = getOfferSessionDescription(intent);
        return ((callId != null) && (offerSd != null));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.339 -0400", hash_original_method = "70AF429815E14941562A6F2DBFF9EBC1", hash_generated_method = "52E866D12AAA4D385EA44EAC9105F06B")
    public static String getCallId(Intent incomingCallIntent) {
        return incomingCallIntent.getStringExtra(EXTRA_CALL_ID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.339 -0400", hash_original_method = "F464808FDF7202E950EC68A83A29D052", hash_generated_method = "FA6896AFE12B4C2BC1DD3B56E533F939")
    public static String getOfferSessionDescription(Intent incomingCallIntent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return incomingCallIntent.getStringExtra(EXTRA_OFFER_SD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.340 -0400", hash_original_method = "7A0B7FD710461D3DD9E5460070BF3AA7", hash_generated_method = "19C5A33FDFC1B63C0DB8E261167CC24C")
    public static Intent createIncomingCallBroadcast(String callId,
            String sessionDescription) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_CALL_ID, callId);
        intent.putExtra(EXTRA_OFFER_SD, sessionDescription);
        return intent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.340 -0400", hash_original_method = "686853C3DB5059E14B851E63F90D72E4", hash_generated_method = "BA4125F07996646B7B2FA32B29FE9BF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void register(SipProfile localProfile, int expiryTime,
            SipRegistrationListener listener) throws SipException {
        dsTaint.addTaint(expiryTime);
        dsTaint.addTaint(localProfile.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        try 
        {
            ISipSession session;
            session = mSipService.createSession(localProfile,
                    createRelay(listener, localProfile.getUriString()));
            {
               if (DroidSafeAndroidRuntime.control)  throw new SipException(
                        "SipService.createSession() returns null");
            } //End block
            session.register(expiryTime);
        } //End block
        catch (RemoteException e)
        {
            throw new SipException("register()", e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.340 -0400", hash_original_method = "4CCD1E71A8A3F25E13404A132CF88582", hash_generated_method = "0DC389D265356DC2135D4CB2D4A56EAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregister(SipProfile localProfile,
            SipRegistrationListener listener) throws SipException {
        dsTaint.addTaint(localProfile.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
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
            throw new SipException("unregister()", e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.340 -0400", hash_original_method = "EDCDF2FC84E74B60CE6B84F2ED6BCA20", hash_generated_method = "52B2C0B78E85FFC409A920A291B329E8")
    @DSModeled(DSC.SPEC)
    public SipSession getSessionFor(Intent incomingCallIntent) throws SipException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(incomingCallIntent.dsTaint);
        try 
        {
            String callId;
            callId = getCallId(incomingCallIntent);
            ISipSession s;
            s = mSipService.getPendingSession(callId);
        } //End block
        catch (RemoteException e)
        {
            throw new SipException("getSessionFor()", e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.340 -0400", hash_original_method = "202F15347D7AFCF2355EFD7038580BD7", hash_generated_method = "80280E4046A29DDF49C73CC5D51E3ECB")
    private static ISipSessionListener createRelay(
            SipRegistrationListener listener, String uri) {
        return ((listener == null) ? null : new ListenerRelay(listener, uri));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.340 -0400", hash_original_method = "EE079117FAD2E68EE193F65B6013BB2B", hash_generated_method = "EF5966D19520435CECC5D199FCC0B4AA")
    @DSModeled(DSC.SAFE)
    public SipSession createSipSession(SipProfile localProfile,
            SipSession.Listener listener) throws SipException {
        dsTaint.addTaint(localProfile.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        try 
        {
            ISipSession s;
            s = mSipService.createSession(localProfile, null);
            {
                throw new SipException(
                        "Failed to create SipSession; network unavailable?");
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.341 -0400", hash_original_method = "1735A7464BE0976B91AB92297644D35E", hash_generated_method = "E6DDA681EC2D7894BA9211B05B7D2F01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipProfile[] getListOfProfiles() {
        try 
        {
            SipProfile[] varAC9164DE3718394EE076A5B1FD4FC72D_173184784 = (mSipService.getListOfProfiles());
        } //End block
        catch (RemoteException e)
        { }
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.341 -0400", hash_original_method = "EDC0C5FAD332557C083D99177F2D4EAD", hash_generated_method = "6AA8F587E1C5BA31A548EBC6C682A15B")
        @DSModeled(DSC.SAFE)
        public ListenerRelay(SipRegistrationListener listener, String uri) {
            dsTaint.addTaint(listener.dsTaint);
            dsTaint.addTaint(uri);
            // ---------- Original Method ----------
            //mListener = listener;
            //mUri = uri;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.341 -0400", hash_original_method = "DB62FE45AF7F183C085E9ABCEE6AC21A", hash_generated_method = "0AE97FF7A744FD7D0684A037913358E8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String getUri(ISipSession session) {
            dsTaint.addTaint(session.dsTaint);
            try 
            {
                String varE40154AEFA0D3343351769FF65ADD7DD_1914462986 = (((session == null)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.341 -0400", hash_original_method = "5C196F3BA9DB038EA3DA210A6D75DA60", hash_generated_method = "F1C8FEE353DF37AE53980CD762B72451")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onRegistering(ISipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(session.dsTaint);
            mListener.onRegistering(getUri(session));
            // ---------- Original Method ----------
            //mListener.onRegistering(getUri(session));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.341 -0400", hash_original_method = "C7A68C57912DB0D6749A6AEEEB478950", hash_generated_method = "10AF2FF95C74173A12F6323787715A15")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.342 -0400", hash_original_method = "0C0A3DDB18DA2EFA9B1E7F04C9F8EEEA", hash_generated_method = "5892BCBAB477FEA403174BDFCB54FE89")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.342 -0400", hash_original_method = "3FA96A1C02B279EF2B5BC0F9EDE11DE7", hash_generated_method = "AB3359704D0E22689AB7EEE1418B86F5")
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


    
}


