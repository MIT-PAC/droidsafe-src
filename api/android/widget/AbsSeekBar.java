package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.614 -0400", hash_original_field = "4C52B1548343B5F67E71ABAB98CDCE25", hash_generated_field = "A9FD89A9EA0824250F9B9C034928CB8F")

    private Drawable mThumb;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.614 -0400", hash_original_field = "A28BD1DCDFDB076ED8B0128D800E7517", hash_generated_field = "EDEA4E873C327B12CA4083E0E57BEE64")

    private int mThumbOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.614 -0400", hash_original_field = "55F071D4796DEB743D84809F3A8DC6D5", hash_generated_field = "E221719242D0437E0E0816E9049A3A6E")

    float mTouchProgressOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.614 -0400", hash_original_field = "281E125C1BC7343D2104EB0DF2965583", hash_generated_field = "267BD1149348204124B40DB8937D82FB")

    boolean mIsUserSeekable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.614 -0400", hash_original_field = "D09059F0BDE48E485EF2977038ECC6B6", hash_generated_field = "DA3EB023D2AE87BC493256844DF4F8FC")

    private int mKeyProgressIncrement = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.614 -0400", hash_original_field = "442F8731C67AF26E1E29D47472A461BF", hash_generated_field = "BE45430B4E582ECC76FDAE96B324FF18")

    private float mDisabledAlpha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.614 -0400", hash_original_field = "007A72391FE679B54C8CDBD6A79A1E3F", hash_generated_field = "A6018E4F8C21D3EE961380A6D74CC7E0")

    private int mScaledTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.614 -0400", hash_original_field = "82594ABA40C2D7123512A711436C704D", hash_generated_field = "A48801BD53279BF93DEF5A0855023B3F")

    private float mTouchDownX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.615 -0400", hash_original_field = "88529674006503CAD340B538C44A2C88", hash_generated_field = "71A2FEF14E89166E5A8A859417B1663A")

    private boolean mIsDragging;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.615 -0400", hash_original_method = "559FDCE349858758D50BC2905EE88B67", hash_generated_method = "FDA7C2EB8B5296D46FCCA250BF0143BC")
    public  AbsSeekBar(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.615 -0400", hash_original_method = "9B53DFB86DC24D620F7DF1D33C461438", hash_generated_method = "0E2064C65DFD6A1F4F14468BF35A30CF")
    public  AbsSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.616 -0400", hash_original_method = "1A34D5E8CF032B0AA6AD65EE16F7EFF6", hash_generated_method = "D5A625CF0D79AD9940C01434BE68DF7F")
    public  AbsSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.SeekBar, defStyle, 0);
        Drawable thumb = a.getDrawable(com.android.internal.R.styleable.SeekBar_thumb);
        setThumb(thumb);
        int thumbOffset = a.getDimensionPixelOffset(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.617 -0400", hash_original_method = "998F0AEDC4C83C00C5B5C0950AA82FAF", hash_generated_method = "EEB40915095E404D71B3A50C9D033C27")
    public void setThumb(Drawable thumb) {
        boolean needUpdate;
    if(mThumb != null && thumb != mThumb)        
        {
            mThumb.setCallback(null);
            needUpdate = true;
        } //End block
        else
        {
            needUpdate = false;
        } //End block
    if(thumb != null)        
        {
            thumb.setCallback(this);
            mThumbOffset = thumb.getIntrinsicWidth() / 2;
    if(needUpdate &&
                    (thumb.getIntrinsicWidth() != mThumb.getIntrinsicWidth()
                        || thumb.getIntrinsicHeight() != mThumb.getIntrinsicHeight()))            
            {
                requestLayout();
            } //End block
        } //End block
        mThumb = thumb;
        invalidate();
    if(needUpdate)        
        {
            updateThumbPos(getWidth(), getHeight());
    if(thumb.isStateful())            
            {
                int[] state = getDrawableState();
                thumb.setState(state);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.618 -0400", hash_original_method = "55BCE64F6AB8A7FA94D80EC71DE6965C", hash_generated_method = "69969BE0978D546C3E0967EA03009C6C")
    public int getThumbOffset() {
        int varA28BD1DCDFDB076ED8B0128D800E7517_523218408 = (mThumbOffset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_526861078 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_526861078;
        // ---------- Original Method ----------
        //return mThumbOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.618 -0400", hash_original_method = "19F18537D3EF5D294C0A19C19876A9D3", hash_generated_method = "C1AE1170153E1358AA343297EAC9437B")
    public void setThumbOffset(int thumbOffset) {
        mThumbOffset = thumbOffset;
        invalidate();
        // ---------- Original Method ----------
        //mThumbOffset = thumbOffset;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.619 -0400", hash_original_method = "47EA7303B3E1A2D7511BD2240E8B9AF2", hash_generated_method = "23FC38C564F6AB4BEDBEB8AF8AF33262")
    public void setKeyProgressIncrement(int increment) {
        mKeyProgressIncrement = increment < 0 ? -increment : increment;
        // ---------- Original Method ----------
        //mKeyProgressIncrement = increment < 0 ? -increment : increment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.619 -0400", hash_original_method = "1305A27F8447A6D05AC7D82E2D035BB9", hash_generated_method = "B32E8C8EEE3FB08464A556FE1368E3E3")
    public int getKeyProgressIncrement() {
        int varC55911B792B2D1356C2FA646B234CAEE_2115305878 = (mKeyProgressIncrement);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1385006054 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1385006054;
        // ---------- Original Method ----------
        //return mKeyProgressIncrement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.619 -0400", hash_original_method = "B86F9FD250EB4E355A6234A6154554E5", hash_generated_method = "2DD959F4E12E1D1F80F3D4224FD42B7A")
    @Override
    public synchronized void setMax(int max) {
        addTaint(max);
        super.setMax(max);
    if((mKeyProgressIncrement == 0) || (getMax() / mKeyProgressIncrement > 20))        
        {
            setKeyProgressIncrement(Math.max(1, Math.round((float) getMax() / 20)));
        } //End block
        // ---------- Original Method ----------
        //super.setMax(max);
        //if ((mKeyProgressIncrement == 0) || (getMax() / mKeyProgressIncrement > 20)) {
            //setKeyProgressIncrement(Math.max(1, Math.round((float) getMax() / 20)));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.620 -0400", hash_original_method = "9C2A9BDC8A382BBBC0B52ACD6BB3E808", hash_generated_method = "C3DA72E247BCB93CF44A60CD74295519")
    @Override
    protected boolean verifyDrawable(Drawable who) {
        addTaint(who.getTaint());
        boolean var40C93E378C8931BB1A1E215663973346_1408420436 = (who == mThumb || super.verifyDrawable(who));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_432516161 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_432516161;
        // ---------- Original Method ----------
        //return who == mThumb || super.verifyDrawable(who);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.620 -0400", hash_original_method = "A2BEB9099595ED17C9F72C657E221F4D", hash_generated_method = "1649235F7AE89E25D54050B6CE9EC8AF")
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
    if(mThumb != null)        
        mThumb.jumpToCurrentState();
        // ---------- Original Method ----------
        //super.jumpDrawablesToCurrentState();
        //if (mThumb != null) mThumb.jumpToCurrentState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.620 -0400", hash_original_method = "18D3C014C29EEACE1B64A99674108866", hash_generated_method = "26C849F776D29648E3856D4193A00387")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable progressDrawable = getProgressDrawable();
    if(progressDrawable != null)        
        {
            progressDrawable.setAlpha(isEnabled() ? NO_ALPHA : (int) (NO_ALPHA * mDisabledAlpha));
        } //End block
    if(mThumb != null && mThumb.isStateful())        
        {
            int[] state = getDrawableState();
            mThumb.setState(state);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.621 -0400", hash_original_method = "BD33A56797AEA3D6F712418E2C1B11B9", hash_generated_method = "861AD8C3EC20310D05FAC1B6B274FD8B")
    @Override
     void onProgressRefresh(float scale, boolean fromUser) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(fromUser);
        addTaint(scale);
        super.onProgressRefresh(scale, fromUser);
        Drawable thumb = mThumb;
    if(thumb != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.621 -0400", hash_original_method = "A1D4A37B8CF40CBB929E8D311A74C166", hash_generated_method = "09A146E0599528F7EF1BF28C7B631032")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(oldh);
        addTaint(oldw);
        addTaint(h);
        addTaint(w);
        updateThumbPos(w, h);
        // ---------- Original Method ----------
        //updateThumbPos(w, h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.621 -0400", hash_original_method = "EBB195A6F6AE70942CBBB72014D4E630", hash_generated_method = "EEBA0758A06700BC917CD7B6307F35F7")
    private void updateThumbPos(int w, int h) {
        addTaint(h);
        addTaint(w);
        Drawable d = getCurrentDrawable();
        Drawable thumb = mThumb;
        int thumbHeight = thumb == null ? 0 : thumb.getIntrinsicHeight();
        int trackHeight = Math.min(mMaxHeight, h - mPaddingTop - mPaddingBottom);
        int max = getMax();
        float scale = max > 0 ? (float) getProgress() / (float) max : 0;
    if(thumbHeight > trackHeight)        
        {
    if(thumb != null)            
            {
                setThumbPos(w, thumb, scale, 0);
            } //End block
            int gapForCenteringTrack = (thumbHeight - trackHeight) / 2;
    if(d != null)            
            {
                d.setBounds(0, gapForCenteringTrack, 
                        w - mPaddingRight - mPaddingLeft, h - mPaddingBottom - gapForCenteringTrack
                        - mPaddingTop);
            } //End block
        } //End block
        else
        {
    if(d != null)            
            {
                d.setBounds(0, 0, w - mPaddingRight - mPaddingLeft, h - mPaddingBottom
                        - mPaddingTop);
            } //End block
            int gap = (trackHeight - thumbHeight) / 2;
    if(thumb != null)            
            {
                setThumbPos(w, thumb, scale, gap);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.622 -0400", hash_original_method = "CA4C19C8B40982548F0C235E2E1E696B", hash_generated_method = "F30533D5251F0D11C8B4CFD2FF36B697")
    private void setThumbPos(int w, Drawable thumb, float scale, int gap) {
        addTaint(gap);
        addTaint(scale);
        addTaint(thumb.getTaint());
        addTaint(w);
        int available = w - mPaddingLeft - mPaddingRight;
        int thumbWidth = thumb.getIntrinsicWidth();
        int thumbHeight = thumb.getIntrinsicHeight();
        available -= thumbWidth;
        available += mThumbOffset * 2;
        int thumbPos = (int) (scale * available);
        int topBound;
        int bottomBound;
    if(gap == Integer.MIN_VALUE)        
        {
            Rect oldBounds = thumb.getBounds();
            topBound = oldBounds.top;
            bottomBound = oldBounds.bottom;
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.623 -0400", hash_original_method = "317EB63F41EF20BCBD26EC2C5FF1A8E2", hash_generated_method = "D6E8D0DB70D229BCB2C29DCB85266734")
    @Override
    protected synchronized void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
        super.onDraw(canvas);
    if(mThumb != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.624 -0400", hash_original_method = "6FE23FC5494DD28976118E3A2B4F8E1A", hash_generated_method = "A3D058C3B4CEA7DF4969518711C4F2C6")
    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        Drawable d = getCurrentDrawable();
        int thumbHeight = mThumb == null ? 0 : mThumb.getIntrinsicHeight();
        int dw = 0;
        int dh = 0;
    if(d != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.625 -0400", hash_original_method = "E10F6AB7670DC24DEEA2309682812EC7", hash_generated_method = "53206375D00AC1DD9DD8DEF773558A20")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(!mIsUserSeekable || !isEnabled())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1187808032 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1418528180 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1418528180;
        } //End block
switch(event.getAction()){
        case MotionEvent.ACTION_DOWN:
    if(isInScrollingContainer())        
        {
            mTouchDownX = event.getX();
        } //End block
        else
        {
            setPressed(true);
    if(mThumb != null)            
            {
                invalidate(mThumb.getBounds());
            } //End block
            onStartTrackingTouch();
            trackTouchEvent(event);
            attemptClaimDrag();
        } //End block
        break;
        case MotionEvent.ACTION_MOVE:
    if(mIsDragging)        
        {
            trackTouchEvent(event);
        } //End block
        else
        {
            final float x = event.getX();
    if(Math.abs(x - mTouchDownX) > mScaledTouchSlop)            
            {
                setPressed(true);
    if(mThumb != null)                
                {
                    invalidate(mThumb.getBounds());
                } //End block
                onStartTrackingTouch();
                trackTouchEvent(event);
                attemptClaimDrag();
            } //End block
        } //End block
        break;
        case MotionEvent.ACTION_UP:
    if(mIsDragging)        
        {
            trackTouchEvent(event);
            onStopTrackingTouch();
            setPressed(false);
        } //End block
        else
        {
            onStartTrackingTouch();
            trackTouchEvent(event);
            onStopTrackingTouch();
        } //End block
        invalidate();
        break;
        case MotionEvent.ACTION_CANCEL:
    if(mIsDragging)        
        {
            onStopTrackingTouch();
            setPressed(false);
        } //End block
        invalidate();
        break;
}        boolean varB326B5062B2F0E69046810717534CB09_1176678970 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2112657067 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2112657067;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.628 -0400", hash_original_method = "B852C5F326259FF2E0714D28C9BE0803", hash_generated_method = "F2D8B3C76143D4B3CDE1BEDEB49AFE66")
    private void trackTouchEvent(MotionEvent event) {
        addTaint(event.getTaint());
        final int width = getWidth();
        final int available = width - mPaddingLeft - mPaddingRight;
        int x = (int)event.getX();
        float scale;
        float progress = 0;
    if(x < mPaddingLeft)        
        {
            scale = 0.0f;
        } //End block
        else
    if(x > width - mPaddingRight)        
        {
            scale = 1.0f;
        } //End block
        else
        {
            scale = (float)(x - mPaddingLeft) / (float)available;
            progress = mTouchProgressOffset;
        } //End block
        final int max = getMax();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.629 -0400", hash_original_method = "EE6806E5D0C523D5F375E4021A29EB50", hash_generated_method = "8A968C4896AB12821206CFEA1423C0BB")
    private void attemptClaimDrag() {
    if(mParent != null)        
        {
            mParent.requestDisallowInterceptTouchEvent(true);
        } //End block
        // ---------- Original Method ----------
        //if (mParent != null) {
            //mParent.requestDisallowInterceptTouchEvent(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.629 -0400", hash_original_method = "81C3D3C536033DCEF00354E775EF2F98", hash_generated_method = "7CAEA821CD5CFD558839E482944A4FF3")
     void onStartTrackingTouch() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mIsDragging = true;
        // ---------- Original Method ----------
        //mIsDragging = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.630 -0400", hash_original_method = "E756AFD9567E2119FB96458DFE00C6A9", hash_generated_method = "28194EE71D53A1717F5B76FA4AF6B1F3")
     void onStopTrackingTouch() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mIsDragging = false;
        // ---------- Original Method ----------
        //mIsDragging = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.630 -0400", hash_original_method = "F04551903C4B751B14DE46074D4BB62C", hash_generated_method = "335DF8C256CE085A3A9253CFE15462AB")
     void onKeyChange() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.631 -0400", hash_original_method = "E4D4B44B4B0BF8B3ACFCDB808BF98F5B", hash_generated_method = "B08BA82682BD3BD61399E95474FAB024")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
    if(isEnabled())        
        {
            int progress = getProgress();
switch(keyCode){
            case KeyEvent.KEYCODE_DPAD_LEFT:
    if(progress <= 0)            
            break;
            setProgress(progress - mKeyProgressIncrement, true);
            onKeyChange();
            boolean varB326B5062B2F0E69046810717534CB09_1669439095 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2104678105 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2104678105;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
    if(progress >= getMax())            
            break;
            setProgress(progress + mKeyProgressIncrement, true);
            onKeyChange();
            boolean varB326B5062B2F0E69046810717534CB09_1658318004 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_248753101 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_248753101;
}
        } //End block
        boolean var947F0C250323B9F4475E02588E9A9740_131858449 = (super.onKeyDown(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2034288486 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2034288486;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.631 -0400", hash_original_field = "B56B6FA624E764C4691175252EBD6A92", hash_generated_field = "0FC0F1E74EFFD499D7E9EC90666C1A5B")

    private static final int NO_ALPHA = 0xFF;
}

