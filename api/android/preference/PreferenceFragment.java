package android.preference;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.ListView;





public abstract class PreferenceFragment extends Fragment implements PreferenceManager.OnPreferenceTreeClickListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.553 -0400", hash_original_field = "D1487CA8252F4AA0A95324AB4DDD5316", hash_generated_field = "13262EB3751B753EEB3302EF75D8B1E5")

    private PreferenceManager mPreferenceManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.553 -0400", hash_original_field = "F796A16BE866311501B24C73148D80F1", hash_generated_field = "C806ABBC7D990ED0AF24BE5023FCB167")

    private ListView mList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.553 -0400", hash_original_field = "9518E42289EDA6A0AA66A094C04D7B12", hash_generated_field = "8011F14F671FAD27C4FFD6AC0EF598D6")

    private boolean mHavePrefs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.553 -0400", hash_original_field = "225D2E634A6D9F644DCDEB8B336EA142", hash_generated_field = "7BD21DEB3785F1CCA6C22068B58B5E93")

    private boolean mInitDone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.410 -0400", hash_original_field = "211BE5272290A461215EA56DECAF46CC", hash_generated_field = "5A5038954D547A401391AFBD1368E284")

    private Handler mHandler = new Handler() {        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.410 -0400", hash_original_method = "6660B1C576139733BCAB4BF0F3860110", hash_generated_method = "B07FCFBE4D4B06D86DB2594E0181910C")
        @Override
        public void handleMessage(Message msg) {
            
            bindPreferences();
            
            addTaint(msg.getTaint());
            
            
                
                    
                    
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.410 -0400", hash_original_field = "F487762B42FCD79D908F11802425F9AE", hash_generated_field = "CD0106315823911D53F9614252FF5C4E")

    final private Runnable mRequestFocus = new Runnable() {        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.410 -0400", hash_original_method = "4F290F2508C3F0B44E09591C5B0749BC", hash_generated_method = "203642A5324F5F18B21A0D020E65FD5C")
        public void run() {
            mList.focusableViewAvailable(mList);
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.411 -0400", hash_original_field = "DA9BF4E41535FF3170B4CEBFA3A21543", hash_generated_field = "E6F0CF32783CB12F7272D76F8F71ABD1")

    private OnKeyListener mListOnKeyListener = new OnKeyListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.411 -0400", hash_original_method = "42F4F5EF32199C59321FBA32E8E299B1", hash_generated_method = "385965B92DA9C2E4AE30708839934258")
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            
            Object selectedItem = mList.getSelectedItem();
            {
                View selectedView = mList.getSelectedView();
                boolean var024E0137020151FF758E138586192620_1251233631 = (((Preference)selectedItem).onKey(
                        selectedView, keyCode, event));
            } 
            addTaint(v.getTaint());
            addTaint(keyCode);
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_493062161 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_493062161;
            
            
            
                
                
                        
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.553 -0400", hash_original_method = "7AC8446BD8400B4FB28876E58FD0C82C", hash_generated_method = "7AC8446BD8400B4FB28876E58FD0C82C")
    public PreferenceFragment ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.554 -0400", hash_original_method = "14584F9C5C89DF812017D65CA10140CA", hash_generated_method = "6FF9C151A932DCC9F728AF78F9445317")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        super.onCreate(savedInstanceState);
        mPreferenceManager = new PreferenceManager(getActivity(), FIRST_REQUEST_CODE);
        mPreferenceManager.setFragment(this);
        // ---------- Original Method ----------
        //super.onCreate(savedInstanceState);
        //mPreferenceManager = new PreferenceManager(getActivity(), FIRST_REQUEST_CODE);
        //mPreferenceManager.setFragment(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.554 -0400", hash_original_method = "791E09A6EB15382808CD8A1F8A420342", hash_generated_method = "25F795E8C5A20A1E154D0E2B54AA49BB")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        addTaint(container.getTaint());
        addTaint(inflater.getTaint());
View varD0B63ED7DA328F8BD7BA58ECA7EAE095_2121203117 =         inflater.inflate(com.android.internal.R.layout.preference_list_fragment, container,
                false);
        varD0B63ED7DA328F8BD7BA58ECA7EAE095_2121203117.addTaint(taint);
        return varD0B63ED7DA328F8BD7BA58ECA7EAE095_2121203117;
        // ---------- Original Method ----------
        //return inflater.inflate(com.android.internal.R.layout.preference_list_fragment, container,
                //false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.554 -0400", hash_original_method = "428378000E0F8A164C3A97E3B49B3453", hash_generated_method = "C353F02A7DFF1ACD9E116D03A0983B7A")
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        super.onActivityCreated(savedInstanceState);
        if(mHavePrefs)        
        {
            bindPreferences();
        } //End block
        mInitDone = true;
        if(savedInstanceState != null)        
        {
            Bundle container = savedInstanceState.getBundle(PREFERENCES_TAG);
            if(container != null)            
            {
                final PreferenceScreen preferenceScreen = getPreferenceScreen();
                if(preferenceScreen != null)                
                {
                    preferenceScreen.restoreHierarchyState(container);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //super.onActivityCreated(savedInstanceState);
        //if (mHavePrefs) {
            //bindPreferences();
        //}
        //mInitDone = true;
        //if (savedInstanceState != null) {
            //Bundle container = savedInstanceState.getBundle(PREFERENCES_TAG);
            //if (container != null) {
                //final PreferenceScreen preferenceScreen = getPreferenceScreen();
                //if (preferenceScreen != null) {
                    //preferenceScreen.restoreHierarchyState(container);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.554 -0400", hash_original_method = "43649DF11F13E2637210DBACA4CC8D33", hash_generated_method = "D0689129ACB54896271454CAE57B768E")
    @Override
    public void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStart();
        mPreferenceManager.setOnPreferenceTreeClickListener(this);
        // ---------- Original Method ----------
        //super.onStart();
        //mPreferenceManager.setOnPreferenceTreeClickListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.554 -0400", hash_original_method = "A0B40E1EDC23C730D4B2DB4DFCBF5599", hash_generated_method = "3377460E54B2419A8818E67B2FC42EBA")
    @Override
    public void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStop();
        mPreferenceManager.dispatchActivityStop();
        mPreferenceManager.setOnPreferenceTreeClickListener(null);
        // ---------- Original Method ----------
        //super.onStop();
        //mPreferenceManager.dispatchActivityStop();
        //mPreferenceManager.setOnPreferenceTreeClickListener(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.555 -0400", hash_original_method = "DD4A0119F9218E9767B3382C8F996136", hash_generated_method = "A18F8A2A0A2FA9C65A7E34DB52823907")
    @Override
    public void onDestroyView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mList = null;
        mHandler.removeCallbacks(mRequestFocus);
        mHandler.removeMessages(MSG_BIND_PREFERENCES);
        super.onDestroyView();
        // ---------- Original Method ----------
        //mList = null;
        //mHandler.removeCallbacks(mRequestFocus);
        //mHandler.removeMessages(MSG_BIND_PREFERENCES);
        //super.onDestroyView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.555 -0400", hash_original_method = "A8BE499835A02B140E34CDE8D21019C1", hash_generated_method = "0899F3D9FAF778E9CAC863266C36BEDB")
    @Override
    public void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDestroy();
        mPreferenceManager.dispatchActivityDestroy();
        // ---------- Original Method ----------
        //super.onDestroy();
        //mPreferenceManager.dispatchActivityDestroy();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.555 -0400", hash_original_method = "26BF943D86091571AFE724B01D9065B4", hash_generated_method = "C35FFADF09A43FCB362DC3815BF256A6")
    @Override
    public void onSaveInstanceState(Bundle outState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(outState.getTaint());
        super.onSaveInstanceState(outState);
        final PreferenceScreen preferenceScreen = getPreferenceScreen();
        if(preferenceScreen != null)        
        {
            Bundle container = new Bundle();
            preferenceScreen.saveHierarchyState(container);
            outState.putBundle(PREFERENCES_TAG, container);
        } //End block
        // ---------- Original Method ----------
        //super.onSaveInstanceState(outState);
        //final PreferenceScreen preferenceScreen = getPreferenceScreen();
        //if (preferenceScreen != null) {
            //Bundle container = new Bundle();
            //preferenceScreen.saveHierarchyState(container);
            //outState.putBundle(PREFERENCES_TAG, container);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.555 -0400", hash_original_method = "ED65E8315019E6E9FED78D8EFC0AFB01", hash_generated_method = "1069C8639F7071B756CD13F5B7EC18FB")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(data.getTaint());
        addTaint(resultCode);
        addTaint(requestCode);
        super.onActivityResult(requestCode, resultCode, data);
        mPreferenceManager.dispatchActivityResult(requestCode, resultCode, data);
        // ---------- Original Method ----------
        //super.onActivityResult(requestCode, resultCode, data);
        //mPreferenceManager.dispatchActivityResult(requestCode, resultCode, data);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.556 -0400", hash_original_method = "002FC5CEE5BE5B5D1FE36CEDBC1DEB65", hash_generated_method = "DC223CB19EDF6F791BEA10EA6B904B93")
    public PreferenceManager getPreferenceManager() {
PreferenceManager var00374A2A6A541F0EA9C609E6C6447EED_1642931474 =         mPreferenceManager;
        var00374A2A6A541F0EA9C609E6C6447EED_1642931474.addTaint(taint);
        return var00374A2A6A541F0EA9C609E6C6447EED_1642931474;
        // ---------- Original Method ----------
        //return mPreferenceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.556 -0400", hash_original_method = "B9D9F1216249E53073B37D7754117BEA", hash_generated_method = "0F206C73ECBAF93573C04F9DFC292AE0")
    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        addTaint(preferenceScreen.getTaint());
        if(mPreferenceManager.setPreferences(preferenceScreen) && preferenceScreen != null)        
        {
            mHavePrefs = true;
            if(mInitDone)            
            {
                postBindPreferences();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mPreferenceManager.setPreferences(preferenceScreen) && preferenceScreen != null) {
            //mHavePrefs = true;
            //if (mInitDone) {
                //postBindPreferences();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.556 -0400", hash_original_method = "9FBCEEF6D5AB95BCE1255F6B27DCC1FB", hash_generated_method = "E3C9D48FEC524BDFCE7C1A0F0385DC52")
    public PreferenceScreen getPreferenceScreen() {
PreferenceScreen varDAFD38741BC1123E8F4608DDE091E020_1176972689 =         mPreferenceManager.getPreferenceScreen();
        varDAFD38741BC1123E8F4608DDE091E020_1176972689.addTaint(taint);
        return varDAFD38741BC1123E8F4608DDE091E020_1176972689;
        // ---------- Original Method ----------
        //return mPreferenceManager.getPreferenceScreen();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.556 -0400", hash_original_method = "5674CE8C214451535BFAB18211614C8C", hash_generated_method = "F85F789656537B3736817DCDDFC2985D")
    public void addPreferencesFromIntent(Intent intent) {
        addTaint(intent.getTaint());
        requirePreferenceManager();
        setPreferenceScreen(mPreferenceManager.inflateFromIntent(intent, getPreferenceScreen()));
        // ---------- Original Method ----------
        //requirePreferenceManager();
        //setPreferenceScreen(mPreferenceManager.inflateFromIntent(intent, getPreferenceScreen()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.557 -0400", hash_original_method = "730912206D2245A2DDEB83331D1CD295", hash_generated_method = "2D26F1C52F7B0E44CB534DF72B55356C")
    public void addPreferencesFromResource(int preferencesResId) {
        addTaint(preferencesResId);
        requirePreferenceManager();
        setPreferenceScreen(mPreferenceManager.inflateFromResource(getActivity(),
                preferencesResId, getPreferenceScreen()));
        // ---------- Original Method ----------
        //requirePreferenceManager();
        //setPreferenceScreen(mPreferenceManager.inflateFromResource(getActivity(),
                //preferencesResId, getPreferenceScreen()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.557 -0400", hash_original_method = "80D6854EDB6C9EF01A71267A1360D8F7", hash_generated_method = "3FBD5285DB029F94B5D08848740457D1")
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
            Preference preference) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(preference.getTaint());
        addTaint(preferenceScreen.getTaint());
        if(preference.getFragment() != null &&
                getActivity() instanceof OnPreferenceStartFragmentCallback)        
        {
            boolean varEF282018DE9AD05EC469CADFCA2BE761_245998763 = (((OnPreferenceStartFragmentCallback)getActivity()).onPreferenceStartFragment(
                    this, preference));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_143276679 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_143276679;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1904333287 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1640974894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1640974894;
        // ---------- Original Method ----------
        //if (preference.getFragment() != null &&
                //getActivity() instanceof OnPreferenceStartFragmentCallback) {
            //return ((OnPreferenceStartFragmentCallback)getActivity()).onPreferenceStartFragment(
                    //this, preference);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.557 -0400", hash_original_method = "0C794FFD7CBFBB35093DF6CE24875508", hash_generated_method = "612317E02F7141E068DAD962095F0EAF")
    public Preference findPreference(CharSequence key) {
        addTaint(key.getTaint());
        if(mPreferenceManager == null)        
        {
Preference var540C13E9E156B687226421B24F2DF178_1564741641 =             null;
            var540C13E9E156B687226421B24F2DF178_1564741641.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1564741641;
        } //End block
Preference var3F9904390C47A44ACE8B6D395680E8CD_1749886173 =         mPreferenceManager.findPreference(key);
        var3F9904390C47A44ACE8B6D395680E8CD_1749886173.addTaint(taint);
        return var3F9904390C47A44ACE8B6D395680E8CD_1749886173;
        // ---------- Original Method ----------
        //if (mPreferenceManager == null) {
            //return null;
        //}
        //return mPreferenceManager.findPreference(key);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.557 -0400", hash_original_method = "F3FAECD811389BDC2E843E71360C928C", hash_generated_method = "F349548BD163925B029C749E56837C40")
    private void requirePreferenceManager() {
        if(mPreferenceManager == null)        
        {
            RuntimeException var3378A9C87F81772D2E810C2DBC2CC508_1923669817 = new RuntimeException("This should be called after super.onCreate.");
            var3378A9C87F81772D2E810C2DBC2CC508_1923669817.addTaint(taint);
            throw var3378A9C87F81772D2E810C2DBC2CC508_1923669817;
        } //End block
        // ---------- Original Method ----------
        //if (mPreferenceManager == null) {
            //throw new RuntimeException("This should be called after super.onCreate.");
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.557 -0400", hash_original_method = "6C1825C42631AE6FCE57D0240C5D762E", hash_generated_method = "62DE4FD95EC2A6D210170DB16FB47120")
    private void postBindPreferences() {
        if(mHandler.hasMessages(MSG_BIND_PREFERENCES))        
        return;
        mHandler.obtainMessage(MSG_BIND_PREFERENCES).sendToTarget();
        // ---------- Original Method ----------
        //if (mHandler.hasMessages(MSG_BIND_PREFERENCES)) return;
        //mHandler.obtainMessage(MSG_BIND_PREFERENCES).sendToTarget();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.558 -0400", hash_original_method = "C0B8E456E30D2EFCEB5004C31E6B868F", hash_generated_method = "A1B59C19F26D008A601E442F66DB1A4A")
    private void bindPreferences() {
        final PreferenceScreen preferenceScreen = getPreferenceScreen();
        if(preferenceScreen != null)        
        {
            preferenceScreen.bind(getListView());
        } //End block
        // ---------- Original Method ----------
        //final PreferenceScreen preferenceScreen = getPreferenceScreen();
        //if (preferenceScreen != null) {
            //preferenceScreen.bind(getListView());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.558 -0400", hash_original_method = "B9D8406BF510100833C8B83670824289", hash_generated_method = "949CA2F71931DB09B849B6DF3DFA5F7B")
    public ListView getListView() {
        ensureList();
ListView var344AE622895130273F3D062543816FEE_493275436 =         mList;
        var344AE622895130273F3D062543816FEE_493275436.addTaint(taint);
        return var344AE622895130273F3D062543816FEE_493275436;
        // ---------- Original Method ----------
        //ensureList();
        //return mList;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.558 -0400", hash_original_method = "E40145CD20E8491E945AD408A8CD6C13", hash_generated_method = "D448D1A003DA61678F64FFBF4055B7C3")
    private void ensureList() {
        if(mList != null)        
        {
            return;
        } //End block
        View root = getView();
        if(root == null)        
        {
            IllegalStateException var052948DC6923A855D5D68E1310933CAB_2083132905 = new IllegalStateException("Content view not yet created");
            var052948DC6923A855D5D68E1310933CAB_2083132905.addTaint(taint);
            throw var052948DC6923A855D5D68E1310933CAB_2083132905;
        } //End block
        View rawListView = root.findViewById(android.R.id.list);
        if(!(rawListView instanceof ListView))        
        {
            RuntimeException var21587997F544C4FA9C985E7B90148739_1555411215 = new RuntimeException(
                    "Content has view with id attribute 'android.R.id.list' "
                    + "that is not a ListView class");
            var21587997F544C4FA9C985E7B90148739_1555411215.addTaint(taint);
            throw var21587997F544C4FA9C985E7B90148739_1555411215;
        } //End block
        mList = (ListView)rawListView;
        if(mList == null)        
        {
            RuntimeException var814898E2A75124B230F991BD301E888E_74979557 = new RuntimeException(
                    "Your content must have a ListView whose id attribute is " +
                    "'android.R.id.list'");
            var814898E2A75124B230F991BD301E888E_74979557.addTaint(taint);
            throw var814898E2A75124B230F991BD301E888E_74979557;
        } //End block
        mList.setOnKeyListener(mListOnKeyListener);
        mHandler.post(mRequestFocus);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public interface OnPreferenceStartFragmentCallback {
        
        boolean onPreferenceStartFragment(PreferenceFragment caller, Preference pref);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.558 -0400", hash_original_field = "333F725D03F58301C39760396324751A", hash_generated_field = "21CC2FFDC9ED4475ACF01DBC06B2A292")

    private static final String PREFERENCES_TAG = "android:preferences";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.558 -0400", hash_original_field = "0466831DAC50AD91F00BE2472F26C26A", hash_generated_field = "0136D59B093194DD543B8062A7975D9E")

    private static final int FIRST_REQUEST_CODE = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.558 -0400", hash_original_field = "D7A6754ED93721763C237AE926734ECE", hash_generated_field = "7A68CD10BF8C3B855976E8E8F733E671")

    private static final int MSG_BIND_PREFERENCES = 1;
}

