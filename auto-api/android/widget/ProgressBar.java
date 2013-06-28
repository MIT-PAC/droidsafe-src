package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.R;
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
import android.widget.RemoteViews.RemoteView;

public class ProgressBar extends View {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "2FB832D2671571BF4EC0C84F8DA6AA79", hash_generated_field = "B5D566AA92521F570066E8773A24B0C0")

    int mMinWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "C4C548A58212673838506E3498DE25A0", hash_generated_field = "DE6F7D0025A7518849324A9E1601224A")

    int mMaxWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "7B1C5936E045E46CDC7DE29B76B9E7F4", hash_generated_field = "0DD4F81D09F8349C333039CCE34B2CF7")

    int mMinHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "C16CF8950AAD7E5F5E8D168AA605278E", hash_generated_field = "2B42F0B48BA5A796B2697835D2F18090")

    int mMaxHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "8E57A1AD458E8C11842F6CF5D7E06883", hash_generated_field = "1CA7BE0C4831604F244183A43ACB7282")

    private int mProgress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "DCB5EA0939620CFCFDDC71F603D69A41", hash_generated_field = "015CFC0D453C8DA6A402F32079F8A6A4")

    private int mSecondaryProgress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "C886C6FF92A43B3F6833B7BAFD354FBA", hash_generated_field = "A1BFCC57A6BC96010A1D330EF07F3F34")

    private int mMax;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "BB93BD926EB6205F05262D1B23379817", hash_generated_field = "7AB98B3DA8DC606CB1698898E1D5910B")

    private int mBehavior;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "A658ABE5235D82E385D992CF2A9ACD3B")

    private int mDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "066BD2341E290903C1ACFDCFA38A9B44", hash_generated_field = "92F2421E00AF2915B64A009A8AEF51CA")

    private boolean mIndeterminate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "58B7B5409BF4F16770CC1AE1C446A910", hash_generated_field = "C1DA2FED56001BDE5D0AD3FEFBE7FD96")

    private boolean mOnlyIndeterminate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "BBDAB2FB373D7DA19760B893D5429B4A", hash_generated_field = "2643C4FF32FBB404667FBA24AD639E50")

    private Transformation mTransformation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "9A46FC3BA66487AE56C5DCE37D0AA79A", hash_generated_field = "57388EC69EE573DE5E4AF3A536B016D4")

    private AlphaAnimation mAnimation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "081CE0D8134A29404CF8CC8A86F7E0F6", hash_generated_field = "C689AC3D1D2B848F3E53B0D791A6559F")

    private Drawable mIndeterminateDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "35ACEA7B06E4E9292BB05774C2312E1C", hash_generated_field = "C7829E00A6912D78CF4DAAA1F03878F2")

    private Drawable mProgressDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "0E46DF6A99A9DBE87718B5F45A249DE6", hash_generated_field = "90CE76B172D180EF24FA84EA783D3205")

    private Drawable mCurrentDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "2E25EACC73788D7925D059F96D8B9B72", hash_generated_field = "A2E623BE945F90A1659BB6259980C46A")

    Bitmap mSampleTile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "3E924E5B9A794C4409F638A71AD282E8", hash_generated_field = "CA606DE6031B2AD65CB031A15282E5C0")

    private boolean mNoInvalidate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "DA3E6FC5A778B3C344EE09B26563FD22", hash_generated_field = "67BF1E9EFEC019D28BF77934CF035B72")

    private Interpolator mInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "2FAEA616A753C70642294CC7860EC666", hash_generated_field = "8ACA154D8775441FD3732F1D17C67323")

    private RefreshProgressRunnable mRefreshProgressRunnable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "D043A3546110D688BA4F6DE20B99A0A1", hash_generated_field = "CD5745C207A6BF8B60FA99DC96FB59AD")

    private long mUiThreadId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "98A2EDCF2A73027C9055FD1BBD0348FA", hash_generated_field = "359DB1662474C9DDA50E3F28F77D23F6")

    private boolean mShouldStartAnimationDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "D73042AA4B83CBB5EDFF85839968BC9A", hash_generated_field = "40DA5017CC9E425245C6E3C14B2FC5CA")

    private long mLastDrawTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "C435AC5CE20BC8410E8D96F6C5A01644", hash_generated_field = "9E34047AEA414B2399121C937D10E14B")

    private boolean mInDrawing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "90A80CF25193B8AF1E55FB872DDAB330", hash_generated_field = "8CB5D4845E1FC7F9C65B298EDDE9F5B1")

    private int mAnimationResolution;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.588 -0400", hash_original_field = "51B0402D7E1CC15169466C294C4EA35D", hash_generated_field = "F465CD63B02941FD3A08D3CC1E47AC81")

    private AccessibilityEventSender mAccessibilityEventSender;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.589 -0400", hash_original_method = "F5911F61390A242F23F5676C44FA4C61", hash_generated_method = "661AE0288A8718D3E63F42C49E8AB855")
    public  ProgressBar(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.589 -0400", hash_original_method = "D031AA7B7D98D3870546853F1BC5BC9E", hash_generated_method = "A8E7A369DA66D876032DE8087DBF4DF3")
    public  ProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.progressBarStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.589 -0400", hash_original_method = "E1F87E741C36AFFDC636A9ACF6EDF064", hash_generated_method = "76DB2251068B1E1F0468620944E99DFE")
    public  ProgressBar(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.591 -0400", hash_original_method = "DAE8B382D7288D55BBDECA5C905F6E78", hash_generated_method = "5528CADAD0351631110197B023137898")
    public  ProgressBar(Context context, AttributeSet attrs, int defStyle, int styleRes) {
        super(context, attrs, defStyle);
        mUiThreadId = Thread.currentThread().getId();
        initProgressBar();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ProgressBar, defStyle, styleRes);
        mNoInvalidate = true;
        Drawable drawable = a.getDrawable(R.styleable.ProgressBar_progressDrawable);
        {
            drawable = tileify(drawable, false);
            setProgressDrawable(drawable);
        } //End block
        mDuration = a.getInt(R.styleable.ProgressBar_indeterminateDuration, mDuration);
        mMinWidth = a.getDimensionPixelSize(R.styleable.ProgressBar_minWidth, mMinWidth);
        mMaxWidth = a.getDimensionPixelSize(R.styleable.ProgressBar_maxWidth, mMaxWidth);
        mMinHeight = a.getDimensionPixelSize(R.styleable.ProgressBar_minHeight, mMinHeight);
        mMaxHeight = a.getDimensionPixelSize(R.styleable.ProgressBar_maxHeight, mMaxHeight);
        mBehavior = a.getInt(R.styleable.ProgressBar_indeterminateBehavior, mBehavior);
        final int resID = a.getResourceId(
                com.android.internal.R.styleable.ProgressBar_interpolator, 
                android.R.anim.linear_interpolator);
        {
            setInterpolator(context, resID);
        } //End block
        setMax(a.getInt(R.styleable.ProgressBar_max, mMax));
        setProgress(a.getInt(R.styleable.ProgressBar_progress, mProgress));
        setSecondaryProgress(
                a.getInt(R.styleable.ProgressBar_secondaryProgress, mSecondaryProgress));
        drawable = a.getDrawable(R.styleable.ProgressBar_indeterminateDrawable);
        {
            drawable = tileifyIndeterminate(drawable);
            setIndeterminateDrawable(drawable);
        } //End block
        mOnlyIndeterminate = a.getBoolean(
                R.styleable.ProgressBar_indeterminateOnly, mOnlyIndeterminate);
        mNoInvalidate = false;
        setIndeterminate(mOnlyIndeterminate || a.getBoolean(
                R.styleable.ProgressBar_indeterminate, mIndeterminate));
        mAnimationResolution = a.getInteger(R.styleable.ProgressBar_animationResolution,
                ANIMATION_RESOLUTION);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        addTaint(styleRes);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.592 -0400", hash_original_method = "224A1F0FE2A7F3DC81BFFEE36861F394", hash_generated_method = "E591B6433A0F29D777BF28D5A096D18F")
    private Drawable tileify(Drawable drawable, boolean clip) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_394708039 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1527177451 = null; //Variable for return #2
        Drawable varB4EAC82CA7396A68D541C85D26508E83_741098834 = null; //Variable for return #3
        Drawable varB4EAC82CA7396A68D541C85D26508E83_936617915 = null; //Variable for return #4
        {
            LayerDrawable background = (LayerDrawable) drawable;
            final int N = background.getNumberOfLayers();
            Drawable[] outDrawables = new Drawable[N];
            {
                int i = 0;
                {
                    int id = background.getId(i);
                    outDrawables[i] = tileify(background.getDrawable(i),
                        (id == R.id.progress || id == R.id.secondaryProgress));
                } //End block
            } //End collapsed parenthetic
            LayerDrawable newBg = new LayerDrawable(outDrawables);
            {
                int i = 0;
                {
                    newBg.setId(i, background.getId(i));
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_394708039 = newBg;
        } //End block
        {
            StateListDrawable in = (StateListDrawable) drawable;
            StateListDrawable out = new StateListDrawable();
            int numStates = in.getStateCount();
            {
                int i = 0;
                {
                    out.addState(in.getStateSet(i), tileify(in.getStateDrawable(i), clip));
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1527177451 = out;
        } //End block
        {
            final Bitmap tileBitmap = ((BitmapDrawable) drawable).getBitmap();
            {
                mSampleTile = tileBitmap;
            } //End block
            final ShapeDrawable shapeDrawable = new ShapeDrawable(getDrawableShape());
            final BitmapShader bitmapShader = new BitmapShader(tileBitmap,
                    Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
            shapeDrawable.getPaint().setShader(bitmapShader);
            varB4EAC82CA7396A68D541C85D26508E83_741098834 = (clip) ? new ClipDrawable(shapeDrawable, Gravity.LEFT,
                    ClipDrawable.HORIZONTAL) : shapeDrawable;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_936617915 = drawable;
        addTaint(drawable.getTaint());
        addTaint(clip);
        Drawable varA7E53CE21691AB073D9660D615818899_1216096989; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1216096989 = varB4EAC82CA7396A68D541C85D26508E83_394708039;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1216096989 = varB4EAC82CA7396A68D541C85D26508E83_1527177451;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1216096989 = varB4EAC82CA7396A68D541C85D26508E83_741098834;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1216096989 = varB4EAC82CA7396A68D541C85D26508E83_936617915;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1216096989.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1216096989;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.593 -0400", hash_original_method = "066FEFD8810FD39B2288696E8912725B", hash_generated_method = "2EDD7DFCBEC5B41A10752AC27AE46B21")
     Shape getDrawableShape() {
        Shape varB4EAC82CA7396A68D541C85D26508E83_890976875 = null; //Variable for return #1
        final float[] roundedCorners = new float[] { 5, 5, 5, 5, 5, 5, 5, 5 };
        varB4EAC82CA7396A68D541C85D26508E83_890976875 = new RoundRectShape(roundedCorners, null, null);
        varB4EAC82CA7396A68D541C85D26508E83_890976875.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_890976875;
        // ---------- Original Method ----------
        //final float[] roundedCorners = new float[] { 5, 5, 5, 5, 5, 5, 5, 5 };
        //return new RoundRectShape(roundedCorners, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.594 -0400", hash_original_method = "9EE7DD01E1AB6B0D269DB58A7544C17D", hash_generated_method = "265A010A4B9CBE9E24984591B4C7B745")
    private Drawable tileifyIndeterminate(Drawable drawable) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_43481441 = null; //Variable for return #1
        {
            AnimationDrawable background = (AnimationDrawable) drawable;
            final int N = background.getNumberOfFrames();
            AnimationDrawable newBg = new AnimationDrawable();
            newBg.setOneShot(background.isOneShot());
            {
                int i = 0;
                {
                    Drawable frame = tileify(background.getFrame(i), true);
                    frame.setLevel(10000);
                    newBg.addFrame(frame, background.getDuration(i));
                } //End block
            } //End collapsed parenthetic
            newBg.setLevel(10000);
            drawable = newBg;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_43481441 = drawable;
        addTaint(drawable.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_43481441.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_43481441;
        // ---------- Original Method ----------
        //if (drawable instanceof AnimationDrawable) {
            //AnimationDrawable background = (AnimationDrawable) drawable;
            //final int N = background.getNumberOfFrames();
            //AnimationDrawable newBg = new AnimationDrawable();
            //newBg.setOneShot(background.isOneShot());
            //for (int i = 0; i < N; i++) {
                //Drawable frame = tileify(background.getFrame(i), true);
                //frame.setLevel(10000);
                //newBg.addFrame(frame, background.getDuration(i));
            //}
            //newBg.setLevel(10000);
            //drawable = newBg;
        //}
        //return drawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.594 -0400", hash_original_method = "E5E4BC7A2B363BE6E2FBD0B5C26F4050", hash_generated_method = "8DA820DB7B007C068BE9D230A5110A34")
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
        // ---------- Original Method ----------
        //mMax = 100;
        //mProgress = 0;
        //mSecondaryProgress = 0;
        //mIndeterminate = false;
        //mOnlyIndeterminate = false;
        //mDuration = 4000;
        //mBehavior = AlphaAnimation.RESTART;
        //mMinWidth = 24;
        //mMaxWidth = 48;
        //mMinHeight = 24;
        //mMaxHeight = 48;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.595 -0400", hash_original_method = "3387FD7633AB5B9FD9EC30B2946E89DA", hash_generated_method = "3A4665BBFE070CB69AD5C68728A615EF")
    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized boolean isIndeterminate() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_96715609 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_96715609;
        // ---------- Original Method ----------
        //return mIndeterminate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.595 -0400", hash_original_method = "9BFD2BF2FBC3833B7107C0E363644A89", hash_generated_method = "4854AAE2DD0D6EDB71325523F4E5E2D0")
    @android.view.RemotableViewMethod
    public synchronized void setIndeterminate(boolean indeterminate) {
        {
            mIndeterminate = indeterminate;
            {
                mCurrentDrawable = mIndeterminateDrawable;
                startAnimation();
            } //End block
            {
                mCurrentDrawable = mProgressDrawable;
                stopAnimation();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if ((!mOnlyIndeterminate || !mIndeterminate) && indeterminate != mIndeterminate) {
            //mIndeterminate = indeterminate;
            //if (indeterminate) {
                //mCurrentDrawable = mIndeterminateDrawable;
                //startAnimation();
            //} else {
                //mCurrentDrawable = mProgressDrawable;
                //stopAnimation();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.596 -0400", hash_original_method = "460B65565106BA0615FD22E30B040519", hash_generated_method = "5797C2CE34036CF7CD0BD3CC350E9391")
    public Drawable getIndeterminateDrawable() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1199923706 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1199923706 = mIndeterminateDrawable;
        varB4EAC82CA7396A68D541C85D26508E83_1199923706.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1199923706;
        // ---------- Original Method ----------
        //return mIndeterminateDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.596 -0400", hash_original_method = "4CAABA82B88C397ED0E927A2E15C90A0", hash_generated_method = "88F78C6CB7EF4734A7FEDCF67EFC9A18")
    public void setIndeterminateDrawable(Drawable d) {
        {
            d.setCallback(this);
        } //End block
        mIndeterminateDrawable = d;
        {
            mCurrentDrawable = d;
            postInvalidate();
        } //End block
        // ---------- Original Method ----------
        //if (d != null) {
            //d.setCallback(this);
        //}
        //mIndeterminateDrawable = d;
        //if (mIndeterminate) {
            //mCurrentDrawable = d;
            //postInvalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.596 -0400", hash_original_method = "6C8C8D805DC88A29293BE605923D5590", hash_generated_method = "231D1443A0E6E8821EC3D838B9BDE5CA")
    public Drawable getProgressDrawable() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_670353992 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_670353992 = mProgressDrawable;
        varB4EAC82CA7396A68D541C85D26508E83_670353992.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_670353992;
        // ---------- Original Method ----------
        //return mProgressDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.597 -0400", hash_original_method = "3733E64362DE34A69671D2EF5503886A", hash_generated_method = "81AB497770C3000F9F4DEFF963049294")
    public void setProgressDrawable(Drawable d) {
        boolean needUpdate;
        {
            mProgressDrawable.setCallback(null);
            needUpdate = true;
        } //End block
        {
            needUpdate = false;
        } //End block
        {
            d.setCallback(this);
            int drawableHeight = d.getMinimumHeight();
            {
                mMaxHeight = drawableHeight;
                requestLayout();
            } //End block
        } //End block
        mProgressDrawable = d;
        {
            mCurrentDrawable = d;
            postInvalidate();
        } //End block
        {
            updateDrawableBounds(getWidth(), getHeight());
            updateDrawableState();
            doRefreshProgress(R.id.progress, mProgress, false, false);
            doRefreshProgress(R.id.secondaryProgress, mSecondaryProgress, false, false);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.597 -0400", hash_original_method = "BC108B758414D6B13292C41A47E0F703", hash_generated_method = "FF0390842AE779B1F7A7646C8AAA37AE")
     Drawable getCurrentDrawable() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_527005955 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_527005955 = mCurrentDrawable;
        varB4EAC82CA7396A68D541C85D26508E83_527005955.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_527005955;
        // ---------- Original Method ----------
        //return mCurrentDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.598 -0400", hash_original_method = "56BA1F17FA722E2B64538801F5E2971D", hash_generated_method = "E089780B46ECFD86A5DE0BC064CC03C0")
    @Override
    protected boolean verifyDrawable(Drawable who) {
        boolean var5B9EE4C74328F86B7CFFFC48CC55DAFD_874233169 = (who == mProgressDrawable || who == mIndeterminateDrawable
                || super.verifyDrawable(who));
        addTaint(who.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_297623942 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_297623942;
        // ---------- Original Method ----------
        //return who == mProgressDrawable || who == mIndeterminateDrawable
                //|| super.verifyDrawable(who);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.598 -0400", hash_original_method = "7333172C31835F46D838DB3DB892DD55", hash_generated_method = "787AD68239E9E5B97EC1726229EFB8B1")
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        mProgressDrawable.jumpToCurrentState();
        mIndeterminateDrawable.jumpToCurrentState();
        // ---------- Original Method ----------
        //super.jumpDrawablesToCurrentState();
        //if (mProgressDrawable != null) mProgressDrawable.jumpToCurrentState();
        //if (mIndeterminateDrawable != null) mIndeterminateDrawable.jumpToCurrentState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.598 -0400", hash_original_method = "9D88EC1BAB8B30E9973F963BD590322C", hash_generated_method = "E90B41141854785CFB2802E07DE0408A")
    @Override
    public void postInvalidate() {
        {
            super.postInvalidate();
        } //End block
        // ---------- Original Method ----------
        //if (!mNoInvalidate) {
            //super.postInvalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.599 -0400", hash_original_method = "10671D93E2F61D98C60CD8288CC260A2", hash_generated_method = "BA87D8094187D0DAEE0FC8A4401846FE")
    private synchronized void doRefreshProgress(int id, int progress, boolean fromUser,
            boolean callBackToApp) {
        float scale;
        scale = (float) progress / (float) mMax;
        scale = 0;
        final Drawable d = mCurrentDrawable;
        {
            Drawable progressDrawable = null;
            {
                progressDrawable = ((LayerDrawable) d).findDrawableByLayerId(id);
            } //End block
            final int level = (int) (scale * MAX_LEVEL);
            (progressDrawable != null ? progressDrawable : d).setLevel(level);
        } //End block
        {
            invalidate();
        } //End block
        {
            onProgressRefresh(scale, fromUser);
        } //End block
        addTaint(id);
        addTaint(progress);
        addTaint(fromUser);
        addTaint(callBackToApp);
        // ---------- Original Method ----------
        //float scale = mMax > 0 ? (float) progress / (float) mMax : 0;
        //final Drawable d = mCurrentDrawable;
        //if (d != null) {
            //Drawable progressDrawable = null;
            //if (d instanceof LayerDrawable) {
                //progressDrawable = ((LayerDrawable) d).findDrawableByLayerId(id);
            //}
            //final int level = (int) (scale * MAX_LEVEL);
            //(progressDrawable != null ? progressDrawable : d).setLevel(level);
        //} else {
            //invalidate();
        //}
        //if (callBackToApp && id == R.id.progress) {
            //onProgressRefresh(scale, fromUser);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.599 -0400", hash_original_method = "1EE4C81513694B44BBA27F5A11B0191B", hash_generated_method = "4F2B6B5802E41B81F7FF990FCFBAC227")
     void onProgressRefresh(float scale, boolean fromUser) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varFEF5E81D9E4B252970529F0E4C094F45_1723004738 = (AccessibilityManager.getInstance(mContext).isEnabled());
            {
                scheduleAccessibilityEventSender();
            } //End block
        } //End collapsed parenthetic
        addTaint(scale);
        addTaint(fromUser);
        // ---------- Original Method ----------
        //if (AccessibilityManager.getInstance(mContext).isEnabled()) {
            //scheduleAccessibilityEventSender();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.600 -0400", hash_original_method = "6344B397C965EAD8A2329C40E25F1FFC", hash_generated_method = "C22629DF161D2C49FA006DC226082661")
    private synchronized void refreshProgress(int id, int progress, boolean fromUser) {
        {
            boolean var1CC5D58891D5AD9A5F4B0AE57801D9FB_795841342 = (mUiThreadId == Thread.currentThread().getId());
            {
                doRefreshProgress(id, progress, fromUser, true);
            } //End block
            {
                RefreshProgressRunnable r;
                {
                    r = mRefreshProgressRunnable;
                    mRefreshProgressRunnable = null;
                    r.setup(id, progress, fromUser);
                } //End block
                {
                    r = new RefreshProgressRunnable(id, progress, fromUser);
                } //End block
                post(r);
            } //End block
        } //End collapsed parenthetic
        addTaint(id);
        addTaint(progress);
        addTaint(fromUser);
        // ---------- Original Method ----------
        //if (mUiThreadId == Thread.currentThread().getId()) {
            //doRefreshProgress(id, progress, fromUser, true);
        //} else {
            //RefreshProgressRunnable r;
            //if (mRefreshProgressRunnable != null) {
                //r = mRefreshProgressRunnable;
                //mRefreshProgressRunnable = null;
                //r.setup(id, progress, fromUser);
            //} else {
                //r = new RefreshProgressRunnable(id, progress, fromUser);
            //}
            //post(r);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.600 -0400", hash_original_method = "E60A634EF77869D698E2255CD3404933", hash_generated_method = "51CEE487883206FC8A62E7558C97C189")
    @android.view.RemotableViewMethod
    public synchronized void setProgress(int progress) {
        setProgress(progress, false);
        addTaint(progress);
        // ---------- Original Method ----------
        //setProgress(progress, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.600 -0400", hash_original_method = "65EDABD4A3EBF7E0899598C1A747DEC8", hash_generated_method = "BF1C30EAC9DAB1113A8DF32970E3EC20")
    @android.view.RemotableViewMethod
    synchronized void setProgress(int progress, boolean fromUser) {
        {
            progress = 0;
        } //End block
        {
            progress = mMax;
        } //End block
        {
            mProgress = progress;
            refreshProgress(R.id.progress, mProgress, fromUser);
        } //End block
        addTaint(fromUser);
        // ---------- Original Method ----------
        //if (mIndeterminate) {
            //return;
        //}
        //if (progress < 0) {
            //progress = 0;
        //}
        //if (progress > mMax) {
            //progress = mMax;
        //}
        //if (progress != mProgress) {
            //mProgress = progress;
            //refreshProgress(R.id.progress, mProgress, fromUser);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.601 -0400", hash_original_method = "9F9AE189F8359350B1506E3BE664E8EE", hash_generated_method = "989779C933B9C18FD9470DECB70B83DB")
    @android.view.RemotableViewMethod
    public synchronized void setSecondaryProgress(int secondaryProgress) {
        {
            secondaryProgress = 0;
        } //End block
        {
            secondaryProgress = mMax;
        } //End block
        {
            mSecondaryProgress = secondaryProgress;
            refreshProgress(R.id.secondaryProgress, mSecondaryProgress, false);
        } //End block
        // ---------- Original Method ----------
        //if (mIndeterminate) {
            //return;
        //}
        //if (secondaryProgress < 0) {
            //secondaryProgress = 0;
        //}
        //if (secondaryProgress > mMax) {
            //secondaryProgress = mMax;
        //}
        //if (secondaryProgress != mSecondaryProgress) {
            //mSecondaryProgress = secondaryProgress;
            //refreshProgress(R.id.secondaryProgress, mSecondaryProgress, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.601 -0400", hash_original_method = "BF818051FE207A57D09CC2C24E2066F6", hash_generated_method = "B8416EA916CA62D2877CF1BB4D872A6F")
    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getProgress() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1824315199 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1824315199;
        // ---------- Original Method ----------
        //return mIndeterminate ? 0 : mProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.601 -0400", hash_original_method = "0E2189FB3CB300C00977FC2C3BDB4D4B", hash_generated_method = "0224026D8D307F7CF285735117FF72F2")
    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getSecondaryProgress() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1107354973 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1107354973;
        // ---------- Original Method ----------
        //return mIndeterminate ? 0 : mSecondaryProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.602 -0400", hash_original_method = "6E6A982D82D781B4C4E0B14E6160A2E7", hash_generated_method = "574C9047695E4B53366063E70DB538D6")
    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getMax() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_744781071 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_744781071;
        // ---------- Original Method ----------
        //return mMax;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.602 -0400", hash_original_method = "DB535D9F1C65E31A54636A6B02096562", hash_generated_method = "29DC0E5AB1AC8F50AAAFFBF1BA12EDA2")
    @android.view.RemotableViewMethod
    public synchronized void setMax(int max) {
        {
            max = 0;
        } //End block
        {
            mMax = max;
            postInvalidate();
            {
                mProgress = max;
            } //End block
            refreshProgress(R.id.progress, mProgress, false);
        } //End block
        // ---------- Original Method ----------
        //if (max < 0) {
            //max = 0;
        //}
        //if (max != mMax) {
            //mMax = max;
            //postInvalidate();
            //if (mProgress > max) {
                //mProgress = max;
            //}
            //refreshProgress(R.id.progress, mProgress, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.603 -0400", hash_original_method = "1E5C167C76FF3FF0E5E9EED4F2394FD5", hash_generated_method = "45447D1866D92216284B6BDF57FC3250")
    public synchronized final void incrementProgressBy(int diff) {
        setProgress(mProgress + diff);
        addTaint(diff);
        // ---------- Original Method ----------
        //setProgress(mProgress + diff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.603 -0400", hash_original_method = "33F180031B438855CD8341D942A736A2", hash_generated_method = "F8FBB51637FDBF33ECAB4648767D64D6")
    public synchronized final void incrementSecondaryProgressBy(int diff) {
        setSecondaryProgress(mSecondaryProgress + diff);
        addTaint(diff);
        // ---------- Original Method ----------
        //setSecondaryProgress(mSecondaryProgress + diff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.604 -0400", hash_original_method = "F5167F20A872A63C36DAF85A2B000FB5", hash_generated_method = "CC60E39B2D14275B7163C903EA83D071")
     void startAnimation() {
        {
            boolean varEB2DA232CDC62C684F55F26E8E4CF877_1977962453 = (getVisibility() != VISIBLE);
        } //End collapsed parenthetic
        {
            mShouldStartAnimationDrawable = true;
            mAnimation = null;
        } //End block
        {
            {
                mInterpolator = new LinearInterpolator();
            } //End block
            mTransformation = new Transformation();
            mAnimation = new AlphaAnimation(0.0f, 1.0f);
            mAnimation.setRepeatMode(mBehavior);
            mAnimation.setRepeatCount(Animation.INFINITE);
            mAnimation.setDuration(mDuration);
            mAnimation.setInterpolator(mInterpolator);
            mAnimation.setStartTime(Animation.START_ON_FIRST_FRAME);
        } //End block
        postInvalidate();
        // ---------- Original Method ----------
        //if (getVisibility() != VISIBLE) {
            //return;
        //}
        //if (mIndeterminateDrawable instanceof Animatable) {
            //mShouldStartAnimationDrawable = true;
            //mAnimation = null;
        //} else {
            //if (mInterpolator == null) {
                //mInterpolator = new LinearInterpolator();
            //}
            //mTransformation = new Transformation();
            //mAnimation = new AlphaAnimation(0.0f, 1.0f);
            //mAnimation.setRepeatMode(mBehavior);
            //mAnimation.setRepeatCount(Animation.INFINITE);
            //mAnimation.setDuration(mDuration);
            //mAnimation.setInterpolator(mInterpolator);
            //mAnimation.setStartTime(Animation.START_ON_FIRST_FRAME);
        //}
        //postInvalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.605 -0400", hash_original_method = "3AFE1BBA347326120AD78BEE94F7B2A6", hash_generated_method = "A23A36E546002B56E789E6B1959E55BE")
     void stopAnimation() {
        mAnimation = null;
        mTransformation = null;
        {
            ((Animatable) mIndeterminateDrawable).stop();
            mShouldStartAnimationDrawable = false;
        } //End block
        postInvalidate();
        // ---------- Original Method ----------
        //mAnimation = null;
        //mTransformation = null;
        //if (mIndeterminateDrawable instanceof Animatable) {
            //((Animatable) mIndeterminateDrawable).stop();
            //mShouldStartAnimationDrawable = false;
        //}
        //postInvalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.605 -0400", hash_original_method = "2C6481DDCCEAC913795356C9BF1AF628", hash_generated_method = "7E5A07BF3C19F4781C14EC826407278C")
    public void setInterpolator(Context context, int resID) {
        setInterpolator(AnimationUtils.loadInterpolator(context, resID));
        addTaint(context.getTaint());
        addTaint(resID);
        // ---------- Original Method ----------
        //setInterpolator(AnimationUtils.loadInterpolator(context, resID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.605 -0400", hash_original_method = "7D5A9A852D608ADF508B994526BF9EAC", hash_generated_method = "305B3174980281AD6A6C4213980CE615")
    public void setInterpolator(Interpolator interpolator) {
        mInterpolator = interpolator;
        // ---------- Original Method ----------
        //mInterpolator = interpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.606 -0400", hash_original_method = "8AA04851FFB5BE49EA5890940035B142", hash_generated_method = "EF5AE69949960795980477E687E0A6F8")
    public Interpolator getInterpolator() {
        Interpolator varB4EAC82CA7396A68D541C85D26508E83_1523373600 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1523373600 = mInterpolator;
        varB4EAC82CA7396A68D541C85D26508E83_1523373600.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1523373600;
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.606 -0400", hash_original_method = "EC8B18EE88EE8E09369A36DBF52DF684", hash_generated_method = "A9ADC4920756BC395E1D2591F19EDB0E")
    @Override
    @RemotableViewMethod
    public void setVisibility(int v) {
        {
            boolean var4AC28F1E2836D09E4E72523D7E694F40_1661778356 = (getVisibility() != v);
            {
                super.setVisibility(v);
                {
                    {
                        stopAnimation();
                    } //End block
                    {
                        startAnimation();
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(v);
        // ---------- Original Method ----------
        //if (getVisibility() != v) {
            //super.setVisibility(v);
            //if (mIndeterminate) {
                //if (v == GONE || v == INVISIBLE) {
                    //stopAnimation();
                //} else {
                    //startAnimation();
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.607 -0400", hash_original_method = "E937F441086D9A40C4DA651781180A92", hash_generated_method = "7812FF13A533845CF27F62A7B9B92B57")
    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onVisibilityChanged(changedView, visibility);
        {
            {
                stopAnimation();
            } //End block
            {
                startAnimation();
            } //End block
        } //End block
        addTaint(changedView.getTaint());
        addTaint(visibility);
        // ---------- Original Method ----------
        //super.onVisibilityChanged(changedView, visibility);
        //if (mIndeterminate) {
            //if (visibility == GONE || visibility == INVISIBLE) {
                //stopAnimation();
            //} else {
                //startAnimation();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.607 -0400", hash_original_method = "51F010448C03C2EA1E2B7053B0DCB7DE", hash_generated_method = "A7C2804732D2D29976E7D123C34F291D")
    @Override
    public void invalidateDrawable(Drawable dr) {
        {
            {
                boolean varD1865A1D464E11906E399FDFD0B19F2A_2070295401 = (verifyDrawable(dr));
                {
                    final Rect dirty = dr.getBounds();
                    final int scrollX = mScrollX + mPaddingLeft;
                    final int scrollY = mScrollY + mPaddingTop;
                    invalidate(dirty.left + scrollX, dirty.top + scrollY,
                        dirty.right + scrollX, dirty.bottom + scrollY);
                } //End block
                {
                    super.invalidateDrawable(dr);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(dr.getTaint());
        // ---------- Original Method ----------
        //if (!mInDrawing) {
            //if (verifyDrawable(dr)) {
                //final Rect dirty = dr.getBounds();
                //final int scrollX = mScrollX + mPaddingLeft;
                //final int scrollY = mScrollY + mPaddingTop;
                //invalidate(dirty.left + scrollX, dirty.top + scrollY,
                        //dirty.right + scrollX, dirty.bottom + scrollY);
            //} else {
                //super.invalidateDrawable(dr);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.608 -0400", hash_original_method = "74277B895F883AA5B2EB254A27C149C7", hash_generated_method = "3A44A2F2AE7BB29A0DA5F3B1F36D52C2")
    @Override
    public int getResolvedLayoutDirection(Drawable who) {
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_1956692564 = (getResolvedLayoutDirection());
            Object var03FD24A395AACAA1B88D723AD820AD48_167808461 = (super.getResolvedLayoutDirection(who));
        } //End flattened ternary
        addTaint(who.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_783407575 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_783407575;
        // ---------- Original Method ----------
        //return (who == mProgressDrawable || who == mIndeterminateDrawable) ?
            //getResolvedLayoutDirection() : super.getResolvedLayoutDirection(who);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.608 -0400", hash_original_method = "69EE8DE1AB95A9498391F63C2C373DBD", hash_generated_method = "AD49383B0BDFA78C0B573ECD57AE0C5B")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        updateDrawableBounds(w, h);
        addTaint(w);
        addTaint(h);
        addTaint(oldw);
        addTaint(oldh);
        // ---------- Original Method ----------
        //updateDrawableBounds(w, h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.609 -0400", hash_original_method = "EA480A5BB3C1237E93332F6C8EE84591", hash_generated_method = "FABF266C0438946BB7CA6790C846A734")
    private void updateDrawableBounds(int w, int h) {
        int right = w - mPaddingRight - mPaddingLeft;
        int bottom = h - mPaddingBottom - mPaddingTop;
        int top = 0;
        int left = 0;
        {
            {
                final int intrinsicWidth = mIndeterminateDrawable.getIntrinsicWidth();
                final int intrinsicHeight = mIndeterminateDrawable.getIntrinsicHeight();
                final float intrinsicAspect = (float) intrinsicWidth / intrinsicHeight;
                final float boundAspect = (float) w / h;
                {
                    {
                        final int width = (int) (h * intrinsicAspect);
                        left = (w - width) / 2;
                        right = left + width;
                    } //End block
                    {
                        final int height = (int) (w * (1 / intrinsicAspect));
                        top = (h - height) / 2;
                        bottom = top + height;
                    } //End block
                } //End block
            } //End block
            mIndeterminateDrawable.setBounds(left, top, right, bottom);
        } //End block
        {
            mProgressDrawable.setBounds(0, 0, right, bottom);
        } //End block
        addTaint(w);
        addTaint(h);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.609 -0400", hash_original_method = "16CD7BB578E96B322FC9201A377B65CC", hash_generated_method = "83C06AB2F22806093E9646B78338663F")
    @Override
    protected synchronized void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDraw(canvas);
        Drawable d = mCurrentDrawable;
        {
            canvas.save();
            canvas.translate(mPaddingLeft, mPaddingTop);
            long time = getDrawingTime();
            {
                mAnimation.getTransformation(time, mTransformation);
                float scale = mTransformation.getAlpha();
                try 
                {
                    mInDrawing = true;
                    d.setLevel((int) (scale * MAX_LEVEL));
                } //End block
                finally 
                {
                    mInDrawing = false;
                } //End block
                {
                    boolean var3836B93166D135D378CFC1C2C62A0477_1139486186 = (SystemClock.uptimeMillis() - mLastDrawTime >= mAnimationResolution);
                    {
                        mLastDrawTime = SystemClock.uptimeMillis();
                        postInvalidateDelayed(mAnimationResolution);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            d.draw(canvas);
            canvas.restore();
            {
                ((Animatable) d).start();
                mShouldStartAnimationDrawable = false;
            } //End block
        } //End block
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.610 -0400", hash_original_method = "6FFAE46060D92EDBE1BD141B1F5C353A", hash_generated_method = "7DDE4407C099DD3242D020C66630B885")
    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Drawable d = mCurrentDrawable;
        int dw = 0;
        int dh = 0;
        {
            dw = Math.max(mMinWidth, Math.min(mMaxWidth, d.getIntrinsicWidth()));
            dh = Math.max(mMinHeight, Math.min(mMaxHeight, d.getIntrinsicHeight()));
        } //End block
        updateDrawableState();
        dw += mPaddingLeft + mPaddingRight;
        dh += mPaddingTop + mPaddingBottom;
        setMeasuredDimension(resolveSizeAndState(dw, widthMeasureSpec, 0),
                resolveSizeAndState(dh, heightMeasureSpec, 0));
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        //Drawable d = mCurrentDrawable;
        //int dw = 0;
        //int dh = 0;
        //if (d != null) {
            //dw = Math.max(mMinWidth, Math.min(mMaxWidth, d.getIntrinsicWidth()));
            //dh = Math.max(mMinHeight, Math.min(mMaxHeight, d.getIntrinsicHeight()));
        //}
        //updateDrawableState();
        //dw += mPaddingLeft + mPaddingRight;
        //dh += mPaddingTop + mPaddingBottom;
        //setMeasuredDimension(resolveSizeAndState(dw, widthMeasureSpec, 0),
                //resolveSizeAndState(dh, heightMeasureSpec, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.610 -0400", hash_original_method = "568F14E497668D52F70AE96AA5EB6F88", hash_generated_method = "2B34FA3925633B97C3B9967238FEABD8")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        updateDrawableState();
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //updateDrawableState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.610 -0400", hash_original_method = "952B851172F804A1D432AC87BADE94E9", hash_generated_method = "FA940635AB533F2FB299EA0FF708C1DC")
    private void updateDrawableState() {
        int[] state = getDrawableState();
        {
            boolean varC8B5BBFB2522EFF4A32AE45BFE86AD14_1899499946 = (mProgressDrawable != null && mProgressDrawable.isStateful());
            {
                mProgressDrawable.setState(state);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varDF233AA74F13D8A45ED1CBF7F222603B_467349211 = (mIndeterminateDrawable != null && mIndeterminateDrawable.isStateful());
            {
                mIndeterminateDrawable.setState(state);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int[] state = getDrawableState();
        //if (mProgressDrawable != null && mProgressDrawable.isStateful()) {
            //mProgressDrawable.setState(state);
        //}
        //if (mIndeterminateDrawable != null && mIndeterminateDrawable.isStateful()) {
            //mIndeterminateDrawable.setState(state);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.611 -0400", hash_original_method = "875308A47ADC87038CC9E153A4D8FE71", hash_generated_method = "5999F37DA25F03051E0BA43F4BF81E0E")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_694218074 = null; //Variable for return #1
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.progress = mProgress;
        ss.secondaryProgress = mSecondaryProgress;
        varB4EAC82CA7396A68D541C85D26508E83_694218074 = ss;
        varB4EAC82CA7396A68D541C85D26508E83_694218074.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_694218074;
        // ---------- Original Method ----------
        //Parcelable superState = super.onSaveInstanceState();
        //SavedState ss = new SavedState(superState);
        //ss.progress = mProgress;
        //ss.secondaryProgress = mSecondaryProgress;
        //return ss;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.611 -0400", hash_original_method = "A42CFAF758710477BAC4A7B2A0C98761", hash_generated_method = "2038D7527632F4C4EDCF5E289F186419")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setProgress(ss.progress);
        setSecondaryProgress(ss.secondaryProgress);
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        //SavedState ss = (SavedState) state;
        //super.onRestoreInstanceState(ss.getSuperState());
        //setProgress(ss.progress);
        //setSecondaryProgress(ss.secondaryProgress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.612 -0400", hash_original_method = "608AE3D8DA74959AA8F2204845C7317D", hash_generated_method = "AF5D2862F20D4786D23B7B35E3696FCA")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        {
            startAnimation();
        } //End block
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //if (mIndeterminate) {
            //startAnimation();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.612 -0400", hash_original_method = "3E30480EE15E7D073BA14A1FE62DC464", hash_generated_method = "2DB66FDCAA43B67C9554732958CC5D6A")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            stopAnimation();
        } //End block
        {
            removeCallbacks(mRefreshProgressRunnable);
        } //End block
        {
            removeCallbacks(mAccessibilityEventSender);
        } //End block
        super.onDetachedFromWindow();
        // ---------- Original Method ----------
        //if (mIndeterminate) {
            //stopAnimation();
        //}
        //if(mRefreshProgressRunnable != null) {
            //removeCallbacks(mRefreshProgressRunnable);
        //}
        //if (mAccessibilityEventSender != null) {
            //removeCallbacks(mAccessibilityEventSender);
        //}
        //super.onDetachedFromWindow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.613 -0400", hash_original_method = "D1990D7DB1A5D8E4C14ADC3323533C4A", hash_generated_method = "8B0226C1C7C236AF54A356C7E65A5812")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onInitializeAccessibilityEvent(event);
        event.setItemCount(mMax);
        event.setCurrentItemIndex(mProgress);
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //event.setItemCount(mMax);
        //event.setCurrentItemIndex(mProgress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.613 -0400", hash_original_method = "20F0DBCD6142D6C8A8DBD6A9085999AF", hash_generated_method = "60F29FAE9C16BE6E15DFD777D11B9B28")
    private void scheduleAccessibilityEventSender() {
        {
            mAccessibilityEventSender = new AccessibilityEventSender();
        } //End block
        {
            removeCallbacks(mAccessibilityEventSender);
        } //End block
        postDelayed(mAccessibilityEventSender, TIMEOUT_SEND_ACCESSIBILITY_EVENT);
        // ---------- Original Method ----------
        //if (mAccessibilityEventSender == null) {
            //mAccessibilityEventSender = new AccessibilityEventSender();
        //} else {
            //removeCallbacks(mAccessibilityEventSender);
        //}
        //postDelayed(mAccessibilityEventSender, TIMEOUT_SEND_ACCESSIBILITY_EVENT);
    }

    
    private class RefreshProgressRunnable implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.613 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

        private int mId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.613 -0400", hash_original_field = "8E57A1AD458E8C11842F6CF5D7E06883", hash_generated_field = "1CA7BE0C4831604F244183A43ACB7282")

        private int mProgress;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.613 -0400", hash_original_field = "C415F34964DBD13CCA489700EA3A16EC", hash_generated_field = "E56F4B776FFB7A387D61A7DB69ED27F1")

        private boolean mFromUser;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.614 -0400", hash_original_method = "84E6436ACAD7BA9E1C46F86F0883DFAC", hash_generated_method = "5727DBFD18D074B41C6BDF42FF9875C9")
          RefreshProgressRunnable(int id, int progress, boolean fromUser) {
            mId = id;
            mProgress = progress;
            mFromUser = fromUser;
            // ---------- Original Method ----------
            //mId = id;
            //mProgress = progress;
            //mFromUser = fromUser;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.615 -0400", hash_original_method = "336F21C38B52B9E04C9FE91372F32949", hash_generated_method = "51D6F418402664ECDD0B0622CCD44263")
        public void run() {
            doRefreshProgress(mId, mProgress, mFromUser, true);
            mRefreshProgressRunnable = this;
            // ---------- Original Method ----------
            //doRefreshProgress(mId, mProgress, mFromUser, true);
            //mRefreshProgressRunnable = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.615 -0400", hash_original_method = "992C4D927E51E72BEA0F4017381D8EC2", hash_generated_method = "A238CC5542317B5EC7A431478DA6D0E3")
        public void setup(int id, int progress, boolean fromUser) {
            mId = id;
            mProgress = progress;
            mFromUser = fromUser;
            // ---------- Original Method ----------
            //mId = id;
            //mProgress = progress;
            //mFromUser = fromUser;
        }

        
    }


    
    static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.615 -0400", hash_original_field = "3C709B10A5D47BA33D85337DD9110917", hash_generated_field = "0E86867788D9F180E816D58F2E5188C6")

        int progress;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.615 -0400", hash_original_field = "FB93C6DAB209AD5362C10535696AC83A", hash_generated_field = "1F6D1EA8F68E49AFD9E30D4EFB3F6276")

        int secondaryProgress;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.616 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "3F4F70129FCB46E4AE0D334AE4D70CF6")
          SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.616 -0400", hash_original_method = "9D61E8AE00F16C0432FB33E15078B080", hash_generated_method = "9ED54A037992D9B4CCD324548CA845EB")
        private  SavedState(Parcel in) {
            super(in);
            progress = in.readInt();
            secondaryProgress = in.readInt();
            // ---------- Original Method ----------
            //progress = in.readInt();
            //secondaryProgress = in.readInt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.616 -0400", hash_original_method = "47949C0C27B3FB6F61C4F76D6E851E0A", hash_generated_method = "D8437CC192EF0331E68B4582CD536C01")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(progress);
            out.writeInt(secondaryProgress);
            addTaint(out.getTaint());
            addTaint(flags);
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeInt(progress);
            //out.writeInt(secondaryProgress);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.616 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.616 -0400", hash_original_method = "5812CBDC5E0171D8BC07CE56DB600368", hash_generated_method = "5812CBDC5E0171D8BC07CE56DB600368")
        public AccessibilityEventSender ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.617 -0400", hash_original_method = "D171B097136E37DF343D32BCCA8935F6", hash_generated_method = "2295CF57C52786E3AEEE5BA06534C7E1")
        public void run() {
            sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
            // ---------- Original Method ----------
            //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.617 -0400", hash_original_field = "D2DD2BB7F0B3E156DA500A133BC0E11B", hash_generated_field = "CC7511334507B624E41735D194F6E4E0")

    private static final int MAX_LEVEL = 10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.617 -0400", hash_original_field = "CB4F103AB492FC713BF751CD8A51F9C3", hash_generated_field = "39EF70D35A29D206C019E7A12A698D6D")

    private static final int ANIMATION_RESOLUTION = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.617 -0400", hash_original_field = "05B419CB9CCCDBAE7ED4E8EC7599640B", hash_generated_field = "81CDC7C9CA9F2EE4E05B25C5A8DB35B0")

    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
}

