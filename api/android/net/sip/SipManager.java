package android.net.sip;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.ParseException;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;





public class SipManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.565 -0400", hash_original_field = "C89A12AD1BC30A8688B3556A71E2BBE6", hash_generated_field = "E6ACD78799E84217EB210D7F6F326F7C")

    private ISipService mSipService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.565 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.566 -0400", hash_original_method = "C37128DE517781FF4AF379CF096D6229", hash_generated_method = "46535482E89F824BA8974FC865635BB0")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.568 -0400", hash_original_method = "78D0C1947CAE04BC8743510E34683CF6", hash_generated_method = "C226BD68CE5CA2F2D909A0E66C6E9FE5")
    private void createSipService() {
        IBinder b = ServiceManager.getService(Context.SIP_SERVICE);
        mSipService = ISipService.Stub.asInterface(b);
        // ---------- Original Method ----------
        //IBinder b = ServiceManager.getService(Context.SIP_SERVICE);
        //mSipService = ISipService.Stub.asInterface(b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.568 -0400", hash_original_method = "52C02C16281ED39358E05D7A6D2BF025", hash_generated_method = "D6AE970FF809A06B2DDB9BF068F7ECCA")
    public void open(SipProfile localProfile) throws SipException {
        addTaint(localProfile.getTaint());
        try 
        {
            mSipService.open(localProfile);
        } //End block
        catch (RemoteException e)
        {
            SipException varCB0579D24A003D85D77D2B823CB864A5_1780329201 = new SipException("open()", e);
            varCB0579D24A003D85D77D2B823CB864A5_1780329201.addTaint(taint);
            throw varCB0579D24A003D85D77D2B823CB864A5_1780329201;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mSipService.open(localProfile);
        //} catch (RemoteException e) {
            //throw new SipException("open()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.568 -0400", hash_original_method = "BDC8C921966B306282AD779760136C05", hash_generated_method = "C844DDDE01CB1E7650C8F2ED2E4EE0E7")
    public void open(SipProfile localProfile,
            PendingIntent incomingCallPendingIntent,
            SipRegistrationListener listener) throws SipException {
        addTaint(listener.getTaint());
        addTaint(incomingCallPendingIntent.getTaint());
        addTaint(localProfile.getTaint());
        if(incomingCallPendingIntent == null)        
        {
            NullPointerException var758BF7B5707A01CCB97ABAB18EFCB65B_87669502 = new NullPointerException(
                    "incomingCallPendingIntent cannot be null");
            var758BF7B5707A01CCB97ABAB18EFCB65B_87669502.addTaint(taint);
            throw var758BF7B5707A01CCB97ABAB18EFCB65B_87669502;
        } //End block
        try 
        {
            mSipService.open3(localProfile, incomingCallPendingIntent,
                    createRelay(listener, localProfile.getUriString()));
        } //End block
        catch (RemoteException e)
        {
            SipException varCB0579D24A003D85D77D2B823CB864A5_2027431937 = new SipException("open()", e);
            varCB0579D24A003D85D77D2B823CB864A5_2027431937.addTaint(taint);
            throw varCB0579D24A003D85D77D2B823CB864A5_2027431937;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.569 -0400", hash_original_method = "CFF28AE1062695240C0119F8DCC4A5F5", hash_generated_method = "F9E0724337A9FAA71B5C5EFAE6B059C5")
    public void setRegistrationListener(String localProfileUri,
            SipRegistrationListener listener) throws SipException {
        addTaint(listener.getTaint());
        addTaint(localProfileUri.getTaint());
        try 
        {
            mSipService.setRegistrationListener(
                    localProfileUri, createRelay(listener, localProfileUri));
        } //End block
        catch (RemoteException e)
        {
            SipException varCA7719AD468776365EA6329C0FFE0E1E_6163130 = new SipException("setRegistrationListener()", e);
            varCA7719AD468776365EA6329C0FFE0E1E_6163130.addTaint(taint);
            throw varCA7719AD468776365EA6329C0FFE0E1E_6163130;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mSipService.setRegistrationListener(
                    //localProfileUri, createRelay(listener, localProfileUri));
        //} catch (RemoteException e) {
            //throw new SipException("setRegistrationListener()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.570 -0400", hash_original_method = "44B0A789C05B858CACCF674C81E7AABD", hash_generated_method = "2582E566810CE83FD1EF0465503A2D90")
    public void close(String localProfileUri) throws SipException {
        addTaint(localProfileUri.getTaint());
        try 
        {
            mSipService.close(localProfileUri);
        } //End block
        catch (RemoteException e)
        {
            SipException varA154EDD252A68D36BAB4E1286AEFF90B_134810342 = new SipException("close()", e);
            varA154EDD252A68D36BAB4E1286AEFF90B_134810342.addTaint(taint);
            throw varA154EDD252A68D36BAB4E1286AEFF90B_134810342;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mSipService.close(localProfileUri);
        //} catch (RemoteException e) {
            //throw new SipException("close()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.570 -0400", hash_original_method = "360E1B00872B2424D301125F3BB142C6", hash_generated_method = "4AACCEDE3E79C83DF4767255F624906B")
    public boolean isOpened(String localProfileUri) throws SipException {
        addTaint(localProfileUri.getTaint());
        try 
        {
            boolean varA4D016A36A7A90E1A72A9A0DC36DB33B_2043844663 = (mSipService.isOpened(localProfileUri));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1436353458 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1436353458;
        } //End block
        catch (RemoteException e)
        {
            SipException varED4BDD1B23EC4951520E98F12E07278C_1280030031 = new SipException("isOpened()", e);
            varED4BDD1B23EC4951520E98F12E07278C_1280030031.addTaint(taint);
            throw varED4BDD1B23EC4951520E98F12E07278C_1280030031;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mSipService.isOpened(localProfileUri);
        //} catch (RemoteException e) {
            //throw new SipException("isOpened()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.571 -0400", hash_original_method = "5A38205B94FE9DB78D17F700EB0D1FB0", hash_generated_method = "60E5BA162561FD7970E9AEB950309461")
    public boolean isRegistered(String localProfileUri) throws SipException {
        addTaint(localProfileUri.getTaint());
        try 
        {
            boolean varAF98DE914DAC60491DD0A6FE2204799D_1935201678 = (mSipService.isRegistered(localProfileUri));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_649794919 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_649794919;
        } //End block
        catch (RemoteException e)
        {
            SipException varB5FECD082731BD3404DBCD5D770DDB82_60445323 = new SipException("isRegistered()", e);
            varB5FECD082731BD3404DBCD5D770DDB82_60445323.addTaint(taint);
            throw varB5FECD082731BD3404DBCD5D770DDB82_60445323;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mSipService.isRegistered(localProfileUri);
        //} catch (RemoteException e) {
            //throw new SipException("isRegistered()", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.571 -0400", hash_original_method = "AC6B9DFAF926B776E74C72D404923FC3", hash_generated_method = "4B0AAA47C151A5A0D5F6440EFDED4286")
    public SipAudioCall makeAudioCall(SipProfile localProfile,
            SipProfile peerProfile, SipAudioCall.Listener listener, int timeout) throws SipException {
        addTaint(timeout);
        addTaint(listener.getTaint());
        addTaint(peerProfile.getTaint());
        addTaint(localProfile.getTaint());
        if(!isVoipSupported(mContext))        
        {
            SipException var8139D71B537813371F04348D0E0BAE9A_1029325674 = new SipException("VOIP API is not supported");
            var8139D71B537813371F04348D0E0BAE9A_1029325674.addTaint(taint);
            throw var8139D71B537813371F04348D0E0BAE9A_1029325674;
        } //End block
        SipAudioCall call = new SipAudioCall(mContext, localProfile);
        call.setListener(listener);
        SipSession s = createSipSession(localProfile, null);
        call.makeCall(peerProfile, s, timeout);
SipAudioCall var9D8B92386554E95AD0A8E3E03CF7AAB5_1821670955 =         call;
        var9D8B92386554E95AD0A8E3E03CF7AAB5_1821670955.addTaint(taint);
        return var9D8B92386554E95AD0A8E3E03CF7AAB5_1821670955;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.574 -0400", hash_original_method = "7876146B456607658E8063AE5100AB4E", hash_generated_method = "BB9FA4706FD68C5DB46A7B197527EA6E")
    public SipAudioCall makeAudioCall(String localProfileUri,
            String peerProfileUri, SipAudioCall.Listener listener, int timeout) throws SipException {
        addTaint(timeout);
        addTaint(listener.getTaint());
        addTaint(peerProfileUri.getTaint());
        addTaint(localProfileUri.getTaint());
        if(!isVoipSupported(mContext))        
        {
            SipException var8139D71B537813371F04348D0E0BAE9A_1710280947 = new SipException("VOIP API is not supported");
            var8139D71B537813371F04348D0E0BAE9A_1710280947.addTaint(taint);
            throw var8139D71B537813371F04348D0E0BAE9A_1710280947;
        } //End block
        try 
        {
SipAudioCall varDD46E855D795EA36DF290A4F301961E6_534764374 =             makeAudioCall(
                    new SipProfile.Builder(localProfileUri).build(),
                    new SipProfile.Builder(peerProfileUri).build(), listener,
                    timeout);
            varDD46E855D795EA36DF290A4F301961E6_534764374.addTaint(taint);
            return varDD46E855D795EA36DF290A4F301961E6_534764374;
        } //End block
        catch (ParseException e)
        {
            SipException var38208256843D40529D556690AD1B5760_280986724 = new SipException("build SipProfile", e);
            var38208256843D40529D556690AD1B5760_280986724.addTaint(taint);
            throw var38208256843D40529D556690AD1B5760_280986724;
        } //End block
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.576 -0400", hash_original_method = "E0DC1BF0888BDAC076F0EBE49A950610", hash_generated_method = "D4B2F369E7ED6BBEB242575C711F7883")
    public SipAudioCall takeAudioCall(Intent incomingCallIntent,
            SipAudioCall.Listener listener) throws SipException {
        addTaint(listener.getTaint());
        addTaint(incomingCallIntent.getTaint());
        if(incomingCallIntent == null)        
        {
            SipException varF6F2718AF27329287F11B31E9104E4D7_279540108 = new SipException("Cannot retrieve session with null intent");
            varF6F2718AF27329287F11B31E9104E4D7_279540108.addTaint(taint);
            throw varF6F2718AF27329287F11B31E9104E4D7_279540108;
        } //End block
        String callId = getCallId(incomingCallIntent);
        if(callId == null)        
        {
            SipException varA9DD4F2B3E4DB745AA4BBCCE44D3789B_1712793802 = new SipException("Call ID missing in incoming call intent");
            varA9DD4F2B3E4DB745AA4BBCCE44D3789B_1712793802.addTaint(taint);
            throw varA9DD4F2B3E4DB745AA4BBCCE44D3789B_1712793802;
        } //End block
        String offerSd = getOfferSessionDescription(incomingCallIntent);
        if(offerSd == null)        
        {
            SipException varDCD6B05ADA9C964A8B56EA277D8CF34F_1357346576 = new SipException("Session description missing in incoming "
                    + "call intent");
            varDCD6B05ADA9C964A8B56EA277D8CF34F_1357346576.addTaint(taint);
            throw varDCD6B05ADA9C964A8B56EA277D8CF34F_1357346576;
        } //End block
        try 
        {
            ISipSession session = mSipService.getPendingSession(callId);
            if(session == null)            
            {
                SipException var8AFC5648F5B766BF57183FC711875607_1736737943 = new SipException("No pending session for the call");
                var8AFC5648F5B766BF57183FC711875607_1736737943.addTaint(taint);
                throw var8AFC5648F5B766BF57183FC711875607_1736737943;
            } //End block
            SipAudioCall call = new SipAudioCall(
                    mContext, session.getLocalProfile());
            call.attachCall(new SipSession(session), offerSd);
            call.setListener(listener);
SipAudioCall var9D8B92386554E95AD0A8E3E03CF7AAB5_140590857 =             call;
            var9D8B92386554E95AD0A8E3E03CF7AAB5_140590857.addTaint(taint);
            return var9D8B92386554E95AD0A8E3E03CF7AAB5_140590857;
        } //End block
        catch (Throwable t)
        {
            SipException varADB6A791E2E55698D8F0A5AC49F803B9_297956298 = new SipException("takeAudioCall()", t);
            varADB6A791E2E55698D8F0A5AC49F803B9_297956298.addTaint(taint);
            throw varADB6A791E2E55698D8F0A5AC49F803B9_297956298;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean isIncomingCallIntent(Intent intent) {
        if (intent == null) return false;
        String callId = getCallId(intent);
        String offerSd = getOfferSessionDescription(intent);
        return ((callId != null) && (offerSd != null));
    }

    
    @DSModeled(DSC.SPEC)
    public static String getCallId(Intent incomingCallIntent) {
        return incomingCallIntent.getStringExtra(EXTRA_CALL_ID);
    }

    
    @DSModeled(DSC.SPEC)
    public static String getOfferSessionDescription(Intent incomingCallIntent) {
        return incomingCallIntent.getStringExtra(EXTRA_OFFER_SD);
    }

    
    @DSModeled(DSC.BAN)
    public static Intent createIncomingCallBroadcast(String callId,
            String sessionDescription) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_CALL_ID, callId);
        intent.putExtra(EXTRA_OFFER_SD, sessionDescription);
        return intent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.578 -0400", hash_original_method = "686853C3DB5059E14B851E63F90D72E4", hash_generated_method = "4C15ACE7C08670B209A6EB2BFE9846EC")
    public void register(SipProfile localProfile, int expiryTime,
            SipRegistrationListener listener) throws SipException {
        addTaint(listener.getTaint());
        addTaint(expiryTime);
        addTaint(localProfile.getTaint());
        try 
        {
            ISipSession session = mSipService.createSession(localProfile,
                    createRelay(listener, localProfile.getUriString()));
            if(session == null)            
            {
                SipException varD6A109936A364A960EC4652FD5897969_2046211688 = new SipException(
                        "SipService.createSession() returns null");
                varD6A109936A364A960EC4652FD5897969_2046211688.addTaint(taint);
                throw varD6A109936A364A960EC4652FD5897969_2046211688;
            } //End block
            session.register(expiryTime);
        } //End block
        catch (RemoteException e)
        {
            SipException varF6AF4E3DE6F2D1A1134920B8CA7AE7F8_1121777987 = new SipException("register()", e);
            varF6AF4E3DE6F2D1A1134920B8CA7AE7F8_1121777987.addTaint(taint);
            throw varF6AF4E3DE6F2D1A1134920B8CA7AE7F8_1121777987;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.578 -0400", hash_original_method = "4CCD1E71A8A3F25E13404A132CF88582", hash_generated_method = "3A884235150C3A84A2D4CB9D51153A5A")
    public void unregister(SipProfile localProfile,
            SipRegistrationListener listener) throws SipException {
        addTaint(listener.getTaint());
        addTaint(localProfile.getTaint());
        try 
        {
            ISipSession session = mSipService.createSession(localProfile,
                    createRelay(listener, localProfile.getUriString()));
            if(session == null)            
            {
                SipException varD6A109936A364A960EC4652FD5897969_560748379 = new SipException(
                        "SipService.createSession() returns null");
                varD6A109936A364A960EC4652FD5897969_560748379.addTaint(taint);
                throw varD6A109936A364A960EC4652FD5897969_560748379;
            } //End block
            session.unregister();
        } //End block
        catch (RemoteException e)
        {
            SipException var8381CB852324840322A4751640629FAE_939210019 = new SipException("unregister()", e);
            var8381CB852324840322A4751640629FAE_939210019.addTaint(taint);
            throw var8381CB852324840322A4751640629FAE_939210019;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.579 -0400", hash_original_method = "EDCDF2FC84E74B60CE6B84F2ED6BCA20", hash_generated_method = "2B6E292CA3278C4DDDE4A81BA90CE33E")
    public SipSession getSessionFor(Intent incomingCallIntent) throws SipException {
        addTaint(incomingCallIntent.getTaint());
        try 
        {
            String callId = getCallId(incomingCallIntent);
            ISipSession s = mSipService.getPendingSession(callId);
SipSession varCDEBB4B2D7C9C11FEA72AC760BD9229E_738791754 =             ((s == null) ? null : new SipSession(s));
            varCDEBB4B2D7C9C11FEA72AC760BD9229E_738791754.addTaint(taint);
            return varCDEBB4B2D7C9C11FEA72AC760BD9229E_738791754;
        } //End block
        catch (RemoteException e)
        {
            SipException var80CEEDE9C49A29376E908BAE69F247A4_838613443 = new SipException("getSessionFor()", e);
            var80CEEDE9C49A29376E908BAE69F247A4_838613443.addTaint(taint);
            throw var80CEEDE9C49A29376E908BAE69F247A4_838613443;
        } //End block
        // ---------- Original Method ----------
        //try {
            //String callId = getCallId(incomingCallIntent);
            //ISipSession s = mSipService.getPendingSession(callId);
            //return ((s == null) ? null : new SipSession(s));
        //} catch (RemoteException e) {
            //throw new SipException("getSessionFor()", e);
        //}
    }

    
    @DSModeled(DSC.BAN)
    private static ISipSessionListener createRelay(
            SipRegistrationListener listener, String uri) {
        return ((listener == null) ? null : new ListenerRelay(listener, uri));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.579 -0400", hash_original_method = "EE079117FAD2E68EE193F65B6013BB2B", hash_generated_method = "C2084A87620A52507C71DAC131D4926C")
    public SipSession createSipSession(SipProfile localProfile,
            SipSession.Listener listener) throws SipException {
        addTaint(listener.getTaint());
        addTaint(localProfile.getTaint());
        try 
        {
            ISipSession s = mSipService.createSession(localProfile, null);
            if(s == null)            
            {
                SipException var3AF8663CE1EE03CDCEF0AA50A4B96B4B_1968814891 = new SipException(
                        "Failed to create SipSession; network unavailable?");
                var3AF8663CE1EE03CDCEF0AA50A4B96B4B_1968814891.addTaint(taint);
                throw var3AF8663CE1EE03CDCEF0AA50A4B96B4B_1968814891;
            } //End block
SipSession var4963606BA616877CE0A6A4A5E865B5F2_1899546576 =             new SipSession(s, listener);
            var4963606BA616877CE0A6A4A5E865B5F2_1899546576.addTaint(taint);
            return var4963606BA616877CE0A6A4A5E865B5F2_1899546576;
        } //End block
        catch (RemoteException e)
        {
            SipException var278B540E7CD3077E05CDFD0453087A0B_1872158635 = new SipException("createSipSession()", e);
            var278B540E7CD3077E05CDFD0453087A0B_1872158635.addTaint(taint);
            throw var278B540E7CD3077E05CDFD0453087A0B_1872158635;
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.580 -0400", hash_original_method = "1735A7464BE0976B91AB92297644D35E", hash_generated_method = "8105E4FD2479A376950B7E385F7057AC")
    public SipProfile[] getListOfProfiles() {
        try 
        {
SipProfile[] varE3884862958FF0D2CD617F1EC83EE03A_50494880 =             mSipService.getListOfProfiles();
            varE3884862958FF0D2CD617F1EC83EE03A_50494880.addTaint(taint);
            return varE3884862958FF0D2CD617F1EC83EE03A_50494880;
        } //End block
        catch (RemoteException e)
        {
SipProfile[] var7F3AFDA0578CF1A81A72F7621B23A66E_917364581 =             new SipProfile[0];
            var7F3AFDA0578CF1A81A72F7621B23A66E_917364581.addTaint(taint);
            return var7F3AFDA0578CF1A81A72F7621B23A66E_917364581;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mSipService.getListOfProfiles();
        //} catch (RemoteException e) {
            //return new SipProfile[0];
        //}
    }

    
    private static class ListenerRelay extends SipSessionAdapter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.580 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "7B60FB898E2E2088859D7AE43BC26B1C")

        private SipRegistrationListener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.581 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "E9F1A1B9306C90FC7C133E78A4DA2C70")

        private String mUri;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.582 -0400", hash_original_method = "EDC0C5FAD332557C083D99177F2D4EAD", hash_generated_method = "91F3E126C02A0394A66546C0A316B364")
        public  ListenerRelay(SipRegistrationListener listener, String uri) {
            mListener = listener;
            mUri = uri;
            // ---------- Original Method ----------
            //mListener = listener;
            //mUri = uri;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.583 -0400", hash_original_method = "DB62FE45AF7F183C085E9ABCEE6AC21A", hash_generated_method = "BC2A9B84B40A4FA022B1C646B872389B")
        private String getUri(ISipSession session) {
            addTaint(session.getTaint());
            try 
            {
String varA6028DAE09D13E33E95BA56BE14987AC_790353394 =                 ((session == null)
                        ? mUri
                        : session.getLocalProfile().getUriString());
                varA6028DAE09D13E33E95BA56BE14987AC_790353394.addTaint(taint);
                return varA6028DAE09D13E33E95BA56BE14987AC_790353394;
            } //End block
            catch (Throwable e)
            {
String var540C13E9E156B687226421B24F2DF178_1105558981 =                 null;
                var540C13E9E156B687226421B24F2DF178_1105558981.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1105558981;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.583 -0400", hash_original_method = "5C196F3BA9DB038EA3DA210A6D75DA60", hash_generated_method = "59F85FC775AA322FA0827DD5E74A44FE")
        @Override
        public void onRegistering(ISipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(session.getTaint());
            mListener.onRegistering(getUri(session));
            // ---------- Original Method ----------
            //mListener.onRegistering(getUri(session));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.583 -0400", hash_original_method = "C7A68C57912DB0D6749A6AEEEB478950", hash_generated_method = "B2273E3EDC668F5971099183F53E0CF3")
        @Override
        public void onRegistrationDone(ISipSession session, int duration) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(duration);
            addTaint(session.getTaint());
            long expiryTime = duration;
            if(duration > 0)            
            expiryTime += System.currentTimeMillis();
            mListener.onRegistrationDone(getUri(session), expiryTime);
            // ---------- Original Method ----------
            //long expiryTime = duration;
            //if (duration > 0) expiryTime += System.currentTimeMillis();
            //mListener.onRegistrationDone(getUri(session), expiryTime);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.584 -0400", hash_original_method = "0C0A3DDB18DA2EFA9B1E7F04C9F8EEEA", hash_generated_method = "8ED15DB17859B80A793B25C98C6B8C9A")
        @Override
        public void onRegistrationFailed(ISipSession session, int errorCode,
                String message) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(message.getTaint());
            addTaint(errorCode);
            addTaint(session.getTaint());
            mListener.onRegistrationFailed(getUri(session), errorCode, message);
            // ---------- Original Method ----------
            //mListener.onRegistrationFailed(getUri(session), errorCode, message);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.584 -0400", hash_original_method = "3FA96A1C02B279EF2B5BC0F9EDE11DE7", hash_generated_method = "A0F2834AF372F5C47976274653094CD7")
        @Override
        public void onRegistrationTimeout(ISipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(session.getTaint());
            mListener.onRegistrationFailed(getUri(session),
                    SipErrorCode.TIME_OUT, "registration timed out");
            // ---------- Original Method ----------
            //mListener.onRegistrationFailed(getUri(session),
                    //SipErrorCode.TIME_OUT, "registration timed out");
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.584 -0400", hash_original_field = "615CBE7EAA3797E4FB5A371AB8EA21D3", hash_generated_field = "096C06749AFC8A734EB64E9F43C694CA")

    public static final int INCOMING_CALL_RESULT_CODE = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.584 -0400", hash_original_field = "57DC4C0EEE4DC2816262CDCCBC15CCE4", hash_generated_field = "BE7284F1439B8DF922112FA654BFDB26")

    public static final String EXTRA_CALL_ID = "android:sipCallID";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.584 -0400", hash_original_field = "14F837E3197F39D754EFFC0B6347E0AC", hash_generated_field = "F8F589322810D9F23E34934F42AD98E5")

    public static final String EXTRA_OFFER_SD = "android:sipOfferSD";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.584 -0400", hash_original_field = "E88307F0EFC08EAB42CCC802D3B24979", hash_generated_field = "5956C7F9F00A7E7D40A01DB91096EDA4")

    public static final String ACTION_SIP_SERVICE_UP =
            "android.net.sip.SIP_SERVICE_UP";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.584 -0400", hash_original_field = "1AF4A0BE95F5943924464BE5332A4537", hash_generated_field = "E952E36637F8A7253404C7DEE87A0FD1")

    public static final String ACTION_SIP_INCOMING_CALL =
            "com.android.phone.SIP_INCOMING_CALL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.584 -0400", hash_original_field = "322F5F882182A39A50866C128BADAA61", hash_generated_field = "769B75184386362AB9C0CCC00A0400CB")

    public static final String ACTION_SIP_ADD_PHONE =
            "com.android.phone.SIP_ADD_PHONE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.585 -0400", hash_original_field = "C2EE982C5FDF93B882C8A1C674874EBF", hash_generated_field = "057027C4130E067452F3B1F04C0FBEAB")

    public static final String ACTION_SIP_REMOVE_PHONE =
            "com.android.phone.SIP_REMOVE_PHONE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.585 -0400", hash_original_field = "895D777F3756404F2CDAA4446C16DE6F", hash_generated_field = "095B17FA462D841344A944B851E56BF0")

    public static final String EXTRA_LOCAL_URI = "android:localSipUri";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.585 -0400", hash_original_field = "B20A10D88CB570AE1C501B6318D29346", hash_generated_field = "645CBB8801570ECCBC5A4AC3D588F8A8")

    private static final String TAG = "SipManager";
}

