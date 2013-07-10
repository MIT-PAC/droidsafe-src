package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class TabWidget extends LinearLayout implements OnFocusChangeListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.288 -0400", hash_original_field = "21A3E0CB5880A1F2D307EE18DDAF80B8", hash_generated_field = "817C5151F42461877F9DF1BDC22232EE")

    private OnTabSelectionChanged mSelectionChangedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.288 -0400", hash_original_field = "82CD4C9BDB9E84554D0EAFBEBE89E81D", hash_generated_field = "CB97DF12B34C53DB09531B52F0015D03")

    private int mSelectedTab = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.288 -0400", hash_original_field = "7414040144E61C5ACFFA8805AA32BCC0", hash_generated_field = "6FA03D36B57D33A357D77C40AACCF8AD")

    private Drawable mLeftStrip;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.288 -0400", hash_original_field = "6B647BF54D22031636EE398A84B953D2", hash_generated_field = "5FBA50C5F8C8013E29152B4F0AB76375")

    private Drawable mRightStrip;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.288 -0400", hash_original_field = "729AE58EA0F3F5F5DD9FDFDD66C719CB", hash_generated_field = "A9EA19E630FD2239CD23BC8D6D6761B9")

    private boolean mDrawBottomStrips = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.288 -0400", hash_original_field = "65F389F180BA15189FB715D69B7FE7D6", hash_generated_field = "CFD4F88030B09A358C5455C797984434")

    private boolean mStripMoved;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.288 -0400", hash_original_field = "6B97A3575489EA5B3E0E3FCBACC05EED", hash_generated_field = "FD1FEF375C4015D208B59BBFA039409F")

    private final Rect mBounds = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.288 -0400", hash_original_field = "A42644E6C7FA86BB03983ECDAE80805B", hash_generated_field = "732D997FD39411FF1FDEB12CCE765B40")

    private int mImposedTabsHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.288 -0400", hash_original_field = "AA94886A7AE8980D826262975EFC65D8", hash_generated_field = "9D9FC5CE98E4D043B266CFEAA1F5897C")

    private int[] mImposedTabWidths;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.288 -0400", hash_original_method = "BAD8053A139C3B2472C278F997D22869", hash_generated_method = "ED3CDDEC2D735285C869678FBFEB686D")
    public  TabWidget(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.289 -0400", hash_original_method = "09ECDBF0B3A18A9B29EEE79A768970FF", hash_generated_method = "E85D9B5A40FA530ACBAED5B5A7DAD79F")
    public  TabWidget(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.tabWidgetStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.289 -0400", hash_original_method = "5CD4B242048A54DEBDC5CA30A897F614", hash_generated_method = "6386E421C2C22D984DD806951248A25E")
    public  TabWidget(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        final TypedArray a = context.obtainStyledAttributes(
                attrs, com.android.internal.R.styleable.TabWidget, defStyle, 0);
        setStripEnabled(a.getBoolean(R.styleable.TabWidget_tabStripEnabled, true));
        setLeftStripDrawable(a.getDrawable(R.styleable.TabWidget_tabStripLeft));
        setRightStripDrawable(a.getDrawable(R.styleable.TabWidget_tabStripRight));
        a.recycle();
        initTabWidget();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
                
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.289 -0400", hash_original_method = "D47B983401A0131B570217343158B99A", hash_generated_method = "869AFFB6915BA66FE884684A5AE16849")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        
        mStripMoved = true;
        super.onSizeChanged(w, h, oldw, oldh);
        addTaint(w);
        addTaint(h);
        addTaint(oldw);
        addTaint(oldh);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.290 -0400", hash_original_method = "6DB375E1DD97C7DB4A0C01A394FBBB39", hash_generated_method = "FF257AD91896483577088FCAB7DA810C")
    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        addTaint(childCount);
        addTaint(i);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_702077731 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_702077731;
        
        
            
        
            
                
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.290 -0400", hash_original_method = "5A72EB2BE089A5D99DEFC278831DF5C3", hash_generated_method = "13244408F9D6D8BFAB5975FDFC247592")
    private void initTabWidget() {
        setChildrenDrawingOrderEnabled(true);
        final Context context = mContext;
        final Resources resources = context.getResources();
        {
            boolean var5BB1B0FE608FE7C017A72D994ED9E6F5_973318019 = (context.getApplicationInfo().targetSdkVersion <= Build.VERSION_CODES.DONUT);
            {
                {
                    mLeftStrip = resources.getDrawable(
                        com.android.internal.R.drawable.tab_bottom_left_v4);
                } 
                {
                    mRightStrip = resources.getDrawable(
                        com.android.internal.R.drawable.tab_bottom_right_v4);
                } 
            } 
            {
                {
                    mLeftStrip = resources.getDrawable(
                        com.android.internal.R.drawable.tab_bottom_left);
                } 
                {
                    mRightStrip = resources.getDrawable(
                        com.android.internal.R.drawable.tab_bottom_right);
                } 
            } 
        } 
        setFocusable(true);
        setOnFocusChangeListener(this);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.291 -0400", hash_original_method = "C935CB6AD095E3F37FD6E422C2C15A30", hash_generated_method = "34A513C8DD8B1C6EE6C0A88CA9711D82")
    @Override
     void measureChildBeforeLayout(View child, int childIndex,
            int widthMeasureSpec, int totalWidth,
            int heightMeasureSpec, int totalHeight) {
        {
            boolean var0EAA5E29F19F7708A7D40088A7AC665C_519340293 = (!isMeasureWithLargestChildEnabled() && mImposedTabsHeight >= 0);
            {
                widthMeasureSpec = MeasureSpec.makeMeasureSpec(
                    totalWidth + mImposedTabWidths[childIndex], MeasureSpec.EXACTLY);
                heightMeasureSpec = MeasureSpec.makeMeasureSpec(mImposedTabsHeight,
                    MeasureSpec.EXACTLY);
            } 
        } 
        super.measureChildBeforeLayout(child, childIndex,
                widthMeasureSpec, totalWidth, heightMeasureSpec, totalHeight);
        addTaint(child.getTaint());
        addTaint(childIndex);
        addTaint(widthMeasureSpec);
        addTaint(totalWidth);
        addTaint(heightMeasureSpec);
        addTaint(totalHeight);
        
        
            
                    
            
                    
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.292 -0400", hash_original_method = "ED82522C2B0B64CD8D60C0C12518DCBA", hash_generated_method = "A408BB143A3142C3659A558C5A907AC3")
    @Override
     void measureHorizontal(int widthMeasureSpec, int heightMeasureSpec) {
        {
            boolean var5CAE5F9877ED5656C3F20920168BB881_775793268 = (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.UNSPECIFIED);
            {
                super.measureHorizontal(widthMeasureSpec, heightMeasureSpec);
            } 
        } 
        final int unspecifiedWidth = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        mImposedTabsHeight = -1;
        super.measureHorizontal(unspecifiedWidth, heightMeasureSpec);
        int extraWidth = getMeasuredWidth() - MeasureSpec.getSize(widthMeasureSpec);
        {
            final int count = getChildCount();
            int childCount = 0;
            {
                int i = 0;
                {
                    final View child = getChildAt(i);
                    {
                        boolean var24A8049355A2DBEE0F9FC0F85F3CAA64_464824946 = (child.getVisibility() == GONE);
                    } 
                } 
            } 
            {
                {
                    mImposedTabWidths = new int[count];
                } 
                {
                    int i = 0;
                    {
                        final View child = getChildAt(i);
                        {
                            boolean var55D817FE805B54FA33E1164360CD374C_756119691 = (child.getVisibility() == GONE);
                        } 
                        final int childWidth = child.getMeasuredWidth();
                        final int delta = extraWidth / childCount;
                        final int newWidth = Math.max(0, childWidth - delta);
                        mImposedTabWidths[i] = newWidth;
                        extraWidth -= childWidth - newWidth;
                        mImposedTabsHeight = Math.max(mImposedTabsHeight, child.getMeasuredHeight());
                    } 
                } 
            } 
        } 
        super.measureHorizontal(widthMeasureSpec, heightMeasureSpec);
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.293 -0400", hash_original_method = "1AFF25E962A9B2EDADD57BD725ECCAB1", hash_generated_method = "729781A44080E4BFE63FE3B5B43F6184")
    public View getChildTabViewAt(int index) {
        View varB4EAC82CA7396A68D541C85D26508E83_1215456759 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1215456759 = getChildAt(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1215456759.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1215456759;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.293 -0400", hash_original_method = "FE2CEC591CEC0077A02A9DEA200F51F9", hash_generated_method = "2A32C1CBE00C15A4E960409546EED3FF")
    public int getTabCount() {
        int varF41158137001188D2F9D08127BFB39DA_1736337626 = (getChildCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_130445142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_130445142;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.293 -0400", hash_original_method = "BE73B200AC63DD0552B4403EEF7DD937", hash_generated_method = "49B890DBADDEBA63B71DBB3903749284")
    @Override
    public void setDividerDrawable(Drawable drawable) {
        super.setDividerDrawable(drawable);
        addTaint(drawable.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.293 -0400", hash_original_method = "3D37FAA6007791B5D3F4A4A58BCFDCCD", hash_generated_method = "4A0387505C11A4BB3BB621A3F70EBD64")
    public void setDividerDrawable(int resId) {
        setDividerDrawable(getResources().getDrawable(resId));
        addTaint(resId);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.294 -0400", hash_original_method = "EEC4B8C710672EE52FF5686EC61F15E6", hash_generated_method = "E6F6197D40EF2320A5C1658CF8CEADD2")
    public void setLeftStripDrawable(Drawable drawable) {
        mLeftStrip = drawable;
        requestLayout();
        invalidate();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.294 -0400", hash_original_method = "172131F6C0343EAF2930103340C29368", hash_generated_method = "3EF36CE53175A58E3F897233D0CA8899")
    public void setLeftStripDrawable(int resId) {
        setLeftStripDrawable(getResources().getDrawable(resId));
        addTaint(resId);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.294 -0400", hash_original_method = "F30794AD8B45F99F5EA4402BF1535928", hash_generated_method = "2C8EF36288888D586A6DD40D84E1EF3B")
    public void setRightStripDrawable(Drawable drawable) {
        mRightStrip = drawable;
        requestLayout();
        invalidate();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.294 -0400", hash_original_method = "74C61065E01D6A0285B64085050AA388", hash_generated_method = "365167B32B43D7207641AAB41DB5EBE2")
    public void setRightStripDrawable(int resId) {
        setRightStripDrawable(getResources().getDrawable(resId));
        addTaint(resId);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.295 -0400", hash_original_method = "7E210175CAACE05D561ED66C44B48699", hash_generated_method = "671695E1D5C7CCAAD77AD2F54ED2A777")
    public void setStripEnabled(boolean stripEnabled) {
        mDrawBottomStrips = stripEnabled;
        invalidate();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.295 -0400", hash_original_method = "187389676AA1F9CD7B5348DE6F614EB0", hash_generated_method = "97F4CA1A312268F926FB51F7AC8A09E0")
    public boolean isStripEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_229010105 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_229010105;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.295 -0400", hash_original_method = "0D5FB7B547C3DEFE9E09A5210890B615", hash_generated_method = "4CD4C8D56F76EE0F32C72E0DB242E2A7")
    @Override
    public void childDrawableStateChanged(View child) {
        {
            boolean var2D48845F7D54D29FF328FFB16591607D_826398746 = (getTabCount() > 0 && child == getChildTabViewAt(mSelectedTab));
            {
                invalidate();
            } 
        } 
        super.childDrawableStateChanged(child);
        addTaint(child.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.296 -0400", hash_original_method = "9B055E7A37DD3E5EB33B478B68D4F173", hash_generated_method = "6EDC5382A25FE33FBAEDD291BE25CFDA")
    @Override
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        {
            boolean varFD58257A0945587E55B4821CDAC2ED0B_1931576346 = (getTabCount() == 0);
        } 
        final View selectedChild = getChildTabViewAt(mSelectedTab);
        final Drawable leftStrip = mLeftStrip;
        final Drawable rightStrip = mRightStrip;
        leftStrip.setState(selectedChild.getDrawableState());
        rightStrip.setState(selectedChild.getDrawableState());
        {
            final Rect bounds = mBounds;
            bounds.left = selectedChild.getLeft();
            bounds.right = selectedChild.getRight();
            final int myHeight = getHeight();
            leftStrip.setBounds(Math.min(0, bounds.left - leftStrip.getIntrinsicWidth()),
                    myHeight - leftStrip.getIntrinsicHeight(), bounds.left, myHeight);
            rightStrip.setBounds(bounds.right, myHeight - rightStrip.getIntrinsicHeight(),
                    Math.max(getWidth(), bounds.right + rightStrip.getIntrinsicWidth()), myHeight);
            mStripMoved = false;
        } 
        leftStrip.draw(canvas);
        rightStrip.draw(canvas);
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.296 -0400", hash_original_method = "FD8145AB0632DE8E66BE264294877C34", hash_generated_method = "1445C077BBAFA9E86B4B70DC358F8898")
    public void setCurrentTab(int index) {
        {
            boolean var823B8B2F2E7A44402B3B7809262C425F_2093833838 = (index < 0 || index >= getTabCount() || index == mSelectedTab);
        } 
        {
            getChildTabViewAt(mSelectedTab).setSelected(false);
        } 
        mSelectedTab = index;
        getChildTabViewAt(mSelectedTab).setSelected(true);
        mStripMoved = true;
        {
            boolean var3CDBC35A1363DD4CC94823B3022E2382_1939901555 = (isShown());
            {
                sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
            } 
        } 
        
        
            
        
        
            
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.296 -0400", hash_original_method = "B9A90DC4D5316593C7C6FB4F4261561D", hash_generated_method = "B5BB744C2B69DFEFF4E41844D4AA3340")
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        onPopulateAccessibilityEvent(event);
        {
            View tabView = getChildTabViewAt(mSelectedTab);
            {
                boolean varF8ADDD16479D1140F075D1A2ABA8BDEC_740198616 = (tabView != null && tabView.getVisibility() == VISIBLE);
                {
                    boolean var573E1FBB9CBC4DC7839CA0F5758022DC_527070212 = (tabView.dispatchPopulateAccessibilityEvent(event));
                } 
            } 
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1436529084 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1436529084;
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.297 -0400", hash_original_method = "5B381D25FD53DF8B1C9131304346B258", hash_generated_method = "8FF9A7CF77463D1D70FCE6FEB3C6C978")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        
        super.onInitializeAccessibilityEvent(event);
        event.setItemCount(getTabCount());
        event.setCurrentItemIndex(mSelectedTab);
        addTaint(event.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.297 -0400", hash_original_method = "599192C49E7FBE73C0448383135B98FF", hash_generated_method = "157E0991CECB337048BF38A47C84878F")
    public void focusCurrentTab(int index) {
        final int oldTab = mSelectedTab;
        setCurrentTab(index);
        {
            getChildTabViewAt(index).requestFocus();
        } 
        addTaint(index);
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.297 -0400", hash_original_method = "B57ADC02C2264C78238655AF009610DC", hash_generated_method = "580B757008C1B4F0FB66DC2686A17410")
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        final int count = getTabCount();
        {
            int i = 0;
            {
                View child = getChildTabViewAt(i);
                child.setEnabled(enabled);
            } 
        } 
        addTaint(enabled);
        
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.298 -0400", hash_original_method = "D99503F0B5A4EFC29BAA1C76A3B67627", hash_generated_method = "2DA72A38789038163CAFEEF1D4668476")
    @Override
    public void addView(View child) {
        {
            boolean varF70F3F387639715ADCB3E64EC88C0ABA_1430989910 = (child.getLayoutParams() == null);
            {
                final LinearLayout.LayoutParams lp = new LayoutParams(
                    0,
                    ViewGroup.LayoutParams.MATCH_PARENT, 1.0f);
                lp.setMargins(0, 0, 0, 0);
                child.setLayoutParams(lp);
            } 
        } 
        child.setFocusable(true);
        child.setClickable(true);
        super.addView(child);
        child.setOnClickListener(new TabClickListener(getTabCount() - 1));
        child.setOnFocusChangeListener(this);
        addTaint(child.getTaint());
        
        
            
                    
                    
            
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.298 -0400", hash_original_method = "EB030694D0FDE69DF41070C45192BD7E", hash_generated_method = "297A4D82F2CE205DB55424A2277990E7")
    @Override
    public void removeAllViews() {
        super.removeAllViews();
        mSelectedTab = -1;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.298 -0400", hash_original_method = "8812800BD81149FA7672691DBEB9912B", hash_generated_method = "9AC00855E8AFA37C7937410D52039D53")
    @Override
    public void sendAccessibilityEventUnchecked(AccessibilityEvent event) {
        {
            boolean varC964DF90FFF64FC9765FBC79F8408C47_1401403281 = (event.getEventType() == AccessibilityEvent.TYPE_VIEW_FOCUSED && isFocused());
            {
                event.recycle();
            } 
        } 
        super.sendAccessibilityEventUnchecked(event);
        addTaint(event.getTaint());
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.299 -0400", hash_original_method = "417165650412A4BD506B46A43D5F7416", hash_generated_method = "7FB911669829C940F00979E3196D854C")
     void setTabSelectionListener(OnTabSelectionChanged listener) {
        mSelectionChangedListener = listener;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.299 -0400", hash_original_method = "4E088FBB30D7470D105CC06A4CB02903", hash_generated_method = "15A354CA911C445CB782106727B5C053")
    public void onFocusChange(View v, boolean hasFocus) {
        
        {
            boolean varED3E4F26678B4882A3C43AC2EF8A5518_1298348139 = (v == this && hasFocus && getTabCount() > 0);
            {
                getChildTabViewAt(mSelectedTab).requestFocus();
            } 
        } 
        {
            int i = 0;
            int numTabs = getTabCount();
            {
                {
                    boolean var4EDB3FF095146FE634B10FB1CF88A91B_1646797497 = (getChildTabViewAt(i) == v);
                    {
                        setCurrentTab(i);
                        mSelectionChangedListener.onTabSelectionChanged(i, false);
                        {
                            boolean var8017EA53E539E0A013DB107E4A4C16D8_858088520 = (isShown());
                            {
                                sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(v.getTaint());
        addTaint(hasFocus);
        
        
            
            
        
        
            
            
            
                
                    
                    
                    
                        
                    
                    
                
                
            
        
    }

    
    private class TabClickListener implements OnClickListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.299 -0400", hash_original_field = "A390CB35B589718F8D23D7523634E78F", hash_generated_field = "CC51272D049B7B1F88C1AB320207675A")

        private int mTabIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.299 -0400", hash_original_method = "D6AF06C429F8FB8C9AE0E71F34F47DE0", hash_generated_method = "1617D57AD98005A88EF56C0EA197663B")
        private  TabClickListener(int tabIndex) {
            mTabIndex = tabIndex;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.300 -0400", hash_original_method = "28066710625DA4D2083757F8679E5933", hash_generated_method = "728F52A5D6FE5A633092EA8A0F46A0F6")
        public void onClick(View v) {
            
            mSelectionChangedListener.onTabSelectionChanged(mTabIndex, true);
            addTaint(v.getTaint());
            
            
        }

        
    }


    
    static interface OnTabSelectionChanged {
        
        void onTabSelectionChanged(int tabIndex, boolean clicked);
    }
    
}

