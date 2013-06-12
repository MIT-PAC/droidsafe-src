package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.R;
import com.android.internal.view.menu.ActionMenuPresenter;
import com.android.internal.view.menu.ActionMenuView;
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

public abstract class AbsActionBarView extends ViewGroup {
    protected ActionMenuView mMenuView;
    protected ActionMenuPresenter mActionMenuPresenter;
    protected ActionBarContainer mSplitView;
    protected boolean mSplitActionBar;
    protected boolean mSplitWhenNarrow;
    protected int mContentHeight;
    protected Animator mVisibilityAnim;
    protected VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();
    private static TimeInterpolator sAlphaInterpolator = new DecelerateInterpolator();
    private static int FADE_DURATION = 200;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:21.847 -0400", hash_original_method = "824EFC2CD32C0974302E563583F4C727", hash_generated_method = "44919A502157509044EF517F34FDDE44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsActionBarView(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:21.853 -0400", hash_original_method = "F88AEDA5B22A6879EF9493B8EB4FB02B", hash_generated_method = "46EEC77617DE115506CCEE9868291827")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsActionBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:21.862 -0400", hash_original_method = "FEA19398278F8B5B6B30417AB1F0C217", hash_generated_method = "E5FEF127FE4427AF68F87D5AA6F08BB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsActionBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:21.899 -0400", hash_original_method = "A484FDB326818C55D115F236B23DD701", hash_generated_method = "2AB1CA530344BCDD70D1E0B9B56324AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newConfig.dsTaint);
        super.onConfigurationChanged(newConfig);
        TypedArray a;
        a = getContext().obtainStyledAttributes(null, R.styleable.ActionBar,
                com.android.internal.R.attr.actionBarStyle, 0);
        setContentHeight(a.getLayoutDimension(R.styleable.ActionBar_height, 0));
        a.recycle();
        {
            setSplitActionBar(getContext().getResources().getBoolean(
                    com.android.internal.R.bool.split_action_bar_is_narrow));
        } //End block
        {
            mActionMenuPresenter.onConfigurationChanged(newConfig);
        } //End block
        // ---------- Original Method ----------
        //super.onConfigurationChanged(newConfig);
        //TypedArray a = getContext().obtainStyledAttributes(null, R.styleable.ActionBar,
                //com.android.internal.R.attr.actionBarStyle, 0);
        //setContentHeight(a.getLayoutDimension(R.styleable.ActionBar_height, 0));
        //a.recycle();
        //if (mSplitWhenNarrow) {
            //setSplitActionBar(getContext().getResources().getBoolean(
                    //com.android.internal.R.bool.split_action_bar_is_narrow));
        //}
        //if (mActionMenuPresenter != null) {
            //mActionMenuPresenter.onConfigurationChanged(newConfig);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:21.915 -0400", hash_original_method = "D4ADA7B8094B8C24856ACB21A2F3F966", hash_generated_method = "1E62A42EECD3072F02C07EF6E34843E1")
    @DSModeled(DSC.SAFE)
    public void setSplitActionBar(boolean split) {
        dsTaint.addTaint(split);
        // ---------- Original Method ----------
        //mSplitActionBar = split;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:21.932 -0400", hash_original_method = "68FCF08F15ACE8E4E864370710ECF8B3", hash_generated_method = "EA8E6B61A8B372D97197F627A0537F20")
    @DSModeled(DSC.SAFE)
    public void setSplitWhenNarrow(boolean splitWhenNarrow) {
        dsTaint.addTaint(splitWhenNarrow);
        // ---------- Original Method ----------
        //mSplitWhenNarrow = splitWhenNarrow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:21.941 -0400", hash_original_method = "156B54BA6D77F8AE13369D564149F7A2", hash_generated_method = "BE3204641ECBC75AEF01511F7CBBE906")
    @DSModeled(DSC.SAFE)
    public void setContentHeight(int height) {
        dsTaint.addTaint(height);
        requestLayout();
        // ---------- Original Method ----------
        //mContentHeight = height;
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:21.949 -0400", hash_original_method = "AB5D9AC478BBA1C6AA700AA7486698D8", hash_generated_method = "48856CB87BC6398AA3DC5D92AE52F4C1")
    @DSModeled(DSC.SAFE)
    public int getContentHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mContentHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:21.956 -0400", hash_original_method = "3A09CE20A6543F8D9E8109683BD6E731", hash_generated_method = "D64EFB802DDF777C7500CF8F6B86F0A4")
    @DSModeled(DSC.SAFE)
    public void setSplitView(ActionBarContainer splitView) {
        dsTaint.addTaint(splitView.dsTaint);
        // ---------- Original Method ----------
        //mSplitView = splitView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:21.966 -0400", hash_original_method = "460E6C1B19245DB35832909D719B5D88", hash_generated_method = "7A4B7100C90A3C8606623EC2C75DF36A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAnimatedVisibility() {
        int var1E6D52E7F8591DCD1DF649DE21C8A049_790289861 = (getVisibility());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mVisibilityAnim != null) {
            //return mVisAnimListener.mFinalVisibility;
        //}
        //return getVisibility();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:22.023 -0400", hash_original_method = "2B465E314C114C54F186AF3EB05111D9", hash_generated_method = "98F2A7C325733A74A42D7747DC34EE1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void animateToVisibility(int visibility) {
        dsTaint.addTaint(visibility);
        {
            mVisibilityAnim.cancel();
        } //End block
        {
            {
                boolean varA0A81FC19EFCAB05136A17FC3377BBD3_1423830294 = (getVisibility() != VISIBLE);
                {
                    setAlpha(0);
                    {
                        mMenuView.setAlpha(0);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            ObjectAnimator anim;
            anim = ObjectAnimator.ofFloat(this, "alpha", 1);
            anim.setDuration(FADE_DURATION);
            anim.setInterpolator(sAlphaInterpolator);
            {
                AnimatorSet set;
                set = new AnimatorSet();
                ObjectAnimator splitAnim;
                splitAnim = ObjectAnimator.ofFloat(mMenuView, "alpha", 1);
                splitAnim.setDuration(FADE_DURATION);
                set.addListener(mVisAnimListener.withFinalVisibility(visibility));
                set.play(anim).with(splitAnim);
                set.start();
            } //End block
            {
                anim.addListener(mVisAnimListener.withFinalVisibility(visibility));
                anim.start();
            } //End block
        } //End block
        {
            ObjectAnimator anim;
            anim = ObjectAnimator.ofFloat(this, "alpha", 0);
            anim.setDuration(FADE_DURATION);
            anim.setInterpolator(sAlphaInterpolator);
            {
                AnimatorSet set;
                set = new AnimatorSet();
                ObjectAnimator splitAnim;
                splitAnim = ObjectAnimator.ofFloat(mMenuView, "alpha", 0);
                splitAnim.setDuration(FADE_DURATION);
                set.addListener(mVisAnimListener.withFinalVisibility(visibility));
                set.play(anim).with(splitAnim);
                set.start();
            } //End block
            {
                anim.addListener(mVisAnimListener.withFinalVisibility(visibility));
                anim.start();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:22.057 -0400", hash_original_method = "E3FDA7CA05E815669691C5C9F461C174", hash_generated_method = "1C06B0DFAD70ECCC8C41341222559FEB")
    @DSModeled(DSC.SAFE)
    @Override
    public void setVisibility(int visibility) {
        dsTaint.addTaint(visibility);
        {
            mVisibilityAnim.end();
        } //End block
        super.setVisibility(visibility);
        // ---------- Original Method ----------
        //if (mVisibilityAnim != null) {
            //mVisibilityAnim.end();
        //}
        //super.setVisibility(visibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:22.069 -0400", hash_original_method = "6ECDD9C0917165AAFEF87E5E5EC8B474", hash_generated_method = "5698BA6BB916EA9E18A3A25218DA03D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean showOverflowMenu() {
        {
            boolean varE02B1D76FDCE55870555B6FA38688077_1370417292 = (mActionMenuPresenter.showOverflowMenu());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.showOverflowMenu();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:22.076 -0400", hash_original_method = "5B398819B085BB8DF5162E4F323954D1", hash_generated_method = "E6E333A3C2CEDC143DC69610734B5A42")
    @DSModeled(DSC.SAFE)
    public void postShowOverflowMenu() {
        post(new Runnable() {
            public void run() {
                showOverflowMenu();
            }
        });
        // ---------- Original Method ----------
        //post(new Runnable() {
            //public void run() {
                //showOverflowMenu();
            //}
        //});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:22.086 -0400", hash_original_method = "5D05982F33AF24415676BD0317DE2206", hash_generated_method = "61AD8CC2A316A32E8ABD71FF33DB9888")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hideOverflowMenu() {
        {
            boolean var8BAEDFF24230E7488EEC35AEFACB6A9F_1122784518 = (mActionMenuPresenter.hideOverflowMenu());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.hideOverflowMenu();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:22.101 -0400", hash_original_method = "2F838D8CBDDC91E04D7A8F0F52ABF2C8", hash_generated_method = "D2DFBE4E6B5E0C783FF0DE76A6B3902D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isOverflowMenuShowing() {
        {
            boolean varD524E4D1CE3A164128E687BA5686CD0D_1947644429 = (mActionMenuPresenter.isOverflowMenuShowing());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.isOverflowMenuShowing();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:22.110 -0400", hash_original_method = "2716B287AFF500B52D105CE9F72467AF", hash_generated_method = "DE0125250BCA07A42A0B10C980A3B182")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isOverflowReserved() {
        boolean var7E43AD698358C7AA1146EFF37C1DC275_1025924560 = (mActionMenuPresenter != null && mActionMenuPresenter.isOverflowReserved());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActionMenuPresenter != null && mActionMenuPresenter.isOverflowReserved();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:22.117 -0400", hash_original_method = "E263C11D43E740E059E17F24B3046AB1", hash_generated_method = "E39BE1FC8ED89364CBD5C770DAD6C417")
    @DSModeled(DSC.SAFE)
    public void dismissPopupMenus() {
        {
            mActionMenuPresenter.dismissPopupMenus();
        } //End block
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //mActionMenuPresenter.dismissPopupMenus();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:22.129 -0400", hash_original_method = "A00B85663064A0063707CD21F6F98F93", hash_generated_method = "BD3AE1398AEE5966375AA3B7252EF79D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int measureChildView(View child, int availableWidth, int childSpecHeight,
            int spacing) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(availableWidth);
        dsTaint.addTaint(childSpecHeight);
        dsTaint.addTaint(spacing);
        child.measure(MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST),
                childSpecHeight);
        availableWidth -= child.getMeasuredWidth();
        availableWidth -= spacing;
        int varA3B4C2E4827FAB59460811D4731C37C3_114949519 = (Math.max(0, availableWidth));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //child.measure(MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST),
                //childSpecHeight);
        //availableWidth -= child.getMeasuredWidth();
        //availableWidth -= spacing;
        //return Math.max(0, availableWidth);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:22.141 -0400", hash_original_method = "231762BB3E313BE1E16BACBDFDC62788", hash_generated_method = "E6BE2A4ACC8D5CA80CFBE8E30DA19992")
    @DSModeled(DSC.SAFE)
    protected int positionChild(View child, int x, int y, int contentHeight) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(contentHeight);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        int childWidth;
        childWidth = child.getMeasuredWidth();
        int childHeight;
        childHeight = child.getMeasuredHeight();
        int childTop;
        childTop = y + (contentHeight - childHeight) / 2;
        child.layout(x, childTop, x + childWidth, childTop + childHeight);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int childWidth = child.getMeasuredWidth();
        //int childHeight = child.getMeasuredHeight();
        //int childTop = y + (contentHeight - childHeight) / 2;
        //child.layout(x, childTop, x + childWidth, childTop + childHeight);
        //return childWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:22.154 -0400", hash_original_method = "59F436BC9157B56F2D013CC5AD850863", hash_generated_method = "1BA5BD1A71AED684C7E08A5865984567")
    @DSModeled(DSC.SAFE)
    protected int positionChildInverse(View child, int x, int y, int contentHeight) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(contentHeight);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        int childWidth;
        childWidth = child.getMeasuredWidth();
        int childHeight;
        childHeight = child.getMeasuredHeight();
        int childTop;
        childTop = y + (contentHeight - childHeight) / 2;
        child.layout(x - childWidth, childTop, x, childTop + childHeight);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int childWidth = child.getMeasuredWidth();
        //int childHeight = child.getMeasuredHeight();
        //int childTop = y + (contentHeight - childHeight) / 2;
        //child.layout(x - childWidth, childTop, x, childTop + childHeight);
        //return childWidth;
    }

    
    protected class VisibilityAnimListener implements Animator.AnimatorListener {
        private boolean mCanceled = false;
        int mFinalVisibility;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:22.186 -0400", hash_original_method = "42B0250930D53F64D6DEADC73C3EFBBA", hash_generated_method = "1280A3E9D7144E6C91453BA1499F1CC3")
        @DSModeled(DSC.SAFE)
        public VisibilityAnimListener withFinalVisibility(int visibility) {
            dsTaint.addTaint(visibility);
            return (VisibilityAnimListener)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mFinalVisibility = visibility;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:22.195 -0400", hash_original_method = "9145E12DF11688F9DD8CB4C23A0F2F13", hash_generated_method = "BD00BCAE2AB5EB8ACE46991AFDCC5093")
        @DSModeled(DSC.SAFE)
        @Override
        public void onAnimationStart(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            setVisibility(VISIBLE);
            mVisibilityAnim = animation;
            mCanceled = false;
            // ---------- Original Method ----------
            //setVisibility(VISIBLE);
            //mVisibilityAnim = animation;
            //mCanceled = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:22.206 -0400", hash_original_method = "D1281410E67CFC6892364AC0D96A57F2", hash_generated_method = "94A5C11C2D0BD25F225F6E5D44DE1511")
        @DSModeled(DSC.SAFE)
        @Override
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            mVisibilityAnim = null;
            setVisibility(mFinalVisibility);
            {
                mMenuView.setVisibility(mFinalVisibility);
            } //End block
            // ---------- Original Method ----------
            //if (mCanceled) return;
            //mVisibilityAnim = null;
            //setVisibility(mFinalVisibility);
            //if (mSplitView != null && mMenuView != null) {
                //mMenuView.setVisibility(mFinalVisibility);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:22.212 -0400", hash_original_method = "2F84891C5ED8AB616225A7D641700DEA", hash_generated_method = "87338A0AE17B72148398A1A0FE6DD53B")
        @DSModeled(DSC.SAFE)
        @Override
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            mCanceled = true;
            // ---------- Original Method ----------
            //mCanceled = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:04:22.217 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "75FF296FC60604A343A82AB9CB8690F0")
        @DSModeled(DSC.SAFE)
        @Override
        public void onAnimationRepeat(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
}


