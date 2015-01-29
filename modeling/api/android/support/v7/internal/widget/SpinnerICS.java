/*
 * Copyright (C) 2007 The Android Open Source Project
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

package android.support.v7.internal.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;

/**
 * A view that displays one child at a time and lets the user pick among them.
 * The items in the Spinner come from the {@link android.widget.Adapter} associated with
 * this view.
 *
 * <p>See the <a href="{@docRoot}resources/tutorials/views/hello-spinner.html">Spinner
 * tutorial</a>.</p>
 *
 * @attr ref android.support.v7.appcompat.R.styleable#Spinner_prompt
 */
class SpinnerICS extends AbsSpinnerICS implements OnClickListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.392 -0400", hash_original_field = "C4AB240E6B4A8D3A229E006BF52962A4", hash_generated_field = "24196829F47AA90801DC8C1D4AB09CA2")

    private static final String TAG = "Spinner";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.406 -0400", hash_original_field = "15ED1CD78B6153A00A977803E319F374", hash_generated_field = "66E10B160A98D63911CB4E37185B80B0")

    private static final int MAX_ITEMS_MEASURED = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.414 -0400", hash_original_field = "72A01AA21E7488FAE1D6F0F6BB5C1A4B", hash_generated_field = "AD00D29B6A1B507EDBC56581F1E43FF6")

    static final int MODE_DIALOG = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.422 -0400", hash_original_field = "C247C0D11111308BB9C5C788C053857C", hash_generated_field = "00F0CA3779B511459000D4B9CBB42E87")

    static final int MODE_DROPDOWN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.430 -0400", hash_original_field = "F86A2C755CE2EB59C5978239E3310EC9", hash_generated_field = "ABE6A4AE1BB7B3ECDF9A30C989D50FCE")

    private static final int MODE_THEME = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.450 -0400", hash_original_field = "FC14FC3442A2E6593D55C850EF3DFBFB", hash_generated_field = "2B2C8DD5949DF96120E12CE686443E54")

    private SpinnerPopup mPopup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.456 -0400", hash_original_field = "1F5BCC6FC4C6935B9E8358A75684BF85", hash_generated_field = "C1900A4CF75F2ED95144B24FDA148887")

    private DropDownAdapter mTempAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.464 -0400", hash_original_field = "9F13B49ED3B4F15DF1C39EF57B2A0772", hash_generated_field = "9F13B49ED3B4F15DF1C39EF57B2A0772")

    int mDropDownWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.471 -0400", hash_original_field = "E8D24DE70DE8CB945622B4CE486A90EA", hash_generated_field = "ACF14A395FB2702990553CD0EFA1BDCC")

    private int mGravity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.479 -0400", hash_original_field = "1732EB32F2D77CCA26590AEEA670A175", hash_generated_field = "AFFA54D19F07A10EE8847CF76FC95323")

    private Rect mTempRect = new Rect();

    /**
     * Construct a new spinner with the given context's theme.
     *
     * @param context The Context the view is running in, through which it can
     *        access the current theme, resources, etc.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.488 -0400", hash_original_method = "831192EDD5EA32BF3EF678D838CC1575", hash_generated_method = "831192EDD5EA32BF3EF678D838CC1575")
    
SpinnerICS(Context context) {
        this(context, null);
    }

    /**
     * Construct a new spinner with the given context's theme and the supplied
     * mode of displaying choices. <code>mode</code> may be one of
     * {@link #MODE_DIALOG} or {@link #MODE_DROPDOWN}.
     *
     * @param context The Context the view is running in, through which it can
     *        access the current theme, resources, etc.
     * @param mode Constant describing how the user will select choices from the spinner.
     *
     * @see #MODE_DIALOG
     * @see #MODE_DROPDOWN
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.496 -0400", hash_original_method = "ECB5C682D704817C080F2AEF01EBD826", hash_generated_method = "ECB5C682D704817C080F2AEF01EBD826")
    
SpinnerICS(Context context, int mode) {
        this(context, null, R.attr.spinnerStyle, mode);
    }

    /**
     * Construct a new spinner with the given context's theme and the supplied attribute set.
     *
     * @param context The Context the view is running in, through which it can
     *        access the current theme, resources, etc.
     * @param attrs The attributes of the XML tag that is inflating the view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.504 -0400", hash_original_method = "DD3A17986A72FD0CBA4EC3BC2BCBAF85", hash_generated_method = "DD3A17986A72FD0CBA4EC3BC2BCBAF85")
    
SpinnerICS(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.spinnerStyle);
    }

    /**
     * Construct a new spinner with the given context's theme, the supplied attribute set,
     * and default style.
     *
     * @param context The Context the view is running in, through which it can
     *        access the current theme, resources, etc.
     * @param attrs The attributes of the XML tag that is inflating the view.
     * @param defStyle The default style to apply to this view. If 0, no style
     *        will be applied (beyond what is included in the theme). This may
     *        either be an attribute resource, whose value will be retrieved
     *        from the current theme, or an explicit style resource.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.513 -0400", hash_original_method = "71457977210D41DC222B3ED9CF83F9D1", hash_generated_method = "71457977210D41DC222B3ED9CF83F9D1")
    
SpinnerICS(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, MODE_THEME);
    }

    /**
     * Construct a new spinner with the given context's theme, the supplied attribute set,
     * and default style. <code>mode</code> may be one of {@link #MODE_DIALOG} or
     * {@link #MODE_DROPDOWN} and determines how the user will select choices from the spinner.
     *
     * @param context The Context the view is running in, through which it can
     *        access the current theme, resources, etc.
     * @param attrs The attributes of the XML tag that is inflating the view.
     * @param defStyle The default style to apply to this view. If 0, no style
     *        will be applied (beyond what is included in the theme). This may
     *        either be an attribute resource, whose value will be retrieved
     *        from the current theme, or an explicit style resource.
     * @param mode Constant describing how the user will select choices from the spinner.
     *
     * @see #MODE_DIALOG
     * @see #MODE_DROPDOWN
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.542 -0400", hash_original_method = "786CF09AF94FDB732213611AE399275D", hash_generated_method = "F42101A91C748982D39B5CAABEB7FE70")
    
SpinnerICS(Context context, AttributeSet attrs, int defStyle, int mode) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.Spinner, defStyle, 0);

        if (mode == MODE_THEME) {
            mode = a.getInt(R.styleable.Spinner_spinnerMode, MODE_DIALOG);
        }

        switch (mode) {
            case MODE_DIALOG: {
                mPopup = new DialogPopup();
                break;
            }

            case MODE_DROPDOWN: {
                DropdownPopup popup = new DropdownPopup(context, attrs, defStyle);

                mDropDownWidth = a.getLayoutDimension(R.styleable.Spinner_android_dropDownWidth,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                popup.setBackgroundDrawable(
                        a.getDrawable(R.styleable.Spinner_android_popupBackground));

                final int verticalOffset = a.getDimensionPixelOffset(
                        R.styleable.Spinner_android_dropDownVerticalOffset, 0);
                if (verticalOffset != 0) {
                    popup.setVerticalOffset(verticalOffset);
                }

                final int horizontalOffset = a.getDimensionPixelOffset(
                        R.styleable.Spinner_android_dropDownHorizontalOffset, 0);
                if (horizontalOffset != 0) {
                    popup.setHorizontalOffset(horizontalOffset);
                }

                mPopup = popup;
                break;
            }
        }

        mGravity = a.getInt(R.styleable.Spinner_android_gravity, Gravity.CENTER);

        mPopup.setPromptText(a.getString(R.styleable.Spinner_prompt));

        a.recycle();

        // Base constructor can call setAdapter before we initialize mPopup.
        // Finish setting things up if this happened.
        if (mTempAdapter != null) {
            mPopup.setAdapter(mTempAdapter);
            mTempAdapter = null;
        }
    }

    /**
     * Describes how the selected item view is positioned. Currently only the horizontal component
     * is used. The default is determined by the current theme.
     *
     * @param gravity See {@link android.view.Gravity}
     *
     * @attr ref android.R.styleable#Spinner_gravity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.551 -0400", hash_original_method = "2D67806CEC3CAAEAC987F460E7189BA9", hash_generated_method = "0ACAAAD9C2B88C8D76C69DAC094734DE")
    
public void setGravity(int gravity) {
        if (mGravity != gravity) {
            if ((gravity & Gravity.HORIZONTAL_GRAVITY_MASK) == 0) {
                gravity |= Gravity.LEFT;
            }
            mGravity = gravity;
            requestLayout();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.563 -0400", hash_original_method = "60241601236C86A9296272064A15234D", hash_generated_method = "C3B2D6E860B82141D2CA77EF0BF7E624")
    
@Override
    public void setAdapter(SpinnerAdapter adapter) {
        super.setAdapter(adapter);

        if (mPopup != null) {
            mPopup.setAdapter(new DropDownAdapter(adapter));
        } else {
            mTempAdapter = new DropDownAdapter(adapter);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.576 -0400", hash_original_method = "50D7CC7A93B993E2A6FF522D575BAEB5", hash_generated_method = "611E2DA9775E0C612F4D5EF38FAF5956")
    
@Override
    public int getBaseline() {
        View child = null;

        if (getChildCount() > 0) {
            child = getChildAt(0);
        } else if (mAdapter != null && mAdapter.getCount() > 0) {
            child = makeAndAddView(0);
            mRecycler.put(0, child);
            removeAllViewsInLayout();
        }

        if (child != null) {
            final int childBaseline = child.getBaseline();
            return childBaseline >= 0 ? child.getTop() + childBaseline : -1;
        } else {
            return -1;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.585 -0400", hash_original_method = "B6F13EE08FDC85FB02DBBB6CA125C601", hash_generated_method = "D6B0999677F0279AF30F74D5F6760851")
    
@Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        if (mPopup != null && mPopup.isShowing()) {
            mPopup.dismiss();
        }
    }

    /**
     * <p>A spinner does not support item click events. Calling this method
     * will raise an exception.</p>
     *
     * @param l this listener will be ignored
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.594 -0400", hash_original_method = "AE9F9278138E36A1F7A0C4102CD0DE5F", hash_generated_method = "E4893921088FD20363D1609510E45D60")
    
@Override
    public void setOnItemClickListener(OnItemClickListener l) {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.602 -0400", hash_original_method = "826DF4E4F08E8F6C45D1E7CAAC075075", hash_generated_method = "826DF4E4F08E8F6C45D1E7CAAC075075")
    
void setOnItemClickListenerInt(OnItemClickListener l) {
        super.setOnItemClickListener(l);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.614 -0400", hash_original_method = "EC8AF316641014792672178145DBD315", hash_generated_method = "C942D9FF9C76DDC01EC6017A7AFA16C3")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mPopup != null && MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST) {
            final int measuredWidth = getMeasuredWidth();
            setMeasuredDimension(Math.min(Math.max(measuredWidth,
                    measureContentWidth(getAdapter(), getBackground())),
                    MeasureSpec.getSize(widthMeasureSpec)),
                    getMeasuredHeight());
        }
    }

    /**
     * @see android.view.View#onLayout(boolean,int,int,int,int)
     *
     * Creates and positions all views
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.629 -0400", hash_original_method = "2F25E46AB3A307ED9F0C91E6C81BDCD4", hash_generated_method = "C9E4EF58D52414D83168BE0C17CAEF46")
    
@Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mInLayout = true;
        layout(0, false);
        mInLayout = false;
    }

    /**
     * Creates and positions all views for this Spinner.
     *
     * @param delta Change in the selected position. +1 moves selection is moving to the right,
     * so views are scrolling to the left. -1 means selection is moving to the left.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.646 -0400", hash_original_method = "0F1AB15FAF6E813E4CB44CFB5741FFDC", hash_generated_method = "DC73610D91E528C1265E125DBF4ACA1F")
    
@Override
    void layout(int delta, boolean animate) {
        int childrenLeft = mSpinnerPadding.left;
        int childrenWidth = getRight() - getLeft() - mSpinnerPadding.left - mSpinnerPadding.right;

        if (mDataChanged) {
            handleDataChanged();
        }

        // Handle the empty set by removing all views
        if (mItemCount == 0) {
            resetList();
            return;
        }

        if (mNextSelectedPosition >= 0) {
            setSelectedPositionInt(mNextSelectedPosition);
        }

        recycleAllViews();

        // Clear out old views
        removeAllViewsInLayout();

        // Make selected view and position it
        mFirstPosition = mSelectedPosition;
        View sel = makeAndAddView(mSelectedPosition);
        int width = sel.getMeasuredWidth();
        int selectedOffset = childrenLeft;
        switch (mGravity & Gravity.HORIZONTAL_GRAVITY_MASK) {
            case Gravity.CENTER_HORIZONTAL:
                selectedOffset = childrenLeft + (childrenWidth / 2) - (width / 2);
                break;
            case Gravity.RIGHT:
                selectedOffset = childrenLeft + childrenWidth - width;
                break;
        }
        sel.offsetLeftAndRight(selectedOffset);

        // Flush any cached views that did not get reused above
        mRecycler.clear();

        invalidate();

        checkSelectionChanged();

        mDataChanged = false;
        mNeedSync = false;
        setNextSelectedPositionInt(mSelectedPosition);
    }

    /**
     * Obtain a view, either by pulling an existing view from the recycler or
     * by getting a new one from the adapter. If we are animating, make sure
     * there is enough information in the view's layout parameters to animate
     * from the old to new positions.
     *
     * @param position Position in the spinner for the view to obtain
     * @return A view that has been added to the spinner
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.654 -0400", hash_original_method = "16A0D15DF35F8329F5BE73262CE9B509", hash_generated_method = "C19A613AD32C7950E4F49F5A1A23137C")
    
private View makeAndAddView(int position) {

        View child;

        if (!mDataChanged) {
            child = mRecycler.get(position);
            if (child != null) {
                // Position the view
                setUpChild(child);

                return child;
            }
        }

        // Nothing found in the recycler -- ask the adapter for a view
        child = mAdapter.getView(position, null, this);

        // Position the view
        setUpChild(child);

        return child;
    }

    /**
     * Helper for makeAndAddView to set the position of a view
     * and fill out its layout paramters.
     *
     * @param child The view to position
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.667 -0400", hash_original_method = "36DE22A04BF6CE4E6D4F683A2B1C4C05", hash_generated_method = "1975EB73AFD491B39B424FDF92F980FB")
    
private void setUpChild(View child) {

        // Respect layout params that are already in the view. Otherwise
        // make some up...
        ViewGroup.LayoutParams lp = child.getLayoutParams();
        if (lp == null) {
            lp = generateDefaultLayoutParams();
        }

        addViewInLayout(child, 0, lp);

        child.setSelected(hasFocus());

        // Get measure specs
        int childHeightSpec = ViewGroup.getChildMeasureSpec(mHeightMeasureSpec,
                mSpinnerPadding.top + mSpinnerPadding.bottom, lp.height);
        int childWidthSpec = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec,
                mSpinnerPadding.left + mSpinnerPadding.right, lp.width);

        // Measure child
        child.measure(childWidthSpec, childHeightSpec);

        int childLeft;
        int childRight;

        // Position vertically based on gravity setting
        int childTop = mSpinnerPadding.top
                + ((getMeasuredHeight() - mSpinnerPadding.bottom -
                mSpinnerPadding.top - child.getMeasuredHeight()) / 2);
        int childBottom = childTop + child.getMeasuredHeight();

        int width = child.getMeasuredWidth();
        childLeft = 0;
        childRight = childLeft + width;

        child.layout(childLeft, childTop, childRight, childBottom);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.674 -0400", hash_original_method = "DE0583C7611D1F2BE10915793A501A4C", hash_generated_method = "BED26375FFB74C4D31CC868D7993F631")
    
@Override
    public boolean performClick() {
        boolean handled = super.performClick();

        if (!handled) {
            handled = true;

            if (!mPopup.isShowing()) {
                mPopup.show();
            }
        }

        return handled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.684 -0400", hash_original_method = "21A8DBFD7E0EEAC4158875C988469F50", hash_generated_method = "1D6F32633F3775D14D8DA1877D92128C")
    
public void onClick(DialogInterface dialog, int which) {
        setSelection(which);
        dialog.dismiss();
    }

    /**
     * Sets the prompt to display when the dialog is shown.
     * @param prompt the prompt to set
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.692 -0400", hash_original_method = "82831FCEC8FF5E5499EA6A36B12A66DA", hash_generated_method = "DA3402CDD5C9B14C14A06E0299D74748")
    
public void setPrompt(CharSequence prompt) {
        mPopup.setPromptText(prompt);
    }

    /**
     * Sets the prompt to display when the dialog is shown.
     * @param promptId the resource ID of the prompt to display when the dialog is shown
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.699 -0400", hash_original_method = "21AEC72317B46CB2881CC90C11A2AA6E", hash_generated_method = "5286C94FB2EAD6E33D86CEEEEEAF9ED6")
    
public void setPromptId(int promptId) {
        setPrompt(getContext().getText(promptId));
    }

    /**
     * @return The prompt to display when the dialog is shown
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.706 -0400", hash_original_method = "07472705288FF1B8FBB0DCE1C944E4ED", hash_generated_method = "9ECC58AF25644B79F11D7F0915DCDF0D")
    
public CharSequence getPrompt() {
        return mPopup.getHintText();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:06:45.719 -0400", hash_original_method = "EB37E42D6ACA63E84337B27962C39033", hash_generated_method = "5D4F9D30A18F3DF5C0F75DDD5FD04597")
    
int measureContentWidth(SpinnerAdapter adapter, Drawable background) {
        if (adapter == null) {
            return 0;
        }

        int width = 0;
        View itemView = null;
        int itemType = 0;
        final int widthMeasureSpec =
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        final int heightMeasureSpec =
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);

        // Make sure the number of items we'll measure is capped. If it's a huge data set
        // with wildly varying sizes, oh well.
        int start = Math.max(0, getSelectedItemPosition());
        final int end = Math.min(adapter.getCount(), start + MAX_ITEMS_MEASURED);
        final int count = end - start;
        start = Math.max(0, start - (MAX_ITEMS_MEASURED - count));
        for (int i = start; i < end; i++) {
            final int positionType = adapter.getItemViewType(i);
            if (positionType != itemType) {
                itemType = positionType;
                itemView = null;
            }
            itemView = adapter.getView(i, itemView, this);
            if (itemView.getLayoutParams() == null) {
                itemView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
            }
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
            width = Math.max(width, itemView.getMeasuredWidth());
        }

        // Add background padding to measured width
        if (background != null) {
            background.getPadding(mTempRect);
            width += mTempRect.left + mTempRect.right;
        }

        return width;
    }

    /**
     * <p>Wrapper class for an Adapter. Transforms the embedded Adapter instance
     * into a ListAdapter.</p>
     */
    private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter mAdapter;
        private ListAdapter mListAdapter;

        /**
         * <p>Creates a new ListAdapter wrapper for the specified adapter.</p>
         *
         * @param adapter the Adapter to transform into a ListAdapter
         */
        public DropDownAdapter(SpinnerAdapter adapter) {
            this.mAdapter = adapter;
            if (adapter instanceof ListAdapter) {
                this.mListAdapter = (ListAdapter) adapter;
            }
        }
        
        @DSSafe(DSCat.SAFE_LIST)
        public int getCount() {
            return mAdapter == null ? 0 : mAdapter.getCount();
        }

        @DSSource({DSSourceKind.DATABASE_INFORMATION})
        @DSSafe(DSCat.SAFE_LIST)
        public Object getItem(int position) {
            return mAdapter == null ? null : mAdapter.getItem(position);
        }

        @DSSource({DSSourceKind.DATABASE})
        @DSSafe(DSCat.SAFE_LIST)
        public long getItemId(int position) {
            return mAdapter == null ? -1 : mAdapter.getItemId(position);
        }

        @DSSafe(DSCat.SAFE_LIST)
        public View getView(int position, View convertView, ViewGroup parent) {
            return getDropDownView(position, convertView, parent);
        }

        @DSSafe(DSCat.SAFE_LIST)
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            return mAdapter == null ? null :
                    mAdapter.getDropDownView(position, convertView, parent);
        }

        @DSSafe(DSCat.SAFE_LIST)
        public boolean hasStableIds() {
            return mAdapter != null && mAdapter.hasStableIds();
        }

        @DSSafe(DSCat.SAFE_LIST)
        public void registerDataSetObserver(DataSetObserver observer) {
            if (mAdapter != null) {
                mAdapter.registerDataSetObserver(observer);
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        public void unregisterDataSetObserver(DataSetObserver observer) {
            if (mAdapter != null) {
                mAdapter.unregisterDataSetObserver(observer);
            }
        }

        /**
         * If the wrapped SpinnerAdapter is also a ListAdapter, delegate this call.
         * Otherwise, return true.
         */
        @DSSafe(DSCat.SAFE_LIST)
        public boolean areAllItemsEnabled() {
            final ListAdapter adapter = mListAdapter;
            if (adapter != null) {
                return adapter.areAllItemsEnabled();
            } else {
                return true;
            }
        }

        /**
         * If the wrapped SpinnerAdapter is also a ListAdapter, delegate this call.
         * Otherwise, return true.
         */
        @DSSafe(DSCat.SAFE_LIST)
        public boolean isEnabled(int position) {
            final ListAdapter adapter = mListAdapter;
            if (adapter != null) {
                return adapter.isEnabled(position);
            } else {
                return true;
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        public int getItemViewType(int position) {
            return 0;
        }

        public int getViewTypeCount() {
            return 1;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /**
     * Implements some sort of popup selection interface for selecting a spinner option.
     * Allows for different spinner modes.
     */
    private interface SpinnerPopup {
        public void setAdapter(ListAdapter adapter);

        /**
         * Show the popup
         */
        public void show();

        /**
         * Dismiss the popup
         */
        public void dismiss();

        /**
         * @return true if the popup is showing, false otherwise.
         */
        public boolean isShowing();

        /**
         * Set hint text to be displayed to the user. This should provide
         * a description of the choice being made.
         * @param hintText Hint text to set.
         */
        public void setPromptText(CharSequence hintText);
        public CharSequence getHintText();
    }

    private class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {
        private AlertDialog mPopup;
        private ListAdapter mListAdapter;
        private CharSequence mPrompt;

        @DSSafe(DSCat.SAFE_LIST)
        public void dismiss() {
            mPopup.dismiss();
            mPopup = null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public boolean isShowing() {
            return mPopup != null ? mPopup.isShowing() : false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setAdapter(ListAdapter adapter) {
            mListAdapter = adapter;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setPromptText(CharSequence hintText) {
            mPrompt = hintText;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public CharSequence getHintText() {
            return mPrompt;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public void show() {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            if (mPrompt != null) {
                builder.setTitle(mPrompt);
            }
            mPopup = builder.setSingleChoiceItems(mListAdapter,
                    getSelectedItemPosition(), this).show();
        }

        public void onClick(DialogInterface dialog, int which) {
            setSelection(which);
            if (mOnItemClickListener != null) {
                performItemClick(null, which, mListAdapter.getItemId(which));
            }
            dismiss();
        }
    }

    private class DropdownPopup extends android.support.v7.internal.widget.ListPopupWindow
            implements SpinnerPopup {
        private CharSequence mHintText;
        private ListAdapter mAdapter;

        public DropdownPopup(Context context, AttributeSet attrs, int defStyleRes) {
            super(context, attrs, defStyleRes);

            setAnchorView(SpinnerICS.this);
            setModal(true);
            setPromptPosition(POSITION_PROMPT_ABOVE);

            AdapterView.OnItemClickListener listener = new OnItemClickListenerWrapper(
                    new OnItemClickListener() {
                public void onItemClick(AdapterViewICS parent, View v, int position, long id) {
                    SpinnerICS.this.setSelection(position);
                    if (mOnItemClickListener != null) {
                        SpinnerICS.this.performItemClick(v, position, mAdapter.getItemId(position));
                    }
                    dismiss();
                }
            });

            setOnItemClickListener(listener);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setAdapter(ListAdapter adapter) {
            super.setAdapter(adapter);
            mAdapter = adapter;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public CharSequence getHintText() {
            return mHintText;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setPromptText(CharSequence hintText) {
            // Hint text is ignored for dropdowns, but maintain it here.
            mHintText = hintText;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void show() {
            final int spinnerPaddingLeft = SpinnerICS.this.getPaddingLeft();
            if (mDropDownWidth == WRAP_CONTENT) {
                final int spinnerWidth = SpinnerICS.this.getWidth();
                final int spinnerPaddingRight = SpinnerICS.this.getPaddingRight();
                setContentWidth(Math.max(
                        measureContentWidth((SpinnerAdapter) mAdapter, getBackground()),
                        spinnerWidth - spinnerPaddingLeft - spinnerPaddingRight));
            } else if (mDropDownWidth == FILL_PARENT) {
                final int spinnerWidth = SpinnerICS.this.getWidth();
                final int spinnerPaddingRight = SpinnerICS.this.getPaddingRight();
                setContentWidth(spinnerWidth - spinnerPaddingLeft - spinnerPaddingRight);
            } else {
                setContentWidth(mDropDownWidth);
            }
            final Drawable background = getBackground();
            int bgOffset = 0;
            if (background != null) {
                background.getPadding(mTempRect);
                bgOffset = -mTempRect.left;
            }
            setHorizontalOffset(bgOffset + spinnerPaddingLeft);
            setInputMethodMode(ListPopupWindow.INPUT_METHOD_NOT_NEEDED);
            super.show();
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            setSelection(SpinnerICS.this.getSelectedItemPosition());
        }
    }
}
