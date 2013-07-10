package android.nfc;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;

public final class NfcFragment extends Fragment {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.189 -0400", hash_original_method = "F4666E8353F6FA3AAFC2948046892751", hash_generated_method = "F4666E8353F6FA3AAFC2948046892751")
    public NfcFragment ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static void attach(Activity activity) {
        FragmentManager manager = activity.getFragmentManager();
        if (manager.findFragmentByTag(FRAGMENT_TAG) == null) {
            manager.beginTransaction().add(new NfcFragment(), FRAGMENT_TAG).commit();
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void remove(Activity activity) {
        FragmentManager manager = activity.getFragmentManager();
        Fragment fragment = manager.findFragmentByTag(FRAGMENT_TAG);
        if (fragment != null) {
            manager.beginTransaction().remove(fragment).commitAllowingStateLoss();
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.190 -0400", hash_original_method = "9E8EF57626D62E2B7C3743DD3C3689D3", hash_generated_method = "9F5D6EBAF09C359A7E41FA9A0D3B7610")
    @Override
    public void onAttach(Activity activity) {
        
        super.onAttach(activity);
        {
            sIsInitialized = true;
            NfcAdapter adapter = NfcAdapter.getDefaultAdapter(
                    activity.getApplicationContext());
            {
                sNfcActivityManager = adapter.mNfcActivityManager;
            } 
        } 
        addTaint(activity.getTaint());
        
        
        
            
            
                    
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.190 -0400", hash_original_method = "94292D3BC9674D261A6EF4BCCF7C8037", hash_generated_method = "68B5D5F3B18DB6952F55B8B21397896C")
    @Override
    public void onResume() {
        
        super.onResume();
        {
            sNfcActivityManager.onResume(getActivity());
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.190 -0400", hash_original_method = "3DB00EC587E995AABF9F1C949970BD43", hash_generated_method = "37A9EF1185C26C2CFB6FCDB1B9416AE3")
    @Override
    public void onPause() {
        
        super.onPause();
        {
            sNfcActivityManager.onPause(getActivity());
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.191 -0400", hash_original_method = "CC535C4F2465D6A6983D04B0B890F971", hash_generated_method = "E43DF23E0003B4EF6862A5BEC5E75CCD")
    @Override
    public void onDestroy() {
        
        super.onDestroy();
        {
            sNfcActivityManager.onDestroy(getActivity());
        } 
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.191 -0400", hash_original_field = "5EDA91289D8A17A87A48FD7662558518", hash_generated_field = "A53AF82FE2AA77C2599D3D25AA595627")

    static final String FRAGMENT_TAG = "android.nfc.NfcFragment";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.191 -0400", hash_original_field = "2D97EC3B76910B149F69BDEF7C5EC755", hash_generated_field = "F9BB84E3D4C91D00C4A915F1D24BE4F8")

    static boolean sIsInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.191 -0400", hash_original_field = "1BEA66CE88E1EAEFB746DB8E48819D9C", hash_generated_field = "90C87A13104818C85EE1C6CB0A407D60")

    static NfcActivityManager sNfcActivityManager;
}

