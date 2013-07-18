package android.widget;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ProgressBar extends View {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.067 -0400", hash_original_field = "2FB832D2671571BF4EC0C84F8DA6AA79", hash_generated_field = "B5D566AA92521F570066E8773A24B0C0")

    int mMinWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.067 -0400", hash_original_field = "C4C548A58212673838506E3498DE25A0", hash_generated_field = "DE6F7D0025A7518849324A9E1601224A")

    int mMaxWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.068 -0400", hash_original_field = "7B1C5936E045E46CDC7DE29B76B9E7F4", hash_generated_field = "0DD4F81D09F8349C333039CCE34B2CF7")

    int mMinHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.068 -0400", hash_original_field = "C16CF8950AAD7E5F5E8D168AA605278E", hash_generated_field = "2B42F0B48BA5A796B2697835D2F18090")

    int mMaxHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.068 -0400", hash_original_field = "8E57A1AD458E8C11842F6CF5D7E06883", hash_generated_field = "1CA7BE0C4831604F244183A43ACB7282")

    private int mProgress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.068 -0400", hash_original_field = "DCB5EA0939620CFCFDDC71F603D69A41", hash_generated_field = "015CFC0D453C8DA6A402F32079F8A6A4")

    private int mSecondaryProgress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.068 -0400", hash_original_field = "C886C6FF92A43B3F6833B7BAFD354FBA", hash_generated_field = "A1BFCC57A6BC96010A1D330EF07F3F34")

    private int mMax;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.068 -0400", hash_original_field = "BB93BD926EB6205F05262D1B23379817", hash_generated_field = "7AB98B3DA8DC606CB1698898E1D5910B")

    private int mBehavior;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.068 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "A658ABE5235D82E385D992CF2A9ACD3B")

    private int mDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.068 -0400", hash_original_field = "066BD2341E290903C1ACFDCFA38A9B44", hash_generated_field = "92F2421E00AF2915B64A009A8AEF51CA")

    private boolean mIndeterminate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.068 -0400", hash_original_field = "58B7B5409BF4F16770CC1AE1C446A910", hash_generated_field = "C1DA2FED56001BDE5D0AD3FEFBE7FD96")

    private boolean mOnlyIndeterminate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.068 -0400", hash_original_field = "BBDAB2FB373D7DA19760B893D5429B4A", hash_generated_field = "2643C4FF32FBB404667FBA24AD639E50")

    private Transformation mTransformation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.068 -0400", hash_original_field = "9A46FC3BA66487AE56C5DCE37D0AA79A", hash_generated_field = "57388EC69EE573DE5E4AF3A536B016D4")

    private AlphaAnimation mAnimation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.068 -0400", hash_original_field = "081CE0D8134A29404CF8CC8A86F7E0F6", hash_generated_field = "C689AC3D1D2B848F3E53B0D791A6559F")

    private Drawable mIndeterminateDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.068 -0400", hash_original_field = "35ACEA7B06E4E9292BB05774C2312E1C", hash_generated_field = "C7829E00A6912D78CF4DAAA1F03878F2")

    private Drawable mProgressDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.068 -0400", hash_original_field = "0E46DF6A99A9DBE87718B5F45A249DE6", hash_generated_field = "90CE76B172D180EF24FA84EA783D3205")

    private Drawable mCurrentDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.068 -0400", hash_original_field = "2E25EACC73788D7925D059F96D8B9B72", hash_generated_field = "A2E623BE945F90A1659BB6259980C46A")

    Bitmap mSampleTile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.068 -0400", hash_original_field = "3E924E5B9A794C4409F638A71AD282E8", hash_generated_field = "CA606DE6031B2AD65CB031A15282E5C0")

    private boolean mNoInvalidate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.069 -0400", hash_original_field = "DA3E6FC5A778B3C344EE09B26563FD22", hash_generated_field = "67BF1E9EFEC019D28BF77934CF035B72")

    private Interpolator mInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.069 -0400", hash_original_field = "2FAEA616A753C70642294CC7860EC666", hash_generated_field = "8ACA154D8775441FD3732F1D17C67323")

    private RefreshProgressRunnable mRefreshProgressRunnable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.069 -0400", hash_original_field = "D043A3546110D688BA4F6DE20B99A0A1", hash_generated_field = "CD5745C207A6BF8B60FA99DC96FB59AD")

    private long mUiThreadId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.069 -0400", hash_original_field = "98A2EDCF2A73027C9055FD1BBD0348FA", hash_generated_field = "359DB1662474C9DDA50E3F28F77D23F6")

    private boolean mShouldStartAnimationDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.069 -0400", hash_original_field = "D73042AA4B83CBB5EDFF85839968BC9A", hash_generated_field = "40DA5017CC9E425245C6E3C14B2FC5CA")

    private long mLastDrawTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.069 -0400", hash_original_field = "C435AC5CE20BC8410E8D96F6C5A01644", hash_generated_field = "9E34047AEA414B2399121C937D10E14B")

    private boolean mInDrawing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.069 -0400", hash_original_field = "90A80CF25193B8AF1E55FB872DDAB330", hash_generated_field = "8CB5D4845E1FC7F9C65B298EDDE9F5B1")

    private int mAnimationResolution;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.069 -0400", hash_original_field = "51B0402D7E1CC15169466C294C4EA35D", hash_generated_field = "F465CD63B02941FD3A08D3CC1E47AC81")

    private AccessibilityEventSender mAccessibilityEventSender;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.069 -0400", hash_original_method = "F5911F61390A242F23F5676C44FA4C61", hash_generated_method = "661AE0288A8718D3E63F42C49E8AB855")
    public  ProgressBar(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.070 -0400", hash_original_method = "D031AA7B7D98D3870546853F1BC5BC9E", hash_generated_method = "86CFE48EF6108DA67F7A6A0E78EC758A")
    public  ProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.progressBarStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.070 -0400", hash_original_method = "E1F87E741C36AFFDC636A9ACF6EDF064", hash_generated_method = "F651297E783E5138BD05F8FA2423EDF9")
    public  ProgressBar(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, 0);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.074 -0400", hash_original_method = "DAE8B382D7288D55BBDECA5C905F6E78", hash_generated_method = "ECBB23DC7D3A80E2D75EF00254655675")
    public  ProgressBar(Context context, AttributeSet attrs, int defStyle, int styleRes) {
        super(context, attrs, defStyle);
        addTaint(styleRes);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        mUiThreadId = Thread.currentThread().getId();
        initProgressBar();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ProgressBar, defStyle, styleRes);
        mNoInvalidate = true;
        Drawable drawable = a.getDrawable(R.styleable.ProgressBar_progressDrawable);
        if(drawable != null)        
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
        if(resID > 0)        
        {
            setInterpolator(context, resID);
        } //End block
        setMax(a.getInt(R.styleable.ProgressBar_max, mMax));
        setProgress(a.getInt(R.styleable.ProgressBar_progress, mProgress));
        setSecondaryProgress(
                a.getInt(R.styleable.ProgressBar_secondaryProgress, mSecondaryProgress));
        drawable = a.getDrawable(R.styleable.ProgressBar_indeterminateDrawable);
        if(drawable != null)        
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.076 -0400", hash_original_method = "224A1F0FE2A7F3DC81BFFEE36861F394", hash_generated_method = "70855A04D6562824065D564D4B93E8F8")
    private Drawable tileify(Drawable drawable, boolean clip) {
        addTaint(clip);
        addTaint(drawable.getTaint());
        if(drawable instanceof LayerDrawable)        
        {
            LayerDrawable background = (LayerDrawable) drawable;
            final int N = background.getNumberOfLayers();
            Drawable[] outDrawables = new Drawable[N];
for(int i = 0;i < N;i++)
            {
                int id = background.getId(i);
                outDrawables[i] = tileify(background.getDrawable(i),
                        (id == R.id.progress || id == R.id.secondaryProgress));
            } //End block
            LayerDrawable newBg = new LayerDrawable(outDrawables);
for(int i = 0;i < N;i++)
            {
                newBg.setId(i, background.getId(i));
            } //End block
Drawable var2649DE119BD6106393C67CBB797B1AB8_231026407 =             newBg;
            var2649DE119BD6106393C67CBB797B1AB8_231026407.addTaint(taint);
            return var2649DE119BD6106393C67CBB797B1AB8_231026407;
        } //End block
        else
        if(drawable instanceof StateListDrawable)        
        {
            StateListDrawable in = (StateListDrawable) drawable;
            StateListDrawable out = new StateListDrawable();
            int numStates = in.getStateCount();
for(int i = 0;i < numStates;i++)
            {
                out.addState(in.getStateSet(i), tileify(in.getStateDrawable(i), clip));
            } //End block
Drawable varFE81D892BE5757A0E16305825903D324_493065016 =             out;
            varFE81D892BE5757A0E16305825903D324_493065016.addTaint(taint);
            return varFE81D892BE5757A0E16305825903D324_493065016;
        } //End block
        else
        if(drawable instanceof BitmapDrawable)        
        {
            final Bitmap tileBitmap = ((BitmapDrawable) drawable).getBitmap();
            if(mSampleTile == null)            
            {
                mSampleTile = tileBitmap;
            } //End block
            final ShapeDrawable shapeDrawable = new ShapeDrawable(getDrawableShape());
            final BitmapShader bitmapShader = new BitmapShader(tileBitmap,
                    Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
            shapeDrawable.getPaint().setShader(bitmapShader);
Drawable var8C1667BE174DF8110DB6DD29959FE973_405821758 =             (clip) ? new ClipDrawable(shapeDrawable, Gravity.LEFT,
                    ClipDrawable.HORIZONTAL) : shapeDrawable;
            var8C1667BE174DF8110DB6DD29959FE973_405821758.addTaint(taint);
            return var8C1667BE174DF8110DB6DD29959FE973_405821758;
        } //End block
Drawable varA22A26D75522826F9AEFA195DDDFD365_1721221798 =         drawable;
        varA22A26D75522826F9AEFA195DDDFD365_1721221798.addTaint(taint);
        return varA22A26D75522826F9AEFA195DDDFD365_1721221798;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.077 -0400", hash_original_method = "066FEFD8810FD39B2288696E8912725B", hash_generated_method = "2DBA756DA7BE0344BB0ADCEC5C86405F")
     Shape getDrawableShape() {
        final float[] roundedCorners = new float[] { 5, 5, 5, 5, 5, 5, 5, 5 };
Shape varE5AD6A465EDE45C705AEBAD629956806_621586862 =         new RoundRectShape(roundedCorners, null, null);
        varE5AD6A465EDE45C705AEBAD629956806_621586862.addTaint(taint);
        return varE5AD6A465EDE45C705AEBAD629956806_621586862;
        // ---------- Original Method ----------
        //final float[] roundedCorners = new float[] { 5, 5, 5, 5, 5, 5, 5, 5 };
        //return new RoundRectShape(roundedCorners, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.077 -0400", hash_original_method = "9EE7DD01E1AB6B0D269DB58A7544C17D", hash_generated_method = "A37EB23EBBDAD68C503FC33BC9FC4DFE")
    private Drawable tileifyIndeterminate(Drawable drawable) {
        addTaint(drawable.getTaint());
        if(drawable instanceof AnimationDrawable)        
        {
            AnimationDrawable background = (AnimationDrawable) drawable;
            final int N = background.getNumberOfFrames();
            AnimationDrawable newBg = new AnimationDrawable();
            newBg.setOneShot(background.isOneShot());
for(int i = 0;i < N;i++)
            {
                Drawable frame = tileify(background.getFrame(i), true);
                frame.setLevel(10000);
                newBg.addFrame(frame, background.getDuration(i));
            } //End block
            newBg.setLevel(10000);
            drawable = newBg;
        } //End block
Drawable varA22A26D75522826F9AEFA195DDDFD365_507455730 =         drawable;
        varA22A26D75522826F9AEFA195DDDFD365_507455730.addTaint(taint);
        return varA22A26D75522826F9AEFA195DDDFD365_507455730;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.079 -0400", hash_original_method = "E5E4BC7A2B363BE6E2FBD0B5C26F4050", hash_generated_method = "8DA820DB7B007C068BE9D230A5110A34")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.079 -0400", hash_original_method = "3387FD7633AB5B9FD9EC30B2946E89DA", hash_generated_method = "20571BF2C86C470B1738579A4D252226")
    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized boolean isIndeterminate() {
        boolean var066BD2341E290903C1ACFDCFA38A9B44_813394763 = (mIndeterminate);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_256810155 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_256810155;
        // ---------- Original Method ----------
        //return mIndeterminate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.080 -0400", hash_original_method = "9BFD2BF2FBC3833B7107C0E363644A89", hash_generated_method = "FF98C2DDC8A1A3069077A1CE018ADDD8")
    @android.view.RemotableViewMethod
    public synchronized void setIndeterminate(boolean indeterminate) {
        if((!mOnlyIndeterminate || !mIndeterminate) && indeterminate != mIndeterminate)        
        {
            mIndeterminate = indeterminate;
            if(indeterminate)            
            {
                mCurrentDrawable = mIndeterminateDrawable;
                startAnimation();
            } //End block
            else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.080 -0400", hash_original_method = "460B65565106BA0615FD22E30B040519", hash_generated_method = "A74A8CF4ABA0B00AAE3815DB91CDC69F")
    public Drawable getIndeterminateDrawable() {
Drawable varF00153B56D2CB49C3A37B1DEFFA7532F_736143345 =         mIndeterminateDrawable;
        varF00153B56D2CB49C3A37B1DEFFA7532F_736143345.addTaint(taint);
        return varF00153B56D2CB49C3A37B1DEFFA7532F_736143345;
        // ---------- Original Method ----------
        //return mIndeterminateDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.081 -0400", hash_original_method = "4CAABA82B88C397ED0E927A2E15C90A0", hash_generated_method = "3C9D22CBBB3AA56E70C40AE86580D6C1")
    public void setIndeterminateDrawable(Drawable d) {
        if(d != null)        
        {
            d.setCallback(this);
        } //End block
        mIndeterminateDrawable = d;
        if(mIndeterminate)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.081 -0400", hash_original_method = "6C8C8D805DC88A29293BE605923D5590", hash_generated_method = "591E84B360BF362C3A6F6A908441D3EC")
    public Drawable getProgressDrawable() {
Drawable varE3CF59E02A1DFBC354305A0CD25ECEA2_1044407042 =         mProgressDrawable;
        varE3CF59E02A1DFBC354305A0CD25ECEA2_1044407042.addTaint(taint);
        return varE3CF59E02A1DFBC354305A0CD25ECEA2_1044407042;
        // ---------- Original Method ----------
        //return mProgressDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.082 -0400", hash_original_method = "3733E64362DE34A69671D2EF5503886A", hash_generated_method = "FD666366B0F9C3306D2A7F7F9A253A96")
    public void setProgressDrawable(Drawable d) {
        boolean needUpdate;
        if(mProgressDrawable != null && d != mProgressDrawable)        
        {
            mProgressDrawable.setCallback(null);
            needUpdate = true;
        } //End block
        else
        {
            needUpdate = false;
        } //End block
        if(d != null)        
        {
            d.setCallback(this);
            int drawableHeight = d.getMinimumHeight();
            if(mMaxHeight < drawableHeight)            
            {
                mMaxHeight = drawableHeight;
                requestLayout();
            } //End block
        } //End block
        mProgressDrawable = d;
        if(!mIndeterminate)        
        {
            mCurrentDrawable = d;
            postInvalidate();
        } //End block
        if(needUpdate)        
        {
            updateDrawableBounds(getWidth(), getHeight());
            updateDrawableState();
            doRefreshProgress(R.id.progress, mProgress, false, false);
            doRefreshProgress(R.id.secondaryProgress, mSecondaryProgress, false, false);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.082 -0400", hash_original_method = "BC108B758414D6B13292C41A47E0F703", hash_generated_method = "11BC58483DC0FBDCA966A85DBEA46864")
     Drawable getCurrentDrawable() {
Drawable varCF8D9BC802F0D54A46071309A1C41866_7228635 =         mCurrentDrawable;
        varCF8D9BC802F0D54A46071309A1C41866_7228635.addTaint(taint);
        return varCF8D9BC802F0D54A46071309A1C41866_7228635;
        // ---------- Original Method ----------
        //return mCurrentDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.082 -0400", hash_original_method = "56BA1F17FA722E2B64538801F5E2971D", hash_generated_method = "1234398C85FC631A9252393F10375851")
    @Override
    protected boolean verifyDrawable(Drawable who) {
        addTaint(who.getTaint());
        boolean var074CAF490D1845521AC52D4E6F4B58C1_1588623794 = (who == mProgressDrawable || who == mIndeterminateDrawable
                || super.verifyDrawable(who));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1460037647 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1460037647;
        // ---------- Original Method ----------
        //return who == mProgressDrawable || who == mIndeterminateDrawable
                //|| super.verifyDrawable(who);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.083 -0400", hash_original_method = "7333172C31835F46D838DB3DB892DD55", hash_generated_method = "70DDDB300C930FE9E1A5A6AD371BC4D1")
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if(mProgressDrawable != null)        
        mProgressDrawable.jumpToCurrentState();
        if(mIndeterminateDrawable != null)        
        mIndeterminateDrawable.jumpToCurrentState();
        // ---------- Original Method ----------
        //super.jumpDrawablesToCurrentState();
        //if (mProgressDrawable != null) mProgressDrawable.jumpToCurrentState();
        //if (mIndeterminateDrawable != null) mIndeterminateDrawable.jumpToCurrentState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.083 -0400", hash_original_method = "9D88EC1BAB8B30E9973F963BD590322C", hash_generated_method = "86259BDEA8CC00FE1AD959A79FA98761")
    @Override
    public void postInvalidate() {
        if(!mNoInvalidate)        
        {
            super.postInvalidate();
        } //End block
        // ---------- Original Method ----------
        //if (!mNoInvalidate) {
            //super.postInvalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.084 -0400", hash_original_method = "10671D93E2F61D98C60CD8288CC260A2", hash_generated_method = "C320777395D89C9FF1521C14A3EE007F")
    private synchronized void doRefreshProgress(int id, int progress, boolean fromUser,
            boolean callBackToApp) {
        addTaint(callBackToApp);
        addTaint(fromUser);
        addTaint(progress);
        addTaint(id);
        float scale = mMax > 0 ? (float) progress / (float) mMax : 0;
        final Drawable d = mCurrentDrawable;
        if(d != null)        
        {
            Drawable progressDrawable = null;
            if(d instanceof LayerDrawable)            
            {
                progressDrawable = ((LayerDrawable) d).findDrawableByLayerId(id);
            } //End block
            final int level = (int) (scale * MAX_LEVEL);
            (progressDrawable != null ? progressDrawable : d).setLevel(level);
        } //End block
        else
        {
            invalidate();
        } //End block
        if(callBackToApp && id == R.id.progress)        
        {
            onProgressRefresh(scale, fromUser);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.084 -0400", hash_original_method = "1EE4C81513694B44BBA27F5A11B0191B", hash_generated_method = "7A76CCB4B14B7266EE64CCE8EB036548")
     void onProgressRefresh(float scale, boolean fromUser) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(fromUser);
        addTaint(scale);
        if(AccessibilityManager.getInstance(mContext).isEnabled())        
        {
            scheduleAccessibilityEventSender();
        } //End block
        // ---------- Original Method ----------
        //if (AccessibilityManager.getInstance(mContext).isEnabled()) {
            //scheduleAccessibilityEventSender();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.085 -0400", hash_original_method = "6344B397C965EAD8A2329C40E25F1FFC", hash_generated_method = "ACFE39C730480A10D40425C8BDE03D7B")
    private synchronized void refreshProgress(int id, int progress, boolean fromUser) {
        addTaint(fromUser);
        addTaint(progress);
        addTaint(id);
        if(mUiThreadId == Thread.currentThread().getId())        
        {
            doRefreshProgress(id, progress, fromUser, true);
        } //End block
        else
        {
            RefreshProgressRunnable r;
            if(mRefreshProgressRunnable != null)            
            {
                r = mRefreshProgressRunnable;
                mRefreshProgressRunnable = null;
                r.setup(id, progress, fromUser);
            } //End block
            else
            {
                r = new RefreshProgressRunnable(id, progress, fromUser);
            } //End block
            post(r);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.086 -0400", hash_original_method = "E60A634EF77869D698E2255CD3404933", hash_generated_method = "8F6DEA5F19AAD77B783CF0F907E6383A")
    @android.view.RemotableViewMethod
    public synchronized void setProgress(int progress) {
        addTaint(progress);
        setProgress(progress, false);
        // ---------- Original Method ----------
        //setProgress(progress, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.086 -0400", hash_original_method = "65EDABD4A3EBF7E0899598C1A747DEC8", hash_generated_method = "DBE4EAE5409845C63F798D9423A78E9E")
    @android.view.RemotableViewMethod
    synchronized void setProgress(int progress, boolean fromUser) {
        addTaint(fromUser);
        if(mIndeterminate)        
        {
            return;
        } //End block
        if(progress < 0)        
        {
            progress = 0;
        } //End block
        if(progress > mMax)        
        {
            progress = mMax;
        } //End block
        if(progress != mProgress)        
        {
            mProgress = progress;
            refreshProgress(R.id.progress, mProgress, fromUser);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.087 -0400", hash_original_method = "9F9AE189F8359350B1506E3BE664E8EE", hash_generated_method = "8A8CE032C94CE4F79A9A60FD36CECE67")
    @android.view.RemotableViewMethod
    public synchronized void setSecondaryProgress(int secondaryProgress) {
        if(mIndeterminate)        
        {
            return;
        } //End block
        if(secondaryProgress < 0)        
        {
            secondaryProgress = 0;
        } //End block
        if(secondaryProgress > mMax)        
        {
            secondaryProgress = mMax;
        } //End block
        if(secondaryProgress != mSecondaryProgress)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.087 -0400", hash_original_method = "BF818051FE207A57D09CC2C24E2066F6", hash_generated_method = "6949554CEFB68BC786EE45CF0E9697FC")
    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getProgress() {
        int var896E81319782829B034F26E4F256A5AD_1180210368 = (mIndeterminate ? 0 : mProgress);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706315100 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706315100;
        // ---------- Original Method ----------
        //return mIndeterminate ? 0 : mProgress;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.087 -0400", hash_original_method = "0E2189FB3CB300C00977FC2C3BDB4D4B", hash_generated_method = "BE1CBE0E4A489F687F860D753AD514F2")
    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getSecondaryProgress() {
        int varCC09693E30955777A6A27C5CBFFFF66A_830256812 = (mIndeterminate ? 0 : mSecondaryProgress);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1105981368 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1105981368;
        // ---------- Original Method ----------
        //return mIndeterminate ? 0 : mSecondaryProgress;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.088 -0400", hash_original_method = "6E6A982D82D781B4C4E0B14E6160A2E7", hash_generated_method = "7B6D7F22016B1466617FA4A59CFDBD5F")
    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getMax() {
        int varC886C6FF92A43B3F6833B7BAFD354FBA_899834944 = (mMax);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_707987912 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_707987912;
        // ---------- Original Method ----------
        //return mMax;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.088 -0400", hash_original_method = "DB535D9F1C65E31A54636A6B02096562", hash_generated_method = "4D3A731803FF6C114AF48ED8EC08AC12")
    @android.view.RemotableViewMethod
    public synchronized void setMax(int max) {
        if(max < 0)        
        {
            max = 0;
        } //End block
        if(max != mMax)        
        {
            mMax = max;
            postInvalidate();
            if(mProgress > max)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.089 -0400", hash_original_method = "1E5C167C76FF3FF0E5E9EED4F2394FD5", hash_generated_method = "D3D9333876A75F30FD4A3EB5943F27E5")
    public synchronized final void incrementProgressBy(int diff) {
        addTaint(diff);
        setProgress(mProgress + diff);
        // ---------- Original Method ----------
        //setProgress(mProgress + diff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.089 -0400", hash_original_method = "33F180031B438855CD8341D942A736A2", hash_generated_method = "875592F97DA8F8337A21309A8EC7B82B")
    public synchronized final void incrementSecondaryProgressBy(int diff) {
        addTaint(diff);
        setSecondaryProgress(mSecondaryProgress + diff);
        // ---------- Original Method ----------
        //setSecondaryProgress(mSecondaryProgress + diff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.090 -0400", hash_original_method = "F5167F20A872A63C36DAF85A2B000FB5", hash_generated_method = "6FA45E3DFA2AFC6767AA6A4B3A568391")
     void startAnimation() {
        if(getVisibility() != VISIBLE)        
        {
            return;
        } //End block
        if(mIndeterminateDrawable instanceof Animatable)        
        {
            mShouldStartAnimationDrawable = true;
            mAnimation = null;
        } //End block
        else
        {
            if(mInterpolator == null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.090 -0400", hash_original_method = "3AFE1BBA347326120AD78BEE94F7B2A6", hash_generated_method = "E890542093B7CD8F089C73B6D19B98EE")
     void stopAnimation() {
        mAnimation = null;
        mTransformation = null;
        if(mIndeterminateDrawable instanceof Animatable)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.090 -0400", hash_original_method = "2C6481DDCCEAC913795356C9BF1AF628", hash_generated_method = "FBCFFDB8934B412FCF947D3B533DE793")
    public void setInterpolator(Context context, int resID) {
        addTaint(resID);
        addTaint(context.getTaint());
        setInterpolator(AnimationUtils.loadInterpolator(context, resID));
        // ---------- Original Method ----------
        //setInterpolator(AnimationUtils.loadInterpolator(context, resID));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.091 -0400", hash_original_method = "7D5A9A852D608ADF508B994526BF9EAC", hash_generated_method = "305B3174980281AD6A6C4213980CE615")
    public void setInterpolator(Interpolator interpolator) {
        mInterpolator = interpolator;
        // ---------- Original Method ----------
        //mInterpolator = interpolator;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.091 -0400", hash_original_method = "8AA04851FFB5BE49EA5890940035B142", hash_generated_method = "270D0392F1C466ACA1C1729C4BD677BF")
    public Interpolator getInterpolator() {
Interpolator var9FA301F6AF154FEBBB2C7439D021F894_821922003 =         mInterpolator;
        var9FA301F6AF154FEBBB2C7439D021F894_821922003.addTaint(taint);
        return var9FA301F6AF154FEBBB2C7439D021F894_821922003;
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.091 -0400", hash_original_method = "EC8B18EE88EE8E09369A36DBF52DF684", hash_generated_method = "3FD65D1E4B02BA1914A841F69EC44FC0")
    @Override
    @RemotableViewMethod
    public void setVisibility(int v) {
        addTaint(v);
        if(getVisibility() != v)        
        {
            super.setVisibility(v);
            if(mIndeterminate)            
            {
                if(v == GONE || v == INVISIBLE)                
                {
                    stopAnimation();
                } //End block
                else
                {
                    startAnimation();
                } //End block
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.092 -0400", hash_original_method = "E937F441086D9A40C4DA651781180A92", hash_generated_method = "F814E6E5CD4BFC60A367A89CAAE37887")
    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(visibility);
        addTaint(changedView.getTaint());
        super.onVisibilityChanged(changedView, visibility);
        if(mIndeterminate)        
        {
            if(visibility == GONE || visibility == INVISIBLE)            
            {
                stopAnimation();
            } //End block
            else
            {
                startAnimation();
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.092 -0400", hash_original_method = "51F010448C03C2EA1E2B7053B0DCB7DE", hash_generated_method = "00C41718C6D468FC0EF4D8B6461D620B")
    @Override
    public void invalidateDrawable(Drawable dr) {
        addTaint(dr.getTaint());
        if(!mInDrawing)        
        {
            if(verifyDrawable(dr))            
            {
                final Rect dirty = dr.getBounds();
                final int scrollX = mScrollX + mPaddingLeft;
                final int scrollY = mScrollY + mPaddingTop;
                invalidate(dirty.left + scrollX, dirty.top + scrollY,
                        dirty.right + scrollX, dirty.bottom + scrollY);
            } //End block
            else
            {
                super.invalidateDrawable(dr);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.092 -0400", hash_original_method = "74277B895F883AA5B2EB254A27C149C7", hash_generated_method = "883A1F09580CEB6D2BC45799B6D0CBB7")
    @Override
    public int getResolvedLayoutDirection(Drawable who) {
        addTaint(who.getTaint());
        int varD683986362A705258C4E69209FB34C5F_421753696 = ((who == mProgressDrawable || who == mIndeterminateDrawable) ?
            getResolvedLayoutDirection() : super.getResolvedLayoutDirection(who));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_150205753 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_150205753;
        // ---------- Original Method ----------
        //return (who == mProgressDrawable || who == mIndeterminateDrawable) ?
            //getResolvedLayoutDirection() : super.getResolvedLayoutDirection(who);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.092 -0400", hash_original_method = "69EE8DE1AB95A9498391F63C2C373DBD", hash_generated_method = "8E3F25468214CB99C9456EF69A803E35")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(oldh);
        addTaint(oldw);
        addTaint(h);
        addTaint(w);
        updateDrawableBounds(w, h);
        // ---------- Original Method ----------
        //updateDrawableBounds(w, h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.093 -0400", hash_original_method = "EA480A5BB3C1237E93332F6C8EE84591", hash_generated_method = "E890F37E2A821761E9E87DB75CB5037C")
    private void updateDrawableBounds(int w, int h) {
        addTaint(h);
        addTaint(w);
        int right = w - mPaddingRight - mPaddingLeft;
        int bottom = h - mPaddingBottom - mPaddingTop;
        int top = 0;
        int left = 0;
        if(mIndeterminateDrawable != null)        
        {
            if(mOnlyIndeterminate && !(mIndeterminateDrawable instanceof AnimationDrawable))            
            {
                final int intrinsicWidth = mIndeterminateDrawable.getIntrinsicWidth();
                final int intrinsicHeight = mIndeterminateDrawable.getIntrinsicHeight();
                final float intrinsicAspect = (float) intrinsicWidth / intrinsicHeight;
                final float boundAspect = (float) w / h;
                if(intrinsicAspect != boundAspect)                
                {
                    if(boundAspect > intrinsicAspect)                    
                    {
                        final int width = (int) (h * intrinsicAspect);
                        left = (w - width) / 2;
                        right = left + width;
                    } //End block
                    else
                    {
                        final int height = (int) (w * (1 / intrinsicAspect));
                        top = (h - height) / 2;
                        bottom = top + height;
                    } //End block
                } //End block
            } //End block
            mIndeterminateDrawable.setBounds(left, top, right, bottom);
        } //End block
        if(mProgressDrawable != null)        
        {
            mProgressDrawable.setBounds(0, 0, right, bottom);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.093 -0400", hash_original_method = "16CD7BB578E96B322FC9201A377B65CC", hash_generated_method = "229270E8BFECAF2393326E1A1065DCD7")
    @Override
    protected synchronized void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
        super.onDraw(canvas);
        Drawable d = mCurrentDrawable;
        if(d != null)        
        {
            canvas.save();
            canvas.translate(mPaddingLeft, mPaddingTop);
            long time = getDrawingTime();
            if(mAnimation != null)            
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
                if(SystemClock.uptimeMillis() - mLastDrawTime >= mAnimationResolution)                
                {
                    mLastDrawTime = SystemClock.uptimeMillis();
                    postInvalidateDelayed(mAnimationResolution);
                } //End block
            } //End block
            d.draw(canvas);
            canvas.restore();
            if(mShouldStartAnimationDrawable && d instanceof Animatable)            
            {
                ((Animatable) d).start();
                mShouldStartAnimationDrawable = false;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.094 -0400", hash_original_method = "6FFAE46060D92EDBE1BD141B1F5C353A", hash_generated_method = "5CE2802FDFABB61BD444615EF31B6D82")
    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        Drawable d = mCurrentDrawable;
        int dw = 0;
        int dh = 0;
        if(d != null)        
        {
            dw = Math.max(mMinWidth, Math.min(mMaxWidth, d.getIntrinsicWidth()));
            dh = Math.max(mMinHeight, Math.min(mMaxHeight, d.getIntrinsicHeight()));
        } //End block
        updateDrawableState();
        dw += mPaddingLeft + mPaddingRight;
        dh += mPaddingTop + mPaddingBottom;
        setMeasuredDimension(resolveSizeAndState(dw, widthMeasureSpec, 0),
                resolveSizeAndState(dh, heightMeasureSpec, 0));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.094 -0400", hash_original_method = "568F14E497668D52F70AE96AA5EB6F88", hash_generated_method = "2B34FA3925633B97C3B9967238FEABD8")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        updateDrawableState();
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //updateDrawableState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.094 -0400", hash_original_method = "952B851172F804A1D432AC87BADE94E9", hash_generated_method = "035F9AA26E84ABF84843C88F22BD02C4")
    private void updateDrawableState() {
        int[] state = getDrawableState();
        if(mProgressDrawable != null && mProgressDrawable.isStateful())        
        {
            mProgressDrawable.setState(state);
        } //End block
        if(mIndeterminateDrawable != null && mIndeterminateDrawable.isStateful())        
        {
            mIndeterminateDrawable.setState(state);
        } //End block
        // ---------- Original Method ----------
        //int[] state = getDrawableState();
        //if (mProgressDrawable != null && mProgressDrawable.isStateful()) {
            //mProgressDrawable.setState(state);
        //}
        //if (mIndeterminateDrawable != null && mIndeterminateDrawable.isStateful()) {
            //mIndeterminateDrawable.setState(state);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.094 -0400", hash_original_method = "875308A47ADC87038CC9E153A4D8FE71", hash_generated_method = "BA6E59010649E0AB5341D02027C12FCC")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.progress = mProgress;
        ss.secondaryProgress = mSecondaryProgress;
Parcelable var182E37827114C3F455816E0E29D81D76_1040674042 =         ss;
        var182E37827114C3F455816E0E29D81D76_1040674042.addTaint(taint);
        return var182E37827114C3F455816E0E29D81D76_1040674042;
        // ---------- Original Method ----------
        //Parcelable superState = super.onSaveInstanceState();
        //SavedState ss = new SavedState(superState);
        //ss.progress = mProgress;
        //ss.secondaryProgress = mSecondaryProgress;
        //return ss;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.094 -0400", hash_original_method = "A42CFAF758710477BAC4A7B2A0C98761", hash_generated_method = "03DA06A994E94488FD6261FD993B394B")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setProgress(ss.progress);
        setSecondaryProgress(ss.secondaryProgress);
        // ---------- Original Method ----------
        //SavedState ss = (SavedState) state;
        //super.onRestoreInstanceState(ss.getSuperState());
        //setProgress(ss.progress);
        //setSecondaryProgress(ss.secondaryProgress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.095 -0400", hash_original_method = "608AE3D8DA74959AA8F2204845C7317D", hash_generated_method = "BD28E03E51CC17CCA52C53EA3B241745")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        if(mIndeterminate)        
        {
            startAnimation();
        } //End block
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //if (mIndeterminate) {
            //startAnimation();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.095 -0400", hash_original_method = "3E30480EE15E7D073BA14A1FE62DC464", hash_generated_method = "4E75B1242BABD343DD6395D004C5A81F")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(mIndeterminate)        
        {
            stopAnimation();
        } //End block
        if(mRefreshProgressRunnable != null)        
        {
            removeCallbacks(mRefreshProgressRunnable);
        } //End block
        if(mAccessibilityEventSender != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.095 -0400", hash_original_method = "D1990D7DB1A5D8E4C14ADC3323533C4A", hash_generated_method = "C887023349DFAB3818350D8E5A890EB8")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        super.onInitializeAccessibilityEvent(event);
        event.setItemCount(mMax);
        event.setCurrentItemIndex(mProgress);
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //event.setItemCount(mMax);
        //event.setCurrentItemIndex(mProgress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.095 -0400", hash_original_method = "20F0DBCD6142D6C8A8DBD6A9085999AF", hash_generated_method = "8B96CF4A8042ACE3CB9E7F89C59F7EC8")
    private void scheduleAccessibilityEventSender() {
        if(mAccessibilityEventSender == null)        
        {
            mAccessibilityEventSender = new AccessibilityEventSender();
        } //End block
        else
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.095 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

        private int mId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.095 -0400", hash_original_field = "8E57A1AD458E8C11842F6CF5D7E06883", hash_generated_field = "1CA7BE0C4831604F244183A43ACB7282")

        private int mProgress;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.095 -0400", hash_original_field = "C415F34964DBD13CCA489700EA3A16EC", hash_generated_field = "E56F4B776FFB7A387D61A7DB69ED27F1")

        private boolean mFromUser;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.095 -0400", hash_original_method = "84E6436ACAD7BA9E1C46F86F0883DFAC", hash_generated_method = "5727DBFD18D074B41C6BDF42FF9875C9")
          RefreshProgressRunnable(int id, int progress, boolean fromUser) {
            mId = id;
            mProgress = progress;
            mFromUser = fromUser;
            // ---------- Original Method ----------
            //mId = id;
            //mProgress = progress;
            //mFromUser = fromUser;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.095 -0400", hash_original_method = "336F21C38B52B9E04C9FE91372F32949", hash_generated_method = "51D6F418402664ECDD0B0622CCD44263")
        public void run() {
            doRefreshProgress(mId, mProgress, mFromUser, true);
            mRefreshProgressRunnable = this;
            // ---------- Original Method ----------
            //doRefreshProgress(mId, mProgress, mFromUser, true);
            //mRefreshProgressRunnable = this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.096 -0400", hash_original_method = "992C4D927E51E72BEA0F4017381D8EC2", hash_generated_method = "A238CC5542317B5EC7A431478DA6D0E3")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.096 -0400", hash_original_field = "3C709B10A5D47BA33D85337DD9110917", hash_generated_field = "0E86867788D9F180E816D58F2E5188C6")

        int progress;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.096 -0400", hash_original_field = "FB93C6DAB209AD5362C10535696AC83A", hash_generated_field = "1F6D1EA8F68E49AFD9E30D4EFB3F6276")

        int secondaryProgress;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.096 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "3F4F70129FCB46E4AE0D334AE4D70CF6")
          SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.096 -0400", hash_original_method = "9D61E8AE00F16C0432FB33E15078B080", hash_generated_method = "9ED54A037992D9B4CCD324548CA845EB")
        private  SavedState(Parcel in) {
            super(in);
            progress = in.readInt();
            secondaryProgress = in.readInt();
            // ---------- Original Method ----------
            //progress = in.readInt();
            //secondaryProgress = in.readInt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.096 -0400", hash_original_method = "47949C0C27B3FB6F61C4F76D6E851E0A", hash_generated_method = "D43E3100F12AD41EF68715035B31EAFA")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            addTaint(flags);
            addTaint(out.getTaint());
            super.writeToParcel(out, flags);
            out.writeInt(progress);
            out.writeInt(secondaryProgress);
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeInt(progress);
            //out.writeInt(secondaryProgress);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.097 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.097 -0400", hash_original_method = "5812CBDC5E0171D8BC07CE56DB600368", hash_generated_method = "5812CBDC5E0171D8BC07CE56DB600368")
        public AccessibilityEventSender ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.097 -0400", hash_original_method = "D171B097136E37DF343D32BCCA8935F6", hash_generated_method = "2295CF57C52786E3AEEE5BA06534C7E1")
        public void run() {
            sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
            // ---------- Original Method ----------
            //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.097 -0400", hash_original_field = "D2DD2BB7F0B3E156DA500A133BC0E11B", hash_generated_field = "CC7511334507B624E41735D194F6E4E0")

    private static final int MAX_LEVEL = 10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.097 -0400", hash_original_field = "CB4F103AB492FC713BF751CD8A51F9C3", hash_generated_field = "39EF70D35A29D206C019E7A12A698D6D")

    private static final int ANIMATION_RESOLUTION = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.097 -0400", hash_original_field = "05B419CB9CCCDBAE7ED4E8EC7599640B", hash_generated_field = "81CDC7C9CA9F2EE4E05B25C5A8DB35B0")

    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
}

