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
    private static String TAG = "ActionBarContextView";
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
    private static int ANIMATE_IDLE = 0;
    private static int ANIMATE_IN = 1;
    private static int ANIMATE_OUT = 2;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.004 -0400", hash_original_method = "2EBFD0846938BB846291BE9F4AD94F04", hash_generated_method = "1164FB406FB49A843C31137E612F8E94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionBarContextView(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.024 -0400", hash_original_method = "43CDEE17F6E403B0B882E0F499365FE4", hash_generated_method = "424E963E939723796D56591E8F444DCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionBarContextView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.actionModeStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.047 -0400", hash_original_method = "19C70EFA7CD06BD307662BD45113B543", hash_generated_method = "96C27729CE712C60DCCD9226E61DE5AB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.062 -0400", hash_original_method = "B72CC99F1AE7F170915B2F32514E502E", hash_generated_method = "37285DBC108A9B45CA6619C5C65F923F")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.090 -0400", hash_original_method = "E552720A78112C3EB9A59B322D8064C9", hash_generated_method = "CA666EE989784C0079ADACEB9E95AF2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setSplitActionBar(boolean split) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.118 -0400", hash_original_method = "2AF53FC77EF46E1AB46FFEE70D9B4BD3", hash_generated_method = "066A4C006BA330C7BA324B50F8D95534")
    @DSModeled(DSC.SAFE)
    public void setContentHeight(int height) {
        dsTaint.addTaint(height);
        mContentHeight = height;
        // ---------- Original Method ----------
        //mContentHeight = height;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.128 -0400", hash_original_method = "BF35621F736CEABB1B31AE57D0749737", hash_generated_method = "CFE3CFF1E4B15532BD654A977502173C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.143 -0400", hash_original_method = "211EB79F55FBE601162C52B7DDCEAE29", hash_generated_method = "4F94B6F82ED9DFF1A31525E301EC88BB")
    @DSModeled(DSC.SAFE)
    public void setTitle(CharSequence title) {
        dsTaint.addTaint(title);
        initTitle();
        // ---------- Original Method ----------
        //mTitle = title;
        //initTitle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.160 -0400", hash_original_method = "7D9357B6D11390EB60D28E00C6F28FA8", hash_generated_method = "B57CA45F7F8B6ECD08E0F38706016902")
    @DSModeled(DSC.SAFE)
    public void setSubtitle(CharSequence subtitle) {
        dsTaint.addTaint(subtitle);
        initTitle();
        // ---------- Original Method ----------
        //mSubtitle = subtitle;
        //initTitle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.177 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "C93F883BAA39D032555C8300A9C50A39")
    @DSModeled(DSC.SAFE)
    public CharSequence getTitle() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.182 -0400", hash_original_method = "8334E54E49A430BB5E2CB9D01857CDC7", hash_generated_method = "CFC3036F4184205A3442A189DF537980")
    @DSModeled(DSC.SAFE)
    public CharSequence getSubtitle() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSubtitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.222 -0400", hash_original_method = "790F9E36BA88F469E91A3DDEB8BA7A0E", hash_generated_method = "B9789D21B016615AF0DC8002305A0043")
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
            boolean var3A8301BC648C0D99D98FE6154410787A_1733395175 = (mTitleLayout.getParent() == null);
            {
                addView(mTitleLayout);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.262 -0400", hash_original_method = "6CF0CC9D4208F5A3169016F9961CD359", hash_generated_method = "21E7434ED35EB59F17682B8A7FE14E95")
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
            boolean var3F2B07AD129A1B42F4010FDA38D1B689_1186738963 = (mClose.getParent() == null);
            {
                addView(mClose);
            } //End block
        } //End collapsed parenthetic
        View closeButton;
        closeButton = mClose.findViewById(R.id.action_mode_close_button);
        closeButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                mode.finish();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.335 -0400", hash_original_method = "45A4BF13DB4610A7D54223CBAAD97337", hash_generated_method = "3C24C497D76CD40AD0F1ED5D97240B4C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.344 -0400", hash_original_method = "A219535592712D030952E62AEE6B3C28", hash_generated_method = "C533E2F1D026600DDC4DD7EF0743B9C5")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.354 -0400", hash_original_method = "2B49C690F775A4BD526B81BD0C8494DB", hash_generated_method = "EFA61A60CBC876190217DE1B10143C6D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.374 -0400", hash_original_method = "6ECDD9C0917165AAFEF87E5E5EC8B474", hash_generated_method = "4B0212F818B99DCD80BBBA034BB59B45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean showOverflowMenu() {
        {
            boolean varE02B1D76FDCE55870555B6FA38688077_1682414582 = (mActionMenuPresenter.showOverflowMenu());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.showOverflowMenu();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.399 -0400", hash_original_method = "5D05982F33AF24415676BD0317DE2206", hash_generated_method = "13E7960C16BC9292F9CEE814D45981D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean hideOverflowMenu() {
        {
            boolean var8BAEDFF24230E7488EEC35AEFACB6A9F_1618393735 = (mActionMenuPresenter.hideOverflowMenu());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.hideOverflowMenu();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.430 -0400", hash_original_method = "2F838D8CBDDC91E04D7A8F0F52ABF2C8", hash_generated_method = "F2246363E6214CD53201A80F583459F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isOverflowMenuShowing() {
        {
            boolean varD524E4D1CE3A164128E687BA5686CD0D_1668916108 = (mActionMenuPresenter.isOverflowMenuShowing());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mActionMenuPresenter != null) {
            //return mActionMenuPresenter.isOverflowMenuShowing();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.465 -0400", hash_original_method = "73CB5175F40E2B68B8D41267F726F54F", hash_generated_method = "25FA016C397C4712B66073CFA8A052FC")
    @DSModeled(DSC.SAFE)
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.471 -0400", hash_original_method = "5C07F753B3F2B1F9F4C858C93EDD71AE", hash_generated_method = "0A0F209124817977B4061CE7FA2E4BCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        ViewGroup.LayoutParams var9287B1C620FE2FF843157943FFD9C70F_1545408806 = (new MarginLayoutParams(getContext(), attrs));
        return (ViewGroup.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new MarginLayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.556 -0400", hash_original_method = "ADE259D11B02655AAFB5EBCEC641AC5E", hash_generated_method = "AF275632CE469335344F781BC8E5CA4D")
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
            boolean var1178C40D6B4B3394C757D204E5BDCC27_1306145883 = (mMenuView != null && mMenuView.getParent() == this);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.626 -0400", hash_original_method = "D2AABA845E73DB17B403309D7405A0B6", hash_generated_method = "76670D8DFC7B8E6548EE0A163BF3EEE7")
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
                        a.setDuration(300);
                        b.with(a);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        return (Animator)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.668 -0400", hash_original_method = "95601D720463BD538058805E1B086090", hash_generated_method = "B20C80CA1276ADBF6F4057F3496D3699")
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
                        a.setDuration(300);
                        b.with(a);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        return (Animator)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.744 -0400", hash_original_method = "EAC754957749E93A677F7BF2F54929F7", hash_generated_method = "B6B71B02F127714C253FC77D77584A7E")
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
            boolean var8961E9B959AFEC04EA20AF6092DB526E_1670198272 = (mClose != null && mClose.getVisibility() != GONE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.769 -0400", hash_original_method = "B990D1A680B01C8A5486D22741D7E96B", hash_generated_method = "055CED28A243DDD2B0445C0C4C3FE2BE")
    @DSModeled(DSC.SAFE)
    @Override
    public void onAnimationStart(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(animation.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.777 -0400", hash_original_method = "5DF138862D9EBBC48B8DDB31E593969C", hash_generated_method = "311005F9D8E09A23F8BC08C5595B4235")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.811 -0400", hash_original_method = "16FF962612CA0CC38B4765F38064800C", hash_generated_method = "1BC0C718FD765BD9EDB80DA5FE6E2332")
    @DSModeled(DSC.SAFE)
    @Override
    public void onAnimationCancel(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(animation.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.836 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "75FF296FC60604A343A82AB9CB8690F0")
    @DSModeled(DSC.SAFE)
    @Override
    public void onAnimationRepeat(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(animation.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:52.991 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "1239C6C76A60BF63BE5F6B305C415611")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean shouldDelayChildPressedState() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:53.037 -0400", hash_original_method = "237F1A60A9E9685B4EADEDCFF21B9A19", hash_generated_method = "66A2854A3975916820D58FD4BD0B7925")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varC84EC12C0993677C63B7E5F379D6D168_804478918 = (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
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

    
}


