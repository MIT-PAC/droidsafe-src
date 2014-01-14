package android.preference;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.XmlResourceParser;
import android.os.Bundle;

public class PreferenceManager {
    
    /**
     * Gets a SharedPreferences instance that points to the default file that is
     * used by the preference framework in the given context.
     * 
     * @param context The context of the preferences whose values are wanted.
     * @return A SharedPreferences instance that can be used to retrieve and
     *         listen to values of the preferences.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.726 -0500", hash_original_method = "DEE839A83C4B35ACEA8CCC2B71E2B5D1", hash_generated_method = "2B16C131215B04C3D72C14303B6B379E")
    
public static SharedPreferences getDefaultSharedPreferences(Context context) {
        return context.getSharedPreferences(getDefaultSharedPreferencesName(context),
                getDefaultSharedPreferencesMode());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.728 -0500", hash_original_method = "42C9CE230DD05245AC0F1F15B9BA0F77", hash_generated_method = "C0A43771BC0878E5F7FF1D24F0A68563")
    
private static String getDefaultSharedPreferencesName(Context context) {
        return context.getPackageName() + "_preferences";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.730 -0500", hash_original_method = "9A4A0B76FBD75A7A2387EF85E0D2FD54", hash_generated_method = "D84FC8AF76E7CF2269D44A6A6D9A3736")
    
private static int getDefaultSharedPreferencesMode() {
        return Context.MODE_PRIVATE;
    }
    
    /**
     * Sets the default values from a preference hierarchy in XML. This should
     * be called by the application's main activity.
     * <p>
     * If {@code readAgain} is false, this will only set the default values if this
     * method has never been called in the past (or the
     * {@link #KEY_HAS_SET_DEFAULT_VALUES} in the default value shared
     * preferences file is false). To attempt to set the default values again
     * bypassing this check, set {@code readAgain} to true.
     * 
     * @param context The context of the shared preferences.
     * @param resId The resource ID of the preference hierarchy XML file.
     * @param readAgain Whether to re-read the default values.
     *            <p>
     *            Note: this will NOT reset preferences back to their default
     *            values. For that functionality, use
     *            {@link PreferenceManager#getDefaultSharedPreferences(Context)}
     *            and clear it followed by a call to this method with this
     *            parameter set to true.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.739 -0500", hash_original_method = "1B08E289995C6C21F5C2BC4F9B6F5187", hash_generated_method = "3DC84A33A3C2DB62DE5115DFA6B9F88B")
    
public static void setDefaultValues(Context context, int resId, boolean readAgain) {
        
        // Use the default shared preferences name and mode
        setDefaultValues(context, getDefaultSharedPreferencesName(context),
                getDefaultSharedPreferencesMode(), resId, readAgain);
    }
    
    /**
     * Similar to {@link #setDefaultValues(Context, int, boolean)} but allows
     * the client to provide the filename and mode of the shared preferences
     * file.
     * 
     * @see #setDefaultValues(Context, int, boolean)
     * @see #setSharedPreferencesName(String)
     * @see #setSharedPreferencesMode(int)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.741 -0500", hash_original_method = "9646A9372ECC55871733A680E62A72CA", hash_generated_method = "2F9BBD3261B2D934E006F58101CB7E9C")
    
public static void setDefaultValues(Context context, String sharedPreferencesName,
            int sharedPreferencesMode, int resId, boolean readAgain) {
        final SharedPreferences defaultValueSp = context.getSharedPreferences(
                KEY_HAS_SET_DEFAULT_VALUES, Context.MODE_PRIVATE);
        
        if (readAgain || !defaultValueSp.getBoolean(KEY_HAS_SET_DEFAULT_VALUES, false)) {
            final PreferenceManager pm = new PreferenceManager(context);
            pm.setSharedPreferencesName(sharedPreferencesName);
            pm.setSharedPreferencesMode(sharedPreferencesMode);
            pm.inflateFromResource(context, resId, null);

            SharedPreferences.Editor editor =
                    defaultValueSp.edit().putBoolean(KEY_HAS_SET_DEFAULT_VALUES, true);
            try {
                editor.apply();
            } catch (AbstractMethodError unused) {
                // The app injected its own pre-Gingerbread
                // SharedPreferences.Editor implementation without
                // an apply method.
                editor.commit();
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.652 -0500", hash_original_field = "3A3BD45FA93DD50F7F6C52D2CEF15DB2", hash_generated_field = "7AAEA04E4548D5AB6EC8143F21A30EA9")
    
    private static final String TAG = "PreferenceManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.654 -0500", hash_original_field = "F86CBB3D5E7D46D5EC5C061B27A4EB7F", hash_generated_field = "6C182C497B18AE33867D48A4D7F5655E")

    public static final String METADATA_KEY_PREFERENCES = "android.preference";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.656 -0500", hash_original_field = "A25C8F9EA6A0FB10147CB42E8AE48EF6", hash_generated_field = "99247B06873D9B62D5B8F33E5FB96366")
    
    public static final String KEY_HAS_SET_DEFAULT_VALUES = "_has_set_default_values";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.658 -0500", hash_original_field = "3895D7E6DB5042DA7856DC78E391C7B9", hash_generated_field = "B0D69375984D6EE7DC93AC12DB4DFC55")

    private Activity mActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.661 -0500", hash_original_field = "8520498A009FD770816A73BC7BBAAE33", hash_generated_field = "CFB43EBA13761D69B30BE1C8ABC90FE3")

    private PreferenceFragment mFragment;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.663 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.665 -0500", hash_original_field = "94D2C61B90F9DDCEA6229CFD1BD4B5A5", hash_generated_field = "5707822036BF051C0059AD070444BD58")

    private long mNextId = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.667 -0500", hash_original_field = "0BEC202ACD2F4B80A9D91BEF44E417AC", hash_generated_field = "AD359E85C996698973B9458D92AF4B64")

    private int mNextRequestCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.669 -0500", hash_original_field = "6863CBC1FD02A5848172EE011B9C880B", hash_generated_field = "E69BF347D3F561905392BD5BBB86A4AF")

    private SharedPreferences mSharedPreferences;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.671 -0500", hash_original_field = "C2C898D216011536ABB52408727E0074", hash_generated_field = "93BFA57AAD9A25C531F3726BE9E311D1")

    private SharedPreferences.Editor mEditor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.673 -0500", hash_original_field = "DD8CF6ABD3E3C3CF856EF58396F040C3", hash_generated_field = "0870CFBDAD0F12B21EFE736694E5D5A0")

    private boolean mNoCommit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.675 -0500", hash_original_field = "84C67C1FD7D5449453BD7928216DE986", hash_generated_field = "08A9F51924058A9BDDEB8AE59F95CBF8")

    private String mSharedPreferencesName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.677 -0500", hash_original_field = "A3A8925479C449E7BF4F11709ABEAFA6", hash_generated_field = "3DFD0E17BB5556DF650F1E4262E37691")

    private int mSharedPreferencesMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.679 -0500", hash_original_field = "FA341E6EF4A389944B6ABCC0C00AA260", hash_generated_field = "6929FA68B759CC402927F67ADE03851B")

    private PreferenceScreen mPreferenceScreen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.681 -0500", hash_original_field = "5A55F2E03C7E028B9F56681221DAC65B", hash_generated_field = "759FE206EC137F2D102DEE69CB506E29")

    private List<OnActivityResultListener> mActivityResultListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.684 -0500", hash_original_field = "B48C98E3D9D54A0CB2952B7439998405", hash_generated_field = "AB511ABA80C53F6AD5EC1856C35DAF7F")

    private List<OnActivityStopListener> mActivityStopListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.686 -0500", hash_original_field = "C29EDB5974FA1CC8018E563C739E55BF", hash_generated_field = "ED711A008E3B4CD7A93067555688693E")

    private List<OnActivityDestroyListener> mActivityDestroyListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.688 -0500", hash_original_field = "DDDDE82983F75A043C150207C23DA1FF", hash_generated_field = "EEC46A0D6BAD420AFB426C404E85D2BA")

    private List<DialogInterface> mPreferencesScreens;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.690 -0500", hash_original_field = "7B1980F7CD2856B99E6CF8987DD8E986", hash_generated_field = "420F1647C8F11E826C9DE0A838CD7533")
    
    private OnPreferenceTreeClickListener mOnPreferenceTreeClickListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.693 -0500", hash_original_method = "A48679E26B4CF910ADEF8C7563331346", hash_generated_method = "A48679E26B4CF910ADEF8C7563331346")
    
PreferenceManager(Activity activity, int firstRequestCode) {
        mActivity = activity;
        mNextRequestCode = firstRequestCode;
        
        init(activity);
    }

    /**
     * This constructor should ONLY be used when getting default values from
     * an XML preference hierarchy.
     * <p>
     * The {@link PreferenceManager#PreferenceManager(Activity)}
     * should be used ANY time a preference will be displayed, since some preference
     * types need an Activity for managed queries.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.695 -0500", hash_original_method = "962D66AE85693F6FF77A2DEF54D76478", hash_generated_method = "F4455A393DE301F35622852BA02E91EE")
    
private PreferenceManager(Context context) {
        init(context);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.697 -0500", hash_original_method = "2AA94A8F94EE739DE2B0DB27540BEB34", hash_generated_method = "E716CEF61FDD32C708F8A58ED93D2B72")
    
private void init(Context context) {
        mContext = context;
        
        setSharedPreferencesName(getDefaultSharedPreferencesName(context));
    }

    /**
     * Sets the owning preference fragment
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.699 -0500", hash_original_method = "922F3E36F99E52FA3036E92080002B11", hash_generated_method = "922F3E36F99E52FA3036E92080002B11")
    
void setFragment(PreferenceFragment fragment) {
        mFragment = fragment;
    }

    /**
     * Returns the owning preference fragment, if any.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.701 -0500", hash_original_method = "11BC570017448843B9A9A22E52E0E479", hash_generated_method = "11BC570017448843B9A9A22E52E0E479")
    
PreferenceFragment getFragment() {
        return mFragment;
    }

    /**
     * Returns a list of {@link Activity} (indirectly) that match a given
     * {@link Intent}.
     * 
     * @param queryIntent The Intent to match.
     * @return The list of {@link ResolveInfo} that point to the matched
     *         activities.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.703 -0500", hash_original_method = "6682C9F88019B1A37FE99B0D2B3B34A2", hash_generated_method = "051844387A24EAE487A48C8117E4273D")
    
private List<ResolveInfo> queryIntentActivities(Intent queryIntent) {
        return mContext.getPackageManager().queryIntentActivities(queryIntent,
                PackageManager.GET_META_DATA);
    }
    
    /**
     * Inflates a preference hierarchy from the preference hierarchies of
     * {@link Activity Activities} that match the given {@link Intent}. An
     * {@link Activity} defines its preference hierarchy with meta-data using
     * the {@link #METADATA_KEY_PREFERENCES} key.
     * <p>
     * If a preference hierarchy is given, the new preference hierarchies will
     * be merged in.
     * 
     * @param queryIntent The intent to match activities.
     * @param rootPreferences Optional existing hierarchy to merge the new
     *            hierarchies into.
     * @return The root hierarchy (if one was not provided, the new hierarchy's
     *         root).
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.707 -0500", hash_original_method = "96A93C80BB9070BDED20D9AB85FFA8E8", hash_generated_method = "DBE5D9014245D9646FD40A2413C6069E")
    
PreferenceScreen inflateFromIntent(Intent queryIntent, PreferenceScreen rootPreferences) {
        final List<ResolveInfo> activities = queryIntentActivities(queryIntent);
        final HashSet<String> inflatedRes = new HashSet<String>();

        for (int i = activities.size() - 1; i >= 0; i--) {
            final ActivityInfo activityInfo = activities.get(i).activityInfo;
            final Bundle metaData = activityInfo.metaData;

            if ((metaData == null) || !metaData.containsKey(METADATA_KEY_PREFERENCES)) {
                continue;
            }

            // Need to concat the package with res ID since the same res ID
            // can be re-used across contexts
            final String uniqueResId = activityInfo.packageName + ":"
                    + activityInfo.metaData.getInt(METADATA_KEY_PREFERENCES);
            
            if (!inflatedRes.contains(uniqueResId)) {
                inflatedRes.add(uniqueResId);

                final Context context;
                try {
                    context = mContext.createPackageContext(activityInfo.packageName, 0);
                } catch (NameNotFoundException e) {
                    Log.w(TAG, "Could not create context for " + activityInfo.packageName + ": "
                        + Log.getStackTraceString(e));
                    continue;
                }
                
                final PreferenceInflater inflater = new PreferenceInflater(context, this);
                final XmlResourceParser parser = activityInfo.loadXmlMetaData(context
                        .getPackageManager(), METADATA_KEY_PREFERENCES);
                rootPreferences = (PreferenceScreen) inflater
                        .inflate(parser, rootPreferences, true);
                parser.close();
            }
        }

        rootPreferences.onAttachedToHierarchy(this);
        
        return rootPreferences;
    }

    /**
     * Inflates a preference hierarchy from XML. If a preference hierarchy is
     * given, the new preference hierarchies will be merged in.
     * 
     * @param context The context of the resource.
     * @param resId The resource ID of the XML to inflate.
     * @param rootPreferences Optional existing hierarchy to merge the new
     *            hierarchies into.
     * @return The root hierarchy (if one was not provided, the new hierarchy's
     *         root).
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.709 -0500", hash_original_method = "94F9DF66CFF516C2DE1B651AB9A3388E", hash_generated_method = "F0AFDC09FF8BB70BC36CA61F47DEE655")
    
public PreferenceScreen inflateFromResource(Context context, int resId,
            PreferenceScreen rootPreferences) {
        // Block commits
        setNoCommit(true);

        final PreferenceInflater inflater = new PreferenceInflater(context, this);
        rootPreferences = (PreferenceScreen) inflater.inflate(resId, rootPreferences, true);
        rootPreferences.onAttachedToHierarchy(this);

        // Unblock commits
        setNoCommit(false);

        return rootPreferences;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.711 -0500", hash_original_method = "AE92D4BACEE41B351C64A7E59B1B4342", hash_generated_method = "E2CDEBF8828B208E67A9E92B6039C90D")
    
public PreferenceScreen createPreferenceScreen(Context context) {
        final PreferenceScreen preferenceScreen = new PreferenceScreen(context, null);
        preferenceScreen.onAttachedToHierarchy(this);
        return preferenceScreen;
    }
    
    /**
     * Called by a preference to get a unique ID in its hierarchy.
     * 
     * @return A unique ID.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.713 -0500", hash_original_method = "D904EAF0B6D90BB52E1F8594EC3F4D15", hash_generated_method = "D904EAF0B6D90BB52E1F8594EC3F4D15")
    
long getNextId() {
        synchronized (this) {
            return mNextId++;
        }
    }
    
    /**
     * Returns the current name of the SharedPreferences file that preferences managed by
     * this will use.
     * 
     * @return The name that can be passed to {@link Context#getSharedPreferences(String, int)}.
     * @see Context#getSharedPreferences(String, int)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.715 -0500", hash_original_method = "BDB110631059975A566BD4AA87A106E8", hash_generated_method = "D7DFCD75F95FBE67D23A3991103EABD7")
    
public String getSharedPreferencesName() {
        return mSharedPreferencesName;
    }

    /**
     * Sets the name of the SharedPreferences file that preferences managed by this
     * will use.
     * 
     * @param sharedPreferencesName The name of the SharedPreferences file.
     * @see Context#getSharedPreferences(String, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.717 -0500", hash_original_method = "F8FB75CAC643ECF72FE6E9CDE35245C6", hash_generated_method = "D3C3B5611FB8BEDC3068F55C7516B295")
    
public void setSharedPreferencesName(String sharedPreferencesName) {
        mSharedPreferencesName = sharedPreferencesName;
        mSharedPreferences = null;
    }

    /**
     * Returns the current mode of the SharedPreferences file that preferences managed by
     * this will use.
     * 
     * @return The mode that can be passed to {@link Context#getSharedPreferences(String, int)}.
     * @see Context#getSharedPreferences(String, int)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.719 -0500", hash_original_method = "D2CF6E8640E20A030077A21285843C05", hash_generated_method = "B34187E4A80B6C182ADA869B95EED2EC")
    
public int getSharedPreferencesMode() {
        return mSharedPreferencesMode;
    }

    /**
     * Sets the mode of the SharedPreferences file that preferences managed by this
     * will use.
     * 
     * @param sharedPreferencesMode The mode of the SharedPreferences file.
     * @see Context#getSharedPreferences(String, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.721 -0500", hash_original_method = "6988E36A0998B14CBE7D70DCBAB74FF8", hash_generated_method = "8C8607EA8C2F96D19E7B38EF0A94EFB6")
    
public void setSharedPreferencesMode(int sharedPreferencesMode) {
        mSharedPreferencesMode = sharedPreferencesMode;
        mSharedPreferences = null;
    }

    /**
     * Gets a SharedPreferences instance that preferences managed by this will
     * use.
     * 
     * @return A SharedPreferences instance pointing to the file that contains
     *         the values of preferences that are managed by this.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.724 -0500", hash_original_method = "B901A30CD0A7131EC29E8BD072ADC21D", hash_generated_method = "9CA9AF2288C06BC076812E1B81D8C766")
    
public SharedPreferences getSharedPreferences() {
        if (mSharedPreferences == null) {
            mSharedPreferences = mContext.getSharedPreferences(mSharedPreferencesName,
                    mSharedPreferencesMode);
        }
        
        return mSharedPreferences;
    }

    /**
     * Returns the root of the preference hierarchy managed by this class.
     *  
     * @return The {@link PreferenceScreen} object that is at the root of the hierarchy.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.732 -0500", hash_original_method = "60967B21FA602EB86E9B5EB647B08AF2", hash_generated_method = "60967B21FA602EB86E9B5EB647B08AF2")
    
PreferenceScreen getPreferenceScreen() {
        return mPreferenceScreen;
    }
    
    /**
     * Sets the root of the preference hierarchy.
     * 
     * @param preferenceScreen The root {@link PreferenceScreen} of the preference hierarchy.
     * @return Whether the {@link PreferenceScreen} given is different than the previous. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.734 -0500", hash_original_method = "72F330353D1AAD0C361FC98ABB0551E0", hash_generated_method = "72F330353D1AAD0C361FC98ABB0551E0")
    
boolean setPreferences(PreferenceScreen preferenceScreen) {
        if (preferenceScreen != mPreferenceScreen) {
            mPreferenceScreen = preferenceScreen;
            return true;
        }
        
        return false;
    }
    
    /**
     * Finds a {@link Preference} based on its key.
     * 
     * @param key The key of the preference to retrieve.
     * @return The {@link Preference} with the key, or null.
     * @see PreferenceGroup#findPreference(CharSequence)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.737 -0500", hash_original_method = "313075D13AC6A3D78BD3127C39A86211", hash_generated_method = "17D4C85ACE0ADBEB3C87DB5BE0FA1596")
    
public Preference findPreference(CharSequence key) {
        if (mPreferenceScreen == null) {
            return null;
        }
        
        return mPreferenceScreen.findPreference(key);
    }
    
    /**
     * Returns an editor to use when modifying the shared preferences.
     * <p>
     * Do NOT commit unless {@link #shouldCommit()} returns true.
     * 
     * @return An editor to use to write to shared preferences.
     * @see #shouldCommit()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.743 -0500", hash_original_method = "D4733D45210A4F96431F976F3F9AB3C2", hash_generated_method = "D4733D45210A4F96431F976F3F9AB3C2")
    
SharedPreferences.Editor getEditor() {
        
        if (mNoCommit) {
            if (mEditor == null) {
                mEditor = getSharedPreferences().edit();
            }
            
            return mEditor;
        } else {
            return getSharedPreferences().edit();
        }
    }
    
    /**
     * Whether it is the client's responsibility to commit on the
     * {@link #getEditor()}. This will return false in cases where the writes
     * should be batched, for example when inflating preferences from XML.
     * 
     * @return Whether the client should commit.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.746 -0500", hash_original_method = "47C154426E8AAB84597A7B272BF8D2FA", hash_generated_method = "47C154426E8AAB84597A7B272BF8D2FA")
    
boolean shouldCommit() {
        return !mNoCommit;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.748 -0500", hash_original_method = "2ED947FD2CD87E45A298D362CE1C3C54", hash_generated_method = "E1BD2FA4925352CE9F59025D474FA77C")
    
private void setNoCommit(boolean noCommit) {
        if (!noCommit && mEditor != null) {
            try {
                mEditor.apply();
            } catch (AbstractMethodError unused) {
                // The app injected its own pre-Gingerbread
                // SharedPreferences.Editor implementation without
                // an apply method.
                mEditor.commit();
            }
        }
        mNoCommit = noCommit;
    }

    /**
     * Returns the activity that shows the preferences. This is useful for doing
     * managed queries, but in most cases the use of {@link #getContext()} is
     * preferred.
     * <p>
     * This will return null if this class was instantiated with a Context
     * instead of Activity. For example, when setting the default values.
     * 
     * @return The activity that shows the preferences.
     * @see #mContext
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.751 -0500", hash_original_method = "3F17133E8D63AE8C7414DC58966291E3", hash_generated_method = "3F17133E8D63AE8C7414DC58966291E3")
    
Activity getActivity() {
        return mActivity;
    }
    
    /**
     * Returns the context. This is preferred over {@link #getActivity()} when
     * possible.
     * 
     * @return The context.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.753 -0500", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "4F4EBC54D108D66F416C93B46580E117")
    
Context getContext() {
        return mContext;
    }

    /**
     * Registers a listener.
     * 
     * @see OnActivityResultListener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.755 -0500", hash_original_method = "8C7924F669844968ABD2440B12D35A69", hash_generated_method = "8C7924F669844968ABD2440B12D35A69")
    
void registerOnActivityResultListener(OnActivityResultListener listener) {
        synchronized (this) {
            if (mActivityResultListeners == null) {
                mActivityResultListeners = new ArrayList<OnActivityResultListener>();
            }
            
            if (!mActivityResultListeners.contains(listener)) {
                mActivityResultListeners.add(listener);
            }
        }
    }

    /**
     * Unregisters a listener.
     * 
     * @see OnActivityResultListener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.757 -0500", hash_original_method = "2F16D3A7CC67220808B5AF6C63D00415", hash_generated_method = "2F16D3A7CC67220808B5AF6C63D00415")
    
void unregisterOnActivityResultListener(OnActivityResultListener listener) {
        synchronized (this) {
            if (mActivityResultListeners != null) {
                mActivityResultListeners.remove(listener);
            }
        }
    }

    /**
     * Called by the {@link PreferenceManager} to dispatch a subactivity result.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.760 -0500", hash_original_method = "A3EFE32034D38DFF1A90F9A5F45D56A6", hash_generated_method = "A3EFE32034D38DFF1A90F9A5F45D56A6")
    
void dispatchActivityResult(int requestCode, int resultCode, Intent data) {
        List<OnActivityResultListener> list;
        
        synchronized (this) {
            if (mActivityResultListeners == null) return;
            list = new ArrayList<OnActivityResultListener>(mActivityResultListeners);
        }

        final int N = list.size();
        for (int i = 0; i < N; i++) {
            if (list.get(i).onActivityResult(requestCode, resultCode, data)) {
                break;
            }
        }
    }

    /**
     * Registers a listener.
     * 
     * @see OnActivityStopListener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.762 -0500", hash_original_method = "2A0808589AAB6A9778EC4C51EF499853", hash_generated_method = "2A0808589AAB6A9778EC4C51EF499853")
    
void registerOnActivityStopListener(OnActivityStopListener listener) {
        synchronized (this) {
            if (mActivityStopListeners == null) {
                mActivityStopListeners = new ArrayList<OnActivityStopListener>();
            }
            
            if (!mActivityStopListeners.contains(listener)) {
                mActivityStopListeners.add(listener);
            }
        }
    }
    
    /**
     * Unregisters a listener.
     * 
     * @see OnActivityStopListener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.764 -0500", hash_original_method = "D042C49681BB57CB7E14977DE37ED6E0", hash_generated_method = "D042C49681BB57CB7E14977DE37ED6E0")
    
void unregisterOnActivityStopListener(OnActivityStopListener listener) {
        synchronized (this) {
            if (mActivityStopListeners != null) {
                mActivityStopListeners.remove(listener);
            }
        }
    }
    
    /**
     * Called by the {@link PreferenceManager} to dispatch the activity stop
     * event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.766 -0500", hash_original_method = "6FD57C464C4DA57829A6C2B52E45A452", hash_generated_method = "6FD57C464C4DA57829A6C2B52E45A452")
    
void dispatchActivityStop() {
        List<OnActivityStopListener> list;
        
        synchronized (this) {
            if (mActivityStopListeners == null) return;
            list = new ArrayList<OnActivityStopListener>(mActivityStopListeners);
        }

        final int N = list.size();
        for (int i = 0; i < N; i++) {
            list.get(i).onActivityStop();
        }
    }

    /**
     * Registers a listener.
     * 
     * @see OnActivityDestroyListener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.768 -0500", hash_original_method = "8932A6D76CD73EDD58651F522607034F", hash_generated_method = "8932A6D76CD73EDD58651F522607034F")
    
void registerOnActivityDestroyListener(OnActivityDestroyListener listener) {
        synchronized (this) {
            if (mActivityDestroyListeners == null) {
                mActivityDestroyListeners = new ArrayList<OnActivityDestroyListener>();
            }

            if (!mActivityDestroyListeners.contains(listener)) {
                mActivityDestroyListeners.add(listener);
            }
        }
    }
    
    /**
     * Unregisters a listener.
     * 
     * @see OnActivityDestroyListener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.770 -0500", hash_original_method = "221E9A8BD7E96AD4198B64196703C2D4", hash_generated_method = "221E9A8BD7E96AD4198B64196703C2D4")
    
void unregisterOnActivityDestroyListener(OnActivityDestroyListener listener) {
        synchronized (this) {
            if (mActivityDestroyListeners != null) {
                mActivityDestroyListeners.remove(listener);
            }
        }
    }
    
    /**
     * Called by the {@link PreferenceManager} to dispatch the activity destroy
     * event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.773 -0500", hash_original_method = "ABC0DFC11A448AE601035D9520ECAF99", hash_generated_method = "A50EB56106E28498551C2918E03A855A")
    
void dispatchActivityDestroy() {
        List<OnActivityDestroyListener> list = null;
        
        synchronized (this) {
            if (mActivityDestroyListeners != null) {
                list = new ArrayList<OnActivityDestroyListener>(mActivityDestroyListeners);
            }
        }

        if (list != null) {
            final int N = list.size();
            for (int i = 0; i < N; i++) {
                list.get(i).onActivityDestroy();
            }
        }

        // Dismiss any PreferenceScreens still showing
        dismissAllScreens();
    }
    
    /**
     * Returns a request code that is unique for the activity. Each subsequent
     * call to this method should return another unique request code.
     * 
     * @return A unique request code that will never be used by anyone other
     *         than the caller of this method.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.775 -0500", hash_original_method = "74A43F7F50012109C1C50A128DECA709", hash_generated_method = "74A43F7F50012109C1C50A128DECA709")
    
int getNextRequestCode() {
        synchronized (this) {
            return mNextRequestCode++;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.777 -0500", hash_original_method = "64532379007357BDD2B5A06E80A12A41", hash_generated_method = "64532379007357BDD2B5A06E80A12A41")
    
void addPreferencesScreen(DialogInterface screen) {
        synchronized (this) {
            
            if (mPreferencesScreens == null) {
                mPreferencesScreens = new ArrayList<DialogInterface>();
            }
            
            mPreferencesScreens.add(screen);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.779 -0500", hash_original_method = "98728EB5C20211F6C02CB983C1971CE8", hash_generated_method = "98728EB5C20211F6C02CB983C1971CE8")
    
void removePreferencesScreen(DialogInterface screen) {
        synchronized (this) {
            
            if (mPreferencesScreens == null) {
                return;
            }
            
            mPreferencesScreens.remove(screen);
        }
    }
    
    /**
     * Called by {@link PreferenceActivity} to dispatch the new Intent event.
     * 
     * @param intent The new Intent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.781 -0500", hash_original_method = "4573B347852C64DB794205DBF1F726CF", hash_generated_method = "4573B347852C64DB794205DBF1F726CF")
    
void dispatchNewIntent(Intent intent) {
        dismissAllScreens();
    }
    
    interface OnPreferenceTreeClickListener {
        
        boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference);
    }
    
    public interface OnActivityResultListener {
        
        boolean onActivityResult(int requestCode, int resultCode, Intent data);
    }
    
    public interface OnActivityStopListener {
        
        void onActivityStop();
    }
    
    public interface OnActivityDestroyListener {
        
        void onActivityDestroy();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.784 -0500", hash_original_method = "9025418B8BBAFCD2E271951C43610D69", hash_generated_method = "DCBAF81ECD7B379BC2C84590968F3DB8")
    
private void dismissAllScreens() {
        // Remove any of the previously shown preferences screens
        ArrayList<DialogInterface> screensToDismiss;

        synchronized (this) {
            
            if (mPreferencesScreens == null) {
                return;
            }
            
            screensToDismiss = new ArrayList<DialogInterface>(mPreferencesScreens);
            mPreferencesScreens.clear();
        }
        
        for (int i = screensToDismiss.size() - 1; i >= 0; i--) {
            screensToDismiss.get(i).dismiss();
        }
    }
    
    /**
     * Sets the callback to be invoked when a {@link Preference} in the
     * hierarchy rooted at this {@link PreferenceManager} is clicked.
     * 
     * @param listener The callback to be invoked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.785 -0500", hash_original_method = "285310B7C58E8A2220B6B265614A6D90", hash_generated_method = "285310B7C58E8A2220B6B265614A6D90")
    
void setOnPreferenceTreeClickListener(OnPreferenceTreeClickListener listener) {
        mOnPreferenceTreeClickListener = listener;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.787 -0500", hash_original_method = "44D09E26591D5A19BD471058A1477B47", hash_generated_method = "44D09E26591D5A19BD471058A1477B47")
    
OnPreferenceTreeClickListener getOnPreferenceTreeClickListener() {
        return mOnPreferenceTreeClickListener;
    }
}

