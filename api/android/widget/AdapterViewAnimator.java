package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.367 -0400", hash_original_field = "EA21F533229388AA4B2EFE079FA29356", hash_generated_field = "A4199CA8B30F98AAF67F6FDF10E09266")

    int mWhichChild = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.367 -0400", hash_original_field = "C0E47D0A038ADFE91661E4E5371F0BD6", hash_generated_field = "A493EB2C57153A47A21988AED08A61F9")

    private int mRestoreWhichChild = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.367 -0400", hash_original_field = "FDE1980A01124F9ECAD446EEE35F7267", hash_generated_field = "11022FC94DBD000AF0F23EE6D44DA07A")

    boolean mAnimateFirstTime = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.367 -0400", hash_original_field = "C0C9D87647F1DD58CD2938611477200B", hash_generated_field = "1CB8D73EF29501CAF0F770C194E4A275")

    int mActiveOffset = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.367 -0400", hash_original_field = "E46FAD00B5C2DBF29FABE10F0F93BDAB", hash_generated_field = "F89A42DD2C5934C96B97C28D423189DC")

    int mMaxNumActiveViews = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.367 -0400", hash_original_field = "24A5E7040AA6FFE7AE892C9904044EF6", hash_generated_field = "0CC41FBC4366667A564C06DC4F0D9357")

    HashMap<Integer, ViewAndMetaData> mViewsMap = new HashMap<Integer, ViewAndMetaData>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.367 -0400", hash_original_field = "AD55C52A81E04B39FEAF449A80DEC714", hash_generated_field = "DCC538958BCCC098025B00C03E72E198")

    ArrayList<Integer> mPreviousViews;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.367 -0400", hash_original_field = "DC605E9287B2D84952185DAA194FE524", hash_generated_field = "3A6641FE6CF608A1624B00F1DAB420F6")

    int mCurrentWindowStart = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.367 -0400", hash_original_field = "4859BE4C935A36901AB8D860398C0451", hash_generated_field = "F84B4803BE53A338433E57C705009CC2")

    int mCurrentWindowEnd = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.367 -0400", hash_original_field = "8B9C4207ECA1072C739371D6A4CB8F55", hash_generated_field = "875B8F5BD30A8973DBF780138CCA9A4B")

    int mCurrentWindowStartUnbounded = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.367 -0400", hash_original_field = "1AB0B744C03B78F09E9DEC3C88684ED1", hash_generated_field = "C2A92A98CA414A0C47C4CCACBB8EA2C2")

    AdapterDataSetObserver mDataSetObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.367 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "2CCFA3B9041B42EEC769AA09DF8CA535")

    Adapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.367 -0400", hash_original_field = "46E2FBD69946D5D63C919774CDC2709A", hash_generated_field = "6C2145BBB74854B314D98BC5E793C836")

    RemoteViewsAdapter mRemoteViewsAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.368 -0400", hash_original_field = "8DBD1724A62493247BCB06E14E790DDB", hash_generated_field = "D8481D38E4E063E4EC28948859294EB6")

    boolean mDeferNotifyDataSetChanged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.368 -0400", hash_original_field = "819CF91F91F67E3ABFDBBF304392B421", hash_generated_field = "319BF9E49F2FBE9453A9508A3A60521D")

    boolean mFirstTime = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.368 -0400", hash_original_field = "E9CF07B4E9DF18186772188A653F6ACD", hash_generated_field = "EE119C98E20A644961B6553C661011C0")

    boolean mLoopViews = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.368 -0400", hash_original_field = "EDE726180C85C86910D06D268C52F692", hash_generated_field = "A104F61DF317955825146E40FC0C3A53")

    int mReferenceChildWidth = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.368 -0400", hash_original_field = "BDC749679D65E3F204B9D532393B6541", hash_generated_field = "FD007F8803D65B2ABC0CC17D246ED815")

    int mReferenceChildHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.368 -0400", hash_original_field = "69EE9328057C3731E3E5851972F2D1BA", hash_generated_field = "C00C0EA8F9B59A998740D4241DDCA251")

    ObjectAnimator mInAnimation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.368 -0400", hash_original_field = "00AD3937DA6C2650F811216846F50E5C", hash_generated_field = "4FC9F8644D505DE7FB36472E6D47BDF1")

    ObjectAnimator mOutAnimation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.368 -0400", hash_original_field = "011DFC8310C57F40F856FB0A216752FC", hash_generated_field = "9849E22BF41E24F9EE56259FB24FEA91")

    private int mTouchMode = TOUCH_MODE_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.368 -0400", hash_original_field = "4349FC27F2087C20272E81AADEE9392A", hash_generated_field = "C7859F448E179D513123D1E080D96FF5")

    private Runnable mPendingCheckForTap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.368 -0400", hash_original_method = "5A28C6E6B4D6383379224D19746F7CDC", hash_generated_method = "A6ED3146008CDFA5DD8DB6A1373C5F32")
    public  AdapterViewAnimator(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.369 -0400", hash_original_method = "ADD24FA1FA279C1B8387D7B0109F9EEC", hash_generated_method = "855E8FF26A95189944E347A7F691EA6D")
    public  AdapterViewAnimator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.370 -0400", hash_original_method = "C5643612A08EABEF3EDB2D9CFA87FEC7", hash_generated_method = "6BBB95A3075B7B83533D072A10AA8652")
    public  AdapterViewAnimator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        addTaint(defStyleAttr);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.AdapterViewAnimator, defStyleAttr, 0);
        int resource = a.getResourceId(
                com.android.internal.R.styleable.AdapterViewAnimator_inAnimation, 0);
    if(resource > 0)        
        {
            setInAnimation(context, resource);
        } //End block
        else
        {
            setInAnimation(getDefaultInAnimation());
        } //End block
        resource = a.getResourceId(com.android.internal.R.styleable.AdapterViewAnimator_outAnimation, 0);
    if(resource > 0)        
        {
            setOutAnimation(context, resource);
        } //End block
        else
        {
            setOutAnimation(getDefaultOutAnimation());
        } //End block
        boolean flag = a.getBoolean(
                com.android.internal.R.styleable.AdapterViewAnimator_animateFirstView, true);
        setAnimateFirstView(flag);
        mLoopViews = a.getBoolean(
                com.android.internal.R.styleable.AdapterViewAnimator_loopViews, false);
        a.recycle();
        initViewAnimator();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.371 -0400", hash_original_method = "4508B464C0C2084478BE2A642B32436E", hash_generated_method = "0AEEC796AE042A1371E848170F3AEF4C")
    private void initViewAnimator() {
        mPreviousViews = new ArrayList<Integer>();
        // ---------- Original Method ----------
        //mPreviousViews = new ArrayList<Integer>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.371 -0400", hash_original_method = "91B9FA80E0031C77B528C608AC4759E5", hash_generated_method = "4CD731FF95B59B137BB96ACF5138B101")
     void configureViewAnimator(int numVisibleViews, int activeOffset) {
    if(activeOffset > numVisibleViews - 1)        
        {
        } //End block
        mMaxNumActiveViews = numVisibleViews;
        mActiveOffset = activeOffset;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.372 -0400", hash_original_method = "CD78C78157016071B0AA2236145765B6", hash_generated_method = "56B18F99ECE15B19FD7DC3F155EABF05")
     void transformViewForTransition(int fromIndex, int toIndex, View view, boolean animate) {
        addTaint(animate);
        addTaint(view.getTaint());
        addTaint(toIndex);
        addTaint(fromIndex);
    if(fromIndex == -1)        
        {
            mInAnimation.setTarget(view);
            mInAnimation.start();
        } //End block
        else
    if(toIndex == -1)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.372 -0400", hash_original_method = "1B47254A99E5F108270897DC3078BE58", hash_generated_method = "77A5913E0432DA50B73C2EEFB4DE1012")
     ObjectAnimator getDefaultInAnimation() {
        ObjectAnimator anim = ObjectAnimator.ofFloat(null, "alpha", 0.0f, 1.0f);
        anim.setDuration(DEFAULT_ANIMATION_DURATION);
ObjectAnimator var6E2178F33F884BED37C5DEBCD18F9A96_1214444376 =         anim;
        var6E2178F33F884BED37C5DEBCD18F9A96_1214444376.addTaint(taint);
        return var6E2178F33F884BED37C5DEBCD18F9A96_1214444376;
        // ---------- Original Method ----------
        //ObjectAnimator anim = ObjectAnimator.ofFloat(null, "alpha", 0.0f, 1.0f);
        //anim.setDuration(DEFAULT_ANIMATION_DURATION);
        //return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.372 -0400", hash_original_method = "FB8DA060E53CA502AAAD2E0D3630FF89", hash_generated_method = "F5BF3E42261FE4006F73F9CF425EF292")
     ObjectAnimator getDefaultOutAnimation() {
        ObjectAnimator anim = ObjectAnimator.ofFloat(null, "alpha", 1.0f, 0.0f);
        anim.setDuration(DEFAULT_ANIMATION_DURATION);
ObjectAnimator var6E2178F33F884BED37C5DEBCD18F9A96_45780091 =         anim;
        var6E2178F33F884BED37C5DEBCD18F9A96_45780091.addTaint(taint);
        return var6E2178F33F884BED37C5DEBCD18F9A96_45780091;
        // ---------- Original Method ----------
        //ObjectAnimator anim = ObjectAnimator.ofFloat(null, "alpha", 1.0f, 0.0f);
        //anim.setDuration(DEFAULT_ANIMATION_DURATION);
        //return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.373 -0400", hash_original_method = "C45281778BDF4A98514907509DE78D33", hash_generated_method = "EF6310B3A0B82D81CBF5DEE656C2A947")
    @android.view.RemotableViewMethod
    public void setDisplayedChild(int whichChild) {
        addTaint(whichChild);
        setDisplayedChild(whichChild, true);
        // ---------- Original Method ----------
        //setDisplayedChild(whichChild, true);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.373 -0400", hash_original_method = "91CB6634BDE3355704A6B2B246DAA7A9", hash_generated_method = "2611AE739E240D7A76D87C75CA154E0C")
    private void setDisplayedChild(int whichChild, boolean animate) {
        addTaint(animate);
    if(mAdapter != null)        
        {
            mWhichChild = whichChild;
    if(whichChild >= getWindowSize())            
            {
                mWhichChild = mLoopViews ? 0 : getWindowSize() - 1;
            } //End block
            else
    if(whichChild < 0)            
            {
                mWhichChild = mLoopViews ? getWindowSize() - 1 : 0;
            } //End block
            boolean hasFocus = getFocusedChild() != null;
            showOnly(mWhichChild, animate);
    if(hasFocus)            
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.374 -0400", hash_original_method = "A7ED1EB61B0FBCD2BEBD15D1C1303F9C", hash_generated_method = "5679EA3D8F18A0FEBFDD599E810F6440")
     void applyTransformForChildAtIndex(View child, int relativeIndex) {
        addTaint(relativeIndex);
        addTaint(child.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.374 -0400", hash_original_method = "EEFA4D3ABF985412351A1BD0CB5D6161", hash_generated_method = "D0EB6A40CD0035C78337D7E801F2E773")
    public int getDisplayedChild() {
        int varDB5BE583416C3068C849D51E047EB136_2022995309 = (mWhichChild);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_386433644 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_386433644;
        // ---------- Original Method ----------
        //return mWhichChild;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.374 -0400", hash_original_method = "EFCC34AA69F6F34103211EDFAD5FB56A", hash_generated_method = "EB11A1D2F0D61EF8CF5A7F00E571FA28")
    public void showNext() {
        setDisplayedChild(mWhichChild + 1);
        // ---------- Original Method ----------
        //setDisplayedChild(mWhichChild + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.374 -0400", hash_original_method = "F846DD3340718784FB63764FD5BBF0F3", hash_generated_method = "A6ED72EB8F3F7302328A84241E26038A")
    public void showPrevious() {
        setDisplayedChild(mWhichChild - 1);
        // ---------- Original Method ----------
        //setDisplayedChild(mWhichChild - 1);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.375 -0400", hash_original_method = "2C561D0D9BDC240B9A5D5DE9ED7CC2E1", hash_generated_method = "C2280049749561BD96B803DFE6A9DE9D")
     int modulo(int pos, int size) {
        addTaint(size);
        addTaint(pos);
    if(size > 0)        
        {
            int varFA9E60DE812FCD35AF0DA6D2483B918A_1418455088 = ((size + (pos % size)) % size);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1998196192 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1998196192;
        } //End block
        else
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_340584856 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_56366342 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_56366342;
        } //End block
        // ---------- Original Method ----------
        //if (size > 0) {
            //return (size + (pos % size)) % size;
        //} else {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.375 -0400", hash_original_method = "FBBD82E59359C019A1CEF3EB94A89AA2", hash_generated_method = "508C99DCE4ED83595CCE14F8513045EE")
     View getViewAtRelativeIndex(int relativeIndex) {
        addTaint(relativeIndex);
    if(relativeIndex >= 0 && relativeIndex <= getNumActiveViews() - 1 && mAdapter != null)        
        {
            int i = modulo(mCurrentWindowStartUnbounded + relativeIndex, getWindowSize());
    if(mViewsMap.get(i) != null)            
            {
View varAFB4B99C1B7872DD5C0F10E36777FB0D_1856483178 =                 mViewsMap.get(i).view;
                varAFB4B99C1B7872DD5C0F10E36777FB0D_1856483178.addTaint(taint);
                return varAFB4B99C1B7872DD5C0F10E36777FB0D_1856483178;
            } //End block
        } //End block
View var540C13E9E156B687226421B24F2DF178_689782515 =         null;
        var540C13E9E156B687226421B24F2DF178_689782515.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_689782515;
        // ---------- Original Method ----------
        //if (relativeIndex >= 0 && relativeIndex <= getNumActiveViews() - 1 && mAdapter != null) {
            //int i = modulo(mCurrentWindowStartUnbounded + relativeIndex, getWindowSize());
            //if (mViewsMap.get(i) != null) {
                //return mViewsMap.get(i).view;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.375 -0400", hash_original_method = "0421178BBB7DE66A738CAA04F8761832", hash_generated_method = "3AA0998971B55E4B6FDE6627991E2243")
     int getNumActiveViews() {
    if(mAdapter != null)        
        {
            int var3CD3A63E334A44D006D0BEB28A3B1FB6_1070148268 = (Math.min(getCount() + 1, mMaxNumActiveViews));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1271585010 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1271585010;
        } //End block
        else
        {
            int varB759EF247DECE7AB63302981F49C703D_249552833 = (mMaxNumActiveViews);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1780746748 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1780746748;
        } //End block
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return Math.min(getCount() + 1, mMaxNumActiveViews);
        //} else {
            //return mMaxNumActiveViews;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.376 -0400", hash_original_method = "6029719CD1CD7AB457F8E78F86AE86A1", hash_generated_method = "B8EC9990A95917A6AE9CECE48C6B316C")
     int getWindowSize() {
    if(mAdapter != null)        
        {
            int adapterCount = getCount();
    if(adapterCount <= getNumActiveViews() && mLoopViews)            
            {
                int var0F4D20AC4C773A418CA37E614337E288_1842653472 = (adapterCount*mMaxNumActiveViews);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1691899511 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1691899511;
            } //End block
            else
            {
                int varA5C0CB122B416B649A7DE771DB95949F_667022094 = (adapterCount);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_116743106 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_116743106;
            } //End block
        } //End block
        else
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1522756340 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_404262148 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_404262148;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.376 -0400", hash_original_method = "1D56DD893F980F245C60382C98FF1278", hash_generated_method = "8258C070FBFD0AA0BD5AE2ED5FAC01F2")
    private ViewAndMetaData getMetaDataForChild(View child) {
        addTaint(child.getTaint());
for(ViewAndMetaData vm : mViewsMap.values())
        {
    if(vm.view == child)            
            {
ViewAndMetaData var516574B285DC68B6ED438E43999A3A39_1486821679 =                 vm;
                var516574B285DC68B6ED438E43999A3A39_1486821679.addTaint(taint);
                return var516574B285DC68B6ED438E43999A3A39_1486821679;
            } //End block
        } //End block
ViewAndMetaData var540C13E9E156B687226421B24F2DF178_1250495196 =         null;
        var540C13E9E156B687226421B24F2DF178_1250495196.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1250495196;
        // ---------- Original Method ----------
        //for (ViewAndMetaData vm: mViewsMap.values()) {
            //if (vm.view == child) {
                //return vm;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.377 -0400", hash_original_method = "F5EC02A85B8BD647E297FF00917E7C1D", hash_generated_method = "5B17A403BE45B95C4DFBAD4B5426EB4D")
     LayoutParams createOrReuseLayoutParams(View v) {
        addTaint(v.getTaint());
        final ViewGroup.LayoutParams currentLp = v.getLayoutParams();
    if(currentLp instanceof ViewGroup.LayoutParams)        
        {
            LayoutParams lp = (LayoutParams) currentLp;
LayoutParams var91B5D28524FC29CFA4C262BA1E7587AA_192917247 =             lp;
            var91B5D28524FC29CFA4C262BA1E7587AA_192917247.addTaint(taint);
            return var91B5D28524FC29CFA4C262BA1E7587AA_192917247;
        } //End block
LayoutParams varF44D7F30B9B6E328389E3C590584E540_501590668 =         new ViewGroup.LayoutParams(0, 0);
        varF44D7F30B9B6E328389E3C590584E540_501590668.addTaint(taint);
        return varF44D7F30B9B6E328389E3C590584E540_501590668;
        // ---------- Original Method ----------
        //final ViewGroup.LayoutParams currentLp = v.getLayoutParams();
        //if (currentLp instanceof ViewGroup.LayoutParams) {
            //LayoutParams lp = (LayoutParams) currentLp;
            //return lp;
        //}
        //return new ViewGroup.LayoutParams(0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.377 -0400", hash_original_method = "DEC1654E1282F99AB82BE6A9F7EE0E03", hash_generated_method = "C34AFDD7AA04B83619F4FE00C2C05E72")
     void refreshChildren() {
    if(mAdapter == null)        
        return;
for(int i = mCurrentWindowStart;i <= mCurrentWindowEnd;i++)
        {
            int index = modulo(i, getWindowSize());
            int adapterCount = getCount();
            final View updatedChild = mAdapter.getView(modulo(i, adapterCount), null, this);
    if(mViewsMap.containsKey(index))            
            {
                final FrameLayout fl = (FrameLayout) mViewsMap.get(index).view;
    if(updatedChild != null)                
                {
                    fl.removeAllViewsInLayout();
                    fl.addView(updatedChild);
                } //End block
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.377 -0400", hash_original_method = "3A74ED5464ECC3EDCA3FF6D985E482E9", hash_generated_method = "0A2DF0B15998BBD5BF22A1E432DFDC1B")
     FrameLayout getFrameForChild() {
FrameLayout var8050F23A0304DA90B73A010A3C16762E_1681479318 =         new FrameLayout(mContext);
        var8050F23A0304DA90B73A010A3C16762E_1681479318.addTaint(taint);
        return var8050F23A0304DA90B73A010A3C16762E_1681479318;
        // ---------- Original Method ----------
        //return new FrameLayout(mContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.380 -0400", hash_original_method = "65797EBCBD60DE13415615382F58C13B", hash_generated_method = "0BAAA25300A88024C251B509287E438C")
     void showOnly(int childIndex, boolean animate) {
        addTaint(animate);
        addTaint(childIndex);
    if(mAdapter == null)        
        return;
        final int adapterCount = getCount();
    if(adapterCount == 0)        
        return;
for(int i = 0;i < mPreviousViews.size();i++)
        {
            View viewToRemove = mViewsMap.get(mPreviousViews.get(i)).view;
            mViewsMap.remove(mPreviousViews.get(i));
            viewToRemove.clearAnimation();
    if(viewToRemove instanceof ViewGroup)            
            {
                ViewGroup vg = (ViewGroup) viewToRemove;
                vg.removeAllViewsInLayout();
            } //End block
            applyTransformForChildAtIndex(viewToRemove, -1);
            removeViewInLayout(viewToRemove);
        } //End block
        mPreviousViews.clear();
        int newWindowStartUnbounded = childIndex - mActiveOffset;
        int newWindowEndUnbounded = newWindowStartUnbounded + getNumActiveViews() - 1;
        int newWindowStart = Math.max(0, newWindowStartUnbounded);
        int newWindowEnd = Math.min(adapterCount - 1, newWindowEndUnbounded);
    if(mLoopViews)        
        {
            newWindowStart = newWindowStartUnbounded;
            newWindowEnd = newWindowEndUnbounded;
        } //End block
        int rangeStart = modulo(newWindowStart, getWindowSize());
        int rangeEnd = modulo(newWindowEnd, getWindowSize());
        boolean wrap = false;
    if(rangeStart > rangeEnd)        
        {
            wrap = true;
        } //End block
for(Integer index : mViewsMap.keySet())
        {
            boolean remove = false;
    if(!wrap && (index < rangeStart || index > rangeEnd))            
            {
                remove = true;
            } //End block
            else
    if(wrap && (index > rangeEnd && index < rangeStart))            
            {
                remove = true;
            } //End block
    if(remove)            
            {
                View previousView = mViewsMap.get(index).view;
                int oldRelativeIndex = mViewsMap.get(index).relativeIndex;
                mPreviousViews.add(index);
                transformViewForTransition(oldRelativeIndex, -1, previousView, animate);
            } //End block
        } //End block
    if(!(newWindowStart == mCurrentWindowStart && newWindowEnd == mCurrentWindowEnd &&
              newWindowStartUnbounded == mCurrentWindowStartUnbounded))        
        {
for(int i = newWindowStart;i <= newWindowEnd;i++)
            {
                int index = modulo(i, getWindowSize());
                int oldRelativeIndex;
    if(mViewsMap.containsKey(index))                
                {
                    oldRelativeIndex = mViewsMap.get(index).relativeIndex;
                } //End block
                else
                {
                    oldRelativeIndex = -1;
                } //End block
                int newRelativeIndex = i - newWindowStartUnbounded;
                boolean inOldRange = mViewsMap.containsKey(index) && !mPreviousViews.contains(index);
    if(inOldRange)                
                {
                    View view = mViewsMap.get(index).view;
                    mViewsMap.get(index).relativeIndex = newRelativeIndex;
                    applyTransformForChildAtIndex(view, newRelativeIndex);
                    transformViewForTransition(oldRelativeIndex, newRelativeIndex, view, animate);
                } //End block
                else
                {
                    final int adapterPosition = modulo(i, adapterCount);
                    View newView = mAdapter.getView(adapterPosition, null, this);
                    long itemId = mAdapter.getItemId(adapterPosition);
                    FrameLayout fl = getFrameForChild();
    if(newView != null)                    
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
            mCurrentWindowStart = newWindowStart;
            mCurrentWindowEnd = newWindowEnd;
            mCurrentWindowStartUnbounded = newWindowStartUnbounded;
        } //End block
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.381 -0400", hash_original_method = "CF7E9270D6A781D39501E4BBAEBB3A13", hash_generated_method = "C23055D9A605ECD16C59A605EBC3401D")
    private void addChild(View child) {
        addViewInLayout(child, -1, createOrReuseLayoutParams(child));
    if(mReferenceChildWidth == -1 || mReferenceChildHeight == -1)        
        {
            int measureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.382 -0400", hash_original_method = "2ABC3404C13E4A800F47D0C635B72929", hash_generated_method = "B76206E375F67296445B5E81A1C71E6E")
     void showTapFeedback(View v) {
        addTaint(v.getTaint());
        v.setPressed(true);
        // ---------- Original Method ----------
        //v.setPressed(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.382 -0400", hash_original_method = "AB8C1F9AF8BDC4DF902FB7F7CD728C3A", hash_generated_method = "369F102CB7BAB1BF79FE2978B2B02433")
     void hideTapFeedback(View v) {
        addTaint(v.getTaint());
        v.setPressed(false);
        // ---------- Original Method ----------
        //v.setPressed(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.382 -0400", hash_original_method = "67399547287D8F71A7A5AE67A071254C", hash_generated_method = "BBDB77C0D792C44830BC3430697FE549")
     void cancelHandleClick() {
        View v = getCurrentView();
    if(v != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.385 -0400", hash_original_method = "A2B685172F5BE99872ECD239B8E084E5", hash_generated_method = "31583E41B13769BD171304B96B6484EC")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(ev.getTaint());
        int action = ev.getAction();
        boolean handled = false;
switch(action){
        case MotionEvent.ACTION_DOWN:
        {
            View v = getCurrentView();
    if(v != null)            
            {
    if(isTransformedTouchPointInView(ev.getX(), ev.getY(), v, null))                
                {
    if(mPendingCheckForTap == null)                    
                    {
                        mPendingCheckForTap = new CheckForTap();
                    } //End block
                    mTouchMode = TOUCH_MODE_DOWN_IN_CURRENT_VIEW;
                    postDelayed(mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                } //End block
            } //End block
            break;
        } //End block
        case MotionEvent.ACTION_MOVE:
        break;
        case MotionEvent.ACTION_POINTER_UP:
        break;
        case MotionEvent.ACTION_UP:
        {
    if(mTouchMode == TOUCH_MODE_DOWN_IN_CURRENT_VIEW)            
            {
                final View v = getCurrentView();
                final ViewAndMetaData viewData = getMetaDataForChild(v);
    if(v != null)                
                {
    if(isTransformedTouchPointInView(ev.getX(), ev.getY(), v, null))                    
                    {
                        final Handler handler = getHandler();
    if(handler != null)                        
                        {
                            handler.removeCallbacks(mPendingCheckForTap);
                        } //End block
                        showTapFeedback(v);
                        postDelayed(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.384 -0400", hash_original_method = "514935A2E7728F849473B37374E9557E", hash_generated_method = "6EC4BEA86AA728053D1EBF33077D5E6A")
        public void run() {
            hideTapFeedback(v);
            post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.384 -0400", hash_original_method = "42524E48826E836CBD16722378FBDC75", hash_generated_method = "A57FD1A608C7826F1FB7A8DDF241C8A5")
            public void run() {
    if(viewData != null)                
                {
                    performItemClick(v, viewData.adapterPosition,
                                                        viewData.itemId);
                } //End block
                else
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
                } //End block
            } //End block
            mTouchMode = TOUCH_MODE_NONE;
            break;
        } //End block
        case MotionEvent.ACTION_CANCEL:
        {
            View v = getCurrentView();
    if(v != null)            
            {
                hideTapFeedback(v);
            } //End block
            mTouchMode = TOUCH_MODE_NONE;
        } //End block
}        boolean var98F0599AF776A1FE4101C199A40EEB8F_162530795 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_915811825 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_915811825;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.385 -0400", hash_original_method = "CF7CC5DB55CCFC095F8C480C67A97670", hash_generated_method = "36306F17917E67726131EEBB4DDE9153")
    private void measureChildren() {
        final int count = getChildCount();
        final int childWidth = getMeasuredWidth() - mPaddingLeft - mPaddingRight;
        final int childHeight = getMeasuredHeight() - mPaddingTop - mPaddingBottom;
for(int i = 0;i < count;i++)
        {
            final View child = getChildAt(i);
            child.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY));
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.386 -0400", hash_original_method = "B8DC8FCB5714B92F7D9B397FCC5E6B1D", hash_generated_method = "C63FDA3E2FFBD96CBE040196524A0D51")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        final int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        boolean haveChildRefSize = (mReferenceChildWidth != -1 && mReferenceChildHeight != -1);
    if(heightSpecMode == MeasureSpec.UNSPECIFIED)        
        {
            heightSpecSize = haveChildRefSize ? mReferenceChildHeight + mPaddingTop +
                    mPaddingBottom : 0;
        } //End block
        else
    if(heightSpecMode == MeasureSpec.AT_MOST)        
        {
    if(haveChildRefSize)            
            {
                int height = mReferenceChildHeight + mPaddingTop + mPaddingBottom;
    if(height > heightSpecSize)                
                {
                    heightSpecSize |= MEASURED_STATE_TOO_SMALL;
                } //End block
                else
                {
                    heightSpecSize = height;
                } //End block
            } //End block
        } //End block
    if(widthSpecMode == MeasureSpec.UNSPECIFIED)        
        {
            widthSpecSize = haveChildRefSize ? mReferenceChildWidth + mPaddingLeft +
                    mPaddingRight : 0;
        } //End block
        else
    if(heightSpecMode == MeasureSpec.AT_MOST)        
        {
    if(haveChildRefSize)            
            {
                int width = mReferenceChildWidth + mPaddingLeft + mPaddingRight;
    if(width > widthSpecSize)                
                {
                    widthSpecSize |= MEASURED_STATE_TOO_SMALL;
                } //End block
                else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.388 -0400", hash_original_method = "F3EF4D3CC56F2B38758DB6D9F3299660", hash_generated_method = "4ECF60777C8A6E6D4182A391E061E7B5")
     void checkForAndHandleDataChanged() {
        boolean dataChanged = mDataChanged;
    if(dataChanged)        
        {
            post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.387 -0400", hash_original_method = "15BF43057866669BD34B56F96081697B", hash_generated_method = "C18BA3A204F9E3D7D17FD1BC80E4A6B7")
        public void run() {
            handleDataChanged();
    if(mWhichChild >= getWindowSize())            
            {
                mWhichChild = 0;
                showOnly(mWhichChild, false);
            } //End block
            else
    if(mOldItemCount != getCount())            
            {
                showOnly(mWhichChild, false);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.388 -0400", hash_original_method = "BFF47184DAE09EA9D82185EB27DBF22D", hash_generated_method = "E4C8612F7772A03D48EB3C95AB950739")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        addTaint(changed);
        checkForAndHandleDataChanged();
        final int childCount = getChildCount();
for(int i = 0;i < childCount;i++)
        {
            final View child = getChildAt(i);
            int childRight = mPaddingLeft + child.getMeasuredWidth();
            int childBottom = mPaddingTop + child.getMeasuredHeight();
            child.layout(mPaddingLeft, mPaddingTop, childRight, childBottom);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.389 -0400", hash_original_method = "C09C373B1A1103A4B30F4932FEFEB18D", hash_generated_method = "BA45C7C460EA71932D68FC0A2F9D130A")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable superState = super.onSaveInstanceState();
Parcelable var11363738A09686A83D7F808C5259F29A_1457576814 =         new SavedState(superState, mWhichChild);
        var11363738A09686A83D7F808C5259F29A_1457576814.addTaint(taint);
        return var11363738A09686A83D7F808C5259F29A_1457576814;
        // ---------- Original Method ----------
        //Parcelable superState = super.onSaveInstanceState();
        //return new SavedState(superState, mWhichChild);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.389 -0400", hash_original_method = "A2807F1883DAD1F14A6CC088A989D676", hash_generated_method = "F7A2B037FE18B88D1D426D476A09B500")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        mWhichChild = ss.whichChild;
    if(mRemoteViewsAdapter != null && mAdapter == null)        
        {
            mRestoreWhichChild = mWhichChild;
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.389 -0400", hash_original_method = "906CF989810621761D25CEDBF35A3122", hash_generated_method = "8B1596A5D5CD403809283BFF7F9B76B2")
    public View getCurrentView() {
View varD83D48D5932ACB235CE655A1204CCB70_546050429 =         getViewAtRelativeIndex(mActiveOffset);
        varD83D48D5932ACB235CE655A1204CCB70_546050429.addTaint(taint);
        return varD83D48D5932ACB235CE655A1204CCB70_546050429;
        // ---------- Original Method ----------
        //return getViewAtRelativeIndex(mActiveOffset);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.390 -0400", hash_original_method = "23AFF2D08DB63552361956C44B4439AE", hash_generated_method = "F9874A5D4C5566522725D1F0707CA6A0")
    public ObjectAnimator getInAnimation() {
ObjectAnimator var4B5C05D2D2A95AF947FC9E803E337EB1_1460361330 =         mInAnimation;
        var4B5C05D2D2A95AF947FC9E803E337EB1_1460361330.addTaint(taint);
        return var4B5C05D2D2A95AF947FC9E803E337EB1_1460361330;
        // ---------- Original Method ----------
        //return mInAnimation;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.390 -0400", hash_original_method = "4E43CB38736F57C9005B93984FDB3BE2", hash_generated_method = "EA5FC0666FD015F2A1540E2A3150D3AB")
    public void setInAnimation(ObjectAnimator inAnimation) {
        mInAnimation = inAnimation;
        // ---------- Original Method ----------
        //mInAnimation = inAnimation;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.390 -0400", hash_original_method = "6B0CDF48C8054A61C9B211FDE065CA93", hash_generated_method = "4503F642B064FAA723CB11C62417D023")
    public ObjectAnimator getOutAnimation() {
ObjectAnimator var12545A6CD44F5F92DFAF41C046B9E960_116028624 =         mOutAnimation;
        var12545A6CD44F5F92DFAF41C046B9E960_116028624.addTaint(taint);
        return var12545A6CD44F5F92DFAF41C046B9E960_116028624;
        // ---------- Original Method ----------
        //return mOutAnimation;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.390 -0400", hash_original_method = "1BCB8E8A3DAEDE15E6756EE2F683DC83", hash_generated_method = "C301EFF9C320600FE647D35958651477")
    public void setOutAnimation(ObjectAnimator outAnimation) {
        mOutAnimation = outAnimation;
        // ---------- Original Method ----------
        //mOutAnimation = outAnimation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.391 -0400", hash_original_method = "8F8897D1BAA8E5AE19C8237937D2CA37", hash_generated_method = "A3ADF7B0F83B11AD96E0A146947E0BB8")
    public void setInAnimation(Context context, int resourceID) {
        addTaint(resourceID);
        addTaint(context.getTaint());
        setInAnimation((ObjectAnimator) AnimatorInflater.loadAnimator(context, resourceID));
        // ---------- Original Method ----------
        //setInAnimation((ObjectAnimator) AnimatorInflater.loadAnimator(context, resourceID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.391 -0400", hash_original_method = "DAE8806685F393E416F20FAE75D3F12A", hash_generated_method = "C24C91214C584D636318758EC1F2165A")
    public void setOutAnimation(Context context, int resourceID) {
        addTaint(resourceID);
        addTaint(context.getTaint());
        setOutAnimation((ObjectAnimator) AnimatorInflater.loadAnimator(context, resourceID));
        // ---------- Original Method ----------
        //setOutAnimation((ObjectAnimator) AnimatorInflater.loadAnimator(context, resourceID));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.391 -0400", hash_original_method = "8FC95409534ABC48E92905DC8C518CE2", hash_generated_method = "B8F320B30FC7DD41541BCFCAA6FCA367")
    public void setAnimateFirstView(boolean animate) {
        mAnimateFirstTime = animate;
        // ---------- Original Method ----------
        //mAnimateFirstTime = animate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.392 -0400", hash_original_method = "0B91CAAE76789C8A4B2B18C9D0AAF852", hash_generated_method = "85766D742510D9D205EE9E967A0824C7")
    @Override
    public int getBaseline() {
        int var4702CD21947610980ED4BFE44C6C48B3_617745954 = ((getCurrentView() != null) ? getCurrentView().getBaseline() : super.getBaseline());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1352418187 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1352418187;
        // ---------- Original Method ----------
        //return (getCurrentView() != null) ? getCurrentView().getBaseline() : super.getBaseline();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.392 -0400", hash_original_method = "4778E83EF7DB01E18145E85F688E24B4", hash_generated_method = "816E08BD7BA54EC30735C7B11940C83D")
    @Override
    public Adapter getAdapter() {
Adapter varD72668EDE5E63ADF9340F3D8A19FD205_1265176362 =         mAdapter;
        varD72668EDE5E63ADF9340F3D8A19FD205_1265176362.addTaint(taint);
        return varD72668EDE5E63ADF9340F3D8A19FD205_1265176362;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.393 -0400", hash_original_method = "8F781C0E336C7A94E2963F9C2B9D5E7F", hash_generated_method = "A96D50F98FE7710BCE2F0D5FBBB7FA49")
    @Override
    public void setAdapter(Adapter adapter) {
    if(mAdapter != null && mDataSetObserver != null)        
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        } //End block
        mAdapter = adapter;
        checkFocus();
    if(mAdapter != null)        
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.394 -0400", hash_original_method = "27E899D618A9F50FEEEF08AE1A9356B2", hash_generated_method = "830668230BE8DBAE61B67DFF47A3F87F")
    @android.view.RemotableViewMethod
    public void setRemoteViewsAdapter(Intent intent) {
    if(mRemoteViewsAdapter != null)        
        {
            Intent.FilterComparison fcNew = new Intent.FilterComparison(intent);
            Intent.FilterComparison fcOld = new Intent.FilterComparison(
                    mRemoteViewsAdapter.getRemoteViewsServiceIntent());
    if(fcNew.equals(fcOld))            
            {
                return;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.394 -0400", hash_original_method = "DA18836BD93C624B14E0649B9FD256B6", hash_generated_method = "55CC815711D45E249788DFE6175249CF")
    @Override
    public void setSelection(int position) {
        addTaint(position);
        setDisplayedChild(position);
        // ---------- Original Method ----------
        //setDisplayedChild(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.394 -0400", hash_original_method = "B55B55B562FC01D014E8D16B89577F15", hash_generated_method = "D9D8B7AF015DEFE340ED40A080900AB9")
    @Override
    public View getSelectedView() {
View varD83D48D5932ACB235CE655A1204CCB70_429871561 =         getViewAtRelativeIndex(mActiveOffset);
        varD83D48D5932ACB235CE655A1204CCB70_429871561.addTaint(taint);
        return varD83D48D5932ACB235CE655A1204CCB70_429871561;
        // ---------- Original Method ----------
        //return getViewAtRelativeIndex(mActiveOffset);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.394 -0400", hash_original_method = "0410210FC7BC336B3896BEA7510AAE3D", hash_generated_method = "9D38AC80197E9738EE138974F1EA14DE")
    public void deferNotifyDataSetChanged() {
        mDeferNotifyDataSetChanged = true;
        // ---------- Original Method ----------
        //mDeferNotifyDataSetChanged = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.395 -0400", hash_original_method = "9E5375D03017C5CE595A523DBE298043", hash_generated_method = "FAD984CCBE17A06C7B6075430C7D5F30")
    public boolean onRemoteAdapterConnected() {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(mRemoteViewsAdapter != mAdapter)        
        {
            setAdapter(mRemoteViewsAdapter);
    if(mDeferNotifyDataSetChanged)            
            {
                mRemoteViewsAdapter.notifyDataSetChanged();
                mDeferNotifyDataSetChanged = false;
            } //End block
    if(mRestoreWhichChild > -1)            
            {
                setDisplayedChild(mRestoreWhichChild, false);
                mRestoreWhichChild = -1;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_916932241 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_980995875 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_980995875;
        } //End block
        else
    if(mRemoteViewsAdapter != null)        
        {
            mRemoteViewsAdapter.superNotifyDataSetChanged();
            boolean varB326B5062B2F0E69046810717534CB09_1599920613 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_981781116 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_981781116;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2120005854 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2127239915 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2127239915;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.396 -0400", hash_original_method = "062C10606C6763A75AEC213E65863835", hash_generated_method = "64085B2EAF9EA39B9EA364A5E4CA7F63")
    public void onRemoteAdapterDisconnected() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.396 -0400", hash_original_method = "47C53466AFD69B01265302F86E539CFE", hash_generated_method = "87EFC5B96525071A3735B428531FF9C3")
    public void advance() {
        showNext();
        // ---------- Original Method ----------
        //showNext();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.396 -0400", hash_original_method = "1A32686EBDFA985B54B6CF53155BB413", hash_generated_method = "AD4C3644092881C2E0FBB4399DF4389D")
    public void fyiWillBeAdvancedByHostKThx() {
        // ---------- Original Method ----------
    }

    
    class ViewAndMetaData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.396 -0400", hash_original_field = "1BDA80F2BE4D3658E0BAA43FBE7AE8C1", hash_generated_field = "203A52904F64FA8CF6CE15F1E8FE3025")

        View view;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.396 -0400", hash_original_field = "1649870BFCA992A7734977CEF67E4975", hash_generated_field = "F52544800E665053DD324CCFDCF1B6BE")

        int relativeIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.396 -0400", hash_original_field = "FEF97891E871CA6DBF8C5D0E12EFD666", hash_generated_field = "F4E75FF2D1EE9ACFE3453A0D6E862D8C")

        int adapterPosition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.396 -0400", hash_original_field = "59A814AA020A1B32C4674A5887A35022", hash_generated_field = "90EEB5AA84937AD6A8CE9746B6FECA6A")

        long itemId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.397 -0400", hash_original_method = "35BDC394C726F4932D0D464E91A92D34", hash_generated_method = "C8E3B8D5DA225BE5086B6B8C2E465CDD")
          ViewAndMetaData(View view, int relativeIndex, int adapterPosition, long itemId) {
            this.view = view;
            this.relativeIndex = relativeIndex;
            this.adapterPosition = adapterPosition;
            this.itemId = itemId;
            // ---------- Original Method ----------
            //this.view = view;
            //this.relativeIndex = relativeIndex;
            //this.adapterPosition = adapterPosition;
            //this.itemId = itemId;
        }

        
    }


    
    final class CheckForTap implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.397 -0400", hash_original_method = "AB5DEBF7CC7D6BE3A48A21837827B410", hash_generated_method = "AB5DEBF7CC7D6BE3A48A21837827B410")
        public CheckForTap ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.397 -0400", hash_original_method = "0DE0DC1F19EC8E43C86C5443C435E50A", hash_generated_method = "A71C94AEF73BB8B2781AAC869A1D927C")
        public void run() {
    if(mTouchMode == TOUCH_MODE_DOWN_IN_CURRENT_VIEW)            
            {
                View v = getCurrentView();
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.398 -0400", hash_original_field = "CE5C510735FE6790F65A3AA148FAE8B4", hash_generated_field = "522DBB163D0DA4822B2CF5511F1DEE9A")

        int whichChild;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.398 -0400", hash_original_method = "B7BF12453E93628DE35CAA34B998429F", hash_generated_method = "DC495D06C7EDE4BF17FA8427E16535EB")
          SavedState(Parcelable superState, int whichChild) {
            super(superState);
            addTaint(superState.getTaint());
            this.whichChild = whichChild;
            // ---------- Original Method ----------
            //this.whichChild = whichChild;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.399 -0400", hash_original_method = "392EDFCBBF619540219C8F70BEB96B16", hash_generated_method = "D17CD0B9598104FED0F460078284E1DD")
        private  SavedState(Parcel in) {
            super(in);
            this.whichChild = in.readInt();
            // ---------- Original Method ----------
            //this.whichChild = in.readInt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.399 -0400", hash_original_method = "DA40422C10B10105F9CB19E8091B3EEC", hash_generated_method = "4541675DC163D71633572B103667F7C7")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            addTaint(flags);
            addTaint(out.getTaint());
            super.writeToParcel(out, flags);
            out.writeInt(this.whichChild);
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeInt(this.whichChild);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.399 -0400", hash_original_method = "808D88187ABBC8D595A46EE25C5AC5ED", hash_generated_method = "7E65C72832E266E06F8FD758EB58F277")
        @Override
        public String toString() {
String varBB90EC9BBBCCB3859934BE2FA50C5569_1417971921 =             "AdapterViewAnimator.SavedState{ whichChild = " + this.whichChild + " }";
            varBB90EC9BBBCCB3859934BE2FA50C5569_1417971921.addTaint(taint);
            return varBB90EC9BBBCCB3859934BE2FA50C5569_1417971921;
            // ---------- Original Method ----------
            //return "AdapterViewAnimator.SavedState{ whichChild = " + this.whichChild + " }";
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.400 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.400 -0400", hash_original_field = "BA38F1273922EBA69134FC12348D9DC6", hash_generated_field = "3A652617CCF7727670B8485C49C1574A")

    private static final String TAG = "RemoteViewAnimator";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.400 -0400", hash_original_field = "7DE134AF0FADA22646CB6752D5B20793", hash_generated_field = "94E9E36D497ACD2451DC65DFC34FDE84")

    static final int TOUCH_MODE_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.400 -0400", hash_original_field = "6C2B69311814E6B6A05889B884E5C4FF", hash_generated_field = "016189EFF611A0FE1D4693C1CCBDA407")

    static final int TOUCH_MODE_DOWN_IN_CURRENT_VIEW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.400 -0400", hash_original_field = "4F1A03CB78BBB1B4953D9F1B19C942B4", hash_generated_field = "7488778163D886E6949F033B92DE547C")

    static final int TOUCH_MODE_HANDLED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.400 -0400", hash_original_field = "ECAE526882BC6D6EF1127CB35D7351D3", hash_generated_field = "F6CDC47961A92F3B929B6B11861E0C14")

    private static final int DEFAULT_ANIMATION_DURATION = 200;
}

