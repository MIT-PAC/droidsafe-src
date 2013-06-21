package android.provider;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.IContentProvider;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Log;
import android.view.WindowOrientationListener;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;

public final class Settings {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.991 -0400", hash_original_method = "9E9C65F3ECED90949A3BED36B52A3064", hash_generated_method = "9E9C65F3ECED90949A3BED36B52A3064")
        public Settings ()
    {
    }


        public static String getGTalkDeviceId(long androidId) {
        return "android-" + Long.toHexString(androidId);
    }

    
    public static class SettingNotFoundException extends AndroidException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.992 -0400", hash_original_method = "9D3DA3FD01BD65E9C8D44BD33E232128", hash_generated_method = "52BC52B0A250352B9CAF9585096F5384")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SettingNotFoundException(String msg) {
            super(msg);
            dsTaint.addTaint(msg);
            // ---------- Original Method ----------
        }

        
    }


    
    public static class NameValueTable implements BaseColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.992 -0400", hash_original_method = "DD1594AE2393A9C243453FFEF17696E5", hash_generated_method = "DD1594AE2393A9C243453FFEF17696E5")
                public NameValueTable ()
        {
        }


                protected static boolean putString(ContentResolver resolver, Uri uri,
                String name, String value) {
            try {
                ContentValues values = new ContentValues();
                values.put(NAME, name);
                values.put(VALUE, value);
                resolver.insert(uri, values);
                return true;
            } catch (SQLException e) {
                Log.w(TAG, "Can't set key " + name + " in " + uri, e);
                return false;
            }
        }

        
                public static Uri getUriFor(Uri uri, String name) {
            return Uri.withAppendedPath(uri, name);
        }

        
        public static final String NAME = "name";
        public static final String VALUE = "value";
    }


    
    private static class NameValueCache {
        private String mVersionSystemProperty;
        private Uri mUri;
        private HashMap<String, String> mValues = new HashMap<String, String>();
        private long mValuesVersion = 0;
        private IContentProvider mContentProvider = null;
        private String mCallCommand;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.992 -0400", hash_original_method = "AA2EC60B6F4EA71E8A16119EB161E070", hash_generated_method = "258E18A5EA291563A0BB98303A3911E6")
        @DSModeled(DSC.SPEC)
        public NameValueCache(String versionSystemProperty, Uri uri, String callCommand) {
            dsTaint.addTaint(callCommand);
            dsTaint.addTaint(versionSystemProperty);
            dsTaint.addTaint(uri.dsTaint);
            // ---------- Original Method ----------
            //mVersionSystemProperty = versionSystemProperty;
            //mUri = uri;
            //mCallCommand = callCommand;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.993 -0400", hash_original_method = "30813ECB8D9A0346E7379ADA0BD790C8", hash_generated_method = "1DCD733CBB302AF4F745ED429DFC8AD2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getString(ContentResolver cr, String name) {
            dsTaint.addTaint(cr.dsTaint);
            dsTaint.addTaint(name);
            long newValuesVersion;
            newValuesVersion = SystemProperties.getLong(mVersionSystemProperty, 0);
            {
                {
                    mValues.clear();
                    mValuesVersion = newValuesVersion;
                } //End block
                {
                    boolean varF248B3A69A82BD386B70A575B06BB5F0_417441669 = (mValues.containsKey(name));
                    {
                        String var3CC66E8B9BAEC9E10CE33AD641F02C18_1730472165 = (mValues.get(name));
                    } //End block
                } //End collapsed parenthetic
            } //End block
            IContentProvider cp;
            cp = null;
            {
                cp = mContentProvider;
                {
                    cp = mContentProvider = cr.acquireProvider(mUri.getAuthority());
                } //End block
            } //End block
            {
                try 
                {
                    Bundle b;
                    b = cp.call(mCallCommand, name, null);
                    {
                        String value;
                        value = b.getPairValue();
                        {
                            mValues.put(name, value);
                        } //End block
                    } //End block
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            Cursor c;
            c = null;
            try 
            {
                c = cp.query(mUri, SELECT_VALUE, NAME_EQ_PLACEHOLDER,
                             new String[]{name}, null);
                String value;
                boolean var4D86B3BFFD03EEDEB3FCD4358BA0EB15_517595812 = (c.moveToNext());
                value = c.getString(0);
                value = null;
                {
                    mValues.put(name, value);
                } //End block
            } //End block
            catch (RemoteException e)
            { }
            finally 
            {
                c.close();
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private static final String[] SELECT_VALUE =
            new String[] { Settings.NameValueTable.VALUE };
        private static final String NAME_EQ_PLACEHOLDER = "name=?";
    }


    
    public static final class System extends NameValueTable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.994 -0400", hash_original_method = "011E22A399537A71CE4EA301896DF590", hash_generated_method = "011E22A399537A71CE4EA301896DF590")
                public System ()
        {
        }


                public synchronized static String getString(ContentResolver resolver, String name) {
            if (MOVED_TO_SECURE.contains(name)) {
                Log.w(TAG, "Setting " + name + " has moved from android.provider.Settings.System"
                        + " to android.provider.Settings.Secure, returning read-only value.");
                return Secure.getString(resolver, name);
            }
            if (sNameValueCache == null) {
                sNameValueCache = new NameValueCache(SYS_PROP_SETTING_VERSION, CONTENT_URI,
                                                     CALL_METHOD_GET_SYSTEM);
            }
            return sNameValueCache.getString(resolver, name);
        }

        
                public static boolean putString(ContentResolver resolver, String name, String value) {
            if (MOVED_TO_SECURE.contains(name)) {
                Log.w(TAG, "Setting " + name + " has moved from android.provider.Settings.System"
                        + " to android.provider.Settings.Secure, value is unchanged.");
                return false;
            }
            return putString(resolver, CONTENT_URI, name, value);
        }

        
                public static Uri getUriFor(String name) {
            if (MOVED_TO_SECURE.contains(name)) {
                Log.w(TAG, "Setting " + name + " has moved from android.provider.Settings.System"
                    + " to android.provider.Settings.Secure, returning Secure URI.");
                return Secure.getUriFor(Secure.CONTENT_URI, name);
            }
            return getUriFor(CONTENT_URI, name);
        }

        
                public static int getInt(ContentResolver cr, String name, int def) {
            String v = getString(cr, name);
            try {
                return v != null ? Integer.parseInt(v) : def;
            } catch (NumberFormatException e) {
                return def;
            }
        }

        
                public static int getInt(ContentResolver cr, String name) throws SettingNotFoundException {
            String v = getString(cr, name);
            try {
                return Integer.parseInt(v);
            } catch (NumberFormatException e) {
                throw new SettingNotFoundException(name);
            }
        }

        
                public static boolean putInt(ContentResolver cr, String name, int value) {
            return putString(cr, name, Integer.toString(value));
        }

        
                public static long getLong(ContentResolver cr, String name, long def) {
            String valString = getString(cr, name);
            long value;
            try {
                value = valString != null ? Long.parseLong(valString) : def;
            } catch (NumberFormatException e) {
                value = def;
            }
            return value;
        }

        
                public static long getLong(ContentResolver cr, String name) throws SettingNotFoundException {
            String valString = getString(cr, name);
            try {
                return Long.parseLong(valString);
            } catch (NumberFormatException e) {
                throw new SettingNotFoundException(name);
            }
        }

        
                public static boolean putLong(ContentResolver cr, String name, long value) {
            return putString(cr, name, Long.toString(value));
        }

        
                public static float getFloat(ContentResolver cr, String name, float def) {
            String v = getString(cr, name);
            try {
                return v != null ? Float.parseFloat(v) : def;
            } catch (NumberFormatException e) {
                return def;
            }
        }

        
                public static float getFloat(ContentResolver cr, String name) throws SettingNotFoundException {
            String v = getString(cr, name);
            if (v == null) {
                throw new SettingNotFoundException(name);
            }
            try {
                return Float.parseFloat(v);
            } catch (NumberFormatException e) {
                throw new SettingNotFoundException(name);
            }
        }

        
                public static boolean putFloat(ContentResolver cr, String name, float value) {
            return putString(cr, name, Float.toString(value));
        }

        
                public static void getConfiguration(ContentResolver cr, Configuration outConfig) {
            outConfig.fontScale = Settings.System.getFloat(
                cr, FONT_SCALE, outConfig.fontScale);
            if (outConfig.fontScale < 0) {
                outConfig.fontScale = 1;
            }
        }

        
                public static void clearConfiguration(Configuration inoutConfig) {
            inoutConfig.fontScale = 0;
        }

        
                public static boolean putConfiguration(ContentResolver cr, Configuration config) {
            return Settings.System.putFloat(cr, FONT_SCALE, config.fontScale);
        }

        
                public static boolean hasInterestingConfigurationChanges(int changes) {
            return (changes&ActivityInfo.CONFIG_FONT_SCALE) != 0;
        }

        
                public static boolean getShowGTalkServiceStatus(ContentResolver cr) {
            return getInt(cr, SHOW_GTALK_SERVICE_STATUS, 0) != 0;
        }

        
                public static void setShowGTalkServiceStatus(ContentResolver cr, boolean flag) {
            putInt(cr, SHOW_GTALK_SERVICE_STATUS, flag ? 1 : 0);
        }

        
        public static final String SYS_PROP_SETTING_VERSION = "sys.settings_system_version";
        private static NameValueCache sNameValueCache = null;
        private static final HashSet<String> MOVED_TO_SECURE;
        static {
            MOVED_TO_SECURE = new HashSet<String>(30);
            MOVED_TO_SECURE.add(Secure.ADB_ENABLED);
            MOVED_TO_SECURE.add(Secure.ANDROID_ID);
            MOVED_TO_SECURE.add(Secure.BLUETOOTH_ON);
            MOVED_TO_SECURE.add(Secure.DATA_ROAMING);
            MOVED_TO_SECURE.add(Secure.DEVICE_PROVISIONED);
            MOVED_TO_SECURE.add(Secure.HTTP_PROXY);
            MOVED_TO_SECURE.add(Secure.INSTALL_NON_MARKET_APPS);
            MOVED_TO_SECURE.add(Secure.LOCATION_PROVIDERS_ALLOWED);
            MOVED_TO_SECURE.add(Secure.LOCK_PATTERN_ENABLED);
            MOVED_TO_SECURE.add(Secure.LOCK_PATTERN_VISIBLE);
            MOVED_TO_SECURE.add(Secure.LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED);
            MOVED_TO_SECURE.add(Secure.LOGGING_ID);
            MOVED_TO_SECURE.add(Secure.PARENTAL_CONTROL_ENABLED);
            MOVED_TO_SECURE.add(Secure.PARENTAL_CONTROL_LAST_UPDATE);
            MOVED_TO_SECURE.add(Secure.PARENTAL_CONTROL_REDIRECT_URL);
            MOVED_TO_SECURE.add(Secure.SETTINGS_CLASSNAME);
            MOVED_TO_SECURE.add(Secure.USB_MASS_STORAGE_ENABLED);
            MOVED_TO_SECURE.add(Secure.USE_GOOGLE_MAIL);
            MOVED_TO_SECURE.add(Secure.WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON);
            MOVED_TO_SECURE.add(Secure.WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY);
            MOVED_TO_SECURE.add(Secure.WIFI_NUM_OPEN_NETWORKS_KEPT);
            MOVED_TO_SECURE.add(Secure.WIFI_ON);
            MOVED_TO_SECURE.add(Secure.WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE);
            MOVED_TO_SECURE.add(Secure.WIFI_WATCHDOG_AP_COUNT);
            MOVED_TO_SECURE.add(Secure.WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS);
            MOVED_TO_SECURE.add(Secure.WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED);
            MOVED_TO_SECURE.add(Secure.WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS);
            MOVED_TO_SECURE.add(Secure.WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT);
            MOVED_TO_SECURE.add(Secure.WIFI_WATCHDOG_MAX_AP_CHECKS);
            MOVED_TO_SECURE.add(Secure.WIFI_WATCHDOG_ON);
            MOVED_TO_SECURE.add(Secure.WIFI_WATCHDOG_PING_COUNT);
            MOVED_TO_SECURE.add(Secure.WIFI_WATCHDOG_PING_DELAY_MS);
            MOVED_TO_SECURE.add(Secure.WIFI_WATCHDOG_PING_TIMEOUT_MS);
        }
        
        public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/system");
        public static final String STAY_ON_WHILE_PLUGGED_IN = "stay_on_while_plugged_in";
        public static final String END_BUTTON_BEHAVIOR = "end_button_behavior";
        public static final int END_BUTTON_BEHAVIOR_HOME = 0x1;
        public static final int END_BUTTON_BEHAVIOR_SLEEP = 0x2;
        public static final int END_BUTTON_BEHAVIOR_DEFAULT = END_BUTTON_BEHAVIOR_SLEEP;
        public static final String ADVANCED_SETTINGS = "advanced_settings";
        public static final int ADVANCED_SETTINGS_DEFAULT = 0;
        public static final String AIRPLANE_MODE_ON = "airplane_mode_on";
        public static final String RADIO_BLUETOOTH = "bluetooth";
        public static final String RADIO_WIFI = "wifi";
        public static final String RADIO_WIMAX = "wimax";
        public static final String RADIO_CELL = "cell";
        public static final String RADIO_NFC = "nfc";
        public static final String AIRPLANE_MODE_RADIOS = "airplane_mode_radios";
        public static final String AIRPLANE_MODE_TOGGLEABLE_RADIOS = "airplane_mode_toggleable_radios";
        public static final String WIFI_SLEEP_POLICY = "wifi_sleep_policy";
        public static final int WIFI_SLEEP_POLICY_DEFAULT = 0;
        public static final int WIFI_SLEEP_POLICY_NEVER_WHILE_PLUGGED = 1;
        public static final int WIFI_SLEEP_POLICY_NEVER = 2;
        public static final String WIFI_USE_STATIC_IP = "wifi_use_static_ip";
        public static final String WIFI_STATIC_IP = "wifi_static_ip";
        public static final String WIFI_STATIC_GATEWAY = "wifi_static_gateway";
        public static final String WIFI_STATIC_NETMASK = "wifi_static_netmask";
        public static final String WIFI_STATIC_DNS1 = "wifi_static_dns1";
        public static final String WIFI_STATIC_DNS2 = "wifi_static_dns2";
        public static final String BLUETOOTH_DISCOVERABILITY =
            "bluetooth_discoverability";
        public static final String BLUETOOTH_DISCOVERABILITY_TIMEOUT =
            "bluetooth_discoverability_timeout";
        @Deprecated public static final String LOCK_PATTERN_ENABLED = Secure.LOCK_PATTERN_ENABLED;
        @Deprecated public static final String LOCK_PATTERN_VISIBLE = "lock_pattern_visible_pattern";
        @Deprecated public static final String LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED =
            "lock_pattern_tactile_feedback_enabled";
        public static final String NEXT_ALARM_FORMATTED = "next_alarm_formatted";
        public static final String FONT_SCALE = "font_scale";
        public static final String DEBUG_APP = "debug_app";
        public static final String WAIT_FOR_DEBUGGER = "wait_for_debugger";
        public static final String DIM_SCREEN = "dim_screen";
        public static final String SCREEN_OFF_TIMEOUT = "screen_off_timeout";
        public static final String COMPATIBILITY_MODE = "compatibility_mode";
        public static final String SCREEN_BRIGHTNESS = "screen_brightness";
        public static final String SCREEN_BRIGHTNESS_MODE = "screen_brightness_mode";
        public static final int SCREEN_BRIGHTNESS_MODE_MANUAL = 0;
        public static final int SCREEN_BRIGHTNESS_MODE_AUTOMATIC = 1;
        public static final String SHOW_PROCESSES = "show_processes";
        public static final String ALWAYS_FINISH_ACTIVITIES =
                "always_finish_activities";
        public static final String MODE_RINGER = "mode_ringer";
        public static final String MODE_RINGER_STREAMS_AFFECTED = "mode_ringer_streams_affected";
        public static final String MUTE_STREAMS_AFFECTED = "mute_streams_affected";
        public static final String VIBRATE_ON = "vibrate_on";
        public static final String VOLUME_RING = "volume_ring";
        public static final String VOLUME_SYSTEM = "volume_system";
        public static final String VOLUME_VOICE = "volume_voice";
        public static final String VOLUME_MUSIC = "volume_music";
        public static final String VOLUME_ALARM = "volume_alarm";
        public static final String VOLUME_NOTIFICATION = "volume_notification";
        public static final String VOLUME_BLUETOOTH_SCO = "volume_bluetooth_sco";
        @Deprecated public static final String NOTIFICATIONS_USE_RING_VOLUME =
            "notifications_use_ring_volume";
        public static final String VIBRATE_IN_SILENT = "vibrate_in_silent";
        public static final String[] VOLUME_SETTINGS = {
            VOLUME_VOICE, VOLUME_SYSTEM, VOLUME_RING, VOLUME_MUSIC,
            VOLUME_ALARM, VOLUME_NOTIFICATION, VOLUME_BLUETOOTH_SCO
        };
        public static final String APPEND_FOR_LAST_AUDIBLE = "_last_audible";
        public static final String RINGTONE = "ringtone";
        public static final Uri DEFAULT_RINGTONE_URI = getUriFor(RINGTONE);
        public static final String NOTIFICATION_SOUND = "notification_sound";
        public static final Uri DEFAULT_NOTIFICATION_URI = getUriFor(NOTIFICATION_SOUND);
        public static final String ALARM_ALERT = "alarm_alert";
        public static final Uri DEFAULT_ALARM_ALERT_URI = getUriFor(ALARM_ALERT);
        public static final String MEDIA_BUTTON_RECEIVER = "media_button_receiver";
        public static final String TEXT_AUTO_REPLACE = "auto_replace";
        public static final String TEXT_AUTO_CAPS = "auto_caps";
        public static final String TEXT_AUTO_PUNCTUATE = "auto_punctuate";
        public static final String TEXT_SHOW_PASSWORD = "show_password";
        public static final String SHOW_GTALK_SERVICE_STATUS =
                "SHOW_GTALK_SERVICE_STATUS";
        public static final String WALLPAPER_ACTIVITY = "wallpaper_activity";
        public static final String AUTO_TIME = "auto_time";
        public static final String AUTO_TIME_ZONE = "auto_time_zone";
        public static final String TIME_12_24 = "time_12_24";
        public static final String DATE_FORMAT = "date_format";
        public static final String SETUP_WIZARD_HAS_RUN = "setup_wizard_has_run";
        public static final String WINDOW_ANIMATION_SCALE = "window_animation_scale";
        public static final String TRANSITION_ANIMATION_SCALE = "transition_animation_scale";
        public static final String FANCY_IME_ANIMATIONS = "fancy_ime_animations";
        public static final String ACCELEROMETER_ROTATION = "accelerometer_rotation";
        public static final String USER_ROTATION = "user_rotation";
        public static final String DTMF_TONE_WHEN_DIALING = "dtmf_tone";
        public static final String DTMF_TONE_TYPE_WHEN_DIALING = "dtmf_tone_type";
        public static final String EMERGENCY_TONE = "emergency_tone";
        public static final String CALL_AUTO_RETRY = "call_auto_retry";
        public static final String HEARING_AID = "hearing_aid";
        public static final String TTY_MODE = "tty_mode";
        public static final String SOUND_EFFECTS_ENABLED = "sound_effects_enabled";
        public static final String HAPTIC_FEEDBACK_ENABLED = "haptic_feedback_enabled";
        @Deprecated public static final String SHOW_WEB_SUGGESTIONS = "show_web_suggestions";
        public static final String NOTIFICATION_LIGHT_PULSE = "notification_light_pulse";
        public static final String POINTER_LOCATION = "pointer_location";
        public static final String SHOW_TOUCHES = "show_touches";
        public static final String WINDOW_ORIENTATION_LISTENER_LOG =
                "window_orientation_listener_log";
        public static final String POWER_SOUNDS_ENABLED = "power_sounds_enabled";
        public static final String DOCK_SOUNDS_ENABLED = "dock_sounds_enabled";
        public static final String LOCKSCREEN_SOUNDS_ENABLED = "lockscreen_sounds_enabled";
        public static final String LOW_BATTERY_SOUND = "low_battery_sound";
        public static final String DESK_DOCK_SOUND = "desk_dock_sound";
        public static final String DESK_UNDOCK_SOUND = "desk_undock_sound";
        public static final String CAR_DOCK_SOUND = "car_dock_sound";
        public static final String CAR_UNDOCK_SOUND = "car_undock_sound";
        public static final String LOCK_SOUND = "lock_sound";
        public static final String UNLOCK_SOUND = "unlock_sound";
        public static final String SIP_RECEIVE_CALLS = "sip_receive_calls";
        public static final String SIP_CALL_OPTIONS = "sip_call_options";
        public static final String SIP_ALWAYS = "SIP_ALWAYS";
        public static final String SIP_ADDRESS_ONLY = "SIP_ADDRESS_ONLY";
        public static final String SIP_ASK_ME_EACH_TIME = "SIP_ASK_ME_EACH_TIME";
        public static final String POINTER_SPEED = "pointer_speed";
        public static final String[] SETTINGS_TO_BACKUP = {
            STAY_ON_WHILE_PLUGGED_IN,
            WIFI_USE_STATIC_IP,
            WIFI_STATIC_IP,
            WIFI_STATIC_GATEWAY,
            WIFI_STATIC_NETMASK,
            WIFI_STATIC_DNS1,
            WIFI_STATIC_DNS2,
            BLUETOOTH_DISCOVERABILITY,
            BLUETOOTH_DISCOVERABILITY_TIMEOUT,
            DIM_SCREEN,
            SCREEN_OFF_TIMEOUT,
            SCREEN_BRIGHTNESS,
            SCREEN_BRIGHTNESS_MODE,
            VIBRATE_ON,
            MODE_RINGER,
            MODE_RINGER_STREAMS_AFFECTED,
            MUTE_STREAMS_AFFECTED,
            VOLUME_VOICE,
            VOLUME_SYSTEM,
            VOLUME_RING,
            VOLUME_MUSIC,
            VOLUME_ALARM,
            VOLUME_NOTIFICATION,
            VOLUME_BLUETOOTH_SCO,
            VOLUME_VOICE + APPEND_FOR_LAST_AUDIBLE,
            VOLUME_SYSTEM + APPEND_FOR_LAST_AUDIBLE,
            VOLUME_RING + APPEND_FOR_LAST_AUDIBLE,
            VOLUME_MUSIC + APPEND_FOR_LAST_AUDIBLE,
            VOLUME_ALARM + APPEND_FOR_LAST_AUDIBLE,
            VOLUME_NOTIFICATION + APPEND_FOR_LAST_AUDIBLE,
            VOLUME_BLUETOOTH_SCO + APPEND_FOR_LAST_AUDIBLE,
            VIBRATE_IN_SILENT,
            TEXT_AUTO_REPLACE,
            TEXT_AUTO_CAPS,
            TEXT_AUTO_PUNCTUATE,
            TEXT_SHOW_PASSWORD,
            AUTO_TIME,
            AUTO_TIME_ZONE,
            TIME_12_24,
            DATE_FORMAT,
            ACCELEROMETER_ROTATION,
            USER_ROTATION,
            DTMF_TONE_WHEN_DIALING,
            DTMF_TONE_TYPE_WHEN_DIALING,
            EMERGENCY_TONE,
            CALL_AUTO_RETRY,
            HEARING_AID,
            TTY_MODE,
            SOUND_EFFECTS_ENABLED,
            HAPTIC_FEEDBACK_ENABLED,
            POWER_SOUNDS_ENABLED,
            DOCK_SOUNDS_ENABLED,
            LOCKSCREEN_SOUNDS_ENABLED,
            SHOW_WEB_SUGGESTIONS,
            NOTIFICATION_LIGHT_PULSE,
            SIP_CALL_OPTIONS,
            SIP_RECEIVE_CALLS,
            POINTER_SPEED,
        };
        @Deprecated public static final String ADB_ENABLED = Secure.ADB_ENABLED;
        @Deprecated public static final String ANDROID_ID = Secure.ANDROID_ID;
        @Deprecated public static final String BLUETOOTH_ON = Secure.BLUETOOTH_ON;
        @Deprecated public static final String DATA_ROAMING = Secure.DATA_ROAMING;
        @Deprecated public static final String DEVICE_PROVISIONED = Secure.DEVICE_PROVISIONED;
        @Deprecated public static final String HTTP_PROXY = Secure.HTTP_PROXY;
        @Deprecated public static final String INSTALL_NON_MARKET_APPS = Secure.INSTALL_NON_MARKET_APPS;
        @Deprecated public static final String LOCATION_PROVIDERS_ALLOWED = Secure.LOCATION_PROVIDERS_ALLOWED;
        @Deprecated public static final String LOGGING_ID = Secure.LOGGING_ID;
        @Deprecated public static final String NETWORK_PREFERENCE = Secure.NETWORK_PREFERENCE;
        @Deprecated public static final String PARENTAL_CONTROL_ENABLED = Secure.PARENTAL_CONTROL_ENABLED;
        @Deprecated public static final String PARENTAL_CONTROL_LAST_UPDATE = Secure.PARENTAL_CONTROL_LAST_UPDATE;
        @Deprecated public static final String PARENTAL_CONTROL_REDIRECT_URL =
            Secure.PARENTAL_CONTROL_REDIRECT_URL;
        @Deprecated public static final String SETTINGS_CLASSNAME = Secure.SETTINGS_CLASSNAME;
        @Deprecated public static final String USB_MASS_STORAGE_ENABLED = Secure.USB_MASS_STORAGE_ENABLED;
        @Deprecated public static final String USE_GOOGLE_MAIL = Secure.USE_GOOGLE_MAIL;
        @Deprecated public static final String WIFI_MAX_DHCP_RETRY_COUNT = Secure.WIFI_MAX_DHCP_RETRY_COUNT;
        @Deprecated public static final String WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS =
                Secure.WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS;
        @Deprecated public static final String WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON =
            Secure.WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON;
        @Deprecated public static final String WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY =
            Secure.WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY;
        @Deprecated public static final String WIFI_NUM_OPEN_NETWORKS_KEPT = Secure.WIFI_NUM_OPEN_NETWORKS_KEPT;
        @Deprecated public static final String WIFI_ON = Secure.WIFI_ON;
        @Deprecated public static final String WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE =
                Secure.WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE;
        @Deprecated public static final String WIFI_WATCHDOG_AP_COUNT = Secure.WIFI_WATCHDOG_AP_COUNT;
        @Deprecated public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS =
                Secure.WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS;
        @Deprecated public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED =
                Secure.WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED;
        @Deprecated public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS =
                Secure.WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS;
        @Deprecated public static final String WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT =
            Secure.WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT;
        @Deprecated public static final String WIFI_WATCHDOG_MAX_AP_CHECKS = Secure.WIFI_WATCHDOG_MAX_AP_CHECKS;
        @Deprecated public static final String WIFI_WATCHDOG_ON = Secure.WIFI_WATCHDOG_ON;
        @Deprecated public static final String WIFI_WATCHDOG_PING_COUNT = Secure.WIFI_WATCHDOG_PING_COUNT;
        @Deprecated public static final String WIFI_WATCHDOG_PING_DELAY_MS = Secure.WIFI_WATCHDOG_PING_DELAY_MS;
        @Deprecated public static final String WIFI_WATCHDOG_PING_TIMEOUT_MS =
            Secure.WIFI_WATCHDOG_PING_TIMEOUT_MS;
    }


    
    public static final class Secure extends NameValueTable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.997 -0400", hash_original_method = "DD2238145688C91DCB19B1B9D1BE5809", hash_generated_method = "DD2238145688C91DCB19B1B9D1BE5809")
                public Secure ()
        {
        }


                public synchronized static String getString(ContentResolver resolver, String name) {
            if (sNameValueCache == null) {
                sNameValueCache = new NameValueCache(SYS_PROP_SETTING_VERSION, CONTENT_URI,
                                                     CALL_METHOD_GET_SECURE);
            }
            return sNameValueCache.getString(resolver, name);
        }

        
                public static boolean putString(ContentResolver resolver,
                String name, String value) {
            return putString(resolver, CONTENT_URI, name, value);
        }

        
                public static Uri getUriFor(String name) {
            return getUriFor(CONTENT_URI, name);
        }

        
                public static int getInt(ContentResolver cr, String name, int def) {
            String v = getString(cr, name);
            try {
                return v != null ? Integer.parseInt(v) : def;
            } catch (NumberFormatException e) {
                return def;
            }
        }

        
                public static int getInt(ContentResolver cr, String name) throws SettingNotFoundException {
            String v = getString(cr, name);
            try {
                return Integer.parseInt(v);
            } catch (NumberFormatException e) {
                throw new SettingNotFoundException(name);
            }
        }

        
                public static boolean putInt(ContentResolver cr, String name, int value) {
            return putString(cr, name, Integer.toString(value));
        }

        
                public static long getLong(ContentResolver cr, String name, long def) {
            String valString = getString(cr, name);
            long value;
            try {
                value = valString != null ? Long.parseLong(valString) : def;
            } catch (NumberFormatException e) {
                value = def;
            }
            return value;
        }

        
                public static long getLong(ContentResolver cr, String name) throws SettingNotFoundException {
            String valString = getString(cr, name);
            try {
                return Long.parseLong(valString);
            } catch (NumberFormatException e) {
                throw new SettingNotFoundException(name);
            }
        }

        
                public static boolean putLong(ContentResolver cr, String name, long value) {
            return putString(cr, name, Long.toString(value));
        }

        
                public static float getFloat(ContentResolver cr, String name, float def) {
            String v = getString(cr, name);
            try {
                return v != null ? Float.parseFloat(v) : def;
            } catch (NumberFormatException e) {
                return def;
            }
        }

        
                public static float getFloat(ContentResolver cr, String name) throws SettingNotFoundException {
            String v = getString(cr, name);
            if (v == null) {
                throw new SettingNotFoundException(name);
            }
            try {
                return Float.parseFloat(v);
            } catch (NumberFormatException e) {
                throw new SettingNotFoundException(name);
            }
        }

        
                public static boolean putFloat(ContentResolver cr, String name, float value) {
            return putString(cr, name, Float.toString(value));
        }

        
                public static final String getBluetoothHeadsetPriorityKey(String address) {
            return ("bluetooth_headset_priority_" + address.toUpperCase());
        }

        
                public static final String getBluetoothA2dpSinkPriorityKey(String address) {
            return ("bluetooth_a2dp_sink_priority_" + address.toUpperCase());
        }

        
                public static final String getBluetoothInputDevicePriorityKey(String address) {
            return ("bluetooth_input_device_priority_" + address.toUpperCase());
        }

        
                public static final boolean isLocationProviderEnabled(ContentResolver cr, String provider) {
            String allowedProviders = Settings.Secure.getString(cr, LOCATION_PROVIDERS_ALLOWED);
            return TextUtils.delimitedStringContains(allowedProviders, ',', provider);
        }

        
                public static final void setLocationProviderEnabled(ContentResolver cr,
                String provider, boolean enabled) {
            if (enabled) {
                provider = "+" + provider;
            } else {
                provider = "-" + provider;
            }
            putString(cr, Settings.Secure.LOCATION_PROVIDERS_ALLOWED, provider);
        }

        
        public static final String SYS_PROP_SETTING_VERSION = "sys.settings_secure_version";
        private static NameValueCache sNameValueCache = null;
        public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/secure");
        public static final String ADB_ENABLED = "adb_enabled";
        public static final String ALLOW_MOCK_LOCATION = "mock_location";
        public static final String ANDROID_ID = "android_id";
        public static final String BLUETOOTH_ON = "bluetooth_on";
        public static final String DATA_ROAMING = "data_roaming";
        public static final String DEFAULT_INPUT_METHOD = "default_input_method";
        public static final String SELECTED_INPUT_METHOD_SUBTYPE =
                "selected_input_method_subtype";
        public static final String INPUT_METHODS_SUBTYPE_HISTORY =
                "input_methods_subtype_history";
        public static final String INPUT_METHOD_SELECTOR_VISIBILITY =
                "input_method_selector_visibility";
        public static final String DEVICE_PROVISIONED = "device_provisioned";
        public static final String ENABLED_INPUT_METHODS = "enabled_input_methods";
        public static final String DISABLED_SYSTEM_INPUT_METHODS = "disabled_system_input_methods";
        public static final String HTTP_PROXY = "http_proxy";
        public static final String GLOBAL_HTTP_PROXY_HOST = "global_http_proxy_host";
        public static final String GLOBAL_HTTP_PROXY_PORT = "global_http_proxy_port";
        public static final String GLOBAL_HTTP_PROXY_EXCLUSION_LIST =
                "global_http_proxy_exclusion_list";
        public static final String SET_GLOBAL_HTTP_PROXY = "set_global_http_proxy";
        public static final String DEFAULT_DNS_SERVER = "default_dns_server";
        public static final String INSTALL_NON_MARKET_APPS = "install_non_market_apps";
        public static final String LOCATION_PROVIDERS_ALLOWED = "location_providers_allowed";
        public static final String LOCK_PATTERN_ENABLED = "lock_pattern_autolock";
        public static final String LOCK_PATTERN_VISIBLE = "lock_pattern_visible_pattern";
        public static final String LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED =
            "lock_pattern_tactile_feedback_enabled";
        public static final String LOCK_SCREEN_LOCK_AFTER_TIMEOUT = "lock_screen_lock_after_timeout";
        public static final String LOCK_SCREEN_OWNER_INFO = "lock_screen_owner_info";
        public static final String LOCK_SCREEN_OWNER_INFO_ENABLED =
            "lock_screen_owner_info_enabled";
        public static final String DISPLAY_SIZE_FORCED = "display_size_forced";
        public static final String ASSISTED_GPS_ENABLED = "assisted_gps_enabled";
        @Deprecated public static final String LOGGING_ID = "logging_id";
        public static final String NETWORK_PREFERENCE = "network_preference";
        public static final String TETHER_SUPPORTED = "tether_supported";
        public static final String TETHER_DUN_REQUIRED = "tether_dun_required";
        public static final String TETHER_DUN_APN = "tether_dun_apn";
        public static final String PARENTAL_CONTROL_ENABLED = "parental_control_enabled";
        public static final String PARENTAL_CONTROL_LAST_UPDATE = "parental_control_last_update";
        public static final String PARENTAL_CONTROL_REDIRECT_URL = "parental_control_redirect_url";
        public static final String SAMPLING_PROFILER_MS = "sampling_profiler_ms";
        public static final String SETTINGS_CLASSNAME = "settings_classname";
        public static final String USB_MASS_STORAGE_ENABLED = "usb_mass_storage_enabled";
        public static final String USE_GOOGLE_MAIL = "use_google_mail";
        public static final String ACCESSIBILITY_ENABLED = "accessibility_enabled";
        public static final String TOUCH_EXPLORATION_ENABLED = "touch_exploration_enabled";
        public static final String ENABLED_ACCESSIBILITY_SERVICES =
            "enabled_accessibility_services";
        public static final String ACCESSIBILITY_SPEAK_PASSWORD = "speak_password";
        public static final String ACCESSIBILITY_SCRIPT_INJECTION =
            "accessibility_script_injection";
        public static final String ACCESSIBILITY_WEB_CONTENT_KEY_BINDINGS =
            "accessibility_web_content_key_bindings";
        public static final String LONG_PRESS_TIMEOUT = "long_press_timeout";
        @Deprecated public static final String TTS_USE_DEFAULTS = "tts_use_defaults";
        public static final String TTS_DEFAULT_RATE = "tts_default_rate";
        public static final String TTS_DEFAULT_PITCH = "tts_default_pitch";
        public static final String TTS_DEFAULT_SYNTH = "tts_default_synth";
        @Deprecated public static final String TTS_DEFAULT_LANG = "tts_default_lang";
        @Deprecated public static final String TTS_DEFAULT_COUNTRY = "tts_default_country";
        @Deprecated public static final String TTS_DEFAULT_VARIANT = "tts_default_variant";
        public static final String TTS_DEFAULT_LOCALE = "tts_default_locale";
        public static final String TTS_ENABLED_PLUGINS = "tts_enabled_plugins";
        public static final String WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON =
                "wifi_networks_available_notification_on";
        public static final String WIMAX_NETWORKS_AVAILABLE_NOTIFICATION_ON =
                "wimax_networks_available_notification_on";
        public static final String WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY =
                "wifi_networks_available_repeat_delay";
        public static final String WIFI_COUNTRY_CODE = "wifi_country_code";
        public static final String WIFI_NUM_OPEN_NETWORKS_KEPT = "wifi_num_open_networks_kept";
        public static final String WIFI_ON = "wifi_on";
        public static final String WIFI_SAVED_STATE = "wifi_saved_state";
        public static final String WIFI_AP_SSID = "wifi_ap_ssid";
        public static final String WIFI_AP_SECURITY = "wifi_ap_security";
        public static final String WIFI_AP_PASSWD = "wifi_ap_passwd";
        @Deprecated public static final String WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE =
                "wifi_watchdog_acceptable_packet_loss_percentage";
        @Deprecated public static final String WIFI_WATCHDOG_AP_COUNT = "wifi_watchdog_ap_count";
        @Deprecated public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS =
                "wifi_watchdog_background_check_delay_ms";
        @Deprecated public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED =
                "wifi_watchdog_background_check_enabled";
        @Deprecated public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS =
                "wifi_watchdog_background_check_timeout_ms";
        @Deprecated public static final String WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT =
            "wifi_watchdog_initial_ignored_ping_count";
        @Deprecated public static final String WIFI_WATCHDOG_MAX_AP_CHECKS = "wifi_watchdog_max_ap_checks";
        public static final String WIFI_WATCHDOG_ON = "wifi_watchdog_on";
        @Deprecated public static final String WIFI_WATCHDOG_WATCH_LIST = "wifi_watchdog_watch_list";
        @Deprecated public static final String WIFI_WATCHDOG_PING_COUNT = "wifi_watchdog_ping_count";
        @Deprecated public static final String WIFI_WATCHDOG_PING_DELAY_MS = "wifi_watchdog_ping_delay_ms";
        @Deprecated public static final String WIFI_WATCHDOG_PING_TIMEOUT_MS = "wifi_watchdog_ping_timeout_ms";
        public static final String WIFI_WATCHDOG_DNS_CHECK_SHORT_INTERVAL_MS =
                "wifi_watchdog_dns_check_short_interval_ms";
        public static final String WIFI_WATCHDOG_DNS_CHECK_LONG_INTERVAL_MS =
                "wifi_watchdog_dns_check_long_interval_ms";
        public static final String WIFI_WATCHDOG_WALLED_GARDEN_INTERVAL_MS =
                "wifi_watchdog_walled_garden_interval_ms";
        public static final String WIFI_WATCHDOG_MAX_SSID_BLACKLISTS =
                "wifi_watchdog_max_ssid_blacklists";
        public static final String WIFI_WATCHDOG_NUM_DNS_PINGS = "wifi_watchdog_num_dns_pings";
        public static final String WIFI_WATCHDOG_MIN_DNS_RESPONSES =
                "wifi_watchdog_min_dns_responses";
        public static final String WIFI_WATCHDOG_DNS_PING_TIMEOUT_MS =
                "wifi_watchdog_dns_ping_timeout_ms";
        public static final String WIFI_WATCHDOG_BLACKLIST_FOLLOWUP_INTERVAL_MS =
                "wifi_watchdog_blacklist_followup_interval_ms";
        public static final String WIFI_WATCHDOG_POOR_NETWORK_TEST_ENABLED =
                "wifi_watchdog_poor_network_test_enabled";
        public static final String WIFI_WATCHDOG_WALLED_GARDEN_TEST_ENABLED =
                "wifi_watchdog_walled_garden_test_enabled";
        public static final String WIFI_WATCHDOG_WALLED_GARDEN_URL =
                "wifi_watchdog_walled_garden_url";
        public static final String WIFI_WATCHDOG_SHOW_DISABLED_NETWORK_POPUP =
                "wifi_watchdog_show_disabled_network_popup";
        public static final String WIFI_MAX_DHCP_RETRY_COUNT = "wifi_max_dhcp_retry_count";
        public static final String WIFI_FREQUENCY_BAND = "wifi_frequency_band";
        public static final String WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS =
            "wifi_mobile_data_transition_wakelock_timeout_ms";
        @Deprecated public static final String BACKGROUND_DATA = "background_data";
        public static final String ALLOWED_GEOLOCATION_ORIGINS
                = "allowed_geolocation_origins";
        public static final String MOBILE_DATA = "mobile_data";
        public static final String CDMA_ROAMING_MODE = "roaming_settings";
        public static final String CDMA_SUBSCRIPTION_MODE = "subscription_mode";
        public static final String PREFERRED_NETWORK_MODE =
                "preferred_network_mode";
        public static final String PREFERRED_TTY_MODE =
                "preferred_tty_mode";
        public static final String CDMA_CELL_BROADCAST_SMS =
                "cdma_cell_broadcast_sms";
        public static final String PREFERRED_CDMA_SUBSCRIPTION =
                "preferred_cdma_subscription";
        public static final String ENHANCED_VOICE_PRIVACY_ENABLED = "enhanced_voice_privacy_enabled";
        public static final String TTY_MODE_ENABLED = "tty_mode_enabled";
        public static final String CONNECTIVITY_CHANGE_DELAY = "connectivity_change_delay";
        public static final int CONNECTIVITY_CHANGE_DELAY_DEFAULT = 3000;
        public static final String BACKUP_ENABLED = "backup_enabled";
        public static final String BACKUP_AUTO_RESTORE = "backup_auto_restore";
        public static final String BACKUP_PROVISIONED = "backup_provisioned";
        public static final String BACKUP_TRANSPORT = "backup_transport";
        public static final String LAST_SETUP_SHOWN = "last_setup_shown";
        public static final String MEMCHECK_INTERVAL = "memcheck_interval";
        public static final String MEMCHECK_LOG_REALTIME_INTERVAL =
                "memcheck_log_realtime_interval";
        public static final String MEMCHECK_SYSTEM_ENABLED = "memcheck_system_enabled";
        public static final String MEMCHECK_SYSTEM_SOFT_THRESHOLD = "memcheck_system_soft";
        public static final String MEMCHECK_SYSTEM_HARD_THRESHOLD = "memcheck_system_hard";
        public static final String MEMCHECK_PHONE_SOFT_THRESHOLD = "memcheck_phone_soft";
        public static final String MEMCHECK_PHONE_HARD_THRESHOLD = "memcheck_phone_hard";
        public static final String MEMCHECK_PHONE_ENABLED = "memcheck_phone_enabled";
        public static final String MEMCHECK_EXEC_START_TIME = "memcheck_exec_start_time";
        public static final String MEMCHECK_EXEC_END_TIME = "memcheck_exec_end_time";
        public static final String MEMCHECK_MIN_SCREEN_OFF = "memcheck_min_screen_off";
        public static final String MEMCHECK_MIN_ALARM = "memcheck_min_alarm";
        public static final String MEMCHECK_RECHECK_INTERVAL = "memcheck_recheck_interval";
        public static final String REBOOT_INTERVAL = "reboot_interval";
        public static final String REBOOT_START_TIME = "reboot_start_time";
        public static final String REBOOT_WINDOW = "reboot_window";
        public static final String BATTERY_DISCHARGE_DURATION_THRESHOLD =
                "battery_discharge_duration_threshold";
        public static final String BATTERY_DISCHARGE_THRESHOLD = "battery_discharge_threshold";
        public static final String SEND_ACTION_APP_ERROR = "send_action_app_error";
        public static final String WTF_IS_FATAL = "wtf_is_fatal";
        public static final String DROPBOX_AGE_SECONDS =
                "dropbox_age_seconds";
        public static final String DROPBOX_MAX_FILES =
                "dropbox_max_files";
        public static final String DROPBOX_QUOTA_KB =
                "dropbox_quota_kb";
        public static final String DROPBOX_QUOTA_PERCENT =
                "dropbox_quota_percent";
        public static final String DROPBOX_RESERVE_PERCENT =
                "dropbox_reserve_percent";
        public static final String DROPBOX_TAG_PREFIX =
                "dropbox:";
        public static final String ERROR_LOGCAT_PREFIX =
                "logcat_for_";
        public static final String SHORT_KEYLIGHT_DELAY_MS =
                "short_keylight_delay_ms";
        public static final String SYS_FREE_STORAGE_LOG_INTERVAL =
                "sys_free_storage_log_interval";
        public static final String DISK_FREE_CHANGE_REPORTING_THRESHOLD =
                "disk_free_change_reporting_threshold";
        public static final String SYS_STORAGE_THRESHOLD_PERCENTAGE =
                "sys_storage_threshold_percentage";
        public static final String SYS_STORAGE_THRESHOLD_MAX_BYTES =
                "sys_storage_threshold_max_bytes";
        public static final String SYS_STORAGE_FULL_THRESHOLD_BYTES =
                "sys_storage_full_threshold_bytes";
        public static final String WIFI_IDLE_MS = "wifi_idle_ms";
        public static final String WIFI_FRAMEWORK_SCAN_INTERVAL_MS =
                "wifi_framework_scan_interval_ms";
        public static final String WIFI_SUPPLICANT_SCAN_INTERVAL_MS =
                "wifi_supplicant_scan_interval_ms";
        public static final String PDP_WATCHDOG_POLL_INTERVAL_MS =
                "pdp_watchdog_poll_interval_ms";
        public static final String PDP_WATCHDOG_LONG_POLL_INTERVAL_MS =
                "pdp_watchdog_long_poll_interval_ms";
        public static final String PDP_WATCHDOG_ERROR_POLL_INTERVAL_MS =
                "pdp_watchdog_error_poll_interval_ms";
        public static final String PDP_WATCHDOG_TRIGGER_PACKET_COUNT =
                "pdp_watchdog_trigger_packet_count";
        public static final String PDP_WATCHDOG_ERROR_POLL_COUNT =
                "pdp_watchdog_error_poll_count";
        public static final String PDP_WATCHDOG_MAX_PDP_RESET_FAIL_COUNT =
                "pdp_watchdog_max_pdp_reset_fail_count";
        public static final String DATA_STALL_ALARM_NON_AGGRESSIVE_DELAY_IN_MS =
                "data_stall_alarm_non_aggressive_delay_in_ms";
        public static final String DATA_STALL_ALARM_AGGRESSIVE_DELAY_IN_MS =
                "data_stall_alarm_aggressive_delay_in_ms";
        public static final String GPRS_REGISTER_CHECK_PERIOD_MS =
                "gprs_register_check_period_ms";
        public static final String NITZ_UPDATE_SPACING = "nitz_update_spacing";
        public static final String NITZ_UPDATE_DIFF = "nitz_update_diff";
        public static final String SYNC_MAX_RETRY_DELAY_IN_SECONDS =
                "sync_max_retry_delay_in_seconds";
        public static final String SMS_OUTGOING_CHECK_INTERVAL_MS =
                "sms_outgoing_check_interval_ms";
        public static final String SMS_OUTGOING_CHECK_MAX_COUNT =
                "sms_outgoing_check_max_count";
        public static final String SEARCH_GLOBAL_SEARCH_ACTIVITY =
                "search_global_search_activity";
        public static final String SEARCH_NUM_PROMOTED_SOURCES = "search_num_promoted_sources";
        public static final String SEARCH_MAX_RESULTS_TO_DISPLAY = "search_max_results_to_display";
        public static final String SEARCH_MAX_RESULTS_PER_SOURCE = "search_max_results_per_source";
        public static final String SEARCH_WEB_RESULTS_OVERRIDE_LIMIT =
                "search_web_results_override_limit";
        public static final String SEARCH_PROMOTED_SOURCE_DEADLINE_MILLIS =
                "search_promoted_source_deadline_millis";
        public static final String SEARCH_SOURCE_TIMEOUT_MILLIS = "search_source_timeout_millis";
        public static final String SEARCH_PREFILL_MILLIS = "search_prefill_millis";
        public static final String SEARCH_MAX_STAT_AGE_MILLIS = "search_max_stat_age_millis";
        public static final String SEARCH_MAX_SOURCE_EVENT_AGE_MILLIS =
                "search_max_source_event_age_millis";
        public static final String SEARCH_MIN_IMPRESSIONS_FOR_SOURCE_RANKING =
                "search_min_impressions_for_source_ranking";
        public static final String SEARCH_MIN_CLICKS_FOR_SOURCE_RANKING =
                "search_min_clicks_for_source_ranking";
        public static final String SEARCH_MAX_SHORTCUTS_RETURNED = "search_max_shortcuts_returned";
        public static final String SEARCH_QUERY_THREAD_CORE_POOL_SIZE =
                "search_query_thread_core_pool_size";
        public static final String SEARCH_QUERY_THREAD_MAX_POOL_SIZE =
                "search_query_thread_max_pool_size";
        public static final String SEARCH_SHORTCUT_REFRESH_CORE_POOL_SIZE =
                "search_shortcut_refresh_core_pool_size";
        public static final String SEARCH_SHORTCUT_REFRESH_MAX_POOL_SIZE =
                "search_shortcut_refresh_max_pool_size";
        public static final String SEARCH_THREAD_KEEPALIVE_SECONDS =
                "search_thread_keepalive_seconds";
        public static final String SEARCH_PER_SOURCE_CONCURRENT_QUERY_LIMIT =
                "search_per_source_concurrent_query_limit";
        public static final String MOUNT_PLAY_NOTIFICATION_SND = "mount_play_not_snd";
        public static final String MOUNT_UMS_AUTOSTART = "mount_ums_autostart";
        public static final String MOUNT_UMS_PROMPT = "mount_ums_prompt";
        public static final String MOUNT_UMS_NOTIFY_ENABLED = "mount_ums_notify_enabled";
        public static final String ANR_SHOW_BACKGROUND = "anr_show_background";
        public static final String VOICE_RECOGNITION_SERVICE = "voice_recognition_service";
        public static final String SELECTED_SPELL_CHECKER = "selected_spell_checker";
        public static final String SELECTED_SPELL_CHECKER_SUBTYPE =
                "selected_spell_checker_subtype";
        public static final String SPELL_CHECKER_ENABLED = "spell_checker_enabled";
        public static final String INCALL_POWER_BUTTON_BEHAVIOR = "incall_power_button_behavior";
        public static final int INCALL_POWER_BUTTON_BEHAVIOR_SCREEN_OFF = 0x1;
        public static final int INCALL_POWER_BUTTON_BEHAVIOR_HANGUP = 0x2;
        public static final int INCALL_POWER_BUTTON_BEHAVIOR_DEFAULT =
                INCALL_POWER_BUTTON_BEHAVIOR_SCREEN_OFF;
        public static final String UI_NIGHT_MODE = "ui_night_mode";
        public static final String SET_INSTALL_LOCATION = "set_install_location";
        public static final String DEFAULT_INSTALL_LOCATION = "default_install_location";
        public static final String THROTTLE_POLLING_SEC = "throttle_polling_sec";
        public static final String THROTTLE_THRESHOLD_BYTES = "throttle_threshold_bytes";
        public static final String THROTTLE_VALUE_KBITSPS = "throttle_value_kbitsps";
        public static final String THROTTLE_RESET_DAY = "throttle_reset_day";
        public static final String THROTTLE_NOTIFICATION_TYPE = "throttle_notification_type";
        public static final String THROTTLE_HELP_URI = "throttle_help_uri";
        public static final String THROTTLE_MAX_NTP_CACHE_AGE_SEC =
                "throttle_max_ntp_cache_age_sec";
        public static final String DOWNLOAD_MAX_BYTES_OVER_MOBILE =
                "download_manager_max_bytes_over_mobile";
        public static final String DOWNLOAD_RECOMMENDED_MAX_BYTES_OVER_MOBILE =
                "download_manager_recommended_max_bytes_over_mobile";
        public static final String INET_CONDITION_DEBOUNCE_UP_DELAY =
                "inet_condition_debounce_up_delay";
        public static final String INET_CONDITION_DEBOUNCE_DOWN_DELAY =
                "inet_condition_debounce_down_delay";
        public static final String SETUP_PREPAID_DATA_SERVICE_URL =
                "setup_prepaid_data_service_url";
        public static final String SETUP_PREPAID_DETECTION_TARGET_URL =
                "setup_prepaid_detection_target_url";
        public static final String SETUP_PREPAID_DETECTION_REDIR_HOST =
                "setup_prepaid_detection_redir_host";
        public static final String NETSTATS_ENABLED = "netstats_enabled";
        public static final String NETSTATS_POLL_INTERVAL = "netstats_poll_interval";
        public static final String NETSTATS_PERSIST_THRESHOLD = "netstats_persist_threshold";
        public static final String NETSTATS_NETWORK_BUCKET_DURATION = "netstats_network_bucket_duration";
        public static final String NETSTATS_NETWORK_MAX_HISTORY = "netstats_network_max_history";
        public static final String NETSTATS_UID_BUCKET_DURATION = "netstats_uid_bucket_duration";
        public static final String NETSTATS_UID_MAX_HISTORY = "netstats_uid_max_history";
        public static final String NETSTATS_TAG_MAX_HISTORY = "netstats_tag_max_history";
        public static final String NTP_SERVER = "ntp_server";
        public static final String NTP_TIMEOUT = "ntp_timeout";
        public static final String WEB_AUTOFILL_QUERY_URL =
            "web_autofill_query_url";
        public static final String PACKAGE_VERIFIER_ENABLE = "verifier_enable";
        public static final String PACKAGE_VERIFIER_TIMEOUT = "verifier_timeout";
        public static final String CONTACTS_PREAUTH_URI_EXPIRATION =
                "contacts_preauth_uri_expiration";
        public static final String[] SETTINGS_TO_BACKUP = {
            ADB_ENABLED,
            ALLOW_MOCK_LOCATION,
            PARENTAL_CONTROL_ENABLED,
            PARENTAL_CONTROL_REDIRECT_URL,
            USB_MASS_STORAGE_ENABLED,
            ACCESSIBILITY_SCRIPT_INJECTION,
            BACKUP_AUTO_RESTORE,
            ENABLED_ACCESSIBILITY_SERVICES,
            TOUCH_EXPLORATION_ENABLED,
            ACCESSIBILITY_ENABLED,
            ACCESSIBILITY_SPEAK_PASSWORD,
            TTS_USE_DEFAULTS,
            TTS_DEFAULT_RATE,
            TTS_DEFAULT_PITCH,
            TTS_DEFAULT_SYNTH,
            TTS_DEFAULT_LANG,
            TTS_DEFAULT_COUNTRY,
            TTS_ENABLED_PLUGINS,
            TTS_DEFAULT_LOCALE,
            WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON,
            WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY,
            WIFI_NUM_OPEN_NETWORKS_KEPT,
            MOUNT_PLAY_NOTIFICATION_SND,
            MOUNT_UMS_AUTOSTART,
            MOUNT_UMS_PROMPT,
            MOUNT_UMS_NOTIFY_ENABLED,
            UI_NIGHT_MODE,
            LOCK_SCREEN_OWNER_INFO,
            LOCK_SCREEN_OWNER_INFO_ENABLED
        };
    }


    
    public static final class Bookmarks implements BaseColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.001 -0400", hash_original_method = "FBB082DE8180752D32E62381CDBD146E", hash_generated_method = "FBB082DE8180752D32E62381CDBD146E")
                public Bookmarks ()
        {
        }


                public static Intent getIntentForShortcut(ContentResolver cr, char shortcut) {
            Intent intent = null;
            Cursor c = cr.query(CONTENT_URI,
                    sIntentProjection, sShortcutSelection,
                    new String[] { String.valueOf((int) shortcut) }, ORDERING);
            try {
                while (intent == null && c.moveToNext()) {
                    try {
                        String intentURI = c.getString(c.getColumnIndexOrThrow(INTENT));
                        intent = Intent.parseUri(intentURI, 0);
                    } catch (java.net.URISyntaxException e) {
                    } catch (IllegalArgumentException e) {
                        Log.w(TAG, "Intent column not found", e);
                    }
                }
            } finally {
                if (c != null) c.close();
            }
            return intent;
        }

        
                public static Uri add(ContentResolver cr,
                                           Intent intent,
                                           String title,
                                           String folder,
                                           char shortcut,
                                           int ordering) {
            if (shortcut != 0) {
                cr.delete(CONTENT_URI, sShortcutSelection,
                        new String[] { String.valueOf((int) shortcut) });
            }
            ContentValues values = new ContentValues();
            if (title != null) values.put(TITLE, title);
            if (folder != null) values.put(FOLDER, folder);
            values.put(INTENT, intent.toUri(0));
            if (shortcut != 0) values.put(SHORTCUT, (int) shortcut);
            values.put(ORDERING, ordering);
            return cr.insert(CONTENT_URI, values);
        }

        
                public static CharSequence getLabelForFolder(Resources r, String folder) {
            return folder;
        }

        
                public static CharSequence getTitle(Context context, Cursor cursor) {
            int titleColumn = cursor.getColumnIndex(TITLE);
            int intentColumn = cursor.getColumnIndex(INTENT);
            if (titleColumn == -1 || intentColumn == -1) {
                throw new IllegalArgumentException(
                        "The cursor must contain the TITLE and INTENT columns.");
            }
            String title = cursor.getString(titleColumn);
            if (!TextUtils.isEmpty(title)) {
                return title;
            }
            String intentUri = cursor.getString(intentColumn);
            if (TextUtils.isEmpty(intentUri)) {
                return "";
            }
            Intent intent;
            try {
                intent = Intent.parseUri(intentUri, 0);
            } catch (URISyntaxException e) {
                return "";
            }
            PackageManager packageManager = context.getPackageManager();
            ResolveInfo info = packageManager.resolveActivity(intent, 0);
            return info != null ? info.loadLabel(packageManager) : "";
        }

        
        private static final String TAG = "Bookmarks";
        public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/bookmarks");
        public static final String ID = "_id";
        public static final String TITLE = "title";
        public static final String FOLDER = "folder";
        public static final String INTENT = "intent";
        public static final String SHORTCUT = "shortcut";
        public static final String ORDERING = "ordering";
        private static final String[] sIntentProjection = { INTENT };
        private static final String[] sShortcutProjection = { ID, SHORTCUT };
        private static final String sShortcutSelection = SHORTCUT + "=?";
    }


    
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_SETTINGS = "android.settings.SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_APN_SETTINGS = "android.settings.APN_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_LOCATION_SOURCE_SETTINGS =
            "android.settings.LOCATION_SOURCE_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_WIRELESS_SETTINGS =
            "android.settings.WIRELESS_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_AIRPLANE_MODE_SETTINGS =
            "android.settings.AIRPLANE_MODE_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_ACCESSIBILITY_SETTINGS =
            "android.settings.ACCESSIBILITY_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_SECURITY_SETTINGS =
            "android.settings.SECURITY_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_PRIVACY_SETTINGS =
            "android.settings.PRIVACY_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_WIFI_SETTINGS =
            "android.settings.WIFI_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_WIFI_IP_SETTINGS =
            "android.settings.WIFI_IP_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_BLUETOOTH_SETTINGS =
            "android.settings.BLUETOOTH_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_DATE_SETTINGS =
            "android.settings.DATE_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_SOUND_SETTINGS =
            "android.settings.SOUND_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_DISPLAY_SETTINGS =
            "android.settings.DISPLAY_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_LOCALE_SETTINGS =
            "android.settings.LOCALE_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_INPUT_METHOD_SETTINGS =
            "android.settings.INPUT_METHOD_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_INPUT_METHOD_SUBTYPE_SETTINGS =
            "android.settings.INPUT_METHOD_SUBTYPE_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_SHOW_INPUT_METHOD_PICKER =
            "android.settings.SHOW_INPUT_METHOD_PICKER";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_USER_DICTIONARY_SETTINGS =
            "android.settings.USER_DICTIONARY_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_USER_DICTIONARY_INSERT =
            "com.android.settings.USER_DICTIONARY_INSERT";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_APPLICATION_SETTINGS =
            "android.settings.APPLICATION_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_APPLICATION_DEVELOPMENT_SETTINGS =
            "android.settings.APPLICATION_DEVELOPMENT_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_QUICK_LAUNCH_SETTINGS =
            "android.settings.QUICK_LAUNCH_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_MANAGE_APPLICATIONS_SETTINGS =
            "android.settings.MANAGE_APPLICATIONS_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS =
            "android.settings.MANAGE_ALL_APPLICATIONS_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_APPLICATION_DETAILS_SETTINGS =
            "android.settings.APPLICATION_DETAILS_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_SYSTEM_UPDATE_SETTINGS =
            "android.settings.SYSTEM_UPDATE_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_SYNC_SETTINGS =
            "android.settings.SYNC_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_ADD_ACCOUNT =
            "android.settings.ADD_ACCOUNT_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_NETWORK_OPERATOR_SETTINGS =
            "android.settings.NETWORK_OPERATOR_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_DATA_ROAMING_SETTINGS =
            "android.settings.DATA_ROAMING_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_INTERNAL_STORAGE_SETTINGS =
            "android.settings.INTERNAL_STORAGE_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_MEMORY_CARD_SETTINGS =
            "android.settings.MEMORY_CARD_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_SEARCH_SETTINGS =
        "android.search.action.SEARCH_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_DEVICE_INFO_SETTINGS =
        "android.settings.DEVICE_INFO_SETTINGS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_NFCSHARING_SETTINGS =
        "android.settings.NFCSHARING_SETTINGS";
    public static final String CALL_METHOD_GET_SYSTEM = "GET_system";
    public static final String CALL_METHOD_GET_SECURE = "GET_secure";
    public static final String EXTRA_AUTHORITIES =
            "authorities";
    public static final String EXTRA_INPUT_METHOD_ID = "input_method_id";
    private static final String JID_RESOURCE_PREFIX = "android";
    public static final String AUTHORITY = "settings";
    private static final String TAG = "Settings";
    private static final boolean LOCAL_LOGV = false || false;
}

