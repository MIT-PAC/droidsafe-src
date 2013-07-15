package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.575 -0400", hash_original_field = "4301CED8C5B8959C82A54CDC142B837C", hash_generated_field = "7B14B552DB0C79CBA209909A2B52BF74")

    protected ActionMenuView mMenuView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.575 -0400", hash_original_field = "F3A83DE351B723F2146B4C8617F8CB09", hash_generated_field = "B42779F216CC4528173E085A9F4DAD48")

    protected ActionMenuPresenter mActionMenuPresenter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.575 -0400", hash_original_field = "1D151831F4C7E78E301ECA2DDA3CAED0", hash_generated_field = "339FAE9C579EB8FD1618BEDA3B70551C")

    protected ActionBarContainer mSplitView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.575 -0400", hash_original_field = "01607C3A00087AF535527D0068A14C4D", hash_generated_field = "8F069B86042E1A0FB43FF36675E8AEC3")

    protected boolean mSplitActionBar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.575 -0400", hash_original_field = "C44265D4C8D825F29D7DA74BBD7F184C", hash_generated_field = "F626921AECC66B10EB0684795A9C5AA3")

    protected boolean mSplitWhenNarrow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.575 -0400", hash_original_field = "F40FB88A5310D2E8A8F0AC8C692796A5", hash_generated_field = "6227F76581B18D5818B4E51B94662C6C")

    protected int mContentHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.575 -0400", hash_original_field = "1CF5159AB7BA0B608B8FD842C6C652D4", hash_generated_field = "9B230B482D363407A6E2031086F40952")

    protected Animator mVisibilityAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.575 -0400", hash_original_field = "27A07A2C9917014FCD8B9D90F05A92EC", hash_generated_field = "2572558D73FCEA5CB5F54CEC528FD58F")

    protected final VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.576 -0400", hash_original_method = "824EFC2CD32C0974302E563583F4C727", hash_generated_method = "C31E479B2F20E6B9EB8FC80C3860DE2C")
    public  AbsActionBarView(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.576 -0400", hash_original_method = "F88AEDA5B22A6879EF9493B8EB4FB02B", hash_generated_method = "AC9A01860C700EB25FF49AAA1CD5681D")
    public  AbsActionBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.576 -0400", hash_original_method = "FEA19398278F8B5B6B30417AB1F0C217", hash_generated_method = "36DEA6CD6EAB18721A345683EAFF7B4E")
    public  AbsActionBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.577 -0400", hash_original_method = "A484FDB326818C55D115F236B23DD701", hash_generated_method = "8421EFCC81A17DB87F0ECC5198A416D9")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
        super.onConfigurationChanged(newConfig);
        TypedArray a = getContext().obtainStyledAttributes(null, R.styleable.ActionBar,
                com.android.internal.R.attr.actionBarStyle, 0);
        setContentHeight(a.getLayoutDimension(R.styleable.ActionBar_height, 0));
        a.recycle();
    if(mSplitWhenNarrow)        
        {
            setSplitActionBar(getContext().getResources().getBoolean(
                    com.android.internal.R.bool.split_action_bar_is_narrow));
        } //End block
    if(mActionMenuPresenter != null)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.577 -0400", hash_original_method = "D4ADA7B8094B8C24856ACB21A2F3F966", hash_generated_method = "2774B4992A13F924AB31013753167D87")
    public void setSplitActionBar(boolean split) {
        mSplitActionBar = split;
        // ---------- Original Method ----------
        //mSplitActionBar = split;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.578 -0400", hash_original_method = "68FCF08F15ACE8E4E864370710ECF8B3", hash_generated_method = "EFC04914301CDD5999164CC812B627A5")
    public void setSplitWhenNarrow(boolean splitWhenNarrow) {
        mSplitWhenNarrow = splitWhenNarrow;
        // ---------- Original Method ----------
        //mSplitWhenNarrow = splitWhenNarrow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.578 -0400", hash_original_method = "156B54BA6D77F8AE13369D564149F7A2", hash_generated_method = "7D9711632D731186724CA7F4F4F3FAD8")
    public void setContentHeight(int height) {
        mContentHeight = height;
        requestLayout();
        // ---------- Original Method ----------
        //mContentHeight = height;
        //requestLayout();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.579 -0400", hash_original_method = "AB5D9AC478BBA1C6AA700AA7486698D8", hash_generated_method = "42DA680F456B0688C3D54DCDF8F89351")
    public int getContentHeight() {
        int varF40FB88A5310D2E8A8F0AC8C692796A5_588320704 = (mContentHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1719716381 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1719716381;
        // ---------- Original Method ----------
        //return mContentHeight;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.580 -0400", hash_original_method = "3A09CE20A6543F8D9E8109683BD6E731", hash_generated_method = "1A26F6E86D020C5E2F245C84AB51C6BF")
    public void setSplitView(ActionBarContainer splitView) {
        mSplitView = splitView;
        // ---------- Original Method ----------
        //mSplitView = splitView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.580 -0400", hash_original_method = "460E6C1B19245DB35832909D719B5D88", hash_generated_method = "76F83FA1471ED06D6E3BAB0F5657F041")
    public int getAnimatedVisibility() {
    if(mVisibilityAnim != null)        
        {
            int var118A2AD99A701291A6244621E05EAB9A_1409158368 = (mVisAnimListener.mFinalVisibility);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_535697569 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_535697569;
        } //End block
        int var166FFC3829FC1035C266CC4C4D713A8C_153832016 = (getVisibility());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1687170732 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1687170732;
        // ---------- Original Method ----------
        //if (mVisibilityAnim != null) {
            //return mVisAnimListener.mFinalVisibility;
        //}
        //return getVisibility();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.582 -0400", hash_original_method = "2B465E314C114C54F186AF3EB05111D9", hash_generated_method = "69252CE66765CF476EB83EF9077D6FBF")
    public void animateToVisibility(int visibility) {
        addTaint(visibility);
    if(mVisibilityAnim != null)        
        {
            mVisibilityAnim.cancel();
        } //End block
    if(visibility == VISIBLE)        
        {
    if(getVisibility() != VISIBLE)            
            {
                setAlpha(0);
    if(mSplitView != null && mMenuView != null)                
                {
                    mMenuView.setAlpha(0);
                } //End block
            } //End block
            ObjectAnimator anim = ObjectAnimator.ofFloat(this, "alpha", 1);
            anim.setDuration(FADE_DURATION);
            anim.setInterpolator(sAlphaInterpolator);
    if(mSplitView != null && mMenuView != null)            
            {
                AnimatorSet set = new AnimatorSet();
                ObjectAnimator splitAnim = ObjectAnimator.ofFloat(mMenuView, "alpha", 1);
                splitAnim.setDuration(FADE_DURATION);
                set.addListener(mVisAnimListener.withFinalVisibility(visibility));
                set.play(anim).with(splitAnim);
                set.start();
            } //End block
            else
            {
                anim.addListener(mVisAnimListener.withFinalVisibility(visibility));
                anim.start();
            } //End block
        } //End block
        else
        {
            ObjectAnimator anim = ObjectAnimator.ofFloat(this, "alpha", 0);
            anim.setDuration(FADE_DURATION);
            anim.setInterpolator(sAlphaInterpolator);
    if(mSplitView != null && mMenuView != null)            
            {
                AnimatorSet set = new AnimatorSet();
                ObjectAnimator splitAnim = ObjectAnimator.ofFloat(mMenuView, "alpha", 0);
                splitAnim.setDuration(FADE_DURATION);
                set.addListener(mVisAnimListener.withFinalVisibility(visibility));
                set.play(anim).with(splitAnim);
                set.start();
            } //End block
            else
            {
                anim.addListener(mVisAnimListener.withFinalVisibility(visibility));
                anim.start();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.584 -0400", hash_original_method = "E3FDA7CA05E815669691C5C9F461C174", hash_generated_method = "F348BE301D04D3937F0F827432AC70BD")
    @Override
    public void setVisibility(int visibility) {
        addTaint(visibility);
    if(mVisibilityAnim != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.585 -0400", hash_original_method = "6ECDD9C0917165AAFEF87E5E5EC8B474", hash_generated_method = "270A32156819CCAF5A0E430BDDB4F5FE")
    public boolean showOverflowMenu() {
    if(mActionMenuPresenter != null)        
        {
            boolean varBFC2B6A46330B4A2C0833A7CFFCAD0E6_1384120773 = (mActionMenuPresenter.showOverflowMenu());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1216206056 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1216206056;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1810635502 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2146119169 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2146119169;
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.showOverflowMenu();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.586 -0400", hash_original_method = "5B398819B085BB8DF5162E4F323954D1", hash_generated_method = "18ADCEAB37E78D4C7BBDE0A95608FFF4")
    public void postShowOverflowMenu() {
        post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.585 -0400", hash_original_method = "2C58279E0E2988284D33F5FBC58AA75D", hash_generated_method = "09EE0F572B2A69A085769CC77C52E2CA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.586 -0400", hash_original_method = "5D05982F33AF24415676BD0317DE2206", hash_generated_method = "4A6DE22F214B2A501CA2283DF56F145C")
    public boolean hideOverflowMenu() {
    if(mActionMenuPresenter != null)        
        {
            boolean var5C0D979EB15917E48FF5FEE985A01770_3740901 = (mActionMenuPresenter.hideOverflowMenu());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1230550249 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1230550249;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1055327249 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_510764726 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_510764726;
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.hideOverflowMenu();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.586 -0400", hash_original_method = "2F838D8CBDDC91E04D7A8F0F52ABF2C8", hash_generated_method = "A8467D201A63E12DF2826D35B13CBB4D")
    public boolean isOverflowMenuShowing() {
    if(mActionMenuPresenter != null)        
        {
            boolean varAED510BBF3E16C2B886300C9FBDF94E1_964794281 = (mActionMenuPresenter.isOverflowMenuShowing());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1123345473 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1123345473;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_90942491 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_67018834 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_67018834;
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.isOverflowMenuShowing();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.587 -0400", hash_original_method = "2716B287AFF500B52D105CE9F72467AF", hash_generated_method = "8819015502838CDB4CFCC2F49E2434A4")
    public boolean isOverflowReserved() {
        boolean var0407F9259A8F0659777734FF7C947718_1479526133 = (mActionMenuPresenter != null && mActionMenuPresenter.isOverflowReserved());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_311118864 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_311118864;
        // ---------- Original Method ----------
        //return mActionMenuPresenter != null && mActionMenuPresenter.isOverflowReserved();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.587 -0400", hash_original_method = "E263C11D43E740E059E17F24B3046AB1", hash_generated_method = "0C8CC31443E33B0A3D343683DEADE683")
    public void dismissPopupMenus() {
    if(mActionMenuPresenter != null)        
        {
            mActionMenuPresenter.dismissPopupMenus();
        } //End block
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //mActionMenuPresenter.dismissPopupMenus();
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.587 -0400", hash_original_method = "A00B85663064A0063707CD21F6F98F93", hash_generated_method = "A9B63D44F434F295592D101DB5E0AB77")
    protected int measureChildView(View child, int availableWidth, int childSpecHeight,
            int spacing) {
        addTaint(spacing);
        addTaint(childSpecHeight);
        addTaint(availableWidth);
        addTaint(child.getTaint());
        child.measure(MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST),
                childSpecHeight);
        availableWidth -= child.getMeasuredWidth();
        availableWidth -= spacing;
        int var5685DA2162D26409CBA45AC55FBEF80A_825597845 = (Math.max(0, availableWidth));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_13820721 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_13820721;
        // ---------- Original Method ----------
        //child.measure(MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST),
                //childSpecHeight);
        //availableWidth -= child.getMeasuredWidth();
        //availableWidth -= spacing;
        //return Math.max(0, availableWidth);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.588 -0400", hash_original_method = "231762BB3E313BE1E16BACBDFDC62788", hash_generated_method = "A41FDE3E1276B6D5937307EDABA9E325")
    protected int positionChild(View child, int x, int y, int contentHeight) {
        addTaint(contentHeight);
        addTaint(y);
        addTaint(x);
        addTaint(child.getTaint());
        int childWidth = child.getMeasuredWidth();
        int childHeight = child.getMeasuredHeight();
        int childTop = y + (contentHeight - childHeight) / 2;
        child.layout(x, childTop, x + childWidth, childTop + childHeight);
        int varF224CB0AD2B63E1D0A5F37B6E86F1183_478312984 = (childWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1881696122 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1881696122;
        // ---------- Original Method ----------
        //int childWidth = child.getMeasuredWidth();
        //int childHeight = child.getMeasuredHeight();
        //int childTop = y + (contentHeight - childHeight) / 2;
        //child.layout(x, childTop, x + childWidth, childTop + childHeight);
        //return childWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.588 -0400", hash_original_method = "59F436BC9157B56F2D013CC5AD850863", hash_generated_method = "B8D36B601332B6131600E182858DD47C")
    protected int positionChildInverse(View child, int x, int y, int contentHeight) {
        addTaint(contentHeight);
        addTaint(y);
        addTaint(x);
        addTaint(child.getTaint());
        int childWidth = child.getMeasuredWidth();
        int childHeight = child.getMeasuredHeight();
        int childTop = y + (contentHeight - childHeight) / 2;
        child.layout(x - childWidth, childTop, x, childTop + childHeight);
        int varF224CB0AD2B63E1D0A5F37B6E86F1183_177143670 = (childWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1108462653 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1108462653;
        // ---------- Original Method ----------
        //int childWidth = child.getMeasuredWidth();
        //int childHeight = child.getMeasuredHeight();
        //int childTop = y + (contentHeight - childHeight) / 2;
        //child.layout(x - childWidth, childTop, x, childTop + childHeight);
        //return childWidth;
    }

    
    protected class VisibilityAnimListener implements Animator.AnimatorListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.588 -0400", hash_original_field = "D91530AF3D6C660AC2C0C8D4CBB2367B", hash_generated_field = "67D6DA73468F2D6E84B945FD38F1CC1D")

        private boolean mCanceled = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.588 -0400", hash_original_field = "270EA634CE9CE51A331284B9E8EB3832", hash_generated_field = "7E7DD7E9FF8079F20BDC4231CBA0A4C8")

        int mFinalVisibility;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.588 -0400", hash_original_method = "80D34182BA082FA1C0AC7FE2CE12E2A6", hash_generated_method = "80D34182BA082FA1C0AC7FE2CE12E2A6")
        public VisibilityAnimListener ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.589 -0400", hash_original_method = "42B0250930D53F64D6DEADC73C3EFBBA", hash_generated_method = "8228809A759C1FB306F4F325FED8D50D")
        public VisibilityAnimListener withFinalVisibility(int visibility) {
            mFinalVisibility = visibility;
VisibilityAnimListener var72A74007B2BE62B849F475C7BDA4658B_58454927 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_58454927.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_58454927;
            // ---------- Original Method ----------
            //mFinalVisibility = visibility;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.589 -0400", hash_original_method = "9145E12DF11688F9DD8CB4C23A0F2F13", hash_generated_method = "43A419CBA987813FF6A97459EB9F4822")
        @Override
        public void onAnimationStart(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            setVisibility(VISIBLE);
            mVisibilityAnim = animation;
            mCanceled = false;
            // ---------- Original Method ----------
            //setVisibility(VISIBLE);
            //mVisibilityAnim = animation;
            //mCanceled = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.589 -0400", hash_original_method = "D1281410E67CFC6892364AC0D96A57F2", hash_generated_method = "4A086F0917800DBFFB372EEFD955EEDC")
        @Override
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
    if(mCanceled)            
            return;
            mVisibilityAnim = null;
            setVisibility(mFinalVisibility);
    if(mSplitView != null && mMenuView != null)            
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.590 -0400", hash_original_method = "2F84891C5ED8AB616225A7D641700DEA", hash_generated_method = "8F11757114E12F8DD42F47845FC47878")
        @Override
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            mCanceled = true;
            // ---------- Original Method ----------
            //mCanceled = true;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.590 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "4BE2C3EAC3B10B8BD5CE86F0E3077935")
        @Override
        public void onAnimationRepeat(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.590 -0400", hash_original_field = "58EA75425C7F0D76C382950FFD0E66A6", hash_generated_field = "8547110952636D9B94C38943E41DDC94")

    private static final TimeInterpolator sAlphaInterpolator = new DecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.590 -0400", hash_original_field = "5427C149FA3D3269A4036F1A93D514B4", hash_generated_field = "2297CD97C5AD861EDC516998785F45D4")

    private static final int FADE_DURATION = 200;
}

