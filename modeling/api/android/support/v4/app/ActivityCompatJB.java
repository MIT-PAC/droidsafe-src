/*
 * Copyright (C) 2012 The Android Open Source Project
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
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class ActivityCompatJB {
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:54.481 -0400", hash_original_method = "EC2F08D2F56161485A23876377125A51", hash_generated_method = "829C0CDC999587A975F155AC40EC741E")
    
public static void startActivity(Context context, Intent intent, Bundle options) {
    	intent.addTaint(options.getTaint());
        context.startActivity(intent);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:54.488 -0400", hash_original_method = "0A2BEC98B5A7676E54E6B9DAE800F426", hash_generated_method = "DE00602C7D7DB806DFD620EDB4B70678")
    
public static void startActivityForResult(Activity activity, Intent intent, int requestCode, Bundle options) {
    	intent.addTaint(options.getTaint());
        activity.startActivityForResult(intent, requestCode);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:54.492 -0400", hash_original_method = "FC2F9520AC746E59C216145672BD1746", hash_generated_method = "47CEE8421520C90519E735514915E54B")
    
public static void finishAffinity(Activity activity) {
        activity.finishAffinity();
    }
}
