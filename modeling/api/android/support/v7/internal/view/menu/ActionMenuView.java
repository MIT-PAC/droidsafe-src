/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.support.v7.internal.view.menu;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v7.appcompat.R;
import android.support.v7.internal.widget.LinearLayoutICS;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;

/**
 * @hide
 */
public class ActionMenuView extends LinearLayoutICS // implements MenuBuilder.ItemInvoker //, MenuView 
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.556 -0400", hash_original_field = "320C79E83D057AE06FA097EB825F7D18", hash_generated_field = "1CEFC30E74C2ED26E1D7A5895C1A6938")

    private static final String TAG = "ActionMenuView";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.565 -0400", hash_original_field = "CBB9A87CCC818C67802089C94E9F7462", hash_generated_field = "C82EA13B7AFB56A9509B0706C650CC26")

    static final int MIN_CELL_SIZE = 56;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.573 -0400", hash_original_field = "B69ED2BFE64FDEE415EEACA8AA14E856", hash_generated_field = "7918CEA6EF4CC9E7E97331DC428C97AE")

    static final int GENERATED_ITEM_PADDING = 4;

    /**
     * Measure a child view to fit within cell-based formatting. The child's width will be measured
     * to a whole multiple of cellSize.
     *
     * <p>Sets the expandable and cellsUsed fields of LayoutParams.
     *
     * @param child                   Child to measure
     * @param cellSize                Size of one cell
     * @param cellsRemaining          Number of cells remaining that this view can expand to fill
     * @param parentHeightMeasureSpec MeasureSpec used by the parent view
     * @param parentHeightPadding     Padding present in the parent view
     * @return Number of cells this child was measured to occupy
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.829 -0400", hash_original_method = "095E841216803529C033AD610D8363A3", hash_generated_method = "A2185A5B418CBD78AA35043A072DA03D")
    
static int measureChildForCells(View child, int cellSize, int cellsRemaining,
            int parentHeightMeasureSpec, int parentHeightPadding) {
        final LayoutParams lp = (LayoutParams) child.getLayoutParams();

        final int childHeightSize = MeasureSpec.getSize(parentHeightMeasureSpec) -
                parentHeightPadding;
        final int childHeightMode = MeasureSpec.getMode(parentHeightMeasureSpec);
        final int childHeightSpec = MeasureSpec.makeMeasureSpec(childHeightSize, childHeightMode);

        /*
        final ActionMenuItemView itemView = child instanceof ActionMenuItemView ?
                (ActionMenuItemView) child : null;
        final boolean hasText = itemView != null && itemView.hasText();
        */
        
        boolean hasText = child.getTaintBoolean();

        int cellsUsed = 0;
        if (cellsRemaining > 0 && (!hasText || cellsRemaining >= 2)) {
            final int childWidthSpec = MeasureSpec.makeMeasureSpec(
                    cellSize * cellsRemaining, MeasureSpec.AT_MOST);
            child.measure(childWidthSpec, childHeightSpec);

            final int measuredWidth = child.getMeasuredWidth();
            cellsUsed = measuredWidth / cellSize;
            if (measuredWidth % cellSize != 0) {
                cellsUsed++;
            }
            if (hasText && cellsUsed < 2) {
                cellsUsed = 2;
            }
        }

        final boolean expandable = !lp.isOverflowButton && hasText;
        lp.expandable = expandable;

        lp.cellsUsed = cellsUsed;
        final int targetWidth = cellsUsed * cellSize;
        child.measure(MeasureSpec.makeMeasureSpec(targetWidth, MeasureSpec.EXACTLY),
                childHeightSpec);
        return cellsUsed;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.579 -0400", hash_original_field = "E0FA7D9C40725579D8730D3DABE74643", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.587 -0400", hash_original_field = "E5A9CB2F2F54CC6E136BCFE6856F2EC9", hash_generated_field = "3619C222EA285420CD3DE70ECE0D1D48")

    private boolean mReserveOverflow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.604 -0400", hash_original_field = "56BE51BB984E57DB0E28F12A92854E0A", hash_generated_field = "BC36FBD9CCAFE590BF9A0B51503C858E")

    private ActionMenuPresenter mPresenter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.612 -0400", hash_original_field = "322BA3EACF3AE8682B8141C6B6B04B6F", hash_generated_field = "6B2CAAF6AA38EAEFE2FA3F0FE80C1E20")

    private boolean mFormatItems;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.619 -0400", hash_original_field = "BA6BF1005C9DC90A7A3E5E1AE1B8B2C1", hash_generated_field = "7ADECD8C88CFFA290657D73715D82527")

    private int mFormatItemsWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.626 -0400", hash_original_field = "D89719B11B3D07DF5BEDF9A3B5892A7C", hash_generated_field = "303D27EFA1C100E376A8416C573EAB8F")

    private int mMinCellSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.632 -0400", hash_original_field = "C0AE55BE014E315B6ADA8626221EC7E8", hash_generated_field = "32B1FF10CA48AFEEB7A5989848197D17")

    private int mGeneratedItemPadding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.654 -0400", hash_original_field = "F0607E7BB49C2550F4908E98FD6A00D2", hash_generated_field = "A7412B938C8635F667A20F8A5F45CA3A")

    private int mMeasuredExtraWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.667 -0400", hash_original_field = "D977BC2C43F4E4D8C04D7659AC278603", hash_generated_field = "524DE9B53CBA3C5E6E7CD4DB4A997E70")

    private int mMaxItemHeight;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.674 -0400", hash_original_method = "AC153E2863979DC17A482AC64988B640", hash_generated_method = "F29E54B2D2D6FAF44C6B2C23AD66A8B4")
    
public ActionMenuView(Context context) {
        this(context, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.687 -0400", hash_original_method = "6C73FFBEB4E8AD142E8EBAAB5546B49B", hash_generated_method = "FB8757B423713BE2DBFCF3BCAE275F3B")
    
public ActionMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBaselineAligned(false);
        final float density = context.getResources().getDisplayMetrics().density;
        mMinCellSize = (int) (MIN_CELL_SIZE * density);
        mGeneratedItemPadding = (int) (GENERATED_ITEM_PADDING * density);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ActionBar,
                R.attr.actionBarStyle, 0);
        mMaxItemHeight = a.getDimensionPixelSize(R.styleable.ActionBar_height, 0);
        a.recycle();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.694 -0400", hash_original_method = "F8B2E0B9AF6B77951E8DA779DE9E37B4", hash_generated_method = "F57C2CCCDFA8C19F841E8A365C66C0C9")
    
public void setPresenter(ActionMenuPresenter presenter) {
        mPresenter = presenter;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.701 -0400", hash_original_method = "309FFF524EE8C98ED8919EC0ED593079", hash_generated_method = "641BEAE03E9F54FC51C2D17E3F4DDAF4")
    
public boolean isExpandedFormat() {
        return mFormatItems;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.710 -0400", hash_original_method = "9D96824DEF3098B6D8D76D3681180EEB", hash_generated_method = "174A4AFA5B5E989351B5623BCF8E657E")
    
@Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(newConfig);
        }

        mPresenter.updateMenuView(false);

        if (mPresenter != null && mPresenter.isOverflowMenuShowing()) {
            mPresenter.hideOverflowMenu();
            mPresenter.showOverflowMenu();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.727 -0400", hash_original_method = "AC3CCE6585939BC7F05ED16F63493D1E", hash_generated_method = "9CB6352E82CA856894739E6B464F81C4")
    
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
            // Previous measurement at exact format may have set margins - reset them.
            final int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = getChildAt(i);
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                lp.leftMargin = lp.rightMargin = 0;
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.814 -0400", hash_original_method = "9D5FAA757ACD3BC6F73045CC1C70F766", hash_generated_method = "23AB258569EB1F5E65929EC335AF6167")
    
private void onMeasureExactFormat(int widthMeasureSpec, int heightMeasureSpec) {
        // We already know the width mode is EXACTLY if we're here.
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        final int widthPadding = getPaddingLeft() + getPaddingRight();
        final int heightPadding = getPaddingTop() + getPaddingBottom();

        final int itemHeightSpec = heightMode == MeasureSpec.EXACTLY
                ? MeasureSpec.makeMeasureSpec(heightSize - heightPadding, MeasureSpec.EXACTLY)
                : MeasureSpec.makeMeasureSpec(
                        Math.min(mMaxItemHeight, heightSize - heightPadding), MeasureSpec.AT_MOST);

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
            if (child.getVisibility() == GONE) {
                continue;
            }

            final boolean isGeneratedItem = child.getTaintBoolean();
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
            lp.preventEdgeOffset = isGeneratedItem && child.getTaintBoolean();

            // Overflow always gets 1 cell. No more, no less.
            final int cellsAvailable = lp.isOverflowButton ? 1 : cellsRemaining;

            final int cellsUsed = measureChildForCells(child, cellSize, cellsAvailable,
                    itemHeightSpec, heightPadding);

            maxCellsUsed = Math.max(maxCellsUsed, cellsUsed);
            if (lp.expandable) {
                expandableItemCount++;
            }
            if (lp.isOverflowButton) {
                hasOverflow = true;
            }

            cellsRemaining -= cellsUsed;
            maxChildHeight = Math.max(maxChildHeight, child.getMeasuredHeight());
            if (cellsUsed == 1) {
                smallestItemsAt |= (1 << i);
            }
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
                if (!lp.expandable) {
                    continue;
                }

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

            if (minCellsItemCount > cellsRemaining) {
                break; // Couldn't expand anything evenly. Stop.
            }

            // We have enough cells, all minimum size items will be incremented.
            minCells++;

            for (int i = 0; i < childCount; i++) {
                final View child = getChildAt(i);
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if ((minCellsAt & (1 << i)) == 0) {
                    // If this item is already at our small item count, mark it for later.
                    if (lp.cellsUsed == minCells) {
                        smallestItemsAt |= 1 << i;
                    }
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
                    if (!lp.preventEdgeOffset) {
                        expandCount -= 0.5f;
                    }
                }
                if ((smallestItemsAt & (1 << (childCount - 1))) != 0) {
                    LayoutParams lp = ((LayoutParams) getChildAt(childCount - 1).getLayoutParams());
                    if (!lp.preventEdgeOffset) {
                        expandCount -= 0.5f;
                    }
                }
            }

            final int extraPixels = expandCount > 0 ?
                    (int) (cellsRemaining * cellSize / expandCount) : 0;

            for (int i = 0; i < childCount; i++) {
                if ((smallestItemsAt & (1 << i)) == 0) {
                    continue;
                }

                final View child = getChildAt(i);
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                //if (child instanceof ActionMenuItemView) {
                if (DroidSafeAndroidRuntime.control) {
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
            for (int i = 0; i < childCount; i++) {
                final View child = getChildAt(i);
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();

                if (!lp.expanded) {
                    continue;
                }

                final int width = lp.cellsUsed * cellSize + lp.extraPixels;
                child.measure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
                        itemHeightSpec);
            }
        }

        if (heightMode != MeasureSpec.EXACTLY) {
            heightSize = maxChildHeight;
        }

        setMeasuredDimension(widthSize, heightSize);
        mMeasuredExtraWidth = cellsRemaining * cellSize;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.850 -0400", hash_original_method = "C8F55BF57E4458DB1FB65209F2E04E81", hash_generated_method = "433C0C1F9D520A5949EEFDCCCAF761C5")
    
@Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (!mFormatItems) {
            super.onLayout(changed, left, top, right, bottom);
            return;
        }

        final int childCount = getChildCount();
        final int midVertical = (top + bottom) / 2;
        final int dividerWidth = getSupportDividerWidth();
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
                if (hasSupportDividerBeforeChildAt(i)) {
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
                if (hasSupportDividerBeforeChildAt(i)) {
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.857 -0400", hash_original_method = "BCFF92F724E40A93547AD27810B374B7", hash_generated_method = "A84D72B361AE36102DA6C6534829A3F9")
    
@Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mPresenter.dismissPopupMenus();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.863 -0400", hash_original_method = "9F44211E52A7149BFED02520B6DEF800", hash_generated_method = "139EA482158AF5CCB7770B48716B0B5E")
    
public boolean isOverflowReserved() {
        return mReserveOverflow;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.871 -0400", hash_original_method = "F5103BD0EA93D884CF8413DB778005C1", hash_generated_method = "B82F98E8C95E384D621AB24537CC57B4")
    
public void setOverflowReserved(boolean reserveOverflow) {
        mReserveOverflow = reserveOverflow;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.878 -0400", hash_original_method = "DEBB4048965D8045F192555AB279F2BA", hash_generated_method = "29BEB9B545D88184017C9E3123770325")
    
@Override
    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        return params;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.886 -0400", hash_original_method = "AED9080C69042489485342721EE0B0B1", hash_generated_method = "4AD7665169039F61ACFF3C8481974477")
    
@Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.893 -0400", hash_original_method = "6543FCE3043AA8E09E4AB46D137D1290", hash_generated_method = "26BFBF2498F471584ACFC84914ECE101")
    
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.899 -0400", hash_original_method = "C7A39F9D75FC22971A40D0A54E61424A", hash_generated_method = "7E38BA9E25DA97EDD4FE18FB943B604C")
    
@Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p != null && p instanceof LayoutParams;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.906 -0400", hash_original_method = "AF673847AD60845228ED5C7DBF294789", hash_generated_method = "16FD06704D4C3D23EE9E8C85745CB17B")
    
public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams result = generateDefaultLayoutParams();
        result.isOverflowButton = true;
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.911 -0400", hash_original_method = "52251A4D38FF83C9B55C46C571A25CAE", hash_generated_method = "E4D0C6B553755CCD3E1324292EB5E10F")
    
public boolean invokeItem(MenuItemImpl item) {
        return mMenu.performItemAction(item, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.918 -0400", hash_original_method = "DC1BDB1B98459EBD06B93B75A5D0D038", hash_generated_method = "7D099F9FB44E7521834F67AB97BE9EAC")
    
public int getWindowAnimations() {
        return 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.923 -0400", hash_original_method = "EDB3B7E883C1486DD9AED3AB15C0E44B", hash_generated_method = "4239B6BD8C1C7C2E7AC8C3A17352B70E")
    
public void initialize(MenuBuilder menu) {
        mMenu = menu;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.928 -0400", hash_original_method = "3AD27366CD169731101D50D4445554A3", hash_generated_method = "F8C3EAE22EAFF0CD433A6A13273589FD")
    
protected boolean hasSupportDividerBeforeChildAt(int childIndex) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:37:54.934 -0400", hash_original_method = "87E5D39D1D82C11AB077A37A8786E27E", hash_generated_method = "0CF47D3AADD137C907CE91EE0D9110E3")
    
public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return false;
    }

    public interface ActionMenuChildView {

        public boolean needsDividerBefore();

        public boolean needsDividerAfter();
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {

        @ViewDebug.ExportedProperty()
        public boolean isOverflowButton;

        @ViewDebug.ExportedProperty()
        public int cellsUsed;

        @ViewDebug.ExportedProperty()
        public int extraPixels;

        @ViewDebug.ExportedProperty()
        public boolean expandable;

        @ViewDebug.ExportedProperty()
        public boolean preventEdgeOffset;

        public boolean expanded;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public LayoutParams(LayoutParams other) {
            super((LinearLayout.LayoutParams) other);
            isOverflowButton = other.isOverflowButton;
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            isOverflowButton = false;
        }

        public LayoutParams(int width, int height, boolean isOverflowButton) {
            super(width, height);
            this.isOverflowButton = isOverflowButton;
        }
    }
}
