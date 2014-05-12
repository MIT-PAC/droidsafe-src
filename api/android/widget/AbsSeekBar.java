package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public abstract class AbsSeekBar extends ProgressBar {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.397 -0500", hash_original_field = "F40A65A0161E245EB9410D7A796FE9B3", hash_generated_field = "0FC0F1E74EFFD499D7E9EC90666C1A5B")
    
    private static final int NO_ALPHA = 0xFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.387 -0500", hash_original_field = "FD62B894F97CF0695B853F1F96D29A26", hash_generated_field = "A9FD89A9EA0824250F9B9C034928CB8F")

    private Drawable mThumb;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.389 -0500", hash_original_field = "F00844383D5CEE5E798D45B7C877A065", hash_generated_field = "EDEA4E873C327B12CA4083E0E57BEE64")

    private int mThumbOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.391 -0500", hash_original_field = "E221719242D0437E0E0816E9049A3A6E", hash_generated_field = "E221719242D0437E0E0816E9049A3A6E")

    float mTouchProgressOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.393 -0500", hash_original_field = "267BD1149348204124B40DB8937D82FB", hash_generated_field = "267BD1149348204124B40DB8937D82FB")

    boolean mIsUserSeekable = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.395 -0500", hash_original_field = "662F70DA59E7A41884406B4F6627CC0C", hash_generated_field = "DA3EB023D2AE87BC493256844DF4F8FC")

    private int mKeyProgressIncrement = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.399 -0500", hash_original_field = "C7A330BE7142327056539F5ED284903D", hash_generated_field = "BE45430B4E582ECC76FDAE96B324FF18")

    private float mDisabledAlpha;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.401 -0500", hash_original_field = "BDDA105C43BD9D84A4C5E84D10C957AD", hash_generated_field = "A6018E4F8C21D3EE961380A6D74CC7E0")
    
    private int mScaledTouchSlop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.404 -0500", hash_original_field = "736B8C13D43D5513EA82C61CE573A2F9", hash_generated_field = "A48801BD53279BF93DEF5A0855023B3F")

    private float mTouchDownX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.406 -0500", hash_original_field = "3A568D5A24E6042844823649C40BC486", hash_generated_field = "71A2FEF14E89166E5A8A859417B1663A")

    private boolean mIsDragging;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.408 -0500", hash_original_method = "559FDCE349858758D50BC2905EE88B67", hash_generated_method = "C46FBF546DF5E71B0BE095D871862D47")
    
public AbsSeekBar(Context context) {
        super(context);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.411 -0500", hash_original_method = "9B53DFB86DC24D620F7DF1D33C461438", hash_generated_method = "F87231B1B13D3C212440C6199DF2E606")
    
public AbsSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.413 -0500", hash_original_method = "1A34D5E8CF032B0AA6AD65EE16F7EFF6", hash_generated_method = "48447701C2F88AB3D5BB3C56A26D5D74")
    
public AbsSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.SeekBar, defStyle, 0);
        Drawable thumb = a.getDrawable(com.android.internal.R.styleable.SeekBar_thumb);
        setThumb(thumb); // will guess mThumbOffset if thumb != null...
        // ...but allow layout to override this
        int thumbOffset = a.getDimensionPixelOffset(
                com.android.internal.R.styleable.SeekBar_thumbOffset, getThumbOffset());
        setThumbOffset(thumbOffset);
        a.recycle();

        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.Theme, 0, 0);
        mDisabledAlpha = a.getFloat(com.android.internal.R.styleable.Theme_disabledAlpha, 0.5f);
        a.recycle();

        mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /**
     * Sets the thumb that will be drawn at the end of the progress meter within the SeekBar.
     * <p>
     * If the thumb is a valid drawable (i.e. not null), half its width will be
     * used as the new thumb offset (@see #setThumbOffset(int)).
     * 
     * @param thumb Drawable representing the thumb
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.416 -0500", hash_original_method = "998F0AEDC4C83C00C5B5C0950AA82FAF", hash_generated_method = "41C55E3CB0B790AF3F0B45527A049B51")
    
public void setThumb(Drawable thumb) {
        boolean needUpdate;
        // This way, calling setThumb again with the same bitmap will result in
        // it recalcuating mThumbOffset (if for example it the bounds of the
        // drawable changed)
        if (mThumb != null && thumb != mThumb) {
            mThumb.setCallback(null);
            needUpdate = true;
        } else {
            needUpdate = false;
        }
        if (thumb != null) {
            thumb.setCallback(this);

            // Assuming the thumb drawable is symmetric, set the thumb offset
            // such that the thumb will hang halfway off either edge of the
            // progress bar.
            mThumbOffset = thumb.getIntrinsicWidth() / 2;

            // If we're updating get the new states
            if (needUpdate &&
                    (thumb.getIntrinsicWidth() != mThumb.getIntrinsicWidth()
                        || thumb.getIntrinsicHeight() != mThumb.getIntrinsicHeight())) {
                requestLayout();
            }
        }
        mThumb = thumb;
        invalidate();
        if (needUpdate) {
            updateThumbPos(getWidth(), getHeight());
            if (thumb.isStateful()) {
                // Note that if the states are different this won't work.
                // For now, let's consider that an app bug.
                int[] state = getDrawableState();
                thumb.setState(state);
            }
        }
    }

    /**
     * @see #setThumbOffset(int)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.418 -0500", hash_original_method = "55BCE64F6AB8A7FA94D80EC71DE6965C", hash_generated_method = "F79543ECA2A92AB64764C5A2B1FACA32")
    
public int getThumbOffset() {
        return mThumbOffset;
    }

    /**
     * Sets the thumb offset that allows the thumb to extend out of the range of
     * the track.
     * 
     * @param thumbOffset The offset amount in pixels.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.420 -0500", hash_original_method = "19F18537D3EF5D294C0A19C19876A9D3", hash_generated_method = "D77A319057FF6F3ED8417DF0C6540BD0")
    
public void setThumbOffset(int thumbOffset) {
        mThumbOffset = thumbOffset;
        invalidate();
    }

    /**
     * Sets the amount of progress changed via the arrow keys.
     * 
     * @param increment The amount to increment or decrement when the user
     *            presses the arrow keys.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.423 -0500", hash_original_method = "47EA7303B3E1A2D7511BD2240E8B9AF2", hash_generated_method = "A209AB66D0BC1B042527F3A4A6F5077A")
    
public void setKeyProgressIncrement(int increment) {
        mKeyProgressIncrement = increment < 0 ? -increment : increment;
    }

    /**
     * Returns the amount of progress changed via the arrow keys.
     * <p>
     * By default, this will be a value that is derived from the max progress.
     * 
     * @return The amount to increment or decrement when the user presses the
     *         arrow keys. This will be positive.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.425 -0500", hash_original_method = "1305A27F8447A6D05AC7D82E2D035BB9", hash_generated_method = "77282FCD0571741C2B935EB5C9168980")
    
public int getKeyProgressIncrement() {
        return mKeyProgressIncrement;
    }
    
    @DSComment("Abstract SeekBar")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.428 -0500", hash_original_method = "B86F9FD250EB4E355A6234A6154554E5", hash_generated_method = "CA2AA6C75D79CE639A6D579C54BBA41C")
    
@Override
    public synchronized void setMax(int max) {
        super.setMax(max);

        if ((mKeyProgressIncrement == 0) || (getMax() / mKeyProgressIncrement > 20)) {
            // It will take the user too long to change this via keys, change it
            // to something more reasonable
            setKeyProgressIncrement(Math.max(1, Math.round((float) getMax() / 20)));
        }
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.430 -0500", hash_original_method = "9C2A9BDC8A382BBBC0B52ACD6BB3E808", hash_generated_method = "CD88B145328FDFD5D46FE47A595B26EF")
    
@Override
    protected boolean verifyDrawable(Drawable who) {
        return who == mThumb || super.verifyDrawable(who);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.433 -0500", hash_original_method = "A2BEB9099595ED17C9F72C657E221F4D", hash_generated_method = "4D7F0A10FE0CD79695DE44900B208795")
    
@Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (mThumb != null) mThumb.jumpToCurrentState();
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.435 -0500", hash_original_method = "18D3C014C29EEACE1B64A99674108866", hash_generated_method = "FAF6A29E2A27C45E9DC5EF38CDBAFF4C")
    
@Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setAlpha(isEnabled() ? NO_ALPHA : (int) (NO_ALPHA * mDisabledAlpha));
        }
        
        if (mThumb != null && mThumb.isStateful()) {
            int[] state = getDrawableState();
            mThumb.setState(state);
        }
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.437 -0500", hash_original_method = "BD33A56797AEA3D6F712418E2C1B11B9", hash_generated_method = "D297D1781696209F89E9F026CF903A01")
    
@Override
    void onProgressRefresh(float scale, boolean fromUser) {
        super.onProgressRefresh(scale, fromUser);
        Drawable thumb = mThumb;
        if (thumb != null) {
            setThumbPos(getWidth(), thumb, scale, Integer.MIN_VALUE);
            /*
             * Since we draw translated, the drawable's bounds that it signals
             * for invalidation won't be the actual bounds we want invalidated,
             * so just invalidate this whole view.
             */
            invalidate();
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.439 -0500", hash_original_method = "A1D4A37B8CF40CBB929E8D311A74C166", hash_generated_method = "12D73892C6F9EC6E45F16411E16C2432")
    
@Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        updateThumbPos(w, h);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.442 -0500", hash_original_method = "EBB195A6F6AE70942CBBB72014D4E630", hash_generated_method = "2CD59655C19BBBF172D87FF48B30C6E2")
    
private void updateThumbPos(int w, int h) {
        Drawable d = getCurrentDrawable();
        Drawable thumb = mThumb;
        int thumbHeight = thumb == null ? 0 : thumb.getIntrinsicHeight();
        // The max height does not incorporate padding, whereas the height
        // parameter does
        int trackHeight = Math.min(mMaxHeight, h - mPaddingTop - mPaddingBottom);
        
        int max = getMax();
        float scale = max > 0 ? (float) getProgress() / (float) max : 0;
        
        if (thumbHeight > trackHeight) {
            if (thumb != null) {
                setThumbPos(w, thumb, scale, 0);
            }
            int gapForCenteringTrack = (thumbHeight - trackHeight) / 2;
            if (d != null) {
                // Canvas will be translated by the padding, so 0,0 is where we start drawing
                d.setBounds(0, gapForCenteringTrack, 
                        w - mPaddingRight - mPaddingLeft, h - mPaddingBottom - gapForCenteringTrack
                        - mPaddingTop);
            }
        } else {
            if (d != null) {
                // Canvas will be translated by the padding, so 0,0 is where we start drawing
                d.setBounds(0, 0, w - mPaddingRight - mPaddingLeft, h - mPaddingBottom
                        - mPaddingTop);
            }
            int gap = (trackHeight - thumbHeight) / 2;
            if (thumb != null) {
                setThumbPos(w, thumb, scale, gap);
            }
        }
    }

    /**
     * @param gap If set to {@link Integer#MIN_VALUE}, this will be ignored and
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.444 -0500", hash_original_method = "CA4C19C8B40982548F0C235E2E1E696B", hash_generated_method = "78D4F43E8B8447727A62D2774621AC09")
    
private void setThumbPos(int w, Drawable thumb, float scale, int gap) {
        int available = w - mPaddingLeft - mPaddingRight;
        int thumbWidth = thumb.getIntrinsicWidth();
        int thumbHeight = thumb.getIntrinsicHeight();
        available -= thumbWidth;

        // The extra space for the thumb to move on the track
        available += mThumbOffset * 2;

        int thumbPos = (int) (scale * available);

        int topBound, bottomBound;
        if (gap == Integer.MIN_VALUE) {
            Rect oldBounds = thumb.getBounds();
            topBound = oldBounds.top;
            bottomBound = oldBounds.bottom;
        } else {
            topBound = gap;
            bottomBound = gap + thumbHeight;
        }
        
        // Canvas will be translated, so 0,0 is where we start drawing
        thumb.setBounds(thumbPos, topBound, thumbPos + thumbWidth, bottomBound);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.448 -0500", hash_original_method = "317EB63F41EF20BCBD26EC2C5FF1A8E2", hash_generated_method = "16DB17B8D7608C5FF448B8EA63343F43")
    
@Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mThumb != null) {
            canvas.save();
            // Translate the padding. For the x, we need to allow the thumb to
            // draw in its extra space
            canvas.translate(mPaddingLeft - mThumbOffset, mPaddingTop);
            mThumb.draw(canvas);
            canvas.restore();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.450 -0500", hash_original_method = "6FE23FC5494DD28976118E3A2B4F8E1A", hash_generated_method = "1109593018B12D4B6F6E8B418FAD1A15")
    
@Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable d = getCurrentDrawable();

        int thumbHeight = mThumb == null ? 0 : mThumb.getIntrinsicHeight();
        int dw = 0;
        int dh = 0;
        if (d != null) {
            dw = Math.max(mMinWidth, Math.min(mMaxWidth, d.getIntrinsicWidth()));
            dh = Math.max(mMinHeight, Math.min(mMaxHeight, d.getIntrinsicHeight()));
            dh = Math.max(thumbHeight, dh);
        }
        dw += mPaddingLeft + mPaddingRight;
        dh += mPaddingTop + mPaddingBottom;
        
        setMeasuredDimension(resolveSizeAndState(dw, widthMeasureSpec, 0),
                resolveSizeAndState(dh, heightMeasureSpec, 0));
    }
    
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.453 -0500", hash_original_method = "E10F6AB7670DC24DEEA2309682812EC7", hash_generated_method = "4AB12CB6D519D45D8BF3CCDE9EE80395")
    
@Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!mIsUserSeekable || !isEnabled()) {
            return false;
        }
        
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (isInScrollingContainer()) {
                    mTouchDownX = event.getX();
                } else {
                    setPressed(true);
                    if (mThumb != null) {
                        invalidate(mThumb.getBounds()); // This may be within the padding region
                    }
                    onStartTrackingTouch();
                    trackTouchEvent(event);
                    attemptClaimDrag();
                }
                break;
                
            case MotionEvent.ACTION_MOVE:
                if (mIsDragging) {
                    trackTouchEvent(event);
                } else {
                    final float x = event.getX();
                    if (Math.abs(x - mTouchDownX) > mScaledTouchSlop) {
                        setPressed(true);
                        if (mThumb != null) {
                            invalidate(mThumb.getBounds()); // This may be within the padding region
                        }
                        onStartTrackingTouch();
                        trackTouchEvent(event);
                        attemptClaimDrag();
                    }
                }
                break;
                
            case MotionEvent.ACTION_UP:
                if (mIsDragging) {
                    trackTouchEvent(event);
                    onStopTrackingTouch();
                    setPressed(false);
                } else {
                    // Touch up when we never crossed the touch slop threshold should
                    // be interpreted as a tap-seek to that location.
                    onStartTrackingTouch();
                    trackTouchEvent(event);
                    onStopTrackingTouch();
                }
                // ProgressBar doesn't know to repaint the thumb drawable
                // in its inactive state when the touch stops (because the
                // value has not apparently changed)
                invalidate();
                break;
                
            case MotionEvent.ACTION_CANCEL:
                if (mIsDragging) {
                    onStopTrackingTouch();
                    setPressed(false);
                }
                invalidate(); // see above explanation
                break;
        }
        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.456 -0500", hash_original_method = "B852C5F326259FF2E0714D28C9BE0803", hash_generated_method = "174F3F06879596C6E7370B53A22AABF9")
    
private void trackTouchEvent(MotionEvent event) {
        final int width = getWidth();
        final int available = width - mPaddingLeft - mPaddingRight;
        int x = (int)event.getX();
        float scale;
        float progress = 0;
        if (x < mPaddingLeft) {
            scale = 0.0f;
        } else if (x > width - mPaddingRight) {
            scale = 1.0f;
        } else {
            scale = (float)(x - mPaddingLeft) / (float)available;
            progress = mTouchProgressOffset;
        }
        
        final int max = getMax();
        progress += scale * max;
        
        setProgress((int) progress, true);
    }

    /**
     * Tries to claim the user's drag motion, and requests disallowing any
     * ancestors from stealing events in the drag.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.458 -0500", hash_original_method = "EE6806E5D0C523D5F375E4021A29EB50", hash_generated_method = "4A38C155913606B908C0A2B83E84F323")
    
private void attemptClaimDrag() {
        if (mParent != null) {
            mParent.requestDisallowInterceptTouchEvent(true);
        }
    }
    
    /**
     * This is called when the user has started touching this widget.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.460 -0500", hash_original_method = "81C3D3C536033DCEF00354E775EF2F98", hash_generated_method = "81C3D3C536033DCEF00354E775EF2F98")
    
void onStartTrackingTouch() {
        mIsDragging = true;
    }

    /**
     * This is called when the user either releases his touch or the touch is
     * canceled.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.462 -0500", hash_original_method = "E756AFD9567E2119FB96458DFE00C6A9", hash_generated_method = "E756AFD9567E2119FB96458DFE00C6A9")
    
void onStopTrackingTouch() {
        mIsDragging = false;
    }

    /**
     * Called when the user changes the seekbar's progress by using a key event.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.464 -0500", hash_original_method = "F04551903C4B751B14DE46074D4BB62C", hash_generated_method = "F04551903C4B751B14DE46074D4BB62C")
    
void onKeyChange() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.467 -0500", hash_original_method = "E4D4B44B4B0BF8B3ACFCDB808BF98F5B", hash_generated_method = "8320667AC9767154144F7EC414ED3C97")
    
@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (isEnabled()) {
            int progress = getProgress();
            switch (keyCode) {
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    if (progress <= 0) break;
                    setProgress(progress - mKeyProgressIncrement, true);
                    onKeyChange();
                    return true;
            
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    if (progress >= getMax()) break;
                    setProgress(progress + mKeyProgressIncrement, true);
                    onKeyChange();
                    return true;
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}

