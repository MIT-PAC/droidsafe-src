package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

public class ViewPropertyAnimator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.811 -0500", hash_original_field = "2393DA295339CE8A5EAF99EBAE1708DF", hash_generated_field = "53FCA486F4B3E72DD422D1A05E64E7D7")

    private static final int NONE           = 0x0000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.814 -0500", hash_original_field = "7168B25EE034846478340206CE8A64F7", hash_generated_field = "1EA0ED90123067FBA25A12B73C3B24A4")

    private static final int TRANSLATION_X  = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.816 -0500", hash_original_field = "97D51246C31A08A6875DE974E88B0AFC", hash_generated_field = "74C6ACDB0AB6198B341013D44626807D")

    private static final int TRANSLATION_Y  = 0x0002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.819 -0500", hash_original_field = "917CFF95D768FA16277282F87A22761B", hash_generated_field = "E676EA8846B5357A39E8D3182B5EE15E")

    private static final int SCALE_X        = 0x0004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.821 -0500", hash_original_field = "730DD21E7BFECD2006497F57BA58B150", hash_generated_field = "08F4E43074CCDA53ECDCF5DD24262BBA")

    private static final int SCALE_Y        = 0x0008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.824 -0500", hash_original_field = "81D254063F85CB581E4E2A755C7D2D91", hash_generated_field = "A0750AAA69331EB7E9646558AD0A02F9")

    private static final int ROTATION       = 0x0010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.826 -0500", hash_original_field = "22D5BA9A03354EB0A3DD293DBEE6B698", hash_generated_field = "159F22271A102CB6FE5DEF638B8BC6A5")

    private static final int ROTATION_X     = 0x0020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.829 -0500", hash_original_field = "D1F5C8225D15B0BBCE3B155E03C80AB9", hash_generated_field = "97534AB067F7E259F67702CF1E739334")

    private static final int ROTATION_Y     = 0x0040;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.832 -0500", hash_original_field = "38B1A35E229DFBDAFA89B64F4817605A", hash_generated_field = "581B8B6FF307BDC6C94C6FBF3BC24EAE")

    private static final int X              = 0x0080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.834 -0500", hash_original_field = "62F01A3489C5E5D94B2E30E0EF92AA2E", hash_generated_field = "55573BD988F03CE9C928861DECD58BE3")

    private static final int Y              = 0x0100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.837 -0500", hash_original_field = "9A3502876F0E06875E8CEB06925B6848", hash_generated_field = "04050B0DAE51D1C9573296CE00EE96EE")

    private static final int ALPHA          = 0x0200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.839 -0500", hash_original_field = "AA5479D90772E462052798FCB9FF1CF5", hash_generated_field = "6B12798A8293494A9A5448AEA6533D12")

    private static final int TRANSFORM_MASK = TRANSLATION_X | TRANSLATION_Y | SCALE_X | SCALE_Y |
            ROTATION | ROTATION_X | ROTATION_Y | X | Y;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.788 -0500", hash_original_field = "6F4F028D1DE9C463F753A80DD0991753", hash_generated_field = "E606D96B6FC531BB030B680E135C95D0")

    private  View mView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.790 -0500", hash_original_field = "CFDA69B4AD03D72FC4B0627E39231164", hash_generated_field = "8BF5222528387AE04CED3C727F9F8865")

    private long mDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.792 -0500", hash_original_field = "9AA2ACD2EDECBE49876E74E81DB0277C", hash_generated_field = "03D5FC9AEBB7D8B90777FF73C31E1A48")

    private boolean mDurationSet = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.795 -0500", hash_original_field = "E2D3DF82FC7132D00FA0FC1CE9572EB9", hash_generated_field = "7C883F9B967B7CFCC6422EEE44FD3782")

    private long mStartDelay = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.797 -0500", hash_original_field = "868B709D95CF1C443670E68B47B1548D", hash_generated_field = "4F4328485D02696A823721721A3E8657")

    private boolean mStartDelaySet = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.799 -0500", hash_original_field = "E4914FA8D762AE766FD60D6E9561C2E8", hash_generated_field = "EACBADF91032ABF3D011EE1B3057F84D")

    private TimeInterpolator mInterpolator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.802 -0500", hash_original_field = "144B6A86852C34CE46CA38D4676EB10A", hash_generated_field = "82B2216AD41FE3E781D6035774E250B3")

    private boolean mInterpolatorSet = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.804 -0500", hash_original_field = "312392A85C9181DFDA9EEDED039AB023", hash_generated_field = "69256070A6B51CD84194DBDA7B561216")

    private Animator.AnimatorListener mListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.806 -0500", hash_original_field = "EC79DECB51FB9D6ABF13209474FA27BD", hash_generated_field = "2F88CB8CE002DBE4EE3C525DE38A44D1")

    private AnimatorEventListener mAnimatorEventListener = new AnimatorEventListener();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.809 -0500", hash_original_field = "245199B04CE5933EE61BB14613CB2F2D", hash_generated_field = "245199B04CE5933EE61BB14613CB2F2D")

    ArrayList<NameValuesHolder> mPendingAnimations = new ArrayList<NameValuesHolder>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.253 -0400", hash_original_field = "E77137B6BB2AC6EED35F93F563E9A9A8", hash_generated_field = "DDAE17988E2F7FE309FFBA8222A2CC64")

    private Runnable mAnimationStarter = new Runnable() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.253 -0400", hash_original_method = "FBB53873B37744AA497F2F82BA93513F", hash_generated_method = "B49121F60C78DA005BF63A708AB544D3")
        @Override
        public void run() {
            startAnimation();
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.862 -0500", hash_original_field = "60350FA44FA98050D47E5954263AB745", hash_generated_field = "8AE0B8099C4E7901C63106A6D931EB1C")

    private HashMap<Animator, PropertyBundle> mAnimatorMap =
            new HashMap<Animator, PropertyBundle>();

    /**
     * Constructor, called by View. This is private by design, as the user should only
     * get a ViewPropertyAnimator by calling View.animate().
     *
     * @param view The View associated with this ViewPropertyAnimator
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.876 -0500", hash_original_method = "684AC817B57804E91C0EF57CA21B86F4", hash_generated_method = "684AC817B57804E91C0EF57CA21B86F4")
    
ViewPropertyAnimator(View view) {
        mView = view;
        view.ensureTransformationInfo();
    }

    /**
     * Sets the duration for the underlying animator that animates the requested properties.
     * By default, the animator uses the default value for ValueAnimator. Calling this method
     * will cause the declared value to be used instead.
     * @param duration The length of ensuing property animations, in milliseconds. The value
     * cannot be negative.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.879 -0500", hash_original_method = "AB53F93DCFA553673F10278B2219DEEA", hash_generated_method = "7DBAE6117C6111F148FBBB4241F58108")
    
public ViewPropertyAnimator setDuration(long duration) {
        if (duration < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    duration);
        }
        mDurationSet = true;
        mDuration = duration;
        return this;
    }

    /**
     * Returns the current duration of property animations. If the duration was set on this
     * object, that value is returned. Otherwise, the default value of the underlying Animator
     * is returned.
     *
     * @see #setDuration(long)
     * @return The duration of animations, in milliseconds.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.881 -0500", hash_original_method = "BFD4BDEC4492EF4D0AE1BFA285B3702C", hash_generated_method = "61ADAD11A07D7EE009448328FC58F753")
    
public long getDuration() {
        if (mDurationSet) {
            return mDuration;
        } else {
            // Just return the default from ValueAnimator, since that's what we'd get if
            // the value has not been set otherwise
            return new ValueAnimator().getDuration();
        }
    }

    /**
     * Returns the current startDelay of property animations. If the startDelay was set on this
     * object, that value is returned. Otherwise, the default value of the underlying Animator
     * is returned.
     *
     * @see #setStartDelay(long)
     * @return The startDelay of animations, in milliseconds.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.884 -0500", hash_original_method = "137A1F44FEDEF7DBAEA1EE8251F82E1F", hash_generated_method = "86DE1BBA23FB944616559989A9C60C16")
    
public long getStartDelay() {
        if (mStartDelaySet) {
            return mStartDelay;
        } else {
            // Just return the default from ValueAnimator (0), since that's what we'd get if
            // the value has not been set otherwise
            return 0;
        }
    }

    /**
     * Sets the startDelay for the underlying animator that animates the requested properties.
     * By default, the animator uses the default value for ValueAnimator. Calling this method
     * will cause the declared value to be used instead.
     * @param startDelay The delay of ensuing property animations, in milliseconds. The value
     * cannot be negative.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.886 -0500", hash_original_method = "55E567100D84151F5304C84C830F2C1B", hash_generated_method = "C859EB205504805BE57D3E4A82E9724F")
    
public ViewPropertyAnimator setStartDelay(long startDelay) {
        if (startDelay < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    startDelay);
        }
        mStartDelaySet = true;
        mStartDelay = startDelay;
        return this;
    }

    /**
     * Sets the interpolator for the underlying animator that animates the requested properties.
     * By default, the animator uses the default interpolator for ValueAnimator. Calling this method
     * will cause the declared object to be used instead.
     * 
     * @param interpolator The TimeInterpolator to be used for ensuing property animations.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.888 -0500", hash_original_method = "995017692E981832E150BE79F0CB8507", hash_generated_method = "9B8BC1A182443290DC992248B4394F1F")
    
public ViewPropertyAnimator setInterpolator(TimeInterpolator interpolator) {
        mInterpolatorSet = true;
        mInterpolator = interpolator;
        return this;
    }

    /**
     * Sets a listener for events in the underlying Animators that run the property
     * animations.
     *
     * @param listener The listener to be called with AnimatorListener events.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.891 -0500", hash_original_method = "D3B983C6B8AF317CF4B7893570C39145", hash_generated_method = "7101A83DA2C3C646CFDF7C01A4888E97")
    
public ViewPropertyAnimator setListener(Animator.AnimatorListener listener) {
        mListener = listener;
        return this;
    }

    /**
     * Starts the currently pending property animations immediately. Calling <code>start()</code>
     * is optional because all animations start automatically at the next opportunity. However,
     * if the animations are needed to start immediately and synchronously (not at the time when
     * the next event is processed by the hierarchy, which is when the animations would begin
     * otherwise), then this method can be used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.893 -0500", hash_original_method = "8C3C0DB6E3E572D598F887EBD1169042", hash_generated_method = "CF84313E0A656F6B37009570B4E262F7")
    
public void start() {
        startAnimation();
    }

    /**
     * Cancels all property animations that are currently running or pending.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.896 -0500", hash_original_method = "504B77AB05B1FC68628CE89848555449", hash_generated_method = "E2D795A20D1D1525950EBC006B172A7F")
    
public void cancel() {
        if (mAnimatorMap.size() > 0) {
            HashMap<Animator, PropertyBundle> mAnimatorMapCopy =
                    (HashMap<Animator, PropertyBundle>)mAnimatorMap.clone();
            Set<Animator> animatorSet = mAnimatorMapCopy.keySet();
            for (Animator runningAnim : animatorSet) {
                runningAnim.cancel();
            }
        }
        mPendingAnimations.clear();
        mView.removeCallbacks(mAnimationStarter);
    }

    /**
     * This method will cause the View's <code>x</code> property to be animated to the
     * specified value. Animations already running on the property will be canceled.
     *
     * @param value The value to be animated to.
     * @see View#setX(float)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.899 -0500", hash_original_method = "8D670697E365032294CEEA6593A27CE4", hash_generated_method = "8803EAAB3918614F1470ED57F6BA48A4")
    
public ViewPropertyAnimator x(float value) {
        animateProperty(X, value);
        return this;
    }

    /**
     * This method will cause the View's <code>x</code> property to be animated by the
     * specified value. Animations already running on the property will be canceled.
     *
     * @param value The amount to be animated by, as an offset from the current value.
     * @see View#setX(float)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.901 -0500", hash_original_method = "2E3B808D4A6B84F6D09D6182416A5594", hash_generated_method = "B6ABE100F1B770B81F87112251BB7552")
    
public ViewPropertyAnimator xBy(float value) {
        animatePropertyBy(X, value);
        return this;
    }

    /**
     * This method will cause the View's <code>y</code> property to be animated to the
     * specified value. Animations already running on the property will be canceled.
     *
     * @param value The value to be animated to.
     * @see View#setY(float)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.903 -0500", hash_original_method = "6AC23ECE2D15FE0B2F16B84D01FE289F", hash_generated_method = "7D5E0FFC8DC0D0D6A5025A88A960BF73")
    
public ViewPropertyAnimator y(float value) {
        animateProperty(Y, value);
        return this;
    }

    /**
     * This method will cause the View's <code>y</code> property to be animated by the
     * specified value. Animations already running on the property will be canceled.
     *
     * @param value The amount to be animated by, as an offset from the current value.
     * @see View#setY(float)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.906 -0500", hash_original_method = "00E84702996DAE91A9CE0634285E6E21", hash_generated_method = "AC914F9D11C14A36E16BA7574B42A713")
    
public ViewPropertyAnimator yBy(float value) {
        animatePropertyBy(Y, value);
        return this;
    }

    /**
     * This method will cause the View's <code>rotation</code> property to be animated to the
     * specified value. Animations already running on the property will be canceled.
     *
     * @param value The value to be animated to.
     * @see View#setRotation(float)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.908 -0500", hash_original_method = "F233DBDEC9778D70C84673F609341CB5", hash_generated_method = "9CB329AE3EF025790988ABFC3D113BCB")
    
public ViewPropertyAnimator rotation(float value) {
        animateProperty(ROTATION, value);
        return this;
    }

    /**
     * This method will cause the View's <code>rotation</code> property to be animated by the
     * specified value. Animations already running on the property will be canceled.
     *
     * @param value The amount to be animated by, as an offset from the current value.
     * @see View#setRotation(float)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.910 -0500", hash_original_method = "64AA9FBA8001BF9E52DBF885273C96E3", hash_generated_method = "D7E16058E00B282DC4DB20DDA6EE65E9")
    
public ViewPropertyAnimator rotationBy(float value) {
        animatePropertyBy(ROTATION, value);
        return this;
    }

    /**
     * This method will cause the View's <code>rotationX</code> property to be animated to the
     * specified value. Animations already running on the property will be canceled.
     *
     * @param value The value to be animated to.
     * @see View#setRotationX(float)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.917 -0500", hash_original_method = "6C5ABF33E117D9BB891BADA4C861CBC2", hash_generated_method = "E6ECDA0BAA469C811EFFB29E67203A65")
    
public ViewPropertyAnimator rotationX(float value) {
        animateProperty(ROTATION_X, value);
        return this;
    }

    /**
     * This method will cause the View's <code>rotationX</code> property to be animated by the
     * specified value. Animations already running on the property will be canceled.
     *
     * @param value The amount to be animated by, as an offset from the current value.
     * @see View#setRotationX(float)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.921 -0500", hash_original_method = "107BE4D9D2AC7B45B56F8331D6FF6E98", hash_generated_method = "78A65A6D3B3DFC71A2A8B778EAFA4C4B")
    
public ViewPropertyAnimator rotationXBy(float value) {
        animatePropertyBy(ROTATION_X, value);
        return this;
    }

    /**
     * This method will cause the View's <code>rotationY</code> property to be animated to the
     * specified value. Animations already running on the property will be canceled.
     *
     * @param value The value to be animated to.
     * @see View#setRotationY(float)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.924 -0500", hash_original_method = "C4C456A89DC44934AFAAB7646D99F320", hash_generated_method = "392043351EF12A33B3D68429B30BAC5F")
    
public ViewPropertyAnimator rotationY(float value) {
        animateProperty(ROTATION_Y, value);
        return this;
    }

    /**
     * This method will cause the View's <code>rotationY</code> property to be animated by the
     * specified value. Animations already running on the property will be canceled.
     *
     * @param value The amount to be animated by, as an offset from the current value.
     * @see View#setRotationY(float)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.926 -0500", hash_original_method = "50D1D865E8418E3E5575CE85EA5530DD", hash_generated_method = "C19551BC9F6E3816DC99167E25922AE8")
    
public ViewPropertyAnimator rotationYBy(float value) {
        animatePropertyBy(ROTATION_Y, value);
        return this;
    }

    /**
     * This method will cause the View's <code>translationX</code> property to be animated to the
     * specified value. Animations already running on the property will be canceled.
     *
     * @param value The value to be animated to.
     * @see View#setTranslationX(float)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.928 -0500", hash_original_method = "6A79DB871F5C4E97C4452F0A1C04756A", hash_generated_method = "F8C3AE05EF7B3B150E7A2CC92E85E9EF")
    
public ViewPropertyAnimator translationX(float value) {
        animateProperty(TRANSLATION_X, value);
        return this;
    }

    /**
     * This method will cause the View's <code>translationX</code> property to be animated by the
     * specified value. Animations already running on the property will be canceled.
     *
     * @param value The amount to be animated by, as an offset from the current value.
     * @see View#setTranslationX(float)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.931 -0500", hash_original_method = "92BE44E9F6280B7AE0D2A8904499350A", hash_generated_method = "5A68C897F2049F6754C8DA6E4CBD57CE")
    
public ViewPropertyAnimator translationXBy(float value) {
        animatePropertyBy(TRANSLATION_X, value);
        return this;
    }

    /**
     * This method will cause the View's <code>translationY</code> property to be animated to the
     * specified value. Animations already running on the property will be canceled.
     *
     * @param value The value to be animated to.
     * @see View#setTranslationY(float)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.933 -0500", hash_original_method = "B250150142DA03B7AD8AE045EB4F7730", hash_generated_method = "5491A0EA98C716E5394E1F17693AAE39")
    
public ViewPropertyAnimator translationY(float value) {
        animateProperty(TRANSLATION_Y, value);
        return this;
    }

    /**
     * This method will cause the View's <code>translationY</code> property to be animated by the
     * specified value. Animations already running on the property will be canceled.
     *
     * @param value The amount to be animated by, as an offset from the current value.
     * @see View#setTranslationY(float)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.935 -0500", hash_original_method = "5605726C555918AA2A627C8B848E7FA1", hash_generated_method = "E02E4656A8BF8A5819A18FD75D369E76")
    
public ViewPropertyAnimator translationYBy(float value) {
        animatePropertyBy(TRANSLATION_Y, value);
        return this;
    }
    
    private static class PropertyBundle {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.848 -0500", hash_original_field = "DD49B26A61D9970E0B1D820803D8F62F", hash_generated_field = "DD49B26A61D9970E0B1D820803D8F62F")

        int mPropertyMask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.851 -0500", hash_original_field = "F20E3CD953F396C43CDD27D3775574C7", hash_generated_field = "F20E3CD953F396C43CDD27D3775574C7")

        ArrayList<NameValuesHolder> mNameValuesHolder;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.855 -0500", hash_original_method = "6483519B8187FEE4E1EA6883A6980FC2", hash_generated_method = "6483519B8187FEE4E1EA6883A6980FC2")
        
PropertyBundle(int propertyMask, ArrayList<NameValuesHolder> nameValuesHolder) {
            mPropertyMask = propertyMask;
            mNameValuesHolder = nameValuesHolder;
        }

        /**
         * Removes the given property from being animated as a part of this
         * PropertyBundle. If the property was a part of this bundle, it returns
         * true to indicate that it was, in fact, canceled. This is an indication
         * to the caller that a cancellation actually occurred.
         *
         * @param propertyConstant The property whose cancellation is requested.
         * @return true if the given property is a part of this bundle and if it
         * has therefore been canceled.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.858 -0500", hash_original_method = "4E1EA61EF3802406B1375FE91CF7D26A", hash_generated_method = "4E1EA61EF3802406B1375FE91CF7D26A")
        
boolean cancel(int propertyConstant) {
            if ((mPropertyMask & propertyConstant) != 0 && mNameValuesHolder != null) {
                int count = mNameValuesHolder.size();
                for (int i = 0; i < count; ++i) {
                    NameValuesHolder nameValuesHolder = mNameValuesHolder.get(i);
                    if (nameValuesHolder.mNameConstant == propertyConstant) {
                        mNameValuesHolder.remove(i);
                        mPropertyMask &= ~propertyConstant;
                        return true;
                    }
                }
            }
            return false;
        }
        
    }
    
    private static class NameValuesHolder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.865 -0500", hash_original_field = "1D2069986089C122C058DF69AE8585A8", hash_generated_field = "1D2069986089C122C058DF69AE8585A8")

        int mNameConstant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.867 -0500", hash_original_field = "E0FB3AD0E73F80DF22AE6663ABA13808", hash_generated_field = "E0FB3AD0E73F80DF22AE6663ABA13808")

        float mFromValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.869 -0500", hash_original_field = "6689A5DB2A8581AB15B0CD1E639E3108", hash_generated_field = "6689A5DB2A8581AB15B0CD1E639E3108")

        float mDeltaValue;
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.872 -0500", hash_original_method = "96CB986053199F9A9E461CA697D4B879", hash_generated_method = "96CB986053199F9A9E461CA697D4B879")
        
NameValuesHolder(int nameConstant, float fromValue, float deltaValue) {
            mNameConstant = nameConstant;
            mFromValue = fromValue;
            mDeltaValue = deltaValue;
        }
        
    }
    
    private class AnimatorEventListener implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.910 -0400", hash_original_method = "583F783AF22881FEE7C79B0EC23630FE", hash_generated_method = "583F783AF22881FEE7C79B0EC23630FE")
        public AnimatorEventListener ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.968 -0500", hash_original_method = "F9860C292F584577E1CB80EC7999B7B9", hash_generated_method = "94405BF74DACAEA756F2C63CB8E1AD26")
        
@Override
        public void onAnimationStart(Animator animation) {
            if (mListener != null) {
                mListener.onAnimationStart(animation);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.971 -0500", hash_original_method = "F7FF3E25F5EB45E2838B85C55C1E6F41", hash_generated_method = "19C146109DCD2A93551256D75BCB162E")
        
@Override
        public void onAnimationCancel(Animator animation) {
            if (mListener != null) {
                mListener.onAnimationCancel(animation);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.973 -0500", hash_original_method = "B115085E9A5CEF09E5F889C8A8B6D805", hash_generated_method = "6DFE6DD9722A4C93607B94FDE9DFD6E7")
        
@Override
        public void onAnimationRepeat(Animator animation) {
            if (mListener != null) {
                mListener.onAnimationRepeat(animation);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.976 -0500", hash_original_method = "A70C7A230A722F778ADFA14D1A0F2C8C", hash_generated_method = "E9B6A639E12047F8A33E13B7AD2FBB51")
        
@Override
        public void onAnimationEnd(Animator animation) {
            if (mListener != null) {
                mListener.onAnimationEnd(animation);
            }
            mAnimatorMap.remove(animation);
        }

        /**
         * Calculate the current value for each property and set it on the view. Invalidate
         * the view object appropriately, depending on which properties are being animated.
         *
         * @param animation The animator associated with the properties that need to be
         * set. This animator holds the animation fraction which we will use to calculate
         * the current value of each property.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.980 -0500", hash_original_method = "DF41E3115CE6BC840253482EC4390D2C", hash_generated_method = "A3BD9EAD3B73D5EA83D6E511CE564A22")
        
@Override
        public void onAnimationUpdate(ValueAnimator animation) {
            // alpha requires slightly different treatment than the other (transform) properties.
            // The logic in setAlpha() is not simply setting mAlpha, plus the invalidation
            // logic is dependent on how the view handles an internal call to onSetAlpha().
            // We track what kinds of properties are set, and how alpha is handled when it is
            // set, and perform the invalidation steps appropriately.
            boolean alphaHandled = false;
            mView.invalidateParentCaches();
            float fraction = animation.getAnimatedFraction();
            PropertyBundle propertyBundle = mAnimatorMap.get(animation);
            int propertyMask = propertyBundle.mPropertyMask;
            if ((propertyMask & TRANSFORM_MASK) != 0) {
                mView.invalidate(false);
            }
            ArrayList<NameValuesHolder> valueList = propertyBundle.mNameValuesHolder;
            if (valueList != null) {
                int count = valueList.size();
                for (int i = 0; i < count; ++i) {
                    NameValuesHolder values = valueList.get(i);
                    float value = values.mFromValue + fraction * values.mDeltaValue;
                    if (values.mNameConstant == ALPHA) {
                        alphaHandled = mView.setAlphaNoInvalidation(value);
                    } else {
                        setValue(values.mNameConstant, value);
                    }
                }
            }
            if ((propertyMask & TRANSFORM_MASK) != 0) {
                mView.mTransformationInfo.mMatrixDirty = true;
                mView.mPrivateFlags |= View.DRAWN; // force another invalidation
            }
            // invalidate(false) in all cases except if alphaHandled gets set to true
            // via the call to setAlphaNoInvalidation(), above
            mView.invalidate(alphaHandled);
        }
        
    }

    /**
     * This method will cause the View's <code>scaleX</code> property to be animated to the
     * specified value. Animations already running on the property will be canceled.
     *
     * @param value The value to be animated to.
     * @see View#setScaleX(float)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.937 -0500", hash_original_method = "D5A33D637AF4590F069926DA61E58388", hash_generated_method = "B8E3AAA6B6FB824F0E8EB9AAF658A379")
    
public ViewPropertyAnimator scaleX(float value) {
        animateProperty(SCALE_X, value);
        return this;
    }

    /**
     * This method will cause the View's <code>scaleX</code> property to be animated by the
     * specified value. Animations already running on the property will be canceled.
     *
     * @param value The amount to be animated by, as an offset from the current value.
     * @see View#setScaleX(float)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.940 -0500", hash_original_method = "631FDEF7985B082E37297CEE1F6072F7", hash_generated_method = "282FA41582C10E3AE571FFC257BAB5FB")
    
public ViewPropertyAnimator scaleXBy(float value) {
        animatePropertyBy(SCALE_X, value);
        return this;
    }

    /**
     * This method will cause the View's <code>scaleY</code> property to be animated to the
     * specified value. Animations already running on the property will be canceled.
     *
     * @param value The value to be animated to.
     * @see View#setScaleY(float)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.942 -0500", hash_original_method = "4F8C4B940AF7AE45F87D198B1B467EBE", hash_generated_method = "1F8B361ECFDD8AC5A25EB4FFFB7BD686")
    
public ViewPropertyAnimator scaleY(float value) {
        animateProperty(SCALE_Y, value);
        return this;
    }

    /**
     * This method will cause the View's <code>scaleY</code> property to be animated by the
     * specified value. Animations already running on the property will be canceled.
     *
     * @param value The amount to be animated by, as an offset from the current value.
     * @see View#setScaleY(float)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.944 -0500", hash_original_method = "966CE83C4778D118E9F221736109C3B2", hash_generated_method = "CCFF9C8F64E2E93D46D30C8FC4C6B355")
    
public ViewPropertyAnimator scaleYBy(float value) {
        animatePropertyBy(SCALE_Y, value);
        return this;
    }

    /**
     * This method will cause the View's <code>alpha</code> property to be animated to the
     * specified value. Animations already running on the property will be canceled.
     *
     * @param value The value to be animated to.
     * @see View#setAlpha(float)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.947 -0500", hash_original_method = "0CB6E06CAEEE818FC3721A3BD57FF4EB", hash_generated_method = "7313943BB1C6B61885A855F50AD7A371")
    
public ViewPropertyAnimator alpha(float value) {
        animateProperty(ALPHA, value);
        return this;
    }

    /**
     * This method will cause the View's <code>alpha</code> property to be animated by the
     * specified value. Animations already running on the property will be canceled.
     *
     * @param value The amount to be animated by, as an offset from the current value.
     * @see View#setAlpha(float)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.949 -0500", hash_original_method = "ECBF15CE25304962FC64383EBA52129F", hash_generated_method = "E2C8F6C46C537B5339E1E5CD392CDBEB")
    
public ViewPropertyAnimator alphaBy(float value) {
        animatePropertyBy(ALPHA, value);
        return this;
    }

    /**
     * Starts the underlying Animator for a set of properties. We use a single animator that
     * simply runs from 0 to 1, and then use that fractional value to set each property
     * value accordingly.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.952 -0500", hash_original_method = "10886573EB8B45FC976B918620A506A6", hash_generated_method = "3FB2942F950847506BC4F36FE2D2B437")
    
private void startAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(1.0f);
        ArrayList<NameValuesHolder> nameValueList =
                (ArrayList<NameValuesHolder>) mPendingAnimations.clone();
        mPendingAnimations.clear();
        int propertyMask = 0;
        int propertyCount = nameValueList.size();
        for (int i = 0; i < propertyCount; ++i) {
            NameValuesHolder nameValuesHolder = nameValueList.get(i);
            propertyMask |= nameValuesHolder.mNameConstant;
        }
        mAnimatorMap.put(animator, new PropertyBundle(propertyMask, nameValueList));
        animator.addUpdateListener(mAnimatorEventListener);
        animator.addListener(mAnimatorEventListener);
        if (mStartDelaySet) {
            animator.setStartDelay(mStartDelay);
        }
        if (mDurationSet) {
            animator.setDuration(mDuration);
        }
        if (mInterpolatorSet) {
            animator.setInterpolator(mInterpolator);
        }
        animator.start();
    }

    /**
     * Utility function, called by the various x(), y(), etc. methods. This stores the
     * constant name for the property along with the from/delta values that will be used to
     * calculate and set the property during the animation. This structure is added to the
     * pending animations, awaiting the eventual start() of the underlying animator. A
     * Runnable is posted to start the animation, and any pending such Runnable is canceled
     * (which enables us to end up starting just one animator for all of the properties
     * specified at one time).
     *
     * @param constantName The specifier for the property being animated
     * @param toValue The value to which the property will animate
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.955 -0500", hash_original_method = "DC6A356EFD140318ADF1C94BF09D3544", hash_generated_method = "10B460DDFDD02DB492A2EE848F66304C")
    
private void animateProperty(int constantName, float toValue) {
        float fromValue = getValue(constantName);
        float deltaValue = toValue - fromValue;
        animatePropertyBy(constantName, fromValue, deltaValue);
    }

    /**
     * Utility function, called by the various xBy(), yBy(), etc. methods. This method is
     * just like animateProperty(), except the value is an offset from the property's
     * current value, instead of an absolute "to" value.
     *
     * @param constantName The specifier for the property being animated
     * @param byValue The amount by which the property will change
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.957 -0500", hash_original_method = "B9FE8E2780DEC5F83DA892CAE9192499", hash_generated_method = "CB7E2A92B217AFDBB96A3BB381AD5B3F")
    
private void animatePropertyBy(int constantName, float byValue) {
        float fromValue = getValue(constantName);
        animatePropertyBy(constantName, fromValue, byValue);
    }

    /**
     * Utility function, called by animateProperty() and animatePropertyBy(), which handles the
     * details of adding a pending animation and posting the request to start the animation.
     *
     * @param constantName The specifier for the property being animated
     * @param startValue The starting value of the property
     * @param byValue The amount by which the property will change
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.959 -0500", hash_original_method = "1BDECA037A3A41B230975E15C12C5086", hash_generated_method = "7946A799974109CAE7A8BC2385A7E3F0")
    
private void animatePropertyBy(int constantName, float startValue, float byValue) {
        // First, cancel any existing animations on this property
        if (mAnimatorMap.size() > 0) {
            Animator animatorToCancel = null;
            Set<Animator> animatorSet = mAnimatorMap.keySet();
            for (Animator runningAnim : animatorSet) {
                PropertyBundle bundle = mAnimatorMap.get(runningAnim);
                if (bundle.cancel(constantName)) {
                    // property was canceled - cancel the animation if it's now empty
                    // Note that it's safe to break out here because every new animation
                    // on a property will cancel a previous animation on that property, so
                    // there can only ever be one such animation running.
                    if (bundle.mPropertyMask == NONE) {
                        // the animation is no longer changing anything - cancel it
                        animatorToCancel = runningAnim;
                        break;
                    }
                }
            }
            if (animatorToCancel != null) {
                animatorToCancel.cancel();
            }
        }

        NameValuesHolder nameValuePair = new NameValuesHolder(constantName, startValue, byValue);
        mPendingAnimations.add(nameValuePair);
        mView.removeCallbacks(mAnimationStarter);
        mView.post(mAnimationStarter);
    }

    /**
     * This method handles setting the property values directly in the View object's fields.
     * propertyConstant tells it which property should be set, value is the value to set
     * the property to.
     *
     * @param propertyConstant The property to be set
     * @param value The value to set the property to
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.962 -0500", hash_original_method = "543199367D6B4536DD4796BA994C91F7", hash_generated_method = "6A583290A1A3C3675A6F487171E2386D")
    
private void setValue(int propertyConstant, float value) {
        final View.TransformationInfo info = mView.mTransformationInfo;
        switch (propertyConstant) {
            case TRANSLATION_X:
                info.mTranslationX = value;
                break;
            case TRANSLATION_Y:
                info.mTranslationY = value;
                break;
            case ROTATION:
                info.mRotation = value;
                break;
            case ROTATION_X:
                info.mRotationX = value;
                break;
            case ROTATION_Y:
                info.mRotationY = value;
                break;
            case SCALE_X:
                info.mScaleX = value;
                break;
            case SCALE_Y:
                info.mScaleY = value;
                break;
            case X:
                info.mTranslationX = value - mView.mLeft;
                break;
            case Y:
                info.mTranslationY = value - mView.mTop;
                break;
            case ALPHA:
                info.mAlpha = value;
                break;
        }
    }

    /**
     * This method gets the value of the named property from the View object.
     *
     * @param propertyConstant The property whose value should be returned
     * @return float The value of the named property
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:27.965 -0500", hash_original_method = "7CFF5C0EAB5A873E8FB7B3F0396E6B5F", hash_generated_method = "2AE1B98D068C1D81669D86104DD87D7A")
    
private float getValue(int propertyConstant) {
        final View.TransformationInfo info = mView.mTransformationInfo;
        switch (propertyConstant) {
            case TRANSLATION_X:
                return info.mTranslationX;
            case TRANSLATION_Y:
                return info.mTranslationY;
            case ROTATION:
                return info.mRotation;
            case ROTATION_X:
                return info.mRotationX;
            case ROTATION_Y:
                return info.mRotationY;
            case SCALE_X:
                return info.mScaleX;
            case SCALE_Y:
                return info.mScaleY;
            case X:
                return mView.mLeft + info.mTranslationX;
            case Y:
                return mView.mTop + info.mTranslationY;
            case ALPHA:
                return info.mAlpha;
        }
        return 0;
    }

}

