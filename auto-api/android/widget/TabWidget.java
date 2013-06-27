package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.032 -0400", hash_original_field = "21A3E0CB5880A1F2D307EE18DDAF80B8", hash_generated_field = "817C5151F42461877F9DF1BDC22232EE")

    private OnTabSelectionChanged mSelectionChangedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.032 -0400", hash_original_field = "82CD4C9BDB9E84554D0EAFBEBE89E81D", hash_generated_field = "CB97DF12B34C53DB09531B52F0015D03")

    private int mSelectedTab = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.032 -0400", hash_original_field = "7414040144E61C5ACFFA8805AA32BCC0", hash_generated_field = "6FA03D36B57D33A357D77C40AACCF8AD")

    private Drawable mLeftStrip;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.032 -0400", hash_original_field = "6B647BF54D22031636EE398A84B953D2", hash_generated_field = "5FBA50C5F8C8013E29152B4F0AB76375")

    private Drawable mRightStrip;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.032 -0400", hash_original_field = "729AE58EA0F3F5F5DD9FDFDD66C719CB", hash_generated_field = "A9EA19E630FD2239CD23BC8D6D6761B9")

    private boolean mDrawBottomStrips = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.032 -0400", hash_original_field = "65F389F180BA15189FB715D69B7FE7D6", hash_generated_field = "CFD4F88030B09A358C5455C797984434")

    private boolean mStripMoved;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.032 -0400", hash_original_field = "6B97A3575489EA5B3E0E3FCBACC05EED", hash_generated_field = "E67C945376AAE00DB9440E3399BD8397")

    private Rect mBounds = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.032 -0400", hash_original_field = "A42644E6C7FA86BB03983ECDAE80805B", hash_generated_field = "732D997FD39411FF1FDEB12CCE765B40")

    private int mImposedTabsHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.032 -0400", hash_original_field = "AA94886A7AE8980D826262975EFC65D8", hash_generated_field = "9D9FC5CE98E4D043B266CFEAA1F5897C")

    private int[] mImposedTabWidths;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.033 -0400", hash_original_method = "BAD8053A139C3B2472C278F997D22869", hash_generated_method = "ED3CDDEC2D735285C869678FBFEB686D")
    public  TabWidget(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.033 -0400", hash_original_method = "09ECDBF0B3A18A9B29EEE79A768970FF", hash_generated_method = "E85D9B5A40FA530ACBAED5B5A7DAD79F")
    public  TabWidget(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.tabWidgetStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.034 -0400", hash_original_method = "5CD4B242048A54DEBDC5CA30A897F614", hash_generated_method = "39FC2DA6884DD2B4F6F57064F14CEC26")
    public  TabWidget(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a;
        a = context.obtainStyledAttributes(
                attrs, com.android.internal.R.styleable.TabWidget, defStyle, 0);
        setStripEnabled(a.getBoolean(R.styleable.TabWidget_tabStripEnabled, true));
        setLeftStripDrawable(a.getDrawable(R.styleable.TabWidget_tabStripLeft));
        setRightStripDrawable(a.getDrawable(R.styleable.TabWidget_tabStripRight));
        a.recycle();
        initTabWidget();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
        //final TypedArray a = context.obtainStyledAttributes(
                //attrs, com.android.internal.R.styleable.TabWidget, defStyle, 0);
        //setStripEnabled(a.getBoolean(R.styleable.TabWidget_tabStripEnabled, true));
        //setLeftStripDrawable(a.getDrawable(R.styleable.TabWidget_tabStripLeft));
        //setRightStripDrawable(a.getDrawable(R.styleable.TabWidget_tabStripRight));
        //a.recycle();
        //initTabWidget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.034 -0400", hash_original_method = "D47B983401A0131B570217343158B99A", hash_generated_method = "869AFFB6915BA66FE884684A5AE16849")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mStripMoved = true;
        super.onSizeChanged(w, h, oldw, oldh);
        addTaint(w);
        addTaint(h);
        addTaint(oldw);
        addTaint(oldh);
        // ---------- Original Method ----------
        //mStripMoved = true;
        //super.onSizeChanged(w, h, oldw, oldh);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.034 -0400", hash_original_method = "6DB375E1DD97C7DB4A0C01A394FBBB39", hash_generated_method = "7A2F948B3797000C9A7EA644491C384B")
    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        addTaint(childCount);
        addTaint(i);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_886373613 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_886373613;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.043 -0400", hash_original_method = "5A72EB2BE089A5D99DEFC278831DF5C3", hash_generated_method = "889FB6FBF403F55A720E849A2E2C04FE")
    private void initTabWidget() {
        setChildrenDrawingOrderEnabled(true);
        Context context;
        context = mContext;
        Resources resources;
        resources = context.getResources();
        {
            boolean var5BB1B0FE608FE7C017A72D994ED9E6F5_1369143596 = (context.getApplicationInfo().targetSdkVersion <= Build.VERSION_CODES.DONUT);
            {
                {
                    mLeftStrip = resources.getDrawable(
                        com.android.internal.R.drawable.tab_bottom_left_v4);
                } //End block
                {
                    mRightStrip = resources.getDrawable(
                        com.android.internal.R.drawable.tab_bottom_right_v4);
                } //End block
            } //End block
            {
                {
                    mLeftStrip = resources.getDrawable(
                        com.android.internal.R.drawable.tab_bottom_left);
                } //End block
                {
                    mRightStrip = resources.getDrawable(
                        com.android.internal.R.drawable.tab_bottom_right);
                } //End block
            } //End block
        } //End collapsed parenthetic
        setFocusable(true);
        setOnFocusChangeListener(this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.053 -0400", hash_original_method = "C935CB6AD095E3F37FD6E422C2C15A30", hash_generated_method = "52B19EB38861394C4C546735AEC3F667")
    @Override
     void measureChildBeforeLayout(View child, int childIndex,
            int widthMeasureSpec, int totalWidth,
            int heightMeasureSpec, int totalHeight) {
        {
            boolean var0EAA5E29F19F7708A7D40088A7AC665C_544486078 = (!isMeasureWithLargestChildEnabled() && mImposedTabsHeight >= 0);
            {
                widthMeasureSpec = MeasureSpec.makeMeasureSpec(
                    totalWidth + mImposedTabWidths[childIndex], MeasureSpec.EXACTLY);
                heightMeasureSpec = MeasureSpec.makeMeasureSpec(mImposedTabsHeight,
                    MeasureSpec.EXACTLY);
            } //End block
        } //End collapsed parenthetic
        super.measureChildBeforeLayout(child, childIndex,
                widthMeasureSpec, totalWidth, heightMeasureSpec, totalHeight);
        addTaint(child.getTaint());
        addTaint(childIndex);
        addTaint(widthMeasureSpec);
        addTaint(totalWidth);
        addTaint(heightMeasureSpec);
        addTaint(totalHeight);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.058 -0400", hash_original_method = "ED82522C2B0B64CD8D60C0C12518DCBA", hash_generated_method = "DB1BAFE710BE09EB1B442B721CD35688")
    @Override
     void measureHorizontal(int widthMeasureSpec, int heightMeasureSpec) {
        {
            boolean var5CAE5F9877ED5656C3F20920168BB881_2027240920 = (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.UNSPECIFIED);
            {
                super.measureHorizontal(widthMeasureSpec, heightMeasureSpec);
            } //End block
        } //End collapsed parenthetic
        int unspecifiedWidth;
        unspecifiedWidth = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        mImposedTabsHeight = -1;
        super.measureHorizontal(unspecifiedWidth, heightMeasureSpec);
        int extraWidth;
        extraWidth = getMeasuredWidth() - MeasureSpec.getSize(widthMeasureSpec);
        {
            int count;
            count = getChildCount();
            int childCount;
            childCount = 0;
            {
                int i;
                i = 0;
                {
                    View child;
                    child = getChildAt(i);
                    {
                        boolean var24A8049355A2DBEE0F9FC0F85F3CAA64_105371129 = (child.getVisibility() == GONE);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                {
                    mImposedTabWidths = new int[count];
                } //End block
                {
                    int i;
                    i = 0;
                    {
                        View child;
                        child = getChildAt(i);
                        {
                            boolean var55D817FE805B54FA33E1164360CD374C_1360415953 = (child.getVisibility() == GONE);
                        } //End collapsed parenthetic
                        int childWidth;
                        childWidth = child.getMeasuredWidth();
                        int delta;
                        delta = extraWidth / childCount;
                        int newWidth;
                        newWidth = Math.max(0, childWidth - delta);
                        mImposedTabWidths[i] = newWidth;
                        extraWidth -= childWidth - newWidth;
                        mImposedTabsHeight = Math.max(mImposedTabsHeight, child.getMeasuredHeight());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        super.measureHorizontal(widthMeasureSpec, heightMeasureSpec);
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.058 -0400", hash_original_method = "1AFF25E962A9B2EDADD57BD725ECCAB1", hash_generated_method = "370BEA5E3342E5312A3C2B2E18C54F4E")
    public View getChildTabViewAt(int index) {
        View varB4EAC82CA7396A68D541C85D26508E83_1126889932 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1126889932 = getChildAt(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1126889932.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1126889932;
        // ---------- Original Method ----------
        //return getChildAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.059 -0400", hash_original_method = "FE2CEC591CEC0077A02A9DEA200F51F9", hash_generated_method = "D97FCB791A9F61065D033D9BC125C7DD")
    public int getTabCount() {
        int varF41158137001188D2F9D08127BFB39DA_247272283 = (getChildCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1116058152 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1116058152;
        // ---------- Original Method ----------
        //return getChildCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.059 -0400", hash_original_method = "BE73B200AC63DD0552B4403EEF7DD937", hash_generated_method = "49B890DBADDEBA63B71DBB3903749284")
    @Override
    public void setDividerDrawable(Drawable drawable) {
        super.setDividerDrawable(drawable);
        addTaint(drawable.getTaint());
        // ---------- Original Method ----------
        //super.setDividerDrawable(drawable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.059 -0400", hash_original_method = "3D37FAA6007791B5D3F4A4A58BCFDCCD", hash_generated_method = "4A0387505C11A4BB3BB621A3F70EBD64")
    public void setDividerDrawable(int resId) {
        setDividerDrawable(getResources().getDrawable(resId));
        addTaint(resId);
        // ---------- Original Method ----------
        //setDividerDrawable(getResources().getDrawable(resId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.060 -0400", hash_original_method = "EEC4B8C710672EE52FF5686EC61F15E6", hash_generated_method = "E6F6197D40EF2320A5C1658CF8CEADD2")
    public void setLeftStripDrawable(Drawable drawable) {
        mLeftStrip = drawable;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mLeftStrip = drawable;
        //requestLayout();
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.076 -0400", hash_original_method = "172131F6C0343EAF2930103340C29368", hash_generated_method = "3EF36CE53175A58E3F897233D0CA8899")
    public void setLeftStripDrawable(int resId) {
        setLeftStripDrawable(getResources().getDrawable(resId));
        addTaint(resId);
        // ---------- Original Method ----------
        //setLeftStripDrawable(getResources().getDrawable(resId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.076 -0400", hash_original_method = "F30794AD8B45F99F5EA4402BF1535928", hash_generated_method = "2C8EF36288888D586A6DD40D84E1EF3B")
    public void setRightStripDrawable(Drawable drawable) {
        mRightStrip = drawable;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mRightStrip = drawable;
        //requestLayout();
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.076 -0400", hash_original_method = "74C61065E01D6A0285B64085050AA388", hash_generated_method = "365167B32B43D7207641AAB41DB5EBE2")
    public void setRightStripDrawable(int resId) {
        setRightStripDrawable(getResources().getDrawable(resId));
        addTaint(resId);
        // ---------- Original Method ----------
        //setRightStripDrawable(getResources().getDrawable(resId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.077 -0400", hash_original_method = "7E210175CAACE05D561ED66C44B48699", hash_generated_method = "671695E1D5C7CCAAD77AD2F54ED2A777")
    public void setStripEnabled(boolean stripEnabled) {
        mDrawBottomStrips = stripEnabled;
        invalidate();
        // ---------- Original Method ----------
        //mDrawBottomStrips = stripEnabled;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.077 -0400", hash_original_method = "187389676AA1F9CD7B5348DE6F614EB0", hash_generated_method = "AFB0823E26CBC5BB852223C1D5F2D28C")
    public boolean isStripEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_16168372 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_16168372;
        // ---------- Original Method ----------
        //return mDrawBottomStrips;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.077 -0400", hash_original_method = "0D5FB7B547C3DEFE9E09A5210890B615", hash_generated_method = "E6A5EE53E301AD401F6A15908A521619")
    @Override
    public void childDrawableStateChanged(View child) {
        {
            boolean var2D48845F7D54D29FF328FFB16591607D_977608508 = (getTabCount() > 0 && child == getChildTabViewAt(mSelectedTab));
            {
                invalidate();
            } //End block
        } //End collapsed parenthetic
        super.childDrawableStateChanged(child);
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //if (getTabCount() > 0 && child == getChildTabViewAt(mSelectedTab)) {
            //invalidate();
        //}
        //super.childDrawableStateChanged(child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.078 -0400", hash_original_method = "9B055E7A37DD3E5EB33B478B68D4F173", hash_generated_method = "08378699EDCD3BF31A058F353E3DCC2C")
    @Override
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        {
            boolean varFD58257A0945587E55B4821CDAC2ED0B_932593466 = (getTabCount() == 0);
        } //End collapsed parenthetic
        View selectedChild;
        selectedChild = getChildTabViewAt(mSelectedTab);
        Drawable leftStrip;
        leftStrip = mLeftStrip;
        Drawable rightStrip;
        rightStrip = mRightStrip;
        leftStrip.setState(selectedChild.getDrawableState());
        rightStrip.setState(selectedChild.getDrawableState());
        {
            Rect bounds;
            bounds = mBounds;
            bounds.left = selectedChild.getLeft();
            bounds.right = selectedChild.getRight();
            int myHeight;
            myHeight = getHeight();
            leftStrip.setBounds(Math.min(0, bounds.left - leftStrip.getIntrinsicWidth()),
                    myHeight - leftStrip.getIntrinsicHeight(), bounds.left, myHeight);
            rightStrip.setBounds(bounds.right, myHeight - rightStrip.getIntrinsicHeight(),
                    Math.max(getWidth(), bounds.right + rightStrip.getIntrinsicWidth()), myHeight);
            mStripMoved = false;
        } //End block
        leftStrip.draw(canvas);
        rightStrip.draw(canvas);
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.079 -0400", hash_original_method = "FD8145AB0632DE8E66BE264294877C34", hash_generated_method = "8EC79593A650DE8FD0C526E74B1A388B")
    public void setCurrentTab(int index) {
        {
            boolean var823B8B2F2E7A44402B3B7809262C425F_446139319 = (index < 0 || index >= getTabCount() || index == mSelectedTab);
        } //End collapsed parenthetic
        {
            getChildTabViewAt(mSelectedTab).setSelected(false);
        } //End block
        mSelectedTab = index;
        getChildTabViewAt(mSelectedTab).setSelected(true);
        mStripMoved = true;
        {
            boolean var3CDBC35A1363DD4CC94823B3022E2382_1348878719 = (isShown());
            {
                sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.079 -0400", hash_original_method = "B9A90DC4D5316593C7C6FB4F4261561D", hash_generated_method = "FDE72CB2E5849480931A8B6D6BA3BD81")
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        onPopulateAccessibilityEvent(event);
        {
            View tabView;
            tabView = getChildTabViewAt(mSelectedTab);
            {
                boolean varF8ADDD16479D1140F075D1A2ABA8BDEC_1188482194 = (tabView != null && tabView.getVisibility() == VISIBLE);
                {
                    boolean var573E1FBB9CBC4DC7839CA0F5758022DC_296099383 = (tabView.dispatchPopulateAccessibilityEvent(event));
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1095034362 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1095034362;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.080 -0400", hash_original_method = "5B381D25FD53DF8B1C9131304346B258", hash_generated_method = "8FF9A7CF77463D1D70FCE6FEB3C6C978")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onInitializeAccessibilityEvent(event);
        event.setItemCount(getTabCount());
        event.setCurrentItemIndex(mSelectedTab);
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //event.setItemCount(getTabCount());
        //event.setCurrentItemIndex(mSelectedTab);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.080 -0400", hash_original_method = "599192C49E7FBE73C0448383135B98FF", hash_generated_method = "DEC0FE88C6C25D74C8F6B9F816B2AEAE")
    public void focusCurrentTab(int index) {
        int oldTab;
        oldTab = mSelectedTab;
        setCurrentTab(index);
        {
            getChildTabViewAt(index).requestFocus();
        } //End block
        addTaint(index);
        // ---------- Original Method ----------
        //final int oldTab = mSelectedTab;
        //setCurrentTab(index);
        //if (oldTab != index) {
            //getChildTabViewAt(index).requestFocus();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.080 -0400", hash_original_method = "B57ADC02C2264C78238655AF009610DC", hash_generated_method = "D162A306E7FFFB3BCFF6D20A98C385BC")
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        int count;
        count = getTabCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildTabViewAt(i);
                child.setEnabled(enabled);
            } //End block
        } //End collapsed parenthetic
        addTaint(enabled);
        // ---------- Original Method ----------
        //super.setEnabled(enabled);
        //final int count = getTabCount();
        //for (int i = 0; i < count; i++) {
            //View child = getChildTabViewAt(i);
            //child.setEnabled(enabled);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.081 -0400", hash_original_method = "D99503F0B5A4EFC29BAA1C76A3B67627", hash_generated_method = "8EAA3D8BFC46A80506C32321B18ECB24")
    @Override
    public void addView(View child) {
        {
            boolean varF70F3F387639715ADCB3E64EC88C0ABA_1695003576 = (child.getLayoutParams() == null);
            {
                LinearLayout.LayoutParams lp;
                lp = new LayoutParams(
                    0,
                    ViewGroup.LayoutParams.MATCH_PARENT, 1.0f);
                lp.setMargins(0, 0, 0, 0);
                child.setLayoutParams(lp);
            } //End block
        } //End collapsed parenthetic
        child.setFocusable(true);
        child.setClickable(true);
        super.addView(child);
        child.setOnClickListener(new TabClickListener(getTabCount() - 1));
        child.setOnFocusChangeListener(this);
        addTaint(child.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.081 -0400", hash_original_method = "EB030694D0FDE69DF41070C45192BD7E", hash_generated_method = "297A4D82F2CE205DB55424A2277990E7")
    @Override
    public void removeAllViews() {
        super.removeAllViews();
        mSelectedTab = -1;
        // ---------- Original Method ----------
        //super.removeAllViews();
        //mSelectedTab = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.081 -0400", hash_original_method = "8812800BD81149FA7672691DBEB9912B", hash_generated_method = "3C89B3AD5EBE4EB511F374889D6E3E75")
    @Override
    public void sendAccessibilityEventUnchecked(AccessibilityEvent event) {
        {
            boolean varC964DF90FFF64FC9765FBC79F8408C47_868637270 = (event.getEventType() == AccessibilityEvent.TYPE_VIEW_FOCUSED && isFocused());
            {
                event.recycle();
            } //End block
        } //End collapsed parenthetic
        super.sendAccessibilityEventUnchecked(event);
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_FOCUSED && isFocused()) {
            //event.recycle();
            //return;
        //}
        //super.sendAccessibilityEventUnchecked(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.082 -0400", hash_original_method = "417165650412A4BD506B46A43D5F7416", hash_generated_method = "7FB911669829C940F00979E3196D854C")
     void setTabSelectionListener(OnTabSelectionChanged listener) {
        mSelectionChangedListener = listener;
        // ---------- Original Method ----------
        //mSelectionChangedListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.082 -0400", hash_original_method = "4E088FBB30D7470D105CC06A4CB02903", hash_generated_method = "180208A07F7D12DF296D8A44E5A91110")
    public void onFocusChange(View v, boolean hasFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varED3E4F26678B4882A3C43AC2EF8A5518_1216838331 = (v == this && hasFocus && getTabCount() > 0);
            {
                getChildTabViewAt(mSelectedTab).requestFocus();
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
            int numTabs;
            numTabs = getTabCount();
            {
                {
                    boolean var4EDB3FF095146FE634B10FB1CF88A91B_755089494 = (getChildTabViewAt(i) == v);
                    {
                        setCurrentTab(i);
                        mSelectionChangedListener.onTabSelectionChanged(i, false);
                        {
                            boolean var8017EA53E539E0A013DB107E4A4C16D8_1560277106 = (isShown());
                            {
                                sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(v.getTaint());
        addTaint(hasFocus);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.091 -0400", hash_original_field = "A390CB35B589718F8D23D7523634E78F", hash_generated_field = "CC51272D049B7B1F88C1AB320207675A")

        private int mTabIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.092 -0400", hash_original_method = "D6AF06C429F8FB8C9AE0E71F34F47DE0", hash_generated_method = "1617D57AD98005A88EF56C0EA197663B")
        private  TabClickListener(int tabIndex) {
            mTabIndex = tabIndex;
            // ---------- Original Method ----------
            //mTabIndex = tabIndex;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.096 -0400", hash_original_method = "28066710625DA4D2083757F8679E5933", hash_generated_method = "728F52A5D6FE5A633092EA8A0F46A0F6")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mSelectionChangedListener.onTabSelectionChanged(mTabIndex, true);
            addTaint(v.getTaint());
            // ---------- Original Method ----------
            //mSelectionChangedListener.onTabSelectionChanged(mTabIndex, true);
        }

        
    }


    
    static interface OnTabSelectionChanged {
        
        void onTabSelectionChanged(int tabIndex, boolean clicked);
    }
    
}

