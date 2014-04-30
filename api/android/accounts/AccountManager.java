package android.accounts;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
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

    /**
     * @hide for internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.971 -0500", hash_original_method = "F888113D3DF006EA49FF73334C06BE1E", hash_generated_method = "B3E3A4DBE45ECE90EEB5DB065EDB493F")
    
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

    /**
     * Gets an AccountManager instance associated with a Context.
     * The {@link Context} will be used as long as the AccountManager is
     * active, so make sure to use a {@link Context} whose lifetime is
     * commensurate with any listeners registered to
     * {@link #addOnAccountsUpdatedListener} or similar methods.
     *
     * <p>It is safe to call this method from the main thread.
     *
     * <p>No permission is required to call this method.
     *
     * @param context The {@link Context} to use when necessary
     * @return An {@link AccountManager} instance
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.ACCOUNT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.973 -0500", hash_original_method = "5160F1A7A4EC859C57D4D0FFF150F671", hash_generated_method = "5EF3D5664AA350D0DC486554FEE23BDB")
    
public static AccountManager get(Context context) {
        if (context == null) throw new IllegalArgumentException("context is null");
        return (AccountManager) context.getSystemService(Context.ACCOUNT_SERVICE);
    }

    /**
     * Returns an intent to an {@link Activity} that prompts the user to choose from a list of
     * accounts.
     * The caller will then typically start the activity by calling
     * <code>startActivityWithResult(intent, ...);</code>.
     * <p>
     * On success the activity returns a Bundle with the account name and type specified using
     * keys {@link #KEY_ACCOUNT_NAME} and {@link #KEY_ACCOUNT_TYPE}.
     * <p>
     * The most common case is to call this with one account type, e.g.:
     * <p>
     * <pre>  newChooseAccountsIntent(null, null, new String[]{"com.google"}, false, null,
     * null, null, null);</pre>
     * @param selectedAccount if specified, indicates that the {@link Account} is the currently
     * selected one, according to the caller's definition of selected.
     * @param allowableAccounts an optional {@link ArrayList} of accounts that are allowed to be
     * shown. If not specified then this field will not limit the displayed accounts.
     * @param allowableAccountTypes an optional string array of account types. These are used
     * both to filter the shown accounts and to filter the list of account types that are shown
     * when adding an account.
     * @param alwaysPromptForAccount if set the account chooser screen is always shown, otherwise
     * it is only shown when there is more than one account from which to choose
     * @param descriptionOverrideText if non-null this string is used as the description in the
     * accounts chooser screen rather than the default
     * @param addAccountAuthTokenType this string is passed as the {@link #addAccount}
     * authTokenType parameter
     * @param addAccountRequiredFeatures this string array is passed as the {@link #addAccount}
     * requiredFeatures parameter
     * @param addAccountOptions This {@link Bundle} is passed as the {@link #addAccount} options
     * parameter
     * @return an {@link Intent} that can be used to launch the ChooseAccount activity flow.
     */
    @DSSink({DSSinkKind.ACCOUNT_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.257 -0500", hash_original_method = "8106C3BE6C75982E692D742A84DC4CF5", hash_generated_method = "BAB723D4B0B362AA257356D33B802776")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.878 -0500", hash_original_field = "2551A9EED4AFC4DB7A7E20A21CCF5516", hash_generated_field = "011994D593F4EA76C280FB7FCC436706")

    private static final String TAG = "AccountManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.881 -0500", hash_original_field = "D0D59A7AFBDB1F965C9519675B93E3CF", hash_generated_field = "839EE2AD959F91D7F8A30C4DF896A0A9")

    public static final int ERROR_CODE_REMOTE_EXCEPTION = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.883 -0500", hash_original_field = "AA737B716F124CE97EA182DE75F3738F", hash_generated_field = "28836EE16DABE4CC8F98413027A9030B")

    public static final int ERROR_CODE_NETWORK_ERROR = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.886 -0500", hash_original_field = "884923CFE9CA885B7210EB9279F5CE50", hash_generated_field = "E9001C9A5A6B658887C8978E4189FD52")

    public static final int ERROR_CODE_CANCELED = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.889 -0500", hash_original_field = "A3E7FF4CE25E8B43568B8E85505A9671", hash_generated_field = "215CD378075E4729EC91AA3C099AEFED")

    public static final int ERROR_CODE_INVALID_RESPONSE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.891 -0500", hash_original_field = "FC401022A5DDBE76AC23981DB8464226", hash_generated_field = "0BA889018A83A6B2347976FA0C25E335")

    public static final int ERROR_CODE_UNSUPPORTED_OPERATION = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.894 -0500", hash_original_field = "DF99DCDCA0E2CCBB02CE88852C0A825E", hash_generated_field = "3B28C1EA1CA857E1ECC16D27FCB2B421")

    public static final int ERROR_CODE_BAD_ARGUMENTS = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.896 -0500", hash_original_field = "710EB42A3C855A651F39C8B0D1C90887", hash_generated_field = "12AE862392583AD965A36301576778CD")

    public static final int ERROR_CODE_BAD_REQUEST = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.899 -0500", hash_original_field = "EFF6C03B9352F6ED649EEAA3316BCB0D", hash_generated_field = "F859CD3519729A82BCD23BCE5084C439")

    public static final String KEY_ACCOUNT_NAME = "authAccount";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.901 -0500", hash_original_field = "7FA0FC5BC6EFAF210273A2BC6786A670", hash_generated_field = "01FDA1F42087656DFED808AC20B15C21")

    public static final String KEY_ACCOUNT_TYPE = "accountType";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.905 -0500", hash_original_field = "01D195418E3300775311A2262868CE0D", hash_generated_field = "3A382E093156E682D8C89BEB9C2CF37B")

    public static final String KEY_AUTHTOKEN = "authtoken";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.907 -0500", hash_original_field = "BE29B56C524FD8B4F067E3ADD78CB2FF", hash_generated_field = "DD3EB87933A482E342BDBCADB6FCD849")

    public static final String KEY_INTENT = "intent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.910 -0500", hash_original_field = "1912076E802C9C31476D766AB9B794FA", hash_generated_field = "B6E4CF7265B3037CDACBE69F87D1F211")

    public static final String KEY_PASSWORD = "password";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.912 -0500", hash_original_field = "118D55C478CC5432ABEB40A1DAB155D5", hash_generated_field = "48376F363D9C8E28672349E76C9AB9D6")

    public static final String KEY_ACCOUNTS = "accounts";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.915 -0500", hash_original_field = "B2A4953447EB6A8BE6F40E723830CAA9", hash_generated_field = "B6500903448CA38B1C135E7FAACA8E59")

    public static final String KEY_ACCOUNT_AUTHENTICATOR_RESPONSE = "accountAuthenticatorResponse";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.918 -0500", hash_original_field = "82E3FFC4F1A3C550AD57D2E4CEFE16A7", hash_generated_field = "6787B86CE20B7D25DB80F65A6DF78575")

    public static final String KEY_ACCOUNT_MANAGER_RESPONSE = "accountManagerResponse";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.920 -0500", hash_original_field = "3ADE0968885F2B69F714587571C2EBFA", hash_generated_field = "A880DA3011386B62681F12DCA6F995AF")

    public static final String KEY_AUTHENTICATOR_TYPES = "authenticator_types";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.922 -0500", hash_original_field = "08334C2698FE204AF6B81CC611A4DBBA", hash_generated_field = "E3A6E02E13FC436339BAE96EF05B9915")

    public static final String KEY_AUTH_FAILED_MESSAGE = "authFailedMessage";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.925 -0500", hash_original_field = "E37E5ECAD0D64D7ED1A5CEF66DE47EAF", hash_generated_field = "6A52A1128A766E523E11400904962290")

    public static final String KEY_AUTH_TOKEN_LABEL = "authTokenLabelKey";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.927 -0500", hash_original_field = "B51DD36D5E260AACD54FF2DE312E527D", hash_generated_field = "0966148F1C7D6F1B380611DBCB3F9034")

    public static final String KEY_BOOLEAN_RESULT = "booleanResult";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.930 -0500", hash_original_field = "1CF502F8D50764F6B13A55576D6CDFFA", hash_generated_field = "5C41C2089C3858E1102D472FE91ABBF6")

    public static final String KEY_ERROR_CODE = "errorCode";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.933 -0500", hash_original_field = "ADA3EC44AC6E597F649FE6254D2E789B", hash_generated_field = "6F255AB3CB507FA25E18B20330ACC508")

    public static final String KEY_ERROR_MESSAGE = "errorMessage";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.935 -0500", hash_original_field = "E9A4AAE118D7BB95C318CA13DDDD555F", hash_generated_field = "41604824FAA4E2183B26678B9BA94C58")

    public static final String KEY_USERDATA = "userdata";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.938 -0500", hash_original_field = "A3A647AD7521C8D42BF47A6D3AA88A59", hash_generated_field = "C963ED8E4968C78870BB72394D89E0BF")

    public static final String KEY_CALLER_UID = "callerUid";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.940 -0500", hash_original_field = "55A411E770665B1EB4CCBC2E84E23565", hash_generated_field = "597D7766913E4C39E55EDE8137AC8EF2")

    public static final String KEY_CALLER_PID = "callerPid";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.944 -0500", hash_original_field = "41AEA02ECD85A934BE39FCB182815AF4", hash_generated_field = "DDEECC7543FA2BF07514362519C946F4")

    public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.946 -0500", hash_original_field = "F9F02A0F8B553AA8CD71E53F99B100AF", hash_generated_field = "CBB4031BA4A54F6632AC99B12AF54139")

    public static final String KEY_NOTIFY_ON_FAILURE = "notifyOnAuthFailure";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.949 -0500", hash_original_field = "8544C1E28E24976FB062BD804ABC83D7", hash_generated_field = "7CF12A75D3DE0CB88FEDEEC45F4C6998")

    public static final String ACTION_AUTHENTICATOR_INTENT =
            "android.accounts.AccountAuthenticator";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.951 -0500", hash_original_field = "C01C2A817D5D6732C027E2696F342880", hash_generated_field = "38C40DD9584F5E25D4E08184425EF38E")

    public static final String AUTHENTICATOR_META_DATA_NAME =
            "android.accounts.AccountAuthenticator";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.954 -0500", hash_original_field = "314037DEFD7C2016E3B7B7D5633C6393", hash_generated_field = "A69C2C428C8648CBB8DC6F428CBCC207")

    public static final String AUTHENTICATOR_ATTRIBUTES_NAME = "account-authenticator";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.963 -0500", hash_original_field = "A898A14B43D894B160BDF4779E4C2100", hash_generated_field = "5DE28EA7EC32E4A054DAAC679C704B36")

    public static final String LOGIN_ACCOUNTS_CHANGED_ACTION =
        "android.accounts.LOGIN_ACCOUNTS_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.956 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.958 -0500", hash_original_field = "41CD1B8397AB313E493085F486A2475D", hash_generated_field = "5EECF8903744EA4C4535FC399DE7EDD3")

    private  IAccountManager mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.961 -0500", hash_original_field = "028D008EEBDEF4402B8F64158F6B8728", hash_generated_field = "36D62901B5F66AD7425C1042CCC68DC2")

    private  Handler mMainHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.259 -0500", hash_original_field = "A97C603C6192DBB01430A77ACF905E46", hash_generated_field = "E06E5EFE2F853C682425BCF2C68C9174")

    private final HashMap<OnAccountsUpdateListener, Handler> mAccountsUpdatedListeners =
            Maps.newHashMap();
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.810 -0400", hash_original_method = "399D8365074F8431C3C32ED7720975E8", hash_generated_method = "699A204D5899DBCF695891C3392F1F59")
    public  AccountManager(Context context, IAccountManager service) {
        mContext = context;
        mService = service;
        mMainHandler = new Handler(mContext.getMainLooper());
        addTaint(context.getTaint());
        addTaint(service.getTaint());
        // ---------- Original Method ----------
        //mContext = context;
        //mService = service;
        //mMainHandler = new Handler(mContext.getMainLooper());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.814 -0400", hash_original_method = "25BBC3E1043ACDD515139061A9597BA7", hash_generated_method = "34C7F2EB81FAF854CED2B6C04922B77F")
    public  AccountManager(Context context, IAccountManager service, Handler handler) {
        mContext = context;
        mService = service;
        mMainHandler = handler;
        addTaint(context.getTaint());
        addTaint(service.getTaint());
        addTaint(handler.getTaint());
        // ---------- Original Method ----------
        //mContext = context;
        //mService = service;
        //mMainHandler = handler;
    }
    
    private abstract class AmsTask extends FutureTask<Bundle> implements AccountManagerFuture<Bundle> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.101 -0500", hash_original_field = "BCCFC11938EEC7DE34A0DE82C0A04729", hash_generated_field = "BCCFC11938EEC7DE34A0DE82C0A04729")

         IAccountManagerResponse mResponse;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.103 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "A163099B522120C606A3CA562F90E927")

         Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.105 -0500", hash_original_field = "382974AD998518E9037A5E4EDC0E3105", hash_generated_field = "382974AD998518E9037A5E4EDC0E3105")

         AccountManagerCallback<Bundle> mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.108 -0500", hash_original_field = "3895D7E6DB5042DA7856DC78E391C7B9", hash_generated_field = "3895D7E6DB5042DA7856DC78E391C7B9")

         Activity mActivity;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.115 -0500", hash_original_method = "B1B053361B7316D8D8AF57ECEF4696C6", hash_generated_method = "D3F9634578D9A1D06C549591FAC325A2")
        
public AmsTask(Activity activity, Handler handler, AccountManagerCallback<Bundle> callback) {
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.117 -0500", hash_original_method = "E07DE3E7F6D29C4D4BDAC4812A3CF430", hash_generated_method = "920E5F18578729F244F551A940BC7E44")
        
public final AccountManagerFuture<Bundle> start() {
            try {
                doWork();
            } catch (RemoteException e) {
                setException(e);
            }
            return this;
        }

        @DSSink({DSSinkKind.ACCOUNT_SETTINGS})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.120 -0500", hash_original_method = "127E02577FE14DDB30AB934EB38A0588", hash_generated_method = "4BC6487A229BD836DB45687EBF9E02A9")
        
protected void set(Bundle bundle) {
            // TODO: somehow a null is being set as the result of the Future. Log this
            // case to help debug where this is occurring. When this bug is fixed this
            // condition statement should be removed.
            if (bundle == null) {
                Log.e(TAG, "the bundle must not be null", new Exception());
            }
            super.set(bundle);
        }

        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.123 -0500", hash_original_method = "E172AC54BDA548AF6DAEF4A168CC4707", hash_generated_method = "84F2E7A49346DDBB2054F34A8AF373BF")
        
public abstract void doWork() throws RemoteException;

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.126 -0500", hash_original_method = "6C34E289CBAB2DD26AA2603338539143", hash_generated_method = "DDD1772D3E9759F0EF2ED2D8151322AC")
        
private Bundle internalGetResult(Long timeout, TimeUnit unit)
                throws OperationCanceledException, IOException, AuthenticatorException {
            if (!isDone()) {
                ensureNotOnMainThread();
            }
            try {
                if (timeout == null) {
                    return get();
                } else {
                    return get(timeout, unit);
                }
            } catch (CancellationException e) {
                throw new OperationCanceledException();
            } catch (TimeoutException e) {
                // fall through and cancel
            } catch (InterruptedException e) {
                // fall through and cancel
            } catch (ExecutionException e) {
                final Throwable cause = e.getCause();
                if (cause instanceof IOException) {
                    throw (IOException) cause;
                } else if (cause instanceof UnsupportedOperationException) {
                    throw new AuthenticatorException(cause);
                } else if (cause instanceof AuthenticatorException) {
                    throw (AuthenticatorException) cause;
                } else if (cause instanceof RuntimeException) {
                    throw (RuntimeException) cause;
                } else if (cause instanceof Error) {
                    throw (Error) cause;
                } else {
                    throw new IllegalStateException(cause);
                }
            } finally {
                cancel(true /* interrupt if running */);
            }
            throw new OperationCanceledException();
        }

        @DSSource({DSSourceKind.ACCOUNT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.129 -0500", hash_original_method = "7428E8716809F4A01AF7F726F040DE64", hash_generated_method = "00F9263FEFCB2E71541C4C0C76EA7412")
        
public Bundle getResult()
                throws OperationCanceledException, IOException, AuthenticatorException {
            return internalGetResult(null, null);
        }

        @DSSource({DSSourceKind.ACCOUNT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.132 -0500", hash_original_method = "2DB61FA3CF370F8EAC405A022C9CA553", hash_generated_method = "9D7E637B2597AAA6B0B651988F82E2BB")
        
public Bundle getResult(long timeout, TimeUnit unit)
                throws OperationCanceledException, IOException, AuthenticatorException {
            return internalGetResult(timeout, unit);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.134 -0500", hash_original_method = "3B9C9BC58CC1D6BA66EF9DB56725570D", hash_generated_method = "BFB06F3537CB087B532440F69518A89B")
        
protected void done() {
            if (mCallback != null) {
                postToHandler(mHandler, mCallback, this);
            }
        }
        
        private class Response extends IAccountManagerResponse.Stub {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.129 -0400", hash_original_method = "1C91C9705FD3BE3D2A4F4357891D41FD", hash_generated_method = "1C91C9705FD3BE3D2A4F4357891D41FD")
            public Response ()
            {
                //Synthesized constructor
            }
            @DSSink({DSSinkKind.ACCOUNT_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.138 -0500", hash_original_method = "BC11F9A6ED106794CC5C9152E9BD3B43", hash_generated_method = "3F87B4BC1804003A7DAC7BA8131AFE99")
            
public void onResult(Bundle bundle) {
                Intent intent = bundle.getParcelable(KEY_INTENT);
                if (intent != null && mActivity != null) {
                    // since the user provided an Activity we will silently start intents
                    // that we see
                    mActivity.startActivity(intent);
                    // leave the Future running to wait for the real response to this request
                } else if (bundle.getBoolean("retry")) {
                    try {
                        doWork();
                    } catch (RemoteException e) {
                        // this will only happen if the system process is dead, which means
                        // we will be dying ourselves
                    }
                } else {
                    set(bundle);
                }
            }

            @DSSink({DSSinkKind.ACCOUNT_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.173 -0500", hash_original_method = "DD61FDBEB518045420249589A7AE75D2", hash_generated_method = "E9A25AD74E531D0CA5E7898168BA1F21")
            
public void onError(int code, String message) {
                if (code == ERROR_CODE_CANCELED) {
                    cancel(true /* mayInterruptIfRunning */);
                    return;
                }
                setException(convertErrorToException(code, message));
            }
            
        }
        
    }
    
    private abstract class BaseFutureTask<T> extends FutureTask<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.148 -0500", hash_original_field = "BCCFC11938EEC7DE34A0DE82C0A04729", hash_generated_field = "A54F64CAD983BA5040DC733186B2FF3B")

         public IAccountManagerResponse mResponse;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.150 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "A163099B522120C606A3CA562F90E927")

         Handler mHandler;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.157 -0500", hash_original_method = "26CFE7EFCBFE85C3047A425A4F720F86", hash_generated_method = "97C1A6A5D268F23A7F2832D180811246")
        
public BaseFutureTask(Handler handler) {
            super(new Callable<T>() {
                public T call() throws Exception {
                    throw new IllegalStateException("this should never be called");
                }
            });
            mHandler = handler;
            mResponse = new Response();
        }

        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.160 -0500", hash_original_method = "E172AC54BDA548AF6DAEF4A168CC4707", hash_generated_method = "84F2E7A49346DDBB2054F34A8AF373BF")
        
public abstract void doWork() throws RemoteException;

        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.162 -0500", hash_original_method = "B16E0611AA9ED6C18764DFE7CA12071D", hash_generated_method = "90D20EACEA319C48DC12C539CF65F27B")
        
public abstract T bundleToResult(Bundle bundle) throws AuthenticatorException;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.165 -0500", hash_original_method = "B01C5697E6FB95B4A78D57A4C431F13F", hash_generated_method = "35A1D19D1320A4FEF16D6440EB19C749")
        
protected void postRunnableToHandler(Runnable runnable) {
            Handler handler = (mHandler == null) ? mMainHandler : mHandler;
            handler.post(runnable);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.167 -0500", hash_original_method = "030130E13746E076BBD203E6D46CECFF", hash_generated_method = "CE63BDF795AFCD5FD813F1CD9CB6EAE0")
        
protected void startTask() {
            try {
                doWork();
            } catch (RemoteException e) {
                setException(e);
            }
        }
        
        protected class Response extends IAccountManagerResponse.Stub {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.170 -0400", hash_original_method = "1C91C9705FD3BE3D2A4F4357891D41FD", hash_generated_method = "1C91C9705FD3BE3D2A4F4357891D41FD")
            public Response ()
            {
                //Synthesized constructor
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.171 -0500", hash_original_method = "B8AEC5DE9AFE3040461BEFA9E791EE34", hash_generated_method = "51996DB584D72AA7DA964142316806B5")
            
public void onResult(Bundle bundle) {
                try {
                    T result = bundleToResult(bundle);
                    if (result == null) {
                        return;
                    }
                    set(result);
                    return;
                } catch (ClassCastException e) {
                    // we will set the exception below
                } catch (AuthenticatorException e) {
                    // we will set the exception below
                }
                onError(ERROR_CODE_INVALID_RESPONSE, "no result in response");
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.180 -0500", hash_original_field = "719E4FBEE0E6D8BC8E61E553D79747F3", hash_generated_field = "719E4FBEE0E6D8BC8E61E553D79747F3")

         AccountManagerCallback<T> mCallback;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.182 -0500", hash_original_method = "FC1DD61776F9D5FC9C321068652B66F1", hash_generated_method = "8184112D75CA5479DB5EB0D06C531140")
        
public Future2Task(Handler handler, AccountManagerCallback<T> callback) {
            super(handler);
            mCallback = callback;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.189 -0500", hash_original_method = "762C0B9FE5A1A00B697BA32E9AEAF22E", hash_generated_method = "CC61DCE0CA778D73894F80744B6264E9")
        
protected void done() {
            if (mCallback != null) {
                postRunnableToHandler(new Runnable() {
                    public void run() {
                        mCallback.run(Future2Task.this);
                    }
                });
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.191 -0500", hash_original_method = "31A85EDC6833090D765F6613E9274CD1", hash_generated_method = "7D9A6A6A9F04A41A6BD46ED77E3F5619")
        
public Future2Task<T> start() {
            startTask();
            return this;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.194 -0500", hash_original_method = "41F0112BBEC6735226A2F41FF2202D7E", hash_generated_method = "0239A56840CD6C80C452C472F8299284")
        
private T internalGetResult(Long timeout, TimeUnit unit)
                throws OperationCanceledException, IOException, AuthenticatorException {
            if (!isDone()) {
                ensureNotOnMainThread();
            }
            try {
                if (timeout == null) {
                    return get();
                } else {
                    return get(timeout, unit);
                }
            } catch (InterruptedException e) {
                // fall through and cancel
            } catch (TimeoutException e) {
                // fall through and cancel
            } catch (CancellationException e) {
                // fall through and cancel
            } catch (ExecutionException e) {
                final Throwable cause = e.getCause();
                if (cause instanceof IOException) {
                    throw (IOException) cause;
                } else if (cause instanceof UnsupportedOperationException) {
                    throw new AuthenticatorException(cause);
                } else if (cause instanceof AuthenticatorException) {
                    throw (AuthenticatorException) cause;
                } else if (cause instanceof RuntimeException) {
                    throw (RuntimeException) cause;
                } else if (cause instanceof Error) {
                    throw (Error) cause;
                } else {
                    throw new IllegalStateException(cause);
                }
            } finally {
                cancel(true /* interrupt if running */);
            }
            throw new OperationCanceledException();
        }

        @DSSource({DSSourceKind.ACCOUNT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.197 -0500", hash_original_method = "F09B519E265A8A66FE763E800742348B", hash_generated_method = "9EBD0039162A8275DDAC5AE2D3DEF838")
        
public T getResult()
                throws OperationCanceledException, IOException, AuthenticatorException {
            return internalGetResult(null, null);
        }

        @DSSource({DSSourceKind.ACCOUNT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.200 -0500", hash_original_method = "50CBD7888960B26C4BF28EA57E206BB1", hash_generated_method = "02AF5BFF6F8E1D6BEF4E55776C8ECD52")
        
public T getResult(long timeout, TimeUnit unit)
                throws OperationCanceledException, IOException, AuthenticatorException {
            return internalGetResult(timeout, unit);
        }
        
    }
    
    private class GetAuthTokenByTypeAndFeaturesTask extends AmsTask implements AccountManagerCallback<Bundle> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.209 -0500", hash_original_field = "787F270AB101B859863E4A8AC2ACCBAB", hash_generated_field = "DA7FCA7FD25B2715DDA5B1151A329B57")

        volatile AccountManagerFuture<Bundle> mFuture = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.212 -0500", hash_original_field = "1BAC3F5B48D7CBDC0DEC096887906F9A", hash_generated_field = "1BAC3F5B48D7CBDC0DEC096887906F9A")

         String mAccountType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.214 -0500", hash_original_field = "62E235D18D61381B167C250C0385DCF5", hash_generated_field = "62E235D18D61381B167C250C0385DCF5")

         String mAuthTokenType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.218 -0500", hash_original_field = "BB73EBD9036EEEC92FAB5A91A39B5A6F", hash_generated_field = "BB73EBD9036EEEC92FAB5A91A39B5A6F")

         String[] mFeatures;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.220 -0500", hash_original_field = "7B6AE567E0F7C37B83B94413E80422D3", hash_generated_field = "7B6AE567E0F7C37B83B94413E80422D3")

         Bundle mAddAccountOptions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.222 -0500", hash_original_field = "4B7678D538696871E7C4A9E9A154E69B", hash_generated_field = "4B7678D538696871E7C4A9E9A154E69B")

         Bundle mLoginOptions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.225 -0500", hash_original_field = "9AB039BA73F970DDDFBFE5E982A0A257", hash_generated_field = "9AB039BA73F970DDDFBFE5E982A0A257")

         AccountManagerCallback<Bundle> mMyCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.227 -0500", hash_original_field = "72DA832F6EC774BAB58CFC3BEE423DA0", hash_generated_field = "71E70B13764C89A5A2D6CAA3A090D703")

        private volatile int mNumAccounts = 0;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.207 -0500", hash_original_method = "8B428F75DFA4C0F7DC2037249CE783CE", hash_generated_method = "8B428F75DFA4C0F7DC2037249CE783CE")
        
GetAuthTokenByTypeAndFeaturesTask(final String accountType, final String authTokenType,
                final String[] features, Activity activityForPrompting,
                final Bundle addAccountOptions, final Bundle loginOptions,
                AccountManagerCallback<Bundle> callback, Handler handler) {
            super(activityForPrompting, handler, callback);
            if (accountType == null) throw new IllegalArgumentException("account type is null");
            mAccountType = accountType;
            mAuthTokenType = authTokenType;
            mFeatures = features;
            mAddAccountOptions = addAccountOptions;
            mLoginOptions = loginOptions;
            mMyCallback = this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.244 -0500", hash_original_method = "C4C5F207D191035A436136641EA5FDB4", hash_generated_method = "7576066B51E9EF8200F077235AE71D71")
        
public void doWork() throws RemoteException {
            getAccountsByTypeAndFeatures(mAccountType, mFeatures,
                    new AccountManagerCallback<Account[]>() {
                        @DSSink({DSSinkKind.ACCOUNT_SETTINGS})
            public void run(AccountManagerFuture<Account[]> future) {
                            Account[] accounts;
                            try {
                                accounts = future.getResult();
                            } catch (OperationCanceledException e) {
                                setException(e);
                                return;
                            } catch (IOException e) {
                                setException(e);
                                return;
                            } catch (AuthenticatorException e) {
                                setException(e);
                                return;
                            }

                            mNumAccounts = accounts.length;

                            if (accounts.length == 0) {
                                if (mActivity != null) {
                                    // no accounts, add one now. pretend that the user directly
                                    // made this request
                                    mFuture = addAccount(mAccountType, mAuthTokenType, mFeatures,
                                            mAddAccountOptions, mActivity, mMyCallback, mHandler);
                                } else {
                                    // send result since we can't prompt to add an account
                                    Bundle result = new Bundle();
                                    result.putString(KEY_ACCOUNT_NAME, null);
                                    result.putString(KEY_ACCOUNT_TYPE, null);
                                    result.putString(KEY_AUTHTOKEN, null);
                                    try {
                                        mResponse.onResult(result);
                                    } catch (RemoteException e) {
                                        // this will never happen
                                    }
                                    // we are done
                                }
                            } else if (accounts.length == 1) {
                                // have a single account, return an authtoken for it
                                if (mActivity == null) {
                                    mFuture = getAuthToken(accounts[0], mAuthTokenType,
                                            false /* notifyAuthFailure */, mMyCallback, mHandler);
                                } else {
                                    mFuture = getAuthToken(accounts[0],
                                            mAuthTokenType, mLoginOptions,
                                            mActivity, mMyCallback, mHandler);
                                }
                            } else {
                                if (mActivity != null) {
                                    IAccountManagerResponse chooseResponse =
                                            new IAccountManagerResponse.Stub() {
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
                                    // have many accounts, launch the chooser
                                    Intent intent = new Intent();
                                    intent.setClassName("android",
                                            "android.accounts.ChooseAccountActivity");
                                    intent.putExtra(KEY_ACCOUNTS, accounts);
                                    intent.putExtra(KEY_ACCOUNT_MANAGER_RESPONSE,
                                            new AccountManagerResponse(chooseResponse));
                                    mActivity.startActivity(intent);
                                    // the result will arrive via the IAccountManagerResponse
                                } else {
                                    // send result since we can't prompt to select an account
                                    Bundle result = new Bundle();
                                    result.putString(KEY_ACCOUNTS, null);
                                    try {
                                        mResponse.onResult(result);
                                    } catch (RemoteException e) {
                                        // this will never happen
                                    }
                                    // we are done
                                }
                            }
                        }}, mHandler);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.247 -0500", hash_original_method = "770A26A7F965A1883CF21DF75B7155CF", hash_generated_method = "789EE338FABA28369118D635F320E85B")
        
public void run(AccountManagerFuture<Bundle> future) {
            try {
                final Bundle result = future.getResult();
                if (mNumAccounts == 0) {
                    final String accountName = result.getString(KEY_ACCOUNT_NAME);
                    final String accountType = result.getString(KEY_ACCOUNT_TYPE);
                    if (TextUtils.isEmpty(accountName) || TextUtils.isEmpty(accountType)) {
                        setException(new AuthenticatorException("account not in result"));
                        return;
                    }
                    final Account account = new Account(accountName, accountType);
                    mNumAccounts = 1;
                    getAuthToken(account, mAuthTokenType, null /* options */, mActivity,
                            mMyCallback, mHandler);
                    return;
                }
                set(result);
            } catch (OperationCanceledException e) {
                cancel(true /* mayInterruptIfRUnning */);
            } catch (IOException e) {
                setException(e);
            } catch (AuthenticatorException e) {
                setException(e);
            }
        }
        
    }
    
    //DS: we added method to allow creation of account manager from getSystemService()
    
    @DSSafe(DSCat.SAFE_OTHERS)
    public AccountManager() {
        
    }

    /**
     * Gets the saved password associated with the account.
     * This is intended for authenticators and related code; applications
     * should get an auth token instead.
     *
     * <p>It is safe to call this method from the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#AUTHENTICATE_ACCOUNTS}
     * and to have the same UID as the account's authenticator.
     *
     * @param account The account to query for a password
     * @return The account's password, null if none or if the account doesn't exist
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.977 -0500", hash_original_method = "96491C15B9EBF498D1F12389B670F852", hash_generated_method = "507B905B9387DA03A81F4A185732ED61")
    
public String getPassword(final Account account) {
        if (account == null) throw new IllegalArgumentException("account is null");
        try {
            return mService.getPassword(account);
        } catch (RemoteException e) {
            // will never happen
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets the user data named by "key" associated with the account.
     * This is intended for authenticators and related code to store
     * arbitrary metadata along with accounts.  The meaning of the keys
     * and values is up to the authenticator for the account.
     *
     * <p>It is safe to call this method from the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#AUTHENTICATE_ACCOUNTS}
     * and to have the same UID as the account's authenticator.
     *
     * @param account The account to query for user data
     * @return The user data, null if the account or key doesn't exist
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.980 -0500", hash_original_method = "8DF662EA0E604D155E2F8EF5AE185580", hash_generated_method = "AE45A2B824F8C312756415AB8BD08328")
    
public String getUserData(final Account account, final String key) {
        if (account == null) throw new IllegalArgumentException("account is null");
        if (key == null) throw new IllegalArgumentException("key is null");
        try {
            return mService.getUserData(account, key);
        } catch (RemoteException e) {
            // will never happen
            throw new RuntimeException(e);
        }
    }

    /**
     * Lists the currently registered authenticators.
     *
     * <p>It is safe to call this method from the main thread.
     *
     * <p>No permission is required to call this method.
     *
     * @return An array of {@link AuthenticatorDescription} for every
     *     authenticator known to the AccountManager service.  Empty (never
     *     null) if no authenticators are known.
     */
    @DSSource({DSSourceKind.ACCOUNT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.982 -0500", hash_original_method = "CE81752A69974A848970631715E35659", hash_generated_method = "748F931D39A4440F0C9729C8E4947ADB")
    
public AuthenticatorDescription[] getAuthenticatorTypes() {
        try {
            return mService.getAuthenticatorTypes();
        } catch (RemoteException e) {
            // will never happen
            throw new RuntimeException(e);
        }
    }

    /**
     * Lists all accounts of any type registered on the device.
     * Equivalent to getAccountsByType(null).
     *
     * <p>It is safe to call this method from the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#GET_ACCOUNTS}.
     *
     * @return An array of {@link Account}, one for each account.  Empty
     *     (never null) if no accounts have been added.
     */
    @DSSource({DSSourceKind.ACCOUNT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.984 -0500", hash_original_method = "CBAE32CDB06D92C44980C30430EF1CC0", hash_generated_method = "3C8716EFC8BE771BB2ED9E3800837556")
    
public Account[] getAccounts() {
        try {
            return mService.getAccounts(null);
        } catch (RemoteException e) {
            // won't ever happen
            throw new RuntimeException(e);
        }
    }

    /**
     * Lists all accounts of a particular type.  The account type is a
     * string token corresponding to the authenticator and useful domain
     * of the account.  For example, there are types corresponding to Google
     * and Facebook.  The exact string token to use will be published somewhere
     * associated with the authenticator in question.
     *
     * <p>It is safe to call this method from the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#GET_ACCOUNTS}.
     *
     * @param type The type of accounts to return, null to retrieve all accounts
     * @return An array of {@link Account}, one per matching account.  Empty
     *     (never null) if no accounts of the specified type have been added.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.ACCOUNT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.987 -0500", hash_original_method = "182706774272102452F63339D769DBB2", hash_generated_method = "3E5A9E7DA6686259CE7A37D9087EAE06")
    
public Account[] getAccountsByType(String type) {
        try {
            return mService.getAccounts(type);
        } catch (RemoteException e) {
            // won't ever happen
            throw new RuntimeException(e);
        }
    }

    /**
     * Finds out whether a particular account has all the specified features.
     * Account features are authenticator-specific string tokens identifying
     * boolean account properties.  For example, features are used to tell
     * whether Google accounts have a particular service (such as Google
     * Calendar or Google Talk) enabled.  The feature names and their meanings
     * are published somewhere associated with the authenticator in question.
     *
     * <p>This method may be called from any thread, but the returned
     * {@link AccountManagerFuture} must not be used on the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#GET_ACCOUNTS}.
     *
     * @param account The {@link Account} to test
     * @param features An array of the account features to check
     * @param callback Callback to invoke when the request completes,
     *     null for no callback
     * @param handler {@link Handler} identifying the callback thread,
     *     null for the main thread
     * @return An {@link AccountManagerFuture} which resolves to a Boolean,
     * true if the account exists and has all of the specified features.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.995 -0500", hash_original_method = "74ADBAC1696D9C481AB31AC8146F1AF9", hash_generated_method = "C14BE34C7DF9E035F0BC9FA9EDFC8E53")
    
public AccountManagerFuture<Boolean> hasFeatures(final Account account,
            final String[] features,
            AccountManagerCallback<Boolean> callback, Handler handler) {
        if (account == null) throw new IllegalArgumentException("account is null");
        if (features == null) throw new IllegalArgumentException("features is null");
        return new Future2Task<Boolean>(handler, callback) {
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
    }

    /**
     * Lists all accounts of a type which have certain features.  The account
     * type identifies the authenticator (see {@link #getAccountsByType}).
     * Account features are authenticator-specific string tokens identifying
     * boolean account properties (see {@link #hasFeatures}).
     *
     * <p>Unlike {@link #getAccountsByType}, this method calls the authenticator,
     * which may contact the server or do other work to check account features,
     * so the method returns an {@link AccountManagerFuture}.
     *
     * <p>This method may be called from any thread, but the returned
     * {@link AccountManagerFuture} must not be used on the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#GET_ACCOUNTS}.
     *
     * @param type The type of accounts to return, must not be null
     * @param features An array of the account features to require,
     *     may be null or empty
     * @param callback Callback to invoke when the request completes,
     *     null for no callback
     * @param handler {@link Handler} identifying the callback thread,
     *     null for the main thread
     * @return An {@link AccountManagerFuture} which resolves to an array of
     *     {@link Account}, one per account of the specified type which
     *     matches the requested features.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.005 -0500", hash_original_method = "430725BCDDC603435317A3A309F1AEF2", hash_generated_method = "9021CB12DAAAF3EB5390CFB8CEE7C861")
    
public AccountManagerFuture<Account[]> getAccountsByTypeAndFeatures(
            final String type, final String[] features,
            AccountManagerCallback<Account[]> callback, Handler handler) {
        if (type == null) throw new IllegalArgumentException("type is null");
        return new Future2Task<Account[]>(handler, callback) {
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
    }

    /**
     * Adds an account directly to the AccountManager.  Normally used by sign-up
     * wizards associated with authenticators, not directly by applications.
     *
     * <p>It is safe to call this method from the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#AUTHENTICATE_ACCOUNTS}
     * and to have the same UID as the added account's authenticator.
     *
     * @param account The {@link Account} to add
     * @param password The password to associate with the account, null for none
     * @param userdata String values to use for the account's userdata, null for none
     * @return True if the account was successfully added, false if the account
     *     already exists, the account is null, or another error occurs.
     */
    @DSSpec(DSCat.ANDROID_ACCOUNT)
    @DSSink({DSSinkKind.ACCOUNT_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.008 -0500", hash_original_method = "757D4D500E44E3A8DF2EF3DE74D56199", hash_generated_method = "3DCE731003B6465DC675805C3C9DBC38")
    
public boolean addAccountExplicitly(Account account, String password, Bundle userdata) {
        if (account == null) throw new IllegalArgumentException("account is null");
        try {
            return mService.addAccount(account, password, userdata);
        } catch (RemoteException e) {
            // won't ever happen
            throw new RuntimeException(e);
        }
    }

    /**
     * Removes an account from the AccountManager.  Does nothing if the account
     * does not exist.  Does not delete the account from the server.
     * The authenticator may have its own policies preventing account
     * deletion, in which case the account will not be deleted.
     *
     * <p>This method may be called from any thread, but the returned
     * {@link AccountManagerFuture} must not be used on the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#MANAGE_ACCOUNTS}.
     *
     * @param account The {@link Account} to remove
     * @param callback Callback to invoke when the request completes,
     *     null for no callback
     * @param handler {@link Handler} identifying the callback thread,
     *     null for the main thread
     * @return An {@link AccountManagerFuture} which resolves to a Boolean,
     *     true if the account has been successfully removed,
     *     false if the authenticator forbids deleting this account.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.016 -0500", hash_original_method = "E8BA698C89E3CF76A294446D4D176FF0", hash_generated_method = "604D26B1D6F9346FDB793FE2F6AF6F35")
    
public AccountManagerFuture<Boolean> removeAccount(final Account account,
            AccountManagerCallback<Boolean> callback, Handler handler) {
        if (account == null) throw new IllegalArgumentException("account is null");
        return new Future2Task<Boolean>(handler, callback) {
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
    }

    /**
     * Removes an auth token from the AccountManager's cache.  Does nothing if
     * the auth token is not currently in the cache.  Applications must call this
     * method when the auth token is found to have expired or otherwise become
     * invalid for authenticating requests.  The AccountManager does not validate
     * or expire cached auth tokens otherwise.
     *
     * <p>It is safe to call this method from the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#MANAGE_ACCOUNTS} or
     * {@link android.Manifest.permission#USE_CREDENTIALS}
     *
     * @param accountType The account type of the auth token to invalidate, must not be null
     * @param authToken The auth token to invalidate, may be null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.018 -0500", hash_original_method = "4162D414A92CDAFD44055C84C3F9947E", hash_generated_method = "951E58E3DB5435C77EA4F5E2F3AD6DB5")
    
public void invalidateAuthToken(final String accountType, final String authToken) {
        if (accountType == null) throw new IllegalArgumentException("accountType is null");
        try {
            if (authToken != null) {
                mService.invalidateAuthToken(accountType, authToken);
            }
        } catch (RemoteException e) {
            // won't ever happen
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets an auth token from the AccountManager's cache.  If no auth
     * token is cached for this account, null will be returned -- a new
     * auth token will not be generated, and the server will not be contacted.
     * Intended for use by the authenticator, not directly by applications.
     *
     * <p>It is safe to call this method from the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#AUTHENTICATE_ACCOUNTS}
     * and to have the same UID as the account's authenticator.
     *
     * @param account The account to fetch an auth token for
     * @param authTokenType The type of auth token to fetch, see {#getAuthToken}
     * @return The cached auth token for this account and type, or null if
     *     no auth token is cached or the account does not exist.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.021 -0500", hash_original_method = "DF00C62B1FBE79E2C2C3124DAA6E8CCA", hash_generated_method = "A0F5850B683375BA8343334B52A2ABE0")
    
public String peekAuthToken(final Account account, final String authTokenType) {
        if (account == null) throw new IllegalArgumentException("account is null");
        if (authTokenType == null) throw new IllegalArgumentException("authTokenType is null");
        try {
            return mService.peekAuthToken(account, authTokenType);
        } catch (RemoteException e) {
            // won't ever happen
            throw new RuntimeException(e);
        }
    }

    /**
     * Sets or forgets a saved password.  This modifies the local copy of the
     * password used to automatically authenticate the user; it does
     * not change the user's account password on the server.  Intended for use
     * by the authenticator, not directly by applications.
     *
     * <p>It is safe to call this method from the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#AUTHENTICATE_ACCOUNTS}
     * and have the same UID as the account's authenticator.
     *
     * @param account The account to set a password for
     * @param password The password to set, null to clear the password
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.024 -0500", hash_original_method = "DBE21AE149A5EC66FBC34FA1D5807CA3", hash_generated_method = "A8E24B094050C44F65D349391CF51349")
    
public void setPassword(final Account account, final String password) {
        if (account == null) throw new IllegalArgumentException("account is null");
        try {
            mService.setPassword(account, password);
        } catch (RemoteException e) {
            // won't ever happen
            throw new RuntimeException(e);
        }
    }

    /**
     * Forgets a saved password.  This erases the local copy of the password;
     * it does not change the user's account password on the server.
     * Has the same effect as setPassword(account, null) but requires fewer
     * permissions, and may be used by applications or management interfaces
     * to "sign out" from an account.
     *
     * <p>It is safe to call this method from the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#MANAGE_ACCOUNTS}
     *
     * @param account The account whose password to clear
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.026 -0500", hash_original_method = "9D6E3653B7C827404B4854FFAF700F44", hash_generated_method = "CCF578CC7F5CD0D40880E62BB767450E")
    
public void clearPassword(final Account account) {
        if (account == null) throw new IllegalArgumentException("account is null");
        try {
            mService.clearPassword(account);
        } catch (RemoteException e) {
            // won't ever happen
            throw new RuntimeException(e);
        }
    }

    /**
     * Sets one userdata key for an account.  Intended by use for the
     * authenticator to stash state for itself, not directly by applications.
     * The meaning of the keys and values is up to the authenticator.
     *
     * <p>It is safe to call this method from the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#AUTHENTICATE_ACCOUNTS}
     * and to have the same UID as the account's authenticator.
     *
     * @param account The account to set the userdata for
     * @param key The userdata key to set.  Must not be null
     * @param value The value to set, null to clear this userdata key
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.029 -0500", hash_original_method = "39E18EFA140E2C140EF9BDAC244CFA88", hash_generated_method = "31F2A702F9CF815DA5920719B8142700")
    
public void setUserData(final Account account, final String key, final String value) {
        if (account == null) throw new IllegalArgumentException("account is null");
        if (key == null) throw new IllegalArgumentException("key is null");
        try {
            mService.setUserData(account, key, value);
        } catch (RemoteException e) {
            // won't ever happen
            throw new RuntimeException(e);
        }
    }

    /**
     * Adds an auth token to the AccountManager cache for an account.
     * If the account does not exist then this call has no effect.
     * Replaces any previous auth token for this account and auth token type.
     * Intended for use by the authenticator, not directly by applications.
     *
     * <p>It is safe to call this method from the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#AUTHENTICATE_ACCOUNTS}
     * and to have the same UID as the account's authenticator.
     *
     * @param account The account to set an auth token for
     * @param authTokenType The type of the auth token, see {#getAuthToken}
     * @param authToken The auth token to add to the cache
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.031 -0500", hash_original_method = "967876CD971AD7982E73046636574113", hash_generated_method = "E7C787CE5FFA14E341ACA23702086A73")
    
public void setAuthToken(Account account, final String authTokenType, final String authToken) {
        if (account == null) throw new IllegalArgumentException("account is null");
        if (authTokenType == null) throw new IllegalArgumentException("authTokenType is null");
        try {
            mService.setAuthToken(account, authTokenType, authToken);
        } catch (RemoteException e) {
            // won't ever happen
            throw new RuntimeException(e);
        }
    }

    /**
     * This convenience helper synchronously gets an auth token with
     * {@link #getAuthToken(Account, String, boolean, AccountManagerCallback, Handler)}.
     *
     * <p>This method may block while a network request completes, and must
     * never be made from the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#USE_CREDENTIALS}.
     *
     * @param account The account to fetch an auth token for
     * @param authTokenType The auth token type, see {#link getAuthToken}
     * @param notifyAuthFailure If true, display a notification and return null
     *     if authentication fails; if false, prompt and wait for the user to
     *     re-enter correct credentials before returning
     * @return An auth token of the specified type for this account, or null
     *     if authentication fails or none can be fetched.
     * @throws AuthenticatorException if the authenticator failed to respond
     * @throws OperationCanceledException if the request was canceled for any
     *     reason, including the user canceling a credential request
     * @throws java.io.IOException if the authenticator experienced an I/O problem
     *     creating a new auth token, usually because of network trouble
     */
    @DSSource({DSSourceKind.ACCOUNT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.034 -0500", hash_original_method = "51CDD8704FBB21791536BE5C26E3F85E", hash_generated_method = "88EFABDB4E4E86089ADFDC19C5A43689")
    
public String blockingGetAuthToken(Account account, String authTokenType,
            boolean notifyAuthFailure)
            throws OperationCanceledException, IOException, AuthenticatorException {
        if (account == null) throw new IllegalArgumentException("account is null");
        if (authTokenType == null) throw new IllegalArgumentException("authTokenType is null");
        Bundle bundle = getAuthToken(account, authTokenType, notifyAuthFailure, null /* callback */,
                null /* handler */).getResult();
        if (bundle == null) {
            // This should never happen, but it does, occasionally. If it does return null to
            // signify that we were not able to get the authtoken.
            // TODO: remove this when the bug is found that sometimes causes a null bundle to be
            // returned
            Log.e(TAG, "blockingGetAuthToken: null was returned from getResult() for "
                    + account + ", authTokenType " + authTokenType);
            return null;
        }
        return bundle.getString(KEY_AUTHTOKEN);
    }

    /**
     * Gets an auth token of the specified type for a particular account,
     * prompting the user for credentials if necessary.  This method is
     * intended for applications running in the foreground where it makes
     * sense to ask the user directly for a password.
     *
     * <p>If a previously generated auth token is cached for this account and
     * type, then it is returned.  Otherwise, if a saved password is
     * available, it is sent to the server to generate a new auth token.
     * Otherwise, the user is prompted to enter a password.
     *
     * <p>Some authenticators have auth token <em>types</em>, whose value
     * is authenticator-dependent.  Some services use different token types to
     * access different functionality -- for example, Google uses different auth
     * tokens to access Gmail and Google Calendar for the same account.
     *
     * <p>This method may be called from any thread, but the returned
     * {@link AccountManagerFuture} must not be used on the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#USE_CREDENTIALS}.
     *
     * @param account The account to fetch an auth token for
     * @param authTokenType The auth token type, an authenticator-dependent
     *     string token, must not be null
     * @param options Authenticator-specific options for the request,
     *     may be null or empty
     * @param activity The {@link Activity} context to use for launching a new
     *     authenticator-defined sub-Activity to prompt the user for a password
     *     if necessary; used only to call startActivity(); must not be null.
     * @param callback Callback to invoke when the request completes,
     *     null for no callback
     * @param handler {@link Handler} identifying the callback thread,
     *     null for the main thread
     * @return An {@link AccountManagerFuture} which resolves to a Bundle with
     *     at least the following fields:
     * <ul>
     * <li> {@link #KEY_ACCOUNT_NAME} - the name of the account you supplied
     * <li> {@link #KEY_ACCOUNT_TYPE} - the type of the account
     * <li> {@link #KEY_AUTHTOKEN} - the auth token you wanted
     * </ul>
     *
     * (Other authenticator-specific values may be returned.)  If an auth token
     * could not be fetched, {@link AccountManagerFuture#getResult()} throws:
     * <ul>
     * <li> {@link AuthenticatorException} if the authenticator failed to respond
     * <li> {@link OperationCanceledException} if the operation is canceled for
     *      any reason, incluidng the user canceling a credential request
     * <li> {@link IOException} if the authenticator experienced an I/O problem
     *      creating a new auth token, usually because of network trouble
     * </ul>
     * If the account is no longer present on the device, the return value is
     * authenticator-dependent.  The caller should verify the validity of the
     * account before requesting an auth token.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.040 -0500", hash_original_method = "DC329BE18D12A187B670EF72046E93F0", hash_generated_method = "6A78EF68BD695D1D60F2FED08D299EE1")
    
public AccountManagerFuture<Bundle> getAuthToken(
            final Account account, final String authTokenType, final Bundle options,
            final Activity activity, AccountManagerCallback<Bundle> callback, Handler handler) {
        if (account == null) throw new IllegalArgumentException("account is null");
        if (authTokenType == null) throw new IllegalArgumentException("authTokenType is null");
        final Bundle optionsIn = new Bundle();
        if (options != null) {
            optionsIn.putAll(options);
        }
        optionsIn.putString(KEY_ANDROID_PACKAGE_NAME, mContext.getPackageName());
        return new AmsTask(activity, handler, callback) {
            public void doWork() throws RemoteException {
                mService.getAuthToken(mResponse, account, authTokenType,
                        false /* notifyOnAuthFailure */, true /* expectActivityLaunch */,
                        optionsIn);
            }
        }.start();
    }

    /**
     * Gets an auth token of the specified type for a particular account,
     * optionally raising a notification if the user must enter credentials.
     * This method is intended for background tasks and services where the
     * user should not be immediately interrupted with a password prompt.
     *
     * <p>If a previously generated auth token is cached for this account and
     * type, then it is returned.  Otherwise, if a saved password is
     * available, it is sent to the server to generate a new auth token.
     * Otherwise, an {@link Intent} is returned which, when started, will
     * prompt the user for a password.  If the notifyAuthFailure parameter is
     * set, a status bar notification is also created with the same Intent,
     * alerting the user that they need to enter a password at some point.
     *
     * <p>In that case, you may need to wait until the user responds, which
     * could take hours or days or forever.  When the user does respond and
     * supply a new password, the account manager will broadcast the
     * {@link #LOGIN_ACCOUNTS_CHANGED_ACTION} Intent, which applications can
     * use to try again.
     *
     * <p>If notifyAuthFailure is not set, it is the application's
     * responsibility to launch the returned Intent at some point.
     * Either way, the result from this call will not wait for user action.
     *
     * <p>Some authenticators have auth token <em>types</em>, whose value
     * is authenticator-dependent.  Some services use different token types to
     * access different functionality -- for example, Google uses different auth
     * tokens to access Gmail and Google Calendar for the same account.
     *
     * <p>This method may be called from any thread, but the returned
     * {@link AccountManagerFuture} must not be used on the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#USE_CREDENTIALS}.
     *
     * @param account The account to fetch an auth token for
     * @param authTokenType The auth token type, an authenticator-dependent
     *     string token, must not be null
     * @param notifyAuthFailure True to add a notification to prompt the
     *     user for a password if necessary, false to leave that to the caller
     * @param callback Callback to invoke when the request completes,
     *     null for no callback
     * @param handler {@link Handler} identifying the callback thread,
     *     null for the main thread
     * @return An {@link AccountManagerFuture} which resolves to a Bundle with
     *     at least the following fields on success:
     * <ul>
     * <li> {@link #KEY_ACCOUNT_NAME} - the name of the account you supplied
     * <li> {@link #KEY_ACCOUNT_TYPE} - the type of the account
     * <li> {@link #KEY_AUTHTOKEN} - the auth token you wanted
     * </ul>
     *
     * (Other authenticator-specific values may be returned.)  If the user
     * must enter credentials, the returned Bundle contains only
     * {@link #KEY_INTENT} with the {@link Intent} needed to launch a prompt.
     *
     * If an error occurred, {@link AccountManagerFuture#getResult()} throws:
     * <ul>
     * <li> {@link AuthenticatorException} if the authenticator failed to respond
     * <li> {@link OperationCanceledException} if the operation is canceled for
     *      any reason, incluidng the user canceling a credential request
     * <li> {@link IOException} if the authenticator experienced an I/O problem
     *      creating a new auth token, usually because of network trouble
     * </ul>
     * If the account is no longer present on the device, the return value is
     * authenticator-dependent.  The caller should verify the validity of the
     * account before requesting an auth token.
     * @deprecated use {@link #getAuthToken(Account, String, android.os.Bundle,
     * boolean, AccountManagerCallback, android.os.Handler)} instead
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.043 -0500", hash_original_method = "63BBFF30BB2AEF86FE403A4E568375F4", hash_generated_method = "982AFE464C844194B8DCAD4487B88C71")
    
@Deprecated
    public AccountManagerFuture<Bundle> getAuthToken(
            final Account account, final String authTokenType, 
            final boolean notifyAuthFailure,
            AccountManagerCallback<Bundle> callback, Handler handler) {
        return getAuthToken(account, authTokenType, null, notifyAuthFailure, callback, 
                handler);
    }

    /**
     * Gets an auth token of the specified type for a particular account,
     * optionally raising a notification if the user must enter credentials.
     * This method is intended for background tasks and services where the
     * user should not be immediately interrupted with a password prompt.
     *
     * <p>If a previously generated auth token is cached for this account and
     * type, then it is returned.  Otherwise, if a saved password is
     * available, it is sent to the server to generate a new auth token.
     * Otherwise, an {@link Intent} is returned which, when started, will
     * prompt the user for a password.  If the notifyAuthFailure parameter is
     * set, a status bar notification is also created with the same Intent,
     * alerting the user that they need to enter a password at some point.
     *
     * <p>In that case, you may need to wait until the user responds, which
     * could take hours or days or forever.  When the user does respond and
     * supply a new password, the account manager will broadcast the
     * {@link #LOGIN_ACCOUNTS_CHANGED_ACTION} Intent, which applications can
     * use to try again.
     *
     * <p>If notifyAuthFailure is not set, it is the application's
     * responsibility to launch the returned Intent at some point.
     * Either way, the result from this call will not wait for user action.
     *
     * <p>Some authenticators have auth token <em>types</em>, whose value
     * is authenticator-dependent.  Some services use different token types to
     * access different functionality -- for example, Google uses different auth
     * tokens to access Gmail and Google Calendar for the same account.
     *
     * <p>This method may be called from any thread, but the returned
     * {@link AccountManagerFuture} must not be used on the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#USE_CREDENTIALS}.
     *
     * @param account The account to fetch an auth token for
     * @param authTokenType The auth token type, an authenticator-dependent
     *     string token, must not be null
     * @param options Authenticator-specific options for the request,
     *     may be null or empty
     * @param notifyAuthFailure True to add a notification to prompt the
     *     user for a password if necessary, false to leave that to the caller
     * @param callback Callback to invoke when the request completes,
     *     null for no callback
     * @param handler {@link Handler} identifying the callback thread,
     *     null for the main thread
     * @return An {@link AccountManagerFuture} which resolves to a Bundle with
     *     at least the following fields on success:
     * <ul>
     * <li> {@link #KEY_ACCOUNT_NAME} - the name of the account you supplied
     * <li> {@link #KEY_ACCOUNT_TYPE} - the type of the account
     * <li> {@link #KEY_AUTHTOKEN} - the auth token you wanted
     * </ul>
     *
     * (Other authenticator-specific values may be returned.)  If the user
     * must enter credentials, the returned Bundle contains only
     * {@link #KEY_INTENT} with the {@link Intent} needed to launch a prompt.
     *
     * If an error occurred, {@link AccountManagerFuture#getResult()} throws:
     * <ul>
     * <li> {@link AuthenticatorException} if the authenticator failed to respond
     * <li> {@link OperationCanceledException} if the operation is canceled for
     *      any reason, incluidng the user canceling a credential request
     * <li> {@link IOException} if the authenticator experienced an I/O problem
     *      creating a new auth token, usually because of network trouble
     * </ul>
     * If the account is no longer present on the device, the return value is
     * authenticator-dependent.  The caller should verify the validity of the
     * account before requesting an auth token.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.050 -0500", hash_original_method = "748DC8BCC0E7F6CE1552DDD9EEAFB074", hash_generated_method = "06E63B0EA22F6B040ADFECFA126FA224")
    
public AccountManagerFuture<Bundle> getAuthToken(
            final Account account, final String authTokenType, final Bundle options,
            final boolean notifyAuthFailure,
            AccountManagerCallback<Bundle> callback, Handler handler) {

        if (account == null) throw new IllegalArgumentException("account is null");
        if (authTokenType == null) throw new IllegalArgumentException("authTokenType is null");
        final Bundle optionsIn = new Bundle();
        if (options != null) {
            optionsIn.putAll(options);
        }
        optionsIn.putString(KEY_ANDROID_PACKAGE_NAME, mContext.getPackageName());
        return new AmsTask(null, handler, callback) {
            public void doWork() throws RemoteException {
                mService.getAuthToken(mResponse, account, authTokenType,
                        notifyAuthFailure, false /* expectActivityLaunch */, optionsIn);
            }
        }.start();
    }

    /**
     * Asks the user to add an account of a specified type.  The authenticator
     * for this account type processes this request with the appropriate user
     * interface.  If the user does elect to create a new account, the account
     * name is returned.
     *
     * <p>This method may be called from any thread, but the returned
     * {@link AccountManagerFuture} must not be used on the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#MANAGE_ACCOUNTS}.
     *
     * @param accountType The type of account to add; must not be null
     * @param authTokenType The type of auth token (see {@link #getAuthToken})
     *     this account will need to be able to generate, null for none
     * @param requiredFeatures The features (see {@link #hasFeatures}) this
     *     account must have, null for none
     * @param addAccountOptions Authenticator-specific options for the request,
     *     may be null or empty
     * @param activity The {@link Activity} context to use for launching a new
     *     authenticator-defined sub-Activity to prompt the user to create an
     *     account; used only to call startActivity(); if null, the prompt
     *     will not be launched directly, but the necessary {@link Intent}
     *     will be returned to the caller instead
     * @param callback Callback to invoke when the request completes,
     *     null for no callback
     * @param handler {@link Handler} identifying the callback thread,
     *     null for the main thread
     * @return An {@link AccountManagerFuture} which resolves to a Bundle with
     *     these fields if activity was specified and an account was created:
     * <ul>
     * <li> {@link #KEY_ACCOUNT_NAME} - the name of the account created
     * <li> {@link #KEY_ACCOUNT_TYPE} - the type of the account
     * </ul>
     *
     * If no activity was specified, the returned Bundle contains only
     * {@link #KEY_INTENT} with the {@link Intent} needed to launch the
     * actual account creation process.  If an error occurred,
     * {@link AccountManagerFuture#getResult()} throws:
     * <ul>
     * <li> {@link AuthenticatorException} if no authenticator was registered for
     *      this account type or the authenticator failed to respond
     * <li> {@link OperationCanceledException} if the operation was canceled for
     *      any reason, including the user canceling the creation process
     * <li> {@link IOException} if the authenticator experienced an I/O problem
     *      creating a new account, usually because of network trouble
     * </ul>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.055 -0500", hash_original_method = "6ACDAD8A4FE951A7F40DF03A76D4A058", hash_generated_method = "1185125A1E5F2791E5AF6908BD303D50")
    
public AccountManagerFuture<Bundle> addAccount(final String accountType,
            final String authTokenType, final String[] requiredFeatures,
            final Bundle addAccountOptions,
            final Activity activity, AccountManagerCallback<Bundle> callback, Handler handler) {
        if (accountType == null) throw new IllegalArgumentException("accountType is null");
        final Bundle optionsIn = new Bundle();
        if (addAccountOptions != null) {
            optionsIn.putAll(addAccountOptions);
        }
        optionsIn.putString(KEY_ANDROID_PACKAGE_NAME, mContext.getPackageName());

        return new AmsTask(activity, handler, callback) {
            public void doWork() throws RemoteException {
                mService.addAcount(mResponse, accountType, authTokenType,
                        requiredFeatures, activity != null, optionsIn);
            }
        }.start();
    }

    /**
     * Confirms that the user knows the password for an account to make extra
     * sure they are the owner of the account.  The user-entered password can
     * be supplied directly, otherwise the authenticator for this account type
     * prompts the user with the appropriate interface.  This method is
     * intended for applications which want extra assurance; for example, the
     * phone lock screen uses this to let the user unlock the phone with an
     * account password if they forget the lock pattern.
     *
     * <p>If the user-entered password matches a saved password for this
     * account, the request is considered valid; otherwise the authenticator
     * verifies the password (usually by contacting the server).
     *
     * <p>This method may be called from any thread, but the returned
     * {@link AccountManagerFuture} must not be used on the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#MANAGE_ACCOUNTS}.
     *
     * @param account The account to confirm password knowledge for
     * @param options Authenticator-specific options for the request;
     *     if the {@link #KEY_PASSWORD} string field is present, the
     *     authenticator may use it directly rather than prompting the user;
     *     may be null or empty
     * @param activity The {@link Activity} context to use for launching a new
     *     authenticator-defined sub-Activity to prompt the user to enter a
     *     password; used only to call startActivity(); if null, the prompt
     *     will not be launched directly, but the necessary {@link Intent}
     *     will be returned to the caller instead
     * @param callback Callback to invoke when the request completes,
     *     null for no callback
     * @param handler {@link Handler} identifying the callback thread,
     *     null for the main thread
     * @return An {@link AccountManagerFuture} which resolves to a Bundle
     *     with these fields if activity or password was supplied and
     *     the account was successfully verified:
     * <ul>
     * <li> {@link #KEY_ACCOUNT_NAME} - the name of the account created
     * <li> {@link #KEY_ACCOUNT_TYPE} - the type of the account
     * <li> {@link #KEY_BOOLEAN_RESULT} - true to indicate success
     * </ul>
     *
     * If no activity or password was specified, the returned Bundle contains
     * only {@link #KEY_INTENT} with the {@link Intent} needed to launch the
     * password prompt.  If an error occurred,
     * {@link AccountManagerFuture#getResult()} throws:
     * <ul>
     * <li> {@link AuthenticatorException} if the authenticator failed to respond
     * <li> {@link OperationCanceledException} if the operation was canceled for
     *      any reason, including the user canceling the password prompt
     * <li> {@link IOException} if the authenticator experienced an I/O problem
     *      verifying the password, usually because of network trouble
     * </ul>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.061 -0500", hash_original_method = "E9F24B896DDD289C3D9D25FA0235DC55", hash_generated_method = "E2D82630AC364FC858051E0C6AC18D99")
    
public AccountManagerFuture<Bundle> confirmCredentials(final Account account,
            final Bundle options,
            final Activity activity,
            final AccountManagerCallback<Bundle> callback,
            final Handler handler) {
        if (account == null) throw new IllegalArgumentException("account is null");
        return new AmsTask(activity, handler, callback) {
            public void doWork() throws RemoteException {
                mService.confirmCredentials(mResponse, account, options, activity != null);
            }
        }.start();
    }

    /**
     * Asks the user to enter a new password for an account, updating the
     * saved credentials for the account.  Normally this happens automatically
     * when the server rejects credentials during an auth token fetch, but this
     * can be invoked directly to ensure we have the correct credentials stored.
     *
     * <p>This method may be called from any thread, but the returned
     * {@link AccountManagerFuture} must not be used on the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#MANAGE_ACCOUNTS}.
     *
     * @param account The account to update credentials for
     * @param authTokenType The credentials entered must allow an auth token
     *     of this type to be created (but no actual auth token is returned);
     *     may be null
     * @param options Authenticator-specific options for the request;
     *     may be null or empty
     * @param activity The {@link Activity} context to use for launching a new
     *     authenticator-defined sub-Activity to prompt the user to enter a
     *     password; used only to call startActivity(); if null, the prompt
     *     will not be launched directly, but the necessary {@link Intent}
     *     will be returned to the caller instead
     * @param callback Callback to invoke when the request completes,
     *     null for no callback
     * @param handler {@link Handler} identifying the callback thread,
     *     null for the main thread
     * @return An {@link AccountManagerFuture} which resolves to a Bundle
     *     with these fields if an activity was supplied and the account
     *     credentials were successfully updated:
     * <ul>
     * <li> {@link #KEY_ACCOUNT_NAME} - the name of the account created
     * <li> {@link #KEY_ACCOUNT_TYPE} - the type of the account
     * </ul>
     *
     * If no activity was specified, the returned Bundle contains only
     * {@link #KEY_INTENT} with the {@link Intent} needed to launch the
     * password prompt.  If an error occurred,
     * {@link AccountManagerFuture#getResult()} throws:
     * <ul>
     * <li> {@link AuthenticatorException} if the authenticator failed to respond
     * <li> {@link OperationCanceledException} if the operation was canceled for
     *      any reason, including the user canceling the password prompt
     * <li> {@link IOException} if the authenticator experienced an I/O problem
     *      verifying the password, usually because of network trouble
     * </ul>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.078 -0500", hash_original_method = "D809F6F9BB7D46EEEE0B772ED5C9F6A9", hash_generated_method = "6E18974BE6A1CA9F6A170DC8B365EFCE")
    
public AccountManagerFuture<Bundle> updateCredentials(final Account account,
            final String authTokenType,
            final Bundle options, final Activity activity,
            final AccountManagerCallback<Bundle> callback,
            final Handler handler) {
        if (account == null) throw new IllegalArgumentException("account is null");
        return new AmsTask(activity, handler, callback) {
            public void doWork() throws RemoteException {
                mService.updateCredentials(mResponse, account, authTokenType, activity != null,
                        options);
            }
        }.start();
    }

    /**
     * Offers the user an opportunity to change an authenticator's settings.
     * These properties are for the authenticator in general, not a particular
     * account.  Not all authenticators support this method.
     *
     * <p>This method may be called from any thread, but the returned
     * {@link AccountManagerFuture} must not be used on the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#MANAGE_ACCOUNTS}.
     *
     * @param accountType The account type associated with the authenticator
     *     to adjust
     * @param activity The {@link Activity} context to use for launching a new
     *     authenticator-defined sub-Activity to adjust authenticator settings;
     *     used only to call startActivity(); if null, the settings dialog will
     *     not be launched directly, but the necessary {@link Intent} will be
     *     returned to the caller instead
     * @param callback Callback to invoke when the request completes,
     *     null for no callback
     * @param handler {@link Handler} identifying the callback thread,
     *     null for the main thread
     * @return An {@link AccountManagerFuture} which resolves to a Bundle
     *     which is empty if properties were edited successfully, or
     *     if no activity was specified, contains only {@link #KEY_INTENT}
     *     needed to launch the authenticator's settings dialog.
     *     If an error occurred, {@link AccountManagerFuture#getResult()}
     *     throws:
     * <ul>
     * <li> {@link AuthenticatorException} if no authenticator was registered for
     *      this account type or the authenticator failed to respond
     * <li> {@link OperationCanceledException} if the operation was canceled for
     *      any reason, including the user canceling the settings dialog
     * <li> {@link IOException} if the authenticator experienced an I/O problem
     *      updating settings, usually because of network trouble
     * </ul>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.084 -0500", hash_original_method = "72C42C362A18F251D937648B5DDE9096", hash_generated_method = "0B5B02A0D7E40E55766A1D4FA9DA5FDA")
    
public AccountManagerFuture<Bundle> editProperties(final String accountType,
            final Activity activity, final AccountManagerCallback<Bundle> callback,
            final Handler handler) {
        if (accountType == null) throw new IllegalArgumentException("accountType is null");
        return new AmsTask(activity, handler, callback) {
            public void doWork() throws RemoteException {
                mService.editProperties(mResponse, accountType, activity != null);
            }
        }.start();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.086 -0500", hash_original_method = "05C769BBE692F72E464B52B58848EACE", hash_generated_method = "AC805C3019B3B0AC462E72DD9A55AA27")
    
private void ensureNotOnMainThread() {
        final Looper looper = Looper.myLooper();
        if (looper != null && looper == mContext.getMainLooper()) {
            final IllegalStateException exception = new IllegalStateException(
                    "calling this from your main thread can lead to deadlock");
            Log.e(TAG, "calling this from your main thread can lead to deadlock and/or ANRs",
                    exception);
            if (mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.FROYO) {
                throw exception;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.092 -0500", hash_original_method = "80D38BDC6E0DE7333CAAD84CC9E6E84A", hash_generated_method = "5C7B88FBC2023512CF9D7AADA7F3251A")
    
private void postToHandler(Handler handler, final AccountManagerCallback<Bundle> callback,
            final AccountManagerFuture<Bundle> future) {
        handler = handler == null ? mMainHandler : handler;
        handler.post(new Runnable() {
            public void run() {
                callback.run(future);
            }
        });
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.098 -0500", hash_original_method = "20F25A89C89C92245636BC8DCFF18BD7", hash_generated_method = "4045BDD7789E44982A042C28F60CC555")
    
private void postToHandler(Handler handler, final OnAccountsUpdateListener listener,
            final Account[] accounts) {
        final Account[] accountsCopy = new Account[accounts.length];
        // send a copy to make sure that one doesn't
        // change what another sees
        System.arraycopy(accounts, 0, accountsCopy, 0, accountsCopy.length);
        handler = (handler == null) ? mMainHandler : handler;
        handler.post(new Runnable() {
            public void run() {
                try {
                    listener.onAccountsUpdated(accountsCopy);
                } catch (SQLException e) {
                    // Better luck next time.  If the problem was disk-full,
                    // the STORAGE_OK intent will re-trigger the update.
                    Log.e(TAG, "Can't update accounts", e);
                }
            }
        });
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.204 -0500", hash_original_method = "6FDE075EEB86D1BECEDE842FFDA184DE", hash_generated_method = "E3E7A3DF6CE8F3FD2FAF466271540457")
    
private Exception convertErrorToException(int code, String message) {
        if (code == ERROR_CODE_NETWORK_ERROR) {
            return new IOException(message);
        }

        if (code == ERROR_CODE_UNSUPPORTED_OPERATION) {
            return new UnsupportedOperationException(message);
        }

        if (code == ERROR_CODE_INVALID_RESPONSE) {
            return new AuthenticatorException(message);
        }

        if (code == ERROR_CODE_BAD_ARGUMENTS) {
            return new IllegalArgumentException(message);
        }

        return new AuthenticatorException(message);
    }

    /**
     * This convenience helper combines the functionality of
     * {@link #getAccountsByTypeAndFeatures}, {@link #getAuthToken}, and
     * {@link #addAccount}.
     *
     * <p>This method gets a list of the accounts matching the
     * specified type and feature set; if there is exactly one, it is
     * used; if there are more than one, the user is prompted to pick one;
     * if there are none, the user is prompted to add one.  Finally,
     * an auth token is acquired for the chosen account.
     *
     * <p>This method may be called from any thread, but the returned
     * {@link AccountManagerFuture} must not be used on the main thread.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#MANAGE_ACCOUNTS}.
     *
     * @param accountType The account type required
     *     (see {@link #getAccountsByType}), must not be null
     * @param authTokenType The desired auth token type
     *     (see {@link #getAuthToken}), must not be null
     * @param features Required features for the account
     *     (see {@link #getAccountsByTypeAndFeatures}), may be null or empty
     * @param activity The {@link Activity} context to use for launching new
     *     sub-Activities to prompt to add an account, select an account,
     *     and/or enter a password, as necessary; used only to call
     *     startActivity(); should not be null
     * @param addAccountOptions Authenticator-specific options to use for
     *     adding new accounts; may be null or empty
     * @param getAuthTokenOptions Authenticator-specific options to use for
     *     getting auth tokens; may be null or empty
     * @param callback Callback to invoke when the request completes,
     *     null for no callback
     * @param handler {@link Handler} identifying the callback thread,
     *     null for the main thread
     * @return An {@link AccountManagerFuture} which resolves to a Bundle with
     *     at least the following fields:
     * <ul>
     * <li> {@link #KEY_ACCOUNT_NAME} - the name of the account
     * <li> {@link #KEY_ACCOUNT_TYPE} - the type of the account
     * <li> {@link #KEY_AUTHTOKEN} - the auth token you wanted
     * </ul>
     *
     * If an error occurred, {@link AccountManagerFuture#getResult()} throws:
     * <ul>
     * <li> {@link AuthenticatorException} if no authenticator was registered for
     *      this account type or the authenticator failed to respond
     * <li> {@link OperationCanceledException} if the operation was canceled for
     *      any reason, including the user canceling any operation
     * <li> {@link IOException} if the authenticator experienced an I/O problem
     *      updating settings, usually because of network trouble
     * </ul>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.253 -0500", hash_original_method = "801F35A66961F670B5EADD181BA66DC7", hash_generated_method = "E96204DEE4ACD9C303080284B2FA6B19")
    
public AccountManagerFuture<Bundle> getAuthTokenByFeatures(
            final String accountType, final String authTokenType, final String[] features,
            final Activity activity, final Bundle addAccountOptions,
            final Bundle getAuthTokenOptions,
            final AccountManagerCallback<Bundle> callback, final Handler handler) {
        if (accountType == null) throw new IllegalArgumentException("account type is null");
        if (authTokenType == null) throw new IllegalArgumentException("authTokenType is null");
        final GetAuthTokenByTypeAndFeaturesTask task =
                new GetAuthTokenByTypeAndFeaturesTask(accountType, authTokenType, features,
                activity, addAccountOptions, getAuthTokenOptions, callback, handler);
        task.start();
        return task;
    }

    /**
     * Adds an {@link OnAccountsUpdateListener} to this instance of the
     * {@link AccountManager}.  This listener will be notified whenever the
     * list of accounts on the device changes.
     *
     * <p>As long as this listener is present, the AccountManager instance
     * will not be garbage-collected, and neither will the {@link Context}
     * used to retrieve it, which may be a large Activity instance.  To avoid
     * memory leaks, you must remove this listener before then.  Normally
     * listeners are added in an Activity or Service's {@link Activity#onCreate}
     * and removed in {@link Activity#onDestroy}.
     *
     * <p>It is safe to call this method from the main thread.
     *
     * <p>No permission is required to call this method.
     *
     * @param listener The listener to send notifications to
     * @param handler {@link Handler} identifying the thread to use
     *     for notifications, null for the main thread
     * @param updateImmediately If true, the listener will be invoked
     *     (on the handler thread) right away with the current account list
     * @throws IllegalArgumentException if listener is null
     * @throws IllegalStateException if listener was already added
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.267 -0500", hash_original_method = "7A5668A93C6BCE258395457FB89679A1", hash_generated_method = "89B02BB73B7FF745EB07796067141868")
    
public void addOnAccountsUpdatedListener(final OnAccountsUpdateListener listener,
            Handler handler, boolean updateImmediately) {
        if (listener == null) {
            throw new IllegalArgumentException("the listener is null");
        }
        synchronized (mAccountsUpdatedListeners) {
            if (mAccountsUpdatedListeners.containsKey(listener)) {
                throw new IllegalStateException("this listener is already added");
            }
            final boolean wasEmpty = mAccountsUpdatedListeners.isEmpty();

            mAccountsUpdatedListeners.put(listener, handler);

            if (wasEmpty) {
                // Register a broadcast receiver to monitor account changes
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(LOGIN_ACCOUNTS_CHANGED_ACTION);
                // To recover from disk-full.
                intentFilter.addAction(Intent.ACTION_DEVICE_STORAGE_OK);
                mContext.registerReceiver(mAccountsChangedBroadcastReceiver, intentFilter);
            }
        }

        if (updateImmediately) {
            postToHandler(handler, listener, getAccounts());
        }
    }

    /**
     * Removes an {@link OnAccountsUpdateListener} previously registered with
     * {@link #addOnAccountsUpdatedListener}.  The listener will no longer
     * receive notifications of account changes.
     *
     * <p>It is safe to call this method from the main thread.
     *
     * <p>No permission is required to call this method.
     *
     * @param listener The previously added listener to remove
     * @throws IllegalArgumentException if listener is null
     * @throws IllegalStateException if listener was not already added
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:48.270 -0500", hash_original_method = "66F9A18B2BBFAE47B027D9D23A795F11", hash_generated_method = "83C4424B2DDA414C73E45E20774E7B62")
    
public void removeOnAccountsUpdatedListener(OnAccountsUpdateListener listener) {
        if (listener == null) throw new IllegalArgumentException("listener is null");
        synchronized (mAccountsUpdatedListeners) {
            if (!mAccountsUpdatedListeners.containsKey(listener)) {
                Log.e(TAG, "Listener was not previously added");
                return;
            }
            mAccountsUpdatedListeners.remove(listener);
            if (mAccountsUpdatedListeners.isEmpty()) {
                mContext.unregisterReceiver(mAccountsChangedBroadcastReceiver);
            }
        }
    }
}

