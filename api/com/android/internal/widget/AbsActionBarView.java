package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

import com.android.internal.R;
import com.android.internal.view.menu.ActionMenuPresenter;
import com.android.internal.view.menu.ActionMenuView;

public abstract class AbsActionBarView extends ViewGroup {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.235 -0500", hash_original_field = "D03B4416DFABD1105B6C0533A6AC7D12", hash_generated_field = "8547110952636D9B94C38943E41DDC94")

    private static final TimeInterpolator sAlphaInterpolator = new DecelerateInterpolator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.238 -0500", hash_original_field = "0217F77CCFC1C8AF37A39627A6C46858", hash_generated_field = "2297CD97C5AD861EDC516998785F45D4")

    private static final int FADE_DURATION = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.216 -0500", hash_original_field = "C5D24CAE9D499645E662279CCDBCBFED", hash_generated_field = "7B14B552DB0C79CBA209909A2B52BF74")

    protected ActionMenuView mMenuView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.218 -0500", hash_original_field = "83149C518D179EC10AC8E811139579F8", hash_generated_field = "B42779F216CC4528173E085A9F4DAD48")

    protected ActionMenuPresenter mActionMenuPresenter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.221 -0500", hash_original_field = "697914BCC588648A228AE86640E2671D", hash_generated_field = "339FAE9C579EB8FD1618BEDA3B70551C")

    protected ActionBarContainer mSplitView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.223 -0500", hash_original_field = "E9BF37F76DC250F2CA829FFF57793375", hash_generated_field = "8F069B86042E1A0FB43FF36675E8AEC3")

    protected boolean mSplitActionBar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.225 -0500", hash_original_field = "1024CDB3A263DF3959DEC11D52CF91B0", hash_generated_field = "F626921AECC66B10EB0684795A9C5AA3")

    protected boolean mSplitWhenNarrow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.228 -0500", hash_original_field = "6909FC61CEAFC4290968B35F30281B2B", hash_generated_field = "6227F76581B18D5818B4E51B94662C6C")

    protected int mContentHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.230 -0500", hash_original_field = "45C08F827C667A6DCF7969318A42238E", hash_generated_field = "9B230B482D363407A6E2031086F40952")

    protected Animator mVisibilityAnim;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.233 -0500", hash_original_field = "90445405F42A5D20F9DDEB82807E1550", hash_generated_field = "2572558D73FCEA5CB5F54CEC528FD58F")

    protected final VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.240 -0500", hash_original_method = "824EFC2CD32C0974302E563583F4C727", hash_generated_method = "3CCCEBF4ABA5EC8D15C23485280BD3BF")
    
public AbsActionBarView(Context context) {
        super(context);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.243 -0500", hash_original_method = "F88AEDA5B22A6879EF9493B8EB4FB02B", hash_generated_method = "A9F1032592146F82C510D3EE54EA9D47")
    
public AbsActionBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.245 -0500", hash_original_method = "FEA19398278F8B5B6B30417AB1F0C217", hash_generated_method = "FA969A6C27B14E3031A9932BF9A98274")
    
public AbsActionBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.248 -0500", hash_original_method = "A484FDB326818C55D115F236B23DD701", hash_generated_method = "4F30AF12109A412482EFF81C971F0798")
    
@Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Action bar can change size on configuration changes.
        // Reread the desired height from the theme-specified style.
        TypedArray a = getContext().obtainStyledAttributes(null, R.styleable.ActionBar,
                com.android.internal.R.attr.actionBarStyle, 0);
        setContentHeight(a.getLayoutDimension(R.styleable.ActionBar_height, 0));
        a.recycle();
        if (mSplitWhenNarrow) {
            setSplitActionBar(getContext().getResources().getBoolean(
                    com.android.internal.R.bool.split_action_bar_is_narrow));
        }
        if (mActionMenuPresenter != null) {
            mActionMenuPresenter.onConfigurationChanged(newConfig);
        }
    }

    /**
     * Sets whether the bar should be split right now, no questions asked.
     * @param split true if the bar should split
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.250 -0500", hash_original_method = "D4ADA7B8094B8C24856ACB21A2F3F966", hash_generated_method = "4BA69C6EE77FE9FC0D1D5536DF5BAF8C")
    
public void setSplitActionBar(boolean split) {
        mSplitActionBar = split;
    }

    /**
     * Sets whether the bar should split if we enter a narrow screen configuration.
     * @param splitWhenNarrow true if the bar should check to split after a config change
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.252 -0500", hash_original_method = "68FCF08F15ACE8E4E864370710ECF8B3", hash_generated_method = "AF771BA8D31DBD339E36F25DAF8F147D")
    
public void setSplitWhenNarrow(boolean splitWhenNarrow) {
        mSplitWhenNarrow = splitWhenNarrow;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.254 -0500", hash_original_method = "156B54BA6D77F8AE13369D564149F7A2", hash_generated_method = "E9094B3C011966F113F287066F202892")
    
public void setContentHeight(int height) {
        mContentHeight = height;
        requestLayout();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.257 -0500", hash_original_method = "AB5D9AC478BBA1C6AA700AA7486698D8", hash_generated_method = "ACB213AC2A4D5DA4279E6F97171C16BE")
    
public int getContentHeight() {
        return mContentHeight;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.259 -0500", hash_original_method = "3A09CE20A6543F8D9E8109683BD6E731", hash_generated_method = "BA5262CB7EA2CA9638A747DED1B59B29")
    
public void setSplitView(ActionBarContainer splitView) {
        mSplitView = splitView;
    }

    /**
     * @return Current visibility or if animating, the visibility being animated to.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.261 -0500", hash_original_method = "460E6C1B19245DB35832909D719B5D88", hash_generated_method = "C8B9BA432328D87A81F412D3E44DA7C8")
    
public int getAnimatedVisibility() {
        if (mVisibilityAnim != null) {
            return mVisAnimListener.mFinalVisibility;
        }
        return getVisibility();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.264 -0500", hash_original_method = "2B465E314C114C54F186AF3EB05111D9", hash_generated_method = "76EE35E605A332C81A8582137B40B9F7")
    
public void animateToVisibility(int visibility) {
        if (mVisibilityAnim != null) {
            mVisibilityAnim.cancel();
        }
        if (visibility == VISIBLE) {
            if (getVisibility() != VISIBLE) {
                setAlpha(0);
                if (mSplitView != null && mMenuView != null) {
                    mMenuView.setAlpha(0);
                }
            }
            ObjectAnimator anim = ObjectAnimator.ofFloat(this, "alpha", 1);
            anim.setDuration(FADE_DURATION);
            anim.setInterpolator(sAlphaInterpolator);
            if (mSplitView != null && mMenuView != null) {
                AnimatorSet set = new AnimatorSet();
                ObjectAnimator splitAnim = ObjectAnimator.ofFloat(mMenuView, "alpha", 1);
                splitAnim.setDuration(FADE_DURATION);
                set.addListener(mVisAnimListener.withFinalVisibility(visibility));
                set.play(anim).with(splitAnim);
                set.start();
            } else {
                anim.addListener(mVisAnimListener.withFinalVisibility(visibility));
                anim.start();
            }
        } else {
            ObjectAnimator anim = ObjectAnimator.ofFloat(this, "alpha", 0);
            anim.setDuration(FADE_DURATION);
            anim.setInterpolator(sAlphaInterpolator);
            if (mSplitView != null && mMenuView != null) {
                AnimatorSet set = new AnimatorSet();
                ObjectAnimator splitAnim = ObjectAnimator.ofFloat(mMenuView, "alpha", 0);
                splitAnim.setDuration(FADE_DURATION);
                set.addListener(mVisAnimListener.withFinalVisibility(visibility));
                set.play(anim).with(splitAnim);
                set.start();
            } else {
                anim.addListener(mVisAnimListener.withFinalVisibility(visibility));
                anim.start();
            }
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.267 -0500", hash_original_method = "E3FDA7CA05E815669691C5C9F461C174", hash_generated_method = "7507F82342AEE21992A70367745836D1")
    
@Override
    public void setVisibility(int visibility) {
        if (mVisibilityAnim != null) {
            mVisibilityAnim.end();
        }
        super.setVisibility(visibility);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.269 -0500", hash_original_method = "6ECDD9C0917165AAFEF87E5E5EC8B474", hash_generated_method = "9DC48792B6C46D132A9B94061617D16B")
    
public boolean showOverflowMenu() {
        if (mActionMenuPresenter != null) {
            return mActionMenuPresenter.showOverflowMenu();
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.275 -0500", hash_original_method = "5B398819B085BB8DF5162E4F323954D1", hash_generated_method = "0C68F83D49777FE3D90EBF89CED1A4BA")
    
public void postShowOverflowMenu() {
        post(new Runnable() {
            public void run() {
                showOverflowMenu();
            }
        });
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.277 -0500", hash_original_method = "5D05982F33AF24415676BD0317DE2206", hash_generated_method = "CEE194F262DB6BBBE36DFE61AF2E5A04")
    
public boolean hideOverflowMenu() {
        if (mActionMenuPresenter != null) {
            return mActionMenuPresenter.hideOverflowMenu();
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.279 -0500", hash_original_method = "2F838D8CBDDC91E04D7A8F0F52ABF2C8", hash_generated_method = "54E5E33F107A17CC64613D9753739950")
    
public boolean isOverflowMenuShowing() {
        if (mActionMenuPresenter != null) {
            return mActionMenuPresenter.isOverflowMenuShowing();
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.281 -0500", hash_original_method = "2716B287AFF500B52D105CE9F72467AF", hash_generated_method = "0EEDB35B60AD080D5517260D839948B2")
    
public boolean isOverflowReserved() {
        return mActionMenuPresenter != null && mActionMenuPresenter.isOverflowReserved();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.283 -0500", hash_original_method = "E263C11D43E740E059E17F24B3046AB1", hash_generated_method = "172A0960A66C36409D2DEED435273569")
    
public void dismissPopupMenus() {
        if (mActionMenuPresenter != null) {
            mActionMenuPresenter.dismissPopupMenus();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.286 -0500", hash_original_method = "A00B85663064A0063707CD21F6F98F93", hash_generated_method = "B02F190771DB45F974B15E7379A2A70C")
    
protected int measureChildView(View child, int availableWidth, int childSpecHeight,
            int spacing) {
        child.measure(MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST),
                childSpecHeight);

        availableWidth -= child.getMeasuredWidth();
        availableWidth -= spacing;

        return Math.max(0, availableWidth);
    }
    
    protected class VisibilityAnimListener implements Animator.AnimatorListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.293 -0500", hash_original_field = "88E0F93494857DA513393E07912CD8CE", hash_generated_field = "67D6DA73468F2D6E84B945FD38F1CC1D")

        private boolean mCanceled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.295 -0500", hash_original_field = "7E7DD7E9FF8079F20BDC4231CBA0A4C8", hash_generated_field = "7E7DD7E9FF8079F20BDC4231CBA0A4C8")

        int mFinalVisibility;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.645 -0400", hash_original_method = "80D34182BA082FA1C0AC7FE2CE12E2A6", hash_generated_method = "80D34182BA082FA1C0AC7FE2CE12E2A6")
        public VisibilityAnimListener ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.298 -0500", hash_original_method = "42B0250930D53F64D6DEADC73C3EFBBA", hash_generated_method = "0C5A5A53EA3B891E84240528FE5624C6")
        
public VisibilityAnimListener withFinalVisibility(int visibility) {
            mFinalVisibility = visibility;
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.300 -0500", hash_original_method = "9145E12DF11688F9DD8CB4C23A0F2F13", hash_generated_method = "D6A3B1E0285589475B43685B9D454296")
        
@Override
        public void onAnimationStart(Animator animation) {
            setVisibility(VISIBLE);
            mVisibilityAnim = animation;
            mCanceled = false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.304 -0500", hash_original_method = "D1281410E67CFC6892364AC0D96A57F2", hash_generated_method = "5F7DA4760C0614FC8588DA36752D8B55")
        
@Override
        public void onAnimationEnd(Animator animation) {
            if (mCanceled) return;

            mVisibilityAnim = null;
            setVisibility(mFinalVisibility);
            if (mSplitView != null && mMenuView != null) {
                mMenuView.setVisibility(mFinalVisibility);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.306 -0500", hash_original_method = "2F84891C5ED8AB616225A7D641700DEA", hash_generated_method = "53F79C3A4E0C5892C226CF581D552D23")
        
@Override
        public void onAnimationCancel(Animator animation) {
            mCanceled = true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.308 -0500", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "10E9921CB3298EBACCE8F83DAB252AF1")
        
@Override
        public void onAnimationRepeat(Animator animation) {
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.288 -0500", hash_original_method = "231762BB3E313BE1E16BACBDFDC62788", hash_generated_method = "D8FF977D463F276AF981A8E1C35C5585")
    
protected int positionChild(View child, int x, int y, int contentHeight) {
        int childWidth = child.getMeasuredWidth();
        int childHeight = child.getMeasuredHeight();
        int childTop = y + (contentHeight - childHeight) / 2;

        child.layout(x, childTop, x + childWidth, childTop + childHeight);

        return childWidth;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.291 -0500", hash_original_method = "59F436BC9157B56F2D013CC5AD850863", hash_generated_method = "67C029CB2EFB280035BB61D1A790378F")
    
protected int positionChildInverse(View child, int x, int y, int contentHeight) {
        int childWidth = child.getMeasuredWidth();
        int childHeight = child.getMeasuredHeight();
        int childTop = y + (contentHeight - childHeight) / 2;

        child.layout(x - childWidth, childTop, x, childTop + childHeight);

        return childWidth;
    }
}

