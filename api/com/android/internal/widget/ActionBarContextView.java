package com.android.internal.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.R;
import com.android.internal.view.menu.ActionMenuPresenter;
import com.android.internal.view.menu.ActionMenuView;
import com.android.internal.view.menu.MenuBuilder;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends AbsActionBarView implements AnimatorListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.703 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.703 -0400", hash_original_field = "6EDD40BFDEB251E34BDCB1CE9C263665", hash_generated_field = "775125B4EBC8ED0F3E5FBA051277E18D")

    private CharSequence mSubtitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.703 -0400", hash_original_field = "6D2EE1E387531C84DD880458CD9B9060", hash_generated_field = "24F281CC402C90EA9D9EB00DDCF618F4")

    private View mClose;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.703 -0400", hash_original_field = "0F85706FF7ACEA880EA803CB0E63A48D", hash_generated_field = "58BF9FCCDFB47B7346A31DF060279244")

    private View mCustomView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.703 -0400", hash_original_field = "E04DEDB0B406830A59065795F4A530C9", hash_generated_field = "53515DAB03CBCC904881F85C0D0B24F4")

    private LinearLayout mTitleLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.703 -0400", hash_original_field = "5F3FDB05EE6E2581CC95AB22CADCE47B", hash_generated_field = "3B26FAD098CFEC3A217F2BF71097A83E")

    private TextView mTitleView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.703 -0400", hash_original_field = "68B3FAC852E3272F9F54C6B1610054DA", hash_generated_field = "5B91EC47B0CD462AA7928A5697458750")

    private TextView mSubtitleView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.703 -0400", hash_original_field = "F00D2B188EA8D8F58E0764D2012CA069", hash_generated_field = "CFEDF1432A06310A2FB06B788CC20410")

    private int mTitleStyleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.703 -0400", hash_original_field = "C0606F823BBDDA71B84334C05C268230", hash_generated_field = "9FA8532B8CB2D1269C79565E301C661F")

    private int mSubtitleStyleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.703 -0400", hash_original_field = "2225C949EA81FBFB7C5583F73183E256", hash_generated_field = "EAFF30D2C8DDA41FABEEAF56960F2296")

    private Drawable mSplitBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.703 -0400", hash_original_field = "40A500CAA798F3EB011971DCA401C2FB", hash_generated_field = "33771BEA3F609DD1955FEC169216294A")

    private Animator mCurrentAnimation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.704 -0400", hash_original_field = "2617AFF41B3BE696F7430186B046AEFC", hash_generated_field = "8265308A3A327A796C7CC259CBBF12AC")

    private boolean mAnimateInOnLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.704 -0400", hash_original_field = "535E559CD7B99D09B7149CE1751E3916", hash_generated_field = "7231072E88C5D78E0458C5139E2E8DF1")

    private int mAnimationMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.704 -0400", hash_original_method = "2EBFD0846938BB846291BE9F4AD94F04", hash_generated_method = "36E4F0BA0A93AF1939B2F4DCD87398AA")
    public  ActionBarContextView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.704 -0400", hash_original_method = "43CDEE17F6E403B0B882E0F499365FE4", hash_generated_method = "65DBF2F815134C17A6737EAF83DA4A05")
    public  ActionBarContextView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.actionModeStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.706 -0400", hash_original_method = "19C70EFA7CD06BD307662BD45113B543", hash_generated_method = "F37F895C3CF4EE0FDA59DBCAE9B4DF29")
    public  ActionBarContextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ActionMode, defStyle, 0);
        setBackgroundDrawable(a.getDrawable(
                com.android.internal.R.styleable.ActionMode_background));
        mTitleStyleRes = a.getResourceId(
                com.android.internal.R.styleable.ActionMode_titleTextStyle, 0);
        mSubtitleStyleRes = a.getResourceId(
                com.android.internal.R.styleable.ActionMode_subtitleTextStyle, 0);
        mContentHeight = a.getLayoutDimension(
                com.android.internal.R.styleable.ActionMode_height, 0);
        mSplitBackground = a.getDrawable(
                com.android.internal.R.styleable.ActionMode_backgroundSplit);
        a.recycle();
        
        
        
                
        
                
        
                
        
                
        
                
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.706 -0400", hash_original_method = "B72CC99F1AE7F170915B2F32514E502E", hash_generated_method = "6EA6D69ABCECA05459E9BD91FFC1CC0C")
    @Override
    public void onDetachedFromWindow() {
        
        super.onDetachedFromWindow();
    if(mActionMenuPresenter != null)        
        {
            mActionMenuPresenter.hideOverflowMenu();
            mActionMenuPresenter.hideSubMenus();
        } 
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.707 -0400", hash_original_method = "E552720A78112C3EB9A59B322D8064C9", hash_generated_method = "40B512652B40353CCC395D998D022942")
    @Override
    public void setSplitActionBar(boolean split) {
        addTaint(split);
    if(mSplitActionBar != split)        
        {
    if(mActionMenuPresenter != null)            
            {
                final LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.MATCH_PARENT);
    if(!split)                
                {
                    mMenuView = (ActionMenuView) mActionMenuPresenter.getMenuView(this);
                    mMenuView.setBackgroundDrawable(null);
                    final ViewGroup oldParent = (ViewGroup) mMenuView.getParent();
    if(oldParent != null)                    
                    oldParent.removeView(mMenuView);
                    addView(mMenuView, layoutParams);
                } 
                else
                {
                    mActionMenuPresenter.setWidthLimit(
                            getContext().getResources().getDisplayMetrics().widthPixels, true);
                    mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
                    layoutParams.width = LayoutParams.MATCH_PARENT;
                    layoutParams.height = mContentHeight;
                    mMenuView = (ActionMenuView) mActionMenuPresenter.getMenuView(this);
                    mMenuView.setBackgroundDrawable(mSplitBackground);
                    final ViewGroup oldParent = (ViewGroup) mMenuView.getParent();
    if(oldParent != null)                    
                    oldParent.removeView(mMenuView);
                    mSplitView.addView(mMenuView, layoutParams);
                } 
            } 
            super.setSplitActionBar(split);
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.708 -0400", hash_original_method = "2AF53FC77EF46E1AB46FFEE70D9B4BD3", hash_generated_method = "85FA25C5E13013EF4DA8CDE2B89AEA08")
    public void setContentHeight(int height) {
        addTaint(height);
        mContentHeight = height;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.708 -0400", hash_original_method = "BF35621F736CEABB1B31AE57D0749737", hash_generated_method = "D56A77774B7BE854EE8AF246CB3E6B0D")
    public void setCustomView(View view) {
    if(mCustomView != null)        
        {
            removeView(mCustomView);
        } 
        mCustomView = view;
    if(mTitleLayout != null)        
        {
            removeView(mTitleLayout);
            mTitleLayout = null;
        } 
    if(view != null)        
        {
            addView(view);
        } 
        requestLayout();
        
        
            
        
        
        
            
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.708 -0400", hash_original_method = "211EB79F55FBE601162C52B7DDCEAE29", hash_generated_method = "3068752903ECBB84927D6D1A0EFBCED0")
    public void setTitle(CharSequence title) {
        mTitle = title;
        initTitle();
        
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.709 -0400", hash_original_method = "7D9357B6D11390EB60D28E00C6F28FA8", hash_generated_method = "B14BABC7DBB2EABEF924921B7507BA92")
    public void setSubtitle(CharSequence subtitle) {
        mSubtitle = subtitle;
        initTitle();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.709 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "1D99492135EC7C21FE15C39E45B0F986")
    public CharSequence getTitle() {
CharSequence var4FE0D95ADE4B4BDFA36D55D8B62A6C49_2041842331 =         mTitle;
        var4FE0D95ADE4B4BDFA36D55D8B62A6C49_2041842331.addTaint(taint);
        return var4FE0D95ADE4B4BDFA36D55D8B62A6C49_2041842331;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.709 -0400", hash_original_method = "8334E54E49A430BB5E2CB9D01857CDC7", hash_generated_method = "969B24DB4A61A96F0FCDD9911B3A47BB")
    public CharSequence getSubtitle() {
CharSequence varB3753FC770C7D70B94AC4A298F41B100_553180510 =         mSubtitle;
        varB3753FC770C7D70B94AC4A298F41B100_553180510.addTaint(taint);
        return varB3753FC770C7D70B94AC4A298F41B100_553180510;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.710 -0400", hash_original_method = "790F9E36BA88F469E91A3DDEB8BA7A0E", hash_generated_method = "B14E78CBBC57D41311882724B30EAEC7")
    private void initTitle() {
    if(mTitleLayout == null)        
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            inflater.inflate(R.layout.action_bar_title_item, this);
            mTitleLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            mTitleView = (TextView) mTitleLayout.findViewById(R.id.action_bar_title);
            mSubtitleView = (TextView) mTitleLayout.findViewById(R.id.action_bar_subtitle);
    if(mTitleStyleRes != 0)            
            {
                mTitleView.setTextAppearance(mContext, mTitleStyleRes);
            } 
    if(mSubtitleStyleRes != 0)            
            {
                mSubtitleView.setTextAppearance(mContext, mSubtitleStyleRes);
            } 
        } 
        mTitleView.setText(mTitle);
        mSubtitleView.setText(mSubtitle);
        final boolean hasTitle = !TextUtils.isEmpty(mTitle);
        final boolean hasSubtitle = !TextUtils.isEmpty(mSubtitle);
        mSubtitleView.setVisibility(hasSubtitle ? VISIBLE : GONE);
        mTitleLayout.setVisibility(hasTitle || hasSubtitle ? VISIBLE : GONE);
    if(mTitleLayout.getParent() == null)        
        {
            addView(mTitleLayout);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.712 -0400", hash_original_method = "6CF0CC9D4208F5A3169016F9961CD359", hash_generated_method = "BDADFC5AA84FFE73F39B7C16C04970A6")
    public void initForMode(final ActionMode mode) {
        addTaint(mode.getTaint());
    if(mClose == null)        
        {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            mClose = inflater.inflate(R.layout.action_mode_close_item, this, false);
            addView(mClose);
        } 
        else
    if(mClose.getParent() == null)        
        {
            addView(mClose);
        } 
        View closeButton = mClose.findViewById(R.id.action_mode_close_button);
        closeButton.setOnClickListener(new OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.711 -0400", hash_original_method = "67B70578F0892507CE1943EF7ED1845C", hash_generated_method = "7FD471FBA5EFC7F8931EB5607ABE258B")
        public void onClick(View v) {
            
            addTaint(v.getTaint());
            mode.finish();
            
            
        }
});
        final MenuBuilder menu = (MenuBuilder) mode.getMenu();
    if(mActionMenuPresenter != null)        
        {
            mActionMenuPresenter.dismissPopupMenus();
        } 
        mActionMenuPresenter = new ActionMenuPresenter(mContext);
        mActionMenuPresenter.setReserveOverflow(true);
        final LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
    if(!mSplitActionBar)        
        {
            menu.addMenuPresenter(mActionMenuPresenter);
            mMenuView = (ActionMenuView) mActionMenuPresenter.getMenuView(this);
            mMenuView.setBackgroundDrawable(null);
            addView(mMenuView, layoutParams);
        } 
        else
        {
            mActionMenuPresenter.setWidthLimit(
                    getContext().getResources().getDisplayMetrics().widthPixels, true);
            mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
            layoutParams.width = LayoutParams.MATCH_PARENT;
            layoutParams.height = mContentHeight;
            menu.addMenuPresenter(mActionMenuPresenter);
            mMenuView = (ActionMenuView) mActionMenuPresenter.getMenuView(this);
            mMenuView.setBackgroundDrawable(mSplitBackground);
            mSplitView.addView(mMenuView, layoutParams);
        } 
        mAnimateInOnLayout = true;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.712 -0400", hash_original_method = "45A4BF13DB4610A7D54223CBAAD97337", hash_generated_method = "F40F6DF06CC44895351C09776DEB92CD")
    public void closeMode() {
    if(mAnimationMode == ANIMATE_OUT)        
        {
            return;
        } 
    if(mClose == null)        
        {
            killMode();
            return;
        } 
        finishAnimation();
        mAnimationMode = ANIMATE_OUT;
        mCurrentAnimation = makeOutAnimation();
        mCurrentAnimation.start();
        
        
            
        
        
            
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.713 -0400", hash_original_method = "A219535592712D030952E62AEE6B3C28", hash_generated_method = "8CBB2A0382B52CD1AD9C6470C0BE330D")
    private void finishAnimation() {
        final Animator a = mCurrentAnimation;
    if(a != null)        
        {
            mCurrentAnimation = null;
            a.end();
        } 
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.713 -0400", hash_original_method = "2B49C690F775A4BD526B81BD0C8494DB", hash_generated_method = "DBEC42C8FD1604880E9C5F3213306446")
    public void killMode() {
        finishAnimation();
        removeAllViews();
    if(mSplitView != null)        
        {
            mSplitView.removeView(mMenuView);
        } 
        mCustomView = null;
        mMenuView = null;
        mAnimateInOnLayout = false;
        
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.713 -0400", hash_original_method = "6ECDD9C0917165AAFEF87E5E5EC8B474", hash_generated_method = "E0FDF9B2EB446D8097794CE877CBC723")
    @Override
    public boolean showOverflowMenu() {
    if(mActionMenuPresenter != null)        
        {
            boolean varBFC2B6A46330B4A2C0833A7CFFCAD0E6_725679944 = (mActionMenuPresenter.showOverflowMenu());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1699533592 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1699533592;
        } 
        boolean var68934A3E9455FA72420237EB05902327_1713616644 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1671644660 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1671644660;
        
        
            
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.714 -0400", hash_original_method = "5D05982F33AF24415676BD0317DE2206", hash_generated_method = "54732FE68CB2A2F5CE6F0037AB89E921")
    @Override
    public boolean hideOverflowMenu() {
    if(mActionMenuPresenter != null)        
        {
            boolean var5C0D979EB15917E48FF5FEE985A01770_1873970016 = (mActionMenuPresenter.hideOverflowMenu());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1937853088 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1937853088;
        } 
        boolean var68934A3E9455FA72420237EB05902327_390623365 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1434370108 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1434370108;
        
        
            
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.714 -0400", hash_original_method = "2F838D8CBDDC91E04D7A8F0F52ABF2C8", hash_generated_method = "D4E517CC99713747AD03DFF01E207654")
    @Override
    public boolean isOverflowMenuShowing() {
    if(mActionMenuPresenter != null)        
        {
            boolean varAED510BBF3E16C2B886300C9FBDF94E1_943213256 = (mActionMenuPresenter.isOverflowMenuShowing());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_440382634 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_440382634;
        } 
        boolean var68934A3E9455FA72420237EB05902327_905146443 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_639091321 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_639091321;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.714 -0400", hash_original_method = "73CB5175F40E2B68B8D41267F726F54F", hash_generated_method = "3B7F9DAD699EB0749583451F9E54BBC9")
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
ViewGroup.LayoutParams var4490FB16A7D525B3F5943EA644263D71_252616285 =         new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        var4490FB16A7D525B3F5943EA644263D71_252616285.addTaint(taint);
        return var4490FB16A7D525B3F5943EA644263D71_252616285;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.715 -0400", hash_original_method = "5C07F753B3F2B1F9F4C858C93EDD71AE", hash_generated_method = "015C728BA9F3CC6762BE86CEEC09D6B5")
    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        addTaint(attrs.getTaint());
ViewGroup.LayoutParams varF0A7E2F39E7E9E98E9F37F1089A0BE0D_1794925957 =         new MarginLayoutParams(getContext(), attrs);
        varF0A7E2F39E7E9E98E9F37F1089A0BE0D_1794925957.addTaint(taint);
        return varF0A7E2F39E7E9E98E9F37F1089A0BE0D_1794925957;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.716 -0400", hash_original_method = "ADE259D11B02655AAFB5EBCEC641AC5E", hash_generated_method = "4CDC1EE6C1664393DFE4D171366C5AAB")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
    if(widthMode != MeasureSpec.EXACTLY)        
        {
            IllegalStateException var0078FEAADAE205F1DDF3953FFCC7DD03_1891228857 = new IllegalStateException(getClass().getSimpleName() + " can only be used " +
                    "with android:layout_width=\"match_parent\" (or fill_parent)");
            var0078FEAADAE205F1DDF3953FFCC7DD03_1891228857.addTaint(taint);
            throw var0078FEAADAE205F1DDF3953FFCC7DD03_1891228857;
        } 
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
    if(heightMode == MeasureSpec.UNSPECIFIED)        
        {
            IllegalStateException var2F6FC63DCF083FE3E3F7F2BC6369EDB9_1237104829 = new IllegalStateException(getClass().getSimpleName() + " can only be used " +
                    "with android:layout_height=\"wrap_content\"");
            var2F6FC63DCF083FE3E3F7F2BC6369EDB9_1237104829.addTaint(taint);
            throw var2F6FC63DCF083FE3E3F7F2BC6369EDB9_1237104829;
        } 
        final int contentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int maxHeight = mContentHeight > 0 ?
                mContentHeight : MeasureSpec.getSize(heightMeasureSpec);
        final int verticalPadding = getPaddingTop() + getPaddingBottom();
        int availableWidth = contentWidth - getPaddingLeft() - getPaddingRight();
        final int height = maxHeight - verticalPadding;
        final int childSpecHeight = MeasureSpec.makeMeasureSpec(height, MeasureSpec.AT_MOST);
    if(mClose != null)        
        {
            availableWidth = measureChildView(mClose, availableWidth, childSpecHeight, 0);
            MarginLayoutParams lp = (MarginLayoutParams) mClose.getLayoutParams();
            availableWidth -= lp.leftMargin + lp.rightMargin;
        } 
    if(mMenuView != null && mMenuView.getParent() == this)        
        {
            availableWidth = measureChildView(mMenuView, availableWidth,
                    childSpecHeight, 0);
        } 
    if(mTitleLayout != null && mCustomView == null)        
        {
            availableWidth = measureChildView(mTitleLayout, availableWidth, childSpecHeight, 0);
        } 
    if(mCustomView != null)        
        {
            ViewGroup.LayoutParams lp = mCustomView.getLayoutParams();
            final int customWidthMode = lp.width != LayoutParams.WRAP_CONTENT ?
                    MeasureSpec.EXACTLY : MeasureSpec.AT_MOST;
            final int customWidth = lp.width >= 0 ?
                    Math.min(lp.width, availableWidth) : availableWidth;
            final int customHeightMode = lp.height != LayoutParams.WRAP_CONTENT ?
                    MeasureSpec.EXACTLY : MeasureSpec.AT_MOST;
            final int customHeight = lp.height >= 0 ?
                    Math.min(lp.height, height) : height;
            mCustomView.measure(MeasureSpec.makeMeasureSpec(customWidth, customWidthMode),
                    MeasureSpec.makeMeasureSpec(customHeight, customHeightMode));
        } 
    if(mContentHeight <= 0)        
        {
            int measuredHeight = 0;
            final int count = getChildCount();
for(int i = 0;i < count;i++)
            {
                View v = getChildAt(i);
                int paddedViewHeight = v.getMeasuredHeight() + verticalPadding;
    if(paddedViewHeight > measuredHeight)                
                {
                    measuredHeight = paddedViewHeight;
                } 
            } 
            setMeasuredDimension(contentWidth, measuredHeight);
        } 
        else
        {
            setMeasuredDimension(contentWidth, maxHeight);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.717 -0400", hash_original_method = "1F1E13F5C24EF6D24D9BF3983118D5E2", hash_generated_method = "055A21E63BA41DCE273FC8730B2B7213")
    private Animator makeInAnimation() {
        mClose.setTranslationX(-mClose.getWidth() -
                ((MarginLayoutParams) mClose.getLayoutParams()).leftMargin);
        ObjectAnimator buttonAnimator = ObjectAnimator.ofFloat(mClose, "translationX", 0);
        buttonAnimator.setDuration(200);
        buttonAnimator.addListener(this);
        buttonAnimator.setInterpolator(new DecelerateInterpolator());
        AnimatorSet set = new AnimatorSet();
        AnimatorSet.Builder b = set.play(buttonAnimator);
    if(mMenuView != null)        
        {
            final int count = mMenuView.getChildCount();
    if(count > 0)            
            {
for(int i = count - 1, j = 0;i >= 0;i--,j++)
                {
                    View child = mMenuView.getChildAt(i);
                    child.setScaleY(0);
                    ObjectAnimator a = ObjectAnimator.ofFloat(child, "scaleY", 0, 1);
                    a.setDuration(100);
                    a.setStartDelay(j * 70);
                    b.with(a);
                } 
            } 
        } 
Animator varD2D4612E029977363A9BBEBD4F0339C0_889883095 =         set;
        varD2D4612E029977363A9BBEBD4F0339C0_889883095.addTaint(taint);
        return varD2D4612E029977363A9BBEBD4F0339C0_889883095;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.718 -0400", hash_original_method = "BAA3822313887C49DB18D4BC04440E7E", hash_generated_method = "B2E43A144E8A1AB4CB5E4126F5715541")
    private Animator makeOutAnimation() {
        ObjectAnimator buttonAnimator = ObjectAnimator.ofFloat(mClose, "translationX",
                -mClose.getWidth() - ((MarginLayoutParams) mClose.getLayoutParams()).leftMargin);
        buttonAnimator.setDuration(200);
        buttonAnimator.addListener(this);
        buttonAnimator.setInterpolator(new DecelerateInterpolator());
        AnimatorSet set = new AnimatorSet();
        AnimatorSet.Builder b = set.play(buttonAnimator);
    if(mMenuView != null)        
        {
            final int count = mMenuView.getChildCount();
    if(count > 0)            
            {
for(int i = 0;i < 0;i++)
                {
                    View child = mMenuView.getChildAt(i);
                    child.setScaleY(0);
                    ObjectAnimator a = ObjectAnimator.ofFloat(child, "scaleY", 0);
                    a.setDuration(100);
                    a.setStartDelay(i * 70);
                    b.with(a);
                } 
            } 
        } 
Animator varD2D4612E029977363A9BBEBD4F0339C0_2077319040 =         set;
        varD2D4612E029977363A9BBEBD4F0339C0_2077319040.addTaint(taint);
        return varD2D4612E029977363A9BBEBD4F0339C0_2077319040;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.720 -0400", hash_original_method = "EAC754957749E93A677F7BF2F54929F7", hash_generated_method = "E6B7479EC970840FE45F87B94031E6A2")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        addTaint(changed);
        int x = getPaddingLeft();
        final int y = getPaddingTop();
        final int contentHeight = b - t - getPaddingTop() - getPaddingBottom();
    if(mClose != null && mClose.getVisibility() != GONE)        
        {
            MarginLayoutParams lp = (MarginLayoutParams) mClose.getLayoutParams();
            x += lp.leftMargin;
            x += positionChild(mClose, x, y, contentHeight);
            x += lp.rightMargin;
    if(mAnimateInOnLayout)            
            {
                mAnimationMode = ANIMATE_IN;
                mCurrentAnimation = makeInAnimation();
                mCurrentAnimation.start();
                mAnimateInOnLayout = false;
            } 
        } 
    if(mTitleLayout != null && mCustomView == null)        
        {
            x += positionChild(mTitleLayout, x, y, contentHeight);
        } 
    if(mCustomView != null)        
        {
            x += positionChild(mCustomView, x, y, contentHeight);
        } 
        x = r - l - getPaddingRight();
    if(mMenuView != null)        
        {
            x -= positionChildInverse(mMenuView, x, y, contentHeight);
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.720 -0400", hash_original_method = "B990D1A680B01C8A5486D22741D7E96B", hash_generated_method = "B2B2A92B36E552BECB72262238AEF578")
    @Override
    public void onAnimationStart(Animator animation) {
        
        addTaint(animation.getTaint());
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.720 -0400", hash_original_method = "5DF138862D9EBBC48B8DDB31E593969C", hash_generated_method = "C5CC1F87C1E87F656ABAAB8F28BE50CA")
    @Override
    public void onAnimationEnd(Animator animation) {
        
        addTaint(animation.getTaint());
    if(mAnimationMode == ANIMATE_OUT)        
        {
            killMode();
        } 
        mAnimationMode = ANIMATE_IDLE;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.721 -0400", hash_original_method = "16FF962612CA0CC38B4765F38064800C", hash_generated_method = "87B148FBA6A6D3270D8BD7F9EEB4C6C1")
    @Override
    public void onAnimationCancel(Animator animation) {
        
        addTaint(animation.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.721 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "4BE2C3EAC3B10B8BD5CE86F0E3077935")
    @Override
    public void onAnimationRepeat(Animator animation) {
        
        addTaint(animation.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.721 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "195CC6D228CCCE4E7DC53ABD77AAD3C8")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean var68934A3E9455FA72420237EB05902327_711302083 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1385043730 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1385043730;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.721 -0400", hash_original_method = "237F1A60A9E9685B4EADEDCFF21B9A19", hash_generated_method = "496B961F7C884FE8DE8F8D81E2BF7357")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        
        addTaint(event.getTaint());
    if(event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED)        
        {
            event.setSource(this);
            event.setClassName(getClass().getName());
            event.setPackageName(getContext().getPackageName());
            event.setContentDescription(mTitle);
        } 
        else
        {
            super.onInitializeAccessibilityEvent(event);
        } 
        
        
            
            
            
            
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.721 -0400", hash_original_field = "739489FAD6929E44E2450E802B918903", hash_generated_field = "C45604C41252B81A800ABE94C507699D")

    private static final String TAG = "ActionBarContextView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.721 -0400", hash_original_field = "AF00BC2BF674D3EFAB3DFBD00DBA4532", hash_generated_field = "2A63476C517D08BD976212871A960624")

    private static final int ANIMATE_IDLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.721 -0400", hash_original_field = "3C1F5798ED90853371F7E27F97227A2D", hash_generated_field = "822EF0AC3705B18FD672B9EE2414E019")

    private static final int ANIMATE_IN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.721 -0400", hash_original_field = "12EBE1750465D044EFC402BA687119AE", hash_generated_field = "1F174DF669D4184CA0C67FB39313E9F2")

    private static final int ANIMATE_OUT = 2;
}

