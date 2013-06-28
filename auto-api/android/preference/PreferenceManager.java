package android.preference;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PreferenceManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.571 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "B0D69375984D6EE7DC93AC12DB4DFC55")

    private Activity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.571 -0400", hash_original_field = "3FD10A4D9B0E4F081E637AB2E170510C", hash_generated_field = "CFB43EBA13761D69B30BE1C8ABC90FE3")

    private PreferenceFragment mFragment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.571 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.571 -0400", hash_original_field = "A17D8D6E755B4D9F0325D801FA4F522E", hash_generated_field = "5707822036BF051C0059AD070444BD58")

    private long mNextId = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.571 -0400", hash_original_field = "4D3E01F29E2B733089344544F0A2603B", hash_generated_field = "AD359E85C996698973B9458D92AF4B64")

    private int mNextRequestCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.571 -0400", hash_original_field = "E241A9EA476C8AD360A6AF86B26B9894", hash_generated_field = "E69BF347D3F561905392BD5BBB86A4AF")

    private SharedPreferences mSharedPreferences;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.571 -0400", hash_original_field = "3D8FE9A15F9A53942FA618F826FAAFAF", hash_generated_field = "93BFA57AAD9A25C531F3726BE9E311D1")

    private SharedPreferences.Editor mEditor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.571 -0400", hash_original_field = "DAB8B93668BA5C4E8F1FA494EFEB56CF", hash_generated_field = "0870CFBDAD0F12B21EFE736694E5D5A0")

    private boolean mNoCommit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.571 -0400", hash_original_field = "2CC6E4D34D38FBDAB4FF7426A8D306D0", hash_generated_field = "08A9F51924058A9BDDEB8AE59F95CBF8")

    private String mSharedPreferencesName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.571 -0400", hash_original_field = "0E08AB7B895C16662875F197C1D44525", hash_generated_field = "3DFD0E17BB5556DF650F1E4262E37691")

    private int mSharedPreferencesMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.571 -0400", hash_original_field = "3E80BD46BA722B2DEF6CEFDE0275013E", hash_generated_field = "6929FA68B759CC402927F67ADE03851B")

    private PreferenceScreen mPreferenceScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.571 -0400", hash_original_field = "0FC215BE4A48484D140C21D5FB74120B", hash_generated_field = "759FE206EC137F2D102DEE69CB506E29")

    private List<OnActivityResultListener> mActivityResultListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.571 -0400", hash_original_field = "B5B2B104EE390763BB06AE8C00F2D113", hash_generated_field = "AB511ABA80C53F6AD5EC1856C35DAF7F")

    private List<OnActivityStopListener> mActivityStopListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.571 -0400", hash_original_field = "E8D0AA01EBF581234349769ABDFB96C5", hash_generated_field = "ED711A008E3B4CD7A93067555688693E")

    private List<OnActivityDestroyListener> mActivityDestroyListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.571 -0400", hash_original_field = "56170581385593D634EBED0A25E25CB6", hash_generated_field = "EEC46A0D6BAD420AFB426C404E85D2BA")

    private List<DialogInterface> mPreferencesScreens;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.571 -0400", hash_original_field = "EBF233AC10AB295ADBFE9F3DE441C883", hash_generated_field = "420F1647C8F11E826C9DE0A838CD7533")

    private OnPreferenceTreeClickListener mOnPreferenceTreeClickListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.572 -0400", hash_original_method = "A48679E26B4CF910ADEF8C7563331346", hash_generated_method = "B66A3E0FCD8D031D8854177CFA39A7CA")
      PreferenceManager(Activity activity, int firstRequestCode) {
        mActivity = activity;
        mNextRequestCode = firstRequestCode;
        init(activity);
        // ---------- Original Method ----------
        //mActivity = activity;
        //mNextRequestCode = firstRequestCode;
        //init(activity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.572 -0400", hash_original_method = "962D66AE85693F6FF77A2DEF54D76478", hash_generated_method = "22F00F7DD7E03EF7FC6790EF1DC6EADB")
    private  PreferenceManager(Context context) {
        init(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //init(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.572 -0400", hash_original_method = "2AA94A8F94EE739DE2B0DB27540BEB34", hash_generated_method = "1FEF65B26EA7FB18FC4F33B72116A507")
    private void init(Context context) {
        mContext = context;
        setSharedPreferencesName(getDefaultSharedPreferencesName(context));
        // ---------- Original Method ----------
        //mContext = context;
        //setSharedPreferencesName(getDefaultSharedPreferencesName(context));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.574 -0400", hash_original_method = "922F3E36F99E52FA3036E92080002B11", hash_generated_method = "0365529319BA5CC1DE5358358F20159B")
     void setFragment(PreferenceFragment fragment) {
        mFragment = fragment;
        // ---------- Original Method ----------
        //mFragment = fragment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.575 -0400", hash_original_method = "11BC570017448843B9A9A22E52E0E479", hash_generated_method = "233A631F93FDFCDBFFD1A949F127D957")
     PreferenceFragment getFragment() {
        PreferenceFragment varB4EAC82CA7396A68D541C85D26508E83_187083871 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_187083871 = mFragment;
        varB4EAC82CA7396A68D541C85D26508E83_187083871.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_187083871;
        // ---------- Original Method ----------
        //return mFragment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.575 -0400", hash_original_method = "6682C9F88019B1A37FE99B0D2B3B34A2", hash_generated_method = "A414C8543D45E7A057133FA525394C61")
    private List<ResolveInfo> queryIntentActivities(Intent queryIntent) {
        List<ResolveInfo> varB4EAC82CA7396A68D541C85D26508E83_454127928 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_454127928 = mContext.getPackageManager().queryIntentActivities(queryIntent,
                PackageManager.GET_META_DATA);
        addTaint(queryIntent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_454127928.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_454127928;
        // ---------- Original Method ----------
        //return mContext.getPackageManager().queryIntentActivities(queryIntent,
                //PackageManager.GET_META_DATA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.360 -0400", hash_original_method = "96A93C80BB9070BDED20D9AB85FFA8E8", hash_generated_method = "81E23B027CF4E9DA588940F5C6C95B14")
     PreferenceScreen inflateFromIntent(Intent queryIntent, PreferenceScreen rootPreferences) {
        PreferenceScreen varB4EAC82CA7396A68D541C85D26508E83_1553149189 = null; //Variable for return #1
        List<ResolveInfo> activities;
        activities = queryIntentActivities(queryIntent);
        HashSet<String> inflatedRes;
        inflatedRes = new HashSet<String>();
        {
            int i;
            i = activities.size() - 1;
            {
                ActivityInfo activityInfo;
                activityInfo = activities.get(i).activityInfo;
                Bundle metaData;
                metaData = activityInfo.metaData;
                {
                    boolean varCCFE5DA33F498B61582829F1A271E4A2_68536780 = ((metaData == null) || !metaData.containsKey(METADATA_KEY_PREFERENCES));
                } //End collapsed parenthetic
                String uniqueResId;
                uniqueResId = activityInfo.packageName + ":"
                    + activityInfo.metaData.getInt(METADATA_KEY_PREFERENCES);
                {
                    boolean varC3FF154FA48BC17A0ABB9C1087AA7414_92028484 = (!inflatedRes.contains(uniqueResId));
                    {
                        inflatedRes.add(uniqueResId);
                        Context context = null;
                        try 
                        {
                            context = mContext.createPackageContext(activityInfo.packageName, 0);
                        } //End block
                        catch (NameNotFoundException e)
                        { }
                        PreferenceInflater inflater;
                        inflater = new PreferenceInflater(context, this);
                        XmlResourceParser parser;
                        parser = activityInfo.loadXmlMetaData(context
                        .getPackageManager(), METADATA_KEY_PREFERENCES);
                        rootPreferences = (PreferenceScreen) inflater
                        .inflate(parser, rootPreferences, true);
                        parser.close();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        rootPreferences.onAttachedToHierarchy(this);
        varB4EAC82CA7396A68D541C85D26508E83_1553149189 = rootPreferences;
        addTaint(queryIntent.getTaint());
        addTaint(rootPreferences.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1553149189.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1553149189;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.577 -0400", hash_original_method = "94F9DF66CFF516C2DE1B651AB9A3388E", hash_generated_method = "C9BF1377CB38977F9001098E1B278B75")
    public PreferenceScreen inflateFromResource(Context context, int resId,
            PreferenceScreen rootPreferences) {
        PreferenceScreen varB4EAC82CA7396A68D541C85D26508E83_179565983 = null; //Variable for return #1
        setNoCommit(true);
        final PreferenceInflater inflater = new PreferenceInflater(context, this);
        rootPreferences = (PreferenceScreen) inflater.inflate(resId, rootPreferences, true);
        rootPreferences.onAttachedToHierarchy(this);
        setNoCommit(false);
        varB4EAC82CA7396A68D541C85D26508E83_179565983 = rootPreferences;
        addTaint(context.getTaint());
        addTaint(resId);
        addTaint(rootPreferences.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_179565983.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_179565983;
        // ---------- Original Method ----------
        //setNoCommit(true);
        //final PreferenceInflater inflater = new PreferenceInflater(context, this);
        //rootPreferences = (PreferenceScreen) inflater.inflate(resId, rootPreferences, true);
        //rootPreferences.onAttachedToHierarchy(this);
        //setNoCommit(false);
        //return rootPreferences;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.577 -0400", hash_original_method = "AE92D4BACEE41B351C64A7E59B1B4342", hash_generated_method = "AC65F40DBB62570BE793CC8F68BF597C")
    public PreferenceScreen createPreferenceScreen(Context context) {
        PreferenceScreen varB4EAC82CA7396A68D541C85D26508E83_1399092586 = null; //Variable for return #1
        final PreferenceScreen preferenceScreen = new PreferenceScreen(context, null);
        preferenceScreen.onAttachedToHierarchy(this);
        varB4EAC82CA7396A68D541C85D26508E83_1399092586 = preferenceScreen;
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1399092586.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1399092586;
        // ---------- Original Method ----------
        //final PreferenceScreen preferenceScreen = new PreferenceScreen(context, null);
        //preferenceScreen.onAttachedToHierarchy(this);
        //return preferenceScreen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.578 -0400", hash_original_method = "D904EAF0B6D90BB52E1F8594EC3F4D15", hash_generated_method = "A63410BB604CD9ACE85A0359C1727941")
     long getNextId() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_115224282 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_115224282;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mNextId++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.578 -0400", hash_original_method = "BDB110631059975A566BD4AA87A106E8", hash_generated_method = "0C2961B21E8AE27E1920E29E3CC999C1")
    public String getSharedPreferencesName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1189457685 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1189457685 = mSharedPreferencesName;
        varB4EAC82CA7396A68D541C85D26508E83_1189457685.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1189457685;
        // ---------- Original Method ----------
        //return mSharedPreferencesName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.579 -0400", hash_original_method = "F8FB75CAC643ECF72FE6E9CDE35245C6", hash_generated_method = "D9BEB55F87EC14156033461466352F28")
    public void setSharedPreferencesName(String sharedPreferencesName) {
        mSharedPreferencesName = sharedPreferencesName;
        mSharedPreferences = null;
        // ---------- Original Method ----------
        //mSharedPreferencesName = sharedPreferencesName;
        //mSharedPreferences = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.579 -0400", hash_original_method = "D2CF6E8640E20A030077A21285843C05", hash_generated_method = "490150F6D28AC0987D69AC2996945F75")
    public int getSharedPreferencesMode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1742533321 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1742533321;
        // ---------- Original Method ----------
        //return mSharedPreferencesMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.579 -0400", hash_original_method = "6988E36A0998B14CBE7D70DCBAB74FF8", hash_generated_method = "9D485153CC70863E2B681C1F00F79C11")
    public void setSharedPreferencesMode(int sharedPreferencesMode) {
        mSharedPreferencesMode = sharedPreferencesMode;
        mSharedPreferences = null;
        // ---------- Original Method ----------
        //mSharedPreferencesMode = sharedPreferencesMode;
        //mSharedPreferences = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.580 -0400", hash_original_method = "B901A30CD0A7131EC29E8BD072ADC21D", hash_generated_method = "6A356E06A7A6F0B1D4B5F9B4669E3D62")
    public SharedPreferences getSharedPreferences() {
        SharedPreferences varB4EAC82CA7396A68D541C85D26508E83_1686224641 = null; //Variable for return #1
        {
            mSharedPreferences = mContext.getSharedPreferences(mSharedPreferencesName,
                    mSharedPreferencesMode);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1686224641 = mSharedPreferences;
        varB4EAC82CA7396A68D541C85D26508E83_1686224641.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1686224641;
        // ---------- Original Method ----------
        //if (mSharedPreferences == null) {
            //mSharedPreferences = mContext.getSharedPreferences(mSharedPreferencesName,
                    //mSharedPreferencesMode);
        //}
        //return mSharedPreferences;
    }

    
    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        return context.getSharedPreferences(getDefaultSharedPreferencesName(context),
                getDefaultSharedPreferencesMode());
    }

    
    private static String getDefaultSharedPreferencesName(Context context) {
        return context.getPackageName() + "_preferences";
    }

    
    private static int getDefaultSharedPreferencesMode() {
        return Context.MODE_PRIVATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.581 -0400", hash_original_method = "60967B21FA602EB86E9B5EB647B08AF2", hash_generated_method = "A8F605CBEC5307556592616EF2E925C7")
     PreferenceScreen getPreferenceScreen() {
        PreferenceScreen varB4EAC82CA7396A68D541C85D26508E83_220707835 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_220707835 = mPreferenceScreen;
        varB4EAC82CA7396A68D541C85D26508E83_220707835.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_220707835;
        // ---------- Original Method ----------
        //return mPreferenceScreen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.581 -0400", hash_original_method = "72F330353D1AAD0C361FC98ABB0551E0", hash_generated_method = "C464ACAB07AADB8881168849042DA135")
     boolean setPreferences(PreferenceScreen preferenceScreen) {
        {
            mPreferenceScreen = preferenceScreen;
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1406772542 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1406772542;
        // ---------- Original Method ----------
        //if (preferenceScreen != mPreferenceScreen) {
            //mPreferenceScreen = preferenceScreen;
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.582 -0400", hash_original_method = "313075D13AC6A3D78BD3127C39A86211", hash_generated_method = "4020CB86CC5432B07ED02CA6D00D92CC")
    public Preference findPreference(CharSequence key) {
        Preference varB4EAC82CA7396A68D541C85D26508E83_1653702320 = null; //Variable for return #1
        Preference varB4EAC82CA7396A68D541C85D26508E83_387215151 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1653702320 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_387215151 = mPreferenceScreen.findPreference(key);
        addTaint(key.getTaint());
        Preference varA7E53CE21691AB073D9660D615818899_972754474; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_972754474 = varB4EAC82CA7396A68D541C85D26508E83_1653702320;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_972754474 = varB4EAC82CA7396A68D541C85D26508E83_387215151;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_972754474.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_972754474;
        // ---------- Original Method ----------
        //if (mPreferenceScreen == null) {
            //return null;
        //}
        //return mPreferenceScreen.findPreference(key);
    }

    
    public static void setDefaultValues(Context context, int resId, boolean readAgain) {
        setDefaultValues(context, getDefaultSharedPreferencesName(context),
                getDefaultSharedPreferencesMode(), resId, readAgain);
    }

    
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
                editor.commit();
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.583 -0400", hash_original_method = "D4733D45210A4F96431F976F3F9AB3C2", hash_generated_method = "174269208056F9FD5ED6A4ADB046BEB1")
     SharedPreferences.Editor getEditor() {
        SharedPreferences.Editor varB4EAC82CA7396A68D541C85D26508E83_1741719511 = null; //Variable for return #1
        SharedPreferences.Editor varB4EAC82CA7396A68D541C85D26508E83_1084906896 = null; //Variable for return #2
        {
            {
                mEditor = getSharedPreferences().edit();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1741719511 = mEditor;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1084906896 = getSharedPreferences().edit();
        } //End block
        SharedPreferences.Editor varA7E53CE21691AB073D9660D615818899_1261100612; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1261100612 = varB4EAC82CA7396A68D541C85D26508E83_1741719511;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1261100612 = varB4EAC82CA7396A68D541C85D26508E83_1084906896;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1261100612.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1261100612;
        // ---------- Original Method ----------
        //if (mNoCommit) {
            //if (mEditor == null) {
                //mEditor = getSharedPreferences().edit();
            //}
            //return mEditor;
        //} else {
            //return getSharedPreferences().edit();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.583 -0400", hash_original_method = "47C154426E8AAB84597A7B272BF8D2FA", hash_generated_method = "9D55A8D5289B69D75032FAB5910608C8")
     boolean shouldCommit() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_320213457 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_320213457;
        // ---------- Original Method ----------
        //return !mNoCommit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.583 -0400", hash_original_method = "2ED947FD2CD87E45A298D362CE1C3C54", hash_generated_method = "597632B8DB3DBA0DDE74BC4FC05122DB")
    private void setNoCommit(boolean noCommit) {
        {
            try 
            {
                mEditor.apply();
            } //End block
            catch (AbstractMethodError unused)
            {
                mEditor.commit();
            } //End block
        } //End block
        mNoCommit = noCommit;
        // ---------- Original Method ----------
        //if (!noCommit && mEditor != null) {
            //try {
                //mEditor.apply();
            //} catch (AbstractMethodError unused) {
                //mEditor.commit();
            //}
        //}
        //mNoCommit = noCommit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.584 -0400", hash_original_method = "3F17133E8D63AE8C7414DC58966291E3", hash_generated_method = "422258F6F08E5C9B7A9EE80C861FACB8")
     Activity getActivity() {
        Activity varB4EAC82CA7396A68D541C85D26508E83_1156706278 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1156706278 = mActivity;
        varB4EAC82CA7396A68D541C85D26508E83_1156706278.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1156706278;
        // ---------- Original Method ----------
        //return mActivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.585 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "10A3D9041AF602BA1EA7311149C60755")
     Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_1764902396 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1764902396 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_1764902396.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1764902396;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.586 -0400", hash_original_method = "8C7924F669844968ABD2440B12D35A69", hash_generated_method = "99F315D31019C9AB65D145E739CFE417")
     void registerOnActivityResultListener(OnActivityResultListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        {
            {
                mActivityResultListeners = new ArrayList<OnActivityResultListener>();
            } //End block
            {
                boolean var15DEA0801B4CA66F31C20D5EEB846813_1636618095 = (!mActivityResultListeners.contains(listener));
                {
                    mActivityResultListeners.add(listener);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mActivityResultListeners == null) {
                //mActivityResultListeners = new ArrayList<OnActivityResultListener>();
            //}
            //if (!mActivityResultListeners.contains(listener)) {
                //mActivityResultListeners.add(listener);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.586 -0400", hash_original_method = "2F16D3A7CC67220808B5AF6C63D00415", hash_generated_method = "096E3924968B33E382ED307A803FF7FC")
     void unregisterOnActivityResultListener(OnActivityResultListener listener) {
        {
            {
                mActivityResultListeners.remove(listener);
            } //End block
        } //End block
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mActivityResultListeners != null) {
                //mActivityResultListeners.remove(listener);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.587 -0400", hash_original_method = "A3EFE32034D38DFF1A90F9A5F45D56A6", hash_generated_method = "56AB6BF78B9A08C100A8C030DB3812D2")
     void dispatchActivityResult(int requestCode, int resultCode, Intent data) {
        List<OnActivityResultListener> list;
        {
            list = new ArrayList<OnActivityResultListener>(mActivityResultListeners);
        } //End block
        final int N = list.size();
        {
            int i = 0;
            {
                {
                    boolean varA0E378DB28F1EA78419E01C6630E728F_241221029 = (list.get(i).onActivityResult(requestCode, resultCode, data));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(requestCode);
        addTaint(resultCode);
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        //List<OnActivityResultListener> list;
        //synchronized (this) {
            //if (mActivityResultListeners == null) return;
            //list = new ArrayList<OnActivityResultListener>(mActivityResultListeners);
        //}
        //final int N = list.size();
        //for (int i = 0; i < N; i++) {
            //if (list.get(i).onActivityResult(requestCode, resultCode, data)) {
                //break;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.588 -0400", hash_original_method = "2A0808589AAB6A9778EC4C51EF499853", hash_generated_method = "86BBE180DAC5621DFB9667C924AE48B9")
     void registerOnActivityStopListener(OnActivityStopListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        {
            {
                mActivityStopListeners = new ArrayList<OnActivityStopListener>();
            } //End block
            {
                boolean var8DD9D2AD16524FCA9AA66A5DFCB0DD9D_1517905936 = (!mActivityStopListeners.contains(listener));
                {
                    mActivityStopListeners.add(listener);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mActivityStopListeners == null) {
                //mActivityStopListeners = new ArrayList<OnActivityStopListener>();
            //}
            //if (!mActivityStopListeners.contains(listener)) {
                //mActivityStopListeners.add(listener);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.588 -0400", hash_original_method = "D042C49681BB57CB7E14977DE37ED6E0", hash_generated_method = "87238E8F4BF40CF5A2FFCD49064BFB73")
     void unregisterOnActivityStopListener(OnActivityStopListener listener) {
        {
            {
                mActivityStopListeners.remove(listener);
            } //End block
        } //End block
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mActivityStopListeners != null) {
                //mActivityStopListeners.remove(listener);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.589 -0400", hash_original_method = "6FD57C464C4DA57829A6C2B52E45A452", hash_generated_method = "42DCF56A2E4AE2682CCA00CCE1EDC088")
     void dispatchActivityStop() {
        List<OnActivityStopListener> list;
        {
            list = new ArrayList<OnActivityStopListener>(mActivityStopListeners);
        } //End block
        final int N = list.size();
        {
            int i = 0;
            {
                list.get(i).onActivityStop();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //List<OnActivityStopListener> list;
        //synchronized (this) {
            //if (mActivityStopListeners == null) return;
            //list = new ArrayList<OnActivityStopListener>(mActivityStopListeners);
        //}
        //final int N = list.size();
        //for (int i = 0; i < N; i++) {
            //list.get(i).onActivityStop();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.589 -0400", hash_original_method = "8932A6D76CD73EDD58651F522607034F", hash_generated_method = "955D9B341B64D76D2EEABBED38D34FFC")
     void registerOnActivityDestroyListener(OnActivityDestroyListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        {
            {
                mActivityDestroyListeners = new ArrayList<OnActivityDestroyListener>();
            } //End block
            {
                boolean var7376631AC503E8DE4340FDE7CD8C5D8E_220305410 = (!mActivityDestroyListeners.contains(listener));
                {
                    mActivityDestroyListeners.add(listener);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mActivityDestroyListeners == null) {
                //mActivityDestroyListeners = new ArrayList<OnActivityDestroyListener>();
            //}
            //if (!mActivityDestroyListeners.contains(listener)) {
                //mActivityDestroyListeners.add(listener);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.589 -0400", hash_original_method = "221E9A8BD7E96AD4198B64196703C2D4", hash_generated_method = "D422C86ECD6382BFD6BDBC291675FE75")
     void unregisterOnActivityDestroyListener(OnActivityDestroyListener listener) {
        {
            {
                mActivityDestroyListeners.remove(listener);
            } //End block
        } //End block
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mActivityDestroyListeners != null) {
                //mActivityDestroyListeners.remove(listener);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.590 -0400", hash_original_method = "ABC0DFC11A448AE601035D9520ECAF99", hash_generated_method = "9EE2D55CEA47180489A352AD87313D4F")
     void dispatchActivityDestroy() {
        List<OnActivityDestroyListener> list = null;
        {
            {
                list = new ArrayList<OnActivityDestroyListener>(mActivityDestroyListeners);
            } //End block
        } //End block
        {
            final int N = list.size();
            {
                int i = 0;
                {
                    list.get(i).onActivityDestroy();
                } //End block
            } //End collapsed parenthetic
        } //End block
        dismissAllScreens();
        // ---------- Original Method ----------
        //List<OnActivityDestroyListener> list = null;
        //synchronized (this) {
            //if (mActivityDestroyListeners != null) {
                //list = new ArrayList<OnActivityDestroyListener>(mActivityDestroyListeners);
            //}
        //}
        //if (list != null) {
            //final int N = list.size();
            //for (int i = 0; i < N; i++) {
                //list.get(i).onActivityDestroy();
            //}
        //}
        //dismissAllScreens();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.590 -0400", hash_original_method = "74A43F7F50012109C1C50A128DECA709", hash_generated_method = "EE6AC02F50B6B946EBA4155F96806FA4")
     int getNextRequestCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1863314507 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1863314507;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mNextRequestCode++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.591 -0400", hash_original_method = "64532379007357BDD2B5A06E80A12A41", hash_generated_method = "DFA894C0594746E298AE4C977D35CE78")
     void addPreferencesScreen(DialogInterface screen) {
        {
            {
                mPreferencesScreens = new ArrayList<DialogInterface>();
            } //End block
            mPreferencesScreens.add(screen);
        } //End block
        addTaint(screen.getTaint());
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mPreferencesScreens == null) {
                //mPreferencesScreens = new ArrayList<DialogInterface>();
            //}
            //mPreferencesScreens.add(screen);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.591 -0400", hash_original_method = "98728EB5C20211F6C02CB983C1971CE8", hash_generated_method = "A301D7AD80E4F4F34329F7857BEF6B3F")
     void removePreferencesScreen(DialogInterface screen) {
        {
            mPreferencesScreens.remove(screen);
        } //End block
        addTaint(screen.getTaint());
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mPreferencesScreens == null) {
                //return;
            //}
            //mPreferencesScreens.remove(screen);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.591 -0400", hash_original_method = "4573B347852C64DB794205DBF1F726CF", hash_generated_method = "5F9FA38D60D9F7C9289F17546751CC26")
     void dispatchNewIntent(Intent intent) {
        dismissAllScreens();
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //dismissAllScreens();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.592 -0400", hash_original_method = "9025418B8BBAFCD2E271951C43610D69", hash_generated_method = "060A698B1048E9938EED0070CE321DD7")
    private void dismissAllScreens() {
        ArrayList<DialogInterface> screensToDismiss;
        {
            screensToDismiss = new ArrayList<DialogInterface>(mPreferencesScreens);
            mPreferencesScreens.clear();
        } //End block
        {
            int i = screensToDismiss.size() - 1;
            {
                screensToDismiss.get(i).dismiss();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //ArrayList<DialogInterface> screensToDismiss;
        //synchronized (this) {
            //if (mPreferencesScreens == null) {
                //return;
            //}
            //screensToDismiss = new ArrayList<DialogInterface>(mPreferencesScreens);
            //mPreferencesScreens.clear();
        //}
        //for (int i = screensToDismiss.size() - 1; i >= 0; i--) {
            //screensToDismiss.get(i).dismiss();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.592 -0400", hash_original_method = "285310B7C58E8A2220B6B265614A6D90", hash_generated_method = "54FF302A27BDAFD0688C064472C3369F")
     void setOnPreferenceTreeClickListener(OnPreferenceTreeClickListener listener) {
        mOnPreferenceTreeClickListener = listener;
        // ---------- Original Method ----------
        //mOnPreferenceTreeClickListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.593 -0400", hash_original_method = "44D09E26591D5A19BD471058A1477B47", hash_generated_method = "BAB674C18FCF08BCCE499B47971E93BF")
     OnPreferenceTreeClickListener getOnPreferenceTreeClickListener() {
        OnPreferenceTreeClickListener varB4EAC82CA7396A68D541C85D26508E83_1719690360 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1719690360 = mOnPreferenceTreeClickListener;
        varB4EAC82CA7396A68D541C85D26508E83_1719690360.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1719690360;
        // ---------- Original Method ----------
        //return mOnPreferenceTreeClickListener;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.593 -0400", hash_original_field = "3B3156BFCCD2750D37F1326B97CB5F31", hash_generated_field = "7AAEA04E4548D5AB6EC8143F21A30EA9")

    private static final String TAG = "PreferenceManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.593 -0400", hash_original_field = "A2BD9669003E7E13497AC3567764BDBD", hash_generated_field = "6C182C497B18AE33867D48A4D7F5655E")

    public static final String METADATA_KEY_PREFERENCES = "android.preference";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.593 -0400", hash_original_field = "9F2BA8A2ED391A83C5161DE1503D56BD", hash_generated_field = "99247B06873D9B62D5B8F33E5FB96366")

    public static final String KEY_HAS_SET_DEFAULT_VALUES = "_has_set_default_values";
}

