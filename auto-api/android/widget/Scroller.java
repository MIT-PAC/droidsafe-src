package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.util.FloatMath;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class Scroller {
    private int mMode;
    private int mStartX;
    private int mStartY;
    private int mFinalX;
    private int mFinalY;
    private int mMinX;
    private int mMaxX;
    private int mMinY;
    private int mMaxY;
    private int mCurrX;
    private int mCurrY;
    private long mStartTime;
    private int mDuration;
    private float mDurationReciprocal;
    private float mDeltaX;
    private float mDeltaY;
    private boolean mFinished;
    private Interpolator mInterpolator;
    private boolean mFlywheel;
    private float mVelocity;
    private static final int DEFAULT_DURATION = 250;
    private static final int SCROLL_MODE = 0;
    private static final int FLING_MODE = 1;
    private static float DECELERATION_RATE = (float) (Math.log(0.75) / Math.log(0.9));
    private static float ALPHA = 800;
    private static float START_TENSION = 0.4f;
    private static float END_TENSION = 1.0f - START_TENSION;
    private static final int NB_SAMPLES = 100;
    private static final float[] SPLINE = new float[NB_SAMPLES + 1];
    private float mDeceleration;
    private final float mPpi;
    private static float sViscousFluidScale;
    private static float sViscousFluidNormalize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.288 -0400", hash_original_method = "F0B1F091C7D17598674B0DE91138DFE8", hash_generated_method = "8D0528E17219AAA2C66E6F51A26D2BEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Scroller(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.288 -0400", hash_original_method = "26C129B43F046C683A3A546D94D7B25F", hash_generated_method = "C24813825652368029201D3B76911C79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Scroller(Context context, Interpolator interpolator) {
        this(context, interpolator,
                context.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(interpolator.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.288 -0400", hash_original_method = "DB17BDB963992533B7D3120B4F8AA0BD", hash_generated_method = "E5BFB170B13F9E53298EA70B8CF00D0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Scroller(Context context, Interpolator interpolator, boolean flywheel) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(interpolator.dsTaint);
        dsTaint.addTaint(flywheel);
        mFinished = true;
        mPpi = context.getResources().getDisplayMetrics().density * 160.0f;
        mDeceleration = computeDeceleration(ViewConfiguration.getScrollFriction());
        // ---------- Original Method ----------
        //mFinished = true;
        //mInterpolator = interpolator;
        //mPpi = context.getResources().getDisplayMetrics().density * 160.0f;
        //mDeceleration = computeDeceleration(ViewConfiguration.getScrollFriction());
        //mFlywheel = flywheel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.288 -0400", hash_original_method = "7DBB574AF8BCDDD777C332A70FF88B50", hash_generated_method = "C606450173C963A2A6957F115992B22A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setFriction(float friction) {
        dsTaint.addTaint(friction);
        mDeceleration = computeDeceleration(friction);
        // ---------- Original Method ----------
        //mDeceleration = computeDeceleration(friction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.288 -0400", hash_original_method = "B6D5379ECD830F8ABC23D18179CF1E64", hash_generated_method = "EC848BBFAC123CF7CE9566DBB7884E74")
    @DSModeled(DSC.SAFE)
    private float computeDeceleration(float friction) {
        dsTaint.addTaint(friction);
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return SensorManager.GRAVITY_EARTH   
                      //* 39.37f               
                      //* mPpi                 
                      //* friction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.288 -0400", hash_original_method = "FC91CF543B97ECA9AF0E75894ECCBF47", hash_generated_method = "355CE5E074C85F6E337B6F351544FDAF")
    @DSModeled(DSC.SAFE)
    public final boolean isFinished() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFinished;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.288 -0400", hash_original_method = "D2A5F5698F1FC9281D0C68AF0BDE844E", hash_generated_method = "A148EC288AD009FEF55B38FE00F8850F")
    @DSModeled(DSC.SAFE)
    public final void forceFinished(boolean finished) {
        dsTaint.addTaint(finished);
        // ---------- Original Method ----------
        //mFinished = finished;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.288 -0400", hash_original_method = "C5CB9F23218BD0303C05492AF6E52DA2", hash_generated_method = "CE550CC7D89EC95180EC56AB41CE354B")
    @DSModeled(DSC.SAFE)
    public final int getDuration() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.288 -0400", hash_original_method = "BBE38D2570F755B77B8BCEE3883878A8", hash_generated_method = "D9581C65395425F4BB7BBF6385510187")
    @DSModeled(DSC.SAFE)
    public final int getCurrX() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCurrX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.288 -0400", hash_original_method = "F6ADC6344D48E201FCE3042AD823C1E1", hash_generated_method = "B6E8B810A5F6E433FB24C1EA3C496A44")
    @DSModeled(DSC.SAFE)
    public final int getCurrY() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCurrY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.288 -0400", hash_original_method = "B027DED22A5B5763CA61B11517344C6D", hash_generated_method = "EC0A3A94D9A16EE6AF67AAE288AF3820")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getCurrVelocity() {
        float var4E1A0AA14190C662937E996756C006EC_721528894 = (mVelocity - mDeceleration * timePassed() / 2000.0f);
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mVelocity - mDeceleration * timePassed() / 2000.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.289 -0400", hash_original_method = "E9E5B4E6E70EEEC71B101472B8ED332D", hash_generated_method = "F75506E6672686FF77BA59ED0E0BE182")
    @DSModeled(DSC.SAFE)
    public final int getStartX() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mStartX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.289 -0400", hash_original_method = "96DB239ADDDE6565887119C487206B3B", hash_generated_method = "480F1190379827DB6625399513ABA820")
    @DSModeled(DSC.SAFE)
    public final int getStartY() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mStartY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.289 -0400", hash_original_method = "FA811E85285FC4A5EAEC6F3CADDA829D", hash_generated_method = "B6AD3EE61BFA2881720F937759079183")
    @DSModeled(DSC.SAFE)
    public final int getFinalX() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFinalX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.289 -0400", hash_original_method = "39F49202EF2D412808D46FE4B1B455BA", hash_generated_method = "5025F9CE29928C13D645F68F9AE97777")
    @DSModeled(DSC.SAFE)
    public final int getFinalY() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFinalY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.289 -0400", hash_original_method = "1D0B82032F5CA4B8FBC2BBD45CD555A7", hash_generated_method = "233ECB9E382BD6F4EB33B43FC2287AA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean computeScrollOffset() {
        int timePassed;
        timePassed = (int)(AnimationUtils.currentAnimationTimeMillis() - mStartTime);
        {
            //Begin case SCROLL_MODE 
            float x;
            x = timePassed * mDurationReciprocal;
            //End case SCROLL_MODE 
            //Begin case SCROLL_MODE 
            x = viscousFluid(x);
            x = mInterpolator.getInterpolation(x);
            //End case SCROLL_MODE 
            //Begin case SCROLL_MODE 
            mCurrX = mStartX + Math.round(x * mDeltaX);
            //End case SCROLL_MODE 
            //Begin case SCROLL_MODE 
            mCurrY = mStartY + Math.round(x * mDeltaY);
            //End case SCROLL_MODE 
            //Begin case FLING_MODE 
            final float t;
            t = (float) timePassed / mDuration;
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            final int index;
            index = (int) (NB_SAMPLES * t);
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            final float t_inf;
            t_inf = (float) index / NB_SAMPLES;
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            final float t_sup;
            t_sup = (float) (index + 1) / NB_SAMPLES;
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            final float d_inf;
            d_inf = SPLINE[index];
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            final float d_sup;
            d_sup = SPLINE[index + 1];
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            final float distanceCoef;
            distanceCoef = d_inf + (t - t_inf) / (t_sup - t_inf) * (d_sup - d_inf);
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            mCurrX = mStartX + Math.round(distanceCoef * (mFinalX - mStartX));
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            mCurrX = Math.min(mCurrX, mMaxX);
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            mCurrX = Math.max(mCurrX, mMinX);
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            mCurrY = mStartY + Math.round(distanceCoef * (mFinalY - mStartY));
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            mCurrY = Math.min(mCurrY, mMaxY);
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            mCurrY = Math.max(mCurrY, mMinY);
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            {
                mFinished = true;
            } //End block
            //End case FLING_MODE 
        } //End block
        {
            mCurrX = mFinalX;
            mCurrY = mFinalY;
            mFinished = true;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.289 -0400", hash_original_method = "2558578E34A043045AE1AF32A3800D82", hash_generated_method = "4FEB147BEF48913BD11605DE9EF0E82A")
    @DSModeled(DSC.SAFE)
    public void startScroll(int startX, int startY, int dx, int dy) {
        dsTaint.addTaint(startX);
        dsTaint.addTaint(startY);
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        startScroll(startX, startY, dx, dy, DEFAULT_DURATION);
        // ---------- Original Method ----------
        //startScroll(startX, startY, dx, dy, DEFAULT_DURATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.289 -0400", hash_original_method = "81DB7D22C5A12E34B7101A322373D8F4", hash_generated_method = "A141DB9CE2A5306F6DEAC16338675AC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        dsTaint.addTaint(startX);
        dsTaint.addTaint(duration);
        dsTaint.addTaint(startY);
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        mMode = SCROLL_MODE;
        mFinished = false;
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mFinalX = startX + dx;
        mFinalY = startY + dy;
        mDurationReciprocal = 1.0f / (float) mDuration;
        // ---------- Original Method ----------
        //mMode = SCROLL_MODE;
        //mFinished = false;
        //mDuration = duration;
        //mStartTime = AnimationUtils.currentAnimationTimeMillis();
        //mStartX = startX;
        //mStartY = startY;
        //mFinalX = startX + dx;
        //mFinalY = startY + dy;
        //mDeltaX = dx;
        //mDeltaY = dy;
        //mDurationReciprocal = 1.0f / (float) mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.290 -0400", hash_original_method = "9117CBBBDEAEC710E4E0E8355A758A12", hash_generated_method = "87DC337EACFA87E75AFF7EEAF0004865")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fling(int startX, int startY, int velocityX, int velocityY,
            int minX, int maxX, int minY, int maxY) {
        dsTaint.addTaint(velocityX);
        dsTaint.addTaint(startX);
        dsTaint.addTaint(startY);
        dsTaint.addTaint(velocityY);
        dsTaint.addTaint(maxY);
        dsTaint.addTaint(maxX);
        dsTaint.addTaint(minX);
        dsTaint.addTaint(minY);
        {
            float oldVel;
            oldVel = getCurrVelocity();
            float dx;
            dx = (float) (mFinalX - mStartX);
            float dy;
            dy = (float) (mFinalY - mStartY);
            float hyp;
            hyp = FloatMath.sqrt(dx * dx + dy * dy);
            float ndx;
            ndx = dx / hyp;
            float ndy;
            ndy = dy / hyp;
            float oldVelocityX;
            oldVelocityX = ndx * oldVel;
            float oldVelocityY;
            oldVelocityY = ndy * oldVel;
            {
                boolean var86A175506156C862CC1BDCAE0428DBA5_1253763977 = (Math.signum(velocityX) == Math.signum(oldVelocityX) &&
                    Math.signum(velocityY) == Math.signum(oldVelocityY));
                {
                    velocityX += oldVelocityX;
                    velocityY += oldVelocityY;
                } //End block
            } //End collapsed parenthetic
        } //End block
        mMode = FLING_MODE;
        mFinished = false;
        float velocity;
        velocity = FloatMath.sqrt(velocityX * velocityX + velocityY * velocityY);
        mVelocity = velocity;
        final double l;
        l = Math.log(START_TENSION * velocity / ALPHA);
        mDuration = (int) (1000.0 * Math.exp(l / (DECELERATION_RATE - 1.0)));
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        float coeffX;
        coeffX = 1.0f;
        coeffX = velocityX / velocity;
        float coeffY;
        coeffY = 1.0f;
        coeffY = velocityY / velocity;
        int totalDistance;
        totalDistance = (int) (ALPHA * Math.exp(DECELERATION_RATE / (DECELERATION_RATE - 1.0) * l));
        mFinalX = startX + Math.round(totalDistance * coeffX);
        mFinalX = Math.min(mFinalX, mMaxX);
        mFinalX = Math.max(mFinalX, mMinX);
        mFinalY = startY + Math.round(totalDistance * coeffY);
        mFinalY = Math.min(mFinalY, mMaxY);
        mFinalY = Math.max(mFinalY, mMinY);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.290 -0400", hash_original_method = "CF44D29393F8CF17D456596D4EDD821D", hash_generated_method = "E8D2333A212A2E1D2BA432BCE9311CEA")
    static float viscousFluid(float x) {
        x *= sViscousFluidScale;
        if (x < 1.0f) {
            x -= (1.0f - (float)Math.exp(-x));
        } else {
            float start = 0.36787944117f;   
            x = 1.0f - (float)Math.exp(1.0f - x);
            x = start + x * (1.0f - start);
        }
        x *= sViscousFluidNormalize;
        return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.290 -0400", hash_original_method = "685B5069D17FA4EA234CACB4808C2E58", hash_generated_method = "796D74475C405F6836FB1E00746194FB")
    @DSModeled(DSC.SAFE)
    public void abortAnimation() {
        mCurrX = mFinalX;
        mCurrY = mFinalY;
        mFinished = true;
        // ---------- Original Method ----------
        //mCurrX = mFinalX;
        //mCurrY = mFinalY;
        //mFinished = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.290 -0400", hash_original_method = "B7B8889BAD93C262A7F1BCB27AD999FF", hash_generated_method = "7BF3B271F056CC7DDE19A7C11998CE42")
    @DSModeled(DSC.SAFE)
    public void extendDuration(int extend) {
        dsTaint.addTaint(extend);
        int passed;
        passed = timePassed();
        mDuration = passed + extend;
        mDurationReciprocal = 1.0f / mDuration;
        mFinished = false;
        // ---------- Original Method ----------
        //int passed = timePassed();
        //mDuration = passed + extend;
        //mDurationReciprocal = 1.0f / mDuration;
        //mFinished = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.290 -0400", hash_original_method = "2E2DDE91830A97E8B4307DB61F63C9CC", hash_generated_method = "DBFE0AA9683AA42A15BB479351B7A8E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int timePassed() {
        int varB31274B63FB1A219A03CF7B3308E210D_51037880 = ((int)(AnimationUtils.currentAnimationTimeMillis() - mStartTime));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int)(AnimationUtils.currentAnimationTimeMillis() - mStartTime);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.290 -0400", hash_original_method = "EE7294042EF8679A239A5BDA33848B52", hash_generated_method = "626707076A28605F325298DB730134C6")
    @DSModeled(DSC.SAFE)
    public void setFinalX(int newX) {
        dsTaint.addTaint(newX);
        mDeltaX = mFinalX - mStartX;
        mFinished = false;
        // ---------- Original Method ----------
        //mFinalX = newX;
        //mDeltaX = mFinalX - mStartX;
        //mFinished = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.290 -0400", hash_original_method = "E7F00F8A662510F71298FE30A619B84A", hash_generated_method = "3229D9B0137EE5BF9CCA4C8C855F711D")
    @DSModeled(DSC.SAFE)
    public void setFinalY(int newY) {
        dsTaint.addTaint(newY);
        mDeltaY = mFinalY - mStartY;
        mFinished = false;
        // ---------- Original Method ----------
        //mFinalY = newY;
        //mDeltaY = mFinalY - mStartY;
        //mFinished = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.290 -0400", hash_original_method = "8B3C79E02507006E36F2788C827D3070", hash_generated_method = "66F5B13D213A12B76772E02E7CBED5D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isScrollingInDirection(float xvel, float yvel) {
        dsTaint.addTaint(xvel);
        dsTaint.addTaint(yvel);
        boolean var059728334551CBB30CCF37D7663E618C_448346387 = (!mFinished && Math.signum(xvel) == Math.signum(mFinalX - mStartX) &&
                Math.signum(yvel) == Math.signum(mFinalY - mStartY));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !mFinished && Math.signum(xvel) == Math.signum(mFinalX - mStartX) &&
                //Math.signum(yvel) == Math.signum(mFinalY - mStartY);
    }

    
    static {
        float x_min = 0.0f;
        for (int i = 0; i <= NB_SAMPLES; i++) {
            final float t = (float) i / NB_SAMPLES;
            float x_max = 1.0f;
            float x, tx, coef;
            while (true) {
                x = x_min + (x_max - x_min) / 2.0f;
                coef = 3.0f * x * (1.0f - x);
                tx = coef * ((1.0f - x) * START_TENSION + x * END_TENSION) + x * x * x;
                if (Math.abs(tx - t) < 1E-5) break;
                if (tx > t) x_max = x;
                else x_min = x;
            }
            final float d = coef + x * x * x;
            SPLINE[i] = d;
        }
        SPLINE[NB_SAMPLES] = 1.0f;
        sViscousFluidScale = 8.0f;
        sViscousFluidNormalize = 1.0f;
        sViscousFluidNormalize = 1.0f / viscousFluid(1.0f);
    }
    
}


