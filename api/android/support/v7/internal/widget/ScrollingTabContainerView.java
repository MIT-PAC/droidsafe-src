/*
 * Copyright (C) 2011 The Android Open Source Project
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
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R;
import android.support.v7.internal.view.ActionBarPolicy;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * This widget implements the dynamic action bar tab behavior that can change across different
 * configurations or circumstances.
 *
 * @hide
 */
public class ScrollingTabContainerView extends HorizontalScrollView
        implements AdapterViewICS.OnItemClickListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.737 -0400", hash_original_field = "6C8728AD27930156AB8B4DB6BE524CA6", hash_generated_field = "8198E33AEA6A4E67CF498CFCEDA7ACFC")


    private static final String TAG = "ScrollingTabContainerView";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.739 -0400", hash_original_field = "E682310941753B94BE1FECAC9286C6E9", hash_generated_field = "E682310941753B94BE1FECAC9286C6E9")

    Runnable mTabSelector;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.741 -0400", hash_original_field = "27F716F08128A8A34303C449A84D3A78", hash_generated_field = "9D65B8DF4295D2997A201C87527D1868")

    private TabClickListener mTabClickListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.743 -0400", hash_original_field = "117D0428E613CA4EEA398DB816A811C9", hash_generated_field = "E5144854D9186C0CFBAD4E1FE3ACCBAF")


    private LinearLayout mTabLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.745 -0400", hash_original_field = "ABA35B8DEAF6F6F3E525E90C0C888748", hash_generated_field = "27919755099CABF8038B2DC3252B547C")

    private SpinnerICS mTabSpinner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.747 -0400", hash_original_field = "38A157EEF5FAA5B04C6812A030CB89D6", hash_generated_field = "F02107E932C3D4F526DFB20B4DC44818")

    private boolean mAllowCollapse;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.749 -0400", hash_original_field = "B03B4DAE3F576B7166425BEE37B96C5E", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")


    private  LayoutInflater mInflater;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.751 -0400", hash_original_field = "2536FBAA8D2459579C241F8EA3302AA1", hash_generated_field = "2536FBAA8D2459579C241F8EA3302AA1")


    int mMaxTabWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.753 -0400", hash_original_field = "F6922599AF8F8C01D9657DDBC0BBE90F", hash_generated_field = "F6922599AF8F8C01D9657DDBC0BBE90F")

    int mStackedTabMaxWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.755 -0400", hash_original_field = "6909FC61CEAFC4290968B35F30281B2B", hash_generated_field = "2B9929C05137BEFD1EEE8192DEC02202")

    private int mContentHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.758 -0400", hash_original_field = "3E29127999834DE794E6FF50E94B261E", hash_generated_field = "5FAA7FEF18B6FA6D1EC21FF900B235B4")

    private int mSelectedTabIndex;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.761 -0400", hash_original_method = "9C73CF34E6AB4FEA2E012CFF5165573D", hash_generated_method = "EAFA69D13551394FA7B4A6E81480424F")
    
public ScrollingTabContainerView(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);

        setHorizontalScrollBarEnabled(false);

        ActionBarPolicy abp = ActionBarPolicy.get(context);
        setContentHeight(abp.getTabContainerHeight());
        mStackedTabMaxWidth = abp.getStackedTabMaxWidth();

        mTabLayout = (LinearLayout) mInflater.inflate(R.layout.abc_action_bar_tabbar, this, false);
        addView(mTabLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.FILL_PARENT));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.764 -0400", hash_original_method = "D8A2A7EE17DA5B352BCD2933C7BEF96B", hash_generated_method = "7026A2EC3054AFDCA3747F830C7C11EA")
    
@Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final boolean lockedExpanded = widthMode == MeasureSpec.EXACTLY;
        setFillViewport(lockedExpanded);

        final int childCount = mTabLayout.getChildCount();
        if (childCount > 1 &&
                (widthMode == MeasureSpec.EXACTLY || widthMode == MeasureSpec.AT_MOST)) {
            if (childCount > 2) {
                mMaxTabWidth = (int) (MeasureSpec.getSize(widthMeasureSpec) * 0.4f);
            } else {
                mMaxTabWidth = MeasureSpec.getSize(widthMeasureSpec) / 2;
            }
            mMaxTabWidth = Math.min(mMaxTabWidth, mStackedTabMaxWidth);
        } else {
            mMaxTabWidth = -1;
        }

        heightMeasureSpec = MeasureSpec.makeMeasureSpec(mContentHeight, MeasureSpec.EXACTLY);

        final boolean canCollapse = !lockedExpanded && mAllowCollapse;

        if (canCollapse) {
            // See if we should expand
            mTabLayout.measure(MeasureSpec.UNSPECIFIED, heightMeasureSpec);
            if (mTabLayout.getMeasuredWidth() > MeasureSpec.getSize(widthMeasureSpec)) {
                performCollapse();
            } else {
                performExpand();
            }
        } else {
            performExpand();
        }

        final int oldWidth = getMeasuredWidth();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int newWidth = getMeasuredWidth();

        if (lockedExpanded && oldWidth != newWidth) {
            // Recenter the tab display if we're at a new (scrollable) size.
            setTabSelected(mSelectedTabIndex);
        }
    }

    /**
     * Indicates whether this view is collapsed into a dropdown menu instead of traditional tabs.
     *
     * @return true if showing as a spinner
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.766 -0400", hash_original_method = "0C44DD211AEDE4F8875A759BF8E8E48B", hash_generated_method = "BC517FA24EACE7A695FB011A5D82F875")
    
private boolean isCollapsed() {
        return mTabSpinner != null && mTabSpinner.getParent() == this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.769 -0400", hash_original_method = "E654067D8A391E646F927D11468DA221", hash_generated_method = "39D180B8DA3868E9B3117926128CBE51")
    
public void setAllowCollapse(boolean allowCollapse) {
        mAllowCollapse = allowCollapse;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.771 -0400", hash_original_method = "E4A6441B355758E123E93C462AAB600B", hash_generated_method = "43B054F47B426CCB7303C472D451B979")
    
private void performCollapse() {
        if (isCollapsed()) {
            return;
        }

        if (mTabSpinner == null) {
            mTabSpinner = createSpinner();
        }
        removeView(mTabLayout);
        addView(mTabSpinner, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.FILL_PARENT));
        if (mTabSpinner.getAdapter() == null) {
            mTabSpinner.setAdapter(new TabAdapter());
        }
        if (mTabSelector != null) {
            removeCallbacks(mTabSelector);
            mTabSelector = null;
        }
        mTabSpinner.setSelection(mSelectedTabIndex);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.775 -0400", hash_original_method = "CF6AA315EED7F54B95F1D63E370DEAB9", hash_generated_method = "61753EF7F8E422AC0687C13441E5B851")
    
private boolean performExpand() {
        if (!isCollapsed()) {
            return false;
        }

        removeView(mTabSpinner);
        addView(mTabLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.FILL_PARENT));
        setTabSelected(mTabSpinner.getSelectedItemPosition());
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.778 -0400", hash_original_method = "5B085F5082C3C5C03A931B942AF8A3B6", hash_generated_method = "112BCF492B27698FE21828886138A967")
    
public void setTabSelected(int position) {
        mSelectedTabIndex = position;
        final int tabCount = mTabLayout.getChildCount();
        for (int i = 0; i < tabCount; i++) {
            final View child = mTabLayout.getChildAt(i);
            final boolean isSelected = i == position;
            child.setSelected(isSelected);
            if (isSelected) {
                animateToTab(position);
            }
        }
        if (mTabSpinner != null && position >= 0) {
            mTabSpinner.setSelection(position);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.780 -0400", hash_original_method = "2D264BA3FDE4BFC89C0D29CEF35AB5AF", hash_generated_method = "BA14FA1A5C9AF572E4D240F3CC7F6A66")
    
public void setContentHeight(int contentHeight) {
        mContentHeight = contentHeight;
        requestLayout();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.782 -0400", hash_original_method = "B4E812F40FC3A49365E1CB3188DE3779", hash_generated_method = "64EF974C0D2F495707A3F0DE7A620CE9")
    
private SpinnerICS createSpinner() {
        final SpinnerICS spinner = new SpinnerICS(getContext(), null,
                R.attr.actionDropDownStyle);
        spinner.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT));
        spinner.setOnItemClickListenerInt(this);
        return spinner;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.785 -0400", hash_original_method = "A26981EA8AD814980954A4CEE1D4E712", hash_generated_method = "18A922A28641D403F4314435286B81BA")
    
protected void onConfigurationChanged(Configuration newConfig) {
        ActionBarPolicy abp = ActionBarPolicy.get(getContext());
        // Action bar can change size on configuration changes.
        // Reread the desired height from the theme-specified style.
        setContentHeight(abp.getTabContainerHeight());
        mStackedTabMaxWidth = abp.getStackedTabMaxWidth();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.792 -0400", hash_original_method = "798975849EC8D4C022ED8EB3C4439FA8", hash_generated_method = "A4A568A7A57E71BBFDC61457E7EF9115")
    
public void animateToTab(final int position) {
        final View tabView = mTabLayout.getChildAt(position);
        if (mTabSelector != null) {
            removeCallbacks(mTabSelector);
        }
        mTabSelector = new Runnable() {
            public void run() {
                final int scrollPos = tabView.getLeft() - (getWidth() - tabView.getWidth()) / 2;
                smoothScrollTo(scrollPos, 0);
                mTabSelector = null;
            }
        };
        post(mTabSelector);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.794 -0400", hash_original_method = "887CFA274A392DE8385671362C9964CB", hash_generated_method = "076F7E6432360CBE28CEA2E9E2C26749")
    
@Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mTabSelector != null) {
            // Re-post the selector we saved
            post(mTabSelector);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.797 -0400", hash_original_method = "18C292ABA374873141A21AD02D4712CF", hash_generated_method = "6DAB4E72961212723D7393FA0190E981")
    
@Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mTabSelector != null) {
            removeCallbacks(mTabSelector);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.800 -0400", hash_original_method = "E3617A09ED94AE8466F09C3E16179C32", hash_generated_method = "5FC4D0B4C14AB0B25786A17AE0BB3980")
    
private TabView createTabView(ActionBar.Tab tab, boolean forAdapter) {
        final TabView tabView = (TabView) mInflater.inflate(R.layout.abc_action_bar_tab, mTabLayout,
                false);
        tabView.attach(this, tab, forAdapter);

        if (forAdapter) {
            tabView.setBackgroundDrawable(null);
            tabView.setLayoutParams(new ListView.LayoutParams(ListView.LayoutParams.FILL_PARENT,
                    mContentHeight));
        } else {
            tabView.setFocusable(true);

            if (mTabClickListener == null) {
                mTabClickListener = new TabClickListener();
            }
            tabView.setOnClickListener(mTabClickListener);
        }
        return tabView;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.803 -0400", hash_original_method = "5879B9B1BDE3F93014BC7C2D490E546E", hash_generated_method = "F26863D81298F0804DCADB66430ED7A9")
    
public void addTab(ActionBar.Tab tab, boolean setSelected) {
        TabView tabView = createTabView(tab, false);
        mTabLayout.addView(tabView, new LinearLayout.LayoutParams(0,
                LayoutParams.FILL_PARENT, 1));
        if (mTabSpinner != null) {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (setSelected) {
            tabView.setSelected(true);
        }
        if (mAllowCollapse) {
            requestLayout();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.806 -0400", hash_original_method = "CD9A593B089931F7795774F7AB284F41", hash_generated_method = "8D7C3A5CC3C9D85D00C6C6CB6C411AF3")
    
public void addTab(ActionBar.Tab tab, int position, boolean setSelected) {
        final TabView tabView = createTabView(tab, false);
        mTabLayout.addView(tabView, position, new LinearLayout.LayoutParams(
                0, LayoutParams.FILL_PARENT, 1));
        if (mTabSpinner != null) {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (setSelected) {
            tabView.setSelected(true);
        }
        if (mAllowCollapse) {
            requestLayout();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.808 -0400", hash_original_method = "AB4E22DBFABD54435D3DD6BE48A7A755", hash_generated_method = "A5986D8AE63246102446BD7AE4D30F38")
    
public void updateTab(int position) {
        ((TabView) mTabLayout.getChildAt(position)).update();
        if (mTabSpinner != null) {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (mAllowCollapse) {
            requestLayout();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.810 -0400", hash_original_method = "F55D08535CE5AE8E892CFC88E40F0277", hash_generated_method = "538626902C18D997FAA00ECEFD6F65ED")
    
public void removeTabAt(int position) {
        mTabLayout.removeViewAt(position);
        if (mTabSpinner != null) {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (mAllowCollapse) {
            requestLayout();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.812 -0400", hash_original_method = "505192EE2E755E624302670BB829212B", hash_generated_method = "C99ABC999ADB8D2BB225EA22C0506257")
    
public void removeAllTabs() {
        mTabLayout.removeAllViews();
        if (mTabSpinner != null) {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (mAllowCollapse) {
            requestLayout();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:49.815 -0400", hash_original_method = "9CB5F14C0AE4FAF95D21AEB43B29B5AA", hash_generated_method = "A2366EAEE03057154D5576EAEC148F62")
    
@Override
    public void onItemClick(AdapterViewICS<?> parent, View view, int position, long id) {
        TabView tabView = (TabView) view;
        tabView.getTab().select();
    }

    /**
     * @hide
     */
    public static class TabView extends LinearLayout {

        private ActionBar.Tab mTab;
        private TextView mTextView;
        private ImageView mIconView;
        private View mCustomView;
        private ScrollingTabContainerView mParent;

        public TabView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        void attach(ScrollingTabContainerView parent, ActionBar.Tab tab, boolean forList) {
            mParent = parent;
            mTab = tab;

            if (forList) {
                setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
            }

            update();
        }

        public void bindTab(ActionBar.Tab tab) {
            mTab = tab;
            update();
        }

        @Override
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);

            int maxTabWidth = mParent != null ? mParent.mMaxTabWidth : 0;

            // Re-measure if we went beyond our maximum size.
            if (maxTabWidth > 0 && getMeasuredWidth() > maxTabWidth) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(maxTabWidth, MeasureSpec.EXACTLY),
                        heightMeasureSpec);
            }
        }

        public void update() {
            final ActionBar.Tab tab = mTab;
            final View custom = tab.getCustomView();
            if (custom != null) {
                final ViewParent customParent = custom.getParent();
                if (customParent != this) {
                    if (customParent != null) {
                        ((ViewGroup) customParent).removeView(custom);
                    }
                    addView(custom);
                }
                mCustomView = custom;
                if (mTextView != null) {
                    mTextView.setVisibility(GONE);
                }
                if (mIconView != null) {
                    mIconView.setVisibility(GONE);
                    mIconView.setImageDrawable(null);
                }
            } else {
                if (mCustomView != null) {
                    removeView(mCustomView);
                    mCustomView = null;
                }

                final Drawable icon = tab.getIcon();
                final CharSequence text = tab.getText();

                if (icon != null) {
                    if (mIconView == null) {
                        ImageView iconView = new ImageView(getContext());
                        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,
                                LayoutParams.WRAP_CONTENT);
                        lp.gravity = Gravity.CENTER_VERTICAL;
                        iconView.setLayoutParams(lp);
                        addView(iconView, 0);
                        mIconView = iconView;
                    }
                    mIconView.setImageDrawable(icon);
                    mIconView.setVisibility(VISIBLE);
                } else if (mIconView != null) {
                    mIconView.setVisibility(GONE);
                    mIconView.setImageDrawable(null);
                }

                if (text != null) {
                    if (mTextView == null) {
                        /*TextView textView = new CompatTextView(getContext(), null,
                                R.attr.actionBarTabTextStyle);
                        textView.setEllipsize(TruncateAt.END);
                        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,
                                LayoutParams.WRAP_CONTENT);
                        lp.gravity = Gravity.CENTER_VERTICAL;
                        textView.setLayoutParams(lp);*/
                    	TextView textView = new TextView(getContext());
                        addView(textView);
                        mTextView = textView;
                    }
                    mTextView.setText(text);
                    mTextView.setVisibility(VISIBLE);
                } else if (mTextView != null) {
                    mTextView.setVisibility(GONE);
                    mTextView.setText(null);
                }

                if (mIconView != null) {
                    mIconView.setContentDescription(tab.getContentDescription());
                }
            }
        }

        public ActionBar.Tab getTab() {
            return mTab;
        }
    }

    private class TabAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mTabLayout.getChildCount();
        }

        @Override
        public Object getItem(int position) {
            return ((TabView) mTabLayout.getChildAt(position)).getTab();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = createTabView((ActionBar.Tab) getItem(position), true);
            } else {
                ((TabView) convertView).bindTab((ActionBar.Tab) getItem(position));
            }
            return convertView;
        }
    }

    private class TabClickListener implements OnClickListener {

        public void onClick(View view) {
            TabView tabView = (TabView) view;
            tabView.getTab().select();
            final int tabCount = mTabLayout.getChildCount();
            for (int i = 0; i < tabCount; i++) {
                final View child = mTabLayout.getChildAt(i);
                child.setSelected(child == view);
            }
        }
    }

}

