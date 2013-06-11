package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    public static final int CHANGE_APPEARING = 0;
    public static final int CHANGE_DISAPPEARING = 1;
    public static final int APPEARING = 2;
    public static final int DISAPPEARING = 3;
    private Animator mDisappearingAnim = null;
    private Animator mAppearingAnim = null;
    private Animator mChangingAppearingAnim = null;
    private Animator mChangingDisappearingAnim = null;
    private static ObjectAnimator defaultChangeIn;
    private static ObjectAnimator defaultChangeOut;
    private static ObjectAnimator defaultFadeIn;
    private static ObjectAnimator defaultFadeOut;
    private static long DEFAULT_DURATION = 300;
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
    private final HashMap<View, Animator> pendingAnimations =
            new HashMap<View, Animator>();
    private final LinkedHashMap<View, Animator> currentChangingAnimations =
            new LinkedHashMap<View, Animator>();
    private final LinkedHashMap<View, Animator> currentAppearingAnimations =
            new LinkedHashMap<View, Animator>();
    private final LinkedHashMap<View, Animator> currentDisappearingAnimations =
            new LinkedHashMap<View, Animator>();
    private final HashMap<View, View.OnLayoutChangeListener> layoutChangeListenerMap =
            new HashMap<View, View.OnLayoutChangeListener>();
    private long staggerDelay;
    private ArrayList<TransitionListener> mListeners;
    private boolean mAnimateParentHierarchy = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.136 -0400", hash_original_method = "52DB630B34835349C84181A9ADA45542", hash_generated_method = "28E9C49EB3813FFD9BB9D6A191A14B76")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.137 -0400", hash_original_method = "24394BA80BA94B39DCA5B438DC3EBDB1", hash_generated_method = "B25BFD498F49A9A0B07CA8F657804939")
    @DSModeled(DSC.SAFE)
    public void setDuration(long duration) {
        dsTaint.addTaint(duration);
        // ---------- Original Method ----------
        //mChangingAppearingDuration = duration;
        //mChangingDisappearingDuration = duration;
        //mAppearingDuration = duration;
        //mDisappearingDuration = duration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.138 -0400", hash_original_method = "939FBD8B4C5590BFCAA9E14AEC15ED50", hash_generated_method = "58680D2BE78573100F94B9142F0B7492")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.139 -0400", hash_original_method = "3F88CD33B6864BEBC3B576EB6504FB35", hash_generated_method = "EE8DCC6E9C7218A5D18CCBA02482C6A0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.140 -0400", hash_original_method = "2851CBF3AA331995F771441E9F6D0AAD", hash_generated_method = "B663E4A243785DE1A2A5ED14A3027EE7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.141 -0400", hash_original_method = "F259A86CD3BB3A6D515EAAF2335DC6DD", hash_generated_method = "955A27106CDD49E89BD9AEB893432C20")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.142 -0400", hash_original_method = "DB3710D74B2FBFD7C44693C4FBA40808", hash_generated_method = "FB69EE8582E5BF30CBA2D8DE621A83B5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.143 -0400", hash_original_method = "70FCFF77D9C405B5FA9E6B4579BF3D8B", hash_generated_method = "EC0FEBED3A6065869AA53360533870B9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.144 -0400", hash_original_method = "2AD5234EB4F80ED9C0D5C1F0BD7735E5", hash_generated_method = "40D5B7B90008BB2853804123A7EEFF3A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.145 -0400", hash_original_method = "11C2A17826922B819D4ABA31B32AF7FD", hash_generated_method = "35FA7321AEEEA27A25322FFC3D62EC52")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.146 -0400", hash_original_method = "1CE02B172FBE4A7CE10D1F87669E47EA", hash_generated_method = "AD39C9341923CE01828D24966444312B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.147 -0400", hash_original_method = "FF737FAA09DE0C7945DD1E6E302C4C89", hash_generated_method = "E51AD7A1BA96B8D6846F51C1B7C6C855")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.149 -0400", hash_original_method = "388160589FFEE2126FAAE5CBAFC89998", hash_generated_method = "9E77232123A16152339E3838A790BECA")
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
        final ViewTreeObserver observer;
        observer = parent.getViewTreeObserver();
        {
            boolean var8AD88F416FDBC789F76B74DE1C37B0E1_1989492609 = (!observer.isAlive());
        } //End collapsed parenthetic
        int numChildren;
        numChildren = parent.getChildCount();
        {
            int i;
            i = 0;
            {
                final View child;
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
            public boolean onPreDraw() {
                parent.getViewTreeObserver().removeOnPreDrawListener(this);
                int count = layoutChangeListenerMap.size();
                if (count > 0) {
                    Collection<View> views = layoutChangeListenerMap.keySet();
                    for (View view : views) {
                        View.OnLayoutChangeListener listener = layoutChangeListenerMap.get(view);
                        view.removeOnLayoutChangeListener(listener);
                    }
                }
                layoutChangeListenerMap.clear();
                return true;
            }
        });
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.150 -0400", hash_original_method = "5ECFD2D430BE870F40C042D01FD8A2D6", hash_generated_method = "75B9175195396EADAD9E3C2799D16573")
    @DSModeled(DSC.SAFE)
    public void setAnimateParentHierarchy(boolean animateParentHierarchy) {
        dsTaint.addTaint(animateParentHierarchy);
        // ---------- Original Method ----------
        //mAnimateParentHierarchy = animateParentHierarchy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.152 -0400", hash_original_method = "108854515942B7EF6A63499B84E31466", hash_generated_method = "F5826C0A59425D16BEE9F0B7CF10A477")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setupChangeAnimation(final ViewGroup parent, final int changeReason,
            Animator baseAnimator, final long duration, final View child) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(changeReason);
        dsTaint.addTaint(duration);
        dsTaint.addTaint(baseAnimator.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        {
            boolean varA6A7315ADDDC59C70ED73956C763A706_1498519287 = (layoutChangeListenerMap.get(child) != null);
        } //End collapsed parenthetic
        final Animator anim;
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
            @Override
            public void onAnimationEnd(Animator animation) {
                pendingAnimations.remove(child);
            }
        });
        pendingAnimRemover.start();
        final View.OnLayoutChangeListener listener;
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
            @Override
            public void onAnimationStart(Animator animator) {
                if (mListeners != null) {
                    for (TransitionListener listener : mListeners) {
                        listener.startTransition(LayoutTransition.this, parent, child,
                                changeReason == APPEARING ?
                                        CHANGE_APPEARING : CHANGE_DISAPPEARING);
                    }
                }
            }
            @Override
            public void onAnimationCancel(Animator animator) {
                child.removeOnLayoutChangeListener(listener);
                layoutChangeListenerMap.remove(child);
            }
            @Override
            public void onAnimationEnd(Animator animator) {
                currentChangingAnimations.remove(child);
                if (mListeners != null) {
                    for (TransitionListener listener : mListeners) {
                        listener.endTransition(LayoutTransition.this, parent, child,
                                changeReason == APPEARING ?
                                        CHANGE_APPEARING : CHANGE_DISAPPEARING);
                    }
                }
            }
        });
        child.addOnLayoutChangeListener(listener);
        layoutChangeListenerMap.put(child, listener);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.153 -0400", hash_original_method = "7222BE89A56886A0CF62DC8766C00475", hash_generated_method = "ED177C01D390D0E8DE09E82145AD6DF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startChangingAnimations() {
        LinkedHashMap<View, Animator> currentAnimCopy;
        currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
        {
            Iterator<Animator> seatecAstronomy42 = currentAnimCopy.values().iterator();
            seatecAstronomy42.hasNext();
            Animator anim = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.154 -0400", hash_original_method = "7BA742550F1E1298AB8FE77F45C4383D", hash_generated_method = "67DC3518505FFC160132A70BD3DD5F14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void endChangingAnimations() {
        LinkedHashMap<View, Animator> currentAnimCopy;
        currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
        {
            Iterator<Animator> seatecAstronomy42 = currentAnimCopy.values().iterator();
            seatecAstronomy42.hasNext();
            Animator anim = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.155 -0400", hash_original_method = "8C9364165F532DD8BD43415668542398", hash_generated_method = "F5C4B8CB7FC6316E057F9B495D658C45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isChangingLayout() {
        boolean var4077384608DE00EFE78F41629DE0A95B_70638423 = ((currentChangingAnimations.size() > 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (currentChangingAnimations.size() > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.156 -0400", hash_original_method = "7F683046BB72ECC23A172B1D3B81B266", hash_generated_method = "E2FE6DFC51F69B2B891045EF5DFFFF22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isRunning() {
        boolean var987B4F52345B82CBBAB6F416FA45A0C5_273896626 = ((currentChangingAnimations.size() > 0 || currentAppearingAnimations.size() > 0 ||
                currentDisappearingAnimations.size() > 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (currentChangingAnimations.size() > 0 || currentAppearingAnimations.size() > 0 ||
                //currentDisappearingAnimations.size() > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.157 -0400", hash_original_method = "2E46A59670A61A0AF64FD97BDAF7B728", hash_generated_method = "BD88B2DA5979B4FEE4EB7D64D2C3794D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancel() {
        {
            boolean var33AE39A73D9B32AC5849C5A957F93302_1890783315 = (currentChangingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
                {
                    Iterator<Animator> seatecAstronomy42 = currentAnimCopy.values().iterator();
                    seatecAstronomy42.hasNext();
                    Animator anim = seatecAstronomy42.next();
                    {
                        anim.cancel();
                    } //End block
                } //End collapsed parenthetic
                currentChangingAnimations.clear();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var581E5FE1178D7616A969479C9EF98728_1105707579 = (currentAppearingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentAppearingAnimations.clone();
                {
                    Iterator<Animator> seatecAstronomy42 = currentAnimCopy.values().iterator();
                    seatecAstronomy42.hasNext();
                    Animator anim = seatecAstronomy42.next();
                    {
                        anim.end();
                    } //End block
                } //End collapsed parenthetic
                currentAppearingAnimations.clear();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var08F255EDB4B7971930CFAED58C7D7CB3_536928852 = (currentDisappearingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentDisappearingAnimations.clone();
                {
                    Iterator<Animator> seatecAstronomy42 = currentAnimCopy.values().iterator();
                    seatecAstronomy42.hasNext();
                    Animator anim = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.159 -0400", hash_original_method = "19B870791205108BA3B602A2E8CB5138", hash_generated_method = "8646B669490C952749D2B657CEC688CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancel(int transitionType) {
        dsTaint.addTaint(transitionType);
        //Begin case CHANGE_APPEARING CHANGE_DISAPPEARING 
        {
            boolean var33AE39A73D9B32AC5849C5A957F93302_157722262 = (currentChangingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
                {
                    Iterator<Animator> seatecAstronomy42 = currentAnimCopy.values().iterator();
                    seatecAstronomy42.hasNext();
                    Animator anim = seatecAstronomy42.next();
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
            boolean var581E5FE1178D7616A969479C9EF98728_1071611892 = (currentAppearingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentAppearingAnimations.clone();
                {
                    Iterator<Animator> seatecAstronomy42 = currentAnimCopy.values().iterator();
                    seatecAstronomy42.hasNext();
                    Animator anim = seatecAstronomy42.next();
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
            boolean var08F255EDB4B7971930CFAED58C7D7CB3_51398373 = (currentDisappearingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentDisappearingAnimations.clone();
                {
                    Iterator<Animator> seatecAstronomy42 = currentAnimCopy.values().iterator();
                    seatecAstronomy42.hasNext();
                    Animator anim = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.162 -0400", hash_original_method = "071036D6A0EA050ACF09A35752DC1D52", hash_generated_method = "AEF13BBCDB4CB2E832A5C1668DA0376A")
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
                    Iterator<TransitionListener> seatecAstronomy42 = mListeners.iterator();
                    seatecAstronomy42.hasNext();
                    TransitionListener listener = seatecAstronomy42.next();
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
                @Override
                public void onAnimationEnd(Animator anim) {
                    currentAppearingAnimations.remove(child);
                    for (TransitionListener listener : mListeners) {
                        listener.endTransition(LayoutTransition.this, parent, child, APPEARING);
                    }
                }
            });
        } //End block
        currentAppearingAnimations.put(child, anim);
        anim.start();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.164 -0400", hash_original_method = "202CDBACC5F0926CC1D7E1540267464D", hash_generated_method = "508CC2E445D029A86AD3DB24A99E68BC")
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
                    Iterator<TransitionListener> seatecAstronomy42 = mListeners.iterator();
                    seatecAstronomy42.hasNext();
                    TransitionListener listener = seatecAstronomy42.next();
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
                @Override
                public void onAnimationEnd(Animator anim) {
                    currentDisappearingAnimations.remove(child);
                    for (TransitionListener listener : mListeners) {
                        listener.endTransition(LayoutTransition.this, parent, child, DISAPPEARING);
                    }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.165 -0400", hash_original_method = "05533C05F33D5C5B655A5BABA4CC6F65", hash_generated_method = "41ACB99BD3D73AED8AD095ECCB8531CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addChild(ViewGroup parent, View child) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        cancel(DISAPPEARING);
        cancel(CHANGE_APPEARING);
        {
            {
                Iterator<TransitionListener> seatecAstronomy42 = mListeners.iterator();
                seatecAstronomy42.hasNext();
                TransitionListener listener = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.166 -0400", hash_original_method = "5867E97EE566113A4AD2D7416A9B4CB1", hash_generated_method = "715D915FD422CE4B984A17AA581EB56A")
    @DSModeled(DSC.SAFE)
    public void showChild(ViewGroup parent, View child) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        addChild(parent, child);
        // ---------- Original Method ----------
        //addChild(parent, child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.167 -0400", hash_original_method = "E23F457F66AC508EC3728A00193F4832", hash_generated_method = "AD64E1A426EB935F568A1D091D56D995")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeChild(ViewGroup parent, View child) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        cancel(APPEARING);
        cancel(CHANGE_DISAPPEARING);
        {
            {
                Iterator<TransitionListener> seatecAstronomy42 = mListeners.iterator();
                seatecAstronomy42.hasNext();
                TransitionListener listener = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.168 -0400", hash_original_method = "59CF94EEC1336BEEB8FFF5467E6ED5F9", hash_generated_method = "90AE9C46E36E64AAA2688D7B7BD04245")
    @DSModeled(DSC.SAFE)
    public void hideChild(ViewGroup parent, View child) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        removeChild(parent, child);
        // ---------- Original Method ----------
        //removeChild(parent, child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.168 -0400", hash_original_method = "167EED27AB5F7469F2545513C43EBDC4", hash_generated_method = "1253E137999DF88A1D6B39300CEC9A30")
    @DSModeled(DSC.SAFE)
    public void addTransitionListener(TransitionListener listener) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.169 -0400", hash_original_method = "CD0DE6419C69039B8FDEE8C2D5BC497D", hash_generated_method = "D6B240515321C790F8717B7732C581F7")
    @DSModeled(DSC.SAFE)
    public void removeTransitionListener(TransitionListener listener) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(listener.dsTaint);
        mListeners.remove(listener);
        // ---------- Original Method ----------
        //if (mListeners == null) {
            //return;
        //}
        //mListeners.remove(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.170 -0400", hash_original_method = "F0DD3EC0CE94CE6304D7C3009A3E39A6", hash_generated_method = "7415865CD6F60CFE1E7B95ABAE05F0A0")
    @DSModeled(DSC.SAFE)
    public List<TransitionListener> getTransitionListeners() {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
    
}


