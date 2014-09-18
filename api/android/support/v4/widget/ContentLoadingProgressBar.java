/*
 * Copyright (C) 2013 The Android Open Source Project
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

package android.support.v4.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;

/**
 * ContentLoadingProgressBar implements a ProgressBar that waits a minimum time to be
 * dismissed before showing. Once visible, the progress bar will be visible for
 * a minimum amount of time to avoid "flashes" in the UI when an event could take
 * a largely variable time to complete (from none, to a user perceivable amount)
 */
public class ContentLoadingProgressBar extends ProgressBar {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:05.793 -0400", hash_original_field = "CEFFA668112F5FC3E1BF69DB6BF70CDC", hash_generated_field = "B15D2C89EF8F8CD47C6ED256EEE91295")

    private static final int MIN_SHOW_TIME = 500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:05.798 -0400", hash_original_field = "FEE4615B11015898CAD8431AAA82B379", hash_generated_field = "08BB5C444B1F49815400A58C2791DC82")

    private static final int MIN_DELAY = 500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:05.802 -0400", hash_original_field = "81105A88481A5B0AE717E10F26F868BC", hash_generated_field = "970AC890D67E1C272DF3C10F230D5582")


    private long mStartTime = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:05.807 -0400", hash_original_field = "5E7613B38EFEBB47552A29F8E71FE257", hash_generated_field = "4212A47838A37BBCAAF9B76B25E028CF")


    private boolean mPostedHide = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:05.811 -0400", hash_original_field = "6F81CA6EE3D78F8B5044427CDC459927", hash_generated_field = "DB7D8559EE5DA03DA6274A12FA54583A")


    private boolean mPostedShow = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:05.816 -0400", hash_original_field = "D84AA843E49022C0E9B230872C5207F8", hash_generated_field = "A227EE2BA99DCE691AA725EEF77E8617")


    private boolean mDismissed = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:05.827 -0400", hash_original_field = "4F57D219B21F683CEC29B094213DB200", hash_generated_field = "707A15CAFF0FCB14D243A5F09F5C4AA0")


    private final Runnable mDelayedHide = new Runnable() {

        @Override
        public void run() {
            mPostedHide = false;
            mStartTime = -1;
            setVisibility(View.GONE);
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:05.839 -0400", hash_original_field = "36884D4DB8B62CD9AF72AFDA3FBF3265", hash_generated_field = "4CBE6A06F8939BEDC0E177F08BCFE4BA")


    private final Runnable mDelayedShow = new Runnable() {

        @Override
        public void run() {
            mPostedShow = false;
            if (!mDismissed) {
                mStartTime = System.currentTimeMillis();
                setVisibility(View.VISIBLE);
            }
        }
    };

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:05.844 -0400", hash_original_method = "5C207E5A62FFD98775403E0B58651AFA", hash_generated_method = "F6D6A1EEA746E273E4095E24963970E7")
    
public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:05.849 -0400", hash_original_method = "8028FF765DA133E05688A1529AC58708", hash_generated_method = "48BD27FF8A765F0E7938D76EA7BEBA11")
    
public ContentLoadingProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:05.853 -0400", hash_original_method = "BFA37626495F213AB51599ADC140C8A0", hash_generated_method = "F971A20C10EB62E4A2437F56D124AF57")
    
@Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:05.858 -0400", hash_original_method = "4D4F7A98F5C749CC5985026A9C640937", hash_generated_method = "1176B3787C91B38A7859D751B705CCFF")
    
@Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:05.862 -0400", hash_original_method = "AA45B58F5CAB43E559C6EFEE60BD4E7B", hash_generated_method = "D3D02CD49CAACEDFF42B45AD3CE911E3")
    
private void removeCallbacks() {
        removeCallbacks(mDelayedHide);
        removeCallbacks(mDelayedShow);
    }

    /**
     * Hide the progress view if it is visible. The progress view will not be
     * hidden until it has been shown for at least a minimum show time. If the
     * progress view was not yet visible, cancels showing the progress view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:05.867 -0400", hash_original_method = "7B87EB758D2E1E15E358062221E5691B", hash_generated_method = "9A81A7AF4AF0283C87E613C6120CCAF0")
    
public void hide() {
        mDismissed = true;
        removeCallbacks(mDelayedShow);
        long diff = System.currentTimeMillis() - mStartTime;
        if (diff >= MIN_SHOW_TIME || mStartTime == -1) {
            // The progress spinner has been shown long enough
            // OR was not shown yet. If it wasn't shown yet,
            // it will just never be shown.
            setVisibility(View.GONE);
        } else {
            // The progress spinner is shown, but not long enough,
            // so put a delayed message in to hide it when its been
            // shown long enough.
            if (!mPostedHide) {
                postDelayed(mDelayedHide, MIN_SHOW_TIME - diff);
                mPostedHide = true;
            }
        }
    }

    /**
     * Show the progress view after waiting for a minimum delay. If
     * during that time, hide() is called, the view is never made visible.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:05.873 -0400", hash_original_method = "50343ACEF9E590EE2CAFFA9DABE84DB9", hash_generated_method = "F07D312F05DCAA69887E3DED05ED497F")
    
public void show() {
        // Reset the start time.
        mStartTime = -1;
        mDismissed = false;
        removeCallbacks(mDelayedHide);
        if (!mPostedShow) {
            postDelayed(mDelayedShow, MIN_DELAY);
            mPostedShow = true;
        }
    }
}
