package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
import java.util.List;

public class HorizontalScrollView extends FrameLayout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.635 -0400", hash_original_field = "380EFAD062415C5D611446C1B15B307D", hash_generated_field = "507FF60BF6AED501221786F4F9B1C4CE")

    private long mLastScroll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.635 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

    private final Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.635 -0400", hash_original_field = "360DD66618E954525BEA0D65B05DC7EC", hash_generated_field = "7106C69F4E49AB9D7F59F38965DF6036")

    private OverScroller mScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.635 -0400", hash_original_field = "ACEBD86C89C68033BA00F1E22D2FC23B", hash_generated_field = "CF32CFBB2A976E850EE8DDE803F384D7")

    private EdgeEffect mEdgeGlowLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.635 -0400", hash_original_field = "876C7C33DE6802509886BB6ADFFE041C", hash_generated_field = "304A2CBEA7C331CEDE170973F40765C0")

    private EdgeEffect mEdgeGlowRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.635 -0400", hash_original_field = "4F6DEDF0BA2D99325BDAE4A27C301E0B", hash_generated_field = "90F53F7625CC0EEE4DC6EBCFF5E518A6")

    private float mLastMotionX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.635 -0400", hash_original_field = "A43EC71B2E74CACC223B47379717A080", hash_generated_field = "9C16E67A6EDB3E799E01AFB02BCF7815")

    private boolean mIsLayoutDirty = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.635 -0400", hash_original_field = "8949A253727FAE7FB577F98D2A9463C2", hash_generated_field = "7E1EAB0DC4AB4B81BAB22B01D588949E")

    private View mChildToScrollTo = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.635 -0400", hash_original_field = "A8AB6008485C6E787B3DBB97D2050FF4", hash_generated_field = "40AA109CDE3739730D8C499D23D26FF1")

    private boolean mIsBeingDragged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.635 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.635 -0400", hash_original_field = "B3E3E62AA85A925921DCB2869A4E7017", hash_generated_field = "16DDF79C39D64DD0F8B72040D2242A75")

    @ViewDebug.ExportedProperty(category = "layout") private boolean mFillViewport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.635 -0400", hash_original_field = "581BD96ACB5FC0F4F529183E58EA63B2", hash_generated_field = "EA3AE5CC17F6060C1DBAA2AAAFFFC35C")

    private boolean mSmoothScrollingEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.635 -0400", hash_original_field = "3DFFFAD10926598D18EEC50D61DE79CA", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.635 -0400", hash_original_field = "30B0DF23DBDF2426D66E4D98494C369B", hash_generated_field = "7DBE1A18599B8760DC9B67AAFE3499E3")

    private int mMinimumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.635 -0400", hash_original_field = "1C66D9179508D091F8E90C9FEBAD15CA", hash_generated_field = "6F997413D0B227487940C402EB78A8FD")

    private int mMaximumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.635 -0400", hash_original_field = "7A5B6F76BA72A8D6AFCFCEA14B8C2556", hash_generated_field = "7B0107E1CAE9FFC281D766335539D7C4")

    private int mOverscrollDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.635 -0400", hash_original_field = "755491871A4FCE3E01181030F8FEB178", hash_generated_field = "06022A8A798B4C892D35D0FFB16D2FDF")

    private int mOverflingDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.635 -0400", hash_original_field = "D0F34CC6DB83FC46AEC38F19CA5CE138", hash_generated_field = "1B464B20D80463EC30779F63AB0559BD")

    private int mActivePointerId = INVALID_POINTER;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.636 -0400", hash_original_method = "D579CCE5E39252987369F5EF7BC67FC0", hash_generated_method = "14051F04924CFB33DDABF2912876D78F")
    public  HorizontalScrollView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.636 -0400", hash_original_method = "7F7EA51B0CF52F1D171B225CFAE9439C", hash_generated_method = "73CCB570B3749D561A036B836DA6B022")
    public  HorizontalScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.horizontalScrollViewStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.636 -0400", hash_original_method = "ABF3CE2040AE9A0702C38DF91EEF10E7", hash_generated_method = "8478F362DCE60C1AC24636DDAA95E40A")
    public  HorizontalScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initScrollView();
        TypedArray a = context.obtainStyledAttributes(attrs,
                android.R.styleable.HorizontalScrollView, defStyle, 0);
        setFillViewport(a.getBoolean(android.R.styleable.HorizontalScrollView_fillViewport, false));
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.637 -0400", hash_original_method = "041555434146A9B8485461655BD1A318", hash_generated_method = "B687590291E41D2EABF4B286E5FB6110")
    @Override
    protected float getLeftFadingEdgeStrength() {
        {
            boolean varF370735710C80808B6618BA2D491D045_1629121480 = (getChildCount() == 0);
        } 
        final int length = getHorizontalFadingEdgeLength();
        float var546ADE640B6EDFBC8A086EF31347E768_1300753877 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1300753877;
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.637 -0400", hash_original_method = "AC1CCEB780F155A105BA88465002385B", hash_generated_method = "E392B4F53AD0D7BA3A8A52EEA833976B")
    @Override
    protected float getRightFadingEdgeStrength() {
        {
            boolean varF370735710C80808B6618BA2D491D045_241025944 = (getChildCount() == 0);
        } 
        final int length = getHorizontalFadingEdgeLength();
        final int rightEdge = getWidth() - mPaddingRight;
        final int span = getChildAt(0).getRight() - mScrollX - rightEdge;
        float var546ADE640B6EDFBC8A086EF31347E768_1872373227 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1872373227;
        
        
            
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.637 -0400", hash_original_method = "F72D9B4700B8FCB550AB26E9792E603C", hash_generated_method = "AE5C10BB16A9BE731BC69DCE43DF4AFB")
    public int getMaxScrollAmount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1085696579 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1085696579;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.638 -0400", hash_original_method = "02BBAF53D85E267FB240E2D4309C877F", hash_generated_method = "02BFF61AA3D9E1FA9C55929FA1EDF318")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.638 -0400", hash_original_method = "28BB619967A3B168E514D899D7C1C204", hash_generated_method = "2A3A3972BE1AED1B7F048B7BF6C5A6EE")
    @Override
    public void addView(View child) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1445893338 = (getChildCount() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("HorizontalScrollView can host only one direct child");
            } 
        } 
        super.addView(child);
        addTaint(child.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.639 -0400", hash_original_method = "D082E00953E9B886F1BBE563E072EA76", hash_generated_method = "F4F68301093E5361896E85611784E9A3")
    @Override
    public void addView(View child, int index) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_361622730 = (getChildCount() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("HorizontalScrollView can host only one direct child");
            } 
        } 
        super.addView(child, index);
        addTaint(child.getTaint());
        addTaint(index);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.640 -0400", hash_original_method = "35F41E1C04BFB475A60C431B3898F857", hash_generated_method = "1AA5D7CE076BD89022EE3FB1B2E6193C")
    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_986123523 = (getChildCount() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("HorizontalScrollView can host only one direct child");
            } 
        } 
        super.addView(child, params);
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.640 -0400", hash_original_method = "D331A2B6162E307FE1F025F2ABEA7C28", hash_generated_method = "752BD03C2C88B5DB580A71798C199293")
    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1318239546 = (getChildCount() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("HorizontalScrollView can host only one direct child");
            } 
        } 
        super.addView(child, index, params);
        addTaint(child.getTaint());
        addTaint(index);
        addTaint(params.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.641 -0400", hash_original_method = "3DE53F922B0BEA48963A7A11A88BC712", hash_generated_method = "54E977B61A9E80C233D5F39665FA8603")
    private boolean canScroll() {
        View child = getChildAt(0);
        {
            int childWidth = child.getWidth();
            boolean varA6C40242804D94D2C9C8F4BFEFCFD006_968011451 = (getWidth() < childWidth + mPaddingLeft + mPaddingRight);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1611806319 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1611806319;
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.641 -0400", hash_original_method = "801E6F065AC6A60CFB0DADB1E074F98E", hash_generated_method = "726E30375762DCC42D3526056CA7699C")
    public boolean isFillViewport() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_199603871 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_199603871;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.641 -0400", hash_original_method = "D2588C7F74D0E18DF5DFA629FE7BF270", hash_generated_method = "2659D9B4D00861C682890CC931AD720B")
    public void setFillViewport(boolean fillViewport) {
        {
            mFillViewport = fillViewport;
            requestLayout();
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.642 -0400", hash_original_method = "D26C58327C0CB18AC1F62B7629FD16B1", hash_generated_method = "2346A65BA82F9D3EEFEEDDD702F8600A")
    public boolean isSmoothScrollingEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_103136818 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_103136818;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.642 -0400", hash_original_method = "63C96CE84D9CD60CA1FF4EF87D7FF4F5", hash_generated_method = "5C7F23BB3E765786BEE5D256B048D32A")
    public void setSmoothScrollingEnabled(boolean smoothScrollingEnabled) {
        mSmoothScrollingEnabled = smoothScrollingEnabled;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.642 -0400", hash_original_method = "1306D2831DF4DA9A5EDAD3DA6127274D", hash_generated_method = "40403629B54BD7AD340EBEEC801D49B7")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_801225294 = (getChildCount() > 0);
            {
                final View child = getChildAt(0);
                int width = getMeasuredWidth();
                {
                    boolean varBA5E95C6C7C7E6CFE039E1AE81F2A9F7_953219005 = (child.getMeasuredWidth() < width);
                    {
                        final FrameLayout.LayoutParams lp = (LayoutParams) child.getLayoutParams();
                        int childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, mPaddingTop
                        + mPaddingBottom, lp.height);
                        width -= mPaddingLeft;
                        width -= mPaddingRight;
                        int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
                        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                    } 
                } 
            } 
        } 
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.643 -0400", hash_original_method = "40D3C8E04EF2AEB04EFDF302E05EC516", hash_generated_method = "EEEC6531010035E53DC2704E4461747F")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        boolean var160A6DCE359009EE36E492A233BEB313_603084653 = (super.dispatchKeyEvent(event) || executeKeyEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1515069921 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1515069921;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.643 -0400", hash_original_method = "59EE8B926A303894927E6FAD605B1FF1", hash_generated_method = "C307E7F1FEC0F230CFEE6739CBDCEC19")
    public boolean executeKeyEvent(KeyEvent event) {
        mTempRect.setEmpty();
        {
            boolean varF142AAB9B9E2812C95D81D43568D13C8_856767803 = (!canScroll());
            {
                {
                    boolean var807A689000786E69147E7D957AAAFB6F_94843108 = (isFocused());
                    {
                        View currentFocused = findFocus();
                        {
                            boolean varCCA9B61B8A448B09DE583C4C7BFDEFBB_1102245464 = (currentFocused == this);
                            currentFocused = null;
                        } 
                        View nextFocused = FocusFinder.getInstance().findNextFocus(this,
                        currentFocused, View.FOCUS_RIGHT);
                        boolean varE3066A006DC54F43B369F4B21A267608_1052339659 = (nextFocused != null && nextFocused != this &&
                        nextFocused.requestFocus(View.FOCUS_RIGHT));
                    } 
                } 
            } 
        } 
        boolean handled = false;
        {
            boolean varE78E9647F4429F5955AD42D05C6FEF7A_2126905724 = (event.getAction() == KeyEvent.ACTION_DOWN);
            {
                {
                    Object varA0761DC6508339A4AD5D875712ADE561_563274078 = (event.getKeyCode());
                    
                    {
                        boolean var6263B7F37C2CF1348DCC37C937DB4EA5_1047481442 = (!event.isAltPressed());
                        {
                            handled = arrowScroll(View.FOCUS_LEFT);
                        } 
                        {
                            handled = fullScroll(View.FOCUS_LEFT);
                        } 
                    } 
                    
                    
                    {
                        boolean var6263B7F37C2CF1348DCC37C937DB4EA5_1660977666 = (!event.isAltPressed());
                        {
                            handled = arrowScroll(View.FOCUS_RIGHT);
                        } 
                        {
                            handled = fullScroll(View.FOCUS_RIGHT);
                        } 
                    } 
                    
                    
                    pageScroll(event.isShiftPressed() ? View.FOCUS_LEFT : View.FOCUS_RIGHT);
                    
                } 
            } 
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1390276626 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1390276626;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.644 -0400", hash_original_method = "9319BD4BC402BC56524E94C60EDF0AE3", hash_generated_method = "06E5643FD3F571C1E2E4EC270A69E5F1")
    private boolean inChild(int x, int y) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1146270413 = (getChildCount() > 0);
            {
                final int scrollX = mScrollX;
                final View child = getChildAt(0);
                boolean var39E4E21670022FBDEFC34F7F342484F1_869404427 = (!(y < child.getTop()
                    || y >= child.getBottom()
                    || x < child.getLeft() - scrollX
                    || x >= child.getRight() - scrollX));
            } 
        } 
        addTaint(x);
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_247923896 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_247923896;
        
        
            
            
            
                    
                    
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.644 -0400", hash_original_method = "2F2E3E2ED97C397B1954EFE1C35FD1EF", hash_generated_method = "D2F7B701FF4A7C7D5D9BBE60A4204A34")
    private void initOrResetVelocityTracker() {
        {
            mVelocityTracker = VelocityTracker.obtain();
        } 
        {
            mVelocityTracker.clear();
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.644 -0400", hash_original_method = "2C2F1E0A6C232182F8110D9EE75ED47E", hash_generated_method = "A47C5AEFF80C521B346EFD43CCEC463A")
    private void initVelocityTrackerIfNotExists() {
        {
            mVelocityTracker = VelocityTracker.obtain();
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.645 -0400", hash_original_method = "FC3B581D4963BCED4340031BA20C5421", hash_generated_method = "4A5B29B306AF5EDD25C8547D1436EB51")
    private void recycleVelocityTracker() {
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.645 -0400", hash_original_method = "C74400E8950C106883E854683AF24673", hash_generated_method = "9EE44C43E2819EE39A2C95C618F793B6")
    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        {
            recycleVelocityTracker();
        } 
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
        addTaint(disallowIntercept);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.646 -0400", hash_original_method = "B8EBEABAF4D085F1DC9FA2F6547DBF28", hash_generated_method = "AC38567C6393CD7D10864ADD20ED799B")
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        
        final int action = ev.getAction();
        
        {
            final int activePointerId = mActivePointerId;
            final int pointerIndex = ev.findPointerIndex(activePointerId);
            final float x = ev.getX(pointerIndex);
            final int xDiff = (int) Math.abs(x - mLastMotionX);
            {
                mIsBeingDragged = true;
                mLastMotionX = x;
                initVelocityTrackerIfNotExists();
                mVelocityTracker.addMovement(ev);
                mParent.requestDisallowInterceptTouchEvent(true);
            } 
        } 
        
        
        {
            final float x = ev.getX();
            {
                boolean var3405975BC361ED70AE7E5B2027F4D35B_260344872 = (!inChild((int) x, (int) ev.getY()));
                {
                    mIsBeingDragged = false;
                    recycleVelocityTracker();
                } 
            } 
            mLastMotionX = x;
            mActivePointerId = ev.getPointerId(0);
            initOrResetVelocityTracker();
            mVelocityTracker.addMovement(ev);
            mIsBeingDragged = !mScroller.isFinished();
        } 
        
        
        mIsBeingDragged = false;
        
        
        mActivePointerId = INVALID_POINTER;
        
        
        {
            boolean varEE5121167538D55FE2ED747573ECA340_1333169443 = (mScroller.springBack(mScrollX, mScrollY, 0, getScrollRange(), 0, 0));
            {
                invalidate();
            } 
        } 
        
        
        {
            final int index = ev.getActionIndex();
            mLastMotionX = ev.getX(index);
            mActivePointerId = ev.getPointerId(index);
        } 
        
        
        onSecondaryPointerUp(ev);
        
        
        mLastMotionX = ev.getX(ev.findPointerIndex(mActivePointerId));
        
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1438727529 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1438727529;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.647 -0400", hash_original_method = "DC232709D0DE420641FAAFB6B744429B", hash_generated_method = "294C4D4D3EE1A450CFDC5615CD6C4BEF")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        
        initVelocityTrackerIfNotExists();
        mVelocityTracker.addMovement(ev);
        final int action = ev.getAction();
        
        {
            mIsBeingDragged = getChildCount() != 0;
            {
                boolean var11F6C92CC339B9B3B7C0C85A8DBD1165_1098598299 = (!mScroller.isFinished());
                {
                    mScroller.abortAnimation();
                } 
            } 
            mLastMotionX = ev.getX();
            mActivePointerId = ev.getPointerId(0);
        } 
        
        
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
            {
                boolean var4673405DB318F577EB775B557DA805F2_2056552916 = (overScrollBy(deltaX, 0, mScrollX, 0, range, 0,
                            mOverscrollDistance, 0, true));
                {
                    mVelocityTracker.clear();
                } 
            } 
            onScrollChanged(mScrollX, mScrollY, oldX, oldY);
            {
                final int pulledToX = oldX + deltaX;
                {
                    mEdgeGlowLeft.onPull((float) deltaX / getWidth());
                    {
                        boolean varD2DEBDA1B3BE7D590185C2C37852D200_1673254481 = (!mEdgeGlowRight.isFinished());
                        {
                            mEdgeGlowRight.onRelease();
                        } 
                    } 
                } 
                {
                    mEdgeGlowRight.onPull((float) deltaX / getWidth());
                    {
                        boolean varD07D7885146F53648F473CE045927D93_1351833910 = (!mEdgeGlowLeft.isFinished());
                        {
                            mEdgeGlowLeft.onRelease();
                        } 
                    } 
                } 
                {
                    boolean var5D2E730F9B7FB13C61A16574D0E5ADB7_543440831 = (mEdgeGlowLeft != null
                                && (!mEdgeGlowLeft.isFinished() || !mEdgeGlowRight.isFinished()));
                    {
                        invalidate();
                    } 
                } 
            } 
        } 
        
        
        {
            final VelocityTracker velocityTracker = mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
            int initialVelocity = (int) velocityTracker.getXVelocity(mActivePointerId);
            {
                boolean var9C190A50DA656473F4A85C2EF380F022_384925817 = (getChildCount() > 0);
                {
                    {
                        boolean varCB55D3BE2E93A2FD55EF78A581740AFC_1457879104 = ((Math.abs(initialVelocity) > mMinimumVelocity));
                        {
                            fling(-initialVelocity);
                        } 
                        {
                            {
                                boolean var620455B046FC74D8EB536096D28363E6_840254825 = (mScroller.springBack(mScrollX, mScrollY, 0,
                                    getScrollRange(), 0, 0));
                                {
                                    invalidate();
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            mActivePointerId = INVALID_POINTER;
            mIsBeingDragged = false;
            recycleVelocityTracker();
            {
                mEdgeGlowLeft.onRelease();
                mEdgeGlowRight.onRelease();
            } 
        } 
        
        
        {
            boolean var9286919EB531712C93F03BFB604683F8_1727674559 = (mIsBeingDragged && getChildCount() > 0);
            {
                {
                    boolean var22BD84039EB304B13BC2A1C6684C6C6D_973441142 = (mScroller.springBack(mScrollX, mScrollY, 0, getScrollRange(), 0, 0));
                    {
                        invalidate();
                    } 
                } 
                mActivePointerId = INVALID_POINTER;
                mIsBeingDragged = false;
                recycleVelocityTracker();
                {
                    mEdgeGlowLeft.onRelease();
                    mEdgeGlowRight.onRelease();
                } 
            } 
        } 
        
        
        onSecondaryPointerUp(ev);
        
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591770522 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591770522;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.648 -0400", hash_original_method = "15678E7D87FCB5B2E2A6D15F2CBAE390", hash_generated_method = "E30C1CA42ECFFCBA76EF86B8D87D63B8")
    private void onSecondaryPointerUp(MotionEvent ev) {
        final int pointerIndex = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >>
                MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        final int pointerId = ev.getPointerId(pointerIndex);
        {
            int newPointerIndex;
            newPointerIndex = 1;
            newPointerIndex = 0;
            mLastMotionX = ev.getX(newPointerIndex);
            mActivePointerId = ev.getPointerId(newPointerIndex);
            {
                mVelocityTracker.clear();
            } 
        } 
        
        
                
        
        
            
            
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.648 -0400", hash_original_method = "EA19C55D5CBC44B40040771841401365", hash_generated_method = "3010DF0F8E7AFA10EE00D831DB1CC748")
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        
        {
            boolean varB5CEEFE1A0B0FE6CF2A2378211A03C4D_1609899379 = ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0);
            {
                {
                    Object varC2BF00F96F1D1B1ABEF4B0E3FC4FE9EC_883874099 = (event.getAction());
                    
                    {
                        {
                            float hscroll;
                            {
                                boolean varB081D4C178A0E24C7934472C47298D77_919730966 = ((event.getMetaState() & KeyEvent.META_SHIFT_ON) != 0);
                                {
                                    hscroll = -event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                                } 
                                {
                                    hscroll = event.getAxisValue(MotionEvent.AXIS_HSCROLL);
                                } 
                            } 
                            {
                                final int delta = (int) (hscroll * getHorizontalScrollFactor());
                                final int range = getScrollRange();
                                int oldScrollX = mScrollX;
                                int newScrollX = oldScrollX + delta;
                                {
                                    newScrollX = 0;
                                } 
                                {
                                    newScrollX = range;
                                } 
                                {
                                    super.scrollTo(newScrollX, mScrollY);
                                } 
                            } 
                        } 
                    } 
                    
                } 
            } 
        } 
        boolean var32C1E3DF40BCC120C79428C7AEB27DD1_460240045 = (super.onGenericMotionEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_897358491 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_897358491;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.649 -0400", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "2A890713EF0FB94CFE15DEE89BF63F00")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_433024547 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_433024547;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.650 -0400", hash_original_method = "06CAD3F9DAB24C265A0AAEC7445D85D7", hash_generated_method = "8740A4A8270816D51D07AA6F98E3FA3E")
    @Override
    protected void onOverScrolled(int scrollX, int scrollY,
            boolean clampedX, boolean clampedY) {
        
        {
            boolean var2844BA5E42FD344CC642021B350DFDAC_780835597 = (!mScroller.isFinished());
            {
                mScrollX = scrollX;
                mScrollY = scrollY;
                invalidateParentIfNeeded();
                {
                    mScroller.springBack(mScrollX, mScrollY, 0, getScrollRange(), 0, 0);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.650 -0400", hash_original_method = "AF8EC74B0AD4D69DC5ACACFC8749064F", hash_generated_method = "61EE9670444DDDD9440F00D0D1F34A0C")
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        
        super.onInitializeAccessibilityNodeInfo(info);
        info.setScrollable(getScrollRange() > 0);
        addTaint(info.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.651 -0400", hash_original_method = "7DA515169DBC462D06A7F08F561D2E84", hash_generated_method = "70863D26B40E871DF53D836A7A42F80F")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        
        super.onInitializeAccessibilityEvent(event);
        event.setScrollable(getScrollRange() > 0);
        event.setScrollX(mScrollX);
        event.setScrollY(mScrollY);
        event.setMaxScrollX(getScrollRange());
        event.setMaxScrollY(mScrollY);
        addTaint(event.getTaint());
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.652 -0400", hash_original_method = "6035917F8C30F3A1C02AFED333ACB352", hash_generated_method = "8BA38212EA661A47ADF79E2092E10E99")
    private int getScrollRange() {
        int scrollRange = 0;
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1379460504 = (getChildCount() > 0);
            {
                View child = getChildAt(0);
                scrollRange = Math.max(0,
                    child.getWidth() - (getWidth() - mPaddingLeft - mPaddingRight));
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1166374795 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1166374795;
        
        
        
            
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.653 -0400", hash_original_method = "B34C300D12B589B0218EA4927548AE87", hash_generated_method = "E13B5CF4BA6BDFB3B752D14D918AE4E2")
    private View findFocusableViewInMyBounds(final boolean leftFocus,
            final int left, View preferredFocusable) {
        View varB4EAC82CA7396A68D541C85D26508E83_1213286401 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1003934340 = null; 
        final int fadingEdgeLength = getHorizontalFadingEdgeLength() / 2;
        final int leftWithoutFadingEdge = left + fadingEdgeLength;
        final int rightWithoutFadingEdge = left + getWidth() - fadingEdgeLength;
        {
            boolean var7D87B4F60FE19E28B97792EEA30CCEF8_675067868 = ((preferredFocusable != null)
                && (preferredFocusable.getLeft() < rightWithoutFadingEdge)
                && (preferredFocusable.getRight() > leftWithoutFadingEdge));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1213286401 = preferredFocusable;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1003934340 = findFocusableViewInBounds(leftFocus, leftWithoutFadingEdge,
                rightWithoutFadingEdge);
        addTaint(leftFocus);
        addTaint(left);
        addTaint(preferredFocusable.getTaint());
        View varA7E53CE21691AB073D9660D615818899_2065139460; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2065139460 = varB4EAC82CA7396A68D541C85D26508E83_1213286401;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2065139460 = varB4EAC82CA7396A68D541C85D26508E83_1003934340;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2065139460.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2065139460;
        
        
        
        
        
                
                
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.655 -0400", hash_original_method = "CFAC89DA51B9853AC14992D421225DFD", hash_generated_method = "585247D6327DE90A253DC8601DA97BC8")
    private View findFocusableViewInBounds(boolean leftFocus, int left, int right) {
        View varB4EAC82CA7396A68D541C85D26508E83_1290929792 = null; 
        List<View> focusables = getFocusables(View.FOCUS_FORWARD);
        View focusCandidate = null;
        boolean foundFullyContainedFocusable = false;
        int count = focusables.size();
        {
            int i = 0;
            {
                View view = focusables.get(i);
                int viewLeft = view.getLeft();
                int viewRight = view.getRight();
                {
                    final boolean viewIsFullyContained = (left < viewLeft) &&
                        (viewRight < right);
                    {
                        focusCandidate = view;
                        foundFullyContainedFocusable = viewIsFullyContained;
                    } 
                    {
                        final boolean viewIsCloserToBoundary = (leftFocus && viewLeft < focusCandidate.getLeft()) ||
                                    (!leftFocus && viewRight > focusCandidate.getRight());
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
        varB4EAC82CA7396A68D541C85D26508E83_1290929792 = focusCandidate;
        addTaint(leftFocus);
        addTaint(left);
        addTaint(right);
        varB4EAC82CA7396A68D541C85D26508E83_1290929792.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1290929792;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.655 -0400", hash_original_method = "DA183CDCD6EA3DA10063DE059735FFD7", hash_generated_method = "2255FAE9260BFE107649E958CEA1ECDD")
    public boolean pageScroll(int direction) {
        boolean right = direction == View.FOCUS_RIGHT;
        int width = getWidth();
        {
            mTempRect.left = getScrollX() + width;
            int count = getChildCount();
            {
                View view = getChildAt(0);
                {
                    boolean var8C78AEBAFA30CD197C035E0F448FF2FC_553254276 = (mTempRect.left + width > view.getRight());
                    {
                        mTempRect.left = view.getRight() - width;
                    } 
                } 
            } 
        } 
        {
            mTempRect.left = getScrollX() - width;
            {
                mTempRect.left = 0;
            } 
        } 
        mTempRect.right = mTempRect.left + width;
        boolean var4D73DD7FC50DAF2C1DFAEF953A983AC8_414115487 = (scrollAndFocus(direction, mTempRect.left, mTempRect.right));
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_434654583 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_434654583;
        
        
        
        
            
            
            
                
                
                    
                
            
        
            
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.656 -0400", hash_original_method = "13724385C240165AD29E108B78F9E99D", hash_generated_method = "55885A213F4E20A020DB8CCD401F67FA")
    public boolean fullScroll(int direction) {
        boolean right = direction == View.FOCUS_RIGHT;
        int width = getWidth();
        mTempRect.left = 0;
        mTempRect.right = width;
        {
            int count = getChildCount();
            {
                View view = getChildAt(0);
                mTempRect.right = view.getRight();
                mTempRect.left = mTempRect.right - width;
            } 
        } 
        boolean var4D73DD7FC50DAF2C1DFAEF953A983AC8_1281321664 = (scrollAndFocus(direction, mTempRect.left, mTempRect.right));
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_480546317 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_480546317;
        
        
        
        
        
        
            
            
                
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.656 -0400", hash_original_method = "DF3968C57E4B66E8EEB56F2D4C42BFD9", hash_generated_method = "CE7044C0D53F1A27A369754BF3D33B39")
    private boolean scrollAndFocus(int direction, int left, int right) {
        boolean handled = true;
        int width = getWidth();
        int containerLeft = getScrollX();
        int containerRight = containerLeft + width;
        boolean goLeft = direction == View.FOCUS_LEFT;
        View newFocused = findFocusableViewInBounds(goLeft, left, right);
        {
            newFocused = this;
        } 
        {
            handled = false;
        } 
        {
            int delta;
            delta = (left - containerLeft);
            delta = (right - containerRight);
            doScrollX(delta);
        } 
        {
            boolean var2DF5574E3AD9AB6AAA9DDD6415AB9F2D_340110969 = (newFocused != findFocus());
            newFocused.requestFocus(direction);
        } 
        addTaint(direction);
        addTaint(left);
        addTaint(right);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_375856616 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_375856616;
        
        
        
        
        
        
        
        
            
        
        
            
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.657 -0400", hash_original_method = "ED0B7D3300F52C8B0FEFDD6EE298A1FB", hash_generated_method = "F9D67E64F440DA92B33EE91217D7F8F5")
    public boolean arrowScroll(int direction) {
        View currentFocused = findFocus();
        {
            boolean varF85CA3EE0100E1E3C5B0606F6BE9D9A9_171911122 = (currentFocused == this);
            currentFocused = null;
        } 
        View nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused, direction);
        final int maxJump = getMaxScrollAmount();
        {
            boolean var2292435FA822AB146936012380ED5BBB_1497979690 = (nextFocused != null && isWithinDeltaOfScreen(nextFocused, maxJump));
            {
                nextFocused.getDrawingRect(mTempRect);
                offsetDescendantRectToMyCoords(nextFocused, mTempRect);
                int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
                doScrollX(scrollDelta);
                nextFocused.requestFocus(direction);
            } 
            {
                int scrollDelta = maxJump;
                {
                    boolean var3623D08ACBADBF97DF4231DD021A3251_451228894 = (direction == View.FOCUS_LEFT && getScrollX() < scrollDelta);
                    {
                        scrollDelta = getScrollX();
                    } 
                    {
                        boolean var31DDA0576A919784AA2E33F0C157B20A_1574364441 = (direction == View.FOCUS_RIGHT && getChildCount() > 0);
                        {
                            int daRight = getChildAt(0).getRight();
                            int screenRight = getScrollX() + getWidth();
                            {
                                scrollDelta = daRight - screenRight;
                            } 
                        } 
                    } 
                } 
                doScrollX(direction == View.FOCUS_RIGHT ? scrollDelta : -scrollDelta);
            } 
        } 
        {
            boolean var42D708BBCBC43DF6E5AC106D419B282D_2032977365 = (currentFocused != null && currentFocused.isFocused()
                && isOffScreen(currentFocused));
            {
                final int descendantFocusability = getDescendantFocusability();
                setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
                requestFocus();
                setDescendantFocusability(descendantFocusability);
            } 
        } 
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1630353845 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1630353845;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.658 -0400", hash_original_method = "E39461866A28C70AD36F56E791C6BE3B", hash_generated_method = "2E55B0FD2E5BCBE8C20B64C9A74722DF")
    private boolean isOffScreen(View descendant) {
        boolean var3CCD939A38ACEEE7749282D1DF99CC78_1003906450 = (!isWithinDeltaOfScreen(descendant, 0));
        addTaint(descendant.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_415175366 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_415175366;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.658 -0400", hash_original_method = "47CB02AABD47C9E7AF2DCBC38CD370E2", hash_generated_method = "45DC6216D5E7DB63F53A64EE61DC346B")
    private boolean isWithinDeltaOfScreen(View descendant, int delta) {
        descendant.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(descendant, mTempRect);
        boolean var05C136A6ECA4FF0F2BC7726A4BFA46FE_1716256277 = ((mTempRect.right + delta) >= getScrollX()
                && (mTempRect.left - delta) <= (getScrollX() + getWidth()));
        addTaint(descendant.getTaint());
        addTaint(delta);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_24569563 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_24569563;
        
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.658 -0400", hash_original_method = "3F16B27E18A709EC962C39AF363F3965", hash_generated_method = "FCCBC3CEEE3CAEE5D716C5585B9172A0")
    private void doScrollX(int delta) {
        {
            {
                smoothScrollBy(delta, 0);
            } 
            {
                scrollBy(delta, 0);
            } 
        } 
        addTaint(delta);
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.659 -0400", hash_original_method = "DAE9EEC093475C9AC0229EA6C3F406DC", hash_generated_method = "569FF8A4B5AF2594EF7FE535CA5D71A5")
    public final void smoothScrollBy(int dx, int dy) {
        {
            boolean varF370735710C80808B6618BA2D491D045_1334754395 = (getChildCount() == 0);
        } 
        long duration = AnimationUtils.currentAnimationTimeMillis() - mLastScroll;
        {
            final int width = getWidth() - mPaddingRight - mPaddingLeft;
            final int right = getChildAt(0).getWidth();
            final int maxX = Math.max(0, right - width);
            final int scrollX = mScrollX;
            dx = Math.max(0, Math.min(scrollX + dx, maxX)) - scrollX;
            mScroller.startScroll(scrollX, mScrollY, dx, 0);
            invalidate();
        } 
        {
            {
                boolean var11F6C92CC339B9B3B7C0C85A8DBD1165_1910037594 = (!mScroller.isFinished());
                {
                    mScroller.abortAnimation();
                } 
            } 
            scrollBy(dx, dy);
        } 
        mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        addTaint(dx);
        addTaint(dy);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.660 -0400", hash_original_method = "EED648F6788EFF0F67B65ABAA0DE4CF2", hash_generated_method = "DA73281470CE7C276C318CD6CA129252")
    public final void smoothScrollTo(int x, int y) {
        smoothScrollBy(x - mScrollX, y - mScrollY);
        addTaint(x);
        addTaint(y);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.660 -0400", hash_original_method = "344907C67A02819CC7A230367AD45761", hash_generated_method = "2ECCE8FACADD9AE8AAF2467F4B03E0A5")
    @Override
    protected int computeHorizontalScrollRange() {
        final int count = getChildCount();
        final int contentWidth = getWidth() - mPaddingLeft - mPaddingRight;
        int scrollRange = getChildAt(0).getRight();
        final int scrollX = mScrollX;
        final int overscrollRight = Math.max(0, scrollRange - contentWidth);
        {
            scrollRange -= scrollX;
        } 
        {
            scrollRange += scrollX - overscrollRight;
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1300271391 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1300271391;
        
        
        
        
            
        
        
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.661 -0400", hash_original_method = "9CF354C1D07DBC59A9E2E44E57F7657B", hash_generated_method = "277F9C7CA63B8F3B657F74F22D784540")
    @Override
    protected int computeHorizontalScrollOffset() {
        int var7A9951C5866872080505940D11B99587_1368148833 = (Math.max(0, super.computeHorizontalScrollOffset()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_75448866 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_75448866;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.662 -0400", hash_original_method = "1A4819189D92B65ABF3F692114902ED1", hash_generated_method = "ADAFBEB9B9EC260E7F9DA179D26DB521")
    @Override
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        ViewGroup.LayoutParams lp = child.getLayoutParams();
        int childWidthMeasureSpec;
        int childHeightMeasureSpec;
        childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec, mPaddingTop
                + mPaddingBottom, lp.height);
        childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        addTaint(child.getTaint());
        addTaint(parentWidthMeasureSpec);
        addTaint(parentHeightMeasureSpec);
        
        
        
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.662 -0400", hash_original_method = "0EA8DFEAF2643806863B304E52EE38A5", hash_generated_method = "95DDAB9CE26EAD3804842262A235E15E")
    @Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed,
            int parentHeightMeasureSpec, int heightUsed) {
        final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                mPaddingTop + mPaddingBottom + lp.topMargin + lp.bottomMargin
                        + heightUsed, lp.height);
        final int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(
                lp.leftMargin + lp.rightMargin, MeasureSpec.UNSPECIFIED);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        addTaint(child.getTaint());
        addTaint(parentWidthMeasureSpec);
        addTaint(widthUsed);
        addTaint(parentHeightMeasureSpec);
        addTaint(heightUsed);
        
        
        
                
                        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.663 -0400", hash_original_method = "D30258BCA66C5E19407EB248DA88CE03", hash_generated_method = "37777E77A2003F6B55CDF984AA712A94")
    @Override
    public void computeScroll() {
        {
            boolean varE7DE5EF6873640B86AA94D9EE969CCF1_210754934 = (mScroller.computeScrollOffset());
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
                    overScrollBy(x - oldX, y - oldY, oldX, oldY, range, 0,
                        mOverflingDistance, 0, false);
                    onScrollChanged(mScrollX, mScrollY, oldX, oldY);
                    {
                        {
                            mEdgeGlowLeft.onAbsorb((int) mScroller.getCurrVelocity());
                        } 
                        {
                            mEdgeGlowRight.onAbsorb((int) mScroller.getCurrVelocity());
                        } 
                    } 
                } 
                awakenScrollBars();
                postInvalidate();
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.664 -0400", hash_original_method = "988A7EC33B56EE551974E7C841966101", hash_generated_method = "CC461F082829174F3006FFC15289D153")
    private void scrollToChild(View child) {
        child.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(child, mTempRect);
        int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
        {
            scrollBy(scrollDelta, 0);
        } 
        addTaint(child.getTaint());
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.664 -0400", hash_original_method = "07633DDCD66F05F9C6104D95040C4376", hash_generated_method = "D3B154237FC93D88F4E61E73CD370672")
    private boolean scrollToChildRect(Rect rect, boolean immediate) {
        final int delta = computeScrollDeltaToGetChildRectOnScreen(rect);
        final boolean scroll = delta != 0;
        {
            {
                scrollBy(delta, 0);
            } 
            {
                smoothScrollBy(delta, 0);
            } 
        } 
        addTaint(rect.getTaint());
        addTaint(immediate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1366225366 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1366225366;
        
        
        
        
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.665 -0400", hash_original_method = "8C5AA93676CE0EF7515972F93F61C0B6", hash_generated_method = "D2A782A4971910C078254F9F9494BD42")
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        {
            boolean varF370735710C80808B6618BA2D491D045_1126893817 = (getChildCount() == 0);
        } 
        int width = getWidth();
        int screenLeft = getScrollX();
        int screenRight = screenLeft + width;
        int fadingEdge = getHorizontalFadingEdgeLength();
        {
            screenLeft += fadingEdge;
        } 
        {
            boolean var111E177520853BA7F7EEE5AEE5221F06_1209260361 = (rect.right < getChildAt(0).getWidth());
            {
                screenRight -= fadingEdge;
            } 
        } 
        int scrollXDelta = 0;
        {
            {
                boolean varAE73F3F4DF09B867223301D92BC7E6F0_130491240 = (rect.width() > width);
                {
                    scrollXDelta += (rect.left - screenLeft);
                } 
                {
                    scrollXDelta += (rect.right - screenRight);
                } 
            } 
            int right = getChildAt(0).getRight();
            int distanceToRight = right - screenRight;
            scrollXDelta = Math.min(scrollXDelta, distanceToRight);
        } 
        {
            {
                boolean varAE73F3F4DF09B867223301D92BC7E6F0_1933158880 = (rect.width() > width);
                {
                    scrollXDelta -= (screenRight - rect.right);
                } 
                {
                    scrollXDelta -= (screenLeft - rect.left);
                } 
            } 
            scrollXDelta = Math.max(scrollXDelta, -getScrollX());
        } 
        addTaint(rect.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_109619113 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_109619113;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.665 -0400", hash_original_method = "C2C4A47D49BA76A3A98712461E581564", hash_generated_method = "A6F96566FD9F1BE3771DA2878DF4DC46")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.665 -0400", hash_original_method = "4857D3DE9468292A125F69FE9ECFC007", hash_generated_method = "BECEEC125559EF0457A5F69B8379AE72")
    @Override
    protected boolean onRequestFocusInDescendants(int direction,
            Rect previouslyFocusedRect) {
        
        {
            direction = View.FOCUS_RIGHT;
        } 
        {
            direction = View.FOCUS_LEFT;
        } 
        View nextFocus;
        nextFocus = FocusFinder.getInstance().findNextFocus(this, null, direction);
        nextFocus = FocusFinder.getInstance().findNextFocusFromRect(this,
                        previouslyFocusedRect, direction);
        {
            boolean var2421F6D33436D75DDCB765DA8D416CB8_126556501 = (isOffScreen(nextFocus));
        } 
        boolean varBB06A889CCA25ED822B35181716FFE90_624066766 = (nextFocus.requestFocus(direction, previouslyFocusedRect));
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1444057612 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1444057612;
        
        
            
        
            
        
        
                
                
                        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.666 -0400", hash_original_method = "50E2DA7CF8E403536932E3B77491E964", hash_generated_method = "7081A31C9BBC2195792B4F0888BFFF7C")
    @Override
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle,
            boolean immediate) {
        rectangle.offset(child.getLeft() - child.getScrollX(),
                child.getTop() - child.getScrollY());
        boolean var9EED5F05118BACEED05952D173A9E219_1719373745 = (scrollToChildRect(rectangle, immediate));
        addTaint(child.getTaint());
        addTaint(rectangle.getTaint());
        addTaint(immediate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_281056472 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_281056472;
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.666 -0400", hash_original_method = "31751D7E496E2D7BD9B4D4E94AD28515", hash_generated_method = "11A20A1DA3E3F0E4689DA3F629925C7D")
    @Override
    public void requestLayout() {
        mIsLayoutDirty = true;
        super.requestLayout();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.666 -0400", hash_original_method = "51521A672083F0AD2F639BD854AB8D0F", hash_generated_method = "BD7DCB46332967947C49F216FF10522B")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        
        super.onLayout(changed, l, t, r, b);
        mIsLayoutDirty = false;
        {
            boolean varFEFF39315B1161E387E3A3BC8A5B6333_69094856 = (mChildToScrollTo != null && isViewDescendantOf(mChildToScrollTo, this));
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.667 -0400", hash_original_method = "BFC9FDBBB166F0ED568B66B969E998B2", hash_generated_method = "3A2BDE5F8C486D370181EDA894BB8A0A")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        
        super.onSizeChanged(w, h, oldw, oldh);
        View currentFocused = findFocus();
        final int maxJump = mRight - mLeft;
        {
            boolean var23B5651428E53758F7813143E4B31F1D_1668134739 = (isWithinDeltaOfScreen(currentFocused, maxJump));
            {
                currentFocused.getDrawingRect(mTempRect);
                offsetDescendantRectToMyCoords(currentFocused, mTempRect);
                int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
                doScrollX(scrollDelta);
            } 
        } 
        addTaint(w);
        addTaint(h);
        addTaint(oldw);
        addTaint(oldh);
        
        
        
        
            
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.667 -0400", hash_original_method = "25276A1ACE97D138BB17C9052B223D37", hash_generated_method = "FB6FE4E4D33E5AA7B2146EAE9EDF980A")
    private boolean isViewDescendantOf(View child, View parent) {
        final ViewParent theParent = child.getParent();
        boolean var948A486C9D980B3FCF5DD6DC234D8E28_1480362970 = ((theParent instanceof ViewGroup) && isViewDescendantOf((View) theParent, parent));
        addTaint(child.getTaint());
        addTaint(parent.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_568895986 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_568895986;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.668 -0400", hash_original_method = "C5A2747735A9CF7D4575D6EE52958D1F", hash_generated_method = "8FE03257C08D847811BCC0A4FFBE90F0")
    public void fling(int velocityX) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_270997323 = (getChildCount() > 0);
            {
                int width = getWidth() - mPaddingRight - mPaddingLeft;
                int right = getChildAt(0).getWidth();
                mScroller.fling(mScrollX, mScrollY, velocityX, 0, 0,
                    Math.max(0, right - width), 0, 0, width/2, 0);
                final boolean movingRight = velocityX > 0;
                View currentFocused = findFocus();
                View newFocused = findFocusableViewInMyBounds(movingRight,
                    mScroller.getFinalX(), currentFocused);
                {
                    newFocused = this;
                } 
                {
                    newFocused.requestFocus(movingRight ? View.FOCUS_RIGHT : View.FOCUS_LEFT);
                } 
                invalidate();
            } 
        } 
        addTaint(velocityX);
        
        
            
            
            
                    
            
            
            
                    
            
                
            
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.668 -0400", hash_original_method = "748C5914370A5F8CDD8109B6F4611B5B", hash_generated_method = "A4A016A6A40486BE075FA894CFC71D43")
    @Override
    public void scrollTo(int x, int y) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1578708140 = (getChildCount() > 0);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.668 -0400", hash_original_method = "7D7EAD2993C7155FA8CA9421487AA499", hash_generated_method = "ED5D3BF5F354A711AA3A1D612B62D7E1")
    @Override
    public void setOverScrollMode(int mode) {
        {
            {
                Context context = getContext();
                mEdgeGlowLeft = new EdgeEffect(context);
                mEdgeGlowRight = new EdgeEffect(context);
            } 
        } 
        {
            mEdgeGlowLeft = null;
            mEdgeGlowRight = null;
        } 
        super.setOverScrollMode(mode);
        addTaint(mode);
        
        
            
                
                
                
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.669 -0400", hash_original_method = "63AFEEC895B9671DC479FE83536227D7", hash_generated_method = "FA5A3E13752EFD7EA195053F063D61CB")
    @SuppressWarnings({"SuspiciousNameCombination"})
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        {
            final int scrollX = mScrollX;
            {
                boolean var1ECF01FA9E017D6BE3235AB8A34635E8_243937817 = (!mEdgeGlowLeft.isFinished());
                {
                    final int restoreCount = canvas.save();
                    final int height = getHeight() - mPaddingTop - mPaddingBottom;
                    canvas.rotate(270);
                    canvas.translate(-height + mPaddingTop, Math.min(0, scrollX));
                    mEdgeGlowLeft.setSize(height, getWidth());
                    {
                        boolean var610D4E0E7DF4A306CD193957D2FE9A09_1578134433 = (mEdgeGlowLeft.draw(canvas));
                        {
                            invalidate();
                        } 
                    } 
                    canvas.restoreToCount(restoreCount);
                } 
            } 
            {
                boolean varFB5CAACA6057E33D653CCB246DF230DF_1715236122 = (!mEdgeGlowRight.isFinished());
                {
                    final int restoreCount = canvas.save();
                    final int width = getWidth();
                    final int height = getHeight() - mPaddingTop - mPaddingBottom;
                    canvas.rotate(90);
                    canvas.translate(-mPaddingTop,
                        -(Math.max(getScrollRange(), scrollX) + width));
                    mEdgeGlowRight.setSize(height, width);
                    {
                        boolean var0CDA4D4B63F069A0ADED01E10A235FEC_376567170 = (mEdgeGlowRight.draw(canvas));
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.670 -0400", hash_original_method = "10E81B579101690AB90AC933866D5438", hash_generated_method = "FC36480D74B9C21CD10EC394FC544D7F")
    private int clamp(int n, int my, int child) {
        addTaint(n);
        addTaint(my);
        addTaint(child);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2012676616 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2012676616;
        
        
            
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.670 -0400", hash_original_field = "592B4C751C2D22CD7D43317BD897714A", hash_generated_field = "4083FF51B3491C57DFF4E035C0066C80")

    private static final int ANIMATED_SCROLL_GAP = ScrollView.ANIMATED_SCROLL_GAP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.670 -0400", hash_original_field = "CA227357940761AB7254479B7BD99962", hash_generated_field = "49356EE5727E8BD04682A1AF4FB39A2B")

    private static final float MAX_SCROLL_FACTOR = ScrollView.MAX_SCROLL_FACTOR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.670 -0400", hash_original_field = "7EF8B2C57AC3A1D5EC1190F4098C6121", hash_generated_field = "E2DAEB44FC73F85759FCDB42BA10BD3A")

    private static final int INVALID_POINTER = -1;
}

