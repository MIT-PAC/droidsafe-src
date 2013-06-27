package android.preference;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnKeyListener;
import android.widget.ListView;

public abstract class PreferenceFragment extends Fragment implements PreferenceManager.OnPreferenceTreeClickListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.761 -0400", hash_original_field = "D1487CA8252F4AA0A95324AB4DDD5316", hash_generated_field = "13262EB3751B753EEB3302EF75D8B1E5")

    private PreferenceManager mPreferenceManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.761 -0400", hash_original_field = "F796A16BE866311501B24C73148D80F1", hash_generated_field = "C806ABBC7D990ED0AF24BE5023FCB167")

    private ListView mList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.761 -0400", hash_original_field = "9518E42289EDA6A0AA66A094C04D7B12", hash_generated_field = "8011F14F671FAD27C4FFD6AC0EF598D6")

    private boolean mHavePrefs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.761 -0400", hash_original_field = "225D2E634A6D9F644DCDEB8B336EA142", hash_generated_field = "7BD21DEB3785F1CCA6C22068B58B5E93")

    private boolean mInitDone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.762 -0400", hash_original_field = "211BE5272290A461215EA56DECAF46CC", hash_generated_field = "C485E52E775FCE65556E6F65BA535FDE")

    private Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.762 -0400", hash_original_method = "6660B1C576139733BCAB4BF0F3860110", hash_generated_method = "B07FCFBE4D4B06D86DB2594E0181910C")
        @Override
        public void handleMessage(Message msg) {
            //Begin case MSG_BIND_PREFERENCES 
            bindPreferences();
            //End case MSG_BIND_PREFERENCES 
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            //switch (msg.what) {
                //case MSG_BIND_PREFERENCES:
                    //bindPreferences();
                    //break;
            //}
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.764 -0400", hash_original_field = "F487762B42FCD79D908F11802425F9AE", hash_generated_field = "A9657EFFF2644F80831DD70D69AD0785")

    private Runnable mRequestFocus = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.763 -0400", hash_original_method = "4F290F2508C3F0B44E09591C5B0749BC", hash_generated_method = "203642A5324F5F18B21A0D020E65FD5C")
        public void run() {
            mList.focusableViewAvailable(mList);
            // ---------- Original Method ----------
            //mList.focusableViewAvailable(mList);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.770 -0400", hash_original_field = "DA9BF4E41535FF3170B4CEBFA3A21543", hash_generated_field = "583A40358A0C3909A86F392C3034CDF2")

    private OnKeyListener mListOnKeyListener = new OnKeyListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.770 -0400", hash_original_method = "42F4F5EF32199C59321FBA32E8E299B1", hash_generated_method = "865C3949FED7AAC22D0650EA69234FC6")
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            Object selectedItem;
            selectedItem = mList.getSelectedItem();
            {
                View selectedView;
                selectedView = mList.getSelectedView();
                boolean var024E0137020151FF758E138586192620_786694173 = (((Preference)selectedItem).onKey(
                        selectedView, keyCode, event));
            } //End block
            addTaint(v.getTaint());
            addTaint(keyCode);
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1406626651 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1406626651;
            // ---------- Original Method ----------
            //Object selectedItem = mList.getSelectedItem();
            //if (selectedItem instanceof Preference) {
                //View selectedView = mList.getSelectedView();
                //return ((Preference)selectedItem).onKey(
                        //selectedView, keyCode, event);
            //}
            //return false;
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.770 -0400", hash_original_method = "7AC8446BD8400B4FB28876E58FD0C82C", hash_generated_method = "7AC8446BD8400B4FB28876E58FD0C82C")
    public PreferenceFragment ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.778 -0400", hash_original_method = "14584F9C5C89DF812017D65CA10140CA", hash_generated_method = "DDBFFE6D3D18F61A4057DE95730859D5")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onCreate(savedInstanceState);
        mPreferenceManager = new PreferenceManager(getActivity(), FIRST_REQUEST_CODE);
        mPreferenceManager.setFragment(this);
        addTaint(savedInstanceState.getTaint());
        // ---------- Original Method ----------
        //super.onCreate(savedInstanceState);
        //mPreferenceManager = new PreferenceManager(getActivity(), FIRST_REQUEST_CODE);
        //mPreferenceManager.setFragment(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.787 -0400", hash_original_method = "791E09A6EB15382808CD8A1F8A420342", hash_generated_method = "CD0D09B3732CD4052B01BBD81CE31A0A")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View varB4EAC82CA7396A68D541C85D26508E83_1291009717 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1291009717 = inflater.inflate(com.android.internal.R.layout.preference_list_fragment, container,
                false);
        addTaint(inflater.getTaint());
        addTaint(container.getTaint());
        addTaint(savedInstanceState.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1291009717.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1291009717;
        // ---------- Original Method ----------
        //return inflater.inflate(com.android.internal.R.layout.preference_list_fragment, container,
                //false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.805 -0400", hash_original_method = "428378000E0F8A164C3A97E3B49B3453", hash_generated_method = "F9975A05AA897E4CE30585E51B9CF8AF")
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onActivityCreated(savedInstanceState);
        {
            bindPreferences();
        } //End block
        mInitDone = true;
        {
            Bundle container;
            container = savedInstanceState.getBundle(PREFERENCES_TAG);
            {
                PreferenceScreen preferenceScreen;
                preferenceScreen = getPreferenceScreen();
                {
                    preferenceScreen.restoreHierarchyState(container);
                } //End block
            } //End block
        } //End block
        addTaint(savedInstanceState.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.805 -0400", hash_original_method = "43649DF11F13E2637210DBACA4CC8D33", hash_generated_method = "D0689129ACB54896271454CAE57B768E")
    @Override
    public void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStart();
        mPreferenceManager.setOnPreferenceTreeClickListener(this);
        // ---------- Original Method ----------
        //super.onStart();
        //mPreferenceManager.setOnPreferenceTreeClickListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.806 -0400", hash_original_method = "A0B40E1EDC23C730D4B2DB4DFCBF5599", hash_generated_method = "3377460E54B2419A8818E67B2FC42EBA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.806 -0400", hash_original_method = "DD4A0119F9218E9767B3382C8F996136", hash_generated_method = "A18F8A2A0A2FA9C65A7E34DB52823907")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.807 -0400", hash_original_method = "A8BE499835A02B140E34CDE8D21019C1", hash_generated_method = "0899F3D9FAF778E9CAC863266C36BEDB")
    @Override
    public void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDestroy();
        mPreferenceManager.dispatchActivityDestroy();
        // ---------- Original Method ----------
        //super.onDestroy();
        //mPreferenceManager.dispatchActivityDestroy();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.807 -0400", hash_original_method = "26BF943D86091571AFE724B01D9065B4", hash_generated_method = "0FC3566B3162CEBB60E8079EC7137D52")
    @Override
    public void onSaveInstanceState(Bundle outState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onSaveInstanceState(outState);
        PreferenceScreen preferenceScreen;
        preferenceScreen = getPreferenceScreen();
        {
            Bundle container;
            container = new Bundle();
            preferenceScreen.saveHierarchyState(container);
            outState.putBundle(PREFERENCES_TAG, container);
        } //End block
        addTaint(outState.getTaint());
        // ---------- Original Method ----------
        //super.onSaveInstanceState(outState);
        //final PreferenceScreen preferenceScreen = getPreferenceScreen();
        //if (preferenceScreen != null) {
            //Bundle container = new Bundle();
            //preferenceScreen.saveHierarchyState(container);
            //outState.putBundle(PREFERENCES_TAG, container);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.826 -0400", hash_original_method = "ED65E8315019E6E9FED78D8EFC0AFB01", hash_generated_method = "55955FA368C10DD998CDE3F08D677E27")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onActivityResult(requestCode, resultCode, data);
        mPreferenceManager.dispatchActivityResult(requestCode, resultCode, data);
        addTaint(requestCode);
        addTaint(resultCode);
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        //super.onActivityResult(requestCode, resultCode, data);
        //mPreferenceManager.dispatchActivityResult(requestCode, resultCode, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.827 -0400", hash_original_method = "002FC5CEE5BE5B5D1FE36CEDBC1DEB65", hash_generated_method = "8F415237E279E55C4A50CE1631396604")
    public PreferenceManager getPreferenceManager() {
        PreferenceManager varB4EAC82CA7396A68D541C85D26508E83_309558333 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_309558333 = mPreferenceManager;
        varB4EAC82CA7396A68D541C85D26508E83_309558333.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_309558333;
        // ---------- Original Method ----------
        //return mPreferenceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.827 -0400", hash_original_method = "B9D9F1216249E53073B37D7754117BEA", hash_generated_method = "50DD7E08237D29E1B5539C924F7409E7")
    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        {
            boolean var551C8AB5BC879C26D0247C3960A9CA65_995978049 = (mPreferenceManager.setPreferences(preferenceScreen) && preferenceScreen != null);
            {
                mHavePrefs = true;
                {
                    postBindPreferences();
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(preferenceScreen.getTaint());
        // ---------- Original Method ----------
        //if (mPreferenceManager.setPreferences(preferenceScreen) && preferenceScreen != null) {
            //mHavePrefs = true;
            //if (mInitDone) {
                //postBindPreferences();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.828 -0400", hash_original_method = "9FBCEEF6D5AB95BCE1255F6B27DCC1FB", hash_generated_method = "EE895BC975AD9CF4243A9443583EC580")
    public PreferenceScreen getPreferenceScreen() {
        PreferenceScreen varB4EAC82CA7396A68D541C85D26508E83_1660186208 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1660186208 = mPreferenceManager.getPreferenceScreen();
        varB4EAC82CA7396A68D541C85D26508E83_1660186208.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1660186208;
        // ---------- Original Method ----------
        //return mPreferenceManager.getPreferenceScreen();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.828 -0400", hash_original_method = "5674CE8C214451535BFAB18211614C8C", hash_generated_method = "C197DF940CA351D67F29E7068DF4C51E")
    public void addPreferencesFromIntent(Intent intent) {
        requirePreferenceManager();
        setPreferenceScreen(mPreferenceManager.inflateFromIntent(intent, getPreferenceScreen()));
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //requirePreferenceManager();
        //setPreferenceScreen(mPreferenceManager.inflateFromIntent(intent, getPreferenceScreen()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.831 -0400", hash_original_method = "730912206D2245A2DDEB83331D1CD295", hash_generated_method = "1B46872DBC656B83998833184F4FBDE9")
    public void addPreferencesFromResource(int preferencesResId) {
        requirePreferenceManager();
        setPreferenceScreen(mPreferenceManager.inflateFromResource(getActivity(),
                preferencesResId, getPreferenceScreen()));
        addTaint(preferencesResId);
        // ---------- Original Method ----------
        //requirePreferenceManager();
        //setPreferenceScreen(mPreferenceManager.inflateFromResource(getActivity(),
                //preferencesResId, getPreferenceScreen()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.855 -0400", hash_original_method = "80D6854EDB6C9EF01A71267A1360D8F7", hash_generated_method = "8549D99ECF6A5C3CF0B025C086A5738F")
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
            Preference preference) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var867CC0BF7E964C7FBC8C5917113E8F64_2138150489 = (preference.getFragment() != null &&
                getActivity() instanceof OnPreferenceStartFragmentCallback);
            {
                boolean var8A39A2B87FC49E08BF6153F1701CDF48_927328378 = (((OnPreferenceStartFragmentCallback)getActivity()).onPreferenceStartFragment(
                    this, preference));
            } //End block
        } //End collapsed parenthetic
        addTaint(preferenceScreen.getTaint());
        addTaint(preference.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_668827591 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_668827591;
        // ---------- Original Method ----------
        //if (preference.getFragment() != null &&
                //getActivity() instanceof OnPreferenceStartFragmentCallback) {
            //return ((OnPreferenceStartFragmentCallback)getActivity()).onPreferenceStartFragment(
                    //this, preference);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.856 -0400", hash_original_method = "0C794FFD7CBFBB35093DF6CE24875508", hash_generated_method = "8CDE4FC67581D48E1BF8858C35EC9533")
    public Preference findPreference(CharSequence key) {
        Preference varB4EAC82CA7396A68D541C85D26508E83_1095714434 = null; //Variable for return #1
        Preference varB4EAC82CA7396A68D541C85D26508E83_1754595921 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1095714434 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1754595921 = mPreferenceManager.findPreference(key);
        addTaint(key.getTaint());
        Preference varA7E53CE21691AB073D9660D615818899_140860233; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_140860233 = varB4EAC82CA7396A68D541C85D26508E83_1095714434;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_140860233 = varB4EAC82CA7396A68D541C85D26508E83_1754595921;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_140860233.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_140860233;
        // ---------- Original Method ----------
        //if (mPreferenceManager == null) {
            //return null;
        //}
        //return mPreferenceManager.findPreference(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.857 -0400", hash_original_method = "F3FAECD811389BDC2E843E71360C928C", hash_generated_method = "FA2DC237BA4E425C5D1D9F54E7F13E3D")
    private void requirePreferenceManager() {
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("This should be called after super.onCreate.");
        } //End block
        // ---------- Original Method ----------
        //if (mPreferenceManager == null) {
            //throw new RuntimeException("This should be called after super.onCreate.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.861 -0400", hash_original_method = "6C1825C42631AE6FCE57D0240C5D762E", hash_generated_method = "C73134FC9964B750D792C6E670519EE4")
    private void postBindPreferences() {
        {
            boolean var0A3D3B0504D764BC1C3FB906BCA6B206_1174375656 = (mHandler.hasMessages(MSG_BIND_PREFERENCES));
        } //End collapsed parenthetic
        mHandler.obtainMessage(MSG_BIND_PREFERENCES).sendToTarget();
        // ---------- Original Method ----------
        //if (mHandler.hasMessages(MSG_BIND_PREFERENCES)) return;
        //mHandler.obtainMessage(MSG_BIND_PREFERENCES).sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.868 -0400", hash_original_method = "C0B8E456E30D2EFCEB5004C31E6B868F", hash_generated_method = "8574A185CCD1B376EF84B57F5AFB1CDC")
    private void bindPreferences() {
        PreferenceScreen preferenceScreen;
        preferenceScreen = getPreferenceScreen();
        {
            preferenceScreen.bind(getListView());
        } //End block
        // ---------- Original Method ----------
        //final PreferenceScreen preferenceScreen = getPreferenceScreen();
        //if (preferenceScreen != null) {
            //preferenceScreen.bind(getListView());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.879 -0400", hash_original_method = "B9D8406BF510100833C8B83670824289", hash_generated_method = "44376426D3690748F27E76A921EC8578")
    public ListView getListView() {
        ListView varB4EAC82CA7396A68D541C85D26508E83_319578453 = null; //Variable for return #1
        ensureList();
        varB4EAC82CA7396A68D541C85D26508E83_319578453 = mList;
        varB4EAC82CA7396A68D541C85D26508E83_319578453.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_319578453;
        // ---------- Original Method ----------
        //ensureList();
        //return mList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.889 -0400", hash_original_method = "E40145CD20E8491E945AD408A8CD6C13", hash_generated_method = "92822B453C84EFD691ECCCCB13B4348A")
    private void ensureList() {
        View root;
        root = getView();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Content view not yet created");
        } //End block
        View rawListView;
        rawListView = root.findViewById(android.R.id.list);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Content has view with id attribute 'android.R.id.list' "
                    + "that is not a ListView class");
        } //End block
        mList = (ListView)rawListView;
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Your content must have a ListView whose id attribute is " +
                    "'android.R.id.list'");
        } //End block
        mList.setOnKeyListener(mListOnKeyListener);
        mHandler.post(mRequestFocus);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public interface OnPreferenceStartFragmentCallback {
        
        boolean onPreferenceStartFragment(PreferenceFragment caller, Preference pref);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.889 -0400", hash_original_field = "333F725D03F58301C39760396324751A", hash_generated_field = "B8D32B1CFAF3111272983D08DAC505D3")

    private static String PREFERENCES_TAG = "android:preferences";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.889 -0400", hash_original_field = "0466831DAC50AD91F00BE2472F26C26A", hash_generated_field = "7B59C9E22FB89D92E9C9BE49405D418F")

    private static int FIRST_REQUEST_CODE = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.889 -0400", hash_original_field = "D7A6754ED93721763C237AE926734ECE", hash_generated_field = "B7C0D2FF79AAE30581F370D2E4D9B876")

    private static int MSG_BIND_PREFERENCES = 1;
}

