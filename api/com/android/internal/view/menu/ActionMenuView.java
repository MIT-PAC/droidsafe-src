package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

    /**
     * Measure a child view to fit within cell-based formatting. The child's width
     * will be measured to a whole multiple of cellSize.
     *
     * <p>Sets the expandable and cellsUsed fields of LayoutParams.
     *
     * @param child Child to measure
     * @param cellSize Size of one cell
     * @param cellsRemaining Number of cells remaining that this view can expand to fill
     * @param parentHeightMeasureSpec MeasureSpec used by the parent view
     * @param parentHeightPadding Padding present in the parent view
     * @return Number of cells this child was measured to occupy
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.796 -0500", hash_original_method = "3EE8D7D16F58FBE24D52688DB0D4BEBD", hash_generated_method = "B755F96AF94AB504804536B58F7E7090")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.749 -0500", hash_original_field = "320C79E83D057AE06FA097EB825F7D18", hash_generated_field = "1CEFC30E74C2ED26E1D7A5895C1A6938")

    private static final String TAG = "ActionMenuView";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.752 -0500", hash_original_field = "CBB9A87CCC818C67802089C94E9F7462", hash_generated_field = "C82EA13B7AFB56A9509B0706C650CC26")
    
    static final int MIN_CELL_SIZE = 56;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.754 -0500", hash_original_field = "B69ED2BFE64FDEE415EEACA8AA14E856", hash_generated_field = "7918CEA6EF4CC9E7E97331DC428C97AE")

    static final int GENERATED_ITEM_PADDING = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.756 -0500", hash_original_field = "E0FA7D9C40725579D8730D3DABE74643", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.758 -0500", hash_original_field = "E5A9CB2F2F54CC6E136BCFE6856F2EC9", hash_generated_field = "3619C222EA285420CD3DE70ECE0D1D48")

    private boolean mReserveOverflow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.761 -0500", hash_original_field = "56BE51BB984E57DB0E28F12A92854E0A", hash_generated_field = "BC36FBD9CCAFE590BF9A0B51503C858E")

    private ActionMenuPresenter mPresenter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.763 -0500", hash_original_field = "322BA3EACF3AE8682B8141C6B6B04B6F", hash_generated_field = "6B2CAAF6AA38EAEFE2FA3F0FE80C1E20")

    private boolean mFormatItems;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.765 -0500", hash_original_field = "BA6BF1005C9DC90A7A3E5E1AE1B8B2C1", hash_generated_field = "7ADECD8C88CFFA290657D73715D82527")

    private int mFormatItemsWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.768 -0500", hash_original_field = "D89719B11B3D07DF5BEDF9A3B5892A7C", hash_generated_field = "303D27EFA1C100E376A8416C573EAB8F")

    private int mMinCellSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.770 -0500", hash_original_field = "C0AE55BE014E315B6ADA8626221EC7E8", hash_generated_field = "32B1FF10CA48AFEEB7A5989848197D17")

    private int mGeneratedItemPadding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.772 -0500", hash_original_field = "F0607E7BB49C2550F4908E98FD6A00D2", hash_generated_field = "A7412B938C8635F667A20F8A5F45CA3A")

    private int mMeasuredExtraWidth;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.774 -0500", hash_original_method = "AC153E2863979DC17A482AC64988B640", hash_generated_method = "F29E54B2D2D6FAF44C6B2C23AD66A8B4")
    
public ActionMenuView(Context context) {
        this(context, null);
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.777 -0500", hash_original_method = "35E28BCF8B52367FF953A9B63C9F4F20", hash_generated_method = "1552265F67243F06076559D9E0410C2C")
    
public ActionMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBaselineAligned(false);
        final float density = context.getResources().getDisplayMetrics().density;
        mMinCellSize = (int) (MIN_CELL_SIZE * density);
        mGeneratedItemPadding = (int) (GENERATED_ITEM_PADDING * density);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.780 -0500", hash_original_method = "F8B2E0B9AF6B77951E8DA779DE9E37B4", hash_generated_method = "F57C2CCCDFA8C19F841E8A365C66C0C9")
    
public void setPresenter(ActionMenuPresenter presenter) {
        mPresenter = presenter;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.782 -0500", hash_original_method = "309FFF524EE8C98ED8919EC0ED593079", hash_generated_method = "641BEAE03E9F54FC51C2D17E3F4DDAF4")
    
public boolean isExpandedFormat() {
        return mFormatItems;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.785 -0500", hash_original_method = "8C9F73227D09E5C25F24B8EE1F20BF37", hash_generated_method = "527D610DE6C30D40E9BD8832382E920B")
    
@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mPresenter.updateMenuView(false);

        if (mPresenter != null && mPresenter.isOverflowMenuShowing()) {
            mPresenter.hideOverflowMenu();
            mPresenter.showOverflowMenu();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.787 -0500", hash_original_method = "7A0AC3F9A12B78835921801D3FB6DAA4", hash_generated_method = "C1C3D6ADF8BE2C75373C1966C533F1D8")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // If we've been given an exact size to match, apply special formatting during layout.
        final boolean wasFormatted = mFormatItems;
        mFormatItems = MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.EXACTLY;

        if (wasFormatted != mFormatItems) {
            mFormatItemsWidth = 0; // Reset this when switching modes
        }

        // Special formatting can change whether items can fit as action buttons.
        // Kick the menu and update presenters when this changes.
        final int widthSize = MeasureSpec.getMode(widthMeasureSpec);
        if (mFormatItems && mMenu != null && widthSize != mFormatItemsWidth) {
            mFormatItemsWidth = widthSize;
            mMenu.onItemsChanged(true);
        }

        if (mFormatItems) {
            onMeasureExactFormat(widthMeasureSpec, heightMeasureSpec);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.793 -0500", hash_original_method = "904CFC5C82A7517026F4582C82215F76", hash_generated_method = "D798BE971F883CA82659A3338E449641")
    
private void onMeasureExactFormat(int widthMeasureSpec, int heightMeasureSpec) {
        // We already know the width mode is EXACTLY if we're here.
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        final int widthPadding = getPaddingLeft() + getPaddingRight();
        final int heightPadding = getPaddingTop() + getPaddingBottom();

        widthSize -= widthPadding;

        // Divide the view into cells.
        final int cellCount = widthSize / mMinCellSize;
        final int cellSizeRemaining = widthSize % mMinCellSize;

        if (cellCount == 0) {
            // Give up, nothing fits.
            setMeasuredDimension(widthSize, 0);
            return;
        }

        final int cellSize = mMinCellSize + cellSizeRemaining / cellCount;

        int cellsRemaining = cellCount;
        int maxChildHeight = 0;
        int maxCellsUsed = 0;
        int expandableItemCount = 0;
        int visibleItemCount = 0;
        boolean hasOverflow = false;

        // This is used as a bitfield to locate the smallest items present. Assumes childCount < 64.
        long smallestItemsAt = 0;

        final int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() == GONE) continue;

            final boolean isGeneratedItem = child instanceof ActionMenuItemView;
            visibleItemCount++;

            if (isGeneratedItem) {
                // Reset padding for generated menu item views; it may change below
                // and views are recycled.
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

            // Overflow always gets 1 cell. No more, no less.
            final int cellsAvailable = lp.isOverflowButton ? 1 : cellsRemaining;

            final int cellsUsed = measureChildForCells(child, cellSize, cellsAvailable,
                    heightMeasureSpec, heightPadding);

            maxCellsUsed = Math.max(maxCellsUsed, cellsUsed);
            if (lp.expandable) expandableItemCount++;
            if (lp.isOverflowButton) hasOverflow = true;

            cellsRemaining -= cellsUsed;
            maxChildHeight = Math.max(maxChildHeight, child.getMeasuredHeight());
            if (cellsUsed == 1) smallestItemsAt |= (1 << i);
        }

        // When we have overflow and a single expanded (text) item, we want to try centering it
        // visually in the available space even though overflow consumes some of it.
        final boolean centerSingleExpandedItem = hasOverflow && visibleItemCount == 2;

        // Divide space for remaining cells if we have items that can expand.
        // Try distributing whole leftover cells to smaller items first.

        boolean needsExpansion = false;
        while (expandableItemCount > 0 && cellsRemaining > 0) {
            int minCells = Integer.MAX_VALUE;
            long minCellsAt = 0; // Bit locations are indices of relevant child views
            int minCellsItemCount = 0;
            for (int i = 0; i < childCount; i++) {
                final View child = getChildAt(i);
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();

                // Don't try to expand items that shouldn't.
                if (!lp.expandable) continue;

                // Mark indices of children that can receive an extra cell.
                if (lp.cellsUsed < minCells) {
                    minCells = lp.cellsUsed;
                    minCellsAt = 1 << i;
                    minCellsItemCount = 1;
                } else if (lp.cellsUsed == minCells) {
                    minCellsAt |= 1 << i;
                    minCellsItemCount++;
                }
            }

            // Items that get expanded will always be in the set of smallest items when we're done.
            smallestItemsAt |= minCellsAt;

            if (minCellsItemCount > cellsRemaining) break; // Couldn't expand anything evenly. Stop.

            // We have enough cells, all minimum size items will be incremented.
            minCells++;

            for (int i = 0; i < childCount; i++) {
                final View child = getChildAt(i);
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if ((minCellsAt & (1 << i)) == 0) {
                    // If this item is already at our small item count, mark it for later.
                    if (lp.cellsUsed == minCells) smallestItemsAt |= 1 << i;
                    continue;
                }

                if (centerSingleExpandedItem && lp.preventEdgeOffset && cellsRemaining == 1) {
                    // Add padding to this item such that it centers.
                    child.setPadding(mGeneratedItemPadding + cellSize, 0, mGeneratedItemPadding, 0);
                }
                lp.cellsUsed++;
                lp.expanded = true;
                cellsRemaining--;
            }

            needsExpansion = true;
        }

        // Divide any space left that wouldn't divide along cell boundaries
        // evenly among the smallest items

        final boolean singleItem = !hasOverflow && visibleItemCount == 1;
        if (cellsRemaining > 0 && smallestItemsAt != 0 &&
                (cellsRemaining < visibleItemCount - 1 || singleItem || maxCellsUsed > 1)) {
            float expandCount = Long.bitCount(smallestItemsAt);

            if (!singleItem) {
                // The items at the far edges may only expand by half in order to pin to either side.
                if ((smallestItemsAt & 1) != 0) {
                    LayoutParams lp = (LayoutParams) getChildAt(0).getLayoutParams();
                    if (!lp.preventEdgeOffset) expandCount -= 0.5f;
                }
                if ((smallestItemsAt & (1 << (childCount - 1))) != 0) {
                    LayoutParams lp = ((LayoutParams) getChildAt(childCount - 1).getLayoutParams());
                    if (!lp.preventEdgeOffset) expandCount -= 0.5f;
                }
            }

            final int extraPixels = expandCount > 0 ?
                    (int) (cellsRemaining * cellSize / expandCount) : 0;

            for (int i = 0; i < childCount; i++) {
                if ((smallestItemsAt & (1 << i)) == 0) continue;

                final View child = getChildAt(i);
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (child instanceof ActionMenuItemView) {
                    // If this is one of our views, expand and measure at the larger size.
                    lp.extraPixels = extraPixels;
                    lp.expanded = true;
                    if (i == 0 && !lp.preventEdgeOffset) {
                        // First item gets part of its new padding pushed out of sight.
                        // The last item will get this implicitly from layout.
                        lp.leftMargin = -extraPixels / 2;
                    }
                    needsExpansion = true;
                } else if (lp.isOverflowButton) {
                    lp.extraPixels = extraPixels;
                    lp.expanded = true;
                    lp.rightMargin = -extraPixels / 2;
                    needsExpansion = true;
                } else {
                    // If we don't know what it is, give it some margins instead
                    // and let it center within its space. We still want to pin
                    // against the edges.
                    if (i != 0) {
                        lp.leftMargin = extraPixels / 2;
                    }
                    if (i != childCount - 1) {
                        lp.rightMargin = extraPixels / 2;
                    }
                }
            }

            cellsRemaining = 0;
        }

        // Remeasure any items that have had extra space allocated to them.
        if (needsExpansion) {
            int heightSpec = MeasureSpec.makeMeasureSpec(heightSize - heightPadding, heightMode);
            for (int i = 0; i < childCount; i++) {
                final View child = getChildAt(i);
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();

                if (!lp.expanded) continue;

                final int width = lp.cellsUsed * cellSize + lp.extraPixels;
                child.measure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY), heightSpec);
            }
        }

        if (heightMode != MeasureSpec.EXACTLY) {
            heightSize = maxChildHeight;
        }

        setMeasuredDimension(widthSize, heightSize);
        mMeasuredExtraWidth = cellsRemaining * cellSize;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.800 -0500", hash_original_method = "CF95DF9C40DBA0243EC42554D6345F0F", hash_generated_method = "965A3FFB0A24308148D72367A0BFBD87")
    
@Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (!mFormatItems) {
            super.onLayout(changed, left, top, right, bottom);
            return;
        }

        final int childCount = getChildCount();
        final int midVertical = (top + bottom) / 2;
        final int dividerWidth = getDividerWidth();
        int overflowWidth = 0;
        int nonOverflowWidth = 0;
        int nonOverflowCount = 0;
        int widthRemaining = right - left - getPaddingRight() - getPaddingLeft();
        boolean hasOverflow = false;
        for (int i = 0; i < childCount; i++) {
            final View v = getChildAt(i);
            if (v.getVisibility() == GONE) {
                continue;
            }

            LayoutParams p = (LayoutParams) v.getLayoutParams();
            if (p.isOverflowButton) {
                overflowWidth = v.getMeasuredWidth();
                if (hasDividerBeforeChildAt(i)) {
                    overflowWidth += dividerWidth;
                }

                int height = v.getMeasuredHeight();
                int r = getWidth() - getPaddingRight() - p.rightMargin;
                int l = r - overflowWidth;
                int t = midVertical - (height / 2);
                int b = t + height;
                v.layout(l, t, r, b);

                widthRemaining -= overflowWidth;
                hasOverflow = true;
            } else {
                final int size = v.getMeasuredWidth() + p.leftMargin + p.rightMargin;
                nonOverflowWidth += size;
                widthRemaining -= size;
                if (hasDividerBeforeChildAt(i)) {
                    nonOverflowWidth += dividerWidth;
                }
                nonOverflowCount++;
            }
        }

        if (childCount == 1 && !hasOverflow) {
            // Center a single child
            final View v = getChildAt(0);
            final int width = v.getMeasuredWidth();
            final int height = v.getMeasuredHeight();
            final int midHorizontal = (right - left) / 2;
            final int l = midHorizontal - width / 2;
            final int t = midVertical - height / 2;
            v.layout(l, t, l + width, t + height);
            return;
        }

        final int spacerCount = nonOverflowCount - (hasOverflow ? 0 : 1);
        final int spacerSize = Math.max(0, spacerCount > 0 ? widthRemaining / spacerCount : 0);

        int startLeft = getPaddingLeft();
        for (int i = 0; i < childCount; i++) {
            final View v = getChildAt(i);
            final LayoutParams lp = (LayoutParams) v.getLayoutParams();
            if (v.getVisibility() == GONE || lp.isOverflowButton) {
                continue;
            }

            startLeft += lp.leftMargin;
            int width = v.getMeasuredWidth();
            int height = v.getMeasuredHeight();
            int t = midVertical - height / 2;
            v.layout(startLeft, t, startLeft + width, t + height);
            startLeft += width + lp.rightMargin + spacerSize;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.803 -0500", hash_original_method = "BCFF92F724E40A93547AD27810B374B7", hash_generated_method = "A84D72B361AE36102DA6C6534829A3F9")
    
@Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mPresenter.dismissPopupMenus();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.805 -0500", hash_original_method = "9F44211E52A7149BFED02520B6DEF800", hash_generated_method = "139EA482158AF5CCB7770B48716B0B5E")
    
public boolean isOverflowReserved() {
        return mReserveOverflow;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.808 -0500", hash_original_method = "F5103BD0EA93D884CF8413DB778005C1", hash_generated_method = "B82F98E8C95E384D621AB24537CC57B4")
    
public void setOverflowReserved(boolean reserveOverflow) {
        mReserveOverflow = reserveOverflow;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.810 -0500", hash_original_method = "DEBB4048965D8045F192555AB279F2BA", hash_generated_method = "29BEB9B545D88184017C9E3123770325")
    
@Override
    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        return params;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.812 -0500", hash_original_method = "AED9080C69042489485342721EE0B0B1", hash_generated_method = "4AD7665169039F61ACFF3C8481974477")
    
@Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.815 -0500", hash_original_method = "6543FCE3043AA8E09E4AB46D137D1290", hash_generated_method = "26BFBF2498F471584ACFC84914ECE101")
    
@Override
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        if (p instanceof LayoutParams) {
            LayoutParams result = new LayoutParams((LayoutParams) p);
            if (result.gravity <= Gravity.NO_GRAVITY) {
                result.gravity = Gravity.CENTER_VERTICAL;
            }
            return result;
        }
        return generateDefaultLayoutParams();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.817 -0500", hash_original_method = "C7A39F9D75FC22971A40D0A54E61424A", hash_generated_method = "7E38BA9E25DA97EDD4FE18FB943B604C")
    
@Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p != null && p instanceof LayoutParams;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.819 -0500", hash_original_method = "AF673847AD60845228ED5C7DBF294789", hash_generated_method = "16FD06704D4C3D23EE9E8C85745CB17B")
    
public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams result = generateDefaultLayoutParams();
        result.isOverflowButton = true;
        return result;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.822 -0500", hash_original_method = "52251A4D38FF83C9B55C46C571A25CAE", hash_generated_method = "E4D0C6B553755CCD3E1324292EB5E10F")
    
public boolean invokeItem(MenuItemImpl item) {
        return mMenu.performItemAction(item, 0);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.824 -0500", hash_original_method = "DC1BDB1B98459EBD06B93B75A5D0D038", hash_generated_method = "7D099F9FB44E7521834F67AB97BE9EAC")
    
public int getWindowAnimations() {
        return 0;
    }
    
    public static class LayoutParams extends LinearLayout.LayoutParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.837 -0500", hash_original_field = "C0B8632FE61D69DA3E730B1072943D77", hash_generated_field = "06AA5094630821EA9900D65F21750F66")

        @ViewDebug.ExportedProperty(category = "layout")
        public boolean isOverflowButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.839 -0500", hash_original_field = "F659A9D09BEE6C3649CCED37773D3DA6", hash_generated_field = "E1D8EB1EB816463205B2DDDF77A75406")

        @ViewDebug.ExportedProperty(category = "layout")
        public int cellsUsed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.842 -0500", hash_original_field = "A7BED7F2CCBFDAB11050911A574E4797", hash_generated_field = "C29D7D4D121FC646F2A1DA13C25BE452")

        @ViewDebug.ExportedProperty(category = "layout")
        public int extraPixels;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.844 -0500", hash_original_field = "41D64CE3F517397634F74E6A8F8D6B73", hash_generated_field = "3C4066DDF8E8E17F2EF63131655754FD")

        @ViewDebug.ExportedProperty(category = "layout")
        public boolean expandable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.846 -0500", hash_original_field = "24049946C405019C5406CB67BB4299E6", hash_generated_field = "E66E784ED3625370EFD8B17A60737371")

        @ViewDebug.ExportedProperty(category = "layout")
        public boolean preventEdgeOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.848 -0500", hash_original_field = "AE9CFB22956097C5084AEEC042601338", hash_generated_field = "A93A7FF052663F567D43ED21528A4163")

        public boolean expanded;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.852 -0500", hash_original_method = "35869249D2D5BC08819A8507F87D33FD", hash_generated_method = "72A2ECA2CF4C647C2D28F670D4DC27E1")
        
public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.854 -0500", hash_original_method = "1AEEB2B6AE567062F04CDAB99E43CD26", hash_generated_method = "E072C50FA001C088868A1D711A3353CC")
        
public LayoutParams(LayoutParams other) {
            super((LinearLayout.LayoutParams) other);
            isOverflowButton = other.isOverflowButton;
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.857 -0500", hash_original_method = "5CB9C8D742F9EAB0281FCB85ADC86E3D", hash_generated_method = "FEB49580069182443E8876B33915FFCA")
        
public LayoutParams(int width, int height) {
            super(width, height);
            isOverflowButton = false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.860 -0500", hash_original_method = "0D80B5BE9184580A03D083B0A94309F3", hash_generated_method = "32540CBAF0F34ACADD4E3FE7E6D630AA")
        
public LayoutParams(int width, int height, boolean isOverflowButton) {
            super(width, height);
            this.isOverflowButton = isOverflowButton;
        }
        
    }
    
    public interface ActionMenuChildView {
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public boolean needsDividerBefore();
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public boolean needsDividerAfter();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.826 -0500", hash_original_method = "EDB3B7E883C1486DD9AED3AB15C0E44B", hash_generated_method = "4239B6BD8C1C7C2E7AC8C3A17352B70E")
    
public void initialize(MenuBuilder menu) {
        mMenu = menu;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.829 -0500", hash_original_method = "9B32BE6DC23F13B511A55013BB42C488", hash_generated_method = "ACD3FB0858E1D3C7E682570848DAAA2A")
    
@Override
    protected boolean hasDividerBeforeChildAt(int childIndex) {
        final View childBefore = getChildAt(childIndex - 1);
        final View child = getChildAt(childIndex);
        boolean result = false;
        if (childIndex < getChildCount() && childBefore instanceof ActionMenuChildView) {
            result |= ((ActionMenuChildView) childBefore).needsDividerAfter();
        }
        if (childIndex > 0 && child instanceof ActionMenuChildView) {
            result |= ((ActionMenuChildView) child).needsDividerBefore();
        }
        return result;
    }

    @DSSpec(DSCat.TO_MODEL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.831 -0500", hash_original_method = "87E5D39D1D82C11AB077A37A8786E27E", hash_generated_method = "0CF47D3AADD137C907CE91EE0D9110E3")
    
public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return false;
    }
}

