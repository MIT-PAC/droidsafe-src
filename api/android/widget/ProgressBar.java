package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.RemotableViewMethod;
import android.view.View;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

import com.android.internal.R;

public class ProgressBar extends View {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.687 -0500", hash_original_field = "1496E1C556157C5FD3FDE79598CDF532", hash_generated_field = "CC7511334507B624E41735D194F6E4E0")

    private static final int MAX_LEVEL = 10000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.689 -0500", hash_original_field = "DE20DBD72E84B094A00D03E5F4058886", hash_generated_field = "39EF70D35A29D206C019E7A12A698D6D")

    private static final int ANIMATION_RESOLUTION = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.692 -0500", hash_original_field = "0A2BB441F836A0A495E0A325BD9EEF0B", hash_generated_field = "81CDC7C9CA9F2EE4E05B25C5A8DB35B0")

    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.693 -0500", hash_original_field = "B5D566AA92521F570066E8773A24B0C0", hash_generated_field = "B5D566AA92521F570066E8773A24B0C0")

    int mMinWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.695 -0500", hash_original_field = "DE6F7D0025A7518849324A9E1601224A", hash_generated_field = "DE6F7D0025A7518849324A9E1601224A")

    int mMaxWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.697 -0500", hash_original_field = "0DD4F81D09F8349C333039CCE34B2CF7", hash_generated_field = "0DD4F81D09F8349C333039CCE34B2CF7")

    int mMinHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.699 -0500", hash_original_field = "2B42F0B48BA5A796B2697835D2F18090", hash_generated_field = "2B42F0B48BA5A796B2697835D2F18090")

    int mMaxHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.702 -0500", hash_original_field = "7CDF5A45863735DC45D655DB7E365343", hash_generated_field = "1CA7BE0C4831604F244183A43ACB7282")

    private int mProgress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.704 -0500", hash_original_field = "58F48CA09A1DEC274EE2E349256BF813", hash_generated_field = "015CFC0D453C8DA6A402F32079F8A6A4")

    private int mSecondaryProgress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.707 -0500", hash_original_field = "643806E929E292CCE314B6AD18027C00", hash_generated_field = "A1BFCC57A6BC96010A1D330EF07F3F34")

    private int mMax;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.709 -0500", hash_original_field = "C0FAA889F27EDA16D523267D3E01AF97", hash_generated_field = "7AB98B3DA8DC606CB1698898E1D5910B")

    private int mBehavior;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.711 -0500", hash_original_field = "BC345057CF9CBE8611DA24E477E3EC27", hash_generated_field = "A658ABE5235D82E385D992CF2A9ACD3B")

    private int mDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.713 -0500", hash_original_field = "0D148F2C69F7B5D4956EFF238B82CCCF", hash_generated_field = "92F2421E00AF2915B64A009A8AEF51CA")

    private boolean mIndeterminate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.715 -0500", hash_original_field = "8D6F8F24BD3E8D16C7D8EDD479BE4D36", hash_generated_field = "C1DA2FED56001BDE5D0AD3FEFBE7FD96")

    private boolean mOnlyIndeterminate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.717 -0500", hash_original_field = "D7452398083A8158EC2258CE710AF169", hash_generated_field = "2643C4FF32FBB404667FBA24AD639E50")

    private Transformation mTransformation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.719 -0500", hash_original_field = "7849FCBAD521645A9FD25D981C5FB3CD", hash_generated_field = "57388EC69EE573DE5E4AF3A536B016D4")

    private AlphaAnimation mAnimation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.721 -0500", hash_original_field = "ACF08658A02B579A46D5805654850485", hash_generated_field = "C689AC3D1D2B848F3E53B0D791A6559F")

    private Drawable mIndeterminateDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.723 -0500", hash_original_field = "5D7F822ED6B0FEE4C7B4B596E0F35534", hash_generated_field = "C7829E00A6912D78CF4DAAA1F03878F2")

    private Drawable mProgressDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.725 -0500", hash_original_field = "F46103DB1FD9DFCD58939843BB73C39E", hash_generated_field = "90CE76B172D180EF24FA84EA783D3205")

    private Drawable mCurrentDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.727 -0500", hash_original_field = "A2E623BE945F90A1659BB6259980C46A", hash_generated_field = "A2E623BE945F90A1659BB6259980C46A")

    Bitmap mSampleTile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.729 -0500", hash_original_field = "EB51415A899B076FAA29104E03FDC65B", hash_generated_field = "CA606DE6031B2AD65CB031A15282E5C0")

    private boolean mNoInvalidate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.732 -0500", hash_original_field = "A1326AE9004157E0812422F0F20CD6F9", hash_generated_field = "67BF1E9EFEC019D28BF77934CF035B72")

    private Interpolator mInterpolator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.734 -0500", hash_original_field = "BA73900692161E788233BDEAE97C3D49", hash_generated_field = "8ACA154D8775441FD3732F1D17C67323")

    private RefreshProgressRunnable mRefreshProgressRunnable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.736 -0500", hash_original_field = "B1BC3A9B57A62980AAB3CDF8C8A1BB60", hash_generated_field = "CD5745C207A6BF8B60FA99DC96FB59AD")

    private long mUiThreadId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.738 -0500", hash_original_field = "CCBAD50B4E2548F835C8997A08B254D3", hash_generated_field = "359DB1662474C9DDA50E3F28F77D23F6")

    private boolean mShouldStartAnimationDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.740 -0500", hash_original_field = "1BD45591A95C9F5C2B8DC0805F99A777", hash_generated_field = "40DA5017CC9E425245C6E3C14B2FC5CA")

    private long mLastDrawTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.742 -0500", hash_original_field = "46DA55E63CE38C818116D2946753B27E", hash_generated_field = "9E34047AEA414B2399121C937D10E14B")

    private boolean mInDrawing;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.744 -0500", hash_original_field = "40BD7E4A5CEBC9065C6EF2B4B6EBD7EB", hash_generated_field = "8CB5D4845E1FC7F9C65B298EDDE9F5B1")

    private int mAnimationResolution;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.747 -0500", hash_original_field = "180082D26693BAEDD31E26CC6F43AC12", hash_generated_field = "F465CD63B02941FD3A08D3CC1E47AC81")

    private AccessibilityEventSender mAccessibilityEventSender;

    /**
     * Create a new progress bar with range 0...100 and initial progress of 0.
     * @param context the application environment
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.750 -0500", hash_original_method = "F5911F61390A242F23F5676C44FA4C61", hash_generated_method = "05E6D4AB511F57E4A865290B84F04FA0")
    
public ProgressBar(Context context) {
        this(context, null);
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.752 -0500", hash_original_method = "D031AA7B7D98D3870546853F1BC5BC9E", hash_generated_method = "47D897E39CB9DA3B5AFB7902ECC9EC16")
    
public ProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.progressBarStyle);
    }

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.755 -0500", hash_original_method = "E1F87E741C36AFFDC636A9ACF6EDF064", hash_generated_method = "DF0BE037724D12B3A67CC8FCB3B2ED9F")
    
public ProgressBar(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, 0);
    }

    /**
     * @hide
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.758 -0500", hash_original_method = "DAE8B382D7288D55BBDECA5C905F6E78", hash_generated_method = "C71F6C764FA9D0B7547017DA6EB5808A")
    
public ProgressBar(Context context, AttributeSet attrs, int defStyle, int styleRes) {
        super(context, attrs, defStyle);
        mUiThreadId = Thread.currentThread().getId();
        initProgressBar();

        TypedArray a =
            context.obtainStyledAttributes(attrs, R.styleable.ProgressBar, defStyle, styleRes);
        
        mNoInvalidate = true;
        
        Drawable drawable = a.getDrawable(R.styleable.ProgressBar_progressDrawable);
        if (drawable != null) {
            drawable = tileify(drawable, false);
            // Calling this method can set mMaxHeight, make sure the corresponding
            // XML attribute for mMaxHeight is read after calling this method
            setProgressDrawable(drawable);
        }

        mDuration = a.getInt(R.styleable.ProgressBar_indeterminateDuration, mDuration);

        mMinWidth = a.getDimensionPixelSize(R.styleable.ProgressBar_minWidth, mMinWidth);
        mMaxWidth = a.getDimensionPixelSize(R.styleable.ProgressBar_maxWidth, mMaxWidth);
        mMinHeight = a.getDimensionPixelSize(R.styleable.ProgressBar_minHeight, mMinHeight);
        mMaxHeight = a.getDimensionPixelSize(R.styleable.ProgressBar_maxHeight, mMaxHeight);

        mBehavior = a.getInt(R.styleable.ProgressBar_indeterminateBehavior, mBehavior);

        final int resID = a.getResourceId(
                com.android.internal.R.styleable.ProgressBar_interpolator, 
                android.R.anim.linear_interpolator); // default to linear interpolator
        if (resID > 0) {
            setInterpolator(context, resID);
        }

        setMax(a.getInt(R.styleable.ProgressBar_max, mMax));

        setProgress(a.getInt(R.styleable.ProgressBar_progress, mProgress));

        setSecondaryProgress(
                a.getInt(R.styleable.ProgressBar_secondaryProgress, mSecondaryProgress));

        drawable = a.getDrawable(R.styleable.ProgressBar_indeterminateDrawable);
        if (drawable != null) {
            drawable = tileifyIndeterminate(drawable);
            setIndeterminateDrawable(drawable);
        }

        mOnlyIndeterminate = a.getBoolean(
                R.styleable.ProgressBar_indeterminateOnly, mOnlyIndeterminate);

        mNoInvalidate = false;

        setIndeterminate(mOnlyIndeterminate || a.getBoolean(
                R.styleable.ProgressBar_indeterminate, mIndeterminate));

        mAnimationResolution = a.getInteger(R.styleable.ProgressBar_animationResolution,
                ANIMATION_RESOLUTION);

        a.recycle();
    }

    /**
     * Converts a drawable to a tiled version of itself. It will recursively
     * traverse layer and state list drawables.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.762 -0500", hash_original_method = "224A1F0FE2A7F3DC81BFFEE36861F394", hash_generated_method = "9798DB3B91AFBFE542192DDF8FB12827")
    
private Drawable tileify(Drawable drawable, boolean clip) {
        
        if (drawable instanceof LayerDrawable) {
            LayerDrawable background = (LayerDrawable) drawable;
            final int N = background.getNumberOfLayers();
            Drawable[] outDrawables = new Drawable[N];
            
            for (int i = 0; i < N; i++) {
                int id = background.getId(i);
                outDrawables[i] = tileify(background.getDrawable(i),
                        (id == R.id.progress || id == R.id.secondaryProgress));
            }

            LayerDrawable newBg = new LayerDrawable(outDrawables);
            
            for (int i = 0; i < N; i++) {
                newBg.setId(i, background.getId(i));
            }
            
            return newBg;
            
        } else if (drawable instanceof StateListDrawable) {
            StateListDrawable in = (StateListDrawable) drawable;
            StateListDrawable out = new StateListDrawable();
            int numStates = in.getStateCount();
            for (int i = 0; i < numStates; i++) {
                out.addState(in.getStateSet(i), tileify(in.getStateDrawable(i), clip));
            }
            return out;
            
        } else if (drawable instanceof BitmapDrawable) {
            final Bitmap tileBitmap = ((BitmapDrawable) drawable).getBitmap();
            if (mSampleTile == null) {
                mSampleTile = tileBitmap;
            }
            
            final ShapeDrawable shapeDrawable = new ShapeDrawable(getDrawableShape());

            final BitmapShader bitmapShader = new BitmapShader(tileBitmap,
                    Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
            shapeDrawable.getPaint().setShader(bitmapShader);

            return (clip) ? new ClipDrawable(shapeDrawable, Gravity.LEFT,
                    ClipDrawable.HORIZONTAL) : shapeDrawable;
        }
        
        return drawable;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.764 -0500", hash_original_method = "066FEFD8810FD39B2288696E8912725B", hash_generated_method = "066FEFD8810FD39B2288696E8912725B")
    
Shape getDrawableShape() {
        final float[] roundedCorners = new float[] { 5, 5, 5, 5, 5, 5, 5, 5 };
        return new RoundRectShape(roundedCorners, null, null);
    }
    
    /**
     * Convert a AnimationDrawable for use as a barberpole animation.
     * Each frame of the animation is wrapped in a ClipDrawable and
     * given a tiling BitmapShader.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.766 -0500", hash_original_method = "9EE7DD01E1AB6B0D269DB58A7544C17D", hash_generated_method = "BFBDCEA5D01AFD36373F651333FF5A41")
    
private Drawable tileifyIndeterminate(Drawable drawable) {
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable background = (AnimationDrawable) drawable;
            final int N = background.getNumberOfFrames();
            AnimationDrawable newBg = new AnimationDrawable();
            newBg.setOneShot(background.isOneShot());
            
            for (int i = 0; i < N; i++) {
                Drawable frame = tileify(background.getFrame(i), true);
                frame.setLevel(10000);
                newBg.addFrame(frame, background.getDuration(i));
            }
            newBg.setLevel(10000);
            drawable = newBg;
        }
        return drawable;
    }
    
    /**
     * <p>
     * Initialize the progress bar's default values:
     * </p>
     * <ul>
     * <li>progress = 0</li>
     * <li>max = 100</li>
     * <li>animation duration = 4000 ms</li>
     * <li>indeterminate = false</li>
     * <li>behavior = repeat</li>
     * </ul>
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.768 -0500", hash_original_method = "E5E4BC7A2B363BE6E2FBD0B5C26F4050", hash_generated_method = "78375C615A16504B3FCA36BE4D985473")
    
private void initProgressBar() {
        mMax = 100;
        mProgress = 0;
        mSecondaryProgress = 0;
        mIndeterminate = false;
        mOnlyIndeterminate = false;
        mDuration = 4000;
        mBehavior = AlphaAnimation.RESTART;
        mMinWidth = 24;
        mMaxWidth = 48;
        mMinHeight = 24;
        mMaxHeight = 48;
    }

    /**
     * <p>Indicate whether this progress bar is in indeterminate mode.</p>
     *
     * @return true if the progress bar is in indeterminate mode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.771 -0500", hash_original_method = "3387FD7633AB5B9FD9EC30B2946E89DA", hash_generated_method = "CC7C9D7D034AACDA4ADC00E28D75104D")
    
@ViewDebug.ExportedProperty(category = "progress")
    public synchronized boolean isIndeterminate() {
        return mIndeterminate;
    }

    /**
     * <p>Change the indeterminate mode for this progress bar. In indeterminate
     * mode, the progress is ignored and the progress bar shows an infinite
     * animation instead.</p>
     * 
     * If this progress bar's style only supports indeterminate mode (such as the circular
     * progress bars), then this will be ignored.
     *
     * @param indeterminate true to enable the indeterminate mode
     */
    @DSComment("ProgressBar")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.774 -0500", hash_original_method = "9BFD2BF2FBC3833B7107C0E363644A89", hash_generated_method = "6C104FE3027AADFF3B4C5EAC70F94A44")
    
@android.view.RemotableViewMethod
    public synchronized void setIndeterminate(boolean indeterminate) {
        if ((!mOnlyIndeterminate || !mIndeterminate) && indeterminate != mIndeterminate) {
            mIndeterminate = indeterminate;

            if (indeterminate) {
                // swap between indeterminate and regular backgrounds
                mCurrentDrawable = mIndeterminateDrawable;
                startAnimation();
            } else {
                mCurrentDrawable = mProgressDrawable;
                stopAnimation();
            }
        }
    }

    /**
     * <p>Get the drawable used to draw the progress bar in
     * indeterminate mode.</p>
     *
     * @return a {@link android.graphics.drawable.Drawable} instance
     *
     * @see #setIndeterminateDrawable(android.graphics.drawable.Drawable)
     * @see #setIndeterminate(boolean)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.776 -0500", hash_original_method = "460B65565106BA0615FD22E30B040519", hash_generated_method = "1D0B7B0BC2B00D07FF81B79AC8D11B88")
    
public Drawable getIndeterminateDrawable() {
        return mIndeterminateDrawable;
    }

    /**
     * <p>Define the drawable used to draw the progress bar in
     * indeterminate mode.</p>
     *
     * @param d the new drawable
     *
     * @see #getIndeterminateDrawable()
     * @see #setIndeterminate(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.779 -0500", hash_original_method = "4CAABA82B88C397ED0E927A2E15C90A0", hash_generated_method = "C9C5FF69EB2FE939BF7A67171571DBF0")
    
public void setIndeterminateDrawable(Drawable d) {
        if (d != null) {
            d.setCallback(this);
        }
        mIndeterminateDrawable = d;
        if (mIndeterminate) {
            mCurrentDrawable = d;
            postInvalidate();
        }
    }
    
    /**
     * <p>Get the drawable used to draw the progress bar in
     * progress mode.</p>
     *
     * @return a {@link android.graphics.drawable.Drawable} instance
     *
     * @see #setProgressDrawable(android.graphics.drawable.Drawable)
     * @see #setIndeterminate(boolean)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.781 -0500", hash_original_method = "6C8C8D805DC88A29293BE605923D5590", hash_generated_method = "4BA7DC49F21214973C9ECF5C6BFE263B")
    
public Drawable getProgressDrawable() {
        return mProgressDrawable;
    }

    /**
     * <p>Define the drawable used to draw the progress bar in
     * progress mode.</p>
     *
     * @param d the new drawable
     *
     * @see #getProgressDrawable()
     * @see #setIndeterminate(boolean)
     */
    @DSComment("ProgressBar")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.783 -0500", hash_original_method = "3733E64362DE34A69671D2EF5503886A", hash_generated_method = "9BE10D26D1E010DAFB36345990CB8E1A")
    
public void setProgressDrawable(Drawable d) {
        boolean needUpdate;
        if (mProgressDrawable != null && d != mProgressDrawable) {
            mProgressDrawable.setCallback(null);
            needUpdate = true;
        } else {
            needUpdate = false;
        }

        if (d != null) {
            d.setCallback(this);

            // Make sure the ProgressBar is always tall enough
            int drawableHeight = d.getMinimumHeight();
            if (mMaxHeight < drawableHeight) {
                mMaxHeight = drawableHeight;
                requestLayout();
            }
        }
        mProgressDrawable = d;
        if (!mIndeterminate) {
            mCurrentDrawable = d;
            postInvalidate();
        }

        if (needUpdate) {
            updateDrawableBounds(getWidth(), getHeight());
            updateDrawableState();
            doRefreshProgress(R.id.progress, mProgress, false, false);
            doRefreshProgress(R.id.secondaryProgress, mSecondaryProgress, false, false);
        }
    }
    
    /**
     * @return The drawable currently used to draw the progress bar
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.785 -0500", hash_original_method = "BC108B758414D6B13292C41A47E0F703", hash_generated_method = "BC108B758414D6B13292C41A47E0F703")
    
Drawable getCurrentDrawable() {
        return mCurrentDrawable;
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.788 -0500", hash_original_method = "56BA1F17FA722E2B64538801F5E2971D", hash_generated_method = "0B02F1DFB62424893F2A6429D2429244")
    
@Override
    protected boolean verifyDrawable(Drawable who) {
        return who == mProgressDrawable || who == mIndeterminateDrawable
                || super.verifyDrawable(who);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.790 -0500", hash_original_method = "7333172C31835F46D838DB3DB892DD55", hash_generated_method = "7B470CE0005216ACBBF68112C34F848E")
    
@Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (mProgressDrawable != null) mProgressDrawable.jumpToCurrentState();
        if (mIndeterminateDrawable != null) mIndeterminateDrawable.jumpToCurrentState();
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.792 -0500", hash_original_method = "9D88EC1BAB8B30E9973F963BD590322C", hash_generated_method = "E638853BDC411A9115DF2C7DD6FAA67E")
    
@Override
    public void postInvalidate() {
        if (!mNoInvalidate) {
            super.postInvalidate();
        }
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.810 -0500", hash_original_method = "10671D93E2F61D98C60CD8288CC260A2", hash_generated_method = "40EC5B38E670A660E34BCF4B038ADA0B")
    
private synchronized void doRefreshProgress(int id, int progress, boolean fromUser,
            boolean callBackToApp) {
        float scale = mMax > 0 ? (float) progress / (float) mMax : 0;
        final Drawable d = mCurrentDrawable;
        if (d != null) {
            Drawable progressDrawable = null;

            if (d instanceof LayerDrawable) {
                progressDrawable = ((LayerDrawable) d).findDrawableByLayerId(id);
            }

            final int level = (int) (scale * MAX_LEVEL);
            (progressDrawable != null ? progressDrawable : d).setLevel(level);
        } else {
            invalidate();
        }
        
        if (callBackToApp && id == R.id.progress) {
            onProgressRefresh(scale, fromUser);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.812 -0500", hash_original_method = "1EE4C81513694B44BBA27F5A11B0191B", hash_generated_method = "1EE4C81513694B44BBA27F5A11B0191B")
    
void onProgressRefresh(float scale, boolean fromUser) {
        if (AccessibilityManager.getInstance(mContext).isEnabled()) {
            scheduleAccessibilityEventSender();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.815 -0500", hash_original_method = "6344B397C965EAD8A2329C40E25F1FFC", hash_generated_method = "F10BD9D23747680E1837588EDF8BD40B")
    
private synchronized void refreshProgress(int id, int progress, boolean fromUser) {
        if (mUiThreadId == Thread.currentThread().getId()) {
            doRefreshProgress(id, progress, fromUser, true);
        } else {
            RefreshProgressRunnable r;
            if (mRefreshProgressRunnable != null) {
                // Use cached RefreshProgressRunnable if available
                r = mRefreshProgressRunnable;
                // Uncache it
                mRefreshProgressRunnable = null;
                r.setup(id, progress, fromUser);
            } else {
                // Make a new one
                r = new RefreshProgressRunnable(id, progress, fromUser);
            }
            post(r);
        }
    }
    
    /**
     * <p>Set the current progress to the specified value. Does not do anything
     * if the progress bar is in indeterminate mode.</p>
     *
     * @param progress the new progress, between 0 and {@link #getMax()}
     *
     * @see #setIndeterminate(boolean)
     * @see #isIndeterminate()
     * @see #getProgress()
     * @see #incrementProgressBy(int) 
     */
    @DSComment("ProgressBar")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.817 -0500", hash_original_method = "E60A634EF77869D698E2255CD3404933", hash_generated_method = "B35794BD35CFE2DAE884F434C5E52CD1")
    
@android.view.RemotableViewMethod
    public synchronized void setProgress(int progress) {
        setProgress(progress, false);
    }
    
    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.821 -0500", hash_original_method = "65EDABD4A3EBF7E0899598C1A747DEC8", hash_generated_method = "A3704F7A1508E702EEC8F03B978F393E")
    
@android.view.RemotableViewMethod
    synchronized void setProgress(int progress, boolean fromUser) {
        if (mIndeterminate) {
            return;
        }

        if (progress < 0) {
            progress = 0;
        }

        if (progress > mMax) {
            progress = mMax;
        }

        if (progress != mProgress) {
            mProgress = progress;
            refreshProgress(R.id.progress, mProgress, fromUser);
        }
    }

    /**
     * <p>
     * Set the current secondary progress to the specified value. Does not do
     * anything if the progress bar is in indeterminate mode.
     * </p>
     * 
     * @param secondaryProgress the new secondary progress, between 0 and {@link #getMax()}
     * @see #setIndeterminate(boolean)
     * @see #isIndeterminate()
     * @see #getSecondaryProgress()
     * @see #incrementSecondaryProgressBy(int)
     */
    @DSComment("ProgressBar")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.823 -0500", hash_original_method = "9F9AE189F8359350B1506E3BE664E8EE", hash_generated_method = "7BC950379A7AD819B2451C593B6C4182")
    
@android.view.RemotableViewMethod
    public synchronized void setSecondaryProgress(int secondaryProgress) {
        if (mIndeterminate) {
            return;
        }

        if (secondaryProgress < 0) {
            secondaryProgress = 0;
        }

        if (secondaryProgress > mMax) {
            secondaryProgress = mMax;
        }

        if (secondaryProgress != mSecondaryProgress) {
            mSecondaryProgress = secondaryProgress;
            refreshProgress(R.id.secondaryProgress, mSecondaryProgress, false);
        }
    }

    /**
     * <p>Get the progress bar's current level of progress. Return 0 when the
     * progress bar is in indeterminate mode.</p>
     *
     * @return the current progress, between 0 and {@link #getMax()}
     *
     * @see #setIndeterminate(boolean)
     * @see #isIndeterminate()
     * @see #setProgress(int)
     * @see #setMax(int)
     * @see #getMax()
     */
    @DSComment("ProgressBar")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.826 -0500", hash_original_method = "BF818051FE207A57D09CC2C24E2066F6", hash_generated_method = "7CF8711369421702779707E12BB7463A")
    
@ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getProgress() {
        return mIndeterminate ? 0 : mProgress;
    }

    /**
     * <p>Get the progress bar's current level of secondary progress. Return 0 when the
     * progress bar is in indeterminate mode.</p>
     *
     * @return the current secondary progress, between 0 and {@link #getMax()}
     *
     * @see #setIndeterminate(boolean)
     * @see #isIndeterminate()
     * @see #setSecondaryProgress(int)
     * @see #setMax(int)
     * @see #getMax()
     */
    @DSComment("ProgressBar")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.828 -0500", hash_original_method = "0E2189FB3CB300C00977FC2C3BDB4D4B", hash_generated_method = "58E4C1CCFC1DD27C3F9337CD2BA5B461")
    
@ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getSecondaryProgress() {
        return mIndeterminate ? 0 : mSecondaryProgress;
    }

    /**
     * <p>Return the upper limit of this progress bar's range.</p>
     *
     * @return a positive integer
     *
     * @see #setMax(int)
     * @see #getProgress()
     * @see #getSecondaryProgress()
     */
    @DSComment("ProgressBar")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.830 -0500", hash_original_method = "6E6A982D82D781B4C4E0B14E6160A2E7", hash_generated_method = "34A3B480BE2CC3F8D98489B2C60467E0")
    
@ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getMax() {
        return mMax;
    }

    /**
     * <p>Set the range of the progress bar to 0...<tt>max</tt>.</p>
     *
     * @param max the upper range of this progress bar
     *
     * @see #getMax()
     * @see #setProgress(int) 
     * @see #setSecondaryProgress(int) 
     */
    @DSComment("ProgressBar")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.833 -0500", hash_original_method = "DB535D9F1C65E31A54636A6B02096562", hash_generated_method = "5F485EFADD9A8E4B9E6B85A84DA8F58E")
    
@android.view.RemotableViewMethod
    public synchronized void setMax(int max) {
        if (max < 0) {
            max = 0;
        }
        if (max != mMax) {
            mMax = max;
            postInvalidate();

            if (mProgress > max) {
                mProgress = max;
            }
            refreshProgress(R.id.progress, mProgress, false);
        }
    }
    
    /**
     * <p>Increase the progress bar's progress by the specified amount.</p>
     *
     * @param diff the amount by which the progress must be increased
     *
     * @see #setProgress(int) 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.835 -0500", hash_original_method = "1E5C167C76FF3FF0E5E9EED4F2394FD5", hash_generated_method = "ECB6544B74373497ABBCEAA760E25BB2")
    
public synchronized final void incrementProgressBy(int diff) {
        setProgress(mProgress + diff);
    }

    /**
     * <p>Increase the progress bar's secondary progress by the specified amount.</p>
     *
     * @param diff the amount by which the secondary progress must be increased
     *
     * @see #setSecondaryProgress(int) 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.838 -0500", hash_original_method = "33F180031B438855CD8341D942A736A2", hash_generated_method = "1822A5BEC7AF261DE838CCCCFB295CA9")
    
public synchronized final void incrementSecondaryProgressBy(int diff) {
        setSecondaryProgress(mSecondaryProgress + diff);
    }

    /**
     * <p>Start the indeterminate progress animation.</p>
     */
    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.840 -0500", hash_original_method = "F5167F20A872A63C36DAF85A2B000FB5", hash_generated_method = "F5167F20A872A63C36DAF85A2B000FB5")
    
void startAnimation() {
        if (getVisibility() != VISIBLE) {
            return;
        }

        if (mIndeterminateDrawable instanceof Animatable) {
            mShouldStartAnimationDrawable = true;
            mAnimation = null;
        } else {
            if (mInterpolator == null) {
                mInterpolator = new LinearInterpolator();
            }
    
            mTransformation = new Transformation();
            mAnimation = new AlphaAnimation(0.0f, 1.0f);
            mAnimation.setRepeatMode(mBehavior);
            mAnimation.setRepeatCount(Animation.INFINITE);
            mAnimation.setDuration(mDuration);
            mAnimation.setInterpolator(mInterpolator);
            mAnimation.setStartTime(Animation.START_ON_FIRST_FRAME);
        }
        postInvalidate();
    }

    /**
     * <p>Stop the indeterminate progress animation.</p>
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.842 -0500", hash_original_method = "3AFE1BBA347326120AD78BEE94F7B2A6", hash_generated_method = "3AFE1BBA347326120AD78BEE94F7B2A6")
    
void stopAnimation() {
        mAnimation = null;
        mTransformation = null;
        if (mIndeterminateDrawable instanceof Animatable) {
            ((Animatable) mIndeterminateDrawable).stop();
            mShouldStartAnimationDrawable = false;
        }
        postInvalidate();
    }

    /**
     * Sets the acceleration curve for the indeterminate animation.
     * The interpolator is loaded as a resource from the specified context.
     *
     * @param context The application environment
     * @param resID The resource identifier of the interpolator to load
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.844 -0500", hash_original_method = "2C6481DDCCEAC913795356C9BF1AF628", hash_generated_method = "BE3242216311F89FBBEC5A97D66A30C9")
    
public void setInterpolator(Context context, int resID) {
        setInterpolator(AnimationUtils.loadInterpolator(context, resID));
    }

    /**
     * Sets the acceleration curve for the indeterminate animation.
     * Defaults to a linear interpolation.
     *
     * @param interpolator The interpolator which defines the acceleration curve
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.846 -0500", hash_original_method = "7D5A9A852D608ADF508B994526BF9EAC", hash_generated_method = "DF8FD2546DF08BADAB224E60C1A6C2B9")
    
public void setInterpolator(Interpolator interpolator) {
        mInterpolator = interpolator;
    }

    /**
     * Gets the acceleration curve type for the indeterminate animation.
     *
     * @return the {@link Interpolator} associated to this animation
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.848 -0500", hash_original_method = "8AA04851FFB5BE49EA5890940035B142", hash_generated_method = "680BC21A34AFF00E6707D9E25D0C0570")
    
public Interpolator getInterpolator() {
        return mInterpolator;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.852 -0500", hash_original_method = "EC8B18EE88EE8E09369A36DBF52DF684", hash_generated_method = "39E0006847B6ED0F90C17C5E24442D20")
    
@Override
    @RemotableViewMethod
    public void setVisibility(int v) {
        if (getVisibility() != v) {
            super.setVisibility(v);

            if (mIndeterminate) {
                // let's be nice with the UI thread
                if (v == GONE || v == INVISIBLE) {
                    stopAnimation();
                } else {
                    startAnimation();
                }
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.854 -0500", hash_original_method = "E937F441086D9A40C4DA651781180A92", hash_generated_method = "1ED71813CAE5A0C16DA256492B8D334A")
    
@Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);

        if (mIndeterminate) {
            // let's be nice with the UI thread
            if (visibility == GONE || visibility == INVISIBLE) {
                stopAnimation();
            } else {
                startAnimation();
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.856 -0500", hash_original_method = "51F010448C03C2EA1E2B7053B0DCB7DE", hash_generated_method = "A8F117221FFD11320EFD837F3BB6AAAA")
    
@Override
    public void invalidateDrawable(Drawable dr) {
        if (!mInDrawing) {
            if (verifyDrawable(dr)) {
                final Rect dirty = dr.getBounds();
                final int scrollX = mScrollX + mPaddingLeft;
                final int scrollY = mScrollY + mPaddingTop;

                invalidate(dirty.left + scrollX, dirty.top + scrollY,
                        dirty.right + scrollX, dirty.bottom + scrollY);
            } else {
                super.invalidateDrawable(dr);
            }
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.859 -0500", hash_original_method = "74277B895F883AA5B2EB254A27C149C7", hash_generated_method = "3284679464233C18FD5B82A395A1FF64")
    
@Override
    public int getResolvedLayoutDirection(Drawable who) {
        return (who == mProgressDrawable || who == mIndeterminateDrawable) ?
            getResolvedLayoutDirection() : super.getResolvedLayoutDirection(who);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.861 -0500", hash_original_method = "69EE8DE1AB95A9498391F63C2C373DBD", hash_generated_method = "5CA0B0F09A03F7EA0410163A47798DB8")
    
@Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        updateDrawableBounds(w, h);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.863 -0500", hash_original_method = "EA480A5BB3C1237E93332F6C8EE84591", hash_generated_method = "23BFC8FF9086DAA4E8425857EEAE0014")
    
private void updateDrawableBounds(int w, int h) {
        // onDraw will translate the canvas so we draw starting at 0,0
        int right = w - mPaddingRight - mPaddingLeft;
        int bottom = h - mPaddingBottom - mPaddingTop;
        int top = 0;
        int left = 0;

        if (mIndeterminateDrawable != null) {
            // Aspect ratio logic does not apply to AnimationDrawables
            if (mOnlyIndeterminate && !(mIndeterminateDrawable instanceof AnimationDrawable)) {
                // Maintain aspect ratio. Certain kinds of animated drawables
                // get very confused otherwise.
                final int intrinsicWidth = mIndeterminateDrawable.getIntrinsicWidth();
                final int intrinsicHeight = mIndeterminateDrawable.getIntrinsicHeight();
                final float intrinsicAspect = (float) intrinsicWidth / intrinsicHeight;
                final float boundAspect = (float) w / h;
                if (intrinsicAspect != boundAspect) {
                    if (boundAspect > intrinsicAspect) {
                        // New width is larger. Make it smaller to match height.
                        final int width = (int) (h * intrinsicAspect);
                        left = (w - width) / 2;
                        right = left + width;
                    } else {
                        // New height is larger. Make it smaller to match width.
                        final int height = (int) (w * (1 / intrinsicAspect));
                        top = (h - height) / 2;
                        bottom = top + height;
                    }
                }
            }
            mIndeterminateDrawable.setBounds(left, top, right, bottom);
        }
        
        if (mProgressDrawable != null) {
            mProgressDrawable.setBounds(0, 0, right, bottom);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.867 -0500", hash_original_method = "16CD7BB578E96B322FC9201A377B65CC", hash_generated_method = "5590632EA0B2148C381E50563857A5F0")
    
@Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Drawable d = mCurrentDrawable;
        if (d != null) {
            // Translate canvas so a indeterminate circular progress bar with padding
            // rotates properly in its animation
            canvas.save();
            canvas.translate(mPaddingLeft, mPaddingTop);
            long time = getDrawingTime();
            if (mAnimation != null) {
                mAnimation.getTransformation(time, mTransformation);
                float scale = mTransformation.getAlpha();
                try {
                    mInDrawing = true;
                    d.setLevel((int) (scale * MAX_LEVEL));
                } finally {
                    mInDrawing = false;
                }
                if (SystemClock.uptimeMillis() - mLastDrawTime >= mAnimationResolution) {
                    mLastDrawTime = SystemClock.uptimeMillis();
                    postInvalidateDelayed(mAnimationResolution);
                }
            }
            d.draw(canvas);
            canvas.restore();
            if (mShouldStartAnimationDrawable && d instanceof Animatable) {
                ((Animatable) d).start();
                mShouldStartAnimationDrawable = false;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.870 -0500", hash_original_method = "6FFAE46060D92EDBE1BD141B1F5C353A", hash_generated_method = "E909015B17FDF605B5E62DA973B3CD74")
    
@Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable d = mCurrentDrawable;

        int dw = 0;
        int dh = 0;
        if (d != null) {
            dw = Math.max(mMinWidth, Math.min(mMaxWidth, d.getIntrinsicWidth()));
            dh = Math.max(mMinHeight, Math.min(mMaxHeight, d.getIntrinsicHeight()));
        }
        updateDrawableState();
        dw += mPaddingLeft + mPaddingRight;
        dh += mPaddingTop + mPaddingBottom;

        setMeasuredDimension(resolveSizeAndState(dw, widthMeasureSpec, 0),
                resolveSizeAndState(dh, heightMeasureSpec, 0));
    }
    
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.872 -0500", hash_original_method = "568F14E497668D52F70AE96AA5EB6F88", hash_generated_method = "4EB57F8B143863A87C550D037C073C6C")
    
@Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        updateDrawableState();
    }
        
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.874 -0500", hash_original_method = "952B851172F804A1D432AC87BADE94E9", hash_generated_method = "539E58DB3A2F5D873F38DF27B1746999")
    
private void updateDrawableState() {
        int[] state = getDrawableState();
        
        if (mProgressDrawable != null && mProgressDrawable.isStateful()) {
            mProgressDrawable.setState(state);
        }
        
        if (mIndeterminateDrawable != null && mIndeterminateDrawable.isStateful()) {
            mIndeterminateDrawable.setState(state);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.899 -0500", hash_original_method = "875308A47ADC87038CC9E153A4D8FE71", hash_generated_method = "C5A52986289D68811DA77A5BE28BE018")
    
@Override
    public Parcelable onSaveInstanceState() {
        // Force our ancestor class to save its state
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        
        ss.progress = mProgress;
        ss.secondaryProgress = mSecondaryProgress;
        
        return ss;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.901 -0500", hash_original_method = "A42CFAF758710477BAC4A7B2A0C98761", hash_generated_method = "36920F3704EEF8E261868AE4CB4E618B")
    
@Override
    public void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        
        setProgress(ss.progress);
        setSecondaryProgress(ss.secondaryProgress);
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.904 -0500", hash_original_method = "608AE3D8DA74959AA8F2204845C7317D", hash_generated_method = "7F5751066C42C755413048DCB414803C")
    
@Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mIndeterminate) {
            startAnimation();
        }
    }
    
    private class RefreshProgressRunnable implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.795 -0500", hash_original_field = "9F66E723E60E4F10157FDA7C23C67293", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

        private int mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.797 -0500", hash_original_field = "7CDF5A45863735DC45D655DB7E365343", hash_generated_field = "1CA7BE0C4831604F244183A43ACB7282")

        private int mProgress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.799 -0500", hash_original_field = "77B4B6EFDD4C9DA9B5E0BF53A9ADE143", hash_generated_field = "E56F4B776FFB7A387D61A7DB69ED27F1")

        private boolean mFromUser;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.802 -0500", hash_original_method = "84E6436ACAD7BA9E1C46F86F0883DFAC", hash_generated_method = "84E6436ACAD7BA9E1C46F86F0883DFAC")
        
RefreshProgressRunnable(int id, int progress, boolean fromUser) {
            mId = id;
            mProgress = progress;
            mFromUser = fromUser;
        }
        
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.804 -0500", hash_original_method = "336F21C38B52B9E04C9FE91372F32949", hash_generated_method = "83B3C867EB5837D082466162CAA6717E")
        
public void run() {
            doRefreshProgress(mId, mProgress, mFromUser, true);
            // Put ourselves back in the cache when we are done
            mRefreshProgressRunnable = this;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.807 -0500", hash_original_method = "992C4D927E51E72BEA0F4017381D8EC2", hash_generated_method = "A64417E0DF270DD8F2AAD21272258DF8")
        
public void setup(int id, int progress, boolean fromUser) {
            mId = id;
            mProgress = progress;
            mFromUser = fromUser;
        }
        
    }
    
    static class SavedState extends BaseSavedState {
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.097 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.890 -0500", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "C97AA17CB243756458D0FB7A2D786EA0")
            
public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.892 -0500", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "020465B62F970B98C266AF229149E391")
            
public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.877 -0500", hash_original_field = "0E86867788D9F180E816D58F2E5188C6", hash_generated_field = "0E86867788D9F180E816D58F2E5188C6")

        int progress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.879 -0500", hash_original_field = "1F6D1EA8F68E49AFD9E30D4EFB3F6276", hash_generated_field = "1F6D1EA8F68E49AFD9E30D4EFB3F6276")

        int secondaryProgress;
        
        /**
         * Constructor called from {@link ProgressBar#onSaveInstanceState()}
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.881 -0500", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "89EB4EC154F05BF905ECA8E02BBD14BC")
        
SavedState(Parcelable superState) {
            super(superState);
        }
        
        /**
         * Constructor called from {@link #CREATOR}
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.884 -0500", hash_original_method = "9D61E8AE00F16C0432FB33E15078B080", hash_generated_method = "3ADD61C80BF0DBEDD59C385D5BA2738C")
        
private SavedState(Parcel in) {
            super(in);
            progress = in.readInt();
            secondaryProgress = in.readInt();
        }

        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.886 -0500", hash_original_method = "47949C0C27B3FB6F61C4F76D6E851E0A", hash_generated_method = "9A232E27C99C90AF353AD363FA55D1D0")
        
@Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(progress);
            out.writeInt(secondaryProgress);
        }
        // orphaned legacy method
        public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }
        
        // orphaned legacy method
        public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        
    }
    
    private class AccessibilityEventSender implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.097 -0400", hash_original_method = "5812CBDC5E0171D8BC07CE56DB600368", hash_generated_method = "5812CBDC5E0171D8BC07CE56DB600368")
        public AccessibilityEventSender ()
        {
            //Synthesized constructor
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.913 -0500", hash_original_method = "D171B097136E37DF343D32BCCA8935F6", hash_generated_method = "130DDEE72B6AB9E862C8FF6D8AE65536")
        
public void run() {
            sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        }
        
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.906 -0500", hash_original_method = "3E30480EE15E7D073BA14A1FE62DC464", hash_generated_method = "6A2E3120A45F5AF406553365915C1EE8")
    
@Override
    protected void onDetachedFromWindow() {
        if (mIndeterminate) {
            stopAnimation();
        }
        if(mRefreshProgressRunnable != null) {
            removeCallbacks(mRefreshProgressRunnable);
        }
        if (mAccessibilityEventSender != null) {
            removeCallbacks(mAccessibilityEventSender);
        }
        // This should come after stopAnimation(), otherwise an invalidate message remains in the
        // queue, which can prevent the entire view hierarchy from being GC'ed during a rotation
        super.onDetachedFromWindow();
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.908 -0500", hash_original_method = "D1990D7DB1A5D8E4C14ADC3323533C4A", hash_generated_method = "B202A0D1F99F962057E80705738AC863")
    
@Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setItemCount(mMax);
        event.setCurrentItemIndex(mProgress);
    }

    /**
     * Schedule a command for sending an accessibility event.
     * </br>
     * Note: A command is used to ensure that accessibility events
     *       are sent at most one in a given time frame to save
     *       system resources while the progress changes quickly.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.911 -0500", hash_original_method = "20F0DBCD6142D6C8A8DBD6A9085999AF", hash_generated_method = "0E30A3D2BAE76CBBDF9F9F5237802C23")
    
private void scheduleAccessibilityEventSender() {
        if (mAccessibilityEventSender == null) {
            mAccessibilityEventSender = new AccessibilityEventSender();
        } else {
            removeCallbacks(mAccessibilityEventSender);
        }
        postDelayed(mAccessibilityEventSender, TIMEOUT_SEND_ACCESSIBILITY_EVENT);
    }
}

