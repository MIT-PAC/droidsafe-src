package com.android.internal.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.649 -0400", hash_original_field = "4301CED8C5B8959C82A54CDC142B837C", hash_generated_field = "7B14B552DB0C79CBA209909A2B52BF74")

    protected ActionMenuView mMenuView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.649 -0400", hash_original_field = "F3A83DE351B723F2146B4C8617F8CB09", hash_generated_field = "B42779F216CC4528173E085A9F4DAD48")

    protected ActionMenuPresenter mActionMenuPresenter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.649 -0400", hash_original_field = "1D151831F4C7E78E301ECA2DDA3CAED0", hash_generated_field = "339FAE9C579EB8FD1618BEDA3B70551C")

    protected ActionBarContainer mSplitView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.649 -0400", hash_original_field = "01607C3A00087AF535527D0068A14C4D", hash_generated_field = "8F069B86042E1A0FB43FF36675E8AEC3")

    protected boolean mSplitActionBar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.649 -0400", hash_original_field = "C44265D4C8D825F29D7DA74BBD7F184C", hash_generated_field = "F626921AECC66B10EB0684795A9C5AA3")

    protected boolean mSplitWhenNarrow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.649 -0400", hash_original_field = "F40FB88A5310D2E8A8F0AC8C692796A5", hash_generated_field = "6227F76581B18D5818B4E51B94662C6C")

    protected int mContentHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.649 -0400", hash_original_field = "1CF5159AB7BA0B608B8FD842C6C652D4", hash_generated_field = "9B230B482D363407A6E2031086F40952")

    protected Animator mVisibilityAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.649 -0400", hash_original_field = "27A07A2C9917014FCD8B9D90F05A92EC", hash_generated_field = "2572558D73FCEA5CB5F54CEC528FD58F")

    protected final VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.650 -0400", hash_original_method = "824EFC2CD32C0974302E563583F4C727", hash_generated_method = "C31E479B2F20E6B9EB8FC80C3860DE2C")
    public  AbsActionBarView(Context context) {
        super(context);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.650 -0400", hash_original_method = "F88AEDA5B22A6879EF9493B8EB4FB02B", hash_generated_method = "6D934468F312505C408344289DBBF34F")
    public  AbsActionBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.651 -0400", hash_original_method = "FEA19398278F8B5B6B30417AB1F0C217", hash_generated_method = "E15E117507044CDA56F8EC8391E3D319")
    public  AbsActionBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.652 -0400", hash_original_method = "A484FDB326818C55D115F236B23DD701", hash_generated_method = "BE1BD9A4C78BAF1E5105C876F4348D08")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        
        super.onConfigurationChanged(newConfig);
        TypedArray a = getContext().obtainStyledAttributes(null, R.styleable.ActionBar,
                com.android.internal.R.attr.actionBarStyle, 0);
        setContentHeight(a.getLayoutDimension(R.styleable.ActionBar_height, 0));
        a.recycle();
        {
            setSplitActionBar(getContext().getResources().getBoolean(
                    com.android.internal.R.bool.split_action_bar_is_narrow));
        } 
        {
            mActionMenuPresenter.onConfigurationChanged(newConfig);
        } 
        addTaint(newConfig.getTaint());
        
        
        
                
        
        
        
            
                    
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.652 -0400", hash_original_method = "D4ADA7B8094B8C24856ACB21A2F3F966", hash_generated_method = "2774B4992A13F924AB31013753167D87")
    public void setSplitActionBar(boolean split) {
        mSplitActionBar = split;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.653 -0400", hash_original_method = "68FCF08F15ACE8E4E864370710ECF8B3", hash_generated_method = "EFC04914301CDD5999164CC812B627A5")
    public void setSplitWhenNarrow(boolean splitWhenNarrow) {
        mSplitWhenNarrow = splitWhenNarrow;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.653 -0400", hash_original_method = "156B54BA6D77F8AE13369D564149F7A2", hash_generated_method = "7D9711632D731186724CA7F4F4F3FAD8")
    public void setContentHeight(int height) {
        mContentHeight = height;
        requestLayout();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.654 -0400", hash_original_method = "AB5D9AC478BBA1C6AA700AA7486698D8", hash_generated_method = "120AC417F74EDDB1530ACB56CE8F4F85")
    public int getContentHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180382397 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180382397;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.654 -0400", hash_original_method = "3A09CE20A6543F8D9E8109683BD6E731", hash_generated_method = "1A26F6E86D020C5E2F245C84AB51C6BF")
    public void setSplitView(ActionBarContainer splitView) {
        mSplitView = splitView;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.655 -0400", hash_original_method = "460E6C1B19245DB35832909D719B5D88", hash_generated_method = "73BDD16A8BC7D6EEE3C0D08107F8E413")
    public int getAnimatedVisibility() {
        int var1E6D52E7F8591DCD1DF649DE21C8A049_1380397888 = (getVisibility());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896565805 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896565805;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.656 -0400", hash_original_method = "2B465E314C114C54F186AF3EB05111D9", hash_generated_method = "9957185B4462656D55B51286DB9D5814")
    public void animateToVisibility(int visibility) {
        {
            mVisibilityAnim.cancel();
        } 
        {
            {
                boolean varA0A81FC19EFCAB05136A17FC3377BBD3_1229472808 = (getVisibility() != VISIBLE);
                {
                    setAlpha(0);
                    {
                        mMenuView.setAlpha(0);
                    } 
                } 
            } 
            ObjectAnimator anim = ObjectAnimator.ofFloat(this, "alpha", 1);
            anim.setDuration(FADE_DURATION);
            anim.setInterpolator(sAlphaInterpolator);
            {
                AnimatorSet set = new AnimatorSet();
                ObjectAnimator splitAnim = ObjectAnimator.ofFloat(mMenuView, "alpha", 1);
                splitAnim.setDuration(FADE_DURATION);
                set.addListener(mVisAnimListener.withFinalVisibility(visibility));
                set.play(anim).with(splitAnim);
                set.start();
            } 
            {
                anim.addListener(mVisAnimListener.withFinalVisibility(visibility));
                anim.start();
            } 
        } 
        {
            ObjectAnimator anim = ObjectAnimator.ofFloat(this, "alpha", 0);
            anim.setDuration(FADE_DURATION);
            anim.setInterpolator(sAlphaInterpolator);
            {
                AnimatorSet set = new AnimatorSet();
                ObjectAnimator splitAnim = ObjectAnimator.ofFloat(mMenuView, "alpha", 0);
                splitAnim.setDuration(FADE_DURATION);
                set.addListener(mVisAnimListener.withFinalVisibility(visibility));
                set.play(anim).with(splitAnim);
                set.start();
            } 
            {
                anim.addListener(mVisAnimListener.withFinalVisibility(visibility));
                anim.start();
            } 
        } 
        addTaint(visibility);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.656 -0400", hash_original_method = "E3FDA7CA05E815669691C5C9F461C174", hash_generated_method = "73F0BC07F3D2C7A4210E9CF201F1CCD6")
    @Override
    public void setVisibility(int visibility) {
        {
            mVisibilityAnim.end();
        } 
        super.setVisibility(visibility);
        addTaint(visibility);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.657 -0400", hash_original_method = "6ECDD9C0917165AAFEF87E5E5EC8B474", hash_generated_method = "3CED5FC534C69E766E2CDA5472760996")
    public boolean showOverflowMenu() {
        {
            boolean varE02B1D76FDCE55870555B6FA38688077_1500908151 = (mActionMenuPresenter.showOverflowMenu());
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1116047886 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1116047886;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.658 -0400", hash_original_method = "5B398819B085BB8DF5162E4F323954D1", hash_generated_method = "15C61C3B3E97F424B83D4E55D5DE72E9")
    public void postShowOverflowMenu() {
        post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.658 -0400", hash_original_method = "2C58279E0E2988284D33F5FBC58AA75D", hash_generated_method = "09EE0F572B2A69A085769CC77C52E2CA")
            public void run() {
                showOverflowMenu();
                
                
            }
});
        
        
            
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.659 -0400", hash_original_method = "5D05982F33AF24415676BD0317DE2206", hash_generated_method = "E79CC35BB0D77FA9E21E5B395566DFCC")
    public boolean hideOverflowMenu() {
        {
            boolean var8BAEDFF24230E7488EEC35AEFACB6A9F_1914290229 = (mActionMenuPresenter.hideOverflowMenu());
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1275700249 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1275700249;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.659 -0400", hash_original_method = "2F838D8CBDDC91E04D7A8F0F52ABF2C8", hash_generated_method = "E339E12EC605CFDE2963601060F6F0A9")
    public boolean isOverflowMenuShowing() {
        {
            boolean varD524E4D1CE3A164128E687BA5686CD0D_1958550380 = (mActionMenuPresenter.isOverflowMenuShowing());
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_585977471 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_585977471;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.660 -0400", hash_original_method = "2716B287AFF500B52D105CE9F72467AF", hash_generated_method = "8AEC7CC421E98263188990DB80B33230")
    public boolean isOverflowReserved() {
        boolean var7E43AD698358C7AA1146EFF37C1DC275_943633081 = (mActionMenuPresenter != null && mActionMenuPresenter.isOverflowReserved());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1076269347 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1076269347;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.661 -0400", hash_original_method = "E263C11D43E740E059E17F24B3046AB1", hash_generated_method = "321210DA712F127E641AD7F8F8C32179")
    public void dismissPopupMenus() {
        {
            mActionMenuPresenter.dismissPopupMenus();
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.661 -0400", hash_original_method = "A00B85663064A0063707CD21F6F98F93", hash_generated_method = "B055142FAD451453413284B5A43A7869")
    protected int measureChildView(View child, int availableWidth, int childSpecHeight,
            int spacing) {
        child.measure(MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST),
                childSpecHeight);
        availableWidth -= child.getMeasuredWidth();
        availableWidth -= spacing;
        int varA3B4C2E4827FAB59460811D4731C37C3_1773253244 = (Math.max(0, availableWidth));
        addTaint(child.getTaint());
        addTaint(availableWidth);
        addTaint(childSpecHeight);
        addTaint(spacing);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1070993249 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1070993249;
        
        
                
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.662 -0400", hash_original_method = "231762BB3E313BE1E16BACBDFDC62788", hash_generated_method = "A50CD758024BABCCC986C77CB833002F")
    protected int positionChild(View child, int x, int y, int contentHeight) {
        int childWidth = child.getMeasuredWidth();
        int childHeight = child.getMeasuredHeight();
        int childTop = y + (contentHeight - childHeight) / 2;
        child.layout(x, childTop, x + childWidth, childTop + childHeight);
        addTaint(child.getTaint());
        addTaint(x);
        addTaint(y);
        addTaint(contentHeight);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960047719 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960047719;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.663 -0400", hash_original_method = "59F436BC9157B56F2D013CC5AD850863", hash_generated_method = "D35FFC20517F8AE166802182C82804A8")
    protected int positionChildInverse(View child, int x, int y, int contentHeight) {
        int childWidth = child.getMeasuredWidth();
        int childHeight = child.getMeasuredHeight();
        int childTop = y + (contentHeight - childHeight) / 2;
        child.layout(x - childWidth, childTop, x, childTop + childHeight);
        addTaint(child.getTaint());
        addTaint(x);
        addTaint(y);
        addTaint(contentHeight);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1621545546 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1621545546;
        
        
        
        
        
        
    }

    
    protected class VisibilityAnimListener implements Animator.AnimatorListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.663 -0400", hash_original_field = "D91530AF3D6C660AC2C0C8D4CBB2367B", hash_generated_field = "67D6DA73468F2D6E84B945FD38F1CC1D")

        private boolean mCanceled = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.663 -0400", hash_original_field = "270EA634CE9CE51A331284B9E8EB3832", hash_generated_field = "7E7DD7E9FF8079F20BDC4231CBA0A4C8")

        int mFinalVisibility;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.663 -0400", hash_original_method = "80D34182BA082FA1C0AC7FE2CE12E2A6", hash_generated_method = "80D34182BA082FA1C0AC7FE2CE12E2A6")
        public VisibilityAnimListener ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.663 -0400", hash_original_method = "42B0250930D53F64D6DEADC73C3EFBBA", hash_generated_method = "6E4D6226663E0438BB390032D0703E39")
        public VisibilityAnimListener withFinalVisibility(int visibility) {
            VisibilityAnimListener varB4EAC82CA7396A68D541C85D26508E83_1697385221 = null; 
            mFinalVisibility = visibility;
            varB4EAC82CA7396A68D541C85D26508E83_1697385221 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1697385221.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1697385221;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.664 -0400", hash_original_method = "9145E12DF11688F9DD8CB4C23A0F2F13", hash_generated_method = "B818DF791669294EDB0F112B9A238DEF")
        @Override
        public void onAnimationStart(Animator animation) {
            
            setVisibility(VISIBLE);
            mVisibilityAnim = animation;
            mCanceled = false;
            addTaint(animation.getTaint());
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.664 -0400", hash_original_method = "D1281410E67CFC6892364AC0D96A57F2", hash_generated_method = "294D800343603FD19A6AF523A05DF836")
        @Override
        public void onAnimationEnd(Animator animation) {
            
            mVisibilityAnim = null;
            setVisibility(mFinalVisibility);
            {
                mMenuView.setVisibility(mFinalVisibility);
            } 
            addTaint(animation.getTaint());
            
            
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.664 -0400", hash_original_method = "2F84891C5ED8AB616225A7D641700DEA", hash_generated_method = "66692DF1E254D3C3C92CC85749BF5C5B")
        @Override
        public void onAnimationCancel(Animator animation) {
            
            mCanceled = true;
            addTaint(animation.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.664 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "4BE2C3EAC3B10B8BD5CE86F0E3077935")
        @Override
        public void onAnimationRepeat(Animator animation) {
            
            addTaint(animation.getTaint());
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.665 -0400", hash_original_field = "58EA75425C7F0D76C382950FFD0E66A6", hash_generated_field = "8547110952636D9B94C38943E41DDC94")

    private static final TimeInterpolator sAlphaInterpolator = new DecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.665 -0400", hash_original_field = "5427C149FA3D3269A4036F1A93D514B4", hash_generated_field = "2297CD97C5AD861EDC516998785F45D4")

    private static final int FADE_DURATION = 200;
}

