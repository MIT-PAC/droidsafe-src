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
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

/**
 * Helper for accessing features in {@link android.app.ActivityOptions}
 * introduced in API level 16 in a backwards compatible fashion.
 */
public class ActivityOptionsCompat {
    /**
     * Create an ActivityOptions specifying a custom animation to run when the
     * activity is displayed.
     *
     * @param context Who is defining this. This is the application that the
     * animation resources will be loaded from.
     * @param enterResId A resource ID of the animation resource to use for the
     * incoming activity. Use 0 for no animation.
     * @param exitResId A resource ID of the animation resource to use for the
     * outgoing activity. Use 0 for no animation.
     * @return Returns a new ActivityOptions object that you can use to supply
     * these options as the options Bundle when starting an activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:54.606 -0400", hash_original_method = "FD2BA800170C8DC42E379DABFFB5EFE5", hash_generated_method = "B239975B85A9B21DC60FCDFB76323183")
    
public static ActivityOptionsCompat makeCustomAnimation(Context context,
            int enterResId, int exitResId) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new ActivityOptionsImplJB(
                ActivityOptionsCompatJB.makeCustomAnimation(context, enterResId, exitResId));
        }
        return new ActivityOptionsCompat();
    }

    /**
     * Create an ActivityOptions specifying an animation where the new activity is
     * scaled from a small originating area of the screen to its final full
     * representation.
     * <p/>
     * If the Intent this is being used with has not set its
     * {@link android.content.Intent#setSourceBounds(android.graphics.Rect)},
     * those bounds will be filled in for you based on the initial bounds passed
     * in here.
     *
     * @param source The View that the new activity is animating from. This
     * defines the coordinate space for startX and startY.
     * @param startX The x starting location of the new activity, relative to
     * source.
     * @param startY The y starting location of the activity, relative to source.
     * @param startWidth The initial width of the new activity.
     * @param startHeight The initial height of the new activity.
     * @return Returns a new ActivityOptions object that you can use to supply
     * these options as the options Bundle when starting an activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:54.613 -0400", hash_original_method = "1D4A610DE4F5181569866CF445B26750", hash_generated_method = "9B01E4EE18D9AA5C116ACE37BA61AD55")
    
public static ActivityOptionsCompat makeScaleUpAnimation(View source,
            int startX, int startY, int startWidth, int startHeight) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new ActivityOptionsImplJB(
                ActivityOptionsCompatJB.makeScaleUpAnimation(source, startX, startY,
                        startWidth, startHeight));
        }
        return new ActivityOptionsCompat();
    }

    /**
     * Create an ActivityOptions specifying an animation where a thumbnail is
     * scaled from a given position to the new activity window that is being
     * started.
     * <p/>
     * If the Intent this is being used with has not set its
     * {@link android.content.Intent#setSourceBounds(android.graphics.Rect)},
     * those bounds will be filled in for you based on the initial thumbnail
     * location and size provided here.
     *
     * @param source The View that this thumbnail is animating from. This
     * defines the coordinate space for startX and startY.
     * @param thumbnail The bitmap that will be shown as the initial thumbnail
     * of the animation.
     * @param startX The x starting location of the bitmap, relative to source.
     * @param startY The y starting location of the bitmap, relative to source.
     * @return Returns a new ActivityOptions object that you can use to supply
     * these options as the options Bundle when starting an activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:54.620 -0400", hash_original_method = "FDC9AB05A831D56F23C43A2483DBEA1B", hash_generated_method = "2E45DA36707CDB57838F7C3B363EAC20")
    
public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View source,
            Bitmap thumbnail, int startX, int startY) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new ActivityOptionsImplJB(
                ActivityOptionsCompatJB.makeThumbnailScaleUpAnimation(source, thumbnail,
                        startX, startY));
        }
        return new ActivityOptionsCompat();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.127 -0500", hash_original_method = "C3D8A08DB57C7D5061C47B6764CF0D6D", hash_generated_method = "830C483BBC9EBC1A9B02D162E181CF3C")
    
protected ActivityOptionsCompat() {
    }

    /**
     * Returns the created options as a Bundle, which can be passed to
     * {@link ActivityCompat#startActivity(android.app.Activity, android.content.Intent, android.os.Bundle)}.
     * Note that the returned Bundle is still owned by the ActivityOptions
     * object; you must not modify it, but can supply it to the startActivity
     * methods that take an options Bundle.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.129 -0500", hash_original_method = "7E5B5BB9483DF7F31CD9182E0CD97C2F", hash_generated_method = "741CCC5416904FFD42E8D86880EBABC5")
    
public Bundle toBundle() {
        return null;
    }

    /**
     * Update the current values in this ActivityOptions from those supplied in
     * otherOptions. Any values defined in otherOptions replace those in the
     * base options.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.130 -0500", hash_original_method = "69B9528DEAFE31561943A8DC3715279B", hash_generated_method = "BC7B357D9E620F5DEFDC6E84EF87CBBB")
    
public void update(ActivityOptionsCompat otherOptions) {
        // Do nothing.
    }




    private static class ActivityOptionsImplJB extends ActivityOptionsCompat {
        private final ActivityOptionsCompatJB mImpl;

        ActivityOptionsImplJB(ActivityOptionsCompatJB impl) {
            mImpl = impl;
        }

        @Override
        public Bundle toBundle() {
            return mImpl.toBundle();
        }

        @Override
        public void update(ActivityOptionsCompat otherOptions) {
            if (otherOptions instanceof ActivityOptionsImplJB) {
                ActivityOptionsImplJB otherImpl = (ActivityOptionsImplJB)otherOptions;
                mImpl.update(otherImpl.mImpl);
            }
        }
    }}
