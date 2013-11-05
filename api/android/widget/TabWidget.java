package android.widget;

// Droidsafe Imports
import droidsafe.annotations.*;
import com.android.internal.R;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.778 -0400", hash_original_field = "21A3E0CB5880A1F2D307EE18DDAF80B8", hash_generated_field = "817C5151F42461877F9DF1BDC22232EE")

    private OnTabSelectionChanged mSelectionChangedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.778 -0400", hash_original_field = "82CD4C9BDB9E84554D0EAFBEBE89E81D", hash_generated_field = "CB97DF12B34C53DB09531B52F0015D03")

    private int mSelectedTab = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.778 -0400", hash_original_field = "7414040144E61C5ACFFA8805AA32BCC0", hash_generated_field = "6FA03D36B57D33A357D77C40AACCF8AD")

    private Drawable mLeftStrip;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.778 -0400", hash_original_field = "6B647BF54D22031636EE398A84B953D2", hash_generated_field = "5FBA50C5F8C8013E29152B4F0AB76375")

    private Drawable mRightStrip;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.779 -0400", hash_original_field = "729AE58EA0F3F5F5DD9FDFDD66C719CB", hash_generated_field = "A9EA19E630FD2239CD23BC8D6D6761B9")

    private boolean mDrawBottomStrips = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.779 -0400", hash_original_field = "65F389F180BA15189FB715D69B7FE7D6", hash_generated_field = "CFD4F88030B09A358C5455C797984434")

    private boolean mStripMoved;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.779 -0400", hash_original_field = "6B97A3575489EA5B3E0E3FCBACC05EED", hash_generated_field = "FD1FEF375C4015D208B59BBFA039409F")

    private final Rect mBounds = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.779 -0400", hash_original_field = "A42644E6C7FA86BB03983ECDAE80805B", hash_generated_field = "732D997FD39411FF1FDEB12CCE765B40")

    private int mImposedTabsHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.779 -0400", hash_original_field = "AA94886A7AE8980D826262975EFC65D8", hash_generated_field = "9D9FC5CE98E4D043B266CFEAA1F5897C")

    private int[] mImposedTabWidths;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.779 -0400", hash_original_method = "BAD8053A139C3B2472C278F997D22869", hash_generated_method = "ED3CDDEC2D735285C869678FBFEB686D")
    public  TabWidget(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.780 -0400", hash_original_method = "09ECDBF0B3A18A9B29EEE79A768970FF", hash_generated_method = "867E705626E781EA01B2250C08DDE2D1")
    public  TabWidget(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.tabWidgetStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.780 -0400", hash_original_method = "5CD4B242048A54DEBDC5CA30A897F614", hash_generated_method = "2C074367B612805D13D4111362C052BC")
    public  TabWidget(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        final TypedArray a = context.obtainStyledAttributes(
                attrs, com.android.internal.R.styleable.TabWidget, defStyle, 0);
        setStripEnabled(a.getBoolean(R.styleable.TabWidget_tabStripEnabled, true));
        setLeftStripDrawable(a.getDrawable(R.styleable.TabWidget_tabStripLeft));
        setRightStripDrawable(a.getDrawable(R.styleable.TabWidget_tabStripRight));
        a.recycle();
        initTabWidget();
        // ---------- Original Method ----------
        //final TypedArray a = context.obtainStyledAttributes(
                //attrs, com.android.internal.R.styleable.TabWidget, defStyle, 0);
        //setStripEnabled(a.getBoolean(R.styleable.TabWidget_tabStripEnabled, true));
        //setLeftStripDrawable(a.getDrawable(R.styleable.TabWidget_tabStripLeft));
        //setRightStripDrawable(a.getDrawable(R.styleable.TabWidget_tabStripRight));
        //a.recycle();
        //initTabWidget();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.780 -0400", hash_original_method = "D47B983401A0131B570217343158B99A", hash_generated_method = "8F2226E3253CFE95C847F8BCE75ECD4E")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(oldh);
        addTaint(oldw);
        addTaint(h);
        addTaint(w);
        mStripMoved = true;
        super.onSizeChanged(w, h, oldw, oldh);
        // ---------- Original Method ----------
        //mStripMoved = true;
        //super.onSizeChanged(w, h, oldw, oldh);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.781 -0400", hash_original_method = "6DB375E1DD97C7DB4A0C01A394FBBB39", hash_generated_method = "E38356B8AC76610B2984D729D9EE4A41")
    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        addTaint(i);
        addTaint(childCount);
        if(mSelectedTab == -1)        
        {
            int var865C0C0B4AB0E063E5CAA3387C1A8741_160410516 = (i);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1468946825 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1468946825;
        } //End block
        else
        {
            if(i == childCount - 1)            
            {
                int var7AB2B74DF2A193B0C68E51A8508488A0_1082291662 = (mSelectedTab);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_556694195 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_556694195;
            } //End block
            else
            if(i >= mSelectedTab)            
            {
                int var11C19633C6D7B85EEC5EFAFDD655392D_308511430 = (i + 1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1598093174 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1598093174;
            } //End block
            else
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_1379111584 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1969122481 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1969122481;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mSelectedTab == -1) {
            //return i;
        //} else {
            //if (i == childCount - 1) {
                //return mSelectedTab;
            //} else if (i >= mSelectedTab) {
                //return i + 1;
            //} else {
                //return i;
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.782 -0400", hash_original_method = "5A72EB2BE089A5D99DEFC278831DF5C3", hash_generated_method = "215AAB95A8CEF3BDD9C66FBEE2ACF491")
    private void initTabWidget() {
        setChildrenDrawingOrderEnabled(true);
        final Context context = mContext;
        final Resources resources = context.getResources();
        if(context.getApplicationInfo().targetSdkVersion <= Build.VERSION_CODES.DONUT)        
        {
            if(mLeftStrip == null)            
            {
                mLeftStrip = resources.getDrawable(
                        com.android.internal.R.drawable.tab_bottom_left_v4);
            } //End block
            if(mRightStrip == null)            
            {
                mRightStrip = resources.getDrawable(
                        com.android.internal.R.drawable.tab_bottom_right_v4);
            } //End block
        } //End block
        else
        {
            if(mLeftStrip == null)            
            {
                mLeftStrip = resources.getDrawable(
                        com.android.internal.R.drawable.tab_bottom_left);
            } //End block
            if(mRightStrip == null)            
            {
                mRightStrip = resources.getDrawable(
                        com.android.internal.R.drawable.tab_bottom_right);
            } //End block
        } //End block
        setFocusable(true);
        setOnFocusChangeListener(this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.783 -0400", hash_original_method = "C935CB6AD095E3F37FD6E422C2C15A30", hash_generated_method = "0FF7047D18F78663FEE3749A4C7DEF02")
    @Override
     void measureChildBeforeLayout(View child, int childIndex,
            int widthMeasureSpec, int totalWidth,
            int heightMeasureSpec, int totalHeight) {
        addTaint(totalHeight);
        addTaint(heightMeasureSpec);
        addTaint(totalWidth);
        addTaint(widthMeasureSpec);
        addTaint(childIndex);
        addTaint(child.getTaint());
        if(!isMeasureWithLargestChildEnabled() && mImposedTabsHeight >= 0)        
        {
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(
                    totalWidth + mImposedTabWidths[childIndex], MeasureSpec.EXACTLY);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(mImposedTabsHeight,
                    MeasureSpec.EXACTLY);
        } //End block
        super.measureChildBeforeLayout(child, childIndex,
                widthMeasureSpec, totalWidth, heightMeasureSpec, totalHeight);
        // ---------- Original Method ----------
        //if (!isMeasureWithLargestChildEnabled() && mImposedTabsHeight >= 0) {
            //widthMeasureSpec = MeasureSpec.makeMeasureSpec(
                    //totalWidth + mImposedTabWidths[childIndex], MeasureSpec.EXACTLY);
            //heightMeasureSpec = MeasureSpec.makeMeasureSpec(mImposedTabsHeight,
                    //MeasureSpec.EXACTLY);
        //}
        //super.measureChildBeforeLayout(child, childIndex,
                //widthMeasureSpec, totalWidth, heightMeasureSpec, totalHeight);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.784 -0400", hash_original_method = "ED82522C2B0B64CD8D60C0C12518DCBA", hash_generated_method = "2D4F3289FF067F8A582597B0E2657C0D")
    @Override
     void measureHorizontal(int widthMeasureSpec, int heightMeasureSpec) {
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        if(MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.UNSPECIFIED)        
        {
            super.measureHorizontal(widthMeasureSpec, heightMeasureSpec);
            return;
        } //End block
        final int unspecifiedWidth = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        mImposedTabsHeight = -1;
        super.measureHorizontal(unspecifiedWidth, heightMeasureSpec);
        int extraWidth = getMeasuredWidth() - MeasureSpec.getSize(widthMeasureSpec);
        if(extraWidth > 0)        
        {
            final int count = getChildCount();
            int childCount = 0;
for(int i = 0;i < count;i++)
            {
                final View child = getChildAt(i);
                if(child.getVisibility() == GONE)                
                continue;
                childCount++;
            } //End block
            if(childCount > 0)            
            {
                if(mImposedTabWidths == null || mImposedTabWidths.length != count)                
                {
                    mImposedTabWidths = new int[count];
                } //End block
for(int i = 0;i < count;i++)
                {
                    final View child = getChildAt(i);
                    if(child.getVisibility() == GONE)                    
                    continue;
                    final int childWidth = child.getMeasuredWidth();
                    final int delta = extraWidth / childCount;
                    final int newWidth = Math.max(0, childWidth - delta);
                    mImposedTabWidths[i] = newWidth;
                    extraWidth -= childWidth - newWidth;
                    childCount--;
                    mImposedTabsHeight = Math.max(mImposedTabsHeight, child.getMeasuredHeight());
                } //End block
            } //End block
        } //End block
        super.measureHorizontal(widthMeasureSpec, heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.785 -0400", hash_original_method = "1AFF25E962A9B2EDADD57BD725ECCAB1", hash_generated_method = "892498F0F50DC5903C4A765680BD86C6")
    public View getChildTabViewAt(int index) {
        addTaint(index);
View varEB5FB2D1E3F8D0183D7A20330A95FD1E_851773809 =         getChildAt(index);
        varEB5FB2D1E3F8D0183D7A20330A95FD1E_851773809.addTaint(taint);
        return varEB5FB2D1E3F8D0183D7A20330A95FD1E_851773809;
        // ---------- Original Method ----------
        //return getChildAt(index);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.785 -0400", hash_original_method = "FE2CEC591CEC0077A02A9DEA200F51F9", hash_generated_method = "82E42D3550512E55DFC8E3A8A4788362")
    public int getTabCount() {
        int var9B10B38940134F290E8A5D1B402D3360_763332937 = (getChildCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1716146943 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1716146943;
        // ---------- Original Method ----------
        //return getChildCount();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.785 -0400", hash_original_method = "BE73B200AC63DD0552B4403EEF7DD937", hash_generated_method = "AB55E333D7CE34C9A0AE495EF381DDC0")
    @Override
    public void setDividerDrawable(Drawable drawable) {
        addTaint(drawable.getTaint());
        super.setDividerDrawable(drawable);
        // ---------- Original Method ----------
        //super.setDividerDrawable(drawable);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.786 -0400", hash_original_method = "3D37FAA6007791B5D3F4A4A58BCFDCCD", hash_generated_method = "F0DD6357C991D56322A7EC3D99E92F10")
    public void setDividerDrawable(int resId) {
        addTaint(resId);
        setDividerDrawable(getResources().getDrawable(resId));
        // ---------- Original Method ----------
        //setDividerDrawable(getResources().getDrawable(resId));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.786 -0400", hash_original_method = "EEC4B8C710672EE52FF5686EC61F15E6", hash_generated_method = "E6F6197D40EF2320A5C1658CF8CEADD2")
    public void setLeftStripDrawable(Drawable drawable) {
        mLeftStrip = drawable;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mLeftStrip = drawable;
        //requestLayout();
        //invalidate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.786 -0400", hash_original_method = "172131F6C0343EAF2930103340C29368", hash_generated_method = "C8FDE2DCC1226E7B55598B6C2BEF65C3")
    public void setLeftStripDrawable(int resId) {
        addTaint(resId);
        setLeftStripDrawable(getResources().getDrawable(resId));
        // ---------- Original Method ----------
        //setLeftStripDrawable(getResources().getDrawable(resId));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.787 -0400", hash_original_method = "F30794AD8B45F99F5EA4402BF1535928", hash_generated_method = "2C8EF36288888D586A6DD40D84E1EF3B")
    public void setRightStripDrawable(Drawable drawable) {
        mRightStrip = drawable;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mRightStrip = drawable;
        //requestLayout();
        //invalidate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.787 -0400", hash_original_method = "74C61065E01D6A0285B64085050AA388", hash_generated_method = "2E829DF4318A3F1A80621F87201E5803")
    public void setRightStripDrawable(int resId) {
        addTaint(resId);
        setRightStripDrawable(getResources().getDrawable(resId));
        // ---------- Original Method ----------
        //setRightStripDrawable(getResources().getDrawable(resId));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.788 -0400", hash_original_method = "7E210175CAACE05D561ED66C44B48699", hash_generated_method = "671695E1D5C7CCAAD77AD2F54ED2A777")
    public void setStripEnabled(boolean stripEnabled) {
        mDrawBottomStrips = stripEnabled;
        invalidate();
        // ---------- Original Method ----------
        //mDrawBottomStrips = stripEnabled;
        //invalidate();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.788 -0400", hash_original_method = "187389676AA1F9CD7B5348DE6F614EB0", hash_generated_method = "BF534E4D077D039FA9937E7DA4341617")
    public boolean isStripEnabled() {
        boolean var552556C0EC7ACE1827AD74246AF9A657_1109400477 = (mDrawBottomStrips);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_715629498 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_715629498;
        // ---------- Original Method ----------
        //return mDrawBottomStrips;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.788 -0400", hash_original_method = "0D5FB7B547C3DEFE9E09A5210890B615", hash_generated_method = "B4B333E85E20330D5C9C12C9B676622F")
    @Override
    public void childDrawableStateChanged(View child) {
        addTaint(child.getTaint());
        if(getTabCount() > 0 && child == getChildTabViewAt(mSelectedTab))        
        {
            invalidate();
        } //End block
        super.childDrawableStateChanged(child);
        // ---------- Original Method ----------
        //if (getTabCount() > 0 && child == getChildTabViewAt(mSelectedTab)) {
            //invalidate();
        //}
        //super.childDrawableStateChanged(child);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.789 -0400", hash_original_method = "9B055E7A37DD3E5EB33B478B68D4F173", hash_generated_method = "F6871FAF06F6902D5C47B79B74176933")
    @Override
    public void dispatchDraw(Canvas canvas) {
        addTaint(canvas.getTaint());
        super.dispatchDraw(canvas);
        if(getTabCount() == 0)        
        return;
        if(!mDrawBottomStrips)        
        {
            return;
        } //End block
        final View selectedChild = getChildTabViewAt(mSelectedTab);
        final Drawable leftStrip = mLeftStrip;
        final Drawable rightStrip = mRightStrip;
        leftStrip.setState(selectedChild.getDrawableState());
        rightStrip.setState(selectedChild.getDrawableState());
        if(mStripMoved)        
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
        } //End block
        leftStrip.draw(canvas);
        rightStrip.draw(canvas);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.790 -0400", hash_original_method = "FD8145AB0632DE8E66BE264294877C34", hash_generated_method = "D4D3DE8F40239BD1315E9486DF79EAA2")
    public void setCurrentTab(int index) {
        if(index < 0 || index >= getTabCount() || index == mSelectedTab)        
        {
            return;
        } //End block
        if(mSelectedTab != -1)        
        {
            getChildTabViewAt(mSelectedTab).setSelected(false);
        } //End block
        mSelectedTab = index;
        getChildTabViewAt(mSelectedTab).setSelected(true);
        mStripMoved = true;
        if(isShown())        
        {
            sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        } //End block
        // ---------- Original Method ----------
        //if (index < 0 || index >= getTabCount() || index == mSelectedTab) {
            //return;
        //}
        //if (mSelectedTab != -1) {
            //getChildTabViewAt(mSelectedTab).setSelected(false);
        //}
        //mSelectedTab = index;
        //getChildTabViewAt(mSelectedTab).setSelected(true);
        //mStripMoved = true;
        //if (isShown()) {
            //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.791 -0400", hash_original_method = "B9A90DC4D5316593C7C6FB4F4261561D", hash_generated_method = "8325A05F99474E843565CF2DAFACB217")
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        addTaint(event.getTaint());
        onPopulateAccessibilityEvent(event);
        if(mSelectedTab != -1)        
        {
            View tabView = getChildTabViewAt(mSelectedTab);
            if(tabView != null && tabView.getVisibility() == VISIBLE)            
            {
                boolean var4325B44A7852CB9C6B053CB6EDF92C60_1285524529 = (tabView.dispatchPopulateAccessibilityEvent(event));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_319231535 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_319231535;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_174779416 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_74617285 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_74617285;
        // ---------- Original Method ----------
        //onPopulateAccessibilityEvent(event);
        //if (mSelectedTab != -1) {
            //View tabView = getChildTabViewAt(mSelectedTab);
            //if (tabView != null && tabView.getVisibility() == VISIBLE) {
                //return tabView.dispatchPopulateAccessibilityEvent(event);
            //}
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.791 -0400", hash_original_method = "5B381D25FD53DF8B1C9131304346B258", hash_generated_method = "F7F86676E3B27D07BF33F02FB9B9E769")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        super.onInitializeAccessibilityEvent(event);
        event.setItemCount(getTabCount());
        event.setCurrentItemIndex(mSelectedTab);
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //event.setItemCount(getTabCount());
        //event.setCurrentItemIndex(mSelectedTab);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.792 -0400", hash_original_method = "599192C49E7FBE73C0448383135B98FF", hash_generated_method = "2869A38054E44A9DC32A9DBD759882B9")
    public void focusCurrentTab(int index) {
        addTaint(index);
        final int oldTab = mSelectedTab;
        setCurrentTab(index);
        if(oldTab != index)        
        {
            getChildTabViewAt(index).requestFocus();
        } //End block
        // ---------- Original Method ----------
        //final int oldTab = mSelectedTab;
        //setCurrentTab(index);
        //if (oldTab != index) {
            //getChildTabViewAt(index).requestFocus();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.792 -0400", hash_original_method = "B57ADC02C2264C78238655AF009610DC", hash_generated_method = "FF9A843B87A86CD150F1C7854E6BC638")
    @Override
    public void setEnabled(boolean enabled) {
        addTaint(enabled);
        super.setEnabled(enabled);
        final int count = getTabCount();
for(int i = 0;i < count;i++)
        {
            View child = getChildTabViewAt(i);
            child.setEnabled(enabled);
        } //End block
        // ---------- Original Method ----------
        //super.setEnabled(enabled);
        //final int count = getTabCount();
        //for (int i = 0; i < count; i++) {
            //View child = getChildTabViewAt(i);
            //child.setEnabled(enabled);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.793 -0400", hash_original_method = "D99503F0B5A4EFC29BAA1C76A3B67627", hash_generated_method = "C4B5637420F90D3C5F7684B2719A085C")
    @Override
    public void addView(View child) {
        addTaint(child.getTaint());
        if(child.getLayoutParams() == null)        
        {
            final LinearLayout.LayoutParams lp = new LayoutParams(
                    0,
                    ViewGroup.LayoutParams.MATCH_PARENT, 1.0f);
            lp.setMargins(0, 0, 0, 0);
            child.setLayoutParams(lp);
        } //End block
        child.setFocusable(true);
        child.setClickable(true);
        super.addView(child);
        child.setOnClickListener(new TabClickListener(getTabCount() - 1));
        child.setOnFocusChangeListener(this);
        // ---------- Original Method ----------
        //if (child.getLayoutParams() == null) {
            //final LinearLayout.LayoutParams lp = new LayoutParams(
                    //0,
                    //ViewGroup.LayoutParams.MATCH_PARENT, 1.0f);
            //lp.setMargins(0, 0, 0, 0);
            //child.setLayoutParams(lp);
        //}
        //child.setFocusable(true);
        //child.setClickable(true);
        //super.addView(child);
        //child.setOnClickListener(new TabClickListener(getTabCount() - 1));
        //child.setOnFocusChangeListener(this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.793 -0400", hash_original_method = "EB030694D0FDE69DF41070C45192BD7E", hash_generated_method = "297A4D82F2CE205DB55424A2277990E7")
    @Override
    public void removeAllViews() {
        super.removeAllViews();
        mSelectedTab = -1;
        // ---------- Original Method ----------
        //super.removeAllViews();
        //mSelectedTab = -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.793 -0400", hash_original_method = "8812800BD81149FA7672691DBEB9912B", hash_generated_method = "76FFAE725709ADABBBE2B5614A8605BC")
    @Override
    public void sendAccessibilityEventUnchecked(AccessibilityEvent event) {
        addTaint(event.getTaint());
        if(event.getEventType() == AccessibilityEvent.TYPE_VIEW_FOCUSED && isFocused())        
        {
            event.recycle();
            return;
        } //End block
        super.sendAccessibilityEventUnchecked(event);
        // ---------- Original Method ----------
        //if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_FOCUSED && isFocused()) {
            //event.recycle();
            //return;
        //}
        //super.sendAccessibilityEventUnchecked(event);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.794 -0400", hash_original_method = "417165650412A4BD506B46A43D5F7416", hash_generated_method = "7FB911669829C940F00979E3196D854C")
     void setTabSelectionListener(OnTabSelectionChanged listener) {
        mSelectionChangedListener = listener;
        // ---------- Original Method ----------
        //mSelectionChangedListener = listener;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.794 -0400", hash_original_method = "4E088FBB30D7470D105CC06A4CB02903", hash_generated_method = "750D1062EF6BF8F1209EF16538201C0E")
    public void onFocusChange(View v, boolean hasFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hasFocus);
        addTaint(v.getTaint());
        if(v == this && hasFocus && getTabCount() > 0)        
        {
            getChildTabViewAt(mSelectedTab).requestFocus();
            return;
        } //End block
        if(hasFocus)        
        {
            int i = 0;
            int numTabs = getTabCount();
            while
(i < numTabs)            
            {
                if(getChildTabViewAt(i) == v)                
                {
                    setCurrentTab(i);
                    mSelectionChangedListener.onTabSelectionChanged(i, false);
                    if(isShown())                    
                    {
                        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
                    } //End block
                    break;
                } //End block
                i++;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (v == this && hasFocus && getTabCount() > 0) {
            //getChildTabViewAt(mSelectedTab).requestFocus();
            //return;
        //}
        //if (hasFocus) {
            //int i = 0;
            //int numTabs = getTabCount();
            //while (i < numTabs) {
                //if (getChildTabViewAt(i) == v) {
                    //setCurrentTab(i);
                    //mSelectionChangedListener.onTabSelectionChanged(i, false);
                    //if (isShown()) {
                        //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
                    //}
                    //break;
                //}
                //i++;
            //}
        //}
    }

    
    private class TabClickListener implements OnClickListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.794 -0400", hash_original_field = "A390CB35B589718F8D23D7523634E78F", hash_generated_field = "CC51272D049B7B1F88C1AB320207675A")

        private int mTabIndex;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.795 -0400", hash_original_method = "D6AF06C429F8FB8C9AE0E71F34F47DE0", hash_generated_method = "1617D57AD98005A88EF56C0EA197663B")
        private  TabClickListener(int tabIndex) {
            mTabIndex = tabIndex;
            // ---------- Original Method ----------
            //mTabIndex = tabIndex;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.795 -0400", hash_original_method = "28066710625DA4D2083757F8679E5933", hash_generated_method = "30D97969D5BC4554E52315D2BB7FC89B")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(v.getTaint());
            mSelectionChangedListener.onTabSelectionChanged(mTabIndex, true);
            // ---------- Original Method ----------
            //mSelectionChangedListener.onTabSelectionChanged(mTabIndex, true);
        }

        
    }


    
    static interface OnTabSelectionChanged {
        
        void onTabSelectionChanged(int tabIndex, boolean clicked);
    }
    
}

