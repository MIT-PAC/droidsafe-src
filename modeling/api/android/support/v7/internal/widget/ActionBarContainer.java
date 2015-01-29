/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.support.v7.internal.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionMode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * This class acts as a container for the action bar view and action mode context views. It applies
 * special styles as needed to help handle animated transitions between them.
 *
 * @hide
 */
public class ActionBarContainer extends FrameLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.597 -0400", hash_original_field = "1B51005004680B9C24C44A86A45D5340", hash_generated_field = "527C228A5C97714BAF48C0C499097913")

    private boolean mIsTransitioning;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.599 -0400", hash_original_field = "AECD1DC215B8C8E1D18642191AAB741A", hash_generated_field = "9D4880558BE8637E2C9BE9C42BC7DB01")

    private View mTabContainer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.603 -0400", hash_original_field = "28B10220967DD5BDA404C6D29C1B3C6E", hash_generated_field = "6CC22F47D8F7AAE7532A872F09B0E534")

    private ActionBarView mActionBarView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.605 -0400", hash_original_field = "1414D97CE5ED674A74A05A07F83AE3BF", hash_generated_field = "0925F2C91F8CBA797C183309FA7634C5")

    private Drawable mBackground;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.607 -0400", hash_original_field = "01D1EECBDE92194373C425872A155AF7", hash_generated_field = "BE3C8909DD0F859198FF64AA78C3183B")

    private Drawable mStackedBackground;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.609 -0400", hash_original_field = "A2559183FE2F41FA2ACFFAAD43DEAB22", hash_generated_field = "EAFF30D2C8DDA41FABEEAF56960F2296")

    private Drawable mSplitBackground;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.611 -0400", hash_original_field = "106BDAB42DAAFB05BFBE71F856D65314", hash_generated_field = "C9CE7D6607EA26E6C12DDA4008F1DC50")

    private boolean mIsSplit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.614 -0400", hash_original_field = "F46CD8F2DCB5B67EB20F386AF0C3EF49", hash_generated_field = "B07E47F3EE2FE730943F4349A2DF3F8F")

    private boolean mIsStacked;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.616 -0400", hash_original_method = "11ADB8FB86182A3641DB27767A9D337F", hash_generated_method = "10AB43CF85BDA56018E50CC1F591270B")
    
public ActionBarContainer(Context context) {
        this(context, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.619 -0400", hash_original_method = "AA760B96123DC47FFFBF3D20BF372346", hash_generated_method = "A88BD72F4184F94DA17628DC414A5B42")
    
public ActionBarContainer(Context context, AttributeSet attrs) {
        super(context, attrs);

        setBackgroundDrawable(null);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.ActionBar);
        mBackground = a.getDrawable(R.styleable.ActionBar_background);
        mStackedBackground = a.getDrawable(
                R.styleable.ActionBar_backgroundStacked);

        if (getId() == R.id.split_action_bar) {
            mIsSplit = true;
            mSplitBackground = a.getDrawable(
                    R.styleable.ActionBar_backgroundSplit);
        }
        a.recycle();

        setWillNotDraw(mIsSplit ? mSplitBackground == null :
                mBackground == null && mStackedBackground == null);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.622 -0400", hash_original_method = "928DF19F16C54A70A78300638B744F8C", hash_generated_method = "EEC045FE01B122DE92085C05BA0CA95C")
    
@Override
    public void onFinishInflate() {
        super.onFinishInflate();
        mActionBarView = (ActionBarView) findViewById(R.id.action_bar);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.624 -0400", hash_original_method = "9228EFD1E4986AEF3CD32311D0C43BFB", hash_generated_method = "5530D4562AA7D496D239E3BDD1E8C68C")
    
public void setPrimaryBackground(Drawable bg) {
        if (mBackground != null) {
            mBackground.setCallback(null);
            unscheduleDrawable(mBackground);
        }
        mBackground = bg;
        if (bg != null) {
            bg.setCallback(this);
        }
        setWillNotDraw(mIsSplit ? mSplitBackground == null :
                mBackground == null && mStackedBackground == null);
        invalidate();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.627 -0400", hash_original_method = "9DEDC72F824E4DF30539209C43650A5D", hash_generated_method = "9EAE1385C76A33EC9306C0D805A91F62")
    
public void setStackedBackground(Drawable bg) {
        if (mStackedBackground != null) {
            mStackedBackground.setCallback(null);
            unscheduleDrawable(mStackedBackground);
        }
        mStackedBackground = bg;
        if (bg != null) {
            bg.setCallback(this);
        }
        setWillNotDraw(mIsSplit ? mSplitBackground == null :
                mBackground == null && mStackedBackground == null);
        invalidate();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.629 -0400", hash_original_method = "85599A854AA5352F33F419A55E445D36", hash_generated_method = "F1A61162B41FB8A069351EA656CE1A24")
    
public void setSplitBackground(Drawable bg) {
        if (mSplitBackground != null) {
            mSplitBackground.setCallback(null);
            unscheduleDrawable(mSplitBackground);
        }
        mSplitBackground = bg;
        if (bg != null) {
            bg.setCallback(this);
        }
        setWillNotDraw(mIsSplit ? mSplitBackground == null :
                mBackground == null && mStackedBackground == null);
        invalidate();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.632 -0400", hash_original_method = "B9F34175E0ABCF8AABA22F6F59E2062A", hash_generated_method = "0C9088265450A9C033E6D10A7A922535")
    
@Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        final boolean isVisible = visibility == VISIBLE;
        if (mBackground != null) mBackground.setVisible(isVisible, false);
        if (mStackedBackground != null) mStackedBackground.setVisible(isVisible, false);
        if (mSplitBackground != null) mSplitBackground.setVisible(isVisible, false);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.634 -0400", hash_original_method = "696C81F4818C26727428F2C272AAD841", hash_generated_method = "689CC5D50AB0798F7E1A91C8F7DDC1B4")
    
@Override
    protected boolean verifyDrawable(Drawable who) {
        return (who == mBackground && !mIsSplit) || (who == mStackedBackground && mIsStacked) ||
                (who == mSplitBackground && mIsSplit) || super.verifyDrawable(who);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.636 -0400", hash_original_method = "86EFD0A1BDC75696AB94459E20F5AB95", hash_generated_method = "8898D199FB7EBE1C56DA57487AD0CDE5")
    
@Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (mBackground != null && mBackground.isStateful()) {
            mBackground.setState(getDrawableState());
        }
        if (mStackedBackground != null && mStackedBackground.isStateful()) {
            mStackedBackground.setState(getDrawableState());
        }
        if (mSplitBackground != null && mSplitBackground.isStateful()) {
            mSplitBackground.setState(getDrawableState());
        }
    }

    /**
     * Set the action bar into a "transitioning" state. While transitioning the bar will block focus
     * and touch from all of its descendants. This prevents the user from interacting with the bar
     * while it is animating in or out.
     *
     * @param isTransitioning true if the bar is currently transitioning, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.639 -0400", hash_original_method = "B47E345D6B402EE0E60D9E3F40581018", hash_generated_method = "D2DCA8A6189C19A60C9747055B8D388A")
    
public void setTransitioning(boolean isTransitioning) {
        mIsTransitioning = isTransitioning;
        setDescendantFocusability(isTransitioning ? FOCUS_BLOCK_DESCENDANTS
                : FOCUS_AFTER_DESCENDANTS);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.642 -0400", hash_original_method = "8E69245395EC81C98ED35F3490421A0A", hash_generated_method = "8AB0F37E57E1B73525ABFAFDCB30E195")
    
@Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mIsTransitioning || super.onInterceptTouchEvent(ev);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.644 -0400", hash_original_method = "FA8EB54F33D4C310829625567514278C", hash_generated_method = "361F2E2DF99BACCBC61C78B1A6B505F9")
    
@Override
    public boolean onTouchEvent(MotionEvent ev) {
        super.onTouchEvent(ev);

        // An action bar always eats touch events.
        return true;
    }

    //@Override
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.647 -0400", hash_original_method = "C475E96AA4DF7AF688F741D516B3262B", hash_generated_method = "AE525F85BF72741B21E7AD272A829605")
    
public boolean onHoverEvent(MotionEvent ev) {
        //super.onHoverEvent(ev);

        // An action bar always eats hover events.
        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.649 -0400", hash_original_method = "03170B741846887ACE1767F41E2626CD", hash_generated_method = "D5D8D96F2D70AB3439828FB89FD2BFE7")
    
public void setTabContainer(ScrollingTabContainerView tabView) {
        if (mTabContainer != null) {
            removeView(mTabContainer);
        }
        mTabContainer = tabView;
        if (tabView != null) {
            addView(tabView);
            final ViewGroup.LayoutParams lp = tabView.getLayoutParams();
            lp.width = LayoutParams.FILL_PARENT;
            lp.height = LayoutParams.WRAP_CONTENT;
            tabView.setAllowCollapse(false);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.651 -0400", hash_original_method = "1563ACF140881C9576C37880F51665C0", hash_generated_method = "CB6FA5FF71485D38A9EA11D975A94D6F")
    
public View getTabContainer() {
        return mTabContainer;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.654 -0400", hash_original_method = "0AAAEED7C8EA3D08CF197AD4F3223B18", hash_generated_method = "CED19F05FF9107949682360295337A74")
    
@Override
    public void onDraw(Canvas canvas) {
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }

        if (mIsSplit) {
            if (mSplitBackground != null) {
                mSplitBackground.draw(canvas);
            }
        } else {
            if (mBackground != null) {
                mBackground.draw(canvas);
            }
            if (mStackedBackground != null && mIsStacked) {
                mStackedBackground.draw(canvas);
            }
        }
    }

    //@Override
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.656 -0400", hash_original_method = "195483BC208A3A4410E3220FCA03E982", hash_generated_method = "B66D2CC10CAE7E8E8163DD7D4A4F6C5B")
    
public ActionMode startActionModeForChild(View child, ActionMode.Callback callback) {
        // No starting an action mode for an action bar child! (Where would it go?)
        return null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.659 -0400", hash_original_method = "6DDCDDC1CF10AAD7AC558AA0C33B8A1E", hash_generated_method = "0DD92311C559EB2B7056A2C685997190")
    
@Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (mActionBarView == null) {
            return;
        }

        final LayoutParams lp = (LayoutParams) mActionBarView.getLayoutParams();
        final int actionBarViewHeight = mActionBarView.isCollapsed() ? 0 :
                mActionBarView.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;

        if (mTabContainer != null && mTabContainer.getVisibility() != GONE) {
            final int mode = MeasureSpec.getMode(heightMeasureSpec);
            if (mode == MeasureSpec.AT_MOST) {
                final int maxHeight = MeasureSpec.getSize(heightMeasureSpec);
                setMeasuredDimension(getMeasuredWidth(),
                        Math.min(actionBarViewHeight + mTabContainer.getMeasuredHeight(),
                                maxHeight));
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.663 -0400", hash_original_method = "AC092925F0481E857936851F387223DF", hash_generated_method = "BCCB0CB9403ECD8209C676D460B2E3DB")
    
@Override
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        final boolean hasTabs = mTabContainer != null && mTabContainer.getVisibility() != GONE;

        if (mTabContainer != null && mTabContainer.getVisibility() != GONE) {
            final int containerHeight = getMeasuredHeight();
            final int tabHeight = mTabContainer.getMeasuredHeight();

            if ((mActionBarView.getDisplayOptions() & ActionBar.DISPLAY_SHOW_HOME) == 0) {
                // Not showing home, put tabs on top.
                final int count = getChildCount();
                for (int i = 0; i < count; i++) {
                    final View child = getChildAt(i);

                    if (child == mTabContainer) {
                        continue;
                    }

                    if (!mActionBarView.isCollapsed()) {
                        child.offsetTopAndBottom(tabHeight);
                    }
                }
                mTabContainer.layout(l, 0, r, tabHeight);
            } else {
                mTabContainer.layout(l, containerHeight - tabHeight, r, containerHeight);
            }
        }

        boolean needsInvalidate = false;
        if (mIsSplit) {
            if (mSplitBackground != null) {
                mSplitBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                needsInvalidate = true;
            }
        } else {
            if (mBackground != null) {
                mBackground.setBounds(mActionBarView.getLeft(), mActionBarView.getTop(),
                        mActionBarView.getRight(), mActionBarView.getBottom());
                needsInvalidate = true;
            }
            if ((mIsStacked = hasTabs && mStackedBackground != null)) {
                mStackedBackground.setBounds(mTabContainer.getLeft(), mTabContainer.getTop(),
                        mTabContainer.getRight(), mTabContainer.getBottom());
                needsInvalidate = true;
            }
        }

        if (needsInvalidate) {
            invalidate();
        }
    }
}
