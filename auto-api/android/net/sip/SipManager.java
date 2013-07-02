package android.net.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.064 -0400", hash_original_field = "C89A12AD1BC30A8688B3556A71E2BBE6", hash_generated_field = "E6ACD78799E84217EB210D7F6F326F7C")

    private ISipService mSipService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.064 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.064 -0400", hash_original_method = "C37128DE517781FF4AF379CF096D6229", hash_generated_method = "46535482E89F824BA8974FC865635BB0")
    private  SipManager(Context context) {
        mContext = context;
        createSipService();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static SipManager newInstance(Context context) {
        return (isApiSupported(context) ? new SipManager(context) : null);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isApiSupported(Context context) {
        return context.getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_SIP);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isVoipSupported(Context context) {
        return context.getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_SIP_VOIP) && isApiSupported(context);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isSipWifiOnly(Context context) {
        return context.getResources().getBoolean(
                com.android.internal.R.bool.config_sip_wifi_only);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.065 -0400", hash_original_method = "78D0C1947CAE04BC8743510E34683CF6", hash_generated_method = "C226BD68CE5CA2F2D909A0E66C6E9FE5")
    private void createSipService() {
        IBinder b = ServiceManager.getService(Context.SIP_SERVICE);
        mSipService = ISipService.Stub.asInterface(b);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.065 -0400", hash_original_method = "52C02C16281ED39358E05D7A6D2BF025", hash_generated_method = "A8D4A3417706C7FCC786750BD496F683")
    public void open(SipProfile localProfile) throws SipException {
        try 
        {
            mSipService.open(localProfile);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("open()", e);
        } 
        addTaint(localProfile.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.066 -0400", hash_original_method = "BDC8C921966B306282AD779760136C05", hash_generated_method = "EFB9A6E6E7CB52C265F6CB372FB27F30")
    public void open(SipProfile localProfile,
            PendingIntent incomingCallPendingIntent,
            SipRegistrationListener listener) throws SipException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "incomingCallPendingIntent cannot be null");
        } 
        try 
        {
            mSipService.open3(localProfile, incomingCallPendingIntent,
                    createRelay(listener, localProfile.getUriString()));
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("open()", e);
        } 
        addTaint(localProfile.getTaint());
        addTaint(incomingCallPendingIntent.getTaint());
        addTaint(listener.getTaint());
        
        
            
                    
        
        
            
                    
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.066 -0400", hash_original_method = "CFF28AE1062695240C0119F8DCC4A5F5", hash_generated_method = "65A2F1B38C844CA0DEC12609F17E9049")
    public void setRegistrationListener(String localProfileUri,
            SipRegistrationListener listener) throws SipException {
        try 
        {
            mSipService.setRegistrationListener(
                    localProfileUri, createRelay(listener, localProfileUri));
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("setRegistrationListener()", e);
        } 
        addTaint(localProfileUri.getTaint());
        addTaint(listener.getTaint());
        
        
            
                    
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.067 -0400", hash_original_method = "44B0A789C05B858CACCF674C81E7AABD", hash_generated_method = "C98E17B5C6BBBAB8258F887CDED437F9")
    public void close(String localProfileUri) throws SipException {
        try 
        {
            mSipService.close(localProfileUri);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("close()", e);
        } 
        addTaint(localProfileUri.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.067 -0400", hash_original_method = "360E1B00872B2424D301125F3BB142C6", hash_generated_method = "DD87E61377BD6ECBFC46F5D591671C2C")
    public boolean isOpened(String localProfileUri) throws SipException {
        try 
        {
            boolean var6A9CBC405D38097E35D3C30EC845ACA4_2122746875 = (mSipService.isOpened(localProfileUri));
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("isOpened()", e);
        } 
        addTaint(localProfileUri.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1153272953 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1153272953;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.068 -0400", hash_original_method = "5A38205B94FE9DB78D17F700EB0D1FB0", hash_generated_method = "86F652F448176BBED3718CBA28ECE466")
    public boolean isRegistered(String localProfileUri) throws SipException {
        try 
        {
            boolean var2D5D5A8EF9B3BC2166F01EEE008C27C5_271604334 = (mSipService.isRegistered(localProfileUri));
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("isRegistered()", e);
        } 
        addTaint(localProfileUri.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_47145409 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_47145409;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.069 -0400", hash_original_method = "AC6B9DFAF926B776E74C72D404923FC3", hash_generated_method = "60005AFB44B5A85B8316B0E5A324FDBC")
    public SipAudioCall makeAudioCall(SipProfile localProfile,
            SipProfile peerProfile, SipAudioCall.Listener listener, int timeout) throws SipException {
        SipAudioCall varB4EAC82CA7396A68D541C85D26508E83_1361290517 = null; 
        {
            boolean var71F47E4046802A9F78B8CD8F59926173_1165439808 = (!isVoipSupported(mContext));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("VOIP API is not supported");
            } 
        } 
        SipAudioCall call = new SipAudioCall(mContext, localProfile);
        call.setListener(listener);
        SipSession s = createSipSession(localProfile, null);
        call.makeCall(peerProfile, s, timeout);
        varB4EAC82CA7396A68D541C85D26508E83_1361290517 = call;
        addTaint(localProfile.getTaint());
        addTaint(peerProfile.getTaint());
        addTaint(listener.getTaint());
        addTaint(timeout);
        varB4EAC82CA7396A68D541C85D26508E83_1361290517.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1361290517;
        
        
            
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.070 -0400", hash_original_method = "7876146B456607658E8063AE5100AB4E", hash_generated_method = "87C574B5FF387A83BBBEF94D68F570DB")
    public SipAudioCall makeAudioCall(String localProfileUri,
            String peerProfileUri, SipAudioCall.Listener listener, int timeout) throws SipException {
        SipAudioCall varB4EAC82CA7396A68D541C85D26508E83_996792123 = null; 
        {
            boolean var71F47E4046802A9F78B8CD8F59926173_221414979 = (!isVoipSupported(mContext));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("VOIP API is not supported");
            } 
        } 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_996792123 = makeAudioCall(
                    new SipProfile.Builder(localProfileUri).build(),
                    new SipProfile.Builder(peerProfileUri).build(), listener,
                    timeout);
        } 
        catch (ParseException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("build SipProfile", e);
        } 
        addTaint(localProfileUri.getTaint());
        addTaint(peerProfileUri.getTaint());
        addTaint(listener.getTaint());
        addTaint(timeout);
        varB4EAC82CA7396A68D541C85D26508E83_996792123.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_996792123;
        
        
            
        
        
            
                    
                    
                    
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.071 -0400", hash_original_method = "E0DC1BF0888BDAC076F0EBE49A950610", hash_generated_method = "0FBF76B14D3AE2B99D88447F2895E438")
    public SipAudioCall takeAudioCall(Intent incomingCallIntent,
            SipAudioCall.Listener listener) throws SipException {
        SipAudioCall varB4EAC82CA7396A68D541C85D26508E83_879397635 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot retrieve session with null intent");
        } 
        String callId = getCallId(incomingCallIntent);
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Call ID missing in incoming call intent");
        } 
        String offerSd = getOfferSessionDescription(incomingCallIntent);
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Session description missing in incoming "
                    + "call intent");
        } 
        try 
        {
            ISipSession session = mSipService.getPendingSession(callId);
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("No pending session for the call");
            } 
            SipAudioCall call = new SipAudioCall(
                    mContext, session.getLocalProfile());
            call.attachCall(new SipSession(session), offerSd);
            call.setListener(listener);
            varB4EAC82CA7396A68D541C85D26508E83_879397635 = call;
        } 
        catch (Throwable t)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("takeAudioCall()", t);
        } 
        addTaint(incomingCallIntent.getTaint());
        addTaint(listener.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_879397635.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_879397635;
        
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.072 -0400", hash_original_method = "686853C3DB5059E14B851E63F90D72E4", hash_generated_method = "5D18420EFF66DECF82B88945395305E5")
    public void register(SipProfile localProfile, int expiryTime,
            SipRegistrationListener listener) throws SipException {
        try 
        {
            ISipSession session = mSipService.createSession(localProfile,
                    createRelay(listener, localProfile.getUriString()));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException(
                        "SipService.createSession() returns null");
            } 
            session.register(expiryTime);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("register()", e);
        } 
        addTaint(localProfile.getTaint());
        addTaint(expiryTime);
        addTaint(listener.getTaint());
        
        
            
                    
            
                
                        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.073 -0400", hash_original_method = "4CCD1E71A8A3F25E13404A132CF88582", hash_generated_method = "4767D0D276A49465E997B138269B0B2E")
    public void unregister(SipProfile localProfile,
            SipRegistrationListener listener) throws SipException {
        try 
        {
            ISipSession session = mSipService.createSession(localProfile,
                    createRelay(listener, localProfile.getUriString()));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException(
                        "SipService.createSession() returns null");
            } 
            session.unregister();
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("unregister()", e);
        } 
        addTaint(localProfile.getTaint());
        addTaint(listener.getTaint());
        
        
            
                    
            
                
                        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.074 -0400", hash_original_method = "EDCDF2FC84E74B60CE6B84F2ED6BCA20", hash_generated_method = "DEFD0ED0C2780ED471488FD0C650B927")
    public SipSession getSessionFor(Intent incomingCallIntent) throws SipException {
        SipSession varB4EAC82CA7396A68D541C85D26508E83_295600658 = null; 
        try 
        {
            String callId = getCallId(incomingCallIntent);
            ISipSession s = mSipService.getPendingSession(callId);
            varB4EAC82CA7396A68D541C85D26508E83_295600658 = ((s == null) ? null : new SipSession(s));
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("getSessionFor()", e);
        } 
        addTaint(incomingCallIntent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_295600658.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_295600658;
        
        
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    private static ISipSessionListener createRelay(
            SipRegistrationListener listener, String uri) {
        return ((listener == null) ? null : new ListenerRelay(listener, uri));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.075 -0400", hash_original_method = "EE079117FAD2E68EE193F65B6013BB2B", hash_generated_method = "8EF91D7C4A6DE181954AA48C500DF863")
    public SipSession createSipSession(SipProfile localProfile,
            SipSession.Listener listener) throws SipException {
        SipSession varB4EAC82CA7396A68D541C85D26508E83_83814501 = null; 
        try 
        {
            ISipSession s = mSipService.createSession(localProfile, null);
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException(
                        "Failed to create SipSession; network unavailable?");
            } 
            varB4EAC82CA7396A68D541C85D26508E83_83814501 = new SipSession(s, listener);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("createSipSession()", e);
        } 
        addTaint(localProfile.getTaint());
        addTaint(listener.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_83814501.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_83814501;
        
        
            
            
                
                        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.076 -0400", hash_original_method = "1735A7464BE0976B91AB92297644D35E", hash_generated_method = "96352D920186DC76312F38683DB2DA0B")
    public SipProfile[] getListOfProfiles() {
        SipProfile[] varB4EAC82CA7396A68D541C85D26508E83_1028395241 = null; 
        SipProfile[] varB4EAC82CA7396A68D541C85D26508E83_430025831 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1028395241 = mSipService.getListOfProfiles();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_430025831 = new SipProfile[0];
        } 
        SipProfile[] varA7E53CE21691AB073D9660D615818899_1615745864; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1615745864 = varB4EAC82CA7396A68D541C85D26508E83_1028395241;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1615745864 = varB4EAC82CA7396A68D541C85D26508E83_430025831;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1615745864.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1615745864;
        
        
            
        
            
        
    }

    
    private static class ListenerRelay extends SipSessionAdapter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.076 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "7B60FB898E2E2088859D7AE43BC26B1C")

        private SipRegistrationListener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.076 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "E9F1A1B9306C90FC7C133E78A4DA2C70")

        private String mUri;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.076 -0400", hash_original_method = "EDC0C5FAD332557C083D99177F2D4EAD", hash_generated_method = "91F3E126C02A0394A66546C0A316B364")
        public  ListenerRelay(SipRegistrationListener listener, String uri) {
            mListener = listener;
            mUri = uri;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.077 -0400", hash_original_method = "DB62FE45AF7F183C085E9ABCEE6AC21A", hash_generated_method = "CB91E73D79CED8617783EEC298A87D5D")
        private String getUri(ISipSession session) {
            String varB4EAC82CA7396A68D541C85D26508E83_1193615862 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_239100430 = null; 
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1193615862 = ((session == null)
                        ? mUri
                        : session.getLocalProfile().getUriString());
            } 
            catch (Throwable e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_239100430 = null;
            } 
            addTaint(session.getTaint());
            String varA7E53CE21691AB073D9660D615818899_550695645; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_550695645 = varB4EAC82CA7396A68D541C85D26508E83_1193615862;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_550695645 = varB4EAC82CA7396A68D541C85D26508E83_239100430;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_550695645.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_550695645;
            
            
                
                        
                        
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.078 -0400", hash_original_method = "5C196F3BA9DB038EA3DA210A6D75DA60", hash_generated_method = "B3E8354C81201626568CC02F98386C65")
        @Override
        public void onRegistering(ISipSession session) {
            
            mListener.onRegistering(getUri(session));
            addTaint(session.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.078 -0400", hash_original_method = "C7A68C57912DB0D6749A6AEEEB478950", hash_generated_method = "0E06D36B92FB1480094E54B1F468DFEE")
        @Override
        public void onRegistrationDone(ISipSession session, int duration) {
            
            long expiryTime = duration;
            expiryTime += System.currentTimeMillis();
            mListener.onRegistrationDone(getUri(session), expiryTime);
            addTaint(session.getTaint());
            addTaint(duration);
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.079 -0400", hash_original_method = "0C0A3DDB18DA2EFA9B1E7F04C9F8EEEA", hash_generated_method = "5FCC23DFCF59603BA753F3F26D7872E2")
        @Override
        public void onRegistrationFailed(ISipSession session, int errorCode,
                String message) {
            
            mListener.onRegistrationFailed(getUri(session), errorCode, message);
            addTaint(session.getTaint());
            addTaint(errorCode);
            addTaint(message.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.080 -0400", hash_original_method = "3FA96A1C02B279EF2B5BC0F9EDE11DE7", hash_generated_method = "9F6FEC17C1249D4C3579DCA6993315F4")
        @Override
        public void onRegistrationTimeout(ISipSession session) {
            
            mListener.onRegistrationFailed(getUri(session),
                    SipErrorCode.TIME_OUT, "registration timed out");
            addTaint(session.getTaint());
            
            
                    
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.080 -0400", hash_original_field = "615CBE7EAA3797E4FB5A371AB8EA21D3", hash_generated_field = "096C06749AFC8A734EB64E9F43C694CA")

    public static final int INCOMING_CALL_RESULT_CODE = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.080 -0400", hash_original_field = "57DC4C0EEE4DC2816262CDCCBC15CCE4", hash_generated_field = "BE7284F1439B8DF922112FA654BFDB26")

    public static final String EXTRA_CALL_ID = "android:sipCallID";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.080 -0400", hash_original_field = "14F837E3197F39D754EFFC0B6347E0AC", hash_generated_field = "F8F589322810D9F23E34934F42AD98E5")

    public static final String EXTRA_OFFER_SD = "android:sipOfferSD";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.080 -0400", hash_original_field = "E88307F0EFC08EAB42CCC802D3B24979", hash_generated_field = "5956C7F9F00A7E7D40A01DB91096EDA4")

    public static final String ACTION_SIP_SERVICE_UP =
            "android.net.sip.SIP_SERVICE_UP";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.080 -0400", hash_original_field = "1AF4A0BE95F5943924464BE5332A4537", hash_generated_field = "E952E36637F8A7253404C7DEE87A0FD1")

    public static final String ACTION_SIP_INCOMING_CALL =
            "com.android.phone.SIP_INCOMING_CALL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.080 -0400", hash_original_field = "322F5F882182A39A50866C128BADAA61", hash_generated_field = "769B75184386362AB9C0CCC00A0400CB")

    public static final String ACTION_SIP_ADD_PHONE =
            "com.android.phone.SIP_ADD_PHONE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.080 -0400", hash_original_field = "C2EE982C5FDF93B882C8A1C674874EBF", hash_generated_field = "057027C4130E067452F3B1F04C0FBEAB")

    public static final String ACTION_SIP_REMOVE_PHONE =
            "com.android.phone.SIP_REMOVE_PHONE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.080 -0400", hash_original_field = "895D777F3756404F2CDAA4446C16DE6F", hash_generated_field = "095B17FA462D841344A944B851E56BF0")

    public static final String EXTRA_LOCAL_URI = "android:localSipUri";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.080 -0400", hash_original_field = "B20A10D88CB570AE1C501B6318D29346", hash_generated_field = "645CBB8801570ECCBC5A4AC3D588F8A8")

    private static final String TAG = "SipManager";
}

