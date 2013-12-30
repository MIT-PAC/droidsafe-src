package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.util.FloatMath;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;





public class Scroller {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.189 -0500", hash_original_method = "CF44D29393F8CF17D456596D4EDD821D", hash_generated_method = "610DC32ACEA41D734955CF13C80E48E5")
    
static float viscousFluid(float x)
    {
        x *= sViscousFluidScale;
        if (x < 1.0f) {
            x -= (1.0f - (float)Math.exp(-x));
        } else {
            float start = 0.36787944117f;   // 1/e == exp(-1)
            x = 1.0f - (float)Math.exp(1.0f - x);
            x = start + x * (1.0f - start);
        }
        x *= sViscousFluidNormalize;
        return x;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.112 -0500", hash_original_field = "582653CA594E9011AB41A4FCE5484EDB", hash_generated_field = "71A034DCC41856FE859BC1F065FC4DA6")


    private static final int DEFAULT_DURATION = 250;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.116 -0500", hash_original_field = "3D6FED5899F5F015C1131133F50D0489", hash_generated_field = "A767E7A0CD4C56577AF1FE7F420CA686")

    private static final int SCROLL_MODE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.118 -0500", hash_original_field = "81563A2E06AEB00F58D11CE9DD9FB95A", hash_generated_field = "F3B8A415FA7A0B0422B61C4A171BBABD")

    private static final int FLING_MODE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.120 -0500", hash_original_field = "7C81A121BF1E57C28684452243FEDE29", hash_generated_field = "2564FD12FAC96B1440815F377BD8C411")


    private static float DECELERATION_RATE = (float) (Math.log(0.75) / Math.log(0.9));
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.123 -0500", hash_original_field = "E9FCD93A41F4EF4635D4415113CCF888", hash_generated_field = "D1E55FA511AC8DBB15DE29964200AC6B")

    private static float ALPHA = 800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.125 -0500", hash_original_field = "72D0F26258D7291C43DDE5ADBFA62073", hash_generated_field = "B423EA056F8FF25F121E7449EFE88A98")

    private static float START_TENSION = 0.4f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.127 -0500", hash_original_field = "20797BA4CFA1B3807166E4E682597325", hash_generated_field = "27DBFD6C76112C4B1F73E7F2EA5D3AA4")

    private static float END_TENSION = 1.0f - START_TENSION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.129 -0500", hash_original_field = "58559D9CC258992DAA0836486C11E2A8", hash_generated_field = "3B6A479A94E023469276FA3773CA8C8D")

    private static final int NB_SAMPLES = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.131 -0500", hash_original_field = "FD47AF34EC53F0D665043AFCDC6B4852", hash_generated_field = "9F7FDC960AFC4BFEA9C812BBA50BD28B")

    private static final float[] SPLINE = new float[NB_SAMPLES + 1];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.139 -0500", hash_original_field = "CFDDA46428719A93C3DE7EB47B4CA167", hash_generated_field = "1C432C24B5FBB274ECE9C0B14CF36243")


    private static float sViscousFluidScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.141 -0500", hash_original_field = "EA276757CC0DADEE519A4E9CDE52A6B2", hash_generated_field = "4E11B8A84F2C6FEABC4146BC9CB98208")

    private static float sViscousFluidNormalize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.070 -0500", hash_original_field = "556F09336B3BD1BEFE7C8BF0B32BAF35", hash_generated_field = "B9E13EBC2196F570555262A42E5818EF")

    private int mMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.072 -0500", hash_original_field = "7F2FA150F8D8A76C750DD698B8BF6CB5", hash_generated_field = "28E51E686EEF26C8A77C03ED820E724F")


    private int mStartX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.074 -0500", hash_original_field = "81022B59B7942B83F7EE5FF6915DB938", hash_generated_field = "2C4FD2F4594E993A1C0AA896A5F50971")

    private int mStartY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.076 -0500", hash_original_field = "67FBE36F891BDF3EED25F4029C45C078", hash_generated_field = "71B9BE40F3EB3F420DA51BED11A1FACC")

    private int mFinalX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.079 -0500", hash_original_field = "AC63DD55367069DEB05363B2C780CF41", hash_generated_field = "14970227CEB8B8463C037E05672A799A")

    private int mFinalY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.081 -0500", hash_original_field = "2AF40A235D5BECD19E81C37ACF5040F4", hash_generated_field = "AD8B01E82643B27CD370F8D831F238C1")


    private int mMinX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.083 -0500", hash_original_field = "58ADC8006C6A2C2CFC185F4EA3589EFB", hash_generated_field = "B2C478BEE6C183081971A9B0A8AE4922")

    private int mMaxX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.085 -0500", hash_original_field = "9A7F720ED3B9829B86AAD9F07969C9BF", hash_generated_field = "4011ABA5F49EA845B8922B89156403C8")

    private int mMinY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.087 -0500", hash_original_field = "A771FF4980832F6871EE3334D0F18700", hash_generated_field = "1B35EABD97FF7D29EE26B2F8FC71C0DC")

    private int mMaxY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.090 -0500", hash_original_field = "9CD3C946F3F5B3EE742F6639B7C05CBB", hash_generated_field = "060DFB2652993DA63F3C736F2D32C4A0")


    private int mCurrX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.092 -0500", hash_original_field = "B99C14A83C470C2345E5C37F1F3D5B47", hash_generated_field = "DBCFB0FF1F686A6075CBC61640B46359")

    private int mCurrY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.094 -0500", hash_original_field = "3C3A30DDD94D9D47CBB52C3848791CE7", hash_generated_field = "20EEDA67D8E4F20D3E4CA3D911CCA492")

    private long mStartTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.096 -0500", hash_original_field = "BC345057CF9CBE8611DA24E477E3EC27", hash_generated_field = "A658ABE5235D82E385D992CF2A9ACD3B")

    private int mDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.098 -0500", hash_original_field = "1F6732058D00137C35343ACCC16E2CC9", hash_generated_field = "C3F9F7F2BFB7C0487094A4AE88371035")

    private float mDurationReciprocal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.099 -0500", hash_original_field = "30B8A5202B650C136DD3D53E3CC27E2B", hash_generated_field = "BD1886B2C0F2736203D0E4959638388A")

    private float mDeltaX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.101 -0500", hash_original_field = "3BB09A6B16623C766D8175F95727FCF5", hash_generated_field = "B328B232FC86598D50E8994C967C8DF9")

    private float mDeltaY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.103 -0500", hash_original_field = "10598AB9B4F301B505526794EAE9EAF0", hash_generated_field = "0B1DE3EEB5BF08E36FD9B568D72D59CC")

    private boolean mFinished;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.106 -0500", hash_original_field = "A1326AE9004157E0812422F0F20CD6F9", hash_generated_field = "67BF1E9EFEC019D28BF77934CF035B72")

    private Interpolator mInterpolator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.108 -0500", hash_original_field = "3C6C48AF201FFC06BDC466551DBF9587", hash_generated_field = "DB496AACF49E477CC5F54743876A46FF")

    private boolean mFlywheel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.110 -0500", hash_original_field = "42B50432F3F5C6ABEA6F4A8A32D47427", hash_generated_field = "4B9AC7BF5E01DBE21607C260ED737A0D")


    private float mVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.134 -0500", hash_original_field = "94A6EE72E23F9750788C83A9DEAFE695", hash_generated_field = "C2BDDF1F4D015B5A70949ADE337CCAA9")


    private float mDeceleration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.136 -0500", hash_original_field = "69EFFC925D6B4105436F7B705DD526A1", hash_generated_field = "C099BB189EED7BFC70ED32FE3657313E")

    private  float mPpi;

    /**
     * Create a Scroller with the default duration and interpolator.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.143 -0500", hash_original_method = "F0B1F091C7D17598674B0DE91138DFE8", hash_generated_method = "5D5978B521B426BD09D0BCE0882F736E")
    
public Scroller(Context context) {
        this(context, null);
    }

    /**
     * Create a Scroller with the specified interpolator. If the interpolator is
     * null, the default (viscous) interpolator will be used. "Flywheel" behavior will
     * be in effect for apps targeting Honeycomb or newer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.145 -0500", hash_original_method = "26C129B43F046C683A3A546D94D7B25F", hash_generated_method = "16550742F281D93BA8322B35FFE8DACF")
    
public Scroller(Context context, Interpolator interpolator) {
        this(context, interpolator,
                context.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB);
    }

    /**
     * Create a Scroller with the specified interpolator. If the interpolator is
     * null, the default (viscous) interpolator will be used. Specify whether or
     * not to support progressive "flywheel" behavior in flinging.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.148 -0500", hash_original_method = "DB17BDB963992533B7D3120B4F8AA0BD", hash_generated_method = "0FAFDCCE70A0B6A60C3CB38E4C077433")
    
public Scroller(Context context, Interpolator interpolator, boolean flywheel) {
        mFinished = true;
        mInterpolator = interpolator;
        mPpi = context.getResources().getDisplayMetrics().density * 160.0f;
        mDeceleration = computeDeceleration(ViewConfiguration.getScrollFriction());
        mFlywheel = flywheel;
    }

    /**
     * The amount of friction applied to flings. The default value
     * is {@link ViewConfiguration#getScrollFriction}.
     * 
     * @param friction A scalar dimension-less value representing the coefficient of
     *         friction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.151 -0500", hash_original_method = "7DBB574AF8BCDDD777C332A70FF88B50", hash_generated_method = "A8FCC79115F72669CB6FD5389E2F2111")
    
public final void setFriction(float friction) {
        mDeceleration = computeDeceleration(friction);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.153 -0500", hash_original_method = "B6D5379ECD830F8ABC23D18179CF1E64", hash_generated_method = "224177B40DFA9187CA2C63C44995847E")
    
private float computeDeceleration(float friction) {
        return SensorManager.GRAVITY_EARTH   // g (m/s^2)
                      * 39.37f               // inch/meter
                      * mPpi                 // pixels per inch
                      * friction;
    }

    /**
     * 
     * Returns whether the scroller has finished scrolling.
     * 
     * @return True if the scroller has finished scrolling, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.155 -0500", hash_original_method = "FC91CF543B97ECA9AF0E75894ECCBF47", hash_generated_method = "E5DEF0A79033BC9B5EEB0B8F9DB1463F")
    
public final boolean isFinished() {
        return mFinished;
    }
    
    /**
     * Force the finished field to a particular value.
     *  
     * @param finished The new finished value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.157 -0500", hash_original_method = "D2A5F5698F1FC9281D0C68AF0BDE844E", hash_generated_method = "9341FE86DB356DCCE766B8064D35353F")
    
public final void forceFinished(boolean finished) {
        mFinished = finished;
    }
    
    /**
     * Returns how long the scroll event will take, in milliseconds.
     * 
     * @return The duration of the scroll in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.159 -0500", hash_original_method = "C5CB9F23218BD0303C05492AF6E52DA2", hash_generated_method = "435A63AD7A59A60E85ECBFA35C286957")
    
public final int getDuration() {
        return mDuration;
    }
    
    /**
     * Returns the current X offset in the scroll. 
     * 
     * @return The new X offset as an absolute distance from the origin.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.162 -0500", hash_original_method = "BBE38D2570F755B77B8BCEE3883878A8", hash_generated_method = "4E41D36F526AAF68C1E1DC2FBC513434")
    
public final int getCurrX() {
        return mCurrX;
    }
    
    /**
     * Returns the current Y offset in the scroll. 
     * 
     * @return The new Y offset as an absolute distance from the origin.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.164 -0500", hash_original_method = "F6ADC6344D48E201FCE3042AD823C1E1", hash_generated_method = "0FA9E998037FCAAD2F3E776A3158CAED")
    
public final int getCurrY() {
        return mCurrY;
    }
    
    /**
     * Returns the current velocity.
     *
     * @return The original velocity less the deceleration. Result may be
     * negative.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.166 -0500", hash_original_method = "B027DED22A5B5763CA61B11517344C6D", hash_generated_method = "FBD30219A263B76C72919EC369B7C1FE")
    
public float getCurrVelocity() {
        return mVelocity - mDeceleration * timePassed() / 2000.0f;
    }

    /**
     * Returns the start X offset in the scroll. 
     * 
     * @return The start X offset as an absolute distance from the origin.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.168 -0500", hash_original_method = "E9E5B4E6E70EEEC71B101472B8ED332D", hash_generated_method = "F4D774EE2D7DC7B6AC7D4A359A10AB9E")
    
public final int getStartX() {
        return mStartX;
    }
    
    /**
     * Returns the start Y offset in the scroll. 
     * 
     * @return The start Y offset as an absolute distance from the origin.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.170 -0500", hash_original_method = "96DB239ADDDE6565887119C487206B3B", hash_generated_method = "EA10829488B72BE8CDA25C0F10795591")
    
public final int getStartY() {
        return mStartY;
    }
    
    /**
     * Returns where the scroll will end. Valid only for "fling" scrolls.
     * 
     * @return The final X offset as an absolute distance from the origin.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.172 -0500", hash_original_method = "FA811E85285FC4A5EAEC6F3CADDA829D", hash_generated_method = "BDFA12568F79C06B41890291C1FF1C7E")
    
public final int getFinalX() {
        return mFinalX;
    }
    
    /**
     * Returns where the scroll will end. Valid only for "fling" scrolls.
     * 
     * @return The final Y offset as an absolute distance from the origin.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.175 -0500", hash_original_method = "39F49202EF2D412808D46FE4B1B455BA", hash_generated_method = "B4E63B164A6B85616E03240C535C53EE")
    
public final int getFinalY() {
        return mFinalY;
    }

    /**
     * Call this when you want to know the new location.  If it returns true,
     * the animation is not yet finished.  loc will be altered to provide the
     * new location.
     */ 
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.178 -0500", hash_original_method = "1D0B82032F5CA4B8FBC2BBD45CD555A7", hash_generated_method = "2E1962A007DD75268BA5B7E4A9EF347B")
    
public boolean computeScrollOffset() {
        if (mFinished) {
            return false;
        }

        int timePassed = (int)(AnimationUtils.currentAnimationTimeMillis() - mStartTime);
    
        if (timePassed < mDuration) {
            switch (mMode) {
            case SCROLL_MODE:
                float x = timePassed * mDurationReciprocal;
    
                if (mInterpolator == null)
                    x = viscousFluid(x); 
                else
                    x = mInterpolator.getInterpolation(x);
    
                mCurrX = mStartX + Math.round(x * mDeltaX);
                mCurrY = mStartY + Math.round(x * mDeltaY);
                break;
            case FLING_MODE:
                final float t = (float) timePassed / mDuration;
                final int index = (int) (NB_SAMPLES * t);
                final float t_inf = (float) index / NB_SAMPLES;
                final float t_sup = (float) (index + 1) / NB_SAMPLES;
                final float d_inf = SPLINE[index];
                final float d_sup = SPLINE[index + 1];
                final float distanceCoef = d_inf + (t - t_inf) / (t_sup - t_inf) * (d_sup - d_inf);
                
                mCurrX = mStartX + Math.round(distanceCoef * (mFinalX - mStartX));
                // Pin to mMinX <= mCurrX <= mMaxX
                mCurrX = Math.min(mCurrX, mMaxX);
                mCurrX = Math.max(mCurrX, mMinX);
                
                mCurrY = mStartY + Math.round(distanceCoef * (mFinalY - mStartY));
                // Pin to mMinY <= mCurrY <= mMaxY
                mCurrY = Math.min(mCurrY, mMaxY);
                mCurrY = Math.max(mCurrY, mMinY);

                if (mCurrX == mFinalX && mCurrY == mFinalY) {
                    mFinished = true;
                }

                break;
            }
        }
        else {
            mCurrX = mFinalX;
            mCurrY = mFinalY;
            mFinished = true;
        }
        return true;
    }
    
    /**
     * Start scrolling by providing a starting point and the distance to travel.
     * The scroll will use the default value of 250 milliseconds for the
     * duration.
     * 
     * @param startX Starting horizontal scroll offset in pixels. Positive
     *        numbers will scroll the content to the left.
     * @param startY Starting vertical scroll offset in pixels. Positive numbers
     *        will scroll the content up.
     * @param dx Horizontal distance to travel. Positive numbers will scroll the
     *        content to the left.
     * @param dy Vertical distance to travel. Positive numbers will scroll the
     *        content up.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.181 -0500", hash_original_method = "2558578E34A043045AE1AF32A3800D82", hash_generated_method = "F9CD515A4E2C5B16D0DE692CF1A61742")
    
public void startScroll(int startX, int startY, int dx, int dy) {
        startScroll(startX, startY, dx, dy, DEFAULT_DURATION);
    }

    /**
     * Start scrolling by providing a starting point and the distance to travel.
     * 
     * @param startX Starting horizontal scroll offset in pixels. Positive
     *        numbers will scroll the content to the left.
     * @param startY Starting vertical scroll offset in pixels. Positive numbers
     *        will scroll the content up.
     * @param dx Horizontal distance to travel. Positive numbers will scroll the
     *        content to the left.
     * @param dy Vertical distance to travel. Positive numbers will scroll the
     *        content up.
     * @param duration Duration of the scroll in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.183 -0500", hash_original_method = "81DB7D22C5A12E34B7101A322373D8F4", hash_generated_method = "42CF4D719D6A7D98303F02A1CB9DDB63")
    
public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        mMode = SCROLL_MODE;
        mFinished = false;
        mDuration = duration;
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mStartX = startX;
        mStartY = startY;
        mFinalX = startX + dx;
        mFinalY = startY + dy;
        mDeltaX = dx;
        mDeltaY = dy;
        mDurationReciprocal = 1.0f / (float) mDuration;
    }

    /**
     * Start scrolling based on a fling gesture. The distance travelled will
     * depend on the initial velocity of the fling.
     * 
     * @param startX Starting point of the scroll (X)
     * @param startY Starting point of the scroll (Y)
     * @param velocityX Initial velocity of the fling (X) measured in pixels per
     *        second.
     * @param velocityY Initial velocity of the fling (Y) measured in pixels per
     *        second
     * @param minX Minimum X value. The scroller will not scroll past this
     *        point.
     * @param maxX Maximum X value. The scroller will not scroll past this
     *        point.
     * @param minY Minimum Y value. The scroller will not scroll past this
     *        point.
     * @param maxY Maximum Y value. The scroller will not scroll past this
     *        point.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.186 -0500", hash_original_method = "9117CBBBDEAEC710E4E0E8355A758A12", hash_generated_method = "ED21D2C461F3D1D44AE129ABEA513092")
    
public void fling(int startX, int startY, int velocityX, int velocityY,
            int minX, int maxX, int minY, int maxY) {
        // Continue a scroll or fling in progress
        if (mFlywheel && !mFinished) {
            float oldVel = getCurrVelocity();

            float dx = (float) (mFinalX - mStartX);
            float dy = (float) (mFinalY - mStartY);
            float hyp = FloatMath.sqrt(dx * dx + dy * dy);

            float ndx = dx / hyp;
            float ndy = dy / hyp;

            float oldVelocityX = ndx * oldVel;
            float oldVelocityY = ndy * oldVel;
            if (Math.signum(velocityX) == Math.signum(oldVelocityX) &&
                    Math.signum(velocityY) == Math.signum(oldVelocityY)) {
                velocityX += oldVelocityX;
                velocityY += oldVelocityY;
            }
        }

        mMode = FLING_MODE;
        mFinished = false;

        float velocity = FloatMath.sqrt(velocityX * velocityX + velocityY * velocityY);
     
        mVelocity = velocity;
        final double l = Math.log(START_TENSION * velocity / ALPHA);
        mDuration = (int) (1000.0 * Math.exp(l / (DECELERATION_RATE - 1.0)));
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mStartX = startX;
        mStartY = startY;

        float coeffX = velocity == 0 ? 1.0f : velocityX / velocity;
        float coeffY = velocity == 0 ? 1.0f : velocityY / velocity;

        int totalDistance =
                (int) (ALPHA * Math.exp(DECELERATION_RATE / (DECELERATION_RATE - 1.0) * l));
        
        mMinX = minX;
        mMaxX = maxX;
        mMinY = minY;
        mMaxY = maxY;

        mFinalX = startX + Math.round(totalDistance * coeffX);
        // Pin to mMinX <= mFinalX <= mMaxX
        mFinalX = Math.min(mFinalX, mMaxX);
        mFinalX = Math.max(mFinalX, mMinX);
        
        mFinalY = startY + Math.round(totalDistance * coeffY);
        // Pin to mMinY <= mFinalY <= mMaxY
        mFinalY = Math.min(mFinalY, mMaxY);
        mFinalY = Math.max(mFinalY, mMinY);
    }
    
    /**
     * Stops the animation. Contrary to {@link #forceFinished(boolean)},
     * aborting the animating cause the scroller to move to the final x and y
     * position
     *
     * @see #forceFinished(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.191 -0500", hash_original_method = "685B5069D17FA4EA234CACB4808C2E58", hash_generated_method = "315D83D17C9C118149A9AC4942A6E0B8")
    
public void abortAnimation() {
        mCurrX = mFinalX;
        mCurrY = mFinalY;
        mFinished = true;
    }
    
    /**
     * Extend the scroll animation. This allows a running animation to scroll
     * further and longer, when used with {@link #setFinalX(int)} or {@link #setFinalY(int)}.
     *
     * @param extend Additional time to scroll in milliseconds.
     * @see #setFinalX(int)
     * @see #setFinalY(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.193 -0500", hash_original_method = "B7B8889BAD93C262A7F1BCB27AD999FF", hash_generated_method = "A50ACF967EA265E4813C914F81623BB9")
    
public void extendDuration(int extend) {
        int passed = timePassed();
        mDuration = passed + extend;
        mDurationReciprocal = 1.0f / mDuration;
        mFinished = false;
    }

    /**
     * Returns the time elapsed since the beginning of the scrolling.
     *
     * @return The elapsed time in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.195 -0500", hash_original_method = "2E2DDE91830A97E8B4307DB61F63C9CC", hash_generated_method = "120744DD3BD019BAAB244E786A2D5C27")
    
public int timePassed() {
        return (int)(AnimationUtils.currentAnimationTimeMillis() - mStartTime);
    }

    /**
     * Sets the final position (X) for this scroller.
     *
     * @param newX The new X offset as an absolute distance from the origin.
     * @see #extendDuration(int)
     * @see #setFinalY(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.197 -0500", hash_original_method = "EE7294042EF8679A239A5BDA33848B52", hash_generated_method = "3EA90DE968498B1DA25ADA1C3FFE5093")
    
public void setFinalX(int newX) {
        mFinalX = newX;
        mDeltaX = mFinalX - mStartX;
        mFinished = false;
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

    /**
     * Sets the final position (Y) for this scroller.
     *
     * @param newY The new Y offset as an absolute distance from the origin.
     * @see #extendDuration(int)
     * @see #setFinalX(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.199 -0500", hash_original_method = "E7F00F8A662510F71298FE30A619B84A", hash_generated_method = "EB0B1A0D5DB9430E65A31389D4B0B656")
    
public void setFinalY(int newY) {
        mFinalY = newY;
        mDeltaY = mFinalY - mStartY;
        mFinished = false;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.202 -0500", hash_original_method = "8B3C79E02507006E36F2788C827D3070", hash_generated_method = "1083D7931E6FA98A58C40153356D98BA")
    
public boolean isScrollingInDirection(float xvel, float yvel) {
        return !mFinished && Math.signum(xvel) == Math.signum(mFinalX - mStartX) &&
                Math.signum(yvel) == Math.signum(mFinalY - mStartY);
    }
}

