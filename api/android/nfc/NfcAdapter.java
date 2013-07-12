package android.nfc;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.653 -0400", hash_original_field = "11781F6194F8930ED75DD00D22475BDB", hash_generated_field = "35B3C2E1A1D38F975F8DF16795973C35")

    NfcActivityManager mNfcActivityManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.653 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.654 -0400", hash_original_method = "C4AF3477B0D281733AFB736BB9D4035F", hash_generated_method = "30D49F121006E5986523C8D7A73A0AB0")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.656 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "6CAB212FBA4C4567F064914BEAB0FA48")
    public Context getContext() {
Context var178E2AD52D6FBBB503F908168856B574_976022965 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_976022965.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_976022965;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.656 -0400", hash_original_method = "5DC17A5CA100E57D93FCA0A10242D110", hash_generated_method = "D1343EC4DDB9FF5758C66475EB650B8C")
    public INfcAdapter getService() {
        isEnabled();
INfcAdapter var938DAF7C4B8292E45D258C2CDDCCD9C3_1693737592 =         sService;
        var938DAF7C4B8292E45D258C2CDDCCD9C3_1693737592.addTaint(taint);
        return var938DAF7C4B8292E45D258C2CDDCCD9C3_1693737592;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.657 -0400", hash_original_method = "1AA3314EB2D88084AC95E9F76A714199", hash_generated_method = "66322A88CE991E75AF1A11C81F78EFE8")
    public INfcTag getTagService() {
        isEnabled();
INfcTag var95361F532ED5F296684FC2AB649983EC_1863948422 =         sTagService;
        var95361F532ED5F296684FC2AB649983EC_1863948422.addTaint(taint);
        return var95361F532ED5F296684FC2AB649983EC_1863948422;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.658 -0400", hash_original_method = "8B420ADA6778D8BC08D2E0440E69F337", hash_generated_method = "CFB1964E2444680DCD0F6B02BCA09FCC")
    public void attemptDeadServiceRecovery(Exception e) {
        addTaint(e.getTaint());
        INfcAdapter service = getServiceInterface();
    if(service == null)        
        {
            return;
        } 
        sService = service;
        try 
        {
            sTagService = service.getNfcTagInterface();
        } 
        catch (RemoteException ee)
        {
        } 
        return;
        
        
        
        
            
            
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.658 -0400", hash_original_method = "7D7BBD1D80D27F2FA89C3E978875F335", hash_generated_method = "4B10DFDF4CCDA16C49C13E7611C8B1BA")
    public boolean isEnabled() {
        try 
        {
            boolean varCC361E2FB22CF45855688F850C27E53C_518315778 = (sService.getState() == STATE_ON);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1411019097 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1411019097;
        } 
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
            boolean var68934A3E9455FA72420237EB05902327_1518986154 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_402250836 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_402250836;
        } 
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.659 -0400", hash_original_method = "928B269965D2C98169E42755C4D77176", hash_generated_method = "9E7974795A5EF8DB8ADE6070C8505BA4")
    public int getAdapterState() {
        try 
        {
            int var7F03367C92C380A2F1C14F7B990829D7_1473177130 = (sService.getState());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1857969822 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1857969822;
        } 
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
            int varB3CC8A8B913CDC32BBF03AD716A4D656_1215269659 = (NfcAdapter.STATE_OFF);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1527371454 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1527371454;
        } 
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.660 -0400", hash_original_method = "1A932A08F1F08387DBC22C33FE8F21F7", hash_generated_method = "0989E31555BDBB67C623FAC54E9935FC")
    public boolean enable() {
        try 
        {
            boolean varD3C1CFA6F5055200D9D8AC5042182D54_192680011 = (sService.enable());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1613638400 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1613638400;
        } 
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
            boolean var68934A3E9455FA72420237EB05902327_1006718942 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1006945812 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1006945812;
        } 
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.660 -0400", hash_original_method = "C2CC7D959D4121C24D40293E0B89029D", hash_generated_method = "C362EBA4897FFF2FE9571FD5320F0885")
    public boolean disable() {
        try 
        {
            boolean varFCD5C868A0B8451A8803861ABA2A69E5_100760417 = (sService.disable());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_718788745 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_718788745;
        } 
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
            boolean var68934A3E9455FA72420237EB05902327_162431624 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_268271984 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_268271984;
        } 
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.661 -0400", hash_original_method = "A1E6832BF1F30CB75C5E3838CB4EB39F", hash_generated_method = "E1B6B36F285CF06A873733D32099E6F9")
    public void setNdefPushMessage(NdefMessage message, Activity activity,
            Activity ... activities) {
        addTaint(activities[0].getTaint());
        addTaint(activity.getTaint());
        addTaint(message.getTaint());
    if(activity == null)        
        {
            NullPointerException varCF0EA2FBB1ED5EBEBC81DB06EF910DB5_805852018 = new NullPointerException("activity cannot be null");
            varCF0EA2FBB1ED5EBEBC81DB06EF910DB5_805852018.addTaint(taint);
            throw varCF0EA2FBB1ED5EBEBC81DB06EF910DB5_805852018;
        } 
        mNfcActivityManager.setNdefPushMessage(activity, message);
for(Activity a : activities)
        {
    if(a == null)            
            {
                NullPointerException var733F4F427D8A0EDBD91FCC2BC1473083_1359181928 = new NullPointerException("activities cannot contain null");
                var733F4F427D8A0EDBD91FCC2BC1473083_1359181928.addTaint(taint);
                throw var733F4F427D8A0EDBD91FCC2BC1473083_1359181928;
            } 
            mNfcActivityManager.setNdefPushMessage(a, message);
        } 
        
        
            
        
        
        
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.662 -0400", hash_original_method = "B0650F3F4DF141FA2A729CEDE59567AC", hash_generated_method = "E1E586376B90860934FA9D758CE6E64B")
    public void setNdefPushMessageCallback(CreateNdefMessageCallback callback, Activity activity,
            Activity ... activities) {
        addTaint(activities[0].getTaint());
        addTaint(activity.getTaint());
        addTaint(callback.getTaint());
    if(activity == null)        
        {
            NullPointerException varCF0EA2FBB1ED5EBEBC81DB06EF910DB5_1591530363 = new NullPointerException("activity cannot be null");
            varCF0EA2FBB1ED5EBEBC81DB06EF910DB5_1591530363.addTaint(taint);
            throw varCF0EA2FBB1ED5EBEBC81DB06EF910DB5_1591530363;
        } 
        mNfcActivityManager.setNdefPushMessageCallback(activity, callback);
for(Activity a : activities)
        {
    if(a == null)            
            {
                NullPointerException var733F4F427D8A0EDBD91FCC2BC1473083_2000440187 = new NullPointerException("activities cannot contain null");
                var733F4F427D8A0EDBD91FCC2BC1473083_2000440187.addTaint(taint);
                throw var733F4F427D8A0EDBD91FCC2BC1473083_2000440187;
            } 
            mNfcActivityManager.setNdefPushMessageCallback(a, callback);
        } 
        
        
            
        
        
        
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.662 -0400", hash_original_method = "4C0E012E0D16CCB4DEFB75A7779BC5C8", hash_generated_method = "3C8E9D877B75537EC0A98D125B6D34A3")
    public void setOnNdefPushCompleteCallback(OnNdefPushCompleteCallback callback,
            Activity activity, Activity ... activities) {
        addTaint(activities[0].getTaint());
        addTaint(activity.getTaint());
        addTaint(callback.getTaint());
    if(activity == null)        
        {
            NullPointerException varCF0EA2FBB1ED5EBEBC81DB06EF910DB5_1509074014 = new NullPointerException("activity cannot be null");
            varCF0EA2FBB1ED5EBEBC81DB06EF910DB5_1509074014.addTaint(taint);
            throw varCF0EA2FBB1ED5EBEBC81DB06EF910DB5_1509074014;
        } 
        mNfcActivityManager.setOnNdefPushCompleteCallback(activity, callback);
for(Activity a : activities)
        {
    if(a == null)            
            {
                NullPointerException var733F4F427D8A0EDBD91FCC2BC1473083_598294699 = new NullPointerException("activities cannot contain null");
                var733F4F427D8A0EDBD91FCC2BC1473083_598294699.addTaint(taint);
                throw var733F4F427D8A0EDBD91FCC2BC1473083_598294699;
            } 
            mNfcActivityManager.setOnNdefPushCompleteCallback(a, callback);
        } 
        
        
            
        
        
        
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.663 -0400", hash_original_method = "7DFF841E004C0B63DC3E7B85FC7B1907", hash_generated_method = "591C075AEB1210993B438EE084C26196")
    public void enableForegroundDispatch(Activity activity, PendingIntent intent,
            IntentFilter[] filters, String[][] techLists) {
        addTaint(techLists[0][0].getTaint());
        addTaint(filters[0].getTaint());
        addTaint(intent.getTaint());
        addTaint(activity.getTaint());
    if(activity == null || intent == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_997203380 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_997203380.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_997203380;
        } 
    if(!activity.isResumed())        
        {
            IllegalStateException varB2586EF98F77842DA20777812DF98FC3_1986908385 = new IllegalStateException("Foreground dispatch can only be enabled " +
                    "when your activity is resumed");
            varB2586EF98F77842DA20777812DF98FC3_1986908385.addTaint(taint);
            throw varB2586EF98F77842DA20777812DF98FC3_1986908385;
        } 
        try 
        {
            TechListParcel parcel = null;
    if(techLists != null && techLists.length > 0)            
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
        
        
            
        
        
            
                    
        
        
            
            
                
            
            
                    
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.664 -0400", hash_original_method = "18ACF5FE6AECAA88942AA43DE81790DE", hash_generated_method = "DAB8A4571F8E473A419038C9F95E9DA2")
    public void disableForegroundDispatch(Activity activity) {
        addTaint(activity.getTaint());
        ActivityThread.currentActivityThread().unregisterOnActivityPausedListener(activity,
                mForegroundDispatchListener);
        disableForegroundDispatchInternal(activity, false);
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.664 -0400", hash_original_method = "3391D46AA688F0DFABC27A2628A920CB", hash_generated_method = "ABC3F33DE4EB269EF6DA01CF1D37A5D3")
     void disableForegroundDispatchInternal(Activity activity, boolean force) {
        addTaint(force);
        addTaint(activity.getTaint());
        try 
        {
            sService.setForegroundDispatch(null, null, null);
    if(!force && !activity.isResumed())            
            {
                IllegalStateException varCFA7471A5AC7D6E813AE5E0ADEFCCE55_2063371222 = new IllegalStateException("You must disable foreground dispatching " +
                        "while your activity is still resumed");
                varCFA7471A5AC7D6E813AE5E0ADEFCCE55_2063371222.addTaint(taint);
                throw varCFA7471A5AC7D6E813AE5E0ADEFCCE55_2063371222;
            } 
        } 
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
        } 
        
        
            
            
                
                        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.665 -0400", hash_original_method = "6149A052111CDC5E5BB88FC2B2B826FC", hash_generated_method = "E66829FB9A7EF67B74087A48684625D7")
    @Deprecated
    public void enableForegroundNdefPush(Activity activity, NdefMessage message) {
        addTaint(message.getTaint());
        addTaint(activity.getTaint());
    if(activity == null || message == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_477390394 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_477390394.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_477390394;
        } 
        enforceResumed(activity);
        mNfcActivityManager.setNdefPushMessage(activity, message);
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.665 -0400", hash_original_method = "D87492DD9C8E48B40BF8DEA34B5D588A", hash_generated_method = "20BD89FD76E1C117712C23763BB2087C")
    public void disableForegroundNdefPush(Activity activity) {
        addTaint(activity.getTaint());
    if(activity == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1355770844 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1355770844.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1355770844;
        } 
        enforceResumed(activity);
        mNfcActivityManager.setNdefPushMessage(activity, null);
        mNfcActivityManager.setNdefPushMessageCallback(activity, null);
        mNfcActivityManager.setOnNdefPushCompleteCallback(activity, null);
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.665 -0400", hash_original_method = "61512909C8D6C025A83A4E62D3CEE407", hash_generated_method = "ABAEC7E81F42B5E301BA1C8DDD659A08")
    @Deprecated
    public void enableForegroundNdefPush(Activity activity, final NdefPushCallback callback) {
        addTaint(callback.getTaint());
        addTaint(activity.getTaint());
    if(activity == null || callback == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_35124357 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_35124357.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_35124357;
        } 
        enforceResumed(activity);
        LegacyCallbackWrapper callbackWrapper = new LegacyCallbackWrapper(callback);
        mNfcActivityManager.setNdefPushMessageCallback(activity, callbackWrapper);
        mNfcActivityManager.setOnNdefPushCompleteCallback(activity, callbackWrapper);
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.666 -0400", hash_original_method = "D0E93F9BEA709C21A3E1070B6361A93C", hash_generated_method = "3857A5D31F5ED5866856D05812DD6412")
    public boolean enableNdefPush() {
        try 
        {
            boolean varE02BEB5844CA701534F5B85CA0654B2C_1273857154 = (sService.enableNdefPush());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_402825380 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_402825380;
        } 
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
            boolean var68934A3E9455FA72420237EB05902327_336052523 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1768906115 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1768906115;
        } 
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.666 -0400", hash_original_method = "D8D13AD2FDADF22949A24C8F8EF157C1", hash_generated_method = "655B006F03A715B04046B69D297F32FE")
    public boolean disableNdefPush() {
        try 
        {
            boolean var8BA03E77403647B1D417F922F80047EE_1880418418 = (sService.disableNdefPush());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1086039362 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1086039362;
        } 
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
            boolean var68934A3E9455FA72420237EB05902327_72149074 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_628000799 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_628000799;
        } 
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.667 -0400", hash_original_method = "94A881D4AB3515CFCD4651DB6D7A2223", hash_generated_method = "FF458C6670A36AF595DAB31FCD37D60C")
    public boolean isNdefPushEnabled() {
        try 
        {
            boolean varDBD27EFED216468AF5DCC6742D47A68C_1374167303 = (sService.isNdefPushEnabled());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_448170122 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_448170122;
        } 
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
            boolean var68934A3E9455FA72420237EB05902327_1317155685 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_986351248 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_986351248;
        } 
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.667 -0400", hash_original_method = "AC9BE1816495D76DB77DE4C0C93B101E", hash_generated_method = "4869D5C52479FA59163A49B21D457739")
    public INfcAdapterExtras getNfcAdapterExtrasInterface() {
    if(mContext == null)        
        {
            UnsupportedOperationException varC950F527E6C526FA74DB304A2DC00F0C_2044455663 = new UnsupportedOperationException("You need a context on NfcAdapter to use the "
                    + " NFC extras APIs");
            varC950F527E6C526FA74DB304A2DC00F0C_2044455663.addTaint(taint);
            throw varC950F527E6C526FA74DB304A2DC00F0C_2044455663;
        } 
        try 
        {
INfcAdapterExtras var57D052F3D4FA0853A3A8D75F81D61555_1479397752 =             sService.getNfcAdapterExtrasInterface(mContext.getPackageName());
            var57D052F3D4FA0853A3A8D75F81D61555_1479397752.addTaint(taint);
            return var57D052F3D4FA0853A3A8D75F81D61555_1479397752;
        } 
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
INfcAdapterExtras var540C13E9E156B687226421B24F2DF178_1446166861 =             null;
            var540C13E9E156B687226421B24F2DF178_1446166861.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1446166861;
        } 
        
        
            
                    
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.668 -0400", hash_original_method = "219F2FC6E26DD458668CD53974B46E26", hash_generated_method = "F27E498940E46DC43E9B36E382F1BDA8")
     void enforceResumed(Activity activity) {
        addTaint(activity.getTaint());
    if(!activity.isResumed())        
        {
            IllegalStateException var84383A9F11310D2CF8AAB2CF74320295_106855988 = new IllegalStateException("API cannot be called while activity is paused");
            var84383A9F11310D2CF8AAB2CF74320295_106855988.addTaint(taint);
            throw var84383A9F11310D2CF8AAB2CF74320295_106855988;
        } 
        
        
            
        
    }

    
    static final class LegacyCallbackWrapper implements CreateNdefMessageCallback, OnNdefPushCompleteCallback {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.668 -0400", hash_original_field = "68BAA09986A995ECA579C1C3F2CA43D3", hash_generated_field = "C7B0DB97242B1A2CD9ADF6D51253FEC6")

        NdefPushCallback mLegacyCallback;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.669 -0400", hash_original_method = "6BEF15BCF15DD0D85DE3520BB316E0D4", hash_generated_method = "21E11278C209B656E61A1BA349ACB39A")
          LegacyCallbackWrapper(NdefPushCallback legacyCallback) {
            mLegacyCallback = legacyCallback;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.669 -0400", hash_original_method = "D841E457F2B17E12C1E2098B1C645A79", hash_generated_method = "CD0E4C6F116DCF59D10B209EF8EF5FD7")
        @Override
        public void onNdefPushComplete(NfcEvent event) {
            
            addTaint(event.getTaint());
            mLegacyCallback.onMessagePushed();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.670 -0400", hash_original_method = "FCA6320615812CADE55DD6047E7D7630", hash_generated_method = "08A5507070751AD2171A9373146B661C")
        @Override
        public NdefMessage createNdefMessage(NfcEvent event) {
            addTaint(event.getTaint());
NdefMessage varAF42AD55DEAE724D07B6EF46A48CC555_1443282647 =             mLegacyCallback.createMessage();
            varAF42AD55DEAE724D07B6EF46A48CC555_1443282647.addTaint(taint);
            return varAF42AD55DEAE724D07B6EF46A48CC555_1443282647;
            
            
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.670 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "B5A60E2FA52639EB51E0CC65701892A4")

    static final String TAG = "NFC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.670 -0400", hash_original_field = "BBCAAF7A6BB4164CED9FE0085D3B96EF", hash_generated_field = "12E09594F7A717118A3DADA24A701917")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_NDEF_DISCOVERED = "android.nfc.action.NDEF_DISCOVERED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.670 -0400", hash_original_field = "389ED5DFDA100510247D71E900BEE0FC", hash_generated_field = "421DFCD0950F69398DB7B948AD45CD3D")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_TECH_DISCOVERED = "android.nfc.action.TECH_DISCOVERED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.670 -0400", hash_original_field = "EAC6D60264575BCCDB78233863641967", hash_generated_field = "6C611E0AE33420401C802C4D28DAF2D8")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_TAG_DISCOVERED = "android.nfc.action.TAG_DISCOVERED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.671 -0400", hash_original_field = "E12A67E7317687E272FF20692CE79ACE", hash_generated_field = "05DA916FF7DE9C6A5E3D0ED553A216B2")

    public static final String ACTION_TAG_LEFT_FIELD = "android.nfc.action.TAG_LOST";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.671 -0400", hash_original_field = "B2AA4477E41C3D08AE974DC9DFBEB3C0", hash_generated_field = "864FDBA549D69F45DE502B8133671865")

    public static final String EXTRA_TAG = "android.nfc.extra.TAG";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.671 -0400", hash_original_field = "AAE1680F083B9048EB2990BC2C0475CB", hash_generated_field = "B8A498585D958ACF371A30D7A693AF39")

    public static final String EXTRA_NDEF_MESSAGES = "android.nfc.extra.NDEF_MESSAGES";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.671 -0400", hash_original_field = "B1D4035C008D1A17FE88B2A11F232B62", hash_generated_field = "9AFE253D7BCA0B91EEBBA17305076401")

    public static final String EXTRA_ID = "android.nfc.extra.ID";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.671 -0400", hash_original_field = "BD30416007FD045B23F88E67DF9A65BC", hash_generated_field = "64EAD31FCC5D8863D42B912D821EC041")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_ADAPTER_STATE_CHANGED =
            "android.nfc.action.ADAPTER_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.671 -0400", hash_original_field = "95AFECFB12145D62B88111622C2CF93B", hash_generated_field = "5610F9B2EBB4FB9B1E6D234598ECA413")

    public static final String EXTRA_ADAPTER_STATE = "android.nfc.extra.ADAPTER_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.671 -0400", hash_original_field = "0A53D89ED725A061255F15DE04453C0F", hash_generated_field = "501F4A67DD89031B57A5BA8625CF46AC")

    public static final int STATE_OFF = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.671 -0400", hash_original_field = "5AD7C406039106B63B2813040FCCE645", hash_generated_field = "09B2FFE38FB2948139C918D224403C50")

    public static final int STATE_TURNING_ON = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.671 -0400", hash_original_field = "2434AE8CED23C865189AE860BB6CC36A", hash_generated_field = "4D3064FE8FD25755AD9FCE56B0968A76")

    public static final int STATE_ON = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.671 -0400", hash_original_field = "787EE4347FF30A418AB554F78013C338", hash_generated_field = "66FFFDE84846BF12D6E7B1556699CCE2")

    public static final int STATE_TURNING_OFF = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.671 -0400", hash_original_field = "2D97EC3B76910B149F69BDEF7C5EC755", hash_generated_field = "F9BB84E3D4C91D00C4A915F1D24BE4F8")

    static boolean sIsInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.671 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "41D15F90E751870BA8CE193EE4F4BAD4")

    static INfcAdapter sService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.672 -0400", hash_original_field = "6DE46BB21844BCA0E34002FC9E3D3A55", hash_generated_field = "2233B419DEF0D6D6964CA486B17F24A6")

    static INfcTag sTagService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.672 -0400", hash_original_field = "D511F14CF57E503C61C29EBE5986FE9C", hash_generated_field = "43AC8A4224DE3385E9255D2280FEE77B")

    static HashMap<Context, NfcAdapter> sNfcAdapters = new HashMap();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.672 -0400", hash_original_field = "83A0202946E64804ABA88F9B3361A49F", hash_generated_field = "DF70B7C03DCF051010C92018533E7115")

    static NfcAdapter sNullContextNfcAdapter;
}

