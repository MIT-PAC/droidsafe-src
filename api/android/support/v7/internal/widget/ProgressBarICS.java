package android.support.v7.internal.widget;

/*
 * Copyright (C) 2013 Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/**
 * @hide
 */
public class ProgressBarICS extends View {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.209 -0400", hash_original_field = "1496E1C556157C5FD3FDE79598CDF532", hash_generated_field = "CC7511334507B624E41735D194F6E4E0")


    private static final int MAX_LEVEL = 10000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.211 -0400", hash_original_field = "DE20DBD72E84B094A00D03E5F4058886", hash_generated_field = "39EF70D35A29D206C019E7A12A698D6D")

    private static final int ANIMATION_RESOLUTION = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.214 -0400", hash_original_field = "2507B29C1782B76D09D4FA5F093B32F0", hash_generated_field = "18EC6FFE7818688A7EBC6145E87A3963")

    private static final int[] android_R_styleable_ProgressBar = new int[]{
            android.R.attr.max,
            android.R.attr.progress,
            android.R.attr.secondaryProgress,
            android.R.attr.indeterminate,
            android.R.attr.indeterminateOnly,
            android.R.attr.indeterminateDrawable,
            android.R.attr.progressDrawable,
            android.R.attr.indeterminateDuration,
            android.R.attr.indeterminateBehavior,
            android.R.attr.minWidth,
            android.R.attr.maxWidth,
            android.R.attr.minHeight,
            android.R.attr.maxHeight,
            android.R.attr.interpolator,
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.215 -0400", hash_original_field = "B5D566AA92521F570066E8773A24B0C0", hash_generated_field = "B5D566AA92521F570066E8773A24B0C0")


    int mMinWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.217 -0400", hash_original_field = "DE6F7D0025A7518849324A9E1601224A", hash_generated_field = "DE6F7D0025A7518849324A9E1601224A")

    int mMaxWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.220 -0400", hash_original_field = "0DD4F81D09F8349C333039CCE34B2CF7", hash_generated_field = "0DD4F81D09F8349C333039CCE34B2CF7")

    int mMinHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.222 -0400", hash_original_field = "2B42F0B48BA5A796B2697835D2F18090", hash_generated_field = "2B42F0B48BA5A796B2697835D2F18090")

    int mMaxHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.224 -0400", hash_original_field = "7CDF5A45863735DC45D655DB7E365343", hash_generated_field = "1CA7BE0C4831604F244183A43ACB7282")


    private int mProgress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.226 -0400", hash_original_field = "58F48CA09A1DEC274EE2E349256BF813", hash_generated_field = "015CFC0D453C8DA6A402F32079F8A6A4")

    private int mSecondaryProgress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.228 -0400", hash_original_field = "643806E929E292CCE314B6AD18027C00", hash_generated_field = "A1BFCC57A6BC96010A1D330EF07F3F34")

    private int mMax;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.230 -0400", hash_original_field = "C0FAA889F27EDA16D523267D3E01AF97", hash_generated_field = "7AB98B3DA8DC606CB1698898E1D5910B")


    private int mBehavior;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.232 -0400", hash_original_field = "BC345057CF9CBE8611DA24E477E3EC27", hash_generated_field = "A658ABE5235D82E385D992CF2A9ACD3B")

    private int mDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.234 -0400", hash_original_field = "0D148F2C69F7B5D4956EFF238B82CCCF", hash_generated_field = "92F2421E00AF2915B64A009A8AEF51CA")

    private boolean mIndeterminate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.236 -0400", hash_original_field = "8D6F8F24BD3E8D16C7D8EDD479BE4D36", hash_generated_field = "C1DA2FED56001BDE5D0AD3FEFBE7FD96")

    private boolean mOnlyIndeterminate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.238 -0400", hash_original_field = "D7452398083A8158EC2258CE710AF169", hash_generated_field = "2643C4FF32FBB404667FBA24AD639E50")

    private Transformation mTransformation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.240 -0400", hash_original_field = "7849FCBAD521645A9FD25D981C5FB3CD", hash_generated_field = "57388EC69EE573DE5E4AF3A536B016D4")

    private AlphaAnimation mAnimation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.242 -0400", hash_original_field = "ACF08658A02B579A46D5805654850485", hash_generated_field = "C689AC3D1D2B848F3E53B0D791A6559F")

    private Drawable mIndeterminateDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.244 -0400", hash_original_field = "5D7F822ED6B0FEE4C7B4B596E0F35534", hash_generated_field = "C7829E00A6912D78CF4DAAA1F03878F2")

    private Drawable mProgressDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.246 -0400", hash_original_field = "F46103DB1FD9DFCD58939843BB73C39E", hash_generated_field = "90CE76B172D180EF24FA84EA783D3205")

    private Drawable mCurrentDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.248 -0400", hash_original_field = "A2E623BE945F90A1659BB6259980C46A", hash_generated_field = "A2E623BE945F90A1659BB6259980C46A")

    Bitmap mSampleTile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.250 -0400", hash_original_field = "EB51415A899B076FAA29104E03FDC65B", hash_generated_field = "CA606DE6031B2AD65CB031A15282E5C0")

    private boolean mNoInvalidate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.252 -0400", hash_original_field = "A1326AE9004157E0812422F0F20CD6F9", hash_generated_field = "67BF1E9EFEC019D28BF77934CF035B72")

    private Interpolator mInterpolator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.254 -0400", hash_original_field = "BA73900692161E788233BDEAE97C3D49", hash_generated_field = "8ACA154D8775441FD3732F1D17C67323")

    private RefreshProgressRunnable mRefreshProgressRunnable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.255 -0400", hash_original_field = "B1BC3A9B57A62980AAB3CDF8C8A1BB60", hash_generated_field = "CD5745C207A6BF8B60FA99DC96FB59AD")

    private long mUiThreadId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.257 -0400", hash_original_field = "CCBAD50B4E2548F835C8997A08B254D3", hash_generated_field = "359DB1662474C9DDA50E3F28F77D23F6")

    private boolean mShouldStartAnimationDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.259 -0400", hash_original_field = "1BD45591A95C9F5C2B8DC0805F99A777", hash_generated_field = "40DA5017CC9E425245C6E3C14B2FC5CA")

    private long mLastDrawTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.261 -0400", hash_original_field = "46DA55E63CE38C818116D2946753B27E", hash_generated_field = "9E34047AEA414B2399121C937D10E14B")


    private boolean mInDrawing;

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.265 -0400", hash_original_method = "4767712DA18EE3FF6DFD78ACB6FF97DD", hash_generated_method = "BFB2C1F3A7EACE59C626B36AFE75DE0A")
    
public ProgressBarICS(Context context, AttributeSet attrs, int defStyle, int styleRes) {
        super(context, attrs, defStyle);
        mUiThreadId = Thread.currentThread().getId();
        initProgressBar();

        TypedArray a = context.obtainStyledAttributes(attrs, android_R_styleable_ProgressBar,
                defStyle, styleRes);

        mNoInvalidate = true;

        setMax(a.getInt(0, mMax));
        setProgress(a.getInt(1, mProgress));
        setSecondaryProgress(a.getInt(2, mSecondaryProgress));

        final boolean indeterminate = a.getBoolean(3, mIndeterminate);
        mOnlyIndeterminate = a.getBoolean(4, mOnlyIndeterminate);

        Drawable drawable = a.getDrawable(5);
        if (drawable != null) {
            drawable = tileifyIndeterminate(drawable);
            setIndeterminateDrawable(drawable);
        }

        drawable = a.getDrawable(6);
        if (drawable != null) {
            drawable = tileify(drawable, false);
            // Calling this method can set mMaxHeight, make sure the corresponding
            // XML attribute for mMaxHeight is read after calling this method
            setProgressDrawable(drawable);
        }

        mDuration = a.getInt(7, mDuration);
        mBehavior = a.getInt(8, mBehavior);
        mMinWidth = a.getDimensionPixelSize(9, mMinWidth);
        mMaxWidth = a.getDimensionPixelSize(10, mMaxWidth);
        mMinHeight = a.getDimensionPixelSize(11, mMinHeight);
        mMaxHeight = a.getDimensionPixelSize(12, mMaxHeight);

        final int resID = a.getResourceId(13, android.R.anim.linear_interpolator);
        if (resID > 0) {
            setInterpolator(context, resID);
        }

        a.recycle();

        mNoInvalidate = false;
        setIndeterminate(mOnlyIndeterminate || indeterminate);
    }

    /**
     * Converts a drawable to a tiled version of itself. It will recursively
     * traverse layer and state list drawables.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.270 -0400", hash_original_method = "38BEBCC73AF98F5C4AF8ECDEA5782184", hash_generated_method = "BEBE03EEC78D240CBF2536E36E4AFA69")
    
private Drawable tileify(Drawable drawable, boolean clip) {

        if (drawable instanceof LayerDrawable) {
            LayerDrawable background = (LayerDrawable) drawable;
            final int N = background.getNumberOfLayers();
            Drawable[] outDrawables = new Drawable[N];

            for (int i = 0; i < N; i++) {
                int id = background.getId(i);
                outDrawables[i] = tileify(background.getDrawable(i),
                        (id == android.R.id.progress || id == android.R.id.secondaryProgress));
            }

            LayerDrawable newBg = new LayerDrawable(outDrawables);

            for (int i = 0; i < N; i++) {
                newBg.setId(i, background.getId(i));
            }

            return newBg;

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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.273 -0400", hash_original_method = "066FEFD8810FD39B2288696E8912725B", hash_generated_method = "066FEFD8810FD39B2288696E8912725B")
    
Shape getDrawableShape() {
        final float[] roundedCorners = new float[] { 5, 5, 5, 5, 5, 5, 5, 5 };
        return new RoundRectShape(roundedCorners, null, null);
    }

    /**
     * Convert a AnimationDrawable for use as a barberpole animation.
     * Each frame of the animation is wrapped in a ClipDrawable and
     * given a tiling BitmapShader.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.276 -0400", hash_original_method = "9EE7DD01E1AB6B0D269DB58A7544C17D", hash_generated_method = "BFBDCEA5D01AFD36373F651333FF5A41")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.278 -0400", hash_original_method = "E5E4BC7A2B363BE6E2FBD0B5C26F4050", hash_generated_method = "78375C615A16504B3FCA36BE4D985473")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.281 -0400", hash_original_method = "3387FD7633AB5B9FD9EC30B2946E89DA", hash_generated_method = "C90CFEE0B41FF3D2E106BCB49C7AB059")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.284 -0400", hash_original_method = "9BFD2BF2FBC3833B7107C0E363644A89", hash_generated_method = "83EAE0FD544D3B25F05B63870011241F")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.286 -0400", hash_original_method = "460B65565106BA0615FD22E30B040519", hash_generated_method = "1D0B7B0BC2B00D07FF81B79AC8D11B88")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.288 -0400", hash_original_method = "4CAABA82B88C397ED0E927A2E15C90A0", hash_generated_method = "C9C5FF69EB2FE939BF7A67171571DBF0")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.290 -0400", hash_original_method = "6C8C8D805DC88A29293BE605923D5590", hash_generated_method = "4BA7DC49F21214973C9ECF5C6BFE263B")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.293 -0400", hash_original_method = "545791F74335FEE41877E83003E39275", hash_generated_method = "73055FD7C38813C6DC8578E354C7AEEC")
    
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

            // Make sure the android_R_styleable_ProgressBar is always tall enough
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
            doRefreshProgress(android.R.id.progress, mProgress, false, false);
            doRefreshProgress(android.R.id.secondaryProgress, mSecondaryProgress, false, false);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.296 -0400", hash_original_method = "56BA1F17FA722E2B64538801F5E2971D", hash_generated_method = "0B02F1DFB62424893F2A6429D2429244")
    
@Override
    protected boolean verifyDrawable(Drawable who) {
        return who == mProgressDrawable || who == mIndeterminateDrawable
                || super.verifyDrawable(who);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.298 -0400", hash_original_method = "9D88EC1BAB8B30E9973F963BD590322C", hash_generated_method = "E638853BDC411A9115DF2C7DD6FAA67E")
    
@Override
    public void postInvalidate() {
        if (!mNoInvalidate) {
            super.postInvalidate();
        }
    }

    private class RefreshProgressRunnable implements Runnable {

        private int mId;
        private int mProgress;
        private boolean mFromUser;

        RefreshProgressRunnable(int id, int progress, boolean fromUser) {
            mId = id;
            mProgress = progress;
            mFromUser = fromUser;
        }

        public void run() {
            doRefreshProgress(mId, mProgress, mFromUser, true);
            // Put ourselves back in the cache when we are done
            mRefreshProgressRunnable = this;
        }

        public void setup(int id, int progress, boolean fromUser) {
            mId = id;
            mProgress = progress;
            mFromUser = fromUser;
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.317 -0400", hash_original_method = "F382A8584D637A3004BF31C3394ABAEB", hash_generated_method = "F29C2928F71F70DF14A62B85E0C652E7")
    
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.320 -0400", hash_original_method = "6344B397C965EAD8A2329C40E25F1FFC", hash_generated_method = "F10BD9D23747680E1837588EDF8BD40B")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.322 -0400", hash_original_method = "E60A634EF77869D698E2255CD3404933", hash_generated_method = "AD82D0D84FC0A04DF8280A1338FC7191")
    
public synchronized void setProgress(int progress) {
        setProgress(progress, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.324 -0400", hash_original_method = "C2E2CCED53BCB6699A7BC8E2215E473D", hash_generated_method = "55F58A1C033E89AC6D71C5759B18667C")
    
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
            refreshProgress(android.R.id.progress, mProgress, fromUser);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.327 -0400", hash_original_method = "A0ECE8D17F88A97A829C3110A7FE71C7", hash_generated_method = "1F4D26896216F700CDDA68B2AFCB2E75")
    
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
            refreshProgress(android.R.id.secondaryProgress, mSecondaryProgress, false);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.329 -0400", hash_original_method = "BF818051FE207A57D09CC2C24E2066F6", hash_generated_method = "B42929C38FD3EE0C676F8B566418E2D7")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.331 -0400", hash_original_method = "0E2189FB3CB300C00977FC2C3BDB4D4B", hash_generated_method = "445B105BE8BB2B789E050E41D06F27DF")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.333 -0400", hash_original_method = "6E6A982D82D781B4C4E0B14E6160A2E7", hash_generated_method = "38EC1214120F7CF022577F0803F94249")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.335 -0400", hash_original_method = "53D03C35133C3000C507CFF61AE29775", hash_generated_method = "E5BD534F7BC1849CAE27D681AB2D174C")
    
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
            refreshProgress(android.R.id.progress, mProgress, false);
        }
    }

    /**
     * <p>Increase the progress bar's progress by the specified amount.</p>
     *
     * @param diff the amount by which the progress must be increased
     *
     * @see #setProgress(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.338 -0400", hash_original_method = "1E5C167C76FF3FF0E5E9EED4F2394FD5", hash_generated_method = "ECB6544B74373497ABBCEAA760E25BB2")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.340 -0400", hash_original_method = "33F180031B438855CD8341D942A736A2", hash_generated_method = "1822A5BEC7AF261DE838CCCCFB295CA9")
    
public synchronized final void incrementSecondaryProgressBy(int diff) {
        setSecondaryProgress(mSecondaryProgress + diff);
    }

    /**
     * <p>Start the indeterminate progress animation.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.343 -0400", hash_original_method = "F5167F20A872A63C36DAF85A2B000FB5", hash_generated_method = "F5167F20A872A63C36DAF85A2B000FB5")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.346 -0400", hash_original_method = "3AFE1BBA347326120AD78BEE94F7B2A6", hash_generated_method = "3AFE1BBA347326120AD78BEE94F7B2A6")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.348 -0400", hash_original_method = "2C6481DDCCEAC913795356C9BF1AF628", hash_generated_method = "BE3242216311F89FBBEC5A97D66A30C9")
    
public void setInterpolator(Context context, int resID) {
        setInterpolator(AnimationUtils.loadInterpolator(context, resID));
    }

    /**
     * Sets the acceleration curve for the indeterminate animation.
     * Defaults to a linear interpolation.
     *
     * @param interpolator The interpolator which defines the acceleration curve
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.350 -0400", hash_original_method = "7D5A9A852D608ADF508B994526BF9EAC", hash_generated_method = "DF8FD2546DF08BADAB224E60C1A6C2B9")
    
public void setInterpolator(Interpolator interpolator) {
        mInterpolator = interpolator;
    }

    /**
     * Gets the acceleration curve type for the indeterminate animation.
     *
     * @return the {@link Interpolator} associated to this animation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.352 -0400", hash_original_method = "8AA04851FFB5BE49EA5890940035B142", hash_generated_method = "680BC21A34AFF00E6707D9E25D0C0570")
    
public Interpolator getInterpolator() {
        return mInterpolator;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.355 -0400", hash_original_method = "EC8B18EE88EE8E09369A36DBF52DF684", hash_generated_method = "73E2D60221E84DFF666BD917E74B15F5")
    
@Override
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.357 -0400", hash_original_method = "E937F441086D9A40C4DA651781180A92", hash_generated_method = "1ED71813CAE5A0C16DA256492B8D334A")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.360 -0400", hash_original_method = "EAD52858E54831CE0C8FE00F12F2051C", hash_generated_method = "9B0DCD8C0A17B2F6A4A8C6C3AF4DADA6")
    
@Override
    public void invalidateDrawable(Drawable dr) {
        if (!mInDrawing) {
            if (verifyDrawable(dr)) {
                final Rect dirty = dr.getBounds();
                final int scrollX = getScrollX() + getPaddingLeft();
                final int scrollY = getScrollY() + getPaddingTop();

                invalidate(dirty.left + scrollX, dirty.top + scrollY,
                        dirty.right + scrollX, dirty.bottom + scrollY);
            } else {
                super.invalidateDrawable(dr);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.362 -0400", hash_original_method = "69EE8DE1AB95A9498391F63C2C373DBD", hash_generated_method = "5CA0B0F09A03F7EA0410163A47798DB8")
    
@Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        updateDrawableBounds(w, h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.365 -0400", hash_original_method = "CE825990E0CD951F03F92043F3FCC1BC", hash_generated_method = "D5935F3D8E4CC045F4270ACD955461A4")
    
private void updateDrawableBounds(int w, int h) {
        // onDraw will translate the canvas so we draw starting at 0,0
        int right = w - getPaddingRight() - getPaddingLeft();
        int bottom = h - getPaddingBottom() - getPaddingTop();
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.368 -0400", hash_original_method = "0EFB7C1793578989C1A5DF9791806651", hash_generated_method = "B11E5EDA72F7ED41A7E79AB876D22B86")
    
@Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Drawable d = mCurrentDrawable;
        if (d != null) {
            // Translate canvas so a indeterminate circular progress bar with padding
            // rotates properly in its animation
            canvas.save();
            canvas.translate(getPaddingLeft(), getPaddingTop());
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
                if (SystemClock.uptimeMillis() - mLastDrawTime >= ANIMATION_RESOLUTION) {
                    mLastDrawTime = SystemClock.uptimeMillis();
                    postInvalidateDelayed(ANIMATION_RESOLUTION);
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.371 -0400", hash_original_method = "E32267B76522D7CC9911AF5801B49E50", hash_generated_method = "1039C8DB602E0CC5F5DF799FD19E333C")
    
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
        dw += getPaddingLeft() + getPaddingRight();
        dh += getPaddingTop() + getPaddingBottom();

        setMeasuredDimension(resolveSize(dw, widthMeasureSpec),
                resolveSize(dh, heightMeasureSpec));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.373 -0400", hash_original_method = "568F14E497668D52F70AE96AA5EB6F88", hash_generated_method = "4EB57F8B143863A87C550D037C073C6C")
    
@Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        updateDrawableState();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.375 -0400", hash_original_method = "952B851172F804A1D432AC87BADE94E9", hash_generated_method = "539E58DB3A2F5D873F38DF27B1746999")
    
private void updateDrawableState() {
        int[] state = getDrawableState();

        if (mProgressDrawable != null && mProgressDrawable.isStateful()) {
            mProgressDrawable.setState(state);
        }

        if (mIndeterminateDrawable != null && mIndeterminateDrawable.isStateful()) {
            mIndeterminateDrawable.setState(state);
        }
    }

    static class SavedState extends BaseSavedState {
        int progress;
        int secondaryProgress;

        /**
         * Constructor called from {@link ProgressBarICS#onSaveInstanceState()}
         */
        SavedState(Parcelable superState) {
            super(superState);
        }

        /**
         * Constructor called from {@link #CREATOR}
         */
        private SavedState(Parcel in) {
            super(in);
            progress = in.readInt();
            secondaryProgress = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(progress);
            out.writeInt(secondaryProgress);
        }

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.401 -0400", hash_original_method = "875308A47ADC87038CC9E153A4D8FE71", hash_generated_method = "C5A52986289D68811DA77A5BE28BE018")
    
@Override
    public Parcelable onSaveInstanceState() {
        // Force our ancestor class to save its state
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);

        ss.progress = mProgress;
        ss.secondaryProgress = mSecondaryProgress;

        return ss;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.403 -0400", hash_original_method = "A42CFAF758710477BAC4A7B2A0C98761", hash_generated_method = "36920F3704EEF8E261868AE4CB4E618B")
    
@Override
    public void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        setProgress(ss.progress);
        setSecondaryProgress(ss.secondaryProgress);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.406 -0400", hash_original_method = "608AE3D8DA74959AA8F2204845C7317D", hash_generated_method = "7F5751066C42C755413048DCB414803C")
    
@Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mIndeterminate) {
            startAnimation();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.408 -0400", hash_original_method = "849BEAABD731843766EB22798F922874", hash_generated_method = "CC75F266D8C34451BE27A2C0474B486D")
    
@Override
    protected void onDetachedFromWindow() {
        if (mIndeterminate) {
            stopAnimation();
        }
        if(mRefreshProgressRunnable != null) {
            removeCallbacks(mRefreshProgressRunnable);
        }

        // This should come after stopAnimation(), otherwise an invalidate message remains in the
        // queue, which can prevent the entire view hierarchy from being GC'ed during a rotation
        super.onDetachedFromWindow();
    }

}