package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.483 -0400", hash_original_field = "380EFAD062415C5D611446C1B15B307D", hash_generated_field = "507FF60BF6AED501221786F4F9B1C4CE")

    private long mLastScroll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.483 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "AFFA54D19F07A10EE8847CF76FC95323")

    private Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.483 -0400", hash_original_field = "360DD66618E954525BEA0D65B05DC7EC", hash_generated_field = "7106C69F4E49AB9D7F59F38965DF6036")

    private OverScroller mScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.483 -0400", hash_original_field = "ACEBD86C89C68033BA00F1E22D2FC23B", hash_generated_field = "CF32CFBB2A976E850EE8DDE803F384D7")

    private EdgeEffect mEdgeGlowLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.483 -0400", hash_original_field = "876C7C33DE6802509886BB6ADFFE041C", hash_generated_field = "304A2CBEA7C331CEDE170973F40765C0")

    private EdgeEffect mEdgeGlowRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.483 -0400", hash_original_field = "4F6DEDF0BA2D99325BDAE4A27C301E0B", hash_generated_field = "90F53F7625CC0EEE4DC6EBCFF5E518A6")

    private float mLastMotionX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.483 -0400", hash_original_field = "A43EC71B2E74CACC223B47379717A080", hash_generated_field = "9C16E67A6EDB3E799E01AFB02BCF7815")

    private boolean mIsLayoutDirty = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.483 -0400", hash_original_field = "8949A253727FAE7FB577F98D2A9463C2", hash_generated_field = "7E1EAB0DC4AB4B81BAB22B01D588949E")

    private View mChildToScrollTo = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.483 -0400", hash_original_field = "A8AB6008485C6E787B3DBB97D2050FF4", hash_generated_field = "40AA109CDE3739730D8C499D23D26FF1")

    private boolean mIsBeingDragged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.483 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.483 -0400", hash_original_field = "B3E3E62AA85A925921DCB2869A4E7017", hash_generated_field = "16DDF79C39D64DD0F8B72040D2242A75")

    @ViewDebug.ExportedProperty(category = "layout") private boolean mFillViewport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.483 -0400", hash_original_field = "581BD96ACB5FC0F4F529183E58EA63B2", hash_generated_field = "EA3AE5CC17F6060C1DBAA2AAAFFFC35C")

    private boolean mSmoothScrollingEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.483 -0400", hash_original_field = "3DFFFAD10926598D18EEC50D61DE79CA", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.483 -0400", hash_original_field = "30B0DF23DBDF2426D66E4D98494C369B", hash_generated_field = "7DBE1A18599B8760DC9B67AAFE3499E3")

    private int mMinimumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.483 -0400", hash_original_field = "1C66D9179508D091F8E90C9FEBAD15CA", hash_generated_field = "6F997413D0B227487940C402EB78A8FD")

    private int mMaximumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.483 -0400", hash_original_field = "7A5B6F76BA72A8D6AFCFCEA14B8C2556", hash_generated_field = "7B0107E1CAE9FFC281D766335539D7C4")

    private int mOverscrollDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.483 -0400", hash_original_field = "755491871A4FCE3E01181030F8FEB178", hash_generated_field = "06022A8A798B4C892D35D0FFB16D2FDF")

    private int mOverflingDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.483 -0400", hash_original_field = "D0F34CC6DB83FC46AEC38F19CA5CE138", hash_generated_field = "1B464B20D80463EC30779F63AB0559BD")

    private int mActivePointerId = INVALID_POINTER;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.484 -0400", hash_original_method = "D579CCE5E39252987369F5EF7BC67FC0", hash_generated_method = "14051F04924CFB33DDABF2912876D78F")
    public  HorizontalScrollView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.484 -0400", hash_original_method = "7F7EA51B0CF52F1D171B225CFAE9439C", hash_generated_method = "73CCB570B3749D561A036B836DA6B022")
    public  HorizontalScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.horizontalScrollViewStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.498 -0400", hash_original_method = "ABF3CE2040AE9A0702C38DF91EEF10E7", hash_generated_method = "0A34DD722FFA74F566678677DF38D2D5")
    public  HorizontalScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initScrollView();
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                android.R.styleable.HorizontalScrollView, defStyle, 0);
        setFillViewport(a.getBoolean(android.R.styleable.HorizontalScrollView_fillViewport, false));
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
        //initScrollView();
        //TypedArray a = context.obtainStyledAttributes(attrs,
                //android.R.styleable.HorizontalScrollView, defStyle, 0);
        //setFillViewport(a.getBoolean(android.R.styleable.HorizontalScrollView_fillViewport, false));
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.499 -0400", hash_original_method = "041555434146A9B8485461655BD1A318", hash_generated_method = "3F4E83D9977AE99A3448B610071CDE86")
    @Override
    protected float getLeftFadingEdgeStrength() {
        {
            boolean varF370735710C80808B6618BA2D491D045_263295277 = (getChildCount() == 0);
        } //End collapsed parenthetic
        int length;
        length = getHorizontalFadingEdgeLength();
        float var546ADE640B6EDFBC8A086EF31347E768_1826112005 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1826112005;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.499 -0400", hash_original_method = "AC1CCEB780F155A105BA88465002385B", hash_generated_method = "5F057A2E5CB2E6DDF5A3547333BDFC76")
    @Override
    protected float getRightFadingEdgeStrength() {
        {
            boolean varF370735710C80808B6618BA2D491D045_2083589646 = (getChildCount() == 0);
        } //End collapsed parenthetic
        int length;
        length = getHorizontalFadingEdgeLength();
        int rightEdge;
        rightEdge = getWidth() - mPaddingRight;
        int span;
        span = getChildAt(0).getRight() - mScrollX - rightEdge;
        float var546ADE640B6EDFBC8A086EF31347E768_187260582 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_187260582;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.500 -0400", hash_original_method = "F72D9B4700B8FCB550AB26E9792E603C", hash_generated_method = "FCC7FC3ACD506F0AC3BBE9E716B2A8CD")
    public int getMaxScrollAmount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1649931069 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1649931069;
        // ---------- Original Method ----------
        //return (int) (MAX_SCROLL_FACTOR * (mRight - mLeft));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.501 -0400", hash_original_method = "02BBAF53D85E267FB240E2D4309C877F", hash_generated_method = "8A03164972DE1A24C8B4AD83E152C23B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.501 -0400", hash_original_method = "28BB619967A3B168E514D899D7C1C204", hash_generated_method = "62E045EE6EDE8F0A4FB283BC1FAEEA07")
    @Override
    public void addView(View child) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1741875353 = (getChildCount() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("HorizontalScrollView can host only one direct child");
            } //End block
        } //End collapsed parenthetic
        super.addView(child);
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        //}
        //super.addView(child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.502 -0400", hash_original_method = "D082E00953E9B886F1BBE563E072EA76", hash_generated_method = "076DCF55ED3D1DE14FAE7701C83B8DFF")
    @Override
    public void addView(View child, int index) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_491863841 = (getChildCount() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("HorizontalScrollView can host only one direct child");
            } //End block
        } //End collapsed parenthetic
        super.addView(child, index);
        addTaint(child.getTaint());
        addTaint(index);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        //}
        //super.addView(child, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.502 -0400", hash_original_method = "35F41E1C04BFB475A60C431B3898F857", hash_generated_method = "6063C86464760CCB089D252CD0BBEF87")
    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_2029612676 = (getChildCount() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("HorizontalScrollView can host only one direct child");
            } //End block
        } //End collapsed parenthetic
        super.addView(child, params);
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        //}
        //super.addView(child, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.506 -0400", hash_original_method = "D331A2B6162E307FE1F025F2ABEA7C28", hash_generated_method = "38A6D41A8D345A18F0A255A29B949E47")
    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1752822005 = (getChildCount() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("HorizontalScrollView can host only one direct child");
            } //End block
        } //End collapsed parenthetic
        super.addView(child, index, params);
        addTaint(child.getTaint());
        addTaint(index);
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        //}
        //super.addView(child, index, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.506 -0400", hash_original_method = "3DE53F922B0BEA48963A7A11A88BC712", hash_generated_method = "08C139340F70B1D303B1A32FABFE8083")
    private boolean canScroll() {
        View child;
        child = getChildAt(0);
        {
            int childWidth;
            childWidth = child.getWidth();
            boolean varA6C40242804D94D2C9C8F4BFEFCFD006_599514129 = (getWidth() < childWidth + mPaddingLeft + mPaddingRight);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_475790439 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_475790439;
        // ---------- Original Method ----------
        //View child = getChildAt(0);
        //if (child != null) {
            //int childWidth = child.getWidth();
            //return getWidth() < childWidth + mPaddingLeft + mPaddingRight ;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.519 -0400", hash_original_method = "801E6F065AC6A60CFB0DADB1E074F98E", hash_generated_method = "37616BC1F6EB23DE76BEEEA9359013B6")
    public boolean isFillViewport() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_765997697 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_765997697;
        // ---------- Original Method ----------
        //return mFillViewport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.520 -0400", hash_original_method = "D2588C7F74D0E18DF5DFA629FE7BF270", hash_generated_method = "2659D9B4D00861C682890CC931AD720B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.520 -0400", hash_original_method = "D26C58327C0CB18AC1F62B7629FD16B1", hash_generated_method = "2D68E75035D3E7BBCA7232C306DD29EE")
    public boolean isSmoothScrollingEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1889515949 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1889515949;
        // ---------- Original Method ----------
        //return mSmoothScrollingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.520 -0400", hash_original_method = "63C96CE84D9CD60CA1FF4EF87D7FF4F5", hash_generated_method = "5C7F23BB3E765786BEE5D256B048D32A")
    public void setSmoothScrollingEnabled(boolean smoothScrollingEnabled) {
        mSmoothScrollingEnabled = smoothScrollingEnabled;
        // ---------- Original Method ----------
        //mSmoothScrollingEnabled = smoothScrollingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.521 -0400", hash_original_method = "1306D2831DF4DA9A5EDAD3DA6127274D", hash_generated_method = "257E1F50F73D4F3B5770CFCC55898656")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode;
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1695293041 = (getChildCount() > 0);
            {
                View child;
                child = getChildAt(0);
                int width;
                width = getMeasuredWidth();
                {
                    boolean varBA5E95C6C7C7E6CFE039E1AE81F2A9F7_828945020 = (child.getMeasuredWidth() < width);
                    {
                        FrameLayout.LayoutParams lp;
                        lp = (LayoutParams) child.getLayoutParams();
                        int childHeightMeasureSpec;
                        childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, mPaddingTop
                        + mPaddingBottom, lp.height);
                        width -= mPaddingLeft;
                        width -= mPaddingRight;
                        int childWidthMeasureSpec;
                        childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.521 -0400", hash_original_method = "40D3C8E04EF2AEB04EFDF302E05EC516", hash_generated_method = "C5FDE13E52DDF5E8334DE5EBB46A8736")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        boolean var160A6DCE359009EE36E492A233BEB313_549603570 = (super.dispatchKeyEvent(event) || executeKeyEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1274594586 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1274594586;
        // ---------- Original Method ----------
        //return super.dispatchKeyEvent(event) || executeKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.523 -0400", hash_original_method = "59EE8B926A303894927E6FAD605B1FF1", hash_generated_method = "2A630B94C53D5C11B003F234927A182D")
    public boolean executeKeyEvent(KeyEvent event) {
        mTempRect.setEmpty();
        {
            boolean varF142AAB9B9E2812C95D81D43568D13C8_635867391 = (!canScroll());
            {
                {
                    boolean var807A689000786E69147E7D957AAAFB6F_1770587450 = (isFocused());
                    {
                        View currentFocused;
                        currentFocused = findFocus();
                        {
                            boolean varCCA9B61B8A448B09DE583C4C7BFDEFBB_502293461 = (currentFocused == this);
                            currentFocused = null;
                        } //End collapsed parenthetic
                        View nextFocused;
                        nextFocused = FocusFinder.getInstance().findNextFocus(this,
                        currentFocused, View.FOCUS_RIGHT);
                        boolean varE3066A006DC54F43B369F4B21A267608_787995796 = (nextFocused != null && nextFocused != this &&
                        nextFocused.requestFocus(View.FOCUS_RIGHT));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean handled;
        handled = false;
        {
            boolean varE78E9647F4429F5955AD42D05C6FEF7A_2032041263 = (event.getAction() == KeyEvent.ACTION_DOWN);
            {
                {
                    Object varA0761DC6508339A4AD5D875712ADE561_561195296 = (event.getKeyCode());
                    //Begin case KeyEvent.KEYCODE_DPAD_LEFT 
                    {
                        boolean var6263B7F37C2CF1348DCC37C937DB4EA5_1694404975 = (!event.isAltPressed());
                        {
                            handled = arrowScroll(View.FOCUS_LEFT);
                        } //End block
                        {
                            handled = fullScroll(View.FOCUS_LEFT);
                        } //End block
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_DPAD_LEFT 
                    //Begin case KeyEvent.KEYCODE_DPAD_RIGHT 
                    {
                        boolean var6263B7F37C2CF1348DCC37C937DB4EA5_1134572327 = (!event.isAltPressed());
                        {
                            handled = arrowScroll(View.FOCUS_RIGHT);
                        } //End block
                        {
                            handled = fullScroll(View.FOCUS_RIGHT);
                        } //End block
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_DPAD_RIGHT 
                    //Begin case KeyEvent.KEYCODE_SPACE 
                    pageScroll(event.isShiftPressed() ? View.FOCUS_LEFT : View.FOCUS_RIGHT);
                    //End case KeyEvent.KEYCODE_SPACE 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_247291936 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_247291936;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.535 -0400", hash_original_method = "9319BD4BC402BC56524E94C60EDF0AE3", hash_generated_method = "214F8B04007AA223131C053C20A89AE6")
    private boolean inChild(int x, int y) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1864809442 = (getChildCount() > 0);
            {
                int scrollX;
                scrollX = mScrollX;
                View child;
                child = getChildAt(0);
                boolean var39E4E21670022FBDEFC34F7F342484F1_1037567070 = (!(y < child.getTop()
                    || y >= child.getBottom()
                    || x < child.getLeft() - scrollX
                    || x >= child.getRight() - scrollX));
            } //End block
        } //End collapsed parenthetic
        addTaint(x);
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1699237781 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1699237781;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.536 -0400", hash_original_method = "2F2E3E2ED97C397B1954EFE1C35FD1EF", hash_generated_method = "D2F7B701FF4A7C7D5D9BBE60A4204A34")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.536 -0400", hash_original_method = "2C2F1E0A6C232182F8110D9EE75ED47E", hash_generated_method = "A47C5AEFF80C521B346EFD43CCEC463A")
    private void initVelocityTrackerIfNotExists() {
        {
            mVelocityTracker = VelocityTracker.obtain();
        } //End block
        // ---------- Original Method ----------
        //if (mVelocityTracker == null) {
            //mVelocityTracker = VelocityTracker.obtain();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.536 -0400", hash_original_method = "FC3B581D4963BCED4340031BA20C5421", hash_generated_method = "4A5B29B306AF5EDD25C8547D1436EB51")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.537 -0400", hash_original_method = "C74400E8950C106883E854683AF24673", hash_generated_method = "9EE44C43E2819EE39A2C95C618F793B6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.552 -0400", hash_original_method = "B8EBEABAF4D085F1DC9FA2F6547DBF28", hash_generated_method = "D11D4602F707A37FB957731F2E0E8742")
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
            float x;
            x = ev.getX(pointerIndex);
            int xDiff;
            xDiff = (int) Math.abs(x - mLastMotionX);
            {
                mIsBeingDragged = true;
                mLastMotionX = x;
                initVelocityTrackerIfNotExists();
                mVelocityTracker.addMovement(ev);
                mParent.requestDisallowInterceptTouchEvent(true);
            } //End block
        } //End block
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_DOWN 
        {
            float x;
            x = ev.getX();
            {
                boolean var3405975BC361ED70AE7E5B2027F4D35B_1095630711 = (!inChild((int) x, (int) ev.getY()));
                {
                    mIsBeingDragged = false;
                    recycleVelocityTracker();
                } //End block
            } //End collapsed parenthetic
            mLastMotionX = x;
            mActivePointerId = ev.getPointerId(0);
            initOrResetVelocityTracker();
            mVelocityTracker.addMovement(ev);
            mIsBeingDragged = !mScroller.isFinished();
        } //End block
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        mIsBeingDragged = false;
        //End case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        mActivePointerId = INVALID_POINTER;
        //End case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        {
            boolean varEE5121167538D55FE2ED747573ECA340_1893290257 = (mScroller.springBack(mScrollX, mScrollY, 0, getScrollRange(), 0, 0));
            {
                invalidate();
            } //End block
        } //End collapsed parenthetic
        //End case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_POINTER_DOWN 
        {
            int index;
            index = ev.getActionIndex();
            mLastMotionX = ev.getX(index);
            mActivePointerId = ev.getPointerId(index);
        } //End block
        //End case MotionEvent.ACTION_POINTER_DOWN 
        //Begin case MotionEvent.ACTION_POINTER_UP 
        onSecondaryPointerUp(ev);
        //End case MotionEvent.ACTION_POINTER_UP 
        //Begin case MotionEvent.ACTION_POINTER_UP 
        mLastMotionX = ev.getX(ev.findPointerIndex(mActivePointerId));
        //End case MotionEvent.ACTION_POINTER_UP 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1790742291 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1790742291;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.555 -0400", hash_original_method = "DC232709D0DE420641FAAFB6B744429B", hash_generated_method = "A94288B78B332A744955A0194343250D")
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
                boolean var11F6C92CC339B9B3B7C0C85A8DBD1165_470058110 = (!mScroller.isFinished());
                {
                    mScroller.abortAnimation();
                } //End block
            } //End collapsed parenthetic
            mLastMotionX = ev.getX();
            mActivePointerId = ev.getPointerId(0);
        } //End block
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_MOVE 
        {
            int activePointerIndex;
            activePointerIndex = ev.findPointerIndex(mActivePointerId);
            float x;
            x = ev.getX(activePointerIndex);
            int deltaX;
            deltaX = (int) (mLastMotionX - x);
            mLastMotionX = x;
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
                boolean var4673405DB318F577EB775B557DA805F2_675937325 = (overScrollBy(deltaX, 0, mScrollX, 0, range, 0,
                            mOverscrollDistance, 0, true));
                {
                    mVelocityTracker.clear();
                } //End block
            } //End collapsed parenthetic
            onScrollChanged(mScrollX, mScrollY, oldX, oldY);
            {
                int pulledToX;
                pulledToX = oldX + deltaX;
                {
                    mEdgeGlowLeft.onPull((float) deltaX / getWidth());
                    {
                        boolean varD2DEBDA1B3BE7D590185C2C37852D200_1746358649 = (!mEdgeGlowRight.isFinished());
                        {
                            mEdgeGlowRight.onRelease();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    mEdgeGlowRight.onPull((float) deltaX / getWidth());
                    {
                        boolean varD07D7885146F53648F473CE045927D93_1268284565 = (!mEdgeGlowLeft.isFinished());
                        {
                            mEdgeGlowLeft.onRelease();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var5D2E730F9B7FB13C61A16574D0E5ADB7_58378434 = (mEdgeGlowLeft != null
                                && (!mEdgeGlowLeft.isFinished() || !mEdgeGlowRight.isFinished()));
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
            initialVelocity = (int) velocityTracker.getXVelocity(mActivePointerId);
            {
                boolean var9C190A50DA656473F4A85C2EF380F022_1918854216 = (getChildCount() > 0);
                {
                    {
                        boolean varCB55D3BE2E93A2FD55EF78A581740AFC_1712108209 = ((Math.abs(initialVelocity) > mMinimumVelocity));
                        {
                            fling(-initialVelocity);
                        } //End block
                        {
                            {
                                boolean var620455B046FC74D8EB536096D28363E6_1408495522 = (mScroller.springBack(mScrollX, mScrollY, 0,
                                    getScrollRange(), 0, 0));
                                {
                                    invalidate();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            mActivePointerId = INVALID_POINTER;
            mIsBeingDragged = false;
            recycleVelocityTracker();
            {
                mEdgeGlowLeft.onRelease();
                mEdgeGlowRight.onRelease();
            } //End block
        } //End block
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_CANCEL 
        {
            boolean var9286919EB531712C93F03BFB604683F8_1571154892 = (mIsBeingDragged && getChildCount() > 0);
            {
                {
                    boolean var22BD84039EB304B13BC2A1C6684C6C6D_431235710 = (mScroller.springBack(mScrollX, mScrollY, 0, getScrollRange(), 0, 0));
                    {
                        invalidate();
                    } //End block
                } //End collapsed parenthetic
                mActivePointerId = INVALID_POINTER;
                mIsBeingDragged = false;
                recycleVelocityTracker();
                {
                    mEdgeGlowLeft.onRelease();
                    mEdgeGlowRight.onRelease();
                } //End block
            } //End block
        } //End collapsed parenthetic
        //End case MotionEvent.ACTION_CANCEL 
        //Begin case MotionEvent.ACTION_POINTER_UP 
        onSecondaryPointerUp(ev);
        //End case MotionEvent.ACTION_POINTER_UP 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1880124774 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1880124774;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.556 -0400", hash_original_method = "15678E7D87FCB5B2E2A6D15F2CBAE390", hash_generated_method = "C03C4B9A51D1DACCD015A300B3803EB9")
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
            mLastMotionX = ev.getX(newPointerIndex);
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
            //mLastMotionX = ev.getX(newPointerIndex);
            //mActivePointerId = ev.getPointerId(newPointerIndex);
            //if (mVelocityTracker != null) {
                //mVelocityTracker.clear();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.569 -0400", hash_original_method = "EA19C55D5CBC44B40040771841401365", hash_generated_method = "E8BA8E993AC1637CD2BCA23A7BAD2E48")
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varB5CEEFE1A0B0FE6CF2A2378211A03C4D_1329115896 = ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0);
            {
                {
                    Object varC2BF00F96F1D1B1ABEF4B0E3FC4FE9EC_1306851880 = (event.getAction());
                    //Begin case MotionEvent.ACTION_SCROLL 
                    {
                        {
                            float hscroll;
                            {
                                boolean varB081D4C178A0E24C7934472C47298D77_1548222816 = ((event.getMetaState() & KeyEvent.META_SHIFT_ON) != 0);
                                {
                                    hscroll = -event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                                } //End block
                                {
                                    hscroll = event.getAxisValue(MotionEvent.AXIS_HSCROLL);
                                } //End block
                            } //End collapsed parenthetic
                            {
                                int delta;
                                delta = (int) (hscroll * getHorizontalScrollFactor());
                                int range;
                                range = getScrollRange();
                                int oldScrollX;
                                oldScrollX = mScrollX;
                                int newScrollX;
                                newScrollX = oldScrollX + delta;
                                {
                                    newScrollX = 0;
                                } //End block
                                {
                                    newScrollX = range;
                                } //End block
                                {
                                    super.scrollTo(newScrollX, mScrollY);
                                } //End block
                            } //End block
                        } //End block
                    } //End block
                    //End case MotionEvent.ACTION_SCROLL 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var32C1E3DF40BCC120C79428C7AEB27DD1_1703981760 = (super.onGenericMotionEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_277960081 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_277960081;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.570 -0400", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "B4295B612B962FC3AE9E4E37956535CC")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2142479443 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2142479443;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.570 -0400", hash_original_method = "06CAD3F9DAB24C265A0AAEC7445D85D7", hash_generated_method = "2A6408F27D0F1BC46BE83CBED59F91CD")
    @Override
    protected void onOverScrolled(int scrollX, int scrollY,
            boolean clampedX, boolean clampedY) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var2844BA5E42FD344CC642021B350DFDAC_1414871215 = (!mScroller.isFinished());
            {
                mScrollX = scrollX;
                mScrollY = scrollY;
                invalidateParentIfNeeded();
                {
                    mScroller.springBack(mScrollX, mScrollY, 0, getScrollRange(), 0, 0);
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
            //if (clampedX) {
                //mScroller.springBack(mScrollX, mScrollY, 0, getScrollRange(), 0, 0);
            //}
        //} else {
            //super.scrollTo(scrollX, scrollY);
        //}
        //awakenScrollBars();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.579 -0400", hash_original_method = "AF8EC74B0AD4D69DC5ACACFC8749064F", hash_generated_method = "61EE9670444DDDD9440F00D0D1F34A0C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.580 -0400", hash_original_method = "7DA515169DBC462D06A7F08F561D2E84", hash_generated_method = "70863D26B40E871DF53D836A7A42F80F")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onInitializeAccessibilityEvent(event);
        event.setScrollable(getScrollRange() > 0);
        event.setScrollX(mScrollX);
        event.setScrollY(mScrollY);
        event.setMaxScrollX(getScrollRange());
        event.setMaxScrollY(mScrollY);
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //event.setScrollable(getScrollRange() > 0);
        //event.setScrollX(mScrollX);
        //event.setScrollY(mScrollY);
        //event.setMaxScrollX(getScrollRange());
        //event.setMaxScrollY(mScrollY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.581 -0400", hash_original_method = "6035917F8C30F3A1C02AFED333ACB352", hash_generated_method = "1998700B1B31AC91371F9DFACE19A81A")
    private int getScrollRange() {
        int scrollRange;
        scrollRange = 0;
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1296442959 = (getChildCount() > 0);
            {
                View child;
                child = getChildAt(0);
                scrollRange = Math.max(0,
                    child.getWidth() - (getWidth() - mPaddingLeft - mPaddingRight));
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_777797648 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_777797648;
        // ---------- Original Method ----------
        //int scrollRange = 0;
        //if (getChildCount() > 0) {
            //View child = getChildAt(0);
            //scrollRange = Math.max(0,
                    //child.getWidth() - (getWidth() - mPaddingLeft - mPaddingRight));
        //}
        //return scrollRange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.595 -0400", hash_original_method = "B34C300D12B589B0218EA4927548AE87", hash_generated_method = "A8A0511CCF15E7198233D0E9451048B3")
    private View findFocusableViewInMyBounds(final boolean leftFocus,
            final int left, View preferredFocusable) {
        View varB4EAC82CA7396A68D541C85D26508E83_1242960544 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_1078467015 = null; //Variable for return #2
        int fadingEdgeLength;
        fadingEdgeLength = getHorizontalFadingEdgeLength() / 2;
        int leftWithoutFadingEdge;
        leftWithoutFadingEdge = left + fadingEdgeLength;
        int rightWithoutFadingEdge;
        rightWithoutFadingEdge = left + getWidth() - fadingEdgeLength;
        {
            boolean var7D87B4F60FE19E28B97792EEA30CCEF8_1360517619 = ((preferredFocusable != null)
                && (preferredFocusable.getLeft() < rightWithoutFadingEdge)
                && (preferredFocusable.getRight() > leftWithoutFadingEdge));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1242960544 = preferredFocusable;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1078467015 = findFocusableViewInBounds(leftFocus, leftWithoutFadingEdge,
                rightWithoutFadingEdge);
        addTaint(leftFocus);
        addTaint(left);
        addTaint(preferredFocusable.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1135166945; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1135166945 = varB4EAC82CA7396A68D541C85D26508E83_1242960544;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1135166945 = varB4EAC82CA7396A68D541C85D26508E83_1078467015;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1135166945.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1135166945;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.597 -0400", hash_original_method = "CFAC89DA51B9853AC14992D421225DFD", hash_generated_method = "D3C49B0227D9BBDE9BED2623F0A81B21")
    private View findFocusableViewInBounds(boolean leftFocus, int left, int right) {
        View varB4EAC82CA7396A68D541C85D26508E83_1244758629 = null; //Variable for return #1
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
                int viewLeft;
                viewLeft = view.getLeft();
                int viewRight;
                viewRight = view.getRight();
                {
                    boolean viewIsFullyContained;
                    viewIsFullyContained = (left < viewLeft) &&
                        (viewRight < right);
                    {
                        focusCandidate = view;
                        foundFullyContainedFocusable = viewIsFullyContained;
                    } //End block
                    {
                        boolean viewIsCloserToBoundary;
                        viewIsCloserToBoundary = (leftFocus && viewLeft < focusCandidate.getLeft()) ||
                                    (!leftFocus && viewRight > focusCandidate.getRight());
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
        varB4EAC82CA7396A68D541C85D26508E83_1244758629 = focusCandidate;
        addTaint(leftFocus);
        addTaint(left);
        addTaint(right);
        varB4EAC82CA7396A68D541C85D26508E83_1244758629.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1244758629;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.598 -0400", hash_original_method = "DA183CDCD6EA3DA10063DE059735FFD7", hash_generated_method = "54C7E35FA983106D0D893EC2D6273772")
    public boolean pageScroll(int direction) {
        boolean right;
        right = direction == View.FOCUS_RIGHT;
        int width;
        width = getWidth();
        {
            mTempRect.left = getScrollX() + width;
            int count;
            count = getChildCount();
            {
                View view;
                view = getChildAt(0);
                {
                    boolean var8C78AEBAFA30CD197C035E0F448FF2FC_929855878 = (mTempRect.left + width > view.getRight());
                    {
                        mTempRect.left = view.getRight() - width;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            mTempRect.left = getScrollX() - width;
            {
                mTempRect.left = 0;
            } //End block
        } //End block
        mTempRect.right = mTempRect.left + width;
        boolean var4D73DD7FC50DAF2C1DFAEF953A983AC8_596210478 = (scrollAndFocus(direction, mTempRect.left, mTempRect.right));
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_503119705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_503119705;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.602 -0400", hash_original_method = "13724385C240165AD29E108B78F9E99D", hash_generated_method = "2CE1C729CBBAFA5479719053174B4325")
    public boolean fullScroll(int direction) {
        boolean right;
        right = direction == View.FOCUS_RIGHT;
        int width;
        width = getWidth();
        mTempRect.left = 0;
        mTempRect.right = width;
        {
            int count;
            count = getChildCount();
            {
                View view;
                view = getChildAt(0);
                mTempRect.right = view.getRight();
                mTempRect.left = mTempRect.right - width;
            } //End block
        } //End block
        boolean var4D73DD7FC50DAF2C1DFAEF953A983AC8_1543738045 = (scrollAndFocus(direction, mTempRect.left, mTempRect.right));
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1113750525 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1113750525;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.603 -0400", hash_original_method = "DF3968C57E4B66E8EEB56F2D4C42BFD9", hash_generated_method = "72BDB2FF0B98C2A482003128676527BB")
    private boolean scrollAndFocus(int direction, int left, int right) {
        boolean handled;
        handled = true;
        int width;
        width = getWidth();
        int containerLeft;
        containerLeft = getScrollX();
        int containerRight;
        containerRight = containerLeft + width;
        boolean goLeft;
        goLeft = direction == View.FOCUS_LEFT;
        View newFocused;
        newFocused = findFocusableViewInBounds(goLeft, left, right);
        {
            newFocused = this;
        } //End block
        {
            handled = false;
        } //End block
        {
            int delta;
            delta = (left - containerLeft);
            delta = (right - containerRight);
            doScrollX(delta);
        } //End block
        {
            boolean var2DF5574E3AD9AB6AAA9DDD6415AB9F2D_1877734000 = (newFocused != findFocus());
            newFocused.requestFocus(direction);
        } //End collapsed parenthetic
        addTaint(direction);
        addTaint(left);
        addTaint(right);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1814929286 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1814929286;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.614 -0400", hash_original_method = "ED0B7D3300F52C8B0FEFDD6EE298A1FB", hash_generated_method = "E6B3FF8A9C49A7845709B61EF94C9FA2")
    public boolean arrowScroll(int direction) {
        View currentFocused;
        currentFocused = findFocus();
        {
            boolean varF85CA3EE0100E1E3C5B0606F6BE9D9A9_1483482663 = (currentFocused == this);
            currentFocused = null;
        } //End collapsed parenthetic
        View nextFocused;
        nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused, direction);
        int maxJump;
        maxJump = getMaxScrollAmount();
        {
            boolean var2292435FA822AB146936012380ED5BBB_1308569413 = (nextFocused != null && isWithinDeltaOfScreen(nextFocused, maxJump));
            {
                nextFocused.getDrawingRect(mTempRect);
                offsetDescendantRectToMyCoords(nextFocused, mTempRect);
                int scrollDelta;
                scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
                doScrollX(scrollDelta);
                nextFocused.requestFocus(direction);
            } //End block
            {
                int scrollDelta;
                scrollDelta = maxJump;
                {
                    boolean var3623D08ACBADBF97DF4231DD021A3251_483347753 = (direction == View.FOCUS_LEFT && getScrollX() < scrollDelta);
                    {
                        scrollDelta = getScrollX();
                    } //End block
                    {
                        boolean var31DDA0576A919784AA2E33F0C157B20A_291740910 = (direction == View.FOCUS_RIGHT && getChildCount() > 0);
                        {
                            int daRight;
                            daRight = getChildAt(0).getRight();
                            int screenRight;
                            screenRight = getScrollX() + getWidth();
                            {
                                scrollDelta = daRight - screenRight;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                doScrollX(direction == View.FOCUS_RIGHT ? scrollDelta : -scrollDelta);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var42D708BBCBC43DF6E5AC106D419B282D_1242611036 = (currentFocused != null && currentFocused.isFocused()
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1779220473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1779220473;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.615 -0400", hash_original_method = "E39461866A28C70AD36F56E791C6BE3B", hash_generated_method = "3586C522D73EDE16B90C929CADEF37B2")
    private boolean isOffScreen(View descendant) {
        boolean var3CCD939A38ACEEE7749282D1DF99CC78_372452946 = (!isWithinDeltaOfScreen(descendant, 0));
        addTaint(descendant.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_266084404 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_266084404;
        // ---------- Original Method ----------
        //return !isWithinDeltaOfScreen(descendant, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.616 -0400", hash_original_method = "47CB02AABD47C9E7AF2DCBC38CD370E2", hash_generated_method = "22F924837D900E3747399F708F46A10A")
    private boolean isWithinDeltaOfScreen(View descendant, int delta) {
        descendant.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(descendant, mTempRect);
        boolean var05C136A6ECA4FF0F2BC7726A4BFA46FE_1568068043 = ((mTempRect.right + delta) >= getScrollX()
                && (mTempRect.left - delta) <= (getScrollX() + getWidth()));
        addTaint(descendant.getTaint());
        addTaint(delta);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1597397302 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1597397302;
        // ---------- Original Method ----------
        //descendant.getDrawingRect(mTempRect);
        //offsetDescendantRectToMyCoords(descendant, mTempRect);
        //return (mTempRect.right + delta) >= getScrollX()
                //&& (mTempRect.left - delta) <= (getScrollX() + getWidth());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.616 -0400", hash_original_method = "3F16B27E18A709EC962C39AF363F3965", hash_generated_method = "FCCBC3CEEE3CAEE5D716C5585B9172A0")
    private void doScrollX(int delta) {
        {
            {
                smoothScrollBy(delta, 0);
            } //End block
            {
                scrollBy(delta, 0);
            } //End block
        } //End block
        addTaint(delta);
        // ---------- Original Method ----------
        //if (delta != 0) {
            //if (mSmoothScrollingEnabled) {
                //smoothScrollBy(delta, 0);
            //} else {
                //scrollBy(delta, 0);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.630 -0400", hash_original_method = "DAE9EEC093475C9AC0229EA6C3F406DC", hash_generated_method = "507102C9D05BA1259EC1D76A67ED4BF6")
    public final void smoothScrollBy(int dx, int dy) {
        {
            boolean varF370735710C80808B6618BA2D491D045_948410326 = (getChildCount() == 0);
        } //End collapsed parenthetic
        long duration;
        duration = AnimationUtils.currentAnimationTimeMillis() - mLastScroll;
        {
            int width;
            width = getWidth() - mPaddingRight - mPaddingLeft;
            int right;
            right = getChildAt(0).getWidth();
            int maxX;
            maxX = Math.max(0, right - width);
            int scrollX;
            scrollX = mScrollX;
            dx = Math.max(0, Math.min(scrollX + dx, maxX)) - scrollX;
            mScroller.startScroll(scrollX, mScrollY, dx, 0);
            invalidate();
        } //End block
        {
            {
                boolean var11F6C92CC339B9B3B7C0C85A8DBD1165_1018677760 = (!mScroller.isFinished());
                {
                    mScroller.abortAnimation();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.631 -0400", hash_original_method = "EED648F6788EFF0F67B65ABAA0DE4CF2", hash_generated_method = "DA73281470CE7C276C318CD6CA129252")
    public final void smoothScrollTo(int x, int y) {
        smoothScrollBy(x - mScrollX, y - mScrollY);
        addTaint(x);
        addTaint(y);
        // ---------- Original Method ----------
        //smoothScrollBy(x - mScrollX, y - mScrollY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.631 -0400", hash_original_method = "344907C67A02819CC7A230367AD45761", hash_generated_method = "D5195C4B9662401F054659114629C73C")
    @Override
    protected int computeHorizontalScrollRange() {
        int count;
        count = getChildCount();
        int contentWidth;
        contentWidth = getWidth() - mPaddingLeft - mPaddingRight;
        int scrollRange;
        scrollRange = getChildAt(0).getRight();
        int scrollX;
        scrollX = mScrollX;
        int overscrollRight;
        overscrollRight = Math.max(0, scrollRange - contentWidth);
        {
            scrollRange -= scrollX;
        } //End block
        {
            scrollRange += scrollX - overscrollRight;
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_203051482 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_203051482;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.632 -0400", hash_original_method = "9CF354C1D07DBC59A9E2E44E57F7657B", hash_generated_method = "7EE571BD0A18FE44431BCB6E092A6BC0")
    @Override
    protected int computeHorizontalScrollOffset() {
        int var7A9951C5866872080505940D11B99587_1305593284 = (Math.max(0, super.computeHorizontalScrollOffset()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_320853515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_320853515;
        // ---------- Original Method ----------
        //return Math.max(0, super.computeHorizontalScrollOffset());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.632 -0400", hash_original_method = "1A4819189D92B65ABF3F692114902ED1", hash_generated_method = "B4F18299E6BFE34E598282B5A4A69885")
    @Override
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        ViewGroup.LayoutParams lp;
        lp = child.getLayoutParams();
        int childWidthMeasureSpec;
        int childHeightMeasureSpec;
        childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec, mPaddingTop
                + mPaddingBottom, lp.height);
        childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        addTaint(child.getTaint());
        addTaint(parentWidthMeasureSpec);
        addTaint(parentHeightMeasureSpec);
        // ---------- Original Method ----------
        //ViewGroup.LayoutParams lp = child.getLayoutParams();
        //int childWidthMeasureSpec;
        //int childHeightMeasureSpec;
        //childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec, mPaddingTop
                //+ mPaddingBottom, lp.height);
        //childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        //child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.632 -0400", hash_original_method = "0EA8DFEAF2643806863B304E52EE38A5", hash_generated_method = "94353745CB024908F00D826BF192294C")
    @Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed,
            int parentHeightMeasureSpec, int heightUsed) {
        MarginLayoutParams lp;
        lp = (MarginLayoutParams) child.getLayoutParams();
        int childHeightMeasureSpec;
        childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                mPaddingTop + mPaddingBottom + lp.topMargin + lp.bottomMargin
                        + heightUsed, lp.height);
        int childWidthMeasureSpec;
        childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(
                lp.leftMargin + lp.rightMargin, MeasureSpec.UNSPECIFIED);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        addTaint(child.getTaint());
        addTaint(parentWidthMeasureSpec);
        addTaint(widthUsed);
        addTaint(parentHeightMeasureSpec);
        addTaint(heightUsed);
        // ---------- Original Method ----------
        //final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        //final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                //mPaddingTop + mPaddingBottom + lp.topMargin + lp.bottomMargin
                        //+ heightUsed, lp.height);
        //final int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(
                //lp.leftMargin + lp.rightMargin, MeasureSpec.UNSPECIFIED);
        //child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.633 -0400", hash_original_method = "D30258BCA66C5E19407EB248DA88CE03", hash_generated_method = "5BCD99CC5B79DE93E0D4A00140006958")
    @Override
    public void computeScroll() {
        {
            boolean varE7DE5EF6873640B86AA94D9EE969CCF1_557529641 = (mScroller.computeScrollOffset());
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
                    overScrollBy(x - oldX, y - oldY, oldX, oldY, range, 0,
                        mOverflingDistance, 0, false);
                    onScrollChanged(mScrollX, mScrollY, oldX, oldY);
                    {
                        {
                            mEdgeGlowLeft.onAbsorb((int) mScroller.getCurrVelocity());
                        } //End block
                        {
                            mEdgeGlowRight.onAbsorb((int) mScroller.getCurrVelocity());
                        } //End block
                    } //End block
                } //End block
                awakenScrollBars();
                postInvalidate();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.636 -0400", hash_original_method = "988A7EC33B56EE551974E7C841966101", hash_generated_method = "D75228C6C24EEC4B722A2D4B8A645FE3")
    private void scrollToChild(View child) {
        child.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(child, mTempRect);
        int scrollDelta;
        scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
        {
            scrollBy(scrollDelta, 0);
        } //End block
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //child.getDrawingRect(mTempRect);
        //offsetDescendantRectToMyCoords(child, mTempRect);
        //int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
        //if (scrollDelta != 0) {
            //scrollBy(scrollDelta, 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.641 -0400", hash_original_method = "07633DDCD66F05F9C6104D95040C4376", hash_generated_method = "D79C3A28013DFB445ED42B9B949151BB")
    private boolean scrollToChildRect(Rect rect, boolean immediate) {
        int delta;
        delta = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean scroll;
        scroll = delta != 0;
        {
            {
                scrollBy(delta, 0);
            } //End block
            {
                smoothScrollBy(delta, 0);
            } //End block
        } //End block
        addTaint(rect.getTaint());
        addTaint(immediate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1368486720 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1368486720;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.651 -0400", hash_original_method = "8C5AA93676CE0EF7515972F93F61C0B6", hash_generated_method = "CA84FED126B73A220682BD19A9E9E9B4")
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        {
            boolean varF370735710C80808B6618BA2D491D045_1126239920 = (getChildCount() == 0);
        } //End collapsed parenthetic
        int width;
        width = getWidth();
        int screenLeft;
        screenLeft = getScrollX();
        int screenRight;
        screenRight = screenLeft + width;
        int fadingEdge;
        fadingEdge = getHorizontalFadingEdgeLength();
        {
            screenLeft += fadingEdge;
        } //End block
        {
            boolean var111E177520853BA7F7EEE5AEE5221F06_1221008784 = (rect.right < getChildAt(0).getWidth());
            {
                screenRight -= fadingEdge;
            } //End block
        } //End collapsed parenthetic
        int scrollXDelta;
        scrollXDelta = 0;
        {
            {
                boolean varAE73F3F4DF09B867223301D92BC7E6F0_2071473911 = (rect.width() > width);
                {
                    scrollXDelta += (rect.left - screenLeft);
                } //End block
                {
                    scrollXDelta += (rect.right - screenRight);
                } //End block
            } //End collapsed parenthetic
            int right;
            right = getChildAt(0).getRight();
            int distanceToRight;
            distanceToRight = right - screenRight;
            scrollXDelta = Math.min(scrollXDelta, distanceToRight);
        } //End block
        {
            {
                boolean varAE73F3F4DF09B867223301D92BC7E6F0_1072646676 = (rect.width() > width);
                {
                    scrollXDelta -= (screenRight - rect.right);
                } //End block
                {
                    scrollXDelta -= (screenLeft - rect.left);
                } //End block
            } //End collapsed parenthetic
            scrollXDelta = Math.max(scrollXDelta, -getScrollX());
        } //End block
        addTaint(rect.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_181374927 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_181374927;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.651 -0400", hash_original_method = "C2C4A47D49BA76A3A98712461E581564", hash_generated_method = "A6F96566FD9F1BE3771DA2878DF4DC46")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.652 -0400", hash_original_method = "4857D3DE9468292A125F69FE9ECFC007", hash_generated_method = "5BFE2A8EA5695E1949DD7B9521D311B2")
    @Override
    protected boolean onRequestFocusInDescendants(int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            direction = View.FOCUS_RIGHT;
        } //End block
        {
            direction = View.FOCUS_LEFT;
        } //End block
        View nextFocus;
        nextFocus = FocusFinder.getInstance().findNextFocus(this, null, direction);
        nextFocus = FocusFinder.getInstance().findNextFocusFromRect(this,
                        previouslyFocusedRect, direction);
        {
            boolean var2421F6D33436D75DDCB765DA8D416CB8_460872804 = (isOffScreen(nextFocus));
        } //End collapsed parenthetic
        boolean varBB06A889CCA25ED822B35181716FFE90_1921574178 = (nextFocus.requestFocus(direction, previouslyFocusedRect));
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_81966861 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_81966861;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.652 -0400", hash_original_method = "50E2DA7CF8E403536932E3B77491E964", hash_generated_method = "1FE510D9071297A6BBC923498C68E28C")
    @Override
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle,
            boolean immediate) {
        rectangle.offset(child.getLeft() - child.getScrollX(),
                child.getTop() - child.getScrollY());
        boolean var9EED5F05118BACEED05952D173A9E219_753990713 = (scrollToChildRect(rectangle, immediate));
        addTaint(child.getTaint());
        addTaint(rectangle.getTaint());
        addTaint(immediate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1202572062 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1202572062;
        // ---------- Original Method ----------
        //rectangle.offset(child.getLeft() - child.getScrollX(),
                //child.getTop() - child.getScrollY());
        //return scrollToChildRect(rectangle, immediate);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.653 -0400", hash_original_method = "31751D7E496E2D7BD9B4D4E94AD28515", hash_generated_method = "11A20A1DA3E3F0E4689DA3F629925C7D")
    @Override
    public void requestLayout() {
        mIsLayoutDirty = true;
        super.requestLayout();
        // ---------- Original Method ----------
        //mIsLayoutDirty = true;
        //super.requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.653 -0400", hash_original_method = "51521A672083F0AD2F639BD854AB8D0F", hash_generated_method = "6016217DD4B2FC1F68F9DC58ED841A86")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onLayout(changed, l, t, r, b);
        mIsLayoutDirty = false;
        {
            boolean varFEFF39315B1161E387E3A3BC8A5B6333_1474288160 = (mChildToScrollTo != null && isViewDescendantOf(mChildToScrollTo, this));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.663 -0400", hash_original_method = "BFC9FDBBB166F0ED568B66B969E998B2", hash_generated_method = "70DCAE10501BA751B2A6235C37520C7D")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onSizeChanged(w, h, oldw, oldh);
        View currentFocused;
        currentFocused = findFocus();
        int maxJump;
        maxJump = mRight - mLeft;
        {
            boolean var23B5651428E53758F7813143E4B31F1D_25556628 = (isWithinDeltaOfScreen(currentFocused, maxJump));
            {
                currentFocused.getDrawingRect(mTempRect);
                offsetDescendantRectToMyCoords(currentFocused, mTempRect);
                int scrollDelta;
                scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
                doScrollX(scrollDelta);
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
        //final int maxJump = mRight - mLeft;
        //if (isWithinDeltaOfScreen(currentFocused, maxJump)) {
            //currentFocused.getDrawingRect(mTempRect);
            //offsetDescendantRectToMyCoords(currentFocused, mTempRect);
            //int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
            //doScrollX(scrollDelta);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.663 -0400", hash_original_method = "25276A1ACE97D138BB17C9052B223D37", hash_generated_method = "594DA7B0552CBBB73CEA32570969A0B1")
    private boolean isViewDescendantOf(View child, View parent) {
        ViewParent theParent;
        theParent = child.getParent();
        boolean var948A486C9D980B3FCF5DD6DC234D8E28_1745736706 = ((theParent instanceof ViewGroup) && isViewDescendantOf((View) theParent, parent));
        addTaint(child.getTaint());
        addTaint(parent.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2127159394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2127159394;
        // ---------- Original Method ----------
        //if (child == parent) {
            //return true;
        //}
        //final ViewParent theParent = child.getParent();
        //return (theParent instanceof ViewGroup) && isViewDescendantOf((View) theParent, parent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.667 -0400", hash_original_method = "C5A2747735A9CF7D4575D6EE52958D1F", hash_generated_method = "53C86C10D689138C16A6BF93504A6EFF")
    public void fling(int velocityX) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1370948518 = (getChildCount() > 0);
            {
                int width;
                width = getWidth() - mPaddingRight - mPaddingLeft;
                int right;
                right = getChildAt(0).getWidth();
                mScroller.fling(mScrollX, mScrollY, velocityX, 0, 0,
                    Math.max(0, right - width), 0, 0, width/2, 0);
                boolean movingRight;
                movingRight = velocityX > 0;
                View currentFocused;
                currentFocused = findFocus();
                View newFocused;
                newFocused = findFocusableViewInMyBounds(movingRight,
                    mScroller.getFinalX(), currentFocused);
                {
                    newFocused = this;
                } //End block
                {
                    newFocused.requestFocus(movingRight ? View.FOCUS_RIGHT : View.FOCUS_LEFT);
                } //End block
                invalidate();
            } //End block
        } //End collapsed parenthetic
        addTaint(velocityX);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.668 -0400", hash_original_method = "748C5914370A5F8CDD8109B6F4611B5B", hash_generated_method = "5F7E84C94ACC1867BB708CCC0924ADE3")
    @Override
    public void scrollTo(int x, int y) {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1115733149 = (getChildCount() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.668 -0400", hash_original_method = "7D7EAD2993C7155FA8CA9421487AA499", hash_generated_method = "C0A4184E2AE8E8090532172699148362")
    @Override
    public void setOverScrollMode(int mode) {
        {
            {
                Context context;
                context = getContext();
                mEdgeGlowLeft = new EdgeEffect(context);
                mEdgeGlowRight = new EdgeEffect(context);
            } //End block
        } //End block
        {
            mEdgeGlowLeft = null;
            mEdgeGlowRight = null;
        } //End block
        super.setOverScrollMode(mode);
        addTaint(mode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.677 -0400", hash_original_method = "63AFEEC895B9671DC479FE83536227D7", hash_generated_method = "2552ABC05CACCFD94C16A348C9DBC75C")
    @SuppressWarnings({"SuspiciousNameCombination"})
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        {
            int scrollX;
            scrollX = mScrollX;
            {
                boolean var1ECF01FA9E017D6BE3235AB8A34635E8_894478762 = (!mEdgeGlowLeft.isFinished());
                {
                    int restoreCount;
                    restoreCount = canvas.save();
                    int height;
                    height = getHeight() - mPaddingTop - mPaddingBottom;
                    canvas.rotate(270);
                    canvas.translate(-height + mPaddingTop, Math.min(0, scrollX));
                    mEdgeGlowLeft.setSize(height, getWidth());
                    {
                        boolean var610D4E0E7DF4A306CD193957D2FE9A09_1011663281 = (mEdgeGlowLeft.draw(canvas));
                        {
                            invalidate();
                        } //End block
                    } //End collapsed parenthetic
                    canvas.restoreToCount(restoreCount);
                } //End block
            } //End collapsed parenthetic
            {
                boolean varFB5CAACA6057E33D653CCB246DF230DF_740575298 = (!mEdgeGlowRight.isFinished());
                {
                    int restoreCount;
                    restoreCount = canvas.save();
                    int width;
                    width = getWidth();
                    int height;
                    height = getHeight() - mPaddingTop - mPaddingBottom;
                    canvas.rotate(90);
                    canvas.translate(-mPaddingTop,
                        -(Math.max(getScrollRange(), scrollX) + width));
                    mEdgeGlowRight.setSize(height, width);
                    {
                        boolean var0CDA4D4B63F069A0ADED01E10A235FEC_2009601932 = (mEdgeGlowRight.draw(canvas));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.678 -0400", hash_original_method = "10E81B579101690AB90AC933866D5438", hash_generated_method = "921FB2BD90563902BC049258BDDFD884")
    private int clamp(int n, int my, int child) {
        addTaint(n);
        addTaint(my);
        addTaint(child);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_352562841 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_352562841;
        // ---------- Original Method ----------
        //if (my >= child || n < 0) {
            //return 0;
        //}
        //if ((my + n) > child) {
            //return child - my;
        //}
        //return n;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.678 -0400", hash_original_field = "592B4C751C2D22CD7D43317BD897714A", hash_generated_field = "018B77B6661104DBE0CD6C323146736E")

    private static int ANIMATED_SCROLL_GAP = ScrollView.ANIMATED_SCROLL_GAP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.678 -0400", hash_original_field = "CA227357940761AB7254479B7BD99962", hash_generated_field = "405D2BECEB77C0A33F0943BA8701E354")

    private static float MAX_SCROLL_FACTOR = ScrollView.MAX_SCROLL_FACTOR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.678 -0400", hash_original_field = "7EF8B2C57AC3A1D5EC1190F4098C6121", hash_generated_field = "EC0CE8121C7A62BAD74595655C619E28")

    private static int INVALID_POINTER = -1;
}

