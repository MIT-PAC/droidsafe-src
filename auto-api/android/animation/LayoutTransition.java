package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class LayoutTransition {
    private Animator mDisappearingAnim = null;
    private Animator mAppearingAnim = null;
    private Animator mChangingAppearingAnim = null;
    private Animator mChangingDisappearingAnim = null;
    private long mChangingAppearingDuration = DEFAULT_DURATION;
    private long mChangingDisappearingDuration = DEFAULT_DURATION;
    private long mAppearingDuration = DEFAULT_DURATION;
    private long mDisappearingDuration = DEFAULT_DURATION;
    private long mAppearingDelay = DEFAULT_DURATION;
    private long mDisappearingDelay = 0;
    private long mChangingAppearingDelay = 0;
    private long mChangingDisappearingDelay = DEFAULT_DURATION;
    private long mChangingAppearingStagger = 0;
    private long mChangingDisappearingStagger = 0;
    private TimeInterpolator mAppearingInterpolator = new AccelerateDecelerateInterpolator();
    private TimeInterpolator mDisappearingInterpolator = new AccelerateDecelerateInterpolator();
    private TimeInterpolator mChangingAppearingInterpolator = new DecelerateInterpolator();
    private TimeInterpolator mChangingDisappearingInterpolator = new DecelerateInterpolator();
    private HashMap<View, Animator> pendingAnimations =
            new HashMap<View, Animator>();
    private LinkedHashMap<View, Animator> currentChangingAnimations =
            new LinkedHashMap<View, Animator>();
    private LinkedHashMap<View, Animator> currentAppearingAnimations =
            new LinkedHashMap<View, Animator>();
    private LinkedHashMap<View, Animator> currentDisappearingAnimations =
            new LinkedHashMap<View, Animator>();
    private HashMap<View, View.OnLayoutChangeListener> layoutChangeListenerMap =
            new HashMap<View, View.OnLayoutChangeListener>();
    private long staggerDelay;
    private ArrayList<TransitionListener> mListeners;
    private boolean mAnimateParentHierarchy = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.181 -0400", hash_original_method = "52DB630B34835349C84181A9ADA45542", hash_generated_method = "B5AF3E8337270E86D71495E381BA6591")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LayoutTransition() {
        {
            PropertyValuesHolder pvhLeft;
            pvhLeft = PropertyValuesHolder.ofInt("left", 0, 1);
            PropertyValuesHolder pvhTop;
            pvhTop = PropertyValuesHolder.ofInt("top", 0, 1);
            PropertyValuesHolder pvhRight;
            pvhRight = PropertyValuesHolder.ofInt("right", 0, 1);
            PropertyValuesHolder pvhBottom;
            pvhBottom = PropertyValuesHolder.ofInt("bottom", 0, 1);
            PropertyValuesHolder pvhScrollX;
            pvhScrollX = PropertyValuesHolder.ofInt("scrollX", 0, 1);
            PropertyValuesHolder pvhScrollY;
            pvhScrollY = PropertyValuesHolder.ofInt("scrollY", 0, 1);
            defaultChangeIn = ObjectAnimator.ofPropertyValuesHolder((Object)null,
                    pvhLeft, pvhTop, pvhRight, pvhBottom, pvhScrollX, pvhScrollY);
            defaultChangeIn.setDuration(DEFAULT_DURATION);
            defaultChangeIn.setStartDelay(mChangingAppearingDelay);
            defaultChangeIn.setInterpolator(mChangingAppearingInterpolator);
            defaultChangeOut = defaultChangeIn.clone();
            defaultChangeOut.setStartDelay(mChangingDisappearingDelay);
            defaultChangeOut.setInterpolator(mChangingDisappearingInterpolator);
            defaultFadeIn = ObjectAnimator.ofFloat(null, "alpha", 0f, 1f);
            defaultFadeIn.setDuration(DEFAULT_DURATION);
            defaultFadeIn.setStartDelay(mAppearingDelay);
            defaultFadeIn.setInterpolator(mAppearingInterpolator);
            defaultFadeOut = ObjectAnimator.ofFloat(null, "alpha", 1f, 0f);
            defaultFadeOut.setDuration(DEFAULT_DURATION);
            defaultFadeOut.setStartDelay(mDisappearingDelay);
            defaultFadeOut.setInterpolator(mDisappearingInterpolator);
        } //End block
        mChangingAppearingAnim = defaultChangeIn;
        mChangingDisappearingAnim = defaultChangeOut;
        mAppearingAnim = defaultFadeIn;
        mDisappearingAnim = defaultFadeOut;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.182 -0400", hash_original_method = "24394BA80BA94B39DCA5B438DC3EBDB1", hash_generated_method = "F22302EAB85F1C9D4F17580021095C1C")
    @DSModeled(DSC.SAFE)
    public void setDuration(long duration) {
        dsTaint.addTaint(duration);
        // ---------- Original Method ----------
        //mChangingAppearingDuration = duration;
        //mChangingDisappearingDuration = duration;
        //mAppearingDuration = duration;
        //mDisappearingDuration = duration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.190 -0400", hash_original_method = "939FBD8B4C5590BFCAA9E14AEC15ED50", hash_generated_method = "F4438A53B1D97DAFECC1032489D5AB4F")
    @DSModeled(DSC.SAFE)
    public void setStartDelay(int transitionType, long delay) {
        dsTaint.addTaint(transitionType);
        dsTaint.addTaint(delay);
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //mChangingAppearingDelay = delay;
                //break;
            //case CHANGE_DISAPPEARING:
                //mChangingDisappearingDelay = delay;
                //break;
            //case APPEARING:
                //mAppearingDelay = delay;
                //break;
            //case DISAPPEARING:
                //mDisappearingDelay = delay;
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.191 -0400", hash_original_method = "3F88CD33B6864BEBC3B576EB6504FB35", hash_generated_method = "8E0C371516D0DEC48F977A42B7445FDA")
    @DSModeled(DSC.SAFE)
    public long getStartDelay(int transitionType) {
        dsTaint.addTaint(transitionType);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //return mChangingAppearingDuration;
            //case CHANGE_DISAPPEARING:
                //return mChangingDisappearingDuration;
            //case APPEARING:
                //return mAppearingDuration;
            //case DISAPPEARING:
                //return mDisappearingDuration;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.192 -0400", hash_original_method = "2851CBF3AA331995F771441E9F6D0AAD", hash_generated_method = "793BBA51BF3E46352B7ED011349D1275")
    @DSModeled(DSC.SAFE)
    public void setDuration(int transitionType, long duration) {
        dsTaint.addTaint(duration);
        dsTaint.addTaint(transitionType);
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //mChangingAppearingDuration = duration;
                //break;
            //case CHANGE_DISAPPEARING:
                //mChangingDisappearingDuration = duration;
                //break;
            //case APPEARING:
                //mAppearingDuration = duration;
                //break;
            //case DISAPPEARING:
                //mDisappearingDuration = duration;
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.193 -0400", hash_original_method = "F259A86CD3BB3A6D515EAAF2335DC6DD", hash_generated_method = "16C65156778E4B6E4CC2B4770CD6C5C3")
    @DSModeled(DSC.SAFE)
    public long getDuration(int transitionType) {
        dsTaint.addTaint(transitionType);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //return mChangingAppearingDuration;
            //case CHANGE_DISAPPEARING:
                //return mChangingDisappearingDuration;
            //case APPEARING:
                //return mAppearingDuration;
            //case DISAPPEARING:
                //return mDisappearingDuration;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.194 -0400", hash_original_method = "DB3710D74B2FBFD7C44693C4FBA40808", hash_generated_method = "5B00F493056B044B0C1CE9DE824A8C94")
    @DSModeled(DSC.SAFE)
    public void setStagger(int transitionType, long duration) {
        dsTaint.addTaint(duration);
        dsTaint.addTaint(transitionType);
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //mChangingAppearingStagger = duration;
                //break;
            //case CHANGE_DISAPPEARING:
                //mChangingDisappearingStagger = duration;
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.195 -0400", hash_original_method = "70FCFF77D9C405B5FA9E6B4579BF3D8B", hash_generated_method = "2A7C983326E94C45691C4E12F867BAC7")
    @DSModeled(DSC.SAFE)
    public long getStagger(int transitionType) {
        dsTaint.addTaint(transitionType);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //return mChangingAppearingStagger;
            //case CHANGE_DISAPPEARING:
                //return mChangingDisappearingStagger;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.206 -0400", hash_original_method = "2AD5234EB4F80ED9C0D5C1F0BD7735E5", hash_generated_method = "158055EC9E22E445410A20CE6C42AA33")
    @DSModeled(DSC.SAFE)
    public void setInterpolator(int transitionType, TimeInterpolator interpolator) {
        dsTaint.addTaint(transitionType);
        dsTaint.addTaint(interpolator.dsTaint);
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //mChangingAppearingInterpolator = interpolator;
                //break;
            //case CHANGE_DISAPPEARING:
                //mChangingDisappearingInterpolator = interpolator;
                //break;
            //case APPEARING:
                //mAppearingInterpolator = interpolator;
                //break;
            //case DISAPPEARING:
                //mDisappearingInterpolator = interpolator;
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.207 -0400", hash_original_method = "11C2A17826922B819D4ABA31B32AF7FD", hash_generated_method = "44ECFD4F5532063DBBE5CDEB2637796A")
    @DSModeled(DSC.SAFE)
    public TimeInterpolator getInterpolator(int transitionType) {
        dsTaint.addTaint(transitionType);
        return (TimeInterpolator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //return mChangingAppearingInterpolator;
            //case CHANGE_DISAPPEARING:
                //return mChangingDisappearingInterpolator;
            //case APPEARING:
                //return mAppearingInterpolator;
            //case DISAPPEARING:
                //return mDisappearingInterpolator;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.209 -0400", hash_original_method = "1CE02B172FBE4A7CE10D1F87669E47EA", hash_generated_method = "4F7F618A151C7B756336F6F37CBE4D56")
    @DSModeled(DSC.SAFE)
    public void setAnimator(int transitionType, Animator animator) {
        dsTaint.addTaint(animator.dsTaint);
        dsTaint.addTaint(transitionType);
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //mChangingAppearingAnim = animator;
                //break;
            //case CHANGE_DISAPPEARING:
                //mChangingDisappearingAnim = animator;
                //break;
            //case APPEARING:
                //mAppearingAnim = animator;
                //break;
            //case DISAPPEARING:
                //mDisappearingAnim = animator;
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.212 -0400", hash_original_method = "FF737FAA09DE0C7945DD1E6E302C4C89", hash_generated_method = "FCFD6F553B2388C3A56CB3E8FCD00E67")
    @DSModeled(DSC.SAFE)
    public Animator getAnimator(int transitionType) {
        dsTaint.addTaint(transitionType);
        return (Animator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //return mChangingAppearingAnim;
            //case CHANGE_DISAPPEARING:
                //return mChangingDisappearingAnim;
            //case APPEARING:
                //return mAppearingAnim;
            //case DISAPPEARING:
                //return mDisappearingAnim;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.228 -0400", hash_original_method = "388160589FFEE2126FAAE5CBAFC89998", hash_generated_method = "C078EBA292C1D78832D0091C24F5089B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void runChangeTransition(final ViewGroup parent, View newView, final int changeReason) {
        dsTaint.addTaint(changeReason);
        dsTaint.addTaint(newView.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        Animator baseAnimator;
        baseAnimator = mChangingAppearingAnim;
        baseAnimator = mChangingDisappearingAnim;
        staggerDelay = 0;
        long duration;
        duration = mChangingAppearingDuration;
        duration = mChangingDisappearingDuration;
        ViewTreeObserver observer;
        observer = parent.getViewTreeObserver();
        {
            boolean var8AD88F416FDBC789F76B74DE1C37B0E1_1147857348 = (!observer.isAlive());
        } //End collapsed parenthetic
        int numChildren;
        numChildren = parent.getChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = parent.getChildAt(i);
                {
                    setupChangeAnimation(parent, changeReason, baseAnimator, duration, child);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            Animator parentAnimator;
            parentAnimator = defaultChangeIn;
            parentAnimator = defaultChangeOut;
            ViewGroup tempParent;
            tempParent = parent;
            {
                ViewParent parentParent;
                parentParent = tempParent.getParent();
                {
                    setupChangeAnimation((ViewGroup)parentParent, changeReason, parentAnimator,
                            duration, tempParent);
                    tempParent = (ViewGroup) parentParent;
                } //End block
                {
                    tempParent = null;
                } //End block
            } //End block
        } //End block
        observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.227 -0400", hash_original_method = "6C01974BA3CD333428484527C9FBE54F", hash_generated_method = "6FCB0FB9D991198572CC246F02005957")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public boolean onPreDraw() {
                //DSFIXME:  CODE0009: Possible callback target function detected
                parent.getViewTreeObserver().removeOnPreDrawListener(this);
                int count;
                count = layoutChangeListenerMap.size();
                {
                    Collection<View> views;
                    views = layoutChangeListenerMap.keySet();
                    {
                        Iterator<View> var6B1B56E78019197FFF75517BC796AC75_545920011 = (views).iterator();
                        var6B1B56E78019197FFF75517BC796AC75_545920011.hasNext();
                        View view = var6B1B56E78019197FFF75517BC796AC75_545920011.next();
                        {
                            View.OnLayoutChangeListener listener;
                            listener = layoutChangeListenerMap.get(view);
                            view.removeOnLayoutChangeListener(listener);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                layoutChangeListenerMap.clear();
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //parent.getViewTreeObserver().removeOnPreDrawListener(this);
                //int count = layoutChangeListenerMap.size();
                //if (count > 0) {
                    //Collection<View> views = layoutChangeListenerMap.keySet();
                    //for (View view : views) {
                        //View.OnLayoutChangeListener listener = layoutChangeListenerMap.get(view);
                        //view.removeOnLayoutChangeListener(listener);
                    //}
                //}
                //layoutChangeListenerMap.clear();
                //return true;
            }
});
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.229 -0400", hash_original_method = "5ECFD2D430BE870F40C042D01FD8A2D6", hash_generated_method = "AC783C900271DF21E4C4887EFADBB38C")
    @DSModeled(DSC.SAFE)
    public void setAnimateParentHierarchy(boolean animateParentHierarchy) {
        dsTaint.addTaint(animateParentHierarchy);
        // ---------- Original Method ----------
        //mAnimateParentHierarchy = animateParentHierarchy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.245 -0400", hash_original_method = "108854515942B7EF6A63499B84E31466", hash_generated_method = "914010327656737F82D24FE45108D55F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setupChangeAnimation(final ViewGroup parent, final int changeReason,
            Animator baseAnimator, final long duration, final View child) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(changeReason);
        dsTaint.addTaint(duration);
        dsTaint.addTaint(baseAnimator.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        {
            boolean varA6A7315ADDDC59C70ED73956C763A706_524520757 = (layoutChangeListenerMap.get(child) != null);
        } //End collapsed parenthetic
        Animator anim;
        anim = baseAnimator.clone();
        anim.setTarget(child);
        anim.setupStartValues();
        Animator currentAnimation;
        currentAnimation = pendingAnimations.get(child);
        {
            currentAnimation.cancel();
            pendingAnimations.remove(child);
        } //End block
        pendingAnimations.put(child, anim);
        ValueAnimator pendingAnimRemover;
        pendingAnimRemover = ValueAnimator.ofFloat(0f, 1f).
                setDuration(duration + 100);
        pendingAnimRemover.addListener(new AnimatorListenerAdapter() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.232 -0400", hash_original_method = "81B18D5FBD0385E26F1E055D2C44BFFA", hash_generated_method = "0DFC4062B57229EF8508A77D591A754D")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onAnimationEnd(Animator animation) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(animation.dsTaint);
                pendingAnimations.remove(child);
                // ---------- Original Method ----------
                //pendingAnimations.remove(child);
            }
});
        pendingAnimRemover.start();
        View.OnLayoutChangeListener listener;
        listener = new View.OnLayoutChangeListener() {
            public void onLayoutChange(View v, int left, int top, int right, int bottom,
                    int oldLeft, int oldTop, int oldRight, int oldBottom) {
                anim.setupEndValues();
                if (anim instanceof ValueAnimator) {
                    boolean valuesDiffer = false;
                    ValueAnimator valueAnim = (ValueAnimator)anim;
                    PropertyValuesHolder[] oldValues = valueAnim.getValues();
                    for (int i = 0; i < oldValues.length; ++i) {
                        PropertyValuesHolder pvh = oldValues[i];
                        KeyframeSet keyframeSet = pvh.mKeyframeSet;
                        if (keyframeSet.mFirstKeyframe == null ||
                                keyframeSet.mLastKeyframe == null ||
                                !keyframeSet.mFirstKeyframe.getValue().equals(
                                keyframeSet.mLastKeyframe.getValue())) {
                            valuesDiffer = true;
                        }
                    }
                    if (!valuesDiffer) {
                        return;
                    }
                }
                long startDelay;
                if (changeReason == APPEARING) {
                    startDelay = mChangingAppearingDelay + staggerDelay;
                    staggerDelay += mChangingAppearingStagger;
                } else {
                    startDelay = mChangingDisappearingDelay + staggerDelay;
                    staggerDelay += mChangingDisappearingStagger;
                }
                anim.setStartDelay(startDelay);
                anim.setDuration(duration);
                Animator prevAnimation = currentChangingAnimations.get(child);
                if (prevAnimation != null) {
                    prevAnimation.cancel();
                }
                Animator pendingAnimation = pendingAnimations.get(child);
                if (pendingAnimation != null) {
                    pendingAnimations.remove(child);
                }
                currentChangingAnimations.put(child, anim);
                parent.requestTransitionStart(LayoutTransition.this);
                child.removeOnLayoutChangeListener(this);
                layoutChangeListenerMap.remove(child);
            }
        };
        anim.addListener(new AnimatorListenerAdapter() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.241 -0400", hash_original_method = "E2B93FC024F741AE866ED6DC48631B6A", hash_generated_method = "674E24C2EAC08373F624781922C8E721")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onAnimationStart(Animator animator) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(animator.dsTaint);
                {
                    {
                        Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_2132830925 = (mListeners).iterator();
                        var027539751E49B70605583F80C9C40859_2132830925.hasNext();
                        TransitionListener listener = var027539751E49B70605583F80C9C40859_2132830925.next();
                        {
                            listener.startTransition(LayoutTransition.this, parent, child,
                                changeReason == APPEARING ?
                                        CHANGE_APPEARING : CHANGE_DISAPPEARING);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                // ---------- Original Method ----------
                //if (mListeners != null) {
                    //for (TransitionListener listener : mListeners) {
                        //listener.startTransition(LayoutTransition.this, parent, child,
                                //changeReason == APPEARING ?
                                        //CHANGE_APPEARING : CHANGE_DISAPPEARING);
                    //}
                //}
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.242 -0400", hash_original_method = "06655B4777E7383270776E7CEC1CCF7E", hash_generated_method = "AB3C2D3B77F25A1591DD1E8CE2F0B341")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onAnimationCancel(Animator animator) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(animator.dsTaint);
                child.removeOnLayoutChangeListener(listener);
                layoutChangeListenerMap.remove(child);
                // ---------- Original Method ----------
                //child.removeOnLayoutChangeListener(listener);
                //layoutChangeListenerMap.remove(child);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.244 -0400", hash_original_method = "DE5B5D0FB75885026A5DD6EBE7BC56A2", hash_generated_method = "196CBB5646AAEAD11B46F0680889B2B2")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onAnimationEnd(Animator animator) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(animator.dsTaint);
                currentChangingAnimations.remove(child);
                {
                    {
                        Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_27795613 = (mListeners).iterator();
                        var027539751E49B70605583F80C9C40859_27795613.hasNext();
                        TransitionListener listener = var027539751E49B70605583F80C9C40859_27795613.next();
                        {
                            listener.endTransition(LayoutTransition.this, parent, child,
                                changeReason == APPEARING ?
                                        CHANGE_APPEARING : CHANGE_DISAPPEARING);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                // ---------- Original Method ----------
                //currentChangingAnimations.remove(child);
                //if (mListeners != null) {
                    //for (TransitionListener listener : mListeners) {
                        //listener.endTransition(LayoutTransition.this, parent, child,
                                //changeReason == APPEARING ?
                                        //CHANGE_APPEARING : CHANGE_DISAPPEARING);
                    //}
                //}
            }
});
        child.addOnLayoutChangeListener(listener);
        layoutChangeListenerMap.put(child, listener);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.267 -0400", hash_original_method = "7222BE89A56886A0CF62DC8766C00475", hash_generated_method = "9E4F24D42C68EB20DFC22FF5536262A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startChangingAnimations() {
        LinkedHashMap<View, Animator> currentAnimCopy;
        currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
        {
            Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_1982138570 = (currentAnimCopy.values()).iterator();
            var77A69CCC7893588B99D9F323E4F0D0AD_1982138570.hasNext();
            Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_1982138570.next();
            {
                {
                    ((ObjectAnimator) anim).setCurrentPlayTime(0);
                } //End block
                anim.start();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //LinkedHashMap<View, Animator> currentAnimCopy =
                //(LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
        //for (Animator anim : currentAnimCopy.values()) {
            //if (anim instanceof ObjectAnimator) {
                //((ObjectAnimator) anim).setCurrentPlayTime(0);
            //}
            //anim.start();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.288 -0400", hash_original_method = "7BA742550F1E1298AB8FE77F45C4383D", hash_generated_method = "749926F7C40A7200F866636164F23624")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void endChangingAnimations() {
        LinkedHashMap<View, Animator> currentAnimCopy;
        currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
        {
            Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_1255129651 = (currentAnimCopy.values()).iterator();
            var77A69CCC7893588B99D9F323E4F0D0AD_1255129651.hasNext();
            Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_1255129651.next();
            {
                anim.start();
                anim.end();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //LinkedHashMap<View, Animator> currentAnimCopy =
                //(LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
        //for (Animator anim : currentAnimCopy.values()) {
            //anim.start();
            //anim.end();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.298 -0400", hash_original_method = "8C9364165F532DD8BD43415668542398", hash_generated_method = "4D6DAD8F3E446754A2FD217F9AC2D09C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isChangingLayout() {
        boolean var4077384608DE00EFE78F41629DE0A95B_275628664 = ((currentChangingAnimations.size() > 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (currentChangingAnimations.size() > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.299 -0400", hash_original_method = "7F683046BB72ECC23A172B1D3B81B266", hash_generated_method = "7A41E17D64853F61BFD1BA841DD2C35C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isRunning() {
        boolean var987B4F52345B82CBBAB6F416FA45A0C5_846561919 = ((currentChangingAnimations.size() > 0 || currentAppearingAnimations.size() > 0 ||
                currentDisappearingAnimations.size() > 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (currentChangingAnimations.size() > 0 || currentAppearingAnimations.size() > 0 ||
                //currentDisappearingAnimations.size() > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.340 -0400", hash_original_method = "2E46A59670A61A0AF64FD97BDAF7B728", hash_generated_method = "3A39391D2F8C8201C596AD392163575E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancel() {
        {
            boolean var33AE39A73D9B32AC5849C5A957F93302_297860444 = (currentChangingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_2018733410 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_2018733410.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_2018733410.next();
                    {
                        anim.cancel();
                    } //End block
                } //End collapsed parenthetic
                currentChangingAnimations.clear();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var581E5FE1178D7616A969479C9EF98728_546651658 = (currentAppearingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentAppearingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_1883649326 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_1883649326.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_1883649326.next();
                    {
                        anim.end();
                    } //End block
                } //End collapsed parenthetic
                currentAppearingAnimations.clear();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var08F255EDB4B7971930CFAED58C7D7CB3_241187336 = (currentDisappearingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentDisappearingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_432963719 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_432963719.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_432963719.next();
                    {
                        anim.end();
                    } //End block
                } //End collapsed parenthetic
                currentDisappearingAnimations.clear();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.402 -0400", hash_original_method = "19B870791205108BA3B602A2E8CB5138", hash_generated_method = "35743CD53DA02FDA2EA15BE4A1BEE82F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancel(int transitionType) {
        dsTaint.addTaint(transitionType);
        //Begin case CHANGE_APPEARING CHANGE_DISAPPEARING 
        {
            boolean var33AE39A73D9B32AC5849C5A957F93302_1877558015 = (currentChangingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_1607042115 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_1607042115.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_1607042115.next();
                    {
                        anim.cancel();
                    } //End block
                } //End collapsed parenthetic
                currentChangingAnimations.clear();
            } //End block
        } //End collapsed parenthetic
        //End case CHANGE_APPEARING CHANGE_DISAPPEARING 
        //Begin case APPEARING 
        {
            boolean var581E5FE1178D7616A969479C9EF98728_772688494 = (currentAppearingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentAppearingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_1233085121 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_1233085121.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_1233085121.next();
                    {
                        anim.end();
                    } //End block
                } //End collapsed parenthetic
                currentAppearingAnimations.clear();
            } //End block
        } //End collapsed parenthetic
        //End case APPEARING 
        //Begin case DISAPPEARING 
        {
            boolean var08F255EDB4B7971930CFAED58C7D7CB3_1860714804 = (currentDisappearingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentDisappearingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_2092589850 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_2092589850.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_2092589850.next();
                    {
                        anim.end();
                    } //End block
                } //End collapsed parenthetic
                currentDisappearingAnimations.clear();
            } //End block
        } //End collapsed parenthetic
        //End case DISAPPEARING 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.465 -0400", hash_original_method = "071036D6A0EA050ACF09A35752DC1D52", hash_generated_method = "4D9387C6875FC4C2CAFC40CC71A1B9A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void runAppearingTransition(final ViewGroup parent, final View child) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        Animator currentAnimation;
        currentAnimation = currentDisappearingAnimations.get(child);
        {
            currentAnimation.cancel();
        } //End block
        {
            {
                {
                    Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_1674900504 = (mListeners).iterator();
                    var027539751E49B70605583F80C9C40859_1674900504.hasNext();
                    TransitionListener listener = var027539751E49B70605583F80C9C40859_1674900504.next();
                    {
                        listener.endTransition(LayoutTransition.this, parent, child, APPEARING);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        Animator anim;
        anim = mAppearingAnim.clone();
        anim.setTarget(child);
        anim.setStartDelay(mAppearingDelay);
        anim.setDuration(mAppearingDuration);
        {
            ((ObjectAnimator) anim).setCurrentPlayTime(0);
        } //End block
        {
            anim.addListener(new AnimatorListenerAdapter() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.464 -0400", hash_original_method = "494D571A7E2D39F79DD71B48D4E2ACB8", hash_generated_method = "B38EDA558A1772D543A2FE1184007668")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void onAnimationEnd(Animator anim) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    dsTaint.addTaint(anim.dsTaint);
                    currentAppearingAnimations.remove(child);
                    {
                        Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_188859490 = (mListeners).iterator();
                        var027539751E49B70605583F80C9C40859_188859490.hasNext();
                        TransitionListener listener = var027539751E49B70605583F80C9C40859_188859490.next();
                        {
                            listener.endTransition(LayoutTransition.this, parent, child, APPEARING);
                        } //End block
                    } //End collapsed parenthetic
                    // ---------- Original Method ----------
                    //currentAppearingAnimations.remove(child);
                    //for (TransitionListener listener : mListeners) {
                        //listener.endTransition(LayoutTransition.this, parent, child, APPEARING);
                    //}
                }
});
        } //End block
        currentAppearingAnimations.put(child, anim);
        anim.start();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.526 -0400", hash_original_method = "202CDBACC5F0926CC1D7E1540267464D", hash_generated_method = "C2DC3F9ED27E13BA01686F43D40AF902")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void runDisappearingTransition(final ViewGroup parent, final View child) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        Animator currentAnimation;
        currentAnimation = currentAppearingAnimations.get(child);
        {
            currentAnimation.cancel();
        } //End block
        {
            {
                {
                    Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_1614021872 = (mListeners).iterator();
                    var027539751E49B70605583F80C9C40859_1614021872.hasNext();
                    TransitionListener listener = var027539751E49B70605583F80C9C40859_1614021872.next();
                    {
                        listener.endTransition(LayoutTransition.this, parent, child, DISAPPEARING);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        Animator anim;
        anim = mDisappearingAnim.clone();
        anim.setStartDelay(mDisappearingDelay);
        anim.setDuration(mDisappearingDuration);
        anim.setTarget(child);
        {
            anim.addListener(new AnimatorListenerAdapter() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.524 -0400", hash_original_method = "29C17A3026C40266B26AB145A51034B4", hash_generated_method = "AD203B38DA64F1534D33BE22F9CD0502")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void onAnimationEnd(Animator anim) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    dsTaint.addTaint(anim.dsTaint);
                    currentDisappearingAnimations.remove(child);
                    {
                        Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_96179878 = (mListeners).iterator();
                        var027539751E49B70605583F80C9C40859_96179878.hasNext();
                        TransitionListener listener = var027539751E49B70605583F80C9C40859_96179878.next();
                        {
                            listener.endTransition(LayoutTransition.this, parent, child, DISAPPEARING);
                        } //End block
                    } //End collapsed parenthetic
                    // ---------- Original Method ----------
                    //currentDisappearingAnimations.remove(child);
                    //for (TransitionListener listener : mListeners) {
                        //listener.endTransition(LayoutTransition.this, parent, child, DISAPPEARING);
                    //}
                }
});
        } //End block
        {
            ((ObjectAnimator) anim).setCurrentPlayTime(0);
        } //End block
        currentDisappearingAnimations.put(child, anim);
        anim.start();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.563 -0400", hash_original_method = "05533C05F33D5C5B655A5BABA4CC6F65", hash_generated_method = "0629396F01D0A27E4B97447CB76B2886")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addChild(ViewGroup parent, View child) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        cancel(DISAPPEARING);
        cancel(CHANGE_APPEARING);
        {
            {
                Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_205750499 = (mListeners).iterator();
                var027539751E49B70605583F80C9C40859_205750499.hasNext();
                TransitionListener listener = var027539751E49B70605583F80C9C40859_205750499.next();
                {
                    listener.startTransition(this, parent, child, APPEARING);
                } //End block
            } //End collapsed parenthetic
        } //End block
        runChangeTransition(parent, child, APPEARING);
        runAppearingTransition(parent, child);
        // ---------- Original Method ----------
        //cancel(DISAPPEARING);
        //cancel(CHANGE_APPEARING);
        //if (mListeners != null) {
            //for (TransitionListener listener : mListeners) {
                //listener.startTransition(this, parent, child, APPEARING);
            //}
        //}
        //runChangeTransition(parent, child, APPEARING);
        //runAppearingTransition(parent, child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.564 -0400", hash_original_method = "5867E97EE566113A4AD2D7416A9B4CB1", hash_generated_method = "C2C5D111923193A05348486BB1C008A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showChild(ViewGroup parent, View child) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        addChild(parent, child);
        // ---------- Original Method ----------
        //addChild(parent, child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.599 -0400", hash_original_method = "E23F457F66AC508EC3728A00193F4832", hash_generated_method = "2D91406924485C0BDE4E2F2F2B2111E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeChild(ViewGroup parent, View child) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        cancel(APPEARING);
        cancel(CHANGE_DISAPPEARING);
        {
            {
                Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_1481755894 = (mListeners).iterator();
                var027539751E49B70605583F80C9C40859_1481755894.hasNext();
                TransitionListener listener = var027539751E49B70605583F80C9C40859_1481755894.next();
                {
                    listener.startTransition(this, parent, child, DISAPPEARING);
                } //End block
            } //End collapsed parenthetic
        } //End block
        runChangeTransition(parent, child, DISAPPEARING);
        runDisappearingTransition(parent, child);
        // ---------- Original Method ----------
        //cancel(APPEARING);
        //cancel(CHANGE_DISAPPEARING);
        //if (mListeners != null) {
            //for (TransitionListener listener : mListeners) {
                //listener.startTransition(this, parent, child, DISAPPEARING);
            //}
        //}
        //runChangeTransition(parent, child, DISAPPEARING);
        //runDisappearingTransition(parent, child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.606 -0400", hash_original_method = "59CF94EEC1336BEEB8FFF5467E6ED5F9", hash_generated_method = "3F959E562E0EF8AFFC9821502EE0527E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void hideChild(ViewGroup parent, View child) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        removeChild(parent, child);
        // ---------- Original Method ----------
        //removeChild(parent, child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.607 -0400", hash_original_method = "167EED27AB5F7469F2545513C43EBDC4", hash_generated_method = "2AE7E7EF5E9E15C8824A96357A46B150")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addTransitionListener(TransitionListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            mListeners = new ArrayList<TransitionListener>();
        } //End block
        mListeners.add(listener);
        // ---------- Original Method ----------
        //if (mListeners == null) {
            //mListeners = new ArrayList<TransitionListener>();
        //}
        //mListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.608 -0400", hash_original_method = "CD0DE6419C69039B8FDEE8C2D5BC497D", hash_generated_method = "4BC562A405346B6F02A28FA7B73B0AD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeTransitionListener(TransitionListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        mListeners.remove(listener);
        // ---------- Original Method ----------
        //if (mListeners == null) {
            //return;
        //}
        //mListeners.remove(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.608 -0400", hash_original_method = "F0DD3EC0CE94CE6304D7C3009A3E39A6", hash_generated_method = "A6E5E34D57B261ECE5E0E5DF5720586F")
    @DSModeled(DSC.SAFE)
    public List<TransitionListener> getTransitionListeners() {
        return (List<TransitionListener>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mListeners;
    }

    
    public interface TransitionListener {

        
        public void startTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType);

        
        public void endTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType);
    }
    
    public static final int CHANGE_APPEARING = 0;
    public static final int CHANGE_DISAPPEARING = 1;
    public static final int APPEARING = 2;
    public static final int DISAPPEARING = 3;
    private static ObjectAnimator defaultChangeIn;
    private static ObjectAnimator defaultChangeOut;
    private static ObjectAnimator defaultFadeIn;
    private static ObjectAnimator defaultFadeOut;
    private static long DEFAULT_DURATION = 300;
}

