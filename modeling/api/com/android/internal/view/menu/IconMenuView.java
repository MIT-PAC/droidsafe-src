/*
 * Copyright (C) 2006 The Android Open Source Project
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

package com.android.internal.view.menu;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.android.internal.view.menu.MenuBuilder.ItemInvoker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.LayoutInflater;

import java.util.ArrayList;

/**
 * The icon menu view is an icon-based menu usually with a subset of all the menu items.
 * It is opened as the default menu, and shows either the first five or all six of the menu items
 * with text and icon.  In the situation of there being more than six items, the first five items
 * will be accompanied with a 'More' button that opens an {@link ExpandedMenuView} which lists
 * all the menu items. 
 * 
 * @attr ref android.R.styleable#IconMenuView_rowHeight
 * @attr ref android.R.styleable#IconMenuView_maxRows
 * @attr ref android.R.styleable#IconMenuView_maxItemsPerRow
 * 
 * @hide
 */
public final class IconMenuView extends ViewGroup implements ItemInvoker, MenuView, Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.571 -0400", hash_original_field = "652C5441E79A911EE22D7FF4D2FDE198", hash_generated_field = "DF26848AC140D85B5B153A406FE4F0BC")

    private static final int ITEM_CAPTION_CYCLE_DELAY = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.572 -0400", hash_original_field = "E0FA7D9C40725579D8730D3DABE74643", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.573 -0400", hash_original_field = "0D4B92245EAA55B5717D79B860396671", hash_generated_field = "50554ED84AE3E1341AD54F95D6B009DB")

    private int mRowHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.574 -0400", hash_original_field = "7E894805A8A7C23C536666F881A03FB4", hash_generated_field = "650E719F09633C12CA34BCF96EEB93B0")
 
    private int mMaxRows;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.575 -0400", hash_original_field = "6A5D0A43C7A85FA86E1168FC496915AF", hash_generated_field = "46A54E1F46C2CF0E99FFE4A07B201C3C")

    private int mMaxItems;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.577 -0400", hash_original_field = "A9326C5B55CDC8260F019C5CCD69890B", hash_generated_field = "E3370894FBF58595A825ABC6392F2E9C")

    private int mMaxItemsPerRow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.578 -0400", hash_original_field = "E73407C75EB39CE6324B14F5584F6007", hash_generated_field = "5BECA744E87C2676B6BE51FCF525C90A")

    private int mNumActualItemsShown;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.580 -0400", hash_original_field = "2B98DB9B9F410A3281A38E479BAEC65D", hash_generated_field = "D7CDB73D56B1FF7FB1D63B445AB69458")

    private Drawable mHorizontalDivider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.581 -0400", hash_original_field = "A3360B455A2A7D562F4D85438D5CB7DB", hash_generated_field = "A8BD0BECC46C1883ACBCF485960920C1")

    private int mHorizontalDividerHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.582 -0400", hash_original_field = "D50AE98BB658B23D3909E875D2DDFF04", hash_generated_field = "E2B426EDEB1C06BF2014E5EE12659A45")

    private ArrayList<Rect> mHorizontalDividerRects;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.583 -0400", hash_original_field = "D5C16C0728B5EAD3EC2CF7F7524706BF", hash_generated_field = "3E931C1B709E0879CDF4EE780CA07667")

    private Drawable mVerticalDivider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.584 -0400", hash_original_field = "D295DF74B138C09DE636D6951B3D6217", hash_generated_field = "FA36B621555F5ED10B3BD7E0F2FD56B3")

    private int mVerticalDividerWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.585 -0400", hash_original_field = "FA14EBD762E9FFAB0C3FC00EAC2F1995", hash_generated_field = "099B64162C8861F77DD0B4032F760474")

    private ArrayList<Rect> mVerticalDividerRects;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.586 -0400", hash_original_field = "29B312BFCE6A07445769ECD89C2B0B53", hash_generated_field = "1B0CBAB88E1806B1A7E7DF8079220B45")

    private Drawable mMoreIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.588 -0400", hash_original_field = "18007FD55A519CE32B1145CFA690E208", hash_generated_field = "C07C5B821A27F5B0EF8F9331080AA617")

    private Drawable mItemBackground;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.589 -0400", hash_original_field = "06D2B11117F79E7BF1AD7D0C4D350D47", hash_generated_field = "BE32B37325C289EA5DB8A350DE8A52C6")

    private int mAnimations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.590 -0400", hash_original_field = "2EAF636D4A39DF17EF7A33CB209776C9", hash_generated_field = "644DB22A4B894D1F9DD7B58C689FC774")

    private boolean mHasStaleChildren;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.591 -0400", hash_original_field = "E87EA813D4453D1D3D8A6B3198B2B770", hash_generated_field = "F5265FF74CD47F66D8D48620B0E6ACE9")

    private boolean mMenuBeingLongpressed = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.592 -0400", hash_original_field = "AEBE1934AE2663F9BFA6E02A4C5915A1", hash_generated_field = "FE86A1AA9D0FF671D15D1A92F24F43E1")

    private boolean mLastChildrenCaptionMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.593 -0400", hash_original_field = "FB1F8F455866D887A7377E4D8EB17EFE", hash_generated_field = "37BC8D98B8D07DED50A86180790A9B9D")

    private int[] mLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.594 -0400", hash_original_field = "6E842A4868240750A3DE9707938207D9", hash_generated_field = "1D36D7537B85426DBB34EFBD58FDFF59")

    private int mLayoutNumRows;
    
    /**
     * Instantiates the IconMenuView that is linked with the provided MenuBuilder.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.597 -0400", hash_original_method = "0D98049E3DCF0B0B79B4780ADF666819", hash_generated_method = "A97063EB3364CDEDB3BADB876C5562D6")
    
public IconMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = 
            context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.IconMenuView, 0, 0);
        mRowHeight = a.getDimensionPixelSize(com.android.internal.R.styleable.IconMenuView_rowHeight, 64);
        mMaxRows = a.getInt(com.android.internal.R.styleable.IconMenuView_maxRows, 2);
        mMaxItems = a.getInt(com.android.internal.R.styleable.IconMenuView_maxItems, 6);
        mMaxItemsPerRow = a.getInt(com.android.internal.R.styleable.IconMenuView_maxItemsPerRow, 3);
        mMoreIcon = a.getDrawable(com.android.internal.R.styleable.IconMenuView_moreIcon);
        a.recycle();
        
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.MenuView, 0, 0);
        mItemBackground = a.getDrawable(com.android.internal.R.styleable.MenuView_itemBackground);
        mHorizontalDivider = a.getDrawable(com.android.internal.R.styleable.MenuView_horizontalDivider);
        mHorizontalDividerRects = new ArrayList<Rect>();
        mVerticalDivider =  a.getDrawable(com.android.internal.R.styleable.MenuView_verticalDivider);
        mVerticalDividerRects = new ArrayList<Rect>();
        mAnimations = a.getResourceId(com.android.internal.R.styleable.MenuView_windowAnimationStyle, 0);
        a.recycle();
        
        if (mHorizontalDivider != null) {
            mHorizontalDividerHeight = mHorizontalDivider.getIntrinsicHeight();
            // Make sure to have some height for the divider
            if (mHorizontalDividerHeight == -1) mHorizontalDividerHeight = 1;
        }
        
        if (mVerticalDivider != null) {
            mVerticalDividerWidth = mVerticalDivider.getIntrinsicWidth();
            // Make sure to have some width for the divider
            if (mVerticalDividerWidth == -1) mVerticalDividerWidth = 1;
        }
        
        mLayout = new int[mMaxRows];
        
        // This view will be drawing the dividers        
        setWillNotDraw(false);
        
        // This is so we'll receive the MENU key in touch mode
        setFocusableInTouchMode(true);
        // This is so our children can still be arrow-key focused
        setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.598 -0400", hash_original_method = "108D75EE7327D908D864A4E8DACF487B", hash_generated_method = "108D75EE7327D908D864A4E8DACF487B")
    
int getMaxItems() {
        return mMaxItems;
    }

    /**
     * Figures out the layout for the menu items.
     * 
     * @param width The available width for the icon menu.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.599 -0400", hash_original_method = "C8C0C7A546F219CB7EBA97386ADA6910", hash_generated_method = "6786551AA4FCB5415D8D3C23BA5F60A2")
    
private void layoutItems(int width) {
        int numItems = getChildCount();
        if (numItems == 0) {
            mLayoutNumRows = 0;
            return;
        }
        
        // Start with the least possible number of rows
        int curNumRows =
                Math.min((int) Math.ceil(numItems / (float) mMaxItemsPerRow), mMaxRows);
        
        /*
         * Increase the number of rows until we find a configuration that fits
         * all of the items' titles. Worst case, we use mMaxRows.
         */
        for (; curNumRows <= mMaxRows; curNumRows++) {
            layoutItemsUsingGravity(curNumRows, numItems);
            
            if (curNumRows >= numItems) {
                // Can't have more rows than items
                break;
            }
            
            if (doItemsFit()) {
                // All the items fit, so this is a good configuration
                break;
            }
        }
    }

    /**
     * Figures out the layout for the menu items by equally distributing, and
     * adding any excess items equally to lower rows.
     * 
     * @param numRows The total number of rows for the menu view
     * @param numItems The total number of items (across all rows) contained in
     *            the menu view
     * @return int[] Where the value of index i contains the number of items for row i
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.601 -0400", hash_original_method = "15F3DD2CCEEE48DD8745D08C5D9782E0", hash_generated_method = "6B83ED4B22CC4BE353EA23860482AD2C")
    
private void layoutItemsUsingGravity(int numRows, int numItems) {
        int numBaseItemsPerRow = numItems / numRows;
        int numLeftoverItems = numItems % numRows;
        /**
         * The bottom rows will each get a leftover item. Rows (indexed at 0)
         * that are >= this get a leftover item. Note: if there are 0 leftover
         * items, no rows will get them since this value will be greater than
         * the last row.
         */
        int rowsThatGetALeftoverItem = numRows - numLeftoverItems;
        
        int[] layout = mLayout;
        for (int i = 0; i < numRows; i++) {
            layout[i] = numBaseItemsPerRow;

            // Fill the bottom rows with a leftover item each
            if (i >= rowsThatGetALeftoverItem) {
                layout[i]++;
            }
        }
        
        mLayoutNumRows = numRows;
    }

    /**
     * Checks whether each item's title is fully visible using the current
     * layout.
     * 
     * @return True if the items fit (each item's text is fully visible), false
     *         otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.602 -0400", hash_original_method = "4CAE73F9E2C20E210A336A18A45A6289", hash_generated_method = "2C7289ABFFE45E1D05216ECB2E05299F")
    
private boolean doItemsFit() {
        int itemPos = 0;
        
        int[] layout = mLayout;
        int numRows = mLayoutNumRows;
        for (int row = 0; row < numRows; row++) {
            int numItemsOnRow = layout[row];

            /*
             * If there is only one item on this row, increasing the
             * number of rows won't help.
             */ 
            if (numItemsOnRow == 1) {
                itemPos++;
                continue;
            }
            
            for (int itemsOnRowCounter = numItemsOnRow; itemsOnRowCounter > 0;
                    itemsOnRowCounter--) {
                View child = getChildAt(itemPos++);
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (lp.maxNumItemsOnRow < numItemsOnRow) {
                    return false;
                }
            }
        }
        
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.603 -0400", hash_original_method = "342FE30B08D1FB3D755218650DF3E588", hash_generated_method = "342FE30B08D1FB3D755218650DF3E588")
    
Drawable getItemBackgroundDrawable() {
        return mItemBackground.getConstantState().newDrawable(getContext().getResources());
    }

    /**
     * Creates the item view for the 'More' button which is used to switch to
     * the expanded menu view. This button is a special case since it does not
     * have a MenuItemData backing it.
     * @return The IconMenuItemView for the 'More' button
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.606 -0400", hash_original_method = "918AFD9207BD2C1E1C4E088E2C1F561D", hash_generated_method = "97B74E513F5487A03EF694FDE59308E6")
    
IconMenuItemView createMoreItemView() {
        Context context = getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        
        final IconMenuItemView itemView = (IconMenuItemView) inflater.inflate(
                com.android.internal.R.layout.icon_menu_item_layout, null);
        
        Resources r = context.getResources();
        itemView.initialize(r.getText(com.android.internal.R.string.more_item_label), mMoreIcon);
        
        // Set up a click listener on the view since there will be no invocation sequence
        // due to the lack of a MenuItemData this view
        itemView.setOnClickListener(new OnClickListener() {
            @DSSafe(DSCat.SAFE_LIST)
        public void onClick(View v) {
                // Switches the menu to expanded mode. Requires support from
                // the menu's active callback.
                mMenu.changeMenuMode();
            }
        });
        
        return itemView;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.607 -0400", hash_original_method = "EDB3B7E883C1486DD9AED3AB15C0E44B", hash_generated_method = "4239B6BD8C1C7C2E7AC8C3A17352B70E")
    
public void initialize(MenuBuilder menu) {
        mMenu = menu;
    }

    /**
     * The positioning algorithm that gets called from onMeasure.  It
     * just computes positions for each child, and then stores them in the child's layout params.
     * @param menuWidth The width of this menu to assume for positioning
     * @param menuHeight The height of this menu to assume for positioning
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.611 -0400", hash_original_method = "6B975B236D38733D8D97A87E4CBCD8AE", hash_generated_method = "652F22B5F8BD6D8D5D9F214EE134C943")
    
private void positionChildren(int menuWidth, int menuHeight) {
        // Clear the containers for the positions where the dividers should be drawn
        if (mHorizontalDivider != null) mHorizontalDividerRects.clear();
        if (mVerticalDivider != null) mVerticalDividerRects.clear();

        // Get the minimum number of rows needed
        final int numRows = mLayoutNumRows;
        final int numRowsMinus1 = numRows - 1;
        final int numItemsForRow[] = mLayout;
        
        // The item position across all rows
        int itemPos = 0;
        View child;
        IconMenuView.LayoutParams childLayoutParams = null;

        // Use float for this to get precise positions (uniform item widths
        // instead of last one taking any slack), and then convert to ints at last opportunity
        float itemLeft;
        float itemTop = 0;
        // Since each row can have a different number of items, this will be computed per row
        float itemWidth;
        // Subtract the space needed for the horizontal dividers
        final float itemHeight = (menuHeight - mHorizontalDividerHeight * (numRows - 1))
                / (float)numRows;
        
        for (int row = 0; row < numRows; row++) {
            // Start at the left
            itemLeft = 0;
            
            // Subtract the space needed for the vertical dividers, and divide by the number of items
            itemWidth = (menuWidth - mVerticalDividerWidth * (numItemsForRow[row] - 1))
                    / (float)numItemsForRow[row];
            
            for (int itemPosOnRow = 0; itemPosOnRow < numItemsForRow[row]; itemPosOnRow++) {
                // Tell the child to be exactly this size
                child = getChildAt(itemPos);
                child.measure(MeasureSpec.makeMeasureSpec((int) itemWidth, MeasureSpec.EXACTLY),
                        MeasureSpec.makeMeasureSpec((int) itemHeight, MeasureSpec.EXACTLY));
                
                // Remember the child's position for layout
                childLayoutParams = (IconMenuView.LayoutParams) child.getLayoutParams();
                childLayoutParams.left = (int) itemLeft;
                childLayoutParams.right = (int) (itemLeft + itemWidth);
                childLayoutParams.top = (int) itemTop;
                childLayoutParams.bottom = (int) (itemTop + itemHeight);
                
                // Increment by item width
                itemLeft += itemWidth;
                itemPos++;

                // Add a vertical divider to draw
                if (mVerticalDivider != null) {
                    mVerticalDividerRects.add(new Rect((int) itemLeft,
                            (int) itemTop, (int) (itemLeft + mVerticalDividerWidth),
                            (int) (itemTop + itemHeight)));
                }

                // Increment by divider width (even if we're not computing
                // dividers, since we need to leave room for them when
                // calculating item positions)
                itemLeft += mVerticalDividerWidth;
            }
            
            // Last child on each row should extend to very right edge
            if (childLayoutParams != null) {
                childLayoutParams.right = menuWidth;
            }
            
            itemTop += itemHeight;

            // Add a horizontal divider to draw
            if ((mHorizontalDivider != null) && (row < numRowsMinus1)) {
                mHorizontalDividerRects.add(new Rect(0, (int) itemTop, menuWidth,
                        (int) (itemTop + mHorizontalDividerHeight)));

                itemTop += mHorizontalDividerHeight;
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.612 -0400", hash_original_method = "EDB3F8162AECACC833E5C2CFE32AF75C", hash_generated_method = "025A13EDC7F3553846261FF2D23F3C6E")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth = resolveSize(Integer.MAX_VALUE, widthMeasureSpec);
        calculateItemFittingMetadata(measuredWidth);
        layoutItems(measuredWidth);
        
        // Get the desired height of the icon menu view (last row of items does
        // not have a divider below)
        final int layoutNumRows = mLayoutNumRows;
        final int desiredHeight = (mRowHeight + mHorizontalDividerHeight) *
                layoutNumRows - mHorizontalDividerHeight;
        
        // Maximum possible width and desired height
        setMeasuredDimension(measuredWidth,
                resolveSize(desiredHeight, heightMeasureSpec));

        // Position the children
        if (layoutNumRows > 0) {
            positionChildren(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.613 -0400", hash_original_method = "DC7318F4A96694F755DACF211BFD8BCE", hash_generated_method = "8233A7063AF195260803AD62A3E6860F")
    
@Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        View child;
        IconMenuView.LayoutParams childLayoutParams;
        
        for (int i = getChildCount() - 1; i >= 0; i--) {
            child = getChildAt(i);
            childLayoutParams = (IconMenuView.LayoutParams)child
                    .getLayoutParams();

            // Layout children according to positions set during the measure
            child.layout(childLayoutParams.left, childLayoutParams.top, childLayoutParams.right,
                    childLayoutParams.bottom);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.615 -0400", hash_original_method = "D3B7E8035E214B05048CDEAC905E068A", hash_generated_method = "35E074AD6B336A6DF61DE48CFD78C780")
    
@Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = mHorizontalDivider;
        if (drawable != null) {
            // If we have a horizontal divider to draw, draw it at the remembered positions
            final ArrayList<Rect> rects = mHorizontalDividerRects;
            for (int i = rects.size() - 1; i >= 0; i--) {
                drawable.setBounds(rects.get(i));
                drawable.draw(canvas);
            }
        }

        drawable = mVerticalDivider;
        if (drawable != null) {
            // If we have a vertical divider to draw, draw it at the remembered positions
            final ArrayList<Rect> rects = mVerticalDividerRects;
            for (int i = rects.size() - 1; i >= 0; i--) {
                drawable.setBounds(rects.get(i));
                drawable.draw(canvas);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.616 -0400", hash_original_method = "52251A4D38FF83C9B55C46C571A25CAE", hash_generated_method = "E4D0C6B553755CCD3E1324292EB5E10F")
    
public boolean invokeItem(MenuItemImpl item) {
        return mMenu.performItemAction(item, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.617 -0400", hash_original_method = "26F92B771E79AE804A49D5FEE2186C8A", hash_generated_method = "E6C6DF5424D44A5D96CBB9C17708C6C2")
    
@Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new IconMenuView.LayoutParams(getContext(), attrs);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.618 -0400", hash_original_method = "C6170839D0C24530AF40D6B41DC89AE3", hash_generated_method = "9975831127881415DB1A9F98C11EE9EC")
    
@Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        // Override to allow type-checking of LayoutParams. 
        return p instanceof IconMenuView.LayoutParams;
    }

    /**
     * Marks as having stale children.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.619 -0400", hash_original_method = "D366EB4474B58C92DE0B49A58CD76C7E", hash_generated_method = "D366EB4474B58C92DE0B49A58CD76C7E")
    
void markStaleChildren() {
        if (!mHasStaleChildren) {
            mHasStaleChildren = true;
            requestLayout();
        }
    }
    
    /**
     * @return The number of actual items shown (those that are backed by an
     *         {@link MenuView.ItemView} implementation--eg: excludes More
     *         item).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.620 -0400", hash_original_method = "2E7382510CFF7F381BDC957C5A430D1D", hash_generated_method = "2E7382510CFF7F381BDC957C5A430D1D")
    
int getNumActualItemsShown() {
        return mNumActualItemsShown;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.621 -0400", hash_original_method = "D2A195F905DEAD0253E2450B9B916022", hash_generated_method = "D2A195F905DEAD0253E2450B9B916022")
    
void setNumActualItemsShown(int count) {
        mNumActualItemsShown = count;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.622 -0400", hash_original_method = "02CB30F0EA5DFC81374866D1443F8CD5", hash_generated_method = "95896EC854DD5E8FA6619C5587BDEDE9")
    
public int getWindowAnimations() {
        return mAnimations;
    }

    /**
     * Returns the number of items per row.
     * <p>
     * This should only be used for testing.
     * 
     * @return The length of the array is the number of rows. A value at a
     *         position is the number of items in that row.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.623 -0400", hash_original_method = "0A6D0BA513C188E58DB5D6B83033FC1C", hash_generated_method = "480B501201B5BF85F0D1D6718F1E22CB")
    
public int[] getLayout() {
        return mLayout;
    }
    
    /**
     * Returns the number of rows in the layout.
     * <p>
     * This should only be used for testing.
     * 
     * @return The length of the array is the number of rows. A value at a
     *         position is the number of items in that row.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.625 -0400", hash_original_method = "0196BB4EF1DF8907F2478175D6EDA5BE", hash_generated_method = "EC7595F7C9DD909E5114AE858AE2DDE5")
    
public int getLayoutNumRows() {
        return mLayoutNumRows;
    }
    
    @DSSpec(DSCat.TO_MODEL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.626 -0400", hash_original_method = "D40C17BF4E36F8FA59B3A091DC2FD968", hash_generated_method = "5EAF53B79221C4AF56FD42CA650C022C")
    
@Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        if (event.getKeyCode() == KeyEvent.KEYCODE_MENU) {
            if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                removeCallbacks(this);
                postDelayed(this, ViewConfiguration.getLongPressTimeout());
            } else if (event.getAction() == KeyEvent.ACTION_UP) {
                
                if (mMenuBeingLongpressed) {
                    // It was in cycle mode, so reset it (will also remove us
                    // from being called back)
                    setCycleShortcutCaptionMode(false);
                    return true;
                    
                } else {
                    // Just remove us from being called back
                    removeCallbacks(this);
                    // Fall through to normal processing too
                }
            }
        }
        
        return super.dispatchKeyEvent(event);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.627 -0400", hash_original_method = "AC8CADB4985D382072198F95CA72CEBB", hash_generated_method = "A9AE56247EA887B3F356AE8704190EF8")
    
@Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        
        requestFocus();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.628 -0400", hash_original_method = "4FCF3D1FDA8CE4D7D0697CE02F867DA9", hash_generated_method = "EEE8741DCDAD6C19FF9F666067B5B8FE")
    
@Override
    protected void onDetachedFromWindow() {
        setCycleShortcutCaptionMode(false);
        super.onDetachedFromWindow();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.629 -0400", hash_original_method = "2F4414D7A88BA8DC843C3C24FE02C2AC", hash_generated_method = "16A14C3595D6274646BE09E49C2BBD1D")
    
@Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {

        if (!hasWindowFocus) {
            setCycleShortcutCaptionMode(false);
        }

        super.onWindowFocusChanged(hasWindowFocus);
    }

    /**
     * Sets the shortcut caption mode for IconMenuView. This mode will
     * continuously cycle between a child's shortcut and its title.
     * 
     * @param cycleShortcutAndNormal Whether to go into cycling shortcut mode,
     *        or to go back to normal.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.630 -0400", hash_original_method = "EAA7C0BCFAB219D9AE1C36741A30726F", hash_generated_method = "D3ED8C63982BE931444195D511CEACC7")
    
private void setCycleShortcutCaptionMode(boolean cycleShortcutAndNormal) {

        if (!cycleShortcutAndNormal) {
            /*
             * We're setting back to title, so remove any callbacks for setting
             * to shortcut
             */
            removeCallbacks(this);
            setChildrenCaptionMode(false);
            mMenuBeingLongpressed = false;
            
        } else {
            
            // Set it the first time (the cycle will be started in run()).
            setChildrenCaptionMode(true);
        }
        
    }

    /**
     * When this method is invoked if the menu is currently not being
     * longpressed, it means that the longpress has just been reached (so we set
     * longpress flag, and start cycling). If it is being longpressed, we cycle
     * to the next mode.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.632 -0400", hash_original_method = "89F2C35600300C50A3DBB522D6A4DDE2", hash_generated_method = "5146E8B818C8357BD9CA478C2FE8526E")
    
public void run() {
        
        if (mMenuBeingLongpressed) {

            // Cycle to other caption mode on the children
            setChildrenCaptionMode(!mLastChildrenCaptionMode);

        } else {
            
            // Switch ourselves to continuously cycle the items captions
            mMenuBeingLongpressed = true;
            setCycleShortcutCaptionMode(true);
        }

        // We should run again soon to cycle to the other caption mode
        postDelayed(this, ITEM_CAPTION_CYCLE_DELAY);
    }

    /**
     * Iterates children and sets the desired shortcut mode. Only
     * {@link #setCycleShortcutCaptionMode(boolean)} and {@link #run()} should call
     * this.
     * 
     * @param shortcut Whether to show shortcut or the title.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.633 -0400", hash_original_method = "C57B8AA3741F7E114665F300DB39D7AA", hash_generated_method = "14B152214541DBBB87755994FDD942B2")
    
private void setChildrenCaptionMode(boolean shortcut) {
        
        // Set the last caption mode pushed to children
        mLastChildrenCaptionMode = shortcut;
        
        for (int i = getChildCount() - 1; i >= 0; i--) {
            ((IconMenuItemView) getChildAt(i)).setCaptionMode(shortcut);
        }
    }

    /**
     * For each item, calculates the most dense row that fully shows the item's
     * title.
     * 
     * @param width The available width of the icon menu.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.634 -0400", hash_original_method = "18307823C6D4849DA161FBBDECA74E79", hash_generated_method = "8ACAF867DB0ABDB5F0E4708E7AA920D4")
    
private void calculateItemFittingMetadata(int width) {
        int maxNumItemsPerRow = mMaxItemsPerRow;
        int numItems = getChildCount();
        for (int i = 0; i < numItems; i++) {
            LayoutParams lp = (LayoutParams) getChildAt(i).getLayoutParams();
            // Start with 1, since that case does not get covered in the loop below
            lp.maxNumItemsOnRow = 1;
            for (int curNumItemsPerRow = maxNumItemsPerRow; curNumItemsPerRow > 0;
                    curNumItemsPerRow--) {
                // Check whether this item can fit into a row containing curNumItemsPerRow
                if (lp.desiredWidth < width / curNumItemsPerRow) {
                    // It can, mark this value as the most dense row it can fit into
                    lp.maxNumItemsOnRow = curNumItemsPerRow;
                    break;
                }
            }
        }
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.636 -0400", hash_original_method = "2D6F044112ADAA2591CF3D217EC1849B", hash_generated_method = "EEAB008C979522F1A2612F4D0FF1D4EB")
    
@Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        
        View focusedView = getFocusedChild();
        
        for (int i = getChildCount() - 1; i >= 0; i--) {
            if (getChildAt(i) == focusedView) {
                return new SavedState(superState, i);
            }
        }
        
        return new SavedState(superState, -1);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.637 -0400", hash_original_method = "49AFBE27B9E568F013D030667BB6BE48", hash_generated_method = "EA7A0BF17596655FABFC8CDE09374B8F")
    
@Override
    protected void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        if (ss.focusedPosition >= getChildCount()) {
            return;
        }
        
        View v = getChildAt(ss.focusedPosition);
        if (v != null) {
            v.requestFocus();
        }
    }

    private static class SavedState extends BaseSavedState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.645 -0400", hash_original_field = "AD99978CDC5E698C2A4DD1DC3100EFC5", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")
        
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            @DSSafe(DSCat.SAFE_OTHERS)
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.638 -0400", hash_original_field = "65A10FA3F33879E00676D385003DC819", hash_generated_field = "65A10FA3F33879E00676D385003DC819")

        int focusedPosition;

        /**
         * Constructor called from {@link IconMenuView#onSaveInstanceState()}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.639 -0400", hash_original_method = "6B85E225CE4895DF69D7AD3BA1A1D0E6", hash_generated_method = "5ACACEAE22A0714A084B08C99B107716")
        
public SavedState(Parcelable superState, int focusedPosition) {
            super(superState);
            this.focusedPosition = focusedPosition;
        }
        
        /**
         * Constructor called from {@link #CREATOR}
         */
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.640 -0400", hash_original_method = "62FDA856B6BB84CB97F84F93D2B95AF3", hash_generated_method = "EEF291454A98DFF21835444419B8B80A")
        
private SavedState(Parcel in) {
            super(in);
            focusedPosition = in.readInt();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.641 -0400", hash_original_method = "57263806AFC4195E4D76796955F0C7D6", hash_generated_method = "6ECFBC4F908133CE3398C0B037F9EFEF")
        
@Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(focusedPosition);
        }
        
    }
    
    /**
     * Layout parameters specific to IconMenuView (stores the left, top, right, bottom from the
     * measure pass). 
     */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams
    {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.648 -0400", hash_original_field = "38EB2F75B16AA1A3FB9EB48696DC7FAE", hash_generated_field = "38EB2F75B16AA1A3FB9EB48696DC7FAE")

        int left, top, right, bottom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.649 -0400", hash_original_field = "629C51D4291EC18D0013765006B60758", hash_generated_field = "629C51D4291EC18D0013765006B60758")

        int desiredWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.650 -0400", hash_original_field = "4E1F2D68D6DD0A64CF2F4943FDD37F07", hash_generated_field = "4E1F2D68D6DD0A64CF2F4943FDD37F07")

        int maxNumItemsOnRow;
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.651 -0400", hash_original_method = "35869249D2D5BC08819A8507F87D33FD", hash_generated_method = "72A2ECA2CF4C647C2D28F670D4DC27E1")
        
public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.654 -0400", hash_original_method = "B179862558DB9232A546423CE2E9C45B", hash_generated_method = "5618D547D1ACB51021D28AF4BAF9972B")
        
public LayoutParams(int width, int height) {
            super(width, height);
        }
    }
}
