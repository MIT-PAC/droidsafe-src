package android.accounts;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.SQLException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;

import com.google.android.collect.Maps;






public class AccountManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.795 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.796 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "5EECF8903744EA4C4535FC399DE7EDD3")

    private IAccountManager mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.797 -0400", hash_original_field = "07ED8299DCE5FFC54346DB7582134B71", hash_generated_field = "36D62901B5F66AD7425C1042CCC68DC2")

    private Handler mMainHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.798 -0400", hash_original_field = "206AC291D9BD241BDB1384C71EF5E229", hash_generated_field = "E06E5EFE2F853C682425BCF2C68C9174")

    private final HashMap<OnAccountsUpdateListener, Handler> mAccountsUpdatedListeners = Maps.newHashMap();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.275 -0400", hash_original_field = "5B9AAF8C7934EB6B84189463FFEE1757", hash_generated_field = "9131D7F68152C610E64880FB5BD3872C")

    private final BroadcastReceiver mAccountsChangedBroadcastReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.275 -0400", hash_original_method = "06776CFD48438B35B07B048BEACBE4B9", hash_generated_method = "36F56EEE450A855D1F32BF53B0FC45A6")
        public void onReceive(final Context context, final Intent intent) {
            
            final Account[] accounts = getAccounts();
            {
            	for (Map.Entry<OnAccountsUpdateListener, Handler> entry: mAccountsUpdatedListeners.entrySet())
                {
                    postToHandler(entry.getValue(), entry.getKey(), accounts);
                }
            } 
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
        }
    };
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.810 -0400", hash_original_method = "399D8365074F8431C3C32ED7720975E8", hash_generated_method = "699A204D5899DBCF695891C3392F1F59")
    public  AccountManager(Context context, IAccountManager service) {
        mContext = context;
        mService = service;
        mMainHandler = new Handler(mContext.getMainLooper());
        // ---------- Original Method ----------
        //mContext = context;
        //mService = service;
        //mMainHandler = new Handler(mContext.getMainLooper());
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.814 -0400", hash_original_method = "25BBC3E1043ACDD515139061A9597BA7", hash_generated_method = "34C7F2EB81FAF854CED2B6C04922B77F")
    public  AccountManager(Context context, IAccountManager service, Handler handler) {
        mContext = context;
        mService = service;
        mMainHandler = handler;
        // ---------- Original Method ----------
        //mContext = context;
        //mService = service;
        //mMainHandler = handler;
    }

    
    @DSModeled(DSC.BAN)
    public static Bundle sanitizeResult(Bundle result) {
        if (result != null) {
            if (result.containsKey(KEY_AUTHTOKEN)
                    && !TextUtils.isEmpty(result.getString(KEY_AUTHTOKEN))) {
                final Bundle newResult = new Bundle(result);
                newResult.putString(KEY_AUTHTOKEN, "<omitted for logging purposes>");
                return newResult;
            }
        }
        return result;
    }

    
    public static AccountManager get(Context context) {
        if (context == null) throw new IllegalArgumentException("context is null");
        return (AccountManager) context.getSystemService(Context.ACCOUNT_SERVICE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.824 -0400", hash_original_method = "96491C15B9EBF498D1F12389B670F852", hash_generated_method = "3E0872507A37323EA476FA927548A741")
    public String getPassword(final Account account) {
        addTaint(account.getTaint());
        if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_1365246402 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_1365246402.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_1365246402;
        }
        try 
        {
String varF265DC2FF2F4422603F1281D744D04FC_1235973310 =             mService.getPassword(account);
            varF265DC2FF2F4422603F1281D744D04FC_1235973310.addTaint(taint);
            return varF265DC2FF2F4422603F1281D744D04FC_1235973310;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1157067495 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1157067495.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1157067495;
        } //End block
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //try {
            //return mService.getPassword(account);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.830 -0400", hash_original_method = "8DF662EA0E604D155E2F8EF5AE185580", hash_generated_method = "9475F81DC39B8549A1A699546433EC86")
    public String getUserData(final Account account, final String key) {
        addTaint(key.getTaint());
        addTaint(account.getTaint());
        if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_257046532 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_257046532.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_257046532;
        }
        if(key == null)        
        {
        IllegalArgumentException varE3808CDA429E68361B6214A9C953E73D_1517221664 = new IllegalArgumentException("key is null");
        varE3808CDA429E68361B6214A9C953E73D_1517221664.addTaint(taint);
        throw varE3808CDA429E68361B6214A9C953E73D_1517221664;
        }
        try 
        {
String varB6E12DC381BC7D4C78B95DD144A437FD_224410325 =             mService.getUserData(account, key);
            varB6E12DC381BC7D4C78B95DD144A437FD_224410325.addTaint(taint);
            return varB6E12DC381BC7D4C78B95DD144A437FD_224410325;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_959312832 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_959312832.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_959312832;
        } //End block
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //if (key == null) throw new IllegalArgumentException("key is null");
        //try {
            //return mService.getUserData(account, key);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.835 -0400", hash_original_method = "CE81752A69974A848970631715E35659", hash_generated_method = "23423FA4C366823E9B3EEF77F3776FBA")
    public AuthenticatorDescription[] getAuthenticatorTypes() {
        try 
        {
AuthenticatorDescription[] var72B248AAB2E560F9BE7F0C8BB51E605E_1858779447 =             mService.getAuthenticatorTypes();
            var72B248AAB2E560F9BE7F0C8BB51E605E_1858779447.addTaint(taint);
            return var72B248AAB2E560F9BE7F0C8BB51E605E_1858779447;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1768397020 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1768397020.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1768397020;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getAuthenticatorTypes();
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.842 -0400", hash_original_method = "CBAE32CDB06D92C44980C30430EF1CC0", hash_generated_method = "D7D90327F5BB6BCCDC5D26574162FEED")
    public Account[] getAccounts() {
        try 
        {
Account[] varC591FC5C8C08716D5E3035B51846A437_1061328503 =             mService.getAccounts(null);
            varC591FC5C8C08716D5E3035B51846A437_1061328503.addTaint(taint);
            return varC591FC5C8C08716D5E3035B51846A437_1061328503;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_754255134 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_754255134.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_754255134;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getAccounts(null);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.847 -0400", hash_original_method = "182706774272102452F63339D769DBB2", hash_generated_method = "E9C83AF8E42816DD9CC8557374FED97B")
    public Account[] getAccountsByType(String type) {
        addTaint(type.getTaint());
        try 
        {
Account[] var374F02E84765AA530519BBC2335DB4D9_1836235970 =             mService.getAccounts(type);
            var374F02E84765AA530519BBC2335DB4D9_1836235970.addTaint(taint);
            return var374F02E84765AA530519BBC2335DB4D9_1836235970;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1050657914 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1050657914.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1050657914;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getAccounts(type);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.866 -0400", hash_original_method = "74ADBAC1696D9C481AB31AC8146F1AF9", hash_generated_method = "C64A31646681ECC25BA0916F29411473")
    public AccountManagerFuture<Boolean> hasFeatures(final Account account,
            final String[] features,
            AccountManagerCallback<Boolean> callback, Handler handler) {
        addTaint(handler.getTaint());
        addTaint(callback.getTaint());
        addTaint(features[0].getTaint());
        addTaint(account.getTaint());
        if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_384044179 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_384044179.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_384044179;
        }
        if(features == null)        
        {
        IllegalArgumentException var2D1AA98EF7D0249EC9EFBC9AA5F0F4ED_403573880 = new IllegalArgumentException("features is null");
        var2D1AA98EF7D0249EC9EFBC9AA5F0F4ED_403573880.addTaint(taint);
        throw var2D1AA98EF7D0249EC9EFBC9AA5F0F4ED_403573880;
        }
AccountManagerFuture<Boolean> varDFF33794F9650E111BD6F4FC4D492A46_2043356232 =         new Future2Task<Boolean>(handler, callback) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.856 -0400", hash_original_method = "FFBFF398261B5CC044E2A91B7E73D5E3", hash_generated_method = "89205067D73CE89B6B97941EBFF4C904")
        public void doWork() throws RemoteException {
            mService.hasFeatures(mResponse, account, features);
            // ---------- Original Method ----------
            //mService.hasFeatures(mResponse, account, features);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.862 -0400", hash_original_method = "EE3E978FB5F7BB3B094FBC48A926EAB2", hash_generated_method = "F03E88C4E34A7455286E04669E2F9FF8")
        public Boolean bundleToResult(Bundle bundle) throws AuthenticatorException {
            addTaint(bundle.getTaint());
            if(!bundle.containsKey(KEY_BOOLEAN_RESULT))            
            {
                AuthenticatorException varF12691AEB1A4C0781851C7555271DC34_1391257020 = new AuthenticatorException("no result in response");
                varF12691AEB1A4C0781851C7555271DC34_1391257020.addTaint(taint);
                throw varF12691AEB1A4C0781851C7555271DC34_1391257020;
            } //End block
Boolean varE5CA5297BFAF8C89D32D5EF2EF2432F6_1475202972 =             bundle.getBoolean(KEY_BOOLEAN_RESULT);
            varE5CA5297BFAF8C89D32D5EF2EF2432F6_1475202972.addTaint(taint);
            return varE5CA5297BFAF8C89D32D5EF2EF2432F6_1475202972;
            // ---------- Original Method ----------
            //if (!bundle.containsKey(KEY_BOOLEAN_RESULT)) {
                    //throw new AuthenticatorException("no result in response");
                //}
            //return bundle.getBoolean(KEY_BOOLEAN_RESULT);
        }
}.start();
        varDFF33794F9650E111BD6F4FC4D492A46_2043356232.addTaint(taint);
        return varDFF33794F9650E111BD6F4FC4D492A46_2043356232;
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //if (features == null) throw new IllegalArgumentException("features is null");
        //return new Future2Task<Boolean>(handler, callback) {
            //public void doWork() throws RemoteException {
                //mService.hasFeatures(mResponse, account, features);
            //}
            //public Boolean bundleToResult(Bundle bundle) throws AuthenticatorException {
                //if (!bundle.containsKey(KEY_BOOLEAN_RESULT)) {
                    //throw new AuthenticatorException("no result in response");
                //}
                //return bundle.getBoolean(KEY_BOOLEAN_RESULT);
            //}
        //}.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.886 -0400", hash_original_method = "430725BCDDC603435317A3A309F1AEF2", hash_generated_method = "CA868D99E360524342D71D2A3B1D409C")
    public AccountManagerFuture<Account[]> getAccountsByTypeAndFeatures(
            final String type, final String[] features,
            AccountManagerCallback<Account[]> callback, Handler handler) {
        addTaint(handler.getTaint());
        addTaint(callback.getTaint());
        addTaint(features[0].getTaint());
        addTaint(type.getTaint());
        if(type == null)        
        {
        IllegalArgumentException varD47EFECFC51B1CB5E3A8469789214E4E_644207266 = new IllegalArgumentException("type is null");
        varD47EFECFC51B1CB5E3A8469789214E4E_644207266.addTaint(taint);
        throw varD47EFECFC51B1CB5E3A8469789214E4E_644207266;
        }
AccountManagerFuture<Account[]> var32592741EE7D1B027B3439F04859A07A_628101399 =         new Future2Task<Account[]>(handler, callback) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.877 -0400", hash_original_method = "73AB820A1E98A1765445367AD9245309", hash_generated_method = "E4EFF5B2612046AA05CA36509915F542")
        public void doWork() throws RemoteException {
            mService.getAccountsByFeatures(mResponse, type, features);
            // ---------- Original Method ----------
            //mService.getAccountsByFeatures(mResponse, type, features);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.883 -0400", hash_original_method = "4E01F2C268DC2C127E06F0E054062427", hash_generated_method = "026731FF74821B984E94677D7CBBC866")
        public Account[] bundleToResult(Bundle bundle) throws AuthenticatorException {
            addTaint(bundle.getTaint());
            if(!bundle.containsKey(KEY_ACCOUNTS))            
            {
                AuthenticatorException varF12691AEB1A4C0781851C7555271DC34_1775316048 = new AuthenticatorException("no result in response");
                varF12691AEB1A4C0781851C7555271DC34_1775316048.addTaint(taint);
                throw varF12691AEB1A4C0781851C7555271DC34_1775316048;
            } //End block
            final Parcelable[] parcelables = bundle.getParcelableArray(KEY_ACCOUNTS);
            Account[] descs = new Account[parcelables.length];
for(int i = 0;i < parcelables.length;i++)
            {
                descs[i] = (Account) parcelables[i];
            } //End block
Account[] var8AFC8F239FAF32249C1DA5BD5D6C508A_259823908 =             descs;
            var8AFC8F239FAF32249C1DA5BD5D6C508A_259823908.addTaint(taint);
            return var8AFC8F239FAF32249C1DA5BD5D6C508A_259823908;
            // ---------- Original Method ----------
            //if (!bundle.containsKey(KEY_ACCOUNTS)) {
                    //throw new AuthenticatorException("no result in response");
                //}
            //final Parcelable[] parcelables = bundle.getParcelableArray(KEY_ACCOUNTS);
            //Account[] descs = new Account[parcelables.length];
            //for (int i = 0; i < parcelables.length; i++) {
                    //descs[i] = (Account) parcelables[i];
                //}
            //return descs;
        }
}.start();
        var32592741EE7D1B027B3439F04859A07A_628101399.addTaint(taint);
        return var32592741EE7D1B027B3439F04859A07A_628101399;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.896 -0400", hash_original_method = "757D4D500E44E3A8DF2EF3DE74D56199", hash_generated_method = "F72ED6D765740E30CC13B331B40E005F")
    public boolean addAccountExplicitly(Account account, String password, Bundle userdata) {
        addTaint(userdata.getTaint());
        addTaint(password.getTaint());
        addTaint(account.getTaint());
        if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_690881345 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_690881345.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_690881345;
        }
        try 
        {
            boolean varB8116F6C3347DBB4478ABC1827CF1BC9_1424672946 = (mService.addAccount(account, password, userdata));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2135032910 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2135032910;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_64904708 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_64904708.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_64904708;
        } //End block
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //try {
            //return mService.addAccount(account, password, userdata);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.910 -0400", hash_original_method = "E8BA698C89E3CF76A294446D4D176FF0", hash_generated_method = "15E24A567D05DCC27F124EAD65F5D3B4")
    public AccountManagerFuture<Boolean> removeAccount(final Account account,
            AccountManagerCallback<Boolean> callback, Handler handler) {
        addTaint(handler.getTaint());
        addTaint(callback.getTaint());
        addTaint(account.getTaint());
        if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_1790619886 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_1790619886.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_1790619886;
        }
AccountManagerFuture<Boolean> var4A4ADA264DA1FB81D3FF82DCFC2D4A40_691035055 =         new Future2Task<Boolean>(handler, callback) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.903 -0400", hash_original_method = "008B2E3F52D7383A94B933DA4159D4A7", hash_generated_method = "81AD4A0CB256A6E863BA4C31FFEB45E7")
        public void doWork() throws RemoteException {
            mService.removeAccount(mResponse, account);
            // ---------- Original Method ----------
            //mService.removeAccount(mResponse, account);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.906 -0400", hash_original_method = "EE3E978FB5F7BB3B094FBC48A926EAB2", hash_generated_method = "B6BF443E84D66A85EB0525A3E497C79A")
        public Boolean bundleToResult(Bundle bundle) throws AuthenticatorException {
            addTaint(bundle.getTaint());
            if(!bundle.containsKey(KEY_BOOLEAN_RESULT))            
            {
                AuthenticatorException varF12691AEB1A4C0781851C7555271DC34_1183861841 = new AuthenticatorException("no result in response");
                varF12691AEB1A4C0781851C7555271DC34_1183861841.addTaint(taint);
                throw varF12691AEB1A4C0781851C7555271DC34_1183861841;
            } //End block
Boolean varE5CA5297BFAF8C89D32D5EF2EF2432F6_1423864158 =             bundle.getBoolean(KEY_BOOLEAN_RESULT);
            varE5CA5297BFAF8C89D32D5EF2EF2432F6_1423864158.addTaint(taint);
            return varE5CA5297BFAF8C89D32D5EF2EF2432F6_1423864158;
            // ---------- Original Method ----------
            //if (!bundle.containsKey(KEY_BOOLEAN_RESULT)) {
                    //throw new AuthenticatorException("no result in response");
                //}
            //return bundle.getBoolean(KEY_BOOLEAN_RESULT);
        }
}.start();
        var4A4ADA264DA1FB81D3FF82DCFC2D4A40_691035055.addTaint(taint);
        return var4A4ADA264DA1FB81D3FF82DCFC2D4A40_691035055;
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //return new Future2Task<Boolean>(handler, callback) {
            //public void doWork() throws RemoteException {
                //mService.removeAccount(mResponse, account);
            //}
            //public Boolean bundleToResult(Bundle bundle) throws AuthenticatorException {
                //if (!bundle.containsKey(KEY_BOOLEAN_RESULT)) {
                    //throw new AuthenticatorException("no result in response");
                //}
                //return bundle.getBoolean(KEY_BOOLEAN_RESULT);
            //}
        //}.start();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.915 -0400", hash_original_method = "4162D414A92CDAFD44055C84C3F9947E", hash_generated_method = "1010DEB38636C019DB35834056540FDF")
    public void invalidateAuthToken(final String accountType, final String authToken) {
        addTaint(authToken.getTaint());
        addTaint(accountType.getTaint());
        if(accountType == null)        
        {
        IllegalArgumentException var763EFEBC62165BF514D56EF43D87C9E2_89477634 = new IllegalArgumentException("accountType is null");
        var763EFEBC62165BF514D56EF43D87C9E2_89477634.addTaint(taint);
        throw var763EFEBC62165BF514D56EF43D87C9E2_89477634;
        }
        try 
        {
            if(authToken != null)            
            {
                mService.invalidateAuthToken(accountType, authToken);
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1067272114 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1067272114.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1067272114;
        } //End block
        // ---------- Original Method ----------
        //if (accountType == null) throw new IllegalArgumentException("accountType is null");
        //try {
            //if (authToken != null) {
                //mService.invalidateAuthToken(accountType, authToken);
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.923 -0400", hash_original_method = "DF00C62B1FBE79E2C2C3124DAA6E8CCA", hash_generated_method = "744A7EEB628379B7A2BBCB2A17437144")
    public String peekAuthToken(final Account account, final String authTokenType) {
        addTaint(authTokenType.getTaint());
        addTaint(account.getTaint());
        if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_870955101 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_870955101.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_870955101;
        }
        if(authTokenType == null)        
        {
        IllegalArgumentException var0343EB95D47FDF1150074966B4E27105_1162291919 = new IllegalArgumentException("authTokenType is null");
        var0343EB95D47FDF1150074966B4E27105_1162291919.addTaint(taint);
        throw var0343EB95D47FDF1150074966B4E27105_1162291919;
        }
        try 
        {
String var57F2B5CDC8AC908E5586F36AB9127795_1250779985 =             mService.peekAuthToken(account, authTokenType);
            var57F2B5CDC8AC908E5586F36AB9127795_1250779985.addTaint(taint);
            return var57F2B5CDC8AC908E5586F36AB9127795_1250779985;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_226209197 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_226209197.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_226209197;
        } //End block
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //if (authTokenType == null) throw new IllegalArgumentException("authTokenType is null");
        //try {
            //return mService.peekAuthToken(account, authTokenType);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.926 -0400", hash_original_method = "DBE21AE149A5EC66FBC34FA1D5807CA3", hash_generated_method = "AD36FB21E807B4818E503BE0E38283A3")
    public void setPassword(final Account account, final String password) {
        addTaint(password.getTaint());
        addTaint(account.getTaint());
        if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_2046755659 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_2046755659.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_2046755659;
        }
        try 
        {
            mService.setPassword(account, password);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1387655319 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1387655319.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1387655319;
        } //End block
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //try {
            //mService.setPassword(account, password);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.931 -0400", hash_original_method = "9D6E3653B7C827404B4854FFAF700F44", hash_generated_method = "405E9D1D29F1E437BD18B42515E6D44B")
    public void clearPassword(final Account account) {
        addTaint(account.getTaint());
        if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_291118950 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_291118950.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_291118950;
        }
        try 
        {
            mService.clearPassword(account);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1142877384 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1142877384.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1142877384;
        } //End block
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //try {
            //mService.clearPassword(account);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.937 -0400", hash_original_method = "39E18EFA140E2C140EF9BDAC244CFA88", hash_generated_method = "092A8213A112F79A7E43AFF738C7D4EB")
    public void setUserData(final Account account, final String key, final String value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        addTaint(account.getTaint());
        if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_786080543 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_786080543.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_786080543;
        }
        if(key == null)        
        {
        IllegalArgumentException varE3808CDA429E68361B6214A9C953E73D_1703327881 = new IllegalArgumentException("key is null");
        varE3808CDA429E68361B6214A9C953E73D_1703327881.addTaint(taint);
        throw varE3808CDA429E68361B6214A9C953E73D_1703327881;
        }
        try 
        {
            mService.setUserData(account, key, value);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1023843851 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1023843851.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1023843851;
        } //End block
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //if (key == null) throw new IllegalArgumentException("key is null");
        //try {
            //mService.setUserData(account, key, value);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.947 -0400", hash_original_method = "967876CD971AD7982E73046636574113", hash_generated_method = "A4BBD03FEB7D574A254D751E4B018ABE")
    public void setAuthToken(Account account, final String authTokenType, final String authToken) {
        addTaint(authToken.getTaint());
        addTaint(authTokenType.getTaint());
        addTaint(account.getTaint());
        if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_1639096470 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_1639096470.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_1639096470;
        }
        if(authTokenType == null)        
        {
        IllegalArgumentException var0343EB95D47FDF1150074966B4E27105_603496321 = new IllegalArgumentException("authTokenType is null");
        var0343EB95D47FDF1150074966B4E27105_603496321.addTaint(taint);
        throw var0343EB95D47FDF1150074966B4E27105_603496321;
        }
        try 
        {
            mService.setAuthToken(account, authTokenType, authToken);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_598093942 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_598093942.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_598093942;
        } //End block
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //if (authTokenType == null) throw new IllegalArgumentException("authTokenType is null");
        //try {
            //mService.setAuthToken(account, authTokenType, authToken);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.959 -0400", hash_original_method = "51CDD8704FBB21791536BE5C26E3F85E", hash_generated_method = "640E5A9CBF81A8BFC89D83529AC81EA1")
    public String blockingGetAuthToken(Account account, String authTokenType,
            boolean notifyAuthFailure) throws OperationCanceledException, IOException, AuthenticatorException {
        addTaint(notifyAuthFailure);
        addTaint(authTokenType.getTaint());
        addTaint(account.getTaint());
        if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_1130294661 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_1130294661.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_1130294661;
        }
        if(authTokenType == null)        
        {
        IllegalArgumentException var0343EB95D47FDF1150074966B4E27105_1867120649 = new IllegalArgumentException("authTokenType is null");
        var0343EB95D47FDF1150074966B4E27105_1867120649.addTaint(taint);
        throw var0343EB95D47FDF1150074966B4E27105_1867120649;
        }
        Bundle bundle = getAuthToken(account, authTokenType, notifyAuthFailure, null ,
                null ).getResult();
        if(bundle == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1207110956 =             null;
            var540C13E9E156B687226421B24F2DF178_1207110956.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1207110956;
        } //End block
String var3A2B6A9F8F72674C0701F55FC46307ED_167186034 =         bundle.getString(KEY_AUTHTOKEN);
        var3A2B6A9F8F72674C0701F55FC46307ED_167186034.addTaint(taint);
        return var3A2B6A9F8F72674C0701F55FC46307ED_167186034;
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //if (authTokenType == null) throw new IllegalArgumentException("authTokenType is null");
        //Bundle bundle = getAuthToken(account, authTokenType, notifyAuthFailure, null ,
                //null ).getResult();
        //if (bundle == null) {
            //Log.e(TAG, "blockingGetAuthToken: null was returned from getResult() for "
                    //+ account + ", authTokenType " + authTokenType);
            //return null;
        //}
        //return bundle.getString(KEY_AUTHTOKEN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.968 -0400", hash_original_method = "DC329BE18D12A187B670EF72046E93F0", hash_generated_method = "CFE3C8F428E42914D5768C54D28160A2")
    public AccountManagerFuture<Bundle> getAuthToken(
            final Account account, final String authTokenType, final Bundle options,
            final Activity activity, AccountManagerCallback<Bundle> callback, Handler handler) {
        addTaint(handler.getTaint());
        addTaint(callback.getTaint());
        addTaint(activity.getTaint());
        addTaint(options.getTaint());
        addTaint(authTokenType.getTaint());
        addTaint(account.getTaint());
        if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_1264261707 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_1264261707.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_1264261707;
        }
        if(authTokenType == null)        
        {
        IllegalArgumentException var0343EB95D47FDF1150074966B4E27105_800039107 = new IllegalArgumentException("authTokenType is null");
        var0343EB95D47FDF1150074966B4E27105_800039107.addTaint(taint);
        throw var0343EB95D47FDF1150074966B4E27105_800039107;
        }
        final Bundle optionsIn = new Bundle();
        if(options != null)        
        {
            optionsIn.putAll(options);
        } //End block
        optionsIn.putString(KEY_ANDROID_PACKAGE_NAME, mContext.getPackageName());
AccountManagerFuture<Bundle> var0C15B41E283DF0F7CE7BDD58718BC504_1606349305 =         new AmsTask(activity, handler, callback) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.966 -0400", hash_original_method = "DB27CC533E1EBFD8DDE03170C9D7E426", hash_generated_method = "914FB93966B313E8F64C04FDBCE1D8BE")
        public void doWork() throws RemoteException {
            mService.getAuthToken(mResponse, account, authTokenType,
                        false , true ,
                        optionsIn);
            // ---------- Original Method ----------
            //mService.getAuthToken(mResponse, account, authTokenType,
                        //false , true ,
                        //optionsIn);
        }
}.start();
        var0C15B41E283DF0F7CE7BDD58718BC504_1606349305.addTaint(taint);
        return var0C15B41E283DF0F7CE7BDD58718BC504_1606349305;
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //if (authTokenType == null) throw new IllegalArgumentException("authTokenType is null");
        //final Bundle optionsIn = new Bundle();
        //if (options != null) {
            //optionsIn.putAll(options);
        //}
        //optionsIn.putString(KEY_ANDROID_PACKAGE_NAME, mContext.getPackageName());
        //return new AmsTask(activity, handler, callback) {
            //public void doWork() throws RemoteException {
                //mService.getAuthToken(mResponse, account, authTokenType,
                        //false , true ,
                        //optionsIn);
            //}
        //}.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.973 -0400", hash_original_method = "63BBFF30BB2AEF86FE403A4E568375F4", hash_generated_method = "3B63E172DB42DD4AC94CDA7B79EF3A4C")
    @Deprecated
    public AccountManagerFuture<Bundle> getAuthToken(
            final Account account, final String authTokenType, 
            final boolean notifyAuthFailure,
            AccountManagerCallback<Bundle> callback, Handler handler) {
        addTaint(handler.getTaint());
        addTaint(callback.getTaint());
        addTaint(notifyAuthFailure);
        addTaint(authTokenType.getTaint());
        addTaint(account.getTaint());
AccountManagerFuture<Bundle> varE53CBB2E6EE67C2A88DB98EB051FE1C4_763211933 =         getAuthToken(account, authTokenType, null, notifyAuthFailure, callback, 
                handler);
        varE53CBB2E6EE67C2A88DB98EB051FE1C4_763211933.addTaint(taint);
        return varE53CBB2E6EE67C2A88DB98EB051FE1C4_763211933;
        // ---------- Original Method ----------
        //return getAuthToken(account, authTokenType, null, notifyAuthFailure, callback, 
                //handler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.981 -0400", hash_original_method = "748DC8BCC0E7F6CE1552DDD9EEAFB074", hash_generated_method = "099D8CE55AB855F9943A6F7D8191829B")
    public AccountManagerFuture<Bundle> getAuthToken(
            final Account account, final String authTokenType, final Bundle options,
            final boolean notifyAuthFailure,
            AccountManagerCallback<Bundle> callback, Handler handler) {
        addTaint(handler.getTaint());
        addTaint(callback.getTaint());
        addTaint(notifyAuthFailure);
        addTaint(options.getTaint());
        addTaint(authTokenType.getTaint());
        addTaint(account.getTaint());
        if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_1905407941 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_1905407941.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_1905407941;
        }
        if(authTokenType == null)        
        {
        IllegalArgumentException var0343EB95D47FDF1150074966B4E27105_1224038886 = new IllegalArgumentException("authTokenType is null");
        var0343EB95D47FDF1150074966B4E27105_1224038886.addTaint(taint);
        throw var0343EB95D47FDF1150074966B4E27105_1224038886;
        }
        final Bundle optionsIn = new Bundle();
        if(options != null)        
        {
            optionsIn.putAll(options);
        } //End block
        optionsIn.putString(KEY_ANDROID_PACKAGE_NAME, mContext.getPackageName());
AccountManagerFuture<Bundle> varD0E43CD18B7614D621DC6D506B386ABB_1706452161 =         new AmsTask(null, handler, callback) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.979 -0400", hash_original_method = "4D806FE924DCA4BD633F9FEEB108BD63", hash_generated_method = "22E63FDD6EFBDF9C79B3AB87B647FECC")
        public void doWork() throws RemoteException {
            mService.getAuthToken(mResponse, account, authTokenType,
                        notifyAuthFailure, false , optionsIn);
            // ---------- Original Method ----------
            //mService.getAuthToken(mResponse, account, authTokenType,
                        //notifyAuthFailure, false , optionsIn);
        }
}.start();
        varD0E43CD18B7614D621DC6D506B386ABB_1706452161.addTaint(taint);
        return varD0E43CD18B7614D621DC6D506B386ABB_1706452161;
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //if (authTokenType == null) throw new IllegalArgumentException("authTokenType is null");
        //final Bundle optionsIn = new Bundle();
        //if (options != null) {
            //optionsIn.putAll(options);
        //}
        //optionsIn.putString(KEY_ANDROID_PACKAGE_NAME, mContext.getPackageName());
        //return new AmsTask(null, handler, callback) {
            //public void doWork() throws RemoteException {
                //mService.getAuthToken(mResponse, account, authTokenType,
                        //notifyAuthFailure, false , optionsIn);
            //}
        //}.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.994 -0400", hash_original_method = "6ACDAD8A4FE951A7F40DF03A76D4A058", hash_generated_method = "02F6C910767E2FFE46C3E58DA631F22A")
    public AccountManagerFuture<Bundle> addAccount(final String accountType,
            final String authTokenType, final String[] requiredFeatures,
            final Bundle addAccountOptions,
            final Activity activity, AccountManagerCallback<Bundle> callback, Handler handler) {
        addTaint(handler.getTaint());
        addTaint(callback.getTaint());
        addTaint(activity.getTaint());
        addTaint(addAccountOptions.getTaint());
        addTaint(requiredFeatures[0].getTaint());
        addTaint(authTokenType.getTaint());
        addTaint(accountType.getTaint());
        if(accountType == null)        
        {
        IllegalArgumentException var763EFEBC62165BF514D56EF43D87C9E2_2091623187 = new IllegalArgumentException("accountType is null");
        var763EFEBC62165BF514D56EF43D87C9E2_2091623187.addTaint(taint);
        throw var763EFEBC62165BF514D56EF43D87C9E2_2091623187;
        }
        final Bundle optionsIn = new Bundle();
        if(addAccountOptions != null)        
        {
            optionsIn.putAll(addAccountOptions);
        } //End block
        optionsIn.putString(KEY_ANDROID_PACKAGE_NAME, mContext.getPackageName());
AccountManagerFuture<Bundle> varD8CFA3F11091A5A788758BA8176211E1_729597014 =         new AmsTask(activity, handler, callback) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.991 -0400", hash_original_method = "8125D1B63E005C814CD2B9CB30309226", hash_generated_method = "8F2127E03570576B47D9FA13D331F1D9")
        public void doWork() throws RemoteException {
            mService.addAcount(mResponse, accountType, authTokenType,
                        requiredFeatures, activity != null, optionsIn);
            // ---------- Original Method ----------
            //mService.addAcount(mResponse, accountType, authTokenType,
                        //requiredFeatures, activity != null, optionsIn);
        }
}.start();
        varD8CFA3F11091A5A788758BA8176211E1_729597014.addTaint(taint);
        return varD8CFA3F11091A5A788758BA8176211E1_729597014;
        // ---------- Original Method ----------
        //if (accountType == null) throw new IllegalArgumentException("accountType is null");
        //final Bundle optionsIn = new Bundle();
        //if (addAccountOptions != null) {
            //optionsIn.putAll(addAccountOptions);
        //}
        //optionsIn.putString(KEY_ANDROID_PACKAGE_NAME, mContext.getPackageName());
        //return new AmsTask(activity, handler, callback) {
            //public void doWork() throws RemoteException {
                //mService.addAcount(mResponse, accountType, authTokenType,
                        //requiredFeatures, activity != null, optionsIn);
            //}
        //}.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.002 -0400", hash_original_method = "E9F24B896DDD289C3D9D25FA0235DC55", hash_generated_method = "91B62CE4BD5B613EBE343632CCB85072")
    public AccountManagerFuture<Bundle> confirmCredentials(final Account account,
            final Bundle options,
            final Activity activity,
            final AccountManagerCallback<Bundle> callback,
            final Handler handler) {
        addTaint(handler.getTaint());
        addTaint(callback.getTaint());
        addTaint(activity.getTaint());
        addTaint(options.getTaint());
        addTaint(account.getTaint());
        if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_1750453905 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_1750453905.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_1750453905;
        }
AccountManagerFuture<Bundle> varAF4F8503C14478A49D1D8937CDFAB658_985942427 =         new AmsTask(activity, handler, callback) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.000 -0400", hash_original_method = "352D9086D40AE796E81956BBA2D0E5D4", hash_generated_method = "3F77048E922E80B6C7C6633D1C3CBAEF")
        public void doWork() throws RemoteException {
            mService.confirmCredentials(mResponse, account, options, activity != null);
            // ---------- Original Method ----------
            //mService.confirmCredentials(mResponse, account, options, activity != null);
        }
}.start();
        varAF4F8503C14478A49D1D8937CDFAB658_985942427.addTaint(taint);
        return varAF4F8503C14478A49D1D8937CDFAB658_985942427;
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //return new AmsTask(activity, handler, callback) {
            //public void doWork() throws RemoteException {
                //mService.confirmCredentials(mResponse, account, options, activity != null);
            //}
        //}.start();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.011 -0400", hash_original_method = "D809F6F9BB7D46EEEE0B772ED5C9F6A9", hash_generated_method = "E300B37B96D9F856FD83EEA0A5E51C40")
    public AccountManagerFuture<Bundle> updateCredentials(final Account account,
            final String authTokenType,
            final Bundle options, final Activity activity,
            final AccountManagerCallback<Bundle> callback,
            final Handler handler) {
        addTaint(handler.getTaint());
        addTaint(callback.getTaint());
        addTaint(activity.getTaint());
        addTaint(options.getTaint());
        addTaint(authTokenType.getTaint());
        addTaint(account.getTaint());
        if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_974244125 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_974244125.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_974244125;
        }
AccountManagerFuture<Bundle> varFD1B4C0E8EE2C772594596D209598B34_801071035 =         new AmsTask(activity, handler, callback) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.008 -0400", hash_original_method = "6D2F90C4553E4DD12E7AEE5963D4AB1E", hash_generated_method = "5F0AD53448D1D721264F4D7E73A4152F")
        public void doWork() throws RemoteException {
            mService.updateCredentials(mResponse, account, authTokenType, activity != null,
                        options);
            // ---------- Original Method ----------
            //mService.updateCredentials(mResponse, account, authTokenType, activity != null,
                        //options);
        }
}.start();
        varFD1B4C0E8EE2C772594596D209598B34_801071035.addTaint(taint);
        return varFD1B4C0E8EE2C772594596D209598B34_801071035;
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //return new AmsTask(activity, handler, callback) {
            //public void doWork() throws RemoteException {
                //mService.updateCredentials(mResponse, account, authTokenType, activity != null,
                        //options);
            //}
        //}.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.026 -0400", hash_original_method = "72C42C362A18F251D937648B5DDE9096", hash_generated_method = "B4943810004D5563BC679C62C629DD5D")
    public AccountManagerFuture<Bundle> editProperties(final String accountType,
            final Activity activity, final AccountManagerCallback<Bundle> callback,
            final Handler handler) {
        addTaint(handler.getTaint());
        addTaint(callback.getTaint());
        addTaint(activity.getTaint());
        addTaint(accountType.getTaint());
        if(accountType == null)        
        {
        IllegalArgumentException var763EFEBC62165BF514D56EF43D87C9E2_946342080 = new IllegalArgumentException("accountType is null");
        var763EFEBC62165BF514D56EF43D87C9E2_946342080.addTaint(taint);
        throw var763EFEBC62165BF514D56EF43D87C9E2_946342080;
        }
AccountManagerFuture<Bundle> varB99B0F3BC6F6C2150AAD6BA17DB7DE1F_992146252 =         new AmsTask(activity, handler, callback) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.024 -0400", hash_original_method = "04B8B0735D1CA277ED91C00D79F33B2D", hash_generated_method = "1D34C9364A966EE79E020E27C5A65409")
        public void doWork() throws RemoteException {
            mService.editProperties(mResponse, accountType, activity != null);
            // ---------- Original Method ----------
            //mService.editProperties(mResponse, accountType, activity != null);
        }
}.start();
        varB99B0F3BC6F6C2150AAD6BA17DB7DE1F_992146252.addTaint(taint);
        return varB99B0F3BC6F6C2150AAD6BA17DB7DE1F_992146252;
        // ---------- Original Method ----------
        //if (accountType == null) throw new IllegalArgumentException("accountType is null");
        //return new AmsTask(activity, handler, callback) {
            //public void doWork() throws RemoteException {
                //mService.editProperties(mResponse, accountType, activity != null);
            //}
        //}.start();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.032 -0400", hash_original_method = "05C769BBE692F72E464B52B58848EACE", hash_generated_method = "9C8597D05E95DEE9B9D7D0991840332F")
    private void ensureNotOnMainThread() {
        final Looper looper = Looper.myLooper();
        if(looper != null && looper == mContext.getMainLooper())        
        {
            final IllegalStateException exception = new IllegalStateException(
                    "calling this from your main thread can lead to deadlock");
            if(mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.FROYO)            
            {
                exception.addTaint(taint);
                throw exception;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final Looper looper = Looper.myLooper();
        //if (looper != null && looper == mContext.getMainLooper()) {
            //final IllegalStateException exception = new IllegalStateException(
                    //"calling this from your main thread can lead to deadlock");
            //Log.e(TAG, "calling this from your main thread can lead to deadlock and/or ANRs",
                    //exception);
            //if (mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.FROYO) {
                //throw exception;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.039 -0400", hash_original_method = "80D38BDC6E0DE7333CAAD84CC9E6E84A", hash_generated_method = "313E9D94E8CECB06EFAFC8E5C0CA04C5")
    private void postToHandler(Handler handler, final AccountManagerCallback<Bundle> callback,
            final AccountManagerFuture<Bundle> future) {
        addTaint(future.getTaint());
        addTaint(callback.getTaint());
        addTaint(handler.getTaint());
        handler = handler == null ? mMainHandler : handler;
        handler.post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.037 -0400", hash_original_method = "BDBA0E8ABF21CCC323F7A43F04981195", hash_generated_method = "0CA3FE6CFE2D535345F3115B21FF729A")
        public void run() {
            callback.run(future);
            // ---------- Original Method ----------
            //callback.run(future);
        }
});
        // ---------- Original Method ----------
        //handler = handler == null ? mMainHandler : handler;
        //handler.post(new Runnable() {
            //public void run() {
                //callback.run(future);
            //}
        //});
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.048 -0400", hash_original_method = "20F25A89C89C92245636BC8DCFF18BD7", hash_generated_method = "3A2A32EA4123F98789B49893C89592C0")
    private void postToHandler(Handler handler, final OnAccountsUpdateListener listener,
            final Account[] accounts) {
        addTaint(accounts[0].getTaint());
        addTaint(listener.getTaint());
        addTaint(handler.getTaint());
        final Account[] accountsCopy = new Account[accounts.length];
        System.arraycopy(accounts, 0, accountsCopy, 0, accountsCopy.length);
        handler = (handler == null) ? mMainHandler : handler;
        handler.post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.046 -0400", hash_original_method = "8E333205C0A7A1853354D3DAC2CB74E8", hash_generated_method = "A22A972F5E35D7E3C15D79722DEB108F")
        public void run() {
            try 
            {
                listener.onAccountsUpdated(accountsCopy);
            } //End block
            catch (SQLException e)
            {
            } //End block
            // ---------- Original Method ----------
            //try {
                    //listener.onAccountsUpdated(accountsCopy);
                //} catch (SQLException e) {
                    //Log.e(TAG, "Can't update accounts", e);
                //}
        }
});
        // ---------- Original Method ----------
        //final Account[] accountsCopy = new Account[accounts.length];
        //System.arraycopy(accounts, 0, accountsCopy, 0, accountsCopy.length);
        //handler = (handler == null) ? mMainHandler : handler;
        //handler.post(new Runnable() {
            //public void run() {
                //try {
                    //listener.onAccountsUpdated(accountsCopy);
                //} catch (SQLException e) {
                    //Log.e(TAG, "Can't update accounts", e);
                //}
            //}
        //});
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.054 -0400", hash_original_method = "6FDE075EEB86D1BECEDE842FFDA184DE", hash_generated_method = "9CA9B1125603D7BBA2FD273A11BF2463")
    private Exception convertErrorToException(int code, String message) {
        addTaint(message.getTaint());
        addTaint(code);
        if(code == ERROR_CODE_NETWORK_ERROR)        
        {
Exception varD49BA77971BE8FFE69DAEADCD296A867_451239412 =             new IOException(message);
            varD49BA77971BE8FFE69DAEADCD296A867_451239412.addTaint(taint);
            return varD49BA77971BE8FFE69DAEADCD296A867_451239412;
        } //End block
        if(code == ERROR_CODE_UNSUPPORTED_OPERATION)        
        {
Exception var84C15D5A27C7BF62148868CF27DC7C0B_2015511262 =             new UnsupportedOperationException(message);
            var84C15D5A27C7BF62148868CF27DC7C0B_2015511262.addTaint(taint);
            return var84C15D5A27C7BF62148868CF27DC7C0B_2015511262;
        } //End block
        if(code == ERROR_CODE_INVALID_RESPONSE)        
        {
Exception varB112E87B12E2B59F9C53CCF508EEEC4A_1438312707 =             new AuthenticatorException(message);
            varB112E87B12E2B59F9C53CCF508EEEC4A_1438312707.addTaint(taint);
            return varB112E87B12E2B59F9C53CCF508EEEC4A_1438312707;
        } //End block
        if(code == ERROR_CODE_BAD_ARGUMENTS)        
        {
Exception varBA95164A78C837CF35BB1C0FF86E66FF_13430568 =             new IllegalArgumentException(message);
            varBA95164A78C837CF35BB1C0FF86E66FF_13430568.addTaint(taint);
            return varBA95164A78C837CF35BB1C0FF86E66FF_13430568;
        } //End block
Exception varB112E87B12E2B59F9C53CCF508EEEC4A_924280050 =         new AuthenticatorException(message);
        varB112E87B12E2B59F9C53CCF508EEEC4A_924280050.addTaint(taint);
        return varB112E87B12E2B59F9C53CCF508EEEC4A_924280050;
        // ---------- Original Method ----------
        //if (code == ERROR_CODE_NETWORK_ERROR) {
            //return new IOException(message);
        //}
        //if (code == ERROR_CODE_UNSUPPORTED_OPERATION) {
            //return new UnsupportedOperationException(message);
        //}
        //if (code == ERROR_CODE_INVALID_RESPONSE) {
            //return new AuthenticatorException(message);
        //}
        //if (code == ERROR_CODE_BAD_ARGUMENTS) {
            //return new IllegalArgumentException(message);
        //}
        //return new AuthenticatorException(message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.062 -0400", hash_original_method = "801F35A66961F670B5EADD181BA66DC7", hash_generated_method = "270CB197F45DE231D56F688C061F2F19")
    public AccountManagerFuture<Bundle> getAuthTokenByFeatures(
            final String accountType, final String authTokenType, final String[] features,
            final Activity activity, final Bundle addAccountOptions,
            final Bundle getAuthTokenOptions,
            final AccountManagerCallback<Bundle> callback, final Handler handler) {
        addTaint(handler.getTaint());
        addTaint(callback.getTaint());
        addTaint(getAuthTokenOptions.getTaint());
        addTaint(addAccountOptions.getTaint());
        addTaint(activity.getTaint());
        addTaint(features[0].getTaint());
        addTaint(authTokenType.getTaint());
        addTaint(accountType.getTaint());
        if(accountType == null)        
        {
        IllegalArgumentException var3FEF5283C635241049D3258C060D2A11_1429420924 = new IllegalArgumentException("account type is null");
        var3FEF5283C635241049D3258C060D2A11_1429420924.addTaint(taint);
        throw var3FEF5283C635241049D3258C060D2A11_1429420924;
        }
        if(authTokenType == null)        
        {
        IllegalArgumentException var0343EB95D47FDF1150074966B4E27105_559036627 = new IllegalArgumentException("authTokenType is null");
        var0343EB95D47FDF1150074966B4E27105_559036627.addTaint(taint);
        throw var0343EB95D47FDF1150074966B4E27105_559036627;
        }
        final GetAuthTokenByTypeAndFeaturesTask task = new GetAuthTokenByTypeAndFeaturesTask(accountType, authTokenType, features,
                activity, addAccountOptions, getAuthTokenOptions, callback, handler);
        task.start();
AccountManagerFuture<Bundle> varE3FBC805688C6CF32CF252D3CB460B3C_14640056 =         task;
        varE3FBC805688C6CF32CF252D3CB460B3C_14640056.addTaint(taint);
        return varE3FBC805688C6CF32CF252D3CB460B3C_14640056;
        // ---------- Original Method ----------
        //if (accountType == null) throw new IllegalArgumentException("account type is null");
        //if (authTokenType == null) throw new IllegalArgumentException("authTokenType is null");
        //final GetAuthTokenByTypeAndFeaturesTask task =
                //new GetAuthTokenByTypeAndFeaturesTask(accountType, authTokenType, features,
                //activity, addAccountOptions, getAuthTokenOptions, callback, handler);
        //task.start();
        //return task;
    }

    
    @DSModeled(DSC.SAFE)
    static public Intent newChooseAccountIntent(Account selectedAccount,
            ArrayList<Account> allowableAccounts,
            String[] allowableAccountTypes,
            boolean alwaysPromptForAccount,
            String descriptionOverrideText,
            String addAccountAuthTokenType,
            String[] addAccountRequiredFeatures,
            Bundle addAccountOptions) {
        Intent intent = new Intent();
        intent.setClassName("android", "android.accounts.ChooseTypeAndAccountActivity");
        intent.putExtra(ChooseTypeAndAccountActivity.EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST,
                allowableAccounts);
        intent.putExtra(ChooseTypeAndAccountActivity.EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY,
                allowableAccountTypes);
        intent.putExtra(ChooseTypeAndAccountActivity.EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE,
                addAccountOptions);
        intent.putExtra(ChooseTypeAndAccountActivity.EXTRA_SELECTED_ACCOUNT, selectedAccount);
        intent.putExtra(ChooseTypeAndAccountActivity.EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT,
                alwaysPromptForAccount);
        intent.putExtra(ChooseTypeAndAccountActivity.EXTRA_DESCRIPTION_TEXT_OVERRIDE,
                descriptionOverrideText);
        intent.putExtra(ChooseTypeAndAccountActivity.EXTRA_ADD_ACCOUNT_AUTH_TOKEN_TYPE_STRING,
                addAccountAuthTokenType);
        intent.putExtra(
                ChooseTypeAndAccountActivity.EXTRA_ADD_ACCOUNT_REQUIRED_FEATURES_STRING_ARRAY,
                addAccountRequiredFeatures);
        return intent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.075 -0400", hash_original_method = "7A5668A93C6BCE258395457FB89679A1", hash_generated_method = "951E02840BF1F6896ABEE0E8B3FB3F85")
    public void addOnAccountsUpdatedListener(final OnAccountsUpdateListener listener,
            Handler handler, boolean updateImmediately) {
        addTaint(updateImmediately);
        addTaint(handler.getTaint());
        addTaint(listener.getTaint());
        if(listener == null)        
        {
            IllegalArgumentException var27C26F8F826117C9E6C7C46F036A0E78_1003498763 = new IllegalArgumentException("the listener is null");
            var27C26F8F826117C9E6C7C46F036A0E78_1003498763.addTaint(taint);
            throw var27C26F8F826117C9E6C7C46F036A0E78_1003498763;
        } //End block
        synchronized
(mAccountsUpdatedListeners)        {
            if(mAccountsUpdatedListeners.containsKey(listener))            
            {
                IllegalStateException var73DDD708B9F638937AEEA3A1722B32DA_1700864247 = new IllegalStateException("this listener is already added");
                var73DDD708B9F638937AEEA3A1722B32DA_1700864247.addTaint(taint);
                throw var73DDD708B9F638937AEEA3A1722B32DA_1700864247;
            } //End block
            final boolean wasEmpty = mAccountsUpdatedListeners.isEmpty();
            mAccountsUpdatedListeners.put(listener, handler);
            if(wasEmpty)            
            {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(LOGIN_ACCOUNTS_CHANGED_ACTION);
                intentFilter.addAction(Intent.ACTION_DEVICE_STORAGE_OK);
                mContext.registerReceiver(mAccountsChangedBroadcastReceiver, intentFilter);
            } //End block
        } //End block
        if(updateImmediately)        
        {
            postToHandler(handler, listener, getAccounts());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.078 -0400", hash_original_method = "66F9A18B2BBFAE47B027D9D23A795F11", hash_generated_method = "AF3780A7EFBE5E70C47E4B4640680E9E")
    public void removeOnAccountsUpdatedListener(OnAccountsUpdateListener listener) {
        addTaint(listener.getTaint());
        if(listener == null)        
        {
        IllegalArgumentException varA47873FC7599174144A251E0E98D02E8_547837464 = new IllegalArgumentException("listener is null");
        varA47873FC7599174144A251E0E98D02E8_547837464.addTaint(taint);
        throw varA47873FC7599174144A251E0E98D02E8_547837464;
        }
        synchronized
(mAccountsUpdatedListeners)        {
            if(!mAccountsUpdatedListeners.containsKey(listener))            
            {
                return;
            } //End block
            mAccountsUpdatedListeners.remove(listener);
            if(mAccountsUpdatedListeners.isEmpty())            
            {
                mContext.unregisterReceiver(mAccountsChangedBroadcastReceiver);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (listener == null) throw new IllegalArgumentException("listener is null");
        //synchronized (mAccountsUpdatedListeners) {
            //if (!mAccountsUpdatedListeners.containsKey(listener)) {
                //Log.e(TAG, "Listener was not previously added");
                //return;
            //}
            //mAccountsUpdatedListeners.remove(listener);
            //if (mAccountsUpdatedListeners.isEmpty()) {
                //mContext.unregisterReceiver(mAccountsChangedBroadcastReceiver);
            //}
        //}
    }

    
    private abstract class AmsTask extends FutureTask<Bundle> implements AccountManagerFuture<Bundle> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.082 -0400", hash_original_field = "E72652B09AB331E8E60D8A37942A6989", hash_generated_field = "BCCFC11938EEC7DE34A0DE82C0A04729")

        IAccountManagerResponse mResponse;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.083 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

        Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.085 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "382974AD998518E9037A5E4EDC0E3105")

        AccountManagerCallback<Bundle> mCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.085 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "3895D7E6DB5042DA7856DC78E391C7B9")

        Activity mActivity;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.091 -0400", hash_original_method = "B1B053361B7316D8D8AF57ECEF4696C6", hash_generated_method = "28BC1A87CA8A0CC402A36B363995E588")
        public  AmsTask(Activity activity, Handler handler, AccountManagerCallback<Bundle> callback) {
            super(new Callable<Bundle>() {
                public Bundle call() throws Exception {
                    throw new IllegalStateException("this should never be called");
                }
            });
            mHandler = handler;
            mCallback = callback;
            mActivity = activity;
            mResponse = new Response();
            // ---------- Original Method ----------
            //mHandler = handler;
            //mCallback = callback;
            //mActivity = activity;
            //mResponse = new Response();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.095 -0400", hash_original_method = "E07DE3E7F6D29C4D4BDAC4812A3CF430", hash_generated_method = "08444F07D0304588BB8B389DB91065EB")
        public final AccountManagerFuture<Bundle> start() {
            try 
            {
                doWork();
            } //End block
            catch (RemoteException e)
            {
                setException(e);
            } //End block
AccountManagerFuture<Bundle> var72A74007B2BE62B849F475C7BDA4658B_1156969260 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1156969260.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1156969260;
            // ---------- Original Method ----------
            //try {
                //doWork();
            //} catch (RemoteException e) {
                //setException(e);
            //}
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.099 -0400", hash_original_method = "127E02577FE14DDB30AB934EB38A0588", hash_generated_method = "4746B5D5C353C5A89229EE21403F96A7")
        protected void set(Bundle bundle) {
            addTaint(bundle.getTaint());
            if(bundle == null)            
            {
            } //End block
            super.set(bundle);
            // ---------- Original Method ----------
            //if (bundle == null) {
                //Log.e(TAG, "the bundle must not be null", new Exception());
            //}
            //super.set(bundle);
        }

        
        @DSModeled(DSC.SAFE)
        public abstract void doWork() throws RemoteException;

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.107 -0400", hash_original_method = "6C34E289CBAB2DD26AA2603338539143", hash_generated_method = "F9C35AFCD44C9C04B3C9D84CE29F726A")
        private Bundle internalGetResult(Long timeout, TimeUnit unit) throws OperationCanceledException, IOException, AuthenticatorException {
            addTaint(unit.getTaint());
            addTaint(timeout.getTaint());
            if(!isDone())            
            {
                ensureNotOnMainThread();
            } //End block
            try 
            {
                if(timeout == null)                
                {
Bundle varE05826B33CE3BB3E950704304F321003_904716658 =                     get();
                    varE05826B33CE3BB3E950704304F321003_904716658.addTaint(taint);
                    return varE05826B33CE3BB3E950704304F321003_904716658;
                } //End block
                else
                {
Bundle varC29A4AA05E7B4279C36345837ED71E88_457156107 =                     get(timeout, unit);
                    varC29A4AA05E7B4279C36345837ED71E88_457156107.addTaint(taint);
                    return varC29A4AA05E7B4279C36345837ED71E88_457156107;
                } //End block
            } //End block
            catch (CancellationException e)
            {
                OperationCanceledException var489A2CB176387ED788C84D313A8E80A8_11722296 = new OperationCanceledException();
                var489A2CB176387ED788C84D313A8E80A8_11722296.addTaint(taint);
                throw var489A2CB176387ED788C84D313A8E80A8_11722296;
            } //End block
            catch (TimeoutException e)
            {
            } //End block
            catch (InterruptedException e)
            {
            } //End block
            catch (ExecutionException e)
            {
                final Throwable cause = e.getCause();
                if(cause instanceof IOException)                
                {
                    IOException varA8CE4520913DFE6D323B16DA5398FDBA_562294309 = (IOException) cause;
                    varA8CE4520913DFE6D323B16DA5398FDBA_562294309.addTaint(taint);
                    throw varA8CE4520913DFE6D323B16DA5398FDBA_562294309;
                } //End block
                else
                if(cause instanceof UnsupportedOperationException)                
                {
                    AuthenticatorException var29FD6CBF16AA9C29D6E479E7DACCE852_718990490 = new AuthenticatorException(cause);
                    var29FD6CBF16AA9C29D6E479E7DACCE852_718990490.addTaint(taint);
                    throw var29FD6CBF16AA9C29D6E479E7DACCE852_718990490;
                } //End block
                else
                if(cause instanceof AuthenticatorException)                
                {
                    AuthenticatorException varB43496F9EDC051E222D6D5AA8F1E1D9B_870443696 = (AuthenticatorException) cause;
                    varB43496F9EDC051E222D6D5AA8F1E1D9B_870443696.addTaint(taint);
                    throw varB43496F9EDC051E222D6D5AA8F1E1D9B_870443696;
                } //End block
                else
                if(cause instanceof RuntimeException)                
                {
                    RuntimeException var2BEB6EF3D41E44EED5E35024D3C50335_171459804 = (RuntimeException) cause;
                    var2BEB6EF3D41E44EED5E35024D3C50335_171459804.addTaint(taint);
                    throw var2BEB6EF3D41E44EED5E35024D3C50335_171459804;
                } //End block
                else
                if(cause instanceof Error)                
                {
                    Error varF690D0FEA4496CAA0F487E9481A0D919_1557049157 = (Error) cause;
                    varF690D0FEA4496CAA0F487E9481A0D919_1557049157.addTaint(taint);
                    throw varF690D0FEA4496CAA0F487E9481A0D919_1557049157;
                } //End block
                else
                {
                    IllegalStateException varF60D9E53AC195769C06EA2A79A7E7653_793780843 = new IllegalStateException(cause);
                    varF60D9E53AC195769C06EA2A79A7E7653_793780843.addTaint(taint);
                    throw varF60D9E53AC195769C06EA2A79A7E7653_793780843;
                } //End block
            } //End block
            finally 
            {
                cancel(true );
            } //End block
            OperationCanceledException var489A2CB176387ED788C84D313A8E80A8_356909286 = new OperationCanceledException();
            var489A2CB176387ED788C84D313A8E80A8_356909286.addTaint(taint);
            throw var489A2CB176387ED788C84D313A8E80A8_356909286;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.116 -0400", hash_original_method = "7428E8716809F4A01AF7F726F040DE64", hash_generated_method = "ED07E38CE5EC33149E0CEB1CC19AF672")
        public Bundle getResult() throws OperationCanceledException, IOException, AuthenticatorException {
Bundle var6DB880D2F96BCDB0DB0C5333CAB0CBD0_1053827127 =             internalGetResult(null, null);
            var6DB880D2F96BCDB0DB0C5333CAB0CBD0_1053827127.addTaint(taint);
            return var6DB880D2F96BCDB0DB0C5333CAB0CBD0_1053827127;
            // ---------- Original Method ----------
            //return internalGetResult(null, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.123 -0400", hash_original_method = "2DB61FA3CF370F8EAC405A022C9CA553", hash_generated_method = "D08BE10C9F8E362D193233698987FBCD")
        public Bundle getResult(long timeout, TimeUnit unit) throws OperationCanceledException, IOException, AuthenticatorException {
            addTaint(unit.getTaint());
            addTaint(timeout);
Bundle var9D01E8DE3D6E1C2C2386B1AD0AD3C5EC_114891976 =             internalGetResult(timeout, unit);
            var9D01E8DE3D6E1C2C2386B1AD0AD3C5EC_114891976.addTaint(taint);
            return var9D01E8DE3D6E1C2C2386B1AD0AD3C5EC_114891976;
            // ---------- Original Method ----------
            //return internalGetResult(timeout, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.126 -0400", hash_original_method = "3B9C9BC58CC1D6BA66EF9DB56725570D", hash_generated_method = "C6ACA7FEB19F044A3793E96E12569666")
        protected void done() {
            if(mCallback != null)            
            {
                postToHandler(mHandler, mCallback, this);
            } //End block
            // ---------- Original Method ----------
            //if (mCallback != null) {
                //postToHandler(mHandler, mCallback, this);
            //}
        }

        
        private class Response extends IAccountManagerResponse.Stub {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.129 -0400", hash_original_method = "1C91C9705FD3BE3D2A4F4357891D41FD", hash_generated_method = "1C91C9705FD3BE3D2A4F4357891D41FD")
            public Response ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.133 -0400", hash_original_method = "BC11F9A6ED106794CC5C9152E9BD3B43", hash_generated_method = "AE0DC4BB71B6E644FCD2CC26FB83E610")
            public void onResult(Bundle bundle) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(bundle.getTaint());
                Intent intent = bundle.getParcelable(KEY_INTENT);
                if(intent != null && mActivity != null)                
                {
                    mActivity.startActivity(intent);
                } //End block
                else
                if(bundle.getBoolean("retry"))                
                {
                    try 
                    {
                        doWork();
                    } //End block
                    catch (RemoteException e)
                    {
                    } //End block
                } //End block
                else
                {
                    set(bundle);
                } //End block
                // ---------- Original Method ----------
                //Intent intent = bundle.getParcelable(KEY_INTENT);
                //if (intent != null && mActivity != null) {
                    //mActivity.startActivity(intent);
                //} else if (bundle.getBoolean("retry")) {
                    //try {
                        //doWork();
                    //} catch (RemoteException e) {
                    //}
                //} else {
                    //set(bundle);
                //}
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.140 -0400", hash_original_method = "DD61FDBEB518045420249589A7AE75D2", hash_generated_method = "32D16F6FE7CC45BC71A427F58177EA53")
            public void onError(int code, String message) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(message.getTaint());
                addTaint(code);
                if(code == ERROR_CODE_CANCELED)                
                {
                    cancel(true );
                    return;
                } //End block
                setException(convertErrorToException(code, message));
                // ---------- Original Method ----------
                //if (code == ERROR_CODE_CANCELED) {
                    //cancel(true );
                    //return;
                //}
                //setException(convertErrorToException(code, message));
            }

            
        }


        
    }


    
    private abstract class BaseFutureTask<T> extends FutureTask<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.147 -0400", hash_original_field = "E72652B09AB331E8E60D8A37942A6989", hash_generated_field = "A54F64CAD983BA5040DC733186B2FF3B")

        public IAccountManagerResponse mResponse;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.149 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

        Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.153 -0400", hash_original_method = "26CFE7EFCBFE85C3047A425A4F720F86", hash_generated_method = "07FC7C468CB0119415FE7B69CAD44E68")
        public  BaseFutureTask(Handler handler) {
            super(new Callable<T>() {
                public T call() throws Exception {
                    throw new IllegalStateException("this should never be called");
                }
            });
            mHandler = handler;
            mResponse = new Response();
            // ---------- Original Method ----------
            //mHandler = handler;
            //mResponse = new Response();
        }

        
        @DSModeled(DSC.SAFE)
        public abstract void doWork() throws RemoteException;

        
        public abstract T bundleToResult(Bundle bundle) throws AuthenticatorException;

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.162 -0400", hash_original_method = "B01C5697E6FB95B4A78D57A4C431F13F", hash_generated_method = "46E928041BDE8537752EB60BAA1FCD58")
        protected void postRunnableToHandler(Runnable runnable) {
            addTaint(runnable.getTaint());
            Handler handler = (mHandler == null) ? mMainHandler : mHandler;
            handler.post(runnable);
            // ---------- Original Method ----------
            //Handler handler = (mHandler == null) ? mMainHandler : mHandler;
            //handler.post(runnable);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.166 -0400", hash_original_method = "030130E13746E076BBD203E6D46CECFF", hash_generated_method = "255E12B7B835ACF16F252F3ADA55C2A0")
        protected void startTask() {
            try 
            {
                doWork();
            } //End block
            catch (RemoteException e)
            {
                setException(e);
            } //End block
            // ---------- Original Method ----------
            //try {
                //doWork();
            //} catch (RemoteException e) {
                //setException(e);
            //}
        }

        
        protected class Response extends IAccountManagerResponse.Stub {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.170 -0400", hash_original_method = "1C91C9705FD3BE3D2A4F4357891D41FD", hash_generated_method = "1C91C9705FD3BE3D2A4F4357891D41FD")
            public Response ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.175 -0400", hash_original_method = "B8AEC5DE9AFE3040461BEFA9E791EE34", hash_generated_method = "5907B2238C51B69B98935E09B5E833A9")
            public void onResult(Bundle bundle) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(bundle.getTaint());
                try 
                {
                    T result = bundleToResult(bundle);
                    if(result == null)                    
                    {
                        return;
                    } //End block
                    set(result);
                    return;
                } //End block
                catch (ClassCastException e)
                {
                } //End block
                catch (AuthenticatorException e)
                {
                } //End block
                onError(ERROR_CODE_INVALID_RESPONSE, "no result in response");
                // ---------- Original Method ----------
                //try {
                    //T result = bundleToResult(bundle);
                    //if (result == null) {
                        //return;
                    //}
                    //set(result);
                    //return;
                //} catch (ClassCastException e) {
                //} catch (AuthenticatorException e) {
                //}
                //onError(ERROR_CODE_INVALID_RESPONSE, "no result in response");
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.180 -0400", hash_original_method = "DD61FDBEB518045420249589A7AE75D2", hash_generated_method = "32D16F6FE7CC45BC71A427F58177EA53")
            public void onError(int code, String message) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(message.getTaint());
                addTaint(code);
                if(code == ERROR_CODE_CANCELED)                
                {
                    cancel(true );
                    return;
                } //End block
                setException(convertErrorToException(code, message));
                // ---------- Original Method ----------
                //if (code == ERROR_CODE_CANCELED) {
                    //cancel(true );
                    //return;
                //}
                //setException(convertErrorToException(code, message));
            }

            
        }


        
    }


    
    private abstract class Future2Task<T> extends BaseFutureTask<T> implements AccountManagerFuture<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.182 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "719E4FBEE0E6D8BC8E61E553D79747F3")

        AccountManagerCallback<T> mCallback;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.187 -0400", hash_original_method = "FC1DD61776F9D5FC9C321068652B66F1", hash_generated_method = "B34773829AE61D9E9A09F15F11D8449D")
        public  Future2Task(Handler handler, AccountManagerCallback<T> callback) {
            super(handler);
            addTaint(handler.getTaint());
            mCallback = callback;
            // ---------- Original Method ----------
            //mCallback = callback;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.194 -0400", hash_original_method = "762C0B9FE5A1A00B697BA32E9AEAF22E", hash_generated_method = "1BCD2569B7AA02F02D6F14E93D6DCAC3")
        protected void done() {
            if(mCallback != null)            
            {
                postRunnableToHandler(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.192 -0400", hash_original_method = "0F70B80A50B592CBF5F504B35808D596", hash_generated_method = "7101081B29B4523A9AECBBD0EF73571E")
            public void run() {
                mCallback.run(Future2Task.this);
                // ---------- Original Method ----------
                //mCallback.run(Future2Task.this);
            }
});
            } //End block
            // ---------- Original Method ----------
            //if (mCallback != null) {
                //postRunnableToHandler(new Runnable() {
                    //public void run() {
                        //mCallback.run(Future2Task.this);
                    //}
                //});
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.199 -0400", hash_original_method = "31A85EDC6833090D765F6613E9274CD1", hash_generated_method = "FB7859AA6182BEF74525155CD0E5D732")
        public Future2Task<T> start() {
            startTask();
Future2Task<T> var72A74007B2BE62B849F475C7BDA4658B_1284376435 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1284376435.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1284376435;
            // ---------- Original Method ----------
            //startTask();
            //return this;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.204 -0400", hash_original_method = "41F0112BBEC6735226A2F41FF2202D7E", hash_generated_method = "149214C5C31E317F77C9D84079D6194B")
        private T internalGetResult(Long timeout, TimeUnit unit) throws OperationCanceledException, IOException, AuthenticatorException {
            addTaint(unit.getTaint());
            addTaint(timeout.getTaint());
            if(!isDone())            
            {
                ensureNotOnMainThread();
            } //End block
            try 
            {
                if(timeout == null)                
                {
T varE05826B33CE3BB3E950704304F321003_1706384227 =                     get();
                    varE05826B33CE3BB3E950704304F321003_1706384227.addTaint(taint);
                    return varE05826B33CE3BB3E950704304F321003_1706384227;
                } //End block
                else
                {
T varC29A4AA05E7B4279C36345837ED71E88_876560267 =                     get(timeout, unit);
                    varC29A4AA05E7B4279C36345837ED71E88_876560267.addTaint(taint);
                    return varC29A4AA05E7B4279C36345837ED71E88_876560267;
                } //End block
            } //End block
            catch (InterruptedException e)
            {
            } //End block
            catch (TimeoutException e)
            {
            } //End block
            catch (CancellationException e)
            {
            } //End block
            catch (ExecutionException e)
            {
                final Throwable cause = e.getCause();
                if(cause instanceof IOException)                
                {
                    IOException varA8CE4520913DFE6D323B16DA5398FDBA_1547489444 = (IOException) cause;
                    varA8CE4520913DFE6D323B16DA5398FDBA_1547489444.addTaint(taint);
                    throw varA8CE4520913DFE6D323B16DA5398FDBA_1547489444;
                } //End block
                else
                if(cause instanceof UnsupportedOperationException)                
                {
                    AuthenticatorException var29FD6CBF16AA9C29D6E479E7DACCE852_604006103 = new AuthenticatorException(cause);
                    var29FD6CBF16AA9C29D6E479E7DACCE852_604006103.addTaint(taint);
                    throw var29FD6CBF16AA9C29D6E479E7DACCE852_604006103;
                } //End block
                else
                if(cause instanceof AuthenticatorException)                
                {
                    AuthenticatorException varB43496F9EDC051E222D6D5AA8F1E1D9B_1769097281 = (AuthenticatorException) cause;
                    varB43496F9EDC051E222D6D5AA8F1E1D9B_1769097281.addTaint(taint);
                    throw varB43496F9EDC051E222D6D5AA8F1E1D9B_1769097281;
                } //End block
                else
                if(cause instanceof RuntimeException)                
                {
                    RuntimeException var2BEB6EF3D41E44EED5E35024D3C50335_414525798 = (RuntimeException) cause;
                    var2BEB6EF3D41E44EED5E35024D3C50335_414525798.addTaint(taint);
                    throw var2BEB6EF3D41E44EED5E35024D3C50335_414525798;
                } //End block
                else
                if(cause instanceof Error)                
                {
                    Error varF690D0FEA4496CAA0F487E9481A0D919_1914198591 = (Error) cause;
                    varF690D0FEA4496CAA0F487E9481A0D919_1914198591.addTaint(taint);
                    throw varF690D0FEA4496CAA0F487E9481A0D919_1914198591;
                } //End block
                else
                {
                    IllegalStateException varF60D9E53AC195769C06EA2A79A7E7653_1226067870 = new IllegalStateException(cause);
                    varF60D9E53AC195769C06EA2A79A7E7653_1226067870.addTaint(taint);
                    throw varF60D9E53AC195769C06EA2A79A7E7653_1226067870;
                } //End block
            } //End block
            finally 
            {
                cancel(true );
            } //End block
            OperationCanceledException var489A2CB176387ED788C84D313A8E80A8_1843293076 = new OperationCanceledException();
            var489A2CB176387ED788C84D313A8E80A8_1843293076.addTaint(taint);
            throw var489A2CB176387ED788C84D313A8E80A8_1843293076;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.210 -0400", hash_original_method = "F09B519E265A8A66FE763E800742348B", hash_generated_method = "C43FF29475D1BB966BE5AA312CB45EFE")
        public T getResult() throws OperationCanceledException, IOException, AuthenticatorException {
T var6DB880D2F96BCDB0DB0C5333CAB0CBD0_337839780 =             internalGetResult(null, null);
            var6DB880D2F96BCDB0DB0C5333CAB0CBD0_337839780.addTaint(taint);
            return var6DB880D2F96BCDB0DB0C5333CAB0CBD0_337839780;
            // ---------- Original Method ----------
            //return internalGetResult(null, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.214 -0400", hash_original_method = "50CBD7888960B26C4BF28EA57E206BB1", hash_generated_method = "BBAAF926801FA0571259C00D89433D4B")
        public T getResult(long timeout, TimeUnit unit) throws OperationCanceledException, IOException, AuthenticatorException {
            addTaint(unit.getTaint());
            addTaint(timeout);
T var9D01E8DE3D6E1C2C2386B1AD0AD3C5EC_2093155544 =             internalGetResult(timeout, unit);
            var9D01E8DE3D6E1C2C2386B1AD0AD3C5EC_2093155544.addTaint(taint);
            return var9D01E8DE3D6E1C2C2386B1AD0AD3C5EC_2093155544;
            // ---------- Original Method ----------
            //return internalGetResult(timeout, unit);
        }

        
    }


    
    private class GetAuthTokenByTypeAndFeaturesTask extends AmsTask implements AccountManagerCallback<Bundle> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.220 -0400", hash_original_field = "89EED8F86B939D76F6E66671841F66E0", hash_generated_field = "DA7FCA7FD25B2715DDA5B1151A329B57")

        volatile AccountManagerFuture<Bundle> mFuture = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.222 -0400", hash_original_field = "D3E1F03AA680CFA730A921954023E5B9", hash_generated_field = "1BAC3F5B48D7CBDC0DEC096887906F9A")

        String mAccountType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.224 -0400", hash_original_field = "69D299670D936CF5E779CEC994C9B669", hash_generated_field = "62E235D18D61381B167C250C0385DCF5")

        String mAuthTokenType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.225 -0400", hash_original_field = "B6FEAD34C9CE2FFD9FDB8BCB7536B5B4", hash_generated_field = "BB73EBD9036EEEC92FAB5A91A39B5A6F")

        String[] mFeatures;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.226 -0400", hash_original_field = "612B48E31872CED4823D637CF52B7B68", hash_generated_field = "7B6AE567E0F7C37B83B94413E80422D3")

        Bundle mAddAccountOptions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.228 -0400", hash_original_field = "DEE378E96D6BC88E66F300481BD20A99", hash_generated_field = "4B7678D538696871E7C4A9E9A154E69B")

        Bundle mLoginOptions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.230 -0400", hash_original_field = "4AC3E767900DAB7270D2E11DF66BD083", hash_generated_field = "9AB039BA73F970DDDFBFE5E982A0A257")

        AccountManagerCallback<Bundle> mMyCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.231 -0400", hash_original_field = "FF4A321CA3E8F9F098306FE32821F7F6", hash_generated_field = "71E70B13764C89A5A2D6CAA3A090D703")

        private volatile int mNumAccounts = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.244 -0400", hash_original_method = "8B428F75DFA4C0F7DC2037249CE783CE", hash_generated_method = "E092729DDFA63793AD8A4138EE6098E2")
          GetAuthTokenByTypeAndFeaturesTask(final String accountType, final String authTokenType,
                final String[] features, Activity activityForPrompting,
                final Bundle addAccountOptions, final Bundle loginOptions,
                AccountManagerCallback<Bundle> callback, Handler handler) {
            super(activityForPrompting, handler, callback);
            addTaint(handler.getTaint());
            addTaint(callback.getTaint());
            addTaint(activityForPrompting.getTaint());
            if(accountType == null)            
            {
            IllegalArgumentException var3FEF5283C635241049D3258C060D2A11_2071615968 = new IllegalArgumentException("account type is null");
            var3FEF5283C635241049D3258C060D2A11_2071615968.addTaint(taint);
            throw var3FEF5283C635241049D3258C060D2A11_2071615968;
            }
            mAccountType = accountType;
            mAuthTokenType = authTokenType;
            mFeatures = features;
            mAddAccountOptions = addAccountOptions;
            mLoginOptions = loginOptions;
            mMyCallback = this;
            // ---------- Original Method ----------
            //if (accountType == null) throw new IllegalArgumentException("account type is null");
            //mAccountType = accountType;
            //mAuthTokenType = authTokenType;
            //mFeatures = features;
            //mAddAccountOptions = addAccountOptions;
            //mLoginOptions = loginOptions;
            //mMyCallback = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.259 -0400", hash_original_method = "C4C5F207D191035A436136641EA5FDB4", hash_generated_method = "A635702F7D2BEA73C5D2202B651CB468")
        public void doWork() throws RemoteException {
            getAccountsByTypeAndFeatures(mAccountType, mFeatures,
                    new AccountManagerCallback<Account[]>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.253 -0400", hash_original_method = "A16608B5927D0AB580BEC16F01D5E6C5", hash_generated_method = "49E8F6FF13DB92598A6D929C1A5B00DF")
            public void run(AccountManagerFuture<Account[]> future) {
                addTaint(future.getTaint());
                Account[] accounts;
                try 
                {
                    accounts = future.getResult();
                } //End block
                catch (OperationCanceledException e)
                {
                    setException(e);
                    return;
                } //End block
                catch (IOException e)
                {
                    setException(e);
                    return;
                } //End block
                catch (AuthenticatorException e)
                {
                    setException(e);
                    return;
                } //End block
                mNumAccounts = accounts.length;
                if(accounts.length == 0)                
                {
                    if(mActivity != null)                    
                    {
                        mFuture = addAccount(mAccountType, mAuthTokenType, mFeatures,
                                            mAddAccountOptions, mActivity, mMyCallback, mHandler);
                    } //End block
                    else
                    {
                        Bundle result = new Bundle();
                        result.putString(KEY_ACCOUNT_NAME, null);
                        result.putString(KEY_ACCOUNT_TYPE, null);
                        result.putString(KEY_AUTHTOKEN, null);
                        try 
                        {
                            mResponse.onResult(result);
                        } //End block
                        catch (RemoteException e)
                        {
                        } //End block
                    } //End block
                } //End block
                else
                if(accounts.length == 1)                
                {
                    if(mActivity == null)                    
                    {
                        mFuture = getAuthToken(accounts[0], mAuthTokenType,
                                            false , mMyCallback, mHandler);
                    } //End block
                    else
                    {
                        mFuture = getAuthToken(accounts[0],
                                            mAuthTokenType, mLoginOptions,
                                            mActivity, mMyCallback, mHandler);
                    } //End block
                } //End block
                else
                {
                    if(mActivity != null)                    
                    {
                        IAccountManagerResponse chooseResponse = new IAccountManagerResponse.Stub() {
                                        public void onResult(Bundle value) throws RemoteException {
                                            Account account = new Account(
                                                    value.getString(KEY_ACCOUNT_NAME),
                                                    value.getString(KEY_ACCOUNT_TYPE));
                                            mFuture = getAuthToken(account, mAuthTokenType, mLoginOptions,
                                                    mActivity, mMyCallback, mHandler);
                                        }
                                        public void onError(int errorCode, String errorMessage)
                                                throws RemoteException {
                                            mResponse.onError(errorCode, errorMessage);
                                        }
                                    };
                        Intent intent = new Intent();
                        intent.setClassName("android",
                                            "android.accounts.ChooseAccountActivity");
                        intent.putExtra(KEY_ACCOUNTS, accounts);
                        intent.putExtra(KEY_ACCOUNT_MANAGER_RESPONSE,
                                            new AccountManagerResponse(chooseResponse));
                        mActivity.startActivity(intent);
                    } //End block
                    else
                    {
                        Bundle result = new Bundle();
                        result.putString(KEY_ACCOUNTS, null);
                        try 
                        {
                            mResponse.onResult(result);
                        } //End block
                        catch (RemoteException e)
                        {
                        } //End block
                    } //End block
                } //End block
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }
}, mHandler);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.264 -0400", hash_original_method = "770A26A7F965A1883CF21DF75B7155CF", hash_generated_method = "96B7951346214BE8AE61BF760ADA2D03")
        public void run(AccountManagerFuture<Bundle> future) {
            addTaint(future.getTaint());
            try 
            {
                final Bundle result = future.getResult();
                if(mNumAccounts == 0)                
                {
                    final String accountName = result.getString(KEY_ACCOUNT_NAME);
                    final String accountType = result.getString(KEY_ACCOUNT_TYPE);
                    if(TextUtils.isEmpty(accountName) || TextUtils.isEmpty(accountType))                    
                    {
                        setException(new AuthenticatorException("account not in result"));
                        return;
                    } //End block
                    final Account account = new Account(accountName, accountType);
                    mNumAccounts = 1;
                    getAuthToken(account, mAuthTokenType, null , mActivity,
                            mMyCallback, mHandler);
                    return;
                } //End block
                set(result);
            } //End block
            catch (OperationCanceledException e)
            {
                cancel(true );
            } //End block
            catch (IOException e)
            {
                setException(e);
            } //End block
            catch (AuthenticatorException e)
            {
                setException(e);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.268 -0400", hash_original_field = "F3D9B685FE257E35A5518E55C53EDBB5", hash_generated_field = "011994D593F4EA76C280FB7FCC436706")

    private static final String TAG = "AccountManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.270 -0400", hash_original_field = "5682D7209AD8196B50CDE69B11CF84FC", hash_generated_field = "839EE2AD959F91D7F8A30C4DF896A0A9")

    public static final int ERROR_CODE_REMOTE_EXCEPTION = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.272 -0400", hash_original_field = "7B304DDB9B040633C59F1FF30BF3152E", hash_generated_field = "28836EE16DABE4CC8F98413027A9030B")

    public static final int ERROR_CODE_NETWORK_ERROR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.274 -0400", hash_original_field = "D478BA52CD235A967541002997DC3AA6", hash_generated_field = "E9001C9A5A6B658887C8978E4189FD52")

    public static final int ERROR_CODE_CANCELED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.275 -0400", hash_original_field = "FBFA7BA888137604C744C4C94598EE2D", hash_generated_field = "215CD378075E4729EC91AA3C099AEFED")

    public static final int ERROR_CODE_INVALID_RESPONSE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.276 -0400", hash_original_field = "9B4921D822E6A752A161E9638B7B5855", hash_generated_field = "0BA889018A83A6B2347976FA0C25E335")

    public static final int ERROR_CODE_UNSUPPORTED_OPERATION = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.277 -0400", hash_original_field = "441E288400266D25BF96690B5B2648CF", hash_generated_field = "3B28C1EA1CA857E1ECC16D27FCB2B421")

    public static final int ERROR_CODE_BAD_ARGUMENTS = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.277 -0400", hash_original_field = "B5C112F89B649221CF8D5CCD13A3E67C", hash_generated_field = "12AE862392583AD965A36301576778CD")

    public static final int ERROR_CODE_BAD_REQUEST = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.278 -0400", hash_original_field = "24012699D9C87B37F55B94D84D834D40", hash_generated_field = "F859CD3519729A82BCD23BCE5084C439")

    public static final String KEY_ACCOUNT_NAME = "authAccount";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.279 -0400", hash_original_field = "875DAE202146AE21D8E5C0D20C4DBEF8", hash_generated_field = "01FDA1F42087656DFED808AC20B15C21")

    public static final String KEY_ACCOUNT_TYPE = "accountType";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.280 -0400", hash_original_field = "CC71893A4FCD1A1DD4453793B59C31DA", hash_generated_field = "3A382E093156E682D8C89BEB9C2CF37B")

    public static final String KEY_AUTHTOKEN = "authtoken";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.281 -0400", hash_original_field = "71D907CB05409A0E28D4B7C31B332693", hash_generated_field = "DD3EB87933A482E342BDBCADB6FCD849")

    public static final String KEY_INTENT = "intent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.282 -0400", hash_original_field = "7C785D3EB4603FD221BC62F1CCD0E7C5", hash_generated_field = "B6E4CF7265B3037CDACBE69F87D1F211")

    public static final String KEY_PASSWORD = "password";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.283 -0400", hash_original_field = "04E43CD01AECF48894BA8EE76CBB2644", hash_generated_field = "48376F363D9C8E28672349E76C9AB9D6")

    public static final String KEY_ACCOUNTS = "accounts";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.285 -0400", hash_original_field = "673D226C4294710314CFC5F6B369553B", hash_generated_field = "B6500903448CA38B1C135E7FAACA8E59")

    public static final String KEY_ACCOUNT_AUTHENTICATOR_RESPONSE = "accountAuthenticatorResponse";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.286 -0400", hash_original_field = "DF580DCDEB34BC7D8289BF21DC88D9CF", hash_generated_field = "6787B86CE20B7D25DB80F65A6DF78575")

    public static final String KEY_ACCOUNT_MANAGER_RESPONSE = "accountManagerResponse";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.286 -0400", hash_original_field = "6DD28DC2AE7EADDDE62185F19A5BC429", hash_generated_field = "A880DA3011386B62681F12DCA6F995AF")

    public static final String KEY_AUTHENTICATOR_TYPES = "authenticator_types";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.287 -0400", hash_original_field = "7207C3402EF475A67F25B0533D159155", hash_generated_field = "E3A6E02E13FC436339BAE96EF05B9915")

    public static final String KEY_AUTH_FAILED_MESSAGE = "authFailedMessage";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.288 -0400", hash_original_field = "8100DBE9D757B60FBC5FF35925499144", hash_generated_field = "6A52A1128A766E523E11400904962290")

    public static final String KEY_AUTH_TOKEN_LABEL = "authTokenLabelKey";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.289 -0400", hash_original_field = "3BBBF4EBA1F856CE971818A9E0752502", hash_generated_field = "0966148F1C7D6F1B380611DBCB3F9034")

    public static final String KEY_BOOLEAN_RESULT = "booleanResult";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.290 -0400", hash_original_field = "960A9762BF50C605FD3F96ED7CBD1E0F", hash_generated_field = "5C41C2089C3858E1102D472FE91ABBF6")

    public static final String KEY_ERROR_CODE = "errorCode";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.292 -0400", hash_original_field = "562D9F4AA7449DA657AD433238B9EBD8", hash_generated_field = "6F255AB3CB507FA25E18B20330ACC508")

    public static final String KEY_ERROR_MESSAGE = "errorMessage";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.293 -0400", hash_original_field = "A1665E1BED4929F1C7402AA61D7E505B", hash_generated_field = "41604824FAA4E2183B26678B9BA94C58")

    public static final String KEY_USERDATA = "userdata";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.295 -0400", hash_original_field = "7FFBF08AD4199CBCC71ECAD71FA560BB", hash_generated_field = "C963ED8E4968C78870BB72394D89E0BF")

    public static final String KEY_CALLER_UID = "callerUid";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.296 -0400", hash_original_field = "16F796D4E32E0FA5E3B0838C6EB12ECF", hash_generated_field = "597D7766913E4C39E55EDE8137AC8EF2")

    public static final String KEY_CALLER_PID = "callerPid";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.298 -0400", hash_original_field = "179C3FFD19A70202F1C72887FFE6F426", hash_generated_field = "DDEECC7543FA2BF07514362519C946F4")

    public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.299 -0400", hash_original_field = "1C3D198C124F03E4909827C29DE5E097", hash_generated_field = "CBB4031BA4A54F6632AC99B12AF54139")

    public static final String KEY_NOTIFY_ON_FAILURE = "notifyOnAuthFailure";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.300 -0400", hash_original_field = "B9451B185DC55015635E10F1C7EF42FC", hash_generated_field = "7CF12A75D3DE0CB88FEDEEC45F4C6998")

    public static final String ACTION_AUTHENTICATOR_INTENT =
            "android.accounts.AccountAuthenticator";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.302 -0400", hash_original_field = "3A084764BEBCE1E8BD8FA48F063CDF80", hash_generated_field = "38C40DD9584F5E25D4E08184425EF38E")

    public static final String AUTHENTICATOR_META_DATA_NAME =
            "android.accounts.AccountAuthenticator";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.304 -0400", hash_original_field = "479EB2FA42E43378F91DDCFEA951F29D", hash_generated_field = "A69C2C428C8648CBB8DC6F428CBCC207")

    public static final String AUTHENTICATOR_ATTRIBUTES_NAME = "account-authenticator";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.305 -0400", hash_original_field = "C8E6097876D8D41A13679743EF63E966", hash_generated_field = "5DE28EA7EC32E4A054DAAC679C704B36")

    public static final String LOGIN_ACCOUNTS_CHANGED_ACTION =
        "android.accounts.LOGIN_ACCOUNTS_CHANGED";
}

