package android.preference;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final String TAG = "PreferenceManager";
    public static final String METADATA_KEY_PREFERENCES = "android.preference";
    public static final String KEY_HAS_SET_DEFAULT_VALUES = "_has_set_default_values";
    private Activity mActivity;
    private PreferenceFragment mFragment;
    private Context mContext;
    private long mNextId = 0;
    private int mNextRequestCode;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private boolean mNoCommit;
    private String mSharedPreferencesName;
    private int mSharedPreferencesMode;
    private PreferenceScreen mPreferenceScreen;
    private List<OnActivityResultListener> mActivityResultListeners;
    private List<OnActivityStopListener> mActivityStopListeners;
    private List<OnActivityDestroyListener> mActivityDestroyListeners;
    private List<DialogInterface> mPreferencesScreens;
    private OnPreferenceTreeClickListener mOnPreferenceTreeClickListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.061 -0400", hash_original_method = "A48679E26B4CF910ADEF8C7563331346", hash_generated_method = "0CD5B784FC72712A9B8465294F522308")
    @DSModeled(DSC.SAFE)
     PreferenceManager(Activity activity, int firstRequestCode) {
        dsTaint.addTaint(firstRequestCode);
        dsTaint.addTaint(activity.dsTaint);
        init(activity);
        // ---------- Original Method ----------
        //mActivity = activity;
        //mNextRequestCode = firstRequestCode;
        //init(activity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.061 -0400", hash_original_method = "962D66AE85693F6FF77A2DEF54D76478", hash_generated_method = "4E4E29884F9E8BD74D109E7B3E0FBC2E")
    @DSModeled(DSC.SAFE)
    private PreferenceManager(Context context) {
        dsTaint.addTaint(context.dsTaint);
        init(context);
        // ---------- Original Method ----------
        //init(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.061 -0400", hash_original_method = "2AA94A8F94EE739DE2B0DB27540BEB34", hash_generated_method = "BFC40005270BE59BD860986AAB28F224")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init(Context context) {
        dsTaint.addTaint(context.dsTaint);
        setSharedPreferencesName(getDefaultSharedPreferencesName(context));
        // ---------- Original Method ----------
        //mContext = context;
        //setSharedPreferencesName(getDefaultSharedPreferencesName(context));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.061 -0400", hash_original_method = "922F3E36F99E52FA3036E92080002B11", hash_generated_method = "393016288E80EDF41EF6ECE457756A15")
    @DSModeled(DSC.SAFE)
     void setFragment(PreferenceFragment fragment) {
        dsTaint.addTaint(fragment.dsTaint);
        // ---------- Original Method ----------
        //mFragment = fragment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.062 -0400", hash_original_method = "11BC570017448843B9A9A22E52E0E479", hash_generated_method = "44F25367683A4B109E22290432689097")
    @DSModeled(DSC.SAFE)
     PreferenceFragment getFragment() {
        return (PreferenceFragment)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFragment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.062 -0400", hash_original_method = "6682C9F88019B1A37FE99B0D2B3B34A2", hash_generated_method = "F4E123FAA9A12E9744390F6534D436A2")
    @DSModeled(DSC.SPEC)
    private List<ResolveInfo> queryIntentActivities(Intent queryIntent) {
        dsTaint.addTaint(queryIntent.dsTaint);
        List<ResolveInfo> var59F2D462372FAD99326B1574628BE656_2134041030 = (mContext.getPackageManager().queryIntentActivities(queryIntent,
                PackageManager.GET_META_DATA));
        return (List<ResolveInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext.getPackageManager().queryIntentActivities(queryIntent,
                //PackageManager.GET_META_DATA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.062 -0400", hash_original_method = "96A93C80BB9070BDED20D9AB85FFA8E8", hash_generated_method = "6E1B2166D0EA80079C53F93AFF4362AD")
    @DSModeled(DSC.SPEC)
     PreferenceScreen inflateFromIntent(Intent queryIntent, PreferenceScreen rootPreferences) {
        dsTaint.addTaint(queryIntent.dsTaint);
        dsTaint.addTaint(rootPreferences.dsTaint);
        final List<ResolveInfo> activities;
        activities = queryIntentActivities(queryIntent);
        final HashSet<String> inflatedRes;
        inflatedRes = new HashSet<String>();
        {
            int i;
            i = activities.size() - 1;
            {
                final ActivityInfo activityInfo;
                activityInfo = activities.get(i).activityInfo;
                final Bundle metaData;
                metaData = activityInfo.metaData;
                {
                    boolean varCCFE5DA33F498B61582829F1A271E4A2_1123070625 = ((metaData == null) || !metaData.containsKey(METADATA_KEY_PREFERENCES));
                } //End collapsed parenthetic
                final String uniqueResId;
                uniqueResId = activityInfo.packageName + ":"
                    + activityInfo.metaData.getInt(METADATA_KEY_PREFERENCES);
                {
                    boolean varC3FF154FA48BC17A0ABB9C1087AA7414_2056907977 = (!inflatedRes.contains(uniqueResId));
                    {
                        inflatedRes.add(uniqueResId);
                        Context context = null;
                        try 
                        {
                            context = mContext.createPackageContext(activityInfo.packageName, 0);
                        } //End block
                        catch (NameNotFoundException e)
                        { }
                        final PreferenceInflater inflater;
                        inflater = new PreferenceInflater(context, this);
                        final XmlResourceParser parser;
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
        return (PreferenceScreen)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.062 -0400", hash_original_method = "94F9DF66CFF516C2DE1B651AB9A3388E", hash_generated_method = "1A5DB1711652475BE602A0AA78D99476")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PreferenceScreen inflateFromResource(Context context, int resId,
            PreferenceScreen rootPreferences) {
        dsTaint.addTaint(rootPreferences.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(resId);
        setNoCommit(true);
        final PreferenceInflater inflater;
        inflater = new PreferenceInflater(context, this);
        rootPreferences = (PreferenceScreen) inflater.inflate(resId, rootPreferences, true);
        rootPreferences.onAttachedToHierarchy(this);
        setNoCommit(false);
        return (PreferenceScreen)dsTaint.getTaint();
        // ---------- Original Method ----------
        //setNoCommit(true);
        //final PreferenceInflater inflater = new PreferenceInflater(context, this);
        //rootPreferences = (PreferenceScreen) inflater.inflate(resId, rootPreferences, true);
        //rootPreferences.onAttachedToHierarchy(this);
        //setNoCommit(false);
        //return rootPreferences;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.062 -0400", hash_original_method = "AE92D4BACEE41B351C64A7E59B1B4342", hash_generated_method = "470CBC251362424D274FF41E16271A4B")
    @DSModeled(DSC.SAFE)
    public PreferenceScreen createPreferenceScreen(Context context) {
        dsTaint.addTaint(context.dsTaint);
        final PreferenceScreen preferenceScreen;
        preferenceScreen = new PreferenceScreen(context, null);
        preferenceScreen.onAttachedToHierarchy(this);
        return (PreferenceScreen)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final PreferenceScreen preferenceScreen = new PreferenceScreen(context, null);
        //preferenceScreen.onAttachedToHierarchy(this);
        //return preferenceScreen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.063 -0400", hash_original_method = "D904EAF0B6D90BB52E1F8594EC3F4D15", hash_generated_method = "93439A2ACC296768EFCC2F6BB2AC3251")
    @DSModeled(DSC.SAFE)
     long getNextId() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mNextId++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.063 -0400", hash_original_method = "BDB110631059975A566BD4AA87A106E8", hash_generated_method = "985A05232EEEEE6F44E1E5EACF2591F0")
    @DSModeled(DSC.SAFE)
    public String getSharedPreferencesName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSharedPreferencesName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.063 -0400", hash_original_method = "F8FB75CAC643ECF72FE6E9CDE35245C6", hash_generated_method = "6FC547B1361DAED3096469986525036A")
    @DSModeled(DSC.SAFE)
    public void setSharedPreferencesName(String sharedPreferencesName) {
        dsTaint.addTaint(sharedPreferencesName);
        mSharedPreferences = null;
        // ---------- Original Method ----------
        //mSharedPreferencesName = sharedPreferencesName;
        //mSharedPreferences = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.063 -0400", hash_original_method = "D2CF6E8640E20A030077A21285843C05", hash_generated_method = "9D13635F1D7D52D9FE5CAF1096C24C8F")
    @DSModeled(DSC.SAFE)
    public int getSharedPreferencesMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSharedPreferencesMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.063 -0400", hash_original_method = "6988E36A0998B14CBE7D70DCBAB74FF8", hash_generated_method = "48C98A9A2EDD269A1FC1C2A55B926703")
    @DSModeled(DSC.SAFE)
    public void setSharedPreferencesMode(int sharedPreferencesMode) {
        dsTaint.addTaint(sharedPreferencesMode);
        mSharedPreferences = null;
        // ---------- Original Method ----------
        //mSharedPreferencesMode = sharedPreferencesMode;
        //mSharedPreferences = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.063 -0400", hash_original_method = "B901A30CD0A7131EC29E8BD072ADC21D", hash_generated_method = "09EB085536F260B5478B258E29E49362")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SharedPreferences getSharedPreferences() {
        {
            mSharedPreferences = mContext.getSharedPreferences(mSharedPreferencesName,
                    mSharedPreferencesMode);
        } //End block
        return (SharedPreferences)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mSharedPreferences == null) {
            //mSharedPreferences = mContext.getSharedPreferences(mSharedPreferencesName,
                    //mSharedPreferencesMode);
        //}
        //return mSharedPreferences;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.063 -0400", hash_original_method = "DEE839A83C4B35ACEA8CCC2B71E2B5D1", hash_generated_method = "2B16C131215B04C3D72C14303B6B379E")
    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        return context.getSharedPreferences(getDefaultSharedPreferencesName(context),
                getDefaultSharedPreferencesMode());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.063 -0400", hash_original_method = "42C9CE230DD05245AC0F1F15B9BA0F77", hash_generated_method = "C0A43771BC0878E5F7FF1D24F0A68563")
    private static String getDefaultSharedPreferencesName(Context context) {
        return context.getPackageName() + "_preferences";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.063 -0400", hash_original_method = "9A4A0B76FBD75A7A2387EF85E0D2FD54", hash_generated_method = "D84FC8AF76E7CF2269D44A6A6D9A3736")
    private static int getDefaultSharedPreferencesMode() {
        return Context.MODE_PRIVATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.063 -0400", hash_original_method = "60967B21FA602EB86E9B5EB647B08AF2", hash_generated_method = "B4224F97C6B2686705A2D2DD2EC1E61B")
    @DSModeled(DSC.SAFE)
     PreferenceScreen getPreferenceScreen() {
        return (PreferenceScreen)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mPreferenceScreen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.063 -0400", hash_original_method = "72F330353D1AAD0C361FC98ABB0551E0", hash_generated_method = "373DDEB0A9CAFBED76CF4B5A776324F7")
    @DSModeled(DSC.SAFE)
     boolean setPreferences(PreferenceScreen preferenceScreen) {
        dsTaint.addTaint(preferenceScreen.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (preferenceScreen != mPreferenceScreen) {
            //mPreferenceScreen = preferenceScreen;
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.064 -0400", hash_original_method = "313075D13AC6A3D78BD3127C39A86211", hash_generated_method = "6DEA6063A1472153FAB699D2FC0DB6D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Preference findPreference(CharSequence key) {
        dsTaint.addTaint(key);
        Preference var87C1A986291E6AFED7D02EAECE847A62_1781227010 = (mPreferenceScreen.findPreference(key));
        return (Preference)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mPreferenceScreen == null) {
            //return null;
        //}
        //return mPreferenceScreen.findPreference(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.064 -0400", hash_original_method = "1B08E289995C6C21F5C2BC4F9B6F5187", hash_generated_method = "F724C524DB65805B1F61E415B268DBA7")
    public static void setDefaultValues(Context context, int resId, boolean readAgain) {
        setDefaultValues(context, getDefaultSharedPreferencesName(context),
                getDefaultSharedPreferencesMode(), resId, readAgain);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.064 -0400", hash_original_method = "9646A9372ECC55871733A680E62A72CA", hash_generated_method = "79B0073DD25D6B22E6CDE97A8130A2AB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.064 -0400", hash_original_method = "D4733D45210A4F96431F976F3F9AB3C2", hash_generated_method = "3A28711AF5F266F8228EB37362E8D913")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SharedPreferences.Editor getEditor() {
        {
            {
                mEditor = getSharedPreferences().edit();
            } //End block
        } //End block
        {
            SharedPreferences.Editor var0948B81E09E41A32904748A17BADC880_1325004192 = (getSharedPreferences().edit());
        } //End block
        return (SharedPreferences.Editor)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.064 -0400", hash_original_method = "47C154426E8AAB84597A7B272BF8D2FA", hash_generated_method = "F087DB9A50A559093DDFC7D273D880DF")
    @DSModeled(DSC.SAFE)
     boolean shouldCommit() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !mNoCommit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.064 -0400", hash_original_method = "2ED947FD2CD87E45A298D362CE1C3C54", hash_generated_method = "0FD0B338AC910C42DA26C73B8965BD34")
    @DSModeled(DSC.SAFE)
    private void setNoCommit(boolean noCommit) {
        dsTaint.addTaint(noCommit);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.064 -0400", hash_original_method = "3F17133E8D63AE8C7414DC58966291E3", hash_generated_method = "F13DE7409A763AE70FF83E6BDADA6995")
    @DSModeled(DSC.SAFE)
     Activity getActivity() {
        return (Activity)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.064 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "984B688B58AB4EF934D2048ACA6C1BFF")
    @DSModeled(DSC.SAFE)
     Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.065 -0400", hash_original_method = "8C7924F669844968ABD2440B12D35A69", hash_generated_method = "16BEF104E488EFDD6547E490D24BC1C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void registerOnActivityResultListener(OnActivityResultListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(listener.dsTaint);
        {
            {
                mActivityResultListeners = new ArrayList<OnActivityResultListener>();
            } //End block
            {
                boolean var15DEA0801B4CA66F31C20D5EEB846813_708634244 = (!mActivityResultListeners.contains(listener));
                {
                    mActivityResultListeners.add(listener);
                } //End block
            } //End collapsed parenthetic
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.065 -0400", hash_original_method = "2F16D3A7CC67220808B5AF6C63D00415", hash_generated_method = "580A6798449A0331C003E1F328F715C4")
    @DSModeled(DSC.SAFE)
     void unregisterOnActivityResultListener(OnActivityResultListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(listener.dsTaint);
        {
            {
                mActivityResultListeners.remove(listener);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mActivityResultListeners != null) {
                //mActivityResultListeners.remove(listener);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.065 -0400", hash_original_method = "A3EFE32034D38DFF1A90F9A5F45D56A6", hash_generated_method = "CB39EE6880327BB5677DC0300C3E65C7")
    @DSModeled(DSC.SPEC)
     void dispatchActivityResult(int requestCode, int resultCode, Intent data) {
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(resultCode);
        dsTaint.addTaint(data.dsTaint);
        List<OnActivityResultListener> list;
        {
            list = new ArrayList<OnActivityResultListener>(mActivityResultListeners);
        } //End block
        final int N;
        N = list.size();
        {
            int i;
            i = 0;
            {
                {
                    boolean varA0E378DB28F1EA78419E01C6630E728F_198805583 = (list.get(i).onActivityResult(requestCode, resultCode, data));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.065 -0400", hash_original_method = "2A0808589AAB6A9778EC4C51EF499853", hash_generated_method = "F47F9C3AA87BDFED7F8554C52D9613E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void registerOnActivityStopListener(OnActivityStopListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(listener.dsTaint);
        {
            {
                mActivityStopListeners = new ArrayList<OnActivityStopListener>();
            } //End block
            {
                boolean var8DD9D2AD16524FCA9AA66A5DFCB0DD9D_1579565971 = (!mActivityStopListeners.contains(listener));
                {
                    mActivityStopListeners.add(listener);
                } //End block
            } //End collapsed parenthetic
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.065 -0400", hash_original_method = "D042C49681BB57CB7E14977DE37ED6E0", hash_generated_method = "23C86C7F196756618CFE9C25D38AAD2E")
    @DSModeled(DSC.SAFE)
     void unregisterOnActivityStopListener(OnActivityStopListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(listener.dsTaint);
        {
            {
                mActivityStopListeners.remove(listener);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mActivityStopListeners != null) {
                //mActivityStopListeners.remove(listener);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.065 -0400", hash_original_method = "6FD57C464C4DA57829A6C2B52E45A452", hash_generated_method = "2A8A9975AE1719E32505337FE218814F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchActivityStop() {
        List<OnActivityStopListener> list;
        {
            list = new ArrayList<OnActivityStopListener>(mActivityStopListeners);
        } //End block
        final int N;
        N = list.size();
        {
            int i;
            i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.066 -0400", hash_original_method = "8932A6D76CD73EDD58651F522607034F", hash_generated_method = "7D78193A30AF330B3EF69F7515B9E97A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void registerOnActivityDestroyListener(OnActivityDestroyListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(listener.dsTaint);
        {
            {
                mActivityDestroyListeners = new ArrayList<OnActivityDestroyListener>();
            } //End block
            {
                boolean var7376631AC503E8DE4340FDE7CD8C5D8E_2110719021 = (!mActivityDestroyListeners.contains(listener));
                {
                    mActivityDestroyListeners.add(listener);
                } //End block
            } //End collapsed parenthetic
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.066 -0400", hash_original_method = "221E9A8BD7E96AD4198B64196703C2D4", hash_generated_method = "DCEBF7BAA73B93C3F231FDB86169F570")
    @DSModeled(DSC.SAFE)
     void unregisterOnActivityDestroyListener(OnActivityDestroyListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(listener.dsTaint);
        {
            {
                mActivityDestroyListeners.remove(listener);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mActivityDestroyListeners != null) {
                //mActivityDestroyListeners.remove(listener);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.066 -0400", hash_original_method = "ABC0DFC11A448AE601035D9520ECAF99", hash_generated_method = "6CDDD4D45603E2C8A623923281C9E61F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchActivityDestroy() {
        List<OnActivityDestroyListener> list;
        list = null;
        {
            {
                list = new ArrayList<OnActivityDestroyListener>(mActivityDestroyListeners);
            } //End block
        } //End block
        {
            final int N;
            N = list.size();
            {
                int i;
                i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.066 -0400", hash_original_method = "74A43F7F50012109C1C50A128DECA709", hash_generated_method = "FB28D754B50B76B2D7814A250870D70F")
    @DSModeled(DSC.SAFE)
     int getNextRequestCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mNextRequestCode++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.066 -0400", hash_original_method = "64532379007357BDD2B5A06E80A12A41", hash_generated_method = "A4FC2390433A6D33629A8D0B472631CB")
    @DSModeled(DSC.SAFE)
     void addPreferencesScreen(DialogInterface screen) {
        dsTaint.addTaint(screen.dsTaint);
        {
            {
                mPreferencesScreens = new ArrayList<DialogInterface>();
            } //End block
            mPreferencesScreens.add(screen);
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mPreferencesScreens == null) {
                //mPreferencesScreens = new ArrayList<DialogInterface>();
            //}
            //mPreferencesScreens.add(screen);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.066 -0400", hash_original_method = "98728EB5C20211F6C02CB983C1971CE8", hash_generated_method = "CA18FF1D93E3F597C21505D53217B773")
    @DSModeled(DSC.SAFE)
     void removePreferencesScreen(DialogInterface screen) {
        dsTaint.addTaint(screen.dsTaint);
        {
            mPreferencesScreens.remove(screen);
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mPreferencesScreens == null) {
                //return;
            //}
            //mPreferencesScreens.remove(screen);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.066 -0400", hash_original_method = "4573B347852C64DB794205DBF1F726CF", hash_generated_method = "0DF392DA56DAB40D998B219EE28D1CF0")
    @DSModeled(DSC.SPEC)
     void dispatchNewIntent(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        dismissAllScreens();
        // ---------- Original Method ----------
        //dismissAllScreens();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.066 -0400", hash_original_method = "9025418B8BBAFCD2E271951C43610D69", hash_generated_method = "20FE1B2F10D922049CD36A6B96621DBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dismissAllScreens() {
        ArrayList<DialogInterface> screensToDismiss;
        {
            screensToDismiss = new ArrayList<DialogInterface>(mPreferencesScreens);
            mPreferencesScreens.clear();
        } //End block
        {
            int i;
            i = screensToDismiss.size() - 1;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.067 -0400", hash_original_method = "285310B7C58E8A2220B6B265614A6D90", hash_generated_method = "056A9C8FAC23A7C7C77E5545B95A4349")
    @DSModeled(DSC.SAFE)
     void setOnPreferenceTreeClickListener(OnPreferenceTreeClickListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnPreferenceTreeClickListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.067 -0400", hash_original_method = "44D09E26591D5A19BD471058A1477B47", hash_generated_method = "011D839EEB1C5FF85A344F7D72B5AF3B")
    @DSModeled(DSC.SAFE)
     OnPreferenceTreeClickListener getOnPreferenceTreeClickListener() {
        return (OnPreferenceTreeClickListener)dsTaint.getTaint();
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
    
}


