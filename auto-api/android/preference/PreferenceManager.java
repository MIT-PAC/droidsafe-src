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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.711 -0400", hash_original_method = "A48679E26B4CF910ADEF8C7563331346", hash_generated_method = "F1A1FC919AD83AD718B307E6FA0A66BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     PreferenceManager(Activity activity, int firstRequestCode) {
        dsTaint.addTaint(firstRequestCode);
        dsTaint.addTaint(activity.dsTaint);
        init(activity);
        // ---------- Original Method ----------
        //mActivity = activity;
        //mNextRequestCode = firstRequestCode;
        //init(activity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.711 -0400", hash_original_method = "962D66AE85693F6FF77A2DEF54D76478", hash_generated_method = "60C7F53D564457DA6DBBAB8EDCDC4F5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private PreferenceManager(Context context) {
        dsTaint.addTaint(context.dsTaint);
        init(context);
        // ---------- Original Method ----------
        //init(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.711 -0400", hash_original_method = "2AA94A8F94EE739DE2B0DB27540BEB34", hash_generated_method = "AFB7A4C1C3C9A877FC2426FF8D6E0EC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init(Context context) {
        dsTaint.addTaint(context.dsTaint);
        setSharedPreferencesName(getDefaultSharedPreferencesName(context));
        // ---------- Original Method ----------
        //mContext = context;
        //setSharedPreferencesName(getDefaultSharedPreferencesName(context));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.722 -0400", hash_original_method = "922F3E36F99E52FA3036E92080002B11", hash_generated_method = "5C947397308360EA5448AED093FF6222")
    @DSModeled(DSC.SAFE)
     void setFragment(PreferenceFragment fragment) {
        dsTaint.addTaint(fragment.dsTaint);
        // ---------- Original Method ----------
        //mFragment = fragment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.722 -0400", hash_original_method = "11BC570017448843B9A9A22E52E0E479", hash_generated_method = "1B5ACEB7DE464FF793E0B10ECAC7F390")
    @DSModeled(DSC.SAFE)
     PreferenceFragment getFragment() {
        return (PreferenceFragment)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFragment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.722 -0400", hash_original_method = "6682C9F88019B1A37FE99B0D2B3B34A2", hash_generated_method = "89F5805D4EAD8A1BA85784348688ADB2")
    @DSModeled(DSC.SPEC)
    private List<ResolveInfo> queryIntentActivities(Intent queryIntent) {
        dsTaint.addTaint(queryIntent.dsTaint);
        List<ResolveInfo> var59F2D462372FAD99326B1574628BE656_340260773 = (mContext.getPackageManager().queryIntentActivities(queryIntent,
                PackageManager.GET_META_DATA));
        return (List<ResolveInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext.getPackageManager().queryIntentActivities(queryIntent,
                //PackageManager.GET_META_DATA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.724 -0400", hash_original_method = "96A93C80BB9070BDED20D9AB85FFA8E8", hash_generated_method = "094C09BC7501B43D3FCCBFDADFE6BF34")
    @DSModeled(DSC.SPEC)
     PreferenceScreen inflateFromIntent(Intent queryIntent, PreferenceScreen rootPreferences) {
        dsTaint.addTaint(rootPreferences.dsTaint);
        dsTaint.addTaint(queryIntent.dsTaint);
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
                    boolean varCCFE5DA33F498B61582829F1A271E4A2_472991252 = ((metaData == null) || !metaData.containsKey(METADATA_KEY_PREFERENCES));
                } //End collapsed parenthetic
                String uniqueResId;
                uniqueResId = activityInfo.packageName + ":"
                    + activityInfo.metaData.getInt(METADATA_KEY_PREFERENCES);
                {
                    boolean varC3FF154FA48BC17A0ABB9C1087AA7414_958699933 = (!inflatedRes.contains(uniqueResId));
                    {
                        inflatedRes.add(uniqueResId);
                        Context context;
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
        return (PreferenceScreen)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.725 -0400", hash_original_method = "94F9DF66CFF516C2DE1B651AB9A3388E", hash_generated_method = "4D98C39F75698B84755CFA115AFA358D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PreferenceScreen inflateFromResource(Context context, int resId,
            PreferenceScreen rootPreferences) {
        dsTaint.addTaint(rootPreferences.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(resId);
        setNoCommit(true);
        PreferenceInflater inflater;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.726 -0400", hash_original_method = "AE92D4BACEE41B351C64A7E59B1B4342", hash_generated_method = "4D03463E35418353F08648C5A5E8DECB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PreferenceScreen createPreferenceScreen(Context context) {
        dsTaint.addTaint(context.dsTaint);
        PreferenceScreen preferenceScreen;
        preferenceScreen = new PreferenceScreen(context, null);
        preferenceScreen.onAttachedToHierarchy(this);
        return (PreferenceScreen)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final PreferenceScreen preferenceScreen = new PreferenceScreen(context, null);
        //preferenceScreen.onAttachedToHierarchy(this);
        //return preferenceScreen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.726 -0400", hash_original_method = "D904EAF0B6D90BB52E1F8594EC3F4D15", hash_generated_method = "87F105B1C2FA2D479FDCF184A1D52FEA")
    @DSModeled(DSC.SAFE)
     long getNextId() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mNextId++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.726 -0400", hash_original_method = "BDB110631059975A566BD4AA87A106E8", hash_generated_method = "4A2AA660B4A58148FAC39018919FFD5A")
    @DSModeled(DSC.SAFE)
    public String getSharedPreferencesName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSharedPreferencesName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.727 -0400", hash_original_method = "F8FB75CAC643ECF72FE6E9CDE35245C6", hash_generated_method = "F131E3F51277D6986DA599F63368AE8D")
    @DSModeled(DSC.SAFE)
    public void setSharedPreferencesName(String sharedPreferencesName) {
        dsTaint.addTaint(sharedPreferencesName);
        mSharedPreferences = null;
        // ---------- Original Method ----------
        //mSharedPreferencesName = sharedPreferencesName;
        //mSharedPreferences = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.727 -0400", hash_original_method = "D2CF6E8640E20A030077A21285843C05", hash_generated_method = "3B42FDCF79D4A2E53EDDAAFF3B2890C3")
    @DSModeled(DSC.SAFE)
    public int getSharedPreferencesMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSharedPreferencesMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.728 -0400", hash_original_method = "6988E36A0998B14CBE7D70DCBAB74FF8", hash_generated_method = "F22ADE2CD1746C004D4B2CA2290B3BF4")
    @DSModeled(DSC.SAFE)
    public void setSharedPreferencesMode(int sharedPreferencesMode) {
        dsTaint.addTaint(sharedPreferencesMode);
        mSharedPreferences = null;
        // ---------- Original Method ----------
        //mSharedPreferencesMode = sharedPreferencesMode;
        //mSharedPreferences = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.729 -0400", hash_original_method = "B901A30CD0A7131EC29E8BD072ADC21D", hash_generated_method = "4282D51885CE70C7DAECFC9E5A228A5F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.731 -0400", hash_original_method = "60967B21FA602EB86E9B5EB647B08AF2", hash_generated_method = "C7E350ADEAD6667DA66C920F4F68BD02")
    @DSModeled(DSC.SAFE)
     PreferenceScreen getPreferenceScreen() {
        return (PreferenceScreen)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mPreferenceScreen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.731 -0400", hash_original_method = "72F330353D1AAD0C361FC98ABB0551E0", hash_generated_method = "7CFAEAB8CCD2BC5214A49A53B479627F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.731 -0400", hash_original_method = "313075D13AC6A3D78BD3127C39A86211", hash_generated_method = "44D9B1E7167D93F6032DACAA507DEEC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Preference findPreference(CharSequence key) {
        dsTaint.addTaint(key);
        Preference var87C1A986291E6AFED7D02EAECE847A62_1229405968 = (mPreferenceScreen.findPreference(key));
        return (Preference)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.732 -0400", hash_original_method = "D4733D45210A4F96431F976F3F9AB3C2", hash_generated_method = "4BF20F5164EA8F1920F78678EFE0E4CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SharedPreferences.Editor getEditor() {
        {
            {
                mEditor = getSharedPreferences().edit();
            } //End block
        } //End block
        {
            SharedPreferences.Editor var0948B81E09E41A32904748A17BADC880_209456008 = (getSharedPreferences().edit());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.732 -0400", hash_original_method = "47C154426E8AAB84597A7B272BF8D2FA", hash_generated_method = "14DB7925FB81714B3B9DDBA7699CE625")
    @DSModeled(DSC.SAFE)
     boolean shouldCommit() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !mNoCommit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.733 -0400", hash_original_method = "2ED947FD2CD87E45A298D362CE1C3C54", hash_generated_method = "73D5291BD17138FD579A1D4775AF8634")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.733 -0400", hash_original_method = "3F17133E8D63AE8C7414DC58966291E3", hash_generated_method = "0CCA83D1B90B580ED5B3B87A35D20A5D")
    @DSModeled(DSC.SAFE)
     Activity getActivity() {
        return (Activity)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.733 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "B0B2DDBEB77BA94D0A4C33C64B71FA82")
    @DSModeled(DSC.SAFE)
     Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.733 -0400", hash_original_method = "8C7924F669844968ABD2440B12D35A69", hash_generated_method = "0486B16E44BEA324F97CDA6DC417BE4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void registerOnActivityResultListener(OnActivityResultListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(listener.dsTaint);
        {
            {
                mActivityResultListeners = new ArrayList<OnActivityResultListener>();
            } //End block
            {
                boolean var15DEA0801B4CA66F31C20D5EEB846813_1638686088 = (!mActivityResultListeners.contains(listener));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.734 -0400", hash_original_method = "2F16D3A7CC67220808B5AF6C63D00415", hash_generated_method = "8A4BA236B108C9C27B10E7B2C6D7D8A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void unregisterOnActivityResultListener(OnActivityResultListener listener) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.734 -0400", hash_original_method = "A3EFE32034D38DFF1A90F9A5F45D56A6", hash_generated_method = "4F3AD123455C8A6386459835978FDBE7")
    @DSModeled(DSC.SPEC)
     void dispatchActivityResult(int requestCode, int resultCode, Intent data) {
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(resultCode);
        List<OnActivityResultListener> list;
        {
            list = new ArrayList<OnActivityResultListener>(mActivityResultListeners);
        } //End block
        int N;
        N = list.size();
        {
            int i;
            i = 0;
            {
                {
                    boolean varA0E378DB28F1EA78419E01C6630E728F_262653364 = (list.get(i).onActivityResult(requestCode, resultCode, data));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.734 -0400", hash_original_method = "2A0808589AAB6A9778EC4C51EF499853", hash_generated_method = "8CC75838EFAD6ECE4B06457F9FDDB473")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void registerOnActivityStopListener(OnActivityStopListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(listener.dsTaint);
        {
            {
                mActivityStopListeners = new ArrayList<OnActivityStopListener>();
            } //End block
            {
                boolean var8DD9D2AD16524FCA9AA66A5DFCB0DD9D_1051852772 = (!mActivityStopListeners.contains(listener));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.735 -0400", hash_original_method = "D042C49681BB57CB7E14977DE37ED6E0", hash_generated_method = "8775F4BB202879E1E078AC09E845B36F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void unregisterOnActivityStopListener(OnActivityStopListener listener) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.735 -0400", hash_original_method = "6FD57C464C4DA57829A6C2B52E45A452", hash_generated_method = "1EE8CF8BE53B75A860C2D0AF79A8F057")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchActivityStop() {
        List<OnActivityStopListener> list;
        {
            list = new ArrayList<OnActivityStopListener>(mActivityStopListeners);
        } //End block
        int N;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.735 -0400", hash_original_method = "8932A6D76CD73EDD58651F522607034F", hash_generated_method = "95336ACE419DCDF5FB162A66D49FDC14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void registerOnActivityDestroyListener(OnActivityDestroyListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(listener.dsTaint);
        {
            {
                mActivityDestroyListeners = new ArrayList<OnActivityDestroyListener>();
            } //End block
            {
                boolean var7376631AC503E8DE4340FDE7CD8C5D8E_1059191747 = (!mActivityDestroyListeners.contains(listener));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.736 -0400", hash_original_method = "221E9A8BD7E96AD4198B64196703C2D4", hash_generated_method = "2AA1D139DDE3989254DA51FF31FF108D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void unregisterOnActivityDestroyListener(OnActivityDestroyListener listener) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.736 -0400", hash_original_method = "ABC0DFC11A448AE601035D9520ECAF99", hash_generated_method = "A64C00776B9121AB8FE450CA2FC38987")
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
            int N;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.736 -0400", hash_original_method = "74A43F7F50012109C1C50A128DECA709", hash_generated_method = "A65CE946D475406A4228D2B498960A90")
    @DSModeled(DSC.SAFE)
     int getNextRequestCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mNextRequestCode++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.736 -0400", hash_original_method = "64532379007357BDD2B5A06E80A12A41", hash_generated_method = "8CAC2631453AF676A880573578D3CBA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.737 -0400", hash_original_method = "98728EB5C20211F6C02CB983C1971CE8", hash_generated_method = "A8DA7F15E77F7B8E4862939D0859EC07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.737 -0400", hash_original_method = "4573B347852C64DB794205DBF1F726CF", hash_generated_method = "3A542A35A42CC8020FB45A9268E15EAF")
    @DSModeled(DSC.SPEC)
     void dispatchNewIntent(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        dismissAllScreens();
        // ---------- Original Method ----------
        //dismissAllScreens();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.737 -0400", hash_original_method = "9025418B8BBAFCD2E271951C43610D69", hash_generated_method = "7EE7BB55892756091976079355014E54")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.738 -0400", hash_original_method = "285310B7C58E8A2220B6B265614A6D90", hash_generated_method = "F2E8DBE802782E8A8624E0E4A08FD122")
    @DSModeled(DSC.SAFE)
     void setOnPreferenceTreeClickListener(OnPreferenceTreeClickListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnPreferenceTreeClickListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.738 -0400", hash_original_method = "44D09E26591D5A19BD471058A1477B47", hash_generated_method = "F0FC5B3415D6F65342AB96DAF7FC05FC")
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
    
    private static final String TAG = "PreferenceManager";
    public static final String METADATA_KEY_PREFERENCES = "android.preference";
    public static final String KEY_HAS_SET_DEFAULT_VALUES = "_has_set_default_values";
}

