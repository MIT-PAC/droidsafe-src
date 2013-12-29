package android.provider;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
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
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Log;





public final class Settings {

    /**
     * Returns the device ID that we should use when connecting to the mobile gtalk server.
     * This is a string like "android-0x1242", where the hex string is the Android ID obtained
     * from the GoogleLoginService.
     *
     * @param androidId The Android ID for this device.
     * @return The device ID that should be used when connecting to the mobile gtalk server.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.252 -0500", hash_original_method = "8B3803D6F4B33CAB905DD137BF81E092", hash_generated_method = "241E6E8D94A86CBDA619EC3D24D550FE")
    public static String getGTalkDeviceId(long androidId) {
        return "android-" + Long.toHexString(androidId);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:27.309 -0500", hash_original_field = "F52D50AC5FBA7EB56A3CAD2DA302FB0E", hash_generated_field = "9210D76982E0CCE119094FF576748A06")


    /**
     * Activity Action: Show system settings.
     * <p>
     * Input: Nothing.
     * <p>
     * Output: Nothing.
     */
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SETTINGS = "android.settings.SETTINGS";

    
    public static class SettingNotFoundException extends AndroidException {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.814 -0500", hash_original_method = "9D3DA3FD01BD65E9C8D44BD33E232128", hash_generated_method = "9CAD6371E48DA955B5974C157A71A1B7")
        public SettingNotFoundException(String msg) {
            super(msg);
        }

        
    }


    
    public static class NameValueTable implements BaseColumns {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.818 -0500", hash_original_method = "21FF82E299A7324E4B71C8146DBBBDA8", hash_generated_method = "41C125A427706602C0A78C0A1E970EA4")
        protected static boolean putString(ContentResolver resolver, Uri uri,
                String name, String value) {
            // The database will take care of replacing duplicates.
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.819 -0500", hash_original_method = "C630C296F5C357D60AA0A465458F1635", hash_generated_method = "EBD10A190A45E97629EFAC370345EAD4")
        public static Uri getUriFor(Uri uri, String name) {
            return Uri.withAppendedPath(uri, name);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.816 -0500", hash_original_field = "11F7D90F715D916A63D5FB3D55CA93F4", hash_generated_field = "8F5B94AE17AA8887EB81EF0FD5591FF7")

        public static final String NAME = "name";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.817 -0500", hash_original_field = "A2895FC88154CFB96E0F519FA521FF35", hash_generated_field = "5D8DAB0D387706C30A46713A8E60D5A3")

        public static final String VALUE = "value";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.672 -0400", hash_original_method = "FA7615754860C9050FE125371ADC3B8B", hash_generated_method = "FA7615754860C9050FE125371ADC3B8B")
        public NameValueTable ()
        {
            //Synthesized constructor
        }
    }


    
    private static class NameValueCache {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.822 -0500", hash_original_field = "3116B3BCEB63B81CD9E17B13B775EDFC", hash_generated_field = "23E47445004801DA0364F31D1E83BC51")


        private static final String[] SELECT_VALUE =
            new String[] { Settings.NameValueTable.VALUE };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.823 -0500", hash_original_field = "B3A2993D49BCD8B8E7CBF387DBB3F47C", hash_generated_field = "26B04325FB348644FBE33A5DD660F1BA")

        private static final String NAME_EQ_PLACEHOLDER = "name=?";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.821 -0500", hash_original_field = "F41A63E2E62C9D79CC9D89763ABAB2CC", hash_generated_field = "8053655979FC96B88F0F0DB849815BA8")

        private  String mVersionSystemProperty;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.821 -0500", hash_original_field = "49226456B4CE4E55A779249DE3DC63D4", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

        private  Uri mUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.824 -0500", hash_original_field = "20227DDE8FD14DAC2E83E5BDB38F9F82", hash_generated_field = "DB6F166C847159AF638BD64416B47EB4")

        private final HashMap<String, String> mValues = new HashMap<String, String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.825 -0500", hash_original_field = "3FD7267B1C80DE8D32AF045CE5B79D31", hash_generated_field = "FCE810A42FA561E1E083AE063834BBA4")

        private long mValuesVersion = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.826 -0500", hash_original_field = "FD4E2DB3DCA6BD4431EA21A78AD21342", hash_generated_field = "C581E09B51E89883758FAC86E652180C")

        private IContentProvider mContentProvider = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:27.365 -0500", hash_original_field = "50B69EB4924A87893048E1FE1E486C51", hash_generated_field = "98CF625DC55DCD9AFBDD248FBFD8D944")

        // for the fast path of retrieving settings.
        private  String mCallCommand;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.827 -0500", hash_original_method = "AA2EC60B6F4EA71E8A16119EB161E070", hash_generated_method = "F05120C049375539CD7FCC434594E224")
        public NameValueCache(String versionSystemProperty, Uri uri, String callCommand) {
            mVersionSystemProperty = versionSystemProperty;
            mUri = uri;
            mCallCommand = callCommand;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.829 -0500", hash_original_method = "30813ECB8D9A0346E7379ADA0BD790C8", hash_generated_method = "3F56C11F8B1D8391051310C80CA41A69")
        public String getString(ContentResolver cr, String name) {
            long newValuesVersion = SystemProperties.getLong(mVersionSystemProperty, 0);

            synchronized (this) {
                if (mValuesVersion != newValuesVersion) {
                    if (LOCAL_LOGV) {
                        Log.v(TAG, "invalidate [" + mUri.getLastPathSegment() + "]: current " +
                                newValuesVersion + " != cached " + mValuesVersion);
                    }

                    mValues.clear();
                    mValuesVersion = newValuesVersion;
                }

                if (mValues.containsKey(name)) {
                    return mValues.get(name);  // Could be null, that's OK -- negative caching
                }
            }

            IContentProvider cp = null;
            synchronized (this) {
                cp = mContentProvider;
                if (cp == null) {
                    cp = mContentProvider = cr.acquireProvider(mUri.getAuthority());
                }
            }

            // Try the fast path first, not using query().  If this
            // fails (alternate Settings provider that doesn't support
            // this interface?) then we fall back to the query/table
            // interface.
            if (mCallCommand != null) {
                try {
                    Bundle b = cp.call(mCallCommand, name, null);
                    if (b != null) {
                        String value = b.getPairValue();
                        synchronized (this) {
                            mValues.put(name, value);
                        }
                        return value;
                    }
                    // If the response Bundle is null, we fall through
                    // to the query interface below.
                } catch (RemoteException e) {
                    // Not supported by the remote side?  Fall through
                    // to query().
                }
            }

            Cursor c = null;
            try {
                c = cp.query(mUri, SELECT_VALUE, NAME_EQ_PLACEHOLDER,
                             new String[]{name}, null);
                if (c == null) {
                    Log.w(TAG, "Can't get key " + name + " from " + mUri);
                    return null;
                }

                String value = c.moveToNext() ? c.getString(0) : null;
                synchronized (this) {
                    mValues.put(name, value);
                }
                if (LOCAL_LOGV) {
                    Log.v(TAG, "cache miss [" + mUri.getLastPathSegment() + "]: " +
                            name + " = " + (value == null ? "(null)" : value));
                }
                return value;
            } catch (RemoteException e) {
                Log.w(TAG, "Can't get key " + name + " from " + mUri, e);
                return null;  // Return null, but don't cache it.
            } finally {
                if (c != null) c.close();
            }
        }
    }


    
    public static final class System extends NameValueTable {

        /**
         * Look up a name in the database.
         * @param resolver to access the database with
         * @param name to look up in the table
         * @return the corresponding value, or null if not present
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.835 -0500", hash_original_method = "BCE17AD551131F3C5B0199F6E8D71A65", hash_generated_method = "0E3882E2540A80A5533039D724BE4002")
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

        /**
         * Store a name/value pair into the database.
         * @param resolver to access the database with
         * @param name to store
         * @param value to associate with the name
         * @return true if the value was set, false on database errors
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.836 -0500", hash_original_method = "77FDB26F7E07396FBB2F925B9C6125A4", hash_generated_method = "EC73CBB8EAD727032252B9D5371705BD")
        public static boolean putString(ContentResolver resolver, String name, String value) {
            if (MOVED_TO_SECURE.contains(name)) {
                Log.w(TAG, "Setting " + name + " has moved from android.provider.Settings.System"
                        + " to android.provider.Settings.Secure, value is unchanged.");
                return false;
            }
            return putString(resolver, CONTENT_URI, name, value);
        }

        /**
         * Construct the content URI for a particular name/value pair,
         * useful for monitoring changes with a ContentObserver.
         * @param name to look up in the table
         * @return the corresponding content URI, or null if not present
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.837 -0500", hash_original_method = "B4A26DD7AFB6F0356A37068D3E87F288", hash_generated_method = "4DF70A8ABC36243ABA00FC2E52415B98")
        public static Uri getUriFor(String name) {
            if (MOVED_TO_SECURE.contains(name)) {
                Log.w(TAG, "Setting " + name + " has moved from android.provider.Settings.System"
                    + " to android.provider.Settings.Secure, returning Secure URI.");
                return Secure.getUriFor(Secure.CONTENT_URI, name);
            }
            return getUriFor(CONTENT_URI, name);
        }

        /**
         * Convenience function for retrieving a single system settings value
         * as an integer.  Note that internally setting values are always
         * stored as strings; this function converts the string to an integer
         * for you.  The default value will be returned if the setting is
         * not defined or not an integer.
         *
         * @param cr The ContentResolver to access.
         * @param name The name of the setting to retrieve.
         * @param def Value to return if the setting is not defined.
         *
         * @return The setting's current value, or 'def' if it is not defined
         * or not a valid integer.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.838 -0500", hash_original_method = "DBD93DA0568D4E47C40E6BFA100A1EF2", hash_generated_method = "6431710C35E8CCD460BB62DB2BBC4A9B")
        public static int getInt(ContentResolver cr, String name, int def) {
            String v = getString(cr, name);
            try {
                return v != null ? Integer.parseInt(v) : def;
            } catch (NumberFormatException e) {
                return def;
            }
        }

        /**
         * Convenience function for retrieving a single system settings value
         * as an integer.  Note that internally setting values are always
         * stored as strings; this function converts the string to an integer
         * for you.
         * <p>
         * This version does not take a default value.  If the setting has not
         * been set, or the string value is not a number,
         * it throws {@link SettingNotFoundException}.
         *
         * @param cr The ContentResolver to access.
         * @param name The name of the setting to retrieve.
         *
         * @throws SettingNotFoundException Thrown if a setting by the given
         * name can't be found or the setting value is not an integer.
         *
         * @return The setting's current value.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.839 -0500", hash_original_method = "BC1F410DCF7E88197DA27D0D425DD822", hash_generated_method = "65A02ED2DBB08389547A19AA8589B1B4")
        public static int getInt(ContentResolver cr, String name)
                throws SettingNotFoundException {
            String v = getString(cr, name);
            try {
                return Integer.parseInt(v);
            } catch (NumberFormatException e) {
                throw new SettingNotFoundException(name);
            }
        }

        /**
         * Convenience function for updating a single settings value as an
         * integer. This will either create a new entry in the table if the
         * given name does not exist, or modify the value of the existing row
         * with that name.  Note that internally setting values are always
         * stored as strings, so this function converts the given value to a
         * string before storing it.
         *
         * @param cr The ContentResolver to access.
         * @param name The name of the setting to modify.
         * @param value The new value for the setting.
         * @return true if the value was set, false on database errors
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.840 -0500", hash_original_method = "5F86FAE7117D2E108E68CEB80BF49DA7", hash_generated_method = "6ED7733ABB42EB8D1CAB516377E36AA4")
        public static boolean putInt(ContentResolver cr, String name, int value) {
            return putString(cr, name, Integer.toString(value));
        }

        /**
         * Convenience function for retrieving a single system settings value
         * as a {@code long}.  Note that internally setting values are always
         * stored as strings; this function converts the string to a {@code long}
         * for you.  The default value will be returned if the setting is
         * not defined or not a {@code long}.
         *
         * @param cr The ContentResolver to access.
         * @param name The name of the setting to retrieve.
         * @param def Value to return if the setting is not defined.
         *
         * @return The setting's current value, or 'def' if it is not defined
         * or not a valid {@code long}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.841 -0500", hash_original_method = "2986E5629421403DA55C169D77194DCA", hash_generated_method = "334B1526468744A2753D53DD17327221")
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

        /**
         * Convenience function for retrieving a single system settings value
         * as a {@code long}.  Note that internally setting values are always
         * stored as strings; this function converts the string to a {@code long}
         * for you.
         * <p>
         * This version does not take a default value.  If the setting has not
         * been set, or the string value is not a number,
         * it throws {@link SettingNotFoundException}.
         *
         * @param cr The ContentResolver to access.
         * @param name The name of the setting to retrieve.
         *
         * @return The setting's current value.
         * @throws SettingNotFoundException Thrown if a setting by the given
         * name can't be found or the setting value is not an integer.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.842 -0500", hash_original_method = "69C00B9492B59345A478AD340BB82560", hash_generated_method = "DEF6F194A9786A3EC928CD0D3E9ABD57")
        public static long getLong(ContentResolver cr, String name)
                throws SettingNotFoundException {
            String valString = getString(cr, name);
            try {
                return Long.parseLong(valString);
            } catch (NumberFormatException e) {
                throw new SettingNotFoundException(name);
            }
        }

        /**
         * Convenience function for updating a single settings value as a long
         * integer. This will either create a new entry in the table if the
         * given name does not exist, or modify the value of the existing row
         * with that name.  Note that internally setting values are always
         * stored as strings, so this function converts the given value to a
         * string before storing it.
         *
         * @param cr The ContentResolver to access.
         * @param name The name of the setting to modify.
         * @param value The new value for the setting.
         * @return true if the value was set, false on database errors
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.843 -0500", hash_original_method = "A37AC0F546410BFB8FB9B835A95E1AD0", hash_generated_method = "776F05CA560EFB9C0C763CBDB1EB98A5")
        public static boolean putLong(ContentResolver cr, String name, long value) {
            return putString(cr, name, Long.toString(value));
        }

        /**
         * Convenience function for retrieving a single system settings value
         * as a floating point number.  Note that internally setting values are
         * always stored as strings; this function converts the string to an
         * float for you. The default value will be returned if the setting
         * is not defined or not a valid float.
         *
         * @param cr The ContentResolver to access.
         * @param name The name of the setting to retrieve.
         * @param def Value to return if the setting is not defined.
         *
         * @return The setting's current value, or 'def' if it is not defined
         * or not a valid float.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.844 -0500", hash_original_method = "0D9E7A4535CB773913AB18AAD472FAE3", hash_generated_method = "3B5A88E4A2869809F140DF533B38E22D")
        public static float getFloat(ContentResolver cr, String name, float def) {
            String v = getString(cr, name);
            try {
                return v != null ? Float.parseFloat(v) : def;
            } catch (NumberFormatException e) {
                return def;
            }
        }

        /**
         * Convenience function for retrieving a single system settings value
         * as a float.  Note that internally setting values are always
         * stored as strings; this function converts the string to a float
         * for you.
         * <p>
         * This version does not take a default value.  If the setting has not
         * been set, or the string value is not a number,
         * it throws {@link SettingNotFoundException}.
         *
         * @param cr The ContentResolver to access.
         * @param name The name of the setting to retrieve.
         *
         * @throws SettingNotFoundException Thrown if a setting by the given
         * name can't be found or the setting value is not a float.
         *
         * @return The setting's current value.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.845 -0500", hash_original_method = "8F942018F858810492E264878914C1E0", hash_generated_method = "B4F108BE0DBD2F067C9CEB071B929767")
        public static float getFloat(ContentResolver cr, String name)
                throws SettingNotFoundException {
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

        /**
         * Convenience function for updating a single settings value as a
         * floating point number. This will either create a new entry in the
         * table if the given name does not exist, or modify the value of the
         * existing row with that name.  Note that internally setting values
         * are always stored as strings, so this function converts the given
         * value to a string before storing it.
         *
         * @param cr The ContentResolver to access.
         * @param name The name of the setting to modify.
         * @param value The new value for the setting.
         * @return true if the value was set, false on database errors
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.846 -0500", hash_original_method = "7C7CB2A2E239FDA02FE8F80A9EE7770A", hash_generated_method = "DFFDFDA6D89A1873E0163B25D5D32EAF")
        public static boolean putFloat(ContentResolver cr, String name, float value) {
            return putString(cr, name, Float.toString(value));
        }

        /**
         * Convenience function to read all of the current
         * configuration-related settings into a
         * {@link Configuration} object.
         *
         * @param cr The ContentResolver to access.
         * @param outConfig Where to place the configuration settings.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.847 -0500", hash_original_method = "3441F4800E5F4590193E9727722854D0", hash_generated_method = "CA07B71A7B303EEF0499F1C39F506351")
        public static void getConfiguration(ContentResolver cr, Configuration outConfig) {
            outConfig.fontScale = Settings.System.getFloat(
                cr, FONT_SCALE, outConfig.fontScale);
            if (outConfig.fontScale < 0) {
                outConfig.fontScale = 1;
            }
        }

        /**
         * @hide Erase the fields in the Configuration that should be applied
         * by the settings.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.848 -0500", hash_original_method = "B73938E08E789E74114DBF59F86C2CB2", hash_generated_method = "CCD285729676B3FCF20DE207B47440D9")
        public static void clearConfiguration(Configuration inoutConfig) {
            inoutConfig.fontScale = 0;
        }

        /**
         * Convenience function to write a batch of configuration-related
         * settings from a {@link Configuration} object.
         *
         * @param cr The ContentResolver to access.
         * @param config The settings to write.
         * @return true if the values were set, false on database errors
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.849 -0500", hash_original_method = "D58FF0184DFDAF7AB1234DB16705A709", hash_generated_method = "7FF98E9DB431AA9B44B4C794A2D2999E")
        public static boolean putConfiguration(ContentResolver cr, Configuration config) {
            return Settings.System.putFloat(cr, FONT_SCALE, config.fontScale);
        }

        /** @hide */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.849 -0500", hash_original_method = "C45518EFECA9F1C0734505050BA0E26B", hash_generated_method = "BCD67FD3B6F626FFD5F0A9F6D68C6E56")
        public static boolean hasInterestingConfigurationChanges(int changes) {
            return (changes&ActivityInfo.CONFIG_FONT_SCALE) != 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.850 -0500", hash_original_method = "1E8F844182FAFB552A3979783C673A64", hash_generated_method = "24E124FCC1ED56754477DEE8FC55F00E")
        public static boolean getShowGTalkServiceStatus(ContentResolver cr) {
            return getInt(cr, SHOW_GTALK_SERVICE_STATUS, 0) != 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.851 -0500", hash_original_method = "0CA3CDD297682AF780AE81001E5FE18D", hash_generated_method = "442A1C074A9C96D62DE3C91B02F7F082")
        public static void setShowGTalkServiceStatus(ContentResolver cr, boolean flag) {
            putInt(cr, SHOW_GTALK_SERVICE_STATUS, flag ? 1 : 0);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.832 -0500", hash_original_field = "1C86DFF5CAC5AA66A4FBFBCEDE41A2FA", hash_generated_field = "1F2456A83E929BCA3BB4607D01A844B2")

        public static final String SYS_PROP_SETTING_VERSION = "sys.settings_system_version";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.832 -0500", hash_original_field = "9FE679F762373D0396651F36B26F2D6D", hash_generated_field = "1FB09179C87042F649D2E6D9B8084B29")

        private static NameValueCache sNameValueCache = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.833 -0500", hash_original_field = "1AF9FB4FAE0D891C841A6BD0FF19066F", hash_generated_field = "A0CAC6ABE4414AB6B5026A67B764DC5F")


        private static  HashSet<String> MOVED_TO_SECURE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.852 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "73522F6CDB248227CBD6A2EE71CA3762")

        public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/system");
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.853 -0500", hash_original_field = "B685340E21E47D7E32207087DF753707", hash_generated_field = "3B2E2B5800656B6A77725DD672C46B9D")

        public static final String STAY_ON_WHILE_PLUGGED_IN = "stay_on_while_plugged_in";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.854 -0500", hash_original_field = "737820431EA7CE6FC3D5274ED506276F", hash_generated_field = "D21F2265B6B377D85FEA61AA7A6C9A91")

        public static final String END_BUTTON_BEHAVIOR = "end_button_behavior";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.855 -0500", hash_original_field = "91B023D4D1130E4E1D896616942E7F3F", hash_generated_field = "33485B813338885E3EF315E2C1B712E1")

        public static final int END_BUTTON_BEHAVIOR_HOME = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.856 -0500", hash_original_field = "4190DD5058327638FCC939E15797ABC3", hash_generated_field = "6D08D9D291225EF80FC4BA876AA9F0C3")

        public static final int END_BUTTON_BEHAVIOR_SLEEP = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.857 -0500", hash_original_field = "F9C88E42376AFB9D5121D1AD5B369BB9", hash_generated_field = "C289E4BFD362BFA530F26A20E383DB7E")

        public static final int END_BUTTON_BEHAVIOR_DEFAULT = END_BUTTON_BEHAVIOR_SLEEP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.858 -0500", hash_original_field = "639233F16BEEEAD54AD0CD0FA548FC0B", hash_generated_field = "DCFE63C3879CBA756C65B4B69ECD68F4")

        public static final String ADVANCED_SETTINGS = "advanced_settings";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.859 -0500", hash_original_field = "F3C9BAA71C98D80F67051F4D7A4EE44B", hash_generated_field = "019DCD45BE65B913274B5AA692F40655")

        public static final int ADVANCED_SETTINGS_DEFAULT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.860 -0500", hash_original_field = "C3299DEA62C98747B8A8B176249E9761", hash_generated_field = "55FCC9341703FB893FA281A80454844D")

        public static final String AIRPLANE_MODE_ON = "airplane_mode_on";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.861 -0500", hash_original_field = "932D435CDB03C6FDAFB1DC9CA5783195", hash_generated_field = "CBF14E37A49742B1762CB93C99D1D050")

        public static final String RADIO_BLUETOOTH = "bluetooth";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.862 -0500", hash_original_field = "6A767B38A86DA9EE832EEAD213B11DE4", hash_generated_field = "5DA0211CD66CB5F1D939CC5760E4080E")

        public static final String RADIO_WIFI = "wifi";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.863 -0500", hash_original_field = "E2A685B53006A9302B250061903F6F53", hash_generated_field = "E55D30F8015A4EDC205B488E73E9C3C7")

        public static final String RADIO_WIMAX = "wimax";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.864 -0500", hash_original_field = "D3DD275E2C360BA0F4F4FA75B28581DE", hash_generated_field = "F38D5CB83BC4823F9E7AAA66A6A55089")

        public static final String RADIO_CELL = "cell";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.864 -0500", hash_original_field = "FEF59473C4413AD68546364A6D8B8F36", hash_generated_field = "338A37CDF684AB581C516725556BEE8A")

        public static final String RADIO_NFC = "nfc";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.865 -0500", hash_original_field = "86203521C1E57377039134346FF626EB", hash_generated_field = "1A2C056412A23950C9E33244B1E272D9")

        public static final String AIRPLANE_MODE_RADIOS = "airplane_mode_radios";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.866 -0500", hash_original_field = "E3B1FC1A7351220DF232BAF2D5AA48E2", hash_generated_field = "3EC8431B0EF96E87AD69A440406FE4A8")

        public static final String AIRPLANE_MODE_TOGGLEABLE_RADIOS = "airplane_mode_toggleable_radios";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.867 -0500", hash_original_field = "A6D7F0E289EFB3BB8FE0ED9F5D5DD9F5", hash_generated_field = "9BBC5B7E7110FE2989D8236E94AB1FB4")

        public static final String WIFI_SLEEP_POLICY = "wifi_sleep_policy";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.868 -0500", hash_original_field = "B79E65977D3EB32625B84E5435E92613", hash_generated_field = "9398666E4F04883DE0E2BA9E9B23A686")

        public static final int WIFI_SLEEP_POLICY_DEFAULT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.869 -0500", hash_original_field = "1FC9506CB5AAEE25A0B0FCC91851810A", hash_generated_field = "D601B0CE6A4CF9504DCA251B695BCB5D")

        public static final int WIFI_SLEEP_POLICY_NEVER_WHILE_PLUGGED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.870 -0500", hash_original_field = "59023B9679BE389AD6CEE710011F2D2C", hash_generated_field = "5160D2E233690D463855E47C49032C56")

        public static final int WIFI_SLEEP_POLICY_NEVER = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:27.409 -0500", hash_original_field = "59015325BC4CBF5586BF14AFFC362731", hash_generated_field = "35FA0CAF887B0F1B8538EEB2BF7C4CC8")

        /**
         * Whether to use static IP and other static network attributes.
         * <p>
         * Set to 1 for true and 0 for false.
         */
        public static final String WIFI_USE_STATIC_IP = "wifi_use_static_ip";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.871 -0500", hash_original_field = "E9CF43845A99A8820636E5EDA5C4DCCB", hash_generated_field = "1E4EFCD82854CCE99527175CC3854DF6")

        public static final String WIFI_STATIC_IP = "wifi_static_ip";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.872 -0500", hash_original_field = "1CF0A4686FF0147D1F460C0E8EDECCDF", hash_generated_field = "FECB1DD251347D01F55DBAF2ADA7529A")

        public static final String WIFI_STATIC_GATEWAY = "wifi_static_gateway";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.873 -0500", hash_original_field = "8CA044B8A12EA765F662A26228618C3D", hash_generated_field = "FBF052DF0AC4A30D8CF16D40480FAEEB")

        public static final String WIFI_STATIC_NETMASK = "wifi_static_netmask";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.874 -0500", hash_original_field = "1AB64D861B2115F11120EF68CD2CE2D2", hash_generated_field = "7272D86506529066EF782D81CBCA730E")

        public static final String WIFI_STATIC_DNS1 = "wifi_static_dns1";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.876 -0500", hash_original_field = "E8AE90AAABDDCC55F021F67611DA68CC", hash_generated_field = "57F3E3F0D37260047223CE06C4BEDA7D")

        public static final String WIFI_STATIC_DNS2 = "wifi_static_dns2";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.877 -0500", hash_original_field = "6B1E5395C810E45905B9462FA2070B83", hash_generated_field = "6AEE36383AD19BB8C2CFB7DB3382DE3A")

        public static final String BLUETOOTH_DISCOVERABILITY =
            "bluetooth_discoverability";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.878 -0500", hash_original_field = "7F71711AEC036BA578E2D6F7A9A9D8AE", hash_generated_field = "A02A0ACCF4F67A363B9410B52CAC2860")

        public static final String BLUETOOTH_DISCOVERABILITY_TIMEOUT =
            "bluetooth_discoverability_timeout";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.879 -0500", hash_original_field = "91F2A3B5EFC0515A6E9CEA8BC08CF1A9", hash_generated_field = "F30D5A0D770F1446E17D6B9D5CF508C6")

        @Deprecated
        public static final String LOCK_PATTERN_ENABLED = Secure.LOCK_PATTERN_ENABLED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.880 -0500", hash_original_field = "AA79CEC039827029BFDB607AD7563322", hash_generated_field = "AFE220E0B57AC087ECB648638461E9AD")

        @Deprecated
        public static final String LOCK_PATTERN_VISIBLE = "lock_pattern_visible_pattern";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.881 -0500", hash_original_field = "EA106DCD904E84527E48323B260C9CAC", hash_generated_field = "AAF77AB120C25C0B3F1F1757970361DD")

        @Deprecated
        public static final String LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED =
            "lock_pattern_tactile_feedback_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.882 -0500", hash_original_field = "7FEAFAED92964349FEE35EAEF693FEE6", hash_generated_field = "C640615D90700F02DD2DA4540447D2AB")

        public static final String NEXT_ALARM_FORMATTED = "next_alarm_formatted";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.883 -0500", hash_original_field = "CECEBCE40D1953BD353517C486A9AA32", hash_generated_field = "B84405F90D1542D338C2CB78CC887DF4")

        public static final String FONT_SCALE = "font_scale";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.884 -0500", hash_original_field = "052593A70B2F66B2A69C23862776D9D4", hash_generated_field = "1FDB5EBD482132808AEC2C0FCF91119B")

        public static final String DEBUG_APP = "debug_app";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.885 -0500", hash_original_field = "9510F2C7661362794420C972CFED6399", hash_generated_field = "45DB8334ACF69D8BDC0273CC28951085")

        public static final String WAIT_FOR_DEBUGGER = "wait_for_debugger";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.885 -0500", hash_original_field = "DD9710918966C37449F92BD69910C21C", hash_generated_field = "21DD68ACF771DA87FB12656C7D9ECEAE")

        public static final String DIM_SCREEN = "dim_screen";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.886 -0500", hash_original_field = "E56B2D3DA3BC20D392786D4D6DFE64F8", hash_generated_field = "F67F87D993A243B0D391C3B0D02FD748")

        public static final String SCREEN_OFF_TIMEOUT = "screen_off_timeout";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.887 -0500", hash_original_field = "3FB7859CEEC23525AB93564A20C0E5D0", hash_generated_field = "1F164A6095C276D0D8923DF60512CCA0")

        public static final String COMPATIBILITY_MODE = "compatibility_mode";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.888 -0500", hash_original_field = "EB6E77510D44DF5E6A49B8CA304CBACB", hash_generated_field = "CE544C9E0C810697AC7204FCED554A71")

        public static final String SCREEN_BRIGHTNESS = "screen_brightness";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.889 -0500", hash_original_field = "56D19021F3555AF4DF7AB133C68F21F9", hash_generated_field = "69C67F5DC39ABF90E401738745A78A04")

        public static final String SCREEN_BRIGHTNESS_MODE = "screen_brightness_mode";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.890 -0500", hash_original_field = "E0B1F61F216BA7E0A2EB89A36F96E8F6", hash_generated_field = "18509F5406C47F14229896FAD98E0FE4")

        public static final int SCREEN_BRIGHTNESS_MODE_MANUAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.891 -0500", hash_original_field = "2F440E3DD8BBF529640A275CD4A89125", hash_generated_field = "4D1C057868E93087553CD0CBA218E4B0")

        public static final int SCREEN_BRIGHTNESS_MODE_AUTOMATIC = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.892 -0500", hash_original_field = "78A8526C92D10788798566A67FBF0CCE", hash_generated_field = "B29ACF97250EE696921D7D0F0E55355A")

        public static final String SHOW_PROCESSES = "show_processes";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.893 -0500", hash_original_field = "89E7F5232A0353413A0CE759D9875C08", hash_generated_field = "2707C925F43197F607FC371112C84589")

        public static final String ALWAYS_FINISH_ACTIVITIES =
                "always_finish_activities";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.894 -0500", hash_original_field = "5E7D896F0870B297E5E77C6B07427103", hash_generated_field = "697A87B302F7C66E2B6B04A5DA9D7B26")

        public static final String MODE_RINGER = "mode_ringer";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.895 -0500", hash_original_field = "08348376C584F40F8136F041533814FB", hash_generated_field = "CCA369CA013A98B69BCBBB78922ADAF4")

        public static final String MODE_RINGER_STREAMS_AFFECTED = "mode_ringer_streams_affected";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.896 -0500", hash_original_field = "39A4B7CF675EC99598053D3AA7F2E83E", hash_generated_field = "1B76396DE9FFA2C1F64A1ACE233E9A4F")

         public static final String MUTE_STREAMS_AFFECTED = "mute_streams_affected";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.897 -0500", hash_original_field = "2104EF052364E46C7C90188DF50A5C97", hash_generated_field = "8F1B8BD1575869A8CADF68D51B171CC2")

        public static final String VIBRATE_ON = "vibrate_on";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.898 -0500", hash_original_field = "5E82654C81024FF741C868DF1AE0B588", hash_generated_field = "1362364C056D246C2E8E42AA5C45BB29")

        public static final String VOLUME_RING = "volume_ring";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.898 -0500", hash_original_field = "241DA708395B708D7BB37703DA67CE9E", hash_generated_field = "EED8CAB1845CC1C2509B015FDC6BEC23")

        public static final String VOLUME_SYSTEM = "volume_system";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.899 -0500", hash_original_field = "ABDADE01E940FA8EEFCBD341B31DBC62", hash_generated_field = "E0EA9784F9797B7C50DF8CA47CE0112F")

        public static final String VOLUME_VOICE = "volume_voice";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.900 -0500", hash_original_field = "C8256C3FCDF8AB1BC7AD55A09C4FAFF4", hash_generated_field = "1DE966C9806D54EEC941F957598EC0AE")

        public static final String VOLUME_MUSIC = "volume_music";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.901 -0500", hash_original_field = "B966E1C7A868FDEB4374D9CD8824F612", hash_generated_field = "E722A903F81918154C66CD7BD30730E9")

        public static final String VOLUME_ALARM = "volume_alarm";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.902 -0500", hash_original_field = "B7E0FA7C3ABD7707F5C69073C7C26DF1", hash_generated_field = "D78E22DA48A62C766FB2ECB47A0B003E")

        public static final String VOLUME_NOTIFICATION = "volume_notification";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.903 -0500", hash_original_field = "FEAAE581FF9073C24D305C873A8959B9", hash_generated_field = "C2B31D6FAA5CF59AB74C4EDE2CC028E3")

        public static final String VOLUME_BLUETOOTH_SCO = "volume_bluetooth_sco";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.904 -0500", hash_original_field = "A51DFC9217E96FE362D524CE7669734B", hash_generated_field = "4AF062B7F6928290D96C0F960388552A")

        @Deprecated
        public static final String NOTIFICATIONS_USE_RING_VOLUME =
            "notifications_use_ring_volume";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.905 -0500", hash_original_field = "993ABE091B1210622F51CA3047CACA3B", hash_generated_field = "3C213BB0E7B1489277A1BC3C5C3B8C50")

        public static final String VIBRATE_IN_SILENT = "vibrate_in_silent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.906 -0500", hash_original_field = "5A29143699E675A2AA5ABF11227C9152", hash_generated_field = "7FD1FFC876A892626BE17FA0121ABC35")

        public static final String[] VOLUME_SETTINGS = {
            VOLUME_VOICE, VOLUME_SYSTEM, VOLUME_RING, VOLUME_MUSIC,
            VOLUME_ALARM, VOLUME_NOTIFICATION, VOLUME_BLUETOOTH_SCO
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.907 -0500", hash_original_field = "4178AF3506D3A47071AEF257A58BCBBE", hash_generated_field = "A875CBA60C614DB5A2ACF4410B47ED48")

        public static final String APPEND_FOR_LAST_AUDIBLE = "_last_audible";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.908 -0500", hash_original_field = "16F8920354A43ADA99E6B2D46C405745", hash_generated_field = "B4AEB4F09B891C9CD1A27425B662A163")

        public static final String RINGTONE = "ringtone";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.909 -0500", hash_original_field = "32B073B1E3B6385FE71F16B18F566C12", hash_generated_field = "A8BB7CFDF81BA379E1C7D108199ADFFD")

        public static final Uri DEFAULT_RINGTONE_URI = getUriFor(RINGTONE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.910 -0500", hash_original_field = "80D1AD0CEF5D8CF72C8F18DF596C02C3", hash_generated_field = "AF51286C7034DC1CA7310637E31C750C")

        public static final String NOTIFICATION_SOUND = "notification_sound";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.911 -0500", hash_original_field = "4778327DBBF2A41ADD56F7D281688561", hash_generated_field = "9199AB0B8E91A11AAD0346F35198C71A")

        public static final Uri DEFAULT_NOTIFICATION_URI = getUriFor(NOTIFICATION_SOUND);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.912 -0500", hash_original_field = "84D842C6B1BCD3154D555DDC90C93039", hash_generated_field = "6C2249FC5A25A16B22A7668926A26E88")

        public static final String ALARM_ALERT = "alarm_alert";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.913 -0500", hash_original_field = "793C7EFA94AB32A4EC6D524B41A7CB39", hash_generated_field = "E31F51BB248AADF4730DC0D2E08FAAEB")

        public static final Uri DEFAULT_ALARM_ALERT_URI = getUriFor(ALARM_ALERT);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.913 -0500", hash_original_field = "9BA54997536E18C6F33B991169F306BE", hash_generated_field = "35A7CD5A1839B7D8C1DBB044A624DE37")

        public static final String MEDIA_BUTTON_RECEIVER = "media_button_receiver";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.914 -0500", hash_original_field = "15FEAE6251A2C3AE53B20A61C9AFE251", hash_generated_field = "D82B22C42E5D8BE4795122310CD7ED28")

        public static final String TEXT_AUTO_REPLACE = "auto_replace";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.915 -0500", hash_original_field = "261D4601B9084B0BAA130BE6FB0D51FD", hash_generated_field = "9788CD283DFEAEB4942605075DDDF378")

        public static final String TEXT_AUTO_CAPS = "auto_caps";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.916 -0500", hash_original_field = "F95E617C04FA500AF861577C3E351B5E", hash_generated_field = "43A4C86E305A5C2124FD2FFD9732F39B")

        public static final String TEXT_AUTO_PUNCTUATE = "auto_punctuate";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.917 -0500", hash_original_field = "9F12F47B69C8624F0747E3C62C379FE9", hash_generated_field = "4F1F16DE8368FD02C00EFC0E9B76FE8D")

        public static final String TEXT_SHOW_PASSWORD = "show_password";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.918 -0500", hash_original_field = "D659AF15FF3BA97B7319BAFC135E06A9", hash_generated_field = "334EEAA225578A6C1A6482FC1D36E631")


        public static final String SHOW_GTALK_SERVICE_STATUS =
                "SHOW_GTALK_SERVICE_STATUS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.919 -0500", hash_original_field = "B072BED0579E0C52B20C28651E0B1E16", hash_generated_field = "275DAC983B63898C2E3B05CE4B27AEEC")

        public static final String WALLPAPER_ACTIVITY = "wallpaper_activity";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.920 -0500", hash_original_field = "051A98DDACC108CC730E0AA84759688B", hash_generated_field = "E39CF0E244C018A254795F9D4E92EE65")

        public static final String AUTO_TIME = "auto_time";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.921 -0500", hash_original_field = "F19E344E26973462482D87463BC1E895", hash_generated_field = "B4F7710466D6D99F54C519D0E089EAAB")

        public static final String AUTO_TIME_ZONE = "auto_time_zone";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.922 -0500", hash_original_field = "4133602BE81F78AF2A95DF4B2E003E2E", hash_generated_field = "E3D405036DB50DFB5BFA3DEA26F62E8E")

        public static final String TIME_12_24 = "time_12_24";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.923 -0500", hash_original_field = "6F219882EB9BFA12705A9C1ABB506CD2", hash_generated_field = "EAE805229AAAB849CC5ED1DB337B57E1")

        public static final String DATE_FORMAT = "date_format";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.924 -0500", hash_original_field = "0D5F715AEA8029358BBF3E8CB17383B3", hash_generated_field = "C532E6AB48FB115C2F70980B54E148FC")

        public static final String SETUP_WIZARD_HAS_RUN = "setup_wizard_has_run";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.925 -0500", hash_original_field = "7EE779513A134AC1CBEC200EBA63DFDD", hash_generated_field = "965EB588E008DCD4109E38F001F2DD98")

        public static final String WINDOW_ANIMATION_SCALE = "window_animation_scale";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.926 -0500", hash_original_field = "CFB0102E0B6859AA53685D7570F681E3", hash_generated_field = "B7BE6330A9FC454CF7AEFBBC6CDA8D8F")

        public static final String TRANSITION_ANIMATION_SCALE = "transition_animation_scale";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.927 -0500", hash_original_field = "E9B126802AD2C8380F8026CCFBDE1FDE", hash_generated_field = "58D1E5725821B6F62A3AB3FA8F3F2119")

        public static final String FANCY_IME_ANIMATIONS = "fancy_ime_animations";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.928 -0500", hash_original_field = "0F2FF6FE312BE2FD962087D78398C4FE", hash_generated_field = "796406544C593ABF78D1D0B68837CC1A")

        public static final String ACCELEROMETER_ROTATION = "accelerometer_rotation";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.929 -0500", hash_original_field = "0F3FFE5F7D0540F4E6679C5C523DC2C5", hash_generated_field = "BF9E8128DB5F902333F910DDB3B51E11")

        public static final String USER_ROTATION = "user_rotation";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.930 -0500", hash_original_field = "C59C475A19915A4DEEDA870A082D3359", hash_generated_field = "515D9C36110F1E78727EB3509BDD30F1")

        public static final String DTMF_TONE_WHEN_DIALING = "dtmf_tone";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.930 -0500", hash_original_field = "9078947992A6BAF4B437D5F522A1E85F", hash_generated_field = "EDD874E2569CF564C9BDB60196A6FACE")

        public static final String DTMF_TONE_TYPE_WHEN_DIALING = "dtmf_tone_type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.931 -0500", hash_original_field = "87B8547848A8442191177D8B57FC77FB", hash_generated_field = "CCEA6D5F67FAAC4278F9567DD9326A34")

        public static final String EMERGENCY_TONE = "emergency_tone";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.932 -0500", hash_original_field = "625C5BA8C19CE7A59859F1DCB40A343D", hash_generated_field = "2C1251730E3D408EC520BD06F166F7A6")

        public static final String CALL_AUTO_RETRY = "call_auto_retry";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.933 -0500", hash_original_field = "A86B03E16D234174B615474544C95EA9", hash_generated_field = "AD43FDDF5B448DB6AA9B6D199DBC847A")

        public static final String HEARING_AID = "hearing_aid";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.934 -0500", hash_original_field = "237AD0A79DCCBF77696E5258D782D9EC", hash_generated_field = "032865E4B4AC984A1F7B2029ACCB1205")

        public static final String TTY_MODE = "tty_mode";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.935 -0500", hash_original_field = "CCAEEB2312B6E3048877A2E0A774AAB5", hash_generated_field = "CFEFED556580674602B9ADF1DCFBB414")

        public static final String SOUND_EFFECTS_ENABLED = "sound_effects_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.936 -0500", hash_original_field = "8D0141ACB5B75C8ABF530D4E7CB3AFE0", hash_generated_field = "6871D81DAA2B1FB3C71F0EAB219E9FE9")

        public static final String HAPTIC_FEEDBACK_ENABLED = "haptic_feedback_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.937 -0500", hash_original_field = "C1D4D7647AAFCFE945D999AD82234E78", hash_generated_field = "D35E17F6DD33A76EDBA58FF1A62D1D35")

        @Deprecated
        public static final String SHOW_WEB_SUGGESTIONS = "show_web_suggestions";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.938 -0500", hash_original_field = "25789B5E3081CCE979720BAA61566B37", hash_generated_field = "38A84262B3C034871EC44AAC84C5C42C")

        public static final String NOTIFICATION_LIGHT_PULSE = "notification_light_pulse";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.939 -0500", hash_original_field = "CB840789670E87441F8C5E25594CCD90", hash_generated_field = "832AB6C8EEA7F531FC912360D588124C")

        public static final String POINTER_LOCATION = "pointer_location";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.940 -0500", hash_original_field = "659608B2A2E1C683F9C05BDF3306A091", hash_generated_field = "BAC322C0405CFBC41F9E81B438CCD8FC")

        public static final String SHOW_TOUCHES = "show_touches";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.940 -0500", hash_original_field = "016F7F2F6EA12EB30A4E18453C9756BF", hash_generated_field = "BE99F9E2CBEABE6F49AC4E6F1CB2D423")

        public static final String WINDOW_ORIENTATION_LISTENER_LOG =
                "window_orientation_listener_log";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.941 -0500", hash_original_field = "62CBC91116E4E583FB7469A3E40FCA9C", hash_generated_field = "E805AECE657E431A64EBF81DC4423056")

        public static final String POWER_SOUNDS_ENABLED = "power_sounds_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.942 -0500", hash_original_field = "A137880AF98AB90410209B1DF023FEB8", hash_generated_field = "889562242653E6291B87AF97B8C19DF6")

        public static final String DOCK_SOUNDS_ENABLED = "dock_sounds_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.943 -0500", hash_original_field = "FA3C0913360FE43BD82F8221CD6260CC", hash_generated_field = "36FBE565E204CB8FB57F85C0D58F661A")

        public static final String LOCKSCREEN_SOUNDS_ENABLED = "lockscreen_sounds_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.944 -0500", hash_original_field = "63B65212A93425051B1291A96FD035D0", hash_generated_field = "2B4E7FEFDD7371085EE84BA75CD7C2F8")

        public static final String LOW_BATTERY_SOUND = "low_battery_sound";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.945 -0500", hash_original_field = "3E674ABA0600B83B4F5B06DD38DE426D", hash_generated_field = "80ECE9F8420D23D29962B5EFDFB38034")

        public static final String DESK_DOCK_SOUND = "desk_dock_sound";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.946 -0500", hash_original_field = "FE6E62C07651CBA9F1703A7BDF70C276", hash_generated_field = "92BE150247669CE4FAB596BBB85654C4")

        public static final String DESK_UNDOCK_SOUND = "desk_undock_sound";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.947 -0500", hash_original_field = "FAE38E89A94C2CA1F1C634A5C0E0AB0A", hash_generated_field = "54C3CF9DFEAD69AFDA16F76FC712CCBA")

        public static final String CAR_DOCK_SOUND = "car_dock_sound";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.948 -0500", hash_original_field = "364FBFC11356F64DE7311560D3D5B380", hash_generated_field = "8EFAFA8B52DC8A5913610F73524B1349")

        public static final String CAR_UNDOCK_SOUND = "car_undock_sound";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.949 -0500", hash_original_field = "8855F9BDAC672C7E09CDC85BD6378BFE", hash_generated_field = "59EF24D009976CB270ACA55DAB87EFB2")

        public static final String LOCK_SOUND = "lock_sound";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.950 -0500", hash_original_field = "3893EE7194D6E6EAC9566608DCE055F3", hash_generated_field = "D8E4D2E810E643DBCBA6FD530A4DA764")

        public static final String UNLOCK_SOUND = "unlock_sound";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.951 -0500", hash_original_field = "E7CCE088FB0203338B03A216C0F43502", hash_generated_field = "438FB5B96B314E9DC89AC19DB30A6176")

        public static final String SIP_RECEIVE_CALLS = "sip_receive_calls";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.952 -0500", hash_original_field = "1FBA5124CCA38BC9B22164A7577439E6", hash_generated_field = "2ADA62A9D843DB5B49435E578FCDA034")

        public static final String SIP_CALL_OPTIONS = "sip_call_options";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.953 -0500", hash_original_field = "D0E163A960DAE37C0759EC82097BB77A", hash_generated_field = "D52129CEEF65BC08652E9F3C6253D7A7")

        public static final String SIP_ALWAYS = "SIP_ALWAYS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.954 -0500", hash_original_field = "E5A5BFB1CBD576B68BFE6D483B403AEB", hash_generated_field = "9A4F09A2753BAFDF7EF040996465B130")

        public static final String SIP_ADDRESS_ONLY = "SIP_ADDRESS_ONLY";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.954 -0500", hash_original_field = "B1B41A53EA01D9A406B17B46E1DB36E4", hash_generated_field = "D51355F143487EFABF5EB9267AACBEA2")

        public static final String SIP_ASK_ME_EACH_TIME = "SIP_ASK_ME_EACH_TIME";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.955 -0500", hash_original_field = "30430A4AC4FE2C7BFE95FF8BBC3938A4", hash_generated_field = "D1002FCCEB2A459ED87837D55D219225")

        public static final String POINTER_SPEED = "pointer_speed";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.957 -0500", hash_original_field = "88A5F2C1C6A2D1A848AB8673B55A0C83", hash_generated_field = "73B6208EBA22CAE48882CDE3F75B564C")

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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:27.497 -0500", hash_original_field = "1B0AE811C9E38D83E312E0942328683D", hash_generated_field = "6CC623763E98C14C6A6666840BD94A2E")


        /**
         * @deprecated Use {@link android.provider.Settings.Secure#ADB_ENABLED}
         * instead
         */
        @Deprecated
        public static final String ADB_ENABLED = Secure.ADB_ENABLED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.958 -0500", hash_original_field = "B7049127B4DA9F8907E32B37FB404C6F", hash_generated_field = "0ACA16E81EE87596F1A2FFBA6DD48242")

        @Deprecated
        public static final String ANDROID_ID = Secure.ANDROID_ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.959 -0500", hash_original_field = "53E2EEA5CB8EB0D058B4D5BF0DB7EFDF", hash_generated_field = "5BDEA47CA3E299AEF8AACFE651DBEE01")

        @Deprecated
        public static final String BLUETOOTH_ON = Secure.BLUETOOTH_ON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.960 -0500", hash_original_field = "25682C9B443886D11F6486D463C33E05", hash_generated_field = "0FE5D4BDC7C499B7F1172E65323BA8E7")

        @Deprecated
        public static final String DATA_ROAMING = Secure.DATA_ROAMING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.961 -0500", hash_original_field = "629CEC5F17484D755A1825843071DD08", hash_generated_field = "6434C83044DE325459C0115B4E171696")

        @Deprecated
        public static final String DEVICE_PROVISIONED = Secure.DEVICE_PROVISIONED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.962 -0500", hash_original_field = "5902C1B8285182C85E1108BA7A6273C8", hash_generated_field = "935644B669D7B0487AC9F277F906F853")

        @Deprecated
        public static final String HTTP_PROXY = Secure.HTTP_PROXY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.963 -0500", hash_original_field = "57EC989AE96D3C3E7E1CFD5E23E6C02A", hash_generated_field = "06F7310B2EB8C2A093DD1D2EBE163C9A")

        @Deprecated
        public static final String INSTALL_NON_MARKET_APPS = Secure.INSTALL_NON_MARKET_APPS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.964 -0500", hash_original_field = "F4E612170C520813C086DD66F9D6A247", hash_generated_field = "0A47C5F6758DE070D1DCA29C59F9E265")

        @Deprecated
        public static final String LOCATION_PROVIDERS_ALLOWED = Secure.LOCATION_PROVIDERS_ALLOWED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.965 -0500", hash_original_field = "79430AD94B637054BB145BB1965CC74B", hash_generated_field = "D6506E36F2AD0960E5DC34B8B87277A0")

        @Deprecated
        public static final String LOGGING_ID = Secure.LOGGING_ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.967 -0500", hash_original_field = "9497152C8A937F342AD64911ECA7FEAD", hash_generated_field = "0A037DD0966AF59BCF3DB4CA35F6FBC3")

        @Deprecated
        public static final String NETWORK_PREFERENCE = Secure.NETWORK_PREFERENCE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.968 -0500", hash_original_field = "BAFDD22C320E42E9F0FD80FDA702D264", hash_generated_field = "84796F1553CBE4E8CF2A3D4F4DFFDA28")

        @Deprecated
        public static final String PARENTAL_CONTROL_ENABLED = Secure.PARENTAL_CONTROL_ENABLED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.969 -0500", hash_original_field = "F29070127196EFA9B9D1FB611E16B301", hash_generated_field = "FA7155D8AB592E1F40EBA66EEA30E8E1")

        @Deprecated
        public static final String PARENTAL_CONTROL_LAST_UPDATE = Secure.PARENTAL_CONTROL_LAST_UPDATE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.970 -0500", hash_original_field = "5FF8AF5209D4CED96AA3DEEFE9496651", hash_generated_field = "F4603F47EAC6A39F83D0AFD232782310")

        @Deprecated
        public static final String PARENTAL_CONTROL_REDIRECT_URL =
            Secure.PARENTAL_CONTROL_REDIRECT_URL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.971 -0500", hash_original_field = "2C65B0F06ABE7F8B94BB918009E590A0", hash_generated_field = "89669DEF771A099EEBAF3DA9E1E1EA61")

        @Deprecated
        public static final String SETTINGS_CLASSNAME = Secure.SETTINGS_CLASSNAME;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.972 -0500", hash_original_field = "7BB906890585CDD3160FF7EE611A4B17", hash_generated_field = "850ECA04CC143293B0DB760696152F0C")

        @Deprecated
        public static final String USB_MASS_STORAGE_ENABLED = Secure.USB_MASS_STORAGE_ENABLED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.973 -0500", hash_original_field = "745AD326A31B83C9C0A9E6B3151EDA03", hash_generated_field = "0A185F50A9A1FF26C7C0DC336E0B8FFF")

        @Deprecated
        public static final String USE_GOOGLE_MAIL = Secure.USE_GOOGLE_MAIL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.974 -0500", hash_original_field = "226DD742C8C8C24FD060BE01F7907757", hash_generated_field = "9031BD4C95FD17A73104ACE3E6507B25")

        @Deprecated
        public static final String WIFI_MAX_DHCP_RETRY_COUNT = Secure.WIFI_MAX_DHCP_RETRY_COUNT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.975 -0500", hash_original_field = "8A2517B3B31579EFF2FD95B0B9C003D1", hash_generated_field = "3CDFF6C4CAF8771B42470D4218DFE245")

        @Deprecated
        public static final String WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS =
                Secure.WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.976 -0500", hash_original_field = "F3F905BE50E8D12A58808D51B7A9C54D", hash_generated_field = "741892A65B2970566BD781F31FCE550E")

        @Deprecated
        public static final String WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON =
            Secure.WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.977 -0500", hash_original_field = "5812255D9D4AD0C239226DC9DB513C90", hash_generated_field = "7D93E709DF63AE53BD5A1D9EB429CBBF")

        @Deprecated
        public static final String WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY =
            Secure.WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.978 -0500", hash_original_field = "F58306FF7624EF9F033D0EA929467CCF", hash_generated_field = "EDE996AE1E1BBE951325E134337F729E")

        @Deprecated
        public static final String WIFI_NUM_OPEN_NETWORKS_KEPT = Secure.WIFI_NUM_OPEN_NETWORKS_KEPT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.979 -0500", hash_original_field = "0869947E3948D9010740D9BEC1D803AB", hash_generated_field = "23851BA4096DF5768F88F4BD0B4C5584")

        @Deprecated
        public static final String WIFI_ON = Secure.WIFI_ON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.980 -0500", hash_original_field = "B9202CD08C3092744DBD8FBFD7815ACF", hash_generated_field = "8729494C56A2EA11C4E4598BD13E3F03")

        @Deprecated
        public static final String WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE =
                Secure.WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.981 -0500", hash_original_field = "84CFEF5B24115B00C6449F898599A37D", hash_generated_field = "6C2680ED58B98431580917E9714EA9D2")

        @Deprecated
        public static final String WIFI_WATCHDOG_AP_COUNT = Secure.WIFI_WATCHDOG_AP_COUNT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.982 -0500", hash_original_field = "925F90299E8377BAA1517A585DEE8A07", hash_generated_field = "BE0C5BF1C4CDC0AF6521399A8AB6C9F5")

        @Deprecated
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS =
                Secure.WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.983 -0500", hash_original_field = "1C6ACBBEFDBE52EBDCF7E69591AD7312", hash_generated_field = "2049D8D0AB5D47AE5A38B87A22E183BD")

        @Deprecated
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED =
                Secure.WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.984 -0500", hash_original_field = "978DF84361AAA3E8F41EDD85F6F351FE", hash_generated_field = "E4A8E74F10B07727F0D2314EA91DE0DA")

        @Deprecated
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS =
                Secure.WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.985 -0500", hash_original_field = "9FA16F35DE56D73BD874189A86F57127", hash_generated_field = "88BA451BBD486A2495B5907AE94E9469")

        @Deprecated
        public static final String WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT =
            Secure.WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.986 -0500", hash_original_field = "A1A758B33DAFD14B38F30FAE854F9AF6", hash_generated_field = "C28BFA31098F58B246DC1CCF7C25B7FF")

        @Deprecated
        public static final String WIFI_WATCHDOG_MAX_AP_CHECKS = Secure.WIFI_WATCHDOG_MAX_AP_CHECKS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.987 -0500", hash_original_field = "094EFF522842CC2C0981605BF69888B1", hash_generated_field = "FFCB4171F06B714155340312C28397EF")

        @Deprecated
        public static final String WIFI_WATCHDOG_ON = Secure.WIFI_WATCHDOG_ON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.988 -0500", hash_original_field = "FE9C9EE0374B355BA92892E05B4732BB", hash_generated_field = "32667D9B2087E39F8C8F05313D8E2B50")

        @Deprecated
        public static final String WIFI_WATCHDOG_PING_COUNT = Secure.WIFI_WATCHDOG_PING_COUNT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.989 -0500", hash_original_field = "EB61DA9E79C2529A8D4EA1033D8F2554", hash_generated_field = "B7303EA32D313DB0D78425480DE7D828")

        @Deprecated
        public static final String WIFI_WATCHDOG_PING_DELAY_MS = Secure.WIFI_WATCHDOG_PING_DELAY_MS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.990 -0500", hash_original_field = "F55143B6DEC725843B9B9889AEFD7FB8", hash_generated_field = "55A102E3F7D2A23C71E2DE953B72AC49")

        @Deprecated
        public static final String WIFI_WATCHDOG_PING_TIMEOUT_MS =
            Secure.WIFI_WATCHDOG_PING_TIMEOUT_MS;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.692 -0400", hash_original_method = "FCC05FCD4F95F74464895D80CA2398E6", hash_generated_method = "FCC05FCD4F95F74464895D80CA2398E6")
        @DSModeled(DSC.SPEC)
        public System ()
        {
            //Synthesized constructor
        }
    }


    
    public static final class Secure extends NameValueTable {

        /**
         * Look up a name in the database.
         * @param resolver to access the database with
         * @param name to look up in the table
         * @return the corresponding value, or null if not present
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.998 -0500", hash_original_method = "673ACF52738B2550EB82A63F524A794C", hash_generated_method = "DF23D5CD90F7627E0234D522B83FB549")
        public synchronized static String getString(ContentResolver resolver, String name) {
            if (sNameValueCache == null) {
                sNameValueCache = new NameValueCache(SYS_PROP_SETTING_VERSION, CONTENT_URI,
                                                     CALL_METHOD_GET_SECURE);
            }
            return sNameValueCache.getString(resolver, name);
        }

        /**
         * Store a name/value pair into the database.
         * @param resolver to access the database with
         * @param name to store
         * @param value to associate with the name
         * @return true if the value was set, false on database errors
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.999 -0500", hash_original_method = "0140B0C084561EBE6D9CB9F916362E53", hash_generated_method = "2E5FD5211A5DBC3FA7DD1C6845765FB6")
        public static boolean putString(ContentResolver resolver,
                String name, String value) {
            return putString(resolver, CONTENT_URI, name, value);
        }

        /**
         * Construct the content URI for a particular name/value pair,
         * useful for monitoring changes with a ContentObserver.
         * @param name to look up in the table
         * @return the corresponding content URI, or null if not present
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.000 -0500", hash_original_method = "6094EDC02DB67FDF86E7659AB564A860", hash_generated_method = "D066004669828715526BC70324C79D5D")
        public static Uri getUriFor(String name) {
            return getUriFor(CONTENT_URI, name);
        }

        /**
         * Convenience function for retrieving a single secure settings value
         * as an integer.  Note that internally setting values are always
         * stored as strings; this function converts the string to an integer
         * for you.  The default value will be returned if the setting is
         * not defined or not an integer.
         *
         * @param cr The ContentResolver to access.
         * @param name The name of the setting to retrieve.
         * @param def Value to return if the setting is not defined.
         *
         * @return The setting's current value, or 'def' if it is not defined
         * or not a valid integer.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.000 -0500", hash_original_method = "DBD93DA0568D4E47C40E6BFA100A1EF2", hash_generated_method = "6431710C35E8CCD460BB62DB2BBC4A9B")
        public static int getInt(ContentResolver cr, String name, int def) {
            String v = getString(cr, name);
            try {
                return v != null ? Integer.parseInt(v) : def;
            } catch (NumberFormatException e) {
                return def;
            }
        }

        /**
         * Convenience function for retrieving a single secure settings value
         * as an integer.  Note that internally setting values are always
         * stored as strings; this function converts the string to an integer
         * for you.
         * <p>
         * This version does not take a default value.  If the setting has not
         * been set, or the string value is not a number,
         * it throws {@link SettingNotFoundException}.
         *
         * @param cr The ContentResolver to access.
         * @param name The name of the setting to retrieve.
         *
         * @throws SettingNotFoundException Thrown if a setting by the given
         * name can't be found or the setting value is not an integer.
         *
         * @return The setting's current value.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.001 -0500", hash_original_method = "BC1F410DCF7E88197DA27D0D425DD822", hash_generated_method = "65A02ED2DBB08389547A19AA8589B1B4")
        public static int getInt(ContentResolver cr, String name)
                throws SettingNotFoundException {
            String v = getString(cr, name);
            try {
                return Integer.parseInt(v);
            } catch (NumberFormatException e) {
                throw new SettingNotFoundException(name);
            }
        }

        /**
         * Convenience function for updating a single settings value as an
         * integer. This will either create a new entry in the table if the
         * given name does not exist, or modify the value of the existing row
         * with that name.  Note that internally setting values are always
         * stored as strings, so this function converts the given value to a
         * string before storing it.
         *
         * @param cr The ContentResolver to access.
         * @param name The name of the setting to modify.
         * @param value The new value for the setting.
         * @return true if the value was set, false on database errors
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.002 -0500", hash_original_method = "5F86FAE7117D2E108E68CEB80BF49DA7", hash_generated_method = "6ED7733ABB42EB8D1CAB516377E36AA4")
        public static boolean putInt(ContentResolver cr, String name, int value) {
            return putString(cr, name, Integer.toString(value));
        }

        /**
         * Convenience function for retrieving a single secure settings value
         * as a {@code long}.  Note that internally setting values are always
         * stored as strings; this function converts the string to a {@code long}
         * for you.  The default value will be returned if the setting is
         * not defined or not a {@code long}.
         *
         * @param cr The ContentResolver to access.
         * @param name The name of the setting to retrieve.
         * @param def Value to return if the setting is not defined.
         *
         * @return The setting's current value, or 'def' if it is not defined
         * or not a valid {@code long}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.003 -0500", hash_original_method = "2986E5629421403DA55C169D77194DCA", hash_generated_method = "334B1526468744A2753D53DD17327221")
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

        /**
         * Convenience function for retrieving a single secure settings value
         * as a {@code long}.  Note that internally setting values are always
         * stored as strings; this function converts the string to a {@code long}
         * for you.
         * <p>
         * This version does not take a default value.  If the setting has not
         * been set, or the string value is not a number,
         * it throws {@link SettingNotFoundException}.
         *
         * @param cr The ContentResolver to access.
         * @param name The name of the setting to retrieve.
         *
         * @return The setting's current value.
         * @throws SettingNotFoundException Thrown if a setting by the given
         * name can't be found or the setting value is not an integer.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.004 -0500", hash_original_method = "69C00B9492B59345A478AD340BB82560", hash_generated_method = "DEF6F194A9786A3EC928CD0D3E9ABD57")
        public static long getLong(ContentResolver cr, String name)
                throws SettingNotFoundException {
            String valString = getString(cr, name);
            try {
                return Long.parseLong(valString);
            } catch (NumberFormatException e) {
                throw new SettingNotFoundException(name);
            }
        }

        /**
         * Convenience function for updating a secure settings value as a long
         * integer. This will either create a new entry in the table if the
         * given name does not exist, or modify the value of the existing row
         * with that name.  Note that internally setting values are always
         * stored as strings, so this function converts the given value to a
         * string before storing it.
         *
         * @param cr The ContentResolver to access.
         * @param name The name of the setting to modify.
         * @param value The new value for the setting.
         * @return true if the value was set, false on database errors
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.005 -0500", hash_original_method = "A37AC0F546410BFB8FB9B835A95E1AD0", hash_generated_method = "776F05CA560EFB9C0C763CBDB1EB98A5")
        public static boolean putLong(ContentResolver cr, String name, long value) {
            return putString(cr, name, Long.toString(value));
        }

        /**
         * Convenience function for retrieving a single secure settings value
         * as a floating point number.  Note that internally setting values are
         * always stored as strings; this function converts the string to an
         * float for you. The default value will be returned if the setting
         * is not defined or not a valid float.
         *
         * @param cr The ContentResolver to access.
         * @param name The name of the setting to retrieve.
         * @param def Value to return if the setting is not defined.
         *
         * @return The setting's current value, or 'def' if it is not defined
         * or not a valid float.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.006 -0500", hash_original_method = "0D9E7A4535CB773913AB18AAD472FAE3", hash_generated_method = "3B5A88E4A2869809F140DF533B38E22D")
        public static float getFloat(ContentResolver cr, String name, float def) {
            String v = getString(cr, name);
            try {
                return v != null ? Float.parseFloat(v) : def;
            } catch (NumberFormatException e) {
                return def;
            }
        }

        /**
         * Convenience function for retrieving a single secure settings value
         * as a float.  Note that internally setting values are always
         * stored as strings; this function converts the string to a float
         * for you.
         * <p>
         * This version does not take a default value.  If the setting has not
         * been set, or the string value is not a number,
         * it throws {@link SettingNotFoundException}.
         *
         * @param cr The ContentResolver to access.
         * @param name The name of the setting to retrieve.
         *
         * @throws SettingNotFoundException Thrown if a setting by the given
         * name can't be found or the setting value is not a float.
         *
         * @return The setting's current value.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.007 -0500", hash_original_method = "8F942018F858810492E264878914C1E0", hash_generated_method = "B4F108BE0DBD2F067C9CEB071B929767")
        public static float getFloat(ContentResolver cr, String name)
                throws SettingNotFoundException {
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

        /**
         * Convenience function for updating a single settings value as a
         * floating point number. This will either create a new entry in the
         * table if the given name does not exist, or modify the value of the
         * existing row with that name.  Note that internally setting values
         * are always stored as strings, so this function converts the given
         * value to a string before storing it.
         *
         * @param cr The ContentResolver to access.
         * @param name The name of the setting to modify.
         * @param value The new value for the setting.
         * @return true if the value was set, false on database errors
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.007 -0500", hash_original_method = "7C7CB2A2E239FDA02FE8F80A9EE7770A", hash_generated_method = "DFFDFDA6D89A1873E0163B25D5D32EAF")
        public static boolean putFloat(ContentResolver cr, String name, float value) {
            return putString(cr, name, Float.toString(value));
        }

        /**
         * Get the key that retrieves a bluetooth headset's priority.
         * @hide
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.014 -0500", hash_original_method = "9F3FDD311864041364D161CC9D459AEC", hash_generated_method = "D143F6CF5A5053E047AEA9033141920E")
        public static final String getBluetoothHeadsetPriorityKey(String address) {
            return ("bluetooth_headset_priority_" + address.toUpperCase());
        }

        /**
         * Get the key that retrieves a bluetooth a2dp sink's priority.
         * @hide
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.015 -0500", hash_original_method = "88ED3EEF3F850491928892A6D7A98BFC", hash_generated_method = "EBF41E9A33477D1B5948416D50C28E94")
        public static final String getBluetoothA2dpSinkPriorityKey(String address) {
            return ("bluetooth_a2dp_sink_priority_" + address.toUpperCase());
        }

        /**
         * Get the key that retrieves a bluetooth Input Device's priority.
         * @hide
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.016 -0500", hash_original_method = "92FDA249B7A1BC5A23BF9AFC1E60BB2A", hash_generated_method = "6CAC2E4AC13C7A35781AE7FB38ABBE8F")
        public static final String getBluetoothInputDevicePriorityKey(String address) {
            return ("bluetooth_input_device_priority_" + address.toUpperCase());
        }

        /**
         * Helper method for determining if a location provider is enabled.
         * @param cr the content resolver to use
         * @param provider the location provider to query
         * @return true if the provider is enabled
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.227 -0500", hash_original_method = "D85F37EBA7BADE4247645DA206EE836F", hash_generated_method = "1B57BE8B9CF258F29A6F28387123668B")
        public static final boolean isLocationProviderEnabled(ContentResolver cr, String provider) {
            String allowedProviders = Settings.Secure.getString(cr, LOCATION_PROVIDERS_ALLOWED);
            return TextUtils.delimitedStringContains(allowedProviders, ',', provider);
        }

        /**
         * Thread-safe method for enabling or disabling a single location provider.
         * @param cr the content resolver to use
         * @param provider the location provider to enable or disable
         * @param enabled true if the provider should be enabled
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.228 -0500", hash_original_method = "36D25F998AFB22F91E8D73E56A87BBDF", hash_generated_method = "0F9702063225A2571440E3D71581DE3B")
        public static final void setLocationProviderEnabled(ContentResolver cr,
                String provider, boolean enabled) {
            // to ensure thread safety, we write the provider name with a '+' or '-'
            // and let the SettingsProvider handle it rather than reading and modifying
            // the list of enabled providers.
            if (enabled) {
                provider = "+" + provider;
            } else {
                provider = "-" + provider;
            }
            putString(cr, Settings.Secure.LOCATION_PROVIDERS_ALLOWED, provider);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.996 -0500", hash_original_field = "FBC263FA84C13AB225541020FA11C68E", hash_generated_field = "89F618E2E3C416CB64A1997ADB040178")

        public static final String SYS_PROP_SETTING_VERSION = "sys.settings_secure_version";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.997 -0500", hash_original_field = "9FE679F762373D0396651F36B26F2D6D", hash_generated_field = "1FB09179C87042F649D2E6D9B8084B29")

        private static NameValueCache sNameValueCache = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.008 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "50A988B0A7905EB03033341F5986653C")

        public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/secure");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.010 -0500", hash_original_field = "488729A55CBC62CA2744ACAF4626BC9F", hash_generated_field = "79C9D39FC9AEFA4FD135B1B0E9CFD23B")

        public static final String ADB_ENABLED = "adb_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.011 -0500", hash_original_field = "19274C5E96184BA3AB0A2C01E2125EA2", hash_generated_field = "3BC333DB3AFA4C696FAD89681679AA10")

        public static final String ALLOW_MOCK_LOCATION = "mock_location";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.012 -0500", hash_original_field = "592F2C22201D0D6889A9ED9B0135B17E", hash_generated_field = "89FD614DB78884DF65F3F864AB0A15E4")

        public static final String ANDROID_ID = "android_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.013 -0500", hash_original_field = "8FEC70FD6DE25E221A97D832AA3D5EFB", hash_generated_field = "6ECB5F3102CE3AAAB4956FF4F326D9FD")

        public static final String BLUETOOTH_ON = "bluetooth_on";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.017 -0500", hash_original_field = "CD042626DAA788AAAEE6CAFD213DDF11", hash_generated_field = "161416AEED8B133C02292255110D8589")

        public static final String DATA_ROAMING = "data_roaming";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.017 -0500", hash_original_field = "7948A1A1B3351A92A7865DFF14B34A5D", hash_generated_field = "786D71DE2574BB102EE620BBEFE3B97D")

        public static final String DEFAULT_INPUT_METHOD = "default_input_method";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.018 -0500", hash_original_field = "8B669382AD10470DB33178A3EE8DBE6A", hash_generated_field = "439F1F7665FD282BF53CD7D967AE11B8")

        public static final String SELECTED_INPUT_METHOD_SUBTYPE =
                "selected_input_method_subtype";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.019 -0500", hash_original_field = "3F9DCC0EC40E7A27F93EB582DAC4223A", hash_generated_field = "A5A72B1A7317C15B1F497E011637F800")

        public static final String INPUT_METHODS_SUBTYPE_HISTORY =
                "input_methods_subtype_history";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.020 -0500", hash_original_field = "0136A2BF6AF74423286B2909FF47E7B2", hash_generated_field = "BDA028C6D33BCE8F68880A0F59B553D8")

        public static final String INPUT_METHOD_SELECTOR_VISIBILITY =
                "input_method_selector_visibility";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.021 -0500", hash_original_field = "286F8A2862B550AF0EB28E6AAD015C7A", hash_generated_field = "37959C9F324A4531FCAFAFAA9F627951")

        public static final String DEVICE_PROVISIONED = "device_provisioned";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.022 -0500", hash_original_field = "CA87714D6587ECB68F7DFE2C01586B21", hash_generated_field = "3DE62CCC2B9BC3E462ACB5065E6B416D")

        public static final String ENABLED_INPUT_METHODS = "enabled_input_methods";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.023 -0500", hash_original_field = "AD264F6884B832C85727A5B12B346C82", hash_generated_field = "5BDA117944EC7B2205CF264FF0467CD7")

        public static final String DISABLED_SYSTEM_INPUT_METHODS = "disabled_system_input_methods";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.024 -0500", hash_original_field = "27D11EDD9E92E0BCBBDD19170A186949", hash_generated_field = "BD934F1BA33AA64486FB6E371253EF84")

        public static final String HTTP_PROXY = "http_proxy";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.025 -0500", hash_original_field = "E9AAA25C8EA043561A5F79E6E7791D1D", hash_generated_field = "A1C49F8CC5DF0E871082A64E1E915759")

        public static final String GLOBAL_HTTP_PROXY_HOST = "global_http_proxy_host";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.026 -0500", hash_original_field = "6830F042AC45F6416083E73A1580A674", hash_generated_field = "F94933BFC71A934BBEF9EE97FD5AE9A6")

        public static final String GLOBAL_HTTP_PROXY_PORT = "global_http_proxy_port";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.027 -0500", hash_original_field = "B1AAE7DF7E6AB005DFE4DC77C6F99E82", hash_generated_field = "D7FD231F3BD028154E38DD47CF2F5F26")

        public static final String GLOBAL_HTTP_PROXY_EXCLUSION_LIST =
                "global_http_proxy_exclusion_list";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.027 -0500", hash_original_field = "B84099C9F7C520D90F9FFD12DC475806", hash_generated_field = "9146A394ADABDBFCED4323E3935F0C59")

        public static final String SET_GLOBAL_HTTP_PROXY = "set_global_http_proxy";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.028 -0500", hash_original_field = "931C220D9D6C530F33178FE56540E692", hash_generated_field = "EDF48BF13E9B5A624E0D8A45059AD437")

        public static final String DEFAULT_DNS_SERVER = "default_dns_server";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.029 -0500", hash_original_field = "8CB96312D0697A4643BBED9E105219B7", hash_generated_field = "0E2F58D8FA8E46D4792ACDFAA870246C")

        public static final String INSTALL_NON_MARKET_APPS = "install_non_market_apps";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.030 -0500", hash_original_field = "2DC49E3CE12709A09A91563896B1BE50", hash_generated_field = "907D81EB90820D16F8FAD7BB2F9BA6F8")

        public static final String LOCATION_PROVIDERS_ALLOWED = "location_providers_allowed";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.031 -0500", hash_original_field = "6A560E9A1FEB401C1DC4876FA86FAEE6", hash_generated_field = "82B3CDF29251BA36EBA228FF6B55927E")

        public static final String LOCK_PATTERN_ENABLED = "lock_pattern_autolock";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.032 -0500", hash_original_field = "AA79CEC039827029BFDB607AD7563322", hash_generated_field = "DF7DD79FD9BB251B49360995543E0E37")

        public static final String LOCK_PATTERN_VISIBLE = "lock_pattern_visible_pattern";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.033 -0500", hash_original_field = "EA106DCD904E84527E48323B260C9CAC", hash_generated_field = "6D24BA38A6603BF3EE5DA4E0EE37AE46")

        public static final String LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED =
            "lock_pattern_tactile_feedback_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.034 -0500", hash_original_field = "E66AA6FD419774785090E5B5D69EC536", hash_generated_field = "BB69B189558D8C7D217A89E68B28ABB4")

        public static final String LOCK_SCREEN_LOCK_AFTER_TIMEOUT = "lock_screen_lock_after_timeout";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.036 -0500", hash_original_field = "5B57A3BD0F0CD3914CB984AB6C1DA3DC", hash_generated_field = "6C70254B97D651FD36AA5BEEE1A4EE22")

        public static final String LOCK_SCREEN_OWNER_INFO = "lock_screen_owner_info";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.037 -0500", hash_original_field = "AC7EA6E913ABEAFD03811E316884454C", hash_generated_field = "71E668B511B8248CCFCDF87B3C8D226C")

        public static final String LOCK_SCREEN_OWNER_INFO_ENABLED =
            "lock_screen_owner_info_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.037 -0500", hash_original_field = "CD6F393F3D3F0B62829545349C8D2975", hash_generated_field = "30200426AF9EABAE361B7F05B1C2D4D0")

        public static final String DISPLAY_SIZE_FORCED = "display_size_forced";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.038 -0500", hash_original_field = "0D1BEC1DD9260B1F49F82BB9061C5DE0", hash_generated_field = "13583C0CA20E88382CF606B4B1E38E05")

        public static final String ASSISTED_GPS_ENABLED = "assisted_gps_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.039 -0500", hash_original_field = "99C5293F3C6746A0EADB33A23B143B0C", hash_generated_field = "E5C38E643BDB2CE0FD82B6F004D9222D")

        @Deprecated
        public static final String LOGGING_ID = "logging_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.041 -0500", hash_original_field = "7B79E3DF7F87B787905A8600359ED8B2", hash_generated_field = "F44B77883E7B62CAFDF44672A3FB44DF")

        public static final String NETWORK_PREFERENCE = "network_preference";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.042 -0500", hash_original_field = "2A5EB73AB8BE04AEE1C048F0976E78C9", hash_generated_field = "C43BC96F6DDFB913111A0C732BA9F7CC")

        public static final String TETHER_SUPPORTED = "tether_supported";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.042 -0500", hash_original_field = "A2A7EB2BDDAD942647D726D54AB9A6AD", hash_generated_field = "0D4BC156E64A22E1802AB4E3CF305441")

        public static final String TETHER_DUN_REQUIRED = "tether_dun_required";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.043 -0500", hash_original_field = "DD2B1D5733C0BD4452E1A58243E5B9B0", hash_generated_field = "043BC9E84F6FADD85EACDEB6EAA0286E")

        public static final String TETHER_DUN_APN = "tether_dun_apn";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.044 -0500", hash_original_field = "6DAD2B82151E8CC8EB07767EE753EBF8", hash_generated_field = "82A884384BF067DB2E2DA4E361D89867")

        public static final String PARENTAL_CONTROL_ENABLED = "parental_control_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.045 -0500", hash_original_field = "C6262AB7179D20D3E675295671590C37", hash_generated_field = "405F693ACFDFBD44096304B1F35BF2E7")

        public static final String PARENTAL_CONTROL_LAST_UPDATE = "parental_control_last_update";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.046 -0500", hash_original_field = "4B090BFC5CEA4D6A6BAE39E88D22B5E3", hash_generated_field = "EF661B7BE5B462AD0DA465010C4ADBB5")

        public static final String PARENTAL_CONTROL_REDIRECT_URL = "parental_control_redirect_url";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.047 -0500", hash_original_field = "160900E8D29446BADF200A12B52EDC20", hash_generated_field = "3EB64A0AF7782602A607B47D7BE14661")

        public static final String SAMPLING_PROFILER_MS = "sampling_profiler_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:27.585 -0500", hash_original_field = "A8CB8E584A0FB3201C8498BDC25EF13C", hash_generated_field = "47C49E0C240F274A3DD8142B990DE247")

        // TODO: 881807
        public static final String SETTINGS_CLASSNAME = "settings_classname";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.048 -0500", hash_original_field = "3BDC1E8F7555414A80C2166770946CD1", hash_generated_field = "E0BEDEC3309A5E98637A774A3B2F6ABC")

        public static final String USB_MASS_STORAGE_ENABLED = "usb_mass_storage_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.049 -0500", hash_original_field = "6C671E79280B755C2BBDBDFB1BAC47FF", hash_generated_field = "BB70E850B9E1C3B7DCCEDA651ABD0C51")

        public static final String USE_GOOGLE_MAIL = "use_google_mail";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.050 -0500", hash_original_field = "0A2A471256DCF27BD05C37518384629C", hash_generated_field = "404B30DDDC777DD7033331F1B9D2E39B")

        public static final String ACCESSIBILITY_ENABLED = "accessibility_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.051 -0500", hash_original_field = "8F8BDE1993C9AA20FCC03E48FB8F10CE", hash_generated_field = "9FA8FE59652462F2BB54E061B617FC9E")

        public static final String TOUCH_EXPLORATION_ENABLED = "touch_exploration_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.052 -0500", hash_original_field = "DB8788165255FA633525E7751AB58F5C", hash_generated_field = "2852478F7170A6E83BBFACBF69078101")

        public static final String ENABLED_ACCESSIBILITY_SERVICES =
            "enabled_accessibility_services";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.053 -0500", hash_original_field = "F4D63C99A9163D7189D7B5388F88F831", hash_generated_field = "31D998194C7910CA82CDE399ECD22B62")

        public static final String ACCESSIBILITY_SPEAK_PASSWORD = "speak_password";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.054 -0500", hash_original_field = "42154EBF120809136961B05333EAC075", hash_generated_field = "2E179B7DFEA7FD5BBF2E7FFCC6A68410")

        public static final String ACCESSIBILITY_SCRIPT_INJECTION =
            "accessibility_script_injection";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.055 -0500", hash_original_field = "80948C76B904F1A7B0088F4DB378286F", hash_generated_field = "0070BD7CA809C4401B9C22E9E20E9BA0")

        public static final String ACCESSIBILITY_WEB_CONTENT_KEY_BINDINGS =
            "accessibility_web_content_key_bindings";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.056 -0500", hash_original_field = "09486BB39347F52E6FAABD1301E8C37B", hash_generated_field = "CAD61C8FED762602C379CFD7F487280E")

        public static final String LONG_PRESS_TIMEOUT = "long_press_timeout";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.057 -0500", hash_original_field = "6192ABAEE9D6D5790A53EB19B1DE15FC", hash_generated_field = "4D0CEA197A58CE5210BA6936CA1883CA")

        @Deprecated
        public static final String TTS_USE_DEFAULTS = "tts_use_defaults";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.058 -0500", hash_original_field = "0D8AF4B0E0CE6E687132D99D57C58C98", hash_generated_field = "DDC9C56E7C3533D0CB9DE226F30E21B8")

        public static final String TTS_DEFAULT_RATE = "tts_default_rate";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.059 -0500", hash_original_field = "2F00578D7334F6A301D5F9307F556A2D", hash_generated_field = "4EFE4D0227367750096C34E3A7E346B3")

        public static final String TTS_DEFAULT_PITCH = "tts_default_pitch";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.060 -0500", hash_original_field = "4543FFBCD1816773190E7C72AD94EC0F", hash_generated_field = "F2D6900708576CA908745561500EF3C4")

        public static final String TTS_DEFAULT_SYNTH = "tts_default_synth";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.061 -0500", hash_original_field = "42FE0B1CD08B26ED8EED97E79BAA1286", hash_generated_field = "0EBE88E208B1851FF7590028067FDB5E")

        @Deprecated
        public static final String TTS_DEFAULT_LANG = "tts_default_lang";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.062 -0500", hash_original_field = "E4BF74BEFBA569558CACA018DA7D8FA1", hash_generated_field = "56A050A1A2DB89C9570F760F5015745A")

        @Deprecated
        public static final String TTS_DEFAULT_COUNTRY = "tts_default_country";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.063 -0500", hash_original_field = "F431443E3C7FFB9A5ED396579FFB19F4", hash_generated_field = "D2A0E2237CA61C3436901404ADAABC12")

        @Deprecated
        public static final String TTS_DEFAULT_VARIANT = "tts_default_variant";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.064 -0500", hash_original_field = "ADF3A8BF8EFCE894A897DFDBCA7EFE82", hash_generated_field = "C70B854049AA294107CE8BED3A774F27")

        public static final String TTS_DEFAULT_LOCALE = "tts_default_locale";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.065 -0500", hash_original_field = "B1DEBAE27FF24D986508F5AD1628829E", hash_generated_field = "854FCF0B78B4570DE26F375774B0B03C")

        public static final String TTS_ENABLED_PLUGINS = "tts_enabled_plugins";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.066 -0500", hash_original_field = "BC2D33D8D226F544FF28381393482A54", hash_generated_field = "E77A49D7F5B8C434897B8F922D14D6E4")

        public static final String WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON =
                "wifi_networks_available_notification_on";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.067 -0500", hash_original_field = "76D87E47BB4ABB99E3DF1B99CC4C88E7", hash_generated_field = "51E3DA776598F758A63CB8614CB8CF37")

        public static final String WIMAX_NETWORKS_AVAILABLE_NOTIFICATION_ON =
                "wimax_networks_available_notification_on";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.068 -0500", hash_original_field = "0FBCB2E0CA2C354B91CA50F4901C340F", hash_generated_field = "EB71927AE8FF594D3494CC7DD199AE0C")

        public static final String WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY =
                "wifi_networks_available_repeat_delay";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.069 -0500", hash_original_field = "49A29AAD18B1C1FF98099B6F1ABF80B5", hash_generated_field = "73CDF25AE524EEA5842CAE97A4624659")

        public static final String WIFI_COUNTRY_CODE = "wifi_country_code";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.070 -0500", hash_original_field = "057D1BF069B8862F31805BC1BDB2B835", hash_generated_field = "B32FE3167D8FEF1DD0AA761FA9919781")

        public static final String WIFI_NUM_OPEN_NETWORKS_KEPT = "wifi_num_open_networks_kept";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.071 -0500", hash_original_field = "2CC0A7337C9A3A7F45EA157C464C577F", hash_generated_field = "1F16CB26B69C164B197B31E0DD9D191E")

        public static final String WIFI_ON = "wifi_on";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.072 -0500", hash_original_field = "1C6C44E6294125CAC2619B21F157B51A", hash_generated_field = "FD7AFE3DBB403DF237FD3E49B38C38F7")

        public static final String WIFI_SAVED_STATE = "wifi_saved_state";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.073 -0500", hash_original_field = "F28DCD7B6E7E51C32D968F5978A6A031", hash_generated_field = "D9052A1B349240A9BD258935AD11DF85")

        public static final String WIFI_AP_SSID = "wifi_ap_ssid";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.074 -0500", hash_original_field = "8F395F974852E2C80011E7410673328C", hash_generated_field = "1E938B466B6204C77CFF64693A7F9EFE")

        public static final String WIFI_AP_SECURITY = "wifi_ap_security";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.075 -0500", hash_original_field = "01A27FB92C96AE45601B39171F211405", hash_generated_field = "8D1E9FCA5B2A2A6E00182F6A70C0A3DC")

        public static final String WIFI_AP_PASSWD = "wifi_ap_passwd";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.076 -0500", hash_original_field = "F98C83A859DADC26DC3333DD494674AE", hash_generated_field = "83BA3C88680EA6E3324AF2839D0EB942")

        @Deprecated
        public static final String WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE =
                "wifi_watchdog_acceptable_packet_loss_percentage";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.076 -0500", hash_original_field = "5A3E6B2FA1AB3D19D380B9C4C125B03B", hash_generated_field = "AD6194D470E707D60A5B38DA12E0817E")

        @Deprecated
        public static final String WIFI_WATCHDOG_AP_COUNT = "wifi_watchdog_ap_count";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.078 -0500", hash_original_field = "E815C7CC3F38F20A03E0BE0B8C4D7487", hash_generated_field = "407528D8402F624D61DA51A9773DA9EF")

        @Deprecated
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS =
                "wifi_watchdog_background_check_delay_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.079 -0500", hash_original_field = "3B9C2036D875D8232E2F916EF4C36D5A", hash_generated_field = "8C2503926809955C5E808684C01D4A39")

        @Deprecated
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED =
                "wifi_watchdog_background_check_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.080 -0500", hash_original_field = "37AAF42C29C8825E9B055F9A25767962", hash_generated_field = "3BBEFDC0DF3EB28ADCD125B18B6482DA")

        @Deprecated
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS =
                "wifi_watchdog_background_check_timeout_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.081 -0500", hash_original_field = "BD064BC776D2F996D3E23FA7875C3DE7", hash_generated_field = "5DC2C91A28ECCF5C9817286975EEE6D2")

        @Deprecated
        public static final String WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT =
            "wifi_watchdog_initial_ignored_ping_count";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.082 -0500", hash_original_field = "32EBA57FCF4DFB0F5FB127EB760FF922", hash_generated_field = "B5578E1AC71D475B561E8D9E7A955127")

        @Deprecated
        public static final String WIFI_WATCHDOG_MAX_AP_CHECKS = "wifi_watchdog_max_ap_checks";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.083 -0500", hash_original_field = "B588A6D0CB1C511946222DD88A81BBFE", hash_generated_field = "4D29BDA552B839DC0DD97343EE6CD4E0")

        public static final String WIFI_WATCHDOG_ON = "wifi_watchdog_on";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.084 -0500", hash_original_field = "ED1B261204C5431FB9B0CC0CDC120595", hash_generated_field = "471028AFABA89CF336D093B439EE705F")

        @Deprecated
        public static final String WIFI_WATCHDOG_WATCH_LIST = "wifi_watchdog_watch_list";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.085 -0500", hash_original_field = "584620E5E7E2518358D178D533B28564", hash_generated_field = "DA26C1688FC60CD953796708BE77C471")

        @Deprecated
        public static final String WIFI_WATCHDOG_PING_COUNT = "wifi_watchdog_ping_count";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.086 -0500", hash_original_field = "CF0824BD86F2CEAAE5FDD385EC650C36", hash_generated_field = "2CDF8826F07666FDCB8A82EEC07FC855")

        @Deprecated
        public static final String WIFI_WATCHDOG_PING_DELAY_MS = "wifi_watchdog_ping_delay_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.087 -0500", hash_original_field = "9235DECEEB1ACE781AA0322FB421E304", hash_generated_field = "306F914FD3C294A8F2745F8C532C0862")

        @Deprecated
        public static final String WIFI_WATCHDOG_PING_TIMEOUT_MS = "wifi_watchdog_ping_timeout_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.088 -0500", hash_original_field = "149C65AEF0A70C3777FD3FBD4C165D75", hash_generated_field = "14BE9E5C2CEAE1BFD61064F03EEDEDBD")

        public static final String WIFI_WATCHDOG_DNS_CHECK_SHORT_INTERVAL_MS =
                "wifi_watchdog_dns_check_short_interval_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.089 -0500", hash_original_field = "753723C21DA03343BB5BDB69DE6F4A88", hash_generated_field = "D346454A076E302AEA489CB9A566068A")

        public static final String WIFI_WATCHDOG_DNS_CHECK_LONG_INTERVAL_MS =
                "wifi_watchdog_dns_check_long_interval_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.089 -0500", hash_original_field = "AD5A3490E66061B223F43D83CAB2065E", hash_generated_field = "CBC93C08D9074342B13AB32EDC9FAA5D")

        public static final String WIFI_WATCHDOG_WALLED_GARDEN_INTERVAL_MS =
                "wifi_watchdog_walled_garden_interval_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.090 -0500", hash_original_field = "45A921F155D1E14BBF6E3F28E60D0EF7", hash_generated_field = "0F7F4D099CBD6513013C1E5AD684989B")

        public static final String WIFI_WATCHDOG_MAX_SSID_BLACKLISTS =
                "wifi_watchdog_max_ssid_blacklists";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.091 -0500", hash_original_field = "52141F388C1A64D3593277582578CE52", hash_generated_field = "9E118E1ABC6D2774B7437A2926AF3472")

        public static final String WIFI_WATCHDOG_NUM_DNS_PINGS = "wifi_watchdog_num_dns_pings";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.092 -0500", hash_original_field = "CC3F0BB213A1C1194E48734045A61979", hash_generated_field = "E23B3ABB35784011E55EEB4194623D07")

        public static final String WIFI_WATCHDOG_MIN_DNS_RESPONSES =
                "wifi_watchdog_min_dns_responses";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.093 -0500", hash_original_field = "85320680DA9EA3501FF2EC934FDFF8BB", hash_generated_field = "7A09FDF01BD3DC833190299A3FFCB42B")

        public static final String WIFI_WATCHDOG_DNS_PING_TIMEOUT_MS =
                "wifi_watchdog_dns_ping_timeout_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.094 -0500", hash_original_field = "254055246EBE4430A820839721BD0F3D", hash_generated_field = "6CBB69D64C3CA9AF44F840D809506929")

        public static final String WIFI_WATCHDOG_BLACKLIST_FOLLOWUP_INTERVAL_MS =
                "wifi_watchdog_blacklist_followup_interval_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.095 -0500", hash_original_field = "2F4581AA2AA10F8F8180B400EF190A67", hash_generated_field = "F74A4E3EC63F7CC7E60ADB80ED983511")

        public static final String WIFI_WATCHDOG_POOR_NETWORK_TEST_ENABLED =
                "wifi_watchdog_poor_network_test_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.096 -0500", hash_original_field = "C38B7F03E5B322E8987A222B2C45A06D", hash_generated_field = "436F43D2CC6AB30E4AE6D43A85AD8FAE")

        public static final String WIFI_WATCHDOG_WALLED_GARDEN_TEST_ENABLED =
                "wifi_watchdog_walled_garden_test_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.097 -0500", hash_original_field = "A4FA16AED5B71E6B49CE5DD8C8FBB89B", hash_generated_field = "3867A6B889B240D4E12347BD3A3D5A26")

        public static final String WIFI_WATCHDOG_WALLED_GARDEN_URL =
                "wifi_watchdog_walled_garden_url";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.098 -0500", hash_original_field = "0679A08D85290F329127C9EEED31DCCA", hash_generated_field = "DAAE8FACA016ADE82F696FCAC85BAD96")

        public static final String WIFI_WATCHDOG_SHOW_DISABLED_NETWORK_POPUP =
                "wifi_watchdog_show_disabled_network_popup";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.099 -0500", hash_original_field = "C2AFBA662DF7839973A23A4B54C6961D", hash_generated_field = "2568AA0DD3330B8749996350A4AAB403")

        public static final String WIFI_MAX_DHCP_RETRY_COUNT = "wifi_max_dhcp_retry_count";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.100 -0500", hash_original_field = "44FDFB28C5B4B810BDDD84C1A419EC2E", hash_generated_field = "E377F6D2E06E01D783D8D2AD2FDA9B29")

        public static final String WIFI_FREQUENCY_BAND = "wifi_frequency_band";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.101 -0500", hash_original_field = "E74D8766B3FBEED929500B0793A9DD05", hash_generated_field = "4B7AA9A37571DB91F0C5CB9DE2010AD0")

        public static final String WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS =
            "wifi_mobile_data_transition_wakelock_timeout_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.102 -0500", hash_original_field = "1B1B41273CF04410CB0260D5D6EC2841", hash_generated_field = "82919390A121EA2BBDB3BF9B5866B90E")

        @Deprecated
        public static final String BACKGROUND_DATA = "background_data";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.103 -0500", hash_original_field = "E4085211269A41BFEBFD10B577A85969", hash_generated_field = "830636DDFDEF56433258551354C9804C")

        public static final String ALLOWED_GEOLOCATION_ORIGINS
                = "allowed_geolocation_origins";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.104 -0500", hash_original_field = "274C67A700D42462F1CD3DB173FC428F", hash_generated_field = "EF0AE5FF920FEDD44EDC2B771851B3FA")

        public static final String MOBILE_DATA = "mobile_data";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.105 -0500", hash_original_field = "E2D6ADFE8EC7B47CFBC6B3CBD73503A8", hash_generated_field = "A84A8D317FBFD621AEF87F14CA35E1E0")

        public static final String CDMA_ROAMING_MODE = "roaming_settings";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.106 -0500", hash_original_field = "598563308227897369480DA922E7FC92", hash_generated_field = "6BD5DF2E203B88360CE92D9487007B99")

        public static final String CDMA_SUBSCRIPTION_MODE = "subscription_mode";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.107 -0500", hash_original_field = "D0C1E7A5193CA800425E20300662B394", hash_generated_field = "B7D77A27006639D1B92E8B3A43DE9320")

        public static final String PREFERRED_NETWORK_MODE =
                "preferred_network_mode";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.108 -0500", hash_original_field = "390AF34696BB083A14BEBF3B97490EF9", hash_generated_field = "7923F493177C954A70E7E1830BE2DC87")

        public static final String PREFERRED_TTY_MODE =
                "preferred_tty_mode";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.109 -0500", hash_original_field = "2594655257EA72DC90E7F95472537EB5", hash_generated_field = "BD83A990DC9AA972B2A48FAD1BA15370")

        public static final String CDMA_CELL_BROADCAST_SMS =
                "cdma_cell_broadcast_sms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.110 -0500", hash_original_field = "8AD3ABB2E20FE6CF33528ECAFF3AA461", hash_generated_field = "B6B896D49F18BC36F0DEA2E024C97288")

        public static final String PREFERRED_CDMA_SUBSCRIPTION =
                "preferred_cdma_subscription";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.111 -0500", hash_original_field = "579E0330B36A8AE1E8537AA54273A0C8", hash_generated_field = "EAE64FEE6EE13548FCFBFA0530F8177F")

        public static final String ENHANCED_VOICE_PRIVACY_ENABLED = "enhanced_voice_privacy_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.112 -0500", hash_original_field = "38E1FEF232B4857DAC0FEEE24273ED56", hash_generated_field = "76F47F3CC305593C400303802631921C")

        public static final String TTY_MODE_ENABLED = "tty_mode_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.113 -0500", hash_original_field = "DFC47C9602FEA284EEEE28C21B819A44", hash_generated_field = "26FD879A0EE96016B6C63F40C5B6A098")

        public static final String CONNECTIVITY_CHANGE_DELAY = "connectivity_change_delay";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.113 -0500", hash_original_field = "1E3F991F317D8B8CD49FD463ED4942F6", hash_generated_field = "A177319EBD03EB2037079E40845B9587")

        public static final int CONNECTIVITY_CHANGE_DELAY_DEFAULT = 3000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.114 -0500", hash_original_field = "D96B5752424C58504B3DCBE81DB707DB", hash_generated_field = "9F16CE40B011290E0C981220BE5A4847")

        public static final String BACKUP_ENABLED = "backup_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.115 -0500", hash_original_field = "82548E9A4F7CFD460F1D06D746D753DF", hash_generated_field = "3C9460127594818C6615598BED772E49")

        public static final String BACKUP_AUTO_RESTORE = "backup_auto_restore";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.116 -0500", hash_original_field = "AA4F9B9FCD0137E870AFFBD314101DC3", hash_generated_field = "FA93AD5EA15AE74B79472152E6D83213")

        public static final String BACKUP_PROVISIONED = "backup_provisioned";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.117 -0500", hash_original_field = "0181D2F559A6EEC821C16607B7D66F9A", hash_generated_field = "5E56C94C442D397AC1F933338BA97A6A")

        public static final String BACKUP_TRANSPORT = "backup_transport";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.118 -0500", hash_original_field = "DD385DBA43B3AD5C3893F0BC5944C855", hash_generated_field = "34413AC238EE77066209176AA2AAD0BE")

        public static final String LAST_SETUP_SHOWN = "last_setup_shown";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.119 -0500", hash_original_field = "375F5857B3596791C3880BC2F92049A9", hash_generated_field = "6650FABEE1AD090E0BBC3C2F030F0587")

        public static final String MEMCHECK_INTERVAL = "memcheck_interval";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.120 -0500", hash_original_field = "02960410D6758868CEA01453FB7EE16A", hash_generated_field = "2CBE37645E987ABE9BF821DD1A8EAAA3")

        public static final String MEMCHECK_LOG_REALTIME_INTERVAL =
                "memcheck_log_realtime_interval";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.121 -0500", hash_original_field = "673B73606DE154DB0BC0F882162FC08E", hash_generated_field = "E217CED1FA516C85AE9CE6C0B36327ED")

        public static final String MEMCHECK_SYSTEM_ENABLED = "memcheck_system_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.122 -0500", hash_original_field = "C3ACA64F900918CE3A0C574FE24D3C6F", hash_generated_field = "5E439DE0CA35F259AFE4E25DF663DED1")

        public static final String MEMCHECK_SYSTEM_SOFT_THRESHOLD = "memcheck_system_soft";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.123 -0500", hash_original_field = "D9B068F7F165BF515F726A6D4CF95F55", hash_generated_field = "C1E860D7AD347A43D33AE35AF395980C")

        public static final String MEMCHECK_SYSTEM_HARD_THRESHOLD = "memcheck_system_hard";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.124 -0500", hash_original_field = "5AE45B5026036D84C2FAD60120F922F8", hash_generated_field = "D954FE89B7DE0BBC37AA00C6814543E2")

        public static final String MEMCHECK_PHONE_SOFT_THRESHOLD = "memcheck_phone_soft";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.125 -0500", hash_original_field = "F323D3923A40C548670E400D39AC865F", hash_generated_field = "5B85B57573DA5C316FF9D2E1E5B807B0")

        public static final String MEMCHECK_PHONE_HARD_THRESHOLD = "memcheck_phone_hard";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.126 -0500", hash_original_field = "1AB618F4184BBE27F62CBA6B97DB7BB8", hash_generated_field = "2DF2B831A9D088B4DBE552D27B69C8CF")

        public static final String MEMCHECK_PHONE_ENABLED = "memcheck_phone_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.127 -0500", hash_original_field = "960A01ACF281CE68969144F9D9DEA26A", hash_generated_field = "F2210B70228C1792846F0C6D6200B26A")

        public static final String MEMCHECK_EXEC_START_TIME = "memcheck_exec_start_time";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.127 -0500", hash_original_field = "F81B9D82575C9A62A1194564F656CC30", hash_generated_field = "C68713D66CB5A015EFB7C88696F2DC0C")

        public static final String MEMCHECK_EXEC_END_TIME = "memcheck_exec_end_time";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.128 -0500", hash_original_field = "513BB5F5FA2DAA8667F5232213AB097C", hash_generated_field = "C4EF83D389E781169CD40886C2AE391C")

        public static final String MEMCHECK_MIN_SCREEN_OFF = "memcheck_min_screen_off";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.130 -0500", hash_original_field = "9B16446AC6F3CA033A56957CF0D3579C", hash_generated_field = "CF3215160442E19932186F5F54F016AD")

        public static final String MEMCHECK_MIN_ALARM = "memcheck_min_alarm";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.131 -0500", hash_original_field = "9B3F1FF30A3D14FF19AAD2B9F2883062", hash_generated_field = "0390264DA199344464F5A0E1B7B5C07D")

        public static final String MEMCHECK_RECHECK_INTERVAL = "memcheck_recheck_interval";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.131 -0500", hash_original_field = "828A8880120B53A6D6675A1A08792948", hash_generated_field = "17EDB8D55F371603670B886B29E7CCB2")

        public static final String REBOOT_INTERVAL = "reboot_interval";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.132 -0500", hash_original_field = "A147410500523AC80D85CCD4FE873B24", hash_generated_field = "D27CBDC563F1F59648A761098FAB2CD6")

        public static final String REBOOT_START_TIME = "reboot_start_time";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.133 -0500", hash_original_field = "3FD95AE67944A3C4D7BCDF8B9C46A7F9", hash_generated_field = "DC86005DF57DA1D81775BC7E981D0200")

        public static final String REBOOT_WINDOW = "reboot_window";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.134 -0500", hash_original_field = "9FAD507E0CB2DF4AB29B515A95EBBA22", hash_generated_field = "855DD6262E261B5B00484B5CA23A643E")

        public static final String BATTERY_DISCHARGE_DURATION_THRESHOLD =
                "battery_discharge_duration_threshold";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.136 -0500", hash_original_field = "1058D47B12B92BF16977FD4501C7CEA5", hash_generated_field = "2DC39CE53F1A77A5A33BAD988C3346C1")

        public static final String BATTERY_DISCHARGE_THRESHOLD = "battery_discharge_threshold";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.137 -0500", hash_original_field = "30F0B7606D519F3444084305C787C54D", hash_generated_field = "C56EA982C0E50205317AE48EA25AA5DB")

        public static final String SEND_ACTION_APP_ERROR = "send_action_app_error";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.138 -0500", hash_original_field = "C78CC9E6CED90F1B5D98D4F06F6345FA", hash_generated_field = "83FDD3F6202DE3E004224806C0C9858A")

        public static final String WTF_IS_FATAL = "wtf_is_fatal";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.138 -0500", hash_original_field = "49B6B72E9DB2B78725F87CDD5CE670C6", hash_generated_field = "CB176587351BC7EA5314C91CE9A5EAC1")

        public static final String DROPBOX_AGE_SECONDS =
                "dropbox_age_seconds";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.139 -0500", hash_original_field = "CA19603E99B4F3C06C067DEFD93C27A3", hash_generated_field = "127887A28184EB4759D7D7888A0451E4")

        public static final String DROPBOX_MAX_FILES =
                "dropbox_max_files";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.140 -0500", hash_original_field = "9B1720CE3D703885A5F51212D7162438", hash_generated_field = "4E04B31316E69880D6981CF01009C0FD")

        public static final String DROPBOX_QUOTA_KB =
                "dropbox_quota_kb";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.141 -0500", hash_original_field = "7A2774240F3424D07A8FC5FC4C0B85EC", hash_generated_field = "A3B4CCDB771DBAF6B484C7319D9216B9")

        public static final String DROPBOX_QUOTA_PERCENT =
                "dropbox_quota_percent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.142 -0500", hash_original_field = "E1E01ADEF0F249B2DB58EE9DD293B449", hash_generated_field = "AB9BEC714B40F59C3D87E308A298C1A6")

        public static final String DROPBOX_RESERVE_PERCENT =
                "dropbox_reserve_percent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.143 -0500", hash_original_field = "16DB8FDDEA151C856138DDF2D597A4C4", hash_generated_field = "7F79A75176326171223B71AC217B5802")

        public static final String DROPBOX_TAG_PREFIX =
                "dropbox:";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.144 -0500", hash_original_field = "3104F574A1BD784B868139B53AE6B1E1", hash_generated_field = "4BB97BB3FB3D4C183311FE6E3FD8113B")

        public static final String ERROR_LOGCAT_PREFIX =
                "logcat_for_";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.145 -0500", hash_original_field = "AA065C3A9B393476C37A65A72948242E", hash_generated_field = "C0CB5A6E8A796BEAE078191D880A4B1A")

        public static final String SHORT_KEYLIGHT_DELAY_MS =
                "short_keylight_delay_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.146 -0500", hash_original_field = "48BF4E3B3A59E3EDD53A5B1C5E8C3FD1", hash_generated_field = "79C48C572E4B66AFAC92532282878252")

        public static final String SYS_FREE_STORAGE_LOG_INTERVAL =
                "sys_free_storage_log_interval";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.147 -0500", hash_original_field = "A1D4EB4717BB6254E3152BE8D5987CE1", hash_generated_field = "E277364C46F18F5D514ECA37E8288EA2")

        public static final String DISK_FREE_CHANGE_REPORTING_THRESHOLD =
                "disk_free_change_reporting_threshold";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.148 -0500", hash_original_field = "ACCBDC5A632FAE048A93266EF2F2518C", hash_generated_field = "64238B25E0063519B8231B37BA13CB75")

        public static final String SYS_STORAGE_THRESHOLD_PERCENTAGE =
                "sys_storage_threshold_percentage";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.149 -0500", hash_original_field = "F3AD72D5B7F02A771433B66F46668D79", hash_generated_field = "A86F3D7F535481640E8844C858DE374D")

        public static final String SYS_STORAGE_THRESHOLD_MAX_BYTES =
                "sys_storage_threshold_max_bytes";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.150 -0500", hash_original_field = "31EB1D634EB3694B8C342539903B0F8D", hash_generated_field = "B6CA50AA7D6DA49D2EDD3DCA72A97913")

        public static final String SYS_STORAGE_FULL_THRESHOLD_BYTES =
                "sys_storage_full_threshold_bytes";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.151 -0500", hash_original_field = "17816817A9E9265822B2272E67265A13", hash_generated_field = "902A93A935E10C7FCD2B32BDB03DC096")

        public static final String WIFI_IDLE_MS = "wifi_idle_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.152 -0500", hash_original_field = "4831AF892BC4FE6BD65A26A4D20C1ABD", hash_generated_field = "36BB6CF605591BC25DD80B378BB4EAA4")

        public static final String WIFI_FRAMEWORK_SCAN_INTERVAL_MS =
                "wifi_framework_scan_interval_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.153 -0500", hash_original_field = "E5126960CD6411E6875C94A6C8135BC9", hash_generated_field = "9564EEE58389E3E791A11CCE7EC4B3FB")

        public static final String WIFI_SUPPLICANT_SCAN_INTERVAL_MS =
                "wifi_supplicant_scan_interval_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.154 -0500", hash_original_field = "A8A199DEE99131AB321D9203EC57E6B7", hash_generated_field = "07AB878D7AE1FD436A98630CAA4B5AA3")

        public static final String PDP_WATCHDOG_POLL_INTERVAL_MS =
                "pdp_watchdog_poll_interval_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.155 -0500", hash_original_field = "045D293ACCC1D7D823BE8EF34B404E31", hash_generated_field = "F66E1F7BEAD0C09D09A3DB76CD67D6A9")

        public static final String PDP_WATCHDOG_LONG_POLL_INTERVAL_MS =
                "pdp_watchdog_long_poll_interval_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.156 -0500", hash_original_field = "5D9CA33E56210F9DB4F64F4D08DC1BA6", hash_generated_field = "0B21047992B4DCDD894CE068A106D4C3")

        public static final String PDP_WATCHDOG_ERROR_POLL_INTERVAL_MS =
                "pdp_watchdog_error_poll_interval_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.156 -0500", hash_original_field = "22D9A71D5AB62859C668C18BC39CCD3D", hash_generated_field = "BFF40E3389E98E49B8E77E94CF7D6F85")

        public static final String PDP_WATCHDOG_TRIGGER_PACKET_COUNT =
                "pdp_watchdog_trigger_packet_count";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.157 -0500", hash_original_field = "8E5146C3E264AE0F960E95CBBC9C5B95", hash_generated_field = "CBF88FFCE0BFC3DF98DC840FF0886FE9")

        public static final String PDP_WATCHDOG_ERROR_POLL_COUNT =
                "pdp_watchdog_error_poll_count";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.158 -0500", hash_original_field = "306FED34B8D7D7FA33D513D823FD396B", hash_generated_field = "A181A7ADE439EE350E96EC18E0E3B0B9")

        public static final String PDP_WATCHDOG_MAX_PDP_RESET_FAIL_COUNT =
                "pdp_watchdog_max_pdp_reset_fail_count";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.159 -0500", hash_original_field = "8AB309A24ED4DEB106E666D1D0A58EA7", hash_generated_field = "E446CF2FD2619123DF59EE579B35D307")

        public static final String DATA_STALL_ALARM_DELAY_IN_MS =
                "data_stall_alarm_delay_in_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.161 -0500", hash_original_field = "826278ECC29A2FB7171FB9975A497FD6", hash_generated_field = "83CAD62C7A40DA4635E07950FA3DA46B")

        public static final String GPRS_REGISTER_CHECK_PERIOD_MS =
                "gprs_register_check_period_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.162 -0500", hash_original_field = "0E482D2DEC0047C8656F043706C02036", hash_generated_field = "2346B37B43CA722CA18867AEE46B4813")

        public static final String NITZ_UPDATE_SPACING = "nitz_update_spacing";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.162 -0500", hash_original_field = "CA7162CB636A8993D84CC0795528AFD9", hash_generated_field = "C937AEEBBFEE535DBACF1B5F3BE6566B")

        public static final String NITZ_UPDATE_DIFF = "nitz_update_diff";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.163 -0500", hash_original_field = "F99BA179BE86B453A0227DA8DD57951C", hash_generated_field = "FB85438084F5A378E386134E18DF1E62")

        public static final String SYNC_MAX_RETRY_DELAY_IN_SECONDS =
                "sync_max_retry_delay_in_seconds";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.164 -0500", hash_original_field = "2753B2C2F0C999E8B0AE2D21448A2764", hash_generated_field = "3ADB39776443E40F70DE9993C31208AE")

        public static final String SMS_OUTGOING_CHECK_INTERVAL_MS =
                "sms_outgoing_check_interval_ms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.165 -0500", hash_original_field = "DC9FADCEA97F4B74E800A80A0E34DE8A", hash_generated_field = "274AFB6C6FE7BE016627AB360F6DFC16")

        public static final String SMS_OUTGOING_CHECK_MAX_COUNT =
                "sms_outgoing_check_max_count";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.166 -0500", hash_original_field = "1E5E2F34B09D85D471318025443743A7", hash_generated_field = "62C0A966684FE98935712F2B8D95D10E")

        public static final String SEARCH_GLOBAL_SEARCH_ACTIVITY =
                "search_global_search_activity";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.167 -0500", hash_original_field = "A797C0724C66DEADDAA29199CFA808A2", hash_generated_field = "FE435711C62427EFE767116EEFC9C842")

        public static final String SEARCH_NUM_PROMOTED_SOURCES = "search_num_promoted_sources";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.168 -0500", hash_original_field = "D348D716C5C7F0710DD5BF7C860DE13E", hash_generated_field = "EF937A75EC36E48C092BDBE50EC38011")

        public static final String SEARCH_MAX_RESULTS_TO_DISPLAY = "search_max_results_to_display";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.169 -0500", hash_original_field = "6B7C39C7EF19BE76CA27BDE53D511DCF", hash_generated_field = "474F88BD32B2E67B3E3D2662860F9E6C")

        public static final String SEARCH_MAX_RESULTS_PER_SOURCE = "search_max_results_per_source";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.169 -0500", hash_original_field = "0E6837897FCD481D28C5C2807A7AE3FD", hash_generated_field = "5C1BB97D35B1D708971C2EDB3012301D")

        public static final String SEARCH_WEB_RESULTS_OVERRIDE_LIMIT =
                "search_web_results_override_limit";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.170 -0500", hash_original_field = "157060842092FFEE2F49C93E6A08F722", hash_generated_field = "4EA4C9435B8E7A2B17E493C1525ECDB7")

        public static final String SEARCH_PROMOTED_SOURCE_DEADLINE_MILLIS =
                "search_promoted_source_deadline_millis";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.171 -0500", hash_original_field = "E90B2D5772BC93752118536DF477A014", hash_generated_field = "9A55EA7A829B19C057B78F638F89D6C2")

        public static final String SEARCH_SOURCE_TIMEOUT_MILLIS = "search_source_timeout_millis";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.172 -0500", hash_original_field = "E3AC195CC4AA20F68B5C6809E3C819CE", hash_generated_field = "0C071F6ACB5B86362BC6CBCD154394F7")

        public static final String SEARCH_PREFILL_MILLIS = "search_prefill_millis";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.173 -0500", hash_original_field = "62669BC30C5BC3A5F6B53DA3A16911AD", hash_generated_field = "5196A79C5603E3665516E923C8501BE9")

        public static final String SEARCH_MAX_STAT_AGE_MILLIS = "search_max_stat_age_millis";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.174 -0500", hash_original_field = "A2A65F4536E955E8A2EF05C3AD747AC3", hash_generated_field = "8F5C7210CC623D5C484F18E961CE5BFC")

        public static final String SEARCH_MAX_SOURCE_EVENT_AGE_MILLIS =
                "search_max_source_event_age_millis";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.175 -0500", hash_original_field = "9166731F66DB076A16219042B411B5FF", hash_generated_field = "29050819A6AA7851DB7EBC8C66470CAE")

        public static final String SEARCH_MIN_IMPRESSIONS_FOR_SOURCE_RANKING =
                "search_min_impressions_for_source_ranking";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.176 -0500", hash_original_field = "DA983FB1E95C03FF5163ADA62D1008E5", hash_generated_field = "1C79EADBD441811BAED5564AD8ABA143")

        public static final String SEARCH_MIN_CLICKS_FOR_SOURCE_RANKING =
                "search_min_clicks_for_source_ranking";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.177 -0500", hash_original_field = "CFD51AB30DDFBFFA4D8E31B0DC6F8400", hash_generated_field = "714DAB38101D97CF96C1616130D99A82")

        public static final String SEARCH_MAX_SHORTCUTS_RETURNED = "search_max_shortcuts_returned";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.178 -0500", hash_original_field = "3389069C66ED6407C06D72CB9ED46202", hash_generated_field = "FF30549DFBD69949D6948D94B5085622")

        public static final String SEARCH_QUERY_THREAD_CORE_POOL_SIZE =
                "search_query_thread_core_pool_size";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.179 -0500", hash_original_field = "15050AE607D4E91E2559948C95B9BF97", hash_generated_field = "7C5BBFB811DD9AE5D124759E0468AEED")

        public static final String SEARCH_QUERY_THREAD_MAX_POOL_SIZE =
                "search_query_thread_max_pool_size";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.180 -0500", hash_original_field = "20263A7334300982BE3465C98F5E30D3", hash_generated_field = "EA2E818BED35F3CB560FC8DB3D9AB145")

        public static final String SEARCH_SHORTCUT_REFRESH_CORE_POOL_SIZE =
                "search_shortcut_refresh_core_pool_size";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.181 -0500", hash_original_field = "3BAD16F46AB452CA3A5333C3B6EA3C8D", hash_generated_field = "B127B2F735055CABA38E91E506CFB241")

        public static final String SEARCH_SHORTCUT_REFRESH_MAX_POOL_SIZE =
                "search_shortcut_refresh_max_pool_size";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.182 -0500", hash_original_field = "A36BFDCDDF00300A8C0E99591C55EA6E", hash_generated_field = "D90DD095A25A7921A223228B64B5D628")

        public static final String SEARCH_THREAD_KEEPALIVE_SECONDS =
                "search_thread_keepalive_seconds";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.183 -0500", hash_original_field = "4C0A293F1EF55E3A9A793B5AC5AAFF9C", hash_generated_field = "F657EDE0EFAE5DF1937F2590FAE381C0")

        public static final String SEARCH_PER_SOURCE_CONCURRENT_QUERY_LIMIT =
                "search_per_source_concurrent_query_limit";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.184 -0500", hash_original_field = "C46705460262F34146370328A58CBD19", hash_generated_field = "D99C462BFEC9DDBE5E99B2D165F1ED49")

        public static final String MOUNT_PLAY_NOTIFICATION_SND = "mount_play_not_snd";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.185 -0500", hash_original_field = "3F20AD15C42F643580837E528F0C03B7", hash_generated_field = "581AC1D6D7B5CBFC30AE55C136D9984F")

        public static final String MOUNT_UMS_AUTOSTART = "mount_ums_autostart";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.186 -0500", hash_original_field = "E82EB49FAABA19621490F3E45EB08A0A", hash_generated_field = "991F4343126AD983BA0E8E42638DF175")

        public static final String MOUNT_UMS_PROMPT = "mount_ums_prompt";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.187 -0500", hash_original_field = "B5712A958CD48106737A13C36914C508", hash_generated_field = "3A9128C63EAD25B71695EF45C7DC433C")

        public static final String MOUNT_UMS_NOTIFY_ENABLED = "mount_ums_notify_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.188 -0500", hash_original_field = "E155A97B43A7221F25AF9E3ED06E8BD4", hash_generated_field = "6B39D976CC6297F4816DDAF7095C5513")

        public static final String ANR_SHOW_BACKGROUND = "anr_show_background";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.188 -0500", hash_original_field = "F38DD36724BCF9028484A412128D49B7", hash_generated_field = "7500E24DEBB8B958D77EA1DB38C18728")

        public static final String VOICE_RECOGNITION_SERVICE = "voice_recognition_service";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.189 -0500", hash_original_field = "8695C5D5AC7341541F890C11DAD5420C", hash_generated_field = "5CB0E915937A847A57B25156A3FBE21C")

        public static final String SELECTED_SPELL_CHECKER = "selected_spell_checker";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.190 -0500", hash_original_field = "F66D72BDCE9D698AC2A192218F721DE8", hash_generated_field = "A848D74CE159B0828931339FABB73513")

        public static final String SELECTED_SPELL_CHECKER_SUBTYPE =
                "selected_spell_checker_subtype";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.191 -0500", hash_original_field = "29F10ACD2FDE34F62DD7140532E2CB8A", hash_generated_field = "045992FB365DFF8AFAF90562B61BDB2C")

        public static final String SPELL_CHECKER_ENABLED = "spell_checker_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.192 -0500", hash_original_field = "8F5262F718DE3FE6712B9E8A17E29540", hash_generated_field = "48E57D0ABE39B1BE04BDBBDAF0331443")

        public static final String INCALL_POWER_BUTTON_BEHAVIOR = "incall_power_button_behavior";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.193 -0500", hash_original_field = "EA0DB45CC7ED881F0D67AB4623CE7FF2", hash_generated_field = "2C10D9FDD20BF11E1E9480EF3317B634")

        public static final int INCALL_POWER_BUTTON_BEHAVIOR_SCREEN_OFF = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.194 -0500", hash_original_field = "053091FE37F5ECF543F95175597D0BE4", hash_generated_field = "6C673AF2BD3109F8832E538B0EB6A42B")

        public static final int INCALL_POWER_BUTTON_BEHAVIOR_HANGUP = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.195 -0500", hash_original_field = "2395A2BBC22D74553DEC3A04B8988784", hash_generated_field = "581EC3B66B7D239430AEF3BBDD520C53")

        public static final int INCALL_POWER_BUTTON_BEHAVIOR_DEFAULT =
                INCALL_POWER_BUTTON_BEHAVIOR_SCREEN_OFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.196 -0500", hash_original_field = "A72743C17F318AF6A781323D09EA03EC", hash_generated_field = "6F9BC115B5BEB811F2119CC1ED0AFD69")

        public static final String UI_NIGHT_MODE = "ui_night_mode";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.197 -0500", hash_original_field = "CCDC4D878E649A08CF881DFE7E4AE531", hash_generated_field = "F76535E939C7D25DC00C83DE39FB68A4")

        public static final String SET_INSTALL_LOCATION = "set_install_location";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.198 -0500", hash_original_field = "84F164884A22F8BF5249F5418C814F7B", hash_generated_field = "325D1D23247FBF16F774DF3819384D7C")

        public static final String DEFAULT_INSTALL_LOCATION = "default_install_location";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.199 -0500", hash_original_field = "B95E445B9742FA0D442988A73713DE9C", hash_generated_field = "35B82B902BD73AA1CFFF23CB50AF4D10")

        public static final String THROTTLE_POLLING_SEC = "throttle_polling_sec";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.200 -0500", hash_original_field = "E2712F23F280D0E866CA574CB773303E", hash_generated_field = "CF18CCDECC8B2AB2F4D3A463B9F3F7B2")

        public static final String THROTTLE_THRESHOLD_BYTES = "throttle_threshold_bytes";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.201 -0500", hash_original_field = "AEC4BE4E49C50692266218B5ABB817CC", hash_generated_field = "4D3BF24B5F4F8A6338262114316C0509")

        public static final String THROTTLE_VALUE_KBITSPS = "throttle_value_kbitsps";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.201 -0500", hash_original_field = "80C3E202AF16B9D0568A85D06BAF82C5", hash_generated_field = "6122B7D0E3B6BD5C49C9A7A80EA90DC4")

        public static final String THROTTLE_RESET_DAY = "throttle_reset_day";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.202 -0500", hash_original_field = "A743A8BB80E9D37D21E1AAFD21F435F9", hash_generated_field = "ED33A470FE0B556CAE9434474ADBE00A")

        public static final String THROTTLE_NOTIFICATION_TYPE = "throttle_notification_type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.203 -0500", hash_original_field = "1FA0E85968674133EFAF87B47AB92F80", hash_generated_field = "96511F5C70C5D46A181196C4E4F2E0F1")

        public static final String THROTTLE_HELP_URI = "throttle_help_uri";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.204 -0500", hash_original_field = "DF15C235A23F1A30CACD651FDCA6FC80", hash_generated_field = "CEF1A9314BCD1B2BBDCC2EBD864244A2")

        public static final String THROTTLE_MAX_NTP_CACHE_AGE_SEC =
                "throttle_max_ntp_cache_age_sec";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.206 -0500", hash_original_field = "55A86B6BB82875CE29B063FF081AE2B7", hash_generated_field = "12908E6B3B1A4331BF05F2731E77CCAB")

        public static final String DOWNLOAD_MAX_BYTES_OVER_MOBILE =
                "download_manager_max_bytes_over_mobile";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.206 -0500", hash_original_field = "7193966A90E8E07839E0A25023F654D6", hash_generated_field = "4D04773FFA76C87B0E93CF136B775B26")

        public static final String DOWNLOAD_RECOMMENDED_MAX_BYTES_OVER_MOBILE =
                "download_manager_recommended_max_bytes_over_mobile";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.207 -0500", hash_original_field = "B757919709003C31835091F2A485CC62", hash_generated_field = "8AA5E3DBB58347E7F7D4B4E1C2DED769")

        public static final String INET_CONDITION_DEBOUNCE_UP_DELAY =
                "inet_condition_debounce_up_delay";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.208 -0500", hash_original_field = "B4E2752DA6CCA6FDC90AB47D48551FBA", hash_generated_field = "4E09BC4CF673CF17DA4380FCE5764B70")

        public static final String INET_CONDITION_DEBOUNCE_DOWN_DELAY =
                "inet_condition_debounce_down_delay";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.209 -0500", hash_original_field = "F7FCAD1B6CA5DE1F46A5B261B8E9035B", hash_generated_field = "D397B83F91DBD94FC9647A2CACD0B608")

        public static final String SETUP_PREPAID_DATA_SERVICE_URL =
                "setup_prepaid_data_service_url";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.210 -0500", hash_original_field = "541AFB85961DB69D87114BF72A78DD61", hash_generated_field = "6025DC08E23EA195A8ED5412557B3B24")

        public static final String SETUP_PREPAID_DETECTION_TARGET_URL =
                "setup_prepaid_detection_target_url";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.211 -0500", hash_original_field = "3CE6DB44A75727C08BAE13D2B3D0AC12", hash_generated_field = "C1A1DDAB044903312FFA6AEA41B739DE")

        public static final String SETUP_PREPAID_DETECTION_REDIR_HOST =
                "setup_prepaid_detection_redir_host";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.212 -0500", hash_original_field = "717954BAC1B50B6CED25B77086A83685", hash_generated_field = "3A541D30D8C068F9F4A7A331EDA7D5BF")

        public static final String NETSTATS_ENABLED = "netstats_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.213 -0500", hash_original_field = "D7C167E3511C2FF76B5D524107EA3DBD", hash_generated_field = "97012A614CC18C607233D0AE57406292")

        public static final String NETSTATS_POLL_INTERVAL = "netstats_poll_interval";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.214 -0500", hash_original_field = "A53943C4E44672580BF20CF08CE316EA", hash_generated_field = "3A0BC1015EDAAF28716F7514675B6E57")

        public static final String NETSTATS_PERSIST_THRESHOLD = "netstats_persist_threshold";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.215 -0500", hash_original_field = "46237111B987C73BA3C3199ACE0B0B8D", hash_generated_field = "76F0B43D9D5D5BA00AE54221441E1275")

        public static final String NETSTATS_NETWORK_BUCKET_DURATION = "netstats_network_bucket_duration";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.216 -0500", hash_original_field = "0CDE49F53293D96EA88484D37C86D911", hash_generated_field = "F7B02C2D8E41137E6FEEB5F14E792B3D")

        public static final String NETSTATS_NETWORK_MAX_HISTORY = "netstats_network_max_history";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.216 -0500", hash_original_field = "C48E22DA234B3706DEC6275D4FB95193", hash_generated_field = "C1F30A2512C5BCE8444B05D856D1CDDB")

        public static final String NETSTATS_UID_BUCKET_DURATION = "netstats_uid_bucket_duration";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.217 -0500", hash_original_field = "FD40B9324CA733BED0C85D68D3135458", hash_generated_field = "C0F27467369670AE7A4284EF89A2D19B")

        public static final String NETSTATS_UID_MAX_HISTORY = "netstats_uid_max_history";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.218 -0500", hash_original_field = "D2D536C940320B838280C19D28ACE6BF", hash_generated_field = "B95C276377C5A79D0474B105ED9407CD")

        public static final String NETSTATS_TAG_MAX_HISTORY = "netstats_tag_max_history";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.220 -0500", hash_original_field = "6ADDAE7B8FC3BD0A4B099C75F46C597A", hash_generated_field = "CA846D8261307C193530D560CA29AA1F")

        public static final String NTP_SERVER = "ntp_server";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.221 -0500", hash_original_field = "3B0CF2FAD5F2C42E2040548394B47E48", hash_generated_field = "B86CE931301F586764153CB2A56117CD")

        public static final String NTP_TIMEOUT = "ntp_timeout";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.222 -0500", hash_original_field = "6FA33D047F1298BBB06F03862624AE7E", hash_generated_field = "12E5C8B8E8ABF225189E350147C6584D")

        public static final String WEB_AUTOFILL_QUERY_URL =
            "web_autofill_query_url";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.223 -0500", hash_original_field = "707774BBE08DB618B1A4B9CB2CEDBE33", hash_generated_field = "6DD12C7462C9BCF7A6EAC57A9F7BDFD7")

        public static final String PACKAGE_VERIFIER_ENABLE = "verifier_enable";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.223 -0500", hash_original_field = "978CA411BA7D5E2F48BECFF25999440F", hash_generated_field = "49AF6C6B2403827ED5BBBB49DE820859")

        public static final String PACKAGE_VERIFIER_TIMEOUT = "verifier_timeout";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.224 -0500", hash_original_field = "3B056BCACC8CC7F8D97D1621B1DF2226", hash_generated_field = "9C84C2A6C0CC80D6843080065671E834")

        public static final String CONTACTS_PREAUTH_URI_EXPIRATION =
                "contacts_preauth_uri_expiration";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.226 -0500", hash_original_field = "BB9E312629EAF355306CEB9D3C7F1A45", hash_generated_field = "819961D47F84ED44E31C7B97E1AB9244")

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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.700 -0400", hash_original_method = "73610FEA11960E691F3222B2F82B6F9C", hash_generated_method = "73610FEA11960E691F3222B2F82B6F9C")
        public Secure ()
        {
            //Synthesized constructor
        }
    }


    
    public static final class Bookmarks implements BaseColumns {

        /**
         * Convenience function to retrieve the bookmarked Intent for a
         * particular shortcut key.
         *
         * @param cr The ContentResolver to query.
         * @param shortcut The shortcut key.
         *
         * @return Intent The bookmarked URL, or null if there is no bookmark
         *         matching the given shortcut.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.247 -0500", hash_original_method = "54DB2A6B806A611A983C56EA34B7AD6A", hash_generated_method = "30C2F07D42C3C54B446D679FEC53B969")
        public static Intent getIntentForShortcut(ContentResolver cr, char shortcut)
        {
            Intent intent = null;

            Cursor c = cr.query(CONTENT_URI,
                    sIntentProjection, sShortcutSelection,
                    new String[] { String.valueOf((int) shortcut) }, ORDERING);
            // Keep trying until we find a valid shortcut
            try {
                while (intent == null && c.moveToNext()) {
                    try {
                        String intentURI = c.getString(c.getColumnIndexOrThrow(INTENT));
                        intent = Intent.parseUri(intentURI, 0);
                    } catch (java.net.URISyntaxException e) {
                        // The stored URL is bad...  ignore it.
                    } catch (IllegalArgumentException e) {
                        // Column not found
                        Log.w(TAG, "Intent column not found", e);
                    }
                }
            } finally {
                if (c != null) c.close();
            }

            return intent;
        }

        /**
         * Add a new bookmark to the system.
         *
         * @param cr The ContentResolver to query.
         * @param intent The desired target of the bookmark.
         * @param title Bookmark title that is shown to the user; null if none
         *            or it should be resolved to the intent's title.
         * @param folder Folder in which to place the bookmark; null if none.
         * @param shortcut Shortcut that will invoke the bookmark; 0 if none. If
         *            this is non-zero and there is an existing bookmark entry
         *            with this same shortcut, then that existing shortcut is
         *            cleared (the bookmark is not removed).
         * @return The unique content URL for the new bookmark entry.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.248 -0500", hash_original_method = "DE029E7F723B320891C027CB0C38824B", hash_generated_method = "42D40A1613DAF9C65DEE120112EF352F")
        public static Uri add(ContentResolver cr,
                                           Intent intent,
                                           String title,
                                           String folder,
                                           char shortcut,
                                           int ordering)
        {
            // If a shortcut is supplied, and it is already defined for
            // another bookmark, then remove the old definition.
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

        /**
         * Return the folder name as it should be displayed to the user.  This
         * takes care of localizing special folders.
         *
         * @param r Resources object for current locale; only need access to
         *          system resources.
         * @param folder The value found in the {@link #FOLDER} column.
         *
         * @return CharSequence The label for this folder that should be shown
         *         to the user.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.249 -0500", hash_original_method = "906E03827D89C4CEA0BE70B198F9463B", hash_generated_method = "DEF88F8284054F8954D22926A5EADC81")
        public static CharSequence getLabelForFolder(Resources r, String folder) {
            return folder;
        }

        /**
         * Return the title as it should be displayed to the user. This takes
         * care of localizing bookmarks that point to activities.
         *
         * @param context A context.
         * @param cursor A cursor pointing to the row whose title should be
         *        returned. The cursor must contain at least the {@link #TITLE}
         *        and {@link #INTENT} columns.
         * @return A title that is localized and can be displayed to the user,
         *         or the empty string if one could not be found.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.250 -0500", hash_original_method = "CEF1D2F717830086ECA4871334F6B001", hash_generated_method = "3EC304D62692B33131B3CA88A5083CAF")
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.236 -0500", hash_original_field = "A93CE64F477FE079D3034A9948D130F9", hash_generated_field = "127C508760F30C38F353D1C0CBBEF438")

        private static final String TAG = "Bookmarks";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.237 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "9B4329FE7D67E931B8E4A01B2E427FBD")

        public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/bookmarks");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.239 -0500", hash_original_field = "F0D3FDD50AE0B4B355D4DA426C7375CD", hash_generated_field = "3C2D71BF930B87FEECA9710D884C1BB3")

        public static final String ID = "_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.239 -0500", hash_original_field = "A5249F61E8BCAFD7BA526765268E7EE8", hash_generated_field = "CC2A30295F4B54C534C25CFD7CF431A8")

        public static final String TITLE = "title";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.240 -0500", hash_original_field = "41A3AF8368694497AED957840C881729", hash_generated_field = "DD8A26393BA86076DC51024889C84FE7")

        public static final String FOLDER = "folder";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.241 -0500", hash_original_field = "968B75AAC6005A82796991685920C719", hash_generated_field = "7E52CAF6C787537A717EB72023CCE33A")

        public static final String INTENT = "intent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.242 -0500", hash_original_field = "2D8777F814456BC64BD37E741A140B02", hash_generated_field = "EEDCDED121F192CA9B8B682E02970453")

        public static final String SHORTCUT = "shortcut";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.243 -0500", hash_original_field = "771323AC1348F01058EA66E5A8CDE1AB", hash_generated_field = "1FD5DCEFECBA3CDA9C3F1D8D6E8FCEA5")

        public static final String ORDERING = "ordering";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.244 -0500", hash_original_field = "2DF512845F96B6882194068B5BFCEE6A", hash_generated_field = "8180CFF9E48F414363A8B1B2ED6E8B23")


        private static final String[] sIntentProjection = { INTENT };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.245 -0500", hash_original_field = "F95170514B6E835A883C9423A27D958C", hash_generated_field = "BD85472E85B987B3E065F1D4D68B7324")

        private static final String[] sShortcutProjection = { ID, SHORTCUT };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.246 -0500", hash_original_field = "CDF402DC1A2B09F589CB90E5416761C9", hash_generated_field = "9BB18B2121BFAC2716EBD72A795718CD")

        private static final String sShortcutSelection = SHORTCUT + "=?";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.709 -0400", hash_original_method = "BB83E969FD06D277BEC07ACFEA741415", hash_generated_method = "BB83E969FD06D277BEC07ACFEA741415")
        public Bookmarks ()
        {
            //Synthesized constructor
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.767 -0500", hash_original_field = "8F1ABA87A4BFC89EC68298118AFEA797", hash_generated_field = "B864194FB055615089C91C29E87B0523")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_APN_SETTINGS = "android.settings.APN_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.768 -0500", hash_original_field = "D1D2EB623E98A0F30C3648C3FB1F5EF6", hash_generated_field = "1B4DE5836DE2E2C992166C7C97D4A2A4")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_LOCATION_SOURCE_SETTINGS =
            "android.settings.LOCATION_SOURCE_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.769 -0500", hash_original_field = "4EE614E58CF78CE43A77702B5DE43926", hash_generated_field = "55254051251EE11D83C2A6F39B89E63A")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_WIRELESS_SETTINGS =
            "android.settings.WIRELESS_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.770 -0500", hash_original_field = "0102A00050CB330EE2B194ACE96B933D", hash_generated_field = "01F344B29B140AB2B787B57FA9A1E1A4")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_AIRPLANE_MODE_SETTINGS =
            "android.settings.AIRPLANE_MODE_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.771 -0500", hash_original_field = "D559DA49438C3F39E49EAE08F5B3106C", hash_generated_field = "B2368D64E6C3AC32800919939DF58E78")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ACCESSIBILITY_SETTINGS =
            "android.settings.ACCESSIBILITY_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.772 -0500", hash_original_field = "C3E34CDC73AA4AA1B0A66DA2EF0FE46C", hash_generated_field = "A240EFA9E6595AC7D5401FC441997E80")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SECURITY_SETTINGS =
            "android.settings.SECURITY_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.773 -0500", hash_original_field = "F66F8803769D4762051C4B7176239B2F", hash_generated_field = "6FE8E2AD5E161D29BF56D151531C7699")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_PRIVACY_SETTINGS =
            "android.settings.PRIVACY_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.774 -0500", hash_original_field = "1BFD90CB97C170DAC0FFEBC720D7BA95", hash_generated_field = "716648F784E2F1844AAB6788FE172E3A")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_WIFI_SETTINGS =
            "android.settings.WIFI_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.775 -0500", hash_original_field = "28E05C11DEFE22BD33598986905F9DC7", hash_generated_field = "C7FC3278DEB3C1BF7553DFADE4ECF0A2")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_WIFI_IP_SETTINGS =
            "android.settings.WIFI_IP_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.775 -0500", hash_original_field = "EA94E648074A69E7255B7FE6718953F0", hash_generated_field = "8A632A9B9A10F0E522882BF1A7EF7B57")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_BLUETOOTH_SETTINGS =
            "android.settings.BLUETOOTH_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.776 -0500", hash_original_field = "90ED1694FC54C9BE29D730BFFB245CB4", hash_generated_field = "4C2E0718510D13E88526D0FA27F74D3F")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_DATE_SETTINGS =
            "android.settings.DATE_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.777 -0500", hash_original_field = "CE1654D2C75E38CC3D2B418176ADE0C4", hash_generated_field = "A0E974CC475E770F870EBD1DD075F4BA")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SOUND_SETTINGS =
            "android.settings.SOUND_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.778 -0500", hash_original_field = "52EA3752877CE0B46017266AFD196FA2", hash_generated_field = "40A499BB1112150B1B741AAC14A5C9A5")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_DISPLAY_SETTINGS =
            "android.settings.DISPLAY_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.780 -0500", hash_original_field = "756E59C05AC9C2D28F6BF2372E6FD277", hash_generated_field = "D8F4D2F5FB2B704BCB0B300338FB258D")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_LOCALE_SETTINGS =
            "android.settings.LOCALE_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.781 -0500", hash_original_field = "FBE6169BCEF32FFBC284B4CC55B79582", hash_generated_field = "7CE68EDFA3A8F2FE9BECC07CC52D9F82")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_INPUT_METHOD_SETTINGS =
            "android.settings.INPUT_METHOD_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.781 -0500", hash_original_field = "1E0E86301A65E9D7AA2080F047BA97F9", hash_generated_field = "4AAC09FF7BB0DE02F9C046BE1F7BEF42")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_INPUT_METHOD_SUBTYPE_SETTINGS =
            "android.settings.INPUT_METHOD_SUBTYPE_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.782 -0500", hash_original_field = "3B228022B180E9F22F7950E34E7628EB", hash_generated_field = "5BC01803EDC5010007F13BF8554E3D09")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SHOW_INPUT_METHOD_PICKER =
            "android.settings.SHOW_INPUT_METHOD_PICKER";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.783 -0500", hash_original_field = "7339050B38FDD9EB09766EA89AF09787", hash_generated_field = "F09BD83AD7BC98DA71F06E4EDC1C23F4")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_USER_DICTIONARY_SETTINGS =
            "android.settings.USER_DICTIONARY_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.784 -0500", hash_original_field = "CCB5001F8C1DCB9E8F49C3647FBFB3A2", hash_generated_field = "AA6CA7099234F41E42BC202ECAAB87C5")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_USER_DICTIONARY_INSERT =
            "com.android.settings.USER_DICTIONARY_INSERT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.786 -0500", hash_original_field = "FEB70758EFACF43B0DA54CC4DC9706D5", hash_generated_field = "87C568575A91A6E6EE16A274D46AF87C")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_APPLICATION_SETTINGS =
            "android.settings.APPLICATION_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.787 -0500", hash_original_field = "CBA681DA8CBD9C619268C6D539241462", hash_generated_field = "24DEEECBCBF74CF6915698F12F5917E3")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_APPLICATION_DEVELOPMENT_SETTINGS =
            "android.settings.APPLICATION_DEVELOPMENT_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.788 -0500", hash_original_field = "DD354B78797A9AD3D622A98C77A372FA", hash_generated_field = "5386F6E15F233B1A67E22162CF465CB6")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_QUICK_LAUNCH_SETTINGS =
            "android.settings.QUICK_LAUNCH_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.788 -0500", hash_original_field = "A7E7E8C2D374AE95B0381DF60B947217", hash_generated_field = "8FCAD26C944DCD49FB213DDDEBE72A3C")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_MANAGE_APPLICATIONS_SETTINGS =
            "android.settings.MANAGE_APPLICATIONS_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.789 -0500", hash_original_field = "92582E78EB5EEB9425BE9A14EC01A09D", hash_generated_field = "7F0254EEEBD6BEAC8BA1084E39048541")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS =
            "android.settings.MANAGE_ALL_APPLICATIONS_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.790 -0500", hash_original_field = "CC9B7C5E05006A4D7C84485A6B9F0D54", hash_generated_field = "D544C7AFF247A709115F841B03FCE1C2")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_APPLICATION_DETAILS_SETTINGS =
            "android.settings.APPLICATION_DETAILS_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.791 -0500", hash_original_field = "00E5DB74B02F74371FD0C095E3FA5858", hash_generated_field = "3311ADDA4CC906EE61643A6A1942072D")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SYSTEM_UPDATE_SETTINGS =
            "android.settings.SYSTEM_UPDATE_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.792 -0500", hash_original_field = "8F07D9137EBFC4052BE675C1CC28889A", hash_generated_field = "2A62D0DEF68AC940CCFCA15A8154713F")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SYNC_SETTINGS =
            "android.settings.SYNC_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.799 -0500", hash_original_field = "2A56F7DAF0B2D9919620F2FC77B928D9", hash_generated_field = "9815DDB9E86EC2442899690F191EFD2A")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ADD_ACCOUNT =
            "android.settings.ADD_ACCOUNT_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.800 -0500", hash_original_field = "894137680260E8A8D5DA2E187DB59264", hash_generated_field = "0B25005AF669A43258DB75201D42AF3C")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_NETWORK_OPERATOR_SETTINGS =
            "android.settings.NETWORK_OPERATOR_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.801 -0500", hash_original_field = "8ED6DA6362BEE5A09F6AE21ACE4F86B0", hash_generated_field = "9F19D1DCCEC10730EB3AD96B3ABA527B")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_DATA_ROAMING_SETTINGS =
            "android.settings.DATA_ROAMING_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.802 -0500", hash_original_field = "8CB53E3CCF84382AF8D7A08D2329B358", hash_generated_field = "991BA9F0556092E8C022020DB49CF050")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_INTERNAL_STORAGE_SETTINGS =
            "android.settings.INTERNAL_STORAGE_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.803 -0500", hash_original_field = "1F0D491AC0B00C8D986A6D924E312489", hash_generated_field = "9114C57B1B31D4D36266D5840988DFA4")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_MEMORY_CARD_SETTINGS =
            "android.settings.MEMORY_CARD_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.804 -0500", hash_original_field = "3CCD75148B62E0E3BB3C1EDEC127DF76", hash_generated_field = "612E2ADE94C5D1439222FBA63863BB07")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SEARCH_SETTINGS =
        "android.search.action.SEARCH_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.805 -0500", hash_original_field = "D38A5B16C6D39AFF10DEE9F4FF40F80E", hash_generated_field = "9B65D0366D61656ADBD4A551B8D5E287")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_DEVICE_INFO_SETTINGS =
        "android.settings.DEVICE_INFO_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.806 -0500", hash_original_field = "FFD7F7BDC8A557BF0CC79647CB602B17", hash_generated_field = "A3E074268BD269D0A2C84D260E3F1CB9")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_NFCSHARING_SETTINGS =
        "android.settings.NFCSHARING_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:27.345 -0500", hash_original_field = "F696B18A02C183C9FC46813A261DC967", hash_generated_field = "3DC3DBF8E51BA34EB356BB488CD0D230")


    /**
     * @hide - Private call() method on SettingsProvider to read from 'system' table.
     */
    public static final String CALL_METHOD_GET_SYSTEM = "GET_system";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.808 -0500", hash_original_field = "F2CC6E9ABC62B39D7CDC8B9D9359EFE0", hash_generated_field = "9F29BC105FB7A34DCE42B5192B7DA58B")

    public static final String CALL_METHOD_GET_SECURE = "GET_secure";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.808 -0500", hash_original_field = "EB338F1A9D43D7B9011191984EAC07E9", hash_generated_field = "115F2752CF91CE8BB4B451C26473D380")

    public static final String EXTRA_AUTHORITIES =
            "authorities";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.809 -0500", hash_original_field = "CE91525B6D6031FFAD7F8369ECB0C6E4", hash_generated_field = "BE07686D6DDCE88474EBF79A4C1DA4BA")


    public static final String EXTRA_INPUT_METHOD_ID = "input_method_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.810 -0500", hash_original_field = "79656B7EF44E2649028B6EF7BB68802A", hash_generated_field = "60DD209E3682CBC18875FE018DF89859")


    private static final String JID_RESOURCE_PREFIX = "android";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.811 -0500", hash_original_field = "07E8BE0AFEC9C3FBAAC1E4277ADABE48", hash_generated_field = "CD4CCC4B63A1B6D8CDBF90B4044135B5")


    public static final String AUTHORITY = "settings";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.812 -0500", hash_original_field = "5FBC5D4AEF7186429BB6B1EB6981FFF2", hash_generated_field = "DED9CEFD20FC00D326CC6FBA5A0A509B")


    private static final String TAG = "Settings";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:44.813 -0500", hash_original_field = "A2815BD26E87A627B478F0A2FA303B22", hash_generated_field = "D2585F3BB04C12E7EFFE278BED4DADF8")

    private static final boolean LOCAL_LOGV = false || false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.671 -0400", hash_original_method = "D105991E634C8DCAFDA0F30054C63045", hash_generated_method = "D105991E634C8DCAFDA0F30054C63045")
    public Settings ()
    {
        //Synthesized constructor
    }
}

