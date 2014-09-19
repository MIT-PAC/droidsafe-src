/*
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
package android.support.v7.internal.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionMode;
import android.support.v7.internal.view.menu.ActionMenuPresenter;
import android.support.v7.internal.view.menu.ActionMenuView;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @hide
 */
public class ActionBarContextView extends AbsActionBarView {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.435 -0400", hash_original_field = "4903F05D59AFFD00260A63A4EC905F53", hash_generated_field = "C45604C41252B81A800ABE94C507699D")


    private static final String TAG = "ActionBarContextView";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.444 -0400", hash_original_field = "8C445459F9A68BF8713F87AC9D695E47", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")


    private CharSequence mTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.450 -0400", hash_original_field = "AB153FEBC9BAB866EB9D9BD858F863D7", hash_generated_field = "775125B4EBC8ED0F3E5FBA051277E18D")

    private CharSequence mSubtitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.457 -0400", hash_original_field = "9E5ABA39447839CB8750D1879400036C", hash_generated_field = "24F281CC402C90EA9D9EB00DDCF618F4")


    private View mClose;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.464 -0400", hash_original_field = "ADD711F109703E2EAF61E2AD917F3FB6", hash_generated_field = "58BF9FCCDFB47B7346A31DF060279244")

    private View mCustomView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.484 -0400", hash_original_field = "F5CA594DCFB48DED54369A102A0AE68B", hash_generated_field = "53515DAB03CBCC904881F85C0D0B24F4")

    private LinearLayout mTitleLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.491 -0400", hash_original_field = "B3B1177DB6C3A24EAC74C6705FD25300", hash_generated_field = "3B26FAD098CFEC3A217F2BF71097A83E")

    private TextView mTitleView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.497 -0400", hash_original_field = "913CA974C51FCA87DC9298E376261903", hash_generated_field = "5B91EC47B0CD462AA7928A5697458750")

    private TextView mSubtitleView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.505 -0400", hash_original_field = "91BBE04D928B78D71ACCA8B7A1A78C5D", hash_generated_field = "CFEDF1432A06310A2FB06B788CC20410")

    private int mTitleStyleRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.511 -0400", hash_original_field = "1B837B3FAA0F380D6AF3C59E69CB3BE4", hash_generated_field = "9FA8532B8CB2D1269C79565E301C661F")

    private int mSubtitleStyleRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.518 -0400", hash_original_field = "A2559183FE2F41FA2ACFFAAD43DEAB22", hash_generated_field = "EAFF30D2C8DDA41FABEEAF56960F2296")

    private Drawable mSplitBackground;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.524 -0400", hash_original_field = "A0D8E2C04F8DD2391392983EA5762E96", hash_generated_field = "8A77B9C933654DADA3F01CA69D4FE164")

    private boolean mTitleOptional;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.533 -0400", hash_original_method = "2EBFD0846938BB846291BE9F4AD94F04", hash_generated_method = "5204B1F16256DBE4D4C418301785327D")
    
public ActionBarContextView(Context context) {
        this(context, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.540 -0400", hash_original_method = "A7D95E3CAF8BA47E9D24CE0C44DCD39F", hash_generated_method = "D5545913A1F04CB57C8BF3685441059C")
    
public ActionBarContextView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.actionModeStyle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.557 -0400", hash_original_method = "66DC1BABCA25F41E2F06FFF148AB9600", hash_generated_method = "76CC7A22010DFAC577FC56B21FB056B0")
    
public ActionBarContextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ActionMode, defStyle, 0);
        setBackgroundDrawable(a.getDrawable(
                R.styleable.ActionMode_background));
        mTitleStyleRes = a.getResourceId(
                R.styleable.ActionMode_titleTextStyle, 0);
        mSubtitleStyleRes = a.getResourceId(
                R.styleable.ActionMode_subtitleTextStyle, 0);

        mContentHeight = a.getLayoutDimension(
                R.styleable.ActionMode_height, 0);

        mSplitBackground = a.getDrawable(
                R.styleable.ActionMode_backgroundSplit);

        a.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.566 -0400", hash_original_method = "B72CC99F1AE7F170915B2F32514E502E", hash_generated_method = "85E4C34DF224DF00676DC6184CD8DB89")
    
@Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mActionMenuPresenter != null) {
            mActionMenuPresenter.hideOverflowMenu();
            mActionMenuPresenter.hideSubMenus();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.587 -0400", hash_original_method = "9228B7FC13E5F5D46E19A8808940F624", hash_generated_method = "ADD6F3153E06C7CF79FD7115FA21EAC3")
    
@Override
    public void setSplitActionBar(boolean split) {
        if (mSplitActionBar != split) {
            if (mActionMenuPresenter != null) {
                // Mode is already active; move everything over and adjust the menu itself.
                final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.FILL_PARENT);
                if (!split) {
                    mMenuView = (ActionMenuView) mActionMenuPresenter.getMenuView(this);
                    mMenuView.setBackgroundDrawable(null);
                    final ViewGroup oldParent = (ViewGroup) mMenuView.getParent();
                    if (oldParent != null) {
                        oldParent.removeView(mMenuView);
                    }
                    addView(mMenuView, layoutParams);
                } else {
                    // Allow full screen width in split mode.
                    mActionMenuPresenter.setWidthLimit(
                            getContext().getResources().getDisplayMetrics().widthPixels, true);
                    // No limit to the item count; use whatever will fit.
                    mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
                    // Span the whole width
                    layoutParams.width = ViewGroup.LayoutParams.FILL_PARENT;
                    layoutParams.height = mContentHeight;
                    mMenuView = (ActionMenuView) mActionMenuPresenter.getMenuView(this);
                    mMenuView.setBackgroundDrawable(mSplitBackground);
                    final ViewGroup oldParent = (ViewGroup) mMenuView.getParent();
                    if (oldParent != null) {
                        oldParent.removeView(mMenuView);
                    }
                    mSplitView.addView(mMenuView, layoutParams);
                }
            }
            super.setSplitActionBar(split);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.595 -0400", hash_original_method = "2AF53FC77EF46E1AB46FFEE70D9B4BD3", hash_generated_method = "73099CFA6347D7279481242D53B55ACD")
    
public void setContentHeight(int height) {
        mContentHeight = height;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.604 -0400", hash_original_method = "BF35621F736CEABB1B31AE57D0749737", hash_generated_method = "253AA444B71B925E0AF3E202A9F00B36")
    
public void setCustomView(View view) {
        if (mCustomView != null) {
            removeView(mCustomView);
        }
        mCustomView = view;
        if (mTitleLayout != null) {
            removeView(mTitleLayout);
            mTitleLayout = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.614 -0400", hash_original_method = "211EB79F55FBE601162C52B7DDCEAE29", hash_generated_method = "ABDADF55037DFFFE045D7206C2E121F1")
    
public void setTitle(CharSequence title) {
        mTitle = title;
        initTitle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.623 -0400", hash_original_method = "7D9357B6D11390EB60D28E00C6F28FA8", hash_generated_method = "9A059E21C7BE314F1FFA7934207C4071")
    
public void setSubtitle(CharSequence subtitle) {
        mSubtitle = subtitle;
        initTitle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.629 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "E948C46F1704FC1F24545ED5A725BEE6")
    
public CharSequence getTitle() {
        return mTitle;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.636 -0400", hash_original_method = "8334E54E49A430BB5E2CB9D01857CDC7", hash_generated_method = "3773E52DB2B3822F51D6A3F2CB66D7C2")
    
public CharSequence getSubtitle() {
        return mSubtitle;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.650 -0400", hash_original_method = "856402E3C8B8B19BF8375BB35A80D78C", hash_generated_method = "06164B6C305CE7E4586BDFA394BAEAED")
    
private void initTitle() {
        if (mTitleLayout == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            inflater.inflate(R.layout.abc_action_bar_title_item, this);
            mTitleLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            mTitleView = (TextView) mTitleLayout.findViewById(R.id.action_bar_title);
            mSubtitleView = (TextView) mTitleLayout.findViewById(R.id.action_bar_subtitle);
            if (mTitleStyleRes != 0) {
                mTitleView.setTextAppearance(getContext(), mTitleStyleRes);
            }
            if (mSubtitleStyleRes != 0) {
                mSubtitleView.setTextAppearance(getContext(), mSubtitleStyleRes);
            }
        }

        mTitleView.setText(mTitle);
        mSubtitleView.setText(mSubtitle);

        final boolean hasTitle = !TextUtils.isEmpty(mTitle);
        final boolean hasSubtitle = !TextUtils.isEmpty(mSubtitle);
        mSubtitleView.setVisibility(hasSubtitle ? VISIBLE : GONE);
        mTitleLayout.setVisibility(hasTitle || hasSubtitle ? VISIBLE : GONE);
        if (mTitleLayout.getParent() == null) {
            addView(mTitleLayout);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.678 -0400", hash_original_method = "1E79714AAFC3514FB03FC49B8EFD68A4", hash_generated_method = "4104248550B50B64CB36324A05AFC502")
    
public void initForMode(final ActionMode mode) {
        if (mClose == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            mClose = inflater.inflate(R.layout.abc_action_mode_close_item, this, false);
            addView(mClose);
        } else if (mClose.getParent() == null) {
            addView(mClose);
        }

        View closeButton = mClose.findViewById(R.id.action_mode_close_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mode.finish();
            }
        });

        final MenuBuilder menu = (MenuBuilder) mode.getMenu();
        if (mActionMenuPresenter != null) {
            mActionMenuPresenter.dismissPopupMenus();
        }
        mActionMenuPresenter = new ActionMenuPresenter(getContext());
        mActionMenuPresenter.setReserveOverflow(true);

        final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.FILL_PARENT);
        if (!mSplitActionBar) {
            menu.addMenuPresenter(mActionMenuPresenter);
            mMenuView = (ActionMenuView) mActionMenuPresenter.getMenuView(this);
            mMenuView.setBackgroundDrawable(null);
            addView(mMenuView, layoutParams);
        } else {
            // Allow full screen width in split mode.
            mActionMenuPresenter.setWidthLimit(
                    getContext().getResources().getDisplayMetrics().widthPixels, true);
            // No limit to the item count; use whatever will fit.
            mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
            // Span the whole width
            layoutParams.width = ViewGroup.LayoutParams.FILL_PARENT;
            layoutParams.height = mContentHeight;
            menu.addMenuPresenter(mActionMenuPresenter);
            mMenuView = (ActionMenuView) mActionMenuPresenter.getMenuView(this);
            mMenuView.setBackgroundDrawable(mSplitBackground);
            mSplitView.addView(mMenuView, layoutParams);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.686 -0400", hash_original_method = "5BFE38CAE677BE0C1C701368344881C8", hash_generated_method = "B60320CFD1729E74B9D8E7B420677C9A")
    
public void closeMode() {
        if (mClose == null) {
            killMode();
            return;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.694 -0400", hash_original_method = "602896C4206AEA21B6C7689639C6A506", hash_generated_method = "CAA13721761B6282B2005D504913F12E")
    
public void killMode() {
        removeAllViews();
        if (mSplitView != null) {
            mSplitView.removeView(mMenuView);
        }
        mCustomView = null;
        mMenuView = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.701 -0400", hash_original_method = "6ECDD9C0917165AAFEF87E5E5EC8B474", hash_generated_method = "DB1A2AF65655622E1B55F35B09A3551A")
    
@Override
    public boolean showOverflowMenu() {
        if (mActionMenuPresenter != null) {
            return mActionMenuPresenter.showOverflowMenu();
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.710 -0400", hash_original_method = "5D05982F33AF24415676BD0317DE2206", hash_generated_method = "467E80F972452C0C6AFEA47847C03B8F")
    
@Override
    public boolean hideOverflowMenu() {
        if (mActionMenuPresenter != null) {
            return mActionMenuPresenter.hideOverflowMenu();
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.718 -0400", hash_original_method = "2F838D8CBDDC91E04D7A8F0F52ABF2C8", hash_generated_method = "DE5567A716B3EC74155227BDC35F2E18")
    
@Override
    public boolean isOverflowMenuShowing() {
        if (mActionMenuPresenter != null) {
            return mActionMenuPresenter.isOverflowMenuShowing();
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.726 -0400", hash_original_method = "D35500C62744075F782DE30CE2851D2B", hash_generated_method = "A344403C95180287E50EFD9B07E1468D")
    
@Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        // Used by custom views if they don't supply layout params. Everything else
        // added to an ActionBarContextView should have them already.
        return new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.735 -0400", hash_original_method = "C708C2680E01094CD50AD70B31F79224", hash_generated_method = "F9DD32B0111210FEDE2C620E07102FC7")
    
@Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new ViewGroup.MarginLayoutParams(getContext(), attrs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.754 -0400", hash_original_method = "9A1A76A2A395E3414C3E1FDE7CC6CC9F", hash_generated_method = "74260B12F4C8C2DC1F8A692BEC55C80C")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        if (widthMode != View.MeasureSpec.EXACTLY) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " +
                    "with android:layout_width=\"FILL_PARENT\" (or fill_parent)");
        }

        final int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        if (heightMode == View.MeasureSpec.UNSPECIFIED) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " +
                    "with android:layout_height=\"wrap_content\"");
        }

        final int contentWidth = View.MeasureSpec.getSize(widthMeasureSpec);

        int maxHeight = mContentHeight > 0 ?
                mContentHeight : View.MeasureSpec.getSize(heightMeasureSpec);

        final int verticalPadding = getPaddingTop() + getPaddingBottom();
        int availableWidth = contentWidth - getPaddingLeft() - getPaddingRight();
        final int height = maxHeight - verticalPadding;
        final int childSpecHeight = View.MeasureSpec
                .makeMeasureSpec(height, View.MeasureSpec.AT_MOST);

        if (mClose != null) {
            availableWidth = measureChildView(mClose, availableWidth, childSpecHeight, 0);
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) mClose
                    .getLayoutParams();
            availableWidth -= lp.leftMargin + lp.rightMargin;
        }

        if (mMenuView != null && mMenuView.getParent() == this) {
            availableWidth = measureChildView(mMenuView, availableWidth,
                    childSpecHeight, 0);
        }

        if (mTitleLayout != null && mCustomView == null) {
            if (mTitleOptional) {
                final int titleWidthSpec = View.MeasureSpec
                        .makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                mTitleLayout.measure(titleWidthSpec, childSpecHeight);
                final int titleWidth = mTitleLayout.getMeasuredWidth();
                final boolean titleFits = titleWidth <= availableWidth;
                if (titleFits) {
                    availableWidth -= titleWidth;
                }
                mTitleLayout.setVisibility(titleFits ? VISIBLE : GONE);
            } else {
                availableWidth = measureChildView(mTitleLayout, availableWidth, childSpecHeight, 0);
            }
        }

        if (mCustomView != null) {
            ViewGroup.LayoutParams lp = mCustomView.getLayoutParams();
            final int customWidthMode = lp.width != ViewGroup.LayoutParams.WRAP_CONTENT ?
                    View.MeasureSpec.EXACTLY : View.MeasureSpec.AT_MOST;
            final int customWidth = lp.width >= 0 ?
                    Math.min(lp.width, availableWidth) : availableWidth;
            final int customHeightMode = lp.height != ViewGroup.LayoutParams.WRAP_CONTENT ?
                    View.MeasureSpec.EXACTLY : View.MeasureSpec.AT_MOST;
            final int customHeight = lp.height >= 0 ?
                    Math.min(lp.height, height) : height;
            mCustomView.measure(View.MeasureSpec.makeMeasureSpec(customWidth, customWidthMode),
                    View.MeasureSpec.makeMeasureSpec(customHeight, customHeightMode));
        }

        if (mContentHeight <= 0) {
            int measuredHeight = 0;
            final int count = getChildCount();
            for (int i = 0; i < count; i++) {
                View v = getChildAt(i);
                int paddedViewHeight = v.getMeasuredHeight() + verticalPadding;
                if (paddedViewHeight > measuredHeight) {
                    measuredHeight = paddedViewHeight;
                }
            }
            setMeasuredDimension(contentWidth, measuredHeight);
        } else {
            setMeasuredDimension(contentWidth, maxHeight);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.764 -0400", hash_original_method = "66CC4B6F2149B6576BB0B31CB286E8D8", hash_generated_method = "ECDC067E524A3855E033AB684BCAEE3F")
    
@Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int x = getPaddingLeft();
        final int y = getPaddingTop();
        final int contentHeight = b - t - getPaddingTop() - getPaddingBottom();

        if (mClose != null && mClose.getVisibility() != GONE) {
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) mClose
                    .getLayoutParams();
            x += lp.leftMargin;
            x += positionChild(mClose, x, y, contentHeight);
            x += lp.rightMargin;

        }

        if (mTitleLayout != null && mCustomView == null && mTitleLayout.getVisibility() != GONE) {
            x += positionChild(mTitleLayout, x, y, contentHeight);
        }

        if (mCustomView != null) {
            x += positionChild(mCustomView, x, y, contentHeight);
        }

        x = r - l - getPaddingRight();

        if (mMenuView != null) {
            x -= positionChildInverse(mMenuView, x, y, contentHeight);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.771 -0400", hash_original_method = "1C3FA98CB13F3251D9BD9AC234F80D87", hash_generated_method = "5EC3BB920B121655189EFA2CD736D318")
    
public void setTitleOptional(boolean titleOptional) {
        if (titleOptional != mTitleOptional) {
            requestLayout();
        }
        mTitleOptional = titleOptional;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 10:54:14.775 -0400", hash_original_method = "374D01271DE8D67C559342233B486510", hash_generated_method = "FA85A4575CE0561F73AC70D2EB3DBBF3")
    
public boolean isTitleOptional() {
        return mTitleOptional;
    }
}
