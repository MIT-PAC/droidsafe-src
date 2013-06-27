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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.507 -0400", hash_original_field = "EA21F533229388AA4B2EFE079FA29356", hash_generated_field = "A4199CA8B30F98AAF67F6FDF10E09266")

    int mWhichChild = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.507 -0400", hash_original_field = "C0E47D0A038ADFE91661E4E5371F0BD6", hash_generated_field = "A493EB2C57153A47A21988AED08A61F9")

    private int mRestoreWhichChild = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.507 -0400", hash_original_field = "FDE1980A01124F9ECAD446EEE35F7267", hash_generated_field = "11022FC94DBD000AF0F23EE6D44DA07A")

    boolean mAnimateFirstTime = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.508 -0400", hash_original_field = "C0C9D87647F1DD58CD2938611477200B", hash_generated_field = "1CB8D73EF29501CAF0F770C194E4A275")

    int mActiveOffset = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.508 -0400", hash_original_field = "E46FAD00B5C2DBF29FABE10F0F93BDAB", hash_generated_field = "F89A42DD2C5934C96B97C28D423189DC")

    int mMaxNumActiveViews = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.508 -0400", hash_original_field = "24A5E7040AA6FFE7AE892C9904044EF6", hash_generated_field = "0CC41FBC4366667A564C06DC4F0D9357")

    HashMap<Integer, ViewAndMetaData> mViewsMap = new HashMap<Integer, ViewAndMetaData>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.508 -0400", hash_original_field = "AD55C52A81E04B39FEAF449A80DEC714", hash_generated_field = "DCC538958BCCC098025B00C03E72E198")

    ArrayList<Integer> mPreviousViews;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.521 -0400", hash_original_field = "DC605E9287B2D84952185DAA194FE524", hash_generated_field = "3A6641FE6CF608A1624B00F1DAB420F6")

    int mCurrentWindowStart = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.521 -0400", hash_original_field = "4859BE4C935A36901AB8D860398C0451", hash_generated_field = "F84B4803BE53A338433E57C705009CC2")

    int mCurrentWindowEnd = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.521 -0400", hash_original_field = "8B9C4207ECA1072C739371D6A4CB8F55", hash_generated_field = "875B8F5BD30A8973DBF780138CCA9A4B")

    int mCurrentWindowStartUnbounded = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.521 -0400", hash_original_field = "1AB0B744C03B78F09E9DEC3C88684ED1", hash_generated_field = "C2A92A98CA414A0C47C4CCACBB8EA2C2")

    AdapterDataSetObserver mDataSetObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.521 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "2CCFA3B9041B42EEC769AA09DF8CA535")

    Adapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.521 -0400", hash_original_field = "46E2FBD69946D5D63C919774CDC2709A", hash_generated_field = "6C2145BBB74854B314D98BC5E793C836")

    RemoteViewsAdapter mRemoteViewsAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.521 -0400", hash_original_field = "8DBD1724A62493247BCB06E14E790DDB", hash_generated_field = "D8481D38E4E063E4EC28948859294EB6")

    boolean mDeferNotifyDataSetChanged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.521 -0400", hash_original_field = "819CF91F91F67E3ABFDBBF304392B421", hash_generated_field = "319BF9E49F2FBE9453A9508A3A60521D")

    boolean mFirstTime = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.521 -0400", hash_original_field = "E9CF07B4E9DF18186772188A653F6ACD", hash_generated_field = "EE119C98E20A644961B6553C661011C0")

    boolean mLoopViews = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.521 -0400", hash_original_field = "EDE726180C85C86910D06D268C52F692", hash_generated_field = "A104F61DF317955825146E40FC0C3A53")

    int mReferenceChildWidth = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.521 -0400", hash_original_field = "BDC749679D65E3F204B9D532393B6541", hash_generated_field = "FD007F8803D65B2ABC0CC17D246ED815")

    int mReferenceChildHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.521 -0400", hash_original_field = "69EE9328057C3731E3E5851972F2D1BA", hash_generated_field = "C00C0EA8F9B59A998740D4241DDCA251")

    ObjectAnimator mInAnimation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.521 -0400", hash_original_field = "00AD3937DA6C2650F811216846F50E5C", hash_generated_field = "4FC9F8644D505DE7FB36472E6D47BDF1")

    ObjectAnimator mOutAnimation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.521 -0400", hash_original_field = "011DFC8310C57F40F856FB0A216752FC", hash_generated_field = "9849E22BF41E24F9EE56259FB24FEA91")

    private int mTouchMode = TOUCH_MODE_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.521 -0400", hash_original_field = "4349FC27F2087C20272E81AADEE9392A", hash_generated_field = "C7859F448E179D513123D1E080D96FF5")

    private Runnable mPendingCheckForTap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.522 -0400", hash_original_method = "5A28C6E6B4D6383379224D19746F7CDC", hash_generated_method = "A6ED3146008CDFA5DD8DB6A1373C5F32")
    public  AdapterViewAnimator(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.522 -0400", hash_original_method = "ADD24FA1FA279C1B8387D7B0109F9EEC", hash_generated_method = "E834547F869ADF8877093E7846364F01")
    public  AdapterViewAnimator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.523 -0400", hash_original_method = "C5643612A08EABEF3EDB2D9CFA87FEC7", hash_generated_method = "E453303527411C01B430E85CF075FB16")
    public  AdapterViewAnimator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyleAttr);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.523 -0400", hash_original_method = "4508B464C0C2084478BE2A642B32436E", hash_generated_method = "0AEEC796AE042A1371E848170F3AEF4C")
    private void initViewAnimator() {
        mPreviousViews = new ArrayList<Integer>();
        // ---------- Original Method ----------
        //mPreviousViews = new ArrayList<Integer>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.523 -0400", hash_original_method = "91B9FA80E0031C77B528C608AC4759E5", hash_generated_method = "099EC35CF8611C5EE387FB89DF80D853")
     void configureViewAnimator(int numVisibleViews, int activeOffset) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.541 -0400", hash_original_method = "CD78C78157016071B0AA2236145765B6", hash_generated_method = "195E7C1B94309F4C1EA7ABE376969E2B")
     void transformViewForTransition(int fromIndex, int toIndex, View view, boolean animate) {
        {
            mInAnimation.setTarget(view);
            mInAnimation.start();
        } //End block
        {
            mOutAnimation.setTarget(view);
            mOutAnimation.start();
        } //End block
        addTaint(fromIndex);
        addTaint(toIndex);
        addTaint(view.getTaint());
        addTaint(animate);
        // ---------- Original Method ----------
        //if (fromIndex == -1) {
            //mInAnimation.setTarget(view);
            //mInAnimation.start();
        //} else if (toIndex == -1) {
            //mOutAnimation.setTarget(view);
            //mOutAnimation.start();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.541 -0400", hash_original_method = "1B47254A99E5F108270897DC3078BE58", hash_generated_method = "4162D008FB1BC74B3F58F7BA2B839BEA")
     ObjectAnimator getDefaultInAnimation() {
        ObjectAnimator varB4EAC82CA7396A68D541C85D26508E83_1616598199 = null; //Variable for return #1
        ObjectAnimator anim;
        anim = ObjectAnimator.ofFloat(null, "alpha", 0.0f, 1.0f);
        anim.setDuration(DEFAULT_ANIMATION_DURATION);
        varB4EAC82CA7396A68D541C85D26508E83_1616598199 = anim;
        varB4EAC82CA7396A68D541C85D26508E83_1616598199.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1616598199;
        // ---------- Original Method ----------
        //ObjectAnimator anim = ObjectAnimator.ofFloat(null, "alpha", 0.0f, 1.0f);
        //anim.setDuration(DEFAULT_ANIMATION_DURATION);
        //return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.542 -0400", hash_original_method = "FB8DA060E53CA502AAAD2E0D3630FF89", hash_generated_method = "34CB69C1C82B5A724DB69AA7E32C84EC")
     ObjectAnimator getDefaultOutAnimation() {
        ObjectAnimator varB4EAC82CA7396A68D541C85D26508E83_685386909 = null; //Variable for return #1
        ObjectAnimator anim;
        anim = ObjectAnimator.ofFloat(null, "alpha", 1.0f, 0.0f);
        anim.setDuration(DEFAULT_ANIMATION_DURATION);
        varB4EAC82CA7396A68D541C85D26508E83_685386909 = anim;
        varB4EAC82CA7396A68D541C85D26508E83_685386909.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_685386909;
        // ---------- Original Method ----------
        //ObjectAnimator anim = ObjectAnimator.ofFloat(null, "alpha", 1.0f, 0.0f);
        //anim.setDuration(DEFAULT_ANIMATION_DURATION);
        //return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.542 -0400", hash_original_method = "C45281778BDF4A98514907509DE78D33", hash_generated_method = "86CB72FD0FA25F1C193103E9FCC8A84C")
    @android.view.RemotableViewMethod
    public void setDisplayedChild(int whichChild) {
        setDisplayedChild(whichChild, true);
        addTaint(whichChild);
        // ---------- Original Method ----------
        //setDisplayedChild(whichChild, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.543 -0400", hash_original_method = "91CB6634BDE3355704A6B2B246DAA7A9", hash_generated_method = "251F321D48B124100ED3496A609822B9")
    private void setDisplayedChild(int whichChild, boolean animate) {
        {
            mWhichChild = whichChild;
            {
                boolean var4423A414EEE509E3F96136E1F46B5612_1219220860 = (whichChild >= getWindowSize());
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
        addTaint(animate);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.543 -0400", hash_original_method = "A7ED1EB61B0FBCD2BEBD15D1C1303F9C", hash_generated_method = "9F5C7DAA3E2BF87BE2ACDED77873FF9E")
     void applyTransformForChildAtIndex(View child, int relativeIndex) {
        addTaint(child.getTaint());
        addTaint(relativeIndex);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.544 -0400", hash_original_method = "EEFA4D3ABF985412351A1BD0CB5D6161", hash_generated_method = "B70CEAA52D66CEEA44F18911AEC03140")
    public int getDisplayedChild() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1968615250 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1968615250;
        // ---------- Original Method ----------
        //return mWhichChild;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.545 -0400", hash_original_method = "EFCC34AA69F6F34103211EDFAD5FB56A", hash_generated_method = "EB11A1D2F0D61EF8CF5A7F00E571FA28")
    public void showNext() {
        setDisplayedChild(mWhichChild + 1);
        // ---------- Original Method ----------
        //setDisplayedChild(mWhichChild + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.545 -0400", hash_original_method = "F846DD3340718784FB63764FD5BBF0F3", hash_generated_method = "A6ED72EB8F3F7302328A84241E26038A")
    public void showPrevious() {
        setDisplayedChild(mWhichChild - 1);
        // ---------- Original Method ----------
        //setDisplayedChild(mWhichChild - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.545 -0400", hash_original_method = "2C561D0D9BDC240B9A5D5DE9ED7CC2E1", hash_generated_method = "5FE433649E3E73D853D311D13377F446")
     int modulo(int pos, int size) {
        addTaint(pos);
        addTaint(size);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110256385 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110256385;
        // ---------- Original Method ----------
        //if (size > 0) {
            //return (size + (pos % size)) % size;
        //} else {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.666 -0400", hash_original_method = "FBBD82E59359C019A1CEF3EB94A89AA2", hash_generated_method = "3C0760626A8E1AA234324A8F11777E13")
     View getViewAtRelativeIndex(int relativeIndex) {
        View varB4EAC82CA7396A68D541C85D26508E83_161092879 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_1399546951 = null; //Variable for return #2
        {
            boolean varDAB78BEED386DC6D5D7AAFFD9BC0EFBA_654865362 = (relativeIndex >= 0 && relativeIndex <= getNumActiveViews() - 1 && mAdapter != null);
            {
                int i;
                i = modulo(mCurrentWindowStartUnbounded + relativeIndex, getWindowSize());
                {
                    boolean var70175653C6235B3C753B7C1934966D77_218258312 = (mViewsMap.get(i) != null);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_161092879 = mViewsMap.get(i).view;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1399546951 = null;
        addTaint(relativeIndex);
        View varA7E53CE21691AB073D9660D615818899_1841981715; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1841981715 = varB4EAC82CA7396A68D541C85D26508E83_161092879;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1841981715 = varB4EAC82CA7396A68D541C85D26508E83_1399546951;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1841981715.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1841981715;
        // ---------- Original Method ----------
        //if (relativeIndex >= 0 && relativeIndex <= getNumActiveViews() - 1 && mAdapter != null) {
            //int i = modulo(mCurrentWindowStartUnbounded + relativeIndex, getWindowSize());
            //if (mViewsMap.get(i) != null) {
                //return mViewsMap.get(i).view;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.668 -0400", hash_original_method = "0421178BBB7DE66A738CAA04F8761832", hash_generated_method = "3DF99CA157E27548B32C8F25110EB973")
     int getNumActiveViews() {
        {
            int varE9842C7B0E064F871BFD47EBA4713105_1091976041 = (Math.min(getCount() + 1, mMaxNumActiveViews));
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2105501470 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2105501470;
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return Math.min(getCount() + 1, mMaxNumActiveViews);
        //} else {
            //return mMaxNumActiveViews;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.668 -0400", hash_original_method = "6029719CD1CD7AB457F8E78F86AE86A1", hash_generated_method = "40AD75500A23E174E7B8F8B3C6F83261")
     int getWindowSize() {
        {
            int adapterCount;
            adapterCount = getCount();
            {
                boolean varF2A5E737A41E4249CC2B5F17FAC5B9C5_420352077 = (adapterCount <= getNumActiveViews() && mLoopViews);
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_948328724 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_948328724;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.684 -0400", hash_original_method = "1D56DD893F980F245C60382C98FF1278", hash_generated_method = "69FC9B01E4FB49D0968903F4FF3ECD68")
    private ViewAndMetaData getMetaDataForChild(View child) {
        ViewAndMetaData varB4EAC82CA7396A68D541C85D26508E83_514728213 = null; //Variable for return #1
        ViewAndMetaData varB4EAC82CA7396A68D541C85D26508E83_1239988401 = null; //Variable for return #2
        {
            Iterator<ViewAndMetaData> var3D0147521320DBAC5B3812CCE6A51C87_2019202339 = (mViewsMap.values()).iterator();
            var3D0147521320DBAC5B3812CCE6A51C87_2019202339.hasNext();
            ViewAndMetaData vm = var3D0147521320DBAC5B3812CCE6A51C87_2019202339.next();
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_514728213 = vm;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1239988401 = null;
        addTaint(child.getTaint());
        ViewAndMetaData varA7E53CE21691AB073D9660D615818899_739947437; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_739947437 = varB4EAC82CA7396A68D541C85D26508E83_514728213;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_739947437 = varB4EAC82CA7396A68D541C85D26508E83_1239988401;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_739947437.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_739947437;
        // ---------- Original Method ----------
        //for (ViewAndMetaData vm: mViewsMap.values()) {
            //if (vm.view == child) {
                //return vm;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.706 -0400", hash_original_method = "F5EC02A85B8BD647E297FF00917E7C1D", hash_generated_method = "4E22B2E858CB9A10DD6FAC811D0EBAB3")
     LayoutParams createOrReuseLayoutParams(View v) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_375241022 = null; //Variable for return #1
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1754467791 = null; //Variable for return #2
        ViewGroup.LayoutParams currentLp;
        currentLp = v.getLayoutParams();
        {
            LayoutParams lp;
            lp = (LayoutParams) currentLp;
            varB4EAC82CA7396A68D541C85D26508E83_375241022 = lp;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1754467791 = new ViewGroup.LayoutParams(0, 0);
        addTaint(v.getTaint());
        LayoutParams varA7E53CE21691AB073D9660D615818899_1898334063; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1898334063 = varB4EAC82CA7396A68D541C85D26508E83_375241022;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1898334063 = varB4EAC82CA7396A68D541C85D26508E83_1754467791;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1898334063.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1898334063;
        // ---------- Original Method ----------
        //final ViewGroup.LayoutParams currentLp = v.getLayoutParams();
        //if (currentLp instanceof ViewGroup.LayoutParams) {
            //LayoutParams lp = (LayoutParams) currentLp;
            //return lp;
        //}
        //return new ViewGroup.LayoutParams(0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.707 -0400", hash_original_method = "DEC1654E1282F99AB82BE6A9F7EE0E03", hash_generated_method = "0F03139C108B067D440978F04BE8374D")
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
                    boolean varFBF83238722638C3C490302F95CE401D_1588687379 = (mViewsMap.containsKey(index));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.708 -0400", hash_original_method = "3A74ED5464ECC3EDCA3FF6D985E482E9", hash_generated_method = "12E6C49BC295E0CC279F7CAF4DBD82CE")
     FrameLayout getFrameForChild() {
        FrameLayout varB4EAC82CA7396A68D541C85D26508E83_1547505123 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1547505123 = new FrameLayout(mContext);
        varB4EAC82CA7396A68D541C85D26508E83_1547505123.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1547505123;
        // ---------- Original Method ----------
        //return new FrameLayout(mContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.932 -0400", hash_original_method = "65797EBCBD60DE13415615382F58C13B", hash_generated_method = "1255639E174DAC4C07382BA44292DCCA")
     void showOnly(int childIndex, boolean animate) {
        int adapterCount;
        adapterCount = getCount();
        {
            int i;
            i = 0;
            boolean var5324A830B25BBA52B7E406685EFB4F98_1749333312 = (i < mPreviousViews.size());
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
            Iterator<Integer> var610282C9D2149B9A2642D098939F7602_1229940526 = (mViewsMap.keySet()).iterator();
            var610282C9D2149B9A2642D098939F7602_1229940526.hasNext();
            Integer index = var610282C9D2149B9A2642D098939F7602_1229940526.next();
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
                        boolean var41FB02AF47D0FFCEDE206EC611FE70C8_991333555 = (mViewsMap.containsKey(index));
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
        addTaint(childIndex);
        addTaint(animate);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.933 -0400", hash_original_method = "CF7E9270D6A781D39501E4BBAEBB3A13", hash_generated_method = "A8E5C190EC025EB1BE79C9A93F986B02")
    private void addChild(View child) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.950 -0400", hash_original_method = "2ABC3404C13E4A800F47D0C635B72929", hash_generated_method = "722C84CA0E95451E2D212D051A07749E")
     void showTapFeedback(View v) {
        v.setPressed(true);
        addTaint(v.getTaint());
        // ---------- Original Method ----------
        //v.setPressed(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.951 -0400", hash_original_method = "AB8C1F9AF8BDC4DF902FB7F7CD728C3A", hash_generated_method = "0D7E102632C88AC04810A68A5118DAA7")
     void hideTapFeedback(View v) {
        v.setPressed(false);
        addTaint(v.getTaint());
        // ---------- Original Method ----------
        //v.setPressed(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.952 -0400", hash_original_method = "67399547287D8F71A7A5AE67A071254C", hash_generated_method = "5612B6AEDB9DEFC80041AC9EEE15DAD3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.975 -0400", hash_original_method = "A2B685172F5BE99872ECD239B8E084E5", hash_generated_method = "851F52F39045EDBF46F65216BF91CF11")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
                    boolean varBC775EA6D0A73186451B4F7D426A7D5F_1148147951 = (isTransformedTouchPointInView(ev.getX(), ev.getY(), v, null));
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
                        boolean var39EF9DE1D8B67B073EBB22788CA51268_933580953 = (isTransformedTouchPointInView(ev.getX(), ev.getY(), v, null));
                        {
                            Handler handler;
                            handler = getHandler();
                            {
                                handler.removeCallbacks(mPendingCheckForTap);
                            } //End block
                            showTapFeedback(v);
                            postDelayed(new Runnable() {                                
                                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.974 -0400", hash_original_method = "514935A2E7728F849473B37374E9557E", hash_generated_method = "0AC842A42CA28EA8B4E23DA66DE062FA")
                                public void run() {
                                    hideTapFeedback(v);
                                    post(new Runnable() {                                        
                                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.974 -0400", hash_original_method = "42524E48826E836CBD16722378FBDC75", hash_generated_method = "C1A91307072BB396065B4A9D1506B9FB")
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
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1377383114 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1377383114;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.976 -0400", hash_original_method = "CF7CC5DB55CCFC095F8C480C67A97670", hash_generated_method = "1353814AA744592502B211686F50BB8E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.988 -0400", hash_original_method = "B8DC8FCB5714B92F7D9B397FCC5E6B1D", hash_generated_method = "00FC88A460C2280C10F1384FDE5A7A86")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.989 -0400", hash_original_method = "F3EF4D3CC56F2B38758DB6D9F3299660", hash_generated_method = "EA87B333BC32333A04E9E040F7A98D37")
     void checkForAndHandleDataChanged() {
        boolean dataChanged;
        dataChanged = mDataChanged;
        {
            post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.989 -0400", hash_original_method = "15BF43057866669BD34B56F96081697B", hash_generated_method = "08104CCA65BD4A4D8490E940CAFE2C66")
                public void run() {
                    handleDataChanged();
                    {
                        boolean var91476E53455DDBED1C2497762140CD5A_697992774 = (mWhichChild >= getWindowSize());
                        {
                            mWhichChild = 0;
                            showOnly(mWhichChild, false);
                        } //End block
                        {
                            boolean var9A54785035833875439C9F0D8D389EC7_1769325025 = (mOldItemCount != getCount());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.990 -0400", hash_original_method = "BFF47184DAE09EA9D82185EB27DBF22D", hash_generated_method = "955E9F8E8126448CDDB18D8DBBE437FB")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        addTaint(changed);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.022 -0400", hash_original_method = "C09C373B1A1103A4B30F4932FEFEB18D", hash_generated_method = "C9B5487697498B8F7DDBC07FAE3B8A15")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1447271298 = null; //Variable for return #1
        Parcelable superState;
        superState = super.onSaveInstanceState();
        varB4EAC82CA7396A68D541C85D26508E83_1447271298 = new SavedState(superState, mWhichChild);
        varB4EAC82CA7396A68D541C85D26508E83_1447271298.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1447271298;
        // ---------- Original Method ----------
        //Parcelable superState = super.onSaveInstanceState();
        //return new SavedState(superState, mWhichChild);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.023 -0400", hash_original_method = "A2807F1883DAD1F14A6CC088A989D676", hash_generated_method = "947790BA8DEC5667299ECB467182448B")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        addTaint(state.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.025 -0400", hash_original_method = "906CF989810621761D25CEDBF35A3122", hash_generated_method = "499C13B875FBEC7588CC59640BA517A0")
    public View getCurrentView() {
        View varB4EAC82CA7396A68D541C85D26508E83_1258652246 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1258652246 = getViewAtRelativeIndex(mActiveOffset);
        varB4EAC82CA7396A68D541C85D26508E83_1258652246.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1258652246;
        // ---------- Original Method ----------
        //return getViewAtRelativeIndex(mActiveOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.026 -0400", hash_original_method = "23AFF2D08DB63552361956C44B4439AE", hash_generated_method = "3F0AD46243A8981DD048B9A0E49DDA6F")
    public ObjectAnimator getInAnimation() {
        ObjectAnimator varB4EAC82CA7396A68D541C85D26508E83_625611150 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_625611150 = mInAnimation;
        varB4EAC82CA7396A68D541C85D26508E83_625611150.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_625611150;
        // ---------- Original Method ----------
        //return mInAnimation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.026 -0400", hash_original_method = "4E43CB38736F57C9005B93984FDB3BE2", hash_generated_method = "EA5FC0666FD015F2A1540E2A3150D3AB")
    public void setInAnimation(ObjectAnimator inAnimation) {
        mInAnimation = inAnimation;
        // ---------- Original Method ----------
        //mInAnimation = inAnimation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.037 -0400", hash_original_method = "6B0CDF48C8054A61C9B211FDE065CA93", hash_generated_method = "A5A5A8C2DDBBAE1F118B815FFB646165")
    public ObjectAnimator getOutAnimation() {
        ObjectAnimator varB4EAC82CA7396A68D541C85D26508E83_893730251 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_893730251 = mOutAnimation;
        varB4EAC82CA7396A68D541C85D26508E83_893730251.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_893730251;
        // ---------- Original Method ----------
        //return mOutAnimation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.038 -0400", hash_original_method = "1BCB8E8A3DAEDE15E6756EE2F683DC83", hash_generated_method = "C301EFF9C320600FE647D35958651477")
    public void setOutAnimation(ObjectAnimator outAnimation) {
        mOutAnimation = outAnimation;
        // ---------- Original Method ----------
        //mOutAnimation = outAnimation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.038 -0400", hash_original_method = "8F8897D1BAA8E5AE19C8237937D2CA37", hash_generated_method = "CAF47CC8C4558016170EBDDF433F2BD4")
    public void setInAnimation(Context context, int resourceID) {
        setInAnimation((ObjectAnimator) AnimatorInflater.loadAnimator(context, resourceID));
        addTaint(context.getTaint());
        addTaint(resourceID);
        // ---------- Original Method ----------
        //setInAnimation((ObjectAnimator) AnimatorInflater.loadAnimator(context, resourceID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.038 -0400", hash_original_method = "DAE8806685F393E416F20FAE75D3F12A", hash_generated_method = "985146E0215F8C3AC3E37710B2BAA9C6")
    public void setOutAnimation(Context context, int resourceID) {
        setOutAnimation((ObjectAnimator) AnimatorInflater.loadAnimator(context, resourceID));
        addTaint(context.getTaint());
        addTaint(resourceID);
        // ---------- Original Method ----------
        //setOutAnimation((ObjectAnimator) AnimatorInflater.loadAnimator(context, resourceID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.038 -0400", hash_original_method = "8FC95409534ABC48E92905DC8C518CE2", hash_generated_method = "B8F320B30FC7DD41541BCFCAA6FCA367")
    public void setAnimateFirstView(boolean animate) {
        mAnimateFirstTime = animate;
        // ---------- Original Method ----------
        //mAnimateFirstTime = animate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.043 -0400", hash_original_method = "0B91CAAE76789C8A4B2B18C9D0AAF852", hash_generated_method = "DC433B347F7B1623CDE35454E7DA53AD")
    @Override
    public int getBaseline() {
        {
            boolean var58F8C7D88FB1D1DD9A5513FB3A54B5BC_76060271 = ((getCurrentView() != null));
            Object varA7D65C03FD7AD29B41A2824896EF9900_215037970 = (getCurrentView().getBaseline());
            Object varEC5F70FA49520212A319ACA653FC0209_1172349946 = (super.getBaseline());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325700445 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325700445;
        // ---------- Original Method ----------
        //return (getCurrentView() != null) ? getCurrentView().getBaseline() : super.getBaseline();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.043 -0400", hash_original_method = "4778E83EF7DB01E18145E85F688E24B4", hash_generated_method = "B1DC4F5110259B3728813F3C6A3E482A")
    @Override
    public Adapter getAdapter() {
        Adapter varB4EAC82CA7396A68D541C85D26508E83_201228766 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_201228766 = mAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_201228766.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_201228766;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.046 -0400", hash_original_method = "8F781C0E336C7A94E2963F9C2B9D5E7F", hash_generated_method = "9201EA89D41B4A6B1C9958204AE85FE6")
    @Override
    public void setAdapter(Adapter adapter) {
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        } //End block
        mAdapter = adapter;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.047 -0400", hash_original_method = "27E899D618A9F50FEEEF08AE1A9356B2", hash_generated_method = "00BDD157183D6F02D7AE3945C3D9FCFF")
    @android.view.RemotableViewMethod
    public void setRemoteViewsAdapter(Intent intent) {
        {
            Intent.FilterComparison fcNew;
            fcNew = new Intent.FilterComparison(intent);
            Intent.FilterComparison fcOld;
            fcOld = new Intent.FilterComparison(
                    mRemoteViewsAdapter.getRemoteViewsServiceIntent());
            {
                boolean var45C20E8BCA952BA88AD2862513B06923_980122253 = (fcNew.equals(fcOld));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.231 -0400", hash_original_method = "DA18836BD93C624B14E0649B9FD256B6", hash_generated_method = "7C42918103827E95F3EE4E19188D7CD8")
    @Override
    public void setSelection(int position) {
        setDisplayedChild(position);
        addTaint(position);
        // ---------- Original Method ----------
        //setDisplayedChild(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.232 -0400", hash_original_method = "B55B55B562FC01D014E8D16B89577F15", hash_generated_method = "2B925F3DA9C27844E39F8460A2728C49")
    @Override
    public View getSelectedView() {
        View varB4EAC82CA7396A68D541C85D26508E83_383939859 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_383939859 = getViewAtRelativeIndex(mActiveOffset);
        varB4EAC82CA7396A68D541C85D26508E83_383939859.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_383939859;
        // ---------- Original Method ----------
        //return getViewAtRelativeIndex(mActiveOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.232 -0400", hash_original_method = "0410210FC7BC336B3896BEA7510AAE3D", hash_generated_method = "9D38AC80197E9738EE138974F1EA14DE")
    public void deferNotifyDataSetChanged() {
        mDeferNotifyDataSetChanged = true;
        // ---------- Original Method ----------
        //mDeferNotifyDataSetChanged = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.232 -0400", hash_original_method = "9E5375D03017C5CE595A523DBE298043", hash_generated_method = "A46E5C1355BD5F8276AF16F946E13D39")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_308652449 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_308652449;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.233 -0400", hash_original_method = "062C10606C6763A75AEC213E65863835", hash_generated_method = "64085B2EAF9EA39B9EA364A5E4CA7F63")
    public void onRemoteAdapterDisconnected() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.233 -0400", hash_original_method = "47C53466AFD69B01265302F86E539CFE", hash_generated_method = "87EFC5B96525071A3735B428531FF9C3")
    public void advance() {
        showNext();
        // ---------- Original Method ----------
        //showNext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.233 -0400", hash_original_method = "1A32686EBDFA985B54B6CF53155BB413", hash_generated_method = "AD4C3644092881C2E0FBB4399DF4389D")
    public void fyiWillBeAdvancedByHostKThx() {
        // ---------- Original Method ----------
    }

    
    class ViewAndMetaData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.233 -0400", hash_original_field = "1BDA80F2BE4D3658E0BAA43FBE7AE8C1", hash_generated_field = "203A52904F64FA8CF6CE15F1E8FE3025")

        View view;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.233 -0400", hash_original_field = "1649870BFCA992A7734977CEF67E4975", hash_generated_field = "F52544800E665053DD324CCFDCF1B6BE")

        int relativeIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.233 -0400", hash_original_field = "FEF97891E871CA6DBF8C5D0E12EFD666", hash_generated_field = "F4E75FF2D1EE9ACFE3453A0D6E862D8C")

        int adapterPosition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.233 -0400", hash_original_field = "59A814AA020A1B32C4674A5887A35022", hash_generated_field = "90EEB5AA84937AD6A8CE9746B6FECA6A")

        long itemId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.291 -0400", hash_original_method = "35BDC394C726F4932D0D464E91A92D34", hash_generated_method = "C8E3B8D5DA225BE5086B6B8C2E465CDD")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.291 -0400", hash_original_method = "AB5DEBF7CC7D6BE3A48A21837827B410", hash_generated_method = "AB5DEBF7CC7D6BE3A48A21837827B410")
        public CheckForTap ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.369 -0400", hash_original_method = "0DE0DC1F19EC8E43C86C5443C435E50A", hash_generated_method = "DBF1B507F9ABEEA968E5477FE85A6262")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.369 -0400", hash_original_field = "CE5C510735FE6790F65A3AA148FAE8B4", hash_generated_field = "522DBB163D0DA4822B2CF5511F1DEE9A")

        int whichChild;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.369 -0400", hash_original_method = "B7BF12453E93628DE35CAA34B998429F", hash_generated_method = "9F57A29B81B0BCB9C512805BB2A15AFC")
          SavedState(Parcelable superState, int whichChild) {
            super(superState);
            this.whichChild = whichChild;
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
            //this.whichChild = whichChild;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.370 -0400", hash_original_method = "392EDFCBBF619540219C8F70BEB96B16", hash_generated_method = "D17CD0B9598104FED0F460078284E1DD")
        private  SavedState(Parcel in) {
            super(in);
            this.whichChild = in.readInt();
            // ---------- Original Method ----------
            //this.whichChild = in.readInt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.370 -0400", hash_original_method = "DA40422C10B10105F9CB19E8091B3EEC", hash_generated_method = "CC664BB1E83622CF2A332F48097C5D33")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.whichChild);
            addTaint(out.getTaint());
            addTaint(flags);
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeInt(this.whichChild);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.371 -0400", hash_original_method = "808D88187ABBC8D595A46EE25C5AC5ED", hash_generated_method = "5C14ADC1913237772DC0B017D30E5CA5")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1799932709 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1799932709 = "AdapterViewAnimator.SavedState{ whichChild = " + this.whichChild + " }";
            varB4EAC82CA7396A68D541C85D26508E83_1799932709.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1799932709;
            // ---------- Original Method ----------
            //return "AdapterViewAnimator.SavedState{ whichChild = " + this.whichChild + " }";
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.371 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.371 -0400", hash_original_field = "BA38F1273922EBA69134FC12348D9DC6", hash_generated_field = "A8941907CB33225D16D6BA636F1122A4")

    private static String TAG = "RemoteViewAnimator";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.371 -0400", hash_original_field = "7DE134AF0FADA22646CB6752D5B20793", hash_generated_field = "3BE1A5F8615FBF5B2EB37BF61C97B61D")

    static int TOUCH_MODE_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.371 -0400", hash_original_field = "6C2B69311814E6B6A05889B884E5C4FF", hash_generated_field = "8B00647764899DEEDC7C9C161144EC17")

    static int TOUCH_MODE_DOWN_IN_CURRENT_VIEW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.371 -0400", hash_original_field = "4F1A03CB78BBB1B4953D9F1B19C942B4", hash_generated_field = "47358C5FF6ED2D63F228041E16A45706")

    static int TOUCH_MODE_HANDLED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.371 -0400", hash_original_field = "ECAE526882BC6D6EF1127CB35D7351D3", hash_generated_field = "253CD61D3348B871AB030C7F9EAC4EBA")

    private static int DEFAULT_ANIMATION_DURATION = 200;
}

