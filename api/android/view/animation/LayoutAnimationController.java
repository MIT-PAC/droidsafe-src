package android.view.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Random;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class LayoutAnimationController {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.343 -0500", hash_original_field = "4740D71BCBDAA516D05BBE2DB1309CEA", hash_generated_field = "E859EC909F26DCFC9E7628E48052485C")

    public static final int ORDER_NORMAL  = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.345 -0500", hash_original_field = "8B1535A7501BB93FF5956DB797481363", hash_generated_field = "8AF0E7C910184642E51646CAC9E86C19")

    public static final int ORDER_REVERSE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.348 -0500", hash_original_field = "A4987DC6AD8CB80207CFECE5E52ADF9B", hash_generated_field = "96FD66E505BF01EB19B03EE5BB059919")

    public static final int ORDER_RANDOM  = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.350 -0500", hash_original_field = "B0BB6238A22BA258B707A6C55F86230F", hash_generated_field = "24E67EC6656CB0E8440535D7029988FE")

    protected Animation mAnimation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.352 -0500", hash_original_field = "545E44B16EE6299B0F02940124D4FBEA", hash_generated_field = "2D35EFF44D7BEB70FAD342EC80A5CE7E")

    protected Random mRandomizer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.354 -0500", hash_original_field = "A1326AE9004157E0812422F0F20CD6F9", hash_generated_field = "9557EEC9CBF12937FA6D035BD738A81B")

    protected Interpolator mInterpolator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.356 -0500", hash_original_field = "D3CD8642B181146C60D2B5CCBA523761", hash_generated_field = "40E31E41BFDF10FA2549A57D1E0B2464")

    private float mDelay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.359 -0500", hash_original_field = "F4BD2555E505B5F74392044EEB4F14A1", hash_generated_field = "5491D551C576BD6880788C5897A5BA8A")

    private int mOrder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.361 -0500", hash_original_field = "CFDA69B4AD03D72FC4B0627E39231164", hash_generated_field = "8BF5222528387AE04CED3C727F9F8865")

    private long mDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.363 -0500", hash_original_field = "36B33795FFC885ECAAC56D572445CC57", hash_generated_field = "6858B6909E393C6400B9A7BBD2C111B0")

    private long mMaxDelay;

    /**
     * Creates a new layout animation controller from external resources.
     *
     * @param context the Context the view  group is running in, through which
     *        it can access the resources
     * @param attrs the attributes of the XML tag that is inflating the
     *        layout animation controller
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.366 -0500", hash_original_method = "E3D4984E609CD7A8F1E539254F42C7CB", hash_generated_method = "06B1AB071FC513CEC895DCCCC9494E78")
    
public LayoutAnimationController(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.LayoutAnimation);

        Animation.Description d = Animation.Description.parseValue(
                a.peekValue(com.android.internal.R.styleable.LayoutAnimation_delay));
        mDelay = d.value;

        mOrder = a.getInt(com.android.internal.R.styleable.LayoutAnimation_animationOrder, ORDER_NORMAL);

        int resource = a.getResourceId(com.android.internal.R.styleable.LayoutAnimation_animation, 0);
        if (resource > 0) {
            setAnimation(context, resource);
        }

        resource = a.getResourceId(com.android.internal.R.styleable.LayoutAnimation_interpolator, 0);
        if (resource > 0) {
            setInterpolator(context, resource);
        }

        a.recycle();
    }

    /**
     * Creates a new layout animation controller with a delay of 50%
     * and the specified animation.
     *
     * @param animation the animation to use on each child of the view group
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.368 -0500", hash_original_method = "F5882907CA59BB2AE2BDFE73A922FA4E", hash_generated_method = "B4A836F71336588F640BAABDA130A5C2")
    
public LayoutAnimationController(Animation animation) {
        this(animation, 0.5f);
    }

    /**
     * Creates a new layout animation controller with the specified delay
     * and the specified animation.
     *
     * @param animation the animation to use on each child of the view group
     * @param delay the delay by which each child's animation must be offset
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.371 -0500", hash_original_method = "2D34A90DB159467DA6803B576AE47B5C", hash_generated_method = "D2E47960A2EF00A2F4D85C7CB407FA92")
    
public LayoutAnimationController(Animation animation, float delay) {
        mDelay = delay;
        setAnimation(animation);
    }

    /**
     * Returns the order used to compute the delay of each child's animation.
     *
     * @return one of {@link #ORDER_NORMAL}, {@link #ORDER_REVERSE} or
     *         {@link #ORDER_RANDOM)
     *
     * @attr ref android.R.styleable#LayoutAnimation_animationOrder
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.373 -0500", hash_original_method = "BE8C43C510B8AF8546FEBBAA3EF0F0B1", hash_generated_method = "1910514B82CFF79E9C692B005D1B90F5")
    
public int getOrder() {
        return mOrder;
    }

    /**
     * Sets the order used to compute the delay of each child's animation.
     *
     * @param order one of {@link #ORDER_NORMAL}, {@link #ORDER_REVERSE} or
     *        {@link #ORDER_RANDOM}
     *
     * @attr ref android.R.styleable#LayoutAnimation_animationOrder
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.376 -0500", hash_original_method = "648C96BEF511A58A69E168C40D059B54", hash_generated_method = "3B83676F22CDDF17D01370FBF790EECC")
    
public void setOrder(int order) {
        mOrder = order;
    }

    /**
     * Sets the animation to be run on each child of the view group on which
     * this layout animation controller is .
     *
     * @param context the context from which the animation must be inflated
     * @param resourceID the resource identifier of the animation
     *
     * @see #setAnimation(Animation)
     * @see #getAnimation() 
     *
     * @attr ref android.R.styleable#LayoutAnimation_animation
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.378 -0500", hash_original_method = "DA137DCBF1E5E58EF4425067063E3D6F", hash_generated_method = "4A84A8545ABE4A363E49BE899AA83A33")
    
public void setAnimation(Context context, int resourceID) {
        setAnimation(AnimationUtils.loadAnimation(context, resourceID));
    }

    /**
     * Sets the animation to be run on each child of the view group on which
     * this layout animation controller is .
     *
     * @param animation the animation to run on each child of the view group

     * @see #setAnimation(android.content.Context, int)
     * @see #getAnimation()
     *
     * @attr ref android.R.styleable#LayoutAnimation_animation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.381 -0500", hash_original_method = "B4A74FA6048B5852F1E265E64E11FC0D", hash_generated_method = "9769DE7F2B74144B5DD756755091519C")
    
public void setAnimation(Animation animation) {
        mAnimation = animation;
        mAnimation.setFillBefore(true);
    }

    /**
     * Returns the animation applied to each child of the view group on which
     * this controller is set.
     *
     * @return an {@link android.view.animation.Animation} instance
     *
     * @see #setAnimation(android.content.Context, int)
     * @see #setAnimation(Animation)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.383 -0500", hash_original_method = "DAC4606AD5070B4B7D220BEE34A17978", hash_generated_method = "83A97390DABAB7D0A645F10764265A56")
    
public Animation getAnimation() {
        return mAnimation;
    }

    /**
     * Sets the interpolator used to interpolate the delays between the
     * children.
     *
     * @param context the context from which the interpolator must be inflated
     * @param resourceID the resource identifier of the interpolator
     *
     * @see #getInterpolator()
     * @see #setInterpolator(Interpolator)
     *
     * @attr ref android.R.styleable#LayoutAnimation_interpolator
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.385 -0500", hash_original_method = "66DF0F8C4443D43AC8C0B59FD3C0EE80", hash_generated_method = "20725F66758EF06D9305E35974BCA41F")
    
public void setInterpolator(Context context, int resourceID) {
        setInterpolator(AnimationUtils.loadInterpolator(context, resourceID));
    }

    /**
     * Sets the interpolator used to interpolate the delays between the
     * children.
     *
     * @param interpolator the interpolator
     *
     * @see #getInterpolator()
     * @see #setInterpolator(Interpolator)
     *
     * @attr ref android.R.styleable#LayoutAnimation_interpolator
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.388 -0500", hash_original_method = "7D5A9A852D608ADF508B994526BF9EAC", hash_generated_method = "DF8FD2546DF08BADAB224E60C1A6C2B9")
    
public void setInterpolator(Interpolator interpolator) {
        mInterpolator = interpolator;
    }

    /**
     * Returns the interpolator used to interpolate the delays between the
     * children.
     *
     * @return an {@link android.view.animation.Interpolator}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.390 -0500", hash_original_method = "8AA04851FFB5BE49EA5890940035B142", hash_generated_method = "680BC21A34AFF00E6707D9E25D0C0570")
    
public Interpolator getInterpolator() {
        return mInterpolator;
    }

    /**
     * Returns the delay by which the children's animation are offset. The
     * delay is expressed as a fraction of the animation duration.
     *
     * @return a fraction of the animation duration
     *
     * @see #setDelay(float)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.392 -0500", hash_original_method = "55CD68136127075BB4939DEA602DB451", hash_generated_method = "CAC98EA714B5B10F9AF4D5A4E504278E")
    
public float getDelay() {
        return mDelay;
    }

    /**
     * Sets the delay, as a fraction of the animation duration, by which the
     * children's animations are offset. The general formula is:
     *
     * <pre>
     * child animation delay = child index * delay * animation duration
     * </pre>
     *
     * @param delay a fraction of the animation duration
     *
     * @see #getDelay()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.394 -0500", hash_original_method = "66A46BCEB9C76B70A4A3D1129198A613", hash_generated_method = "97A1D01F33BBBDD00ACFC4609B7E9D9F")
    
public void setDelay(float delay) {
        mDelay = delay;
    }

    /**
     * Indicates whether two children's animations will overlap. Animations
     * overlap when the delay is lower than 100% (or 1.0).
     *
     * @return true if animations will overlap, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.397 -0500", hash_original_method = "C391ED719773BAF357B5BB149771DE74", hash_generated_method = "8D0CAC92E9DA3E6B0A9A91571B01C257")
    
public boolean willOverlap() {
        return mDelay < 1.0f;
    }

    /**
     * Starts the animation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.399 -0500", hash_original_method = "78D31C459A561793AE549A78D34651C2", hash_generated_method = "0CA05712F4F8666F897C8205AE2CDFF4")
    
public void start() {
        mDuration = mAnimation.getDuration();
        mMaxDelay = Long.MIN_VALUE;
        mAnimation.setStartTime(-1);
    }

    /**
     * Returns the animation to be applied to the specified view. The returned
     * animation is delayed by an offset computed according to the information
     * provided by
     * {@link android.view.animation.LayoutAnimationController.AnimationParameters}.
     * This method is called by view groups to obtain the animation to set on
     * a specific child.
     *
     * @param view the view to animate
     * @return an animation delayed by the number of milliseconds returned by
     *         {@link #getDelayForView(android.view.View)}
     *
     * @see #getDelay()
     * @see #setDelay(float)
     * @see #getDelayForView(android.view.View)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.401 -0500", hash_original_method = "96F3EFCD32C49E23FCBCF1FC0105A7B0", hash_generated_method = "038197BB7DC2374258E67AB988B71238")
    
public final Animation getAnimationForView(View view) {
        final long delay = getDelayForView(view) + mAnimation.getStartOffset();
        mMaxDelay = Math.max(mMaxDelay, delay);

        try {
            final Animation animation = mAnimation.clone();
            animation.setStartOffset(delay);
            return animation;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    
    public static class AnimationParameters {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.412 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "21B1DF5337CCD3E0731435FB1361ED67")

        public int count;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.414 -0500", hash_original_field = "8BD524D6245D998B3BBC44EB9313082E", hash_generated_field = "AE1343475DB0F2C28979E182E3B11BCC")

        public int index;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.029 -0400", hash_original_method = "838D907A76D7295751639A8A84C023C1", hash_generated_method = "838D907A76D7295751639A8A84C023C1")
        public AnimationParameters ()
        {
            //Synthesized constructor
        }

    }

    /**
     * Indicates whether the layout animation is over or not. A layout animation
     * is considered done when the animation with the longest delay is done.
     *
     * @return true if all of the children's animations are over, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.404 -0500", hash_original_method = "F6685E165800CF46F16D582CC6341EDA", hash_generated_method = "EABE01545CF26607339D282129CDBAE3")
    
public boolean isDone() {
        return AnimationUtils.currentAnimationTimeMillis() >
                mAnimation.getStartTime() + mMaxDelay + mDuration;
    }

    /**
     * Returns the amount of milliseconds by which the specified view's
     * animation must be delayed or offset. Subclasses should override this
     * method to return a suitable value.
     *
     * This implementation returns <code>child animation delay</code>
     * milliseconds where:
     *
     * <pre>
     * child animation delay = child index * delay
     * </pre>
     *
     * The index is retrieved from the
     * {@link android.view.animation.LayoutAnimationController.AnimationParameters}
     * found in the view's {@link android.view.ViewGroup.LayoutParams}.
     *
     * @param view the view for which to obtain the animation's delay
     * @return a delay in milliseconds
     *
     * @see #getAnimationForView(android.view.View)
     * @see #getDelay()
     * @see #getTransformedIndex(android.view.animation.LayoutAnimationController.AnimationParameters)
     * @see android.view.ViewGroup.LayoutParams
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.406 -0500", hash_original_method = "C5014C66E1BA1577E6F39C7457247B02", hash_generated_method = "D885027E34C7C40BED5461F6A4AD0AFC")
    
protected long getDelayForView(View view) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        AnimationParameters params = lp.layoutAnimationParameters;

        if (params == null) {
            return 0;
        }

        final float delay = mDelay * mAnimation.getDuration();
        final long viewDelay = (long) (getTransformedIndex(params) * delay);
        final float totalDelay = delay * params.count;

        if (mInterpolator == null) {
            mInterpolator = new LinearInterpolator();
        }

        float normalizedDelay = viewDelay / totalDelay;
        normalizedDelay = mInterpolator.getInterpolation(normalizedDelay);

        return (long) (normalizedDelay * totalDelay);
    }

    /**
     * Transforms the index stored in
     * {@link android.view.animation.LayoutAnimationController.AnimationParameters}
     * by the order returned by {@link #getOrder()}. Subclasses should override
     * this method to provide additional support for other types of ordering.
     * This method should be invoked by
     * {@link #getDelayForView(android.view.View)} prior to any computation. 
     *
     * @param params the animation parameters containing the index
     * @return a transformed index
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.408 -0500", hash_original_method = "305795D5C2AE9556CA8D226C9088184E", hash_generated_method = "69B6DC794C1723789F4D43C296352772")
    
protected int getTransformedIndex(AnimationParameters params) {
        switch (getOrder()) {
            case ORDER_REVERSE:
                return params.count - 1 - params.index;
            case ORDER_RANDOM:
                if (mRandomizer == null) {
                    mRandomizer = new Random();
                }
                return (int) (params.count * mRandomizer.nextFloat());
            case ORDER_NORMAL:
            default:
                return params.index;
        }
    }
}

