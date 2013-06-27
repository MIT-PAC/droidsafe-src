package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.291 -0400", hash_original_field = "824472FBDC9B8A7A1D14D0F19A7337AC", hash_generated_field = "C96F9BEAD28A0E01882C41D253AFA846")

    private View mBaselineView = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.291 -0400", hash_original_field = "94742DBD28E405550AB4998957C8C366", hash_generated_field = "6D2C0346DC0DDE3AEF5B4E55639F7BAB")

    private boolean mHasBaselineAlignedChild;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.291 -0400", hash_original_field = "5E1F1BFDB472CA8E7B81A98A346283DF", hash_generated_field = "0B3CD20786EC1640C99D342CF17DE4BB")

    private int mGravity = Gravity.LEFT | Gravity.TOP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.291 -0400", hash_original_field = "073BD2EBDB44B18FFCD2BC32B3DA1E9F", hash_generated_field = "07E55C6B40D7F6C3F6F9D5FF5C4453DA")

    private Rect mContentBounds = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.291 -0400", hash_original_field = "19D950E97D0D17ED8E5107FA45A5A3B0", hash_generated_field = "14261C060FA7F5DC9FDD430F3E263596")

    private Rect mSelfBounds = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.291 -0400", hash_original_field = "FB105EBFDC13B6E222D9A92A87D9D55D", hash_generated_field = "40144C1646BB169CEE55D007B33717AC")

    private int mIgnoreGravity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.291 -0400", hash_original_field = "774E2842298F46AC1B9526CC91732103", hash_generated_field = "681342FA517F01301240A0DCB6966955")

    private SortedSet<View> mTopToBottomLeftToRightSet = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.291 -0400", hash_original_field = "C82377679ED9B96074D2EE30653ACBD8", hash_generated_field = "0C8E33895AC589A2FF55DFCBCE389221")

    private boolean mDirtyHierarchy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.291 -0400", hash_original_field = "0C827560E628733CEDD556735281B077", hash_generated_field = "224DF440DDF6B166B3D2E241F0F3F984")

    private View[] mSortedHorizontalChildren = new View[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.291 -0400", hash_original_field = "17A81D5CE0684E58A6D2CA78E6962AAC", hash_generated_field = "AB00FD5297C1C0ADA708BCFC1E36BC84")

    private View[] mSortedVerticalChildren = new View[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.291 -0400", hash_original_field = "A57E30F91BD1BFAA0A6B76A46793D1F6", hash_generated_field = "FD575FEBC84654D24D417C344E0AEC9A")

    private DependencyGraph mGraph = new DependencyGraph();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.306 -0400", hash_original_method = "88251BE26FFBF8D7F97872F9366B970C", hash_generated_method = "16DDCC589E6274662D70770ADB01F95C")
    public  RelativeLayout(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.306 -0400", hash_original_method = "9502583C8FA8687465E0A06E15614A2F", hash_generated_method = "0213A8D39EFB20610CEDBD1EC9883ECA")
    public  RelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFromAttributes(context, attrs);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        //initFromAttributes(context, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.307 -0400", hash_original_method = "4BEC7267CBAB87A927F52EE3092CF249", hash_generated_method = "8A947B2C3A030E9FE4F02392A6D86ECD")
    public  RelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initFromAttributes(context, attrs);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
        //initFromAttributes(context, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.307 -0400", hash_original_method = "2508EFC88C6F20ACAB1B8BFE22290A1F", hash_generated_method = "F2BE478DC353D8E6E8D2B96F17F61F59")
    private void initFromAttributes(Context context, AttributeSet attrs) {
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, R.styleable.RelativeLayout);
        mIgnoreGravity = a.getResourceId(R.styleable.RelativeLayout_ignoreGravity, View.NO_ID);
        mGravity = a.getInt(R.styleable.RelativeLayout_gravity, mGravity);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RelativeLayout);
        //mIgnoreGravity = a.getResourceId(R.styleable.RelativeLayout_ignoreGravity, View.NO_ID);
        //mGravity = a.getInt(R.styleable.RelativeLayout_gravity, mGravity);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.308 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "B6BD072182802B53031091C588641D6C")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2062806571 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2062806571;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.308 -0400", hash_original_method = "4B00B99E3D4A35B389EB4D3ED9BF824A", hash_generated_method = "2B6D5ACAF56866BE8DAC45848378F798")
    @android.view.RemotableViewMethod
    public void setIgnoreGravity(int viewId) {
        mIgnoreGravity = viewId;
        // ---------- Original Method ----------
        //mIgnoreGravity = viewId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.309 -0400", hash_original_method = "DC8D5E1211DE0926B9DDA2FADCED75EE", hash_generated_method = "70FD7A97C03EACC1814D5C80AB15EB8F")
    @android.view.RemotableViewMethod
    public void setGravity(int gravity) {
        {
            {
                gravity |= Gravity.START;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.315 -0400", hash_original_method = "076C59065FCBD07F7CAA4FFA6D12CC3A", hash_generated_method = "65ABA9E48DE49124BBE38972DFC6C8E3")
    @android.view.RemotableViewMethod
    public void setHorizontalGravity(int horizontalGravity) {
        int gravity;
        gravity = horizontalGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        {
            mGravity = (mGravity & ~Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) | gravity;
            requestLayout();
        } //End block
        addTaint(horizontalGravity);
        // ---------- Original Method ----------
        //final int gravity = horizontalGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        //if ((mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) != gravity) {
            //mGravity = (mGravity & ~Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) | gravity;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.317 -0400", hash_original_method = "EE245B70888F9F1582A126D948173E64", hash_generated_method = "601E6D5BF8B6BDDC866632D7C5C11147")
    @android.view.RemotableViewMethod
    public void setVerticalGravity(int verticalGravity) {
        int gravity;
        gravity = verticalGravity & Gravity.VERTICAL_GRAVITY_MASK;
        {
            mGravity = (mGravity & ~Gravity.VERTICAL_GRAVITY_MASK) | gravity;
            requestLayout();
        } //End block
        addTaint(verticalGravity);
        // ---------- Original Method ----------
        //final int gravity = verticalGravity & Gravity.VERTICAL_GRAVITY_MASK;
        //if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != gravity) {
            //mGravity = (mGravity & ~Gravity.VERTICAL_GRAVITY_MASK) | gravity;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.318 -0400", hash_original_method = "73585EFBB2973430E05667E2654BAD3F", hash_generated_method = "734170EE15B6CE1594466A6818E214E6")
    @Override
    public int getBaseline() {
        {
            Object var8001D8978A247706B0BAAC60E08FE3F0_368077182 = (mBaselineView.getBaseline());
            Object varEC5F70FA49520212A319ACA653FC0209_1405053900 = (super.getBaseline());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442903935 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442903935;
        // ---------- Original Method ----------
        //return mBaselineView != null ? mBaselineView.getBaseline() : super.getBaseline();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.322 -0400", hash_original_method = "D40C3344998DDA8004351F538E92F8E3", hash_generated_method = "D2AF17735BD8ABFA2FCAA161F6376D90")
    @Override
    public void requestLayout() {
        super.requestLayout();
        mDirtyHierarchy = true;
        // ---------- Original Method ----------
        //super.requestLayout();
        //mDirtyHierarchy = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.393 -0400", hash_original_method = "701273CD7B3C60F684ABCCF0BE7DD8A5", hash_generated_method = "04CAA3E55E3469EB45F045641768CBF2")
    private void sortChildren() {
        int count;
        count = getChildCount();
        mSortedVerticalChildren = new View[count];
        mSortedHorizontalChildren = new View[count];
        DependencyGraph graph;
        graph = mGraph;
        graph.clear();
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildAt(i);
                graph.add(child);
            } //End block
        } //End collapsed parenthetic
        {
            d(LOG_TAG, "=== Sorted vertical children");
            graph.log(getResources(), ABOVE, BELOW, ALIGN_BASELINE, ALIGN_TOP, ALIGN_BOTTOM);
            d(LOG_TAG, "=== Sorted horizontal children");
            graph.log(getResources(), LEFT_OF, RIGHT_OF, ALIGN_LEFT, ALIGN_RIGHT);
        } //End block
        graph.getSortedViews(mSortedVerticalChildren, ABOVE, BELOW, ALIGN_BASELINE,
                ALIGN_TOP, ALIGN_BOTTOM);
        graph.getSortedViews(mSortedHorizontalChildren, LEFT_OF, RIGHT_OF, ALIGN_LEFT, ALIGN_RIGHT);
        {
            d(LOG_TAG, "=== Ordered list of vertical children");
            {
                Iterator<View> varC55AB14B8416106CB8012AA1776957AF_2155286 = (mSortedVerticalChildren).iterator();
                varC55AB14B8416106CB8012AA1776957AF_2155286.hasNext();
                View view = varC55AB14B8416106CB8012AA1776957AF_2155286.next();
                {
                    DependencyGraph.printViewId(getResources(), view);
                } //End block
            } //End collapsed parenthetic
            d(LOG_TAG, "=== Ordered list of horizontal children");
            {
                Iterator<View> varDABE4B4241CB29641506235DE1A67B7A_509027455 = (mSortedHorizontalChildren).iterator();
                varDABE4B4241CB29641506235DE1A67B7A_509027455.hasNext();
                View view = varDABE4B4241CB29641506235DE1A67B7A_509027455.next();
                {
                    DependencyGraph.printViewId(getResources(), view);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.404 -0400", hash_original_method = "E2AF18A4E301BF9A8D0B175790671ACC", hash_generated_method = "8871479919E211B319F8DA798C5A0C26")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mDirtyHierarchy = false;
            sortChildren();
        } //End block
        int myWidth;
        myWidth = -1;
        int myHeight;
        myHeight = -1;
        int width;
        width = 0;
        int height;
        height = 0;
        int widthMode;
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode;
        heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize;
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize;
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
        {
            myWidth = widthSize;
        } //End block
        {
            myHeight = heightSize;
        } //End block
        {
            width = myWidth;
        } //End block
        {
            height = myHeight;
        } //End block
        mHasBaselineAlignedChild = false;
        View ignore;
        ignore = null;
        int gravity;
        gravity = mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        boolean horizontalGravity;
        horizontalGravity = gravity != Gravity.LEFT && gravity != 0;
        gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        boolean verticalGravity;
        verticalGravity = gravity != Gravity.TOP && gravity != 0;
        int left;
        left = Integer.MAX_VALUE;
        int top;
        top = Integer.MAX_VALUE;
        int right;
        right = Integer.MIN_VALUE;
        int bottom;
        bottom = Integer.MIN_VALUE;
        boolean offsetHorizontalAxis;
        offsetHorizontalAxis = false;
        boolean offsetVerticalAxis;
        offsetVerticalAxis = false;
        {
            ignore = findViewById(mIgnoreGravity);
        } //End block
        boolean isWrapContentWidth;
        isWrapContentWidth = widthMode != MeasureSpec.EXACTLY;
        boolean isWrapContentHeight;
        isWrapContentHeight = heightMode != MeasureSpec.EXACTLY;
        View[] views;
        views = mSortedHorizontalChildren;
        int count;
        count = views.length;
        {
            int i;
            i = 0;
            {
                View child;
                child = views[i];
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_1713199671 = (child.getVisibility() != GONE);
                    {
                        LayoutParams params;
                        params = (LayoutParams) child.getLayoutParams();
                        applyHorizontalSizeRules(params, myWidth);
                        measureChildHorizontal(child, params, myWidth, myHeight);
                        {
                            boolean var4537C16BA1C0C3924FCC94B830A06952_1997718520 = (positionChildHorizontal(child, params, myWidth, isWrapContentWidth));
                            {
                                offsetHorizontalAxis = true;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        views = mSortedVerticalChildren;
        count = views.length;
        {
            int i;
            i = 0;
            {
                View child;
                child = views[i];
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_1225102126 = (child.getVisibility() != GONE);
                    {
                        LayoutParams params;
                        params = (LayoutParams) child.getLayoutParams();
                        applyVerticalSizeRules(params, myHeight);
                        measureChild(child, params, myWidth, myHeight);
                        {
                            boolean var84A29BCF1C38D9115C84D1FDE3362FD1_627694158 = (positionChildVertical(child, params, myHeight, isWrapContentHeight));
                            {
                                offsetVerticalAxis = true;
                            } //End block
                        } //End collapsed parenthetic
                        {
                            width = Math.max(width, params.mRight);
                        } //End block
                        {
                            height = Math.max(height, params.mBottom);
                        } //End block
                        {
                            left = Math.min(left, params.mLeft - params.leftMargin);
                            top = Math.min(top, params.mTop - params.topMargin);
                        } //End block
                        {
                            right = Math.max(right, params.mRight + params.rightMargin);
                            bottom = Math.max(bottom, params.mBottom + params.bottomMargin);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            {
                int i;
                i = 0;
                {
                    View child;
                    child = getChildAt(i);
                    {
                        boolean varACB49BF1319C5CFA15A5D6A72CCBFBDB_170768559 = (child.getVisibility() != GONE);
                        {
                            LayoutParams params;
                            params = (LayoutParams) child.getLayoutParams();
                            alignBaseline(child, params);
                            {
                                left = Math.min(left, params.mLeft - params.leftMargin);
                                top = Math.min(top, params.mTop - params.topMargin);
                            } //End block
                            {
                                right = Math.max(right, params.mRight + params.rightMargin);
                                bottom = Math.max(bottom, params.mBottom + params.bottomMargin);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            width += mPaddingRight;
            {
                width = Math.max(width, mLayoutParams.width);
            } //End block
            width = Math.max(width, getSuggestedMinimumWidth());
            width = resolveSize(width, widthMeasureSpec);
            {
                {
                    int i;
                    i = 0;
                    {
                        View child;
                        child = getChildAt(i);
                        {
                            boolean var9C6E2C1B9CB3A34CE46D1781E75F2F00_1352413549 = (child.getVisibility() != GONE);
                            {
                                LayoutParams params;
                                params = (LayoutParams) child.getLayoutParams();
                                int[] rules;
                                rules = params.getRules();
                                {
                                    centerHorizontal(child, params, width);
                                } //End block
                                {
                                    int childWidth;
                                    childWidth = child.getMeasuredWidth();
                                    params.mLeft = width - mPaddingRight - childWidth;
                                    params.mRight = params.mLeft + childWidth;
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            height += mPaddingBottom;
            {
                height = Math.max(height, mLayoutParams.height);
            } //End block
            height = Math.max(height, getSuggestedMinimumHeight());
            height = resolveSize(height, heightMeasureSpec);
            {
                {
                    int i;
                    i = 0;
                    {
                        View child;
                        child = getChildAt(i);
                        {
                            boolean var9C6E2C1B9CB3A34CE46D1781E75F2F00_330183152 = (child.getVisibility() != GONE);
                            {
                                LayoutParams params;
                                params = (LayoutParams) child.getLayoutParams();
                                int[] rules;
                                rules = params.getRules();
                                {
                                    centerVertical(child, params, height);
                                } //End block
                                {
                                    int childHeight;
                                    childHeight = child.getMeasuredHeight();
                                    params.mTop = height - mPaddingBottom - childHeight;
                                    params.mBottom = params.mTop + childHeight;
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            Rect selfBounds;
            selfBounds = mSelfBounds;
            selfBounds.set(mPaddingLeft, mPaddingTop, width - mPaddingRight,
                    height - mPaddingBottom);
            Rect contentBounds;
            contentBounds = mContentBounds;
            int layoutDirection;
            layoutDirection = getResolvedLayoutDirection();
            Gravity.apply(mGravity, right - left, bottom - top, selfBounds, contentBounds,
                    layoutDirection);
            int horizontalOffset;
            horizontalOffset = contentBounds.left - left;
            int verticalOffset;
            verticalOffset = contentBounds.top - top;
            {
                {
                    int i;
                    i = 0;
                    {
                        View child;
                        child = getChildAt(i);
                        {
                            boolean var382F74F421BA4E53BFCB9C654B764310_293547107 = (child.getVisibility() != GONE && child != ignore);
                            {
                                LayoutParams params;
                                params = (LayoutParams) child.getLayoutParams();
                                {
                                    params.mLeft += horizontalOffset;
                                    params.mRight += horizontalOffset;
                                } //End block
                                {
                                    params.mTop += verticalOffset;
                                    params.mBottom += verticalOffset;
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        setMeasuredDimension(width, height);
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.414 -0400", hash_original_method = "572E26DE16208C5960AF0F468C9CEB6F", hash_generated_method = "917C3023BE3BBDFF7B5FD93BFC273223")
    private void alignBaseline(View child, LayoutParams params) {
        int[] rules;
        rules = params.getRules();
        int anchorBaseline;
        anchorBaseline = getRelatedViewBaseline(rules, ALIGN_BASELINE);
        {
            LayoutParams anchorParams;
            anchorParams = getRelatedViewParams(rules, ALIGN_BASELINE);
            {
                int offset;
                offset = anchorParams.mTop + anchorBaseline;
                int baseline;
                baseline = child.getBaseline();
                {
                    offset -= baseline;
                } //End block
                int height;
                height = params.mBottom - params.mTop;
                params.mTop = offset;
                params.mBottom = params.mTop + height;
            } //End block
        } //End block
        {
            mBaselineView = child;
        } //End block
        {
            LayoutParams lp;
            lp = (LayoutParams) mBaselineView.getLayoutParams();
            {
                mBaselineView = child;
            } //End block
        } //End block
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.414 -0400", hash_original_method = "6FAB1FA940C67F7A3A04C20DF403CDD7", hash_generated_method = "CD2A897C89C6122781FB18F6C0717FEC")
    private void measureChild(View child, LayoutParams params, int myWidth, int myHeight) {
        int childWidthMeasureSpec;
        childWidthMeasureSpec = getChildMeasureSpec(params.mLeft,
                params.mRight, params.width,
                params.leftMargin, params.rightMargin,
                mPaddingLeft, mPaddingRight,
                myWidth);
        int childHeightMeasureSpec;
        childHeightMeasureSpec = getChildMeasureSpec(params.mTop,
                params.mBottom, params.height,
                params.topMargin, params.bottomMargin,
                mPaddingTop, mPaddingBottom,
                myHeight);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        addTaint(myWidth);
        addTaint(myHeight);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.415 -0400", hash_original_method = "C649DEFF309C12811323B81F575C7972", hash_generated_method = "D18D6A310FD5C5F017F89916810C8E4E")
    private void measureChildHorizontal(View child, LayoutParams params, int myWidth, int myHeight) {
        int childWidthMeasureSpec;
        childWidthMeasureSpec = getChildMeasureSpec(params.mLeft,
                params.mRight, params.width,
                params.leftMargin, params.rightMargin,
                mPaddingLeft, mPaddingRight,
                myWidth);
        int childHeightMeasureSpec;
        {
            childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(myHeight, MeasureSpec.EXACTLY);
        } //End block
        {
            childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(myHeight, MeasureSpec.AT_MOST);
        } //End block
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        addTaint(myWidth);
        addTaint(myHeight);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.416 -0400", hash_original_method = "78354A3A0D2C9A2AC648B99E7333EDDC", hash_generated_method = "9C9FDC45B60969EF1E8A108CD5D07E03")
    private int getChildMeasureSpec(int childStart, int childEnd,
            int childSize, int startMargin, int endMargin, int startPadding,
            int endPadding, int mySize) {
        int childSpecMode;
        childSpecMode = 0;
        int childSpecSize;
        childSpecSize = 0;
        int tempStart;
        tempStart = childStart;
        int tempEnd;
        tempEnd = childEnd;
        {
            tempStart = startPadding + startMargin;
        } //End block
        {
            tempEnd = mySize - endPadding - endMargin;
        } //End block
        int maxAvailable;
        maxAvailable = tempEnd - tempStart;
        {
            childSpecMode = MeasureSpec.EXACTLY;
            childSpecSize = maxAvailable;
        } //End block
        {
            {
                childSpecMode = MeasureSpec.EXACTLY;
                {
                    childSpecSize = Math.min(maxAvailable, childSize);
                } //End block
                {
                    childSpecSize = childSize;
                } //End block
            } //End block
            {
                childSpecMode = MeasureSpec.EXACTLY;
                childSpecSize = maxAvailable;
            } //End block
            {
                {
                    childSpecMode = MeasureSpec.AT_MOST;
                    childSpecSize = maxAvailable;
                } //End block
                {
                    childSpecMode = MeasureSpec.UNSPECIFIED;
                    childSpecSize = 0;
                } //End block
            } //End block
        } //End block
        int varCF7E02B354BBF9C3C60EFC9675543EF2_1765606274 = (MeasureSpec.makeMeasureSpec(childSpecSize, childSpecMode));
        addTaint(childStart);
        addTaint(childEnd);
        addTaint(childSize);
        addTaint(startMargin);
        addTaint(endMargin);
        addTaint(startPadding);
        addTaint(endPadding);
        addTaint(mySize);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1342401039 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1342401039;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.426 -0400", hash_original_method = "B9478380B54B111B46A13309CA4FBB39", hash_generated_method = "1C95BFF0861D286C68A059B8071B902E")
    private boolean positionChildHorizontal(View child, LayoutParams params, int myWidth,
            boolean wrapContent) {
        int[] rules;
        rules = params.getRules();
        {
            params.mLeft = params.mRight - child.getMeasuredWidth();
        } //End block
        {
            params.mRight = params.mLeft + child.getMeasuredWidth();
        } //End block
        {
            {
                {
                    centerHorizontal(child, params, myWidth);
                } //End block
                {
                    params.mLeft = mPaddingLeft + params.leftMargin;
                    params.mRight = params.mLeft + child.getMeasuredWidth();
                } //End block
            } //End block
            {
                params.mLeft = mPaddingLeft + params.leftMargin;
                params.mRight = params.mLeft + child.getMeasuredWidth();
            } //End block
        } //End block
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        addTaint(myWidth);
        addTaint(wrapContent);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1829554760 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1829554760;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.427 -0400", hash_original_method = "09EB493CF05E8E659EC89F37304CD399", hash_generated_method = "E7AACF9F98D96AB17B9EDF50ADE1938E")
    private boolean positionChildVertical(View child, LayoutParams params, int myHeight,
            boolean wrapContent) {
        int[] rules;
        rules = params.getRules();
        {
            params.mTop = params.mBottom - child.getMeasuredHeight();
        } //End block
        {
            params.mBottom = params.mTop + child.getMeasuredHeight();
        } //End block
        {
            {
                {
                    centerVertical(child, params, myHeight);
                } //End block
                {
                    params.mTop = mPaddingTop + params.topMargin;
                    params.mBottom = params.mTop + child.getMeasuredHeight();
                } //End block
            } //End block
            {
                params.mTop = mPaddingTop + params.topMargin;
                params.mBottom = params.mTop + child.getMeasuredHeight();
            } //End block
        } //End block
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        addTaint(myHeight);
        addTaint(wrapContent);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_648583067 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_648583067;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.432 -0400", hash_original_method = "C61E9BCFF76D7B76D77F18D001923EFF", hash_generated_method = "E83AFF4EE2441A8CA68B6B44FD39A076")
    private void applyHorizontalSizeRules(LayoutParams childParams, int myWidth) {
        int[] rules;
        rules = childParams.getRules();
        RelativeLayout.LayoutParams anchorParams;
        childParams.mLeft = -1;
        childParams.mRight = -1;
        anchorParams = getRelatedViewParams(rules, LEFT_OF);
        {
            childParams.mRight = anchorParams.mLeft - (anchorParams.leftMargin +
                    childParams.rightMargin);
        } //End block
        {
            {
                childParams.mRight = myWidth - mPaddingRight - childParams.rightMargin;
            } //End block
        } //End block
        anchorParams = getRelatedViewParams(rules, RIGHT_OF);
        {
            childParams.mLeft = anchorParams.mRight + (anchorParams.rightMargin +
                    childParams.leftMargin);
        } //End block
        {
            childParams.mLeft = mPaddingLeft + childParams.leftMargin;
        } //End block
        anchorParams = getRelatedViewParams(rules, ALIGN_LEFT);
        {
            childParams.mLeft = anchorParams.mLeft + childParams.leftMargin;
        } //End block
        {
            childParams.mLeft = mPaddingLeft + childParams.leftMargin;
        } //End block
        anchorParams = getRelatedViewParams(rules, ALIGN_RIGHT);
        {
            childParams.mRight = anchorParams.mRight - childParams.rightMargin;
        } //End block
        {
            {
                childParams.mRight = myWidth - mPaddingRight - childParams.rightMargin;
            } //End block
        } //End block
        {
            childParams.mLeft = mPaddingLeft + childParams.leftMargin;
        } //End block
        {
            {
                childParams.mRight = myWidth - mPaddingRight - childParams.rightMargin;
            } //End block
        } //End block
        addTaint(childParams.getTaint());
        addTaint(myWidth);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.512 -0400", hash_original_method = "B3DE38D6CE01D7E90C154524E3D3CC84", hash_generated_method = "079A95C861CF0C79A365804A433736E8")
    private void applyVerticalSizeRules(LayoutParams childParams, int myHeight) {
        int[] rules;
        rules = childParams.getRules();
        RelativeLayout.LayoutParams anchorParams;
        childParams.mTop = -1;
        childParams.mBottom = -1;
        anchorParams = getRelatedViewParams(rules, ABOVE);
        {
            childParams.mBottom = anchorParams.mTop - (anchorParams.topMargin +
                    childParams.bottomMargin);
        } //End block
        {
            {
                childParams.mBottom = myHeight - mPaddingBottom - childParams.bottomMargin;
            } //End block
        } //End block
        anchorParams = getRelatedViewParams(rules, BELOW);
        {
            childParams.mTop = anchorParams.mBottom + (anchorParams.bottomMargin +
                    childParams.topMargin);
        } //End block
        {
            childParams.mTop = mPaddingTop + childParams.topMargin;
        } //End block
        anchorParams = getRelatedViewParams(rules, ALIGN_TOP);
        {
            childParams.mTop = anchorParams.mTop + childParams.topMargin;
        } //End block
        {
            childParams.mTop = mPaddingTop + childParams.topMargin;
        } //End block
        anchorParams = getRelatedViewParams(rules, ALIGN_BOTTOM);
        {
            childParams.mBottom = anchorParams.mBottom - childParams.bottomMargin;
        } //End block
        {
            {
                childParams.mBottom = myHeight - mPaddingBottom - childParams.bottomMargin;
            } //End block
        } //End block
        {
            childParams.mTop = mPaddingTop + childParams.topMargin;
        } //End block
        {
            {
                childParams.mBottom = myHeight - mPaddingBottom - childParams.bottomMargin;
            } //End block
        } //End block
        {
            mHasBaselineAlignedChild = true;
        } //End block
        addTaint(childParams.getTaint());
        addTaint(myHeight);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.513 -0400", hash_original_method = "1C833E1C2ADE997D1187353BA16BCE70", hash_generated_method = "314A07808C22DF49203C665D0F2D5AFB")
    private View getRelatedView(int[] rules, int relation) {
        View varB4EAC82CA7396A68D541C85D26508E83_312585177 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_56940615 = null; //Variable for return #2
        View varB4EAC82CA7396A68D541C85D26508E83_359691791 = null; //Variable for return #3
        View varB4EAC82CA7396A68D541C85D26508E83_2100388491 = null; //Variable for return #4
        int id;
        id = rules[relation];
        {
            DependencyGraph.Node node;
            node = mGraph.mKeyNodes.get(id);
            varB4EAC82CA7396A68D541C85D26508E83_312585177 = null;
            View v;
            v = node.view;
            {
                boolean var72B3FB78D7E500F7F9E9259DA85F2263_1255848095 = (v.getVisibility() == View.GONE);
                {
                    rules = ((LayoutParams) v.getLayoutParams()).getRules();
                    node = mGraph.mKeyNodes.get((rules[relation]));
                    varB4EAC82CA7396A68D541C85D26508E83_56940615 = null;
                    v = node.view;
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_359691791 = v;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2100388491 = null;
        addTaint(rules[0]);
        addTaint(relation);
        View varA7E53CE21691AB073D9660D615818899_380430625; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_380430625 = varB4EAC82CA7396A68D541C85D26508E83_312585177;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_380430625 = varB4EAC82CA7396A68D541C85D26508E83_56940615;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_380430625 = varB4EAC82CA7396A68D541C85D26508E83_359691791;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_380430625 = varB4EAC82CA7396A68D541C85D26508E83_2100388491;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_380430625.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_380430625;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.514 -0400", hash_original_method = "1432C4369AF9849456CCA14753707552", hash_generated_method = "41B7C5FE2510F592DFF6518E61FC71DF")
    private LayoutParams getRelatedViewParams(int[] rules, int relation) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_2141692538 = null; //Variable for return #1
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_2049261431 = null; //Variable for return #2
        View v;
        v = getRelatedView(rules, relation);
        {
            ViewGroup.LayoutParams params;
            params = v.getLayoutParams();
            {
                varB4EAC82CA7396A68D541C85D26508E83_2141692538 = (LayoutParams) v.getLayoutParams();
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2049261431 = null;
        addTaint(rules[0]);
        addTaint(relation);
        LayoutParams varA7E53CE21691AB073D9660D615818899_898797754; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_898797754 = varB4EAC82CA7396A68D541C85D26508E83_2141692538;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_898797754 = varB4EAC82CA7396A68D541C85D26508E83_2049261431;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_898797754.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_898797754;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.516 -0400", hash_original_method = "B96AFAE3C58D6FFF0F9AB9328789A20B", hash_generated_method = "016C60B1927719C7F429C880B6C3A93D")
    private int getRelatedViewBaseline(int[] rules, int relation) {
        View v;
        v = getRelatedView(rules, relation);
        {
            int varBFAAD9EEB54C80D14BB04F7DBAE3674A_302861338 = (v.getBaseline());
        } //End block
        addTaint(rules[0]);
        addTaint(relation);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1474737017 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1474737017;
        // ---------- Original Method ----------
        //View v = getRelatedView(rules, relation);
        //if (v != null) {
            //return v.getBaseline();
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.517 -0400", hash_original_method = "8A1AB6E076A6FFB22058EEC6C343479D", hash_generated_method = "2FDB31B64B25EC4460F95285F39139CE")
    private void centerHorizontal(View child, LayoutParams params, int myWidth) {
        int childWidth;
        childWidth = child.getMeasuredWidth();
        int left;
        left = (myWidth - childWidth) / 2;
        params.mLeft = left;
        params.mRight = left + childWidth;
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        addTaint(myWidth);
        // ---------- Original Method ----------
        //int childWidth = child.getMeasuredWidth();
        //int left = (myWidth - childWidth) / 2;
        //params.mLeft = left;
        //params.mRight = left + childWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.518 -0400", hash_original_method = "D7FF6A5DD857E80D590F5847BEDB8204", hash_generated_method = "2F1AE99714F20F0B6CE3AE263CA22E55")
    private void centerVertical(View child, LayoutParams params, int myHeight) {
        int childHeight;
        childHeight = child.getMeasuredHeight();
        int top;
        top = (myHeight - childHeight) / 2;
        params.mTop = top;
        params.mBottom = top + childHeight;
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        addTaint(myHeight);
        // ---------- Original Method ----------
        //int childHeight = child.getMeasuredHeight();
        //int top = (myHeight - childHeight) / 2;
        //params.mTop = top;
        //params.mBottom = top + childHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.526 -0400", hash_original_method = "05FEBBF616C51C2D421358B4A05D22CE", hash_generated_method = "C4345358B20B11FFAF0573FC6A475A31")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int count;
        count = getChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_852984345 = (child.getVisibility() != GONE);
                    {
                        RelativeLayout.LayoutParams st;
                        st = (RelativeLayout.LayoutParams) child.getLayoutParams();
                        child.layout(st.mLeft, st.mTop, st.mRight, st.mBottom);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(changed);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.531 -0400", hash_original_method = "233CD3CEF6FDC0096CEB70C074DAEDA3", hash_generated_method = "4FD3AAC4A328775A5459DE8A29347BA4")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1979991202 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1979991202 = new RelativeLayout.LayoutParams(getContext(), attrs);
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1979991202.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1979991202;
        // ---------- Original Method ----------
        //return new RelativeLayout.LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.532 -0400", hash_original_method = "9A6A2F1616AFA891B0951E317B143439", hash_generated_method = "8F7C90E62F92438AC91A2A6ED4F7F288")
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1244883827 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1244883827 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        varB4EAC82CA7396A68D541C85D26508E83_1244883827.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1244883827;
        // ---------- Original Method ----------
        //return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.542 -0400", hash_original_method = "7AAD3A1C062434D08215151012F2CF47", hash_generated_method = "52B5D82F7B5D57ED0B17C3B6E82FFF7A")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1336664756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1336664756;
        // ---------- Original Method ----------
        //return p instanceof RelativeLayout.LayoutParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.543 -0400", hash_original_method = "B595E0482905B38051CD63239BB5F8BA", hash_generated_method = "1D4CBA96900AFF0EE3A0071442B80944")
    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1188499059 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1188499059 = new LayoutParams(p);
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1188499059.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1188499059;
        // ---------- Original Method ----------
        //return new LayoutParams(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.595 -0400", hash_original_method = "02980C12A71A151B5687E23560D62A05", hash_generated_method = "E4EF2A0465F347D5E1080E6D6BA113EE")
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        {
            mTopToBottomLeftToRightSet = new TreeSet<View>(new TopToBottomLeftToRightComparator());
        } //End block
        {
            int i, count;
            i = 0;
            count = getChildCount();
            {
                mTopToBottomLeftToRightSet.add(getChildAt(i));
            } //End block
        } //End collapsed parenthetic
        {
            Iterator<View> var533C624396C561AA162C41D307444EBC_75908979 = (mTopToBottomLeftToRightSet).iterator();
            var533C624396C561AA162C41D307444EBC_75908979.hasNext();
            View view = var533C624396C561AA162C41D307444EBC_75908979.next();
            {
                {
                    boolean var7C0A1D725855D863393CAE05FD961B09_83629002 = (view.getVisibility() == View.VISIBLE
                    && view.dispatchPopulateAccessibilityEvent(event));
                    {
                        mTopToBottomLeftToRightSet.clear();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mTopToBottomLeftToRightSet.clear();
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_382482602 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_382482602;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.595 -0400", hash_original_method = "32220C1DAB888BE59E67ED1F2F5003D8", hash_generated_method = "32220C1DAB888BE59E67ED1F2F5003D8")
        public TopToBottomLeftToRightComparator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.605 -0400", hash_original_method = "A3AAE4860228E849F39A667518F04B9E", hash_generated_method = "A2F7184E0FF651AC8F2EE07FE267A800")
        public int compare(View first, View second) {
            int topDifference;
            topDifference = first.getTop() - second.getTop();
            int leftDifference;
            leftDifference = first.getLeft() - second.getLeft();
            int heightDiference;
            heightDiference = first.getHeight() - second.getHeight();
            int widthDiference;
            widthDiference = first.getWidth() - second.getWidth();
            addTaint(first.getTaint());
            addTaint(second.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_954987606 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_954987606;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.614 -0400", hash_original_field = "88F74427B9E2F7D924182ECC7F0BA0E3", hash_generated_field = "138597A9D627AA60011D0A51DCF0C547")

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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.615 -0400", hash_original_field = "B5B776A6642DD69B16A47E6FCCAEEB6E", hash_generated_field = "AB08F003659B306A95990D148DDB5C29")

        private int mLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.615 -0400", hash_original_field = "D09DA346C6637C81F0228C8D0347388B", hash_generated_field = "B14441554FAC41961538E028958B2C0C")

        private int mTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.615 -0400", hash_original_field = "720807298C0DE3DCF41AEC725F26A5A1", hash_generated_field = "C26B1BDD0746218442C7F597FAB6F7D0")

        private int mRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.615 -0400", hash_original_field = "2FFD20D7E48915664FDF7F12FC3889D8", hash_generated_field = "4AF6ECE77AC654346D9C0CD81051EB99")

        private int mBottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.615 -0400", hash_original_field = "AC3033727FC96920DD8731A89FE8AF20", hash_generated_field = "666873D7B6DA8C6785E6C7DFC911FFA3")

        @ViewDebug.ExportedProperty(category = "layout") public boolean alignWithParent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.617 -0400", hash_original_method = "A3B36B82744E08B8B1AFF03A4315BD99", hash_generated_method = "5687D76710961879E2DFF0B567AED657")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a;
            a = c.obtainStyledAttributes(attrs,
                    com.android.internal.R.styleable.RelativeLayout_Layout);
            int[] rules;
            rules = mRules;
            int N;
            N = a.getIndexCount();
            {
                int i;
                i = 0;
                {
                    int attr;
                    attr = a.getIndex(i);
                    //Begin case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignWithParentIfMissing 
                    alignWithParent = a.getBoolean(attr, false);
                    //End case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignWithParentIfMissing 
                    //Begin case com.android.internal.R.styleable.RelativeLayout_Layout_layout_toLeftOf 
                    rules[LEFT_OF] = a.getResourceId(attr, 0);
                    //End case com.android.internal.R.styleable.RelativeLayout_Layout_layout_toLeftOf 
                    //Begin case com.android.internal.R.styleable.RelativeLayout_Layout_layout_toRightOf 
                    rules[RIGHT_OF] = a.getResourceId(attr, 0);
                    //End case com.android.internal.R.styleable.RelativeLayout_Layout_layout_toRightOf 
                    //Begin case com.android.internal.R.styleable.RelativeLayout_Layout_layout_above 
                    rules[ABOVE] = a.getResourceId(attr, 0);
                    //End case com.android.internal.R.styleable.RelativeLayout_Layout_layout_above 
                    //Begin case com.android.internal.R.styleable.RelativeLayout_Layout_layout_below 
                    rules[BELOW] = a.getResourceId(attr, 0);
                    //End case com.android.internal.R.styleable.RelativeLayout_Layout_layout_below 
                    //Begin case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignBaseline 
                    rules[ALIGN_BASELINE] = a.getResourceId(attr, 0);
                    //End case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignBaseline 
                    //Begin case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignLeft 
                    rules[ALIGN_LEFT] = a.getResourceId(attr, 0);
                    //End case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignLeft 
                    //Begin case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignTop 
                    rules[ALIGN_TOP] = a.getResourceId(attr, 0);
                    //End case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignTop 
                    //Begin case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignRight 
                    rules[ALIGN_RIGHT] = a.getResourceId(attr, 0);
                    //End case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignRight 
                    //Begin case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignBottom 
                    rules[ALIGN_BOTTOM] = a.getResourceId(attr, 0);
                    //End case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignBottom 
                    //Begin case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignParentLeft 
                    rules[ALIGN_PARENT_LEFT] = a.getBoolean(attr, false) ? TRUE : 0;
                    //End case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignParentLeft 
                    //Begin case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignParentTop 
                    rules[ALIGN_PARENT_TOP] = a.getBoolean(attr, false) ? TRUE : 0;
                    //End case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignParentTop 
                    //Begin case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignParentRight 
                    rules[ALIGN_PARENT_RIGHT] = a.getBoolean(attr, false) ? TRUE : 0;
                    //End case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignParentRight 
                    //Begin case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignParentBottom 
                    rules[ALIGN_PARENT_BOTTOM] = a.getBoolean(attr, false) ? TRUE : 0;
                    //End case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignParentBottom 
                    //Begin case com.android.internal.R.styleable.RelativeLayout_Layout_layout_centerInParent 
                    rules[CENTER_IN_PARENT] = a.getBoolean(attr, false) ? TRUE : 0;
                    //End case com.android.internal.R.styleable.RelativeLayout_Layout_layout_centerInParent 
                    //Begin case com.android.internal.R.styleable.RelativeLayout_Layout_layout_centerHorizontal 
                    rules[CENTER_HORIZONTAL] = a.getBoolean(attr, false) ? TRUE : 0;
                    //End case com.android.internal.R.styleable.RelativeLayout_Layout_layout_centerHorizontal 
                    //Begin case com.android.internal.R.styleable.RelativeLayout_Layout_layout_centerVertical 
                    rules[CENTER_VERTICAL] = a.getBoolean(attr, false) ? TRUE : 0;
                    //End case com.android.internal.R.styleable.RelativeLayout_Layout_layout_centerVertical 
                } //End block
            } //End collapsed parenthetic
            a.recycle();
            addTaint(c.getTaint());
            addTaint(attrs.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.618 -0400", hash_original_method = "979C42732F8B715475115A738CE7596D", hash_generated_method = "A0678A9E2024BFE51CD3F973D466AEAF")
        public  LayoutParams(int w, int h) {
            super(w, h);
            addTaint(w);
            addTaint(h);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.618 -0400", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "37A5DBEF9177864A03971A9D81D7D3EE")
        public  LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.621 -0400", hash_original_method = "600A366FF17B7D40DFA738E77A628E8F", hash_generated_method = "B2D13AC5BD03A134B95617DAFA8D7AF6")
        public  LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.622 -0400", hash_original_method = "E4ABE7598543A22DA450A925C25FFDEA", hash_generated_method = "E80E9A2AB420BA31E54A0C6FED7F2A17")
        @Override
        public String debug(String output) {
            String varB4EAC82CA7396A68D541C85D26508E83_2063613419 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2063613419 = output + "ViewGroup.LayoutParams={ width=" + sizeToString(width) +
                    ", height=" + sizeToString(height) + " }";
            addTaint(output.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2063613419.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2063613419;
            // ---------- Original Method ----------
            //return output + "ViewGroup.LayoutParams={ width=" + sizeToString(width) +
                    //", height=" + sizeToString(height) + " }";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.622 -0400", hash_original_method = "F14B7CDC14D112CF9F86D0C64F4D29ED", hash_generated_method = "93452E0A48B7041D6E93F6CB23E7C08D")
        public void addRule(int verb) {
            mRules[verb] = TRUE;
            // ---------- Original Method ----------
            //mRules[verb] = TRUE;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.629 -0400", hash_original_method = "E6336A158C939972C1CFCFE234B123CF", hash_generated_method = "15C34D41A65E9FA80EF1B69E592566CD")
        public void addRule(int verb, int anchor) {
            mRules[verb] = anchor;
            // ---------- Original Method ----------
            //mRules[verb] = anchor;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.631 -0400", hash_original_method = "42AF2398E9BA5CDF378E196E0674D4AF", hash_generated_method = "7827E67DA2B474CDD1DDD4B657583D23")
        public int[] getRules() {
            int[] varB4CCCA26F9DB9189C32F33E82D425CFB_435764164 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_435764164;
            // ---------- Original Method ----------
            //return mRules;
        }

        
    }


    
    private static class DependencyGraph {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.631 -0400", hash_original_field = "DB82967F5D06BF98EFB4ACBA027F7402", hash_generated_field = "1B3148FB5A2450DADCF9B3CB97C1D5E0")

        private ArrayList<Node> mNodes = new ArrayList<Node>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.631 -0400", hash_original_field = "1C1B3D8C2FB6A40BED49CA5117064AD5", hash_generated_field = "060FE5603F47B674AFC0F0792F7CB200")

        private SparseArray<Node> mKeyNodes = new SparseArray<Node>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.631 -0400", hash_original_field = "1E43BF04D9AA2FB180EB6CB5F6659D68", hash_generated_field = "249978BD32E42A0796E8254A85A11B49")

        private LinkedList<Node> mRoots = new LinkedList<Node>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.631 -0400", hash_original_method = "970FB9BC48F419CD4D1512AB366BD03A", hash_generated_method = "970FB9BC48F419CD4D1512AB366BD03A")
        public DependencyGraph ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.632 -0400", hash_original_method = "686A3AF8289E33425B30BEC25704B03B", hash_generated_method = "21C851968006955EA2C59EE149CDBCA0")
         void clear() {
            ArrayList<Node> nodes;
            nodes = mNodes;
            int count;
            count = nodes.size();
            {
                int i;
                i = 0;
                {
                    nodes.get(i).release();
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.637 -0400", hash_original_method = "2AE2D90F3BED583D61A7D72DDE9D78E7", hash_generated_method = "E19D514FAA5DEB49C2CE06CEC87ADD88")
         void add(View view) {
            int id;
            id = view.getId();
            Node node;
            node = Node.acquire(view);
            {
                mKeyNodes.put(id, node);
            } //End block
            mNodes.add(node);
            addTaint(view.getTaint());
            // ---------- Original Method ----------
            //final int id = view.getId();
            //final Node node = Node.acquire(view);
            //if (id != View.NO_ID) {
                //mKeyNodes.put(id, node);
            //}
            //mNodes.add(node);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.666 -0400", hash_original_method = "A9C10EB6FA89DCA6CFC24E3AC1BF04E7", hash_generated_method = "F2A11AC8C0F31D620DB3203F6A3A47B5")
         void getSortedViews(View[] sorted, int... rules) {
            LinkedList<Node> roots;
            roots = findRoots(rules);
            int index;
            index = 0;
            {
                boolean varD630A3AB67E7A5775827EF03845CAC5C_257875662 = (roots.size() > 0);
                {
                    Node node;
                    node = roots.removeFirst();
                    View view;
                    view = node.view;
                    int key;
                    key = view.getId();
                    sorted[index++] = view;
                    HashSet<Node> dependents;
                    dependents = node.dependents;
                    {
                        Iterator<Node> var0C52FBC8D9B182836C536A5F60F7826A_181756200 = (dependents).iterator();
                        var0C52FBC8D9B182836C536A5F60F7826A_181756200.hasNext();
                        Node dependent = var0C52FBC8D9B182836C536A5F60F7826A_181756200.next();
                        {
                            SparseArray<Node> dependencies;
                            dependencies = dependent.dependencies;
                            dependencies.remove(key);
                            {
                                boolean varBE2B4F04D91A59A08789366480C2B5BD_855235127 = (dependencies.size() == 0);
                                {
                                    roots.add(dependent);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Circular dependencies cannot exist"
                        + " in RelativeLayout");
            } //End block
            addTaint(sorted[0].getTaint());
            addTaint(rules[0]);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.685 -0400", hash_original_method = "3833904997A1288F1E7950B84718C1E5", hash_generated_method = "1F81825099D2F0D19D05F5BFF414DB11")
        private LinkedList<Node> findRoots(int[] rulesFilter) {
            LinkedList<Node> varB4EAC82CA7396A68D541C85D26508E83_1960202820 = null; //Variable for return #1
            SparseArray<Node> keyNodes;
            keyNodes = mKeyNodes;
            ArrayList<Node> nodes;
            nodes = mNodes;
            int count;
            count = nodes.size();
            {
                int i;
                i = 0;
                {
                    Node node;
                    node = nodes.get(i);
                    node.dependents.clear();
                    node.dependencies.clear();
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = 0;
                {
                    Node node;
                    node = nodes.get(i);
                    LayoutParams layoutParams;
                    layoutParams = (LayoutParams) node.view.getLayoutParams();
                    int[] rules;
                    rules = layoutParams.mRules;
                    int rulesCount;
                    rulesCount = rulesFilter.length;
                    {
                        int j;
                        j = 0;
                        {
                            int rule;
                            rule = rules[rulesFilter[j]];
                            {
                                Node dependency;
                                dependency = keyNodes.get(rule);
                                dependency.dependents.add(node);
                                node.dependencies.put(rule, dependency);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            LinkedList<Node> roots;
            roots = mRoots;
            roots.clear();
            {
                int i;
                i = 0;
                {
                    Node node;
                    node = nodes.get(i);
                    {
                        boolean var5E6FEE9956DF9683C1D4121BDE382F81_1661151311 = (node.dependencies.size() == 0);
                        roots.add(node);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1960202820 = roots;
            addTaint(rulesFilter[0]);
            varB4EAC82CA7396A68D541C85D26508E83_1960202820.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1960202820;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.699 -0400", hash_original_method = "6C6DA74626C9CD8B150D67A2E9AEA5BB", hash_generated_method = "A7F7D20252B1FB641BBA8510B93BAFB5")
         void log(Resources resources, int... rules) {
            LinkedList<Node> roots;
            roots = findRoots(rules);
            {
                Iterator<Node> var7DBAABE4E7F879D93D2EDA1D53070AED_1034159702 = (roots).iterator();
                var7DBAABE4E7F879D93D2EDA1D53070AED_1034159702.hasNext();
                Node node = var7DBAABE4E7F879D93D2EDA1D53070AED_1034159702.next();
                {
                    printNode(resources, node);
                } //End block
            } //End collapsed parenthetic
            addTaint(resources.getTaint());
            addTaint(rules[0]);
            // ---------- Original Method ----------
            //final LinkedList<Node> roots = findRoots(rules);
            //for (Node node : roots) {
                //printNode(resources, node);
            //}
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
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.713 -0400", hash_original_field = "1BDA80F2BE4D3658E0BAA43FBE7AE8C1", hash_generated_field = "203A52904F64FA8CF6CE15F1E8FE3025")

            View view;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.713 -0400", hash_original_field = "E45EE0A3360491972145435FEA221205", hash_generated_field = "15404FAB3E19CCE5CED42FA586FF679D")

            HashSet<Node> dependents = new HashSet<Node>();
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.717 -0400", hash_original_field = "D360F8069C7C16E4E73F95B33F2F9896", hash_generated_field = "51D91DD50794A2AD7CC8B731763D84F6")

            SparseArray<Node> dependencies = new SparseArray<Node>();
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.717 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "0A1E5AFC0BA7AE75B487CB8ED7E2A9F4")

            private Node mNext;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.717 -0400", hash_original_field = "224D05F4261498DA1D9DF38424832532", hash_generated_field = "BD952C5DD2D86B34B4D5F4AFE196E837")

            private boolean mIsPooled;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.717 -0400", hash_original_method = "4AE6680246A461A411C2DCFC3E5C235E", hash_generated_method = "4AE6680246A461A411C2DCFC3E5C235E")
            public Node ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.719 -0400", hash_original_method = "A08BF9EBBE4B2747346D150314791002", hash_generated_method = "2FE07B58E0CD5DBB314046E4692100A0")
            public void setNextPoolable(Node element) {
                mNext = element;
                // ---------- Original Method ----------
                //mNext = element;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.720 -0400", hash_original_method = "3B74D9DA1E659E0940912A17ED2BA31C", hash_generated_method = "D443D87D5860607A484374596983ECC6")
            public Node getNextPoolable() {
                Node varB4EAC82CA7396A68D541C85D26508E83_34680557 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_34680557 = mNext;
                varB4EAC82CA7396A68D541C85D26508E83_34680557.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_34680557;
                // ---------- Original Method ----------
                //return mNext;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.720 -0400", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "2A0FB35C2B062D59CF3809D32FECC949")
            public boolean isPooled() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2064188439 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2064188439;
                // ---------- Original Method ----------
                //return mIsPooled;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.726 -0400", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "31CEC37D69D770078DC2E4A0F4797B2A")
            public void setPooled(boolean isPooled) {
                mIsPooled = isPooled;
                // ---------- Original Method ----------
                //mIsPooled = isPooled;
            }

            
                        static Node acquire(View view) {
                final Node node = sPool.acquire();
                node.view = view;
                return node;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.726 -0400", hash_original_method = "4A4B6653C3D2EF8B0AE5BB1353D36229", hash_generated_method = "01DCF22208A7B01047CEF53A1A4F2C6E")
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

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.726 -0400", hash_original_field = "3303CE2CA63B453A0428C68DAD3EFE33", hash_generated_field = "0F953346D09D8553E237E558FD8325F3")

            private static int POOL_LIMIT = 100;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.726 -0400", hash_original_field = "698BA341680326808CDA69878C18B225", hash_generated_field = "360C0058C884D13B7CDAB299D07108C4")

            private static Pool<Node> sPool = Pools.synchronizedPool(
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
        }


        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.730 -0400", hash_original_field = "B81C9D25359AE819312506FB4D454B3C", hash_generated_field = "CB3EF54D2CFF070EF5985CA0F77E37DE")

    private static String LOG_TAG = "RelativeLayout";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.730 -0400", hash_original_field = "A4AD3F5C4B55E9BB91428ACB3F00EB8D", hash_generated_field = "62D8CD43E86056D155BEB83E8C10F507")

    private static boolean DEBUG_GRAPH = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.730 -0400", hash_original_field = "38E1112DF959C803A5554C727023AA17", hash_generated_field = "B2899320334F57908731E112E94F1CDE")

    public static final int TRUE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.730 -0400", hash_original_field = "0152EBE6648A1A849ABE5CCB369A5F61", hash_generated_field = "096208EA2AF3CC7E7141BFD38797A0EC")

    public static final int LEFT_OF                  = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.731 -0400", hash_original_field = "BC8A963608B08F83E18CF292ADCB1EF2", hash_generated_field = "3F8E96F44674079400E1FE6BBEE7D7E2")

    public static final int RIGHT_OF                 = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.731 -0400", hash_original_field = "A552BBF9EE1E682F7D687E2691837FAD", hash_generated_field = "B25BAD9E800E104591FBDEB68402C4D7")

    public static final int ABOVE                    = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.731 -0400", hash_original_field = "F830A844112A468573A1372D853A00F0", hash_generated_field = "C33F54ACAC005E4F7B577DF5ECD8B8CB")

    public static final int BELOW                    = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.731 -0400", hash_original_field = "565F53F1AF518E64110614AF5FDFCB2F", hash_generated_field = "0367429D50A8B97E51A0EA79D61E8341")

    public static final int ALIGN_BASELINE           = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.731 -0400", hash_original_field = "B400AB0A19AC559B655040F61D268739", hash_generated_field = "B08FA699BB0A7B8EE01E81D8523B06B8")

    public static final int ALIGN_LEFT               = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.737 -0400", hash_original_field = "74A2A03ABA276E34AB3C9322C33CDB50", hash_generated_field = "503D8ED8ADEFA09061443AB73E1105EB")

    public static final int ALIGN_TOP                = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.737 -0400", hash_original_field = "CDCCA2471B04431DDC51A918AD8834B6", hash_generated_field = "066A8ADE746ECE1F1116FA381AA46454")

    public static final int ALIGN_RIGHT              = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.737 -0400", hash_original_field = "3723503AA3BFD474E29708678D1AB7A3", hash_generated_field = "0F184873DB5DF31E2DCF140BE0923551")

    public static final int ALIGN_BOTTOM             = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.737 -0400", hash_original_field = "57EDC78D811DE81B14DD0D05A86F4D0D", hash_generated_field = "07136E510188D5E09CB6F7AA93561D06")

    public static final int ALIGN_PARENT_LEFT        = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.737 -0400", hash_original_field = "CE3851F8A5577E5BA49B2CB7B6BB878A", hash_generated_field = "0949503221E389CCE8FB0E1467A44822")

    public static final int ALIGN_PARENT_TOP         = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.737 -0400", hash_original_field = "4F39C7BC6D569B9912A6C401F5A04E01", hash_generated_field = "3EFDDDF20B46B24CC5FB727D20BD8554")

    public static final int ALIGN_PARENT_RIGHT       = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.737 -0400", hash_original_field = "38AA961AD0797B3EB35974B8D237E4DE", hash_generated_field = "82EE6CB558A3BB3B4C93A79C69887380")

    public static final int ALIGN_PARENT_BOTTOM      = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.737 -0400", hash_original_field = "A3DE69363031F50770D752E2DF01665D", hash_generated_field = "D045131D6C0978E01C7E1F593FBD0FC4")

    public static final int CENTER_IN_PARENT         = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.737 -0400", hash_original_field = "26070F6C6231ACEE59A596606E5D0FDA", hash_generated_field = "E7BDEFDBB1D8A752BEF0DA17BCC1DA06")

    public static final int CENTER_HORIZONTAL        = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.737 -0400", hash_original_field = "CE20BA373620FB57D0126DD228A7F498", hash_generated_field = "12CCDDB6CE0278C45C3ED35DE6FCDC8B")

    public static final int CENTER_VERTICAL          = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.737 -0400", hash_original_field = "DA3B5D996B18D578340E863FCDB56B8A", hash_generated_field = "E390F431268FF8561077407F5CCA1FE4")

    private static int VERB_COUNT = 16;
}

