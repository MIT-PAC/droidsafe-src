package android.nfc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import android.nfc.tech.MifareClassic;
import android.nfc.tech.Ndef;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcF;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

public final class NfcAdapter {
    NfcActivityManager mNfcActivityManager;
    Context mContext;
    OnActivityPausedListener mForegroundDispatchListener = new OnActivityPausedListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.032 -0400", hash_original_method = "20720EE87497F4AA75409509758C29CB", hash_generated_method = "DE208AAC4364D3F82732CABE38A130F3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onPaused(Activity activity) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(activity.dsTaint);
            disableForegroundDispatchInternal(activity, true);
            // ---------- Original Method ----------
            //disableForegroundDispatchInternal(activity, true);
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.033 -0400", hash_original_method = "C4AF3477B0D281733AFB736BB9D4035F", hash_generated_method = "EB71CFDF878B521569E58952765AD6F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     NfcAdapter(Context context) {
        dsTaint.addTaint(context.dsTaint);
        mNfcActivityManager = new NfcActivityManager(this);
        // ---------- Original Method ----------
        //mContext = context;
        //mNfcActivityManager = new NfcActivityManager(this);
    }

    
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

    
        public static synchronized NfcAdapter getNfcAdapter(Context context) {
        if (!sIsInitialized) {
            if (!hasNfcFeature()) {
                Log.v(TAG, "this device does not have NFC support");
                throw new UnsupportedOperationException();
            }
            sService = getServiceInterface();
            if (sService == null) {
                Log.e(TAG, "could not retrieve NFC service");
                throw new UnsupportedOperationException();
            }
            try {
                sTagService = sService.getNfcTagInterface();
            } catch (RemoteException e) {
                Log.e(TAG, "could not retrieve NFC Tag service");
                throw new UnsupportedOperationException();
            }
            sIsInitialized = true;
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

    
        private static INfcAdapter getServiceInterface() {
        IBinder b = ServiceManager.getService("nfc");
        if (b == null) {
            return null;
        }
        return INfcAdapter.Stub.asInterface(b);
    }

    
        public static NfcAdapter getDefaultAdapter(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        context = context.getApplicationContext();
        NfcManager manager = (NfcManager) context.getSystemService(Context.NFC_SERVICE);
        if (manager == null) {
            return null;
        }
        return manager.getDefaultAdapter();
    }

    
        @Deprecated
    public static NfcAdapter getDefaultAdapter() {
        Log.w(TAG, "WARNING: NfcAdapter.getDefaultAdapter() is deprecated, use " +
                "NfcAdapter.getDefaultAdapter(Context) instead", new Exception());
        return NfcAdapter.getNfcAdapter(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.034 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "DFA42A6C39C27C217BA4B1F8A6817BD5")
    @DSModeled(DSC.SAFE)
    public Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.034 -0400", hash_original_method = "5DC17A5CA100E57D93FCA0A10242D110", hash_generated_method = "E1E7B0F479A68EE69BFBFDB8BB1491B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public INfcAdapter getService() {
        isEnabled();
        return (INfcAdapter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //isEnabled();
        //return sService;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.034 -0400", hash_original_method = "1AA3314EB2D88084AC95E9F76A714199", hash_generated_method = "6347237B8F8F464D99E3CDE34C5C8DD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public INfcTag getTagService() {
        isEnabled();
        return (INfcTag)dsTaint.getTaint();
        // ---------- Original Method ----------
        //isEnabled();
        //return sTagService;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.034 -0400", hash_original_method = "8B420ADA6778D8BC08D2E0440E69F337", hash_generated_method = "BBB34CFF7E2844F5F2B6BE3D9A135772")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void attemptDeadServiceRecovery(Exception e) {
        dsTaint.addTaint(e.dsTaint);
        INfcAdapter service;
        service = getServiceInterface();
        sService = service;
        try 
        {
            sTagService = service.getNfcTagInterface();
        } //End block
        catch (RemoteException ee)
        { }
        // ---------- Original Method ----------
        //Log.e(TAG, "NFC service dead - attempting to recover", e);
        //INfcAdapter service = getServiceInterface();
        //if (service == null) {
            //Log.e(TAG, "could not retrieve NFC service during service recovery");
            //return;
        //}
        //sService = service;
        //try {
            //sTagService = service.getNfcTagInterface();
        //} catch (RemoteException ee) {
            //Log.e(TAG, "could not retrieve NFC tag service during service recovery");
        //}
        //return;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.035 -0400", hash_original_method = "7D7BBD1D80D27F2FA89C3E978875F335", hash_generated_method = "2EEECAE4C8FF8F63A1BEF3645EE6550B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEnabled() {
        try 
        {
            boolean var9B2C015C131CB94BEE2438D1D075B98D_1287008079 = (sService.getState() == STATE_ON);
        } //End block
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sService.getState() == STATE_ON;
        //} catch (RemoteException e) {
            //attemptDeadServiceRecovery(e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.035 -0400", hash_original_method = "928B269965D2C98169E42755C4D77176", hash_generated_method = "62A035E775E403C0AD0511CBAED7AC18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAdapterState() {
        try 
        {
            int var6449D0D3156979B73A59EC4ECBBA4C78_2016049985 = (sService.getState());
        } //End block
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return sService.getState();
        //} catch (RemoteException e) {
            //attemptDeadServiceRecovery(e);
            //return NfcAdapter.STATE_OFF;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.035 -0400", hash_original_method = "1A932A08F1F08387DBC22C33FE8F21F7", hash_generated_method = "6AED19F1F59581F0435D9AB8797B3AAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean enable() {
        try 
        {
            boolean var94A6AC21F9F97AA82B3508BC1013B2F8_2076572176 = (sService.enable());
        } //End block
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sService.enable();
        //} catch (RemoteException e) {
            //attemptDeadServiceRecovery(e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.035 -0400", hash_original_method = "C2CC7D959D4121C24D40293E0B89029D", hash_generated_method = "3D3DE6362B8471B021C2DFBB0E42052D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean disable() {
        try 
        {
            boolean var9B2DAF29C8816F81E7CE2B74803B55C0_959467842 = (sService.disable());
        } //End block
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sService.disable();
        //} catch (RemoteException e) {
            //attemptDeadServiceRecovery(e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.040 -0400", hash_original_method = "A1E6832BF1F30CB75C5E3838CB4EB39F", hash_generated_method = "4D9C1621C5039A2FEBE56A8C0C59127F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setNdefPushMessage(NdefMessage message, Activity activity,
            Activity ... activities) {
        dsTaint.addTaint(message.dsTaint);
        dsTaint.addTaint(activities[0].dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("activity cannot be null");
        } //End block
        mNfcActivityManager.setNdefPushMessage(activity, message);
        {
            Activity a = activities[0];
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException("activities cannot contain null");
                } //End block
                mNfcActivityManager.setNdefPushMessage(a, message);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (activity == null) {
            //throw new NullPointerException("activity cannot be null");
        //}
        //mNfcActivityManager.setNdefPushMessage(activity, message);
        //for (Activity a : activities) {
            //if (a == null) {
                //throw new NullPointerException("activities cannot contain null");
            //}
            //mNfcActivityManager.setNdefPushMessage(a, message);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.045 -0400", hash_original_method = "B0650F3F4DF141FA2A729CEDE59567AC", hash_generated_method = "60514CEEDFBDA82A670F02BA3E1D6FE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setNdefPushMessageCallback(CreateNdefMessageCallback callback, Activity activity,
            Activity ... activities) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(activities[0].dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("activity cannot be null");
        } //End block
        mNfcActivityManager.setNdefPushMessageCallback(activity, callback);
        {
            Activity a = activities[0];
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException("activities cannot contain null");
                } //End block
                mNfcActivityManager.setNdefPushMessageCallback(a, callback);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (activity == null) {
            //throw new NullPointerException("activity cannot be null");
        //}
        //mNfcActivityManager.setNdefPushMessageCallback(activity, callback);
        //for (Activity a : activities) {
            //if (a == null) {
                //throw new NullPointerException("activities cannot contain null");
            //}
            //mNfcActivityManager.setNdefPushMessageCallback(a, callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.052 -0400", hash_original_method = "4C0E012E0D16CCB4DEFB75A7779BC5C8", hash_generated_method = "F77CF193357A304F3589C4AD5282172B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnNdefPushCompleteCallback(OnNdefPushCompleteCallback callback,
            Activity activity, Activity ... activities) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(activities[0].dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("activity cannot be null");
        } //End block
        mNfcActivityManager.setOnNdefPushCompleteCallback(activity, callback);
        {
            Activity a = activities[0];
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException("activities cannot contain null");
                } //End block
                mNfcActivityManager.setOnNdefPushCompleteCallback(a, callback);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (activity == null) {
            //throw new NullPointerException("activity cannot be null");
        //}
        //mNfcActivityManager.setOnNdefPushCompleteCallback(activity, callback);
        //for (Activity a : activities) {
            //if (a == null) {
                //throw new NullPointerException("activities cannot contain null");
            //}
            //mNfcActivityManager.setOnNdefPushCompleteCallback(a, callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.052 -0400", hash_original_method = "7DFF841E004C0B63DC3E7B85FC7B1907", hash_generated_method = "CC6A3B50705E75DC9E41A070D02AECAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enableForegroundDispatch(Activity activity, PendingIntent intent,
            IntentFilter[] filters, String[][] techLists) {
        dsTaint.addTaint(techLists[0][0]);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(filters[0].dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var61F963C719C1888518BA6D81025614C4_1905367976 = (!activity.isResumed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Foreground dispatch can only be enabled " +
                    "when your activity is resumed");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            TechListParcel parcel;
            parcel = null;
            {
                parcel = new TechListParcel(techLists);
            } //End block
            ActivityThread.currentActivityThread().registerOnActivityPausedListener(activity,
                    mForegroundDispatchListener);
            sService.setForegroundDispatch(intent, filters, parcel);
        } //End block
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
        } //End block
        // ---------- Original Method ----------
        //if (activity == null || intent == null) {
            //throw new NullPointerException();
        //}
        //if (!activity.isResumed()) {
            //throw new IllegalStateException("Foreground dispatch can only be enabled " +
                    //"when your activity is resumed");
        //}
        //try {
            //TechListParcel parcel = null;
            //if (techLists != null && techLists.length > 0) {
                //parcel = new TechListParcel(techLists);
            //}
            //ActivityThread.currentActivityThread().registerOnActivityPausedListener(activity,
                    //mForegroundDispatchListener);
            //sService.setForegroundDispatch(intent, filters, parcel);
        //} catch (RemoteException e) {
            //attemptDeadServiceRecovery(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.053 -0400", hash_original_method = "18ACF5FE6AECAA88942AA43DE81790DE", hash_generated_method = "828AC367D136D730AAB2AB1F2BCE7D46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void disableForegroundDispatch(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        ActivityThread.currentActivityThread().unregisterOnActivityPausedListener(activity,
                mForegroundDispatchListener);
        disableForegroundDispatchInternal(activity, false);
        // ---------- Original Method ----------
        //ActivityThread.currentActivityThread().unregisterOnActivityPausedListener(activity,
                //mForegroundDispatchListener);
        //disableForegroundDispatchInternal(activity, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.054 -0400", hash_original_method = "3391D46AA688F0DFABC27A2628A920CB", hash_generated_method = "5CF0E675DB22353EF3FF2D1C28A5E135")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void disableForegroundDispatchInternal(Activity activity, boolean force) {
        dsTaint.addTaint(force);
        dsTaint.addTaint(activity.dsTaint);
        try 
        {
            sService.setForegroundDispatch(null, null, null);
            {
                boolean varF44EE87051A2BD05389486D14407BE35_1835864012 = (!force && !activity.isResumed());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("You must disable foreground dispatching " +
                        "while your activity is still resumed");
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //sService.setForegroundDispatch(null, null, null);
            //if (!force && !activity.isResumed()) {
                //throw new IllegalStateException("You must disable foreground dispatching " +
                        //"while your activity is still resumed");
            //}
        //} catch (RemoteException e) {
            //attemptDeadServiceRecovery(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.055 -0400", hash_original_method = "6149A052111CDC5E5BB88FC2B2B826FC", hash_generated_method = "A74AFCF4922132EF4053173097814FB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void enableForegroundNdefPush(Activity activity, NdefMessage message) {
        dsTaint.addTaint(message.dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        enforceResumed(activity);
        mNfcActivityManager.setNdefPushMessage(activity, message);
        // ---------- Original Method ----------
        //if (activity == null || message == null) {
            //throw new NullPointerException();
        //}
        //enforceResumed(activity);
        //mNfcActivityManager.setNdefPushMessage(activity, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.056 -0400", hash_original_method = "D87492DD9C8E48B40BF8DEA34B5D588A", hash_generated_method = "0E630FDDC6730CAC508A90AF46CF3C92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void disableForegroundNdefPush(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        enforceResumed(activity);
        mNfcActivityManager.setNdefPushMessage(activity, null);
        mNfcActivityManager.setNdefPushMessageCallback(activity, null);
        mNfcActivityManager.setOnNdefPushCompleteCallback(activity, null);
        // ---------- Original Method ----------
        //if (activity == null) {
            //throw new NullPointerException();
        //}
        //enforceResumed(activity);
        //mNfcActivityManager.setNdefPushMessage(activity, null);
        //mNfcActivityManager.setNdefPushMessageCallback(activity, null);
        //mNfcActivityManager.setOnNdefPushCompleteCallback(activity, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.056 -0400", hash_original_method = "61512909C8D6C025A83A4E62D3CEE407", hash_generated_method = "1545094AC41EDAD122EEF9311DD74628")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void enableForegroundNdefPush(Activity activity, final NdefPushCallback callback) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        enforceResumed(activity);
        LegacyCallbackWrapper callbackWrapper;
        callbackWrapper = new LegacyCallbackWrapper(callback);
        mNfcActivityManager.setNdefPushMessageCallback(activity, callbackWrapper);
        mNfcActivityManager.setOnNdefPushCompleteCallback(activity, callbackWrapper);
        // ---------- Original Method ----------
        //if (activity == null || callback == null) {
            //throw new NullPointerException();
        //}
        //enforceResumed(activity);
        //LegacyCallbackWrapper callbackWrapper = new LegacyCallbackWrapper(callback);
        //mNfcActivityManager.setNdefPushMessageCallback(activity, callbackWrapper);
        //mNfcActivityManager.setOnNdefPushCompleteCallback(activity, callbackWrapper);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.057 -0400", hash_original_method = "D0E93F9BEA709C21A3E1070B6361A93C", hash_generated_method = "3D9534B625B5F062DB34FBBBAE95D4F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean enableNdefPush() {
        try 
        {
            boolean var1C97FF4517A05CA1B5AB7AF9B34BD479_146584925 = (sService.enableNdefPush());
        } //End block
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sService.enableNdefPush();
        //} catch (RemoteException e) {
            //attemptDeadServiceRecovery(e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.057 -0400", hash_original_method = "D8D13AD2FDADF22949A24C8F8EF157C1", hash_generated_method = "1BC150ABC628B7E3FD88A0B7A43F1878")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean disableNdefPush() {
        try 
        {
            boolean var7FC0C61F6E9FE1578E3A4E1BAA577792_1044798653 = (sService.disableNdefPush());
        } //End block
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sService.disableNdefPush();
        //} catch (RemoteException e) {
            //attemptDeadServiceRecovery(e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.058 -0400", hash_original_method = "94A881D4AB3515CFCD4651DB6D7A2223", hash_generated_method = "4AE0B341C36BB20952A76C8281E4778D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isNdefPushEnabled() {
        try 
        {
            boolean varD08156D55243F22D33636CAEA468845B_1019329446 = (sService.isNdefPushEnabled());
        } //End block
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sService.isNdefPushEnabled();
        //} catch (RemoteException e) {
            //attemptDeadServiceRecovery(e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.058 -0400", hash_original_method = "AC9BE1816495D76DB77DE4C0C93B101E", hash_generated_method = "6031C0EE0D874CF6C51B3AD307E72566")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public INfcAdapterExtras getNfcAdapterExtrasInterface() {
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("You need a context on NfcAdapter to use the "
                    + " NFC extras APIs");
        } //End block
        try 
        {
            INfcAdapterExtras var1CA40501F8A7B0732F86D990FBA62B35_109151698 = (sService.getNfcAdapterExtrasInterface(mContext.getPackageName()));
        } //End block
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
        } //End block
        return (INfcAdapterExtras)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mContext == null) {
            //throw new UnsupportedOperationException("You need a context on NfcAdapter to use the "
                    //+ " NFC extras APIs");
        //}
        //try {
            //return sService.getNfcAdapterExtrasInterface(mContext.getPackageName());
        //} catch (RemoteException e) {
            //attemptDeadServiceRecovery(e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.058 -0400", hash_original_method = "219F2FC6E26DD458668CD53974B46E26", hash_generated_method = "AD1EB5BB99379857B1E75D6932A362E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void enforceResumed(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        {
            boolean var61F963C719C1888518BA6D81025614C4_133751001 = (!activity.isResumed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("API cannot be called while activity is paused");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!activity.isResumed()) {
            //throw new IllegalStateException("API cannot be called while activity is paused");
        //}
    }

    
    static final class LegacyCallbackWrapper implements CreateNdefMessageCallback, OnNdefPushCompleteCallback {
        NdefPushCallback mLegacyCallback;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.059 -0400", hash_original_method = "6BEF15BCF15DD0D85DE3520BB316E0D4", hash_generated_method = "136DF8F379F2716AC9093A50CAAC47CF")
        @DSModeled(DSC.SAFE)
         LegacyCallbackWrapper(NdefPushCallback legacyCallback) {
            dsTaint.addTaint(legacyCallback.dsTaint);
            // ---------- Original Method ----------
            //mLegacyCallback = legacyCallback;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.059 -0400", hash_original_method = "D841E457F2B17E12C1E2098B1C645A79", hash_generated_method = "128407E443DF726E9153328984814742")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onNdefPushComplete(NfcEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(event.dsTaint);
            mLegacyCallback.onMessagePushed();
            // ---------- Original Method ----------
            //mLegacyCallback.onMessagePushed();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.059 -0400", hash_original_method = "FCA6320615812CADE55DD6047E7D7630", hash_generated_method = "88A90F024AC2165ABBDB2726B57E0B49")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public NdefMessage createNdefMessage(NfcEvent event) {
            dsTaint.addTaint(event.dsTaint);
            NdefMessage var5F7A09813CC82B1E2F37E5BC43350F68_1876404581 = (mLegacyCallback.createMessage());
            return (NdefMessage)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mLegacyCallback.createMessage();
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
    
    static final String TAG = "NFC";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_NDEF_DISCOVERED = "android.nfc.action.NDEF_DISCOVERED";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_TECH_DISCOVERED = "android.nfc.action.TECH_DISCOVERED";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_TAG_DISCOVERED = "android.nfc.action.TAG_DISCOVERED";
    public static final String ACTION_TAG_LEFT_FIELD = "android.nfc.action.TAG_LOST";
    public static final String EXTRA_TAG = "android.nfc.extra.TAG";
    public static final String EXTRA_NDEF_MESSAGES = "android.nfc.extra.NDEF_MESSAGES";
    public static final String EXTRA_ID = "android.nfc.extra.ID";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_ADAPTER_STATE_CHANGED =
            "android.nfc.action.ADAPTER_STATE_CHANGED";
    public static final String EXTRA_ADAPTER_STATE = "android.nfc.extra.ADAPTER_STATE";
    public static final int STATE_OFF = 1;
    public static final int STATE_TURNING_ON = 2;
    public static final int STATE_ON = 3;
    public static final int STATE_TURNING_OFF = 4;
    static boolean sIsInitialized = false;
    static INfcAdapter sService;
    static INfcTag sTagService;
    static HashMap<Context, NfcAdapter> sNfcAdapters = new HashMap();
    static NfcAdapter sNullContextNfcAdapter;
}

