package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.ActionBar;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.internal.R;

public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.671 -0500", hash_original_field = "6C8728AD27930156AB8B4DB6BE524CA6", hash_generated_field = "8198E33AEA6A4E67CF498CFCEDA7ACFC")

    private static final String TAG = "ScrollingTabContainerView";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.695 -0500", hash_original_field = "D03B4416DFABD1105B6C0533A6AC7D12", hash_generated_field = "8547110952636D9B94C38943E41DDC94")

    private static final TimeInterpolator sAlphaInterpolator = new DecelerateInterpolator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.698 -0500", hash_original_field = "0217F77CCFC1C8AF37A39627A6C46858", hash_generated_field = "2297CD97C5AD861EDC516998785F45D4")

    private static final int FADE_DURATION = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.673 -0500", hash_original_field = "E682310941753B94BE1FECAC9286C6E9", hash_generated_field = "E682310941753B94BE1FECAC9286C6E9")

    Runnable mTabSelector;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.675 -0500", hash_original_field = "27F716F08128A8A34303C449A84D3A78", hash_generated_field = "9D65B8DF4295D2997A201C87527D1868")

    private TabClickListener mTabClickListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.677 -0500", hash_original_field = "117D0428E613CA4EEA398DB816A811C9", hash_generated_field = "E5144854D9186C0CFBAD4E1FE3ACCBAF")

    private LinearLayout mTabLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.679 -0500", hash_original_field = "A22C7A92FA962667DC46B5E04B2EE18D", hash_generated_field = "992DC55613E9C96C70980F7C6305042C")

    private Spinner mTabSpinner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.681 -0500", hash_original_field = "38A157EEF5FAA5B04C6812A030CB89D6", hash_generated_field = "F02107E932C3D4F526DFB20B4DC44818")

    private boolean mAllowCollapse;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.683 -0500", hash_original_field = "2536FBAA8D2459579C241F8EA3302AA1", hash_generated_field = "2536FBAA8D2459579C241F8EA3302AA1")

    int mMaxTabWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.686 -0500", hash_original_field = "6909FC61CEAFC4290968B35F30281B2B", hash_generated_field = "2B9929C05137BEFD1EEE8192DEC02202")

    private int mContentHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.688 -0500", hash_original_field = "3E29127999834DE794E6FF50E94B261E", hash_generated_field = "5FAA7FEF18B6FA6D1EC21FF900B235B4")

    private int mSelectedTabIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.690 -0500", hash_original_field = "45C08F827C667A6DCF7969318A42238E", hash_generated_field = "9B230B482D363407A6E2031086F40952")

    protected Animator mVisibilityAnim;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.693 -0500", hash_original_field = "90445405F42A5D20F9DDEB82807E1550", hash_generated_field = "2572558D73FCEA5CB5F54CEC528FD58F")

    protected final VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.700 -0500", hash_original_method = "B354C67837F2A6192494F63E2EFB003B", hash_generated_method = "AA9DC1D9C1C54B4AEA3061EC1CAF2A5B")
    
public ScrollingTabContainerView(Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);

        TypedArray a = getContext().obtainStyledAttributes(null, R.styleable.ActionBar,
                com.android.internal.R.attr.actionBarStyle, 0);
        setContentHeight(a.getLayoutDimension(R.styleable.ActionBar_height, 0));
        a.recycle();

        mTabLayout = createTabLayout();
        addView(mTabLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.704 -0500", hash_original_method = "3098621744ABB84E77F43010FB80D748", hash_generated_method = "36F513F07BEA02199A282BD56FF52C69")
    
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
     * Indicates whether this view is collapsed into a dropdown menu instead
     * of traditional tabs.
     * @return true if showing as a spinner
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.706 -0500", hash_original_method = "0C44DD211AEDE4F8875A759BF8E8E48B", hash_generated_method = "BC517FA24EACE7A695FB011A5D82F875")
    
private boolean isCollapsed() {
        return mTabSpinner != null && mTabSpinner.getParent() == this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.708 -0500", hash_original_method = "E654067D8A391E646F927D11468DA221", hash_generated_method = "39D180B8DA3868E9B3117926128CBE51")
    
public void setAllowCollapse(boolean allowCollapse) {
        mAllowCollapse = allowCollapse;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.711 -0500", hash_original_method = "002FC4053C0D51D3D52C5463A6463800", hash_generated_method = "6C79A6EEA90ADC9B06DEE18327CBAAF5")
    
private void performCollapse() {
        if (isCollapsed()) return;

        if (mTabSpinner == null) {
            mTabSpinner = createSpinner();
        }
        removeView(mTabLayout);
        addView(mTabSpinner, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        if (mTabSpinner.getAdapter() == null) {
            mTabSpinner.setAdapter(new TabAdapter());
        }
        if (mTabSelector != null) {
            removeCallbacks(mTabSelector);
            mTabSelector = null;
        }
        mTabSpinner.setSelection(mSelectedTabIndex);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.713 -0500", hash_original_method = "DC1833D7C81A29FFDE1BB4D9BF0A022D", hash_generated_method = "D7F01724781FE5EE1E73ED9A909B6EE5")
    
private boolean performExpand() {
        if (!isCollapsed()) return false;

        removeView(mTabSpinner);
        addView(mTabLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        setTabSelected(mTabSpinner.getSelectedItemPosition());
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.716 -0500", hash_original_method = "2880D1017429231FB4C783DE8155FB40", hash_generated_method = "C081D1D51388631D9C9F7FAFD14FDBE6")
    
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.718 -0500", hash_original_method = "2D264BA3FDE4BFC89C0D29CEF35AB5AF", hash_generated_method = "BA14FA1A5C9AF572E4D240F3CC7F6A66")
    
public void setContentHeight(int contentHeight) {
        mContentHeight = contentHeight;
        requestLayout();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.720 -0500", hash_original_method = "5C02AED63A2A4EB9B288612999968966", hash_generated_method = "D2FD5D597D780B8C8283B28DDE4BED5A")
    
private LinearLayout createTabLayout() {
        final LinearLayout tabLayout = new LinearLayout(getContext(), null,
                com.android.internal.R.attr.actionBarTabBarStyle);
        tabLayout.setMeasureWithLargestChildEnabled(true);
        tabLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        return tabLayout;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.722 -0500", hash_original_method = "37274689DF291E70B964F7E850308591", hash_generated_method = "9F61578C116F41856AAFF7C96E992116")
    
private Spinner createSpinner() {
        final Spinner spinner = new Spinner(getContext(), null,
                com.android.internal.R.attr.actionDropDownStyle);
        spinner.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        spinner.setOnItemSelectedListener(this);
        return spinner;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.725 -0500", hash_original_method = "DD246DFC5FD99F8FA7C3003D550B61F7", hash_generated_method = "15DF7AB3B90A39E5BEA9C9B7312B00FB")
    
@Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Action bar can change size on configuration changes.
        // Reread the desired height from the theme-specified style.
        TypedArray a = getContext().obtainStyledAttributes(null, R.styleable.ActionBar,
                com.android.internal.R.attr.actionBarStyle, 0);
        setContentHeight(a.getLayoutDimension(R.styleable.ActionBar_height, 0));
        a.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.727 -0500", hash_original_method = "69157A480990C0D905A38CA00057780E", hash_generated_method = "2D41B0CFC0BE40D0B063C090F536EE08")
    
public void animateToVisibility(int visibility) {
        if (mVisibilityAnim != null) {
            mVisibilityAnim.cancel();
        }
        if (visibility == VISIBLE) {
            if (getVisibility() != VISIBLE) {
                setAlpha(0);
            }
            ObjectAnimator anim = ObjectAnimator.ofFloat(this, "alpha", 1);
            anim.setDuration(FADE_DURATION);
            anim.setInterpolator(sAlphaInterpolator);

            anim.addListener(mVisAnimListener.withFinalVisibility(visibility));
            anim.start();
        } else {
            ObjectAnimator anim = ObjectAnimator.ofFloat(this, "alpha", 0);
            anim.setDuration(FADE_DURATION);
            anim.setInterpolator(sAlphaInterpolator);

            anim.addListener(mVisAnimListener.withFinalVisibility(visibility));
            anim.start();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.733 -0500", hash_original_method = "798975849EC8D4C022ED8EB3C4439FA8", hash_generated_method = "A4A568A7A57E71BBFDC61457E7EF9115")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.736 -0500", hash_original_method = "887CFA274A392DE8385671362C9964CB", hash_generated_method = "076F7E6432360CBE28CEA2E9E2C26749")
    
@Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mTabSelector != null) {
            // Re-post the selector we saved
            post(mTabSelector);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.738 -0500", hash_original_method = "18C292ABA374873141A21AD02D4712CF", hash_generated_method = "6DAB4E72961212723D7393FA0190E981")
    
@Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mTabSelector != null) {
            removeCallbacks(mTabSelector);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.741 -0500", hash_original_method = "450EFC0E420D351EC7204D6D5C8D9AC6", hash_generated_method = "95016CAE18263D4832DC97F50FC4E63A")
    
private TabView createTabView(ActionBar.Tab tab, boolean forAdapter) {
        final TabView tabView = new TabView(getContext(), tab, forAdapter);
        if (forAdapter) {
            tabView.setBackgroundDrawable(null);
            tabView.setLayoutParams(new ListView.LayoutParams(ListView.LayoutParams.MATCH_PARENT,
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.743 -0500", hash_original_method = "21975DD541C9968A5D84261D431559E1", hash_generated_method = "AB46EF11D453A74D7D17AB7D301EEB51")
    
public void addTab(ActionBar.Tab tab, boolean setSelected) {
        TabView tabView = createTabView(tab, false);
        mTabLayout.addView(tabView, new LinearLayout.LayoutParams(0,
                LayoutParams.MATCH_PARENT, 1));
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.745 -0500", hash_original_method = "120AD652FAF12AEC39493BA97DDC8DBA", hash_generated_method = "69CD9FFD578B1BA2E58E2F942F7DA040")
    
public void addTab(ActionBar.Tab tab, int position, boolean setSelected) {
        final TabView tabView = createTabView(tab, false);
        mTabLayout.addView(tabView, position, new LinearLayout.LayoutParams(
                0, LayoutParams.MATCH_PARENT, 1));
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.748 -0500", hash_original_method = "AB4E22DBFABD54435D3DD6BE48A7A755", hash_generated_method = "A5986D8AE63246102446BD7AE4D30F38")
    
public void updateTab(int position) {
        ((TabView) mTabLayout.getChildAt(position)).update();
        if (mTabSpinner != null) {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (mAllowCollapse) {
            requestLayout();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.751 -0500", hash_original_method = "F55D08535CE5AE8E892CFC88E40F0277", hash_generated_method = "538626902C18D997FAA00ECEFD6F65ED")
    
public void removeTabAt(int position) {
        mTabLayout.removeViewAt(position);
        if (mTabSpinner != null) {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (mAllowCollapse) {
            requestLayout();
        }
    }
    
    private class TabView extends LinearLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.761 -0500", hash_original_field = "69655022DB10ADBB9DD21379BEC78E47", hash_generated_field = "3557E0B9D4809295D85BAFD572E62004")

        private ActionBar.Tab mTab;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.763 -0500", hash_original_field = "49AF0A2A014C0E7F98E27CA30429A8B6", hash_generated_field = "B044D5C32398EDC8D922234EFA4F1DF3")

        private TextView mTextView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.765 -0500", hash_original_field = "069158469BB60C88A2C4A541C6AFB8D2", hash_generated_field = "411E3339296CF54457E86988903AF1A7")

        private ImageView mIconView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.768 -0500", hash_original_field = "ADD711F109703E2EAF61E2AD917F3FB6", hash_generated_field = "58BF9FCCDFB47B7346A31DF060279244")

        private View mCustomView;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.770 -0500", hash_original_method = "B5DB6118A5A739AD937742D1C44B643E", hash_generated_method = "7D0723E69D739CBC5B0972B055CB96F0")
        
public TabView(Context context, ActionBar.Tab tab, boolean forList) {
            super(context, null, com.android.internal.R.attr.actionBarTabStyle);
            mTab = tab;

            if (forList) {
                setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
            }

            update();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.772 -0500", hash_original_method = "F47DC88329E05996F10046ACC14BB8E5", hash_generated_method = "107E00B379586235703B74D5D05F6375")
        
public void bindTab(ActionBar.Tab tab) {
            mTab = tab;
            update();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.776 -0500", hash_original_method = "FFA211085DE297C0E0EC5011B4DE8B57", hash_generated_method = "3E323008B81095CD22F305E78A877C9A")
        
@Override
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);

            // Re-measure if we went beyond our maximum size.
            if (mMaxTabWidth > 0 && getMeasuredWidth() > mMaxTabWidth) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(mMaxTabWidth, MeasureSpec.EXACTLY),
                        heightMeasureSpec);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.779 -0500", hash_original_method = "0AA8F20782F60FCDEB51E2F40EEE8538", hash_generated_method = "10D69C8134D037B3FADDA7993F41BE6D")
        
public void update() {
            final ActionBar.Tab tab = mTab;
            final View custom = tab.getCustomView();
            if (custom != null) {
                final ViewParent customParent = custom.getParent();
                if (customParent != this) {
                    if (customParent != null) ((ViewGroup) customParent).removeView(custom);
                    addView(custom);
                }
                mCustomView = custom;
                if (mTextView != null) mTextView.setVisibility(GONE);
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
                        TextView textView = new TextView(getContext(), null,
                                com.android.internal.R.attr.actionBarTabTextStyle);
                        textView.setEllipsize(TruncateAt.END);
                        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,
                                LayoutParams.WRAP_CONTENT);
                        lp.gravity = Gravity.CENTER_VERTICAL;
                        textView.setLayoutParams(lp);
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.782 -0500", hash_original_method = "8ACD8C7DACBB258E07DA374214A46BC1", hash_generated_method = "87CB213503622823255F99AA8796B794")
        
public ActionBar.Tab getTab() {
            return mTab;
        }
        
    }
    
    private class TabAdapter extends BaseAdapter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.223 -0400", hash_original_method = "D47CBC6CCDC74B210F03E0CA569B23D5", hash_generated_method = "D47CBC6CCDC74B210F03E0CA569B23D5")
        public TabAdapter ()
        {
            //Synthesized constructor
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.788 -0500", hash_original_method = "8A8A2A6470BE340ED0660B0DF0493034", hash_generated_method = "6D18E00BFA47F61562A68013AC1E4863")
        
@Override
        public int getCount() {
            return mTabLayout.getChildCount();
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.791 -0500", hash_original_method = "A98679EF5D46D1EF9814D015704A8113", hash_generated_method = "8A104B02EFEC88B3B0789A63A0438694")
        
@Override
        public Object getItem(int position) {
            return ((TabView) mTabLayout.getChildAt(position)).getTab();
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.793 -0500", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "82702E9A3501EE6841B2C5A334199C16")
        
@Override
        public long getItemId(int position) {
            return position;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.796 -0500", hash_original_method = "C541E21433CF0B8E7E2EE0D1C892D4E4", hash_generated_method = "2C99808A42375E74B25A4F3F6A493DEE")
        
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.223 -0400", hash_original_method = "4AA29A9A1E8E979F0176DF66C5E11348", hash_generated_method = "4AA29A9A1E8E979F0176DF66C5E11348")
        public TabClickListener ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.801 -0500", hash_original_method = "024B6ED45DE6B4C8643F8BD12AD99CDA", hash_generated_method = "52641B658A520BDEB20BAAE85850478F")
        
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
    
    protected class VisibilityAnimListener implements Animator.AnimatorListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.806 -0500", hash_original_field = "88E0F93494857DA513393E07912CD8CE", hash_generated_field = "67D6DA73468F2D6E84B945FD38F1CC1D")

        private boolean mCanceled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.808 -0500", hash_original_field = "7E7DD7E9FF8079F20BDC4231CBA0A4C8", hash_generated_field = "5617DA9FA1009CD83DDE5A46F5134947")

        private int mFinalVisibility;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.224 -0400", hash_original_method = "80D34182BA082FA1C0AC7FE2CE12E2A6", hash_generated_method = "80D34182BA082FA1C0AC7FE2CE12E2A6")
        public VisibilityAnimListener ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.810 -0500", hash_original_method = "42B0250930D53F64D6DEADC73C3EFBBA", hash_generated_method = "0C5A5A53EA3B891E84240528FE5624C6")
        
public VisibilityAnimListener withFinalVisibility(int visibility) {
            mFinalVisibility = visibility;
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.812 -0500", hash_original_method = "9145E12DF11688F9DD8CB4C23A0F2F13", hash_generated_method = "D6A3B1E0285589475B43685B9D454296")
        
@Override
        public void onAnimationStart(Animator animation) {
            setVisibility(VISIBLE);
            mVisibilityAnim = animation;
            mCanceled = false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.815 -0500", hash_original_method = "FCD0A8E872EDB46A2BFC14B31FFA43CC", hash_generated_method = "98344E2581EBFD3916940E171D6CD41F")
        
@Override
        public void onAnimationEnd(Animator animation) {
            if (mCanceled) return;

            mVisibilityAnim = null;
            setVisibility(mFinalVisibility);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.817 -0500", hash_original_method = "2F84891C5ED8AB616225A7D641700DEA", hash_generated_method = "53F79C3A4E0C5892C226CF581D552D23")
        
@Override
        public void onAnimationCancel(Animator animation) {
            mCanceled = true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.821 -0500", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "10E9921CB3298EBACCE8F83DAB252AF1")
        
@Override
        public void onAnimationRepeat(Animator animation) {
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.753 -0500", hash_original_method = "505192EE2E755E624302670BB829212B", hash_generated_method = "C99ABC999ADB8D2BB225EA22C0506257")
    
public void removeAllTabs() {
        mTabLayout.removeAllViews();
        if (mTabSpinner != null) {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (mAllowCollapse) {
            requestLayout();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.756 -0500", hash_original_method = "1E807444FE245168D5D160AA45CB2236", hash_generated_method = "3B42A8D2AD95DEAF84141E00BC1C96E9")
    
@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TabView tabView = (TabView) view;
        tabView.getTab().select();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.758 -0500", hash_original_method = "ABAE53FB2582432DFD925A1EB74EEC53", hash_generated_method = "DE5FCEF2B194B9DFABC9F90EE24D1A02")
    
@Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}

