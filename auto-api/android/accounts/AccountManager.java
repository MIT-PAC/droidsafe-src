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
    private Context mContext;
    private IAccountManager mService;
    private Handler mMainHandler;
    private HashMap<OnAccountsUpdateListener, Handler> mAccountsUpdatedListeners =
            Maps.newHashMap();
    private final BroadcastReceiver mAccountsChangedBroadcastReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.175 -0400", hash_original_method = "06776CFD48438B35B07B048BEACBE4B9", hash_generated_method = "49018C6D38D15122A3F28C043BE73F41")
        @DSModeled(DSC.SPEC)
        public void onReceive(final Context context, final Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            Account[] accounts;
            accounts = getAccounts();
            {
                {
                    Iterator<Map.Entry<OnAccountsUpdateListener, Handler>> var0D76520BC83D9FFEE9B0229B4DA6D653_1535386447 = (mAccountsUpdatedListeners.entrySet()).iterator();
                    var0D76520BC83D9FFEE9B0229B4DA6D653_1535386447.hasNext();
                    Map.Entry<OnAccountsUpdateListener, Handler> entry = var0D76520BC83D9FFEE9B0229B4DA6D653_1535386447.next();
                    {
                        postToHandler(entry.getValue(), entry.getKey(), accounts);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //final Account[] accounts = getAccounts();
            //synchronized (mAccountsUpdatedListeners) {
                //for (Map.Entry<OnAccountsUpdateListener, Handler> entry :
                        //mAccountsUpdatedListeners.entrySet()) {
                    //postToHandler(entry.getValue(), entry.getKey(), accounts);
                //}
            //}
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.177 -0400", hash_original_method = "399D8365074F8431C3C32ED7720975E8", hash_generated_method = "D567C88B4BC944140A92455A6CEF3B22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccountManager(Context context, IAccountManager service) {
        dsTaint.addTaint(service.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        mMainHandler = new Handler(mContext.getMainLooper());
        // ---------- Original Method ----------
        //mContext = context;
        //mService = service;
        //mMainHandler = new Handler(mContext.getMainLooper());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.177 -0400", hash_original_method = "25BBC3E1043ACDD515139061A9597BA7", hash_generated_method = "20DEE9234B799A95942975E93F33DFBB")
    @DSModeled(DSC.SAFE)
    public AccountManager(Context context, IAccountManager service, Handler handler) {
        dsTaint.addTaint(service.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.180 -0400", hash_original_method = "96491C15B9EBF498D1F12389B670F852", hash_generated_method = "DC2FF63F75235874D6EFBE84CA530A98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPassword(final Account account) {
        dsTaint.addTaint(account.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        try 
        {
            String var3A59FB73DBA6384EBB2816FD253D3952_1906825559 = (mService.getPassword(account));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //try {
            //return mService.getPassword(account);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.183 -0400", hash_original_method = "8DF662EA0E604D155E2F8EF5AE185580", hash_generated_method = "2FA858DD5D517B208918E9F142DE8B43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getUserData(final Account account, final String key) {
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(key);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("key is null");
        try 
        {
            String varF8E02279D9C9F3844D4D4D2A5B7ECE71_3437812 = (mService.getUserData(account, key));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //if (key == null) throw new IllegalArgumentException("key is null");
        //try {
            //return mService.getUserData(account, key);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.184 -0400", hash_original_method = "CE81752A69974A848970631715E35659", hash_generated_method = "E05B56B10D7D07FE7EC4317A6CAC7BBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthenticatorDescription[] getAuthenticatorTypes() {
        try 
        {
            AuthenticatorDescription[] var0C4D8774EE9C7621D56ADC4787BF6457_1562950604 = (mService.getAuthenticatorTypes());
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        return (AuthenticatorDescription[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getAuthenticatorTypes();
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.185 -0400", hash_original_method = "CBAE32CDB06D92C44980C30430EF1CC0", hash_generated_method = "5A154FD9EA8007058AAD9666CF45F177")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Account[] getAccounts() {
        try 
        {
            Account[] varF6F36E2050CB4901E3F4F4A02CF6B296_645545678 = (mService.getAccounts(null));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        return (Account[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getAccounts(null);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.186 -0400", hash_original_method = "182706774272102452F63339D769DBB2", hash_generated_method = "6124DD59694E636FD223B1F28A094FC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Account[] getAccountsByType(String type) {
        dsTaint.addTaint(type);
        try 
        {
            Account[] var614EF55C18FDB59BCC4C1AF4979800DD_600494039 = (mService.getAccounts(type));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        return (Account[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getAccounts(type);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.193 -0400", hash_original_method = "74ADBAC1696D9C481AB31AC8146F1AF9", hash_generated_method = "08251DCFB112899B1FD58BFD441A76F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccountManagerFuture<Boolean> hasFeatures(final Account account,
            final String[] features,
            AccountManagerCallback<Boolean> callback, Handler handler) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(features[0]);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("features is null");
        AccountManagerFuture<Boolean> varE76755536DDA5211CB2376BFB42DF8C9_1839892774 = (new Future2Task<Boolean>(handler, callback) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.188 -0400", hash_original_method = "FFBFF398261B5CC044E2A91B7E73D5E3", hash_generated_method = "89205067D73CE89B6B97941EBFF4C904")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void doWork() throws RemoteException {
                mService.hasFeatures(mResponse, account, features);
                // ---------- Original Method ----------
                //mService.hasFeatures(mResponse, account, features);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.190 -0400", hash_original_method = "EE3E978FB5F7BB3B094FBC48A926EAB2", hash_generated_method = "BE459C664A258516A9BD355F41EC9047")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Boolean bundleToResult(Bundle bundle) throws AuthenticatorException {
                dsTaint.addTaint(bundle.dsTaint);
                {
                    boolean var44C21E0FF2FF10CB71F75670F87308A6_548657005 = (!bundle.containsKey(KEY_BOOLEAN_RESULT));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new AuthenticatorException("no result in response");
                    } //End block
                } //End collapsed parenthetic
                Boolean varA5BF16BFF0E5D01263AAEA2242EC5E9D_393302133 = (bundle.getBoolean(KEY_BOOLEAN_RESULT));
                return (Boolean)dsTaint.getTaint();
                // ---------- Original Method ----------
                //if (!bundle.containsKey(KEY_BOOLEAN_RESULT)) {
                    //throw new AuthenticatorException("no result in response");
                //}
                //return bundle.getBoolean(KEY_BOOLEAN_RESULT);
            }
}.start());
        return (AccountManagerFuture<Boolean>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.199 -0400", hash_original_method = "430725BCDDC603435317A3A309F1AEF2", hash_generated_method = "07A767AA4D7CB9712AA246FEBA807837")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccountManagerFuture<Account[]> getAccountsByTypeAndFeatures(
            final String type, final String[] features,
            AccountManagerCallback<Account[]> callback, Handler handler) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(features[0]);
        dsTaint.addTaint(type);
        dsTaint.addTaint(handler.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("type is null");
        AccountManagerFuture<Account[]> var133C750B9C2C8036FB482A0DB40A5C72_742423225 = (new Future2Task<Account[]>(handler, callback) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.195 -0400", hash_original_method = "73AB820A1E98A1765445367AD9245309", hash_generated_method = "E4EFF5B2612046AA05CA36509915F542")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void doWork() throws RemoteException {
                mService.getAccountsByFeatures(mResponse, type, features);
                // ---------- Original Method ----------
                //mService.getAccountsByFeatures(mResponse, type, features);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.197 -0400", hash_original_method = "4E01F2C268DC2C127E06F0E054062427", hash_generated_method = "095DF61AE648C603930B7CEFB4B48448")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Account[] bundleToResult(Bundle bundle) throws AuthenticatorException {
                dsTaint.addTaint(bundle.dsTaint);
                {
                    boolean var9D991CA7DBFE2F3F342914ABE05428C5_318223113 = (!bundle.containsKey(KEY_ACCOUNTS));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new AuthenticatorException("no result in response");
                    } //End block
                } //End collapsed parenthetic
                Parcelable[] parcelables;
                parcelables = bundle.getParcelableArray(KEY_ACCOUNTS);
                Account[] descs;
                descs = new Account[parcelables.length];
                {
                    int i;
                    i = 0;
                    {
                        descs[i] = (Account) parcelables[i];
                    } //End block
                } //End collapsed parenthetic
                return (Account[])dsTaint.getTaint();
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
}.start());
        return (AccountManagerFuture<Account[]>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.201 -0400", hash_original_method = "757D4D500E44E3A8DF2EF3DE74D56199", hash_generated_method = "BC2C31BB469A2F188067CEC49ACD6437")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean addAccountExplicitly(Account account, String password, Bundle userdata) {
        dsTaint.addTaint(userdata.dsTaint);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(password);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        try 
        {
            boolean var3A306B1C872C1237D35170E997FB4C71_1612280924 = (mService.addAccount(account, password, userdata));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //try {
            //return mService.addAccount(account, password, userdata);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.207 -0400", hash_original_method = "E8BA698C89E3CF76A294446D4D176FF0", hash_generated_method = "F685626580BF4D1B0026CA97C1C5156E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccountManagerFuture<Boolean> removeAccount(final Account account,
            AccountManagerCallback<Boolean> callback, Handler handler) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        AccountManagerFuture<Boolean> var3AABAC9895260116B81711D5DDD09641_260066373 = (new Future2Task<Boolean>(handler, callback) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.202 -0400", hash_original_method = "008B2E3F52D7383A94B933DA4159D4A7", hash_generated_method = "81AD4A0CB256A6E863BA4C31FFEB45E7")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void doWork() throws RemoteException {
                mService.removeAccount(mResponse, account);
                // ---------- Original Method ----------
                //mService.removeAccount(mResponse, account);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.206 -0400", hash_original_method = "EE3E978FB5F7BB3B094FBC48A926EAB2", hash_generated_method = "7CF7820830F6775A9E0B6FC358FAA9F8")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Boolean bundleToResult(Bundle bundle) throws AuthenticatorException {
                dsTaint.addTaint(bundle.dsTaint);
                {
                    boolean var44C21E0FF2FF10CB71F75670F87308A6_1154609986 = (!bundle.containsKey(KEY_BOOLEAN_RESULT));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new AuthenticatorException("no result in response");
                    } //End block
                } //End collapsed parenthetic
                Boolean varA5BF16BFF0E5D01263AAEA2242EC5E9D_335292498 = (bundle.getBoolean(KEY_BOOLEAN_RESULT));
                return (Boolean)dsTaint.getTaint();
                // ---------- Original Method ----------
                //if (!bundle.containsKey(KEY_BOOLEAN_RESULT)) {
                    //throw new AuthenticatorException("no result in response");
                //}
                //return bundle.getBoolean(KEY_BOOLEAN_RESULT);
            }
}.start());
        return (AccountManagerFuture<Boolean>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.209 -0400", hash_original_method = "4162D414A92CDAFD44055C84C3F9947E", hash_generated_method = "CE66633562EC3E2472D445B47C3287C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invalidateAuthToken(final String accountType, final String authToken) {
        dsTaint.addTaint(authToken);
        dsTaint.addTaint(accountType);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.211 -0400", hash_original_method = "DF00C62B1FBE79E2C2C3124DAA6E8CCA", hash_generated_method = "BB579D119314ECEB37A996C77FF395CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String peekAuthToken(final Account account, final String authTokenType) {
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(authTokenType);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("authTokenType is null");
        try 
        {
            String varCECF102E3BD77C6FC5695F60AD665193_1240792576 = (mService.peekAuthToken(account, authTokenType));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //if (authTokenType == null) throw new IllegalArgumentException("authTokenType is null");
        //try {
            //return mService.peekAuthToken(account, authTokenType);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.212 -0400", hash_original_method = "DBE21AE149A5EC66FBC34FA1D5807CA3", hash_generated_method = "7726E9FEED7E875D1700366457927857")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPassword(final Account account, final String password) {
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(password);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        try 
        {
            mService.setPassword(account, password);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //try {
            //mService.setPassword(account, password);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.214 -0400", hash_original_method = "9D6E3653B7C827404B4854FFAF700F44", hash_generated_method = "022E05EAEC2E51C92CC7BC00F6993563")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearPassword(final Account account) {
        dsTaint.addTaint(account.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        try 
        {
            mService.clearPassword(account);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //try {
            //mService.clearPassword(account);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.216 -0400", hash_original_method = "39E18EFA140E2C140EF9BDAC244CFA88", hash_generated_method = "F7B2FD7641F04197D00851776A6384E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUserData(final Account account, final String key, final String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(key);
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
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //if (key == null) throw new IllegalArgumentException("key is null");
        //try {
            //mService.setUserData(account, key, value);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.218 -0400", hash_original_method = "967876CD971AD7982E73046636574113", hash_generated_method = "F82B8022997FD9DF3DD3B12824571707")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAuthToken(Account account, final String authTokenType, final String authToken) {
        dsTaint.addTaint(authToken);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(authTokenType);
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
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //if (authTokenType == null) throw new IllegalArgumentException("authTokenType is null");
        //try {
            //mService.setAuthToken(account, authTokenType, authToken);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.221 -0400", hash_original_method = "51CDD8704FBB21791536BE5C26E3F85E", hash_generated_method = "A065B56F581FE5C11E8D880960B1F5BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String blockingGetAuthToken(Account account, String authTokenType,
            boolean notifyAuthFailure) throws OperationCanceledException, IOException, AuthenticatorException {
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(authTokenType);
        dsTaint.addTaint(notifyAuthFailure);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("authTokenType is null");
        Bundle bundle;
        bundle = getAuthToken(account, authTokenType, notifyAuthFailure, null ,
                null ).getResult();
        String varD30C7FF5A5BB2F8DECAED89037F32604_87601449 = (bundle.getString(KEY_AUTHTOKEN));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.225 -0400", hash_original_method = "DC329BE18D12A187B670EF72046E93F0", hash_generated_method = "C1FA8ED75D19FEB99781EB474C45EAD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccountManagerFuture<Bundle> getAuthToken(
            final Account account, final String authTokenType, final Bundle options,
            final Activity activity, AccountManagerCallback<Bundle> callback, Handler handler) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(authTokenType);
        dsTaint.addTaint(activity.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        dsTaint.addTaint(options.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("authTokenType is null");
        Bundle optionsIn;
        optionsIn = new Bundle();
        {
            optionsIn.putAll(options);
        } //End block
        optionsIn.putString(KEY_ANDROID_PACKAGE_NAME, mContext.getPackageName());
        AccountManagerFuture<Bundle> varA8D0C45A5848BE8C30C5913C8B106DB0_750876377 = (new AmsTask(activity, handler, callback) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.224 -0400", hash_original_method = "DB27CC533E1EBFD8DDE03170C9D7E426", hash_generated_method = "914FB93966B313E8F64C04FDBCE1D8BE")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void doWork() throws RemoteException {
                mService.getAuthToken(mResponse, account, authTokenType,
                        false , true ,
                        optionsIn);
                // ---------- Original Method ----------
                //mService.getAuthToken(mResponse, account, authTokenType,
                        //false , true ,
                        //optionsIn);
            }
}.start());
        return (AccountManagerFuture<Bundle>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.226 -0400", hash_original_method = "63BBFF30BB2AEF86FE403A4E568375F4", hash_generated_method = "B4970641DAF328001E4CB7C73C179593")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public AccountManagerFuture<Bundle> getAuthToken(
            final Account account, final String authTokenType, 
            final boolean notifyAuthFailure,
            AccountManagerCallback<Bundle> callback, Handler handler) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(authTokenType);
        dsTaint.addTaint(notifyAuthFailure);
        dsTaint.addTaint(handler.dsTaint);
        AccountManagerFuture<Bundle> varAAE37EDD98E29C37ED859C979793736F_648080154 = (getAuthToken(account, authTokenType, null, notifyAuthFailure, callback, 
                handler));
        return (AccountManagerFuture<Bundle>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getAuthToken(account, authTokenType, null, notifyAuthFailure, callback, 
                //handler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.238 -0400", hash_original_method = "748DC8BCC0E7F6CE1552DDD9EEAFB074", hash_generated_method = "9A5B4EAA5DBA447F97895A905E878D00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccountManagerFuture<Bundle> getAuthToken(
            final Account account, final String authTokenType, final Bundle options,
            final boolean notifyAuthFailure,
            AccountManagerCallback<Bundle> callback, Handler handler) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(authTokenType);
        dsTaint.addTaint(notifyAuthFailure);
        dsTaint.addTaint(handler.dsTaint);
        dsTaint.addTaint(options.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("authTokenType is null");
        Bundle optionsIn;
        optionsIn = new Bundle();
        {
            optionsIn.putAll(options);
        } //End block
        optionsIn.putString(KEY_ANDROID_PACKAGE_NAME, mContext.getPackageName());
        AccountManagerFuture<Bundle> var853C7578EF1D9CE7331170B53B574E9A_1257613979 = (new AmsTask(null, handler, callback) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.228 -0400", hash_original_method = "4D806FE924DCA4BD633F9FEEB108BD63", hash_generated_method = "22E63FDD6EFBDF9C79B3AB87B647FECC")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void doWork() throws RemoteException {
                mService.getAuthToken(mResponse, account, authTokenType,
                        notifyAuthFailure, false , optionsIn);
                // ---------- Original Method ----------
                //mService.getAuthToken(mResponse, account, authTokenType,
                        //notifyAuthFailure, false , optionsIn);
            }
}.start());
        return (AccountManagerFuture<Bundle>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.245 -0400", hash_original_method = "6ACDAD8A4FE951A7F40DF03A76D4A058", hash_generated_method = "2AFED00F419A403D07BE5416A2D340EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccountManagerFuture<Bundle> addAccount(final String accountType,
            final String authTokenType, final String[] requiredFeatures,
            final Bundle addAccountOptions,
            final Activity activity, AccountManagerCallback<Bundle> callback, Handler handler) {
        dsTaint.addTaint(requiredFeatures[0]);
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(accountType);
        dsTaint.addTaint(authTokenType);
        dsTaint.addTaint(addAccountOptions.dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("accountType is null");
        Bundle optionsIn;
        optionsIn = new Bundle();
        {
            optionsIn.putAll(addAccountOptions);
        } //End block
        optionsIn.putString(KEY_ANDROID_PACKAGE_NAME, mContext.getPackageName());
        AccountManagerFuture<Bundle> var48A8BD9F06D5C2F89CB433E531B425AC_2047756486 = (new AmsTask(activity, handler, callback) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.244 -0400", hash_original_method = "8125D1B63E005C814CD2B9CB30309226", hash_generated_method = "8F2127E03570576B47D9FA13D331F1D9")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void doWork() throws RemoteException {
                mService.addAcount(mResponse, accountType, authTokenType,
                        requiredFeatures, activity != null, optionsIn);
                // ---------- Original Method ----------
                //mService.addAcount(mResponse, accountType, authTokenType,
                        //requiredFeatures, activity != null, optionsIn);
            }
}.start());
        return (AccountManagerFuture<Bundle>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.250 -0400", hash_original_method = "E9F24B896DDD289C3D9D25FA0235DC55", hash_generated_method = "72BB5BFE43399C66FF0D1C616B52CD18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccountManagerFuture<Bundle> confirmCredentials(final Account account,
            final Bundle options,
            final Activity activity,
            final AccountManagerCallback<Bundle> callback,
            final Handler handler) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        dsTaint.addTaint(options.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        AccountManagerFuture<Bundle> var440FB6EB45FEFB5673B710A6D9B6CB05_299328089 = (new AmsTask(activity, handler, callback) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.249 -0400", hash_original_method = "352D9086D40AE796E81956BBA2D0E5D4", hash_generated_method = "3F77048E922E80B6C7C6633D1C3CBAEF")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void doWork() throws RemoteException {
                mService.confirmCredentials(mResponse, account, options, activity != null);
                // ---------- Original Method ----------
                //mService.confirmCredentials(mResponse, account, options, activity != null);
            }
}.start());
        return (AccountManagerFuture<Bundle>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //return new AmsTask(activity, handler, callback) {
            //public void doWork() throws RemoteException {
                //mService.confirmCredentials(mResponse, account, options, activity != null);
            //}
        //}.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.258 -0400", hash_original_method = "D809F6F9BB7D46EEEE0B772ED5C9F6A9", hash_generated_method = "08EE6456A7D8E9A5924296EB902F695C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccountManagerFuture<Bundle> updateCredentials(final Account account,
            final String authTokenType,
            final Bundle options, final Activity activity,
            final AccountManagerCallback<Bundle> callback,
            final Handler handler) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(authTokenType);
        dsTaint.addTaint(activity.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        dsTaint.addTaint(options.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account is null");
        AccountManagerFuture<Bundle> varCABC6DFFB467990812997F3A41301357_1777525079 = (new AmsTask(activity, handler, callback) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.254 -0400", hash_original_method = "6D2F90C4553E4DD12E7AEE5963D4AB1E", hash_generated_method = "5F0AD53448D1D721264F4D7E73A4152F")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void doWork() throws RemoteException {
                mService.updateCredentials(mResponse, account, authTokenType, activity != null,
                        options);
                // ---------- Original Method ----------
                //mService.updateCredentials(mResponse, account, authTokenType, activity != null,
                        //options);
            }
}.start());
        return (AccountManagerFuture<Bundle>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (account == null) throw new IllegalArgumentException("account is null");
        //return new AmsTask(activity, handler, callback) {
            //public void doWork() throws RemoteException {
                //mService.updateCredentials(mResponse, account, authTokenType, activity != null,
                        //options);
            //}
        //}.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.261 -0400", hash_original_method = "72C42C362A18F251D937648B5DDE9096", hash_generated_method = "C51D0CED58273B5C494C674675AF1BE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccountManagerFuture<Bundle> editProperties(final String accountType,
            final Activity activity, final AccountManagerCallback<Bundle> callback,
            final Handler handler) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(accountType);
        dsTaint.addTaint(activity.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("accountType is null");
        AccountManagerFuture<Bundle> varC3483001E79DF97708624AB59D333454_337444369 = (new AmsTask(activity, handler, callback) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.260 -0400", hash_original_method = "04B8B0735D1CA277ED91C00D79F33B2D", hash_generated_method = "1D34C9364A966EE79E020E27C5A65409")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void doWork() throws RemoteException {
                mService.editProperties(mResponse, accountType, activity != null);
                // ---------- Original Method ----------
                //mService.editProperties(mResponse, accountType, activity != null);
            }
}.start());
        return (AccountManagerFuture<Bundle>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (accountType == null) throw new IllegalArgumentException("accountType is null");
        //return new AmsTask(activity, handler, callback) {
            //public void doWork() throws RemoteException {
                //mService.editProperties(mResponse, accountType, activity != null);
            //}
        //}.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.263 -0400", hash_original_method = "05C769BBE692F72E464B52B58848EACE", hash_generated_method = "4241637E31DD0CB6136A698C65A95715")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void ensureNotOnMainThread() {
        Looper looper;
        looper = Looper.myLooper();
        {
            boolean var73759F18EFA09BFA80EBEDB498DD2F75_155302893 = (looper != null && looper == mContext.getMainLooper());
            {
                IllegalStateException exception;
                exception = new IllegalStateException(
                    "calling this from your main thread can lead to deadlock");
                {
                    boolean var231355A96CE7FC42909F1BC96305F121_224462282 = (mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.FROYO);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.278 -0400", hash_original_method = "80D38BDC6E0DE7333CAAD84CC9E6E84A", hash_generated_method = "C9D1E2207E3B5A9FB3E85BE223A6C4E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void postToHandler(Handler handler, final AccountManagerCallback<Bundle> callback,
            final AccountManagerFuture<Bundle> future) {
        dsTaint.addTaint(future.dsTaint);
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        handler = handler == null ? mMainHandler : handler;
        handler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.277 -0400", hash_original_method = "BDBA0E8ABF21CCC323F7A43F04981195", hash_generated_method = "0CA3FE6CFE2D535345F3115B21FF729A")
            //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.284 -0400", hash_original_method = "20F25A89C89C92245636BC8DCFF18BD7", hash_generated_method = "D762C93C6A2245B6C9D5A689DEDAE932")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void postToHandler(Handler handler, final OnAccountsUpdateListener listener,
            final Account[] accounts) {
        dsTaint.addTaint(accounts[0].dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        Account[] accountsCopy;
        accountsCopy = new Account[accounts.length];
        System.arraycopy(accounts, 0, accountsCopy, 0, accountsCopy.length);
        handler = (handler == null) ? mMainHandler : handler;
        handler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.283 -0400", hash_original_method = "8E333205C0A7A1853354D3DAC2CB74E8", hash_generated_method = "75688E2D0FB82048FE4A4B86888BB4BE")
            //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.286 -0400", hash_original_method = "6FDE075EEB86D1BECEDE842FFDA184DE", hash_generated_method = "9DF712037E0E33BEC3066EE8CBE258C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Exception convertErrorToException(int code, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(code);
        {
            Exception var90F41619C2FA8E3B4A1AB072887E6456_173699689 = (new IOException(message));
        } //End block
        {
            Exception varD33CA662B7FC046FDCAA6142D3D798DD_651960167 = (new UnsupportedOperationException(message));
        } //End block
        {
            Exception var87E46DEAA66A5E9E9B76B9BFBA2D1DB6_565293904 = (new AuthenticatorException(message));
        } //End block
        {
            Exception var1AD6F1F82730D1B5E6061EC28BF06A46_221186686 = (new IllegalArgumentException(message));
        } //End block
        Exception varF63573B819A762A6038AF995D9869E55_778140507 = (new AuthenticatorException(message));
        return (Exception)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.289 -0400", hash_original_method = "801F35A66961F670B5EADD181BA66DC7", hash_generated_method = "B132F59C8C5B8F6D56986E9AEBAA68B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccountManagerFuture<Bundle> getAuthTokenByFeatures(
            final String accountType, final String authTokenType, final String[] features,
            final Activity activity, final Bundle addAccountOptions,
            final Bundle getAuthTokenOptions,
            final AccountManagerCallback<Bundle> callback, final Handler handler) {
        dsTaint.addTaint(getAuthTokenOptions.dsTaint);
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(features[0]);
        dsTaint.addTaint(accountType);
        dsTaint.addTaint(authTokenType);
        dsTaint.addTaint(addAccountOptions.dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account type is null");
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("authTokenType is null");
        GetAuthTokenByTypeAndFeaturesTask task;
        task = new GetAuthTokenByTypeAndFeaturesTask(accountType, authTokenType, features,
                activity, addAccountOptions, getAuthTokenOptions, callback, handler);
        task.start();
        return (AccountManagerFuture<Bundle>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.292 -0400", hash_original_method = "7A5668A93C6BCE258395457FB89679A1", hash_generated_method = "A216A503CDCFDAC4F93C19A064624F63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addOnAccountsUpdatedListener(final OnAccountsUpdateListener listener,
            Handler handler, boolean updateImmediately) {
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(updateImmediately);
        dsTaint.addTaint(handler.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the listener is null");
        } //End block
        {
            {
                boolean varABDC43B51A11969F947C4F80A2C4B841_2046394839 = (mAccountsUpdatedListeners.containsKey(listener));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.294 -0400", hash_original_method = "66F9A18B2BBFAE47B027D9D23A795F11", hash_generated_method = "D19AECAE5B11DBEBAEBC7804439D8930")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeOnAccountsUpdatedListener(OnAccountsUpdateListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener is null");
        {
            {
                boolean var1C6325FC6028CC056AEBDA572E73C2D0_446053981 = (!mAccountsUpdatedListeners.containsKey(listener));
            } //End collapsed parenthetic
            mAccountsUpdatedListeners.remove(listener);
            {
                boolean varED431896F12693751A225EDAD100E63A_1703451501 = (mAccountsUpdatedListeners.isEmpty());
                {
                    mContext.unregisterReceiver(mAccountsChangedBroadcastReceiver);
                } //End block
            } //End collapsed parenthetic
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
        IAccountManagerResponse mResponse;
        Handler mHandler;
        AccountManagerCallback<Bundle> mCallback;
        Activity mActivity;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.307 -0400", hash_original_method = "B1B053361B7316D8D8AF57ECEF4696C6", hash_generated_method = "40D2C041C2AE073BB03EC839D8473DBD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AmsTask(Activity activity, Handler handler, AccountManagerCallback<Bundle> callback) {
            super(new Callable<Bundle>() {
                public Bundle call() throws Exception {
                    throw new IllegalStateException("this should never be called");
                }
            });
            dsTaint.addTaint(callback.dsTaint);
            dsTaint.addTaint(activity.dsTaint);
            dsTaint.addTaint(handler.dsTaint);
            mResponse = new Response();
            // ---------- Original Method ----------
            //mHandler = handler;
            //mCallback = callback;
            //mActivity = activity;
            //mResponse = new Response();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.309 -0400", hash_original_method = "E07DE3E7F6D29C4D4BDAC4812A3CF430", hash_generated_method = "E2B1BCCEB121834FB1B93F44ECE6AAA6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final AccountManagerFuture<Bundle> start() {
            try 
            {
                doWork();
            } //End block
            catch (RemoteException e)
            {
                setException(e);
            } //End block
            return (AccountManagerFuture<Bundle>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //try {
                //doWork();
            //} catch (RemoteException e) {
                //setException(e);
            //}
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.312 -0400", hash_original_method = "127E02577FE14DDB30AB934EB38A0588", hash_generated_method = "4D951B980B4D85D6F50C7F5981D7A146")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void set(Bundle bundle) {
            dsTaint.addTaint(bundle.dsTaint);
            super.set(bundle);
            // ---------- Original Method ----------
            //if (bundle == null) {
                //Log.e(TAG, "the bundle must not be null", new Exception());
            //}
            //super.set(bundle);
        }

        
        public abstract void doWork() throws RemoteException;

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.315 -0400", hash_original_method = "6C34E289CBAB2DD26AA2603338539143", hash_generated_method = "36494EE870B7889CAED1E67AAE7FDDE7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Bundle internalGetResult(Long timeout, TimeUnit unit) throws OperationCanceledException, IOException, AuthenticatorException {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(timeout.dsTaint);
            {
                boolean var1D60817A8CAE63E309C47BE23A4C8C61_2018658979 = (!isDone());
                {
                    ensureNotOnMainThread();
                } //End block
            } //End collapsed parenthetic
            try 
            {
                {
                    Bundle var35E82ED6DB49BBBF85CCC534944D90B2_1978267074 = (get());
                } //End block
                {
                    Bundle varCD4CD50EDBFA295A2127B3993133DEE1_898961041 = (get(timeout, unit));
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
            return (Bundle)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.317 -0400", hash_original_method = "7428E8716809F4A01AF7F726F040DE64", hash_generated_method = "6A2C217D99F27440CCD3E4F7459D3E17")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Bundle getResult() throws OperationCanceledException, IOException, AuthenticatorException {
            Bundle varD7ABCAE771F24F33F77D01468FEEC29B_1050175916 = (internalGetResult(null, null));
            return (Bundle)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return internalGetResult(null, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.318 -0400", hash_original_method = "2DB61FA3CF370F8EAC405A022C9CA553", hash_generated_method = "F164009D75E30CE1B69482BB79F5A7D9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Bundle getResult(long timeout, TimeUnit unit) throws OperationCanceledException, IOException, AuthenticatorException {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(timeout);
            Bundle varBF1F003A106665023C8F37C53E818BC4_101759131 = (internalGetResult(timeout, unit));
            return (Bundle)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return internalGetResult(timeout, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.319 -0400", hash_original_method = "3B9C9BC58CC1D6BA66EF9DB56725570D", hash_generated_method = "CAE741A2E9EFBA1FF7C26834B6AEF1FE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.320 -0400", hash_original_method = "E498986020958DA933F7960D1DABA72A", hash_generated_method = "E498986020958DA933F7960D1DABA72A")
                        public Response ()
            {
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.322 -0400", hash_original_method = "BC11F9A6ED106794CC5C9152E9BD3B43", hash_generated_method = "3A24D0D9BB2152C8E9EFB3EE4B34EB25")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onResult(Bundle bundle) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(bundle.dsTaint);
                Intent intent;
                intent = bundle.getParcelable(KEY_INTENT);
                {
                    mActivity.startActivity(intent);
                } //End block
                {
                    boolean var80E32410CA7CB1AFA3ABADA4FB788EDD_1074789196 = (bundle.getBoolean("retry"));
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.323 -0400", hash_original_method = "DD61FDBEB518045420249589A7AE75D2", hash_generated_method = "E1564EC735C6591A307609487AECF273")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onError(int code, String message) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(message);
                dsTaint.addTaint(code);
                {
                    cancel(true );
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
        public IAccountManagerResponse mResponse;
        Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.324 -0400", hash_original_method = "26CFE7EFCBFE85C3047A425A4F720F86", hash_generated_method = "C99A1D9298241251EF55D136B34423F5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public BaseFutureTask(Handler handler) {
            super(new Callable<T>() {
                public T call() throws Exception {
                    throw new IllegalStateException("this should never be called");
                }
            });
            dsTaint.addTaint(handler.dsTaint);
            mResponse = new Response();
            // ---------- Original Method ----------
            //mHandler = handler;
            //mResponse = new Response();
        }

        
        public abstract void doWork() throws RemoteException;

        
        public abstract T bundleToResult(Bundle bundle) throws AuthenticatorException;

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.331 -0400", hash_original_method = "B01C5697E6FB95B4A78D57A4C431F13F", hash_generated_method = "B495EF33ED72EBE5926517B242A95EA7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void postRunnableToHandler(Runnable runnable) {
            dsTaint.addTaint(runnable.dsTaint);
            Handler handler;
            handler = mMainHandler;
            handler = mHandler;
            handler.post(runnable);
            // ---------- Original Method ----------
            //Handler handler = (mHandler == null) ? mMainHandler : mHandler;
            //handler.post(runnable);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.332 -0400", hash_original_method = "030130E13746E076BBD203E6D46CECFF", hash_generated_method = "255E12B7B835ACF16F252F3ADA55C2A0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.334 -0400", hash_original_method = "E498986020958DA933F7960D1DABA72A", hash_generated_method = "E498986020958DA933F7960D1DABA72A")
                        public Response ()
            {
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.335 -0400", hash_original_method = "B8AEC5DE9AFE3040461BEFA9E791EE34", hash_generated_method = "14E059A6759A169E1E5E15E4E98383BD")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onResult(Bundle bundle) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(bundle.dsTaint);
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.337 -0400", hash_original_method = "DD61FDBEB518045420249589A7AE75D2", hash_generated_method = "E1564EC735C6591A307609487AECF273")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onError(int code, String message) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(message);
                dsTaint.addTaint(code);
                {
                    cancel(true );
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
        AccountManagerCallback<T> mCallback;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.338 -0400", hash_original_method = "FC1DD61776F9D5FC9C321068652B66F1", hash_generated_method = "7A309C0D35093EEBB9BE5DA5935404DF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Future2Task(Handler handler, AccountManagerCallback<T> callback) {
            super(handler);
            dsTaint.addTaint(callback.dsTaint);
            dsTaint.addTaint(handler.dsTaint);
            // ---------- Original Method ----------
            //mCallback = callback;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.347 -0400", hash_original_method = "762C0B9FE5A1A00B697BA32E9AEAF22E", hash_generated_method = "034532DB65258B29951872F7BDE50DC8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void done() {
            {
                postRunnableToHandler(new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.347 -0400", hash_original_method = "0F70B80A50B592CBF5F504B35808D596", hash_generated_method = "7101081B29B4523A9AECBBD0EF73571E")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.348 -0400", hash_original_method = "31A85EDC6833090D765F6613E9274CD1", hash_generated_method = "AB9F63369383D48A4E3FB64A22A736E3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Future2Task<T> start() {
            startTask();
            return (Future2Task<T>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //startTask();
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.350 -0400", hash_original_method = "41F0112BBEC6735226A2F41FF2202D7E", hash_generated_method = "F826790F4E1DB6029F5D77C406940FFB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private T internalGetResult(Long timeout, TimeUnit unit) throws OperationCanceledException, IOException, AuthenticatorException {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(timeout.dsTaint);
            {
                boolean var1D60817A8CAE63E309C47BE23A4C8C61_2081293547 = (!isDone());
                {
                    ensureNotOnMainThread();
                } //End block
            } //End collapsed parenthetic
            try 
            {
                {
                    T var35E82ED6DB49BBBF85CCC534944D90B2_1406124161 = (get());
                } //End block
                {
                    T varCD4CD50EDBFA295A2127B3993133DEE1_1622510276 = (get(timeout, unit));
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
            return (T)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.352 -0400", hash_original_method = "F09B519E265A8A66FE763E800742348B", hash_generated_method = "BCA2D250F4DA651CB1DE13DE19C6E05C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public T getResult() throws OperationCanceledException, IOException, AuthenticatorException {
            T varD7ABCAE771F24F33F77D01468FEEC29B_1801650695 = (internalGetResult(null, null));
            return (T)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return internalGetResult(null, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.354 -0400", hash_original_method = "50CBD7888960B26C4BF28EA57E206BB1", hash_generated_method = "30D26CF09B5D35A796B6D9D4E5BCB2FF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public T getResult(long timeout, TimeUnit unit) throws OperationCanceledException, IOException, AuthenticatorException {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(timeout);
            T varBF1F003A106665023C8F37C53E818BC4_2131244803 = (internalGetResult(timeout, unit));
            return (T)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return internalGetResult(timeout, unit);
        }

        
    }


    
    private class GetAuthTokenByTypeAndFeaturesTask extends AmsTask implements AccountManagerCallback<Bundle> {
        volatile AccountManagerFuture<Bundle> mFuture = null;
        String mAccountType;
        String mAuthTokenType;
        String[] mFeatures;
        Bundle mAddAccountOptions;
        Bundle mLoginOptions;
        AccountManagerCallback<Bundle> mMyCallback;
        private volatile int mNumAccounts = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.363 -0400", hash_original_method = "8B428F75DFA4C0F7DC2037249CE783CE", hash_generated_method = "5474B3E5A33F41038628F8C6B099400C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         GetAuthTokenByTypeAndFeaturesTask(final String accountType, final String authTokenType,
                final String[] features, Activity activityForPrompting,
                final Bundle addAccountOptions, final Bundle loginOptions,
                AccountManagerCallback<Bundle> callback, Handler handler) {
            super(activityForPrompting, handler, callback);
            dsTaint.addTaint(loginOptions.dsTaint);
            dsTaint.addTaint(callback.dsTaint);
            dsTaint.addTaint(features[0]);
            dsTaint.addTaint(accountType);
            dsTaint.addTaint(authTokenType);
            dsTaint.addTaint(activityForPrompting.dsTaint);
            dsTaint.addTaint(addAccountOptions.dsTaint);
            dsTaint.addTaint(handler.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account type is null");
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.375 -0400", hash_original_method = "C4C5F207D191035A436136641EA5FDB4", hash_generated_method = "B376561A1CD03E52995984F22D086691")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void doWork() throws RemoteException {
            getAccountsByTypeAndFeatures(mAccountType, mFeatures,
                    new AccountManagerCallback<Account[]>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.368 -0400", hash_original_method = "A16608B5927D0AB580BEC16F01D5E6C5", hash_generated_method = "544E86207FBFD5D99ECC3294C26A0A6D")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void run(AccountManagerFuture<Account[]> future) {
                    dsTaint.addTaint(future.dsTaint);
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
                    // ---------- Original Method ----------
                    // Original Method Too Long, Refer to Original Implementation
                }
}, mHandler);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.390 -0400", hash_original_method = "770A26A7F965A1883CF21DF75B7155CF", hash_generated_method = "F09200C2344F0F0D90C79E595B2DE692")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run(AccountManagerFuture<Bundle> future) {
            dsTaint.addTaint(future.dsTaint);
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
                        boolean var82B2475C7FDB438FF43C0F4978E62379_665693908 = (TextUtils.isEmpty(accountName) || TextUtils.isEmpty(accountType));
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
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static final String TAG = "AccountManager";
    public static final int ERROR_CODE_REMOTE_EXCEPTION = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 3;
    public static final int ERROR_CODE_CANCELED = 4;
    public static final int ERROR_CODE_INVALID_RESPONSE = 5;
    public static final int ERROR_CODE_UNSUPPORTED_OPERATION = 6;
    public static final int ERROR_CODE_BAD_ARGUMENTS = 7;
    public static final int ERROR_CODE_BAD_REQUEST = 8;
    public static final String KEY_ACCOUNT_NAME = "authAccount";
    public static final String KEY_ACCOUNT_TYPE = "accountType";
    public static final String KEY_AUTHTOKEN = "authtoken";
    public static final String KEY_INTENT = "intent";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_ACCOUNTS = "accounts";
    public static final String KEY_ACCOUNT_AUTHENTICATOR_RESPONSE = "accountAuthenticatorResponse";
    public static final String KEY_ACCOUNT_MANAGER_RESPONSE = "accountManagerResponse";
    public static final String KEY_AUTHENTICATOR_TYPES = "authenticator_types";
    public static final String KEY_AUTH_FAILED_MESSAGE = "authFailedMessage";
    public static final String KEY_AUTH_TOKEN_LABEL = "authTokenLabelKey";
    public static final String KEY_BOOLEAN_RESULT = "booleanResult";
    public static final String KEY_ERROR_CODE = "errorCode";
    public static final String KEY_ERROR_MESSAGE = "errorMessage";
    public static final String KEY_USERDATA = "userdata";
    public static final String KEY_CALLER_UID = "callerUid";
    public static final String KEY_CALLER_PID = "callerPid";
    public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
    public static final String KEY_NOTIFY_ON_FAILURE = "notifyOnAuthFailure";
    public static final String ACTION_AUTHENTICATOR_INTENT =
            "android.accounts.AccountAuthenticator";
    public static final String AUTHENTICATOR_META_DATA_NAME =
            "android.accounts.AccountAuthenticator";
    public static final String AUTHENTICATOR_ATTRIBUTES_NAME = "account-authenticator";
    public static final String LOGIN_ACCOUNTS_CHANGED_ACTION =
        "android.accounts.LOGIN_ACCOUNTS_CHANGED";
}

