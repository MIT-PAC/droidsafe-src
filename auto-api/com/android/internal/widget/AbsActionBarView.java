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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.864 -0400", hash_original_field = "4301CED8C5B8959C82A54CDC142B837C", hash_generated_field = "7B14B552DB0C79CBA209909A2B52BF74")

    protected ActionMenuView mMenuView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.864 -0400", hash_original_field = "F3A83DE351B723F2146B4C8617F8CB09", hash_generated_field = "B42779F216CC4528173E085A9F4DAD48")

    protected ActionMenuPresenter mActionMenuPresenter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.864 -0400", hash_original_field = "1D151831F4C7E78E301ECA2DDA3CAED0", hash_generated_field = "339FAE9C579EB8FD1618BEDA3B70551C")

    protected ActionBarContainer mSplitView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.864 -0400", hash_original_field = "01607C3A00087AF535527D0068A14C4D", hash_generated_field = "8F069B86042E1A0FB43FF36675E8AEC3")

    protected boolean mSplitActionBar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.864 -0400", hash_original_field = "C44265D4C8D825F29D7DA74BBD7F184C", hash_generated_field = "F626921AECC66B10EB0684795A9C5AA3")

    protected boolean mSplitWhenNarrow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.864 -0400", hash_original_field = "F40FB88A5310D2E8A8F0AC8C692796A5", hash_generated_field = "6227F76581B18D5818B4E51B94662C6C")

    protected int mContentHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.864 -0400", hash_original_field = "1CF5159AB7BA0B608B8FD842C6C652D4", hash_generated_field = "9B230B482D363407A6E2031086F40952")

    protected Animator mVisibilityAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.864 -0400", hash_original_field = "27A07A2C9917014FCD8B9D90F05A92EC", hash_generated_field = "086FDC026EF1BFDEA1109A9AB2C496E1")

    protected VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.876 -0400", hash_original_method = "824EFC2CD32C0974302E563583F4C727", hash_generated_method = "C31E479B2F20E6B9EB8FC80C3860DE2C")
    public  AbsActionBarView(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.877 -0400", hash_original_method = "F88AEDA5B22A6879EF9493B8EB4FB02B", hash_generated_method = "6D934468F312505C408344289DBBF34F")
    public  AbsActionBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.877 -0400", hash_original_method = "FEA19398278F8B5B6B30417AB1F0C217", hash_generated_method = "E15E117507044CDA56F8EC8391E3D319")
    public  AbsActionBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.878 -0400", hash_original_method = "A484FDB326818C55D115F236B23DD701", hash_generated_method = "3EA4929A531FCE7EB709374531CBEF78")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        addTaint(newConfig.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.878 -0400", hash_original_method = "D4ADA7B8094B8C24856ACB21A2F3F966", hash_generated_method = "2774B4992A13F924AB31013753167D87")
    public void setSplitActionBar(boolean split) {
        mSplitActionBar = split;
        // ---------- Original Method ----------
        //mSplitActionBar = split;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.878 -0400", hash_original_method = "68FCF08F15ACE8E4E864370710ECF8B3", hash_generated_method = "EFC04914301CDD5999164CC812B627A5")
    public void setSplitWhenNarrow(boolean splitWhenNarrow) {
        mSplitWhenNarrow = splitWhenNarrow;
        // ---------- Original Method ----------
        //mSplitWhenNarrow = splitWhenNarrow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.878 -0400", hash_original_method = "156B54BA6D77F8AE13369D564149F7A2", hash_generated_method = "7D9711632D731186724CA7F4F4F3FAD8")
    public void setContentHeight(int height) {
        mContentHeight = height;
        requestLayout();
        // ---------- Original Method ----------
        //mContentHeight = height;
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.879 -0400", hash_original_method = "AB5D9AC478BBA1C6AA700AA7486698D8", hash_generated_method = "99D02DE9F6BE4442B5BFB7028149EE33")
    public int getContentHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_986448419 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_986448419;
        // ---------- Original Method ----------
        //return mContentHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.879 -0400", hash_original_method = "3A09CE20A6543F8D9E8109683BD6E731", hash_generated_method = "1A26F6E86D020C5E2F245C84AB51C6BF")
    public void setSplitView(ActionBarContainer splitView) {
        mSplitView = splitView;
        // ---------- Original Method ----------
        //mSplitView = splitView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.879 -0400", hash_original_method = "460E6C1B19245DB35832909D719B5D88", hash_generated_method = "4758BFB6EDA91A09582924D8AC8CD74E")
    public int getAnimatedVisibility() {
        int var1E6D52E7F8591DCD1DF649DE21C8A049_1968393513 = (getVisibility());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1387142400 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1387142400;
        // ---------- Original Method ----------
        //if (mVisibilityAnim != null) {
            //return mVisAnimListener.mFinalVisibility;
        //}
        //return getVisibility();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.881 -0400", hash_original_method = "2B465E314C114C54F186AF3EB05111D9", hash_generated_method = "0C9E987463A78FCE2B2CD1E654FF58CB")
    public void animateToVisibility(int visibility) {
        {
            mVisibilityAnim.cancel();
        } //End block
        {
            {
                boolean varA0A81FC19EFCAB05136A17FC3377BBD3_352366909 = (getVisibility() != VISIBLE);
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
        addTaint(visibility);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.895 -0400", hash_original_method = "E3FDA7CA05E815669691C5C9F461C174", hash_generated_method = "73F0BC07F3D2C7A4210E9CF201F1CCD6")
    @Override
    public void setVisibility(int visibility) {
        {
            mVisibilityAnim.end();
        } //End block
        super.setVisibility(visibility);
        addTaint(visibility);
        // ---------- Original Method ----------
        //if (mVisibilityAnim != null) {
            //mVisibilityAnim.end();
        //}
        //super.setVisibility(visibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.895 -0400", hash_original_method = "6ECDD9C0917165AAFEF87E5E5EC8B474", hash_generated_method = "1B58E9282A5CD2FEABB609E2FB6059DD")
    public boolean showOverflowMenu() {
        {
            boolean varE02B1D76FDCE55870555B6FA38688077_1291490925 = (mActionMenuPresenter.showOverflowMenu());
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1306583137 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1306583137;
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.showOverflowMenu();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.896 -0400", hash_original_method = "5B398819B085BB8DF5162E4F323954D1", hash_generated_method = "55AB681F42ADCBD1B9F08F365FD62BD9")
    public void postShowOverflowMenu() {
        post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.896 -0400", hash_original_method = "2C58279E0E2988284D33F5FBC58AA75D", hash_generated_method = "09EE0F572B2A69A085769CC77C52E2CA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.897 -0400", hash_original_method = "5D05982F33AF24415676BD0317DE2206", hash_generated_method = "60D1AF4A82273B67B9E0BD878E38C362")
    public boolean hideOverflowMenu() {
        {
            boolean var8BAEDFF24230E7488EEC35AEFACB6A9F_1151879940 = (mActionMenuPresenter.hideOverflowMenu());
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1234781088 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1234781088;
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.hideOverflowMenu();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.897 -0400", hash_original_method = "2F838D8CBDDC91E04D7A8F0F52ABF2C8", hash_generated_method = "AEB114CEECC01E85A236FB53B5CD0B67")
    public boolean isOverflowMenuShowing() {
        {
            boolean varD524E4D1CE3A164128E687BA5686CD0D_1815209087 = (mActionMenuPresenter.isOverflowMenuShowing());
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_662075705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_662075705;
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.isOverflowMenuShowing();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.898 -0400", hash_original_method = "2716B287AFF500B52D105CE9F72467AF", hash_generated_method = "5ACBCB26DF1D946671C8C594B269E80E")
    public boolean isOverflowReserved() {
        boolean var7E43AD698358C7AA1146EFF37C1DC275_2062421235 = (mActionMenuPresenter != null && mActionMenuPresenter.isOverflowReserved());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_736571819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_736571819;
        // ---------- Original Method ----------
        //return mActionMenuPresenter != null && mActionMenuPresenter.isOverflowReserved();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.905 -0400", hash_original_method = "E263C11D43E740E059E17F24B3046AB1", hash_generated_method = "321210DA712F127E641AD7F8F8C32179")
    public void dismissPopupMenus() {
        {
            mActionMenuPresenter.dismissPopupMenus();
        } //End block
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //mActionMenuPresenter.dismissPopupMenus();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.918 -0400", hash_original_method = "A00B85663064A0063707CD21F6F98F93", hash_generated_method = "076FB5383A2DA029310D0046AE015A75")
    protected int measureChildView(View child, int availableWidth, int childSpecHeight,
            int spacing) {
        child.measure(MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST),
                childSpecHeight);
        availableWidth -= child.getMeasuredWidth();
        availableWidth -= spacing;
        int varA3B4C2E4827FAB59460811D4731C37C3_1767796386 = (Math.max(0, availableWidth));
        addTaint(child.getTaint());
        addTaint(availableWidth);
        addTaint(childSpecHeight);
        addTaint(spacing);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_575297926 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_575297926;
        // ---------- Original Method ----------
        //child.measure(MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST),
                //childSpecHeight);
        //availableWidth -= child.getMeasuredWidth();
        //availableWidth -= spacing;
        //return Math.max(0, availableWidth);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.919 -0400", hash_original_method = "231762BB3E313BE1E16BACBDFDC62788", hash_generated_method = "229566ECEE91EDC74C7032FCE124554C")
    protected int positionChild(View child, int x, int y, int contentHeight) {
        int childWidth;
        childWidth = child.getMeasuredWidth();
        int childHeight;
        childHeight = child.getMeasuredHeight();
        int childTop;
        childTop = y + (contentHeight - childHeight) / 2;
        child.layout(x, childTop, x + childWidth, childTop + childHeight);
        addTaint(child.getTaint());
        addTaint(x);
        addTaint(y);
        addTaint(contentHeight);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2015781887 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2015781887;
        // ---------- Original Method ----------
        //int childWidth = child.getMeasuredWidth();
        //int childHeight = child.getMeasuredHeight();
        //int childTop = y + (contentHeight - childHeight) / 2;
        //child.layout(x, childTop, x + childWidth, childTop + childHeight);
        //return childWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.920 -0400", hash_original_method = "59F436BC9157B56F2D013CC5AD850863", hash_generated_method = "FC45C72AD64868C7C84306FAE8B1B31E")
    protected int positionChildInverse(View child, int x, int y, int contentHeight) {
        int childWidth;
        childWidth = child.getMeasuredWidth();
        int childHeight;
        childHeight = child.getMeasuredHeight();
        int childTop;
        childTop = y + (contentHeight - childHeight) / 2;
        child.layout(x - childWidth, childTop, x, childTop + childHeight);
        addTaint(child.getTaint());
        addTaint(x);
        addTaint(y);
        addTaint(contentHeight);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1771505616 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1771505616;
        // ---------- Original Method ----------
        //int childWidth = child.getMeasuredWidth();
        //int childHeight = child.getMeasuredHeight();
        //int childTop = y + (contentHeight - childHeight) / 2;
        //child.layout(x - childWidth, childTop, x, childTop + childHeight);
        //return childWidth;
    }

    
    protected class VisibilityAnimListener implements Animator.AnimatorListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.920 -0400", hash_original_field = "D91530AF3D6C660AC2C0C8D4CBB2367B", hash_generated_field = "67D6DA73468F2D6E84B945FD38F1CC1D")

        private boolean mCanceled = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.920 -0400", hash_original_field = "270EA634CE9CE51A331284B9E8EB3832", hash_generated_field = "7E7DD7E9FF8079F20BDC4231CBA0A4C8")

        int mFinalVisibility;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.920 -0400", hash_original_method = "80D34182BA082FA1C0AC7FE2CE12E2A6", hash_generated_method = "80D34182BA082FA1C0AC7FE2CE12E2A6")
        public VisibilityAnimListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.921 -0400", hash_original_method = "42B0250930D53F64D6DEADC73C3EFBBA", hash_generated_method = "7DDE4173BB7E1883CEA532F25E8A63D5")
        public VisibilityAnimListener withFinalVisibility(int visibility) {
            VisibilityAnimListener varB4EAC82CA7396A68D541C85D26508E83_1337542607 = null; //Variable for return #1
            mFinalVisibility = visibility;
            varB4EAC82CA7396A68D541C85D26508E83_1337542607 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1337542607.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1337542607;
            // ---------- Original Method ----------
            //mFinalVisibility = visibility;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.921 -0400", hash_original_method = "9145E12DF11688F9DD8CB4C23A0F2F13", hash_generated_method = "B818DF791669294EDB0F112B9A238DEF")
        @Override
        public void onAnimationStart(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            setVisibility(VISIBLE);
            mVisibilityAnim = animation;
            mCanceled = false;
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
            //setVisibility(VISIBLE);
            //mVisibilityAnim = animation;
            //mCanceled = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.922 -0400", hash_original_method = "D1281410E67CFC6892364AC0D96A57F2", hash_generated_method = "294D800343603FD19A6AF523A05DF836")
        @Override
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mVisibilityAnim = null;
            setVisibility(mFinalVisibility);
            {
                mMenuView.setVisibility(mFinalVisibility);
            } //End block
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
            //if (mCanceled) return;
            //mVisibilityAnim = null;
            //setVisibility(mFinalVisibility);
            //if (mSplitView != null && mMenuView != null) {
                //mMenuView.setVisibility(mFinalVisibility);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.939 -0400", hash_original_method = "2F84891C5ED8AB616225A7D641700DEA", hash_generated_method = "66692DF1E254D3C3C92CC85749BF5C5B")
        @Override
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mCanceled = true;
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
            //mCanceled = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.939 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "4BE2C3EAC3B10B8BD5CE86F0E3077935")
        @Override
        public void onAnimationRepeat(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.939 -0400", hash_original_field = "58EA75425C7F0D76C382950FFD0E66A6", hash_generated_field = "D71EB9420CF1988E2188358BCB875B45")

    private static TimeInterpolator sAlphaInterpolator = new DecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.939 -0400", hash_original_field = "5427C149FA3D3269A4036F1A93D514B4", hash_generated_field = "446F7CFF1903ECC636263E98AB446B41")

    private static int FADE_DURATION = 200;
}

