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
    private CharSequence mTitle;
    private CharSequence mSubtitle;
    private View mClose;
    private View mCustomView;
    private LinearLayout mTitleLayout;
    private TextView mTitleView;
    private TextView mSubtitleView;
    private int mTitleStyleRes;
    private int mSubtitleStyleRes;
    private Drawable mSplitBackground;
    private Animator mCurrentAnimation;
    private boolean mAnimateInOnLayout;
    private int mAnimationMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.875 -0400", hash_original_method = "2EBFD0846938BB846291BE9F4AD94F04", hash_generated_method = "F44C7F7F93AF60DBC7C576268CF2419A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionBarContextView(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.875 -0400", hash_original_method = "43CDEE17F6E403B0B882E0F499365FE4", hash_generated_method = "061E5743B773FB2493983540DFBD0847")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionBarContextView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.actionModeStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.875 -0400", hash_original_method = "19C70EFA7CD06BD307662BD45113B543", hash_generated_method = "45DF5E7AD9223DA3C20A8D6E3B1B2C3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionBarContextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, R.styleable.ActionMode, defStyle, 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.876 -0400", hash_original_method = "B72CC99F1AE7F170915B2F32514E502E", hash_generated_method = "557C076842D7BAB87119015349CF3395")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.876 -0400", hash_original_method = "E552720A78112C3EB9A59B322D8064C9", hash_generated_method = "41282C50A8841942D19110902C79BEC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setSplitActionBar(boolean split) {
        dsTaint.addTaint(split);
        {
            {
                LayoutParams layoutParams;
                layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.MATCH_PARENT);
                {
                    mMenuView = (ActionMenuView) mActionMenuPresenter.getMenuView(this);
                    mMenuView.setBackgroundDrawable(null);
                    ViewGroup oldParent;
                    oldParent = (ViewGroup) mMenuView.getParent();
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
                    ViewGroup oldParent;
                    oldParent = (ViewGroup) mMenuView.getParent();
                    oldParent.removeView(mMenuView);
                    mSplitView.addView(mMenuView, layoutParams);
                } //End block
            } //End block
            super.setSplitActionBar(split);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.876 -0400", hash_original_method = "2AF53FC77EF46E1AB46FFEE70D9B4BD3", hash_generated_method = "BB6582E227FA3D63B10E464E5D338D7C")
    @DSModeled(DSC.SAFE)
    public void setContentHeight(int height) {
        dsTaint.addTaint(height);
        mContentHeight = height;
        // ---------- Original Method ----------
        //mContentHeight = height;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.877 -0400", hash_original_method = "BF35621F736CEABB1B31AE57D0749737", hash_generated_method = "5703BCAB969BDFF2F3CF77F899DA5EC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCustomView(View view) {
        dsTaint.addTaint(view.dsTaint);
        {
            removeView(mCustomView);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.877 -0400", hash_original_method = "211EB79F55FBE601162C52B7DDCEAE29", hash_generated_method = "031A8CE92EEEE9A1FB29D045523C199D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTitle(CharSequence title) {
        dsTaint.addTaint(title);
        initTitle();
        // ---------- Original Method ----------
        //mTitle = title;
        //initTitle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.877 -0400", hash_original_method = "7D9357B6D11390EB60D28E00C6F28FA8", hash_generated_method = "BEF1D4B38AEE0C8D87463EF723E9E0A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSubtitle(CharSequence subtitle) {
        dsTaint.addTaint(subtitle);
        initTitle();
        // ---------- Original Method ----------
        //mSubtitle = subtitle;
        //initTitle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.877 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "7A540A7B0E4496A8FAF388C1F1064A47")
    @DSModeled(DSC.SAFE)
    public CharSequence getTitle() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.878 -0400", hash_original_method = "8334E54E49A430BB5E2CB9D01857CDC7", hash_generated_method = "A3BDF4A264E5596560582BA0B36F537B")
    @DSModeled(DSC.SAFE)
    public CharSequence getSubtitle() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSubtitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.878 -0400", hash_original_method = "790F9E36BA88F469E91A3DDEB8BA7A0E", hash_generated_method = "01E22404EA8C9506B3EF43EA86B9715A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initTitle() {
        {
            LayoutInflater inflater;
            inflater = LayoutInflater.from(getContext());
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
        boolean hasTitle;
        hasTitle = !TextUtils.isEmpty(mTitle);
        boolean hasSubtitle;
        hasSubtitle = !TextUtils.isEmpty(mSubtitle);
        mSubtitleView.setVisibility(hasSubtitle ? VISIBLE : GONE);
        mTitleLayout.setVisibility(hasTitle || hasSubtitle ? VISIBLE : GONE);
        {
            boolean var3A8301BC648C0D99D98FE6154410787A_1636144882 = (mTitleLayout.getParent() == null);
            {
                addView(mTitleLayout);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.879 -0400", hash_original_method = "6CF0CC9D4208F5A3169016F9961CD359", hash_generated_method = "366792EA7D0EB5A04260BC2537B729FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void initForMode(final ActionMode mode) {
        dsTaint.addTaint(mode.dsTaint);
        {
            LayoutInflater inflater;
            inflater = LayoutInflater.from(mContext);
            mClose = inflater.inflate(R.layout.action_mode_close_item, this, false);
            addView(mClose);
        } //End block
        {
            boolean var3F2B07AD129A1B42F4010FDA38D1B689_477278200 = (mClose.getParent() == null);
            {
                addView(mClose);
            } //End block
        } //End collapsed parenthetic
        View closeButton;
        closeButton = mClose.findViewById(R.id.action_mode_close_button);
        closeButton.setOnClickListener(new OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.879 -0400", hash_original_method = "67B70578F0892507CE1943EF7ED1845C", hash_generated_method = "2893EC3CCC99DB1E742991A068ABD51E")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onClick(View v) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(v.dsTaint);
                mode.finish();
                // ---------- Original Method ----------
                //mode.finish();
            }
});
        MenuBuilder menu;
        menu = (MenuBuilder) mode.getMenu();
        {
            mActionMenuPresenter.dismissPopupMenus();
        } //End block
        mActionMenuPresenter = new ActionMenuPresenter(mContext);
        mActionMenuPresenter.setReserveOverflow(true);
        LayoutParams layoutParams;
        layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.879 -0400", hash_original_method = "45A4BF13DB4610A7D54223CBAAD97337", hash_generated_method = "745B8B66475F4A40396395F66FFF9CA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.880 -0400", hash_original_method = "A219535592712D030952E62AEE6B3C28", hash_generated_method = "1F4EA41D6887CB0DF8C3EC659F8BF760")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void finishAnimation() {
        Animator a;
        a = mCurrentAnimation;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.880 -0400", hash_original_method = "2B49C690F775A4BD526B81BD0C8494DB", hash_generated_method = "F8B2017962A97F59AC5932BC0432217E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.880 -0400", hash_original_method = "6ECDD9C0917165AAFEF87E5E5EC8B474", hash_generated_method = "742B95EEA046D1CF9F985793BFACF4A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean showOverflowMenu() {
        {
            boolean varE02B1D76FDCE55870555B6FA38688077_1739621608 = (mActionMenuPresenter.showOverflowMenu());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.showOverflowMenu();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.880 -0400", hash_original_method = "5D05982F33AF24415676BD0317DE2206", hash_generated_method = "3379F23115B0CE6185ED483C658941FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean hideOverflowMenu() {
        {
            boolean var8BAEDFF24230E7488EEC35AEFACB6A9F_866446353 = (mActionMenuPresenter.hideOverflowMenu());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.hideOverflowMenu();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.880 -0400", hash_original_method = "2F838D8CBDDC91E04D7A8F0F52ABF2C8", hash_generated_method = "CBD8C6DC1D701857FFA9513E673659E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isOverflowMenuShowing() {
        {
            boolean varD524E4D1CE3A164128E687BA5686CD0D_1069294462 = (mActionMenuPresenter.isOverflowMenuShowing());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.isOverflowMenuShowing();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.881 -0400", hash_original_method = "73CB5175F40E2B68B8D41267F726F54F", hash_generated_method = "07BB2168AEF660C103ACD2795C99F231")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ViewGroup.LayoutParams var36AF474DCA49F71E6CD166C7DDCFB936_810917995 = (new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        return (ViewGroup.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.881 -0400", hash_original_method = "5C07F753B3F2B1F9F4C858C93EDD71AE", hash_generated_method = "221A48E53342933AE18FF9180FCABF02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        ViewGroup.LayoutParams var9287B1C620FE2FF843157943FFD9C70F_928109624 = (new MarginLayoutParams(getContext(), attrs));
        return (ViewGroup.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new MarginLayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.882 -0400", hash_original_method = "ADE259D11B02655AAFB5EBCEC641AC5E", hash_generated_method = "56C638CB432EF51FE0F3A38A97AC67A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        int widthMode;
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(getClass().getSimpleName() + " can only be used " +
                    "with android:layout_width=\"match_parent\" (or fill_parent)");
        } //End block
        int heightMode;
        heightMode = MeasureSpec.getMode(heightMeasureSpec);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(getClass().getSimpleName() + " can only be used " +
                    "with android:layout_height=\"wrap_content\"");
        } //End block
        int contentWidth;
        contentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int maxHeight;
        maxHeight = mContentHeight;
        maxHeight = MeasureSpec.getSize(heightMeasureSpec);
        int verticalPadding;
        verticalPadding = getPaddingTop() + getPaddingBottom();
        int availableWidth;
        availableWidth = contentWidth - getPaddingLeft() - getPaddingRight();
        int height;
        height = maxHeight - verticalPadding;
        int childSpecHeight;
        childSpecHeight = MeasureSpec.makeMeasureSpec(height, MeasureSpec.AT_MOST);
        {
            availableWidth = measureChildView(mClose, availableWidth, childSpecHeight, 0);
            MarginLayoutParams lp;
            lp = (MarginLayoutParams) mClose.getLayoutParams();
            availableWidth -= lp.leftMargin + lp.rightMargin;
        } //End block
        {
            boolean var1178C40D6B4B3394C757D204E5BDCC27_1747171713 = (mMenuView != null && mMenuView.getParent() == this);
            {
                availableWidth = measureChildView(mMenuView, availableWidth,
                    childSpecHeight, 0);
            } //End block
        } //End collapsed parenthetic
        {
            availableWidth = measureChildView(mTitleLayout, availableWidth, childSpecHeight, 0);
        } //End block
        {
            ViewGroup.LayoutParams lp;
            lp = mCustomView.getLayoutParams();
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
            int measuredHeight;
            measuredHeight = 0;
            int count;
            count = getChildCount();
            {
                int i;
                i = 0;
                {
                    View v;
                    v = getChildAt(i);
                    int paddedViewHeight;
                    paddedViewHeight = v.getMeasuredHeight() + verticalPadding;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.882 -0400", hash_original_method = "1F1E13F5C24EF6D24D9BF3983118D5E2", hash_generated_method = "525B3AFCC19EFF2E8C691F8A9459ABC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Animator makeInAnimation() {
        mClose.setTranslationX(-mClose.getWidth() -
                ((MarginLayoutParams) mClose.getLayoutParams()).leftMargin);
        ObjectAnimator buttonAnimator;
        buttonAnimator = ObjectAnimator.ofFloat(mClose, "translationX", 0);
        buttonAnimator.setDuration(200);
        buttonAnimator.addListener(this);
        buttonAnimator.setInterpolator(new DecelerateInterpolator());
        AnimatorSet set;
        set = new AnimatorSet();
        AnimatorSet.Builder b;
        b = set.play(buttonAnimator);
        {
            int count;
            count = mMenuView.getChildCount();
            {
                {
                    int i, j;
                    i = count - 1;
                    j = 0;
                    {
                        View child;
                        child = mMenuView.getChildAt(i);
                        child.setScaleY(0);
                        ObjectAnimator a;
                        a = ObjectAnimator.ofFloat(child, "scaleY", 0, 1);
                        a.setDuration(100);
                        a.setStartDelay(j * 70);
                        b.with(a);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        return (Animator)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.883 -0400", hash_original_method = "BAA3822313887C49DB18D4BC04440E7E", hash_generated_method = "D52F867A54BD3F93E0BE636A4D97303F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Animator makeOutAnimation() {
        ObjectAnimator buttonAnimator;
        buttonAnimator = ObjectAnimator.ofFloat(mClose, "translationX",
                -mClose.getWidth() - ((MarginLayoutParams) mClose.getLayoutParams()).leftMargin);
        buttonAnimator.setDuration(200);
        buttonAnimator.addListener(this);
        buttonAnimator.setInterpolator(new DecelerateInterpolator());
        AnimatorSet set;
        set = new AnimatorSet();
        AnimatorSet.Builder b;
        b = set.play(buttonAnimator);
        {
            int count;
            count = mMenuView.getChildCount();
            {
                {
                    int i;
                    i = 0;
                    {
                        View child;
                        child = mMenuView.getChildAt(i);
                        child.setScaleY(0);
                        ObjectAnimator a;
                        a = ObjectAnimator.ofFloat(child, "scaleY", 0);
                        a.setDuration(100);
                        a.setStartDelay(i * 70);
                        b.with(a);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        return (Animator)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.883 -0400", hash_original_method = "EAC754957749E93A677F7BF2F54929F7", hash_generated_method = "21FA8AFBDE188938B479D5CCE214491B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
        dsTaint.addTaint(changed);
        int x;
        x = getPaddingLeft();
        int y;
        y = getPaddingTop();
        int contentHeight;
        contentHeight = b - t - getPaddingTop() - getPaddingBottom();
        {
            boolean var8961E9B959AFEC04EA20AF6092DB526E_802117582 = (mClose != null && mClose.getVisibility() != GONE);
            {
                MarginLayoutParams lp;
                lp = (MarginLayoutParams) mClose.getLayoutParams();
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.884 -0400", hash_original_method = "B990D1A680B01C8A5486D22741D7E96B", hash_generated_method = "C15E52C113AB38D8B645FC895A607B2B")
    @DSModeled(DSC.SAFE)
    @Override
    public void onAnimationStart(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(animation.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.884 -0400", hash_original_method = "5DF138862D9EBBC48B8DDB31E593969C", hash_generated_method = "8C43D037D404FB55628627561FB6F307")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onAnimationEnd(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(animation.dsTaint);
        {
            killMode();
        } //End block
        mAnimationMode = ANIMATE_IDLE;
        // ---------- Original Method ----------
        //if (mAnimationMode == ANIMATE_OUT) {
            //killMode();
        //}
        //mAnimationMode = ANIMATE_IDLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.884 -0400", hash_original_method = "16FF962612CA0CC38B4765F38064800C", hash_generated_method = "48C2321585D7270ECEF5AA43CFB95837")
    @DSModeled(DSC.SAFE)
    @Override
    public void onAnimationCancel(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(animation.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.885 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "2D32F9A43E5261B156C7705DA49965D8")
    @DSModeled(DSC.SAFE)
    @Override
    public void onAnimationRepeat(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(animation.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.885 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "B6A28B76ECD4015FD614215B915AB786")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean shouldDelayChildPressedState() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.885 -0400", hash_original_method = "237F1A60A9E9685B4EADEDCFF21B9A19", hash_generated_method = "A363103CFC8DC9DF01AC2FD0E8CB5CC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varC84EC12C0993677C63B7E5F379D6D168_1350360050 = (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
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

    
    private static final String TAG = "ActionBarContextView";
    private static final int ANIMATE_IDLE = 0;
    private static final int ANIMATE_IN = 1;
    private static final int ANIMATE_OUT = 2;
}

