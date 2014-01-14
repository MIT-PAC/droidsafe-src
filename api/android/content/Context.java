package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import com.android.internal.policy.PolicyManager;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;

import android.accounts.AccountManager;
import android.accounts.IAccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.StatusBarManager;
import android.app.UiModeManager;
import android.app.admin.DevicePolicyManager;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.hardware.usb.IUsbManager;
import android.hardware.usb.UsbManager;
import android.location.CountryDetector;
import android.location.ICountryDetector;
import android.location.LocationManager;
import android.location.ILocationManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.IConnectivityManager;
import android.net.INetworkPolicyManager;
import android.net.IThrottleManager;
import android.net.NetworkPolicyManager;
import android.net.ThrottleManager;
import android.net.Uri;
import android.net.wifi.IWifiManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.IWifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.DropBoxManager;
import android.os.IBinder;
import android.os.IPowerManager;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.provider.AlarmClock;
import android.telephony.TelephonyManager;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.WindowManagerImpl;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;

public abstract class Context {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.822 -0500", hash_original_field = "B80BB7E1AAC59D39E6DD058233EE4B25", hash_generated_field = "E0534FAE410858BE0239A90CB81A3C3C")

    public static final int MODE_PRIVATE = 0x0000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.825 -0500", hash_original_field = "C5CBD2C336D676643DB09CAF116D05C8", hash_generated_field = "C00A6D34EDBF9E60AF33C96D65B15E93")

    public static final int MODE_WORLD_READABLE = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.827 -0500", hash_original_field = "8DD23C806F6F509AEA8997B1404DD850", hash_generated_field = "61F4EE1E1FDEEECA23996E2131E557AF")

    public static final int MODE_WORLD_WRITEABLE = 0x0002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.829 -0500", hash_original_field = "350DA9323F0A3B99E29C18D9361835FF", hash_generated_field = "A1D4701EDB7C2CF32DB6D704DB64F158")

    public static final int MODE_APPEND = 0x8000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.832 -0500", hash_original_field = "0EAA3F037618F0ACFE8F4DF57CC00F8F", hash_generated_field = "8D32186E1C1FBA644B75AB8D6BD319D0")

    public static final int MODE_MULTI_PROCESS = 0x0004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.834 -0500", hash_original_field = "FE44B77D28FEABCCEA28D5BCF7C92FB2", hash_generated_field = "3F719DF33B5D38DBF9EDA5459690E1E3")

    public static final int BIND_AUTO_CREATE = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.836 -0500", hash_original_field = "C83B7C813DFA9C91BDCE33013EEDCC8A", hash_generated_field = "95934930F85186A3FEB58D687D9B608A")

    public static final int BIND_DEBUG_UNBIND = 0x0002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.838 -0500", hash_original_field = "CBAA59870D8B73A5F47AECDD4DF69362", hash_generated_field = "0C5F5CEFA5733E1C296DEE1B15C8D39A")

    public static final int BIND_NOT_FOREGROUND = 0x0004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.841 -0500", hash_original_field = "44A2E68FEDC8773ACFEED7497799EAF9", hash_generated_field = "8D5736F032682672BB446A94C97B4AB9")

    public static final int BIND_ABOVE_CLIENT = 0x0008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.844 -0500", hash_original_field = "E0D1E7F4091A0A16AAC3B48D54155CE9", hash_generated_field = "7BB1BA1A9DEA67D07B6CE17297E5641E")

    public static final int BIND_ALLOW_OOM_MANAGEMENT = 0x0010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.846 -0500", hash_original_field = "5765DE9522693DE9AD769FFEDF8577BD", hash_generated_field = "2656EBD430F847F35F9423E52425B3EA")

    public static final int BIND_WAIVE_PRIORITY = 0x0020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.848 -0500", hash_original_field = "3AAFFD2B085C6D19407C82B7CE1B7793", hash_generated_field = "9CFD13BAA284CD7299FCD1B7145F9D86")

    public static final int BIND_IMPORTANT = 0x0040;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.851 -0500", hash_original_field = "1F8B15296A5703F173B445B3BFE91EA2", hash_generated_field = "7AACFEB8F1B496D355C0E0064BF3AB29")

    public static final int BIND_ADJUST_WITH_ACTIVITY = 0x0080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.853 -0500", hash_original_field = "3DC8E392084E4F800E07258CAEE9DC22", hash_generated_field = "36952676B0F348321AD0B80A350F64B3")

    public static final int BIND_NOT_VISIBLE = 0x40000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.006 -0500", hash_original_field = "D157F14F92FEBEE86A021706BE52DF01", hash_generated_field = "E8416ECCEA5BEAC114B2264DD2931CB7")

    public static final String POWER_SERVICE = "power";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.008 -0500", hash_original_field = "D5854A4572E21104782CC83F24F5C646", hash_generated_field = "222B9B08FA09921EAC11E4F59C058863")

    public static final String WINDOW_SERVICE = "window";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.011 -0500", hash_original_field = "C8A330A465BA96A4D78B046EEBCB3EE3", hash_generated_field = "38CC5AF191EBD0DB2A5766B331DEFAD9")

    public static final String LAYOUT_INFLATER_SERVICE = "layout_inflater";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.013 -0500", hash_original_field = "671462DA63AA1C6E3A8AA72EF1C046C6", hash_generated_field = "C0101BF00244F413D0C290959C084A6C")

    public static final String ACCOUNT_SERVICE = "account";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.015 -0500", hash_original_field = "BFA50B845F97B299EEC461F9BDEBA848", hash_generated_field = "8BB3D3D67FF9811DEABA28412034BF1F")

    public static final String ACTIVITY_SERVICE = "activity";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.017 -0500", hash_original_field = "D7EFF7C7A31CA915C225135583DAF0BB", hash_generated_field = "E5AF97C7B0EB125B7B2BD44F6B682371")

    public static final String ALARM_SERVICE = "alarm";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.020 -0500", hash_original_field = "17975098D6E77AE5AB9164D97538184B", hash_generated_field = "EE887814E737E14F594C651614CE16DF")

    public static final String NOTIFICATION_SERVICE = "notification";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.022 -0500", hash_original_field = "6BCB4B55259993FC66B43480F3BB4A84", hash_generated_field = "C6CE03AB8349C616824A7FCE6CC045BF")

    public static final String ACCESSIBILITY_SERVICE = "accessibility";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.025 -0500", hash_original_field = "0D1178E80E4A6B45560C7D154F8B5363", hash_generated_field = "A2124D9C2882A3B61AA3F18DE08940F6")

    public static final String KEYGUARD_SERVICE = "keyguard";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.027 -0500", hash_original_field = "F0A8DC43D14A6342209B2BA7D45C2365", hash_generated_field = "0A2D92FCA78EDAD178265457397CBFBB")

    public static final String LOCATION_SERVICE = "location";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.029 -0500", hash_original_field = "01035F613EB5040376DED968E0FF7E94", hash_generated_field = "3E584B95026E0B9C77A1D4775A4F38F1")

    public static final String COUNTRY_DETECTOR = "country_detector";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.032 -0500", hash_original_field = "79C5ACA4AEDB4D6459E4FBDC65AFF8AA", hash_generated_field = "5CDA85362325A86F1D959503F08F9304")

    public static final String SEARCH_SERVICE = "search";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.035 -0500", hash_original_field = "A492C05E74BFD225F0998AADFFE2D3FF", hash_generated_field = "0708D01C0AB8CCDBBBEBA4E8C60C1860")

    public static final String SENSOR_SERVICE = "sensor";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.037 -0500", hash_original_field = "C8F9295E51AE21B0D1882A87B591D437", hash_generated_field = "683D409858DB0534C1F3F8C1B86A84ED")

    public static final String STORAGE_SERVICE = "storage";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.039 -0500", hash_original_field = "870A09418A1972037CA6178DA27FFF75", hash_generated_field = "4AC7C0CE09AEC0002A651C7949FB84DC")

    public static final String WALLPAPER_SERVICE = "wallpaper";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.041 -0500", hash_original_field = "E51D6AB8AD1F12F73D634C3754CF2667", hash_generated_field = "39726A4B89909A265FD047CC4D56AEB8")

    public static final String VIBRATOR_SERVICE = "vibrator";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.044 -0500", hash_original_field = "4EAA61CDE85421448F5630ED152906B7", hash_generated_field = "DACE3B8B9B06D14717640DFBD64CB027")

    public static final String STATUS_BAR_SERVICE = "statusbar";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.046 -0500", hash_original_field = "C16093489DFF215824042ED412850E06", hash_generated_field = "2F45F5AD93952D9D29432D95F2452092")

    public static final String CONNECTIVITY_SERVICE = "connectivity";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.049 -0500", hash_original_field = "C2635A6291CE3B1174483B5247C5F067", hash_generated_field = "3AD0A3355544924E513A0BC3052EFC4B")

    public static final String THROTTLE_SERVICE = "throttle";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.051 -0500", hash_original_field = "3CA97717367ED14770A227E93CF79EAC", hash_generated_field = "A450F3546D814B85E8397541C578F3CF")

    public static final String NETWORKMANAGEMENT_SERVICE = "network_management";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.053 -0500", hash_original_field = "D6E7DDC63B52CED1DE875A637D665DEA", hash_generated_field = "454E71FC4584A535C801D683C68A25ED")

    public static final String NETWORK_STATS_SERVICE = "netstats";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.056 -0500", hash_original_field = "1E654133481635B7422AB17D1B6F0E1E", hash_generated_field = "5A58323C773F04B7B62244D04564F5D5")

    public static final String NETWORK_POLICY_SERVICE = "netpolicy";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.058 -0500", hash_original_field = "43448CFE4D69506B7EABD105C66A4970", hash_generated_field = "99A842CA1318F2E11F6BE58707AB118F")

    public static final String WIFI_SERVICE = "wifi";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.060 -0500", hash_original_field = "65742807EF37F5AF9551367DF51F7C99", hash_generated_field = "C3BF0421487E50A24AE2947C35E56E7D")

    public static final String WIFI_P2P_SERVICE = "wifip2p";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.062 -0500", hash_original_field = "D40EDB45F161E0C6EC435578FA253E30", hash_generated_field = "F28252FD322AD74524DADB8BBEF2D288")

    public static final String AUDIO_SERVICE = "audio";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.065 -0500", hash_original_field = "55A255B436D370E68240D0B8C06E70EF", hash_generated_field = "F10E72BCA2F3F12ECFBC4AD688887010")

    public static final String TELEPHONY_SERVICE = "phone";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.067 -0500", hash_original_field = "F5CF1B308494A1BF0FE8A371F7DB980A", hash_generated_field = "1A766B47E950410C3F30F8C050ED10B5")

    public static final String CLIPBOARD_SERVICE = "clipboard";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.070 -0500", hash_original_field = "A611F6EE0B928B1E19C4BEEF4A175A4E", hash_generated_field = "86CBA0398F780670874BEBBE962A4234")

    public static final String INPUT_METHOD_SERVICE = "input_method";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.072 -0500", hash_original_field = "C12C439F39AD358AA7ACDC99B8C9951E", hash_generated_field = "3D0F48743A480272F049F93E42ADFD28")

    public static final String TEXT_SERVICES_MANAGER_SERVICE = "textservices";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.074 -0500", hash_original_field = "3636CE7D6EE0B26E1CBAA9149D6B9DBB", hash_generated_field = "532AB440378B09C3B6064E442DF5F1B7")

    public static final String APPWIDGET_SERVICE = "appwidget";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.077 -0500", hash_original_field = "55280FF9190560C60B00BE59CB86AB86", hash_generated_field = "FA86164719D55F0E711FE6BC871180E8")

    public static final String BACKUP_SERVICE = "backup";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.079 -0500", hash_original_field = "8B7B3D4F9BE12F4E34A50BD1154FB82A", hash_generated_field = "DB9BF2C988EFDA8B74A602487DB98892")

    public static final String DROPBOX_SERVICE = "dropbox";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.081 -0500", hash_original_field = "97AF284060B72AE1AD4EF284B27C07EA", hash_generated_field = "A27547CDFB697E9207929038781E5413")

    public static final String DEVICE_POLICY_SERVICE = "device_policy";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.084 -0500", hash_original_field = "C3FDDB3446E05B52A969571CA536217B", hash_generated_field = "093487E6D98CF2E55BA893689E4AD09D")

    public static final String UI_MODE_SERVICE = "uimode";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.086 -0500", hash_original_field = "1460D16082DC9EC15D254242944A7043", hash_generated_field = "2878DC56FA5E2F9F330CB8BDE2ACF22A")

    public static final String DOWNLOAD_SERVICE = "download";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.088 -0500", hash_original_field = "EA480B5C26C0B35721FE2E9E3967057A", hash_generated_field = "5831D684985AAEA831FADFDAE47A65F0")

    public static final String NFC_SERVICE = "nfc";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.090 -0500", hash_original_field = "93C6A9BF52ED2321819A900CD60C4AC0", hash_generated_field = "57C5762094E6BFBECA6E66DC4A6D5370")

    /** @hide */
    public static final String SIP_SERVICE = "sip";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.093 -0500", hash_original_field = "CD1646E97619281D86FD8162843B9DAF", hash_generated_field = "8067BA11AD1BFB38AB9ECD2EA5D0F04C")

    public static final String USB_SERVICE = "usb";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.132 -0500", hash_original_field = "03BD76E398287234977B3D68A882C905", hash_generated_field = "2531CFB911E7B5DA453B0D35880BAB90")

    public static final int CONTEXT_INCLUDE_CODE = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.134 -0500", hash_original_field = "FE150DE8C849D8A50E5721A40988727B", hash_generated_field = "EA43A38A5281FECBBE69A8378CDA10EC")

    public static final int CONTEXT_IGNORE_SECURITY = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.136 -0500", hash_original_field = "70FCA06F476C88210D13457871671AF1", hash_generated_field = "F3D4B86861C416E9BCDD00F4D43AA6B2")

    public static final int CONTEXT_RESTRICTED = 0x00000004;
    
	// Hook to match with value analsysis
	public Set<IntentFilter> __ds__intentFilters = new HashSet<IntentFilter>();

	public Context() {
		//Do Nothing
	}

    /** Return an AssetManager instance for your application's package. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.856 -0500", hash_original_method = "3D9F192E32E991AE3314DE7A1AFABF9B", hash_generated_method = "64818D2C9943C784FC5AD2D35E83F009")
    
public abstract AssetManager getAssets();

    /** Return a Resources instance for your application's package. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.858 -0500", hash_original_method = "DDC03F44FA955FC312F0B392013F0650", hash_generated_method = "FCB6897E52684952F018239BD74C6494")
    
public abstract Resources getResources();

    /** Return PackageManager instance to find global package information. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.860 -0500", hash_original_method = "79CAABBA68FB074205B16005189B326D", hash_generated_method = "FCD846236522A06EEDB2DBD77E2946E2")
    
public abstract PackageManager getPackageManager();

    /** Return a ContentResolver instance for your application's package. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.862 -0500", hash_original_method = "1D00732668B8C897D38BE7A141172873", hash_generated_method = "A7D8728F3BE00D5CDB00368E816A20AC")
    
public abstract ContentResolver getContentResolver();

    /**
     * Return the Looper for the main thread of the current process.  This is
     * the thread used to dispatch calls to application components (activities,
     * services, etc).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.865 -0500", hash_original_method = "2273432F36EEE4336A286768A4295592", hash_generated_method = "D221AC1129500C9E83799580297114B8")
    
public abstract Looper getMainLooper();

    /**
     * Return the context of the single, global Application object of the
     * current process.  This generally should only be used if you need a
     * Context whose lifecycle is separate from the current context, that is
     * tied to the lifetime of the process rather than the current component.
     *
     * <p>Consider for example how this interacts with
     * {@link #registerReceiver(BroadcastReceiver, IntentFilter)}:
     * <ul>
     * <li> <p>If used from an Activity context, the receiver is being registered
     * within that activity.  This means that you are expected to unregister
     * before the activity is done being destroyed; in fact if you do not do
     * so, the framework will clean up your leaked registration as it removes
     * the activity and log an error.  Thus, if you use the Activity context
     * to register a receiver that is static (global to the process, not
     * associated with an Activity instance) then that registration will be
     * removed on you at whatever point the activity you used is destroyed.
     * <li> <p>If used from the Context returned here, the receiver is being
     * registered with the global state associated with your application.  Thus
     * it will never be unregistered for you.  This is necessary if the receiver
     * is associated with static data, not a particular component.  However
     * using the ApplicationContext elsewhere can easily lead to serious leaks
     * if you forget to unregister, unbind, etc.
     * </ul>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.867 -0500", hash_original_method = "4BFA2CD701CE85242491E38EAA80F5E1", hash_generated_method = "52427EC0AE341980B3A33AF47042782C")
    
public abstract Context getApplicationContext();

    /**
     * Add a new {@link ComponentCallbacks} to the base application of the
     * Context, which will be called at the same times as the ComponentCallbacks
     * methods of activities and other components are called.  Note that you
     * <em>must</em> be sure to use {@link #unregisterComponentCallbacks} when
     * appropriate in the future; this will not be removed for you.
     *
     * @param callback The interface to call.  This can be either a
     * {@link ComponentCallbacks} or {@link ComponentCallbacks2} interface.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.869 -0500", hash_original_method = "CA41FDFA6BB6EC9A7DA4C7864F293E89", hash_generated_method = "E5E2788341808E62206638EFC3698CF5")
    
public void registerComponentCallbacks(ComponentCallbacks callback) {
        getApplicationContext().registerComponentCallbacks(callback);
    }

    /**
     * Remove a {@link ComponentCallbacks} objec that was previously registered
     * with {@link #registerComponentCallbacks(ComponentCallbacks)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.871 -0500", hash_original_method = "494D7366CDA5CBFD506341B295742C11", hash_generated_method = "76B9ED3DB9C96637173C301628B1E341")
    
public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        getApplicationContext().unregisterComponentCallbacks(callback);
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public final CharSequence getText(int resId) {
        String str = new String();
        str.addTaint(resId);
        return str;
		/*
		 * No need to model the Resources class at this time.  The underlying
		 * implementation calls down into AssetManager and simply supplies a
		 * string value.  If more items utilize Resources or AssetManager we
		 * may need to model those classes.  For now this will suffice.
		 */
        //return getResources().getText(resId);
    }

    /**
     * Return a localized string from the application's package's
     * default string table.
     *
     * @param resId Resource id for the string
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.875 -0500", hash_original_method = "6096F9B7D678CAFA7D67C1784ABCB9A7", hash_generated_method = "D37D9DF864413A58CE69AFC7CD44E2C7")
    
public final String getString(int resId) {
        return getResources().getString(resId);
    }

    /**
     * Return a localized formatted string from the application's package's
     * default string table, substituting the format arguments as defined in
     * {@link java.util.Formatter} and {@link java.lang.String#format}.
     *
     * @param resId Resource id for the format string
     * @param formatArgs The format arguments that will be used for substitution.
     */

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.877 -0500", hash_original_method = "524F00C5C13CBD3BD0D5C512A4C12294", hash_generated_method = "D6859AF8D80E850EE17858448765ABE4")
    
public final String getString(int resId, Object... formatArgs) {
        return getResources().getString(resId, formatArgs);
    }

     /**
     * Set the base theme for this context.  Note that this should be called
     * before any views are instantiated in the Context (for example before
     * calling {@link android.app.Activity#setContentView} or
     * {@link android.view.LayoutInflater#inflate}).
     *
     * @param resid The style resource describing the theme.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.879 -0500", hash_original_method = "0DB49DE87B157A2C4B2935D58BBA65E3", hash_generated_method = "AB34B36F040D23DC72475F0814E8DA5B")
    
public abstract void setTheme(int resid);

    /** @hide Needed for some internal implementation...  not public because
     * you can't assume this actually means anything. */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.881 -0500", hash_original_method = "50CDF7EE4EA4E2BC75FC99DEA1DDCB11", hash_generated_method = "1272D7E9D68672649ADFD8FAF1BD64C2")
    
public int getThemeResId() {
        return 0;
    }

    /**
     * Return the Theme object associated with this Context.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.883 -0500", hash_original_method = "7ACE2B655A5B877874BCA55245CA4650", hash_generated_method = "CF306A85F4EDB21EEEBC87F9574CE37E")
    
public abstract Resources.Theme getTheme();

    /**
     * Retrieve styled attribute information in this Context's theme.  See
     * {@link Resources.Theme#obtainStyledAttributes(int[])}
     * for more information.
     *
     * @see Resources.Theme#obtainStyledAttributes(int[])
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.886 -0500", hash_original_method = "FF26021DC793B4DE3C0383ED66D7E1E8", hash_generated_method = "8263BAB3FE93E96AF6816141E1709550")
    
public final TypedArray obtainStyledAttributes(
            int[] attrs) {
        return getTheme().obtainStyledAttributes(attrs);
    }

    /**
     * Retrieve styled attribute information in this Context's theme.  See
     * {@link Resources.Theme#obtainStyledAttributes(int, int[])}
     * for more information.
     *
     * @see Resources.Theme#obtainStyledAttributes(int, int[])
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.888 -0500", hash_original_method = "C05CBF641E41D370531BE7FED84BE5CE", hash_generated_method = "643F335630EFA85BB93672A12259C8AF")
    
public final TypedArray obtainStyledAttributes(
            int resid, int[] attrs) throws Resources.NotFoundException {
        return getTheme().obtainStyledAttributes(resid, attrs);
    }

    /**
     * Retrieve styled attribute information in this Context's theme.  See
     * {@link Resources.Theme#obtainStyledAttributes(AttributeSet, int[], int, int)}
     * for more information.
     *
     * @see Resources.Theme#obtainStyledAttributes(AttributeSet, int[], int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.891 -0500", hash_original_method = "C594E5E7DCFBB517BAAED03BB3D45896", hash_generated_method = "5BA5A74A13CBB0188C9E74882C49861E")
    
public final TypedArray obtainStyledAttributes(
            AttributeSet set, int[] attrs) {
        return getTheme().obtainStyledAttributes(set, attrs, 0, 0);
    }

    /**
     * Retrieve styled attribute information in this Context's theme.  See
     * {@link Resources.Theme#obtainStyledAttributes(AttributeSet, int[], int, int)}
     * for more information.
     *
     * @see Resources.Theme#obtainStyledAttributes(AttributeSet, int[], int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.894 -0500", hash_original_method = "23F3A3F4901D9D1C9DD21EEAA884561D", hash_generated_method = "4422D6DA26647847CA530D1B3929C7F8")
    
public final TypedArray obtainStyledAttributes(
            AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes) {
        return getTheme().obtainStyledAttributes(
            set, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * Return a class loader you can use to retrieve classes in this package.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.896 -0500", hash_original_method = "8A810E4DE3086C301A9EB2A3F9E45FA2", hash_generated_method = "488BD79C00E2507C7A9C8DB8CE74E57B")
    
public abstract ClassLoader getClassLoader();

    /** Return the name of this application's package. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.898 -0500", hash_original_method = "0AEBC7BE6AC5D73669D5E786F8C71C2E", hash_generated_method = "D1A5857F6911C9DA4EF7356D04CCA9DB")
    
public abstract String getPackageName();

    /** Return the full application info for this context's package. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.900 -0500", hash_original_method = "0853F0BFD0AB024B1B62857AD01DAF33", hash_generated_method = "219D0318B08C94A31B6C8672DAC137FD")
    
public abstract ApplicationInfo getApplicationInfo();

    /**
     * Return the full path to this context's primary Android package.
     * The Android package is a ZIP file which contains the application's
     * primary resources.
     *
     * <p>Note: this is not generally useful for applications, since they should
     * not be directly accessing the file system.
     *
     * @return String Path to the resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.902 -0500", hash_original_method = "BF39A82633B6D5EA73EDAC0764AC8933", hash_generated_method = "91C4A9E8ADEC54954EB83B6E892EF32C")
    
public abstract String getPackageResourcePath();

    /**
     * Return the full path to this context's primary Android package.
     * The Android package is a ZIP file which contains application's
     * primary code and assets.
     *
     * <p>Note: this is not generally useful for applications, since they should
     * not be directly accessing the file system.
     *
     * @return String Path to the code and assets.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.904 -0500", hash_original_method = "6883772254278B57804CBB75A8D1016A", hash_generated_method = "192FAF5BA6A5431FBE320A1DFDB8763F")
    
public abstract String getPackageCodePath();

    /**
     * {@hide}
     * Return the full path to the shared prefs file for the given prefs group name.
     *
     * <p>Note: this is not generally useful for applications, since they should
     * not be directly accessing the file system.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.906 -0500", hash_original_method = "948D6AA8DF4CE395FB14E27B4191DFFF", hash_generated_method = "ABF5EEA2AAE09C560A31B873B03F83B5")
    
public abstract File getSharedPrefsFile(String name);

    /**
     * Retrieve and hold the contents of the preferences file 'name', returning
     * a SharedPreferences through which you can retrieve and modify its
     * values.  Only one instance of the SharedPreferences object is returned
     * to any callers for the same name, meaning they will see each other's
     * edits as soon as they are made.
     *
     * @param name Desired preferences file. If a preferences file by this name
     * does not exist, it will be created when you retrieve an
     * editor (SharedPreferences.edit()) and then commit changes (Editor.commit()).
     * @param mode Operating mode.  Use 0 or {@link #MODE_PRIVATE} for the
     * default operation, {@link #MODE_WORLD_READABLE}
     * and {@link #MODE_WORLD_WRITEABLE} to control permissions.  The bit
     * {@link #MODE_MULTI_PROCESS} can also be used if multiple processes
     * are mutating the same SharedPreferences file.  {@link #MODE_MULTI_PROCESS}
     * is always on in apps targetting Gingerbread (Android 2.3) and below, and
     * off by default in later versions.
     *
     * @return Returns the single SharedPreferences instance that can be used
     *         to retrieve and modify the preference values.
     *
     * @see #MODE_PRIVATE
     * @see #MODE_WORLD_READABLE
     * @see #MODE_WORLD_WRITEABLE
     * @see #MODE_MULTI_PROCESS
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.909 -0500", hash_original_method = "0A32AB6B1755B7A435A6F215DDF3C5B4", hash_generated_method = "58E69BCA38F976DBC2163BAC4DCC28FE")
    
public abstract SharedPreferences getSharedPreferences(String name,
            int mode);

    /**
     * Open a private file associated with this Context's application package
     * for reading.
     *
     * @param name The name of the file to open; can not contain path
     *             separators.
     *
     * @return FileInputStream Resulting input stream.
     *
     * @see #openFileOutput
     * @see #fileList
     * @see #deleteFile
     * @see java.io.FileInputStream#FileInputStream(String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.911 -0500", hash_original_method = "EBAD68309D7C43CA53D7A0B7FB063D1D", hash_generated_method = "7CE8EA82F68F3012E1BE2EA8D2202B3E")
    
public abstract FileInputStream openFileInput(String name)
        throws FileNotFoundException;

    /**
     * Open a private file associated with this Context's application package
     * for writing.  Creates the file if it doesn't already exist.
     *
     * @param name The name of the file to open; can not contain path
     *             separators.
     * @param mode Operating mode.  Use 0 or {@link #MODE_PRIVATE} for the
     * default operation, {@link #MODE_APPEND} to append to an existing file,
     * {@link #MODE_WORLD_READABLE} and {@link #MODE_WORLD_WRITEABLE} to control
     * permissions.
     *
     * @return FileOutputStream Resulting output stream.
     *
     * @see #MODE_APPEND
     * @see #MODE_PRIVATE
     * @see #MODE_WORLD_READABLE
     * @see #MODE_WORLD_WRITEABLE
     * @see #openFileInput
     * @see #fileList
     * @see #deleteFile
     * @see java.io.FileOutputStream#FileOutputStream(String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.913 -0500", hash_original_method = "BEE63DE917C6EB7327F3CD638CB5E201", hash_generated_method = "C3F3F1D5E8BA5B4F3D287ECFD48EBDEA")
    
public abstract FileOutputStream openFileOutput(String name, int mode)
        throws FileNotFoundException;

    /**
     * Delete the given private file associated with this Context's
     * application package.
     *
     * @param name The name of the file to delete; can not contain path
     *             separators.
     *
     * @return True if the file was successfully deleted; else
     *         false.
     *
     * @see #openFileInput
     * @see #openFileOutput
     * @see #fileList
     * @see java.io.File#delete()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.916 -0500", hash_original_method = "5C79B5C96938E780ED6DA72B2F25F47B", hash_generated_method = "7F6FD058AC0AA16AA498D9C8AAE3B078")
    
public abstract boolean deleteFile(String name);

    /**
     * Returns the absolute path on the filesystem where a file created with
     * {@link #openFileOutput} is stored.
     *
     * @param name The name of the file for which you would like to get
     *          its path.
     *
     * @return Returns an absolute path to the given file.
     *
     * @see #openFileOutput
     * @see #getFilesDir
     * @see #getDir
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.918 -0500", hash_original_method = "9A353D6569C6BEC86434D076A37F5A65", hash_generated_method = "434EA32C2C62DB5DD54141843080A7D3")
    
public abstract File getFileStreamPath(String name);

    /**
     * Returns the absolute path to the directory on the filesystem where
     * files created with {@link #openFileOutput} are stored.
     *
     * @return Returns the path of the directory holding application files.
     *
     * @see #openFileOutput
     * @see #getFileStreamPath
     * @see #getDir
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.920 -0500", hash_original_method = "876DBAEF3446A3BCF806918F15973E79", hash_generated_method = "1B23CBD89B8D00392FABFF3F660464F2")
    
public abstract File getFilesDir();

    /**
     * Returns the absolute path to the directory on the external filesystem
     * (that is somewhere on {@link android.os.Environment#getExternalStorageDirectory()
     * Environment.getExternalStorageDirectory()}) where the application can
     * place persistent files it owns.  These files are private to the
     * applications, and not typically visible to the user as media.
     *
     * <p>This is like {@link #getFilesDir()} in that these
     * files will be deleted when the application is uninstalled, however there
     * are some important differences:
     *
     * <ul>
     * <li>External files are not always available: they will disappear if the
     * user mounts the external storage on a computer or removes it.  See the
     * APIs on {@link android.os.Environment} for information in the storage state.
     * <li>There is no security enforced with these files.  All applications
     * can read and write files placed here.
     * </ul>
     *
     * <p>Here is an example of typical code to manipulate a file in
     * an application's private storage:</p>
     *
     * {@sample development/samples/ApiDemos/src/com/example/android/apis/content/ExternalStorage.java
     * private_file}
     *
     * <p>If you supply a non-null <var>type</var> to this function, the returned
     * file will be a path to a sub-directory of the given type.  Though these files
     * are not automatically scanned by the media scanner, you can explicitly
     * add them to the media database with
     * {@link android.media.MediaScannerConnection#scanFile(Context, String[], String[],
     *      OnScanCompletedListener) MediaScannerConnection.scanFile}.
     * Note that this is not the same as
     * {@link android.os.Environment#getExternalStoragePublicDirectory
     * Environment.getExternalStoragePublicDirectory()}, which provides
     * directories of media shared by all applications.  The
     * directories returned here are
     * owned by the application, and their contents will be removed when the
     * application is uninstalled.  Unlike
     * {@link android.os.Environment#getExternalStoragePublicDirectory
     * Environment.getExternalStoragePublicDirectory()}, the directory
     * returned here will be automatically created for you.
     *
     * <p>Here is an example of typical code to manipulate a picture in
     * an application's private storage and add it to the media database:</p>
     *
     * {@sample development/samples/ApiDemos/src/com/example/android/apis/content/ExternalStorage.java
     * private_picture}
     *
     * @param type The type of files directory to return.  May be null for
     * the root of the files directory or one of
     * the following Environment constants for a subdirectory:
     * {@link android.os.Environment#DIRECTORY_MUSIC},
     * {@link android.os.Environment#DIRECTORY_PODCASTS},
     * {@link android.os.Environment#DIRECTORY_RINGTONES},
     * {@link android.os.Environment#DIRECTORY_ALARMS},
     * {@link android.os.Environment#DIRECTORY_NOTIFICATIONS},
     * {@link android.os.Environment#DIRECTORY_PICTURES}, or
     * {@link android.os.Environment#DIRECTORY_MOVIES}.
     *
     * @return Returns the path of the directory holding application files
     * on external storage.  Returns null if external storage is not currently
     * mounted so it could not ensure the path exists; you will need to call
     * this method again when it is available.
     *
     * @see #getFilesDir
     * @see android.os.Environment#getExternalStoragePublicDirectory
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.922 -0500", hash_original_method = "0A68A7ED4304E520C4C4BE1D85F1E40A", hash_generated_method = "AB6B043865C07D01667A23CF19BC158B")
    
public abstract File getExternalFilesDir(String type);

    /**
     * Return the directory where this application's OBB files (if there
     * are any) can be found.  Note if the application does not have any OBB
     * files, this directory may not exist.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.924 -0500", hash_original_method = "A938DDE28A8E328C810E5D63E9AF5380", hash_generated_method = "1D4A7FAD43E05DE74E01D9C6EAFF4AC7")
    
public abstract File getObbDir();

    /**
     * Returns the absolute path to the application specific cache directory
     * on the filesystem. These files will be ones that get deleted first when the
     * device runs low on storage.
     * There is no guarantee when these files will be deleted.
     *
     * <strong>Note: you should not <em>rely</em> on the system deleting these
     * files for you; you should always have a reasonable maximum, such as 1 MB,
     * for the amount of space you consume with cache files, and prune those
     * files when exceeding that space.</strong>
     *
     * @return Returns the path of the directory holding application cache files.
     *
     * @see #openFileOutput
     * @see #getFileStreamPath
     * @see #getDir
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.926 -0500", hash_original_method = "E360556E62C838AA9E622386657A8DBC", hash_generated_method = "F778C1CABF9FB77070025876201F1166")
    
public abstract File getCacheDir();

    /**
     * Returns the absolute path to the directory on the external filesystem
     * (that is somewhere on {@link android.os.Environment#getExternalStorageDirectory()
     * Environment.getExternalStorageDirectory()} where the application can
     * place cache files it owns.
     *
     * <p>This is like {@link #getCacheDir()} in that these
     * files will be deleted when the application is uninstalled, however there
     * are some important differences:
     *
     * <ul>
     * <li>The platform does not monitor the space available in external storage,
     * and thus will not automatically delete these files.  Note that you should
     * be managing the maximum space you will use for these anyway, just like
     * with {@link #getCacheDir()}.
     * <li>External files are not always available: they will disappear if the
     * user mounts the external storage on a computer or removes it.  See the
     * APIs on {@link android.os.Environment} for information in the storage state.
     * <li>There is no security enforced with these files.  All applications
     * can read and write files placed here.
     * </ul>
     *
     * @return Returns the path of the directory holding application cache files
     * on external storage.  Returns null if external storage is not currently
     * mounted so it could not ensure the path exists; you will need to call
     * this method again when it is available.
     *
     * @see #getCacheDir
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.928 -0500", hash_original_method = "DC9C00B30E2B2D99DE9CCC7273B6CAC5", hash_generated_method = "9934C57497FC9CC239AA3AEAA11356D7")
    
public abstract File getExternalCacheDir();

    /**
     * Returns an array of strings naming the private files associated with
     * this Context's application package.
     *
     * @return Array of strings naming the private files.
     *
     * @see #openFileInput
     * @see #openFileOutput
     * @see #deleteFile
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.930 -0500", hash_original_method = "3846BDAC7C805AA359AC3AB66D267D1A", hash_generated_method = "D5AD25458EAB14444E66F9DC72E2FD10")
    
public abstract String[] fileList();

    /**
     * Retrieve, creating if needed, a new directory in which the application
     * can place its own custom data files.  You can use the returned File
     * object to create and access files in this directory.  Note that files
     * created through a File object will only be accessible by your own
     * application; you can only set the mode of the entire directory, not
     * of individual files.
     *
     * @param name Name of the directory to retrieve.  This is a directory
     * that is created as part of your application data.
     * @param mode Operating mode.  Use 0 or {@link #MODE_PRIVATE} for the
     * default operation, {@link #MODE_WORLD_READABLE} and
     * {@link #MODE_WORLD_WRITEABLE} to control permissions.
     *
     * @return Returns a File object for the requested directory.  The directory
     * will have been created if it does not already exist.
     *
     * @see #openFileOutput(String, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.933 -0500", hash_original_method = "0748EFF5A7B0F4DE21AD9D483062B85E", hash_generated_method = "BE5DE3DCA54F7B36439CA2C4C3243FFD")
    
public abstract File getDir(String name, int mode);

    /**
     * Open a new private SQLiteDatabase associated with this Context's
     * application package.  Create the database file if it doesn't exist.
     *
     * @param name The name (unique in the application package) of the database.
     * @param mode Operating mode.  Use 0 or {@link #MODE_PRIVATE} for the
     *     default operation, {@link #MODE_WORLD_READABLE}
     *     and {@link #MODE_WORLD_WRITEABLE} to control permissions.
     * @param factory An optional factory class that is called to instantiate a
     *     cursor when query is called.
     *
     * @return The contents of a newly created database with the given name.
     * @throws android.database.sqlite.SQLiteException if the database file could not be opened.
     *
     * @see #MODE_PRIVATE
     * @see #MODE_WORLD_READABLE
     * @see #MODE_WORLD_WRITEABLE
     * @see #deleteDatabase
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.935 -0500", hash_original_method = "BFF57F85E236CAFF9ED2A22B4F6E2D76", hash_generated_method = "B8D74B054158D9D916C437F4D1E303B4")
    
public abstract SQLiteDatabase openOrCreateDatabase(String name,
            int mode, CursorFactory factory);

    /**
     * Open a new private SQLiteDatabase associated with this Context's
     * application package.  Creates the database file if it doesn't exist.
     *
     * <p>Accepts input param: a concrete instance of {@link DatabaseErrorHandler} to be
     * used to handle corruption when sqlite reports database corruption.</p>
     *
     * @param name The name (unique in the application package) of the database.
     * @param mode Operating mode.  Use 0 or {@link #MODE_PRIVATE} for the
     *     default operation, {@link #MODE_WORLD_READABLE}
     *     and {@link #MODE_WORLD_WRITEABLE} to control permissions.
     * @param factory An optional factory class that is called to instantiate a
     *     cursor when query is called.
     * @param errorHandler the {@link DatabaseErrorHandler} to be used when sqlite reports database
     * corruption. if null, {@link android.database.DefaultDatabaseErrorHandler} is assumed.
     * @return The contents of a newly created database with the given name.
     * @throws android.database.sqlite.SQLiteException if the database file could not be opened.
     *
     * @see #MODE_PRIVATE
     * @see #MODE_WORLD_READABLE
     * @see #MODE_WORLD_WRITEABLE
     * @see #deleteDatabase
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.937 -0500", hash_original_method = "CFF138C98810AAFA3C986D948D608695", hash_generated_method = "AD10CBC6F1D9E099B1D84A094353EE98")
    
public abstract SQLiteDatabase openOrCreateDatabase(String name,
            int mode, CursorFactory factory, DatabaseErrorHandler errorHandler);

    /**
     * Delete an existing private SQLiteDatabase associated with this Context's
     * application package.
     *
     * @param name The name (unique in the application package) of the
     *             database.
     *
     * @return True if the database was successfully deleted; else false.
     *
     * @see #openOrCreateDatabase
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.940 -0500", hash_original_method = "1752316DB0D9A8E81BD94E2CBBA178EF", hash_generated_method = "54E202FF29C8ED4DA7B3D196BAE2C3F3")
    
public abstract boolean deleteDatabase(String name);

    /**
     * Returns the absolute path on the filesystem where a database created with
     * {@link #openOrCreateDatabase} is stored.
     *
     * @param name The name of the database for which you would like to get
     *          its path.
     *
     * @return Returns an absolute path to the given database.
     *
     * @see #openOrCreateDatabase
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.942 -0500", hash_original_method = "583C17FC6B7E3DFFAAC0FC45F39C8AC8", hash_generated_method = "BC032AB9741AD2FF24A24A1FBCBE105C")
    
public abstract File getDatabasePath(String name);

    /**
     * Returns an array of strings naming the private databases associated with
     * this Context's application package.
     *
     * @return Array of strings naming the private databases.
     *
     * @see #openOrCreateDatabase
     * @see #deleteDatabase
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.944 -0500", hash_original_method = "B8230282CF48DD10A0E383A5447D91F5", hash_generated_method = "6F1F0DDAE14858816E53036B48A64355")
    
public abstract String[] databaseList();

    /**
     * @deprecated Use {@link android.app.WallpaperManager#getDrawable
     * WallpaperManager.get()} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.947 -0500", hash_original_method = "182231136535D970944A9B258D915F9F", hash_generated_method = "589709498287BB248804743F73FCA22E")
    
@Deprecated
    public abstract Drawable getWallpaper();

    /**
     * @deprecated Use {@link android.app.WallpaperManager#peekDrawable
     * WallpaperManager.peek()} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.949 -0500", hash_original_method = "726650C1ADA39FFA8794A1993404CF02", hash_generated_method = "A0AC3D831F075845E73FAF1EE2B8634E")
    
@Deprecated
    public abstract Drawable peekWallpaper();

    /**
     * @deprecated Use {@link android.app.WallpaperManager#getDesiredMinimumWidth()
     * WallpaperManager.getDesiredMinimumWidth()} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.951 -0500", hash_original_method = "928FC8C975BE0E1A39B3739458516914", hash_generated_method = "89162B3A7B68544F63F98A859579E10F")
    
@Deprecated
    public abstract int getWallpaperDesiredMinimumWidth();

    /**
     * @deprecated Use {@link android.app.WallpaperManager#getDesiredMinimumHeight()
     * WallpaperManager.getDesiredMinimumHeight()} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.953 -0500", hash_original_method = "42509641D6B1A0F324345BEAFC0B38ED", hash_generated_method = "67208C119AA23A017985B117412CC4D2")
    
@Deprecated
    public abstract int getWallpaperDesiredMinimumHeight();

    /**
     * @deprecated Use {@link android.app.WallpaperManager#setBitmap(Bitmap)
     * WallpaperManager.set()} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.956 -0500", hash_original_method = "775F800C43A170AB1D94B9DE3EB73A03", hash_generated_method = "FC834CE53A3C8F15A47F34306A05660C")
    
@Deprecated
    public abstract void setWallpaper(Bitmap bitmap) throws IOException;

    /**
     * @deprecated Use {@link android.app.WallpaperManager#setStream(InputStream)
     * WallpaperManager.set()} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.958 -0500", hash_original_method = "0CE3AC6E229A689146C2AE2160D4B98D", hash_generated_method = "BC1C1B5E0500197919BCDC640B5E2B15")
    
@Deprecated
    public abstract void setWallpaper(InputStream data) throws IOException;

    /**
     * @deprecated Use {@link android.app.WallpaperManager#clear
     * WallpaperManager.clear()} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.961 -0500", hash_original_method = "C306CC7DBE60ED06767F2017979CF098", hash_generated_method = "7F82426C2707E5A28633D9A28B10B23C")
    
@Deprecated
    public abstract void clearWallpaper() throws IOException;

    /**
     * Launch a new activity.  You will not receive any information about when
     * the activity exits.
     *
     * <p>Note that if this method is being called from outside of an
     * {@link android.app.Activity} Context, then the Intent must include
     * the {@link Intent#FLAG_ACTIVITY_NEW_TASK} launch flag.  This is because,
     * without being started from an existing Activity, there is no existing
     * task in which to place the new activity and thus it needs to be placed
     * in its own separate task.
     *
     * <p>This method throws {@link ActivityNotFoundException}
     * if there was no Activity found to run the given Intent.
     *
     * @param intent The description of the activity to start.
     *
     * @throws ActivityNotFoundException
     *
     * @see PackageManager#resolveActivity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.963 -0500", hash_original_method = "06B12B71B896DBD5D7C902DA38D16681", hash_generated_method = "BC85A3AAC104AF5786AD1DC454AD7A2D")
    
public abstract void startActivity(Intent intent);

    /**
     * Launch multiple new activities.  This is generally the same as calling
     * {@link #startActivity(Intent)} for the first Intent in the array,
     * that activity during its creation calling {@link #startActivity(Intent)}
     * for the second entry, etc.  Note that unlike that approach, generally
     * none of the activities except the last in the array will be created
     * at this point, but rather will be created when the user first visits
     * them (due to pressing back from the activity on top).
     *
     * <p>This method throws {@link ActivityNotFoundException}
     * if there was no Activity found for <em>any</em> given Intent.  In this
     * case the state of the activity stack is undefined (some Intents in the
     * list may be on it, some not), so you probably want to avoid such situations.
     *
     * @param intents An array of Intents to be started.
     *
     * @throws ActivityNotFoundException
     *
     * @see PackageManager#resolveActivity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.965 -0500", hash_original_method = "805B1869BDFCE06BF619D5A658DF064F", hash_generated_method = "A0E9D7EE9D2E9CF7F658AE830D92157B")
    
public abstract void startActivities(Intent[] intents);

    /**
     * Like {@link #startActivity(Intent)}, but taking a IntentSender
     * to start.  If the IntentSender is for an activity, that activity will be started
     * as if you had called the regular {@link #startActivity(Intent)}
     * here; otherwise, its associated action will be executed (such as
     * sending a broadcast) as if you had called
     * {@link IntentSender#sendIntent IntentSender.sendIntent} on it.
     *
     * @param intent The IntentSender to launch.
     * @param fillInIntent If non-null, this will be provided as the
     * intent parameter to {@link IntentSender#sendIntent}.
     * @param flagsMask Intent flags in the original IntentSender that you
     * would like to change.
     * @param flagsValues Desired values for any bits set in
     * <var>flagsMask</var>
     * @param extraFlags Always set to 0.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.967 -0500", hash_original_method = "8B78B83B6D3FFF1A93A5438E593C534B", hash_generated_method = "4F9ECCA0303DC7065C10CDBCBFA92195")
    
public abstract void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags)
            throws IntentSender.SendIntentException;

    /**
     * Broadcast the given intent to all interested BroadcastReceivers.  This
     * call is asynchronous; it returns immediately, and you will continue
     * executing while the receivers are run.  No results are propagated from
     * receivers and receivers can not abort the broadcast. If you want
     * to allow receivers to propagate results or abort the broadcast, you must
     * send an ordered broadcast using
     * {@link #sendOrderedBroadcast(Intent, String)}.
     *
     * <p>See {@link BroadcastReceiver} for more information on Intent broadcasts.
     *
     * @param intent The Intent to broadcast; all receivers matching this
     *               Intent will receive the broadcast.
     *
     * @see android.content.BroadcastReceiver
     * @see #registerReceiver
     * @see #sendBroadcast(Intent, String)
     * @see #sendOrderedBroadcast(Intent, String)
     * @see #sendOrderedBroadcast(Intent, String, BroadcastReceiver, Handler, int, String, Bundle)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.969 -0500", hash_original_method = "758F82A7831A3E63BFA33BC1D51204CD", hash_generated_method = "562685EAD67DEDBF8ECDCC3E48DED167")
    
public abstract void sendBroadcast(Intent intent);

    /**
     * Broadcast the given intent to all interested BroadcastReceivers, allowing
     * an optional required permission to be enforced.  This
     * call is asynchronous; it returns immediately, and you will continue
     * executing while the receivers are run.  No results are propagated from
     * receivers and receivers can not abort the broadcast. If you want
     * to allow receivers to propagate results or abort the broadcast, you must
     * send an ordered broadcast using
     * {@link #sendOrderedBroadcast(Intent, String)}.
     *
     * <p>See {@link BroadcastReceiver} for more information on Intent broadcasts.
     *
     * @param intent The Intent to broadcast; all receivers matching this
     *               Intent will receive the broadcast.
     * @param receiverPermission (optional) String naming a permission that
     *               a receiver must hold in order to receive your broadcast.
     *               If null, no permission is required.
     *
     * @see android.content.BroadcastReceiver
     * @see #registerReceiver
     * @see #sendBroadcast(Intent)
     * @see #sendOrderedBroadcast(Intent, String)
     * @see #sendOrderedBroadcast(Intent, String, BroadcastReceiver, Handler, int, String, Bundle)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.971 -0500", hash_original_method = "BD64097323B630BD418E3BBAB8229A5A", hash_generated_method = "99A1B49845C72E86D3E83EC3A7954E4F")
    
public abstract void sendBroadcast(Intent intent,
            String receiverPermission);

    /**
     * Broadcast the given intent to all interested BroadcastReceivers, delivering
     * them one at a time to allow more preferred receivers to consume the
     * broadcast before it is delivered to less preferred receivers.  This
     * call is asynchronous; it returns immediately, and you will continue
     * executing while the receivers are run.
     *
     * <p>See {@link BroadcastReceiver} for more information on Intent broadcasts.
     *
     * @param intent The Intent to broadcast; all receivers matching this
     *               Intent will receive the broadcast.
     * @param receiverPermission (optional) String naming a permissions that
     *               a receiver must hold in order to receive your broadcast.
     *               If null, no permission is required.
     *
     * @see android.content.BroadcastReceiver
     * @see #registerReceiver
     * @see #sendBroadcast(Intent)
     * @see #sendOrderedBroadcast(Intent, String, BroadcastReceiver, Handler, int, String, Bundle)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.973 -0500", hash_original_method = "4819235453B1EB0A02E9B2B19D176EA5", hash_generated_method = "C8A50F78D35C84BBE5A0A5E97023628C")
    
public abstract void sendOrderedBroadcast(Intent intent,
            String receiverPermission);

    /**
     * Version of {@link #sendBroadcast(Intent)} that allows you to
     * receive data back from the broadcast.  This is accomplished by
     * supplying your own BroadcastReceiver when calling, which will be
     * treated as a final receiver at the end of the broadcast -- its
     * {@link BroadcastReceiver#onReceive} method will be called with
     * the result values collected from the other receivers.  The broadcast will
     * be serialized in the same way as calling
     * {@link #sendOrderedBroadcast(Intent, String)}.
     *
     * <p>Like {@link #sendBroadcast(Intent)}, this method is
     * asynchronous; it will return before
     * resultReceiver.onReceive() is called.
     *
     * <p>See {@link BroadcastReceiver} for more information on Intent broadcasts.
     *
     * @param intent The Intent to broadcast; all receivers matching this
     *               Intent will receive the broadcast.
     * @param receiverPermission String naming a permissions that
     *               a receiver must hold in order to receive your broadcast.
     *               If null, no permission is required.
     * @param resultReceiver Your own BroadcastReceiver to treat as the final
     *                       receiver of the broadcast.
     * @param scheduler A custom Handler with which to schedule the
     *                  resultReceiver callback; if null it will be
     *                  scheduled in the Context's main thread.
     * @param initialCode An initial value for the result code.  Often
     *                    Activity.RESULT_OK.
     * @param initialData An initial value for the result data.  Often
     *                    null.
     * @param initialExtras An initial value for the result extras.  Often
     *                      null.
     *
     * @see #sendBroadcast(Intent)
     * @see #sendBroadcast(Intent, String)
     * @see #sendOrderedBroadcast(Intent, String)
     * @see #sendStickyBroadcast(Intent)
     * @see #sendStickyOrderedBroadcast(Intent, BroadcastReceiver, Handler, int, String, Bundle)
     * @see android.content.BroadcastReceiver
     * @see #registerReceiver
     * @see android.app.Activity#RESULT_OK
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.976 -0500", hash_original_method = "F7F06BF835757EA8F337533771196C96", hash_generated_method = "66B9FEF66D5275FE598D2CA96213915A")
    
public abstract void sendOrderedBroadcast(Intent intent,
            String receiverPermission, BroadcastReceiver resultReceiver,
            Handler scheduler, int initialCode, String initialData,
            Bundle initialExtras);

    /**
     * Perform a {@link #sendBroadcast(Intent)} that is "sticky," meaning the
     * Intent you are sending stays around after the broadcast is complete,
     * so that others can quickly retrieve that data through the return
     * value of {@link #registerReceiver(BroadcastReceiver, IntentFilter)}.  In
     * all other ways, this behaves the same as
     * {@link #sendBroadcast(Intent)}.
     *
     * <p>You must hold the {@link android.Manifest.permission#BROADCAST_STICKY}
     * permission in order to use this API.  If you do not hold that
     * permission, {@link SecurityException} will be thrown.
     *
     * @param intent The Intent to broadcast; all receivers matching this
     * Intent will receive the broadcast, and the Intent will be held to
     * be re-broadcast to future receivers.
     *
     * @see #sendBroadcast(Intent)
     * @see #sendStickyOrderedBroadcast(Intent, BroadcastReceiver, Handler, int, String, Bundle)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.978 -0500", hash_original_method = "EBC415C0B4A9F508CD7CFAFD71BBCC4E", hash_generated_method = "72631BAFAFE1DEE59543EA72FA63139E")
    
public abstract void sendStickyBroadcast(Intent intent);

    /**
     * Version of {@link #sendStickyBroadcast} that allows you to
     * receive data back from the broadcast.  This is accomplished by
     * supplying your own BroadcastReceiver when calling, which will be
     * treated as a final receiver at the end of the broadcast -- its
     * {@link BroadcastReceiver#onReceive} method will be called with
     * the result values collected from the other receivers.  The broadcast will
     * be serialized in the same way as calling
     * {@link #sendOrderedBroadcast(Intent, String)}.
     *
     * <p>Like {@link #sendBroadcast(Intent)}, this method is
     * asynchronous; it will return before
     * resultReceiver.onReceive() is called.  Note that the sticky data
     * stored is only the data you initially supply to the broadcast, not
     * the result of any changes made by the receivers.
     *
     * <p>See {@link BroadcastReceiver} for more information on Intent broadcasts.
     *
     * @param intent The Intent to broadcast; all receivers matching this
     *               Intent will receive the broadcast.
     * @param resultReceiver Your own BroadcastReceiver to treat as the final
     *                       receiver of the broadcast.
     * @param scheduler A custom Handler with which to schedule the
     *                  resultReceiver callback; if null it will be
     *                  scheduled in the Context's main thread.
     * @param initialCode An initial value for the result code.  Often
     *                    Activity.RESULT_OK.
     * @param initialData An initial value for the result data.  Often
     *                    null.
     * @param initialExtras An initial value for the result extras.  Often
     *                      null.
     *
     * @see #sendBroadcast(Intent)
     * @see #sendBroadcast(Intent, String)
     * @see #sendOrderedBroadcast(Intent, String)
     * @see #sendStickyBroadcast(Intent)
     * @see android.content.BroadcastReceiver
     * @see #registerReceiver
     * @see android.app.Activity#RESULT_OK
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.980 -0500", hash_original_method = "93DED7B582D7EACDC4FD6F46909C6664", hash_generated_method = "ACA4150575708078A8D06985E00FFB4B")
    
public abstract void sendStickyOrderedBroadcast(Intent intent,
            BroadcastReceiver resultReceiver,
            Handler scheduler, int initialCode, String initialData,
            Bundle initialExtras);

    /**
     * Remove the data previously sent with {@link #sendStickyBroadcast},
     * so that it is as if the sticky broadcast had never happened.
     *
     * <p>You must hold the {@link android.Manifest.permission#BROADCAST_STICKY}
     * permission in order to use this API.  If you do not hold that
     * permission, {@link SecurityException} will be thrown.
     *
     * @param intent The Intent that was previously broadcast.
     *
     * @see #sendStickyBroadcast
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.983 -0500", hash_original_method = "B56100FC007C9CF0EE28A7BE5317FB3F", hash_generated_method = "A2505F97015E7AB0FAE481D35AF7E281")
    
public abstract void removeStickyBroadcast(Intent intent);

    /**
     * Register a BroadcastReceiver to be run in the main activity thread.  The
     * <var>receiver</var> will be called with any broadcast Intent that
     * matches <var>filter</var>, in the main application thread.
     *
     * <p>The system may broadcast Intents that are "sticky" -- these stay
     * around after the broadcast as finished, to be sent to any later
     * registrations. If your IntentFilter matches one of these sticky
     * Intents, that Intent will be returned by this function
     * <strong>and</strong> sent to your <var>receiver</var> as if it had just
     * been broadcast.
     *
     * <p>There may be multiple sticky Intents that match <var>filter</var>,
     * in which case each of these will be sent to <var>receiver</var>.  In
     * this case, only one of these can be returned directly by the function;
     * which of these that is returned is arbitrarily decided by the system.
     *
     * <p>If you know the Intent your are registering for is sticky, you can
     * supply null for your <var>receiver</var>.  In this case, no receiver is
     * registered -- the function simply returns the sticky Intent that
     * matches <var>filter</var>.  In the case of multiple matches, the same
     * rules as described above apply.
     *
     * <p>See {@link BroadcastReceiver} for more information on Intent broadcasts.
     *
     * <p>As of {@link android.os.Build.VERSION_CODES#ICE_CREAM_SANDWICH}, receivers
     * registered with this method will correctly respect the
     * {@link Intent#setPackage(String)} specified for an Intent being broadcast.
     * Prior to that, it would be ignored and delivered to all matching registered
     * receivers.  Be careful if using this for security.</p>
     *
     * <p class="note">Note: this method <em>cannot be called from a
     * {@link BroadcastReceiver} component;</em> that is, from a BroadcastReceiver
     * that is declared in an application's manifest.  It is okay, however, to call
     * this method from another BroadcastReceiver that has itself been registered
     * at run time with {@link #registerReceiver}, since the lifetime of such a
     * registered BroadcastReceiver is tied to the object that registered it.</p>
     *
     * @param receiver The BroadcastReceiver to handle the broadcast.
     * @param filter Selects the Intent broadcasts to be received.
     *
     * @return The first sticky intent found that matches <var>filter</var>,
     *         or null if there are none.
     *
     * @see #registerReceiver(BroadcastReceiver, IntentFilter, String, Handler)
     * @see #sendBroadcast
     * @see #unregisterReceiver
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.985 -0500", hash_original_method = "A6B23878A18269BFB006C7A17DB19C65", hash_generated_method = "51315EAC9DE25C2EDA33324D2830C956")
    
public abstract Intent registerReceiver(BroadcastReceiver receiver,
                                            IntentFilter filter);

    /**
     * Register to receive intent broadcasts, to run in the context of
     * <var>scheduler</var>.  See
     * {@link #registerReceiver(BroadcastReceiver, IntentFilter)} for more
     * information.  This allows you to enforce permissions on who can
     * broadcast intents to your receiver, or have the receiver run in
     * a different thread than the main application thread.
     *
     * <p>See {@link BroadcastReceiver} for more information on Intent broadcasts.
     *
     * <p>As of {@link android.os.Build.VERSION_CODES#ICE_CREAM_SANDWICH}, receivers
     * registered with this method will correctly respect the
     * {@link Intent#setPackage(String)} specified for an Intent being broadcast.
     * Prior to that, it would be ignored and delivered to all matching registered
     * receivers.  Be careful if using this for security.</p>
     *
     * @param receiver The BroadcastReceiver to handle the broadcast.
     * @param filter Selects the Intent broadcasts to be received.
     * @param broadcastPermission String naming a permissions that a
     *      broadcaster must hold in order to send an Intent to you.  If null,
     *      no permission is required.
     * @param scheduler Handler identifying the thread that will receive
     *      the Intent.  If null, the main thread of the process will be used.
     *
     * @return The first sticky intent found that matches <var>filter</var>,
     *         or null if there are none.
     *
     * @see #registerReceiver(BroadcastReceiver, IntentFilter)
     * @see #sendBroadcast
     * @see #unregisterReceiver
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.987 -0500", hash_original_method = "43BFB7B71F28DFD8E995A19B52DAC398", hash_generated_method = "EA7684A5E9DC86281F4D7A6AE2E42DED")
    
public abstract Intent registerReceiver(BroadcastReceiver receiver,
                                            IntentFilter filter,
                                            String broadcastPermission,
                                            Handler scheduler);

    /**
     * Unregister a previously registered BroadcastReceiver.  <em>All</em>
     * filters that have been registered for this BroadcastReceiver will be
     * removed.
     *
     * @param receiver The BroadcastReceiver to unregister.
     *
     * @see #registerReceiver
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.990 -0500", hash_original_method = "A9535E587929A917D1046B408007AAB8", hash_generated_method = "B1E9C90A32AC9A1F8ABA260A8A39EB87")
    
public abstract void unregisterReceiver(BroadcastReceiver receiver);

    /**
     * Request that a given application service be started.  The Intent
     * can either contain the complete class name of a specific service
     * implementation to start, or an abstract definition through the
     * action and other fields of the kind of service to start.  If this service
     * is not already running, it will be instantiated and started (creating a
     * process for it if needed); if it is running then it remains running.
     *
     * <p>Every call to this method will result in a corresponding call to
     * the target service's {@link android.app.Service#onStartCommand} method,
     * with the <var>intent</var> given here.  This provides a convenient way
     * to submit jobs to a service without having to bind and call on to its
     * interface.
     *
     * <p>Using startService() overrides the default service lifetime that is
     * managed by {@link #bindService}: it requires the service to remain
     * running until {@link #stopService} is called, regardless of whether
     * any clients are connected to it.  Note that calls to startService()
     * are not nesting: no matter how many times you call startService(),
     * a single call to {@link #stopService} will stop it.
     *
     * <p>The system attempts to keep running services around as much as
     * possible.  The only time they should be stopped is if the current
     * foreground application is using so many resources that the service needs
     * to be killed.  If any errors happen in the service's process, it will
     * automatically be restarted.
     *
     * <p>This function will throw {@link SecurityException} if you do not
     * have permission to start the given service.
     *
     * @param service Identifies the service to be started.  The Intent may
     *      specify either an explicit component name to start, or a logical
     *      description (action, category, etc) to match an
     *      {@link IntentFilter} published by a service.  Additional values
     *      may be included in the Intent extras to supply arguments along with
     *      this specific start call.
     *
     * @return If the service is being started or is already running, the
     * {@link ComponentName} of the actual service that was started is
     * returned; else if the service does not exist null is returned.
     *
     * @throws SecurityException
     *
     * @see #stopService
     * @see #bindService
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.992 -0500", hash_original_method = "299DC35BFC98468366A24298AABF9029", hash_generated_method = "9E29465F9BF8E95E0E1D32A7BC59A66B")
    
public abstract ComponentName startService(Intent service);

    /**
     * Request that a given application service be stopped.  If the service is
     * not running, nothing happens.  Otherwise it is stopped.  Note that calls
     * to startService() are not counted -- this stops the service no matter
     * how many times it was started.
     *
     * <p>Note that if a stopped service still has {@link ServiceConnection}
     * objects bound to it with the {@link #BIND_AUTO_CREATE} set, it will
     * not be destroyed until all of these bindings are removed.  See
     * the {@link android.app.Service} documentation for more details on a
     * service's lifecycle.
     *
     * <p>This function will throw {@link SecurityException} if you do not
     * have permission to stop the given service.
     *
     * @param service Description of the service to be stopped.  The Intent may
     *      specify either an explicit component name to start, or a logical
     *      description (action, category, etc) to match an
     *      {@link IntentFilter} published by a service.
     *
     * @return If there is a service matching the given Intent that is already
     * running, then it is stopped and true is returned; else false is returned.
     *
     * @throws SecurityException
     *
     * @see #startService
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.994 -0500", hash_original_method = "C04E26FF6D7273574E38F7525B1B5BFE", hash_generated_method = "D1BBC18DADDAD8020B4B7AF9615658E7")
    
public abstract boolean stopService(Intent service);

    /**
     * Connect to an application service, creating it if needed.  This defines
     * a dependency between your application and the service.  The given
     * <var>conn</var> will receive the service object when its created and be
     * told if it dies and restarts.  The service will be considered required
     * by the system only for as long as the calling context exists.  For
     * example, if this Context is an Activity that is stopped, the service will
     * not be required to continue running until the Activity is resumed.
     *
     * <p>This function will throw {@link SecurityException} if you do not
     * have permission to bind to the given service.
     *
     * <p class="note">Note: this method <em>can not be called from an
     * {@link BroadcastReceiver} component</em>.  A pattern you can use to
     * communicate from an BroadcastReceiver to a Service is to call
     * {@link #startService} with the arguments containing the command to be
     * sent, with the service calling its
     * {@link android.app.Service#stopSelf(int)} method when done executing
     * that command.  See the API demo App/Service/Service Start Arguments
     * Controller for an illustration of this.  It is okay, however, to use
     * this method from an BroadcastReceiver that has been registered with
     * {@link #registerReceiver}, since the lifetime of this BroadcastReceiver
     * is tied to another object (the one that registered it).</p>
     *
     * @param service Identifies the service to connect to.  The Intent may
     *      specify either an explicit component name, or a logical
     *      description (action, category, etc) to match an
     *      {@link IntentFilter} published by a service.
     * @param conn Receives information as the service is started and stopped.
     * @param flags Operation options for the binding.  May be 0,
     *          {@link #BIND_AUTO_CREATE}, {@link #BIND_DEBUG_UNBIND},
     *          {@link #BIND_NOT_FOREGROUND}, {@link #BIND_ABOVE_CLIENT},
     *          {@link #BIND_ALLOW_OOM_MANAGEMENT}, or
     *          {@link #BIND_WAIVE_PRIORITY}.
     * @return If you have successfully bound to the service, true is returned;
     *         false is returned if the connection is not made so you will not
     *         receive the service object.
     *
     * @throws SecurityException
     *
     * @see #unbindService
     * @see #startService
     * @see #BIND_AUTO_CREATE
     * @see #BIND_DEBUG_UNBIND
     * @see #BIND_NOT_FOREGROUND
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.997 -0500", hash_original_method = "BF9EC72D463D2576E4637238C7B5F8A3", hash_generated_method = "4F1CE20356B579F43B07AF5AA56DEB85")
    
public abstract boolean bindService(Intent service, ServiceConnection conn,
            int flags);

    /**
     * Disconnect from an application service.  You will no longer receive
     * calls as the service is restarted, and the service is now allowed to
     * stop at any time.
     *
     * @param conn The connection interface previously supplied to
     *             bindService().
     *
     * @see #bindService
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:29.999 -0500", hash_original_method = "AD50D89FB73F95E5DD03D493BB040603", hash_generated_method = "7E573E5A290A954C1D1A58189D55F91E")
    
public abstract void unbindService(ServiceConnection conn);

    /**
     * Start executing an {@link android.app.Instrumentation} class.  The given
     * Instrumentation component will be run by killing its target application
     * (if currently running), starting the target process, instantiating the
     * instrumentation component, and then letting it drive the application.
     *
     * <p>This function is not synchronous -- it returns as soon as the
     * instrumentation has started and while it is running.
     *
     * <p>Instrumentation is normally only allowed to run against a package
     * that is either unsigned or signed with a signature that the
     * the instrumentation package is also signed with (ensuring the target
     * trusts the instrumentation).
     *
     * @param className Name of the Instrumentation component to be run.
     * @param profileFile Optional path to write profiling data as the
     * instrumentation runs, or null for no profiling.
     * @param arguments Additional optional arguments to pass to the
     * instrumentation, or null.
     *
     * @return Returns true if the instrumentation was successfully started,
     * else false if it could not be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.001 -0500", hash_original_method = "3C9955724D7C03F7ACC1E0BE919D98ED", hash_generated_method = "0DBFD3D71F36926811CCCD08EE1A8C4E")
    
public abstract boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments);
    
    public Object getSystemService(String name) {
        switch (name) {
           
            case ACCOUNT_SERVICE: {
                AccountManager manager = new AccountManager();
                manager.addTaint(getTaint());
                return manager;
            }
            case ACTIVITY_SERVICE: {
                ActivityManager manager = new ActivityManager(this);
                manager.addTaint(getTaint());
                return manager;
            }
            case ALARM_SERVICE: {
                AlarmManager manager = new AlarmManager();
                manager.addTaint(getTaint());
                return manager;
            }
            
            case ACCESSIBILITY_SERVICE: {
                AccessibilityManager manager = AccessibilityManager.getInstance(this);
                manager.addTaint(getTaint());
                return manager;
            }
            case AUDIO_SERVICE: {
                AudioManager manager = new AudioManager(this);
                manager.addTaint(getTaint());
                return manager;
            }
            case APPWIDGET_SERVICE: {
                break;
            }
            case BACKUP_SERVICE: {
                break;
            }
            
           case CLIPBOARD_SERVICE: {
               ClipboardManager manager = new ClipboardManager(this);
               manager.addTaint(getTaint());
               return manager;
            }

           case CONNECTIVITY_SERVICE: {
               ConnectivityManager manager = new ConnectivityManager();
               manager.addTaint(getTaint());
               return manager;
           }
            case COUNTRY_DETECTOR: {
                CountryDetector manager = new CountryDetector();
                manager.addTaint(getTaint());
                return manager;
            }
            case DEVICE_POLICY_SERVICE: {
                DevicePolicyManager manager = new DevicePolicyManager(this);
                manager.addTaint(getTaint());
                return manager;
            }
            case DOWNLOAD_SERVICE: {
                DownloadManager manager = new DownloadManager(this.getContentResolver(), this.getPackageName());
                manager.addTaint(getTaint());
                return manager;
            }
            case DROPBOX_SERVICE: {
                DropBoxManager manager = new DropBoxManager();
                manager.addTaint(getTaint());
                return manager;
            }
            case INPUT_METHOD_SERVICE: {
                InputMethodManager manager = InputMethodManager.getInstance(this);
                manager.addTaint(getTaint());
                return manager;
            }

            case KEYGUARD_SERVICE: {
                KeyguardManager manager = new KeyguardManager();
                manager.addTaint(getTaint());
                return manager;
            }
            case LAYOUT_INFLATER_SERVICE: {
                LayoutInflater manager = PolicyManager.makeNewLayoutInflater(this);
                manager.addTaint(getTaint());
                return manager;
            }
            case LOCATION_SERVICE: {
                //IBinder b4 = ServiceManager.getService(LOCATION_SERVICE);
                //LocationManager manager = new LocationManager(ILocationManager.Stub.asInterface(b4));

                LocationManager manager = new LocationManager();
                manager.addTaint(getTaint());
                return manager;
            } 
            case NFC_SERVICE: {
                NfcManager manager = new NfcManager(this);
                manager.addTaint(getTaint());
                return manager;
            }
            case NETWORKMANAGEMENT_SERVICE: {
                break;
            }
            case NETWORK_STATS_SERVICE: {
                break;
            }
            case NETWORK_POLICY_SERVICE: {
                NetworkPolicyManager manager = new NetworkPolicyManager();
                manager.addTaint(getTaint());
                return manager;
            }
            case NOTIFICATION_SERVICE: {
                NotificationManager manager = new NotificationManager(this);
                manager.addTaint(getTaint());
                return manager;
            }

            case SEARCH_SERVICE: {
                SearchManager manager = new SearchManager(this); 
                manager.addTaint(getTaint());
                return manager;
            }

            case POWER_SERVICE: {
                PowerManager manager = new PowerManager();
                manager.addTaint(getTaint());
                return manager;
            }

            case SENSOR_SERVICE: {
                break;
            }
            case SIP_SERVICE: {
                break;
            }
            case STORAGE_SERVICE: {
                StorageManager manager;
                manager = new StorageManager();
                manager.addTaint(getTaint());
                return manager;
            }
            case STATUS_BAR_SERVICE: {
                StatusBarManager manager = StatusBarManager.createInstance(this);
                manager.addTaint(getTaint());
                return manager;
            }
            case TELEPHONY_SERVICE: {
                TelephonyManager manager = new TelephonyManager(this);
                manager.addTaint(getTaint());
                return manager;
            }
            case TEXT_SERVICES_MANAGER_SERVICE: {
                TextServicesManager manager = TextServicesManager.getInstance();
                manager.addTaint(getTaint());
                return manager;
            }
            case THROTTLE_SERVICE: {
                ThrottleManager manager = ThrottleManager.createInstance();
                manager.addTaint(getTaint());
                return manager;
            }
            case UI_MODE_SERVICE: {
                UiModeManager manager = UiModeManager.createInstance();
                manager.addTaint(getTaint());
                return manager;
            }
            case USB_SERVICE: {
                UsbManager manager = new UsbManager(this);
                manager.addTaint(getTaint());
                return manager;
            }
            case VIBRATOR_SERVICE: {
                Vibrator manager = new Vibrator();
                manager.addTaint(getTaint());
                return manager;
            }

            case WALLPAPER_SERVICE: {
            }
            case WIFI_SERVICE: {
                WifiManager manager = new WifiManager();
                manager.addTaint(getTaint());
                return manager;
            }
            case WIFI_P2P_SERVICE: {
                WifiP2pManager manager = new WifiP2pManager();
                manager.addTaint(getTaint());
                return manager;

            }
            case WINDOW_SERVICE: {
                WindowManager manager = WindowManagerImpl.getDefault();
                manager.addTaint(getTaint());
                return manager;
            }
            
            default: {
            }
        }
        
        Object obj = new Object();
        obj.addTaint(getTaint());
        return obj;
    }

    /**
     * Determine whether the given permission is allowed for a particular
     * process and user ID running in the system.
     *
     * @param permission The name of the permission being checked.
     * @param pid The process ID being checked against.  Must be > 0.
     * @param uid The user ID being checked against.  A uid of 0 is the root
     * user, which will pass every permission check.
     *
     * @return Returns {@link PackageManager#PERMISSION_GRANTED} if the given
     * pid/uid is allowed that permission, or
     * {@link PackageManager#PERMISSION_DENIED} if it is not.
     *
     * @see PackageManager#checkPermission(String, String)
     * @see #checkCallingPermission
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.096 -0500", hash_original_method = "D082A88B633CDD955121276C7960A1D2", hash_generated_method = "1A9A760C3F34E8BF41431C8FE359FD71")
    
public abstract int checkPermission(String permission, int pid, int uid);

    /**
     * Determine whether the calling process of an IPC you are handling has been
     * granted a particular permission.  This is basically the same as calling
     * {@link #checkPermission(String, int, int)} with the pid and uid returned
     * by {@link android.os.Binder#getCallingPid} and
     * {@link android.os.Binder#getCallingUid}.  One important difference
     * is that if you are not currently processing an IPC, this function
     * will always fail.  This is done to protect against accidentally
     * leaking permissions; you can use {@link #checkCallingOrSelfPermission}
     * to avoid this protection.
     *
     * @param permission The name of the permission being checked.
     *
     * @return Returns {@link PackageManager#PERMISSION_GRANTED} if the calling
     * pid/uid is allowed that permission, or
     * {@link PackageManager#PERMISSION_DENIED} if it is not.
     *
     * @see PackageManager#checkPermission(String, String)
     * @see #checkPermission
     * @see #checkCallingOrSelfPermission
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.098 -0500", hash_original_method = "2FE84AD3C8A7AFA7A1E0B323E24D90CD", hash_generated_method = "B8B1FBDB366F09EB9BA4DA6C5F1B52A6")
    
public abstract int checkCallingPermission(String permission);

    /**
     * Determine whether the calling process of an IPC <em>or you</em> have been
     * granted a particular permission.  This is the same as
     * {@link #checkCallingPermission}, except it grants your own permissions
     * if you are not currently processing an IPC.  Use with care!
     *
     * @param permission The name of the permission being checked.
     *
     * @return Returns {@link PackageManager#PERMISSION_GRANTED} if the calling
     * pid/uid is allowed that permission, or
     * {@link PackageManager#PERMISSION_DENIED} if it is not.
     *
     * @see PackageManager#checkPermission(String, String)
     * @see #checkPermission
     * @see #checkCallingPermission
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.100 -0500", hash_original_method = "D24832CC3F7AAF93206CABCBAC5A8475", hash_generated_method = "50D229540B7CE715B77F6F1CB606E6D0")
    
public abstract int checkCallingOrSelfPermission(String permission);

    /**
     * If the given permission is not allowed for a particular process
     * and user ID running in the system, throw a {@link SecurityException}.
     *
     * @param permission The name of the permission being checked.
     * @param pid The process ID being checked against.  Must be &gt; 0.
     * @param uid The user ID being checked against.  A uid of 0 is the root
     * user, which will pass every permission check.
     * @param message A message to include in the exception if it is thrown.
     *
     * @see #checkPermission(String, int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.102 -0500", hash_original_method = "79F5C1924154B5416B1D25C64505B4AE", hash_generated_method = "D02FC49536099055A9657497D2941335")
    
public abstract void enforcePermission(
            String permission, int pid, int uid, String message);

    /**
     * If the calling process of an IPC you are handling has not been
     * granted a particular permission, throw a {@link
     * SecurityException}.  This is basically the same as calling
     * {@link #enforcePermission(String, int, int, String)} with the
     * pid and uid returned by {@link android.os.Binder#getCallingPid}
     * and {@link android.os.Binder#getCallingUid}.  One important
     * difference is that if you are not currently processing an IPC,
     * this function will always throw the SecurityException.  This is
     * done to protect against accidentally leaking permissions; you
     * can use {@link #enforceCallingOrSelfPermission} to avoid this
     * protection.
     *
     * @param permission The name of the permission being checked.
     * @param message A message to include in the exception if it is thrown.
     *
     * @see #checkCallingPermission(String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.104 -0500", hash_original_method = "03E6A01992433D9A651C0CF7DB0FD356", hash_generated_method = "B35E69822C060BFFFFCBF4D3662F1B47")
    
public abstract void enforceCallingPermission(
            String permission, String message);

    /**
     * If neither you nor the calling process of an IPC you are
     * handling has been granted a particular permission, throw a
     * {@link SecurityException}.  This is the same as {@link
     * #enforceCallingPermission}, except it grants your own
     * permissions if you are not currently processing an IPC.  Use
     * with care!
     *
     * @param permission The name of the permission being checked.
     * @param message A message to include in the exception if it is thrown.
     *
     * @see #checkCallingOrSelfPermission(String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.106 -0500", hash_original_method = "41A9367C5CFF83D503396F4DCCE577EA", hash_generated_method = "029DAD1BE59665EC9DBD3CCAF314BC23")
    
public abstract void enforceCallingOrSelfPermission(
            String permission, String message);

    /**
     * Grant permission to access a specific Uri to another package, regardless
     * of whether that package has general permission to access the Uri's
     * content provider.  This can be used to grant specific, temporary
     * permissions, typically in response to user interaction (such as the
     * user opening an attachment that you would like someone else to
     * display).
     *
     * <p>Normally you should use {@link Intent#FLAG_GRANT_READ_URI_PERMISSION
     * Intent.FLAG_GRANT_READ_URI_PERMISSION} or
     * {@link Intent#FLAG_GRANT_WRITE_URI_PERMISSION
     * Intent.FLAG_GRANT_WRITE_URI_PERMISSION} with the Intent being used to
     * start an activity instead of this function directly.  If you use this
     * function directly, you should be sure to call
     * {@link #revokeUriPermission} when the target should no longer be allowed
     * to access it.
     *
     * <p>To succeed, the content provider owning the Uri must have set the
     * {@link android.R.styleable#AndroidManifestProvider_grantUriPermissions
     * grantUriPermissions} attribute in its manifest or included the
     * {@link android.R.styleable#AndroidManifestGrantUriPermission
     * &lt;grant-uri-permissions&gt;} tag.
     *
     * @param toPackage The package you would like to allow to access the Uri.
     * @param uri The Uri you would like to grant access to.
     * @param modeFlags The desired access modes.  Any combination of
     * {@link Intent#FLAG_GRANT_READ_URI_PERMISSION
     * Intent.FLAG_GRANT_READ_URI_PERMISSION} or
     * {@link Intent#FLAG_GRANT_WRITE_URI_PERMISSION
     * Intent.FLAG_GRANT_WRITE_URI_PERMISSION}.
     *
     * @see #revokeUriPermission
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.108 -0500", hash_original_method = "7DA1D740B3E06BF786612D7F97203CBE", hash_generated_method = "1C0E75C2DCD187AD957D55FDE4C9D629")
    
public abstract void grantUriPermission(String toPackage, Uri uri,
            int modeFlags);

    /**
     * Remove all permissions to access a particular content provider Uri
     * that were previously added with {@link #grantUriPermission}.  The given
     * Uri will match all previously granted Uris that are the same or a
     * sub-path of the given Uri.  That is, revoking "content://foo/one" will
     * revoke both "content://foo/target" and "content://foo/target/sub", but not
     * "content://foo".
     *
     * @param uri The Uri you would like to revoke access to.
     * @param modeFlags The desired access modes.  Any combination of
     * {@link Intent#FLAG_GRANT_READ_URI_PERMISSION
     * Intent.FLAG_GRANT_READ_URI_PERMISSION} or
     * {@link Intent#FLAG_GRANT_WRITE_URI_PERMISSION
     * Intent.FLAG_GRANT_WRITE_URI_PERMISSION}.
     *
     * @see #grantUriPermission
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.111 -0500", hash_original_method = "0306B947BBF857241429E2E85B01DB78", hash_generated_method = "8192A9BD34FB57FA552809171B926DDD")
    
public abstract void revokeUriPermission(Uri uri, int modeFlags);

    /**
     * Determine whether a particular process and user ID has been granted
     * permission to access a specific URI.  This only checks for permissions
     * that have been explicitly granted -- if the given process/uid has
     * more general access to the URI's content provider then this check will
     * always fail.
     *
     * @param uri The uri that is being checked.
     * @param pid The process ID being checked against.  Must be &gt; 0.
     * @param uid The user ID being checked against.  A uid of 0 is the root
     * user, which will pass every permission check.
     * @param modeFlags The type of access to grant.  May be one or both of
     * {@link Intent#FLAG_GRANT_READ_URI_PERMISSION Intent.FLAG_GRANT_READ_URI_PERMISSION} or
     * {@link Intent#FLAG_GRANT_WRITE_URI_PERMISSION Intent.FLAG_GRANT_WRITE_URI_PERMISSION}.
     *
     * @return Returns {@link PackageManager#PERMISSION_GRANTED} if the given
     * pid/uid is allowed to access that uri, or
     * {@link PackageManager#PERMISSION_DENIED} if it is not.
     *
     * @see #checkCallingUriPermission
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.113 -0500", hash_original_method = "1757A8458C42B7C8D1A9F485BF64EDA3", hash_generated_method = "3557B40505AF6FD102044B31A129F3E7")
    
public abstract int checkUriPermission(Uri uri, int pid, int uid, int modeFlags);

    /**
     * Determine whether the calling process and user ID has been
     * granted permission to access a specific URI.  This is basically
     * the same as calling {@link #checkUriPermission(Uri, int, int,
     * int)} with the pid and uid returned by {@link
     * android.os.Binder#getCallingPid} and {@link
     * android.os.Binder#getCallingUid}.  One important difference is
     * that if you are not currently processing an IPC, this function
     * will always fail.
     *
     * @param uri The uri that is being checked.
     * @param modeFlags The type of access to grant.  May be one or both of
     * {@link Intent#FLAG_GRANT_READ_URI_PERMISSION Intent.FLAG_GRANT_READ_URI_PERMISSION} or
     * {@link Intent#FLAG_GRANT_WRITE_URI_PERMISSION Intent.FLAG_GRANT_WRITE_URI_PERMISSION}.
     *
     * @return Returns {@link PackageManager#PERMISSION_GRANTED} if the caller
     * is allowed to access that uri, or
     * {@link PackageManager#PERMISSION_DENIED} if it is not.
     *
     * @see #checkUriPermission(Uri, int, int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.115 -0500", hash_original_method = "0615EBE9BDAF897A2BD15403E828839B", hash_generated_method = "8200FB2F1C4C720580D19F3C9F8ACD99")
    
public abstract int checkCallingUriPermission(Uri uri, int modeFlags);

    /**
     * Determine whether the calling process of an IPC <em>or you</em> has been granted
     * permission to access a specific URI.  This is the same as
     * {@link #checkCallingUriPermission}, except it grants your own permissions
     * if you are not currently processing an IPC.  Use with care!
     *
     * @param uri The uri that is being checked.
     * @param modeFlags The type of access to grant.  May be one or both of
     * {@link Intent#FLAG_GRANT_READ_URI_PERMISSION Intent.FLAG_GRANT_READ_URI_PERMISSION} or
     * {@link Intent#FLAG_GRANT_WRITE_URI_PERMISSION Intent.FLAG_GRANT_WRITE_URI_PERMISSION}.
     *
     * @return Returns {@link PackageManager#PERMISSION_GRANTED} if the caller
     * is allowed to access that uri, or
     * {@link PackageManager#PERMISSION_DENIED} if it is not.
     *
     * @see #checkCallingUriPermission
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.118 -0500", hash_original_method = "ED277C304B3725DB9F517B507BDBD439", hash_generated_method = "632F3A5C67A65EC30FCDFEDF3607B7C3")
    
public abstract int checkCallingOrSelfUriPermission(Uri uri, int modeFlags);

    /**
     * Check both a Uri and normal permission.  This allows you to perform
     * both {@link #checkPermission} and {@link #checkUriPermission} in one
     * call.
     *
     * @param uri The Uri whose permission is to be checked, or null to not
     * do this check.
     * @param readPermission The permission that provides overall read access,
     * or null to not do this check.
     * @param writePermission The permission that provides overall write
     * acess, or null to not do this check.
     * @param pid The process ID being checked against.  Must be &gt; 0.
     * @param uid The user ID being checked against.  A uid of 0 is the root
     * user, which will pass every permission check.
     * @param modeFlags The type of access to grant.  May be one or both of
     * {@link Intent#FLAG_GRANT_READ_URI_PERMISSION Intent.FLAG_GRANT_READ_URI_PERMISSION} or
     * {@link Intent#FLAG_GRANT_WRITE_URI_PERMISSION Intent.FLAG_GRANT_WRITE_URI_PERMISSION}.
     *
     * @return Returns {@link PackageManager#PERMISSION_GRANTED} if the caller
     * is allowed to access that uri or holds one of the given permissions, or
     * {@link PackageManager#PERMISSION_DENIED} if it is not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.120 -0500", hash_original_method = "EE95A7B4E97764158E7FDB1CC97A0FB6", hash_generated_method = "44619D0DE6DDE5EEC9789A4F163EB2BF")
    
public abstract int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags);

    /**
     * If a particular process and user ID has not been granted
     * permission to access a specific URI, throw {@link
     * SecurityException}.  This only checks for permissions that have
     * been explicitly granted -- if the given process/uid has more
     * general access to the URI's content provider then this check
     * will always fail.
     *
     * @param uri The uri that is being checked.
     * @param pid The process ID being checked against.  Must be &gt; 0.
     * @param uid The user ID being checked against.  A uid of 0 is the root
     * user, which will pass every permission check.
     * @param modeFlags The type of access to grant.  May be one or both of
     * {@link Intent#FLAG_GRANT_READ_URI_PERMISSION Intent.FLAG_GRANT_READ_URI_PERMISSION} or
     * {@link Intent#FLAG_GRANT_WRITE_URI_PERMISSION Intent.FLAG_GRANT_WRITE_URI_PERMISSION}.
     * @param message A message to include in the exception if it is thrown.
     *
     * @see #checkUriPermission(Uri, int, int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.122 -0500", hash_original_method = "33D5D121AB2E9803842E10640EE4CED1", hash_generated_method = "86E3442483CEB1D81E720E648E522F7B")
    
public abstract void enforceUriPermission(
            Uri uri, int pid, int uid, int modeFlags, String message);

    /**
     * If the calling process and user ID has not been granted
     * permission to access a specific URI, throw {@link
     * SecurityException}.  This is basically the same as calling
     * {@link #enforceUriPermission(Uri, int, int, int, String)} with
     * the pid and uid returned by {@link
     * android.os.Binder#getCallingPid} and {@link
     * android.os.Binder#getCallingUid}.  One important difference is
     * that if you are not currently processing an IPC, this function
     * will always throw a SecurityException.
     *
     * @param uri The uri that is being checked.
     * @param modeFlags The type of access to grant.  May be one or both of
     * {@link Intent#FLAG_GRANT_READ_URI_PERMISSION Intent.FLAG_GRANT_READ_URI_PERMISSION} or
     * {@link Intent#FLAG_GRANT_WRITE_URI_PERMISSION Intent.FLAG_GRANT_WRITE_URI_PERMISSION}.
     * @param message A message to include in the exception if it is thrown.
     *
     * @see #checkCallingUriPermission(Uri, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.124 -0500", hash_original_method = "4DCC378B9BE44D8B9024F5ADE533C126", hash_generated_method = "3A99395B330707793FEDF1B9CE0E1EAF")
    
public abstract void enforceCallingUriPermission(
            Uri uri, int modeFlags, String message);

    /**
     * If the calling process of an IPC <em>or you</em> has not been
     * granted permission to access a specific URI, throw {@link
     * SecurityException}.  This is the same as {@link
     * #enforceCallingUriPermission}, except it grants your own
     * permissions if you are not currently processing an IPC.  Use
     * with care!
     *
     * @param uri The uri that is being checked.
     * @param modeFlags The type of access to grant.  May be one or both of
     * {@link Intent#FLAG_GRANT_READ_URI_PERMISSION Intent.FLAG_GRANT_READ_URI_PERMISSION} or
     * {@link Intent#FLAG_GRANT_WRITE_URI_PERMISSION Intent.FLAG_GRANT_WRITE_URI_PERMISSION}.
     * @param message A message to include in the exception if it is thrown.
     *
     * @see #checkCallingOrSelfUriPermission(Uri, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.127 -0500", hash_original_method = "2585E253391DA96EC43FD98AE09B8F05", hash_generated_method = "0319F16FA5F8C6E503F65CBE90B82709")
    
public abstract void enforceCallingOrSelfUriPermission(
            Uri uri, int modeFlags, String message);

    /**
     * Enforce both a Uri and normal permission.  This allows you to perform
     * both {@link #enforcePermission} and {@link #enforceUriPermission} in one
     * call.
     *
     * @param uri The Uri whose permission is to be checked, or null to not
     * do this check.
     * @param readPermission The permission that provides overall read access,
     * or null to not do this check.
     * @param writePermission The permission that provides overall write
     * acess, or null to not do this check.
     * @param pid The process ID being checked against.  Must be &gt; 0.
     * @param uid The user ID being checked against.  A uid of 0 is the root
     * user, which will pass every permission check.
     * @param modeFlags The type of access to grant.  May be one or both of
     * {@link Intent#FLAG_GRANT_READ_URI_PERMISSION Intent.FLAG_GRANT_READ_URI_PERMISSION} or
     * {@link Intent#FLAG_GRANT_WRITE_URI_PERMISSION Intent.FLAG_GRANT_WRITE_URI_PERMISSION}.
     * @param message A message to include in the exception if it is thrown.
     *
     * @see #checkUriPermission(Uri, String, String, int, int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.129 -0500", hash_original_method = "67DE4ABCCDAFBFC79BE2B9C2FB827578", hash_generated_method = "BBD85522911302A8A5EEC69E3D851BE3")
    
public abstract void enforceUriPermission(
            Uri uri, String readPermission, String writePermission,
            int pid, int uid, int modeFlags, String message);

    /**
     * Return a new Context object for the given application name.  This
     * Context is the same as what the named application gets when it is
     * launched, containing the same resources and class loader.  Each call to
     * this method returns a new instance of a Context object; Context objects
     * are not shared, however they share common state (Resources, ClassLoader,
     * etc) so the Context instance itself is fairly lightweight.
     *
     * <p>Throws {@link PackageManager.NameNotFoundException} if there is no
     * application with the given package name.
     *
     * <p>Throws {@link java.lang.SecurityException} if the Context requested
     * can not be loaded into the caller's process for security reasons (see
     * {@link #CONTEXT_INCLUDE_CODE} for more information}.
     *
     * @param packageName Name of the application's package.
     * @param flags Option flags, one of {@link #CONTEXT_INCLUDE_CODE}
     *              or {@link #CONTEXT_IGNORE_SECURITY}.
     *
     * @return A Context for the application.
     *
     * @throws java.lang.SecurityException
     * @throws PackageManager.NameNotFoundException if there is no application with
     * the given package name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.139 -0500", hash_original_method = "A3579BABAE7FBC221E5B34E715DFD559", hash_generated_method = "588C9ADBC456FB841F9114D12A7471C3")
    
public abstract Context createPackageContext(String packageName,
            int flags) throws PackageManager.NameNotFoundException;

    /**
     * Indicates whether this Context is restricted.
     *
     * @return True if this Context is restricted, false otherwise.
     *
     * @see #CONTEXT_RESTRICTED
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:30.141 -0500", hash_original_method = "83D5E01B4EA95EAE9203A12A4E27AA18", hash_generated_method = "5F09F86AB7736674ADD7B4B91DD7FE80")
    
public boolean isRestricted() {
        return false;
    }
	
	// We pull out IntentFilters out of xml and register them with the appropriate subclasses of Context here
	
	public void __ds__registerIntentFilter(IntentFilter intentFilter) {
	this.__ds__intentFilters.add(intentFilter);
	}
    
}

