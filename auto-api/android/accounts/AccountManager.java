package android.accounts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:47.573 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:47.574 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "5EECF8903744EA4C4535FC399DE7EDD3")

    private IAccountManager mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:47.576 -0400", hash_original_field = "07ED8299DCE5FFC54346DB7582134B71", hash_generated_field = "36D62901B5F66AD7425C1042CCC68DC2")

    private Handler mMainHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:47.600 -0400", hash_original_field = "206AC291D9BD241BDB1384C71EF5E229", hash_generated_field = "2BF38CE0338E42EBAF74DC1DF3022092")

    private HashMap<OnAccountsUpdateListener, Handler> mAccountsUpdatedListeners = Maps.newHashMap();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.597 -0400", hash_original_field = "5B9AAF8C7934EB6B84189463FFEE1757", hash_generated_field = "F3C27DCFA809F817F0E873042B522300")

    private BroadcastReceiver mAccountsChangedBroadcastReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.595 -0400", hash_original_method = "06776CFD48438B35B07B048BEACBE4B9", hash_generated_method = "2472204FD0EA701E35D12BFBB8FC3B1D")
        public void onReceive(final Context context, final Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            Account[] accounts;
            accounts = getAccounts();
            {
                {
                    Iterator<Map.Entry<OnAccountsUpdateListener, Handler>> var0D76520BC83D9FFEE9B0229B4DA6D653_431162412 = (mAccountsUpdatedListeners.entrySet()).iterator();
                    var0D76520BC83D9FFEE9B0229B4DA6D653_431162412.hasNext();
                    Map.Entry<OnAccountsUpdateListener, Handler> entry = var0D76520BC83D9FFEE9B0229B4DA6D653_431162412.next();
                    {
                        postToHandler(entry.getValue(), entry.getKey(), accounts);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            // ---------- Original Method ----------
            //final Account[] accounts = getAccounts();
            //synchronized (mAccountsUpdatedListeners) {
                //for (Map.Entry<OnAccountsUpdateListener, Handler> entry :
                        //mAccountsUpdatedListeners.entrySet()) {
                    //postToHandler(entry.getValue(), entry.getKey(), accounts);
                //}
            //}
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.616 -0400", hash_original_method = "399D8365074F8431C3C32ED7720975E8", hash_generated_method = "699A204D5899DBCF695891C3392F1F59")
    public  AccountManager(Context context, IAccountManager service) {
        mContext = context;
        mService = service;
        mMainHandler = new Handler(mContext.getMainLooper());
        // ---------- Original Method ----------
        //mContext = context;
        //mService = service;
        //mMainHandler = new Handler(mContext.getMainLooper());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.623 -0400", hash_original_method = "25BBC3E1043ACDD515139061A9597BA7", hash_generated_method = "34C7F2EB81FAF854CED2B6C04922B77F")
    public  AccountManager(Context context, IAccountManager service, Handler handler) {
        mContext = context;
        mService = service;
        mMainHandler = handler;
        // ---------- Original Method ----------
        //mContext = context;
        //mService = service;
        //mMainHandler = handler;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.638 -0400", hash_original_method = "96491C15B9EBF498D1F12389B670F852", hash_generated_method = "C791B67AD025B47ADAD9663C10D22A5C")
    public String getPassword(final Account account) {
        String varB4EAC82CA7396A68D541C85D26508E83_1556045728 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1556045728 = mService.getPassword(account);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(account.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1556045728.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1556045728;
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //try {
            //return mService.getPassword(account);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.663 -0400", hash_original_method = "8DF662EA0E604D155E2F8EF5AE185580", hash_generated_method = "F9822E79DB8BBCAA73BAEA46EE436EA7")
    public String getUserData(final Account account, final String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_1355388448 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("key is null");
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1355388448 = mService.getUserData(account, key);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(account.getTaint());
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1355388448.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1355388448;
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //if (key == null) throw new IllegalArgumentException("key is null");
        //try {
            //return mService.getUserData(account, key);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.678 -0400", hash_original_method = "CE81752A69974A848970631715E35659", hash_generated_method = "930CA2AB6DC041A928786B970DD50926")
    public AuthenticatorDescription[] getAuthenticatorTypes() {
        AuthenticatorDescription[] varB4EAC82CA7396A68D541C85D26508E83_657400374 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_657400374 = mService.getAuthenticatorTypes();
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_657400374.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_657400374;
        // ---------- Original Method ----------
        //try {
            //return mService.getAuthenticatorTypes();
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.681 -0400", hash_original_method = "CBAE32CDB06D92C44980C30430EF1CC0", hash_generated_method = "804DD47F3831D3DB259471076C2DB7ED")
    public Account[] getAccounts() {
        Account[] varB4EAC82CA7396A68D541C85D26508E83_615018508 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_615018508 = mService.getAccounts(null);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_615018508.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_615018508;
        // ---------- Original Method ----------
        //try {
            //return mService.getAccounts(null);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.704 -0400", hash_original_method = "182706774272102452F63339D769DBB2", hash_generated_method = "C851F6E06BBB380E509AFC0E0148E589")
    public Account[] getAccountsByType(String type) {
        Account[] varB4EAC82CA7396A68D541C85D26508E83_437851556 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_437851556 = mService.getAccounts(type);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(type.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_437851556.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_437851556;
        // ---------- Original Method ----------
        //try {
            //return mService.getAccounts(type);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.732 -0400", hash_original_method = "74ADBAC1696D9C481AB31AC8146F1AF9", hash_generated_method = "516697312C0A6EDEEABC9863AE15D1D8")
    public AccountManagerFuture<Boolean> hasFeatures(final Account account,
            final String[] features,
            AccountManagerCallback<Boolean> callback, Handler handler) {
        AccountManagerFuture<Boolean> varB4EAC82CA7396A68D541C85D26508E83_1167715780 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("features is null");
        varB4EAC82CA7396A68D541C85D26508E83_1167715780 = new Future2Task<Boolean>(handler, callback) {
            public void doWork() throws RemoteException {
                mService.hasFeatures(mResponse, account, features);
            }
            public Boolean bundleToResult(Bundle bundle) throws AuthenticatorException {
                if (!bundle.containsKey(KEY_BOOLEAN_RESULT)) {
                    throw new AuthenticatorException("no result in response");
                }
                return bundle.getBoolean(KEY_BOOLEAN_RESULT);
            }
        }.start();
        addTaint(account.getTaint());
        addTaint(features[0].getTaint());
        addTaint(callback.getTaint());
        addTaint(handler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1167715780.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1167715780;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.738 -0400", hash_original_method = "430725BCDDC603435317A3A309F1AEF2", hash_generated_method = "E2DA1247E0C4621FF4D90D7FB5C636FD")
    public AccountManagerFuture<Account[]> getAccountsByTypeAndFeatures(
            final String type, final String[] features,
            AccountManagerCallback<Account[]> callback, Handler handler) {
        AccountManagerFuture<Account[]> varB4EAC82CA7396A68D541C85D26508E83_1877640875 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("type is null");
        varB4EAC82CA7396A68D541C85D26508E83_1877640875 = new Future2Task<Account[]>(handler, callback) {
            public void doWork() throws RemoteException {
                mService.getAccountsByFeatures(mResponse, type, features);
            }
            public Account[] bundleToResult(Bundle bundle) throws AuthenticatorException {
                if (!bundle.containsKey(KEY_ACCOUNTS)) {
                    throw new AuthenticatorException("no result in response");
                }
                final Parcelable[] parcelables = bundle.getParcelableArray(KEY_ACCOUNTS);
                Account[] descs = new Account[parcelables.length];
                for (int i = 0; i < parcelables.length; i++) {
                    descs[i] = (Account) parcelables[i];
                }
                return descs;
            }
        }.start();
        addTaint(type.getTaint());
        addTaint(features[0].getTaint());
        addTaint(callback.getTaint());
        addTaint(handler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1877640875.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1877640875;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.758 -0400", hash_original_method = "757D4D500E44E3A8DF2EF3DE74D56199", hash_generated_method = "F256F7FFC4B20A59D218DEE5AB1E31B3")
    public boolean addAccountExplicitly(Account account, String password, Bundle userdata) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        try 
        {
            boolean var3A306B1C872C1237D35170E997FB4C71_1654824273 = (mService.addAccount(account, password, userdata));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(account.getTaint());
        addTaint(password.getTaint());
        addTaint(userdata.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1786536126 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1786536126;
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //try {
            //return mService.addAccount(account, password, userdata);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.783 -0400", hash_original_method = "E8BA698C89E3CF76A294446D4D176FF0", hash_generated_method = "575B5414E54F090EF5891D298B7A8BE5")
    public AccountManagerFuture<Boolean> removeAccount(final Account account,
            AccountManagerCallback<Boolean> callback, Handler handler) {
        AccountManagerFuture<Boolean> varB4EAC82CA7396A68D541C85D26508E83_1909526267 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        varB4EAC82CA7396A68D541C85D26508E83_1909526267 = new Future2Task<Boolean>(handler, callback) {
            public void doWork() throws RemoteException {
                mService.removeAccount(mResponse, account);
            }
            public Boolean bundleToResult(Bundle bundle) throws AuthenticatorException {
                if (!bundle.containsKey(KEY_BOOLEAN_RESULT)) {
                    throw new AuthenticatorException("no result in response");
                }
                return bundle.getBoolean(KEY_BOOLEAN_RESULT);
            }
        }.start();
        addTaint(account.getTaint());
        addTaint(callback.getTaint());
        addTaint(handler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1909526267.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1909526267;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.797 -0400", hash_original_method = "4162D414A92CDAFD44055C84C3F9947E", hash_generated_method = "50040717DAD9BD89AD881719FE65D97B")
    public void invalidateAuthToken(final String accountType, final String authToken) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("accountType is null");
        try 
        {
            {
                mService.invalidateAuthToken(accountType, authToken);
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(accountType.getTaint());
        addTaint(authToken.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.809 -0400", hash_original_method = "DF00C62B1FBE79E2C2C3124DAA6E8CCA", hash_generated_method = "3C2793CF79631598011EA7DD83689E71")
    public String peekAuthToken(final Account account, final String authTokenType) {
        String varB4EAC82CA7396A68D541C85D26508E83_1879484527 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("authTokenType is null");
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1879484527 = mService.peekAuthToken(account, authTokenType);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(account.getTaint());
        addTaint(authTokenType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1879484527.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1879484527;
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //if (authTokenType == null) throw new IllegalArgumentException("authTokenType is null");
        //try {
            //return mService.peekAuthToken(account, authTokenType);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.812 -0400", hash_original_method = "DBE21AE149A5EC66FBC34FA1D5807CA3", hash_generated_method = "91CEB2CCDF7FAA8B0DB6CAB1CCF02760")
    public void setPassword(final Account account, final String password) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        try 
        {
            mService.setPassword(account, password);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(account.getTaint());
        addTaint(password.getTaint());
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //try {
            //mService.setPassword(account, password);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.815 -0400", hash_original_method = "9D6E3653B7C827404B4854FFAF700F44", hash_generated_method = "83F41A89E5E32EEEF2FB764111BEBA16")
    public void clearPassword(final Account account) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        try 
        {
            mService.clearPassword(account);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(account.getTaint());
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //try {
            //mService.clearPassword(account);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.825 -0400", hash_original_method = "39E18EFA140E2C140EF9BDAC244CFA88", hash_generated_method = "47412C4A6E4479A9E76750D2FCBFB4EA")
    public void setUserData(final Account account, final String key, final String value) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("key is null");
        try 
        {
            mService.setUserData(account, key, value);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(account.getTaint());
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //if (key == null) throw new IllegalArgumentException("key is null");
        //try {
            //mService.setUserData(account, key, value);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.832 -0400", hash_original_method = "967876CD971AD7982E73046636574113", hash_generated_method = "6AE383E61F53E49C88AB4C4B0D238E56")
    public void setAuthToken(Account account, final String authTokenType, final String authToken) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("authTokenType is null");
        try 
        {
            mService.setAuthToken(account, authTokenType, authToken);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(account.getTaint());
        addTaint(authTokenType.getTaint());
        addTaint(authToken.getTaint());
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //if (authTokenType == null) throw new IllegalArgumentException("authTokenType is null");
        //try {
            //mService.setAuthToken(account, authTokenType, authToken);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.847 -0400", hash_original_method = "51CDD8704FBB21791536BE5C26E3F85E", hash_generated_method = "76876EE4EBA717D61A847419EF23122D")
    public String blockingGetAuthToken(Account account, String authTokenType,
            boolean notifyAuthFailure) throws OperationCanceledException, IOException, AuthenticatorException {
        String varB4EAC82CA7396A68D541C85D26508E83_1168940404 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_269139965 = null; //Variable for return #2
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("authTokenType is null");
        Bundle bundle;
        bundle = getAuthToken(account, authTokenType, notifyAuthFailure, null ,
                null ).getResult();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1168940404 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_269139965 = bundle.getString(KEY_AUTHTOKEN);
        addTaint(account.getTaint());
        addTaint(authTokenType.getTaint());
        addTaint(notifyAuthFailure);
        String varA7E53CE21691AB073D9660D615818899_1822345815; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1822345815 = varB4EAC82CA7396A68D541C85D26508E83_1168940404;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1822345815 = varB4EAC82CA7396A68D541C85D26508E83_269139965;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1822345815.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1822345815;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.851 -0400", hash_original_method = "DC329BE18D12A187B670EF72046E93F0", hash_generated_method = "CD0FAD97EA2FF1A3354B43D6D52F117E")
    public AccountManagerFuture<Bundle> getAuthToken(
            final Account account, final String authTokenType, final Bundle options,
            final Activity activity, AccountManagerCallback<Bundle> callback, Handler handler) {
        AccountManagerFuture<Bundle> varB4EAC82CA7396A68D541C85D26508E83_806140456 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("authTokenType is null");
        Bundle optionsIn;
        optionsIn = new Bundle();
        {
            optionsIn.putAll(options);
        } //End block
        optionsIn.putString(KEY_ANDROID_PACKAGE_NAME, mContext.getPackageName());
        varB4EAC82CA7396A68D541C85D26508E83_806140456 = new AmsTask(activity, handler, callback) {
            public void doWork() throws RemoteException {
                mService.getAuthToken(mResponse, account, authTokenType,
                        false , true ,
                        optionsIn);
            }
        }.start();
        addTaint(account.getTaint());
        addTaint(authTokenType.getTaint());
        addTaint(options.getTaint());
        addTaint(activity.getTaint());
        addTaint(callback.getTaint());
        addTaint(handler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_806140456.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_806140456;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.861 -0400", hash_original_method = "63BBFF30BB2AEF86FE403A4E568375F4", hash_generated_method = "07028164406692392FFFC0B25AEBAF26")
    @Deprecated
    public AccountManagerFuture<Bundle> getAuthToken(
            final Account account, final String authTokenType, 
            final boolean notifyAuthFailure,
            AccountManagerCallback<Bundle> callback, Handler handler) {
        AccountManagerFuture<Bundle> varB4EAC82CA7396A68D541C85D26508E83_1848466919 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1848466919 = getAuthToken(account, authTokenType, null, notifyAuthFailure, callback, 
                handler);
        addTaint(account.getTaint());
        addTaint(authTokenType.getTaint());
        addTaint(notifyAuthFailure);
        addTaint(callback.getTaint());
        addTaint(handler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1848466919.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1848466919;
        // ---------- Original Method ----------
        //return getAuthToken(account, authTokenType, null, notifyAuthFailure, callback, 
                //handler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.871 -0400", hash_original_method = "748DC8BCC0E7F6CE1552DDD9EEAFB074", hash_generated_method = "65CF3AF880DDBE060EC7EBA3F7DFFCB3")
    public AccountManagerFuture<Bundle> getAuthToken(
            final Account account, final String authTokenType, final Bundle options,
            final boolean notifyAuthFailure,
            AccountManagerCallback<Bundle> callback, Handler handler) {
        AccountManagerFuture<Bundle> varB4EAC82CA7396A68D541C85D26508E83_1667316121 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("authTokenType is null");
        Bundle optionsIn;
        optionsIn = new Bundle();
        {
            optionsIn.putAll(options);
        } //End block
        optionsIn.putString(KEY_ANDROID_PACKAGE_NAME, mContext.getPackageName());
        varB4EAC82CA7396A68D541C85D26508E83_1667316121 = new AmsTask(null, handler, callback) {
            public void doWork() throws RemoteException {
                mService.getAuthToken(mResponse, account, authTokenType,
                        notifyAuthFailure, false , optionsIn);
            }
        }.start();
        addTaint(account.getTaint());
        addTaint(authTokenType.getTaint());
        addTaint(options.getTaint());
        addTaint(notifyAuthFailure);
        addTaint(callback.getTaint());
        addTaint(handler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1667316121.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1667316121;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.880 -0400", hash_original_method = "6ACDAD8A4FE951A7F40DF03A76D4A058", hash_generated_method = "B9D53AE05CCB2DB0208158856072EA4A")
    public AccountManagerFuture<Bundle> addAccount(final String accountType,
            final String authTokenType, final String[] requiredFeatures,
            final Bundle addAccountOptions,
            final Activity activity, AccountManagerCallback<Bundle> callback, Handler handler) {
        AccountManagerFuture<Bundle> varB4EAC82CA7396A68D541C85D26508E83_1451603363 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("accountType is null");
        Bundle optionsIn;
        optionsIn = new Bundle();
        {
            optionsIn.putAll(addAccountOptions);
        } //End block
        optionsIn.putString(KEY_ANDROID_PACKAGE_NAME, mContext.getPackageName());
        varB4EAC82CA7396A68D541C85D26508E83_1451603363 = new AmsTask(activity, handler, callback) {
            public void doWork() throws RemoteException {
                mService.addAcount(mResponse, accountType, authTokenType,
                        requiredFeatures, activity != null, optionsIn);
            }
        }.start();
        addTaint(accountType.getTaint());
        addTaint(authTokenType.getTaint());
        addTaint(requiredFeatures[0].getTaint());
        addTaint(addAccountOptions.getTaint());
        addTaint(activity.getTaint());
        addTaint(callback.getTaint());
        addTaint(handler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1451603363.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1451603363;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.890 -0400", hash_original_method = "E9F24B896DDD289C3D9D25FA0235DC55", hash_generated_method = "433876220DBA87F250EF49107E606070")
    public AccountManagerFuture<Bundle> confirmCredentials(final Account account,
            final Bundle options,
            final Activity activity,
            final AccountManagerCallback<Bundle> callback,
            final Handler handler) {
        AccountManagerFuture<Bundle> varB4EAC82CA7396A68D541C85D26508E83_142206328 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        varB4EAC82CA7396A68D541C85D26508E83_142206328 = new AmsTask(activity, handler, callback) {
            public void doWork() throws RemoteException {
                mService.confirmCredentials(mResponse, account, options, activity != null);
            }
        }.start();
        addTaint(account.getTaint());
        addTaint(options.getTaint());
        addTaint(activity.getTaint());
        addTaint(callback.getTaint());
        addTaint(handler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_142206328.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_142206328;
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //return new AmsTask(activity, handler, callback) {
            //public void doWork() throws RemoteException {
                //mService.confirmCredentials(mResponse, account, options, activity != null);
            //}
        //}.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.900 -0400", hash_original_method = "D809F6F9BB7D46EEEE0B772ED5C9F6A9", hash_generated_method = "199DBF50FEAC4B84DDB5EFEF4576DDC0")
    public AccountManagerFuture<Bundle> updateCredentials(final Account account,
            final String authTokenType,
            final Bundle options, final Activity activity,
            final AccountManagerCallback<Bundle> callback,
            final Handler handler) {
        AccountManagerFuture<Bundle> varB4EAC82CA7396A68D541C85D26508E83_1271869397 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        varB4EAC82CA7396A68D541C85D26508E83_1271869397 = new AmsTask(activity, handler, callback) {
            public void doWork() throws RemoteException {
                mService.updateCredentials(mResponse, account, authTokenType, activity != null,
                        options);
            }
        }.start();
        addTaint(account.getTaint());
        addTaint(authTokenType.getTaint());
        addTaint(options.getTaint());
        addTaint(activity.getTaint());
        addTaint(callback.getTaint());
        addTaint(handler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1271869397.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1271869397;
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //return new AmsTask(activity, handler, callback) {
            //public void doWork() throws RemoteException {
                //mService.updateCredentials(mResponse, account, authTokenType, activity != null,
                        //options);
            //}
        //}.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.904 -0400", hash_original_method = "72C42C362A18F251D937648B5DDE9096", hash_generated_method = "9D1FE47659E6AB95BCB8513BDA6F6662")
    public AccountManagerFuture<Bundle> editProperties(final String accountType,
            final Activity activity, final AccountManagerCallback<Bundle> callback,
            final Handler handler) {
        AccountManagerFuture<Bundle> varB4EAC82CA7396A68D541C85D26508E83_1862699046 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("accountType is null");
        varB4EAC82CA7396A68D541C85D26508E83_1862699046 = new AmsTask(activity, handler, callback) {
            public void doWork() throws RemoteException {
                mService.editProperties(mResponse, accountType, activity != null);
            }
        }.start();
        addTaint(accountType.getTaint());
        addTaint(activity.getTaint());
        addTaint(callback.getTaint());
        addTaint(handler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1862699046.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1862699046;
        // ---------- Original Method ----------
        //if (accountType == null) throw new IllegalArgumentException("accountType is null");
        //return new AmsTask(activity, handler, callback) {
            //public void doWork() throws RemoteException {
                //mService.editProperties(mResponse, accountType, activity != null);
            //}
        //}.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.913 -0400", hash_original_method = "05C769BBE692F72E464B52B58848EACE", hash_generated_method = "D40657251DD52B7576553485A562AD89")
    private void ensureNotOnMainThread() {
        Looper looper;
        looper = Looper.myLooper();
        {
            boolean var73759F18EFA09BFA80EBEDB498DD2F75_1792252119 = (looper != null && looper == mContext.getMainLooper());
            {
                IllegalStateException exception;
                exception = new IllegalStateException(
                    "calling this from your main thread can lead to deadlock");
                {
                    boolean var231355A96CE7FC42909F1BC96305F121_578520620 = (mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.FROYO);
                    {
                        if (DroidSafeAndroidRuntime.control) throw exception;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.918 -0400", hash_original_method = "80D38BDC6E0DE7333CAAD84CC9E6E84A", hash_generated_method = "A4A4F9CDB974A0B175AA44F60306B8D0")
    private void postToHandler(Handler handler, final AccountManagerCallback<Bundle> callback,
            final AccountManagerFuture<Bundle> future) {
        handler = handler == null ? mMainHandler : handler;
        handler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.916 -0400", hash_original_method = "BDBA0E8ABF21CCC323F7A43F04981195", hash_generated_method = "0CA3FE6CFE2D535345F3115B21FF729A")
            public void run() {
                callback.run(future);
                // ---------- Original Method ----------
                //callback.run(future);
            }
});
        addTaint(handler.getTaint());
        addTaint(callback.getTaint());
        addTaint(future.getTaint());
        // ---------- Original Method ----------
        //handler = handler == null ? mMainHandler : handler;
        //handler.post(new Runnable() {
            //public void run() {
                //callback.run(future);
            //}
        //});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.929 -0400", hash_original_method = "20F25A89C89C92245636BC8DCFF18BD7", hash_generated_method = "298825D92F66D9299A8354B6080A1321")
    private void postToHandler(Handler handler, final OnAccountsUpdateListener listener,
            final Account[] accounts) {
        Account[] accountsCopy;
        accountsCopy = new Account[accounts.length];
        System.arraycopy(accounts, 0, accountsCopy, 0, accountsCopy.length);
        handler = (handler == null) ? mMainHandler : handler;
        handler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.927 -0400", hash_original_method = "8E333205C0A7A1853354D3DAC2CB74E8", hash_generated_method = "75688E2D0FB82048FE4A4B86888BB4BE")
            public void run() {
                try 
                {
                    listener.onAccountsUpdated(accountsCopy);
                } //End block
                catch (SQLException e)
                { }
                // ---------- Original Method ----------
                //try {
                    //listener.onAccountsUpdated(accountsCopy);
                //} catch (SQLException e) {
                    //Log.e(TAG, "Can't update accounts", e);
                //}
            }
});
        addTaint(handler.getTaint());
        addTaint(listener.getTaint());
        addTaint(accounts[0].getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.940 -0400", hash_original_method = "6FDE075EEB86D1BECEDE842FFDA184DE", hash_generated_method = "ACBCD6597A91D556BB099A6088F1C0EB")
    private Exception convertErrorToException(int code, String message) {
        Exception varB4EAC82CA7396A68D541C85D26508E83_925025806 = null; //Variable for return #1
        Exception varB4EAC82CA7396A68D541C85D26508E83_748760015 = null; //Variable for return #2
        Exception varB4EAC82CA7396A68D541C85D26508E83_905702091 = null; //Variable for return #3
        Exception varB4EAC82CA7396A68D541C85D26508E83_398191535 = null; //Variable for return #4
        Exception varB4EAC82CA7396A68D541C85D26508E83_592543757 = null; //Variable for return #5
        {
            varB4EAC82CA7396A68D541C85D26508E83_925025806 = new IOException(message);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_748760015 = new UnsupportedOperationException(message);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_905702091 = new AuthenticatorException(message);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_398191535 = new IllegalArgumentException(message);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_592543757 = new AuthenticatorException(message);
        addTaint(code);
        addTaint(message.getTaint());
        Exception varA7E53CE21691AB073D9660D615818899_1783510928; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1783510928 = varB4EAC82CA7396A68D541C85D26508E83_925025806;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1783510928 = varB4EAC82CA7396A68D541C85D26508E83_748760015;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1783510928 = varB4EAC82CA7396A68D541C85D26508E83_905702091;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1783510928 = varB4EAC82CA7396A68D541C85D26508E83_398191535;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1783510928 = varB4EAC82CA7396A68D541C85D26508E83_592543757;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1783510928.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1783510928;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.109 -0400", hash_original_method = "801F35A66961F670B5EADD181BA66DC7", hash_generated_method = "57865F597839C56CA59054891CE27A02")
    public AccountManagerFuture<Bundle> getAuthTokenByFeatures(
            final String accountType, final String authTokenType, final String[] features,
            final Activity activity, final Bundle addAccountOptions,
            final Bundle getAuthTokenOptions,
            final AccountManagerCallback<Bundle> callback, final Handler handler) {
        AccountManagerFuture<Bundle> varB4EAC82CA7396A68D541C85D26508E83_1984563940 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account type is null");
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("authTokenType is null");
        GetAuthTokenByTypeAndFeaturesTask task;
        task = new GetAuthTokenByTypeAndFeaturesTask(accountType, authTokenType, features,
                activity, addAccountOptions, getAuthTokenOptions, callback, handler);
        task.start();
        varB4EAC82CA7396A68D541C85D26508E83_1984563940 = task;
        addTaint(accountType.getTaint());
        addTaint(authTokenType.getTaint());
        addTaint(features[0].getTaint());
        addTaint(activity.getTaint());
        addTaint(addAccountOptions.getTaint());
        addTaint(getAuthTokenOptions.getTaint());
        addTaint(callback.getTaint());
        addTaint(handler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1984563940.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1984563940;
        // ---------- Original Method ----------
        //if (accountType == null) throw new IllegalArgumentException("account type is null");
        //if (authTokenType == null) throw new IllegalArgumentException("authTokenType is null");
        //final GetAuthTokenByTypeAndFeaturesTask task =
                //new GetAuthTokenByTypeAndFeaturesTask(accountType, authTokenType, features,
                //activity, addAccountOptions, getAuthTokenOptions, callback, handler);
        //task.start();
        //return task;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.120 -0400", hash_original_method = "7A5668A93C6BCE258395457FB89679A1", hash_generated_method = "5FA28176CA5050E75CFE13A1F837303E")
    public void addOnAccountsUpdatedListener(final OnAccountsUpdateListener listener,
            Handler handler, boolean updateImmediately) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the listener is null");
        } //End block
        {
            {
                boolean varABDC43B51A11969F947C4F80A2C4B841_1782773486 = (mAccountsUpdatedListeners.containsKey(listener));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("this listener is already added");
                } //End block
            } //End collapsed parenthetic
            boolean wasEmpty;
            wasEmpty = mAccountsUpdatedListeners.isEmpty();
            mAccountsUpdatedListeners.put(listener, handler);
            {
                IntentFilter intentFilter;
                intentFilter = new IntentFilter();
                intentFilter.addAction(LOGIN_ACCOUNTS_CHANGED_ACTION);
                intentFilter.addAction(Intent.ACTION_DEVICE_STORAGE_OK);
                mContext.registerReceiver(mAccountsChangedBroadcastReceiver, intentFilter);
            } //End block
        } //End block
        {
            postToHandler(handler, listener, getAccounts());
        } //End block
        addTaint(listener.getTaint());
        addTaint(handler.getTaint());
        addTaint(updateImmediately);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.140 -0400", hash_original_method = "66F9A18B2BBFAE47B027D9D23A795F11", hash_generated_method = "A6AC88499440AEFE4CE214F40F885ABB")
    public void removeOnAccountsUpdatedListener(OnAccountsUpdateListener listener) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener is null");
        {
            {
                boolean var1C6325FC6028CC056AEBDA572E73C2D0_2102831474 = (!mAccountsUpdatedListeners.containsKey(listener));
            } //End collapsed parenthetic
            mAccountsUpdatedListeners.remove(listener);
            {
                boolean varED431896F12693751A225EDAD100E63A_1835037803 = (mAccountsUpdatedListeners.isEmpty());
                {
                    mContext.unregisterReceiver(mAccountsChangedBroadcastReceiver);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(listener.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.142 -0400", hash_original_field = "E72652B09AB331E8E60D8A37942A6989", hash_generated_field = "BCCFC11938EEC7DE34A0DE82C0A04729")

        IAccountManagerResponse mResponse;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.143 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

        Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.156 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "382974AD998518E9037A5E4EDC0E3105")

        AccountManagerCallback<Bundle> mCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.157 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "3895D7E6DB5042DA7856DC78E391C7B9")

        Activity mActivity;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.163 -0400", hash_original_method = "B1B053361B7316D8D8AF57ECEF4696C6", hash_generated_method = "28BC1A87CA8A0CC402A36B363995E588")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.181 -0400", hash_original_method = "E07DE3E7F6D29C4D4BDAC4812A3CF430", hash_generated_method = "29A5E324E7DFFE42AA74CE5B42F20603")
        public final AccountManagerFuture<Bundle> start() {
            AccountManagerFuture<Bundle> varB4EAC82CA7396A68D541C85D26508E83_115084277 = null; //Variable for return #1
            try 
            {
                doWork();
            } //End block
            catch (RemoteException e)
            {
                setException(e);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_115084277 = this;
            varB4EAC82CA7396A68D541C85D26508E83_115084277.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_115084277;
            // ---------- Original Method ----------
            //try {
                //doWork();
            //} catch (RemoteException e) {
                //setException(e);
            //}
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.185 -0400", hash_original_method = "127E02577FE14DDB30AB934EB38A0588", hash_generated_method = "025A3E7A13D5AD0D1CF22DBDF6DA7F51")
        protected void set(Bundle bundle) {
            super.set(bundle);
            addTaint(bundle.getTaint());
            // ---------- Original Method ----------
            //if (bundle == null) {
                //Log.e(TAG, "the bundle must not be null", new Exception());
            //}
            //super.set(bundle);
        }

        
        public abstract void doWork() throws RemoteException;

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.209 -0400", hash_original_method = "6C34E289CBAB2DD26AA2603338539143", hash_generated_method = "88D77E86D251B82A28E8749961B24F42")
        private Bundle internalGetResult(Long timeout, TimeUnit unit) throws OperationCanceledException, IOException, AuthenticatorException {
            Bundle varB4EAC82CA7396A68D541C85D26508E83_167195249 = null; //Variable for return #1
            Bundle varB4EAC82CA7396A68D541C85D26508E83_1251853773 = null; //Variable for return #2
            {
                boolean var1D60817A8CAE63E309C47BE23A4C8C61_1473768952 = (!isDone());
                {
                    ensureNotOnMainThread();
                } //End block
            } //End collapsed parenthetic
            try 
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_167195249 = get();
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1251853773 = get(timeout, unit);
                } //End block
            } //End block
            catch (CancellationException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new OperationCanceledException();
            } //End block
            catch (TimeoutException e)
            { }
            catch (InterruptedException e)
            { }
            catch (ExecutionException e)
            {
                Throwable cause;
                cause = e.getCause();
                {
                    if (DroidSafeAndroidRuntime.control) throw (IOException) cause;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new AuthenticatorException(cause);
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw (AuthenticatorException) cause;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw (RuntimeException) cause;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw (Error) cause;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(cause);
                } //End block
            } //End block
            finally 
            {
                cancel(true );
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new OperationCanceledException();
            addTaint(timeout.getTaint());
            addTaint(unit.getTaint());
            Bundle varA7E53CE21691AB073D9660D615818899_1108135704; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1108135704 = varB4EAC82CA7396A68D541C85D26508E83_167195249;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1108135704 = varB4EAC82CA7396A68D541C85D26508E83_1251853773;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1108135704.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1108135704;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.222 -0400", hash_original_method = "7428E8716809F4A01AF7F726F040DE64", hash_generated_method = "3EF823621B73037770BB87A5FC476A45")
        public Bundle getResult() throws OperationCanceledException, IOException, AuthenticatorException {
            Bundle varB4EAC82CA7396A68D541C85D26508E83_681406486 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_681406486 = internalGetResult(null, null);
            varB4EAC82CA7396A68D541C85D26508E83_681406486.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_681406486;
            // ---------- Original Method ----------
            //return internalGetResult(null, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.233 -0400", hash_original_method = "2DB61FA3CF370F8EAC405A022C9CA553", hash_generated_method = "E5E6BC1B4DFF4259B0B06C9CA9BD6D42")
        public Bundle getResult(long timeout, TimeUnit unit) throws OperationCanceledException, IOException, AuthenticatorException {
            Bundle varB4EAC82CA7396A68D541C85D26508E83_306299382 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_306299382 = internalGetResult(timeout, unit);
            addTaint(timeout);
            addTaint(unit.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_306299382.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_306299382;
            // ---------- Original Method ----------
            //return internalGetResult(timeout, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.244 -0400", hash_original_method = "3B9C9BC58CC1D6BA66EF9DB56725570D", hash_generated_method = "CAE741A2E9EFBA1FF7C26834B6AEF1FE")
        protected void done() {
            {
                postToHandler(mHandler, mCallback, this);
            } //End block
            // ---------- Original Method ----------
            //if (mCallback != null) {
                //postToHandler(mHandler, mCallback, this);
            //}
        }

        
        private class Response extends IAccountManagerResponse.Stub {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.255 -0400", hash_original_method = "1C91C9705FD3BE3D2A4F4357891D41FD", hash_generated_method = "1C91C9705FD3BE3D2A4F4357891D41FD")
            public Response ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.261 -0400", hash_original_method = "BC11F9A6ED106794CC5C9152E9BD3B43", hash_generated_method = "A1B6C3C32737132BED50412ABD99EA36")
            public void onResult(Bundle bundle) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                Intent intent;
                intent = bundle.getParcelable(KEY_INTENT);
                {
                    mActivity.startActivity(intent);
                } //End block
                {
                    boolean var80E32410CA7CB1AFA3ABADA4FB788EDD_572926083 = (bundle.getBoolean("retry"));
                    {
                        try 
                        {
                            doWork();
                        } //End block
                        catch (RemoteException e)
                        { }
                    } //End block
                    {
                        set(bundle);
                    } //End block
                } //End collapsed parenthetic
                addTaint(bundle.getTaint());
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.274 -0400", hash_original_method = "DD61FDBEB518045420249589A7AE75D2", hash_generated_method = "E2AD38EEB164268ED26CE9220A6F77FA")
            public void onError(int code, String message) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                {
                    cancel(true );
                } //End block
                setException(convertErrorToException(code, message));
                addTaint(code);
                addTaint(message.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.276 -0400", hash_original_field = "E72652B09AB331E8E60D8A37942A6989", hash_generated_field = "A54F64CAD983BA5040DC733186B2FF3B")

        public IAccountManagerResponse mResponse;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.290 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

        Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.297 -0400", hash_original_method = "26CFE7EFCBFE85C3047A425A4F720F86", hash_generated_method = "07FC7C468CB0119415FE7B69CAD44E68")
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

        
        public abstract void doWork() throws RemoteException;

        
        public abstract T bundleToResult(Bundle bundle) throws AuthenticatorException;

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.318 -0400", hash_original_method = "B01C5697E6FB95B4A78D57A4C431F13F", hash_generated_method = "E8B50AABD0789B6868AFC10731005679")
        protected void postRunnableToHandler(Runnable runnable) {
            Handler handler;
            handler = mMainHandler;
            handler = mHandler;
            handler.post(runnable);
            addTaint(runnable.getTaint());
            // ---------- Original Method ----------
            //Handler handler = (mHandler == null) ? mMainHandler : mHandler;
            //handler.post(runnable);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.320 -0400", hash_original_method = "030130E13746E076BBD203E6D46CECFF", hash_generated_method = "255E12B7B835ACF16F252F3ADA55C2A0")
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.330 -0400", hash_original_method = "1C91C9705FD3BE3D2A4F4357891D41FD", hash_generated_method = "1C91C9705FD3BE3D2A4F4357891D41FD")
            public Response ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.344 -0400", hash_original_method = "B8AEC5DE9AFE3040461BEFA9E791EE34", hash_generated_method = "742A4F5930842A5EFAAD43842FCEA19C")
            public void onResult(Bundle bundle) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                try 
                {
                    T result;
                    result = bundleToResult(bundle);
                    set(result);
                } //End block
                catch (ClassCastException e)
                { }
                catch (AuthenticatorException e)
                { }
                onError(ERROR_CODE_INVALID_RESPONSE, "no result in response");
                addTaint(bundle.getTaint());
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.351 -0400", hash_original_method = "DD61FDBEB518045420249589A7AE75D2", hash_generated_method = "E2AD38EEB164268ED26CE9220A6F77FA")
            public void onError(int code, String message) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                {
                    cancel(true );
                } //End block
                setException(convertErrorToException(code, message));
                addTaint(code);
                addTaint(message.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.352 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "719E4FBEE0E6D8BC8E61E553D79747F3")

        AccountManagerCallback<T> mCallback;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.354 -0400", hash_original_method = "FC1DD61776F9D5FC9C321068652B66F1", hash_generated_method = "25416D55C590A58D987A9673213B065A")
        public  Future2Task(Handler handler, AccountManagerCallback<T> callback) {
            super(handler);
            mCallback = callback;
            addTaint(handler.getTaint());
            // ---------- Original Method ----------
            //mCallback = callback;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.377 -0400", hash_original_method = "762C0B9FE5A1A00B697BA32E9AEAF22E", hash_generated_method = "3010E26221CEA7742DE697FF336B4798")
        protected void done() {
            {
                postRunnableToHandler(new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.376 -0400", hash_original_method = "0F70B80A50B592CBF5F504B35808D596", hash_generated_method = "7101081B29B4523A9AECBBD0EF73571E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.397 -0400", hash_original_method = "31A85EDC6833090D765F6613E9274CD1", hash_generated_method = "7CF92709DFCBFE5150FA1E7C911496CD")
        public Future2Task<T> start() {
            Future2Task<T> varB4EAC82CA7396A68D541C85D26508E83_998322088 = null; //Variable for return #1
            startTask();
            varB4EAC82CA7396A68D541C85D26508E83_998322088 = this;
            varB4EAC82CA7396A68D541C85D26508E83_998322088.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_998322088;
            // ---------- Original Method ----------
            //startTask();
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.415 -0400", hash_original_method = "41F0112BBEC6735226A2F41FF2202D7E", hash_generated_method = "B634820BB1589853764799077D356B3C")
        private T internalGetResult(Long timeout, TimeUnit unit) throws OperationCanceledException, IOException, AuthenticatorException {
            T varB4EAC82CA7396A68D541C85D26508E83_766701786 = null; //Variable for return #1
            T varB4EAC82CA7396A68D541C85D26508E83_1155876084 = null; //Variable for return #2
            {
                boolean var1D60817A8CAE63E309C47BE23A4C8C61_38889344 = (!isDone());
                {
                    ensureNotOnMainThread();
                } //End block
            } //End collapsed parenthetic
            try 
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_766701786 = get();
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1155876084 = get(timeout, unit);
                } //End block
            } //End block
            catch (InterruptedException e)
            { }
            catch (TimeoutException e)
            { }
            catch (CancellationException e)
            { }
            catch (ExecutionException e)
            {
                Throwable cause;
                cause = e.getCause();
                {
                    if (DroidSafeAndroidRuntime.control) throw (IOException) cause;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new AuthenticatorException(cause);
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw (AuthenticatorException) cause;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw (RuntimeException) cause;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw (Error) cause;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(cause);
                } //End block
            } //End block
            finally 
            {
                cancel(true );
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new OperationCanceledException();
            addTaint(timeout.getTaint());
            addTaint(unit.getTaint());
            T varA7E53CE21691AB073D9660D615818899_1075933696; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1075933696 = varB4EAC82CA7396A68D541C85D26508E83_766701786;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1075933696 = varB4EAC82CA7396A68D541C85D26508E83_1155876084;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1075933696.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1075933696;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.429 -0400", hash_original_method = "F09B519E265A8A66FE763E800742348B", hash_generated_method = "3ADBEF56788D83CB72A1F098967283DE")
        public T getResult() throws OperationCanceledException, IOException, AuthenticatorException {
            T varB4EAC82CA7396A68D541C85D26508E83_2115779859 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2115779859 = internalGetResult(null, null);
            varB4EAC82CA7396A68D541C85D26508E83_2115779859.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2115779859;
            // ---------- Original Method ----------
            //return internalGetResult(null, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.447 -0400", hash_original_method = "50CBD7888960B26C4BF28EA57E206BB1", hash_generated_method = "7D354C3A738CAF9841A30D775CE5173F")
        public T getResult(long timeout, TimeUnit unit) throws OperationCanceledException, IOException, AuthenticatorException {
            T varB4EAC82CA7396A68D541C85D26508E83_623644041 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_623644041 = internalGetResult(timeout, unit);
            addTaint(timeout);
            addTaint(unit.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_623644041.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_623644041;
            // ---------- Original Method ----------
            //return internalGetResult(timeout, unit);
        }

        
    }


    
    private class GetAuthTokenByTypeAndFeaturesTask extends AmsTask implements AccountManagerCallback<Bundle> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.452 -0400", hash_original_field = "89EED8F86B939D76F6E66671841F66E0", hash_generated_field = "DA7FCA7FD25B2715DDA5B1151A329B57")

        volatile AccountManagerFuture<Bundle> mFuture = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.453 -0400", hash_original_field = "D3E1F03AA680CFA730A921954023E5B9", hash_generated_field = "1BAC3F5B48D7CBDC0DEC096887906F9A")

        String mAccountType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.461 -0400", hash_original_field = "69D299670D936CF5E779CEC994C9B669", hash_generated_field = "62E235D18D61381B167C250C0385DCF5")

        String mAuthTokenType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.462 -0400", hash_original_field = "B6FEAD34C9CE2FFD9FDB8BCB7536B5B4", hash_generated_field = "BB73EBD9036EEEC92FAB5A91A39B5A6F")

        String[] mFeatures;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.463 -0400", hash_original_field = "612B48E31872CED4823D637CF52B7B68", hash_generated_field = "7B6AE567E0F7C37B83B94413E80422D3")

        Bundle mAddAccountOptions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.464 -0400", hash_original_field = "DEE378E96D6BC88E66F300481BD20A99", hash_generated_field = "4B7678D538696871E7C4A9E9A154E69B")

        Bundle mLoginOptions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.465 -0400", hash_original_field = "4AC3E767900DAB7270D2E11DF66BD083", hash_generated_field = "9AB039BA73F970DDDFBFE5E982A0A257")

        AccountManagerCallback<Bundle> mMyCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.482 -0400", hash_original_field = "FF4A321CA3E8F9F098306FE32821F7F6", hash_generated_field = "71E70B13764C89A5A2D6CAA3A090D703")

        private volatile int mNumAccounts = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.489 -0400", hash_original_method = "8B428F75DFA4C0F7DC2037249CE783CE", hash_generated_method = "3EF061C9405E0A149B5B68A00E1C2818")
          GetAuthTokenByTypeAndFeaturesTask(final String accountType, final String authTokenType,
                final String[] features, Activity activityForPrompting,
                final Bundle addAccountOptions, final Bundle loginOptions,
                AccountManagerCallback<Bundle> callback, Handler handler) {
            super(activityForPrompting, handler, callback);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account type is null");
            mAccountType = accountType;
            mAuthTokenType = authTokenType;
            mFeatures = features;
            mAddAccountOptions = addAccountOptions;
            mLoginOptions = loginOptions;
            mMyCallback = this;
            addTaint(activityForPrompting.getTaint());
            addTaint(callback.getTaint());
            addTaint(handler.getTaint());
            // ---------- Original Method ----------
            //if (accountType == null) throw new IllegalArgumentException("account type is null");
            //mAccountType = accountType;
            //mAuthTokenType = authTokenType;
            //mFeatures = features;
            //mAddAccountOptions = addAccountOptions;
            //mLoginOptions = loginOptions;
            //mMyCallback = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.552 -0400", hash_original_method = "C4C5F207D191035A436136641EA5FDB4", hash_generated_method = "DFF82B690EC9D550936696AAC08838EC")
        public void doWork() throws RemoteException {
            getAccountsByTypeAndFeatures(mAccountType, mFeatures,
                    new AccountManagerCallback<Account[]>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.543 -0400", hash_original_method = "A16608B5927D0AB580BEC16F01D5E6C5", hash_generated_method = "787661EBE1122EE5DC3AD1B49BC0BA3F")
                public void run(AccountManagerFuture<Account[]> future) {
                    Account[] accounts;
                    try 
                    {
                        accounts = future.getResult();
                    } //End block
                    catch (OperationCanceledException e)
                    {
                        setException(e);
                    } //End block
                    catch (IOException e)
                    {
                        setException(e);
                    } //End block
                    catch (AuthenticatorException e)
                    {
                        setException(e);
                    } //End block
                    mNumAccounts = accounts.length;
                    {
                        {
                            mFuture = addAccount(mAccountType, mAuthTokenType, mFeatures,
                                            mAddAccountOptions, mActivity, mMyCallback, mHandler);
                        } //End block
                        {
                            Bundle result;
                            result = new Bundle();
                            result.putString(KEY_ACCOUNT_NAME, null);
                            result.putString(KEY_ACCOUNT_TYPE, null);
                            result.putString(KEY_AUTHTOKEN, null);
                            try 
                            {
                                mResponse.onResult(result);
                            } //End block
                            catch (RemoteException e)
                            { }
                        } //End block
                    } //End block
                    {
                        {
                            mFuture = getAuthToken(accounts[0], mAuthTokenType,
                                            false , mMyCallback, mHandler);
                        } //End block
                        {
                            mFuture = getAuthToken(accounts[0],
                                            mAuthTokenType, mLoginOptions,
                                            mActivity, mMyCallback, mHandler);
                        } //End block
                    } //End block
                    {
                        {
                            IAccountManagerResponse chooseResponse;
                            chooseResponse = new IAccountManagerResponse.Stub() {
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
                            Intent intent;
                            intent = new Intent();
                            intent.setClassName("android",
                                            "android.accounts.ChooseAccountActivity");
                            intent.putExtra(KEY_ACCOUNTS, accounts);
                            intent.putExtra(KEY_ACCOUNT_MANAGER_RESPONSE,
                                            new AccountManagerResponse(chooseResponse));
                            mActivity.startActivity(intent);
                        } //End block
                        {
                            Bundle result;
                            result = new Bundle();
                            result.putString(KEY_ACCOUNTS, null);
                            try 
                            {
                                mResponse.onResult(result);
                            } //End block
                            catch (RemoteException e)
                            { }
                        } //End block
                    } //End block
                    addTaint(future.getTaint());
                    // ---------- Original Method ----------
                    // Original Method Too Long, Refer to Original Implementation
                }
}, mHandler);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.578 -0400", hash_original_method = "770A26A7F965A1883CF21DF75B7155CF", hash_generated_method = "3C3379B2AB9D4191BDBB15EA9D6FBC4D")
        public void run(AccountManagerFuture<Bundle> future) {
            try 
            {
                Bundle result;
                result = future.getResult();
                {
                    String accountName;
                    accountName = result.getString(KEY_ACCOUNT_NAME);
                    String accountType;
                    accountType = result.getString(KEY_ACCOUNT_TYPE);
                    {
                        boolean var82B2475C7FDB438FF43C0F4978E62379_522884382 = (TextUtils.isEmpty(accountName) || TextUtils.isEmpty(accountType));
                        {
                            setException(new AuthenticatorException("account not in result"));
                        } //End block
                    } //End collapsed parenthetic
                    Account account;
                    account = new Account(accountName, accountType);
                    mNumAccounts = 1;
                    getAuthToken(account, mAuthTokenType, null , mActivity,
                            mMyCallback, mHandler);
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
            addTaint(future.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.579 -0400", hash_original_field = "F3D9B685FE257E35A5518E55C53EDBB5", hash_generated_field = "EA57548DB8B34343C76C30111D7CED45")

    private static String TAG = "AccountManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.579 -0400", hash_original_field = "5682D7209AD8196B50CDE69B11CF84FC", hash_generated_field = "839EE2AD959F91D7F8A30C4DF896A0A9")

    public static final int ERROR_CODE_REMOTE_EXCEPTION = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.580 -0400", hash_original_field = "7B304DDB9B040633C59F1FF30BF3152E", hash_generated_field = "28836EE16DABE4CC8F98413027A9030B")

    public static final int ERROR_CODE_NETWORK_ERROR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.593 -0400", hash_original_field = "D478BA52CD235A967541002997DC3AA6", hash_generated_field = "E9001C9A5A6B658887C8978E4189FD52")

    public static final int ERROR_CODE_CANCELED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.594 -0400", hash_original_field = "FBFA7BA888137604C744C4C94598EE2D", hash_generated_field = "215CD378075E4729EC91AA3C099AEFED")

    public static final int ERROR_CODE_INVALID_RESPONSE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.595 -0400", hash_original_field = "9B4921D822E6A752A161E9638B7B5855", hash_generated_field = "0BA889018A83A6B2347976FA0C25E335")

    public static final int ERROR_CODE_UNSUPPORTED_OPERATION = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.605 -0400", hash_original_field = "441E288400266D25BF96690B5B2648CF", hash_generated_field = "3B28C1EA1CA857E1ECC16D27FCB2B421")

    public static final int ERROR_CODE_BAD_ARGUMENTS = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.605 -0400", hash_original_field = "B5C112F89B649221CF8D5CCD13A3E67C", hash_generated_field = "12AE862392583AD965A36301576778CD")

    public static final int ERROR_CODE_BAD_REQUEST = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.606 -0400", hash_original_field = "24012699D9C87B37F55B94D84D834D40", hash_generated_field = "F859CD3519729A82BCD23BCE5084C439")

    public static final String KEY_ACCOUNT_NAME = "authAccount";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.607 -0400", hash_original_field = "875DAE202146AE21D8E5C0D20C4DBEF8", hash_generated_field = "01FDA1F42087656DFED808AC20B15C21")

    public static final String KEY_ACCOUNT_TYPE = "accountType";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.607 -0400", hash_original_field = "CC71893A4FCD1A1DD4453793B59C31DA", hash_generated_field = "3A382E093156E682D8C89BEB9C2CF37B")

    public static final String KEY_AUTHTOKEN = "authtoken";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.618 -0400", hash_original_field = "71D907CB05409A0E28D4B7C31B332693", hash_generated_field = "DD3EB87933A482E342BDBCADB6FCD849")

    public static final String KEY_INTENT = "intent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.618 -0400", hash_original_field = "7C785D3EB4603FD221BC62F1CCD0E7C5", hash_generated_field = "B6E4CF7265B3037CDACBE69F87D1F211")

    public static final String KEY_PASSWORD = "password";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.620 -0400", hash_original_field = "04E43CD01AECF48894BA8EE76CBB2644", hash_generated_field = "48376F363D9C8E28672349E76C9AB9D6")

    public static final String KEY_ACCOUNTS = "accounts";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.620 -0400", hash_original_field = "673D226C4294710314CFC5F6B369553B", hash_generated_field = "B6500903448CA38B1C135E7FAACA8E59")

    public static final String KEY_ACCOUNT_AUTHENTICATOR_RESPONSE = "accountAuthenticatorResponse";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.621 -0400", hash_original_field = "DF580DCDEB34BC7D8289BF21DC88D9CF", hash_generated_field = "6787B86CE20B7D25DB80F65A6DF78575")

    public static final String KEY_ACCOUNT_MANAGER_RESPONSE = "accountManagerResponse";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.633 -0400", hash_original_field = "6DD28DC2AE7EADDDE62185F19A5BC429", hash_generated_field = "A880DA3011386B62681F12DCA6F995AF")

    public static final String KEY_AUTHENTICATOR_TYPES = "authenticator_types";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.634 -0400", hash_original_field = "7207C3402EF475A67F25B0533D159155", hash_generated_field = "E3A6E02E13FC436339BAE96EF05B9915")

    public static final String KEY_AUTH_FAILED_MESSAGE = "authFailedMessage";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.634 -0400", hash_original_field = "8100DBE9D757B60FBC5FF35925499144", hash_generated_field = "6A52A1128A766E523E11400904962290")

    public static final String KEY_AUTH_TOKEN_LABEL = "authTokenLabelKey";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.647 -0400", hash_original_field = "3BBBF4EBA1F856CE971818A9E0752502", hash_generated_field = "0966148F1C7D6F1B380611DBCB3F9034")

    public static final String KEY_BOOLEAN_RESULT = "booleanResult";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.648 -0400", hash_original_field = "960A9762BF50C605FD3F96ED7CBD1E0F", hash_generated_field = "5C41C2089C3858E1102D472FE91ABBF6")

    public static final String KEY_ERROR_CODE = "errorCode";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.649 -0400", hash_original_field = "562D9F4AA7449DA657AD433238B9EBD8", hash_generated_field = "6F255AB3CB507FA25E18B20330ACC508")

    public static final String KEY_ERROR_MESSAGE = "errorMessage";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.659 -0400", hash_original_field = "A1665E1BED4929F1C7402AA61D7E505B", hash_generated_field = "41604824FAA4E2183B26678B9BA94C58")

    public static final String KEY_USERDATA = "userdata";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.660 -0400", hash_original_field = "7FFBF08AD4199CBCC71ECAD71FA560BB", hash_generated_field = "C963ED8E4968C78870BB72394D89E0BF")

    public static final String KEY_CALLER_UID = "callerUid";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.661 -0400", hash_original_field = "16F796D4E32E0FA5E3B0838C6EB12ECF", hash_generated_field = "597D7766913E4C39E55EDE8137AC8EF2")

    public static final String KEY_CALLER_PID = "callerPid";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.662 -0400", hash_original_field = "179C3FFD19A70202F1C72887FFE6F426", hash_generated_field = "DDEECC7543FA2BF07514362519C946F4")

    public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.673 -0400", hash_original_field = "1C3D198C124F03E4909827C29DE5E097", hash_generated_field = "CBB4031BA4A54F6632AC99B12AF54139")

    public static final String KEY_NOTIFY_ON_FAILURE = "notifyOnAuthFailure";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.674 -0400", hash_original_field = "B9451B185DC55015635E10F1C7EF42FC", hash_generated_field = "7CF12A75D3DE0CB88FEDEEC45F4C6998")

    public static final String ACTION_AUTHENTICATOR_INTENT =
            "android.accounts.AccountAuthenticator";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.675 -0400", hash_original_field = "3A084764BEBCE1E8BD8FA48F063CDF80", hash_generated_field = "38C40DD9584F5E25D4E08184425EF38E")

    public static final String AUTHENTICATOR_META_DATA_NAME =
            "android.accounts.AccountAuthenticator";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.682 -0400", hash_original_field = "479EB2FA42E43378F91DDCFEA951F29D", hash_generated_field = "A69C2C428C8648CBB8DC6F428CBCC207")

    public static final String AUTHENTICATOR_ATTRIBUTES_NAME = "account-authenticator";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:37.683 -0400", hash_original_field = "C8E6097876D8D41A13679743EF63E966", hash_generated_field = "5DE28EA7EC32E4A054DAAC679C704B36")

    public static final String LOGIN_ACCOUNTS_CHANGED_ACTION =
        "android.accounts.LOGIN_ACCOUNTS_CHANGED";
}

