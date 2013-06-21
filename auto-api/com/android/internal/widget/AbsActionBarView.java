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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.807 -0400", hash_original_method = "824EFC2CD32C0974302E563583F4C727", hash_generated_method = "B2C361AB6BFCECCC7E25DD123A0D1413")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsActionBarView(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.807 -0400", hash_original_method = "F88AEDA5B22A6879EF9493B8EB4FB02B", hash_generated_method = "B52042C1943FD90A547006367178532C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsActionBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.807 -0400", hash_original_method = "FEA19398278F8B5B6B30417AB1F0C217", hash_generated_method = "0651E087AF51FB931CF06C860F70B19B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsActionBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.807 -0400", hash_original_method = "A484FDB326818C55D115F236B23DD701", hash_generated_method = "95851CC30BED7137DF5596E2DA3AC190")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.808 -0400", hash_original_method = "D4ADA7B8094B8C24856ACB21A2F3F966", hash_generated_method = "937D330481118D5B7DD00E21192738B9")
    @DSModeled(DSC.SAFE)
    public void setSplitActionBar(boolean split) {
        dsTaint.addTaint(split);
        // ---------- Original Method ----------
        //mSplitActionBar = split;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.808 -0400", hash_original_method = "68FCF08F15ACE8E4E864370710ECF8B3", hash_generated_method = "EA567A60B525FD906BE87F61D5928B8E")
    @DSModeled(DSC.SAFE)
    public void setSplitWhenNarrow(boolean splitWhenNarrow) {
        dsTaint.addTaint(splitWhenNarrow);
        // ---------- Original Method ----------
        //mSplitWhenNarrow = splitWhenNarrow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.808 -0400", hash_original_method = "156B54BA6D77F8AE13369D564149F7A2", hash_generated_method = "A0E70CE206C48549A3B746D88D253126")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentHeight(int height) {
        dsTaint.addTaint(height);
        requestLayout();
        // ---------- Original Method ----------
        //mContentHeight = height;
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.808 -0400", hash_original_method = "AB5D9AC478BBA1C6AA700AA7486698D8", hash_generated_method = "166E518321C68E56924FD30E2D0947E6")
    @DSModeled(DSC.SAFE)
    public int getContentHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mContentHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.808 -0400", hash_original_method = "3A09CE20A6543F8D9E8109683BD6E731", hash_generated_method = "190FB38E8E8CBB58BC0DD50197F2599B")
    @DSModeled(DSC.SAFE)
    public void setSplitView(ActionBarContainer splitView) {
        dsTaint.addTaint(splitView.dsTaint);
        // ---------- Original Method ----------
        //mSplitView = splitView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.809 -0400", hash_original_method = "460E6C1B19245DB35832909D719B5D88", hash_generated_method = "D5F702BE223BD01E964C978C702CEA45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAnimatedVisibility() {
        int var1E6D52E7F8591DCD1DF649DE21C8A049_765728762 = (getVisibility());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mVisibilityAnim != null) {
            //return mVisAnimListener.mFinalVisibility;
        //}
        //return getVisibility();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.809 -0400", hash_original_method = "2B465E314C114C54F186AF3EB05111D9", hash_generated_method = "72BB051DAC8FD5CC3FDC2E05DB314DA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void animateToVisibility(int visibility) {
        dsTaint.addTaint(visibility);
        {
            mVisibilityAnim.cancel();
        } //End block
        {
            {
                boolean varA0A81FC19EFCAB05136A17FC3377BBD3_868814935 = (getVisibility() != VISIBLE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.810 -0400", hash_original_method = "E3FDA7CA05E815669691C5C9F461C174", hash_generated_method = "21BB514EB1675480A15939F27FDB6A46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.810 -0400", hash_original_method = "6ECDD9C0917165AAFEF87E5E5EC8B474", hash_generated_method = "CF41AF2B020A5EA86818DC2E3A791CCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean showOverflowMenu() {
        {
            boolean varE02B1D76FDCE55870555B6FA38688077_107987547 = (mActionMenuPresenter.showOverflowMenu());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.showOverflowMenu();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.812 -0400", hash_original_method = "5B398819B085BB8DF5162E4F323954D1", hash_generated_method = "E3AE912ED409FEA2EAA66BE7B06B5A40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void postShowOverflowMenu() {
        post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.812 -0400", hash_original_method = "2C58279E0E2988284D33F5FBC58AA75D", hash_generated_method = "09EE0F572B2A69A085769CC77C52E2CA")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void run() {
                showOverflowMenu();
                // ---------- Original Method ----------
                //showOverflowMenu();
            }
});
        // ---------- Original Method ----------
        //post(new Runnable() {
            //public void run() {
                //showOverflowMenu();
            //}
        //});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.813 -0400", hash_original_method = "5D05982F33AF24415676BD0317DE2206", hash_generated_method = "465C4D730A8A9C67403F4F06F53BE9B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hideOverflowMenu() {
        {
            boolean var8BAEDFF24230E7488EEC35AEFACB6A9F_1017038308 = (mActionMenuPresenter.hideOverflowMenu());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.hideOverflowMenu();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.813 -0400", hash_original_method = "2F838D8CBDDC91E04D7A8F0F52ABF2C8", hash_generated_method = "54B4DC80E63E398FBA2A4B48E91DCF50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isOverflowMenuShowing() {
        {
            boolean varD524E4D1CE3A164128E687BA5686CD0D_467366431 = (mActionMenuPresenter.isOverflowMenuShowing());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.isOverflowMenuShowing();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.813 -0400", hash_original_method = "2716B287AFF500B52D105CE9F72467AF", hash_generated_method = "59D6CF340EF7A9D55130A2BF85C3C06D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isOverflowReserved() {
        boolean var7E43AD698358C7AA1146EFF37C1DC275_1825212047 = (mActionMenuPresenter != null && mActionMenuPresenter.isOverflowReserved());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActionMenuPresenter != null && mActionMenuPresenter.isOverflowReserved();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.813 -0400", hash_original_method = "E263C11D43E740E059E17F24B3046AB1", hash_generated_method = "321210DA712F127E641AD7F8F8C32179")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dismissPopupMenus() {
        {
            mActionMenuPresenter.dismissPopupMenus();
        } //End block
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //mActionMenuPresenter.dismissPopupMenus();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.814 -0400", hash_original_method = "A00B85663064A0063707CD21F6F98F93", hash_generated_method = "0E166291CC1F4F75E086B4E0435E3849")
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
        int varA3B4C2E4827FAB59460811D4731C37C3_1618390418 = (Math.max(0, availableWidth));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //child.measure(MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST),
                //childSpecHeight);
        //availableWidth -= child.getMeasuredWidth();
        //availableWidth -= spacing;
        //return Math.max(0, availableWidth);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.814 -0400", hash_original_method = "231762BB3E313BE1E16BACBDFDC62788", hash_generated_method = "6C2A1E3ADAB54E4D16A379446E120CDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.814 -0400", hash_original_method = "59F436BC9157B56F2D013CC5AD850863", hash_generated_method = "3E2E9B6BE72DB758CA63CF6009785CAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.814 -0400", hash_original_method = "75ECA60C9F4D40F51E44C573AEFCFF43", hash_generated_method = "75ECA60C9F4D40F51E44C573AEFCFF43")
                public VisibilityAnimListener ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.814 -0400", hash_original_method = "42B0250930D53F64D6DEADC73C3EFBBA", hash_generated_method = "0EB86CF95549717BDD874A96926731C1")
        @DSModeled(DSC.SAFE)
        public VisibilityAnimListener withFinalVisibility(int visibility) {
            dsTaint.addTaint(visibility);
            return (VisibilityAnimListener)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mFinalVisibility = visibility;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.815 -0400", hash_original_method = "9145E12DF11688F9DD8CB4C23A0F2F13", hash_generated_method = "02ED50A540B5E0EF7632FAFCF88A0B8C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.815 -0400", hash_original_method = "D1281410E67CFC6892364AC0D96A57F2", hash_generated_method = "4944F7C802DBB48146356382851A6953")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.815 -0400", hash_original_method = "2F84891C5ED8AB616225A7D641700DEA", hash_generated_method = "D78BD99B7FA096BC0F7A22E022644707")
        @DSModeled(DSC.SAFE)
        @Override
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            mCanceled = true;
            // ---------- Original Method ----------
            //mCanceled = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.815 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "2D32F9A43E5261B156C7705DA49965D8")
        @DSModeled(DSC.SAFE)
        @Override
        public void onAnimationRepeat(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    private static final TimeInterpolator sAlphaInterpolator = new DecelerateInterpolator();
    private static final int FADE_DURATION = 200;
}

