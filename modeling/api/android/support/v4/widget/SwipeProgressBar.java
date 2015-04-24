/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.support.v4.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/**
 * Custom progress bar that shows a cycle of colors as widening circles that
 * overdraw each other. When finished, the bar is cleared from the inside out as
 * the main cycle continues. Before running, this can also indicate how close
 * the user is to triggering something (e.g. how far they need to pull down to
 * trigger a refresh).
 */
final class SwipeProgressBar {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.399 -0400", hash_original_field = "0B227B435F1E2E2E1C0243AD3BE2686B", hash_generated_field = "57CE3932502C49970948666E0491BFCA")

    private final static int COLOR1 = 0xB3000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.402 -0400", hash_original_field = "D83CE2C7FD90ACED6F70A140580F27CD", hash_generated_field = "EA7D0529466B32807C5653ED7601F55D")

    private final static int COLOR2 = 0x80000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.405 -0400", hash_original_field = "69AB2EDCC66900F26850F657EE0DF71B", hash_generated_field = "DCE9CED329DED7E8E363A4BCC6D84D0E")

    private final static int COLOR3 = 0x4d000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.408 -0400", hash_original_field = "85496A88268043F936266C8B7ADE8EAB", hash_generated_field = "A8D9E7A39D1DB0C8DB5369FFBCFE6488")

    private final static int COLOR4 = 0x1a000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.411 -0400", hash_original_field = "34A58C8E1CCF4F2FC68B17672A857813", hash_generated_field = "A44E12943B3A721F253FABCACDB57128")

    private static final int ANIMATION_DURATION_MS = 2000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.414 -0400", hash_original_field = "BCBAAD180C685DD8BC7D2F8F06D472B2", hash_generated_field = "F2B40996F5D7B51AF9CC20A095827D32")

    private static final int FINISH_ANIMATION_DURATION_MS = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.418 -0400", hash_original_field = "2102CA6236231F5D711425C739653B83", hash_generated_field = "A58D5D5005D6A049E87623E7F3DBAB79")

    private static final Interpolator INTERPOLATOR = BakedBezierInterpolator.getInstance();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.421 -0400", hash_original_field = "1D0586880E5CE88B4198E05E1760434E", hash_generated_field = "90B0608AB53F75A0AC388611FFB8AF86")

    private final Paint mPaint = new Paint();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.425 -0400", hash_original_field = "F92AFD9EDA36830E595BBAA6D099BED9", hash_generated_field = "56E1D5C7BA6E3BAC4C5A64E620BAA5F1")

    private final RectF mClipRect = new RectF();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.428 -0400", hash_original_field = "F9963863DC96BC6A8F5A6AFA9C76054E", hash_generated_field = "75D531FC21FD1F6D6587A3A7E551F686")

    private float mTriggerPercentage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.430 -0400", hash_original_field = "3C3A30DDD94D9D47CBB52C3848791CE7", hash_generated_field = "20EEDA67D8E4F20D3E4CA3D911CCA492")

    private long mStartTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.433 -0400", hash_original_field = "E9E260A3F8D6F9DBCD43C47378767CE0", hash_generated_field = "11A44EFE4ABB3E459310CE6B11FBD93E")

    private long mFinishTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.436 -0400", hash_original_field = "2573C0D70D240E9163F4E289C1920019", hash_generated_field = "E765B9874E0B1A54BCA423FC936F9647")

    private boolean mRunning;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.439 -0400", hash_original_field = "8BEB29A2F0D7BBED20D60D43DB5A1ED1", hash_generated_field = "6C83D16ED6A2BB87A5223CB4C84CD2F0")

    private int mColor1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.441 -0400", hash_original_field = "14DB6EAE89A6DE612252844FEF122A39", hash_generated_field = "4692D6D727F4C620B83F7082CCB3ECF1")

    private int mColor2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.444 -0400", hash_original_field = "48E4FA0FD8B06DD778CD2872A451742E", hash_generated_field = "BB40C044E3242B4F675ADCEC5C3B9772")

    private int mColor3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.447 -0400", hash_original_field = "372D8FBB6BAB01B745E53DCE47CC8831", hash_generated_field = "3FE3FF35B359A863961C18EE6BC9B8E1")

    private int mColor4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.450 -0400", hash_original_field = "E75BFC724C029B218F749A8F367E2F8A", hash_generated_field = "F390CEA2EB774A5E06CF41537787A55D")

    private View mParent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.453 -0400", hash_original_field = "811AC12DD4794990F0DFD3FA5A6E3596", hash_generated_field = "E67C945376AAE00DB9440E3399BD8397")

    private Rect mBounds = new Rect();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.456 -0400", hash_original_method = "806C8DF3C6CABC490E5F026062B91A07", hash_generated_method = "9EB0338E84F54877F53612FDEDB68F1B")
    
public SwipeProgressBar(View parent) {
        mParent = parent;
        mColor1 = COLOR1;
        mColor2 = COLOR2;
        mColor3 = COLOR3;
        mColor4 = COLOR4;
    }

    /**
     * Set the four colors used in the progress animation. The first color will
     * also be the color of the bar that grows in response to a user swipe
     * gesture.
     *
     * @param color1 Integer representation of a color.
     * @param color2 Integer representation of a color.
     * @param color3 Integer representation of a color.
     * @param color4 Integer representation of a color.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.459 -0400", hash_original_method = "7F9B609EC8FBA7C973EA0757F6AB93AD", hash_generated_method = "7F9B609EC8FBA7C973EA0757F6AB93AD")
    
void setColorScheme(int color1, int color2, int color3, int color4) {
        mColor1 = color1;
        mColor2 = color2;
        mColor3 = color3;
        mColor4 = color4;
    }

    /**
     * Update the progress the user has made toward triggering the swipe
     * gesture. and use this value to update the percentage of the trigger that
     * is shown.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.462 -0400", hash_original_method = "D1F759D4E358ACCBA9C55FF71495AA31", hash_generated_method = "D1F759D4E358ACCBA9C55FF71495AA31")
    
void setTriggerPercentage(float triggerPercentage) {
        mTriggerPercentage = triggerPercentage;
        mStartTime = 0;
        ViewCompat.postInvalidateOnAnimation(mParent);
    }

    /**
     * Start showing the progress animation.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.466 -0400", hash_original_method = "4E65DAFB1193371A1339F133EA2A54E6", hash_generated_method = "4E65DAFB1193371A1339F133EA2A54E6")
    
void start() {
        if (!mRunning) {
            mTriggerPercentage = 0;
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mRunning = true;
            mParent.postInvalidate();
        }
    }

    /**
     * Stop showing the progress animation.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.468 -0400", hash_original_method = "382ABFEB62D05869A6A7FF602B7E67FB", hash_generated_method = "382ABFEB62D05869A6A7FF602B7E67FB")
    
void stop() {
        if (mRunning) {
            mTriggerPercentage = 0;
            mFinishTime = AnimationUtils.currentAnimationTimeMillis();
            mRunning = false;
            mParent.postInvalidate();
        }
    }

    /**
     * @return Return whether the progress animation is currently running.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.471 -0400", hash_original_method = "7520422F7505AA4284191140FEA31808", hash_generated_method = "7520422F7505AA4284191140FEA31808")
    
boolean isRunning() {
        return mRunning || mFinishTime > 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.477 -0400", hash_original_method = "8EAF1C7A73C1CC16F7F125D01A70BA7D", hash_generated_method = "C0F519FF880D92EBE68A88FBB767DFBB")
    
void draw(Canvas canvas) {
        final int width = mBounds.width();
        final int height = mBounds.height();
        final int cx = width / 2;
        final int cy = height / 2;
        boolean drawTriggerWhileFinishing = false;
        int restoreCount = canvas.save();
        canvas.clipRect(mBounds);

        if (mRunning || (mFinishTime > 0)) {
            long now = AnimationUtils.currentAnimationTimeMillis();
            long elapsed = (now - mStartTime) % ANIMATION_DURATION_MS;
            long iterations = (now - mStartTime) / ANIMATION_DURATION_MS;
            float rawProgress = (elapsed / (ANIMATION_DURATION_MS / 100f));

            // If we're not running anymore, that means we're running through
            // the finish animation.
            if (!mRunning) {
                // If the finish animation is done, don't draw anything, and
                // don't repost.
                if ((now - mFinishTime) >= FINISH_ANIMATION_DURATION_MS) {
                    mFinishTime = 0;
                    return;
                }

                // Otherwise, use a 0 opacity alpha layer to clear the animation
                // from the inside out. This layer will prevent the circles from
                // drawing within its bounds.
                long finishElapsed = (now - mFinishTime) % FINISH_ANIMATION_DURATION_MS;
                float finishProgress = (finishElapsed / (FINISH_ANIMATION_DURATION_MS / 100f));
                float pct = (finishProgress / 100f);
                // Radius of the circle is half of the screen.
                float clearRadius = width / 2 * INTERPOLATOR.getInterpolation(pct);
                mClipRect.set(cx - clearRadius, 0, cx + clearRadius, height);
                canvas.saveLayerAlpha(mClipRect, 0, 0);
                // Only draw the trigger if there is a space in the center of
                // this refreshing view that needs to be filled in by the
                // trigger. If the progress view is just still animating, let it
                // continue animating.
                drawTriggerWhileFinishing = true;
            }

            // First fill in with the last color that would have finished drawing.
            if (iterations == 0) {
                canvas.drawColor(mColor1);
            } else {
                if (rawProgress >= 0 && rawProgress < 25) {
                    canvas.drawColor(mColor4);
                } else if (rawProgress >= 25 && rawProgress < 50) {
                    canvas.drawColor(mColor1);
                } else if (rawProgress >= 50 && rawProgress < 75) {
                    canvas.drawColor(mColor2);
                } else {
                    canvas.drawColor(mColor3);
                }
            }

            // Then draw up to 4 overlapping concentric circles of varying radii, based on how far
            // along we are in the cycle.
            // progress 0-50 draw mColor2
            // progress 25-75 draw mColor3
            // progress 50-100 draw mColor4
            // progress 75 (wrap to 25) draw mColor1
            if ((rawProgress >= 0 && rawProgress <= 25)) {
                float pct = (((rawProgress + 25) * 2) / 100f);
                drawCircle(canvas, cx, cy, mColor1, pct);
            }
            if (rawProgress >= 0 && rawProgress <= 50) {
                float pct = ((rawProgress * 2) / 100f);
                drawCircle(canvas, cx, cy, mColor2, pct);
            }
            if (rawProgress >= 25 && rawProgress <= 75) {
                float pct = (((rawProgress - 25) * 2) / 100f);
                drawCircle(canvas, cx, cy, mColor3, pct);
            }
            if (rawProgress >= 50 && rawProgress <= 100) {
                float pct = (((rawProgress - 50) * 2) / 100f);
                drawCircle(canvas, cx, cy, mColor4, pct);
            }
            if ((rawProgress >= 75 && rawProgress <= 100)) {
                float pct = (((rawProgress - 75) * 2) / 100f);
                drawCircle(canvas, cx, cy, mColor1, pct);
            }
            if (mTriggerPercentage > 0 && drawTriggerWhileFinishing) {
                // There is some portion of trigger to draw. Restore the canvas,
                // then draw the trigger. Otherwise, the trigger does not appear
                // until after the bar has finished animating and appears to
                // just jump in at a larger width than expected.
                canvas.restoreToCount(restoreCount);
                restoreCount = canvas.save();
                canvas.clipRect(mBounds);
                drawTrigger(canvas, cx, cy);
            }
            // Keep running until we finish out the last cycle.
            ViewCompat.postInvalidateOnAnimation(mParent);
        } else {
            // Otherwise if we're in the middle of a trigger, draw that.
            if (mTriggerPercentage > 0 && mTriggerPercentage <= 1.0) {
                drawTrigger(canvas, cx, cy);
            }
        }
        canvas.restoreToCount(restoreCount);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.481 -0400", hash_original_method = "E7A4B43D71942D4D63F7D4409B75393B", hash_generated_method = "5EE95540AB6F6884E4BB5C733AA4B456")
    
private void drawTrigger(Canvas canvas, int cx, int cy) {
        mPaint.setColor(mColor1);
        canvas.drawCircle(cx, cy, cx * mTriggerPercentage, mPaint);
    }

    /**
     * Draws a circle centered in the view.
     *
     * @param canvas the canvas to draw on
     * @param cx the center x coordinate
     * @param cy the center y coordinate
     * @param color the color to draw
     * @param pct the percentage of the view that the circle should cover
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.484 -0400", hash_original_method = "05B43A5154FC1BD8706BCB0054C3C22B", hash_generated_method = "BDA4934466CE005223F4C2717B6FF822")
    
private void drawCircle(Canvas canvas, float cx, float cy, int color, float pct) {
        mPaint.setColor(color);
        canvas.save();
        canvas.translate(cx, cy);
        float radiusScale = INTERPOLATOR.getInterpolation(pct);
        canvas.scale(radiusScale, radiusScale);
        canvas.drawCircle(0, 0, cx, mPaint);
        canvas.restore();
    }

    /**
     * Set the drawing bounds of this SwipeProgressBar.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.487 -0400", hash_original_method = "61EEE649318014BFB8B1AEC725088AB4", hash_generated_method = "61EEE649318014BFB8B1AEC725088AB4")
    
void setBounds(int left, int top, int right, int bottom) {
        mBounds.left = left;
        mBounds.top = top;
        mBounds.right = right;
        mBounds.bottom = bottom;
    }
}
