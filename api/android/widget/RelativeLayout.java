package android.widget;

// Droidsafe Imports
import static android.util.Log.d;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Pool;
import android.util.Poolable;
import android.util.PoolableManager;
import android.util.Pools;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

import com.android.internal.R;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class RelativeLayout extends ViewGroup {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.495 -0400", hash_original_field = "824472FBDC9B8A7A1D14D0F19A7337AC", hash_generated_field = "C96F9BEAD28A0E01882C41D253AFA846")

    private View mBaselineView = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.495 -0400", hash_original_field = "94742DBD28E405550AB4998957C8C366", hash_generated_field = "6D2C0346DC0DDE3AEF5B4E55639F7BAB")

    private boolean mHasBaselineAlignedChild;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.495 -0400", hash_original_field = "5E1F1BFDB472CA8E7B81A98A346283DF", hash_generated_field = "0B3CD20786EC1640C99D342CF17DE4BB")

    private int mGravity = Gravity.LEFT | Gravity.TOP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.495 -0400", hash_original_field = "073BD2EBDB44B18FFCD2BC32B3DA1E9F", hash_generated_field = "24DC767A3ADC7BC83961E5A62989B517")

    private final Rect mContentBounds = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.495 -0400", hash_original_field = "19D950E97D0D17ED8E5107FA45A5A3B0", hash_generated_field = "3B16C2D681BFC370000C0D459ADC9C55")

    private final Rect mSelfBounds = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.495 -0400", hash_original_field = "FB105EBFDC13B6E222D9A92A87D9D55D", hash_generated_field = "40144C1646BB169CEE55D007B33717AC")

    private int mIgnoreGravity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.495 -0400", hash_original_field = "774E2842298F46AC1B9526CC91732103", hash_generated_field = "681342FA517F01301240A0DCB6966955")

    private SortedSet<View> mTopToBottomLeftToRightSet = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.495 -0400", hash_original_field = "C82377679ED9B96074D2EE30653ACBD8", hash_generated_field = "0C8E33895AC589A2FF55DFCBCE389221")

    private boolean mDirtyHierarchy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.495 -0400", hash_original_field = "0C827560E628733CEDD556735281B077", hash_generated_field = "224DF440DDF6B166B3D2E241F0F3F984")

    private View[] mSortedHorizontalChildren = new View[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.496 -0400", hash_original_field = "17A81D5CE0684E58A6D2CA78E6962AAC", hash_generated_field = "AB00FD5297C1C0ADA708BCFC1E36BC84")

    private View[] mSortedVerticalChildren = new View[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.496 -0400", hash_original_field = "A57E30F91BD1BFAA0A6B76A46793D1F6", hash_generated_field = "A2A346771E3A79053A739D0A482EAA8C")

    private final DependencyGraph mGraph = new DependencyGraph();
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.496 -0400", hash_original_method = "88251BE26FFBF8D7F97872F9366B970C", hash_generated_method = "16DDCC589E6274662D70770ADB01F95C")
    public  RelativeLayout(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.496 -0400", hash_original_method = "9502583C8FA8687465E0A06E15614A2F", hash_generated_method = "8D8CBE71CC46655CBA1F337C26EE79E6")
    public  RelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        initFromAttributes(context, attrs);
        // ---------- Original Method ----------
        //initFromAttributes(context, attrs);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.496 -0400", hash_original_method = "4BEC7267CBAB87A927F52EE3092CF249", hash_generated_method = "22AEB27313C5E39553EFDFD1B2CD99EF")
    public  RelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        initFromAttributes(context, attrs);
        // ---------- Original Method ----------
        //initFromAttributes(context, attrs);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.497 -0400", hash_original_method = "2508EFC88C6F20ACAB1B8BFE22290A1F", hash_generated_method = "18773DCC3CD65F2AB9267E9D4FB35E51")
    private void initFromAttributes(Context context, AttributeSet attrs) {
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RelativeLayout);
        mIgnoreGravity = a.getResourceId(R.styleable.RelativeLayout_ignoreGravity, View.NO_ID);
        mGravity = a.getInt(R.styleable.RelativeLayout_gravity, mGravity);
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RelativeLayout);
        //mIgnoreGravity = a.getResourceId(R.styleable.RelativeLayout_ignoreGravity, View.NO_ID);
        //mGravity = a.getInt(R.styleable.RelativeLayout_gravity, mGravity);
        //a.recycle();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.497 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "C8A69B9B2307C49DE981FA6800A316CB")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean var68934A3E9455FA72420237EB05902327_137831837 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1482990715 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1482990715;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.497 -0400", hash_original_method = "4B00B99E3D4A35B389EB4D3ED9BF824A", hash_generated_method = "2B6D5ACAF56866BE8DAC45848378F798")
    @android.view.RemotableViewMethod
    public void setIgnoreGravity(int viewId) {
        mIgnoreGravity = viewId;
        // ---------- Original Method ----------
        //mIgnoreGravity = viewId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.498 -0400", hash_original_method = "DC8D5E1211DE0926B9DDA2FADCED75EE", hash_generated_method = "9EC9CC9B5D5ABE7E2CDC34C12B8C039E")
    @android.view.RemotableViewMethod
    public void setGravity(int gravity) {
        if(mGravity != gravity)        
        {
            if((gravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 0)            
            {
                gravity |= Gravity.START;
            } //End block
            if((gravity & Gravity.VERTICAL_GRAVITY_MASK) == 0)            
            {
                gravity |= Gravity.TOP;
            } //End block
            mGravity = gravity;
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (mGravity != gravity) {
            //if ((gravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 0) {
                //gravity |= Gravity.START;
            //}
            //if ((gravity & Gravity.VERTICAL_GRAVITY_MASK) == 0) {
                //gravity |= Gravity.TOP;
            //}
            //mGravity = gravity;
            //requestLayout();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.499 -0400", hash_original_method = "076C59065FCBD07F7CAA4FFA6D12CC3A", hash_generated_method = "A03836F2AB6748AC9B219828C5EEA77B")
    @android.view.RemotableViewMethod
    public void setHorizontalGravity(int horizontalGravity) {
        addTaint(horizontalGravity);
        final int gravity = horizontalGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if((mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) != gravity)        
        {
            mGravity = (mGravity & ~Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) | gravity;
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //final int gravity = horizontalGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        //if ((mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) != gravity) {
            //mGravity = (mGravity & ~Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) | gravity;
            //requestLayout();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.499 -0400", hash_original_method = "EE245B70888F9F1582A126D948173E64", hash_generated_method = "E89CA8A9E7442430CE8604395B3DB0DE")
    @android.view.RemotableViewMethod
    public void setVerticalGravity(int verticalGravity) {
        addTaint(verticalGravity);
        final int gravity = verticalGravity & Gravity.VERTICAL_GRAVITY_MASK;
        if((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != gravity)        
        {
            mGravity = (mGravity & ~Gravity.VERTICAL_GRAVITY_MASK) | gravity;
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //final int gravity = verticalGravity & Gravity.VERTICAL_GRAVITY_MASK;
        //if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != gravity) {
            //mGravity = (mGravity & ~Gravity.VERTICAL_GRAVITY_MASK) | gravity;
            //requestLayout();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.499 -0400", hash_original_method = "73585EFBB2973430E05667E2654BAD3F", hash_generated_method = "A4EA1BD5D955863D0E82869F9DF07484")
    @Override
    public int getBaseline() {
        int var0D37D647B8BFB516A3C7BB5F06B87282_565088560 = (mBaselineView != null ? mBaselineView.getBaseline() : super.getBaseline());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2105859926 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2105859926;
        // ---------- Original Method ----------
        //return mBaselineView != null ? mBaselineView.getBaseline() : super.getBaseline();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.500 -0400", hash_original_method = "D40C3344998DDA8004351F538E92F8E3", hash_generated_method = "D2AF17735BD8ABFA2FCAA161F6376D90")
    @Override
    public void requestLayout() {
        super.requestLayout();
        mDirtyHierarchy = true;
        // ---------- Original Method ----------
        //super.requestLayout();
        //mDirtyHierarchy = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.500 -0400", hash_original_method = "701273CD7B3C60F684ABCCF0BE7DD8A5", hash_generated_method = "8659C69625F6F3B717B7A04B2B942BE4")
    private void sortChildren() {
        int count = getChildCount();
        if(mSortedVerticalChildren.length != count)        
        mSortedVerticalChildren = new View[count];
        if(mSortedHorizontalChildren.length != count)        
        mSortedHorizontalChildren = new View[count];
        final DependencyGraph graph = mGraph;
        graph.clear();
for(int i = 0;i < count;i++)
        {
            final View child = getChildAt(i);
            graph.add(child);
        } //End block
        if(DEBUG_GRAPH)        
        {
            d(LOG_TAG, "=== Sorted vertical children");
            graph.log(getResources(), ABOVE, BELOW, ALIGN_BASELINE, ALIGN_TOP, ALIGN_BOTTOM);
            d(LOG_TAG, "=== Sorted horizontal children");
            graph.log(getResources(), LEFT_OF, RIGHT_OF, ALIGN_LEFT, ALIGN_RIGHT);
        } //End block
        graph.getSortedViews(mSortedVerticalChildren, ABOVE, BELOW, ALIGN_BASELINE,
                ALIGN_TOP, ALIGN_BOTTOM);
        graph.getSortedViews(mSortedHorizontalChildren, LEFT_OF, RIGHT_OF, ALIGN_LEFT, ALIGN_RIGHT);
        if(DEBUG_GRAPH)        
        {
            d(LOG_TAG, "=== Ordered list of vertical children");
for(View view : mSortedVerticalChildren)
            {
                DependencyGraph.printViewId(getResources(), view);
            } //End block
            d(LOG_TAG, "=== Ordered list of horizontal children");
for(View view : mSortedHorizontalChildren)
            {
                DependencyGraph.printViewId(getResources(), view);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.506 -0400", hash_original_method = "E2AF18A4E301BF9A8D0B175790671ACC", hash_generated_method = "BDEDAD25BEA0644821B0E6BC1C296147")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        if(mDirtyHierarchy)        
        {
            mDirtyHierarchy = false;
            sortChildren();
        } //End block
        int myWidth = -1;
        int myHeight = -1;
        int width = 0;
        int height = 0;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if(widthMode != MeasureSpec.UNSPECIFIED)        
        {
            myWidth = widthSize;
        } //End block
        if(heightMode != MeasureSpec.UNSPECIFIED)        
        {
            myHeight = heightSize;
        } //End block
        if(widthMode == MeasureSpec.EXACTLY)        
        {
            width = myWidth;
        } //End block
        if(heightMode == MeasureSpec.EXACTLY)        
        {
            height = myHeight;
        } //End block
        mHasBaselineAlignedChild = false;
        View ignore = null;
        int gravity = mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        final boolean horizontalGravity = gravity != Gravity.LEFT && gravity != 0;
        gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        final boolean verticalGravity = gravity != Gravity.TOP && gravity != 0;
        int left = Integer.MAX_VALUE;
        int top = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int bottom = Integer.MIN_VALUE;
        boolean offsetHorizontalAxis = false;
        boolean offsetVerticalAxis = false;
        if((horizontalGravity || verticalGravity) && mIgnoreGravity != View.NO_ID)        
        {
            ignore = findViewById(mIgnoreGravity);
        } //End block
        final boolean isWrapContentWidth = widthMode != MeasureSpec.EXACTLY;
        final boolean isWrapContentHeight = heightMode != MeasureSpec.EXACTLY;
        View[] views = mSortedHorizontalChildren;
        int count = views.length;
for(int i = 0;i < count;i++)
        {
            View child = views[i];
            if(child.getVisibility() != GONE)            
            {
                LayoutParams params = (LayoutParams) child.getLayoutParams();
                applyHorizontalSizeRules(params, myWidth);
                measureChildHorizontal(child, params, myWidth, myHeight);
                if(positionChildHorizontal(child, params, myWidth, isWrapContentWidth))                
                {
                    offsetHorizontalAxis = true;
                } //End block
            } //End block
        } //End block
        views = mSortedVerticalChildren;
        count = views.length;
for(int i = 0;i < count;i++)
        {
            View child = views[i];
            if(child.getVisibility() != GONE)            
            {
                LayoutParams params = (LayoutParams) child.getLayoutParams();
                applyVerticalSizeRules(params, myHeight);
                measureChild(child, params, myWidth, myHeight);
                if(positionChildVertical(child, params, myHeight, isWrapContentHeight))                
                {
                    offsetVerticalAxis = true;
                } //End block
                if(isWrapContentWidth)                
                {
                    width = Math.max(width, params.mRight);
                } //End block
                if(isWrapContentHeight)                
                {
                    height = Math.max(height, params.mBottom);
                } //End block
                if(child != ignore || verticalGravity)                
                {
                    left = Math.min(left, params.mLeft - params.leftMargin);
                    top = Math.min(top, params.mTop - params.topMargin);
                } //End block
                if(child != ignore || horizontalGravity)                
                {
                    right = Math.max(right, params.mRight + params.rightMargin);
                    bottom = Math.max(bottom, params.mBottom + params.bottomMargin);
                } //End block
            } //End block
        } //End block
        if(mHasBaselineAlignedChild)        
        {
for(int i = 0;i < count;i++)
            {
                View child = getChildAt(i);
                if(child.getVisibility() != GONE)                
                {
                    LayoutParams params = (LayoutParams) child.getLayoutParams();
                    alignBaseline(child, params);
                    if(child != ignore || verticalGravity)                    
                    {
                        left = Math.min(left, params.mLeft - params.leftMargin);
                        top = Math.min(top, params.mTop - params.topMargin);
                    } //End block
                    if(child != ignore || horizontalGravity)                    
                    {
                        right = Math.max(right, params.mRight + params.rightMargin);
                        bottom = Math.max(bottom, params.mBottom + params.bottomMargin);
                    } //End block
                } //End block
            } //End block
        } //End block
        if(isWrapContentWidth)        
        {
            width += mPaddingRight;
            if(mLayoutParams.width >= 0)            
            {
                width = Math.max(width, mLayoutParams.width);
            } //End block
            width = Math.max(width, getSuggestedMinimumWidth());
            width = resolveSize(width, widthMeasureSpec);
            if(offsetHorizontalAxis)            
            {
for(int i = 0;i < count;i++)
                {
                    View child = getChildAt(i);
                    if(child.getVisibility() != GONE)                    
                    {
                        LayoutParams params = (LayoutParams) child.getLayoutParams();
                        final int[] rules = params.getRules();
                        if(rules[CENTER_IN_PARENT] != 0 || rules[CENTER_HORIZONTAL] != 0)                        
                        {
                            centerHorizontal(child, params, width);
                        } //End block
                        else
                        if(rules[ALIGN_PARENT_RIGHT] != 0)                        
                        {
                            final int childWidth = child.getMeasuredWidth();
                            params.mLeft = width - mPaddingRight - childWidth;
                            params.mRight = params.mLeft + childWidth;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        if(isWrapContentHeight)        
        {
            height += mPaddingBottom;
            if(mLayoutParams.height >= 0)            
            {
                height = Math.max(height, mLayoutParams.height);
            } //End block
            height = Math.max(height, getSuggestedMinimumHeight());
            height = resolveSize(height, heightMeasureSpec);
            if(offsetVerticalAxis)            
            {
for(int i = 0;i < count;i++)
                {
                    View child = getChildAt(i);
                    if(child.getVisibility() != GONE)                    
                    {
                        LayoutParams params = (LayoutParams) child.getLayoutParams();
                        final int[] rules = params.getRules();
                        if(rules[CENTER_IN_PARENT] != 0 || rules[CENTER_VERTICAL] != 0)                        
                        {
                            centerVertical(child, params, height);
                        } //End block
                        else
                        if(rules[ALIGN_PARENT_BOTTOM] != 0)                        
                        {
                            final int childHeight = child.getMeasuredHeight();
                            params.mTop = height - mPaddingBottom - childHeight;
                            params.mBottom = params.mTop + childHeight;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        if(horizontalGravity || verticalGravity)        
        {
            final Rect selfBounds = mSelfBounds;
            selfBounds.set(mPaddingLeft, mPaddingTop, width - mPaddingRight,
                    height - mPaddingBottom);
            final Rect contentBounds = mContentBounds;
            final int layoutDirection = getResolvedLayoutDirection();
            Gravity.apply(mGravity, right - left, bottom - top, selfBounds, contentBounds,
                    layoutDirection);
            final int horizontalOffset = contentBounds.left - left;
            final int verticalOffset = contentBounds.top - top;
            if(horizontalOffset != 0 || verticalOffset != 0)            
            {
for(int i = 0;i < count;i++)
                {
                    View child = getChildAt(i);
                    if(child.getVisibility() != GONE && child != ignore)                    
                    {
                        LayoutParams params = (LayoutParams) child.getLayoutParams();
                        if(horizontalGravity)                        
                        {
                            params.mLeft += horizontalOffset;
                            params.mRight += horizontalOffset;
                        } //End block
                        if(verticalGravity)                        
                        {
                            params.mTop += verticalOffset;
                            params.mBottom += verticalOffset;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        setMeasuredDimension(width, height);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.509 -0400", hash_original_method = "572E26DE16208C5960AF0F468C9CEB6F", hash_generated_method = "E602CC6E7398BCFC60490F9549029B62")
    private void alignBaseline(View child, LayoutParams params) {
        addTaint(params.getTaint());
        int[] rules = params.getRules();
        int anchorBaseline = getRelatedViewBaseline(rules, ALIGN_BASELINE);
        if(anchorBaseline != -1)        
        {
            LayoutParams anchorParams = getRelatedViewParams(rules, ALIGN_BASELINE);
            if(anchorParams != null)            
            {
                int offset = anchorParams.mTop + anchorBaseline;
                int baseline = child.getBaseline();
                if(baseline != -1)                
                {
                    offset -= baseline;
                } //End block
                int height = params.mBottom - params.mTop;
                params.mTop = offset;
                params.mBottom = params.mTop + height;
            } //End block
        } //End block
        if(mBaselineView == null)        
        {
            mBaselineView = child;
        } //End block
        else
        {
            LayoutParams lp = (LayoutParams) mBaselineView.getLayoutParams();
            if(params.mTop < lp.mTop || (params.mTop == lp.mTop && params.mLeft < lp.mLeft))            
            {
                mBaselineView = child;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.509 -0400", hash_original_method = "6FAB1FA940C67F7A3A04C20DF403CDD7", hash_generated_method = "B56AEFCE4745206457591A7DDA5BDE0F")
    private void measureChild(View child, LayoutParams params, int myWidth, int myHeight) {
        addTaint(myHeight);
        addTaint(myWidth);
        addTaint(params.getTaint());
        addTaint(child.getTaint());
        int childWidthMeasureSpec = getChildMeasureSpec(params.mLeft,
                params.mRight, params.width,
                params.leftMargin, params.rightMargin,
                mPaddingLeft, mPaddingRight,
                myWidth);
        int childHeightMeasureSpec = getChildMeasureSpec(params.mTop,
                params.mBottom, params.height,
                params.topMargin, params.bottomMargin,
                mPaddingTop, mPaddingBottom,
                myHeight);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        // ---------- Original Method ----------
        //int childWidthMeasureSpec = getChildMeasureSpec(params.mLeft,
                //params.mRight, params.width,
                //params.leftMargin, params.rightMargin,
                //mPaddingLeft, mPaddingRight,
                //myWidth);
        //int childHeightMeasureSpec = getChildMeasureSpec(params.mTop,
                //params.mBottom, params.height,
                //params.topMargin, params.bottomMargin,
                //mPaddingTop, mPaddingBottom,
                //myHeight);
        //child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.510 -0400", hash_original_method = "C649DEFF309C12811323B81F575C7972", hash_generated_method = "24E132E767F7297960A0B4D954546A46")
    private void measureChildHorizontal(View child, LayoutParams params, int myWidth, int myHeight) {
        addTaint(myHeight);
        addTaint(myWidth);
        addTaint(params.getTaint());
        addTaint(child.getTaint());
        int childWidthMeasureSpec = getChildMeasureSpec(params.mLeft,
                params.mRight, params.width,
                params.leftMargin, params.rightMargin,
                mPaddingLeft, mPaddingRight,
                myWidth);
        int childHeightMeasureSpec;
        if(params.width == LayoutParams.MATCH_PARENT)        
        {
            childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(myHeight, MeasureSpec.EXACTLY);
        } //End block
        else
        {
            childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(myHeight, MeasureSpec.AT_MOST);
        } //End block
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        // ---------- Original Method ----------
        //int childWidthMeasureSpec = getChildMeasureSpec(params.mLeft,
                //params.mRight, params.width,
                //params.leftMargin, params.rightMargin,
                //mPaddingLeft, mPaddingRight,
                //myWidth);
        //int childHeightMeasureSpec;
        //if (params.width == LayoutParams.MATCH_PARENT) {
            //childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(myHeight, MeasureSpec.EXACTLY);
        //} else {
            //childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(myHeight, MeasureSpec.AT_MOST);
        //}
        //child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.512 -0400", hash_original_method = "78354A3A0D2C9A2AC648B99E7333EDDC", hash_generated_method = "17E0A87B0753FD17262D0B0307741C4B")
    private int getChildMeasureSpec(int childStart, int childEnd,
            int childSize, int startMargin, int endMargin, int startPadding,
            int endPadding, int mySize) {
        addTaint(mySize);
        addTaint(endPadding);
        addTaint(startPadding);
        addTaint(endMargin);
        addTaint(startMargin);
        addTaint(childSize);
        addTaint(childEnd);
        addTaint(childStart);
        int childSpecMode = 0;
        int childSpecSize = 0;
        int tempStart = childStart;
        int tempEnd = childEnd;
        if(tempStart < 0)        
        {
            tempStart = startPadding + startMargin;
        } //End block
        if(tempEnd < 0)        
        {
            tempEnd = mySize - endPadding - endMargin;
        } //End block
        int maxAvailable = tempEnd - tempStart;
        if(childStart >= 0 && childEnd >= 0)        
        {
            childSpecMode = MeasureSpec.EXACTLY;
            childSpecSize = maxAvailable;
        } //End block
        else
        {
            if(childSize >= 0)            
            {
                childSpecMode = MeasureSpec.EXACTLY;
                if(maxAvailable >= 0)                
                {
                    childSpecSize = Math.min(maxAvailable, childSize);
                } //End block
                else
                {
                    childSpecSize = childSize;
                } //End block
            } //End block
            else
            if(childSize == LayoutParams.MATCH_PARENT)            
            {
                childSpecMode = MeasureSpec.EXACTLY;
                childSpecSize = maxAvailable;
            } //End block
            else
            if(childSize == LayoutParams.WRAP_CONTENT)            
            {
                if(maxAvailable >= 0)                
                {
                    childSpecMode = MeasureSpec.AT_MOST;
                    childSpecSize = maxAvailable;
                } //End block
                else
                {
                    childSpecMode = MeasureSpec.UNSPECIFIED;
                    childSpecSize = 0;
                } //End block
            } //End block
        } //End block
        int var841D81673E63494EF88D4D328E538547_1140651460 = (MeasureSpec.makeMeasureSpec(childSpecSize, childSpecMode));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1756424068 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1756424068;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.515 -0400", hash_original_method = "B9478380B54B111B46A13309CA4FBB39", hash_generated_method = "0B10A4E9DF0C24B591F2E0735F93520E")
    private boolean positionChildHorizontal(View child, LayoutParams params, int myWidth,
            boolean wrapContent) {
        addTaint(wrapContent);
        addTaint(myWidth);
        addTaint(params.getTaint());
        addTaint(child.getTaint());
        int[] rules = params.getRules();
        if(params.mLeft < 0 && params.mRight >= 0)        
        {
            params.mLeft = params.mRight - child.getMeasuredWidth();
        } //End block
        else
        if(params.mLeft >= 0 && params.mRight < 0)        
        {
            params.mRight = params.mLeft + child.getMeasuredWidth();
        } //End block
        else
        if(params.mLeft < 0 && params.mRight < 0)        
        {
            if(rules[CENTER_IN_PARENT] != 0 || rules[CENTER_HORIZONTAL] != 0)            
            {
                if(!wrapContent)                
                {
                    centerHorizontal(child, params, myWidth);
                } //End block
                else
                {
                    params.mLeft = mPaddingLeft + params.leftMargin;
                    params.mRight = params.mLeft + child.getMeasuredWidth();
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_1825675342 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1295440198 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1295440198;
            } //End block
            else
            {
                params.mLeft = mPaddingLeft + params.leftMargin;
                params.mRight = params.mLeft + child.getMeasuredWidth();
            } //End block
        } //End block
        boolean varB673573F0221FD08A4A6A5EAF380DAD9_377711562 = (rules[ALIGN_PARENT_RIGHT] != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1627721102 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1627721102;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.516 -0400", hash_original_method = "09EB493CF05E8E659EC89F37304CD399", hash_generated_method = "5BDD4EF875801A22A50B0734E2C49DAF")
    private boolean positionChildVertical(View child, LayoutParams params, int myHeight,
            boolean wrapContent) {
        addTaint(wrapContent);
        addTaint(myHeight);
        addTaint(params.getTaint());
        addTaint(child.getTaint());
        int[] rules = params.getRules();
        if(params.mTop < 0 && params.mBottom >= 0)        
        {
            params.mTop = params.mBottom - child.getMeasuredHeight();
        } //End block
        else
        if(params.mTop >= 0 && params.mBottom < 0)        
        {
            params.mBottom = params.mTop + child.getMeasuredHeight();
        } //End block
        else
        if(params.mTop < 0 && params.mBottom < 0)        
        {
            if(rules[CENTER_IN_PARENT] != 0 || rules[CENTER_VERTICAL] != 0)            
            {
                if(!wrapContent)                
                {
                    centerVertical(child, params, myHeight);
                } //End block
                else
                {
                    params.mTop = mPaddingTop + params.topMargin;
                    params.mBottom = params.mTop + child.getMeasuredHeight();
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_789683141 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1776606473 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1776606473;
            } //End block
            else
            {
                params.mTop = mPaddingTop + params.topMargin;
                params.mBottom = params.mTop + child.getMeasuredHeight();
            } //End block
        } //End block
        boolean var3D69162D9E6E2119B4912951E56A0158_938625374 = (rules[ALIGN_PARENT_BOTTOM] != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_560415894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_560415894;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.519 -0400", hash_original_method = "C61E9BCFF76D7B76D77F18D001923EFF", hash_generated_method = "C0C66D05E7E10A76C247FF4170C9A250")
    private void applyHorizontalSizeRules(LayoutParams childParams, int myWidth) {
        addTaint(myWidth);
        addTaint(childParams.getTaint());
        int[] rules = childParams.getRules();
        RelativeLayout.LayoutParams anchorParams;
        childParams.mLeft = -1;
        childParams.mRight = -1;
        anchorParams = getRelatedViewParams(rules, LEFT_OF);
        if(anchorParams != null)        
        {
            childParams.mRight = anchorParams.mLeft - (anchorParams.leftMargin +
                    childParams.rightMargin);
        } //End block
        else
        if(childParams.alignWithParent && rules[LEFT_OF] != 0)        
        {
            if(myWidth >= 0)            
            {
                childParams.mRight = myWidth - mPaddingRight - childParams.rightMargin;
            } //End block
            else
            {
            } //End block
        } //End block
        anchorParams = getRelatedViewParams(rules, RIGHT_OF);
        if(anchorParams != null)        
        {
            childParams.mLeft = anchorParams.mRight + (anchorParams.rightMargin +
                    childParams.leftMargin);
        } //End block
        else
        if(childParams.alignWithParent && rules[RIGHT_OF] != 0)        
        {
            childParams.mLeft = mPaddingLeft + childParams.leftMargin;
        } //End block
        anchorParams = getRelatedViewParams(rules, ALIGN_LEFT);
        if(anchorParams != null)        
        {
            childParams.mLeft = anchorParams.mLeft + childParams.leftMargin;
        } //End block
        else
        if(childParams.alignWithParent && rules[ALIGN_LEFT] != 0)        
        {
            childParams.mLeft = mPaddingLeft + childParams.leftMargin;
        } //End block
        anchorParams = getRelatedViewParams(rules, ALIGN_RIGHT);
        if(anchorParams != null)        
        {
            childParams.mRight = anchorParams.mRight - childParams.rightMargin;
        } //End block
        else
        if(childParams.alignWithParent && rules[ALIGN_RIGHT] != 0)        
        {
            if(myWidth >= 0)            
            {
                childParams.mRight = myWidth - mPaddingRight - childParams.rightMargin;
            } //End block
            else
            {
            } //End block
        } //End block
        if(0 != rules[ALIGN_PARENT_LEFT])        
        {
            childParams.mLeft = mPaddingLeft + childParams.leftMargin;
        } //End block
        if(0 != rules[ALIGN_PARENT_RIGHT])        
        {
            if(myWidth >= 0)            
            {
                childParams.mRight = myWidth - mPaddingRight - childParams.rightMargin;
            } //End block
            else
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.522 -0400", hash_original_method = "B3DE38D6CE01D7E90C154524E3D3CC84", hash_generated_method = "6B03BC71EF56FFB5D3948A541FDAE3DA")
    private void applyVerticalSizeRules(LayoutParams childParams, int myHeight) {
        addTaint(myHeight);
        addTaint(childParams.getTaint());
        int[] rules = childParams.getRules();
        RelativeLayout.LayoutParams anchorParams;
        childParams.mTop = -1;
        childParams.mBottom = -1;
        anchorParams = getRelatedViewParams(rules, ABOVE);
        if(anchorParams != null)        
        {
            childParams.mBottom = anchorParams.mTop - (anchorParams.topMargin +
                    childParams.bottomMargin);
        } //End block
        else
        if(childParams.alignWithParent && rules[ABOVE] != 0)        
        {
            if(myHeight >= 0)            
            {
                childParams.mBottom = myHeight - mPaddingBottom - childParams.bottomMargin;
            } //End block
            else
            {
            } //End block
        } //End block
        anchorParams = getRelatedViewParams(rules, BELOW);
        if(anchorParams != null)        
        {
            childParams.mTop = anchorParams.mBottom + (anchorParams.bottomMargin +
                    childParams.topMargin);
        } //End block
        else
        if(childParams.alignWithParent && rules[BELOW] != 0)        
        {
            childParams.mTop = mPaddingTop + childParams.topMargin;
        } //End block
        anchorParams = getRelatedViewParams(rules, ALIGN_TOP);
        if(anchorParams != null)        
        {
            childParams.mTop = anchorParams.mTop + childParams.topMargin;
        } //End block
        else
        if(childParams.alignWithParent && rules[ALIGN_TOP] != 0)        
        {
            childParams.mTop = mPaddingTop + childParams.topMargin;
        } //End block
        anchorParams = getRelatedViewParams(rules, ALIGN_BOTTOM);
        if(anchorParams != null)        
        {
            childParams.mBottom = anchorParams.mBottom - childParams.bottomMargin;
        } //End block
        else
        if(childParams.alignWithParent && rules[ALIGN_BOTTOM] != 0)        
        {
            if(myHeight >= 0)            
            {
                childParams.mBottom = myHeight - mPaddingBottom - childParams.bottomMargin;
            } //End block
            else
            {
            } //End block
        } //End block
        if(0 != rules[ALIGN_PARENT_TOP])        
        {
            childParams.mTop = mPaddingTop + childParams.topMargin;
        } //End block
        if(0 != rules[ALIGN_PARENT_BOTTOM])        
        {
            if(myHeight >= 0)            
            {
                childParams.mBottom = myHeight - mPaddingBottom - childParams.bottomMargin;
            } //End block
            else
            {
            } //End block
        } //End block
        if(rules[ALIGN_BASELINE] != 0)        
        {
            mHasBaselineAlignedChild = true;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.523 -0400", hash_original_method = "1C833E1C2ADE997D1187353BA16BCE70", hash_generated_method = "C215DE6A509BBD1FE50A706F10C5FE29")
    private View getRelatedView(int[] rules, int relation) {
        addTaint(relation);
        addTaint(rules[0]);
        int id = rules[relation];
        if(id != 0)        
        {
            DependencyGraph.Node node = mGraph.mKeyNodes.get(id);
            if(node == null)            
            {
View var540C13E9E156B687226421B24F2DF178_1930170756 =             null;
            var540C13E9E156B687226421B24F2DF178_1930170756.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1930170756;
            }
            View v = node.view;
            while
(v.getVisibility() == View.GONE)            
            {
                rules = ((LayoutParams) v.getLayoutParams()).getRules();
                node = mGraph.mKeyNodes.get((rules[relation]));
                if(node == null)                
                {
View var540C13E9E156B687226421B24F2DF178_1167045941 =                 null;
                var540C13E9E156B687226421B24F2DF178_1167045941.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1167045941;
                }
                v = node.view;
            } //End block
View var6DC76BC51820DD65E8396280E884AA78_98620176 =             v;
            var6DC76BC51820DD65E8396280E884AA78_98620176.addTaint(taint);
            return var6DC76BC51820DD65E8396280E884AA78_98620176;
        } //End block
View var540C13E9E156B687226421B24F2DF178_737876707 =         null;
        var540C13E9E156B687226421B24F2DF178_737876707.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_737876707;
        // ---------- Original Method ----------
        //int id = rules[relation];
        //if (id != 0) {
            //DependencyGraph.Node node = mGraph.mKeyNodes.get(id);
            //if (node == null) return null;
            //View v = node.view;
            //while (v.getVisibility() == View.GONE) {
                //rules = ((LayoutParams) v.getLayoutParams()).getRules();
                //node = mGraph.mKeyNodes.get((rules[relation]));
                //if (node == null) return null;
                //v = node.view;
            //}
            //return v;
        //}
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.523 -0400", hash_original_method = "1432C4369AF9849456CCA14753707552", hash_generated_method = "22691014038952AD6697FA9E32D9D6C0")
    private LayoutParams getRelatedViewParams(int[] rules, int relation) {
        addTaint(relation);
        addTaint(rules[0]);
        View v = getRelatedView(rules, relation);
        if(v != null)        
        {
            ViewGroup.LayoutParams params = v.getLayoutParams();
            if(params instanceof LayoutParams)            
            {
LayoutParams var4F75FEDE55B6B9296B3E4730B56C07FA_1321791096 =                 (LayoutParams) v.getLayoutParams();
                var4F75FEDE55B6B9296B3E4730B56C07FA_1321791096.addTaint(taint);
                return var4F75FEDE55B6B9296B3E4730B56C07FA_1321791096;
            } //End block
        } //End block
LayoutParams var540C13E9E156B687226421B24F2DF178_1064684565 =         null;
        var540C13E9E156B687226421B24F2DF178_1064684565.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1064684565;
        // ---------- Original Method ----------
        //View v = getRelatedView(rules, relation);
        //if (v != null) {
            //ViewGroup.LayoutParams params = v.getLayoutParams();
            //if (params instanceof LayoutParams) {
                //return (LayoutParams) v.getLayoutParams();
            //}
        //}
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.542 -0400", hash_original_method = "B96AFAE3C58D6FFF0F9AB9328789A20B", hash_generated_method = "BEEE71C39EDB256F02B5E71F25658189")
    private int getRelatedViewBaseline(int[] rules, int relation) {
        addTaint(relation);
        addTaint(rules[0]);
        View v = getRelatedView(rules, relation);
        if(v != null)        
        {
            int var7FCFEB6AAC114A346B332FBF5A437229_1742416697 = (v.getBaseline());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1767076088 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1767076088;
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1481084721 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_21755287 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_21755287;
        // ---------- Original Method ----------
        //View v = getRelatedView(rules, relation);
        //if (v != null) {
            //return v.getBaseline();
        //}
        //return -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.542 -0400", hash_original_method = "8A1AB6E076A6FFB22058EEC6C343479D", hash_generated_method = "21EB867A17524776BC2CCE0B2E4DDC14")
    private void centerHorizontal(View child, LayoutParams params, int myWidth) {
        addTaint(myWidth);
        addTaint(params.getTaint());
        addTaint(child.getTaint());
        int childWidth = child.getMeasuredWidth();
        int left = (myWidth - childWidth) / 2;
        params.mLeft = left;
        params.mRight = left + childWidth;
        // ---------- Original Method ----------
        //int childWidth = child.getMeasuredWidth();
        //int left = (myWidth - childWidth) / 2;
        //params.mLeft = left;
        //params.mRight = left + childWidth;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.543 -0400", hash_original_method = "D7FF6A5DD857E80D590F5847BEDB8204", hash_generated_method = "148EA00E48905863A48AF233142CDCC5")
    private void centerVertical(View child, LayoutParams params, int myHeight) {
        addTaint(myHeight);
        addTaint(params.getTaint());
        addTaint(child.getTaint());
        int childHeight = child.getMeasuredHeight();
        int top = (myHeight - childHeight) / 2;
        params.mTop = top;
        params.mBottom = top + childHeight;
        // ---------- Original Method ----------
        //int childHeight = child.getMeasuredHeight();
        //int top = (myHeight - childHeight) / 2;
        //params.mTop = top;
        //params.mBottom = top + childHeight;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.543 -0400", hash_original_method = "05FEBBF616C51C2D421358B4A05D22CE", hash_generated_method = "C37C4D4DC4149051ED8D1DDED4A9A0A7")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        addTaint(changed);
        int count = getChildCount();
for(int i = 0;i < count;i++)
        {
            View child = getChildAt(i);
            if(child.getVisibility() != GONE)            
            {
                RelativeLayout.LayoutParams st = (RelativeLayout.LayoutParams) child.getLayoutParams();
                child.layout(st.mLeft, st.mTop, st.mRight, st.mBottom);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int count = getChildCount();
        //for (int i = 0; i < count; i++) {
            //View child = getChildAt(i);
            //if (child.getVisibility() != GONE) {
                //RelativeLayout.LayoutParams st =
                        //(RelativeLayout.LayoutParams) child.getLayoutParams();
                //child.layout(st.mLeft, st.mTop, st.mRight, st.mBottom);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.544 -0400", hash_original_method = "233CD3CEF6FDC0096CEB70C074DAEDA3", hash_generated_method = "7BDF2AC10FFE2F4A50D5EB6E91CEC052")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        addTaint(attrs.getTaint());
LayoutParams varE51DEBDDE107B67850345280552397D8_1944749788 =         new RelativeLayout.LayoutParams(getContext(), attrs);
        varE51DEBDDE107B67850345280552397D8_1944749788.addTaint(taint);
        return varE51DEBDDE107B67850345280552397D8_1944749788;
        // ---------- Original Method ----------
        //return new RelativeLayout.LayoutParams(getContext(), attrs);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.544 -0400", hash_original_method = "9A6A2F1616AFA891B0951E317B143439", hash_generated_method = "04852983ECD5B6906EDBAA05FE9B47E0")
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
ViewGroup.LayoutParams var65BA47367D3E2EC837A3E887EEE5A3B3_632408198 =         new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        var65BA47367D3E2EC837A3E887EEE5A3B3_632408198.addTaint(taint);
        return var65BA47367D3E2EC837A3E887EEE5A3B3_632408198;
        // ---------- Original Method ----------
        //return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.544 -0400", hash_original_method = "7AAD3A1C062434D08215151012F2CF47", hash_generated_method = "8157EEEFA19819B54627F7964C916024")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean varED9D922FA4FD692BC43C4F5784245E8A_95551558 = (p instanceof RelativeLayout.LayoutParams);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1712850691 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1712850691;
        // ---------- Original Method ----------
        //return p instanceof RelativeLayout.LayoutParams;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.545 -0400", hash_original_method = "B595E0482905B38051CD63239BB5F8BA", hash_generated_method = "C0A2408FC3FB88DE751D4437AB86934F")
    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
ViewGroup.LayoutParams varB945D213E5036F8DDF9B40811234DF64_758407523 =         new LayoutParams(p);
        varB945D213E5036F8DDF9B40811234DF64_758407523.addTaint(taint);
        return varB945D213E5036F8DDF9B40811234DF64_758407523;
        // ---------- Original Method ----------
        //return new LayoutParams(p);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.545 -0400", hash_original_method = "02980C12A71A151B5687E23560D62A05", hash_generated_method = "DB2A2E02431DE588E33A99090DEF1259")
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        addTaint(event.getTaint());
        if(mTopToBottomLeftToRightSet == null)        
        {
            mTopToBottomLeftToRightSet = new TreeSet<View>(new TopToBottomLeftToRightComparator());
        } //End block
for(int i = 0, count = getChildCount();i < count;i++)
        {
            mTopToBottomLeftToRightSet.add(getChildAt(i));
        } //End block
for(View view : mTopToBottomLeftToRightSet)
        {
            if(view.getVisibility() == View.VISIBLE
                    && view.dispatchPopulateAccessibilityEvent(event))            
            {
                mTopToBottomLeftToRightSet.clear();
                boolean varB326B5062B2F0E69046810717534CB09_563312914 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_528770624 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_528770624;
            } //End block
        } //End block
        mTopToBottomLeftToRightSet.clear();
        boolean var68934A3E9455FA72420237EB05902327_197048034 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_810764403 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_810764403;
        // ---------- Original Method ----------
        //if (mTopToBottomLeftToRightSet == null) {
            //mTopToBottomLeftToRightSet = new TreeSet<View>(new TopToBottomLeftToRightComparator());
        //}
        //for (int i = 0, count = getChildCount(); i < count; i++) {
            //mTopToBottomLeftToRightSet.add(getChildAt(i));
        //}
        //for (View view : mTopToBottomLeftToRightSet) {
            //if (view.getVisibility() == View.VISIBLE
                    //&& view.dispatchPopulateAccessibilityEvent(event)) {
                //mTopToBottomLeftToRightSet.clear();
                //return true;
            //}
        //}
        //mTopToBottomLeftToRightSet.clear();
        //return false;
    }

    
    private class TopToBottomLeftToRightComparator implements Comparator<View> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.545 -0400", hash_original_method = "32220C1DAB888BE59E67ED1F2F5003D8", hash_generated_method = "32220C1DAB888BE59E67ED1F2F5003D8")
        public TopToBottomLeftToRightComparator ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.546 -0400", hash_original_method = "A3AAE4860228E849F39A667518F04B9E", hash_generated_method = "A7B5B942B3149FE5451D4635C1B66E77")
        public int compare(View first, View second) {
            addTaint(second.getTaint());
            addTaint(first.getTaint());
            int topDifference = first.getTop() - second.getTop();
            if(topDifference != 0)            
            {
                int var52339E5B13F6409E1601B19630C31099_1400669584 = (topDifference);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1193412066 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1193412066;
            } //End block
            int leftDifference = first.getLeft() - second.getLeft();
            if(leftDifference != 0)            
            {
                int varE2DF44AD014175AB04B6953418D21658_1207953279 = (leftDifference);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000912986 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000912986;
            } //End block
            int heightDiference = first.getHeight() - second.getHeight();
            if(heightDiference != 0)            
            {
                int var172A2AAD27F156A9E1E968C6D3E450F2_855346500 = (heightDiference);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_268441715 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_268441715;
            } //End block
            int widthDiference = first.getWidth() - second.getWidth();
            if(widthDiference != 0)            
            {
                int var3A93EFFEA3BE861302CB37CF192F6AAB_1270266913 = (widthDiference);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_48446215 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_48446215;
            } //End block
            int varCFCD208495D565EF66E7DFF9F98764DA_1145343613 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_81412399 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_81412399;
            // ---------- Original Method ----------
            //int topDifference = first.getTop() - second.getTop();
            //if (topDifference != 0) {
                //return topDifference;
            //}
            //int leftDifference = first.getLeft() - second.getLeft();
            //if (leftDifference != 0) {
                //return leftDifference;
            //}
            //int heightDiference = first.getHeight() - second.getHeight();
            //if (heightDiference != 0) {
                //return heightDiference;
            //}
            //int widthDiference = first.getWidth() - second.getWidth();
            //if (widthDiference != 0) {
                //return widthDiference;
            //}
            //return 0;
        }

        
    }


    
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.547 -0400", hash_original_field = "88F74427B9E2F7D924182ECC7F0BA0E3", hash_generated_field = "138597A9D627AA60011D0A51DCF0C547")

        @ViewDebug.ExportedProperty(category = "layout", resolveId = true, indexMapping = {
            @ViewDebug.IntToString(from = ABOVE,               to = "above"),
            @ViewDebug.IntToString(from = ALIGN_BASELINE,      to = "alignBaseline"),
            @ViewDebug.IntToString(from = ALIGN_BOTTOM,        to = "alignBottom"),
            @ViewDebug.IntToString(from = ALIGN_LEFT,          to = "alignLeft"),
            @ViewDebug.IntToString(from = ALIGN_PARENT_BOTTOM, to = "alignParentBottom"),
            @ViewDebug.IntToString(from = ALIGN_PARENT_LEFT,   to = "alignParentLeft"),
            @ViewDebug.IntToString(from = ALIGN_PARENT_RIGHT,  to = "alignParentRight"),
            @ViewDebug.IntToString(from = ALIGN_PARENT_TOP,    to = "alignParentTop"),
            @ViewDebug.IntToString(from = ALIGN_RIGHT,         to = "alignRight"),
            @ViewDebug.IntToString(from = ALIGN_TOP,           to = "alignTop"),
            @ViewDebug.IntToString(from = BELOW,               to = "below"),
            @ViewDebug.IntToString(from = CENTER_HORIZONTAL,   to = "centerHorizontal"),
            @ViewDebug.IntToString(from = CENTER_IN_PARENT,    to = "center"),
            @ViewDebug.IntToString(from = CENTER_VERTICAL,     to = "centerVertical"),
            @ViewDebug.IntToString(from = LEFT_OF,             to = "leftOf"),
            @ViewDebug.IntToString(from = RIGHT_OF,            to = "rightOf")
        }, mapping = {
            @ViewDebug.IntToString(from = TRUE, to = "true"),
            @ViewDebug.IntToString(from = 0,    to = "false/NO_ID")
        }) private int[] mRules = new int[VERB_COUNT];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.547 -0400", hash_original_field = "B5B776A6642DD69B16A47E6FCCAEEB6E", hash_generated_field = "AB08F003659B306A95990D148DDB5C29")

        private int mLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.547 -0400", hash_original_field = "D09DA346C6637C81F0228C8D0347388B", hash_generated_field = "B14441554FAC41961538E028958B2C0C")

        private int mTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.547 -0400", hash_original_field = "720807298C0DE3DCF41AEC725F26A5A1", hash_generated_field = "C26B1BDD0746218442C7F597FAB6F7D0")

        private int mRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.547 -0400", hash_original_field = "2FFD20D7E48915664FDF7F12FC3889D8", hash_generated_field = "4AF6ECE77AC654346D9C0CD81051EB99")

        private int mBottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.547 -0400", hash_original_field = "AC3033727FC96920DD8731A89FE8AF20", hash_generated_field = "666873D7B6DA8C6785E6C7DFC911FFA3")

        @ViewDebug.ExportedProperty(category = "layout") public boolean alignWithParent;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.551 -0400", hash_original_method = "A3B36B82744E08B8B1AFF03A4315BD99", hash_generated_method = "2A51C5961170A890739CA818F87BB3F8")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            addTaint(attrs.getTaint());
            addTaint(c.getTaint());
            TypedArray a = c.obtainStyledAttributes(attrs,
                    com.android.internal.R.styleable.RelativeLayout_Layout);
            final int[] rules = mRules;
            final int N = a.getIndexCount();
for(int i = 0;i < N;i++)
            {
                int attr = a.getIndex(i);
switch(attr){
                case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignWithParentIfMissing:
                alignWithParent = a.getBoolean(attr, false);
                break;
                case com.android.internal.R.styleable.RelativeLayout_Layout_layout_toLeftOf:
                rules[LEFT_OF] = a.getResourceId(attr, 0);
                break;
                case com.android.internal.R.styleable.RelativeLayout_Layout_layout_toRightOf:
                rules[RIGHT_OF] = a.getResourceId(attr, 0);
                break;
                case com.android.internal.R.styleable.RelativeLayout_Layout_layout_above:
                rules[ABOVE] = a.getResourceId(attr, 0);
                break;
                case com.android.internal.R.styleable.RelativeLayout_Layout_layout_below:
                rules[BELOW] = a.getResourceId(attr, 0);
                break;
                case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignBaseline:
                rules[ALIGN_BASELINE] = a.getResourceId(attr, 0);
                break;
                case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignLeft:
                rules[ALIGN_LEFT] = a.getResourceId(attr, 0);
                break;
                case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignTop:
                rules[ALIGN_TOP] = a.getResourceId(attr, 0);
                break;
                case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignRight:
                rules[ALIGN_RIGHT] = a.getResourceId(attr, 0);
                break;
                case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignBottom:
                rules[ALIGN_BOTTOM] = a.getResourceId(attr, 0);
                break;
                case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignParentLeft:
                rules[ALIGN_PARENT_LEFT] = a.getBoolean(attr, false) ? TRUE : 0;
                break;
                case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignParentTop:
                rules[ALIGN_PARENT_TOP] = a.getBoolean(attr, false) ? TRUE : 0;
                break;
                case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignParentRight:
                rules[ALIGN_PARENT_RIGHT] = a.getBoolean(attr, false) ? TRUE : 0;
                break;
                case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignParentBottom:
                rules[ALIGN_PARENT_BOTTOM] = a.getBoolean(attr, false) ? TRUE : 0;
                break;
                case com.android.internal.R.styleable.RelativeLayout_Layout_layout_centerInParent:
                rules[CENTER_IN_PARENT] = a.getBoolean(attr, false) ? TRUE : 0;
                break;
                case com.android.internal.R.styleable.RelativeLayout_Layout_layout_centerHorizontal:
                rules[CENTER_HORIZONTAL] = a.getBoolean(attr, false) ? TRUE : 0;
                break;
                case com.android.internal.R.styleable.RelativeLayout_Layout_layout_centerVertical:
                rules[CENTER_VERTICAL] = a.getBoolean(attr, false) ? TRUE : 0;
                break;
}
            } //End block
            a.recycle();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.552 -0400", hash_original_method = "979C42732F8B715475115A738CE7596D", hash_generated_method = "503F8BCA6BB39449EFF41178BE64A21C")
        public  LayoutParams(int w, int h) {
            super(w, h);
            addTaint(h);
            addTaint(w);
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.552 -0400", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "37A5DBEF9177864A03971A9D81D7D3EE")
        public  LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.552 -0400", hash_original_method = "600A366FF17B7D40DFA738E77A628E8F", hash_generated_method = "B2D13AC5BD03A134B95617DAFA8D7AF6")
        public  LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.553 -0400", hash_original_method = "E4ABE7598543A22DA450A925C25FFDEA", hash_generated_method = "0F0CA20CBEEB9101E23112E6C7B59269")
        @Override
        public String debug(String output) {
            addTaint(output.getTaint());
String var415ADF52E55102ED4321EF30FF1080EF_1544025716 =             output + "ViewGroup.LayoutParams={ width=" + sizeToString(width) +
                    ", height=" + sizeToString(height) + " }";
            var415ADF52E55102ED4321EF30FF1080EF_1544025716.addTaint(taint);
            return var415ADF52E55102ED4321EF30FF1080EF_1544025716;
            // ---------- Original Method ----------
            //return output + "ViewGroup.LayoutParams={ width=" + sizeToString(width) +
                    //", height=" + sizeToString(height) + " }";
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.553 -0400", hash_original_method = "F14B7CDC14D112CF9F86D0C64F4D29ED", hash_generated_method = "93452E0A48B7041D6E93F6CB23E7C08D")
        public void addRule(int verb) {
            mRules[verb] = TRUE;
            // ---------- Original Method ----------
            //mRules[verb] = TRUE;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.554 -0400", hash_original_method = "E6336A158C939972C1CFCFE234B123CF", hash_generated_method = "15C34D41A65E9FA80EF1B69E592566CD")
        public void addRule(int verb, int anchor) {
            mRules[verb] = anchor;
            // ---------- Original Method ----------
            //mRules[verb] = anchor;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.554 -0400", hash_original_method = "42AF2398E9BA5CDF378E196E0674D4AF", hash_generated_method = "702AE27491EF5340EB73331DDCE54615")
        public int[] getRules() {
            int[] varE219E87C8357C550D274AF6AD77D1221_616938365 = (mRules);
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1213025186 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_1213025186;
            // ---------- Original Method ----------
            //return mRules;
        }

        
    }


    
    private static class DependencyGraph {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.554 -0400", hash_original_field = "DB82967F5D06BF98EFB4ACBA027F7402", hash_generated_field = "1B3148FB5A2450DADCF9B3CB97C1D5E0")

        private ArrayList<Node> mNodes = new ArrayList<Node>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.554 -0400", hash_original_field = "1C1B3D8C2FB6A40BED49CA5117064AD5", hash_generated_field = "060FE5603F47B674AFC0F0792F7CB200")

        private SparseArray<Node> mKeyNodes = new SparseArray<Node>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.554 -0400", hash_original_field = "1E43BF04D9AA2FB180EB6CB5F6659D68", hash_generated_field = "249978BD32E42A0796E8254A85A11B49")

        private LinkedList<Node> mRoots = new LinkedList<Node>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.554 -0400", hash_original_method = "970FB9BC48F419CD4D1512AB366BD03A", hash_generated_method = "970FB9BC48F419CD4D1512AB366BD03A")
        public DependencyGraph ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.555 -0400", hash_original_method = "686A3AF8289E33425B30BEC25704B03B", hash_generated_method = "6E263DE1C332A32A035DB6ED194F26A5")
         void clear() {
            final ArrayList<Node> nodes = mNodes;
            final int count = nodes.size();
for(int i = 0;i < count;i++)
            {
                nodes.get(i).release();
            } //End block
            nodes.clear();
            mKeyNodes.clear();
            mRoots.clear();
            // ---------- Original Method ----------
            //final ArrayList<Node> nodes = mNodes;
            //final int count = nodes.size();
            //for (int i = 0; i < count; i++) {
                //nodes.get(i).release();
            //}
            //nodes.clear();
            //mKeyNodes.clear();
            //mRoots.clear();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.555 -0400", hash_original_method = "2AE2D90F3BED583D61A7D72DDE9D78E7", hash_generated_method = "755A66AD6F0F9A54AB082244AEAC3FE0")
         void add(View view) {
            addTaint(view.getTaint());
            final int id = view.getId();
            final Node node = Node.acquire(view);
            if(id != View.NO_ID)            
            {
                mKeyNodes.put(id, node);
            } //End block
            mNodes.add(node);
            // ---------- Original Method ----------
            //final int id = view.getId();
            //final Node node = Node.acquire(view);
            //if (id != View.NO_ID) {
                //mKeyNodes.put(id, node);
            //}
            //mNodes.add(node);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.556 -0400", hash_original_method = "A9C10EB6FA89DCA6CFC24E3AC1BF04E7", hash_generated_method = "6BE6BA382BB0A6CC539F812FC88ACCF0")
         void getSortedViews(View[] sorted, int... rules) {
            addTaint(rules[0]);
            addTaint(sorted[0].getTaint());
            final LinkedList<Node> roots = findRoots(rules);
            int index = 0;
            while
(roots.size() > 0)            
            {
                final Node node = roots.removeFirst();
                final View view = node.view;
                final int key = view.getId();
                sorted[index++] = view;
                final HashSet<Node> dependents = node.dependents;
for(Node dependent : dependents)
                {
                    final SparseArray<Node> dependencies = dependent.dependencies;
                    dependencies.remove(key);
                    if(dependencies.size() == 0)                    
                    {
                        roots.add(dependent);
                    } //End block
                } //End block
            } //End block
            if(index < sorted.length)            
            {
                IllegalStateException var04C5B0489467B0FD718C74CE5A26A97E_1274805561 = new IllegalStateException("Circular dependencies cannot exist"
                        + " in RelativeLayout");
                var04C5B0489467B0FD718C74CE5A26A97E_1274805561.addTaint(taint);
                throw var04C5B0489467B0FD718C74CE5A26A97E_1274805561;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.556 -0400", hash_original_method = "3833904997A1288F1E7950B84718C1E5", hash_generated_method = "33D4BFCCC4E864A5C8B5DB98D5C03878")
        private LinkedList<Node> findRoots(int[] rulesFilter) {
            addTaint(rulesFilter[0]);
            final SparseArray<Node> keyNodes = mKeyNodes;
            final ArrayList<Node> nodes = mNodes;
            final int count = nodes.size();
for(int i = 0;i < count;i++)
            {
                final Node node = nodes.get(i);
                node.dependents.clear();
                node.dependencies.clear();
            } //End block
for(int i = 0;i < count;i++)
            {
                final Node node = nodes.get(i);
                final LayoutParams layoutParams = (LayoutParams) node.view.getLayoutParams();
                final int[] rules = layoutParams.mRules;
                final int rulesCount = rulesFilter.length;
for(int j = 0;j < rulesCount;j++)
                {
                    final int rule = rules[rulesFilter[j]];
                    if(rule > 0)                    
                    {
                        final Node dependency = keyNodes.get(rule);
                        if(dependency == null || dependency == node)                        
                        {
                            continue;
                        } //End block
                        dependency.dependents.add(node);
                        node.dependencies.put(rule, dependency);
                    } //End block
                } //End block
            } //End block
            final LinkedList<Node> roots = mRoots;
            roots.clear();
for(int i = 0;i < count;i++)
            {
                final Node node = nodes.get(i);
                if(node.dependencies.size() == 0)                
                roots.add(node);
            } //End block
LinkedList<Node> var907D3440FEE061C7C9FFFCA83FCE83DE_877105495 =             roots;
            var907D3440FEE061C7C9FFFCA83FCE83DE_877105495.addTaint(taint);
            return var907D3440FEE061C7C9FFFCA83FCE83DE_877105495;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.557 -0400", hash_original_method = "6C6DA74626C9CD8B150D67A2E9AEA5BB", hash_generated_method = "7347C0F545C6FFEA1812982CF1F31FEE")
         void log(Resources resources, int... rules) {
            addTaint(rules[0]);
            addTaint(resources.getTaint());
            final LinkedList<Node> roots = findRoots(rules);
for(Node node : roots)
            {
                printNode(resources, node);
            } //End block
            // ---------- Original Method ----------
            //final LinkedList<Node> roots = findRoots(rules);
            //for (Node node : roots) {
                //printNode(resources, node);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        static void printViewId(Resources resources, View view) {
            if (view.getId() != View.NO_ID) {
                d(LOG_TAG, resources.getResourceEntryName(view.getId()));
            } else {
                d(LOG_TAG, "NO_ID");
            }
        }

        
        @DSModeled(DSC.SAFE)
        private static void appendViewId(Resources resources, Node node, StringBuilder buffer) {
            if (node.view.getId() != View.NO_ID) {
                buffer.append(resources.getResourceEntryName(node.view.getId()));
            } else {
                buffer.append("NO_ID");
            }
        }

        
        @DSModeled(DSC.SAFE)
        private static void printNode(Resources resources, Node node) {
            if (node.dependents.size() == 0) {
                printViewId(resources, node.view);
            } else {
                for (Node dependent : node.dependents) {
                    StringBuilder buffer = new StringBuilder();
                    appendViewId(resources, node, buffer);
                    printdependents(resources, dependent, buffer);
                }
            }
        }

        
        @DSModeled(DSC.SAFE)
        private static void printdependents(Resources resources, Node node, StringBuilder buffer) {
            buffer.append(" -> ");
            appendViewId(resources, node, buffer);
            if (node.dependents.size() == 0) {
                d(LOG_TAG, buffer.toString());
            } else {
                for (Node dependent : node.dependents) {
                    StringBuilder subBuffer = new StringBuilder(buffer);
                    printdependents(resources, dependent, subBuffer);
                }
            }
        }

        
        static class Node implements Poolable<Node> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.558 -0400", hash_original_field = "1BDA80F2BE4D3658E0BAA43FBE7AE8C1", hash_generated_field = "203A52904F64FA8CF6CE15F1E8FE3025")

            View view;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.558 -0400", hash_original_field = "E45EE0A3360491972145435FEA221205", hash_generated_field = "A98125254E0172625F934FA16377E7CD")

            final HashSet<Node> dependents = new HashSet<Node>();
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.558 -0400", hash_original_field = "D360F8069C7C16E4E73F95B33F2F9896", hash_generated_field = "316BDC31957F2C9443C511FFBE84DF28")

            final SparseArray<Node> dependencies = new SparseArray<Node>();
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.558 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "0A1E5AFC0BA7AE75B487CB8ED7E2A9F4")

            private Node mNext;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.559 -0400", hash_original_field = "224D05F4261498DA1D9DF38424832532", hash_generated_field = "BD952C5DD2D86B34B4D5F4AFE196E837")

            private boolean mIsPooled;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.559 -0400", hash_original_method = "4AE6680246A461A411C2DCFC3E5C235E", hash_generated_method = "4AE6680246A461A411C2DCFC3E5C235E")
            public Node ()
            {
                //Synthesized constructor
            }


                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.559 -0400", hash_original_method = "A08BF9EBBE4B2747346D150314791002", hash_generated_method = "2FE07B58E0CD5DBB314046E4692100A0")
            public void setNextPoolable(Node element) {
                mNext = element;
                // ---------- Original Method ----------
                //mNext = element;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.559 -0400", hash_original_method = "3B74D9DA1E659E0940912A17ED2BA31C", hash_generated_method = "C61C545D18839CD90AE21742829FFC02")
            public Node getNextPoolable() {
Node varA29C6A1F0F29A0F3732076BE541D5DCD_1367590680 =                 mNext;
                varA29C6A1F0F29A0F3732076BE541D5DCD_1367590680.addTaint(taint);
                return varA29C6A1F0F29A0F3732076BE541D5DCD_1367590680;
                // ---------- Original Method ----------
                //return mNext;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.559 -0400", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "5943E38831216F7D5D3F22ACB72CE2FC")
            public boolean isPooled() {
                boolean var224D05F4261498DA1D9DF38424832532_1171519117 = (mIsPooled);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1984133987 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1984133987;
                // ---------- Original Method ----------
                //return mIsPooled;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.560 -0400", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "31CEC37D69D770078DC2E4A0F4797B2A")
            public void setPooled(boolean isPooled) {
                mIsPooled = isPooled;
                // ---------- Original Method ----------
                //mIsPooled = isPooled;
            }

            
            @DSModeled(DSC.SAFE)
            static Node acquire(View view) {
                final Node node = sPool.acquire();
                node.view = view;
                return node;
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.560 -0400", hash_original_method = "4A4B6653C3D2EF8B0AE5BB1353D36229", hash_generated_method = "01DCF22208A7B01047CEF53A1A4F2C6E")
             void release() {
                view = null;
                dependents.clear();
                dependencies.clear();
                sPool.release(this);
                // ---------- Original Method ----------
                //view = null;
                //dependents.clear();
                //dependencies.clear();
                //sPool.release(this);
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.560 -0400", hash_original_field = "3303CE2CA63B453A0428C68DAD3EFE33", hash_generated_field = "9B2034265E9F4DD5C06037BD50EAEE36")

            private static final int POOL_LIMIT = 100;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.560 -0400", hash_original_field = "698BA341680326808CDA69878C18B225", hash_generated_field = "0C54963AD1342FCB8B8CE9807462CEFA")

            private static final Pool<Node> sPool = Pools.synchronizedPool(
                    Pools.finitePool(new PoolableManager<Node>() {
                        public Node newInstance() {
                            return new Node();
                        }

                        public void onAcquired(Node element) {
                        }

                        public void onReleased(Node element) {
                        }
                    }, POOL_LIMIT)
            );
            // orphaned legacy method
            public void onReleased(Node element) {
                        }
            
            // orphaned legacy method
            public void onAcquired(Node element) {
                        }
            
            // orphaned legacy method
            public Node newInstance() {
                            return new Node();
                        }
            
        }


        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.561 -0400", hash_original_field = "B81C9D25359AE819312506FB4D454B3C", hash_generated_field = "57E1FE47E9272F2D3908282BD0F70602")

    private static final String LOG_TAG = "RelativeLayout";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.561 -0400", hash_original_field = "A4AD3F5C4B55E9BB91428ACB3F00EB8D", hash_generated_field = "2C82381CD2A9F5B5C76AFEACEC85DDDB")

    private static final boolean DEBUG_GRAPH = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.561 -0400", hash_original_field = "38E1112DF959C803A5554C727023AA17", hash_generated_field = "B2899320334F57908731E112E94F1CDE")

    public static final int TRUE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.561 -0400", hash_original_field = "0152EBE6648A1A849ABE5CCB369A5F61", hash_generated_field = "096208EA2AF3CC7E7141BFD38797A0EC")

    public static final int LEFT_OF                  = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.561 -0400", hash_original_field = "BC8A963608B08F83E18CF292ADCB1EF2", hash_generated_field = "3F8E96F44674079400E1FE6BBEE7D7E2")

    public static final int RIGHT_OF                 = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.561 -0400", hash_original_field = "A552BBF9EE1E682F7D687E2691837FAD", hash_generated_field = "B25BAD9E800E104591FBDEB68402C4D7")

    public static final int ABOVE                    = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.561 -0400", hash_original_field = "F830A844112A468573A1372D853A00F0", hash_generated_field = "C33F54ACAC005E4F7B577DF5ECD8B8CB")

    public static final int BELOW                    = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.561 -0400", hash_original_field = "565F53F1AF518E64110614AF5FDFCB2F", hash_generated_field = "0367429D50A8B97E51A0EA79D61E8341")

    public static final int ALIGN_BASELINE           = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.561 -0400", hash_original_field = "B400AB0A19AC559B655040F61D268739", hash_generated_field = "B08FA699BB0A7B8EE01E81D8523B06B8")

    public static final int ALIGN_LEFT               = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.561 -0400", hash_original_field = "74A2A03ABA276E34AB3C9322C33CDB50", hash_generated_field = "503D8ED8ADEFA09061443AB73E1105EB")

    public static final int ALIGN_TOP                = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.561 -0400", hash_original_field = "CDCCA2471B04431DDC51A918AD8834B6", hash_generated_field = "066A8ADE746ECE1F1116FA381AA46454")

    public static final int ALIGN_RIGHT              = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.561 -0400", hash_original_field = "3723503AA3BFD474E29708678D1AB7A3", hash_generated_field = "0F184873DB5DF31E2DCF140BE0923551")

    public static final int ALIGN_BOTTOM             = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.561 -0400", hash_original_field = "57EDC78D811DE81B14DD0D05A86F4D0D", hash_generated_field = "07136E510188D5E09CB6F7AA93561D06")

    public static final int ALIGN_PARENT_LEFT        = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.561 -0400", hash_original_field = "CE3851F8A5577E5BA49B2CB7B6BB878A", hash_generated_field = "0949503221E389CCE8FB0E1467A44822")

    public static final int ALIGN_PARENT_TOP         = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.561 -0400", hash_original_field = "4F39C7BC6D569B9912A6C401F5A04E01", hash_generated_field = "3EFDDDF20B46B24CC5FB727D20BD8554")

    public static final int ALIGN_PARENT_RIGHT       = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.561 -0400", hash_original_field = "38AA961AD0797B3EB35974B8D237E4DE", hash_generated_field = "82EE6CB558A3BB3B4C93A79C69887380")

    public static final int ALIGN_PARENT_BOTTOM      = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.561 -0400", hash_original_field = "A3DE69363031F50770D752E2DF01665D", hash_generated_field = "D045131D6C0978E01C7E1F593FBD0FC4")

    public static final int CENTER_IN_PARENT         = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.562 -0400", hash_original_field = "26070F6C6231ACEE59A596606E5D0FDA", hash_generated_field = "E7BDEFDBB1D8A752BEF0DA17BCC1DA06")

    public static final int CENTER_HORIZONTAL        = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.562 -0400", hash_original_field = "CE20BA373620FB57D0126DD228A7F498", hash_generated_field = "12CCDDB6CE0278C45C3ED35DE6FCDC8B")

    public static final int CENTER_VERTICAL          = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.562 -0400", hash_original_field = "DA3B5D996B18D578340E863FCDB56B8A", hash_generated_field = "4C06C39E645DF1A64F0D7148873000D8")

    private static final int VERB_COUNT = 16;
}

