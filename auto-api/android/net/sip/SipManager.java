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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.820 -0400", hash_original_field = "C89A12AD1BC30A8688B3556A71E2BBE6", hash_generated_field = "E6ACD78799E84217EB210D7F6F326F7C")

    private ISipService mSipService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.820 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.827 -0400", hash_original_method = "C37128DE517781FF4AF379CF096D6229", hash_generated_method = "46535482E89F824BA8974FC865635BB0")
    private  SipManager(Context context) {
        mContext = context;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.840 -0400", hash_original_method = "78D0C1947CAE04BC8743510E34683CF6", hash_generated_method = "B081FD4C8C748236BBD7E49FB2231647")
    private void createSipService() {
        IBinder b;
        b = ServiceManager.getService(Context.SIP_SERVICE);
        mSipService = ISipService.Stub.asInterface(b);
        // ---------- Original Method ----------
        //IBinder b = ServiceManager.getService(Context.SIP_SERVICE);
        //mSipService = ISipService.Stub.asInterface(b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.841 -0400", hash_original_method = "52C02C16281ED39358E05D7A6D2BF025", hash_generated_method = "A8D4A3417706C7FCC786750BD496F683")
    public void open(SipProfile localProfile) throws SipException {
        try 
        {
            mSipService.open(localProfile);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("open()", e);
        } //End block
        addTaint(localProfile.getTaint());
        // ---------- Original Method ----------
        //try {
            //mSipService.open(localProfile);
        //} catch (RemoteException e) {
            //throw new SipException("open()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.841 -0400", hash_original_method = "BDC8C921966B306282AD779760136C05", hash_generated_method = "EFB9A6E6E7CB52C265F6CB372FB27F30")
    public void open(SipProfile localProfile,
            PendingIntent incomingCallPendingIntent,
            SipRegistrationListener listener) throws SipException {
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
        addTaint(localProfile.getTaint());
        addTaint(incomingCallPendingIntent.getTaint());
        addTaint(listener.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.842 -0400", hash_original_method = "CFF28AE1062695240C0119F8DCC4A5F5", hash_generated_method = "65A2F1B38C844CA0DEC12609F17E9049")
    public void setRegistrationListener(String localProfileUri,
            SipRegistrationListener listener) throws SipException {
        try 
        {
            mSipService.setRegistrationListener(
                    localProfileUri, createRelay(listener, localProfileUri));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("setRegistrationListener()", e);
        } //End block
        addTaint(localProfileUri.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //try {
            //mSipService.setRegistrationListener(
                    //localProfileUri, createRelay(listener, localProfileUri));
        //} catch (RemoteException e) {
            //throw new SipException("setRegistrationListener()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.843 -0400", hash_original_method = "44B0A789C05B858CACCF674C81E7AABD", hash_generated_method = "C98E17B5C6BBBAB8258F887CDED437F9")
    public void close(String localProfileUri) throws SipException {
        try 
        {
            mSipService.close(localProfileUri);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("close()", e);
        } //End block
        addTaint(localProfileUri.getTaint());
        // ---------- Original Method ----------
        //try {
            //mSipService.close(localProfileUri);
        //} catch (RemoteException e) {
            //throw new SipException("close()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.844 -0400", hash_original_method = "360E1B00872B2424D301125F3BB142C6", hash_generated_method = "8230D3CFFBC6C984CD4E5846EB0FBED8")
    public boolean isOpened(String localProfileUri) throws SipException {
        try 
        {
            boolean var6A9CBC405D38097E35D3C30EC845ACA4_1614019111 = (mSipService.isOpened(localProfileUri));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("isOpened()", e);
        } //End block
        addTaint(localProfileUri.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_310680261 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_310680261;
        // ---------- Original Method ----------
        //try {
            //return mSipService.isOpened(localProfileUri);
        //} catch (RemoteException e) {
            //throw new SipException("isOpened()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.852 -0400", hash_original_method = "5A38205B94FE9DB78D17F700EB0D1FB0", hash_generated_method = "3BAFA3EC827DA4D9CC2EDC764D551962")
    public boolean isRegistered(String localProfileUri) throws SipException {
        try 
        {
            boolean var2D5D5A8EF9B3BC2166F01EEE008C27C5_386700683 = (mSipService.isRegistered(localProfileUri));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("isRegistered()", e);
        } //End block
        addTaint(localProfileUri.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1417380216 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1417380216;
        // ---------- Original Method ----------
        //try {
            //return mSipService.isRegistered(localProfileUri);
        //} catch (RemoteException e) {
            //throw new SipException("isRegistered()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.868 -0400", hash_original_method = "AC6B9DFAF926B776E74C72D404923FC3", hash_generated_method = "19331B5D7D4480EF620511D502675B29")
    public SipAudioCall makeAudioCall(SipProfile localProfile,
            SipProfile peerProfile, SipAudioCall.Listener listener, int timeout) throws SipException {
        SipAudioCall varB4EAC82CA7396A68D541C85D26508E83_1597142398 = null; //Variable for return #1
        {
            boolean var71F47E4046802A9F78B8CD8F59926173_53877773 = (!isVoipSupported(mContext));
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
        varB4EAC82CA7396A68D541C85D26508E83_1597142398 = call;
        addTaint(localProfile.getTaint());
        addTaint(peerProfile.getTaint());
        addTaint(listener.getTaint());
        addTaint(timeout);
        varB4EAC82CA7396A68D541C85D26508E83_1597142398.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1597142398;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.873 -0400", hash_original_method = "7876146B456607658E8063AE5100AB4E", hash_generated_method = "661368D057514485850F7D5B4D7D2F32")
    public SipAudioCall makeAudioCall(String localProfileUri,
            String peerProfileUri, SipAudioCall.Listener listener, int timeout) throws SipException {
        SipAudioCall varB4EAC82CA7396A68D541C85D26508E83_632442931 = null; //Variable for return #1
        {
            boolean var71F47E4046802A9F78B8CD8F59926173_1292367972 = (!isVoipSupported(mContext));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("VOIP API is not supported");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_632442931 = makeAudioCall(
                    new SipProfile.Builder(localProfileUri).build(),
                    new SipProfile.Builder(peerProfileUri).build(), listener,
                    timeout);
        } //End block
        catch (ParseException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("build SipProfile", e);
        } //End block
        addTaint(localProfileUri.getTaint());
        addTaint(peerProfileUri.getTaint());
        addTaint(listener.getTaint());
        addTaint(timeout);
        varB4EAC82CA7396A68D541C85D26508E83_632442931.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_632442931;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.886 -0400", hash_original_method = "E0DC1BF0888BDAC076F0EBE49A950610", hash_generated_method = "F715FF6554B2042D7E7B2287B70B76BD")
    public SipAudioCall takeAudioCall(Intent incomingCallIntent,
            SipAudioCall.Listener listener) throws SipException {
        SipAudioCall varB4EAC82CA7396A68D541C85D26508E83_1428658433 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1428658433 = call;
        } //End block
        catch (Throwable t)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("takeAudioCall()", t);
        } //End block
        addTaint(incomingCallIntent.getTaint());
        addTaint(listener.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1428658433.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1428658433;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.904 -0400", hash_original_method = "686853C3DB5059E14B851E63F90D72E4", hash_generated_method = "CDA6E1D0CB2D45AE5DF61E184E2AA58F")
    public void register(SipProfile localProfile, int expiryTime,
            SipRegistrationListener listener) throws SipException {
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
        addTaint(localProfile.getTaint());
        addTaint(expiryTime);
        addTaint(listener.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.906 -0400", hash_original_method = "4CCD1E71A8A3F25E13404A132CF88582", hash_generated_method = "48D41E05DF85797C793C1C127B268C33")
    public void unregister(SipProfile localProfile,
            SipRegistrationListener listener) throws SipException {
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
        addTaint(localProfile.getTaint());
        addTaint(listener.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.925 -0400", hash_original_method = "EDCDF2FC84E74B60CE6B84F2ED6BCA20", hash_generated_method = "704D3439B0FD1C3F5C1F443EFC096071")
    public SipSession getSessionFor(Intent incomingCallIntent) throws SipException {
        SipSession varB4EAC82CA7396A68D541C85D26508E83_597197071 = null; //Variable for return #1
        try 
        {
            String callId;
            callId = getCallId(incomingCallIntent);
            ISipSession s;
            s = mSipService.getPendingSession(callId);
            varB4EAC82CA7396A68D541C85D26508E83_597197071 = ((s == null) ? null : new SipSession(s));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("getSessionFor()", e);
        } //End block
        addTaint(incomingCallIntent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_597197071.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_597197071;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.926 -0400", hash_original_method = "EE079117FAD2E68EE193F65B6013BB2B", hash_generated_method = "1B802D2C36E025ECDA5DE7ABF8526968")
    public SipSession createSipSession(SipProfile localProfile,
            SipSession.Listener listener) throws SipException {
        SipSession varB4EAC82CA7396A68D541C85D26508E83_1578712204 = null; //Variable for return #1
        try 
        {
            ISipSession s;
            s = mSipService.createSession(localProfile, null);
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException(
                        "Failed to create SipSession; network unavailable?");
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1578712204 = new SipSession(s, listener);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("createSipSession()", e);
        } //End block
        addTaint(localProfile.getTaint());
        addTaint(listener.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1578712204.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1578712204;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.927 -0400", hash_original_method = "1735A7464BE0976B91AB92297644D35E", hash_generated_method = "9536EABFEE946602BF4C42D467DDA9D1")
    public SipProfile[] getListOfProfiles() {
        SipProfile[] varB4EAC82CA7396A68D541C85D26508E83_1219168224 = null; //Variable for return #1
        SipProfile[] varB4EAC82CA7396A68D541C85D26508E83_1967322691 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1219168224 = mSipService.getListOfProfiles();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1967322691 = new SipProfile[0];
        } //End block
        SipProfile[] varA7E53CE21691AB073D9660D615818899_1891621067; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1891621067 = varB4EAC82CA7396A68D541C85D26508E83_1219168224;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1891621067 = varB4EAC82CA7396A68D541C85D26508E83_1967322691;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1891621067.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1891621067;
        // ---------- Original Method ----------
        //try {
            //return mSipService.getListOfProfiles();
        //} catch (RemoteException e) {
            //return new SipProfile[0];
        //}
    }

    
    private static class ListenerRelay extends SipSessionAdapter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.933 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "7B60FB898E2E2088859D7AE43BC26B1C")

        private SipRegistrationListener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.933 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "E9F1A1B9306C90FC7C133E78A4DA2C70")

        private String mUri;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.937 -0400", hash_original_method = "EDC0C5FAD332557C083D99177F2D4EAD", hash_generated_method = "91F3E126C02A0394A66546C0A316B364")
        public  ListenerRelay(SipRegistrationListener listener, String uri) {
            mListener = listener;
            mUri = uri;
            // ---------- Original Method ----------
            //mListener = listener;
            //mUri = uri;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.954 -0400", hash_original_method = "DB62FE45AF7F183C085E9ABCEE6AC21A", hash_generated_method = "510D9520251A8C21EFB52EBCACD6EB87")
        private String getUri(ISipSession session) {
            String varB4EAC82CA7396A68D541C85D26508E83_1255342521 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_903129973 = null; //Variable for return #2
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1255342521 = ((session == null)
                        ? mUri
                        : session.getLocalProfile().getUriString());
            } //End block
            catch (Throwable e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_903129973 = null;
            } //End block
            addTaint(session.getTaint());
            String varA7E53CE21691AB073D9660D615818899_253320442; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_253320442 = varB4EAC82CA7396A68D541C85D26508E83_1255342521;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_253320442 = varB4EAC82CA7396A68D541C85D26508E83_903129973;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_253320442.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_253320442;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.954 -0400", hash_original_method = "5C196F3BA9DB038EA3DA210A6D75DA60", hash_generated_method = "B3E8354C81201626568CC02F98386C65")
        @Override
        public void onRegistering(ISipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mListener.onRegistering(getUri(session));
            addTaint(session.getTaint());
            // ---------- Original Method ----------
            //mListener.onRegistering(getUri(session));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.955 -0400", hash_original_method = "C7A68C57912DB0D6749A6AEEEB478950", hash_generated_method = "776C9036CAE12E82A5CAB4B68336D1CB")
        @Override
        public void onRegistrationDone(ISipSession session, int duration) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            long expiryTime;
            expiryTime = duration;
            expiryTime += System.currentTimeMillis();
            mListener.onRegistrationDone(getUri(session), expiryTime);
            addTaint(session.getTaint());
            addTaint(duration);
            // ---------- Original Method ----------
            //long expiryTime = duration;
            //if (duration > 0) expiryTime += System.currentTimeMillis();
            //mListener.onRegistrationDone(getUri(session), expiryTime);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.956 -0400", hash_original_method = "0C0A3DDB18DA2EFA9B1E7F04C9F8EEEA", hash_generated_method = "5FCC23DFCF59603BA753F3F26D7872E2")
        @Override
        public void onRegistrationFailed(ISipSession session, int errorCode,
                String message) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mListener.onRegistrationFailed(getUri(session), errorCode, message);
            addTaint(session.getTaint());
            addTaint(errorCode);
            addTaint(message.getTaint());
            // ---------- Original Method ----------
            //mListener.onRegistrationFailed(getUri(session), errorCode, message);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.960 -0400", hash_original_method = "3FA96A1C02B279EF2B5BC0F9EDE11DE7", hash_generated_method = "9F6FEC17C1249D4C3579DCA6993315F4")
        @Override
        public void onRegistrationTimeout(ISipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mListener.onRegistrationFailed(getUri(session),
                    SipErrorCode.TIME_OUT, "registration timed out");
            addTaint(session.getTaint());
            // ---------- Original Method ----------
            //mListener.onRegistrationFailed(getUri(session),
                    //SipErrorCode.TIME_OUT, "registration timed out");
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.960 -0400", hash_original_field = "615CBE7EAA3797E4FB5A371AB8EA21D3", hash_generated_field = "096C06749AFC8A734EB64E9F43C694CA")

    public static final int INCOMING_CALL_RESULT_CODE = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.960 -0400", hash_original_field = "57DC4C0EEE4DC2816262CDCCBC15CCE4", hash_generated_field = "BE7284F1439B8DF922112FA654BFDB26")

    public static final String EXTRA_CALL_ID = "android:sipCallID";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.960 -0400", hash_original_field = "14F837E3197F39D754EFFC0B6347E0AC", hash_generated_field = "F8F589322810D9F23E34934F42AD98E5")

    public static final String EXTRA_OFFER_SD = "android:sipOfferSD";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.960 -0400", hash_original_field = "E88307F0EFC08EAB42CCC802D3B24979", hash_generated_field = "5956C7F9F00A7E7D40A01DB91096EDA4")

    public static final String ACTION_SIP_SERVICE_UP =
            "android.net.sip.SIP_SERVICE_UP";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.960 -0400", hash_original_field = "1AF4A0BE95F5943924464BE5332A4537", hash_generated_field = "E952E36637F8A7253404C7DEE87A0FD1")

    public static final String ACTION_SIP_INCOMING_CALL =
            "com.android.phone.SIP_INCOMING_CALL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.960 -0400", hash_original_field = "322F5F882182A39A50866C128BADAA61", hash_generated_field = "769B75184386362AB9C0CCC00A0400CB")

    public static final String ACTION_SIP_ADD_PHONE =
            "com.android.phone.SIP_ADD_PHONE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.960 -0400", hash_original_field = "C2EE982C5FDF93B882C8A1C674874EBF", hash_generated_field = "057027C4130E067452F3B1F04C0FBEAB")

    public static final String ACTION_SIP_REMOVE_PHONE =
            "com.android.phone.SIP_REMOVE_PHONE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.960 -0400", hash_original_field = "895D777F3756404F2CDAA4446C16DE6F", hash_generated_field = "095B17FA462D841344A944B851E56BF0")

    public static final String EXTRA_LOCAL_URI = "android:localSipUri";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.960 -0400", hash_original_field = "B20A10D88CB570AE1C501B6318D29346", hash_generated_field = "6C3F76E2B61D04B8DDCEB99F23BFB3CB")

    private static String TAG = "SipManager";
}

