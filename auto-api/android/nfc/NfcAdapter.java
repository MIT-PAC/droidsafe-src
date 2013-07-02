package android.nfc;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.132 -0400", hash_original_field = "11781F6194F8930ED75DD00D22475BDB", hash_generated_field = "35B3C2E1A1D38F975F8DF16795973C35")

    NfcActivityManager mNfcActivityManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.132 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.133 -0400", hash_original_method = "C4AF3477B0D281733AFB736BB9D4035F", hash_generated_method = "30D49F121006E5986523C8D7A73A0AB0")
      NfcAdapter(Context context) {
        mContext = context;
        mNfcActivityManager = new NfcActivityManager(this);
        
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.135 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "8317E53C1FE64B5134D77D6B25F84FD4")
    public Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_232971793 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_232971793 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_232971793.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_232971793;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.137 -0400", hash_original_method = "5DC17A5CA100E57D93FCA0A10242D110", hash_generated_method = "DCBCF40D4D7F91A92A33D3D46A56C236")
    public INfcAdapter getService() {
        INfcAdapter varB4EAC82CA7396A68D541C85D26508E83_2000740135 = null; 
        isEnabled();
        varB4EAC82CA7396A68D541C85D26508E83_2000740135 = sService;
        varB4EAC82CA7396A68D541C85D26508E83_2000740135.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2000740135;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.137 -0400", hash_original_method = "1AA3314EB2D88084AC95E9F76A714199", hash_generated_method = "94A530C420F902E0BCBCE42EC14F9AA0")
    public INfcTag getTagService() {
        INfcTag varB4EAC82CA7396A68D541C85D26508E83_1817244382 = null; 
        isEnabled();
        varB4EAC82CA7396A68D541C85D26508E83_1817244382 = sTagService;
        varB4EAC82CA7396A68D541C85D26508E83_1817244382.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1817244382;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.138 -0400", hash_original_method = "8B420ADA6778D8BC08D2E0440E69F337", hash_generated_method = "DBDADDFB0BD9BE2A99A0285F599743A6")
    public void attemptDeadServiceRecovery(Exception e) {
        INfcAdapter service = getServiceInterface();
        sService = service;
        try 
        {
            sTagService = service.getNfcTagInterface();
        } 
        catch (RemoteException ee)
        { }
        addTaint(e.getTaint());
        
        
        
        
            
            
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.138 -0400", hash_original_method = "7D7BBD1D80D27F2FA89C3E978875F335", hash_generated_method = "998C08FCF8C94B65E2C5D3D956F3409A")
    public boolean isEnabled() {
        try 
        {
            boolean var9B2C015C131CB94BEE2438D1D075B98D_1718857915 = (sService.getState() == STATE_ON);
        } 
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_839227549 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_839227549;
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.139 -0400", hash_original_method = "928B269965D2C98169E42755C4D77176", hash_generated_method = "A8FA407B3645EF39433FE2FB968EDB05")
    public int getAdapterState() {
        try 
        {
            int var6449D0D3156979B73A59EC4ECBBA4C78_2121633374 = (sService.getState());
        } 
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1610851360 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1610851360;
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.139 -0400", hash_original_method = "1A932A08F1F08387DBC22C33FE8F21F7", hash_generated_method = "30BF97BB38BE2C1A249F72D1C782EB6C")
    public boolean enable() {
        try 
        {
            boolean var94A6AC21F9F97AA82B3508BC1013B2F8_1425330445 = (sService.enable());
        } 
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_470997977 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_470997977;
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.139 -0400", hash_original_method = "C2CC7D959D4121C24D40293E0B89029D", hash_generated_method = "A42C538DCE49FE865633E76184DA9333")
    public boolean disable() {
        try 
        {
            boolean var9B2DAF29C8816F81E7CE2B74803B55C0_664746637 = (sService.disable());
        } 
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1885204518 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1885204518;
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.144 -0400", hash_original_method = "A1E6832BF1F30CB75C5E3838CB4EB39F", hash_generated_method = "51349B9D0B5E2614191C282065816AD3")
    public void setNdefPushMessage(NdefMessage message, Activity activity,
            Activity ... activities) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("activity cannot be null");
        } 
        mNfcActivityManager.setNdefPushMessage(activity, message);
        {
            Activity a = activities[0];
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException("activities cannot contain null");
                } 
                mNfcActivityManager.setNdefPushMessage(a, message);
            } 
        } 
        addTaint(message.getTaint());
        addTaint(activity.getTaint());
        addTaint(activities[0].getTaint());
        
        
            
        
        
        
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.149 -0400", hash_original_method = "B0650F3F4DF141FA2A729CEDE59567AC", hash_generated_method = "8D6334B446E93D41EC7DFD7EE7540C9C")
    public void setNdefPushMessageCallback(CreateNdefMessageCallback callback, Activity activity,
            Activity ... activities) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("activity cannot be null");
        } 
        mNfcActivityManager.setNdefPushMessageCallback(activity, callback);
        {
            Activity a = activities[0];
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException("activities cannot contain null");
                } 
                mNfcActivityManager.setNdefPushMessageCallback(a, callback);
            } 
        } 
        addTaint(callback.getTaint());
        addTaint(activity.getTaint());
        addTaint(activities[0].getTaint());
        
        
            
        
        
        
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.154 -0400", hash_original_method = "4C0E012E0D16CCB4DEFB75A7779BC5C8", hash_generated_method = "67E637D43045AAA34FC05AF3656D44F2")
    public void setOnNdefPushCompleteCallback(OnNdefPushCompleteCallback callback,
            Activity activity, Activity ... activities) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("activity cannot be null");
        } 
        mNfcActivityManager.setOnNdefPushCompleteCallback(activity, callback);
        {
            Activity a = activities[0];
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException("activities cannot contain null");
                } 
                mNfcActivityManager.setOnNdefPushCompleteCallback(a, callback);
            } 
        } 
        addTaint(callback.getTaint());
        addTaint(activity.getTaint());
        addTaint(activities[0].getTaint());
        
        
            
        
        
        
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.154 -0400", hash_original_method = "7DFF841E004C0B63DC3E7B85FC7B1907", hash_generated_method = "2DC02E7606CDE63B9054E3CEC5DCD0C0")
    public void enableForegroundDispatch(Activity activity, PendingIntent intent,
            IntentFilter[] filters, String[][] techLists) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        {
            boolean var61F963C719C1888518BA6D81025614C4_602076866 = (!activity.isResumed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Foreground dispatch can only be enabled " +
                    "when your activity is resumed");
            } 
        } 
        try 
        {
            TechListParcel parcel = null;
            {
                parcel = new TechListParcel(techLists);
            } 
            ActivityThread.currentActivityThread().registerOnActivityPausedListener(activity,
                    mForegroundDispatchListener);
            sService.setForegroundDispatch(intent, filters, parcel);
        } 
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
        } 
        addTaint(activity.getTaint());
        addTaint(intent.getTaint());
        addTaint(filters[0].getTaint());
        addTaint(techLists[0][0].getTaint());
        
        
            
        
        
            
                    
        
        
            
            
                
            
            
                    
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.155 -0400", hash_original_method = "18ACF5FE6AECAA88942AA43DE81790DE", hash_generated_method = "DBCFFA1C40F0664F47AA2058D0E31B47")
    public void disableForegroundDispatch(Activity activity) {
        ActivityThread.currentActivityThread().unregisterOnActivityPausedListener(activity,
                mForegroundDispatchListener);
        disableForegroundDispatchInternal(activity, false);
        addTaint(activity.getTaint());
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.155 -0400", hash_original_method = "3391D46AA688F0DFABC27A2628A920CB", hash_generated_method = "6B79DF16EDDB703218C9AB75ABE6A34B")
     void disableForegroundDispatchInternal(Activity activity, boolean force) {
        try 
        {
            sService.setForegroundDispatch(null, null, null);
            {
                boolean varF44EE87051A2BD05389486D14407BE35_1867543385 = (!force && !activity.isResumed());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("You must disable foreground dispatching " +
                        "while your activity is still resumed");
                } 
            } 
        } 
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
        } 
        addTaint(activity.getTaint());
        addTaint(force);
        
        
            
            
                
                        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.156 -0400", hash_original_method = "6149A052111CDC5E5BB88FC2B2B826FC", hash_generated_method = "0F50D07EA5A5B6E5B90D3E5A3BB3FC13")
    @Deprecated
    public void enableForegroundNdefPush(Activity activity, NdefMessage message) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        enforceResumed(activity);
        mNfcActivityManager.setNdefPushMessage(activity, message);
        addTaint(activity.getTaint());
        addTaint(message.getTaint());
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.156 -0400", hash_original_method = "D87492DD9C8E48B40BF8DEA34B5D588A", hash_generated_method = "96F8D47DB623D7C048FB5BCE15414E08")
    public void disableForegroundNdefPush(Activity activity) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        enforceResumed(activity);
        mNfcActivityManager.setNdefPushMessage(activity, null);
        mNfcActivityManager.setNdefPushMessageCallback(activity, null);
        mNfcActivityManager.setOnNdefPushCompleteCallback(activity, null);
        addTaint(activity.getTaint());
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.175 -0400", hash_original_method = "61512909C8D6C025A83A4E62D3CEE407", hash_generated_method = "FA91AE1E592341BA85ADAE2467F0BA38")
    @Deprecated
    public void enableForegroundNdefPush(Activity activity, final NdefPushCallback callback) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        enforceResumed(activity);
        LegacyCallbackWrapper callbackWrapper = new LegacyCallbackWrapper(callback);
        mNfcActivityManager.setNdefPushMessageCallback(activity, callbackWrapper);
        mNfcActivityManager.setOnNdefPushCompleteCallback(activity, callbackWrapper);
        addTaint(activity.getTaint());
        addTaint(callback.getTaint());
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.175 -0400", hash_original_method = "D0E93F9BEA709C21A3E1070B6361A93C", hash_generated_method = "16D9C68324ACBA80B372842990DB35FF")
    public boolean enableNdefPush() {
        try 
        {
            boolean var1C97FF4517A05CA1B5AB7AF9B34BD479_1135043126 = (sService.enableNdefPush());
        } 
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_47581779 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_47581779;
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.175 -0400", hash_original_method = "D8D13AD2FDADF22949A24C8F8EF157C1", hash_generated_method = "51B4310AA3D0FECAB04C4B62E4CF2371")
    public boolean disableNdefPush() {
        try 
        {
            boolean var7FC0C61F6E9FE1578E3A4E1BAA577792_1309101590 = (sService.disableNdefPush());
        } 
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_481971340 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_481971340;
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.176 -0400", hash_original_method = "94A881D4AB3515CFCD4651DB6D7A2223", hash_generated_method = "CC5FCBFDB1D3F40939EFC96F82684878")
    public boolean isNdefPushEnabled() {
        try 
        {
            boolean varD08156D55243F22D33636CAEA468845B_1644387870 = (sService.isNdefPushEnabled());
        } 
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1604930039 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1604930039;
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.177 -0400", hash_original_method = "AC9BE1816495D76DB77DE4C0C93B101E", hash_generated_method = "0DE8DDCF4F0FEAEC5366C79947F44DAE")
    public INfcAdapterExtras getNfcAdapterExtrasInterface() {
        INfcAdapterExtras varB4EAC82CA7396A68D541C85D26508E83_271052924 = null; 
        INfcAdapterExtras varB4EAC82CA7396A68D541C85D26508E83_137213643 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("You need a context on NfcAdapter to use the "
                    + " NFC extras APIs");
        } 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_271052924 = sService.getNfcAdapterExtrasInterface(mContext.getPackageName());
        } 
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
            varB4EAC82CA7396A68D541C85D26508E83_137213643 = null;
        } 
        INfcAdapterExtras varA7E53CE21691AB073D9660D615818899_1563671646; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1563671646 = varB4EAC82CA7396A68D541C85D26508E83_271052924;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1563671646 = varB4EAC82CA7396A68D541C85D26508E83_137213643;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1563671646.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1563671646;
        
        
            
                    
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.177 -0400", hash_original_method = "219F2FC6E26DD458668CD53974B46E26", hash_generated_method = "79793ED66CDDA39E20E8C047055D9EC3")
     void enforceResumed(Activity activity) {
        {
            boolean var61F963C719C1888518BA6D81025614C4_2128912551 = (!activity.isResumed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("API cannot be called while activity is paused");
            } 
        } 
        addTaint(activity.getTaint());
        
        
            
        
    }

    
    static final class LegacyCallbackWrapper implements CreateNdefMessageCallback, OnNdefPushCompleteCallback {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.177 -0400", hash_original_field = "68BAA09986A995ECA579C1C3F2CA43D3", hash_generated_field = "C7B0DB97242B1A2CD9ADF6D51253FEC6")

        NdefPushCallback mLegacyCallback;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.178 -0400", hash_original_method = "6BEF15BCF15DD0D85DE3520BB316E0D4", hash_generated_method = "21E11278C209B656E61A1BA349ACB39A")
          LegacyCallbackWrapper(NdefPushCallback legacyCallback) {
            mLegacyCallback = legacyCallback;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.178 -0400", hash_original_method = "D841E457F2B17E12C1E2098B1C645A79", hash_generated_method = "DE2859A882AB04BA5FBC6AF833946175")
        @Override
        public void onNdefPushComplete(NfcEvent event) {
            
            mLegacyCallback.onMessagePushed();
            addTaint(event.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.178 -0400", hash_original_method = "FCA6320615812CADE55DD6047E7D7630", hash_generated_method = "30B89F7A0F36A414FB4E1703CBC799D9")
        @Override
        public NdefMessage createNdefMessage(NfcEvent event) {
            NdefMessage varB4EAC82CA7396A68D541C85D26508E83_473648761 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_473648761 = mLegacyCallback.createMessage();
            addTaint(event.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_473648761.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_473648761;
            
            
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.179 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "B5A60E2FA52639EB51E0CC65701892A4")

    static final String TAG = "NFC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.179 -0400", hash_original_field = "BBCAAF7A6BB4164CED9FE0085D3B96EF", hash_generated_field = "12E09594F7A717118A3DADA24A701917")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_NDEF_DISCOVERED = "android.nfc.action.NDEF_DISCOVERED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.179 -0400", hash_original_field = "389ED5DFDA100510247D71E900BEE0FC", hash_generated_field = "421DFCD0950F69398DB7B948AD45CD3D")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_TECH_DISCOVERED = "android.nfc.action.TECH_DISCOVERED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.179 -0400", hash_original_field = "EAC6D60264575BCCDB78233863641967", hash_generated_field = "6C611E0AE33420401C802C4D28DAF2D8")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_TAG_DISCOVERED = "android.nfc.action.TAG_DISCOVERED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.179 -0400", hash_original_field = "E12A67E7317687E272FF20692CE79ACE", hash_generated_field = "05DA916FF7DE9C6A5E3D0ED553A216B2")

    public static final String ACTION_TAG_LEFT_FIELD = "android.nfc.action.TAG_LOST";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.179 -0400", hash_original_field = "B2AA4477E41C3D08AE974DC9DFBEB3C0", hash_generated_field = "864FDBA549D69F45DE502B8133671865")

    public static final String EXTRA_TAG = "android.nfc.extra.TAG";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.179 -0400", hash_original_field = "AAE1680F083B9048EB2990BC2C0475CB", hash_generated_field = "B8A498585D958ACF371A30D7A693AF39")

    public static final String EXTRA_NDEF_MESSAGES = "android.nfc.extra.NDEF_MESSAGES";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.179 -0400", hash_original_field = "B1D4035C008D1A17FE88B2A11F232B62", hash_generated_field = "9AFE253D7BCA0B91EEBBA17305076401")

    public static final String EXTRA_ID = "android.nfc.extra.ID";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.179 -0400", hash_original_field = "BD30416007FD045B23F88E67DF9A65BC", hash_generated_field = "64EAD31FCC5D8863D42B912D821EC041")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_ADAPTER_STATE_CHANGED =
            "android.nfc.action.ADAPTER_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.179 -0400", hash_original_field = "95AFECFB12145D62B88111622C2CF93B", hash_generated_field = "5610F9B2EBB4FB9B1E6D234598ECA413")

    public static final String EXTRA_ADAPTER_STATE = "android.nfc.extra.ADAPTER_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.179 -0400", hash_original_field = "0A53D89ED725A061255F15DE04453C0F", hash_generated_field = "501F4A67DD89031B57A5BA8625CF46AC")

    public static final int STATE_OFF = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.179 -0400", hash_original_field = "5AD7C406039106B63B2813040FCCE645", hash_generated_field = "09B2FFE38FB2948139C918D224403C50")

    public static final int STATE_TURNING_ON = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.179 -0400", hash_original_field = "2434AE8CED23C865189AE860BB6CC36A", hash_generated_field = "4D3064FE8FD25755AD9FCE56B0968A76")

    public static final int STATE_ON = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.179 -0400", hash_original_field = "787EE4347FF30A418AB554F78013C338", hash_generated_field = "66FFFDE84846BF12D6E7B1556699CCE2")

    public static final int STATE_TURNING_OFF = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.179 -0400", hash_original_field = "2D97EC3B76910B149F69BDEF7C5EC755", hash_generated_field = "F9BB84E3D4C91D00C4A915F1D24BE4F8")

    static boolean sIsInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.179 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "41D15F90E751870BA8CE193EE4F4BAD4")

    static INfcAdapter sService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.179 -0400", hash_original_field = "6DE46BB21844BCA0E34002FC9E3D3A55", hash_generated_field = "2233B419DEF0D6D6964CA486B17F24A6")

    static INfcTag sTagService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.179 -0400", hash_original_field = "D511F14CF57E503C61C29EBE5986FE9C", hash_generated_field = "43AC8A4224DE3385E9255D2280FEE77B")

    static HashMap<Context, NfcAdapter> sNfcAdapters = new HashMap();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.179 -0400", hash_original_field = "83A0202946E64804ABA88F9B3361A49F", hash_generated_field = "DF70B7C03DCF051010C92018533E7115")

    static NfcAdapter sNullContextNfcAdapter;
}

