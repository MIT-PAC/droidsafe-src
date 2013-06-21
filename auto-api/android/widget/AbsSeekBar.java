package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private Drawable mThumb;
    private int mThumbOffset;
    float mTouchProgressOffset;
    boolean mIsUserSeekable = true;
    private int mKeyProgressIncrement = 1;
    private float mDisabledAlpha;
    private int mScaledTouchSlop;
    private float mTouchDownX;
    private boolean mIsDragging;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.014 -0400", hash_original_method = "559FDCE349858758D50BC2905EE88B67", hash_generated_method = "AD54C9B1E797C1CD0BE12B598ADE9B05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsSeekBar(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.014 -0400", hash_original_method = "9B53DFB86DC24D620F7DF1D33C461438", hash_generated_method = "1E859F31CE64C120DA2D0D162F68E910")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.014 -0400", hash_original_method = "1A34D5E8CF032B0AA6AD65EE16F7EFF6", hash_generated_method = "3F551C7D6D998F857752E133E1E08CBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.SeekBar, defStyle, 0);
        Drawable thumb;
        thumb = a.getDrawable(com.android.internal.R.styleable.SeekBar_thumb);
        setThumb(thumb);
        int thumbOffset;
        thumbOffset = a.getDimensionPixelOffset(
                com.android.internal.R.styleable.SeekBar_thumbOffset, getThumbOffset());
        setThumbOffset(thumbOffset);
        a.recycle();
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.Theme, 0, 0);
        mDisabledAlpha = a.getFloat(com.android.internal.R.styleable.Theme_disabledAlpha, 0.5f);
        a.recycle();
        mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs,
                //com.android.internal.R.styleable.SeekBar, defStyle, 0);
        //Drawable thumb = a.getDrawable(com.android.internal.R.styleable.SeekBar_thumb);
        //setThumb(thumb);
        //int thumbOffset = a.getDimensionPixelOffset(
                //com.android.internal.R.styleable.SeekBar_thumbOffset, getThumbOffset());
        //setThumbOffset(thumbOffset);
        //a.recycle();
        //a = context.obtainStyledAttributes(attrs,
                //com.android.internal.R.styleable.Theme, 0, 0);
        //mDisabledAlpha = a.getFloat(com.android.internal.R.styleable.Theme_disabledAlpha, 0.5f);
        //a.recycle();
        //mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.015 -0400", hash_original_method = "998F0AEDC4C83C00C5B5C0950AA82FAF", hash_generated_method = "275D980D468516DD2DDBCAC01569B160")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setThumb(Drawable thumb) {
        dsTaint.addTaint(thumb.dsTaint);
        boolean needUpdate;
        {
            mThumb.setCallback(null);
            needUpdate = true;
        } //End block
        {
            needUpdate = false;
        } //End block
        {
            thumb.setCallback(this);
            mThumbOffset = thumb.getIntrinsicWidth() / 2;
            {
                boolean var59DF2AD9A1CFAFF2C2350A5FD63D8E2E_1994924445 = (needUpdate &&
                    (thumb.getIntrinsicWidth() != mThumb.getIntrinsicWidth()
                        || thumb.getIntrinsicHeight() != mThumb.getIntrinsicHeight()));
                {
                    requestLayout();
                } //End block
            } //End collapsed parenthetic
        } //End block
        invalidate();
        {
            updateThumbPos(getWidth(), getHeight());
            {
                boolean varFCD92C730287EA43C3C6E5B7570040DB_345291201 = (thumb.isStateful());
                {
                    int[] state;
                    state = getDrawableState();
                    thumb.setState(state);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.015 -0400", hash_original_method = "55BCE64F6AB8A7FA94D80EC71DE6965C", hash_generated_method = "EDEC322D64E445AE7CABC59A1C6A3207")
    @DSModeled(DSC.SAFE)
    public int getThumbOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mThumbOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.015 -0400", hash_original_method = "19F18537D3EF5D294C0A19C19876A9D3", hash_generated_method = "6345117DD247583E7D937AB5A4D4A6A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setThumbOffset(int thumbOffset) {
        dsTaint.addTaint(thumbOffset);
        invalidate();
        // ---------- Original Method ----------
        //mThumbOffset = thumbOffset;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.015 -0400", hash_original_method = "47EA7303B3E1A2D7511BD2240E8B9AF2", hash_generated_method = "DAFB0760DE28498C6ADFB0DD8C464D5A")
    @DSModeled(DSC.SAFE)
    public void setKeyProgressIncrement(int increment) {
        dsTaint.addTaint(increment);
        mKeyProgressIncrement = increment < 0 ? -increment : increment;
        // ---------- Original Method ----------
        //mKeyProgressIncrement = increment < 0 ? -increment : increment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.016 -0400", hash_original_method = "1305A27F8447A6D05AC7D82E2D035BB9", hash_generated_method = "5D908A38FDB66A77BEA3F1E1FC484B04")
    @DSModeled(DSC.SAFE)
    public int getKeyProgressIncrement() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mKeyProgressIncrement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.016 -0400", hash_original_method = "B86F9FD250EB4E355A6234A6154554E5", hash_generated_method = "E636A2878B0648EC80F1DDD40D70A153")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void setMax(int max) {
        dsTaint.addTaint(max);
        super.setMax(max);
        {
            boolean var5A2D5B08CD2B6F9FFB530FF2ED2BD2AF_406195985 = ((mKeyProgressIncrement == 0) || (getMax() / mKeyProgressIncrement > 20));
            {
                setKeyProgressIncrement(Math.max(1, Math.round((float) getMax() / 20)));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.setMax(max);
        //if ((mKeyProgressIncrement == 0) || (getMax() / mKeyProgressIncrement > 20)) {
            //setKeyProgressIncrement(Math.max(1, Math.round((float) getMax() / 20)));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.016 -0400", hash_original_method = "9C2A9BDC8A382BBBC0B52ACD6BB3E808", hash_generated_method = "8DBFBC8EBD741FE241BCEF11654B7A40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean verifyDrawable(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        boolean varE1C56A7DB014338269CA53D8B5F618C2_577737918 = (who == mThumb || super.verifyDrawable(who));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return who == mThumb || super.verifyDrawable(who);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.016 -0400", hash_original_method = "A2BEB9099595ED17C9F72C657E221F4D", hash_generated_method = "DA07F644E239140FB7E0B906AAB88BB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        mThumb.jumpToCurrentState();
        // ---------- Original Method ----------
        //super.jumpDrawablesToCurrentState();
        //if (mThumb != null) mThumb.jumpToCurrentState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.017 -0400", hash_original_method = "18D3C014C29EEACE1B64A99674108866", hash_generated_method = "0084D1A4C68C14545424312BF34DAA5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable progressDrawable;
        progressDrawable = getProgressDrawable();
        {
            progressDrawable.setAlpha(isEnabled() ? NO_ALPHA : (int) (NO_ALPHA * mDisabledAlpha));
        } //End block
        {
            boolean varBADFD63D920DCCB8A0340B6A85499F1D_1725310756 = (mThumb != null && mThumb.isStateful());
            {
                int[] state;
                state = getDrawableState();
                mThumb.setState(state);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //Drawable progressDrawable = getProgressDrawable();
        //if (progressDrawable != null) {
            //progressDrawable.setAlpha(isEnabled() ? NO_ALPHA : (int) (NO_ALPHA * mDisabledAlpha));
        //}
        //if (mThumb != null && mThumb.isStateful()) {
            //int[] state = getDrawableState();
            //mThumb.setState(state);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.017 -0400", hash_original_method = "BD33A56797AEA3D6F712418E2C1B11B9", hash_generated_method = "057169092C848761D044B7B6233BDE33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void onProgressRefresh(float scale, boolean fromUser) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(scale);
        dsTaint.addTaint(fromUser);
        super.onProgressRefresh(scale, fromUser);
        Drawable thumb;
        thumb = mThumb;
        {
            setThumbPos(getWidth(), thumb, scale, Integer.MIN_VALUE);
            invalidate();
        } //End block
        // ---------- Original Method ----------
        //super.onProgressRefresh(scale, fromUser);
        //Drawable thumb = mThumb;
        //if (thumb != null) {
            //setThumbPos(getWidth(), thumb, scale, Integer.MIN_VALUE);
            //invalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.017 -0400", hash_original_method = "A1D4A37B8CF40CBB929E8D311A74C166", hash_generated_method = "C33A7EE2CF0C04B5E50BBF34D9F1B2BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(w);
        dsTaint.addTaint(oldh);
        dsTaint.addTaint(oldw);
        dsTaint.addTaint(h);
        updateThumbPos(w, h);
        // ---------- Original Method ----------
        //updateThumbPos(w, h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.018 -0400", hash_original_method = "EBB195A6F6AE70942CBBB72014D4E630", hash_generated_method = "B75459261F69AF525638F2CB4011DA71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateThumbPos(int w, int h) {
        dsTaint.addTaint(w);
        dsTaint.addTaint(h);
        Drawable d;
        d = getCurrentDrawable();
        Drawable thumb;
        thumb = mThumb;
        int thumbHeight;
        thumbHeight = 0;
        thumbHeight = thumb.getIntrinsicHeight();
        int trackHeight;
        trackHeight = Math.min(mMaxHeight, h - mPaddingTop - mPaddingBottom);
        int max;
        max = getMax();
        float scale;
        scale = (float) getProgress() / (float) max;
        scale = 0;
        {
            {
                setThumbPos(w, thumb, scale, 0);
            } //End block
            int gapForCenteringTrack;
            gapForCenteringTrack = (thumbHeight - trackHeight) / 2;
            {
                d.setBounds(0, gapForCenteringTrack, 
                        w - mPaddingRight - mPaddingLeft, h - mPaddingBottom - gapForCenteringTrack
                        - mPaddingTop);
            } //End block
        } //End block
        {
            {
                d.setBounds(0, 0, w - mPaddingRight - mPaddingLeft, h - mPaddingBottom
                        - mPaddingTop);
            } //End block
            int gap;
            gap = (trackHeight - thumbHeight) / 2;
            {
                setThumbPos(w, thumb, scale, gap);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.019 -0400", hash_original_method = "CA4C19C8B40982548F0C235E2E1E696B", hash_generated_method = "91FC66EE14DC618D9E71493480F9A2E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setThumbPos(int w, Drawable thumb, float scale, int gap) {
        dsTaint.addTaint(w);
        dsTaint.addTaint(scale);
        dsTaint.addTaint(thumb.dsTaint);
        dsTaint.addTaint(gap);
        int available;
        available = w - mPaddingLeft - mPaddingRight;
        int thumbWidth;
        thumbWidth = thumb.getIntrinsicWidth();
        int thumbHeight;
        thumbHeight = thumb.getIntrinsicHeight();
        available -= thumbWidth;
        available += mThumbOffset * 2;
        int thumbPos;
        thumbPos = (int) (scale * available);
        int topBound, bottomBound;
        {
            Rect oldBounds;
            oldBounds = thumb.getBounds();
            topBound = oldBounds.top;
            bottomBound = oldBounds.bottom;
        } //End block
        {
            topBound = gap;
            bottomBound = gap + thumbHeight;
        } //End block
        thumb.setBounds(thumbPos, topBound, thumbPos + thumbWidth, bottomBound);
        // ---------- Original Method ----------
        //int available = w - mPaddingLeft - mPaddingRight;
        //int thumbWidth = thumb.getIntrinsicWidth();
        //int thumbHeight = thumb.getIntrinsicHeight();
        //available -= thumbWidth;
        //available += mThumbOffset * 2;
        //int thumbPos = (int) (scale * available);
        //int topBound, bottomBound;
        //if (gap == Integer.MIN_VALUE) {
            //Rect oldBounds = thumb.getBounds();
            //topBound = oldBounds.top;
            //bottomBound = oldBounds.bottom;
        //} else {
            //topBound = gap;
            //bottomBound = gap + thumbHeight;
        //}
        //thumb.setBounds(thumbPos, topBound, thumbPos + thumbWidth, bottomBound);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.020 -0400", hash_original_method = "317EB63F41EF20BCBD26EC2C5FF1A8E2", hash_generated_method = "0EEF06BEF3289F6C28FBDBF09746F38E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected synchronized void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(canvas.dsTaint);
        super.onDraw(canvas);
        {
            canvas.save();
            canvas.translate(mPaddingLeft - mThumbOffset, mPaddingTop);
            mThumb.draw(canvas);
            canvas.restore();
        } //End block
        // ---------- Original Method ----------
        //super.onDraw(canvas);
        //if (mThumb != null) {
            //canvas.save();
            //canvas.translate(mPaddingLeft - mThumbOffset, mPaddingTop);
            //mThumb.draw(canvas);
            //canvas.restore();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.021 -0400", hash_original_method = "6FE23FC5494DD28976118E3A2B4F8E1A", hash_generated_method = "FDCC62F4C83A53146B90D7DF7DEAECE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        Drawable d;
        d = getCurrentDrawable();
        int thumbHeight;
        thumbHeight = 0;
        thumbHeight = mThumb.getIntrinsicHeight();
        int dw;
        dw = 0;
        int dh;
        dh = 0;
        {
            dw = Math.max(mMinWidth, Math.min(mMaxWidth, d.getIntrinsicWidth()));
            dh = Math.max(mMinHeight, Math.min(mMaxHeight, d.getIntrinsicHeight()));
            dh = Math.max(thumbHeight, dh);
        } //End block
        dw += mPaddingLeft + mPaddingRight;
        dh += mPaddingTop + mPaddingBottom;
        setMeasuredDimension(resolveSizeAndState(dw, widthMeasureSpec, 0),
                resolveSizeAndState(dh, heightMeasureSpec, 0));
        // ---------- Original Method ----------
        //Drawable d = getCurrentDrawable();
        //int thumbHeight = mThumb == null ? 0 : mThumb.getIntrinsicHeight();
        //int dw = 0;
        //int dh = 0;
        //if (d != null) {
            //dw = Math.max(mMinWidth, Math.min(mMaxWidth, d.getIntrinsicWidth()));
            //dh = Math.max(mMinHeight, Math.min(mMaxHeight, d.getIntrinsicHeight()));
            //dh = Math.max(thumbHeight, dh);
        //}
        //dw += mPaddingLeft + mPaddingRight;
        //dh += mPaddingTop + mPaddingBottom;
        //setMeasuredDimension(resolveSizeAndState(dw, widthMeasureSpec, 0),
                //resolveSizeAndState(dh, heightMeasureSpec, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.021 -0400", hash_original_method = "E10F6AB7670DC24DEEA2309682812EC7", hash_generated_method = "065B5EE91F632E12EA934753D2C19AED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var8142D51ECE34BA115A5095ACA8798364_1784911220 = (!mIsUserSeekable || !isEnabled());
        } //End collapsed parenthetic
        {
            Object var9E1FBD251DF7E53AB77C3A31F15B2B38_967261044 = (event.getAction());
            //Begin case MotionEvent.ACTION_DOWN 
            {
                boolean varEE20AD2B6B37E9F2660E1C9FA2DDFF2D_1289093419 = (isInScrollingContainer());
                {
                    mTouchDownX = event.getX();
                } //End block
                {
                    setPressed(true);
                    {
                        invalidate(mThumb.getBounds());
                    } //End block
                    onStartTrackingTouch();
                    trackTouchEvent(event);
                    attemptClaimDrag();
                } //End block
            } //End collapsed parenthetic
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_MOVE 
            {
                trackTouchEvent(event);
            } //End block
            {
                float x;
                x = event.getX();
                {
                    boolean varEBF41794203D169307B1311D8438F448_1346675836 = (Math.abs(x - mTouchDownX) > mScaledTouchSlop);
                    {
                        setPressed(true);
                        {
                            invalidate(mThumb.getBounds());
                        } //End block
                        onStartTrackingTouch();
                        trackTouchEvent(event);
                        attemptClaimDrag();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            //End case MotionEvent.ACTION_MOVE 
            //Begin case MotionEvent.ACTION_UP 
            {
                trackTouchEvent(event);
                onStopTrackingTouch();
                setPressed(false);
            } //End block
            {
                onStartTrackingTouch();
                trackTouchEvent(event);
                onStopTrackingTouch();
            } //End block
            //End case MotionEvent.ACTION_UP 
            //Begin case MotionEvent.ACTION_UP 
            invalidate();
            //End case MotionEvent.ACTION_UP 
            //Begin case MotionEvent.ACTION_CANCEL 
            {
                onStopTrackingTouch();
                setPressed(false);
            } //End block
            //End case MotionEvent.ACTION_CANCEL 
            //Begin case MotionEvent.ACTION_CANCEL 
            invalidate();
            //End case MotionEvent.ACTION_CANCEL 
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.022 -0400", hash_original_method = "B852C5F326259FF2E0714D28C9BE0803", hash_generated_method = "46E55A9FA0773C3FE1EB6BAF7A5B33F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void trackTouchEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        int width;
        width = getWidth();
        int available;
        available = width - mPaddingLeft - mPaddingRight;
        int x;
        x = (int)event.getX();
        float scale;
        float progress;
        progress = 0;
        {
            scale = 0.0f;
        } //End block
        {
            scale = 1.0f;
        } //End block
        {
            scale = (float)(x - mPaddingLeft) / (float)available;
            progress = mTouchProgressOffset;
        } //End block
        int max;
        max = getMax();
        progress += scale * max;
        setProgress((int) progress, true);
        // ---------- Original Method ----------
        //final int width = getWidth();
        //final int available = width - mPaddingLeft - mPaddingRight;
        //int x = (int)event.getX();
        //float scale;
        //float progress = 0;
        //if (x < mPaddingLeft) {
            //scale = 0.0f;
        //} else if (x > width - mPaddingRight) {
            //scale = 1.0f;
        //} else {
            //scale = (float)(x - mPaddingLeft) / (float)available;
            //progress = mTouchProgressOffset;
        //}
        //final int max = getMax();
        //progress += scale * max;
        //setProgress((int) progress, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.022 -0400", hash_original_method = "EE6806E5D0C523D5F375E4021A29EB50", hash_generated_method = "2E73808719931C1764DD979BEA00A4A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void attemptClaimDrag() {
        {
            mParent.requestDisallowInterceptTouchEvent(true);
        } //End block
        // ---------- Original Method ----------
        //if (mParent != null) {
            //mParent.requestDisallowInterceptTouchEvent(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.022 -0400", hash_original_method = "81C3D3C536033DCEF00354E775EF2F98", hash_generated_method = "7CAEA821CD5CFD558839E482944A4FF3")
    @DSModeled(DSC.SAFE)
     void onStartTrackingTouch() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mIsDragging = true;
        // ---------- Original Method ----------
        //mIsDragging = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.022 -0400", hash_original_method = "E756AFD9567E2119FB96458DFE00C6A9", hash_generated_method = "28194EE71D53A1717F5B76FA4AF6B1F3")
    @DSModeled(DSC.SAFE)
     void onStopTrackingTouch() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mIsDragging = false;
        // ---------- Original Method ----------
        //mIsDragging = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.023 -0400", hash_original_method = "F04551903C4B751B14DE46074D4BB62C", hash_generated_method = "335DF8C256CE085A3A9253CFE15462AB")
    @DSModeled(DSC.SAFE)
     void onKeyChange() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.023 -0400", hash_original_method = "E4D4B44B4B0BF8B3ACFCDB808BF98F5B", hash_generated_method = "CB27408981FE942E083D51AF9AB00CE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var7DF3FD71A82DB900422A2663707EECDE_1109850277 = (isEnabled());
            {
                int progress;
                progress = getProgress();
                //Begin case KeyEvent.KEYCODE_DPAD_LEFT 
                setProgress(progress - mKeyProgressIncrement, true);
                //End case KeyEvent.KEYCODE_DPAD_LEFT 
                //Begin case KeyEvent.KEYCODE_DPAD_LEFT 
                onKeyChange();
                //End case KeyEvent.KEYCODE_DPAD_LEFT 
                //Begin case KeyEvent.KEYCODE_DPAD_RIGHT 
                {
                    boolean varB82DC9CDF51DAE5C4FBB90D1385705AF_376297787 = (progress >= getMax());
                } //End collapsed parenthetic
                //End case KeyEvent.KEYCODE_DPAD_RIGHT 
                //Begin case KeyEvent.KEYCODE_DPAD_RIGHT 
                setProgress(progress + mKeyProgressIncrement, true);
                //End case KeyEvent.KEYCODE_DPAD_RIGHT 
                //Begin case KeyEvent.KEYCODE_DPAD_RIGHT 
                onKeyChange();
                //End case KeyEvent.KEYCODE_DPAD_RIGHT 
            } //End block
        } //End collapsed parenthetic
        boolean var8C6E6C19273FC56B5C56CC7DEF63ED7B_2060095398 = (super.onKeyDown(keyCode, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (isEnabled()) {
            //int progress = getProgress();
            //switch (keyCode) {
                //case KeyEvent.KEYCODE_DPAD_LEFT:
                    //if (progress <= 0) break;
                    //setProgress(progress - mKeyProgressIncrement, true);
                    //onKeyChange();
                    //return true;
                //case KeyEvent.KEYCODE_DPAD_RIGHT:
                    //if (progress >= getMax()) break;
                    //setProgress(progress + mKeyProgressIncrement, true);
                    //onKeyChange();
                    //return true;
            //}
        //}
        //return super.onKeyDown(keyCode, event);
    }

    
    private static final int NO_ALPHA = 0xFF;
}

