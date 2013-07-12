package android.accounts;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.Activity;
import android.content.Intent;
import android.content.Context;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.database.SQLException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.os.Parcelable;
import android.os.Build;
import android.util.Log;
import android.text.TextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.Map;
import com.google.android.collect.Lists;
import com.google.android.collect.Maps;

public class AccountManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.562 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.564 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "5EECF8903744EA4C4535FC399DE7EDD3")

    private IAccountManager mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.564 -0400", hash_original_field = "07ED8299DCE5FFC54346DB7582134B71", hash_generated_field = "36D62901B5F66AD7425C1042CCC68DC2")

    private Handler mMainHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.565 -0400", hash_original_field = "206AC291D9BD241BDB1384C71EF5E229", hash_generated_field = "E06E5EFE2F853C682425BCF2C68C9174")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.567 -0400", hash_original_method = "399D8365074F8431C3C32ED7720975E8", hash_generated_method = "699A204D5899DBCF695891C3392F1F59")
    public  AccountManager(Context context, IAccountManager service) {
        mContext = context;
        mService = service;
        mMainHandler = new Handler(mContext.getMainLooper());
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.569 -0400", hash_original_method = "25BBC3E1043ACDD515139061A9597BA7", hash_generated_method = "34C7F2EB81FAF854CED2B6C04922B77F")
    public  AccountManager(Context context, IAccountManager service, Handler handler) {
        mContext = context;
        mService = service;
        mMainHandler = handler;
        
        
        
        
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.573 -0400", hash_original_method = "96491C15B9EBF498D1F12389B670F852", hash_generated_method = "250A65CCE6D595C968B2BE5C1C0F35A0")
    public String getPassword(final Account account) {
        addTaint(account.getTaint());
    if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_439864939 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_439864939.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_439864939;
        }
        try 
        {
String varF265DC2FF2F4422603F1281D744D04FC_1548957977 =             mService.getPassword(account);
            varF265DC2FF2F4422603F1281D744D04FC_1548957977.addTaint(taint);
            return varF265DC2FF2F4422603F1281D744D04FC_1548957977;
        } 
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1779434178 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1779434178.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1779434178;
        } 
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.580 -0400", hash_original_method = "8DF662EA0E604D155E2F8EF5AE185580", hash_generated_method = "F3F8683DA27EEA7C0F6B1A363DE15361")
    public String getUserData(final Account account, final String key) {
        addTaint(key.getTaint());
        addTaint(account.getTaint());
    if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_1166521072 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_1166521072.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_1166521072;
        }
    if(key == null)        
        {
        IllegalArgumentException varE3808CDA429E68361B6214A9C953E73D_1855331439 = new IllegalArgumentException("key is null");
        varE3808CDA429E68361B6214A9C953E73D_1855331439.addTaint(taint);
        throw varE3808CDA429E68361B6214A9C953E73D_1855331439;
        }
        try 
        {
String varB6E12DC381BC7D4C78B95DD144A437FD_385111316 =             mService.getUserData(account, key);
            varB6E12DC381BC7D4C78B95DD144A437FD_385111316.addTaint(taint);
            return varB6E12DC381BC7D4C78B95DD144A437FD_385111316;
        } 
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_677880990 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_677880990.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_677880990;
        } 
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.582 -0400", hash_original_method = "CE81752A69974A848970631715E35659", hash_generated_method = "9113A9746262844896091FEA6B852A62")
    public AuthenticatorDescription[] getAuthenticatorTypes() {
        try 
        {
AuthenticatorDescription[] var72B248AAB2E560F9BE7F0C8BB51E605E_1638562930 =             mService.getAuthenticatorTypes();
            var72B248AAB2E560F9BE7F0C8BB51E605E_1638562930.addTaint(taint);
            return var72B248AAB2E560F9BE7F0C8BB51E605E_1638562930;
        } 
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1057503490 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1057503490.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1057503490;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.585 -0400", hash_original_method = "CBAE32CDB06D92C44980C30430EF1CC0", hash_generated_method = "30371FF63FCE7766E60C689168E8A208")
    public Account[] getAccounts() {
        try 
        {
Account[] varC591FC5C8C08716D5E3035B51846A437_1588134773 =             mService.getAccounts(null);
            varC591FC5C8C08716D5E3035B51846A437_1588134773.addTaint(taint);
            return varC591FC5C8C08716D5E3035B51846A437_1588134773;
        } 
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_24230390 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_24230390.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_24230390;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.588 -0400", hash_original_method = "182706774272102452F63339D769DBB2", hash_generated_method = "449AB5BC4D6B3406E1AA22EF1E184C10")
    public Account[] getAccountsByType(String type) {
        addTaint(type.getTaint());
        try 
        {
Account[] var374F02E84765AA530519BBC2335DB4D9_400354232 =             mService.getAccounts(type);
            var374F02E84765AA530519BBC2335DB4D9_400354232.addTaint(taint);
            return var374F02E84765AA530519BBC2335DB4D9_400354232;
        } 
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1599445926 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1599445926.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1599445926;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.596 -0400", hash_original_method = "74ADBAC1696D9C481AB31AC8146F1AF9", hash_generated_method = "958B21E4119FB4D6C60D146DB66A6848")
    public AccountManagerFuture<Boolean> hasFeatures(final Account account,
            final String[] features,
            AccountManagerCallback<Boolean> callback, Handler handler) {
        addTaint(handler.getTaint());
        addTaint(callback.getTaint());
        addTaint(features[0].getTaint());
        addTaint(account.getTaint());
    if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_1473895308 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_1473895308.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_1473895308;
        }
    if(features == null)        
        {
        IllegalArgumentException var2D1AA98EF7D0249EC9EFBC9AA5F0F4ED_1004017575 = new IllegalArgumentException("features is null");
        var2D1AA98EF7D0249EC9EFBC9AA5F0F4ED_1004017575.addTaint(taint);
        throw var2D1AA98EF7D0249EC9EFBC9AA5F0F4ED_1004017575;
        }
AccountManagerFuture<Boolean> varDFF33794F9650E111BD6F4FC4D492A46_1234219541 =         new Future2Task<Boolean>(handler, callback) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.591 -0400", hash_original_method = "FFBFF398261B5CC044E2A91B7E73D5E3", hash_generated_method = "89205067D73CE89B6B97941EBFF4C904")
        public void doWork() throws RemoteException {
            mService.hasFeatures(mResponse, account, features);
            
            
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.593 -0400", hash_original_method = "EE3E978FB5F7BB3B094FBC48A926EAB2", hash_generated_method = "B710DB09C6A1BD4906ABF8903B844E2D")
        public Boolean bundleToResult(Bundle bundle) throws AuthenticatorException {
            addTaint(bundle.getTaint());
    if(!bundle.containsKey(KEY_BOOLEAN_RESULT))            
            {
                AuthenticatorException varF12691AEB1A4C0781851C7555271DC34_455455121 = new AuthenticatorException("no result in response");
                varF12691AEB1A4C0781851C7555271DC34_455455121.addTaint(taint);
                throw varF12691AEB1A4C0781851C7555271DC34_455455121;
            } 
Boolean varE5CA5297BFAF8C89D32D5EF2EF2432F6_130940871 =             bundle.getBoolean(KEY_BOOLEAN_RESULT);
            varE5CA5297BFAF8C89D32D5EF2EF2432F6_130940871.addTaint(taint);
            return varE5CA5297BFAF8C89D32D5EF2EF2432F6_130940871;
            
            
                    
                
            
        }
}.start();
        varDFF33794F9650E111BD6F4FC4D492A46_1234219541.addTaint(taint);
        return varDFF33794F9650E111BD6F4FC4D492A46_1234219541;
        
        
        
        
            
                
            
            
                
                    
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.612 -0400", hash_original_method = "430725BCDDC603435317A3A309F1AEF2", hash_generated_method = "6633FA5552633BCCBA3ED6AF3F665202")
    public AccountManagerFuture<Account[]> getAccountsByTypeAndFeatures(
            final String type, final String[] features,
            AccountManagerCallback<Account[]> callback, Handler handler) {
        addTaint(handler.getTaint());
        addTaint(callback.getTaint());
        addTaint(features[0].getTaint());
        addTaint(type.getTaint());
    if(type == null)        
        {
        IllegalArgumentException varD47EFECFC51B1CB5E3A8469789214E4E_1427357971 = new IllegalArgumentException("type is null");
        varD47EFECFC51B1CB5E3A8469789214E4E_1427357971.addTaint(taint);
        throw varD47EFECFC51B1CB5E3A8469789214E4E_1427357971;
        }
AccountManagerFuture<Account[]> var32592741EE7D1B027B3439F04859A07A_1210515705 =         new Future2Task<Account[]>(handler, callback) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.604 -0400", hash_original_method = "73AB820A1E98A1765445367AD9245309", hash_generated_method = "E4EFF5B2612046AA05CA36509915F542")
        public void doWork() throws RemoteException {
            mService.getAccountsByFeatures(mResponse, type, features);
            
            
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.610 -0400", hash_original_method = "4E01F2C268DC2C127E06F0E054062427", hash_generated_method = "44B9893563C3E059D34562E22A0362CC")
        public Account[] bundleToResult(Bundle bundle) throws AuthenticatorException {
            addTaint(bundle.getTaint());
    if(!bundle.containsKey(KEY_ACCOUNTS))            
            {
                AuthenticatorException varF12691AEB1A4C0781851C7555271DC34_2124084311 = new AuthenticatorException("no result in response");
                varF12691AEB1A4C0781851C7555271DC34_2124084311.addTaint(taint);
                throw varF12691AEB1A4C0781851C7555271DC34_2124084311;
            } 
            final Parcelable[] parcelables = bundle.getParcelableArray(KEY_ACCOUNTS);
            Account[] descs = new Account[parcelables.length];
for(int i = 0;i < parcelables.length;i++)
            {
                descs[i] = (Account) parcelables[i];
            } 
Account[] var8AFC8F239FAF32249C1DA5BD5D6C508A_1224790146 =             descs;
            var8AFC8F239FAF32249C1DA5BD5D6C508A_1224790146.addTaint(taint);
            return var8AFC8F239FAF32249C1DA5BD5D6C508A_1224790146;
            
            
                    
                
            
            
            
                    
                
            
        }
}.start();
        var32592741EE7D1B027B3439F04859A07A_1210515705.addTaint(taint);
        return var32592741EE7D1B027B3439F04859A07A_1210515705;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.616 -0400", hash_original_method = "757D4D500E44E3A8DF2EF3DE74D56199", hash_generated_method = "FE85CFBD9401C4610733A8BDC73476CC")
    public boolean addAccountExplicitly(Account account, String password, Bundle userdata) {
        addTaint(userdata.getTaint());
        addTaint(password.getTaint());
        addTaint(account.getTaint());
    if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_457291421 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_457291421.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_457291421;
        }
        try 
        {
            boolean varB8116F6C3347DBB4478ABC1827CF1BC9_916545448 = (mService.addAccount(account, password, userdata));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1146298586 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1146298586;
        } 
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1380259214 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1380259214.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1380259214;
        } 
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.626 -0400", hash_original_method = "E8BA698C89E3CF76A294446D4D176FF0", hash_generated_method = "5A49C9B64CC5134DC090AFE067DB0FB5")
    public AccountManagerFuture<Boolean> removeAccount(final Account account,
            AccountManagerCallback<Boolean> callback, Handler handler) {
        addTaint(handler.getTaint());
        addTaint(callback.getTaint());
        addTaint(account.getTaint());
    if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_1627645056 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_1627645056.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_1627645056;
        }
AccountManagerFuture<Boolean> var4A4ADA264DA1FB81D3FF82DCFC2D4A40_1273839238 =         new Future2Task<Boolean>(handler, callback) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.622 -0400", hash_original_method = "008B2E3F52D7383A94B933DA4159D4A7", hash_generated_method = "81AD4A0CB256A6E863BA4C31FFEB45E7")
        public void doWork() throws RemoteException {
            mService.removeAccount(mResponse, account);
            
            
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.624 -0400", hash_original_method = "EE3E978FB5F7BB3B094FBC48A926EAB2", hash_generated_method = "E042EE42E2024E5DE520FA024DB73AE3")
        public Boolean bundleToResult(Bundle bundle) throws AuthenticatorException {
            addTaint(bundle.getTaint());
    if(!bundle.containsKey(KEY_BOOLEAN_RESULT))            
            {
                AuthenticatorException varF12691AEB1A4C0781851C7555271DC34_153822610 = new AuthenticatorException("no result in response");
                varF12691AEB1A4C0781851C7555271DC34_153822610.addTaint(taint);
                throw varF12691AEB1A4C0781851C7555271DC34_153822610;
            } 
Boolean varE5CA5297BFAF8C89D32D5EF2EF2432F6_930537952 =             bundle.getBoolean(KEY_BOOLEAN_RESULT);
            varE5CA5297BFAF8C89D32D5EF2EF2432F6_930537952.addTaint(taint);
            return varE5CA5297BFAF8C89D32D5EF2EF2432F6_930537952;
            
            
                    
                
            
        }
}.start();
        var4A4ADA264DA1FB81D3FF82DCFC2D4A40_1273839238.addTaint(taint);
        return var4A4ADA264DA1FB81D3FF82DCFC2D4A40_1273839238;
        
        
        
            
                
            
            
                
                    
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.634 -0400", hash_original_method = "4162D414A92CDAFD44055C84C3F9947E", hash_generated_method = "6ACAD6AE3FBBC537F22B6AC1ACCA3376")
    public void invalidateAuthToken(final String accountType, final String authToken) {
        addTaint(authToken.getTaint());
        addTaint(accountType.getTaint());
    if(accountType == null)        
        {
        IllegalArgumentException var763EFEBC62165BF514D56EF43D87C9E2_2060320218 = new IllegalArgumentException("accountType is null");
        var763EFEBC62165BF514D56EF43D87C9E2_2060320218.addTaint(taint);
        throw var763EFEBC62165BF514D56EF43D87C9E2_2060320218;
        }
        try 
        {
    if(authToken != null)            
            {
                mService.invalidateAuthToken(accountType, authToken);
            } 
        } 
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_268205070 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_268205070.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_268205070;
        } 
        
        
        
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.639 -0400", hash_original_method = "DF00C62B1FBE79E2C2C3124DAA6E8CCA", hash_generated_method = "44217266C1ED09CD4304CBE362BCC886")
    public String peekAuthToken(final Account account, final String authTokenType) {
        addTaint(authTokenType.getTaint());
        addTaint(account.getTaint());
    if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_205546208 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_205546208.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_205546208;
        }
    if(authTokenType == null)        
        {
        IllegalArgumentException var0343EB95D47FDF1150074966B4E27105_1450509968 = new IllegalArgumentException("authTokenType is null");
        var0343EB95D47FDF1150074966B4E27105_1450509968.addTaint(taint);
        throw var0343EB95D47FDF1150074966B4E27105_1450509968;
        }
        try 
        {
String var57F2B5CDC8AC908E5586F36AB9127795_1245763142 =             mService.peekAuthToken(account, authTokenType);
            var57F2B5CDC8AC908E5586F36AB9127795_1245763142.addTaint(taint);
            return var57F2B5CDC8AC908E5586F36AB9127795_1245763142;
        } 
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1422738947 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1422738947.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1422738947;
        } 
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.641 -0400", hash_original_method = "DBE21AE149A5EC66FBC34FA1D5807CA3", hash_generated_method = "C8E6939CBB83076B9E362E11DD2B0E14")
    public void setPassword(final Account account, final String password) {
        addTaint(password.getTaint());
        addTaint(account.getTaint());
    if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_1396067439 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_1396067439.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_1396067439;
        }
        try 
        {
            mService.setPassword(account, password);
        } 
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_27401491 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_27401491.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_27401491;
        } 
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.644 -0400", hash_original_method = "9D6E3653B7C827404B4854FFAF700F44", hash_generated_method = "5177BF88AFDB2A2730BA6D23D72DD343")
    public void clearPassword(final Account account) {
        addTaint(account.getTaint());
    if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_1538686725 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_1538686725.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_1538686725;
        }
        try 
        {
            mService.clearPassword(account);
        } 
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1663104225 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1663104225.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1663104225;
        } 
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.647 -0400", hash_original_method = "39E18EFA140E2C140EF9BDAC244CFA88", hash_generated_method = "941A11011B9CBA2D5E81144988154A24")
    public void setUserData(final Account account, final String key, final String value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        addTaint(account.getTaint());
    if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_1625783791 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_1625783791.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_1625783791;
        }
    if(key == null)        
        {
        IllegalArgumentException varE3808CDA429E68361B6214A9C953E73D_783258905 = new IllegalArgumentException("key is null");
        varE3808CDA429E68361B6214A9C953E73D_783258905.addTaint(taint);
        throw varE3808CDA429E68361B6214A9C953E73D_783258905;
        }
        try 
        {
            mService.setUserData(account, key, value);
        } 
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1660125779 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1660125779.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1660125779;
        } 
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.651 -0400", hash_original_method = "967876CD971AD7982E73046636574113", hash_generated_method = "D23D678B3061C96C57587E39CFFF40FA")
    public void setAuthToken(Account account, final String authTokenType, final String authToken) {
        addTaint(authToken.getTaint());
        addTaint(authTokenType.getTaint());
        addTaint(account.getTaint());
    if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_702383935 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_702383935.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_702383935;
        }
    if(authTokenType == null)        
        {
        IllegalArgumentException var0343EB95D47FDF1150074966B4E27105_38458280 = new IllegalArgumentException("authTokenType is null");
        var0343EB95D47FDF1150074966B4E27105_38458280.addTaint(taint);
        throw var0343EB95D47FDF1150074966B4E27105_38458280;
        }
        try 
        {
            mService.setAuthToken(account, authTokenType, authToken);
        } 
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1128556058 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1128556058.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1128556058;
        } 
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.659 -0400", hash_original_method = "51CDD8704FBB21791536BE5C26E3F85E", hash_generated_method = "8D02D615E442FD30F3F8F021EE6E74B1")
    public String blockingGetAuthToken(Account account, String authTokenType,
            boolean notifyAuthFailure) throws OperationCanceledException, IOException, AuthenticatorException {
        addTaint(notifyAuthFailure);
        addTaint(authTokenType.getTaint());
        addTaint(account.getTaint());
    if(account == null)        
        {
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_802143528 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_802143528.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_802143528;
        }
    if(authTokenType == null)        
        {
        IllegalArgumentException var0343EB95D47FDF1150074966B4E27105_1458400041 = new IllegalArgumentException("authTokenType is null");
        var0343EB95D47FDF1150074966B4E27105_1458400041.addTaint(taint);
        throw var0343EB95D47FDF1150074966B4E27105_1458400041;
        }
        Bundle bundle = getAuthToken(account, authTokenType, notifyAuthFailure, null ,
                null ).getResult();
    if(bundle == null)        
        {
String var540C13E9E156B687226421B24F2DF178_445410957 =             null;
            var540C13E9E156B687226421B24F2DF178_445410957.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_445410957;
        } 
String var3A2B6A9F8F72674C0701F55FC46307ED_1931925551 =         bundle.getString(KEY_AUTHTOKEN);
        var3A2B6A9F8F72674C0701F55FC46307ED_1931925551.addTaint(taint);
        return var3A2B6A9F8F72674C0701F55FC46307ED_1931925551;
        
        
        
        
                
        
            
                    
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.666 -0400", hash_original_method = "DC329BE18D12A187B670EF72046E93F0", hash_generated_method = "C665DC7CA00C64F947835793F4E0CC37")
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
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_1609769072 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_1609769072.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_1609769072;
        }
    if(authTokenType == null)        
        {
        IllegalArgumentException var0343EB95D47FDF1150074966B4E27105_712950017 = new IllegalArgumentException("authTokenType is null");
        var0343EB95D47FDF1150074966B4E27105_712950017.addTaint(taint);
        throw var0343EB95D47FDF1150074966B4E27105_712950017;
        }
        final Bundle optionsIn = new Bundle();
    if(options != null)        
        {
            optionsIn.putAll(options);
        } 
        optionsIn.putString(KEY_ANDROID_PACKAGE_NAME, mContext.getPackageName());
AccountManagerFuture<Bundle> var0C15B41E283DF0F7CE7BDD58718BC504_811985606 =         new AmsTask(activity, handler, callback) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.665 -0400", hash_original_method = "DB27CC533E1EBFD8DDE03170C9D7E426", hash_generated_method = "914FB93966B313E8F64C04FDBCE1D8BE")
        public void doWork() throws RemoteException {
            mService.getAuthToken(mResponse, account, authTokenType,
                        false , true ,
                        optionsIn);
            
            
                        
                        
        }
}.start();
        var0C15B41E283DF0F7CE7BDD58718BC504_811985606.addTaint(taint);
        return var0C15B41E283DF0F7CE7BDD58718BC504_811985606;
        
        
        
        
        
            
        
        
        
            
                
                        
                        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.673 -0400", hash_original_method = "63BBFF30BB2AEF86FE403A4E568375F4", hash_generated_method = "2FB0257AFD4257B3E4D4648952258933")
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
AccountManagerFuture<Bundle> varE53CBB2E6EE67C2A88DB98EB051FE1C4_1918235774 =         getAuthToken(account, authTokenType, null, notifyAuthFailure, callback, 
                handler);
        varE53CBB2E6EE67C2A88DB98EB051FE1C4_1918235774.addTaint(taint);
        return varE53CBB2E6EE67C2A88DB98EB051FE1C4_1918235774;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.684 -0400", hash_original_method = "748DC8BCC0E7F6CE1552DDD9EEAFB074", hash_generated_method = "B9F09C25FE03FED54EEA4B7AA989067F")
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
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_1657330315 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_1657330315.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_1657330315;
        }
    if(authTokenType == null)        
        {
        IllegalArgumentException var0343EB95D47FDF1150074966B4E27105_1018259776 = new IllegalArgumentException("authTokenType is null");
        var0343EB95D47FDF1150074966B4E27105_1018259776.addTaint(taint);
        throw var0343EB95D47FDF1150074966B4E27105_1018259776;
        }
        final Bundle optionsIn = new Bundle();
    if(options != null)        
        {
            optionsIn.putAll(options);
        } 
        optionsIn.putString(KEY_ANDROID_PACKAGE_NAME, mContext.getPackageName());
AccountManagerFuture<Bundle> varD0E43CD18B7614D621DC6D506B386ABB_305724419 =         new AmsTask(null, handler, callback) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.682 -0400", hash_original_method = "4D806FE924DCA4BD633F9FEEB108BD63", hash_generated_method = "22E63FDD6EFBDF9C79B3AB87B647FECC")
        public void doWork() throws RemoteException {
            mService.getAuthToken(mResponse, account, authTokenType,
                        notifyAuthFailure, false , optionsIn);
            
            
                        
        }
}.start();
        varD0E43CD18B7614D621DC6D506B386ABB_305724419.addTaint(taint);
        return varD0E43CD18B7614D621DC6D506B386ABB_305724419;
        
        
        
        
        
            
        
        
        
            
                
                        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.693 -0400", hash_original_method = "6ACDAD8A4FE951A7F40DF03A76D4A058", hash_generated_method = "1797CFED179FDD5A0774055C34C93471")
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
        IllegalArgumentException var763EFEBC62165BF514D56EF43D87C9E2_1590091259 = new IllegalArgumentException("accountType is null");
        var763EFEBC62165BF514D56EF43D87C9E2_1590091259.addTaint(taint);
        throw var763EFEBC62165BF514D56EF43D87C9E2_1590091259;
        }
        final Bundle optionsIn = new Bundle();
    if(addAccountOptions != null)        
        {
            optionsIn.putAll(addAccountOptions);
        } 
        optionsIn.putString(KEY_ANDROID_PACKAGE_NAME, mContext.getPackageName());
AccountManagerFuture<Bundle> varD8CFA3F11091A5A788758BA8176211E1_522445388 =         new AmsTask(activity, handler, callback) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.691 -0400", hash_original_method = "8125D1B63E005C814CD2B9CB30309226", hash_generated_method = "8F2127E03570576B47D9FA13D331F1D9")
        public void doWork() throws RemoteException {
            mService.addAcount(mResponse, accountType, authTokenType,
                        requiredFeatures, activity != null, optionsIn);
            
            
                        
        }
}.start();
        varD8CFA3F11091A5A788758BA8176211E1_522445388.addTaint(taint);
        return varD8CFA3F11091A5A788758BA8176211E1_522445388;
        
        
        
        
            
        
        
        
            
                
                        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.699 -0400", hash_original_method = "E9F24B896DDD289C3D9D25FA0235DC55", hash_generated_method = "151DFFDB366A9E7C2F9BC6525B9D8E5B")
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
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_2002824820 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_2002824820.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_2002824820;
        }
AccountManagerFuture<Bundle> varAF4F8503C14478A49D1D8937CDFAB658_1642465362 =         new AmsTask(activity, handler, callback) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.698 -0400", hash_original_method = "352D9086D40AE796E81956BBA2D0E5D4", hash_generated_method = "3F77048E922E80B6C7C6633D1C3CBAEF")
        public void doWork() throws RemoteException {
            mService.confirmCredentials(mResponse, account, options, activity != null);
            
            
        }
}.start();
        varAF4F8503C14478A49D1D8937CDFAB658_1642465362.addTaint(taint);
        return varAF4F8503C14478A49D1D8937CDFAB658_1642465362;
        
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.706 -0400", hash_original_method = "D809F6F9BB7D46EEEE0B772ED5C9F6A9", hash_generated_method = "BEB105C17565D59B6F33899094206799")
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
        IllegalArgumentException var55E455EBC501D696126783489D113EF9_149335965 = new IllegalArgumentException("account is null");
        var55E455EBC501D696126783489D113EF9_149335965.addTaint(taint);
        throw var55E455EBC501D696126783489D113EF9_149335965;
        }
AccountManagerFuture<Bundle> varFD1B4C0E8EE2C772594596D209598B34_2125954392 =         new AmsTask(activity, handler, callback) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.705 -0400", hash_original_method = "6D2F90C4553E4DD12E7AEE5963D4AB1E", hash_generated_method = "5F0AD53448D1D721264F4D7E73A4152F")
        public void doWork() throws RemoteException {
            mService.updateCredentials(mResponse, account, authTokenType, activity != null,
                        options);
            
            
                        
        }
}.start();
        varFD1B4C0E8EE2C772594596D209598B34_2125954392.addTaint(taint);
        return varFD1B4C0E8EE2C772594596D209598B34_2125954392;
        
        
        
            
                
                        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.720 -0400", hash_original_method = "72C42C362A18F251D937648B5DDE9096", hash_generated_method = "D1B5AD5B108914302BFA812F4194A654")
    public AccountManagerFuture<Bundle> editProperties(final String accountType,
            final Activity activity, final AccountManagerCallback<Bundle> callback,
            final Handler handler) {
        addTaint(handler.getTaint());
        addTaint(callback.getTaint());
        addTaint(activity.getTaint());
        addTaint(accountType.getTaint());
    if(accountType == null)        
        {
        IllegalArgumentException var763EFEBC62165BF514D56EF43D87C9E2_818037603 = new IllegalArgumentException("accountType is null");
        var763EFEBC62165BF514D56EF43D87C9E2_818037603.addTaint(taint);
        throw var763EFEBC62165BF514D56EF43D87C9E2_818037603;
        }
AccountManagerFuture<Bundle> varB99B0F3BC6F6C2150AAD6BA17DB7DE1F_1863436515 =         new AmsTask(activity, handler, callback) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.710 -0400", hash_original_method = "04B8B0735D1CA277ED91C00D79F33B2D", hash_generated_method = "1D34C9364A966EE79E020E27C5A65409")
        public void doWork() throws RemoteException {
            mService.editProperties(mResponse, accountType, activity != null);
            
            
        }
}.start();
        varB99B0F3BC6F6C2150AAD6BA17DB7DE1F_1863436515.addTaint(taint);
        return varB99B0F3BC6F6C2150AAD6BA17DB7DE1F_1863436515;
        
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.723 -0400", hash_original_method = "05C769BBE692F72E464B52B58848EACE", hash_generated_method = "9C8597D05E95DEE9B9D7D0991840332F")
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
            } 
        } 
        
        
        
            
                    
            
                    
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.745 -0400", hash_original_method = "80D38BDC6E0DE7333CAAD84CC9E6E84A", hash_generated_method = "DE38EAD3A6CA7034D6DB7928547B1C3C")
    private void postToHandler(Handler handler, final AccountManagerCallback<Bundle> callback,
            final AccountManagerFuture<Bundle> future) {
        addTaint(future.getTaint());
        addTaint(callback.getTaint());
        addTaint(handler.getTaint());
        handler = handler == null ? mMainHandler : handler;
        handler.post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.741 -0400", hash_original_method = "BDBA0E8ABF21CCC323F7A43F04981195", hash_generated_method = "0CA3FE6CFE2D535345F3115B21FF729A")
        public void run() {
            callback.run(future);
            
            
        }
});
        
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.771 -0400", hash_original_method = "20F25A89C89C92245636BC8DCFF18BD7", hash_generated_method = "4B4B87F6E65C96B68BFB857E5EB3F9B1")
    private void postToHandler(Handler handler, final OnAccountsUpdateListener listener,
            final Account[] accounts) {
        addTaint(accounts[0].getTaint());
        addTaint(listener.getTaint());
        addTaint(handler.getTaint());
        final Account[] accountsCopy = new Account[accounts.length];
        System.arraycopy(accounts, 0, accountsCopy, 0, accountsCopy.length);
        handler = (handler == null) ? mMainHandler : handler;
        handler.post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.767 -0400", hash_original_method = "8E333205C0A7A1853354D3DAC2CB74E8", hash_generated_method = "A22A972F5E35D7E3C15D79722DEB108F")
        public void run() {
            try 
            {
                listener.onAccountsUpdated(accountsCopy);
            } 
            catch (SQLException e)
            {
            } 
            
            
                    
                
                    
                
        }
});
        
        
        
        
        
            
                
                    
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.791 -0400", hash_original_method = "6FDE075EEB86D1BECEDE842FFDA184DE", hash_generated_method = "F3E62C81E0F1A23F15A64BB09426BDAA")
    private Exception convertErrorToException(int code, String message) {
        addTaint(message.getTaint());
        addTaint(code);
    if(code == ERROR_CODE_NETWORK_ERROR)        
        {
Exception varD49BA77971BE8FFE69DAEADCD296A867_1923000397 =             new IOException(message);
            varD49BA77971BE8FFE69DAEADCD296A867_1923000397.addTaint(taint);
            return varD49BA77971BE8FFE69DAEADCD296A867_1923000397;
        } 
    if(code == ERROR_CODE_UNSUPPORTED_OPERATION)        
        {
Exception var84C15D5A27C7BF62148868CF27DC7C0B_1647720242 =             new UnsupportedOperationException(message);
            var84C15D5A27C7BF62148868CF27DC7C0B_1647720242.addTaint(taint);
            return var84C15D5A27C7BF62148868CF27DC7C0B_1647720242;
        } 
    if(code == ERROR_CODE_INVALID_RESPONSE)        
        {
Exception varB112E87B12E2B59F9C53CCF508EEEC4A_2035352076 =             new AuthenticatorException(message);
            varB112E87B12E2B59F9C53CCF508EEEC4A_2035352076.addTaint(taint);
            return varB112E87B12E2B59F9C53CCF508EEEC4A_2035352076;
        } 
    if(code == ERROR_CODE_BAD_ARGUMENTS)        
        {
Exception varBA95164A78C837CF35BB1C0FF86E66FF_2115014559 =             new IllegalArgumentException(message);
            varBA95164A78C837CF35BB1C0FF86E66FF_2115014559.addTaint(taint);
            return varBA95164A78C837CF35BB1C0FF86E66FF_2115014559;
        } 
Exception varB112E87B12E2B59F9C53CCF508EEEC4A_448462697 =         new AuthenticatorException(message);
        varB112E87B12E2B59F9C53CCF508EEEC4A_448462697.addTaint(taint);
        return varB112E87B12E2B59F9C53CCF508EEEC4A_448462697;
        
        
            
        
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.809 -0400", hash_original_method = "801F35A66961F670B5EADD181BA66DC7", hash_generated_method = "F8195AC972C24DBE4E572D94676F062E")
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
        IllegalArgumentException var3FEF5283C635241049D3258C060D2A11_66358544 = new IllegalArgumentException("account type is null");
        var3FEF5283C635241049D3258C060D2A11_66358544.addTaint(taint);
        throw var3FEF5283C635241049D3258C060D2A11_66358544;
        }
    if(authTokenType == null)        
        {
        IllegalArgumentException var0343EB95D47FDF1150074966B4E27105_95826637 = new IllegalArgumentException("authTokenType is null");
        var0343EB95D47FDF1150074966B4E27105_95826637.addTaint(taint);
        throw var0343EB95D47FDF1150074966B4E27105_95826637;
        }
        final GetAuthTokenByTypeAndFeaturesTask task = new GetAuthTokenByTypeAndFeaturesTask(accountType, authTokenType, features,
                activity, addAccountOptions, getAuthTokenOptions, callback, handler);
        task.start();
AccountManagerFuture<Bundle> varE3FBC805688C6CF32CF252D3CB460B3C_580541244 =         task;
        varE3FBC805688C6CF32CF252D3CB460B3C_580541244.addTaint(taint);
        return varE3FBC805688C6CF32CF252D3CB460B3C_580541244;
        
        
        
        
                
                
        
        
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.815 -0400", hash_original_method = "7A5668A93C6BCE258395457FB89679A1", hash_generated_method = "0497C836053E12045DDC03FBAD710992")
    public void addOnAccountsUpdatedListener(final OnAccountsUpdateListener listener,
            Handler handler, boolean updateImmediately) {
        addTaint(updateImmediately);
        addTaint(handler.getTaint());
        addTaint(listener.getTaint());
    if(listener == null)        
        {
            IllegalArgumentException var27C26F8F826117C9E6C7C46F036A0E78_274849928 = new IllegalArgumentException("the listener is null");
            var27C26F8F826117C9E6C7C46F036A0E78_274849928.addTaint(taint);
            throw var27C26F8F826117C9E6C7C46F036A0E78_274849928;
        } 
        synchronized
(mAccountsUpdatedListeners)        {
    if(mAccountsUpdatedListeners.containsKey(listener))            
            {
                IllegalStateException var73DDD708B9F638937AEEA3A1722B32DA_1211041596 = new IllegalStateException("this listener is already added");
                var73DDD708B9F638937AEEA3A1722B32DA_1211041596.addTaint(taint);
                throw var73DDD708B9F638937AEEA3A1722B32DA_1211041596;
            } 
            final boolean wasEmpty = mAccountsUpdatedListeners.isEmpty();
            mAccountsUpdatedListeners.put(listener, handler);
    if(wasEmpty)            
            {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(LOGIN_ACCOUNTS_CHANGED_ACTION);
                intentFilter.addAction(Intent.ACTION_DEVICE_STORAGE_OK);
                mContext.registerReceiver(mAccountsChangedBroadcastReceiver, intentFilter);
            } 
        } 
    if(updateImmediately)        
        {
            postToHandler(handler, listener, getAccounts());
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.818 -0400", hash_original_method = "66F9A18B2BBFAE47B027D9D23A795F11", hash_generated_method = "353617B2ACE6E1B8345E7F545A37DB73")
    public void removeOnAccountsUpdatedListener(OnAccountsUpdateListener listener) {
        addTaint(listener.getTaint());
    if(listener == null)        
        {
        IllegalArgumentException varA47873FC7599174144A251E0E98D02E8_1523392868 = new IllegalArgumentException("listener is null");
        varA47873FC7599174144A251E0E98D02E8_1523392868.addTaint(taint);
        throw varA47873FC7599174144A251E0E98D02E8_1523392868;
        }
        synchronized
(mAccountsUpdatedListeners)        {
    if(!mAccountsUpdatedListeners.containsKey(listener))            
            {
                return;
            } 
            mAccountsUpdatedListeners.remove(listener);
    if(mAccountsUpdatedListeners.isEmpty())            
            {
                mContext.unregisterReceiver(mAccountsChangedBroadcastReceiver);
            } 
        } 
        
        
        
            
                
                
            
            
            
                
            
        
    }

    
    private abstract class AmsTask extends FutureTask<Bundle> implements AccountManagerFuture<Bundle> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.820 -0400", hash_original_field = "E72652B09AB331E8E60D8A37942A6989", hash_generated_field = "BCCFC11938EEC7DE34A0DE82C0A04729")

        IAccountManagerResponse mResponse;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.821 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

        Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.822 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "382974AD998518E9037A5E4EDC0E3105")

        AccountManagerCallback<Bundle> mCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.823 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "3895D7E6DB5042DA7856DC78E391C7B9")

        Activity mActivity;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.834 -0400", hash_original_method = "B1B053361B7316D8D8AF57ECEF4696C6", hash_generated_method = "28BC1A87CA8A0CC402A36B363995E588")
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
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.837 -0400", hash_original_method = "E07DE3E7F6D29C4D4BDAC4812A3CF430", hash_generated_method = "BAE75783644CE59263C3954B4BF10349")
        public final AccountManagerFuture<Bundle> start() {
            try 
            {
                doWork();
            } 
            catch (RemoteException e)
            {
                setException(e);
            } 
AccountManagerFuture<Bundle> var72A74007B2BE62B849F475C7BDA4658B_2452932 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2452932.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2452932;
            
            
                
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.839 -0400", hash_original_method = "127E02577FE14DDB30AB934EB38A0588", hash_generated_method = "4746B5D5C353C5A89229EE21403F96A7")
        protected void set(Bundle bundle) {
            addTaint(bundle.getTaint());
    if(bundle == null)            
            {
            } 
            super.set(bundle);
            
            
                
            
            
        }

        
        public abstract void doWork() throws RemoteException;

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.856 -0400", hash_original_method = "6C34E289CBAB2DD26AA2603338539143", hash_generated_method = "7C2CC28C50E7E22E72C27A409B543F2A")
        private Bundle internalGetResult(Long timeout, TimeUnit unit) throws OperationCanceledException, IOException, AuthenticatorException {
            addTaint(unit.getTaint());
            addTaint(timeout.getTaint());
    if(!isDone())            
            {
                ensureNotOnMainThread();
            } 
            try 
            {
    if(timeout == null)                
                {
Bundle varE05826B33CE3BB3E950704304F321003_1095367844 =                     get();
                    varE05826B33CE3BB3E950704304F321003_1095367844.addTaint(taint);
                    return varE05826B33CE3BB3E950704304F321003_1095367844;
                } 
                else
                {
Bundle varC29A4AA05E7B4279C36345837ED71E88_1657265014 =                     get(timeout, unit);
                    varC29A4AA05E7B4279C36345837ED71E88_1657265014.addTaint(taint);
                    return varC29A4AA05E7B4279C36345837ED71E88_1657265014;
                } 
            } 
            catch (CancellationException e)
            {
                OperationCanceledException var489A2CB176387ED788C84D313A8E80A8_1098897427 = new OperationCanceledException();
                var489A2CB176387ED788C84D313A8E80A8_1098897427.addTaint(taint);
                throw var489A2CB176387ED788C84D313A8E80A8_1098897427;
            } 
            catch (TimeoutException e)
            {
            } 
            catch (InterruptedException e)
            {
            } 
            catch (ExecutionException e)
            {
                final Throwable cause = e.getCause();
    if(cause instanceof IOException)                
                {
                    IOException varA8CE4520913DFE6D323B16DA5398FDBA_1807557430 = (IOException) cause;
                    varA8CE4520913DFE6D323B16DA5398FDBA_1807557430.addTaint(taint);
                    throw varA8CE4520913DFE6D323B16DA5398FDBA_1807557430;
                } 
                else
    if(cause instanceof UnsupportedOperationException)                
                {
                    AuthenticatorException var29FD6CBF16AA9C29D6E479E7DACCE852_137435967 = new AuthenticatorException(cause);
                    var29FD6CBF16AA9C29D6E479E7DACCE852_137435967.addTaint(taint);
                    throw var29FD6CBF16AA9C29D6E479E7DACCE852_137435967;
                } 
                else
    if(cause instanceof AuthenticatorException)                
                {
                    AuthenticatorException varB43496F9EDC051E222D6D5AA8F1E1D9B_334445590 = (AuthenticatorException) cause;
                    varB43496F9EDC051E222D6D5AA8F1E1D9B_334445590.addTaint(taint);
                    throw varB43496F9EDC051E222D6D5AA8F1E1D9B_334445590;
                } 
                else
    if(cause instanceof RuntimeException)                
                {
                    RuntimeException var2BEB6EF3D41E44EED5E35024D3C50335_335870077 = (RuntimeException) cause;
                    var2BEB6EF3D41E44EED5E35024D3C50335_335870077.addTaint(taint);
                    throw var2BEB6EF3D41E44EED5E35024D3C50335_335870077;
                } 
                else
    if(cause instanceof Error)                
                {
                    Error varF690D0FEA4496CAA0F487E9481A0D919_1371058148 = (Error) cause;
                    varF690D0FEA4496CAA0F487E9481A0D919_1371058148.addTaint(taint);
                    throw varF690D0FEA4496CAA0F487E9481A0D919_1371058148;
                } 
                else
                {
                    IllegalStateException varF60D9E53AC195769C06EA2A79A7E7653_217128367 = new IllegalStateException(cause);
                    varF60D9E53AC195769C06EA2A79A7E7653_217128367.addTaint(taint);
                    throw varF60D9E53AC195769C06EA2A79A7E7653_217128367;
                } 
            } 
            finally 
            {
                cancel(true );
            } 
            OperationCanceledException var489A2CB176387ED788C84D313A8E80A8_2146262055 = new OperationCanceledException();
            var489A2CB176387ED788C84D313A8E80A8_2146262055.addTaint(taint);
            throw var489A2CB176387ED788C84D313A8E80A8_2146262055;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.860 -0400", hash_original_method = "7428E8716809F4A01AF7F726F040DE64", hash_generated_method = "038FE00EFB2302967A7B698C3BEFC827")
        public Bundle getResult() throws OperationCanceledException, IOException, AuthenticatorException {
Bundle var6DB880D2F96BCDB0DB0C5333CAB0CBD0_992400263 =             internalGetResult(null, null);
            var6DB880D2F96BCDB0DB0C5333CAB0CBD0_992400263.addTaint(taint);
            return var6DB880D2F96BCDB0DB0C5333CAB0CBD0_992400263;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.862 -0400", hash_original_method = "2DB61FA3CF370F8EAC405A022C9CA553", hash_generated_method = "7FEB73292F7FFBE70464A7267ACD850F")
        public Bundle getResult(long timeout, TimeUnit unit) throws OperationCanceledException, IOException, AuthenticatorException {
            addTaint(unit.getTaint());
            addTaint(timeout);
Bundle var9D01E8DE3D6E1C2C2386B1AD0AD3C5EC_2109153342 =             internalGetResult(timeout, unit);
            var9D01E8DE3D6E1C2C2386B1AD0AD3C5EC_2109153342.addTaint(taint);
            return var9D01E8DE3D6E1C2C2386B1AD0AD3C5EC_2109153342;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.863 -0400", hash_original_method = "3B9C9BC58CC1D6BA66EF9DB56725570D", hash_generated_method = "C6ACA7FEB19F044A3793E96E12569666")
        protected void done() {
    if(mCallback != null)            
            {
                postToHandler(mHandler, mCallback, this);
            } 
            
            
                
            
        }

        
        private class Response extends IAccountManagerResponse.Stub {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.865 -0400", hash_original_method = "1C91C9705FD3BE3D2A4F4357891D41FD", hash_generated_method = "1C91C9705FD3BE3D2A4F4357891D41FD")
            public Response ()
            {
                
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.868 -0400", hash_original_method = "BC11F9A6ED106794CC5C9152E9BD3B43", hash_generated_method = "AE0DC4BB71B6E644FCD2CC26FB83E610")
            public void onResult(Bundle bundle) {
                
                addTaint(bundle.getTaint());
                Intent intent = bundle.getParcelable(KEY_INTENT);
    if(intent != null && mActivity != null)                
                {
                    mActivity.startActivity(intent);
                } 
                else
    if(bundle.getBoolean("retry"))                
                {
                    try 
                    {
                        doWork();
                    } 
                    catch (RemoteException e)
                    {
                    } 
                } 
                else
                {
                    set(bundle);
                } 
                
                
                
                    
                
                    
                        
                    
                    
                
                    
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.872 -0400", hash_original_method = "DD61FDBEB518045420249589A7AE75D2", hash_generated_method = "32D16F6FE7CC45BC71A427F58177EA53")
            public void onError(int code, String message) {
                
                addTaint(message.getTaint());
                addTaint(code);
    if(code == ERROR_CODE_CANCELED)                
                {
                    cancel(true );
                    return;
                } 
                setException(convertErrorToException(code, message));
                
                
                    
                    
                
                
            }

            
        }


        
    }


    
    private abstract class BaseFutureTask<T> extends FutureTask<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.873 -0400", hash_original_field = "E72652B09AB331E8E60D8A37942A6989", hash_generated_field = "A54F64CAD983BA5040DC733186B2FF3B")

        public IAccountManagerResponse mResponse;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.875 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

        Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.882 -0400", hash_original_method = "26CFE7EFCBFE85C3047A425A4F720F86", hash_generated_method = "07FC7C468CB0119415FE7B69CAD44E68")
        public  BaseFutureTask(Handler handler) {
            super(new Callable<T>() {
                public T call() throws Exception {
                    throw new IllegalStateException("this should never be called");
                }
            });
            mHandler = handler;
            mResponse = new Response();
            
            
            
        }

        
        public abstract void doWork() throws RemoteException;

        
        public abstract T bundleToResult(Bundle bundle) throws AuthenticatorException;

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.889 -0400", hash_original_method = "B01C5697E6FB95B4A78D57A4C431F13F", hash_generated_method = "46E928041BDE8537752EB60BAA1FCD58")
        protected void postRunnableToHandler(Runnable runnable) {
            addTaint(runnable.getTaint());
            Handler handler = (mHandler == null) ? mMainHandler : mHandler;
            handler.post(runnable);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.891 -0400", hash_original_method = "030130E13746E076BBD203E6D46CECFF", hash_generated_method = "255E12B7B835ACF16F252F3ADA55C2A0")
        protected void startTask() {
            try 
            {
                doWork();
            } 
            catch (RemoteException e)
            {
                setException(e);
            } 
            
            
                
            
                
            
        }

        
        protected class Response extends IAccountManagerResponse.Stub {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.893 -0400", hash_original_method = "1C91C9705FD3BE3D2A4F4357891D41FD", hash_generated_method = "1C91C9705FD3BE3D2A4F4357891D41FD")
            public Response ()
            {
                
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.895 -0400", hash_original_method = "B8AEC5DE9AFE3040461BEFA9E791EE34", hash_generated_method = "5907B2238C51B69B98935E09B5E833A9")
            public void onResult(Bundle bundle) {
                
                addTaint(bundle.getTaint());
                try 
                {
                    T result = bundleToResult(bundle);
    if(result == null)                    
                    {
                        return;
                    } 
                    set(result);
                    return;
                } 
                catch (ClassCastException e)
                {
                } 
                catch (AuthenticatorException e)
                {
                } 
                onError(ERROR_CODE_INVALID_RESPONSE, "no result in response");
                
                
                    
                    
                        
                    
                    
                    
                
                
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.899 -0400", hash_original_method = "DD61FDBEB518045420249589A7AE75D2", hash_generated_method = "32D16F6FE7CC45BC71A427F58177EA53")
            public void onError(int code, String message) {
                
                addTaint(message.getTaint());
                addTaint(code);
    if(code == ERROR_CODE_CANCELED)                
                {
                    cancel(true );
                    return;
                } 
                setException(convertErrorToException(code, message));
                
                
                    
                    
                
                
            }

            
        }


        
    }


    
    private abstract class Future2Task<T> extends BaseFutureTask<T> implements AccountManagerFuture<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.901 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "719E4FBEE0E6D8BC8E61E553D79747F3")

        AccountManagerCallback<T> mCallback;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.903 -0400", hash_original_method = "FC1DD61776F9D5FC9C321068652B66F1", hash_generated_method = "B34773829AE61D9E9A09F15F11D8449D")
        public  Future2Task(Handler handler, AccountManagerCallback<T> callback) {
            super(handler);
            addTaint(handler.getTaint());
            mCallback = callback;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.908 -0400", hash_original_method = "762C0B9FE5A1A00B697BA32E9AEAF22E", hash_generated_method = "3CADD7C8F16077735BBFE7BD23B77FBF")
        protected void done() {
    if(mCallback != null)            
            {
                postRunnableToHandler(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.906 -0400", hash_original_method = "0F70B80A50B592CBF5F504B35808D596", hash_generated_method = "7101081B29B4523A9AECBBD0EF73571E")
            public void run() {
                mCallback.run(Future2Task.this);
                
                
            }
});
            } 
            
            
                
                    
                        
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.912 -0400", hash_original_method = "31A85EDC6833090D765F6613E9274CD1", hash_generated_method = "87139FB48CADB85B8FB42A5C83E22150")
        public Future2Task<T> start() {
            startTask();
Future2Task<T> var72A74007B2BE62B849F475C7BDA4658B_52011875 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_52011875.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_52011875;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.914 -0400", hash_original_method = "41F0112BBEC6735226A2F41FF2202D7E", hash_generated_method = "8C075A50995F99FD538D9325122E011E")
        private T internalGetResult(Long timeout, TimeUnit unit) throws OperationCanceledException, IOException, AuthenticatorException {
            addTaint(unit.getTaint());
            addTaint(timeout.getTaint());
    if(!isDone())            
            {
                ensureNotOnMainThread();
            } 
            try 
            {
    if(timeout == null)                
                {
T varE05826B33CE3BB3E950704304F321003_273522558 =                     get();
                    varE05826B33CE3BB3E950704304F321003_273522558.addTaint(taint);
                    return varE05826B33CE3BB3E950704304F321003_273522558;
                } 
                else
                {
T varC29A4AA05E7B4279C36345837ED71E88_287289073 =                     get(timeout, unit);
                    varC29A4AA05E7B4279C36345837ED71E88_287289073.addTaint(taint);
                    return varC29A4AA05E7B4279C36345837ED71E88_287289073;
                } 
            } 
            catch (InterruptedException e)
            {
            } 
            catch (TimeoutException e)
            {
            } 
            catch (CancellationException e)
            {
            } 
            catch (ExecutionException e)
            {
                final Throwable cause = e.getCause();
    if(cause instanceof IOException)                
                {
                    IOException varA8CE4520913DFE6D323B16DA5398FDBA_603947162 = (IOException) cause;
                    varA8CE4520913DFE6D323B16DA5398FDBA_603947162.addTaint(taint);
                    throw varA8CE4520913DFE6D323B16DA5398FDBA_603947162;
                } 
                else
    if(cause instanceof UnsupportedOperationException)                
                {
                    AuthenticatorException var29FD6CBF16AA9C29D6E479E7DACCE852_1160646 = new AuthenticatorException(cause);
                    var29FD6CBF16AA9C29D6E479E7DACCE852_1160646.addTaint(taint);
                    throw var29FD6CBF16AA9C29D6E479E7DACCE852_1160646;
                } 
                else
    if(cause instanceof AuthenticatorException)                
                {
                    AuthenticatorException varB43496F9EDC051E222D6D5AA8F1E1D9B_1263465159 = (AuthenticatorException) cause;
                    varB43496F9EDC051E222D6D5AA8F1E1D9B_1263465159.addTaint(taint);
                    throw varB43496F9EDC051E222D6D5AA8F1E1D9B_1263465159;
                } 
                else
    if(cause instanceof RuntimeException)                
                {
                    RuntimeException var2BEB6EF3D41E44EED5E35024D3C50335_1155887051 = (RuntimeException) cause;
                    var2BEB6EF3D41E44EED5E35024D3C50335_1155887051.addTaint(taint);
                    throw var2BEB6EF3D41E44EED5E35024D3C50335_1155887051;
                } 
                else
    if(cause instanceof Error)                
                {
                    Error varF690D0FEA4496CAA0F487E9481A0D919_1410717912 = (Error) cause;
                    varF690D0FEA4496CAA0F487E9481A0D919_1410717912.addTaint(taint);
                    throw varF690D0FEA4496CAA0F487E9481A0D919_1410717912;
                } 
                else
                {
                    IllegalStateException varF60D9E53AC195769C06EA2A79A7E7653_1533534191 = new IllegalStateException(cause);
                    varF60D9E53AC195769C06EA2A79A7E7653_1533534191.addTaint(taint);
                    throw varF60D9E53AC195769C06EA2A79A7E7653_1533534191;
                } 
            } 
            finally 
            {
                cancel(true );
            } 
            OperationCanceledException var489A2CB176387ED788C84D313A8E80A8_983454876 = new OperationCanceledException();
            var489A2CB176387ED788C84D313A8E80A8_983454876.addTaint(taint);
            throw var489A2CB176387ED788C84D313A8E80A8_983454876;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.918 -0400", hash_original_method = "F09B519E265A8A66FE763E800742348B", hash_generated_method = "537C0E199E9B626742A48B40398319FE")
        public T getResult() throws OperationCanceledException, IOException, AuthenticatorException {
T var6DB880D2F96BCDB0DB0C5333CAB0CBD0_1100941273 =             internalGetResult(null, null);
            var6DB880D2F96BCDB0DB0C5333CAB0CBD0_1100941273.addTaint(taint);
            return var6DB880D2F96BCDB0DB0C5333CAB0CBD0_1100941273;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.922 -0400", hash_original_method = "50CBD7888960B26C4BF28EA57E206BB1", hash_generated_method = "780C8F3790D2A77EA88565E2FDF0068B")
        public T getResult(long timeout, TimeUnit unit) throws OperationCanceledException, IOException, AuthenticatorException {
            addTaint(unit.getTaint());
            addTaint(timeout);
T var9D01E8DE3D6E1C2C2386B1AD0AD3C5EC_202315571 =             internalGetResult(timeout, unit);
            var9D01E8DE3D6E1C2C2386B1AD0AD3C5EC_202315571.addTaint(taint);
            return var9D01E8DE3D6E1C2C2386B1AD0AD3C5EC_202315571;
            
            
        }

        
    }


    
    private class GetAuthTokenByTypeAndFeaturesTask extends AmsTask implements AccountManagerCallback<Bundle> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.923 -0400", hash_original_field = "89EED8F86B939D76F6E66671841F66E0", hash_generated_field = "DA7FCA7FD25B2715DDA5B1151A329B57")

        volatile AccountManagerFuture<Bundle> mFuture = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.924 -0400", hash_original_field = "D3E1F03AA680CFA730A921954023E5B9", hash_generated_field = "1BAC3F5B48D7CBDC0DEC096887906F9A")

        String mAccountType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.925 -0400", hash_original_field = "69D299670D936CF5E779CEC994C9B669", hash_generated_field = "62E235D18D61381B167C250C0385DCF5")

        String mAuthTokenType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.925 -0400", hash_original_field = "B6FEAD34C9CE2FFD9FDB8BCB7536B5B4", hash_generated_field = "BB73EBD9036EEEC92FAB5A91A39B5A6F")

        String[] mFeatures;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.926 -0400", hash_original_field = "612B48E31872CED4823D637CF52B7B68", hash_generated_field = "7B6AE567E0F7C37B83B94413E80422D3")

        Bundle mAddAccountOptions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.927 -0400", hash_original_field = "DEE378E96D6BC88E66F300481BD20A99", hash_generated_field = "4B7678D538696871E7C4A9E9A154E69B")

        Bundle mLoginOptions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.928 -0400", hash_original_field = "4AC3E767900DAB7270D2E11DF66BD083", hash_generated_field = "9AB039BA73F970DDDFBFE5E982A0A257")

        AccountManagerCallback<Bundle> mMyCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.929 -0400", hash_original_field = "FF4A321CA3E8F9F098306FE32821F7F6", hash_generated_field = "71E70B13764C89A5A2D6CAA3A090D703")

        private volatile int mNumAccounts = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.937 -0400", hash_original_method = "8B428F75DFA4C0F7DC2037249CE783CE", hash_generated_method = "8EA18D92B0ACE6B29E54696D4E936613")
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
            IllegalArgumentException var3FEF5283C635241049D3258C060D2A11_1778116194 = new IllegalArgumentException("account type is null");
            var3FEF5283C635241049D3258C060D2A11_1778116194.addTaint(taint);
            throw var3FEF5283C635241049D3258C060D2A11_1778116194;
            }
            mAccountType = accountType;
            mAuthTokenType = authTokenType;
            mFeatures = features;
            mAddAccountOptions = addAccountOptions;
            mLoginOptions = loginOptions;
            mMyCallback = this;
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.947 -0400", hash_original_method = "C4C5F207D191035A436136641EA5FDB4", hash_generated_method = "1E9595724D26F9144C465FBDF86D3217")
        public void doWork() throws RemoteException {
            getAccountsByTypeAndFeatures(mAccountType, mFeatures,
                    new AccountManagerCallback<Account[]>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.944 -0400", hash_original_method = "A16608B5927D0AB580BEC16F01D5E6C5", hash_generated_method = "49E8F6FF13DB92598A6D929C1A5B00DF")
            public void run(AccountManagerFuture<Account[]> future) {
                addTaint(future.getTaint());
                Account[] accounts;
                try 
                {
                    accounts = future.getResult();
                } 
                catch (OperationCanceledException e)
                {
                    setException(e);
                    return;
                } 
                catch (IOException e)
                {
                    setException(e);
                    return;
                } 
                catch (AuthenticatorException e)
                {
                    setException(e);
                    return;
                } 
                mNumAccounts = accounts.length;
    if(accounts.length == 0)                
                {
    if(mActivity != null)                    
                    {
                        mFuture = addAccount(mAccountType, mAuthTokenType, mFeatures,
                                            mAddAccountOptions, mActivity, mMyCallback, mHandler);
                    } 
                    else
                    {
                        Bundle result = new Bundle();
                        result.putString(KEY_ACCOUNT_NAME, null);
                        result.putString(KEY_ACCOUNT_TYPE, null);
                        result.putString(KEY_AUTHTOKEN, null);
                        try 
                        {
                            mResponse.onResult(result);
                        } 
                        catch (RemoteException e)
                        {
                        } 
                    } 
                } 
                else
    if(accounts.length == 1)                
                {
    if(mActivity == null)                    
                    {
                        mFuture = getAuthToken(accounts[0], mAuthTokenType,
                                            false , mMyCallback, mHandler);
                    } 
                    else
                    {
                        mFuture = getAuthToken(accounts[0],
                                            mAuthTokenType, mLoginOptions,
                                            mActivity, mMyCallback, mHandler);
                    } 
                } 
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
                    } 
                    else
                    {
                        Bundle result = new Bundle();
                        result.putString(KEY_ACCOUNTS, null);
                        try 
                        {
                            mResponse.onResult(result);
                        } 
                        catch (RemoteException e)
                        {
                        } 
                    } 
                } 
                
                
            }
}, mHandler);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.956 -0400", hash_original_method = "770A26A7F965A1883CF21DF75B7155CF", hash_generated_method = "96B7951346214BE8AE61BF760ADA2D03")
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
                    } 
                    final Account account = new Account(accountName, accountType);
                    mNumAccounts = 1;
                    getAuthToken(account, mAuthTokenType, null , mActivity,
                            mMyCallback, mHandler);
                    return;
                } 
                set(result);
            } 
            catch (OperationCanceledException e)
            {
                cancel(true );
            } 
            catch (IOException e)
            {
                setException(e);
            } 
            catch (AuthenticatorException e)
            {
                setException(e);
            } 
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.960 -0400", hash_original_field = "F3D9B685FE257E35A5518E55C53EDBB5", hash_generated_field = "011994D593F4EA76C280FB7FCC436706")

    private static final String TAG = "AccountManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.962 -0400", hash_original_field = "5682D7209AD8196B50CDE69B11CF84FC", hash_generated_field = "839EE2AD959F91D7F8A30C4DF896A0A9")

    public static final int ERROR_CODE_REMOTE_EXCEPTION = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.963 -0400", hash_original_field = "7B304DDB9B040633C59F1FF30BF3152E", hash_generated_field = "28836EE16DABE4CC8F98413027A9030B")

    public static final int ERROR_CODE_NETWORK_ERROR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.964 -0400", hash_original_field = "D478BA52CD235A967541002997DC3AA6", hash_generated_field = "E9001C9A5A6B658887C8978E4189FD52")

    public static final int ERROR_CODE_CANCELED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.964 -0400", hash_original_field = "FBFA7BA888137604C744C4C94598EE2D", hash_generated_field = "215CD378075E4729EC91AA3C099AEFED")

    public static final int ERROR_CODE_INVALID_RESPONSE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.965 -0400", hash_original_field = "9B4921D822E6A752A161E9638B7B5855", hash_generated_field = "0BA889018A83A6B2347976FA0C25E335")

    public static final int ERROR_CODE_UNSUPPORTED_OPERATION = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.966 -0400", hash_original_field = "441E288400266D25BF96690B5B2648CF", hash_generated_field = "3B28C1EA1CA857E1ECC16D27FCB2B421")

    public static final int ERROR_CODE_BAD_ARGUMENTS = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.966 -0400", hash_original_field = "B5C112F89B649221CF8D5CCD13A3E67C", hash_generated_field = "12AE862392583AD965A36301576778CD")

    public static final int ERROR_CODE_BAD_REQUEST = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.967 -0400", hash_original_field = "24012699D9C87B37F55B94D84D834D40", hash_generated_field = "F859CD3519729A82BCD23BCE5084C439")

    public static final String KEY_ACCOUNT_NAME = "authAccount";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.967 -0400", hash_original_field = "875DAE202146AE21D8E5C0D20C4DBEF8", hash_generated_field = "01FDA1F42087656DFED808AC20B15C21")

    public static final String KEY_ACCOUNT_TYPE = "accountType";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.968 -0400", hash_original_field = "CC71893A4FCD1A1DD4453793B59C31DA", hash_generated_field = "3A382E093156E682D8C89BEB9C2CF37B")

    public static final String KEY_AUTHTOKEN = "authtoken";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.968 -0400", hash_original_field = "71D907CB05409A0E28D4B7C31B332693", hash_generated_field = "DD3EB87933A482E342BDBCADB6FCD849")

    public static final String KEY_INTENT = "intent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.969 -0400", hash_original_field = "7C785D3EB4603FD221BC62F1CCD0E7C5", hash_generated_field = "B6E4CF7265B3037CDACBE69F87D1F211")

    public static final String KEY_PASSWORD = "password";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.970 -0400", hash_original_field = "04E43CD01AECF48894BA8EE76CBB2644", hash_generated_field = "48376F363D9C8E28672349E76C9AB9D6")

    public static final String KEY_ACCOUNTS = "accounts";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.971 -0400", hash_original_field = "673D226C4294710314CFC5F6B369553B", hash_generated_field = "B6500903448CA38B1C135E7FAACA8E59")

    public static final String KEY_ACCOUNT_AUTHENTICATOR_RESPONSE = "accountAuthenticatorResponse";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.972 -0400", hash_original_field = "DF580DCDEB34BC7D8289BF21DC88D9CF", hash_generated_field = "6787B86CE20B7D25DB80F65A6DF78575")

    public static final String KEY_ACCOUNT_MANAGER_RESPONSE = "accountManagerResponse";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.973 -0400", hash_original_field = "6DD28DC2AE7EADDDE62185F19A5BC429", hash_generated_field = "A880DA3011386B62681F12DCA6F995AF")

    public static final String KEY_AUTHENTICATOR_TYPES = "authenticator_types";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.973 -0400", hash_original_field = "7207C3402EF475A67F25B0533D159155", hash_generated_field = "E3A6E02E13FC436339BAE96EF05B9915")

    public static final String KEY_AUTH_FAILED_MESSAGE = "authFailedMessage";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.974 -0400", hash_original_field = "8100DBE9D757B60FBC5FF35925499144", hash_generated_field = "6A52A1128A766E523E11400904962290")

    public static final String KEY_AUTH_TOKEN_LABEL = "authTokenLabelKey";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.974 -0400", hash_original_field = "3BBBF4EBA1F856CE971818A9E0752502", hash_generated_field = "0966148F1C7D6F1B380611DBCB3F9034")

    public static final String KEY_BOOLEAN_RESULT = "booleanResult";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.975 -0400", hash_original_field = "960A9762BF50C605FD3F96ED7CBD1E0F", hash_generated_field = "5C41C2089C3858E1102D472FE91ABBF6")

    public static final String KEY_ERROR_CODE = "errorCode";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.975 -0400", hash_original_field = "562D9F4AA7449DA657AD433238B9EBD8", hash_generated_field = "6F255AB3CB507FA25E18B20330ACC508")

    public static final String KEY_ERROR_MESSAGE = "errorMessage";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.976 -0400", hash_original_field = "A1665E1BED4929F1C7402AA61D7E505B", hash_generated_field = "41604824FAA4E2183B26678B9BA94C58")

    public static final String KEY_USERDATA = "userdata";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.976 -0400", hash_original_field = "7FFBF08AD4199CBCC71ECAD71FA560BB", hash_generated_field = "C963ED8E4968C78870BB72394D89E0BF")

    public static final String KEY_CALLER_UID = "callerUid";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.977 -0400", hash_original_field = "16F796D4E32E0FA5E3B0838C6EB12ECF", hash_generated_field = "597D7766913E4C39E55EDE8137AC8EF2")

    public static final String KEY_CALLER_PID = "callerPid";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.978 -0400", hash_original_field = "179C3FFD19A70202F1C72887FFE6F426", hash_generated_field = "DDEECC7543FA2BF07514362519C946F4")

    public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.979 -0400", hash_original_field = "1C3D198C124F03E4909827C29DE5E097", hash_generated_field = "CBB4031BA4A54F6632AC99B12AF54139")

    public static final String KEY_NOTIFY_ON_FAILURE = "notifyOnAuthFailure";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.980 -0400", hash_original_field = "B9451B185DC55015635E10F1C7EF42FC", hash_generated_field = "7CF12A75D3DE0CB88FEDEEC45F4C6998")

    public static final String ACTION_AUTHENTICATOR_INTENT =
            "android.accounts.AccountAuthenticator";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.982 -0400", hash_original_field = "3A084764BEBCE1E8BD8FA48F063CDF80", hash_generated_field = "38C40DD9584F5E25D4E08184425EF38E")

    public static final String AUTHENTICATOR_META_DATA_NAME =
            "android.accounts.AccountAuthenticator";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.984 -0400", hash_original_field = "479EB2FA42E43378F91DDCFEA951F29D", hash_generated_field = "A69C2C428C8648CBB8DC6F428CBCC207")

    public static final String AUTHENTICATOR_ATTRIBUTES_NAME = "account-authenticator";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.985 -0400", hash_original_field = "C8E6097876D8D41A13679743EF63E966", hash_generated_field = "5DE28EA7EC32E4A054DAAC679C704B36")

    public static final String LOGIN_ACCOUNTS_CHANGED_ACTION =
        "android.accounts.LOGIN_ACCOUNTS_CHANGED";
}

