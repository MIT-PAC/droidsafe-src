package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.HashMap;
import android.content.Intent;
import android.os.Bundle;

public class ActivityGroup extends Activity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.815 -0400", hash_original_field = "14FB0923C44F471FABD31942B1B52B30", hash_generated_field = "608BD4B332B9EA2937D81000E89B6DE0")

    protected LocalActivityManager mLocalActivityManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.817 -0400", hash_original_method = "2AE03BACAB887CF7A6D90481487D2FF6", hash_generated_method = "FCF376EF1EB779B425429CF7B0C7F600")
    public  ActivityGroup() {
        this(true);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.819 -0400", hash_original_method = "B102548477D76CE98F77072DB09F268F", hash_generated_method = "C1B0C022068A17FBC0C46DA1AF5849E4")
    public  ActivityGroup(boolean singleActivityMode) {
        mLocalActivityManager = new LocalActivityManager(this, singleActivityMode);
        // ---------- Original Method ----------
        //mLocalActivityManager = new LocalActivityManager(this, singleActivityMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.842 -0400", hash_original_method = "96D303A1531FF329BB7500E6AC728702", hash_generated_method = "8E889D3EC78EC3397A66CDB454CF043E")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onCreate(savedInstanceState);
        Bundle states;
        states = (Bundle) savedInstanceState.getBundle(STATES_KEY);
        states = null;
        mLocalActivityManager.dispatchCreate(states);
        addTaint(savedInstanceState.getTaint());
        // ---------- Original Method ----------
        //super.onCreate(savedInstanceState);
        //Bundle states = savedInstanceState != null
                //? (Bundle) savedInstanceState.getBundle(STATES_KEY) : null;
        //mLocalActivityManager.dispatchCreate(states);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.844 -0400", hash_original_method = "F4E7F925AD67F8C08641672CC736CBD1", hash_generated_method = "AF855045FFA330486E3D30EE8E77EF2B")
    @Override
    protected void onResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onResume();
        mLocalActivityManager.dispatchResume();
        // ---------- Original Method ----------
        //super.onResume();
        //mLocalActivityManager.dispatchResume();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.856 -0400", hash_original_method = "42BC4841682BB427F9696A4814584FE9", hash_generated_method = "0F9F139A0920CABD98B7D2E7C35157DF")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onSaveInstanceState(outState);
        Bundle state;
        state = mLocalActivityManager.saveInstanceState();
        {
            outState.putBundle(STATES_KEY, state);
        } //End block
        addTaint(outState.getTaint());
        // ---------- Original Method ----------
        //super.onSaveInstanceState(outState);
        //Bundle state = mLocalActivityManager.saveInstanceState();
        //if (state != null) {
            //outState.putBundle(STATES_KEY, state);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.861 -0400", hash_original_method = "FE5C48D98D4B78F303997B7614AC45A4", hash_generated_method = "DA042B81BFF4BDF677B3F026BCD9DABC")
    @Override
    protected void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onPause();
        mLocalActivityManager.dispatchPause(isFinishing());
        // ---------- Original Method ----------
        //super.onPause();
        //mLocalActivityManager.dispatchPause(isFinishing());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.880 -0400", hash_original_method = "BC201DA8DDB80A0B4AC67ABF425CB100", hash_generated_method = "5856A1A2DF83AC895FFA3D1C0B9C0B37")
    @Override
    protected void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStop();
        mLocalActivityManager.dispatchStop();
        // ---------- Original Method ----------
        //super.onStop();
        //mLocalActivityManager.dispatchStop();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.890 -0400", hash_original_method = "25D4F476B8DF9F422F9CA53AF33664B2", hash_generated_method = "67103421B045B4EF4EB0F4C8C85BFF1F")
    @Override
    protected void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDestroy();
        mLocalActivityManager.dispatchDestroy(isFinishing());
        // ---------- Original Method ----------
        //super.onDestroy();
        //mLocalActivityManager.dispatchDestroy(isFinishing());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.896 -0400", hash_original_method = "46EDFE893B3C99E7A9342FF7459E98E1", hash_generated_method = "E30F8642F4FE11F3B1685B5254C4E97D")
    @Override
    public HashMap<String,Object> onRetainNonConfigurationChildInstances() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        HashMap<String,Object> varB4EAC82CA7396A68D541C85D26508E83_1344746126 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1344746126 = mLocalActivityManager.dispatchRetainNonConfigurationInstance();
        varB4EAC82CA7396A68D541C85D26508E83_1344746126.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1344746126;
        // ---------- Original Method ----------
        //return mLocalActivityManager.dispatchRetainNonConfigurationInstance();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.918 -0400", hash_original_method = "4ED9D3000426A44D3C2FDE7055259431", hash_generated_method = "B419CD1ABD14B8DE308FF2C1A74ED337")
    public Activity getCurrentActivity() {
        Activity varB4EAC82CA7396A68D541C85D26508E83_1651069891 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1651069891 = mLocalActivityManager.getCurrentActivity();
        varB4EAC82CA7396A68D541C85D26508E83_1651069891.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1651069891;
        // ---------- Original Method ----------
        //return mLocalActivityManager.getCurrentActivity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.920 -0400", hash_original_method = "CFB60E0F317D2819B9F1EACC62E429D4", hash_generated_method = "55FD39974418E8AEF80A5400D21D22CB")
    public final LocalActivityManager getLocalActivityManager() {
        LocalActivityManager varB4EAC82CA7396A68D541C85D26508E83_627520973 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_627520973 = mLocalActivityManager;
        varB4EAC82CA7396A68D541C85D26508E83_627520973.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_627520973;
        // ---------- Original Method ----------
        //return mLocalActivityManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.937 -0400", hash_original_method = "EF15653BE893F37F81828092C1398373", hash_generated_method = "7E5C60672FFA13FF1633959584543DAC")
    @Override
     void dispatchActivityResult(String who, int requestCode, int resultCode,
            Intent data) {
        {
            Activity act;
            act = mLocalActivityManager.getActivity(who);
            {
                act.onActivityResult(requestCode, resultCode, data);
            } //End block
        } //End block
        super.dispatchActivityResult(who, requestCode, resultCode, data);
        addTaint(who.getTaint());
        addTaint(requestCode);
        addTaint(resultCode);
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        //if (who != null) {
            //Activity act = mLocalActivityManager.getActivity(who);
            //if (act != null) {
                //act.onActivityResult(requestCode, resultCode, data);
                //return;
            //}
        //}
        //super.dispatchActivityResult(who, requestCode, resultCode, data);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.938 -0400", hash_original_field = "9E146CC0E60E25CC47C8EFCE9B88BE7C", hash_generated_field = "773BAE5BF01FB4BA64774E16BF71826C")

    private static String STATES_KEY = "android:states";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.955 -0400", hash_original_field = "A767EA231AD7E55D7BBEA508B30DAF2A", hash_generated_field = "A668BA9900F018CB345AE9D14E849273")

    static String PARENT_NON_CONFIG_INSTANCE_KEY = "android:parent_non_config_instance";
}

