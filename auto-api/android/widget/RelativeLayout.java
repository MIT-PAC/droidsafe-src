package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.R;
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
import android.widget.RemoteViews.RemoteView;
import static android.util.Log.d;

public class RelativeLayout extends ViewGroup {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.835 -0400", hash_original_field = "824472FBDC9B8A7A1D14D0F19A7337AC", hash_generated_field = "C96F9BEAD28A0E01882C41D253AFA846")

    private View mBaselineView = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.835 -0400", hash_original_field = "94742DBD28E405550AB4998957C8C366", hash_generated_field = "6D2C0346DC0DDE3AEF5B4E55639F7BAB")

    private boolean mHasBaselineAlignedChild;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.835 -0400", hash_original_field = "5E1F1BFDB472CA8E7B81A98A346283DF", hash_generated_field = "0B3CD20786EC1640C99D342CF17DE4BB")

    private int mGravity = Gravity.LEFT | Gravity.TOP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.835 -0400", hash_original_field = "073BD2EBDB44B18FFCD2BC32B3DA1E9F", hash_generated_field = "24DC767A3ADC7BC83961E5A62989B517")

    private final Rect mContentBounds = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.835 -0400", hash_original_field = "19D950E97D0D17ED8E5107FA45A5A3B0", hash_generated_field = "3B16C2D681BFC370000C0D459ADC9C55")

    private final Rect mSelfBounds = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.835 -0400", hash_original_field = "FB105EBFDC13B6E222D9A92A87D9D55D", hash_generated_field = "40144C1646BB169CEE55D007B33717AC")

    private int mIgnoreGravity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.835 -0400", hash_original_field = "774E2842298F46AC1B9526CC91732103", hash_generated_field = "681342FA517F01301240A0DCB6966955")

    private SortedSet<View> mTopToBottomLeftToRightSet = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.835 -0400", hash_original_field = "C82377679ED9B96074D2EE30653ACBD8", hash_generated_field = "0C8E33895AC589A2FF55DFCBCE389221")

    private boolean mDirtyHierarchy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.835 -0400", hash_original_field = "0C827560E628733CEDD556735281B077", hash_generated_field = "224DF440DDF6B166B3D2E241F0F3F984")

    private View[] mSortedHorizontalChildren = new View[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.835 -0400", hash_original_field = "17A81D5CE0684E58A6D2CA78E6962AAC", hash_generated_field = "AB00FD5297C1C0ADA708BCFC1E36BC84")

    private View[] mSortedVerticalChildren = new View[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.835 -0400", hash_original_field = "A57E30F91BD1BFAA0A6B76A46793D1F6", hash_generated_field = "A2A346771E3A79053A739D0A482EAA8C")

    private final DependencyGraph mGraph = new DependencyGraph();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.835 -0400", hash_original_method = "88251BE26FFBF8D7F97872F9366B970C", hash_generated_method = "16DDCC589E6274662D70770ADB01F95C")
    public  RelativeLayout(Context context) {
        super(context);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.836 -0400", hash_original_method = "9502583C8FA8687465E0A06E15614A2F", hash_generated_method = "0213A8D39EFB20610CEDBD1EC9883ECA")
    public  RelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFromAttributes(context, attrs);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.836 -0400", hash_original_method = "4BEC7267CBAB87A927F52EE3092CF249", hash_generated_method = "8A947B2C3A030E9FE4F02392A6D86ECD")
    public  RelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initFromAttributes(context, attrs);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.836 -0400", hash_original_method = "2508EFC88C6F20ACAB1B8BFE22290A1F", hash_generated_method = "45BDFB27815E73C36E96DE3F50E2CB36")
    private void initFromAttributes(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RelativeLayout);
        mIgnoreGravity = a.getResourceId(R.styleable.RelativeLayout_ignoreGravity, View.NO_ID);
        mGravity = a.getInt(R.styleable.RelativeLayout_gravity, mGravity);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.836 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "024322D40697AF21FF21A7DEE5B29C5E")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_473271622 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_473271622;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.836 -0400", hash_original_method = "4B00B99E3D4A35B389EB4D3ED9BF824A", hash_generated_method = "2B6D5ACAF56866BE8DAC45848378F798")
    @android.view.RemotableViewMethod
    public void setIgnoreGravity(int viewId) {
        mIgnoreGravity = viewId;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.837 -0400", hash_original_method = "DC8D5E1211DE0926B9DDA2FADCED75EE", hash_generated_method = "70FD7A97C03EACC1814D5C80AB15EB8F")
    @android.view.RemotableViewMethod
    public void setGravity(int gravity) {
        {
            {
                gravity |= Gravity.START;
            } 
            {
                gravity |= Gravity.TOP;
            } 
            mGravity = gravity;
            requestLayout();
        } 
        
        
            
                
            
            
                
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.838 -0400", hash_original_method = "076C59065FCBD07F7CAA4FFA6D12CC3A", hash_generated_method = "472F09623C44D3DF3291E5B067DA27D2")
    @android.view.RemotableViewMethod
    public void setHorizontalGravity(int horizontalGravity) {
        final int gravity = horizontalGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        {
            mGravity = (mGravity & ~Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) | gravity;
            requestLayout();
        } 
        addTaint(horizontalGravity);
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.838 -0400", hash_original_method = "EE245B70888F9F1582A126D948173E64", hash_generated_method = "95CC5873BAFE1E11950B4F47E16D066A")
    @android.view.RemotableViewMethod
    public void setVerticalGravity(int verticalGravity) {
        final int gravity = verticalGravity & Gravity.VERTICAL_GRAVITY_MASK;
        {
            mGravity = (mGravity & ~Gravity.VERTICAL_GRAVITY_MASK) | gravity;
            requestLayout();
        } 
        addTaint(verticalGravity);
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.839 -0400", hash_original_method = "73585EFBB2973430E05667E2654BAD3F", hash_generated_method = "9E67A7D8F9B5A6F35C9D4E5A66DB22A2")
    @Override
    public int getBaseline() {
        {
            Object var8001D8978A247706B0BAAC60E08FE3F0_101611635 = (mBaselineView.getBaseline());
            Object varEC5F70FA49520212A319ACA653FC0209_1731997439 = (super.getBaseline());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_195852346 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_195852346;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.839 -0400", hash_original_method = "D40C3344998DDA8004351F538E92F8E3", hash_generated_method = "D2AF17735BD8ABFA2FCAA161F6376D90")
    @Override
    public void requestLayout() {
        super.requestLayout();
        mDirtyHierarchy = true;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.847 -0400", hash_original_method = "701273CD7B3C60F684ABCCF0BE7DD8A5", hash_generated_method = "ABECBA19D5EF9F5E2E6E20900D08DBB2")
    private void sortChildren() {
        int count = getChildCount();
        mSortedVerticalChildren = new View[count];
        mSortedHorizontalChildren = new View[count];
        final DependencyGraph graph = mGraph;
        graph.clear();
        {
            int i = 0;
            {
                final View child = getChildAt(i);
                graph.add(child);
            } 
        } 
        {
            d(LOG_TAG, "=== Sorted vertical children");
            graph.log(getResources(), ABOVE, BELOW, ALIGN_BASELINE, ALIGN_TOP, ALIGN_BOTTOM);
            d(LOG_TAG, "=== Sorted horizontal children");
            graph.log(getResources(), LEFT_OF, RIGHT_OF, ALIGN_LEFT, ALIGN_RIGHT);
        } 
        graph.getSortedViews(mSortedVerticalChildren, ABOVE, BELOW, ALIGN_BASELINE,
                ALIGN_TOP, ALIGN_BOTTOM);
        graph.getSortedViews(mSortedHorizontalChildren, LEFT_OF, RIGHT_OF, ALIGN_LEFT, ALIGN_RIGHT);
        {
            d(LOG_TAG, "=== Ordered list of vertical children");
            {
                View view = mSortedVerticalChildren[0];
                {
                    DependencyGraph.printViewId(getResources(), view);
                } 
            } 
            d(LOG_TAG, "=== Ordered list of horizontal children");
            {
                View view = mSortedVerticalChildren[0];
                {
                    DependencyGraph.printViewId(getResources(), view);
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.867 -0400", hash_original_method = "E2AF18A4E301BF9A8D0B175790671ACC", hash_generated_method = "AB3154AD9654FE843507A6EAED89812D")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        {
            mDirtyHierarchy = false;
            sortChildren();
        } 
        int myWidth = -1;
        int myHeight = -1;
        int width = 0;
        int height = 0;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        {
            myWidth = widthSize;
        } 
        {
            myHeight = heightSize;
        } 
        {
            width = myWidth;
        } 
        {
            height = myHeight;
        } 
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
        {
            ignore = findViewById(mIgnoreGravity);
        } 
        final boolean isWrapContentWidth = widthMode != MeasureSpec.EXACTLY;
        final boolean isWrapContentHeight = heightMode != MeasureSpec.EXACTLY;
        View[] views = mSortedHorizontalChildren;
        int count = views.length;
        {
            int i = 0;
            {
                View child = views[i];
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_1968776039 = (child.getVisibility() != GONE);
                    {
                        LayoutParams params = (LayoutParams) child.getLayoutParams();
                        applyHorizontalSizeRules(params, myWidth);
                        measureChildHorizontal(child, params, myWidth, myHeight);
                        {
                            boolean var4537C16BA1C0C3924FCC94B830A06952_1610270067 = (positionChildHorizontal(child, params, myWidth, isWrapContentWidth));
                            {
                                offsetHorizontalAxis = true;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        views = mSortedVerticalChildren;
        count = views.length;
        {
            int i = 0;
            {
                View child = views[i];
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_1744957186 = (child.getVisibility() != GONE);
                    {
                        LayoutParams params = (LayoutParams) child.getLayoutParams();
                        applyVerticalSizeRules(params, myHeight);
                        measureChild(child, params, myWidth, myHeight);
                        {
                            boolean var84A29BCF1C38D9115C84D1FDE3362FD1_2073658308 = (positionChildVertical(child, params, myHeight, isWrapContentHeight));
                            {
                                offsetVerticalAxis = true;
                            } 
                        } 
                        {
                            width = Math.max(width, params.mRight);
                        } 
                        {
                            height = Math.max(height, params.mBottom);
                        } 
                        {
                            left = Math.min(left, params.mLeft - params.leftMargin);
                            top = Math.min(top, params.mTop - params.topMargin);
                        } 
                        {
                            right = Math.max(right, params.mRight + params.rightMargin);
                            bottom = Math.max(bottom, params.mBottom + params.bottomMargin);
                        } 
                    } 
                } 
            } 
        } 
        {
            {
                int i = 0;
                {
                    View child = getChildAt(i);
                    {
                        boolean varACB49BF1319C5CFA15A5D6A72CCBFBDB_257334049 = (child.getVisibility() != GONE);
                        {
                            LayoutParams params = (LayoutParams) child.getLayoutParams();
                            alignBaseline(child, params);
                            {
                                left = Math.min(left, params.mLeft - params.leftMargin);
                                top = Math.min(top, params.mTop - params.topMargin);
                            } 
                            {
                                right = Math.max(right, params.mRight + params.rightMargin);
                                bottom = Math.max(bottom, params.mBottom + params.bottomMargin);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            width += mPaddingRight;
            {
                width = Math.max(width, mLayoutParams.width);
            } 
            width = Math.max(width, getSuggestedMinimumWidth());
            width = resolveSize(width, widthMeasureSpec);
            {
                {
                    int i = 0;
                    {
                        View child = getChildAt(i);
                        {
                            boolean var9C6E2C1B9CB3A34CE46D1781E75F2F00_115715494 = (child.getVisibility() != GONE);
                            {
                                LayoutParams params = (LayoutParams) child.getLayoutParams();
                                final int[] rules = params.getRules();
                                {
                                    centerHorizontal(child, params, width);
                                } 
                                {
                                    final int childWidth = child.getMeasuredWidth();
                                    params.mLeft = width - mPaddingRight - childWidth;
                                    params.mRight = params.mLeft + childWidth;
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            height += mPaddingBottom;
            {
                height = Math.max(height, mLayoutParams.height);
            } 
            height = Math.max(height, getSuggestedMinimumHeight());
            height = resolveSize(height, heightMeasureSpec);
            {
                {
                    int i = 0;
                    {
                        View child = getChildAt(i);
                        {
                            boolean var9C6E2C1B9CB3A34CE46D1781E75F2F00_891465655 = (child.getVisibility() != GONE);
                            {
                                LayoutParams params = (LayoutParams) child.getLayoutParams();
                                final int[] rules = params.getRules();
                                {
                                    centerVertical(child, params, height);
                                } 
                                {
                                    final int childHeight = child.getMeasuredHeight();
                                    params.mTop = height - mPaddingBottom - childHeight;
                                    params.mBottom = params.mTop + childHeight;
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
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
            {
                {
                    int i = 0;
                    {
                        View child = getChildAt(i);
                        {
                            boolean var382F74F421BA4E53BFCB9C654B764310_1784209185 = (child.getVisibility() != GONE && child != ignore);
                            {
                                LayoutParams params = (LayoutParams) child.getLayoutParams();
                                {
                                    params.mLeft += horizontalOffset;
                                    params.mRight += horizontalOffset;
                                } 
                                {
                                    params.mTop += verticalOffset;
                                    params.mBottom += verticalOffset;
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        setMeasuredDimension(width, height);
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.868 -0400", hash_original_method = "572E26DE16208C5960AF0F468C9CEB6F", hash_generated_method = "F6E153515DB227305B9E7BC8E6F32B18")
    private void alignBaseline(View child, LayoutParams params) {
        int[] rules = params.getRules();
        int anchorBaseline = getRelatedViewBaseline(rules, ALIGN_BASELINE);
        {
            LayoutParams anchorParams = getRelatedViewParams(rules, ALIGN_BASELINE);
            {
                int offset = anchorParams.mTop + anchorBaseline;
                int baseline = child.getBaseline();
                {
                    offset -= baseline;
                } 
                int height = params.mBottom - params.mTop;
                params.mTop = offset;
                params.mBottom = params.mTop + height;
            } 
        } 
        {
            mBaselineView = child;
        } 
        {
            LayoutParams lp = (LayoutParams) mBaselineView.getLayoutParams();
            {
                mBaselineView = child;
            } 
        } 
        addTaint(params.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.868 -0400", hash_original_method = "6FAB1FA940C67F7A3A04C20DF403CDD7", hash_generated_method = "0F78997D7ED8EF1CE776B8BACD5A2314")
    private void measureChild(View child, LayoutParams params, int myWidth, int myHeight) {
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
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        addTaint(myWidth);
        addTaint(myHeight);
        
        
                
                
                
                
        
                
                
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.868 -0400", hash_original_method = "C649DEFF309C12811323B81F575C7972", hash_generated_method = "2057A2726A4AE7D1307C252AD4563E24")
    private void measureChildHorizontal(View child, LayoutParams params, int myWidth, int myHeight) {
        int childWidthMeasureSpec = getChildMeasureSpec(params.mLeft,
                params.mRight, params.width,
                params.leftMargin, params.rightMargin,
                mPaddingLeft, mPaddingRight,
                myWidth);
        int childHeightMeasureSpec;
        {
            childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(myHeight, MeasureSpec.EXACTLY);
        } 
        {
            childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(myHeight, MeasureSpec.AT_MOST);
        } 
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        addTaint(myWidth);
        addTaint(myHeight);
        
        
                
                
                
                
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.869 -0400", hash_original_method = "78354A3A0D2C9A2AC648B99E7333EDDC", hash_generated_method = "870EF123FE04EDD78628FCBFB02C083E")
    private int getChildMeasureSpec(int childStart, int childEnd,
            int childSize, int startMargin, int endMargin, int startPadding,
            int endPadding, int mySize) {
        int childSpecMode = 0;
        int childSpecSize = 0;
        int tempStart = childStart;
        int tempEnd = childEnd;
        {
            tempStart = startPadding + startMargin;
        } 
        {
            tempEnd = mySize - endPadding - endMargin;
        } 
        int maxAvailable = tempEnd - tempStart;
        {
            childSpecMode = MeasureSpec.EXACTLY;
            childSpecSize = maxAvailable;
        } 
        {
            {
                childSpecMode = MeasureSpec.EXACTLY;
                {
                    childSpecSize = Math.min(maxAvailable, childSize);
                } 
                {
                    childSpecSize = childSize;
                } 
            } 
            {
                childSpecMode = MeasureSpec.EXACTLY;
                childSpecSize = maxAvailable;
            } 
            {
                {
                    childSpecMode = MeasureSpec.AT_MOST;
                    childSpecSize = maxAvailable;
                } 
                {
                    childSpecMode = MeasureSpec.UNSPECIFIED;
                    childSpecSize = 0;
                } 
            } 
        } 
        int varCF7E02B354BBF9C3C60EFC9675543EF2_897009951 = (MeasureSpec.makeMeasureSpec(childSpecSize, childSpecMode));
        addTaint(childStart);
        addTaint(childEnd);
        addTaint(childSize);
        addTaint(startMargin);
        addTaint(endMargin);
        addTaint(startPadding);
        addTaint(endPadding);
        addTaint(mySize);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1880264662 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1880264662;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.870 -0400", hash_original_method = "B9478380B54B111B46A13309CA4FBB39", hash_generated_method = "3ED495666D854C85092B1A2594D77846")
    private boolean positionChildHorizontal(View child, LayoutParams params, int myWidth,
            boolean wrapContent) {
        int[] rules = params.getRules();
        {
            params.mLeft = params.mRight - child.getMeasuredWidth();
        } 
        {
            params.mRight = params.mLeft + child.getMeasuredWidth();
        } 
        {
            {
                {
                    centerHorizontal(child, params, myWidth);
                } 
                {
                    params.mLeft = mPaddingLeft + params.leftMargin;
                    params.mRight = params.mLeft + child.getMeasuredWidth();
                } 
            } 
            {
                params.mLeft = mPaddingLeft + params.leftMargin;
                params.mRight = params.mLeft + child.getMeasuredWidth();
            } 
        } 
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        addTaint(myWidth);
        addTaint(wrapContent);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1795758940 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1795758940;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.870 -0400", hash_original_method = "09EB493CF05E8E659EC89F37304CD399", hash_generated_method = "55AC0F69D931ADA7ED4D562B85367B56")
    private boolean positionChildVertical(View child, LayoutParams params, int myHeight,
            boolean wrapContent) {
        int[] rules = params.getRules();
        {
            params.mTop = params.mBottom - child.getMeasuredHeight();
        } 
        {
            params.mBottom = params.mTop + child.getMeasuredHeight();
        } 
        {
            {
                {
                    centerVertical(child, params, myHeight);
                } 
                {
                    params.mTop = mPaddingTop + params.topMargin;
                    params.mBottom = params.mTop + child.getMeasuredHeight();
                } 
            } 
            {
                params.mTop = mPaddingTop + params.topMargin;
                params.mBottom = params.mTop + child.getMeasuredHeight();
            } 
        } 
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        addTaint(myHeight);
        addTaint(wrapContent);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_763658572 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_763658572;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.871 -0400", hash_original_method = "C61E9BCFF76D7B76D77F18D001923EFF", hash_generated_method = "E8C625E03B1E315AD804E32B7AAC604F")
    private void applyHorizontalSizeRules(LayoutParams childParams, int myWidth) {
        int[] rules = childParams.getRules();
        RelativeLayout.LayoutParams anchorParams;
        childParams.mLeft = -1;
        childParams.mRight = -1;
        anchorParams = getRelatedViewParams(rules, LEFT_OF);
        {
            childParams.mRight = anchorParams.mLeft - (anchorParams.leftMargin +
                    childParams.rightMargin);
        } 
        {
            {
                childParams.mRight = myWidth - mPaddingRight - childParams.rightMargin;
            } 
        } 
        anchorParams = getRelatedViewParams(rules, RIGHT_OF);
        {
            childParams.mLeft = anchorParams.mRight + (anchorParams.rightMargin +
                    childParams.leftMargin);
        } 
        {
            childParams.mLeft = mPaddingLeft + childParams.leftMargin;
        } 
        anchorParams = getRelatedViewParams(rules, ALIGN_LEFT);
        {
            childParams.mLeft = anchorParams.mLeft + childParams.leftMargin;
        } 
        {
            childParams.mLeft = mPaddingLeft + childParams.leftMargin;
        } 
        anchorParams = getRelatedViewParams(rules, ALIGN_RIGHT);
        {
            childParams.mRight = anchorParams.mRight - childParams.rightMargin;
        } 
        {
            {
                childParams.mRight = myWidth - mPaddingRight - childParams.rightMargin;
            } 
        } 
        {
            childParams.mLeft = mPaddingLeft + childParams.leftMargin;
        } 
        {
            {
                childParams.mRight = myWidth - mPaddingRight - childParams.rightMargin;
            } 
        } 
        addTaint(childParams.getTaint());
        addTaint(myWidth);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.873 -0400", hash_original_method = "B3DE38D6CE01D7E90C154524E3D3CC84", hash_generated_method = "79AF11813FC85B5C39A4B95094C8CA8B")
    private void applyVerticalSizeRules(LayoutParams childParams, int myHeight) {
        int[] rules = childParams.getRules();
        RelativeLayout.LayoutParams anchorParams;
        childParams.mTop = -1;
        childParams.mBottom = -1;
        anchorParams = getRelatedViewParams(rules, ABOVE);
        {
            childParams.mBottom = anchorParams.mTop - (anchorParams.topMargin +
                    childParams.bottomMargin);
        } 
        {
            {
                childParams.mBottom = myHeight - mPaddingBottom - childParams.bottomMargin;
            } 
        } 
        anchorParams = getRelatedViewParams(rules, BELOW);
        {
            childParams.mTop = anchorParams.mBottom + (anchorParams.bottomMargin +
                    childParams.topMargin);
        } 
        {
            childParams.mTop = mPaddingTop + childParams.topMargin;
        } 
        anchorParams = getRelatedViewParams(rules, ALIGN_TOP);
        {
            childParams.mTop = anchorParams.mTop + childParams.topMargin;
        } 
        {
            childParams.mTop = mPaddingTop + childParams.topMargin;
        } 
        anchorParams = getRelatedViewParams(rules, ALIGN_BOTTOM);
        {
            childParams.mBottom = anchorParams.mBottom - childParams.bottomMargin;
        } 
        {
            {
                childParams.mBottom = myHeight - mPaddingBottom - childParams.bottomMargin;
            } 
        } 
        {
            childParams.mTop = mPaddingTop + childParams.topMargin;
        } 
        {
            {
                childParams.mBottom = myHeight - mPaddingBottom - childParams.bottomMargin;
            } 
        } 
        {
            mHasBaselineAlignedChild = true;
        } 
        addTaint(childParams.getTaint());
        addTaint(myHeight);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.874 -0400", hash_original_method = "1C833E1C2ADE997D1187353BA16BCE70", hash_generated_method = "9CE574EFEED47B4E4B77C1EAAE3A02B6")
    private View getRelatedView(int[] rules, int relation) {
        View varB4EAC82CA7396A68D541C85D26508E83_1777124878 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1863599562 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_2059419626 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_913046106 = null; 
        int id = rules[relation];
        {
            DependencyGraph.Node node = mGraph.mKeyNodes.get(id);
            varB4EAC82CA7396A68D541C85D26508E83_1777124878 = null;
            View v = node.view;
            {
                boolean var72B3FB78D7E500F7F9E9259DA85F2263_1977578478 = (v.getVisibility() == View.GONE);
                {
                    rules = ((LayoutParams) v.getLayoutParams()).getRules();
                    node = mGraph.mKeyNodes.get((rules[relation]));
                    varB4EAC82CA7396A68D541C85D26508E83_1863599562 = null;
                    v = node.view;
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_2059419626 = v;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_913046106 = null;
        addTaint(rules[0]);
        addTaint(relation);
        View varA7E53CE21691AB073D9660D615818899_1073545378; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1073545378 = varB4EAC82CA7396A68D541C85D26508E83_1777124878;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1073545378 = varB4EAC82CA7396A68D541C85D26508E83_1863599562;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1073545378 = varB4EAC82CA7396A68D541C85D26508E83_2059419626;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1073545378 = varB4EAC82CA7396A68D541C85D26508E83_913046106;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1073545378.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1073545378;
        
        
        
            
            
            
            
                
                
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.875 -0400", hash_original_method = "1432C4369AF9849456CCA14753707552", hash_generated_method = "B6543E01F793BA94B33552CE47DD532B")
    private LayoutParams getRelatedViewParams(int[] rules, int relation) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1546112865 = null; 
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_771822660 = null; 
        View v = getRelatedView(rules, relation);
        {
            ViewGroup.LayoutParams params = v.getLayoutParams();
            {
                varB4EAC82CA7396A68D541C85D26508E83_1546112865 = (LayoutParams) v.getLayoutParams();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_771822660 = null;
        addTaint(rules[0]);
        addTaint(relation);
        LayoutParams varA7E53CE21691AB073D9660D615818899_356058854; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_356058854 = varB4EAC82CA7396A68D541C85D26508E83_1546112865;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_356058854 = varB4EAC82CA7396A68D541C85D26508E83_771822660;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_356058854.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_356058854;
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.875 -0400", hash_original_method = "B96AFAE3C58D6FFF0F9AB9328789A20B", hash_generated_method = "BA4AF922637698725DC0F653C9AEBD02")
    private int getRelatedViewBaseline(int[] rules, int relation) {
        View v = getRelatedView(rules, relation);
        {
            int varBFAAD9EEB54C80D14BB04F7DBAE3674A_1639091670 = (v.getBaseline());
        } 
        addTaint(rules[0]);
        addTaint(relation);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_208074274 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_208074274;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.876 -0400", hash_original_method = "8A1AB6E076A6FFB22058EEC6C343479D", hash_generated_method = "5FDCC80EBD3240AD9B182A55F2596BD0")
    private void centerHorizontal(View child, LayoutParams params, int myWidth) {
        int childWidth = child.getMeasuredWidth();
        int left = (myWidth - childWidth) / 2;
        params.mLeft = left;
        params.mRight = left + childWidth;
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        addTaint(myWidth);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.876 -0400", hash_original_method = "D7FF6A5DD857E80D590F5847BEDB8204", hash_generated_method = "23B4033279882218CC99AA3E337C7B83")
    private void centerVertical(View child, LayoutParams params, int myHeight) {
        int childHeight = child.getMeasuredHeight();
        int top = (myHeight - childHeight) / 2;
        params.mTop = top;
        params.mBottom = top + childHeight;
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        addTaint(myHeight);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.876 -0400", hash_original_method = "05FEBBF616C51C2D421358B4A05D22CE", hash_generated_method = "530A4BB06150C7CCD4FD1F261A5C1777")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        
        int count = getChildCount();
        {
            int i = 0;
            {
                View child = getChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_866232820 = (child.getVisibility() != GONE);
                    {
                        RelativeLayout.LayoutParams st = (RelativeLayout.LayoutParams) child.getLayoutParams();
                        child.layout(st.mLeft, st.mTop, st.mRight, st.mBottom);
                    } 
                } 
            } 
        } 
        addTaint(changed);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        
        
        
            
            
                
                        
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.877 -0400", hash_original_method = "233CD3CEF6FDC0096CEB70C074DAEDA3", hash_generated_method = "B5311DAEF0DD1ABA52E0D27D21D217CC")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_348934040 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_348934040 = new RelativeLayout.LayoutParams(getContext(), attrs);
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_348934040.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_348934040;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.878 -0400", hash_original_method = "9A6A2F1616AFA891B0951E317B143439", hash_generated_method = "EF78911D76D81B919844A93EBBD7D110")
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_100957154 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_100957154 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        varB4EAC82CA7396A68D541C85D26508E83_100957154.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_100957154;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.878 -0400", hash_original_method = "7AAD3A1C062434D08215151012F2CF47", hash_generated_method = "511D8DDB5F1486ED5A736C70D3C8ED56")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2016271876 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2016271876;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.878 -0400", hash_original_method = "B595E0482905B38051CD63239BB5F8BA", hash_generated_method = "7DBC8D6F9D90F80831DF5BA311DC903B")
    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_116666624 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_116666624 = new LayoutParams(p);
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_116666624.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_116666624;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.896 -0400", hash_original_method = "02980C12A71A151B5687E23560D62A05", hash_generated_method = "42749508AC7104B6A8B08B9E0C1599D8")
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        {
            mTopToBottomLeftToRightSet = new TreeSet<View>(new TopToBottomLeftToRightComparator());
        } 
        {
            int i = 0;
            int count = getChildCount();
            {
                mTopToBottomLeftToRightSet.add(getChildAt(i));
            } 
        } 
        {
            Iterator<View> var533C624396C561AA162C41D307444EBC_1238983455 = (mTopToBottomLeftToRightSet).iterator();
            var533C624396C561AA162C41D307444EBC_1238983455.hasNext();
            View view = var533C624396C561AA162C41D307444EBC_1238983455.next();
            {
                {
                    boolean var7C0A1D725855D863393CAE05FD961B09_117460837 = (view.getVisibility() == View.VISIBLE
                    && view.dispatchPopulateAccessibilityEvent(event));
                    {
                        mTopToBottomLeftToRightSet.clear();
                    } 
                } 
            } 
        } 
        mTopToBottomLeftToRightSet.clear();
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1252968417 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1252968417;
        
        
            
        
        
            
        
        
            
                    
                
                
            
        
        
        
    }

    
    private class TopToBottomLeftToRightComparator implements Comparator<View> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.896 -0400", hash_original_method = "32220C1DAB888BE59E67ED1F2F5003D8", hash_generated_method = "32220C1DAB888BE59E67ED1F2F5003D8")
        public TopToBottomLeftToRightComparator ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.896 -0400", hash_original_method = "A3AAE4860228E849F39A667518F04B9E", hash_generated_method = "E35271B51AE63A907C8EF8A52E1C1880")
        public int compare(View first, View second) {
            int topDifference = first.getTop() - second.getTop();
            int leftDifference = first.getLeft() - second.getLeft();
            int heightDiference = first.getHeight() - second.getHeight();
            int widthDiference = first.getWidth() - second.getWidth();
            addTaint(first.getTaint());
            addTaint(second.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_410862570 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_410862570;
            
            
            
                
            
            
            
                
            
            
            
                
            
            
            
                
            
            
        }

        
    }


    
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.896 -0400", hash_original_field = "88F74427B9E2F7D924182ECC7F0BA0E3", hash_generated_field = "138597A9D627AA60011D0A51DCF0C547")

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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.897 -0400", hash_original_field = "B5B776A6642DD69B16A47E6FCCAEEB6E", hash_generated_field = "AB08F003659B306A95990D148DDB5C29")

        private int mLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.897 -0400", hash_original_field = "D09DA346C6637C81F0228C8D0347388B", hash_generated_field = "B14441554FAC41961538E028958B2C0C")

        private int mTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.897 -0400", hash_original_field = "720807298C0DE3DCF41AEC725F26A5A1", hash_generated_field = "C26B1BDD0746218442C7F597FAB6F7D0")

        private int mRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.897 -0400", hash_original_field = "2FFD20D7E48915664FDF7F12FC3889D8", hash_generated_field = "4AF6ECE77AC654346D9C0CD81051EB99")

        private int mBottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.897 -0400", hash_original_field = "AC3033727FC96920DD8731A89FE8AF20", hash_generated_field = "666873D7B6DA8C6785E6C7DFC911FFA3")

        @ViewDebug.ExportedProperty(category = "layout") public boolean alignWithParent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.898 -0400", hash_original_method = "A3B36B82744E08B8B1AFF03A4315BD99", hash_generated_method = "D45850C8CB3DC38E0D70AB5A05BE9047")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a = c.obtainStyledAttributes(attrs,
                    com.android.internal.R.styleable.RelativeLayout_Layout);
            final int[] rules = mRules;
            final int N = a.getIndexCount();
            {
                int i = 0;
                {
                    int attr = a.getIndex(i);
                    
                    alignWithParent = a.getBoolean(attr, false);
                    
                    
                    rules[LEFT_OF] = a.getResourceId(attr, 0);
                    
                    
                    rules[RIGHT_OF] = a.getResourceId(attr, 0);
                    
                    
                    rules[ABOVE] = a.getResourceId(attr, 0);
                    
                    
                    rules[BELOW] = a.getResourceId(attr, 0);
                    
                    
                    rules[ALIGN_BASELINE] = a.getResourceId(attr, 0);
                    
                    
                    rules[ALIGN_LEFT] = a.getResourceId(attr, 0);
                    
                    
                    rules[ALIGN_TOP] = a.getResourceId(attr, 0);
                    
                    
                    rules[ALIGN_RIGHT] = a.getResourceId(attr, 0);
                    
                    
                    rules[ALIGN_BOTTOM] = a.getResourceId(attr, 0);
                    
                    
                    rules[ALIGN_PARENT_LEFT] = a.getBoolean(attr, false) ? TRUE : 0;
                    
                    
                    rules[ALIGN_PARENT_TOP] = a.getBoolean(attr, false) ? TRUE : 0;
                    
                    
                    rules[ALIGN_PARENT_RIGHT] = a.getBoolean(attr, false) ? TRUE : 0;
                    
                    
                    rules[ALIGN_PARENT_BOTTOM] = a.getBoolean(attr, false) ? TRUE : 0;
                    
                    
                    rules[CENTER_IN_PARENT] = a.getBoolean(attr, false) ? TRUE : 0;
                    
                    
                    rules[CENTER_HORIZONTAL] = a.getBoolean(attr, false) ? TRUE : 0;
                    
                    
                    rules[CENTER_VERTICAL] = a.getBoolean(attr, false) ? TRUE : 0;
                    
                } 
            } 
            a.recycle();
            addTaint(c.getTaint());
            addTaint(attrs.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.898 -0400", hash_original_method = "979C42732F8B715475115A738CE7596D", hash_generated_method = "A0678A9E2024BFE51CD3F973D466AEAF")
        public  LayoutParams(int w, int h) {
            super(w, h);
            addTaint(w);
            addTaint(h);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.899 -0400", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "37A5DBEF9177864A03971A9D81D7D3EE")
        public  LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.899 -0400", hash_original_method = "600A366FF17B7D40DFA738E77A628E8F", hash_generated_method = "B2D13AC5BD03A134B95617DAFA8D7AF6")
        public  LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.900 -0400", hash_original_method = "E4ABE7598543A22DA450A925C25FFDEA", hash_generated_method = "FEFE791B8E5AB60FCC15699FDCB615DB")
        @Override
        public String debug(String output) {
            String varB4EAC82CA7396A68D541C85D26508E83_1203628656 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1203628656 = output + "ViewGroup.LayoutParams={ width=" + sizeToString(width) +
                    ", height=" + sizeToString(height) + " }";
            addTaint(output.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1203628656.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1203628656;
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.900 -0400", hash_original_method = "F14B7CDC14D112CF9F86D0C64F4D29ED", hash_generated_method = "93452E0A48B7041D6E93F6CB23E7C08D")
        public void addRule(int verb) {
            mRules[verb] = TRUE;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.901 -0400", hash_original_method = "E6336A158C939972C1CFCFE234B123CF", hash_generated_method = "15C34D41A65E9FA80EF1B69E592566CD")
        public void addRule(int verb, int anchor) {
            mRules[verb] = anchor;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.901 -0400", hash_original_method = "42AF2398E9BA5CDF378E196E0674D4AF", hash_generated_method = "C6F5E975E0F5F5E68259117B0E0A4799")
        public int[] getRules() {
            int[] varB4CCCA26F9DB9189C32F33E82D425CFB_944962084 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_944962084;
            
            
        }

        
    }


    
    private static class DependencyGraph {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.901 -0400", hash_original_field = "DB82967F5D06BF98EFB4ACBA027F7402", hash_generated_field = "1B3148FB5A2450DADCF9B3CB97C1D5E0")

        private ArrayList<Node> mNodes = new ArrayList<Node>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.901 -0400", hash_original_field = "1C1B3D8C2FB6A40BED49CA5117064AD5", hash_generated_field = "060FE5603F47B674AFC0F0792F7CB200")

        private SparseArray<Node> mKeyNodes = new SparseArray<Node>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.901 -0400", hash_original_field = "1E43BF04D9AA2FB180EB6CB5F6659D68", hash_generated_field = "249978BD32E42A0796E8254A85A11B49")

        private LinkedList<Node> mRoots = new LinkedList<Node>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.901 -0400", hash_original_method = "970FB9BC48F419CD4D1512AB366BD03A", hash_generated_method = "970FB9BC48F419CD4D1512AB366BD03A")
        public DependencyGraph ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.901 -0400", hash_original_method = "686A3AF8289E33425B30BEC25704B03B", hash_generated_method = "2C48685B1D5D927BB788C660DB6F3657")
         void clear() {
            final ArrayList<Node> nodes = mNodes;
            final int count = nodes.size();
            {
                int i = 0;
                {
                    nodes.get(i).release();
                } 
            } 
            nodes.clear();
            mKeyNodes.clear();
            mRoots.clear();
            
            
            
            
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.902 -0400", hash_original_method = "2AE2D90F3BED583D61A7D72DDE9D78E7", hash_generated_method = "581C932047669D5E16E4F10CBB207AFB")
         void add(View view) {
            final int id = view.getId();
            final Node node = Node.acquire(view);
            {
                mKeyNodes.put(id, node);
            } 
            mNodes.add(node);
            addTaint(view.getTaint());
            
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.906 -0400", hash_original_method = "A9C10EB6FA89DCA6CFC24E3AC1BF04E7", hash_generated_method = "7BD8B6A70CF8F34DFC937201899A0340")
         void getSortedViews(View[] sorted, int... rules) {
            final LinkedList<Node> roots = findRoots(rules);
            int index = 0;
            {
                boolean varD630A3AB67E7A5775827EF03845CAC5C_1951825940 = (roots.size() > 0);
                {
                    final Node node = roots.removeFirst();
                    final View view = node.view;
                    final int key = view.getId();
                    sorted[index++] = view;
                    final HashSet<Node> dependents = node.dependents;
                    {
                        Iterator<Node> var0C52FBC8D9B182836C536A5F60F7826A_271305791 = (dependents).iterator();
                        var0C52FBC8D9B182836C536A5F60F7826A_271305791.hasNext();
                        Node dependent = var0C52FBC8D9B182836C536A5F60F7826A_271305791.next();
                        {
                            final SparseArray<Node> dependencies = dependent.dependencies;
                            dependencies.remove(key);
                            {
                                boolean varBE2B4F04D91A59A08789366480C2B5BD_223538500 = (dependencies.size() == 0);
                                {
                                    roots.add(dependent);
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Circular dependencies cannot exist"
                        + " in RelativeLayout");
            } 
            addTaint(sorted[0].getTaint());
            addTaint(rules[0]);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.907 -0400", hash_original_method = "3833904997A1288F1E7950B84718C1E5", hash_generated_method = "F0B1BA295B9158A0ABA14696D20825D4")
        private LinkedList<Node> findRoots(int[] rulesFilter) {
            LinkedList<Node> varB4EAC82CA7396A68D541C85D26508E83_1677938563 = null; 
            final SparseArray<Node> keyNodes = mKeyNodes;
            final ArrayList<Node> nodes = mNodes;
            final int count = nodes.size();
            {
                int i = 0;
                {
                    final Node node = nodes.get(i);
                    node.dependents.clear();
                    node.dependencies.clear();
                } 
            } 
            {
                int i = 0;
                {
                    final Node node = nodes.get(i);
                    final LayoutParams layoutParams = (LayoutParams) node.view.getLayoutParams();
                    final int[] rules = layoutParams.mRules;
                    final int rulesCount = rulesFilter.length;
                    {
                        int j = 0;
                        {
                            final int rule = rules[rulesFilter[j]];
                            {
                                final Node dependency = keyNodes.get(rule);
                                dependency.dependents.add(node);
                                node.dependencies.put(rule, dependency);
                            } 
                        } 
                    } 
                } 
            } 
            final LinkedList<Node> roots = mRoots;
            roots.clear();
            {
                int i = 0;
                {
                    final Node node = nodes.get(i);
                    {
                        boolean var5E6FEE9956DF9683C1D4121BDE382F81_1132071534 = (node.dependencies.size() == 0);
                        roots.add(node);
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1677938563 = roots;
            addTaint(rulesFilter[0]);
            varB4EAC82CA7396A68D541C85D26508E83_1677938563.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1677938563;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.914 -0400", hash_original_method = "6C6DA74626C9CD8B150D67A2E9AEA5BB", hash_generated_method = "90582874C872CF10F2F1AE32A1185C94")
         void log(Resources resources, int... rules) {
            final LinkedList<Node> roots = findRoots(rules);
            {
                Iterator<Node> var7DBAABE4E7F879D93D2EDA1D53070AED_1526231655 = (roots).iterator();
                var7DBAABE4E7F879D93D2EDA1D53070AED_1526231655.hasNext();
                Node node = var7DBAABE4E7F879D93D2EDA1D53070AED_1526231655.next();
                {
                    printNode(resources, node);
                } 
            } 
            addTaint(resources.getTaint());
            addTaint(rules[0]);
            
            
            
                
            
        }

        
        static void printViewId(Resources resources, View view) {
            if (view.getId() != View.NO_ID) {
                d(LOG_TAG, resources.getResourceEntryName(view.getId()));
            } else {
                d(LOG_TAG, "NO_ID");
            }
        }

        
        private static void appendViewId(Resources resources, Node node, StringBuilder buffer) {
            if (node.view.getId() != View.NO_ID) {
                buffer.append(resources.getResourceEntryName(node.view.getId()));
            } else {
                buffer.append("NO_ID");
            }
        }

        
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
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.915 -0400", hash_original_field = "1BDA80F2BE4D3658E0BAA43FBE7AE8C1", hash_generated_field = "203A52904F64FA8CF6CE15F1E8FE3025")

            View view;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.915 -0400", hash_original_field = "E45EE0A3360491972145435FEA221205", hash_generated_field = "A98125254E0172625F934FA16377E7CD")

            final HashSet<Node> dependents = new HashSet<Node>();
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.915 -0400", hash_original_field = "D360F8069C7C16E4E73F95B33F2F9896", hash_generated_field = "316BDC31957F2C9443C511FFBE84DF28")

            final SparseArray<Node> dependencies = new SparseArray<Node>();
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.915 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "0A1E5AFC0BA7AE75B487CB8ED7E2A9F4")

            private Node mNext;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.915 -0400", hash_original_field = "224D05F4261498DA1D9DF38424832532", hash_generated_field = "BD952C5DD2D86B34B4D5F4AFE196E837")

            private boolean mIsPooled;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.915 -0400", hash_original_method = "4AE6680246A461A411C2DCFC3E5C235E", hash_generated_method = "4AE6680246A461A411C2DCFC3E5C235E")
            public Node ()
            {
                
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.916 -0400", hash_original_method = "A08BF9EBBE4B2747346D150314791002", hash_generated_method = "2FE07B58E0CD5DBB314046E4692100A0")
            public void setNextPoolable(Node element) {
                mNext = element;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.916 -0400", hash_original_method = "3B74D9DA1E659E0940912A17ED2BA31C", hash_generated_method = "0F382ECBC95B0EA7A226E8997B51BB56")
            public Node getNextPoolable() {
                Node varB4EAC82CA7396A68D541C85D26508E83_1017949239 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1017949239 = mNext;
                varB4EAC82CA7396A68D541C85D26508E83_1017949239.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1017949239;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.917 -0400", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "71CF2BFA2E7B50A0BDE0C3538B358123")
            public boolean isPooled() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1394943721 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1394943721;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.917 -0400", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "31CEC37D69D770078DC2E4A0F4797B2A")
            public void setPooled(boolean isPooled) {
                mIsPooled = isPooled;
                
                
            }

            
            static Node acquire(View view) {
                final Node node = sPool.acquire();
                node.view = view;
                return node;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.917 -0400", hash_original_method = "4A4B6653C3D2EF8B0AE5BB1353D36229", hash_generated_method = "01DCF22208A7B01047CEF53A1A4F2C6E")
             void release() {
                view = null;
                dependents.clear();
                dependencies.clear();
                sPool.release(this);
                
                
                
                
                
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.917 -0400", hash_original_field = "3303CE2CA63B453A0428C68DAD3EFE33", hash_generated_field = "9B2034265E9F4DD5C06037BD50EAEE36")

            private static final int POOL_LIMIT = 100;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.917 -0400", hash_original_field = "698BA341680326808CDA69878C18B225", hash_generated_field = "0C54963AD1342FCB8B8CE9807462CEFA")

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
            
            public void onReleased(Node element) {
                        }
            
            
            public void onAcquired(Node element) {
                        }
            
            
            public Node newInstance() {
                            return new Node();
                        }
            
        }


        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.918 -0400", hash_original_field = "B81C9D25359AE819312506FB4D454B3C", hash_generated_field = "57E1FE47E9272F2D3908282BD0F70602")

    private static final String LOG_TAG = "RelativeLayout";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.918 -0400", hash_original_field = "A4AD3F5C4B55E9BB91428ACB3F00EB8D", hash_generated_field = "2C82381CD2A9F5B5C76AFEACEC85DDDB")

    private static final boolean DEBUG_GRAPH = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.918 -0400", hash_original_field = "38E1112DF959C803A5554C727023AA17", hash_generated_field = "B2899320334F57908731E112E94F1CDE")

    public static final int TRUE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.918 -0400", hash_original_field = "0152EBE6648A1A849ABE5CCB369A5F61", hash_generated_field = "096208EA2AF3CC7E7141BFD38797A0EC")

    public static final int LEFT_OF                  = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.918 -0400", hash_original_field = "BC8A963608B08F83E18CF292ADCB1EF2", hash_generated_field = "3F8E96F44674079400E1FE6BBEE7D7E2")

    public static final int RIGHT_OF                 = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.918 -0400", hash_original_field = "A552BBF9EE1E682F7D687E2691837FAD", hash_generated_field = "B25BAD9E800E104591FBDEB68402C4D7")

    public static final int ABOVE                    = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.918 -0400", hash_original_field = "F830A844112A468573A1372D853A00F0", hash_generated_field = "C33F54ACAC005E4F7B577DF5ECD8B8CB")

    public static final int BELOW                    = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.918 -0400", hash_original_field = "565F53F1AF518E64110614AF5FDFCB2F", hash_generated_field = "0367429D50A8B97E51A0EA79D61E8341")

    public static final int ALIGN_BASELINE           = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.918 -0400", hash_original_field = "B400AB0A19AC559B655040F61D268739", hash_generated_field = "B08FA699BB0A7B8EE01E81D8523B06B8")

    public static final int ALIGN_LEFT               = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.918 -0400", hash_original_field = "74A2A03ABA276E34AB3C9322C33CDB50", hash_generated_field = "503D8ED8ADEFA09061443AB73E1105EB")

    public static final int ALIGN_TOP                = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.918 -0400", hash_original_field = "CDCCA2471B04431DDC51A918AD8834B6", hash_generated_field = "066A8ADE746ECE1F1116FA381AA46454")

    public static final int ALIGN_RIGHT              = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.918 -0400", hash_original_field = "3723503AA3BFD474E29708678D1AB7A3", hash_generated_field = "0F184873DB5DF31E2DCF140BE0923551")

    public static final int ALIGN_BOTTOM             = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.918 -0400", hash_original_field = "57EDC78D811DE81B14DD0D05A86F4D0D", hash_generated_field = "07136E510188D5E09CB6F7AA93561D06")

    public static final int ALIGN_PARENT_LEFT        = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.918 -0400", hash_original_field = "CE3851F8A5577E5BA49B2CB7B6BB878A", hash_generated_field = "0949503221E389CCE8FB0E1467A44822")

    public static final int ALIGN_PARENT_TOP         = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.918 -0400", hash_original_field = "4F39C7BC6D569B9912A6C401F5A04E01", hash_generated_field = "3EFDDDF20B46B24CC5FB727D20BD8554")

    public static final int ALIGN_PARENT_RIGHT       = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.918 -0400", hash_original_field = "38AA961AD0797B3EB35974B8D237E4DE", hash_generated_field = "82EE6CB558A3BB3B4C93A79C69887380")

    public static final int ALIGN_PARENT_BOTTOM      = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.918 -0400", hash_original_field = "A3DE69363031F50770D752E2DF01665D", hash_generated_field = "D045131D6C0978E01C7E1F593FBD0FC4")

    public static final int CENTER_IN_PARENT         = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.918 -0400", hash_original_field = "26070F6C6231ACEE59A596606E5D0FDA", hash_generated_field = "E7BDEFDBB1D8A752BEF0DA17BCC1DA06")

    public static final int CENTER_HORIZONTAL        = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.918 -0400", hash_original_field = "CE20BA373620FB57D0126DD228A7F498", hash_generated_field = "12CCDDB6CE0278C45C3ED35DE6FCDC8B")

    public static final int CENTER_VERTICAL          = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.918 -0400", hash_original_field = "DA3B5D996B18D578340E863FCDB56B8A", hash_generated_field = "4C06C39E645DF1A64F0D7148873000D8")

    private static final int VERB_COUNT = 16;
}

