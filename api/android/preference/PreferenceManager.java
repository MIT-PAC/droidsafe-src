package android.preference;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.696 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "B0D69375984D6EE7DC93AC12DB4DFC55")

    private Activity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.696 -0400", hash_original_field = "3FD10A4D9B0E4F081E637AB2E170510C", hash_generated_field = "CFB43EBA13761D69B30BE1C8ABC90FE3")

    private PreferenceFragment mFragment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.697 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.697 -0400", hash_original_field = "A17D8D6E755B4D9F0325D801FA4F522E", hash_generated_field = "5707822036BF051C0059AD070444BD58")

    private long mNextId = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.697 -0400", hash_original_field = "4D3E01F29E2B733089344544F0A2603B", hash_generated_field = "AD359E85C996698973B9458D92AF4B64")

    private int mNextRequestCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.697 -0400", hash_original_field = "E241A9EA476C8AD360A6AF86B26B9894", hash_generated_field = "E69BF347D3F561905392BD5BBB86A4AF")

    private SharedPreferences mSharedPreferences;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.697 -0400", hash_original_field = "3D8FE9A15F9A53942FA618F826FAAFAF", hash_generated_field = "93BFA57AAD9A25C531F3726BE9E311D1")

    private SharedPreferences.Editor mEditor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.697 -0400", hash_original_field = "DAB8B93668BA5C4E8F1FA494EFEB56CF", hash_generated_field = "0870CFBDAD0F12B21EFE736694E5D5A0")

    private boolean mNoCommit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.697 -0400", hash_original_field = "2CC6E4D34D38FBDAB4FF7426A8D306D0", hash_generated_field = "08A9F51924058A9BDDEB8AE59F95CBF8")

    private String mSharedPreferencesName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.697 -0400", hash_original_field = "0E08AB7B895C16662875F197C1D44525", hash_generated_field = "3DFD0E17BB5556DF650F1E4262E37691")

    private int mSharedPreferencesMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.697 -0400", hash_original_field = "3E80BD46BA722B2DEF6CEFDE0275013E", hash_generated_field = "6929FA68B759CC402927F67ADE03851B")

    private PreferenceScreen mPreferenceScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.697 -0400", hash_original_field = "0FC215BE4A48484D140C21D5FB74120B", hash_generated_field = "759FE206EC137F2D102DEE69CB506E29")

    private List<OnActivityResultListener> mActivityResultListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.697 -0400", hash_original_field = "B5B2B104EE390763BB06AE8C00F2D113", hash_generated_field = "AB511ABA80C53F6AD5EC1856C35DAF7F")

    private List<OnActivityStopListener> mActivityStopListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.697 -0400", hash_original_field = "E8D0AA01EBF581234349769ABDFB96C5", hash_generated_field = "ED711A008E3B4CD7A93067555688693E")

    private List<OnActivityDestroyListener> mActivityDestroyListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.697 -0400", hash_original_field = "56170581385593D634EBED0A25E25CB6", hash_generated_field = "EEC46A0D6BAD420AFB426C404E85D2BA")

    private List<DialogInterface> mPreferencesScreens;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.698 -0400", hash_original_field = "EBF233AC10AB295ADBFE9F3DE441C883", hash_generated_field = "420F1647C8F11E826C9DE0A838CD7533")

    private OnPreferenceTreeClickListener mOnPreferenceTreeClickListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.698 -0400", hash_original_method = "A48679E26B4CF910ADEF8C7563331346", hash_generated_method = "B66A3E0FCD8D031D8854177CFA39A7CA")
      PreferenceManager(Activity activity, int firstRequestCode) {
        mActivity = activity;
        mNextRequestCode = firstRequestCode;
        init(activity);
        // ---------- Original Method ----------
        //mActivity = activity;
        //mNextRequestCode = firstRequestCode;
        //init(activity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.699 -0400", hash_original_method = "962D66AE85693F6FF77A2DEF54D76478", hash_generated_method = "34B51017A324E0CC9BE74F3575C5B9BA")
    private  PreferenceManager(Context context) {
        addTaint(context.getTaint());
        init(context);
        // ---------- Original Method ----------
        //init(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.699 -0400", hash_original_method = "2AA94A8F94EE739DE2B0DB27540BEB34", hash_generated_method = "1FEF65B26EA7FB18FC4F33B72116A507")
    private void init(Context context) {
        mContext = context;
        setSharedPreferencesName(getDefaultSharedPreferencesName(context));
        // ---------- Original Method ----------
        //mContext = context;
        //setSharedPreferencesName(getDefaultSharedPreferencesName(context));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.700 -0400", hash_original_method = "922F3E36F99E52FA3036E92080002B11", hash_generated_method = "0365529319BA5CC1DE5358358F20159B")
     void setFragment(PreferenceFragment fragment) {
        mFragment = fragment;
        // ---------- Original Method ----------
        //mFragment = fragment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.700 -0400", hash_original_method = "11BC570017448843B9A9A22E52E0E479", hash_generated_method = "8AA98C1A98113FCAF04ED0560504BBEB")
     PreferenceFragment getFragment() {
PreferenceFragment var5DA1096D62F21920EA3FC00E046E5678_88328022 =         mFragment;
        var5DA1096D62F21920EA3FC00E046E5678_88328022.addTaint(taint);
        return var5DA1096D62F21920EA3FC00E046E5678_88328022;
        // ---------- Original Method ----------
        //return mFragment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.701 -0400", hash_original_method = "6682C9F88019B1A37FE99B0D2B3B34A2", hash_generated_method = "7A4560AC2097B71796E0FC0FAF7DF344")
    private List<ResolveInfo> queryIntentActivities(Intent queryIntent) {
        addTaint(queryIntent.getTaint());
List<ResolveInfo> var90D0C2A9EDAA21DC643062744F0BBA7C_2089216957 =         mContext.getPackageManager().queryIntentActivities(queryIntent,
                PackageManager.GET_META_DATA);
        var90D0C2A9EDAA21DC643062744F0BBA7C_2089216957.addTaint(taint);
        return var90D0C2A9EDAA21DC643062744F0BBA7C_2089216957;
        // ---------- Original Method ----------
        //return mContext.getPackageManager().queryIntentActivities(queryIntent,
                //PackageManager.GET_META_DATA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.702 -0400", hash_original_method = "96A93C80BB9070BDED20D9AB85FFA8E8", hash_generated_method = "CB6156E53D81D6B6D7576A66AE235B97")
     PreferenceScreen inflateFromIntent(Intent queryIntent, PreferenceScreen rootPreferences) {
        addTaint(rootPreferences.getTaint());
        addTaint(queryIntent.getTaint());
        final List<ResolveInfo> activities = queryIntentActivities(queryIntent);
        final HashSet<String> inflatedRes = new HashSet<String>();
for(int i = activities.size() - 1;i >= 0;i--)
        {
            final ActivityInfo activityInfo = activities.get(i).activityInfo;
            final Bundle metaData = activityInfo.metaData;
    if((metaData == null) || !metaData.containsKey(METADATA_KEY_PREFERENCES))            
            {
                continue;
            } //End block
            final String uniqueResId = activityInfo.packageName + ":"
                    + activityInfo.metaData.getInt(METADATA_KEY_PREFERENCES);
    if(!inflatedRes.contains(uniqueResId))            
            {
                inflatedRes.add(uniqueResId);
                Context context;
                try 
                {
                    context = mContext.createPackageContext(activityInfo.packageName, 0);
                } //End block
                catch (NameNotFoundException e)
                {
                    continue;
                } //End block
                final PreferenceInflater inflater = new PreferenceInflater(context, this);
                final XmlResourceParser parser = activityInfo.loadXmlMetaData(context
                        .getPackageManager(), METADATA_KEY_PREFERENCES);
                rootPreferences = (PreferenceScreen) inflater
                        .inflate(parser, rootPreferences, true);
                parser.close();
            } //End block
        } //End block
        rootPreferences.onAttachedToHierarchy(this);
PreferenceScreen varD1085896DC735505FE279EE21156CD3E_1106249749 =         rootPreferences;
        varD1085896DC735505FE279EE21156CD3E_1106249749.addTaint(taint);
        return varD1085896DC735505FE279EE21156CD3E_1106249749;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.702 -0400", hash_original_method = "94F9DF66CFF516C2DE1B651AB9A3388E", hash_generated_method = "A1A3E0A79A77BC60ADC5BB13EDE99E0A")
    public PreferenceScreen inflateFromResource(Context context, int resId,
            PreferenceScreen rootPreferences) {
        addTaint(rootPreferences.getTaint());
        addTaint(resId);
        addTaint(context.getTaint());
        setNoCommit(true);
        final PreferenceInflater inflater = new PreferenceInflater(context, this);
        rootPreferences = (PreferenceScreen) inflater.inflate(resId, rootPreferences, true);
        rootPreferences.onAttachedToHierarchy(this);
        setNoCommit(false);
PreferenceScreen varD1085896DC735505FE279EE21156CD3E_986350074 =         rootPreferences;
        varD1085896DC735505FE279EE21156CD3E_986350074.addTaint(taint);
        return varD1085896DC735505FE279EE21156CD3E_986350074;
        // ---------- Original Method ----------
        //setNoCommit(true);
        //final PreferenceInflater inflater = new PreferenceInflater(context, this);
        //rootPreferences = (PreferenceScreen) inflater.inflate(resId, rootPreferences, true);
        //rootPreferences.onAttachedToHierarchy(this);
        //setNoCommit(false);
        //return rootPreferences;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.703 -0400", hash_original_method = "AE92D4BACEE41B351C64A7E59B1B4342", hash_generated_method = "DD93808B62BBC227EA85DC0C45B49625")
    public PreferenceScreen createPreferenceScreen(Context context) {
        addTaint(context.getTaint());
        final PreferenceScreen preferenceScreen = new PreferenceScreen(context, null);
        preferenceScreen.onAttachedToHierarchy(this);
PreferenceScreen var5F9FB27F59B0B528F3074161301A321F_1329753287 =         preferenceScreen;
        var5F9FB27F59B0B528F3074161301A321F_1329753287.addTaint(taint);
        return var5F9FB27F59B0B528F3074161301A321F_1329753287;
        // ---------- Original Method ----------
        //final PreferenceScreen preferenceScreen = new PreferenceScreen(context, null);
        //preferenceScreen.onAttachedToHierarchy(this);
        //return preferenceScreen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.703 -0400", hash_original_method = "D904EAF0B6D90BB52E1F8594EC3F4D15", hash_generated_method = "CBAF59F011B549A05976156090EAE682")
     long getNextId() {
        synchronized
(this)        {
            long var2E7314F80C7D1C23F20240D51B140398_317463844 = (mNextId++);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1989895787 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1989895787;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mNextId++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.704 -0400", hash_original_method = "BDB110631059975A566BD4AA87A106E8", hash_generated_method = "79B2DE0ED5720A818766F1557B41EC8D")
    public String getSharedPreferencesName() {
String var6BB3630D7C4F8CB0125907324ED922F4_109454240 =         mSharedPreferencesName;
        var6BB3630D7C4F8CB0125907324ED922F4_109454240.addTaint(taint);
        return var6BB3630D7C4F8CB0125907324ED922F4_109454240;
        // ---------- Original Method ----------
        //return mSharedPreferencesName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.704 -0400", hash_original_method = "F8FB75CAC643ECF72FE6E9CDE35245C6", hash_generated_method = "D9BEB55F87EC14156033461466352F28")
    public void setSharedPreferencesName(String sharedPreferencesName) {
        mSharedPreferencesName = sharedPreferencesName;
        mSharedPreferences = null;
        // ---------- Original Method ----------
        //mSharedPreferencesName = sharedPreferencesName;
        //mSharedPreferences = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.705 -0400", hash_original_method = "D2CF6E8640E20A030077A21285843C05", hash_generated_method = "AE1EB0F481037734779F656866CDD505")
    public int getSharedPreferencesMode() {
        int var0E08AB7B895C16662875F197C1D44525_1300104792 = (mSharedPreferencesMode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_874646877 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_874646877;
        // ---------- Original Method ----------
        //return mSharedPreferencesMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.710 -0400", hash_original_method = "6988E36A0998B14CBE7D70DCBAB74FF8", hash_generated_method = "9D485153CC70863E2B681C1F00F79C11")
    public void setSharedPreferencesMode(int sharedPreferencesMode) {
        mSharedPreferencesMode = sharedPreferencesMode;
        mSharedPreferences = null;
        // ---------- Original Method ----------
        //mSharedPreferencesMode = sharedPreferencesMode;
        //mSharedPreferences = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.710 -0400", hash_original_method = "B901A30CD0A7131EC29E8BD072ADC21D", hash_generated_method = "D6A4C9F80C3E7C15682A4449043697CE")
    public SharedPreferences getSharedPreferences() {
    if(mSharedPreferences == null)        
        {
            mSharedPreferences = mContext.getSharedPreferences(mSharedPreferencesName,
                    mSharedPreferencesMode);
        } //End block
SharedPreferences var51219B3CDC87A25E51630D49EFFCE292_2113411474 =         mSharedPreferences;
        var51219B3CDC87A25E51630D49EFFCE292_2113411474.addTaint(taint);
        return var51219B3CDC87A25E51630D49EFFCE292_2113411474;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.711 -0400", hash_original_method = "60967B21FA602EB86E9B5EB647B08AF2", hash_generated_method = "6543A5DB50CD374A0BF6C599319C139E")
     PreferenceScreen getPreferenceScreen() {
PreferenceScreen varBD47EECFB0EB94EE949C85E37FA9DD44_984719417 =         mPreferenceScreen;
        varBD47EECFB0EB94EE949C85E37FA9DD44_984719417.addTaint(taint);
        return varBD47EECFB0EB94EE949C85E37FA9DD44_984719417;
        // ---------- Original Method ----------
        //return mPreferenceScreen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.712 -0400", hash_original_method = "72F330353D1AAD0C361FC98ABB0551E0", hash_generated_method = "25C5DB26174A034BCE1A586EE09AED0D")
     boolean setPreferences(PreferenceScreen preferenceScreen) {
    if(preferenceScreen != mPreferenceScreen)        
        {
            mPreferenceScreen = preferenceScreen;
            boolean varB326B5062B2F0E69046810717534CB09_1843311530 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_315524202 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_315524202;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_632056230 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_61370547 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_61370547;
        // ---------- Original Method ----------
        //if (preferenceScreen != mPreferenceScreen) {
            //mPreferenceScreen = preferenceScreen;
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.712 -0400", hash_original_method = "313075D13AC6A3D78BD3127C39A86211", hash_generated_method = "EC906A02055B401B5DD2FB9221A2F9C6")
    public Preference findPreference(CharSequence key) {
        addTaint(key.getTaint());
    if(mPreferenceScreen == null)        
        {
Preference var540C13E9E156B687226421B24F2DF178_218432437 =             null;
            var540C13E9E156B687226421B24F2DF178_218432437.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_218432437;
        } //End block
Preference var9C6F359FB789290914AE76733086B9FC_63908511 =         mPreferenceScreen.findPreference(key);
        var9C6F359FB789290914AE76733086B9FC_63908511.addTaint(taint);
        return var9C6F359FB789290914AE76733086B9FC_63908511;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.713 -0400", hash_original_method = "D4733D45210A4F96431F976F3F9AB3C2", hash_generated_method = "95DF21A0A2012C4506391349EF9EFEBC")
     SharedPreferences.Editor getEditor() {
    if(mNoCommit)        
        {
    if(mEditor == null)            
            {
                mEditor = getSharedPreferences().edit();
            } //End block
SharedPreferences.Editor var2D04CA417CFCC60C302B8B016B062983_1732441829 =             mEditor;
            var2D04CA417CFCC60C302B8B016B062983_1732441829.addTaint(taint);
            return var2D04CA417CFCC60C302B8B016B062983_1732441829;
        } //End block
        else
        {
SharedPreferences.Editor varA6CD2099D508E43C12F4496CEDFD54C4_1351255587 =             getSharedPreferences().edit();
            varA6CD2099D508E43C12F4496CEDFD54C4_1351255587.addTaint(taint);
            return varA6CD2099D508E43C12F4496CEDFD54C4_1351255587;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.713 -0400", hash_original_method = "47C154426E8AAB84597A7B272BF8D2FA", hash_generated_method = "60BF0B8623D9EEBC2FDB114C1ECD3397")
     boolean shouldCommit() {
        boolean varD961B46FD9813486F7D6B07ADD72CA9E_1178876156 = (!mNoCommit);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2076757281 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2076757281;
        // ---------- Original Method ----------
        //return !mNoCommit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.714 -0400", hash_original_method = "2ED947FD2CD87E45A298D362CE1C3C54", hash_generated_method = "4BD75C86C65D262DB4AC16D9BA4805BF")
    private void setNoCommit(boolean noCommit) {
    if(!noCommit && mEditor != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.715 -0400", hash_original_method = "3F17133E8D63AE8C7414DC58966291E3", hash_generated_method = "B079AC47136BDBB70B741B410DBB1171")
     Activity getActivity() {
Activity var3D4F4FFFAA1A051817B4856E624EDB92_1636227512 =         mActivity;
        var3D4F4FFFAA1A051817B4856E624EDB92_1636227512.addTaint(taint);
        return var3D4F4FFFAA1A051817B4856E624EDB92_1636227512;
        // ---------- Original Method ----------
        //return mActivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.715 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "A7FEED7ED067E895FAD628FD20BBA2AE")
     Context getContext() {
Context var178E2AD52D6FBBB503F908168856B574_1222148837 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_1222148837.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_1222148837;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.715 -0400", hash_original_method = "8C7924F669844968ABD2440B12D35A69", hash_generated_method = "662521B7F15809F0A516A6CEF62EB9E2")
     void registerOnActivityResultListener(OnActivityResultListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(listener.getTaint());
        synchronized
(this)        {
    if(mActivityResultListeners == null)            
            {
                mActivityResultListeners = new ArrayList<OnActivityResultListener>();
            } //End block
    if(!mActivityResultListeners.contains(listener))            
            {
                mActivityResultListeners.add(listener);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.716 -0400", hash_original_method = "2F16D3A7CC67220808B5AF6C63D00415", hash_generated_method = "8933B83F9C333D1D10E2CF034749ADA5")
     void unregisterOnActivityResultListener(OnActivityResultListener listener) {
        addTaint(listener.getTaint());
        synchronized
(this)        {
    if(mActivityResultListeners != null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.716 -0400", hash_original_method = "A3EFE32034D38DFF1A90F9A5F45D56A6", hash_generated_method = "C5FF8BB84AE6F05E56CB8F0119313688")
     void dispatchActivityResult(int requestCode, int resultCode, Intent data) {
        addTaint(data.getTaint());
        addTaint(resultCode);
        addTaint(requestCode);
        List<OnActivityResultListener> list;
        synchronized
(this)        {
    if(mActivityResultListeners == null)            
            return;
            list = new ArrayList<OnActivityResultListener>(mActivityResultListeners);
        } //End block
        final int N = list.size();
for(int i = 0;i < N;i++)
        {
    if(list.get(i).onActivityResult(requestCode, resultCode, data))            
            {
                break;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.717 -0400", hash_original_method = "2A0808589AAB6A9778EC4C51EF499853", hash_generated_method = "78F729572FAE15DFA20BD523361C85A2")
     void registerOnActivityStopListener(OnActivityStopListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(listener.getTaint());
        synchronized
(this)        {
    if(mActivityStopListeners == null)            
            {
                mActivityStopListeners = new ArrayList<OnActivityStopListener>();
            } //End block
    if(!mActivityStopListeners.contains(listener))            
            {
                mActivityStopListeners.add(listener);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.718 -0400", hash_original_method = "D042C49681BB57CB7E14977DE37ED6E0", hash_generated_method = "DB2FFC78D146E25272C7E73A639A1C50")
     void unregisterOnActivityStopListener(OnActivityStopListener listener) {
        addTaint(listener.getTaint());
        synchronized
(this)        {
    if(mActivityStopListeners != null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.718 -0400", hash_original_method = "6FD57C464C4DA57829A6C2B52E45A452", hash_generated_method = "0901F88778112AFE8EC32D96EE1B4C9A")
     void dispatchActivityStop() {
        List<OnActivityStopListener> list;
        synchronized
(this)        {
    if(mActivityStopListeners == null)            
            return;
            list = new ArrayList<OnActivityStopListener>(mActivityStopListeners);
        } //End block
        final int N = list.size();
for(int i = 0;i < N;i++)
        {
            list.get(i).onActivityStop();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.719 -0400", hash_original_method = "8932A6D76CD73EDD58651F522607034F", hash_generated_method = "E0E31223776A06911D99DD153F174F2D")
     void registerOnActivityDestroyListener(OnActivityDestroyListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(listener.getTaint());
        synchronized
(this)        {
    if(mActivityDestroyListeners == null)            
            {
                mActivityDestroyListeners = new ArrayList<OnActivityDestroyListener>();
            } //End block
    if(!mActivityDestroyListeners.contains(listener))            
            {
                mActivityDestroyListeners.add(listener);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.719 -0400", hash_original_method = "221E9A8BD7E96AD4198B64196703C2D4", hash_generated_method = "920BD6CDDD3551DF4565856A149623BC")
     void unregisterOnActivityDestroyListener(OnActivityDestroyListener listener) {
        addTaint(listener.getTaint());
        synchronized
(this)        {
    if(mActivityDestroyListeners != null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.719 -0400", hash_original_method = "ABC0DFC11A448AE601035D9520ECAF99", hash_generated_method = "8AE04A76F7E23A005CECA51422CA4A4B")
     void dispatchActivityDestroy() {
        List<OnActivityDestroyListener> list = null;
        synchronized
(this)        {
    if(mActivityDestroyListeners != null)            
            {
                list = new ArrayList<OnActivityDestroyListener>(mActivityDestroyListeners);
            } //End block
        } //End block
    if(list != null)        
        {
            final int N = list.size();
for(int i = 0;i < N;i++)
            {
                list.get(i).onActivityDestroy();
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.720 -0400", hash_original_method = "74A43F7F50012109C1C50A128DECA709", hash_generated_method = "D017D04B537FD386B353346F0FF64B57")
     int getNextRequestCode() {
        synchronized
(this)        {
            int var5AC3315F5BCDF392ADD5123D185B74D1_1056359990 = (mNextRequestCode++);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_442940176 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_442940176;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mNextRequestCode++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.720 -0400", hash_original_method = "64532379007357BDD2B5A06E80A12A41", hash_generated_method = "480A4CCFC891D6AC1E5CE3B01C65DC1D")
     void addPreferencesScreen(DialogInterface screen) {
        addTaint(screen.getTaint());
        synchronized
(this)        {
    if(mPreferencesScreens == null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.721 -0400", hash_original_method = "98728EB5C20211F6C02CB983C1971CE8", hash_generated_method = "ACB4674B3AC6EA5BF4AEDAA9FDEAC62A")
     void removePreferencesScreen(DialogInterface screen) {
        addTaint(screen.getTaint());
        synchronized
(this)        {
    if(mPreferencesScreens == null)            
            {
                return;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.721 -0400", hash_original_method = "4573B347852C64DB794205DBF1F726CF", hash_generated_method = "5BCCC400830354D3A2D0D473AC848DF2")
     void dispatchNewIntent(Intent intent) {
        addTaint(intent.getTaint());
        dismissAllScreens();
        // ---------- Original Method ----------
        //dismissAllScreens();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.721 -0400", hash_original_method = "9025418B8BBAFCD2E271951C43610D69", hash_generated_method = "A3F6EC93B62F8AA7FA81DA75CAAA6268")
    private void dismissAllScreens() {
        ArrayList<DialogInterface> screensToDismiss;
        synchronized
(this)        {
    if(mPreferencesScreens == null)            
            {
                return;
            } //End block
            screensToDismiss = new ArrayList<DialogInterface>(mPreferencesScreens);
            mPreferencesScreens.clear();
        } //End block
for(int i = screensToDismiss.size() - 1;i >= 0;i--)
        {
            screensToDismiss.get(i).dismiss();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.722 -0400", hash_original_method = "285310B7C58E8A2220B6B265614A6D90", hash_generated_method = "54FF302A27BDAFD0688C064472C3369F")
     void setOnPreferenceTreeClickListener(OnPreferenceTreeClickListener listener) {
        mOnPreferenceTreeClickListener = listener;
        // ---------- Original Method ----------
        //mOnPreferenceTreeClickListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.722 -0400", hash_original_method = "44D09E26591D5A19BD471058A1477B47", hash_generated_method = "02453366E80E340B4A4C93F8F99E8944")
     OnPreferenceTreeClickListener getOnPreferenceTreeClickListener() {
OnPreferenceTreeClickListener varB08DABDC79CDA3DF8BAB21982B3869A7_1996389040 =         mOnPreferenceTreeClickListener;
        varB08DABDC79CDA3DF8BAB21982B3869A7_1996389040.addTaint(taint);
        return varB08DABDC79CDA3DF8BAB21982B3869A7_1996389040;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.722 -0400", hash_original_field = "3B3156BFCCD2750D37F1326B97CB5F31", hash_generated_field = "7AAEA04E4548D5AB6EC8143F21A30EA9")

    private static final String TAG = "PreferenceManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.722 -0400", hash_original_field = "A2BD9669003E7E13497AC3567764BDBD", hash_generated_field = "6C182C497B18AE33867D48A4D7F5655E")

    public static final String METADATA_KEY_PREFERENCES = "android.preference";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.722 -0400", hash_original_field = "9F2BA8A2ED391A83C5161DE1503D56BD", hash_generated_field = "99247B06873D9B62D5B8F33E5FB96366")

    public static final String KEY_HAS_SET_DEFAULT_VALUES = "_has_set_default_values";
}

