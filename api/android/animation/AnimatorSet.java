package android.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;






public final class AnimatorSet extends Animator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.634 -0500", hash_original_field = "A85391E1318E9B34A06626338A98E52F", hash_generated_field = "26355D432757D1DCAD1F3A8161B362B0")


    /**
     * Tracks animations currently being played, so that we know what to
     * cancel or end when cancel() or end() is called on this AnimatorSet
     */
    private ArrayList<Animator> mPlayingSet = new ArrayList<Animator>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.636 -0500", hash_original_field = "37F30F9142F390F5CBE079A35E65DCD3", hash_generated_field = "F38E02C0F09CF00758E07C1CC5650AAE")

    private HashMap<Animator, Node> mNodeMap = new HashMap<Animator, Node>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.638 -0500", hash_original_field = "EEBCED0903B78B03542BECF17A6D32DC", hash_generated_field = "1B3148FB5A2450DADCF9B3CB97C1D5E0")

    private ArrayList<Node> mNodes = new ArrayList<Node>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.640 -0500", hash_original_field = "E7E28656A9B6CA739FB2EEA8386D3A1E", hash_generated_field = "E9EC8321AA5FBFA3AD5392BA81212767")

    private ArrayList<Node> mSortedNodes = new ArrayList<Node>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.642 -0500", hash_original_field = "1A6B0537643AF19DB65DD488EA11D01C", hash_generated_field = "85FDA93549065D0B768B7599D0ED4292")

    private boolean mNeedsSort = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.644 -0500", hash_original_field = "58AD0945D207E1633DA082A0109BE7B0", hash_generated_field = "E140240C038E8A4BB9AE350DA570B1A7")


    private AnimatorSetListener mSetListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.646 -0500", hash_original_field = "6D37E5BBEF916EC90B750BBB805CC32B", hash_generated_field = "6D37E5BBEF916EC90B750BBB805CC32B")

    boolean mTerminated = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.648 -0500", hash_original_field = "5D947BF952E8653BAADEA609028A78F9", hash_generated_field = "649FDFAC63847330ACCF3CE36C09777A")

    private boolean mStarted = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.650 -0500", hash_original_field = "E2D3DF82FC7132D00FA0FC1CE9572EB9", hash_generated_field = "7C883F9B967B7CFCC6422EEE44FD3782")

    private long mStartDelay = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.652 -0500", hash_original_field = "DD37764CB31B516F7B13DC689E0CF9FB", hash_generated_field = "0B2CF66D82E234938F59A1069E6EEEDE")

    private ValueAnimator mDelayAnim = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.654 -0500", hash_original_field = "E137364C2497A07E5BDAB91F4168FCF1", hash_generated_field = "ABA7FD90398E04D7CC3ED5D092EFDC6D")

    // simply means that there is no duration set on the AnimatorSet. When a real duration is
    // set, it is passed along to the child animations.
    private long mDuration = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.245 -0400", hash_original_method = "A9DDD8ED58932E64D4F5BE029FA05ABF", hash_generated_method = "A9DDD8ED58932E64D4F5BE029FA05ABF")
    @DSModeled(DSC.SAFE)
    public AnimatorSet ()
    {
        //Synthesized constructor
    }


    /**
     * Sets up this AnimatorSet to play all of the supplied animations at the same time.
     *
     * @param items The animations that will be started simultaneously.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.657 -0500", hash_original_method = "D3DC50F4C11146F18EBEE861B5ED6567", hash_generated_method = "A5CC31577A27EC3514D5249E48B12B5F")
    
public void playTogether(Animator... items) {
        if (items != null) {
            mNeedsSort = true;
            Builder builder = play(items[0]);
            for (int i = 1; i < items.length; ++i) {
                builder.with(items[i]);
            }
        }
    }

    /**
     * Sets up this AnimatorSet to play all of the supplied animations at the same time.
     *
     * @param items The animations that will be started simultaneously.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.659 -0500", hash_original_method = "D25B7AF36D80C3FC72EA4BF2A0177D1E", hash_generated_method = "064165BD6D85884EDB47418B01A2DFE7")
    
public void playTogether(Collection<Animator> items) {
        if (items != null && items.size() > 0) {
            mNeedsSort = true;
            Builder builder = null;
            for (Animator anim : items) {
                if (builder == null) {
                    builder = play(anim);
                } else {
                    builder.with(anim);
                }
            }
        }
    }

    /**
     * Sets up this AnimatorSet to play each of the supplied animations when the
     * previous animation ends.
     *
     * @param items The animations that will be started one after another.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.661 -0500", hash_original_method = "6DD5048753632FED7CFB0FE5E71CCF54", hash_generated_method = "460C761655085089DEC182E4B83DF031")
    
public void playSequentially(Animator... items) {
        if (items != null) {
            mNeedsSort = true;
            if (items.length == 1) {
                play(items[0]);
            } else {
                for (int i = 0; i < items.length - 1; ++i) {
                    play(items[i]).before(items[i+1]);
                }
            }
        }
    }

    /**
     * Sets up this AnimatorSet to play each of the supplied animations when the
     * previous animation ends.
     *
     * @param items The animations that will be started one after another.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.663 -0500", hash_original_method = "2D5A2EE93DC881BBD9D776B2A4798185", hash_generated_method = "9EDBF079BDA4DB6789DFE0B6F4168013")
    
public void playSequentially(List<Animator> items) {
        if (items != null && items.size() > 0) {
            mNeedsSort = true;
            if (items.size() == 1) {
                play(items.get(0));
            } else {
                for (int i = 0; i < items.size() - 1; ++i) {
                    play(items.get(i)).before(items.get(i+1));
                }
            }
        }
    }

    /**
     * Returns the current list of child Animator objects controlled by this
     * AnimatorSet. This is a copy of the internal list; modifications to the returned list
     * will not affect the AnimatorSet, although changes to the underlying Animator objects
     * will affect those objects being managed by the AnimatorSet.
     *
     * @return ArrayList<Animator> The list of child animations of this AnimatorSet.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.665 -0500", hash_original_method = "BD23BC3E594C29615E84753B4F440C27", hash_generated_method = "2D4705973B2649AE7AAEC42728BA3D86")
    
public ArrayList<Animator> getChildAnimations() {
        ArrayList<Animator> childList = new ArrayList<Animator>();
        for (Node node : mNodes) {
            childList.add(node.animation);
        }
        return childList;
    }

    /**
     * Sets the target object for all current {@link #getChildAnimations() child animations}
     * of this AnimatorSet that take targets ({@link ObjectAnimator} and
     * AnimatorSet).
     *
     * @param target The object being animated
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.668 -0500", hash_original_method = "41A215E076D4B9AE460EA29EBF85AEE2", hash_generated_method = "27AD7CDF9DD5695E6D47CA2D34A747AD")
    
@Override
    public void setTarget(Object target) {
        for (Node node : mNodes) {
            Animator animation = node.animation;
            if (animation instanceof AnimatorSet) {
                ((AnimatorSet)animation).setTarget(target);
            } else if (animation instanceof ObjectAnimator) {
                ((ObjectAnimator)animation).setTarget(target);
            }
        }
    }

    /**
     * Sets the TimeInterpolator for all current {@link #getChildAnimations() child animations}
     * of this AnimatorSet.
     *
     * @param interpolator the interpolator to be used by each child animation of this AnimatorSet
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.671 -0500", hash_original_method = "09C40C8100DC4A78048B11834DAF681E", hash_generated_method = "6CF83E1FA49147EC13AF3DF2B95DE7A7")
    
@Override
    public void setInterpolator(TimeInterpolator interpolator) {
        for (Node node : mNodes) {
            node.animation.setInterpolator(interpolator);
        }
    }

    /**
     * This method creates a <code>Builder</code> object, which is used to
     * set up playing constraints. This initial <code>play()</code> method
     * tells the <code>Builder</code> the animation that is the dependency for
     * the succeeding commands to the <code>Builder</code>. For example,
     * calling <code>play(a1).with(a2)</code> sets up the AnimatorSet to play
     * <code>a1</code> and <code>a2</code> at the same time,
     * <code>play(a1).before(a2)</code> sets up the AnimatorSet to play
     * <code>a1</code> first, followed by <code>a2</code>, and
     * <code>play(a1).after(a2)</code> sets up the AnimatorSet to play
     * <code>a2</code> first, followed by <code>a1</code>.
     *
     * <p>Note that <code>play()</code> is the only way to tell the
     * <code>Builder</code> the animation upon which the dependency is created,
     * so successive calls to the various functions in <code>Builder</code>
     * will all refer to the initial parameter supplied in <code>play()</code>
     * as the dependency of the other animations. For example, calling
     * <code>play(a1).before(a2).before(a3)</code> will play both <code>a2</code>
     * and <code>a3</code> when a1 ends; it does not set up a dependency between
     * <code>a2</code> and <code>a3</code>.</p>
     *
     * @param anim The animation that is the dependency used in later calls to the
     * methods in the returned <code>Builder</code> object. A null parameter will result
     * in a null <code>Builder</code> return value.
     * @return Builder The object that constructs the AnimatorSet based on the dependencies
     * outlined in the calls to <code>play</code> and the other methods in the
     * <code>Builder</code object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.673 -0500", hash_original_method = "AC4AA224AE1E479BEEF0C5D37CBA15A0", hash_generated_method = "3DCF4D36A666BA27F229587E9732A3A0")
    
public Builder play(Animator anim) {
        if (anim != null) {
            mNeedsSort = true;
            return new Builder(anim);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>Note that canceling a <code>AnimatorSet</code> also cancels all of the animations that it
     * is responsible for.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.676 -0500", hash_original_method = "E3B1DB55014BC169BEC681899C101562", hash_generated_method = "CAFECE9779AC146D1DA27106A900DD3F")
    
@SuppressWarnings("unchecked")
    @Override
    public void cancel() {
        mTerminated = true;
        if (isStarted()) {
            ArrayList<AnimatorListener> tmpListeners = null;
            if (mListeners != null) {
                tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                for (AnimatorListener listener : tmpListeners) {
                    listener.onAnimationCancel(this);
                }
            }
            if (mDelayAnim != null && mDelayAnim.isRunning()) {
                // If we're currently in the startDelay period, just cancel that animator and
                // send out the end event to all listeners
                mDelayAnim.cancel();
            } else  if (mSortedNodes.size() > 0) {
                for (Node node : mSortedNodes) {
                    node.animation.cancel();
                }
            }
            if (tmpListeners != null) {
                for (AnimatorListener listener : tmpListeners) {
                    listener.onAnimationEnd(this);
                }
            }
            mStarted = false;
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>Note that ending a <code>AnimatorSet</code> also ends all of the animations that it is
     * responsible for.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.678 -0500", hash_original_method = "B4B8C3285FA05F4223F7D939EA476CBE", hash_generated_method = "2105C97AD37997EB864971AE97A9FDC3")
    
@Override
    public void end() {
        mTerminated = true;
        if (isStarted()) {
            if (mSortedNodes.size() != mNodes.size()) {
                // hasn't been started yet - sort the nodes now, then end them
                sortNodes();
                for (Node node : mSortedNodes) {
                    if (mSetListener == null) {
                        mSetListener = new AnimatorSetListener(this);
                    }
                    node.animation.addListener(mSetListener);
                }
            }
            if (mDelayAnim != null) {
                mDelayAnim.cancel();
            }
            if (mSortedNodes.size() > 0) {
                for (Node node : mSortedNodes) {
                    node.animation.end();
                }
            }
            if (mListeners != null) {
                ArrayList<AnimatorListener> tmpListeners =
                        (ArrayList<AnimatorListener>) mListeners.clone();
                for (AnimatorListener listener : tmpListeners) {
                    listener.onAnimationEnd(this);
                }
            }
            mStarted = false;
        }
    }

    /**
     * Returns true if any of the child animations of this AnimatorSet have been started and have
     * not yet ended.
     * @return Whether this AnimatorSet has been started and has not yet ended.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.681 -0500", hash_original_method = "0B0086D752673B320D1D01C156228A84", hash_generated_method = "64AAB4F0D519A645CBCFD026AD22AEF2")
    
@Override
    public boolean isRunning() {
        for (Node node : mNodes) {
            if (node.animation.isRunning()) {
                return true;
            }
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.683 -0500", hash_original_method = "4FF549E03853BC8FE3FDFAEBF99B8097", hash_generated_method = "74F3C4B165A06023C52C175EA20DD728")
    
@Override
    public boolean isStarted() {
        return mStarted;
    }

    /**
     * The amount of time, in milliseconds, to delay starting the animation after
     * {@link #start()} is called.
     *
     * @return the number of milliseconds to delay running the animation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.685 -0500", hash_original_method = "36807B48FC1321C96D3D559AECDD954B", hash_generated_method = "ADFAEA717F81E2F47389FF62E9B3E4EF")
    
@Override
    public long getStartDelay() {
        return mStartDelay;
    }

    /**
     * The amount of time, in milliseconds, to delay starting the animation after
     * {@link #start()} is called.

     * @param startDelay The amount of the delay, in milliseconds
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.687 -0500", hash_original_method = "9B89801AA661B38F8303A0C7891B0195", hash_generated_method = "A8A6CF41BA549543CA93D43B3715D406")
    
@Override
    public void setStartDelay(long startDelay) {
        mStartDelay = startDelay;
    }

    /**
     * Gets the length of each of the child animations of this AnimatorSet. This value may
     * be less than 0, which indicates that no duration has been set on this AnimatorSet
     * and each of the child animations will use their own duration.
     *
     * @return The length of the animation, in milliseconds, of each of the child
     * animations of this AnimatorSet.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.690 -0500", hash_original_method = "5E13B5E872677B59408FA3E6BB94A9F6", hash_generated_method = "D26D7CF613CC4D9C0140800DFCFE09CB")
    
@Override
    public long getDuration() {
        return mDuration;
    }

    /**
     * Sets the length of each of the current child animations of this AnimatorSet. By default,
     * each child animation will use its own duration. If the duration is set on the AnimatorSet,
     * then each child animation inherits this duration.
     *
     * @param duration The length of the animation, in milliseconds, of each of the child
     * animations of this AnimatorSet.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.692 -0500", hash_original_method = "617F429F7C8E2B81C3248DA9CF3C7537", hash_generated_method = "8228A6A9CBC63BE0365F0B5A931119F4")
    
@Override
    public AnimatorSet setDuration(long duration) {
        if (duration < 0) {
            throw new IllegalArgumentException("duration must be a value of zero or greater");
        }
        for (Node node : mNodes) {
            // TODO: don't set the duration of the timing-only nodes created by AnimatorSet to
            // insert "play-after" delays
            node.animation.setDuration(duration);
        }
        mDuration = duration;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.695 -0500", hash_original_method = "354AE2554D427EB20F769441D86A2B8E", hash_generated_method = "2D91A91C1A9C3060FEB1091F7962ADCB")
    
@Override
    public void setupStartValues() {
        for (Node node : mNodes) {
            node.animation.setupStartValues();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.697 -0500", hash_original_method = "E9CD39B5113CBC59DEA2E6258E1C2EDB", hash_generated_method = "AF598208125562DEF99D5E00238547C8")
    
@Override
    public void setupEndValues() {
        for (Node node : mNodes) {
            node.animation.setupEndValues();
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.352 -0400", hash_original_method = "BC0D581AF5A0D28CE21AB6B82F02A4C9", hash_generated_method = "9F6799C08C8007AC04C3BA424C228110")
    @SuppressWarnings("unchecked")
    @Override
    public void start() {
        mTerminated = false;
        mStarted = true;
        sortNodes();
        int numSortedNodes = mSortedNodes.size();
for(int i = 0;i < numSortedNodes;++i)
        {
            Node node = mSortedNodes.get(i);
            ArrayList<AnimatorListener> oldListeners = node.animation.getListeners();
            if(oldListeners != null && oldListeners.size() > 0)            
            {
                final ArrayList<AnimatorListener> clonedListeners = new
                        ArrayList<AnimatorListener>(oldListeners);
for(AnimatorListener listener : clonedListeners)
                {
                    if(listener instanceof DependencyListener ||
                            listener instanceof AnimatorSetListener)                    
                    {
                        node.animation.removeListener(listener);
                    } //End block
                } //End block
            } //End block
        } //End block
        final ArrayList<Node> nodesToStart = new ArrayList<Node>();
for(int i = 0;i < numSortedNodes;++i)
        {
            Node node = mSortedNodes.get(i);
            if(mSetListener == null)            
            {
                mSetListener = new AnimatorSetListener(this);
            } //End block
            if(node.dependencies == null || node.dependencies.size() == 0)            
            {
                nodesToStart.add(node);
            } //End block
            else
            {
                int numDependencies = node.dependencies.size();
for(int j = 0;j < numDependencies;++j)
                {
                    Dependency dependency = node.dependencies.get(j);
                    dependency.node.animation.addListener(
                            new DependencyListener(this, node, dependency.rule));
                } //End block
                node.tmpDependencies = (ArrayList<Dependency>) node.dependencies.clone();
            } //End block
            node.animation.addListener(mSetListener);
        } //End block
        if(mStartDelay <= 0)        
        {
for(Node node : nodesToStart)
            {
                node.animation.start();
                mPlayingSet.add(node.animation);
            } //End block
        } //End block
        else
        {
            mDelayAnim = ValueAnimator.ofFloat(0f, 1f);
            mDelayAnim.setDuration(mStartDelay);
            mDelayAnim.addListener(new AnimatorListenerAdapter() {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.700 -0500", hash_original_field = "41402EB62AB9E9D5CBE01FDA6E9433EB", hash_generated_field = "41402EB62AB9E9D5CBE01FDA6E9433EB")

                boolean canceled = false;
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.703 -0500", hash_original_method = "BE87F1813CBA8EA740D5C2234F834512", hash_generated_method = "7149ADECECF3E92DB5F910921E75A473")
                
public void onAnimationCancel(Animator anim) {
                    canceled = true;
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.705 -0500", hash_original_method = "445AE985C63B218AFF9EAABB75FAC581", hash_generated_method = "664D233B6FD238017DE3054CF0A6B711")
                
public void onAnimationEnd(Animator anim) {
                    if (!canceled) {
                        int numNodes = nodesToStart.size();
                        for (int i = 0; i < numNodes; ++i) {
                            Node node = nodesToStart.get(i);
                            node.animation.start();
                            mPlayingSet.add(node.animation);
                        }
                    }
                }
});
            mDelayAnim.start();
        } //End block
        if(mListeners != null)        
        {
            ArrayList<AnimatorListener> tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
            int numListeners = tmpListeners.size();
for(int i = 0;i < numListeners;++i)
            {
                tmpListeners.get(i).onAnimationStart(this);
            } //End block
        } //End block
        if(mNodes.size() == 0 && mStartDelay == 0)        
        {
            mStarted = false;
            if(mListeners != null)            
            {
                ArrayList<AnimatorListener> tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                int numListeners = tmpListeners.size();
for(int i = 0;i < numListeners;++i)
                {
                    tmpListeners.get(i).onAnimationEnd(this);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.713 -0500", hash_original_method = "7A64C2F75A97591C0B8FCD807815163D", hash_generated_method = "377B01EB02D8964A0ECED92BA5917252")
    
@Override
    public AnimatorSet clone() {
        final AnimatorSet anim = (AnimatorSet) super.clone();
        /*
         * The basic clone() operation copies all items. This doesn't work very well for
         * AnimatorSet, because it will copy references that need to be recreated and state
         * that may not apply. What we need to do now is put the clone in an uninitialized
         * state, with fresh, empty data structures. Then we will build up the nodes list
         * manually, as we clone each Node (and its animation). The clone will then be sorted,
         * and will populate any appropriate lists, when it is started.
         */
        anim.mNeedsSort = true;
        anim.mTerminated = false;
        anim.mStarted = false;
        anim.mPlayingSet = new ArrayList<Animator>();
        anim.mNodeMap = new HashMap<Animator, Node>();
        anim.mNodes = new ArrayList<Node>();
        anim.mSortedNodes = new ArrayList<Node>();

        // Walk through the old nodes list, cloning each node and adding it to the new nodemap.
        // One problem is that the old node dependencies point to nodes in the old AnimatorSet.
        // We need to track the old/new nodes in order to reconstruct the dependencies in the clone.
        HashMap<Node, Node> nodeCloneMap = new HashMap<Node, Node>(); // <old, new>
        for (Node node : mNodes) {
            Node nodeClone = node.clone();
            nodeCloneMap.put(node, nodeClone);
            anim.mNodes.add(nodeClone);
            anim.mNodeMap.put(nodeClone.animation, nodeClone);
            // Clear out the dependencies in the clone; we'll set these up manually later
            nodeClone.dependencies = null;
            nodeClone.tmpDependencies = null;
            nodeClone.nodeDependents = null;
            nodeClone.nodeDependencies = null;
            // clear out any listeners that were set up by the AnimatorSet; these will
            // be set up when the clone's nodes are sorted
            ArrayList<AnimatorListener> cloneListeners = nodeClone.animation.getListeners();
            if (cloneListeners != null) {
                ArrayList<AnimatorListener> listenersToRemove = null;
                for (AnimatorListener listener : cloneListeners) {
                    if (listener instanceof AnimatorSetListener) {
                        if (listenersToRemove == null) {
                            listenersToRemove = new ArrayList<AnimatorListener>();
                        }
                        listenersToRemove.add(listener);
                    }
                }
                if (listenersToRemove != null) {
                    for (AnimatorListener listener : listenersToRemove) {
                        cloneListeners.remove(listener);
                    }
                }
            }
        }
        // Now that we've cloned all of the nodes, we're ready to walk through their
        // dependencies, mapping the old dependencies to the new nodes
        for (Node node : mNodes) {
            Node nodeClone = nodeCloneMap.get(node);
            if (node.dependencies != null) {
                for (Dependency dependency : node.dependencies) {
                    Node clonedDependencyNode = nodeCloneMap.get(dependency.node);
                    Dependency cloneDependency = new Dependency(clonedDependencyNode,
                            dependency.rule);
                    nodeClone.addDependency(cloneDependency);
                }
            }
        }

        return anim;
    }

    /**
     * This method sorts the current set of nodes, if needed. The sort is a simple
     * DependencyGraph sort, which goes like this:
     * - All nodes without dependencies become 'roots'
     * - while roots list is not null
     * -   for each root r
     * -     add r to sorted list
     * -     remove r as a dependency from any other node
     * -   any nodes with no dependencies are added to the roots list
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.758 -0500", hash_original_method = "FF30C4A715862D404FA915E9EED652EB", hash_generated_method = "E4CCE78079DEBE872337D58AF3DC982E")
    
private void sortNodes() {
        if (mNeedsSort) {
            mSortedNodes.clear();
            ArrayList<Node> roots = new ArrayList<Node>();
            int numNodes = mNodes.size();
            for (int i = 0; i < numNodes; ++i) {
                Node node = mNodes.get(i);
                if (node.dependencies == null || node.dependencies.size() == 0) {
                    roots.add(node);
                }
            }
            ArrayList<Node> tmpRoots = new ArrayList<Node>();
            while (roots.size() > 0) {
                int numRoots = roots.size();
                for (int i = 0; i < numRoots; ++i) {
                    Node root = roots.get(i);
                    mSortedNodes.add(root);
                    if (root.nodeDependents != null) {
                        int numDependents = root.nodeDependents.size();
                        for (int j = 0; j < numDependents; ++j) {
                            Node node = root.nodeDependents.get(j);
                            node.nodeDependencies.remove(root);
                            if (node.nodeDependencies.size() == 0) {
                                tmpRoots.add(node);
                            }
                        }
                    }
                }
                roots.clear();
                roots.addAll(tmpRoots);
                tmpRoots.clear();
            }
            mNeedsSort = false;
            if (mSortedNodes.size() != mNodes.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist"
                        + " in AnimatorSet");
            }
        } else {
            // Doesn't need sorting, but still need to add in the nodeDependencies list
            // because these get removed as the event listeners fire and the dependencies
            // are satisfied
            int numNodes = mNodes.size();
            for (int i = 0; i < numNodes; ++i) {
                Node node = mNodes.get(i);
                if (node.dependencies != null && node.dependencies.size() > 0) {
                    int numDependencies = node.dependencies.size();
                    for (int j = 0; j < numDependencies; ++j) {
                        Dependency dependency = node.dependencies.get(j);
                        if (node.nodeDependencies == null) {
                            node.nodeDependencies = new ArrayList<Node>();
                        }
                        if (!node.nodeDependencies.contains(dependency.node)) {
                            node.nodeDependencies.add(dependency.node);
                        }
                    }
                }
                // nodes are 'done' by default; they become un-done when started, and done
                // again when ended
                node.done = false;
            }
        }
    }

    
    private static class DependencyListener implements AnimatorListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.716 -0500", hash_original_field = "D714D2C5468EB747703A2C0F7E744D58", hash_generated_field = "26BB44EB69421663EACF2A18D0E63EFE")


        private AnimatorSet mAnimatorSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.718 -0500", hash_original_field = "83519156A5C550DBE6FE5C6058996232", hash_generated_field = "298BE469E9769EF16537BF922B91FDA5")

        private Node mNode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.721 -0500", hash_original_field = "5A0D2303621D2D5EDE0962DD27ECBCFA", hash_generated_field = "58A556ABADA5D390372DA081E073F444")

        // the node
        private int mRule;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.723 -0500", hash_original_method = "14BF3BE2BFE19AED1CD60C8FAD308911", hash_generated_method = "DD8F279DDBEA292AAB28E2780E964024")
        
public DependencyListener(AnimatorSet animatorSet, Node node, int rule) {
            this.mAnimatorSet = animatorSet;
            this.mNode = node;
            this.mRule = rule;
        }

        /**
         * Ignore cancel events for now. We may want to handle this eventually,
         * to prevent follow-on animations from running when some dependency
         * animation is canceled.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.725 -0500", hash_original_method = "16FF962612CA0CC38B4765F38064800C", hash_generated_method = "DE41ACB60F7DCC91D2500687FD4FFE69")
        
public void onAnimationCancel(Animator animation) {
        }

        /**
         * An end event is received - see if this is an event we are listening for
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.728 -0500", hash_original_method = "E0F66F3A2F7DEFA05E43170D7FDC6E81", hash_generated_method = "42514359CDD00951D89B9ED5670B7B09")
        
public void onAnimationEnd(Animator animation) {
            if (mRule == Dependency.AFTER) {
                startIfReady(animation);
            }
        }

        /**
         * Ignore repeat events for now
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.730 -0500", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "21972E6A0238BBC5342FCFEFA63E7A08")
        
public void onAnimationRepeat(Animator animation) {
        }

        /**
         * A start event is received - see if this is an event we are listening for
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.732 -0500", hash_original_method = "C319AA8CE810AC3271C178BB34DF8E30", hash_generated_method = "2E86170B59EB6BEEE710D4737E27B5A4")
        
public void onAnimationStart(Animator animation) {
            if (mRule == Dependency.WITH) {
                startIfReady(animation);
            }
        }

        /**
         * Check whether the event received is one that the node was waiting for.
         * If so, mark it as complete and see whether it's time to start
         * the animation.
         * @param dependencyAnimation the animation that sent the event.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.735 -0500", hash_original_method = "AF711F2A0E7E526F8B6CE8D71F56AFBE", hash_generated_method = "A19B60437C7CFB3800A4E1159AA166E4")
        
private void startIfReady(Animator dependencyAnimation) {
            if (mAnimatorSet.mTerminated) {
                // if the parent AnimatorSet was canceled, then don't start any dependent anims
                return;
            }
            Dependency dependencyToRemove = null;
            int numDependencies = mNode.tmpDependencies.size();
            for (int i = 0; i < numDependencies; ++i) {
                Dependency dependency = mNode.tmpDependencies.get(i);
                if (dependency.rule == mRule &&
                        dependency.node.animation == dependencyAnimation) {
                    // rule fired - remove the dependency and listener and check to
                    // see whether it's time to start the animation
                    dependencyToRemove = dependency;
                    dependencyAnimation.removeListener(this);
                    break;
                }
            }
            mNode.tmpDependencies.remove(dependencyToRemove);
            if (mNode.tmpDependencies.size() == 0) {
                // all dependencies satisfied: start the animation
                mNode.animation.start();
                mAnimatorSet.mPlayingSet.add(mNode.animation);
            }
        }

        
    }


    
    private class AnimatorSetListener implements AnimatorListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.740 -0500", hash_original_field = "D714D2C5468EB747703A2C0F7E744D58", hash_generated_field = "26BB44EB69421663EACF2A18D0E63EFE")


        private AnimatorSet mAnimatorSet;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.742 -0500", hash_original_method = "F7A8B618CE707AD8B38E15DFED3CE3FB", hash_generated_method = "F7A8B618CE707AD8B38E15DFED3CE3FB")
        
AnimatorSetListener(AnimatorSet animatorSet) {
            mAnimatorSet = animatorSet;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.745 -0500", hash_original_method = "BE6E1E1BF0ACB2CE5581D6C3A3287656", hash_generated_method = "BE7D60EE73685D79D0CA6057D31795D3")
        
public void onAnimationCancel(Animator animation) {
            if (!mTerminated) {
                // Listeners are already notified of the AnimatorSet canceling in cancel().
                // The logic below only kicks in when animations end normally
                if (mPlayingSet.size() == 0) {
                    if (mListeners != null) {
                        int numListeners = mListeners.size();
                        for (int i = 0; i < numListeners; ++i) {
                            mListeners.get(i).onAnimationCancel(mAnimatorSet);
                        }
                    }
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.748 -0500", hash_original_method = "18180E214611C82656F1013B7F322C73", hash_generated_method = "2B60FB18C966945F6F5C9E35F9C9615C")
        
@SuppressWarnings("unchecked")
        public void onAnimationEnd(Animator animation) {
            animation.removeListener(this);
            mPlayingSet.remove(animation);
            Node animNode = mAnimatorSet.mNodeMap.get(animation);
            animNode.done = true;
            if (!mTerminated) {
                // Listeners are already notified of the AnimatorSet ending in cancel() or
                // end(); the logic below only kicks in when animations end normally
                ArrayList<Node> sortedNodes = mAnimatorSet.mSortedNodes;
                boolean allDone = true;
                int numSortedNodes = sortedNodes.size();
                for (int i = 0; i < numSortedNodes; ++i) {
                    if (!sortedNodes.get(i).done) {
                        allDone = false;
                        break;
                    }
                }
                if (allDone) {
                    // If this was the last child animation to end, then notify listeners that this
                    // AnimatorSet has ended
                    if (mListeners != null) {
                        ArrayList<AnimatorListener> tmpListeners =
                                (ArrayList<AnimatorListener>) mListeners.clone();
                        int numListeners = tmpListeners.size();
                        for (int i = 0; i < numListeners; ++i) {
                            tmpListeners.get(i).onAnimationEnd(mAnimatorSet);
                        }
                    }
                    mAnimatorSet.mStarted = false;
                }
            }
        }

        // Nothing to do
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.751 -0500", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "21972E6A0238BBC5342FCFEFA63E7A08")
        
public void onAnimationRepeat(Animator animation) {
        }

        // Nothing to do
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.753 -0500", hash_original_method = "B990D1A680B01C8A5486D22741D7E96B", hash_generated_method = "AD8243EFA3A8C87DFAAAF133F32BDC0A")
        
public void onAnimationStart(Animator animation) {
        }

        
    }


    
    private static class Dependency {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.761 -0500", hash_original_field = "727982CBEA696B80A4FAE212C4BDBE6D", hash_generated_field = "D2E63A1F901C713BA822C6F070CEAD0C")

        static final int WITH = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.764 -0500", hash_original_field = "066FD67F9A2F4842B86B1B82BF82ABEE", hash_generated_field = "B2EDF4A77A9D7AC10EE81BB78B2A3B97")

        static final int AFTER = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.766 -0500", hash_original_field = "D4FCE8012659E56145F1753A3BD8D56E", hash_generated_field = "C8A632366A29618A29C7EE12E15819C8")


        // The node that the other node with this Dependency is dependent upon
        public Node node;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.768 -0500", hash_original_field = "DE96B7BCAB0FB87C4AED2600779645F4", hash_generated_field = "5BCB5D76D9FE8D00C97FD248D276BEFB")

        public int rule;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.771 -0500", hash_original_method = "762AEC0CFA60BDA08F8DF742864617B6", hash_generated_method = "64EE5F1A4B5FFC9B5C0AFBAEF2ED7946")
        
public Dependency(Node node, int rule) {
            this.node = node;
            this.rule = rule;
        }
    }


    
    private static class Node implements Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.775 -0500", hash_original_field = "94032F0292DB21EF61AC0A36FDD04147", hash_generated_field = "85D1EE31923D44CB9D3110ADDD29D65D")

        public Animator animation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.777 -0500", hash_original_field = "DE57C1399F5EB7872F5EECCDBFFCFC68", hash_generated_field = "46C94882CA4285AE3FB52FBE346AC349")

        public ArrayList<Dependency> dependencies = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.779 -0500", hash_original_field = "5D240F07EB5D51E8C231AA8298EA90E3", hash_generated_field = "B8C6459C87326A52248B3A69C1AD5ACC")

        public ArrayList<Dependency> tmpDependencies = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.781 -0500", hash_original_field = "E97E903A59FB84B00681BD9870697518", hash_generated_field = "4B254F155DE5D18E0880E4E9DEF81A08")

        public ArrayList<Node> nodeDependencies = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.784 -0500", hash_original_field = "906CA0568C175DCFDF102C33F583A960", hash_generated_field = "D83CBAAD32ACD2DF620D72FD4EEEA1F1")

        public ArrayList<Node> nodeDependents = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.786 -0500", hash_original_field = "B3F4B9FB7F6E266775B1E500C6C15A46", hash_generated_field = "3C1F0C530EFFEA18D19D1DCE04D244D2")

        public boolean done = false;

        /**
         * Constructs the Node with the animation that it encapsulates. A Node has no
         * dependencies by default; dependencies are added via the addDependency()
         * method.
         *
         * @param animation The animation that the Node encapsulates.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.789 -0500", hash_original_method = "003188EC42D875435178AF0E478B9BB9", hash_generated_method = "7A1D5B83B6B320ADCFCC06E5AE125442")
        
public Node(Animator animation) {
            this.animation = animation;
        }

        /**
         * Add a dependency to this Node. The dependency includes information about the
         * node that this node is dependency upon and the nature of the dependency.
         * @param dependency
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.792 -0500", hash_original_method = "A5D3F28C11D8E50179A44FB484206D0C", hash_generated_method = "4D78BAE0D7C03C0346B07CB3B077254E")
        
public void addDependency(Dependency dependency) {
            if (dependencies == null) {
                dependencies = new ArrayList<Dependency>();
                nodeDependencies = new ArrayList<Node>();
            }
            dependencies.add(dependency);
            if (!nodeDependencies.contains(dependency.node)) {
                nodeDependencies.add(dependency.node);
            }
            Node dependencyNode = dependency.node;
            if (dependencyNode.nodeDependents == null) {
                dependencyNode.nodeDependents = new ArrayList<Node>();
            }
            dependencyNode.nodeDependents.add(this);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.794 -0500", hash_original_method = "DEE80C65840F010A2F5E3A56F885F02B", hash_generated_method = "5310A6405CE0EDF9B1EE4BD24617F4C1")
        
@Override
        public Node clone() {
            try {
                Node node = (Node) super.clone();
                node.animation = (Animator) animation.clone();
                return node;
            } catch (CloneNotSupportedException e) {
               throw new AssertionError();
            }
        }

        
    }


    
    public class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.799 -0500", hash_original_field = "7BF0EF0DFDDEC52446DEF44E6956307E", hash_generated_field = "A3A3172265405E9566BFFCC4660589E1")

        private Node mCurrentNode;

        /**
         * package-private constructor. Builders are only constructed by AnimatorSet, when the
         * play() method is called.
         *
         * @param anim The animation that is the dependency for the other animations passed into
         * the other methods of this Builder object.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.801 -0500", hash_original_method = "B0114D66E7DF09FC47A74BA216B98164", hash_generated_method = "B0114D66E7DF09FC47A74BA216B98164")
        
Builder(Animator anim) {
            mCurrentNode = mNodeMap.get(anim);
            if (mCurrentNode == null) {
                mCurrentNode = new Node(anim);
                mNodeMap.put(anim, mCurrentNode);
                mNodes.add(mCurrentNode);
            }
        }

        /**
         * Sets up the given animation to play at the same time as the animation supplied in the
         * {@link AnimatorSet#play(Animator)} call that created this <code>Builder</code> object.
         *
         * @param anim The animation that will play when the animation supplied to the
         * {@link AnimatorSet#play(Animator)} method starts.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.803 -0500", hash_original_method = "B05ED6D6B491946B79783B58A8AC02E5", hash_generated_method = "FC8F4A8CD6F8E05ACF3A3197FD6930FF")
        
public Builder with(Animator anim) {
            Node node = mNodeMap.get(anim);
            if (node == null) {
                node = new Node(anim);
                mNodeMap.put(anim, node);
                mNodes.add(node);
            }
            Dependency dependency = new Dependency(mCurrentNode, Dependency.WITH);
            node.addDependency(dependency);
            return this;
        }

        /**
         * Sets up the given animation to play when the animation supplied in the
         * {@link AnimatorSet#play(Animator)} call that created this <code>Builder</code> object
         * ends.
         *
         * @param anim The animation that will play when the animation supplied to the
         * {@link AnimatorSet#play(Animator)} method ends.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.807 -0500", hash_original_method = "115926E0469E8C75055FFE822D9B435C", hash_generated_method = "A0BE22F31690B5565E23A795E6D3318F")
        
public Builder before(Animator anim) {
            Node node = mNodeMap.get(anim);
            if (node == null) {
                node = new Node(anim);
                mNodeMap.put(anim, node);
                mNodes.add(node);
            }
            Dependency dependency = new Dependency(mCurrentNode, Dependency.AFTER);
            node.addDependency(dependency);
            return this;
        }

        /**
         * Sets up the given animation to play when the animation supplied in the
         * {@link AnimatorSet#play(Animator)} call that created this <code>Builder</code> object
         * to start when the animation supplied in this method call ends.
         *
         * @param anim The animation whose end will cause the animation supplied to the
         * {@link AnimatorSet#play(Animator)} method to play.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.809 -0500", hash_original_method = "83E010DE5FB75637ACD6CFFBA4AB1D7F", hash_generated_method = "E00834B6C1E4D5CD71741A44B05CD531")
        
public Builder after(Animator anim) {
            Node node = mNodeMap.get(anim);
            if (node == null) {
                node = new Node(anim);
                mNodeMap.put(anim, node);
                mNodes.add(node);
            }
            Dependency dependency = new Dependency(node, Dependency.AFTER);
            mCurrentNode.addDependency(dependency);
            return this;
        }

        /**
         * Sets up the animation supplied in the
         * {@link AnimatorSet#play(Animator)} call that created this <code>Builder</code> object
         * to play when the given amount of time elapses.
         *
         * @param delay The number of milliseconds that should elapse before the
         * animation starts.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.811 -0500", hash_original_method = "5E60D6733644E2424482AFF107063E09", hash_generated_method = "392273B6B486D7F0366629E9B78B72B3")
        
public Builder after(long delay) {
            // setup dummy ValueAnimator just to run the clock
            ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);
            anim.setDuration(delay);
            after(anim);
            return this;
        }

        
    }


    
}

