package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.ActionBar;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class ActionBarContainer extends FrameLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.332 -0500", hash_original_field = "1B51005004680B9C24C44A86A45D5340", hash_generated_field = "527C228A5C97714BAF48C0C499097913")

    private boolean mIsTransitioning;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.334 -0500", hash_original_field = "AECD1DC215B8C8E1D18642191AAB741A", hash_generated_field = "9D4880558BE8637E2C9BE9C42BC7DB01")

    private View mTabContainer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.336 -0500", hash_original_field = "28B10220967DD5BDA404C6D29C1B3C6E", hash_generated_field = "6CC22F47D8F7AAE7532A872F09B0E534")

    private ActionBarView mActionBarView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.338 -0500", hash_original_field = "1414D97CE5ED674A74A05A07F83AE3BF", hash_generated_field = "0925F2C91F8CBA797C183309FA7634C5")

    private Drawable mBackground;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.341 -0500", hash_original_field = "01D1EECBDE92194373C425872A155AF7", hash_generated_field = "BE3C8909DD0F859198FF64AA78C3183B")

    private Drawable mStackedBackground;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.343 -0500", hash_original_field = "A2559183FE2F41FA2ACFFAAD43DEAB22", hash_generated_field = "EAFF30D2C8DDA41FABEEAF56960F2296")

    private Drawable mSplitBackground;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.346 -0500", hash_original_field = "106BDAB42DAAFB05BFBE71F856D65314", hash_generated_field = "C9CE7D6607EA26E6C12DDA4008F1DC50")

    private boolean mIsSplit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.348 -0500", hash_original_field = "F46CD8F2DCB5B67EB20F386AF0C3EF49", hash_generated_field = "B07E47F3EE2FE730943F4349A2DF3F8F")

    private boolean mIsStacked;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.350 -0500", hash_original_method = "11ADB8FB86182A3641DB27767A9D337F", hash_generated_method = "10AB43CF85BDA56018E50CC1F591270B")
    
public ActionBarContainer(Context context) {
        this(context, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.353 -0500", hash_original_method = "63748832C1944A3823B0F9894E29E249", hash_generated_method = "D5A536066B5CC5F1C40ADED7CD0C7534")
    
public ActionBarContainer(Context context, AttributeSet attrs) {
        super(context, attrs);

        setBackgroundDrawable(null);

        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.ActionBar);
        mBackground = a.getDrawable(com.android.internal.R.styleable.ActionBar_background);
        mStackedBackground = a.getDrawable(
                com.android.internal.R.styleable.ActionBar_backgroundStacked);

        if (getId() == com.android.internal.R.id.split_action_bar) {
            mIsSplit = true;
            mSplitBackground = a.getDrawable(
                    com.android.internal.R.styleable.ActionBar_backgroundSplit);
        }
        a.recycle();

        setWillNotDraw(mIsSplit ? mSplitBackground == null :
                mBackground == null && mStackedBackground == null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.357 -0500", hash_original_method = "69B88AD6BEB0BE6EF5F88037F33C1F3D", hash_generated_method = "F89B1CC731054EA867FD89E05E091B10")
    
@Override
    public void onFinishInflate() {
        super.onFinishInflate();
        mActionBarView = (ActionBarView) findViewById(com.android.internal.R.id.action_bar);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.359 -0500", hash_original_method = "78385A861A7FDA3897557FA33D96C5EA", hash_generated_method = "F6711A8E97BA6D1BA9EEEC9F9248ADCD")
    
public void setPrimaryBackground(Drawable bg) {
        mBackground = bg;
        invalidate();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.361 -0500", hash_original_method = "D9D97A9D1A3797ABD6FF2A72BC0DD994", hash_generated_method = "CC0D67EEF537D9C1C0688EDF5BBADFAE")
    
public void setStackedBackground(Drawable bg) {
        mStackedBackground = bg;
        invalidate();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.363 -0500", hash_original_method = "EE7203C1470FAC3396749865559F7B8E", hash_generated_method = "C809C7C1FB5906ADBD5FD612A11C03FD")
    
public void setSplitBackground(Drawable bg) {
        mSplitBackground = bg;
        invalidate();
    }

    /**
     * Set the action bar into a "transitioning" state. While transitioning
     * the bar will block focus and touch from all of its descendants. This
     * prevents the user from interacting with the bar while it is animating
     * in or out.
     *
     * @param isTransitioning true if the bar is currently transitioning, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.365 -0500", hash_original_method = "B47E345D6B402EE0E60D9E3F40581018", hash_generated_method = "D2DCA8A6189C19A60C9747055B8D388A")
    
public void setTransitioning(boolean isTransitioning) {
        mIsTransitioning = isTransitioning;
        setDescendantFocusability(isTransitioning ? FOCUS_BLOCK_DESCENDANTS
                : FOCUS_AFTER_DESCENDANTS);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.368 -0500", hash_original_method = "8E69245395EC81C98ED35F3490421A0A", hash_generated_method = "8AB0F37E57E1B73525ABFAFDCB30E195")
    
@Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mIsTransitioning || super.onInterceptTouchEvent(ev);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.371 -0500", hash_original_method = "FA8EB54F33D4C310829625567514278C", hash_generated_method = "361F2E2DF99BACCBC61C78B1A6B505F9")
    
@Override
    public boolean onTouchEvent(MotionEvent ev) {
        super.onTouchEvent(ev);

        // An action bar always eats touch events.
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.374 -0500", hash_original_method = "9A976B5E6EF3A94656A0B6DD07EE34B7", hash_generated_method = "5C13287B406859F1E982F74ED0329F29")
    
@Override
    public boolean onHoverEvent(MotionEvent ev) {
        super.onHoverEvent(ev);

        // An action bar always eats hover events.
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.376 -0500", hash_original_method = "56F3757B297FC41285B5D7002065B92C", hash_generated_method = "C090E7A0234D41F26731DAE1B00436F2")
    
public void setTabContainer(ScrollingTabContainerView tabView) {
        if (mTabContainer != null) {
            removeView(mTabContainer);
        }
        mTabContainer = tabView;
        if (tabView != null) {
            addView(tabView);
            final ViewGroup.LayoutParams lp = tabView.getLayoutParams();
            lp.width = LayoutParams.MATCH_PARENT;
            lp.height = LayoutParams.WRAP_CONTENT;
            tabView.setAllowCollapse(false);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.379 -0500", hash_original_method = "1563ACF140881C9576C37880F51665C0", hash_generated_method = "CB6FA5FF71485D38A9EA11D975A94D6F")
    
public View getTabContainer() {
        return mTabContainer;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.381 -0500", hash_original_method = "643CD56BC30DF4A83018A79008BF6616", hash_generated_method = "157A57E9FC6F7334C65656F9EBF499FE")
    
@Override
    public void onDraw(Canvas canvas) {
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }

        if (mIsSplit) {
            if (mSplitBackground != null) mSplitBackground.draw(canvas);
        } else {
            if (mBackground != null) {
                mBackground.draw(canvas);
            }
            if (mStackedBackground != null && mIsStacked) {
                mStackedBackground.draw(canvas);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.384 -0500", hash_original_method = "195483BC208A3A4410E3220FCA03E982", hash_generated_method = "4B9A59C539024A9D835FE43D1357F222")
    
@Override
    public ActionMode startActionModeForChild(View child, ActionMode.Callback callback) {
        // No starting an action mode for an action bar child! (Where would it go?)
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.387 -0500", hash_original_method = "8D0F26C3446558D3092AD9D990B93994", hash_generated_method = "D18874826F455EE0C3A5248E8EE2BFEA")
    
@Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (mActionBarView == null) return;

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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.391 -0500", hash_original_method = "325ECF81F05468831378A42F90AA0A17", hash_generated_method = "B4537F4B4A682A0ACDF28E662515105C")
    
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

                    if (child == mTabContainer) continue;

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

