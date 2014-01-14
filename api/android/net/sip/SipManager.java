package android.net.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
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

    /**
     * Creates a manager instance. Returns null if SIP API is not supported.
     *
     * @param context application context for creating the manager object
     * @return the manager instance or null if SIP API is not supported
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.176 -0500", hash_original_method = "66F422A1F07B1EF61355B4A646F6CF3A", hash_generated_method = "652CF5553FF8C8C60050A97610D1CFC0")
    
public static SipManager newInstance(Context context) {
        return (isApiSupported(context) ? new SipManager(context) : null);
    }

    /**
     * Returns true if the SIP API is supported by the system.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.179 -0500", hash_original_method = "3DFE3DD93360D391D61344F06E56E68A", hash_generated_method = "EE9DBC42532266034E02F6C7CB27EDC1")
    
public static boolean isApiSupported(Context context) {
        return context.getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_SIP);
    }

    /**
     * Returns true if the system supports SIP-based VOIP API.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.181 -0500", hash_original_method = "2F1F4217686C723813009E2E078B2257", hash_generated_method = "0FBB255CA3773D98A3FCEEF44B21219C")
    
public static boolean isVoipSupported(Context context) {
        return context.getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_SIP_VOIP) && isApiSupported(context);
    }

    /**
     * Returns true if SIP is only available on WIFI.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.184 -0500", hash_original_method = "B035E9969048B9A33AAF34D9AA865F8C", hash_generated_method = "8EFF349340EF5493E8744793A91FA890")
    
public static boolean isSipWifiOnly(Context context) {
        return context.getResources().getBoolean(
                com.android.internal.R.bool.config_sip_wifi_only);
    }

    /**
     * Checks if the intent is an incoming call broadcast intent.
     *
     * @param intent the intent in question
     * @return true if the intent is an incoming call broadcast intent
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.211 -0500", hash_original_method = "C6D368F9A631ACABA788A2C236A29B4D", hash_generated_method = "B538328CDE3330B9B227E3BE8EDDED53")
    
public static boolean isIncomingCallIntent(Intent intent) {
        if (intent == null) return false;
        String callId = getCallId(intent);
        String offerSd = getOfferSessionDescription(intent);
        return ((callId != null) && (offerSd != null));
    }

    /**
     * Gets the call ID from the specified incoming call broadcast intent.
     *
     * @param incomingCallIntent the incoming call broadcast intent
     * @return the call ID or null if the intent does not contain it
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.214 -0500", hash_original_method = "70AF429815E14941562A6F2DBFF9EBC1", hash_generated_method = "52E866D12AAA4D385EA44EAC9105F06B")
    
public static String getCallId(Intent incomingCallIntent) {
        return incomingCallIntent.getStringExtra(EXTRA_CALL_ID);
    }

    /**
     * Gets the offer session description from the specified incoming call
     * broadcast intent.
     *
     * @param incomingCallIntent the incoming call broadcast intent
     * @return the offer session description or null if the intent does not
     *      have it
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.216 -0500", hash_original_method = "F464808FDF7202E950EC68A83A29D052", hash_generated_method = "A2E0CA5FB8870BDA79D65B68641AFB08")
    
public static String getOfferSessionDescription(Intent incomingCallIntent) {
        return incomingCallIntent.getStringExtra(EXTRA_OFFER_SD);
    }

    /**
     * Creates an incoming call broadcast intent.
     *
     * @param callId the call ID of the incoming call
     * @param sessionDescription the session description of the incoming call
     * @return the incoming call intent
     * @hide
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.218 -0500", hash_original_method = "7A0B7FD710461D3DD9E5460070BF3AA7", hash_generated_method = "19C5A33FDFC1B63C0DB8E261167CC24C")
    
public static Intent createIncomingCallBroadcast(String callId,
            String sessionDescription) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_CALL_ID, callId);
        intent.putExtra(EXTRA_OFFER_SD, sessionDescription);
        return intent;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.228 -0500", hash_original_method = "202F15347D7AFCF2355EFD7038580BD7", hash_generated_method = "80280E4046A29DDF49C73CC5D51E3ECB")
    
private static ISipSessionListener createRelay(
            SipRegistrationListener listener, String uri) {
        return ((listener == null) ? null : new ListenerRelay(listener, uri));
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.152 -0500", hash_original_field = "BE4E381F5A7CA9322DB4C24745C73414", hash_generated_field = "096C06749AFC8A734EB64E9F43C694CA")

    public static final int INCOMING_CALL_RESULT_CODE = 101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.154 -0500", hash_original_field = "43836FEDDAC6BEA4BBB2457D9D03E81D", hash_generated_field = "BE7284F1439B8DF922112FA654BFDB26")

    public static final String EXTRA_CALL_ID = "android:sipCallID";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.156 -0500", hash_original_field = "4B1D8888BDFDDB15FA7493AB146A5D2A", hash_generated_field = "F8F589322810D9F23E34934F42AD98E5")

    public static final String EXTRA_OFFER_SD = "android:sipOfferSD";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.158 -0500", hash_original_field = "F6A60ED13393FE9F4E961838F55E6081", hash_generated_field = "5956C7F9F00A7E7D40A01DB91096EDA4")

    public static final String ACTION_SIP_SERVICE_UP =
            "android.net.sip.SIP_SERVICE_UP";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.161 -0500", hash_original_field = "0D875E861D8B8843A8D35B512F951470", hash_generated_field = "E952E36637F8A7253404C7DEE87A0FD1")

    public static final String ACTION_SIP_INCOMING_CALL =
            "com.android.phone.SIP_INCOMING_CALL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.164 -0500", hash_original_field = "DF75601C0C5503D7E415967E9D340849", hash_generated_field = "769B75184386362AB9C0CCC00A0400CB")

    public static final String ACTION_SIP_ADD_PHONE =
            "com.android.phone.SIP_ADD_PHONE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.166 -0500", hash_original_field = "785EB2B4C7F63CE4A03574A3428B1B2B", hash_generated_field = "057027C4130E067452F3B1F04C0FBEAB")

    public static final String ACTION_SIP_REMOVE_PHONE =
            "com.android.phone.SIP_REMOVE_PHONE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.168 -0500", hash_original_field = "10ADB3A7179D24D52635E87F32116A9C", hash_generated_field = "095B17FA462D841344A944B851E56BF0")

    public static final String EXTRA_LOCAL_URI = "android:localSipUri";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.170 -0500", hash_original_field = "BDE96822EFEC6D46922749BEFC449993", hash_generated_field = "645CBB8801570ECCBC5A4AC3D588F8A8")

    private static final String TAG = "SipManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.172 -0500", hash_original_field = "8E592A1294885FA358EB764D496D8A65", hash_generated_field = "E6ACD78799E84217EB210D7F6F326F7C")

    private ISipService mSipService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.174 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.186 -0500", hash_original_method = "C37128DE517781FF4AF379CF096D6229", hash_generated_method = "85AB50911AE1C256C1EDCF24348BC04D")
    
private SipManager(Context context) {
        mContext = context;
        createSipService();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.188 -0500", hash_original_method = "78D0C1947CAE04BC8743510E34683CF6", hash_generated_method = "9EEC76B0340FE46B7E6A2AEA5341C1B7")
    
private void createSipService() {
        IBinder b = ServiceManager.getService(Context.SIP_SERVICE);
        mSipService = ISipService.Stub.asInterface(b);
    }

    /**
     * Opens the profile for making generic SIP calls. The caller may make subsequent calls
     * through {@link #makeAudioCall}. If one also wants to receive calls on the
     * profile, use
     * {@link #open(SipProfile, PendingIntent, SipRegistrationListener)}
     * instead.
     *
     * @param localProfile the SIP profile to make calls from
     * @throws SipException if the profile contains incorrect settings or
     *      calling the SIP service results in an error
     */
    @DSSink({DSSinkKind.VOIP})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.191 -0500", hash_original_method = "52C02C16281ED39358E05D7A6D2BF025", hash_generated_method = "47F673D7A9CAF1E4FA89ADF370804CB6")
    
public void open(SipProfile localProfile) throws SipException {
        try {
            mSipService.open(localProfile);
        } catch (RemoteException e) {
            throw new SipException("open()", e);
        }
    }

    /**
     * Opens the profile for making calls and/or receiving generic SIP calls. The caller may
     * make subsequent calls through {@link #makeAudioCall}. If the
     * auto-registration option is enabled in the profile, the SIP service
     * will register the profile to the corresponding SIP provider periodically
     * in order to receive calls from the provider. When the SIP service
     * receives a new call, it will send out an intent with the provided action
     * string. The intent contains a call ID extra and an offer session
     * description string extra. Use {@link #getCallId} and
     * {@link #getOfferSessionDescription} to retrieve those extras.
     *
     * @param localProfile the SIP profile to receive incoming calls for
     * @param incomingCallPendingIntent When an incoming call is received, the
     *      SIP service will call
     *      {@link PendingIntent#send(Context, int, Intent)} to send back the
     *      intent to the caller with {@link #INCOMING_CALL_RESULT_CODE} as the
     *      result code and the intent to fill in the call ID and session
     *      description information. It cannot be null.
     * @param listener to listen to registration events; can be null
     * @see #getCallId
     * @see #getOfferSessionDescription
     * @see #takeAudioCall
     * @throws NullPointerException if {@code incomingCallPendingIntent} is null
     * @throws SipException if the profile contains incorrect settings or
     *      calling the SIP service results in an error
     * @see #isIncomingCallIntent
     * @see #getCallId
     * @see #getOfferSessionDescription
     */
    @DSSink({DSSinkKind.VOIP})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.193 -0500", hash_original_method = "BDC8C921966B306282AD779760136C05", hash_generated_method = "8527A1D79853591CE7E52EC29C824448")
    
public void open(SipProfile localProfile,
            PendingIntent incomingCallPendingIntent,
            SipRegistrationListener listener) throws SipException {
        if (incomingCallPendingIntent == null) {
            throw new NullPointerException(
                    "incomingCallPendingIntent cannot be null");
        }
        try {
            mSipService.open3(localProfile, incomingCallPendingIntent,
                    createRelay(listener, localProfile.getUriString()));
        } catch (RemoteException e) {
            throw new SipException("open()", e);
        }
    }

    /**
     * Sets the listener to listen to registration events. No effect if the
     * profile has not been opened to receive calls (see
     * {@link #open(SipProfile, PendingIntent, SipRegistrationListener)}).
     *
     * @param localProfileUri the URI of the profile
     * @param listener to listen to registration events; can be null
     * @throws SipException if calling the SIP service results in an error
     */
    @DSSink({DSSinkKind.VOIP})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.195 -0500", hash_original_method = "CFF28AE1062695240C0119F8DCC4A5F5", hash_generated_method = "F1C8ECE543E5B0202CFE7BEF1EEE182D")
    
public void setRegistrationListener(String localProfileUri,
            SipRegistrationListener listener) throws SipException {
        try {
            mSipService.setRegistrationListener(
                    localProfileUri, createRelay(listener, localProfileUri));
        } catch (RemoteException e) {
            throw new SipException("setRegistrationListener()", e);
        }
    }

    /**
     * Closes the specified profile to not make/receive calls. All the resources
     * that were allocated to the profile are also released.
     *
     * @param localProfileUri the URI of the profile to close
     * @throws SipException if calling the SIP service results in an error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.197 -0500", hash_original_method = "44B0A789C05B858CACCF674C81E7AABD", hash_generated_method = "CBA5F72A5B5D57CF9151840D5B14FC5C")
    
public void close(String localProfileUri) throws SipException {
        try {
            mSipService.close(localProfileUri);
        } catch (RemoteException e) {
            throw new SipException("close()", e);
        }
    }

    /**
     * Checks if the specified profile is opened in the SIP service for
     * making and/or receiving calls.
     *
     * @param localProfileUri the URI of the profile in question
     * @return true if the profile is enabled to receive calls
     * @throws SipException if calling the SIP service results in an error
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.199 -0500", hash_original_method = "360E1B00872B2424D301125F3BB142C6", hash_generated_method = "6CE6B367989B93B9BB247196E863E8E9")
    
public boolean isOpened(String localProfileUri) throws SipException {
        try {
            return mSipService.isOpened(localProfileUri);
        } catch (RemoteException e) {
            throw new SipException("isOpened()", e);
        }
    }
    
    private static class ListenerRelay extends SipSessionAdapter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.236 -0500", hash_original_field = "3E77454322C6C2E6AA2D3642EC2D93DA", hash_generated_field = "7B60FB898E2E2088859D7AE43BC26B1C")

        private SipRegistrationListener mListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.238 -0500", hash_original_field = "BA70E00DFD0E7FE38CE5D2F28F5B3217", hash_generated_field = "E9F1A1B9306C90FC7C133E78A4DA2C70")

        private String mUri;

        // listener must not be null
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.240 -0500", hash_original_method = "EDC0C5FAD332557C083D99177F2D4EAD", hash_generated_method = "E70DA54B380B68134B466871174FA847")
        
public ListenerRelay(SipRegistrationListener listener, String uri) {
            mListener = listener;
            mUri = uri;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.242 -0500", hash_original_method = "DB62FE45AF7F183C085E9ABCEE6AC21A", hash_generated_method = "DE20EAFC1CBB5FC0EF03E583DA412F14")
        
private String getUri(ISipSession session) {
            try {
                return ((session == null)
                        ? mUri
                        : session.getLocalProfile().getUriString());
            } catch (Throwable e) {
                // SipService died? SIP stack died?
                Log.w(TAG, "getUri(): " + e);
                return null;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.244 -0500", hash_original_method = "5C196F3BA9DB038EA3DA210A6D75DA60", hash_generated_method = "F57FB556DFFEDF8347EEBC2D696683F3")
        
@Override
        public void onRegistering(ISipSession session) {
            mListener.onRegistering(getUri(session));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.247 -0500", hash_original_method = "C7A68C57912DB0D6749A6AEEEB478950", hash_generated_method = "4F10DA8D97E5860739C8336D3F902B20")
        
@Override
        public void onRegistrationDone(ISipSession session, int duration) {
            long expiryTime = duration;
            if (duration > 0) expiryTime += System.currentTimeMillis();
            mListener.onRegistrationDone(getUri(session), expiryTime);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.249 -0500", hash_original_method = "0C0A3DDB18DA2EFA9B1E7F04C9F8EEEA", hash_generated_method = "FFCBE3078C451527D968CEE316E8C82B")
        
@Override
        public void onRegistrationFailed(ISipSession session, int errorCode,
                String message) {
            mListener.onRegistrationFailed(getUri(session), errorCode, message);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.252 -0500", hash_original_method = "3FA96A1C02B279EF2B5BC0F9EDE11DE7", hash_generated_method = "1AEE99135E4ABB4DEB867FFA0FA921BF")
        
@Override
        public void onRegistrationTimeout(ISipSession session) {
            mListener.onRegistrationFailed(getUri(session),
                    SipErrorCode.TIME_OUT, "registration timed out");
        }
        
    }

    /**
     * Checks if the SIP service has successfully registered the profile to the
     * SIP provider (specified in the profile) for receiving calls. Returning
     * true from this method also implies the profile is opened
     * ({@link #isOpened}).
     *
     * @param localProfileUri the URI of the profile in question
     * @return true if the profile is registered to the SIP provider; false if
     *        the profile has not been opened in the SIP service or the SIP
     *        service has not yet successfully registered the profile to the SIP
     *        provider
     * @throws SipException if calling the SIP service results in an error
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.201 -0500", hash_original_method = "5A38205B94FE9DB78D17F700EB0D1FB0", hash_generated_method = "81A6B6372084AE54793B63AF5FF9FA54")
    
public boolean isRegistered(String localProfileUri) throws SipException {
        try {
            return mSipService.isRegistered(localProfileUri);
        } catch (RemoteException e) {
            throw new SipException("isRegistered()", e);
        }
    }

    /**
     * Creates a {@link SipAudioCall} to make a call. The attempt will be timed
     * out if the call is not established within {@code timeout} seconds and
     * {@link SipAudioCall.Listener#onError onError(SipAudioCall, SipErrorCode.TIME_OUT, String)}
     * will be called.
     *
     * @param localProfile the SIP profile to make the call from
     * @param peerProfile the SIP profile to make the call to
     * @param listener to listen to the call events from {@link SipAudioCall};
     *      can be null
     * @param timeout the timeout value in seconds. Default value (defined by
     *        SIP protocol) is used if {@code timeout} is zero or negative.
     * @return a {@link SipAudioCall} object
     * @throws SipException if calling the SIP service results in an error or
     *      VOIP API is not supported by the device
     * @see SipAudioCall.Listener#onError
     * @see #isVoipSupported
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.204 -0500", hash_original_method = "AC6B9DFAF926B776E74C72D404923FC3", hash_generated_method = "ABD901304CE49428641B6E4FFDA1B7F7")
    
public SipAudioCall makeAudioCall(SipProfile localProfile,
            SipProfile peerProfile, SipAudioCall.Listener listener, int timeout)
            throws SipException {
        if (!isVoipSupported(mContext)) {
            throw new SipException("VOIP API is not supported");
        }
        SipAudioCall call = new SipAudioCall(mContext, localProfile);
        call.setListener(listener);
        SipSession s = createSipSession(localProfile, null);
        call.makeCall(peerProfile, s, timeout);
        return call;
    }

    /**
     * Creates a {@link SipAudioCall} to make an audio call. The attempt will be
     * timed out if the call is not established within {@code timeout} seconds
     * and
     * {@link SipAudioCall.Listener#onError onError(SipAudioCall, SipErrorCode.TIME_OUT, String)}
     * will be called.
     *
     * @param localProfileUri URI of the SIP profile to make the call from
     * @param peerProfileUri URI of the SIP profile to make the call to
     * @param listener to listen to the call events from {@link SipAudioCall};
     *      can be null
     * @param timeout the timeout value in seconds. Default value (defined by
     *        SIP protocol) is used if {@code timeout} is zero or negative.
     * @return a {@link SipAudioCall} object
     * @throws SipException if calling the SIP service results in an error or
     *      VOIP API is not supported by the device
     * @see SipAudioCall.Listener#onError
     * @see #isVoipSupported
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.206 -0500", hash_original_method = "7876146B456607658E8063AE5100AB4E", hash_generated_method = "12D4AE3EECF2BCDF0238BD19667308B9")
    
public SipAudioCall makeAudioCall(String localProfileUri,
            String peerProfileUri, SipAudioCall.Listener listener, int timeout)
            throws SipException {
        if (!isVoipSupported(mContext)) {
            throw new SipException("VOIP API is not supported");
        }
        try {
            return makeAudioCall(
                    new SipProfile.Builder(localProfileUri).build(),
                    new SipProfile.Builder(peerProfileUri).build(), listener,
                    timeout);
        } catch (ParseException e) {
            throw new SipException("build SipProfile", e);
        }
    }

    /**
     * Creates a {@link SipAudioCall} to take an incoming call. Before the call
     * is returned, the listener will receive a
     * {@link SipAudioCall.Listener#onRinging}
     * callback.
     *
     * @param incomingCallIntent the incoming call broadcast intent
     * @param listener to listen to the call events from {@link SipAudioCall};
     *      can be null
     * @return a {@link SipAudioCall} object
     * @throws SipException if calling the SIP service results in an error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.209 -0500", hash_original_method = "E0DC1BF0888BDAC076F0EBE49A950610", hash_generated_method = "919D2F282F644DC15CC2600D08129F25")
    
public SipAudioCall takeAudioCall(Intent incomingCallIntent,
            SipAudioCall.Listener listener) throws SipException {
        if (incomingCallIntent == null) {
            throw new SipException("Cannot retrieve session with null intent");
        }

        String callId = getCallId(incomingCallIntent);
        if (callId == null) {
            throw new SipException("Call ID missing in incoming call intent");
        }

        String offerSd = getOfferSessionDescription(incomingCallIntent);
        if (offerSd == null) {
            throw new SipException("Session description missing in incoming "
                    + "call intent");
        }

        try {
            ISipSession session = mSipService.getPendingSession(callId);
            if (session == null) {
                throw new SipException("No pending session for the call");
            }
            SipAudioCall call = new SipAudioCall(
                    mContext, session.getLocalProfile());
            call.attachCall(new SipSession(session), offerSd);
            call.setListener(listener);
            return call;
        } catch (Throwable t) {
            throw new SipException("takeAudioCall()", t);
        }
    }

    /**
     * Manually registers the profile to the corresponding SIP provider for
     * receiving calls.
     * {@link #open(SipProfile, PendingIntent, SipRegistrationListener)} is
     * still needed to be called at least once in order for the SIP service to
     * notify the caller with the {@link android.app.PendingIntent} when an incoming call is
     * received.
     *
     * @param localProfile the SIP profile to register with
     * @param expiryTime registration expiration time (in seconds)
     * @param listener to listen to the registration events
     * @throws SipException if calling the SIP service results in an error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.220 -0500", hash_original_method = "686853C3DB5059E14B851E63F90D72E4", hash_generated_method = "8E9EA7A06A585A493CD111ED84E3DE89")
    
public void register(SipProfile localProfile, int expiryTime,
            SipRegistrationListener listener) throws SipException {
        try {
            ISipSession session = mSipService.createSession(localProfile,
                    createRelay(listener, localProfile.getUriString()));
            if (session == null) {
                throw new SipException(
                        "SipService.createSession() returns null");
            }
            session.register(expiryTime);
        } catch (RemoteException e) {
            throw new SipException("register()", e);
        }
    }

    /**
     * Manually unregisters the profile from the corresponding SIP provider for
     * stop receiving further calls. This may interference with the auto
     * registration process in the SIP service if the auto-registration option
     * in the profile is enabled.
     *
     * @param localProfile the SIP profile to register with
     * @param listener to listen to the registration events
     * @throws SipException if calling the SIP service results in an error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.224 -0500", hash_original_method = "4CCD1E71A8A3F25E13404A132CF88582", hash_generated_method = "FC74BA086DC8580A48F5BE9E1EAF38F2")
    
public void unregister(SipProfile localProfile,
            SipRegistrationListener listener) throws SipException {
        try {
            ISipSession session = mSipService.createSession(localProfile,
                    createRelay(listener, localProfile.getUriString()));
            if (session == null) {
                throw new SipException(
                        "SipService.createSession() returns null");
            }
            session.unregister();
        } catch (RemoteException e) {
            throw new SipException("unregister()", e);
        }
    }

    /**
     * Gets the {@link SipSession} that handles the incoming call. For audio
     * calls, consider to use {@link SipAudioCall} to handle the incoming call.
     * See {@link #takeAudioCall}. Note that the method may be called only once
     * for the same intent. For subsequent calls on the same intent, the method
     * returns null.
     *
     * @param incomingCallIntent the incoming call broadcast intent
     * @return the session object that handles the incoming call
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.226 -0500", hash_original_method = "EDCDF2FC84E74B60CE6B84F2ED6BCA20", hash_generated_method = "C977213B7D15E378A034987AAE287794")
    
public SipSession getSessionFor(Intent incomingCallIntent)
            throws SipException {
        try {
            String callId = getCallId(incomingCallIntent);
            ISipSession s = mSipService.getPendingSession(callId);
            return ((s == null) ? null : new SipSession(s));
        } catch (RemoteException e) {
            throw new SipException("getSessionFor()", e);
        }
    }

    /**
     * Creates a {@link SipSession} with the specified profile. Use other
     * methods, if applicable, instead of interacting with {@link SipSession}
     * directly.
     *
     * @param localProfile the SIP profile the session is associated with
     * @param listener to listen to SIP session events
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.230 -0500", hash_original_method = "EE079117FAD2E68EE193F65B6013BB2B", hash_generated_method = "DF84589C1FBA8138B7A6A7F77D78B9D6")
    
public SipSession createSipSession(SipProfile localProfile,
            SipSession.Listener listener) throws SipException {
        try {
            ISipSession s = mSipService.createSession(localProfile, null);
            if (s == null) {
                throw new SipException(
                        "Failed to create SipSession; network unavailable?");
            }
            return new SipSession(s, listener);
        } catch (RemoteException e) {
            throw new SipException("createSipSession()", e);
        }
    }

    /**
     * Gets the list of profiles hosted by the SIP service. The user information
     * (username, password and display name) are crossed out.
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:28.232 -0500", hash_original_method = "1735A7464BE0976B91AB92297644D35E", hash_generated_method = "2E9A676A61C75A93778AB6EFD769CCB2")
    
public SipProfile[] getListOfProfiles() {
        try {
            return mSipService.getListOfProfiles();
        } catch (RemoteException e) {
            return new SipProfile[0];
        }
    }
}

