package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.RemoteViews.RemoteView;

public class LinearLayout extends ViewGroup {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.123 -0400", hash_original_field = "C4AC870B117F9377D557E108C2F5864C", hash_generated_field = "49EF932FC6F54346B0D68DBE32BC1514")

    @ViewDebug.ExportedProperty(category = "layout") private boolean mBaselineAligned = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.123 -0400", hash_original_field = "C4FA8C15F1496E5D4914A441B3EF4877", hash_generated_field = "9479D6BEF70B8D911DE1D3E00E354445")

    @ViewDebug.ExportedProperty(category = "layout") private int mBaselineAlignedChildIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.123 -0400", hash_original_field = "74E8B6E6B0FDC4F4D8852726B0CC3BAD", hash_generated_field = "44D10AD5ECEE597BECDD4FB40534DC17")

    @ViewDebug.ExportedProperty(category = "measurement") private int mBaselineChildTop = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.123 -0400", hash_original_field = "7EA67827B94D10D1A4B368659EA63B71", hash_generated_field = "3C6DDBEC00F7F6467812B81CEA371C07")

    @ViewDebug.ExportedProperty(category = "measurement") private int mOrientation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.123 -0400", hash_original_field = "964B8A9513C01B9AF2664D1A54E32EEA", hash_generated_field = "EE266283EE900FDD2432D031F7395357")

    @ViewDebug.ExportedProperty(category = "measurement", flagMapping = {
            @ViewDebug.FlagToString(mask = -1,
                equals = -1, name = "NONE"),
            @ViewDebug.FlagToString(mask = Gravity.NO_GRAVITY,
                equals = Gravity.NO_GRAVITY,name = "NONE"),
            @ViewDebug.FlagToString(mask = Gravity.TOP,
                equals = Gravity.TOP, name = "TOP"),
            @ViewDebug.FlagToString(mask = Gravity.BOTTOM,
                equals = Gravity.BOTTOM, name = "BOTTOM"),
            @ViewDebug.FlagToString(mask = Gravity.LEFT,
                equals = Gravity.LEFT, name = "LEFT"),
            @ViewDebug.FlagToString(mask = Gravity.RIGHT,
                equals = Gravity.RIGHT, name = "RIGHT"),
            @ViewDebug.FlagToString(mask = Gravity.START,
                equals = Gravity.START, name = "START"),
            @ViewDebug.FlagToString(mask = Gravity.END,
                equals = Gravity.END, name = "END"),
            @ViewDebug.FlagToString(mask = Gravity.CENTER_VERTICAL,
                equals = Gravity.CENTER_VERTICAL, name = "CENTER_VERTICAL"),
            @ViewDebug.FlagToString(mask = Gravity.FILL_VERTICAL,
                equals = Gravity.FILL_VERTICAL, name = "FILL_VERTICAL"),
            @ViewDebug.FlagToString(mask = Gravity.CENTER_HORIZONTAL,
                equals = Gravity.CENTER_HORIZONTAL, name = "CENTER_HORIZONTAL"),
            @ViewDebug.FlagToString(mask = Gravity.FILL_HORIZONTAL,
                equals = Gravity.FILL_HORIZONTAL, name = "FILL_HORIZONTAL"),
            @ViewDebug.FlagToString(mask = Gravity.CENTER,
                equals = Gravity.CENTER, name = "CENTER"),
            @ViewDebug.FlagToString(mask = Gravity.FILL,
                equals = Gravity.FILL, name = "FILL"),
            @ViewDebug.FlagToString(mask = Gravity.RELATIVE_LAYOUT_DIRECTION,
                equals = Gravity.RELATIVE_LAYOUT_DIRECTION, name = "RELATIVE")
        }) private int mGravity = Gravity.START | Gravity.TOP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.124 -0400", hash_original_field = "43703A9421153843DA88A5EE2D1672A0", hash_generated_field = "DE3BC85B85ECB21DC64AEE79C7BD6AB4")

    @ViewDebug.ExportedProperty(category = "measurement") private int mTotalLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.124 -0400", hash_original_field = "0B41BD4353E911E2EC90D6CA263443B7", hash_generated_field = "EF9873241C2DA21073158F3890B03884")

    @ViewDebug.ExportedProperty(category = "layout") private float mWeightSum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.124 -0400", hash_original_field = "0C8E174FC05FB87AC9CC0DB60A352BB7", hash_generated_field = "295836EFFBA80C7933F8A212CF2A587C")

    @ViewDebug.ExportedProperty(category = "layout") private boolean mUseLargestChild;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.124 -0400", hash_original_field = "091770C374CE70054C190C0FB419201A", hash_generated_field = "EAE955816B4A7ECE00EA7D8113667D8A")

    private int[] mMaxAscent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.124 -0400", hash_original_field = "54405F87D6BC3932D04A1754A96D3A3D", hash_generated_field = "59DC29D31F14D9C75D4CE10DB2E42CAF")

    private int[] mMaxDescent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.124 -0400", hash_original_field = "F2EB92D46BFACFA75ABCA33DC6179915", hash_generated_field = "D73292FD603C307DCBB538076F31C80F")

    private Drawable mDivider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.124 -0400", hash_original_field = "2CFB9EB3B0B1B519D9DE96130629CD90", hash_generated_field = "57640F4296EC1DBBA1FC773929C31009")

    private int mDividerWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.124 -0400", hash_original_field = "FDC96C666CAD9FBF2EF59762861622A0", hash_generated_field = "D39F10261E466E88A7BE2C17E757ADFE")

    private int mDividerHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.124 -0400", hash_original_field = "570DF19833C5FFBC7225A5E90145E2AD", hash_generated_field = "1313B8BA9906A262CF63E7F9653AB503")

    private int mShowDividers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.124 -0400", hash_original_field = "009CC63A514E465A3A03D8B8E546A1D2", hash_generated_field = "8407F81B00C5F4756EECF88D42950A05")

    private int mDividerPadding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.124 -0400", hash_original_method = "FE94B0C3331DC48DD922B45C9927A2E5", hash_generated_method = "5599C5BD2C841CC6FACAC31E386AB809")
    public  LinearLayout(Context context) {
        super(context);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.125 -0400", hash_original_method = "90765D7AD39C5FFE28F827609E4D9AAF", hash_generated_method = "3EBE68191C4C2BC4D01EADD3696A2D6C")
    public  LinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.125 -0400", hash_original_method = "CABCB619C04E154CCE92AB7E91451BB7", hash_generated_method = "CA5A72A7F2D1E3625F6F89720D3CE613")
    public  LinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.LinearLayout, defStyle, 0);
        int index = a.getInt(com.android.internal.R.styleable.LinearLayout_orientation, -1);
        {
            setOrientation(index);
        } 
        index = a.getInt(com.android.internal.R.styleable.LinearLayout_gravity, -1);
        {
            setGravity(index);
        } 
        boolean baselineAligned = a.getBoolean(R.styleable.LinearLayout_baselineAligned, true);
        {
            setBaselineAligned(baselineAligned);
        } 
        mWeightSum = a.getFloat(R.styleable.LinearLayout_weightSum, -1.0f);
        mBaselineAlignedChildIndex =
                a.getInt(com.android.internal.R.styleable.LinearLayout_baselineAlignedChildIndex, -1);
        mUseLargestChild = a.getBoolean(R.styleable.LinearLayout_measureWithLargestChild, false);
        setDividerDrawable(a.getDrawable(R.styleable.LinearLayout_divider));
        mShowDividers = a.getInt(R.styleable.LinearLayout_showDividers, SHOW_DIVIDER_NONE);
        mDividerPadding = a.getDimensionPixelSize(R.styleable.LinearLayout_dividerPadding, 0);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.126 -0400", hash_original_method = "DE827128F1412AED640E145E58E9E69C", hash_generated_method = "FAA302745E69D3FEC3B40DEBEDFE410F")
    public void setShowDividers(int showDividers) {
        {
            requestLayout();
        } 
        mShowDividers = showDividers;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.126 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "A8970A942128317C9B5756399C19F605")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1395010500 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1395010500;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.126 -0400", hash_original_method = "81C750B99B14EF38CA21D36808CD7086", hash_generated_method = "D23F80949338E3DD5C3F715F1D4EAD0C")
    public int getShowDividers() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960727119 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960727119;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.127 -0400", hash_original_method = "7357A0D71E9A27E2C8DA29FA77A144AF", hash_generated_method = "C7D7FB39733171DDB03A67C46B5795DC")
    public void setDividerDrawable(Drawable divider) {
        mDivider = divider;
        {
            mDividerWidth = divider.getIntrinsicWidth();
            mDividerHeight = divider.getIntrinsicHeight();
        } 
        {
            mDividerWidth = 0;
            mDividerHeight = 0;
        } 
        setWillNotDraw(divider == null);
        requestLayout();
        
        
            
        
        
        
            
            
        
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.127 -0400", hash_original_method = "E2E4F4C3D603F5F2D62C3F5CBAFDCC06", hash_generated_method = "21B19108F063ADDE197FAB8209A2015F")
    public void setDividerPadding(int padding) {
        mDividerPadding = padding;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.128 -0400", hash_original_method = "2F70F7AA30D3819DCD53286185A1CA49", hash_generated_method = "6BBF11D7B10A88F5D556E33F116A08E7")
    public int getDividerPadding() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1818156713 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1818156713;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.128 -0400", hash_original_method = "4DCD95C01B6B6891D72266EBA61909DF", hash_generated_method = "E877DF13029BEE630454A5949751ABCA")
    public int getDividerWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1311804881 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1311804881;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.129 -0400", hash_original_method = "4D234859DAD3D7D2BD3ABC15BDBCF93C", hash_generated_method = "EA0F424986F5F82EE98B75D81D726482")
    @Override
    protected void onDraw(Canvas canvas) {
        
        {
            drawDividersVertical(canvas);
        } 
        {
            drawDividersHorizontal(canvas);
        } 
        addTaint(canvas.getTaint());
        
        
            
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.129 -0400", hash_original_method = "6F9B50C05500D3423B595FD6EF29F0C0", hash_generated_method = "D7098022FD9DC3AD60855BC2ABCCCBDC")
     void drawDividersVertical(Canvas canvas) {
        final int count = getVirtualChildCount();
        {
            int i = 0;
            {
                final View child = getVirtualChildAt(i);
                {
                    boolean varAD445368CB7F7DFBCAA93AD5AAA408ED_1897845836 = (child != null && child.getVisibility() != GONE);
                    {
                        {
                            boolean var5753280A391A92BDB591E4FED1D40DAB_1465493482 = (hasDividerBeforeChildAt(i));
                            {
                                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                                final int top = child.getTop() - lp.topMargin;
                                drawHorizontalDivider(canvas, top);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            boolean var48BF1E2FEB752C0437BBA766958C3F15_1373381410 = (hasDividerBeforeChildAt(count));
            {
                final View child = getVirtualChildAt(count - 1);
                int bottom = 0;
                {
                    bottom = getHeight() - getPaddingBottom() - mDividerHeight;
                } 
                {
                    final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                    bottom = child.getBottom() + lp.bottomMargin;
                } 
                drawHorizontalDivider(canvas, bottom);
            } 
        } 
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.130 -0400", hash_original_method = "86833A485E8343AB391A7321B35B1538", hash_generated_method = "33C24131C2DF47A58083ABD6A29315BF")
     void drawDividersHorizontal(Canvas canvas) {
        final int count = getVirtualChildCount();
        {
            int i = 0;
            {
                final View child = getVirtualChildAt(i);
                {
                    boolean varAD445368CB7F7DFBCAA93AD5AAA408ED_1056498985 = (child != null && child.getVisibility() != GONE);
                    {
                        {
                            boolean var5753280A391A92BDB591E4FED1D40DAB_1157144067 = (hasDividerBeforeChildAt(i));
                            {
                                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                                final int left = child.getLeft() - lp.leftMargin;
                                drawVerticalDivider(canvas, left);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            boolean var48BF1E2FEB752C0437BBA766958C3F15_446549329 = (hasDividerBeforeChildAt(count));
            {
                final View child = getVirtualChildAt(count - 1);
                int right = 0;
                {
                    right = getWidth() - getPaddingRight() - mDividerWidth;
                } 
                {
                    final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                    right = child.getRight() + lp.rightMargin;
                } 
                drawVerticalDivider(canvas, right);
            } 
        } 
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.130 -0400", hash_original_method = "B34FB2DB2BC7F90A8C4BCDC4C5D2422E", hash_generated_method = "5FB3124BBD0B3867543A8BAE6BBB72C3")
     void drawHorizontalDivider(Canvas canvas, int top) {
        mDivider.setBounds(getPaddingLeft() + mDividerPadding, top,
                getWidth() - getPaddingRight() - mDividerPadding, top + mDividerHeight);
        mDivider.draw(canvas);
        addTaint(canvas.getTaint());
        addTaint(top);
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.131 -0400", hash_original_method = "230D2DD24F19D940DC30A0FCA2C380AD", hash_generated_method = "DFB1F7777C357FC332037B845BC0A0E5")
     void drawVerticalDivider(Canvas canvas, int left) {
        mDivider.setBounds(left, getPaddingTop() + mDividerPadding,
                left + mDividerWidth, getHeight() - getPaddingBottom() - mDividerPadding);
        mDivider.draw(canvas);
        addTaint(canvas.getTaint());
        addTaint(left);
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.131 -0400", hash_original_method = "F54465AC5542CF519D3902E7BAEA3188", hash_generated_method = "239FA2275BD61819866D402374D7249B")
    public boolean isBaselineAligned() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1825660688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1825660688;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.131 -0400", hash_original_method = "8643C35E200A9ECC6F4D083B3C632ADD", hash_generated_method = "F5B36677A19813656057576482BE895F")
    @android.view.RemotableViewMethod
    public void setBaselineAligned(boolean baselineAligned) {
        mBaselineAligned = baselineAligned;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.131 -0400", hash_original_method = "49EB4E4C3BC63D2BEAA8F5D24053BB96", hash_generated_method = "6E66F23750181DBD9810FC8FEEFA45EF")
    public boolean isMeasureWithLargestChildEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1173309808 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1173309808;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.132 -0400", hash_original_method = "55BFE46AC305D5ECEC6F564C443E4CAB", hash_generated_method = "F0D8B5D04B16B58DE2D6932713E4CAD4")
    @android.view.RemotableViewMethod
    public void setMeasureWithLargestChildEnabled(boolean enabled) {
        mUseLargestChild = enabled;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.132 -0400", hash_original_method = "8677A7AE77B37457B2CE24BC40A0B2AA", hash_generated_method = "43B5942D0E0873996200333F107C734C")
    @Override
    public int getBaseline() {
        {
            int varEC5F70FA49520212A319ACA653FC0209_909856125 = (super.getBaseline());
        } 
        {
            boolean var0CC14488A448130ACFEBA1F25FFBD58A_1502064211 = (getChildCount() <= mBaselineAlignedChildIndex);
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout "
                    + "set to an index that is out of bounds.");
            } 
        } 
        final View child = getChildAt(mBaselineAlignedChildIndex);
        final int childBaseline = child.getBaseline();
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout "
                    + "points to a View that doesn't know how to get its baseline.");
        } 
        int childTop = mBaselineChildTop;
        {
            final int majorGravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
            {
                
                childTop = mBottom - mTop - mPaddingBottom - mTotalLength;
                
                
                childTop += ((mBottom - mTop - mPaddingTop - mPaddingBottom) -
                               mTotalLength) / 2;
                
            } 
        } 
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487035788 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487035788;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.133 -0400", hash_original_method = "90F550BFDC49A6587A7A8440E339A132", hash_generated_method = "919C7E7A37C11D011DDEFAB3F4BF6E96")
    public int getBaselineAlignedChildIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_235599574 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_235599574;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.133 -0400", hash_original_method = "4CFC93DB175F8874B4EFFA335793DCB8", hash_generated_method = "816A24B738BDED20127DC69601FA3E28")
    @android.view.RemotableViewMethod
    public void setBaselineAlignedChildIndex(int i) {
        {
            boolean varE9CD64879C792E1B66A251BAB70D8B08_376910737 = ((i < 0) || (i >= getChildCount()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("base aligned child index out "
                    + "of range (0, " + getChildCount() + ")");
            } 
        } 
        mBaselineAlignedChildIndex = i;
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.133 -0400", hash_original_method = "87FE8C209A68A97BDFF0666E4CF673D3", hash_generated_method = "EA21A5EB407D96B63C562392A1D59D87")
     View getVirtualChildAt(int index) {
        View varB4EAC82CA7396A68D541C85D26508E83_189579836 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_189579836 = getChildAt(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_189579836.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_189579836;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.134 -0400", hash_original_method = "04A766EF9FA40CCD4344368D3178C5E7", hash_generated_method = "885AFAD9EC7789EC6AAF52C419C0C261")
     int getVirtualChildCount() {
        int varF41158137001188D2F9D08127BFB39DA_401020141 = (getChildCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1574444060 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1574444060;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.134 -0400", hash_original_method = "131E7E20664E8B649BC33F0915A0DE0D", hash_generated_method = "08182987288632DC7EA854E6D5B8B5B0")
    public float getWeightSum() {
        float var546ADE640B6EDFBC8A086EF31347E768_1520484905 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1520484905;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.134 -0400", hash_original_method = "47922B5280E89B2CF9B73D66705F0A8D", hash_generated_method = "0C909C9A2C5340B2F81C58E12B1C7283")
    @android.view.RemotableViewMethod
    public void setWeightSum(float weightSum) {
        mWeightSum = Math.max(0.0f, weightSum);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.135 -0400", hash_original_method = "3F3B158F407FDE6BDDE91ED473E376D3", hash_generated_method = "E572AC246BCA803DBDD629DE2DB04BF7")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        {
            measureVertical(widthMeasureSpec, heightMeasureSpec);
        } 
        {
            measureHorizontal(widthMeasureSpec, heightMeasureSpec);
        } 
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.135 -0400", hash_original_method = "E4A04FCA37D7E9FFFC1F15D63F30923E", hash_generated_method = "6081791780D1819EA019C36CCC2A4300")
    protected boolean hasDividerBeforeChildAt(int childIndex) {
        {
            boolean var042391D18CFAA58040C07325508C3E5D_1801015340 = (childIndex == getChildCount());
            {
                boolean hasVisibleViewBefore = false;
                {
                    int i = childIndex - 1;
                    {
                        {
                            boolean var849B37533740585CFE18F837DD2EDAAB_577922481 = (getChildAt(i).getVisibility() != GONE);
                            {
                                hasVisibleViewBefore = true;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(childIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2034321585 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2034321585;
        
        
            
        
            
        
            
            
                
                    
                    
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.139 -0400", hash_original_method = "A88B972B81C9E0D927EB1FAC25F8F6D1", hash_generated_method = "D311881B894C142FB0097A0D832EF94F")
     void measureVertical(int widthMeasureSpec, int heightMeasureSpec) {
        mTotalLength = 0;
        int maxWidth = 0;
        int childState = 0;
        int alternativeMaxWidth = 0;
        int weightedMaxWidth = 0;
        boolean allFillParent = true;
        float totalWeight = 0;
        final int count = getVirtualChildCount();
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        boolean matchWidth = false;
        final int baselineChildIndex = mBaselineAlignedChildIndex;
        final boolean useLargestChild = mUseLargestChild;
        int largestChildHeight = Integer.MIN_VALUE;
        {
            int i = 0;
            {
                final View child = getVirtualChildAt(i);
                {
                    mTotalLength += measureNullChild(i);
                } 
                {
                    boolean varAE94D5328E94C6606865B35993EDD564_1950961700 = (child.getVisibility() == View.GONE);
                    {
                        i += getChildrenSkipCount(child, i);
                    } 
                } 
                {
                    boolean var53CA14277C14EA37C3E2B0E1BF193AF9_1644312516 = (hasDividerBeforeChildAt(i));
                    {
                        mTotalLength += mDividerHeight;
                    } 
                } 
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                totalWeight += lp.weight;
                {
                    final int totalLength = mTotalLength;
                    mTotalLength = Math.max(totalLength, totalLength + lp.topMargin + lp.bottomMargin);
                } 
                {
                    int oldHeight = Integer.MIN_VALUE;
                    {
                        oldHeight = 0;
                        lp.height = LayoutParams.WRAP_CONTENT;
                    } 
                    measureChildBeforeLayout(
                       child, i, widthMeasureSpec, 0, heightMeasureSpec,
                       totalWeight == 0 ? mTotalLength : 0);
                    {
                        lp.height = oldHeight;
                    } 
                    final int childHeight = child.getMeasuredHeight();
                    final int totalLength = mTotalLength;
                    mTotalLength = Math.max(totalLength, totalLength + childHeight + lp.topMargin +
                       lp.bottomMargin + getNextLocationOffset(child));
                    {
                        largestChildHeight = Math.max(childHeight, largestChildHeight);
                    } 
                } 
                {
                    mBaselineChildTop = mTotalLength;
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("A child of LinearLayout with index "
                        + "less than mBaselineAlignedChildIndex has weight > 0, which "
                        + "won't work.  Either remove the weight, or don't set "
                        + "mBaselineAlignedChildIndex.");
                } 
                boolean matchWidthLocally = false;
                {
                    matchWidth = true;
                    matchWidthLocally = true;
                } 
                final int margin = lp.leftMargin + lp.rightMargin;
                final int measuredWidth = child.getMeasuredWidth() + margin;
                maxWidth = Math.max(maxWidth, measuredWidth);
                childState = combineMeasuredStates(childState, child.getMeasuredState());
                allFillParent = allFillParent && lp.width == LayoutParams.MATCH_PARENT;
                {
                    weightedMaxWidth = Math.max(weightedMaxWidth,
                        matchWidthLocally ? margin : measuredWidth);
                } 
                {
                    alternativeMaxWidth = Math.max(alternativeMaxWidth,
                        matchWidthLocally ? margin : measuredWidth);
                } 
                i += getChildrenSkipCount(child, i);
            } 
        } 
        {
            boolean varCC0767313899D8044991C6ED676480A0_1522014382 = (mTotalLength > 0 && hasDividerBeforeChildAt(count));
            {
                mTotalLength += mDividerHeight;
            } 
        } 
        {
            mTotalLength = 0;
            {
                int i = 0;
                {
                    final View child = getVirtualChildAt(i);
                    {
                        mTotalLength += measureNullChild(i);
                    } 
                    {
                        boolean var24A8049355A2DBEE0F9FC0F85F3CAA64_664537640 = (child.getVisibility() == GONE);
                        {
                            i += getChildrenSkipCount(child, i);
                        } 
                    } 
                    final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)
                        child.getLayoutParams();
                    final int totalLength = mTotalLength;
                    mTotalLength = Math.max(totalLength, totalLength + largestChildHeight +
                        lp.topMargin + lp.bottomMargin + getNextLocationOffset(child));
                } 
            } 
        } 
        mTotalLength += mPaddingTop + mPaddingBottom;
        int heightSize = mTotalLength;
        heightSize = Math.max(heightSize, getSuggestedMinimumHeight());
        int heightSizeAndState = resolveSizeAndState(heightSize, heightMeasureSpec, 0);
        heightSize = heightSizeAndState & MEASURED_SIZE_MASK;
        int delta = heightSize - mTotalLength;
        {
            float weightSum;
            weightSum = mWeightSum;
            weightSum = totalWeight;
            mTotalLength = 0;
            {
                int i = 0;
                {
                    final View child = getVirtualChildAt(i);
                    {
                        boolean varCE5DD5D436329456ACE82D8F3349CC31_947038804 = (child.getVisibility() == View.GONE);
                    } 
                    LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                    float childExtra = lp.weight;
                    {
                        int share = (int) (childExtra * delta / weightSum);
                        weightSum -= childExtra;
                        delta -= share;
                        final int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec,
                            mPaddingLeft + mPaddingRight +
                                    lp.leftMargin + lp.rightMargin, lp.width);
                        {
                            int childHeight = child.getMeasuredHeight() + share;
                            {
                                childHeight = 0;
                            } 
                            child.measure(childWidthMeasureSpec,
                                MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY));
                        } 
                        {
                            child.measure(childWidthMeasureSpec,
                                MeasureSpec.makeMeasureSpec(share > 0 ? share : 0,
                                        MeasureSpec.EXACTLY));
                        } 
                        childState = combineMeasuredStates(childState, child.getMeasuredState()
                            & (MEASURED_STATE_MASK>>MEASURED_HEIGHT_STATE_SHIFT));
                    } 
                    final int margin = lp.leftMargin + lp.rightMargin;
                    final int measuredWidth = child.getMeasuredWidth() + margin;
                    maxWidth = Math.max(maxWidth, measuredWidth);
                    boolean matchWidthLocally = widthMode != MeasureSpec.EXACTLY &&
                        lp.width == LayoutParams.MATCH_PARENT;
                    alternativeMaxWidth = Math.max(alternativeMaxWidth,
                        matchWidthLocally ? margin : measuredWidth);
                    allFillParent = allFillParent && lp.width == LayoutParams.MATCH_PARENT;
                    final int totalLength = mTotalLength;
                    mTotalLength = Math.max(totalLength, totalLength + child.getMeasuredHeight() +
                        lp.topMargin + lp.bottomMargin + getNextLocationOffset(child));
                } 
            } 
            mTotalLength += mPaddingTop + mPaddingBottom;
        } 
        {
            alternativeMaxWidth = Math.max(alternativeMaxWidth,
                                           weightedMaxWidth);
            {
                {
                    int i = 0;
                    {
                        final View child = getVirtualChildAt(i);
                        {
                            boolean varE7BB3503787C529D329422F9519818AF_828304870 = (child == null || child.getVisibility() == View.GONE);
                        } 
                        final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                        float childExtra = lp.weight;
                        {
                            child.measure(
                                MeasureSpec.makeMeasureSpec(child.getMeasuredWidth(),
                                        MeasureSpec.EXACTLY),
                                MeasureSpec.makeMeasureSpec(largestChildHeight,
                                        MeasureSpec.EXACTLY));
                        } 
                    } 
                } 
            } 
        } 
        {
            maxWidth = alternativeMaxWidth;
        } 
        maxWidth += mPaddingLeft + mPaddingRight;
        maxWidth = Math.max(maxWidth, getSuggestedMinimumWidth());
        setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, childState),
                heightSizeAndState);
        {
            forceUniformWidth(count, heightMeasureSpec);
        } 
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.140 -0400", hash_original_method = "AFA9034D947EBEF26850BC0782F132F9", hash_generated_method = "BE90EC86722F0BB381C096468328575E")
    private void forceUniformWidth(int count, int heightMeasureSpec) {
        int uniformMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(),
                MeasureSpec.EXACTLY);
        {
            int i = 0;
            {
                final View child = getVirtualChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_854739716 = (child.getVisibility() != GONE);
                    {
                        LinearLayout.LayoutParams lp = ((LinearLayout.LayoutParams)child.getLayoutParams());
                        {
                            int oldHeight = lp.height;
                            lp.height = child.getMeasuredHeight();
                            measureChildWithMargins(child, uniformMeasureSpec, 0, heightMeasureSpec, 0);
                            lp.height = oldHeight;
                        } 
                    } 
                } 
            } 
        } 
        addTaint(count);
        addTaint(heightMeasureSpec);
        
        
                
        
           
           
               
               
                   
                   
                   
                   
               
           
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.144 -0400", hash_original_method = "22C04BEEA310D9DB4A6BB8F3656099B0", hash_generated_method = "62EE2BA53D34FA25A9DFEE2BF43635BF")
     void measureHorizontal(int widthMeasureSpec, int heightMeasureSpec) {
        mTotalLength = 0;
        int maxHeight = 0;
        int childState = 0;
        int alternativeMaxHeight = 0;
        int weightedMaxHeight = 0;
        boolean allFillParent = true;
        float totalWeight = 0;
        final int count = getVirtualChildCount();
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        boolean matchHeight = false;
        {
            mMaxAscent = new int[VERTICAL_GRAVITY_COUNT];
            mMaxDescent = new int[VERTICAL_GRAVITY_COUNT];
        } 
        final int[] maxAscent = mMaxAscent;
        final int[] maxDescent = mMaxDescent;
        maxAscent[0] = maxAscent[1] = maxAscent[2] = maxAscent[3] = -1;
        maxDescent[0] = maxDescent[1] = maxDescent[2] = maxDescent[3] = -1;
        final boolean baselineAligned = mBaselineAligned;
        final boolean useLargestChild = mUseLargestChild;
        final boolean isExactly = widthMode == MeasureSpec.EXACTLY;
        int largestChildWidth = Integer.MIN_VALUE;
        {
            int i = 0;
            {
                final View child = getVirtualChildAt(i);
                {
                    mTotalLength += measureNullChild(i);
                } 
                {
                    boolean varE5A6421440835A22FD9C00B75E3D1565_1460205874 = (child.getVisibility() == GONE);
                    {
                        i += getChildrenSkipCount(child, i);
                    } 
                } 
                {
                    boolean var53CA14277C14EA37C3E2B0E1BF193AF9_149892317 = (hasDividerBeforeChildAt(i));
                    {
                        mTotalLength += mDividerWidth;
                    } 
                } 
                final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)
                    child.getLayoutParams();
                totalWeight += lp.weight;
                {
                    {
                        mTotalLength += lp.leftMargin + lp.rightMargin;
                    } 
                    {
                        final int totalLength = mTotalLength;
                        mTotalLength = Math.max(totalLength, totalLength +
                            lp.leftMargin + lp.rightMargin);
                    } 
                    {
                        final int freeSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                        child.measure(freeSpec, freeSpec);
                    } 
                } 
                {
                    int oldWidth = Integer.MIN_VALUE;
                    {
                        oldWidth = 0;
                        lp.width = LayoutParams.WRAP_CONTENT;
                    } 
                    measureChildBeforeLayout(child, i, widthMeasureSpec,
                        totalWeight == 0 ? mTotalLength : 0,
                        heightMeasureSpec, 0);
                    {
                        lp.width = oldWidth;
                    } 
                    final int childWidth = child.getMeasuredWidth();
                    {
                        mTotalLength += childWidth + lp.leftMargin + lp.rightMargin +
                            getNextLocationOffset(child);
                    } 
                    {
                        final int totalLength = mTotalLength;
                        mTotalLength = Math.max(totalLength, totalLength + childWidth + lp.leftMargin +
                           lp.rightMargin + getNextLocationOffset(child));
                    } 
                    {
                        largestChildWidth = Math.max(childWidth, largestChildWidth);
                    } 
                } 
                boolean matchHeightLocally = false;
                {
                    matchHeight = true;
                    matchHeightLocally = true;
                } 
                final int margin = lp.topMargin + lp.bottomMargin;
                final int childHeight = child.getMeasuredHeight() + margin;
                childState = combineMeasuredStates(childState, child.getMeasuredState());
                {
                    final int childBaseline = child.getBaseline();
                    {
                        final int gravity = (lp.gravity < 0 ? mGravity : lp.gravity)
                            & Gravity.VERTICAL_GRAVITY_MASK;
                        final int index = ((gravity >> Gravity.AXIS_Y_SHIFT)
                            & ~Gravity.AXIS_SPECIFIED) >> 1;
                        maxAscent[index] = Math.max(maxAscent[index], childBaseline);
                        maxDescent[index] = Math.max(maxDescent[index], childHeight - childBaseline);
                    } 
                } 
                maxHeight = Math.max(maxHeight, childHeight);
                allFillParent = allFillParent && lp.height == LayoutParams.MATCH_PARENT;
                {
                    weightedMaxHeight = Math.max(weightedMaxHeight,
                        matchHeightLocally ? margin : childHeight);
                } 
                {
                    alternativeMaxHeight = Math.max(alternativeMaxHeight,
                        matchHeightLocally ? margin : childHeight);
                } 
                i += getChildrenSkipCount(child, i);
            } 
        } 
        {
            boolean varCC0767313899D8044991C6ED676480A0_486485145 = (mTotalLength > 0 && hasDividerBeforeChildAt(count));
            {
                mTotalLength += mDividerWidth;
            } 
        } 
        {
            final int ascent = Math.max(maxAscent[INDEX_FILL],
                    Math.max(maxAscent[INDEX_CENTER_VERTICAL],
                    Math.max(maxAscent[INDEX_TOP], maxAscent[INDEX_BOTTOM])));
            final int descent = Math.max(maxDescent[INDEX_FILL],
                    Math.max(maxDescent[INDEX_CENTER_VERTICAL],
                    Math.max(maxDescent[INDEX_TOP], maxDescent[INDEX_BOTTOM])));
            maxHeight = Math.max(maxHeight, ascent + descent);
        } 
        {
            mTotalLength = 0;
            {
                int i = 0;
                {
                    final View child = getVirtualChildAt(i);
                    {
                        mTotalLength += measureNullChild(i);
                    } 
                    {
                        boolean var24A8049355A2DBEE0F9FC0F85F3CAA64_1833582288 = (child.getVisibility() == GONE);
                        {
                            i += getChildrenSkipCount(child, i);
                        } 
                    } 
                    final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)
                        child.getLayoutParams();
                    {
                        mTotalLength += largestChildWidth + lp.leftMargin + lp.rightMargin +
                            getNextLocationOffset(child);
                    } 
                    {
                        final int totalLength = mTotalLength;
                        mTotalLength = Math.max(totalLength, totalLength + largestChildWidth +
                            lp.leftMargin + lp.rightMargin + getNextLocationOffset(child));
                    } 
                } 
            } 
        } 
        mTotalLength += mPaddingLeft + mPaddingRight;
        int widthSize = mTotalLength;
        widthSize = Math.max(widthSize, getSuggestedMinimumWidth());
        int widthSizeAndState = resolveSizeAndState(widthSize, widthMeasureSpec, 0);
        widthSize = widthSizeAndState & MEASURED_SIZE_MASK;
        int delta = widthSize - mTotalLength;
        {
            float weightSum;
            weightSum = mWeightSum;
            weightSum = totalWeight;
            maxAscent[0] = maxAscent[1] = maxAscent[2] = maxAscent[3] = -1;
            maxDescent[0] = maxDescent[1] = maxDescent[2] = maxDescent[3] = -1;
            maxHeight = -1;
            mTotalLength = 0;
            {
                int i = 0;
                {
                    final View child = getVirtualChildAt(i);
                    {
                        boolean varF9B20D9EE469ED1FED42E2666426C840_1923057674 = (child == null || child.getVisibility() == View.GONE);
                    } 
                    final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                    float childExtra = lp.weight;
                    {
                        int share = (int) (childExtra * delta / weightSum);
                        weightSum -= childExtra;
                        delta -= share;
                        final int childHeightMeasureSpec = getChildMeasureSpec(
                            heightMeasureSpec,
                            mPaddingTop + mPaddingBottom + lp.topMargin + lp.bottomMargin,
                            lp.height);
                        {
                            int childWidth = child.getMeasuredWidth() + share;
                            {
                                childWidth = 0;
                            } 
                            child.measure(
                            MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY),
                            childHeightMeasureSpec);
                        } 
                        {
                            child.measure(MeasureSpec.makeMeasureSpec(
                                share > 0 ? share : 0, MeasureSpec.EXACTLY),
                                childHeightMeasureSpec);
                        } 
                        childState = combineMeasuredStates(childState,
                            child.getMeasuredState() & MEASURED_STATE_MASK);
                    } 
                    {
                        mTotalLength += child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin +
                            getNextLocationOffset(child);
                    } 
                    {
                        final int totalLength = mTotalLength;
                        mTotalLength = Math.max(totalLength, totalLength + child.getMeasuredWidth() +
                            lp.leftMargin + lp.rightMargin + getNextLocationOffset(child));
                    } 
                    boolean matchHeightLocally = heightMode != MeasureSpec.EXACTLY &&
                        lp.height == LayoutParams.MATCH_PARENT;
                    final int margin = lp.topMargin + lp .bottomMargin;
                    int childHeight = child.getMeasuredHeight() + margin;
                    maxHeight = Math.max(maxHeight, childHeight);
                    alternativeMaxHeight = Math.max(alternativeMaxHeight,
                        matchHeightLocally ? margin : childHeight);
                    allFillParent = allFillParent && lp.height == LayoutParams.MATCH_PARENT;
                    {
                        final int childBaseline = child.getBaseline();
                        {
                            final int gravity = (lp.gravity < 0 ? mGravity : lp.gravity)
                                & Gravity.VERTICAL_GRAVITY_MASK;
                            final int index = ((gravity >> Gravity.AXIS_Y_SHIFT)
                                & ~Gravity.AXIS_SPECIFIED) >> 1;
                            maxAscent[index] = Math.max(maxAscent[index], childBaseline);
                            maxDescent[index] = Math.max(maxDescent[index],
                                childHeight - childBaseline);
                        } 
                    } 
                } 
            } 
            mTotalLength += mPaddingLeft + mPaddingRight;
            {
                final int ascent = Math.max(maxAscent[INDEX_FILL],
                        Math.max(maxAscent[INDEX_CENTER_VERTICAL],
                        Math.max(maxAscent[INDEX_TOP], maxAscent[INDEX_BOTTOM])));
                final int descent = Math.max(maxDescent[INDEX_FILL],
                        Math.max(maxDescent[INDEX_CENTER_VERTICAL],
                        Math.max(maxDescent[INDEX_TOP], maxDescent[INDEX_BOTTOM])));
                maxHeight = Math.max(maxHeight, ascent + descent);
            } 
        } 
        {
            alternativeMaxHeight = Math.max(alternativeMaxHeight, weightedMaxHeight);
            {
                {
                    int i = 0;
                    {
                        final View child = getVirtualChildAt(i);
                        {
                            boolean varE7BB3503787C529D329422F9519818AF_235922444 = (child == null || child.getVisibility() == View.GONE);
                        } 
                        final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                        float childExtra = lp.weight;
                        {
                            child.measure(
                                MeasureSpec.makeMeasureSpec(largestChildWidth, MeasureSpec.EXACTLY),
                                MeasureSpec.makeMeasureSpec(child.getMeasuredHeight(),
                                        MeasureSpec.EXACTLY));
                        } 
                    } 
                } 
            } 
        } 
        {
            maxHeight = alternativeMaxHeight;
        } 
        maxHeight += mPaddingTop + mPaddingBottom;
        maxHeight = Math.max(maxHeight, getSuggestedMinimumHeight());
        setMeasuredDimension(widthSizeAndState | (childState&MEASURED_STATE_MASK),
                resolveSizeAndState(maxHeight, heightMeasureSpec,
                        (childState<<MEASURED_HEIGHT_STATE_SHIFT)));
        {
            forceUniformHeight(count, widthMeasureSpec);
        } 
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.145 -0400", hash_original_method = "FDF33FE6741A819E3461023969653A29", hash_generated_method = "5994F1AAB55F14957D416651EE1E1475")
    private void forceUniformHeight(int count, int widthMeasureSpec) {
        int uniformMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(),
                MeasureSpec.EXACTLY);
        {
            int i = 0;
            {
                final View child = getVirtualChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_855037008 = (child.getVisibility() != GONE);
                    {
                        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                        {
                            int oldWidth = lp.width;
                            lp.width = child.getMeasuredWidth();
                            measureChildWithMargins(child, widthMeasureSpec, 0, uniformMeasureSpec, 0);
                            lp.width = oldWidth;
                        } 
                    } 
                } 
            } 
        } 
        addTaint(count);
        addTaint(widthMeasureSpec);
        
        
                
        
           
           
               
               
                   
                   
                   
                   
               
           
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.145 -0400", hash_original_method = "64CDF538399E47C38C21DACEFC8C1E08", hash_generated_method = "FE59B5355FA2EAA6921EE3476C588226")
     int getChildrenSkipCount(View child, int index) {
        addTaint(child.getTaint());
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1713834060 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1713834060;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.145 -0400", hash_original_method = "0C791DFCDA5E7DFE7963EF393BDBDA11", hash_generated_method = "0025997AD10A8F16E73E3F3789E74D36")
     int measureNullChild(int childIndex) {
        addTaint(childIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_281305402 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_281305402;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.146 -0400", hash_original_method = "784157887C32A4B8D345E93BB13DEECA", hash_generated_method = "3CD9D429BD4B3D6B5F431E83EFD174DB")
     void measureChildBeforeLayout(View child, int childIndex,
            int widthMeasureSpec, int totalWidth, int heightMeasureSpec,
            int totalHeight) {
        measureChildWithMargins(child, widthMeasureSpec, totalWidth,
                heightMeasureSpec, totalHeight);
        addTaint(child.getTaint());
        addTaint(childIndex);
        addTaint(widthMeasureSpec);
        addTaint(totalWidth);
        addTaint(heightMeasureSpec);
        addTaint(totalHeight);
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.146 -0400", hash_original_method = "BA69BAE2E1D7A163D53D02D47016A6D7", hash_generated_method = "120A45A2634B44862FD3AEEFFFB2D287")
     int getLocationOffset(View child) {
        addTaint(child.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_412278902 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_412278902;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.146 -0400", hash_original_method = "6D7A4F846C7E828D32B84605EE3B545F", hash_generated_method = "9B6810446AE5464BDDFED4F715B4A2A1")
     int getNextLocationOffset(View child) {
        addTaint(child.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1898389918 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1898389918;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.147 -0400", hash_original_method = "38617BD257A07AF46AAF702E88FA7138", hash_generated_method = "B0A2BFC2F6C6A680B82583D6DC4BAE75")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        
        {
            layoutVertical();
        } 
        {
            layoutHorizontal();
        } 
        addTaint(changed);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.148 -0400", hash_original_method = "30B5FEA9EA0D751AC72456573A204452", hash_generated_method = "1C7CB9D806C6CBA9C67206782A26D145")
     void layoutVertical() {
        final int paddingLeft = mPaddingLeft;
        int childTop;
        int childLeft;
        final int width = mRight - mLeft;
        int childRight = width - mPaddingRight;
        int childSpace = width - paddingLeft - mPaddingRight;
        final int count = getVirtualChildCount();
        final int majorGravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        final int minorGravity = mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        
        childTop = mPaddingTop + mBottom - mTop - mTotalLength;
        
        
        childTop = mPaddingTop + (mBottom - mTop - mTotalLength) / 2;
        
        
        childTop = mPaddingTop;
        
        {
            int i = 0;
            {
                final View child = getVirtualChildAt(i);
                {
                    childTop += measureNullChild(i);
                } 
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_1182867875 = (child.getVisibility() != GONE);
                    {
                        final int childWidth = child.getMeasuredWidth();
                        final int childHeight = child.getMeasuredHeight();
                        final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                        int gravity = lp.gravity;
                        {
                            gravity = minorGravity;
                        } 
                        final int layoutDirection = getResolvedLayoutDirection();
                        final int absoluteGravity = Gravity.getAbsoluteGravity(gravity, layoutDirection);
                        
                        childLeft = paddingLeft + ((childSpace - childWidth) / 2)
                                + lp.leftMargin - lp.rightMargin;
                        
                        
                        childLeft = childRight - childWidth - lp.rightMargin;
                        
                        
                        childLeft = paddingLeft + lp.leftMargin;
                        
                        {
                            boolean var5753280A391A92BDB591E4FED1D40DAB_1116836674 = (hasDividerBeforeChildAt(i));
                            {
                                childTop += mDividerHeight;
                            } 
                        } 
                        childTop += lp.topMargin;
                        setChildFrame(child, childLeft, childTop + getLocationOffset(child),
                        childWidth, childHeight);
                        childTop += childHeight + lp.bottomMargin + getNextLocationOffset(child);
                        i += getChildrenSkipCount(child, i);
                    } 
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.150 -0400", hash_original_method = "7E4C2E885F4FB677FEB4B548A065DB2A", hash_generated_method = "4C8DD5318BA965AAA60CE72DB581F8C5")
     void layoutHorizontal() {
        final boolean isLayoutRtl = isLayoutRtl();
        final int paddingTop = mPaddingTop;
        int childTop;
        int childLeft;
        final int height = mBottom - mTop;
        int childBottom = height - mPaddingBottom;
        int childSpace = height - paddingTop - mPaddingBottom;
        final int count = getVirtualChildCount();
        final int majorGravity = mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        final int minorGravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        final boolean baselineAligned = mBaselineAligned;
        final int[] maxAscent = mMaxAscent;
        final int[] maxDescent = mMaxDescent;
        final int layoutDirection = getResolvedLayoutDirection();
        {
            Object var9AC6381C3482ABA654889035FB8C338F_1355318478 = (Gravity.getAbsoluteGravity(majorGravity, layoutDirection));
            
            childLeft = mPaddingLeft + mRight - mLeft - mTotalLength;
            
            
            childLeft = mPaddingLeft + (mRight - mLeft - mTotalLength) / 2;
            
            
            childLeft = mPaddingLeft;
            
        } 
        int start = 0;
        int dir = 1;
        {
            start = count - 1;
            dir = -1;
        } 
        {
            int i = 0;
            {
                int childIndex = start + dir * i;
                final View child = getVirtualChildAt(childIndex);
                {
                    childLeft += measureNullChild(childIndex);
                } 
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_2122776350 = (child.getVisibility() != GONE);
                    {
                        final int childWidth = child.getMeasuredWidth();
                        final int childHeight = child.getMeasuredHeight();
                        int childBaseline = -1;
                        final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                        {
                            childBaseline = child.getBaseline();
                        } 
                        int gravity = lp.gravity;
                        {
                            gravity = minorGravity;
                        } 
                        
                        childTop = paddingTop + lp.topMargin;
                        
                        
                        {
                            childTop += maxAscent[INDEX_TOP] - childBaseline;
                        } 
                        
                        
                        childTop = paddingTop + ((childSpace - childHeight) / 2)
                                + lp.topMargin - lp.bottomMargin;
                        
                        
                        childTop = childBottom - childHeight - lp.bottomMargin;
                        
                        
                        {
                            int descent = child.getMeasuredHeight() - childBaseline;
                            childTop -= (maxDescent[INDEX_BOTTOM] - descent);
                        } 
                        
                        
                        childTop = paddingTop;
                        
                        {
                            boolean varD92D197B47B02ED47C53CE932422B14B_1443083286 = (hasDividerBeforeChildAt(childIndex));
                            {
                                childLeft += mDividerWidth;
                            } 
                        } 
                        childLeft += lp.leftMargin;
                        setChildFrame(child, childLeft + getLocationOffset(child), childTop,
                        childWidth, childHeight);
                        childLeft += childWidth + lp.rightMargin +
                        getNextLocationOffset(child);
                        i += getChildrenSkipCount(child, childIndex);
                    } 
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.151 -0400", hash_original_method = "74793CDC2820B7770CC6C7B645CE6A0C", hash_generated_method = "ABEA48B3A59EDBABAE9B04B6126B44B6")
    private void setChildFrame(View child, int left, int top, int width, int height) {
        child.layout(left, top, left + width, top + height);
        addTaint(child.getTaint());
        addTaint(left);
        addTaint(top);
        addTaint(width);
        addTaint(height);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.151 -0400", hash_original_method = "708E6C59CCF6822D1254CF8F346C250A", hash_generated_method = "ED9B202367C7DECE598DADBE6010297D")
    public void setOrientation(int orientation) {
        {
            mOrientation = orientation;
            requestLayout();
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.152 -0400", hash_original_method = "6BA82D6B625174A8AC80664141F0D361", hash_generated_method = "9A63CD788C6CD7949F03F50917C08314")
    public int getOrientation() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730145335 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730145335;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.152 -0400", hash_original_method = "DC8D5E1211DE0926B9DDA2FADCED75EE", hash_generated_method = "70FD7A97C03EACC1814D5C80AB15EB8F")
    @android.view.RemotableViewMethod
    public void setGravity(int gravity) {
        {
            {
                gravity |= Gravity.START;
            } 
            {
                gravity |= Gravity.TOP;
            } 
            mGravity = gravity;
            requestLayout();
        } 
        
        
            
                
            
            
                
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.152 -0400", hash_original_method = "076C59065FCBD07F7CAA4FFA6D12CC3A", hash_generated_method = "472F09623C44D3DF3291E5B067DA27D2")
    @android.view.RemotableViewMethod
    public void setHorizontalGravity(int horizontalGravity) {
        final int gravity = horizontalGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        {
            mGravity = (mGravity & ~Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) | gravity;
            requestLayout();
        } 
        addTaint(horizontalGravity);
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.153 -0400", hash_original_method = "EE245B70888F9F1582A126D948173E64", hash_generated_method = "95CC5873BAFE1E11950B4F47E16D066A")
    @android.view.RemotableViewMethod
    public void setVerticalGravity(int verticalGravity) {
        final int gravity = verticalGravity & Gravity.VERTICAL_GRAVITY_MASK;
        {
            mGravity = (mGravity & ~Gravity.VERTICAL_GRAVITY_MASK) | gravity;
            requestLayout();
        } 
        addTaint(verticalGravity);
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.153 -0400", hash_original_method = "5E749CCE267F5C755BAC22F4F9345284", hash_generated_method = "555977B4A2B479E0777D5FD97C69E28F")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_299455699 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_299455699 = new LinearLayout.LayoutParams(getContext(), attrs);
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_299455699.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_299455699;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.154 -0400", hash_original_method = "3D6E4608F39560A7785B268309288C51", hash_generated_method = "84C1C0ED7A13502C10CFF7BB11DE1879")
    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1955261368 = null; 
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1860584141 = null; 
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_279967678 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1955261368 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1860584141 = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_279967678 = null;
        LayoutParams varA7E53CE21691AB073D9660D615818899_1605032203; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1605032203 = varB4EAC82CA7396A68D541C85D26508E83_1955261368;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1605032203 = varB4EAC82CA7396A68D541C85D26508E83_1860584141;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1605032203 = varB4EAC82CA7396A68D541C85D26508E83_279967678;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1605032203.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1605032203;
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.154 -0400", hash_original_method = "E5FE95308BC48D9899CFDE5A4F7DEDB6", hash_generated_method = "ACCEB5AB02F27686F7B7AF8FBBF08159")
    @Override
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1321423024 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1321423024 = new LayoutParams(p);
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1321423024.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1321423024;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.155 -0400", hash_original_method = "1F2E8350C10FBDB8051DCF8E5479411B", hash_generated_method = "D44F2E81C7A43A209D0E5D0856C5594E")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1695012428 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1695012428;
        
        
    }

    
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.155 -0400", hash_original_field = "7EDABF994B76A00CBC60C95AF337DB8F", hash_generated_field = "B59DE7C019472A73872C811A2811FA3D")

        @ViewDebug.ExportedProperty(category = "layout") public float weight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.155 -0400", hash_original_field = "CF0F2AF9EE62920A17A205053A2F0423", hash_generated_field = "938DDF19CF8B381A3F6119E45B2090E8")

        @ViewDebug.ExportedProperty(category = "layout", mapping = {
            @ViewDebug.IntToString(from =  -1,                       to = "NONE"),
            @ViewDebug.IntToString(from = Gravity.NO_GRAVITY,        to = "NONE"),
            @ViewDebug.IntToString(from = Gravity.TOP,               to = "TOP"),
            @ViewDebug.IntToString(from = Gravity.BOTTOM,            to = "BOTTOM"),
            @ViewDebug.IntToString(from = Gravity.LEFT,              to = "LEFT"),
            @ViewDebug.IntToString(from = Gravity.RIGHT,             to = "RIGHT"),
            @ViewDebug.IntToString(from = Gravity.START,            to = "START"),
            @ViewDebug.IntToString(from = Gravity.END,             to = "END"),
            @ViewDebug.IntToString(from = Gravity.CENTER_VERTICAL,   to = "CENTER_VERTICAL"),
            @ViewDebug.IntToString(from = Gravity.FILL_VERTICAL,     to = "FILL_VERTICAL"),
            @ViewDebug.IntToString(from = Gravity.CENTER_HORIZONTAL, to = "CENTER_HORIZONTAL"),
            @ViewDebug.IntToString(from = Gravity.FILL_HORIZONTAL,   to = "FILL_HORIZONTAL"),
            @ViewDebug.IntToString(from = Gravity.CENTER,            to = "CENTER"),
            @ViewDebug.IntToString(from = Gravity.FILL,              to = "FILL")
        }) public int gravity = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.155 -0400", hash_original_method = "C424BD779148A2828DEB0ABC94DCC73C", hash_generated_method = "CBEABF9A820F58D768BE5945E181273A")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a = c.obtainStyledAttributes(attrs, com.android.internal.R.styleable.LinearLayout_Layout);
            weight = a.getFloat(com.android.internal.R.styleable.LinearLayout_Layout_layout_weight, 0);
            gravity = a.getInt(com.android.internal.R.styleable.LinearLayout_Layout_layout_gravity, -1);
            a.recycle();
            addTaint(c.getTaint());
            addTaint(attrs.getTaint());
            
            
                    
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.155 -0400", hash_original_method = "5675045EFCD4661F32116909A9822399", hash_generated_method = "13653ECE503E7E958B6B0343131C8A7C")
        public  LayoutParams(int width, int height) {
            super(width, height);
            weight = 0;
            addTaint(width);
            addTaint(height);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.156 -0400", hash_original_method = "4CDC4D1E7FEEFBC37A8F4BABF983F00D", hash_generated_method = "570550A708822B75490AA0A4DA8AB602")
        public  LayoutParams(int width, int height, float weight) {
            super(width, height);
            this.weight = weight;
            addTaint(width);
            addTaint(height);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.156 -0400", hash_original_method = "DE4ED36682A1028E303BDCC28A48E06F", hash_generated_method = "66B55E9EFECAB48B3D28D153941B8308")
        public  LayoutParams(ViewGroup.LayoutParams p) {
            super(p);
            addTaint(p.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.156 -0400", hash_original_method = "CC87BD4B8C067788FA2BA37DBA116F62", hash_generated_method = "BDFD9CE52FB4D6304CCFF1CA731BA0A9")
        public  LayoutParams(MarginLayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.157 -0400", hash_original_method = "09BB09F623D63D4B2B1AF033D2D5C9B4", hash_generated_method = "AA52E56B729211B8F73C2BF5AB7E0D92")
        @Override
        public String debug(String output) {
            String varB4EAC82CA7396A68D541C85D26508E83_1523348801 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1523348801 = output + "LinearLayout.LayoutParams={width=" + sizeToString(width) +
                    ", height=" + sizeToString(height) + " weight=" + weight +  "}";
            addTaint(output.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1523348801.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1523348801;
            
            
                    
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.157 -0400", hash_original_field = "10CC209974739317E961EBD041018581", hash_generated_field = "AC2205EFFDAF899686D059A4EFB7832E")

    public static final int HORIZONTAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.157 -0400", hash_original_field = "B9A581C9879D3D62C7911745C0873959", hash_generated_field = "91DAF494B5C30478B3C457C5B0180E08")

    public static final int VERTICAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.157 -0400", hash_original_field = "8E79999F9F33DFB3FEA79372A82665CC", hash_generated_field = "0C5B8E328FB66A18A43839866930E8D4")

    public static final int SHOW_DIVIDER_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.157 -0400", hash_original_field = "A32E55A167CB9B1767289058C30ADA8B", hash_generated_field = "1DD6C5FF6610D03904D40069FE620989")

    public static final int SHOW_DIVIDER_BEGINNING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.157 -0400", hash_original_field = "B89CD3C872738F0B2E6C2ED3A7D520A1", hash_generated_field = "BA257B3BA3E7775EC6015D8CAB979002")

    public static final int SHOW_DIVIDER_MIDDLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.157 -0400", hash_original_field = "6DCA5BAE6370E56F53BB44B9146BA598", hash_generated_field = "DD4A6080B5F419CDA74F877B1348BFA3")

    public static final int SHOW_DIVIDER_END = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.157 -0400", hash_original_field = "D50D1954CC86BCF359A31F9E0FA36B86", hash_generated_field = "2ADB96257BCF6B94BEB08B7C805F3758")

    private static final int VERTICAL_GRAVITY_COUNT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.157 -0400", hash_original_field = "D29FEE3A1F7E065383FB6F36F4BE0ED7", hash_generated_field = "32CFAC2C2333762286EED0DC09E96431")

    private static final int INDEX_CENTER_VERTICAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.157 -0400", hash_original_field = "ED03692D3867A1965A1652C9AEAD08BC", hash_generated_field = "E642F731D98BFDC57447B50CB016F9AF")

    private static final int INDEX_TOP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.157 -0400", hash_original_field = "BD7D4E77C2437CF6BE5DE22C27EBF700", hash_generated_field = "FA5DBFD73C51FA836CD354A2027A09D5")

    private static final int INDEX_BOTTOM = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.157 -0400", hash_original_field = "CB9D90A00CF11F5A0D279367FF293389", hash_generated_field = "9750C44AFBABD80C054265737A88ED08")

    private static final int INDEX_FILL = 3;
}

