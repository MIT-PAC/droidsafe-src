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
 * Copyright (C) 2010 The Android Open Source Project
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


package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

import com.android.internal.R;

public class EdgeEffect {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.749 -0500", hash_original_field = "158AF8AF1166347DE99E49344EB0783D", hash_generated_field = "8318DED0E83CE770D47711FAEB77E6C5")

    private static final String TAG = "EdgeEffect";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.752 -0500", hash_original_field = "13EC5606422A0E12909E4F45DF95DBE0", hash_generated_field = "95C02B4A0287FA86ED46A69803A79218")

    private static final int RECEDE_TIME = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.755 -0500", hash_original_field = "FDEE85672940A4C6FAEA40D5A521410C", hash_generated_field = "2C74B79C1183F7DEC78751B83468CF0D")

    private static final int PULL_TIME = 167;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.757 -0500", hash_original_field = "877FD9AFF0D32D64D685D8E1F1DC5FDC", hash_generated_field = "81B49A12E85960788C5F8AE3D82C58C7")

    private static final int PULL_DECAY_TIME = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.759 -0500", hash_original_field = "CD69B044F116F40C3C74A14F1C6FC67A", hash_generated_field = "3C3930C5D92B8510AC36599132967614")

    private static final float MAX_ALPHA = 0.8f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.762 -0500", hash_original_field = "0A02DA569AA0ADB326931EA2F4727554", hash_generated_field = "A5BCE2D319734849C17A12366D047EEB")

    private static final float HELD_EDGE_ALPHA = 0.7f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.765 -0500", hash_original_field = "609937908BF8A1447428753AEE67B4AC", hash_generated_field = "2BA8155A958133E13ED73727484A3B84")

    private static final float HELD_EDGE_SCALE_Y = 0.5f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.767 -0500", hash_original_field = "BC696CF0E4A69D37D7AB1CE8CAC149D6", hash_generated_field = "5C108BBD047E80601904156DEEC9474E")

    private static final float HELD_GLOW_ALPHA = 0.5f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.769 -0500", hash_original_field = "077A60D5FE76A0E7C30333C714C6C1FC", hash_generated_field = "DDDF9F3A6A2AC28769770EC81801836E")

    private static final float HELD_GLOW_SCALE_Y = 0.5f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.772 -0500", hash_original_field = "0A66F7F75CCFB9CE729DC3FEB904C6D3", hash_generated_field = "1FC6FD4875548D3C97E25AB46C8876F8")

    private static final float MAX_GLOW_HEIGHT = 4.f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.774 -0500", hash_original_field = "6455246E26AE2BF61B54BC9E3E1BF855", hash_generated_field = "1852B514A0F172C1A0C0CE468D21AE38")

    private static final float PULL_GLOW_BEGIN = 1.f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.776 -0500", hash_original_field = "EBCAA574C48D1FF61D2717FB9EDD9A8C", hash_generated_field = "E4D812693FB853EEE256AA78FA1B8DFD")

    private static final float PULL_EDGE_BEGIN = 0.6f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.779 -0500", hash_original_field = "480426226B1797CB8905E08538BDDBB6", hash_generated_field = "27AA9B07C11177BE51EB8E22C1C62F5F")

    private static final int MIN_VELOCITY = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.781 -0500", hash_original_field = "349E379FB9B63E15950AC3D1E6C0557D", hash_generated_field = "BFA53C88BB1CB77A0739A8F00482034F")

    private static final float EPSILON = 0.001f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.828 -0500", hash_original_field = "E39B828D2E7A099E9F830BC3FBD507AA", hash_generated_field = "31A5ECBA709672BB7BAE010B1E1C3954")

    private static final int STATE_IDLE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.831 -0500", hash_original_field = "3B661E83BEC8CD9FEB57748873C569A5", hash_generated_field = "77FEF176BBE43E2F8960B9784C71E6B0")

    private static final int STATE_PULL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.833 -0500", hash_original_field = "F4AC61807A42244B7B7C6EAB19C94DC9", hash_generated_field = "85CD668DE159DB3B274284B977F86D18")

    private static final int STATE_ABSORB = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.835 -0500", hash_original_field = "08471C565C3A59F8ED0DAC1AD3503EDE", hash_generated_field = "D1EC2E1A815D35A15D574DAE68E4CC43")

    private static final int STATE_RECEDE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.837 -0500", hash_original_field = "AF03E148891A5D3CC870CB90FAFDAB69", hash_generated_field = "375C652B2C4D3ADE1445E8DECCE71CB9")

    private static final int STATE_PULL_DECAY = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.841 -0500", hash_original_field = "8FBFF7A68E6EC3B868EE33F83068E4C5", hash_generated_field = "4D44C12DA0976B463DF0805C53308E46")

    // Number determined by user testing.
    private static final int PULL_DISTANCE_EDGE_FACTOR = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.843 -0500", hash_original_field = "4564F070719F139313C2A0DADA7C14E5", hash_generated_field = "7DDAFD6497D9ED413FE328FAD2CD82D1")

    // Number determined by user testing.
    private static final int PULL_DISTANCE_GLOW_FACTOR = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.846 -0500", hash_original_field = "449B7F47D8F469EE428D2BF00EE236EE", hash_generated_field = "CF0135F44D863650817E434094F22930")

    private static final float PULL_DISTANCE_ALPHA_GLOW_FACTOR = 1.1f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.848 -0500", hash_original_field = "FB61E704B8B09B74208051D3F62684EB", hash_generated_field = "A935EB5BD34095A1331297B18BCECC07")

    private static final int VELOCITY_EDGE_FACTOR = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.850 -0500", hash_original_field = "A2A1F5037EA66B79E77DAD4B72BE3C7A", hash_generated_field = "F5DD8A210B2F110796FE117CF4CEAC48")

    private static final int VELOCITY_GLOW_FACTOR = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.783 -0500", hash_original_field = "31703B85965524E8276FFB5971ABD229", hash_generated_field = "05964103E2640D266736C21291ED963A")

    private  Drawable mEdge;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.785 -0500", hash_original_field = "DF20E5F38FAD117C96C6D421A3B7424C", hash_generated_field = "D018733BFF00E669B84A6D8AFEEDCF48")

    private  Drawable mGlow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.787 -0500", hash_original_field = "AF6410B200BC05DCA2CF0BE65165448A", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

    private int mWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.789 -0500", hash_original_field = "7DDAE255893B528E7BEBEC203BC2D9F3", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

    private int mHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.791 -0500", hash_original_field = "5F6F3682E5C3E9AD88727B7BAF5AAB79", hash_generated_field = "CA4554880F5BBA33C228166752942684")

    private final int MIN_WIDTH = 300;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.793 -0500", hash_original_field = "B5D566AA92521F570066E8773A24B0C0", hash_generated_field = "ED0C6BF081117F2A257C521DB4125AB9")

    private  int mMinWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.796 -0500", hash_original_field = "807B0EB36B94F1F864EF8A8657219589", hash_generated_field = "C9E57FA99AB49068A8F6E92401E4EDF8")

    private float mEdgeAlpha;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.799 -0500", hash_original_field = "2A5CF131E16CDB77173A3C74E2859088", hash_generated_field = "CC58105158D79453C497FDAC69A3CBDA")

    private float mEdgeScaleY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.801 -0500", hash_original_field = "C79682CACD993D25D25885634CDC2FAF", hash_generated_field = "DB067BCEF357200891D3577E65E9378E")

    private float mGlowAlpha;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.803 -0500", hash_original_field = "9313B5B02F3808CD5EBFF6CECC69DA52", hash_generated_field = "9705800BBC7D1D409097697AD04EEC0A")

    private float mGlowScaleY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.805 -0500", hash_original_field = "FB1077AC92024BEB040861020FA54705", hash_generated_field = "E42FD5C4BF05C06F1FE157CC7F60650B")

    private float mEdgeAlphaStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.807 -0500", hash_original_field = "0BF5EE39A0DD1FDA43BA90DBEAAD1768", hash_generated_field = "C1F5208E06DFC4F14F94A109222A8734")

    private float mEdgeAlphaFinish;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.809 -0500", hash_original_field = "1C3A0E5AACBC7177178747AFEC890BA2", hash_generated_field = "B1F8C79BFDAA0E6EB028DAC9F61BA8F3")

    private float mEdgeScaleYStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.811 -0500", hash_original_field = "CC80CCB5A3D3455B7D8A4A0D1C2C60E6", hash_generated_field = "02463AD75A569C6736255765B3F5D721")

    private float mEdgeScaleYFinish;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.813 -0500", hash_original_field = "B7DF58B385128895A570A8C276BEDCFE", hash_generated_field = "04753334CFB95BA993CA564E84E8DBBE")

    private float mGlowAlphaStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.815 -0500", hash_original_field = "C6B629F700EF4EA75CC51C8FE6674D20", hash_generated_field = "6B5717F153A0936F85E0BE336A54E8EC")

    private float mGlowAlphaFinish;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.817 -0500", hash_original_field = "3D5CF9CADEB83B282EC285F926492A79", hash_generated_field = "DCE1D0531C3FB7E23F3B6E495CCBDE48")

    private float mGlowScaleYStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.820 -0500", hash_original_field = "D909D547813DD4273684E245BCA4FC03", hash_generated_field = "A8A7CF5496D086FD30B1B3B4160D004D")

    private float mGlowScaleYFinish;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.822 -0500", hash_original_field = "3C3A30DDD94D9D47CBB52C3848791CE7", hash_generated_field = "20EEDA67D8E4F20D3E4CA3D911CCA492")

    private long mStartTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.824 -0500", hash_original_field = "5FE68E6696B6FECEA2CEEBC34689D580", hash_generated_field = "E74108ED786047D2751EA97FD8595181")

    private float mDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.826 -0500", hash_original_field = "A1326AE9004157E0812422F0F20CD6F9", hash_generated_field = "67BF1E9EFEC019D28BF77934CF035B72")

    private  Interpolator mInterpolator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.853 -0500", hash_original_field = "C29396A3DA71C74DDF66E5C9D8EE9E1B", hash_generated_field = "445CA88308987469683043EF45117C11")

    private int mState = STATE_IDLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.855 -0500", hash_original_field = "359EB3C7F7F03F28C5116C3A22795F0F", hash_generated_field = "E175867FE0E063DCFFB7A99C55784D6E")

    private float mPullDistance;

    /**
     * Construct a new EdgeEffect with a theme appropriate for the provided context.
     * @param context Context used to provide theming and resource information for the EdgeEffect
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.857 -0500", hash_original_method = "AC508E1EC1805645807F80E8793DDCA5", hash_generated_method = "61AE4AD3CB08912ADE9B987299285E5F")
    
public EdgeEffect(Context context) {
        final Resources res = context.getResources();
        mEdge = res.getDrawable(R.drawable.overscroll_edge);
        mGlow = res.getDrawable(R.drawable.overscroll_glow);

        mMinWidth = (int) (res.getDisplayMetrics().density * MIN_WIDTH + 0.5f);
        mInterpolator = new DecelerateInterpolator();
    }

    /**
     * Set the size of this edge effect in pixels.
     *
     * @param width Effect width in pixels
     * @param height Effect height in pixels
     */
    @DSComment("GUI/Edge Effect, check callbacks")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.859 -0500", hash_original_method = "2560E21D822EB58266D32B5FBCFCA888", hash_generated_method = "BEDF188A0EC8BD748C2219CB14E1DFDF")
    
public void setSize(int width, int height) {
        mWidth = width;
        mHeight = height;
    }

    /**
     * Reports if this EdgeEffect's animation is finished. If this method returns false
     * after a call to {@link #draw(Canvas)} the host widget should schedule another
     * drawing pass to continue the animation.
     *
     * @return true if animation is finished, false if drawing should continue on the next frame.
     */
    @DSComment("GUI/Edge Effect, check callbacks")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.861 -0500", hash_original_method = "C5415C2330467D0B97062A48ADF90DEB", hash_generated_method = "114CE06FA1A6DC1537798C7A13F64722")
    
public boolean isFinished() {
        return mState == STATE_IDLE;
    }

    /**
     * Immediately finish the current animation.
     * After this call {@link #isFinished()} will return true.
     */
    @DSComment("GUI/Edge Effect, check callbacks")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.864 -0500", hash_original_method = "27AC7ECC3801AAB2943059507B28FB49", hash_generated_method = "7F04C80BAE41F6AE1FE1D9AE7B6B6EBB")
    
public void finish() {
        mState = STATE_IDLE;
    }

    /**
     * A view should call this when content is pulled away from an edge by the user.
     * This will update the state of the current visual effect and its associated animation.
     * The host view should always {@link android.view.View#invalidate()} after this
     * and draw the results accordingly.
     *
     * @param deltaDistance Change in distance since the last call. Values may be 0 (no change) to
     *                      1.f (full length of the view) or negative values to express change
     *                      back toward the edge reached to initiate the effect.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.866 -0500", hash_original_method = "0B34B4327835671A51286147399AA2A4", hash_generated_method = "5D31D945DD0AEF2B864525B6E78BBE25")
    
public void onPull(float deltaDistance) {
        final long now = AnimationUtils.currentAnimationTimeMillis();
        if (mState == STATE_PULL_DECAY && now - mStartTime < mDuration) {
            return;
        }
        if (mState != STATE_PULL) {
            mGlowScaleY = PULL_GLOW_BEGIN;
        }
        mState = STATE_PULL;

        mStartTime = now;
        mDuration = PULL_TIME;

        mPullDistance += deltaDistance;
        float distance = Math.abs(mPullDistance);

        mEdgeAlpha = mEdgeAlphaStart = Math.max(PULL_EDGE_BEGIN, Math.min(distance, MAX_ALPHA));
        mEdgeScaleY = mEdgeScaleYStart = Math.max(
                HELD_EDGE_SCALE_Y, Math.min(distance * PULL_DISTANCE_EDGE_FACTOR, 1.f));

        mGlowAlpha = mGlowAlphaStart = Math.min(MAX_ALPHA,
                mGlowAlpha +
                (Math.abs(deltaDistance) * PULL_DISTANCE_ALPHA_GLOW_FACTOR));

        float glowChange = Math.abs(deltaDistance);
        if (deltaDistance > 0 && mPullDistance < 0) {
            glowChange = -glowChange;
        }
        if (mPullDistance == 0) {
            mGlowScaleY = 0;
        }

        // Do not allow glow to get larger than MAX_GLOW_HEIGHT.
        mGlowScaleY = mGlowScaleYStart = Math.min(MAX_GLOW_HEIGHT, Math.max(
                0, mGlowScaleY + glowChange * PULL_DISTANCE_GLOW_FACTOR));

        mEdgeAlphaFinish = mEdgeAlpha;
        mEdgeScaleYFinish = mEdgeScaleY;
        mGlowAlphaFinish = mGlowAlpha;
        mGlowScaleYFinish = mGlowScaleY;
    }

    /**
     * Call when the object is released after being pulled.
     * This will begin the "decay" phase of the effect. After calling this method
     * the host view should {@link android.view.View#invalidate()} and thereby
     * draw the results accordingly.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.869 -0500", hash_original_method = "130A4176B67F340D0300F29A870A39F7", hash_generated_method = "E7BEAE81590D8C94B507483B16FBAA57")
    
public void onRelease() {
        mPullDistance = 0;

        if (mState != STATE_PULL && mState != STATE_PULL_DECAY) {
            return;
        }

        mState = STATE_RECEDE;
        mEdgeAlphaStart = mEdgeAlpha;
        mEdgeScaleYStart = mEdgeScaleY;
        mGlowAlphaStart = mGlowAlpha;
        mGlowScaleYStart = mGlowScaleY;

        mEdgeAlphaFinish = 0.f;
        mEdgeScaleYFinish = 0.f;
        mGlowAlphaFinish = 0.f;
        mGlowScaleYFinish = 0.f;

        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mDuration = RECEDE_TIME;
    }

    /**
     * Call when the effect absorbs an impact at the given velocity.
     * Used when a fling reaches the scroll boundary.
     *
     * <p>When using a {@link android.widget.Scroller} or {@link android.widget.OverScroller},
     * the method <code>getCurrVelocity</code> will provide a reasonable approximation
     * to use here.</p>
     *
     * @param velocity Velocity at impact in pixels per second.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.873 -0500", hash_original_method = "1D958DC13C828E6D4B8059ABA730E95F", hash_generated_method = "CD00A01465198F58694392BDD8D9862E")
    
public void onAbsorb(int velocity) {
        mState = STATE_ABSORB;
        velocity = Math.max(MIN_VELOCITY, Math.abs(velocity));

        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mDuration = 0.1f + (velocity * 0.03f);

        // The edge should always be at least partially visible, regardless
        // of velocity.
        mEdgeAlphaStart = 0.f;
        mEdgeScaleY = mEdgeScaleYStart = 0.f;
        // The glow depends more on the velocity, and therefore starts out
        // nearly invisible.
        mGlowAlphaStart = 0.5f;
        mGlowScaleYStart = 0.f;

        // Factor the velocity by 8. Testing on device shows this works best to
        // reflect the strength of the user's scrolling.
        mEdgeAlphaFinish = Math.max(0, Math.min(velocity * VELOCITY_EDGE_FACTOR, 1));
        // Edge should never get larger than the size of its asset.
        mEdgeScaleYFinish = Math.max(
                HELD_EDGE_SCALE_Y, Math.min(velocity * VELOCITY_EDGE_FACTOR, 1.f));

        // Growth for the size of the glow should be quadratic to properly
        // respond
        // to a user's scrolling speed. The faster the scrolling speed, the more
        // intense the effect should be for both the size and the saturation.
        mGlowScaleYFinish = Math.min(0.025f + (velocity * (velocity / 100) * 0.00015f), 1.75f);
        // Alpha should change for the glow as well as size.
        mGlowAlphaFinish = Math.max(
                mGlowAlphaStart, Math.min(velocity * VELOCITY_GLOW_FACTOR * .00001f, MAX_ALPHA));
    }

    /**
     * Draw into the provided canvas. Assumes that the canvas has been rotated
     * accordingly and the size has been set. The effect will be drawn the full
     * width of X=0 to X=width, beginning from Y=0 and extending to some factor <
     * 1.f of height.
     *
     * @param canvas Canvas to draw into
     * @return true if drawing should continue beyond this frame to continue the
     *         animation
     */
    @DSComment("GUI/Edge Effect, check callbacks")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.876 -0500", hash_original_method = "610B6E206A511890E944EC9E15AA39A0", hash_generated_method = "1EDED50610952764ADA2095B62231960")
    
public boolean draw(Canvas canvas) {
        update();

        final int edgeHeight = mEdge.getIntrinsicHeight();
        final int edgeWidth = mEdge.getIntrinsicWidth();
        final int glowHeight = mGlow.getIntrinsicHeight();
        final int glowWidth = mGlow.getIntrinsicWidth();

        mGlow.setAlpha((int) (Math.max(0, Math.min(mGlowAlpha, 1)) * 255));

        int glowBottom = (int) Math.min(
                glowHeight * mGlowScaleY * glowHeight/ glowWidth * 0.6f,
                glowHeight * MAX_GLOW_HEIGHT);
        if (mWidth < mMinWidth) {
            // Center the glow and clip it.
            int glowLeft = (mWidth - mMinWidth)/2;
            mGlow.setBounds(glowLeft, 0, mWidth - glowLeft, glowBottom);
        } else {
            // Stretch the glow to fit.
            mGlow.setBounds(0, 0, mWidth, glowBottom);
        }

        mGlow.draw(canvas);

        mEdge.setAlpha((int) (Math.max(0, Math.min(mEdgeAlpha, 1)) * 255));

        int edgeBottom = (int) (edgeHeight * mEdgeScaleY);
        if (mWidth < mMinWidth) {
            // Center the edge and clip it.
            int edgeLeft = (mWidth - mMinWidth)/2;
            mEdge.setBounds(edgeLeft, 0, mWidth - edgeLeft, edgeBottom);
        } else {
            // Stretch the edge to fit.
            mEdge.setBounds(0, 0, mWidth, edgeBottom);
        }
        mEdge.draw(canvas);

        return mState != STATE_IDLE;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.879 -0500", hash_original_method = "217F98194ACCE474266C15D1EE978E29", hash_generated_method = "FCC2C3FBF942F3A242F19781D96BDFAE")
    
private void update() {
        final long time = AnimationUtils.currentAnimationTimeMillis();
        final float t = Math.min((time - mStartTime) / mDuration, 1.f);

        final float interp = mInterpolator.getInterpolation(t);

        mEdgeAlpha = mEdgeAlphaStart + (mEdgeAlphaFinish - mEdgeAlphaStart) * interp;
        mEdgeScaleY = mEdgeScaleYStart + (mEdgeScaleYFinish - mEdgeScaleYStart) * interp;
        mGlowAlpha = mGlowAlphaStart + (mGlowAlphaFinish - mGlowAlphaStart) * interp;
        mGlowScaleY = mGlowScaleYStart + (mGlowScaleYFinish - mGlowScaleYStart) * interp;

        if (t >= 1.f - EPSILON) {
            switch (mState) {
                case STATE_ABSORB:
                    mState = STATE_RECEDE;
                    mStartTime = AnimationUtils.currentAnimationTimeMillis();
                    mDuration = RECEDE_TIME;

                    mEdgeAlphaStart = mEdgeAlpha;
                    mEdgeScaleYStart = mEdgeScaleY;
                    mGlowAlphaStart = mGlowAlpha;
                    mGlowScaleYStart = mGlowScaleY;

                    // After absorb, the glow and edge should fade to nothing.
                    mEdgeAlphaFinish = 0.f;
                    mEdgeScaleYFinish = 0.f;
                    mGlowAlphaFinish = 0.f;
                    mGlowScaleYFinish = 0.f;
                    break;
                case STATE_PULL:
                    mState = STATE_PULL_DECAY;
                    mStartTime = AnimationUtils.currentAnimationTimeMillis();
                    mDuration = PULL_DECAY_TIME;

                    mEdgeAlphaStart = mEdgeAlpha;
                    mEdgeScaleYStart = mEdgeScaleY;
                    mGlowAlphaStart = mGlowAlpha;
                    mGlowScaleYStart = mGlowScaleY;

                    // After pull, the glow and edge should fade to nothing.
                    mEdgeAlphaFinish = 0.f;
                    mEdgeScaleYFinish = 0.f;
                    mGlowAlphaFinish = 0.f;
                    mGlowScaleYFinish = 0.f;
                    break;
                case STATE_PULL_DECAY:
                    // When receding, we want edge to decrease more slowly
                    // than the glow.
                    float factor = mGlowScaleYFinish != 0 ? 1
                            / (mGlowScaleYFinish * mGlowScaleYFinish)
                            : Float.MAX_VALUE;
                    mEdgeScaleY = mEdgeScaleYStart +
                        (mEdgeScaleYFinish - mEdgeScaleYStart) *
                            interp * factor;
                    mState = STATE_RECEDE;
                    break;
                case STATE_RECEDE:
                    mState = STATE_IDLE;
                    break;
            }
        }
    }
}

