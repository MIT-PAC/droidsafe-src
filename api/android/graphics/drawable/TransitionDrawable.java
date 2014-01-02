package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.SystemClock;





public class TransitionDrawable extends LayerDrawable implements Drawable.Callback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.001 -0500", hash_original_field = "75C926C83BBFDB17FFBF28EC90F80F69", hash_generated_field = "1A633D536EE3F439C073F10EBA919A97")

    private static final int TRANSITION_STARTING = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.004 -0500", hash_original_field = "43FEA14DBDEBEAC7E0F3C270B7319611", hash_generated_field = "D6BAF07E7FDE629B17C0001BE3132290")

    private static final int TRANSITION_RUNNING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.006 -0500", hash_original_field = "55B79D003ACFD8A7BAD42DCF3543E63B", hash_generated_field = "0E71F11924CBF54A46E740E3338A6F34")

    private static final int TRANSITION_NONE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.008 -0500", hash_original_field = "3B8614A2378385C9F1789079D2F28F0D", hash_generated_field = "D70F55987D084695053B74ED3F9477FE")

    private int mTransitionState = TRANSITION_NONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.011 -0500", hash_original_field = "CAEDC7360129F326D2D0FC7BDB4F9CC0", hash_generated_field = "589AC6E67EEDC8ABFD20242996FB9ED2")


    private boolean mReverse;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.013 -0500", hash_original_field = "509D3898CD21540946E17C915247FD75", hash_generated_field = "B83C8955E1DA3FA0CE0799F8A1CE7B42")

    private long mStartTimeMillis;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.015 -0500", hash_original_field = "90BBA3355E6267427C684DA37D63DEF0", hash_generated_field = "24B6498B57A4DDD67F7E9CE57E59205C")

    private int mFrom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.017 -0500", hash_original_field = "F0AA2A81D33FE51B8231CFC923AA9D0D", hash_generated_field = "E7DD6E411B4567693D5B14849913048F")

    private int mTo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.019 -0500", hash_original_field = "BC345057CF9CBE8611DA24E477E3EC27", hash_generated_field = "A658ABE5235D82E385D992CF2A9ACD3B")

    private int mDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.021 -0500", hash_original_field = "FCAF05B55D4F9E28FA3B30134B5B1E8F", hash_generated_field = "63DA7996CEEB5E2E849F56A3032ADA4C")

    private int mOriginalDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.023 -0500", hash_original_field = "68FBD3BDBF461995193FB1B35370CCAA", hash_generated_field = "F0AD14C6D1BAF0FD9600F81F877732D7")

    private int mAlpha = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.025 -0500", hash_original_field = "4DC75675F6AEB055FE11E036617403C9", hash_generated_field = "3D2C4B8BEF089824EBF65466777785F1")

    private boolean mCrossFade;

    /**
     * Create a new transition drawable with the specified list of layers. At least
     * 2 layers are required for this drawable to work properly.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.028 -0500", hash_original_method = "C5B06968060DB82F171AE45EB2B5A112", hash_generated_method = "ABEADF15FB58787DF6D3E6D297120009")
    
public TransitionDrawable(Drawable[] layers) {
        this(new TransitionState(null, null, null), layers);
    }

    /**
     * Create a new transition drawable with no layer. To work correctly, at least 2
     * layers must be added to this drawable.
     *
     * @see #TransitionDrawable(Drawable[])
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.030 -0500", hash_original_method = "F9A92C9D3CD4AD3DBA18C1A12C406B85", hash_generated_method = "F9A92C9D3CD4AD3DBA18C1A12C406B85")
    
TransitionDrawable() {
        this(new TransitionState(null, null, null), (Resources)null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.033 -0500", hash_original_method = "EA80240A8BFE15F4A059DA8EDA5E6B2D", hash_generated_method = "17FC28862B642C3E0C6574EC9040F8EE")
    
private TransitionDrawable(TransitionState state, Resources res) {
        super(state, res);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.035 -0500", hash_original_method = "63330FC0726BC441343F8A6C1CE8445A", hash_generated_method = "49B677147A982D39F64B032921BEEDD3")
    
private TransitionDrawable(TransitionState state, Drawable[] layers) {
        super(layers, state);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.037 -0500", hash_original_method = "7DD647D65429090EAAF6E9E0252444A1", hash_generated_method = "35F871EB482059AD21F524DB6B3ABD1D")
    
@Override
    LayerState createConstantState(LayerState state, Resources res) {
        return new TransitionState((TransitionState) state, this, res);
    }
    
    /**
     * Begin the second layer on top of the first layer.
     * 
     * @param durationMillis The length of the transition in milliseconds
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.040 -0500", hash_original_method = "97CEB1054BCE489E9912047DDD2569CF", hash_generated_method = "5A3261347299998869D5339D00F41336")
    
public void startTransition(int durationMillis) {
        mFrom = 0;
        mTo = 255;
        mAlpha = 0;
        mDuration = mOriginalDuration = durationMillis;
        mReverse = false;
        mTransitionState = TRANSITION_STARTING;
        invalidateSelf();
    }
    
    /**
     * Show only the first layer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.042 -0500", hash_original_method = "08F42BFD1EBF12CF3276DCDF0956FF23", hash_generated_method = "8E0CE9AD094D416BA7CB8E50F612FB48")
    
public void resetTransition() {
        mAlpha = 0;
        mTransitionState = TRANSITION_NONE;
        invalidateSelf();
    }

    /**
     * Reverses the transition, picking up where the transition currently is.
     * If the transition is not currently running, this will start the transition
     * with the specified duration. If the transition is already running, the last
     * known duration will be used.
     *
     * @param duration The duration to use if no transition is running.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.044 -0500", hash_original_method = "46AFBEEBA20F3F34CF5FEC703E9F1E57", hash_generated_method = "D908623F6D5052BD806272F7A2E73E18")
    
public void reverseTransition(int duration) {
        final long time = SystemClock.uptimeMillis();
        // Animation is over
        if (time - mStartTimeMillis > mDuration) {
            if (mTo == 0) {
                mFrom = 0;
                mTo = 255;
                mAlpha = 0;
                mReverse = false;
            } else {
                mFrom = 255;
                mTo = 0;
                mAlpha = 255;
                mReverse = true;
            }
            mDuration = mOriginalDuration = duration;
            mTransitionState = TRANSITION_STARTING;
            invalidateSelf();
            return;
        }

        mReverse = !mReverse;
        mFrom = mAlpha;
        mTo = mReverse ? 0 : 255;
        mDuration = (int) (mReverse ? time - mStartTimeMillis :
                mOriginalDuration - (time - mStartTimeMillis));
        mTransitionState = TRANSITION_STARTING;
    }

    
    static class TransitionState extends LayerState {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.055 -0500", hash_original_method = "F1D0B45B3E25602A3478E0025FE64518", hash_generated_method = "F1D0B45B3E25602A3478E0025FE64518")
        
TransitionState(TransitionState orig, TransitionDrawable owner,
                Resources res) {
            super(orig, owner, res);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.057 -0500", hash_original_method = "74F5798AEA04A77B6E31B76C53519B4C", hash_generated_method = "68DED141956BBFCC7DB396CF672EAE1A")
        
@Override
        public Drawable newDrawable() {
            return new TransitionDrawable(this, (Resources)null);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.060 -0500", hash_original_method = "2864DA5070788F66F2135B6D59FADE5D", hash_generated_method = "9FC7C6FFA92003CA8B436189770C5389")
        
@Override
        public Drawable newDrawable(Resources res) {
            return new TransitionDrawable(this, res);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.062 -0500", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "3AB30668ED270F2EDF2E0129C706FE4D")
        
@Override
        public int getChangingConfigurations() {
            return mChangingConfigurations;
        }

        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.047 -0500", hash_original_method = "1FBAB3689755625C733FF3C6D865C65F", hash_generated_method = "FC82F7FA3DEABE0ADAA5A9978DBA3FA6")
    
@Override
    public void draw(Canvas canvas) {
        boolean done = true;

        switch (mTransitionState) {
            case TRANSITION_STARTING:
                mStartTimeMillis = SystemClock.uptimeMillis();
                done = false;
                mTransitionState = TRANSITION_RUNNING;
                break;

            case TRANSITION_RUNNING:
                if (mStartTimeMillis >= 0) {
                    float normalized = (float)
                            (SystemClock.uptimeMillis() - mStartTimeMillis) / mDuration;
                    done = normalized >= 1.0f;
                    normalized = Math.min(normalized, 1.0f);
                    mAlpha = (int) (mFrom  + (mTo - mFrom) * normalized);
                }
                break;
        }
      
        final int alpha = mAlpha;
        final boolean crossFade = mCrossFade;
        final ChildDrawable[] array = mLayerState.mChildren;

        if (done) {
            // the setAlpha() calls below trigger invalidation and redraw. If we're done, just draw
            // the appropriate drawable[s] and return
            if (!crossFade || alpha == 0) {
                array[0].mDrawable.draw(canvas);
            }
            if (alpha == 0xFF) {
                array[1].mDrawable.draw(canvas);
            }
            return;
        }

        Drawable d;
        d = array[0].mDrawable;
        if (crossFade) {
            d.setAlpha(255 - alpha);
        }
        d.draw(canvas);
        if (crossFade) {
            d.setAlpha(0xFF);
        }

        if (alpha > 0) {
            d = array[1].mDrawable;
            d.setAlpha(alpha);
            d.draw(canvas);
            d.setAlpha(0xFF);
        }
        
        if (!done) {
            invalidateSelf();
        }
    }

    /**
     * Enables or disables the cross fade of the drawables. When cross fade
     * is disabled, the first drawable is always drawn opaque. With cross
     * fade enabled, the first drawable is drawn with the opposite alpha of
     * the second drawable. Cross fade is disabled by default.
     *
     * @param enabled True to enable cross fading, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.049 -0500", hash_original_method = "2CD6D3E73358D8CBD280E6EE92F2D07C", hash_generated_method = "72A640F9B98E6463FF6F6AE927DBEB70")
    
public void setCrossFadeEnabled(boolean enabled) {
        mCrossFade = enabled;
    }

    /**
     * Indicates whether the cross fade is enabled for this transition.
     *
     * @return True if cross fading is enabled, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:13.051 -0500", hash_original_method = "CD2EAE34D95290C8C0E6CBB8BD3A8C00", hash_generated_method = "BB4BB6AEDC75FA056864FEC70F3EB226")
    
public boolean isCrossFadeEnabled() {
        return mCrossFade;
    }
}

