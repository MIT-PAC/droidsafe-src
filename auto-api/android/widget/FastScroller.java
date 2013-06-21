package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView.OnScrollListener;

class FastScroller {
    private Drawable mThumbDrawable;
    private Drawable mOverlayDrawable;
    private Drawable mTrackDrawable;
    private Drawable mOverlayDrawableLeft;
    private Drawable mOverlayDrawableRight;
    int mThumbH;
    int mThumbW;
    int mThumbY;
    private RectF mOverlayPos;
    private int mOverlaySize;
    AbsListView mList;
    boolean mScrollCompleted;
    private int mVisibleItem;
    private Paint mPaint;
    private int mListOffset;
    private int mItemCount = -1;
    private boolean mLongList;
    private Object [] mSections;
    private String mSectionText;
    private boolean mDrawOverlay;
    private ScrollFade mScrollFade;
    private int mState;
    private Handler mHandler = new Handler();
    BaseAdapter mListAdapter;
    private SectionIndexer mSectionIndexer;
    private boolean mChangedBounds;
    private int mPosition;
    private boolean mAlwaysShow;
    private int mOverlayPosition;
    private boolean mMatchDragPosition;
    float mInitialTouchY;
    boolean mPendingDrag;
    private int mScaledTouchSlop;
    private Rect mTmpRect = new Rect();
    private final Runnable mDeferStartDrag = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.684 -0400", hash_original_method = "8A3021930710B16F81DE57976EDC3D0F", hash_generated_method = "A54B8140DCAB37601071A13B219175E4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            {
                beginDrag();
                int viewHeight;
                viewHeight = mList.getHeight();
                int newThumbY;
                newThumbY = (int) mInitialTouchY - mThumbH + 10;
                {
                    newThumbY = 0;
                } //End block
                {
                    newThumbY = viewHeight - mThumbH;
                } //End block
                mThumbY = newThumbY;
                scrollTo((float) mThumbY / (viewHeight - mThumbH));
            } //End block
            mPendingDrag = false;
            // ---------- Original Method ----------
            //if (mList.mIsAttached) {
                //beginDrag();
                //final int viewHeight = mList.getHeight();
                //int newThumbY = (int) mInitialTouchY - mThumbH + 10;
                //if (newThumbY < 0) {
                    //newThumbY = 0;
                //} else if (newThumbY + mThumbH > viewHeight) {
                    //newThumbY = viewHeight - mThumbH;
                //}
                //mThumbY = newThumbY;
                //scrollTo((float) mThumbY / (viewHeight - mThumbH));
            //}
            //mPendingDrag = false;
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.684 -0400", hash_original_method = "A2A2A1F0C9639ECE9FE84AFC4D4D3A80", hash_generated_method = "3A0FBBFCB8119D2A1035789EB7AD4DE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FastScroller(Context context, AbsListView listView) {
        dsTaint.addTaint(listView.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        init(context);
        // ---------- Original Method ----------
        //mList = listView;
        //init(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.684 -0400", hash_original_method = "39D93CA5552A2245B487796C83EA3A2C", hash_generated_method = "D2D54482FA9C786B000D5775160D2278")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAlwaysShow(boolean alwaysShow) {
        dsTaint.addTaint(alwaysShow);
        {
            mHandler.removeCallbacks(mScrollFade);
            setState(STATE_VISIBLE);
        } //End block
        {
            mHandler.postDelayed(mScrollFade, FADE_TIMEOUT);
        } //End block
        // ---------- Original Method ----------
        //mAlwaysShow = alwaysShow;
        //if (alwaysShow) {
            //mHandler.removeCallbacks(mScrollFade);
            //setState(STATE_VISIBLE);
        //} else if (mState == STATE_VISIBLE) {
            //mHandler.postDelayed(mScrollFade, FADE_TIMEOUT);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.684 -0400", hash_original_method = "FE4F6BFF00D7A9534103DEC6DDA5B37C", hash_generated_method = "7A67CE8C418136051B3AE0B6A10584F0")
    @DSModeled(DSC.SAFE)
    public boolean isAlwaysShowEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAlwaysShow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.684 -0400", hash_original_method = "8A07D5E4DE8CD170DC3BFC9FE8A30504", hash_generated_method = "72F1E01536A97C16FDF90BD85B98FA57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void refreshDrawableState() {
        int[] state;
        state = PRESSED_STATES;
        state = DEFAULT_STATES;
        {
            boolean varFFD0D4700603A30109E1419E6751DAC5_893787938 = (mThumbDrawable != null && mThumbDrawable.isStateful());
            {
                mThumbDrawable.setState(state);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var186A66CF4AFBB431FA0AA3F444BEC0A2_1648021551 = (mTrackDrawable != null && mTrackDrawable.isStateful());
            {
                mTrackDrawable.setState(state);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int[] state = mState == STATE_DRAGGING ? PRESSED_STATES : DEFAULT_STATES;
        //if (mThumbDrawable != null && mThumbDrawable.isStateful()) {
            //mThumbDrawable.setState(state);
        //}
        //if (mTrackDrawable != null && mTrackDrawable.isStateful()) {
            //mTrackDrawable.setState(state);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.685 -0400", hash_original_method = "4A2BCFB2C4534D1665C92142AF186787", hash_generated_method = "4A21841193755F2CDD7D7C54FC0223F2")
    @DSModeled(DSC.SAFE)
    public void setScrollbarPosition(int position) {
        dsTaint.addTaint(position);
        //Begin case default View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
        mOverlayDrawable = mOverlayDrawableRight;
        //End case default View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
        //Begin case View.SCROLLBAR_POSITION_LEFT 
        mOverlayDrawable = mOverlayDrawableLeft;
        //End case View.SCROLLBAR_POSITION_LEFT 
        // ---------- Original Method ----------
        //mPosition = position;
        //switch (position) {
            //default:
            //case View.SCROLLBAR_POSITION_DEFAULT:
            //case View.SCROLLBAR_POSITION_RIGHT:
                //mOverlayDrawable = mOverlayDrawableRight;
                //break;
            //case View.SCROLLBAR_POSITION_LEFT:
                //mOverlayDrawable = mOverlayDrawableLeft;
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.685 -0400", hash_original_method = "B47561E95C2F1E64B16085B75AB60280", hash_generated_method = "50BB6BE2A8F3B340837F6A1DEB3A3D84")
    @DSModeled(DSC.SAFE)
    public int getWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mThumbW;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.685 -0400", hash_original_method = "FD0548A7869DD54F34FB4A98FCCC10E9", hash_generated_method = "7435642DAC4AD85B79A94F2B3518772C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setState(int state) {
        dsTaint.addTaint(state);
        //Begin case STATE_NONE 
        mHandler.removeCallbacks(mScrollFade);
        //End case STATE_NONE 
        //Begin case STATE_NONE 
        mList.invalidate();
        //End case STATE_NONE 
        //Begin case STATE_VISIBLE 
        {
            resetThumbPos();
        } //End block
        //End case STATE_VISIBLE 
        //Begin case STATE_DRAGGING 
        mHandler.removeCallbacks(mScrollFade);
        //End case STATE_DRAGGING 
        //Begin case STATE_EXIT 
        int viewWidth;
        viewWidth = mList.getWidth();
        //End case STATE_EXIT 
        //Begin case STATE_EXIT 
        mList.invalidate(viewWidth - mThumbW, mThumbY, viewWidth, mThumbY + mThumbH);
        //End case STATE_EXIT 
        refreshDrawableState();
        // ---------- Original Method ----------
        //switch (state) {
            //case STATE_NONE:
                //mHandler.removeCallbacks(mScrollFade);
                //mList.invalidate();
                //break;
            //case STATE_VISIBLE:
                //if (mState != STATE_VISIBLE) { 
                    //resetThumbPos();
                //}
            //case STATE_DRAGGING:
                //mHandler.removeCallbacks(mScrollFade);
                //break;
            //case STATE_EXIT:
                //int viewWidth = mList.getWidth();
                //mList.invalidate(viewWidth - mThumbW, mThumbY, viewWidth, mThumbY + mThumbH);
                //break;
        //}
        //mState = state;
        //refreshDrawableState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.685 -0400", hash_original_method = "10E9373648D5DF4EE43B4904732E3886", hash_generated_method = "EAFA6E13B7668B98AAF6336330D54E32")
    @DSModeled(DSC.SAFE)
    public int getState() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.685 -0400", hash_original_method = "C32E62B08B27A384339E1BC75CFE4552", hash_generated_method = "4C891B7316A12CA786E90BF79A4EEC23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void resetThumbPos() {
        int viewWidth;
        viewWidth = mList.getWidth();
        //Begin case View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
        mThumbDrawable.setBounds(viewWidth - mThumbW, 0, viewWidth, mThumbH);
        //End case View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
        //Begin case View.SCROLLBAR_POSITION_LEFT 
        mThumbDrawable.setBounds(0, 0, mThumbW, mThumbH);
        //End case View.SCROLLBAR_POSITION_LEFT 
        mThumbDrawable.setAlpha(ScrollFade.ALPHA_MAX);
        // ---------- Original Method ----------
        //final int viewWidth = mList.getWidth();
        //switch (mPosition) {
            //case View.SCROLLBAR_POSITION_DEFAULT:
            //case View.SCROLLBAR_POSITION_RIGHT:
                //mThumbDrawable.setBounds(viewWidth - mThumbW, 0, viewWidth, mThumbH);
                //break;
            //case View.SCROLLBAR_POSITION_LEFT:
                //mThumbDrawable.setBounds(0, 0, mThumbW, mThumbH);
                //break;
        //}
        //mThumbDrawable.setAlpha(ScrollFade.ALPHA_MAX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.686 -0400", hash_original_method = "5C6D13F417D5AA8E0A1553C57F0CD3F0", hash_generated_method = "D301529F93DDF80E1997963A2C171B3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void useThumbDrawable(Context context, Drawable drawable) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(drawable.dsTaint);
        {
            mThumbW = context.getResources().getDimensionPixelSize(
                    com.android.internal.R.dimen.fastscroll_thumb_width);
            mThumbH = context.getResources().getDimensionPixelSize(
                    com.android.internal.R.dimen.fastscroll_thumb_height);
        } //End block
        {
            mThumbW = drawable.getIntrinsicWidth();
            mThumbH = drawable.getIntrinsicHeight();
        } //End block
        mChangedBounds = true;
        // ---------- Original Method ----------
        //mThumbDrawable = drawable;
        //if (drawable instanceof NinePatchDrawable) {
            //mThumbW = context.getResources().getDimensionPixelSize(
                    //com.android.internal.R.dimen.fastscroll_thumb_width);
            //mThumbH = context.getResources().getDimensionPixelSize(
                    //com.android.internal.R.dimen.fastscroll_thumb_height);
        //} else {
            //mThumbW = drawable.getIntrinsicWidth();
            //mThumbH = drawable.getIntrinsicHeight();
        //}
        //mChangedBounds = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.686 -0400", hash_original_method = "0A57524C8928F6FDE971C9B9E9D3463C", hash_generated_method = "D1C4D362610005F6F319757D4750F3DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init(Context context) {
        dsTaint.addTaint(context.dsTaint);
        TypedArray ta;
        ta = context.getTheme().obtainStyledAttributes(ATTRS);
        useThumbDrawable(context, ta.getDrawable(THUMB_DRAWABLE));
        mTrackDrawable = ta.getDrawable(TRACK_DRAWABLE);
        mOverlayDrawableLeft = ta.getDrawable(PREVIEW_BACKGROUND_LEFT);
        mOverlayDrawableRight = ta.getDrawable(PREVIEW_BACKGROUND_RIGHT);
        mOverlayPosition = ta.getInt(OVERLAY_POSITION, OVERLAY_FLOATING);
        mScrollCompleted = true;
        getSectionsFromIndexer();
        mOverlaySize = context.getResources().getDimensionPixelSize(
                com.android.internal.R.dimen.fastscroll_overlay_size);
        mOverlayPos = new RectF();
        mScrollFade = new ScrollFade();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(mOverlaySize / 2);
        ColorStateList textColor;
        textColor = ta.getColorStateList(TEXT_COLOR);
        int textColorNormal;
        textColorNormal = textColor.getDefaultColor();
        mPaint.setColor(textColorNormal);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        {
            boolean var0E9C0EBA61F05B4437A59B11FFE8A9DF_1608007441 = (mList.getWidth() > 0 && mList.getHeight() > 0);
            {
                onSizeChanged(mList.getWidth(), mList.getHeight(), 0, 0);
            } //End block
        } //End collapsed parenthetic
        mState = STATE_NONE;
        refreshDrawableState();
        ta.recycle();
        mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        mMatchDragPosition = context.getApplicationInfo().targetSdkVersion >=
                android.os.Build.VERSION_CODES.HONEYCOMB;
        setScrollbarPosition(mList.getVerticalScrollbarPosition());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.687 -0400", hash_original_method = "056243A841F0EC691D28BA5422CDF65B", hash_generated_method = "CFE1ED30A07D3814D31EDD1FE0EF553E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void stop() {
        setState(STATE_NONE);
        // ---------- Original Method ----------
        //setState(STATE_NONE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.687 -0400", hash_original_method = "DC69F15A6278F37206902D3451EB4A27", hash_generated_method = "A6DC648F94467B85E3D107A8078CDA65")
    @DSModeled(DSC.SAFE)
     boolean isVisible() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !(mState == STATE_NONE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.688 -0400", hash_original_method = "C51EC11284E4C57CA49569FFECEAA05A", hash_generated_method = "4B321B020EB92A5D7C39BDE47A8EB586")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        int y;
        y = mThumbY;
        int viewWidth;
        viewWidth = mList.getWidth();
        FastScroller.ScrollFade scrollFade;
        scrollFade = mScrollFade;
        int alpha;
        alpha = -1;
        {
            alpha = scrollFade.getAlpha();
            {
                mThumbDrawable.setAlpha(alpha * 2);
            } //End block
            int left;
            left = 0;
            //Begin case View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
            left = viewWidth - (mThumbW * alpha) / ScrollFade.ALPHA_MAX;
            //End case View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
            //Begin case View.SCROLLBAR_POSITION_LEFT 
            left = -mThumbW + (mThumbW * alpha) / ScrollFade.ALPHA_MAX;
            //End case View.SCROLLBAR_POSITION_LEFT 
            mThumbDrawable.setBounds(left, 0, left + mThumbW, mThumbH);
            mChangedBounds = true;
        } //End block
        {
            Rect thumbBounds;
            thumbBounds = mThumbDrawable.getBounds();
            int left;
            left = thumbBounds.left;
            int halfThumbHeight;
            halfThumbHeight = (thumbBounds.bottom - thumbBounds.top) / 2;
            int trackWidth;
            trackWidth = mTrackDrawable.getIntrinsicWidth();
            int trackLeft;
            trackLeft = (left + mThumbW / 2) - trackWidth / 2;
            mTrackDrawable.setBounds(trackLeft, halfThumbHeight,
                    trackLeft + trackWidth, mList.getHeight() - halfThumbHeight);
            mTrackDrawable.draw(canvas);
        } //End block
        canvas.translate(0, y);
        mThumbDrawable.draw(canvas);
        canvas.translate(0, -y);
        {
            {
                int left;
                left = 0;
                //Begin case default View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
                left = Math.max(0,
                                mThumbDrawable.getBounds().left - mThumbW - mOverlaySize);
                //End case default View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
                //Begin case View.SCROLLBAR_POSITION_LEFT 
                left = Math.min(mThumbDrawable.getBounds().right + mThumbW,
                                mList.getWidth() - mOverlaySize);
                //End case View.SCROLLBAR_POSITION_LEFT 
                int top;
                top = Math.max(0,
                        Math.min(y + (mThumbH - mOverlaySize) / 2, mList.getHeight() - mOverlaySize));
                RectF pos;
                pos = mOverlayPos;
                pos.left = left;
                pos.right = pos.left + mOverlaySize;
                pos.top = top;
                pos.bottom = pos.top + mOverlaySize;
                {
                    mOverlayDrawable.setBounds((int) pos.left, (int) pos.top,
                            (int) pos.right, (int) pos.bottom);
                } //End block
            } //End block
            mOverlayDrawable.draw(canvas);
            Paint paint;
            paint = mPaint;
            float descent;
            descent = paint.descent();
            RectF rectF;
            rectF = mOverlayPos;
            Rect tmpRect;
            tmpRect = mTmpRect;
            mOverlayDrawable.getPadding(tmpRect);
            int hOff;
            hOff = (tmpRect.right - tmpRect.left) / 2;
            int vOff;
            vOff = (tmpRect.bottom - tmpRect.top) / 2;
            canvas.drawText(mSectionText, (int) (rectF.left + rectF.right) / 2 - hOff,
                    (int) (rectF.bottom + rectF.top) / 2 + mOverlaySize / 4 - descent - vOff,
                    paint);
        } //End block
        {
            {
                setState(STATE_NONE);
            } //End block
            {
                mList.invalidate(viewWidth - mThumbW, 0, viewWidth, mList.getHeight());
            } //End block
            {
                mList.invalidate(viewWidth - mThumbW, y, viewWidth, y + mThumbH);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.688 -0400", hash_original_method = "E295B7FC2E9560F481D5875AE2ECD038", hash_generated_method = "FC6C60C960BE18A06CB2F98F5F70A026")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(w);
        dsTaint.addTaint(oldh);
        dsTaint.addTaint(oldw);
        dsTaint.addTaint(h);
        {
            //Begin case default View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
            mThumbDrawable.setBounds(w - mThumbW, 0, w, mThumbH);
            //End case default View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
            //Begin case View.SCROLLBAR_POSITION_LEFT 
            mThumbDrawable.setBounds(0, 0, mThumbW, mThumbH);
            //End case View.SCROLLBAR_POSITION_LEFT 
        } //End block
        {
            RectF pos;
            pos = mOverlayPos;
            pos.left = (w - mOverlaySize) / 2;
            pos.right = pos.left + mOverlaySize;
            pos.top = h / 10;
            pos.bottom = pos.top + mOverlaySize;
            {
                mOverlayDrawable.setBounds((int) pos.left, (int) pos.top,
                        (int) pos.right, (int) pos.bottom);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.688 -0400", hash_original_method = "33CBCEE809BB980D8FD69134B46323D0", hash_generated_method = "214EF823355FE9488E3DE08F5482DFD2")
    @DSModeled(DSC.SAFE)
     void onItemCountChanged(int oldCount, int newCount) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(oldCount);
        dsTaint.addTaint(newCount);
        {
            mLongList = true;
        } //End block
        // ---------- Original Method ----------
        //if (mAlwaysShow) {
            //mLongList = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.689 -0400", hash_original_method = "E5B6E6440A22D0800FAD70BDC783A6AE", hash_generated_method = "62178BAB6FEFA794D5CEFB3069D334A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, 
            int totalItemCount) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(totalItemCount);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(visibleItemCount);
        dsTaint.addTaint(firstVisibleItem);
        {
            mLongList = mItemCount / visibleItemCount >= MIN_PAGES;
        } //End block
        {
            mLongList = true;
        } //End block
        {
            {
                setState(STATE_NONE);
            } //End block
        } //End block
        {
            mThumbY = getThumbPositionForListPosition(firstVisibleItem, visibleItemCount,
                    totalItemCount);
            {
                resetThumbPos();
                mChangedBounds = false;
            } //End block
        } //End block
        mScrollCompleted = true;
        {
            setState(STATE_VISIBLE);
            {
                mHandler.postDelayed(mScrollFade, FADE_TIMEOUT);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.689 -0400", hash_original_method = "AD42D97439FFEC71F76D9E9B9EF1920A", hash_generated_method = "AE0643EA31526889395BC865016964B0")
    @DSModeled(DSC.SAFE)
     SectionIndexer getSectionIndexer() {
        return (SectionIndexer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSectionIndexer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.689 -0400", hash_original_method = "0CD968054794DA4AF55762FEAC06E707", hash_generated_method = "3AAA420C4F3A053BEB10A5E99A999B85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Object[] getSections() {
        {
            getSectionsFromIndexer();
        } //End block
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mListAdapter == null && mList != null) {
            //getSectionsFromIndexer();
        //}
        //return mSections;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.689 -0400", hash_original_method = "800EB68723F3F3F4CE4E1BDE2BD8DC58", hash_generated_method = "9F4C51120EC6D22CCDC7EA269C0AC4D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void getSectionsFromIndexer() {
        Adapter adapter;
        adapter = mList.getAdapter();
        mSectionIndexer = null;
        {
            mListOffset = ((HeaderViewListAdapter)adapter).getHeadersCount();
            adapter = ((HeaderViewListAdapter)adapter).getWrappedAdapter();
        } //End block
        {
            ExpandableListAdapter expAdapter;
            expAdapter = ((ExpandableListConnector)adapter).getAdapter();
            {
                mSectionIndexer = (SectionIndexer) expAdapter;
                mListAdapter = (BaseAdapter) adapter;
                mSections = mSectionIndexer.getSections();
            } //End block
        } //End block
        {
            {
                mListAdapter = (BaseAdapter) adapter;
                mSectionIndexer = (SectionIndexer) adapter;
                mSections = mSectionIndexer.getSections();
                {
                    mSections = new String[] { " " };
                } //End block
            } //End block
            {
                mListAdapter = (BaseAdapter) adapter;
                mSections = new String[] { " " };
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.690 -0400", hash_original_method = "B72F5DA2B803BA6E8807DBDDDB2D9463", hash_generated_method = "3DA083163E23080BFCF30DF5DB399931")
    @DSModeled(DSC.SAFE)
    public void onSectionsChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mListAdapter = null;
        // ---------- Original Method ----------
        //mListAdapter = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.691 -0400", hash_original_method = "5A8E212F57F70A160B41013FFA05181F", hash_generated_method = "34B772FDB14CD898C10016602D8A656B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void scrollTo(float position) {
        dsTaint.addTaint(position);
        int count;
        count = mList.getCount();
        mScrollCompleted = false;
        float fThreshold;
        fThreshold = (1.0f / count) / 8;
        Object[] sections;
        sections = mSections;
        int sectionIndex;
        {
            int nSections;
            nSections = sections.length;
            int section;
            section = (int) (position * nSections);
            {
                section = nSections - 1;
            } //End block
            int exactSection;
            exactSection = section;
            sectionIndex = section;
            int index;
            index = mSectionIndexer.getPositionForSection(section);
            int nextIndex;
            nextIndex = count;
            int prevIndex;
            prevIndex = index;
            int prevSection;
            prevSection = section;
            int nextSection;
            nextSection = section + 1;
            {
                nextIndex = mSectionIndexer.getPositionForSection(section + 1);
            } //End block
            {
                {
                    prevIndex = mSectionIndexer.getPositionForSection(section);
                    {
                        prevSection = section;
                        sectionIndex = section;
                    } //End block
                    {
                        sectionIndex = 0;
                    } //End block
                } //End block
            } //End block
            int nextNextSection;
            nextNextSection = nextSection + 1;
            {
                boolean varBB2D3FB3AE20EB293998F7828EEA8D6B_208694423 = (nextNextSection < nSections &&
                    mSectionIndexer.getPositionForSection(nextNextSection) == nextIndex);
            } //End collapsed parenthetic
            float fPrev;
            fPrev = (float) prevSection / nSections;
            float fNext;
            fNext = (float) nextSection / nSections;
            {
                index = prevIndex;
            } //End block
            {
                index = prevIndex + (int) ((nextIndex - prevIndex) * (position - fPrev) 
                    / (fNext - fPrev));
            } //End block
            index = count - 1;
            {
                ExpandableListView expList;
                expList = (ExpandableListView) mList;
                expList.setSelectionFromTop(expList.getFlatListPosition(
                        ExpandableListView.getPackedPositionForGroup(index + mListOffset)), 0);
            } //End block
            {
                ((ListView)mList).setSelectionFromTop(index + mListOffset, 0);
            } //End block
            {
                mList.setSelection(index + mListOffset);
            } //End block
        } //End block
        {
            int index;
            index = (int) (position * count);
            index = count - 1;
            {
                ExpandableListView expList;
                expList = (ExpandableListView) mList;
                expList.setSelectionFromTop(expList.getFlatListPosition(
                        ExpandableListView.getPackedPositionForGroup(index + mListOffset)), 0);
            } //End block
            {
                ((ListView)mList).setSelectionFromTop(index + mListOffset, 0);
            } //End block
            {
                mList.setSelection(index + mListOffset);
            } //End block
            sectionIndex = -1;
        } //End block
        {
            String text;
            text = mSectionText = sections[sectionIndex].toString();
            mDrawOverlay = (text.length() != 1 || text.charAt(0) != ' ') &&
                    sectionIndex < sections.length;
        } //End block
        {
            mDrawOverlay = false;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.691 -0400", hash_original_method = "5B13E30A0127E5E811D3308FC0C54801", hash_generated_method = "1201803CE4FECE8985B6680A5CFB2304")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getThumbPositionForListPosition(int firstVisibleItem, int visibleItemCount,
            int totalItemCount) {
        dsTaint.addTaint(totalItemCount);
        dsTaint.addTaint(visibleItemCount);
        dsTaint.addTaint(firstVisibleItem);
        {
            getSectionsFromIndexer();
        } //End block
        {
            int var9DBC44A6EBF4F17793F4C156235B003F_1492870316 = (((mList.getHeight() - mThumbH) * firstVisibleItem)
                    / (totalItemCount - visibleItemCount));
        } //End block
        firstVisibleItem -= mListOffset;
        totalItemCount -= mListOffset;
        int trackHeight;
        trackHeight = mList.getHeight() - mThumbH;
        int section;
        section = mSectionIndexer.getSectionForPosition(firstVisibleItem);
        int sectionPos;
        sectionPos = mSectionIndexer.getPositionForSection(section);
        int nextSectionPos;
        nextSectionPos = mSectionIndexer.getPositionForSection(section + 1);
        int sectionCount;
        sectionCount = mSections.length;
        int positionsInSection;
        positionsInSection = nextSectionPos - sectionPos;
        View child;
        child = mList.getChildAt(0);
        float incrementalPos;
        incrementalPos = 0;
        incrementalPos = firstVisibleItem +
                (float) (mList.getPaddingTop() - child.getTop()) / child.getHeight();
        float posWithinSection;
        posWithinSection = (incrementalPos - sectionPos) / positionsInSection;
        int result;
        result = (int) ((section + posWithinSection) / sectionCount * trackHeight);
        {
            View lastChild;
            lastChild = mList.getChildAt(visibleItemCount - 1);
            float lastItemVisible;
            lastItemVisible = (float) (mList.getHeight() - mList.getPaddingBottom()
                    - lastChild.getTop()) / lastChild.getHeight();
            result += (trackHeight - result) * lastItemVisible;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.691 -0400", hash_original_method = "CEA01B9B754ED8848F89028F972B696F", hash_generated_method = "62A7CA02F03EB50FF40E5A304006CFEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void cancelFling() {
        MotionEvent cancelFling;
        cancelFling = MotionEvent.obtain(0, 0, MotionEvent.ACTION_CANCEL, 0, 0, 0);
        mList.onTouchEvent(cancelFling);
        cancelFling.recycle();
        // ---------- Original Method ----------
        //MotionEvent cancelFling = MotionEvent.obtain(0, 0, MotionEvent.ACTION_CANCEL, 0, 0, 0);
        //mList.onTouchEvent(cancelFling);
        //cancelFling.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.692 -0400", hash_original_method = "1BBF9FC05240D406AB082B75B38F8E40", hash_generated_method = "A17CF01D8897AFD0C2378D2D899955A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void cancelPendingDrag() {
        mList.removeCallbacks(mDeferStartDrag);
        mPendingDrag = false;
        // ---------- Original Method ----------
        //mList.removeCallbacks(mDeferStartDrag);
        //mPendingDrag = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.692 -0400", hash_original_method = "DD628BE0DD3562FCAA0807D28A9AC0F6", hash_generated_method = "43BA3AD6A490FA6251BAC1E2C528E5CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void startPendingDrag() {
        mPendingDrag = true;
        mList.postDelayed(mDeferStartDrag, PENDING_DRAG_DELAY);
        // ---------- Original Method ----------
        //mPendingDrag = true;
        //mList.postDelayed(mDeferStartDrag, PENDING_DRAG_DELAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.692 -0400", hash_original_method = "12EF9C1930DF387CC333A7C9F1E54726", hash_generated_method = "35D4DE833C677581785D47E702F2E832")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void beginDrag() {
        setState(STATE_DRAGGING);
        {
            getSectionsFromIndexer();
        } //End block
        {
            mList.requestDisallowInterceptTouchEvent(true);
            mList.reportScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
        } //End block
        cancelFling();
        // ---------- Original Method ----------
        //setState(STATE_DRAGGING);
        //if (mListAdapter == null && mList != null) {
            //getSectionsFromIndexer();
        //}
        //if (mList != null) {
            //mList.requestDisallowInterceptTouchEvent(true);
            //mList.reportScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
        //}
        //cancelFling();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.692 -0400", hash_original_method = "D950A8D9B3AA1D87B11E428662FC0A13", hash_generated_method = "5E18F3538C530D8B1C66B8138503B76A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean onInterceptTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        {
            Object var74F259241399C7FD6DED5A7AA3E7383D_1781227868 = (ev.getActionMasked());
            //Begin case MotionEvent.ACTION_DOWN 
            {
                boolean varA956E413CCC396DCDE8A419D3081CEBC_1652526188 = (mState > STATE_NONE && isPointInside(ev.getX(), ev.getY()));
                {
                    {
                        boolean var5F096BB9A8B8CA8FD2C7A33B3C25AF8F_1474967430 = (!mList.isInScrollingContainer());
                        {
                            beginDrag();
                        } //End block
                    } //End collapsed parenthetic
                    mInitialTouchY = ev.getY();
                    startPendingDrag();
                } //End block
            } //End collapsed parenthetic
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
            cancelPendingDrag();
            //End case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //switch (ev.getActionMasked()) {
            //case MotionEvent.ACTION_DOWN:
                //if (mState > STATE_NONE && isPointInside(ev.getX(), ev.getY())) {
                    //if (!mList.isInScrollingContainer()) {
                        //beginDrag();
                        //return true;
                    //}
                    //mInitialTouchY = ev.getY();
                    //startPendingDrag();
                //}
                //break;
            //case MotionEvent.ACTION_UP:
            //case MotionEvent.ACTION_CANCEL:
                //cancelPendingDrag();
                //break;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.693 -0400", hash_original_method = "891E4A8523ECAE5B8AA3233AF8AC2D21", hash_generated_method = "2015A6E08DB3787FC5197120F98E44B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean onTouchEvent(MotionEvent me) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(me.dsTaint);
        int action;
        action = me.getAction();
        {
            {
                boolean var4CB4F6C2F788DDF9D1F357233A0B0645_1403572830 = (isPointInside(me.getX(), me.getY()));
                {
                    {
                        boolean var5F096BB9A8B8CA8FD2C7A33B3C25AF8F_1834244073 = (!mList.isInScrollingContainer());
                        {
                            beginDrag();
                        } //End block
                    } //End collapsed parenthetic
                    mInitialTouchY = me.getY();
                    startPendingDrag();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                beginDrag();
                int viewHeight;
                viewHeight = mList.getHeight();
                int newThumbY;
                newThumbY = (int) me.getY() - mThumbH + 10;
                {
                    newThumbY = 0;
                } //End block
                {
                    newThumbY = viewHeight - mThumbH;
                } //End block
                mThumbY = newThumbY;
                scrollTo((float) mThumbY / (viewHeight - mThumbH));
                cancelPendingDrag();
            } //End block
            {
                {
                    mList.requestDisallowInterceptTouchEvent(false);
                    mList.reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
                } //End block
                setState(STATE_VISIBLE);
                Handler handler;
                handler = mHandler;
                handler.removeCallbacks(mScrollFade);
                {
                    handler.postDelayed(mScrollFade, 1000);
                } //End block
                mList.invalidate();
            } //End block
        } //End block
        {
            {
                float y;
                y = me.getY();
                {
                    boolean var57D155B745B41B70666C3C0DB25BDA45_2146022455 = (Math.abs(y - mInitialTouchY) > mScaledTouchSlop);
                    {
                        setState(STATE_DRAGGING);
                        {
                            getSectionsFromIndexer();
                        } //End block
                        {
                            mList.requestDisallowInterceptTouchEvent(true);
                            mList.reportScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
                        } //End block
                        cancelFling();
                        cancelPendingDrag();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                int viewHeight;
                viewHeight = mList.getHeight();
                int newThumbY;
                newThumbY = (int) me.getY() - mThumbH + 10;
                {
                    newThumbY = 0;
                } //End block
                {
                    newThumbY = viewHeight - mThumbH;
                } //End block
                {
                    boolean varF809D69832046C315D14C292FA46A81C_1278904735 = (Math.abs(mThumbY - newThumbY) < 2);
                } //End collapsed parenthetic
                mThumbY = newThumbY;
                {
                    scrollTo((float) mThumbY / (viewHeight - mThumbH));
                } //End block
            } //End block
        } //End block
        {
            cancelPendingDrag();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.694 -0400", hash_original_method = "4AFF55C64BD9939BD0E5A83378980FDE", hash_generated_method = "62D0415DB90B34369618D74EDA47D8B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isPointInside(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        boolean inTrack;
        inTrack = false;
        //Begin case default View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
        inTrack = x > mList.getWidth() - mThumbW;
        //End case default View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
        //Begin case View.SCROLLBAR_POSITION_LEFT 
        inTrack = x < mThumbW;
        //End case View.SCROLLBAR_POSITION_LEFT 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean inTrack = false;
        //switch (mPosition) {
            //default:
            //case View.SCROLLBAR_POSITION_DEFAULT:
            //case View.SCROLLBAR_POSITION_RIGHT:
                //inTrack = x > mList.getWidth() - mThumbW;
                //break;
            //case View.SCROLLBAR_POSITION_LEFT:
                //inTrack = x < mThumbW;
                //break;
        //}
        //return inTrack && (mTrackDrawable != null || y >= mThumbY && y <= mThumbY + mThumbH);
    }

    
    public class ScrollFade implements Runnable {
        long mStartTime;
        long mFadeDuration;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.694 -0400", hash_original_method = "E1B0B93D94710716744A018E47927158", hash_generated_method = "E1B0B93D94710716744A018E47927158")
                public ScrollFade ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.694 -0400", hash_original_method = "C2CB87B9E1EBFB96BF37E1CA2A1422A5", hash_generated_method = "19230DB05151B9744467D8C099CFC776")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void startFade() {
            mFadeDuration = FADE_DURATION;
            mStartTime = SystemClock.uptimeMillis();
            setState(STATE_EXIT);
            // ---------- Original Method ----------
            //mFadeDuration = FADE_DURATION;
            //mStartTime = SystemClock.uptimeMillis();
            //setState(STATE_EXIT);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.694 -0400", hash_original_method = "AFB48DA784BE880095A4465F927D06A4", hash_generated_method = "D86AC137EB55B63A4811A9B666163F03")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         int getAlpha() {
            {
                boolean var18C99A1467A5E28EFE0461A6C774AF80_795086738 = (getState() != STATE_EXIT);
            } //End collapsed parenthetic
            int alpha;
            long now;
            now = SystemClock.uptimeMillis();
            {
                alpha = 0;
            } //End block
            {
                alpha = (int) (ALPHA_MAX - ((now - mStartTime) * ALPHA_MAX) / mFadeDuration);
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (getState() != STATE_EXIT) {
                //return ALPHA_MAX;
            //}
            //int alpha;
            //long now = SystemClock.uptimeMillis();
            //if (now > mStartTime + mFadeDuration) {
                //alpha = 0;
            //} else {
                //alpha = (int) (ALPHA_MAX - ((now - mStartTime) * ALPHA_MAX) / mFadeDuration); 
            //}
            //return alpha;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.694 -0400", hash_original_method = "3A2ADC6F19B17BA5C164F36207FFFC0C", hash_generated_method = "5739AB381924467FF0BE7F4F00BC210A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            {
                boolean var18C99A1467A5E28EFE0461A6C774AF80_1435345163 = (getState() != STATE_EXIT);
                {
                    startFade();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var6703FBB521765E4D7F8ABFF437383AC8_357114093 = (getAlpha() > 0);
                {
                    mList.invalidate();
                } //End block
                {
                    setState(STATE_NONE);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (getState() != STATE_EXIT) {
                //startFade();
                //return;
            //}
            //if (getAlpha() > 0) {
                //mList.invalidate();
            //} else {
                //setState(STATE_NONE);
            //}
        }

        
        static final int ALPHA_MAX = 208;
        static final long FADE_DURATION = 200;
    }


    
    private static final String TAG = "FastScroller";
    private static int MIN_PAGES = 4;
    private static final int STATE_NONE = 0;
    private static final int STATE_ENTER = 1;
    private static final int STATE_VISIBLE = 2;
    private static final int STATE_DRAGGING = 3;
    private static final int STATE_EXIT = 4;
    private static final int[] PRESSED_STATES = new int[] {
        android.R.attr.state_pressed
    };
    private static final int[] DEFAULT_STATES = new int[0];
    private static final int[] ATTRS = new int[] {
        android.R.attr.fastScrollTextColor,
        android.R.attr.fastScrollThumbDrawable,
        android.R.attr.fastScrollTrackDrawable,
        android.R.attr.fastScrollPreviewBackgroundLeft,
        android.R.attr.fastScrollPreviewBackgroundRight,
        android.R.attr.fastScrollOverlayPosition
    };
    private static final int TEXT_COLOR = 0;
    private static final int THUMB_DRAWABLE = 1;
    private static final int TRACK_DRAWABLE = 2;
    private static final int PREVIEW_BACKGROUND_LEFT = 3;
    private static final int PREVIEW_BACKGROUND_RIGHT = 4;
    private static final int OVERLAY_POSITION = 5;
    private static final int OVERLAY_FLOATING = 0;
    private static final int OVERLAY_AT_THUMB = 1;
    private static final int FADE_TIMEOUT = 1500;
    private static final int PENDING_DRAG_DELAY = 180;
}

