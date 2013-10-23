package android.nfc;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.219 -0400", hash_original_field = "11781F6194F8930ED75DD00D22475BDB", hash_generated_field = "35B3C2E1A1D38F975F8DF16795973C35")

    NfcActivityManager mNfcActivityManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.219 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

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
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.220 -0400", hash_original_method = "C4AF3477B0D281733AFB736BB9D4035F", hash_generated_method = "30D49F121006E5986523C8D7A73A0AB0")
      NfcAdapter(Context context) {
        mContext = context;
        mNfcActivityManager = new NfcActivityManager(this);
        // ---------- Original Method ----------
        //mContext = context;
        //mNfcActivityManager = new NfcActivityManager(this);
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.222 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "B6F2A6C19162530AEFD85AD977F6D75A")
    public Context getContext() {
Context var178E2AD52D6FBBB503F908168856B574_1624558705 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_1624558705.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_1624558705;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.223 -0400", hash_original_method = "5DC17A5CA100E57D93FCA0A10242D110", hash_generated_method = "4CCC0C7FBA4406207E8F7B8D13A396BC")
    public INfcAdapter getService() {
        isEnabled();
INfcAdapter var938DAF7C4B8292E45D258C2CDDCCD9C3_77209557 =         sService;
        var938DAF7C4B8292E45D258C2CDDCCD9C3_77209557.addTaint(taint);
        return var938DAF7C4B8292E45D258C2CDDCCD9C3_77209557;
        // ---------- Original Method ----------
        //isEnabled();
        //return sService;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.223 -0400", hash_original_method = "1AA3314EB2D88084AC95E9F76A714199", hash_generated_method = "CCCE49257F984D86939E968E21022363")
    public INfcTag getTagService() {
        isEnabled();
INfcTag var95361F532ED5F296684FC2AB649983EC_792422382 =         sTagService;
        var95361F532ED5F296684FC2AB649983EC_792422382.addTaint(taint);
        return var95361F532ED5F296684FC2AB649983EC_792422382;
        // ---------- Original Method ----------
        //isEnabled();
        //return sTagService;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.224 -0400", hash_original_method = "8B420ADA6778D8BC08D2E0440E69F337", hash_generated_method = "CFB1964E2444680DCD0F6B02BCA09FCC")
    public void attemptDeadServiceRecovery(Exception e) {
        addTaint(e.getTaint());
        INfcAdapter service = getServiceInterface();
        if(service == null)        
        {
            return;
        } //End block
        sService = service;
        try 
        {
            sTagService = service.getNfcTagInterface();
        } //End block
        catch (RemoteException ee)
        {
        } //End block
        return;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.225 -0400", hash_original_method = "7D7BBD1D80D27F2FA89C3E978875F335", hash_generated_method = "C28AB3B9F3871D705574B6689C0F581F")
    public boolean isEnabled() {
        try 
        {
            boolean varCC361E2FB22CF45855688F850C27E53C_1394594027 = (sService.getState() == STATE_ON);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1960619195 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1960619195;
        } //End block
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
            boolean var68934A3E9455FA72420237EB05902327_1052922560 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1126514918 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1126514918;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return sService.getState() == STATE_ON;
        //} catch (RemoteException e) {
            //attemptDeadServiceRecovery(e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.226 -0400", hash_original_method = "928B269965D2C98169E42755C4D77176", hash_generated_method = "705BC86C289C7573BD1BF3BA46EDF806")
    public int getAdapterState() {
        try 
        {
            int var7F03367C92C380A2F1C14F7B990829D7_1084061661 = (sService.getState());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_543907575 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_543907575;
        } //End block
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
            int varB3CC8A8B913CDC32BBF03AD716A4D656_893504093 = (NfcAdapter.STATE_OFF);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1165345678 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1165345678;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return sService.getState();
        //} catch (RemoteException e) {
            //attemptDeadServiceRecovery(e);
            //return NfcAdapter.STATE_OFF;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.227 -0400", hash_original_method = "1A932A08F1F08387DBC22C33FE8F21F7", hash_generated_method = "3F64BC3E34FC39FD92A668355001DA7F")
    public boolean enable() {
        try 
        {
            boolean varD3C1CFA6F5055200D9D8AC5042182D54_993882842 = (sService.enable());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_111961431 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_111961431;
        } //End block
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
            boolean var68934A3E9455FA72420237EB05902327_683546937 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1852106051 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1852106051;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return sService.enable();
        //} catch (RemoteException e) {
            //attemptDeadServiceRecovery(e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.228 -0400", hash_original_method = "C2CC7D959D4121C24D40293E0B89029D", hash_generated_method = "BA916EAAF36598D9484BEEAC88450F63")
    public boolean disable() {
        try 
        {
            boolean varFCD5C868A0B8451A8803861ABA2A69E5_906647893 = (sService.disable());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1677710791 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1677710791;
        } //End block
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
            boolean var68934A3E9455FA72420237EB05902327_606465208 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1177164306 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1177164306;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return sService.disable();
        //} catch (RemoteException e) {
            //attemptDeadServiceRecovery(e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.229 -0400", hash_original_method = "A1E6832BF1F30CB75C5E3838CB4EB39F", hash_generated_method = "E9855AD5E60420EAA76D41B44DF835D3")
    public void setNdefPushMessage(NdefMessage message, Activity activity,
            Activity ... activities) {
        addTaint(activities[0].getTaint());
        addTaint(activity.getTaint());
        addTaint(message.getTaint());
        if(activity == null)        
        {
            NullPointerException varCF0EA2FBB1ED5EBEBC81DB06EF910DB5_2128440631 = new NullPointerException("activity cannot be null");
            varCF0EA2FBB1ED5EBEBC81DB06EF910DB5_2128440631.addTaint(taint);
            throw varCF0EA2FBB1ED5EBEBC81DB06EF910DB5_2128440631;
        } //End block
        mNfcActivityManager.setNdefPushMessage(activity, message);
for(Activity a : activities)
        {
            if(a == null)            
            {
                NullPointerException var733F4F427D8A0EDBD91FCC2BC1473083_1946389898 = new NullPointerException("activities cannot contain null");
                var733F4F427D8A0EDBD91FCC2BC1473083_1946389898.addTaint(taint);
                throw var733F4F427D8A0EDBD91FCC2BC1473083_1946389898;
            } //End block
            mNfcActivityManager.setNdefPushMessage(a, message);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.231 -0400", hash_original_method = "B0650F3F4DF141FA2A729CEDE59567AC", hash_generated_method = "50062652106CD99644002D03603DA6EE")
    public void setNdefPushMessageCallback(CreateNdefMessageCallback callback, Activity activity,
            Activity ... activities) {
        addTaint(activities[0].getTaint());
        addTaint(activity.getTaint());
        addTaint(callback.getTaint());
        if(activity == null)        
        {
            NullPointerException varCF0EA2FBB1ED5EBEBC81DB06EF910DB5_585067377 = new NullPointerException("activity cannot be null");
            varCF0EA2FBB1ED5EBEBC81DB06EF910DB5_585067377.addTaint(taint);
            throw varCF0EA2FBB1ED5EBEBC81DB06EF910DB5_585067377;
        } //End block
        mNfcActivityManager.setNdefPushMessageCallback(activity, callback);
for(Activity a : activities)
        {
            if(a == null)            
            {
                NullPointerException var733F4F427D8A0EDBD91FCC2BC1473083_901204879 = new NullPointerException("activities cannot contain null");
                var733F4F427D8A0EDBD91FCC2BC1473083_901204879.addTaint(taint);
                throw var733F4F427D8A0EDBD91FCC2BC1473083_901204879;
            } //End block
            mNfcActivityManager.setNdefPushMessageCallback(a, callback);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.232 -0400", hash_original_method = "4C0E012E0D16CCB4DEFB75A7779BC5C8", hash_generated_method = "E59AD4998EE80D1A60D46B431B05B157")
    public void setOnNdefPushCompleteCallback(OnNdefPushCompleteCallback callback,
            Activity activity, Activity ... activities) {
        addTaint(activities[0].getTaint());
        addTaint(activity.getTaint());
        addTaint(callback.getTaint());
        if(activity == null)        
        {
            NullPointerException varCF0EA2FBB1ED5EBEBC81DB06EF910DB5_1748803545 = new NullPointerException("activity cannot be null");
            varCF0EA2FBB1ED5EBEBC81DB06EF910DB5_1748803545.addTaint(taint);
            throw varCF0EA2FBB1ED5EBEBC81DB06EF910DB5_1748803545;
        } //End block
        mNfcActivityManager.setOnNdefPushCompleteCallback(activity, callback);
for(Activity a : activities)
        {
            if(a == null)            
            {
                NullPointerException var733F4F427D8A0EDBD91FCC2BC1473083_1171001984 = new NullPointerException("activities cannot contain null");
                var733F4F427D8A0EDBD91FCC2BC1473083_1171001984.addTaint(taint);
                throw var733F4F427D8A0EDBD91FCC2BC1473083_1171001984;
            } //End block
            mNfcActivityManager.setOnNdefPushCompleteCallback(a, callback);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.234 -0400", hash_original_method = "7DFF841E004C0B63DC3E7B85FC7B1907", hash_generated_method = "E4B90372A6BB08D368C684E463406495")
    public void enableForegroundDispatch(Activity activity, PendingIntent intent,
            IntentFilter[] filters, String[][] techLists) {
        addTaint(techLists[0][0].getTaint());
        addTaint(filters[0].getTaint());
        addTaint(intent.getTaint());
        addTaint(activity.getTaint());
        if(activity == null || intent == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1072164652 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1072164652.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1072164652;
        } //End block
        if(!activity.isResumed())        
        {
            IllegalStateException varB2586EF98F77842DA20777812DF98FC3_609276656 = new IllegalStateException("Foreground dispatch can only be enabled " +
                    "when your activity is resumed");
            varB2586EF98F77842DA20777812DF98FC3_609276656.addTaint(taint);
            throw varB2586EF98F77842DA20777812DF98FC3_609276656;
        } //End block
        try 
        {
            TechListParcel parcel = null;
            if(techLists != null && techLists.length > 0)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.237 -0400", hash_original_method = "18ACF5FE6AECAA88942AA43DE81790DE", hash_generated_method = "DAB8A4571F8E473A419038C9F95E9DA2")
    public void disableForegroundDispatch(Activity activity) {
        addTaint(activity.getTaint());
        ActivityThread.currentActivityThread().unregisterOnActivityPausedListener(activity,
                mForegroundDispatchListener);
        disableForegroundDispatchInternal(activity, false);
        // ---------- Original Method ----------
        //ActivityThread.currentActivityThread().unregisterOnActivityPausedListener(activity,
                //mForegroundDispatchListener);
        //disableForegroundDispatchInternal(activity, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.238 -0400", hash_original_method = "3391D46AA688F0DFABC27A2628A920CB", hash_generated_method = "2AA991A35C0854956DB0587AB5288A68")
     void disableForegroundDispatchInternal(Activity activity, boolean force) {
        addTaint(force);
        addTaint(activity.getTaint());
        try 
        {
            sService.setForegroundDispatch(null, null, null);
            if(!force && !activity.isResumed())            
            {
                IllegalStateException varCFA7471A5AC7D6E813AE5E0ADEFCCE55_156604067 = new IllegalStateException("You must disable foreground dispatching " +
                        "while your activity is still resumed");
                varCFA7471A5AC7D6E813AE5E0ADEFCCE55_156604067.addTaint(taint);
                throw varCFA7471A5AC7D6E813AE5E0ADEFCCE55_156604067;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.239 -0400", hash_original_method = "6149A052111CDC5E5BB88FC2B2B826FC", hash_generated_method = "03D6CE00D410E99C4C047DAA6C7BF8AF")
    @Deprecated
    public void enableForegroundNdefPush(Activity activity, NdefMessage message) {
        addTaint(message.getTaint());
        addTaint(activity.getTaint());
        if(activity == null || message == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1854142483 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1854142483.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1854142483;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.240 -0400", hash_original_method = "D87492DD9C8E48B40BF8DEA34B5D588A", hash_generated_method = "FEE1A84897D1A235057700DA9AC0213B")
    public void disableForegroundNdefPush(Activity activity) {
        addTaint(activity.getTaint());
        if(activity == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_483723713 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_483723713.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_483723713;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.240 -0400", hash_original_method = "61512909C8D6C025A83A4E62D3CEE407", hash_generated_method = "ADC625F42C1A8DC9E916687CB9F49F02")
    @Deprecated
    public void enableForegroundNdefPush(Activity activity, final NdefPushCallback callback) {
        addTaint(callback.getTaint());
        addTaint(activity.getTaint());
        if(activity == null || callback == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1128184842 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1128184842.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1128184842;
        } //End block
        enforceResumed(activity);
        LegacyCallbackWrapper callbackWrapper = new LegacyCallbackWrapper(callback);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.241 -0400", hash_original_method = "D0E93F9BEA709C21A3E1070B6361A93C", hash_generated_method = "796FFFA5F29C40FAD115284EBE230989")
    public boolean enableNdefPush() {
        try 
        {
            boolean varE02BEB5844CA701534F5B85CA0654B2C_1888082076 = (sService.enableNdefPush());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1863868501 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1863868501;
        } //End block
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
            boolean var68934A3E9455FA72420237EB05902327_344744842 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1674346018 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1674346018;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return sService.enableNdefPush();
        //} catch (RemoteException e) {
            //attemptDeadServiceRecovery(e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.241 -0400", hash_original_method = "D8D13AD2FDADF22949A24C8F8EF157C1", hash_generated_method = "80717BF042C90DEF0C8087E10C5501E5")
    public boolean disableNdefPush() {
        try 
        {
            boolean var8BA03E77403647B1D417F922F80047EE_1371026556 = (sService.disableNdefPush());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1336006886 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1336006886;
        } //End block
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
            boolean var68934A3E9455FA72420237EB05902327_489453284 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1623971213 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1623971213;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return sService.disableNdefPush();
        //} catch (RemoteException e) {
            //attemptDeadServiceRecovery(e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.241 -0400", hash_original_method = "94A881D4AB3515CFCD4651DB6D7A2223", hash_generated_method = "34663A7ED246ED7AA0D0840C6A6139EB")
    public boolean isNdefPushEnabled() {
        try 
        {
            boolean varDBD27EFED216468AF5DCC6742D47A68C_2023730896 = (sService.isNdefPushEnabled());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1627621173 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1627621173;
        } //End block
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
            boolean var68934A3E9455FA72420237EB05902327_795354904 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1851105639 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1851105639;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return sService.isNdefPushEnabled();
        //} catch (RemoteException e) {
            //attemptDeadServiceRecovery(e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.242 -0400", hash_original_method = "AC9BE1816495D76DB77DE4C0C93B101E", hash_generated_method = "D349194D92FE50194CD7BC0E14983EC8")
    public INfcAdapterExtras getNfcAdapterExtrasInterface() {
        if(mContext == null)        
        {
            UnsupportedOperationException varC950F527E6C526FA74DB304A2DC00F0C_1487856687 = new UnsupportedOperationException("You need a context on NfcAdapter to use the "
                    + " NFC extras APIs");
            varC950F527E6C526FA74DB304A2DC00F0C_1487856687.addTaint(taint);
            throw varC950F527E6C526FA74DB304A2DC00F0C_1487856687;
        } //End block
        try 
        {
INfcAdapterExtras var57D052F3D4FA0853A3A8D75F81D61555_1709784380 =             sService.getNfcAdapterExtrasInterface(mContext.getPackageName());
            var57D052F3D4FA0853A3A8D75F81D61555_1709784380.addTaint(taint);
            return var57D052F3D4FA0853A3A8D75F81D61555_1709784380;
        } //End block
        catch (RemoteException e)
        {
            attemptDeadServiceRecovery(e);
INfcAdapterExtras var540C13E9E156B687226421B24F2DF178_1870984466 =             null;
            var540C13E9E156B687226421B24F2DF178_1870984466.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1870984466;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.242 -0400", hash_original_method = "219F2FC6E26DD458668CD53974B46E26", hash_generated_method = "450820EC8B25351E4AD0CBE895C5DC54")
     void enforceResumed(Activity activity) {
        addTaint(activity.getTaint());
        if(!activity.isResumed())        
        {
            IllegalStateException var84383A9F11310D2CF8AAB2CF74320295_1870901207 = new IllegalStateException("API cannot be called while activity is paused");
            var84383A9F11310D2CF8AAB2CF74320295_1870901207.addTaint(taint);
            throw var84383A9F11310D2CF8AAB2CF74320295_1870901207;
        } //End block
        // ---------- Original Method ----------
        //if (!activity.isResumed()) {
            //throw new IllegalStateException("API cannot be called while activity is paused");
        //}
    }

    
    static final class LegacyCallbackWrapper implements CreateNdefMessageCallback, OnNdefPushCompleteCallback {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.242 -0400", hash_original_field = "68BAA09986A995ECA579C1C3F2CA43D3", hash_generated_field = "C7B0DB97242B1A2CD9ADF6D51253FEC6")

        NdefPushCallback mLegacyCallback;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.242 -0400", hash_original_method = "6BEF15BCF15DD0D85DE3520BB316E0D4", hash_generated_method = "21E11278C209B656E61A1BA349ACB39A")
          LegacyCallbackWrapper(NdefPushCallback legacyCallback) {
            mLegacyCallback = legacyCallback;
            // ---------- Original Method ----------
            //mLegacyCallback = legacyCallback;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.243 -0400", hash_original_method = "D841E457F2B17E12C1E2098B1C645A79", hash_generated_method = "CD0E4C6F116DCF59D10B209EF8EF5FD7")
        @Override
        public void onNdefPushComplete(NfcEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            mLegacyCallback.onMessagePushed();
            // ---------- Original Method ----------
            //mLegacyCallback.onMessagePushed();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.243 -0400", hash_original_method = "FCA6320615812CADE55DD6047E7D7630", hash_generated_method = "FF8C2F8702C38E6A0E8013B8FBD3B416")
        @Override
        public NdefMessage createNdefMessage(NfcEvent event) {
            addTaint(event.getTaint());
NdefMessage varAF42AD55DEAE724D07B6EF46A48CC555_1549058169 =             mLegacyCallback.createMessage();
            varAF42AD55DEAE724D07B6EF46A48CC555_1549058169.addTaint(taint);
            return varAF42AD55DEAE724D07B6EF46A48CC555_1549058169;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.243 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "B5A60E2FA52639EB51E0CC65701892A4")

    static final String TAG = "NFC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.243 -0400", hash_original_field = "BBCAAF7A6BB4164CED9FE0085D3B96EF", hash_generated_field = "12E09594F7A717118A3DADA24A701917")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_NDEF_DISCOVERED = "android.nfc.action.NDEF_DISCOVERED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.243 -0400", hash_original_field = "389ED5DFDA100510247D71E900BEE0FC", hash_generated_field = "421DFCD0950F69398DB7B948AD45CD3D")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_TECH_DISCOVERED = "android.nfc.action.TECH_DISCOVERED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.243 -0400", hash_original_field = "EAC6D60264575BCCDB78233863641967", hash_generated_field = "6C611E0AE33420401C802C4D28DAF2D8")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_TAG_DISCOVERED = "android.nfc.action.TAG_DISCOVERED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.244 -0400", hash_original_field = "E12A67E7317687E272FF20692CE79ACE", hash_generated_field = "05DA916FF7DE9C6A5E3D0ED553A216B2")

    public static final String ACTION_TAG_LEFT_FIELD = "android.nfc.action.TAG_LOST";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.244 -0400", hash_original_field = "B2AA4477E41C3D08AE974DC9DFBEB3C0", hash_generated_field = "864FDBA549D69F45DE502B8133671865")

    public static final String EXTRA_TAG = "android.nfc.extra.TAG";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.244 -0400", hash_original_field = "AAE1680F083B9048EB2990BC2C0475CB", hash_generated_field = "B8A498585D958ACF371A30D7A693AF39")

    public static final String EXTRA_NDEF_MESSAGES = "android.nfc.extra.NDEF_MESSAGES";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.244 -0400", hash_original_field = "B1D4035C008D1A17FE88B2A11F232B62", hash_generated_field = "9AFE253D7BCA0B91EEBBA17305076401")

    public static final String EXTRA_ID = "android.nfc.extra.ID";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.244 -0400", hash_original_field = "BD30416007FD045B23F88E67DF9A65BC", hash_generated_field = "64EAD31FCC5D8863D42B912D821EC041")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_ADAPTER_STATE_CHANGED =
            "android.nfc.action.ADAPTER_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.244 -0400", hash_original_field = "95AFECFB12145D62B88111622C2CF93B", hash_generated_field = "5610F9B2EBB4FB9B1E6D234598ECA413")

    public static final String EXTRA_ADAPTER_STATE = "android.nfc.extra.ADAPTER_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.244 -0400", hash_original_field = "0A53D89ED725A061255F15DE04453C0F", hash_generated_field = "501F4A67DD89031B57A5BA8625CF46AC")

    public static final int STATE_OFF = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.244 -0400", hash_original_field = "5AD7C406039106B63B2813040FCCE645", hash_generated_field = "09B2FFE38FB2948139C918D224403C50")

    public static final int STATE_TURNING_ON = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.245 -0400", hash_original_field = "2434AE8CED23C865189AE860BB6CC36A", hash_generated_field = "4D3064FE8FD25755AD9FCE56B0968A76")

    public static final int STATE_ON = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.245 -0400", hash_original_field = "787EE4347FF30A418AB554F78013C338", hash_generated_field = "66FFFDE84846BF12D6E7B1556699CCE2")

    public static final int STATE_TURNING_OFF = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.245 -0400", hash_original_field = "2D97EC3B76910B149F69BDEF7C5EC755", hash_generated_field = "F9BB84E3D4C91D00C4A915F1D24BE4F8")

    static boolean sIsInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.245 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "41D15F90E751870BA8CE193EE4F4BAD4")

    static INfcAdapter sService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.245 -0400", hash_original_field = "6DE46BB21844BCA0E34002FC9E3D3A55", hash_generated_field = "2233B419DEF0D6D6964CA486B17F24A6")

    static INfcTag sTagService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.245 -0400", hash_original_field = "D511F14CF57E503C61C29EBE5986FE9C", hash_generated_field = "43AC8A4224DE3385E9255D2280FEE77B")

    static HashMap<Context, NfcAdapter> sNfcAdapters = new HashMap();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.245 -0400", hash_original_field = "83A0202946E64804ABA88F9B3361A49F", hash_generated_field = "DF70B7C03DCF051010C92018533E7115")

    static NfcAdapter sNullContextNfcAdapter;
}

