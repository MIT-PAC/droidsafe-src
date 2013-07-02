package android.preference;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.409 -0400", hash_original_field = "D1487CA8252F4AA0A95324AB4DDD5316", hash_generated_field = "13262EB3751B753EEB3302EF75D8B1E5")

    private PreferenceManager mPreferenceManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.409 -0400", hash_original_field = "F796A16BE866311501B24C73148D80F1", hash_generated_field = "C806ABBC7D990ED0AF24BE5023FCB167")

    private ListView mList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.409 -0400", hash_original_field = "9518E42289EDA6A0AA66A094C04D7B12", hash_generated_field = "8011F14F671FAD27C4FFD6AC0EF598D6")

    private boolean mHavePrefs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.409 -0400", hash_original_field = "225D2E634A6D9F644DCDEB8B336EA142", hash_generated_field = "7BD21DEB3785F1CCA6C22068B58B5E93")

    private boolean mInitDone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.410 -0400", hash_original_field = "211BE5272290A461215EA56DECAF46CC", hash_generated_field = "5A5038954D547A401391AFBD1368E284")

    private Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.410 -0400", hash_original_method = "6660B1C576139733BCAB4BF0F3860110", hash_generated_method = "B07FCFBE4D4B06D86DB2594E0181910C")
        @Override
        public void handleMessage(Message msg) {
            
            bindPreferences();
            
            addTaint(msg.getTaint());
            
            
                
                    
                    
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.410 -0400", hash_original_field = "F487762B42FCD79D908F11802425F9AE", hash_generated_field = "CD0106315823911D53F9614252FF5C4E")

    final private Runnable mRequestFocus = new Runnable() {        
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.411 -0400", hash_original_method = "7AC8446BD8400B4FB28876E58FD0C82C", hash_generated_method = "7AC8446BD8400B4FB28876E58FD0C82C")
    public PreferenceFragment ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.411 -0400", hash_original_method = "14584F9C5C89DF812017D65CA10140CA", hash_generated_method = "DDBFFE6D3D18F61A4057DE95730859D5")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        mPreferenceManager = new PreferenceManager(getActivity(), FIRST_REQUEST_CODE);
        mPreferenceManager.setFragment(this);
        addTaint(savedInstanceState.getTaint());
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.412 -0400", hash_original_method = "791E09A6EB15382808CD8A1F8A420342", hash_generated_method = "DB1F7AF67372C81E7D98F271F8225598")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        
        View varB4EAC82CA7396A68D541C85D26508E83_962805059 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_962805059 = inflater.inflate(com.android.internal.R.layout.preference_list_fragment, container,
                false);
        addTaint(inflater.getTaint());
        addTaint(container.getTaint());
        addTaint(savedInstanceState.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_962805059.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_962805059;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.412 -0400", hash_original_method = "428378000E0F8A164C3A97E3B49B3453", hash_generated_method = "3B16988B8A31FBF5C70669321A41A884")
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        
        super.onActivityCreated(savedInstanceState);
        {
            bindPreferences();
        } 
        mInitDone = true;
        {
            Bundle container = savedInstanceState.getBundle(PREFERENCES_TAG);
            {
                final PreferenceScreen preferenceScreen = getPreferenceScreen();
                {
                    preferenceScreen.restoreHierarchyState(container);
                } 
            } 
        } 
        addTaint(savedInstanceState.getTaint());
        
        
        
            
        
        
        
            
            
                
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.413 -0400", hash_original_method = "43649DF11F13E2637210DBACA4CC8D33", hash_generated_method = "D0689129ACB54896271454CAE57B768E")
    @Override
    public void onStart() {
        
        super.onStart();
        mPreferenceManager.setOnPreferenceTreeClickListener(this);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.413 -0400", hash_original_method = "A0B40E1EDC23C730D4B2DB4DFCBF5599", hash_generated_method = "3377460E54B2419A8818E67B2FC42EBA")
    @Override
    public void onStop() {
        
        super.onStop();
        mPreferenceManager.dispatchActivityStop();
        mPreferenceManager.setOnPreferenceTreeClickListener(null);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.413 -0400", hash_original_method = "DD4A0119F9218E9767B3382C8F996136", hash_generated_method = "A18F8A2A0A2FA9C65A7E34DB52823907")
    @Override
    public void onDestroyView() {
        
        mList = null;
        mHandler.removeCallbacks(mRequestFocus);
        mHandler.removeMessages(MSG_BIND_PREFERENCES);
        super.onDestroyView();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.414 -0400", hash_original_method = "A8BE499835A02B140E34CDE8D21019C1", hash_generated_method = "0899F3D9FAF778E9CAC863266C36BEDB")
    @Override
    public void onDestroy() {
        
        super.onDestroy();
        mPreferenceManager.dispatchActivityDestroy();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.414 -0400", hash_original_method = "26BF943D86091571AFE724B01D9065B4", hash_generated_method = "D60F5E8EC7D13FB83F85A611DE579AD3")
    @Override
    public void onSaveInstanceState(Bundle outState) {
        
        super.onSaveInstanceState(outState);
        final PreferenceScreen preferenceScreen = getPreferenceScreen();
        {
            Bundle container = new Bundle();
            preferenceScreen.saveHierarchyState(container);
            outState.putBundle(PREFERENCES_TAG, container);
        } 
        addTaint(outState.getTaint());
        
        
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.415 -0400", hash_original_method = "ED65E8315019E6E9FED78D8EFC0AFB01", hash_generated_method = "55955FA368C10DD998CDE3F08D677E27")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        
        super.onActivityResult(requestCode, resultCode, data);
        mPreferenceManager.dispatchActivityResult(requestCode, resultCode, data);
        addTaint(requestCode);
        addTaint(resultCode);
        addTaint(data.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.415 -0400", hash_original_method = "002FC5CEE5BE5B5D1FE36CEDBC1DEB65", hash_generated_method = "D6616F6B4B499AB484A1DFCAE08ADC30")
    public PreferenceManager getPreferenceManager() {
        PreferenceManager varB4EAC82CA7396A68D541C85D26508E83_1131465622 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1131465622 = mPreferenceManager;
        varB4EAC82CA7396A68D541C85D26508E83_1131465622.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1131465622;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.415 -0400", hash_original_method = "B9D9F1216249E53073B37D7754117BEA", hash_generated_method = "474214A7899244BCBAD130618B2F0AF6")
    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        {
            boolean var551C8AB5BC879C26D0247C3960A9CA65_1399911049 = (mPreferenceManager.setPreferences(preferenceScreen) && preferenceScreen != null);
            {
                mHavePrefs = true;
                {
                    postBindPreferences();
                } 
            } 
        } 
        addTaint(preferenceScreen.getTaint());
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.416 -0400", hash_original_method = "9FBCEEF6D5AB95BCE1255F6B27DCC1FB", hash_generated_method = "B2F2221F7934CE6D1AC1A46994EC1923")
    public PreferenceScreen getPreferenceScreen() {
        PreferenceScreen varB4EAC82CA7396A68D541C85D26508E83_666690232 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_666690232 = mPreferenceManager.getPreferenceScreen();
        varB4EAC82CA7396A68D541C85D26508E83_666690232.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_666690232;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.417 -0400", hash_original_method = "5674CE8C214451535BFAB18211614C8C", hash_generated_method = "C197DF940CA351D67F29E7068DF4C51E")
    public void addPreferencesFromIntent(Intent intent) {
        requirePreferenceManager();
        setPreferenceScreen(mPreferenceManager.inflateFromIntent(intent, getPreferenceScreen()));
        addTaint(intent.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.417 -0400", hash_original_method = "730912206D2245A2DDEB83331D1CD295", hash_generated_method = "1B46872DBC656B83998833184F4FBDE9")
    public void addPreferencesFromResource(int preferencesResId) {
        requirePreferenceManager();
        setPreferenceScreen(mPreferenceManager.inflateFromResource(getActivity(),
                preferencesResId, getPreferenceScreen()));
        addTaint(preferencesResId);
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.417 -0400", hash_original_method = "80D6854EDB6C9EF01A71267A1360D8F7", hash_generated_method = "DB41DECDE8D0D7976230B36CCE709580")
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
            Preference preference) {
        
        {
            boolean var867CC0BF7E964C7FBC8C5917113E8F64_895245993 = (preference.getFragment() != null &&
                getActivity() instanceof OnPreferenceStartFragmentCallback);
            {
                boolean var8A39A2B87FC49E08BF6153F1701CDF48_1871971628 = (((OnPreferenceStartFragmentCallback)getActivity()).onPreferenceStartFragment(
                    this, preference));
            } 
        } 
        addTaint(preferenceScreen.getTaint());
        addTaint(preference.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2061136770 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2061136770;
        
        
                
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.419 -0400", hash_original_method = "0C794FFD7CBFBB35093DF6CE24875508", hash_generated_method = "D1E8232982015784B8DADFF08DF5F02D")
    public Preference findPreference(CharSequence key) {
        Preference varB4EAC82CA7396A68D541C85D26508E83_723710296 = null; 
        Preference varB4EAC82CA7396A68D541C85D26508E83_1179260869 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_723710296 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1179260869 = mPreferenceManager.findPreference(key);
        addTaint(key.getTaint());
        Preference varA7E53CE21691AB073D9660D615818899_793351760; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_793351760 = varB4EAC82CA7396A68D541C85D26508E83_723710296;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_793351760 = varB4EAC82CA7396A68D541C85D26508E83_1179260869;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_793351760.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_793351760;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.419 -0400", hash_original_method = "F3FAECD811389BDC2E843E71360C928C", hash_generated_method = "FA2DC237BA4E425C5D1D9F54E7F13E3D")
    private void requirePreferenceManager() {
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("This should be called after super.onCreate.");
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.420 -0400", hash_original_method = "6C1825C42631AE6FCE57D0240C5D762E", hash_generated_method = "C04C059D6C39587D7330CD803EDBD008")
    private void postBindPreferences() {
        {
            boolean var0A3D3B0504D764BC1C3FB906BCA6B206_436780629 = (mHandler.hasMessages(MSG_BIND_PREFERENCES));
        } 
        mHandler.obtainMessage(MSG_BIND_PREFERENCES).sendToTarget();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.420 -0400", hash_original_method = "C0B8E456E30D2EFCEB5004C31E6B868F", hash_generated_method = "59B2308DCE9F47901442750C6EA95D13")
    private void bindPreferences() {
        final PreferenceScreen preferenceScreen = getPreferenceScreen();
        {
            preferenceScreen.bind(getListView());
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.421 -0400", hash_original_method = "B9D8406BF510100833C8B83670824289", hash_generated_method = "113645C786E580AE1315F64F2B1810C5")
    public ListView getListView() {
        ListView varB4EAC82CA7396A68D541C85D26508E83_1732104934 = null; 
        ensureList();
        varB4EAC82CA7396A68D541C85D26508E83_1732104934 = mList;
        varB4EAC82CA7396A68D541C85D26508E83_1732104934.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1732104934;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.421 -0400", hash_original_method = "E40145CD20E8491E945AD408A8CD6C13", hash_generated_method = "437E24A22057538693AFA3A6FB1F8C03")
    private void ensureList() {
        View root = getView();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Content view not yet created");
        } 
        View rawListView = root.findViewById(android.R.id.list);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Content has view with id attribute 'android.R.id.list' "
                    + "that is not a ListView class");
        } 
        mList = (ListView)rawListView;
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Your content must have a ListView whose id attribute is " +
                    "'android.R.id.list'");
        } 
        mList.setOnKeyListener(mListOnKeyListener);
        mHandler.post(mRequestFocus);
        
        
    }

    
    public interface OnPreferenceStartFragmentCallback {
        
        boolean onPreferenceStartFragment(PreferenceFragment caller, Preference pref);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.421 -0400", hash_original_field = "333F725D03F58301C39760396324751A", hash_generated_field = "21CC2FFDC9ED4475ACF01DBC06B2A292")

    private static final String PREFERENCES_TAG = "android:preferences";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.421 -0400", hash_original_field = "0466831DAC50AD91F00BE2472F26C26A", hash_generated_field = "0136D59B093194DD543B8062A7975D9E")

    private static final int FIRST_REQUEST_CODE = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.421 -0400", hash_original_field = "D7A6754ED93721763C237AE926734ECE", hash_generated_field = "7A68CD10BF8C3B855976E8E8F733E671")

    private static final int MSG_BIND_PREFERENCES = 1;
}

