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
    int mMinWidth;
    int mMaxWidth;
    int mMinHeight;
    int mMaxHeight;
    private int mProgress;
    private int mSecondaryProgress;
    private int mMax;
    private int mBehavior;
    private int mDuration;
    private boolean mIndeterminate;
    private boolean mOnlyIndeterminate;
    private Transformation mTransformation;
    private AlphaAnimation mAnimation;
    private Drawable mIndeterminateDrawable;
    private Drawable mProgressDrawable;
    private Drawable mCurrentDrawable;
    Bitmap mSampleTile;
    private boolean mNoInvalidate;
    private Interpolator mInterpolator;
    private RefreshProgressRunnable mRefreshProgressRunnable;
    private long mUiThreadId;
    private boolean mShouldStartAnimationDrawable;
    private long mLastDrawTime;
    private boolean mInDrawing;
    private int mAnimationResolution;
    private AccessibilityEventSender mAccessibilityEventSender;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.038 -0400", hash_original_method = "F5911F61390A242F23F5676C44FA4C61", hash_generated_method = "15ACAF215A6C5C0C35BC10F0FA9CE203")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProgressBar(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.038 -0400", hash_original_method = "D031AA7B7D98D3870546853F1BC5BC9E", hash_generated_method = "43A90D7E7C9A1C98A63E324577EAA326")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.progressBarStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.038 -0400", hash_original_method = "E1F87E741C36AFFDC636A9ACF6EDF064", hash_generated_method = "AA2BFD3B5FD3188B10B67B9E144A2134")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProgressBar(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, 0);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.039 -0400", hash_original_method = "DAE8B382D7288D55BBDECA5C905F6E78", hash_generated_method = "28A7AB25C1995D640F1123D141B01DF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProgressBar(Context context, AttributeSet attrs, int defStyle, int styleRes) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(styleRes);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        mUiThreadId = Thread.currentThread().getId();
        initProgressBar();
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, R.styleable.ProgressBar, defStyle, styleRes);
        mNoInvalidate = true;
        Drawable drawable;
        drawable = a.getDrawable(R.styleable.ProgressBar_progressDrawable);
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
        int resID;
        resID = a.getResourceId(
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.040 -0400", hash_original_method = "224A1F0FE2A7F3DC81BFFEE36861F394", hash_generated_method = "3F4A1D7FC0B2FC3577D6813E09363103")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Drawable tileify(Drawable drawable, boolean clip) {
        dsTaint.addTaint(clip);
        dsTaint.addTaint(drawable.dsTaint);
        {
            LayerDrawable background;
            background = (LayerDrawable) drawable;
            int N;
            N = background.getNumberOfLayers();
            Drawable[] outDrawables;
            outDrawables = new Drawable[N];
            {
                int i;
                i = 0;
                {
                    int id;
                    id = background.getId(i);
                    outDrawables[i] = tileify(background.getDrawable(i),
                        (id == R.id.progress || id == R.id.secondaryProgress));
                } //End block
            } //End collapsed parenthetic
            LayerDrawable newBg;
            newBg = new LayerDrawable(outDrawables);
            {
                int i;
                i = 0;
                {
                    newBg.setId(i, background.getId(i));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            StateListDrawable in;
            in = (StateListDrawable) drawable;
            StateListDrawable out;
            out = new StateListDrawable();
            int numStates;
            numStates = in.getStateCount();
            {
                int i;
                i = 0;
                {
                    out.addState(in.getStateSet(i), tileify(in.getStateDrawable(i), clip));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            Bitmap tileBitmap;
            tileBitmap = ((BitmapDrawable) drawable).getBitmap();
            {
                mSampleTile = tileBitmap;
            } //End block
            ShapeDrawable shapeDrawable;
            shapeDrawable = new ShapeDrawable(getDrawableShape());
            BitmapShader bitmapShader;
            bitmapShader = new BitmapShader(tileBitmap,
                    Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
            shapeDrawable.getPaint().setShader(bitmapShader);
            {
                Object var8B12F9BFFA98F68A4549ACB2CE810290_1343459255 = (new ClipDrawable(shapeDrawable, Gravity.LEFT,
                    ClipDrawable.HORIZONTAL));
            } //End flattened ternary
        } //End block
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.040 -0400", hash_original_method = "066FEFD8810FD39B2288696E8912725B", hash_generated_method = "5C3272BE2AF634F3B4E72C028F2CE618")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Shape getDrawableShape() {
        float[] roundedCorners;
        roundedCorners = new float[] { 5, 5, 5, 5, 5, 5, 5, 5 };
        Shape var02A57DA10DE338DD486CF0A73C581C27_1212127531 = (new RoundRectShape(roundedCorners, null, null));
        return (Shape)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final float[] roundedCorners = new float[] { 5, 5, 5, 5, 5, 5, 5, 5 };
        //return new RoundRectShape(roundedCorners, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.040 -0400", hash_original_method = "9EE7DD01E1AB6B0D269DB58A7544C17D", hash_generated_method = "09371A0B3A983D2ABCF53BA57AA41C08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Drawable tileifyIndeterminate(Drawable drawable) {
        dsTaint.addTaint(drawable.dsTaint);
        {
            AnimationDrawable background;
            background = (AnimationDrawable) drawable;
            int N;
            N = background.getNumberOfFrames();
            AnimationDrawable newBg;
            newBg = new AnimationDrawable();
            newBg.setOneShot(background.isOneShot());
            {
                int i;
                i = 0;
                {
                    Drawable frame;
                    frame = tileify(background.getFrame(i), true);
                    frame.setLevel(10000);
                    newBg.addFrame(frame, background.getDuration(i));
                } //End block
            } //End collapsed parenthetic
            newBg.setLevel(10000);
            drawable = newBg;
        } //End block
        return (Drawable)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.041 -0400", hash_original_method = "E5E4BC7A2B363BE6E2FBD0B5C26F4050", hash_generated_method = "8DA820DB7B007C068BE9D230A5110A34")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.041 -0400", hash_original_method = "3387FD7633AB5B9FD9EC30B2946E89DA", hash_generated_method = "A7E17D646BEE2DD64244302F2B958CE1")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized boolean isIndeterminate() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIndeterminate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.041 -0400", hash_original_method = "9BFD2BF2FBC3833B7107C0E363644A89", hash_generated_method = "413FB593104565409C6775CEC48A15C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public synchronized void setIndeterminate(boolean indeterminate) {
        dsTaint.addTaint(indeterminate);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.041 -0400", hash_original_method = "460B65565106BA0615FD22E30B040519", hash_generated_method = "403A0BFF09E00A5DE1ADB491B4F090FC")
    @DSModeled(DSC.SAFE)
    public Drawable getIndeterminateDrawable() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIndeterminateDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.042 -0400", hash_original_method = "4CAABA82B88C397ED0E927A2E15C90A0", hash_generated_method = "6E24F2885EEE6BD4354EF7E2E9665F41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIndeterminateDrawable(Drawable d) {
        dsTaint.addTaint(d.dsTaint);
        {
            d.setCallback(this);
        } //End block
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.042 -0400", hash_original_method = "6C8C8D805DC88A29293BE605923D5590", hash_generated_method = "ABC640DB6A0849C2E30AECA4D58E80F5")
    @DSModeled(DSC.SAFE)
    public Drawable getProgressDrawable() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mProgressDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.042 -0400", hash_original_method = "3733E64362DE34A69671D2EF5503886A", hash_generated_method = "C37D441D3194A061E640022EE5B1530A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setProgressDrawable(Drawable d) {
        dsTaint.addTaint(d.dsTaint);
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
            int drawableHeight;
            drawableHeight = d.getMinimumHeight();
            {
                mMaxHeight = drawableHeight;
                requestLayout();
            } //End block
        } //End block
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.042 -0400", hash_original_method = "BC108B758414D6B13292C41A47E0F703", hash_generated_method = "DA11C1FDCFD6158B772D4EB442A9DC9B")
    @DSModeled(DSC.SAFE)
     Drawable getCurrentDrawable() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCurrentDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.042 -0400", hash_original_method = "56BA1F17FA722E2B64538801F5E2971D", hash_generated_method = "D06AF9D67CAF45A7B3A63BEF78F640FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean verifyDrawable(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        boolean var5B9EE4C74328F86B7CFFFC48CC55DAFD_1201561307 = (who == mProgressDrawable || who == mIndeterminateDrawable
                || super.verifyDrawable(who));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return who == mProgressDrawable || who == mIndeterminateDrawable
                //|| super.verifyDrawable(who);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.043 -0400", hash_original_method = "7333172C31835F46D838DB3DB892DD55", hash_generated_method = "787AD68239E9E5B97EC1726229EFB8B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.043 -0400", hash_original_method = "9D88EC1BAB8B30E9973F963BD590322C", hash_generated_method = "E90B41141854785CFB2802E07DE0408A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.043 -0400", hash_original_method = "10671D93E2F61D98C60CD8288CC260A2", hash_generated_method = "15E5AE8ADC3B6E0DBE9587698327AF0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void doRefreshProgress(int id, int progress, boolean fromUser,
            boolean callBackToApp) {
        dsTaint.addTaint(progress);
        dsTaint.addTaint(id);
        dsTaint.addTaint(callBackToApp);
        dsTaint.addTaint(fromUser);
        float scale;
        scale = (float) progress / (float) mMax;
        scale = 0;
        Drawable d;
        d = mCurrentDrawable;
        {
            Drawable progressDrawable;
            progressDrawable = null;
            {
                progressDrawable = ((LayerDrawable) d).findDrawableByLayerId(id);
            } //End block
            int level;
            level = (int) (scale * MAX_LEVEL);
            (progressDrawable != null ? progressDrawable : d).setLevel(level);
        } //End block
        {
            invalidate();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.043 -0400", hash_original_method = "1EE4C81513694B44BBA27F5A11B0191B", hash_generated_method = "6DFC3664EEE8E302C0B387B882143118")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onProgressRefresh(float scale, boolean fromUser) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(scale);
        dsTaint.addTaint(fromUser);
        {
            boolean varFEF5E81D9E4B252970529F0E4C094F45_1771652867 = (AccessibilityManager.getInstance(mContext).isEnabled());
            {
                scheduleAccessibilityEventSender();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (AccessibilityManager.getInstance(mContext).isEnabled()) {
            //scheduleAccessibilityEventSender();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.044 -0400", hash_original_method = "6344B397C965EAD8A2329C40E25F1FFC", hash_generated_method = "0B041C2B910D29F34F2CD411E5DB8699")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void refreshProgress(int id, int progress, boolean fromUser) {
        dsTaint.addTaint(progress);
        dsTaint.addTaint(id);
        dsTaint.addTaint(fromUser);
        {
            boolean var1CC5D58891D5AD9A5F4B0AE57801D9FB_819021722 = (mUiThreadId == Thread.currentThread().getId());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.044 -0400", hash_original_method = "E60A634EF77869D698E2255CD3404933", hash_generated_method = "6A7024C8F4DEBABEB6D7B8111D2FD98E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public synchronized void setProgress(int progress) {
        dsTaint.addTaint(progress);
        setProgress(progress, false);
        // ---------- Original Method ----------
        //setProgress(progress, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.044 -0400", hash_original_method = "65EDABD4A3EBF7E0899598C1A747DEC8", hash_generated_method = "55A1B8B597832EB6652C0921F49ECBEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    synchronized void setProgress(int progress, boolean fromUser) {
        dsTaint.addTaint(progress);
        dsTaint.addTaint(fromUser);
        {
            progress = 0;
        } //End block
        {
            progress = mMax;
        } //End block
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.045 -0400", hash_original_method = "9F9AE189F8359350B1506E3BE664E8EE", hash_generated_method = "23A1767233B15E71054D9EEAABA96496")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public synchronized void setSecondaryProgress(int secondaryProgress) {
        dsTaint.addTaint(secondaryProgress);
        {
            secondaryProgress = 0;
        } //End block
        {
            secondaryProgress = mMax;
        } //End block
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.045 -0400", hash_original_method = "BF818051FE207A57D09CC2C24E2066F6", hash_generated_method = "DD091EBD6E21FB32EE083F0B398B0042")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getProgress() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mIndeterminate ? 0 : mProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.045 -0400", hash_original_method = "0E2189FB3CB300C00977FC2C3BDB4D4B", hash_generated_method = "EB0A3EF64CD7C2B3737C9C89E86CFF1D")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getSecondaryProgress() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mIndeterminate ? 0 : mSecondaryProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.045 -0400", hash_original_method = "6E6A982D82D781B4C4E0B14E6160A2E7", hash_generated_method = "1995EE05AA210998EF8BC69D1FE13EF0")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getMax() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMax;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.045 -0400", hash_original_method = "DB535D9F1C65E31A54636A6B02096562", hash_generated_method = "C82D32A73D4CAD18ABD2361C219FC246")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public synchronized void setMax(int max) {
        dsTaint.addTaint(max);
        {
            max = 0;
        } //End block
        {
            postInvalidate();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.046 -0400", hash_original_method = "1E5C167C76FF3FF0E5E9EED4F2394FD5", hash_generated_method = "9C23357632B086CA53844833C2D96D27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized final void incrementProgressBy(int diff) {
        dsTaint.addTaint(diff);
        setProgress(mProgress + diff);
        // ---------- Original Method ----------
        //setProgress(mProgress + diff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.046 -0400", hash_original_method = "33F180031B438855CD8341D942A736A2", hash_generated_method = "AC197061954FB146665BBA4168021B1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized final void incrementSecondaryProgressBy(int diff) {
        dsTaint.addTaint(diff);
        setSecondaryProgress(mSecondaryProgress + diff);
        // ---------- Original Method ----------
        //setSecondaryProgress(mSecondaryProgress + diff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.046 -0400", hash_original_method = "F5167F20A872A63C36DAF85A2B000FB5", hash_generated_method = "FB4DBC4EE421DF12C28FDB7073B73D50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void startAnimation() {
        {
            boolean varEB2DA232CDC62C684F55F26E8E4CF877_1034902388 = (getVisibility() != VISIBLE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.046 -0400", hash_original_method = "3AFE1BBA347326120AD78BEE94F7B2A6", hash_generated_method = "A23A36E546002B56E789E6B1959E55BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.047 -0400", hash_original_method = "2C6481DDCCEAC913795356C9BF1AF628", hash_generated_method = "98C0D27C587C4CDF7DDFA11AC2FF23E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInterpolator(Context context, int resID) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(resID);
        setInterpolator(AnimationUtils.loadInterpolator(context, resID));
        // ---------- Original Method ----------
        //setInterpolator(AnimationUtils.loadInterpolator(context, resID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.047 -0400", hash_original_method = "7D5A9A852D608ADF508B994526BF9EAC", hash_generated_method = "A14ED552F9DB6BE8496AFC6BEA170232")
    @DSModeled(DSC.SAFE)
    public void setInterpolator(Interpolator interpolator) {
        dsTaint.addTaint(interpolator.dsTaint);
        // ---------- Original Method ----------
        //mInterpolator = interpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.047 -0400", hash_original_method = "8AA04851FFB5BE49EA5890940035B142", hash_generated_method = "76053164EB61152210D7C18D58A6F349")
    @DSModeled(DSC.SAFE)
    public Interpolator getInterpolator() {
        return (Interpolator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.047 -0400", hash_original_method = "EC8B18EE88EE8E09369A36DBF52DF684", hash_generated_method = "99A77593FD653A1B3C5D7059F9D7DE0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    @RemotableViewMethod
    public void setVisibility(int v) {
        dsTaint.addTaint(v);
        {
            boolean var4AC28F1E2836D09E4E72523D7E694F40_1584610045 = (getVisibility() != v);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.047 -0400", hash_original_method = "E937F441086D9A40C4DA651781180A92", hash_generated_method = "956948A4E833E8A42507B2D0ADCE0F26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(visibility);
        dsTaint.addTaint(changedView.dsTaint);
        super.onVisibilityChanged(changedView, visibility);
        {
            {
                stopAnimation();
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.048 -0400", hash_original_method = "51F010448C03C2EA1E2B7053B0DCB7DE", hash_generated_method = "3749820AEDF220E6801CB4DE70CD7355")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void invalidateDrawable(Drawable dr) {
        dsTaint.addTaint(dr.dsTaint);
        {
            {
                boolean varD1865A1D464E11906E399FDFD0B19F2A_1552355887 = (verifyDrawable(dr));
                {
                    Rect dirty;
                    dirty = dr.getBounds();
                    int scrollX;
                    scrollX = mScrollX + mPaddingLeft;
                    int scrollY;
                    scrollY = mScrollY + mPaddingTop;
                    invalidate(dirty.left + scrollX, dirty.top + scrollY,
                        dirty.right + scrollX, dirty.bottom + scrollY);
                } //End block
                {
                    super.invalidateDrawable(dr);
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.048 -0400", hash_original_method = "74277B895F883AA5B2EB254A27C149C7", hash_generated_method = "48976378A092349B8E4979539204D540")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getResolvedLayoutDirection(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_888957580 = (getResolvedLayoutDirection());
            Object var03FD24A395AACAA1B88D723AD820AD48_1009839703 = (super.getResolvedLayoutDirection(who));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (who == mProgressDrawable || who == mIndeterminateDrawable) ?
            //getResolvedLayoutDirection() : super.getResolvedLayoutDirection(who);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.048 -0400", hash_original_method = "69EE8DE1AB95A9498391F63C2C373DBD", hash_generated_method = "5E9A16778128982ED368F6FEAF18809D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(w);
        dsTaint.addTaint(oldh);
        dsTaint.addTaint(oldw);
        dsTaint.addTaint(h);
        updateDrawableBounds(w, h);
        // ---------- Original Method ----------
        //updateDrawableBounds(w, h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.049 -0400", hash_original_method = "EA480A5BB3C1237E93332F6C8EE84591", hash_generated_method = "D951048AC2D0136E197C83C31B8E8C21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateDrawableBounds(int w, int h) {
        dsTaint.addTaint(w);
        dsTaint.addTaint(h);
        int right;
        right = w - mPaddingRight - mPaddingLeft;
        int bottom;
        bottom = h - mPaddingBottom - mPaddingTop;
        int top;
        top = 0;
        int left;
        left = 0;
        {
            {
                int intrinsicWidth;
                intrinsicWidth = mIndeterminateDrawable.getIntrinsicWidth();
                int intrinsicHeight;
                intrinsicHeight = mIndeterminateDrawable.getIntrinsicHeight();
                float intrinsicAspect;
                intrinsicAspect = (float) intrinsicWidth / intrinsicHeight;
                float boundAspect;
                boundAspect = (float) w / h;
                {
                    {
                        int width;
                        width = (int) (h * intrinsicAspect);
                        left = (w - width) / 2;
                        right = left + width;
                    } //End block
                    {
                        int height;
                        height = (int) (w * (1 / intrinsicAspect));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.049 -0400", hash_original_method = "16CD7BB578E96B322FC9201A377B65CC", hash_generated_method = "BDF46F4C9389DE589225796FCB084F59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected synchronized void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(canvas.dsTaint);
        super.onDraw(canvas);
        Drawable d;
        d = mCurrentDrawable;
        {
            canvas.save();
            canvas.translate(mPaddingLeft, mPaddingTop);
            long time;
            time = getDrawingTime();
            {
                mAnimation.getTransformation(time, mTransformation);
                float scale;
                scale = mTransformation.getAlpha();
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
                    boolean var3836B93166D135D378CFC1C2C62A0477_2044402005 = (SystemClock.uptimeMillis() - mLastDrawTime >= mAnimationResolution);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.050 -0400", hash_original_method = "6FFAE46060D92EDBE1BD141B1F5C353A", hash_generated_method = "2069D58563BF974397ECB6093324F12B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        Drawable d;
        d = mCurrentDrawable;
        int dw;
        dw = 0;
        int dh;
        dh = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.050 -0400", hash_original_method = "568F14E497668D52F70AE96AA5EB6F88", hash_generated_method = "2B34FA3925633B97C3B9967238FEABD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        updateDrawableState();
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //updateDrawableState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.051 -0400", hash_original_method = "952B851172F804A1D432AC87BADE94E9", hash_generated_method = "8C1BEC8D24D71CE90E8BC14C3B443EF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateDrawableState() {
        int[] state;
        state = getDrawableState();
        {
            boolean varC8B5BBFB2522EFF4A32AE45BFE86AD14_1100934695 = (mProgressDrawable != null && mProgressDrawable.isStateful());
            {
                mProgressDrawable.setState(state);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varDF233AA74F13D8A45ED1CBF7F222603B_865977535 = (mIndeterminateDrawable != null && mIndeterminateDrawable.isStateful());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.051 -0400", hash_original_method = "875308A47ADC87038CC9E153A4D8FE71", hash_generated_method = "7BBDFA4F7663574AEDF59A9E1A756963")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable superState;
        superState = super.onSaveInstanceState();
        SavedState ss;
        ss = new SavedState(superState);
        ss.progress = mProgress;
        ss.secondaryProgress = mSecondaryProgress;
        return (Parcelable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Parcelable superState = super.onSaveInstanceState();
        //SavedState ss = new SavedState(superState);
        //ss.progress = mProgress;
        //ss.secondaryProgress = mSecondaryProgress;
        //return ss;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.051 -0400", hash_original_method = "A42CFAF758710477BAC4A7B2A0C98761", hash_generated_method = "575C676E27AAF4492DB4BEB06AC34494")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state.dsTaint);
        SavedState ss;
        ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setProgress(ss.progress);
        setSecondaryProgress(ss.secondaryProgress);
        // ---------- Original Method ----------
        //SavedState ss = (SavedState) state;
        //super.onRestoreInstanceState(ss.getSuperState());
        //setProgress(ss.progress);
        //setSecondaryProgress(ss.secondaryProgress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.051 -0400", hash_original_method = "608AE3D8DA74959AA8F2204845C7317D", hash_generated_method = "AF5D2862F20D4786D23B7B35E3696FCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.052 -0400", hash_original_method = "3E30480EE15E7D073BA14A1FE62DC464", hash_generated_method = "2DB66FDCAA43B67C9554732958CC5D6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.052 -0400", hash_original_method = "D1990D7DB1A5D8E4C14ADC3323533C4A", hash_generated_method = "E88210FE34815D0C6C7C36F12B8C141D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        super.onInitializeAccessibilityEvent(event);
        event.setItemCount(mMax);
        event.setCurrentItemIndex(mProgress);
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //event.setItemCount(mMax);
        //event.setCurrentItemIndex(mProgress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.052 -0400", hash_original_method = "20F0DBCD6142D6C8A8DBD6A9085999AF", hash_generated_method = "60F29FAE9C16BE6E15DFD777D11B9B28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        private int mId;
        private int mProgress;
        private boolean mFromUser;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.052 -0400", hash_original_method = "84E6436ACAD7BA9E1C46F86F0883DFAC", hash_generated_method = "C53BB09DF32699218A7339FDE2FA375D")
        @DSModeled(DSC.SAFE)
         RefreshProgressRunnable(int id, int progress, boolean fromUser) {
            dsTaint.addTaint(progress);
            dsTaint.addTaint(id);
            dsTaint.addTaint(fromUser);
            // ---------- Original Method ----------
            //mId = id;
            //mProgress = progress;
            //mFromUser = fromUser;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.052 -0400", hash_original_method = "336F21C38B52B9E04C9FE91372F32949", hash_generated_method = "51D6F418402664ECDD0B0622CCD44263")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            doRefreshProgress(mId, mProgress, mFromUser, true);
            mRefreshProgressRunnable = this;
            // ---------- Original Method ----------
            //doRefreshProgress(mId, mProgress, mFromUser, true);
            //mRefreshProgressRunnable = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.053 -0400", hash_original_method = "992C4D927E51E72BEA0F4017381D8EC2", hash_generated_method = "C20C840D9DA2D01CBEEC76A8FB62963D")
        @DSModeled(DSC.SAFE)
        public void setup(int id, int progress, boolean fromUser) {
            dsTaint.addTaint(progress);
            dsTaint.addTaint(id);
            dsTaint.addTaint(fromUser);
            // ---------- Original Method ----------
            //mId = id;
            //mProgress = progress;
            //mFromUser = fromUser;
        }

        
    }


    
    static class SavedState extends BaseSavedState {
        int progress;
        int secondaryProgress;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.053 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "AB6E14E26999AC4D7AF1972CF22F65E4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SavedState(Parcelable superState) {
            super(superState);
            dsTaint.addTaint(superState.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.053 -0400", hash_original_method = "9D61E8AE00F16C0432FB33E15078B080", hash_generated_method = "7599CB9369733076EA9968A540FA9A51")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private SavedState(Parcel in) {
            super(in);
            dsTaint.addTaint(in.dsTaint);
            progress = in.readInt();
            secondaryProgress = in.readInt();
            // ---------- Original Method ----------
            //progress = in.readInt();
            //secondaryProgress = in.readInt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.053 -0400", hash_original_method = "47949C0C27B3FB6F61C4F76D6E851E0A", hash_generated_method = "A689BA23AD72C9120C382BF6071D0579")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void writeToParcel(Parcel out, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(out.dsTaint);
            super.writeToParcel(out, flags);
            out.writeInt(progress);
            out.writeInt(secondaryProgress);
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeInt(progress);
            //out.writeInt(secondaryProgress);
        }

        
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.053 -0400", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "39BCD7AD56D29AA778F178DE51A0B1AE")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SavedState createFromParcel(Parcel in) {
                dsTaint.addTaint(in.dsTaint);
                SavedState var41ED8F3548F5060881BBE51AB9112A3F_1109693791 = (new SavedState(in));
                return (SavedState)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState(in);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.054 -0400", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "58D254F4F67C9AA011A25933F6EC9F25")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SavedState[] newArray(int size) {
                dsTaint.addTaint(size);
                SavedState[] varB5C72E5BBB181D4CA93D7BAA0B8B5E3D_964852385 = (new SavedState[size]);
                return (SavedState[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState[size];
            }

            
}; //Transformed anonymous class
    }


    
    private class AccessibilityEventSender implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.054 -0400", hash_original_method = "4C38828AD79D0D2F452DE2611F79503D", hash_generated_method = "4C38828AD79D0D2F452DE2611F79503D")
                public AccessibilityEventSender ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.054 -0400", hash_original_method = "D171B097136E37DF343D32BCCA8935F6", hash_generated_method = "2295CF57C52786E3AEEE5BA06534C7E1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
            // ---------- Original Method ----------
            //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        }

        
    }


    
    private static final int MAX_LEVEL = 10000;
    private static final int ANIMATION_RESOLUTION = 200;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
}

