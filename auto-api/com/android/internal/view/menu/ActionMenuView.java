package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.196 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.196 -0400", hash_original_field = "0E213F9463B6EFE55ADA2109C5E5DC56", hash_generated_field = "3619C222EA285420CD3DE70ECE0D1D48")

    private boolean mReserveOverflow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.196 -0400", hash_original_field = "24BE2DD94A844242C35ABB990B9E3B93", hash_generated_field = "BC36FBD9CCAFE590BF9A0B51503C858E")

    private ActionMenuPresenter mPresenter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.196 -0400", hash_original_field = "91949478145170F53463EA7B1D93DAAB", hash_generated_field = "6B2CAAF6AA38EAEFE2FA3F0FE80C1E20")

    private boolean mFormatItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.196 -0400", hash_original_field = "9EAE809C529287B9D5ACFCE152326FD4", hash_generated_field = "7ADECD8C88CFFA290657D73715D82527")

    private int mFormatItemsWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.196 -0400", hash_original_field = "C0CB7E511A75AFCB98C3B0342F6802E9", hash_generated_field = "303D27EFA1C100E376A8416C573EAB8F")

    private int mMinCellSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.196 -0400", hash_original_field = "25DB108BA28ED0013D5558630CEBAF2D", hash_generated_field = "32B1FF10CA48AFEEB7A5989848197D17")

    private int mGeneratedItemPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.196 -0400", hash_original_field = "B1E8AEB61B975F039E0DDB567198268F", hash_generated_field = "A7412B938C8635F667A20F8A5F45CA3A")

    private int mMeasuredExtraWidth;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.198 -0400", hash_original_method = "AC153E2863979DC17A482AC64988B640", hash_generated_method = "5F3CB5A8A49E2CC16CAE28F7B3615920")
    public  ActionMenuView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.199 -0400", hash_original_method = "35E28BCF8B52367FF953A9B63C9F4F20", hash_generated_method = "B6CD56CB479301472721DA516CE60C66")
    public  ActionMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBaselineAligned(false);
        float density;
        density = context.getResources().getDisplayMetrics().density;
        mMinCellSize = (int) (MIN_CELL_SIZE * density);
        mGeneratedItemPadding = (int) (GENERATED_ITEM_PADDING * density);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        //setBaselineAligned(false);
        //final float density = context.getResources().getDisplayMetrics().density;
        //mMinCellSize = (int) (MIN_CELL_SIZE * density);
        //mGeneratedItemPadding = (int) (GENERATED_ITEM_PADDING * density);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.199 -0400", hash_original_method = "F8B2E0B9AF6B77951E8DA779DE9E37B4", hash_generated_method = "2D2E0A69D628FF0C713DCBD58D8FEF6B")
    public void setPresenter(ActionMenuPresenter presenter) {
        mPresenter = presenter;
        // ---------- Original Method ----------
        //mPresenter = presenter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.199 -0400", hash_original_method = "309FFF524EE8C98ED8919EC0ED593079", hash_generated_method = "02E84535D9BFAA8E0CA2EDCB15631795")
    public boolean isExpandedFormat() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1385368764 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1385368764;
        // ---------- Original Method ----------
        //return mFormatItems;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.200 -0400", hash_original_method = "8C9F73227D09E5C25F24B8EE1F20BF37", hash_generated_method = "08B71C31C22C1248AF11C04001F6FE20")
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onConfigurationChanged(newConfig);
        mPresenter.updateMenuView(false);
        {
            boolean varFFBC8C8E161FD649FDC01AB3F026CE61_1582348485 = (mPresenter != null && mPresenter.isOverflowMenuShowing());
            {
                mPresenter.hideOverflowMenu();
                mPresenter.showOverflowMenu();
            } //End block
        } //End collapsed parenthetic
        addTaint(newConfig.getTaint());
        // ---------- Original Method ----------
        //super.onConfigurationChanged(newConfig);
        //mPresenter.updateMenuView(false);
        //if (mPresenter != null && mPresenter.isOverflowMenuShowing()) {
            //mPresenter.hideOverflowMenu();
            //mPresenter.showOverflowMenu();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.200 -0400", hash_original_method = "7A0AC3F9A12B78835921801D3FB6DAA4", hash_generated_method = "EE8551D5960A18CBB873CC9800B7A2DE")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean wasFormatted;
        wasFormatted = mFormatItems;
        mFormatItems = MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.EXACTLY;
        {
            mFormatItemsWidth = 0;
        } //End block
        int widthSize;
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
        addTaint(heightMeasureSpec);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.228 -0400", hash_original_method = "904CFC5C82A7517026F4582C82215F76", hash_generated_method = "63B76B401408C20CD5D1E3DDD1D927BC")
    private void onMeasureExactFormat(int widthMeasureSpec, int heightMeasureSpec) {
        int heightMode;
        heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize;
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize;
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthPadding;
        widthPadding = getPaddingLeft() + getPaddingRight();
        int heightPadding;
        heightPadding = getPaddingTop() + getPaddingBottom();
        widthSize -= widthPadding;
        int cellCount;
        cellCount = widthSize / mMinCellSize;
        int cellSizeRemaining;
        cellSizeRemaining = widthSize % mMinCellSize;
        {
            setMeasuredDimension(widthSize, 0);
        } //End block
        int cellSize;
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
        int childCount;
        childCount = getChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildAt(i);
                {
                    boolean varE5A6421440835A22FD9C00B75E3D1565_2139943785 = (child.getVisibility() == GONE);
                } //End collapsed parenthetic
                boolean isGeneratedItem;
                isGeneratedItem = child instanceof ActionMenuItemView;
                {
                    child.setPadding(mGeneratedItemPadding, 0, mGeneratedItemPadding, 0);
                } //End block
                LayoutParams lp;
                lp = (LayoutParams) child.getLayoutParams();
                lp.expanded = false;
                lp.extraPixels = 0;
                lp.cellsUsed = 0;
                lp.expandable = false;
                lp.leftMargin = 0;
                lp.rightMargin = 0;
                lp.preventEdgeOffset = isGeneratedItem && ((ActionMenuItemView) child).hasText();
                int cellsAvailable;
                cellsAvailable = 1;
                cellsAvailable = cellsRemaining;
                int cellsUsed;
                cellsUsed = measureChildForCells(child, cellSize, cellsAvailable,
                    heightMeasureSpec, heightPadding);
                maxCellsUsed = Math.max(maxCellsUsed, cellsUsed);
                hasOverflow = true;
                cellsRemaining -= cellsUsed;
                maxChildHeight = Math.max(maxChildHeight, child.getMeasuredHeight());
                smallestItemsAt |= (1 << i);
            } //End block
        } //End collapsed parenthetic
        boolean centerSingleExpandedItem;
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
                    View child;
                    child = getChildAt(i);
                    LayoutParams lp;
                    lp = (LayoutParams) child.getLayoutParams();
                    {
                        minCells = lp.cellsUsed;
                        minCellsAt = 1 << i;
                        minCellsItemCount = 1;
                    } //End block
                    {
                        minCellsAt |= 1 << i;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            smallestItemsAt |= minCellsAt;
            {
                int i;
                i = 0;
                {
                    View child;
                    child = getChildAt(i);
                    LayoutParams lp;
                    lp = (LayoutParams) child.getLayoutParams();
                    {
                        smallestItemsAt |= 1 << i;
                    } //End block
                    {
                        child.setPadding(mGeneratedItemPadding + cellSize, 0, mGeneratedItemPadding, 0);
                    } //End block
                    lp.expanded = true;
                } //End block
            } //End collapsed parenthetic
            needsExpansion = true;
        } //End block
        boolean singleItem;
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
            int extraPixels;
            extraPixels = (int) (cellsRemaining * cellSize / expandCount);
            extraPixels = 0;
            {
                int i;
                i = 0;
                {
                    View child;
                    child = getChildAt(i);
                    LayoutParams lp;
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
                    View child;
                    child = getChildAt(i);
                    LayoutParams lp;
                    lp = (LayoutParams) child.getLayoutParams();
                    int width;
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
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.247 -0400", hash_original_method = "CF95DF9C40DBA0243EC42554D6345F0F", hash_generated_method = "6CF2127583247DE5F98474049D6A5339")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            super.onLayout(changed, left, top, right, bottom);
        } //End block
        int childCount;
        childCount = getChildCount();
        int midVertical;
        midVertical = (top + bottom) / 2;
        int dividerWidth;
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
                View v;
                v = getChildAt(i);
                {
                    boolean varDA63034006064F4C7F0A3E1C4DB8D066_867860236 = (v.getVisibility() == GONE);
                } //End collapsed parenthetic
                LayoutParams p;
                p = (LayoutParams) v.getLayoutParams();
                {
                    overflowWidth = v.getMeasuredWidth();
                    {
                        boolean varCAC00097357B8B7C575A4308C6C0DBA2_419378806 = (hasDividerBeforeChildAt(i));
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
                    int size;
                    size = v.getMeasuredWidth() + p.leftMargin + p.rightMargin;
                    nonOverflowWidth += size;
                    widthRemaining -= size;
                    {
                        boolean varCAC00097357B8B7C575A4308C6C0DBA2_1415021384 = (hasDividerBeforeChildAt(i));
                        {
                            nonOverflowWidth += dividerWidth;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            View v;
            v = getChildAt(0);
            int width;
            width = v.getMeasuredWidth();
            int height;
            height = v.getMeasuredHeight();
            int midHorizontal;
            midHorizontal = (right - left) / 2;
            int l;
            l = midHorizontal - width / 2;
            int t;
            t = midVertical - height / 2;
            v.layout(l, t, l + width, t + height);
        } //End block
        int spacerCount;
        spacerCount = nonOverflowCount - (hasOverflow ? 0 : 1);//DSFIXME:  CODE0008: Nested ternary operator in expression
        int spacerSize;
        spacerSize = Math.max(0, spacerCount > 0 ? widthRemaining / spacerCount : 0);//DSFIXME:  CODE0008: Nested ternary operator in expression
        int startLeft;
        startLeft = getPaddingLeft();
        {
            int i;
            i = 0;
            {
                View v;
                v = getChildAt(i);
                LayoutParams lp;
                lp = (LayoutParams) v.getLayoutParams();
                {
                    boolean var49B93947E8B636089049537FC51034AE_385228182 = (v.getVisibility() == GONE || lp.isOverflowButton);
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
        addTaint(changed);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.248 -0400", hash_original_method = "BCFF92F724E40A93547AD27810B374B7", hash_generated_method = "20B039D9957A5ED6936C442629CD13D4")
    @Override
    public void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        mPresenter.dismissPopupMenus();
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //mPresenter.dismissPopupMenus();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.248 -0400", hash_original_method = "9F44211E52A7149BFED02520B6DEF800", hash_generated_method = "10758882632C3F887E9EC93AD25AEE4E")
    public boolean isOverflowReserved() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1258444897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1258444897;
        // ---------- Original Method ----------
        //return mReserveOverflow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.248 -0400", hash_original_method = "F5103BD0EA93D884CF8413DB778005C1", hash_generated_method = "15B323109E8BF25E66710A01C5BEDE02")
    public void setOverflowReserved(boolean reserveOverflow) {
        mReserveOverflow = reserveOverflow;
        // ---------- Original Method ----------
        //mReserveOverflow = reserveOverflow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.249 -0400", hash_original_method = "DEBB4048965D8045F192555AB279F2BA", hash_generated_method = "E5F6B227ECDE4B8A236376B51E7E2984")
    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1072746613 = null; //Variable for return #1
        LayoutParams params;
        params = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        varB4EAC82CA7396A68D541C85D26508E83_1072746613 = params;
        varB4EAC82CA7396A68D541C85D26508E83_1072746613.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1072746613;
        // ---------- Original Method ----------
        //LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
                //LayoutParams.WRAP_CONTENT);
        //params.gravity = Gravity.CENTER_VERTICAL;
        //return params;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.249 -0400", hash_original_method = "AED9080C69042489485342721EE0B0B1", hash_generated_method = "752E614A0739BB0FBB629DDC8D2D7C1D")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_407233620 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_407233620 = new LayoutParams(getContext(), attrs);
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_407233620.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_407233620;
        // ---------- Original Method ----------
        //return new LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.250 -0400", hash_original_method = "6543FCE3043AA8E09E4AB46D137D1290", hash_generated_method = "6B9CA1B1873B9B84B25B800F16D57B5E")
    @Override
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1826041000 = null; //Variable for return #1
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1074682122 = null; //Variable for return #2
        {
            LayoutParams result;
            result = new LayoutParams((LayoutParams) p);
            {
                result.gravity = Gravity.CENTER_VERTICAL;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1826041000 = result;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1074682122 = generateDefaultLayoutParams();
        addTaint(p.getTaint());
        LayoutParams varA7E53CE21691AB073D9660D615818899_1042762836; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1042762836 = varB4EAC82CA7396A68D541C85D26508E83_1826041000;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1042762836 = varB4EAC82CA7396A68D541C85D26508E83_1074682122;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1042762836.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1042762836;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.250 -0400", hash_original_method = "C7A39F9D75FC22971A40D0A54E61424A", hash_generated_method = "5E667EE367101EE6D48658FEBDFAE2BD")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1355556878 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1355556878;
        // ---------- Original Method ----------
        //return p != null && p instanceof LayoutParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.257 -0400", hash_original_method = "AF673847AD60845228ED5C7DBF294789", hash_generated_method = "455516A3596F41AAA49CEA50F970D49A")
    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1230325389 = null; //Variable for return #1
        LayoutParams result;
        result = generateDefaultLayoutParams();
        result.isOverflowButton = true;
        varB4EAC82CA7396A68D541C85D26508E83_1230325389 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1230325389.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1230325389;
        // ---------- Original Method ----------
        //LayoutParams result = generateDefaultLayoutParams();
        //result.isOverflowButton = true;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.262 -0400", hash_original_method = "52251A4D38FF83C9B55C46C571A25CAE", hash_generated_method = "C96D977E28796F0126FCEA2719297625")
    public boolean invokeItem(MenuItemImpl item) {
        boolean varC4283B859DE61FC835DAD199DF70A5FF_1383401263 = (mMenu.performItemAction(item, 0));
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_9508841 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_9508841;
        // ---------- Original Method ----------
        //return mMenu.performItemAction(item, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.308 -0400", hash_original_method = "DC1BDB1B98459EBD06B93B75A5D0D038", hash_generated_method = "BCB481709E9893C531D6AE80831D0E26")
    public int getWindowAnimations() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1916078238 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1916078238;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.308 -0400", hash_original_method = "EDB3B7E883C1486DD9AED3AB15C0E44B", hash_generated_method = "E50EB2D0FDCBBA00CCFEFF4A83375DDF")
    public void initialize(MenuBuilder menu) {
        mMenu = menu;
        // ---------- Original Method ----------
        //mMenu = menu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.309 -0400", hash_original_method = "9B32BE6DC23F13B511A55013BB42C488", hash_generated_method = "849FC984BE7A90A6D7A3D5C39FAB6B19")
    @Override
    protected boolean hasDividerBeforeChildAt(int childIndex) {
        View childBefore;
        childBefore = getChildAt(childIndex - 1);
        View child;
        child = getChildAt(childIndex);
        boolean result;
        result = false;
        {
            boolean var208B2155B1BCB653E775DCCF74C07E92_1511546933 = (childIndex < getChildCount() && childBefore instanceof ActionMenuChildView);
            {
                result |= ((ActionMenuChildView) childBefore).needsDividerAfter();
            } //End block
        } //End collapsed parenthetic
        {
            result |= ((ActionMenuChildView) child).needsDividerBefore();
        } //End block
        addTaint(childIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1606885821 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1606885821;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.309 -0400", hash_original_method = "87E5D39D1D82C11AB077A37A8786E27E", hash_generated_method = "E32016E13A17FC8DC055EFD6A1C50FC6")
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1593669153 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1593669153;
        // ---------- Original Method ----------
        //return false;
    }

    
    public static class LayoutParams extends LinearLayout.LayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.310 -0400", hash_original_field = "BC891BAF62FC8DDB492AD764B3ECB81D", hash_generated_field = "06AA5094630821EA9900D65F21750F66")

        @ViewDebug.ExportedProperty(category = "layout") public boolean isOverflowButton;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.310 -0400", hash_original_field = "E7EEEFE3F1DABDA5F3DF051861EACC10", hash_generated_field = "E1D8EB1EB816463205B2DDDF77A75406")

        @ViewDebug.ExportedProperty(category = "layout") public int cellsUsed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.310 -0400", hash_original_field = "676598AABCF21B3A19E3058EF2F83A07", hash_generated_field = "C29D7D4D121FC646F2A1DA13C25BE452")

        @ViewDebug.ExportedProperty(category = "layout") public int extraPixels;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.310 -0400", hash_original_field = "34ADC2548F6C20BFDE9DEF65C39FC4CD", hash_generated_field = "3C4066DDF8E8E17F2EF63131655754FD")

        @ViewDebug.ExportedProperty(category = "layout") public boolean expandable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.310 -0400", hash_original_field = "13DDB03DB32CFB3CB44D09E16E3A67C5", hash_generated_field = "E66E784ED3625370EFD8B17A60737371")

        @ViewDebug.ExportedProperty(category = "layout") public boolean preventEdgeOffset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.310 -0400", hash_original_field = "1A6130A21D7D578D81A168EBCF0D9921", hash_generated_field = "A93A7FF052663F567D43ED21528A4163")

        public boolean expanded;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.310 -0400", hash_original_method = "35869249D2D5BC08819A8507F87D33FD", hash_generated_method = "0DBD7DD67030DB53521B4CBB550D5399")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            addTaint(c.getTaint());
            addTaint(attrs.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.310 -0400", hash_original_method = "1AEEB2B6AE567062F04CDAB99E43CD26", hash_generated_method = "5F38F7306F4BCF2F00B15945AC196DD5")
        public  LayoutParams(LayoutParams other) {
            super((LinearLayout.LayoutParams) other);
            isOverflowButton = other.isOverflowButton;
            // ---------- Original Method ----------
            //isOverflowButton = other.isOverflowButton;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.325 -0400", hash_original_method = "5CB9C8D742F9EAB0281FCB85ADC86E3D", hash_generated_method = "1E4B24B979DDE2F01038D43AA1C9565A")
        public  LayoutParams(int width, int height) {
            super(width, height);
            isOverflowButton = false;
            addTaint(width);
            addTaint(height);
            // ---------- Original Method ----------
            //isOverflowButton = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.325 -0400", hash_original_method = "0D80B5BE9184580A03D083B0A94309F3", hash_generated_method = "EC402BDDF2DD511DF4ABF769A80D1437")
        public  LayoutParams(int width, int height, boolean isOverflowButton) {
            super(width, height);
            this.isOverflowButton = isOverflowButton;
            addTaint(width);
            addTaint(height);
            // ---------- Original Method ----------
            //this.isOverflowButton = isOverflowButton;
        }

        
    }


    
    public interface ActionMenuChildView {
        public boolean needsDividerBefore();
        public boolean needsDividerAfter();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.325 -0400", hash_original_field = "B9C30FC7E4A7160F4B35C4CEFD8C059C", hash_generated_field = "02AFED4D310BB3C61955829EF022518D")

    private static String TAG = "ActionMenuView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.325 -0400", hash_original_field = "31E1444ACC597D97F7D1F308819AC54B", hash_generated_field = "8CA4A800D900D5D6501D74A1D290A629")

    static int MIN_CELL_SIZE = 56;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.325 -0400", hash_original_field = "2BD151CF00588194F99C1F7C0113FF34", hash_generated_field = "BCF79347E61D6E19A720B5441E73A82E")

    static int GENERATED_ITEM_PADDING = 4;
}

