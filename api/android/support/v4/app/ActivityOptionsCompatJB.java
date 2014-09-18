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
import android.app.ActivityOptions;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

class ActivityOptionsCompatJB {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:54.747 -0400", hash_original_method = "8C2B5B0E653131C7FE29B8F4DEF92DAB", hash_generated_method = "F3209A1F4D924B8ACF94D290A02F1E07")
    
public static ActivityOptionsCompatJB makeCustomAnimation(Context context,
            int enterResId, int exitResId) {
        return new ActivityOptionsCompatJB(
            ActivityOptions.makeCustomAnimation(context, enterResId, exitResId));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:54.754 -0400", hash_original_method = "BC32BF2FDA6BA5634CADA56FE4D5FC74", hash_generated_method = "A1650C87EF7CDE50451C4D646334ABDB")
    
public static ActivityOptionsCompatJB makeScaleUpAnimation(View source,
            int startX, int startY, int startWidth, int startHeight) {
        return new ActivityOptionsCompatJB(
            ActivityOptions.makeScaleUpAnimation(source, startX, startY, startWidth, startHeight));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:54.762 -0400", hash_original_method = "EE3E76A0193832B3C4EDDFCAA15660A2", hash_generated_method = "BFCCFE3A8EE14B70F8A116C6204B3C6D")
    
public static ActivityOptionsCompatJB makeThumbnailScaleUpAnimation(View source,
            Bitmap thumbnail, int startX, int startY) {
        return new ActivityOptionsCompatJB(
            ActivityOptions.makeThumbnailScaleUpAnimation(source, thumbnail, startX, startY));
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:54.768 -0400", hash_original_field = "FFAEF3F006D0EBB48F9FD1C68E6D08BD", hash_generated_field = "05631F4CD6557D70E151BAD9309B752C")


    private  ActivityOptions mActivityOptions;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:54.773 -0400", hash_original_method = "B9CC2F3C64E31F3A7CDD57365D1E4BFA", hash_generated_method = "1C8C50EBA6E58C67DDD216BF0DB26E3E")
    
private ActivityOptionsCompatJB(ActivityOptions activityOptions) {
        mActivityOptions = activityOptions;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:54.778 -0400", hash_original_method = "83F874A86B7C872C0375E1C46CC5E819", hash_generated_method = "CBC6DDC6A7A26D6366C3DF1482AF32F6")
    
public Bundle toBundle() {
        return mActivityOptions.toBundle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:54.784 -0400", hash_original_method = "02009E93BA3C57E3055A7F85B817ABAA", hash_generated_method = "291D86381B7E6B55A2AA4D1305B43345")
    
public void update(ActivityOptionsCompatJB otherOptions) {
        mActivityOptions.update(otherOptions.mActivityOptions);
    }
}
