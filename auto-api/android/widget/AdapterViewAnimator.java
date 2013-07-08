package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "EA21F533229388AA4B2EFE079FA29356", hash_generated_field = "A4199CA8B30F98AAF67F6FDF10E09266")

    int mWhichChild = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "C0E47D0A038ADFE91661E4E5371F0BD6", hash_generated_field = "A493EB2C57153A47A21988AED08A61F9")

    private int mRestoreWhichChild = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "FDE1980A01124F9ECAD446EEE35F7267", hash_generated_field = "11022FC94DBD000AF0F23EE6D44DA07A")

    boolean mAnimateFirstTime = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "C0C9D87647F1DD58CD2938611477200B", hash_generated_field = "1CB8D73EF29501CAF0F770C194E4A275")

    int mActiveOffset = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "E46FAD00B5C2DBF29FABE10F0F93BDAB", hash_generated_field = "F89A42DD2C5934C96B97C28D423189DC")

    int mMaxNumActiveViews = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "24A5E7040AA6FFE7AE892C9904044EF6", hash_generated_field = "0CC41FBC4366667A564C06DC4F0D9357")

    HashMap<Integer, ViewAndMetaData> mViewsMap = new HashMap<Integer, ViewAndMetaData>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "AD55C52A81E04B39FEAF449A80DEC714", hash_generated_field = "DCC538958BCCC098025B00C03E72E198")

    ArrayList<Integer> mPreviousViews;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "DC605E9287B2D84952185DAA194FE524", hash_generated_field = "3A6641FE6CF608A1624B00F1DAB420F6")

    int mCurrentWindowStart = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "4859BE4C935A36901AB8D860398C0451", hash_generated_field = "F84B4803BE53A338433E57C705009CC2")

    int mCurrentWindowEnd = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "8B9C4207ECA1072C739371D6A4CB8F55", hash_generated_field = "875B8F5BD30A8973DBF780138CCA9A4B")

    int mCurrentWindowStartUnbounded = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "1AB0B744C03B78F09E9DEC3C88684ED1", hash_generated_field = "C2A92A98CA414A0C47C4CCACBB8EA2C2")

    AdapterDataSetObserver mDataSetObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "2CCFA3B9041B42EEC769AA09DF8CA535")

    Adapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "46E2FBD69946D5D63C919774CDC2709A", hash_generated_field = "6C2145BBB74854B314D98BC5E793C836")

    RemoteViewsAdapter mRemoteViewsAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "8DBD1724A62493247BCB06E14E790DDB", hash_generated_field = "D8481D38E4E063E4EC28948859294EB6")

    boolean mDeferNotifyDataSetChanged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "819CF91F91F67E3ABFDBBF304392B421", hash_generated_field = "319BF9E49F2FBE9453A9508A3A60521D")

    boolean mFirstTime = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "E9CF07B4E9DF18186772188A653F6ACD", hash_generated_field = "EE119C98E20A644961B6553C661011C0")

    boolean mLoopViews = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "EDE726180C85C86910D06D268C52F692", hash_generated_field = "A104F61DF317955825146E40FC0C3A53")

    int mReferenceChildWidth = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "BDC749679D65E3F204B9D532393B6541", hash_generated_field = "FD007F8803D65B2ABC0CC17D246ED815")

    int mReferenceChildHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "69EE9328057C3731E3E5851972F2D1BA", hash_generated_field = "C00C0EA8F9B59A998740D4241DDCA251")

    ObjectAnimator mInAnimation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "00AD3937DA6C2650F811216846F50E5C", hash_generated_field = "4FC9F8644D505DE7FB36472E6D47BDF1")

    ObjectAnimator mOutAnimation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "011DFC8310C57F40F856FB0A216752FC", hash_generated_field = "9849E22BF41E24F9EE56259FB24FEA91")

    private int mTouchMode = TOUCH_MODE_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_field = "4349FC27F2087C20272E81AADEE9392A", hash_generated_field = "C7859F448E179D513123D1E080D96FF5")

    private Runnable mPendingCheckForTap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.738 -0400", hash_original_method = "5A28C6E6B4D6383379224D19746F7CDC", hash_generated_method = "A6ED3146008CDFA5DD8DB6A1373C5F32")
    public  AdapterViewAnimator(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.739 -0400", hash_original_method = "ADD24FA1FA279C1B8387D7B0109F9EEC", hash_generated_method = "E834547F869ADF8877093E7846364F01")
    public  AdapterViewAnimator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.739 -0400", hash_original_method = "C5643612A08EABEF3EDB2D9CFA87FEC7", hash_generated_method = "6AE304E8AEB82813B29CCCEB734B97A2")
    public  AdapterViewAnimator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.AdapterViewAnimator, defStyleAttr, 0);
        int resource = a.getResourceId(
                com.android.internal.R.styleable.AdapterViewAnimator_inAnimation, 0);
        {
            setInAnimation(context, resource);
        } 
        {
            setInAnimation(getDefaultInAnimation());
        } 
        resource = a.getResourceId(com.android.internal.R.styleable.AdapterViewAnimator_outAnimation, 0);
        {
            setOutAnimation(context, resource);
        } 
        {
            setOutAnimation(getDefaultOutAnimation());
        } 
        boolean flag = a.getBoolean(
                com.android.internal.R.styleable.AdapterViewAnimator_animateFirstView, true);
        setAnimateFirstView(flag);
        mLoopViews = a.getBoolean(
                com.android.internal.R.styleable.AdapterViewAnimator_loopViews, false);
        a.recycle();
        initViewAnimator();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyleAttr);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.740 -0400", hash_original_method = "4508B464C0C2084478BE2A642B32436E", hash_generated_method = "0AEEC796AE042A1371E848170F3AEF4C")
    private void initViewAnimator() {
        mPreviousViews = new ArrayList<Integer>();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.740 -0400", hash_original_method = "91B9FA80E0031C77B528C608AC4759E5", hash_generated_method = "099EC35CF8611C5EE387FB89DF80D853")
     void configureViewAnimator(int numVisibleViews, int activeOffset) {
        mMaxNumActiveViews = numVisibleViews;
        mActiveOffset = activeOffset;
        mPreviousViews.clear();
        mViewsMap.clear();
        removeAllViewsInLayout();
        mCurrentWindowStart = 0;
        mCurrentWindowEnd = -1;
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.741 -0400", hash_original_method = "CD78C78157016071B0AA2236145765B6", hash_generated_method = "195E7C1B94309F4C1EA7ABE376969E2B")
     void transformViewForTransition(int fromIndex, int toIndex, View view, boolean animate) {
        {
            mInAnimation.setTarget(view);
            mInAnimation.start();
        } 
        {
            mOutAnimation.setTarget(view);
            mOutAnimation.start();
        } 
        addTaint(fromIndex);
        addTaint(toIndex);
        addTaint(view.getTaint());
        addTaint(animate);
        
        
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.742 -0400", hash_original_method = "1B47254A99E5F108270897DC3078BE58", hash_generated_method = "89DD00DB897902D06F37ACF7ECD01ADA")
     ObjectAnimator getDefaultInAnimation() {
        ObjectAnimator varB4EAC82CA7396A68D541C85D26508E83_1563742647 = null; 
        ObjectAnimator anim = ObjectAnimator.ofFloat(null, "alpha", 0.0f, 1.0f);
        anim.setDuration(DEFAULT_ANIMATION_DURATION);
        varB4EAC82CA7396A68D541C85D26508E83_1563742647 = anim;
        varB4EAC82CA7396A68D541C85D26508E83_1563742647.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1563742647;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.743 -0400", hash_original_method = "FB8DA060E53CA502AAAD2E0D3630FF89", hash_generated_method = "73CAC83DED04BFD6177949B40E358244")
     ObjectAnimator getDefaultOutAnimation() {
        ObjectAnimator varB4EAC82CA7396A68D541C85D26508E83_1214666937 = null; 
        ObjectAnimator anim = ObjectAnimator.ofFloat(null, "alpha", 1.0f, 0.0f);
        anim.setDuration(DEFAULT_ANIMATION_DURATION);
        varB4EAC82CA7396A68D541C85D26508E83_1214666937 = anim;
        varB4EAC82CA7396A68D541C85D26508E83_1214666937.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1214666937;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.743 -0400", hash_original_method = "C45281778BDF4A98514907509DE78D33", hash_generated_method = "86CB72FD0FA25F1C193103E9FCC8A84C")
    @android.view.RemotableViewMethod
    public void setDisplayedChild(int whichChild) {
        setDisplayedChild(whichChild, true);
        addTaint(whichChild);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.744 -0400", hash_original_method = "91CB6634BDE3355704A6B2B246DAA7A9", hash_generated_method = "E7133F6B05FE70B63D3551C2E7C73B24")
    private void setDisplayedChild(int whichChild, boolean animate) {
        {
            mWhichChild = whichChild;
            {
                boolean var4423A414EEE509E3F96136E1F46B5612_1946474133 = (whichChild >= getWindowSize());
                {
                    mWhichChild = mLoopViews ? 0 : getWindowSize() - 1;
                } 
                {
                    mWhichChild = mLoopViews ? getWindowSize() - 1 : 0;
                } 
            } 
            boolean hasFocus = getFocusedChild() != null;
            showOnly(mWhichChild, animate);
            {
                requestFocus(FOCUS_FORWARD);
            } 
        } 
        addTaint(animate);
        
        
            
            
                
            
                
            
            
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.744 -0400", hash_original_method = "A7ED1EB61B0FBCD2BEBD15D1C1303F9C", hash_generated_method = "9F5C7DAA3E2BF87BE2ACDED77873FF9E")
     void applyTransformForChildAtIndex(View child, int relativeIndex) {
        addTaint(child.getTaint());
        addTaint(relativeIndex);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.744 -0400", hash_original_method = "EEFA4D3ABF985412351A1BD0CB5D6161", hash_generated_method = "C46A817B1502E2EE908E1FBCC5363AC5")
    public int getDisplayedChild() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1695104358 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1695104358;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.744 -0400", hash_original_method = "EFCC34AA69F6F34103211EDFAD5FB56A", hash_generated_method = "EB11A1D2F0D61EF8CF5A7F00E571FA28")
    public void showNext() {
        setDisplayedChild(mWhichChild + 1);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.745 -0400", hash_original_method = "F846DD3340718784FB63764FD5BBF0F3", hash_generated_method = "A6ED72EB8F3F7302328A84241E26038A")
    public void showPrevious() {
        setDisplayedChild(mWhichChild - 1);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.745 -0400", hash_original_method = "2C561D0D9BDC240B9A5D5DE9ED7CC2E1", hash_generated_method = "05F5CAB7935FB62EAE6F97636396B049")
     int modulo(int pos, int size) {
        addTaint(pos);
        addTaint(size);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1462952158 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1462952158;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.746 -0400", hash_original_method = "FBBD82E59359C019A1CEF3EB94A89AA2", hash_generated_method = "039141FDB1BC66F8F3CC5B087EFD065A")
     View getViewAtRelativeIndex(int relativeIndex) {
        View varB4EAC82CA7396A68D541C85D26508E83_962400310 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1478900808 = null; 
        {
            boolean varDAB78BEED386DC6D5D7AAFFD9BC0EFBA_24495707 = (relativeIndex >= 0 && relativeIndex <= getNumActiveViews() - 1 && mAdapter != null);
            {
                int i = modulo(mCurrentWindowStartUnbounded + relativeIndex, getWindowSize());
                {
                    boolean var70175653C6235B3C753B7C1934966D77_31497695 = (mViewsMap.get(i) != null);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_962400310 = mViewsMap.get(i).view;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1478900808 = null;
        addTaint(relativeIndex);
        View varA7E53CE21691AB073D9660D615818899_851643595; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_851643595 = varB4EAC82CA7396A68D541C85D26508E83_962400310;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_851643595 = varB4EAC82CA7396A68D541C85D26508E83_1478900808;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_851643595.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_851643595;
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.746 -0400", hash_original_method = "0421178BBB7DE66A738CAA04F8761832", hash_generated_method = "402FD423563597BD0F072214A98CD797")
     int getNumActiveViews() {
        {
            int varE9842C7B0E064F871BFD47EBA4713105_544049200 = (Math.min(getCount() + 1, mMaxNumActiveViews));
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2022095111 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2022095111;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.746 -0400", hash_original_method = "6029719CD1CD7AB457F8E78F86AE86A1", hash_generated_method = "418CC633D7FCA4FFB8295A3E7E79D0B0")
     int getWindowSize() {
        {
            int adapterCount = getCount();
            {
                boolean varF2A5E737A41E4249CC2B5F17FAC5B9C5_1247504305 = (adapterCount <= getNumActiveViews() && mLoopViews);
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_711005598 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_711005598;
        
        
            
            
                
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.750 -0400", hash_original_method = "1D56DD893F980F245C60382C98FF1278", hash_generated_method = "5B2B70C1ECD410FE82D5AC0D801C31C7")
    private ViewAndMetaData getMetaDataForChild(View child) {
        ViewAndMetaData varB4EAC82CA7396A68D541C85D26508E83_474785871 = null; 
        ViewAndMetaData varB4EAC82CA7396A68D541C85D26508E83_832747280 = null; 
        {
            Iterator<ViewAndMetaData> var3D0147521320DBAC5B3812CCE6A51C87_1769800417 = (mViewsMap.values()).iterator();
            var3D0147521320DBAC5B3812CCE6A51C87_1769800417.hasNext();
            ViewAndMetaData vm = var3D0147521320DBAC5B3812CCE6A51C87_1769800417.next();
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_474785871 = vm;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_832747280 = null;
        addTaint(child.getTaint());
        ViewAndMetaData varA7E53CE21691AB073D9660D615818899_2010083423; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2010083423 = varB4EAC82CA7396A68D541C85D26508E83_474785871;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2010083423 = varB4EAC82CA7396A68D541C85D26508E83_832747280;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2010083423.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2010083423;
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.751 -0400", hash_original_method = "F5EC02A85B8BD647E297FF00917E7C1D", hash_generated_method = "DE765764518AB0C7828909B059571FF3")
     LayoutParams createOrReuseLayoutParams(View v) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1364203646 = null; 
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1491168363 = null; 
        final ViewGroup.LayoutParams currentLp = v.getLayoutParams();
        {
            LayoutParams lp = (LayoutParams) currentLp;
            varB4EAC82CA7396A68D541C85D26508E83_1364203646 = lp;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1491168363 = new ViewGroup.LayoutParams(0, 0);
        addTaint(v.getTaint());
        LayoutParams varA7E53CE21691AB073D9660D615818899_1087808101; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1087808101 = varB4EAC82CA7396A68D541C85D26508E83_1364203646;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1087808101 = varB4EAC82CA7396A68D541C85D26508E83_1491168363;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1087808101.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1087808101;
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.752 -0400", hash_original_method = "DEC1654E1282F99AB82BE6A9F7EE0E03", hash_generated_method = "379BDA66AA17B86A6DFC063732EB9549")
     void refreshChildren() {
        {
            int i = mCurrentWindowStart;
            {
                int index = modulo(i, getWindowSize());
                int adapterCount = getCount();
                final View updatedChild = mAdapter.getView(modulo(i, adapterCount), null, this);
                {
                    boolean varFBF83238722638C3C490302F95CE401D_112203739 = (mViewsMap.containsKey(index));
                    {
                        final FrameLayout fl = (FrameLayout) mViewsMap.get(index).view;
                        {
                            fl.removeAllViewsInLayout();
                            fl.addView(updatedChild);
                        } 
                    } 
                } 
            } 
        } 
        
        
        
            
            
            
            
                
                
                    
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.753 -0400", hash_original_method = "3A74ED5464ECC3EDCA3FF6D985E482E9", hash_generated_method = "CA2C293D76D5FF4B138B52EF0D540DE5")
     FrameLayout getFrameForChild() {
        FrameLayout varB4EAC82CA7396A68D541C85D26508E83_1607509550 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1607509550 = new FrameLayout(mContext);
        varB4EAC82CA7396A68D541C85D26508E83_1607509550.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1607509550;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.775 -0400", hash_original_method = "65797EBCBD60DE13415615382F58C13B", hash_generated_method = "EF10430A2B1A7CFEE50CBAD1322E88F5")
     void showOnly(int childIndex, boolean animate) {
        final int adapterCount = getCount();
        {
            int i = 0;
            boolean var5324A830B25BBA52B7E406685EFB4F98_639579642 = (i < mPreviousViews.size());
            {
                View viewToRemove = mViewsMap.get(mPreviousViews.get(i)).view;
                mViewsMap.remove(mPreviousViews.get(i));
                viewToRemove.clearAnimation();
                {
                    ViewGroup vg = (ViewGroup) viewToRemove;
                    vg.removeAllViewsInLayout();
                } 
                applyTransformForChildAtIndex(viewToRemove, -1);
                removeViewInLayout(viewToRemove);
            } 
        } 
        mPreviousViews.clear();
        int newWindowStartUnbounded = childIndex - mActiveOffset;
        int newWindowEndUnbounded = newWindowStartUnbounded + getNumActiveViews() - 1;
        int newWindowStart = Math.max(0, newWindowStartUnbounded);
        int newWindowEnd = Math.min(adapterCount - 1, newWindowEndUnbounded);
        {
            newWindowStart = newWindowStartUnbounded;
            newWindowEnd = newWindowEndUnbounded;
        } 
        int rangeStart = modulo(newWindowStart, getWindowSize());
        int rangeEnd = modulo(newWindowEnd, getWindowSize());
        boolean wrap = false;
        {
            wrap = true;
        } 
        {
            Iterator<Integer> var610282C9D2149B9A2642D098939F7602_112210208 = (mViewsMap.keySet()).iterator();
            var610282C9D2149B9A2642D098939F7602_112210208.hasNext();
            Integer index = var610282C9D2149B9A2642D098939F7602_112210208.next();
            {
                boolean remove = false;
                {
                    remove = true;
                } 
                {
                    remove = true;
                } 
                {
                    View previousView = mViewsMap.get(index).view;
                    int oldRelativeIndex = mViewsMap.get(index).relativeIndex;
                    mPreviousViews.add(index);
                    transformViewForTransition(oldRelativeIndex, -1, previousView, animate);
                } 
            } 
        } 
        {
            {
                int i = newWindowStart;
                {
                    int index = modulo(i, getWindowSize());
                    int oldRelativeIndex;
                    {
                        boolean var41FB02AF47D0FFCEDE206EC611FE70C8_526129657 = (mViewsMap.containsKey(index));
                        {
                            oldRelativeIndex = mViewsMap.get(index).relativeIndex;
                        } 
                        {
                            oldRelativeIndex = -1;
                        } 
                    } 
                    int newRelativeIndex = i - newWindowStartUnbounded;
                    boolean inOldRange = mViewsMap.containsKey(index) && !mPreviousViews.contains(index);
                    {
                        View view = mViewsMap.get(index).view;
                        mViewsMap.get(index).relativeIndex = newRelativeIndex;
                        applyTransformForChildAtIndex(view, newRelativeIndex);
                        transformViewForTransition(oldRelativeIndex, newRelativeIndex, view, animate);
                    } 
                    {
                        final int adapterPosition = modulo(i, adapterCount);
                        View newView = mAdapter.getView(adapterPosition, null, this);
                        long itemId = mAdapter.getItemId(adapterPosition);
                        FrameLayout fl = getFrameForChild();
                        {
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
            } 
            mCurrentWindowStart = newWindowStart;
            mCurrentWindowEnd = newWindowEnd;
            mCurrentWindowStartUnbounded = newWindowStartUnbounded;
        } 
        requestLayout();
        invalidate();
        addTaint(childIndex);
        addTaint(animate);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.776 -0400", hash_original_method = "CF7E9270D6A781D39501E4BBAEBB3A13", hash_generated_method = "1DF52A8CC559FE180B7BB6E01F8611F7")
    private void addChild(View child) {
        addViewInLayout(child, -1, createOrReuseLayoutParams(child));
        {
            int measureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            child.measure(measureSpec, measureSpec);
            mReferenceChildWidth = child.getMeasuredWidth();
            mReferenceChildHeight = child.getMeasuredHeight();
        } 
        
        
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.776 -0400", hash_original_method = "2ABC3404C13E4A800F47D0C635B72929", hash_generated_method = "722C84CA0E95451E2D212D051A07749E")
     void showTapFeedback(View v) {
        v.setPressed(true);
        addTaint(v.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.776 -0400", hash_original_method = "AB8C1F9AF8BDC4DF902FB7F7CD728C3A", hash_generated_method = "0D7E102632C88AC04810A68A5118DAA7")
     void hideTapFeedback(View v) {
        v.setPressed(false);
        addTaint(v.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.777 -0400", hash_original_method = "67399547287D8F71A7A5AE67A071254C", hash_generated_method = "56C580D3310C19FF0BA9FF6ACC175DBD")
     void cancelHandleClick() {
        View v = getCurrentView();
        {
            hideTapFeedback(v);
        } 
        mTouchMode = TOUCH_MODE_NONE;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.778 -0400", hash_original_method = "A2B685172F5BE99872ECD239B8E084E5", hash_generated_method = "EDAE82B984D95CDC858CAF4E30B6E99D")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        
        int action = ev.getAction();
        boolean handled = false;
        
        {
            View v = getCurrentView();
            {
                {
                    boolean varBC775EA6D0A73186451B4F7D426A7D5F_1778763254 = (isTransformedTouchPointInView(ev.getX(), ev.getY(), v, null));
                    {
                        {
                            mPendingCheckForTap = new CheckForTap();
                        } 
                        mTouchMode = TOUCH_MODE_DOWN_IN_CURRENT_VIEW;
                        postDelayed(mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                    } 
                } 
            } 
        } 
        
        
        {
            {
                final View v = getCurrentView();
                final ViewAndMetaData viewData = getMetaDataForChild(v);
                {
                    {
                        boolean var39EF9DE1D8B67B073EBB22788CA51268_900405110 = (isTransformedTouchPointInView(ev.getX(), ev.getY(), v, null));
                        {
                            final Handler handler = getHandler();
                            {
                                handler.removeCallbacks(mPendingCheckForTap);
                            } 
                            showTapFeedback(v);
                            postDelayed(new Runnable() {                                
                                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.778 -0400", hash_original_method = "514935A2E7728F849473B37374E9557E", hash_generated_method = "D7F73D5A566A45A62C5BC175C84FCC1F")
                                public void run() {
                                    hideTapFeedback(v);
                                    post(new Runnable() {                                        
                                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.778 -0400", hash_original_method = "42524E48826E836CBD16722378FBDC75", hash_generated_method = "C1A91307072BB396065B4A9D1506B9FB")
                                        public void run() {
                                            {
                                                performItemClick(v, viewData.adapterPosition,
                                                        viewData.itemId);
                                            } 
                                            {
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
            } 
            mTouchMode = TOUCH_MODE_NONE;
        } 
        
        
        {
            View v = getCurrentView();
            {
                hideTapFeedback(v);
            } 
            mTouchMode = TOUCH_MODE_NONE;
        } 
        
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_643246132 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_643246132;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.779 -0400", hash_original_method = "CF7CC5DB55CCFC095F8C480C67A97670", hash_generated_method = "861A547720E92BA148A4F8B002647DDB")
    private void measureChildren() {
        final int count = getChildCount();
        final int childWidth = getMeasuredWidth() - mPaddingLeft - mPaddingRight;
        final int childHeight = getMeasuredHeight() - mPaddingTop - mPaddingBottom;
        {
            int i = 0;
            {
                final View child = getChildAt(i);
                child.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY));
            } 
        } 
        
        
        
        
        
            
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.780 -0400", hash_original_method = "B8DC8FCB5714B92F7D9B397FCC5E6B1D", hash_generated_method = "21339F5856B18D6D9CCC7A63B4DC2542")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        final int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        boolean haveChildRefSize = (mReferenceChildWidth != -1 && mReferenceChildHeight != -1);
        {
            heightSpecSize = haveChildRefSize ? mReferenceChildHeight + mPaddingTop +
                    mPaddingBottom : 0;
        } 
        {
            {
                int height = mReferenceChildHeight + mPaddingTop + mPaddingBottom;
                {
                    heightSpecSize |= MEASURED_STATE_TOO_SMALL;
                } 
                {
                    heightSpecSize = height;
                } 
            } 
        } 
        {
            widthSpecSize = haveChildRefSize ? mReferenceChildWidth + mPaddingLeft +
                    mPaddingRight : 0;
        } 
        {
            {
                int width = mReferenceChildWidth + mPaddingLeft + mPaddingRight;
                {
                    widthSpecSize |= MEASURED_STATE_TOO_SMALL;
                } 
                {
                    widthSpecSize = width;
                } 
            } 
        } 
        setMeasuredDimension(widthSpecSize, heightSpecSize);
        measureChildren();
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.781 -0400", hash_original_method = "F3EF4D3CC56F2B38758DB6D9F3299660", hash_generated_method = "DEAB20BC1E57280C8E2289756E80A859")
     void checkForAndHandleDataChanged() {
        boolean dataChanged = mDataChanged;
        {
            post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.781 -0400", hash_original_method = "15BF43057866669BD34B56F96081697B", hash_generated_method = "91C2558D5B4FB881A7E48A97840C2F49")
                public void run() {
                    handleDataChanged();
                    {
                        boolean var91476E53455DDBED1C2497762140CD5A_2134243194 = (mWhichChild >= getWindowSize());
                        {
                            mWhichChild = 0;
                            showOnly(mWhichChild, false);
                        } 
                        {
                            boolean var9A54785035833875439C9F0D8D389EC7_815926408 = (mOldItemCount != getCount());
                            {
                                showOnly(mWhichChild, false);
                            } 
                        } 
                    } 
                    refreshChildren();
                    requestLayout();
                    
                    
                    
                        
                        
                    
                        
                    
                    
                    
                }
});
        } 
        mDataChanged = false;
        
        
        
            
                
                    
                    
                        
                        
                    
                        
                    
                    
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.782 -0400", hash_original_method = "BFF47184DAE09EA9D82185EB27DBF22D", hash_generated_method = "C16D29443711746007F38AF398D9723D")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        
        checkForAndHandleDataChanged();
        final int childCount = getChildCount();
        {
            int i = 0;
            {
                final View child = getChildAt(i);
                int childRight = mPaddingLeft + child.getMeasuredWidth();
                int childBottom = mPaddingTop + child.getMeasuredHeight();
                child.layout(mPaddingLeft, mPaddingTop, childRight, childBottom);
            } 
        } 
        addTaint(changed);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        
        
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.783 -0400", hash_original_method = "C09C373B1A1103A4B30F4932FEFEB18D", hash_generated_method = "F8F394959C6C9222F9798D2515EC5A4C")
    @Override
    public Parcelable onSaveInstanceState() {
        
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_919936337 = null; 
        Parcelable superState = super.onSaveInstanceState();
        varB4EAC82CA7396A68D541C85D26508E83_919936337 = new SavedState(superState, mWhichChild);
        varB4EAC82CA7396A68D541C85D26508E83_919936337.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_919936337;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.783 -0400", hash_original_method = "A2807F1883DAD1F14A6CC088A989D676", hash_generated_method = "DA0CD88694F8BD2E5C500DAD827510A5")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        mWhichChild = ss.whichChild;
        {
            mRestoreWhichChild = mWhichChild;
        } 
        {
            setDisplayedChild(mWhichChild, false);
        } 
        addTaint(state.getTaint());
        
        
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.783 -0400", hash_original_method = "906CF989810621761D25CEDBF35A3122", hash_generated_method = "272F70ED96D1C37885C83F9EF6077564")
    public View getCurrentView() {
        View varB4EAC82CA7396A68D541C85D26508E83_1880031733 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1880031733 = getViewAtRelativeIndex(mActiveOffset);
        varB4EAC82CA7396A68D541C85D26508E83_1880031733.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1880031733;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.784 -0400", hash_original_method = "23AFF2D08DB63552361956C44B4439AE", hash_generated_method = "1D033D1DC2888F9723E3C1BCEB6A2469")
    public ObjectAnimator getInAnimation() {
        ObjectAnimator varB4EAC82CA7396A68D541C85D26508E83_428334702 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_428334702 = mInAnimation;
        varB4EAC82CA7396A68D541C85D26508E83_428334702.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_428334702;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.784 -0400", hash_original_method = "4E43CB38736F57C9005B93984FDB3BE2", hash_generated_method = "EA5FC0666FD015F2A1540E2A3150D3AB")
    public void setInAnimation(ObjectAnimator inAnimation) {
        mInAnimation = inAnimation;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.785 -0400", hash_original_method = "6B0CDF48C8054A61C9B211FDE065CA93", hash_generated_method = "1E67BDF99D79C214019339967487CC92")
    public ObjectAnimator getOutAnimation() {
        ObjectAnimator varB4EAC82CA7396A68D541C85D26508E83_32807768 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_32807768 = mOutAnimation;
        varB4EAC82CA7396A68D541C85D26508E83_32807768.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_32807768;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.785 -0400", hash_original_method = "1BCB8E8A3DAEDE15E6756EE2F683DC83", hash_generated_method = "C301EFF9C320600FE647D35958651477")
    public void setOutAnimation(ObjectAnimator outAnimation) {
        mOutAnimation = outAnimation;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.785 -0400", hash_original_method = "8F8897D1BAA8E5AE19C8237937D2CA37", hash_generated_method = "CAF47CC8C4558016170EBDDF433F2BD4")
    public void setInAnimation(Context context, int resourceID) {
        setInAnimation((ObjectAnimator) AnimatorInflater.loadAnimator(context, resourceID));
        addTaint(context.getTaint());
        addTaint(resourceID);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.785 -0400", hash_original_method = "DAE8806685F393E416F20FAE75D3F12A", hash_generated_method = "985146E0215F8C3AC3E37710B2BAA9C6")
    public void setOutAnimation(Context context, int resourceID) {
        setOutAnimation((ObjectAnimator) AnimatorInflater.loadAnimator(context, resourceID));
        addTaint(context.getTaint());
        addTaint(resourceID);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.786 -0400", hash_original_method = "8FC95409534ABC48E92905DC8C518CE2", hash_generated_method = "B8F320B30FC7DD41541BCFCAA6FCA367")
    public void setAnimateFirstView(boolean animate) {
        mAnimateFirstTime = animate;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.786 -0400", hash_original_method = "0B91CAAE76789C8A4B2B18C9D0AAF852", hash_generated_method = "31CF00D7199E3E35E3F8644BED923E68")
    @Override
    public int getBaseline() {
        {
            boolean var58F8C7D88FB1D1DD9A5513FB3A54B5BC_1518934689 = ((getCurrentView() != null));
            Object varA7D65C03FD7AD29B41A2824896EF9900_960890332 = (getCurrentView().getBaseline());
            Object varEC5F70FA49520212A319ACA653FC0209_1840511194 = (super.getBaseline());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1685135230 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1685135230;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.786 -0400", hash_original_method = "4778E83EF7DB01E18145E85F688E24B4", hash_generated_method = "3BB98781901640FD6294EE33711DDF33")
    @Override
    public Adapter getAdapter() {
        Adapter varB4EAC82CA7396A68D541C85D26508E83_161797833 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_161797833 = mAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_161797833.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_161797833;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.787 -0400", hash_original_method = "8F781C0E336C7A94E2963F9C2B9D5E7F", hash_generated_method = "9201EA89D41B4A6B1C9958204AE85FE6")
    @Override
    public void setAdapter(Adapter adapter) {
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        } 
        mAdapter = adapter;
        checkFocus();
        {
            mDataSetObserver = new AdapterDataSetObserver();
            mAdapter.registerDataSetObserver(mDataSetObserver);
            mItemCount = mAdapter.getCount();
        } 
        setFocusable(true);
        mWhichChild = 0;
        showOnly(mWhichChild, false);
        
        
            
        
        
        
        
            
            
            
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.787 -0400", hash_original_method = "27E899D618A9F50FEEEF08AE1A9356B2", hash_generated_method = "4978C6296E36A8A42F09E019461656FD")
    @android.view.RemotableViewMethod
    public void setRemoteViewsAdapter(Intent intent) {
        {
            Intent.FilterComparison fcNew = new Intent.FilterComparison(intent);
            Intent.FilterComparison fcOld = new Intent.FilterComparison(
                    mRemoteViewsAdapter.getRemoteViewsServiceIntent());
            {
                boolean var45C20E8BCA952BA88AD2862513B06923_1591343518 = (fcNew.equals(fcOld));
            } 
        } 
        mDeferNotifyDataSetChanged = false;
        mRemoteViewsAdapter = new RemoteViewsAdapter(getContext(), intent, this);
        
        
            
            
                    
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.788 -0400", hash_original_method = "DA18836BD93C624B14E0649B9FD256B6", hash_generated_method = "7C42918103827E95F3EE4E19188D7CD8")
    @Override
    public void setSelection(int position) {
        setDisplayedChild(position);
        addTaint(position);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.788 -0400", hash_original_method = "B55B55B562FC01D014E8D16B89577F15", hash_generated_method = "757ABADF37FB3FCDF6C636C9C13D4882")
    @Override
    public View getSelectedView() {
        View varB4EAC82CA7396A68D541C85D26508E83_1079836709 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1079836709 = getViewAtRelativeIndex(mActiveOffset);
        varB4EAC82CA7396A68D541C85D26508E83_1079836709.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1079836709;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.789 -0400", hash_original_method = "0410210FC7BC336B3896BEA7510AAE3D", hash_generated_method = "9D38AC80197E9738EE138974F1EA14DE")
    public void deferNotifyDataSetChanged() {
        mDeferNotifyDataSetChanged = true;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.789 -0400", hash_original_method = "9E5375D03017C5CE595A523DBE298043", hash_generated_method = "53373B60F63A8BBC1B557D02AE27224A")
    public boolean onRemoteAdapterConnected() {
        
        {
            setAdapter(mRemoteViewsAdapter);
            {
                mRemoteViewsAdapter.notifyDataSetChanged();
                mDeferNotifyDataSetChanged = false;
            } 
            {
                setDisplayedChild(mRestoreWhichChild, false);
                mRestoreWhichChild = -1;
            } 
        } 
        {
            mRemoteViewsAdapter.superNotifyDataSetChanged();
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1792420754 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1792420754;
        
        
            
            
                
                
            
            
                
                
            
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.790 -0400", hash_original_method = "062C10606C6763A75AEC213E65863835", hash_generated_method = "64085B2EAF9EA39B9EA364A5E4CA7F63")
    public void onRemoteAdapterDisconnected() {
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.790 -0400", hash_original_method = "47C53466AFD69B01265302F86E539CFE", hash_generated_method = "87EFC5B96525071A3735B428531FF9C3")
    public void advance() {
        showNext();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.791 -0400", hash_original_method = "1A32686EBDFA985B54B6CF53155BB413", hash_generated_method = "AD4C3644092881C2E0FBB4399DF4389D")
    public void fyiWillBeAdvancedByHostKThx() {
        
    }

    
    class ViewAndMetaData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.791 -0400", hash_original_field = "1BDA80F2BE4D3658E0BAA43FBE7AE8C1", hash_generated_field = "203A52904F64FA8CF6CE15F1E8FE3025")

        View view;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.791 -0400", hash_original_field = "1649870BFCA992A7734977CEF67E4975", hash_generated_field = "F52544800E665053DD324CCFDCF1B6BE")

        int relativeIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.791 -0400", hash_original_field = "FEF97891E871CA6DBF8C5D0E12EFD666", hash_generated_field = "F4E75FF2D1EE9ACFE3453A0D6E862D8C")

        int adapterPosition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.791 -0400", hash_original_field = "59A814AA020A1B32C4674A5887A35022", hash_generated_field = "90EEB5AA84937AD6A8CE9746B6FECA6A")

        long itemId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.792 -0400", hash_original_method = "35BDC394C726F4932D0D464E91A92D34", hash_generated_method = "C8E3B8D5DA225BE5086B6B8C2E465CDD")
          ViewAndMetaData(View view, int relativeIndex, int adapterPosition, long itemId) {
            this.view = view;
            this.relativeIndex = relativeIndex;
            this.adapterPosition = adapterPosition;
            this.itemId = itemId;
            
            
            
            
            
        }

        
    }


    
    final class CheckForTap implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.792 -0400", hash_original_method = "AB5DEBF7CC7D6BE3A48A21837827B410", hash_generated_method = "AB5DEBF7CC7D6BE3A48A21837827B410")
        public CheckForTap ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.793 -0400", hash_original_method = "0DE0DC1F19EC8E43C86C5443C435E50A", hash_generated_method = "B9341239BB59A2DE6B12620084530D6C")
        public void run() {
            {
                View v = getCurrentView();
                showTapFeedback(v);
            } 
            
            
                
                
            
        }

        
    }


    
    static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.793 -0400", hash_original_field = "CE5C510735FE6790F65A3AA148FAE8B4", hash_generated_field = "522DBB163D0DA4822B2CF5511F1DEE9A")

        int whichChild;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.793 -0400", hash_original_method = "B7BF12453E93628DE35CAA34B998429F", hash_generated_method = "9F57A29B81B0BCB9C512805BB2A15AFC")
          SavedState(Parcelable superState, int whichChild) {
            super(superState);
            this.whichChild = whichChild;
            addTaint(superState.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.793 -0400", hash_original_method = "392EDFCBBF619540219C8F70BEB96B16", hash_generated_method = "D17CD0B9598104FED0F460078284E1DD")
        private  SavedState(Parcel in) {
            super(in);
            this.whichChild = in.readInt();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.794 -0400", hash_original_method = "DA40422C10B10105F9CB19E8091B3EEC", hash_generated_method = "CC664BB1E83622CF2A332F48097C5D33")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.whichChild);
            addTaint(out.getTaint());
            addTaint(flags);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.794 -0400", hash_original_method = "808D88187ABBC8D595A46EE25C5AC5ED", hash_generated_method = "528312AC0EAC62015B4E1697C918F6DA")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_273414930 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_273414930 = "AdapterViewAnimator.SavedState{ whichChild = " + this.whichChild + " }";
            varB4EAC82CA7396A68D541C85D26508E83_273414930.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_273414930;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.794 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.794 -0400", hash_original_field = "BA38F1273922EBA69134FC12348D9DC6", hash_generated_field = "3A652617CCF7727670B8485C49C1574A")

    private static final String TAG = "RemoteViewAnimator";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.794 -0400", hash_original_field = "7DE134AF0FADA22646CB6752D5B20793", hash_generated_field = "94E9E36D497ACD2451DC65DFC34FDE84")

    static final int TOUCH_MODE_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.794 -0400", hash_original_field = "6C2B69311814E6B6A05889B884E5C4FF", hash_generated_field = "016189EFF611A0FE1D4693C1CCBDA407")

    static final int TOUCH_MODE_DOWN_IN_CURRENT_VIEW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.794 -0400", hash_original_field = "4F1A03CB78BBB1B4953D9F1B19C942B4", hash_generated_field = "7488778163D886E6949F033B92DE547C")

    static final int TOUCH_MODE_HANDLED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.794 -0400", hash_original_field = "ECAE526882BC6D6EF1127CB35D7351D3", hash_generated_field = "F6CDC47961A92F3B929B6B11861E0C14")

    private static final int DEFAULT_ANIMATION_DURATION = 200;
}

