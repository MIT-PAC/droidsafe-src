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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:52:28.151 -0400", hash_original_method = "0D8BE47B4CC10913DB4ECAD1674E174D", hash_generated_method = "667F213CA83AB99077A2424BF50AA4B5")
    
static long getFrameTime() {
        return ValueAnimator.getFrameDelay();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:52:28.155 -0400", hash_original_method = "4F85A7DBE26C5D9F71383D656D0BAF22", hash_generated_method = "6CF3B8686C53C63511BB6521657B0134")
    
public static float getAlpha(View view) {
        return view.getAlpha();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:52:28.160 -0400", hash_original_method = "13C7B7D6BFB552836C47A79648A3D9CC", hash_generated_method = "0AE65DB0DFCC1B87C1481742525CAC13")
    
public static void setLayerType(View view, int layerType, Paint paint) {
        view.setLayerType(layerType, paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:52:28.165 -0400", hash_original_method = "9B1C9F40C8B385E85FFD5E213EC50BE6", hash_generated_method = "64BD64267E48FAE833EF6BD6C412CE29")
    
public static int getLayerType(View view) {
        return view.getLayerType();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:52:28.171 -0400", hash_original_method = "0659225423D7C478FE12329F89589661", hash_generated_method = "01F49F8976435895433A3B75F35A21BA")
    
public static int resolveSizeAndState(int size, int measureSpec, int childMeasuredState) {
        return View.resolveSizeAndState(size, measureSpec, childMeasuredState);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:52:28.175 -0400", hash_original_method = "EE66E36CFC7F3CED3374D5640A0C4372", hash_generated_method = "DBADDC59F0A5EF22951A6EFB948F1047")
    
public static int getMeasuredWidthAndState(View view) {
        return view.getMeasuredWidthAndState();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:52:28.179 -0400", hash_original_method = "2C7586AF371139F1301FBCF8DD0EDD25", hash_generated_method = "B3E66BD4EB91F320B89106F6FFFFA87F")
    
public static int getMeasuredHeightAndState(View view) {
        return view.getMeasuredHeightAndState();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:52:28.184 -0400", hash_original_method = "8441914CD5B1182AA9498A8EE0E68C6A", hash_generated_method = "66DE86F95F6859F3C096757411E14C1F")
    
public static int getMeasuredState(View view) {
        return view.getMeasuredState();
    }
}
