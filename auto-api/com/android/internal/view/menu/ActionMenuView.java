package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;

public class ActionMenuView extends LinearLayout implements MenuBuilder.ItemInvoker, MenuView {
    private static final String TAG = "ActionMenuView";
    static final int MIN_CELL_SIZE = 56;
    static final int GENERATED_ITEM_PADDING = 4;
    private MenuBuilder mMenu;
    private boolean mReserveOverflow;
    private ActionMenuPresenter mPresenter;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mMinCellSize;
    private int mGeneratedItemPadding;
    private int mMeasuredExtraWidth;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.001 -0400", hash_original_method = "AC153E2863979DC17A482AC64988B640", hash_generated_method = "3C2AA40811A886C818ED7D7FB398E0E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionMenuView(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.002 -0400", hash_original_method = "35E28BCF8B52367FF953A9B63C9F4F20", hash_generated_method = "E5B4DD8CCCB4819CA6838BBDF17F9021")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        setBaselineAligned(false);
        final float density;
        density = context.getResources().getDisplayMetrics().density;
        mMinCellSize = (int) (MIN_CELL_SIZE * density);
        mGeneratedItemPadding = (int) (GENERATED_ITEM_PADDING * density);
        // ---------- Original Method ----------
        //setBaselineAligned(false);
        //final float density = context.getResources().getDisplayMetrics().density;
        //mMinCellSize = (int) (MIN_CELL_SIZE * density);
        //mGeneratedItemPadding = (int) (GENERATED_ITEM_PADDING * density);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.002 -0400", hash_original_method = "F8B2E0B9AF6B77951E8DA779DE9E37B4", hash_generated_method = "FC1B7EAC327C3BC4310F3180890AADC1")
    @DSModeled(DSC.SAFE)
    public void setPresenter(ActionMenuPresenter presenter) {
        dsTaint.addTaint(presenter.dsTaint);
        // ---------- Original Method ----------
        //mPresenter = presenter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.002 -0400", hash_original_method = "309FFF524EE8C98ED8919EC0ED593079", hash_generated_method = "FE1179AC928FF0401B42D2C03FDE22CB")
    @DSModeled(DSC.SAFE)
    public boolean isExpandedFormat() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFormatItems;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.002 -0400", hash_original_method = "8C9F73227D09E5C25F24B8EE1F20BF37", hash_generated_method = "C418611210F5B75D6F06208CA3CE6835")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newConfig.dsTaint);
        super.onConfigurationChanged(newConfig);
        mPresenter.updateMenuView(false);
        {
            boolean varFFBC8C8E161FD649FDC01AB3F026CE61_1829305566 = (mPresenter != null && mPresenter.isOverflowMenuShowing());
            {
                mPresenter.hideOverflowMenu();
                mPresenter.showOverflowMenu();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.onConfigurationChanged(newConfig);
        //mPresenter.updateMenuView(false);
        //if (mPresenter != null && mPresenter.isOverflowMenuShowing()) {
            //mPresenter.hideOverflowMenu();
            //mPresenter.showOverflowMenu();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.002 -0400", hash_original_method = "7A0AC3F9A12B78835921801D3FB6DAA4", hash_generated_method = "D024234229A49AEBB034722B1B7D66F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        final boolean wasFormatted;
        wasFormatted = mFormatItems;
        mFormatItems = MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.EXACTLY;
        {
            mFormatItemsWidth = 0;
        } //End block
        final int widthSize;
        widthSize = MeasureSpec.getMode(widthMeasureSpec);
        {
            mFormatItemsWidth = widthSize;
            mMenu.onItemsChanged(true);
        } //End block
        {
            onMeasureExactFormat(widthMeasureSpec, heightMeasureSpec);
        } //End block
        {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } //End block
        // ---------- Original Method ----------
        //final boolean wasFormatted = mFormatItems;
        //mFormatItems = MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.EXACTLY;
        //if (wasFormatted != mFormatItems) {
            //mFormatItemsWidth = 0; 
        //}
        //final int widthSize = MeasureSpec.getMode(widthMeasureSpec);
        //if (mFormatItems && mMenu != null && widthSize != mFormatItemsWidth) {
            //mFormatItemsWidth = widthSize;
            //mMenu.onItemsChanged(true);
        //}
        //if (mFormatItems) {
            //onMeasureExactFormat(widthMeasureSpec, heightMeasureSpec);
        //} else {
            //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.003 -0400", hash_original_method = "904CFC5C82A7517026F4582C82215F76", hash_generated_method = "5F050DF16433020EFCC98F66AF75F796")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onMeasureExactFormat(int widthMeasureSpec, int heightMeasureSpec) {
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        final int heightMode;
        heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize;
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize;
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
        final int widthPadding;
        widthPadding = getPaddingLeft() + getPaddingRight();
        final int heightPadding;
        heightPadding = getPaddingTop() + getPaddingBottom();
        widthSize -= widthPadding;
        final int cellCount;
        cellCount = widthSize / mMinCellSize;
        final int cellSizeRemaining;
        cellSizeRemaining = widthSize % mMinCellSize;
        {
            setMeasuredDimension(widthSize, 0);
        } //End block
        final int cellSize;
        cellSize = mMinCellSize + cellSizeRemaining / cellCount;
        int cellsRemaining;
        cellsRemaining = cellCount;
        int maxChildHeight;
        maxChildHeight = 0;
        int maxCellsUsed;
        maxCellsUsed = 0;
        int expandableItemCount;
        expandableItemCount = 0;
        int visibleItemCount;
        visibleItemCount = 0;
        boolean hasOverflow;
        hasOverflow = false;
        long smallestItemsAt;
        smallestItemsAt = 0;
        final int childCount;
        childCount = getChildCount();
        {
            int i;
            i = 0;
            {
                final View child;
                child = getChildAt(i);
                {
                    boolean varE5A6421440835A22FD9C00B75E3D1565_1558030097 = (child.getVisibility() == GONE);
                } //End collapsed parenthetic
                final boolean isGeneratedItem;
                isGeneratedItem = child instanceof ActionMenuItemView;
                visibleItemCount++;
                {
                    child.setPadding(mGeneratedItemPadding, 0, mGeneratedItemPadding, 0);
                } //End block
                final LayoutParams lp;
                lp = (LayoutParams) child.getLayoutParams();
                lp.expanded = false;
                lp.extraPixels = 0;
                lp.cellsUsed = 0;
                lp.expandable = false;
                lp.leftMargin = 0;
                lp.rightMargin = 0;
                lp.preventEdgeOffset = isGeneratedItem && ((ActionMenuItemView) child).hasText();
                final int cellsAvailable;
                cellsAvailable = 1;
                cellsAvailable = cellsRemaining;
                final int cellsUsed;
                cellsUsed = measureChildForCells(child, cellSize, cellsAvailable,
                    heightMeasureSpec, heightPadding);
                maxCellsUsed = Math.max(maxCellsUsed, cellsUsed);
                expandableItemCount++;
                hasOverflow = true;
                cellsRemaining -= cellsUsed;
                maxChildHeight = Math.max(maxChildHeight, child.getMeasuredHeight());
                smallestItemsAt |= (1 << i);
            } //End block
        } //End collapsed parenthetic
        final boolean centerSingleExpandedItem;
        centerSingleExpandedItem = hasOverflow && visibleItemCount == 2;
        boolean needsExpansion;
        needsExpansion = false;
        {
            int minCells;
            minCells = Integer.MAX_VALUE;
            long minCellsAt;
            minCellsAt = 0;
            int minCellsItemCount;
            minCellsItemCount = 0;
            {
                int i;
                i = 0;
                {
                    final View child;
                    child = getChildAt(i);
                    final LayoutParams lp;
                    lp = (LayoutParams) child.getLayoutParams();
                    {
                        minCells = lp.cellsUsed;
                        minCellsAt = 1 << i;
                        minCellsItemCount = 1;
                    } //End block
                    {
                        minCellsAt |= 1 << i;
                        minCellsItemCount++;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            smallestItemsAt |= minCellsAt;
            minCells++;
            {
                int i;
                i = 0;
                {
                    final View child;
                    child = getChildAt(i);
                    final LayoutParams lp;
                    lp = (LayoutParams) child.getLayoutParams();
                    {
                        smallestItemsAt |= 1 << i;
                    } //End block
                    {
                        child.setPadding(mGeneratedItemPadding + cellSize, 0, mGeneratedItemPadding, 0);
                    } //End block
                    lp.cellsUsed++;
                    lp.expanded = true;
                    cellsRemaining--;
                } //End block
            } //End collapsed parenthetic
            needsExpansion = true;
        } //End block
        final boolean singleItem;
        singleItem = !hasOverflow && visibleItemCount == 1;
        {
            float expandCount;
            expandCount = Long.bitCount(smallestItemsAt);
            {
                {
                    LayoutParams lp;
                    lp = (LayoutParams) getChildAt(0).getLayoutParams();
                    expandCount -= 0.5f;
                } //End block
                {
                    LayoutParams lp;
                    lp = ((LayoutParams) getChildAt(childCount - 1).getLayoutParams());
                    expandCount -= 0.5f;
                } //End block
            } //End block
            final int extraPixels;
            extraPixels = (int) (cellsRemaining * cellSize / expandCount);
            extraPixels = 0;
            {
                int i;
                i = 0;
                {
                    final View child;
                    child = getChildAt(i);
                    final LayoutParams lp;
                    lp = (LayoutParams) child.getLayoutParams();
                    {
                        lp.extraPixels = extraPixels;
                        lp.expanded = true;
                        {
                            lp.leftMargin = -extraPixels / 2;
                        } //End block
                        needsExpansion = true;
                    } //End block
                    {
                        lp.extraPixels = extraPixels;
                        lp.expanded = true;
                        lp.rightMargin = -extraPixels / 2;
                        needsExpansion = true;
                    } //End block
                    {
                        {
                            lp.leftMargin = extraPixels / 2;
                        } //End block
                        {
                            lp.rightMargin = extraPixels / 2;
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            cellsRemaining = 0;
        } //End block
        {
            int heightSpec;
            heightSpec = MeasureSpec.makeMeasureSpec(heightSize - heightPadding, heightMode);
            {
                int i;
                i = 0;
                {
                    final View child;
                    child = getChildAt(i);
                    final LayoutParams lp;
                    lp = (LayoutParams) child.getLayoutParams();
                    final int width;
                    width = lp.cellsUsed * cellSize + lp.extraPixels;
                    child.measure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY), heightSpec);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            heightSize = maxChildHeight;
        } //End block
        setMeasuredDimension(widthSize, heightSize);
        mMeasuredExtraWidth = cellsRemaining * cellSize;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.003 -0400", hash_original_method = "3EE8D7D16F58FBE24D52688DB0D4BEBD", hash_generated_method = "B755F96AF94AB504804536B58F7E7090")
    static int measureChildForCells(View child, int cellSize, int cellsRemaining,
            int parentHeightMeasureSpec, int parentHeightPadding) {
        final LayoutParams lp = (LayoutParams) child.getLayoutParams();
        final int childHeightSize = MeasureSpec.getSize(parentHeightMeasureSpec) -
                parentHeightPadding;
        final int childHeightMode = MeasureSpec.getMode(parentHeightMeasureSpec);
        final int childHeightSpec = MeasureSpec.makeMeasureSpec(childHeightSize, childHeightMode);
        int cellsUsed = 0;
        if (cellsRemaining > 0) {
            final int childWidthSpec = MeasureSpec.makeMeasureSpec(
                    cellSize * cellsRemaining, MeasureSpec.AT_MOST);
            child.measure(childWidthSpec, childHeightSpec);
            final int measuredWidth = child.getMeasuredWidth();
            cellsUsed = measuredWidth / cellSize;
            if (measuredWidth % cellSize != 0) cellsUsed++;
        }
        final ActionMenuItemView itemView = child instanceof ActionMenuItemView ?
                (ActionMenuItemView) child : null;
        final boolean expandable = !lp.isOverflowButton && itemView != null && itemView.hasText();
        lp.expandable = expandable;
        lp.cellsUsed = cellsUsed;
        final int targetWidth = cellsUsed * cellSize;
        child.measure(MeasureSpec.makeMeasureSpec(targetWidth, MeasureSpec.EXACTLY),
                childHeightSpec);
        return cellsUsed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.004 -0400", hash_original_method = "CF95DF9C40DBA0243EC42554D6345F0F", hash_generated_method = "AD5193BD7FFB184033206FE28A0BB652")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(changed);
        dsTaint.addTaint(top);
        {
            super.onLayout(changed, left, top, right, bottom);
        } //End block
        final int childCount;
        childCount = getChildCount();
        final int midVertical;
        midVertical = (top + bottom) / 2;
        final int dividerWidth;
        dividerWidth = getDividerWidth();
        int overflowWidth;
        overflowWidth = 0;
        int nonOverflowWidth;
        nonOverflowWidth = 0;
        int nonOverflowCount;
        nonOverflowCount = 0;
        int widthRemaining;
        widthRemaining = right - left - getPaddingRight() - getPaddingLeft();
        boolean hasOverflow;
        hasOverflow = false;
        {
            int i;
            i = 0;
            {
                final View v;
                v = getChildAt(i);
                {
                    boolean varDA63034006064F4C7F0A3E1C4DB8D066_1405165246 = (v.getVisibility() == GONE);
                } //End collapsed parenthetic
                LayoutParams p;
                p = (LayoutParams) v.getLayoutParams();
                {
                    overflowWidth = v.getMeasuredWidth();
                    {
                        boolean varCAC00097357B8B7C575A4308C6C0DBA2_889312154 = (hasDividerBeforeChildAt(i));
                        {
                            overflowWidth += dividerWidth;
                        } //End block
                    } //End collapsed parenthetic
                    int height;
                    height = v.getMeasuredHeight();
                    int r;
                    r = getWidth() - getPaddingRight() - p.rightMargin;
                    int l;
                    l = r - overflowWidth;
                    int t;
                    t = midVertical - (height / 2);
                    int b;
                    b = t + height;
                    v.layout(l, t, r, b);
                    widthRemaining -= overflowWidth;
                    hasOverflow = true;
                } //End block
                {
                    final int size;
                    size = v.getMeasuredWidth() + p.leftMargin + p.rightMargin;
                    nonOverflowWidth += size;
                    widthRemaining -= size;
                    {
                        boolean varCAC00097357B8B7C575A4308C6C0DBA2_1064597041 = (hasDividerBeforeChildAt(i));
                        {
                            nonOverflowWidth += dividerWidth;
                        } //End block
                    } //End collapsed parenthetic
                    nonOverflowCount++;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            final View v;
            v = getChildAt(0);
            final int width;
            width = v.getMeasuredWidth();
            final int height;
            height = v.getMeasuredHeight();
            final int midHorizontal;
            midHorizontal = (right - left) / 2;
            final int l;
            l = midHorizontal - width / 2;
            final int t;
            t = midVertical - height / 2;
            v.layout(l, t, l + width, t + height);
        } //End block
        final int spacerCount;
        spacerCount = nonOverflowCount - (hasOverflow ? 0 : 1);//DSFIXME:  CODE0008: Nested ternary operator in expression
        final int spacerSize;
        spacerSize = Math.max(0, spacerCount > 0 ? widthRemaining / spacerCount : 0);//DSFIXME:  CODE0008: Nested ternary operator in expression
        int startLeft;
        startLeft = getPaddingLeft();
        {
            int i;
            i = 0;
            {
                final View v;
                v = getChildAt(i);
                final LayoutParams lp;
                lp = (LayoutParams) v.getLayoutParams();
                {
                    boolean var49B93947E8B636089049537FC51034AE_1505699367 = (v.getVisibility() == GONE || lp.isOverflowButton);
                } //End collapsed parenthetic
                startLeft += lp.leftMargin;
                int width;
                width = v.getMeasuredWidth();
                int height;
                height = v.getMeasuredHeight();
                int t;
                t = midVertical - height / 2;
                v.layout(startLeft, t, startLeft + width, t + height);
                startLeft += width + lp.rightMargin + spacerSize;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.004 -0400", hash_original_method = "BCFF92F724E40A93547AD27810B374B7", hash_generated_method = "86F348F61F59F85C513F7F9DBAB8BD22")
    @DSModeled(DSC.SAFE)
    @Override
    public void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        mPresenter.dismissPopupMenus();
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //mPresenter.dismissPopupMenus();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.004 -0400", hash_original_method = "9F44211E52A7149BFED02520B6DEF800", hash_generated_method = "4D6C1E8FDA41830356B62B44C4D2BBD0")
    @DSModeled(DSC.SAFE)
    public boolean isOverflowReserved() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mReserveOverflow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.004 -0400", hash_original_method = "F5103BD0EA93D884CF8413DB778005C1", hash_generated_method = "F076FAD289C7E33E5AD72E2492765827")
    @DSModeled(DSC.SAFE)
    public void setOverflowReserved(boolean reserveOverflow) {
        dsTaint.addTaint(reserveOverflow);
        // ---------- Original Method ----------
        //mReserveOverflow = reserveOverflow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.004 -0400", hash_original_method = "DEBB4048965D8045F192555AB279F2BA", hash_generated_method = "FA132ADB2E44CCAF73B592D3F1709F98")
    @DSModeled(DSC.SAFE)
    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams params;
        params = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
                //LayoutParams.WRAP_CONTENT);
        //params.gravity = Gravity.CENTER_VERTICAL;
        //return params;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.004 -0400", hash_original_method = "AED9080C69042489485342721EE0B0B1", hash_generated_method = "02A99C3BA5265273A312088A042615C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        LayoutParams var1608545582BA25B7A0B072469C4B0958_1018371981 = (new LayoutParams(getContext(), attrs));
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.005 -0400", hash_original_method = "6543FCE3043AA8E09E4AB46D137D1290", hash_generated_method = "5FB0DAC0805A26411F6CC63422F217A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        {
            LayoutParams result;
            result = new LayoutParams((LayoutParams) p);
            {
                result.gravity = Gravity.CENTER_VERTICAL;
            } //End block
        } //End block
        LayoutParams var63E3DA67FB7B65B584D5E515426C9EE0_23035250 = (generateDefaultLayoutParams());
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (p instanceof LayoutParams) {
            //LayoutParams result = new LayoutParams((LayoutParams) p);
            //if (result.gravity <= Gravity.NO_GRAVITY) {
                //result.gravity = Gravity.CENTER_VERTICAL;
            //}
            //return result;
        //}
        //return generateDefaultLayoutParams();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.005 -0400", hash_original_method = "C7A39F9D75FC22971A40D0A54E61424A", hash_generated_method = "6ACFC03AD12631AEF9D6E8AB20C06D39")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return p != null && p instanceof LayoutParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.005 -0400", hash_original_method = "AF673847AD60845228ED5C7DBF294789", hash_generated_method = "2EF6253FF018F39F9B661ADAAA4B37D3")
    @DSModeled(DSC.SAFE)
    public LayoutParams generateOverflowButtonLayoutParams() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        LayoutParams result;
        result = generateDefaultLayoutParams();
        result.isOverflowButton = true;
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //LayoutParams result = generateDefaultLayoutParams();
        //result.isOverflowButton = true;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.005 -0400", hash_original_method = "52251A4D38FF83C9B55C46C571A25CAE", hash_generated_method = "FBDABD14ADD3B09A8288211652C76592")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean invokeItem(MenuItemImpl item) {
        dsTaint.addTaint(item.dsTaint);
        boolean varC4283B859DE61FC835DAD199DF70A5FF_1179176049 = (mMenu.performItemAction(item, 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mMenu.performItemAction(item, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.005 -0400", hash_original_method = "DC1BDB1B98459EBD06B93B75A5D0D038", hash_generated_method = "9846770188B61ACF2642FBEDE57AE8B6")
    @DSModeled(DSC.SAFE)
    public int getWindowAnimations() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.005 -0400", hash_original_method = "EDB3B7E883C1486DD9AED3AB15C0E44B", hash_generated_method = "02554AE0C3590CBBA71FDDF1D4B9EE8C")
    @DSModeled(DSC.SAFE)
    public void initialize(MenuBuilder menu) {
        dsTaint.addTaint(menu.dsTaint);
        // ---------- Original Method ----------
        //mMenu = menu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.005 -0400", hash_original_method = "9B32BE6DC23F13B511A55013BB42C488", hash_generated_method = "4C33CE34BDCBB5AB9B8148FFC1C80287")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean hasDividerBeforeChildAt(int childIndex) {
        dsTaint.addTaint(childIndex);
        final View childBefore;
        childBefore = getChildAt(childIndex - 1);
        final View child;
        child = getChildAt(childIndex);
        boolean result;
        result = false;
        {
            boolean var208B2155B1BCB653E775DCCF74C07E92_586716578 = (childIndex < getChildCount() && childBefore instanceof ActionMenuChildView);
            {
                result |= ((ActionMenuChildView) childBefore).needsDividerAfter();
            } //End block
        } //End collapsed parenthetic
        {
            result |= ((ActionMenuChildView) child).needsDividerBefore();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final View childBefore = getChildAt(childIndex - 1);
        //final View child = getChildAt(childIndex);
        //boolean result = false;
        //if (childIndex < getChildCount() && childBefore instanceof ActionMenuChildView) {
            //result |= ((ActionMenuChildView) childBefore).needsDividerAfter();
        //}
        //if (childIndex > 0 && child instanceof ActionMenuChildView) {
            //result |= ((ActionMenuChildView) child).needsDividerBefore();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.005 -0400", hash_original_method = "87E5D39D1D82C11AB077A37A8786E27E", hash_generated_method = "F2364E35503E90BEDF23881A8A31F8D1")
    @DSModeled(DSC.SAFE)
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    public static class LayoutParams extends LinearLayout.LayoutParams {
        @ViewDebug.ExportedProperty(category = "layout")
        public boolean isOverflowButton;
        @ViewDebug.ExportedProperty(category = "layout")
        public int cellsUsed;
        @ViewDebug.ExportedProperty(category = "layout")
        public int extraPixels;
        @ViewDebug.ExportedProperty(category = "layout")
        public boolean expandable;
        @ViewDebug.ExportedProperty(category = "layout")
        public boolean preventEdgeOffset;
        public boolean expanded;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.005 -0400", hash_original_method = "35869249D2D5BC08819A8507F87D33FD", hash_generated_method = "27AA4F047E6B38797AD586ED7B1454BA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            dsTaint.addTaint(c.dsTaint);
            dsTaint.addTaint(attrs.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.005 -0400", hash_original_method = "1AEEB2B6AE567062F04CDAB99E43CD26", hash_generated_method = "335030708B2C3AF9C40F589A1108476D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(LayoutParams other) {
            super((LinearLayout.LayoutParams) other);
            dsTaint.addTaint(other.dsTaint);
            isOverflowButton = other.isOverflowButton;
            // ---------- Original Method ----------
            //isOverflowButton = other.isOverflowButton;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.005 -0400", hash_original_method = "5CB9C8D742F9EAB0281FCB85ADC86E3D", hash_generated_method = "B8E63E4E52FB188FCD4105B126426CDB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(int width, int height) {
            super(width, height);
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            isOverflowButton = false;
            // ---------- Original Method ----------
            //isOverflowButton = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.005 -0400", hash_original_method = "0D80B5BE9184580A03D083B0A94309F3", hash_generated_method = "93744BDC6AB0994752C06864EBCF214E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(int width, int height, boolean isOverflowButton) {
            super(width, height);
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            dsTaint.addTaint(isOverflowButton);
            // ---------- Original Method ----------
            //this.isOverflowButton = isOverflowButton;
        }

        
    }


    
    public interface ActionMenuChildView {
        public boolean needsDividerBefore();
        public boolean needsDividerAfter();
    }
    
}


