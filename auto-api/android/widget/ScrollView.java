package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.489 -0400", hash_original_field = "380EFAD062415C5D611446C1B15B307D", hash_generated_field = "507FF60BF6AED501221786F4F9B1C4CE")

    private long mLastScroll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.489 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

    private final Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.489 -0400", hash_original_field = "360DD66618E954525BEA0D65B05DC7EC", hash_generated_field = "7106C69F4E49AB9D7F59F38965DF6036")

    private OverScroller mScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.489 -0400", hash_original_field = "89E135B7087DB76810F3F37EE0DAB560", hash_generated_field = "E572968A85247BF2ECB5635FFF539C2E")

    private EdgeEffect mEdgeGlowTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.490 -0400", hash_original_field = "289036755C83C8893D6004D3220BA45B", hash_generated_field = "D2A4A7BE91BF29EB90E114C9648825A6")

    private EdgeEffect mEdgeGlowBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.490 -0400", hash_original_field = "4925C8499D6FECBA832A37F55AA6C69B", hash_generated_field = "2D88D85D441545A6227529A03C0B4E71")

    private float mLastMotionY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.490 -0400", hash_original_field = "A43EC71B2E74CACC223B47379717A080", hash_generated_field = "9C16E67A6EDB3E799E01AFB02BCF7815")

    private boolean mIsLayoutDirty = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.490 -0400", hash_original_field = "8949A253727FAE7FB577F98D2A9463C2", hash_generated_field = "7E1EAB0DC4AB4B81BAB22B01D588949E")

    private View mChildToScrollTo = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.490 -0400", hash_original_field = "A8AB6008485C6E787B3DBB97D2050FF4", hash_generated_field = "40AA109CDE3739730D8C499D23D26FF1")

    private boolean mIsBeingDragged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.490 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.490 -0400", hash_original_field = "B3E3E62AA85A925921DCB2869A4E7017", hash_generated_field = "16DDF79C39D64DD0F8B72040D2242A75")

    @ViewDebug.ExportedProperty(category = "layout") private boolean mFillViewport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.490 -0400", hash_original_field = "581BD96ACB5FC0F4F529183E58EA63B2", hash_generated_field = "EA3AE5CC17F6060C1DBAA2AAAFFFC35C")

    private boolean mSmoothScrollingEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.490 -0400", hash_original_field = "3DFFFAD10926598D18EEC50D61DE79CA", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.490 -0400", hash_original_field = "30B0DF23DBDF2426D66E4D98494C369B", hash_generated_field = "7DBE1A18599B8760DC9B67AAFE3499E3")

    private int mMinimumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.490 -0400", hash_original_field = "1C66D9179508D091F8E90C9FEBAD15CA", hash_generated_field = "6F997413D0B227487940C402EB78A8FD")

    private int mMaximumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.490 -0400", hash_original_field = "7A5B6F76BA72A8D6AFCFCEA14B8C2556", hash_generated_field = "7B0107E1CAE9FFC281D766335539D7C4")

    private int mOverscrollDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.490 -0400", hash_original_field = "755491871A4FCE3E01181030F8FEB178", hash_generated_field = "06022A8A798B4C892D35D0FFB16D2FDF")

    private int mOverflingDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.490 -0400", hash_original_field = "D0F34CC6DB83FC46AEC38F19CA5CE138", hash_generated_field = "1B464B20D80463EC30779F63AB0559BD")

    private int mActivePointerId = INVALID_POINTER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.490 -0400", hash_original_field = "D2BBDD4FC0A41CFC280764A4FBDC4D52", hash_generated_field = "BA5EBFF9CCBAD624E5B38890A6227093")

    private StrictMode.Span mScrollStrictSpan = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.490 -0400", hash_original_field = "A914CE4AFB85B902CB007BE88097BB3F", hash_generated_field = "1B2DFB133C9B4AE33C58293244DDF261")

    private StrictMode.Span mFlingStrictSpan = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.490 -0400", hash_original_method = "4713E1355E9C805E185DB05E4B4B9810", hash_generated_method = "D94FF7D50EC38B3687BB3B0C7B5552B0")
    public  ScrollView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.490 -0400", hash_original_method = "D709104905B863FC98F9383546426518", hash_generated_method = "18D71EA425ED840CDB485C506CBAC309")
    public  ScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.scrollViewStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.491 -0400", hash_original_method = "A71F55C63B3167922F139A658C272800", hash_generated_method = "D993960E65ECDB5BC88C492311895176")
    public  ScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initScrollView();
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.ScrollView, defStyle, 0);
        setFillViewport(a.getBoolean(R.styleable.ScrollView_fillViewport, false));
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.491 -0400", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "FAA97586D79C57BB3592C6194BDA7D6F")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1879544892 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1879544892;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.491 -0400", hash_original_method = "2B5BCBF9645A95C024C3D4122E8D2438", hash_generated_method = "E4DD79CAF6FD42A930CAA065EAC0394E")
    @Override
    protected float getTopFadingEdgeStrength() {
        {
            boolean varF370735710C80808B6618BA2D491D045_1164242860 = (getChildCount() == 0);
        } 
        final int length = getVerticalFadingEdgeLength();
        float var546ADE640B6EDFBC8A086EF31347E768_61039982 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_61039982;
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.492 -0400", hash_original_method = "F0E4C184CA27C21FD42267E77DCA1374", hash_generated_method = "E2D0AAE1798183D49C3A4EA9711D3074")
    @Override
    protected float getBottomFadingEdgeStrength() {
        {
            boolean varF370735710C80808B6618BA2D491D045_201256289 = (getChildCount() == 0);
        } 
        final int length = getVerticalFadingEdgeLength();
        final int bottomEdge = getHeight() - mPaddingBottom;
        final int span = getChildAt(0).getBottom() - mScrollY - bottomEdge;
        float var546ADE640B6EDFBC8A086EF31347E768_691104180 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_691104180;
        
        
            
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.492 -0400", hash_original_method = "13CC3D3BB67006B8B223FEAA5CEB8AD3", hash_generated_method = "F3E6DC38504AF74A694CDB151F9761C3")
    public int getMaxScrollAmount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897193608 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897193608;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.493 -0400", hash_original_method = "02BBAF53D85E267FB240E2D4309C877F", hash_generated_method = "02BFF61AA3D9E1FA9C55929FA1EDF318")
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
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.493 -0400", hash_original_method = "C2B46C856A31C41C5B4609404338EFA0", hash_generated_method = "8181AC5A52966B2D4A52D3164D6E3440")
    @Override
    public void addView(View child) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1401493136 = (getChildCount() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("ScrollView can host only one direct child");
            } 
        } 
        super.addView(child);
        addTaint(child.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.494 -0400", hash_original_method = "E948CE4EC40C516B64A70B82C4D41ABE", hash_generated_method = "D6B5EC1B3BA761531D42718C39CF862E")
    @Override
    public void addView(View child, int index) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1582805131 = (getChildCount() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("ScrollView can host only one direct child");
            } 
        } 
        super.addView(child, index);
        addTaint(child.getTaint());
        addTaint(index);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.494 -0400", hash_original_method = "34A1DE7AC13648E903519BA7AEB15B21", hash_generated_method = "640A95EB535ACB93B1E3BAE83997EB1D")
    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1635076624 = (getChildCount() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("ScrollView can host only one direct child");
            } 
        } 
        super.addView(child, params);
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.495 -0400", hash_original_method = "363983D07DF3EAAC15B8A0529305BE77", hash_generated_method = "DE2A50BC1F89795B0A11B7AE4AD53968")
    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1359590221 = (getChildCount() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("ScrollView can host only one direct child");
            } 
        } 
        super.addView(child, index, params);
        addTaint(child.getTaint());
        addTaint(index);
        addTaint(params.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.495 -0400", hash_original_method = "F1DEDB4D65582CE354A1D843D55A4B55", hash_generated_method = "5E336291C071C6B661215908615DBD02")
    private boolean canScroll() {
        View child = getChildAt(0);
        {
            int childHeight = child.getHeight();
            boolean var3A415DE46D6A024E28376F2A13A712DB_861959233 = (getHeight() < childHeight + mPaddingTop + mPaddingBottom);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_258550871 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_258550871;
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.495 -0400", hash_original_method = "801E6F065AC6A60CFB0DADB1E074F98E", hash_generated_method = "8FE399D72F1006E98140067C30B34433")
    public boolean isFillViewport() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1871729370 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1871729370;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.496 -0400", hash_original_method = "D2588C7F74D0E18DF5DFA629FE7BF270", hash_generated_method = "2659D9B4D00861C682890CC931AD720B")
    public void setFillViewport(boolean fillViewport) {
        {
            mFillViewport = fillViewport;
            requestLayout();
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.496 -0400", hash_original_method = "D26C58327C0CB18AC1F62B7629FD16B1", hash_generated_method = "8EF1D9E7BEEB956833471DB11835DC0C")
    public boolean isSmoothScrollingEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2009568510 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2009568510;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.496 -0400", hash_original_method = "63C96CE84D9CD60CA1FF4EF87D7FF4F5", hash_generated_method = "5C7F23BB3E765786BEE5D256B048D32A")
    public void setSmoothScrollingEnabled(boolean smoothScrollingEnabled) {
        mSmoothScrollingEnabled = smoothScrollingEnabled;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.497 -0400", hash_original_method = "1504CEEE6604563B648201D50795D68C", hash_generated_method = "D4AE489F4E9418E78AEA1C3F3D02B0E2")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1112452067 = (getChildCount() > 0);
            {
                final View child = getChildAt(0);
                int height = getMeasuredHeight();
                {
                    boolean varEEEC94D0CC5FB640673872B86A985E2B_1145385559 = (child.getMeasuredHeight() < height);
                    {
                        final FrameLayout.LayoutParams lp = (LayoutParams) child.getLayoutParams();
                        int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec,
                        mPaddingLeft + mPaddingRight, lp.width);
                        height -= mPaddingTop;
                        height -= mPaddingBottom;
                        int childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
                        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                    } 
                } 
            } 
        } 
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.497 -0400", hash_original_method = "40D3C8E04EF2AEB04EFDF302E05EC516", hash_generated_method = "D18676A2A4FD36741432C5E3F72B3EDB")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        boolean var160A6DCE359009EE36E492A233BEB313_832804011 = (super.dispatchKeyEvent(event) || executeKeyEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1138417309 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1138417309;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.498 -0400", hash_original_method = "1E6EE1FACBE8E24D9D58E940A1542C55", hash_generated_method = "F3989E46347C802BB5155453CECEA028")
    public boolean executeKeyEvent(KeyEvent event) {
        mTempRect.setEmpty();
        {
            boolean varF142AAB9B9E2812C95D81D43568D13C8_890973093 = (!canScroll());
            {
                {
                    boolean var2897164B636FEEE3DA92631EEF7087B0_365736093 = (isFocused() && event.getKeyCode() != KeyEvent.KEYCODE_BACK);
                    {
                        View currentFocused = findFocus();
                        {
                            boolean varCCA9B61B8A448B09DE583C4C7BFDEFBB_1742565820 = (currentFocused == this);
                            currentFocused = null;
                        } 
                        View nextFocused = FocusFinder.getInstance().findNextFocus(this,
                        currentFocused, View.FOCUS_DOWN);
                        boolean varD482CC356741D5879BD547A170E814F4_1736634139 = (nextFocused != null
                        && nextFocused != this
                        && nextFocused.requestFocus(View.FOCUS_DOWN));
                    } 
                } 
            } 
        } 
        boolean handled = false;
        {
            boolean varE78E9647F4429F5955AD42D05C6FEF7A_1650996832 = (event.getAction() == KeyEvent.ACTION_DOWN);
            {
                {
                    Object varA0761DC6508339A4AD5D875712ADE561_1967097918 = (event.getKeyCode());
                    
                    {
                        boolean var6263B7F37C2CF1348DCC37C937DB4EA5_1552040026 = (!event.isAltPressed());
                        {
                            handled = arrowScroll(View.FOCUS_UP);
                        } 
                        {
                            handled = fullScroll(View.FOCUS_UP);
                        } 
                    } 
                    
                    
                    {
                        boolean var6263B7F37C2CF1348DCC37C937DB4EA5_576165035 = (!event.isAltPressed());
                        {
                            handled = arrowScroll(View.FOCUS_DOWN);
                        } 
                        {
                            handled = fullScroll(View.FOCUS_DOWN);
                        } 
                    } 
                    
                    
                    pageScroll(event.isShiftPressed() ? View.FOCUS_UP : View.FOCUS_DOWN);
                    
                } 
            } 
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_583092987 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_583092987;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.498 -0400", hash_original_method = "21B5B152D5EE02017A0CB65ECB9B3403", hash_generated_method = "84F01D69C0D904EE890D9393C34CF091")
    private boolean inChild(int x, int y) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1477261305 = (getChildCount() > 0);
            {
                final int scrollY = mScrollY;
                final View child = getChildAt(0);
                boolean varB6F197A68897B2FF8EC1E9EDD5403361_1010366156 = (!(y < child.getTop() - scrollY
                    || y >= child.getBottom() - scrollY
                    || x < child.getLeft()
                    || x >= child.getRight()));
            } 
        } 
        addTaint(x);
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2033973210 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2033973210;
        
        
            
            
            
                    
                    
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.499 -0400", hash_original_method = "2F2E3E2ED97C397B1954EFE1C35FD1EF", hash_generated_method = "D2F7B701FF4A7C7D5D9BBE60A4204A34")
    private void initOrResetVelocityTracker() {
        {
            mVelocityTracker = VelocityTracker.obtain();
        } 
        {
            mVelocityTracker.clear();
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.499 -0400", hash_original_method = "2C2F1E0A6C232182F8110D9EE75ED47E", hash_generated_method = "A47C5AEFF80C521B346EFD43CCEC463A")
    private void initVelocityTrackerIfNotExists() {
        {
            mVelocityTracker = VelocityTracker.obtain();
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.499 -0400", hash_original_method = "FC3B581D4963BCED4340031BA20C5421", hash_generated_method = "4A5B29B306AF5EDD25C8547D1436EB51")
    private void recycleVelocityTracker() {
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.499 -0400", hash_original_method = "C74400E8950C106883E854683AF24673", hash_generated_method = "9EE44C43E2819EE39A2C95C618F793B6")
    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        {
            recycleVelocityTracker();
        } 
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
        addTaint(disallowIntercept);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.500 -0400", hash_original_method = "A618CDF234D118EA8A225B0CD965AEA3", hash_generated_method = "61CFC31F65319CD33EF6CBB4382E7112")
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        
        final int action = ev.getAction();
        
        {
            final int activePointerId = mActivePointerId;
            final int pointerIndex = ev.findPointerIndex(activePointerId);
            final float y = ev.getY(pointerIndex);
            final int yDiff = (int) Math.abs(y - mLastMotionY);
            {
                mIsBeingDragged = true;
                mLastMotionY = y;
                initVelocityTrackerIfNotExists();
                mVelocityTracker.addMovement(ev);
                {
                    mScrollStrictSpan = StrictMode.enterCriticalSpan("ScrollView-scroll");
                } 
            } 
        } 
        
        
        {
            final float y = ev.getY();
            {
                boolean varFF34B1086FC4594476FFD6F360BBB78C_1226722886 = (!inChild((int) ev.getX(), (int) y));
                {
                    mIsBeingDragged = false;
                    recycleVelocityTracker();
                } 
            } 
            mLastMotionY = y;
            mActivePointerId = ev.getPointerId(0);
            initOrResetVelocityTracker();
            mVelocityTracker.addMovement(ev);
            mIsBeingDragged = !mScroller.isFinished();
            {
                mScrollStrictSpan = StrictMode.enterCriticalSpan("ScrollView-scroll");
            } 
        } 
        
        
        mIsBeingDragged = false;
        
        
        mActivePointerId = INVALID_POINTER;
        
        
        recycleVelocityTracker();
        
        
        {
            boolean var5A644DDFA364D0381E7012BF55F348DC_1689387609 = (mScroller.springBack(mScrollX, mScrollY, 0, 0, 0, getScrollRange()));
            {
                invalidate();
            } 
        } 
        
        
        onSecondaryPointerUp(ev);
        
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1979022592 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1979022592;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.502 -0400", hash_original_method = "83F23D23BD0BAB2CB063E24A3B111651", hash_generated_method = "F4363BA3A466FC6453BB50E73C67537F")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        
        initVelocityTrackerIfNotExists();
        mVelocityTracker.addMovement(ev);
        final int action = ev.getAction();
        
        {
            mIsBeingDragged = getChildCount() != 0;
            {
                boolean var11F6C92CC339B9B3B7C0C85A8DBD1165_1891720526 = (!mScroller.isFinished());
                {
                    mScroller.abortAnimation();
                    {
                        mFlingStrictSpan.finish();
                        mFlingStrictSpan = null;
                    } 
                } 
            } 
            mLastMotionY = ev.getY();
            mActivePointerId = ev.getPointerId(0);
        } 
        
        
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
            {
                boolean var670E8200B9D4E089C7377D895DE2F86E_383492436 = (overScrollBy(0, deltaY, 0, mScrollY,
                            0, range, 0, mOverscrollDistance, true));
                {
                    mVelocityTracker.clear();
                } 
            } 
            onScrollChanged(mScrollX, mScrollY, oldX, oldY);
            {
                final int pulledToY = oldY + deltaY;
                {
                    mEdgeGlowTop.onPull((float) deltaY / getHeight());
                    {
                        boolean varE6213428B20479BD32BF17B140F5ED52_770070039 = (!mEdgeGlowBottom.isFinished());
                        {
                            mEdgeGlowBottom.onRelease();
                        } 
                    } 
                } 
                {
                    mEdgeGlowBottom.onPull((float) deltaY / getHeight());
                    {
                        boolean var5D6A56784A8F83A042E55ED0998DBE18_1288832315 = (!mEdgeGlowTop.isFinished());
                        {
                            mEdgeGlowTop.onRelease();
                        } 
                    } 
                } 
                {
                    boolean var4BAAB9D93C535A28BF0C04887423354C_459200066 = (mEdgeGlowTop != null
                                && (!mEdgeGlowTop.isFinished() || !mEdgeGlowBottom.isFinished()));
                    {
                        invalidate();
                    } 
                } 
            } 
        } 
        
        
        {
            final VelocityTracker velocityTracker = mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
            int initialVelocity = (int) velocityTracker.getYVelocity(mActivePointerId);
            {
                boolean var9C190A50DA656473F4A85C2EF380F022_1444013280 = (getChildCount() > 0);
                {
                    {
                        boolean varCB55D3BE2E93A2FD55EF78A581740AFC_1193615017 = ((Math.abs(initialVelocity) > mMinimumVelocity));
                        {
                            fling(-initialVelocity);
                        } 
                        {
                            {
                                boolean varC93C7034440DD4C8753F4F2114A84A37_1895674162 = (mScroller.springBack(mScrollX, mScrollY, 0, 0, 0,
                                    getScrollRange()));
                                {
                                    invalidate();
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            mActivePointerId = INVALID_POINTER;
            endDrag();
        } 
        
        
        {
            boolean var9286919EB531712C93F03BFB604683F8_1126911996 = (mIsBeingDragged && getChildCount() > 0);
            {
                {
                    boolean var0B94B4CD263DE1DB92077C5CA547FAC2_468954537 = (mScroller.springBack(mScrollX, mScrollY, 0, 0, 0, getScrollRange()));
                    {
                        invalidate();
                    } 
                } 
                mActivePointerId = INVALID_POINTER;
                endDrag();
            } 
        } 
        
        
        {
            final int index = ev.getActionIndex();
            final float y = ev.getY(index);
            mLastMotionY = y;
            mActivePointerId = ev.getPointerId(index);
        } 
        
        
        onSecondaryPointerUp(ev);
        
        
        mLastMotionY = ev.getY(ev.findPointerIndex(mActivePointerId));
        
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_9221292 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_9221292;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.502 -0400", hash_original_method = "1724FA32F4E11B8EDA6825E1236F6DA2", hash_generated_method = "93E8CF5F4E533BBCFB8EAEF969BB2AA0")
    private void onSecondaryPointerUp(MotionEvent ev) {
        final int pointerIndex = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >>
                MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        final int pointerId = ev.getPointerId(pointerIndex);
        {
            int newPointerIndex;
            newPointerIndex = 1;
            newPointerIndex = 0;
            mLastMotionY = ev.getY(newPointerIndex);
            mActivePointerId = ev.getPointerId(newPointerIndex);
            {
                mVelocityTracker.clear();
            } 
        } 
        
        
                
        
        
            
            
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.503 -0400", hash_original_method = "ABBC11F59DDEDBBBBFE897034F702501", hash_generated_method = "38DF9B7358538FF729FBF3EBF553EF8D")
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        
        {
            boolean varB5CEEFE1A0B0FE6CF2A2378211A03C4D_572362721 = ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0);
            {
                {
                    Object varC2BF00F96F1D1B1ABEF4B0E3FC4FE9EC_1007225406 = (event.getAction());
                    
                    {
                        {
                            final float vscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                            {
                                final int delta = (int) (vscroll * getVerticalScrollFactor());
                                final int range = getScrollRange();
                                int oldScrollY = mScrollY;
                                int newScrollY = oldScrollY - delta;
                                {
                                    newScrollY = 0;
                                } 
                                {
                                    newScrollY = range;
                                } 
                                {
                                    super.scrollTo(mScrollX, newScrollY);
                                } 
                            } 
                        } 
                    } 
                    
                } 
            } 
        } 
        boolean var32C1E3DF40BCC120C79428C7AEB27DD1_1612221062 = (super.onGenericMotionEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1453403769 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1453403769;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.503 -0400", hash_original_method = "CC5D228BD55E3E42D5A6CE954C441DF3", hash_generated_method = "F3204F4253BF66E64FE9040CEB79DB2A")
    @Override
    protected void onOverScrolled(int scrollX, int scrollY,
            boolean clampedX, boolean clampedY) {
        
        {
            boolean var2844BA5E42FD344CC642021B350DFDAC_1570823014 = (!mScroller.isFinished());
            {
                mScrollX = scrollX;
                mScrollY = scrollY;
                invalidateParentIfNeeded();
                {
                    mScroller.springBack(mScrollX, mScrollY, 0, 0, 0, getScrollRange());
                } 
            } 
            {
                super.scrollTo(scrollX, scrollY);
            } 
        } 
        awakenScrollBars();
        addTaint(scrollX);
        addTaint(scrollY);
        addTaint(clampedX);
        addTaint(clampedY);
        
        
            
            
            
            
                
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.503 -0400", hash_original_method = "AF8EC74B0AD4D69DC5ACACFC8749064F", hash_generated_method = "61EE9670444DDDD9440F00D0D1F34A0C")
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        
        super.onInitializeAccessibilityNodeInfo(info);
        info.setScrollable(getScrollRange() > 0);
        addTaint(info.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.504 -0400", hash_original_method = "F1695E9318A6A21B761B35BD458E866B", hash_generated_method = "E04C79992153212AFEF70BA91D714C1D")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        
        super.onInitializeAccessibilityEvent(event);
        final boolean scrollable = getScrollRange() > 0;
        event.setScrollable(scrollable);
        event.setScrollX(mScrollX);
        event.setScrollY(mScrollY);
        event.setMaxScrollX(mScrollX);
        event.setMaxScrollY(getScrollRange());
        addTaint(event.getTaint());
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.505 -0400", hash_original_method = "54B8D0E6795D053FB63A6E55BD2EA0C5", hash_generated_method = "340C4DF4553DA01832117512C8002774")
    private int getScrollRange() {
        int scrollRange = 0;
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_234531929 = (getChildCount() > 0);
            {
                View child = getChildAt(0);
                scrollRange = Math.max(0,
                    child.getHeight() - (getHeight() - mPaddingBottom - mPaddingTop));
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1495061810 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1495061810;
        
        
        
            
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.506 -0400", hash_original_method = "CCA8F1BE638FE2EC5E8781CBB11ADD24", hash_generated_method = "7B70CEA0474E9846E9BC075F285BF554")
    private View findFocusableViewInMyBounds(final boolean topFocus,
            final int top, View preferredFocusable) {
        View varB4EAC82CA7396A68D541C85D26508E83_1835300276 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1044630368 = null; 
        final int fadingEdgeLength = getVerticalFadingEdgeLength() / 2;
        final int topWithoutFadingEdge = top + fadingEdgeLength;
        final int bottomWithoutFadingEdge = top + getHeight() - fadingEdgeLength;
        {
            boolean var779C321780A81D8A63D26CAE3AB982D5_1996144184 = ((preferredFocusable != null)
                && (preferredFocusable.getTop() < bottomWithoutFadingEdge)
                && (preferredFocusable.getBottom() > topWithoutFadingEdge));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1835300276 = preferredFocusable;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1044630368 = findFocusableViewInBounds(topFocus, topWithoutFadingEdge,
                bottomWithoutFadingEdge);
        addTaint(topFocus);
        addTaint(top);
        addTaint(preferredFocusable.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1463139365; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1463139365 = varB4EAC82CA7396A68D541C85D26508E83_1835300276;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1463139365 = varB4EAC82CA7396A68D541C85D26508E83_1044630368;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1463139365.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1463139365;
        
        
        
        
        
                
                
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.508 -0400", hash_original_method = "78998B2E5B42D469D0E131861596BD99", hash_generated_method = "C70ED500C253EBE4DB54C7D3A7EC5E83")
    private View findFocusableViewInBounds(boolean topFocus, int top, int bottom) {
        View varB4EAC82CA7396A68D541C85D26508E83_528707301 = null; 
        List<View> focusables = getFocusables(View.FOCUS_FORWARD);
        View focusCandidate = null;
        boolean foundFullyContainedFocusable = false;
        int count = focusables.size();
        {
            int i = 0;
            {
                View view = focusables.get(i);
                int viewTop = view.getTop();
                int viewBottom = view.getBottom();
                {
                    final boolean viewIsFullyContained = (top < viewTop) &&
                        (viewBottom < bottom);
                    {
                        focusCandidate = view;
                        foundFullyContainedFocusable = viewIsFullyContained;
                    } 
                    {
                        final boolean viewIsCloserToBoundary = (topFocus && viewTop < focusCandidate.getTop()) ||
                                    (!topFocus && viewBottom > focusCandidate
                                            .getBottom());
                        {
                            {
                                focusCandidate = view;
                            } 
                        } 
                        {
                            {
                                focusCandidate = view;
                                foundFullyContainedFocusable = true;
                            } 
                            {
                                focusCandidate = view;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_528707301 = focusCandidate;
        addTaint(topFocus);
        addTaint(top);
        addTaint(bottom);
        varB4EAC82CA7396A68D541C85D26508E83_528707301.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_528707301;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.508 -0400", hash_original_method = "8096444783AE8C9AF2A604C00C6FDBC2", hash_generated_method = "ECB0F2080E083D815654E3986CA44C21")
    public boolean pageScroll(int direction) {
        boolean down = direction == View.FOCUS_DOWN;
        int height = getHeight();
        {
            mTempRect.top = getScrollY() + height;
            int count = getChildCount();
            {
                View view = getChildAt(count - 1);
                {
                    boolean varED85C349B0DA33BB45D7B420A69B2E3A_1781690763 = (mTempRect.top + height > view.getBottom());
                    {
                        mTempRect.top = view.getBottom() - height;
                    } 
                } 
            } 
        } 
        {
            mTempRect.top = getScrollY() - height;
            {
                mTempRect.top = 0;
            } 
        } 
        mTempRect.bottom = mTempRect.top + height;
        boolean var39A84547F8736C141B73A0089E5E641A_1088771425 = (scrollAndFocus(direction, mTempRect.top, mTempRect.bottom));
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1893500777 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1893500777;
        
        
        
        
            
            
            
                
                
                    
                
            
        
            
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.509 -0400", hash_original_method = "E10B42C26E723F278A5695B0C5DAB2DB", hash_generated_method = "E626B59741F006B3C201FAE782829A44")
    public boolean fullScroll(int direction) {
        boolean down = direction == View.FOCUS_DOWN;
        int height = getHeight();
        mTempRect.top = 0;
        mTempRect.bottom = height;
        {
            int count = getChildCount();
            {
                View view = getChildAt(count - 1);
                mTempRect.bottom = view.getBottom() + mPaddingBottom;
                mTempRect.top = mTempRect.bottom - height;
            } 
        } 
        boolean var39A84547F8736C141B73A0089E5E641A_567354910 = (scrollAndFocus(direction, mTempRect.top, mTempRect.bottom));
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1658109647 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1658109647;
        
        
        
        
        
        
            
            
                
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.510 -0400", hash_original_method = "AEE85E195E488E817C7C5FD2FB4EC0FB", hash_generated_method = "42FFF1802B13583B0692DB44A676AF5C")
    private boolean scrollAndFocus(int direction, int top, int bottom) {
        boolean handled = true;
        int height = getHeight();
        int containerTop = getScrollY();
        int containerBottom = containerTop + height;
        boolean up = direction == View.FOCUS_UP;
        View newFocused = findFocusableViewInBounds(up, top, bottom);
        {
            newFocused = this;
        } 
        {
            handled = false;
        } 
        {
            int delta;
            delta = (top - containerTop);
            delta = (bottom - containerBottom);
            doScrollY(delta);
        } 
        {
            boolean var2DF5574E3AD9AB6AAA9DDD6415AB9F2D_1648049153 = (newFocused != findFocus());
            newFocused.requestFocus(direction);
        } 
        addTaint(direction);
        addTaint(top);
        addTaint(bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_870187662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_870187662;
        
        
        
        
        
        
        
        
            
        
        
            
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.510 -0400", hash_original_method = "99A4FFBBF0B3182EC320D3CC49E9281B", hash_generated_method = "31F73BDF5BAA38108DBD6A99298C8AF4")
    public boolean arrowScroll(int direction) {
        View currentFocused = findFocus();
        {
            boolean varF85CA3EE0100E1E3C5B0606F6BE9D9A9_1455478747 = (currentFocused == this);
            currentFocused = null;
        } 
        View nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused, direction);
        final int maxJump = getMaxScrollAmount();
        {
            boolean var9D8E7BEB7B2A9A39F141F9B559F28F2E_1366625260 = (nextFocused != null && isWithinDeltaOfScreen(nextFocused, maxJump, getHeight()));
            {
                nextFocused.getDrawingRect(mTempRect);
                offsetDescendantRectToMyCoords(nextFocused, mTempRect);
                int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
                doScrollY(scrollDelta);
                nextFocused.requestFocus(direction);
            } 
            {
                int scrollDelta = maxJump;
                {
                    boolean var63FC15BACC5B673A5F772C0D7C31E719_1070490774 = (direction == View.FOCUS_UP && getScrollY() < scrollDelta);
                    {
                        scrollDelta = getScrollY();
                    } 
                    {
                        {
                            boolean varB8CB178E8413E8F52B580007177C5576_1244830318 = (getChildCount() > 0);
                            {
                                int daBottom = getChildAt(0).getBottom();
                                int screenBottom = getScrollY() + getHeight() - mPaddingBottom;
                                {
                                    scrollDelta = daBottom - screenBottom;
                                } 
                            } 
                        } 
                    } 
                } 
                doScrollY(direction == View.FOCUS_DOWN ? scrollDelta : -scrollDelta);
            } 
        } 
        {
            boolean var42D708BBCBC43DF6E5AC106D419B282D_1321852357 = (currentFocused != null && currentFocused.isFocused()
                && isOffScreen(currentFocused));
            {
                final int descendantFocusability = getDescendantFocusability();
                setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
                requestFocus();
                setDescendantFocusability(descendantFocusability);
            } 
        } 
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_295114271 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_295114271;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.511 -0400", hash_original_method = "98AD346ACFBFFAEC79BE4B86F94546B3", hash_generated_method = "27C16B990F51D403E935127A53BF3140")
    private boolean isOffScreen(View descendant) {
        boolean varE152D8C04578A7B6775C0B5DD4F62EE3_3539169 = (!isWithinDeltaOfScreen(descendant, 0, getHeight()));
        addTaint(descendant.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_151143717 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_151143717;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.511 -0400", hash_original_method = "472E587EAA6D318183AF3AB1B7CEF83F", hash_generated_method = "E10BAB66B48C7C7A2E6088815D188746")
    private boolean isWithinDeltaOfScreen(View descendant, int delta, int height) {
        descendant.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(descendant, mTempRect);
        boolean varF9194AE0C6867682D5312FCB54F0ABEF_887079199 = ((mTempRect.bottom + delta) >= getScrollY()
                && (mTempRect.top - delta) <= (getScrollY() + height));
        addTaint(descendant.getTaint());
        addTaint(delta);
        addTaint(height);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_814995295 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_814995295;
        
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.511 -0400", hash_original_method = "8E606864EB91DBB174E2D5FEBC80C80F", hash_generated_method = "C9EFDA9264F7B5DABCE5928AE922DAF5")
    private void doScrollY(int delta) {
        {
            {
                smoothScrollBy(0, delta);
            } 
            {
                scrollBy(0, delta);
            } 
        } 
        addTaint(delta);
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.512 -0400", hash_original_method = "2EB75EC7C5D47510D212013AE17ECAD9", hash_generated_method = "6E0CBF59F147F9B464DEF5A7917D549B")
    public final void smoothScrollBy(int dx, int dy) {
        {
            boolean varF370735710C80808B6618BA2D491D045_631441796 = (getChildCount() == 0);
        } 
        long duration = AnimationUtils.currentAnimationTimeMillis() - mLastScroll;
        {
            final int height = getHeight() - mPaddingBottom - mPaddingTop;
            final int bottom = getChildAt(0).getHeight();
            final int maxY = Math.max(0, bottom - height);
            final int scrollY = mScrollY;
            dy = Math.max(0, Math.min(scrollY + dy, maxY)) - scrollY;
            mScroller.startScroll(mScrollX, scrollY, 0, dy);
            invalidate();
        } 
        {
            {
                boolean var11F6C92CC339B9B3B7C0C85A8DBD1165_1034891327 = (!mScroller.isFinished());
                {
                    mScroller.abortAnimation();
                    {
                        mFlingStrictSpan.finish();
                        mFlingStrictSpan = null;
                    } 
                } 
            } 
            scrollBy(dx, dy);
        } 
        mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        addTaint(dx);
        addTaint(dy);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.512 -0400", hash_original_method = "EED648F6788EFF0F67B65ABAA0DE4CF2", hash_generated_method = "DA73281470CE7C276C318CD6CA129252")
    public final void smoothScrollTo(int x, int y) {
        smoothScrollBy(x - mScrollX, y - mScrollY);
        addTaint(x);
        addTaint(y);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.513 -0400", hash_original_method = "91313F7EB1086727A920BA0C858900A2", hash_generated_method = "71653CE5A7381AC96E96436DEA3366C5")
    @Override
    protected int computeVerticalScrollRange() {
        final int count = getChildCount();
        final int contentHeight = getHeight() - mPaddingBottom - mPaddingTop;
        int scrollRange = getChildAt(0).getBottom();
        final int scrollY = mScrollY;
        final int overscrollBottom = Math.max(0, scrollRange - contentHeight);
        {
            scrollRange -= scrollY;
        } 
        {
            scrollRange += scrollY - overscrollBottom;
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_211647866 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_211647866;
        
        
        
        
            
        
        
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.513 -0400", hash_original_method = "3295CF5A20E98E4F1F0B32253FD00545", hash_generated_method = "4410CB16E353A45569606386314EB755")
    @Override
    protected int computeVerticalScrollOffset() {
        int varEB30566907E969E358CA3C9E47523092_1000890167 = (Math.max(0, super.computeVerticalScrollOffset()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1499814942 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1499814942;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.513 -0400", hash_original_method = "A9DFCA2E7D027D85128F33708BC045A3", hash_generated_method = "C2F4367CA885E031D58E7FDB4013F80F")
    @Override
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        ViewGroup.LayoutParams lp = child.getLayoutParams();
        int childWidthMeasureSpec;
        int childHeightMeasureSpec;
        childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec, mPaddingLeft
                + mPaddingRight, lp.width);
        childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        addTaint(child.getTaint());
        addTaint(parentWidthMeasureSpec);
        addTaint(parentHeightMeasureSpec);
        
        
        
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.514 -0400", hash_original_method = "39312C7B222B807E39D76A29FDE3363F", hash_generated_method = "0BFCF0ACB0B52FB1675296D1B5FEBD4C")
    @Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed,
            int parentHeightMeasureSpec, int heightUsed) {
        final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                mPaddingLeft + mPaddingRight + lp.leftMargin + lp.rightMargin
                        + widthUsed, lp.width);
        final int childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
                lp.topMargin + lp.bottomMargin, MeasureSpec.UNSPECIFIED);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        addTaint(child.getTaint());
        addTaint(parentWidthMeasureSpec);
        addTaint(widthUsed);
        addTaint(parentHeightMeasureSpec);
        addTaint(heightUsed);
        
        
        
                
                        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.515 -0400", hash_original_method = "71999091E2F6915A9DB2336BBDDFAF94", hash_generated_method = "D9B47C30EC0B944389AA6EA278712897")
    @Override
    public void computeScroll() {
        {
            boolean varE7DE5EF6873640B86AA94D9EE969CCF1_1492625674 = (mScroller.computeScrollOffset());
            {
                int oldX = mScrollX;
                int oldY = mScrollY;
                int x = mScroller.getCurrX();
                int y = mScroller.getCurrY();
                {
                    final int range = getScrollRange();
                    final int overscrollMode = getOverScrollMode();
                    final boolean canOverscroll = overscrollMode == OVER_SCROLL_ALWAYS ||
                        (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && range > 0);
                    overScrollBy(x - oldX, y - oldY, oldX, oldY, 0, range,
                        0, mOverflingDistance, false);
                    onScrollChanged(mScrollX, mScrollY, oldX, oldY);
                    {
                        {
                            mEdgeGlowTop.onAbsorb((int) mScroller.getCurrVelocity());
                        } 
                        {
                            mEdgeGlowBottom.onAbsorb((int) mScroller.getCurrVelocity());
                        } 
                    } 
                } 
                awakenScrollBars();
                postInvalidate();
            } 
            {
                {
                    mFlingStrictSpan.finish();
                    mFlingStrictSpan = null;
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.515 -0400", hash_original_method = "356AAB4A47E20FEC6EFC92C05FCA16CC", hash_generated_method = "F1650693445F8008A77591C4DB2A25FE")
    private void scrollToChild(View child) {
        child.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(child, mTempRect);
        int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
        {
            scrollBy(0, scrollDelta);
        } 
        addTaint(child.getTaint());
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.516 -0400", hash_original_method = "D69703D23BD1E07705411D82E1BC609A", hash_generated_method = "C7AD3681A382856BC0CB4FC7B65DA2CF")
    private boolean scrollToChildRect(Rect rect, boolean immediate) {
        final int delta = computeScrollDeltaToGetChildRectOnScreen(rect);
        final boolean scroll = delta != 0;
        {
            {
                scrollBy(0, delta);
            } 
            {
                smoothScrollBy(0, delta);
            } 
        } 
        addTaint(rect.getTaint());
        addTaint(immediate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_475664740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_475664740;
        
        
        
        
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.517 -0400", hash_original_method = "8A5FFBB9A861965CD3F605D3125E7C0B", hash_generated_method = "589FBF75563C4EFE3F33E2990D9A5E6B")
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        {
            boolean varF370735710C80808B6618BA2D491D045_414365005 = (getChildCount() == 0);
        } 
        int height = getHeight();
        int screenTop = getScrollY();
        int screenBottom = screenTop + height;
        int fadingEdge = getVerticalFadingEdgeLength();
        {
            screenTop += fadingEdge;
        } 
        {
            boolean var21EF5215D3173B9EEA5879484954AC40_1844447006 = (rect.bottom < getChildAt(0).getHeight());
            {
                screenBottom -= fadingEdge;
            } 
        } 
        int scrollYDelta = 0;
        {
            {
                boolean var1852437954D6FC93B41EE304F855C339_242672846 = (rect.height() > height);
                {
                    scrollYDelta += (rect.top - screenTop);
                } 
                {
                    scrollYDelta += (rect.bottom - screenBottom);
                } 
            } 
            int bottom = getChildAt(0).getBottom();
            int distanceToBottom = bottom - screenBottom;
            scrollYDelta = Math.min(scrollYDelta, distanceToBottom);
        } 
        {
            {
                boolean var1852437954D6FC93B41EE304F855C339_11219107 = (rect.height() > height);
                {
                    scrollYDelta -= (screenBottom - rect.bottom);
                } 
                {
                    scrollYDelta -= (screenTop - rect.top);
                } 
            } 
            scrollYDelta = Math.max(scrollYDelta, -getScrollY());
        } 
        addTaint(rect.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_126308388 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_126308388;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.518 -0400", hash_original_method = "C2C4A47D49BA76A3A98712461E581564", hash_generated_method = "A6F96566FD9F1BE3771DA2878DF4DC46")
    @Override
    public void requestChildFocus(View child, View focused) {
        {
            scrollToChild(focused);
        } 
        {
            mChildToScrollTo = focused;
        } 
        super.requestChildFocus(child, focused);
        addTaint(child.getTaint());
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.518 -0400", hash_original_method = "BC1790D54EF67B6E1EFAB03FC42BAB96", hash_generated_method = "47BB1979B08207480D1FF4B45AA0271B")
    @Override
    protected boolean onRequestFocusInDescendants(int direction,
            Rect previouslyFocusedRect) {
        
        {
            direction = View.FOCUS_DOWN;
        } 
        {
            direction = View.FOCUS_UP;
        } 
        View nextFocus;
        nextFocus = FocusFinder.getInstance().findNextFocus(this, null, direction);
        nextFocus = FocusFinder.getInstance().findNextFocusFromRect(this,
                        previouslyFocusedRect, direction);
        {
            boolean var2421F6D33436D75DDCB765DA8D416CB8_804197067 = (isOffScreen(nextFocus));
        } 
        boolean varBB06A889CCA25ED822B35181716FFE90_1128085779 = (nextFocus.requestFocus(direction, previouslyFocusedRect));
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_604679756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_604679756;
        
        
            
        
            
        
        
                
                
                        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.519 -0400", hash_original_method = "50E2DA7CF8E403536932E3B77491E964", hash_generated_method = "8DC0803DE42F822546F7EE86529E60C6")
    @Override
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle,
            boolean immediate) {
        rectangle.offset(child.getLeft() - child.getScrollX(),
                child.getTop() - child.getScrollY());
        boolean var9EED5F05118BACEED05952D173A9E219_619391891 = (scrollToChildRect(rectangle, immediate));
        addTaint(child.getTaint());
        addTaint(rectangle.getTaint());
        addTaint(immediate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_444685959 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_444685959;
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.519 -0400", hash_original_method = "31751D7E496E2D7BD9B4D4E94AD28515", hash_generated_method = "11A20A1DA3E3F0E4689DA3F629925C7D")
    @Override
    public void requestLayout() {
        mIsLayoutDirty = true;
        super.requestLayout();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.519 -0400", hash_original_method = "E0B1FFFA746AE76ECF17449388BCEBCA", hash_generated_method = "0769E662DBD4D44EBB6685D0653E05DC")
    @Override
    protected void onDetachedFromWindow() {
        
        super.onDetachedFromWindow();
        {
            mScrollStrictSpan.finish();
            mScrollStrictSpan = null;
        } 
        {
            mFlingStrictSpan.finish();
            mFlingStrictSpan = null;
        } 
        
        
        
            
            
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.520 -0400", hash_original_method = "51521A672083F0AD2F639BD854AB8D0F", hash_generated_method = "4957C1F1DFE8B81698D67346821D0508")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        
        super.onLayout(changed, l, t, r, b);
        mIsLayoutDirty = false;
        {
            boolean varFEFF39315B1161E387E3A3BC8A5B6333_1288369433 = (mChildToScrollTo != null && isViewDescendantOf(mChildToScrollTo, this));
            {
                scrollToChild(mChildToScrollTo);
            } 
        } 
        mChildToScrollTo = null;
        scrollTo(mScrollX, mScrollY);
        addTaint(changed);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.520 -0400", hash_original_method = "35BE22C8E7AB63B977E9EAA0D1A8EAA6", hash_generated_method = "C066087B07DD96DE991D1DD05DCB9ECF")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        
        super.onSizeChanged(w, h, oldw, oldh);
        View currentFocused = findFocus();
        {
            boolean varCE6D2EB5D4D2223694B6B3F92A2E212D_1857006354 = (isWithinDeltaOfScreen(currentFocused, 0, oldh));
            {
                currentFocused.getDrawingRect(mTempRect);
                offsetDescendantRectToMyCoords(currentFocused, mTempRect);
                int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
                doScrollY(scrollDelta);
            } 
        } 
        addTaint(w);
        addTaint(h);
        addTaint(oldw);
        addTaint(oldh);
        
        
        
        
            
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.520 -0400", hash_original_method = "25276A1ACE97D138BB17C9052B223D37", hash_generated_method = "D1FDBDF5995100233CA1E67299DBF3E0")
    private boolean isViewDescendantOf(View child, View parent) {
        final ViewParent theParent = child.getParent();
        boolean var948A486C9D980B3FCF5DD6DC234D8E28_890102263 = ((theParent instanceof ViewGroup) && isViewDescendantOf((View) theParent, parent));
        addTaint(child.getTaint());
        addTaint(parent.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_288185316 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_288185316;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.521 -0400", hash_original_method = "C7B4AEF12870EFF4E9873FB61486C527", hash_generated_method = "656BE29E154C8FE32983C35D28D46213")
    public void fling(int velocityY) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1383304860 = (getChildCount() > 0);
            {
                int height = getHeight() - mPaddingBottom - mPaddingTop;
                int bottom = getChildAt(0).getHeight();
                mScroller.fling(mScrollX, mScrollY, 0, velocityY, 0, 0, 0,
                    Math.max(0, bottom - height), 0, height/2);
                final boolean movingDown = velocityY > 0;
                {
                    mFlingStrictSpan = StrictMode.enterCriticalSpan("ScrollView-fling");
                } 
                invalidate();
            } 
        } 
        addTaint(velocityY);
        
        
            
            
            
                    
            
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.521 -0400", hash_original_method = "526DB7CB9D9E6BCF2CDE3F8A7F1D2890", hash_generated_method = "0DFF22FC23EC0A9A95D0F21098A32742")
    private void endDrag() {
        mIsBeingDragged = false;
        recycleVelocityTracker();
        {
            mEdgeGlowTop.onRelease();
            mEdgeGlowBottom.onRelease();
        } 
        {
            mScrollStrictSpan.finish();
            mScrollStrictSpan = null;
        } 
        
        
        
        
            
            
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.522 -0400", hash_original_method = "748C5914370A5F8CDD8109B6F4611B5B", hash_generated_method = "F81D2738F9818C92D0439E736DA83CD9")
    @Override
    public void scrollTo(int x, int y) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1019463348 = (getChildCount() > 0);
            {
                View child = getChildAt(0);
                x = clamp(x, getWidth() - mPaddingRight - mPaddingLeft, child.getWidth());
                y = clamp(y, getHeight() - mPaddingBottom - mPaddingTop, child.getHeight());
                {
                    super.scrollTo(x, y);
                } 
            } 
        } 
        addTaint(x);
        addTaint(y);
        
        
            
            
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.522 -0400", hash_original_method = "3BD104A12D7CF3E01CAF1DA422C489F3", hash_generated_method = "1CA11FD4B7CABC4E3AF912A1AAF56E24")
    @Override
    public void setOverScrollMode(int mode) {
        {
            {
                Context context = getContext();
                mEdgeGlowTop = new EdgeEffect(context);
                mEdgeGlowBottom = new EdgeEffect(context);
            } 
        } 
        {
            mEdgeGlowTop = null;
            mEdgeGlowBottom = null;
        } 
        super.setOverScrollMode(mode);
        addTaint(mode);
        
        
            
                
                
                
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.523 -0400", hash_original_method = "50FAD524FA6B782881C70ABEF15C4DDF", hash_generated_method = "92C9DFFEEBCB8A4FEF5CAB07088D56B2")
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        {
            final int scrollY = mScrollY;
            {
                boolean varD7662701013542BC2CCE8B2B50437EBA_1187355808 = (!mEdgeGlowTop.isFinished());
                {
                    final int restoreCount = canvas.save();
                    final int width = getWidth() - mPaddingLeft - mPaddingRight;
                    canvas.translate(mPaddingLeft, Math.min(0, scrollY));
                    mEdgeGlowTop.setSize(width, getHeight());
                    {
                        boolean varAE9426D05B3D52BFC4B9E7AA44588485_860458314 = (mEdgeGlowTop.draw(canvas));
                        {
                            invalidate();
                        } 
                    } 
                    canvas.restoreToCount(restoreCount);
                } 
            } 
            {
                boolean var71AB611E918A4C599E2F06D4154D257E_728248832 = (!mEdgeGlowBottom.isFinished());
                {
                    final int restoreCount = canvas.save();
                    final int width = getWidth() - mPaddingLeft - mPaddingRight;
                    final int height = getHeight();
                    canvas.translate(-width + mPaddingLeft,
                        Math.max(getScrollRange(), scrollY) + height);
                    canvas.rotate(180, width, 0);
                    mEdgeGlowBottom.setSize(width, height);
                    {
                        boolean var61CCF9557D478E1494862B3636E22888_1109002749 = (mEdgeGlowBottom.draw(canvas));
                        {
                            invalidate();
                        } 
                    } 
                    canvas.restoreToCount(restoreCount);
                } 
            } 
        } 
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.523 -0400", hash_original_method = "10E81B579101690AB90AC933866D5438", hash_generated_method = "874C7DB7266F4639991AD34AD2260997")
    private int clamp(int n, int my, int child) {
        addTaint(n);
        addTaint(my);
        addTaint(child);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1021569374 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1021569374;
        
        
            
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.523 -0400", hash_original_field = "D4B6C25D0A03D262C947BCD869108225", hash_generated_field = "0DB9E46E1BC530D48AB4117911138FC2")

    static final int ANIMATED_SCROLL_GAP = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.523 -0400", hash_original_field = "9BFFC1AB0B9FE2B016F88B3E293FEE4F", hash_generated_field = "58258D94D76BAF55ECF7DADE8930E574")

    static final float MAX_SCROLL_FACTOR = 0.5f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.523 -0400", hash_original_field = "7EF8B2C57AC3A1D5EC1190F4098C6121", hash_generated_field = "E2DAEB44FC73F85759FCDB42BA10BD3A")

    private static final int INVALID_POINTER = -1;
}

