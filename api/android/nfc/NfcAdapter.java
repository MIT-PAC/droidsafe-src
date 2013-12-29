package android.nfc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;

import java.util.HashMap;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.app.Activity;
import android.app.ActivityThread;
import android.app.OnActivityPausedListener;
import android.app.PendingIntent;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;





public final class NfcAdapter {

    /**
     * Helper to check if this device has FEATURE_NFC, but without using
     * a context.
     * Equivalent to
     * context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_NFC)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.615 -0500", hash_original_method = "EB029713530469167365B3658B6FC47E", hash_generated_method = "679B5280429AEA728A25AE4EF9C45DBC")
    private static boolean hasNfcFeature() {
        IPackageManager pm = ActivityThread.getPackageManager();
        if (pm == null) {
            Log.e(TAG, "Cannot get package manager, assuming no NFC feature");
            return false;
        }
        try {
            return pm.hasSystemFeature(PackageManager.FEATURE_NFC);
        } catch (RemoteException e) {
            Log.e(TAG, "Package manager query failed, assuming no NFC feature", e);
            return false;
        }
    }

    
    @DSModeled(DSC.SPEC)
    public static synchronized NfcAdapter getNfcAdapter(Context context) {
        if (DroidSafeAndroidRuntime.control) {
           UnsupportedOperationException exc = new UnsupportedOperationException();
        }
        if (context == null) {
            if (sNullContextNfcAdapter == null) {
                sNullContextNfcAdapter = new NfcAdapter(null);
            }
            return sNullContextNfcAdapter;
        }

        NfcAdapter adapter = sNfcAdapters.get(context);
        if (adapter == null) {
            adapter = new NfcAdapter(context);
            sNfcAdapters.put(context, adapter);
        }
        return adapter;
    }

    /** get handle to NFC service interface */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.617 -0500", hash_original_method = "0FFEE716C32FBFB9A0B5A211768219BA", hash_generated_method = "A69D89BB473C479A38B8A821A81439C0")
    private static INfcAdapter getServiceInterface() {
        /* get a handle to NFC service */
        IBinder b = ServiceManager.getService("nfc");
        if (b == null) {
            return null;
        }
        return INfcAdapter.Stub.asInterface(b);
    }

    /**
     * Helper to get the default NFC Adapter.
     * <p>
     * Most Android devices will only have one NFC Adapter (NFC Controller).
     * <p>
     * This helper is the equivalent of:
     * <pre>{@code
     * NfcManager manager = (NfcManager) context.getSystemService(Context.NFC_SERVICE);
     * NfcAdapter adapter = manager.getDefaultAdapter();
     * }</pre>
     * @param context the calling application's context
     *
     * @return the default NFC adapter, or null if no NFC adapter exists
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.618 -0500", hash_original_method = "BBAF054E3A572AA64409457A2C6BC138", hash_generated_method = "5115AE9CECB46ACBA915434EDC27859F")
    public static NfcAdapter getDefaultAdapter(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        context = context.getApplicationContext();
        /* use getSystemService() instead of just instantiating to take
         * advantage of the context's cached NfcManager & NfcAdapter */
        NfcManager manager = (NfcManager) context.getSystemService(Context.NFC_SERVICE);
        if (manager == null) {
            // NFC not available
            return null;
        }
        return manager.getDefaultAdapter();
    }

    /**
     * Legacy NfcAdapter getter, always use {@link #getDefaultAdapter(Context)} instead.<p>
     * This method was deprecated at API level 10 (Gingerbread MR1) because a context is required
     * for many NFC API methods. Those methods will fail when called on an NfcAdapter
     * object created from this method.<p>
     * @deprecated use {@link #getDefaultAdapter(Context)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.619 -0500", hash_original_method = "48A7691839F3163BD41DEB5028DF54C7", hash_generated_method = "00D355938CBC4A736CD55F3604C3ECCB")
    @Deprecated
public static NfcAdapter getDefaultAdapter() {
        Log.w(TAG, "WARNING: NfcAdapter.getDefaultAdapter() is deprecated, use " +
                "NfcAdapter.getDefaultAdapter(Context) instead", new Exception());

        return NfcAdapter.getNfcAdapter(null);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.594 -0500", hash_original_field = "76B42502A850F1BA8F9A78C316486025", hash_generated_field = "B5A60E2FA52639EB51E0CC65701892A4")

    static final String TAG = "NFC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.595 -0500", hash_original_field = "B556699344548323303635D3C515B3B6", hash_generated_field = "12E09594F7A717118A3DADA24A701917")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_NDEF_DISCOVERED = "android.nfc.action.NDEF_DISCOVERED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.596 -0500", hash_original_field = "93070AD8B3837B4B71EC0F00DC42ABB8", hash_generated_field = "421DFCD0950F69398DB7B948AD45CD3D")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_TECH_DISCOVERED = "android.nfc.action.TECH_DISCOVERED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.597 -0500", hash_original_field = "6DA5AFC2842F7EA2D0798E495FF6E507", hash_generated_field = "6C611E0AE33420401C802C4D28DAF2D8")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_TAG_DISCOVERED = "android.nfc.action.TAG_DISCOVERED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.598 -0500", hash_original_field = "58DC5B8507186B8F94BC8D6EA1643E20", hash_generated_field = "05DA916FF7DE9C6A5E3D0ED553A216B2")

    public static final String ACTION_TAG_LEFT_FIELD = "android.nfc.action.TAG_LOST";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.599 -0500", hash_original_field = "FF9B908A8930E493AC4D33A030F9046C", hash_generated_field = "864FDBA549D69F45DE502B8133671865")

    public static final String EXTRA_TAG = "android.nfc.extra.TAG";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.600 -0500", hash_original_field = "DF4C5D05D7919416996E8C3E7DF61778", hash_generated_field = "B8A498585D958ACF371A30D7A693AF39")

    public static final String EXTRA_NDEF_MESSAGES = "android.nfc.extra.NDEF_MESSAGES";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.601 -0500", hash_original_field = "76C644CAB7321CE637A84954169830F2", hash_generated_field = "9AFE253D7BCA0B91EEBBA17305076401")

    public static final String EXTRA_ID = "android.nfc.extra.ID";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.602 -0500", hash_original_field = "7427C04515F5C016CB8523F63DC37FC8", hash_generated_field = "64EAD31FCC5D8863D42B912D821EC041")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_ADAPTER_STATE_CHANGED =
            "android.nfc.action.ADAPTER_STATE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.603 -0500", hash_original_field = "10E4914A677975ECC13B7B77064559BB", hash_generated_field = "5610F9B2EBB4FB9B1E6D234598ECA413")

    public static final String EXTRA_ADAPTER_STATE = "android.nfc.extra.ADAPTER_STATE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.604 -0500", hash_original_field = "DFA817520B4BD2D1F63D38E0170AAAA6", hash_generated_field = "501F4A67DD89031B57A5BA8625CF46AC")

    public static final int STATE_OFF = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.604 -0500", hash_original_field = "EBA28948D041A52778AC30C0E2179E52", hash_generated_field = "09B2FFE38FB2948139C918D224403C50")

    public static final int STATE_TURNING_ON = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.605 -0500", hash_original_field = "5CC75307D8BCC154BBEB956FB3BB7E02", hash_generated_field = "4D3064FE8FD25755AD9FCE56B0968A76")

    public static final int STATE_ON = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.606 -0500", hash_original_field = "95F9057FFCA95A636EFB9A5F7725DE81", hash_generated_field = "66FFFDE84846BF12D6E7B1556699CCE2")

    public static final int STATE_TURNING_OFF = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.608 -0500", hash_original_field = "85B25108193CD96000076C9FEB763F37", hash_generated_field = "F9BB84E3D4C91D00C4A915F1D24BE4F8")

    static boolean sIsInitialized = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:34:10.608 -0500", hash_original_field = "42BFC8F87F5DAA35E2B85F9027E47BF5", hash_generated_field = "651AB749C4ED1A0349F68E271823B3C3")

    // attemptDeadServiceRecovery() when NFC crashes - we accept a best effort
    // recovery
    static INfcAdapter sService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.609 -0500", hash_original_field = "32B868ACD220513B566D230E5282ADC1", hash_generated_field = "2233B419DEF0D6D6964CA486B17F24A6")

    static INfcTag sTagService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.610 -0500", hash_original_field = "B9B707A015CD8AC987CC5B0619A91F7A", hash_generated_field = "43AC8A4224DE3385E9255D2280FEE77B")

    static HashMap<Context, NfcAdapter> sNfcAdapters = new HashMap();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:34:10.610 -0500", hash_original_field = "98BCE2FA4CD149969F933211DFD678A2", hash_generated_field = "1DAC697DF93D7551113C7B2C5A1CB051")


    /**
     * NfcAdapter used with a null context. This ctor was deprecated but we have
     * to support it for backwards compatibility. New methods that require context
     * might throw when called on the null-context NfcAdapter.
     */
    static NfcAdapter sNullContextNfcAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.612 -0500", hash_original_field = "35B3C2E1A1D38F975F8DF16795973C35", hash_generated_field = "35B3C2E1A1D38F975F8DF16795973C35")


     NfcActivityManager mNfcActivityManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.612 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

     Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.133 -0400", hash_original_field = "158683AE178C4CD4D4CD46B2CA281B7C", hash_generated_field = "5ABD4D31FC9F42AC1531FBC9E85DB3FF")

    OnActivityPausedListener mForegroundDispatchListener = new OnActivityPausedListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.133 -0400", hash_original_method = "20720EE87497F4AA75409509758C29CB", hash_generated_method = "CCDF3879995637CE1FE9CE6838EC2B7B")
        @Override
        public void onPaused(Activity activity) {
            
            disableForegroundDispatchInternal(activity, true);
            addTaint(activity.getTaint());
            
            
        }

        
};

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.620 -0500", hash_original_method = "C4AF3477B0D281733AFB736BB9D4035F", hash_generated_method = "C4AF3477B0D281733AFB736BB9D4035F")
    NfcAdapter(Context context) {
        mContext = context;
        mNfcActivityManager = new NfcActivityManager(this);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.621 -0500", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "BA026F6873AF9B17E96AB49AFB6CEE03")
    public Context getContext() {
        return mContext;
    }

    /**
     * Returns the binder interface to the service.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.621 -0500", hash_original_method = "5DC17A5CA100E57D93FCA0A10242D110", hash_generated_method = "67BDEEAF74AD8E7AA4D695CD3950CDFF")
    public INfcAdapter getService() {
        isEnabled();  // NOP call to recover sService if it is stale
        return sService;
    }

    /**
     * Returns the binder interface to the tag service.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.622 -0500", hash_original_method = "1AA3314EB2D88084AC95E9F76A714199", hash_generated_method = "9F6A59069E733103F62E8135C7AA16B9")
    public INfcTag getTagService() {
        isEnabled();  // NOP call to recover sTagService if it is stale
        return sTagService;
    }

    
    static final class LegacyCallbackWrapper implements CreateNdefMessageCallback, OnNdefPushCompleteCallback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.638 -0500", hash_original_field = "C7B0DB97242B1A2CD9ADF6D51253FEC6", hash_generated_field = "C7B0DB97242B1A2CD9ADF6D51253FEC6")

         NdefPushCallback mLegacyCallback;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.639 -0500", hash_original_method = "6BEF15BCF15DD0D85DE3520BB316E0D4", hash_generated_method = "6BEF15BCF15DD0D85DE3520BB316E0D4")
        LegacyCallbackWrapper(NdefPushCallback legacyCallback) {
            mLegacyCallback = legacyCallback;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.640 -0500", hash_original_method = "D841E457F2B17E12C1E2098B1C645A79", hash_generated_method = "E9AF1347D2C2208247823B1D0D9EDCA5")
        @Override
public void onNdefPushComplete(NfcEvent event) {
            mLegacyCallback.onMessagePushed();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.640 -0500", hash_original_method = "FCA6320615812CADE55DD6047E7D7630", hash_generated_method = "1ACCC19FA75F6B9C1DD23063F7120C64")
        @Override
public NdefMessage createNdefMessage(NfcEvent event) {
            return mLegacyCallback.createMessage();
        }

        
    }


    
    public interface OnNdefPushCompleteCallback {
        
        public void onNdefPushComplete(NfcEvent event);
    }
    
    public interface CreateNdefMessageCallback {
        
        public NdefMessage createNdefMessage(NfcEvent event);
    }
    
    @Deprecated public interface NdefPushCallback {
        
        @Deprecated
        NdefMessage createMessage();
        
        @Deprecated
        void onMessagePushed();
    }

    /**
     * NFC service dead - attempt best effort recovery
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.623 -0500", hash_original_method = "8B420ADA6778D8BC08D2E0440E69F337", hash_generated_method = "8A11DC2539ACC515F2B1C9FA87D3843E")
    public void attemptDeadServiceRecovery(Exception e) {
        Log.e(TAG, "NFC service dead - attempting to recover", e);
        INfcAdapter service = getServiceInterface();
        if (service == null) {
            Log.e(TAG, "could not retrieve NFC service during service recovery");
            // nothing more can be done now, sService is still stale, we'll hit
            // this recovery path again later
            return;
        }
        // assigning to sService is not thread-safe, but this is best-effort code
        // and on a well-behaved system should never happen
        sService = service;
        try {
            sTagService = service.getNfcTagInterface();
        } catch (RemoteException ee) {
            Log.e(TAG, "could not retrieve NFC tag service during service recovery");
            // nothing more can be done now, sService is still stale, we'll hit
            // this recovery path again later
        }

        return;
    }

    /**
     * Return true if this NFC Adapter has any features enabled.
     *
     * <p>Application may use this as a helper to suggest that the user
     * should turn on NFC in Settings.
     * <p>If this method returns false, the NFC hardware is guaranteed not to
     * generate or respond to any NFC transactions.
     *
     * @return true if this NFC Adapter has any features enabled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.624 -0500", hash_original_method = "7D7BBD1D80D27F2FA89C3E978875F335", hash_generated_method = "47231A760E79B9BF2AABBE52B0F725EB")
    public boolean isEnabled() {
        try {
            return sService.getState() == STATE_ON;
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
            return false;
        }
    }

    /**
     * Return the state of this NFC Adapter.
     *
     * <p>Returns one of {@link #STATE_ON}, {@link #STATE_TURNING_ON},
     * {@link #STATE_OFF}, {@link #STATE_TURNING_OFF}.
     *
     * <p>{@link #isEnabled()} is equivalent to
     * <code>{@link #getAdapterState()} == {@link #STATE_ON}</code>
     *
     * @return the current state of this NFC adapter
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.625 -0500", hash_original_method = "928B269965D2C98169E42755C4D77176", hash_generated_method = "333AE0A5C2E08ACB07CD764088133ED1")
    public int getAdapterState() {
        try {
            return sService.getState();
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
            return NfcAdapter.STATE_OFF;
        }
    }

    /**
     * Enable NFC hardware.
     *
     * <p>This call is asynchronous. Listen for
     * {@link #ACTION_ADAPTER_STATE_CHANGED} broadcasts to find out when the
     * operation is complete.
     *
     * <p>If this returns true, then either NFC is already on, or
     * a {@link #ACTION_ADAPTER_STATE_CHANGED} broadcast will be sent
     * to indicate a state transition. If this returns false, then
     * there is some problem that prevents an attempt to turn
     * NFC on (for example we are in airplane mode and NFC is not
     * toggleable in airplane mode on this platform).
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.625 -0500", hash_original_method = "1A932A08F1F08387DBC22C33FE8F21F7", hash_generated_method = "5A3AA53BCC141B0FAE519EBDE31574E1")
    public boolean enable() {
        try {
            return sService.enable();
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
            return false;
        }
    }

    /**
     * Disable NFC hardware.
     *
     * <p>No NFC features will work after this call, and the hardware
     * will not perform or respond to any NFC communication.
     *
     * <p>This call is asynchronous. Listen for
     * {@link #ACTION_ADAPTER_STATE_CHANGED} broadcasts to find out when the
     * operation is complete.
     *
     * <p>If this returns true, then either NFC is already off, or
     * a {@link #ACTION_ADAPTER_STATE_CHANGED} broadcast will be sent
     * to indicate a state transition. If this returns false, then
     * there is some problem that prevents an attempt to turn
     * NFC off.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.626 -0500", hash_original_method = "C2CC7D959D4121C24D40293E0B89029D", hash_generated_method = "15E62F32E4F0F268EB3E4688A1902237")
    public boolean disable() {
        try {
            return sService.disable();
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
            return false;
        }
    }

    /**
     * Set the {@link NdefMessage} to push over NFC during the specified activities.
     *
     * <p>This method may be called at any time, but the NDEF message is
     * only made available for NDEF push when one of the specified activities
     * is in resumed (foreground) state.
     *
     * <p>Only one NDEF message can be pushed by the currently resumed activity.
     * If both {@link #setNdefPushMessage} and
     * {@link #setNdefPushMessageCallback} are set then
     * the callback will take priority.
     *
     * <p>Pass a null NDEF message to disable foreground NDEF push in the
     * specified activities.
     *
     * <p>At least one activity must be specified, and usually only one is necessary.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param message NDEF message to push over NFC, or null to disable
     * @param activity an activity in which NDEF push should be enabled to share the provided
     *                 NDEF message
     * @param activities optional additional activities that should also enable NDEF push with
     *                   the provided NDEF message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.627 -0500", hash_original_method = "A1E6832BF1F30CB75C5E3838CB4EB39F", hash_generated_method = "2801EBC84E285C2B255CCA9C15DB4170")
    public void setNdefPushMessage(NdefMessage message, Activity activity,
            Activity ... activities) {
        if (activity == null) {
            throw new NullPointerException("activity cannot be null");
        }
        mNfcActivityManager.setNdefPushMessage(activity, message);
        for (Activity a : activities) {
            if (a == null) {
                throw new NullPointerException("activities cannot contain null");
            }
            mNfcActivityManager.setNdefPushMessage(a, message);
        }
    }

    /**
     * Set the callback to create a {@link NdefMessage} to push over NFC.
     *
     * <p>This method may be called at any time, but this callback is
     * only made if one of the specified activities
     * is in resumed (foreground) state.
     *
     * <p>Only one NDEF message can be pushed by the currently resumed activity.
     * If both {@link #setNdefPushMessage} and
     * {@link #setNdefPushMessageCallback} are set then
     * the callback will take priority.
     *
     * <p>Pass a null callback to disable the callback in the
     * specified activities.
     *
     * <p>At least one activity must be specified, and usually only one is necessary.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param callback callback, or null to disable
     * @param activity an activity in which NDEF push should be enabled to share an NDEF message
     *                 that's retrieved from the provided callback
     * @param activities optional additional activities that should also enable NDEF push using
     *                   the provided callback
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.628 -0500", hash_original_method = "B0650F3F4DF141FA2A729CEDE59567AC", hash_generated_method = "2346FDDB2041D1DA7877C35531AD6783")
    public void setNdefPushMessageCallback(CreateNdefMessageCallback callback, Activity activity,
            Activity ... activities) {
        if (activity == null) {
            throw new NullPointerException("activity cannot be null");
        }
        mNfcActivityManager.setNdefPushMessageCallback(activity, callback);
        for (Activity a : activities) {
            if (a == null) {
                throw new NullPointerException("activities cannot contain null");
            }
            mNfcActivityManager.setNdefPushMessageCallback(a, callback);
        }
    }

    /**
     * Set the callback on a successful NDEF push over NFC.
     *
     * <p>This method may be called at any time, but NDEF push and this callback
     * can only occur when one of the specified activities is in resumed
     * (foreground) state.
     *
     * <p>One or more activities must be specified.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param callback callback, or null to disable
     * @param activity an activity to enable the callback (at least one is required)
     * @param activities zero or more additional activities to enable to callback
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.629 -0500", hash_original_method = "4C0E012E0D16CCB4DEFB75A7779BC5C8", hash_generated_method = "85267C8B4583C8482B8780F134972F10")
    public void setOnNdefPushCompleteCallback(OnNdefPushCompleteCallback callback,
            Activity activity, Activity ... activities) {
        if (activity == null) {
            throw new NullPointerException("activity cannot be null");
        }
        mNfcActivityManager.setOnNdefPushCompleteCallback(activity, callback);
        for (Activity a : activities) {
            if (a == null) {
                throw new NullPointerException("activities cannot contain null");
            }
            mNfcActivityManager.setOnNdefPushCompleteCallback(a, callback);
        }
    }

    /**
     * Enable foreground dispatch to the given Activity.
     *
     * <p>This will give give priority to the foreground activity when
     * dispatching a discovered {@link Tag} to an application.
     *
     * <p>If any IntentFilters are provided to this method they are used to match dispatch Intents
     * for both the {@link NfcAdapter#ACTION_NDEF_DISCOVERED} and
     * {@link NfcAdapter#ACTION_TAG_DISCOVERED}. Since {@link NfcAdapter#ACTION_TECH_DISCOVERED}
     * relies on meta data outside of the IntentFilter matching for that dispatch Intent is handled
     * by passing in the tech lists separately. Each first level entry in the tech list represents
     * an array of technologies that must all be present to match. If any of the first level sets
     * match then the dispatch is routed through the given PendingIntent. In other words, the second
     * level is ANDed together and the first level entries are ORed together.
     *
     * <p>If you pass {@code null} for both the {@code filters} and {@code techLists} parameters
     * that acts a wild card and will cause the foreground activity to receive all tags via the
     * {@link NfcAdapter#ACTION_TAG_DISCOVERED} intent.
     *
     * <p>This method must be called from the main thread, and only when the activity is in the
     * foreground (resumed). Also, activities must call {@link #disableForegroundDispatch} before
     * the completion of their {@link Activity#onPause} callback to disable foreground dispatch
     * after it has been enabled.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param activity the Activity to dispatch to
     * @param intent the PendingIntent to start for the dispatch
     * @param filters the IntentFilters to override dispatching for, or null to always dispatch
     * @param techLists the tech lists used to perform matching for dispatching of the
     *      {@link NfcAdapter#ACTION_TECH_DISCOVERED} intent
     * @throws IllegalStateException if the Activity is not currently in the foreground
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.630 -0500", hash_original_method = "7DFF841E004C0B63DC3E7B85FC7B1907", hash_generated_method = "070D430D5D9AEFA4114F930CD19E2A91")
    public void enableForegroundDispatch(Activity activity, PendingIntent intent,
            IntentFilter[] filters, String[][] techLists) {
        if (activity == null || intent == null) {
            throw new NullPointerException();
        }
        if (!activity.isResumed()) {
            throw new IllegalStateException("Foreground dispatch can only be enabled " +
                    "when your activity is resumed");
        }
        try {
            TechListParcel parcel = null;
            if (techLists != null && techLists.length > 0) {
                parcel = new TechListParcel(techLists);
            }
            ActivityThread.currentActivityThread().registerOnActivityPausedListener(activity,
                    mForegroundDispatchListener);
            sService.setForegroundDispatch(intent, filters, parcel);
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
        }
    }

    /**
     * Disable foreground dispatch to the given activity.
     *
     * <p>After calling {@link #enableForegroundDispatch}, an activity
     * must call this method before its {@link Activity#onPause} callback
     * completes.
     *
     * <p>This method must be called from the main thread.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param activity the Activity to disable dispatch to
     * @throws IllegalStateException if the Activity has already been paused
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.631 -0500", hash_original_method = "18ACF5FE6AECAA88942AA43DE81790DE", hash_generated_method = "71ECA6B462C079E252759F86E931323D")
    public void disableForegroundDispatch(Activity activity) {
        ActivityThread.currentActivityThread().unregisterOnActivityPausedListener(activity,
                mForegroundDispatchListener);
        disableForegroundDispatchInternal(activity, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.634 -0500", hash_original_method = "3391D46AA688F0DFABC27A2628A920CB", hash_generated_method = "3391D46AA688F0DFABC27A2628A920CB")
    void disableForegroundDispatchInternal(Activity activity, boolean force) {
        try {
            sService.setForegroundDispatch(null, null, null);
            if (!force && !activity.isResumed()) {
                throw new IllegalStateException("You must disable foreground dispatching " +
                        "while your activity is still resumed");
            }
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
        }
    }

    /**
     * Enable NDEF message push over NFC while this Activity is in the foreground.
     *
     * <p>You must explicitly call this method every time the activity is
     * resumed, and you must call {@link #disableForegroundNdefPush} before
     * your activity completes {@link Activity#onPause}.
     *
     * <p>Strongly recommend to use the new {@link #setNdefPushMessage}
     * instead: it automatically hooks into your activity life-cycle,
     * so you do not need to call enable/disable in your onResume/onPause.
     *
     * <p>For NDEF push to function properly the other NFC device must
     * support either NFC Forum's SNEP (Simple Ndef Exchange Protocol), or
     * Android's "com.android.npp" (Ndef Push Protocol). This was optional
     * on Gingerbread level Android NFC devices, but SNEP is mandatory on
     * Ice-Cream-Sandwich and beyond.
     *
     * <p>This method must be called from the main thread.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param activity foreground activity
     * @param message a NDEF Message to push over NFC
     * @throws IllegalStateException if the activity is not currently in the foreground
     * @deprecated use {@link #setNdefPushMessage} instead
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.635 -0500", hash_original_method = "6149A052111CDC5E5BB88FC2B2B826FC", hash_generated_method = "B5F9F8F40EDCBAA9E1922A8584B3F862")
    @Deprecated
public void enableForegroundNdefPush(Activity activity, NdefMessage message) {
        if (activity == null || message == null) {
            throw new NullPointerException();
        }
        enforceResumed(activity);
        mNfcActivityManager.setNdefPushMessage(activity, message);
    }

    /**
     * Disable NDEF message push over P2P.
     *
     * <p>After calling {@link #enableForegroundNdefPush}, an activity
     * must call this method before its {@link Activity#onPause} callback
     * completes.
     *
     * <p>Strongly recommend to use the new {@link #setNdefPushMessage}
     * instead: it automatically hooks into your activity life-cycle,
     * so you do not need to call enable/disable in your onResume/onPause.
     *
     * <p>This method must be called from the main thread.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param activity the Foreground activity
     * @throws IllegalStateException if the Activity has already been paused
     * @deprecated use {@link #setNdefPushMessage} instead
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.636 -0500", hash_original_method = "D87492DD9C8E48B40BF8DEA34B5D588A", hash_generated_method = "8C82D17F1E7BAC177DF80416DABB4CCA")
    public void disableForegroundNdefPush(Activity activity) {
        if (activity == null) {
            throw new NullPointerException();
        }
        enforceResumed(activity);
        mNfcActivityManager.setNdefPushMessage(activity, null);
        mNfcActivityManager.setNdefPushMessageCallback(activity, null);
        mNfcActivityManager.setOnNdefPushCompleteCallback(activity, null);
    }

    /**
     * TODO: Remove this once pre-built apk's (Maps, Youtube etc) are updated
     * @deprecated use {@link #setNdefPushMessageCallback} instead
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.642 -0500", hash_original_method = "61512909C8D6C025A83A4E62D3CEE407", hash_generated_method = "D3C51A3B6F24560B676AB8897CCD66E9")
    @Deprecated
public void enableForegroundNdefPush(Activity activity, final NdefPushCallback callback) {
        if (activity == null || callback == null) {
            throw new NullPointerException();
        }
        enforceResumed(activity);
        LegacyCallbackWrapper callbackWrapper = new LegacyCallbackWrapper(callback);
        mNfcActivityManager.setNdefPushMessageCallback(activity, callbackWrapper);
        mNfcActivityManager.setOnNdefPushCompleteCallback(activity, callbackWrapper);
    }

    /**
     * Enable NDEF Push feature.
     * <p>This API is for the Settings application.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.643 -0500", hash_original_method = "D0E93F9BEA709C21A3E1070B6361A93C", hash_generated_method = "009AFF2E064ED178754602E4701CA4A8")
    public boolean enableNdefPush() {
        try {
            return sService.enableNdefPush();
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
            return false;
        }
    }

    /**
     * Disable NDEF Push feature.
     * <p>This API is for the Settings application.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.644 -0500", hash_original_method = "D8D13AD2FDADF22949A24C8F8EF157C1", hash_generated_method = "2A9627F77288CF19CCF723C7F614425C")
    public boolean disableNdefPush() {
        try {
            return sService.disableNdefPush();
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
            return false;
        }
    }

    /**
     * Return true if NDEF Push feature is enabled.
     * <p>This function can return true even if NFC is currently turned-off.
     * This indicates that NDEF Push is not currently active, but it has
     * been requested by the user and will be active as soon as NFC is turned
     * on.
     * <p>If you want to check if NDEF PUsh sharing is currently active, use
     * <code>{@link #isEnabled()} && {@link #isNdefPushEnabled()}</code>
     *
     * @return true if NDEF Push feature is enabled
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.644 -0500", hash_original_method = "94A881D4AB3515CFCD4651DB6D7A2223", hash_generated_method = "15DFF662420FE1B8A07948A766B67C64")
    public boolean isNdefPushEnabled() {
        try {
            return sService.isNdefPushEnabled();
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
            return false;
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.645 -0500", hash_original_method = "AC9BE1816495D76DB77DE4C0C93B101E", hash_generated_method = "FA2152B5FBA646DF6DD8C402D9DDB792")
    public INfcAdapterExtras getNfcAdapterExtrasInterface() {
        if (mContext == null) {
            throw new UnsupportedOperationException("You need a context on NfcAdapter to use the "
                    + " NFC extras APIs");
        }
        try {
            return sService.getNfcAdapterExtrasInterface(mContext.getPackageName());
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.646 -0500", hash_original_method = "219F2FC6E26DD458668CD53974B46E26", hash_generated_method = "219F2FC6E26DD458668CD53974B46E26")
    void enforceResumed(Activity activity) {
        if (!activity.isResumed()) {
            throw new IllegalStateException("API cannot be called while activity is paused");
        }
    }
}

