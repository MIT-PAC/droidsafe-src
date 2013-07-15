package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.concrete.DroidSafeContentResolver;
import droidsafe.runtime.*;
import com.android.internal.policy.PolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IContentProvider;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IIntentReceiver;
import android.content.IntentSender;
import android.content.ReceiverCallNotAllowedException;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.CompatibilityInfo;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.hardware.usb.IUsbManager;
import android.hardware.usb.UsbManager;
import android.location.CountryDetector;
import android.location.ICountryDetector;
import android.location.ILocationManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.IConnectivityManager;
import android.net.INetworkPolicyManager;
import android.net.NetworkPolicyManager;
import android.net.ThrottleManager;
import android.net.IThrottleManager;
import android.net.Uri;
import android.net.wifi.IWifiManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.IWifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Environment;
import android.os.FileUtils;
import android.os.Handler;
import android.os.IBinder;
import android.os.IPowerManager;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.telephony.TelephonyManager;
import android.content.ClipboardManager;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.WindowManagerImpl;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import android.accounts.AccountManager;
import android.accounts.IAccountManager;
import android.app.admin.DevicePolicyManager;
import com.android.internal.os.IDropBoxManagerService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

class ReceiverRestrictedContext extends ContextWrapper {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.340 -0400", hash_original_method = "7FD4094CD16832D548D3CEFA622075F6", hash_generated_method = "26ACA97A400E372B38EB9A675A8132FB")
      ReceiverRestrictedContext(Context base) {
        super(base);
        addTaint(base.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.340 -0400", hash_original_method = "E79FC2581462A23AEE3B4180EBBDA608", hash_generated_method = "1FE9908F11A0993579718F342D40E177")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
Intent varD535A24B470170C9E7EA08ED846B5DCB_1930781662 =         registerReceiver(receiver, filter, null, null);
        varD535A24B470170C9E7EA08ED846B5DCB_1930781662.addTaint(taint);
        return varD535A24B470170C9E7EA08ED846B5DCB_1930781662;
        // ---------- Original Method ----------
        //return registerReceiver(receiver, filter, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.341 -0400", hash_original_method = "7DBE869AA37665F34E0D6939DBC75DAB", hash_generated_method = "8F8EA3DFB2B558D267176A6E30086625")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter,
            String broadcastPermission, Handler scheduler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(scheduler.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
        ReceiverCallNotAllowedException var407F1997E2CF2D1DCB2F742C7E6ABC2A_606119675 = new ReceiverCallNotAllowedException(
                "IntentReceiver components are not allowed to register to receive intents");
        var407F1997E2CF2D1DCB2F742C7E6ABC2A_606119675.addTaint(taint);
        throw var407F1997E2CF2D1DCB2F742C7E6ABC2A_606119675;
        // ---------- Original Method ----------
        //throw new ReceiverCallNotAllowedException(
                //"IntentReceiver components are not allowed to register to receive intents");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.342 -0400", hash_original_method = "E81E60407BE1AC3446285185653F6DEC", hash_generated_method = "21E0F42109545B7AC98278F7C1F2AB65")
    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        addTaint(flags);
        addTaint(conn.getTaint());
        addTaint(service.getTaint());
        ReceiverCallNotAllowedException var729F58CF16FF58058AE63A05FEB9E78F_1011572110 = new ReceiverCallNotAllowedException(
                "IntentReceiver components are not allowed to bind to services");
        var729F58CF16FF58058AE63A05FEB9E78F_1011572110.addTaint(taint);
        throw var729F58CF16FF58058AE63A05FEB9E78F_1011572110;
        // ---------- Original Method ----------
        //throw new ReceiverCallNotAllowedException(
                //"IntentReceiver components are not allowed to bind to services");
    }

    
}

public class ContextImpl extends Context {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.343 -0400", hash_original_field = "F26EF77FADF5A57881907E560F2D0D42", hash_generated_field = "EDE05288DA1A1347727FFDBB84784438")

    LoadedApk mPackageInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.344 -0400", hash_original_field = "150BB4175FE9139A54D3AF314D73B91A", hash_generated_field = "A7EF77D1F0E656D4474B6E8D2DBB3B3B")

    private String mBasePackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.344 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.344 -0400", hash_original_field = "46FDB2388003D2F8D58B7436C6E7B099", hash_generated_field = "DAA5CF027F30E341CB6E5B438E9919B8")

    ActivityThread mMainThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.344 -0400", hash_original_field = "D10CC1136F43CB8D3AAE1B13B8FBB4DD", hash_generated_field = "34FBCC1608A4936A90F9DF98F1E48881")

    private Context mOuterContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.344 -0400", hash_original_field = "2BE449269B1F4C70928A0DCFE94621E0", hash_generated_field = "14A36E3A1E55C5D74F222A902E5EE0F2")

    private IBinder mActivityToken = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.344 -0400", hash_original_field = "AA30776C328196000CD028A324C818FD", hash_generated_field = "AF9BE5AAF7F29484886F2FDF1856DC2E")

    private ApplicationContentResolver mContentResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.345 -0400", hash_original_field = "CE5AF0AE42F0D6CB1908A11BF7CF16FA", hash_generated_field = "299CB1540B8056273D436B48FEF6A0EE")

    private int mThemeResource = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.345 -0400", hash_original_field = "78906EEF842F20C56E3EE018C7F5BDA7", hash_generated_field = "ECFB75E383EB1877735FF15B18C148C8")

    private Resources.Theme mTheme = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.346 -0400", hash_original_field = "7D66DD2494F037ED6AC341A00B2AD467", hash_generated_field = "7DEF40BE9F330F69BEFB5B68E8125FE9")

    private PackageManager mPackageManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.346 -0400", hash_original_field = "B21243549DB3C4FC35772D5A6CD22B8A", hash_generated_field = "822E0B86F97CBCA30BEAC92D7074EF2C")

    private Context mReceiverRestrictedContext = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.346 -0400", hash_original_field = "ADD7E2B2442A13369398593FA842CF51", hash_generated_field = "02C747C3724FCFC2B7C6A9A22D88CF16")

    private boolean mRestricted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.346 -0400", hash_original_field = "99CA2AB98020F687D6F8CAD3BC28A985", hash_generated_field = "E2A875EF987A77EEC850F20D740B8615")

    private final Object mSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.346 -0400", hash_original_field = "31F3077B8747A5A9D3290AEC5630F5D0", hash_generated_field = "BD1C0920C019BE593BE14FA4F0428E82")

    private File mDatabasesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.347 -0400", hash_original_field = "8672D560D8B148EC9C43183252399EC3", hash_generated_field = "BEE1171B4DEF7C018E6FF18B5E39497F")

    private File mPreferencesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.347 -0400", hash_original_field = "73A71AF7C46968236F3164132333F1FD", hash_generated_field = "836A24647D35486771B3D976EA5B50CE")

    private File mFilesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.347 -0400", hash_original_field = "0635BA74861D7387F8A35531AB504605", hash_generated_field = "DAD88E122F93A5C508E14D87A3BF9A70")

    private File mCacheDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.347 -0400", hash_original_field = "52A2417455D76879BFA170FFF26775B5", hash_generated_field = "BC229612E30213AE76D95F88EDC2856F")

    private File mObbDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.347 -0400", hash_original_field = "E65B49FD891CDDD102DA56E94053DEBA", hash_generated_field = "7FECE535D8094A9FC9D153E6776699B3")

    private File mExternalFilesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.347 -0400", hash_original_field = "C9602422414763F3A8137ECD73997A49", hash_generated_field = "507D0ED70658593E79745C0F5D91041A")

    private File mExternalCacheDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.348 -0400", hash_original_field = "9CDF81E446283F70EAFFA44FDC69EEA5", hash_generated_field = "D63EC7F2931BD6BAD4B3EF85C123726C")

    final ArrayList<Object> mServiceCache = new ArrayList<Object>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.348 -0400", hash_original_method = "D626E4F654DE4449ACE9581A8359F0B3", hash_generated_method = "EE67F93CB8AD578637611B4EAAB10CB4")
	public
      ContextImpl() {
        mOuterContext = this;
        // ---------- Original Method ----------
        //mOuterContext = this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.349 -0400", hash_original_method = "9A0B254F42B92476EDBA974C3F238399", hash_generated_method = "953194B41378DE16C60A8443D4FF5403")
    public  ContextImpl(ContextImpl context) {
        mPackageInfo = context.mPackageInfo;
        mBasePackageName = context.mBasePackageName;
        mResources = context.mResources;
        mMainThread = context.mMainThread;
        mContentResolver = context.mContentResolver;
        mOuterContext = this;
        // ---------- Original Method ----------
        //mPackageInfo = context.mPackageInfo;
        //mBasePackageName = context.mBasePackageName;
        //mResources = context.mResources;
        //mMainThread = context.mMainThread;
        //mContentResolver = context.mContentResolver;
        //mOuterContext = this;
    }

    
        private static void registerService(String serviceName, ServiceFetcher fetcher) {
        if (!(fetcher instanceof StaticServiceFetcher)) {
            fetcher.mContextCacheIndex = sNextPerContextServiceCacheIndex++;
        }
        SYSTEM_SERVICE_MAP.put(serviceName, fetcher);
    }

    
        static ContextImpl getImpl(Context context) {
        Context nextContext;
        while ((context instanceof ContextWrapper) &&
                (nextContext=((ContextWrapper)context).getBaseContext()) != null) {
            context = nextContext;
        }
        return (ContextImpl)context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.350 -0400", hash_original_method = "E29B1E8B8DA0771E0791531B452826D2", hash_generated_method = "5498498665415D6D26613AAA8FDC0441")
    @Override
    public AssetManager getAssets() {
AssetManager var09CC54E28D033A2A797092212493867A_1395554747 =         mResources.getAssets();
        var09CC54E28D033A2A797092212493867A_1395554747.addTaint(taint);
        return var09CC54E28D033A2A797092212493867A_1395554747;
        // ---------- Original Method ----------
        //return mResources.getAssets();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.350 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "513C115A76CBD13D66EA678F46B3197A")
    @Override
    public Resources getResources() {
Resources var346B953D96D762F7FED561E83C1656CA_459228197 =         mResources;
        var346B953D96D762F7FED561E83C1656CA_459228197.addTaint(taint);
        return var346B953D96D762F7FED561E83C1656CA_459228197;
        // ---------- Original Method ----------
        //return mResources;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.351 -0400", hash_original_method = "BD4B6640BF321317C66EC62ED1810EDC", hash_generated_method = "37295C55EDA168EF5FC9A9A7046AEAFA")
    @Override
    public PackageManager getPackageManager() {
    if(mPackageManager != null)        
        {
PackageManager varC7B8C71CB31DF77623EA48045969A5A3_399021256 =             mPackageManager;
            varC7B8C71CB31DF77623EA48045969A5A3_399021256.addTaint(taint);
            return varC7B8C71CB31DF77623EA48045969A5A3_399021256;
        } //End block
        IPackageManager pm = ActivityThread.getPackageManager();
    if(pm != null)        
        {
PackageManager var439715D8D8C22EAB4975899C0BC19C97_182668381 =             (mPackageManager = new ApplicationPackageManager(this, pm));
            var439715D8D8C22EAB4975899C0BC19C97_182668381.addTaint(taint);
            return var439715D8D8C22EAB4975899C0BC19C97_182668381;
        } //End block
PackageManager var540C13E9E156B687226421B24F2DF178_771013823 =         null;
        var540C13E9E156B687226421B24F2DF178_771013823.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_771013823;
        // ---------- Original Method ----------
        //if (mPackageManager != null) {
            //return mPackageManager;
        //}
        //IPackageManager pm = ActivityThread.getPackageManager();
        //if (pm != null) {
            //return (mPackageManager = new ApplicationPackageManager(this, pm));
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.351 -0400", hash_original_method = "E4195DED98361134A039FE4C88A6F4B6", hash_generated_method = "8E10595E998E9C308DD6619879A2BB7B")
    @Override
    public ContentResolver getContentResolver() {
ContentResolver var8F9DC2C8493C9EB20B434E13A678C351_750837724 =         mContentResolver;
        var8F9DC2C8493C9EB20B434E13A678C351_750837724.addTaint(taint);
        return var8F9DC2C8493C9EB20B434E13A678C351_750837724;
        // ---------- Original Method ----------
        //return mContentResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.352 -0400", hash_original_method = "83F01A831E976E654749A9BEC1E37CC3", hash_generated_method = "F46EB358F695139974DA8944BD25EF01")
    @Override
    public Looper getMainLooper() {
Looper varED41AD3A274FCDD4F3CC86DDF274D901_1108192453 =         mMainThread.getLooper();
        varED41AD3A274FCDD4F3CC86DDF274D901_1108192453.addTaint(taint);
        return varED41AD3A274FCDD4F3CC86DDF274D901_1108192453;
        // ---------- Original Method ----------
        //return mMainThread.getLooper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.352 -0400", hash_original_method = "EEBDE58C6E671C89B231CC2A7DC13506", hash_generated_method = "FE951EA6E3A0A66CD5D26568FAB3D4CC")
    @Override
    public Context getApplicationContext() {
Context varF9043C0E82871E798A752CA9E2B9F901_1641153101 =         (mPackageInfo != null) ?
                mPackageInfo.getApplication() : mMainThread.getApplication();
        varF9043C0E82871E798A752CA9E2B9F901_1641153101.addTaint(taint);
        return varF9043C0E82871E798A752CA9E2B9F901_1641153101;
        // ---------- Original Method ----------
        //return (mPackageInfo != null) ?
                //mPackageInfo.getApplication() : mMainThread.getApplication();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.353 -0400", hash_original_method = "B9D345E863E2753C5A0BB0CFD009BEA6", hash_generated_method = "DAC2322817B2898A8DBFE4A50CECD38D")
    @Override
    public void setTheme(int resid) {
        mThemeResource = resid;
        // ---------- Original Method ----------
        //mThemeResource = resid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.353 -0400", hash_original_method = "AE4733E1C9FA88CFC00EFC04FF1EA93F", hash_generated_method = "ABED4795AC783F45AD966FFC59FBB34F")
    @Override
    public int getThemeResId() {
        int var1A7BE5C50406CFB30A072C422592257E_1273898937 = (mThemeResource);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1036928573 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1036928573;
        // ---------- Original Method ----------
        //return mThemeResource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.354 -0400", hash_original_method = "D6BB36732A764F444B4412949FAD7357", hash_generated_method = "646E975E15D56CA4C7BFFBA590E8BFFB")
    @Override
    public Resources.Theme getTheme() {
    if(mTheme == null)        
        {
            mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                    getOuterContext().getApplicationInfo().targetSdkVersion);
            mTheme = mResources.newTheme();
            mTheme.applyStyle(mThemeResource, true);
        } //End block
Resources.Theme var021DB673F568E8BD9EB3155CBE6DF295_1915968411 =         mTheme;
        var021DB673F568E8BD9EB3155CBE6DF295_1915968411.addTaint(taint);
        return var021DB673F568E8BD9EB3155CBE6DF295_1915968411;
        // ---------- Original Method ----------
        //if (mTheme == null) {
            //mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                    //getOuterContext().getApplicationInfo().targetSdkVersion);
            //mTheme = mResources.newTheme();
            //mTheme.applyStyle(mThemeResource, true);
        //}
        //return mTheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.354 -0400", hash_original_method = "E4AD06E2DE5640E33DD0DE83076841CC", hash_generated_method = "7398CCED24DB02E4D9D7B31901EC642A")
    @Override
    public ClassLoader getClassLoader() {
ClassLoader var16F1A93B2F99E523726DFCDF4517DCE5_374412184 =         mPackageInfo != null ?
                mPackageInfo.getClassLoader() : ClassLoader.getSystemClassLoader();
        var16F1A93B2F99E523726DFCDF4517DCE5_374412184.addTaint(taint);
        return var16F1A93B2F99E523726DFCDF4517DCE5_374412184;
        // ---------- Original Method ----------
        //return mPackageInfo != null ?
                //mPackageInfo.getClassLoader() : ClassLoader.getSystemClassLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.355 -0400", hash_original_method = "C2ABF52241A6291268B401FAB7288697", hash_generated_method = "625F95FAA815E86396683A863A3B08B1")
    @Override
    public String getPackageName() {
    if(mPackageInfo != null)        
        {
String varF4EF12C3F9E3305DAB52E25F8F73442B_538664031 =             mPackageInfo.getPackageName();
            varF4EF12C3F9E3305DAB52E25F8F73442B_538664031.addTaint(taint);
            return varF4EF12C3F9E3305DAB52E25F8F73442B_538664031;
        } //End block
        RuntimeException varEE904A2D709F2CDD39CAD0AF95215C1A_215729130 = new RuntimeException("Not supported in system context");
        varEE904A2D709F2CDD39CAD0AF95215C1A_215729130.addTaint(taint);
        throw varEE904A2D709F2CDD39CAD0AF95215C1A_215729130;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getPackageName();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.355 -0400", hash_original_method = "B6824C91AB2BEA3E97D1CD03B60D140A", hash_generated_method = "A45DA6593946F2BC6AC1EF88F9D6BC24")
    @Override
    public ApplicationInfo getApplicationInfo() {
    if(mPackageInfo != null)        
        {
ApplicationInfo var4B691FDD00B489A2B48EC32B158A39C7_1948739366 =             mPackageInfo.getApplicationInfo();
            var4B691FDD00B489A2B48EC32B158A39C7_1948739366.addTaint(taint);
            return var4B691FDD00B489A2B48EC32B158A39C7_1948739366;
        } //End block
        RuntimeException varEE904A2D709F2CDD39CAD0AF95215C1A_2109199573 = new RuntimeException("Not supported in system context");
        varEE904A2D709F2CDD39CAD0AF95215C1A_2109199573.addTaint(taint);
        throw varEE904A2D709F2CDD39CAD0AF95215C1A_2109199573;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getApplicationInfo();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.356 -0400", hash_original_method = "B40C4604E79523ED9CA9BD2DB89D9D21", hash_generated_method = "0FEBA0049AF9723F1736A3D7AC681E05")
    @Override
    public String getPackageResourcePath() {
    if(mPackageInfo != null)        
        {
String var609075041E4A04BFC71DFBD66E2FBED9_1203166317 =             mPackageInfo.getResDir();
            var609075041E4A04BFC71DFBD66E2FBED9_1203166317.addTaint(taint);
            return var609075041E4A04BFC71DFBD66E2FBED9_1203166317;
        } //End block
        RuntimeException varEE904A2D709F2CDD39CAD0AF95215C1A_653245795 = new RuntimeException("Not supported in system context");
        varEE904A2D709F2CDD39CAD0AF95215C1A_653245795.addTaint(taint);
        throw varEE904A2D709F2CDD39CAD0AF95215C1A_653245795;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getResDir();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.356 -0400", hash_original_method = "6299B0E465B0087370ABC2DD5D8DF3A0", hash_generated_method = "BCD4D0FC8D6A9A24CF9CD19829E6350D")
    @Override
    public String getPackageCodePath() {
    if(mPackageInfo != null)        
        {
String var497BC599628C573D3705051D9A60BE22_1752134006 =             mPackageInfo.getAppDir();
            var497BC599628C573D3705051D9A60BE22_1752134006.addTaint(taint);
            return var497BC599628C573D3705051D9A60BE22_1752134006;
        } //End block
        RuntimeException varEE904A2D709F2CDD39CAD0AF95215C1A_284513606 = new RuntimeException("Not supported in system context");
        varEE904A2D709F2CDD39CAD0AF95215C1A_284513606.addTaint(taint);
        throw varEE904A2D709F2CDD39CAD0AF95215C1A_284513606;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getAppDir();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.365 -0400", hash_original_method = "AB577AC8DAB754DCD42D8B905735EB0E", hash_generated_method = "A85D7678E389FC62FF7612CC8A10ECA0")
    public File getSharedPrefsFile(String name) {
        addTaint(name.getTaint());
File var1E7D6E44AFED15D14645E57F196080B8_1088349714 =         makeFilename(getPreferencesDir(), name + ".xml");
        var1E7D6E44AFED15D14645E57F196080B8_1088349714.addTaint(taint);
        return var1E7D6E44AFED15D14645E57F196080B8_1088349714;
        // ---------- Original Method ----------
        //return makeFilename(getPreferencesDir(), name + ".xml");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.371 -0400", hash_original_method = "B5A20353911F33A4DD3A6110C0300877", hash_generated_method = "7161762215E0B623BB7698616203D813")
    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        addTaint(mode);
        addTaint(name.getTaint());
        SharedPreferencesImpl sp;
        synchronized
(sSharedPrefs)        {
            sp = sSharedPrefs.get(name);
    if(sp == null)            
            {
                File prefsFile = getSharedPrefsFile(name);
                sp = new SharedPreferencesImpl(prefsFile, mode);
                sSharedPrefs.put(name, sp);
SharedPreferences varA4DCFF844B7753D115259E5560FDE637_1451935944 =                 sp;
                varA4DCFF844B7753D115259E5560FDE637_1451935944.addTaint(taint);
                return varA4DCFF844B7753D115259E5560FDE637_1451935944;
            } //End block
        } //End block
    if((mode & Context.MODE_MULTI_PROCESS) != 0 ||
            getApplicationInfo().targetSdkVersion < android.os.Build.VERSION_CODES.HONEYCOMB)        
        {
            sp.startReloadIfChangedUnexpectedly();
        } //End block
SharedPreferences varA4DCFF844B7753D115259E5560FDE637_340036548 =         sp;
        varA4DCFF844B7753D115259E5560FDE637_340036548.addTaint(taint);
        return varA4DCFF844B7753D115259E5560FDE637_340036548;
        // ---------- Original Method ----------
        //SharedPreferencesImpl sp;
        //synchronized (sSharedPrefs) {
            //sp = sSharedPrefs.get(name);
            //if (sp == null) {
                //File prefsFile = getSharedPrefsFile(name);
                //sp = new SharedPreferencesImpl(prefsFile, mode);
                //sSharedPrefs.put(name, sp);
                //return sp;
            //}
        //}
        //if ((mode & Context.MODE_MULTI_PROCESS) != 0 ||
            //getApplicationInfo().targetSdkVersion < android.os.Build.VERSION_CODES.HONEYCOMB) {
            //sp.startReloadIfChangedUnexpectedly();
        //}
        //return sp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.372 -0400", hash_original_method = "0A29125F4E4AA8A93CA3D1CE13216DA3", hash_generated_method = "41F06EB8C4FA63845C36C6E91E2DE826")
    private File getPreferencesDir() {
        synchronized
(mSync)        {
    if(mPreferencesDir == null)            
            {
                mPreferencesDir = new File(getDataDirFile(), "shared_prefs");
            } //End block
File varB5580270F36BE30B06AE9DEFC8DEE79A_1770533287 =             mPreferencesDir;
            varB5580270F36BE30B06AE9DEFC8DEE79A_1770533287.addTaint(taint);
            return varB5580270F36BE30B06AE9DEFC8DEE79A_1770533287;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mPreferencesDir == null) {
                //mPreferencesDir = new File(getDataDirFile(), "shared_prefs");
            //}
            //return mPreferencesDir;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.373 -0400", hash_original_method = "99E1A62B7C8E5CCF8F9E6256C436E103", hash_generated_method = "FF51AEF11A0982841568BDC2E370E296")
    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        addTaint(name.getTaint());
        File f = makeFilename(getFilesDir(), name);
FileInputStream varE117E1656619F1101A221825116618B1_1732691897 =         new FileInputStream(f);
        varE117E1656619F1101A221825116618B1_1732691897.addTaint(taint);
        return varE117E1656619F1101A221825116618B1_1732691897;
        // ---------- Original Method ----------
        //File f = makeFilename(getFilesDir(), name);
        //return new FileInputStream(f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.374 -0400", hash_original_method = "8D0BF4576C7B4CFD18075B0F373C4195", hash_generated_method = "53C7752DE0E6DE452C10725531982F74")
    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        addTaint(mode);
        addTaint(name.getTaint());
        final boolean append = (mode&MODE_APPEND) != 0;
        File f = makeFilename(getFilesDir(), name);
        try 
        {
            FileOutputStream fos = new FileOutputStream(f, append);
            setFilePermissionsFromMode(f.getPath(), mode, 0);
FileOutputStream varEF20B018C31FD4204B36935D484B0EEF_383874207 =             fos;
            varEF20B018C31FD4204B36935D484B0EEF_383874207.addTaint(taint);
            return varEF20B018C31FD4204B36935D484B0EEF_383874207;
        } //End block
        catch (FileNotFoundException e)
        {
        } //End block
        File parent = f.getParentFile();
        parent.mkdir();
        FileUtils.setPermissions(
            parent.getPath(),
            FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
            -1, -1);
        FileOutputStream fos = new FileOutputStream(f, append);
        setFilePermissionsFromMode(f.getPath(), mode, 0);
FileOutputStream varEF20B018C31FD4204B36935D484B0EEF_1931178651 =         fos;
        varEF20B018C31FD4204B36935D484B0EEF_1931178651.addTaint(taint);
        return varEF20B018C31FD4204B36935D484B0EEF_1931178651;
        // ---------- Original Method ----------
        //final boolean append = (mode&MODE_APPEND) != 0;
        //File f = makeFilename(getFilesDir(), name);
        //try {
            //FileOutputStream fos = new FileOutputStream(f, append);
            //setFilePermissionsFromMode(f.getPath(), mode, 0);
            //return fos;
        //} catch (FileNotFoundException e) {
        //}
        //File parent = f.getParentFile();
        //parent.mkdir();
        //FileUtils.setPermissions(
            //parent.getPath(),
            //FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
            //-1, -1);
        //FileOutputStream fos = new FileOutputStream(f, append);
        //setFilePermissionsFromMode(f.getPath(), mode, 0);
        //return fos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.376 -0400", hash_original_method = "F16B6B6A1EABD28DB33653BAF5021B3A", hash_generated_method = "1BD87E7D4ED40F9E2E912034E7321FF2")
    @Override
    public boolean deleteFile(String name) {
        addTaint(name.getTaint());
        File f = makeFilename(getFilesDir(), name);
        boolean varD09C522A4F6F8C6D66D204481533EF11_1098605800 = (f.delete());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_201141822 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_201141822;
        // ---------- Original Method ----------
        //File f = makeFilename(getFilesDir(), name);
        //return f.delete();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.377 -0400", hash_original_method = "F3D2FFAF4E630F0552CFADCBAF494A59", hash_generated_method = "42956A4B7E0FBBE0552EB8075F1C1C25")
    @Override
    public File getFilesDir() {
        synchronized
(mSync)        {
    if(mFilesDir == null)            
            {
                mFilesDir = new File(getDataDirFile(), "files");
            } //End block
    if(!mFilesDir.exists())            
            {
    if(!mFilesDir.mkdirs())                
                {
File var540C13E9E156B687226421B24F2DF178_1589667220 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1589667220.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1589667220;
                } //End block
                FileUtils.setPermissions(
                        mFilesDir.getPath(),
                        FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                        -1, -1);
            } //End block
File varDDEB74CA65264268E92A9632171F02BD_201783212 =             mFilesDir;
            varDDEB74CA65264268E92A9632171F02BD_201783212.addTaint(taint);
            return varDDEB74CA65264268E92A9632171F02BD_201783212;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mFilesDir == null) {
                //mFilesDir = new File(getDataDirFile(), "files");
            //}
            //if (!mFilesDir.exists()) {
                //if(!mFilesDir.mkdirs()) {
                    //Log.w(TAG, "Unable to create files directory " + mFilesDir.getPath());
                    //return null;
                //}
                //FileUtils.setPermissions(
                        //mFilesDir.getPath(),
                        //FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                        //-1, -1);
            //}
            //return mFilesDir;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.378 -0400", hash_original_method = "E1CC83B0B5F678A7C2185F1397CC9FDE", hash_generated_method = "A9B8E080EAD3A95D492649FAE998F5C2")
    @Override
    public File getExternalFilesDir(String type) {
        addTaint(type.getTaint());
        synchronized
(mSync)        {
    if(mExternalFilesDir == null)            
            {
                mExternalFilesDir = Environment.getExternalStorageAppFilesDirectory(
                        getPackageName());
            } //End block
    if(!mExternalFilesDir.exists())            
            {
                try 
                {
                    (new File(Environment.getExternalStorageAndroidDataDir(),
                            ".nomedia")).createNewFile();
                } //End block
                catch (IOException e)
                {
                } //End block
    if(!mExternalFilesDir.mkdirs())                
                {
File var540C13E9E156B687226421B24F2DF178_1187118946 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1187118946.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1187118946;
                } //End block
            } //End block
    if(type == null)            
            {
File var5CE0FFC467CE1E61F8F3D6EDA0801610_1052211070 =                 mExternalFilesDir;
                var5CE0FFC467CE1E61F8F3D6EDA0801610_1052211070.addTaint(taint);
                return var5CE0FFC467CE1E61F8F3D6EDA0801610_1052211070;
            } //End block
            File dir = new File(mExternalFilesDir, type);
    if(!dir.exists())            
            {
    if(!dir.mkdirs())                
                {
File var540C13E9E156B687226421B24F2DF178_1348985286 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1348985286.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1348985286;
                } //End block
            } //End block
File var5EF865AB804D7F7E31B936B35280353F_1418713337 =             dir;
            var5EF865AB804D7F7E31B936B35280353F_1418713337.addTaint(taint);
            return var5EF865AB804D7F7E31B936B35280353F_1418713337;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.379 -0400", hash_original_method = "36DEC4EC6E4DB2E91443B0A9125E0342", hash_generated_method = "1F8EC03A8A027FC1CFAF1160A21165E0")
    @Override
    public File getObbDir() {
        synchronized
(mSync)        {
    if(mObbDir == null)            
            {
                mObbDir = Environment.getExternalStorageAppObbDirectory(
                        getPackageName());
            } //End block
File var15B08C553D466EC306008816A9169994_2128732210 =             mObbDir;
            var15B08C553D466EC306008816A9169994_2128732210.addTaint(taint);
            return var15B08C553D466EC306008816A9169994_2128732210;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mObbDir == null) {
                //mObbDir = Environment.getExternalStorageAppObbDirectory(
                        //getPackageName());
            //}
            //return mObbDir;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.383 -0400", hash_original_method = "F6DBEEC95A0D73AEBD7CDC4BC14EA6E3", hash_generated_method = "95926B39248919819AF626ED4F2C502E")
    @Override
    public File getCacheDir() {
        synchronized
(mSync)        {
    if(mCacheDir == null)            
            {
                mCacheDir = new File(getDataDirFile(), "cache");
            } //End block
    if(!mCacheDir.exists())            
            {
    if(!mCacheDir.mkdirs())                
                {
File var540C13E9E156B687226421B24F2DF178_171748711 =                     null;
                    var540C13E9E156B687226421B24F2DF178_171748711.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_171748711;
                } //End block
                FileUtils.setPermissions(
                        mCacheDir.getPath(),
                        FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                        -1, -1);
            } //End block
        } //End block
File var02A188D4F0BB4497378BBD745019EB79_1785381405 =         mCacheDir;
        var02A188D4F0BB4497378BBD745019EB79_1785381405.addTaint(taint);
        return var02A188D4F0BB4497378BBD745019EB79_1785381405;
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mCacheDir == null) {
                //mCacheDir = new File(getDataDirFile(), "cache");
            //}
            //if (!mCacheDir.exists()) {
                //if(!mCacheDir.mkdirs()) {
                    //Log.w(TAG, "Unable to create cache directory");
                    //return null;
                //}
                //FileUtils.setPermissions(
                        //mCacheDir.getPath(),
                        //FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                        //-1, -1);
            //}
        //}
        //return mCacheDir;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.384 -0400", hash_original_method = "A3CE8D82B860400333D94B94289B1B1E", hash_generated_method = "849C7F68FAA67C862D03CBEE48B3CF2B")
    @Override
    public File getExternalCacheDir() {
        synchronized
(mSync)        {
    if(mExternalCacheDir == null)            
            {
                mExternalCacheDir = Environment.getExternalStorageAppCacheDirectory(
                        getPackageName());
            } //End block
    if(!mExternalCacheDir.exists())            
            {
                try 
                {
                    (new File(Environment.getExternalStorageAndroidDataDir(),
                            ".nomedia")).createNewFile();
                } //End block
                catch (IOException e)
                {
                } //End block
    if(!mExternalCacheDir.mkdirs())                
                {
File var540C13E9E156B687226421B24F2DF178_1337083947 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1337083947.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1337083947;
                } //End block
            } //End block
File var58AAD984409F0E8BC59441667F2007CA_1202885759 =             mExternalCacheDir;
            var58AAD984409F0E8BC59441667F2007CA_1202885759.addTaint(taint);
            return var58AAD984409F0E8BC59441667F2007CA_1202885759;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mExternalCacheDir == null) {
                //mExternalCacheDir = Environment.getExternalStorageAppCacheDirectory(
                        //getPackageName());
            //}
            //if (!mExternalCacheDir.exists()) {
                //try {
                    //(new File(Environment.getExternalStorageAndroidDataDir(),
                            //".nomedia")).createNewFile();
                //} catch (IOException e) {
                //}
                //if (!mExternalCacheDir.mkdirs()) {
                    //Log.w(TAG, "Unable to create external cache directory");
                    //return null;
                //}
            //}
            //return mExternalCacheDir;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.385 -0400", hash_original_method = "32A40B7EA525B83ED21D63D0A896CF7D", hash_generated_method = "6FD44BDACB531333A00398C5706DF733")
    @Override
    public File getFileStreamPath(String name) {
        addTaint(name.getTaint());
File var05C79A75FB5F00CBCA581256542EDF5B_2140632783 =         makeFilename(getFilesDir(), name);
        var05C79A75FB5F00CBCA581256542EDF5B_2140632783.addTaint(taint);
        return var05C79A75FB5F00CBCA581256542EDF5B_2140632783;
        // ---------- Original Method ----------
        //return makeFilename(getFilesDir(), name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.385 -0400", hash_original_method = "568E82D783647A73A7CA56CF0FA39878", hash_generated_method = "6F9F1E7F3C2AFAEFF96F4EC006FD48DA")
    @Override
    public String[] fileList() {
        final String[] list = getFilesDir().list();
String[] varA1D0BD99D688D03B1D47ADCB816068DF_919583141 =         (list != null) ? list : EMPTY_FILE_LIST;
        varA1D0BD99D688D03B1D47ADCB816068DF_919583141.addTaint(taint);
        return varA1D0BD99D688D03B1D47ADCB816068DF_919583141;
        // ---------- Original Method ----------
        //final String[] list = getFilesDir().list();
        //return (list != null) ? list : EMPTY_FILE_LIST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.386 -0400", hash_original_method = "65FB5D1503ECB4784897EFA233F40D4E", hash_generated_method = "F01D0044204A808A412F7BEF363F91B0")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        addTaint(factory.getTaint());
        addTaint(mode);
        addTaint(name.getTaint());
        File f = validateFilePath(name, true);
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f, factory);
        setFilePermissionsFromMode(f.getPath(), mode, 0);
SQLiteDatabase var2F732BA7E0C8A6B94C1D7B25B6A078BE_1331325998 =         db;
        var2F732BA7E0C8A6B94C1D7B25B6A078BE_1331325998.addTaint(taint);
        return var2F732BA7E0C8A6B94C1D7B25B6A078BE_1331325998;
        // ---------- Original Method ----------
        //File f = validateFilePath(name, true);
        //SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f, factory);
        //setFilePermissionsFromMode(f.getPath(), mode, 0);
        //return db;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.387 -0400", hash_original_method = "E2C57028FEE97C40627D175379C5C276", hash_generated_method = "FC15ED60B3FBEE0092580F846232CAF5")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory,
            DatabaseErrorHandler errorHandler) {
        addTaint(errorHandler.getTaint());
        addTaint(factory.getTaint());
        addTaint(mode);
        addTaint(name.getTaint());
        File f = validateFilePath(name, true);
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f.getPath(), factory, errorHandler);
        setFilePermissionsFromMode(f.getPath(), mode, 0);
SQLiteDatabase var2F732BA7E0C8A6B94C1D7B25B6A078BE_1040679221 =         db;
        var2F732BA7E0C8A6B94C1D7B25B6A078BE_1040679221.addTaint(taint);
        return var2F732BA7E0C8A6B94C1D7B25B6A078BE_1040679221;
        // ---------- Original Method ----------
        //File f = validateFilePath(name, true);
        //SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f.getPath(), factory, errorHandler);
        //setFilePermissionsFromMode(f.getPath(), mode, 0);
        //return db;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.395 -0400", hash_original_method = "0A030BBB6F700BE85FBACF41F39CE120", hash_generated_method = "D3B732CEF5B023F086B55C519D7CD1D5")
    @Override
    public boolean deleteDatabase(String name) {
        addTaint(name.getTaint());
        try 
        {
            File f = validateFilePath(name, false);
            boolean varD09C522A4F6F8C6D66D204481533EF11_314649413 = (f.delete());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2073755993 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2073755993;
        } //End block
        catch (Exception e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_941660193 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1538660456 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1538660456;
        // ---------- Original Method ----------
        //try {
            //File f = validateFilePath(name, false);
            //return f.delete();
        //} catch (Exception e) {
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.397 -0400", hash_original_method = "D766C2B887EEA2E44EE642CC66A97FF8", hash_generated_method = "54F43A41B28FAAD137F87E348BEEFA49")
    @Override
    public File getDatabasePath(String name) {
        addTaint(name.getTaint());
File var6129DA788DD9074E6FCE2D96880A1C18_418812878 =         validateFilePath(name, false);
        var6129DA788DD9074E6FCE2D96880A1C18_418812878.addTaint(taint);
        return var6129DA788DD9074E6FCE2D96880A1C18_418812878;
        // ---------- Original Method ----------
        //return validateFilePath(name, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.398 -0400", hash_original_method = "68895933E30EC3F2C5788FC13140D12F", hash_generated_method = "36C62997800D8A9847FE5A16B2AE11ED")
    @Override
    public String[] databaseList() {
        final String[] list = getDatabasesDir().list();
String[] varA1D0BD99D688D03B1D47ADCB816068DF_1635866004 =         (list != null) ? list : EMPTY_FILE_LIST;
        varA1D0BD99D688D03B1D47ADCB816068DF_1635866004.addTaint(taint);
        return varA1D0BD99D688D03B1D47ADCB816068DF_1635866004;
        // ---------- Original Method ----------
        //final String[] list = getDatabasesDir().list();
        //return (list != null) ? list : EMPTY_FILE_LIST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.403 -0400", hash_original_method = "5E7F893311C7FFBA04D943EFEC31C4D2", hash_generated_method = "AFDF2E1FF9E07E82AFD4869B1F1FF839")
    private File getDatabasesDir() {
        synchronized
(mSync)        {
    if(mDatabasesDir == null)            
            {
                mDatabasesDir = new File(getDataDirFile(), "databases");
            } //End block
    if(mDatabasesDir.getPath().equals("databases"))            
            {
                mDatabasesDir = new File("/data/system");
            } //End block
File var03F2278E22352E1F6C912BE2E985552F_387130384 =             mDatabasesDir;
            var03F2278E22352E1F6C912BE2E985552F_387130384.addTaint(taint);
            return var03F2278E22352E1F6C912BE2E985552F_387130384;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mDatabasesDir == null) {
                //mDatabasesDir = new File(getDataDirFile(), "databases");
            //}
            //if (mDatabasesDir.getPath().equals("databases")) {
                //mDatabasesDir = new File("/data/system");
            //}
            //return mDatabasesDir;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.404 -0400", hash_original_method = "FF2FCBF8AB66D55188EF68C63BF4015D", hash_generated_method = "B754B207765464EA564454B2EA4FD0D9")
    @Override
    public Drawable getWallpaper() {
Drawable var5E1B3A03EBA58046DCBF3473B140430E_1627792775 =         getWallpaperManager().getDrawable();
        var5E1B3A03EBA58046DCBF3473B140430E_1627792775.addTaint(taint);
        return var5E1B3A03EBA58046DCBF3473B140430E_1627792775;
        // ---------- Original Method ----------
        //return getWallpaperManager().getDrawable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.406 -0400", hash_original_method = "65D83D9F23D018D77206F0312145003F", hash_generated_method = "FD37B775C4B6063CC550ED2B9DD83CAB")
    @Override
    public Drawable peekWallpaper() {
Drawable varA6AD709EF453905A27C70C18776D17AA_754937845 =         getWallpaperManager().peekDrawable();
        varA6AD709EF453905A27C70C18776D17AA_754937845.addTaint(taint);
        return varA6AD709EF453905A27C70C18776D17AA_754937845;
        // ---------- Original Method ----------
        //return getWallpaperManager().peekDrawable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.406 -0400", hash_original_method = "4D3A48BB3B555646A3FEA2026A3AE79A", hash_generated_method = "3AE70FE37F699963C30B5AA4632F9D2D")
    @Override
    public int getWallpaperDesiredMinimumWidth() {
        int varB1BB8DF8516F66F35C17BBD021952106_130483232 = (getWallpaperManager().getDesiredMinimumWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_379341962 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_379341962;
        // ---------- Original Method ----------
        //return getWallpaperManager().getDesiredMinimumWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.407 -0400", hash_original_method = "5FD558BDEB2B471F8EE36257DB8EACE1", hash_generated_method = "69DAD349A1269F2381A11398B0C599C3")
    @Override
    public int getWallpaperDesiredMinimumHeight() {
        int var051CF96C471A22111752E67DEDF110B7_1877548764 = (getWallpaperManager().getDesiredMinimumHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_124356728 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_124356728;
        // ---------- Original Method ----------
        //return getWallpaperManager().getDesiredMinimumHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.407 -0400", hash_original_method = "0825D5DEC636130484CFA4FBC7BA319E", hash_generated_method = "E9D1644A32FE91BB0B210946C9A38655")
    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        addTaint(bitmap.getTaint());
        getWallpaperManager().setBitmap(bitmap);
        // ---------- Original Method ----------
        //getWallpaperManager().setBitmap(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.407 -0400", hash_original_method = "DCC00C29B93F57D37E7F7F1EC0E5F4AD", hash_generated_method = "6D1E48BF9B6F8ADD780BD04ED3B656CE")
    @Override
    public void setWallpaper(InputStream data) throws IOException {
        addTaint(data.getTaint());
        getWallpaperManager().setStream(data);
        // ---------- Original Method ----------
        //getWallpaperManager().setStream(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.408 -0400", hash_original_method = "4ED3BD15D71B912DA43CDB584176350F", hash_generated_method = "1643E4DA39B9CD39D6B65552B739B7A0")
    @Override
    public void clearWallpaper() throws IOException {
        getWallpaperManager().clear();
        // ---------- Original Method ----------
        //getWallpaperManager().clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.408 -0400", hash_original_method = "C279CF6F1AD260899DD449A44D934DDE", hash_generated_method = "7F80260949580DD615F61C17C1DF8C9B")
    @Override
    public void startActivity(Intent intent) {
        addTaint(intent.getTaint());
    if((intent.getFlags()&Intent.FLAG_ACTIVITY_NEW_TASK) == 0)        
        {
            AndroidRuntimeException varA30FE02AC1640D5D4583E8D1CC7BBD50_1072941349 = new AndroidRuntimeException(
                    "Calling startActivity() from outside of an Activity "
                    + " context requires the FLAG_ACTIVITY_NEW_TASK flag."
                    + " Is this really what you want?");
            varA30FE02AC1640D5D4583E8D1CC7BBD50_1072941349.addTaint(taint);
            throw varA30FE02AC1640D5D4583E8D1CC7BBD50_1072941349;
        } //End block
        mMainThread.getInstrumentation().execStartActivity(
            getOuterContext(), mMainThread.getApplicationThread(), null,
            (Activity)null, intent, -1);
        // ---------- Original Method ----------
        //if ((intent.getFlags()&Intent.FLAG_ACTIVITY_NEW_TASK) == 0) {
            //throw new AndroidRuntimeException(
                    //"Calling startActivity() from outside of an Activity "
                    //+ " context requires the FLAG_ACTIVITY_NEW_TASK flag."
                    //+ " Is this really what you want?");
        //}
        //mMainThread.getInstrumentation().execStartActivity(
            //getOuterContext(), mMainThread.getApplicationThread(), null,
            //(Activity)null, intent, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.409 -0400", hash_original_method = "769E1A7E8134E0631F8E7ACB4BECF53B", hash_generated_method = "85C2434F983D68C5DA6D1E1E7F3479C2")
    @Override
    public void startActivities(Intent[] intents) {
        addTaint(intents[0].getTaint());
    if((intents[0].getFlags()&Intent.FLAG_ACTIVITY_NEW_TASK) == 0)        
        {
            AndroidRuntimeException var85C7B0C8F8D504BEA7D6F78119F6A5C9_310207188 = new AndroidRuntimeException(
                    "Calling startActivities() from outside of an Activity "
                    + " context requires the FLAG_ACTIVITY_NEW_TASK flag on first Intent."
                    + " Is this really what you want?");
            var85C7B0C8F8D504BEA7D6F78119F6A5C9_310207188.addTaint(taint);
            throw var85C7B0C8F8D504BEA7D6F78119F6A5C9_310207188;
        } //End block
        mMainThread.getInstrumentation().execStartActivities(
            getOuterContext(), mMainThread.getApplicationThread(), null,
            (Activity)null, intents);
        // ---------- Original Method ----------
        //if ((intents[0].getFlags()&Intent.FLAG_ACTIVITY_NEW_TASK) == 0) {
            //throw new AndroidRuntimeException(
                    //"Calling startActivities() from outside of an Activity "
                    //+ " context requires the FLAG_ACTIVITY_NEW_TASK flag on first Intent."
                    //+ " Is this really what you want?");
        //}
        //mMainThread.getInstrumentation().execStartActivities(
            //getOuterContext(), mMainThread.getApplicationThread(), null,
            //(Activity)null, intents);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.410 -0400", hash_original_method = "C8E02424AE63F5F49E1852E1F77F5819", hash_generated_method = "45A75E682DAB02CCDA16820B1B039B83")
    @Override
    public void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        addTaint(extraFlags);
        addTaint(flagsValues);
        addTaint(flagsMask);
        addTaint(fillInIntent.getTaint());
        addTaint(intent.getTaint());
        try 
        {
            String resolvedType = null;
    if(fillInIntent != null)            
            {
                fillInIntent.setAllowFds(false);
                resolvedType = fillInIntent.resolveTypeIfNeeded(getContentResolver());
            } //End block
            int result = ActivityManagerNative.getDefault()
                .startActivityIntentSender(mMainThread.getApplicationThread(), intent,
                        fillInIntent, resolvedType, null, null,
                        0, flagsMask, flagsValues);
    if(result == IActivityManager.START_CANCELED)            
            {
                IntentSender.SendIntentException var60287FF7293661812F3B04B1C75E0F5D_1760979197 = new IntentSender.SendIntentException();
                var60287FF7293661812F3B04B1C75E0F5D_1760979197.addTaint(taint);
                throw var60287FF7293661812F3B04B1C75E0F5D_1760979197;
            } //End block
            Instrumentation.checkStartActivityResult(result, null);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //String resolvedType = null;
            //if (fillInIntent != null) {
                //fillInIntent.setAllowFds(false);
                //resolvedType = fillInIntent.resolveTypeIfNeeded(getContentResolver());
            //}
            //int result = ActivityManagerNative.getDefault()
                //.startActivityIntentSender(mMainThread.getApplicationThread(), intent,
                        //fillInIntent, resolvedType, null, null,
                        //0, flagsMask, flagsValues);
            //if (result == IActivityManager.START_CANCELED) {
                //throw new IntentSender.SendIntentException();
            //}
            //Instrumentation.checkStartActivityResult(result, null);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.411 -0400", hash_original_method = "A60EBABFFFCFDD737FB1FDCFE05C44F2", hash_generated_method = "3B442FD0A050512DC523D928A0CCA3E1")
    @Override
    public void sendBroadcast(Intent intent) {
        addTaint(intent.getTaint());
        String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().broadcastIntent(
                mMainThread.getApplicationThread(), intent, resolvedType, null,
                Activity.RESULT_OK, null, null, null, false, false);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        //try {
            //intent.setAllowFds(false);
            //ActivityManagerNative.getDefault().broadcastIntent(
                //mMainThread.getApplicationThread(), intent, resolvedType, null,
                //Activity.RESULT_OK, null, null, null, false, false);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.411 -0400", hash_original_method = "D592FFEA5E7229A3F68F56DC823D9A2C", hash_generated_method = "A91F11D3CC18FACA47E82A7165C83160")
    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        addTaint(receiverPermission.getTaint());
        addTaint(intent.getTaint());
        String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().broadcastIntent(
                mMainThread.getApplicationThread(), intent, resolvedType, null,
                Activity.RESULT_OK, null, null, receiverPermission, false, false);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        //try {
            //intent.setAllowFds(false);
            //ActivityManagerNative.getDefault().broadcastIntent(
                //mMainThread.getApplicationThread(), intent, resolvedType, null,
                //Activity.RESULT_OK, null, null, receiverPermission, false, false);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.412 -0400", hash_original_method = "1B45A83FF6806414FEA9DF50022B81FD", hash_generated_method = "9AAA6671FFE17AB2B3F17AC011258BB3")
    @Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission) {
        addTaint(receiverPermission.getTaint());
        addTaint(intent.getTaint());
        String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().broadcastIntent(
                mMainThread.getApplicationThread(), intent, resolvedType, null,
                Activity.RESULT_OK, null, null, receiverPermission, true, false);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        //try {
            //intent.setAllowFds(false);
            //ActivityManagerNative.getDefault().broadcastIntent(
                //mMainThread.getApplicationThread(), intent, resolvedType, null,
                //Activity.RESULT_OK, null, null, receiverPermission, true, false);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.415 -0400", hash_original_method = "75D722FF40A3D746C01E744F45F69CB7", hash_generated_method = "E448B4AA396A37B41FAD09EC13F5593C")
    @Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission, BroadcastReceiver resultReceiver,
            Handler scheduler, int initialCode, String initialData,
            Bundle initialExtras) {
        addTaint(initialExtras.getTaint());
        addTaint(initialData.getTaint());
        addTaint(initialCode);
        addTaint(scheduler.getTaint());
        addTaint(resultReceiver.getTaint());
        addTaint(receiverPermission.getTaint());
        addTaint(intent.getTaint());
        IIntentReceiver rd = null;
    if(resultReceiver != null)        
        {
    if(mPackageInfo != null)            
            {
    if(scheduler == null)                
                {
                    scheduler = mMainThread.getHandler();
                } //End block
                rd = mPackageInfo.getReceiverDispatcher(
                    resultReceiver, getOuterContext(), scheduler,
                    mMainThread.getInstrumentation(), false);
            } //End block
            else
            {
    if(scheduler == null)                
                {
                    scheduler = mMainThread.getHandler();
                } //End block
                rd = new LoadedApk.ReceiverDispatcher(
                        resultReceiver, getOuterContext(), scheduler, null, false).getIIntentReceiver();
            } //End block
        } //End block
        String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().broadcastIntent(
                mMainThread.getApplicationThread(), intent, resolvedType, rd,
                initialCode, initialData, initialExtras, receiverPermission,
                true, false);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.416 -0400", hash_original_method = "A9DD8A9FF695328B63C944596A4EDBF3", hash_generated_method = "63521AC803F19A311769B31BB73955DF")
    @Override
    public void sendStickyBroadcast(Intent intent) {
        addTaint(intent.getTaint());
        String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().broadcastIntent(
                mMainThread.getApplicationThread(), intent, resolvedType, null,
                Activity.RESULT_OK, null, null, null, false, true);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        //try {
            //intent.setAllowFds(false);
            //ActivityManagerNative.getDefault().broadcastIntent(
                //mMainThread.getApplicationThread(), intent, resolvedType, null,
                //Activity.RESULT_OK, null, null, null, false, true);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.418 -0400", hash_original_method = "5A5C4F9500968E8C5F0A5BF45BC32927", hash_generated_method = "681F85464CB71C4E7AC8B03FE335C8D5")
    @Override
    public void sendStickyOrderedBroadcast(Intent intent,
            BroadcastReceiver resultReceiver,
            Handler scheduler, int initialCode, String initialData,
            Bundle initialExtras) {
        addTaint(initialExtras.getTaint());
        addTaint(initialData.getTaint());
        addTaint(initialCode);
        addTaint(scheduler.getTaint());
        addTaint(resultReceiver.getTaint());
        addTaint(intent.getTaint());
        IIntentReceiver rd = null;
    if(resultReceiver != null)        
        {
    if(mPackageInfo != null)            
            {
    if(scheduler == null)                
                {
                    scheduler = mMainThread.getHandler();
                } //End block
                rd = mPackageInfo.getReceiverDispatcher(
                    resultReceiver, getOuterContext(), scheduler,
                    mMainThread.getInstrumentation(), false);
            } //End block
            else
            {
    if(scheduler == null)                
                {
                    scheduler = mMainThread.getHandler();
                } //End block
                rd = new LoadedApk.ReceiverDispatcher(
                        resultReceiver, getOuterContext(), scheduler, null, false).getIIntentReceiver();
            } //End block
        } //End block
        String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().broadcastIntent(
                mMainThread.getApplicationThread(), intent, resolvedType, rd,
                initialCode, initialData, initialExtras, null,
                true, true);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.420 -0400", hash_original_method = "F1371F3418D2B98EF62AEAB9A1FB12D9", hash_generated_method = "3889259B7B6339BE7D07507552EB293C")
    @Override
    public void removeStickyBroadcast(Intent intent) {
        addTaint(intent.getTaint());
        String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
    if(resolvedType != null)        
        {
            intent = new Intent(intent);
            intent.setDataAndType(intent.getData(), resolvedType);
        } //End block
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().unbroadcastIntent(
                mMainThread.getApplicationThread(), intent);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        //if (resolvedType != null) {
            //intent = new Intent(intent);
            //intent.setDataAndType(intent.getData(), resolvedType);
        //}
        //try {
            //intent.setAllowFds(false);
            //ActivityManagerNative.getDefault().unbroadcastIntent(
                //mMainThread.getApplicationThread(), intent);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.420 -0400", hash_original_method = "E79FC2581462A23AEE3B4180EBBDA608", hash_generated_method = "DF6397899C04A57CD1E7F51EB1EA1C42")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
Intent varD535A24B470170C9E7EA08ED846B5DCB_414202972 =         registerReceiver(receiver, filter, null, null);
        varD535A24B470170C9E7EA08ED846B5DCB_414202972.addTaint(taint);
        return varD535A24B470170C9E7EA08ED846B5DCB_414202972;
        // ---------- Original Method ----------
        //return registerReceiver(receiver, filter, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.421 -0400", hash_original_method = "185009C7B52864D361FCA1A63F57A4A0", hash_generated_method = "3443D95BDAC30360CA08BCD01EC3306F")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter,
            String broadcastPermission, Handler scheduler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(scheduler.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
Intent varC9B8644FEB54CD52908C3775CE9BC850_352745958 =         registerReceiverInternal(receiver, filter, broadcastPermission,
                scheduler, getOuterContext());
        varC9B8644FEB54CD52908C3775CE9BC850_352745958.addTaint(taint);
        return varC9B8644FEB54CD52908C3775CE9BC850_352745958;
        // ---------- Original Method ----------
        //return registerReceiverInternal(receiver, filter, broadcastPermission,
                //scheduler, getOuterContext());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.423 -0400", hash_original_method = "22E75A5CFB9DB3D3B6EDA1829895EA59", hash_generated_method = "3BE82EE54CBF93D31ABF3C69BD9EC84D")
    private Intent registerReceiverInternal(BroadcastReceiver receiver,
            IntentFilter filter, String broadcastPermission,
            Handler scheduler, Context context) {
        addTaint(context.getTaint());
        addTaint(scheduler.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
        IIntentReceiver rd = null;
    if(receiver != null)        
        {
    if(mPackageInfo != null && context != null)            
            {
    if(scheduler == null)                
                {
                    scheduler = mMainThread.getHandler();
                } //End block
                rd = mPackageInfo.getReceiverDispatcher(
                    receiver, context, scheduler,
                    mMainThread.getInstrumentation(), true);
            } //End block
            else
            {
    if(scheduler == null)                
                {
                    scheduler = mMainThread.getHandler();
                } //End block
                rd = new LoadedApk.ReceiverDispatcher(
                        receiver, context, scheduler, null, true).getIIntentReceiver();
            } //End block
        } //End block
        try 
        {
Intent var2F4548E10CBDEA14DF6B0F5748692FEB_1774508200 =             ActivityManagerNative.getDefault().registerReceiver(
                    mMainThread.getApplicationThread(), mBasePackageName,
                    rd, filter, broadcastPermission);
            var2F4548E10CBDEA14DF6B0F5748692FEB_1774508200.addTaint(taint);
            return var2F4548E10CBDEA14DF6B0F5748692FEB_1774508200;
        } //End block
        catch (RemoteException e)
        {
Intent var540C13E9E156B687226421B24F2DF178_1122423568 =             null;
            var540C13E9E156B687226421B24F2DF178_1122423568.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1122423568;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.424 -0400", hash_original_method = "21E1A5F4D046FA1A605B9CB2F1A5C01A", hash_generated_method = "50BE485602D59E413D1F85DDD2114964")
    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        addTaint(receiver.getTaint());
    if(mPackageInfo != null)        
        {
            IIntentReceiver rd = mPackageInfo.forgetReceiverDispatcher(
                    getOuterContext(), receiver);
            try 
            {
                ActivityManagerNative.getDefault().unregisterReceiver(rd);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        else
        {
            RuntimeException varEE904A2D709F2CDD39CAD0AF95215C1A_1196127735 = new RuntimeException("Not supported in system context");
            varEE904A2D709F2CDD39CAD0AF95215C1A_1196127735.addTaint(taint);
            throw varEE904A2D709F2CDD39CAD0AF95215C1A_1196127735;
        } //End block
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //IIntentReceiver rd = mPackageInfo.forgetReceiverDispatcher(
                    //getOuterContext(), receiver);
            //try {
                //ActivityManagerNative.getDefault().unregisterReceiver(rd);
            //} catch (RemoteException e) {
            //}
        //} else {
            //throw new RuntimeException("Not supported in system context");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.425 -0400", hash_original_method = "9B31F5C57DE16C0FCBD62EA4E59CD86B", hash_generated_method = "8D52AF21A6C56995B6F6885CFE968257")
    @Override
    public ComponentName startService(Intent service) {
        addTaint(service.getTaint());
        try 
        {
            service.setAllowFds(false);
            ComponentName cn = ActivityManagerNative.getDefault().startService(
                mMainThread.getApplicationThread(), service,
                service.resolveTypeIfNeeded(getContentResolver()));
    if(cn != null && cn.getPackageName().equals("!"))            
            {
                SecurityException var0F46DE1C915BDF377D7A74C57AFCEF44_1424709713 = new SecurityException(
                        "Not allowed to start service " + service
                        + " without permission " + cn.getClassName());
                var0F46DE1C915BDF377D7A74C57AFCEF44_1424709713.addTaint(taint);
                throw var0F46DE1C915BDF377D7A74C57AFCEF44_1424709713;
            } //End block
ComponentName varDCCFDFA3C846990C7CD62841D6F23059_289075387 =             cn;
            varDCCFDFA3C846990C7CD62841D6F23059_289075387.addTaint(taint);
            return varDCCFDFA3C846990C7CD62841D6F23059_289075387;
        } //End block
        catch (RemoteException e)
        {
ComponentName var540C13E9E156B687226421B24F2DF178_1326864898 =             null;
            var540C13E9E156B687226421B24F2DF178_1326864898.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1326864898;
        } //End block
        // ---------- Original Method ----------
        //try {
            //service.setAllowFds(false);
            //ComponentName cn = ActivityManagerNative.getDefault().startService(
                //mMainThread.getApplicationThread(), service,
                //service.resolveTypeIfNeeded(getContentResolver()));
            //if (cn != null && cn.getPackageName().equals("!")) {
                //throw new SecurityException(
                        //"Not allowed to start service " + service
                        //+ " without permission " + cn.getClassName());
            //}
            //return cn;
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.426 -0400", hash_original_method = "3FB64CBED2328D4F85F81CBC4C681900", hash_generated_method = "CAFCF9A12DF2DF0D2AC722EEE68B6FB9")
    @Override
    public boolean stopService(Intent service) {
        addTaint(service.getTaint());
        try 
        {
            service.setAllowFds(false);
            int res = ActivityManagerNative.getDefault().stopService(
                mMainThread.getApplicationThread(), service,
                service.resolveTypeIfNeeded(getContentResolver()));
    if(res < 0)            
            {
                SecurityException varC0BD828536BF559BF761E837EAE85D6D_1042620064 = new SecurityException(
                        "Not allowed to stop service " + service);
                varC0BD828536BF559BF761E837EAE85D6D_1042620064.addTaint(taint);
                throw varC0BD828536BF559BF761E837EAE85D6D_1042620064;
            } //End block
            boolean var13D92C9476B1FFEA425551B5286D4643_308572139 = (res != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1735223087 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1735223087;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_437454643 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_697062871 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_697062871;
        } //End block
        // ---------- Original Method ----------
        //try {
            //service.setAllowFds(false);
            //int res = ActivityManagerNative.getDefault().stopService(
                //mMainThread.getApplicationThread(), service,
                //service.resolveTypeIfNeeded(getContentResolver()));
            //if (res < 0) {
                //throw new SecurityException(
                        //"Not allowed to stop service " + service);
            //}
            //return res != 0;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.427 -0400", hash_original_method = "96A08A27D9E82A40B6EBDC8137646365", hash_generated_method = "FEAD98165EB70B81A74569DE12782BEE")
    @Override
    public boolean bindService(Intent service, ServiceConnection conn,
            int flags) {
        addTaint(flags);
        addTaint(conn.getTaint());
        addTaint(service.getTaint());
        IServiceConnection sd;
    if(mPackageInfo != null)        
        {
            sd = mPackageInfo.getServiceDispatcher(conn, getOuterContext(),
                    mMainThread.getHandler(), flags);
        } //End block
        else
        {
            RuntimeException varEE904A2D709F2CDD39CAD0AF95215C1A_306638522 = new RuntimeException("Not supported in system context");
            varEE904A2D709F2CDD39CAD0AF95215C1A_306638522.addTaint(taint);
            throw varEE904A2D709F2CDD39CAD0AF95215C1A_306638522;
        } //End block
        try 
        {
            IBinder token = getActivityToken();
    if(token == null && (flags&BIND_AUTO_CREATE) == 0 && mPackageInfo != null
                    && mPackageInfo.getApplicationInfo().targetSdkVersion
                    < android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH)            
            {
                flags |= BIND_WAIVE_PRIORITY;
            } //End block
            service.setAllowFds(false);
            int res = ActivityManagerNative.getDefault().bindService(
                mMainThread.getApplicationThread(), getActivityToken(),
                service, service.resolveTypeIfNeeded(getContentResolver()),
                sd, flags);
    if(res < 0)            
            {
                SecurityException var0DF7474FDDF9AAE542CC8854B8071C2C_671159120 = new SecurityException(
                        "Not allowed to bind to service " + service);
                var0DF7474FDDF9AAE542CC8854B8071C2C_671159120.addTaint(taint);
                throw var0DF7474FDDF9AAE542CC8854B8071C2C_671159120;
            } //End block
            boolean var13D92C9476B1FFEA425551B5286D4643_1813178285 = (res != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1884072276 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1884072276;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_910082936 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_192123247 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_192123247;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.428 -0400", hash_original_method = "9DD3486AE81B06ADE2CF5A15294BDDD9", hash_generated_method = "083EA6FEA1DA0CF3CBF7AF3C70FA1D90")
    @Override
    public void unbindService(ServiceConnection conn) {
        addTaint(conn.getTaint());
    if(mPackageInfo != null)        
        {
            IServiceConnection sd = mPackageInfo.forgetServiceDispatcher(
                    getOuterContext(), conn);
            try 
            {
                ActivityManagerNative.getDefault().unbindService(sd);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        else
        {
            RuntimeException varEE904A2D709F2CDD39CAD0AF95215C1A_1687553999 = new RuntimeException("Not supported in system context");
            varEE904A2D709F2CDD39CAD0AF95215C1A_1687553999.addTaint(taint);
            throw varEE904A2D709F2CDD39CAD0AF95215C1A_1687553999;
        } //End block
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //IServiceConnection sd = mPackageInfo.forgetServiceDispatcher(
                    //getOuterContext(), conn);
            //try {
                //ActivityManagerNative.getDefault().unbindService(sd);
            //} catch (RemoteException e) {
            //}
        //} else {
            //throw new RuntimeException("Not supported in system context");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.429 -0400", hash_original_method = "CC12C19EE7A70096368CCF1888E2A848", hash_generated_method = "B05778F0BCAAE0902B3BFE122D532C80")
    @Override
    public boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments) {
        addTaint(arguments.getTaint());
        addTaint(profileFile.getTaint());
        addTaint(className.getTaint());
        try 
        {
    if(arguments != null)            
            {
                arguments.setAllowFds(false);
            } //End block
            boolean var63C8572B1AED1AAC338BD6C4B78706EA_395125898 = (ActivityManagerNative.getDefault().startInstrumentation(
                    className, profileFile, 0, arguments, null));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_672656190 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_672656190;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1380246393 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1535648254 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1535648254;
        // ---------- Original Method ----------
        //try {
            //if (arguments != null) {
                //arguments.setAllowFds(false);
            //}
            //return ActivityManagerNative.getDefault().startInstrumentation(
                    //className, profileFile, 0, arguments, null);
        //} catch (RemoteException e) {
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.429 -0400", hash_original_method = "321D04A4EEFC063A6FECB18E3640022A", hash_generated_method = "0F2AAAFDF2C1496F423390910C109B63")
    @Override
    public Object getSystemService(String name) {
        addTaint(name.getTaint());
        ServiceFetcher fetcher = SYSTEM_SERVICE_MAP.get(name);
Object var9C0020E217A0DB6896F4209CA40C4554_2098804048 =         fetcher == null ? null : fetcher.getService(this);
        var9C0020E217A0DB6896F4209CA40C4554_2098804048.addTaint(taint);
        return var9C0020E217A0DB6896F4209CA40C4554_2098804048;
        // ---------- Original Method ----------
        //ServiceFetcher fetcher = SYSTEM_SERVICE_MAP.get(name);
        //return fetcher == null ? null : fetcher.getService(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.430 -0400", hash_original_method = "0B425FF354429B91E3FB5E5F0CCF5247", hash_generated_method = "45982EB8BE73B63BDEF577D5E9796110")
    private WallpaperManager getWallpaperManager() {
WallpaperManager var7DCBA8725EE8E928D8710BDCD76F68F8_403200018 =         (WallpaperManager) WALLPAPER_FETCHER.getService(this);
        var7DCBA8725EE8E928D8710BDCD76F68F8_403200018.addTaint(taint);
        return var7DCBA8725EE8E928D8710BDCD76F68F8_403200018;
        // ---------- Original Method ----------
        //return (WallpaperManager) WALLPAPER_FETCHER.getService(this);
    }

    
        static DropBoxManager createDropBoxManager() {
        IBinder b = ServiceManager.getService(DROPBOX_SERVICE);
        IDropBoxManagerService service = IDropBoxManagerService.Stub.asInterface(b);
        if (service == null) {
            return null;
        }
        return new DropBoxManager(service);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.431 -0400", hash_original_method = "E655FD683190F9408899A9F63A4817BD", hash_generated_method = "FF0FEE401F129166D59986D5B1601A11")
    @Override
    public int checkPermission(String permission, int pid, int uid) {
        addTaint(uid);
        addTaint(pid);
        addTaint(permission.getTaint());
    if(permission == null)        
        {
            IllegalArgumentException varF63596F589200F8D345507D41B64F315_877401813 = new IllegalArgumentException("permission is null");
            varF63596F589200F8D345507D41B64F315_877401813.addTaint(taint);
            throw varF63596F589200F8D345507D41B64F315_877401813;
        } //End block
        try 
        {
            int var9C0899B109FF3609AF6B533C91A063A8_567460113 = (ActivityManagerNative.getDefault().checkPermission(
                    permission, pid, uid));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1689834724 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1689834724;
        } //End block
        catch (RemoteException e)
        {
            int varDCC24A235C49CEDE71587AA8B50287A4_1237824512 = (PackageManager.PERMISSION_DENIED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1149309791 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1149309791;
        } //End block
        // ---------- Original Method ----------
        //if (permission == null) {
            //throw new IllegalArgumentException("permission is null");
        //}
        //try {
            //return ActivityManagerNative.getDefault().checkPermission(
                    //permission, pid, uid);
        //} catch (RemoteException e) {
            //return PackageManager.PERMISSION_DENIED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.433 -0400", hash_original_method = "53BB4562C186F88686E791E4D4D7B971", hash_generated_method = "821A6D7D55E8DB2E631D88A75AAE6035")
    @Override
    public int checkCallingPermission(String permission) {
        addTaint(permission.getTaint());
    if(permission == null)        
        {
            IllegalArgumentException varF63596F589200F8D345507D41B64F315_1749623879 = new IllegalArgumentException("permission is null");
            varF63596F589200F8D345507D41B64F315_1749623879.addTaint(taint);
            throw varF63596F589200F8D345507D41B64F315_1749623879;
        } //End block
        int pid = Binder.getCallingPid();
    if(pid != Process.myPid())        
        {
            int varA7ABCC960187BD913275E249C7F290B2_1402008673 = (checkPermission(permission, pid,
                    Binder.getCallingUid()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_112359179 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_112359179;
        } //End block
        int varDCC24A235C49CEDE71587AA8B50287A4_1130429337 = (PackageManager.PERMISSION_DENIED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1634839914 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1634839914;
        // ---------- Original Method ----------
        //if (permission == null) {
            //throw new IllegalArgumentException("permission is null");
        //}
        //int pid = Binder.getCallingPid();
        //if (pid != Process.myPid()) {
            //return checkPermission(permission, pid,
                    //Binder.getCallingUid());
        //}
        //return PackageManager.PERMISSION_DENIED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.434 -0400", hash_original_method = "5A754757CCEBCBF70FA4909241A44647", hash_generated_method = "E4DDEE7BADAE7380ACCA45D9C51A97F6")
    @Override
    public int checkCallingOrSelfPermission(String permission) {
        addTaint(permission.getTaint());
    if(permission == null)        
        {
            IllegalArgumentException varF63596F589200F8D345507D41B64F315_1245833500 = new IllegalArgumentException("permission is null");
            varF63596F589200F8D345507D41B64F315_1245833500.addTaint(taint);
            throw varF63596F589200F8D345507D41B64F315_1245833500;
        } //End block
        int varFEA56755FDE2AC58AA99F03461D32DE6_1377963795 = (checkPermission(permission, Binder.getCallingPid(),
                Binder.getCallingUid()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_388810249 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_388810249;
        // ---------- Original Method ----------
        //if (permission == null) {
            //throw new IllegalArgumentException("permission is null");
        //}
        //return checkPermission(permission, Binder.getCallingPid(),
                //Binder.getCallingUid());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.434 -0400", hash_original_method = "6A8DDEA43434D3CB20BB0A5477A87FA9", hash_generated_method = "2DFE51F64B51E28AC64E372E61938570")
    private void enforce(
            String permission, int resultOfCheck,
            boolean selfToo, int uid, String message) {
        addTaint(message.getTaint());
        addTaint(uid);
        addTaint(selfToo);
        addTaint(resultOfCheck);
        addTaint(permission.getTaint());
    if(resultOfCheck != PackageManager.PERMISSION_GRANTED)        
        {
            SecurityException varE050E0B9F98E39D331C5436BC1F85F8F_646764445 = new SecurityException(
                    (message != null ? (message + ": ") : "") +
                    (selfToo
                     ? "Neither user " + uid + " nor current process has "
                     : "User " + uid + " does not have ") +
                    permission +
                    ".");
            varE050E0B9F98E39D331C5436BC1F85F8F_646764445.addTaint(taint);
            throw varE050E0B9F98E39D331C5436BC1F85F8F_646764445;
        } //End block
        // ---------- Original Method ----------
        //if (resultOfCheck != PackageManager.PERMISSION_GRANTED) {
            //throw new SecurityException(
                    //(message != null ? (message + ": ") : "") +
                    //(selfToo
                     //? "Neither user " + uid + " nor current process has "
                     //: "User " + uid + " does not have ") +
                    //permission +
                    //".");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.435 -0400", hash_original_method = "F2B22F288DBABA7E0BD88EB0745E09E9", hash_generated_method = "B49B1E6DDA9DB79620C3190B6AFF5E4D")
    public void enforcePermission(
            String permission, int pid, int uid, String message) {
        addTaint(message.getTaint());
        addTaint(uid);
        addTaint(pid);
        addTaint(permission.getTaint());
        enforce(permission,
                checkPermission(permission, pid, uid),
                false,
                uid,
                message);
        // ---------- Original Method ----------
        //enforce(permission,
                //checkPermission(permission, pid, uid),
                //false,
                //uid,
                //message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.436 -0400", hash_original_method = "CA80E1A1204586397A57A1A5E2A7C208", hash_generated_method = "8793B5851A63A0C86637AF020385F39D")
    public void enforceCallingPermission(String permission, String message) {
        addTaint(message.getTaint());
        addTaint(permission.getTaint());
        enforce(permission,
                checkCallingPermission(permission),
                false,
                Binder.getCallingUid(),
                message);
        // ---------- Original Method ----------
        //enforce(permission,
                //checkCallingPermission(permission),
                //false,
                //Binder.getCallingUid(),
                //message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.436 -0400", hash_original_method = "29F4EE380B9693113A658836F1C9D9AE", hash_generated_method = "8E49C82C4F66F04C1AF18B9E5564DDE8")
    public void enforceCallingOrSelfPermission(
            String permission, String message) {
        addTaint(message.getTaint());
        addTaint(permission.getTaint());
        enforce(permission,
                checkCallingOrSelfPermission(permission),
                true,
                Binder.getCallingUid(),
                message);
        // ---------- Original Method ----------
        //enforce(permission,
                //checkCallingOrSelfPermission(permission),
                //true,
                //Binder.getCallingUid(),
                //message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.437 -0400", hash_original_method = "482617D8CF55E6FF0FA0E9B04256EFBF", hash_generated_method = "71EC0AEF463F93750CFA98CAD4B67372")
    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        addTaint(toPackage.getTaint());
        try 
        {
            ActivityManagerNative.getDefault().grantUriPermission(
                    mMainThread.getApplicationThread(), toPackage, uri,
                    modeFlags);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().grantUriPermission(
                    //mMainThread.getApplicationThread(), toPackage, uri,
                    //modeFlags);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.438 -0400", hash_original_method = "F750735697FFE8FE8985E9218A8D8CF6", hash_generated_method = "CB790926A22491D1607B8B2139B4188A")
    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        try 
        {
            ActivityManagerNative.getDefault().revokeUriPermission(
                    mMainThread.getApplicationThread(), uri,
                    modeFlags);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().revokeUriPermission(
                    //mMainThread.getApplicationThread(), uri,
                    //modeFlags);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.438 -0400", hash_original_method = "A8F29D130C6713A956C80075096D4067", hash_generated_method = "67E45F6A2B58A30E2F8704F7192F9366")
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(uri.getTaint());
        try 
        {
            int var63C72A61CB6EF995DC046AEBF18CA65C_905472432 = (ActivityManagerNative.getDefault().checkUriPermission(
                    uri, pid, uid, modeFlags));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1553071467 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1553071467;
        } //End block
        catch (RemoteException e)
        {
            int varDCC24A235C49CEDE71587AA8B50287A4_93238198 = (PackageManager.PERMISSION_DENIED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1581084446 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1581084446;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().checkUriPermission(
                    //uri, pid, uid, modeFlags);
        //} catch (RemoteException e) {
            //return PackageManager.PERMISSION_DENIED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.441 -0400", hash_original_method = "F1471C24A57D163C01E766B9D19A4C37", hash_generated_method = "5AB8E94AF12A3D96DA3764CE49ADD318")
    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        int pid = Binder.getCallingPid();
    if(pid != Process.myPid())        
        {
            int var560552F7687141DBAEAABB84FE2246FA_427741077 = (checkUriPermission(uri, pid,
                    Binder.getCallingUid(), modeFlags));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2004967597 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2004967597;
        } //End block
        int varDCC24A235C49CEDE71587AA8B50287A4_1103224823 = (PackageManager.PERMISSION_DENIED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720011912 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720011912;
        // ---------- Original Method ----------
        //int pid = Binder.getCallingPid();
        //if (pid != Process.myPid()) {
            //return checkUriPermission(uri, pid,
                    //Binder.getCallingUid(), modeFlags);
        //}
        //return PackageManager.PERMISSION_DENIED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.442 -0400", hash_original_method = "92EE95457F7ED1F3B819760C77B2C515", hash_generated_method = "A9F0FC306594C15D9F89F53ED18AE9C9")
    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        int var26E0B2E457DC8B59C754F17E22F00E43_1499666654 = (checkUriPermission(uri, Binder.getCallingPid(),
                Binder.getCallingUid(), modeFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1505692127 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1505692127;
        // ---------- Original Method ----------
        //return checkUriPermission(uri, Binder.getCallingPid(),
                //Binder.getCallingUid(), modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.444 -0400", hash_original_method = "A80C4E19DF7618048E1ED051566AC69E", hash_generated_method = "CBD08A2EA2A965C346488265697329D8")
    @Override
    public int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(writePermission.getTaint());
        addTaint(readPermission.getTaint());
        addTaint(uri.getTaint());
    if(DEBUG)        
        {
        } //End block
    if((modeFlags&Intent.FLAG_GRANT_READ_URI_PERMISSION) != 0)        
        {
    if(readPermission == null
                    || checkPermission(readPermission, pid, uid)
                    == PackageManager.PERMISSION_GRANTED)            
            {
                int var55413C6AD5414521A701E18298A1C877_1578749245 = (PackageManager.PERMISSION_GRANTED);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699348712 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699348712;
            } //End block
        } //End block
    if((modeFlags&Intent.FLAG_GRANT_WRITE_URI_PERMISSION) != 0)        
        {
    if(writePermission == null
                    || checkPermission(writePermission, pid, uid)
                    == PackageManager.PERMISSION_GRANTED)            
            {
                int var55413C6AD5414521A701E18298A1C877_1137155133 = (PackageManager.PERMISSION_GRANTED);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1524424215 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1524424215;
            } //End block
        } //End block
        int varC80346FCA15E7B9E9131B288859EBED2_1865883639 = (uri != null ? checkUriPermission(uri, pid, uid, modeFlags)
                : PackageManager.PERMISSION_DENIED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_16827873 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_16827873;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.445 -0400", hash_original_method = "4ABE3E1ABE03D924F88AC8D7A295DCAE", hash_generated_method = "D7492D9A53AFBBE731CAC53CA4E6612C")
    private String uriModeFlagToString(int uriModeFlags) {
        addTaint(uriModeFlags);
switch(uriModeFlags){
        case Intent.FLAG_GRANT_READ_URI_PERMISSION |
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION:
String varB66BDCE2B275B77D4B33D75B25097E16_1225418088 =         "read and write";
        varB66BDCE2B275B77D4B33D75B25097E16_1225418088.addTaint(taint);
        return varB66BDCE2B275B77D4B33D75B25097E16_1225418088;
        case Intent.FLAG_GRANT_READ_URI_PERMISSION:
String var8406D42862B2F33E68A58F11E3652EA9_173268809 =         "read";
        var8406D42862B2F33E68A58F11E3652EA9_173268809.addTaint(taint);
        return var8406D42862B2F33E68A58F11E3652EA9_173268809;
        case Intent.FLAG_GRANT_WRITE_URI_PERMISSION:
String var1D88E2A6AC371783E3524ED205D20662_1258304995 =         "write";
        var1D88E2A6AC371783E3524ED205D20662_1258304995.addTaint(taint);
        return var1D88E2A6AC371783E3524ED205D20662_1258304995;
}        IllegalArgumentException var3D3A9E5462A7D4A56D1C234DC46E3B04_542099335 = new IllegalArgumentException(
                "Unknown permission mode flags: " + uriModeFlags);
        var3D3A9E5462A7D4A56D1C234DC46E3B04_542099335.addTaint(taint);
        throw var3D3A9E5462A7D4A56D1C234DC46E3B04_542099335;
        // ---------- Original Method ----------
        //switch (uriModeFlags) {
            //case Intent.FLAG_GRANT_READ_URI_PERMISSION |
                    //Intent.FLAG_GRANT_WRITE_URI_PERMISSION:
                //return "read and write";
            //case Intent.FLAG_GRANT_READ_URI_PERMISSION:
                //return "read";
            //case Intent.FLAG_GRANT_WRITE_URI_PERMISSION:
                //return "write";
        //}
        //throw new IllegalArgumentException(
                //"Unknown permission mode flags: " + uriModeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.448 -0400", hash_original_method = "6A9FD3C401F0CEC7314A7CD25AD534A9", hash_generated_method = "906DA9AB1ECFE1F04F2633C7C1F8A3CE")
    private void enforceForUri(
            int modeFlags, int resultOfCheck, boolean selfToo,
            int uid, Uri uri, String message) {
        addTaint(message.getTaint());
        addTaint(uri.getTaint());
        addTaint(uid);
        addTaint(selfToo);
        addTaint(resultOfCheck);
        addTaint(modeFlags);
    if(resultOfCheck != PackageManager.PERMISSION_GRANTED)        
        {
            SecurityException var47D452409C040F6BBFD52844F43F3DAE_643410067 = new SecurityException(
                    (message != null ? (message + ": ") : "") +
                    (selfToo
                     ? "Neither user " + uid + " nor current process has "
                     : "User " + uid + " does not have ") +
                    uriModeFlagToString(modeFlags) +
                    " permission on " +
                    uri +
                    ".");
            var47D452409C040F6BBFD52844F43F3DAE_643410067.addTaint(taint);
            throw var47D452409C040F6BBFD52844F43F3DAE_643410067;
        } //End block
        // ---------- Original Method ----------
        //if (resultOfCheck != PackageManager.PERMISSION_GRANTED) {
            //throw new SecurityException(
                    //(message != null ? (message + ": ") : "") +
                    //(selfToo
                     //? "Neither user " + uid + " nor current process has "
                     //: "User " + uid + " does not have ") +
                    //uriModeFlagToString(modeFlags) +
                    //" permission on " +
                    //uri +
                    //".");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.450 -0400", hash_original_method = "E9EAEBDE16DA8C22A5B7F64130CC6C00", hash_generated_method = "CF5309F8900706B880FD7D966E326DF8")
    public void enforceUriPermission(
            Uri uri, int pid, int uid, int modeFlags, String message) {
        addTaint(message.getTaint());
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(uri.getTaint());
        enforceForUri(
                modeFlags, checkUriPermission(uri, pid, uid, modeFlags),
                false, uid, uri, message);
        // ---------- Original Method ----------
        //enforceForUri(
                //modeFlags, checkUriPermission(uri, pid, uid, modeFlags),
                //false, uid, uri, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.450 -0400", hash_original_method = "6F0B74751E74AFB2005E6D12F19CB27E", hash_generated_method = "A85D37F5BA9D9917AC9F8A274C0EB185")
    public void enforceCallingUriPermission(
            Uri uri, int modeFlags, String message) {
        addTaint(message.getTaint());
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        enforceForUri(
                modeFlags, checkCallingUriPermission(uri, modeFlags),
                false, Binder.getCallingUid(), uri, message);
        // ---------- Original Method ----------
        //enforceForUri(
                //modeFlags, checkCallingUriPermission(uri, modeFlags),
                //false, Binder.getCallingUid(), uri, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.451 -0400", hash_original_method = "886A3C8614D2CB5B8B7CB50793F1366D", hash_generated_method = "4EC849A5754E4309C74EF27D86437AD9")
    public void enforceCallingOrSelfUriPermission(
            Uri uri, int modeFlags, String message) {
        addTaint(message.getTaint());
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        enforceForUri(
                modeFlags,
                checkCallingOrSelfUriPermission(uri, modeFlags), true,
                Binder.getCallingUid(), uri, message);
        // ---------- Original Method ----------
        //enforceForUri(
                //modeFlags,
                //checkCallingOrSelfUriPermission(uri, modeFlags), true,
                //Binder.getCallingUid(), uri, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.453 -0400", hash_original_method = "68131D896D42419119F62C3A9452D081", hash_generated_method = "B536C745EF650C57D0EFE3F0BAFF70D0")
    public void enforceUriPermission(
            Uri uri, String readPermission, String writePermission,
            int pid, int uid, int modeFlags, String message) {
        addTaint(message.getTaint());
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(writePermission.getTaint());
        addTaint(readPermission.getTaint());
        addTaint(uri.getTaint());
        enforceForUri(modeFlags,
                      checkUriPermission(
                              uri, readPermission, writePermission, pid, uid,
                              modeFlags),
                      false,
                      uid,
                      uri,
                      message);
        // ---------- Original Method ----------
        //enforceForUri(modeFlags,
                      //checkUriPermission(
                              //uri, readPermission, writePermission, pid, uid,
                              //modeFlags),
                      //false,
                      //uid,
                      //uri,
                      //message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.455 -0400", hash_original_method = "3BCB60F29BD51DD324BEDBA4985B960D", hash_generated_method = "A56327A58D5BD299FA8E18F5A20F0341")
    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        addTaint(packageName.getTaint());
    if(packageName.equals("system") || packageName.equals("android"))        
        {
Context var4621F3569C20654C811A1BA1CE91BC2D_499584052 =             new ContextImpl(mMainThread.getSystemContext());
            var4621F3569C20654C811A1BA1CE91BC2D_499584052.addTaint(taint);
            return var4621F3569C20654C811A1BA1CE91BC2D_499584052;
        } //End block
        LoadedApk pi = mMainThread.getPackageInfo(packageName, mResources.getCompatibilityInfo(), flags);
    if(pi != null)        
        {
            ContextImpl c = new ContextImpl();
            c.mRestricted = (flags & CONTEXT_RESTRICTED) == CONTEXT_RESTRICTED;
            c.init(pi, null, mMainThread, mResources, mBasePackageName);
    if(c.mResources != null)            
            {
Context var807FB10045EE51C06BDB74744A6714DF_1289178871 =                 c;
                var807FB10045EE51C06BDB74744A6714DF_1289178871.addTaint(taint);
                return var807FB10045EE51C06BDB74744A6714DF_1289178871;
            } //End block
        } //End block
        PackageManager.NameNotFoundException varF1D2CA2FC3493B3EB54ABD773CEBD1FA_936552659 = new PackageManager.NameNotFoundException(
            "Application package " + packageName + " not found");
        varF1D2CA2FC3493B3EB54ABD773CEBD1FA_936552659.addTaint(taint);
        throw varF1D2CA2FC3493B3EB54ABD773CEBD1FA_936552659;
        // ---------- Original Method ----------
        //if (packageName.equals("system") || packageName.equals("android")) {
            //return new ContextImpl(mMainThread.getSystemContext());
        //}
        //LoadedApk pi =
            //mMainThread.getPackageInfo(packageName, mResources.getCompatibilityInfo(), flags);
        //if (pi != null) {
            //ContextImpl c = new ContextImpl();
            //c.mRestricted = (flags & CONTEXT_RESTRICTED) == CONTEXT_RESTRICTED;
            //c.init(pi, null, mMainThread, mResources, mBasePackageName);
            //if (c.mResources != null) {
                //return c;
            //}
        //}
        //throw new PackageManager.NameNotFoundException(
            //"Application package " + packageName + " not found");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.456 -0400", hash_original_method = "190E6158FD0788E25F3E34C2C0D2C33E", hash_generated_method = "9E9401E225F3F219A5DB34B61327E0EC")
    @Override
    public boolean isRestricted() {
        boolean varADD7E2B2442A13369398593FA842CF51_1896740945 = (mRestricted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_355941823 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_355941823;
        // ---------- Original Method ----------
        //return mRestricted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.457 -0400", hash_original_method = "E67FD2E3CB9CBDDDA85EF29E76BC4DD2", hash_generated_method = "CD8618EF8CEFA8DDB5FA780ECDE68911")
    private File getDataDirFile() {
    if(mPackageInfo != null)        
        {
File varFC9C2C7F2B1B79BD901FB4B96215DB24_706686622 =             mPackageInfo.getDataDirFile();
            varFC9C2C7F2B1B79BD901FB4B96215DB24_706686622.addTaint(taint);
            return varFC9C2C7F2B1B79BD901FB4B96215DB24_706686622;
        } //End block
        RuntimeException varEE904A2D709F2CDD39CAD0AF95215C1A_316924150 = new RuntimeException("Not supported in system context");
        varEE904A2D709F2CDD39CAD0AF95215C1A_316924150.addTaint(taint);
        throw varEE904A2D709F2CDD39CAD0AF95215C1A_316924150;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getDataDirFile();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.458 -0400", hash_original_method = "217ABBE8E0BC68B3B120E02EA884E102", hash_generated_method = "A91D02FADCD12AC3CF6C2D6CD140C25A")
    @Override
    public File getDir(String name, int mode) {
        addTaint(mode);
        addTaint(name.getTaint());
        name = "app_" + name;
        File file = makeFilename(getDataDirFile(), name);
    if(!file.exists())        
        {
            file.mkdir();
            setFilePermissionsFromMode(file.getPath(), mode,
                    FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH);
        } //End block
File varADCB75793FA1DABACC5DEBFFAE466050_1985561616 =         file;
        varADCB75793FA1DABACC5DEBFFAE466050_1985561616.addTaint(taint);
        return varADCB75793FA1DABACC5DEBFFAE466050_1985561616;
        // ---------- Original Method ----------
        //name = "app_" + name;
        //File file = makeFilename(getDataDirFile(), name);
        //if (!file.exists()) {
            //file.mkdir();
            //setFilePermissionsFromMode(file.getPath(), mode,
                    //FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH);
        //}
        //return file;
    }

    
        static ContextImpl createSystemContext(ActivityThread mainThread) {
        ContextImpl context = new ContextImpl();
        context.init(Resources.getSystem(), mainThread);
        return context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.458 -0400", hash_original_method = "32CF6005086B5520DA4AE96ECAD890BA", hash_generated_method = "AE2CC5C57D9D5C26CA316310EFA3A3B8")
    final void init(LoadedApk packageInfo,
            IBinder activityToken, ActivityThread mainThread) {
        addTaint(mainThread.getTaint());
        addTaint(activityToken.getTaint());
        addTaint(packageInfo.getTaint());
        init(packageInfo, activityToken, mainThread, null, null);
        // ---------- Original Method ----------
        //init(packageInfo, activityToken, mainThread, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.460 -0400", hash_original_method = "617B56367877BE6D5351978E32679FCB", hash_generated_method = "3BC163CC2102C44B3CFCAD183744CCC5")
    final void init(LoadedApk packageInfo,
                IBinder activityToken, ActivityThread mainThread,
                Resources container, String basePackageName) {
        addTaint(activityToken.getTaint());
        mPackageInfo = packageInfo;
        mBasePackageName = basePackageName != null ? basePackageName : packageInfo.mPackageName;
        mResources = mPackageInfo.getResources(mainThread);
    if(mResources != null && container != null
                && container.getCompatibilityInfo().applicationScale !=
                        mResources.getCompatibilityInfo().applicationScale)        
        {
    if(DEBUG)            
            {
                Log.d(TAG, "loaded context has different scaling. Using container's" +
                        " compatiblity info:" + container.getDisplayMetrics());
            } //End block
            mResources = mainThread.getTopLevelResources(
                    mPackageInfo.getResDir(), container.getCompatibilityInfo());
        } //End block
        mMainThread = mainThread;
        mContentResolver = new ApplicationContentResolver(this, mainThread);
        setActivityToken(activityToken);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.462 -0400", hash_original_method = "A01AC1DE8A0942D58F790AE1580128F4", hash_generated_method = "B64720F78160A873470409736052901F")
    final void init(Resources resources, ActivityThread mainThread) {
        mPackageInfo = null;
        mBasePackageName = null;
        mResources = resources;
        mMainThread = mainThread;
        mContentResolver = new ApplicationContentResolver(this, mainThread);
        // ---------- Original Method ----------
        //mPackageInfo = null;
        //mBasePackageName = null;
        //mResources = resources;
        //mMainThread = mainThread;
        //mContentResolver = new ApplicationContentResolver(this, mainThread);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.462 -0400", hash_original_method = "3668A95D26BB557CD7264A8982F20E37", hash_generated_method = "AEFCCA08892C84D675AD5641AAB08075")
    final void scheduleFinalCleanup(String who, String what) {
        addTaint(what.getTaint());
        addTaint(who.getTaint());
        mMainThread.scheduleContextCleanup(this, who, what);
        // ---------- Original Method ----------
        //mMainThread.scheduleContextCleanup(this, who, what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.463 -0400", hash_original_method = "0501008D8AD4AD5FA54A7545814DC0B6", hash_generated_method = "54C566E7BE538AE9A5BF1A18440BA5CE")
    final void performFinalCleanup(String who, String what) {
        addTaint(what.getTaint());
        addTaint(who.getTaint());
        mPackageInfo.removeContextRegistrations(getOuterContext(), who, what);
        // ---------- Original Method ----------
        //mPackageInfo.removeContextRegistrations(getOuterContext(), who, what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.464 -0400", hash_original_method = "00E338AD03CD22E7A509C63ABE7257F4", hash_generated_method = "917ED8976D4343C932A58D774C44FF99")
    final Context getReceiverRestrictedContext() {
    if(mReceiverRestrictedContext != null)        
        {
Context varA84ADA944216C52FAC66287846BC900D_1172854588 =             mReceiverRestrictedContext;
            varA84ADA944216C52FAC66287846BC900D_1172854588.addTaint(taint);
            return varA84ADA944216C52FAC66287846BC900D_1172854588;
        } //End block
Context var7BF64381736836E6D5B8EFBEBA0DD76E_434331944 =         mReceiverRestrictedContext = new ReceiverRestrictedContext(getOuterContext());
        var7BF64381736836E6D5B8EFBEBA0DD76E_434331944.addTaint(taint);
        return var7BF64381736836E6D5B8EFBEBA0DD76E_434331944;
        // ---------- Original Method ----------
        //if (mReceiverRestrictedContext != null) {
            //return mReceiverRestrictedContext;
        //}
        //return mReceiverRestrictedContext = new ReceiverRestrictedContext(getOuterContext());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.466 -0400", hash_original_method = "909971A42CA4D34B6A2AABA7AFFB96CE", hash_generated_method = "C4C31AC20FA544B3334C8E032915E0EF")
    final void setActivityToken(IBinder token) {
        mActivityToken = token;
        // ---------- Original Method ----------
        //mActivityToken = token;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.468 -0400", hash_original_method = "A74250CBDFD89C9F601A5AA3ED01CDC8", hash_generated_method = "F5D9056DA7F9C25752FDC44D6CB7B93B")
    final void setOuterContext(Context context) {
        mOuterContext = context;
        // ---------- Original Method ----------
        //mOuterContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.469 -0400", hash_original_method = "03C284D73757410812309249CAB76117", hash_generated_method = "42CE6B7B9F0266042C073BA97B9F3B20")
    final Context getOuterContext() {
Context var05221853CA1248996DC6A0DB070356A2_1199708691 =         mOuterContext;
        var05221853CA1248996DC6A0DB070356A2_1199708691.addTaint(taint);
        return var05221853CA1248996DC6A0DB070356A2_1199708691;
        // ---------- Original Method ----------
        //return mOuterContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.470 -0400", hash_original_method = "D32D1A589CFC02641AF8A3133A37BC7F", hash_generated_method = "CAD026027F2E1AF9093717BC4A23D463")
    final IBinder getActivityToken() {
IBinder var776483BEB0D8BCC1373C51E8861CFB6F_909169695 =         mActivityToken;
        var776483BEB0D8BCC1373C51E8861CFB6F_909169695.addTaint(taint);
        return var776483BEB0D8BCC1373C51E8861CFB6F_909169695;
        // ---------- Original Method ----------
        //return mActivityToken;
    }

    
        static void setFilePermissionsFromMode(String name, int mode,
            int extraPermissions) {
        int perms = FileUtils.S_IRUSR|FileUtils.S_IWUSR
            |FileUtils.S_IRGRP|FileUtils.S_IWGRP
            |extraPermissions;
        if ((mode&MODE_WORLD_READABLE) != 0) {
            perms |= FileUtils.S_IROTH;
        }
        if ((mode&MODE_WORLD_WRITEABLE) != 0) {
            perms |= FileUtils.S_IWOTH;
        }
        if (DEBUG) {
            Log.i(TAG, "File " + name + ": mode=0x" + Integer.toHexString(mode)
                  + ", perms=0x" + Integer.toHexString(perms));
        }
        FileUtils.setPermissions(name, perms, -1, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.473 -0400", hash_original_method = "B435A8710874F18AA5DE97F01977E23C", hash_generated_method = "50420C28798D3B291C6F08513706EBCB")
    private File validateFilePath(String name, boolean createDirectory) {
        addTaint(createDirectory);
        addTaint(name.getTaint());
        File dir;
        File f;
    if(name.charAt(0) == File.separatorChar)        
        {
            String dirPath = name.substring(0, name.lastIndexOf(File.separatorChar));
            dir = new File(dirPath);
            name = name.substring(name.lastIndexOf(File.separatorChar));
            f = new File(dir, name);
        } //End block
        else
        {
            dir = getDatabasesDir();
            f = makeFilename(dir, name);
        } //End block
    if(createDirectory && !dir.isDirectory() && dir.mkdir())        
        {
            FileUtils.setPermissions(dir.getPath(),
                FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                -1, -1);
        } //End block
File varABE3CFB53FE4A79F34CB25BC80BFD6E2_1165472201 =         f;
        varABE3CFB53FE4A79F34CB25BC80BFD6E2_1165472201.addTaint(taint);
        return varABE3CFB53FE4A79F34CB25BC80BFD6E2_1165472201;
        // ---------- Original Method ----------
        //File dir;
        //File f;
        //if (name.charAt(0) == File.separatorChar) {
            //String dirPath = name.substring(0, name.lastIndexOf(File.separatorChar));
            //dir = new File(dirPath);
            //name = name.substring(name.lastIndexOf(File.separatorChar));
            //f = new File(dir, name);
        //} else {
            //dir = getDatabasesDir();
            //f = makeFilename(dir, name);
        //}
        //if (createDirectory && !dir.isDirectory() && dir.mkdir()) {
            //FileUtils.setPermissions(dir.getPath(),
                //FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                //-1, -1);
        //}
        //return f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.474 -0400", hash_original_method = "E9A305FD20BBA1C0FB0979159F7000FC", hash_generated_method = "BBEB6B5EC033D8693889F5F25BEE2387")
    private File makeFilename(File base, String name) {
        addTaint(name.getTaint());
        addTaint(base.getTaint());
    if(name.indexOf(File.separatorChar) < 0)        
        {
File var1737453552AEDF3042D01F5D328877B0_907809950 =             new File(base, name);
            var1737453552AEDF3042D01F5D328877B0_907809950.addTaint(taint);
            return var1737453552AEDF3042D01F5D328877B0_907809950;
        } //End block
        IllegalArgumentException var43A7391A8C864B703618A9E060576B77_1622783141 = new IllegalArgumentException(
                "File " + name + " contains a path separator");
        var43A7391A8C864B703618A9E060576B77_1622783141.addTaint(taint);
        throw var43A7391A8C864B703618A9E060576B77_1622783141;
        // ---------- Original Method ----------
        //if (name.indexOf(File.separatorChar) < 0) {
            //return new File(base, name);
        //}
        //throw new IllegalArgumentException(
                //"File " + name + " contains a path separator");
    }

    
    static class ServiceFetcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.474 -0400", hash_original_field = "11138EF8AAFCAE7E2D7F37AF352B0770", hash_generated_field = "20F7EDA162164996331945812DFD02D4")

        int mContextCacheIndex = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.474 -0400", hash_original_method = "89135ACC7FF80D7CE959D5207760FBC6", hash_generated_method = "89135ACC7FF80D7CE959D5207760FBC6")
        public ServiceFetcher ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.477 -0400", hash_original_method = "B6729E9AD3191DC45FFEF069242EB9AE", hash_generated_method = "53FF2E1A4E58528DE4D8D8E244D4AA76")
        public Object getService(ContextImpl ctx) {
            addTaint(ctx.getTaint());
            ArrayList<Object> cache = ctx.mServiceCache;
            Object service;
            synchronized
(cache)            {
    if(cache.size() == 0)                
                {
for(int i = 0;i < sNextPerContextServiceCacheIndex;i++)
                    {
                        cache.add(null);
                    } //End block
                } //End block
                else
                {
                    service = cache.get(mContextCacheIndex);
    if(service != null)                    
                    {
Object var18881A382C668272945CA08D6E19E173_1393474115 =                         service;
                        var18881A382C668272945CA08D6E19E173_1393474115.addTaint(taint);
                        return var18881A382C668272945CA08D6E19E173_1393474115;
                    } //End block
                } //End block
                service = createService(ctx);
                cache.set(mContextCacheIndex, service);
Object var18881A382C668272945CA08D6E19E173_895790776 =                 service;
                var18881A382C668272945CA08D6E19E173_895790776.addTaint(taint);
                return var18881A382C668272945CA08D6E19E173_895790776;
            } //End block
            // ---------- Original Method ----------
            //ArrayList<Object> cache = ctx.mServiceCache;
            //Object service;
            //synchronized (cache) {
                //if (cache.size() == 0) {
                    //for (int i = 0; i < sNextPerContextServiceCacheIndex; i++) {
                        //cache.add(null);
                    //}
                //} else {
                    //service = cache.get(mContextCacheIndex);
                    //if (service != null) {
                        //return service;
                    //}
                //}
                //service = createService(ctx);
                //cache.set(mContextCacheIndex, service);
                //return service;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.478 -0400", hash_original_method = "46ECB6FD3C57198589BC43EC5E83533F", hash_generated_method = "736FBEDEF02FB3036EADA2432C7A6701")
        public Object createService(ContextImpl ctx) {
            addTaint(ctx.getTaint());
            RuntimeException varECF25F51942B946710F937BB139F9A1F_1574664862 = new RuntimeException("Not implemented");
            varECF25F51942B946710F937BB139F9A1F_1574664862.addTaint(taint);
            throw varECF25F51942B946710F937BB139F9A1F_1574664862;
            // ---------- Original Method ----------
            //throw new RuntimeException("Not implemented");
        }

        
    }


    
    abstract static class StaticServiceFetcher extends ServiceFetcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.478 -0400", hash_original_field = "ADDD4BB358F7AD43A1A174EC547D00F5", hash_generated_field = "5F0E5A47E62743034DEA32CA1075BE94")

        private Object mCachedInstance;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.478 -0400", hash_original_method = "8F4B3E9510C7190A989D0DB2833CAA4A", hash_generated_method = "8F4B3E9510C7190A989D0DB2833CAA4A")
        public StaticServiceFetcher ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.479 -0400", hash_original_method = "1B75D0F6FCB51C941C36BEE235F0DE1C", hash_generated_method = "4D42C1045A3729096CF5504CB876E9CA")
        @Override
        public final Object getService(ContextImpl unused) {
            addTaint(unused.getTaint());
            synchronized
(StaticServiceFetcher.this)            {
                Object service = mCachedInstance;
    if(service != null)                
                {
Object var18881A382C668272945CA08D6E19E173_1456138899 =                     service;
                    var18881A382C668272945CA08D6E19E173_1456138899.addTaint(taint);
                    return var18881A382C668272945CA08D6E19E173_1456138899;
                } //End block
Object var43F21808E64BDDCA0A2A490DACFF475F_135557154 =                 mCachedInstance = createStaticService();
                var43F21808E64BDDCA0A2A490DACFF475F_135557154.addTaint(taint);
                return var43F21808E64BDDCA0A2A490DACFF475F_135557154;
            } //End block
            // ---------- Original Method ----------
            //synchronized (StaticServiceFetcher.this) {
                //Object service = mCachedInstance;
                //if (service != null) {
                    //return service;
                //}
                //return mCachedInstance = createStaticService();
            //}
        }

        
        public abstract Object createStaticService();

        
    }


    
    private static final class ApplicationContentResolver extends ContentResolver {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.479 -0400", hash_original_field = "46FDB2388003D2F8D58B7436C6E7B099", hash_generated_field = "3BD1B37D989628ECBEBF06B5281DCE58")

        private ActivityThread mMainThread;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.480 -0400", hash_original_method = "FC2218F5409D3B615253B9FADC78F4F0", hash_generated_method = "359DBF2FD41658189FAAF78BDED31F8F")
        public  ApplicationContentResolver(Context context, ActivityThread mainThread) {
            super(context);
            addTaint(context.getTaint());
            mMainThread = mainThread;
            // ---------- Original Method ----------
            //mMainThread = mainThread;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.480 -0400", hash_original_method = "1D54690CD1C75C22354AFE636FCBB54C", hash_generated_method = "D41BBAC3E610522788F1FF9955815ED2")
        @Override
        protected IContentProvider acquireProvider(Context context, String name) {
            addTaint(name.getTaint());
            addTaint(context.getTaint());
IContentProvider var504CEE3172AE9DFD9087963E4D1C26EC_689823030 =             mMainThread.acquireProvider(context, name);
            var504CEE3172AE9DFD9087963E4D1C26EC_689823030.addTaint(taint);
            return var504CEE3172AE9DFD9087963E4D1C26EC_689823030;
            // ---------- Original Method ----------
            //return mMainThread.acquireProvider(context, name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.481 -0400", hash_original_method = "88B28437EF544809DF8D55FC39CCF726", hash_generated_method = "1011F58F7140E7182DB2EEF1339131B9")
        @Override
        protected IContentProvider acquireExistingProvider(Context context, String name) {
            addTaint(name.getTaint());
            addTaint(context.getTaint());
IContentProvider var1E904BFF275D0D05BE64E7DBFB56C1C8_423702531 =             mMainThread.acquireExistingProvider(context, name);
            var1E904BFF275D0D05BE64E7DBFB56C1C8_423702531.addTaint(taint);
            return var1E904BFF275D0D05BE64E7DBFB56C1C8_423702531;
            // ---------- Original Method ----------
            //return mMainThread.acquireExistingProvider(context, name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.481 -0400", hash_original_method = "2FE34FA97A494E67E9164BEE654A40D1", hash_generated_method = "7581DE49A5F47ED5DC32644371FF1696")
        @Override
        public boolean releaseProvider(IContentProvider provider) {
            addTaint(provider.getTaint());
            boolean var8D325C1832521ECE73A55AE353080AA9_637766653 = (mMainThread.releaseProvider(provider));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_268866028 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_268866028;
            // ---------- Original Method ----------
            //return mMainThread.releaseProvider(provider);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.482 -0400", hash_original_field = "DBC1AC9CDA1CA721403986EF486E93FD", hash_generated_field = "1DD3236631063C4A39FED7CD2DD748A1")

    private final static String TAG = "ApplicationContext";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.482 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "7841AA055B417A7E8C3D727A4ADDD91D")

    private final static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.482 -0400", hash_original_field = "6207FCFCFA690538862FA691A68C4AB1", hash_generated_field = "C28D37FE74542C16238F74BB2031E102")

    private static final HashMap<String, SharedPreferencesImpl> sSharedPrefs = new HashMap<String, SharedPreferencesImpl>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.482 -0400", hash_original_field = "8606DB58F4504BB95F437927A1118D9A", hash_generated_field = "24FE645B537D86D59BF761DAE24AA3EA")

    private static final String[] EMPTY_FILE_LIST = {};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.482 -0400", hash_original_field = "13BBA1D4EB247DCAB6C28F8022170B75", hash_generated_field = "4284E1216B34B381ED919CF71692E867")

    private static final HashMap<String, ServiceFetcher> SYSTEM_SERVICE_MAP = new HashMap<String, ServiceFetcher>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.482 -0400", hash_original_field = "27718F14D4140FEAE2ACB2C6900056C4", hash_generated_field = "BD87370C7C88691CA93E0A9F7822E99D")

    private static int sNextPerContextServiceCacheIndex = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.315 -0400", hash_original_field = "7DB09CDC66836808CD50648C6519F6AD", hash_generated_field = "CD2A659A34AB859F9017A1B2CEB8A4E2")

    private static ServiceFetcher WALLPAPER_FETCHER = new ServiceFetcher() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.315 -0400", hash_original_method = "08C2B02667D273FDC254F58A2074D83A", hash_generated_method = "666779A41202E9B3348BBA99A71CBFCC")
        public Object createService(ContextImpl ctx) {
            Object varB4EAC82CA7396A68D541C85D26508E83_382677315 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_382677315 = new WallpaperManager(ctx.getOuterContext(),
                        ctx.mMainThread.getHandler());
            addTaint(ctx.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_382677315.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_382677315;
            
            
                        
        }

        
};
    static {
        registerService(ACCESSIBILITY_SERVICE, new ServiceFetcher() {
                public Object getService(ContextImpl ctx) {
                    return AccessibilityManager.getInstance(ctx);
                }});
        registerService(ACCOUNT_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    IBinder b = ServiceManager.getService(ACCOUNT_SERVICE);
                    IAccountManager service = IAccountManager.Stub.asInterface(b);
                    return new AccountManager(ctx, service);
                }});
        registerService(ACTIVITY_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new ActivityManager(ctx.getOuterContext(), ctx.mMainThread.getHandler());
                }});
        registerService(ALARM_SERVICE, new StaticServiceFetcher() {
                public Object createStaticService() {
                    IBinder b = ServiceManager.getService(ALARM_SERVICE);
                    IAlarmManager service = IAlarmManager.Stub.asInterface(b);
                    return new AlarmManager(service);
                }});
        registerService(AUDIO_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new AudioManager(ctx);
                }});
        registerService(CLIPBOARD_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new ClipboardManager(ctx.getOuterContext(),
                            ctx.mMainThread.getHandler());
                }});
        registerService(CONNECTIVITY_SERVICE, new StaticServiceFetcher() {
                public Object createStaticService() {
                    IBinder b = ServiceManager.getService(CONNECTIVITY_SERVICE);
                    return new ConnectivityManager(IConnectivityManager.Stub.asInterface(b));
                }});
        registerService(COUNTRY_DETECTOR, new StaticServiceFetcher() {
                public Object createStaticService() {
                    IBinder b = ServiceManager.getService(COUNTRY_DETECTOR);
                    return new CountryDetector(ICountryDetector.Stub.asInterface(b));
                }});
        registerService(DEVICE_POLICY_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return DevicePolicyManager.create(ctx, ctx.mMainThread.getHandler());
                }});
        registerService(DOWNLOAD_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new DownloadManager(ctx.getContentResolver(), ctx.getPackageName());
                }});
        registerService(NFC_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new NfcManager(ctx);
                }});
        registerService(DROPBOX_SERVICE, new StaticServiceFetcher() {
                public Object createStaticService() {
                    return createDropBoxManager();
                }});
        registerService(INPUT_METHOD_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return InputMethodManager.getInstance(ctx);
                }});
        registerService(TEXT_SERVICES_MANAGER_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return TextServicesManager.getInstance();
                }});
        registerService(KEYGUARD_SERVICE, new ServiceFetcher() {
                public Object getService(ContextImpl ctx) {
                    return new KeyguardManager();
                }});
        registerService(LAYOUT_INFLATER_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return PolicyManager.makeNewLayoutInflater(ctx.getOuterContext());
                }});
        registerService(LOCATION_SERVICE, new StaticServiceFetcher() {
                public Object createStaticService() {
                    IBinder b = ServiceManager.getService(LOCATION_SERVICE);
                    return new LocationManager(ILocationManager.Stub.asInterface(b));
                }});
        registerService(NETWORK_POLICY_SERVICE, new ServiceFetcher() {
            @Override
            public Object createService(ContextImpl ctx) {
                return new NetworkPolicyManager(INetworkPolicyManager.Stub.asInterface(
                        ServiceManager.getService(NETWORK_POLICY_SERVICE)));
            }
        });
        registerService(NOTIFICATION_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    final Context outerContext = ctx.getOuterContext();
                    return new NotificationManager(
                        new ContextThemeWrapper(outerContext,
                                Resources.selectSystemTheme(0,
                                        outerContext.getApplicationInfo().targetSdkVersion,
                                        com.android.internal.R.style.Theme_Dialog,
                                        com.android.internal.R.style.Theme_Holo_Dialog,
                                        com.android.internal.R.style.Theme_DeviceDefault_Dialog)),
                        ctx.mMainThread.getHandler());
                }});
        registerService(POWER_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    IBinder b = ServiceManager.getService(POWER_SERVICE);
                    IPowerManager service = IPowerManager.Stub.asInterface(b);
                    return new PowerManager(service, ctx.mMainThread.getHandler());
                }});
        registerService(SEARCH_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new SearchManager(ctx.getOuterContext(),
                            ctx.mMainThread.getHandler());
                }});
        registerService(SENSOR_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new SensorManager(ctx.mMainThread.getHandler().getLooper());
                }});
        registerService(STATUS_BAR_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new StatusBarManager(ctx.getOuterContext());
                }});
        registerService(STORAGE_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    try {
                        return new StorageManager(ctx.mMainThread.getHandler().getLooper());
                    } catch (RemoteException rex) {
                        Log.e(TAG, "Failed to create StorageManager", rex);
                        return null;
                    }
                }});
        registerService(TELEPHONY_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new TelephonyManager(ctx.getOuterContext());
                }});
        registerService(THROTTLE_SERVICE, new StaticServiceFetcher() {
                public Object createStaticService() {
                    IBinder b = ServiceManager.getService(THROTTLE_SERVICE);
                    return new ThrottleManager(IThrottleManager.Stub.asInterface(b));
                }});
        registerService(UI_MODE_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new UiModeManager();
                }});
        registerService(USB_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    IBinder b = ServiceManager.getService(USB_SERVICE);
                    return new UsbManager(ctx, IUsbManager.Stub.asInterface(b));
                }});
        registerService(VIBRATOR_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new Vibrator();
                }});
        registerService(WALLPAPER_SERVICE, WALLPAPER_FETCHER);
        registerService(WIFI_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    IBinder b = ServiceManager.getService(WIFI_SERVICE);
                    IWifiManager service = IWifiManager.Stub.asInterface(b);
                    return new WifiManager(service, ctx.mMainThread.getHandler());
                }});
        registerService(WIFI_P2P_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    IBinder b = ServiceManager.getService(WIFI_P2P_SERVICE);
                    IWifiP2pManager service = IWifiP2pManager.Stub.asInterface(b);
                    return new WifiP2pManager(service);
                }});
        registerService(WINDOW_SERVICE, new ServiceFetcher() {
                public Object getService(ContextImpl ctx) {
                    return WindowManagerImpl.getDefault(ctx.mPackageInfo.mCompatibilityInfo);
                }});
    }
    
    // orphaned legacy field
    private DroidSafeContentResolver contentResolver;
    
    // orphaned legacy field
    private SensorManager sensorManager;
    
}

