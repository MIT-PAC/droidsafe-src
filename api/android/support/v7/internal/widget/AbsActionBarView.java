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
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v7.appcompat.R;
import android.support.v7.internal.view.menu.ActionMenuPresenter;
import android.support.v7.internal.view.menu.ActionMenuView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

abstract class AbsActionBarView extends ViewGroup {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.604 -0400", hash_original_field = "0217F77CCFC1C8AF37A39627A6C46858", hash_generated_field = "2297CD97C5AD861EDC516998785F45D4")

    private static final int FADE_DURATION = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.578 -0400", hash_original_field = "C5D24CAE9D499645E662279CCDBCBFED", hash_generated_field = "7B14B552DB0C79CBA209909A2B52BF74")

    protected ActionMenuView mMenuView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.582 -0400", hash_original_field = "83149C518D179EC10AC8E811139579F8", hash_generated_field = "B42779F216CC4528173E085A9F4DAD48")

    protected ActionMenuPresenter mActionMenuPresenter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.587 -0400", hash_original_field = "697914BCC588648A228AE86640E2671D", hash_generated_field = "339FAE9C579EB8FD1618BEDA3B70551C")

    protected ActionBarContainer mSplitView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.591 -0400", hash_original_field = "E9BF37F76DC250F2CA829FFF57793375", hash_generated_field = "8F069B86042E1A0FB43FF36675E8AEC3")

    protected boolean mSplitActionBar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.595 -0400", hash_original_field = "1024CDB3A263DF3959DEC11D52CF91B0", hash_generated_field = "F626921AECC66B10EB0684795A9C5AA3")

    protected boolean mSplitWhenNarrow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.599 -0400", hash_original_field = "6909FC61CEAFC4290968B35F30281B2B", hash_generated_field = "6227F76581B18D5818B4E51B94662C6C")

    protected int mContentHeight;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.607 -0400", hash_original_method = "824EFC2CD32C0974302E563583F4C727", hash_generated_method = "824EFC2CD32C0974302E563583F4C727")
    
AbsActionBarView(Context context) {
        super(context);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.613 -0400", hash_original_method = "F88AEDA5B22A6879EF9493B8EB4FB02B", hash_generated_method = "F88AEDA5B22A6879EF9493B8EB4FB02B")
    
AbsActionBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.618 -0400", hash_original_method = "FEA19398278F8B5B6B30417AB1F0C217", hash_generated_method = "FEA19398278F8B5B6B30417AB1F0C217")
    
AbsActionBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.623 -0400", hash_original_method = "1A1BBCCA059A99CBC66249D9DA235B79", hash_generated_method = "7CEE7AF1652FB016E09F81F9A59DDFC8")
    
@Override
    protected void onConfigurationChanged(Configuration newConfig) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(newConfig);
        }

        // Action bar can change size on configuration changes.
        // Reread the desired height from the theme-specified style.
        TypedArray a = getContext().obtainStyledAttributes(null, R.styleable.ActionBar,
                R.attr.actionBarStyle, 0);
        setContentHeight(a.getLayoutDimension(R.styleable.ActionBar_height, 0));
        a.recycle();
        if (mSplitWhenNarrow) {
            setSplitActionBar(getContext().getResources().getBoolean(
                    R.bool.abc_split_action_bar_is_narrow));
        }
        if (mActionMenuPresenter != null) {
            mActionMenuPresenter.onConfigurationChanged(newConfig);
        }
    }

    /**
     * Sets whether the bar should be split right now, no questions asked.
     *
     * @param split true if the bar should split
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.627 -0400", hash_original_method = "D4ADA7B8094B8C24856ACB21A2F3F966", hash_generated_method = "4BA69C6EE77FE9FC0D1D5536DF5BAF8C")
    
public void setSplitActionBar(boolean split) {
        mSplitActionBar = split;
    }

    /**
     * Sets whether the bar should split if we enter a narrow screen configuration.
     *
     * @param splitWhenNarrow true if the bar should check to split after a config change
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.631 -0400", hash_original_method = "68FCF08F15ACE8E4E864370710ECF8B3", hash_generated_method = "AF771BA8D31DBD339E36F25DAF8F147D")
    
public void setSplitWhenNarrow(boolean splitWhenNarrow) {
        mSplitWhenNarrow = splitWhenNarrow;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.636 -0400", hash_original_method = "156B54BA6D77F8AE13369D564149F7A2", hash_generated_method = "E9094B3C011966F113F287066F202892")
    
public void setContentHeight(int height) {
        mContentHeight = height;
        requestLayout();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.640 -0400", hash_original_method = "AB5D9AC478BBA1C6AA700AA7486698D8", hash_generated_method = "ACB213AC2A4D5DA4279E6F97171C16BE")
    
public int getContentHeight() {
        return mContentHeight;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.643 -0400", hash_original_method = "3A09CE20A6543F8D9E8109683BD6E731", hash_generated_method = "BA5262CB7EA2CA9638A747DED1B59B29")
    
public void setSplitView(ActionBarContainer splitView) {
        mSplitView = splitView;
    }

    /**
     * @return Current visibility or if animating, the visibility being animated to.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.647 -0400", hash_original_method = "A8CA78C6ABB7B5A3D6C0FBCA5E336AA5", hash_generated_method = "3389D78C03C1B737548806066D1C8490")
    
public int getAnimatedVisibility() {
        return getVisibility();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.653 -0400", hash_original_method = "17D776E73D87655ED57B92C2D1D0CE5F", hash_generated_method = "0C76B6F9AE0D03FAF083B95112C9C325")
    
public void animateToVisibility(int visibility) {
        clearAnimation();

        if (visibility != getVisibility()) {
            Animation anim = AnimationUtils.loadAnimation(getContext(),
                    visibility == View.VISIBLE ? R.anim.abc_fade_in : R.anim.abc_fade_out);

            startAnimation(anim);
            setVisibility(visibility);

            if (mSplitView != null && mMenuView != null) {
                mMenuView.startAnimation(anim);
                mMenuView.setVisibility(visibility);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.658 -0400", hash_original_method = "18C5CF9B467563351141F1A59DD43E2B", hash_generated_method = "1C0B4C3A62E55CFE077D7893575C4585")
    
@Override
    public void setVisibility(int visibility) {
        if (visibility != getVisibility()) {
            super.setVisibility(visibility);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.663 -0400", hash_original_method = "6ECDD9C0917165AAFEF87E5E5EC8B474", hash_generated_method = "9DC48792B6C46D132A9B94061617D16B")
    
public boolean showOverflowMenu() {
        if (mActionMenuPresenter != null) {
            return mActionMenuPresenter.showOverflowMenu();
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.672 -0400", hash_original_method = "5B398819B085BB8DF5162E4F323954D1", hash_generated_method = "0C68F83D49777FE3D90EBF89CED1A4BA")
    
public void postShowOverflowMenu() {
        post(new Runnable() {
            @DSSafe(DSCat.SAFE_LIST)
        public void run() {
                showOverflowMenu();
            }
        });
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.676 -0400", hash_original_method = "5D05982F33AF24415676BD0317DE2206", hash_generated_method = "CEE194F262DB6BBBE36DFE61AF2E5A04")
    
public boolean hideOverflowMenu() {
        if (mActionMenuPresenter != null) {
            return mActionMenuPresenter.hideOverflowMenu();
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.680 -0400", hash_original_method = "2F838D8CBDDC91E04D7A8F0F52ABF2C8", hash_generated_method = "54E5E33F107A17CC64613D9753739950")
    
public boolean isOverflowMenuShowing() {
        if (mActionMenuPresenter != null) {
            return mActionMenuPresenter.isOverflowMenuShowing();
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.684 -0400", hash_original_method = "2716B287AFF500B52D105CE9F72467AF", hash_generated_method = "0EEDB35B60AD080D5517260D839948B2")
    
public boolean isOverflowReserved() {
        return mActionMenuPresenter != null && mActionMenuPresenter.isOverflowReserved();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.689 -0400", hash_original_method = "E263C11D43E740E059E17F24B3046AB1", hash_generated_method = "172A0960A66C36409D2DEED435273569")
    
public void dismissPopupMenus() {
        if (mActionMenuPresenter != null) {
            mActionMenuPresenter.dismissPopupMenus();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.693 -0400", hash_original_method = "A00B85663064A0063707CD21F6F98F93", hash_generated_method = "B02F190771DB45F974B15E7379A2A70C")
    
protected int measureChildView(View child, int availableWidth, int childSpecHeight,
            int spacing) {
        child.measure(MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST),
                childSpecHeight);

        availableWidth -= child.getMeasuredWidth();
        availableWidth -= spacing;

        return Math.max(0, availableWidth);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.698 -0400", hash_original_method = "231762BB3E313BE1E16BACBDFDC62788", hash_generated_method = "D8FF977D463F276AF981A8E1C35C5585")
    
protected int positionChild(View child, int x, int y, int contentHeight) {
        int childWidth = child.getMeasuredWidth();
        int childHeight = child.getMeasuredHeight();
        int childTop = y + (contentHeight - childHeight) / 2;

        child.layout(x, childTop, x + childWidth, childTop + childHeight);

        return childWidth;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:03.703 -0400", hash_original_method = "59F436BC9157B56F2D013CC5AD850863", hash_generated_method = "67C029CB2EFB280035BB61D1A790378F")
    
protected int positionChildInverse(View child, int x, int y, int contentHeight) {
        int childWidth = child.getMeasuredWidth();
        int childHeight = child.getMeasuredHeight();
        int childTop = y + (contentHeight - childHeight) / 2;

        child.layout(x - childWidth, childTop, x, childTop + childHeight);

        return childWidth;
    }

}
