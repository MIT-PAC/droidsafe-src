package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

public abstract class AdapterViewAnimator extends AdapterView<Adapter> implements RemoteViewsAdapter.RemoteAdapterConnectionCallback, Advanceable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.376 -0500", hash_original_field = "15AE70B28988206776965B45142D9A41", hash_generated_field = "3A652617CCF7727670B8485C49C1574A")

    private static final String TAG = "RemoteViewAnimator";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.420 -0500", hash_original_field = "E2DD16B83E5DF8AC65DB2FEE126833FE", hash_generated_field = "94E9E36D497ACD2451DC65DFC34FDE84")

    static final int TOUCH_MODE_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.423 -0500", hash_original_field = "60B5C3F2E3E50B1F26E588806EE6DE9A", hash_generated_field = "016189EFF611A0FE1D4693C1CCBDA407")

    static final int TOUCH_MODE_DOWN_IN_CURRENT_VIEW = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.425 -0500", hash_original_field = "D780916905B22C778FD004C9E756F745", hash_generated_field = "7488778163D886E6949F033B92DE547C")

    static final int TOUCH_MODE_HANDLED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.429 -0500", hash_original_field = "7C4B93ADEC90FA6A96C10557965974CC", hash_generated_field = "F6CDC47961A92F3B929B6B11861E0C14")

    private static final int DEFAULT_ANIMATION_DURATION = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.378 -0500", hash_original_field = "A4199CA8B30F98AAF67F6FDF10E09266", hash_generated_field = "A4199CA8B30F98AAF67F6FDF10E09266")

    int mWhichChild = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.380 -0500", hash_original_field = "1E55CFCB40F18614F1B34B3329121F1C", hash_generated_field = "A493EB2C57153A47A21988AED08A61F9")

    private int mRestoreWhichChild = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.382 -0500", hash_original_field = "11022FC94DBD000AF0F23EE6D44DA07A", hash_generated_field = "11022FC94DBD000AF0F23EE6D44DA07A")

    boolean mAnimateFirstTime = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.384 -0500", hash_original_field = "1CB8D73EF29501CAF0F770C194E4A275", hash_generated_field = "1CB8D73EF29501CAF0F770C194E4A275")

    int mActiveOffset = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.386 -0500", hash_original_field = "F89A42DD2C5934C96B97C28D423189DC", hash_generated_field = "F89A42DD2C5934C96B97C28D423189DC")

    int mMaxNumActiveViews = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.388 -0500", hash_original_field = "0CC41FBC4366667A564C06DC4F0D9357", hash_generated_field = "0CC41FBC4366667A564C06DC4F0D9357")

    HashMap<Integer, ViewAndMetaData> mViewsMap = new HashMap<Integer, ViewAndMetaData>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.390 -0500", hash_original_field = "DCC538958BCCC098025B00C03E72E198", hash_generated_field = "DCC538958BCCC098025B00C03E72E198")

    ArrayList<Integer> mPreviousViews;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.392 -0500", hash_original_field = "3A6641FE6CF608A1624B00F1DAB420F6", hash_generated_field = "3A6641FE6CF608A1624B00F1DAB420F6")

    int mCurrentWindowStart = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.394 -0500", hash_original_field = "F84B4803BE53A338433E57C705009CC2", hash_generated_field = "F84B4803BE53A338433E57C705009CC2")

    int mCurrentWindowEnd = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.396 -0500", hash_original_field = "875B8F5BD30A8973DBF780138CCA9A4B", hash_generated_field = "875B8F5BD30A8973DBF780138CCA9A4B")

    int mCurrentWindowStartUnbounded = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.397 -0500", hash_original_field = "C2A92A98CA414A0C47C4CCACBB8EA2C2", hash_generated_field = "C2A92A98CA414A0C47C4CCACBB8EA2C2")

    AdapterDataSetObserver mDataSetObserver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.399 -0500", hash_original_field = "2CCFA3B9041B42EEC769AA09DF8CA535", hash_generated_field = "2CCFA3B9041B42EEC769AA09DF8CA535")

    Adapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.401 -0500", hash_original_field = "6C2145BBB74854B314D98BC5E793C836", hash_generated_field = "6C2145BBB74854B314D98BC5E793C836")

    RemoteViewsAdapter mRemoteViewsAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.404 -0500", hash_original_field = "D8481D38E4E063E4EC28948859294EB6", hash_generated_field = "D8481D38E4E063E4EC28948859294EB6")

    boolean mDeferNotifyDataSetChanged = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.406 -0500", hash_original_field = "319BF9E49F2FBE9453A9508A3A60521D", hash_generated_field = "319BF9E49F2FBE9453A9508A3A60521D")

    boolean mFirstTime = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.408 -0500", hash_original_field = "EE119C98E20A644961B6553C661011C0", hash_generated_field = "EE119C98E20A644961B6553C661011C0")

    boolean mLoopViews = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.410 -0500", hash_original_field = "A104F61DF317955825146E40FC0C3A53", hash_generated_field = "A104F61DF317955825146E40FC0C3A53")

    int mReferenceChildWidth = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.412 -0500", hash_original_field = "FD007F8803D65B2ABC0CC17D246ED815", hash_generated_field = "FD007F8803D65B2ABC0CC17D246ED815")

    int mReferenceChildHeight = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.414 -0500", hash_original_field = "C00C0EA8F9B59A998740D4241DDCA251", hash_generated_field = "C00C0EA8F9B59A998740D4241DDCA251")

    ObjectAnimator mInAnimation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.415 -0500", hash_original_field = "4FC9F8644D505DE7FB36472E6D47BDF1", hash_generated_field = "4FC9F8644D505DE7FB36472E6D47BDF1")

    ObjectAnimator mOutAnimation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.417 -0500", hash_original_field = "66B0F908555DBB95D9290020FFA7CAB3", hash_generated_field = "9849E22BF41E24F9EE56259FB24FEA91")

    private int mTouchMode = TOUCH_MODE_NONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.427 -0500", hash_original_field = "F3CF806FFB4C33156882341FD42C8EAB", hash_generated_field = "C7859F448E179D513123D1E080D96FF5")

    private Runnable mPendingCheckForTap;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.431 -0500", hash_original_method = "5A28C6E6B4D6383379224D19746F7CDC", hash_generated_method = "F8A11874EB4985473EE0C2CA9B2C56F0")
    
public AdapterViewAnimator(Context context) {
        this(context, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.434 -0500", hash_original_method = "ADD24FA1FA279C1B8387D7B0109F9EEC", hash_generated_method = "AB6BC801BD81C35C61A819C26913A433")
    
public AdapterViewAnimator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.437 -0500", hash_original_method = "C5643612A08EABEF3EDB2D9CFA87FEC7", hash_generated_method = "F6C673D6425F0E1F00DFBD5760BB6E60")
    
public AdapterViewAnimator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.AdapterViewAnimator, defStyleAttr, 0);
        int resource = a.getResourceId(
                com.android.internal.R.styleable.AdapterViewAnimator_inAnimation, 0);
        if (resource > 0) {
            setInAnimation(context, resource);
        } else {
            setInAnimation(getDefaultInAnimation());
        }

        resource = a.getResourceId(com.android.internal.R.styleable.AdapterViewAnimator_outAnimation, 0);
        if (resource > 0) {
            setOutAnimation(context, resource);
        } else {
            setOutAnimation(getDefaultOutAnimation());
        }

        boolean flag = a.getBoolean(
                com.android.internal.R.styleable.AdapterViewAnimator_animateFirstView, true);
        setAnimateFirstView(flag);

        mLoopViews = a.getBoolean(
                com.android.internal.R.styleable.AdapterViewAnimator_loopViews, false);

        a.recycle();

        initViewAnimator();
    }

    /**
     * Initialize this {@link AdapterViewAnimator}
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.440 -0500", hash_original_method = "4508B464C0C2084478BE2A642B32436E", hash_generated_method = "E7312D2EEF68D1DD75FC11CFD9B6019C")
    
private void initViewAnimator() {
        mPreviousViews = new ArrayList<Integer>();
    }

    /**
     * This method is used by subclasses to configure the animator to display the
     * desired number of views, and specify the offset
     *
     * @param numVisibleViews The number of views the animator keeps in the {@link ViewGroup}
     * @param activeOffset This parameter specifies where the current index ({@link #mWhichChild})
     *        sits within the window. For example if activeOffset is 1, and numVisibleViews is 3,
     *        and {@link #setDisplayedChild(int)} is called with 10, then the effective window will
     *        be the indexes 9, 10, and 11. In the same example, if activeOffset were 0, then the
     *        window would instead contain indexes 10, 11 and 12.
     * @param shouldLoop If the animator is show view 0, and setPrevious() is called, do we
     *        we loop back to the end, or do we do nothing
     */
     @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.455 -0500", hash_original_method = "91B9FA80E0031C77B528C608AC4759E5", hash_generated_method = "E6943E699166CD8D0B5A859437A889EA")
    
void configureViewAnimator(int numVisibleViews, int activeOffset) {
        if (activeOffset > numVisibleViews - 1) {
            // Throw an exception here.
        }
        mMaxNumActiveViews = numVisibleViews;
        mActiveOffset = activeOffset;
        mPreviousViews.clear();
        mViewsMap.clear();
        removeAllViewsInLayout();
        mCurrentWindowStart = 0;
        mCurrentWindowEnd = -1;
    }

    /**
     * This class should be overridden by subclasses to customize view transitions within
     * the set of visible views
     *
     * @param fromIndex The relative index within the window that the view was in, -1 if it wasn't
     *        in the window
     * @param toIndex The relative index within the window that the view is going to, -1 if it is
     *        being removed
     * @param view The view that is being animated
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.457 -0500", hash_original_method = "CD78C78157016071B0AA2236145765B6", hash_generated_method = "CD78C78157016071B0AA2236145765B6")
    
void transformViewForTransition(int fromIndex, int toIndex, View view, boolean animate) {
        if (fromIndex == -1) {
            mInAnimation.setTarget(view);
            mInAnimation.start();
        } else if (toIndex == -1) {
            mOutAnimation.setTarget(view);
            mOutAnimation.start();
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.459 -0500", hash_original_method = "1B47254A99E5F108270897DC3078BE58", hash_generated_method = "1B47254A99E5F108270897DC3078BE58")
    
ObjectAnimator getDefaultInAnimation() {
        ObjectAnimator anim = ObjectAnimator.ofFloat(null, "alpha", 0.0f, 1.0f);
        anim.setDuration(DEFAULT_ANIMATION_DURATION);
        return anim;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.461 -0500", hash_original_method = "FB8DA060E53CA502AAAD2E0D3630FF89", hash_generated_method = "FB8DA060E53CA502AAAD2E0D3630FF89")
    
ObjectAnimator getDefaultOutAnimation() {
        ObjectAnimator anim = ObjectAnimator.ofFloat(null, "alpha", 1.0f, 0.0f);
        anim.setDuration(DEFAULT_ANIMATION_DURATION);
        return anim;
    }

    /**
     * Sets which child view will be displayed.
     *
     * @param whichChild the index of the child view to display
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.463 -0500", hash_original_method = "C45281778BDF4A98514907509DE78D33", hash_generated_method = "BA235B9C8575E242029D74BBE31EB9D2")
    
@android.view.RemotableViewMethod
    public void setDisplayedChild(int whichChild) {
        setDisplayedChild(whichChild, true);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.466 -0500", hash_original_method = "91CB6634BDE3355704A6B2B246DAA7A9", hash_generated_method = "EF4943262A0A8830C80F7C891ECE0FE8")
    
private void setDisplayedChild(int whichChild, boolean animate) {
        if (mAdapter != null) {
            mWhichChild = whichChild;
            if (whichChild >= getWindowSize()) {
                mWhichChild = mLoopViews ? 0 : getWindowSize() - 1;
            } else if (whichChild < 0) {
                mWhichChild = mLoopViews ? getWindowSize() - 1 : 0;
            }

            boolean hasFocus = getFocusedChild() != null;
            // This will clear old focus if we had it
            showOnly(mWhichChild, animate);
            if (hasFocus) {
                // Try to retake focus if we had it
                requestFocus(FOCUS_FORWARD);
            }
        }
    }

    /**
     * To be overridden by subclasses. This method applies a view / index specific
     * transform to the child view.
     *
     * @param child
     * @param relativeIndex
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.468 -0500", hash_original_method = "A7ED1EB61B0FBCD2BEBD15D1C1303F9C", hash_generated_method = "A7ED1EB61B0FBCD2BEBD15D1C1303F9C")
    
void applyTransformForChildAtIndex(View child, int relativeIndex) {
    }

    /**
     * Returns the index of the currently displayed child view.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.470 -0500", hash_original_method = "EEFA4D3ABF985412351A1BD0CB5D6161", hash_generated_method = "7CCCB2C258F137F09749CB31D2CA0D0D")
    
public int getDisplayedChild() {
        return mWhichChild;
    }

    /**
     * Manually shows the next child.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.472 -0500", hash_original_method = "EFCC34AA69F6F34103211EDFAD5FB56A", hash_generated_method = "9D84899AE91390F5AEE34C64C9A5F8AF")
    
public void showNext() {
        setDisplayedChild(mWhichChild + 1);
    }

    /**
     * Manually shows the previous child.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.475 -0500", hash_original_method = "F846DD3340718784FB63764FD5BBF0F3", hash_generated_method = "213C0CEDC11BEF1A8137FD5F192CE2C3")
    
public void showPrevious() {
        setDisplayedChild(mWhichChild - 1);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.477 -0500", hash_original_method = "2C561D0D9BDC240B9A5D5DE9ED7CC2E1", hash_generated_method = "2C561D0D9BDC240B9A5D5DE9ED7CC2E1")
    
int modulo(int pos, int size) {
        if (size > 0) {
            return (size + (pos % size)) % size;
        } else {
            return 0;
        }
    }

    /**
     * Get the view at this index relative to the current window's start
     *
     * @param relativeIndex Position relative to the current window's start
     * @return View at this index, null if the index is outside the bounds
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.480 -0500", hash_original_method = "FBBD82E59359C019A1CEF3EB94A89AA2", hash_generated_method = "FBBD82E59359C019A1CEF3EB94A89AA2")
    
View getViewAtRelativeIndex(int relativeIndex) {
        if (relativeIndex >= 0 && relativeIndex <= getNumActiveViews() - 1 && mAdapter != null) {
            int i = modulo(mCurrentWindowStartUnbounded + relativeIndex, getWindowSize());
            if (mViewsMap.get(i) != null) {
                return mViewsMap.get(i).view;
            }
        }
        return null;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.482 -0500", hash_original_method = "0421178BBB7DE66A738CAA04F8761832", hash_generated_method = "0421178BBB7DE66A738CAA04F8761832")
    
int getNumActiveViews() {
        if (mAdapter != null) {
            return Math.min(getCount() + 1, mMaxNumActiveViews);
        } else {
            return mMaxNumActiveViews;
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.484 -0500", hash_original_method = "6029719CD1CD7AB457F8E78F86AE86A1", hash_generated_method = "6029719CD1CD7AB457F8E78F86AE86A1")
    
int getWindowSize() {
        if (mAdapter != null) {
            int adapterCount = getCount();
            if (adapterCount <= getNumActiveViews() && mLoopViews) {
                return adapterCount*mMaxNumActiveViews;
            } else {
                return adapterCount;
            }
        } else {
            return 0;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.486 -0500", hash_original_method = "1D56DD893F980F245C60382C98FF1278", hash_generated_method = "B578AAF02304B285E2112CBC6C31B3FE")
    
private ViewAndMetaData getMetaDataForChild(View child) {
        for (ViewAndMetaData vm: mViewsMap.values()) {
            if (vm.view == child) {
                return vm;
            }
        }
        return null;
     }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.488 -0500", hash_original_method = "F5EC02A85B8BD647E297FF00917E7C1D", hash_generated_method = "F5EC02A85B8BD647E297FF00917E7C1D")
    
LayoutParams createOrReuseLayoutParams(View v) {
        final ViewGroup.LayoutParams currentLp = v.getLayoutParams();
        if (currentLp instanceof ViewGroup.LayoutParams) {
            LayoutParams lp = (LayoutParams) currentLp;
            return lp;
        }
        return new ViewGroup.LayoutParams(0, 0);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.491 -0500", hash_original_method = "DEC1654E1282F99AB82BE6A9F7EE0E03", hash_generated_method = "8E8E209FC8B2C875AD52DE3894BCA0EA")
    
void refreshChildren() {
        if (mAdapter == null) return;
        for (int i = mCurrentWindowStart; i <= mCurrentWindowEnd; i++) {
            int index = modulo(i, getWindowSize());

            int adapterCount = getCount();
            // get the fresh child from the adapter
            final View updatedChild = mAdapter.getView(modulo(i, adapterCount), null, this);

            if (mViewsMap.containsKey(index)) {
                final FrameLayout fl = (FrameLayout) mViewsMap.get(index).view;
                // add the new child to the frame, if it exists
                if (updatedChild != null) {
                    // flush out the old child
                    fl.removeAllViewsInLayout();
                    fl.addView(updatedChild);
                }
            }
        }
    }

    /**
     * This method can be overridden so that subclasses can provide a custom frame in which their
     * children can live. For example, StackView adds padding to its childrens' frames so as to
     * accomodate for the highlight effect.
     *
     * @return The FrameLayout into which children can be placed.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.493 -0500", hash_original_method = "3A74ED5464ECC3EDCA3FF6D985E482E9", hash_generated_method = "3A74ED5464ECC3EDCA3FF6D985E482E9")
    
FrameLayout getFrameForChild() {
        return new FrameLayout(mContext);
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
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.496 -0500", hash_original_method = "65797EBCBD60DE13415615382F58C13B", hash_generated_method = "18A8B821F4EC1624EBF26585D79CE0EF")
    
void showOnly(int childIndex, boolean animate) {
        if (mAdapter == null) return;
        final int adapterCount = getCount();
        if (adapterCount == 0) return;

        for (int i = 0; i < mPreviousViews.size(); i++) {
            View viewToRemove = mViewsMap.get(mPreviousViews.get(i)).view;
            mViewsMap.remove(mPreviousViews.get(i));
            viewToRemove.clearAnimation();
            if (viewToRemove instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) viewToRemove;
                vg.removeAllViewsInLayout();
            }
            // applyTransformForChildAtIndex here just allows for any cleanup
            // associated with this view that may need to be done by a subclass
            applyTransformForChildAtIndex(viewToRemove, -1);

            removeViewInLayout(viewToRemove);
        }
        mPreviousViews.clear();
        int newWindowStartUnbounded = childIndex - mActiveOffset;
        int newWindowEndUnbounded = newWindowStartUnbounded + getNumActiveViews() - 1;
        int newWindowStart = Math.max(0, newWindowStartUnbounded);
        int newWindowEnd = Math.min(adapterCount - 1, newWindowEndUnbounded);

        if (mLoopViews) {
            newWindowStart = newWindowStartUnbounded;
            newWindowEnd = newWindowEndUnbounded;
        }
        int rangeStart = modulo(newWindowStart, getWindowSize());
        int rangeEnd = modulo(newWindowEnd, getWindowSize());

        boolean wrap = false;
        if (rangeStart > rangeEnd) {
            wrap = true;
        }

        // This section clears out any items that are in our active views list
        // but are outside the effective bounds of our window (this is becomes an issue
        // at the extremities of the list, eg. where newWindowStartUnbounded < 0 or
        // newWindowEndUnbounded > adapterCount - 1
        for (Integer index : mViewsMap.keySet()) {
            boolean remove = false;
            if (!wrap && (index < rangeStart || index > rangeEnd)) {
                remove = true;
            } else if (wrap && (index > rangeEnd && index < rangeStart)) {
                remove = true;
            }

            if (remove) {
                View previousView = mViewsMap.get(index).view;
                int oldRelativeIndex = mViewsMap.get(index).relativeIndex;

                mPreviousViews.add(index);
                transformViewForTransition(oldRelativeIndex, -1, previousView, animate);
            }
        }

        // If the window has changed
        if (!(newWindowStart == mCurrentWindowStart && newWindowEnd == mCurrentWindowEnd &&
              newWindowStartUnbounded == mCurrentWindowStartUnbounded)) {
            // Run through the indices in the new range
            for (int i = newWindowStart; i <= newWindowEnd; i++) {

                int index = modulo(i, getWindowSize());
                int oldRelativeIndex;
                if (mViewsMap.containsKey(index)) {
                    oldRelativeIndex = mViewsMap.get(index).relativeIndex;
                } else {
                    oldRelativeIndex = -1;
                }
                int newRelativeIndex = i - newWindowStartUnbounded;

                // If this item is in the current window, great, we just need to apply
                // the transform for it's new relative position in the window, and animate
                // between it's current and new relative positions
                boolean inOldRange = mViewsMap.containsKey(index) && !mPreviousViews.contains(index);

                if (inOldRange) {
                    View view = mViewsMap.get(index).view;
                    mViewsMap.get(index).relativeIndex = newRelativeIndex;
                    applyTransformForChildAtIndex(view, newRelativeIndex);
                    transformViewForTransition(oldRelativeIndex, newRelativeIndex, view, animate);

                // Otherwise this view is new to the window
                } else {
                    // Get the new view from the adapter, add it and apply any transform / animation
                    final int adapterPosition = modulo(i, adapterCount);
                    View newView = mAdapter.getView(adapterPosition, null, this);
                    long itemId = mAdapter.getItemId(adapterPosition);

                    // We wrap the new view in a FrameLayout so as to respect the contract
                    // with the adapter, that is, that we don't modify this view directly
                    FrameLayout fl = getFrameForChild();

                    // If the view from the adapter is null, we still keep an empty frame in place
                    if (newView != null) {
                       fl.addView(newView);
                    }
                    mViewsMap.put(index, new ViewAndMetaData(fl, newRelativeIndex,
                            adapterPosition, itemId));
                    addChild(fl);
                    applyTransformForChildAtIndex(fl, newRelativeIndex);
                    transformViewForTransition(-1, newRelativeIndex, fl, animate);
                }
                mViewsMap.get(index).view.bringToFront();
            }
            mCurrentWindowStart = newWindowStart;
            mCurrentWindowEnd = newWindowEnd;
            mCurrentWindowStartUnbounded = newWindowStartUnbounded;
        }
        requestLayout();
        invalidate();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.499 -0500", hash_original_method = "CF7E9270D6A781D39501E4BBAEBB3A13", hash_generated_method = "94CDBD4B975DB8AE19E2C2FA0917B3EE")
    
private void addChild(View child) {
        addViewInLayout(child, -1, createOrReuseLayoutParams(child));

        // This code is used to obtain a reference width and height of a child in case we need
        // to decide our own size. TODO: Do we want to update the size of the child that we're
        // using for reference size? If so, when?
        if (mReferenceChildWidth == -1 || mReferenceChildHeight == -1) {
            int measureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            child.measure(measureSpec, measureSpec);
            mReferenceChildWidth = child.getMeasuredWidth();
            mReferenceChildHeight = child.getMeasuredHeight();
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.501 -0500", hash_original_method = "2ABC3404C13E4A800F47D0C635B72929", hash_generated_method = "2ABC3404C13E4A800F47D0C635B72929")
    
void showTapFeedback(View v) {
        v.setPressed(true);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.503 -0500", hash_original_method = "AB8C1F9AF8BDC4DF902FB7F7CD728C3A", hash_generated_method = "AB8C1F9AF8BDC4DF902FB7F7CD728C3A")
    
void hideTapFeedback(View v) {
        v.setPressed(false);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.505 -0500", hash_original_method = "67399547287D8F71A7A5AE67A071254C", hash_generated_method = "67399547287D8F71A7A5AE67A071254C")
    
void cancelHandleClick() {
        View v = getCurrentView();
        if (v != null) {
            hideTapFeedback(v);
        }
        mTouchMode = TOUCH_MODE_NONE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.522 -0500", hash_original_method = "A2B685172F5BE99872ECD239B8E084E5", hash_generated_method = "085460C7FA75B37C37D31BFC1D91DC8E")
    
@Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        boolean handled = false;
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                View v = getCurrentView();
                if (v != null) {
                    if (isTransformedTouchPointInView(ev.getX(), ev.getY(), v, null)) {
                        if (mPendingCheckForTap == null) {
                            mPendingCheckForTap = new CheckForTap();
                        }
                        mTouchMode = TOUCH_MODE_DOWN_IN_CURRENT_VIEW;
                        postDelayed(mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                    }
                }
                break;
            }
            case MotionEvent.ACTION_MOVE: break;
            case MotionEvent.ACTION_POINTER_UP: break;
            case MotionEvent.ACTION_UP: {
                if (mTouchMode == TOUCH_MODE_DOWN_IN_CURRENT_VIEW) {
                    final View v = getCurrentView();
                    final ViewAndMetaData viewData = getMetaDataForChild(v);
                    if (v != null) {
                        if (isTransformedTouchPointInView(ev.getX(), ev.getY(), v, null)) {
                            final Handler handler = getHandler();
                            if (handler != null) {
                                handler.removeCallbacks(mPendingCheckForTap);
                            }
                            showTapFeedback(v);
                            postDelayed(new Runnable() {
                                public void run() {
                                    hideTapFeedback(v);
                                    post(new Runnable() {
                                        public void run() {
                                            if (viewData != null) {
                                                performItemClick(v, viewData.adapterPosition,
                                                        viewData.itemId);
                                            } else {
                                                performItemClick(v, 0, 0);
                                            }
                                        }
                                    });
                                }
                            }, ViewConfiguration.getPressedStateDuration());
                            handled = true;
                        }
                    }
                }
                mTouchMode = TOUCH_MODE_NONE;
                break;
            }
            case MotionEvent.ACTION_CANCEL: {
                View v = getCurrentView();
                if (v != null) {
                    hideTapFeedback(v);
                }
                mTouchMode = TOUCH_MODE_NONE;
            }
        }
        return handled;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.524 -0500", hash_original_method = "CF7CC5DB55CCFC095F8C480C67A97670", hash_generated_method = "8353998CA3AA7A37F69D5A5FCBCDE922")
    
private void measureChildren() {
        final int count = getChildCount();
        final int childWidth = getMeasuredWidth() - mPaddingLeft - mPaddingRight;
        final int childHeight = getMeasuredHeight() - mPaddingTop - mPaddingBottom;

        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            child.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.528 -0500", hash_original_method = "B8DC8FCB5714B92F7D9B397FCC5E6B1D", hash_generated_method = "90548D64DF3FC37F12CF3824A6DE1091")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        final int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        boolean haveChildRefSize = (mReferenceChildWidth != -1 && mReferenceChildHeight != -1);

        // We need to deal with the case where our parent hasn't told us how
        // big we should be. In this case we try to use the desired size of the first
        // child added.
        if (heightSpecMode == MeasureSpec.UNSPECIFIED) {
            heightSpecSize = haveChildRefSize ? mReferenceChildHeight + mPaddingTop +
                    mPaddingBottom : 0;
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            if (haveChildRefSize) {
                int height = mReferenceChildHeight + mPaddingTop + mPaddingBottom;
                if (height > heightSpecSize) {
                    heightSpecSize |= MEASURED_STATE_TOO_SMALL;
                } else {
                    heightSpecSize = height;
                }
            }
        }

        if (widthSpecMode == MeasureSpec.UNSPECIFIED) {
            widthSpecSize = haveChildRefSize ? mReferenceChildWidth + mPaddingLeft +
                    mPaddingRight : 0;
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            if (haveChildRefSize) {
                int width = mReferenceChildWidth + mPaddingLeft + mPaddingRight;
                if (width > widthSpecSize) {
                    widthSpecSize |= MEASURED_STATE_TOO_SMALL;
                } else {
                    widthSpecSize = width;
                }
            }
        }

        setMeasuredDimension(widthSpecSize, heightSpecSize);
        measureChildren();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.564 -0500", hash_original_method = "F3EF4D3CC56F2B38758DB6D9F3299660", hash_generated_method = "3BB22202D6405B1715E714512F7739CF")
    
void checkForAndHandleDataChanged() {
        boolean dataChanged = mDataChanged;
        if (dataChanged) {
            post(new Runnable() {
                public void run() {
                    handleDataChanged();
                    // if the data changes, mWhichChild might be out of the bounds of the adapter
                    // in this case, we reset mWhichChild to the beginning
                    if (mWhichChild >= getWindowSize()) {
                        mWhichChild = 0;

                        showOnly(mWhichChild, false);
                    } else if (mOldItemCount != getCount()) {
                        showOnly(mWhichChild, false);
                    }
                    refreshChildren();
                    requestLayout();
                }
            });
        }
        mDataChanged = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.569 -0500", hash_original_method = "BFF47184DAE09EA9D82185EB27DBF22D", hash_generated_method = "67D0619A3B8C326863E1756A4D2A16C9")
    
@Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        checkForAndHandleDataChanged();

        final int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = getChildAt(i);

            int childRight = mPaddingLeft + child.getMeasuredWidth();
            int childBottom = mPaddingTop + child.getMeasuredHeight();

            child.layout(mPaddingLeft, mPaddingTop, childRight, childBottom);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.611 -0500", hash_original_method = "C09C373B1A1103A4B30F4932FEFEB18D", hash_generated_method = "8D2EA4ED5957DAAB17AC309D3678E720")
    
@Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        return new SavedState(superState, mWhichChild);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.615 -0500", hash_original_method = "A2807F1883DAD1F14A6CC088A989D676", hash_generated_method = "7BAEC4531DE1888140D8B0523E2D6E73")
    
@Override
    public void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        // Here we set mWhichChild in addition to setDisplayedChild
        // We do the former in case mAdapter is null, and hence setDisplayedChild won't
        // set mWhichChild
        mWhichChild = ss.whichChild;

        // When using RemoteAdapters, the async connection process can lead to
        // onRestoreInstanceState to be called before setAdapter(), so we need to save the previous
        // values to restore the list position after we connect, and can skip setting the displayed
        // child until then.
        if (mRemoteViewsAdapter != null && mAdapter == null) {
            mRestoreWhichChild = mWhichChild;
        } else {
            setDisplayedChild(mWhichChild, false);
        }
    }

    /**
     * Returns the View corresponding to the currently displayed child.
     *
     * @return The View currently displayed.
     *
     * @see #getDisplayedChild()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.619 -0500", hash_original_method = "906CF989810621761D25CEDBF35A3122", hash_generated_method = "28A16321E361D283D7165F5FCAAC6E29")
    
public View getCurrentView() {
        return getViewAtRelativeIndex(mActiveOffset);
    }

    /**
     * Returns the current animation used to animate a View that enters the screen.
     *
     * @return An Animation or null if none is set.
     *
     * @see #setInAnimation(android.animation.ObjectAnimator)
     * @see #setInAnimation(android.content.Context, int)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.623 -0500", hash_original_method = "23AFF2D08DB63552361956C44B4439AE", hash_generated_method = "337FFEC168F6BA1440931AE012BD6B84")
    
public ObjectAnimator getInAnimation() {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.626 -0500", hash_original_method = "4E43CB38736F57C9005B93984FDB3BE2", hash_generated_method = "FDE58AAF34609C8339542AEFB9EF0658")
    
public void setInAnimation(ObjectAnimator inAnimation) {
        mInAnimation = inAnimation;
    }

    /**
     * Returns the current animation used to animate a View that exits the screen.
     *
     * @return An Animation or null if none is set.
     *
     * @see #setOutAnimation(android.animation.ObjectAnimator)
     * @see #setOutAnimation(android.content.Context, int)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.629 -0500", hash_original_method = "6B0CDF48C8054A61C9B211FDE065CA93", hash_generated_method = "B011ECCD0686190BDBCEC17874E77F9E")
    
public ObjectAnimator getOutAnimation() {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.633 -0500", hash_original_method = "1BCB8E8A3DAEDE15E6756EE2F683DC83", hash_generated_method = "F655B2DC6134D71BD12ABF63A96D8D6C")
    
public void setOutAnimation(ObjectAnimator outAnimation) {
        mOutAnimation = outAnimation;
    }

    /**
     * Specifies the animation used to animate a View that enters the screen.
     *
     * @param context The application's environment.
     * @param resourceID The resource id of the animation.
     *
     * @see #getInAnimation()
     * @see #setInAnimation(android.animation.ObjectAnimator)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.636 -0500", hash_original_method = "8F8897D1BAA8E5AE19C8237937D2CA37", hash_generated_method = "BDD340679F1D4A4EC54A5813B810A008")
    
public void setInAnimation(Context context, int resourceID) {
        setInAnimation((ObjectAnimator) AnimatorInflater.loadAnimator(context, resourceID));
    }

    /**
     * Specifies the animation used to animate a View that exit the screen.
     *
     * @param context The application's environment.
     * @param resourceID The resource id of the animation.
     *
     * @see #getOutAnimation()
     * @see #setOutAnimation(android.animation.ObjectAnimator)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.649 -0500", hash_original_method = "DAE8806685F393E416F20FAE75D3F12A", hash_generated_method = "7C6FD2BCABEF09E7ECDB2DFEA02F15BD")
    
public void setOutAnimation(Context context, int resourceID) {
        setOutAnimation((ObjectAnimator) AnimatorInflater.loadAnimator(context, resourceID));
    }

    /**
     * Indicates whether the current View should be animated the first time
     * the ViewAnimation is displayed.
     *
     * @param animate True to animate the current View the first time it is displayed,
     *                false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.652 -0500", hash_original_method = "8FC95409534ABC48E92905DC8C518CE2", hash_generated_method = "2161D1636A0BC5F12D5CCB943AE3E97C")
    
public void setAnimateFirstView(boolean animate) {
        mAnimateFirstTime = animate;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.656 -0500", hash_original_method = "0B91CAAE76789C8A4B2B18C9D0AAF852", hash_generated_method = "BC44695AA42F588274CA96129EE3350B")
    
@Override
    public int getBaseline() {
        return (getCurrentView() != null) ? getCurrentView().getBaseline() : super.getBaseline();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.659 -0500", hash_original_method = "4778E83EF7DB01E18145E85F688E24B4", hash_generated_method = "7074E68DF390D755A8C1C993C686683A")
    
@Override
    public Adapter getAdapter() {
        return mAdapter;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.664 -0500", hash_original_method = "8F781C0E336C7A94E2963F9C2B9D5E7F", hash_generated_method = "433BEDCF025EDA8170E668501EB4808B")
    
@Override
    public void setAdapter(Adapter adapter) {
        if (mAdapter != null && mDataSetObserver != null) {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        }

        mAdapter = adapter;
        checkFocus();

        if (mAdapter != null) {
            mDataSetObserver = new AdapterDataSetObserver();
            mAdapter.registerDataSetObserver(mDataSetObserver);
            mItemCount = mAdapter.getCount();
        }
        setFocusable(true);
        mWhichChild = 0;
        showOnly(mWhichChild, false);
    }

    /**
     * Sets up this AdapterViewAnimator to use a remote views adapter which connects to a
     * RemoteViewsService through the specified intent.
     *
     * @param intent the intent used to identify the RemoteViewsService for the adapter to
     *        connect to.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.668 -0500", hash_original_method = "27E899D618A9F50FEEEF08AE1A9356B2", hash_generated_method = "42C2AB37F27F8D286FA64AFAC3F089AE")
    
@android.view.RemotableViewMethod
    public void setRemoteViewsAdapter(Intent intent) {
        // Ensure that we don't already have a RemoteViewsAdapter that is bound to an existing
        // service handling the specified intent.
        if (mRemoteViewsAdapter != null) {
            Intent.FilterComparison fcNew = new Intent.FilterComparison(intent);
            Intent.FilterComparison fcOld = new Intent.FilterComparison(
                    mRemoteViewsAdapter.getRemoteViewsServiceIntent());
            if (fcNew.equals(fcOld)) {
                return;
            }
        }
        mDeferNotifyDataSetChanged = false;
        // Otherwise, create a new RemoteViewsAdapter for binding
        mRemoteViewsAdapter = new RemoteViewsAdapter(getContext(), intent, this);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.671 -0500", hash_original_method = "DA18836BD93C624B14E0649B9FD256B6", hash_generated_method = "04ADD3F82734D63EA2100D8EBB7DAC2D")
    
@Override
    public void setSelection(int position) {
        setDisplayedChild(position);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.674 -0500", hash_original_method = "B55B55B562FC01D014E8D16B89577F15", hash_generated_method = "CD1CA85B7EA8B0CF1A16A778FF8A3885")
    
@Override
    public View getSelectedView() {
        return getViewAtRelativeIndex(mActiveOffset);
    }
    
    class ViewAndMetaData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.443 -0500", hash_original_field = "203A52904F64FA8CF6CE15F1E8FE3025", hash_generated_field = "203A52904F64FA8CF6CE15F1E8FE3025")

        View view;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.445 -0500", hash_original_field = "F52544800E665053DD324CCFDCF1B6BE", hash_generated_field = "F52544800E665053DD324CCFDCF1B6BE")

        int relativeIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.447 -0500", hash_original_field = "F4E75FF2D1EE9ACFE3453A0D6E862D8C", hash_generated_field = "F4E75FF2D1EE9ACFE3453A0D6E862D8C")

        int adapterPosition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.449 -0500", hash_original_field = "90EEB5AA84937AD6A8CE9746B6FECA6A", hash_generated_field = "90EEB5AA84937AD6A8CE9746B6FECA6A")

        long itemId;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.452 -0500", hash_original_method = "35BDC394C726F4932D0D464E91A92D34", hash_generated_method = "35BDC394C726F4932D0D464E91A92D34")
        
ViewAndMetaData(View view, int relativeIndex, int adapterPosition, long itemId) {
            this.view = view;
            this.relativeIndex = relativeIndex;
            this.adapterPosition = adapterPosition;
            this.itemId = itemId;
        }
        
    }
    
    final class CheckForTap implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.535 -0400", hash_original_method = "AB5DEBF7CC7D6BE3A48A21837827B410", hash_generated_method = "AB5DEBF7CC7D6BE3A48A21837827B410")
        public CheckForTap ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.508 -0500", hash_original_method = "0DE0DC1F19EC8E43C86C5443C435E50A", hash_generated_method = "784003EA1EA1EB3B1E7FFD2639983D57")
        
public void run() {
            if (mTouchMode == TOUCH_MODE_DOWN_IN_CURRENT_VIEW) {
                View v = getCurrentView();
                showTapFeedback(v);
            }
        }
        
    }
    
    static class SavedState extends BaseSavedState {
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.536 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.596 -0500", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "C97AA17CB243756458D0FB7A2D786EA0")
            
public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.601 -0500", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "020465B62F970B98C266AF229149E391")
            
public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.573 -0500", hash_original_field = "522DBB163D0DA4822B2CF5511F1DEE9A", hash_generated_field = "522DBB163D0DA4822B2CF5511F1DEE9A")

        int whichChild;

        /**
         * Constructor called from {@link AdapterViewAnimator#onSaveInstanceState()}
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.578 -0500", hash_original_method = "B7BF12453E93628DE35CAA34B998429F", hash_generated_method = "B7BF12453E93628DE35CAA34B998429F")
        
SavedState(Parcelable superState, int whichChild) {
            super(superState);
            this.whichChild = whichChild;
        }

        /**
         * Constructor called from {@link #CREATOR}
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.582 -0500", hash_original_method = "392EDFCBBF619540219C8F70BEB96B16", hash_generated_method = "E74A3C95F94CE20D39360016741E18B1")
        
private SavedState(Parcel in) {
            super(in);
            this.whichChild = in.readInt();
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.586 -0500", hash_original_method = "DA40422C10B10105F9CB19E8091B3EEC", hash_generated_method = "BCFB9E62A4D01FE68F1307AE2618AC5F")
        
@Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.whichChild);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.590 -0500", hash_original_method = "808D88187ABBC8D595A46EE25C5AC5ED", hash_generated_method = "8010E7371F27313F1C5C64B46C856D2E")
        
@Override
        public String toString() {
            return "AdapterViewAnimator.SavedState{ whichChild = " + this.whichChild + " }";
        }
    }

    /**
     * This defers a notifyDataSetChanged on the pending RemoteViewsAdapter if it has not
     * connected yet.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.677 -0500", hash_original_method = "0410210FC7BC336B3896BEA7510AAE3D", hash_generated_method = "461FAAA0F6EB5E50DABF0D6CD6054FBC")
    
public void deferNotifyDataSetChanged() {
        mDeferNotifyDataSetChanged = true;
    }

    /**
     * Called back when the adapter connects to the RemoteViewsService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.681 -0500", hash_original_method = "9E5375D03017C5CE595A523DBE298043", hash_generated_method = "AE4507B3B94EE68FC57DD5F106438CE1")
    
public boolean onRemoteAdapterConnected() {
        if (mRemoteViewsAdapter != mAdapter) {
            setAdapter(mRemoteViewsAdapter);

            if (mDeferNotifyDataSetChanged) {
                mRemoteViewsAdapter.notifyDataSetChanged();
                mDeferNotifyDataSetChanged = false;
            }

            // Restore the previous position (see onRestoreInstanceState)
            if (mRestoreWhichChild > -1) {
                setDisplayedChild(mRestoreWhichChild, false);
                mRestoreWhichChild = -1;
            }
            return false;
        } else if (mRemoteViewsAdapter != null) {
            mRemoteViewsAdapter.superNotifyDataSetChanged();
            return true;
        }
        return false;
    }

    /**
     * Called back when the adapter disconnects from the RemoteViewsService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.684 -0500", hash_original_method = "062C10606C6763A75AEC213E65863835", hash_generated_method = "2A1BDF8455F53C3793A6BB8693DAE109")
    
public void onRemoteAdapterDisconnected() {
        // If the remote adapter disconnects, we keep it around
        // since the currently displayed items are still cached.
        // Further, we want the service to eventually reconnect
        // when necessary, as triggered by this view requesting
        // items from the Adapter.
    }

    /**
     * Called by an {@link android.appwidget.AppWidgetHost} in order to advance the current view when
     * it is being used within an app widget.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.687 -0500", hash_original_method = "47C53466AFD69B01265302F86E539CFE", hash_generated_method = "BEB6AE8625FD6C7F02F57CEC845DDB59")
    
public void advance() {
        showNext();
    }

    /**
     * Called by an {@link android.appwidget.AppWidgetHost} to indicate that it will be
     * automatically advancing the views of this {@link AdapterViewAnimator} by calling
     * {@link AdapterViewAnimator#advance()} at some point in the future. This allows subclasses to
     * perform any required setup, for example, to stop automatically advancing their children.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:20.691 -0500", hash_original_method = "1A32686EBDFA985B54B6CF53155BB413", hash_generated_method = "B8D54171679C68FE958EC5464CAB4FB4")
    
public void fyiWillBeAdvancedByHostKThx() {
    }
}

