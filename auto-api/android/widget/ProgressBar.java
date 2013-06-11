package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final int MAX_LEVEL = 10000;
    private static final int ANIMATION_RESOLUTION = 200;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.236 -0400", hash_original_method = "F5911F61390A242F23F5676C44FA4C61", hash_generated_method = "25A23576CFED552EAF394F8E88F22059")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProgressBar(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.236 -0400", hash_original_method = "D031AA7B7D98D3870546853F1BC5BC9E", hash_generated_method = "CE1B0FFDC157540C48CC76E99FA88AD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.progressBarStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.236 -0400", hash_original_method = "E1F87E741C36AFFDC636A9ACF6EDF064", hash_generated_method = "42C41A54CCD157FE6FD5015EB0F5711C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProgressBar(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, 0);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.237 -0400", hash_original_method = "DAE8B382D7288D55BBDECA5C905F6E78", hash_generated_method = "91381EEFD66873C149E4E430EDED79ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProgressBar(Context context, AttributeSet attrs, int defStyle, int styleRes) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(styleRes);
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
        final int resID;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.237 -0400", hash_original_method = "224A1F0FE2A7F3DC81BFFEE36861F394", hash_generated_method = "0BB3B79F427E65EB205559C5D2FAA656")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Drawable tileify(Drawable drawable, boolean clip) {
        dsTaint.addTaint(clip);
        dsTaint.addTaint(drawable.dsTaint);
        {
            LayerDrawable background;
            background = (LayerDrawable) drawable;
            final int N;
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
            final Bitmap tileBitmap;
            tileBitmap = ((BitmapDrawable) drawable).getBitmap();
            {
                mSampleTile = tileBitmap;
            } //End block
            final ShapeDrawable shapeDrawable;
            shapeDrawable = new ShapeDrawable(getDrawableShape());
            final BitmapShader bitmapShader;
            bitmapShader = new BitmapShader(tileBitmap,
                    Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
            shapeDrawable.getPaint().setShader(bitmapShader);
        } //End block
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.237 -0400", hash_original_method = "066FEFD8810FD39B2288696E8912725B", hash_generated_method = "ADCC4AC00A6E5C5C8FD9329C4D99A9D2")
    @DSModeled(DSC.SAFE)
     Shape getDrawableShape() {
        final float[] roundedCorners;
        roundedCorners = new float[] { 5, 5, 5, 5, 5, 5, 5, 5 };
        return (Shape)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final float[] roundedCorners = new float[] { 5, 5, 5, 5, 5, 5, 5, 5 };
        //return new RoundRectShape(roundedCorners, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.237 -0400", hash_original_method = "9EE7DD01E1AB6B0D269DB58A7544C17D", hash_generated_method = "302F0C2E4C0E6063901CE53C28785FA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Drawable tileifyIndeterminate(Drawable drawable) {
        dsTaint.addTaint(drawable.dsTaint);
        {
            AnimationDrawable background;
            background = (AnimationDrawable) drawable;
            final int N;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.237 -0400", hash_original_method = "E5E4BC7A2B363BE6E2FBD0B5C26F4050", hash_generated_method = "F5E0A01AC9BD76267689A9639190A1D2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.237 -0400", hash_original_method = "3387FD7633AB5B9FD9EC30B2946E89DA", hash_generated_method = "5FBB1148D2B64D7A59C41020EE92107A")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized boolean isIndeterminate() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIndeterminate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.238 -0400", hash_original_method = "9BFD2BF2FBC3833B7107C0E363644A89", hash_generated_method = "7EC2F4C93752740F73BC748CF3A72886")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.238 -0400", hash_original_method = "460B65565106BA0615FD22E30B040519", hash_generated_method = "439B364EF2DC0A543CC06BFA85FAA613")
    @DSModeled(DSC.SAFE)
    public Drawable getIndeterminateDrawable() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIndeterminateDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.238 -0400", hash_original_method = "4CAABA82B88C397ED0E927A2E15C90A0", hash_generated_method = "C390FB5355994E5ACDC1BADA9BEB72C3")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.238 -0400", hash_original_method = "6C8C8D805DC88A29293BE605923D5590", hash_generated_method = "082679FA3AAACA4CD251E68E7D645931")
    @DSModeled(DSC.SAFE)
    public Drawable getProgressDrawable() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mProgressDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.238 -0400", hash_original_method = "3733E64362DE34A69671D2EF5503886A", hash_generated_method = "BD4DC1E61E121F1C6E39011EC1421813")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.238 -0400", hash_original_method = "BC108B758414D6B13292C41A47E0F703", hash_generated_method = "A26D2C3B6AF2E37DE10C954FD72DBF92")
    @DSModeled(DSC.SAFE)
     Drawable getCurrentDrawable() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCurrentDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.238 -0400", hash_original_method = "56BA1F17FA722E2B64538801F5E2971D", hash_generated_method = "6522CCF317AB59C6BEB496330ED37487")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean verifyDrawable(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        boolean var5B9EE4C74328F86B7CFFFC48CC55DAFD_1119734234 = (who == mProgressDrawable || who == mIndeterminateDrawable
                || super.verifyDrawable(who));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return who == mProgressDrawable || who == mIndeterminateDrawable
                //|| super.verifyDrawable(who);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.238 -0400", hash_original_method = "7333172C31835F46D838DB3DB892DD55", hash_generated_method = "13B88CB363AEF610D026BF138CE57FEE")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.238 -0400", hash_original_method = "9D88EC1BAB8B30E9973F963BD590322C", hash_generated_method = "1E0102F5CF19DA7941A6A31B5DE66FBE")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.238 -0400", hash_original_method = "10671D93E2F61D98C60CD8288CC260A2", hash_generated_method = "68496051B83F34A6E886DDD23967D8CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void doRefreshProgress(int id, int progress, boolean fromUser,
            boolean callBackToApp) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(progress);
        dsTaint.addTaint(fromUser);
        dsTaint.addTaint(callBackToApp);
        float scale;
        scale = (float) progress / (float) mMax;
        scale = 0;
        final Drawable d;
        d = mCurrentDrawable;
        {
            Drawable progressDrawable;
            progressDrawable = null;
            {
                progressDrawable = ((LayerDrawable) d).findDrawableByLayerId(id);
            } //End block
            final int level;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.239 -0400", hash_original_method = "1EE4C81513694B44BBA27F5A11B0191B", hash_generated_method = "AB30230E1A0220F1391C4C742914E103")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onProgressRefresh(float scale, boolean fromUser) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(scale);
        dsTaint.addTaint(fromUser);
        {
            boolean varFEF5E81D9E4B252970529F0E4C094F45_1463310934 = (AccessibilityManager.getInstance(mContext).isEnabled());
            {
                scheduleAccessibilityEventSender();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (AccessibilityManager.getInstance(mContext).isEnabled()) {
            //scheduleAccessibilityEventSender();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.239 -0400", hash_original_method = "6344B397C965EAD8A2329C40E25F1FFC", hash_generated_method = "33BE478B3653A0F8392003C351272B29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void refreshProgress(int id, int progress, boolean fromUser) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(progress);
        dsTaint.addTaint(fromUser);
        {
            boolean var1CC5D58891D5AD9A5F4B0AE57801D9FB_1460155391 = (mUiThreadId == Thread.currentThread().getId());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.239 -0400", hash_original_method = "E60A634EF77869D698E2255CD3404933", hash_generated_method = "B4D0907FC2C8352C22B6FAA2D53FE6F1")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public synchronized void setProgress(int progress) {
        dsTaint.addTaint(progress);
        setProgress(progress, false);
        // ---------- Original Method ----------
        //setProgress(progress, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.239 -0400", hash_original_method = "65EDABD4A3EBF7E0899598C1A747DEC8", hash_generated_method = "5298BC1FFAC4AEF5DC27399EEDD2FBAF")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.239 -0400", hash_original_method = "9F9AE189F8359350B1506E3BE664E8EE", hash_generated_method = "A5948C0CC9859A204455DAED466A52AA")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.239 -0400", hash_original_method = "BF818051FE207A57D09CC2C24E2066F6", hash_generated_method = "1A9EFD67669D350298EA8F02E944A039")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getProgress() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mIndeterminate ? 0 : mProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.239 -0400", hash_original_method = "0E2189FB3CB300C00977FC2C3BDB4D4B", hash_generated_method = "F82B3E4B6B40E9550F9F6628E7B42D09")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getSecondaryProgress() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mIndeterminate ? 0 : mSecondaryProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.239 -0400", hash_original_method = "6E6A982D82D781B4C4E0B14E6160A2E7", hash_generated_method = "10D74DFFF88AF6611D501B0721763B74")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getMax() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMax;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.239 -0400", hash_original_method = "DB535D9F1C65E31A54636A6B02096562", hash_generated_method = "F343C75C9FDE30567F8029A1E1EE940B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.239 -0400", hash_original_method = "1E5C167C76FF3FF0E5E9EED4F2394FD5", hash_generated_method = "E540420188776C39F36B169681785A5E")
    @DSModeled(DSC.SAFE)
    public synchronized final void incrementProgressBy(int diff) {
        dsTaint.addTaint(diff);
        setProgress(mProgress + diff);
        // ---------- Original Method ----------
        //setProgress(mProgress + diff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.239 -0400", hash_original_method = "33F180031B438855CD8341D942A736A2", hash_generated_method = "658E8C7D6C918A9344B878440BEAB932")
    @DSModeled(DSC.SAFE)
    public synchronized final void incrementSecondaryProgressBy(int diff) {
        dsTaint.addTaint(diff);
        setSecondaryProgress(mSecondaryProgress + diff);
        // ---------- Original Method ----------
        //setSecondaryProgress(mSecondaryProgress + diff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.240 -0400", hash_original_method = "F5167F20A872A63C36DAF85A2B000FB5", hash_generated_method = "38F37C97766EE86BE8D342A0CD2E226F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void startAnimation() {
        {
            boolean varEB2DA232CDC62C684F55F26E8E4CF877_1785505911 = (getVisibility() != VISIBLE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.240 -0400", hash_original_method = "3AFE1BBA347326120AD78BEE94F7B2A6", hash_generated_method = "BBE50C9F5CF1D927CCC5F7ADB0F2B46E")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.240 -0400", hash_original_method = "2C6481DDCCEAC913795356C9BF1AF628", hash_generated_method = "084DD1A175B4A57CD663847655FA277E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInterpolator(Context context, int resID) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(resID);
        setInterpolator(AnimationUtils.loadInterpolator(context, resID));
        // ---------- Original Method ----------
        //setInterpolator(AnimationUtils.loadInterpolator(context, resID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.240 -0400", hash_original_method = "7D5A9A852D608ADF508B994526BF9EAC", hash_generated_method = "8BFFA42E2F11EC2F4AA064053DB323E7")
    @DSModeled(DSC.SAFE)
    public void setInterpolator(Interpolator interpolator) {
        dsTaint.addTaint(interpolator.dsTaint);
        // ---------- Original Method ----------
        //mInterpolator = interpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.240 -0400", hash_original_method = "8AA04851FFB5BE49EA5890940035B142", hash_generated_method = "68BD8EAF0EBFDD77CF24F1750A8A54DC")
    @DSModeled(DSC.SAFE)
    public Interpolator getInterpolator() {
        return (Interpolator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.240 -0400", hash_original_method = "EC8B18EE88EE8E09369A36DBF52DF684", hash_generated_method = "4C678A727829AF3444982347244256E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    @RemotableViewMethod
    public void setVisibility(int v) {
        dsTaint.addTaint(v);
        {
            boolean var4AC28F1E2836D09E4E72523D7E694F40_1641439405 = (getVisibility() != v);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.240 -0400", hash_original_method = "E937F441086D9A40C4DA651781180A92", hash_generated_method = "D5A1DF053AE6EB17BEDB546D97AEBCCC")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.240 -0400", hash_original_method = "51F010448C03C2EA1E2B7053B0DCB7DE", hash_generated_method = "9A6DF4E9A2A419087C9C89B7B9F6E205")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void invalidateDrawable(Drawable dr) {
        dsTaint.addTaint(dr.dsTaint);
        {
            {
                boolean varD1865A1D464E11906E399FDFD0B19F2A_1174315446 = (verifyDrawable(dr));
                {
                    final Rect dirty;
                    dirty = dr.getBounds();
                    final int scrollX;
                    scrollX = mScrollX + mPaddingLeft;
                    final int scrollY;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.240 -0400", hash_original_method = "74277B895F883AA5B2EB254A27C149C7", hash_generated_method = "65F5F456C413319AD36E0AB3D4EEA54B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getResolvedLayoutDirection(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_75129787 = (getResolvedLayoutDirection());
            Object var03FD24A395AACAA1B88D723AD820AD48_1126674070 = (super.getResolvedLayoutDirection(who));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (who == mProgressDrawable || who == mIndeterminateDrawable) ?
            //getResolvedLayoutDirection() : super.getResolvedLayoutDirection(who);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.240 -0400", hash_original_method = "69EE8DE1AB95A9498391F63C2C373DBD", hash_generated_method = "8B361E56A8B1B8821BA106C80FEA8BB4")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(w);
        dsTaint.addTaint(oldw);
        dsTaint.addTaint(oldh);
        dsTaint.addTaint(h);
        updateDrawableBounds(w, h);
        // ---------- Original Method ----------
        //updateDrawableBounds(w, h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.241 -0400", hash_original_method = "EA480A5BB3C1237E93332F6C8EE84591", hash_generated_method = "5CDF84057D6FFD9CB2D463D0FFBF924D")
    @DSModeled(DSC.SAFE)
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
                final int intrinsicWidth;
                intrinsicWidth = mIndeterminateDrawable.getIntrinsicWidth();
                final int intrinsicHeight;
                intrinsicHeight = mIndeterminateDrawable.getIntrinsicHeight();
                final float intrinsicAspect;
                intrinsicAspect = (float) intrinsicWidth / intrinsicHeight;
                final float boundAspect;
                boundAspect = (float) w / h;
                {
                    {
                        final int width;
                        width = (int) (h * intrinsicAspect);
                        left = (w - width) / 2;
                        right = left + width;
                    } //End block
                    {
                        final int height;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.241 -0400", hash_original_method = "16CD7BB578E96B322FC9201A377B65CC", hash_generated_method = "3B5D14AF5F0A5EFA0D422089CF09978C")
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
                    boolean var3836B93166D135D378CFC1C2C62A0477_1378158563 = (SystemClock.uptimeMillis() - mLastDrawTime >= mAnimationResolution);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.241 -0400", hash_original_method = "6FFAE46060D92EDBE1BD141B1F5C353A", hash_generated_method = "C1706EF0D26B81DE5AC7C222CBFE853D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.241 -0400", hash_original_method = "568F14E497668D52F70AE96AA5EB6F88", hash_generated_method = "65207BD8CBF6CCCA0D4B41EF86778E98")
    @DSModeled(DSC.SAFE)
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        updateDrawableState();
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //updateDrawableState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.241 -0400", hash_original_method = "952B851172F804A1D432AC87BADE94E9", hash_generated_method = "458AFE25A1A9460F1C5786F05F9D8A8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateDrawableState() {
        int[] state;
        state = getDrawableState();
        {
            boolean varC8B5BBFB2522EFF4A32AE45BFE86AD14_489343432 = (mProgressDrawable != null && mProgressDrawable.isStateful());
            {
                mProgressDrawable.setState(state);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varDF233AA74F13D8A45ED1CBF7F222603B_1571575609 = (mIndeterminateDrawable != null && mIndeterminateDrawable.isStateful());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.241 -0400", hash_original_method = "875308A47ADC87038CC9E153A4D8FE71", hash_generated_method = "3D5F79AA714EF9B5C819F03A5231670F")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.241 -0400", hash_original_method = "A42CFAF758710477BAC4A7B2A0C98761", hash_generated_method = "D79A8B644E9265E99112AC7BD3101138")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.242 -0400", hash_original_method = "608AE3D8DA74959AA8F2204845C7317D", hash_generated_method = "87B0A5599C9513623A2847B9C7C8243B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.242 -0400", hash_original_method = "3E30480EE15E7D073BA14A1FE62DC464", hash_generated_method = "0548DFF678BA07A993D58345566F6F16")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.242 -0400", hash_original_method = "D1990D7DB1A5D8E4C14ADC3323533C4A", hash_generated_method = "E2FDBE9276CCFC61585610090502DA7E")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.242 -0400", hash_original_method = "20F0DBCD6142D6C8A8DBD6A9085999AF", hash_generated_method = "F1A642442A515DE83B5E14957A32F211")
    @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.242 -0400", hash_original_method = "84E6436ACAD7BA9E1C46F86F0883DFAC", hash_generated_method = "173F5780D0B2E55992B7F40776EA824E")
        @DSModeled(DSC.SAFE)
         RefreshProgressRunnable(int id, int progress, boolean fromUser) {
            dsTaint.addTaint(id);
            dsTaint.addTaint(progress);
            dsTaint.addTaint(fromUser);
            // ---------- Original Method ----------
            //mId = id;
            //mProgress = progress;
            //mFromUser = fromUser;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.242 -0400", hash_original_method = "336F21C38B52B9E04C9FE91372F32949", hash_generated_method = "EA766BF631E6D13DB3F80EC308B5CAF6")
        @DSModeled(DSC.SAFE)
        public void run() {
            doRefreshProgress(mId, mProgress, mFromUser, true);
            mRefreshProgressRunnable = this;
            // ---------- Original Method ----------
            //doRefreshProgress(mId, mProgress, mFromUser, true);
            //mRefreshProgressRunnable = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.242 -0400", hash_original_method = "992C4D927E51E72BEA0F4017381D8EC2", hash_generated_method = "D5C1C9325CA05267AF826BE6596FEC1F")
        @DSModeled(DSC.SAFE)
        public void setup(int id, int progress, boolean fromUser) {
            dsTaint.addTaint(id);
            dsTaint.addTaint(progress);
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
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.242 -0400", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "6C6B0A873BD52E2752F88E9968D483CA")
            @DSModeled(DSC.SAFE)
            public SavedState createFromParcel(Parcel in) {
                dsTaint.addTaint(in.dsTaint);
                return (SavedState)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState(in);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.242 -0400", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "1325778BB443F872513E70F9A19C5918")
            @DSModeled(DSC.SAFE)
            public SavedState[] newArray(int size) {
                dsTaint.addTaint(size);
                return (SavedState[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState[size];
            }

            
}; //Transformed anonymous class
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.242 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "BBD854AA7A117C86D9FBF897ADE36FE1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SavedState(Parcelable superState) {
            super(superState);
            dsTaint.addTaint(superState.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.242 -0400", hash_original_method = "9D61E8AE00F16C0432FB33E15078B080", hash_generated_method = "542133BF0F8718674B3E909BD510CC46")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.242 -0400", hash_original_method = "47949C0C27B3FB6F61C4F76D6E851E0A", hash_generated_method = "9AE028587637FE64B737D53CFC81BCB5")
        @DSModeled(DSC.SAFE)
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

        
    }


    
    private class AccessibilityEventSender implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.242 -0400", hash_original_method = "D171B097136E37DF343D32BCCA8935F6", hash_generated_method = "FEF1396D4F2C1FE3BF25A7F63E73834E")
        @DSModeled(DSC.SAFE)
        public void run() {
            sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
            // ---------- Original Method ----------
            //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        }

        
    }


    
}


