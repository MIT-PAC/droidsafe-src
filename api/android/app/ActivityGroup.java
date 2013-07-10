package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.HashMap;
import android.content.Intent;
import android.os.Bundle;

public class ActivityGroup extends Activity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.840 -0400", hash_original_field = "14FB0923C44F471FABD31942B1B52B30", hash_generated_field = "608BD4B332B9EA2937D81000E89B6DE0")

    protected LocalActivityManager mLocalActivityManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.841 -0400", hash_original_method = "2AE03BACAB887CF7A6D90481487D2FF6", hash_generated_method = "FCF376EF1EB779B425429CF7B0C7F600")
    public  ActivityGroup() {
        this(true);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.841 -0400", hash_original_method = "B102548477D76CE98F77072DB09F268F", hash_generated_method = "C1B0C022068A17FBC0C46DA1AF5849E4")
    public  ActivityGroup(boolean singleActivityMode) {
        mLocalActivityManager = new LocalActivityManager(this, singleActivityMode);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.842 -0400", hash_original_method = "96D303A1531FF329BB7500E6AC728702", hash_generated_method = "8E889D3EC78EC3397A66CDB454CF043E")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        Bundle states;
        states = (Bundle) savedInstanceState.getBundle(STATES_KEY);
        states = null;
        mLocalActivityManager.dispatchCreate(states);
        addTaint(savedInstanceState.getTaint());
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.843 -0400", hash_original_method = "F4E7F925AD67F8C08641672CC736CBD1", hash_generated_method = "AF855045FFA330486E3D30EE8E77EF2B")
    @Override
    protected void onResume() {
        
        super.onResume();
        mLocalActivityManager.dispatchResume();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.844 -0400", hash_original_method = "42BC4841682BB427F9696A4814584FE9", hash_generated_method = "2C61D819681B9D569447BECA8C0F6F9C")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        
        super.onSaveInstanceState(outState);
        Bundle state = mLocalActivityManager.saveInstanceState();
        {
            outState.putBundle(STATES_KEY, state);
        } 
        addTaint(outState.getTaint());
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.845 -0400", hash_original_method = "FE5C48D98D4B78F303997B7614AC45A4", hash_generated_method = "DA042B81BFF4BDF677B3F026BCD9DABC")
    @Override
    protected void onPause() {
        
        super.onPause();
        mLocalActivityManager.dispatchPause(isFinishing());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.846 -0400", hash_original_method = "BC201DA8DDB80A0B4AC67ABF425CB100", hash_generated_method = "5856A1A2DF83AC895FFA3D1C0B9C0B37")
    @Override
    protected void onStop() {
        
        super.onStop();
        mLocalActivityManager.dispatchStop();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.847 -0400", hash_original_method = "25D4F476B8DF9F422F9CA53AF33664B2", hash_generated_method = "67103421B045B4EF4EB0F4C8C85BFF1F")
    @Override
    protected void onDestroy() {
        
        super.onDestroy();
        mLocalActivityManager.dispatchDestroy(isFinishing());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.848 -0400", hash_original_method = "46EDFE893B3C99E7A9342FF7459E98E1", hash_generated_method = "FDABCAA24F8025E7E095C7061F775618")
    @Override
    public HashMap<String,Object> onRetainNonConfigurationChildInstances() {
        
        HashMap<String,Object> varB4EAC82CA7396A68D541C85D26508E83_1483131772 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1483131772 = mLocalActivityManager.dispatchRetainNonConfigurationInstance();
        varB4EAC82CA7396A68D541C85D26508E83_1483131772.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1483131772;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.849 -0400", hash_original_method = "4ED9D3000426A44D3C2FDE7055259431", hash_generated_method = "1A28495EAD1FA5973016D3C115BAD7AD")
    public Activity getCurrentActivity() {
        Activity varB4EAC82CA7396A68D541C85D26508E83_357084191 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_357084191 = mLocalActivityManager.getCurrentActivity();
        varB4EAC82CA7396A68D541C85D26508E83_357084191.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_357084191;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.850 -0400", hash_original_method = "CFB60E0F317D2819B9F1EACC62E429D4", hash_generated_method = "AA707C54C653D185EC2E95430F888E9F")
    public final LocalActivityManager getLocalActivityManager() {
        LocalActivityManager varB4EAC82CA7396A68D541C85D26508E83_737102996 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_737102996 = mLocalActivityManager;
        varB4EAC82CA7396A68D541C85D26508E83_737102996.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_737102996;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.850 -0400", hash_original_method = "EF15653BE893F37F81828092C1398373", hash_generated_method = "B3FC0F0682782F27CFB40F23F16DD589")
    @Override
     void dispatchActivityResult(String who, int requestCode, int resultCode,
            Intent data) {
        {
            Activity act = mLocalActivityManager.getActivity(who);
            {
                act.onActivityResult(requestCode, resultCode, data);
            } 
        } 
        super.dispatchActivityResult(who, requestCode, resultCode, data);
        addTaint(who.getTaint());
        addTaint(requestCode);
        addTaint(resultCode);
        addTaint(data.getTaint());
        
        
            
            
                
                
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.851 -0400", hash_original_field = "9E146CC0E60E25CC47C8EFCE9B88BE7C", hash_generated_field = "1B1CF035C8E33148F5737039E1CF7416")

    private static final String STATES_KEY = "android:states";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.851 -0400", hash_original_field = "A767EA231AD7E55D7BBEA508B30DAF2A", hash_generated_field = "73547C32C8CD10C63A819DBF03C3CAF5")

    static final String PARENT_NON_CONFIG_INSTANCE_KEY = "android:parent_non_config_instance";
}

