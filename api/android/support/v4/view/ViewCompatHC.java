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

package android.support.v4.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class ViewCompatHC {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:29.932 -0500", hash_original_method = "0D8BE47B4CC10913DB4ECAD1674E174D", hash_generated_method = "667F213CA83AB99077A2424BF50AA4B5")
    
static long getFrameTime() {
        return ValueAnimator.getFrameDelay();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:29.934 -0500", hash_original_method = "13C7B7D6BFB552836C47A79648A3D9CC", hash_generated_method = "0AE65DB0DFCC1B87C1481742525CAC13")
    
public static void setLayerType(View view, int layerType, Paint paint) {
        view.setLayerType(layerType, paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:29.935 -0500", hash_original_method = "9B1C9F40C8B385E85FFD5E213EC50BE6", hash_generated_method = "64BD64267E48FAE833EF6BD6C412CE29")
    
public static int getLayerType(View view) {
        return view.getLayerType();
    }
}
