package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class EdgeEffect {
    private Drawable mEdge;
    private Drawable mGlow;
    private int mWidth;
    private int mHeight;
    private int MIN_WIDTH = 300;
    private int mMinWidth;
    private float mEdgeAlpha;
    private float mEdgeScaleY;
    private float mGlowAlpha;
    private float mGlowScaleY;
    private float mEdgeAlphaStart;
    private float mEdgeAlphaFinish;
    private float mEdgeScaleYStart;
    private float mEdgeScaleYFinish;
    private float mGlowAlphaStart;
    private float mGlowAlphaFinish;
    private float mGlowScaleYStart;
    private float mGlowScaleYFinish;
    private long mStartTime;
    private float mDuration;
    private Interpolator mInterpolator;
    private int mState = STATE_IDLE;
    private float mPullDistance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.441 -0400", hash_original_method = "AC508E1EC1805645807F80E8793DDCA5", hash_generated_method = "F550027B4C224E2C394010A2F36C2BCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EdgeEffect(Context context) {
        dsTaint.addTaint(context.dsTaint);
        Resources res;
        res = context.getResources();
        mEdge = res.getDrawable(R.drawable.overscroll_edge);
        mGlow = res.getDrawable(R.drawable.overscroll_glow);
        mMinWidth = (int) (res.getDisplayMetrics().density * MIN_WIDTH + 0.5f);
        mInterpolator = new DecelerateInterpolator();
        // ---------- Original Method ----------
        //final Resources res = context.getResources();
        //mEdge = res.getDrawable(R.drawable.overscroll_edge);
        //mGlow = res.getDrawable(R.drawable.overscroll_glow);
        //mMinWidth = (int) (res.getDisplayMetrics().density * MIN_WIDTH + 0.5f);
        //mInterpolator = new DecelerateInterpolator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.441 -0400", hash_original_method = "2560E21D822EB58266D32B5FBCFCA888", hash_generated_method = "B8824A448B9B7B91DD29FEC2964E0A45")
    @DSModeled(DSC.SAFE)
    public void setSize(int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        // ---------- Original Method ----------
        //mWidth = width;
        //mHeight = height;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.442 -0400", hash_original_method = "C5415C2330467D0B97062A48ADF90DEB", hash_generated_method = "13842FA2F7CC4F6710991CAF3E2C139D")
    @DSModeled(DSC.SAFE)
    public boolean isFinished() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mState == STATE_IDLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.442 -0400", hash_original_method = "27AC7ECC3801AAB2943059507B28FB49", hash_generated_method = "4A51E2781D945A7EDF99F072DEC552D1")
    @DSModeled(DSC.SAFE)
    public void finish() {
        mState = STATE_IDLE;
        // ---------- Original Method ----------
        //mState = STATE_IDLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.442 -0400", hash_original_method = "0B34B4327835671A51286147399AA2A4", hash_generated_method = "539AEE4B6C8BBAE0D4D53DBEED3BBDD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onPull(float deltaDistance) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(deltaDistance);
        long now;
        now = AnimationUtils.currentAnimationTimeMillis();
        {
            mGlowScaleY = PULL_GLOW_BEGIN;
        } //End block
        mState = STATE_PULL;
        mStartTime = now;
        mDuration = PULL_TIME;
        float distance;
        distance = Math.abs(mPullDistance);
        mEdgeAlpha = mEdgeAlphaStart = Math.max(PULL_EDGE_BEGIN, Math.min(distance, MAX_ALPHA));
        mEdgeScaleY = mEdgeScaleYStart = Math.max(
                HELD_EDGE_SCALE_Y, Math.min(distance * PULL_DISTANCE_EDGE_FACTOR, 1.f));
        mGlowAlpha = mGlowAlphaStart = Math.min(MAX_ALPHA,
                mGlowAlpha +
                (Math.abs(deltaDistance) * PULL_DISTANCE_ALPHA_GLOW_FACTOR));
        float glowChange;
        glowChange = Math.abs(deltaDistance);
        {
            glowChange = -glowChange;
        } //End block
        {
            mGlowScaleY = 0;
        } //End block
        mGlowScaleY = mGlowScaleYStart = Math.min(MAX_GLOW_HEIGHT, Math.max(
                0, mGlowScaleY + glowChange * PULL_DISTANCE_GLOW_FACTOR));
        mEdgeAlphaFinish = mEdgeAlpha;
        mEdgeScaleYFinish = mEdgeScaleY;
        mGlowAlphaFinish = mGlowAlpha;
        mGlowScaleYFinish = mGlowScaleY;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.443 -0400", hash_original_method = "130A4176B67F340D0300F29A870A39F7", hash_generated_method = "48EABD6C325B873D69ADA88ADC482D05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onRelease() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mPullDistance = 0;
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
        // ---------- Original Method ----------
        //mPullDistance = 0;
        //if (mState != STATE_PULL && mState != STATE_PULL_DECAY) {
            //return;
        //}
        //mState = STATE_RECEDE;
        //mEdgeAlphaStart = mEdgeAlpha;
        //mEdgeScaleYStart = mEdgeScaleY;
        //mGlowAlphaStart = mGlowAlpha;
        //mGlowScaleYStart = mGlowScaleY;
        //mEdgeAlphaFinish = 0.f;
        //mEdgeScaleYFinish = 0.f;
        //mGlowAlphaFinish = 0.f;
        //mGlowScaleYFinish = 0.f;
        //mStartTime = AnimationUtils.currentAnimationTimeMillis();
        //mDuration = RECEDE_TIME;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.443 -0400", hash_original_method = "1D958DC13C828E6D4B8059ABA730E95F", hash_generated_method = "B048FA04DAFAB04AF9C9E47601F32E82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onAbsorb(int velocity) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(velocity);
        mState = STATE_ABSORB;
        velocity = Math.max(MIN_VELOCITY, Math.abs(velocity));
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mDuration = 0.1f + (velocity * 0.03f);
        mEdgeAlphaStart = 0.f;
        mEdgeScaleY = mEdgeScaleYStart = 0.f;
        mGlowAlphaStart = 0.5f;
        mGlowScaleYStart = 0.f;
        mEdgeAlphaFinish = Math.max(0, Math.min(velocity * VELOCITY_EDGE_FACTOR, 1));
        mEdgeScaleYFinish = Math.max(
                HELD_EDGE_SCALE_Y, Math.min(velocity * VELOCITY_EDGE_FACTOR, 1.f));
        mGlowScaleYFinish = Math.min(0.025f + (velocity * (velocity / 100) * 0.00015f), 1.75f);
        mGlowAlphaFinish = Math.max(
                mGlowAlphaStart, Math.min(velocity * VELOCITY_GLOW_FACTOR * .00001f, MAX_ALPHA));
        // ---------- Original Method ----------
        //mState = STATE_ABSORB;
        //velocity = Math.max(MIN_VELOCITY, Math.abs(velocity));
        //mStartTime = AnimationUtils.currentAnimationTimeMillis();
        //mDuration = 0.1f + (velocity * 0.03f);
        //mEdgeAlphaStart = 0.f;
        //mEdgeScaleY = mEdgeScaleYStart = 0.f;
        //mGlowAlphaStart = 0.5f;
        //mGlowScaleYStart = 0.f;
        //mEdgeAlphaFinish = Math.max(0, Math.min(velocity * VELOCITY_EDGE_FACTOR, 1));
        //mEdgeScaleYFinish = Math.max(
                //HELD_EDGE_SCALE_Y, Math.min(velocity * VELOCITY_EDGE_FACTOR, 1.f));
        //mGlowScaleYFinish = Math.min(0.025f + (velocity * (velocity / 100) * 0.00015f), 1.75f);
        //mGlowAlphaFinish = Math.max(
                //mGlowAlphaStart, Math.min(velocity * VELOCITY_GLOW_FACTOR * .00001f, MAX_ALPHA));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.444 -0400", hash_original_method = "610B6E206A511890E944EC9E15AA39A0", hash_generated_method = "F20975A7BE83043050024DC11527AE45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        update();
        int edgeHeight;
        edgeHeight = mEdge.getIntrinsicHeight();
        int edgeWidth;
        edgeWidth = mEdge.getIntrinsicWidth();
        int glowHeight;
        glowHeight = mGlow.getIntrinsicHeight();
        int glowWidth;
        glowWidth = mGlow.getIntrinsicWidth();
        mGlow.setAlpha((int) (Math.max(0, Math.min(mGlowAlpha, 1)) * 255));
        int glowBottom;
        glowBottom = (int) Math.min(
                glowHeight * mGlowScaleY * glowHeight/ glowWidth * 0.6f,
                glowHeight * MAX_GLOW_HEIGHT);
        {
            int glowLeft;
            glowLeft = (mWidth - mMinWidth)/2;
            mGlow.setBounds(glowLeft, 0, mWidth - glowLeft, glowBottom);
        } //End block
        {
            mGlow.setBounds(0, 0, mWidth, glowBottom);
        } //End block
        mGlow.draw(canvas);
        mEdge.setAlpha((int) (Math.max(0, Math.min(mEdgeAlpha, 1)) * 255));
        int edgeBottom;
        edgeBottom = (int) (edgeHeight * mEdgeScaleY);
        {
            int edgeLeft;
            edgeLeft = (mWidth - mMinWidth)/2;
            mEdge.setBounds(edgeLeft, 0, mWidth - edgeLeft, edgeBottom);
        } //End block
        {
            mEdge.setBounds(0, 0, mWidth, edgeBottom);
        } //End block
        mEdge.draw(canvas);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.445 -0400", hash_original_method = "217F98194ACCE474266C15D1EE978E29", hash_generated_method = "AEBDC7ACE719073347541577B47EF2D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void update() {
        long time;
        time = AnimationUtils.currentAnimationTimeMillis();
        float t;
        t = Math.min((time - mStartTime) / mDuration, 1.f);
        float interp;
        interp = mInterpolator.getInterpolation(t);
        mEdgeAlpha = mEdgeAlphaStart + (mEdgeAlphaFinish - mEdgeAlphaStart) * interp;
        mEdgeScaleY = mEdgeScaleYStart + (mEdgeScaleYFinish - mEdgeScaleYStart) * interp;
        mGlowAlpha = mGlowAlphaStart + (mGlowAlphaFinish - mGlowAlphaStart) * interp;
        mGlowScaleY = mGlowScaleYStart + (mGlowScaleYFinish - mGlowScaleYStart) * interp;
        {
            //Begin case STATE_ABSORB 
            mState = STATE_RECEDE;
            //End case STATE_ABSORB 
            //Begin case STATE_ABSORB 
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            //End case STATE_ABSORB 
            //Begin case STATE_ABSORB 
            mDuration = RECEDE_TIME;
            //End case STATE_ABSORB 
            //Begin case STATE_ABSORB 
            mEdgeAlphaStart = mEdgeAlpha;
            //End case STATE_ABSORB 
            //Begin case STATE_ABSORB 
            mEdgeScaleYStart = mEdgeScaleY;
            //End case STATE_ABSORB 
            //Begin case STATE_ABSORB 
            mGlowAlphaStart = mGlowAlpha;
            //End case STATE_ABSORB 
            //Begin case STATE_ABSORB 
            mGlowScaleYStart = mGlowScaleY;
            //End case STATE_ABSORB 
            //Begin case STATE_ABSORB 
            mEdgeAlphaFinish = 0.f;
            //End case STATE_ABSORB 
            //Begin case STATE_ABSORB 
            mEdgeScaleYFinish = 0.f;
            //End case STATE_ABSORB 
            //Begin case STATE_ABSORB 
            mGlowAlphaFinish = 0.f;
            //End case STATE_ABSORB 
            //Begin case STATE_ABSORB 
            mGlowScaleYFinish = 0.f;
            //End case STATE_ABSORB 
            //Begin case STATE_PULL 
            mState = STATE_PULL_DECAY;
            //End case STATE_PULL 
            //Begin case STATE_PULL 
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            //End case STATE_PULL 
            //Begin case STATE_PULL 
            mDuration = PULL_DECAY_TIME;
            //End case STATE_PULL 
            //Begin case STATE_PULL 
            mEdgeAlphaStart = mEdgeAlpha;
            //End case STATE_PULL 
            //Begin case STATE_PULL 
            mEdgeScaleYStart = mEdgeScaleY;
            //End case STATE_PULL 
            //Begin case STATE_PULL 
            mGlowAlphaStart = mGlowAlpha;
            //End case STATE_PULL 
            //Begin case STATE_PULL 
            mGlowScaleYStart = mGlowScaleY;
            //End case STATE_PULL 
            //Begin case STATE_PULL 
            mEdgeAlphaFinish = 0.f;
            //End case STATE_PULL 
            //Begin case STATE_PULL 
            mEdgeScaleYFinish = 0.f;
            //End case STATE_PULL 
            //Begin case STATE_PULL 
            mGlowAlphaFinish = 0.f;
            //End case STATE_PULL 
            //Begin case STATE_PULL 
            mGlowScaleYFinish = 0.f;
            //End case STATE_PULL 
            //Begin case STATE_PULL_DECAY 
            float factor;
            factor = 1
                            / (mGlowScaleYFinish * mGlowScaleYFinish);
            factor = Float.MAX_VALUE;
            //End case STATE_PULL_DECAY 
            //Begin case STATE_PULL_DECAY 
            mEdgeScaleY = mEdgeScaleYStart +
                        (mEdgeScaleYFinish - mEdgeScaleYStart) *
                            interp * factor;
            //End case STATE_PULL_DECAY 
            //Begin case STATE_PULL_DECAY 
            mState = STATE_RECEDE;
            //End case STATE_PULL_DECAY 
            //Begin case STATE_RECEDE 
            mState = STATE_IDLE;
            //End case STATE_RECEDE 
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final String TAG = "EdgeEffect";
    private static final int RECEDE_TIME = 1000;
    private static final int PULL_TIME = 167;
    private static final int PULL_DECAY_TIME = 1000;
    private static final float MAX_ALPHA = 0.8f;
    private static final float HELD_EDGE_ALPHA = 0.7f;
    private static final float HELD_EDGE_SCALE_Y = 0.5f;
    private static final float HELD_GLOW_ALPHA = 0.5f;
    private static final float HELD_GLOW_SCALE_Y = 0.5f;
    private static final float MAX_GLOW_HEIGHT = 4.f;
    private static final float PULL_GLOW_BEGIN = 1.f;
    private static final float PULL_EDGE_BEGIN = 0.6f;
    private static final int MIN_VELOCITY = 100;
    private static final float EPSILON = 0.001f;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PULL = 1;
    private static final int STATE_ABSORB = 2;
    private static final int STATE_RECEDE = 3;
    private static final int STATE_PULL_DECAY = 4;
    private static final int PULL_DISTANCE_EDGE_FACTOR = 7;
    private static final int PULL_DISTANCE_GLOW_FACTOR = 7;
    private static final float PULL_DISTANCE_ALPHA_GLOW_FACTOR = 1.1f;
    private static final int VELOCITY_EDGE_FACTOR = 8;
    private static final int VELOCITY_GLOW_FACTOR = 16;
}

