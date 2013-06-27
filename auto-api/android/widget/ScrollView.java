package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.StrictMode;
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
import java.util.List;

public class ScrollView extends FrameLayout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.951 -0400", hash_original_field = "380EFAD062415C5D611446C1B15B307D", hash_generated_field = "507FF60BF6AED501221786F4F9B1C4CE")

    private long mLastScroll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.960 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "AFFA54D19F07A10EE8847CF76FC95323")

    private Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.960 -0400", hash_original_field = "360DD66618E954525BEA0D65B05DC7EC", hash_generated_field = "7106C69F4E49AB9D7F59F38965DF6036")

    private OverScroller mScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.960 -0400", hash_original_field = "89E135B7087DB76810F3F37EE0DAB560", hash_generated_field = "E572968A85247BF2ECB5635FFF539C2E")

    private EdgeEffect mEdgeGlowTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.960 -0400", hash_original_field = "289036755C83C8893D6004D3220BA45B", hash_generated_field = "D2A4A7BE91BF29EB90E114C9648825A6")

    private EdgeEffect mEdgeGlowBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.960 -0400", hash_original_field = "4925C8499D6FECBA832A37F55AA6C69B", hash_generated_field = "2D88D85D441545A6227529A03C0B4E71")

    private float mLastMotionY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.960 -0400", hash_original_field = "A43EC71B2E74CACC223B47379717A080", hash_generated_field = "9C16E67A6EDB3E799E01AFB02BCF7815")

    private boolean mIsLayoutDirty = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.960 -0400", hash_original_field = "8949A253727FAE7FB577F98D2A9463C2", hash_generated_field = "7E1EAB0DC4AB4B81BAB22B01D588949E")

    private View mChildToScrollTo = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.960 -0400", hash_original_field = "A8AB6008485C6E787B3DBB97D2050FF4", hash_generated_field = "40AA109CDE3739730D8C499D23D26FF1")

    private boolean mIsBeingDragged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.961 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.965 -0400", hash_original_field = "B3E3E62AA85A925921DCB2869A4E7017", hash_generated_field = "16DDF79C39D64DD0F8B72040D2242A75")

    @ViewDebug.ExportedProperty(category = "layout") private boolean mFillViewport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.965 -0400", hash_original_field = "581BD96ACB5FC0F4F529183E58EA63B2", hash_generated_field = "EA3AE5CC17F6060C1DBAA2AAAFFFC35C")

    private boolean mSmoothScrollingEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.965 -0400", hash_original_field = "3DFFFAD10926598D18EEC50D61DE79CA", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.965 -0400", hash_original_field = "30B0DF23DBDF2426D66E4D98494C369B", hash_generated_field = "7DBE1A18599B8760DC9B67AAFE3499E3")

    private int mMinimumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.965 -0400", hash_original_field = "1C66D9179508D091F8E90C9FEBAD15CA", hash_generated_field = "6F997413D0B227487940C402EB78A8FD")

    private int mMaximumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.965 -0400", hash_original_field = "7A5B6F76BA72A8D6AFCFCEA14B8C2556", hash_generated_field = "7B0107E1CAE9FFC281D766335539D7C4")

    private int mOverscrollDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.965 -0400", hash_original_field = "755491871A4FCE3E01181030F8FEB178", hash_generated_field = "06022A8A798B4C892D35D0FFB16D2FDF")

    private int mOverflingDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.965 -0400", hash_original_field = "D0F34CC6DB83FC46AEC38F19CA5CE138", hash_generated_field = "1B464B20D80463EC30779F63AB0559BD")

    private int mActivePointerId = INVALID_POINTER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.965 -0400", hash_original_field = "D2BBDD4FC0A41CFC280764A4FBDC4D52", hash_generated_field = "BA5EBFF9CCBAD624E5B38890A6227093")

    private StrictMode.Span mScrollStrictSpan = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.965 -0400", hash_original_field = "A914CE4AFB85B902CB007BE88097BB3F", hash_generated_field = "1B2DFB133C9B4AE33C58293244DDF261")

    private StrictMode.Span mFlingStrictSpan = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.965 -0400", hash_original_method = "4713E1355E9C805E185DB05E4B4B9810", hash_generated_method = "D94FF7D50EC38B3687BB3B0C7B5552B0")
    public  ScrollView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.966 -0400", hash_original_method = "D709104905B863FC98F9383546426518", hash_generated_method = "18D71EA425ED840CDB485C506CBAC309")
    public  ScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.scrollViewStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.966 -0400", hash_original_method = "A71F55C63B3167922F139A658C272800", hash_generated_method = "EB0C8CA81B970D9794FCDBDF1B03CD37")
    public  ScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initScrollView();
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.ScrollView, defStyle, 0);
        setFillViewport(a.getBoolean(R.styleable.ScrollView_fillViewport, false));
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
        //initScrollView();
        //TypedArray a =
            //context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.ScrollView, defStyle, 0);
        //setFillViewport(a.getBoolean(R.styleable.ScrollView_fillViewport, false));
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.966 -0400", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "AB5D4D394983A53942A03EE360A942C3")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1223543913 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1223543913;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.969 -0400", hash_original_method = "2B5BCBF9645A95C024C3D4122E8D2438", hash_generated_method = "9A1C83A277747C775116A379C35A96BD")
    @Override
    protected float getTopFadingEdgeStrength() {
        {
            boolean varF370735710C80808B6618BA2D491D045_631176371 = (getChildCount() == 0);
        } //End collapsed parenthetic
        int length;
        length = getVerticalFadingEdgeLength();
        float var546ADE640B6EDFBC8A086EF31347E768_1316506639 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1316506639;
        // ---------- Original Method ----------
        //if (getChildCount() == 0) {
            //return 0.0f;
        //}
        //final int length = getVerticalFadingEdgeLength();
        //if (mScrollY < length) {
            //return mScrollY / (float) length;
        //}
        //return 1.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.969 -0400", hash_original_method = "F0E4C184CA27C21FD42267E77DCA1374", hash_generated_method = "7F1132C188268681E3D925760531DB01")
    @Override
    protected float getBottomFadingEdgeStrength() {
        {
            boolean varF370735710C80808B6618BA2D491D045_211593138 = (getChildCount() == 0);
        } //End collapsed parenthetic
        int length;
        length = getVerticalFadingEdgeLength();
        int bottomEdge;
        bottomEdge = getHeight() - mPaddingBottom;
        int span;
        span = getChildAt(0).getBottom() - mScrollY - bottomEdge;
        float var546ADE640B6EDFBC8A086EF31347E768_1655728155 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1655728155;
        // ---------- Original Method ----------
        //if (getChildCount() == 0) {
            //return 0.0f;
        //}
        //final int length = getVerticalFadingEdgeLength();
        //final int bottomEdge = getHeight() - mPaddingBottom;
        //final int span = getChildAt(0).getBottom() - mScrollY - bottomEdge;
        //if (span < length) {
            //return span / (float) length;
        //}
        //return 1.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.971 -0400", hash_original_method = "13CC3D3BB67006B8B223FEAA5CEB8AD3", hash_generated_method = "6FF8EEE73642BF6CF38782F14C7407D8")
    public int getMaxScrollAmount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_176212211 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_176212211;
        // ---------- Original Method ----------
        //return (int) (MAX_SCROLL_FACTOR * (mBottom - mTop));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.971 -0400", hash_original_method = "02BBAF53D85E267FB240E2D4309C877F", hash_generated_method = "8A03164972DE1A24C8B4AD83E152C23B")
    private void initScrollView() {
        mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
        setWillNotDraw(false);
        ViewConfiguration configuration;
        configuration = ViewConfiguration.get(mContext);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.973 -0400", hash_original_method = "C2B46C856A31C41C5B4609404338EFA0", hash_generated_method = "9B0C68D61348AC4F925D825167E92D17")
    @Override
    public void addView(View child) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_537414107 = (getChildCount() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("ScrollView can host only one direct child");
            } //End block
        } //End collapsed parenthetic
        super.addView(child);
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("ScrollView can host only one direct child");
        //}
        //super.addView(child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.980 -0400", hash_original_method = "E948CE4EC40C516B64A70B82C4D41ABE", hash_generated_method = "3B28D25D1E46545CD862170C86A8E1A9")
    @Override
    public void addView(View child, int index) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1306779157 = (getChildCount() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("ScrollView can host only one direct child");
            } //End block
        } //End collapsed parenthetic
        super.addView(child, index);
        addTaint(child.getTaint());
        addTaint(index);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("ScrollView can host only one direct child");
        //}
        //super.addView(child, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.980 -0400", hash_original_method = "34A1DE7AC13648E903519BA7AEB15B21", hash_generated_method = "5AFBF0FD70E9A02B107F1718ECCFF209")
    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1802601326 = (getChildCount() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("ScrollView can host only one direct child");
            } //End block
        } //End collapsed parenthetic
        super.addView(child, params);
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("ScrollView can host only one direct child");
        //}
        //super.addView(child, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.981 -0400", hash_original_method = "363983D07DF3EAAC15B8A0529305BE77", hash_generated_method = "70BC3059F9CCA593FC3B30106DFC77C5")
    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1660753892 = (getChildCount() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("ScrollView can host only one direct child");
            } //End block
        } //End collapsed parenthetic
        super.addView(child, index, params);
        addTaint(child.getTaint());
        addTaint(index);
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("ScrollView can host only one direct child");
        //}
        //super.addView(child, index, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.981 -0400", hash_original_method = "F1DEDB4D65582CE354A1D843D55A4B55", hash_generated_method = "940C9D9CDBC259322182AB5FC8556C10")
    private boolean canScroll() {
        View child;
        child = getChildAt(0);
        {
            int childHeight;
            childHeight = child.getHeight();
            boolean var3A415DE46D6A024E28376F2A13A712DB_1055711806 = (getHeight() < childHeight + mPaddingTop + mPaddingBottom);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2040460666 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2040460666;
        // ---------- Original Method ----------
        //View child = getChildAt(0);
        //if (child != null) {
            //int childHeight = child.getHeight();
            //return getHeight() < childHeight + mPaddingTop + mPaddingBottom;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.981 -0400", hash_original_method = "801E6F065AC6A60CFB0DADB1E074F98E", hash_generated_method = "66BFAF3FF7DFCD0545D81971442BBDF8")
    public boolean isFillViewport() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1291362608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1291362608;
        // ---------- Original Method ----------
        //return mFillViewport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.982 -0400", hash_original_method = "D2588C7F74D0E18DF5DFA629FE7BF270", hash_generated_method = "2659D9B4D00861C682890CC931AD720B")
    public void setFillViewport(boolean fillViewport) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.982 -0400", hash_original_method = "D26C58327C0CB18AC1F62B7629FD16B1", hash_generated_method = "9D825E448E7982B22481676AE271FC4D")
    public boolean isSmoothScrollingEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1323772131 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1323772131;
        // ---------- Original Method ----------
        //return mSmoothScrollingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.982 -0400", hash_original_method = "63C96CE84D9CD60CA1FF4EF87D7FF4F5", hash_generated_method = "5C7F23BB3E765786BEE5D256B048D32A")
    public void setSmoothScrollingEnabled(boolean smoothScrollingEnabled) {
        mSmoothScrollingEnabled = smoothScrollingEnabled;
        // ---------- Original Method ----------
        //mSmoothScrollingEnabled = smoothScrollingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.997 -0400", hash_original_method = "1504CEEE6604563B648201D50795D68C", hash_generated_method = "23A8A6F0CE7FC0B2D5251A90CE903137")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int heightMode;
        heightMode = MeasureSpec.getMode(heightMeasureSpec);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1992090353 = (getChildCount() > 0);
            {
                View child;
                child = getChildAt(0);
                int height;
                height = getMeasuredHeight();
                {
                    boolean varEEEC94D0CC5FB640673872B86A985E2B_1506558201 = (child.getMeasuredHeight() < height);
                    {
                        FrameLayout.LayoutParams lp;
                        lp = (LayoutParams) child.getLayoutParams();
                        int childWidthMeasureSpec;
                        childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec,
                        mPaddingLeft + mPaddingRight, lp.width);
                        height -= mPaddingTop;
                        height -= mPaddingBottom;
                        int childHeightMeasureSpec;
                        childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
                        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.997 -0400", hash_original_method = "40D3C8E04EF2AEB04EFDF302E05EC516", hash_generated_method = "6E016E66F223C73B066E20295A339A4E")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        boolean var160A6DCE359009EE36E492A233BEB313_2074386899 = (super.dispatchKeyEvent(event) || executeKeyEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_961898788 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_961898788;
        // ---------- Original Method ----------
        //return super.dispatchKeyEvent(event) || executeKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.998 -0400", hash_original_method = "1E6EE1FACBE8E24D9D58E940A1542C55", hash_generated_method = "7FFCB8EDD2A40258A946DE44CF850CF5")
    public boolean executeKeyEvent(KeyEvent event) {
        mTempRect.setEmpty();
        {
            boolean varF142AAB9B9E2812C95D81D43568D13C8_1329431015 = (!canScroll());
            {
                {
                    boolean var2897164B636FEEE3DA92631EEF7087B0_526770464 = (isFocused() && event.getKeyCode() != KeyEvent.KEYCODE_BACK);
                    {
                        View currentFocused;
                        currentFocused = findFocus();
                        {
                            boolean varCCA9B61B8A448B09DE583C4C7BFDEFBB_2135038742 = (currentFocused == this);
                            currentFocused = null;
                        } //End collapsed parenthetic
                        View nextFocused;
                        nextFocused = FocusFinder.getInstance().findNextFocus(this,
                        currentFocused, View.FOCUS_DOWN);
                        boolean varD482CC356741D5879BD547A170E814F4_755400615 = (nextFocused != null
                        && nextFocused != this
                        && nextFocused.requestFocus(View.FOCUS_DOWN));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean handled;
        handled = false;
        {
            boolean varE78E9647F4429F5955AD42D05C6FEF7A_1176810978 = (event.getAction() == KeyEvent.ACTION_DOWN);
            {
                {
                    Object varA0761DC6508339A4AD5D875712ADE561_541380479 = (event.getKeyCode());
                    //Begin case KeyEvent.KEYCODE_DPAD_UP 
                    {
                        boolean var6263B7F37C2CF1348DCC37C937DB4EA5_1289604805 = (!event.isAltPressed());
                        {
                            handled = arrowScroll(View.FOCUS_UP);
                        } //End block
                        {
                            handled = fullScroll(View.FOCUS_UP);
                        } //End block
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_DPAD_UP 
                    //Begin case KeyEvent.KEYCODE_DPAD_DOWN 
                    {
                        boolean var6263B7F37C2CF1348DCC37C937DB4EA5_1048992629 = (!event.isAltPressed());
                        {
                            handled = arrowScroll(View.FOCUS_DOWN);
                        } //End block
                        {
                            handled = fullScroll(View.FOCUS_DOWN);
                        } //End block
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_DPAD_DOWN 
                    //Begin case KeyEvent.KEYCODE_SPACE 
                    pageScroll(event.isShiftPressed() ? View.FOCUS_UP : View.FOCUS_DOWN);
                    //End case KeyEvent.KEYCODE_SPACE 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_643168266 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_643168266;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.999 -0400", hash_original_method = "21B5B152D5EE02017A0CB65ECB9B3403", hash_generated_method = "7A2E029CEA1F5663329B868D4F081E60")
    private boolean inChild(int x, int y) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1630030842 = (getChildCount() > 0);
            {
                int scrollY;
                scrollY = mScrollY;
                View child;
                child = getChildAt(0);
                boolean varB6F197A68897B2FF8EC1E9EDD5403361_215676449 = (!(y < child.getTop() - scrollY
                    || y >= child.getBottom() - scrollY
                    || x < child.getLeft()
                    || x >= child.getRight()));
            } //End block
        } //End collapsed parenthetic
        addTaint(x);
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_385438720 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_385438720;
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //final int scrollY = mScrollY;
            //final View child = getChildAt(0);
            //return !(y < child.getTop() - scrollY
                    //|| y >= child.getBottom() - scrollY
                    //|| x < child.getLeft()
                    //|| x >= child.getRight());
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.999 -0400", hash_original_method = "2F2E3E2ED97C397B1954EFE1C35FD1EF", hash_generated_method = "D2F7B701FF4A7C7D5D9BBE60A4204A34")
    private void initOrResetVelocityTracker() {
        {
            mVelocityTracker = VelocityTracker.obtain();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.000 -0400", hash_original_method = "2C2F1E0A6C232182F8110D9EE75ED47E", hash_generated_method = "A47C5AEFF80C521B346EFD43CCEC463A")
    private void initVelocityTrackerIfNotExists() {
        {
            mVelocityTracker = VelocityTracker.obtain();
        } //End block
        // ---------- Original Method ----------
        //if (mVelocityTracker == null) {
            //mVelocityTracker = VelocityTracker.obtain();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.000 -0400", hash_original_method = "FC3B581D4963BCED4340031BA20C5421", hash_generated_method = "4A5B29B306AF5EDD25C8547D1436EB51")
    private void recycleVelocityTracker() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.000 -0400", hash_original_method = "C74400E8950C106883E854683AF24673", hash_generated_method = "9EE44C43E2819EE39A2C95C618F793B6")
    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        {
            recycleVelocityTracker();
        } //End block
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
        addTaint(disallowIntercept);
        // ---------- Original Method ----------
        //if (disallowIntercept) {
            //recycleVelocityTracker();
        //}
        //super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.089 -0400", hash_original_method = "A618CDF234D118EA8A225B0CD965AEA3", hash_generated_method = "E47FA98DBB0291C70824719D26D5D6A4")
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int action;
        action = ev.getAction();
        //Begin case MotionEvent.ACTION_MOVE 
        {
            int activePointerId;
            activePointerId = mActivePointerId;
            int pointerIndex;
            pointerIndex = ev.findPointerIndex(activePointerId);
            float y;
            y = ev.getY(pointerIndex);
            int yDiff;
            yDiff = (int) Math.abs(y - mLastMotionY);
            {
                mIsBeingDragged = true;
                mLastMotionY = y;
                initVelocityTrackerIfNotExists();
                mVelocityTracker.addMovement(ev);
                {
                    mScrollStrictSpan = StrictMode.enterCriticalSpan("ScrollView-scroll");
                } //End block
            } //End block
        } //End block
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_DOWN 
        {
            float y;
            y = ev.getY();
            {
                boolean varFF34B1086FC4594476FFD6F360BBB78C_1111530337 = (!inChild((int) ev.getX(), (int) y));
                {
                    mIsBeingDragged = false;
                    recycleVelocityTracker();
                } //End block
            } //End collapsed parenthetic
            mLastMotionY = y;
            mActivePointerId = ev.getPointerId(0);
            initOrResetVelocityTracker();
            mVelocityTracker.addMovement(ev);
            mIsBeingDragged = !mScroller.isFinished();
            {
                mScrollStrictSpan = StrictMode.enterCriticalSpan("ScrollView-scroll");
            } //End block
        } //End block
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        mIsBeingDragged = false;
        //End case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        mActivePointerId = INVALID_POINTER;
        //End case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        recycleVelocityTracker();
        //End case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        {
            boolean var5A644DDFA364D0381E7012BF55F348DC_1746885243 = (mScroller.springBack(mScrollX, mScrollY, 0, 0, 0, getScrollRange()));
            {
                invalidate();
            } //End block
        } //End collapsed parenthetic
        //End case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_POINTER_UP 
        onSecondaryPointerUp(ev);
        //End case MotionEvent.ACTION_POINTER_UP 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1056106412 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1056106412;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.094 -0400", hash_original_method = "83F23D23BD0BAB2CB063E24A3B111651", hash_generated_method = "FC6258795A52BE60A8AACF0832C85A01")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        initVelocityTrackerIfNotExists();
        mVelocityTracker.addMovement(ev);
        int action;
        action = ev.getAction();
        //Begin case MotionEvent.ACTION_DOWN 
        {
            mIsBeingDragged = getChildCount() != 0;
            {
                boolean var11F6C92CC339B9B3B7C0C85A8DBD1165_859762713 = (!mScroller.isFinished());
                {
                    mScroller.abortAnimation();
                    {
                        mFlingStrictSpan.finish();
                        mFlingStrictSpan = null;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            mLastMotionY = ev.getY();
            mActivePointerId = ev.getPointerId(0);
        } //End block
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_MOVE 
        {
            int activePointerIndex;
            activePointerIndex = ev.findPointerIndex(mActivePointerId);
            float y;
            y = ev.getY(activePointerIndex);
            int deltaY;
            deltaY = (int) (mLastMotionY - y);
            mLastMotionY = y;
            int oldX;
            oldX = mScrollX;
            int oldY;
            oldY = mScrollY;
            int range;
            range = getScrollRange();
            int overscrollMode;
            overscrollMode = getOverScrollMode();
            boolean canOverscroll;
            canOverscroll = overscrollMode == OVER_SCROLL_ALWAYS ||
                            (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && range > 0);
            {
                boolean var670E8200B9D4E089C7377D895DE2F86E_1623418530 = (overScrollBy(0, deltaY, 0, mScrollY,
                            0, range, 0, mOverscrollDistance, true));
                {
                    mVelocityTracker.clear();
                } //End block
            } //End collapsed parenthetic
            onScrollChanged(mScrollX, mScrollY, oldX, oldY);
            {
                int pulledToY;
                pulledToY = oldY + deltaY;
                {
                    mEdgeGlowTop.onPull((float) deltaY / getHeight());
                    {
                        boolean varE6213428B20479BD32BF17B140F5ED52_116635904 = (!mEdgeGlowBottom.isFinished());
                        {
                            mEdgeGlowBottom.onRelease();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    mEdgeGlowBottom.onPull((float) deltaY / getHeight());
                    {
                        boolean var5D6A56784A8F83A042E55ED0998DBE18_249719768 = (!mEdgeGlowTop.isFinished());
                        {
                            mEdgeGlowTop.onRelease();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var4BAAB9D93C535A28BF0C04887423354C_2111632159 = (mEdgeGlowTop != null
                                && (!mEdgeGlowTop.isFinished() || !mEdgeGlowBottom.isFinished()));
                    {
                        invalidate();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_UP 
        {
            VelocityTracker velocityTracker;
            velocityTracker = mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
            int initialVelocity;
            initialVelocity = (int) velocityTracker.getYVelocity(mActivePointerId);
            {
                boolean var9C190A50DA656473F4A85C2EF380F022_1358470004 = (getChildCount() > 0);
                {
                    {
                        boolean varCB55D3BE2E93A2FD55EF78A581740AFC_577213654 = ((Math.abs(initialVelocity) > mMinimumVelocity));
                        {
                            fling(-initialVelocity);
                        } //End block
                        {
                            {
                                boolean varC93C7034440DD4C8753F4F2114A84A37_1516777264 = (mScroller.springBack(mScrollX, mScrollY, 0, 0, 0,
                                    getScrollRange()));
                                {
                                    invalidate();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            mActivePointerId = INVALID_POINTER;
            endDrag();
        } //End block
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_CANCEL 
        {
            boolean var9286919EB531712C93F03BFB604683F8_605791440 = (mIsBeingDragged && getChildCount() > 0);
            {
                {
                    boolean var0B94B4CD263DE1DB92077C5CA547FAC2_1598080228 = (mScroller.springBack(mScrollX, mScrollY, 0, 0, 0, getScrollRange()));
                    {
                        invalidate();
                    } //End block
                } //End collapsed parenthetic
                mActivePointerId = INVALID_POINTER;
                endDrag();
            } //End block
        } //End collapsed parenthetic
        //End case MotionEvent.ACTION_CANCEL 
        //Begin case MotionEvent.ACTION_POINTER_DOWN 
        {
            int index;
            index = ev.getActionIndex();
            float y;
            y = ev.getY(index);
            mLastMotionY = y;
            mActivePointerId = ev.getPointerId(index);
        } //End block
        //End case MotionEvent.ACTION_POINTER_DOWN 
        //Begin case MotionEvent.ACTION_POINTER_UP 
        onSecondaryPointerUp(ev);
        //End case MotionEvent.ACTION_POINTER_UP 
        //Begin case MotionEvent.ACTION_POINTER_UP 
        mLastMotionY = ev.getY(ev.findPointerIndex(mActivePointerId));
        //End case MotionEvent.ACTION_POINTER_UP 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1654655533 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1654655533;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.101 -0400", hash_original_method = "1724FA32F4E11B8EDA6825E1236F6DA2", hash_generated_method = "C11C6C36453DB2D2A4F3F98915CC42BB")
    private void onSecondaryPointerUp(MotionEvent ev) {
        int pointerIndex;
        pointerIndex = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >>
                MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        int pointerId;
        pointerId = ev.getPointerId(pointerIndex);
        {
            int newPointerIndex;
            newPointerIndex = 1;
            newPointerIndex = 0;
            mLastMotionY = ev.getY(newPointerIndex);
            mActivePointerId = ev.getPointerId(newPointerIndex);
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
            //mLastMotionY = ev.getY(newPointerIndex);
            //mActivePointerId = ev.getPointerId(newPointerIndex);
            //if (mVelocityTracker != null) {
                //mVelocityTracker.clear();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.105 -0400", hash_original_method = "ABBC11F59DDEDBBBBFE897034F702501", hash_generated_method = "29415549025E35D4373D58C1546F1084")
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varB5CEEFE1A0B0FE6CF2A2378211A03C4D_1310637522 = ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0);
            {
                {
                    Object varC2BF00F96F1D1B1ABEF4B0E3FC4FE9EC_1260866567 = (event.getAction());
                    //Begin case MotionEvent.ACTION_SCROLL 
                    {
                        {
                            float vscroll;
                            vscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                            {
                                int delta;
                                delta = (int) (vscroll * getVerticalScrollFactor());
                                int range;
                                range = getScrollRange();
                                int oldScrollY;
                                oldScrollY = mScrollY;
                                int newScrollY;
                                newScrollY = oldScrollY - delta;
                                {
                                    newScrollY = 0;
                                } //End block
                                {
                                    newScrollY = range;
                                } //End block
                                {
                                    super.scrollTo(mScrollX, newScrollY);
                                } //End block
                            } //End block
                        } //End block
                    } //End block
                    //End case MotionEvent.ACTION_SCROLL 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var32C1E3DF40BCC120C79428C7AEB27DD1_1546063846 = (super.onGenericMotionEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1658360165 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1658360165;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.106 -0400", hash_original_method = "CC5D228BD55E3E42D5A6CE954C441DF3", hash_generated_method = "6223908F3963BACE851809D786E94F05")
    @Override
    protected void onOverScrolled(int scrollX, int scrollY,
            boolean clampedX, boolean clampedY) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var2844BA5E42FD344CC642021B350DFDAC_331780798 = (!mScroller.isFinished());
            {
                mScrollX = scrollX;
                mScrollY = scrollY;
                invalidateParentIfNeeded();
                {
                    mScroller.springBack(mScrollX, mScrollY, 0, 0, 0, getScrollRange());
                } //End block
            } //End block
            {
                super.scrollTo(scrollX, scrollY);
            } //End block
        } //End collapsed parenthetic
        awakenScrollBars();
        addTaint(scrollX);
        addTaint(scrollY);
        addTaint(clampedX);
        addTaint(clampedY);
        // ---------- Original Method ----------
        //if (!mScroller.isFinished()) {
            //mScrollX = scrollX;
            //mScrollY = scrollY;
            //invalidateParentIfNeeded();
            //if (clampedY) {
                //mScroller.springBack(mScrollX, mScrollY, 0, 0, 0, getScrollRange());
            //}
        //} else {
            //super.scrollTo(scrollX, scrollY);
        //}
        //awakenScrollBars();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.114 -0400", hash_original_method = "AF8EC74B0AD4D69DC5ACACFC8749064F", hash_generated_method = "61EE9670444DDDD9440F00D0D1F34A0C")
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onInitializeAccessibilityNodeInfo(info);
        info.setScrollable(getScrollRange() > 0);
        addTaint(info.getTaint());
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityNodeInfo(info);
        //info.setScrollable(getScrollRange() > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.115 -0400", hash_original_method = "F1695E9318A6A21B761B35BD458E866B", hash_generated_method = "7D5318F1535F679E406E64E8A05CBE61")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onInitializeAccessibilityEvent(event);
        boolean scrollable;
        scrollable = getScrollRange() > 0;
        event.setScrollable(scrollable);
        event.setScrollX(mScrollX);
        event.setScrollY(mScrollY);
        event.setMaxScrollX(mScrollX);
        event.setMaxScrollY(getScrollRange());
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //final boolean scrollable = getScrollRange() > 0;
        //event.setScrollable(scrollable);
        //event.setScrollX(mScrollX);
        //event.setScrollY(mScrollY);
        //event.setMaxScrollX(mScrollX);
        //event.setMaxScrollY(getScrollRange());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.117 -0400", hash_original_method = "54B8D0E6795D053FB63A6E55BD2EA0C5", hash_generated_method = "05C90F5A26206D5E15028BE61DEF962F")
    private int getScrollRange() {
        int scrollRange;
        scrollRange = 0;
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1770123581 = (getChildCount() > 0);
            {
                View child;
                child = getChildAt(0);
                scrollRange = Math.max(0,
                    child.getHeight() - (getHeight() - mPaddingBottom - mPaddingTop));
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1654532759 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1654532759;
        // ---------- Original Method ----------
        //int scrollRange = 0;
        //if (getChildCount() > 0) {
            //View child = getChildAt(0);
            //scrollRange = Math.max(0,
                    //child.getHeight() - (getHeight() - mPaddingBottom - mPaddingTop));
        //}
        //return scrollRange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.122 -0400", hash_original_method = "CCA8F1BE638FE2EC5E8781CBB11ADD24", hash_generated_method = "D5BBB40297C1AD5FD35FFEDAB3A138BD")
    private View findFocusableViewInMyBounds(final boolean topFocus,
            final int top, View preferredFocusable) {
        View varB4EAC82CA7396A68D541C85D26508E83_787849120 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_507202835 = null; //Variable for return #2
        int fadingEdgeLength;
        fadingEdgeLength = getVerticalFadingEdgeLength() / 2;
        int topWithoutFadingEdge;
        topWithoutFadingEdge = top + fadingEdgeLength;
        int bottomWithoutFadingEdge;
        bottomWithoutFadingEdge = top + getHeight() - fadingEdgeLength;
        {
            boolean var779C321780A81D8A63D26CAE3AB982D5_715552442 = ((preferredFocusable != null)
                && (preferredFocusable.getTop() < bottomWithoutFadingEdge)
                && (preferredFocusable.getBottom() > topWithoutFadingEdge));
            {
                varB4EAC82CA7396A68D541C85D26508E83_787849120 = preferredFocusable;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_507202835 = findFocusableViewInBounds(topFocus, topWithoutFadingEdge,
                bottomWithoutFadingEdge);
        addTaint(topFocus);
        addTaint(top);
        addTaint(preferredFocusable.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1792755237; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1792755237 = varB4EAC82CA7396A68D541C85D26508E83_787849120;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1792755237 = varB4EAC82CA7396A68D541C85D26508E83_507202835;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1792755237.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1792755237;
        // ---------- Original Method ----------
        //final int fadingEdgeLength = getVerticalFadingEdgeLength() / 2;
        //final int topWithoutFadingEdge = top + fadingEdgeLength;
        //final int bottomWithoutFadingEdge = top + getHeight() - fadingEdgeLength;
        //if ((preferredFocusable != null)
                //&& (preferredFocusable.getTop() < bottomWithoutFadingEdge)
                //&& (preferredFocusable.getBottom() > topWithoutFadingEdge)) {
            //return preferredFocusable;
        //}
        //return findFocusableViewInBounds(topFocus, topWithoutFadingEdge,
                //bottomWithoutFadingEdge);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.124 -0400", hash_original_method = "78998B2E5B42D469D0E131861596BD99", hash_generated_method = "B5122549706341B8564C8CEB4F3F31CA")
    private View findFocusableViewInBounds(boolean topFocus, int top, int bottom) {
        View varB4EAC82CA7396A68D541C85D26508E83_1035528469 = null; //Variable for return #1
        List<View> focusables;
        focusables = getFocusables(View.FOCUS_FORWARD);
        View focusCandidate;
        focusCandidate = null;
        boolean foundFullyContainedFocusable;
        foundFullyContainedFocusable = false;
        int count;
        count = focusables.size();
        {
            int i;
            i = 0;
            {
                View view;
                view = focusables.get(i);
                int viewTop;
                viewTop = view.getTop();
                int viewBottom;
                viewBottom = view.getBottom();
                {
                    boolean viewIsFullyContained;
                    viewIsFullyContained = (top < viewTop) &&
                        (viewBottom < bottom);
                    {
                        focusCandidate = view;
                        foundFullyContainedFocusable = viewIsFullyContained;
                    } //End block
                    {
                        boolean viewIsCloserToBoundary;
                        viewIsCloserToBoundary = (topFocus && viewTop < focusCandidate.getTop()) ||
                                    (!topFocus && viewBottom > focusCandidate
                                            .getBottom());
                        {
                            {
                                focusCandidate = view;
                            } //End block
                        } //End block
                        {
                            {
                                focusCandidate = view;
                                foundFullyContainedFocusable = true;
                            } //End block
                            {
                                focusCandidate = view;
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1035528469 = focusCandidate;
        addTaint(topFocus);
        addTaint(top);
        addTaint(bottom);
        varB4EAC82CA7396A68D541C85D26508E83_1035528469.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1035528469;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.127 -0400", hash_original_method = "8096444783AE8C9AF2A604C00C6FDBC2", hash_generated_method = "28BC1389F3B2CB9C269F46548BE42D92")
    public boolean pageScroll(int direction) {
        boolean down;
        down = direction == View.FOCUS_DOWN;
        int height;
        height = getHeight();
        {
            mTempRect.top = getScrollY() + height;
            int count;
            count = getChildCount();
            {
                View view;
                view = getChildAt(count - 1);
                {
                    boolean varED85C349B0DA33BB45D7B420A69B2E3A_1280879133 = (mTempRect.top + height > view.getBottom());
                    {
                        mTempRect.top = view.getBottom() - height;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            mTempRect.top = getScrollY() - height;
            {
                mTempRect.top = 0;
            } //End block
        } //End block
        mTempRect.bottom = mTempRect.top + height;
        boolean var39A84547F8736C141B73A0089E5E641A_355264247 = (scrollAndFocus(direction, mTempRect.top, mTempRect.bottom));
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1836871539 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1836871539;
        // ---------- Original Method ----------
        //boolean down = direction == View.FOCUS_DOWN;
        //int height = getHeight();
        //if (down) {
            //mTempRect.top = getScrollY() + height;
            //int count = getChildCount();
            //if (count > 0) {
                //View view = getChildAt(count - 1);
                //if (mTempRect.top + height > view.getBottom()) {
                    //mTempRect.top = view.getBottom() - height;
                //}
            //}
        //} else {
            //mTempRect.top = getScrollY() - height;
            //if (mTempRect.top < 0) {
                //mTempRect.top = 0;
            //}
        //}
        //mTempRect.bottom = mTempRect.top + height;
        //return scrollAndFocus(direction, mTempRect.top, mTempRect.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.136 -0400", hash_original_method = "E10B42C26E723F278A5695B0C5DAB2DB", hash_generated_method = "70B92C2ABD83F71F227A1BBEDE7E902C")
    public boolean fullScroll(int direction) {
        boolean down;
        down = direction == View.FOCUS_DOWN;
        int height;
        height = getHeight();
        mTempRect.top = 0;
        mTempRect.bottom = height;
        {
            int count;
            count = getChildCount();
            {
                View view;
                view = getChildAt(count - 1);
                mTempRect.bottom = view.getBottom() + mPaddingBottom;
                mTempRect.top = mTempRect.bottom - height;
            } //End block
        } //End block
        boolean var39A84547F8736C141B73A0089E5E641A_1536604561 = (scrollAndFocus(direction, mTempRect.top, mTempRect.bottom));
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1518039625 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1518039625;
        // ---------- Original Method ----------
        //boolean down = direction == View.FOCUS_DOWN;
        //int height = getHeight();
        //mTempRect.top = 0;
        //mTempRect.bottom = height;
        //if (down) {
            //int count = getChildCount();
            //if (count > 0) {
                //View view = getChildAt(count - 1);
                //mTempRect.bottom = view.getBottom() + mPaddingBottom;
                //mTempRect.top = mTempRect.bottom - height;
            //}
        //}
        //return scrollAndFocus(direction, mTempRect.top, mTempRect.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.136 -0400", hash_original_method = "AEE85E195E488E817C7C5FD2FB4EC0FB", hash_generated_method = "672289F6520DD12C7F553B89C4D1F47A")
    private boolean scrollAndFocus(int direction, int top, int bottom) {
        boolean handled;
        handled = true;
        int height;
        height = getHeight();
        int containerTop;
        containerTop = getScrollY();
        int containerBottom;
        containerBottom = containerTop + height;
        boolean up;
        up = direction == View.FOCUS_UP;
        View newFocused;
        newFocused = findFocusableViewInBounds(up, top, bottom);
        {
            newFocused = this;
        } //End block
        {
            handled = false;
        } //End block
        {
            int delta;
            delta = (top - containerTop);
            delta = (bottom - containerBottom);
            doScrollY(delta);
        } //End block
        {
            boolean var2DF5574E3AD9AB6AAA9DDD6415AB9F2D_437410617 = (newFocused != findFocus());
            newFocused.requestFocus(direction);
        } //End collapsed parenthetic
        addTaint(direction);
        addTaint(top);
        addTaint(bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_480126169 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_480126169;
        // ---------- Original Method ----------
        //boolean handled = true;
        //int height = getHeight();
        //int containerTop = getScrollY();
        //int containerBottom = containerTop + height;
        //boolean up = direction == View.FOCUS_UP;
        //View newFocused = findFocusableViewInBounds(up, top, bottom);
        //if (newFocused == null) {
            //newFocused = this;
        //}
        //if (top >= containerTop && bottom <= containerBottom) {
            //handled = false;
        //} else {
            //int delta = up ? (top - containerTop) : (bottom - containerBottom);
            //doScrollY(delta);
        //}
        //if (newFocused != findFocus()) newFocused.requestFocus(direction);
        //return handled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.141 -0400", hash_original_method = "99A4FFBBF0B3182EC320D3CC49E9281B", hash_generated_method = "E911C01EF31B2962B1EBC82B514CEE6D")
    public boolean arrowScroll(int direction) {
        View currentFocused;
        currentFocused = findFocus();
        {
            boolean varF85CA3EE0100E1E3C5B0606F6BE9D9A9_411122612 = (currentFocused == this);
            currentFocused = null;
        } //End collapsed parenthetic
        View nextFocused;
        nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused, direction);
        int maxJump;
        maxJump = getMaxScrollAmount();
        {
            boolean var9D8E7BEB7B2A9A39F141F9B559F28F2E_1201008144 = (nextFocused != null && isWithinDeltaOfScreen(nextFocused, maxJump, getHeight()));
            {
                nextFocused.getDrawingRect(mTempRect);
                offsetDescendantRectToMyCoords(nextFocused, mTempRect);
                int scrollDelta;
                scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
                doScrollY(scrollDelta);
                nextFocused.requestFocus(direction);
            } //End block
            {
                int scrollDelta;
                scrollDelta = maxJump;
                {
                    boolean var63FC15BACC5B673A5F772C0D7C31E719_382853616 = (direction == View.FOCUS_UP && getScrollY() < scrollDelta);
                    {
                        scrollDelta = getScrollY();
                    } //End block
                    {
                        {
                            boolean varB8CB178E8413E8F52B580007177C5576_1648522625 = (getChildCount() > 0);
                            {
                                int daBottom;
                                daBottom = getChildAt(0).getBottom();
                                int screenBottom;
                                screenBottom = getScrollY() + getHeight() - mPaddingBottom;
                                {
                                    scrollDelta = daBottom - screenBottom;
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                doScrollY(direction == View.FOCUS_DOWN ? scrollDelta : -scrollDelta);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var42D708BBCBC43DF6E5AC106D419B282D_66704840 = (currentFocused != null && currentFocused.isFocused()
                && isOffScreen(currentFocused));
            {
                int descendantFocusability;
                descendantFocusability = getDescendantFocusability();
                setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
                requestFocus();
                setDescendantFocusability(descendantFocusability);
            } //End block
        } //End collapsed parenthetic
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1780372642 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1780372642;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.142 -0400", hash_original_method = "98AD346ACFBFFAEC79BE4B86F94546B3", hash_generated_method = "51C6AF5A0C04B630D2A2B8F4B2CE422D")
    private boolean isOffScreen(View descendant) {
        boolean varE152D8C04578A7B6775C0B5DD4F62EE3_1599902778 = (!isWithinDeltaOfScreen(descendant, 0, getHeight()));
        addTaint(descendant.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_212255608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_212255608;
        // ---------- Original Method ----------
        //return !isWithinDeltaOfScreen(descendant, 0, getHeight());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.151 -0400", hash_original_method = "472E587EAA6D318183AF3AB1B7CEF83F", hash_generated_method = "6B120D53A1C9429E702C9F642BABA297")
    private boolean isWithinDeltaOfScreen(View descendant, int delta, int height) {
        descendant.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(descendant, mTempRect);
        boolean varF9194AE0C6867682D5312FCB54F0ABEF_491255995 = ((mTempRect.bottom + delta) >= getScrollY()
                && (mTempRect.top - delta) <= (getScrollY() + height));
        addTaint(descendant.getTaint());
        addTaint(delta);
        addTaint(height);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_567409128 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_567409128;
        // ---------- Original Method ----------
        //descendant.getDrawingRect(mTempRect);
        //offsetDescendantRectToMyCoords(descendant, mTempRect);
        //return (mTempRect.bottom + delta) >= getScrollY()
                //&& (mTempRect.top - delta) <= (getScrollY() + height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.152 -0400", hash_original_method = "8E606864EB91DBB174E2D5FEBC80C80F", hash_generated_method = "C9EFDA9264F7B5DABCE5928AE922DAF5")
    private void doScrollY(int delta) {
        {
            {
                smoothScrollBy(0, delta);
            } //End block
            {
                scrollBy(0, delta);
            } //End block
        } //End block
        addTaint(delta);
        // ---------- Original Method ----------
        //if (delta != 0) {
            //if (mSmoothScrollingEnabled) {
                //smoothScrollBy(0, delta);
            //} else {
                //scrollBy(0, delta);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.152 -0400", hash_original_method = "2EB75EC7C5D47510D212013AE17ECAD9", hash_generated_method = "3B9FCF7F6628298511FFDB0B88B7A304")
    public final void smoothScrollBy(int dx, int dy) {
        {
            boolean varF370735710C80808B6618BA2D491D045_844858672 = (getChildCount() == 0);
        } //End collapsed parenthetic
        long duration;
        duration = AnimationUtils.currentAnimationTimeMillis() - mLastScroll;
        {
            int height;
            height = getHeight() - mPaddingBottom - mPaddingTop;
            int bottom;
            bottom = getChildAt(0).getHeight();
            int maxY;
            maxY = Math.max(0, bottom - height);
            int scrollY;
            scrollY = mScrollY;
            dy = Math.max(0, Math.min(scrollY + dy, maxY)) - scrollY;
            mScroller.startScroll(mScrollX, scrollY, 0, dy);
            invalidate();
        } //End block
        {
            {
                boolean var11F6C92CC339B9B3B7C0C85A8DBD1165_919473624 = (!mScroller.isFinished());
                {
                    mScroller.abortAnimation();
                    {
                        mFlingStrictSpan.finish();
                        mFlingStrictSpan = null;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            scrollBy(dx, dy);
        } //End block
        mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        addTaint(dx);
        addTaint(dy);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.153 -0400", hash_original_method = "EED648F6788EFF0F67B65ABAA0DE4CF2", hash_generated_method = "DA73281470CE7C276C318CD6CA129252")
    public final void smoothScrollTo(int x, int y) {
        smoothScrollBy(x - mScrollX, y - mScrollY);
        addTaint(x);
        addTaint(y);
        // ---------- Original Method ----------
        //smoothScrollBy(x - mScrollX, y - mScrollY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.153 -0400", hash_original_method = "91313F7EB1086727A920BA0C858900A2", hash_generated_method = "9B50BB29B88734403F46549CAC6D1B17")
    @Override
    protected int computeVerticalScrollRange() {
        int count;
        count = getChildCount();
        int contentHeight;
        contentHeight = getHeight() - mPaddingBottom - mPaddingTop;
        int scrollRange;
        scrollRange = getChildAt(0).getBottom();
        int scrollY;
        scrollY = mScrollY;
        int overscrollBottom;
        overscrollBottom = Math.max(0, scrollRange - contentHeight);
        {
            scrollRange -= scrollY;
        } //End block
        {
            scrollRange += scrollY - overscrollBottom;
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1392841504 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1392841504;
        // ---------- Original Method ----------
        //final int count = getChildCount();
        //final int contentHeight = getHeight() - mPaddingBottom - mPaddingTop;
        //if (count == 0) {
            //return contentHeight;
        //}
        //int scrollRange = getChildAt(0).getBottom();
        //final int scrollY = mScrollY;
        //final int overscrollBottom = Math.max(0, scrollRange - contentHeight);
        //if (scrollY < 0) {
            //scrollRange -= scrollY;
        //} else if (scrollY > overscrollBottom) {
            //scrollRange += scrollY - overscrollBottom;
        //}
        //return scrollRange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.153 -0400", hash_original_method = "3295CF5A20E98E4F1F0B32253FD00545", hash_generated_method = "FB737F2D423D36D88A69CC35AF1B1BC7")
    @Override
    protected int computeVerticalScrollOffset() {
        int varEB30566907E969E358CA3C9E47523092_82376315 = (Math.max(0, super.computeVerticalScrollOffset()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1078033543 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1078033543;
        // ---------- Original Method ----------
        //return Math.max(0, super.computeVerticalScrollOffset());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.155 -0400", hash_original_method = "A9DFCA2E7D027D85128F33708BC045A3", hash_generated_method = "B462C9219CC911AF0C6EBBAF8B6AC5F3")
    @Override
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        ViewGroup.LayoutParams lp;
        lp = child.getLayoutParams();
        int childWidthMeasureSpec;
        int childHeightMeasureSpec;
        childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec, mPaddingLeft
                + mPaddingRight, lp.width);
        childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        addTaint(child.getTaint());
        addTaint(parentWidthMeasureSpec);
        addTaint(parentHeightMeasureSpec);
        // ---------- Original Method ----------
        //ViewGroup.LayoutParams lp = child.getLayoutParams();
        //int childWidthMeasureSpec;
        //int childHeightMeasureSpec;
        //childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec, mPaddingLeft
                //+ mPaddingRight, lp.width);
        //childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        //child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.155 -0400", hash_original_method = "39312C7B222B807E39D76A29FDE3363F", hash_generated_method = "F64125A211917F19C0D14D9E76A7D24E")
    @Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed,
            int parentHeightMeasureSpec, int heightUsed) {
        MarginLayoutParams lp;
        lp = (MarginLayoutParams) child.getLayoutParams();
        int childWidthMeasureSpec;
        childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                mPaddingLeft + mPaddingRight + lp.leftMargin + lp.rightMargin
                        + widthUsed, lp.width);
        int childHeightMeasureSpec;
        childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
                lp.topMargin + lp.bottomMargin, MeasureSpec.UNSPECIFIED);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        addTaint(child.getTaint());
        addTaint(parentWidthMeasureSpec);
        addTaint(widthUsed);
        addTaint(parentHeightMeasureSpec);
        addTaint(heightUsed);
        // ---------- Original Method ----------
        //final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        //final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                //mPaddingLeft + mPaddingRight + lp.leftMargin + lp.rightMargin
                        //+ widthUsed, lp.width);
        //final int childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
                //lp.topMargin + lp.bottomMargin, MeasureSpec.UNSPECIFIED);
        //child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.156 -0400", hash_original_method = "71999091E2F6915A9DB2336BBDDFAF94", hash_generated_method = "754762382FA2F67A33DBB2B5655E3D94")
    @Override
    public void computeScroll() {
        {
            boolean varE7DE5EF6873640B86AA94D9EE969CCF1_1873092402 = (mScroller.computeScrollOffset());
            {
                int oldX;
                oldX = mScrollX;
                int oldY;
                oldY = mScrollY;
                int x;
                x = mScroller.getCurrX();
                int y;
                y = mScroller.getCurrY();
                {
                    int range;
                    range = getScrollRange();
                    int overscrollMode;
                    overscrollMode = getOverScrollMode();
                    boolean canOverscroll;
                    canOverscroll = overscrollMode == OVER_SCROLL_ALWAYS ||
                        (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && range > 0);
                    overScrollBy(x - oldX, y - oldY, oldX, oldY, 0, range,
                        0, mOverflingDistance, false);
                    onScrollChanged(mScrollX, mScrollY, oldX, oldY);
                    {
                        {
                            mEdgeGlowTop.onAbsorb((int) mScroller.getCurrVelocity());
                        } //End block
                        {
                            mEdgeGlowBottom.onAbsorb((int) mScroller.getCurrVelocity());
                        } //End block
                    } //End block
                } //End block
                awakenScrollBars();
                postInvalidate();
            } //End block
            {
                {
                    mFlingStrictSpan.finish();
                    mFlingStrictSpan = null;
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.164 -0400", hash_original_method = "356AAB4A47E20FEC6EFC92C05FCA16CC", hash_generated_method = "A31B5CD8BB12240C14EFAAB9E55A8838")
    private void scrollToChild(View child) {
        child.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(child, mTempRect);
        int scrollDelta;
        scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
        {
            scrollBy(0, scrollDelta);
        } //End block
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //child.getDrawingRect(mTempRect);
        //offsetDescendantRectToMyCoords(child, mTempRect);
        //int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
        //if (scrollDelta != 0) {
            //scrollBy(0, scrollDelta);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.168 -0400", hash_original_method = "D69703D23BD1E07705411D82E1BC609A", hash_generated_method = "517704A6E6DA9A20043BFD6518DB1BED")
    private boolean scrollToChildRect(Rect rect, boolean immediate) {
        int delta;
        delta = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean scroll;
        scroll = delta != 0;
        {
            {
                scrollBy(0, delta);
            } //End block
            {
                smoothScrollBy(0, delta);
            } //End block
        } //End block
        addTaint(rect.getTaint());
        addTaint(immediate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1410630359 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1410630359;
        // ---------- Original Method ----------
        //final int delta = computeScrollDeltaToGetChildRectOnScreen(rect);
        //final boolean scroll = delta != 0;
        //if (scroll) {
            //if (immediate) {
                //scrollBy(0, delta);
            //} else {
                //smoothScrollBy(0, delta);
            //}
        //}
        //return scroll;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.169 -0400", hash_original_method = "8A5FFBB9A861965CD3F605D3125E7C0B", hash_generated_method = "7DFFB1715EFED6ADDF2661938397F027")
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        {
            boolean varF370735710C80808B6618BA2D491D045_1417094095 = (getChildCount() == 0);
        } //End collapsed parenthetic
        int height;
        height = getHeight();
        int screenTop;
        screenTop = getScrollY();
        int screenBottom;
        screenBottom = screenTop + height;
        int fadingEdge;
        fadingEdge = getVerticalFadingEdgeLength();
        {
            screenTop += fadingEdge;
        } //End block
        {
            boolean var21EF5215D3173B9EEA5879484954AC40_398111897 = (rect.bottom < getChildAt(0).getHeight());
            {
                screenBottom -= fadingEdge;
            } //End block
        } //End collapsed parenthetic
        int scrollYDelta;
        scrollYDelta = 0;
        {
            {
                boolean var1852437954D6FC93B41EE304F855C339_1920825826 = (rect.height() > height);
                {
                    scrollYDelta += (rect.top - screenTop);
                } //End block
                {
                    scrollYDelta += (rect.bottom - screenBottom);
                } //End block
            } //End collapsed parenthetic
            int bottom;
            bottom = getChildAt(0).getBottom();
            int distanceToBottom;
            distanceToBottom = bottom - screenBottom;
            scrollYDelta = Math.min(scrollYDelta, distanceToBottom);
        } //End block
        {
            {
                boolean var1852437954D6FC93B41EE304F855C339_899042877 = (rect.height() > height);
                {
                    scrollYDelta -= (screenBottom - rect.bottom);
                } //End block
                {
                    scrollYDelta -= (screenTop - rect.top);
                } //End block
            } //End collapsed parenthetic
            scrollYDelta = Math.max(scrollYDelta, -getScrollY());
        } //End block
        addTaint(rect.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1447852525 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1447852525;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.173 -0400", hash_original_method = "C2C4A47D49BA76A3A98712461E581564", hash_generated_method = "A6F96566FD9F1BE3771DA2878DF4DC46")
    @Override
    public void requestChildFocus(View child, View focused) {
        {
            scrollToChild(focused);
        } //End block
        {
            mChildToScrollTo = focused;
        } //End block
        super.requestChildFocus(child, focused);
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //if (!mIsLayoutDirty) {
            //scrollToChild(focused);
        //} else {
            //mChildToScrollTo = focused;
        //}
        //super.requestChildFocus(child, focused);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.174 -0400", hash_original_method = "BC1790D54EF67B6E1EFAB03FC42BAB96", hash_generated_method = "69D046E49C66C8A105C6F64826E30F58")
    @Override
    protected boolean onRequestFocusInDescendants(int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            direction = View.FOCUS_DOWN;
        } //End block
        {
            direction = View.FOCUS_UP;
        } //End block
        View nextFocus;
        nextFocus = FocusFinder.getInstance().findNextFocus(this, null, direction);
        nextFocus = FocusFinder.getInstance().findNextFocusFromRect(this,
                        previouslyFocusedRect, direction);
        {
            boolean var2421F6D33436D75DDCB765DA8D416CB8_1606308673 = (isOffScreen(nextFocus));
        } //End collapsed parenthetic
        boolean varBB06A889CCA25ED822B35181716FFE90_1371182708 = (nextFocus.requestFocus(direction, previouslyFocusedRect));
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1749038086 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1749038086;
        // ---------- Original Method ----------
        //if (direction == View.FOCUS_FORWARD) {
            //direction = View.FOCUS_DOWN;
        //} else if (direction == View.FOCUS_BACKWARD) {
            //direction = View.FOCUS_UP;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.174 -0400", hash_original_method = "50E2DA7CF8E403536932E3B77491E964", hash_generated_method = "3C6535496D7B70D287D53277BE876F12")
    @Override
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle,
            boolean immediate) {
        rectangle.offset(child.getLeft() - child.getScrollX(),
                child.getTop() - child.getScrollY());
        boolean var9EED5F05118BACEED05952D173A9E219_1911715057 = (scrollToChildRect(rectangle, immediate));
        addTaint(child.getTaint());
        addTaint(rectangle.getTaint());
        addTaint(immediate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1013927727 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1013927727;
        // ---------- Original Method ----------
        //rectangle.offset(child.getLeft() - child.getScrollX(),
                //child.getTop() - child.getScrollY());
        //return scrollToChildRect(rectangle, immediate);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.179 -0400", hash_original_method = "31751D7E496E2D7BD9B4D4E94AD28515", hash_generated_method = "11A20A1DA3E3F0E4689DA3F629925C7D")
    @Override
    public void requestLayout() {
        mIsLayoutDirty = true;
        super.requestLayout();
        // ---------- Original Method ----------
        //mIsLayoutDirty = true;
        //super.requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.180 -0400", hash_original_method = "E0B1FFFA746AE76ECF17449388BCEBCA", hash_generated_method = "0769E662DBD4D44EBB6685D0653E05DC")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        {
            mScrollStrictSpan.finish();
            mScrollStrictSpan = null;
        } //End block
        {
            mFlingStrictSpan.finish();
            mFlingStrictSpan = null;
        } //End block
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //if (mScrollStrictSpan != null) {
            //mScrollStrictSpan.finish();
            //mScrollStrictSpan = null;
        //}
        //if (mFlingStrictSpan != null) {
            //mFlingStrictSpan.finish();
            //mFlingStrictSpan = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.186 -0400", hash_original_method = "51521A672083F0AD2F639BD854AB8D0F", hash_generated_method = "BB82C4E4AE96BF7C96AF4D7BC45987C2")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onLayout(changed, l, t, r, b);
        mIsLayoutDirty = false;
        {
            boolean varFEFF39315B1161E387E3A3BC8A5B6333_87898377 = (mChildToScrollTo != null && isViewDescendantOf(mChildToScrollTo, this));
            {
                scrollToChild(mChildToScrollTo);
            } //End block
        } //End collapsed parenthetic
        mChildToScrollTo = null;
        scrollTo(mScrollX, mScrollY);
        addTaint(changed);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        // ---------- Original Method ----------
        //super.onLayout(changed, l, t, r, b);
        //mIsLayoutDirty = false;
        //if (mChildToScrollTo != null && isViewDescendantOf(mChildToScrollTo, this)) {
            //scrollToChild(mChildToScrollTo);
        //}
        //mChildToScrollTo = null;
        //scrollTo(mScrollX, mScrollY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.186 -0400", hash_original_method = "35BE22C8E7AB63B977E9EAA0D1A8EAA6", hash_generated_method = "BB428894E33EDC7DDC40CF8B8B8F7E1B")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onSizeChanged(w, h, oldw, oldh);
        View currentFocused;
        currentFocused = findFocus();
        {
            boolean varCE6D2EB5D4D2223694B6B3F92A2E212D_1697083630 = (isWithinDeltaOfScreen(currentFocused, 0, oldh));
            {
                currentFocused.getDrawingRect(mTempRect);
                offsetDescendantRectToMyCoords(currentFocused, mTempRect);
                int scrollDelta;
                scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
                doScrollY(scrollDelta);
            } //End block
        } //End collapsed parenthetic
        addTaint(w);
        addTaint(h);
        addTaint(oldw);
        addTaint(oldh);
        // ---------- Original Method ----------
        //super.onSizeChanged(w, h, oldw, oldh);
        //View currentFocused = findFocus();
        //if (null == currentFocused || this == currentFocused)
            //return;
        //if (isWithinDeltaOfScreen(currentFocused, 0, oldh)) {
            //currentFocused.getDrawingRect(mTempRect);
            //offsetDescendantRectToMyCoords(currentFocused, mTempRect);
            //int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
            //doScrollY(scrollDelta);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.187 -0400", hash_original_method = "25276A1ACE97D138BB17C9052B223D37", hash_generated_method = "EDC1034AB686AB269FAA91074E2E3BC2")
    private boolean isViewDescendantOf(View child, View parent) {
        ViewParent theParent;
        theParent = child.getParent();
        boolean var948A486C9D980B3FCF5DD6DC234D8E28_1619172605 = ((theParent instanceof ViewGroup) && isViewDescendantOf((View) theParent, parent));
        addTaint(child.getTaint());
        addTaint(parent.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_919390249 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_919390249;
        // ---------- Original Method ----------
        //if (child == parent) {
            //return true;
        //}
        //final ViewParent theParent = child.getParent();
        //return (theParent instanceof ViewGroup) && isViewDescendantOf((View) theParent, parent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.187 -0400", hash_original_method = "C7B4AEF12870EFF4E9873FB61486C527", hash_generated_method = "956033023162923FD5D107052D5F9177")
    public void fling(int velocityY) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1102468200 = (getChildCount() > 0);
            {
                int height;
                height = getHeight() - mPaddingBottom - mPaddingTop;
                int bottom;
                bottom = getChildAt(0).getHeight();
                mScroller.fling(mScrollX, mScrollY, 0, velocityY, 0, 0, 0,
                    Math.max(0, bottom - height), 0, height/2);
                boolean movingDown;
                movingDown = velocityY > 0;
                {
                    mFlingStrictSpan = StrictMode.enterCriticalSpan("ScrollView-fling");
                } //End block
                invalidate();
            } //End block
        } //End collapsed parenthetic
        addTaint(velocityY);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //int height = getHeight() - mPaddingBottom - mPaddingTop;
            //int bottom = getChildAt(0).getHeight();
            //mScroller.fling(mScrollX, mScrollY, 0, velocityY, 0, 0, 0,
                    //Math.max(0, bottom - height), 0, height/2);
            //final boolean movingDown = velocityY > 0;
            //if (mFlingStrictSpan == null) {
                //mFlingStrictSpan = StrictMode.enterCriticalSpan("ScrollView-fling");
            //}
            //invalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.188 -0400", hash_original_method = "526DB7CB9D9E6BCF2CDE3F8A7F1D2890", hash_generated_method = "0DFF22FC23EC0A9A95D0F21098A32742")
    private void endDrag() {
        mIsBeingDragged = false;
        recycleVelocityTracker();
        {
            mEdgeGlowTop.onRelease();
            mEdgeGlowBottom.onRelease();
        } //End block
        {
            mScrollStrictSpan.finish();
            mScrollStrictSpan = null;
        } //End block
        // ---------- Original Method ----------
        //mIsBeingDragged = false;
        //recycleVelocityTracker();
        //if (mEdgeGlowTop != null) {
            //mEdgeGlowTop.onRelease();
            //mEdgeGlowBottom.onRelease();
        //}
        //if (mScrollStrictSpan != null) {
            //mScrollStrictSpan.finish();
            //mScrollStrictSpan = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.209 -0400", hash_original_method = "748C5914370A5F8CDD8109B6F4611B5B", hash_generated_method = "A5DD6AA92A00D491D15AD7C3034DA3BF")
    @Override
    public void scrollTo(int x, int y) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_515725468 = (getChildCount() > 0);
            {
                View child;
                child = getChildAt(0);
                x = clamp(x, getWidth() - mPaddingRight - mPaddingLeft, child.getWidth());
                y = clamp(y, getHeight() - mPaddingBottom - mPaddingTop, child.getHeight());
                {
                    super.scrollTo(x, y);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(x);
        addTaint(y);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.210 -0400", hash_original_method = "3BD104A12D7CF3E01CAF1DA422C489F3", hash_generated_method = "4CBA9234CB0696D0322C8E3B63FAF9C9")
    @Override
    public void setOverScrollMode(int mode) {
        {
            {
                Context context;
                context = getContext();
                mEdgeGlowTop = new EdgeEffect(context);
                mEdgeGlowBottom = new EdgeEffect(context);
            } //End block
        } //End block
        {
            mEdgeGlowTop = null;
            mEdgeGlowBottom = null;
        } //End block
        super.setOverScrollMode(mode);
        addTaint(mode);
        // ---------- Original Method ----------
        //if (mode != OVER_SCROLL_NEVER) {
            //if (mEdgeGlowTop == null) {
                //Context context = getContext();
                //mEdgeGlowTop = new EdgeEffect(context);
                //mEdgeGlowBottom = new EdgeEffect(context);
            //}
        //} else {
            //mEdgeGlowTop = null;
            //mEdgeGlowBottom = null;
        //}
        //super.setOverScrollMode(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.210 -0400", hash_original_method = "50FAD524FA6B782881C70ABEF15C4DDF", hash_generated_method = "42A587E28EE387B58431773C49BC2845")
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        {
            int scrollY;
            scrollY = mScrollY;
            {
                boolean varD7662701013542BC2CCE8B2B50437EBA_1908532160 = (!mEdgeGlowTop.isFinished());
                {
                    int restoreCount;
                    restoreCount = canvas.save();
                    int width;
                    width = getWidth() - mPaddingLeft - mPaddingRight;
                    canvas.translate(mPaddingLeft, Math.min(0, scrollY));
                    mEdgeGlowTop.setSize(width, getHeight());
                    {
                        boolean varAE9426D05B3D52BFC4B9E7AA44588485_615034741 = (mEdgeGlowTop.draw(canvas));
                        {
                            invalidate();
                        } //End block
                    } //End collapsed parenthetic
                    canvas.restoreToCount(restoreCount);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var71AB611E918A4C599E2F06D4154D257E_1450675977 = (!mEdgeGlowBottom.isFinished());
                {
                    int restoreCount;
                    restoreCount = canvas.save();
                    int width;
                    width = getWidth() - mPaddingLeft - mPaddingRight;
                    int height;
                    height = getHeight();
                    canvas.translate(-width + mPaddingLeft,
                        Math.max(getScrollRange(), scrollY) + height);
                    canvas.rotate(180, width, 0);
                    mEdgeGlowBottom.setSize(width, height);
                    {
                        boolean var61CCF9557D478E1494862B3636E22888_1211761887 = (mEdgeGlowBottom.draw(canvas));
                        {
                            invalidate();
                        } //End block
                    } //End collapsed parenthetic
                    canvas.restoreToCount(restoreCount);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.211 -0400", hash_original_method = "10E81B579101690AB90AC933866D5438", hash_generated_method = "30F449904D9A1E09DDF555DD323C92DC")
    private int clamp(int n, int my, int child) {
        addTaint(n);
        addTaint(my);
        addTaint(child);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2089229275 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2089229275;
        // ---------- Original Method ----------
        //if (my >= child || n < 0) {
            //return 0;
        //}
        //if ((my+n) > child) {
            //return child-my;
        //}
        //return n;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.211 -0400", hash_original_field = "D4B6C25D0A03D262C947BCD869108225", hash_generated_field = "776A3B5C879D294B7A4E3A9080A92207")

    static int ANIMATED_SCROLL_GAP = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.211 -0400", hash_original_field = "9BFFC1AB0B9FE2B016F88B3E293FEE4F", hash_generated_field = "4FF6A0CD88A94A91E5CD9C968A41AD23")

    static float MAX_SCROLL_FACTOR = 0.5f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.211 -0400", hash_original_field = "7EF8B2C57AC3A1D5EC1190F4098C6121", hash_generated_field = "EC0CE8121C7A62BAD74595655C619E28")

    private static int INVALID_POINTER = -1;
}

