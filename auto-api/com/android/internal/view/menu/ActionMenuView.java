package com.android.internal.view.menu;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.036 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.036 -0400", hash_original_field = "0E213F9463B6EFE55ADA2109C5E5DC56", hash_generated_field = "3619C222EA285420CD3DE70ECE0D1D48")

    private boolean mReserveOverflow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.036 -0400", hash_original_field = "24BE2DD94A844242C35ABB990B9E3B93", hash_generated_field = "BC36FBD9CCAFE590BF9A0B51503C858E")

    private ActionMenuPresenter mPresenter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.036 -0400", hash_original_field = "91949478145170F53463EA7B1D93DAAB", hash_generated_field = "6B2CAAF6AA38EAEFE2FA3F0FE80C1E20")

    private boolean mFormatItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.036 -0400", hash_original_field = "9EAE809C529287B9D5ACFCE152326FD4", hash_generated_field = "7ADECD8C88CFFA290657D73715D82527")

    private int mFormatItemsWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.036 -0400", hash_original_field = "C0CB7E511A75AFCB98C3B0342F6802E9", hash_generated_field = "303D27EFA1C100E376A8416C573EAB8F")

    private int mMinCellSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.036 -0400", hash_original_field = "25DB108BA28ED0013D5558630CEBAF2D", hash_generated_field = "32B1FF10CA48AFEEB7A5989848197D17")

    private int mGeneratedItemPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.036 -0400", hash_original_field = "B1E8AEB61B975F039E0DDB567198268F", hash_generated_field = "A7412B938C8635F667A20F8A5F45CA3A")

    private int mMeasuredExtraWidth;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.036 -0400", hash_original_method = "AC153E2863979DC17A482AC64988B640", hash_generated_method = "5F3CB5A8A49E2CC16CAE28F7B3615920")
    public  ActionMenuView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.037 -0400", hash_original_method = "35E28BCF8B52367FF953A9B63C9F4F20", hash_generated_method = "DD41C7A3B7CE227B1CC745EF8395A655")
    public  ActionMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBaselineAligned(false);
        final float density = context.getResources().getDisplayMetrics().density;
        mMinCellSize = (int) (MIN_CELL_SIZE * density);
        mGeneratedItemPadding = (int) (GENERATED_ITEM_PADDING * density);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.037 -0400", hash_original_method = "F8B2E0B9AF6B77951E8DA779DE9E37B4", hash_generated_method = "2D2E0A69D628FF0C713DCBD58D8FEF6B")
    public void setPresenter(ActionMenuPresenter presenter) {
        mPresenter = presenter;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.038 -0400", hash_original_method = "309FFF524EE8C98ED8919EC0ED593079", hash_generated_method = "DC80F32AB4238BE885FC58E013AB4876")
    public boolean isExpandedFormat() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1059515851 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1059515851;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.038 -0400", hash_original_method = "8C9F73227D09E5C25F24B8EE1F20BF37", hash_generated_method = "C330A2DBAC1838C510CABEA6193C4D42")
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        
        super.onConfigurationChanged(newConfig);
        mPresenter.updateMenuView(false);
        {
            boolean varFFBC8C8E161FD649FDC01AB3F026CE61_1072624622 = (mPresenter != null && mPresenter.isOverflowMenuShowing());
            {
                mPresenter.hideOverflowMenu();
                mPresenter.showOverflowMenu();
            } 
        } 
        addTaint(newConfig.getTaint());
        
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.038 -0400", hash_original_method = "7A0AC3F9A12B78835921801D3FB6DAA4", hash_generated_method = "D0EE72DA6327C4CE4864E657ED394F31")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        final boolean wasFormatted = mFormatItems;
        mFormatItems = MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.EXACTLY;
        {
            mFormatItemsWidth = 0;
        } 
        final int widthSize = MeasureSpec.getMode(widthMeasureSpec);
        {
            mFormatItemsWidth = widthSize;
            mMenu.onItemsChanged(true);
        } 
        {
            onMeasureExactFormat(widthMeasureSpec, heightMeasureSpec);
        } 
        {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } 
        addTaint(heightMeasureSpec);
        
        
        
        
            
        
        
        
            
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.042 -0400", hash_original_method = "904CFC5C82A7517026F4582C82215F76", hash_generated_method = "FB5008145639E98863CB190A1B03B6C6")
    private void onMeasureExactFormat(int widthMeasureSpec, int heightMeasureSpec) {
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        final int widthPadding = getPaddingLeft() + getPaddingRight();
        final int heightPadding = getPaddingTop() + getPaddingBottom();
        widthSize -= widthPadding;
        final int cellCount = widthSize / mMinCellSize;
        final int cellSizeRemaining = widthSize % mMinCellSize;
        {
            setMeasuredDimension(widthSize, 0);
        } 
        final int cellSize = mMinCellSize + cellSizeRemaining / cellCount;
        int cellsRemaining = cellCount;
        int maxChildHeight = 0;
        int maxCellsUsed = 0;
        int expandableItemCount = 0;
        int visibleItemCount = 0;
        boolean hasOverflow = false;
        long smallestItemsAt = 0;
        final int childCount = getChildCount();
        {
            int i = 0;
            {
                final View child = getChildAt(i);
                {
                    boolean varE5A6421440835A22FD9C00B75E3D1565_520767611 = (child.getVisibility() == GONE);
                } 
                final boolean isGeneratedItem = child instanceof ActionMenuItemView;
                {
                    child.setPadding(mGeneratedItemPadding, 0, mGeneratedItemPadding, 0);
                } 
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
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
                final int cellsUsed = measureChildForCells(child, cellSize, cellsAvailable,
                    heightMeasureSpec, heightPadding);
                maxCellsUsed = Math.max(maxCellsUsed, cellsUsed);
                hasOverflow = true;
                cellsRemaining -= cellsUsed;
                maxChildHeight = Math.max(maxChildHeight, child.getMeasuredHeight());
                smallestItemsAt |= (1 << i);
            } 
        } 
        final boolean centerSingleExpandedItem = hasOverflow && visibleItemCount == 2;
        boolean needsExpansion = false;
        {
            int minCells = Integer.MAX_VALUE;
            long minCellsAt = 0;
            int minCellsItemCount = 0;
            {
                int i = 0;
                {
                    final View child = getChildAt(i);
                    final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                    {
                        minCells = lp.cellsUsed;
                        minCellsAt = 1 << i;
                        minCellsItemCount = 1;
                    } 
                    {
                        minCellsAt |= 1 << i;
                    } 
                } 
            } 
            smallestItemsAt |= minCellsAt;
            {
                int i = 0;
                {
                    final View child = getChildAt(i);
                    final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                    {
                        smallestItemsAt |= 1 << i;
                    } 
                    {
                        child.setPadding(mGeneratedItemPadding + cellSize, 0, mGeneratedItemPadding, 0);
                    } 
                    lp.expanded = true;
                } 
            } 
            needsExpansion = true;
        } 
        final boolean singleItem = !hasOverflow && visibleItemCount == 1;
        {
            float expandCount = Long.bitCount(smallestItemsAt);
            {
                {
                    LayoutParams lp = (LayoutParams) getChildAt(0).getLayoutParams();
                    expandCount -= 0.5f;
                } 
                {
                    LayoutParams lp = ((LayoutParams) getChildAt(childCount - 1).getLayoutParams());
                    expandCount -= 0.5f;
                } 
            } 
            int extraPixels;
            extraPixels = (int) (cellsRemaining * cellSize / expandCount);
            extraPixels = 0;
            {
                int i = 0;
                {
                    final View child = getChildAt(i);
                    final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                    {
                        lp.extraPixels = extraPixels;
                        lp.expanded = true;
                        {
                            lp.leftMargin = -extraPixels / 2;
                        } 
                        needsExpansion = true;
                    } 
                    {
                        lp.extraPixels = extraPixels;
                        lp.expanded = true;
                        lp.rightMargin = -extraPixels / 2;
                        needsExpansion = true;
                    } 
                    {
                        {
                            lp.leftMargin = extraPixels / 2;
                        } 
                        {
                            lp.rightMargin = extraPixels / 2;
                        } 
                    } 
                } 
            } 
            cellsRemaining = 0;
        } 
        {
            int heightSpec = MeasureSpec.makeMeasureSpec(heightSize - heightPadding, heightMode);
            {
                int i = 0;
                {
                    final View child = getChildAt(i);
                    final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                    final int width = lp.cellsUsed * cellSize + lp.extraPixels;
                    child.measure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY), heightSpec);
                } 
            } 
        } 
        {
            heightSize = maxChildHeight;
        } 
        setMeasuredDimension(widthSize, heightSize);
        mMeasuredExtraWidth = cellsRemaining * cellSize;
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.043 -0400", hash_original_method = "CF95DF9C40DBA0243EC42554D6345F0F", hash_generated_method = "03AFC73D1E70E9B1200DE4690A1B257D")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        
        {
            super.onLayout(changed, left, top, right, bottom);
        } 
        final int childCount = getChildCount();
        final int midVertical = (top + bottom) / 2;
        final int dividerWidth = getDividerWidth();
        int overflowWidth = 0;
        int nonOverflowWidth = 0;
        int nonOverflowCount = 0;
        int widthRemaining = right - left - getPaddingRight() - getPaddingLeft();
        boolean hasOverflow = false;
        {
            int i = 0;
            {
                final View v = getChildAt(i);
                {
                    boolean varDA63034006064F4C7F0A3E1C4DB8D066_1679965009 = (v.getVisibility() == GONE);
                } 
                LayoutParams p = (LayoutParams) v.getLayoutParams();
                {
                    overflowWidth = v.getMeasuredWidth();
                    {
                        boolean varCAC00097357B8B7C575A4308C6C0DBA2_568719820 = (hasDividerBeforeChildAt(i));
                        {
                            overflowWidth += dividerWidth;
                        } 
                    } 
                    int height = v.getMeasuredHeight();
                    int r = getWidth() - getPaddingRight() - p.rightMargin;
                    int l = r - overflowWidth;
                    int t = midVertical - (height / 2);
                    int b = t + height;
                    v.layout(l, t, r, b);
                    widthRemaining -= overflowWidth;
                    hasOverflow = true;
                } 
                {
                    final int size = v.getMeasuredWidth() + p.leftMargin + p.rightMargin;
                    nonOverflowWidth += size;
                    widthRemaining -= size;
                    {
                        boolean varCAC00097357B8B7C575A4308C6C0DBA2_1959539213 = (hasDividerBeforeChildAt(i));
                        {
                            nonOverflowWidth += dividerWidth;
                        } 
                    } 
                } 
            } 
        } 
        {
            final View v = getChildAt(0);
            final int width = v.getMeasuredWidth();
            final int height = v.getMeasuredHeight();
            final int midHorizontal = (right - left) / 2;
            final int l = midHorizontal - width / 2;
            final int t = midVertical - height / 2;
            v.layout(l, t, l + width, t + height);
        } 
        final int spacerCount = nonOverflowCount - (hasOverflow ? 0 : 1);
        final int spacerSize = Math.max(0, spacerCount > 0 ? widthRemaining / spacerCount : 0);
        int startLeft = getPaddingLeft();
        {
            int i = 0;
            {
                final View v = getChildAt(i);
                final LayoutParams lp = (LayoutParams) v.getLayoutParams();
                {
                    boolean var49B93947E8B636089049537FC51034AE_1374502491 = (v.getVisibility() == GONE || lp.isOverflowButton);
                } 
                startLeft += lp.leftMargin;
                int width = v.getMeasuredWidth();
                int height = v.getMeasuredHeight();
                int t = midVertical - height / 2;
                v.layout(startLeft, t, startLeft + width, t + height);
                startLeft += width + lp.rightMargin + spacerSize;
            } 
        } 
        addTaint(changed);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.044 -0400", hash_original_method = "BCFF92F724E40A93547AD27810B374B7", hash_generated_method = "20B039D9957A5ED6936C442629CD13D4")
    @Override
    public void onDetachedFromWindow() {
        
        super.onDetachedFromWindow();
        mPresenter.dismissPopupMenus();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.044 -0400", hash_original_method = "9F44211E52A7149BFED02520B6DEF800", hash_generated_method = "D058EB07BBDF1FA2BBF068585ED0D646")
    public boolean isOverflowReserved() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_76459072 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_76459072;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.044 -0400", hash_original_method = "F5103BD0EA93D884CF8413DB778005C1", hash_generated_method = "15B323109E8BF25E66710A01C5BEDE02")
    public void setOverflowReserved(boolean reserveOverflow) {
        mReserveOverflow = reserveOverflow;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.045 -0400", hash_original_method = "DEBB4048965D8045F192555AB279F2BA", hash_generated_method = "8DD856CA8D356A2EBECD078666C80554")
    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1808188493 = null; 
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        varB4EAC82CA7396A68D541C85D26508E83_1808188493 = params;
        varB4EAC82CA7396A68D541C85D26508E83_1808188493.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1808188493;
        
        
                
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.045 -0400", hash_original_method = "AED9080C69042489485342721EE0B0B1", hash_generated_method = "2F0FC8FCF5EE311B307725FD000BDBDD")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_406312679 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_406312679 = new LayoutParams(getContext(), attrs);
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_406312679.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_406312679;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.046 -0400", hash_original_method = "6543FCE3043AA8E09E4AB46D137D1290", hash_generated_method = "50E3BB4A61B2179DD8F603A74A2164A3")
    @Override
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1132718823 = null; 
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_222110269 = null; 
        {
            LayoutParams result = new LayoutParams((LayoutParams) p);
            {
                result.gravity = Gravity.CENTER_VERTICAL;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1132718823 = result;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_222110269 = generateDefaultLayoutParams();
        addTaint(p.getTaint());
        LayoutParams varA7E53CE21691AB073D9660D615818899_1184056355; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1184056355 = varB4EAC82CA7396A68D541C85D26508E83_1132718823;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1184056355 = varB4EAC82CA7396A68D541C85D26508E83_222110269;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1184056355.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1184056355;
        
        
            
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.046 -0400", hash_original_method = "C7A39F9D75FC22971A40D0A54E61424A", hash_generated_method = "D197AEC158DF8BB7D28D908EEC4C4D43")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_358048680 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_358048680;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.047 -0400", hash_original_method = "AF673847AD60845228ED5C7DBF294789", hash_generated_method = "E84C5809E7645AC184EB9ABB2DC1B8D8")
    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1126159426 = null; 
        LayoutParams result = generateDefaultLayoutParams();
        result.isOverflowButton = true;
        varB4EAC82CA7396A68D541C85D26508E83_1126159426 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1126159426.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1126159426;
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.047 -0400", hash_original_method = "52251A4D38FF83C9B55C46C571A25CAE", hash_generated_method = "F958E6D54D5C913791B64D50C3C5E839")
    public boolean invokeItem(MenuItemImpl item) {
        boolean varC4283B859DE61FC835DAD199DF70A5FF_1957850860 = (mMenu.performItemAction(item, 0));
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1551468869 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1551468869;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.047 -0400", hash_original_method = "DC1BDB1B98459EBD06B93B75A5D0D038", hash_generated_method = "6ED361B86F2FA2C49A1C30FBB41EB620")
    public int getWindowAnimations() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1314623281 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1314623281;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.047 -0400", hash_original_method = "EDB3B7E883C1486DD9AED3AB15C0E44B", hash_generated_method = "E50EB2D0FDCBBA00CCFEFF4A83375DDF")
    public void initialize(MenuBuilder menu) {
        mMenu = menu;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.048 -0400", hash_original_method = "9B32BE6DC23F13B511A55013BB42C488", hash_generated_method = "951571323057A0B340D290FD58C91F41")
    @Override
    protected boolean hasDividerBeforeChildAt(int childIndex) {
        final View childBefore = getChildAt(childIndex - 1);
        final View child = getChildAt(childIndex);
        boolean result = false;
        {
            boolean var208B2155B1BCB653E775DCCF74C07E92_1738566379 = (childIndex < getChildCount() && childBefore instanceof ActionMenuChildView);
            {
                result |= ((ActionMenuChildView) childBefore).needsDividerAfter();
            } 
        } 
        {
            result |= ((ActionMenuChildView) child).needsDividerBefore();
        } 
        addTaint(childIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_592013783 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_592013783;
        
        
        
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.048 -0400", hash_original_method = "87E5D39D1D82C11AB077A37A8786E27E", hash_generated_method = "E1ACE0FDBB74FC75D7A564996F2D5142")
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1192532941 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1192532941;
        
        
    }

    
    public static class LayoutParams extends LinearLayout.LayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.048 -0400", hash_original_field = "BC891BAF62FC8DDB492AD764B3ECB81D", hash_generated_field = "06AA5094630821EA9900D65F21750F66")

        @ViewDebug.ExportedProperty(category = "layout") public boolean isOverflowButton;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.048 -0400", hash_original_field = "E7EEEFE3F1DABDA5F3DF051861EACC10", hash_generated_field = "E1D8EB1EB816463205B2DDDF77A75406")

        @ViewDebug.ExportedProperty(category = "layout") public int cellsUsed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.048 -0400", hash_original_field = "676598AABCF21B3A19E3058EF2F83A07", hash_generated_field = "C29D7D4D121FC646F2A1DA13C25BE452")

        @ViewDebug.ExportedProperty(category = "layout") public int extraPixels;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.048 -0400", hash_original_field = "34ADC2548F6C20BFDE9DEF65C39FC4CD", hash_generated_field = "3C4066DDF8E8E17F2EF63131655754FD")

        @ViewDebug.ExportedProperty(category = "layout") public boolean expandable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.048 -0400", hash_original_field = "13DDB03DB32CFB3CB44D09E16E3A67C5", hash_generated_field = "E66E784ED3625370EFD8B17A60737371")

        @ViewDebug.ExportedProperty(category = "layout") public boolean preventEdgeOffset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.048 -0400", hash_original_field = "1A6130A21D7D578D81A168EBCF0D9921", hash_generated_field = "A93A7FF052663F567D43ED21528A4163")

        public boolean expanded;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.049 -0400", hash_original_method = "35869249D2D5BC08819A8507F87D33FD", hash_generated_method = "0DBD7DD67030DB53521B4CBB550D5399")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            addTaint(c.getTaint());
            addTaint(attrs.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.049 -0400", hash_original_method = "1AEEB2B6AE567062F04CDAB99E43CD26", hash_generated_method = "5F38F7306F4BCF2F00B15945AC196DD5")
        public  LayoutParams(LayoutParams other) {
            super((LinearLayout.LayoutParams) other);
            isOverflowButton = other.isOverflowButton;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.050 -0400", hash_original_method = "5CB9C8D742F9EAB0281FCB85ADC86E3D", hash_generated_method = "1E4B24B979DDE2F01038D43AA1C9565A")
        public  LayoutParams(int width, int height) {
            super(width, height);
            isOverflowButton = false;
            addTaint(width);
            addTaint(height);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.050 -0400", hash_original_method = "0D80B5BE9184580A03D083B0A94309F3", hash_generated_method = "EC402BDDF2DD511DF4ABF769A80D1437")
        public  LayoutParams(int width, int height, boolean isOverflowButton) {
            super(width, height);
            this.isOverflowButton = isOverflowButton;
            addTaint(width);
            addTaint(height);
            
            
        }

        
    }


    
    public interface ActionMenuChildView {
        public boolean needsDividerBefore();
        public boolean needsDividerAfter();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.050 -0400", hash_original_field = "B9C30FC7E4A7160F4B35C4CEFD8C059C", hash_generated_field = "1CEFC30E74C2ED26E1D7A5895C1A6938")

    private static final String TAG = "ActionMenuView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.050 -0400", hash_original_field = "31E1444ACC597D97F7D1F308819AC54B", hash_generated_field = "C82EA13B7AFB56A9509B0706C650CC26")

    static final int MIN_CELL_SIZE = 56;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.050 -0400", hash_original_field = "2BD151CF00588194F99C1F7C0113FF34", hash_generated_field = "7918CEA6EF4CC9E7E97331DC428C97AE")

    static final int GENERATED_ITEM_PADDING = 4;
}

