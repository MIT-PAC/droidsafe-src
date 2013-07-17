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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.356 -0400", hash_original_method = "7FD4094CD16832D548D3CEFA622075F6", hash_generated_method = "26ACA97A400E372B38EB9A675A8132FB")
      ReceiverRestrictedContext(Context base) {
        super(base);
        addTaint(base.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.357 -0400", hash_original_method = "E79FC2581462A23AEE3B4180EBBDA608", hash_generated_method = "A8971A929B7E203FBDAD9169059078BB")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
Intent varD535A24B470170C9E7EA08ED846B5DCB_1034801259 =         registerReceiver(receiver, filter, null, null);
        varD535A24B470170C9E7EA08ED846B5DCB_1034801259.addTaint(taint);
        return varD535A24B470170C9E7EA08ED846B5DCB_1034801259;
        // ---------- Original Method ----------
        //return registerReceiver(receiver, filter, null, null);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.357 -0400", hash_original_method = "7DBE869AA37665F34E0D6939DBC75DAB", hash_generated_method = "DC46203FF04BCD6443E30EFAFDE4FBD2")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter,
            String broadcastPermission, Handler scheduler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(scheduler.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
        ReceiverCallNotAllowedException var407F1997E2CF2D1DCB2F742C7E6ABC2A_1199427851 = new ReceiverCallNotAllowedException(
                "IntentReceiver components are not allowed to register to receive intents");
        var407F1997E2CF2D1DCB2F742C7E6ABC2A_1199427851.addTaint(taint);
        throw var407F1997E2CF2D1DCB2F742C7E6ABC2A_1199427851;
        // ---------- Original Method ----------
        //throw new ReceiverCallNotAllowedException(
                //"IntentReceiver components are not allowed to register to receive intents");
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.359 -0400", hash_original_method = "E81E60407BE1AC3446285185653F6DEC", hash_generated_method = "C42568A02D8CB0D48DCAB548BC3B7FC2")
    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        addTaint(flags);
        addTaint(conn.getTaint());
        addTaint(service.getTaint());
        ReceiverCallNotAllowedException var729F58CF16FF58058AE63A05FEB9E78F_1249761753 = new ReceiverCallNotAllowedException(
                "IntentReceiver components are not allowed to bind to services");
        var729F58CF16FF58058AE63A05FEB9E78F_1249761753.addTaint(taint);
        throw var729F58CF16FF58058AE63A05FEB9E78F_1249761753;
        // ---------- Original Method ----------
        //throw new ReceiverCallNotAllowedException(
                //"IntentReceiver components are not allowed to bind to services");
    }

    
}

public class ContextImpl extends Context {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.362 -0400", hash_original_field = "F26EF77FADF5A57881907E560F2D0D42", hash_generated_field = "EDE05288DA1A1347727FFDBB84784438")

    LoadedApk mPackageInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.362 -0400", hash_original_field = "150BB4175FE9139A54D3AF314D73B91A", hash_generated_field = "A7EF77D1F0E656D4474B6E8D2DBB3B3B")

    private String mBasePackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.363 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.363 -0400", hash_original_field = "46FDB2388003D2F8D58B7436C6E7B099", hash_generated_field = "DAA5CF027F30E341CB6E5B438E9919B8")

    ActivityThread mMainThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.364 -0400", hash_original_field = "D10CC1136F43CB8D3AAE1B13B8FBB4DD", hash_generated_field = "34FBCC1608A4936A90F9DF98F1E48881")

    private Context mOuterContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.364 -0400", hash_original_field = "2BE449269B1F4C70928A0DCFE94621E0", hash_generated_field = "14A36E3A1E55C5D74F222A902E5EE0F2")

    private IBinder mActivityToken = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.364 -0400", hash_original_field = "AA30776C328196000CD028A324C818FD", hash_generated_field = "AF9BE5AAF7F29484886F2FDF1856DC2E")

    private ApplicationContentResolver mContentResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.365 -0400", hash_original_field = "CE5AF0AE42F0D6CB1908A11BF7CF16FA", hash_generated_field = "299CB1540B8056273D436B48FEF6A0EE")

    private int mThemeResource = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.366 -0400", hash_original_field = "78906EEF842F20C56E3EE018C7F5BDA7", hash_generated_field = "ECFB75E383EB1877735FF15B18C148C8")

    private Resources.Theme mTheme = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.366 -0400", hash_original_field = "7D66DD2494F037ED6AC341A00B2AD467", hash_generated_field = "7DEF40BE9F330F69BEFB5B68E8125FE9")

    private PackageManager mPackageManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.367 -0400", hash_original_field = "B21243549DB3C4FC35772D5A6CD22B8A", hash_generated_field = "822E0B86F97CBCA30BEAC92D7074EF2C")

    private Context mReceiverRestrictedContext = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.367 -0400", hash_original_field = "ADD7E2B2442A13369398593FA842CF51", hash_generated_field = "02C747C3724FCFC2B7C6A9A22D88CF16")

    private boolean mRestricted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.368 -0400", hash_original_field = "99CA2AB98020F687D6F8CAD3BC28A985", hash_generated_field = "E2A875EF987A77EEC850F20D740B8615")

    private final Object mSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.368 -0400", hash_original_field = "31F3077B8747A5A9D3290AEC5630F5D0", hash_generated_field = "BD1C0920C019BE593BE14FA4F0428E82")

    private File mDatabasesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.368 -0400", hash_original_field = "8672D560D8B148EC9C43183252399EC3", hash_generated_field = "BEE1171B4DEF7C018E6FF18B5E39497F")

    private File mPreferencesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.369 -0400", hash_original_field = "73A71AF7C46968236F3164132333F1FD", hash_generated_field = "836A24647D35486771B3D976EA5B50CE")

    private File mFilesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.369 -0400", hash_original_field = "0635BA74861D7387F8A35531AB504605", hash_generated_field = "DAD88E122F93A5C508E14D87A3BF9A70")

    private File mCacheDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.369 -0400", hash_original_field = "52A2417455D76879BFA170FFF26775B5", hash_generated_field = "BC229612E30213AE76D95F88EDC2856F")

    private File mObbDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.370 -0400", hash_original_field = "E65B49FD891CDDD102DA56E94053DEBA", hash_generated_field = "7FECE535D8094A9FC9D153E6776699B3")

    private File mExternalFilesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.370 -0400", hash_original_field = "C9602422414763F3A8137ECD73997A49", hash_generated_field = "507D0ED70658593E79745C0F5D91041A")

    private File mExternalCacheDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.370 -0400", hash_original_field = "9CDF81E446283F70EAFFA44FDC69EEA5", hash_generated_field = "D63EC7F2931BD6BAD4B3EF85C123726C")

    final ArrayList<Object> mServiceCache = new ArrayList<Object>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-11 17:07:32.348 -0400", hash_original_method = "D626E4F654DE4449ACE9581A8359F0B3", hash_generated_method = "EE67F93CB8AD578637611B4EAAB10CB4")
	public
      ContextImpl() {
        mOuterContext = this;
        // ---------- Original Method ----------
        //mOuterContext = this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.373 -0400", hash_original_method = "9A0B254F42B92476EDBA974C3F238399", hash_generated_method = "953194B41378DE16C60A8443D4FF5403")
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

    
    @DSModeled(DSC.SPEC)
    private static void registerService(String serviceName, ServiceFetcher fetcher) {
        if (!(fetcher instanceof StaticServiceFetcher)) {
            fetcher.mContextCacheIndex = sNextPerContextServiceCacheIndex++;
        }
        SYSTEM_SERVICE_MAP.put(serviceName, fetcher);
    }

    
    @DSModeled(DSC.SPEC)
    static ContextImpl getImpl(Context context) {
        Context nextContext;
        while ((context instanceof ContextWrapper) &&
                (nextContext=((ContextWrapper)context).getBaseContext()) != null) {
            context = nextContext;
        }
        return (ContextImpl)context;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.376 -0400", hash_original_method = "E29B1E8B8DA0771E0791531B452826D2", hash_generated_method = "2690539A3972C1DA33BA9CA90DA71176")
    @Override
    public AssetManager getAssets() {
AssetManager var09CC54E28D033A2A797092212493867A_1919776121 =         mResources.getAssets();
        var09CC54E28D033A2A797092212493867A_1919776121.addTaint(taint);
        return var09CC54E28D033A2A797092212493867A_1919776121;
        // ---------- Original Method ----------
        //return mResources.getAssets();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.377 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "DD36D0E7609F777BFD6D65C916636D64")
    @Override
    public Resources getResources() {
Resources var346B953D96D762F7FED561E83C1656CA_1320195431 =         mResources;
        var346B953D96D762F7FED561E83C1656CA_1320195431.addTaint(taint);
        return var346B953D96D762F7FED561E83C1656CA_1320195431;
        // ---------- Original Method ----------
        //return mResources;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.378 -0400", hash_original_method = "BD4B6640BF321317C66EC62ED1810EDC", hash_generated_method = "242256D595907B80632CF0772C7B1A6E")
    @Override
    public PackageManager getPackageManager() {
        if(mPackageManager != null)        
        {
PackageManager varC7B8C71CB31DF77623EA48045969A5A3_389192712 =             mPackageManager;
            varC7B8C71CB31DF77623EA48045969A5A3_389192712.addTaint(taint);
            return varC7B8C71CB31DF77623EA48045969A5A3_389192712;
        } //End block
        IPackageManager pm = ActivityThread.getPackageManager();
        if(pm != null)        
        {
PackageManager var439715D8D8C22EAB4975899C0BC19C97_1419448046 =             (mPackageManager = new ApplicationPackageManager(this, pm));
            var439715D8D8C22EAB4975899C0BC19C97_1419448046.addTaint(taint);
            return var439715D8D8C22EAB4975899C0BC19C97_1419448046;
        } //End block
PackageManager var540C13E9E156B687226421B24F2DF178_662187430 =         null;
        var540C13E9E156B687226421B24F2DF178_662187430.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_662187430;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.378 -0400", hash_original_method = "E4195DED98361134A039FE4C88A6F4B6", hash_generated_method = "F45EE039F095B3D25A7286EAC9E1F6CD")
    @Override
    public ContentResolver getContentResolver() {
ContentResolver var8F9DC2C8493C9EB20B434E13A678C351_611324885 =         mContentResolver;
        var8F9DC2C8493C9EB20B434E13A678C351_611324885.addTaint(taint);
        return var8F9DC2C8493C9EB20B434E13A678C351_611324885;
        // ---------- Original Method ----------
        //return mContentResolver;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.379 -0400", hash_original_method = "83F01A831E976E654749A9BEC1E37CC3", hash_generated_method = "3458F23B3E1E047923EDA6D4FBDE824D")
    @Override
    public Looper getMainLooper() {
Looper varED41AD3A274FCDD4F3CC86DDF274D901_300116311 =         mMainThread.getLooper();
        varED41AD3A274FCDD4F3CC86DDF274D901_300116311.addTaint(taint);
        return varED41AD3A274FCDD4F3CC86DDF274D901_300116311;
        // ---------- Original Method ----------
        //return mMainThread.getLooper();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.379 -0400", hash_original_method = "EEBDE58C6E671C89B231CC2A7DC13506", hash_generated_method = "94E5C6635909174E8B515EF35780149F")
    @Override
    public Context getApplicationContext() {
Context varF9043C0E82871E798A752CA9E2B9F901_2145974227 =         (mPackageInfo != null) ?
                mPackageInfo.getApplication() : mMainThread.getApplication();
        varF9043C0E82871E798A752CA9E2B9F901_2145974227.addTaint(taint);
        return varF9043C0E82871E798A752CA9E2B9F901_2145974227;
        // ---------- Original Method ----------
        //return (mPackageInfo != null) ?
                //mPackageInfo.getApplication() : mMainThread.getApplication();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.380 -0400", hash_original_method = "B9D345E863E2753C5A0BB0CFD009BEA6", hash_generated_method = "DAC2322817B2898A8DBFE4A50CECD38D")
    @Override
    public void setTheme(int resid) {
        mThemeResource = resid;
        // ---------- Original Method ----------
        //mThemeResource = resid;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.381 -0400", hash_original_method = "AE4733E1C9FA88CFC00EFC04FF1EA93F", hash_generated_method = "6704E68D01C96DF5C44A01DE17020DC0")
    @Override
    public int getThemeResId() {
        int var1A7BE5C50406CFB30A072C422592257E_28858390 = (mThemeResource);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1193642582 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1193642582;
        // ---------- Original Method ----------
        //return mThemeResource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.382 -0400", hash_original_method = "D6BB36732A764F444B4412949FAD7357", hash_generated_method = "DF65F479255A9B30C6265153A020D8E7")
    @Override
    public Resources.Theme getTheme() {
        if(mTheme == null)        
        {
            mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                    getOuterContext().getApplicationInfo().targetSdkVersion);
            mTheme = mResources.newTheme();
            mTheme.applyStyle(mThemeResource, true);
        } //End block
Resources.Theme var021DB673F568E8BD9EB3155CBE6DF295_380726344 =         mTheme;
        var021DB673F568E8BD9EB3155CBE6DF295_380726344.addTaint(taint);
        return var021DB673F568E8BD9EB3155CBE6DF295_380726344;
        // ---------- Original Method ----------
        //if (mTheme == null) {
            //mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                    //getOuterContext().getApplicationInfo().targetSdkVersion);
            //mTheme = mResources.newTheme();
            //mTheme.applyStyle(mThemeResource, true);
        //}
        //return mTheme;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.383 -0400", hash_original_method = "E4AD06E2DE5640E33DD0DE83076841CC", hash_generated_method = "8BD8067EACE39F0FB7BCDE4CBA3DD9EC")
    @Override
    public ClassLoader getClassLoader() {
ClassLoader var16F1A93B2F99E523726DFCDF4517DCE5_1267827733 =         mPackageInfo != null ?
                mPackageInfo.getClassLoader() : ClassLoader.getSystemClassLoader();
        var16F1A93B2F99E523726DFCDF4517DCE5_1267827733.addTaint(taint);
        return var16F1A93B2F99E523726DFCDF4517DCE5_1267827733;
        // ---------- Original Method ----------
        //return mPackageInfo != null ?
                //mPackageInfo.getClassLoader() : ClassLoader.getSystemClassLoader();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.383 -0400", hash_original_method = "C2ABF52241A6291268B401FAB7288697", hash_generated_method = "E9F88011CE8D8428C6FB80280E01C88E")
    @Override
    public String getPackageName() {
        if(mPackageInfo != null)        
        {
String varF4EF12C3F9E3305DAB52E25F8F73442B_1394017093 =             mPackageInfo.getPackageName();
            varF4EF12C3F9E3305DAB52E25F8F73442B_1394017093.addTaint(taint);
            return varF4EF12C3F9E3305DAB52E25F8F73442B_1394017093;
        } //End block
        RuntimeException varEE904A2D709F2CDD39CAD0AF95215C1A_1893685782 = new RuntimeException("Not supported in system context");
        varEE904A2D709F2CDD39CAD0AF95215C1A_1893685782.addTaint(taint);
        throw varEE904A2D709F2CDD39CAD0AF95215C1A_1893685782;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getPackageName();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.384 -0400", hash_original_method = "B6824C91AB2BEA3E97D1CD03B60D140A", hash_generated_method = "EBDBFD4E6CED7A5AB378E1C5B35F57E0")
    @Override
    public ApplicationInfo getApplicationInfo() {
        if(mPackageInfo != null)        
        {
ApplicationInfo var4B691FDD00B489A2B48EC32B158A39C7_552362804 =             mPackageInfo.getApplicationInfo();
            var4B691FDD00B489A2B48EC32B158A39C7_552362804.addTaint(taint);
            return var4B691FDD00B489A2B48EC32B158A39C7_552362804;
        } //End block
        RuntimeException varEE904A2D709F2CDD39CAD0AF95215C1A_408957416 = new RuntimeException("Not supported in system context");
        varEE904A2D709F2CDD39CAD0AF95215C1A_408957416.addTaint(taint);
        throw varEE904A2D709F2CDD39CAD0AF95215C1A_408957416;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getApplicationInfo();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.385 -0400", hash_original_method = "B40C4604E79523ED9CA9BD2DB89D9D21", hash_generated_method = "956006DEE0E1E15CC1FCB655C46C5DC9")
    @Override
    public String getPackageResourcePath() {
        if(mPackageInfo != null)        
        {
String var609075041E4A04BFC71DFBD66E2FBED9_375299230 =             mPackageInfo.getResDir();
            var609075041E4A04BFC71DFBD66E2FBED9_375299230.addTaint(taint);
            return var609075041E4A04BFC71DFBD66E2FBED9_375299230;
        } //End block
        RuntimeException varEE904A2D709F2CDD39CAD0AF95215C1A_950034235 = new RuntimeException("Not supported in system context");
        varEE904A2D709F2CDD39CAD0AF95215C1A_950034235.addTaint(taint);
        throw varEE904A2D709F2CDD39CAD0AF95215C1A_950034235;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getResDir();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.387 -0400", hash_original_method = "6299B0E465B0087370ABC2DD5D8DF3A0", hash_generated_method = "F6C584776FEBF00E390FE8E32F7237A1")
    @Override
    public String getPackageCodePath() {
        if(mPackageInfo != null)        
        {
String var497BC599628C573D3705051D9A60BE22_801416136 =             mPackageInfo.getAppDir();
            var497BC599628C573D3705051D9A60BE22_801416136.addTaint(taint);
            return var497BC599628C573D3705051D9A60BE22_801416136;
        } //End block
        RuntimeException varEE904A2D709F2CDD39CAD0AF95215C1A_1132215057 = new RuntimeException("Not supported in system context");
        varEE904A2D709F2CDD39CAD0AF95215C1A_1132215057.addTaint(taint);
        throw varEE904A2D709F2CDD39CAD0AF95215C1A_1132215057;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getAppDir();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.388 -0400", hash_original_method = "AB577AC8DAB754DCD42D8B905735EB0E", hash_generated_method = "B8057C6EBC25139E36730403777A0775")
    public File getSharedPrefsFile(String name) {
        addTaint(name.getTaint());
File var1E7D6E44AFED15D14645E57F196080B8_2107530578 =         makeFilename(getPreferencesDir(), name + ".xml");
        var1E7D6E44AFED15D14645E57F196080B8_2107530578.addTaint(taint);
        return var1E7D6E44AFED15D14645E57F196080B8_2107530578;
        // ---------- Original Method ----------
        //return makeFilename(getPreferencesDir(), name + ".xml");
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.391 -0400", hash_original_method = "B5A20353911F33A4DD3A6110C0300877", hash_generated_method = "58785FBF0B54119B6188C0CFF8576534")
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
SharedPreferences varA4DCFF844B7753D115259E5560FDE637_454598923 =                 sp;
                varA4DCFF844B7753D115259E5560FDE637_454598923.addTaint(taint);
                return varA4DCFF844B7753D115259E5560FDE637_454598923;
            } //End block
        } //End block
        if((mode & Context.MODE_MULTI_PROCESS) != 0 ||
            getApplicationInfo().targetSdkVersion < android.os.Build.VERSION_CODES.HONEYCOMB)        
        {
            sp.startReloadIfChangedUnexpectedly();
        } //End block
SharedPreferences varA4DCFF844B7753D115259E5560FDE637_1919627804 =         sp;
        varA4DCFF844B7753D115259E5560FDE637_1919627804.addTaint(taint);
        return varA4DCFF844B7753D115259E5560FDE637_1919627804;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.392 -0400", hash_original_method = "0A29125F4E4AA8A93CA3D1CE13216DA3", hash_generated_method = "72A54AFE8753DE4769C1205A0CB844B2")
    private File getPreferencesDir() {
        synchronized
(mSync)        {
            if(mPreferencesDir == null)            
            {
                mPreferencesDir = new File(getDataDirFile(), "shared_prefs");
            } //End block
File varB5580270F36BE30B06AE9DEFC8DEE79A_1241621129 =             mPreferencesDir;
            varB5580270F36BE30B06AE9DEFC8DEE79A_1241621129.addTaint(taint);
            return varB5580270F36BE30B06AE9DEFC8DEE79A_1241621129;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mPreferencesDir == null) {
                //mPreferencesDir = new File(getDataDirFile(), "shared_prefs");
            //}
            //return mPreferencesDir;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.393 -0400", hash_original_method = "99E1A62B7C8E5CCF8F9E6256C436E103", hash_generated_method = "A2AF8B736FE8611CEF7B38B892901D11")
    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        addTaint(name.getTaint());
        File f = makeFilename(getFilesDir(), name);
FileInputStream varE117E1656619F1101A221825116618B1_309339557 =         new FileInputStream(f);
        varE117E1656619F1101A221825116618B1_309339557.addTaint(taint);
        return varE117E1656619F1101A221825116618B1_309339557;
        // ---------- Original Method ----------
        //File f = makeFilename(getFilesDir(), name);
        //return new FileInputStream(f);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.395 -0400", hash_original_method = "8D0BF4576C7B4CFD18075B0F373C4195", hash_generated_method = "C0BB6AEB788AF40D7C10096988AE769E")
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
FileOutputStream varEF20B018C31FD4204B36935D484B0EEF_1872244961 =             fos;
            varEF20B018C31FD4204B36935D484B0EEF_1872244961.addTaint(taint);
            return varEF20B018C31FD4204B36935D484B0EEF_1872244961;
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
FileOutputStream varEF20B018C31FD4204B36935D484B0EEF_318676357 =         fos;
        varEF20B018C31FD4204B36935D484B0EEF_318676357.addTaint(taint);
        return varEF20B018C31FD4204B36935D484B0EEF_318676357;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.395 -0400", hash_original_method = "F16B6B6A1EABD28DB33653BAF5021B3A", hash_generated_method = "4055E0A79524434DACC4CA74F024F0F2")
    @Override
    public boolean deleteFile(String name) {
        addTaint(name.getTaint());
        File f = makeFilename(getFilesDir(), name);
        boolean varD09C522A4F6F8C6D66D204481533EF11_399306199 = (f.delete());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_59305795 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_59305795;
        // ---------- Original Method ----------
        //File f = makeFilename(getFilesDir(), name);
        //return f.delete();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.396 -0400", hash_original_method = "F3D2FFAF4E630F0552CFADCBAF494A59", hash_generated_method = "A0B2DB8E9096FAE7D974158C2DFE0484")
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
File var540C13E9E156B687226421B24F2DF178_248183639 =                     null;
                    var540C13E9E156B687226421B24F2DF178_248183639.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_248183639;
                } //End block
                FileUtils.setPermissions(
                        mFilesDir.getPath(),
                        FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                        -1, -1);
            } //End block
File varDDEB74CA65264268E92A9632171F02BD_15355723 =             mFilesDir;
            varDDEB74CA65264268E92A9632171F02BD_15355723.addTaint(taint);
            return varDDEB74CA65264268E92A9632171F02BD_15355723;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.398 -0400", hash_original_method = "E1CC83B0B5F678A7C2185F1397CC9FDE", hash_generated_method = "6E31C8D6A019FD8388F4374CE2F1E018")
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
File var540C13E9E156B687226421B24F2DF178_1760019551 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1760019551.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1760019551;
                } //End block
            } //End block
            if(type == null)            
            {
File var5CE0FFC467CE1E61F8F3D6EDA0801610_994079246 =                 mExternalFilesDir;
                var5CE0FFC467CE1E61F8F3D6EDA0801610_994079246.addTaint(taint);
                return var5CE0FFC467CE1E61F8F3D6EDA0801610_994079246;
            } //End block
            File dir = new File(mExternalFilesDir, type);
            if(!dir.exists())            
            {
                if(!dir.mkdirs())                
                {
File var540C13E9E156B687226421B24F2DF178_679075945 =                     null;
                    var540C13E9E156B687226421B24F2DF178_679075945.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_679075945;
                } //End block
            } //End block
File var5EF865AB804D7F7E31B936B35280353F_1896609210 =             dir;
            var5EF865AB804D7F7E31B936B35280353F_1896609210.addTaint(taint);
            return var5EF865AB804D7F7E31B936B35280353F_1896609210;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.400 -0400", hash_original_method = "36DEC4EC6E4DB2E91443B0A9125E0342", hash_generated_method = "29AD0C328C2E016416D9C2A6AA5DD692")
    @Override
    public File getObbDir() {
        synchronized
(mSync)        {
            if(mObbDir == null)            
            {
                mObbDir = Environment.getExternalStorageAppObbDirectory(
                        getPackageName());
            } //End block
File var15B08C553D466EC306008816A9169994_2018605998 =             mObbDir;
            var15B08C553D466EC306008816A9169994_2018605998.addTaint(taint);
            return var15B08C553D466EC306008816A9169994_2018605998;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.401 -0400", hash_original_method = "F6DBEEC95A0D73AEBD7CDC4BC14EA6E3", hash_generated_method = "33EB8889AA57937FF1983E063D6EF18A")
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
File var540C13E9E156B687226421B24F2DF178_970241337 =                     null;
                    var540C13E9E156B687226421B24F2DF178_970241337.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_970241337;
                } //End block
                FileUtils.setPermissions(
                        mCacheDir.getPath(),
                        FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                        -1, -1);
            } //End block
        } //End block
File var02A188D4F0BB4497378BBD745019EB79_1336816961 =         mCacheDir;
        var02A188D4F0BB4497378BBD745019EB79_1336816961.addTaint(taint);
        return var02A188D4F0BB4497378BBD745019EB79_1336816961;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.403 -0400", hash_original_method = "A3CE8D82B860400333D94B94289B1B1E", hash_generated_method = "98E2CB3D27C8AE97B6A0A060098F0E11")
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
File var540C13E9E156B687226421B24F2DF178_799938231 =                     null;
                    var540C13E9E156B687226421B24F2DF178_799938231.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_799938231;
                } //End block
            } //End block
File var58AAD984409F0E8BC59441667F2007CA_1042111659 =             mExternalCacheDir;
            var58AAD984409F0E8BC59441667F2007CA_1042111659.addTaint(taint);
            return var58AAD984409F0E8BC59441667F2007CA_1042111659;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.404 -0400", hash_original_method = "32A40B7EA525B83ED21D63D0A896CF7D", hash_generated_method = "53C1DEF365B06937D56DDE2DDBBD5FCF")
    @Override
    public File getFileStreamPath(String name) {
        addTaint(name.getTaint());
File var05C79A75FB5F00CBCA581256542EDF5B_388862082 =         makeFilename(getFilesDir(), name);
        var05C79A75FB5F00CBCA581256542EDF5B_388862082.addTaint(taint);
        return var05C79A75FB5F00CBCA581256542EDF5B_388862082;
        // ---------- Original Method ----------
        //return makeFilename(getFilesDir(), name);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.405 -0400", hash_original_method = "568E82D783647A73A7CA56CF0FA39878", hash_generated_method = "A4D7CA59E446BDFED7770F79F0EEF1B6")
    @Override
    public String[] fileList() {
        final String[] list = getFilesDir().list();
String[] varA1D0BD99D688D03B1D47ADCB816068DF_1362479370 =         (list != null) ? list : EMPTY_FILE_LIST;
        varA1D0BD99D688D03B1D47ADCB816068DF_1362479370.addTaint(taint);
        return varA1D0BD99D688D03B1D47ADCB816068DF_1362479370;
        // ---------- Original Method ----------
        //final String[] list = getFilesDir().list();
        //return (list != null) ? list : EMPTY_FILE_LIST;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.406 -0400", hash_original_method = "65FB5D1503ECB4784897EFA233F40D4E", hash_generated_method = "8B97C5D20A574ECF19B229B6A9079CF6")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        addTaint(factory.getTaint());
        addTaint(mode);
        addTaint(name.getTaint());
        File f = validateFilePath(name, true);
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f, factory);
        setFilePermissionsFromMode(f.getPath(), mode, 0);
SQLiteDatabase var2F732BA7E0C8A6B94C1D7B25B6A078BE_1481301436 =         db;
        var2F732BA7E0C8A6B94C1D7B25B6A078BE_1481301436.addTaint(taint);
        return var2F732BA7E0C8A6B94C1D7B25B6A078BE_1481301436;
        // ---------- Original Method ----------
        //File f = validateFilePath(name, true);
        //SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f, factory);
        //setFilePermissionsFromMode(f.getPath(), mode, 0);
        //return db;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.408 -0400", hash_original_method = "E2C57028FEE97C40627D175379C5C276", hash_generated_method = "AEBC4DD6C415E541E6387FB164ABD223")
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
SQLiteDatabase var2F732BA7E0C8A6B94C1D7B25B6A078BE_273027756 =         db;
        var2F732BA7E0C8A6B94C1D7B25B6A078BE_273027756.addTaint(taint);
        return var2F732BA7E0C8A6B94C1D7B25B6A078BE_273027756;
        // ---------- Original Method ----------
        //File f = validateFilePath(name, true);
        //SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f.getPath(), factory, errorHandler);
        //setFilePermissionsFromMode(f.getPath(), mode, 0);
        //return db;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.409 -0400", hash_original_method = "0A030BBB6F700BE85FBACF41F39CE120", hash_generated_method = "DE443F2FC00687356DD6EBAFDA9D6966")
    @Override
    public boolean deleteDatabase(String name) {
        addTaint(name.getTaint());
        try 
        {
            File f = validateFilePath(name, false);
            boolean varD09C522A4F6F8C6D66D204481533EF11_525973948 = (f.delete());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1258148525 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1258148525;
        } //End block
        catch (Exception e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1890218306 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_527811295 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_527811295;
        // ---------- Original Method ----------
        //try {
            //File f = validateFilePath(name, false);
            //return f.delete();
        //} catch (Exception e) {
        //}
        //return false;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.411 -0400", hash_original_method = "D766C2B887EEA2E44EE642CC66A97FF8", hash_generated_method = "563F3D6CB43C4C578639596B1AF77447")
    @Override
    public File getDatabasePath(String name) {
        addTaint(name.getTaint());
File var6129DA788DD9074E6FCE2D96880A1C18_328623602 =         validateFilePath(name, false);
        var6129DA788DD9074E6FCE2D96880A1C18_328623602.addTaint(taint);
        return var6129DA788DD9074E6FCE2D96880A1C18_328623602;
        // ---------- Original Method ----------
        //return validateFilePath(name, false);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.412 -0400", hash_original_method = "68895933E30EC3F2C5788FC13140D12F", hash_generated_method = "25741EC8752B108B6B8DA78400D81752")
    @Override
    public String[] databaseList() {
        final String[] list = getDatabasesDir().list();
String[] varA1D0BD99D688D03B1D47ADCB816068DF_1921837538 =         (list != null) ? list : EMPTY_FILE_LIST;
        varA1D0BD99D688D03B1D47ADCB816068DF_1921837538.addTaint(taint);
        return varA1D0BD99D688D03B1D47ADCB816068DF_1921837538;
        // ---------- Original Method ----------
        //final String[] list = getDatabasesDir().list();
        //return (list != null) ? list : EMPTY_FILE_LIST;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.413 -0400", hash_original_method = "5E7F893311C7FFBA04D943EFEC31C4D2", hash_generated_method = "D9A1322CB1BC7463B04B82C098517884")
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
File var03F2278E22352E1F6C912BE2E985552F_150859442 =             mDatabasesDir;
            var03F2278E22352E1F6C912BE2E985552F_150859442.addTaint(taint);
            return var03F2278E22352E1F6C912BE2E985552F_150859442;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.414 -0400", hash_original_method = "FF2FCBF8AB66D55188EF68C63BF4015D", hash_generated_method = "39DC4FAED0FCF791745A85D2313F0784")
    @Override
    public Drawable getWallpaper() {
Drawable var5E1B3A03EBA58046DCBF3473B140430E_1505910276 =         getWallpaperManager().getDrawable();
        var5E1B3A03EBA58046DCBF3473B140430E_1505910276.addTaint(taint);
        return var5E1B3A03EBA58046DCBF3473B140430E_1505910276;
        // ---------- Original Method ----------
        //return getWallpaperManager().getDrawable();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.415 -0400", hash_original_method = "65D83D9F23D018D77206F0312145003F", hash_generated_method = "A8CCEB3CD6775F65DA461FD5077D88C9")
    @Override
    public Drawable peekWallpaper() {
Drawable varA6AD709EF453905A27C70C18776D17AA_880380163 =         getWallpaperManager().peekDrawable();
        varA6AD709EF453905A27C70C18776D17AA_880380163.addTaint(taint);
        return varA6AD709EF453905A27C70C18776D17AA_880380163;
        // ---------- Original Method ----------
        //return getWallpaperManager().peekDrawable();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.417 -0400", hash_original_method = "4D3A48BB3B555646A3FEA2026A3AE79A", hash_generated_method = "EC8D09A27149911E448504B1B7F8C002")
    @Override
    public int getWallpaperDesiredMinimumWidth() {
        int varB1BB8DF8516F66F35C17BBD021952106_1459362811 = (getWallpaperManager().getDesiredMinimumWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_952488245 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_952488245;
        // ---------- Original Method ----------
        //return getWallpaperManager().getDesiredMinimumWidth();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.418 -0400", hash_original_method = "5FD558BDEB2B471F8EE36257DB8EACE1", hash_generated_method = "CA32AA5DBDAAF68632F8E23CBBBF8170")
    @Override
    public int getWallpaperDesiredMinimumHeight() {
        int var051CF96C471A22111752E67DEDF110B7_605197581 = (getWallpaperManager().getDesiredMinimumHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1121672376 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1121672376;
        // ---------- Original Method ----------
        //return getWallpaperManager().getDesiredMinimumHeight();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.420 -0400", hash_original_method = "0825D5DEC636130484CFA4FBC7BA319E", hash_generated_method = "E9D1644A32FE91BB0B210946C9A38655")
    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        addTaint(bitmap.getTaint());
        getWallpaperManager().setBitmap(bitmap);
        // ---------- Original Method ----------
        //getWallpaperManager().setBitmap(bitmap);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.420 -0400", hash_original_method = "DCC00C29B93F57D37E7F7F1EC0E5F4AD", hash_generated_method = "6D1E48BF9B6F8ADD780BD04ED3B656CE")
    @Override
    public void setWallpaper(InputStream data) throws IOException {
        addTaint(data.getTaint());
        getWallpaperManager().setStream(data);
        // ---------- Original Method ----------
        //getWallpaperManager().setStream(data);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.421 -0400", hash_original_method = "4ED3BD15D71B912DA43CDB584176350F", hash_generated_method = "1643E4DA39B9CD39D6B65552B739B7A0")
    @Override
    public void clearWallpaper() throws IOException {
        getWallpaperManager().clear();
        // ---------- Original Method ----------
        //getWallpaperManager().clear();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.422 -0400", hash_original_method = "C279CF6F1AD260899DD449A44D934DDE", hash_generated_method = "8288EF03638DFA2634956E9AA7089641")
    @Override
    public void startActivity(Intent intent) {
        addTaint(intent.getTaint());
        if((intent.getFlags()&Intent.FLAG_ACTIVITY_NEW_TASK) == 0)        
        {
            AndroidRuntimeException varA30FE02AC1640D5D4583E8D1CC7BBD50_1716317546 = new AndroidRuntimeException(
                    "Calling startActivity() from outside of an Activity "
                    + " context requires the FLAG_ACTIVITY_NEW_TASK flag."
                    + " Is this really what you want?");
            varA30FE02AC1640D5D4583E8D1CC7BBD50_1716317546.addTaint(taint);
            throw varA30FE02AC1640D5D4583E8D1CC7BBD50_1716317546;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.423 -0400", hash_original_method = "769E1A7E8134E0631F8E7ACB4BECF53B", hash_generated_method = "2A708D9DE56FA115D8F86AA17DEF71C5")
    @Override
    public void startActivities(Intent[] intents) {
        addTaint(intents[0].getTaint());
        if((intents[0].getFlags()&Intent.FLAG_ACTIVITY_NEW_TASK) == 0)        
        {
            AndroidRuntimeException var85C7B0C8F8D504BEA7D6F78119F6A5C9_1072525684 = new AndroidRuntimeException(
                    "Calling startActivities() from outside of an Activity "
                    + " context requires the FLAG_ACTIVITY_NEW_TASK flag on first Intent."
                    + " Is this really what you want?");
            var85C7B0C8F8D504BEA7D6F78119F6A5C9_1072525684.addTaint(taint);
            throw var85C7B0C8F8D504BEA7D6F78119F6A5C9_1072525684;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.425 -0400", hash_original_method = "C8E02424AE63F5F49E1852E1F77F5819", hash_generated_method = "F744B2501E0E22B41484B8B0042FCB06")
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
                IntentSender.SendIntentException var60287FF7293661812F3B04B1C75E0F5D_32968622 = new IntentSender.SendIntentException();
                var60287FF7293661812F3B04B1C75E0F5D_32968622.addTaint(taint);
                throw var60287FF7293661812F3B04B1C75E0F5D_32968622;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.427 -0400", hash_original_method = "A60EBABFFFCFDD737FB1FDCFE05C44F2", hash_generated_method = "3B442FD0A050512DC523D928A0CCA3E1")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.430 -0400", hash_original_method = "D592FFEA5E7229A3F68F56DC823D9A2C", hash_generated_method = "A91F11D3CC18FACA47E82A7165C83160")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.433 -0400", hash_original_method = "1B45A83FF6806414FEA9DF50022B81FD", hash_generated_method = "9AAA6671FFE17AB2B3F17AC011258BB3")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.439 -0400", hash_original_method = "75D722FF40A3D746C01E744F45F69CB7", hash_generated_method = "E448B4AA396A37B41FAD09EC13F5593C")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.441 -0400", hash_original_method = "A9DD8A9FF695328B63C944596A4EDBF3", hash_generated_method = "63521AC803F19A311769B31BB73955DF")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.445 -0400", hash_original_method = "5A5C4F9500968E8C5F0A5BF45BC32927", hash_generated_method = "681F85464CB71C4E7AC8B03FE335C8D5")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.449 -0400", hash_original_method = "F1371F3418D2B98EF62AEAB9A1FB12D9", hash_generated_method = "3889259B7B6339BE7D07507552EB293C")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.451 -0400", hash_original_method = "E79FC2581462A23AEE3B4180EBBDA608", hash_generated_method = "C1045A4F6B0BBE5037748F25C0C30F82")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
Intent varD535A24B470170C9E7EA08ED846B5DCB_1145749003 =         registerReceiver(receiver, filter, null, null);
        varD535A24B470170C9E7EA08ED846B5DCB_1145749003.addTaint(taint);
        return varD535A24B470170C9E7EA08ED846B5DCB_1145749003;
        // ---------- Original Method ----------
        //return registerReceiver(receiver, filter, null, null);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.452 -0400", hash_original_method = "185009C7B52864D361FCA1A63F57A4A0", hash_generated_method = "6B36E3018579CAC2DF9AA28997E556D6")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter,
            String broadcastPermission, Handler scheduler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(scheduler.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
Intent varC9B8644FEB54CD52908C3775CE9BC850_225239380 =         registerReceiverInternal(receiver, filter, broadcastPermission,
                scheduler, getOuterContext());
        varC9B8644FEB54CD52908C3775CE9BC850_225239380.addTaint(taint);
        return varC9B8644FEB54CD52908C3775CE9BC850_225239380;
        // ---------- Original Method ----------
        //return registerReceiverInternal(receiver, filter, broadcastPermission,
                //scheduler, getOuterContext());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.471 -0400", hash_original_method = "22E75A5CFB9DB3D3B6EDA1829895EA59", hash_generated_method = "277A6FEFD14511E1CD1545CD1E6D26B0")
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
Intent var2F4548E10CBDEA14DF6B0F5748692FEB_2015657791 =             ActivityManagerNative.getDefault().registerReceiver(
                    mMainThread.getApplicationThread(), mBasePackageName,
                    rd, filter, broadcastPermission);
            var2F4548E10CBDEA14DF6B0F5748692FEB_2015657791.addTaint(taint);
            return var2F4548E10CBDEA14DF6B0F5748692FEB_2015657791;
        } //End block
        catch (RemoteException e)
        {
Intent var540C13E9E156B687226421B24F2DF178_502744257 =             null;
            var540C13E9E156B687226421B24F2DF178_502744257.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_502744257;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.475 -0400", hash_original_method = "21E1A5F4D046FA1A605B9CB2F1A5C01A", hash_generated_method = "F7FE47D28B34AC45820AC2CCAA2551B3")
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
            RuntimeException varEE904A2D709F2CDD39CAD0AF95215C1A_228602974 = new RuntimeException("Not supported in system context");
            varEE904A2D709F2CDD39CAD0AF95215C1A_228602974.addTaint(taint);
            throw varEE904A2D709F2CDD39CAD0AF95215C1A_228602974;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.477 -0400", hash_original_method = "9B31F5C57DE16C0FCBD62EA4E59CD86B", hash_generated_method = "9A250731C1F1FB0F1827D2BD72ECD7B7")
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
                SecurityException var0F46DE1C915BDF377D7A74C57AFCEF44_436975031 = new SecurityException(
                        "Not allowed to start service " + service
                        + " without permission " + cn.getClassName());
                var0F46DE1C915BDF377D7A74C57AFCEF44_436975031.addTaint(taint);
                throw var0F46DE1C915BDF377D7A74C57AFCEF44_436975031;
            } //End block
ComponentName varDCCFDFA3C846990C7CD62841D6F23059_2000485007 =             cn;
            varDCCFDFA3C846990C7CD62841D6F23059_2000485007.addTaint(taint);
            return varDCCFDFA3C846990C7CD62841D6F23059_2000485007;
        } //End block
        catch (RemoteException e)
        {
ComponentName var540C13E9E156B687226421B24F2DF178_1729644998 =             null;
            var540C13E9E156B687226421B24F2DF178_1729644998.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1729644998;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.481 -0400", hash_original_method = "3FB64CBED2328D4F85F81CBC4C681900", hash_generated_method = "D7596492BA493134F38A92347539B373")
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
                SecurityException varC0BD828536BF559BF761E837EAE85D6D_1656449177 = new SecurityException(
                        "Not allowed to stop service " + service);
                varC0BD828536BF559BF761E837EAE85D6D_1656449177.addTaint(taint);
                throw varC0BD828536BF559BF761E837EAE85D6D_1656449177;
            } //End block
            boolean var13D92C9476B1FFEA425551B5286D4643_472709259 = (res != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1713871593 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1713871593;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_348494703 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1774868604 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1774868604;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.486 -0400", hash_original_method = "96A08A27D9E82A40B6EBDC8137646365", hash_generated_method = "8C96A292ACDE88A8A036A31DBFE7E1FE")
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
            RuntimeException varEE904A2D709F2CDD39CAD0AF95215C1A_1552263300 = new RuntimeException("Not supported in system context");
            varEE904A2D709F2CDD39CAD0AF95215C1A_1552263300.addTaint(taint);
            throw varEE904A2D709F2CDD39CAD0AF95215C1A_1552263300;
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
                SecurityException var0DF7474FDDF9AAE542CC8854B8071C2C_1471788883 = new SecurityException(
                        "Not allowed to bind to service " + service);
                var0DF7474FDDF9AAE542CC8854B8071C2C_1471788883.addTaint(taint);
                throw var0DF7474FDDF9AAE542CC8854B8071C2C_1471788883;
            } //End block
            boolean var13D92C9476B1FFEA425551B5286D4643_1900423309 = (res != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1968791987 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1968791987;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1955140310 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2029176942 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2029176942;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.488 -0400", hash_original_method = "9DD3486AE81B06ADE2CF5A15294BDDD9", hash_generated_method = "59D8A7F44625AB1CF6B18E6B7AD6B283")
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
            RuntimeException varEE904A2D709F2CDD39CAD0AF95215C1A_1395081310 = new RuntimeException("Not supported in system context");
            varEE904A2D709F2CDD39CAD0AF95215C1A_1395081310.addTaint(taint);
            throw varEE904A2D709F2CDD39CAD0AF95215C1A_1395081310;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.491 -0400", hash_original_method = "CC12C19EE7A70096368CCF1888E2A848", hash_generated_method = "7C84F5A9BCCD1127AF5E3ABA2239E367")
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
            boolean var63C8572B1AED1AAC338BD6C4B78706EA_225148599 = (ActivityManagerNative.getDefault().startInstrumentation(
                    className, profileFile, 0, arguments, null));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1589310597 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1589310597;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_310560356 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1354900935 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1354900935;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.493 -0400", hash_original_method = "321D04A4EEFC063A6FECB18E3640022A", hash_generated_method = "7ACCDD54F249A24D0837391EBBF4FF66")
    @Override
    public Object getSystemService(String name) {
        addTaint(name.getTaint());
        ServiceFetcher fetcher = SYSTEM_SERVICE_MAP.get(name);
Object var9C0020E217A0DB6896F4209CA40C4554_132075483 =         fetcher == null ? null : fetcher.getService(this);
        var9C0020E217A0DB6896F4209CA40C4554_132075483.addTaint(taint);
        return var9C0020E217A0DB6896F4209CA40C4554_132075483;
        // ---------- Original Method ----------
        //ServiceFetcher fetcher = SYSTEM_SERVICE_MAP.get(name);
        //return fetcher == null ? null : fetcher.getService(this);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.494 -0400", hash_original_method = "0B425FF354429B91E3FB5E5F0CCF5247", hash_generated_method = "07E3D3DA2D4FB848E1805C6A5ECA5D7A")
    private WallpaperManager getWallpaperManager() {
WallpaperManager var7DCBA8725EE8E928D8710BDCD76F68F8_719958790 =         (WallpaperManager) WALLPAPER_FETCHER.getService(this);
        var7DCBA8725EE8E928D8710BDCD76F68F8_719958790.addTaint(taint);
        return var7DCBA8725EE8E928D8710BDCD76F68F8_719958790;
        // ---------- Original Method ----------
        //return (WallpaperManager) WALLPAPER_FETCHER.getService(this);
    }

    
    @DSModeled(DSC.SPEC)
    static DropBoxManager createDropBoxManager() {
        IBinder b = ServiceManager.getService(DROPBOX_SERVICE);
        IDropBoxManagerService service = IDropBoxManagerService.Stub.asInterface(b);
        if (service == null) {
            return null;
        }
        return new DropBoxManager(service);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.497 -0400", hash_original_method = "E655FD683190F9408899A9F63A4817BD", hash_generated_method = "A23EC8E1CA1E158442920F76604AAA75")
    @Override
    public int checkPermission(String permission, int pid, int uid) {
        addTaint(uid);
        addTaint(pid);
        addTaint(permission.getTaint());
        if(permission == null)        
        {
            IllegalArgumentException varF63596F589200F8D345507D41B64F315_779370014 = new IllegalArgumentException("permission is null");
            varF63596F589200F8D345507D41B64F315_779370014.addTaint(taint);
            throw varF63596F589200F8D345507D41B64F315_779370014;
        } //End block
        try 
        {
            int var9C0899B109FF3609AF6B533C91A063A8_1088142473 = (ActivityManagerNative.getDefault().checkPermission(
                    permission, pid, uid));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_286041497 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_286041497;
        } //End block
        catch (RemoteException e)
        {
            int varDCC24A235C49CEDE71587AA8B50287A4_1071886368 = (PackageManager.PERMISSION_DENIED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153496369 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153496369;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.499 -0400", hash_original_method = "53BB4562C186F88686E791E4D4D7B971", hash_generated_method = "1CAA88136D06DE76B446A28EFBEE3EF2")
    @Override
    public int checkCallingPermission(String permission) {
        addTaint(permission.getTaint());
        if(permission == null)        
        {
            IllegalArgumentException varF63596F589200F8D345507D41B64F315_1451328623 = new IllegalArgumentException("permission is null");
            varF63596F589200F8D345507D41B64F315_1451328623.addTaint(taint);
            throw varF63596F589200F8D345507D41B64F315_1451328623;
        } //End block
        int pid = Binder.getCallingPid();
        if(pid != Process.myPid())        
        {
            int varA7ABCC960187BD913275E249C7F290B2_1828586242 = (checkPermission(permission, pid,
                    Binder.getCallingUid()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_322464571 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_322464571;
        } //End block
        int varDCC24A235C49CEDE71587AA8B50287A4_1066502729 = (PackageManager.PERMISSION_DENIED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_259425055 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_259425055;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.502 -0400", hash_original_method = "5A754757CCEBCBF70FA4909241A44647", hash_generated_method = "5EA1373D4132C82E315E2C77C9D3BE27")
    @Override
    public int checkCallingOrSelfPermission(String permission) {
        addTaint(permission.getTaint());
        if(permission == null)        
        {
            IllegalArgumentException varF63596F589200F8D345507D41B64F315_1924500725 = new IllegalArgumentException("permission is null");
            varF63596F589200F8D345507D41B64F315_1924500725.addTaint(taint);
            throw varF63596F589200F8D345507D41B64F315_1924500725;
        } //End block
        int varFEA56755FDE2AC58AA99F03461D32DE6_698770450 = (checkPermission(permission, Binder.getCallingPid(),
                Binder.getCallingUid()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1105647141 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1105647141;
        // ---------- Original Method ----------
        //if (permission == null) {
            //throw new IllegalArgumentException("permission is null");
        //}
        //return checkPermission(permission, Binder.getCallingPid(),
                //Binder.getCallingUid());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.504 -0400", hash_original_method = "6A8DDEA43434D3CB20BB0A5477A87FA9", hash_generated_method = "E617B69D5AC43EDA9229268F15267BD4")
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
            SecurityException varE050E0B9F98E39D331C5436BC1F85F8F_480845886 = new SecurityException(
                    (message != null ? (message + ": ") : "") +
                    (selfToo
                     ? "Neither user " + uid + " nor current process has "
                     : "User " + uid + " does not have ") +
                    permission +
                    ".");
            varE050E0B9F98E39D331C5436BC1F85F8F_480845886.addTaint(taint);
            throw varE050E0B9F98E39D331C5436BC1F85F8F_480845886;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.505 -0400", hash_original_method = "F2B22F288DBABA7E0BD88EB0745E09E9", hash_generated_method = "B49B1E6DDA9DB79620C3190B6AFF5E4D")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.506 -0400", hash_original_method = "CA80E1A1204586397A57A1A5E2A7C208", hash_generated_method = "8793B5851A63A0C86637AF020385F39D")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.507 -0400", hash_original_method = "29F4EE380B9693113A658836F1C9D9AE", hash_generated_method = "8E49C82C4F66F04C1AF18B9E5564DDE8")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.508 -0400", hash_original_method = "482617D8CF55E6FF0FA0E9B04256EFBF", hash_generated_method = "71EC0AEF463F93750CFA98CAD4B67372")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.510 -0400", hash_original_method = "F750735697FFE8FE8985E9218A8D8CF6", hash_generated_method = "CB790926A22491D1607B8B2139B4188A")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.512 -0400", hash_original_method = "A8F29D130C6713A956C80075096D4067", hash_generated_method = "7B68A8DD1621979CF92BAD0A363CCE07")
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(uri.getTaint());
        try 
        {
            int var63C72A61CB6EF995DC046AEBF18CA65C_957552656 = (ActivityManagerNative.getDefault().checkUriPermission(
                    uri, pid, uid, modeFlags));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1446657682 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1446657682;
        } //End block
        catch (RemoteException e)
        {
            int varDCC24A235C49CEDE71587AA8B50287A4_894918855 = (PackageManager.PERMISSION_DENIED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_741888866 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_741888866;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().checkUriPermission(
                    //uri, pid, uid, modeFlags);
        //} catch (RemoteException e) {
            //return PackageManager.PERMISSION_DENIED;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.516 -0400", hash_original_method = "F1471C24A57D163C01E766B9D19A4C37", hash_generated_method = "DAE50CE6C7F5A20951569C7F4B1900C4")
    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        int pid = Binder.getCallingPid();
        if(pid != Process.myPid())        
        {
            int var560552F7687141DBAEAABB84FE2246FA_85947150 = (checkUriPermission(uri, pid,
                    Binder.getCallingUid(), modeFlags));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1644672320 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1644672320;
        } //End block
        int varDCC24A235C49CEDE71587AA8B50287A4_535401723 = (PackageManager.PERMISSION_DENIED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_16835504 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_16835504;
        // ---------- Original Method ----------
        //int pid = Binder.getCallingPid();
        //if (pid != Process.myPid()) {
            //return checkUriPermission(uri, pid,
                    //Binder.getCallingUid(), modeFlags);
        //}
        //return PackageManager.PERMISSION_DENIED;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.518 -0400", hash_original_method = "92EE95457F7ED1F3B819760C77B2C515", hash_generated_method = "97D7D445CA74D73BFCACA232B51814F2")
    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        int var26E0B2E457DC8B59C754F17E22F00E43_157578125 = (checkUriPermission(uri, Binder.getCallingPid(),
                Binder.getCallingUid(), modeFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460679990 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460679990;
        // ---------- Original Method ----------
        //return checkUriPermission(uri, Binder.getCallingPid(),
                //Binder.getCallingUid(), modeFlags);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.521 -0400", hash_original_method = "A80C4E19DF7618048E1ED051566AC69E", hash_generated_method = "91AC807B703EADDF4EF79A895499F324")
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
                int var55413C6AD5414521A701E18298A1C877_1882814157 = (PackageManager.PERMISSION_GRANTED);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_201588759 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_201588759;
            } //End block
        } //End block
        if((modeFlags&Intent.FLAG_GRANT_WRITE_URI_PERMISSION) != 0)        
        {
            if(writePermission == null
                    || checkPermission(writePermission, pid, uid)
                    == PackageManager.PERMISSION_GRANTED)            
            {
                int var55413C6AD5414521A701E18298A1C877_1090108234 = (PackageManager.PERMISSION_GRANTED);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2058774376 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2058774376;
            } //End block
        } //End block
        int varC80346FCA15E7B9E9131B288859EBED2_8729715 = (uri != null ? checkUriPermission(uri, pid, uid, modeFlags)
                : PackageManager.PERMISSION_DENIED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1688984590 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1688984590;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.522 -0400", hash_original_method = "4ABE3E1ABE03D924F88AC8D7A295DCAE", hash_generated_method = "EF8FA2F65CF3B5A91285BFC0336E2B83")
    private String uriModeFlagToString(int uriModeFlags) {
        addTaint(uriModeFlags);
switch(uriModeFlags){
        case Intent.FLAG_GRANT_READ_URI_PERMISSION |
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION:
String varB66BDCE2B275B77D4B33D75B25097E16_1198474498 =         "read and write";
        varB66BDCE2B275B77D4B33D75B25097E16_1198474498.addTaint(taint);
        return varB66BDCE2B275B77D4B33D75B25097E16_1198474498;
        case Intent.FLAG_GRANT_READ_URI_PERMISSION:
String var8406D42862B2F33E68A58F11E3652EA9_1628775584 =         "read";
        var8406D42862B2F33E68A58F11E3652EA9_1628775584.addTaint(taint);
        return var8406D42862B2F33E68A58F11E3652EA9_1628775584;
        case Intent.FLAG_GRANT_WRITE_URI_PERMISSION:
String var1D88E2A6AC371783E3524ED205D20662_1495754006 =         "write";
        var1D88E2A6AC371783E3524ED205D20662_1495754006.addTaint(taint);
        return var1D88E2A6AC371783E3524ED205D20662_1495754006;
}        IllegalArgumentException var3D3A9E5462A7D4A56D1C234DC46E3B04_1856871085 = new IllegalArgumentException(
                "Unknown permission mode flags: " + uriModeFlags);
        var3D3A9E5462A7D4A56D1C234DC46E3B04_1856871085.addTaint(taint);
        throw var3D3A9E5462A7D4A56D1C234DC46E3B04_1856871085;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.523 -0400", hash_original_method = "6A9FD3C401F0CEC7314A7CD25AD534A9", hash_generated_method = "CC99212B730AFC734FFE5BF9BB4645D6")
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
            SecurityException var47D452409C040F6BBFD52844F43F3DAE_1350501317 = new SecurityException(
                    (message != null ? (message + ": ") : "") +
                    (selfToo
                     ? "Neither user " + uid + " nor current process has "
                     : "User " + uid + " does not have ") +
                    uriModeFlagToString(modeFlags) +
                    " permission on " +
                    uri +
                    ".");
            var47D452409C040F6BBFD52844F43F3DAE_1350501317.addTaint(taint);
            throw var47D452409C040F6BBFD52844F43F3DAE_1350501317;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.525 -0400", hash_original_method = "E9EAEBDE16DA8C22A5B7F64130CC6C00", hash_generated_method = "CF5309F8900706B880FD7D966E326DF8")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.525 -0400", hash_original_method = "6F0B74751E74AFB2005E6D12F19CB27E", hash_generated_method = "A85D37F5BA9D9917AC9F8A274C0EB185")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.527 -0400", hash_original_method = "886A3C8614D2CB5B8B7CB50793F1366D", hash_generated_method = "4EC849A5754E4309C74EF27D86437AD9")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.529 -0400", hash_original_method = "68131D896D42419119F62C3A9452D081", hash_generated_method = "B536C745EF650C57D0EFE3F0BAFF70D0")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.532 -0400", hash_original_method = "3BCB60F29BD51DD324BEDBA4985B960D", hash_generated_method = "4AE19F9A69036CC4C051C22A0548BBE9")
    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        addTaint(packageName.getTaint());
        if(packageName.equals("system") || packageName.equals("android"))        
        {
Context var4621F3569C20654C811A1BA1CE91BC2D_731597781 =             new ContextImpl(mMainThread.getSystemContext());
            var4621F3569C20654C811A1BA1CE91BC2D_731597781.addTaint(taint);
            return var4621F3569C20654C811A1BA1CE91BC2D_731597781;
        } //End block
        LoadedApk pi = mMainThread.getPackageInfo(packageName, mResources.getCompatibilityInfo(), flags);
        if(pi != null)        
        {
            ContextImpl c = new ContextImpl();
            c.mRestricted = (flags & CONTEXT_RESTRICTED) == CONTEXT_RESTRICTED;
            c.init(pi, null, mMainThread, mResources, mBasePackageName);
            if(c.mResources != null)            
            {
Context var807FB10045EE51C06BDB74744A6714DF_126005613 =                 c;
                var807FB10045EE51C06BDB74744A6714DF_126005613.addTaint(taint);
                return var807FB10045EE51C06BDB74744A6714DF_126005613;
            } //End block
        } //End block
        PackageManager.NameNotFoundException varF1D2CA2FC3493B3EB54ABD773CEBD1FA_1377574787 = new PackageManager.NameNotFoundException(
            "Application package " + packageName + " not found");
        varF1D2CA2FC3493B3EB54ABD773CEBD1FA_1377574787.addTaint(taint);
        throw varF1D2CA2FC3493B3EB54ABD773CEBD1FA_1377574787;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.535 -0400", hash_original_method = "190E6158FD0788E25F3E34C2C0D2C33E", hash_generated_method = "1B75B3243BAAAE0F64020B497C0FDF10")
    @Override
    public boolean isRestricted() {
        boolean varADD7E2B2442A13369398593FA842CF51_884391716 = (mRestricted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1709529426 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1709529426;
        // ---------- Original Method ----------
        //return mRestricted;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.537 -0400", hash_original_method = "E67FD2E3CB9CBDDDA85EF29E76BC4DD2", hash_generated_method = "9D909D0C784730DCF80CF67864684744")
    private File getDataDirFile() {
        if(mPackageInfo != null)        
        {
File varFC9C2C7F2B1B79BD901FB4B96215DB24_956999713 =             mPackageInfo.getDataDirFile();
            varFC9C2C7F2B1B79BD901FB4B96215DB24_956999713.addTaint(taint);
            return varFC9C2C7F2B1B79BD901FB4B96215DB24_956999713;
        } //End block
        RuntimeException varEE904A2D709F2CDD39CAD0AF95215C1A_1620482214 = new RuntimeException("Not supported in system context");
        varEE904A2D709F2CDD39CAD0AF95215C1A_1620482214.addTaint(taint);
        throw varEE904A2D709F2CDD39CAD0AF95215C1A_1620482214;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getDataDirFile();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.539 -0400", hash_original_method = "217ABBE8E0BC68B3B120E02EA884E102", hash_generated_method = "8284F95A653D709883500F33F660D5E7")
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
File varADCB75793FA1DABACC5DEBFFAE466050_1620822033 =         file;
        varADCB75793FA1DABACC5DEBFFAE466050_1620822033.addTaint(taint);
        return varADCB75793FA1DABACC5DEBFFAE466050_1620822033;
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

    
    @DSModeled(DSC.SPEC)
    static ContextImpl createSystemContext(ActivityThread mainThread) {
        ContextImpl context = new ContextImpl();
        context.init(Resources.getSystem(), mainThread);
        return context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.541 -0400", hash_original_method = "32CF6005086B5520DA4AE96ECAD890BA", hash_generated_method = "AE2CC5C57D9D5C26CA316310EFA3A3B8")
    final void init(LoadedApk packageInfo,
            IBinder activityToken, ActivityThread mainThread) {
        addTaint(mainThread.getTaint());
        addTaint(activityToken.getTaint());
        addTaint(packageInfo.getTaint());
        init(packageInfo, activityToken, mainThread, null, null);
        // ---------- Original Method ----------
        //init(packageInfo, activityToken, mainThread, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.545 -0400", hash_original_method = "617B56367877BE6D5351978E32679FCB", hash_generated_method = "3BC163CC2102C44B3CFCAD183744CCC5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.546 -0400", hash_original_method = "A01AC1DE8A0942D58F790AE1580128F4", hash_generated_method = "B64720F78160A873470409736052901F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.547 -0400", hash_original_method = "3668A95D26BB557CD7264A8982F20E37", hash_generated_method = "AEFCCA08892C84D675AD5641AAB08075")
    final void scheduleFinalCleanup(String who, String what) {
        addTaint(what.getTaint());
        addTaint(who.getTaint());
        mMainThread.scheduleContextCleanup(this, who, what);
        // ---------- Original Method ----------
        //mMainThread.scheduleContextCleanup(this, who, what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.548 -0400", hash_original_method = "0501008D8AD4AD5FA54A7545814DC0B6", hash_generated_method = "54C566E7BE538AE9A5BF1A18440BA5CE")
    final void performFinalCleanup(String who, String what) {
        addTaint(what.getTaint());
        addTaint(who.getTaint());
        mPackageInfo.removeContextRegistrations(getOuterContext(), who, what);
        // ---------- Original Method ----------
        //mPackageInfo.removeContextRegistrations(getOuterContext(), who, what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.551 -0400", hash_original_method = "00E338AD03CD22E7A509C63ABE7257F4", hash_generated_method = "854E98EF0E6C7E5982C4FBAF5A1BA49D")
    final Context getReceiverRestrictedContext() {
        if(mReceiverRestrictedContext != null)        
        {
Context varA84ADA944216C52FAC66287846BC900D_1728399974 =             mReceiverRestrictedContext;
            varA84ADA944216C52FAC66287846BC900D_1728399974.addTaint(taint);
            return varA84ADA944216C52FAC66287846BC900D_1728399974;
        } //End block
Context var7BF64381736836E6D5B8EFBEBA0DD76E_1275023053 =         mReceiverRestrictedContext = new ReceiverRestrictedContext(getOuterContext());
        var7BF64381736836E6D5B8EFBEBA0DD76E_1275023053.addTaint(taint);
        return var7BF64381736836E6D5B8EFBEBA0DD76E_1275023053;
        // ---------- Original Method ----------
        //if (mReceiverRestrictedContext != null) {
            //return mReceiverRestrictedContext;
        //}
        //return mReceiverRestrictedContext = new ReceiverRestrictedContext(getOuterContext());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.553 -0400", hash_original_method = "909971A42CA4D34B6A2AABA7AFFB96CE", hash_generated_method = "C4C31AC20FA544B3334C8E032915E0EF")
    final void setActivityToken(IBinder token) {
        mActivityToken = token;
        // ---------- Original Method ----------
        //mActivityToken = token;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.554 -0400", hash_original_method = "A74250CBDFD89C9F601A5AA3ED01CDC8", hash_generated_method = "F5D9056DA7F9C25752FDC44D6CB7B93B")
    final void setOuterContext(Context context) {
        mOuterContext = context;
        // ---------- Original Method ----------
        //mOuterContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.555 -0400", hash_original_method = "03C284D73757410812309249CAB76117", hash_generated_method = "74F4C9FD31F6C2220EAD23A45CD33F99")
    final Context getOuterContext() {
Context var05221853CA1248996DC6A0DB070356A2_437065226 =         mOuterContext;
        var05221853CA1248996DC6A0DB070356A2_437065226.addTaint(taint);
        return var05221853CA1248996DC6A0DB070356A2_437065226;
        // ---------- Original Method ----------
        //return mOuterContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.556 -0400", hash_original_method = "D32D1A589CFC02641AF8A3133A37BC7F", hash_generated_method = "39485914D135359682710BC7F3E1530D")
    final IBinder getActivityToken() {
IBinder var776483BEB0D8BCC1373C51E8861CFB6F_1914197988 =         mActivityToken;
        var776483BEB0D8BCC1373C51E8861CFB6F_1914197988.addTaint(taint);
        return var776483BEB0D8BCC1373C51E8861CFB6F_1914197988;
        // ---------- Original Method ----------
        //return mActivityToken;
    }

    
    @DSModeled(DSC.SPEC)
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.558 -0400", hash_original_method = "B435A8710874F18AA5DE97F01977E23C", hash_generated_method = "163F072372E61A4820A558AD725E5DAF")
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
File varABE3CFB53FE4A79F34CB25BC80BFD6E2_1542075859 =         f;
        varABE3CFB53FE4A79F34CB25BC80BFD6E2_1542075859.addTaint(taint);
        return varABE3CFB53FE4A79F34CB25BC80BFD6E2_1542075859;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.560 -0400", hash_original_method = "E9A305FD20BBA1C0FB0979159F7000FC", hash_generated_method = "40D50B8F2B9756ABC51093FC54FBDA08")
    private File makeFilename(File base, String name) {
        addTaint(name.getTaint());
        addTaint(base.getTaint());
        if(name.indexOf(File.separatorChar) < 0)        
        {
File var1737453552AEDF3042D01F5D328877B0_1948186150 =             new File(base, name);
            var1737453552AEDF3042D01F5D328877B0_1948186150.addTaint(taint);
            return var1737453552AEDF3042D01F5D328877B0_1948186150;
        } //End block
        IllegalArgumentException var43A7391A8C864B703618A9E060576B77_2140749290 = new IllegalArgumentException(
                "File " + name + " contains a path separator");
        var43A7391A8C864B703618A9E060576B77_2140749290.addTaint(taint);
        throw var43A7391A8C864B703618A9E060576B77_2140749290;
        // ---------- Original Method ----------
        //if (name.indexOf(File.separatorChar) < 0) {
            //return new File(base, name);
        //}
        //throw new IllegalArgumentException(
                //"File " + name + " contains a path separator");
    }

    
    static class ServiceFetcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.561 -0400", hash_original_field = "11138EF8AAFCAE7E2D7F37AF352B0770", hash_generated_field = "20F7EDA162164996331945812DFD02D4")

        int mContextCacheIndex = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.561 -0400", hash_original_method = "89135ACC7FF80D7CE959D5207760FBC6", hash_generated_method = "89135ACC7FF80D7CE959D5207760FBC6")
        public ServiceFetcher ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.564 -0400", hash_original_method = "B6729E9AD3191DC45FFEF069242EB9AE", hash_generated_method = "603E37EB0BB72F90DA95BCC5C870852E")
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
Object var18881A382C668272945CA08D6E19E173_1891651442 =                         service;
                        var18881A382C668272945CA08D6E19E173_1891651442.addTaint(taint);
                        return var18881A382C668272945CA08D6E19E173_1891651442;
                    } //End block
                } //End block
                service = createService(ctx);
                cache.set(mContextCacheIndex, service);
Object var18881A382C668272945CA08D6E19E173_443106406 =                 service;
                var18881A382C668272945CA08D6E19E173_443106406.addTaint(taint);
                return var18881A382C668272945CA08D6E19E173_443106406;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.565 -0400", hash_original_method = "46ECB6FD3C57198589BC43EC5E83533F", hash_generated_method = "E28F73D51807F38FB37DF9F0B9D5AB27")
        public Object createService(ContextImpl ctx) {
            addTaint(ctx.getTaint());
            RuntimeException varECF25F51942B946710F937BB139F9A1F_1680983753 = new RuntimeException("Not implemented");
            varECF25F51942B946710F937BB139F9A1F_1680983753.addTaint(taint);
            throw varECF25F51942B946710F937BB139F9A1F_1680983753;
            // ---------- Original Method ----------
            //throw new RuntimeException("Not implemented");
        }

        
    }


    
    abstract static class StaticServiceFetcher extends ServiceFetcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.566 -0400", hash_original_field = "ADDD4BB358F7AD43A1A174EC547D00F5", hash_generated_field = "5F0E5A47E62743034DEA32CA1075BE94")

        private Object mCachedInstance;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.567 -0400", hash_original_method = "8F4B3E9510C7190A989D0DB2833CAA4A", hash_generated_method = "8F4B3E9510C7190A989D0DB2833CAA4A")
        public StaticServiceFetcher ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.568 -0400", hash_original_method = "1B75D0F6FCB51C941C36BEE235F0DE1C", hash_generated_method = "5F24D967EAFC2950A08C684EE902831D")
        @Override
        public final Object getService(ContextImpl unused) {
            addTaint(unused.getTaint());
            synchronized
(StaticServiceFetcher.this)            {
                Object service = mCachedInstance;
                if(service != null)                
                {
Object var18881A382C668272945CA08D6E19E173_637890700 =                     service;
                    var18881A382C668272945CA08D6E19E173_637890700.addTaint(taint);
                    return var18881A382C668272945CA08D6E19E173_637890700;
                } //End block
Object var43F21808E64BDDCA0A2A490DACFF475F_965734590 =                 mCachedInstance = createStaticService();
                var43F21808E64BDDCA0A2A490DACFF475F_965734590.addTaint(taint);
                return var43F21808E64BDDCA0A2A490DACFF475F_965734590;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.569 -0400", hash_original_field = "46FDB2388003D2F8D58B7436C6E7B099", hash_generated_field = "3BD1B37D989628ECBEBF06B5281DCE58")

        private ActivityThread mMainThread;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.570 -0400", hash_original_method = "FC2218F5409D3B615253B9FADC78F4F0", hash_generated_method = "359DBF2FD41658189FAAF78BDED31F8F")
        public  ApplicationContentResolver(Context context, ActivityThread mainThread) {
            super(context);
            addTaint(context.getTaint());
            mMainThread = mainThread;
            // ---------- Original Method ----------
            //mMainThread = mainThread;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.571 -0400", hash_original_method = "1D54690CD1C75C22354AFE636FCBB54C", hash_generated_method = "EE63605324DD102851B5F483CFBA8802")
        @Override
        protected IContentProvider acquireProvider(Context context, String name) {
            addTaint(name.getTaint());
            addTaint(context.getTaint());
IContentProvider var504CEE3172AE9DFD9087963E4D1C26EC_2126916216 =             mMainThread.acquireProvider(context, name);
            var504CEE3172AE9DFD9087963E4D1C26EC_2126916216.addTaint(taint);
            return var504CEE3172AE9DFD9087963E4D1C26EC_2126916216;
            // ---------- Original Method ----------
            //return mMainThread.acquireProvider(context, name);
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.573 -0400", hash_original_method = "88B28437EF544809DF8D55FC39CCF726", hash_generated_method = "BC0524C37C043A5F34D71088AB728994")
        @Override
        protected IContentProvider acquireExistingProvider(Context context, String name) {
            addTaint(name.getTaint());
            addTaint(context.getTaint());
IContentProvider var1E904BFF275D0D05BE64E7DBFB56C1C8_1438849949 =             mMainThread.acquireExistingProvider(context, name);
            var1E904BFF275D0D05BE64E7DBFB56C1C8_1438849949.addTaint(taint);
            return var1E904BFF275D0D05BE64E7DBFB56C1C8_1438849949;
            // ---------- Original Method ----------
            //return mMainThread.acquireExistingProvider(context, name);
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.574 -0400", hash_original_method = "2FE34FA97A494E67E9164BEE654A40D1", hash_generated_method = "7736549C8D9D1BA0BF65C2D777944D20")
        @Override
        public boolean releaseProvider(IContentProvider provider) {
            addTaint(provider.getTaint());
            boolean var8D325C1832521ECE73A55AE353080AA9_796626904 = (mMainThread.releaseProvider(provider));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1094293941 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1094293941;
            // ---------- Original Method ----------
            //return mMainThread.releaseProvider(provider);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.575 -0400", hash_original_field = "DBC1AC9CDA1CA721403986EF486E93FD", hash_generated_field = "1DD3236631063C4A39FED7CD2DD748A1")

    private final static String TAG = "ApplicationContext";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.575 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "7841AA055B417A7E8C3D727A4ADDD91D")

    private final static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.575 -0400", hash_original_field = "6207FCFCFA690538862FA691A68C4AB1", hash_generated_field = "C28D37FE74542C16238F74BB2031E102")

    private static final HashMap<String, SharedPreferencesImpl> sSharedPrefs = new HashMap<String, SharedPreferencesImpl>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.575 -0400", hash_original_field = "8606DB58F4504BB95F437927A1118D9A", hash_generated_field = "24FE645B537D86D59BF761DAE24AA3EA")

    private static final String[] EMPTY_FILE_LIST = {};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.576 -0400", hash_original_field = "13BBA1D4EB247DCAB6C28F8022170B75", hash_generated_field = "4284E1216B34B381ED919CF71692E867")

    private static final HashMap<String, ServiceFetcher> SYSTEM_SERVICE_MAP = new HashMap<String, ServiceFetcher>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.576 -0400", hash_original_field = "27718F14D4140FEAE2ACB2C6900056C4", hash_generated_field = "BD87370C7C88691CA93E0A9F7822E99D")

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

