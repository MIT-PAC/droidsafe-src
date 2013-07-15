package android.provider;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.607 -0400", hash_original_method = "D105991E634C8DCAFDA0F30054C63045", hash_generated_method = "D105991E634C8DCAFDA0F30054C63045")
    public Settings ()
    {
        //Synthesized constructor
    }


        public static String getGTalkDeviceId(long androidId) {
        return "android-" + Long.toHexString(androidId);
    }

    
    public static class SettingNotFoundException extends AndroidException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.608 -0400", hash_original_method = "9D3DA3FD01BD65E9C8D44BD33E232128", hash_generated_method = "200240BBB63B98FF89E2DBCEE5936BE5")
        public  SettingNotFoundException(String msg) {
            super(msg);
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    public static class NameValueTable implements BaseColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.608 -0400", hash_original_method = "FA7615754860C9050FE125371ADC3B8B", hash_generated_method = "FA7615754860C9050FE125371ADC3B8B")
        public NameValueTable ()
        {
            //Synthesized constructor
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.608 -0400", hash_original_field = "DF93ACD53BD3A496BAA30564AD0C5925", hash_generated_field = "8F5B94AE17AA8887EB81EF0FD5591FF7")

        public static final String NAME = "name";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.609 -0400", hash_original_field = "E2F29D4CBE5FD8C9FB6E536F08014752", hash_generated_field = "5D8DAB0D387706C30A46713A8E60D5A3")

        public static final String VALUE = "value";
    }


    
    private static class NameValueCache {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.609 -0400", hash_original_field = "B1CE7A02754C7E905BE98D8E81FE4A56", hash_generated_field = "8053655979FC96B88F0F0DB849815BA8")

        private String mVersionSystemProperty;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.609 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

        private Uri mUri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.609 -0400", hash_original_field = "0F9DB8A5619F05F34223E5F693E6415C", hash_generated_field = "DB6F166C847159AF638BD64416B47EB4")

        private final HashMap<String, String> mValues = new HashMap<String, String>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.609 -0400", hash_original_field = "A8D5D0719E7D114E70121F06518D333E", hash_generated_field = "FCE810A42FA561E1E083AE063834BBA4")

        private long mValuesVersion = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.609 -0400", hash_original_field = "201849063975B48329829F1434F01C5E", hash_generated_field = "C581E09B51E89883758FAC86E652180C")

        private IContentProvider mContentProvider = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.609 -0400", hash_original_field = "16A1B470A7CF4F1D7E6CA0530068E38F", hash_generated_field = "3818FF29E7710B79D59A574EA0ABAAA7")

        private String mCallCommand;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.610 -0400", hash_original_method = "AA2EC60B6F4EA71E8A16119EB161E070", hash_generated_method = "E3A8B4C7105DE18E39D460473A77A79A")
        public  NameValueCache(String versionSystemProperty, Uri uri, String callCommand) {
            mVersionSystemProperty = versionSystemProperty;
            mUri = uri;
            mCallCommand = callCommand;
            // ---------- Original Method ----------
            //mVersionSystemProperty = versionSystemProperty;
            //mUri = uri;
            //mCallCommand = callCommand;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.611 -0400", hash_original_method = "30813ECB8D9A0346E7379ADA0BD790C8", hash_generated_method = "C6A0FF6DE079B50FA7207E5530F95F6D")
        public String getString(ContentResolver cr, String name) {
            addTaint(name.getTaint());
            addTaint(cr.getTaint());
            long newValuesVersion = SystemProperties.getLong(mVersionSystemProperty, 0);
            synchronized
(this)            {
    if(mValuesVersion != newValuesVersion)                
                {
    if(LOCAL_LOGV)                    
                    {
                    } //End block
                    mValues.clear();
                    mValuesVersion = newValuesVersion;
                } //End block
    if(mValues.containsKey(name))                
                {
String varC353D578E7CD7DCB6BFA8853817FDDD5_183659554 =                     mValues.get(name);
                    varC353D578E7CD7DCB6BFA8853817FDDD5_183659554.addTaint(taint);
                    return varC353D578E7CD7DCB6BFA8853817FDDD5_183659554;
                } //End block
            } //End block
            IContentProvider cp = null;
            synchronized
(this)            {
                cp = mContentProvider;
    if(cp == null)                
                {
                    cp = mContentProvider = cr.acquireProvider(mUri.getAuthority());
                } //End block
            } //End block
    if(mCallCommand != null)            
            {
                try 
                {
                    Bundle b = cp.call(mCallCommand, name, null);
    if(b != null)                    
                    {
                        String value = b.getPairValue();
                        synchronized
(this)                        {
                            mValues.put(name, value);
                        } //End block
String varAF280DA2BC37D8BE783D8499160168DE_2057455075 =                         value;
                        varAF280DA2BC37D8BE783D8499160168DE_2057455075.addTaint(taint);
                        return varAF280DA2BC37D8BE783D8499160168DE_2057455075;
                    } //End block
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
            Cursor c = null;
            try 
            {
                c = cp.query(mUri, SELECT_VALUE, NAME_EQ_PLACEHOLDER,
                             new String[]{name}, null);
    if(c == null)                
                {
String var540C13E9E156B687226421B24F2DF178_1865044646 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1865044646.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1865044646;
                } //End block
                String value = c.moveToNext() ? c.getString(0) : null;
                synchronized
(this)                {
                    mValues.put(name, value);
                } //End block
    if(LOCAL_LOGV)                
                {
                } //End block
String varAF280DA2BC37D8BE783D8499160168DE_1576602058 =                 value;
                varAF280DA2BC37D8BE783D8499160168DE_1576602058.addTaint(taint);
                return varAF280DA2BC37D8BE783D8499160168DE_1576602058;
            } //End block
            catch (RemoteException e)
            {
String var540C13E9E156B687226421B24F2DF178_354695256 =                 null;
                var540C13E9E156B687226421B24F2DF178_354695256.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_354695256;
            } //End block
            finally 
            {
    if(c != null)                
                c.close();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.611 -0400", hash_original_field = "6F3B96EEA54AF4CE7066D98700ADD10B", hash_generated_field = "23E47445004801DA0364F31D1E83BC51")

        private static final String[] SELECT_VALUE = new String[] { Settings.NameValueTable.VALUE };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.611 -0400", hash_original_field = "284444E1AC67A8711EA033FD17B05ECD", hash_generated_field = "26B04325FB348644FBE33A5DD660F1BA")

        private static final String NAME_EQ_PLACEHOLDER = "name=?";
    }


    
    public static final class System extends NameValueTable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.614 -0400", hash_original_method = "FCC05FCD4F95F74464895D80CA2398E6", hash_generated_method = "FCC05FCD4F95F74464895D80CA2398E6")
        public System ()
        {
            //Synthesized constructor
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.618 -0400", hash_original_field = "053F70E6F5BD61381472796CA0BDD66A", hash_generated_field = "1F2456A83E929BCA3BB4607D01A844B2")

        public static final String SYS_PROP_SETTING_VERSION = "sys.settings_system_version";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.618 -0400", hash_original_field = "B98039EA853AA9A1AF1831BA37B04DA2", hash_generated_field = "1FB09179C87042F649D2E6D9B8084B29")

        private static NameValueCache sNameValueCache = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.618 -0400", hash_original_field = "83B0238E7018F3F5F168F9DC6D3E468A", hash_generated_field = "A0CAC6ABE4414AB6B5026A67B764DC5F")

        private static HashSet<String> MOVED_TO_SECURE;
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
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.618 -0400", hash_original_field = "BA5D1F6C48E67D0E67973035DB8BB4FA", hash_generated_field = "73522F6CDB248227CBD6A2EE71CA3762")

        public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/system");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.618 -0400", hash_original_field = "5FA2A8999E491158D8DCC5B6205F37DA", hash_generated_field = "3B2E2B5800656B6A77725DD672C46B9D")

        public static final String STAY_ON_WHILE_PLUGGED_IN = "stay_on_while_plugged_in";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.618 -0400", hash_original_field = "DC36BDAAD57ACE5C6AE91E42B6E91BA2", hash_generated_field = "D21F2265B6B377D85FEA61AA7A6C9A91")

        public static final String END_BUTTON_BEHAVIOR = "end_button_behavior";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.618 -0400", hash_original_field = "1F02CF77F4A4DD73A4D0B40F15CB1348", hash_generated_field = "33485B813338885E3EF315E2C1B712E1")

        public static final int END_BUTTON_BEHAVIOR_HOME = 0x1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.618 -0400", hash_original_field = "BE196F6DE372BD80426E3FA35B9AB75A", hash_generated_field = "6D08D9D291225EF80FC4BA876AA9F0C3")

        public static final int END_BUTTON_BEHAVIOR_SLEEP = 0x2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.618 -0400", hash_original_field = "F1A9B3D439076DC4F8EBF00A848E7784", hash_generated_field = "C289E4BFD362BFA530F26A20E383DB7E")

        public static final int END_BUTTON_BEHAVIOR_DEFAULT = END_BUTTON_BEHAVIOR_SLEEP;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.618 -0400", hash_original_field = "2DBA0EAD8423FCC5A633488EAA3C2018", hash_generated_field = "DCFE63C3879CBA756C65B4B69ECD68F4")

        public static final String ADVANCED_SETTINGS = "advanced_settings";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.618 -0400", hash_original_field = "2A169EB37DEF09027C6483122193F8E1", hash_generated_field = "019DCD45BE65B913274B5AA692F40655")

        public static final int ADVANCED_SETTINGS_DEFAULT = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.618 -0400", hash_original_field = "D0C4F072ADFD8EC308ECED49E6E7BAF4", hash_generated_field = "55FCC9341703FB893FA281A80454844D")

        public static final String AIRPLANE_MODE_ON = "airplane_mode_on";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.618 -0400", hash_original_field = "481E9D82ADE180C1C5CFC0E9D629FC00", hash_generated_field = "CBF14E37A49742B1762CB93C99D1D050")

        public static final String RADIO_BLUETOOTH = "bluetooth";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.618 -0400", hash_original_field = "9436D7E600B0EFC99B168A61D92E50B1", hash_generated_field = "5DA0211CD66CB5F1D939CC5760E4080E")

        public static final String RADIO_WIFI = "wifi";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.618 -0400", hash_original_field = "A7448F64F1B6E9D972CCAB3B3787DE65", hash_generated_field = "E55D30F8015A4EDC205B488E73E9C3C7")

        public static final String RADIO_WIMAX = "wimax";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.618 -0400", hash_original_field = "10CCD16C0163C2F6087C3E440D058AE2", hash_generated_field = "F38D5CB83BC4823F9E7AAA66A6A55089")

        public static final String RADIO_CELL = "cell";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.618 -0400", hash_original_field = "79EBF048480595C0C7AA54E2BE91DD09", hash_generated_field = "338A37CDF684AB581C516725556BEE8A")

        public static final String RADIO_NFC = "nfc";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.618 -0400", hash_original_field = "EEDA4CFE1AE2F38171E6DDE8EDF9CD99", hash_generated_field = "1A2C056412A23950C9E33244B1E272D9")

        public static final String AIRPLANE_MODE_RADIOS = "airplane_mode_radios";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.618 -0400", hash_original_field = "FA9A5A965EC24B9BD8D0B6ED4EA5D198", hash_generated_field = "3EC8431B0EF96E87AD69A440406FE4A8")

        public static final String AIRPLANE_MODE_TOGGLEABLE_RADIOS = "airplane_mode_toggleable_radios";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.619 -0400", hash_original_field = "996F29ABD720DB70025EBF7F2E8684ED", hash_generated_field = "9BBC5B7E7110FE2989D8236E94AB1FB4")

        public static final String WIFI_SLEEP_POLICY = "wifi_sleep_policy";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.619 -0400", hash_original_field = "A10AA1C92762FDD52A4E8DD5FF345B7F", hash_generated_field = "9398666E4F04883DE0E2BA9E9B23A686")

        public static final int WIFI_SLEEP_POLICY_DEFAULT = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.619 -0400", hash_original_field = "A1ED4B54A871083A3029DBD1B4B3A6F4", hash_generated_field = "D601B0CE6A4CF9504DCA251B695BCB5D")

        public static final int WIFI_SLEEP_POLICY_NEVER_WHILE_PLUGGED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.619 -0400", hash_original_field = "92AB5E708DAB19F5BD8916EF63D224F7", hash_generated_field = "5160D2E233690D463855E47C49032C56")

        public static final int WIFI_SLEEP_POLICY_NEVER = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.619 -0400", hash_original_field = "FDCFCEB09C11570118C41E0812351EC7", hash_generated_field = "D52120E42989209D07C112D9EA104295")

        public static final String WIFI_USE_STATIC_IP = "wifi_use_static_ip";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.619 -0400", hash_original_field = "5379C9C863ADAB5FBDD481275E03FD33", hash_generated_field = "1E4EFCD82854CCE99527175CC3854DF6")

        public static final String WIFI_STATIC_IP = "wifi_static_ip";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.619 -0400", hash_original_field = "26B97648DA05813666A0BD4418DCD513", hash_generated_field = "FECB1DD251347D01F55DBAF2ADA7529A")

        public static final String WIFI_STATIC_GATEWAY = "wifi_static_gateway";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.619 -0400", hash_original_field = "69C2D4DF9A11FABCC53DFAA76542E752", hash_generated_field = "FBF052DF0AC4A30D8CF16D40480FAEEB")

        public static final String WIFI_STATIC_NETMASK = "wifi_static_netmask";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.619 -0400", hash_original_field = "454E071D1479C0FC994CE2E0771C85EA", hash_generated_field = "7272D86506529066EF782D81CBCA730E")

        public static final String WIFI_STATIC_DNS1 = "wifi_static_dns1";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.619 -0400", hash_original_field = "A5D827D5C04D44338BACEE5937466694", hash_generated_field = "57F3E3F0D37260047223CE06C4BEDA7D")

        public static final String WIFI_STATIC_DNS2 = "wifi_static_dns2";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.619 -0400", hash_original_field = "DE6FF1BF57C9E086A6E77173A9D7A0C4", hash_generated_field = "6AEE36383AD19BB8C2CFB7DB3382DE3A")

        public static final String BLUETOOTH_DISCOVERABILITY =
            "bluetooth_discoverability";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.619 -0400", hash_original_field = "F4C27EC0BAD3F210F1534F1EC0C04B1A", hash_generated_field = "A02A0ACCF4F67A363B9410B52CAC2860")

        public static final String BLUETOOTH_DISCOVERABILITY_TIMEOUT =
            "bluetooth_discoverability_timeout";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.619 -0400", hash_original_field = "E9BE01FD2DCB7502CDB8D8115F3E42D2", hash_generated_field = "F30D5A0D770F1446E17D6B9D5CF508C6")

        @Deprecated
        public static final String LOCK_PATTERN_ENABLED = Secure.LOCK_PATTERN_ENABLED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.619 -0400", hash_original_field = "62FEBDE12BC61330FB1672BCB8E93E37", hash_generated_field = "AFE220E0B57AC087ECB648638461E9AD")

        @Deprecated
        public static final String LOCK_PATTERN_VISIBLE = "lock_pattern_visible_pattern";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.619 -0400", hash_original_field = "D29C204677A4C86A389FA02C8848E0EE", hash_generated_field = "AAF77AB120C25C0B3F1F1757970361DD")

        @Deprecated
        public static final String LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED =
            "lock_pattern_tactile_feedback_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.619 -0400", hash_original_field = "10D403AB0BD867C8B99675B99F3B7C4A", hash_generated_field = "C640615D90700F02DD2DA4540447D2AB")

        public static final String NEXT_ALARM_FORMATTED = "next_alarm_formatted";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.619 -0400", hash_original_field = "D7DED25634C6A924ABBB65BD678B8306", hash_generated_field = "B84405F90D1542D338C2CB78CC887DF4")

        public static final String FONT_SCALE = "font_scale";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.619 -0400", hash_original_field = "6B40A68882F240C56840963CD2A3312B", hash_generated_field = "1FDB5EBD482132808AEC2C0FCF91119B")

        public static final String DEBUG_APP = "debug_app";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.619 -0400", hash_original_field = "5AE920D27C1052577BF9B1ECB556F546", hash_generated_field = "45DB8334ACF69D8BDC0273CC28951085")

        public static final String WAIT_FOR_DEBUGGER = "wait_for_debugger";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.620 -0400", hash_original_field = "6F6F2C17ED0D088D8C611C3975C92BDF", hash_generated_field = "21DD68ACF771DA87FB12656C7D9ECEAE")

        public static final String DIM_SCREEN = "dim_screen";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.620 -0400", hash_original_field = "CBB664CD64A832BAC49E26A55EA95954", hash_generated_field = "F67F87D993A243B0D391C3B0D02FD748")

        public static final String SCREEN_OFF_TIMEOUT = "screen_off_timeout";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.620 -0400", hash_original_field = "6767CA604F18262B806514C4FC5FA80D", hash_generated_field = "1F164A6095C276D0D8923DF60512CCA0")

        public static final String COMPATIBILITY_MODE = "compatibility_mode";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.620 -0400", hash_original_field = "B856F71C20AB6A4E8E113EAB75C64E2A", hash_generated_field = "CE544C9E0C810697AC7204FCED554A71")

        public static final String SCREEN_BRIGHTNESS = "screen_brightness";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.620 -0400", hash_original_field = "2841F7692100B266083E1E256E887270", hash_generated_field = "69C67F5DC39ABF90E401738745A78A04")

        public static final String SCREEN_BRIGHTNESS_MODE = "screen_brightness_mode";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.620 -0400", hash_original_field = "7AC8BF0B419AE69DE82F19F87C1D1A24", hash_generated_field = "18509F5406C47F14229896FAD98E0FE4")

        public static final int SCREEN_BRIGHTNESS_MODE_MANUAL = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.620 -0400", hash_original_field = "A42927DF510D6AB6EA7B1D6AA466AC4A", hash_generated_field = "4D1C057868E93087553CD0CBA218E4B0")

        public static final int SCREEN_BRIGHTNESS_MODE_AUTOMATIC = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.620 -0400", hash_original_field = "FC37DE1536695F55AA1CAE7A5E58519E", hash_generated_field = "B29ACF97250EE696921D7D0F0E55355A")

        public static final String SHOW_PROCESSES = "show_processes";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.620 -0400", hash_original_field = "027B1CD10A9698FD6DD630995A18D332", hash_generated_field = "2707C925F43197F607FC371112C84589")

        public static final String ALWAYS_FINISH_ACTIVITIES =
                "always_finish_activities";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.620 -0400", hash_original_field = "C3464B30ED78A18B45B63C3A583CB732", hash_generated_field = "697A87B302F7C66E2B6B04A5DA9D7B26")

        public static final String MODE_RINGER = "mode_ringer";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.620 -0400", hash_original_field = "E7507E5F67A986D1EA8D197DD8F5F7FC", hash_generated_field = "CCA369CA013A98B69BCBBB78922ADAF4")

        public static final String MODE_RINGER_STREAMS_AFFECTED = "mode_ringer_streams_affected";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.620 -0400", hash_original_field = "B26800351FDA4EC0696ED220CD0AC2A0", hash_generated_field = "1B76396DE9FFA2C1F64A1ACE233E9A4F")

        public static final String MUTE_STREAMS_AFFECTED = "mute_streams_affected";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.621 -0400", hash_original_field = "BEC37A6A6605C6F399AC1E9FD3D081DD", hash_generated_field = "8F1B8BD1575869A8CADF68D51B171CC2")

        public static final String VIBRATE_ON = "vibrate_on";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.621 -0400", hash_original_field = "642570B4C03E41F9B16EE2771FCAA984", hash_generated_field = "1362364C056D246C2E8E42AA5C45BB29")

        public static final String VOLUME_RING = "volume_ring";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.621 -0400", hash_original_field = "B996ECB045AA95212153DE0F4A27B310", hash_generated_field = "EED8CAB1845CC1C2509B015FDC6BEC23")

        public static final String VOLUME_SYSTEM = "volume_system";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.621 -0400", hash_original_field = "3E03054765F05E76C7991C947691DB06", hash_generated_field = "E0EA9784F9797B7C50DF8CA47CE0112F")

        public static final String VOLUME_VOICE = "volume_voice";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.621 -0400", hash_original_field = "BC2768F35626EE54DD5AAFBF2335626E", hash_generated_field = "1DE966C9806D54EEC941F957598EC0AE")

        public static final String VOLUME_MUSIC = "volume_music";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.621 -0400", hash_original_field = "97557D5200AB2E84D2C31B3E6FCD121E", hash_generated_field = "E722A903F81918154C66CD7BD30730E9")

        public static final String VOLUME_ALARM = "volume_alarm";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.621 -0400", hash_original_field = "CA7A01442AB751750F421A66A7C345D7", hash_generated_field = "D78E22DA48A62C766FB2ECB47A0B003E")

        public static final String VOLUME_NOTIFICATION = "volume_notification";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.621 -0400", hash_original_field = "28B38CA038FA9B000C5DDA0089B1BF0F", hash_generated_field = "C2B31D6FAA5CF59AB74C4EDE2CC028E3")

        public static final String VOLUME_BLUETOOTH_SCO = "volume_bluetooth_sco";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.621 -0400", hash_original_field = "A86F2BDCEB81ADA8E6A9502EA4779D1B", hash_generated_field = "4AF062B7F6928290D96C0F960388552A")

        @Deprecated
        public static final String NOTIFICATIONS_USE_RING_VOLUME =
            "notifications_use_ring_volume";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.621 -0400", hash_original_field = "BA66782B3C38965099FD51827B92EC9A", hash_generated_field = "3C213BB0E7B1489277A1BC3C5C3B8C50")

        public static final String VIBRATE_IN_SILENT = "vibrate_in_silent";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.621 -0400", hash_original_field = "1418C5A0A9FC70AD6B9464BA24724A17", hash_generated_field = "7FD1FFC876A892626BE17FA0121ABC35")

        public static final String[] VOLUME_SETTINGS = {
            VOLUME_VOICE, VOLUME_SYSTEM, VOLUME_RING, VOLUME_MUSIC,
            VOLUME_ALARM, VOLUME_NOTIFICATION, VOLUME_BLUETOOTH_SCO
        };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.621 -0400", hash_original_field = "92AEAAEA3D658051D7F66345178F388D", hash_generated_field = "A875CBA60C614DB5A2ACF4410B47ED48")

        public static final String APPEND_FOR_LAST_AUDIBLE = "_last_audible";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.621 -0400", hash_original_field = "3F0D77E1B62A135562A1A0DBD7488734", hash_generated_field = "B4AEB4F09B891C9CD1A27425B662A163")

        public static final String RINGTONE = "ringtone";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.622 -0400", hash_original_field = "0A47E9B639A8A373AFD1341A8B3235DC", hash_generated_field = "A8BB7CFDF81BA379E1C7D108199ADFFD")

        public static final Uri DEFAULT_RINGTONE_URI = getUriFor(RINGTONE);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.622 -0400", hash_original_field = "44E0F277BCB56EDDB93D9D8B2388F004", hash_generated_field = "AF51286C7034DC1CA7310637E31C750C")

        public static final String NOTIFICATION_SOUND = "notification_sound";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.622 -0400", hash_original_field = "24A486508CC26831A88B39102CC15450", hash_generated_field = "9199AB0B8E91A11AAD0346F35198C71A")

        public static final Uri DEFAULT_NOTIFICATION_URI = getUriFor(NOTIFICATION_SOUND);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.622 -0400", hash_original_field = "E8EC5DDA14BC742EE1C6E65D2244D7D2", hash_generated_field = "6C2249FC5A25A16B22A7668926A26E88")

        public static final String ALARM_ALERT = "alarm_alert";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.622 -0400", hash_original_field = "77F6B6D6D1F49C3BC93AD9B90311D42E", hash_generated_field = "E31F51BB248AADF4730DC0D2E08FAAEB")

        public static final Uri DEFAULT_ALARM_ALERT_URI = getUriFor(ALARM_ALERT);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.622 -0400", hash_original_field = "C736D3D8902ABE40415724C493E6F44C", hash_generated_field = "35A7CD5A1839B7D8C1DBB044A624DE37")

        public static final String MEDIA_BUTTON_RECEIVER = "media_button_receiver";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.622 -0400", hash_original_field = "D82B9DE86441A46B268510BA0F3E7AE4", hash_generated_field = "D82B22C42E5D8BE4795122310CD7ED28")

        public static final String TEXT_AUTO_REPLACE = "auto_replace";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.622 -0400", hash_original_field = "2BA6A0437DE6E218A70581208ABB1B39", hash_generated_field = "9788CD283DFEAEB4942605075DDDF378")

        public static final String TEXT_AUTO_CAPS = "auto_caps";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.622 -0400", hash_original_field = "094B0D69C7D215CBB84C25077D8109BC", hash_generated_field = "43A4C86E305A5C2124FD2FFD9732F39B")

        public static final String TEXT_AUTO_PUNCTUATE = "auto_punctuate";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.622 -0400", hash_original_field = "72E1E6DD1765C95B4B4A37D3A673C95F", hash_generated_field = "4F1F16DE8368FD02C00EFC0E9B76FE8D")

        public static final String TEXT_SHOW_PASSWORD = "show_password";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.622 -0400", hash_original_field = "01C1767C62D565F067A0AB0F8568762C", hash_generated_field = "334EEAA225578A6C1A6482FC1D36E631")

        public static final String SHOW_GTALK_SERVICE_STATUS =
                "SHOW_GTALK_SERVICE_STATUS";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.622 -0400", hash_original_field = "B54D02E8DAF8E345490044B70781B008", hash_generated_field = "275DAC983B63898C2E3B05CE4B27AEEC")

        public static final String WALLPAPER_ACTIVITY = "wallpaper_activity";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.622 -0400", hash_original_field = "2EADE8B61FC347628A478517CCDFFB13", hash_generated_field = "E39CF0E244C018A254795F9D4E92EE65")

        public static final String AUTO_TIME = "auto_time";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.623 -0400", hash_original_field = "2E988D222E527B46ABC780C635FD61CB", hash_generated_field = "B4F7710466D6D99F54C519D0E089EAAB")

        public static final String AUTO_TIME_ZONE = "auto_time_zone";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.623 -0400", hash_original_field = "56635E29178705B9962BB65B43C9FD5B", hash_generated_field = "E3D405036DB50DFB5BFA3DEA26F62E8E")

        public static final String TIME_12_24 = "time_12_24";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.623 -0400", hash_original_field = "C3C57F541AD5F696CCACA1341F3B5980", hash_generated_field = "EAE805229AAAB849CC5ED1DB337B57E1")

        public static final String DATE_FORMAT = "date_format";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.623 -0400", hash_original_field = "DAC7BDBCD6B0F794941CC257337BBEB1", hash_generated_field = "C532E6AB48FB115C2F70980B54E148FC")

        public static final String SETUP_WIZARD_HAS_RUN = "setup_wizard_has_run";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.623 -0400", hash_original_field = "379D315A9DF9D46B3ADC90AD5E125746", hash_generated_field = "965EB588E008DCD4109E38F001F2DD98")

        public static final String WINDOW_ANIMATION_SCALE = "window_animation_scale";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.623 -0400", hash_original_field = "C87DF2F1DE5EFD8262F92A5C50DC610B", hash_generated_field = "B7BE6330A9FC454CF7AEFBBC6CDA8D8F")

        public static final String TRANSITION_ANIMATION_SCALE = "transition_animation_scale";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.623 -0400", hash_original_field = "F4CF20BF406258A6D0F3E18645C8AD66", hash_generated_field = "58D1E5725821B6F62A3AB3FA8F3F2119")

        public static final String FANCY_IME_ANIMATIONS = "fancy_ime_animations";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.623 -0400", hash_original_field = "D27AA7705EE8C93D318A9727F4339237", hash_generated_field = "796406544C593ABF78D1D0B68837CC1A")

        public static final String ACCELEROMETER_ROTATION = "accelerometer_rotation";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.623 -0400", hash_original_field = "4D2C499FD51193A705A1CE2ED45D12EA", hash_generated_field = "BF9E8128DB5F902333F910DDB3B51E11")

        public static final String USER_ROTATION = "user_rotation";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.623 -0400", hash_original_field = "E7DC5C4B2E4F444C8A1B7BF16554884A", hash_generated_field = "515D9C36110F1E78727EB3509BDD30F1")

        public static final String DTMF_TONE_WHEN_DIALING = "dtmf_tone";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.623 -0400", hash_original_field = "92542C130046AC514BC788CB97D52E6F", hash_generated_field = "EDD874E2569CF564C9BDB60196A6FACE")

        public static final String DTMF_TONE_TYPE_WHEN_DIALING = "dtmf_tone_type";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.623 -0400", hash_original_field = "5370DB51D6C8C141D563949D88C2D218", hash_generated_field = "CCEA6D5F67FAAC4278F9567DD9326A34")

        public static final String EMERGENCY_TONE = "emergency_tone";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.623 -0400", hash_original_field = "73AC7DD850CAB0D6CE9FC185F2A7ADCF", hash_generated_field = "2C1251730E3D408EC520BD06F166F7A6")

        public static final String CALL_AUTO_RETRY = "call_auto_retry";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.624 -0400", hash_original_field = "C74885AEECE2555D1A4F5502D9D80D97", hash_generated_field = "AD43FDDF5B448DB6AA9B6D199DBC847A")

        public static final String HEARING_AID = "hearing_aid";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.624 -0400", hash_original_field = "0C4F4BF5E41DE72E1EDF5238304D6D16", hash_generated_field = "032865E4B4AC984A1F7B2029ACCB1205")

        public static final String TTY_MODE = "tty_mode";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.624 -0400", hash_original_field = "933F2109CCACC4D117D92C4B0AFAFBC9", hash_generated_field = "CFEFED556580674602B9ADF1DCFBB414")

        public static final String SOUND_EFFECTS_ENABLED = "sound_effects_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.624 -0400", hash_original_field = "19CDB6856977C91875E23A96725C068A", hash_generated_field = "6871D81DAA2B1FB3C71F0EAB219E9FE9")

        public static final String HAPTIC_FEEDBACK_ENABLED = "haptic_feedback_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.624 -0400", hash_original_field = "8561E15F4638819CB4D341677171C440", hash_generated_field = "D35E17F6DD33A76EDBA58FF1A62D1D35")

        @Deprecated
        public static final String SHOW_WEB_SUGGESTIONS = "show_web_suggestions";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.624 -0400", hash_original_field = "78159955EF7157C8DF26E1996D427882", hash_generated_field = "38A84262B3C034871EC44AAC84C5C42C")

        public static final String NOTIFICATION_LIGHT_PULSE = "notification_light_pulse";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.624 -0400", hash_original_field = "EB6E04268DAD67DD16E55F0D42AFDB3A", hash_generated_field = "832AB6C8EEA7F531FC912360D588124C")

        public static final String POINTER_LOCATION = "pointer_location";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.624 -0400", hash_original_field = "C0F9C16691EF4DA0B4F66AFA7E8F6A6A", hash_generated_field = "BAC322C0405CFBC41F9E81B438CCD8FC")

        public static final String SHOW_TOUCHES = "show_touches";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.624 -0400", hash_original_field = "6C6A8278FBEE45CEB6F655E71E055570", hash_generated_field = "BE99F9E2CBEABE6F49AC4E6F1CB2D423")

        public static final String WINDOW_ORIENTATION_LISTENER_LOG =
                "window_orientation_listener_log";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.624 -0400", hash_original_field = "DDD52E25D5D6F63729F26BF96464BBFC", hash_generated_field = "E805AECE657E431A64EBF81DC4423056")

        public static final String POWER_SOUNDS_ENABLED = "power_sounds_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.624 -0400", hash_original_field = "C7C83B047CE2FD014B436ADC6ABFD596", hash_generated_field = "889562242653E6291B87AF97B8C19DF6")

        public static final String DOCK_SOUNDS_ENABLED = "dock_sounds_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.624 -0400", hash_original_field = "729578C6283090585B13E2DE0184DA7E", hash_generated_field = "36FBE565E204CB8FB57F85C0D58F661A")

        public static final String LOCKSCREEN_SOUNDS_ENABLED = "lockscreen_sounds_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.624 -0400", hash_original_field = "87E4E73CE14E727770ABE251D8F9EA9B", hash_generated_field = "2B4E7FEFDD7371085EE84BA75CD7C2F8")

        public static final String LOW_BATTERY_SOUND = "low_battery_sound";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.625 -0400", hash_original_field = "1D5F1468E040F4FE1860681BC56AF94B", hash_generated_field = "80ECE9F8420D23D29962B5EFDFB38034")

        public static final String DESK_DOCK_SOUND = "desk_dock_sound";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.625 -0400", hash_original_field = "C051ABCCFE9E4C3E067044A81D7B705B", hash_generated_field = "92BE150247669CE4FAB596BBB85654C4")

        public static final String DESK_UNDOCK_SOUND = "desk_undock_sound";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.625 -0400", hash_original_field = "33F8B38975FA57EB14E03B7614DF55EC", hash_generated_field = "54C3CF9DFEAD69AFDA16F76FC712CCBA")

        public static final String CAR_DOCK_SOUND = "car_dock_sound";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.625 -0400", hash_original_field = "23B648FCC2CEB5B289CCB6E091531CAD", hash_generated_field = "8EFAFA8B52DC8A5913610F73524B1349")

        public static final String CAR_UNDOCK_SOUND = "car_undock_sound";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.625 -0400", hash_original_field = "BE9B0F6A4646ED9CC800306B726F2C00", hash_generated_field = "59EF24D009976CB270ACA55DAB87EFB2")

        public static final String LOCK_SOUND = "lock_sound";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.625 -0400", hash_original_field = "7B6BE209F9FA2FC61CA023CDB6CC248C", hash_generated_field = "D8E4D2E810E643DBCBA6FD530A4DA764")

        public static final String UNLOCK_SOUND = "unlock_sound";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.625 -0400", hash_original_field = "F7449E2F5F9C3F911E45E605977E0420", hash_generated_field = "438FB5B96B314E9DC89AC19DB30A6176")

        public static final String SIP_RECEIVE_CALLS = "sip_receive_calls";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.625 -0400", hash_original_field = "595FD9EF916FF5823AE808DB3B102DD4", hash_generated_field = "2ADA62A9D843DB5B49435E578FCDA034")

        public static final String SIP_CALL_OPTIONS = "sip_call_options";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.625 -0400", hash_original_field = "3BDF05A9B57EB59A6EA3C9B9EE7236CF", hash_generated_field = "D52129CEEF65BC08652E9F3C6253D7A7")

        public static final String SIP_ALWAYS = "SIP_ALWAYS";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.625 -0400", hash_original_field = "2E5BE605EF29AE9D6227BFCDA83BCFBA", hash_generated_field = "9A4F09A2753BAFDF7EF040996465B130")

        public static final String SIP_ADDRESS_ONLY = "SIP_ADDRESS_ONLY";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.625 -0400", hash_original_field = "B1790A807BFF1EA71EFE26C56476A0FE", hash_generated_field = "D51355F143487EFABF5EB9267AACBEA2")

        public static final String SIP_ASK_ME_EACH_TIME = "SIP_ASK_ME_EACH_TIME";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.625 -0400", hash_original_field = "F91DAF59FFADE018A100845B402BD526", hash_generated_field = "D1002FCCEB2A459ED87837D55D219225")

        public static final String POINTER_SPEED = "pointer_speed";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.625 -0400", hash_original_field = "B2D3FA72F202B715F328874ADB01D69E", hash_generated_field = "73B6208EBA22CAE48882CDE3F75B564C")

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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.626 -0400", hash_original_field = "6277BFD08A8FCBDBDBE10DA78D366085", hash_generated_field = "0158730810C89AFB2B11F831BF219983")

        @Deprecated
        public static final String ADB_ENABLED = Secure.ADB_ENABLED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.626 -0400", hash_original_field = "07B992B5D05E95E94FEE14163F9385A2", hash_generated_field = "0ACA16E81EE87596F1A2FFBA6DD48242")

        @Deprecated
        public static final String ANDROID_ID = Secure.ANDROID_ID;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.626 -0400", hash_original_field = "8407C5FF353F5D1267135BA5FC6D85C3", hash_generated_field = "5BDEA47CA3E299AEF8AACFE651DBEE01")

        @Deprecated
        public static final String BLUETOOTH_ON = Secure.BLUETOOTH_ON;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.626 -0400", hash_original_field = "FDFF0A49D15FF1ACECA02D7FBD75B66B", hash_generated_field = "0FE5D4BDC7C499B7F1172E65323BA8E7")

        @Deprecated
        public static final String DATA_ROAMING = Secure.DATA_ROAMING;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.626 -0400", hash_original_field = "18B04EC804F4B7290ADD4CC2AE17C153", hash_generated_field = "6434C83044DE325459C0115B4E171696")

        @Deprecated
        public static final String DEVICE_PROVISIONED = Secure.DEVICE_PROVISIONED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.626 -0400", hash_original_field = "D0FE33B1D4CEACD5925CD17BA1948C95", hash_generated_field = "935644B669D7B0487AC9F277F906F853")

        @Deprecated
        public static final String HTTP_PROXY = Secure.HTTP_PROXY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.626 -0400", hash_original_field = "554A9683C8EB4152B68548D2F3570DBE", hash_generated_field = "06F7310B2EB8C2A093DD1D2EBE163C9A")

        @Deprecated
        public static final String INSTALL_NON_MARKET_APPS = Secure.INSTALL_NON_MARKET_APPS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.626 -0400", hash_original_field = "2338FAE58210BDFDA6AA4AC517711017", hash_generated_field = "0A47C5F6758DE070D1DCA29C59F9E265")

        @Deprecated
        public static final String LOCATION_PROVIDERS_ALLOWED = Secure.LOCATION_PROVIDERS_ALLOWED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.626 -0400", hash_original_field = "A468EA8E722259CFD7179B62EFF867C3", hash_generated_field = "D6506E36F2AD0960E5DC34B8B87277A0")

        @Deprecated
        public static final String LOGGING_ID = Secure.LOGGING_ID;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.626 -0400", hash_original_field = "E6B296D97E6BAC07C366CC92132DD89F", hash_generated_field = "0A037DD0966AF59BCF3DB4CA35F6FBC3")

        @Deprecated
        public static final String NETWORK_PREFERENCE = Secure.NETWORK_PREFERENCE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.626 -0400", hash_original_field = "5CD127842A511FB2C178E6A218475A5F", hash_generated_field = "84796F1553CBE4E8CF2A3D4F4DFFDA28")

        @Deprecated
        public static final String PARENTAL_CONTROL_ENABLED = Secure.PARENTAL_CONTROL_ENABLED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.627 -0400", hash_original_field = "0787CD93F96EFF41A0C3266B95050D71", hash_generated_field = "FA7155D8AB592E1F40EBA66EEA30E8E1")

        @Deprecated
        public static final String PARENTAL_CONTROL_LAST_UPDATE = Secure.PARENTAL_CONTROL_LAST_UPDATE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.627 -0400", hash_original_field = "83D817F44266E890908FD00EC7B47ED7", hash_generated_field = "F4603F47EAC6A39F83D0AFD232782310")

        @Deprecated
        public static final String PARENTAL_CONTROL_REDIRECT_URL =
            Secure.PARENTAL_CONTROL_REDIRECT_URL;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.627 -0400", hash_original_field = "D1D86A7745EC5BC86612A335F967DFA8", hash_generated_field = "89669DEF771A099EEBAF3DA9E1E1EA61")

        @Deprecated
        public static final String SETTINGS_CLASSNAME = Secure.SETTINGS_CLASSNAME;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.627 -0400", hash_original_field = "41AAE491C79B638C894E428F9B63F0FB", hash_generated_field = "850ECA04CC143293B0DB760696152F0C")

        @Deprecated
        public static final String USB_MASS_STORAGE_ENABLED = Secure.USB_MASS_STORAGE_ENABLED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.627 -0400", hash_original_field = "A8251F8B0DAB7DD811431E515CCAF27C", hash_generated_field = "0A185F50A9A1FF26C7C0DC336E0B8FFF")

        @Deprecated
        public static final String USE_GOOGLE_MAIL = Secure.USE_GOOGLE_MAIL;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.627 -0400", hash_original_field = "C551A3E666A909FB106C12E1CAF8DB0F", hash_generated_field = "9031BD4C95FD17A73104ACE3E6507B25")

        @Deprecated
        public static final String WIFI_MAX_DHCP_RETRY_COUNT = Secure.WIFI_MAX_DHCP_RETRY_COUNT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.627 -0400", hash_original_field = "26FADE6243B5B63109D628F34322AA93", hash_generated_field = "3CDFF6C4CAF8771B42470D4218DFE245")

        @Deprecated
        public static final String WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS =
                Secure.WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.627 -0400", hash_original_field = "7CBB741F276A77C7799C318A29234B1A", hash_generated_field = "741892A65B2970566BD781F31FCE550E")

        @Deprecated
        public static final String WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON =
            Secure.WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.627 -0400", hash_original_field = "B5F5F6A694A78090179F4194410A10B8", hash_generated_field = "7D93E709DF63AE53BD5A1D9EB429CBBF")

        @Deprecated
        public static final String WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY =
            Secure.WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.627 -0400", hash_original_field = "35757A81B80A447BE2F513E086EB4102", hash_generated_field = "EDE996AE1E1BBE951325E134337F729E")

        @Deprecated
        public static final String WIFI_NUM_OPEN_NETWORKS_KEPT = Secure.WIFI_NUM_OPEN_NETWORKS_KEPT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.627 -0400", hash_original_field = "42500F8AED350BFD56F741FF4301EB28", hash_generated_field = "23851BA4096DF5768F88F4BD0B4C5584")

        @Deprecated
        public static final String WIFI_ON = Secure.WIFI_ON;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.627 -0400", hash_original_field = "782C92CF1B17BCB7DB4E33638071234A", hash_generated_field = "8729494C56A2EA11C4E4598BD13E3F03")

        @Deprecated
        public static final String WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE =
                Secure.WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.628 -0400", hash_original_field = "1D43C00648179ACDE7551396D12C8002", hash_generated_field = "6C2680ED58B98431580917E9714EA9D2")

        @Deprecated
        public static final String WIFI_WATCHDOG_AP_COUNT = Secure.WIFI_WATCHDOG_AP_COUNT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.628 -0400", hash_original_field = "0DD2D1C32EA659E0D911E61167E485BE", hash_generated_field = "BE0C5BF1C4CDC0AF6521399A8AB6C9F5")

        @Deprecated
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS =
                Secure.WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.628 -0400", hash_original_field = "136EA9768FF8E639B52401A615DF4D60", hash_generated_field = "2049D8D0AB5D47AE5A38B87A22E183BD")

        @Deprecated
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED =
                Secure.WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.628 -0400", hash_original_field = "80B90EB636BEC04DA0E2C9B3921C9CE9", hash_generated_field = "E4A8E74F10B07727F0D2314EA91DE0DA")

        @Deprecated
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS =
                Secure.WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.628 -0400", hash_original_field = "55D1835CCCAB4F24BBE662CB114C2225", hash_generated_field = "88BA451BBD486A2495B5907AE94E9469")

        @Deprecated
        public static final String WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT =
            Secure.WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.628 -0400", hash_original_field = "2D11612B5820FAEC110C046C5A69D7E7", hash_generated_field = "C28BFA31098F58B246DC1CCF7C25B7FF")

        @Deprecated
        public static final String WIFI_WATCHDOG_MAX_AP_CHECKS = Secure.WIFI_WATCHDOG_MAX_AP_CHECKS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.628 -0400", hash_original_field = "6F65BFB0DBD3EADBD8A7A20127B6411F", hash_generated_field = "FFCB4171F06B714155340312C28397EF")

        @Deprecated
        public static final String WIFI_WATCHDOG_ON = Secure.WIFI_WATCHDOG_ON;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.628 -0400", hash_original_field = "AEE479030A1908F349FF0B680ED2CD27", hash_generated_field = "32667D9B2087E39F8C8F05313D8E2B50")

        @Deprecated
        public static final String WIFI_WATCHDOG_PING_COUNT = Secure.WIFI_WATCHDOG_PING_COUNT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.628 -0400", hash_original_field = "ED015A9C56850855BD23768DA56CDDE2", hash_generated_field = "B7303EA32D313DB0D78425480DE7D828")

        @Deprecated
        public static final String WIFI_WATCHDOG_PING_DELAY_MS = Secure.WIFI_WATCHDOG_PING_DELAY_MS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.628 -0400", hash_original_field = "AE186DE19A6BA1E95E4C2E31989B451B", hash_generated_field = "55A102E3F7D2A23C71E2DE953B72AC49")

        @Deprecated
        public static final String WIFI_WATCHDOG_PING_TIMEOUT_MS =
            Secure.WIFI_WATCHDOG_PING_TIMEOUT_MS;
    }


    
    public static final class Secure extends NameValueTable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.633 -0400", hash_original_method = "73610FEA11960E691F3222B2F82B6F9C", hash_generated_method = "73610FEA11960E691F3222B2F82B6F9C")
        public Secure ()
        {
            //Synthesized constructor
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.637 -0400", hash_original_field = "D48583E7FC2E334DC6900C58D3C30C9A", hash_generated_field = "89F618E2E3C416CB64A1997ADB040178")

        public static final String SYS_PROP_SETTING_VERSION = "sys.settings_secure_version";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.638 -0400", hash_original_field = "B98039EA853AA9A1AF1831BA37B04DA2", hash_generated_field = "1FB09179C87042F649D2E6D9B8084B29")

        private static NameValueCache sNameValueCache = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.638 -0400", hash_original_field = "3F0F00AE87F914FE4DBC1C65EFB8A659", hash_generated_field = "50A988B0A7905EB03033341F5986653C")

        public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/secure");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.638 -0400", hash_original_field = "BBAF81C810A51D5B1A6855F89637F4DB", hash_generated_field = "79C9D39FC9AEFA4FD135B1B0E9CFD23B")

        public static final String ADB_ENABLED = "adb_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.638 -0400", hash_original_field = "EA8CE29E28F588B3D0F0EB8D742BE48C", hash_generated_field = "3BC333DB3AFA4C696FAD89681679AA10")

        public static final String ALLOW_MOCK_LOCATION = "mock_location";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.638 -0400", hash_original_field = "6901E180A578334071B9368C41036BB2", hash_generated_field = "89FD614DB78884DF65F3F864AB0A15E4")

        public static final String ANDROID_ID = "android_id";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.638 -0400", hash_original_field = "7A3FC99EB59881B136108998FA82761E", hash_generated_field = "6ECB5F3102CE3AAAB4956FF4F326D9FD")

        public static final String BLUETOOTH_ON = "bluetooth_on";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.638 -0400", hash_original_field = "B725B48FBDB6B51C6AF18CFA069594F2", hash_generated_field = "161416AEED8B133C02292255110D8589")

        public static final String DATA_ROAMING = "data_roaming";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.638 -0400", hash_original_field = "20362677B3D8E6C93EDC734B7A8AD34E", hash_generated_field = "786D71DE2574BB102EE620BBEFE3B97D")

        public static final String DEFAULT_INPUT_METHOD = "default_input_method";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.638 -0400", hash_original_field = "5C2ED860538CFB4EBCC401B4B559A971", hash_generated_field = "439F1F7665FD282BF53CD7D967AE11B8")

        public static final String SELECTED_INPUT_METHOD_SUBTYPE =
                "selected_input_method_subtype";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.638 -0400", hash_original_field = "EE7D65D5C8B397C5685CCF7D1E35E199", hash_generated_field = "A5A72B1A7317C15B1F497E011637F800")

        public static final String INPUT_METHODS_SUBTYPE_HISTORY =
                "input_methods_subtype_history";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.638 -0400", hash_original_field = "DADDB6F1D487DB331E3254E3633A4440", hash_generated_field = "BDA028C6D33BCE8F68880A0F59B553D8")

        public static final String INPUT_METHOD_SELECTOR_VISIBILITY =
                "input_method_selector_visibility";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.638 -0400", hash_original_field = "2B0B1CB633A63FABA4AF95596BD7C851", hash_generated_field = "37959C9F324A4531FCAFAFAA9F627951")

        public static final String DEVICE_PROVISIONED = "device_provisioned";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.639 -0400", hash_original_field = "2ABB219C2D6F22D0D4B7F7910587F432", hash_generated_field = "3DE62CCC2B9BC3E462ACB5065E6B416D")

        public static final String ENABLED_INPUT_METHODS = "enabled_input_methods";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.639 -0400", hash_original_field = "D0FDA2C6E4DD397794AC063F970ECB02", hash_generated_field = "5BDA117944EC7B2205CF264FF0467CD7")

        public static final String DISABLED_SYSTEM_INPUT_METHODS = "disabled_system_input_methods";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.639 -0400", hash_original_field = "338D0F4653452AB84C8162689D716117", hash_generated_field = "BD934F1BA33AA64486FB6E371253EF84")

        public static final String HTTP_PROXY = "http_proxy";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.639 -0400", hash_original_field = "1555CE03793ABF672ED52597491A9C7C", hash_generated_field = "A1C49F8CC5DF0E871082A64E1E915759")

        public static final String GLOBAL_HTTP_PROXY_HOST = "global_http_proxy_host";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.639 -0400", hash_original_field = "C488B3BF51D51D4B431080CE8602D916", hash_generated_field = "F94933BFC71A934BBEF9EE97FD5AE9A6")

        public static final String GLOBAL_HTTP_PROXY_PORT = "global_http_proxy_port";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.639 -0400", hash_original_field = "828E039BBAAB3F7B7AE28052D0BDA91F", hash_generated_field = "D7FD231F3BD028154E38DD47CF2F5F26")

        public static final String GLOBAL_HTTP_PROXY_EXCLUSION_LIST =
                "global_http_proxy_exclusion_list";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.639 -0400", hash_original_field = "E449B2C6CD5008C4254A159E461BE891", hash_generated_field = "9146A394ADABDBFCED4323E3935F0C59")

        public static final String SET_GLOBAL_HTTP_PROXY = "set_global_http_proxy";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.639 -0400", hash_original_field = "BEA42A64B9C257ECC4BAFE6CD7195AA3", hash_generated_field = "EDF48BF13E9B5A624E0D8A45059AD437")

        public static final String DEFAULT_DNS_SERVER = "default_dns_server";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.639 -0400", hash_original_field = "E49BEEBEE5E33E05CE7018CC6018C373", hash_generated_field = "0E2F58D8FA8E46D4792ACDFAA870246C")

        public static final String INSTALL_NON_MARKET_APPS = "install_non_market_apps";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.639 -0400", hash_original_field = "CD0D1D0299C7CA4E6135EBEDF7854B88", hash_generated_field = "907D81EB90820D16F8FAD7BB2F9BA6F8")

        public static final String LOCATION_PROVIDERS_ALLOWED = "location_providers_allowed";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.640 -0400", hash_original_field = "AB4A2A25D4CBBC684A5F4886F123DDA4", hash_generated_field = "82B3CDF29251BA36EBA228FF6B55927E")

        public static final String LOCK_PATTERN_ENABLED = "lock_pattern_autolock";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.640 -0400", hash_original_field = "62FEBDE12BC61330FB1672BCB8E93E37", hash_generated_field = "DF7DD79FD9BB251B49360995543E0E37")

        public static final String LOCK_PATTERN_VISIBLE = "lock_pattern_visible_pattern";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.640 -0400", hash_original_field = "D29C204677A4C86A389FA02C8848E0EE", hash_generated_field = "6D24BA38A6603BF3EE5DA4E0EE37AE46")

        public static final String LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED =
            "lock_pattern_tactile_feedback_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.640 -0400", hash_original_field = "AD207888011C366D2CEF338F9528ECAB", hash_generated_field = "BB69B189558D8C7D217A89E68B28ABB4")

        public static final String LOCK_SCREEN_LOCK_AFTER_TIMEOUT = "lock_screen_lock_after_timeout";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.640 -0400", hash_original_field = "6C4D021ACB7ACEA788F5733018DC60D3", hash_generated_field = "6C70254B97D651FD36AA5BEEE1A4EE22")

        public static final String LOCK_SCREEN_OWNER_INFO = "lock_screen_owner_info";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.640 -0400", hash_original_field = "0642A663C5B8F9BD53B0A8569C767A98", hash_generated_field = "71E668B511B8248CCFCDF87B3C8D226C")

        public static final String LOCK_SCREEN_OWNER_INFO_ENABLED =
            "lock_screen_owner_info_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.640 -0400", hash_original_field = "C65150D279122A2E7CB46DC760A55BCB", hash_generated_field = "30200426AF9EABAE361B7F05B1C2D4D0")

        public static final String DISPLAY_SIZE_FORCED = "display_size_forced";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.640 -0400", hash_original_field = "B9095C07211898DCD7B351E7A0500015", hash_generated_field = "13583C0CA20E88382CF606B4B1E38E05")

        public static final String ASSISTED_GPS_ENABLED = "assisted_gps_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.640 -0400", hash_original_field = "2F6568BAC4226A8ABF30017BDBD951DF", hash_generated_field = "E5C38E643BDB2CE0FD82B6F004D9222D")

        @Deprecated
        public static final String LOGGING_ID = "logging_id";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.640 -0400", hash_original_field = "14A0CF8BC7E29A2AC03DDE913372192E", hash_generated_field = "F44B77883E7B62CAFDF44672A3FB44DF")

        public static final String NETWORK_PREFERENCE = "network_preference";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.641 -0400", hash_original_field = "4C5F154D7D2BD04A52CE78A25326AD75", hash_generated_field = "C43BC96F6DDFB913111A0C732BA9F7CC")

        public static final String TETHER_SUPPORTED = "tether_supported";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.641 -0400", hash_original_field = "D4CA4E53FB71A02F61D1F8F91851A24D", hash_generated_field = "0D4BC156E64A22E1802AB4E3CF305441")

        public static final String TETHER_DUN_REQUIRED = "tether_dun_required";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.641 -0400", hash_original_field = "1B866602898E9EA2DFA66B7D8AB77C6F", hash_generated_field = "043BC9E84F6FADD85EACDEB6EAA0286E")

        public static final String TETHER_DUN_APN = "tether_dun_apn";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.641 -0400", hash_original_field = "98633A8A5881E328E4F4361491E99449", hash_generated_field = "82A884384BF067DB2E2DA4E361D89867")

        public static final String PARENTAL_CONTROL_ENABLED = "parental_control_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.641 -0400", hash_original_field = "5516D77879D81B7EADA1827263BE35F5", hash_generated_field = "405F693ACFDFBD44096304B1F35BF2E7")

        public static final String PARENTAL_CONTROL_LAST_UPDATE = "parental_control_last_update";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.641 -0400", hash_original_field = "4399B2E88AF80EEA0DF8D5B5E755AEE0", hash_generated_field = "EF661B7BE5B462AD0DA465010C4ADBB5")

        public static final String PARENTAL_CONTROL_REDIRECT_URL = "parental_control_redirect_url";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.641 -0400", hash_original_field = "1F289D9F09BC8AA7856AEA5D1772A19C", hash_generated_field = "3EB64A0AF7782602A607B47D7BE14661")

        public static final String SAMPLING_PROFILER_MS = "sampling_profiler_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.641 -0400", hash_original_field = "DA94C822B51D03F7C7C94BA001369E92", hash_generated_field = "DE4EB86752A8CB2FCE425CE29AD2D6D3")

        public static final String SETTINGS_CLASSNAME = "settings_classname";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.641 -0400", hash_original_field = "495A25F8062B8D71CEA835BA05D382E5", hash_generated_field = "E0BEDEC3309A5E98637A774A3B2F6ABC")

        public static final String USB_MASS_STORAGE_ENABLED = "usb_mass_storage_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.641 -0400", hash_original_field = "979164594FEE029337DF1CBAE403333D", hash_generated_field = "BB70E850B9E1C3B7DCCEDA651ABD0C51")

        public static final String USE_GOOGLE_MAIL = "use_google_mail";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.641 -0400", hash_original_field = "4B00CFA91B6E875ADC602A34284A14C3", hash_generated_field = "404B30DDDC777DD7033331F1B9D2E39B")

        public static final String ACCESSIBILITY_ENABLED = "accessibility_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.642 -0400", hash_original_field = "DA4E3E760A02305077E22A5D1C3DE360", hash_generated_field = "9FA8FE59652462F2BB54E061B617FC9E")

        public static final String TOUCH_EXPLORATION_ENABLED = "touch_exploration_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.642 -0400", hash_original_field = "62EEAE3EE466087021C24F079672620C", hash_generated_field = "2852478F7170A6E83BBFACBF69078101")

        public static final String ENABLED_ACCESSIBILITY_SERVICES =
            "enabled_accessibility_services";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.642 -0400", hash_original_field = "DBDC33D4415A981249A990F62337A6F8", hash_generated_field = "31D998194C7910CA82CDE399ECD22B62")

        public static final String ACCESSIBILITY_SPEAK_PASSWORD = "speak_password";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.642 -0400", hash_original_field = "62AC5A407E0E871A9AAFD071E7F000FB", hash_generated_field = "2E179B7DFEA7FD5BBF2E7FFCC6A68410")

        public static final String ACCESSIBILITY_SCRIPT_INJECTION =
            "accessibility_script_injection";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.642 -0400", hash_original_field = "2BCF018D318007E52CD5C6529E13E914", hash_generated_field = "0070BD7CA809C4401B9C22E9E20E9BA0")

        public static final String ACCESSIBILITY_WEB_CONTENT_KEY_BINDINGS =
            "accessibility_web_content_key_bindings";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.642 -0400", hash_original_field = "CA161A4C92AF805356F484EEC0C67347", hash_generated_field = "CAD61C8FED762602C379CFD7F487280E")

        public static final String LONG_PRESS_TIMEOUT = "long_press_timeout";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.642 -0400", hash_original_field = "876070DBD48024D7ACC50554B598B24E", hash_generated_field = "4D0CEA197A58CE5210BA6936CA1883CA")

        @Deprecated
        public static final String TTS_USE_DEFAULTS = "tts_use_defaults";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.642 -0400", hash_original_field = "ECE41E838FDA5C4B7BB81C48041659D3", hash_generated_field = "DDC9C56E7C3533D0CB9DE226F30E21B8")

        public static final String TTS_DEFAULT_RATE = "tts_default_rate";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.642 -0400", hash_original_field = "A63C7D72DEE93BE73B5C3ABA51D654B3", hash_generated_field = "4EFE4D0227367750096C34E3A7E346B3")

        public static final String TTS_DEFAULT_PITCH = "tts_default_pitch";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.642 -0400", hash_original_field = "211C0774B98B98AC66FAEC7FC5830B6E", hash_generated_field = "F2D6900708576CA908745561500EF3C4")

        public static final String TTS_DEFAULT_SYNTH = "tts_default_synth";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.642 -0400", hash_original_field = "557C85EA4B8801DC5A52F713BF3FB844", hash_generated_field = "0EBE88E208B1851FF7590028067FDB5E")

        @Deprecated
        public static final String TTS_DEFAULT_LANG = "tts_default_lang";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.643 -0400", hash_original_field = "1CD9DBC7FE0B3AACF2D1EFDAC4472080", hash_generated_field = "56A050A1A2DB89C9570F760F5015745A")

        @Deprecated
        public static final String TTS_DEFAULT_COUNTRY = "tts_default_country";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.643 -0400", hash_original_field = "6BEAB1B649E251A87B919F9C147DDB84", hash_generated_field = "D2A0E2237CA61C3436901404ADAABC12")

        @Deprecated
        public static final String TTS_DEFAULT_VARIANT = "tts_default_variant";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.643 -0400", hash_original_field = "F45475A58621F2700E22AB05730B9140", hash_generated_field = "C70B854049AA294107CE8BED3A774F27")

        public static final String TTS_DEFAULT_LOCALE = "tts_default_locale";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.643 -0400", hash_original_field = "FC0C09069644A792603C085570199F02", hash_generated_field = "854FCF0B78B4570DE26F375774B0B03C")

        public static final String TTS_ENABLED_PLUGINS = "tts_enabled_plugins";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.643 -0400", hash_original_field = "74B1E9BBE85AE4BC97DFEBD5701C5D95", hash_generated_field = "E77A49D7F5B8C434897B8F922D14D6E4")

        public static final String WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON =
                "wifi_networks_available_notification_on";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.643 -0400", hash_original_field = "76919722D350EA9FE57F67C5EBA9FF2E", hash_generated_field = "51E3DA776598F758A63CB8614CB8CF37")

        public static final String WIMAX_NETWORKS_AVAILABLE_NOTIFICATION_ON =
                "wimax_networks_available_notification_on";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.643 -0400", hash_original_field = "F41108B9F2E454E50CB12A40F2B017B7", hash_generated_field = "EB71927AE8FF594D3494CC7DD199AE0C")

        public static final String WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY =
                "wifi_networks_available_repeat_delay";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.643 -0400", hash_original_field = "886715706B74A15BBA57F919522BBC38", hash_generated_field = "73CDF25AE524EEA5842CAE97A4624659")

        public static final String WIFI_COUNTRY_CODE = "wifi_country_code";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.643 -0400", hash_original_field = "2E1DD4BD59078586E5720FAABB9D538C", hash_generated_field = "B32FE3167D8FEF1DD0AA761FA9919781")

        public static final String WIFI_NUM_OPEN_NETWORKS_KEPT = "wifi_num_open_networks_kept";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.643 -0400", hash_original_field = "553D9EEDE6A584E2AD6717D7C5E0B2B1", hash_generated_field = "1F16CB26B69C164B197B31E0DD9D191E")

        public static final String WIFI_ON = "wifi_on";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.643 -0400", hash_original_field = "39F9E11861F530EEDE7C72CEA0B4D3F6", hash_generated_field = "FD7AFE3DBB403DF237FD3E49B38C38F7")

        public static final String WIFI_SAVED_STATE = "wifi_saved_state";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.644 -0400", hash_original_field = "D96CE94EBE2EBC01E8EDB747A942197D", hash_generated_field = "D9052A1B349240A9BD258935AD11DF85")

        public static final String WIFI_AP_SSID = "wifi_ap_ssid";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.644 -0400", hash_original_field = "4AE7C3B02581A36607510A0BFFB03C25", hash_generated_field = "1E938B466B6204C77CFF64693A7F9EFE")

        public static final String WIFI_AP_SECURITY = "wifi_ap_security";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.644 -0400", hash_original_field = "B5D9C933A285F6AFE6C2FB03125AB481", hash_generated_field = "8D1E9FCA5B2A2A6E00182F6A70C0A3DC")

        public static final String WIFI_AP_PASSWD = "wifi_ap_passwd";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.644 -0400", hash_original_field = "DC756133EE1616AFC24CA20A452A6CB4", hash_generated_field = "83BA3C88680EA6E3324AF2839D0EB942")

        @Deprecated
        public static final String WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE =
                "wifi_watchdog_acceptable_packet_loss_percentage";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.644 -0400", hash_original_field = "833B1A574F4519E7A78F643855C33C32", hash_generated_field = "AD6194D470E707D60A5B38DA12E0817E")

        @Deprecated
        public static final String WIFI_WATCHDOG_AP_COUNT = "wifi_watchdog_ap_count";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.644 -0400", hash_original_field = "786954D73EC10CEA089985ACD4AFA011", hash_generated_field = "407528D8402F624D61DA51A9773DA9EF")

        @Deprecated
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS =
                "wifi_watchdog_background_check_delay_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.644 -0400", hash_original_field = "50754B8F09FF9251D19771EEA02BC498", hash_generated_field = "8C2503926809955C5E808684C01D4A39")

        @Deprecated
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED =
                "wifi_watchdog_background_check_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.644 -0400", hash_original_field = "5C24621848FA694585D6A50B803FBC3A", hash_generated_field = "3BBEFDC0DF3EB28ADCD125B18B6482DA")

        @Deprecated
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS =
                "wifi_watchdog_background_check_timeout_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.644 -0400", hash_original_field = "CB1EE8401495CD8003714290F6BFDB45", hash_generated_field = "5DC2C91A28ECCF5C9817286975EEE6D2")

        @Deprecated
        public static final String WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT =
            "wifi_watchdog_initial_ignored_ping_count";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.644 -0400", hash_original_field = "D99704D26C17F11392D6CE1798752FF4", hash_generated_field = "B5578E1AC71D475B561E8D9E7A955127")

        @Deprecated
        public static final String WIFI_WATCHDOG_MAX_AP_CHECKS = "wifi_watchdog_max_ap_checks";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.645 -0400", hash_original_field = "3690428328658D28F9FF9AF13CF055D4", hash_generated_field = "4D29BDA552B839DC0DD97343EE6CD4E0")

        public static final String WIFI_WATCHDOG_ON = "wifi_watchdog_on";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.645 -0400", hash_original_field = "BA3109C2F642B20728082B4AF78DB1D2", hash_generated_field = "471028AFABA89CF336D093B439EE705F")

        @Deprecated
        public static final String WIFI_WATCHDOG_WATCH_LIST = "wifi_watchdog_watch_list";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.645 -0400", hash_original_field = "E7F6E90741DF8A5361D4CDE982B4B115", hash_generated_field = "DA26C1688FC60CD953796708BE77C471")

        @Deprecated
        public static final String WIFI_WATCHDOG_PING_COUNT = "wifi_watchdog_ping_count";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.645 -0400", hash_original_field = "088AED766430C96E5C3B6BB43BBB52EA", hash_generated_field = "2CDF8826F07666FDCB8A82EEC07FC855")

        @Deprecated
        public static final String WIFI_WATCHDOG_PING_DELAY_MS = "wifi_watchdog_ping_delay_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.645 -0400", hash_original_field = "757A15388078398A0FAECB0F33099B85", hash_generated_field = "306F914FD3C294A8F2745F8C532C0862")

        @Deprecated
        public static final String WIFI_WATCHDOG_PING_TIMEOUT_MS = "wifi_watchdog_ping_timeout_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.645 -0400", hash_original_field = "ADF3B72B1A521540053E1E644F4482D6", hash_generated_field = "14BE9E5C2CEAE1BFD61064F03EEDEDBD")

        public static final String WIFI_WATCHDOG_DNS_CHECK_SHORT_INTERVAL_MS =
                "wifi_watchdog_dns_check_short_interval_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.645 -0400", hash_original_field = "B072FA3BCFAD38956E5D1C43AD3114F5", hash_generated_field = "D346454A076E302AEA489CB9A566068A")

        public static final String WIFI_WATCHDOG_DNS_CHECK_LONG_INTERVAL_MS =
                "wifi_watchdog_dns_check_long_interval_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.645 -0400", hash_original_field = "00618DCF9699B6C7F761EC117489C7C7", hash_generated_field = "CBC93C08D9074342B13AB32EDC9FAA5D")

        public static final String WIFI_WATCHDOG_WALLED_GARDEN_INTERVAL_MS =
                "wifi_watchdog_walled_garden_interval_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.645 -0400", hash_original_field = "56329087B70D9118493739B0EDEA083D", hash_generated_field = "0F7F4D099CBD6513013C1E5AD684989B")

        public static final String WIFI_WATCHDOG_MAX_SSID_BLACKLISTS =
                "wifi_watchdog_max_ssid_blacklists";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.645 -0400", hash_original_field = "E61818F66A2EC986ABF036EC2B8A1BF8", hash_generated_field = "9E118E1ABC6D2774B7437A2926AF3472")

        public static final String WIFI_WATCHDOG_NUM_DNS_PINGS = "wifi_watchdog_num_dns_pings";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.645 -0400", hash_original_field = "84E83729F9A7C4574E8C40F24614DEB5", hash_generated_field = "E23B3ABB35784011E55EEB4194623D07")

        public static final String WIFI_WATCHDOG_MIN_DNS_RESPONSES =
                "wifi_watchdog_min_dns_responses";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.646 -0400", hash_original_field = "9921FCD004355B5FC99AA1E87E6A87C1", hash_generated_field = "7A09FDF01BD3DC833190299A3FFCB42B")

        public static final String WIFI_WATCHDOG_DNS_PING_TIMEOUT_MS =
                "wifi_watchdog_dns_ping_timeout_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.646 -0400", hash_original_field = "A9D5339B9DCED5E9D3C1BB2BE9BB2B28", hash_generated_field = "6CBB69D64C3CA9AF44F840D809506929")

        public static final String WIFI_WATCHDOG_BLACKLIST_FOLLOWUP_INTERVAL_MS =
                "wifi_watchdog_blacklist_followup_interval_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.646 -0400", hash_original_field = "3FAA4138F4ACE14FF07AD167D1725499", hash_generated_field = "F74A4E3EC63F7CC7E60ADB80ED983511")

        public static final String WIFI_WATCHDOG_POOR_NETWORK_TEST_ENABLED =
                "wifi_watchdog_poor_network_test_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.646 -0400", hash_original_field = "559AB37382BEE88EDAA6CBF9E3FED302", hash_generated_field = "436F43D2CC6AB30E4AE6D43A85AD8FAE")

        public static final String WIFI_WATCHDOG_WALLED_GARDEN_TEST_ENABLED =
                "wifi_watchdog_walled_garden_test_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.646 -0400", hash_original_field = "0ECDF6927A9E30678387661F96F771AD", hash_generated_field = "3867A6B889B240D4E12347BD3A3D5A26")

        public static final String WIFI_WATCHDOG_WALLED_GARDEN_URL =
                "wifi_watchdog_walled_garden_url";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.646 -0400", hash_original_field = "DA0E45B403B80B466CE1989E2318D6B7", hash_generated_field = "DAAE8FACA016ADE82F696FCAC85BAD96")

        public static final String WIFI_WATCHDOG_SHOW_DISABLED_NETWORK_POPUP =
                "wifi_watchdog_show_disabled_network_popup";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.646 -0400", hash_original_field = "B467EE611BD9FD2BB6365E072AFDFB06", hash_generated_field = "2568AA0DD3330B8749996350A4AAB403")

        public static final String WIFI_MAX_DHCP_RETRY_COUNT = "wifi_max_dhcp_retry_count";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.646 -0400", hash_original_field = "58CDAACE99763C4E31D3937CDFE7DE8F", hash_generated_field = "E377F6D2E06E01D783D8D2AD2FDA9B29")

        public static final String WIFI_FREQUENCY_BAND = "wifi_frequency_band";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.646 -0400", hash_original_field = "74D1CA63B7F7DCD35F25372C94304010", hash_generated_field = "4B7AA9A37571DB91F0C5CB9DE2010AD0")

        public static final String WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS =
            "wifi_mobile_data_transition_wakelock_timeout_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.646 -0400", hash_original_field = "3B8F620D09F25E423E5C6E571A4EFAC8", hash_generated_field = "82919390A121EA2BBDB3BF9B5866B90E")

        @Deprecated
        public static final String BACKGROUND_DATA = "background_data";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.646 -0400", hash_original_field = "B229D78640F07DD96AAEB0AA8E5BD8B9", hash_generated_field = "830636DDFDEF56433258551354C9804C")

        public static final String ALLOWED_GEOLOCATION_ORIGINS
                = "allowed_geolocation_origins";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.647 -0400", hash_original_field = "D872BF345D242824A574EA7F2FBCF21E", hash_generated_field = "EF0AE5FF920FEDD44EDC2B771851B3FA")

        public static final String MOBILE_DATA = "mobile_data";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.647 -0400", hash_original_field = "6476DE20202A2A29C436C2883D7E7DE3", hash_generated_field = "A84A8D317FBFD621AEF87F14CA35E1E0")

        public static final String CDMA_ROAMING_MODE = "roaming_settings";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.647 -0400", hash_original_field = "5DCA95EAF15664A81CD6B75B2DEE5A61", hash_generated_field = "6BD5DF2E203B88360CE92D9487007B99")

        public static final String CDMA_SUBSCRIPTION_MODE = "subscription_mode";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.647 -0400", hash_original_field = "D288FFEBBD3EB24B15E08F3266D64EDA", hash_generated_field = "B7D77A27006639D1B92E8B3A43DE9320")

        public static final String PREFERRED_NETWORK_MODE =
                "preferred_network_mode";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.647 -0400", hash_original_field = "0568A87792FFD63E8396FBA3DF4C9750", hash_generated_field = "7923F493177C954A70E7E1830BE2DC87")

        public static final String PREFERRED_TTY_MODE =
                "preferred_tty_mode";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.647 -0400", hash_original_field = "9D4D195AB25CE1445F599EBED59F0016", hash_generated_field = "BD83A990DC9AA972B2A48FAD1BA15370")

        public static final String CDMA_CELL_BROADCAST_SMS =
                "cdma_cell_broadcast_sms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.647 -0400", hash_original_field = "495F0713941DAE3FD610B4DA3356DDA6", hash_generated_field = "B6B896D49F18BC36F0DEA2E024C97288")

        public static final String PREFERRED_CDMA_SUBSCRIPTION =
                "preferred_cdma_subscription";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.647 -0400", hash_original_field = "69A1C031D0AA5A09AAAC6D0EDB8FE7F1", hash_generated_field = "EAE64FEE6EE13548FCFBFA0530F8177F")

        public static final String ENHANCED_VOICE_PRIVACY_ENABLED = "enhanced_voice_privacy_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.647 -0400", hash_original_field = "D4ABD1DCA92CEC0CF993B4A9804979E5", hash_generated_field = "76F47F3CC305593C400303802631921C")

        public static final String TTY_MODE_ENABLED = "tty_mode_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.647 -0400", hash_original_field = "1665D3855865C4D6420162D9999A43E7", hash_generated_field = "26FD879A0EE96016B6C63F40C5B6A098")

        public static final String CONNECTIVITY_CHANGE_DELAY = "connectivity_change_delay";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.648 -0400", hash_original_field = "96500576E54270185B8ACB549BADB04E", hash_generated_field = "A177319EBD03EB2037079E40845B9587")

        public static final int CONNECTIVITY_CHANGE_DELAY_DEFAULT = 3000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.648 -0400", hash_original_field = "ED86C1A3A8C23019A36F1A7D0B6C2830", hash_generated_field = "9F16CE40B011290E0C981220BE5A4847")

        public static final String BACKUP_ENABLED = "backup_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.648 -0400", hash_original_field = "28E1F42BAA7A30099283B0B8B17BE253", hash_generated_field = "3C9460127594818C6615598BED772E49")

        public static final String BACKUP_AUTO_RESTORE = "backup_auto_restore";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.648 -0400", hash_original_field = "67B5886BF33375613DE3C1DAA31429CA", hash_generated_field = "FA93AD5EA15AE74B79472152E6D83213")

        public static final String BACKUP_PROVISIONED = "backup_provisioned";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.648 -0400", hash_original_field = "D47E9AB232716A11154ABB9C0645CF00", hash_generated_field = "5E56C94C442D397AC1F933338BA97A6A")

        public static final String BACKUP_TRANSPORT = "backup_transport";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.648 -0400", hash_original_field = "C553FB5F07448C1EA85B1987585FBD4C", hash_generated_field = "34413AC238EE77066209176AA2AAD0BE")

        public static final String LAST_SETUP_SHOWN = "last_setup_shown";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.648 -0400", hash_original_field = "058A80DDA764070D0098977C3EF80F97", hash_generated_field = "6650FABEE1AD090E0BBC3C2F030F0587")

        public static final String MEMCHECK_INTERVAL = "memcheck_interval";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.648 -0400", hash_original_field = "B03F849B21BCFE9539F92759042C9B77", hash_generated_field = "2CBE37645E987ABE9BF821DD1A8EAAA3")

        public static final String MEMCHECK_LOG_REALTIME_INTERVAL =
                "memcheck_log_realtime_interval";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.648 -0400", hash_original_field = "961D1531D3F77C6B4EC4747E2C678F5A", hash_generated_field = "E217CED1FA516C85AE9CE6C0B36327ED")

        public static final String MEMCHECK_SYSTEM_ENABLED = "memcheck_system_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.648 -0400", hash_original_field = "219C47E10ECB29DB2FDEEC6B4343076A", hash_generated_field = "5E439DE0CA35F259AFE4E25DF663DED1")

        public static final String MEMCHECK_SYSTEM_SOFT_THRESHOLD = "memcheck_system_soft";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.648 -0400", hash_original_field = "C5DD28DD72E04055DDC5E4352E65C091", hash_generated_field = "C1E860D7AD347A43D33AE35AF395980C")

        public static final String MEMCHECK_SYSTEM_HARD_THRESHOLD = "memcheck_system_hard";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.648 -0400", hash_original_field = "A838B062A204B9D6E91321B2A2947F78", hash_generated_field = "D954FE89B7DE0BBC37AA00C6814543E2")

        public static final String MEMCHECK_PHONE_SOFT_THRESHOLD = "memcheck_phone_soft";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.649 -0400", hash_original_field = "E9BBB1809E4E10000121D29DD9BEC9AC", hash_generated_field = "5B85B57573DA5C316FF9D2E1E5B807B0")

        public static final String MEMCHECK_PHONE_HARD_THRESHOLD = "memcheck_phone_hard";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.649 -0400", hash_original_field = "26D68C3AA6A783CEF025816FDB2434D5", hash_generated_field = "2DF2B831A9D088B4DBE552D27B69C8CF")

        public static final String MEMCHECK_PHONE_ENABLED = "memcheck_phone_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.649 -0400", hash_original_field = "BFFE7C1233BFBEC5E49F5C8AE7305B76", hash_generated_field = "F2210B70228C1792846F0C6D6200B26A")

        public static final String MEMCHECK_EXEC_START_TIME = "memcheck_exec_start_time";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.649 -0400", hash_original_field = "9EDF7856A8CF023D8C186A4A3AF411B8", hash_generated_field = "C68713D66CB5A015EFB7C88696F2DC0C")

        public static final String MEMCHECK_EXEC_END_TIME = "memcheck_exec_end_time";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.649 -0400", hash_original_field = "BCF1422EB2E42D3DA3D4E593F9CD0C69", hash_generated_field = "C4EF83D389E781169CD40886C2AE391C")

        public static final String MEMCHECK_MIN_SCREEN_OFF = "memcheck_min_screen_off";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.649 -0400", hash_original_field = "2339F38090ED0BB5C05E4374DE0804BC", hash_generated_field = "CF3215160442E19932186F5F54F016AD")

        public static final String MEMCHECK_MIN_ALARM = "memcheck_min_alarm";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.649 -0400", hash_original_field = "EC4DEDF7E5DF7FA22150E83E52F1B746", hash_generated_field = "0390264DA199344464F5A0E1B7B5C07D")

        public static final String MEMCHECK_RECHECK_INTERVAL = "memcheck_recheck_interval";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.649 -0400", hash_original_field = "6899811D21B8B4F63D927659BF99F4CB", hash_generated_field = "17EDB8D55F371603670B886B29E7CCB2")

        public static final String REBOOT_INTERVAL = "reboot_interval";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.649 -0400", hash_original_field = "E5B7BC9D0EA95ABBF2EF664ADC5BA873", hash_generated_field = "D27CBDC563F1F59648A761098FAB2CD6")

        public static final String REBOOT_START_TIME = "reboot_start_time";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.649 -0400", hash_original_field = "668439BBD70FAF8A2336A1D1A7F91BA7", hash_generated_field = "DC86005DF57DA1D81775BC7E981D0200")

        public static final String REBOOT_WINDOW = "reboot_window";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.649 -0400", hash_original_field = "CD45762E164EAE31F559B64A37EE56A4", hash_generated_field = "855DD6262E261B5B00484B5CA23A643E")

        public static final String BATTERY_DISCHARGE_DURATION_THRESHOLD =
                "battery_discharge_duration_threshold";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.649 -0400", hash_original_field = "6A00DD75DDCF7AAE781DBCB6CDE19FD1", hash_generated_field = "2DC39CE53F1A77A5A33BAD988C3346C1")

        public static final String BATTERY_DISCHARGE_THRESHOLD = "battery_discharge_threshold";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.649 -0400", hash_original_field = "1C1AED33B5607DF606DFEAD51F38D66D", hash_generated_field = "C56EA982C0E50205317AE48EA25AA5DB")

        public static final String SEND_ACTION_APP_ERROR = "send_action_app_error";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.650 -0400", hash_original_field = "9E642E4868361216FC27FB9B1CDAB200", hash_generated_field = "83FDD3F6202DE3E004224806C0C9858A")

        public static final String WTF_IS_FATAL = "wtf_is_fatal";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.650 -0400", hash_original_field = "69CA5D6611CF83143DB802FF9DB85078", hash_generated_field = "CB176587351BC7EA5314C91CE9A5EAC1")

        public static final String DROPBOX_AGE_SECONDS =
                "dropbox_age_seconds";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.650 -0400", hash_original_field = "E0403D2B130074B37585B9ECAA03FD9E", hash_generated_field = "127887A28184EB4759D7D7888A0451E4")

        public static final String DROPBOX_MAX_FILES =
                "dropbox_max_files";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.650 -0400", hash_original_field = "C01CE709CBC34303B2B0E80E47667592", hash_generated_field = "4E04B31316E69880D6981CF01009C0FD")

        public static final String DROPBOX_QUOTA_KB =
                "dropbox_quota_kb";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.650 -0400", hash_original_field = "998D99A3E40872096999551F0A3BBF3A", hash_generated_field = "A3B4CCDB771DBAF6B484C7319D9216B9")

        public static final String DROPBOX_QUOTA_PERCENT =
                "dropbox_quota_percent";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.650 -0400", hash_original_field = "6432746FDAA7EA8BB93C31DFE3B08F3B", hash_generated_field = "AB9BEC714B40F59C3D87E308A298C1A6")

        public static final String DROPBOX_RESERVE_PERCENT =
                "dropbox_reserve_percent";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.650 -0400", hash_original_field = "FE5B2EB8D037513396E70F8E438E2C16", hash_generated_field = "7F79A75176326171223B71AC217B5802")

        public static final String DROPBOX_TAG_PREFIX =
                "dropbox:";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.650 -0400", hash_original_field = "FF3EF88F8E605DF1E5845F7AE975B105", hash_generated_field = "4BB97BB3FB3D4C183311FE6E3FD8113B")

        public static final String ERROR_LOGCAT_PREFIX =
                "logcat_for_";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.650 -0400", hash_original_field = "0F4F823BF0F5A0D81828DF09EBB436E3", hash_generated_field = "C0CB5A6E8A796BEAE078191D880A4B1A")

        public static final String SHORT_KEYLIGHT_DELAY_MS =
                "short_keylight_delay_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.650 -0400", hash_original_field = "4760524822DB29062BC89EBF867876DE", hash_generated_field = "79C48C572E4B66AFAC92532282878252")

        public static final String SYS_FREE_STORAGE_LOG_INTERVAL =
                "sys_free_storage_log_interval";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.650 -0400", hash_original_field = "10E95DDDC6A705F1725949C6ED9F352A", hash_generated_field = "E277364C46F18F5D514ECA37E8288EA2")

        public static final String DISK_FREE_CHANGE_REPORTING_THRESHOLD =
                "disk_free_change_reporting_threshold";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.651 -0400", hash_original_field = "A2A03539F21E47285A62FA09FECD46BC", hash_generated_field = "64238B25E0063519B8231B37BA13CB75")

        public static final String SYS_STORAGE_THRESHOLD_PERCENTAGE =
                "sys_storage_threshold_percentage";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.651 -0400", hash_original_field = "53564F86AFD29D49DCEEBA62D086AA4B", hash_generated_field = "A86F3D7F535481640E8844C858DE374D")

        public static final String SYS_STORAGE_THRESHOLD_MAX_BYTES =
                "sys_storage_threshold_max_bytes";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.651 -0400", hash_original_field = "84DF2430CFC3317D23AACF5A6D53BEFA", hash_generated_field = "B6CA50AA7D6DA49D2EDD3DCA72A97913")

        public static final String SYS_STORAGE_FULL_THRESHOLD_BYTES =
                "sys_storage_full_threshold_bytes";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.651 -0400", hash_original_field = "71EAE178E0005C8BA56D03184BF2E525", hash_generated_field = "902A93A935E10C7FCD2B32BDB03DC096")

        public static final String WIFI_IDLE_MS = "wifi_idle_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.651 -0400", hash_original_field = "3BD60645A018F4BE778AD45854661B01", hash_generated_field = "36BB6CF605591BC25DD80B378BB4EAA4")

        public static final String WIFI_FRAMEWORK_SCAN_INTERVAL_MS =
                "wifi_framework_scan_interval_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.652 -0400", hash_original_field = "75D389023DDB362C8AAF5FA3A410B41F", hash_generated_field = "9564EEE58389E3E791A11CCE7EC4B3FB")

        public static final String WIFI_SUPPLICANT_SCAN_INTERVAL_MS =
                "wifi_supplicant_scan_interval_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.652 -0400", hash_original_field = "AD0BE31E3C8E9C0D9C7C0463802E13D6", hash_generated_field = "07AB878D7AE1FD436A98630CAA4B5AA3")

        public static final String PDP_WATCHDOG_POLL_INTERVAL_MS =
                "pdp_watchdog_poll_interval_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.652 -0400", hash_original_field = "B7190B5E45459DA85C447D8FD4FCD0DF", hash_generated_field = "F66E1F7BEAD0C09D09A3DB76CD67D6A9")

        public static final String PDP_WATCHDOG_LONG_POLL_INTERVAL_MS =
                "pdp_watchdog_long_poll_interval_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.652 -0400", hash_original_field = "F2FC3249F949AFFD16411A8933BC74E6", hash_generated_field = "0B21047992B4DCDD894CE068A106D4C3")

        public static final String PDP_WATCHDOG_ERROR_POLL_INTERVAL_MS =
                "pdp_watchdog_error_poll_interval_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.652 -0400", hash_original_field = "9300BB59ECD6BE839700226D27C13DC1", hash_generated_field = "BFF40E3389E98E49B8E77E94CF7D6F85")

        public static final String PDP_WATCHDOG_TRIGGER_PACKET_COUNT =
                "pdp_watchdog_trigger_packet_count";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.653 -0400", hash_original_field = "5D9851851308E9957595FB9E4F2EC533", hash_generated_field = "CBF88FFCE0BFC3DF98DC840FF0886FE9")

        public static final String PDP_WATCHDOG_ERROR_POLL_COUNT =
                "pdp_watchdog_error_poll_count";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.653 -0400", hash_original_field = "D235CA82BA2E7C09E7BD54107A53F747", hash_generated_field = "A181A7ADE439EE350E96EC18E0E3B0B9")

        public static final String PDP_WATCHDOG_MAX_PDP_RESET_FAIL_COUNT =
                "pdp_watchdog_max_pdp_reset_fail_count";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.653 -0400", hash_original_field = "EEC5B5A7F8C854E3AC98867AD3BF7824", hash_generated_field = "E446CF2FD2619123DF59EE579B35D307")

        public static final String DATA_STALL_ALARM_DELAY_IN_MS =
                "data_stall_alarm_delay_in_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.653 -0400", hash_original_field = "4D96DB524A3AD93C4B977041D261336D", hash_generated_field = "83CAD62C7A40DA4635E07950FA3DA46B")

        public static final String GPRS_REGISTER_CHECK_PERIOD_MS =
                "gprs_register_check_period_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.653 -0400", hash_original_field = "182958C617C0EBBB82E4E112D2B8FDAB", hash_generated_field = "2346B37B43CA722CA18867AEE46B4813")

        public static final String NITZ_UPDATE_SPACING = "nitz_update_spacing";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.653 -0400", hash_original_field = "299177FEBEE1108A950CFBFFE69A4C9F", hash_generated_field = "C937AEEBBFEE535DBACF1B5F3BE6566B")

        public static final String NITZ_UPDATE_DIFF = "nitz_update_diff";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.654 -0400", hash_original_field = "FCA66DD30A79C2BB86C2D39AB161F9C2", hash_generated_field = "FB85438084F5A378E386134E18DF1E62")

        public static final String SYNC_MAX_RETRY_DELAY_IN_SECONDS =
                "sync_max_retry_delay_in_seconds";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.654 -0400", hash_original_field = "5B44933D13C73FAF85DAEA2789F418E4", hash_generated_field = "3ADB39776443E40F70DE9993C31208AE")

        public static final String SMS_OUTGOING_CHECK_INTERVAL_MS =
                "sms_outgoing_check_interval_ms";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.654 -0400", hash_original_field = "7AB8ADC7A40B19EC248C90A351A90BCD", hash_generated_field = "274AFB6C6FE7BE016627AB360F6DFC16")

        public static final String SMS_OUTGOING_CHECK_MAX_COUNT =
                "sms_outgoing_check_max_count";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.654 -0400", hash_original_field = "190A37C1C49ACC609AFC6F197E11695D", hash_generated_field = "62C0A966684FE98935712F2B8D95D10E")

        public static final String SEARCH_GLOBAL_SEARCH_ACTIVITY =
                "search_global_search_activity";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.654 -0400", hash_original_field = "16513F1E3963153A84126E3F34FBB2B0", hash_generated_field = "FE435711C62427EFE767116EEFC9C842")

        public static final String SEARCH_NUM_PROMOTED_SOURCES = "search_num_promoted_sources";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.655 -0400", hash_original_field = "1C63196321F0DA925AA55581F2D53830", hash_generated_field = "EF937A75EC36E48C092BDBE50EC38011")

        public static final String SEARCH_MAX_RESULTS_TO_DISPLAY = "search_max_results_to_display";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.655 -0400", hash_original_field = "369ED73B13FCF105485CBEB3BF3B006E", hash_generated_field = "474F88BD32B2E67B3E3D2662860F9E6C")

        public static final String SEARCH_MAX_RESULTS_PER_SOURCE = "search_max_results_per_source";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.655 -0400", hash_original_field = "16DC55B938550781960BB3E003D02D82", hash_generated_field = "5C1BB97D35B1D708971C2EDB3012301D")

        public static final String SEARCH_WEB_RESULTS_OVERRIDE_LIMIT =
                "search_web_results_override_limit";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.655 -0400", hash_original_field = "88E22B0F4DD7FACFFF945F899DB00B7C", hash_generated_field = "4EA4C9435B8E7A2B17E493C1525ECDB7")

        public static final String SEARCH_PROMOTED_SOURCE_DEADLINE_MILLIS =
                "search_promoted_source_deadline_millis";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.655 -0400", hash_original_field = "FDF41E63B4607DC6B10A5DE26389D720", hash_generated_field = "9A55EA7A829B19C057B78F638F89D6C2")

        public static final String SEARCH_SOURCE_TIMEOUT_MILLIS = "search_source_timeout_millis";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.655 -0400", hash_original_field = "C83338771B46DDA22B2837D08FB2095A", hash_generated_field = "0C071F6ACB5B86362BC6CBCD154394F7")

        public static final String SEARCH_PREFILL_MILLIS = "search_prefill_millis";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.655 -0400", hash_original_field = "32B25501592098290A2A15441169C8C2", hash_generated_field = "5196A79C5603E3665516E923C8501BE9")

        public static final String SEARCH_MAX_STAT_AGE_MILLIS = "search_max_stat_age_millis";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.655 -0400", hash_original_field = "338F8C96BEE2A7E8FB445FBC843750C5", hash_generated_field = "8F5C7210CC623D5C484F18E961CE5BFC")

        public static final String SEARCH_MAX_SOURCE_EVENT_AGE_MILLIS =
                "search_max_source_event_age_millis";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.655 -0400", hash_original_field = "03BE2EF70D9B08B6F6B2765F8D3A1D16", hash_generated_field = "29050819A6AA7851DB7EBC8C66470CAE")

        public static final String SEARCH_MIN_IMPRESSIONS_FOR_SOURCE_RANKING =
                "search_min_impressions_for_source_ranking";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.655 -0400", hash_original_field = "E8A82987E22176F410A4ED560296110C", hash_generated_field = "1C79EADBD441811BAED5564AD8ABA143")

        public static final String SEARCH_MIN_CLICKS_FOR_SOURCE_RANKING =
                "search_min_clicks_for_source_ranking";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.656 -0400", hash_original_field = "40A856E0A961FABC7E71163CE27D6066", hash_generated_field = "714DAB38101D97CF96C1616130D99A82")

        public static final String SEARCH_MAX_SHORTCUTS_RETURNED = "search_max_shortcuts_returned";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.656 -0400", hash_original_field = "1D8D951E5781FD37D438C86F5AD18A6C", hash_generated_field = "FF30549DFBD69949D6948D94B5085622")

        public static final String SEARCH_QUERY_THREAD_CORE_POOL_SIZE =
                "search_query_thread_core_pool_size";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.656 -0400", hash_original_field = "33CE8669B9C80EB0295082CA4E02D1A5", hash_generated_field = "7C5BBFB811DD9AE5D124759E0468AEED")

        public static final String SEARCH_QUERY_THREAD_MAX_POOL_SIZE =
                "search_query_thread_max_pool_size";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.656 -0400", hash_original_field = "8CE9A825DAEA725BC4FF876CC7ABD9F3", hash_generated_field = "EA2E818BED35F3CB560FC8DB3D9AB145")

        public static final String SEARCH_SHORTCUT_REFRESH_CORE_POOL_SIZE =
                "search_shortcut_refresh_core_pool_size";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.656 -0400", hash_original_field = "EB5B5E02B47D1A3AFC1779687F7620EE", hash_generated_field = "B127B2F735055CABA38E91E506CFB241")

        public static final String SEARCH_SHORTCUT_REFRESH_MAX_POOL_SIZE =
                "search_shortcut_refresh_max_pool_size";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.656 -0400", hash_original_field = "CD3C399B04826215024E9F3D836A7B25", hash_generated_field = "D90DD095A25A7921A223228B64B5D628")

        public static final String SEARCH_THREAD_KEEPALIVE_SECONDS =
                "search_thread_keepalive_seconds";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.656 -0400", hash_original_field = "2E7F7A5F5D2BFFADD11F4DD2447BABD3", hash_generated_field = "F657EDE0EFAE5DF1937F2590FAE381C0")

        public static final String SEARCH_PER_SOURCE_CONCURRENT_QUERY_LIMIT =
                "search_per_source_concurrent_query_limit";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.656 -0400", hash_original_field = "54AA4AE66282438A518B4AC5633189A9", hash_generated_field = "D99C462BFEC9DDBE5E99B2D165F1ED49")

        public static final String MOUNT_PLAY_NOTIFICATION_SND = "mount_play_not_snd";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.656 -0400", hash_original_field = "58127469D9DF07718CE9AC8C0FA13248", hash_generated_field = "581AC1D6D7B5CBFC30AE55C136D9984F")

        public static final String MOUNT_UMS_AUTOSTART = "mount_ums_autostart";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.656 -0400", hash_original_field = "50C8616FD6F8136FF0E8E31D99DD3EE5", hash_generated_field = "991F4343126AD983BA0E8E42638DF175")

        public static final String MOUNT_UMS_PROMPT = "mount_ums_prompt";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.656 -0400", hash_original_field = "2E9BEDCF914BD628840EB354091004BF", hash_generated_field = "3A9128C63EAD25B71695EF45C7DC433C")

        public static final String MOUNT_UMS_NOTIFY_ENABLED = "mount_ums_notify_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.656 -0400", hash_original_field = "5BABD361C2E02DC55500ED505DE6B20F", hash_generated_field = "6B39D976CC6297F4816DDAF7095C5513")

        public static final String ANR_SHOW_BACKGROUND = "anr_show_background";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.656 -0400", hash_original_field = "E13BFA68BBE99C0783E5A78F42D1DE33", hash_generated_field = "7500E24DEBB8B958D77EA1DB38C18728")

        public static final String VOICE_RECOGNITION_SERVICE = "voice_recognition_service";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.657 -0400", hash_original_field = "D4FAD6E66A813D1949782E20EAA38E2C", hash_generated_field = "5CB0E915937A847A57B25156A3FBE21C")

        public static final String SELECTED_SPELL_CHECKER = "selected_spell_checker";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.657 -0400", hash_original_field = "3F8946DFF1830A4C8B2EECB490A87F36", hash_generated_field = "A848D74CE159B0828931339FABB73513")

        public static final String SELECTED_SPELL_CHECKER_SUBTYPE =
                "selected_spell_checker_subtype";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.657 -0400", hash_original_field = "068CF941EAEF4397F715FE988075FF67", hash_generated_field = "045992FB365DFF8AFAF90562B61BDB2C")

        public static final String SPELL_CHECKER_ENABLED = "spell_checker_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.657 -0400", hash_original_field = "EF5CF35088BA06DD34070395F4AA00E8", hash_generated_field = "48E57D0ABE39B1BE04BDBBDAF0331443")

        public static final String INCALL_POWER_BUTTON_BEHAVIOR = "incall_power_button_behavior";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.657 -0400", hash_original_field = "63B3149C783055A4C8FCE91A8343F38D", hash_generated_field = "2C10D9FDD20BF11E1E9480EF3317B634")

        public static final int INCALL_POWER_BUTTON_BEHAVIOR_SCREEN_OFF = 0x1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.657 -0400", hash_original_field = "7ED9D450C1795BC59C3F04C4AC35ACE5", hash_generated_field = "6C673AF2BD3109F8832E538B0EB6A42B")

        public static final int INCALL_POWER_BUTTON_BEHAVIOR_HANGUP = 0x2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.657 -0400", hash_original_field = "F6C062E6C3B38F44DDA99BE88A5286DC", hash_generated_field = "581EC3B66B7D239430AEF3BBDD520C53")

        public static final int INCALL_POWER_BUTTON_BEHAVIOR_DEFAULT =
                INCALL_POWER_BUTTON_BEHAVIOR_SCREEN_OFF;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.657 -0400", hash_original_field = "23847DBEE4DFEB340017646FFF3896C0", hash_generated_field = "6F9BC115B5BEB811F2119CC1ED0AFD69")

        public static final String UI_NIGHT_MODE = "ui_night_mode";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.657 -0400", hash_original_field = "3DE7E9193E6C3342DAB24F7CE947AA11", hash_generated_field = "F76535E939C7D25DC00C83DE39FB68A4")

        public static final String SET_INSTALL_LOCATION = "set_install_location";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.658 -0400", hash_original_field = "944D9D4A474BD3B1FA5C557C34EA9658", hash_generated_field = "325D1D23247FBF16F774DF3819384D7C")

        public static final String DEFAULT_INSTALL_LOCATION = "default_install_location";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.658 -0400", hash_original_field = "4E675E3770A78E341C2063B4CF5D2C60", hash_generated_field = "35B82B902BD73AA1CFFF23CB50AF4D10")

        public static final String THROTTLE_POLLING_SEC = "throttle_polling_sec";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.658 -0400", hash_original_field = "69496F8FF7CC458F7EBD5C95DE5FD4F1", hash_generated_field = "CF18CCDECC8B2AB2F4D3A463B9F3F7B2")

        public static final String THROTTLE_THRESHOLD_BYTES = "throttle_threshold_bytes";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.658 -0400", hash_original_field = "F3E2B89EB87722E0A331BF9D8B3179D7", hash_generated_field = "4D3BF24B5F4F8A6338262114316C0509")

        public static final String THROTTLE_VALUE_KBITSPS = "throttle_value_kbitsps";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.658 -0400", hash_original_field = "7E5F9787D90A22143907FA6C20D76648", hash_generated_field = "6122B7D0E3B6BD5C49C9A7A80EA90DC4")

        public static final String THROTTLE_RESET_DAY = "throttle_reset_day";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.658 -0400", hash_original_field = "B01EA82D1B098A8A40AB55468B2ADDFA", hash_generated_field = "ED33A470FE0B556CAE9434474ADBE00A")

        public static final String THROTTLE_NOTIFICATION_TYPE = "throttle_notification_type";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.658 -0400", hash_original_field = "76CF0B6D86CFAC7490607C6DDB4BE969", hash_generated_field = "96511F5C70C5D46A181196C4E4F2E0F1")

        public static final String THROTTLE_HELP_URI = "throttle_help_uri";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.658 -0400", hash_original_field = "4A89BE320DEB27B1B3D913481453473F", hash_generated_field = "CEF1A9314BCD1B2BBDCC2EBD864244A2")

        public static final String THROTTLE_MAX_NTP_CACHE_AGE_SEC =
                "throttle_max_ntp_cache_age_sec";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.659 -0400", hash_original_field = "766DC3FE943773E470ECC10C14B322B2", hash_generated_field = "12908E6B3B1A4331BF05F2731E77CCAB")

        public static final String DOWNLOAD_MAX_BYTES_OVER_MOBILE =
                "download_manager_max_bytes_over_mobile";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.659 -0400", hash_original_field = "59F3B0A51DF03ACD6E9456270CE52B5C", hash_generated_field = "4D04773FFA76C87B0E93CF136B775B26")

        public static final String DOWNLOAD_RECOMMENDED_MAX_BYTES_OVER_MOBILE =
                "download_manager_recommended_max_bytes_over_mobile";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.659 -0400", hash_original_field = "B8C65F18DA94295B9624F5EE3F8A36DC", hash_generated_field = "8AA5E3DBB58347E7F7D4B4E1C2DED769")

        public static final String INET_CONDITION_DEBOUNCE_UP_DELAY =
                "inet_condition_debounce_up_delay";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.659 -0400", hash_original_field = "D999F3BACA5C4790D7935A2C1B36AD1A", hash_generated_field = "4E09BC4CF673CF17DA4380FCE5764B70")

        public static final String INET_CONDITION_DEBOUNCE_DOWN_DELAY =
                "inet_condition_debounce_down_delay";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.659 -0400", hash_original_field = "0427E302D74B69819D0996BF9233D063", hash_generated_field = "D397B83F91DBD94FC9647A2CACD0B608")

        public static final String SETUP_PREPAID_DATA_SERVICE_URL =
                "setup_prepaid_data_service_url";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.659 -0400", hash_original_field = "DA213C9C075AE754C3B4E65C942ABAC3", hash_generated_field = "6025DC08E23EA195A8ED5412557B3B24")

        public static final String SETUP_PREPAID_DETECTION_TARGET_URL =
                "setup_prepaid_detection_target_url";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.659 -0400", hash_original_field = "1035032510BA10645016434504FF90EB", hash_generated_field = "C1A1DDAB044903312FFA6AEA41B739DE")

        public static final String SETUP_PREPAID_DETECTION_REDIR_HOST =
                "setup_prepaid_detection_redir_host";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.659 -0400", hash_original_field = "F85E96133C9DC0BD7D237C69DAD63C12", hash_generated_field = "3A541D30D8C068F9F4A7A331EDA7D5BF")

        public static final String NETSTATS_ENABLED = "netstats_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.659 -0400", hash_original_field = "B25DA3B6AEB5A6265453F3B66731AB68", hash_generated_field = "97012A614CC18C607233D0AE57406292")

        public static final String NETSTATS_POLL_INTERVAL = "netstats_poll_interval";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.660 -0400", hash_original_field = "820EDD5ED2966C2ADB7A8160BB023575", hash_generated_field = "3A0BC1015EDAAF28716F7514675B6E57")

        public static final String NETSTATS_PERSIST_THRESHOLD = "netstats_persist_threshold";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.660 -0400", hash_original_field = "B9910A17F55615F80B02A4D97A785ABE", hash_generated_field = "76F0B43D9D5D5BA00AE54221441E1275")

        public static final String NETSTATS_NETWORK_BUCKET_DURATION = "netstats_network_bucket_duration";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.660 -0400", hash_original_field = "158C41360AA653869EC5E6CDE10C8D10", hash_generated_field = "F7B02C2D8E41137E6FEEB5F14E792B3D")

        public static final String NETSTATS_NETWORK_MAX_HISTORY = "netstats_network_max_history";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.660 -0400", hash_original_field = "09D0D40F67CC733587CF40469675545D", hash_generated_field = "C1F30A2512C5BCE8444B05D856D1CDDB")

        public static final String NETSTATS_UID_BUCKET_DURATION = "netstats_uid_bucket_duration";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.660 -0400", hash_original_field = "258347E281EAB62F7563C1347034DC96", hash_generated_field = "C0F27467369670AE7A4284EF89A2D19B")

        public static final String NETSTATS_UID_MAX_HISTORY = "netstats_uid_max_history";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.660 -0400", hash_original_field = "BE5F596FD4F9E15C6E0E0639B4B3B3A8", hash_generated_field = "B95C276377C5A79D0474B105ED9407CD")

        public static final String NETSTATS_TAG_MAX_HISTORY = "netstats_tag_max_history";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.660 -0400", hash_original_field = "156F59E3351EA2AD23C18C4D3A0089E0", hash_generated_field = "CA846D8261307C193530D560CA29AA1F")

        public static final String NTP_SERVER = "ntp_server";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.660 -0400", hash_original_field = "A33015A719C4E1E4D612457A816C1255", hash_generated_field = "B86CE931301F586764153CB2A56117CD")

        public static final String NTP_TIMEOUT = "ntp_timeout";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.661 -0400", hash_original_field = "4339100B174BFFF6D8E2B8D82DFB2287", hash_generated_field = "12E5C8B8E8ABF225189E350147C6584D")

        public static final String WEB_AUTOFILL_QUERY_URL =
            "web_autofill_query_url";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.661 -0400", hash_original_field = "EE06EA0D729568A5E39C5DCCD4F7640F", hash_generated_field = "6DD12C7462C9BCF7A6EAC57A9F7BDFD7")

        public static final String PACKAGE_VERIFIER_ENABLE = "verifier_enable";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.661 -0400", hash_original_field = "6AA5CF53E3CCCD04E8810B19BEA1EB4D", hash_generated_field = "49AF6C6B2403827ED5BBBB49DE820859")

        public static final String PACKAGE_VERIFIER_TIMEOUT = "verifier_timeout";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.661 -0400", hash_original_field = "729F0F8954DAAA9169BCB074AB1F21DB", hash_generated_field = "9C84C2A6C0CC80D6843080065671E834")

        public static final String CONTACTS_PREAUTH_URI_EXPIRATION =
                "contacts_preauth_uri_expiration";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.661 -0400", hash_original_field = "42C1371E0158A65C744C5AFA729AFE61", hash_generated_field = "819961D47F84ED44E31C7B97E1AB9244")

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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.663 -0400", hash_original_method = "BB83E969FD06D277BEC07ACFEA741415", hash_generated_method = "BB83E969FD06D277BEC07ACFEA741415")
        public Bookmarks ()
        {
            //Synthesized constructor
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.666 -0400", hash_original_field = "B8E5FB690A44060A129221081020014F", hash_generated_field = "127C508760F30C38F353D1C0CBBEF438")

        private static final String TAG = "Bookmarks";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.667 -0400", hash_original_field = "0E45B873932DF6C00E550CA9A4362852", hash_generated_field = "9B4329FE7D67E931B8E4A01B2E427FBD")

        public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/bookmarks");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.667 -0400", hash_original_field = "7E5E2750791E8E194A5E2FDF6565BB0B", hash_generated_field = "3C2D71BF930B87FEECA9710D884C1BB3")

        public static final String ID = "_id";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.667 -0400", hash_original_field = "9E269B31B78A189F060D2477A999115E", hash_generated_field = "CC2A30295F4B54C534C25CFD7CF431A8")

        public static final String TITLE = "title";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.667 -0400", hash_original_field = "D2F30F46B539120FCC5DA8025D2DEDAF", hash_generated_field = "DD8A26393BA86076DC51024889C84FE7")

        public static final String FOLDER = "folder";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.668 -0400", hash_original_field = "D6359D1056484FE639F0167D04010781", hash_generated_field = "7E52CAF6C787537A717EB72023CCE33A")

        public static final String INTENT = "intent";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.668 -0400", hash_original_field = "D95BF5C6CA523F20546C6B6D655D0E46", hash_generated_field = "EEDCDED121F192CA9B8B682E02970453")

        public static final String SHORTCUT = "shortcut";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.668 -0400", hash_original_field = "1FA70383E2F953FE1B67CE24AB3A7E31", hash_generated_field = "1FD5DCEFECBA3CDA9C3F1D8D6E8FCEA5")

        public static final String ORDERING = "ordering";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.669 -0400", hash_original_field = "E2E6886CE46B995A0AF534F907B5CDAE", hash_generated_field = "8180CFF9E48F414363A8B1B2ED6E8B23")

        private static final String[] sIntentProjection = { INTENT };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.669 -0400", hash_original_field = "9DBCB78574612FE03B53D676F8126B15", hash_generated_field = "BD85472E85B987B3E065F1D4D68B7324")

        private static final String[] sShortcutProjection = { ID, SHORTCUT };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.669 -0400", hash_original_field = "0902BFE82570AFFBFD601004844097AF", hash_generated_field = "9BB18B2121BFAC2716EBD72A795718CD")

        private static final String sShortcutSelection = SHORTCUT + "=?";
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.669 -0400", hash_original_field = "C64288920DFE68068456EE6F98955632", hash_generated_field = "F0EBBFBD91A8AB3C2FA08137C9490453")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SETTINGS = "android.settings.SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.669 -0400", hash_original_field = "6F8B00B1F15914D6293ECADD65B22A9E", hash_generated_field = "B864194FB055615089C91C29E87B0523")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_APN_SETTINGS = "android.settings.APN_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.669 -0400", hash_original_field = "DD72D0B671A0A1265709A2CB9D94105E", hash_generated_field = "1B4DE5836DE2E2C992166C7C97D4A2A4")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_LOCATION_SOURCE_SETTINGS =
            "android.settings.LOCATION_SOURCE_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.669 -0400", hash_original_field = "D976DFDD59AB30E51C303B3DD35B4427", hash_generated_field = "55254051251EE11D83C2A6F39B89E63A")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_WIRELESS_SETTINGS =
            "android.settings.WIRELESS_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.670 -0400", hash_original_field = "EF4A03EC3F3908206CA5904953771E3E", hash_generated_field = "01F344B29B140AB2B787B57FA9A1E1A4")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_AIRPLANE_MODE_SETTINGS =
            "android.settings.AIRPLANE_MODE_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.670 -0400", hash_original_field = "650BF4D261E3ACDBEA1E56695D53EE8D", hash_generated_field = "B2368D64E6C3AC32800919939DF58E78")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ACCESSIBILITY_SETTINGS =
            "android.settings.ACCESSIBILITY_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.670 -0400", hash_original_field = "F35F03789E3DD4B1D30C8356750AE7FD", hash_generated_field = "A240EFA9E6595AC7D5401FC441997E80")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SECURITY_SETTINGS =
            "android.settings.SECURITY_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.670 -0400", hash_original_field = "89AC8706D39430A859B5652866F87C1C", hash_generated_field = "6FE8E2AD5E161D29BF56D151531C7699")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_PRIVACY_SETTINGS =
            "android.settings.PRIVACY_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.670 -0400", hash_original_field = "03CFFFE39D30E211C8391D9BE28AF228", hash_generated_field = "716648F784E2F1844AAB6788FE172E3A")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_WIFI_SETTINGS =
            "android.settings.WIFI_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.671 -0400", hash_original_field = "A73AFAD44B0BC8E781786BCF55694BB0", hash_generated_field = "C7FC3278DEB3C1BF7553DFADE4ECF0A2")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_WIFI_IP_SETTINGS =
            "android.settings.WIFI_IP_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.671 -0400", hash_original_field = "F5D44A7F6E48B13272E0BB0A3BB7A925", hash_generated_field = "8A632A9B9A10F0E522882BF1A7EF7B57")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_BLUETOOTH_SETTINGS =
            "android.settings.BLUETOOTH_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.671 -0400", hash_original_field = "5BB5C39075E0718FA762AD24DC8E5BB2", hash_generated_field = "4C2E0718510D13E88526D0FA27F74D3F")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_DATE_SETTINGS =
            "android.settings.DATE_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.671 -0400", hash_original_field = "1224B4A5D7A592DA379FFF1D82E7E431", hash_generated_field = "A0E974CC475E770F870EBD1DD075F4BA")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SOUND_SETTINGS =
            "android.settings.SOUND_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.671 -0400", hash_original_field = "1B6F2FF67892CB6DCA184CE4C26C3BA4", hash_generated_field = "40A499BB1112150B1B741AAC14A5C9A5")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_DISPLAY_SETTINGS =
            "android.settings.DISPLAY_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.671 -0400", hash_original_field = "8E130DCC62E6F6EB0974486029E32733", hash_generated_field = "D8F4D2F5FB2B704BCB0B300338FB258D")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_LOCALE_SETTINGS =
            "android.settings.LOCALE_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.671 -0400", hash_original_field = "94B117754A363A519067FFDE49550B95", hash_generated_field = "7CE68EDFA3A8F2FE9BECC07CC52D9F82")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_INPUT_METHOD_SETTINGS =
            "android.settings.INPUT_METHOD_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.671 -0400", hash_original_field = "C8B9408BD177463A824AF77573FFB736", hash_generated_field = "4AAC09FF7BB0DE02F9C046BE1F7BEF42")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_INPUT_METHOD_SUBTYPE_SETTINGS =
            "android.settings.INPUT_METHOD_SUBTYPE_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.672 -0400", hash_original_field = "7293B05A84B2E205975D093428308E73", hash_generated_field = "5BC01803EDC5010007F13BF8554E3D09")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SHOW_INPUT_METHOD_PICKER =
            "android.settings.SHOW_INPUT_METHOD_PICKER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.672 -0400", hash_original_field = "B9679E759C3EB9D3DAF9A2ECE8B66455", hash_generated_field = "F09BD83AD7BC98DA71F06E4EDC1C23F4")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_USER_DICTIONARY_SETTINGS =
            "android.settings.USER_DICTIONARY_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.672 -0400", hash_original_field = "CD1D24AA4B88BDBFE6A2192D05F3BAFC", hash_generated_field = "AA6CA7099234F41E42BC202ECAAB87C5")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_USER_DICTIONARY_INSERT =
            "com.android.settings.USER_DICTIONARY_INSERT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.672 -0400", hash_original_field = "E7BC5D2878E584E6B10C54C65A1B7E85", hash_generated_field = "87C568575A91A6E6EE16A274D46AF87C")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_APPLICATION_SETTINGS =
            "android.settings.APPLICATION_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.672 -0400", hash_original_field = "E213CFB39219F983562D6E594C8B0CAC", hash_generated_field = "24DEEECBCBF74CF6915698F12F5917E3")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_APPLICATION_DEVELOPMENT_SETTINGS =
            "android.settings.APPLICATION_DEVELOPMENT_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.672 -0400", hash_original_field = "846BDBED9FEE419AB24E81CCA31815AD", hash_generated_field = "5386F6E15F233B1A67E22162CF465CB6")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_QUICK_LAUNCH_SETTINGS =
            "android.settings.QUICK_LAUNCH_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.672 -0400", hash_original_field = "589C026187152376DC03F4E930C61104", hash_generated_field = "8FCAD26C944DCD49FB213DDDEBE72A3C")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_MANAGE_APPLICATIONS_SETTINGS =
            "android.settings.MANAGE_APPLICATIONS_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.672 -0400", hash_original_field = "810AA228523796BB6974C121FF146819", hash_generated_field = "7F0254EEEBD6BEAC8BA1084E39048541")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS =
            "android.settings.MANAGE_ALL_APPLICATIONS_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.672 -0400", hash_original_field = "93AEAF0EF17A20643CCDA398EC2B5B3C", hash_generated_field = "D544C7AFF247A709115F841B03FCE1C2")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_APPLICATION_DETAILS_SETTINGS =
            "android.settings.APPLICATION_DETAILS_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.672 -0400", hash_original_field = "3154C97FC7259AC4F1970AFDF6E4EC31", hash_generated_field = "3311ADDA4CC906EE61643A6A1942072D")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SYSTEM_UPDATE_SETTINGS =
            "android.settings.SYSTEM_UPDATE_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.673 -0400", hash_original_field = "AB923B17DEC1A197F7D7EA444A3F7883", hash_generated_field = "2A62D0DEF68AC940CCFCA15A8154713F")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SYNC_SETTINGS =
            "android.settings.SYNC_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.673 -0400", hash_original_field = "8B601247E22DB623EDC7C744D04CA00B", hash_generated_field = "9815DDB9E86EC2442899690F191EFD2A")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ADD_ACCOUNT =
            "android.settings.ADD_ACCOUNT_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.673 -0400", hash_original_field = "D05BDD0E3DE6166FF001E5781E86B404", hash_generated_field = "0B25005AF669A43258DB75201D42AF3C")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_NETWORK_OPERATOR_SETTINGS =
            "android.settings.NETWORK_OPERATOR_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.673 -0400", hash_original_field = "4144AF600FA777381710F3D4AFE379AB", hash_generated_field = "9F19D1DCCEC10730EB3AD96B3ABA527B")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_DATA_ROAMING_SETTINGS =
            "android.settings.DATA_ROAMING_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.673 -0400", hash_original_field = "A9FC390F18B901563D372F3B1C45234B", hash_generated_field = "991BA9F0556092E8C022020DB49CF050")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_INTERNAL_STORAGE_SETTINGS =
            "android.settings.INTERNAL_STORAGE_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.673 -0400", hash_original_field = "58467E072F8085DAAD6A3771BDAF653F", hash_generated_field = "9114C57B1B31D4D36266D5840988DFA4")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_MEMORY_CARD_SETTINGS =
            "android.settings.MEMORY_CARD_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.673 -0400", hash_original_field = "31944FEF629AA2E886F491F950E91214", hash_generated_field = "612E2ADE94C5D1439222FBA63863BB07")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SEARCH_SETTINGS =
        "android.search.action.SEARCH_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.673 -0400", hash_original_field = "5D8D312F243A069BF5996F7C89F04200", hash_generated_field = "9B65D0366D61656ADBD4A551B8D5E287")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_DEVICE_INFO_SETTINGS =
        "android.settings.DEVICE_INFO_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.673 -0400", hash_original_field = "085BFE94D2B0AA85E2923769436B6DE4", hash_generated_field = "A3E074268BD269D0A2C84D260E3F1CB9")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_NFCSHARING_SETTINGS =
        "android.settings.NFCSHARING_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.673 -0400", hash_original_field = "7DB1C9182A8035A69B122F100F9E6786", hash_generated_field = "10C48E207BCC1D11F0157C2931EAD1DA")

    public static final String CALL_METHOD_GET_SYSTEM = "GET_system";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.673 -0400", hash_original_field = "D4992617AF66042F2FE7B55F00700ED2", hash_generated_field = "9F29BC105FB7A34DCE42B5192B7DA58B")

    public static final String CALL_METHOD_GET_SECURE = "GET_secure";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.674 -0400", hash_original_field = "19A13503301BADD68DD946C949B3428D", hash_generated_field = "115F2752CF91CE8BB4B451C26473D380")

    public static final String EXTRA_AUTHORITIES =
            "authorities";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.674 -0400", hash_original_field = "4F86A178C0534A425B9F37C943E817A8", hash_generated_field = "BE07686D6DDCE88474EBF79A4C1DA4BA")

    public static final String EXTRA_INPUT_METHOD_ID = "input_method_id";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.674 -0400", hash_original_field = "CE44FBEB51AA456A609AD1F7EC14E447", hash_generated_field = "60DD209E3682CBC18875FE018DF89859")

    private static final String JID_RESOURCE_PREFIX = "android";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.674 -0400", hash_original_field = "AD76BA408B046B6E926DBB97BA3B45C7", hash_generated_field = "CD4CCC4B63A1B6D8CDBF90B4044135B5")

    public static final String AUTHORITY = "settings";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.674 -0400", hash_original_field = "1FB3C2CC48C1240719DCE33A23898FBF", hash_generated_field = "DED9CEFD20FC00D326CC6FBA5A0A509B")

    private static final String TAG = "Settings";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.674 -0400", hash_original_field = "899D7C8D56392CD45C29EA5FFB061F9D", hash_generated_field = "D2585F3BB04C12E7EFFE278BED4DADF8")

    private static final boolean LOCAL_LOGV = false || false;
}

