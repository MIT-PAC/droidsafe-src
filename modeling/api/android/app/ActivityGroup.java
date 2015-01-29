/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import java.util.HashMap;

import android.content.Intent;
import android.os.Bundle;

/**
 * A screen that contains and runs multiple embedded activities.
 *
 * @deprecated Use the new {@link Fragment} and {@link FragmentManager} APIs
 * instead; these are also
 * available on older platforms through the Android compatibility package.
 */
@Deprecated
public class ActivityGroup extends Activity {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-07 12:46:31.696 -0500", hash_original_field = "4A358BE5BDBECD448B3A6054B917FAFE", hash_generated_field = "1B1CF035C8E33148F5737039E1CF7416")

    private static final String STATES_KEY = "android:states";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-07 12:46:31.709 -0500", hash_original_field = "23462FC250D021F3166FD69AAB3BC0BB", hash_generated_field = "73547C32C8CD10C63A819DBF03C3CAF5")

    static final String PARENT_NON_CONFIG_INSTANCE_KEY = "android:parent_non_config_instance";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-07 12:46:31.718 -0500", hash_original_field = "8D983F41B42A734FB9F36AD74EE29E08", hash_generated_field = "608BD4B332B9EA2937D81000E89B6DE0")

    protected LocalActivityManager mLocalActivityManager;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-07 12:46:31.726 -0500", hash_original_method = "2AE03BACAB887CF7A6D90481487D2FF6", hash_generated_method = "FC15AF3FD8F3A1EA0CCD059B29D49F7B")
    
public ActivityGroup() {
        this(true);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-07 12:46:31.736 -0500", hash_original_method = "B102548477D76CE98F77072DB09F268F", hash_generated_method = "C88284A9024511B875B8D11C044CCADF")
    
public ActivityGroup(boolean singleActivityMode) {
        mLocalActivityManager = new LocalActivityManager(this, singleActivityMode);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-07 12:46:31.747 -0500", hash_original_method = "96D303A1531FF329BB7500E6AC728702", hash_generated_method = "BD77D8E9731BA3F582FCCDE213051CA5")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle states = savedInstanceState != null
                ? (Bundle) savedInstanceState.getBundle(STATES_KEY) : null;
        mLocalActivityManager.dispatchCreate(states);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-07 12:46:31.770 -0500", hash_original_method = "F4E7F925AD67F8C08641672CC736CBD1", hash_generated_method = "E8A638190FD50359F0DBFE5F3B99684F")

    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    protected void onResume() {
        super.onResume();
        mLocalActivityManager.dispatchResume();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-07 12:46:31.781 -0500", hash_original_method = "42BC4841682BB427F9696A4814584FE9", hash_generated_method = "DA5CBD401712E9E6D4505CB1B535F718")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Bundle state = mLocalActivityManager.saveInstanceState();
        if (state != null) {
            outState.putBundle(STATES_KEY, state);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-07 12:46:31.789 -0500", hash_original_method = "FE5C48D98D4B78F303997B7614AC45A4", hash_generated_method = "023308D7FE28046A581D6078045BE7A4")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    protected void onPause() {
        super.onPause();
        mLocalActivityManager.dispatchPause(isFinishing());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-07 12:46:31.797 -0500", hash_original_method = "BC201DA8DDB80A0B4AC67ABF425CB100", hash_generated_method = "C25F60F1C749830CBFCB1F528EA8FC6D")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    protected void onStop() {
        super.onStop();
        mLocalActivityManager.dispatchStop();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-07 12:46:31.812 -0500", hash_original_method = "25D4F476B8DF9F422F9CA53AF33664B2", hash_generated_method = "A2AA3F01C4D2AA1C455897CD050E0314")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    protected void onDestroy() {
        super.onDestroy();
        mLocalActivityManager.dispatchDestroy(isFinishing());
    }

    /**
     * Returns a HashMap mapping from child activity ids to the return values
     * from calls to their onRetainNonConfigurationInstance methods.
     *
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-07 12:46:31.821 -0500", hash_original_method = "46EDFE893B3C99E7A9342FF7459E98E1", hash_generated_method = "E7BBF9ED533175375C3947C409E31164")
    
@Override
    public HashMap<String,Object> onRetainNonConfigurationChildInstances() {
        return mLocalActivityManager.dispatchRetainNonConfigurationInstance();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-07 12:46:31.829 -0500", hash_original_method = "4ED9D3000426A44D3C2FDE7055259431", hash_generated_method = "91577E33D1EFA741A0E12EC6A3E6F14D")
    
public Activity getCurrentActivity() {
        return mLocalActivityManager.getCurrentActivity();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-07 12:46:31.837 -0500", hash_original_method = "CFB60E0F317D2819B9F1EACC62E429D4", hash_generated_method = "82DCFA9AC80EE5D276D959C484530AC3")
    
public final LocalActivityManager getLocalActivityManager() {
        return mLocalActivityManager;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-07 12:46:31.849 -0500", hash_original_method = "EF15653BE893F37F81828092C1398373", hash_generated_method = "33125CF7FEA618B6A92D9D0776A7A0F1")
    
@Override
    void dispatchActivityResult(String who, int requestCode, int resultCode,
            Intent data) {
        if (who != null) {
            Activity act = mLocalActivityManager.getActivity(who);
            /*
            if (false) Log.v(
                TAG, "Dispatching result: who=" + who + ", reqCode=" + requestCode
                + ", resCode=" + resultCode + ", data=" + data
                + ", rec=" + rec);
            */
            if (act != null) {
                act.onActivityResult(requestCode, resultCode, data);
                return;
            }
        }
        super.dispatchActivityResult(who, requestCode, resultCode, data);
    }
}


