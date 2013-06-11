package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.ArrayList;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.RemoteViews.RemoteView;

public class FrameLayout extends ViewGroup {
    private static final int DEFAULT_CHILD_GRAVITY = Gravity.TOP | Gravity.LEFT;
    @ViewDebug.ExportedProperty(category = "measurement")
    boolean mMeasureAllChildren = false;
    @ViewDebug.ExportedProperty(category = "drawing")
    private Drawable mForeground;
    @ViewDebug.ExportedProperty(category = "padding")
    private int mForegroundPaddingLeft = 0;
    @ViewDebug.ExportedProperty(category = "padding")
    private int mForegroundPaddingTop = 0;
    @ViewDebug.ExportedProperty(category = "padding")
    private int mForegroundPaddingRight = 0;
    @ViewDebug.ExportedProperty(category = "padding")
    private int mForegroundPaddingBottom = 0;
    private final Rect mSelfBounds = new Rect();
    private final Rect mOverlayBounds = new Rect();
    @ViewDebug.ExportedProperty(category = "drawing")
    private int mForegroundGravity = Gravity.FILL;
    @ViewDebug.ExportedProperty(category = "drawing")
    protected boolean mForegroundInPadding = true;
    boolean mForegroundBoundsChanged = false;
    private final ArrayList<View> mMatchParentChildren = new ArrayList<View>(1);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.533 -0400", hash_original_method = "C65968E2416D9A27DB8533C5F0C75B69", hash_generated_method = "A322F9F62717237F1ACB4AABB9EDA06B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FrameLayout(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.533 -0400", hash_original_method = "874EEAD1D73BF9A0D133CBC5B921EDD8", hash_generated_method = "EC2F371F1F370D219AB519220AECA0C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.534 -0400", hash_original_method = "CEC811F1E2979D1B9B78B672C02AD5D3", hash_generated_method = "C4F39EC1EDF1065C04C8D472666D55FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.FrameLayout,
                    defStyle, 0);
        mForegroundGravity = a.getInt(
                com.android.internal.R.styleable.FrameLayout_foregroundGravity, mForegroundGravity);
        final Drawable d;
        d = a.getDrawable(com.android.internal.R.styleable.FrameLayout_foreground);
        {
            setForeground(d);
        } //End block
        {
            boolean var060BD58CD70382001F4DF1DEF51F4B47_1626715183 = (a.getBoolean(com.android.internal.R.styleable.FrameLayout_measureAllChildren, false));
            {
                setMeasureAllChildren(true);
            } //End block
        } //End collapsed parenthetic
        mForegroundInPadding = a.getBoolean(
                com.android.internal.R.styleable.FrameLayout_foregroundInsidePadding, true);
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.FrameLayout,
                    //defStyle, 0);
        //mForegroundGravity = a.getInt(
                //com.android.internal.R.styleable.FrameLayout_foregroundGravity, mForegroundGravity);
        //final Drawable d = a.getDrawable(com.android.internal.R.styleable.FrameLayout_foreground);
        //if (d != null) {
            //setForeground(d);
        //}
        //if (a.getBoolean(com.android.internal.R.styleable.FrameLayout_measureAllChildren, false)) {
            //setMeasureAllChildren(true);
        //}
        //mForegroundInPadding = a.getBoolean(
                //com.android.internal.R.styleable.FrameLayout_foregroundInsidePadding, true);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.534 -0400", hash_original_method = "8BC875BA00D5710711DB00A919CACCE0", hash_generated_method = "C0F9217F06ECAFCB5D8E8389CCF8C544")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public void setForegroundGravity(int foregroundGravity) {
        dsTaint.addTaint(foregroundGravity);
        {
            {
                foregroundGravity |= Gravity.START;
            } //End block
            {
                foregroundGravity |= Gravity.TOP;
            } //End block
            {
                Rect padding;
                padding = new Rect();
                {
                    boolean varEC4E72B2B4FAF413CB9D2BD426568F5B_695591023 = (mForeground.getPadding(padding));
                    {
                        mForegroundPaddingLeft = padding.left;
                        mForegroundPaddingTop = padding.top;
                        mForegroundPaddingRight = padding.right;
                        mForegroundPaddingBottom = padding.bottom;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                mForegroundPaddingLeft = 0;
                mForegroundPaddingTop = 0;
                mForegroundPaddingRight = 0;
                mForegroundPaddingBottom = 0;
            } //End block
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.534 -0400", hash_original_method = "10BAAC6631BEDC803E3228221401304B", hash_generated_method = "4A6AAA811FC4B1AEDD7DDAFFA6B502BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean verifyDrawable(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        boolean var5DDC393BAE0536F27182E72C3FC3DFA4_1854447578 = (super.verifyDrawable(who) || (who == mForeground));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.verifyDrawable(who) || (who == mForeground);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.534 -0400", hash_original_method = "583607554001D9F198CD54104E44B797", hash_generated_method = "A3C6B9E7BEB7DD591EDA5A810D831888")
    @DSModeled(DSC.SAFE)
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        mForeground.jumpToCurrentState();
        // ---------- Original Method ----------
        //super.jumpDrawablesToCurrentState();
        //if (mForeground != null) mForeground.jumpToCurrentState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.534 -0400", hash_original_method = "D0BDA221075CF616F9E9A9FBE3F4B88A", hash_generated_method = "A79BEE609F13DECF0320D9D79A5A4B0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        {
            boolean varF047BC408D282175FD6894DD2CA5E4AA_530143301 = (mForeground != null && mForeground.isStateful());
            {
                mForeground.setState(getDrawableState());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //if (mForeground != null && mForeground.isStateful()) {
            //mForeground.setState(getDrawableState());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.534 -0400", hash_original_method = "988BCAE6A6E42EFDC25DEBC315DD1190", hash_generated_method = "E460B10AF4C79334E4B05268CA35AFA8")
    @DSModeled(DSC.SAFE)
    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.534 -0400", hash_original_method = "9754375AE3C405E0761F3FE1F1DE65D9", hash_generated_method = "03346B91B7A928B0F801F67D03D09A63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setForeground(Drawable drawable) {
        dsTaint.addTaint(drawable.dsTaint);
        {
            {
                mForeground.setCallback(null);
                unscheduleDrawable(mForeground);
            } //End block
            mForegroundPaddingLeft = 0;
            mForegroundPaddingTop = 0;
            mForegroundPaddingRight = 0;
            mForegroundPaddingBottom = 0;
            {
                setWillNotDraw(false);
                drawable.setCallback(this);
                {
                    boolean var7A233AAD91A9FC1732BFC704C20F2EC0_1311201064 = (drawable.isStateful());
                    {
                        drawable.setState(getDrawableState());
                    } //End block
                } //End collapsed parenthetic
                {
                    Rect padding;
                    padding = new Rect();
                    {
                        boolean var640F577FE90036D5B7F6C5FBC863E5E1_1491776636 = (drawable.getPadding(padding));
                        {
                            mForegroundPaddingLeft = padding.left;
                            mForegroundPaddingTop = padding.top;
                            mForegroundPaddingRight = padding.right;
                            mForegroundPaddingBottom = padding.bottom;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                setWillNotDraw(true);
            } //End block
            requestLayout();
            invalidate();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.534 -0400", hash_original_method = "8DDBBCB9F2E6942D000521EEF66C0D86", hash_generated_method = "5AE950EDC98215BB934ECB6F3D42686F")
    @DSModeled(DSC.SAFE)
    public Drawable getForeground() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mForeground;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.535 -0400", hash_original_method = "FF3A696BD56D74C1EF72BB71EC65ECEC", hash_generated_method = "F72D3C7CE77C58AC6709A4ED9AD38C6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getPaddingLeftWithForeground() {
        {
            Object var8418F173DB412201BC8297CCEF71A2D0_1000539763 = (Math.max(mPaddingLeft, mForegroundPaddingLeft));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mForegroundInPadding ? Math.max(mPaddingLeft, mForegroundPaddingLeft) :
            //mPaddingLeft + mForegroundPaddingLeft;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.535 -0400", hash_original_method = "6F38D617A9DA11062600EF5C115E1518", hash_generated_method = "D9F9802DEA45D21AC9A072C84E413CD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getPaddingRightWithForeground() {
        {
            Object varDF068A7244503D471731ABCFF3C011C6_890695859 = (Math.max(mPaddingRight, mForegroundPaddingRight));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mForegroundInPadding ? Math.max(mPaddingRight, mForegroundPaddingRight) :
            //mPaddingRight + mForegroundPaddingRight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.535 -0400", hash_original_method = "9A91E9D92D71EE5460C3A06ABC1FBD77", hash_generated_method = "F329295F4B4EF688C105BBDC89AFB9A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getPaddingTopWithForeground() {
        {
            Object varEC4D518B0257A4830CF6F1BBCA4DFEDC_275299535 = (Math.max(mPaddingTop, mForegroundPaddingTop));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mForegroundInPadding ? Math.max(mPaddingTop, mForegroundPaddingTop) :
            //mPaddingTop + mForegroundPaddingTop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.535 -0400", hash_original_method = "6BA199CF08BDB4F9A10CECB43AC6A7C1", hash_generated_method = "3A492F7903A174C877A6AA793E563BF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getPaddingBottomWithForeground() {
        {
            Object varD5F18AAE1C8F95C812828DD0D3D39BCF_2029806784 = (Math.max(mPaddingBottom, mForegroundPaddingBottom));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mForegroundInPadding ? Math.max(mPaddingBottom, mForegroundPaddingBottom) :
            //mPaddingBottom + mForegroundPaddingBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.536 -0400", hash_original_method = "5535255FB97D5EBC35FC058E1C30F774", hash_generated_method = "59C9A1634D5F11F514F2D8A67E6F439A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        int count;
        count = getChildCount();
        final boolean measureMatchParentChildren;
        measureMatchParentChildren = MeasureSpec.getMode(widthMeasureSpec) != MeasureSpec.EXACTLY ||
                MeasureSpec.getMode(heightMeasureSpec) != MeasureSpec.EXACTLY;
        mMatchParentChildren.clear();
        int maxHeight;
        maxHeight = 0;
        int maxWidth;
        maxWidth = 0;
        int childState;
        childState = 0;
        {
            int i;
            i = 0;
            {
                final View child;
                child = getChildAt(i);
                {
                    boolean var52D84F7738B8AF8E899201F04FE0F413_299547964 = (mMeasureAllChildren || child.getVisibility() != GONE);
                    {
                        measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
                        final LayoutParams lp;
                        lp = (LayoutParams) child.getLayoutParams();
                        maxWidth = Math.max(maxWidth,
                        child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin);
                        maxHeight = Math.max(maxHeight,
                        child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin);
                        childState = combineMeasuredStates(childState, child.getMeasuredState());
                        {
                            {
                                mMatchParentChildren.add(child);
                            } //End block
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        maxWidth += getPaddingLeftWithForeground() + getPaddingRightWithForeground();
        maxHeight += getPaddingTopWithForeground() + getPaddingBottomWithForeground();
        maxHeight = Math.max(maxHeight, getSuggestedMinimumHeight());
        maxWidth = Math.max(maxWidth, getSuggestedMinimumWidth());
        final Drawable drawable;
        drawable = getForeground();
        {
            maxHeight = Math.max(maxHeight, drawable.getMinimumHeight());
            maxWidth = Math.max(maxWidth, drawable.getMinimumWidth());
        } //End block
        setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, childState),
                resolveSizeAndState(maxHeight, heightMeasureSpec,
                        childState << MEASURED_HEIGHT_STATE_SHIFT));
        count = mMatchParentChildren.size();
        {
            {
                int i;
                i = 0;
                {
                    final View child;
                    child = mMatchParentChildren.get(i);
                    final MarginLayoutParams lp;
                    lp = (MarginLayoutParams) child.getLayoutParams();
                    int childWidthMeasureSpec;
                    int childHeightMeasureSpec;
                    {
                        childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth() -
                            getPaddingLeftWithForeground() - getPaddingRightWithForeground() -
                            lp.leftMargin - lp.rightMargin,
                            MeasureSpec.EXACTLY);
                    } //End block
                    {
                        childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec,
                            getPaddingLeftWithForeground() + getPaddingRightWithForeground() +
                            lp.leftMargin + lp.rightMargin,
                            lp.width);
                    } //End block
                    {
                        childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight() -
                            getPaddingTopWithForeground() - getPaddingBottomWithForeground() -
                            lp.topMargin - lp.bottomMargin,
                            MeasureSpec.EXACTLY);
                    } //End block
                    {
                        childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec,
                            getPaddingTopWithForeground() + getPaddingBottomWithForeground() +
                            lp.topMargin + lp.bottomMargin,
                            lp.height);
                    } //End block
                    child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.536 -0400", hash_original_method = "E7FA69BF1895927226A22DFF32FA5B4F", hash_generated_method = "6D8DE6218446532E3F0DFF9A723E1C4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(changed);
        dsTaint.addTaint(top);
        final int count;
        count = getChildCount();
        final int parentLeft;
        parentLeft = getPaddingLeftWithForeground();
        final int parentRight;
        parentRight = right - left - getPaddingRightWithForeground();
        final int parentTop;
        parentTop = getPaddingTopWithForeground();
        final int parentBottom;
        parentBottom = bottom - top - getPaddingBottomWithForeground();
        mForegroundBoundsChanged = true;
        {
            int i;
            i = 0;
            {
                final View child;
                child = getChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_806382740 = (child.getVisibility() != GONE);
                    {
                        final LayoutParams lp;
                        lp = (LayoutParams) child.getLayoutParams();
                        final int width;
                        width = child.getMeasuredWidth();
                        final int height;
                        height = child.getMeasuredHeight();
                        int childLeft;
                        int childTop;
                        int gravity;
                        gravity = lp.gravity;
                        {
                            gravity = DEFAULT_CHILD_GRAVITY;
                        } //End block
                        final int layoutDirection;
                        layoutDirection = getResolvedLayoutDirection();
                        final int absoluteGravity;
                        absoluteGravity = Gravity.getAbsoluteGravity(gravity, layoutDirection);
                        final int verticalGravity;
                        verticalGravity = gravity & Gravity.VERTICAL_GRAVITY_MASK;
                        //Begin case Gravity.LEFT 
                        childLeft = parentLeft + lp.leftMargin;
                        //End case Gravity.LEFT 
                        //Begin case Gravity.CENTER_HORIZONTAL 
                        childLeft = parentLeft + (parentRight - parentLeft - width) / 2 +
                        lp.leftMargin - lp.rightMargin;
                        //End case Gravity.CENTER_HORIZONTAL 
                        //Begin case Gravity.RIGHT 
                        childLeft = parentRight - width - lp.rightMargin;
                        //End case Gravity.RIGHT 
                        //Begin case default 
                        childLeft = parentLeft + lp.leftMargin;
                        //End case default 
                        //Begin case Gravity.TOP 
                        childTop = parentTop + lp.topMargin;
                        //End case Gravity.TOP 
                        //Begin case Gravity.CENTER_VERTICAL 
                        childTop = parentTop + (parentBottom - parentTop - height) / 2 +
                        lp.topMargin - lp.bottomMargin;
                        //End case Gravity.CENTER_VERTICAL 
                        //Begin case Gravity.BOTTOM 
                        childTop = parentBottom - height - lp.bottomMargin;
                        //End case Gravity.BOTTOM 
                        //Begin case default 
                        childTop = parentTop + lp.topMargin;
                        //End case default 
                        child.layout(childLeft, childTop, childLeft + width, childTop + height);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.536 -0400", hash_original_method = "4AC6B20E904606B8A51AEBBB15006C72", hash_generated_method = "E41E5E8E5B2EA18C257A14E72C13A5F4")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(w);
        dsTaint.addTaint(oldw);
        dsTaint.addTaint(oldh);
        dsTaint.addTaint(h);
        super.onSizeChanged(w, h, oldw, oldh);
        mForegroundBoundsChanged = true;
        // ---------- Original Method ----------
        //super.onSizeChanged(w, h, oldw, oldh);
        //mForegroundBoundsChanged = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.537 -0400", hash_original_method = "6D753914B55367AEDC866ACE8B2692D8", hash_generated_method = "5192E8FA5278B06C63F3292DACA1CACC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        super.draw(canvas);
        {
            final Drawable foreground;
            foreground = mForeground;
            {
                mForegroundBoundsChanged = false;
                final Rect selfBounds;
                selfBounds = mSelfBounds;
                final Rect overlayBounds;
                overlayBounds = mOverlayBounds;
                final int w;
                w = mRight-mLeft;
                final int h;
                h = mBottom-mTop;
                {
                    selfBounds.set(0, 0, w, h);
                } //End block
                {
                    selfBounds.set(mPaddingLeft, mPaddingTop, w - mPaddingRight, h - mPaddingBottom);
                } //End block
                final int layoutDirection;
                layoutDirection = getResolvedLayoutDirection();
                Gravity.apply(mForegroundGravity, foreground.getIntrinsicWidth(),
                        foreground.getIntrinsicHeight(), selfBounds, overlayBounds,
                        layoutDirection);
                foreground.setBounds(overlayBounds);
            } //End block
            foreground.draw(canvas);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.537 -0400", hash_original_method = "89E57DF442BD7C3C4F7FCB93934115A6", hash_generated_method = "158FE14FA186AB72B084B1CDC0FC4BD6")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean gatherTransparentRegion(Region region) {
        dsTaint.addTaint(region.dsTaint);
        boolean opaque;
        opaque = super.gatherTransparentRegion(region);
        {
            applyDrawableToTransparentRegion(mForeground, region);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean opaque = super.gatherTransparentRegion(region);
        //if (region != null && mForeground != null) {
            //applyDrawableToTransparentRegion(mForeground, region);
        //}
        //return opaque;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.537 -0400", hash_original_method = "F157652BCC07DCD3C1A1E63F95BA7504", hash_generated_method = "9A85A57D0141033559DE2A9CDB1EC515")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setMeasureAllChildren(boolean measureAll) {
        dsTaint.addTaint(measureAll);
        // ---------- Original Method ----------
        //mMeasureAllChildren = measureAll;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.537 -0400", hash_original_method = "E2FDB5CCBB08727222AD77E37CF74AF8", hash_generated_method = "116195ED06BF586994EB439856288943")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean getConsiderGoneChildrenWhenMeasuring() {
        boolean var9F57B6D4A5A1C146ADB9D4B74E243376_391869466 = (getMeasureAllChildren());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getMeasureAllChildren();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.537 -0400", hash_original_method = "52ECFF8459DAA24A15017A3D3C6FE0BF", hash_generated_method = "4DF85E2F3AF5ECBB96F7B02A37099942")
    @DSModeled(DSC.SAFE)
    public boolean getMeasureAllChildren() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mMeasureAllChildren;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.537 -0400", hash_original_method = "A40DD32EC45E4EF4D9BB874732A909D0", hash_generated_method = "C4226C74C861ACBB6C854E6761DF21CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        LayoutParams var65F932752F70D2B8EE875E34B10EE93F_1298060882 = (new FrameLayout.LayoutParams(getContext(), attrs));
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new FrameLayout.LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.537 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "1239C6C76A60BF63BE5F6B305C415611")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean shouldDelayChildPressedState() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.537 -0400", hash_original_method = "E5E3FCBA546B7CFE2F525BEFE910A396", hash_generated_method = "C77E7F6AA46AE234AD2714622128D283")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return p instanceof LayoutParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.537 -0400", hash_original_method = "B595E0482905B38051CD63239BB5F8BA", hash_generated_method = "29644007F7CFEED57C9F56BE3742304B")
    @DSModeled(DSC.SAFE)
    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        return (ViewGroup.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LayoutParams(p);
    }

    
    public static class LayoutParams extends MarginLayoutParams {
        public int gravity = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.537 -0400", hash_original_method = "8477494D7C126F8EB5E8F09916E06813", hash_generated_method = "EB2EE49C4B59DE58F1C1EEAEE5FC9850")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            dsTaint.addTaint(c.dsTaint);
            dsTaint.addTaint(attrs.dsTaint);
            TypedArray a;
            a = c.obtainStyledAttributes(attrs, com.android.internal.R.styleable.FrameLayout_Layout);
            gravity = a.getInt(com.android.internal.R.styleable.FrameLayout_Layout_layout_gravity, -1);
            a.recycle();
            // ---------- Original Method ----------
            //TypedArray a = c.obtainStyledAttributes(attrs, com.android.internal.R.styleable.FrameLayout_Layout);
            //gravity = a.getInt(com.android.internal.R.styleable.FrameLayout_Layout_layout_gravity, -1);
            //a.recycle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.537 -0400", hash_original_method = "B179862558DB9232A546423CE2E9C45B", hash_generated_method = "22D5D1595758A01FFF9BAF1C2C6C1819")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(int width, int height) {
            super(width, height);
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.537 -0400", hash_original_method = "DAE5F643078D3DA273ACC6BEF5E44EF2", hash_generated_method = "8234EE5A67690B1367ADD7B55C8976E1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(int width, int height, int gravity) {
            super(width, height);
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            dsTaint.addTaint(gravity);
            // ---------- Original Method ----------
            //this.gravity = gravity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.537 -0400", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "56865DF2AAA17BD60F7856200319F1B6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            dsTaint.addTaint(source.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.537 -0400", hash_original_method = "600A366FF17B7D40DFA738E77A628E8F", hash_generated_method = "5EA9C52E234CE7134779B1629A95F683")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
            dsTaint.addTaint(source.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
}


