package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Intent implements Parcelable, Cloneable {
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_MAIN = "android.intent.action.MAIN";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_VIEW = "android.intent.action.VIEW";
    public static final String ACTION_DEFAULT = ACTION_VIEW;
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ATTACH_DATA = "android.intent.action.ATTACH_DATA";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_EDIT = "android.intent.action.EDIT";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_INSERT_OR_EDIT = "android.intent.action.INSERT_OR_EDIT";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_PICK = "android.intent.action.PICK";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_CREATE_SHORTCUT = "android.intent.action.CREATE_SHORTCUT";
    public static final String EXTRA_SHORTCUT_INTENT = "android.intent.extra.shortcut.INTENT";
    public static final String EXTRA_SHORTCUT_NAME = "android.intent.extra.shortcut.NAME";
    public static final String EXTRA_SHORTCUT_ICON = "android.intent.extra.shortcut.ICON";
    public static final String EXTRA_SHORTCUT_ICON_RESOURCE =
            "android.intent.extra.shortcut.ICON_RESOURCE";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_CHOOSER = "android.intent.action.CHOOSER";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_GET_CONTENT = "android.intent.action.GET_CONTENT";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_DIAL = "android.intent.action.DIAL";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_CALL = "android.intent.action.CALL";
    public static final String ACTION_CALL_EMERGENCY = "android.intent.action.CALL_EMERGENCY";
    public static final String ACTION_CALL_PRIVILEGED = "android.intent.action.CALL_PRIVILEGED";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SENDTO = "android.intent.action.SENDTO";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SEND = "android.intent.action.SEND";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SEND_MULTIPLE = "android.intent.action.SEND_MULTIPLE";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ANSWER = "android.intent.action.ANSWER";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_INSERT = "android.intent.action.INSERT";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_PASTE = "android.intent.action.PASTE";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_DELETE = "android.intent.action.DELETE";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_RUN = "android.intent.action.RUN";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SYNC = "android.intent.action.SYNC";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_PICK_ACTIVITY = "android.intent.action.PICK_ACTIVITY";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SEARCH = "android.intent.action.SEARCH";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SYSTEM_TUTORIAL = "android.intent.action.SYSTEM_TUTORIAL";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_WEB_SEARCH = "android.intent.action.WEB_SEARCH";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ALL_APPS = "android.intent.action.ALL_APPS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SET_WALLPAPER = "android.intent.action.SET_WALLPAPER";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_BUG_REPORT = "android.intent.action.BUG_REPORT";
    public static final String ACTION_FACTORY_TEST = "android.intent.action.FACTORY_TEST";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_CALL_BUTTON = "android.intent.action.CALL_BUTTON";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_VOICE_COMMAND = "android.intent.action.VOICE_COMMAND";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SEARCH_LONG_PRESS = "android.intent.action.SEARCH_LONG_PRESS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_APP_ERROR = "android.intent.action.APP_ERROR";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_POWER_USAGE_SUMMARY = "android.intent.action.POWER_USAGE_SUMMARY";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_UPGRADE_SETUP = "android.intent.action.UPGRADE_SETUP";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_MANAGE_NETWORK_USAGE =
            "android.intent.action.MANAGE_NETWORK_USAGE";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_INSTALL_PACKAGE = "android.intent.action.INSTALL_PACKAGE";
    public static final String EXTRA_INSTALLER_PACKAGE_NAME
            = "android.intent.extra.INSTALLER_PACKAGE_NAME";
    public static final String EXTRA_NOT_UNKNOWN_SOURCE
            = "android.intent.extra.NOT_UNKNOWN_SOURCE";
    public static final String EXTRA_ALLOW_REPLACE
            = "android.intent.extra.ALLOW_REPLACE";
    public static final String EXTRA_RETURN_RESULT
            = "android.intent.extra.RETURN_RESULT";
    public static final String EXTRA_INSTALL_RESULT
            = "android.intent.extra.INSTALL_RESULT";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_UNINSTALL_PACKAGE = "android.intent.action.UNINSTALL_PACKAGE";
    public static final String METADATA_SETUP_VERSION = "android.SETUP_VERSION";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SCREEN_OFF = "android.intent.action.SCREEN_OFF";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SCREEN_ON = "android.intent.action.SCREEN_ON";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_USER_PRESENT = "android.intent.action.USER_PRESENT";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_TIME_TICK = "android.intent.action.TIME_TICK";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_TIME_CHANGED = "android.intent.action.TIME_SET";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DATE_CHANGED = "android.intent.action.DATE_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_TIMEZONE_CHANGED = "android.intent.action.TIMEZONE_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CLEAR_DNS_CACHE = "android.intent.action.CLEAR_DNS_CACHE";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_ALARM_CHANGED = "android.intent.action.ALARM_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SYNC_STATE_CHANGED
            = "android.intent.action.SYNC_STATE_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BOOT_COMPLETED = "android.intent.action.BOOT_COMPLETED";
    public static final String ACTION_CLOSE_SYSTEM_DIALOGS = "android.intent.action.CLOSE_SYSTEM_DIALOGS";
    @Deprecated
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_INSTALL = "android.intent.action.PACKAGE_INSTALL";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_ADDED = "android.intent.action.PACKAGE_ADDED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_REPLACED = "android.intent.action.PACKAGE_REPLACED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MY_PACKAGE_REPLACED = "android.intent.action.MY_PACKAGE_REPLACED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_REMOVED = "android.intent.action.PACKAGE_REMOVED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_FULLY_REMOVED
            = "android.intent.action.PACKAGE_FULLY_REMOVED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_CHANGED = "android.intent.action.PACKAGE_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_QUERY_PACKAGE_RESTART = "android.intent.action.QUERY_PACKAGE_RESTART";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_RESTARTED = "android.intent.action.PACKAGE_RESTARTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_DATA_CLEARED = "android.intent.action.PACKAGE_DATA_CLEARED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_UID_REMOVED = "android.intent.action.UID_REMOVED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_FIRST_LAUNCH = "android.intent.action.PACKAGE_FIRST_LAUNCH";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_NEEDS_VERIFICATION = "android.intent.action.PACKAGE_NEEDS_VERIFICATION";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE =
        "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE =
        "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_WALLPAPER_CHANGED = "android.intent.action.WALLPAPER_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONFIGURATION_CHANGED = "android.intent.action.CONFIGURATION_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_LOCALE_CHANGED = "android.intent.action.LOCALE_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BATTERY_CHANGED = "android.intent.action.BATTERY_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BATTERY_LOW = "android.intent.action.BATTERY_LOW";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BATTERY_OKAY = "android.intent.action.BATTERY_OKAY";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_POWER_CONNECTED = "android.intent.action.ACTION_POWER_CONNECTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_POWER_DISCONNECTED =
            "android.intent.action.ACTION_POWER_DISCONNECTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SHUTDOWN = "android.intent.action.ACTION_SHUTDOWN";
    public static final String ACTION_REQUEST_SHUTDOWN = "android.intent.action.ACTION_REQUEST_SHUTDOWN";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_STORAGE_LOW = "android.intent.action.DEVICE_STORAGE_LOW";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_STORAGE_OK = "android.intent.action.DEVICE_STORAGE_OK";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_STORAGE_FULL = "android.intent.action.DEVICE_STORAGE_FULL";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_STORAGE_NOT_FULL = "android.intent.action.DEVICE_STORAGE_NOT_FULL";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MANAGE_PACKAGE_STORAGE = "android.intent.action.MANAGE_PACKAGE_STORAGE";
    @Deprecated
    public static final String ACTION_UMS_CONNECTED = "android.intent.action.UMS_CONNECTED";
    @Deprecated
    public static final String ACTION_UMS_DISCONNECTED = "android.intent.action.UMS_DISCONNECTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_REMOVED = "android.intent.action.MEDIA_REMOVED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_UNMOUNTED = "android.intent.action.MEDIA_UNMOUNTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_CHECKING = "android.intent.action.MEDIA_CHECKING";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_NOFS = "android.intent.action.MEDIA_NOFS";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_MOUNTED = "android.intent.action.MEDIA_MOUNTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_SHARED = "android.intent.action.MEDIA_SHARED";
    public static final String ACTION_MEDIA_UNSHARED = "android.intent.action.MEDIA_UNSHARED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_BAD_REMOVAL = "android.intent.action.MEDIA_BAD_REMOVAL";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_UNMOUNTABLE = "android.intent.action.MEDIA_UNMOUNTABLE";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_EJECT = "android.intent.action.MEDIA_EJECT";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_SCANNER_STARTED = "android.intent.action.MEDIA_SCANNER_STARTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_SCANNER_FINISHED = "android.intent.action.MEDIA_SCANNER_FINISHED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_SCANNER_SCAN_FILE = "android.intent.action.MEDIA_SCANNER_SCAN_FILE";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_BUTTON = "android.intent.action.MEDIA_BUTTON";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CAMERA_BUTTON = "android.intent.action.CAMERA_BUTTON";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_GTALK_SERVICE_CONNECTED =
            "android.intent.action.GTALK_CONNECTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_GTALK_SERVICE_DISCONNECTED =
            "android.intent.action.GTALK_DISCONNECTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_INPUT_METHOD_CHANGED =
            "android.intent.action.INPUT_METHOD_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_AIRPLANE_MODE_CHANGED = "android.intent.action.AIRPLANE_MODE";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PROVIDER_CHANGED =
            "android.intent.action.PROVIDER_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_HEADSET_PLUG =
            "android.intent.action.HEADSET_PLUG";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_USB_ANLG_HEADSET_PLUG =
            "android.intent.action.USB_ANLG_HEADSET_PLUG";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_USB_DGTL_HEADSET_PLUG =
            "android.intent.action.USB_DGTL_HEADSET_PLUG";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_HDMI_AUDIO_PLUG =
            "android.intent.action.HDMI_AUDIO_PLUG";
    public static final String ACTION_ADVANCED_SETTINGS_CHANGED
            = "android.intent.action.ADVANCED_SETTINGS";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_NEW_OUTGOING_CALL =
            "android.intent.action.NEW_OUTGOING_CALL";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_REBOOT =
            "android.intent.action.REBOOT";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DOCK_EVENT =
            "android.intent.action.DOCK_EVENT";
    public static final String ACTION_REMOTE_INTENT =
            "com.google.android.c2dm.intent.RECEIVE";
    public static final String ACTION_PRE_BOOT_COMPLETED =
            "android.intent.action.PRE_BOOT_COMPLETED";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_DEFAULT = "android.intent.category.DEFAULT";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_BROWSABLE = "android.intent.category.BROWSABLE";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_ALTERNATIVE = "android.intent.category.ALTERNATIVE";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_SELECTED_ALTERNATIVE = "android.intent.category.SELECTED_ALTERNATIVE";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_TAB = "android.intent.category.TAB";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_LAUNCHER = "android.intent.category.LAUNCHER";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_INFO = "android.intent.category.INFO";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_HOME = "android.intent.category.HOME";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_PREFERENCE = "android.intent.category.PREFERENCE";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_DEVELOPMENT_PREFERENCE = "android.intent.category.DEVELOPMENT_PREFERENCE";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_EMBED = "android.intent.category.EMBED";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_MARKET = "android.intent.category.APP_MARKET";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_MONKEY = "android.intent.category.MONKEY";
    public static final String CATEGORY_TEST = "android.intent.category.TEST";
    public static final String CATEGORY_UNIT_TEST = "android.intent.category.UNIT_TEST";
    public static final String CATEGORY_SAMPLE_CODE = "android.intent.category.SAMPLE_CODE";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_OPENABLE = "android.intent.category.OPENABLE";
    public static final String CATEGORY_FRAMEWORK_INSTRUMENTATION_TEST =
            "android.intent.category.FRAMEWORK_INSTRUMENTATION_TEST";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_CAR_DOCK = "android.intent.category.CAR_DOCK";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_DESK_DOCK = "android.intent.category.DESK_DOCK";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_LE_DESK_DOCK = "android.intent.category.LE_DESK_DOCK";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_HE_DESK_DOCK = "android.intent.category.HE_DESK_DOCK";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_CAR_MODE = "android.intent.category.CAR_MODE";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_BROWSER = "android.intent.category.APP_BROWSER";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_CALCULATOR = "android.intent.category.APP_CALCULATOR";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_CALENDAR = "android.intent.category.APP_CALENDAR";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_CONTACTS = "android.intent.category.APP_CONTACTS";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_EMAIL = "android.intent.category.APP_EMAIL";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_GALLERY = "android.intent.category.APP_GALLERY";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_MAPS = "android.intent.category.APP_MAPS";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_MESSAGING = "android.intent.category.APP_MESSAGING";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_MUSIC = "android.intent.category.APP_MUSIC";
    public static final String EXTRA_TEMPLATE = "android.intent.extra.TEMPLATE";
    public static final String EXTRA_TEXT = "android.intent.extra.TEXT";
    public static final String EXTRA_STREAM = "android.intent.extra.STREAM";
    public static final String EXTRA_EMAIL       = "android.intent.extra.EMAIL";
    public static final String EXTRA_CC       = "android.intent.extra.CC";
    public static final String EXTRA_BCC      = "android.intent.extra.BCC";
    public static final String EXTRA_SUBJECT  = "android.intent.extra.SUBJECT";
    public static final String EXTRA_INTENT = "android.intent.extra.INTENT";
    public static final String EXTRA_TITLE = "android.intent.extra.TITLE";
    public static final String EXTRA_INITIAL_INTENTS = "android.intent.extra.INITIAL_INTENTS";
    public static final String EXTRA_KEY_EVENT = "android.intent.extra.KEY_EVENT";
    public static final String EXTRA_KEY_CONFIRM = "android.intent.extra.KEY_CONFIRM";
    public static final String EXTRA_DONT_KILL_APP = "android.intent.extra.DONT_KILL_APP";
    public static final String EXTRA_PHONE_NUMBER = "android.intent.extra.PHONE_NUMBER";
    public static final String EXTRA_UID = "android.intent.extra.UID";
    public static final String EXTRA_PACKAGES = "android.intent.extra.PACKAGES";
    public static final String EXTRA_DATA_REMOVED = "android.intent.extra.DATA_REMOVED";
    public static final String EXTRA_REPLACING = "android.intent.extra.REPLACING";
    public static final String EXTRA_ALARM_COUNT = "android.intent.extra.ALARM_COUNT";
    public static final String EXTRA_DOCK_STATE = "android.intent.extra.DOCK_STATE";
    public static final int EXTRA_DOCK_STATE_UNDOCKED = 0;
    public static final int EXTRA_DOCK_STATE_DESK = 1;
    public static final int EXTRA_DOCK_STATE_CAR = 2;
    public static final int EXTRA_DOCK_STATE_LE_DESK = 3;
    public static final int EXTRA_DOCK_STATE_HE_DESK = 4;
    public static final String METADATA_DOCK_HOME = "android.dock_home";
    public static final String EXTRA_BUG_REPORT = "android.intent.extra.BUG_REPORT";
    public static final String EXTRA_REMOTE_INTENT_TOKEN =
            "android.intent.extra.remote_intent_token";
    @Deprecated public static final String EXTRA_CHANGED_COMPONENT_NAME =
            "android.intent.extra.changed_component_name";
    public static final String EXTRA_CHANGED_COMPONENT_NAME_LIST =
            "android.intent.extra.changed_component_name_list";
    public static final String EXTRA_CHANGED_PACKAGE_LIST =
            "android.intent.extra.changed_package_list";
    public static final String EXTRA_CHANGED_UID_LIST =
            "android.intent.extra.changed_uid_list";
    public static final String EXTRA_CLIENT_LABEL =
            "android.intent.extra.client_label";
    public static final String EXTRA_CLIENT_INTENT =
            "android.intent.extra.client_intent";
    public static final String EXTRA_LOCAL_ONLY =
        "android.intent.extra.LOCAL_ONLY";
    public static final int FLAG_GRANT_READ_URI_PERMISSION = 0x00000001;
    public static final int FLAG_GRANT_WRITE_URI_PERMISSION = 0x00000002;
    public static final int FLAG_FROM_BACKGROUND = 0x00000004;
    public static final int FLAG_DEBUG_LOG_RESOLUTION = 0x00000008;
    public static final int FLAG_EXCLUDE_STOPPED_PACKAGES = 0x00000010;
    public static final int FLAG_INCLUDE_STOPPED_PACKAGES = 0x00000020;
    public static final int FLAG_ACTIVITY_NO_HISTORY = 0x40000000;
    public static final int FLAG_ACTIVITY_SINGLE_TOP = 0x20000000;
    public static final int FLAG_ACTIVITY_NEW_TASK = 0x10000000;
    public static final int FLAG_ACTIVITY_MULTIPLE_TASK = 0x08000000;
    public static final int FLAG_ACTIVITY_CLEAR_TOP = 0x04000000;
    public static final int FLAG_ACTIVITY_FORWARD_RESULT = 0x02000000;
    public static final int FLAG_ACTIVITY_PREVIOUS_IS_TOP = 0x01000000;
    public static final int FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS = 0x00800000;
    public static final int FLAG_ACTIVITY_BROUGHT_TO_FRONT = 0x00400000;
    public static final int FLAG_ACTIVITY_RESET_TASK_IF_NEEDED = 0x00200000;
    public static final int FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY = 0x00100000;
    public static final int FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET = 0x00080000;
    public static final int FLAG_ACTIVITY_NO_USER_ACTION = 0x00040000;
    public static final int FLAG_ACTIVITY_REORDER_TO_FRONT = 0X00020000;
    public static final int FLAG_ACTIVITY_NO_ANIMATION = 0X00010000;
    public static final int FLAG_ACTIVITY_CLEAR_TASK = 0X00008000;
    public static final int FLAG_ACTIVITY_TASK_ON_HOME = 0X00004000;
    public static final int FLAG_RECEIVER_REGISTERED_ONLY = 0x40000000;
    public static final int FLAG_RECEIVER_REPLACE_PENDING = 0x20000000;
    public static final int FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT = 0x10000000;
    public static final int FLAG_RECEIVER_BOOT_UPGRADE = 0x08000000;
    public static final int IMMUTABLE_FLAGS =
            FLAG_GRANT_READ_URI_PERMISSION
            | FLAG_GRANT_WRITE_URI_PERMISSION;
    public static final int URI_INTENT_SCHEME = 1<<0;
    private String mAction;
    private Uri mData;
    private String mType;
    private String mPackage;
    private ComponentName mComponent;
    private int mFlags;
    private HashSet<String> mCategories;
    private Bundle mExtras;
    private Rect mSourceBounds;
    private Intent mSelector;
    public static final int FILL_IN_ACTION = 1<<0;
    public static final int FILL_IN_DATA = 1<<1;
    public static final int FILL_IN_CATEGORIES = 1<<2;
    public static final int FILL_IN_COMPONENT = 1<<3;
    public static final int FILL_IN_PACKAGE = 1<<4;
    public static final int FILL_IN_SOURCE_BOUNDS = 1<<5;
    public static final int FILL_IN_SELECTOR = 1<<6;
    public static final Parcelable.Creator<Intent> CREATOR = new Parcelable.Creator<Intent>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:26.952 -0400", hash_original_method = "F9E3C09B709E0EDEDA66B8BB83B427D5", hash_generated_method = "E1B69C6F75CCA2575CF50AE5F056C6D3")
        @DSModeled(DSC.SPEC)
        public Intent createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            return (Intent)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Intent(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:26.957 -0400", hash_original_method = "44BCAE850DE57DDD4EABB7D1FBBBB969", hash_generated_method = "C69EBA185D7371D4D2FF1FA46245841A")
        @DSModeled(DSC.SAFE)
        public Intent[] newArray(int size) {
            dsTaint.addTaint(size);
            return (Intent[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Intent[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:26.963 -0400", hash_original_method = "5C0F2C7B56AA3A635FE64462CDD8279E", hash_generated_method = "5708F10F2E95235970FA45898F2F72C4")
    @DSModeled(DSC.SPEC)
    public Intent() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:26.978 -0400", hash_original_method = "3FAB664599EE7924CC36F277EFA522C8", hash_generated_method = "7BAF65A305EDFAF432540819064CDD70")
    @DSModeled(DSC.SPEC)
    public Intent(Intent o) {
        dsTaint.addTaint(o.dsTaint);
        this.mAction = o.mAction;
        this.mData = o.mData;
        this.mType = o.mType;
        this.mPackage = o.mPackage;
        this.mComponent = o.mComponent;
        this.mFlags = o.mFlags;
        {
            this.mCategories = new HashSet<String>(o.mCategories);
        } //End block
        {
            this.mExtras = new Bundle(o.mExtras);
        } //End block
        {
            this.mSourceBounds = new Rect(o.mSourceBounds);
        } //End block
        {
            this.mSelector = new Intent(o.mSelector);
        } //End block
        // ---------- Original Method ----------
        //this.mAction = o.mAction;
        //this.mData = o.mData;
        //this.mType = o.mType;
        //this.mPackage = o.mPackage;
        //this.mComponent = o.mComponent;
        //this.mFlags = o.mFlags;
        //if (o.mCategories != null) {
            //this.mCategories = new HashSet<String>(o.mCategories);
        //}
        //if (o.mExtras != null) {
            //this.mExtras = new Bundle(o.mExtras);
        //}
        //if (o.mSourceBounds != null) {
            //this.mSourceBounds = new Rect(o.mSourceBounds);
        //}
        //if (o.mSelector != null) {
            //this.mSelector = new Intent(o.mSelector);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:26.994 -0400", hash_original_method = "C1E3B3E9040DD8E1371895A668D56796", hash_generated_method = "9AFEB4520D190F0EBF54EABF1E7162D2")
    @DSModeled(DSC.SPEC)
    private Intent(Intent o, boolean all) {
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(all);
        this.mAction = o.mAction;
        this.mData = o.mData;
        this.mType = o.mType;
        this.mPackage = o.mPackage;
        this.mComponent = o.mComponent;
        {
            this.mCategories = new HashSet<String>(o.mCategories);
        } //End block
        // ---------- Original Method ----------
        //this.mAction = o.mAction;
        //this.mData = o.mData;
        //this.mType = o.mType;
        //this.mPackage = o.mPackage;
        //this.mComponent = o.mComponent;
        //if (o.mCategories != null) {
            //this.mCategories = new HashSet<String>(o.mCategories);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.011 -0400", hash_original_method = "D5ECE127B03D5F5367AC94B767F0584E", hash_generated_method = "1D0249A7029E79DA47D6441EFC690F5D")
    @DSModeled(DSC.SPEC)
    public Intent(String action) {
        dsTaint.addTaint(action);
        setAction(action);
        // ---------- Original Method ----------
        //setAction(action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.017 -0400", hash_original_method = "FF213ACFD5B7DFA2C83F432472B13960", hash_generated_method = "74B369EA82E5E109E04E1C0098414E85")
    @DSModeled(DSC.SPEC)
    public Intent(String action, Uri uri) {
        dsTaint.addTaint(action);
        dsTaint.addTaint(uri.dsTaint);
        setAction(action);
        // ---------- Original Method ----------
        //setAction(action);
        //mData = uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.027 -0400", hash_original_method = "8A8F598E2C7B57A58F1379D7AFC8B81F", hash_generated_method = "1BE390BDCFED3C0A04EB643F7EE7EDAE")
    @DSModeled(DSC.SPEC)
    public Intent(Context packageContext, Class<?> cls) {
        dsTaint.addTaint(packageContext.dsTaint);
        dsTaint.addTaint(cls.dsTaint);
        mComponent = new ComponentName(packageContext, cls);
        // ---------- Original Method ----------
        //mComponent = new ComponentName(packageContext, cls);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.033 -0400", hash_original_method = "780AF3DA4D357977F460A8077F315476", hash_generated_method = "B3306C4E7CF4582A51996D88535AD213")
    @DSModeled(DSC.SPEC)
    public Intent(String action, Uri uri,
            Context packageContext, Class<?> cls) {
        dsTaint.addTaint(packageContext.dsTaint);
        dsTaint.addTaint(cls.dsTaint);
        dsTaint.addTaint(action);
        dsTaint.addTaint(uri.dsTaint);
        setAction(action);
        mComponent = new ComponentName(packageContext, cls);
        // ---------- Original Method ----------
        //setAction(action);
        //mData = uri;
        //mComponent = new ComponentName(packageContext, cls);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.038 -0400", hash_original_method = "BDABA8F9DB7F141DA2E5B48F186347CF", hash_generated_method = "8AEF259671DFCD09EBE7847011344574")
    @DSModeled(DSC.SPEC)
    protected Intent(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        readFromParcel(in);
        // ---------- Original Method ----------
        //readFromParcel(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.042 -0400", hash_original_method = "43F6EAB342082D2390B2ECED1CCBA8B1", hash_generated_method = "A816FD59E9987469E7B74430ED69774F")
    public static Intent createChooser(Intent target, CharSequence title) {
        Intent intent = new Intent(ACTION_CHOOSER);
        intent.putExtra(EXTRA_INTENT, target);
        if (title != null) {
            intent.putExtra(EXTRA_TITLE, title);
        }
        return intent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.050 -0400", hash_original_method = "0DE1E082CFAE738C657D3967F7BD3FA4", hash_generated_method = "D2B9654CC4EDD9C1DF0A354FD58CECA0")
    @DSModeled(DSC.SPEC)
    @Override
    public Object clone() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Intent(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.054 -0400", hash_original_method = "321DCA737B51074721765C9DBE3DB18C", hash_generated_method = "D642917A30BEDD2925A2E8386C5EE308")
    @DSModeled(DSC.SPEC)
    public Intent cloneFilter() {
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Intent(this, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.058 -0400", hash_original_method = "7AED2B47C306BAB7F7D451618997A7BB", hash_generated_method = "FB6DA85F5D45B429213A71D4678F3259")
    public static Intent makeMainActivity(ComponentName mainActivity) {
        Intent intent = new Intent(ACTION_MAIN);
        intent.setComponent(mainActivity);
        intent.addCategory(CATEGORY_LAUNCHER);
        return intent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.063 -0400", hash_original_method = "D6FBF20876F918111C6430036A818C6A", hash_generated_method = "2A2960869EF2FB28477E1815FEAAEC84")
    public static Intent makeMainSelectorActivity(String selectorAction,
            String selectorCategory) {
        Intent intent = new Intent(ACTION_MAIN);
        intent.addCategory(CATEGORY_LAUNCHER);
        Intent selector = new Intent();
        selector.setAction(selectorAction);
        selector.addCategory(selectorCategory);
        intent.setSelector(selector);
        return intent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.069 -0400", hash_original_method = "A6877A9D43804E19B3305D0B2E659CAC", hash_generated_method = "C8346CB9F8080D74631221AA3292232B")
    public static Intent makeRestartActivityTask(ComponentName mainActivity) {
        Intent intent = makeMainActivity(mainActivity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.075 -0400", hash_original_method = "98F9DED50B2CB0429925771F0A25EF9A", hash_generated_method = "5EA9CB4B5480139454B9912278C7C60B")
    @Deprecated
    public static Intent getIntent(String uri) throws URISyntaxException {
        return parseUri(uri, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.108 -0400", hash_original_method = "C5B32AAE1FE2D64E6A622392E0301DD1", hash_generated_method = "AC985102758AE04E7989512A6B0C0453")
    public static Intent parseUri(String uri, int flags) throws URISyntaxException {
        int i = 0;
        try {
            if ((flags&URI_INTENT_SCHEME) != 0) {
                if (!uri.startsWith("intent:")) {
                    Intent intent = new Intent(ACTION_VIEW);
                    try {
                        intent.setData(Uri.parse(uri));
                    } catch (IllegalArgumentException e) {
                        throw new URISyntaxException(uri, e.getMessage());
                    }
                    return intent;
                }
            }
            i = uri.lastIndexOf("#");
            if (i == -1) return new Intent(ACTION_VIEW, Uri.parse(uri));
            if (!uri.startsWith("#Intent;", i)) return getIntentOld(uri);
            Intent intent = new Intent(ACTION_VIEW);
            Intent baseIntent = intent;
            String data = i >= 0 ? uri.substring(0, i) : null;
            String scheme = null;
            i += "#Intent;".length();
            while (!uri.startsWith("end", i)) {
                int eq = uri.indexOf('=', i);
                if (eq < 0) eq = i-1;
                int semi = uri.indexOf(';', i);
                String value = eq < semi ? Uri.decode(uri.substring(eq + 1, semi)) : "";
                if (uri.startsWith("action=", i)) {
                    intent.setAction(value);
                }
                else if (uri.startsWith("category=", i)) {
                    intent.addCategory(value);
                }
                else if (uri.startsWith("type=", i)) {
                    intent.mType = value;
                }
                else if (uri.startsWith("launchFlags=", i)) {
                    intent.mFlags = Integer.decode(value).intValue();
                }
                else if (uri.startsWith("package=", i)) {
                    intent.mPackage = value;
                }
                else if (uri.startsWith("component=", i)) {
                    intent.mComponent = ComponentName.unflattenFromString(value);
                }
                else if (uri.startsWith("scheme=", i)) {
                    scheme = value;
                }
                else if (uri.startsWith("sourceBounds=", i)) {
                    intent.mSourceBounds = Rect.unflattenFromString(value);
                }
                else if (semi == (i+3) && uri.startsWith("SEL", i)) {
                    intent = new Intent();
                }
                else {
                    String key = Uri.decode(uri.substring(i + 2, eq));
                    if (intent.mExtras == null) intent.mExtras = new Bundle();
                    Bundle b = intent.mExtras;
                    if      (uri.startsWith("S.", i)) b.putString(key, value);
                    else if (uri.startsWith("B.", i)) b.putBoolean(key, Boolean.parseBoolean(value));
                    else if (uri.startsWith("b.", i)) b.putByte(key, Byte.parseByte(value));
                    else if (uri.startsWith("c.", i)) b.putChar(key, value.charAt(0));
                    else if (uri.startsWith("d.", i)) b.putDouble(key, Double.parseDouble(value));
                    else if (uri.startsWith("f.", i)) b.putFloat(key, Float.parseFloat(value));
                    else if (uri.startsWith("i.", i)) b.putInt(key, Integer.parseInt(value));
                    else if (uri.startsWith("l.", i)) b.putLong(key, Long.parseLong(value));
                    else if (uri.startsWith("s.", i)) b.putShort(key, Short.parseShort(value));
                    else throw new URISyntaxException(uri, "unknown EXTRA type", i);
                }
                i = semi + 1;
            }
            if (intent != baseIntent) {
                baseIntent.setSelector(intent);
                intent = baseIntent;
            }
            if (data != null) {
                if (data.startsWith("intent:")) {
                    data = data.substring(7);
                    if (scheme != null) {
                        data = scheme + ':' + data;
                    }
                }
                if (data.length() > 0) {
                    try {
                        intent.mData = Uri.parse(data);
                    } catch (IllegalArgumentException e) {
                        throw new URISyntaxException(uri, e.getMessage());
                    }
                }
            }
            return intent;
        } catch (IndexOutOfBoundsException e) {
            throw new URISyntaxException(uri, "illegal Intent URI format", i);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.148 -0400", hash_original_method = "B4C415433E77631C2B3B21C89A688CF9", hash_generated_method = "71A88B32A4FEA937643F8AFDA27022B3")
    public static Intent getIntentOld(String uri) throws URISyntaxException {
        Intent intent;
        int i = uri.lastIndexOf('#');
        if (i >= 0) {
            String action = null;
            final int intentFragmentStart = i;
            boolean isIntentFragment = false;
            i++;
            if (uri.regionMatches(i, "action(", 0, 7)) {
                isIntentFragment = true;
                i += 7;
                int j = uri.indexOf(')', i);
                action = uri.substring(i, j);
                i = j + 1;
            }
            intent = new Intent(action);
            if (uri.regionMatches(i, "categories(", 0, 11)) {
                isIntentFragment = true;
                i += 11;
                int j = uri.indexOf(')', i);
                while (i < j) {
                    int sep = uri.indexOf('!', i);
                    if (sep < 0) sep = j;
                    if (i < sep) {
                        intent.addCategory(uri.substring(i, sep));
                    }
                    i = sep + 1;
                }
                i = j + 1;
            }
            if (uri.regionMatches(i, "type(", 0, 5)) {
                isIntentFragment = true;
                i += 5;
                int j = uri.indexOf(')', i);
                intent.mType = uri.substring(i, j);
                i = j + 1;
            }
            if (uri.regionMatches(i, "launchFlags(", 0, 12)) {
                isIntentFragment = true;
                i += 12;
                int j = uri.indexOf(')', i);
                intent.mFlags = Integer.decode(uri.substring(i, j)).intValue();
                i = j + 1;
            }
            if (uri.regionMatches(i, "component(", 0, 10)) {
                isIntentFragment = true;
                i += 10;
                int j = uri.indexOf(')', i);
                int sep = uri.indexOf('!', i);
                if (sep >= 0 && sep < j) {
                    String pkg = uri.substring(i, sep);
                    String cls = uri.substring(sep + 1, j);
                    intent.mComponent = new ComponentName(pkg, cls);
                }
                i = j + 1;
            }
            if (uri.regionMatches(i, "extras(", 0, 7)) {
                isIntentFragment = true;
                i += 7;
                final int closeParen = uri.indexOf(')', i);
                if (closeParen == -1) throw new URISyntaxException(uri,
                        "EXTRA missing trailing ')'", i);
                while (i < closeParen) {
                    int j = uri.indexOf('=', i);
                    if (j <= i + 1 || i >= closeParen) {
                        throw new URISyntaxException(uri, "EXTRA missing '='", i);
                    }
                    char type = uri.charAt(i);
                    i++;
                    String key = uri.substring(i, j);
                    i = j + 1;
                    j = uri.indexOf('!', i);
                    if (j == -1 || j >= closeParen) j = closeParen;
                    if (i >= j) throw new URISyntaxException(uri, "EXTRA missing '!'", i);
                    String value = uri.substring(i, j);
                    i = j;
                    if (intent.mExtras == null) intent.mExtras = new Bundle();
                    try {
                        switch (type) {
                            case 'S':
                                intent.mExtras.putString(key, Uri.decode(value));
                                break;
                            case 'B':
                                intent.mExtras.putBoolean(key, Boolean.parseBoolean(value));
                                break;
                            case 'b':
                                intent.mExtras.putByte(key, Byte.parseByte(value));
                                break;
                            case 'c':
                                intent.mExtras.putChar(key, Uri.decode(value).charAt(0));
                                break;
                            case 'd':
                                intent.mExtras.putDouble(key, Double.parseDouble(value));
                                break;
                            case 'f':
                                intent.mExtras.putFloat(key, Float.parseFloat(value));
                                break;
                            case 'i':
                                intent.mExtras.putInt(key, Integer.parseInt(value));
                                break;
                            case 'l':
                                intent.mExtras.putLong(key, Long.parseLong(value));
                                break;
                            case 's':
                                intent.mExtras.putShort(key, Short.parseShort(value));
                                break;
                            default:
                                throw new URISyntaxException(uri, "EXTRA has unknown type", i);
                        }
                    } catch (NumberFormatException e) {
                        throw new URISyntaxException(uri, "EXTRA value can't be parsed", i);
                    }
                    char ch = uri.charAt(i);
                    if (ch == ')') break;
                    if (ch != '!') throw new URISyntaxException(uri, "EXTRA missing '!'", i);
                    i++;
                }
            }
            if (isIntentFragment) {
                intent.mData = Uri.parse(uri.substring(0, intentFragmentStart));
            } else {
                intent.mData = Uri.parse(uri);
            }
            if (intent.mAction == null) {
                intent.mAction = ACTION_VIEW;
            }
        } else {
            intent = new Intent(ACTION_VIEW, Uri.parse(uri));
        }
        return intent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.163 -0400", hash_original_method = "2F09B930D511D23A5EF1D9DB36B884EA", hash_generated_method = "345D3E637F3CA684DD9E607930623A5F")
    @DSModeled(DSC.SAFE)
    public String getAction() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mAction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.170 -0400", hash_original_method = "E338941BA5F359CEDBE88CD11D2A1B67", hash_generated_method = "0CD06CD2C8E5A22E602BAAFEA61C2816")
    @DSModeled(DSC.SPEC)
    public Uri getData() {
        return (Uri)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.176 -0400", hash_original_method = "3391B7F4BF539D2060FFC8B715534970", hash_generated_method = "5D66A312EC7348EA74F53A573937C7EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDataString() {
        {
            Object var70663BF686601B14A770DCAF60EA7EF3_1761337864 = (mData.toString());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mData != null ? mData.toString() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.183 -0400", hash_original_method = "773226227E17626211D04D8FDBCEC473", hash_generated_method = "4E65A495AD0F655C578FB56E9FF77115")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getScheme() {
        {
            Object var5BCE5BCE4346F17AB3B3FBE72E945FBA_418343755 = (mData.getScheme());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mData != null ? mData.getScheme() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.189 -0400", hash_original_method = "F57356AE1A37FC524BD36BB2BA67325B", hash_generated_method = "192B28EC953898010D0B553B4104790F")
    @DSModeled(DSC.SAFE)
    public String getType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.198 -0400", hash_original_method = "BE275DDE2732AB3F4C79CA9D98784573", hash_generated_method = "886C4FD97A42C467B1AACF4DFB783740")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String resolveType(Context context) {
        dsTaint.addTaint(context.dsTaint);
        String var503AC6ADE9C234A4016D6D0E552F860D_631124334 = (resolveType(context.getContentResolver()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return resolveType(context.getContentResolver());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.208 -0400", hash_original_method = "897693CEC97DB20AF099C3D62602279E", hash_generated_method = "0D405FCE7BD64A9A2249E19241FA198D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String resolveType(ContentResolver resolver) {
        dsTaint.addTaint(resolver.dsTaint);
        {
            {
                boolean var7B4C5E574C7ED5DA8E1E1A150D29C82A_476927544 = ("content".equals(mData.getScheme()));
                {
                    String varE33080EF2FD0F6BAED172F608BC09D6E_371434802 = (resolver.getType(mData));
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mType != null) {
            //return mType;
        //}
        //if (mData != null) {
            //if ("content".equals(mData.getScheme())) {
                //return resolver.getType(mData);
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.216 -0400", hash_original_method = "824F1F0C825483A1D800708DE36CD7E2", hash_generated_method = "0AFEBEE22FD96DF2E7E7AF39E382E6AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String resolveTypeIfNeeded(ContentResolver resolver) {
        dsTaint.addTaint(resolver.dsTaint);
        String varCA94606B8BF118E7C4A4A9671061A88B_1634319741 = (resolveType(resolver));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mComponent != null) {
            //return mType;
        //}
        //return resolveType(resolver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.224 -0400", hash_original_method = "3612221F73372432993CCD6954A20D1D", hash_generated_method = "A5FBF915958DC5E87356E667FB0DF934")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasCategory(String category) {
        dsTaint.addTaint(category);
        boolean varC2460535E11742A1B298C090C684A3C7_664351662 = (mCategories != null && mCategories.contains(category));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCategories != null && mCategories.contains(category);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.230 -0400", hash_original_method = "44E921F5CBF6AA9462AF2EF773666A6D", hash_generated_method = "5722B548A39070178F5B91A7DA4C57BF")
    @DSModeled(DSC.SAFE)
    public Set<String> getCategories() {
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCategories;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.235 -0400", hash_original_method = "0EFF867FD71A8B842E16179807F3AE79", hash_generated_method = "A89F1B7DFFB6ECD9A441C3147A3F3711")
    @DSModeled(DSC.SPEC)
    public Intent getSelector() {
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSelector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.240 -0400", hash_original_method = "C5389CB5192CD8E55615D6E62222251D", hash_generated_method = "736ECEAB36A6E91D67E467605E876519")
    @DSModeled(DSC.BAN)
    public void setExtrasClassLoader(ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        {
            mExtras.setClassLoader(loader);
        } //End block
        // ---------- Original Method ----------
        //if (mExtras != null) {
            //mExtras.setClassLoader(loader);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.246 -0400", hash_original_method = "820997F7D9BF8A8B37DA5723F540EC8D", hash_generated_method = "98E3C2FC0B697684169B8D3739C6B6ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasExtra(String name) {
        dsTaint.addTaint(name);
        boolean var8D5EC6D3C753A94FA222F4E5ACC81591_1580778208 = (mExtras != null && mExtras.containsKey(name));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mExtras != null && mExtras.containsKey(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.251 -0400", hash_original_method = "A4A187292984F1C3EE73C7C78931040C", hash_generated_method = "7FBFFDA26E0404C178F4F5D9A6EA17A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasFileDescriptors() {
        boolean var0C8CC71D26B004C46DB7A137664B7280_1418399623 = (mExtras != null && mExtras.hasFileDescriptors());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mExtras != null && mExtras.hasFileDescriptors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.258 -0400", hash_original_method = "D5A9FCC072E976E3B1807EE38A32DBE8", hash_generated_method = "DA0C989FB29F31F6A846F82338231571")
    @DSModeled(DSC.SAFE)
    public void setAllowFds(boolean allowFds) {
        dsTaint.addTaint(allowFds);
        {
            mExtras.setAllowFds(allowFds);
        } //End block
        // ---------- Original Method ----------
        //if (mExtras != null) {
            //mExtras.setAllowFds(allowFds);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.264 -0400", hash_original_method = "4C23C66584C2E08F8D8923DC65F21B8A", hash_generated_method = "1BC1AF286F77A19DD922D619D5C7D26A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public Object getExtra(String name) {
        dsTaint.addTaint(name);
        Object var0CC9BB07BDA119320AB72AB3E2F2B839_1539864643 = (getExtra(name, null));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getExtra(name, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.273 -0400", hash_original_method = "6C77EA53DBDF6A732015829C63BCD454", hash_generated_method = "3517367067B305077EC9726932682A4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBooleanExtra(String name, boolean defaultValue) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        {
            Object var441345A13C50B96F36B1BDDFE386B01D_860936225 = (mExtras.getBoolean(name, defaultValue));
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getBoolean(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.279 -0400", hash_original_method = "7FB23DDD0BCB246CA49844E5ABE7B23C", hash_generated_method = "6D81B54F278D01C46A515434804CAAA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte getByteExtra(String name, byte defaultValue) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        {
            Object var5E722E48E6374BC3181BB0395ED7280C_600339387 = (mExtras.getByte(name, defaultValue));
        } //End flattened ternary
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getByte(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.286 -0400", hash_original_method = "7EF2CF350AA07FA1327C85A618EDDBDF", hash_generated_method = "EE4C92DC31747F0E47EACE69C02D3E68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short getShortExtra(String name, short defaultValue) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        {
            Object var1F19702B4265707BAB9F4C74EAFD2129_1182688013 = (mExtras.getShort(name, defaultValue));
        } //End flattened ternary
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getShort(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.300 -0400", hash_original_method = "49AA93250C5B660485540E34F899D621", hash_generated_method = "202FE38CB9D95A077934B36EE6179204")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char getCharExtra(String name, char defaultValue) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        {
            Object varF0573B87D0C0746DE636734AFBFD1074_1772816406 = (mExtras.getChar(name, defaultValue));
        } //End flattened ternary
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getChar(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.311 -0400", hash_original_method = "E0513A91E6CBAE3AB1C6E2298E28F4E9", hash_generated_method = "EAE4E74448296CA9742E4ACBB9C4B12B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getIntExtra(String name, int defaultValue) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        {
            Object var005750265D68679C9436FF96E8585426_644581140 = (mExtras.getInt(name, defaultValue));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getInt(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.319 -0400", hash_original_method = "C094BEE2071DFD73ABD25F184B7F6CE5", hash_generated_method = "86DEAD12FA31DD91FF0A19ABCFEFD7F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLongExtra(String name, long defaultValue) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        {
            Object varB55020DEBF1224039DDEA4A270305BFE_869967415 = (mExtras.getLong(name, defaultValue));
        } //End flattened ternary
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getLong(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.325 -0400", hash_original_method = "468C9940FDAFD3DDCC0968AC84566FDC", hash_generated_method = "43A96906FC2444A299ADD9B7DA45290E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFloatExtra(String name, float defaultValue) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        {
            Object varFEEC99C4EF3B173D2F91E923C717FD9F_278814042 = (mExtras.getFloat(name, defaultValue));
        } //End flattened ternary
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getFloat(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.331 -0400", hash_original_method = "9D513802316CA501D261DB0FDD177D9E", hash_generated_method = "D65813859D06EE5856551C0A3A6A91F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double getDoubleExtra(String name, double defaultValue) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        {
            Object varA815D167050171A219111346DF8F615D_1269320947 = (mExtras.getDouble(name, defaultValue));
        } //End flattened ternary
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getDouble(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.336 -0400", hash_original_method = "8063ECA9F5AA2AEF21F6A345FFE2B7E6", hash_generated_method = "BDD9FFE2307737BB8892CB76F380EB04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getStringExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var1622D96888E465ACF80D3A57986BFDFE_51614429 = (mExtras.getString(name));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getString(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.341 -0400", hash_original_method = "1694F41DCC8D039EBF419B4A0F2C4125", hash_generated_method = "CB9893400359359449B7498828B2E232")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getCharSequenceExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var5672E25D88AFE052A79EA0E194E775D5_232557723 = (mExtras.getCharSequence(name));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getCharSequence(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.345 -0400", hash_original_method = "1C448816D9B902054FE9E8A698247DA2", hash_generated_method = "3825B503FE21AEEBD9308D0584CB163A")
    @DSModeled(DSC.SAFE)
    public <T extends Parcelable> T getParcelableExtra(String name) {
        dsTaint.addTaint(name);
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.<T>getParcelable(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.351 -0400", hash_original_method = "28D360BBB773D3DC39CC6E8B3FB095BE", hash_generated_method = "2C1A69E02E3E42BF753B4DCF718BC507")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Parcelable[] getParcelableArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object varFBDECE06B1B4BE422B8E6EC2652F817C_1168261659 = (mExtras.getParcelableArray(name));
        } //End flattened ternary
        return (Parcelable[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getParcelableArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.361 -0400", hash_original_method = "BB02D0F500EDCAC2282F912174ECF594", hash_generated_method = "33463450463D88F32EBC6FCAF18DEB1D")
    @DSModeled(DSC.SAFE)
    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String name) {
        dsTaint.addTaint(name);
        return (ArrayList<T>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.<T>getParcelableArrayList(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.366 -0400", hash_original_method = "9F4D1ACCAA6C6918CB97F661FEDB7260", hash_generated_method = "DD61FE8FDF2B3E1E2C1D94F4C6DE2D71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Serializable getSerializableExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var20491745DB4E37C390B78A9E8DB4DC1F_1954091374 = (mExtras.getSerializable(name));
        } //End flattened ternary
        return (Serializable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getSerializable(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.374 -0400", hash_original_method = "E5A5C9C6BF01CEEFEAABCB20BBD32323", hash_generated_method = "A958B06076FCC0167356431E6C6518F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayList<Integer> getIntegerArrayListExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var4E9B562AE2B2856C288023B12FFCEF54_900648922 = (mExtras.getIntegerArrayList(name));
        } //End flattened ternary
        return (ArrayList<Integer>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getIntegerArrayList(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.380 -0400", hash_original_method = "D8E538521D5877A04B9E1243CFFC8BD3", hash_generated_method = "8BC882DAB4D3DB17C0086BF88ED39C9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayList<String> getStringArrayListExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var436943B2F8A26196132E8BBF463A0E93_845670748 = (mExtras.getStringArrayList(name));
        } //End flattened ternary
        return (ArrayList<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getStringArrayList(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.386 -0400", hash_original_method = "3C0B0EF6206949D4005752F37A471C32", hash_generated_method = "2C7CB43C1E96995C2F6A920D3D1223D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayList<CharSequence> getCharSequenceArrayListExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var29715E4749394A863D018F3D99834D7E_1668386416 = (mExtras.getCharSequenceArrayList(name));
        } //End flattened ternary
        return (ArrayList<CharSequence>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getCharSequenceArrayList(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.391 -0400", hash_original_method = "FE55BFBE9F4BF617BE3A0BE7101EDA89", hash_generated_method = "79A04C7F3E0DAA5062AA886301921346")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean[] getBooleanArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var00FB540837D005E34C6B04656181AAF7_1269893472 = (mExtras.getBooleanArray(name));
        } //End flattened ternary
        boolean[] retVal = new boolean[1];
        retVal[0] = dsTaint.getTaintBoolean();
        return retVal;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getBooleanArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.396 -0400", hash_original_method = "8982B2CEDDCF3062481CA9400546FBDD", hash_generated_method = "63C7D8025EC8DE46DBD5F404C6501A22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getByteArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var322B50C01B0B62460932D61E8C8FF801_96060120 = (mExtras.getByteArray(name));
        } //End flattened ternary
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getByteArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.401 -0400", hash_original_method = "CD9B24503F7344F42640A5B885850704", hash_generated_method = "B559FA1D511AD23ACA56C7B1973D3EAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short[] getShortArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var04AD7917A8202994626E7AF890795D1F_690890143 = (mExtras.getShortArray(name));
        } //End flattened ternary
        short[] retVal = new short[1];
        retVal[0] = (short)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getShortArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.406 -0400", hash_original_method = "CC419D577155763512853EA59FC750C3", hash_generated_method = "4ECB76D1C05EB7730249B74F561A5220")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char[] getCharArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object varD9F1732DD887AB31EBCB5E5E8A0BEC70_1421145013 = (mExtras.getCharArray(name));
        } //End flattened ternary
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getCharArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.412 -0400", hash_original_method = "0A82189594F324AE308815E53494E5B0", hash_generated_method = "4F6543E56816B4DD0B58C3C345FB2B23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int[] getIntArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object varDE084C3791D41A1082090562E4AEDD61_1436099113 = (mExtras.getIntArray(name));
        } //End flattened ternary
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getIntArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.417 -0400", hash_original_method = "2B191C1241796E74336A46C43420CA80", hash_generated_method = "72277B7B6E368C0AA780D47BD5BE0460")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long[] getLongArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var57E54E068A5207CC6FCC89D5EA86074A_1065702624 = (mExtras.getLongArray(name));
        } //End flattened ternary
        long[] retVal = new long[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getLongArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.422 -0400", hash_original_method = "8DC240B1B74093D697F56B17354B0D80", hash_generated_method = "8833BE599F821CBEBB55EDD5D84F72F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float[] getFloatArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var02187F0ED2F1F083AB042B5328108502_1538873914 = (mExtras.getFloatArray(name));
        } //End flattened ternary
        float[] retVal = new float[1];
        retVal[0] = dsTaint.getTaintFloat();
        return retVal;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getFloatArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.428 -0400", hash_original_method = "3975857C05E9D537152AB546E3F37275", hash_generated_method = "5E0CEFAF8E52EAF13CF7EE6BC368712D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double[] getDoubleArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var28E231FBCD466F21C98163F52E08EB15_1282338394 = (mExtras.getDoubleArray(name));
        } //End flattened ternary
        double[] retVal = new double[1];
        retVal[0] = dsTaint.getTaintFloat();
        return retVal;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getDoubleArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.433 -0400", hash_original_method = "63A5C80C2A9C3E397356915A6EC07B98", hash_generated_method = "5A2E5C98540322A27D18BCDEBD3D12BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getStringArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object varF0EE54AF34C58A189447A057DAC31617_1031225090 = (mExtras.getStringArray(name));
        } //End flattened ternary
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getStringArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.441 -0400", hash_original_method = "9443A9A4C1E608DAA4A110E653269318", hash_generated_method = "2D8524AFBDD03E9BAFCE69B97CCF795C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence[] getCharSequenceArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var84E624D09DE97FCF75ABD64672F382A8_837969220 = (mExtras.getCharSequenceArray(name));
        } //End flattened ternary
        CharSequence[] retVal = new CharSequence[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getCharSequenceArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.447 -0400", hash_original_method = "913345623B540CBB75EA0BDD1C78C162", hash_generated_method = "92B04C611D59B49AEB140D41A1C4C300")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle getBundleExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var2604CD42EA36E682E7F86DC90D8B51F9_84431717 = (mExtras.getBundle(name));
        } //End flattened ternary
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getBundle(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.452 -0400", hash_original_method = "657BCF405F69BF4C38A0897E9F672C84", hash_generated_method = "C8BD047D6112D5C4239018878FEFA0CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public IBinder getIBinderExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var973B5B5DACA29B673F3D52DAC3457957_1216831169 = (mExtras.getIBinder(name));
        } //End flattened ternary
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getIBinder(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.458 -0400", hash_original_method = "EF34C6BD33619501EBC4FFC15D7C460E", hash_generated_method = "7646FCDF1829BE9AE91F014FB170DC74")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public Object getExtra(String name, Object defaultValue) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue.dsTaint);
        Object result;
        result = defaultValue;
        {
            Object result2;
            result2 = mExtras.get(name);
            {
                result = result2;
            } //End block
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object result = defaultValue;
        //if (mExtras != null) {
            //Object result2 = mExtras.get(name);
            //if (result2 != null) {
                //result = result2;
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.462 -0400", hash_original_method = "6E509C3CEA63C12F8DB889EF86C70010", hash_generated_method = "606DE880B00E3825FE95F715FAA1B7F4")
    @DSModeled(DSC.SAFE)
    public Bundle getExtras() {
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (mExtras != null)
                //? new Bundle(mExtras)
                //: null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.466 -0400", hash_original_method = "CE8F8E5E4A30C515D6BD9049A49703B9", hash_generated_method = "B26C2F9BF1D3CF35709A1E868416FD9D")
    @DSModeled(DSC.SAFE)
    public int getFlags() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.472 -0400", hash_original_method = "35A271981CF0FB3B138FC227A1ADE9BA", hash_generated_method = "259D5B1BF2C398DE360C7372C55A56FF")
    @DSModeled(DSC.SAFE)
    public boolean isExcludingStopped() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags&(FLAG_EXCLUDE_STOPPED_PACKAGES|FLAG_INCLUDE_STOPPED_PACKAGES))
                //== FLAG_EXCLUDE_STOPPED_PACKAGES;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.476 -0400", hash_original_method = "D6B19F05A1BF219922EA06A43EF822A3", hash_generated_method = "499CD7E44AC0E8208E27F447641EB8A3")
    @DSModeled(DSC.SAFE)
    public String getPackage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPackage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.479 -0400", hash_original_method = "3446011C83A765263A4F2617180E656B", hash_generated_method = "695AA57B38E623B8A71E24C1265334E0")
    @DSModeled(DSC.SAFE)
    public ComponentName getComponent() {
        return (ComponentName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mComponent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.484 -0400", hash_original_method = "418D2917B5B7B0B035ED428CB7C119CA", hash_generated_method = "ACFD3E944871809601338D0F7F3DB21A")
    @DSModeled(DSC.SAFE)
    public Rect getSourceBounds() {
        return (Rect)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSourceBounds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.492 -0400", hash_original_method = "CDA09128651728DC4DB1AA79DEAE44CB", hash_generated_method = "DF2DF7680F342C776809FAD88B908C8F")
    @DSModeled(DSC.SAFE)
    public ComponentName resolveActivity(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        ResolveInfo info;
        info = pm.resolveActivity(
            this, PackageManager.MATCH_DEFAULT_ONLY);
        return (ComponentName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mComponent != null) {
            //return mComponent;
        //}
        //ResolveInfo info = pm.resolveActivity(
            //this, PackageManager.MATCH_DEFAULT_ONLY);
        //if (info != null) {
            //return new ComponentName(
                    //info.activityInfo.applicationInfo.packageName,
                    //info.activityInfo.name);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.502 -0400", hash_original_method = "4C4C454D517012EF1DC091F981BC8CF0", hash_generated_method = "E4C83348A1A01B9CCFAF40525A316CEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActivityInfo resolveActivityInfo(PackageManager pm, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(pm.dsTaint);
        ActivityInfo ai;
        ai = null;
        {
            try 
            {
                ai = pm.getActivityInfo(mComponent, flags);
            } //End block
            catch (PackageManager.NameNotFoundException e)
            { }
        } //End block
        {
            ResolveInfo info;
            info = pm.resolveActivity(
                this, PackageManager.MATCH_DEFAULT_ONLY | flags);
            {
                ai = info.activityInfo;
            } //End block
        } //End block
        return (ActivityInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ActivityInfo ai = null;
        //if (mComponent != null) {
            //try {
                //ai = pm.getActivityInfo(mComponent, flags);
            //} catch (PackageManager.NameNotFoundException e) {
            //}
        //} else {
            //ResolveInfo info = pm.resolveActivity(
                //this, PackageManager.MATCH_DEFAULT_ONLY | flags);
            //if (info != null) {
                //ai = info.activityInfo;
            //}
        //}
        //return ai;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.509 -0400", hash_original_method = "7FAE192103F51EFC97895E1DA306617B", hash_generated_method = "8488545BEE9F2EE891533C088D62C326")
    @DSModeled(DSC.SPEC)
    public Intent setAction(String action) {
        dsTaint.addTaint(action);
        mAction = action != null ? action.intern() : null;
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mAction = action != null ? action.intern() : null;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.523 -0400", hash_original_method = "7ABFC734F037DFB16AA9737CCDEC3D90", hash_generated_method = "C94A5C67B441FDE6EFED9B7AAFF3BFEF")
    @DSModeled(DSC.SPEC)
    public Intent setData(Uri data) {
        dsTaint.addTaint(data.dsTaint);
        mType = null;
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mData = data;
        //mType = null;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.536 -0400", hash_original_method = "797A6BD6371209544F539CFD71A54CFB", hash_generated_method = "616001A9F3BA0B06BF6EF9319664BF5D")
    @DSModeled(DSC.SPEC)
    public Intent setType(String type) {
        dsTaint.addTaint(type);
        mData = null;
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mData = null;
        //mType = type;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.553 -0400", hash_original_method = "43AA0CE5E260B0FA5B26C9FC36ABF327", hash_generated_method = "025C9735A01FE3D5F76497863E88958D")
    @DSModeled(DSC.SPEC)
    public Intent setDataAndType(Uri data, String type) {
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(type);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mData = data;
        //mType = type;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.561 -0400", hash_original_method = "0929EFE348972B36CEEED1BD1629D6D4", hash_generated_method = "5C819A425D48CF96BF0DF098D3EDADC0")
    @DSModeled(DSC.SPEC)
    public Intent addCategory(String category) {
        dsTaint.addTaint(category);
        {
            mCategories = new HashSet<String>();
        } //End block
        mCategories.add(category.intern());
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mCategories == null) {
            //mCategories = new HashSet<String>();
        //}
        //mCategories.add(category.intern());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.570 -0400", hash_original_method = "CFCF8DDC5EB4FA9E7ADB1DEB9CFAFA89", hash_generated_method = "4A02881FE944E41FEA339A41A2A92100")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeCategory(String category) {
        dsTaint.addTaint(category);
        {
            mCategories.remove(category);
            {
                boolean varF3E827929A4D5BB767FBFDA33518C46A_496687669 = (mCategories.size() == 0);
                {
                    mCategories = null;
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (mCategories != null) {
            //mCategories.remove(category);
            //if (mCategories.size() == 0) {
                //mCategories = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.575 -0400", hash_original_method = "4143B41199E8262105CB671C15097E99", hash_generated_method = "3CAEDC34B3EB66B2E80E2650041DB5F9")
    @DSModeled(DSC.SPEC)
    public void setSelector(Intent selector) {
        dsTaint.addTaint(selector.dsTaint);
        {
        	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Intent being set as a selector of itself");
        } //End block
        {
            throw new IllegalArgumentException(
                    "Can't set selector when package name is already set");
        } //End block
        // ---------- Original Method ----------
        //if (selector == this) {
            //throw new IllegalArgumentException(
                    //"Intent being set as a selector of itself");
        //}
        //if (selector != null && mPackage != null) {
            //throw new IllegalArgumentException(
                    //"Can't set selector when package name is already set");
        //}
        //mSelector = selector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.580 -0400", hash_original_method = "E358DED697FF080F831811D5D578FEBC", hash_generated_method = "28A2103A47FA98B9741C9FDA274E6EEF")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, boolean value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putBoolean(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putBoolean(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.585 -0400", hash_original_method = "983951350B18B30CD357EFC4A5F8C533", hash_generated_method = "5B806A4F5CFA260596A0B76BE1904859")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, byte value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putByte(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putByte(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.592 -0400", hash_original_method = "44F743D0FCF3A3B09735F92996DFB8B8", hash_generated_method = "F10F65A47B58CFCB8F7569244EFD08FA")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, char value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putChar(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putChar(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.597 -0400", hash_original_method = "D504428E6A64263CB337167E8E11D24B", hash_generated_method = "3F770ECE7213F9B7BA200C48AAAC28F9")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, short value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putShort(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putShort(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.601 -0400", hash_original_method = "0F8D3938F71F1CBC0AF93312AEF5DBAF", hash_generated_method = "A084C0315A6B209EB727094413E8C56D")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, int value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putInt(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putInt(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.605 -0400", hash_original_method = "210CE6920B09DE82954A1910A2E05BDA", hash_generated_method = "B42E244D546F29EA29D5644061AA239F")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, long value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putLong(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putLong(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.611 -0400", hash_original_method = "5563D3D5FF8C4FA36F1584B48F1347B6", hash_generated_method = "CDB610DFA46729BAFADAD4CA5C224CF3")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, float value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putFloat(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putFloat(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.616 -0400", hash_original_method = "FDAB0726590DA4887C7F048C162A9588", hash_generated_method = "63D425CD783F39BBED083047041DF078")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, double value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putDouble(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putDouble(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.620 -0400", hash_original_method = "FFA94FE476B4FC82FDFAB8191F06F76A", hash_generated_method = "0E819E23CB198936706F44725FCAFB36")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, String value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putString(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putString(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.627 -0400", hash_original_method = "C3AAC0183A1B956AD55E80A8556AFB71", hash_generated_method = "AFD066A4F6D821B5C811D949C8E1CF44")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, CharSequence value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putCharSequence(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putCharSequence(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.631 -0400", hash_original_method = "49EBB52F87B2F24E715C34795BBE3213", hash_generated_method = "5549D289587B7DF7481BAD75D6231A24")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, Parcelable value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putParcelable(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putParcelable(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.636 -0400", hash_original_method = "478D5F3649CF3C1019BEE6D895BDE15B", hash_generated_method = "36541FD6F3469FBD6CDDFD25225A6E37")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, Parcelable[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value[0].dsTaint);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putParcelableArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putParcelableArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.641 -0400", hash_original_method = "7056A89E2AB58239EE1F715B825304C9", hash_generated_method = "0A1407F02C93815EA5E8638169525F4C")
    @DSModeled(DSC.SPEC)
    public Intent putParcelableArrayListExtra(String name, ArrayList<? extends Parcelable> value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putParcelableArrayList(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putParcelableArrayList(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.647 -0400", hash_original_method = "25611C5EA858F4B01007B3F78DCCE949", hash_generated_method = "7A0F580B087DFFAAB83A7F6BABFF4515")
    @DSModeled(DSC.SPEC)
    public Intent putIntegerArrayListExtra(String name, ArrayList<Integer> value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putIntegerArrayList(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putIntegerArrayList(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.654 -0400", hash_original_method = "FCCCC0193355017A3AB410227E2B8C63", hash_generated_method = "06DABF62007D01B0AF6CEB047F4FD075")
    @DSModeled(DSC.SPEC)
    public Intent putStringArrayListExtra(String name, ArrayList<String> value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putStringArrayList(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putStringArrayList(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.659 -0400", hash_original_method = "56169BFB83B473D5686B58CC3B07DAC6", hash_generated_method = "11494D36FB436D4BF8E7676133C20D17")
    @DSModeled(DSC.SPEC)
    public Intent putCharSequenceArrayListExtra(String name, ArrayList<CharSequence> value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putCharSequenceArrayList(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putCharSequenceArrayList(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.665 -0400", hash_original_method = "050AC720F09B8AB16CBB253B94EE49E6", hash_generated_method = "2A4F6568F5FF93031043FDAEFA9BABAB")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, Serializable value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putSerializable(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putSerializable(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.672 -0400", hash_original_method = "6C30326EEBD8635124BFC9218A6B6422", hash_generated_method = "160AEECFFDD9E894A00AA00405BF736D")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, boolean[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putBooleanArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putBooleanArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.681 -0400", hash_original_method = "4D4788E50F7779B1D72BD45B4E76C775", hash_generated_method = "B8BDE886ABCB85B33611384539D57D7F")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, byte[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putByteArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putByteArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.687 -0400", hash_original_method = "521E65BC95668B6A66CE17103975D2B1", hash_generated_method = "1EDBB87E83EA8DEDAAEC22B82C1F2190")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, short[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putShortArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putShortArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.696 -0400", hash_original_method = "CEC6E945D8554F36BF71D2D38B61B7EF", hash_generated_method = "A20D0DCECFD27D9BAE86A69594980987")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, char[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putCharArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putCharArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.701 -0400", hash_original_method = "AD8C8F2DD7A3862E32E54CE0FBFF67CE", hash_generated_method = "C7F57D877AA4B65D27AB1BC1385A01F3")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, int[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putIntArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putIntArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.723 -0400", hash_original_method = "EEA209751D515DE89BAC56042276C483", hash_generated_method = "3F7D8B8A9CECB2A350C3C88DD63839D5")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, long[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putLongArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putLongArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.728 -0400", hash_original_method = "F6CA728A57FEA4C77AF7294872C7D495", hash_generated_method = "EF2B4250DB0ABD4485965C17E039EA99")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, float[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putFloatArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putFloatArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.732 -0400", hash_original_method = "3F155E9B232579FD3DCD2D3FAECEA79F", hash_generated_method = "F85DF2C7A34E94154542361D5F3D2921")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, double[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putDoubleArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putDoubleArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.740 -0400", hash_original_method = "4105C6229BFDC8C2B450D57FAD8A78CA", hash_generated_method = "1EE3F976776626524D87BFE7DA3B81E4")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, String[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putStringArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putStringArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.753 -0400", hash_original_method = "5B5979B9E2BB6EA8D0974FC96788F02A", hash_generated_method = "7B10DADE8C9D74FD873000A4BE8D82BB")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, CharSequence[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putCharSequenceArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putCharSequenceArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.758 -0400", hash_original_method = "79076492A33BAA4B69A022CE305E32E8", hash_generated_method = "53E1E032EB9220207BAB24610546E9F3")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, Bundle value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putBundle(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putBundle(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.779 -0400", hash_original_method = "1AE089536D0C6059F1731DCA673BC867", hash_generated_method = "3FF2E0B51EB3279EE755394DE402DAA1")
    @DSModeled(DSC.SPEC)
    @Deprecated
    public Intent putExtra(String name, IBinder value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putIBinder(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putIBinder(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.786 -0400", hash_original_method = "49B5D5019DC4C58D3432134ADBF206CE", hash_generated_method = "3580DE5550149730871F25C023476030")
    @DSModeled(DSC.SPEC)
    public Intent putExtras(Intent src) {
        dsTaint.addTaint(src.dsTaint);
        {
            {
                mExtras = new Bundle(src.mExtras);
            } //End block
            {
                mExtras.putAll(src.mExtras);
            } //End block
        } //End block
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (src.mExtras != null) {
            //if (mExtras == null) {
                //mExtras = new Bundle(src.mExtras);
            //} else {
                //mExtras.putAll(src.mExtras);
            //}
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.805 -0400", hash_original_method = "300503D60C48D249178D35D7CDB92339", hash_generated_method = "D245E6DEE689929BD134EA166D96EA4A")
    @DSModeled(DSC.SPEC)
    public Intent putExtras(Bundle extras) {
        dsTaint.addTaint(extras.dsTaint);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putAll(extras);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putAll(extras);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.813 -0400", hash_original_method = "9273ED8AEDE591E5D2100B41909C8A11", hash_generated_method = "BEC64EAF7B7D0BBAF17BB78E5C350AC4")
    @DSModeled(DSC.SPEC)
    public Intent replaceExtras(Intent src) {
        dsTaint.addTaint(src.dsTaint);
        mExtras = src.mExtras != null ? new Bundle(src.mExtras) : null;
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mExtras = src.mExtras != null ? new Bundle(src.mExtras) : null;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.816 -0400", hash_original_method = "CBF42E478CC456FFD10D6777F319F0BD", hash_generated_method = "67D042CEFD7377F1762CE4C10E2977DF")
    @DSModeled(DSC.SPEC)
    public Intent replaceExtras(Bundle extras) {
        dsTaint.addTaint(extras.dsTaint);
        mExtras = extras != null ? new Bundle(extras) : null;
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mExtras = extras != null ? new Bundle(extras) : null;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.821 -0400", hash_original_method = "84A47E40481CBF5586A9CCDD8AD7D655", hash_generated_method = "C244570A963B823ED83D4FC335B1CC2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeExtra(String name) {
        dsTaint.addTaint(name);
        {
            mExtras.remove(name);
            {
                boolean var7E8DAB3F8FE8420FBC71F6F461E1A32B_662430883 = (mExtras.size() == 0);
                {
                    mExtras = null;
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (mExtras != null) {
            //mExtras.remove(name);
            //if (mExtras.size() == 0) {
                //mExtras = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.826 -0400", hash_original_method = "240F6D2BBC198957F28DF199FF71FA51", hash_generated_method = "5BA97D5A913E1D2F565E799EF83CC8B3")
    @DSModeled(DSC.SPEC)
    public Intent setFlags(int flags) {
        dsTaint.addTaint(flags);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mFlags = flags;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.832 -0400", hash_original_method = "324CD70B42F70589537B5DD566C39001", hash_generated_method = "88932C39ED04D6B6DC12127D68CB2984")
    @DSModeled(DSC.SPEC)
    public Intent addFlags(int flags) {
        dsTaint.addTaint(flags);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mFlags |= flags;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.837 -0400", hash_original_method = "200C4521B9AF8FCBBA6D2C276396E1AF", hash_generated_method = "2B5130F86E06E6E5EB163FDA63131510")
    @DSModeled(DSC.SPEC)
    public Intent setPackage(String packageName) {
        dsTaint.addTaint(packageName);
        {
        	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Can't set package name when selector is already set");
        } //End block
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (packageName != null && mSelector != null) {
            //throw new IllegalArgumentException(
                    //"Can't set package name when selector is already set");
        //}
        //mPackage = packageName;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.842 -0400", hash_original_method = "36A7CA099992FC1299C683CE16869B23", hash_generated_method = "51BB44411E610E63B43839769D62E910")
    @DSModeled(DSC.SPEC)
    public Intent setComponent(ComponentName component) {
        dsTaint.addTaint(component.dsTaint);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mComponent = component;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.845 -0400", hash_original_method = "A7E573A4994CE22857A73F3E6FF16052", hash_generated_method = "6078149CD999FB5FCCEB73F5B132941F")
    @DSModeled(DSC.SPEC)
    public Intent setClassName(Context packageContext, String className) {
        dsTaint.addTaint(packageContext.dsTaint);
        dsTaint.addTaint(className);
        mComponent = new ComponentName(packageContext, className);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mComponent = new ComponentName(packageContext, className);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.850 -0400", hash_original_method = "0DAD204BCD083F4BEBCC949C19CA4443", hash_generated_method = "A616F4FA303500E98DD953C60A458EA2")
    @DSModeled(DSC.SPEC)
    public Intent setClassName(String packageName, String className) {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(className);
        mComponent = new ComponentName(packageName, className);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mComponent = new ComponentName(packageName, className);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.854 -0400", hash_original_method = "07D0BC1863460C70C46D0D4DB8E842CD", hash_generated_method = "30C9EA3FE1ADBA7AE9F13A80A3767F4A")
    @DSModeled(DSC.SPEC)
    public Intent setClass(Context packageContext, Class<?> cls) {
        dsTaint.addTaint(packageContext.dsTaint);
        dsTaint.addTaint(cls.dsTaint);
        mComponent = new ComponentName(packageContext, cls);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mComponent = new ComponentName(packageContext, cls);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.858 -0400", hash_original_method = "2A55D148D28C14A8FD18A3C56EB5208F", hash_generated_method = "F79B6C961E6C613D5BC1024B0D4797AA")
    @DSModeled(DSC.SAFE)
    public void setSourceBounds(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        {
            mSourceBounds = new Rect(r);
        } //End block
        {
            mSourceBounds = null;
        } //End block
        // ---------- Original Method ----------
        //if (r != null) {
            //mSourceBounds = new Rect(r);
        //} else {
            //mSourceBounds = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.880 -0400", hash_original_method = "E5580C6082A47C0EDDA03A45ABBBF7D7", hash_generated_method = "680941C3FD3DDEF770D67797339E4E61")
    @DSModeled(DSC.SPEC)
    public int fillIn(Intent other, int flags) {
        dsTaint.addTaint(other.dsTaint);
        dsTaint.addTaint(flags);
        int changes;
        changes = 0;
        {
            mAction = other.mAction;
            changes |= FILL_IN_ACTION;
        } //End block
        {
            mData = other.mData;
            mType = other.mType;
            changes |= FILL_IN_DATA;
        } //End block
        {
            {
                mCategories = new HashSet<String>(other.mCategories);
            } //End block
            changes |= FILL_IN_CATEGORIES;
        } //End block
        {
            {
                mPackage = other.mPackage;
                changes |= FILL_IN_PACKAGE;
            } //End block
        } //End block
        {
            {
                mSelector = new Intent(other.mSelector);
                mPackage = null;
                changes |= FILL_IN_SELECTOR;
            } //End block
        } //End block
        {
            mComponent = other.mComponent;
            changes |= FILL_IN_COMPONENT;
        } //End block
        mFlags |= other.mFlags;
        {
            mSourceBounds = new Rect(other.mSourceBounds);
            changes |= FILL_IN_SOURCE_BOUNDS;
        } //End block
        {
            {
                mExtras = new Bundle(other.mExtras);
            } //End block
        } //End block
        {
            try 
            {
                Bundle newb;
                newb = new Bundle(other.mExtras);
                newb.putAll(mExtras);
                mExtras = newb;
            } //End block
            catch (RuntimeException e)
            { }
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.905 -0400", hash_original_method = "B6E4053A3570119C1E3D361525D403A8", hash_generated_method = "E3687AA3C85289026247E2EA7600BC4B")
    @DSModeled(DSC.SPEC)
    public boolean filterEquals(Intent other) {
        dsTaint.addTaint(other.dsTaint);
        {
            {
                {
                    boolean var34A6740CF00C4CE99E014DB52800A86C_1329241010 = (!mAction.equals(other.mAction));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varAEFDA509D1872F11467FB8BDF0BEF91F_56367358 = (!other.mAction.equals(mAction));
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    boolean var1B3E4D86DDEB4D4A831A6326700A0F0B_636020822 = (!mData.equals(other.mData));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varB9280F5A87CB7471F1F68ACAD9FF512A_889788114 = (!other.mData.equals(mData));
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    boolean var6E90D3CB216BAFFC33A8A7351B637345_1912455738 = (!mType.equals(other.mType));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var49F589FDF6BAFD9349A39C37D467C96C_1363725763 = (!other.mType.equals(mType));
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    boolean var0FF5A23B099AB3A4E4889633C3DF81A9_1055632276 = (!mPackage.equals(other.mPackage));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var7A82FF7EACC0A9829485BCB718ACD023_2076593560 = (!other.mPackage.equals(mPackage));
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    boolean var8978EFF033EC0F607CC0AB6AE0299151_2117316584 = (!mComponent.equals(other.mComponent));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var384CAB8913950049F62446B39911719F_906467180 = (!other.mComponent.equals(mComponent));
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    boolean varAE538A113FE5A591A0CC1368E43F8DD6_465299536 = (!mCategories.equals(other.mCategories));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varE14E437DACF017225A5A506C3E8F03FE_1636563157 = (!other.mCategories.equals(mCategories));
                } //End collapsed parenthetic
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.917 -0400", hash_original_method = "8096117DA4698C90A65D3667512D1D4C", hash_generated_method = "7849F27C41C7C27FA3CDE11D76C780ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int filterHashCode() {
        int code;
        code = 0;
        {
            code += mAction.hashCode();
        } //End block
        {
            code += mData.hashCode();
        } //End block
        {
            code += mType.hashCode();
        } //End block
        {
            code += mPackage.hashCode();
        } //End block
        {
            code += mComponent.hashCode();
        } //End block
        {
            code += mCategories.hashCode();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int code = 0;
        //if (mAction != null) {
            //code += mAction.hashCode();
        //}
        //if (mData != null) {
            //code += mData.hashCode();
        //}
        //if (mType != null) {
            //code += mType.hashCode();
        //}
        //if (mPackage != null) {
            //code += mPackage.hashCode();
        //}
        //if (mComponent != null) {
            //code += mComponent.hashCode();
        //}
        //if (mCategories != null) {
            //code += mCategories.hashCode();
        //}
        //return code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.929 -0400", hash_original_method = "A07DFF04DF4B6FC888385D304C4BCF4A", hash_generated_method = "1AF9DBB63B8CB35B9325DF10C085AC99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder b;
        b = new StringBuilder(128);
        b.append("Intent { ");
        toShortString(b, true, true, true);
        b.append(" }");
        String varAFA387FFE5FA21CB2784F303FB8FD58D_1407049445 = (b.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder b = new StringBuilder(128);
        //b.append("Intent { ");
        //toShortString(b, true, true, true);
        //b.append(" }");
        //return b.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.933 -0400", hash_original_method = "561478671997B5BD9B57800B6A20BE68", hash_generated_method = "6B9B8E1D9AB10903A03BDFF9E020AF7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toInsecureString() {
        StringBuilder b;
        b = new StringBuilder(128);
        b.append("Intent { ");
        toShortString(b, false, true, true);
        b.append(" }");
        String varAFA387FFE5FA21CB2784F303FB8FD58D_1081709349 = (b.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder b = new StringBuilder(128);
        //b.append("Intent { ");
        //toShortString(b, false, true, true);
        //b.append(" }");
        //return b.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.936 -0400", hash_original_method = "78E0A44749B0E137B37BE3EA0840E73D", hash_generated_method = "DAB4DB6F6295BB6FA8F78EE0C974F667")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toShortString(boolean secure, boolean comp, boolean extras) {
        dsTaint.addTaint(comp);
        dsTaint.addTaint(secure);
        dsTaint.addTaint(extras);
        StringBuilder b;
        b = new StringBuilder(128);
        toShortString(b, secure, comp, extras);
        String varAFA387FFE5FA21CB2784F303FB8FD58D_898609421 = (b.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder b = new StringBuilder(128);
        //toShortString(b, secure, comp, extras);
        //return b.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.980 -0400", hash_original_method = "084143D5D45481DE69737429FAF260F9", hash_generated_method = "196F25DAB2B7CD8C22FF3B4328C66B00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void toShortString(StringBuilder b, boolean secure, boolean comp, boolean extras) {
        dsTaint.addTaint(comp);
        dsTaint.addTaint(b.dsTaint);
        dsTaint.addTaint(secure);
        dsTaint.addTaint(extras);
        boolean first;
        first = true;
        {
            b.append("act=").append(mAction);
            first = false;
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("cat=[");
            Iterator<String> i;
            i = mCategories.iterator();
            boolean didone;
            didone = false;
            {
                boolean varD8B5E52A597500CBD863E52A46B42708_1279874379 = (i.hasNext());
                {
                    b.append(",");
                    didone = true;
                    b.append(i.next());
                } //End block
            } //End collapsed parenthetic
            b.append("]");
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("dat=");
            {
                b.append(mData.toSafeString());
            } //End block
            {
                b.append(mData);
            } //End block
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("typ=").append(mType);
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("flg=0x").append(Integer.toHexString(mFlags));
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("pkg=").append(mPackage);
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("cmp=").append(mComponent.flattenToShortString());
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("bnds=").append(mSourceBounds.toShortString());
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("(has extras)");
        } //End block
        {
            b.append(" sel={");
            mSelector.toShortString(b, secure, comp, extras);
            b.append("}");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.989 -0400", hash_original_method = "A1DA43CBB31EA268C3AC25819B92FFB9", hash_generated_method = "221FF0CE8573CBA7656805356079301F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public String toURI() {
        String var45B38A796CB009C694F24FDA957E527A_1898900554 = (toUri(0));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return toUri(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:27.997 -0400", hash_original_method = "E005DA59F987D9130CC4868A94C4C496", hash_generated_method = "5A888A54785B3EE7C738A1C7388D7418")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toUri(int flags) {
        dsTaint.addTaint(flags);
        StringBuilder uri;
        uri = new StringBuilder(128);
        String scheme;
        scheme = null;
        {
            String data;
            data = mData.toString();
            {
                final int N;
                N = data.length();
                {
                    int i;
                    i = 0;
                    {
                        char c;
                        c = data.charAt(i);
                        {
                            scheme = data.substring(0, i);
                            uri.append("intent:");
                            data = data.substring(i+1);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            uri.append(data);
        } //End block
        {
            uri.append("intent:");
        } //End block
        uri.append("#Intent;");
        toUriInner(uri, scheme, flags);
        {
            uri.append("SEL;");
            mSelector.toUriInner(uri, null, flags);
        } //End block
        uri.append("end");
        String var9492102A459355C54E108EA1266B741C_1322610063 = (uri.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:28.014 -0400", hash_original_method = "C6B01852F6499829AE05E1CED618D6B2", hash_generated_method = "D8919AF4292D10B7C1D7D413BEF2FD5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void toUriInner(StringBuilder uri, String scheme, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(scheme);
        dsTaint.addTaint(uri.dsTaint);
        {
            uri.append("scheme=").append(scheme).append(';');
        } //End block
        {
            uri.append("action=").append(Uri.encode(mAction)).append(';');
        } //End block
        {
            {
                Iterator<String> seatecAstronomy42 = mCategories.iterator();
                seatecAstronomy42.hasNext();
                String category = seatecAstronomy42.next();
                {
                    uri.append("category=").append(Uri.encode(category)).append(';');
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            uri.append("type=").append(Uri.encode(mType, "/")).append(';');
        } //End block
        {
            uri.append("launchFlags=0x").append(Integer.toHexString(mFlags)).append(';');
        } //End block
        {
            uri.append("package=").append(Uri.encode(mPackage)).append(';');
        } //End block
        {
            uri.append("component=").append(Uri.encode(
                    mComponent.flattenToShortString(), "/")).append(';');
        } //End block
        {
            uri.append("sourceBounds=")
                    .append(Uri.encode(mSourceBounds.flattenToString()))
                    .append(';');
        } //End block
        {
            {
                Iterator<String> seatecAstronomy42 = mExtras.keySet().iterator();
                seatecAstronomy42.hasNext();
                String key = seatecAstronomy42.next();
                {
                    final Object value;
                    value = mExtras.get(key);
                    char entryType;
                    entryType = 's';
                    entryType = '\0';
                    {
                        uri.append(entryType);
                        uri.append('.');
                        uri.append(Uri.encode(key));
                        uri.append('=');
                        uri.append(Uri.encode(value.toString()));
                        uri.append(';');
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:28.020 -0400", hash_original_method = "2C347F4A4F86FFA77F246DC5FD21E5D6", hash_generated_method = "B18920DD6E1D595CCFE254BEED31A834")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int describeContents() {
        {
            Object varE627D80D86B1145CFBB6F925B58A1813_1614360316 = (mExtras.describeContents());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (mExtras != null) ? mExtras.describeContents() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:28.026 -0400", hash_original_method = "D9DA92F04D8A96D9F8D7CC23CBDB1396", hash_generated_method = "7538489DCC0F037ADCCC9FEF17465C0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeString(mAction);
        Uri.writeToParcel(out, mData);
        out.writeString(mType);
        out.writeInt(mFlags);
        out.writeString(mPackage);
        ComponentName.writeToParcel(mComponent, out);
        {
            out.writeInt(1);
            mSourceBounds.writeToParcel(out, flags);
        } //End block
        {
            out.writeInt(0);
        } //End block
        {
            out.writeInt(mCategories.size());
            {
                Iterator<String> seatecAstronomy42 = mCategories.iterator();
                seatecAstronomy42.hasNext();
                String category = seatecAstronomy42.next();
                {
                    out.writeString(category);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            out.writeInt(0);
        } //End block
        {
            out.writeInt(1);
            mSelector.writeToParcel(out, flags);
        } //End block
        {
            out.writeInt(0);
        } //End block
        out.writeBundle(mExtras);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:28.036 -0400", hash_original_method = "275963C0D40D3AED4795057AE368B460", hash_generated_method = "F05C584EAA49E8EFECF7B17B89DED3F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readFromParcel(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        setAction(in.readString());
        mData = Uri.CREATOR.createFromParcel(in);
        mType = in.readString();
        mFlags = in.readInt();
        mPackage = in.readString();
        mComponent = ComponentName.readFromParcel(in);
        {
            boolean var25D67F28E4887DDC152DCB9726EAB4D3_1490869367 = (in.readInt() != 0);
            {
                mSourceBounds = Rect.CREATOR.createFromParcel(in);
            } //End block
        } //End collapsed parenthetic
        int N;
        N = in.readInt();
        {
            mCategories = new HashSet<String>();
            int i;
            {
                i=0;
                {
                    mCategories.add(in.readString().intern());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mCategories = null;
        } //End block
        {
            boolean var25D67F28E4887DDC152DCB9726EAB4D3_467420219 = (in.readInt() != 0);
            {
                mSelector = new Intent(in);
            } //End block
        } //End collapsed parenthetic
        mExtras = in.readBundle();
        // ---------- Original Method ----------
        //setAction(in.readString());
        //mData = Uri.CREATOR.createFromParcel(in);
        //mType = in.readString();
        //mFlags = in.readInt();
        //mPackage = in.readString();
        //mComponent = ComponentName.readFromParcel(in);
        //if (in.readInt() != 0) {
            //mSourceBounds = Rect.CREATOR.createFromParcel(in);
        //}
        //int N = in.readInt();
        //if (N > 0) {
            //mCategories = new HashSet<String>();
            //int i;
            //for (i=0; i<N; i++) {
                //mCategories.add(in.readString().intern());
            //}
        //} else {
            //mCategories = null;
        //}
        //if (in.readInt() != 0) {
            //mSelector = new Intent(in);
        //}
        //mExtras = in.readBundle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:28.041 -0400", hash_original_method = "EA5BCA16215C9C34CA5AC6D2E9340E92", hash_generated_method = "8BCFD14ABAF0729FF1A1792BB1869177")
    public static Intent parseIntent(Resources resources, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        Intent intent = new Intent();
        TypedArray sa = resources.obtainAttributes(attrs,
                com.android.internal.R.styleable.Intent);
        intent.setAction(sa.getString(com.android.internal.R.styleable.Intent_action));
        String data = sa.getString(com.android.internal.R.styleable.Intent_data);
        String mimeType = sa.getString(com.android.internal.R.styleable.Intent_mimeType);
        intent.setDataAndType(data != null ? Uri.parse(data) : null, mimeType);
        String packageName = sa.getString(com.android.internal.R.styleable.Intent_targetPackage);
        String className = sa.getString(com.android.internal.R.styleable.Intent_targetClass);
        if (packageName != null && className != null) {
            intent.setComponent(new ComponentName(packageName, className));
        }
        sa.recycle();
        int outerDepth = parser.getDepth();
        int type;
        while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth)) {
            if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                continue;
            }
            String nodeName = parser.getName();
            if (nodeName.equals("category")) {
                sa = resources.obtainAttributes(attrs,
                        com.android.internal.R.styleable.IntentCategory);
                String cat = sa.getString(com.android.internal.R.styleable.IntentCategory_name);
                sa.recycle();
                if (cat != null) {
                    intent.addCategory(cat);
                }
                XmlUtils.skipCurrentTag(parser);
            } else if (nodeName.equals("extra")) {
                if (intent.mExtras == null) {
                    intent.mExtras = new Bundle();
                }
                resources.parseBundleExtra("extra", attrs, intent.mExtras);
                XmlUtils.skipCurrentTag(parser);
            } else {
                XmlUtils.skipCurrentTag(parser);
            }
        }
        return intent;
    }

    
    public static class ShortcutIconResource implements Parcelable {
        public String packageName;
        public String resourceName;
        public static final Parcelable.Creator<ShortcutIconResource> CREATOR = new Parcelable.Creator<ShortcutIconResource>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:28.045 -0400", hash_original_method = "E5EFB41AF12EFD491D45E99DE4F055C4", hash_generated_method = "00D83C00214578027E44A3A7B5390156")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public ShortcutIconResource createFromParcel(Parcel source) {
                dsTaint.addTaint(source.dsTaint);
                ShortcutIconResource icon;
                icon = new ShortcutIconResource();
                icon.packageName = source.readString();
                icon.resourceName = source.readString();
                return (ShortcutIconResource)dsTaint.getTaint();
                // ---------- Original Method ----------
                //ShortcutIconResource icon = new ShortcutIconResource();
                //icon.packageName = source.readString();
                //icon.resourceName = source.readString();
                //return icon;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:28.048 -0400", hash_original_method = "3C31821CAA714EDAC90B580A2669C2C0", hash_generated_method = "D380EE05F2118C1557C5FED19BA61B8C")
            @DSModeled(DSC.SAFE)
            public ShortcutIconResource[] newArray(int size) {
                dsTaint.addTaint(size);
                return (ShortcutIconResource[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new ShortcutIconResource[size];
            }

            
}; //Transformed anonymous class
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:28.051 -0400", hash_original_method = "9BE6357EB542FC84A087A4445B1D473C", hash_generated_method = "38B512328D2735C6716B0A16A54B15A6")
        public static ShortcutIconResource fromContext(Context context, int resourceId) {
            ShortcutIconResource icon = new ShortcutIconResource();
            icon.packageName = context.getPackageName();
            icon.resourceName = context.getResources().getResourceName(resourceId);
            return icon;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:28.053 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:28.056 -0400", hash_original_method = "A078CBD5399741F593957325C4A01342", hash_generated_method = "8B65415F69B91E795AAFE2A719E76BC8")
        @DSModeled(DSC.SAFE)
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(dest.dsTaint);
            dsTaint.addTaint(flags);
            dest.writeString(packageName);
            dest.writeString(resourceName);
            // ---------- Original Method ----------
            //dest.writeString(packageName);
            //dest.writeString(resourceName);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:28.059 -0400", hash_original_method = "8D66F7367028E1EB1EA87D8477E02D6C", hash_generated_method = "1DCDF3ABC96B5538468197BB88A33325")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return resourceName;
        }

        
    }


    
    public static final class FilterComparison {
        private final Intent mIntent;
        private final int mHashCode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:28.062 -0400", hash_original_method = "2099CA9774C8964FCB84A0C5BA5EC3C6", hash_generated_method = "1667FF8D70F07CA9C77770F0F1D6A071")
        @DSModeled(DSC.SPEC)
        public FilterComparison(Intent intent) {
            dsTaint.addTaint(intent.dsTaint);
            mIntent = intent;
            mHashCode = intent.filterHashCode();
            // ---------- Original Method ----------
            //mIntent = intent;
            //mHashCode = intent.filterHashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:28.064 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "0171D0DC4EAD6361737CA1E97CC20C8A")
        @DSModeled(DSC.SPEC)
        public Intent getIntent() {
            return (Intent)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mIntent;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:28.068 -0400", hash_original_method = "57E0DE3F426C34FAD2C087D7985C733F", hash_generated_method = "A6F88B466A58954AFCE1BEBD71DD1C66")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            {
                Intent other;
                other = ((FilterComparison)obj).mIntent;
                boolean varE65638074C2BB312154E364F2332F00A_1707058790 = (mIntent.filterEquals(other));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (obj instanceof FilterComparison) {
                //Intent other = ((FilterComparison)obj).mIntent;
                //return mIntent.filterEquals(other);
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:42:28.071 -0400", hash_original_method = "D7D5E8B622FC6A9CB6E203DCD79B8799", hash_generated_method = "CC95935C60ED1B6371583A785322D85D")
        @DSModeled(DSC.SAFE)
        @Override
        public int hashCode() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mHashCode;
        }

        
    }


    
}


//DSFIXME:  CODE0011:  Unresolved legacy methods exist in original model
/*

*/
