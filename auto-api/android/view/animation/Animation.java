package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.util.TypedValue;
import dalvik.system.CloseGuard;

public abstract class Animation implements Cloneable {
    boolean mEnded = false;
    boolean mStarted = false;
    boolean mCycleFlip = false;
    boolean mInitialized = false;
    boolean mFillBefore = true;
    boolean mFillAfter = false;
    boolean mFillEnabled = false;
    long mStartTime = -1;
    long mStartOffset;
    long mDuration;
    int mRepeatCount = 0;
    int mRepeated = 0;
    int mRepeatMode = RESTART;
    Interpolator mInterpolator;
    AnimationListener mListener;
    private int mZAdjustment;
    private int mBackgroundColor;
    private float mScaleFactor = 1f;
    private boolean mDetachWallpaper = false;
    private boolean mMore = true;
    private boolean mOneMoreTime = true;
    RectF mPreviousRegion = new RectF();
    RectF mRegion = new RectF();
    Transformation mTransformation = new Transformation();
    Transformation mPreviousTransformation = new Transformation();
    private CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.994 -0400", hash_original_method = "F5207BDCC3F51BB57C76C57DBA5A0AD4", hash_generated_method = "F05BFA516EF987BB837572F17670E4BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Animation() {
        ensureInterpolator();
        // ---------- Original Method ----------
        //ensureInterpolator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.995 -0400", hash_original_method = "325850FA9042895E97F9004576A85DF0", hash_generated_method = "8EB51364F897F4B2EDF23C788AD401BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Animation(Context context, AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.Animation);
        setDuration((long) a.getInt(com.android.internal.R.styleable.Animation_duration, 0));
        setStartOffset((long) a.getInt(com.android.internal.R.styleable.Animation_startOffset, 0));
        setFillEnabled(a.getBoolean(com.android.internal.R.styleable.Animation_fillEnabled, mFillEnabled));
        setFillBefore(a.getBoolean(com.android.internal.R.styleable.Animation_fillBefore, mFillBefore));
        setFillAfter(a.getBoolean(com.android.internal.R.styleable.Animation_fillAfter, mFillAfter));
        setRepeatCount(a.getInt(com.android.internal.R.styleable.Animation_repeatCount, mRepeatCount));
        setRepeatMode(a.getInt(com.android.internal.R.styleable.Animation_repeatMode, RESTART));
        setZAdjustment(a.getInt(com.android.internal.R.styleable.Animation_zAdjustment, ZORDER_NORMAL));
        setBackgroundColor(a.getInt(com.android.internal.R.styleable.Animation_background, 0));
        setDetachWallpaper(a.getBoolean(com.android.internal.R.styleable.Animation_detachWallpaper, false));
        int resID;
        resID = a.getResourceId(com.android.internal.R.styleable.Animation_interpolator, 0);
        a.recycle();
        {
            setInterpolator(context, resID);
        } //End block
        ensureInterpolator();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.995 -0400", hash_original_method = "7BC58C079EA752AD7803A7DE0B66531B", hash_generated_method = "0DCE75BAB4CD7017273B8F42B4583885")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected Animation clone() throws CloneNotSupportedException {
        Animation animation;
        animation = (Animation) super.clone();
        animation.mPreviousRegion = new RectF();
        animation.mRegion = new RectF();
        animation.mTransformation = new Transformation();
        animation.mPreviousTransformation = new Transformation();
        return (Animation)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final Animation animation = (Animation) super.clone();
        //animation.mPreviousRegion = new RectF();
        //animation.mRegion = new RectF();
        //animation.mTransformation = new Transformation();
        //animation.mPreviousTransformation = new Transformation();
        //return animation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.995 -0400", hash_original_method = "3AB995FAF173BC91AA72FEE328D0BE86", hash_generated_method = "8D4043FB51D478DAAF7B549EEBB6A8F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reset() {
        mPreviousRegion.setEmpty();
        mPreviousTransformation.clear();
        mInitialized = false;
        mCycleFlip = false;
        mRepeated = 0;
        mMore = true;
        mOneMoreTime = true;
        // ---------- Original Method ----------
        //mPreviousRegion.setEmpty();
        //mPreviousTransformation.clear();
        //mInitialized = false;
        //mCycleFlip = false;
        //mRepeated = 0;
        //mMore = true;
        //mOneMoreTime = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.995 -0400", hash_original_method = "E313CF9FDC4A243810ECD11633502833", hash_generated_method = "29EBB71A23A64A845C7799973E35B096")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancel() {
        {
            mListener.onAnimationEnd(this);
            mEnded = true;
            guard.close();
        } //End block
        mStartTime = Long.MIN_VALUE;
        mMore = mOneMoreTime = false;
        // ---------- Original Method ----------
        //if (mStarted && !mEnded) {
            //if (mListener != null) mListener.onAnimationEnd(this);
            //mEnded = true;
            //guard.close();
        //}
        //mStartTime = Long.MIN_VALUE;
        //mMore = mOneMoreTime = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.995 -0400", hash_original_method = "BA118FB94C8A2A7F04D6CE25751A9CE0", hash_generated_method = "A4DDB9C862465695F447293D473853D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void detach() {
        {
            mEnded = true;
            guard.close();
            mListener.onAnimationEnd(this);
        } //End block
        // ---------- Original Method ----------
        //if (mStarted && !mEnded) {
            //mEnded = true;
            //guard.close();
            //if (mListener != null) mListener.onAnimationEnd(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.996 -0400", hash_original_method = "130A49FBCE1398CCC055AA736C1B7B6D", hash_generated_method = "F3FF49193D6888BA6472B1C2C354ACBD")
    @DSModeled(DSC.SAFE)
    public boolean isInitialized() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mInitialized;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.996 -0400", hash_original_method = "9B9AA705D4796FA141302715AF35F1C7", hash_generated_method = "097198EAC2DDCBAD400AEC91EB450BED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(parentWidth);
        dsTaint.addTaint(width);
        dsTaint.addTaint(parentHeight);
        reset();
        mInitialized = true;
        // ---------- Original Method ----------
        //reset();
        //mInitialized = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.996 -0400", hash_original_method = "2C6481DDCCEAC913795356C9BF1AF628", hash_generated_method = "98C0D27C587C4CDF7DDFA11AC2FF23E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInterpolator(Context context, int resID) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(resID);
        setInterpolator(AnimationUtils.loadInterpolator(context, resID));
        // ---------- Original Method ----------
        //setInterpolator(AnimationUtils.loadInterpolator(context, resID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.996 -0400", hash_original_method = "4EEF3DF2F4BA4D9B865A07AD850625E7", hash_generated_method = "1EFCC6F575E774DD8F84F3DA015B8F50")
    @DSModeled(DSC.SAFE)
    public void setInterpolator(Interpolator i) {
        dsTaint.addTaint(i.dsTaint);
        // ---------- Original Method ----------
        //mInterpolator = i;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.996 -0400", hash_original_method = "BF0ACB3E237AAE7044714380D4DED735", hash_generated_method = "C5E91138D5F32523CA674277F4BBD1E2")
    @DSModeled(DSC.SAFE)
    public void setStartOffset(long startOffset) {
        dsTaint.addTaint(startOffset);
        // ---------- Original Method ----------
        //mStartOffset = startOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.997 -0400", hash_original_method = "C4FADDE7E113E13802025E54418B7E99", hash_generated_method = "E63E6AEEC5A1D7046DE0CEF89CDDB09E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDuration(long durationMillis) {
        dsTaint.addTaint(durationMillis);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Animation duration cannot be negative");
        } //End block
        // ---------- Original Method ----------
        //if (durationMillis < 0) {
            //throw new IllegalArgumentException("Animation duration cannot be negative");
        //}
        //mDuration = durationMillis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.997 -0400", hash_original_method = "448C869CF9265A7FCC7AB9AE39BBC12A", hash_generated_method = "84C3D3723F66A154A65E7FD7BE0B5BB8")
    @DSModeled(DSC.SAFE)
    public void restrictDuration(long durationMillis) {
        dsTaint.addTaint(durationMillis);
        {
            mDuration = 0;
            mRepeatCount = 0;
        } //End block
        long dur;
        dur = mDuration + mStartOffset;
        {
            mDuration = durationMillis-mStartOffset;
            dur = durationMillis;
        } //End block
        {
            mDuration = 0;
            mRepeatCount = 0;
        } //End block
        {
            mRepeatCount = (int)(durationMillis/dur) - 1;
            {
                mRepeatCount = 0;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mStartOffset > durationMillis) {
            //mStartOffset = durationMillis;
            //mDuration = 0;
            //mRepeatCount = 0;
            //return;
        //}
        //long dur = mDuration + mStartOffset;
        //if (dur > durationMillis) {
            //mDuration = durationMillis-mStartOffset;
            //dur = durationMillis;
        //}
        //if (mDuration <= 0) {
            //mDuration = 0;
            //mRepeatCount = 0;
            //return;
        //}
        //if (mRepeatCount < 0 || mRepeatCount > durationMillis
                //|| (dur*mRepeatCount) > durationMillis) {
            //mRepeatCount = (int)(durationMillis/dur) - 1;
            //if (mRepeatCount < 0) {
                //mRepeatCount = 0;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.997 -0400", hash_original_method = "7B723F7D723B2ADF0E8C91EC6AA68330", hash_generated_method = "226315FD750CDE0543E74968D5861590")
    @DSModeled(DSC.SAFE)
    public void scaleCurrentDuration(float scale) {
        dsTaint.addTaint(scale);
        mDuration = (long) (mDuration * scale);
        mStartOffset = (long) (mStartOffset * scale);
        // ---------- Original Method ----------
        //mDuration = (long) (mDuration * scale);
        //mStartOffset = (long) (mStartOffset * scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.997 -0400", hash_original_method = "C5F2E1E5B86432971DA671FBAF722042", hash_generated_method = "5FD30009386713C51EE8B66F349441BE")
    @DSModeled(DSC.SAFE)
    public void setStartTime(long startTimeMillis) {
        dsTaint.addTaint(startTimeMillis);
        mStarted = mEnded = false;
        mCycleFlip = false;
        mRepeated = 0;
        mMore = true;
        // ---------- Original Method ----------
        //mStartTime = startTimeMillis;
        //mStarted = mEnded = false;
        //mCycleFlip = false;
        //mRepeated = 0;
        //mMore = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.997 -0400", hash_original_method = "95CC5B32D25F554AB1041684F2D9EFB3", hash_generated_method = "C2C0CAF344BAFEE463FD4717BEBB205F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void start() {
        setStartTime(-1);
        // ---------- Original Method ----------
        //setStartTime(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.998 -0400", hash_original_method = "66165BC7696DE4F74728FD45F7498148", hash_generated_method = "A6131EE72377D167A51760B30339E8DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startNow() {
        setStartTime(AnimationUtils.currentAnimationTimeMillis());
        // ---------- Original Method ----------
        //setStartTime(AnimationUtils.currentAnimationTimeMillis());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.998 -0400", hash_original_method = "DDD317A37915E8A65D2BE1E304EF578A", hash_generated_method = "4CEBB9BAC70803E89459400039658F44")
    @DSModeled(DSC.SAFE)
    public void setRepeatMode(int repeatMode) {
        dsTaint.addTaint(repeatMode);
        // ---------- Original Method ----------
        //mRepeatMode = repeatMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.998 -0400", hash_original_method = "A134D6BEB9FF1047810E15F38A519E7E", hash_generated_method = "16C5E5CD92926BAE73A40949A771E008")
    @DSModeled(DSC.SAFE)
    public void setRepeatCount(int repeatCount) {
        dsTaint.addTaint(repeatCount);
        {
            repeatCount = INFINITE;
        } //End block
        // ---------- Original Method ----------
        //if (repeatCount < 0) {
            //repeatCount = INFINITE;
        //}
        //mRepeatCount = repeatCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.998 -0400", hash_original_method = "99447AF68D215B648170642F948B1397", hash_generated_method = "E7BEB76B1C51AD456349891B2CD27EC2")
    @DSModeled(DSC.SAFE)
    public boolean isFillEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFillEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.998 -0400", hash_original_method = "FD550D09AAFA6DFC07B09135F2C7B62C", hash_generated_method = "0A1A67F00D148CC067BF3E508F24FEEE")
    @DSModeled(DSC.SAFE)
    public void setFillEnabled(boolean fillEnabled) {
        dsTaint.addTaint(fillEnabled);
        // ---------- Original Method ----------
        //mFillEnabled = fillEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.998 -0400", hash_original_method = "4449C3292A8570D114A58B4E08D55011", hash_generated_method = "E43E241AF00FF285E42191D8B85B61AF")
    @DSModeled(DSC.SAFE)
    public void setFillBefore(boolean fillBefore) {
        dsTaint.addTaint(fillBefore);
        // ---------- Original Method ----------
        //mFillBefore = fillBefore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.999 -0400", hash_original_method = "4CCE59DDFB007D2C725E384A84210333", hash_generated_method = "ED66473D8FF9BEDD0C269512D61DB859")
    @DSModeled(DSC.SAFE)
    public void setFillAfter(boolean fillAfter) {
        dsTaint.addTaint(fillAfter);
        // ---------- Original Method ----------
        //mFillAfter = fillAfter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.999 -0400", hash_original_method = "B53AFA13C43018FC57757729E8C6F5B9", hash_generated_method = "CE5EC9388280BD927C2DC2BAEC58FEB7")
    @DSModeled(DSC.SAFE)
    public void setZAdjustment(int zAdjustment) {
        dsTaint.addTaint(zAdjustment);
        // ---------- Original Method ----------
        //mZAdjustment = zAdjustment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.999 -0400", hash_original_method = "5CC3CCDE182714D1D24D814D03E78D72", hash_generated_method = "F97EFF9BC4503FDA2E20544DCB4D8515")
    @DSModeled(DSC.SAFE)
    public void setBackgroundColor(int bg) {
        dsTaint.addTaint(bg);
        // ---------- Original Method ----------
        //mBackgroundColor = bg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.999 -0400", hash_original_method = "209B3580CB795CD8B9886E8B498D1959", hash_generated_method = "06DEAA92CD61A54F0A81D16B55031EA4")
    @DSModeled(DSC.SAFE)
    protected float getScaleFactor() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mScaleFactor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.999 -0400", hash_original_method = "DC51879EADA1EC63F555D590C58841F2", hash_generated_method = "3E6B30E78195A7EC2E1F691C3912869B")
    @DSModeled(DSC.SAFE)
    public void setDetachWallpaper(boolean detachWallpaper) {
        dsTaint.addTaint(detachWallpaper);
        // ---------- Original Method ----------
        //mDetachWallpaper = detachWallpaper;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.999 -0400", hash_original_method = "8AA04851FFB5BE49EA5890940035B142", hash_generated_method = "76053164EB61152210D7C18D58A6F349")
    @DSModeled(DSC.SAFE)
    public Interpolator getInterpolator() {
        return (Interpolator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.000 -0400", hash_original_method = "62DE33F2E1C7C51F234B4CE29FC5DCED", hash_generated_method = "0BB32B07FFBC55B68C58BB58FA5AEA36")
    @DSModeled(DSC.SAFE)
    public long getStartTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mStartTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.000 -0400", hash_original_method = "5E13B5E872677B59408FA3E6BB94A9F6", hash_generated_method = "7393246166219F841D7208D2C30FC7B2")
    @DSModeled(DSC.SAFE)
    public long getDuration() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.000 -0400", hash_original_method = "F15F7E68559FE94D65E8E77E2E4D8AE9", hash_generated_method = "13A033B78E54C5CAB0085FCECCF3964F")
    @DSModeled(DSC.SAFE)
    public long getStartOffset() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mStartOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.000 -0400", hash_original_method = "081205714C0DCBE8DC8471C6BC7C6458", hash_generated_method = "6624FE6A716E0D15AACB0C3B82E99B42")
    @DSModeled(DSC.SAFE)
    public int getRepeatMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRepeatMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.000 -0400", hash_original_method = "4FE747AC8B0667617AE307ECFC6ED74A", hash_generated_method = "85EC6C9DB83FC4FA5B74CCFA57CA19CC")
    @DSModeled(DSC.SAFE)
    public int getRepeatCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRepeatCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.000 -0400", hash_original_method = "EC25BC6D19EE141C12788801543B6178", hash_generated_method = "314D8DF60BE6898020F113BCAB53976F")
    @DSModeled(DSC.SAFE)
    public boolean getFillBefore() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFillBefore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.000 -0400", hash_original_method = "6D667DA3C62337EC4E4606350728AE89", hash_generated_method = "729AF02366AF582BE67AA4A3F375AF4A")
    @DSModeled(DSC.SAFE)
    public boolean getFillAfter() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFillAfter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.001 -0400", hash_original_method = "409F6F7832CADDC17E7E5231CAA22AC6", hash_generated_method = "1538E42F15454B02A463C9B52F146E8E")
    @DSModeled(DSC.SAFE)
    public int getZAdjustment() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mZAdjustment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.001 -0400", hash_original_method = "FAF00526A7BA7C979C907792653A05BB", hash_generated_method = "D63E19C58672099AECA963A1124AC0B1")
    @DSModeled(DSC.SAFE)
    public int getBackgroundColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBackgroundColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.001 -0400", hash_original_method = "E6A00B836A83DBDC739846B44941121A", hash_generated_method = "8D81B0A47AD90DEC6207ED2234F322E5")
    @DSModeled(DSC.SAFE)
    public boolean getDetachWallpaper() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDetachWallpaper;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.001 -0400", hash_original_method = "06611FABC5DAE0D86003F0AC94713BBE", hash_generated_method = "986052F9DEE05E4FE695995CEC7848DC")
    @DSModeled(DSC.SAFE)
    public boolean willChangeTransformationMatrix() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.001 -0400", hash_original_method = "75ECA58382FCAFBFF99662736FC361D6", hash_generated_method = "1377BB7B0E17585E3EEFEB5BD02E62FA")
    @DSModeled(DSC.SAFE)
    public boolean willChangeBounds() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.001 -0400", hash_original_method = "93175FBEC8620A1D25367C53936C85B5", hash_generated_method = "C1CE2ABC2E95AA771943B6F90D21FCE1")
    @DSModeled(DSC.SAFE)
    public void setAnimationListener(AnimationListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.001 -0400", hash_original_method = "B0865E74040125EA32BE48261064C937", hash_generated_method = "4EBFE9C6B0075792054082D9C6D06DB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void ensureInterpolator() {
        {
            mInterpolator = new AccelerateDecelerateInterpolator();
        } //End block
        // ---------- Original Method ----------
        //if (mInterpolator == null) {
            //mInterpolator = new AccelerateDecelerateInterpolator();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.002 -0400", hash_original_method = "B3F1AB6DDEFF92B122293B4363A1C456", hash_generated_method = "0A1FE2E357E49B28923D1501F41B1E68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long computeDurationHint() {
        long varABD0FCA997F16598E25E81E01A20B151_1779693528 = ((getStartOffset() + getDuration()) * (getRepeatCount() + 1));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return (getStartOffset() + getDuration()) * (getRepeatCount() + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.002 -0400", hash_original_method = "1D66EEFFAD10DF7675973FFD0CA72C11", hash_generated_method = "1303EDD13B5D8025799709A3FE565C67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getTransformation(long currentTime, Transformation outTransformation) {
        dsTaint.addTaint(currentTime);
        dsTaint.addTaint(outTransformation.dsTaint);
        long startOffset;
        startOffset = getStartOffset();
        long duration;
        duration = mDuration;
        float normalizedTime;
        {
            normalizedTime = ((float) (currentTime - (mStartTime + startOffset))) /
                    (float) duration;
        } //End block
        {
            normalizedTime = currentTime < mStartTime ? 0.0f : 1.0f;
        } //End block
        boolean expired;
        expired = normalizedTime >= 1.0f;
        mMore = !expired;
        normalizedTime = Math.max(Math.min(normalizedTime, 1.0f), 0.0f);
        {
            {
                {
                    mListener.onAnimationStart(this);
                } //End block
                mStarted = true;
                {
                    guard.open("cancel or detach or getTransformation");
                } //End block
            } //End block
            normalizedTime = Math.max(Math.min(normalizedTime, 1.0f), 0.0f);
            {
                normalizedTime = 1.0f - normalizedTime;
            } //End block
            float interpolatedTime;
            interpolatedTime = mInterpolator.getInterpolation(normalizedTime);
            applyTransformation(interpolatedTime, outTransformation);
        } //End block
        {
            {
                {
                    mEnded = true;
                    guard.close();
                    {
                        mListener.onAnimationEnd(this);
                    } //End block
                } //End block
            } //End block
            {
                {
                    mCycleFlip = !mCycleFlip;
                } //End block
                mStartTime = -1;
                mMore = true;
                {
                    mListener.onAnimationRepeat(this);
                } //End block
            } //End block
        } //End block
        {
            mOneMoreTime = false;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.003 -0400", hash_original_method = "2D55A6E78A3D329DDFA1835011833D50", hash_generated_method = "BB1A709E2B527E68E5A960088A17652C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getTransformation(long currentTime, Transformation outTransformation,
            float scale) {
        dsTaint.addTaint(currentTime);
        dsTaint.addTaint(scale);
        dsTaint.addTaint(outTransformation.dsTaint);
        boolean var0C8BADD9759052F94EFF38E8FDC1128E_325397609 = (getTransformation(currentTime, outTransformation));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mScaleFactor = scale;
        //return getTransformation(currentTime, outTransformation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.003 -0400", hash_original_method = "777CAD815D79C7ADA7276922FB123EB2", hash_generated_method = "03E9779614090AA69EB2B36F1F232B18")
    @DSModeled(DSC.SAFE)
    public boolean hasStarted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mStarted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.003 -0400", hash_original_method = "D01D8338B537AF4FCC0E5AB769C5FB0B", hash_generated_method = "4984D34701439E66961C9ECC8DD1D6CE")
    @DSModeled(DSC.SAFE)
    public boolean hasEnded() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mEnded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.003 -0400", hash_original_method = "073EBA254DBED3B6D4C21030E1884802", hash_generated_method = "0059266E09B6DF87C448763D0C6A211B")
    @DSModeled(DSC.SAFE)
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        dsTaint.addTaint(t.dsTaint);
        dsTaint.addTaint(interpolatedTime);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.003 -0400", hash_original_method = "51B92BC0266A1C2F3581A8B430ACF6F7", hash_generated_method = "4E8E04028913B36AF4A21591E55815BC")
    @DSModeled(DSC.SAFE)
    protected float resolveSize(int type, float value, int size, int parentSize) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(parentSize);
        dsTaint.addTaint(type);
        dsTaint.addTaint(size);
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //switch (type) {
            //case ABSOLUTE:
                //return value;
            //case RELATIVE_TO_SELF:
                //return size * value;
            //case RELATIVE_TO_PARENT:
                //return parentSize * value;
            //default:
                //return value;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.004 -0400", hash_original_method = "CF5E77120A30A36E6B295FA946811571", hash_generated_method = "3395B5F58591363FDEC6808261C5CD49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getInvalidateRegion(int left, int top, int right, int bottom,
            RectF invalidate, Transformation transformation) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(transformation.dsTaint);
        dsTaint.addTaint(invalidate.dsTaint);
        dsTaint.addTaint(top);
        RectF tempRegion;
        tempRegion = mRegion;
        RectF previousRegion;
        previousRegion = mPreviousRegion;
        invalidate.set(left, top, right, bottom);
        transformation.getMatrix().mapRect(invalidate);
        invalidate.inset(-1.0f, -1.0f);
        tempRegion.set(invalidate);
        invalidate.union(previousRegion);
        previousRegion.set(tempRegion);
        Transformation tempTransformation;
        tempTransformation = mTransformation;
        Transformation previousTransformation;
        previousTransformation = mPreviousTransformation;
        tempTransformation.set(transformation);
        transformation.set(previousTransformation);
        previousTransformation.set(tempTransformation);
        // ---------- Original Method ----------
        //final RectF tempRegion = mRegion;
        //final RectF previousRegion = mPreviousRegion;
        //invalidate.set(left, top, right, bottom);
        //transformation.getMatrix().mapRect(invalidate);
        //invalidate.inset(-1.0f, -1.0f);
        //tempRegion.set(invalidate);
        //invalidate.union(previousRegion);
        //previousRegion.set(tempRegion);
        //final Transformation tempTransformation = mTransformation;
        //final Transformation previousTransformation = mPreviousTransformation;
        //tempTransformation.set(transformation);
        //transformation.set(previousTransformation);
        //previousTransformation.set(tempTransformation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.004 -0400", hash_original_method = "CE5BD1162FB4278724A9276A03F0A96A", hash_generated_method = "618F94B2158FF4F235B382D5CCFDD0A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void initializeInvalidateRegion(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        RectF region;
        region = mPreviousRegion;
        region.set(left, top, right, bottom);
        region.inset(-1.0f, -1.0f);
        {
            Transformation previousTransformation;
            previousTransformation = mPreviousTransformation;
            applyTransformation(mInterpolator.getInterpolation(0.0f), previousTransformation);
        } //End block
        // ---------- Original Method ----------
        //final RectF region = mPreviousRegion;
        //region.set(left, top, right, bottom);
        //region.inset(-1.0f, -1.0f);
        //if (mFillBefore) {
            //final Transformation previousTransformation = mPreviousTransformation;
            //applyTransformation(mInterpolator.getInterpolation(0.0f), previousTransformation);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.004 -0400", hash_original_method = "F91EB5DE0AE774B21AEF523039CEDA53", hash_generated_method = "FF262FB1B8FCA7802500418216B369E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() throws Throwable {
        try 
        {
            {
                guard.warnIfOpen();
            } //End block
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (guard != null) {
                //guard.warnIfOpen();
            //}
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.004 -0400", hash_original_method = "00F0E38B38876C14DBBEFF57F3DE3ED9", hash_generated_method = "651A90B3E9C6E3B8B7A5ED87CB9A3370")
    @DSModeled(DSC.SAFE)
    public boolean hasAlpha() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    protected static class Description {
        public int type;
        public float value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.005 -0400", hash_original_method = "13B02809537A9233D3B195627A018956", hash_generated_method = "13B02809537A9233D3B195627A018956")
                public Description ()
        {
        }


                static Description parseValue(TypedValue value) {
            Description d = new Description();
            if (value == null) {
                d.type = ABSOLUTE;
                d.value = 0;
            } else {
                if (value.type == TypedValue.TYPE_FRACTION) {
                    d.type = (value.data & TypedValue.COMPLEX_UNIT_MASK) ==
                            TypedValue.COMPLEX_UNIT_FRACTION_PARENT ?
                                    RELATIVE_TO_PARENT : RELATIVE_TO_SELF;
                    d.value = TypedValue.complexToFloat(value.data);
                    return d;
                } else if (value.type == TypedValue.TYPE_FLOAT) {
                    d.type = ABSOLUTE;
                    d.value = value.getFloat();
                    return d;
                } else if (value.type >= TypedValue.TYPE_FIRST_INT &&
                        value.type <= TypedValue.TYPE_LAST_INT) {
                    d.type = ABSOLUTE;
                    d.value = value.data;
                    return d;
                }
            }
            d.type = ABSOLUTE;
            d.value = 0.0f;
            return d;
        }

        
    }


    
    public static interface AnimationListener {
        
        void onAnimationStart(Animation animation);

        
        void onAnimationEnd(Animation animation);

        
        void onAnimationRepeat(Animation animation);
    }
    
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    public static final int START_ON_FIRST_FRAME = -1;
    public static final int ABSOLUTE = 0;
    public static final int RELATIVE_TO_SELF = 1;
    public static final int RELATIVE_TO_PARENT = 2;
    public static final int ZORDER_NORMAL = 0;
    public static final int ZORDER_TOP = 1;
    public static final int ZORDER_BOTTOM = -1;
    private static final boolean USE_CLOSEGUARD
            = SystemProperties.getBoolean("log.closeguard.Animation", false);
}

