/*
 * Copyright (C) 2011 The Android Open Source Project
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

package android.support.v4.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.Activity;
import android.content.Intent;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

class ShareCompatICS {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:57.104 -0500", hash_original_field = "947C9B43CFC289E95FC356164736E967", hash_generated_field = "95DACE398CE3A9191D58C77F0410A924")

    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:57.109 -0500", hash_original_method = "412B6883D84857E64446D127AF58A967", hash_generated_method = "C07B141D45FAF6B637912EFDE873649C")
    
public static void configureMenuItem(MenuItem item, Activity callingActivity, Intent intent) {
        ActionProvider itemProvider = item.getActionProvider();
        ShareActionProvider provider = null;
        if (!(itemProvider instanceof ShareActionProvider)) {
            provider = new ShareActionProvider(callingActivity);
        } else {
            provider = (ShareActionProvider) itemProvider;
        }
        provider.setShareHistoryFileName(HISTORY_FILENAME_PREFIX +
                callingActivity.getClass().getName());
        provider.setShareIntent(intent);
        item.setActionProvider(provider);
    }
}
