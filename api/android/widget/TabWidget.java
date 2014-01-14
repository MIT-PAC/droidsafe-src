package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import com.android.internal.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class TabWidget extends LinearLayout implements OnFocusChangeListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.779 -0500", hash_original_field = "1DE038090B333F8057F27224589C1348", hash_generated_field = "817C5151F42461877F9DF1BDC22232EE")

    private OnTabSelectionChanged mSelectionChangedListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.781 -0500", hash_original_field = "A2D5AC5FA60C5ABCD5A9B10EE281BE7A", hash_generated_field = "CB97DF12B34C53DB09531B52F0015D03")

    private int mSelectedTab = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.783 -0500", hash_original_field = "618AAAC4898CD87C5C84F0DC492486D1", hash_generated_field = "6FA03D36B57D33A357D77C40AACCF8AD")

    private Drawable mLeftStrip;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.785 -0500", hash_original_field = "EDD204461E77D6F2F90FD7B4CC3B86B1", hash_generated_field = "5FBA50C5F8C8013E29152B4F0AB76375")

    private Drawable mRightStrip;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.787 -0500", hash_original_field = "DD0BD3E1E4D9018332D08DAF365FE055", hash_generated_field = "A9EA19E630FD2239CD23BC8D6D6761B9")

    private boolean mDrawBottomStrips = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.789 -0500", hash_original_field = "82444D27E77396C5CB9A9C2F5B72A999", hash_generated_field = "CFD4F88030B09A358C5455C797984434")

    private boolean mStripMoved;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.792 -0500", hash_original_field = "811AC12DD4794990F0DFD3FA5A6E3596", hash_generated_field = "FD1FEF375C4015D208B59BBFA039409F")

    private final Rect mBounds = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.794 -0500", hash_original_field = "B0AC9BE7BEF6A11D59FBF8BF7809A886", hash_generated_field = "732D997FD39411FF1FDEB12CCE765B40")

    private int mImposedTabsHeight = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.796 -0500", hash_original_field = "6E8417EFDF4C23D53AA321E51BBAD2FB", hash_generated_field = "9D9FC5CE98E4D043B266CFEAA1F5897C")

    private int[] mImposedTabWidths;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.799 -0500", hash_original_method = "BAD8053A139C3B2472C278F997D22869", hash_generated_method = "F03AF98FF889585319AC016EC76F6657")
    
public TabWidget(Context context) {
        this(context, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.802 -0500", hash_original_method = "09ECDBF0B3A18A9B29EEE79A768970FF", hash_generated_method = "171AD1885EE8BD11A2273EA7E3E4CAA4")
    
public TabWidget(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.tabWidgetStyle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.804 -0500", hash_original_method = "5CD4B242048A54DEBDC5CA30A897F614", hash_generated_method = "0591D1822D0377E67C3230F5E2B19F49")
    
public TabWidget(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        final TypedArray a = context.obtainStyledAttributes(
                attrs, com.android.internal.R.styleable.TabWidget, defStyle, 0);

        setStripEnabled(a.getBoolean(R.styleable.TabWidget_tabStripEnabled, true));
        setLeftStripDrawable(a.getDrawable(R.styleable.TabWidget_tabStripLeft));
        setRightStripDrawable(a.getDrawable(R.styleable.TabWidget_tabStripRight));

        a.recycle();

        initTabWidget();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.807 -0500", hash_original_method = "D47B983401A0131B570217343158B99A", hash_generated_method = "10B54AD18FE5A8EBFA33C8D12BA288E0")
    
@Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mStripMoved = true;
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.809 -0500", hash_original_method = "6DB375E1DD97C7DB4A0C01A394FBBB39", hash_generated_method = "86FCA3A335595F67361B20C120CCC7C7")
    
@Override
    protected int getChildDrawingOrder(int childCount, int i) {
        if (mSelectedTab == -1) {
            return i;
        } else {
            // Always draw the selected tab last, so that drop shadows are drawn
            // in the correct z-order.
            if (i == childCount - 1) {
                return mSelectedTab;
            } else if (i >= mSelectedTab) {
                return i + 1;
            } else {
                return i;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.812 -0500", hash_original_method = "5A72EB2BE089A5D99DEFC278831DF5C3", hash_generated_method = "0B3DFAF6C865060DF737C32099F87995")
    
private void initTabWidget() {
        setChildrenDrawingOrderEnabled(true);

        final Context context = mContext;
        final Resources resources = context.getResources();

        // Tests the target Sdk version, as set in the Manifest. Could not be set using styles.xml
        // in a values-v? directory which targets the current platform Sdk version instead.
        if (context.getApplicationInfo().targetSdkVersion <= Build.VERSION_CODES.DONUT) {
            // Donut apps get old color scheme
            if (mLeftStrip == null) {
                mLeftStrip = resources.getDrawable(
                        com.android.internal.R.drawable.tab_bottom_left_v4);
            }
            if (mRightStrip == null) {
                mRightStrip = resources.getDrawable(
                        com.android.internal.R.drawable.tab_bottom_right_v4);
            }
        } else {
            // Use modern color scheme for Eclair and beyond
            if (mLeftStrip == null) {
                mLeftStrip = resources.getDrawable(
                        com.android.internal.R.drawable.tab_bottom_left);
            }
            if (mRightStrip == null) {
                mRightStrip = resources.getDrawable(
                        com.android.internal.R.drawable.tab_bottom_right);
            }
        }

        // Deal with focus, as we don't want the focus to go by default
        // to a tab other than the current tab
        setFocusable(true);
        setOnFocusChangeListener(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.814 -0500", hash_original_method = "C935CB6AD095E3F37FD6E422C2C15A30", hash_generated_method = "2C35F53DC1C551664A772CA0130B6C50")
    
@Override
    void measureChildBeforeLayout(View child, int childIndex,
            int widthMeasureSpec, int totalWidth,
            int heightMeasureSpec, int totalHeight) {
        if (!isMeasureWithLargestChildEnabled() && mImposedTabsHeight >= 0) {
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(
                    totalWidth + mImposedTabWidths[childIndex], MeasureSpec.EXACTLY);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(mImposedTabsHeight,
                    MeasureSpec.EXACTLY);
        }

        super.measureChildBeforeLayout(child, childIndex,
                widthMeasureSpec, totalWidth, heightMeasureSpec, totalHeight);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.817 -0500", hash_original_method = "ED82522C2B0B64CD8D60C0C12518DCBA", hash_generated_method = "86ED1DD9064FCE4E863DD64E952FF7FE")
    
@Override
    void measureHorizontal(int widthMeasureSpec, int heightMeasureSpec) {
        if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.UNSPECIFIED) {
            super.measureHorizontal(widthMeasureSpec, heightMeasureSpec);
            return;
        }

        // First, measure with no constraint
        final int unspecifiedWidth = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        mImposedTabsHeight = -1;
        super.measureHorizontal(unspecifiedWidth, heightMeasureSpec);

        int extraWidth = getMeasuredWidth() - MeasureSpec.getSize(widthMeasureSpec);
        if (extraWidth > 0) {
            final int count = getChildCount();

            int childCount = 0;
            for (int i = 0; i < count; i++) {
                final View child = getChildAt(i);
                if (child.getVisibility() == GONE) continue;
                childCount++;
            }

            if (childCount > 0) {
                if (mImposedTabWidths == null || mImposedTabWidths.length != count) {
                    mImposedTabWidths = new int[count];
                }
                for (int i = 0; i < count; i++) {
                    final View child = getChildAt(i);
                    if (child.getVisibility() == GONE) continue;
                    final int childWidth = child.getMeasuredWidth();
                    final int delta = extraWidth / childCount;
                    final int newWidth = Math.max(0, childWidth - delta);
                    mImposedTabWidths[i] = newWidth;
                    // Make sure the extra width is evenly distributed, no int division remainder
                    extraWidth -= childWidth - newWidth; // delta may have been clamped
                    childCount--;
                    mImposedTabsHeight = Math.max(mImposedTabsHeight, child.getMeasuredHeight());
                }
            }
        }

        // Measure again, this time with imposed tab widths and respecting initial spec request
        super.measureHorizontal(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * Returns the tab indicator view at the given index.
     *
     * @param index the zero-based index of the tab indicator view to return
     * @return the tab indicator view at the given index
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.819 -0500", hash_original_method = "1AFF25E962A9B2EDADD57BD725ECCAB1", hash_generated_method = "EDA347D92CD3A217B27F5FAF7390EAB5")
    
public View getChildTabViewAt(int index) {
        return getChildAt(index);
    }

    /**
     * Returns the number of tab indicator views.
     * @return the number of tab indicator views.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.822 -0500", hash_original_method = "FE2CEC591CEC0077A02A9DEA200F51F9", hash_generated_method = "6D43FC4346EAA4BAFDCB8F9604AFC353")
    
public int getTabCount() {
        return getChildCount();
    }

    /**
     * Sets the drawable to use as a divider between the tab indicators.
     * @param drawable the divider drawable
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.824 -0500", hash_original_method = "BE73B200AC63DD0552B4403EEF7DD937", hash_generated_method = "1763E49A5BF6B71427810D0DD5B3C79F")
    
@Override
    public void setDividerDrawable(Drawable drawable) {
        super.setDividerDrawable(drawable);
    }

    /**
     * Sets the drawable to use as a divider between the tab indicators.
     * @param resId the resource identifier of the drawable to use as a
     * divider.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.826 -0500", hash_original_method = "3D37FAA6007791B5D3F4A4A58BCFDCCD", hash_generated_method = "42948D2C85A8C2DA9B780B071515A7FD")
    
public void setDividerDrawable(int resId) {
        setDividerDrawable(getResources().getDrawable(resId));
    }
    
    /**
     * Sets the drawable to use as the left part of the strip below the
     * tab indicators.
     * @param drawable the left strip drawable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.828 -0500", hash_original_method = "EEC4B8C710672EE52FF5686EC61F15E6", hash_generated_method = "AA3E961236173938943AEBB7D08173DC")
    
public void setLeftStripDrawable(Drawable drawable) {
        mLeftStrip = drawable;
        requestLayout();
        invalidate();
    }

    /**
     * Sets the drawable to use as the left part of the strip below the
     * tab indicators.
     * @param resId the resource identifier of the drawable to use as the
     * left strip drawable
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.830 -0500", hash_original_method = "172131F6C0343EAF2930103340C29368", hash_generated_method = "B18485E1984D1B0337B1AE750910637A")
    
public void setLeftStripDrawable(int resId) {
        setLeftStripDrawable(getResources().getDrawable(resId));
    }

    /**
     * Sets the drawable to use as the right part of the strip below the
     * tab indicators.
     * @param drawable the right strip drawable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.832 -0500", hash_original_method = "F30794AD8B45F99F5EA4402BF1535928", hash_generated_method = "3A253FCEE233842342A4CDA2F72BAD71")
    
public void setRightStripDrawable(Drawable drawable) {
        mRightStrip = drawable;
        requestLayout();
        invalidate();
    }

    /**
     * Sets the drawable to use as the right part of the strip below the
     * tab indicators.
     * @param resId the resource identifier of the drawable to use as the
     * right strip drawable
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.834 -0500", hash_original_method = "74C61065E01D6A0285B64085050AA388", hash_generated_method = "52FEA7BBEAFFA7B7B2C90A3A0FDE74F5")
    
public void setRightStripDrawable(int resId) {
        setRightStripDrawable(getResources().getDrawable(resId));
    }

    /**
     * Controls whether the bottom strips on the tab indicators are drawn or
     * not.  The default is to draw them.  If the user specifies a custom
     * view for the tab indicators, then the TabHost class calls this method
     * to disable drawing of the bottom strips.
     * @param stripEnabled true if the bottom strips should be drawn.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.836 -0500", hash_original_method = "7E210175CAACE05D561ED66C44B48699", hash_generated_method = "5823EB8C4E99718BEE1B2A931156F727")
    
public void setStripEnabled(boolean stripEnabled) {
        mDrawBottomStrips = stripEnabled;
        invalidate();
    }

    /**
     * Indicates whether the bottom strips on the tab indicators are drawn
     * or not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.839 -0500", hash_original_method = "187389676AA1F9CD7B5348DE6F614EB0", hash_generated_method = "788663CFD5788BDD995F778F6FDE867A")
    
public boolean isStripEnabled() {
        return mDrawBottomStrips;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.841 -0500", hash_original_method = "0D5FB7B547C3DEFE9E09A5210890B615", hash_generated_method = "40D0BCC39770F33E0FADE37BA7A9D532")
    
@Override
    public void childDrawableStateChanged(View child) {
        if (getTabCount() > 0 && child == getChildTabViewAt(mSelectedTab)) {
            // To make sure that the bottom strip is redrawn
            invalidate();
        }
        super.childDrawableStateChanged(child);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.845 -0500", hash_original_method = "9B055E7A37DD3E5EB33B478B68D4F173", hash_generated_method = "99D4EEC0364E0F6F83A1AECD6ACB3070")
    
@Override
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);

        // Do nothing if there are no tabs.
        if (getTabCount() == 0) return;

        // If the user specified a custom view for the tab indicators, then
        // do not draw the bottom strips.
        if (!mDrawBottomStrips) {
            // Skip drawing the bottom strips.
            return;
        }

        final View selectedChild = getChildTabViewAt(mSelectedTab);

        final Drawable leftStrip = mLeftStrip;
        final Drawable rightStrip = mRightStrip;

        leftStrip.setState(selectedChild.getDrawableState());
        rightStrip.setState(selectedChild.getDrawableState());

        if (mStripMoved) {
            final Rect bounds = mBounds;
            bounds.left = selectedChild.getLeft();
            bounds.right = selectedChild.getRight();
            final int myHeight = getHeight();
            leftStrip.setBounds(Math.min(0, bounds.left - leftStrip.getIntrinsicWidth()),
                    myHeight - leftStrip.getIntrinsicHeight(), bounds.left, myHeight);
            rightStrip.setBounds(bounds.right, myHeight - rightStrip.getIntrinsicHeight(),
                    Math.max(getWidth(), bounds.right + rightStrip.getIntrinsicWidth()), myHeight);
            mStripMoved = false;
        }

        leftStrip.draw(canvas);
        rightStrip.draw(canvas);
    }

    /**
     * Sets the current tab.
     * This method is used to bring a tab to the front of the Widget,
     * and is used to post to the rest of the UI that a different tab
     * has been brought to the foreground.
     *
     * Note, this is separate from the traditional "focus" that is
     * employed from the view logic.
     *
     * For instance, if we have a list in a tabbed view, a user may be
     * navigating up and down the list, moving the UI focus (orange
     * highlighting) through the list items.  The cursor movement does
     * not effect the "selected" tab though, because what is being
     * scrolled through is all on the same tab.  The selected tab only
     * changes when we navigate between tabs (moving from the list view
     * to the next tabbed view, in this example).
     *
     * To move both the focus AND the selected tab at once, please use
     * {@link #setCurrentTab}. Normally, the view logic takes care of
     * adjusting the focus, so unless you're circumventing the UI,
     * you'll probably just focus your interest here.
     *
     *  @param index The tab that you want to indicate as the selected
     *  tab (tab brought to the front of the widget)
     *
     *  @see #focusCurrentTab
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.847 -0500", hash_original_method = "FD8145AB0632DE8E66BE264294877C34", hash_generated_method = "3890226868A65856D8B54AC27713E78D")
    
public void setCurrentTab(int index) {
        if (index < 0 || index >= getTabCount() || index == mSelectedTab) {
            return;
        }

        if (mSelectedTab != -1) {
            getChildTabViewAt(mSelectedTab).setSelected(false);
        }
        mSelectedTab = index;
        getChildTabViewAt(mSelectedTab).setSelected(true);
        mStripMoved = true;

        if (isShown()) {
            sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.849 -0500", hash_original_method = "B9A90DC4D5316593C7C6FB4F4261561D", hash_generated_method = "6D31189FDBA1BE15A893CDED416E3A15")
    
@Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        onPopulateAccessibilityEvent(event);
        // Dispatch only to the selected tab.
        if (mSelectedTab != -1) {
            View tabView = getChildTabViewAt(mSelectedTab);
            if (tabView != null && tabView.getVisibility() == VISIBLE) {
                return tabView.dispatchPopulateAccessibilityEvent(event);
            }
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.851 -0500", hash_original_method = "5B381D25FD53DF8B1C9131304346B258", hash_generated_method = "30B30F9A896683C427093E967B8E29A7")
    
@Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setItemCount(getTabCount());
        event.setCurrentItemIndex(mSelectedTab);
    }

    /**
     * Sets the current tab and focuses the UI on it.
     * This method makes sure that the focused tab matches the selected
     * tab, normally at {@link #setCurrentTab}.  Normally this would not
     * be an issue if we go through the UI, since the UI is responsible
     * for calling TabWidget.onFocusChanged(), but in the case where we
     * are selecting the tab programmatically, we'll need to make sure
     * focus keeps up.
     *
     *  @param index The tab that you want focused (highlighted in orange)
     *  and selected (tab brought to the front of the widget)
     *
     *  @see #setCurrentTab
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.854 -0500", hash_original_method = "599192C49E7FBE73C0448383135B98FF", hash_generated_method = "733E2AF971F46419E764F001A5B19938")
    
public void focusCurrentTab(int index) {
        final int oldTab = mSelectedTab;

        // set the tab
        setCurrentTab(index);

        // change the focus if applicable.
        if (oldTab != index) {
            getChildTabViewAt(index).requestFocus();
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.856 -0500", hash_original_method = "B57ADC02C2264C78238655AF009610DC", hash_generated_method = "FCD2BCD429D675C6EFB2C291F381F8F8")
    
@Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);

        final int count = getTabCount();
        for (int i = 0; i < count; i++) {
            View child = getChildTabViewAt(i);
            child.setEnabled(enabled);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.858 -0500", hash_original_method = "D99503F0B5A4EFC29BAA1C76A3B67627", hash_generated_method = "5110715304003C2086DFCA701223F035")
    
@Override
    public void addView(View child) {
        if (child.getLayoutParams() == null) {
            final LinearLayout.LayoutParams lp = new LayoutParams(
                    0,
                    ViewGroup.LayoutParams.MATCH_PARENT, 1.0f);
            lp.setMargins(0, 0, 0, 0);
            child.setLayoutParams(lp);
        }

        // Ensure you can navigate to the tab with the keyboard, and you can touch it
        child.setFocusable(true);
        child.setClickable(true);

        super.addView(child);

        // TODO: detect this via geometry with a tabwidget listener rather
        // than potentially interfere with the view's listener
        child.setOnClickListener(new TabClickListener(getTabCount() - 1));
        child.setOnFocusChangeListener(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.861 -0500", hash_original_method = "EB030694D0FDE69DF41070C45192BD7E", hash_generated_method = "8601C5104587FAE2DF248A4A1233B0F3")
    
@Override
    public void removeAllViews() {
        super.removeAllViews();
        mSelectedTab = -1;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.863 -0500", hash_original_method = "8812800BD81149FA7672691DBEB9912B", hash_generated_method = "D96F5DE0EB20A18636AFCA009F2DB29B")
    
@Override
    public void sendAccessibilityEventUnchecked(AccessibilityEvent event) {
        // this class fires events only when tabs are focused or selected
        if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_FOCUSED && isFocused()) {
            event.recycle();
            return;
        }
        super.sendAccessibilityEventUnchecked(event);
    }

    /**
     * Provides a way for {@link TabHost} to be notified that the user clicked on a tab indicator.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.865 -0500", hash_original_method = "417165650412A4BD506B46A43D5F7416", hash_generated_method = "417165650412A4BD506B46A43D5F7416")
    
void setTabSelectionListener(OnTabSelectionChanged listener) {
        mSelectionChangedListener = listener;
    }

    /** {@inheritDoc} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.868 -0500", hash_original_method = "4E088FBB30D7470D105CC06A4CB02903", hash_generated_method = "0FDD57BDAFB5BACCA45890A5626C8C6A")
    
public void onFocusChange(View v, boolean hasFocus) {
        if (v == this && hasFocus && getTabCount() > 0) {
            getChildTabViewAt(mSelectedTab).requestFocus();
            return;
        }

        if (hasFocus) {
            int i = 0;
            int numTabs = getTabCount();
            while (i < numTabs) {
                if (getChildTabViewAt(i) == v) {
                    setCurrentTab(i);
                    mSelectionChangedListener.onTabSelectionChanged(i, false);
                    if (isShown()) {
                        // a tab is focused so send an event to announce the tab widget state
                        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
                    }
                    break;
                }
                i++;
            }
        }
    }
    
    private class TabClickListener implements OnClickListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.870 -0500", hash_original_field = "7E0206C5388F7BDA55A378F003C5C30C", hash_generated_field = "CC51272D049B7B1F88C1AB320207675A")

        private  int mTabIndex;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.873 -0500", hash_original_method = "D6AF06C429F8FB8C9AE0E71F34F47DE0", hash_generated_method = "35A786ECF4C00E93FB6D57A2EC44D88C")
        
private TabClickListener(int tabIndex) {
            mTabIndex = tabIndex;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:37.875 -0500", hash_original_method = "28066710625DA4D2083757F8679E5933", hash_generated_method = "7A271955D8BDABC8C65F69FE4086A9D9")
        
public void onClick(View v) {
            mSelectionChangedListener.onTabSelectionChanged(mTabIndex, true);
        }
        
    }
    
    static interface OnTabSelectionChanged {
        
        void onTabSelectionChanged(int tabIndex, boolean clicked);
    }
    
}

