package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;





public class ViewAnimator extends FrameLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.160 -0500", hash_original_field = "A4199CA8B30F98AAF67F6FDF10E09266", hash_generated_field = "A4199CA8B30F98AAF67F6FDF10E09266")


    int mWhichChild = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.160 -0500", hash_original_field = "319BF9E49F2FBE9453A9508A3A60521D", hash_generated_field = "319BF9E49F2FBE9453A9508A3A60521D")

    boolean mFirstTime = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.161 -0500", hash_original_field = "11022FC94DBD000AF0F23EE6D44DA07A", hash_generated_field = "11022FC94DBD000AF0F23EE6D44DA07A")


    boolean mAnimateFirstTime = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.162 -0500", hash_original_field = "29299F27489816D586AD948F6D96C9C1", hash_generated_field = "29299F27489816D586AD948F6D96C9C1")


    Animation mInAnimation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.163 -0500", hash_original_field = "9E3A714F1340062D6D1C605D96F85572", hash_generated_field = "9E3A714F1340062D6D1C605D96F85572")

    Animation mOutAnimation;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.164 -0500", hash_original_method = "66F6B937748E2D301A30C8F3ECD323BD", hash_generated_method = "C416DCDEE73239E8D576D62488884402")
    public ViewAnimator(Context context) {
        super(context);
        initViewAnimator(context, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.165 -0500", hash_original_method = "F8EF7A2A27A81BBBD9162F58F1DAF59B", hash_generated_method = "7BAB977C1DC3579243763FE6D1628B34")
    public ViewAnimator(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.ViewAnimator);
        int resource = a.getResourceId(com.android.internal.R.styleable.ViewAnimator_inAnimation, 0);
        if (resource > 0) {
            setInAnimation(context, resource);
        }

        resource = a.getResourceId(com.android.internal.R.styleable.ViewAnimator_outAnimation, 0);
        if (resource > 0) {
            setOutAnimation(context, resource);
        }

        boolean flag = a.getBoolean(com.android.internal.R.styleable.ViewAnimator_animateFirstView, true);
        setAnimateFirstView(flag);

        a.recycle();

        initViewAnimator(context, attrs);
    }

    /**
     * Initialize this {@link ViewAnimator}, possibly setting
     * {@link #setMeasureAllChildren(boolean)} based on {@link FrameLayout} flags.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.166 -0500", hash_original_method = "6B106D21A6B322E95178F19E05B7CE37", hash_generated_method = "52F738E13C11CE8B2A0A08528D976E94")
    private void initViewAnimator(Context context, AttributeSet attrs) {
        if (attrs == null) {
            // For compatibility, always measure children when undefined.
            mMeasureAllChildren = true;
            return;
        }

        // For compatibility, default to measure children, but allow XML
        // attribute to override.
        final TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.FrameLayout);
        final boolean measureAllChildren = a.getBoolean(
                com.android.internal.R.styleable.FrameLayout_measureAllChildren, true);
        setMeasureAllChildren(measureAllChildren);
        a.recycle();
    }

    /**
     * Sets which child view will be displayed.
     *
     * @param whichChild the index of the child view to display
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.166 -0500", hash_original_method = "886E9E30E7E0F1B550AD6251245A0536", hash_generated_method = "85CFFD1038B757B608DC791E7423D275")
    @android.view.RemotableViewMethod
public void setDisplayedChild(int whichChild) {
        mWhichChild = whichChild;
        if (whichChild >= getChildCount()) {
            mWhichChild = 0;
        } else if (whichChild < 0) {
            mWhichChild = getChildCount() - 1;
        }
        boolean hasFocus = getFocusedChild() != null;
        // This will clear old focus if we had it
        showOnly(mWhichChild);
        if (hasFocus) {
            // Try to retake focus if we had it
            requestFocus(FOCUS_FORWARD);
        }
    }

    /**
     * Returns the index of the currently displayed child view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.167 -0500", hash_original_method = "EEFA4D3ABF985412351A1BD0CB5D6161", hash_generated_method = "7CCCB2C258F137F09749CB31D2CA0D0D")
    public int getDisplayedChild() {
        return mWhichChild;
    }

    /**
     * Manually shows the next child.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.168 -0500", hash_original_method = "EFCC34AA69F6F34103211EDFAD5FB56A", hash_generated_method = "C8057A111EAE9FF161EAC71A04735053")
    @android.view.RemotableViewMethod
public void showNext() {
        setDisplayedChild(mWhichChild + 1);
    }

    /**
     * Manually shows the previous child.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.169 -0500", hash_original_method = "F846DD3340718784FB63764FD5BBF0F3", hash_generated_method = "F7A27E564FD03DC11A20DB63764AFE91")
    @android.view.RemotableViewMethod
public void showPrevious() {
        setDisplayedChild(mWhichChild - 1);
    }

    /**
     * Shows only the specified child. The other displays Views exit the screen,
     * optionally with the with the {@link #getOutAnimation() out animation} and
     * the specified child enters the screen, optionally with the
     * {@link #getInAnimation() in animation}.
     *
     * @param childIndex The index of the child to be shown.
     * @param animate Whether or not to use the in and out animations, defaults
     *            to true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.170 -0500", hash_original_method = "821F94AAA9585776C884C184A81B321A", hash_generated_method = "821F94AAA9585776C884C184A81B321A")
    void showOnly(int childIndex, boolean animate) {
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (i == childIndex) {
                if (animate && mInAnimation != null) {
                    child.startAnimation(mInAnimation);
                }
                child.setVisibility(View.VISIBLE);
                mFirstTime = false;
            } else {
                if (animate && mOutAnimation != null && child.getVisibility() == View.VISIBLE) {
                    child.startAnimation(mOutAnimation);
                } else if (child.getAnimation() == mInAnimation)
                    child.clearAnimation();
                child.setVisibility(View.GONE);
            }
        }
    }
    /**
     * Shows only the specified child. The other displays Views exit the screen
     * with the {@link #getOutAnimation() out animation} and the specified child
     * enters the screen with the {@link #getInAnimation() in animation}.
     *
     * @param childIndex The index of the child to be shown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.171 -0500", hash_original_method = "F76460515723C04BD015D3AE7F75A8EE", hash_generated_method = "F76460515723C04BD015D3AE7F75A8EE")
    void showOnly(int childIndex) {
        final boolean animate = (!mFirstTime || mAnimateFirstTime);
        showOnly(childIndex, animate);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.172 -0500", hash_original_method = "B6265928EFB656804D99665538BC6B35", hash_generated_method = "21689BF928C4D8AC7D910941AC2D202D")
    @Override
public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        if (getChildCount() == 1) {
            child.setVisibility(View.VISIBLE);
        } else {
            child.setVisibility(View.GONE);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.173 -0500", hash_original_method = "2876DED6BDEBD13B29080CE11E9063E4", hash_generated_method = "5B940171BCBCAC8BFBD354C9728A6728")
    @Override
public void removeAllViews() {
        super.removeAllViews();
        mWhichChild = 0;
        mFirstTime = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.173 -0500", hash_original_method = "96F6E7BCEF91AFFF9BCD877C8E22A578", hash_generated_method = "4BCEB94DEB3DC069169CB7D5410262B4")
    @Override
public void removeView(View view) {
        final int index = indexOfChild(view);
        if (index >= 0) {
            removeViewAt(index);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.174 -0500", hash_original_method = "39615E53633A229D459BCD129C9447D8", hash_generated_method = "0E14CC5B03390920FF44255802561C36")
    @Override
public void removeViewAt(int index) {
        super.removeViewAt(index);
        final int childCount = getChildCount();
        if (childCount == 0) {
            mWhichChild = 0;
            mFirstTime = true;
        } else if (mWhichChild >= childCount) {
            // Displayed is above child count, so float down to top of stack
            setDisplayedChild(childCount - 1);
        } else if (mWhichChild == index) {
            // Displayed was removed, so show the new child living in its place
            setDisplayedChild(mWhichChild);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.175 -0500", hash_original_method = "E39155B01A3404328E46119B32BA0220", hash_generated_method = "7FAD47F7594FF1176856FB7AA555F7BE")
    public void removeViewInLayout(View view) {
        removeView(view);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.176 -0500", hash_original_method = "E3FA5900F02B916C2065C9EFA9728FDF", hash_generated_method = "51DA4FA06D70978BF94CDC8180B5E391")
    public void removeViews(int start, int count) {
        super.removeViews(start, count);
        if (getChildCount() == 0) {
            mWhichChild = 0;
            mFirstTime = true;
        } else if (mWhichChild >= start && mWhichChild < start + count) {
            // Try showing new displayed child, wrapping if needed
            setDisplayedChild(mWhichChild);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.177 -0500", hash_original_method = "76C75A4C2363189C0B16150C5B7ECE1A", hash_generated_method = "73852041D10B70BBE7FFCA35F7D48BC1")
    public void removeViewsInLayout(int start, int count) {
        removeViews(start, count);
    }

    /**
     * Returns the View corresponding to the currently displayed child.
     *
     * @return The View currently displayed.
     *
     * @see #getDisplayedChild()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.177 -0500", hash_original_method = "844041B2553847C9CC4B36B79F20B7EC", hash_generated_method = "34E1EA694076F22BBF84C85C43E13FE8")
    public View getCurrentView() {
        return getChildAt(mWhichChild);
    }

    /**
     * Returns the current animation used to animate a View that enters the screen.
     *
     * @return An Animation or null if none is set.
     *
     * @see #setInAnimation(android.view.animation.Animation)
     * @see #setInAnimation(android.content.Context, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.178 -0500", hash_original_method = "9649A93AAEAC388E07F52DE503C0F001", hash_generated_method = "FEC2C051AA60B017CF0DB36CB1BCC183")
    public Animation getInAnimation() {
        return mInAnimation;
    }

    /**
     * Specifies the animation used to animate a View that enters the screen.
     *
     * @param inAnimation The animation started when a View enters the screen.
     *
     * @see #getInAnimation()
     * @see #setInAnimation(android.content.Context, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.179 -0500", hash_original_method = "3A3CF51D7EEDC43DA48CCA94EBF1692F", hash_generated_method = "615FE56B69AD0C06A3BDDB2BA5A7DC92")
    public void setInAnimation(Animation inAnimation) {
        mInAnimation = inAnimation;
    }

    /**
     * Returns the current animation used to animate a View that exits the screen.
     *
     * @return An Animation or null if none is set.
     *
     * @see #setOutAnimation(android.view.animation.Animation)
     * @see #setOutAnimation(android.content.Context, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.180 -0500", hash_original_method = "966AEDC04CB1C3738AA44B09B913030C", hash_generated_method = "0A77B9C7F911EA541864D2292977F9DB")
    public Animation getOutAnimation() {
        return mOutAnimation;
    }

    /**
     * Specifies the animation used to animate a View that exit the screen.
     *
     * @param outAnimation The animation started when a View exit the screen.
     *
     * @see #getOutAnimation()
     * @see #setOutAnimation(android.content.Context, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.180 -0500", hash_original_method = "E7C95EC2E63D184B364637DD8AD18F73", hash_generated_method = "2750236BB1A6DFD678E483DE660F74A1")
    public void setOutAnimation(Animation outAnimation) {
        mOutAnimation = outAnimation;
    }

    /**
     * Specifies the animation used to animate a View that enters the screen.
     *
     * @param context The application's environment.
     * @param resourceID The resource id of the animation.
     *
     * @see #getInAnimation()
     * @see #setInAnimation(android.view.animation.Animation)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.181 -0500", hash_original_method = "4B14A90FDB2491821F3B7183A1AB7EB4", hash_generated_method = "025FDCC5D184A99FE1DAAE365D5613F7")
    public void setInAnimation(Context context, int resourceID) {
        setInAnimation(AnimationUtils.loadAnimation(context, resourceID));
    }

    /**
     * Specifies the animation used to animate a View that exit the screen.
     *
     * @param context The application's environment.
     * @param resourceID The resource id of the animation.
     *
     * @see #getOutAnimation()
     * @see #setOutAnimation(android.view.animation.Animation)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.182 -0500", hash_original_method = "C68FA8DD73709498CDF74B32AA0794E0", hash_generated_method = "285D28BB5F2C5F362294AE0F5AA17676")
    public void setOutAnimation(Context context, int resourceID) {
        setOutAnimation(AnimationUtils.loadAnimation(context, resourceID));
    }

    /**
     * Indicates whether the current View should be animated the first time
     * the ViewAnimation is displayed.
     *
     * @param animate True to animate the current View the first time it is displayed,
     *                false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.183 -0500", hash_original_method = "8FC95409534ABC48E92905DC8C518CE2", hash_generated_method = "2161D1636A0BC5F12D5CCB943AE3E97C")
    public void setAnimateFirstView(boolean animate) {
        mAnimateFirstTime = animate;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:56.183 -0500", hash_original_method = "0B91CAAE76789C8A4B2B18C9D0AAF852", hash_generated_method = "BC44695AA42F588274CA96129EE3350B")
    @Override
public int getBaseline() {
        return (getCurrentView() != null) ? getCurrentView().getBaseline() : super.getBaseline();
    }

    
}

