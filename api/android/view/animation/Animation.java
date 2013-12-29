package android.view.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.util.TypedValue;
import dalvik.system.CloseGuard;





public abstract class Animation implements Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.750 -0500", hash_original_field = "417F8E2CBC513720508F8C102EA05FF0", hash_generated_field = "285D35A4B336A34C53955AE44424AC64")

    public static final int INFINITE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.751 -0500", hash_original_field = "7DE78E0FB953C6A3E6F6F966B35CD4A9", hash_generated_field = "9FE7B7E5ED52768DD1C53DC895EC1A0D")

    public static final int RESTART = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.752 -0500", hash_original_field = "8AF1934B0634DCB90851FF627910B42C", hash_generated_field = "6790E6439C0E7615743240DF9A7C010E")

    public static final int REVERSE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.753 -0500", hash_original_field = "D4E42EB1E71DD5D85256B3A55C100190", hash_generated_field = "235BF0C9710820F28A2E28648164C2B7")

    public static final int START_ON_FIRST_FRAME = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.754 -0500", hash_original_field = "5C89E962BC02DAE82FF281F302E83FEB", hash_generated_field = "4BC65DE722DF4CE40D49EFB427E9C12C")

    public static final int ABSOLUTE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.755 -0500", hash_original_field = "FD0817C6A905848E79C7A243F19C9612", hash_generated_field = "2A99BA87ACDDCA9C9FB386FFFB6151EA")

    public static final int RELATIVE_TO_SELF = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.755 -0500", hash_original_field = "6B92A2C5E0FCAB33CDA782C9D1A7A524", hash_generated_field = "39CEF3E15FF6FF8064031A5B0E218AC6")

    public static final int RELATIVE_TO_PARENT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.756 -0500", hash_original_field = "C78A962F9C98B7CF3B564488DDD54EC7", hash_generated_field = "350B866462D7A5796C6E66AE9D7BB305")

    public static final int ZORDER_NORMAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.757 -0500", hash_original_field = "AB6ABAB5829BE2C33188B2A597989F50", hash_generated_field = "63A9791B289181049B87F13C581D3AF7")

    public static final int ZORDER_TOP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.758 -0500", hash_original_field = "45C8E386A62BFF6413DE02DAB63F04BA", hash_generated_field = "6655EB233E0907175F6FC1DFBCF648DD")

    public static final int ZORDER_BOTTOM = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.759 -0500", hash_original_field = "FC18F37F6CE202E9BF34901468BC437A", hash_generated_field = "5160DD832DA627994F79F0E39BF3B141")


    private static final boolean USE_CLOSEGUARD
            = SystemProperties.getBoolean("log.closeguard.Animation", false);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.760 -0500", hash_original_field = "2B949884EB9BE3C788B16B27F6DA2E53", hash_generated_field = "2B949884EB9BE3C788B16B27F6DA2E53")

    boolean mEnded = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.761 -0500", hash_original_field = "5D947BF952E8653BAADEA609028A78F9", hash_generated_field = "5D947BF952E8653BAADEA609028A78F9")

    boolean mStarted = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.762 -0500", hash_original_field = "F5A90569EED95B6137362B9C24B64AD6", hash_generated_field = "F5A90569EED95B6137362B9C24B64AD6")

    boolean mCycleFlip = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.762 -0500", hash_original_field = "D7228C282593CDC77734D668B23541D3", hash_generated_field = "D7228C282593CDC77734D668B23541D3")

    boolean mInitialized = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.764 -0500", hash_original_field = "138DAF4C12E534C03F3D363580B12729", hash_generated_field = "138DAF4C12E534C03F3D363580B12729")

    boolean mFillBefore = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.764 -0500", hash_original_field = "0713D9CEE65AF19CBD303F718622380C", hash_generated_field = "0713D9CEE65AF19CBD303F718622380C")

    boolean mFillAfter = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.765 -0500", hash_original_field = "CD0E2560F62E160B1797BA608E99A525", hash_generated_field = "CD0E2560F62E160B1797BA608E99A525")

    boolean mFillEnabled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.766 -0500", hash_original_field = "81105A88481A5B0AE717E10F26F868BC", hash_generated_field = "81105A88481A5B0AE717E10F26F868BC")

    long mStartTime = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.766 -0500", hash_original_field = "EA2AC6F7F17E9F5AC720129EC7B5A165", hash_generated_field = "EA2AC6F7F17E9F5AC720129EC7B5A165")

    long mStartOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.767 -0500", hash_original_field = "CFDA69B4AD03D72FC4B0627E39231164", hash_generated_field = "CFDA69B4AD03D72FC4B0627E39231164")

    long mDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.768 -0500", hash_original_field = "8CAB60CAF9F0EC867720B208BC5D4CD6", hash_generated_field = "8CAB60CAF9F0EC867720B208BC5D4CD6")

    int mRepeatCount = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.768 -0500", hash_original_field = "0909517ECD26F075EDEABEF3C36497E6", hash_generated_field = "0909517ECD26F075EDEABEF3C36497E6")

    int mRepeated = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.769 -0500", hash_original_field = "496B647F2BFAD8D2A4745DD01043EBB9", hash_generated_field = "496B647F2BFAD8D2A4745DD01043EBB9")

    int mRepeatMode = RESTART;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.769 -0500", hash_original_field = "A1326AE9004157E0812422F0F20CD6F9", hash_generated_field = "A1326AE9004157E0812422F0F20CD6F9")

    Interpolator mInterpolator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.770 -0500", hash_original_field = "A82325198CD06548448A0D3238E6DB44", hash_generated_field = "A82325198CD06548448A0D3238E6DB44")

    AnimationListener mListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.771 -0500", hash_original_field = "8944269C7EC97204FE665AC335B6CA78", hash_generated_field = "388F873F7FDD1B97364C31A2829DAA2F")

    private int mZAdjustment;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.772 -0500", hash_original_field = "9413B7CAD54A5CFB690F08E0547B483E", hash_generated_field = "CC64588E1E08B8E0993874A8A69D251D")

    private int mBackgroundColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.772 -0500", hash_original_field = "E60B535E3DF3732134D1B8BC55E0DD6D", hash_generated_field = "55C0C2A62CD0016DB863EA4C86F92AB3")

    private float mScaleFactor = 1f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.773 -0500", hash_original_field = "5B333B6860C25C8D8C5825D6F41A2C7D", hash_generated_field = "78F07B4146BD29D0652AD1623F0B1A21")

    private boolean mDetachWallpaper = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.774 -0500", hash_original_field = "34F0803CBA0D1BF93F53C9B7DF44DAB6", hash_generated_field = "EB7123F1E56B8FC7DB4670361B61F3BB")


    private boolean mMore = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.774 -0500", hash_original_field = "784A4D6001260A3DDDB7D9385099EDBA", hash_generated_field = "1A1B781F58C47FD588A3C25DEC073F2E")

    private boolean mOneMoreTime = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.776 -0500", hash_original_field = "1281DD848D4CAC286B7C56B469674D23", hash_generated_field = "1281DD848D4CAC286B7C56B469674D23")


    RectF mPreviousRegion = new RectF();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.776 -0500", hash_original_field = "B8EF1E9F1F3FA3BF5EA38E9CC57EEE1D", hash_generated_field = "B8EF1E9F1F3FA3BF5EA38E9CC57EEE1D")

    RectF mRegion = new RectF();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.777 -0500", hash_original_field = "96FFB41D18FE51CA2378656E6B610C99", hash_generated_field = "96FFB41D18FE51CA2378656E6B610C99")

    Transformation mTransformation = new Transformation();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.778 -0500", hash_original_field = "82E7EE1C48131039EC27409DAF0D59C0", hash_generated_field = "82E7EE1C48131039EC27409DAF0D59C0")

    Transformation mPreviousTransformation = new Transformation();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.779 -0500", hash_original_field = "759D7885648499D4F341C13F7C4AA861", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")


    private final CloseGuard guard = CloseGuard.get();

    /**
     * Creates a new animation with a duration of 0ms, the default interpolator, with
     * fillBefore set to true and fillAfter set to false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.780 -0500", hash_original_method = "F5207BDCC3F51BB57C76C57DBA5A0AD4", hash_generated_method = "A0EB6EA81A29ED824D2AB6EBD330F031")
    public Animation() {
        ensureInterpolator();
    }

    /**
     * Creates a new animation whose parameters come from the specified context and
     * attributes set.
     *
     * @param context the application environment
     * @param attrs the set of attributes holding the animation parameters
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.781 -0500", hash_original_method = "325850FA9042895E97F9004576A85DF0", hash_generated_method = "41843917E3308BC46B7F7EF1C7981CFB")
    public Animation(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.Animation);

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

        final int resID = a.getResourceId(com.android.internal.R.styleable.Animation_interpolator, 0);

        a.recycle();

        if (resID > 0) {
            setInterpolator(context, resID);
        }

        ensureInterpolator();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.782 -0500", hash_original_method = "7BC58C079EA752AD7803A7DE0B66531B", hash_generated_method = "A46C39E528811DD8F50726DDD0E7B5CA")
    @Override
protected Animation clone() throws CloneNotSupportedException {
        final Animation animation = (Animation) super.clone();
        animation.mPreviousRegion = new RectF();
        animation.mRegion = new RectF();
        animation.mTransformation = new Transformation();
        animation.mPreviousTransformation = new Transformation();
        return animation;
    }

    /**
     * Reset the initialization state of this animation.
     *
     * @see #initialize(int, int, int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.783 -0500", hash_original_method = "3AB995FAF173BC91AA72FEE328D0BE86", hash_generated_method = "56AD414A6C21BD31F46118253782A6AA")
    public void reset() {
        mPreviousRegion.setEmpty();
        mPreviousTransformation.clear();
        mInitialized = false;
        mCycleFlip = false;
        mRepeated = 0;
        mMore = true;
        mOneMoreTime = true;
    }

    /**
     * Cancel the animation. Cancelling an animation invokes the animation
     * listener, if set, to notify the end of the animation.
     * 
     * If you cancel an animation manually, you must call {@link #reset()}
     * before starting the animation again.
     * 
     * @see #reset() 
     * @see #start() 
     * @see #startNow() 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.783 -0500", hash_original_method = "E313CF9FDC4A243810ECD11633502833", hash_generated_method = "38E190E5AAE374C352F6D43E31DB3DFC")
    public void cancel() {
        if (mStarted && !mEnded) {
            if (mListener != null) mListener.onAnimationEnd(this);
            mEnded = true;
            guard.close();
        }
        // Make sure we move the animation to the end
        mStartTime = Long.MIN_VALUE;
        mMore = mOneMoreTime = false;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.784 -0500", hash_original_method = "BA118FB94C8A2A7F04D6CE25751A9CE0", hash_generated_method = "73A65B340A24CE177EABA6CA85CC9EC0")
    public void detach() {
        if (mStarted && !mEnded) {
            mEnded = true;
            guard.close();
            if (mListener != null) mListener.onAnimationEnd(this);
        }
    }

    /**
     * Whether or not the animation has been initialized.
     *
     * @return Has this animation been initialized.
     * @see #initialize(int, int, int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.785 -0500", hash_original_method = "130A49FBCE1398CCC055AA736C1B7B6D", hash_generated_method = "7D04AE94F2897F57A0C38D3D022CBE7F")
    public boolean isInitialized() {
        return mInitialized;
    }

    /**
     * Initialize this animation with the dimensions of the object being
     * animated as well as the objects parents. (This is to support animation
     * sizes being specifed relative to these dimensions.)
     *
     * <p>Objects that interpret Animations should call this method when
     * the sizes of the object being animated and its parent are known, and
     * before calling {@link #getTransformation}.
     *
     *
     * @param width Width of the object being animated
     * @param height Height of the object being animated
     * @param parentWidth Width of the animated object's parent
     * @param parentHeight Height of the animated object's parent
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.786 -0500", hash_original_method = "9B9AA705D4796FA141302715AF35F1C7", hash_generated_method = "C0BA59E45CAA6D168AE4D85D952D4755")
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        reset();
        mInitialized = true;
    }

    /**
     * Sets the acceleration curve for this animation. The interpolator is loaded as
     * a resource from the specified context.
     *
     * @param context The application environment
     * @param resID The resource identifier of the interpolator to load
     * @attr ref android.R.styleable#Animation_interpolator
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.787 -0500", hash_original_method = "2C6481DDCCEAC913795356C9BF1AF628", hash_generated_method = "BE3242216311F89FBBEC5A97D66A30C9")
    public void setInterpolator(Context context, int resID) {
        setInterpolator(AnimationUtils.loadInterpolator(context, resID));
    }

    /**
     * Sets the acceleration curve for this animation. Defaults to a linear
     * interpolation.
     *
     * @param i The interpolator which defines the acceleration curve
     * @attr ref android.R.styleable#Animation_interpolator
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.787 -0500", hash_original_method = "4EEF3DF2F4BA4D9B865A07AD850625E7", hash_generated_method = "9B5D95C6D52CF58DE3C89639A08894AB")
    public void setInterpolator(Interpolator i) {
        mInterpolator = i;
    }

    /**
     * When this animation should start relative to the start time. This is most
     * useful when composing complex animations using an {@link AnimationSet }
     * where some of the animations components start at different times.
     *
     * @param startOffset When this Animation should start, in milliseconds from
     *                    the start time of the root AnimationSet.
     * @attr ref android.R.styleable#Animation_startOffset
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.788 -0500", hash_original_method = "BF0ACB3E237AAE7044714380D4DED735", hash_generated_method = "5F56E7CC5787995BF0DE06CEBCE5293E")
    public void setStartOffset(long startOffset) {
        mStartOffset = startOffset;
    }

    /**
     * How long this animation should last. The duration cannot be negative.
     * 
     * @param durationMillis Duration in milliseconds
     *
     * @throws java.lang.IllegalArgumentException if the duration is < 0
     *
     * @attr ref android.R.styleable#Animation_duration
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.789 -0500", hash_original_method = "C4FADDE7E113E13802025E54418B7E99", hash_generated_method = "0DE5BF6C734EE0CBAE9EDCCF7A31B7BC")
    public void setDuration(long durationMillis) {
        if (durationMillis < 0) {
            throw new IllegalArgumentException("Animation duration cannot be negative");
        }
        mDuration = durationMillis;
    }

    /**
     * Ensure that the duration that this animation will run is not longer
     * than <var>durationMillis</var>.  In addition to adjusting the duration
     * itself, this ensures that the repeat count also will not make it run
     * longer than the given time.
     * 
     * @param durationMillis The maximum duration the animation is allowed
     * to run.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.790 -0500", hash_original_method = "448C869CF9265A7FCC7AB9AE39BBC12A", hash_generated_method = "1B6855CE74FDD9E751A8670D358BDE7D")
    public void restrictDuration(long durationMillis) {
        // If we start after the duration, then we just won't run.
        if (mStartOffset > durationMillis) {
            mStartOffset = durationMillis;
            mDuration = 0;
            mRepeatCount = 0;
            return;
        }
        
        long dur = mDuration + mStartOffset;
        if (dur > durationMillis) {
            mDuration = durationMillis-mStartOffset;
            dur = durationMillis;
        }
        // If the duration is 0 or less, then we won't run.
        if (mDuration <= 0) {
            mDuration = 0;
            mRepeatCount = 0;
            return;
        }
        // Reduce the number of repeats to keep below the maximum duration.
        // The comparison between mRepeatCount and duration is to catch
        // overflows after multiplying them.
        if (mRepeatCount < 0 || mRepeatCount > durationMillis
                || (dur*mRepeatCount) > durationMillis) {
            // Figure out how many times to do the animation.  Subtract 1 since
            // repeat count is the number of times to repeat so 0 runs once.
            mRepeatCount = (int)(durationMillis/dur) - 1;
            if (mRepeatCount < 0) {
                mRepeatCount = 0;
            }
        }
    }
    
    /**
     * How much to scale the duration by.
     *
     * @param scale The amount to scale the duration.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.791 -0500", hash_original_method = "7B723F7D723B2ADF0E8C91EC6AA68330", hash_generated_method = "724587B7562FC6115F9D75611A033E7B")
    public void scaleCurrentDuration(float scale) {
        mDuration = (long) (mDuration * scale);
        mStartOffset = (long) (mStartOffset * scale);
    }

    /**
     * When this animation should start. When the start time is set to
     * {@link #START_ON_FIRST_FRAME}, the animation will start the first time
     * {@link #getTransformation(long, Transformation)} is invoked. The time passed
     * to this method should be obtained by calling
     * {@link AnimationUtils#currentAnimationTimeMillis()} instead of
     * {@link System#currentTimeMillis()}.
     *
     * @param startTimeMillis the start time in milliseconds
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.791 -0500", hash_original_method = "C5F2E1E5B86432971DA671FBAF722042", hash_generated_method = "1367442DC0E8BEF435895BF3EBFA875E")
    public void setStartTime(long startTimeMillis) {
        mStartTime = startTimeMillis;
        mStarted = mEnded = false;
        mCycleFlip = false;
        mRepeated = 0;
        mMore = true;
    }

    /**
     * Convenience method to start the animation the first time
     * {@link #getTransformation(long, Transformation)} is invoked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.792 -0500", hash_original_method = "95CC5B32D25F554AB1041684F2D9EFB3", hash_generated_method = "EF4028773B7A6B0A0D4DF28465844EB2")
    public void start() {
        setStartTime(-1);
    }

    /**
     * Convenience method to start the animation at the current time in
     * milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.793 -0500", hash_original_method = "66165BC7696DE4F74728FD45F7498148", hash_generated_method = "48CAFEEECB8702DC8B84D7A50668DFAF")
    public void startNow() {
        setStartTime(AnimationUtils.currentAnimationTimeMillis());
    }

    /**
     * Defines what this animation should do when it reaches the end. This
     * setting is applied only when the repeat count is either greater than
     * 0 or {@link #INFINITE}. Defaults to {@link #RESTART}. 
     *
     * @param repeatMode {@link #RESTART} or {@link #REVERSE}
     * @attr ref android.R.styleable#Animation_repeatMode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.794 -0500", hash_original_method = "DDD317A37915E8A65D2BE1E304EF578A", hash_generated_method = "CCA7F75AF93485A9A05519CC0E21F5DD")
    public void setRepeatMode(int repeatMode) {
        mRepeatMode = repeatMode;
    }

    /**
     * Sets how many times the animation should be repeated. If the repeat
     * count is 0, the animation is never repeated. If the repeat count is
     * greater than 0 or {@link #INFINITE}, the repeat mode will be taken
     * into account. The repeat count is 0 by default.
     *
     * @param repeatCount the number of times the animation should be repeated
     * @attr ref android.R.styleable#Animation_repeatCount
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.795 -0500", hash_original_method = "A134D6BEB9FF1047810E15F38A519E7E", hash_generated_method = "34C8A0FFE6904A906F56F967950A9EC1")
    public void setRepeatCount(int repeatCount) {
        if (repeatCount < 0) {
            repeatCount = INFINITE;
        }
        mRepeatCount = repeatCount;
    }

    /**
     * If fillEnabled is true, this animation will apply the value of fillBefore.
     *
     * @return true if the animation will take fillBefore into account
     * @attr ref android.R.styleable#Animation_fillEnabled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.795 -0500", hash_original_method = "99447AF68D215B648170642F948B1397", hash_generated_method = "6C319B38E137910103E25539ACF67B4A")
    public boolean isFillEnabled() {
        return mFillEnabled;
    }

    /**
     * If fillEnabled is true, the animation will apply the value of fillBefore.
     * Otherwise, fillBefore is ignored and the animation
     * transformation is always applied until the animation ends.
     *
     * @param fillEnabled true if the animation should take the value of fillBefore into account
     * @attr ref android.R.styleable#Animation_fillEnabled
     *
     * @see #setFillBefore(boolean)
     * @see #setFillAfter(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.796 -0500", hash_original_method = "FD550D09AAFA6DFC07B09135F2C7B62C", hash_generated_method = "9A45188B06A349CD847C3ECEB7C28382")
    public void setFillEnabled(boolean fillEnabled) {
        mFillEnabled = fillEnabled;
    }

    /**
     * If fillBefore is true, this animation will apply its transformation
     * before the start time of the animation. Defaults to true if
     * {@link #setFillEnabled(boolean)} is not set to true.
     * Note that this applies when using an {@link
     * android.view.animation.AnimationSet AnimationSet} to chain
     * animations. The transformation is not applied before the AnimationSet
     * itself starts.
     *
     * @param fillBefore true if the animation should apply its transformation before it starts
     * @attr ref android.R.styleable#Animation_fillBefore
     *
     * @see #setFillEnabled(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.797 -0500", hash_original_method = "4449C3292A8570D114A58B4E08D55011", hash_generated_method = "54FCC9206042009479E0B001A4D0EF7D")
    public void setFillBefore(boolean fillBefore) {
        mFillBefore = fillBefore;
    }

    /**
     * If fillAfter is true, the transformation that this animation performed
     * will persist when it is finished. Defaults to false if not set.
     * Note that this applies to individual animations and when using an {@link
     * android.view.animation.AnimationSet AnimationSet} to chain
     * animations.
     *
     * @param fillAfter true if the animation should apply its transformation after it ends
     * @attr ref android.R.styleable#Animation_fillAfter
     *
     * @see #setFillEnabled(boolean) 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.798 -0500", hash_original_method = "4CCE59DDFB007D2C725E384A84210333", hash_generated_method = "D067159FD9979BCD4C8DCA55B54D9A6D")
    public void setFillAfter(boolean fillAfter) {
        mFillAfter = fillAfter;
    }

    /**
     * Set the Z ordering mode to use while running the animation.
     * 
     * @param zAdjustment The desired mode, one of {@link #ZORDER_NORMAL},
     * {@link #ZORDER_TOP}, or {@link #ZORDER_BOTTOM}.
     * @attr ref android.R.styleable#Animation_zAdjustment
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.798 -0500", hash_original_method = "B53AFA13C43018FC57757729E8C6F5B9", hash_generated_method = "AB3C12FF0F17BADE8D5F9913A888DFAA")
    public void setZAdjustment(int zAdjustment) {
        mZAdjustment = zAdjustment;
    }
    
    /**
     * Set background behind animation.
     *
     * @param bg The background color.  If 0, no background.  Currently must
     * be black, with any desired alpha level.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.799 -0500", hash_original_method = "5CC3CCDE182714D1D24D814D03E78D72", hash_generated_method = "856F98F135EAD8DE400CB78E3A432635")
    public void setBackgroundColor(int bg) {
        mBackgroundColor = bg;
    }

    /**
     * The scale factor is set by the call to <code>getTransformation</code>. Overrides of 
     * {@link #getTransformation(long, Transformation, float)} will get this value
     * directly. Overrides of {@link #applyTransformation(float, Transformation)} can
     * call this method to get the value.
     * 
     * @return float The scale factor that should be applied to pre-scaled values in
     * an Animation such as the pivot points in {@link ScaleAnimation} and {@link RotateAnimation}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.800 -0500", hash_original_method = "209B3580CB795CD8B9886E8B498D1959", hash_generated_method = "FD28421A9844C6509E5A8CA8EAC32ED5")
    protected float getScaleFactor() {
        return mScaleFactor;
    }

    /**
     * If detachWallpaper is true, and this is a window animation of a window
     * that has a wallpaper background, then the window will be detached from
     * the wallpaper while it runs.  That is, the animation will only be applied
     * to the window, and the wallpaper behind it will remain static.
     *
     * @param detachWallpaper true if the wallpaper should be detached from the animation
     * @attr ref android.R.styleable#Animation_detachWallpaper
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.801 -0500", hash_original_method = "DC51879EADA1EC63F555D590C58841F2", hash_generated_method = "9FEAB3304A65C19B123BA07C272EC884")
    public void setDetachWallpaper(boolean detachWallpaper) {
        mDetachWallpaper = detachWallpaper;
    }

    /**
     * Gets the acceleration curve type for this animation.
     *
     * @return the {@link Interpolator} associated to this animation
     * @attr ref android.R.styleable#Animation_interpolator
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.802 -0500", hash_original_method = "8AA04851FFB5BE49EA5890940035B142", hash_generated_method = "680BC21A34AFF00E6707D9E25D0C0570")
    public Interpolator getInterpolator() {
        return mInterpolator;
    }

    /**
     * When this animation should start. If the animation has not startet yet,
     * this method might return {@link #START_ON_FIRST_FRAME}.
     *
     * @return the time in milliseconds when the animation should start or
     *         {@link #START_ON_FIRST_FRAME}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.802 -0500", hash_original_method = "62DE33F2E1C7C51F234B4CE29FC5DCED", hash_generated_method = "3A12FD646648836565EFD0DB4DBB60DF")
    public long getStartTime() {
        return mStartTime;
    }

    /**
     * How long this animation should last
     *
     * @return the duration in milliseconds of the animation
     * @attr ref android.R.styleable#Animation_duration
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.803 -0500", hash_original_method = "5E13B5E872677B59408FA3E6BB94A9F6", hash_generated_method = "5F80C859A9364DABCB96E2B8240D7C36")
    public long getDuration() {
        return mDuration;
    }

    /**
     * When this animation should start, relative to StartTime
     *
     * @return the start offset in milliseconds
     * @attr ref android.R.styleable#Animation_startOffset
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.804 -0500", hash_original_method = "F15F7E68559FE94D65E8E77E2E4D8AE9", hash_generated_method = "8D97620EF9AD25B7CC0B648BD738E0E0")
    public long getStartOffset() {
        return mStartOffset;
    }

    /**
     * Defines what this animation should do when it reaches the end.
     *
     * @return either one of {@link #REVERSE} or {@link #RESTART}
     * @attr ref android.R.styleable#Animation_repeatMode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.805 -0500", hash_original_method = "081205714C0DCBE8DC8471C6BC7C6458", hash_generated_method = "B3061FB54C6BA1A7788D9CDF2AC798B1")
    public int getRepeatMode() {
        return mRepeatMode;
    }

    /**
     * Defines how many times the animation should repeat. The default value
     * is 0.
     *
     * @return the number of times the animation should repeat, or {@link #INFINITE}
     * @attr ref android.R.styleable#Animation_repeatCount
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.806 -0500", hash_original_method = "4FE747AC8B0667617AE307ECFC6ED74A", hash_generated_method = "33DEC8850621553CE5D2A9983998E6CF")
    public int getRepeatCount() {
        return mRepeatCount;
    }

    /**
     * If fillBefore is true, this animation will apply its transformation
     * before the start time of the animation. If fillBefore is false and
     * {@link #isFillEnabled() fillEnabled} is true, the transformation will not be applied until
     * the start time of the animation.
     *
     * @return true if the animation applies its transformation before it starts
     * @attr ref android.R.styleable#Animation_fillBefore
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.807 -0500", hash_original_method = "EC25BC6D19EE141C12788801543B6178", hash_generated_method = "AA4F011708BF42AAAC91ECB3A2807F6A")
    public boolean getFillBefore() {
        return mFillBefore;
    }

    /**
     * If fillAfter is true, this animation will apply its transformation
     * after the end time of the animation.
     *
     * @return true if the animation applies its transformation after it ends
     * @attr ref android.R.styleable#Animation_fillAfter
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.808 -0500", hash_original_method = "6D667DA3C62337EC4E4606350728AE89", hash_generated_method = "09BE84B4A2936B8492F14C8FC369C28A")
    public boolean getFillAfter() {
        return mFillAfter;
    }

    /**
     * Returns the Z ordering mode to use while running the animation as
     * previously set by {@link #setZAdjustment}.
     * 
     * @return Returns one of {@link #ZORDER_NORMAL},
     * {@link #ZORDER_TOP}, or {@link #ZORDER_BOTTOM}.
     * @attr ref android.R.styleable#Animation_zAdjustment
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.808 -0500", hash_original_method = "409F6F7832CADDC17E7E5231CAA22AC6", hash_generated_method = "484852A752A0545CAD7E76341CAA55FA")
    public int getZAdjustment() {
        return mZAdjustment;
    }

    /**
     * Returns the background color behind the animation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.809 -0500", hash_original_method = "FAF00526A7BA7C979C907792653A05BB", hash_generated_method = "93FF3504BCECBF572F60FE0FB71AC3CF")
    public int getBackgroundColor() {
        return mBackgroundColor;
    }

    /**
     * Return value of {@link #setDetachWallpaper(boolean)}.
     * @attr ref android.R.styleable#Animation_detachWallpaper
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.810 -0500", hash_original_method = "E6A00B836A83DBDC739846B44941121A", hash_generated_method = "000C6EE266D749B0DBB8211EE32D19DF")
    public boolean getDetachWallpaper() {
        return mDetachWallpaper;
    }

    /**
     * <p>Indicates whether or not this animation will affect the transformation
     * matrix. For instance, a fade animation will not affect the matrix whereas
     * a scale animation will.</p>
     *
     * @return true if this animation will change the transformation matrix
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.810 -0500", hash_original_method = "06611FABC5DAE0D86003F0AC94713BBE", hash_generated_method = "8197F30D7537116607A9F65D58AA143E")
    public boolean willChangeTransformationMatrix() {
        // assume we will change the matrix
        return true;
    }

    /**
     * <p>Indicates whether or not this animation will affect the bounds of the
     * animated view. For instance, a fade animation will not affect the bounds
     * whereas a 200% scale animation will.</p>
     *
     * @return true if this animation will change the view's bounds
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.811 -0500", hash_original_method = "75ECA58382FCAFBFF99662736FC361D6", hash_generated_method = "37DB5CBF05A8BDDC1899CC88AF883E83")
    public boolean willChangeBounds() {
        // assume we will change the bounds
        return true;
    }

    /**
     * <p>Binds an animation listener to this animation. The animation listener
     * is notified of animation events such as the end of the animation or the
     * repetition of the animation.</p>
     *
     * @param listener the animation listener to be notified
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.812 -0500", hash_original_method = "93175FBEC8620A1D25367C53936C85B5", hash_generated_method = "31A6529B587BD93A6B444DCD66C155FD")
    public void setAnimationListener(AnimationListener listener) {
        mListener = listener;
    }

    /**
     * Gurantees that this animation has an interpolator. Will use
     * a AccelerateDecelerateInterpolator is nothing else was specified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.813 -0500", hash_original_method = "B0865E74040125EA32BE48261064C937", hash_generated_method = "EEB67997D6D12CE98BE399A4863E3DE2")
    protected void ensureInterpolator() {
        if (mInterpolator == null) {
            mInterpolator = new AccelerateDecelerateInterpolator();
        }
    }

    
    protected static class Description {

        /**
         * Size descriptions can appear inthree forms:
         * <ol>
         * <li>An absolute size. This is represented by a number.</li>
         * <li>A size relative to the size of the object being animated. This
         * is represented by a number followed by "%".</li> *
         * <li>A size relative to the size of the parent of object being
         * animated. This is represented by a number followed by "%p".</li>
         * </ol>
         * @param value The typed value to parse
         * @return The parsed version of the description
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.825 -0500", hash_original_method = "DD44A677B5B9DC6554F1ADD22A249AFD", hash_generated_method = "638A82D9F1A7C39A53D7C396790CF0CD")
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.824 -0500", hash_original_field = "961B4204667A4AE2FF8DD374E6728ADE", hash_generated_field = "6AC5CE4BE311ED1283E9BD812937901E")

        public int type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.824 -0500", hash_original_field = "AFED88F9B46D00F83012B0491FE8482F", hash_generated_field = "D18E7B5EA79EF395F5CA2EA5D5CA9DE3")

        public float value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.744 -0400", hash_original_method = "670F11C8AD1CA46EBC3158EE54497D14", hash_generated_method = "670F11C8AD1CA46EBC3158EE54497D14")
        public Description ()
        {
            //Synthesized constructor
        }

        
    }


    
    public static interface AnimationListener {
        
        void onAnimationStart(Animation animation);

        
        void onAnimationEnd(Animation animation);

        
        void onAnimationRepeat(Animation animation);
    }

    /**
     * Compute a hint at how long the entire animation may last, in milliseconds.
     * Animations can be written to cause themselves to run for a different
     * duration than what is computed here, but generally this should be
     * accurate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.813 -0500", hash_original_method = "B3F1AB6DDEFF92B122293B4363A1C456", hash_generated_method = "218F4F0D841E83DDCED3770CA4EF235B")
    public long computeDurationHint() {
        return (getStartOffset() + getDuration()) * (getRepeatCount() + 1);
    }
    
    /**
     * Gets the transformation to apply at a specified point in time. Implementations of this
     * method should always replace the specified Transformation or document they are doing
     * otherwise.
     *
     * @param currentTime Where we are in the animation. This is wall clock time.
     * @param outTransformation A transformation object that is provided by the
     *        caller and will be filled in by the animation.
     * @return True if the animation is still running
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.815 -0500", hash_original_method = "1D66EEFFAD10DF7675973FFD0CA72C11", hash_generated_method = "AF8652057DAD4A8F9C8E0866DE608D21")
    public boolean getTransformation(long currentTime, Transformation outTransformation) {

        if (mStartTime == -1) {
            mStartTime = currentTime;
        }

        final long startOffset = getStartOffset();
        final long duration = mDuration;
        float normalizedTime;
        if (duration != 0) {
            normalizedTime = ((float) (currentTime - (mStartTime + startOffset))) /
                    (float) duration;
        } else {
            // time is a step-change with a zero duration
            normalizedTime = currentTime < mStartTime ? 0.0f : 1.0f;
        }

        final boolean expired = normalizedTime >= 1.0f;
        mMore = !expired;

        if (!mFillEnabled) normalizedTime = Math.max(Math.min(normalizedTime, 1.0f), 0.0f);

        if ((normalizedTime >= 0.0f || mFillBefore) && (normalizedTime <= 1.0f || mFillAfter)) {
            if (!mStarted) {
                if (mListener != null) {
                    mListener.onAnimationStart(this);
                }
                mStarted = true;
                if (USE_CLOSEGUARD) {
                    guard.open("cancel or detach or getTransformation");
                }
            }

            if (mFillEnabled) normalizedTime = Math.max(Math.min(normalizedTime, 1.0f), 0.0f);

            if (mCycleFlip) {
                normalizedTime = 1.0f - normalizedTime;
            }

            final float interpolatedTime = mInterpolator.getInterpolation(normalizedTime);
            applyTransformation(interpolatedTime, outTransformation);
        }

        if (expired) {
            if (mRepeatCount == mRepeated) {
                if (!mEnded) {
                    mEnded = true;
                    guard.close();
                    if (mListener != null) {
                        mListener.onAnimationEnd(this);
                    }
                }
            } else {
                if (mRepeatCount > 0) {
                    mRepeated++;
                }

                if (mRepeatMode == REVERSE) {
                    mCycleFlip = !mCycleFlip;
                }

                mStartTime = -1;
                mMore = true;

                if (mListener != null) {
                    mListener.onAnimationRepeat(this);
                }
            }
        }

        if (!mMore && mOneMoreTime) {
            mOneMoreTime = false;
            return true;
        }

        return mMore;
    }
    
    /**
     * Gets the transformation to apply at a specified point in time. Implementations of this
     * method should always replace the specified Transformation or document they are doing
     * otherwise.
     *
     * @param currentTime Where we are in the animation. This is wall clock time.
     * @param outTransformation A tranformation object that is provided by the
     *        caller and will be filled in by the animation.
     * @param scale Scaling factor to apply to any inputs to the transform operation, such
     *        pivot points being rotated or scaled around.
     * @return True if the animation is still running
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.815 -0500", hash_original_method = "2D55A6E78A3D329DDFA1835011833D50", hash_generated_method = "BEF4999254C104668FDB8CAEBDD04900")
    public boolean getTransformation(long currentTime, Transformation outTransformation,
            float scale) {
        mScaleFactor = scale;
        return getTransformation(currentTime, outTransformation);
    }

    /**
     * <p>Indicates whether this animation has started or not.</p>
     *
     * @return true if the animation has started, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.816 -0500", hash_original_method = "777CAD815D79C7ADA7276922FB123EB2", hash_generated_method = "29680F04B6CA177231C15349D1DAC7C6")
    public boolean hasStarted() {
        return mStarted;
    }

    /**
     * <p>Indicates whether this animation has ended or not.</p>
     *
     * @return true if the animation has ended, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.817 -0500", hash_original_method = "D01D8338B537AF4FCC0E5AB769C5FB0B", hash_generated_method = "773D01EF8E711AEBA48EABF5103125E0")
    public boolean hasEnded() {
        return mEnded;
    }

    /**
     * Helper for getTransformation. Subclasses should implement this to apply
     * their transforms given an interpolation value.  Implementations of this
     * method should always replace the specified Transformation or document
     * they are doing otherwise.
     * 
     * @param interpolatedTime The value of the normalized time (0.0 to 1.0)
     *        after it has been run through the interpolation function.
     * @param t The Transofrmation object to fill in with the current
     *        transforms.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.818 -0500", hash_original_method = "073EBA254DBED3B6D4C21030E1884802", hash_generated_method = "D6FE7A45FD5E4B9F277EDEFC410B9A03")
    protected void applyTransformation(float interpolatedTime, Transformation t) {
    }

    /**
     * Convert the information in the description of a size to an actual
     * dimension
     *
     * @param type One of Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF, or
     *             Animation.RELATIVE_TO_PARENT.
     * @param value The dimension associated with the type parameter
     * @param size The size of the object being animated
     * @param parentSize The size of the parent of the object being animated
     * @return The dimension to use for the animation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.818 -0500", hash_original_method = "51B92BC0266A1C2F3581A8B430ACF6F7", hash_generated_method = "84FF2D70821B019127875CE5A1E6B242")
    protected float resolveSize(int type, float value, int size, int parentSize) {
        switch (type) {
            case ABSOLUTE:
                return value;
            case RELATIVE_TO_SELF:
                return size * value;
            case RELATIVE_TO_PARENT:
                return parentSize * value;
            default:
                return value;
        }
    }

    /**
     * @param left
     * @param top
     * @param right
     * @param bottom
     * @param invalidate
     * @param transformation
     * 
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.820 -0500", hash_original_method = "CF5E77120A30A36E6B295FA946811571", hash_generated_method = "233BA7BD76EDC6766C0EF1C270B9C185")
    public void getInvalidateRegion(int left, int top, int right, int bottom,
            RectF invalidate, Transformation transformation) {

        final RectF tempRegion = mRegion;
        final RectF previousRegion = mPreviousRegion;

        invalidate.set(left, top, right, bottom);
        transformation.getMatrix().mapRect(invalidate);
        // Enlarge the invalidate region to account for rounding errors
        invalidate.inset(-1.0f, -1.0f);
        tempRegion.set(invalidate);
        invalidate.union(previousRegion);

        previousRegion.set(tempRegion);

        final Transformation tempTransformation = mTransformation;
        final Transformation previousTransformation = mPreviousTransformation;

        tempTransformation.set(transformation);
        transformation.set(previousTransformation);
        previousTransformation.set(tempTransformation);
    }

    /**
     * @param left
     * @param top
     * @param right
     * @param bottom
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.821 -0500", hash_original_method = "CE5BD1162FB4278724A9276A03F0A96A", hash_generated_method = "87E5AE505747DD51A8C50204F665DD6C")
    public void initializeInvalidateRegion(int left, int top, int right, int bottom) {
        final RectF region = mPreviousRegion;
        region.set(left, top, right, bottom);
        // Enlarge the invalidate region to account for rounding errors
        region.inset(-1.0f, -1.0f);
        if (mFillBefore) {
            final Transformation previousTransformation = mPreviousTransformation;
            applyTransformation(mInterpolator.getInterpolation(0.0f), previousTransformation);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.822 -0500", hash_original_method = "F91EB5DE0AE774B21AEF523039CEDA53", hash_generated_method = "1BDDD198ABF893F767F90C68C32D3AB3")
    protected void finalize() throws Throwable {
        try {
            if (guard != null) {
                guard.warnIfOpen();
            }
        } finally {
            super.finalize();
        }
    }

    /**
     * Return true if this animation changes the view's alpha property.
     * 
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.822 -0500", hash_original_method = "00F0E38B38876C14DBBEFF57F3DE3ED9", hash_generated_method = "A7E953EAB38F31E94469E70A0CA9229A")
    public boolean hasAlpha() {
        return false;
    }
}

