package android.widget;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.List;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;





public class HorizontalScrollView extends FrameLayout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.024 -0400", hash_original_field = "380EFAD062415C5D611446C1B15B307D", hash_generated_field = "507FF60BF6AED501221786F4F9B1C4CE")

    private long mLastScroll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.024 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

    private final Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.025 -0400", hash_original_field = "360DD66618E954525BEA0D65B05DC7EC", hash_generated_field = "7106C69F4E49AB9D7F59F38965DF6036")

    private OverScroller mScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.025 -0400", hash_original_field = "ACEBD86C89C68033BA00F1E22D2FC23B", hash_generated_field = "CF32CFBB2A976E850EE8DDE803F384D7")

    private EdgeEffect mEdgeGlowLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.025 -0400", hash_original_field = "876C7C33DE6802509886BB6ADFFE041C", hash_generated_field = "304A2CBEA7C331CEDE170973F40765C0")

    private EdgeEffect mEdgeGlowRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.025 -0400", hash_original_field = "4F6DEDF0BA2D99325BDAE4A27C301E0B", hash_generated_field = "90F53F7625CC0EEE4DC6EBCFF5E518A6")

    private float mLastMotionX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.025 -0400", hash_original_field = "A43EC71B2E74CACC223B47379717A080", hash_generated_field = "9C16E67A6EDB3E799E01AFB02BCF7815")

    private boolean mIsLayoutDirty = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.025 -0400", hash_original_field = "8949A253727FAE7FB577F98D2A9463C2", hash_generated_field = "7E1EAB0DC4AB4B81BAB22B01D588949E")

    private View mChildToScrollTo = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.025 -0400", hash_original_field = "A8AB6008485C6E787B3DBB97D2050FF4", hash_generated_field = "40AA109CDE3739730D8C499D23D26FF1")

    private boolean mIsBeingDragged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.025 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.025 -0400", hash_original_field = "B3E3E62AA85A925921DCB2869A4E7017", hash_generated_field = "16DDF79C39D64DD0F8B72040D2242A75")

    @ViewDebug.ExportedProperty(category = "layout") private boolean mFillViewport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.025 -0400", hash_original_field = "581BD96ACB5FC0F4F529183E58EA63B2", hash_generated_field = "EA3AE5CC17F6060C1DBAA2AAAFFFC35C")

    private boolean mSmoothScrollingEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.025 -0400", hash_original_field = "3DFFFAD10926598D18EEC50D61DE79CA", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.025 -0400", hash_original_field = "30B0DF23DBDF2426D66E4D98494C369B", hash_generated_field = "7DBE1A18599B8760DC9B67AAFE3499E3")

    private int mMinimumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.025 -0400", hash_original_field = "1C66D9179508D091F8E90C9FEBAD15CA", hash_generated_field = "6F997413D0B227487940C402EB78A8FD")

    private int mMaximumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.025 -0400", hash_original_field = "7A5B6F76BA72A8D6AFCFCEA14B8C2556", hash_generated_field = "7B0107E1CAE9FFC281D766335539D7C4")

    private int mOverscrollDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.025 -0400", hash_original_field = "755491871A4FCE3E01181030F8FEB178", hash_generated_field = "06022A8A798B4C892D35D0FFB16D2FDF")

    private int mOverflingDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.025 -0400", hash_original_field = "D0F34CC6DB83FC46AEC38F19CA5CE138", hash_generated_field = "1B464B20D80463EC30779F63AB0559BD")

    private int mActivePointerId = INVALID_POINTER;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.026 -0400", hash_original_method = "D579CCE5E39252987369F5EF7BC67FC0", hash_generated_method = "14051F04924CFB33DDABF2912876D78F")
    public  HorizontalScrollView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.026 -0400", hash_original_method = "7F7EA51B0CF52F1D171B225CFAE9439C", hash_generated_method = "5DD8D3112CC9437FFA1029FAC50BB5E5")
    public  HorizontalScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.horizontalScrollViewStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.026 -0400", hash_original_method = "ABF3CE2040AE9A0702C38DF91EEF10E7", hash_generated_method = "120D1237A739744E6399B506AE3126CF")
    public  HorizontalScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        initScrollView();
        TypedArray a = context.obtainStyledAttributes(attrs,
                android.R.styleable.HorizontalScrollView, defStyle, 0);
        setFillViewport(a.getBoolean(android.R.styleable.HorizontalScrollView_fillViewport, false));
        a.recycle();
        // ---------- Original Method ----------
        //initScrollView();
        //TypedArray a = context.obtainStyledAttributes(attrs,
                //android.R.styleable.HorizontalScrollView, defStyle, 0);
        //setFillViewport(a.getBoolean(android.R.styleable.HorizontalScrollView_fillViewport, false));
        //a.recycle();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.027 -0400", hash_original_method = "041555434146A9B8485461655BD1A318", hash_generated_method = "C70EA56E5352B48710DAC9479A54268D")
    @Override
    protected float getLeftFadingEdgeStrength() {
        if(getChildCount() == 0)        
        {
            float var2C64466C1DFC5FC617E8E7707C276CC3_1871374659 = (0.0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_108215613 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_108215613;
        } //End block
        final int length = getHorizontalFadingEdgeLength();
        if(mScrollX < length)        
        {
            float varE6986454617065CD04CBD0B907EE353C_321212397 = (mScrollX / (float) length);
                        float var546ADE640B6EDFBC8A086EF31347E768_1143852906 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1143852906;
        } //End block
        float varCFE70293CC98B68AC513E2798BAD793D_125096154 = (1.0f);
                float var546ADE640B6EDFBC8A086EF31347E768_842161687 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_842161687;
        // ---------- Original Method ----------
        //if (getChildCount() == 0) {
            //return 0.0f;
        //}
        //final int length = getHorizontalFadingEdgeLength();
        //if (mScrollX < length) {
            //return mScrollX / (float) length;
        //}
        //return 1.0f;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.027 -0400", hash_original_method = "AC1CCEB780F155A105BA88465002385B", hash_generated_method = "9F06EB2DF52A406B928AFE7E1634937E")
    @Override
    protected float getRightFadingEdgeStrength() {
        if(getChildCount() == 0)        
        {
            float var2C64466C1DFC5FC617E8E7707C276CC3_1873282050 = (0.0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_1149322389 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1149322389;
        } //End block
        final int length = getHorizontalFadingEdgeLength();
        final int rightEdge = getWidth() - mPaddingRight;
        final int span = getChildAt(0).getRight() - mScrollX - rightEdge;
        if(span < length)        
        {
            float var941A690C6CFF230827FF210C6B3392A9_931015926 = (span / (float) length);
                        float var546ADE640B6EDFBC8A086EF31347E768_86776229 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_86776229;
        } //End block
        float varCFE70293CC98B68AC513E2798BAD793D_939147196 = (1.0f);
                float var546ADE640B6EDFBC8A086EF31347E768_996018833 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_996018833;
        // ---------- Original Method ----------
        //if (getChildCount() == 0) {
            //return 0.0f;
        //}
        //final int length = getHorizontalFadingEdgeLength();
        //final int rightEdge = getWidth() - mPaddingRight;
        //final int span = getChildAt(0).getRight() - mScrollX - rightEdge;
        //if (span < length) {
            //return span / (float) length;
        //}
        //return 1.0f;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.027 -0400", hash_original_method = "F72D9B4700B8FCB550AB26E9792E603C", hash_generated_method = "1ABC689584C6E87D5D94EC97BF71D812")
    public int getMaxScrollAmount() {
        int var3811E0A0C3B22AE8514C2309C41B7802_501763196 = ((int) (MAX_SCROLL_FACTOR * (mRight - mLeft)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1434206221 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1434206221;
        // ---------- Original Method ----------
        //return (int) (MAX_SCROLL_FACTOR * (mRight - mLeft));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.028 -0400", hash_original_method = "02BBAF53D85E267FB240E2D4309C877F", hash_generated_method = "02BFF61AA3D9E1FA9C55929FA1EDF318")
    private void initScrollView() {
        mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
        setWillNotDraw(false);
        final ViewConfiguration configuration = ViewConfiguration.get(mContext);
        mTouchSlop = configuration.getScaledTouchSlop();
        mMinimumVelocity = configuration.getScaledMinimumFlingVelocity();
        mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
        mOverscrollDistance = configuration.getScaledOverscrollDistance();
        mOverflingDistance = configuration.getScaledOverflingDistance();
        // ---------- Original Method ----------
        //mScroller = new OverScroller(getContext());
        //setFocusable(true);
        //setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
        //setWillNotDraw(false);
        //final ViewConfiguration configuration = ViewConfiguration.get(mContext);
        //mTouchSlop = configuration.getScaledTouchSlop();
        //mMinimumVelocity = configuration.getScaledMinimumFlingVelocity();
        //mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
        //mOverscrollDistance = configuration.getScaledOverscrollDistance();
        //mOverflingDistance = configuration.getScaledOverflingDistance();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.029 -0400", hash_original_method = "28BB619967A3B168E514D899D7C1C204", hash_generated_method = "DD1439F4C4BD7AE5F4304FB790A45B3B")
    @Override
    public void addView(View child) {
        addTaint(child.getTaint());
        if(getChildCount() > 0)        
        {
            IllegalStateException var05A10724DF5EE1DED9BB2CB05480822D_340641255 = new IllegalStateException("HorizontalScrollView can host only one direct child");
            var05A10724DF5EE1DED9BB2CB05480822D_340641255.addTaint(taint);
            throw var05A10724DF5EE1DED9BB2CB05480822D_340641255;
        } //End block
        super.addView(child);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        //}
        //super.addView(child);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.029 -0400", hash_original_method = "D082E00953E9B886F1BBE563E072EA76", hash_generated_method = "D1889CD05F521B3EDF413B5E080AD3F1")
    @Override
    public void addView(View child, int index) {
        addTaint(index);
        addTaint(child.getTaint());
        if(getChildCount() > 0)        
        {
            IllegalStateException var05A10724DF5EE1DED9BB2CB05480822D_1850653704 = new IllegalStateException("HorizontalScrollView can host only one direct child");
            var05A10724DF5EE1DED9BB2CB05480822D_1850653704.addTaint(taint);
            throw var05A10724DF5EE1DED9BB2CB05480822D_1850653704;
        } //End block
        super.addView(child, index);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        //}
        //super.addView(child, index);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.030 -0400", hash_original_method = "35F41E1C04BFB475A60C431B3898F857", hash_generated_method = "C2D6149FA08252853148D22BF6AEE639")
    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(child.getTaint());
        if(getChildCount() > 0)        
        {
            IllegalStateException var05A10724DF5EE1DED9BB2CB05480822D_2081762678 = new IllegalStateException("HorizontalScrollView can host only one direct child");
            var05A10724DF5EE1DED9BB2CB05480822D_2081762678.addTaint(taint);
            throw var05A10724DF5EE1DED9BB2CB05480822D_2081762678;
        } //End block
        super.addView(child, params);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        //}
        //super.addView(child, params);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.030 -0400", hash_original_method = "D331A2B6162E307FE1F025F2ABEA7C28", hash_generated_method = "72CBF43AB3860EE548C276F45F424116")
    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(index);
        addTaint(child.getTaint());
        if(getChildCount() > 0)        
        {
            IllegalStateException var05A10724DF5EE1DED9BB2CB05480822D_962497894 = new IllegalStateException("HorizontalScrollView can host only one direct child");
            var05A10724DF5EE1DED9BB2CB05480822D_962497894.addTaint(taint);
            throw var05A10724DF5EE1DED9BB2CB05480822D_962497894;
        } //End block
        super.addView(child, index, params);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        //}
        //super.addView(child, index, params);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.030 -0400", hash_original_method = "3DE53F922B0BEA48963A7A11A88BC712", hash_generated_method = "E87F59BE260A474256EF66875466193A")
    private boolean canScroll() {
        View child = getChildAt(0);
        if(child != null)        
        {
            int childWidth = child.getWidth();
            boolean varADCB9BFDAE39B6778BB46AAB32CB64ED_125528166 = (getWidth() < childWidth + mPaddingLeft + mPaddingRight);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1402456946 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1402456946;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_771030560 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1496342244 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1496342244;
        // ---------- Original Method ----------
        //View child = getChildAt(0);
        //if (child != null) {
            //int childWidth = child.getWidth();
            //return getWidth() < childWidth + mPaddingLeft + mPaddingRight ;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.031 -0400", hash_original_method = "801E6F065AC6A60CFB0DADB1E074F98E", hash_generated_method = "CFBD9F09EBB4644E64098A271F3D1082")
    public boolean isFillViewport() {
        boolean varB3E3E62AA85A925921DCB2869A4E7017_291223945 = (mFillViewport);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_721566970 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_721566970;
        // ---------- Original Method ----------
        //return mFillViewport;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.031 -0400", hash_original_method = "D2588C7F74D0E18DF5DFA629FE7BF270", hash_generated_method = "F2E2A5C18232B8609B837CA278719D40")
    public void setFillViewport(boolean fillViewport) {
        if(fillViewport != mFillViewport)        
        {
            mFillViewport = fillViewport;
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (fillViewport != mFillViewport) {
            //mFillViewport = fillViewport;
            //requestLayout();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.031 -0400", hash_original_method = "D26C58327C0CB18AC1F62B7629FD16B1", hash_generated_method = "F47B71BE7098085624C82DF54D856B83")
    public boolean isSmoothScrollingEnabled() {
        boolean var15B603515FEC15F2893A41D962B8656B_119475025 = (mSmoothScrollingEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1268896749 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1268896749;
        // ---------- Original Method ----------
        //return mSmoothScrollingEnabled;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.032 -0400", hash_original_method = "63C96CE84D9CD60CA1FF4EF87D7FF4F5", hash_generated_method = "5C7F23BB3E765786BEE5D256B048D32A")
    public void setSmoothScrollingEnabled(boolean smoothScrollingEnabled) {
        mSmoothScrollingEnabled = smoothScrollingEnabled;
        // ---------- Original Method ----------
        //mSmoothScrollingEnabled = smoothScrollingEnabled;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.032 -0400", hash_original_method = "1306D2831DF4DA9A5EDAD3DA6127274D", hash_generated_method = "EE512012F00EA80710F870D8C0240B91")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if(!mFillViewport)        
        {
            return;
        } //End block
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        if(widthMode == MeasureSpec.UNSPECIFIED)        
        {
            return;
        } //End block
        if(getChildCount() > 0)        
        {
            final View child = getChildAt(0);
            int width = getMeasuredWidth();
            if(child.getMeasuredWidth() < width)            
            {
                final FrameLayout.LayoutParams lp = (LayoutParams) child.getLayoutParams();
                int childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, mPaddingTop
                        + mPaddingBottom, lp.height);
                width -= mPaddingLeft;
                width -= mPaddingRight;
                int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
                child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.032 -0400", hash_original_method = "40D3C8E04EF2AEB04EFDF302E05EC516", hash_generated_method = "2473D32461060F976030E027A319787C")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        boolean var4D7C358C8BD535F7098378506DB34C5F_1041756299 = (super.dispatchKeyEvent(event) || executeKeyEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_115381041 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_115381041;
        // ---------- Original Method ----------
        //return super.dispatchKeyEvent(event) || executeKeyEvent(event);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.033 -0400", hash_original_method = "59EE8B926A303894927E6FAD605B1FF1", hash_generated_method = "E0C1BB1AEE2C4A403034DE4C36E7F5AF")
    public boolean executeKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        mTempRect.setEmpty();
        if(!canScroll())        
        {
            if(isFocused())            
            {
                View currentFocused = findFocus();
                if(currentFocused == this)                
                currentFocused = null;
                View nextFocused = FocusFinder.getInstance().findNextFocus(this,
                        currentFocused, View.FOCUS_RIGHT);
                boolean var2D16C80B5336D8EEAE1F48547DDA8A1E_913696427 = (nextFocused != null && nextFocused != this &&
                        nextFocused.requestFocus(View.FOCUS_RIGHT));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2102813033 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2102813033;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1639673320 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_624534923 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_624534923;
        } //End block
        boolean handled = false;
        if(event.getAction() == KeyEvent.ACTION_DOWN)        
        {
switch(event.getKeyCode()){
            case KeyEvent.KEYCODE_DPAD_LEFT:
            if(!event.isAltPressed())            
            {
                handled = arrowScroll(View.FOCUS_LEFT);
            } //End block
            else
            {
                handled = fullScroll(View.FOCUS_LEFT);
            } //End block
            break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
            if(!event.isAltPressed())            
            {
                handled = arrowScroll(View.FOCUS_RIGHT);
            } //End block
            else
            {
                handled = fullScroll(View.FOCUS_RIGHT);
            } //End block
            break;
            case KeyEvent.KEYCODE_SPACE:
            pageScroll(event.isShiftPressed() ? View.FOCUS_LEFT : View.FOCUS_RIGHT);
            break;
}
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_896336144 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_160728733 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_160728733;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.033 -0400", hash_original_method = "9319BD4BC402BC56524E94C60EDF0AE3", hash_generated_method = "D53575D646C0818E5680B417B31608D8")
    private boolean inChild(int x, int y) {
        addTaint(y);
        addTaint(x);
        if(getChildCount() > 0)        
        {
            final int scrollX = mScrollX;
            final View child = getChildAt(0);
            boolean var315B4686B994B17FFBC4F4304C1A43F9_641368063 = (!(y < child.getTop()
                    || y >= child.getBottom()
                    || x < child.getLeft() - scrollX
                    || x >= child.getRight() - scrollX));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1123713249 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1123713249;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_593269597 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1054451907 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1054451907;
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //final int scrollX = mScrollX;
            //final View child = getChildAt(0);
            //return !(y < child.getTop()
                    //|| y >= child.getBottom()
                    //|| x < child.getLeft() - scrollX
                    //|| x >= child.getRight() - scrollX);
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.033 -0400", hash_original_method = "2F2E3E2ED97C397B1954EFE1C35FD1EF", hash_generated_method = "E6A2459F70C94EEE4F8E0DC05B01F193")
    private void initOrResetVelocityTracker() {
        if(mVelocityTracker == null)        
        {
            mVelocityTracker = VelocityTracker.obtain();
        } //End block
        else
        {
            mVelocityTracker.clear();
        } //End block
        // ---------- Original Method ----------
        //if (mVelocityTracker == null) {
            //mVelocityTracker = VelocityTracker.obtain();
        //} else {
            //mVelocityTracker.clear();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.033 -0400", hash_original_method = "2C2F1E0A6C232182F8110D9EE75ED47E", hash_generated_method = "2B8D7737D5D71D4902AEB864DE542716")
    private void initVelocityTrackerIfNotExists() {
        if(mVelocityTracker == null)        
        {
            mVelocityTracker = VelocityTracker.obtain();
        } //End block
        // ---------- Original Method ----------
        //if (mVelocityTracker == null) {
            //mVelocityTracker = VelocityTracker.obtain();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.033 -0400", hash_original_method = "FC3B581D4963BCED4340031BA20C5421", hash_generated_method = "701A7C43D055D340A0D18EE9D957EDFF")
    private void recycleVelocityTracker() {
        if(mVelocityTracker != null)        
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        } //End block
        // ---------- Original Method ----------
        //if (mVelocityTracker != null) {
            //mVelocityTracker.recycle();
            //mVelocityTracker = null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.033 -0400", hash_original_method = "C74400E8950C106883E854683AF24673", hash_generated_method = "0484ACC96D68F9484E340AA90FA16493")
    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        addTaint(disallowIntercept);
        if(disallowIntercept)        
        {
            recycleVelocityTracker();
        } //End block
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
        // ---------- Original Method ----------
        //if (disallowIntercept) {
            //recycleVelocityTracker();
        //}
        //super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.034 -0400", hash_original_method = "B8EBEABAF4D085F1DC9FA2F6547DBF28", hash_generated_method = "4E8B9B58DC873701052385416A563CB2")
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final int action = ev.getAction();
        if((action == MotionEvent.ACTION_MOVE) && (mIsBeingDragged))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1477328784 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_109795951 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_109795951;
        } //End block
switch(action & MotionEvent.ACTION_MASK){
        case MotionEvent.ACTION_MOVE:
        {
            final int activePointerId = mActivePointerId;
            if(activePointerId == INVALID_POINTER)            
            {
                break;
            } //End block
            final int pointerIndex = ev.findPointerIndex(activePointerId);
            final float x = ev.getX(pointerIndex);
            final int xDiff = (int) Math.abs(x - mLastMotionX);
            if(xDiff > mTouchSlop)            
            {
                mIsBeingDragged = true;
                mLastMotionX = x;
                initVelocityTrackerIfNotExists();
                mVelocityTracker.addMovement(ev);
                if(mParent != null)                
                mParent.requestDisallowInterceptTouchEvent(true);
            } //End block
            break;
        } //End block
        case MotionEvent.ACTION_DOWN:
        {
            final float x = ev.getX();
            if(!inChild((int) x, (int) ev.getY()))            
            {
                mIsBeingDragged = false;
                recycleVelocityTracker();
                break;
            } //End block
            mLastMotionX = x;
            mActivePointerId = ev.getPointerId(0);
            initOrResetVelocityTracker();
            mVelocityTracker.addMovement(ev);
            mIsBeingDragged = !mScroller.isFinished();
            break;
        } //End block
        case MotionEvent.ACTION_CANCEL:
        case MotionEvent.ACTION_UP:
        mIsBeingDragged = false;
        mActivePointerId = INVALID_POINTER;
        if(mScroller.springBack(mScrollX, mScrollY, 0, getScrollRange(), 0, 0))        
        {
            invalidate();
        } //End block
        break;
        case MotionEvent.ACTION_POINTER_DOWN:
        {
            final int index = ev.getActionIndex();
            mLastMotionX = ev.getX(index);
            mActivePointerId = ev.getPointerId(index);
            break;
        } //End block
        case MotionEvent.ACTION_POINTER_UP:
        onSecondaryPointerUp(ev);
        mLastMotionX = ev.getX(ev.findPointerIndex(mActivePointerId));
        break;
}        boolean varCD7F83DE880FD2A584529B26609B9552_1830329299 = (mIsBeingDragged);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_78825253 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_78825253;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.035 -0400", hash_original_method = "DC232709D0DE420641FAAFB6B744429B", hash_generated_method = "F0F8412A8E9A33E0FF2CEB2ECF3E90B9")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        initVelocityTrackerIfNotExists();
        mVelocityTracker.addMovement(ev);
        final int action = ev.getAction();
switch(action & MotionEvent.ACTION_MASK){
        case MotionEvent.ACTION_DOWN:
        {
            mIsBeingDragged = getChildCount() != 0;
            if(!mIsBeingDragged)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1115025273 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1693065784 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1693065784;
            } //End block
            if(!mScroller.isFinished())            
            {
                mScroller.abortAnimation();
            } //End block
            mLastMotionX = ev.getX();
            mActivePointerId = ev.getPointerId(0);
            break;
        } //End block
        case MotionEvent.ACTION_MOVE:
        if(mIsBeingDragged)        
        {
            final int activePointerIndex = ev.findPointerIndex(mActivePointerId);
            final float x = ev.getX(activePointerIndex);
            final int deltaX = (int) (mLastMotionX - x);
            mLastMotionX = x;
            final int oldX = mScrollX;
            final int oldY = mScrollY;
            final int range = getScrollRange();
            final int overscrollMode = getOverScrollMode();
            final boolean canOverscroll = overscrollMode == OVER_SCROLL_ALWAYS ||
                            (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && range > 0);
            if(overScrollBy(deltaX, 0, mScrollX, 0, range, 0,
                            mOverscrollDistance, 0, true))            
            {
                mVelocityTracker.clear();
            } //End block
            onScrollChanged(mScrollX, mScrollY, oldX, oldY);
            if(canOverscroll)            
            {
                final int pulledToX = oldX + deltaX;
                if(pulledToX < 0)                
                {
                    mEdgeGlowLeft.onPull((float) deltaX / getWidth());
                    if(!mEdgeGlowRight.isFinished())                    
                    {
                        mEdgeGlowRight.onRelease();
                    } //End block
                } //End block
                else
                if(pulledToX > range)                
                {
                    mEdgeGlowRight.onPull((float) deltaX / getWidth());
                    if(!mEdgeGlowLeft.isFinished())                    
                    {
                        mEdgeGlowLeft.onRelease();
                    } //End block
                } //End block
                if(mEdgeGlowLeft != null
                                && (!mEdgeGlowLeft.isFinished() || !mEdgeGlowRight.isFinished()))                
                {
                    invalidate();
                } //End block
            } //End block
        } //End block
        break;
        case MotionEvent.ACTION_UP:
        if(mIsBeingDragged)        
        {
            final VelocityTracker velocityTracker = mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
            int initialVelocity = (int) velocityTracker.getXVelocity(mActivePointerId);
            if(getChildCount() > 0)            
            {
                if((Math.abs(initialVelocity) > mMinimumVelocity))                
                {
                    fling(-initialVelocity);
                } //End block
                else
                {
                    if(mScroller.springBack(mScrollX, mScrollY, 0,
                                    getScrollRange(), 0, 0))                    
                    {
                        invalidate();
                    } //End block
                } //End block
            } //End block
            mActivePointerId = INVALID_POINTER;
            mIsBeingDragged = false;
            recycleVelocityTracker();
            if(mEdgeGlowLeft != null)            
            {
                mEdgeGlowLeft.onRelease();
                mEdgeGlowRight.onRelease();
            } //End block
        } //End block
        break;
        case MotionEvent.ACTION_CANCEL:
        if(mIsBeingDragged && getChildCount() > 0)        
        {
            if(mScroller.springBack(mScrollX, mScrollY, 0, getScrollRange(), 0, 0))            
            {
                invalidate();
            } //End block
            mActivePointerId = INVALID_POINTER;
            mIsBeingDragged = false;
            recycleVelocityTracker();
            if(mEdgeGlowLeft != null)            
            {
                mEdgeGlowLeft.onRelease();
                mEdgeGlowRight.onRelease();
            } //End block
        } //End block
        break;
        case MotionEvent.ACTION_POINTER_UP:
        onSecondaryPointerUp(ev);
        break;
}        boolean varB326B5062B2F0E69046810717534CB09_26991532 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_17194326 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_17194326;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.036 -0400", hash_original_method = "15678E7D87FCB5B2E2A6D15F2CBAE390", hash_generated_method = "6E8CEB267E5C94F79FF4514B7A7BA1AE")
    private void onSecondaryPointerUp(MotionEvent ev) {
        final int pointerIndex = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >>
                MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        final int pointerId = ev.getPointerId(pointerIndex);
        if(pointerId == mActivePointerId)        
        {
            final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            mLastMotionX = ev.getX(newPointerIndex);
            mActivePointerId = ev.getPointerId(newPointerIndex);
            if(mVelocityTracker != null)            
            {
                mVelocityTracker.clear();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final int pointerIndex = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >>
                //MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        //final int pointerId = ev.getPointerId(pointerIndex);
        //if (pointerId == mActivePointerId) {
            //final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            //mLastMotionX = ev.getX(newPointerIndex);
            //mActivePointerId = ev.getPointerId(newPointerIndex);
            //if (mVelocityTracker != null) {
                //mVelocityTracker.clear();
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.036 -0400", hash_original_method = "EA19C55D5CBC44B40040771841401365", hash_generated_method = "8687218607AB0104C5F53D4E10810355")
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        if((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0)        
        {
switch(event.getAction()){
            case MotionEvent.ACTION_SCROLL:
            {
                if(!mIsBeingDragged)                
                {
                    float hscroll;
                    if((event.getMetaState() & KeyEvent.META_SHIFT_ON) != 0)                    
                    {
                        hscroll = -event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                    } //End block
                    else
                    {
                        hscroll = event.getAxisValue(MotionEvent.AXIS_HSCROLL);
                    } //End block
                    if(hscroll != 0)                    
                    {
                        final int delta = (int) (hscroll * getHorizontalScrollFactor());
                        final int range = getScrollRange();
                        int oldScrollX = mScrollX;
                        int newScrollX = oldScrollX + delta;
                        if(newScrollX < 0)                        
                        {
                            newScrollX = 0;
                        } //End block
                        else
                        if(newScrollX > range)                        
                        {
                            newScrollX = range;
                        } //End block
                        if(newScrollX != oldScrollX)                        
                        {
                            super.scrollTo(newScrollX, mScrollY);
                            boolean varB326B5062B2F0E69046810717534CB09_97034590 = (true);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1292228788 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1292228788;
                        } //End block
                    } //End block
                } //End block
            } //End block
}
        } //End block
        boolean var3B54C423A43BA14BBEA440506237FA4B_1605078245 = (super.onGenericMotionEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1913130864 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1913130864;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.036 -0400", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "B05BF0571A144240ABF3F26303671E8A")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean varB326B5062B2F0E69046810717534CB09_540932094 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_541658789 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_541658789;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.036 -0400", hash_original_method = "06CAD3F9DAB24C265A0AAEC7445D85D7", hash_generated_method = "9FCAC737D0B0C30894E5FEDAB13B5BF9")
    @Override
    protected void onOverScrolled(int scrollX, int scrollY,
            boolean clampedX, boolean clampedY) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(clampedY);
        addTaint(clampedX);
        addTaint(scrollY);
        addTaint(scrollX);
        if(!mScroller.isFinished())        
        {
            mScrollX = scrollX;
            mScrollY = scrollY;
            invalidateParentIfNeeded();
            if(clampedX)            
            {
                mScroller.springBack(mScrollX, mScrollY, 0, getScrollRange(), 0, 0);
            } //End block
        } //End block
        else
        {
            super.scrollTo(scrollX, scrollY);
        } //End block
        awakenScrollBars();
        // ---------- Original Method ----------
        //if (!mScroller.isFinished()) {
            //mScrollX = scrollX;
            //mScrollY = scrollY;
            //invalidateParentIfNeeded();
            //if (clampedX) {
                //mScroller.springBack(mScrollX, mScrollY, 0, getScrollRange(), 0, 0);
            //}
        //} else {
            //super.scrollTo(scrollX, scrollY);
        //}
        //awakenScrollBars();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.037 -0400", hash_original_method = "AF8EC74B0AD4D69DC5ACACFC8749064F", hash_generated_method = "2035CC755BD505267DFD2C0A965F4DCF")
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(info.getTaint());
        super.onInitializeAccessibilityNodeInfo(info);
        info.setScrollable(getScrollRange() > 0);
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityNodeInfo(info);
        //info.setScrollable(getScrollRange() > 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.037 -0400", hash_original_method = "7DA515169DBC462D06A7F08F561D2E84", hash_generated_method = "CEF007BE694C3C607FD2AB3C05372CC0")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        super.onInitializeAccessibilityEvent(event);
        event.setScrollable(getScrollRange() > 0);
        event.setScrollX(mScrollX);
        event.setScrollY(mScrollY);
        event.setMaxScrollX(getScrollRange());
        event.setMaxScrollY(mScrollY);
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //event.setScrollable(getScrollRange() > 0);
        //event.setScrollX(mScrollX);
        //event.setScrollY(mScrollY);
        //event.setMaxScrollX(getScrollRange());
        //event.setMaxScrollY(mScrollY);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.037 -0400", hash_original_method = "6035917F8C30F3A1C02AFED333ACB352", hash_generated_method = "C775CA46316448D87412B344B7CC0CD0")
    private int getScrollRange() {
        int scrollRange = 0;
        if(getChildCount() > 0)        
        {
            View child = getChildAt(0);
            scrollRange = Math.max(0,
                    child.getWidth() - (getWidth() - mPaddingLeft - mPaddingRight));
        } //End block
        int var94D4A3ECD79FF3E17EB5BD0659AF9AAE_1835843848 = (scrollRange);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_350818973 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_350818973;
        // ---------- Original Method ----------
        //int scrollRange = 0;
        //if (getChildCount() > 0) {
            //View child = getChildAt(0);
            //scrollRange = Math.max(0,
                    //child.getWidth() - (getWidth() - mPaddingLeft - mPaddingRight));
        //}
        //return scrollRange;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.037 -0400", hash_original_method = "B34C300D12B589B0218EA4927548AE87", hash_generated_method = "042545AE00ADD425598FC729FC7F459C")
    private View findFocusableViewInMyBounds(final boolean leftFocus,
            final int left, View preferredFocusable) {
        addTaint(preferredFocusable.getTaint());
        addTaint(left);
        addTaint(leftFocus);
        final int fadingEdgeLength = getHorizontalFadingEdgeLength() / 2;
        final int leftWithoutFadingEdge = left + fadingEdgeLength;
        final int rightWithoutFadingEdge = left + getWidth() - fadingEdgeLength;
        if((preferredFocusable != null)
                && (preferredFocusable.getLeft() < rightWithoutFadingEdge)
                && (preferredFocusable.getRight() > leftWithoutFadingEdge))        
        {
View varEDCC47E7BD000496BBF92CD9272FBD7B_1607560354 =             preferredFocusable;
            varEDCC47E7BD000496BBF92CD9272FBD7B_1607560354.addTaint(taint);
            return varEDCC47E7BD000496BBF92CD9272FBD7B_1607560354;
        } //End block
View var3C5DAB17BC904AC109467AE0B923004B_1564733784 =         findFocusableViewInBounds(leftFocus, leftWithoutFadingEdge,
                rightWithoutFadingEdge);
        var3C5DAB17BC904AC109467AE0B923004B_1564733784.addTaint(taint);
        return var3C5DAB17BC904AC109467AE0B923004B_1564733784;
        // ---------- Original Method ----------
        //final int fadingEdgeLength = getHorizontalFadingEdgeLength() / 2;
        //final int leftWithoutFadingEdge = left + fadingEdgeLength;
        //final int rightWithoutFadingEdge = left + getWidth() - fadingEdgeLength;
        //if ((preferredFocusable != null)
                //&& (preferredFocusable.getLeft() < rightWithoutFadingEdge)
                //&& (preferredFocusable.getRight() > leftWithoutFadingEdge)) {
            //return preferredFocusable;
        //}
        //return findFocusableViewInBounds(leftFocus, leftWithoutFadingEdge,
                //rightWithoutFadingEdge);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.038 -0400", hash_original_method = "CFAC89DA51B9853AC14992D421225DFD", hash_generated_method = "546DAEEDCFA797C1904C5FD7FA364545")
    private View findFocusableViewInBounds(boolean leftFocus, int left, int right) {
        addTaint(right);
        addTaint(left);
        addTaint(leftFocus);
        List<View> focusables = getFocusables(View.FOCUS_FORWARD);
        View focusCandidate = null;
        boolean foundFullyContainedFocusable = false;
        int count = focusables.size();
for(int i = 0;i < count;i++)
        {
            View view = focusables.get(i);
            int viewLeft = view.getLeft();
            int viewRight = view.getRight();
            if(left < viewRight && viewLeft < right)            
            {
                final boolean viewIsFullyContained = (left < viewLeft) &&
                        (viewRight < right);
                if(focusCandidate == null)                
                {
                    focusCandidate = view;
                    foundFullyContainedFocusable = viewIsFullyContained;
                } //End block
                else
                {
                    final boolean viewIsCloserToBoundary = (leftFocus && viewLeft < focusCandidate.getLeft()) ||
                                    (!leftFocus && viewRight > focusCandidate.getRight());
                    if(foundFullyContainedFocusable)                    
                    {
                        if(viewIsFullyContained && viewIsCloserToBoundary)                        
                        {
                            focusCandidate = view;
                        } //End block
                    } //End block
                    else
                    {
                        if(viewIsFullyContained)                        
                        {
                            focusCandidate = view;
                            foundFullyContainedFocusable = true;
                        } //End block
                        else
                        if(viewIsCloserToBoundary)                        
                        {
                            focusCandidate = view;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
View var9E337B9582937B68BAD70C44709A03C7_1376189816 =         focusCandidate;
        var9E337B9582937B68BAD70C44709A03C7_1376189816.addTaint(taint);
        return var9E337B9582937B68BAD70C44709A03C7_1376189816;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.038 -0400", hash_original_method = "DA183CDCD6EA3DA10063DE059735FFD7", hash_generated_method = "6065ECDB8170246DB2572CBE479221B0")
    public boolean pageScroll(int direction) {
        addTaint(direction);
        boolean right = direction == View.FOCUS_RIGHT;
        int width = getWidth();
        if(right)        
        {
            mTempRect.left = getScrollX() + width;
            int count = getChildCount();
            if(count > 0)            
            {
                View view = getChildAt(0);
                if(mTempRect.left + width > view.getRight())                
                {
                    mTempRect.left = view.getRight() - width;
                } //End block
            } //End block
        } //End block
        else
        {
            mTempRect.left = getScrollX() - width;
            if(mTempRect.left < 0)            
            {
                mTempRect.left = 0;
            } //End block
        } //End block
        mTempRect.right = mTempRect.left + width;
        boolean var7C1EF92AB564BC909CCE560A1120AF30_1134611924 = (scrollAndFocus(direction, mTempRect.left, mTempRect.right));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1638092155 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1638092155;
        // ---------- Original Method ----------
        //boolean right = direction == View.FOCUS_RIGHT;
        //int width = getWidth();
        //if (right) {
            //mTempRect.left = getScrollX() + width;
            //int count = getChildCount();
            //if (count > 0) {
                //View view = getChildAt(0);
                //if (mTempRect.left + width > view.getRight()) {
                    //mTempRect.left = view.getRight() - width;
                //}
            //}
        //} else {
            //mTempRect.left = getScrollX() - width;
            //if (mTempRect.left < 0) {
                //mTempRect.left = 0;
            //}
        //}
        //mTempRect.right = mTempRect.left + width;
        //return scrollAndFocus(direction, mTempRect.left, mTempRect.right);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.039 -0400", hash_original_method = "13724385C240165AD29E108B78F9E99D", hash_generated_method = "5CC875FA2F49D1586DC23FD0E3DC40EC")
    public boolean fullScroll(int direction) {
        addTaint(direction);
        boolean right = direction == View.FOCUS_RIGHT;
        int width = getWidth();
        mTempRect.left = 0;
        mTempRect.right = width;
        if(right)        
        {
            int count = getChildCount();
            if(count > 0)            
            {
                View view = getChildAt(0);
                mTempRect.right = view.getRight();
                mTempRect.left = mTempRect.right - width;
            } //End block
        } //End block
        boolean var7C1EF92AB564BC909CCE560A1120AF30_1550585658 = (scrollAndFocus(direction, mTempRect.left, mTempRect.right));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1115549215 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1115549215;
        // ---------- Original Method ----------
        //boolean right = direction == View.FOCUS_RIGHT;
        //int width = getWidth();
        //mTempRect.left = 0;
        //mTempRect.right = width;
        //if (right) {
            //int count = getChildCount();
            //if (count > 0) {
                //View view = getChildAt(0);
                //mTempRect.right = view.getRight();
                //mTempRect.left = mTempRect.right - width;
            //}
        //}
        //return scrollAndFocus(direction, mTempRect.left, mTempRect.right);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.039 -0400", hash_original_method = "DF3968C57E4B66E8EEB56F2D4C42BFD9", hash_generated_method = "2A49F671E1B677EBBD647087544D544B")
    private boolean scrollAndFocus(int direction, int left, int right) {
        addTaint(right);
        addTaint(left);
        addTaint(direction);
        boolean handled = true;
        int width = getWidth();
        int containerLeft = getScrollX();
        int containerRight = containerLeft + width;
        boolean goLeft = direction == View.FOCUS_LEFT;
        View newFocused = findFocusableViewInBounds(goLeft, left, right);
        if(newFocused == null)        
        {
            newFocused = this;
        } //End block
        if(left >= containerLeft && right <= containerRight)        
        {
            handled = false;
        } //End block
        else
        {
            int delta = goLeft ? (left - containerLeft) : (right - containerRight);
            doScrollX(delta);
        } //End block
        if(newFocused != findFocus())        
        newFocused.requestFocus(direction);
        boolean var98F0599AF776A1FE4101C199A40EEB8F_1728285321 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1562192072 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1562192072;
        // ---------- Original Method ----------
        //boolean handled = true;
        //int width = getWidth();
        //int containerLeft = getScrollX();
        //int containerRight = containerLeft + width;
        //boolean goLeft = direction == View.FOCUS_LEFT;
        //View newFocused = findFocusableViewInBounds(goLeft, left, right);
        //if (newFocused == null) {
            //newFocused = this;
        //}
        //if (left >= containerLeft && right <= containerRight) {
            //handled = false;
        //} else {
            //int delta = goLeft ? (left - containerLeft) : (right - containerRight);
            //doScrollX(delta);
        //}
        //if (newFocused != findFocus()) newFocused.requestFocus(direction);
        //return handled;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.039 -0400", hash_original_method = "ED0B7D3300F52C8B0FEFDD6EE298A1FB", hash_generated_method = "0708B4E796F9450702CC6E95C8BD15C1")
    public boolean arrowScroll(int direction) {
        addTaint(direction);
        View currentFocused = findFocus();
        if(currentFocused == this)        
        currentFocused = null;
        View nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused, direction);
        final int maxJump = getMaxScrollAmount();
        if(nextFocused != null && isWithinDeltaOfScreen(nextFocused, maxJump))        
        {
            nextFocused.getDrawingRect(mTempRect);
            offsetDescendantRectToMyCoords(nextFocused, mTempRect);
            int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
            doScrollX(scrollDelta);
            nextFocused.requestFocus(direction);
        } //End block
        else
        {
            int scrollDelta = maxJump;
            if(direction == View.FOCUS_LEFT && getScrollX() < scrollDelta)            
            {
                scrollDelta = getScrollX();
            } //End block
            else
            if(direction == View.FOCUS_RIGHT && getChildCount() > 0)            
            {
                int daRight = getChildAt(0).getRight();
                int screenRight = getScrollX() + getWidth();
                if(daRight - screenRight < maxJump)                
                {
                    scrollDelta = daRight - screenRight;
                } //End block
            } //End block
            if(scrollDelta == 0)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1588887631 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1338787509 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1338787509;
            } //End block
            doScrollX(direction == View.FOCUS_RIGHT ? scrollDelta : -scrollDelta);
        } //End block
        if(currentFocused != null && currentFocused.isFocused()
                && isOffScreen(currentFocused))        
        {
            final int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1795056264 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_200054601 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_200054601;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.040 -0400", hash_original_method = "E39461866A28C70AD36F56E791C6BE3B", hash_generated_method = "E8BFA9086996ADBF82175D50F4B7B1F8")
    private boolean isOffScreen(View descendant) {
        addTaint(descendant.getTaint());
        boolean var3D726CE330560D3EFA6DFB1FF35B4C67_1025642742 = (!isWithinDeltaOfScreen(descendant, 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1483809368 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1483809368;
        // ---------- Original Method ----------
        //return !isWithinDeltaOfScreen(descendant, 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.040 -0400", hash_original_method = "47CB02AABD47C9E7AF2DCBC38CD370E2", hash_generated_method = "5A0C888EC9092E173FB40552601C8038")
    private boolean isWithinDeltaOfScreen(View descendant, int delta) {
        addTaint(delta);
        addTaint(descendant.getTaint());
        descendant.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(descendant, mTempRect);
        boolean varFACA1C4E77F32851DF23DA96FB43CD96_1945699359 = ((mTempRect.right + delta) >= getScrollX()
                && (mTempRect.left - delta) <= (getScrollX() + getWidth()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1435174832 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1435174832;
        // ---------- Original Method ----------
        //descendant.getDrawingRect(mTempRect);
        //offsetDescendantRectToMyCoords(descendant, mTempRect);
        //return (mTempRect.right + delta) >= getScrollX()
                //&& (mTempRect.left - delta) <= (getScrollX() + getWidth());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.040 -0400", hash_original_method = "3F16B27E18A709EC962C39AF363F3965", hash_generated_method = "C93A97A668F634FF7B4DA6D35A07845F")
    private void doScrollX(int delta) {
        addTaint(delta);
        if(delta != 0)        
        {
            if(mSmoothScrollingEnabled)            
            {
                smoothScrollBy(delta, 0);
            } //End block
            else
            {
                scrollBy(delta, 0);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (delta != 0) {
            //if (mSmoothScrollingEnabled) {
                //smoothScrollBy(delta, 0);
            //} else {
                //scrollBy(delta, 0);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.041 -0400", hash_original_method = "DAE9EEC093475C9AC0229EA6C3F406DC", hash_generated_method = "D107125CA7489BD9FD31DD40266B0EF6")
    public final void smoothScrollBy(int dx, int dy) {
        addTaint(dy);
        addTaint(dx);
        if(getChildCount() == 0)        
        {
            return;
        } //End block
        long duration = AnimationUtils.currentAnimationTimeMillis() - mLastScroll;
        if(duration > ANIMATED_SCROLL_GAP)        
        {
            final int width = getWidth() - mPaddingRight - mPaddingLeft;
            final int right = getChildAt(0).getWidth();
            final int maxX = Math.max(0, right - width);
            final int scrollX = mScrollX;
            dx = Math.max(0, Math.min(scrollX + dx, maxX)) - scrollX;
            mScroller.startScroll(scrollX, mScrollY, dx, 0);
            invalidate();
        } //End block
        else
        {
            if(!mScroller.isFinished())            
            {
                mScroller.abortAnimation();
            } //End block
            scrollBy(dx, dy);
        } //End block
        mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.041 -0400", hash_original_method = "EED648F6788EFF0F67B65ABAA0DE4CF2", hash_generated_method = "1619451DF2B1DD4BECD96649A5683C61")
    public final void smoothScrollTo(int x, int y) {
        addTaint(y);
        addTaint(x);
        smoothScrollBy(x - mScrollX, y - mScrollY);
        // ---------- Original Method ----------
        //smoothScrollBy(x - mScrollX, y - mScrollY);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.041 -0400", hash_original_method = "344907C67A02819CC7A230367AD45761", hash_generated_method = "9E8F8992EA8ED725175B8C57BEC4E543")
    @Override
    protected int computeHorizontalScrollRange() {
        final int count = getChildCount();
        final int contentWidth = getWidth() - mPaddingLeft - mPaddingRight;
        if(count == 0)        
        {
            int var1BF07926F6538F21E562505C076C042A_357747498 = (contentWidth);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_599417015 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_599417015;
        } //End block
        int scrollRange = getChildAt(0).getRight();
        final int scrollX = mScrollX;
        final int overscrollRight = Math.max(0, scrollRange - contentWidth);
        if(scrollX < 0)        
        {
            scrollRange -= scrollX;
        } //End block
        else
        if(scrollX > overscrollRight)        
        {
            scrollRange += scrollX - overscrollRight;
        } //End block
        int var94D4A3ECD79FF3E17EB5BD0659AF9AAE_1736391549 = (scrollRange);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1515573906 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1515573906;
        // ---------- Original Method ----------
        //final int count = getChildCount();
        //final int contentWidth = getWidth() - mPaddingLeft - mPaddingRight;
        //if (count == 0) {
            //return contentWidth;
        //}
        //int scrollRange = getChildAt(0).getRight();
        //final int scrollX = mScrollX;
        //final int overscrollRight = Math.max(0, scrollRange - contentWidth);
        //if (scrollX < 0) {
            //scrollRange -= scrollX;
        //} else if (scrollX > overscrollRight) {
            //scrollRange += scrollX - overscrollRight;
        //}
        //return scrollRange;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.041 -0400", hash_original_method = "9CF354C1D07DBC59A9E2E44E57F7657B", hash_generated_method = "7606EC594275DCDD353CA08CC7AE42A8")
    @Override
    protected int computeHorizontalScrollOffset() {
        int varF6857976BB9B7C6ED56FF74099CDBEBC_1643691144 = (Math.max(0, super.computeHorizontalScrollOffset()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1102410406 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1102410406;
        // ---------- Original Method ----------
        //return Math.max(0, super.computeHorizontalScrollOffset());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.041 -0400", hash_original_method = "1A4819189D92B65ABF3F692114902ED1", hash_generated_method = "D1D35D018153C7C1449F7EA0245290A7")
    @Override
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        addTaint(parentHeightMeasureSpec);
        addTaint(parentWidthMeasureSpec);
        addTaint(child.getTaint());
        ViewGroup.LayoutParams lp = child.getLayoutParams();
        int childWidthMeasureSpec;
        int childHeightMeasureSpec;
        childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec, mPaddingTop
                + mPaddingBottom, lp.height);
        childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        // ---------- Original Method ----------
        //ViewGroup.LayoutParams lp = child.getLayoutParams();
        //int childWidthMeasureSpec;
        //int childHeightMeasureSpec;
        //childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec, mPaddingTop
                //+ mPaddingBottom, lp.height);
        //childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        //child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.042 -0400", hash_original_method = "0EA8DFEAF2643806863B304E52EE38A5", hash_generated_method = "50971521E32DF7E3193DEA122D9D2652")
    @Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed,
            int parentHeightMeasureSpec, int heightUsed) {
        addTaint(heightUsed);
        addTaint(parentHeightMeasureSpec);
        addTaint(widthUsed);
        addTaint(parentWidthMeasureSpec);
        addTaint(child.getTaint());
        final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                mPaddingTop + mPaddingBottom + lp.topMargin + lp.bottomMargin
                        + heightUsed, lp.height);
        final int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(
                lp.leftMargin + lp.rightMargin, MeasureSpec.UNSPECIFIED);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        // ---------- Original Method ----------
        //final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        //final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                //mPaddingTop + mPaddingBottom + lp.topMargin + lp.bottomMargin
                        //+ heightUsed, lp.height);
        //final int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(
                //lp.leftMargin + lp.rightMargin, MeasureSpec.UNSPECIFIED);
        //child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.042 -0400", hash_original_method = "D30258BCA66C5E19407EB248DA88CE03", hash_generated_method = "3F16AA7BE934B5D63EE12A0D7542579E")
    @Override
    public void computeScroll() {
        if(mScroller.computeScrollOffset())        
        {
            int oldX = mScrollX;
            int oldY = mScrollY;
            int x = mScroller.getCurrX();
            int y = mScroller.getCurrY();
            if(oldX != x || oldY != y)            
            {
                final int range = getScrollRange();
                final int overscrollMode = getOverScrollMode();
                final boolean canOverscroll = overscrollMode == OVER_SCROLL_ALWAYS ||
                        (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && range > 0);
                overScrollBy(x - oldX, y - oldY, oldX, oldY, range, 0,
                        mOverflingDistance, 0, false);
                onScrollChanged(mScrollX, mScrollY, oldX, oldY);
                if(canOverscroll)                
                {
                    if(x < 0 && oldX >= 0)                    
                    {
                        mEdgeGlowLeft.onAbsorb((int) mScroller.getCurrVelocity());
                    } //End block
                    else
                    if(x > range && oldX <= range)                    
                    {
                        mEdgeGlowRight.onAbsorb((int) mScroller.getCurrVelocity());
                    } //End block
                } //End block
            } //End block
            awakenScrollBars();
            postInvalidate();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.042 -0400", hash_original_method = "988A7EC33B56EE551974E7C841966101", hash_generated_method = "DAB03F10A57CC9C2AB456DEEDA3A40B2")
    private void scrollToChild(View child) {
        addTaint(child.getTaint());
        child.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(child, mTempRect);
        int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
        if(scrollDelta != 0)        
        {
            scrollBy(scrollDelta, 0);
        } //End block
        // ---------- Original Method ----------
        //child.getDrawingRect(mTempRect);
        //offsetDescendantRectToMyCoords(child, mTempRect);
        //int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
        //if (scrollDelta != 0) {
            //scrollBy(scrollDelta, 0);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.042 -0400", hash_original_method = "07633DDCD66F05F9C6104D95040C4376", hash_generated_method = "57D86FB366FE716BA853C45A5916A846")
    private boolean scrollToChildRect(Rect rect, boolean immediate) {
        addTaint(immediate);
        addTaint(rect.getTaint());
        final int delta = computeScrollDeltaToGetChildRectOnScreen(rect);
        final boolean scroll = delta != 0;
        if(scroll)        
        {
            if(immediate)            
            {
                scrollBy(delta, 0);
            } //End block
            else
            {
                smoothScrollBy(delta, 0);
            } //End block
        } //End block
        boolean var089B0CDD8835D09CB1CABF38B3CE9C09_330541321 = (scroll);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_703651803 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_703651803;
        // ---------- Original Method ----------
        //final int delta = computeScrollDeltaToGetChildRectOnScreen(rect);
        //final boolean scroll = delta != 0;
        //if (scroll) {
            //if (immediate) {
                //scrollBy(delta, 0);
            //} else {
                //smoothScrollBy(delta, 0);
            //}
        //}
        //return scroll;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.043 -0400", hash_original_method = "8C5AA93676CE0EF7515972F93F61C0B6", hash_generated_method = "1075EB706BD5C0C03F52CED8B319896F")
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        addTaint(rect.getTaint());
        if(getChildCount() == 0)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_1768864257 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724511138 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724511138;
        }
        int width = getWidth();
        int screenLeft = getScrollX();
        int screenRight = screenLeft + width;
        int fadingEdge = getHorizontalFadingEdgeLength();
        if(rect.left > 0)        
        {
            screenLeft += fadingEdge;
        } //End block
        if(rect.right < getChildAt(0).getWidth())        
        {
            screenRight -= fadingEdge;
        } //End block
        int scrollXDelta = 0;
        if(rect.right > screenRight && rect.left > screenLeft)        
        {
            if(rect.width() > width)            
            {
                scrollXDelta += (rect.left - screenLeft);
            } //End block
            else
            {
                scrollXDelta += (rect.right - screenRight);
            } //End block
            int right = getChildAt(0).getRight();
            int distanceToRight = right - screenRight;
            scrollXDelta = Math.min(scrollXDelta, distanceToRight);
        } //End block
        else
        if(rect.left < screenLeft && rect.right < screenRight)        
        {
            if(rect.width() > width)            
            {
                scrollXDelta -= (screenRight - rect.right);
            } //End block
            else
            {
                scrollXDelta -= (screenLeft - rect.left);
            } //End block
            scrollXDelta = Math.max(scrollXDelta, -getScrollX());
        } //End block
        int varB9383B9729AD21AB9895DA2CB9F10123_1602274715 = (scrollXDelta);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471844236 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471844236;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.043 -0400", hash_original_method = "C2C4A47D49BA76A3A98712461E581564", hash_generated_method = "13A992C0A02A86749A86E776DD1237E5")
    @Override
    public void requestChildFocus(View child, View focused) {
        addTaint(child.getTaint());
        if(!mIsLayoutDirty)        
        {
            scrollToChild(focused);
        } //End block
        else
        {
            mChildToScrollTo = focused;
        } //End block
        super.requestChildFocus(child, focused);
        // ---------- Original Method ----------
        //if (!mIsLayoutDirty) {
            //scrollToChild(focused);
        //} else {
            //mChildToScrollTo = focused;
        //}
        //super.requestChildFocus(child, focused);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.044 -0400", hash_original_method = "4857D3DE9468292A125F69FE9ECFC007", hash_generated_method = "8401F19A429A24C6EB04F9F3C7C13312")
    @Override
    protected boolean onRequestFocusInDescendants(int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
        if(direction == View.FOCUS_FORWARD)        
        {
            direction = View.FOCUS_RIGHT;
        } //End block
        else
        if(direction == View.FOCUS_BACKWARD)        
        {
            direction = View.FOCUS_LEFT;
        } //End block
        final View nextFocus = previouslyFocusedRect == null ?
                FocusFinder.getInstance().findNextFocus(this, null, direction) :
                FocusFinder.getInstance().findNextFocusFromRect(this,
                        previouslyFocusedRect, direction);
        if(nextFocus == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_931151930 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1193286276 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1193286276;
        } //End block
        if(isOffScreen(nextFocus))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1770595763 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_177048556 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_177048556;
        } //End block
        boolean var19AC7E01A4DA8FE4B22BFDF34DB33D51_1730713906 = (nextFocus.requestFocus(direction, previouslyFocusedRect));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1447119355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1447119355;
        // ---------- Original Method ----------
        //if (direction == View.FOCUS_FORWARD) {
            //direction = View.FOCUS_RIGHT;
        //} else if (direction == View.FOCUS_BACKWARD) {
            //direction = View.FOCUS_LEFT;
        //}
        //final View nextFocus = previouslyFocusedRect == null ?
                //FocusFinder.getInstance().findNextFocus(this, null, direction) :
                //FocusFinder.getInstance().findNextFocusFromRect(this,
                        //previouslyFocusedRect, direction);
        //if (nextFocus == null) {
            //return false;
        //}
        //if (isOffScreen(nextFocus)) {
            //return false;
        //}
        //return nextFocus.requestFocus(direction, previouslyFocusedRect);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.044 -0400", hash_original_method = "50E2DA7CF8E403536932E3B77491E964", hash_generated_method = "E9D18306EA60F36E5BA02AF6292B9198")
    @Override
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle,
            boolean immediate) {
        addTaint(immediate);
        addTaint(rectangle.getTaint());
        addTaint(child.getTaint());
        rectangle.offset(child.getLeft() - child.getScrollX(),
                child.getTop() - child.getScrollY());
        boolean var10C2B91B22AF1483455A09D794128372_1921686971 = (scrollToChildRect(rectangle, immediate));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1915535796 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1915535796;
        // ---------- Original Method ----------
        //rectangle.offset(child.getLeft() - child.getScrollX(),
                //child.getTop() - child.getScrollY());
        //return scrollToChildRect(rectangle, immediate);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.044 -0400", hash_original_method = "31751D7E496E2D7BD9B4D4E94AD28515", hash_generated_method = "11A20A1DA3E3F0E4689DA3F629925C7D")
    @Override
    public void requestLayout() {
        mIsLayoutDirty = true;
        super.requestLayout();
        // ---------- Original Method ----------
        //mIsLayoutDirty = true;
        //super.requestLayout();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.044 -0400", hash_original_method = "51521A672083F0AD2F639BD854AB8D0F", hash_generated_method = "0FF04B3425BEE3DDBF54B80FEC67BB3C")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        addTaint(changed);
        super.onLayout(changed, l, t, r, b);
        mIsLayoutDirty = false;
        if(mChildToScrollTo != null && isViewDescendantOf(mChildToScrollTo, this))        
        {
            scrollToChild(mChildToScrollTo);
        } //End block
        mChildToScrollTo = null;
        scrollTo(mScrollX, mScrollY);
        // ---------- Original Method ----------
        //super.onLayout(changed, l, t, r, b);
        //mIsLayoutDirty = false;
        //if (mChildToScrollTo != null && isViewDescendantOf(mChildToScrollTo, this)) {
                //scrollToChild(mChildToScrollTo);
        //}
        //mChildToScrollTo = null;
        //scrollTo(mScrollX, mScrollY);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.044 -0400", hash_original_method = "BFC9FDBBB166F0ED568B66B969E998B2", hash_generated_method = "3093074D38714A9B789A0142846514D0")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(oldh);
        addTaint(oldw);
        addTaint(h);
        addTaint(w);
        super.onSizeChanged(w, h, oldw, oldh);
        View currentFocused = findFocus();
        if(null == currentFocused || this == currentFocused)        
        return;
        final int maxJump = mRight - mLeft;
        if(isWithinDeltaOfScreen(currentFocused, maxJump))        
        {
            currentFocused.getDrawingRect(mTempRect);
            offsetDescendantRectToMyCoords(currentFocused, mTempRect);
            int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
            doScrollX(scrollDelta);
        } //End block
        // ---------- Original Method ----------
        //super.onSizeChanged(w, h, oldw, oldh);
        //View currentFocused = findFocus();
        //if (null == currentFocused || this == currentFocused)
            //return;
        //final int maxJump = mRight - mLeft;
        //if (isWithinDeltaOfScreen(currentFocused, maxJump)) {
            //currentFocused.getDrawingRect(mTempRect);
            //offsetDescendantRectToMyCoords(currentFocused, mTempRect);
            //int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
            //doScrollX(scrollDelta);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.044 -0400", hash_original_method = "25276A1ACE97D138BB17C9052B223D37", hash_generated_method = "ABFA9F164CB9A83B4C98E5D62CD7EC94")
    private boolean isViewDescendantOf(View child, View parent) {
        addTaint(parent.getTaint());
        addTaint(child.getTaint());
        if(child == parent)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_518273226 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_166286220 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_166286220;
        } //End block
        final ViewParent theParent = child.getParent();
        boolean var6F793E02A243A0ADE05122683367FBA6_1118136362 = ((theParent instanceof ViewGroup) && isViewDescendantOf((View) theParent, parent));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1224468844 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1224468844;
        // ---------- Original Method ----------
        //if (child == parent) {
            //return true;
        //}
        //final ViewParent theParent = child.getParent();
        //return (theParent instanceof ViewGroup) && isViewDescendantOf((View) theParent, parent);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.045 -0400", hash_original_method = "C5A2747735A9CF7D4575D6EE52958D1F", hash_generated_method = "6EA483B0C83FAE1542BDD434B2C6823D")
    public void fling(int velocityX) {
        addTaint(velocityX);
        if(getChildCount() > 0)        
        {
            int width = getWidth() - mPaddingRight - mPaddingLeft;
            int right = getChildAt(0).getWidth();
            mScroller.fling(mScrollX, mScrollY, velocityX, 0, 0,
                    Math.max(0, right - width), 0, 0, width/2, 0);
            final boolean movingRight = velocityX > 0;
            View currentFocused = findFocus();
            View newFocused = findFocusableViewInMyBounds(movingRight,
                    mScroller.getFinalX(), currentFocused);
            if(newFocused == null)            
            {
                newFocused = this;
            } //End block
            if(newFocused != currentFocused)            
            {
                newFocused.requestFocus(movingRight ? View.FOCUS_RIGHT : View.FOCUS_LEFT);
            } //End block
            invalidate();
        } //End block
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //int width = getWidth() - mPaddingRight - mPaddingLeft;
            //int right = getChildAt(0).getWidth();
            //mScroller.fling(mScrollX, mScrollY, velocityX, 0, 0,
                    //Math.max(0, right - width), 0, 0, width/2, 0);
            //final boolean movingRight = velocityX > 0;
            //View currentFocused = findFocus();
            //View newFocused = findFocusableViewInMyBounds(movingRight,
                    //mScroller.getFinalX(), currentFocused);
            //if (newFocused == null) {
                //newFocused = this;
            //}
            //if (newFocused != currentFocused) {
                //newFocused.requestFocus(movingRight ? View.FOCUS_RIGHT : View.FOCUS_LEFT);
            //}
            //invalidate();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.045 -0400", hash_original_method = "748C5914370A5F8CDD8109B6F4611B5B", hash_generated_method = "0D6230820B8CF3ACD12B82804532AC3B")
    @Override
    public void scrollTo(int x, int y) {
        addTaint(y);
        addTaint(x);
        if(getChildCount() > 0)        
        {
            View child = getChildAt(0);
            x = clamp(x, getWidth() - mPaddingRight - mPaddingLeft, child.getWidth());
            y = clamp(y, getHeight() - mPaddingBottom - mPaddingTop, child.getHeight());
            if(x != mScrollX || y != mScrollY)            
            {
                super.scrollTo(x, y);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //View child = getChildAt(0);
            //x = clamp(x, getWidth() - mPaddingRight - mPaddingLeft, child.getWidth());
            //y = clamp(y, getHeight() - mPaddingBottom - mPaddingTop, child.getHeight());
            //if (x != mScrollX || y != mScrollY) {
                //super.scrollTo(x, y);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.045 -0400", hash_original_method = "7D7EAD2993C7155FA8CA9421487AA499", hash_generated_method = "A84AB4D0361241C075B5DB472743EA77")
    @Override
    public void setOverScrollMode(int mode) {
        addTaint(mode);
        if(mode != OVER_SCROLL_NEVER)        
        {
            if(mEdgeGlowLeft == null)            
            {
                Context context = getContext();
                mEdgeGlowLeft = new EdgeEffect(context);
                mEdgeGlowRight = new EdgeEffect(context);
            } //End block
        } //End block
        else
        {
            mEdgeGlowLeft = null;
            mEdgeGlowRight = null;
        } //End block
        super.setOverScrollMode(mode);
        // ---------- Original Method ----------
        //if (mode != OVER_SCROLL_NEVER) {
            //if (mEdgeGlowLeft == null) {
                //Context context = getContext();
                //mEdgeGlowLeft = new EdgeEffect(context);
                //mEdgeGlowRight = new EdgeEffect(context);
            //}
        //} else {
            //mEdgeGlowLeft = null;
            //mEdgeGlowRight = null;
        //}
        //super.setOverScrollMode(mode);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.046 -0400", hash_original_method = "63AFEEC895B9671DC479FE83536227D7", hash_generated_method = "A253D366287C363C3A0AC14050D804D8")
    @SuppressWarnings({"SuspiciousNameCombination"})
    @Override
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        super.draw(canvas);
        if(mEdgeGlowLeft != null)        
        {
            final int scrollX = mScrollX;
            if(!mEdgeGlowLeft.isFinished())            
            {
                final int restoreCount = canvas.save();
                final int height = getHeight() - mPaddingTop - mPaddingBottom;
                canvas.rotate(270);
                canvas.translate(-height + mPaddingTop, Math.min(0, scrollX));
                mEdgeGlowLeft.setSize(height, getWidth());
                if(mEdgeGlowLeft.draw(canvas))                
                {
                    invalidate();
                } //End block
                canvas.restoreToCount(restoreCount);
            } //End block
            if(!mEdgeGlowRight.isFinished())            
            {
                final int restoreCount = canvas.save();
                final int width = getWidth();
                final int height = getHeight() - mPaddingTop - mPaddingBottom;
                canvas.rotate(90);
                canvas.translate(-mPaddingTop,
                        -(Math.max(getScrollRange(), scrollX) + width));
                mEdgeGlowRight.setSize(height, width);
                if(mEdgeGlowRight.draw(canvas))                
                {
                    invalidate();
                } //End block
                canvas.restoreToCount(restoreCount);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.046 -0400", hash_original_method = "10E81B579101690AB90AC933866D5438", hash_generated_method = "AC93524F57766AE921649C1D55CD89BC")
    private int clamp(int n, int my, int child) {
        addTaint(child);
        addTaint(my);
        addTaint(n);
        if(my >= child || n < 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1694740569 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_67815787 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_67815787;
        } //End block
        if((my + n) > child)        
        {
            int var302FB6F2915B3D0C2F6551AE59DAFA4C_1606892669 = (child - my);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_501193757 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_501193757;
        } //End block
        int var7B8B965AD4BCA0E41AB51DE7B31363A1_693164153 = (n);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1266370691 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1266370691;
        // ---------- Original Method ----------
        //if (my >= child || n < 0) {
            //return 0;
        //}
        //if ((my + n) > child) {
            //return child - my;
        //}
        //return n;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.046 -0400", hash_original_field = "592B4C751C2D22CD7D43317BD897714A", hash_generated_field = "4083FF51B3491C57DFF4E035C0066C80")

    private static final int ANIMATED_SCROLL_GAP = ScrollView.ANIMATED_SCROLL_GAP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.046 -0400", hash_original_field = "CA227357940761AB7254479B7BD99962", hash_generated_field = "49356EE5727E8BD04682A1AF4FB39A2B")

    private static final float MAX_SCROLL_FACTOR = ScrollView.MAX_SCROLL_FACTOR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.046 -0400", hash_original_field = "7EF8B2C57AC3A1D5EC1190F4098C6121", hash_generated_field = "E2DAEB44FC73F85759FCDB42BA10BD3A")

    private static final int INVALID_POINTER = -1;
}

