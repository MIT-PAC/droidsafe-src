package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.util.TypedValue;
import dalvik.system.CloseGuard;

public abstract class Animation implements Cloneable {
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
    private final CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.834 -0400", hash_original_method = "F5207BDCC3F51BB57C76C57DBA5A0AD4", hash_generated_method = "287001EC021ADE16A2485C58686622E3")
    @DSModeled(DSC.SAFE)
    public Animation() {
        ensureInterpolator();
        // ---------- Original Method ----------
        //ensureInterpolator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.834 -0400", hash_original_method = "325850FA9042895E97F9004576A85DF0", hash_generated_method = "C694798475492607D87E06D184BD4C3B")
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
        final int resID;
        resID = a.getResourceId(com.android.internal.R.styleable.Animation_interpolator, 0);
        a.recycle();
        {
            setInterpolator(context, resID);
        } //End block
        ensureInterpolator();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.834 -0400", hash_original_method = "7BC58C079EA752AD7803A7DE0B66531B", hash_generated_method = "B22630987A6A6DC0749EDB141DB3694B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected Animation clone() throws CloneNotSupportedException {
        final Animation animation;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.835 -0400", hash_original_method = "3AB995FAF173BC91AA72FEE328D0BE86", hash_generated_method = "D583A21262948941273050C0F73A940F")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.835 -0400", hash_original_method = "E313CF9FDC4A243810ECD11633502833", hash_generated_method = "A450E4494BC2B6784EF7501528877C5C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.835 -0400", hash_original_method = "BA118FB94C8A2A7F04D6CE25751A9CE0", hash_generated_method = "A1932C50D0DCC14965B84287CD7B3B52")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.835 -0400", hash_original_method = "130A49FBCE1398CCC055AA736C1B7B6D", hash_generated_method = "AC0B2A392B87B3C9D78108BC6CD26A74")
    @DSModeled(DSC.SAFE)
    public boolean isInitialized() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mInitialized;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.835 -0400", hash_original_method = "9B9AA705D4796FA141302715AF35F1C7", hash_generated_method = "813D32CB8CDD5AC98F38889004F76C5D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.835 -0400", hash_original_method = "2C6481DDCCEAC913795356C9BF1AF628", hash_generated_method = "084DD1A175B4A57CD663847655FA277E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInterpolator(Context context, int resID) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(resID);
        setInterpolator(AnimationUtils.loadInterpolator(context, resID));
        // ---------- Original Method ----------
        //setInterpolator(AnimationUtils.loadInterpolator(context, resID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.835 -0400", hash_original_method = "4EEF3DF2F4BA4D9B865A07AD850625E7", hash_generated_method = "3368E4033B06F5959061810EE31B0375")
    @DSModeled(DSC.SAFE)
    public void setInterpolator(Interpolator i) {
        dsTaint.addTaint(i.dsTaint);
        // ---------- Original Method ----------
        //mInterpolator = i;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.835 -0400", hash_original_method = "BF0ACB3E237AAE7044714380D4DED735", hash_generated_method = "F8EEC6ABDA295D096F7862D4E74D17F9")
    @DSModeled(DSC.SAFE)
    public void setStartOffset(long startOffset) {
        dsTaint.addTaint(startOffset);
        // ---------- Original Method ----------
        //mStartOffset = startOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.835 -0400", hash_original_method = "C4FADDE7E113E13802025E54418B7E99", hash_generated_method = "3BA11B61F74AF8518284F8EEEC8BD9F4")
    @DSModeled(DSC.SAFE)
    public void setDuration(long durationMillis) {
        dsTaint.addTaint(durationMillis);
        {
            throw new IllegalArgumentException("Animation duration cannot be negative");
        } //End block
        // ---------- Original Method ----------
        //if (durationMillis < 0) {
            //throw new IllegalArgumentException("Animation duration cannot be negative");
        //}
        //mDuration = durationMillis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.836 -0400", hash_original_method = "448C869CF9265A7FCC7AB9AE39BBC12A", hash_generated_method = "69CB652E7FABA23961AF975B5466A382")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.836 -0400", hash_original_method = "7B723F7D723B2ADF0E8C91EC6AA68330", hash_generated_method = "8C7A2D237E80031D969D43337D6A0A81")
    @DSModeled(DSC.SAFE)
    public void scaleCurrentDuration(float scale) {
        dsTaint.addTaint(scale);
        mDuration = (long) (mDuration * scale);
        mStartOffset = (long) (mStartOffset * scale);
        // ---------- Original Method ----------
        //mDuration = (long) (mDuration * scale);
        //mStartOffset = (long) (mStartOffset * scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.836 -0400", hash_original_method = "C5F2E1E5B86432971DA671FBAF722042", hash_generated_method = "C3D439ECA48EAA3315065FC6E7A93939")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.836 -0400", hash_original_method = "95CC5B32D25F554AB1041684F2D9EFB3", hash_generated_method = "2EB1D5A54325F4BB9A2C4BE4D53C42DC")
    @DSModeled(DSC.SAFE)
    public void start() {
        setStartTime(-1);
        // ---------- Original Method ----------
        //setStartTime(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.836 -0400", hash_original_method = "66165BC7696DE4F74728FD45F7498148", hash_generated_method = "AA302B915902BF9F45AFA63E91F0CD53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startNow() {
        setStartTime(AnimationUtils.currentAnimationTimeMillis());
        // ---------- Original Method ----------
        //setStartTime(AnimationUtils.currentAnimationTimeMillis());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.836 -0400", hash_original_method = "DDD317A37915E8A65D2BE1E304EF578A", hash_generated_method = "96C0F09B64D4A59F9292559815A4AB8B")
    @DSModeled(DSC.SAFE)
    public void setRepeatMode(int repeatMode) {
        dsTaint.addTaint(repeatMode);
        // ---------- Original Method ----------
        //mRepeatMode = repeatMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.836 -0400", hash_original_method = "A134D6BEB9FF1047810E15F38A519E7E", hash_generated_method = "EA432506D42B61F3BDF4E2D3EB1048A8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.836 -0400", hash_original_method = "99447AF68D215B648170642F948B1397", hash_generated_method = "A2DBCAD386C967A6D4A1EF269F3095B4")
    @DSModeled(DSC.SAFE)
    public boolean isFillEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFillEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.836 -0400", hash_original_method = "FD550D09AAFA6DFC07B09135F2C7B62C", hash_generated_method = "7BE72732721B08504824B94F16BC8338")
    @DSModeled(DSC.SAFE)
    public void setFillEnabled(boolean fillEnabled) {
        dsTaint.addTaint(fillEnabled);
        // ---------- Original Method ----------
        //mFillEnabled = fillEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.836 -0400", hash_original_method = "4449C3292A8570D114A58B4E08D55011", hash_generated_method = "9B468C477C703645E0F400938105A2BA")
    @DSModeled(DSC.SAFE)
    public void setFillBefore(boolean fillBefore) {
        dsTaint.addTaint(fillBefore);
        // ---------- Original Method ----------
        //mFillBefore = fillBefore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.836 -0400", hash_original_method = "4CCE59DDFB007D2C725E384A84210333", hash_generated_method = "894C036CF3152D5F748E7BC83272EB2A")
    @DSModeled(DSC.SAFE)
    public void setFillAfter(boolean fillAfter) {
        dsTaint.addTaint(fillAfter);
        // ---------- Original Method ----------
        //mFillAfter = fillAfter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.836 -0400", hash_original_method = "B53AFA13C43018FC57757729E8C6F5B9", hash_generated_method = "C0F110D2220DEEDB3D31809819A27112")
    @DSModeled(DSC.SAFE)
    public void setZAdjustment(int zAdjustment) {
        dsTaint.addTaint(zAdjustment);
        // ---------- Original Method ----------
        //mZAdjustment = zAdjustment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.836 -0400", hash_original_method = "5CC3CCDE182714D1D24D814D03E78D72", hash_generated_method = "7F97B0CAA16F5A1CB911999DD6D82E21")
    @DSModeled(DSC.SAFE)
    public void setBackgroundColor(int bg) {
        dsTaint.addTaint(bg);
        // ---------- Original Method ----------
        //mBackgroundColor = bg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.837 -0400", hash_original_method = "209B3580CB795CD8B9886E8B498D1959", hash_generated_method = "407267920B9422C4985507555011BBB1")
    @DSModeled(DSC.SAFE)
    protected float getScaleFactor() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mScaleFactor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.837 -0400", hash_original_method = "DC51879EADA1EC63F555D590C58841F2", hash_generated_method = "5CE375F0C56DC98FABF4B0BE5418DD2D")
    @DSModeled(DSC.SAFE)
    public void setDetachWallpaper(boolean detachWallpaper) {
        dsTaint.addTaint(detachWallpaper);
        // ---------- Original Method ----------
        //mDetachWallpaper = detachWallpaper;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.837 -0400", hash_original_method = "8AA04851FFB5BE49EA5890940035B142", hash_generated_method = "68BD8EAF0EBFDD77CF24F1750A8A54DC")
    @DSModeled(DSC.SAFE)
    public Interpolator getInterpolator() {
        return (Interpolator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.837 -0400", hash_original_method = "62DE33F2E1C7C51F234B4CE29FC5DCED", hash_generated_method = "74EBA9E9E9AA7DFE0DA7D6747E542E94")
    @DSModeled(DSC.SAFE)
    public long getStartTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mStartTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.837 -0400", hash_original_method = "5E13B5E872677B59408FA3E6BB94A9F6", hash_generated_method = "CC1748C13DCF52AEDCB67D067F246B6A")
    @DSModeled(DSC.SAFE)
    public long getDuration() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.837 -0400", hash_original_method = "F15F7E68559FE94D65E8E77E2E4D8AE9", hash_generated_method = "B610A8246E363942F17024A5CCC3A716")
    @DSModeled(DSC.SAFE)
    public long getStartOffset() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mStartOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.837 -0400", hash_original_method = "081205714C0DCBE8DC8471C6BC7C6458", hash_generated_method = "CD811FE5C081CE38D3580811FC20E9F1")
    @DSModeled(DSC.SAFE)
    public int getRepeatMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRepeatMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.837 -0400", hash_original_method = "4FE747AC8B0667617AE307ECFC6ED74A", hash_generated_method = "53F7F4F4884825675C175C68ADA5AA45")
    @DSModeled(DSC.SAFE)
    public int getRepeatCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRepeatCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.837 -0400", hash_original_method = "EC25BC6D19EE141C12788801543B6178", hash_generated_method = "67D28A483892D900E1D27CB0ADEE7E2B")
    @DSModeled(DSC.SAFE)
    public boolean getFillBefore() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFillBefore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.837 -0400", hash_original_method = "6D667DA3C62337EC4E4606350728AE89", hash_generated_method = "661743D382FA6C2F7217464E1D2B0686")
    @DSModeled(DSC.SAFE)
    public boolean getFillAfter() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFillAfter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.837 -0400", hash_original_method = "409F6F7832CADDC17E7E5231CAA22AC6", hash_generated_method = "F8BA2EA6E7D4083F0EEDB1E3F9FBFBF3")
    @DSModeled(DSC.SAFE)
    public int getZAdjustment() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mZAdjustment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.837 -0400", hash_original_method = "FAF00526A7BA7C979C907792653A05BB", hash_generated_method = "F2BDF46A0F93F2E9292E17D363CE14C7")
    @DSModeled(DSC.SAFE)
    public int getBackgroundColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBackgroundColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.837 -0400", hash_original_method = "E6A00B836A83DBDC739846B44941121A", hash_generated_method = "D995534082ADB93890571AEB77620D75")
    @DSModeled(DSC.SAFE)
    public boolean getDetachWallpaper() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDetachWallpaper;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.837 -0400", hash_original_method = "06611FABC5DAE0D86003F0AC94713BBE", hash_generated_method = "A4160ECEEDA26D33503B438ADB808A74")
    @DSModeled(DSC.SAFE)
    public boolean willChangeTransformationMatrix() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.837 -0400", hash_original_method = "75ECA58382FCAFBFF99662736FC361D6", hash_generated_method = "D17C7973C4F8A7D6EAC42AB93FBC1485")
    @DSModeled(DSC.SAFE)
    public boolean willChangeBounds() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.838 -0400", hash_original_method = "93175FBEC8620A1D25367C53936C85B5", hash_generated_method = "E66473ED0C66B5051BE72EF7905CC279")
    @DSModeled(DSC.SAFE)
    public void setAnimationListener(AnimationListener listener) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.838 -0400", hash_original_method = "B0865E74040125EA32BE48261064C937", hash_generated_method = "668DF076B0FB2118EB5B04D9E5DBE5AB")
    @DSModeled(DSC.SAFE)
    protected void ensureInterpolator() {
        {
            mInterpolator = new AccelerateDecelerateInterpolator();
        } //End block
        // ---------- Original Method ----------
        //if (mInterpolator == null) {
            //mInterpolator = new AccelerateDecelerateInterpolator();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.838 -0400", hash_original_method = "B3F1AB6DDEFF92B122293B4363A1C456", hash_generated_method = "D58138BBE828CC01DA4A3ECE2A6D5666")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long computeDurationHint() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        long varABD0FCA997F16598E25E81E01A20B151_608152194 = ((getStartOffset() + getDuration()) * (getRepeatCount() + 1));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return (getStartOffset() + getDuration()) * (getRepeatCount() + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.838 -0400", hash_original_method = "1D66EEFFAD10DF7675973FFD0CA72C11", hash_generated_method = "10540C3DCFE122171D8D7B81D9B08859")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getTransformation(long currentTime, Transformation outTransformation) {
        dsTaint.addTaint(currentTime);
        dsTaint.addTaint(outTransformation.dsTaint);
        final long startOffset;
        startOffset = getStartOffset();
        final long duration;
        duration = mDuration;
        float normalizedTime;
        {
            normalizedTime = ((float) (currentTime - (mStartTime + startOffset))) /
                    (float) duration;
        } //End block
        {
            normalizedTime = currentTime < mStartTime ? 0.0f : 1.0f;
        } //End block
        final boolean expired;
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
            final float interpolatedTime;
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
                    mRepeated++;
                } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.838 -0400", hash_original_method = "2D55A6E78A3D329DDFA1835011833D50", hash_generated_method = "54C5E36205776A9E0B26123D7E40CFE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getTransformation(long currentTime, Transformation outTransformation,
            float scale) {
        dsTaint.addTaint(currentTime);
        dsTaint.addTaint(scale);
        dsTaint.addTaint(outTransformation.dsTaint);
        boolean var0C8BADD9759052F94EFF38E8FDC1128E_1266993842 = (getTransformation(currentTime, outTransformation));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mScaleFactor = scale;
        //return getTransformation(currentTime, outTransformation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.838 -0400", hash_original_method = "777CAD815D79C7ADA7276922FB123EB2", hash_generated_method = "1F14FEFAC46E51986E85FB8A3C4704C6")
    @DSModeled(DSC.SAFE)
    public boolean hasStarted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mStarted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.839 -0400", hash_original_method = "D01D8338B537AF4FCC0E5AB769C5FB0B", hash_generated_method = "B14A9FCAD9696868216972397879D18E")
    @DSModeled(DSC.SAFE)
    public boolean hasEnded() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mEnded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.839 -0400", hash_original_method = "073EBA254DBED3B6D4C21030E1884802", hash_generated_method = "994990140892CAD653F2BF5448CEDDC3")
    @DSModeled(DSC.SAFE)
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        dsTaint.addTaint(t.dsTaint);
        dsTaint.addTaint(interpolatedTime);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.839 -0400", hash_original_method = "51B92BC0266A1C2F3581A8B430ACF6F7", hash_generated_method = "AD138D35B34718F04FE98AD0955529E5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.839 -0400", hash_original_method = "CF5E77120A30A36E6B295FA946811571", hash_generated_method = "B66DA3AA7EFDD155E07910204C7DCFC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getInvalidateRegion(int left, int top, int right, int bottom,
            RectF invalidate, Transformation transformation) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(invalidate.dsTaint);
        dsTaint.addTaint(transformation.dsTaint);
        dsTaint.addTaint(top);
        final RectF tempRegion;
        tempRegion = mRegion;
        final RectF previousRegion;
        previousRegion = mPreviousRegion;
        invalidate.set(left, top, right, bottom);
        transformation.getMatrix().mapRect(invalidate);
        invalidate.inset(-1.0f, -1.0f);
        tempRegion.set(invalidate);
        invalidate.union(previousRegion);
        previousRegion.set(tempRegion);
        final Transformation tempTransformation;
        tempTransformation = mTransformation;
        final Transformation previousTransformation;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.839 -0400", hash_original_method = "CE5BD1162FB4278724A9276A03F0A96A", hash_generated_method = "7B423030241412E343663B9183A5108C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void initializeInvalidateRegion(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        final RectF region;
        region = mPreviousRegion;
        region.set(left, top, right, bottom);
        region.inset(-1.0f, -1.0f);
        {
            final Transformation previousTransformation;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.839 -0400", hash_original_method = "F91EB5DE0AE774B21AEF523039CEDA53", hash_generated_method = "ED5038F1351C31124F9C3F8F68032949")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.839 -0400", hash_original_method = "00F0E38B38876C14DBBEFF57F3DE3ED9", hash_generated_method = "5BC59289D6112FD74594497E50B195D9")
    @DSModeled(DSC.SAFE)
    public boolean hasAlpha() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    protected static class Description {
        public int type;
        public float value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.839 -0400", hash_original_method = "DD44A677B5B9DC6554F1ADD22A249AFD", hash_generated_method = "638A82D9F1A7C39A53D7C396790CF0CD")
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
    
}


