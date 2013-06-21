package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.SystemClock;

public class TransitionDrawable extends LayerDrawable implements Drawable.Callback {
    private int mTransitionState = TRANSITION_NONE;
    private boolean mReverse;
    private long mStartTimeMillis;
    private int mFrom;
    private int mTo;
    private int mDuration;
    private int mOriginalDuration;
    private int mAlpha = 0;
    private boolean mCrossFade;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.710 -0400", hash_original_method = "C5B06968060DB82F171AE45EB2B5A112", hash_generated_method = "29CA9CECEDB1AE892E4E936A3C90D29E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TransitionDrawable(Drawable[] layers) {
        this(new TransitionState(null, null, null), layers);
        dsTaint.addTaint(layers[0].dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.710 -0400", hash_original_method = "F9A92C9D3CD4AD3DBA18C1A12C406B85", hash_generated_method = "DD0146F709A79835F04688F1C0174458")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     TransitionDrawable() {
        this(new TransitionState(null, null, null), (Resources)null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.710 -0400", hash_original_method = "EA80240A8BFE15F4A059DA8EDA5E6B2D", hash_generated_method = "FE66630313E918EF214D48F17F0F773D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private TransitionDrawable(TransitionState state, Resources res) {
        super(state, res);
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.711 -0400", hash_original_method = "63330FC0726BC441343F8A6C1CE8445A", hash_generated_method = "87A7C9D5051DA03FEDFE84B9F2C10D76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private TransitionDrawable(TransitionState state, Drawable[] layers) {
        super(layers, state);
        dsTaint.addTaint(layers[0].dsTaint);
        dsTaint.addTaint(state.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.711 -0400", hash_original_method = "7DD647D65429090EAAF6E9E0252444A1", hash_generated_method = "C59C539623E59958DFACF941EE67B7DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     LayerState createConstantState(LayerState state, Resources res) {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        LayerState varF8068A3C9F223E9FEF43EF1EF6E2C687_479221539 = (new TransitionState((TransitionState) state, this, res));
        return (LayerState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new TransitionState((TransitionState) state, this, res);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.711 -0400", hash_original_method = "97CEB1054BCE489E9912047DDD2569CF", hash_generated_method = "40B5D4158D0A4E4C6BD43FD32ED5CE45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startTransition(int durationMillis) {
        dsTaint.addTaint(durationMillis);
        mFrom = 0;
        mTo = 255;
        mAlpha = 0;
        mDuration = mOriginalDuration = durationMillis;
        mReverse = false;
        mTransitionState = TRANSITION_STARTING;
        invalidateSelf();
        // ---------- Original Method ----------
        //mFrom = 0;
        //mTo = 255;
        //mAlpha = 0;
        //mDuration = mOriginalDuration = durationMillis;
        //mReverse = false;
        //mTransitionState = TRANSITION_STARTING;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.712 -0400", hash_original_method = "08F42BFD1EBF12CF3276DCDF0956FF23", hash_generated_method = "01E2910E8D9B446F13286E8FD4E61ED2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void resetTransition() {
        mAlpha = 0;
        mTransitionState = TRANSITION_NONE;
        invalidateSelf();
        // ---------- Original Method ----------
        //mAlpha = 0;
        //mTransitionState = TRANSITION_NONE;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.712 -0400", hash_original_method = "46AFBEEBA20F3F34CF5FEC703E9F1E57", hash_generated_method = "A7007C69D1D30AD8586D66755EB50FB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reverseTransition(int duration) {
        dsTaint.addTaint(duration);
        long time;
        time = SystemClock.uptimeMillis();
        {
            {
                mFrom = 0;
                mTo = 255;
                mAlpha = 0;
                mReverse = false;
            } //End block
            {
                mFrom = 255;
                mTo = 0;
                mAlpha = 255;
                mReverse = true;
            } //End block
            mDuration = mOriginalDuration = duration;
            mTransitionState = TRANSITION_STARTING;
            invalidateSelf();
        } //End block
        mReverse = !mReverse;
        mFrom = mAlpha;
        mTo = mReverse ? 0 : 255;
        mDuration = (int) (mReverse ? time - mStartTimeMillis :
                mOriginalDuration - (time - mStartTimeMillis));
        mTransitionState = TRANSITION_STARTING;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.713 -0400", hash_original_method = "1FBAB3689755625C733FF3C6D865C65F", hash_generated_method = "1AA70AFD9F5CB94D811E45D50BE13BDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        boolean done;
        done = true;
        //Begin case TRANSITION_STARTING 
        mStartTimeMillis = SystemClock.uptimeMillis();
        //End case TRANSITION_STARTING 
        //Begin case TRANSITION_STARTING 
        done = false;
        //End case TRANSITION_STARTING 
        //Begin case TRANSITION_STARTING 
        mTransitionState = TRANSITION_RUNNING;
        //End case TRANSITION_STARTING 
        //Begin case TRANSITION_RUNNING 
        {
            float normalized;
            normalized = (float)
                            (SystemClock.uptimeMillis() - mStartTimeMillis) / mDuration;
            done = normalized >= 1.0f;
            normalized = Math.min(normalized, 1.0f);
            mAlpha = (int) (mFrom  + (mTo - mFrom) * normalized);
        } //End block
        //End case TRANSITION_RUNNING 
        int alpha;
        alpha = mAlpha;
        boolean crossFade;
        crossFade = mCrossFade;
        ChildDrawable[] array;
        array = mLayerState.mChildren;
        {
            {
                array[0].mDrawable.draw(canvas);
            } //End block
            {
                array[1].mDrawable.draw(canvas);
            } //End block
        } //End block
        Drawable d;
        d = array[0].mDrawable;
        {
            d.setAlpha(255 - alpha);
        } //End block
        d.draw(canvas);
        {
            d.setAlpha(0xFF);
        } //End block
        {
            d = array[1].mDrawable;
            d.setAlpha(alpha);
            d.draw(canvas);
            d.setAlpha(0xFF);
        } //End block
        {
            invalidateSelf();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.713 -0400", hash_original_method = "2CD6D3E73358D8CBD280E6EE92F2D07C", hash_generated_method = "3297E376407791BEC3DB8A1B6605FD46")
    @DSModeled(DSC.SAFE)
    public void setCrossFadeEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        // ---------- Original Method ----------
        //mCrossFade = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.714 -0400", hash_original_method = "CD2EAE34D95290C8C0E6CBB8BD3A8C00", hash_generated_method = "2664497FF077C87FE7166EB55645B4EA")
    @DSModeled(DSC.SAFE)
    public boolean isCrossFadeEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCrossFade;
    }

    
    static class TransitionState extends LayerState {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.714 -0400", hash_original_method = "F1D0B45B3E25602A3478E0025FE64518", hash_generated_method = "41F2B7C0A122EAEDBA00095D590C1B99")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         TransitionState(TransitionState orig, TransitionDrawable owner,
                Resources res) {
            super(orig, owner, res);
            dsTaint.addTaint(res.dsTaint);
            dsTaint.addTaint(owner.dsTaint);
            dsTaint.addTaint(orig.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.714 -0400", hash_original_method = "74F5798AEA04A77B6E31B76C53519B4C", hash_generated_method = "FD0CBEBC2E8E006436C2A23271171645")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable() {
            Drawable var7E5191198CE58FE81FA08242476D1BF2_148723758 = (new TransitionDrawable(this, (Resources)null));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new TransitionDrawable(this, (Resources)null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.714 -0400", hash_original_method = "2864DA5070788F66F2135B6D59FADE5D", hash_generated_method = "92B91E865FDFB33B354B7C4A19541C05")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            Drawable var594C11EBE13E5C550F35747C315DB9DA_1963977680 = (new TransitionDrawable(this, res));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new TransitionDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.715 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "36011B0CFA5B1C48E438EB66BB35159E")
        @DSModeled(DSC.SAFE)
        @Override
        public int getChangingConfigurations() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
    }


    
    private static final int TRANSITION_STARTING = 0;
    private static final int TRANSITION_RUNNING = 1;
    private static final int TRANSITION_NONE = 2;
}

