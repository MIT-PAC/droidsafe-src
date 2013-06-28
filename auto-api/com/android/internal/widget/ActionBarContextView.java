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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.800 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.800 -0400", hash_original_field = "6EDD40BFDEB251E34BDCB1CE9C263665", hash_generated_field = "775125B4EBC8ED0F3E5FBA051277E18D")

    private CharSequence mSubtitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.800 -0400", hash_original_field = "6D2EE1E387531C84DD880458CD9B9060", hash_generated_field = "24F281CC402C90EA9D9EB00DDCF618F4")

    private View mClose;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.801 -0400", hash_original_field = "0F85706FF7ACEA880EA803CB0E63A48D", hash_generated_field = "58BF9FCCDFB47B7346A31DF060279244")

    private View mCustomView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.801 -0400", hash_original_field = "E04DEDB0B406830A59065795F4A530C9", hash_generated_field = "53515DAB03CBCC904881F85C0D0B24F4")

    private LinearLayout mTitleLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.801 -0400", hash_original_field = "5F3FDB05EE6E2581CC95AB22CADCE47B", hash_generated_field = "3B26FAD098CFEC3A217F2BF71097A83E")

    private TextView mTitleView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.801 -0400", hash_original_field = "68B3FAC852E3272F9F54C6B1610054DA", hash_generated_field = "5B91EC47B0CD462AA7928A5697458750")

    private TextView mSubtitleView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.801 -0400", hash_original_field = "F00D2B188EA8D8F58E0764D2012CA069", hash_generated_field = "CFEDF1432A06310A2FB06B788CC20410")

    private int mTitleStyleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.801 -0400", hash_original_field = "C0606F823BBDDA71B84334C05C268230", hash_generated_field = "9FA8532B8CB2D1269C79565E301C661F")

    private int mSubtitleStyleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.801 -0400", hash_original_field = "2225C949EA81FBFB7C5583F73183E256", hash_generated_field = "EAFF30D2C8DDA41FABEEAF56960F2296")

    private Drawable mSplitBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.801 -0400", hash_original_field = "40A500CAA798F3EB011971DCA401C2FB", hash_generated_field = "33771BEA3F609DD1955FEC169216294A")

    private Animator mCurrentAnimation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.801 -0400", hash_original_field = "2617AFF41B3BE696F7430186B046AEFC", hash_generated_field = "8265308A3A327A796C7CC259CBBF12AC")

    private boolean mAnimateInOnLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.801 -0400", hash_original_field = "535E559CD7B99D09B7149CE1751E3916", hash_generated_field = "7231072E88C5D78E0458C5139E2E8DF1")

    private int mAnimationMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.801 -0400", hash_original_method = "2EBFD0846938BB846291BE9F4AD94F04", hash_generated_method = "36E4F0BA0A93AF1939B2F4DCD87398AA")
    public  ActionBarContextView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.801 -0400", hash_original_method = "43CDEE17F6E403B0B882E0F499365FE4", hash_generated_method = "8E70D20FDB3F04B61DA16551FB4B3754")
    public  ActionBarContextView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.actionModeStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.802 -0400", hash_original_method = "19C70EFA7CD06BD307662BD45113B543", hash_generated_method = "BAD6B7C6CA4448E00D7EB5EAD151EA08")
    public  ActionBarContextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
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
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ActionMode, defStyle, 0);
        //setBackgroundDrawable(a.getDrawable(
                //com.android.internal.R.styleable.ActionMode_background));
        //mTitleStyleRes = a.getResourceId(
                //com.android.internal.R.styleable.ActionMode_titleTextStyle, 0);
        //mSubtitleStyleRes = a.getResourceId(
                //com.android.internal.R.styleable.ActionMode_subtitleTextStyle, 0);
        //mContentHeight = a.getLayoutDimension(
                //com.android.internal.R.styleable.ActionMode_height, 0);
        //mSplitBackground = a.getDrawable(
                //com.android.internal.R.styleable.ActionMode_backgroundSplit);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.802 -0400", hash_original_method = "B72CC99F1AE7F170915B2F32514E502E", hash_generated_method = "557C076842D7BAB87119015349CF3395")
    @Override
    public void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        {
            mActionMenuPresenter.hideOverflowMenu();
            mActionMenuPresenter.hideSubMenus();
        } //End block
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //if (mActionMenuPresenter != null) {
            //mActionMenuPresenter.hideOverflowMenu();
            //mActionMenuPresenter.hideSubMenus();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.803 -0400", hash_original_method = "E552720A78112C3EB9A59B322D8064C9", hash_generated_method = "03D54A0F0089C925BD524947DCE6A392")
    @Override
    public void setSplitActionBar(boolean split) {
        {
            {
                final LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.MATCH_PARENT);
                {
                    mMenuView = (ActionMenuView) mActionMenuPresenter.getMenuView(this);
                    mMenuView.setBackgroundDrawable(null);
                    final ViewGroup oldParent = (ViewGroup) mMenuView.getParent();
                    oldParent.removeView(mMenuView);
                    addView(mMenuView, layoutParams);
                } //End block
                {
                    mActionMenuPresenter.setWidthLimit(
                            getContext().getResources().getDisplayMetrics().widthPixels, true);
                    mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
                    layoutParams.width = LayoutParams.MATCH_PARENT;
                    layoutParams.height = mContentHeight;
                    mMenuView = (ActionMenuView) mActionMenuPresenter.getMenuView(this);
                    mMenuView.setBackgroundDrawable(mSplitBackground);
                    final ViewGroup oldParent = (ViewGroup) mMenuView.getParent();
                    oldParent.removeView(mMenuView);
                    mSplitView.addView(mMenuView, layoutParams);
                } //End block
            } //End block
            super.setSplitActionBar(split);
        } //End block
        addTaint(split);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.803 -0400", hash_original_method = "2AF53FC77EF46E1AB46FFEE70D9B4BD3", hash_generated_method = "B605154034957D668B9E756F3C9F46CD")
    public void setContentHeight(int height) {
        mContentHeight = height;
        addTaint(height);
        // ---------- Original Method ----------
        //mContentHeight = height;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.804 -0400", hash_original_method = "BF35621F736CEABB1B31AE57D0749737", hash_generated_method = "6E197DFE3D2B6928F20A4E6ECFADB76F")
    public void setCustomView(View view) {
        {
            removeView(mCustomView);
        } //End block
        mCustomView = view;
        {
            removeView(mTitleLayout);
            mTitleLayout = null;
        } //End block
        {
            addView(view);
        } //End block
        requestLayout();
        // ---------- Original Method ----------
        //if (mCustomView != null) {
            //removeView(mCustomView);
        //}
        //mCustomView = view;
        //if (mTitleLayout != null) {
            //removeView(mTitleLayout);
            //mTitleLayout = null;
        //}
        //if (view != null) {
            //addView(view);
        //}
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.804 -0400", hash_original_method = "211EB79F55FBE601162C52B7DDCEAE29", hash_generated_method = "3068752903ECBB84927D6D1A0EFBCED0")
    public void setTitle(CharSequence title) {
        mTitle = title;
        initTitle();
        // ---------- Original Method ----------
        //mTitle = title;
        //initTitle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.805 -0400", hash_original_method = "7D9357B6D11390EB60D28E00C6F28FA8", hash_generated_method = "B14BABC7DBB2EABEF924921B7507BA92")
    public void setSubtitle(CharSequence subtitle) {
        mSubtitle = subtitle;
        initTitle();
        // ---------- Original Method ----------
        //mSubtitle = subtitle;
        //initTitle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.806 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "CE98308AC8FC8DE5A7C5E01D4F0FB7A4")
    public CharSequence getTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1900230383 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1900230383 = mTitle;
        varB4EAC82CA7396A68D541C85D26508E83_1900230383.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1900230383;
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.806 -0400", hash_original_method = "8334E54E49A430BB5E2CB9D01857CDC7", hash_generated_method = "96577F10E51CA4F966917D2D96D5C1AE")
    public CharSequence getSubtitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1666504528 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1666504528 = mSubtitle;
        varB4EAC82CA7396A68D541C85D26508E83_1666504528.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1666504528;
        // ---------- Original Method ----------
        //return mSubtitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.807 -0400", hash_original_method = "790F9E36BA88F469E91A3DDEB8BA7A0E", hash_generated_method = "29A0C6559F1272E4E7EABB9ACE05515F")
    private void initTitle() {
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            inflater.inflate(R.layout.action_bar_title_item, this);
            mTitleLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            mTitleView = (TextView) mTitleLayout.findViewById(R.id.action_bar_title);
            mSubtitleView = (TextView) mTitleLayout.findViewById(R.id.action_bar_subtitle);
            {
                mTitleView.setTextAppearance(mContext, mTitleStyleRes);
            } //End block
            {
                mSubtitleView.setTextAppearance(mContext, mSubtitleStyleRes);
            } //End block
        } //End block
        mTitleView.setText(mTitle);
        mSubtitleView.setText(mSubtitle);
        final boolean hasTitle = !TextUtils.isEmpty(mTitle);
        final boolean hasSubtitle = !TextUtils.isEmpty(mSubtitle);
        mSubtitleView.setVisibility(hasSubtitle ? VISIBLE : GONE);
        mTitleLayout.setVisibility(hasTitle || hasSubtitle ? VISIBLE : GONE);
        {
            boolean var3A8301BC648C0D99D98FE6154410787A_16527663 = (mTitleLayout.getParent() == null);
            {
                addView(mTitleLayout);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.808 -0400", hash_original_method = "6CF0CC9D4208F5A3169016F9961CD359", hash_generated_method = "1792E2015A6AF115C98562CED8D1FA65")
    public void initForMode(final ActionMode mode) {
        {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            mClose = inflater.inflate(R.layout.action_mode_close_item, this, false);
            addView(mClose);
        } //End block
        {
            boolean var3F2B07AD129A1B42F4010FDA38D1B689_322315509 = (mClose.getParent() == null);
            {
                addView(mClose);
            } //End block
        } //End collapsed parenthetic
        View closeButton = mClose.findViewById(R.id.action_mode_close_button);
        closeButton.setOnClickListener(new OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.808 -0400", hash_original_method = "67B70578F0892507CE1943EF7ED1845C", hash_generated_method = "393BF4B4E68042F128F39E87CE78FB26")
            public void onClick(View v) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                mode.finish();
                addTaint(v.getTaint());
                // ---------- Original Method ----------
                //mode.finish();
            }
});
        final MenuBuilder menu = (MenuBuilder) mode.getMenu();
        {
            mActionMenuPresenter.dismissPopupMenus();
        } //End block
        mActionMenuPresenter = new ActionMenuPresenter(mContext);
        mActionMenuPresenter.setReserveOverflow(true);
        final LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        {
            menu.addMenuPresenter(mActionMenuPresenter);
            mMenuView = (ActionMenuView) mActionMenuPresenter.getMenuView(this);
            mMenuView.setBackgroundDrawable(null);
            addView(mMenuView, layoutParams);
        } //End block
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
        } //End block
        mAnimateInOnLayout = true;
        addTaint(mode.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.809 -0400", hash_original_method = "45A4BF13DB4610A7D54223CBAAD97337", hash_generated_method = "745B8B66475F4A40396395F66FFF9CA0")
    public void closeMode() {
        {
            killMode();
        } //End block
        finishAnimation();
        mAnimationMode = ANIMATE_OUT;
        mCurrentAnimation = makeOutAnimation();
        mCurrentAnimation.start();
        // ---------- Original Method ----------
        //if (mAnimationMode == ANIMATE_OUT) {
            //return;
        //}
        //if (mClose == null) {
            //killMode();
            //return;
        //}
        //finishAnimation();
        //mAnimationMode = ANIMATE_OUT;
        //mCurrentAnimation = makeOutAnimation();
        //mCurrentAnimation.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.809 -0400", hash_original_method = "A219535592712D030952E62AEE6B3C28", hash_generated_method = "15152B3FBE9C9332895A06CC6BBDBAD8")
    private void finishAnimation() {
        final Animator a = mCurrentAnimation;
        {
            mCurrentAnimation = null;
            a.end();
        } //End block
        // ---------- Original Method ----------
        //final Animator a = mCurrentAnimation;
        //if (a != null) {
            //mCurrentAnimation = null;
            //a.end();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.809 -0400", hash_original_method = "2B49C690F775A4BD526B81BD0C8494DB", hash_generated_method = "F8B2017962A97F59AC5932BC0432217E")
    public void killMode() {
        finishAnimation();
        removeAllViews();
        {
            mSplitView.removeView(mMenuView);
        } //End block
        mCustomView = null;
        mMenuView = null;
        mAnimateInOnLayout = false;
        // ---------- Original Method ----------
        //finishAnimation();
        //removeAllViews();
        //if (mSplitView != null) {
            //mSplitView.removeView(mMenuView);
        //}
        //mCustomView = null;
        //mMenuView = null;
        //mAnimateInOnLayout = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.809 -0400", hash_original_method = "6ECDD9C0917165AAFEF87E5E5EC8B474", hash_generated_method = "B420515F20440DA3DAF676257AD56DF7")
    @Override
    public boolean showOverflowMenu() {
        {
            boolean varE02B1D76FDCE55870555B6FA38688077_1252479352 = (mActionMenuPresenter.showOverflowMenu());
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_415221439 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_415221439;
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.showOverflowMenu();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.810 -0400", hash_original_method = "5D05982F33AF24415676BD0317DE2206", hash_generated_method = "6B7256EAF240DEF9613DCADFA2EBB81E")
    @Override
    public boolean hideOverflowMenu() {
        {
            boolean var8BAEDFF24230E7488EEC35AEFACB6A9F_328638711 = (mActionMenuPresenter.hideOverflowMenu());
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2030688654 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2030688654;
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.hideOverflowMenu();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.810 -0400", hash_original_method = "2F838D8CBDDC91E04D7A8F0F52ABF2C8", hash_generated_method = "B330EA745F6AB6FA2B2E8D8E4ED70908")
    @Override
    public boolean isOverflowMenuShowing() {
        {
            boolean varD524E4D1CE3A164128E687BA5686CD0D_445258679 = (mActionMenuPresenter.isOverflowMenuShowing());
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_421742366 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_421742366;
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.isOverflowMenuShowing();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.810 -0400", hash_original_method = "73CB5175F40E2B68B8D41267F726F54F", hash_generated_method = "7E9AF0FADB40A4D125ADCDAEA65D4095")
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_502685947 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_502685947 = new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        varB4EAC82CA7396A68D541C85D26508E83_502685947.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_502685947;
        // ---------- Original Method ----------
        //return new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.811 -0400", hash_original_method = "5C07F753B3F2B1F9F4C858C93EDD71AE", hash_generated_method = "9E08B7B340A708C7FC5CA446506FC4EA")
    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1915468303 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1915468303 = new MarginLayoutParams(getContext(), attrs);
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1915468303.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1915468303;
        // ---------- Original Method ----------
        //return new MarginLayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.812 -0400", hash_original_method = "ADE259D11B02655AAFB5EBCEC641AC5E", hash_generated_method = "EC34E9EE0D4C53EA7E7EAD254862B3CB")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(getClass().getSimpleName() + " can only be used " +
                    "with android:layout_width=\"match_parent\" (or fill_parent)");
        } //End block
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(getClass().getSimpleName() + " can only be used " +
                    "with android:layout_height=\"wrap_content\"");
        } //End block
        final int contentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int maxHeight;
        maxHeight = mContentHeight;
        maxHeight = MeasureSpec.getSize(heightMeasureSpec);
        final int verticalPadding = getPaddingTop() + getPaddingBottom();
        int availableWidth = contentWidth - getPaddingLeft() - getPaddingRight();
        final int height = maxHeight - verticalPadding;
        final int childSpecHeight = MeasureSpec.makeMeasureSpec(height, MeasureSpec.AT_MOST);
        {
            availableWidth = measureChildView(mClose, availableWidth, childSpecHeight, 0);
            MarginLayoutParams lp = (MarginLayoutParams) mClose.getLayoutParams();
            availableWidth -= lp.leftMargin + lp.rightMargin;
        } //End block
        {
            boolean var1178C40D6B4B3394C757D204E5BDCC27_1791277527 = (mMenuView != null && mMenuView.getParent() == this);
            {
                availableWidth = measureChildView(mMenuView, availableWidth,
                    childSpecHeight, 0);
            } //End block
        } //End collapsed parenthetic
        {
            availableWidth = measureChildView(mTitleLayout, availableWidth, childSpecHeight, 0);
        } //End block
        {
            ViewGroup.LayoutParams lp = mCustomView.getLayoutParams();
            int customWidthMode;
            customWidthMode = MeasureSpec.EXACTLY;
            customWidthMode = MeasureSpec.AT_MOST;
            int customWidth;
            customWidth = Math.min(lp.width, availableWidth);
            customWidth = availableWidth;
            int customHeightMode;
            customHeightMode = MeasureSpec.EXACTLY;
            customHeightMode = MeasureSpec.AT_MOST;
            int customHeight;
            customHeight = Math.min(lp.height, height);
            customHeight = height;
            mCustomView.measure(MeasureSpec.makeMeasureSpec(customWidth, customWidthMode),
                    MeasureSpec.makeMeasureSpec(customHeight, customHeightMode));
        } //End block
        {
            int measuredHeight = 0;
            final int count = getChildCount();
            {
                int i = 0;
                {
                    View v = getChildAt(i);
                    int paddedViewHeight = v.getMeasuredHeight() + verticalPadding;
                    {
                        measuredHeight = paddedViewHeight;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            setMeasuredDimension(contentWidth, measuredHeight);
        } //End block
        {
            setMeasuredDimension(contentWidth, maxHeight);
        } //End block
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.813 -0400", hash_original_method = "1F1E13F5C24EF6D24D9BF3983118D5E2", hash_generated_method = "2082CBD65651468C89E6BEC3EDC24878")
    private Animator makeInAnimation() {
        Animator varB4EAC82CA7396A68D541C85D26508E83_279660008 = null; //Variable for return #1
        mClose.setTranslationX(-mClose.getWidth() -
                ((MarginLayoutParams) mClose.getLayoutParams()).leftMargin);
        ObjectAnimator buttonAnimator = ObjectAnimator.ofFloat(mClose, "translationX", 0);
        buttonAnimator.setDuration(200);
        buttonAnimator.addListener(this);
        buttonAnimator.setInterpolator(new DecelerateInterpolator());
        AnimatorSet set = new AnimatorSet();
        AnimatorSet.Builder b = set.play(buttonAnimator);
        {
            final int count = mMenuView.getChildCount();
            {
                {
                    int i = count - 1;
                    int j = 0;
                    {
                        View child = mMenuView.getChildAt(i);
                        child.setScaleY(0);
                        ObjectAnimator a = ObjectAnimator.ofFloat(child, "scaleY", 0, 1);
                        a.setDuration(100);
                        a.setStartDelay(j * 70);
                        b.with(a);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_279660008 = set;
        varB4EAC82CA7396A68D541C85D26508E83_279660008.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_279660008;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.813 -0400", hash_original_method = "BAA3822313887C49DB18D4BC04440E7E", hash_generated_method = "F78E2ADEF71A451D254B7DD2885C4123")
    private Animator makeOutAnimation() {
        Animator varB4EAC82CA7396A68D541C85D26508E83_2109783142 = null; //Variable for return #1
        ObjectAnimator buttonAnimator = ObjectAnimator.ofFloat(mClose, "translationX",
                -mClose.getWidth() - ((MarginLayoutParams) mClose.getLayoutParams()).leftMargin);
        buttonAnimator.setDuration(200);
        buttonAnimator.addListener(this);
        buttonAnimator.setInterpolator(new DecelerateInterpolator());
        AnimatorSet set = new AnimatorSet();
        AnimatorSet.Builder b = set.play(buttonAnimator);
        {
            final int count = mMenuView.getChildCount();
            {
                {
                    int i = 0;
                    {
                        View child = mMenuView.getChildAt(i);
                        child.setScaleY(0);
                        ObjectAnimator a = ObjectAnimator.ofFloat(child, "scaleY", 0);
                        a.setDuration(100);
                        a.setStartDelay(i * 70);
                        b.with(a);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2109783142 = set;
        varB4EAC82CA7396A68D541C85D26508E83_2109783142.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2109783142;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.814 -0400", hash_original_method = "EAC754957749E93A677F7BF2F54929F7", hash_generated_method = "AB46E99570DDD01DD3AB82E98EE53E30")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int x = getPaddingLeft();
        final int y = getPaddingTop();
        final int contentHeight = b - t - getPaddingTop() - getPaddingBottom();
        {
            boolean var8961E9B959AFEC04EA20AF6092DB526E_1928341904 = (mClose != null && mClose.getVisibility() != GONE);
            {
                MarginLayoutParams lp = (MarginLayoutParams) mClose.getLayoutParams();
                x += lp.leftMargin;
                x += positionChild(mClose, x, y, contentHeight);
                x += lp.rightMargin;
                {
                    mAnimationMode = ANIMATE_IN;
                    mCurrentAnimation = makeInAnimation();
                    mCurrentAnimation.start();
                    mAnimateInOnLayout = false;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            x += positionChild(mTitleLayout, x, y, contentHeight);
        } //End block
        {
            x += positionChild(mCustomView, x, y, contentHeight);
        } //End block
        x = r - l - getPaddingRight();
        {
            x -= positionChildInverse(mMenuView, x, y, contentHeight);
        } //End block
        addTaint(changed);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.815 -0400", hash_original_method = "B990D1A680B01C8A5486D22741D7E96B", hash_generated_method = "B2B2A92B36E552BECB72262238AEF578")
    @Override
    public void onAnimationStart(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(animation.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.815 -0400", hash_original_method = "5DF138862D9EBBC48B8DDB31E593969C", hash_generated_method = "A4EB3E1952AEDA6F52397D481FF73618")
    @Override
    public void onAnimationEnd(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            killMode();
        } //End block
        mAnimationMode = ANIMATE_IDLE;
        addTaint(animation.getTaint());
        // ---------- Original Method ----------
        //if (mAnimationMode == ANIMATE_OUT) {
            //killMode();
        //}
        //mAnimationMode = ANIMATE_IDLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.816 -0400", hash_original_method = "16FF962612CA0CC38B4765F38064800C", hash_generated_method = "87B148FBA6A6D3270D8BD7F9EEB4C6C1")
    @Override
    public void onAnimationCancel(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(animation.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.817 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "4BE2C3EAC3B10B8BD5CE86F0E3077935")
    @Override
    public void onAnimationRepeat(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(animation.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.817 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "CAF40E2F6CCD5179F3BB3C091F55A466")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2047039129 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2047039129;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.818 -0400", hash_original_method = "237F1A60A9E9685B4EADEDCFF21B9A19", hash_generated_method = "E3B82C9A55E171F0A3F17BEB8A1CC82D")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varC84EC12C0993677C63B7E5F379D6D168_1942183878 = (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
            {
                event.setSource(this);
                event.setClassName(getClass().getName());
                event.setPackageName(getContext().getPackageName());
                event.setContentDescription(mTitle);
            } //End block
            {
                super.onInitializeAccessibilityEvent(event);
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //if (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            //event.setSource(this);
            //event.setClassName(getClass().getName());
            //event.setPackageName(getContext().getPackageName());
            //event.setContentDescription(mTitle);
        //} else {
            //super.onInitializeAccessibilityEvent(event);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.818 -0400", hash_original_field = "739489FAD6929E44E2450E802B918903", hash_generated_field = "C45604C41252B81A800ABE94C507699D")

    private static final String TAG = "ActionBarContextView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.818 -0400", hash_original_field = "AF00BC2BF674D3EFAB3DFBD00DBA4532", hash_generated_field = "2A63476C517D08BD976212871A960624")

    private static final int ANIMATE_IDLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.818 -0400", hash_original_field = "3C1F5798ED90853371F7E27F97227A2D", hash_generated_field = "822EF0AC3705B18FD672B9EE2414E019")

    private static final int ANIMATE_IN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.818 -0400", hash_original_field = "12EBE1750465D044EFC402BA687119AE", hash_generated_field = "1F174DF669D4184CA0C67FB39313E9F2")

    private static final int ANIMATE_OUT = 2;
}

