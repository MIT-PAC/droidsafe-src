package android.nfc;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;

public final class NfcFragment extends Fragment {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.687 -0400", hash_original_method = "F4666E8353F6FA3AAFC2948046892751", hash_generated_method = "F4666E8353F6FA3AAFC2948046892751")
    public NfcFragment ()
    {
        
    }


        public static void attach(Activity activity) {
        FragmentManager manager = activity.getFragmentManager();
        if (manager.findFragmentByTag(FRAGMENT_TAG) == null) {
            manager.beginTransaction().add(new NfcFragment(), FRAGMENT_TAG).commit();
        }
    }

    
        public static void remove(Activity activity) {
        FragmentManager manager = activity.getFragmentManager();
        Fragment fragment = manager.findFragmentByTag(FRAGMENT_TAG);
        if (fragment != null) {
            manager.beginTransaction().remove(fragment).commitAllowingStateLoss();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.688 -0400", hash_original_method = "9E8EF57626D62E2B7C3743DD3C3689D3", hash_generated_method = "B2BBDBE211ECC4865C183B6FFBA946E3")
    @Override
    public void onAttach(Activity activity) {
        
        addTaint(activity.getTaint());
        super.onAttach(activity);
    if(!sIsInitialized)        
        {
            sIsInitialized = true;
            NfcAdapter adapter = NfcAdapter.getDefaultAdapter(
                    activity.getApplicationContext());
    if(adapter != null)            
            {
                sNfcActivityManager = adapter.mNfcActivityManager;
            } 
        } 
        
        
        
            
            
                    
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.689 -0400", hash_original_method = "94292D3BC9674D261A6EF4BCCF7C8037", hash_generated_method = "4AC320B0085C363B4702D105FA395F8D")
    @Override
    public void onResume() {
        
        super.onResume();
    if(sNfcActivityManager != null)        
        {
            sNfcActivityManager.onResume(getActivity());
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.689 -0400", hash_original_method = "3DB00EC587E995AABF9F1C949970BD43", hash_generated_method = "226927A4AB8142122D587930C7CE85AC")
    @Override
    public void onPause() {
        
        super.onPause();
    if(sNfcActivityManager != null)        
        {
            sNfcActivityManager.onPause(getActivity());
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.689 -0400", hash_original_method = "CC535C4F2465D6A6983D04B0B890F971", hash_generated_method = "5CE801F46E853C84800573F66B65D296")
    @Override
    public void onDestroy() {
        
        super.onDestroy();
    if(sNfcActivityManager != null)        
        {
            sNfcActivityManager.onDestroy(getActivity());
        } 
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.690 -0400", hash_original_field = "5EDA91289D8A17A87A48FD7662558518", hash_generated_field = "A53AF82FE2AA77C2599D3D25AA595627")

    static final String FRAGMENT_TAG = "android.nfc.NfcFragment";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.690 -0400", hash_original_field = "2D97EC3B76910B149F69BDEF7C5EC755", hash_generated_field = "F9BB84E3D4C91D00C4A915F1D24BE4F8")

    static boolean sIsInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.690 -0400", hash_original_field = "1BEA66CE88E1EAEFB746DB8E48819D9C", hash_generated_field = "90C87A13104818C85EE1C6CB0A407D60")

    static NfcActivityManager sNfcActivityManager;
}

