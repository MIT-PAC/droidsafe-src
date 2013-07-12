package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.066 -0400", hash_original_field = "380EFAD062415C5D611446C1B15B307D", hash_generated_field = "507FF60BF6AED501221786F4F9B1C4CE")

    private long mLastScroll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.066 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

    private final Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.066 -0400", hash_original_field = "360DD66618E954525BEA0D65B05DC7EC", hash_generated_field = "7106C69F4E49AB9D7F59F38965DF6036")

    private OverScroller mScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.066 -0400", hash_original_field = "89E135B7087DB76810F3F37EE0DAB560", hash_generated_field = "E572968A85247BF2ECB5635FFF539C2E")

    private EdgeEffect mEdgeGlowTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.066 -0400", hash_original_field = "289036755C83C8893D6004D3220BA45B", hash_generated_field = "D2A4A7BE91BF29EB90E114C9648825A6")

    private EdgeEffect mEdgeGlowBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.067 -0400", hash_original_field = "4925C8499D6FECBA832A37F55AA6C69B", hash_generated_field = "2D88D85D441545A6227529A03C0B4E71")

    private float mLastMotionY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.067 -0400", hash_original_field = "A43EC71B2E74CACC223B47379717A080", hash_generated_field = "9C16E67A6EDB3E799E01AFB02BCF7815")

    private boolean mIsLayoutDirty = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.067 -0400", hash_original_field = "8949A253727FAE7FB577F98D2A9463C2", hash_generated_field = "7E1EAB0DC4AB4B81BAB22B01D588949E")

    private View mChildToScrollTo = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.067 -0400", hash_original_field = "A8AB6008485C6E787B3DBB97D2050FF4", hash_generated_field = "40AA109CDE3739730D8C499D23D26FF1")

    private boolean mIsBeingDragged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.067 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.067 -0400", hash_original_field = "B3E3E62AA85A925921DCB2869A4E7017", hash_generated_field = "16DDF79C39D64DD0F8B72040D2242A75")

    @ViewDebug.ExportedProperty(category = "layout") private boolean mFillViewport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.067 -0400", hash_original_field = "581BD96ACB5FC0F4F529183E58EA63B2", hash_generated_field = "EA3AE5CC17F6060C1DBAA2AAAFFFC35C")

    private boolean mSmoothScrollingEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.067 -0400", hash_original_field = "3DFFFAD10926598D18EEC50D61DE79CA", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.067 -0400", hash_original_field = "30B0DF23DBDF2426D66E4D98494C369B", hash_generated_field = "7DBE1A18599B8760DC9B67AAFE3499E3")

    private int mMinimumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.067 -0400", hash_original_field = "1C66D9179508D091F8E90C9FEBAD15CA", hash_generated_field = "6F997413D0B227487940C402EB78A8FD")

    private int mMaximumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.067 -0400", hash_original_field = "7A5B6F76BA72A8D6AFCFCEA14B8C2556", hash_generated_field = "7B0107E1CAE9FFC281D766335539D7C4")

    private int mOverscrollDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.067 -0400", hash_original_field = "755491871A4FCE3E01181030F8FEB178", hash_generated_field = "06022A8A798B4C892D35D0FFB16D2FDF")

    private int mOverflingDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.067 -0400", hash_original_field = "D0F34CC6DB83FC46AEC38F19CA5CE138", hash_generated_field = "1B464B20D80463EC30779F63AB0559BD")

    private int mActivePointerId = INVALID_POINTER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.067 -0400", hash_original_field = "D2BBDD4FC0A41CFC280764A4FBDC4D52", hash_generated_field = "BA5EBFF9CCBAD624E5B38890A6227093")

    private StrictMode.Span mScrollStrictSpan = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.067 -0400", hash_original_field = "A914CE4AFB85B902CB007BE88097BB3F", hash_generated_field = "1B2DFB133C9B4AE33C58293244DDF261")

    private StrictMode.Span mFlingStrictSpan = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.068 -0400", hash_original_method = "4713E1355E9C805E185DB05E4B4B9810", hash_generated_method = "D94FF7D50EC38B3687BB3B0C7B5552B0")
    public  ScrollView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.068 -0400", hash_original_method = "D709104905B863FC98F9383546426518", hash_generated_method = "CA0A33DD4C9506592D1FE214461DF652")
    public  ScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.scrollViewStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.069 -0400", hash_original_method = "A71F55C63B3167922F139A658C272800", hash_generated_method = "FEF2E0811C43849A8F71F9F0E9A639E0")
    public  ScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        initScrollView();
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.ScrollView, defStyle, 0);
        setFillViewport(a.getBoolean(R.styleable.ScrollView_fillViewport, false));
        a.recycle();
        // ---------- Original Method ----------
        //initScrollView();
        //TypedArray a =
            //context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.ScrollView, defStyle, 0);
        //setFillViewport(a.getBoolean(R.styleable.ScrollView_fillViewport, false));
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.069 -0400", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "AE5DFFFFEFC5AD8B8FB6B4A2ADCEC913")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean varB326B5062B2F0E69046810717534CB09_1612567637 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1461135747 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1461135747;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.069 -0400", hash_original_method = "2B5BCBF9645A95C024C3D4122E8D2438", hash_generated_method = "E49153E9A0F927491F9C23F9B6BC2D33")
    @Override
    protected float getTopFadingEdgeStrength() {
    if(getChildCount() == 0)        
        {
            float var2C64466C1DFC5FC617E8E7707C276CC3_2124000862 = (0.0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_452891502 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_452891502;
        } //End block
        final int length = getVerticalFadingEdgeLength();
    if(mScrollY < length)        
        {
            float varB7B510B1D5CD1A5C3736F282DF9DDB61_192834675 = (mScrollY / (float) length);
                        float var546ADE640B6EDFBC8A086EF31347E768_935649137 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_935649137;
        } //End block
        float varCFE70293CC98B68AC513E2798BAD793D_30740521 = (1.0f);
                float var546ADE640B6EDFBC8A086EF31347E768_1552450083 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1552450083;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.070 -0400", hash_original_method = "F0E4C184CA27C21FD42267E77DCA1374", hash_generated_method = "2111F2705D61C2B2314BDA44F72F5720")
    @Override
    protected float getBottomFadingEdgeStrength() {
    if(getChildCount() == 0)        
        {
            float var2C64466C1DFC5FC617E8E7707C276CC3_1398867986 = (0.0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_1686617046 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1686617046;
        } //End block
        final int length = getVerticalFadingEdgeLength();
        final int bottomEdge = getHeight() - mPaddingBottom;
        final int span = getChildAt(0).getBottom() - mScrollY - bottomEdge;
    if(span < length)        
        {
            float var941A690C6CFF230827FF210C6B3392A9_615942485 = (span / (float) length);
                        float var546ADE640B6EDFBC8A086EF31347E768_1051918420 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1051918420;
        } //End block
        float varCFE70293CC98B68AC513E2798BAD793D_1142075067 = (1.0f);
                float var546ADE640B6EDFBC8A086EF31347E768_111713087 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_111713087;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.070 -0400", hash_original_method = "13CC3D3BB67006B8B223FEAA5CEB8AD3", hash_generated_method = "C86EF0F7188982C4DEBA1E4570A9AD0F")
    public int getMaxScrollAmount() {
        int var4EE17CA5D467EC005F38F5E52038081E_2038247252 = ((int) (MAX_SCROLL_FACTOR * (mBottom - mTop)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_809001669 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_809001669;
        // ---------- Original Method ----------
        //return (int) (MAX_SCROLL_FACTOR * (mBottom - mTop));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.071 -0400", hash_original_method = "02BBAF53D85E267FB240E2D4309C877F", hash_generated_method = "02BFF61AA3D9E1FA9C55929FA1EDF318")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.071 -0400", hash_original_method = "C2B46C856A31C41C5B4609404338EFA0", hash_generated_method = "8FF068A10B062F752A0A3880A2147B20")
    @Override
    public void addView(View child) {
        addTaint(child.getTaint());
    if(getChildCount() > 0)        
        {
            IllegalStateException varEA35513AF34C6AA37DA11FBC41AE9A71_1928815501 = new IllegalStateException("ScrollView can host only one direct child");
            varEA35513AF34C6AA37DA11FBC41AE9A71_1928815501.addTaint(taint);
            throw varEA35513AF34C6AA37DA11FBC41AE9A71_1928815501;
        } //End block
        super.addView(child);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("ScrollView can host only one direct child");
        //}
        //super.addView(child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.072 -0400", hash_original_method = "E948CE4EC40C516B64A70B82C4D41ABE", hash_generated_method = "58144AA842889C18FF6C1CA89FA0888C")
    @Override
    public void addView(View child, int index) {
        addTaint(index);
        addTaint(child.getTaint());
    if(getChildCount() > 0)        
        {
            IllegalStateException varEA35513AF34C6AA37DA11FBC41AE9A71_541007698 = new IllegalStateException("ScrollView can host only one direct child");
            varEA35513AF34C6AA37DA11FBC41AE9A71_541007698.addTaint(taint);
            throw varEA35513AF34C6AA37DA11FBC41AE9A71_541007698;
        } //End block
        super.addView(child, index);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("ScrollView can host only one direct child");
        //}
        //super.addView(child, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.072 -0400", hash_original_method = "34A1DE7AC13648E903519BA7AEB15B21", hash_generated_method = "E0C907895309A9E148229BF43B86E930")
    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(child.getTaint());
    if(getChildCount() > 0)        
        {
            IllegalStateException varEA35513AF34C6AA37DA11FBC41AE9A71_530607349 = new IllegalStateException("ScrollView can host only one direct child");
            varEA35513AF34C6AA37DA11FBC41AE9A71_530607349.addTaint(taint);
            throw varEA35513AF34C6AA37DA11FBC41AE9A71_530607349;
        } //End block
        super.addView(child, params);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("ScrollView can host only one direct child");
        //}
        //super.addView(child, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.072 -0400", hash_original_method = "363983D07DF3EAAC15B8A0529305BE77", hash_generated_method = "5E8F1F66D4DA40DF7E642139F1575F58")
    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(index);
        addTaint(child.getTaint());
    if(getChildCount() > 0)        
        {
            IllegalStateException varEA35513AF34C6AA37DA11FBC41AE9A71_629989030 = new IllegalStateException("ScrollView can host only one direct child");
            varEA35513AF34C6AA37DA11FBC41AE9A71_629989030.addTaint(taint);
            throw varEA35513AF34C6AA37DA11FBC41AE9A71_629989030;
        } //End block
        super.addView(child, index, params);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("ScrollView can host only one direct child");
        //}
        //super.addView(child, index, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.073 -0400", hash_original_method = "F1DEDB4D65582CE354A1D843D55A4B55", hash_generated_method = "398FF4766E0A2CC42078FDACA2A7287A")
    private boolean canScroll() {
        View child = getChildAt(0);
    if(child != null)        
        {
            int childHeight = child.getHeight();
            boolean var6B6C0F8BCAEBC4C1FD00D1E276ECEEDF_510733112 = (getHeight() < childHeight + mPaddingTop + mPaddingBottom);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_87390803 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_87390803;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_95990091 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_639830004 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_639830004;
        // ---------- Original Method ----------
        //View child = getChildAt(0);
        //if (child != null) {
            //int childHeight = child.getHeight();
            //return getHeight() < childHeight + mPaddingTop + mPaddingBottom;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.073 -0400", hash_original_method = "801E6F065AC6A60CFB0DADB1E074F98E", hash_generated_method = "82A15F27425537FBE4AAEB27826C974A")
    public boolean isFillViewport() {
        boolean varB3E3E62AA85A925921DCB2869A4E7017_117529245 = (mFillViewport);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1169376742 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1169376742;
        // ---------- Original Method ----------
        //return mFillViewport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.073 -0400", hash_original_method = "D2588C7F74D0E18DF5DFA629FE7BF270", hash_generated_method = "F2E2A5C18232B8609B837CA278719D40")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.073 -0400", hash_original_method = "D26C58327C0CB18AC1F62B7629FD16B1", hash_generated_method = "70C7B911A2B0D71970D4B9A4DADE84E2")
    public boolean isSmoothScrollingEnabled() {
        boolean var15B603515FEC15F2893A41D962B8656B_1021540526 = (mSmoothScrollingEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_667841180 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_667841180;
        // ---------- Original Method ----------
        //return mSmoothScrollingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.074 -0400", hash_original_method = "63C96CE84D9CD60CA1FF4EF87D7FF4F5", hash_generated_method = "5C7F23BB3E765786BEE5D256B048D32A")
    public void setSmoothScrollingEnabled(boolean smoothScrollingEnabled) {
        mSmoothScrollingEnabled = smoothScrollingEnabled;
        // ---------- Original Method ----------
        //mSmoothScrollingEnabled = smoothScrollingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.074 -0400", hash_original_method = "1504CEEE6604563B648201D50795D68C", hash_generated_method = "4BD6021F837D0740EC37C09A55B0F894")
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
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
    if(heightMode == MeasureSpec.UNSPECIFIED)        
        {
            return;
        } //End block
    if(getChildCount() > 0)        
        {
            final View child = getChildAt(0);
            int height = getMeasuredHeight();
    if(child.getMeasuredHeight() < height)            
            {
                final FrameLayout.LayoutParams lp = (LayoutParams) child.getLayoutParams();
                int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec,
                        mPaddingLeft + mPaddingRight, lp.width);
                height -= mPaddingTop;
                height -= mPaddingBottom;
                int childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
                child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.075 -0400", hash_original_method = "40D3C8E04EF2AEB04EFDF302E05EC516", hash_generated_method = "EDAC285B90D37D425CE050406251F7EF")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        boolean var4D7C358C8BD535F7098378506DB34C5F_1834850486 = (super.dispatchKeyEvent(event) || executeKeyEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1476662195 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1476662195;
        // ---------- Original Method ----------
        //return super.dispatchKeyEvent(event) || executeKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.076 -0400", hash_original_method = "1E6EE1FACBE8E24D9D58E940A1542C55", hash_generated_method = "7E1139040BFF69AAA348276833DBFAA0")
    public boolean executeKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        mTempRect.setEmpty();
    if(!canScroll())        
        {
    if(isFocused() && event.getKeyCode() != KeyEvent.KEYCODE_BACK)            
            {
                View currentFocused = findFocus();
    if(currentFocused == this)                
                currentFocused = null;
                View nextFocused = FocusFinder.getInstance().findNextFocus(this,
                        currentFocused, View.FOCUS_DOWN);
                boolean var33AE31F50876CF8AEA9AC9F5F3635287_883743926 = (nextFocused != null
                        && nextFocused != this
                        && nextFocused.requestFocus(View.FOCUS_DOWN));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1285911339 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1285911339;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1388726019 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_204223307 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_204223307;
        } //End block
        boolean handled = false;
    if(event.getAction() == KeyEvent.ACTION_DOWN)        
        {
switch(event.getKeyCode()){
            case KeyEvent.KEYCODE_DPAD_UP:
    if(!event.isAltPressed())            
            {
                handled = arrowScroll(View.FOCUS_UP);
            } //End block
            else
            {
                handled = fullScroll(View.FOCUS_UP);
            } //End block
            break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
    if(!event.isAltPressed())            
            {
                handled = arrowScroll(View.FOCUS_DOWN);
            } //End block
            else
            {
                handled = fullScroll(View.FOCUS_DOWN);
            } //End block
            break;
            case KeyEvent.KEYCODE_SPACE:
            pageScroll(event.isShiftPressed() ? View.FOCUS_UP : View.FOCUS_DOWN);
            break;
}
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_1587345920 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1506347661 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1506347661;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.076 -0400", hash_original_method = "21B5B152D5EE02017A0CB65ECB9B3403", hash_generated_method = "8C8A971E1ABB545F35699F73A6E6F4E0")
    private boolean inChild(int x, int y) {
        addTaint(y);
        addTaint(x);
    if(getChildCount() > 0)        
        {
            final int scrollY = mScrollY;
            final View child = getChildAt(0);
            boolean var09D7ABE4EF5449AEA1E1422AF00FBA90_831727443 = (!(y < child.getTop() - scrollY
                    || y >= child.getBottom() - scrollY
                    || x < child.getLeft()
                    || x >= child.getRight()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_645931422 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_645931422;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_115038589 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_530638730 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_530638730;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.077 -0400", hash_original_method = "2F2E3E2ED97C397B1954EFE1C35FD1EF", hash_generated_method = "E6A2459F70C94EEE4F8E0DC05B01F193")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.077 -0400", hash_original_method = "2C2F1E0A6C232182F8110D9EE75ED47E", hash_generated_method = "2B8D7737D5D71D4902AEB864DE542716")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.078 -0400", hash_original_method = "FC3B581D4963BCED4340031BA20C5421", hash_generated_method = "701A7C43D055D340A0D18EE9D957EDFF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.078 -0400", hash_original_method = "C74400E8950C106883E854683AF24673", hash_generated_method = "0484ACC96D68F9484E340AA90FA16493")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.080 -0400", hash_original_method = "A618CDF234D118EA8A225B0CD965AEA3", hash_generated_method = "EF12BF2C1CA0EF5ADE51A7CFBAB37C24")
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final int action = ev.getAction();
    if((action == MotionEvent.ACTION_MOVE) && (mIsBeingDragged))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1476903199 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_283913860 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_283913860;
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
            final float y = ev.getY(pointerIndex);
            final int yDiff = (int) Math.abs(y - mLastMotionY);
    if(yDiff > mTouchSlop)            
            {
                mIsBeingDragged = true;
                mLastMotionY = y;
                initVelocityTrackerIfNotExists();
                mVelocityTracker.addMovement(ev);
    if(mScrollStrictSpan == null)                
                {
                    mScrollStrictSpan = StrictMode.enterCriticalSpan("ScrollView-scroll");
                } //End block
            } //End block
            break;
        } //End block
        case MotionEvent.ACTION_DOWN:
        {
            final float y = ev.getY();
    if(!inChild((int) ev.getX(), (int) y))            
            {
                mIsBeingDragged = false;
                recycleVelocityTracker();
                break;
            } //End block
            mLastMotionY = y;
            mActivePointerId = ev.getPointerId(0);
            initOrResetVelocityTracker();
            mVelocityTracker.addMovement(ev);
            mIsBeingDragged = !mScroller.isFinished();
    if(mIsBeingDragged && mScrollStrictSpan == null)            
            {
                mScrollStrictSpan = StrictMode.enterCriticalSpan("ScrollView-scroll");
            } //End block
            break;
        } //End block
        case MotionEvent.ACTION_CANCEL:
        case MotionEvent.ACTION_UP:
        mIsBeingDragged = false;
        mActivePointerId = INVALID_POINTER;
        recycleVelocityTracker();
    if(mScroller.springBack(mScrollX, mScrollY, 0, 0, 0, getScrollRange()))        
        {
            invalidate();
        } //End block
        break;
        case MotionEvent.ACTION_POINTER_UP:
        onSecondaryPointerUp(ev);
        break;
}        boolean varCD7F83DE880FD2A584529B26609B9552_224981779 = (mIsBeingDragged);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1226275987 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1226275987;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.083 -0400", hash_original_method = "83F23D23BD0BAB2CB063E24A3B111651", hash_generated_method = "F7C8FAB05070C468CC2C599C2A48856A")
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
                boolean var68934A3E9455FA72420237EB05902327_380734559 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_203291138 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_203291138;
            } //End block
    if(!mScroller.isFinished())            
            {
                mScroller.abortAnimation();
    if(mFlingStrictSpan != null)                
                {
                    mFlingStrictSpan.finish();
                    mFlingStrictSpan = null;
                } //End block
            } //End block
            mLastMotionY = ev.getY();
            mActivePointerId = ev.getPointerId(0);
            break;
        } //End block
        case MotionEvent.ACTION_MOVE:
    if(mIsBeingDragged)        
        {
            final int activePointerIndex = ev.findPointerIndex(mActivePointerId);
            final float y = ev.getY(activePointerIndex);
            final int deltaY = (int) (mLastMotionY - y);
            mLastMotionY = y;
            final int oldX = mScrollX;
            final int oldY = mScrollY;
            final int range = getScrollRange();
            final int overscrollMode = getOverScrollMode();
            final boolean canOverscroll = overscrollMode == OVER_SCROLL_ALWAYS ||
                            (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && range > 0);
    if(overScrollBy(0, deltaY, 0, mScrollY,
                            0, range, 0, mOverscrollDistance, true))            
            {
                mVelocityTracker.clear();
            } //End block
            onScrollChanged(mScrollX, mScrollY, oldX, oldY);
    if(canOverscroll)            
            {
                final int pulledToY = oldY + deltaY;
    if(pulledToY < 0)                
                {
                    mEdgeGlowTop.onPull((float) deltaY / getHeight());
    if(!mEdgeGlowBottom.isFinished())                    
                    {
                        mEdgeGlowBottom.onRelease();
                    } //End block
                } //End block
                else
    if(pulledToY > range)                
                {
                    mEdgeGlowBottom.onPull((float) deltaY / getHeight());
    if(!mEdgeGlowTop.isFinished())                    
                    {
                        mEdgeGlowTop.onRelease();
                    } //End block
                } //End block
    if(mEdgeGlowTop != null
                                && (!mEdgeGlowTop.isFinished() || !mEdgeGlowBottom.isFinished()))                
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
            int initialVelocity = (int) velocityTracker.getYVelocity(mActivePointerId);
    if(getChildCount() > 0)            
            {
    if((Math.abs(initialVelocity) > mMinimumVelocity))                
                {
                    fling(-initialVelocity);
                } //End block
                else
                {
    if(mScroller.springBack(mScrollX, mScrollY, 0, 0, 0,
                                    getScrollRange()))                    
                    {
                        invalidate();
                    } //End block
                } //End block
            } //End block
            mActivePointerId = INVALID_POINTER;
            endDrag();
        } //End block
        break;
        case MotionEvent.ACTION_CANCEL:
    if(mIsBeingDragged && getChildCount() > 0)        
        {
    if(mScroller.springBack(mScrollX, mScrollY, 0, 0, 0, getScrollRange()))            
            {
                invalidate();
            } //End block
            mActivePointerId = INVALID_POINTER;
            endDrag();
        } //End block
        break;
        case MotionEvent.ACTION_POINTER_DOWN:
        {
            final int index = ev.getActionIndex();
            final float y = ev.getY(index);
            mLastMotionY = y;
            mActivePointerId = ev.getPointerId(index);
            break;
        } //End block
        case MotionEvent.ACTION_POINTER_UP:
        onSecondaryPointerUp(ev);
        mLastMotionY = ev.getY(ev.findPointerIndex(mActivePointerId));
        break;
}        boolean varB326B5062B2F0E69046810717534CB09_1848558065 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1146826175 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1146826175;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.085 -0400", hash_original_method = "1724FA32F4E11B8EDA6825E1236F6DA2", hash_generated_method = "AE496CF2DE10298179E1910B20DBA9BF")
    private void onSecondaryPointerUp(MotionEvent ev) {
        final int pointerIndex = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >>
                MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        final int pointerId = ev.getPointerId(pointerIndex);
    if(pointerId == mActivePointerId)        
        {
            final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            mLastMotionY = ev.getY(newPointerIndex);
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
            //mLastMotionY = ev.getY(newPointerIndex);
            //mActivePointerId = ev.getPointerId(newPointerIndex);
            //if (mVelocityTracker != null) {
                //mVelocityTracker.clear();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.085 -0400", hash_original_method = "ABBC11F59DDEDBBBBFE897034F702501", hash_generated_method = "FAF4DAD2E212368CE3B01B9F16F3DD58")
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
                    final float vscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL);
    if(vscroll != 0)                    
                    {
                        final int delta = (int) (vscroll * getVerticalScrollFactor());
                        final int range = getScrollRange();
                        int oldScrollY = mScrollY;
                        int newScrollY = oldScrollY - delta;
    if(newScrollY < 0)                        
                        {
                            newScrollY = 0;
                        } //End block
                        else
    if(newScrollY > range)                        
                        {
                            newScrollY = range;
                        } //End block
    if(newScrollY != oldScrollY)                        
                        {
                            super.scrollTo(mScrollX, newScrollY);
                            boolean varB326B5062B2F0E69046810717534CB09_876332481 = (true);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1833710268 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1833710268;
                        } //End block
                    } //End block
                } //End block
            } //End block
}
        } //End block
        boolean var3B54C423A43BA14BBEA440506237FA4B_950407887 = (super.onGenericMotionEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_745921295 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_745921295;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.086 -0400", hash_original_method = "CC5D228BD55E3E42D5A6CE954C441DF3", hash_generated_method = "0FC58212B12DCFB39ACCBF2645768702")
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
    if(clampedY)            
            {
                mScroller.springBack(mScrollX, mScrollY, 0, 0, 0, getScrollRange());
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
            //if (clampedY) {
                //mScroller.springBack(mScrollX, mScrollY, 0, 0, 0, getScrollRange());
            //}
        //} else {
            //super.scrollTo(scrollX, scrollY);
        //}
        //awakenScrollBars();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.087 -0400", hash_original_method = "AF8EC74B0AD4D69DC5ACACFC8749064F", hash_generated_method = "2035CC755BD505267DFD2C0A965F4DCF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.087 -0400", hash_original_method = "F1695E9318A6A21B761B35BD458E866B", hash_generated_method = "FF02CB6FB25D4C0E9D6C808B364BC9B2")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        super.onInitializeAccessibilityEvent(event);
        final boolean scrollable = getScrollRange() > 0;
        event.setScrollable(scrollable);
        event.setScrollX(mScrollX);
        event.setScrollY(mScrollY);
        event.setMaxScrollX(mScrollX);
        event.setMaxScrollY(getScrollRange());
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //final boolean scrollable = getScrollRange() > 0;
        //event.setScrollable(scrollable);
        //event.setScrollX(mScrollX);
        //event.setScrollY(mScrollY);
        //event.setMaxScrollX(mScrollX);
        //event.setMaxScrollY(getScrollRange());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.087 -0400", hash_original_method = "54B8D0E6795D053FB63A6E55BD2EA0C5", hash_generated_method = "7283F5EE7FE74086DEA0C0C2CBD131B0")
    private int getScrollRange() {
        int scrollRange = 0;
    if(getChildCount() > 0)        
        {
            View child = getChildAt(0);
            scrollRange = Math.max(0,
                    child.getHeight() - (getHeight() - mPaddingBottom - mPaddingTop));
        } //End block
        int var94D4A3ECD79FF3E17EB5BD0659AF9AAE_232461684 = (scrollRange);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1574381132 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1574381132;
        // ---------- Original Method ----------
        //int scrollRange = 0;
        //if (getChildCount() > 0) {
            //View child = getChildAt(0);
            //scrollRange = Math.max(0,
                    //child.getHeight() - (getHeight() - mPaddingBottom - mPaddingTop));
        //}
        //return scrollRange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.088 -0400", hash_original_method = "CCA8F1BE638FE2EC5E8781CBB11ADD24", hash_generated_method = "DD16D5917D961E985FE531BDC0E2372C")
    private View findFocusableViewInMyBounds(final boolean topFocus,
            final int top, View preferredFocusable) {
        addTaint(preferredFocusable.getTaint());
        addTaint(top);
        addTaint(topFocus);
        final int fadingEdgeLength = getVerticalFadingEdgeLength() / 2;
        final int topWithoutFadingEdge = top + fadingEdgeLength;
        final int bottomWithoutFadingEdge = top + getHeight() - fadingEdgeLength;
    if((preferredFocusable != null)
                && (preferredFocusable.getTop() < bottomWithoutFadingEdge)
                && (preferredFocusable.getBottom() > topWithoutFadingEdge))        
        {
View varEDCC47E7BD000496BBF92CD9272FBD7B_951712688 =             preferredFocusable;
            varEDCC47E7BD000496BBF92CD9272FBD7B_951712688.addTaint(taint);
            return varEDCC47E7BD000496BBF92CD9272FBD7B_951712688;
        } //End block
View var3B725BDA0BC870B29494233A04708019_396604679 =         findFocusableViewInBounds(topFocus, topWithoutFadingEdge,
                bottomWithoutFadingEdge);
        var3B725BDA0BC870B29494233A04708019_396604679.addTaint(taint);
        return var3B725BDA0BC870B29494233A04708019_396604679;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.089 -0400", hash_original_method = "78998B2E5B42D469D0E131861596BD99", hash_generated_method = "912D781371134FA9B14AC03B7E848287")
    private View findFocusableViewInBounds(boolean topFocus, int top, int bottom) {
        addTaint(bottom);
        addTaint(top);
        addTaint(topFocus);
        List<View> focusables = getFocusables(View.FOCUS_FORWARD);
        View focusCandidate = null;
        boolean foundFullyContainedFocusable = false;
        int count = focusables.size();
for(int i = 0;i < count;i++)
        {
            View view = focusables.get(i);
            int viewTop = view.getTop();
            int viewBottom = view.getBottom();
    if(top < viewBottom && viewTop < bottom)            
            {
                final boolean viewIsFullyContained = (top < viewTop) &&
                        (viewBottom < bottom);
    if(focusCandidate == null)                
                {
                    focusCandidate = view;
                    foundFullyContainedFocusable = viewIsFullyContained;
                } //End block
                else
                {
                    final boolean viewIsCloserToBoundary = (topFocus && viewTop < focusCandidate.getTop()) ||
                                    (!topFocus && viewBottom > focusCandidate
                                            .getBottom());
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
View var9E337B9582937B68BAD70C44709A03C7_1559429880 =         focusCandidate;
        var9E337B9582937B68BAD70C44709A03C7_1559429880.addTaint(taint);
        return var9E337B9582937B68BAD70C44709A03C7_1559429880;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.090 -0400", hash_original_method = "8096444783AE8C9AF2A604C00C6FDBC2", hash_generated_method = "815C0D3B4A2E8D39BD35F00D760D2555")
    public boolean pageScroll(int direction) {
        addTaint(direction);
        boolean down = direction == View.FOCUS_DOWN;
        int height = getHeight();
    if(down)        
        {
            mTempRect.top = getScrollY() + height;
            int count = getChildCount();
    if(count > 0)            
            {
                View view = getChildAt(count - 1);
    if(mTempRect.top + height > view.getBottom())                
                {
                    mTempRect.top = view.getBottom() - height;
                } //End block
            } //End block
        } //End block
        else
        {
            mTempRect.top = getScrollY() - height;
    if(mTempRect.top < 0)            
            {
                mTempRect.top = 0;
            } //End block
        } //End block
        mTempRect.bottom = mTempRect.top + height;
        boolean varDE06A56AD28ACD66A70F80D4C7544EBC_12542831 = (scrollAndFocus(direction, mTempRect.top, mTempRect.bottom));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1375411857 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1375411857;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.091 -0400", hash_original_method = "E10B42C26E723F278A5695B0C5DAB2DB", hash_generated_method = "BBD9CEFD270841B55EDCAEED9DFF43B8")
    public boolean fullScroll(int direction) {
        addTaint(direction);
        boolean down = direction == View.FOCUS_DOWN;
        int height = getHeight();
        mTempRect.top = 0;
        mTempRect.bottom = height;
    if(down)        
        {
            int count = getChildCount();
    if(count > 0)            
            {
                View view = getChildAt(count - 1);
                mTempRect.bottom = view.getBottom() + mPaddingBottom;
                mTempRect.top = mTempRect.bottom - height;
            } //End block
        } //End block
        boolean varDE06A56AD28ACD66A70F80D4C7544EBC_1641334492 = (scrollAndFocus(direction, mTempRect.top, mTempRect.bottom));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_456179327 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_456179327;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.092 -0400", hash_original_method = "AEE85E195E488E817C7C5FD2FB4EC0FB", hash_generated_method = "AD221F2B6E903245BE784BE6C0C30963")
    private boolean scrollAndFocus(int direction, int top, int bottom) {
        addTaint(bottom);
        addTaint(top);
        addTaint(direction);
        boolean handled = true;
        int height = getHeight();
        int containerTop = getScrollY();
        int containerBottom = containerTop + height;
        boolean up = direction == View.FOCUS_UP;
        View newFocused = findFocusableViewInBounds(up, top, bottom);
    if(newFocused == null)        
        {
            newFocused = this;
        } //End block
    if(top >= containerTop && bottom <= containerBottom)        
        {
            handled = false;
        } //End block
        else
        {
            int delta = up ? (top - containerTop) : (bottom - containerBottom);
            doScrollY(delta);
        } //End block
    if(newFocused != findFocus())        
        newFocused.requestFocus(direction);
        boolean var98F0599AF776A1FE4101C199A40EEB8F_518444390 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_449153978 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_449153978;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.093 -0400", hash_original_method = "99A4FFBBF0B3182EC320D3CC49E9281B", hash_generated_method = "CF2A542EA51722B87F41EEC9F35220B7")
    public boolean arrowScroll(int direction) {
        addTaint(direction);
        View currentFocused = findFocus();
    if(currentFocused == this)        
        currentFocused = null;
        View nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused, direction);
        final int maxJump = getMaxScrollAmount();
    if(nextFocused != null && isWithinDeltaOfScreen(nextFocused, maxJump, getHeight()))        
        {
            nextFocused.getDrawingRect(mTempRect);
            offsetDescendantRectToMyCoords(nextFocused, mTempRect);
            int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
            doScrollY(scrollDelta);
            nextFocused.requestFocus(direction);
        } //End block
        else
        {
            int scrollDelta = maxJump;
    if(direction == View.FOCUS_UP && getScrollY() < scrollDelta)            
            {
                scrollDelta = getScrollY();
            } //End block
            else
    if(direction == View.FOCUS_DOWN)            
            {
    if(getChildCount() > 0)                
                {
                    int daBottom = getChildAt(0).getBottom();
                    int screenBottom = getScrollY() + getHeight() - mPaddingBottom;
    if(daBottom - screenBottom < maxJump)                    
                    {
                        scrollDelta = daBottom - screenBottom;
                    } //End block
                } //End block
            } //End block
    if(scrollDelta == 0)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1470100113 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_534122713 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_534122713;
            } //End block
            doScrollY(direction == View.FOCUS_DOWN ? scrollDelta : -scrollDelta);
        } //End block
    if(currentFocused != null && currentFocused.isFocused()
                && isOffScreen(currentFocused))        
        {
            final int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_152106335 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1323439876 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1323439876;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.094 -0400", hash_original_method = "98AD346ACFBFFAEC79BE4B86F94546B3", hash_generated_method = "84A9EDCDF28914CB27591043F19F6632")
    private boolean isOffScreen(View descendant) {
        addTaint(descendant.getTaint());
        boolean varC168571D25C9C1F94D9BFCC0E6F07A00_993492791 = (!isWithinDeltaOfScreen(descendant, 0, getHeight()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2126451312 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2126451312;
        // ---------- Original Method ----------
        //return !isWithinDeltaOfScreen(descendant, 0, getHeight());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.095 -0400", hash_original_method = "472E587EAA6D318183AF3AB1B7CEF83F", hash_generated_method = "5B7361DFA1BE81C1F44E693A0B8730F6")
    private boolean isWithinDeltaOfScreen(View descendant, int delta, int height) {
        addTaint(height);
        addTaint(delta);
        addTaint(descendant.getTaint());
        descendant.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(descendant, mTempRect);
        boolean var589720DD56B6ED067FEB74F3374B1F8A_2001883808 = ((mTempRect.bottom + delta) >= getScrollY()
                && (mTempRect.top - delta) <= (getScrollY() + height));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1568240536 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1568240536;
        // ---------- Original Method ----------
        //descendant.getDrawingRect(mTempRect);
        //offsetDescendantRectToMyCoords(descendant, mTempRect);
        //return (mTempRect.bottom + delta) >= getScrollY()
                //&& (mTempRect.top - delta) <= (getScrollY() + height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.095 -0400", hash_original_method = "8E606864EB91DBB174E2D5FEBC80C80F", hash_generated_method = "5E7BD625C7494551C88052F7FCABE25E")
    private void doScrollY(int delta) {
        addTaint(delta);
    if(delta != 0)        
        {
    if(mSmoothScrollingEnabled)            
            {
                smoothScrollBy(0, delta);
            } //End block
            else
            {
                scrollBy(0, delta);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (delta != 0) {
            //if (mSmoothScrollingEnabled) {
                //smoothScrollBy(0, delta);
            //} else {
                //scrollBy(0, delta);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.097 -0400", hash_original_method = "2EB75EC7C5D47510D212013AE17ECAD9", hash_generated_method = "5A4148F2069AE358CB74DBC67A6BAD65")
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
            final int height = getHeight() - mPaddingBottom - mPaddingTop;
            final int bottom = getChildAt(0).getHeight();
            final int maxY = Math.max(0, bottom - height);
            final int scrollY = mScrollY;
            dy = Math.max(0, Math.min(scrollY + dy, maxY)) - scrollY;
            mScroller.startScroll(mScrollX, scrollY, 0, dy);
            invalidate();
        } //End block
        else
        {
    if(!mScroller.isFinished())            
            {
                mScroller.abortAnimation();
    if(mFlingStrictSpan != null)                
                {
                    mFlingStrictSpan.finish();
                    mFlingStrictSpan = null;
                } //End block
            } //End block
            scrollBy(dx, dy);
        } //End block
        mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.098 -0400", hash_original_method = "EED648F6788EFF0F67B65ABAA0DE4CF2", hash_generated_method = "1619451DF2B1DD4BECD96649A5683C61")
    public final void smoothScrollTo(int x, int y) {
        addTaint(y);
        addTaint(x);
        smoothScrollBy(x - mScrollX, y - mScrollY);
        // ---------- Original Method ----------
        //smoothScrollBy(x - mScrollX, y - mScrollY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.098 -0400", hash_original_method = "91313F7EB1086727A920BA0C858900A2", hash_generated_method = "0E2AB541184B8E842E3706174A7375A0")
    @Override
    protected int computeVerticalScrollRange() {
        final int count = getChildCount();
        final int contentHeight = getHeight() - mPaddingBottom - mPaddingTop;
    if(count == 0)        
        {
            int varDFFC6190B05D9317FDEC99B9BFD11AC3_708618457 = (contentHeight);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691359300 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691359300;
        } //End block
        int scrollRange = getChildAt(0).getBottom();
        final int scrollY = mScrollY;
        final int overscrollBottom = Math.max(0, scrollRange - contentHeight);
    if(scrollY < 0)        
        {
            scrollRange -= scrollY;
        } //End block
        else
    if(scrollY > overscrollBottom)        
        {
            scrollRange += scrollY - overscrollBottom;
        } //End block
        int var94D4A3ECD79FF3E17EB5BD0659AF9AAE_1118280319 = (scrollRange);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_220545520 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_220545520;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.099 -0400", hash_original_method = "3295CF5A20E98E4F1F0B32253FD00545", hash_generated_method = "EDC140B004C60FC34625C96C8146F51C")
    @Override
    protected int computeVerticalScrollOffset() {
        int var686E5D95411597097844888A116E99A9_709406859 = (Math.max(0, super.computeVerticalScrollOffset()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1861233826 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1861233826;
        // ---------- Original Method ----------
        //return Math.max(0, super.computeVerticalScrollOffset());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.099 -0400", hash_original_method = "A9DFCA2E7D027D85128F33708BC045A3", hash_generated_method = "F9DB732CE0A97EF9E7CDA5E7356AC4D9")
    @Override
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        addTaint(parentHeightMeasureSpec);
        addTaint(parentWidthMeasureSpec);
        addTaint(child.getTaint());
        ViewGroup.LayoutParams lp = child.getLayoutParams();
        int childWidthMeasureSpec;
        int childHeightMeasureSpec;
        childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec, mPaddingLeft
                + mPaddingRight, lp.width);
        childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        // ---------- Original Method ----------
        //ViewGroup.LayoutParams lp = child.getLayoutParams();
        //int childWidthMeasureSpec;
        //int childHeightMeasureSpec;
        //childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec, mPaddingLeft
                //+ mPaddingRight, lp.width);
        //childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        //child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.100 -0400", hash_original_method = "39312C7B222B807E39D76A29FDE3363F", hash_generated_method = "653A27A5F06D6779223F1798C09673DC")
    @Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed,
            int parentHeightMeasureSpec, int heightUsed) {
        addTaint(heightUsed);
        addTaint(parentHeightMeasureSpec);
        addTaint(widthUsed);
        addTaint(parentWidthMeasureSpec);
        addTaint(child.getTaint());
        final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                mPaddingLeft + mPaddingRight + lp.leftMargin + lp.rightMargin
                        + widthUsed, lp.width);
        final int childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
                lp.topMargin + lp.bottomMargin, MeasureSpec.UNSPECIFIED);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        // ---------- Original Method ----------
        //final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        //final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                //mPaddingLeft + mPaddingRight + lp.leftMargin + lp.rightMargin
                        //+ widthUsed, lp.width);
        //final int childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
                //lp.topMargin + lp.bottomMargin, MeasureSpec.UNSPECIFIED);
        //child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.101 -0400", hash_original_method = "71999091E2F6915A9DB2336BBDDFAF94", hash_generated_method = "FBC2DCADE826E251B89EF806214AE1F6")
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
                overScrollBy(x - oldX, y - oldY, oldX, oldY, 0, range,
                        0, mOverflingDistance, false);
                onScrollChanged(mScrollX, mScrollY, oldX, oldY);
    if(canOverscroll)                
                {
    if(y < 0 && oldY >= 0)                    
                    {
                        mEdgeGlowTop.onAbsorb((int) mScroller.getCurrVelocity());
                    } //End block
                    else
    if(y > range && oldY <= range)                    
                    {
                        mEdgeGlowBottom.onAbsorb((int) mScroller.getCurrVelocity());
                    } //End block
                } //End block
            } //End block
            awakenScrollBars();
            postInvalidate();
        } //End block
        else
        {
    if(mFlingStrictSpan != null)            
            {
                mFlingStrictSpan.finish();
                mFlingStrictSpan = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.102 -0400", hash_original_method = "356AAB4A47E20FEC6EFC92C05FCA16CC", hash_generated_method = "8A00833E94125663E715DA215106C2E0")
    private void scrollToChild(View child) {
        addTaint(child.getTaint());
        child.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(child, mTempRect);
        int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
    if(scrollDelta != 0)        
        {
            scrollBy(0, scrollDelta);
        } //End block
        // ---------- Original Method ----------
        //child.getDrawingRect(mTempRect);
        //offsetDescendantRectToMyCoords(child, mTempRect);
        //int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
        //if (scrollDelta != 0) {
            //scrollBy(0, scrollDelta);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.103 -0400", hash_original_method = "D69703D23BD1E07705411D82E1BC609A", hash_generated_method = "8A861CFAAA7E82A98F477A463A9233C9")
    private boolean scrollToChildRect(Rect rect, boolean immediate) {
        addTaint(immediate);
        addTaint(rect.getTaint());
        final int delta = computeScrollDeltaToGetChildRectOnScreen(rect);
        final boolean scroll = delta != 0;
    if(scroll)        
        {
    if(immediate)            
            {
                scrollBy(0, delta);
            } //End block
            else
            {
                smoothScrollBy(0, delta);
            } //End block
        } //End block
        boolean var089B0CDD8835D09CB1CABF38B3CE9C09_439059540 = (scroll);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1483956153 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1483956153;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.107 -0400", hash_original_method = "8A5FFBB9A861965CD3F605D3125E7C0B", hash_generated_method = "DBCCF98FB718C46EA70464BA87064A7E")
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        addTaint(rect.getTaint());
    if(getChildCount() == 0)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_1297113845 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2031079823 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2031079823;
        }
        int height = getHeight();
        int screenTop = getScrollY();
        int screenBottom = screenTop + height;
        int fadingEdge = getVerticalFadingEdgeLength();
    if(rect.top > 0)        
        {
            screenTop += fadingEdge;
        } //End block
    if(rect.bottom < getChildAt(0).getHeight())        
        {
            screenBottom -= fadingEdge;
        } //End block
        int scrollYDelta = 0;
    if(rect.bottom > screenBottom && rect.top > screenTop)        
        {
    if(rect.height() > height)            
            {
                scrollYDelta += (rect.top - screenTop);
            } //End block
            else
            {
                scrollYDelta += (rect.bottom - screenBottom);
            } //End block
            int bottom = getChildAt(0).getBottom();
            int distanceToBottom = bottom - screenBottom;
            scrollYDelta = Math.min(scrollYDelta, distanceToBottom);
        } //End block
        else
    if(rect.top < screenTop && rect.bottom < screenBottom)        
        {
    if(rect.height() > height)            
            {
                scrollYDelta -= (screenBottom - rect.bottom);
            } //End block
            else
            {
                scrollYDelta -= (screenTop - rect.top);
            } //End block
            scrollYDelta = Math.max(scrollYDelta, -getScrollY());
        } //End block
        int var01B17C34592091A879C31B30A73D5FA3_1371082971 = (scrollYDelta);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1574813037 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1574813037;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.108 -0400", hash_original_method = "C2C4A47D49BA76A3A98712461E581564", hash_generated_method = "13A992C0A02A86749A86E776DD1237E5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.109 -0400", hash_original_method = "BC1790D54EF67B6E1EFAB03FC42BAB96", hash_generated_method = "DA866DE2C9E104E3C2D82D2AA5174D3A")
    @Override
    protected boolean onRequestFocusInDescendants(int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
    if(direction == View.FOCUS_FORWARD)        
        {
            direction = View.FOCUS_DOWN;
        } //End block
        else
    if(direction == View.FOCUS_BACKWARD)        
        {
            direction = View.FOCUS_UP;
        } //End block
        final View nextFocus = previouslyFocusedRect == null ?
                FocusFinder.getInstance().findNextFocus(this, null, direction) :
                FocusFinder.getInstance().findNextFocusFromRect(this,
                        previouslyFocusedRect, direction);
    if(nextFocus == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_2060453299 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_167385692 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_167385692;
        } //End block
    if(isOffScreen(nextFocus))        
        {
            boolean var68934A3E9455FA72420237EB05902327_779140949 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_624081703 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_624081703;
        } //End block
        boolean var19AC7E01A4DA8FE4B22BFDF34DB33D51_179810301 = (nextFocus.requestFocus(direction, previouslyFocusedRect));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1175665974 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1175665974;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.109 -0400", hash_original_method = "50E2DA7CF8E403536932E3B77491E964", hash_generated_method = "21D509CC3631EA2AE06E9B217618BE41")
    @Override
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle,
            boolean immediate) {
        addTaint(immediate);
        addTaint(rectangle.getTaint());
        addTaint(child.getTaint());
        rectangle.offset(child.getLeft() - child.getScrollX(),
                child.getTop() - child.getScrollY());
        boolean var10C2B91B22AF1483455A09D794128372_1411954772 = (scrollToChildRect(rectangle, immediate));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1659373564 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1659373564;
        // ---------- Original Method ----------
        //rectangle.offset(child.getLeft() - child.getScrollX(),
                //child.getTop() - child.getScrollY());
        //return scrollToChildRect(rectangle, immediate);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.110 -0400", hash_original_method = "31751D7E496E2D7BD9B4D4E94AD28515", hash_generated_method = "11A20A1DA3E3F0E4689DA3F629925C7D")
    @Override
    public void requestLayout() {
        mIsLayoutDirty = true;
        super.requestLayout();
        // ---------- Original Method ----------
        //mIsLayoutDirty = true;
        //super.requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.110 -0400", hash_original_method = "E0B1FFFA746AE76ECF17449388BCEBCA", hash_generated_method = "225DC6CC26B17A910222CCAFA34810E4")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
    if(mScrollStrictSpan != null)        
        {
            mScrollStrictSpan.finish();
            mScrollStrictSpan = null;
        } //End block
    if(mFlingStrictSpan != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.111 -0400", hash_original_method = "51521A672083F0AD2F639BD854AB8D0F", hash_generated_method = "0FF04B3425BEE3DDBF54B80FEC67BB3C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.112 -0400", hash_original_method = "35BE22C8E7AB63B977E9EAA0D1A8EAA6", hash_generated_method = "17FBFDB5D6D81E53A1B804C4F53E4569")
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
    if(isWithinDeltaOfScreen(currentFocused, 0, oldh))        
        {
            currentFocused.getDrawingRect(mTempRect);
            offsetDescendantRectToMyCoords(currentFocused, mTempRect);
            int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
            doScrollY(scrollDelta);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.112 -0400", hash_original_method = "25276A1ACE97D138BB17C9052B223D37", hash_generated_method = "FA7B8C9B1BE8F3C6F484E2FF17E948EE")
    private boolean isViewDescendantOf(View child, View parent) {
        addTaint(parent.getTaint());
        addTaint(child.getTaint());
    if(child == parent)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1011514638 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_943410450 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_943410450;
        } //End block
        final ViewParent theParent = child.getParent();
        boolean var6F793E02A243A0ADE05122683367FBA6_1272753446 = ((theParent instanceof ViewGroup) && isViewDescendantOf((View) theParent, parent));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2020870388 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2020870388;
        // ---------- Original Method ----------
        //if (child == parent) {
            //return true;
        //}
        //final ViewParent theParent = child.getParent();
        //return (theParent instanceof ViewGroup) && isViewDescendantOf((View) theParent, parent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.113 -0400", hash_original_method = "C7B4AEF12870EFF4E9873FB61486C527", hash_generated_method = "C8E2A5D9C29B373B13C7DA3057B97BC2")
    public void fling(int velocityY) {
        addTaint(velocityY);
    if(getChildCount() > 0)        
        {
            int height = getHeight() - mPaddingBottom - mPaddingTop;
            int bottom = getChildAt(0).getHeight();
            mScroller.fling(mScrollX, mScrollY, 0, velocityY, 0, 0, 0,
                    Math.max(0, bottom - height), 0, height/2);
            final boolean movingDown = velocityY > 0;
    if(mFlingStrictSpan == null)            
            {
                mFlingStrictSpan = StrictMode.enterCriticalSpan("ScrollView-fling");
            } //End block
            invalidate();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.114 -0400", hash_original_method = "526DB7CB9D9E6BCF2CDE3F8A7F1D2890", hash_generated_method = "F0BA9B0CA89D79E35624931D8EC9DA98")
    private void endDrag() {
        mIsBeingDragged = false;
        recycleVelocityTracker();
    if(mEdgeGlowTop != null)        
        {
            mEdgeGlowTop.onRelease();
            mEdgeGlowBottom.onRelease();
        } //End block
    if(mScrollStrictSpan != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.115 -0400", hash_original_method = "748C5914370A5F8CDD8109B6F4611B5B", hash_generated_method = "0D6230820B8CF3ACD12B82804532AC3B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.115 -0400", hash_original_method = "3BD104A12D7CF3E01CAF1DA422C489F3", hash_generated_method = "43AD6AF537E38C837754F889C2E9FA53")
    @Override
    public void setOverScrollMode(int mode) {
        addTaint(mode);
    if(mode != OVER_SCROLL_NEVER)        
        {
    if(mEdgeGlowTop == null)            
            {
                Context context = getContext();
                mEdgeGlowTop = new EdgeEffect(context);
                mEdgeGlowBottom = new EdgeEffect(context);
            } //End block
        } //End block
        else
        {
            mEdgeGlowTop = null;
            mEdgeGlowBottom = null;
        } //End block
        super.setOverScrollMode(mode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.116 -0400", hash_original_method = "50FAD524FA6B782881C70ABEF15C4DDF", hash_generated_method = "7B605499828C1B19E16C2E45446CA06D")
    @Override
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        super.draw(canvas);
    if(mEdgeGlowTop != null)        
        {
            final int scrollY = mScrollY;
    if(!mEdgeGlowTop.isFinished())            
            {
                final int restoreCount = canvas.save();
                final int width = getWidth() - mPaddingLeft - mPaddingRight;
                canvas.translate(mPaddingLeft, Math.min(0, scrollY));
                mEdgeGlowTop.setSize(width, getHeight());
    if(mEdgeGlowTop.draw(canvas))                
                {
                    invalidate();
                } //End block
                canvas.restoreToCount(restoreCount);
            } //End block
    if(!mEdgeGlowBottom.isFinished())            
            {
                final int restoreCount = canvas.save();
                final int width = getWidth() - mPaddingLeft - mPaddingRight;
                final int height = getHeight();
                canvas.translate(-width + mPaddingLeft,
                        Math.max(getScrollRange(), scrollY) + height);
                canvas.rotate(180, width, 0);
                mEdgeGlowBottom.setSize(width, height);
    if(mEdgeGlowBottom.draw(canvas))                
                {
                    invalidate();
                } //End block
                canvas.restoreToCount(restoreCount);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.117 -0400", hash_original_method = "10E81B579101690AB90AC933866D5438", hash_generated_method = "98D10F4F19A585E87F519370E202BFAC")
    private int clamp(int n, int my, int child) {
        addTaint(child);
        addTaint(my);
        addTaint(n);
    if(my >= child || n < 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1532108618 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_430230631 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_430230631;
        } //End block
    if((my+n) > child)        
        {
            int varE1D3AD86DD07AC8C66A79759D52C323C_503065204 = (child-my);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_329583126 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_329583126;
        } //End block
        int var7B8B965AD4BCA0E41AB51DE7B31363A1_216222758 = (n);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_864180364 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_864180364;
        // ---------- Original Method ----------
        //if (my >= child || n < 0) {
            //return 0;
        //}
        //if ((my+n) > child) {
            //return child-my;
        //}
        //return n;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.117 -0400", hash_original_field = "D4B6C25D0A03D262C947BCD869108225", hash_generated_field = "0DB9E46E1BC530D48AB4117911138FC2")

    static final int ANIMATED_SCROLL_GAP = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.117 -0400", hash_original_field = "9BFFC1AB0B9FE2B016F88B3E293FEE4F", hash_generated_field = "58258D94D76BAF55ECF7DADE8930E574")

    static final float MAX_SCROLL_FACTOR = 0.5f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.117 -0400", hash_original_field = "7EF8B2C57AC3A1D5EC1190F4098C6121", hash_generated_field = "E2DAEB44FC73F85759FCDB42BA10BD3A")

    private static final int INVALID_POINTER = -1;
}

