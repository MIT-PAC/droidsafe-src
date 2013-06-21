package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import java.util.ArrayList;
import java.util.HashMap;

public abstract class AdapterViewAnimator extends AdapterView<Adapter> implements RemoteViewsAdapter.RemoteAdapterConnectionCallback, Advanceable {
    int mWhichChild = 0;
    private int mRestoreWhichChild = -1;
    boolean mAnimateFirstTime = true;
    int mActiveOffset = 0;
    int mMaxNumActiveViews = 1;
    HashMap<Integer, ViewAndMetaData> mViewsMap = new HashMap<Integer, ViewAndMetaData>();
    ArrayList<Integer> mPreviousViews;
    int mCurrentWindowStart = 0;
    int mCurrentWindowEnd = -1;
    int mCurrentWindowStartUnbounded = 0;
    AdapterDataSetObserver mDataSetObserver;
    Adapter mAdapter;
    RemoteViewsAdapter mRemoteViewsAdapter;
    boolean mDeferNotifyDataSetChanged = false;
    boolean mFirstTime = true;
    boolean mLoopViews = true;
    int mReferenceChildWidth = -1;
    int mReferenceChildHeight = -1;
    ObjectAnimator mInAnimation;
    ObjectAnimator mOutAnimation;
    private int mTouchMode = TOUCH_MODE_NONE;
    private Runnable mPendingCheckForTap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.205 -0400", hash_original_method = "5A28C6E6B4D6383379224D19746F7CDC", hash_generated_method = "4E928F64B4F923BE62F2AEF8FB2A6073")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AdapterViewAnimator(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.205 -0400", hash_original_method = "ADD24FA1FA279C1B8387D7B0109F9EEC", hash_generated_method = "CCD3F81FD17D3FD637D26B5AAFF8917D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AdapterViewAnimator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.206 -0400", hash_original_method = "C5643612A08EABEF3EDB2D9CFA87FEC7", hash_generated_method = "7659B123B2EDFD692E6F35CCABA2C1B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AdapterViewAnimator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        dsTaint.addTaint(defStyleAttr);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.AdapterViewAnimator, defStyleAttr, 0);
        int resource;
        resource = a.getResourceId(
                com.android.internal.R.styleable.AdapterViewAnimator_inAnimation, 0);
        {
            setInAnimation(context, resource);
        } //End block
        {
            setInAnimation(getDefaultInAnimation());
        } //End block
        resource = a.getResourceId(com.android.internal.R.styleable.AdapterViewAnimator_outAnimation, 0);
        {
            setOutAnimation(context, resource);
        } //End block
        {
            setOutAnimation(getDefaultOutAnimation());
        } //End block
        boolean flag;
        flag = a.getBoolean(
                com.android.internal.R.styleable.AdapterViewAnimator_animateFirstView, true);
        setAnimateFirstView(flag);
        mLoopViews = a.getBoolean(
                com.android.internal.R.styleable.AdapterViewAnimator_loopViews, false);
        a.recycle();
        initViewAnimator();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.206 -0400", hash_original_method = "4508B464C0C2084478BE2A642B32436E", hash_generated_method = "0AEEC796AE042A1371E848170F3AEF4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initViewAnimator() {
        mPreviousViews = new ArrayList<Integer>();
        // ---------- Original Method ----------
        //mPreviousViews = new ArrayList<Integer>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.206 -0400", hash_original_method = "91B9FA80E0031C77B528C608AC4759E5", hash_generated_method = "617D107647511EFAFE6F3F782A79ACC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void configureViewAnimator(int numVisibleViews, int activeOffset) {
        dsTaint.addTaint(numVisibleViews);
        dsTaint.addTaint(activeOffset);
        mPreviousViews.clear();
        mViewsMap.clear();
        removeAllViewsInLayout();
        mCurrentWindowStart = 0;
        mCurrentWindowEnd = -1;
        // ---------- Original Method ----------
        //if (activeOffset > numVisibleViews - 1) {
        //}
        //mMaxNumActiveViews = numVisibleViews;
        //mActiveOffset = activeOffset;
        //mPreviousViews.clear();
        //mViewsMap.clear();
        //removeAllViewsInLayout();
        //mCurrentWindowStart = 0;
        //mCurrentWindowEnd = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.206 -0400", hash_original_method = "CD78C78157016071B0AA2236145765B6", hash_generated_method = "81FC8385242935D81AEA045D6A77DB86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void transformViewForTransition(int fromIndex, int toIndex, View view, boolean animate) {
        dsTaint.addTaint(fromIndex);
        dsTaint.addTaint(animate);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(toIndex);
        {
            mInAnimation.setTarget(view);
            mInAnimation.start();
        } //End block
        {
            mOutAnimation.setTarget(view);
            mOutAnimation.start();
        } //End block
        // ---------- Original Method ----------
        //if (fromIndex == -1) {
            //mInAnimation.setTarget(view);
            //mInAnimation.start();
        //} else if (toIndex == -1) {
            //mOutAnimation.setTarget(view);
            //mOutAnimation.start();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.207 -0400", hash_original_method = "1B47254A99E5F108270897DC3078BE58", hash_generated_method = "0ED852B77E323D9137408FC335AEE128")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ObjectAnimator getDefaultInAnimation() {
        ObjectAnimator anim;
        anim = ObjectAnimator.ofFloat(null, "alpha", 0.0f, 1.0f);
        anim.setDuration(DEFAULT_ANIMATION_DURATION);
        return (ObjectAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ObjectAnimator anim = ObjectAnimator.ofFloat(null, "alpha", 0.0f, 1.0f);
        //anim.setDuration(DEFAULT_ANIMATION_DURATION);
        //return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.207 -0400", hash_original_method = "FB8DA060E53CA502AAAD2E0D3630FF89", hash_generated_method = "9F88303FA61A122EEBE21A7A0476D0A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ObjectAnimator getDefaultOutAnimation() {
        ObjectAnimator anim;
        anim = ObjectAnimator.ofFloat(null, "alpha", 1.0f, 0.0f);
        anim.setDuration(DEFAULT_ANIMATION_DURATION);
        return (ObjectAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ObjectAnimator anim = ObjectAnimator.ofFloat(null, "alpha", 1.0f, 0.0f);
        //anim.setDuration(DEFAULT_ANIMATION_DURATION);
        //return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.207 -0400", hash_original_method = "C45281778BDF4A98514907509DE78D33", hash_generated_method = "C27972E34807BFE80C3ECAC14B1DE5FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public void setDisplayedChild(int whichChild) {
        dsTaint.addTaint(whichChild);
        setDisplayedChild(whichChild, true);
        // ---------- Original Method ----------
        //setDisplayedChild(whichChild, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.207 -0400", hash_original_method = "91CB6634BDE3355704A6B2B246DAA7A9", hash_generated_method = "599A8C5CA23911E5B44676F132379A29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setDisplayedChild(int whichChild, boolean animate) {
        dsTaint.addTaint(animate);
        dsTaint.addTaint(whichChild);
        {
            {
                boolean var4423A414EEE509E3F96136E1F46B5612_523573174 = (whichChild >= getWindowSize());
                {
                    mWhichChild = mLoopViews ? 0 : getWindowSize() - 1;
                } //End block
                {
                    mWhichChild = mLoopViews ? getWindowSize() - 1 : 0;
                } //End block
            } //End collapsed parenthetic
            boolean hasFocus;
            hasFocus = getFocusedChild() != null;
            showOnly(mWhichChild, animate);
            {
                requestFocus(FOCUS_FORWARD);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //mWhichChild = whichChild;
            //if (whichChild >= getWindowSize()) {
                //mWhichChild = mLoopViews ? 0 : getWindowSize() - 1;
            //} else if (whichChild < 0) {
                //mWhichChild = mLoopViews ? getWindowSize() - 1 : 0;
            //}
            //boolean hasFocus = getFocusedChild() != null;
            //showOnly(mWhichChild, animate);
            //if (hasFocus) {
                //requestFocus(FOCUS_FORWARD);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.208 -0400", hash_original_method = "A7ED1EB61B0FBCD2BEBD15D1C1303F9C", hash_generated_method = "354F578CCF27AF87A7FFFB1E6C0716F2")
    @DSModeled(DSC.SAFE)
     void applyTransformForChildAtIndex(View child, int relativeIndex) {
        dsTaint.addTaint(relativeIndex);
        dsTaint.addTaint(child.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.208 -0400", hash_original_method = "EEFA4D3ABF985412351A1BD0CB5D6161", hash_generated_method = "CF8A163F8821A39D8D3F3C85178CD561")
    @DSModeled(DSC.SAFE)
    public int getDisplayedChild() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWhichChild;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.208 -0400", hash_original_method = "EFCC34AA69F6F34103211EDFAD5FB56A", hash_generated_method = "EB11A1D2F0D61EF8CF5A7F00E571FA28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showNext() {
        setDisplayedChild(mWhichChild + 1);
        // ---------- Original Method ----------
        //setDisplayedChild(mWhichChild + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.208 -0400", hash_original_method = "F846DD3340718784FB63764FD5BBF0F3", hash_generated_method = "A6ED72EB8F3F7302328A84241E26038A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showPrevious() {
        setDisplayedChild(mWhichChild - 1);
        // ---------- Original Method ----------
        //setDisplayedChild(mWhichChild - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.208 -0400", hash_original_method = "2C561D0D9BDC240B9A5D5DE9ED7CC2E1", hash_generated_method = "AF5DBAEA597CD2D2A6B51F645C76303F")
    @DSModeled(DSC.SAFE)
     int modulo(int pos, int size) {
        dsTaint.addTaint(size);
        dsTaint.addTaint(pos);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (size > 0) {
            //return (size + (pos % size)) % size;
        //} else {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.208 -0400", hash_original_method = "FBBD82E59359C019A1CEF3EB94A89AA2", hash_generated_method = "11D408F5DF7F694B5D00CFA6B8B32309")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     View getViewAtRelativeIndex(int relativeIndex) {
        dsTaint.addTaint(relativeIndex);
        {
            boolean varDAB78BEED386DC6D5D7AAFFD9BC0EFBA_374795788 = (relativeIndex >= 0 && relativeIndex <= getNumActiveViews() - 1 && mAdapter != null);
            {
                int i;
                i = modulo(mCurrentWindowStartUnbounded + relativeIndex, getWindowSize());
                {
                    boolean var70175653C6235B3C753B7C1934966D77_470473221 = (mViewsMap.get(i) != null);
                    {
                        View var8876094ECA3F1C58CA91782912B450E0_1247937051 = (mViewsMap.get(i).view);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (relativeIndex >= 0 && relativeIndex <= getNumActiveViews() - 1 && mAdapter != null) {
            //int i = modulo(mCurrentWindowStartUnbounded + relativeIndex, getWindowSize());
            //if (mViewsMap.get(i) != null) {
                //return mViewsMap.get(i).view;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.209 -0400", hash_original_method = "0421178BBB7DE66A738CAA04F8761832", hash_generated_method = "B7BE11DB3A9077733B867BBD45C2D7A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getNumActiveViews() {
        {
            int varE9842C7B0E064F871BFD47EBA4713105_1082888184 = (Math.min(getCount() + 1, mMaxNumActiveViews));
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return Math.min(getCount() + 1, mMaxNumActiveViews);
        //} else {
            //return mMaxNumActiveViews;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.209 -0400", hash_original_method = "6029719CD1CD7AB457F8E78F86AE86A1", hash_generated_method = "2525D351FA319B1E33077DE919E84ABA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getWindowSize() {
        {
            int adapterCount;
            adapterCount = getCount();
            {
                boolean varF2A5E737A41E4249CC2B5F17FAC5B9C5_79857816 = (adapterCount <= getNumActiveViews() && mLoopViews);
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //int adapterCount = getCount();
            //if (adapterCount <= getNumActiveViews() && mLoopViews) {
                //return adapterCount*mMaxNumActiveViews;
            //} else {
                //return adapterCount;
            //}
        //} else {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.212 -0400", hash_original_method = "1D56DD893F980F245C60382C98FF1278", hash_generated_method = "FAE5AD0B0894796512609AE420379DE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ViewAndMetaData getMetaDataForChild(View child) {
        dsTaint.addTaint(child.dsTaint);
        {
            Iterator<ViewAndMetaData> var3D0147521320DBAC5B3812CCE6A51C87_1398873197 = (mViewsMap.values()).iterator();
            var3D0147521320DBAC5B3812CCE6A51C87_1398873197.hasNext();
            ViewAndMetaData vm = var3D0147521320DBAC5B3812CCE6A51C87_1398873197.next();
        } //End collapsed parenthetic
        return (ViewAndMetaData)dsTaint.getTaint();
        // ---------- Original Method ----------
        //for (ViewAndMetaData vm: mViewsMap.values()) {
            //if (vm.view == child) {
                //return vm;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.213 -0400", hash_original_method = "F5EC02A85B8BD647E297FF00917E7C1D", hash_generated_method = "695D1B2F4516EA3223655A5BEF5128FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     LayoutParams createOrReuseLayoutParams(View v) {
        dsTaint.addTaint(v.dsTaint);
        ViewGroup.LayoutParams currentLp;
        currentLp = v.getLayoutParams();
        {
            LayoutParams lp;
            lp = (LayoutParams) currentLp;
        } //End block
        LayoutParams varC99FF184BD0CBB8F02632ECC174DF4BB_780683813 = (new ViewGroup.LayoutParams(0, 0));
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final ViewGroup.LayoutParams currentLp = v.getLayoutParams();
        //if (currentLp instanceof ViewGroup.LayoutParams) {
            //LayoutParams lp = (LayoutParams) currentLp;
            //return lp;
        //}
        //return new ViewGroup.LayoutParams(0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.213 -0400", hash_original_method = "DEC1654E1282F99AB82BE6A9F7EE0E03", hash_generated_method = "115E2CFDC7302D58B359935B5E5764BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void refreshChildren() {
        {
            int i;
            i = mCurrentWindowStart;
            {
                int index;
                index = modulo(i, getWindowSize());
                int adapterCount;
                adapterCount = getCount();
                View updatedChild;
                updatedChild = mAdapter.getView(modulo(i, adapterCount), null, this);
                {
                    boolean varFBF83238722638C3C490302F95CE401D_82427423 = (mViewsMap.containsKey(index));
                    {
                        FrameLayout fl;
                        fl = (FrameLayout) mViewsMap.get(index).view;
                        {
                            fl.removeAllViewsInLayout();
                            fl.addView(updatedChild);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mAdapter == null) return;
        //for (int i = mCurrentWindowStart; i <= mCurrentWindowEnd; i++) {
            //int index = modulo(i, getWindowSize());
            //int adapterCount = getCount();
            //final View updatedChild = mAdapter.getView(modulo(i, adapterCount), null, this);
            //if (mViewsMap.containsKey(index)) {
                //final FrameLayout fl = (FrameLayout) mViewsMap.get(index).view;
                //if (updatedChild != null) {
                    //fl.removeAllViewsInLayout();
                    //fl.addView(updatedChild);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.213 -0400", hash_original_method = "3A74ED5464ECC3EDCA3FF6D985E482E9", hash_generated_method = "64027976954FCECDC5AF419799FBDB21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     FrameLayout getFrameForChild() {
        FrameLayout varF4AAB9AA097015634864F107F1E1D5EB_2030817624 = (new FrameLayout(mContext));
        return (FrameLayout)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new FrameLayout(mContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.237 -0400", hash_original_method = "65797EBCBD60DE13415615382F58C13B", hash_generated_method = "8E9EB4F2026D6794D88B75F77F086631")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void showOnly(int childIndex, boolean animate) {
        dsTaint.addTaint(animate);
        dsTaint.addTaint(childIndex);
        int adapterCount;
        adapterCount = getCount();
        {
            int i;
            i = 0;
            boolean var5324A830B25BBA52B7E406685EFB4F98_734423113 = (i < mPreviousViews.size());
            {
                View viewToRemove;
                viewToRemove = mViewsMap.get(mPreviousViews.get(i)).view;
                mViewsMap.remove(mPreviousViews.get(i));
                viewToRemove.clearAnimation();
                {
                    ViewGroup vg;
                    vg = (ViewGroup) viewToRemove;
                    vg.removeAllViewsInLayout();
                } //End block
                applyTransformForChildAtIndex(viewToRemove, -1);
                removeViewInLayout(viewToRemove);
            } //End block
        } //End collapsed parenthetic
        mPreviousViews.clear();
        int newWindowStartUnbounded;
        newWindowStartUnbounded = childIndex - mActiveOffset;
        int newWindowEndUnbounded;
        newWindowEndUnbounded = newWindowStartUnbounded + getNumActiveViews() - 1;
        int newWindowStart;
        newWindowStart = Math.max(0, newWindowStartUnbounded);
        int newWindowEnd;
        newWindowEnd = Math.min(adapterCount - 1, newWindowEndUnbounded);
        {
            newWindowStart = newWindowStartUnbounded;
            newWindowEnd = newWindowEndUnbounded;
        } //End block
        int rangeStart;
        rangeStart = modulo(newWindowStart, getWindowSize());
        int rangeEnd;
        rangeEnd = modulo(newWindowEnd, getWindowSize());
        boolean wrap;
        wrap = false;
        {
            wrap = true;
        } //End block
        {
            Iterator<Integer> var610282C9D2149B9A2642D098939F7602_1096811782 = (mViewsMap.keySet()).iterator();
            var610282C9D2149B9A2642D098939F7602_1096811782.hasNext();
            Integer index = var610282C9D2149B9A2642D098939F7602_1096811782.next();
            {
                boolean remove;
                remove = false;
                {
                    remove = true;
                } //End block
                {
                    remove = true;
                } //End block
                {
                    View previousView;
                    previousView = mViewsMap.get(index).view;
                    int oldRelativeIndex;
                    oldRelativeIndex = mViewsMap.get(index).relativeIndex;
                    mPreviousViews.add(index);
                    transformViewForTransition(oldRelativeIndex, -1, previousView, animate);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            {
                int i;
                i = newWindowStart;
                {
                    int index;
                    index = modulo(i, getWindowSize());
                    int oldRelativeIndex;
                    {
                        boolean var41FB02AF47D0FFCEDE206EC611FE70C8_1366549728 = (mViewsMap.containsKey(index));
                        {
                            oldRelativeIndex = mViewsMap.get(index).relativeIndex;
                        } //End block
                        {
                            oldRelativeIndex = -1;
                        } //End block
                    } //End collapsed parenthetic
                    int newRelativeIndex;
                    newRelativeIndex = i - newWindowStartUnbounded;
                    boolean inOldRange;
                    inOldRange = mViewsMap.containsKey(index) && !mPreviousViews.contains(index);
                    {
                        View view;
                        view = mViewsMap.get(index).view;
                        mViewsMap.get(index).relativeIndex = newRelativeIndex;
                        applyTransformForChildAtIndex(view, newRelativeIndex);
                        transformViewForTransition(oldRelativeIndex, newRelativeIndex, view, animate);
                    } //End block
                    {
                        int adapterPosition;
                        adapterPosition = modulo(i, adapterCount);
                        View newView;
                        newView = mAdapter.getView(adapterPosition, null, this);
                        long itemId;
                        itemId = mAdapter.getItemId(adapterPosition);
                        FrameLayout fl;
                        fl = getFrameForChild();
                        {
                            fl.addView(newView);
                        } //End block
                        mViewsMap.put(index, new ViewAndMetaData(fl, newRelativeIndex,
                            adapterPosition, itemId));
                        addChild(fl);
                        applyTransformForChildAtIndex(fl, newRelativeIndex);
                        transformViewForTransition(-1, newRelativeIndex, fl, animate);
                    } //End block
                    mViewsMap.get(index).view.bringToFront();
                } //End block
            } //End collapsed parenthetic
            mCurrentWindowStart = newWindowStart;
            mCurrentWindowEnd = newWindowEnd;
            mCurrentWindowStartUnbounded = newWindowStartUnbounded;
        } //End block
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.238 -0400", hash_original_method = "CF7E9270D6A781D39501E4BBAEBB3A13", hash_generated_method = "7EE5D2F37944C9735B31AAE98BD213E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addChild(View child) {
        dsTaint.addTaint(child.dsTaint);
        addViewInLayout(child, -1, createOrReuseLayoutParams(child));
        {
            int measureSpec;
            measureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            child.measure(measureSpec, measureSpec);
            mReferenceChildWidth = child.getMeasuredWidth();
            mReferenceChildHeight = child.getMeasuredHeight();
        } //End block
        // ---------- Original Method ----------
        //addViewInLayout(child, -1, createOrReuseLayoutParams(child));
        //if (mReferenceChildWidth == -1 || mReferenceChildHeight == -1) {
            //int measureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            //child.measure(measureSpec, measureSpec);
            //mReferenceChildWidth = child.getMeasuredWidth();
            //mReferenceChildHeight = child.getMeasuredHeight();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.238 -0400", hash_original_method = "2ABC3404C13E4A800F47D0C635B72929", hash_generated_method = "0479DE953E76C063BA8E28E024580065")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void showTapFeedback(View v) {
        dsTaint.addTaint(v.dsTaint);
        v.setPressed(true);
        // ---------- Original Method ----------
        //v.setPressed(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.238 -0400", hash_original_method = "AB8C1F9AF8BDC4DF902FB7F7CD728C3A", hash_generated_method = "BDBF85431ADFD83C8D52928CB477222E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void hideTapFeedback(View v) {
        dsTaint.addTaint(v.dsTaint);
        v.setPressed(false);
        // ---------- Original Method ----------
        //v.setPressed(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.238 -0400", hash_original_method = "67399547287D8F71A7A5AE67A071254C", hash_generated_method = "5612B6AEDB9DEFC80041AC9EEE15DAD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void cancelHandleClick() {
        View v;
        v = getCurrentView();
        {
            hideTapFeedback(v);
        } //End block
        mTouchMode = TOUCH_MODE_NONE;
        // ---------- Original Method ----------
        //View v = getCurrentView();
        //if (v != null) {
            //hideTapFeedback(v);
        //}
        //mTouchMode = TOUCH_MODE_NONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.240 -0400", hash_original_method = "A2B685172F5BE99872ECD239B8E084E5", hash_generated_method = "752487F9F1E1BF9161E0C7F5EA015ADB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        int action;
        action = ev.getAction();
        boolean handled;
        handled = false;
        //Begin case MotionEvent.ACTION_DOWN 
        {
            View v;
            v = getCurrentView();
            {
                {
                    boolean varBC775EA6D0A73186451B4F7D426A7D5F_499018289 = (isTransformedTouchPointInView(ev.getX(), ev.getY(), v, null));
                    {
                        {
                            mPendingCheckForTap = new CheckForTap();
                        } //End block
                        mTouchMode = TOUCH_MODE_DOWN_IN_CURRENT_VIEW;
                        postDelayed(mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_UP 
        {
            {
                View v;
                v = getCurrentView();
                ViewAndMetaData viewData;
                viewData = getMetaDataForChild(v);
                {
                    {
                        boolean var39EF9DE1D8B67B073EBB22788CA51268_1360215412 = (isTransformedTouchPointInView(ev.getX(), ev.getY(), v, null));
                        {
                            Handler handler;
                            handler = getHandler();
                            {
                                handler.removeCallbacks(mPendingCheckForTap);
                            } //End block
                            showTapFeedback(v);
                            postDelayed(new Runnable() {                                
                                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.240 -0400", hash_original_method = "514935A2E7728F849473B37374E9557E", hash_generated_method = "0A1FDC5160C1C861D8EEE2C43142B3EE")
                                //DSFIXME:  CODE0002: Requires DSC value to be set
                                public void run() {
                                    hideTapFeedback(v);
                                    post(new Runnable() {                                        
                                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.240 -0400", hash_original_method = "42524E48826E836CBD16722378FBDC75", hash_generated_method = "C1A91307072BB396065B4A9D1506B9FB")
                                        //DSFIXME:  CODE0002: Requires DSC value to be set
                                        public void run() {
                                            {
                                                performItemClick(v, viewData.adapterPosition,
                                                        viewData.itemId);
                                            } //End block
                                            {
                                                performItemClick(v, 0, 0);
                                            } //End block
                                            // ---------- Original Method ----------
                                            //if (viewData != null) {
                                                //performItemClick(v, viewData.adapterPosition,
                                                        //viewData.itemId);
                                            //} else {
                                                //performItemClick(v, 0, 0);
                                            //}
                                        }
});
                                    // ---------- Original Method ----------
                                    //hideTapFeedback(v);
                                    //post(new Runnable() {
                                        //public void run() {
                                            //if (viewData != null) {
                                                //performItemClick(v, viewData.adapterPosition,
                                                        //viewData.itemId);
                                            //} else {
                                                //performItemClick(v, 0, 0);
                                            //}
                                        //}
                                    //});
                                }
}, ViewConfiguration.getPressedStateDuration());
                            handled = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            mTouchMode = TOUCH_MODE_NONE;
        } //End block
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_CANCEL 
        {
            View v;
            v = getCurrentView();
            {
                hideTapFeedback(v);
            } //End block
            mTouchMode = TOUCH_MODE_NONE;
        } //End block
        //End case MotionEvent.ACTION_CANCEL 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.241 -0400", hash_original_method = "CF7CC5DB55CCFC095F8C480C67A97670", hash_generated_method = "1353814AA744592502B211686F50BB8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void measureChildren() {
        int count;
        count = getChildCount();
        int childWidth;
        childWidth = getMeasuredWidth() - mPaddingLeft - mPaddingRight;
        int childHeight;
        childHeight = getMeasuredHeight() - mPaddingTop - mPaddingBottom;
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildAt(i);
                child.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final int count = getChildCount();
        //final int childWidth = getMeasuredWidth() - mPaddingLeft - mPaddingRight;
        //final int childHeight = getMeasuredHeight() - mPaddingTop - mPaddingBottom;
        //for (int i = 0; i < count; i++) {
            //final View child = getChildAt(i);
            //child.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY),
                    //MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.242 -0400", hash_original_method = "B8DC8FCB5714B92F7D9B397FCC5E6B1D", hash_generated_method = "EBED5E0EF4D0B918F1F80B3DA16BC8F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        int widthSpecSize;
        widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize;
        heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthSpecMode;
        widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode;
        heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        boolean haveChildRefSize;
        haveChildRefSize = (mReferenceChildWidth != -1 && mReferenceChildHeight != -1);
        {
            heightSpecSize = haveChildRefSize ? mReferenceChildHeight + mPaddingTop +
                    mPaddingBottom : 0;
        } //End block
        {
            {
                int height;
                height = mReferenceChildHeight + mPaddingTop + mPaddingBottom;
                {
                    heightSpecSize |= MEASURED_STATE_TOO_SMALL;
                } //End block
                {
                    heightSpecSize = height;
                } //End block
            } //End block
        } //End block
        {
            widthSpecSize = haveChildRefSize ? mReferenceChildWidth + mPaddingLeft +
                    mPaddingRight : 0;
        } //End block
        {
            {
                int width;
                width = mReferenceChildWidth + mPaddingLeft + mPaddingRight;
                {
                    widthSpecSize |= MEASURED_STATE_TOO_SMALL;
                } //End block
                {
                    widthSpecSize = width;
                } //End block
            } //End block
        } //End block
        setMeasuredDimension(widthSpecSize, heightSpecSize);
        measureChildren();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.243 -0400", hash_original_method = "F3EF4D3CC56F2B38758DB6D9F3299660", hash_generated_method = "D4883ED89571DC921C726889B211CB7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void checkForAndHandleDataChanged() {
        boolean dataChanged;
        dataChanged = mDataChanged;
        {
            post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.243 -0400", hash_original_method = "15BF43057866669BD34B56F96081697B", hash_generated_method = "8832F0CAA4F8A753CF55FD45D5385EC3")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void run() {
                    handleDataChanged();
                    {
                        boolean var91476E53455DDBED1C2497762140CD5A_47756122 = (mWhichChild >= getWindowSize());
                        {
                            mWhichChild = 0;
                            showOnly(mWhichChild, false);
                        } //End block
                        {
                            boolean var9A54785035833875439C9F0D8D389EC7_722251736 = (mOldItemCount != getCount());
                            {
                                showOnly(mWhichChild, false);
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                    refreshChildren();
                    requestLayout();
                    // ---------- Original Method ----------
                    //handleDataChanged();
                    //if (mWhichChild >= getWindowSize()) {
                        //mWhichChild = 0;
                        //showOnly(mWhichChild, false);
                    //} else if (mOldItemCount != getCount()) {
                        //showOnly(mWhichChild, false);
                    //}
                    //refreshChildren();
                    //requestLayout();
                }
});
        } //End block
        mDataChanged = false;
        // ---------- Original Method ----------
        //boolean dataChanged = mDataChanged;
        //if (dataChanged) {
            //post(new Runnable() {
                //public void run() {
                    //handleDataChanged();
                    //if (mWhichChild >= getWindowSize()) {
                        //mWhichChild = 0;
                        //showOnly(mWhichChild, false);
                    //} else if (mOldItemCount != getCount()) {
                        //showOnly(mWhichChild, false);
                    //}
                    //refreshChildren();
                    //requestLayout();
                //}
            //});
        //}
        //mDataChanged = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.243 -0400", hash_original_method = "BFF47184DAE09EA9D82185EB27DBF22D", hash_generated_method = "30E0E51FEE7B2BCDA7F78EE8D4E35CA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        dsTaint.addTaint(changed);
        checkForAndHandleDataChanged();
        int childCount;
        childCount = getChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildAt(i);
                int childRight;
                childRight = mPaddingLeft + child.getMeasuredWidth();
                int childBottom;
                childBottom = mPaddingTop + child.getMeasuredHeight();
                child.layout(mPaddingLeft, mPaddingTop, childRight, childBottom);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //checkForAndHandleDataChanged();
        //final int childCount = getChildCount();
        //for (int i = 0; i < childCount; i++) {
            //final View child = getChildAt(i);
            //int childRight = mPaddingLeft + child.getMeasuredWidth();
            //int childBottom = mPaddingTop + child.getMeasuredHeight();
            //child.layout(mPaddingLeft, mPaddingTop, childRight, childBottom);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.244 -0400", hash_original_method = "C09C373B1A1103A4B30F4932FEFEB18D", hash_generated_method = "5CD18D785029CA6CE41B21BC391442CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable superState;
        superState = super.onSaveInstanceState();
        Parcelable var862AA43709B2468B63E792C52E73FA75_1617180331 = (new SavedState(superState, mWhichChild));
        return (Parcelable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Parcelable superState = super.onSaveInstanceState();
        //return new SavedState(superState, mWhichChild);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.244 -0400", hash_original_method = "A2807F1883DAD1F14A6CC088A989D676", hash_generated_method = "07BE980F5D4E1740C168E439D06AA0EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state.dsTaint);
        SavedState ss;
        ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        mWhichChild = ss.whichChild;
        {
            mRestoreWhichChild = mWhichChild;
        } //End block
        {
            setDisplayedChild(mWhichChild, false);
        } //End block
        // ---------- Original Method ----------
        //SavedState ss = (SavedState) state;
        //super.onRestoreInstanceState(ss.getSuperState());
        //mWhichChild = ss.whichChild;
        //if (mRemoteViewsAdapter != null && mAdapter == null) {
            //mRestoreWhichChild = mWhichChild;
        //} else {
            //setDisplayedChild(mWhichChild, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.244 -0400", hash_original_method = "906CF989810621761D25CEDBF35A3122", hash_generated_method = "A91F0DAC6DA263B0F80BDBA1177E012A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getCurrentView() {
        View var8036C1F6C329208BBCF909BD7AD4C364_1118646545 = (getViewAtRelativeIndex(mActiveOffset));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getViewAtRelativeIndex(mActiveOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.244 -0400", hash_original_method = "23AFF2D08DB63552361956C44B4439AE", hash_generated_method = "E83F0276E1DC6F1B53490E72B7481023")
    @DSModeled(DSC.SAFE)
    public ObjectAnimator getInAnimation() {
        return (ObjectAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInAnimation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.245 -0400", hash_original_method = "4E43CB38736F57C9005B93984FDB3BE2", hash_generated_method = "B6738307DFEDEBCB6698A8284DAD409D")
    @DSModeled(DSC.SAFE)
    public void setInAnimation(ObjectAnimator inAnimation) {
        dsTaint.addTaint(inAnimation.dsTaint);
        // ---------- Original Method ----------
        //mInAnimation = inAnimation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.245 -0400", hash_original_method = "6B0CDF48C8054A61C9B211FDE065CA93", hash_generated_method = "3F3613A3D08E31CDE69A7678F0C14A78")
    @DSModeled(DSC.SAFE)
    public ObjectAnimator getOutAnimation() {
        return (ObjectAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mOutAnimation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.245 -0400", hash_original_method = "1BCB8E8A3DAEDE15E6756EE2F683DC83", hash_generated_method = "C197A2B5ACD8CE3018D8FE3B4B8144BF")
    @DSModeled(DSC.SAFE)
    public void setOutAnimation(ObjectAnimator outAnimation) {
        dsTaint.addTaint(outAnimation.dsTaint);
        // ---------- Original Method ----------
        //mOutAnimation = outAnimation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.246 -0400", hash_original_method = "8F8897D1BAA8E5AE19C8237937D2CA37", hash_generated_method = "8CE2094146ED7815B2FFEF31094E832F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInAnimation(Context context, int resourceID) {
        dsTaint.addTaint(resourceID);
        dsTaint.addTaint(context.dsTaint);
        setInAnimation((ObjectAnimator) AnimatorInflater.loadAnimator(context, resourceID));
        // ---------- Original Method ----------
        //setInAnimation((ObjectAnimator) AnimatorInflater.loadAnimator(context, resourceID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.246 -0400", hash_original_method = "DAE8806685F393E416F20FAE75D3F12A", hash_generated_method = "437318590A27B016AF40B7510CF99FD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOutAnimation(Context context, int resourceID) {
        dsTaint.addTaint(resourceID);
        dsTaint.addTaint(context.dsTaint);
        setOutAnimation((ObjectAnimator) AnimatorInflater.loadAnimator(context, resourceID));
        // ---------- Original Method ----------
        //setOutAnimation((ObjectAnimator) AnimatorInflater.loadAnimator(context, resourceID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.246 -0400", hash_original_method = "8FC95409534ABC48E92905DC8C518CE2", hash_generated_method = "92EB2DFBE23FC1DA043FADC8C1F9E49B")
    @DSModeled(DSC.SAFE)
    public void setAnimateFirstView(boolean animate) {
        dsTaint.addTaint(animate);
        // ---------- Original Method ----------
        //mAnimateFirstTime = animate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.247 -0400", hash_original_method = "0B91CAAE76789C8A4B2B18C9D0AAF852", hash_generated_method = "E4E1143DCE75386086F5B9BF472107E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getBaseline() {
        {
            boolean var58F8C7D88FB1D1DD9A5513FB3A54B5BC_1440019025 = ((getCurrentView() != null));
            Object varA7D65C03FD7AD29B41A2824896EF9900_651035427 = (getCurrentView().getBaseline());
            Object varEC5F70FA49520212A319ACA653FC0209_2129728081 = (super.getBaseline());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (getCurrentView() != null) ? getCurrentView().getBaseline() : super.getBaseline();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.247 -0400", hash_original_method = "4778E83EF7DB01E18145E85F688E24B4", hash_generated_method = "C9354E705CB92516A8D7B74DE37A27F4")
    @DSModeled(DSC.SAFE)
    @Override
    public Adapter getAdapter() {
        return (Adapter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.248 -0400", hash_original_method = "8F781C0E336C7A94E2963F9C2B9D5E7F", hash_generated_method = "88AC4FDBD7ACAAFC56DA45AC0677863C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setAdapter(Adapter adapter) {
        dsTaint.addTaint(adapter.dsTaint);
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        } //End block
        checkFocus();
        {
            mDataSetObserver = new AdapterDataSetObserver();
            mAdapter.registerDataSetObserver(mDataSetObserver);
            mItemCount = mAdapter.getCount();
        } //End block
        setFocusable(true);
        mWhichChild = 0;
        showOnly(mWhichChild, false);
        // ---------- Original Method ----------
        //if (mAdapter != null && mDataSetObserver != null) {
            //mAdapter.unregisterDataSetObserver(mDataSetObserver);
        //}
        //mAdapter = adapter;
        //checkFocus();
        //if (mAdapter != null) {
            //mDataSetObserver = new AdapterDataSetObserver();
            //mAdapter.registerDataSetObserver(mDataSetObserver);
            //mItemCount = mAdapter.getCount();
        //}
        //setFocusable(true);
        //mWhichChild = 0;
        //showOnly(mWhichChild, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.248 -0400", hash_original_method = "27E899D618A9F50FEEEF08AE1A9356B2", hash_generated_method = "4C986994378D67C5F9B469513EA9EC7F")
    @DSModeled(DSC.SPEC)
    @android.view.RemotableViewMethod
    public void setRemoteViewsAdapter(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        {
            Intent.FilterComparison fcNew;
            fcNew = new Intent.FilterComparison(intent);
            Intent.FilterComparison fcOld;
            fcOld = new Intent.FilterComparison(
                    mRemoteViewsAdapter.getRemoteViewsServiceIntent());
            {
                boolean var45C20E8BCA952BA88AD2862513B06923_1001536237 = (fcNew.equals(fcOld));
            } //End collapsed parenthetic
        } //End block
        mDeferNotifyDataSetChanged = false;
        mRemoteViewsAdapter = new RemoteViewsAdapter(getContext(), intent, this);
        // ---------- Original Method ----------
        //if (mRemoteViewsAdapter != null) {
            //Intent.FilterComparison fcNew = new Intent.FilterComparison(intent);
            //Intent.FilterComparison fcOld = new Intent.FilterComparison(
                    //mRemoteViewsAdapter.getRemoteViewsServiceIntent());
            //if (fcNew.equals(fcOld)) {
                //return;
            //}
        //}
        //mDeferNotifyDataSetChanged = false;
        //mRemoteViewsAdapter = new RemoteViewsAdapter(getContext(), intent, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.249 -0400", hash_original_method = "DA18836BD93C624B14E0649B9FD256B6", hash_generated_method = "72C3C0D9ACA12A6EC9D968C9903659A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setSelection(int position) {
        dsTaint.addTaint(position);
        setDisplayedChild(position);
        // ---------- Original Method ----------
        //setDisplayedChild(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.249 -0400", hash_original_method = "B55B55B562FC01D014E8D16B89577F15", hash_generated_method = "AC8B530AEAD7652CA655D6F3F731F044")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public View getSelectedView() {
        View var8036C1F6C329208BBCF909BD7AD4C364_640194095 = (getViewAtRelativeIndex(mActiveOffset));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getViewAtRelativeIndex(mActiveOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.249 -0400", hash_original_method = "0410210FC7BC336B3896BEA7510AAE3D", hash_generated_method = "9D38AC80197E9738EE138974F1EA14DE")
    @DSModeled(DSC.SAFE)
    public void deferNotifyDataSetChanged() {
        mDeferNotifyDataSetChanged = true;
        // ---------- Original Method ----------
        //mDeferNotifyDataSetChanged = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.249 -0400", hash_original_method = "9E5375D03017C5CE595A523DBE298043", hash_generated_method = "F04952143FC1A8734FBBC3D2140C57D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onRemoteAdapterConnected() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            setAdapter(mRemoteViewsAdapter);
            {
                mRemoteViewsAdapter.notifyDataSetChanged();
                mDeferNotifyDataSetChanged = false;
            } //End block
            {
                setDisplayedChild(mRestoreWhichChild, false);
                mRestoreWhichChild = -1;
            } //End block
        } //End block
        {
            mRemoteViewsAdapter.superNotifyDataSetChanged();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mRemoteViewsAdapter != mAdapter) {
            //setAdapter(mRemoteViewsAdapter);
            //if (mDeferNotifyDataSetChanged) {
                //mRemoteViewsAdapter.notifyDataSetChanged();
                //mDeferNotifyDataSetChanged = false;
            //}
            //if (mRestoreWhichChild > -1) {
                //setDisplayedChild(mRestoreWhichChild, false);
                //mRestoreWhichChild = -1;
            //}
            //return false;
        //} else if (mRemoteViewsAdapter != null) {
            //mRemoteViewsAdapter.superNotifyDataSetChanged();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.250 -0400", hash_original_method = "062C10606C6763A75AEC213E65863835", hash_generated_method = "64085B2EAF9EA39B9EA364A5E4CA7F63")
    @DSModeled(DSC.SAFE)
    public void onRemoteAdapterDisconnected() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.250 -0400", hash_original_method = "47C53466AFD69B01265302F86E539CFE", hash_generated_method = "87EFC5B96525071A3735B428531FF9C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void advance() {
        showNext();
        // ---------- Original Method ----------
        //showNext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.250 -0400", hash_original_method = "1A32686EBDFA985B54B6CF53155BB413", hash_generated_method = "AD4C3644092881C2E0FBB4399DF4389D")
    @DSModeled(DSC.SAFE)
    public void fyiWillBeAdvancedByHostKThx() {
        // ---------- Original Method ----------
    }

    
    class ViewAndMetaData {
        View view;
        int relativeIndex;
        int adapterPosition;
        long itemId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.250 -0400", hash_original_method = "35BDC394C726F4932D0D464E91A92D34", hash_generated_method = "7EDD52E5CC0B9DC368BEA44174F0BD2A")
        @DSModeled(DSC.SAFE)
         ViewAndMetaData(View view, int relativeIndex, int adapterPosition, long itemId) {
            dsTaint.addTaint(relativeIndex);
            dsTaint.addTaint(adapterPosition);
            dsTaint.addTaint(view.dsTaint);
            dsTaint.addTaint(itemId);
            // ---------- Original Method ----------
            //this.view = view;
            //this.relativeIndex = relativeIndex;
            //this.adapterPosition = adapterPosition;
            //this.itemId = itemId;
        }

        
    }


    
    final class CheckForTap implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.250 -0400", hash_original_method = "DDE2B97FC218E2B375A63A291079A391", hash_generated_method = "DDE2B97FC218E2B375A63A291079A391")
                public CheckForTap ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.251 -0400", hash_original_method = "0DE0DC1F19EC8E43C86C5443C435E50A", hash_generated_method = "DBF1B507F9ABEEA968E5477FE85A6262")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            {
                View v;
                v = getCurrentView();
                showTapFeedback(v);
            } //End block
            // ---------- Original Method ----------
            //if (mTouchMode == TOUCH_MODE_DOWN_IN_CURRENT_VIEW) {
                //View v = getCurrentView();
                //showTapFeedback(v);
            //}
        }

        
    }


    
    static class SavedState extends BaseSavedState {
        int whichChild;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.251 -0400", hash_original_method = "B7BF12453E93628DE35CAA34B998429F", hash_generated_method = "6418A0B62C5335B1586B05C892D592A3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SavedState(Parcelable superState, int whichChild) {
            super(superState);
            dsTaint.addTaint(superState.dsTaint);
            dsTaint.addTaint(whichChild);
            // ---------- Original Method ----------
            //this.whichChild = whichChild;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.251 -0400", hash_original_method = "392EDFCBBF619540219C8F70BEB96B16", hash_generated_method = "8404881BD197ADEF23310D2CF4110BFF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private SavedState(Parcel in) {
            super(in);
            dsTaint.addTaint(in.dsTaint);
            this.whichChild = in.readInt();
            // ---------- Original Method ----------
            //this.whichChild = in.readInt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.252 -0400", hash_original_method = "DA40422C10B10105F9CB19E8091B3EEC", hash_generated_method = "64647A2F8FFC2070B996380DBEBFD896")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void writeToParcel(Parcel out, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(out.dsTaint);
            super.writeToParcel(out, flags);
            out.writeInt(this.whichChild);
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeInt(this.whichChild);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.253 -0400", hash_original_method = "808D88187ABBC8D595A46EE25C5AC5ED", hash_generated_method = "921B9F0546FAE658DD66D2C11514C3A2")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "AdapterViewAnimator.SavedState{ whichChild = " + this.whichChild + " }";
        }

        
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.253 -0400", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "492C2918895CD0E0615E5713266357CE")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SavedState createFromParcel(Parcel in) {
                dsTaint.addTaint(in.dsTaint);
                SavedState var41ED8F3548F5060881BBE51AB9112A3F_76171297 = (new SavedState(in));
                return (SavedState)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState(in);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.254 -0400", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "AF017AA17C957E763EF7BC2F2D179293")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SavedState[] newArray(int size) {
                dsTaint.addTaint(size);
                SavedState[] varB5C72E5BBB181D4CA93D7BAA0B8B5E3D_784170094 = (new SavedState[size]);
                return (SavedState[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState[size];
            }

            
}; //Transformed anonymous class
    }


    
    private static final String TAG = "RemoteViewAnimator";
    static final int TOUCH_MODE_NONE = 0;
    static final int TOUCH_MODE_DOWN_IN_CURRENT_VIEW = 1;
    static final int TOUCH_MODE_HANDLED = 2;
    private static final int DEFAULT_ANIMATION_DURATION = 200;
}

