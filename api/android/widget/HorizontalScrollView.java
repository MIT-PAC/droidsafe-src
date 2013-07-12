package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.790 -0400", hash_original_field = "380EFAD062415C5D611446C1B15B307D", hash_generated_field = "507FF60BF6AED501221786F4F9B1C4CE")

    private long mLastScroll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.790 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

    private final Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.791 -0400", hash_original_field = "360DD66618E954525BEA0D65B05DC7EC", hash_generated_field = "7106C69F4E49AB9D7F59F38965DF6036")

    private OverScroller mScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.791 -0400", hash_original_field = "ACEBD86C89C68033BA00F1E22D2FC23B", hash_generated_field = "CF32CFBB2A976E850EE8DDE803F384D7")

    private EdgeEffect mEdgeGlowLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.791 -0400", hash_original_field = "876C7C33DE6802509886BB6ADFFE041C", hash_generated_field = "304A2CBEA7C331CEDE170973F40765C0")

    private EdgeEffect mEdgeGlowRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.791 -0400", hash_original_field = "4F6DEDF0BA2D99325BDAE4A27C301E0B", hash_generated_field = "90F53F7625CC0EEE4DC6EBCFF5E518A6")

    private float mLastMotionX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.791 -0400", hash_original_field = "A43EC71B2E74CACC223B47379717A080", hash_generated_field = "9C16E67A6EDB3E799E01AFB02BCF7815")

    private boolean mIsLayoutDirty = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.791 -0400", hash_original_field = "8949A253727FAE7FB577F98D2A9463C2", hash_generated_field = "7E1EAB0DC4AB4B81BAB22B01D588949E")

    private View mChildToScrollTo = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.791 -0400", hash_original_field = "A8AB6008485C6E787B3DBB97D2050FF4", hash_generated_field = "40AA109CDE3739730D8C499D23D26FF1")

    private boolean mIsBeingDragged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.791 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.791 -0400", hash_original_field = "B3E3E62AA85A925921DCB2869A4E7017", hash_generated_field = "16DDF79C39D64DD0F8B72040D2242A75")

    @ViewDebug.ExportedProperty(category = "layout") private boolean mFillViewport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.791 -0400", hash_original_field = "581BD96ACB5FC0F4F529183E58EA63B2", hash_generated_field = "EA3AE5CC17F6060C1DBAA2AAAFFFC35C")

    private boolean mSmoothScrollingEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.791 -0400", hash_original_field = "3DFFFAD10926598D18EEC50D61DE79CA", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.791 -0400", hash_original_field = "30B0DF23DBDF2426D66E4D98494C369B", hash_generated_field = "7DBE1A18599B8760DC9B67AAFE3499E3")

    private int mMinimumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.791 -0400", hash_original_field = "1C66D9179508D091F8E90C9FEBAD15CA", hash_generated_field = "6F997413D0B227487940C402EB78A8FD")

    private int mMaximumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.791 -0400", hash_original_field = "7A5B6F76BA72A8D6AFCFCEA14B8C2556", hash_generated_field = "7B0107E1CAE9FFC281D766335539D7C4")

    private int mOverscrollDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.791 -0400", hash_original_field = "755491871A4FCE3E01181030F8FEB178", hash_generated_field = "06022A8A798B4C892D35D0FFB16D2FDF")

    private int mOverflingDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.792 -0400", hash_original_field = "D0F34CC6DB83FC46AEC38F19CA5CE138", hash_generated_field = "1B464B20D80463EC30779F63AB0559BD")

    private int mActivePointerId = INVALID_POINTER;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.792 -0400", hash_original_method = "D579CCE5E39252987369F5EF7BC67FC0", hash_generated_method = "14051F04924CFB33DDABF2912876D78F")
    public  HorizontalScrollView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.792 -0400", hash_original_method = "7F7EA51B0CF52F1D171B225CFAE9439C", hash_generated_method = "5DD8D3112CC9437FFA1029FAC50BB5E5")
    public  HorizontalScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.horizontalScrollViewStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.793 -0400", hash_original_method = "ABF3CE2040AE9A0702C38DF91EEF10E7", hash_generated_method = "120D1237A739744E6399B506AE3126CF")
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
        
        
        
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.793 -0400", hash_original_method = "041555434146A9B8485461655BD1A318", hash_generated_method = "8D4EF2195566ED8E45A2F4B9790887EC")
    @Override
    protected float getLeftFadingEdgeStrength() {
    if(getChildCount() == 0)        
        {
            float var2C64466C1DFC5FC617E8E7707C276CC3_730278497 = (0.0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_1878228016 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1878228016;
        } 
        final int length = getHorizontalFadingEdgeLength();
    if(mScrollX < length)        
        {
            float varE6986454617065CD04CBD0B907EE353C_1601802510 = (mScrollX / (float) length);
                        float var546ADE640B6EDFBC8A086EF31347E768_983989114 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_983989114;
        } 
        float varCFE70293CC98B68AC513E2798BAD793D_422714657 = (1.0f);
                float var546ADE640B6EDFBC8A086EF31347E768_74093627 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_74093627;
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.794 -0400", hash_original_method = "AC1CCEB780F155A105BA88465002385B", hash_generated_method = "7D0FF2F585B775A216255D80047D8B07")
    @Override
    protected float getRightFadingEdgeStrength() {
    if(getChildCount() == 0)        
        {
            float var2C64466C1DFC5FC617E8E7707C276CC3_542220016 = (0.0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_1578492499 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1578492499;
        } 
        final int length = getHorizontalFadingEdgeLength();
        final int rightEdge = getWidth() - mPaddingRight;
        final int span = getChildAt(0).getRight() - mScrollX - rightEdge;
    if(span < length)        
        {
            float var941A690C6CFF230827FF210C6B3392A9_439286053 = (span / (float) length);
                        float var546ADE640B6EDFBC8A086EF31347E768_368901207 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_368901207;
        } 
        float varCFE70293CC98B68AC513E2798BAD793D_1464496042 = (1.0f);
                float var546ADE640B6EDFBC8A086EF31347E768_1194387628 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1194387628;
        
        
            
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.794 -0400", hash_original_method = "F72D9B4700B8FCB550AB26E9792E603C", hash_generated_method = "1766023EFFB14AAFB26D1B2D36FF3713")
    public int getMaxScrollAmount() {
        int var3811E0A0C3B22AE8514C2309C41B7802_1089027136 = ((int) (MAX_SCROLL_FACTOR * (mRight - mLeft)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1417503358 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1417503358;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.795 -0400", hash_original_method = "02BBAF53D85E267FB240E2D4309C877F", hash_generated_method = "02BFF61AA3D9E1FA9C55929FA1EDF318")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.795 -0400", hash_original_method = "28BB619967A3B168E514D899D7C1C204", hash_generated_method = "29B5EF968B0177BB121AE0513339FE12")
    @Override
    public void addView(View child) {
        addTaint(child.getTaint());
    if(getChildCount() > 0)        
        {
            IllegalStateException var05A10724DF5EE1DED9BB2CB05480822D_1251658596 = new IllegalStateException("HorizontalScrollView can host only one direct child");
            var05A10724DF5EE1DED9BB2CB05480822D_1251658596.addTaint(taint);
            throw var05A10724DF5EE1DED9BB2CB05480822D_1251658596;
        } 
        super.addView(child);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.796 -0400", hash_original_method = "D082E00953E9B886F1BBE563E072EA76", hash_generated_method = "58F560746018A3B9FF00BAB985D58C32")
    @Override
    public void addView(View child, int index) {
        addTaint(index);
        addTaint(child.getTaint());
    if(getChildCount() > 0)        
        {
            IllegalStateException var05A10724DF5EE1DED9BB2CB05480822D_2114466473 = new IllegalStateException("HorizontalScrollView can host only one direct child");
            var05A10724DF5EE1DED9BB2CB05480822D_2114466473.addTaint(taint);
            throw var05A10724DF5EE1DED9BB2CB05480822D_2114466473;
        } 
        super.addView(child, index);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.796 -0400", hash_original_method = "35F41E1C04BFB475A60C431B3898F857", hash_generated_method = "24E313613C1E19BC4044BDD6DEA71121")
    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(child.getTaint());
    if(getChildCount() > 0)        
        {
            IllegalStateException var05A10724DF5EE1DED9BB2CB05480822D_435292394 = new IllegalStateException("HorizontalScrollView can host only one direct child");
            var05A10724DF5EE1DED9BB2CB05480822D_435292394.addTaint(taint);
            throw var05A10724DF5EE1DED9BB2CB05480822D_435292394;
        } 
        super.addView(child, params);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.796 -0400", hash_original_method = "D331A2B6162E307FE1F025F2ABEA7C28", hash_generated_method = "110075D0CBD9A1560AEA91207DAB24B2")
    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(index);
        addTaint(child.getTaint());
    if(getChildCount() > 0)        
        {
            IllegalStateException var05A10724DF5EE1DED9BB2CB05480822D_2135129551 = new IllegalStateException("HorizontalScrollView can host only one direct child");
            var05A10724DF5EE1DED9BB2CB05480822D_2135129551.addTaint(taint);
            throw var05A10724DF5EE1DED9BB2CB05480822D_2135129551;
        } 
        super.addView(child, index, params);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.797 -0400", hash_original_method = "3DE53F922B0BEA48963A7A11A88BC712", hash_generated_method = "3D73E763DC05B9C5447504A901CED01E")
    private boolean canScroll() {
        View child = getChildAt(0);
    if(child != null)        
        {
            int childWidth = child.getWidth();
            boolean varADCB9BFDAE39B6778BB46AAB32CB64ED_969941633 = (getWidth() < childWidth + mPaddingLeft + mPaddingRight);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1577354168 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1577354168;
        } 
        boolean var68934A3E9455FA72420237EB05902327_1632043059 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1799177790 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1799177790;
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.797 -0400", hash_original_method = "801E6F065AC6A60CFB0DADB1E074F98E", hash_generated_method = "373D1AB22F88FD1530A85A999FEEC6C5")
    public boolean isFillViewport() {
        boolean varB3E3E62AA85A925921DCB2869A4E7017_366729571 = (mFillViewport);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_771728862 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_771728862;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.797 -0400", hash_original_method = "D2588C7F74D0E18DF5DFA629FE7BF270", hash_generated_method = "F2E2A5C18232B8609B837CA278719D40")
    public void setFillViewport(boolean fillViewport) {
    if(fillViewport != mFillViewport)        
        {
            mFillViewport = fillViewport;
            requestLayout();
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.797 -0400", hash_original_method = "D26C58327C0CB18AC1F62B7629FD16B1", hash_generated_method = "0912AF3F169A81A25F32C6B17796C067")
    public boolean isSmoothScrollingEnabled() {
        boolean var15B603515FEC15F2893A41D962B8656B_1784574402 = (mSmoothScrollingEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1572345847 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1572345847;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.798 -0400", hash_original_method = "63C96CE84D9CD60CA1FF4EF87D7FF4F5", hash_generated_method = "5C7F23BB3E765786BEE5D256B048D32A")
    public void setSmoothScrollingEnabled(boolean smoothScrollingEnabled) {
        mSmoothScrollingEnabled = smoothScrollingEnabled;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.798 -0400", hash_original_method = "1306D2831DF4DA9A5EDAD3DA6127274D", hash_generated_method = "EE512012F00EA80710F870D8C0240B91")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    if(!mFillViewport)        
        {
            return;
        } 
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
    if(widthMode == MeasureSpec.UNSPECIFIED)        
        {
            return;
        } 
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
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.799 -0400", hash_original_method = "40D3C8E04EF2AEB04EFDF302E05EC516", hash_generated_method = "6C28C1F03079755BDA4C19EA5AC92548")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        boolean var4D7C358C8BD535F7098378506DB34C5F_286262525 = (super.dispatchKeyEvent(event) || executeKeyEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2083665787 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2083665787;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.800 -0400", hash_original_method = "59EE8B926A303894927E6FAD605B1FF1", hash_generated_method = "5CD0A1FD73101142D65B71B164C1FD3A")
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
                boolean var2D16C80B5336D8EEAE1F48547DDA8A1E_1237311221 = (nextFocused != null && nextFocused != this &&
                        nextFocused.requestFocus(View.FOCUS_RIGHT));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_17703396 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_17703396;
            } 
            boolean var68934A3E9455FA72420237EB05902327_1491981020 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_229415676 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_229415676;
        } 
        boolean handled = false;
    if(event.getAction() == KeyEvent.ACTION_DOWN)        
        {
switch(event.getKeyCode()){
            case KeyEvent.KEYCODE_DPAD_LEFT:
    if(!event.isAltPressed())            
            {
                handled = arrowScroll(View.FOCUS_LEFT);
            } 
            else
            {
                handled = fullScroll(View.FOCUS_LEFT);
            } 
            break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
    if(!event.isAltPressed())            
            {
                handled = arrowScroll(View.FOCUS_RIGHT);
            } 
            else
            {
                handled = fullScroll(View.FOCUS_RIGHT);
            } 
            break;
            case KeyEvent.KEYCODE_SPACE:
            pageScroll(event.isShiftPressed() ? View.FOCUS_LEFT : View.FOCUS_RIGHT);
            break;
}
        } 
        boolean var98F0599AF776A1FE4101C199A40EEB8F_1661911178 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_674089694 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_674089694;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.800 -0400", hash_original_method = "9319BD4BC402BC56524E94C60EDF0AE3", hash_generated_method = "70A1218F814968ACF91639EFC84E54BB")
    private boolean inChild(int x, int y) {
        addTaint(y);
        addTaint(x);
    if(getChildCount() > 0)        
        {
            final int scrollX = mScrollX;
            final View child = getChildAt(0);
            boolean var315B4686B994B17FFBC4F4304C1A43F9_1924451511 = (!(y < child.getTop()
                    || y >= child.getBottom()
                    || x < child.getLeft() - scrollX
                    || x >= child.getRight() - scrollX));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1646857668 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1646857668;
        } 
        boolean var68934A3E9455FA72420237EB05902327_1952918911 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1144915245 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1144915245;
        
        
            
            
            
                    
                    
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.801 -0400", hash_original_method = "2F2E3E2ED97C397B1954EFE1C35FD1EF", hash_generated_method = "E6A2459F70C94EEE4F8E0DC05B01F193")
    private void initOrResetVelocityTracker() {
    if(mVelocityTracker == null)        
        {
            mVelocityTracker = VelocityTracker.obtain();
        } 
        else
        {
            mVelocityTracker.clear();
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.801 -0400", hash_original_method = "2C2F1E0A6C232182F8110D9EE75ED47E", hash_generated_method = "2B8D7737D5D71D4902AEB864DE542716")
    private void initVelocityTrackerIfNotExists() {
    if(mVelocityTracker == null)        
        {
            mVelocityTracker = VelocityTracker.obtain();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.801 -0400", hash_original_method = "FC3B581D4963BCED4340031BA20C5421", hash_generated_method = "701A7C43D055D340A0D18EE9D957EDFF")
    private void recycleVelocityTracker() {
    if(mVelocityTracker != null)        
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.802 -0400", hash_original_method = "C74400E8950C106883E854683AF24673", hash_generated_method = "0484ACC96D68F9484E340AA90FA16493")
    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        addTaint(disallowIntercept);
    if(disallowIntercept)        
        {
            recycleVelocityTracker();
        } 
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.804 -0400", hash_original_method = "B8EBEABAF4D085F1DC9FA2F6547DBF28", hash_generated_method = "32D120AB3293B94683A51AE622BE7FAE")
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        
        final int action = ev.getAction();
    if((action == MotionEvent.ACTION_MOVE) && (mIsBeingDragged))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1415169531 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1811063801 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1811063801;
        } 
switch(action & MotionEvent.ACTION_MASK){
        case MotionEvent.ACTION_MOVE:
        {
            final int activePointerId = mActivePointerId;
    if(activePointerId == INVALID_POINTER)            
            {
                break;
            } 
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
            } 
            break;
        } 
        case MotionEvent.ACTION_DOWN:
        {
            final float x = ev.getX();
    if(!inChild((int) x, (int) ev.getY()))            
            {
                mIsBeingDragged = false;
                recycleVelocityTracker();
                break;
            } 
            mLastMotionX = x;
            mActivePointerId = ev.getPointerId(0);
            initOrResetVelocityTracker();
            mVelocityTracker.addMovement(ev);
            mIsBeingDragged = !mScroller.isFinished();
            break;
        } 
        case MotionEvent.ACTION_CANCEL:
        case MotionEvent.ACTION_UP:
        mIsBeingDragged = false;
        mActivePointerId = INVALID_POINTER;
    if(mScroller.springBack(mScrollX, mScrollY, 0, getScrollRange(), 0, 0))        
        {
            invalidate();
        } 
        break;
        case MotionEvent.ACTION_POINTER_DOWN:
        {
            final int index = ev.getActionIndex();
            mLastMotionX = ev.getX(index);
            mActivePointerId = ev.getPointerId(index);
            break;
        } 
        case MotionEvent.ACTION_POINTER_UP:
        onSecondaryPointerUp(ev);
        mLastMotionX = ev.getX(ev.findPointerIndex(mActivePointerId));
        break;
}        boolean varCD7F83DE880FD2A584529B26609B9552_225975404 = (mIsBeingDragged);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_612389662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_612389662;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.806 -0400", hash_original_method = "DC232709D0DE420641FAAFB6B744429B", hash_generated_method = "2FD55D40F7BA535D46C7AA5A0A30D95C")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        
        initVelocityTrackerIfNotExists();
        mVelocityTracker.addMovement(ev);
        final int action = ev.getAction();
switch(action & MotionEvent.ACTION_MASK){
        case MotionEvent.ACTION_DOWN:
        {
            mIsBeingDragged = getChildCount() != 0;
    if(!mIsBeingDragged)            
            {
                boolean var68934A3E9455FA72420237EB05902327_324737201 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1948863368 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1948863368;
            } 
    if(!mScroller.isFinished())            
            {
                mScroller.abortAnimation();
            } 
            mLastMotionX = ev.getX();
            mActivePointerId = ev.getPointerId(0);
            break;
        } 
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
            } 
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
                    } 
                } 
                else
    if(pulledToX > range)                
                {
                    mEdgeGlowRight.onPull((float) deltaX / getWidth());
    if(!mEdgeGlowLeft.isFinished())                    
                    {
                        mEdgeGlowLeft.onRelease();
                    } 
                } 
    if(mEdgeGlowLeft != null
                                && (!mEdgeGlowLeft.isFinished() || !mEdgeGlowRight.isFinished()))                
                {
                    invalidate();
                } 
            } 
        } 
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
                } 
                else
                {
    if(mScroller.springBack(mScrollX, mScrollY, 0,
                                    getScrollRange(), 0, 0))                    
                    {
                        invalidate();
                    } 
                } 
            } 
            mActivePointerId = INVALID_POINTER;
            mIsBeingDragged = false;
            recycleVelocityTracker();
    if(mEdgeGlowLeft != null)            
            {
                mEdgeGlowLeft.onRelease();
                mEdgeGlowRight.onRelease();
            } 
        } 
        break;
        case MotionEvent.ACTION_CANCEL:
    if(mIsBeingDragged && getChildCount() > 0)        
        {
    if(mScroller.springBack(mScrollX, mScrollY, 0, getScrollRange(), 0, 0))            
            {
                invalidate();
            } 
            mActivePointerId = INVALID_POINTER;
            mIsBeingDragged = false;
            recycleVelocityTracker();
    if(mEdgeGlowLeft != null)            
            {
                mEdgeGlowLeft.onRelease();
                mEdgeGlowRight.onRelease();
            } 
        } 
        break;
        case MotionEvent.ACTION_POINTER_UP:
        onSecondaryPointerUp(ev);
        break;
}        boolean varB326B5062B2F0E69046810717534CB09_636298364 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_14701147 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_14701147;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.808 -0400", hash_original_method = "15678E7D87FCB5B2E2A6D15F2CBAE390", hash_generated_method = "6E8CEB267E5C94F79FF4514B7A7BA1AE")
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
            } 
        } 
        
        
                
        
        
            
            
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.809 -0400", hash_original_method = "EA19C55D5CBC44B40040771841401365", hash_generated_method = "1B3271172421022907EF22199A20DBFE")
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        
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
                    } 
                    else
                    {
                        hscroll = event.getAxisValue(MotionEvent.AXIS_HSCROLL);
                    } 
    if(hscroll != 0)                    
                    {
                        final int delta = (int) (hscroll * getHorizontalScrollFactor());
                        final int range = getScrollRange();
                        int oldScrollX = mScrollX;
                        int newScrollX = oldScrollX + delta;
    if(newScrollX < 0)                        
                        {
                            newScrollX = 0;
                        } 
                        else
    if(newScrollX > range)                        
                        {
                            newScrollX = range;
                        } 
    if(newScrollX != oldScrollX)                        
                        {
                            super.scrollTo(newScrollX, mScrollY);
                            boolean varB326B5062B2F0E69046810717534CB09_1708980776 = (true);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_368347336 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_368347336;
                        } 
                    } 
                } 
            } 
}
        } 
        boolean var3B54C423A43BA14BBEA440506237FA4B_366385917 = (super.onGenericMotionEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_905058309 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_905058309;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.811 -0400", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "17614565EC2FBE056A8C7371187097D7")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean varB326B5062B2F0E69046810717534CB09_1256804311 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1379230087 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1379230087;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.812 -0400", hash_original_method = "06CAD3F9DAB24C265A0AAEC7445D85D7", hash_generated_method = "9FCAC737D0B0C30894E5FEDAB13B5BF9")
    @Override
    protected void onOverScrolled(int scrollX, int scrollY,
            boolean clampedX, boolean clampedY) {
        
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
            } 
        } 
        else
        {
            super.scrollTo(scrollX, scrollY);
        } 
        awakenScrollBars();
        
        
            
            
            
            
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.814 -0400", hash_original_method = "AF8EC74B0AD4D69DC5ACACFC8749064F", hash_generated_method = "2035CC755BD505267DFD2C0A965F4DCF")
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        
        addTaint(info.getTaint());
        super.onInitializeAccessibilityNodeInfo(info);
        info.setScrollable(getScrollRange() > 0);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.814 -0400", hash_original_method = "7DA515169DBC462D06A7F08F561D2E84", hash_generated_method = "CEF007BE694C3C607FD2AB3C05372CC0")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        
        addTaint(event.getTaint());
        super.onInitializeAccessibilityEvent(event);
        event.setScrollable(getScrollRange() > 0);
        event.setScrollX(mScrollX);
        event.setScrollY(mScrollY);
        event.setMaxScrollX(getScrollRange());
        event.setMaxScrollY(mScrollY);
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.815 -0400", hash_original_method = "6035917F8C30F3A1C02AFED333ACB352", hash_generated_method = "BE40CC84A5064645477762407261E562")
    private int getScrollRange() {
        int scrollRange = 0;
    if(getChildCount() > 0)        
        {
            View child = getChildAt(0);
            scrollRange = Math.max(0,
                    child.getWidth() - (getWidth() - mPaddingLeft - mPaddingRight));
        } 
        int var94D4A3ECD79FF3E17EB5BD0659AF9AAE_1786545784 = (scrollRange);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_81062115 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_81062115;
        
        
        
            
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.816 -0400", hash_original_method = "B34C300D12B589B0218EA4927548AE87", hash_generated_method = "73905363E16F205D6ECAF6C4C071DD66")
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
View varEDCC47E7BD000496BBF92CD9272FBD7B_1938417863 =             preferredFocusable;
            varEDCC47E7BD000496BBF92CD9272FBD7B_1938417863.addTaint(taint);
            return varEDCC47E7BD000496BBF92CD9272FBD7B_1938417863;
        } 
View var3C5DAB17BC904AC109467AE0B923004B_1635348216 =         findFocusableViewInBounds(leftFocus, leftWithoutFadingEdge,
                rightWithoutFadingEdge);
        var3C5DAB17BC904AC109467AE0B923004B_1635348216.addTaint(taint);
        return var3C5DAB17BC904AC109467AE0B923004B_1635348216;
        
        
        
        
        
                
                
            
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.819 -0400", hash_original_method = "CFAC89DA51B9853AC14992D421225DFD", hash_generated_method = "AC243E9B06919EEDDADC3861A6771667")
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
                } 
                else
                {
                    final boolean viewIsCloserToBoundary = (leftFocus && viewLeft < focusCandidate.getLeft()) ||
                                    (!leftFocus && viewRight > focusCandidate.getRight());
    if(foundFullyContainedFocusable)                    
                    {
    if(viewIsFullyContained && viewIsCloserToBoundary)                        
                        {
                            focusCandidate = view;
                        } 
                    } 
                    else
                    {
    if(viewIsFullyContained)                        
                        {
                            focusCandidate = view;
                            foundFullyContainedFocusable = true;
                        } 
                        else
    if(viewIsCloserToBoundary)                        
                        {
                            focusCandidate = view;
                        } 
                    } 
                } 
            } 
        } 
View var9E337B9582937B68BAD70C44709A03C7_1043995767 =         focusCandidate;
        var9E337B9582937B68BAD70C44709A03C7_1043995767.addTaint(taint);
        return var9E337B9582937B68BAD70C44709A03C7_1043995767;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.821 -0400", hash_original_method = "DA183CDCD6EA3DA10063DE059735FFD7", hash_generated_method = "41153C33A76FD5335B47C8E584769750")
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
                } 
            } 
        } 
        else
        {
            mTempRect.left = getScrollX() - width;
    if(mTempRect.left < 0)            
            {
                mTempRect.left = 0;
            } 
        } 
        mTempRect.right = mTempRect.left + width;
        boolean var7C1EF92AB564BC909CCE560A1120AF30_1597993029 = (scrollAndFocus(direction, mTempRect.left, mTempRect.right));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_336636729 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_336636729;
        
        
        
        
            
            
            
                
                
                    
                
            
        
            
            
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.822 -0400", hash_original_method = "13724385C240165AD29E108B78F9E99D", hash_generated_method = "54971A68141588E04E68B04647DC903F")
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
            } 
        } 
        boolean var7C1EF92AB564BC909CCE560A1120AF30_490992881 = (scrollAndFocus(direction, mTempRect.left, mTempRect.right));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_835384581 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_835384581;
        
        
        
        
        
        
            
            
                
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.823 -0400", hash_original_method = "DF3968C57E4B66E8EEB56F2D4C42BFD9", hash_generated_method = "80581016B0F45381498A8CE5D27F125B")
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
        } 
    if(left >= containerLeft && right <= containerRight)        
        {
            handled = false;
        } 
        else
        {
            int delta = goLeft ? (left - containerLeft) : (right - containerRight);
            doScrollX(delta);
        } 
    if(newFocused != findFocus())        
        newFocused.requestFocus(direction);
        boolean var98F0599AF776A1FE4101C199A40EEB8F_1099044200 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1854712944 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1854712944;
        
        
        
        
        
        
        
        
            
        
        
            
        
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.824 -0400", hash_original_method = "ED0B7D3300F52C8B0FEFDD6EE298A1FB", hash_generated_method = "A86547895186A55C0E0BE88A6A00B9B3")
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
        } 
        else
        {
            int scrollDelta = maxJump;
    if(direction == View.FOCUS_LEFT && getScrollX() < scrollDelta)            
            {
                scrollDelta = getScrollX();
            } 
            else
    if(direction == View.FOCUS_RIGHT && getChildCount() > 0)            
            {
                int daRight = getChildAt(0).getRight();
                int screenRight = getScrollX() + getWidth();
    if(daRight - screenRight < maxJump)                
                {
                    scrollDelta = daRight - screenRight;
                } 
            } 
    if(scrollDelta == 0)            
            {
                boolean var68934A3E9455FA72420237EB05902327_889947425 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1121837707 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1121837707;
            } 
            doScrollX(direction == View.FOCUS_RIGHT ? scrollDelta : -scrollDelta);
        } 
    if(currentFocused != null && currentFocused.isFocused()
                && isOffScreen(currentFocused))        
        {
            final int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        } 
        boolean varB326B5062B2F0E69046810717534CB09_909076109 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1356389819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1356389819;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.825 -0400", hash_original_method = "E39461866A28C70AD36F56E791C6BE3B", hash_generated_method = "81091C6F1A229CC58FDDAD46D55C0527")
    private boolean isOffScreen(View descendant) {
        addTaint(descendant.getTaint());
        boolean var3D726CE330560D3EFA6DFB1FF35B4C67_497499873 = (!isWithinDeltaOfScreen(descendant, 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_327187818 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_327187818;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.825 -0400", hash_original_method = "47CB02AABD47C9E7AF2DCBC38CD370E2", hash_generated_method = "95DA860F6943FAA974E2FC65601BC0C9")
    private boolean isWithinDeltaOfScreen(View descendant, int delta) {
        addTaint(delta);
        addTaint(descendant.getTaint());
        descendant.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(descendant, mTempRect);
        boolean varFACA1C4E77F32851DF23DA96FB43CD96_951461861 = ((mTempRect.right + delta) >= getScrollX()
                && (mTempRect.left - delta) <= (getScrollX() + getWidth()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_291510378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_291510378;
        
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.826 -0400", hash_original_method = "3F16B27E18A709EC962C39AF363F3965", hash_generated_method = "C93A97A668F634FF7B4DA6D35A07845F")
    private void doScrollX(int delta) {
        addTaint(delta);
    if(delta != 0)        
        {
    if(mSmoothScrollingEnabled)            
            {
                smoothScrollBy(delta, 0);
            } 
            else
            {
                scrollBy(delta, 0);
            } 
        } 
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.827 -0400", hash_original_method = "DAE9EEC093475C9AC0229EA6C3F406DC", hash_generated_method = "D107125CA7489BD9FD31DD40266B0EF6")
    public final void smoothScrollBy(int dx, int dy) {
        addTaint(dy);
        addTaint(dx);
    if(getChildCount() == 0)        
        {
            return;
        } 
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
        } 
        else
        {
    if(!mScroller.isFinished())            
            {
                mScroller.abortAnimation();
            } 
            scrollBy(dx, dy);
        } 
        mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.827 -0400", hash_original_method = "EED648F6788EFF0F67B65ABAA0DE4CF2", hash_generated_method = "1619451DF2B1DD4BECD96649A5683C61")
    public final void smoothScrollTo(int x, int y) {
        addTaint(y);
        addTaint(x);
        smoothScrollBy(x - mScrollX, y - mScrollY);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.828 -0400", hash_original_method = "344907C67A02819CC7A230367AD45761", hash_generated_method = "979BDF0F1B1E5D69629FAC1B77886758")
    @Override
    protected int computeHorizontalScrollRange() {
        final int count = getChildCount();
        final int contentWidth = getWidth() - mPaddingLeft - mPaddingRight;
    if(count == 0)        
        {
            int var1BF07926F6538F21E562505C076C042A_24838100 = (contentWidth);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1816251308 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1816251308;
        } 
        int scrollRange = getChildAt(0).getRight();
        final int scrollX = mScrollX;
        final int overscrollRight = Math.max(0, scrollRange - contentWidth);
    if(scrollX < 0)        
        {
            scrollRange -= scrollX;
        } 
        else
    if(scrollX > overscrollRight)        
        {
            scrollRange += scrollX - overscrollRight;
        } 
        int var94D4A3ECD79FF3E17EB5BD0659AF9AAE_972716760 = (scrollRange);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1992104576 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1992104576;
        
        
        
        
            
        
        
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.829 -0400", hash_original_method = "9CF354C1D07DBC59A9E2E44E57F7657B", hash_generated_method = "31DD04ACB0C42180040CAA87171CBEB5")
    @Override
    protected int computeHorizontalScrollOffset() {
        int varF6857976BB9B7C6ED56FF74099CDBEBC_370460573 = (Math.max(0, super.computeHorizontalScrollOffset()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1739228466 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1739228466;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.830 -0400", hash_original_method = "1A4819189D92B65ABF3F692114902ED1", hash_generated_method = "D1D35D018153C7C1449F7EA0245290A7")
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
        
        
        
        
        
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.830 -0400", hash_original_method = "0EA8DFEAF2643806863B304E52EE38A5", hash_generated_method = "50971521E32DF7E3193DEA122D9D2652")
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
        
        
        
                
                        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.831 -0400", hash_original_method = "D30258BCA66C5E19407EB248DA88CE03", hash_generated_method = "3F16AA7BE934B5D63EE12A0D7542579E")
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
                    } 
                    else
    if(x > range && oldX <= range)                    
                    {
                        mEdgeGlowRight.onAbsorb((int) mScroller.getCurrVelocity());
                    } 
                } 
            } 
            awakenScrollBars();
            postInvalidate();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.832 -0400", hash_original_method = "988A7EC33B56EE551974E7C841966101", hash_generated_method = "DAB03F10A57CC9C2AB456DEEDA3A40B2")
    private void scrollToChild(View child) {
        addTaint(child.getTaint());
        child.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(child, mTempRect);
        int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
    if(scrollDelta != 0)        
        {
            scrollBy(scrollDelta, 0);
        } 
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.832 -0400", hash_original_method = "07633DDCD66F05F9C6104D95040C4376", hash_generated_method = "A8FBD5CC0ECD7C3683A147753744BC32")
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
            } 
            else
            {
                smoothScrollBy(delta, 0);
            } 
        } 
        boolean var089B0CDD8835D09CB1CABF38B3CE9C09_81787024 = (scroll);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1579282022 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1579282022;
        
        
        
        
            
                
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.834 -0400", hash_original_method = "8C5AA93676CE0EF7515972F93F61C0B6", hash_generated_method = "A7E1AF12630D1128B9D8254A23A07C61")
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        addTaint(rect.getTaint());
    if(getChildCount() == 0)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_1947892026 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_808204570 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_808204570;
        }
        int width = getWidth();
        int screenLeft = getScrollX();
        int screenRight = screenLeft + width;
        int fadingEdge = getHorizontalFadingEdgeLength();
    if(rect.left > 0)        
        {
            screenLeft += fadingEdge;
        } 
    if(rect.right < getChildAt(0).getWidth())        
        {
            screenRight -= fadingEdge;
        } 
        int scrollXDelta = 0;
    if(rect.right > screenRight && rect.left > screenLeft)        
        {
    if(rect.width() > width)            
            {
                scrollXDelta += (rect.left - screenLeft);
            } 
            else
            {
                scrollXDelta += (rect.right - screenRight);
            } 
            int right = getChildAt(0).getRight();
            int distanceToRight = right - screenRight;
            scrollXDelta = Math.min(scrollXDelta, distanceToRight);
        } 
        else
    if(rect.left < screenLeft && rect.right < screenRight)        
        {
    if(rect.width() > width)            
            {
                scrollXDelta -= (screenRight - rect.right);
            } 
            else
            {
                scrollXDelta -= (screenLeft - rect.left);
            } 
            scrollXDelta = Math.max(scrollXDelta, -getScrollX());
        } 
        int varB9383B9729AD21AB9895DA2CB9F10123_1671029030 = (scrollXDelta);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1654234363 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1654234363;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.835 -0400", hash_original_method = "C2C4A47D49BA76A3A98712461E581564", hash_generated_method = "13A992C0A02A86749A86E776DD1237E5")
    @Override
    public void requestChildFocus(View child, View focused) {
        addTaint(child.getTaint());
    if(!mIsLayoutDirty)        
        {
            scrollToChild(focused);
        } 
        else
        {
            mChildToScrollTo = focused;
        } 
        super.requestChildFocus(child, focused);
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.836 -0400", hash_original_method = "4857D3DE9468292A125F69FE9ECFC007", hash_generated_method = "EBCE34BCBB3ABAD35A550FAA2D5BDBE8")
    @Override
    protected boolean onRequestFocusInDescendants(int direction,
            Rect previouslyFocusedRect) {
        
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
    if(direction == View.FOCUS_FORWARD)        
        {
            direction = View.FOCUS_RIGHT;
        } 
        else
    if(direction == View.FOCUS_BACKWARD)        
        {
            direction = View.FOCUS_LEFT;
        } 
        final View nextFocus = previouslyFocusedRect == null ?
                FocusFinder.getInstance().findNextFocus(this, null, direction) :
                FocusFinder.getInstance().findNextFocusFromRect(this,
                        previouslyFocusedRect, direction);
    if(nextFocus == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_871716172 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1805556464 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1805556464;
        } 
    if(isOffScreen(nextFocus))        
        {
            boolean var68934A3E9455FA72420237EB05902327_101592858 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_919632376 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_919632376;
        } 
        boolean var19AC7E01A4DA8FE4B22BFDF34DB33D51_1444844362 = (nextFocus.requestFocus(direction, previouslyFocusedRect));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_763426096 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_763426096;
        
        
            
        
            
        
        
                
                
                        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.838 -0400", hash_original_method = "50E2DA7CF8E403536932E3B77491E964", hash_generated_method = "B64BB1C6BADCFCB3A9F34029A01D7F71")
    @Override
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle,
            boolean immediate) {
        addTaint(immediate);
        addTaint(rectangle.getTaint());
        addTaint(child.getTaint());
        rectangle.offset(child.getLeft() - child.getScrollX(),
                child.getTop() - child.getScrollY());
        boolean var10C2B91B22AF1483455A09D794128372_1179355264 = (scrollToChildRect(rectangle, immediate));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_786200227 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_786200227;
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.839 -0400", hash_original_method = "31751D7E496E2D7BD9B4D4E94AD28515", hash_generated_method = "11A20A1DA3E3F0E4689DA3F629925C7D")
    @Override
    public void requestLayout() {
        mIsLayoutDirty = true;
        super.requestLayout();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.841 -0400", hash_original_method = "51521A672083F0AD2F639BD854AB8D0F", hash_generated_method = "0FF04B3425BEE3DDBF54B80FEC67BB3C")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        
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
        } 
        mChildToScrollTo = null;
        scrollTo(mScrollX, mScrollY);
        
        
        
        
                
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.842 -0400", hash_original_method = "BFC9FDBBB166F0ED568B66B969E998B2", hash_generated_method = "3093074D38714A9B789A0142846514D0")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        
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
        } 
        
        
        
        
            
        
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.843 -0400", hash_original_method = "25276A1ACE97D138BB17C9052B223D37", hash_generated_method = "4F0EBFE8011CE31C8459C1B2B93F8854")
    private boolean isViewDescendantOf(View child, View parent) {
        addTaint(parent.getTaint());
        addTaint(child.getTaint());
    if(child == parent)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1527304343 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1635893257 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1635893257;
        } 
        final ViewParent theParent = child.getParent();
        boolean var6F793E02A243A0ADE05122683367FBA6_2107444871 = ((theParent instanceof ViewGroup) && isViewDescendantOf((View) theParent, parent));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_493899833 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_493899833;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.846 -0400", hash_original_method = "C5A2747735A9CF7D4575D6EE52958D1F", hash_generated_method = "6EA483B0C83FAE1542BDD434B2C6823D")
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
            } 
    if(newFocused != currentFocused)            
            {
                newFocused.requestFocus(movingRight ? View.FOCUS_RIGHT : View.FOCUS_LEFT);
            } 
            invalidate();
        } 
        
        
            
            
            
                    
            
            
            
                    
            
                
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.847 -0400", hash_original_method = "748C5914370A5F8CDD8109B6F4611B5B", hash_generated_method = "0D6230820B8CF3ACD12B82804532AC3B")
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
            } 
        } 
        
        
            
            
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.849 -0400", hash_original_method = "7D7EAD2993C7155FA8CA9421487AA499", hash_generated_method = "A84AB4D0361241C075B5DB472743EA77")
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
            } 
        } 
        else
        {
            mEdgeGlowLeft = null;
            mEdgeGlowRight = null;
        } 
        super.setOverScrollMode(mode);
        
        
            
                
                
                
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.850 -0400", hash_original_method = "63AFEEC895B9671DC479FE83536227D7", hash_generated_method = "A253D366287C363C3A0AC14050D804D8")
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
                } 
                canvas.restoreToCount(restoreCount);
            } 
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
                } 
                canvas.restoreToCount(restoreCount);
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.851 -0400", hash_original_method = "10E81B579101690AB90AC933866D5438", hash_generated_method = "779CDDA0FB663C5F8959C95C9BC64016")
    private int clamp(int n, int my, int child) {
        addTaint(child);
        addTaint(my);
        addTaint(n);
    if(my >= child || n < 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1322790598 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_891445347 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_891445347;
        } 
    if((my + n) > child)        
        {
            int var302FB6F2915B3D0C2F6551AE59DAFA4C_1469021081 = (child - my);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_538259986 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_538259986;
        } 
        int var7B8B965AD4BCA0E41AB51DE7B31363A1_1472891579 = (n);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1876339933 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1876339933;
        
        
            
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.851 -0400", hash_original_field = "592B4C751C2D22CD7D43317BD897714A", hash_generated_field = "4083FF51B3491C57DFF4E035C0066C80")

    private static final int ANIMATED_SCROLL_GAP = ScrollView.ANIMATED_SCROLL_GAP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.851 -0400", hash_original_field = "CA227357940761AB7254479B7BD99962", hash_generated_field = "49356EE5727E8BD04682A1AF4FB39A2B")

    private static final float MAX_SCROLL_FACTOR = ScrollView.MAX_SCROLL_FACTOR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.851 -0400", hash_original_field = "7EF8B2C57AC3A1D5EC1190F4098C6121", hash_generated_field = "E2DAEB44FC73F85759FCDB42BA10BD3A")

    private static final int INVALID_POINTER = -1;
}

