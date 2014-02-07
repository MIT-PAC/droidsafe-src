package android.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

public abstract class Animator implements Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.269 -0500", hash_original_field = "3FD42DDC5A574D761F1E8BD3EC073311", hash_generated_field = "3FD42DDC5A574D761F1E8BD3EC073311")

    ArrayList<AnimatorListener> mListeners = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.808 -0400", hash_original_method = "12606DD4E4D75078EE1609D9ED5651A9", hash_generated_method = "12606DD4E4D75078EE1609D9ED5651A9")
    
    public Animator ()
    {
        //Synthesized constructor
    }

    /**
     * Starts this animation. If the animation has a nonzero startDelay, the animation will start
     * running after that delay elapses. A non-delayed animation will have its initial
     * value(s) set immediately, followed by calls to
     * {@link AnimatorListener#onAnimationStart(Animator)} for any listeners of this animator.
     *
     * <p>The animation started by calling this method will be run on the thread that called
     * this method. This thread should have a Looper on it (a runtime exception will be thrown if
     * this is not the case). Also, if the animation will animate
     * properties of objects in the view hierarchy, then the calling thread should be the UI
     * thread for that view hierarchy.</p>
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.271 -0500", hash_original_method = "077E81C30B4BFFEF2F9502DB378CA204", hash_generated_method = "DA898781E1CBA774E3501CFEAD68389F")
    
public void start() {
    }

    /**
     * Cancels the animation. Unlike {@link #end()}, <code>cancel()</code> causes the animation to
     * stop in its tracks, sending an
     * {@link android.animation.Animator.AnimatorListener#onAnimationCancel(Animator)} to
     * its listeners, followed by an
     * {@link android.animation.Animator.AnimatorListener#onAnimationEnd(Animator)} message.
     *
     * <p>This method must be called on the thread that is running the animation.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.273 -0500", hash_original_method = "E5C5DBED2FC0D18DB80484DB83D94F8A", hash_generated_method = "03D37BD64D7EA5A498C29F3157B06CA4")
    
public void cancel() {
    }

    /**
     * Ends the animation. This causes the animation to assign the end value of the property being
     * animated, then calling the
     * {@link android.animation.Animator.AnimatorListener#onAnimationEnd(Animator)} method on
     * its listeners.
     *
     * <p>This method must be called on the thread that is running the animation.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.275 -0500", hash_original_method = "4F105473DD7236D24F8992C8503B57B1", hash_generated_method = "FE6D8DF71959D6F4FDE5F0F03D32C242")
    
public void end() {
    }

    /**
     * The amount of time, in milliseconds, to delay starting the animation after
     * {@link #start()} is called.
     *
     * @return the number of milliseconds to delay running the animation
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.277 -0500", hash_original_method = "A456A6B27B0B6401B5CBF81B119A96B0", hash_generated_method = "FC57DB7F599A90334BED2B9983159634")
    
public abstract long getStartDelay();

    /**
     * The amount of time, in milliseconds, to delay starting the animation after
     * {@link #start()} is called.

     * @param startDelay The amount of the delay, in milliseconds
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.279 -0500", hash_original_method = "D1BDC615F0D6CB689D5A02F46F04F12A", hash_generated_method = "2CA8B335A9269A0A3839B3FA55AEDEF4")
    
public abstract void setStartDelay(long startDelay);

    /**
     * Sets the length of the animation.
     *
     * @param duration The length of the animation, in milliseconds.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.281 -0500", hash_original_method = "82DE27B36BC4484095B14F7E1A297A9F", hash_generated_method = "9880ED4057E2743F5C69F69D7436C09A")
    
public abstract Animator setDuration(long duration);

    /**
     * Gets the length of the animation.
     *
     * @return The length of the animation, in milliseconds.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.284 -0500", hash_original_method = "13809D2532E5FA38EF98BEB630AAB08D", hash_generated_method = "FF9278407590D9A00164135C344715E5")
    
public abstract long getDuration();

    /**
     * The time interpolator used in calculating the elapsed fraction of this animation. The
     * interpolator determines whether the animation runs with linear or non-linear motion,
     * such as acceleration and deceleration. The default value is
     * {@link android.view.animation.AccelerateDecelerateInterpolator}
     *
     * @param value the interpolator to be used by this animation
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.286 -0500", hash_original_method = "ECD218A4FB106B8E45D391E2FCFE38AF", hash_generated_method = "8E1A8C2825A4BD9063900C0EE443C3BD")
    
public abstract void setInterpolator(TimeInterpolator value);

    /**
     * Returns whether this Animator is currently running (having been started and gone past any
     * initial startDelay period and not yet ended).
     *
     * @return Whether the Animator is running.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.288 -0500", hash_original_method = "01F0FE44E71A30E093E481EBA696B87A", hash_generated_method = "6E27EBB5A90EFE7D59D40ADC42E0CBF6")
    
public abstract boolean isRunning();

    /**
     * Returns whether this Animator has been started and not yet ended. This state is a superset
     * of the state of {@link #isRunning()}, because an Animator with a nonzero
     * {@link #getStartDelay() startDelay} will return true for {@link #isStarted()} during the
     * delay phase, whereas {@link #isRunning()} will return true only after the delay phase
     * is complete.
     *
     * @return Whether the Animator has been started and not yet ended.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.290 -0500", hash_original_method = "5FAE51F608329798E727CB5CCA21128D", hash_generated_method = "F5AC37B65A93F3FBD5BB00F5B58D8A73")
    
public boolean isStarted() {
        // Default method returns value for isRunning(). Subclasses should override to return a
        // real value.
        return isRunning();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.833 -0400", hash_original_method = "9023764EFF4F5DD5C344B401D2F44A3C", hash_generated_method = "AF6F7DF4131BFA1F773F940D8B5D8057")
    
    public void addListener(AnimatorListener listener) {
        addTaint(listener.getTaint());
        if(mListeners == null)        
        {
            mListeners = new ArrayList<AnimatorListener>();
        } //End block
        mListeners.add(listener);
        listener.onAnimationCancel(this);
        listener.onAnimationStart(this);
        listener.onAnimationCancel(this);
        listener.onAnimationRepeat(this);
        // ---------- Original Method ----------
        //if (mListeners == null) {
            //mListeners = new ArrayList<AnimatorListener>();
        //}
        //mListeners.add(listener);
    }

    /**
     * Removes a listener from the set listening to this animation.
     *
     * @param listener the listener to be removed from the current set of listeners for this
     *                 animation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.295 -0500", hash_original_method = "AF89FA0687B9630A1A89E59A21836778", hash_generated_method = "562085D41EA94DF7CF8C8CC219EFCA79")
    
public void removeListener(AnimatorListener listener) {
        if (mListeners == null) {
            return;
        }
        mListeners.remove(listener);
        if (mListeners.size() == 0) {
            mListeners = null;
        }
    }

    /**
     * Gets the set of {@link android.animation.Animator.AnimatorListener} objects that are currently
     * listening for events on this <code>Animator</code> object.
     *
     * @return ArrayList<AnimatorListener> The set of listeners.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.297 -0500", hash_original_method = "A0C570F4990D85172FF1B2594590DE80", hash_generated_method = "44544A80D5F91B2783A66E5247A2E8B1")
    
public ArrayList<AnimatorListener> getListeners() {
        return mListeners;
    }

    /**
     * Removes all listeners from this object. This is equivalent to calling
     * <code>getListeners()</code> followed by calling <code>clear()</code> on the
     * returned list of listeners.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.299 -0500", hash_original_method = "9F15C7E7001670487AA27A3E97528F7B", hash_generated_method = "EA064C71E10C4E95A204ACCF55D3C492")
    
public void removeAllListeners() {
        if (mListeners != null) {
            mListeners.clear();
            mListeners = null;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.302 -0500", hash_original_method = "D34181C2AB04F8825A2BE8661E83342B", hash_generated_method = "B7F66985686932E1DF636764C91CD1BA")
    
@Override
    public Animator clone() {
        try {
            final Animator anim = (Animator) super.clone();
            if (mListeners != null) {
                ArrayList<AnimatorListener> oldListeners = mListeners;
                anim.mListeners = new ArrayList<AnimatorListener>();
                int numListeners = oldListeners.size();
                for (int i = 0; i < numListeners; ++i) {
                    anim.mListeners.add(oldListeners.get(i));
                }
            }
            return anim;
        } catch (CloneNotSupportedException e) {
           throw new AssertionError();
        }
    }

    /**
     * This method tells the object to use appropriate information to extract
     * starting values for the animation. For example, a AnimatorSet object will pass
     * this call to its child objects to tell them to set up the values. A
     * ObjectAnimator object will use the information it has about its target object
     * and PropertyValuesHolder objects to get the start values for its properties.
     * An ValueAnimator object will ignore the request since it does not have enough
     * information (such as a target object) to gather these values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.304 -0500", hash_original_method = "32F08DC85010676418427AA8D9A17152", hash_generated_method = "6730FDB6F6254C0B72706150269179FD")
    
public void setupStartValues() {
    }

    /**
     * This method tells the object to use appropriate information to extract
     * ending values for the animation. For example, a AnimatorSet object will pass
     * this call to its child objects to tell them to set up the values. A
     * ObjectAnimator object will use the information it has about its target object
     * and PropertyValuesHolder objects to get the start values for its properties.
     * An ValueAnimator object will ignore the request since it does not have enough
     * information (such as a target object) to gather these values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.306 -0500", hash_original_method = "4E652EB88F78E42C7E65C332BEA7074B", hash_generated_method = "0F36AB957B35647210D5123B32DEBC83")
    
public void setupEndValues() {
    }

    /**
     * Sets the target object whose property will be animated by this animation. Not all subclasses
     * operate on target objects (for example, {@link ValueAnimator}, but this method
     * is on the superclass for the convenience of dealing generically with those subclasses
     * that do handle targets.
     *
     * @param target The object being animated
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.308 -0500", hash_original_method = "0B5C67CA62B433384E1BDDE3EB79AFB5", hash_generated_method = "F29AFE070434CC410DBB0B279E1F6376")
    
public void setTarget(Object target) {
    }
    
    public static interface AnimatorListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSVerified
        void onAnimationStart(Animator animation);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSVerified
        void onAnimationEnd(Animator animation);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSVerified
        void onAnimationCancel(Animator animation);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSVerified
        void onAnimationRepeat(Animator animation);
    }
    
}

