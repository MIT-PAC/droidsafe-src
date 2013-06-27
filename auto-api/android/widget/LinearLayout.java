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
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.RemoteViews.RemoteView;

public class LinearLayout extends ViewGroup {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.286 -0400", hash_original_field = "C4AC870B117F9377D557E108C2F5864C", hash_generated_field = "49EF932FC6F54346B0D68DBE32BC1514")

    @ViewDebug.ExportedProperty(category = "layout") private boolean mBaselineAligned = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.286 -0400", hash_original_field = "C4FA8C15F1496E5D4914A441B3EF4877", hash_generated_field = "9479D6BEF70B8D911DE1D3E00E354445")

    @ViewDebug.ExportedProperty(category = "layout") private int mBaselineAlignedChildIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.286 -0400", hash_original_field = "74E8B6E6B0FDC4F4D8852726B0CC3BAD", hash_generated_field = "44D10AD5ECEE597BECDD4FB40534DC17")

    @ViewDebug.ExportedProperty(category = "measurement") private int mBaselineChildTop = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.287 -0400", hash_original_field = "7EA67827B94D10D1A4B368659EA63B71", hash_generated_field = "3C6DDBEC00F7F6467812B81CEA371C07")

    @ViewDebug.ExportedProperty(category = "measurement") private int mOrientation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.287 -0400", hash_original_field = "964B8A9513C01B9AF2664D1A54E32EEA", hash_generated_field = "EE266283EE900FDD2432D031F7395357")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.287 -0400", hash_original_field = "43703A9421153843DA88A5EE2D1672A0", hash_generated_field = "DE3BC85B85ECB21DC64AEE79C7BD6AB4")

    @ViewDebug.ExportedProperty(category = "measurement") private int mTotalLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.287 -0400", hash_original_field = "0B41BD4353E911E2EC90D6CA263443B7", hash_generated_field = "EF9873241C2DA21073158F3890B03884")

    @ViewDebug.ExportedProperty(category = "layout") private float mWeightSum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.287 -0400", hash_original_field = "0C8E174FC05FB87AC9CC0DB60A352BB7", hash_generated_field = "295836EFFBA80C7933F8A212CF2A587C")

    @ViewDebug.ExportedProperty(category = "layout") private boolean mUseLargestChild;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.287 -0400", hash_original_field = "091770C374CE70054C190C0FB419201A", hash_generated_field = "EAE955816B4A7ECE00EA7D8113667D8A")

    private int[] mMaxAscent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.287 -0400", hash_original_field = "54405F87D6BC3932D04A1754A96D3A3D", hash_generated_field = "59DC29D31F14D9C75D4CE10DB2E42CAF")

    private int[] mMaxDescent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.287 -0400", hash_original_field = "F2EB92D46BFACFA75ABCA33DC6179915", hash_generated_field = "D73292FD603C307DCBB538076F31C80F")

    private Drawable mDivider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.287 -0400", hash_original_field = "2CFB9EB3B0B1B519D9DE96130629CD90", hash_generated_field = "57640F4296EC1DBBA1FC773929C31009")

    private int mDividerWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.287 -0400", hash_original_field = "FDC96C666CAD9FBF2EF59762861622A0", hash_generated_field = "D39F10261E466E88A7BE2C17E757ADFE")

    private int mDividerHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.287 -0400", hash_original_field = "570DF19833C5FFBC7225A5E90145E2AD", hash_generated_field = "1313B8BA9906A262CF63E7F9653AB503")

    private int mShowDividers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.287 -0400", hash_original_field = "009CC63A514E465A3A03D8B8E546A1D2", hash_generated_field = "8407F81B00C5F4756EECF88D42950A05")

    private int mDividerPadding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.287 -0400", hash_original_method = "FE94B0C3331DC48DD922B45C9927A2E5", hash_generated_method = "5599C5BD2C841CC6FACAC31E386AB809")
    public  LinearLayout(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.292 -0400", hash_original_method = "90765D7AD39C5FFE28F827609E4D9AAF", hash_generated_method = "3EBE68191C4C2BC4D01EADD3696A2D6C")
    public  LinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.294 -0400", hash_original_method = "CABCB619C04E154CCE92AB7E91451BB7", hash_generated_method = "4C7CF60AB31FE2DFC37EB4536FE5D926")
    public  LinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.LinearLayout, defStyle, 0);
        int index;
        index = a.getInt(com.android.internal.R.styleable.LinearLayout_orientation, -1);
        {
            setOrientation(index);
        } //End block
        index = a.getInt(com.android.internal.R.styleable.LinearLayout_gravity, -1);
        {
            setGravity(index);
        } //End block
        boolean baselineAligned;
        baselineAligned = a.getBoolean(R.styleable.LinearLayout_baselineAligned, true);
        {
            setBaselineAligned(baselineAligned);
        } //End block
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.294 -0400", hash_original_method = "DE827128F1412AED640E145E58E9E69C", hash_generated_method = "FAA302745E69D3FEC3B40DEBEDFE410F")
    public void setShowDividers(int showDividers) {
        {
            requestLayout();
        } //End block
        mShowDividers = showDividers;
        // ---------- Original Method ----------
        //if (showDividers != mShowDividers) {
            //requestLayout();
        //}
        //mShowDividers = showDividers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.300 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "16D360BAF9D7FE722FE05BB5077AD12C")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_960605754 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_960605754;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.304 -0400", hash_original_method = "81C750B99B14EF38CA21D36808CD7086", hash_generated_method = "BFA16EF214EDBA8CEB31433E6D496FEC")
    public int getShowDividers() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080218384 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080218384;
        // ---------- Original Method ----------
        //return mShowDividers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.309 -0400", hash_original_method = "7357A0D71E9A27E2C8DA29FA77A144AF", hash_generated_method = "C7D7FB39733171DDB03A67C46B5795DC")
    public void setDividerDrawable(Drawable divider) {
        mDivider = divider;
        {
            mDividerWidth = divider.getIntrinsicWidth();
            mDividerHeight = divider.getIntrinsicHeight();
        } //End block
        {
            mDividerWidth = 0;
            mDividerHeight = 0;
        } //End block
        setWillNotDraw(divider == null);
        requestLayout();
        // ---------- Original Method ----------
        //if (divider == mDivider) {
            //return;
        //}
        //mDivider = divider;
        //if (divider != null) {
            //mDividerWidth = divider.getIntrinsicWidth();
            //mDividerHeight = divider.getIntrinsicHeight();
        //} else {
            //mDividerWidth = 0;
            //mDividerHeight = 0;
        //}
        //setWillNotDraw(divider == null);
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.310 -0400", hash_original_method = "E2E4F4C3D603F5F2D62C3F5CBAFDCC06", hash_generated_method = "21B19108F063ADDE197FAB8209A2015F")
    public void setDividerPadding(int padding) {
        mDividerPadding = padding;
        // ---------- Original Method ----------
        //mDividerPadding = padding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.310 -0400", hash_original_method = "2F70F7AA30D3819DCD53286185A1CA49", hash_generated_method = "135FAE3E0817F35F356273E6889D90EA")
    public int getDividerPadding() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2057670016 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2057670016;
        // ---------- Original Method ----------
        //return mDividerPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.311 -0400", hash_original_method = "4DCD95C01B6B6891D72266EBA61909DF", hash_generated_method = "8C30FDCE83B80FC20796682968352BF7")
    public int getDividerWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858850597 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858850597;
        // ---------- Original Method ----------
        //return mDividerWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.311 -0400", hash_original_method = "4D234859DAD3D7D2BD3ABC15BDBCF93C", hash_generated_method = "EA0F424986F5F82EE98B75D81D726482")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            drawDividersVertical(canvas);
        } //End block
        {
            drawDividersHorizontal(canvas);
        } //End block
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        //if (mDivider == null) {
            //return;
        //}
        //if (mOrientation == VERTICAL) {
            //drawDividersVertical(canvas);
        //} else {
            //drawDividersHorizontal(canvas);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.317 -0400", hash_original_method = "6F9B50C05500D3423B595FD6EF29F0C0", hash_generated_method = "9EC9D5163D365E3EB87744334AF6B6A6")
     void drawDividersVertical(Canvas canvas) {
        int count;
        count = getVirtualChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = getVirtualChildAt(i);
                {
                    boolean varAD445368CB7F7DFBCAA93AD5AAA408ED_1599396070 = (child != null && child.getVisibility() != GONE);
                    {
                        {
                            boolean var5753280A391A92BDB591E4FED1D40DAB_2009760248 = (hasDividerBeforeChildAt(i));
                            {
                                LayoutParams lp;
                                lp = (LayoutParams) child.getLayoutParams();
                                int top;
                                top = child.getTop() - lp.topMargin;
                                drawHorizontalDivider(canvas, top);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var48BF1E2FEB752C0437BBA766958C3F15_711061883 = (hasDividerBeforeChildAt(count));
            {
                View child;
                child = getVirtualChildAt(count - 1);
                int bottom;
                bottom = 0;
                {
                    bottom = getHeight() - getPaddingBottom() - mDividerHeight;
                } //End block
                {
                    LayoutParams lp;
                    lp = (LayoutParams) child.getLayoutParams();
                    bottom = child.getBottom() + lp.bottomMargin;
                } //End block
                drawHorizontalDivider(canvas, bottom);
            } //End block
        } //End collapsed parenthetic
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.327 -0400", hash_original_method = "86833A485E8343AB391A7321B35B1538", hash_generated_method = "C39F7EF2759BA9F331235F57CEB956F4")
     void drawDividersHorizontal(Canvas canvas) {
        int count;
        count = getVirtualChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = getVirtualChildAt(i);
                {
                    boolean varAD445368CB7F7DFBCAA93AD5AAA408ED_509700216 = (child != null && child.getVisibility() != GONE);
                    {
                        {
                            boolean var5753280A391A92BDB591E4FED1D40DAB_1621545994 = (hasDividerBeforeChildAt(i));
                            {
                                LayoutParams lp;
                                lp = (LayoutParams) child.getLayoutParams();
                                int left;
                                left = child.getLeft() - lp.leftMargin;
                                drawVerticalDivider(canvas, left);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var48BF1E2FEB752C0437BBA766958C3F15_588241892 = (hasDividerBeforeChildAt(count));
            {
                View child;
                child = getVirtualChildAt(count - 1);
                int right;
                right = 0;
                {
                    right = getWidth() - getPaddingRight() - mDividerWidth;
                } //End block
                {
                    LayoutParams lp;
                    lp = (LayoutParams) child.getLayoutParams();
                    right = child.getRight() + lp.rightMargin;
                } //End block
                drawVerticalDivider(canvas, right);
            } //End block
        } //End collapsed parenthetic
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.327 -0400", hash_original_method = "B34FB2DB2BC7F90A8C4BCDC4C5D2422E", hash_generated_method = "5FB3124BBD0B3867543A8BAE6BBB72C3")
     void drawHorizontalDivider(Canvas canvas, int top) {
        mDivider.setBounds(getPaddingLeft() + mDividerPadding, top,
                getWidth() - getPaddingRight() - mDividerPadding, top + mDividerHeight);
        mDivider.draw(canvas);
        addTaint(canvas.getTaint());
        addTaint(top);
        // ---------- Original Method ----------
        //mDivider.setBounds(getPaddingLeft() + mDividerPadding, top,
                //getWidth() - getPaddingRight() - mDividerPadding, top + mDividerHeight);
        //mDivider.draw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.332 -0400", hash_original_method = "230D2DD24F19D940DC30A0FCA2C380AD", hash_generated_method = "DFB1F7777C357FC332037B845BC0A0E5")
     void drawVerticalDivider(Canvas canvas, int left) {
        mDivider.setBounds(left, getPaddingTop() + mDividerPadding,
                left + mDividerWidth, getHeight() - getPaddingBottom() - mDividerPadding);
        mDivider.draw(canvas);
        addTaint(canvas.getTaint());
        addTaint(left);
        // ---------- Original Method ----------
        //mDivider.setBounds(left, getPaddingTop() + mDividerPadding,
                //left + mDividerWidth, getHeight() - getPaddingBottom() - mDividerPadding);
        //mDivider.draw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.332 -0400", hash_original_method = "F54465AC5542CF519D3902E7BAEA3188", hash_generated_method = "EB41DE2C6D65A3BF26648F4CF7490E4D")
    public boolean isBaselineAligned() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2017367834 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2017367834;
        // ---------- Original Method ----------
        //return mBaselineAligned;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.337 -0400", hash_original_method = "8643C35E200A9ECC6F4D083B3C632ADD", hash_generated_method = "F5B36677A19813656057576482BE895F")
    @android.view.RemotableViewMethod
    public void setBaselineAligned(boolean baselineAligned) {
        mBaselineAligned = baselineAligned;
        // ---------- Original Method ----------
        //mBaselineAligned = baselineAligned;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.338 -0400", hash_original_method = "49EB4E4C3BC63D2BEAA8F5D24053BB96", hash_generated_method = "5DF5A0844A1C5A0F82AEF2AC7B4461CD")
    public boolean isMeasureWithLargestChildEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_118281634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_118281634;
        // ---------- Original Method ----------
        //return mUseLargestChild;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.338 -0400", hash_original_method = "55BFE46AC305D5ECEC6F564C443E4CAB", hash_generated_method = "F0D8B5D04B16B58DE2D6932713E4CAD4")
    @android.view.RemotableViewMethod
    public void setMeasureWithLargestChildEnabled(boolean enabled) {
        mUseLargestChild = enabled;
        // ---------- Original Method ----------
        //mUseLargestChild = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.340 -0400", hash_original_method = "8677A7AE77B37457B2CE24BC40A0B2AA", hash_generated_method = "EAC4A44BAADEB704A5C37EFA10DB39DF")
    @Override
    public int getBaseline() {
        {
            int varEC5F70FA49520212A319ACA653FC0209_1469376256 = (super.getBaseline());
        } //End block
        {
            boolean var0CC14488A448130ACFEBA1F25FFBD58A_1777213092 = (getChildCount() <= mBaselineAlignedChildIndex);
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout "
                    + "set to an index that is out of bounds.");
            } //End block
        } //End collapsed parenthetic
        View child;
        child = getChildAt(mBaselineAlignedChildIndex);
        int childBaseline;
        childBaseline = child.getBaseline();
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout "
                    + "points to a View that doesn't know how to get its baseline.");
        } //End block
        int childTop;
        childTop = mBaselineChildTop;
        {
            int majorGravity;
            majorGravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
            {
                //Begin case Gravity.BOTTOM 
                childTop = mBottom - mTop - mPaddingBottom - mTotalLength;
                //End case Gravity.BOTTOM 
                //Begin case Gravity.CENTER_VERTICAL 
                childTop += ((mBottom - mTop - mPaddingTop - mPaddingBottom) -
                               mTotalLength) / 2;
                //End case Gravity.CENTER_VERTICAL 
            } //End block
        } //End block
        LinearLayout.LayoutParams lp;
        lp = (LinearLayout.LayoutParams) child.getLayoutParams();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_360209625 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_360209625;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.340 -0400", hash_original_method = "90F550BFDC49A6587A7A8440E339A132", hash_generated_method = "722724B250932EC3B37257CA406BC18D")
    public int getBaselineAlignedChildIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_672879052 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_672879052;
        // ---------- Original Method ----------
        //return mBaselineAlignedChildIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.342 -0400", hash_original_method = "4CFC93DB175F8874B4EFFA335793DCB8", hash_generated_method = "8A57FDF64773AC4A2D2AA490BECD0D26")
    @android.view.RemotableViewMethod
    public void setBaselineAlignedChildIndex(int i) {
        {
            boolean varE9CD64879C792E1B66A251BAB70D8B08_706949431 = ((i < 0) || (i >= getChildCount()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("base aligned child index out "
                    + "of range (0, " + getChildCount() + ")");
            } //End block
        } //End collapsed parenthetic
        mBaselineAlignedChildIndex = i;
        // ---------- Original Method ----------
        //if ((i < 0) || (i >= getChildCount())) {
            //throw new IllegalArgumentException("base aligned child index out "
                    //+ "of range (0, " + getChildCount() + ")");
        //}
        //mBaselineAlignedChildIndex = i;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.349 -0400", hash_original_method = "87FE8C209A68A97BDFF0666E4CF673D3", hash_generated_method = "87DB0B0E34CFDC00B9CAB8DFAA84445F")
     View getVirtualChildAt(int index) {
        View varB4EAC82CA7396A68D541C85D26508E83_796747196 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_796747196 = getChildAt(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_796747196.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_796747196;
        // ---------- Original Method ----------
        //return getChildAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.353 -0400", hash_original_method = "04A766EF9FA40CCD4344368D3178C5E7", hash_generated_method = "E816B4EF548F2EDCE85F2DAF88FE46EC")
     int getVirtualChildCount() {
        int varF41158137001188D2F9D08127BFB39DA_858837672 = (getChildCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_866642356 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_866642356;
        // ---------- Original Method ----------
        //return getChildCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.356 -0400", hash_original_method = "131E7E20664E8B649BC33F0915A0DE0D", hash_generated_method = "B9A863E7D31A9561EA83AE4E421E1559")
    public float getWeightSum() {
        float var546ADE640B6EDFBC8A086EF31347E768_2025297218 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2025297218;
        // ---------- Original Method ----------
        //return mWeightSum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.356 -0400", hash_original_method = "47922B5280E89B2CF9B73D66705F0A8D", hash_generated_method = "0C909C9A2C5340B2F81C58E12B1C7283")
    @android.view.RemotableViewMethod
    public void setWeightSum(float weightSum) {
        mWeightSum = Math.max(0.0f, weightSum);
        // ---------- Original Method ----------
        //mWeightSum = Math.max(0.0f, weightSum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.364 -0400", hash_original_method = "3F3B158F407FDE6BDDE91ED473E376D3", hash_generated_method = "E572AC246BCA803DBDD629DE2DB04BF7")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            measureVertical(widthMeasureSpec, heightMeasureSpec);
        } //End block
        {
            measureHorizontal(widthMeasureSpec, heightMeasureSpec);
        } //End block
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        //if (mOrientation == VERTICAL) {
            //measureVertical(widthMeasureSpec, heightMeasureSpec);
        //} else {
            //measureHorizontal(widthMeasureSpec, heightMeasureSpec);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.365 -0400", hash_original_method = "E4A04FCA37D7E9FFFC1F15D63F30923E", hash_generated_method = "39E8A12523AE0AD10990BF8C10D70F21")
    protected boolean hasDividerBeforeChildAt(int childIndex) {
        {
            boolean var042391D18CFAA58040C07325508C3E5D_1581446547 = (childIndex == getChildCount());
            {
                boolean hasVisibleViewBefore;
                hasVisibleViewBefore = false;
                {
                    int i;
                    i = childIndex - 1;
                    {
                        {
                            boolean var849B37533740585CFE18F837DD2EDAAB_231675714 = (getChildAt(i).getVisibility() != GONE);
                            {
                                hasVisibleViewBefore = true;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(childIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_875161520 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_875161520;
        // ---------- Original Method ----------
        //if (childIndex == 0) {
            //return (mShowDividers & SHOW_DIVIDER_BEGINNING) != 0;
        //} else if (childIndex == getChildCount()) {
            //return (mShowDividers & SHOW_DIVIDER_END) != 0;
        //} else if ((mShowDividers & SHOW_DIVIDER_MIDDLE) != 0) {
            //boolean hasVisibleViewBefore = false;
            //for (int i = childIndex - 1; i >= 0; i--) {
                //if (getChildAt(i).getVisibility() != GONE) {
                    //hasVisibleViewBefore = true;
                    //break;
                //}
            //}
            //return hasVisibleViewBefore;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.392 -0400", hash_original_method = "A88B972B81C9E0D927EB1FAC25F8F6D1", hash_generated_method = "8D9FDC02A4C4258CD4B1A397F06CDD44")
     void measureVertical(int widthMeasureSpec, int heightMeasureSpec) {
        mTotalLength = 0;
        int maxWidth;
        maxWidth = 0;
        int childState;
        childState = 0;
        int alternativeMaxWidth;
        alternativeMaxWidth = 0;
        int weightedMaxWidth;
        weightedMaxWidth = 0;
        boolean allFillParent;
        allFillParent = true;
        float totalWeight;
        totalWeight = 0;
        int count;
        count = getVirtualChildCount();
        int widthMode;
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode;
        heightMode = MeasureSpec.getMode(heightMeasureSpec);
        boolean matchWidth;
        matchWidth = false;
        int baselineChildIndex;
        baselineChildIndex = mBaselineAlignedChildIndex;
        boolean useLargestChild;
        useLargestChild = mUseLargestChild;
        int largestChildHeight;
        largestChildHeight = Integer.MIN_VALUE;
        {
            int i;
            i = 0;
            {
                View child;
                child = getVirtualChildAt(i);
                {
                    mTotalLength += measureNullChild(i);
                } //End block
                {
                    boolean varAE94D5328E94C6606865B35993EDD564_657559960 = (child.getVisibility() == View.GONE);
                    {
                        i += getChildrenSkipCount(child, i);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var53CA14277C14EA37C3E2B0E1BF193AF9_1014246810 = (hasDividerBeforeChildAt(i));
                    {
                        mTotalLength += mDividerHeight;
                    } //End block
                } //End collapsed parenthetic
                LinearLayout.LayoutParams lp;
                lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                totalWeight += lp.weight;
                {
                    int totalLength;
                    totalLength = mTotalLength;
                    mTotalLength = Math.max(totalLength, totalLength + lp.topMargin + lp.bottomMargin);
                } //End block
                {
                    int oldHeight;
                    oldHeight = Integer.MIN_VALUE;
                    {
                        oldHeight = 0;
                        lp.height = LayoutParams.WRAP_CONTENT;
                    } //End block
                    measureChildBeforeLayout(
                       child, i, widthMeasureSpec, 0, heightMeasureSpec,
                       totalWeight == 0 ? mTotalLength : 0);
                    {
                        lp.height = oldHeight;
                    } //End block
                    int childHeight;
                    childHeight = child.getMeasuredHeight();
                    int totalLength;
                    totalLength = mTotalLength;
                    mTotalLength = Math.max(totalLength, totalLength + childHeight + lp.topMargin +
                       lp.bottomMargin + getNextLocationOffset(child));
                    {
                        largestChildHeight = Math.max(childHeight, largestChildHeight);
                    } //End block
                } //End block
                {
                    mBaselineChildTop = mTotalLength;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("A child of LinearLayout with index "
                        + "less than mBaselineAlignedChildIndex has weight > 0, which "
                        + "won't work.  Either remove the weight, or don't set "
                        + "mBaselineAlignedChildIndex.");
                } //End block
                boolean matchWidthLocally;
                matchWidthLocally = false;
                {
                    matchWidth = true;
                    matchWidthLocally = true;
                } //End block
                int margin;
                margin = lp.leftMargin + lp.rightMargin;
                int measuredWidth;
                measuredWidth = child.getMeasuredWidth() + margin;
                maxWidth = Math.max(maxWidth, measuredWidth);
                childState = combineMeasuredStates(childState, child.getMeasuredState());
                allFillParent = allFillParent && lp.width == LayoutParams.MATCH_PARENT;
                {
                    weightedMaxWidth = Math.max(weightedMaxWidth,
                        matchWidthLocally ? margin : measuredWidth);
                } //End block
                {
                    alternativeMaxWidth = Math.max(alternativeMaxWidth,
                        matchWidthLocally ? margin : measuredWidth);
                } //End block
                i += getChildrenSkipCount(child, i);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCC0767313899D8044991C6ED676480A0_42057305 = (mTotalLength > 0 && hasDividerBeforeChildAt(count));
            {
                mTotalLength += mDividerHeight;
            } //End block
        } //End collapsed parenthetic
        {
            mTotalLength = 0;
            {
                int i;
                i = 0;
                {
                    View child;
                    child = getVirtualChildAt(i);
                    {
                        mTotalLength += measureNullChild(i);
                    } //End block
                    {
                        boolean var24A8049355A2DBEE0F9FC0F85F3CAA64_2080746568 = (child.getVisibility() == GONE);
                        {
                            i += getChildrenSkipCount(child, i);
                        } //End block
                    } //End collapsed parenthetic
                    LinearLayout.LayoutParams lp;
                    lp = (LinearLayout.LayoutParams)
                        child.getLayoutParams();
                    int totalLength;
                    totalLength = mTotalLength;
                    mTotalLength = Math.max(totalLength, totalLength + largestChildHeight +
                        lp.topMargin + lp.bottomMargin + getNextLocationOffset(child));
                } //End block
            } //End collapsed parenthetic
        } //End block
        mTotalLength += mPaddingTop + mPaddingBottom;
        int heightSize;
        heightSize = mTotalLength;
        heightSize = Math.max(heightSize, getSuggestedMinimumHeight());
        int heightSizeAndState;
        heightSizeAndState = resolveSizeAndState(heightSize, heightMeasureSpec, 0);
        heightSize = heightSizeAndState & MEASURED_SIZE_MASK;
        int delta;
        delta = heightSize - mTotalLength;
        {
            float weightSum;
            weightSum = mWeightSum;
            weightSum = totalWeight;
            mTotalLength = 0;
            {
                int i;
                i = 0;
                {
                    View child;
                    child = getVirtualChildAt(i);
                    {
                        boolean varCE5DD5D436329456ACE82D8F3349CC31_1772616211 = (child.getVisibility() == View.GONE);
                    } //End collapsed parenthetic
                    LinearLayout.LayoutParams lp;
                    lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                    float childExtra;
                    childExtra = lp.weight;
                    {
                        int share;
                        share = (int) (childExtra * delta / weightSum);
                        weightSum -= childExtra;
                        delta -= share;
                        int childWidthMeasureSpec;
                        childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec,
                            mPaddingLeft + mPaddingRight +
                                    lp.leftMargin + lp.rightMargin, lp.width);
                        {
                            int childHeight;
                            childHeight = child.getMeasuredHeight() + share;
                            {
                                childHeight = 0;
                            } //End block
                            child.measure(childWidthMeasureSpec,
                                MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY));
                        } //End block
                        {
                            child.measure(childWidthMeasureSpec,
                                MeasureSpec.makeMeasureSpec(share > 0 ? share : 0,
                                        MeasureSpec.EXACTLY));
                        } //End block
                        childState = combineMeasuredStates(childState, child.getMeasuredState()
                            & (MEASURED_STATE_MASK>>MEASURED_HEIGHT_STATE_SHIFT));
                    } //End block
                    int margin;
                    margin = lp.leftMargin + lp.rightMargin;
                    int measuredWidth;
                    measuredWidth = child.getMeasuredWidth() + margin;
                    maxWidth = Math.max(maxWidth, measuredWidth);
                    boolean matchWidthLocally;
                    matchWidthLocally = widthMode != MeasureSpec.EXACTLY &&
                        lp.width == LayoutParams.MATCH_PARENT;
                    alternativeMaxWidth = Math.max(alternativeMaxWidth,
                        matchWidthLocally ? margin : measuredWidth);
                    allFillParent = allFillParent && lp.width == LayoutParams.MATCH_PARENT;
                    int totalLength;
                    totalLength = mTotalLength;
                    mTotalLength = Math.max(totalLength, totalLength + child.getMeasuredHeight() +
                        lp.topMargin + lp.bottomMargin + getNextLocationOffset(child));
                } //End block
            } //End collapsed parenthetic
            mTotalLength += mPaddingTop + mPaddingBottom;
        } //End block
        {
            alternativeMaxWidth = Math.max(alternativeMaxWidth,
                                           weightedMaxWidth);
            {
                {
                    int i;
                    i = 0;
                    {
                        View child;
                        child = getVirtualChildAt(i);
                        {
                            boolean varE7BB3503787C529D329422F9519818AF_408306940 = (child == null || child.getVisibility() == View.GONE);
                        } //End collapsed parenthetic
                        LinearLayout.LayoutParams lp;
                        lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                        float childExtra;
                        childExtra = lp.weight;
                        {
                            child.measure(
                                MeasureSpec.makeMeasureSpec(child.getMeasuredWidth(),
                                        MeasureSpec.EXACTLY),
                                MeasureSpec.makeMeasureSpec(largestChildHeight,
                                        MeasureSpec.EXACTLY));
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            maxWidth = alternativeMaxWidth;
        } //End block
        maxWidth += mPaddingLeft + mPaddingRight;
        maxWidth = Math.max(maxWidth, getSuggestedMinimumWidth());
        setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, childState),
                heightSizeAndState);
        {
            forceUniformWidth(count, heightMeasureSpec);
        } //End block
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.395 -0400", hash_original_method = "AFA9034D947EBEF26850BC0782F132F9", hash_generated_method = "2CF8BE8CC42E4178BC2679BBC03376B6")
    private void forceUniformWidth(int count, int heightMeasureSpec) {
        int uniformMeasureSpec;
        uniformMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(),
                MeasureSpec.EXACTLY);
        {
            int i;
            i = 0;
            {
                View child;
                child = getVirtualChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_188083797 = (child.getVisibility() != GONE);
                    {
                        LinearLayout.LayoutParams lp;
                        lp = ((LinearLayout.LayoutParams)child.getLayoutParams());
                        {
                            int oldHeight;
                            oldHeight = lp.height;
                            lp.height = child.getMeasuredHeight();
                            measureChildWithMargins(child, uniformMeasureSpec, 0, heightMeasureSpec, 0);
                            lp.height = oldHeight;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(count);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        //int uniformMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(),
                //MeasureSpec.EXACTLY);
        //for (int i = 0; i< count; ++i) {
           //final View child = getVirtualChildAt(i);
           //if (child.getVisibility() != GONE) { 
               //LinearLayout.LayoutParams lp = ((LinearLayout.LayoutParams)child.getLayoutParams());
               //if (lp.width == LayoutParams.MATCH_PARENT) {
                   //int oldHeight = lp.height;
                   //lp.height = child.getMeasuredHeight();
                   //measureChildWithMargins(child, uniformMeasureSpec, 0, heightMeasureSpec, 0);
                   //lp.height = oldHeight;
               //}
           //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.482 -0400", hash_original_method = "22C04BEEA310D9DB4A6BB8F3656099B0", hash_generated_method = "943D0EF3480DBF7A67525AEBA8EEE142")
     void measureHorizontal(int widthMeasureSpec, int heightMeasureSpec) {
        mTotalLength = 0;
        int maxHeight;
        maxHeight = 0;
        int childState;
        childState = 0;
        int alternativeMaxHeight;
        alternativeMaxHeight = 0;
        int weightedMaxHeight;
        weightedMaxHeight = 0;
        boolean allFillParent;
        allFillParent = true;
        float totalWeight;
        totalWeight = 0;
        int count;
        count = getVirtualChildCount();
        int widthMode;
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode;
        heightMode = MeasureSpec.getMode(heightMeasureSpec);
        boolean matchHeight;
        matchHeight = false;
        {
            mMaxAscent = new int[VERTICAL_GRAVITY_COUNT];
            mMaxDescent = new int[VERTICAL_GRAVITY_COUNT];
        } //End block
        int[] maxAscent;
        maxAscent = mMaxAscent;
        int[] maxDescent;
        maxDescent = mMaxDescent;
        maxAscent[0] = maxAscent[1] = maxAscent[2] = maxAscent[3] = -1;
        maxDescent[0] = maxDescent[1] = maxDescent[2] = maxDescent[3] = -1;
        boolean baselineAligned;
        baselineAligned = mBaselineAligned;
        boolean useLargestChild;
        useLargestChild = mUseLargestChild;
        boolean isExactly;
        isExactly = widthMode == MeasureSpec.EXACTLY;
        int largestChildWidth;
        largestChildWidth = Integer.MIN_VALUE;
        {
            int i;
            i = 0;
            {
                View child;
                child = getVirtualChildAt(i);
                {
                    mTotalLength += measureNullChild(i);
                } //End block
                {
                    boolean varE5A6421440835A22FD9C00B75E3D1565_1301907517 = (child.getVisibility() == GONE);
                    {
                        i += getChildrenSkipCount(child, i);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var53CA14277C14EA37C3E2B0E1BF193AF9_1954124572 = (hasDividerBeforeChildAt(i));
                    {
                        mTotalLength += mDividerWidth;
                    } //End block
                } //End collapsed parenthetic
                LinearLayout.LayoutParams lp;
                lp = (LinearLayout.LayoutParams)
                    child.getLayoutParams();
                totalWeight += lp.weight;
                {
                    {
                        mTotalLength += lp.leftMargin + lp.rightMargin;
                    } //End block
                    {
                        int totalLength;
                        totalLength = mTotalLength;
                        mTotalLength = Math.max(totalLength, totalLength +
                            lp.leftMargin + lp.rightMargin);
                    } //End block
                    {
                        int freeSpec;
                        freeSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                        child.measure(freeSpec, freeSpec);
                    } //End block
                } //End block
                {
                    int oldWidth;
                    oldWidth = Integer.MIN_VALUE;
                    {
                        oldWidth = 0;
                        lp.width = LayoutParams.WRAP_CONTENT;
                    } //End block
                    measureChildBeforeLayout(child, i, widthMeasureSpec,
                        totalWeight == 0 ? mTotalLength : 0,
                        heightMeasureSpec, 0);
                    {
                        lp.width = oldWidth;
                    } //End block
                    int childWidth;
                    childWidth = child.getMeasuredWidth();
                    {
                        mTotalLength += childWidth + lp.leftMargin + lp.rightMargin +
                            getNextLocationOffset(child);
                    } //End block
                    {
                        int totalLength;
                        totalLength = mTotalLength;
                        mTotalLength = Math.max(totalLength, totalLength + childWidth + lp.leftMargin +
                           lp.rightMargin + getNextLocationOffset(child));
                    } //End block
                    {
                        largestChildWidth = Math.max(childWidth, largestChildWidth);
                    } //End block
                } //End block
                boolean matchHeightLocally;
                matchHeightLocally = false;
                {
                    matchHeight = true;
                    matchHeightLocally = true;
                } //End block
                int margin;
                margin = lp.topMargin + lp.bottomMargin;
                int childHeight;
                childHeight = child.getMeasuredHeight() + margin;
                childState = combineMeasuredStates(childState, child.getMeasuredState());
                {
                    int childBaseline;
                    childBaseline = child.getBaseline();
                    {
                        int gravity;
                        gravity = (lp.gravity < 0 ? mGravity : lp.gravity)
                            & Gravity.VERTICAL_GRAVITY_MASK;//DSFIXME:  CODE0008: Nested ternary operator in expression
                        int index;
                        index = ((gravity >> Gravity.AXIS_Y_SHIFT)
                            & ~Gravity.AXIS_SPECIFIED) >> 1;
                        maxAscent[index] = Math.max(maxAscent[index], childBaseline);
                        maxDescent[index] = Math.max(maxDescent[index], childHeight - childBaseline);
                    } //End block
                } //End block
                maxHeight = Math.max(maxHeight, childHeight);
                allFillParent = allFillParent && lp.height == LayoutParams.MATCH_PARENT;
                {
                    weightedMaxHeight = Math.max(weightedMaxHeight,
                        matchHeightLocally ? margin : childHeight);
                } //End block
                {
                    alternativeMaxHeight = Math.max(alternativeMaxHeight,
                        matchHeightLocally ? margin : childHeight);
                } //End block
                i += getChildrenSkipCount(child, i);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCC0767313899D8044991C6ED676480A0_1272429444 = (mTotalLength > 0 && hasDividerBeforeChildAt(count));
            {
                mTotalLength += mDividerWidth;
            } //End block
        } //End collapsed parenthetic
        {
            int ascent;
            ascent = Math.max(maxAscent[INDEX_FILL],
                    Math.max(maxAscent[INDEX_CENTER_VERTICAL],
                    Math.max(maxAscent[INDEX_TOP], maxAscent[INDEX_BOTTOM])));
            int descent;
            descent = Math.max(maxDescent[INDEX_FILL],
                    Math.max(maxDescent[INDEX_CENTER_VERTICAL],
                    Math.max(maxDescent[INDEX_TOP], maxDescent[INDEX_BOTTOM])));
            maxHeight = Math.max(maxHeight, ascent + descent);
        } //End block
        {
            mTotalLength = 0;
            {
                int i;
                i = 0;
                {
                    View child;
                    child = getVirtualChildAt(i);
                    {
                        mTotalLength += measureNullChild(i);
                    } //End block
                    {
                        boolean var24A8049355A2DBEE0F9FC0F85F3CAA64_1487882530 = (child.getVisibility() == GONE);
                        {
                            i += getChildrenSkipCount(child, i);
                        } //End block
                    } //End collapsed parenthetic
                    LinearLayout.LayoutParams lp;
                    lp = (LinearLayout.LayoutParams)
                        child.getLayoutParams();
                    {
                        mTotalLength += largestChildWidth + lp.leftMargin + lp.rightMargin +
                            getNextLocationOffset(child);
                    } //End block
                    {
                        int totalLength;
                        totalLength = mTotalLength;
                        mTotalLength = Math.max(totalLength, totalLength + largestChildWidth +
                            lp.leftMargin + lp.rightMargin + getNextLocationOffset(child));
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        mTotalLength += mPaddingLeft + mPaddingRight;
        int widthSize;
        widthSize = mTotalLength;
        widthSize = Math.max(widthSize, getSuggestedMinimumWidth());
        int widthSizeAndState;
        widthSizeAndState = resolveSizeAndState(widthSize, widthMeasureSpec, 0);
        widthSize = widthSizeAndState & MEASURED_SIZE_MASK;
        int delta;
        delta = widthSize - mTotalLength;
        {
            float weightSum;
            weightSum = mWeightSum;
            weightSum = totalWeight;
            maxAscent[0] = maxAscent[1] = maxAscent[2] = maxAscent[3] = -1;
            maxDescent[0] = maxDescent[1] = maxDescent[2] = maxDescent[3] = -1;
            maxHeight = -1;
            mTotalLength = 0;
            {
                int i;
                i = 0;
                {
                    View child;
                    child = getVirtualChildAt(i);
                    {
                        boolean varF9B20D9EE469ED1FED42E2666426C840_437876335 = (child == null || child.getVisibility() == View.GONE);
                    } //End collapsed parenthetic
                    LinearLayout.LayoutParams lp;
                    lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                    float childExtra;
                    childExtra = lp.weight;
                    {
                        int share;
                        share = (int) (childExtra * delta / weightSum);
                        weightSum -= childExtra;
                        delta -= share;
                        int childHeightMeasureSpec;
                        childHeightMeasureSpec = getChildMeasureSpec(
                            heightMeasureSpec,
                            mPaddingTop + mPaddingBottom + lp.topMargin + lp.bottomMargin,
                            lp.height);
                        {
                            int childWidth;
                            childWidth = child.getMeasuredWidth() + share;
                            {
                                childWidth = 0;
                            } //End block
                            child.measure(
                            MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY),
                            childHeightMeasureSpec);
                        } //End block
                        {
                            child.measure(MeasureSpec.makeMeasureSpec(
                                share > 0 ? share : 0, MeasureSpec.EXACTLY),
                                childHeightMeasureSpec);
                        } //End block
                        childState = combineMeasuredStates(childState,
                            child.getMeasuredState() & MEASURED_STATE_MASK);
                    } //End block
                    {
                        mTotalLength += child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin +
                            getNextLocationOffset(child);
                    } //End block
                    {
                        int totalLength;
                        totalLength = mTotalLength;
                        mTotalLength = Math.max(totalLength, totalLength + child.getMeasuredWidth() +
                            lp.leftMargin + lp.rightMargin + getNextLocationOffset(child));
                    } //End block
                    boolean matchHeightLocally;
                    matchHeightLocally = heightMode != MeasureSpec.EXACTLY &&
                        lp.height == LayoutParams.MATCH_PARENT;
                    int margin;
                    margin = lp.topMargin + lp .bottomMargin;
                    int childHeight;
                    childHeight = child.getMeasuredHeight() + margin;
                    maxHeight = Math.max(maxHeight, childHeight);
                    alternativeMaxHeight = Math.max(alternativeMaxHeight,
                        matchHeightLocally ? margin : childHeight);
                    allFillParent = allFillParent && lp.height == LayoutParams.MATCH_PARENT;
                    {
                        int childBaseline;
                        childBaseline = child.getBaseline();
                        {
                            int gravity;
                            gravity = (lp.gravity < 0 ? mGravity : lp.gravity)
                                & Gravity.VERTICAL_GRAVITY_MASK;//DSFIXME:  CODE0008: Nested ternary operator in expression
                            int index;
                            index = ((gravity >> Gravity.AXIS_Y_SHIFT)
                                & ~Gravity.AXIS_SPECIFIED) >> 1;
                            maxAscent[index] = Math.max(maxAscent[index], childBaseline);
                            maxDescent[index] = Math.max(maxDescent[index],
                                childHeight - childBaseline);
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            mTotalLength += mPaddingLeft + mPaddingRight;
            {
                int ascent;
                ascent = Math.max(maxAscent[INDEX_FILL],
                        Math.max(maxAscent[INDEX_CENTER_VERTICAL],
                        Math.max(maxAscent[INDEX_TOP], maxAscent[INDEX_BOTTOM])));
                int descent;
                descent = Math.max(maxDescent[INDEX_FILL],
                        Math.max(maxDescent[INDEX_CENTER_VERTICAL],
                        Math.max(maxDescent[INDEX_TOP], maxDescent[INDEX_BOTTOM])));
                maxHeight = Math.max(maxHeight, ascent + descent);
            } //End block
        } //End block
        {
            alternativeMaxHeight = Math.max(alternativeMaxHeight, weightedMaxHeight);
            {
                {
                    int i;
                    i = 0;
                    {
                        View child;
                        child = getVirtualChildAt(i);
                        {
                            boolean varE7BB3503787C529D329422F9519818AF_7325047 = (child == null || child.getVisibility() == View.GONE);
                        } //End collapsed parenthetic
                        LinearLayout.LayoutParams lp;
                        lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                        float childExtra;
                        childExtra = lp.weight;
                        {
                            child.measure(
                                MeasureSpec.makeMeasureSpec(largestChildWidth, MeasureSpec.EXACTLY),
                                MeasureSpec.makeMeasureSpec(child.getMeasuredHeight(),
                                        MeasureSpec.EXACTLY));
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            maxHeight = alternativeMaxHeight;
        } //End block
        maxHeight += mPaddingTop + mPaddingBottom;
        maxHeight = Math.max(maxHeight, getSuggestedMinimumHeight());
        setMeasuredDimension(widthSizeAndState | (childState&MEASURED_STATE_MASK),
                resolveSizeAndState(maxHeight, heightMeasureSpec,
                        (childState<<MEASURED_HEIGHT_STATE_SHIFT)));
        {
            forceUniformHeight(count, widthMeasureSpec);
        } //End block
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.504 -0400", hash_original_method = "FDF33FE6741A819E3461023969653A29", hash_generated_method = "8B47DC8BC9B55A03742F84A1D9EC85BF")
    private void forceUniformHeight(int count, int widthMeasureSpec) {
        int uniformMeasureSpec;
        uniformMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(),
                MeasureSpec.EXACTLY);
        {
            int i;
            i = 0;
            {
                View child;
                child = getVirtualChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_1171956169 = (child.getVisibility() != GONE);
                    {
                        LinearLayout.LayoutParams lp;
                        lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                        {
                            int oldWidth;
                            oldWidth = lp.width;
                            lp.width = child.getMeasuredWidth();
                            measureChildWithMargins(child, widthMeasureSpec, 0, uniformMeasureSpec, 0);
                            lp.width = oldWidth;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(count);
        addTaint(widthMeasureSpec);
        // ---------- Original Method ----------
        //int uniformMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(),
                //MeasureSpec.EXACTLY);
        //for (int i = 0; i < count; ++i) {
           //final View child = getVirtualChildAt(i);
           //if (child.getVisibility() != GONE) { 
               //LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
               //if (lp.height == LayoutParams.MATCH_PARENT) {
                   //int oldWidth = lp.width;
                   //lp.width = child.getMeasuredWidth();
                   //measureChildWithMargins(child, widthMeasureSpec, 0, uniformMeasureSpec, 0);
                   //lp.width = oldWidth;
               //}
           //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.504 -0400", hash_original_method = "64CDF538399E47C38C21DACEFC8C1E08", hash_generated_method = "E020C6525C63CABDFDC9FBA4CDAE3BD0")
     int getChildrenSkipCount(View child, int index) {
        addTaint(child.getTaint());
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237058921 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237058921;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.504 -0400", hash_original_method = "0C791DFCDA5E7DFE7963EF393BDBDA11", hash_generated_method = "1B6EBA192304F8DAAF7BDBCA3DA20438")
     int measureNullChild(int childIndex) {
        addTaint(childIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1444352544 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1444352544;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.504 -0400", hash_original_method = "784157887C32A4B8D345E93BB13DEECA", hash_generated_method = "3CD9D429BD4B3D6B5F431E83EFD174DB")
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
        // ---------- Original Method ----------
        //measureChildWithMargins(child, widthMeasureSpec, totalWidth,
                //heightMeasureSpec, totalHeight);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.518 -0400", hash_original_method = "BA69BAE2E1D7A163D53D02D47016A6D7", hash_generated_method = "5EC767987B138A0C892B32F7C3121564")
     int getLocationOffset(View child) {
        addTaint(child.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_369578705 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_369578705;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.519 -0400", hash_original_method = "6D7A4F846C7E828D32B84605EE3B545F", hash_generated_method = "80E71ACDCD4F9B5C4547404C785D2F4B")
     int getNextLocationOffset(View child) {
        addTaint(child.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_899884984 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_899884984;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.519 -0400", hash_original_method = "38617BD257A07AF46AAF702E88FA7138", hash_generated_method = "B0A2BFC2F6C6A680B82583D6DC4BAE75")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            layoutVertical();
        } //End block
        {
            layoutHorizontal();
        } //End block
        addTaint(changed);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        // ---------- Original Method ----------
        //if (mOrientation == VERTICAL) {
            //layoutVertical();
        //} else {
            //layoutHorizontal();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.521 -0400", hash_original_method = "30B5FEA9EA0D751AC72456573A204452", hash_generated_method = "BFB6D533753610FD03A3BC3591350999")
     void layoutVertical() {
        int paddingLeft;
        paddingLeft = mPaddingLeft;
        int childTop;
        int childLeft;
        int width;
        width = mRight - mLeft;
        int childRight;
        childRight = width - mPaddingRight;
        int childSpace;
        childSpace = width - paddingLeft - mPaddingRight;
        int count;
        count = getVirtualChildCount();
        int majorGravity;
        majorGravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        int minorGravity;
        minorGravity = mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        //Begin case Gravity.BOTTOM 
        childTop = mPaddingTop + mBottom - mTop - mTotalLength;
        //End case Gravity.BOTTOM 
        //Begin case Gravity.CENTER_VERTICAL 
        childTop = mPaddingTop + (mBottom - mTop - mTotalLength) / 2;
        //End case Gravity.CENTER_VERTICAL 
        //Begin case Gravity.TOP default 
        childTop = mPaddingTop;
        //End case Gravity.TOP default 
        {
            int i;
            i = 0;
            {
                View child;
                child = getVirtualChildAt(i);
                {
                    childTop += measureNullChild(i);
                } //End block
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_681130636 = (child.getVisibility() != GONE);
                    {
                        int childWidth;
                        childWidth = child.getMeasuredWidth();
                        int childHeight;
                        childHeight = child.getMeasuredHeight();
                        LinearLayout.LayoutParams lp;
                        lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                        int gravity;
                        gravity = lp.gravity;
                        {
                            gravity = minorGravity;
                        } //End block
                        int layoutDirection;
                        layoutDirection = getResolvedLayoutDirection();
                        int absoluteGravity;
                        absoluteGravity = Gravity.getAbsoluteGravity(gravity, layoutDirection);
                        //Begin case Gravity.CENTER_HORIZONTAL 
                        childLeft = paddingLeft + ((childSpace - childWidth) / 2)
                                + lp.leftMargin - lp.rightMargin;
                        //End case Gravity.CENTER_HORIZONTAL 
                        //Begin case Gravity.RIGHT 
                        childLeft = childRight - childWidth - lp.rightMargin;
                        //End case Gravity.RIGHT 
                        //Begin case Gravity.LEFT default 
                        childLeft = paddingLeft + lp.leftMargin;
                        //End case Gravity.LEFT default 
                        {
                            boolean var5753280A391A92BDB591E4FED1D40DAB_1597053606 = (hasDividerBeforeChildAt(i));
                            {
                                childTop += mDividerHeight;
                            } //End block
                        } //End collapsed parenthetic
                        childTop += lp.topMargin;
                        setChildFrame(child, childLeft, childTop + getLocationOffset(child),
                        childWidth, childHeight);
                        childTop += childHeight + lp.bottomMargin + getNextLocationOffset(child);
                        i += getChildrenSkipCount(child, i);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.530 -0400", hash_original_method = "7E4C2E885F4FB677FEB4B548A065DB2A", hash_generated_method = "C40B41BA4077C4F0072F25AC61577951")
     void layoutHorizontal() {
        boolean isLayoutRtl;
        isLayoutRtl = isLayoutRtl();
        int paddingTop;
        paddingTop = mPaddingTop;
        int childTop;
        int childLeft;
        int height;
        height = mBottom - mTop;
        int childBottom;
        childBottom = height - mPaddingBottom;
        int childSpace;
        childSpace = height - paddingTop - mPaddingBottom;
        int count;
        count = getVirtualChildCount();
        int majorGravity;
        majorGravity = mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int minorGravity;
        minorGravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        boolean baselineAligned;
        baselineAligned = mBaselineAligned;
        int[] maxAscent;
        maxAscent = mMaxAscent;
        int[] maxDescent;
        maxDescent = mMaxDescent;
        int layoutDirection;
        layoutDirection = getResolvedLayoutDirection();
        {
            Object var9AC6381C3482ABA654889035FB8C338F_2143422242 = (Gravity.getAbsoluteGravity(majorGravity, layoutDirection));
            //Begin case Gravity.RIGHT 
            childLeft = mPaddingLeft + mRight - mLeft - mTotalLength;
            //End case Gravity.RIGHT 
            //Begin case Gravity.CENTER_HORIZONTAL 
            childLeft = mPaddingLeft + (mRight - mLeft - mTotalLength) / 2;
            //End case Gravity.CENTER_HORIZONTAL 
            //Begin case Gravity.LEFT default 
            childLeft = mPaddingLeft;
            //End case Gravity.LEFT default 
        } //End collapsed parenthetic
        int start;
        start = 0;
        int dir;
        dir = 1;
        {
            start = count - 1;
            dir = -1;
        } //End block
        {
            int i;
            i = 0;
            {
                int childIndex;
                childIndex = start + dir * i;
                View child;
                child = getVirtualChildAt(childIndex);
                {
                    childLeft += measureNullChild(childIndex);
                } //End block
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_879763297 = (child.getVisibility() != GONE);
                    {
                        int childWidth;
                        childWidth = child.getMeasuredWidth();
                        int childHeight;
                        childHeight = child.getMeasuredHeight();
                        int childBaseline;
                        childBaseline = -1;
                        LinearLayout.LayoutParams lp;
                        lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                        {
                            childBaseline = child.getBaseline();
                        } //End block
                        int gravity;
                        gravity = lp.gravity;
                        {
                            gravity = minorGravity;
                        } //End block
                        //Begin case Gravity.TOP 
                        childTop = paddingTop + lp.topMargin;
                        //End case Gravity.TOP 
                        //Begin case Gravity.TOP 
                        {
                            childTop += maxAscent[INDEX_TOP] - childBaseline;
                        } //End block
                        //End case Gravity.TOP 
                        //Begin case Gravity.CENTER_VERTICAL 
                        childTop = paddingTop + ((childSpace - childHeight) / 2)
                                + lp.topMargin - lp.bottomMargin;
                        //End case Gravity.CENTER_VERTICAL 
                        //Begin case Gravity.BOTTOM 
                        childTop = childBottom - childHeight - lp.bottomMargin;
                        //End case Gravity.BOTTOM 
                        //Begin case Gravity.BOTTOM 
                        {
                            int descent;
                            descent = child.getMeasuredHeight() - childBaseline;
                            childTop -= (maxDescent[INDEX_BOTTOM] - descent);
                        } //End block
                        //End case Gravity.BOTTOM 
                        //Begin case default 
                        childTop = paddingTop;
                        //End case default 
                        {
                            boolean varD92D197B47B02ED47C53CE932422B14B_770639659 = (hasDividerBeforeChildAt(childIndex));
                            {
                                childLeft += mDividerWidth;
                            } //End block
                        } //End collapsed parenthetic
                        childLeft += lp.leftMargin;
                        setChildFrame(child, childLeft + getLocationOffset(child), childTop,
                        childWidth, childHeight);
                        childLeft += childWidth + lp.rightMargin +
                        getNextLocationOffset(child);
                        i += getChildrenSkipCount(child, childIndex);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.539 -0400", hash_original_method = "74793CDC2820B7770CC6C7B645CE6A0C", hash_generated_method = "ABEA48B3A59EDBABAE9B04B6126B44B6")
    private void setChildFrame(View child, int left, int top, int width, int height) {
        child.layout(left, top, left + width, top + height);
        addTaint(child.getTaint());
        addTaint(left);
        addTaint(top);
        addTaint(width);
        addTaint(height);
        // ---------- Original Method ----------
        //child.layout(left, top, left + width, top + height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.544 -0400", hash_original_method = "708E6C59CCF6822D1254CF8F346C250A", hash_generated_method = "ED9B202367C7DECE598DADBE6010297D")
    public void setOrientation(int orientation) {
        {
            mOrientation = orientation;
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (mOrientation != orientation) {
            //mOrientation = orientation;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.544 -0400", hash_original_method = "6BA82D6B625174A8AC80664141F0D361", hash_generated_method = "FDCA8B853914280443D29B0B29C1866A")
    public int getOrientation() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_112061185 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_112061185;
        // ---------- Original Method ----------
        //return mOrientation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.559 -0400", hash_original_method = "DC8D5E1211DE0926B9DDA2FADCED75EE", hash_generated_method = "70FD7A97C03EACC1814D5C80AB15EB8F")
    @android.view.RemotableViewMethod
    public void setGravity(int gravity) {
        {
            {
                gravity |= Gravity.START;
            } //End block
            {
                gravity |= Gravity.TOP;
            } //End block
            mGravity = gravity;
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (mGravity != gravity) {
            //if ((gravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 0) {
                //gravity |= Gravity.START;
            //}
            //if ((gravity & Gravity.VERTICAL_GRAVITY_MASK) == 0) {
                //gravity |= Gravity.TOP;
            //}
            //mGravity = gravity;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.560 -0400", hash_original_method = "076C59065FCBD07F7CAA4FFA6D12CC3A", hash_generated_method = "65ABA9E48DE49124BBE38972DFC6C8E3")
    @android.view.RemotableViewMethod
    public void setHorizontalGravity(int horizontalGravity) {
        int gravity;
        gravity = horizontalGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        {
            mGravity = (mGravity & ~Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) | gravity;
            requestLayout();
        } //End block
        addTaint(horizontalGravity);
        // ---------- Original Method ----------
        //final int gravity = horizontalGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        //if ((mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) != gravity) {
            //mGravity = (mGravity & ~Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) | gravity;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.560 -0400", hash_original_method = "EE245B70888F9F1582A126D948173E64", hash_generated_method = "601E6D5BF8B6BDDC866632D7C5C11147")
    @android.view.RemotableViewMethod
    public void setVerticalGravity(int verticalGravity) {
        int gravity;
        gravity = verticalGravity & Gravity.VERTICAL_GRAVITY_MASK;
        {
            mGravity = (mGravity & ~Gravity.VERTICAL_GRAVITY_MASK) | gravity;
            requestLayout();
        } //End block
        addTaint(verticalGravity);
        // ---------- Original Method ----------
        //final int gravity = verticalGravity & Gravity.VERTICAL_GRAVITY_MASK;
        //if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != gravity) {
            //mGravity = (mGravity & ~Gravity.VERTICAL_GRAVITY_MASK) | gravity;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.561 -0400", hash_original_method = "5E749CCE267F5C755BAC22F4F9345284", hash_generated_method = "3D82D0B3C2606E47DA1FF6F6D1F89EE6")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1700419610 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1700419610 = new LinearLayout.LayoutParams(getContext(), attrs);
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1700419610.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1700419610;
        // ---------- Original Method ----------
        //return new LinearLayout.LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.562 -0400", hash_original_method = "3D6E4608F39560A7785B268309288C51", hash_generated_method = "108CB536A788EC0E41F6621D57D1AD04")
    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1877966115 = null; //Variable for return #1
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1530130959 = null; //Variable for return #2
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1851789952 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1877966115 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1530130959 = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1851789952 = null;
        LayoutParams varA7E53CE21691AB073D9660D615818899_1132384409; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1132384409 = varB4EAC82CA7396A68D541C85D26508E83_1877966115;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1132384409 = varB4EAC82CA7396A68D541C85D26508E83_1530130959;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1132384409 = varB4EAC82CA7396A68D541C85D26508E83_1851789952;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1132384409.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1132384409;
        // ---------- Original Method ----------
        //if (mOrientation == HORIZONTAL) {
            //return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        //} else if (mOrientation == VERTICAL) {
            //return new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.572 -0400", hash_original_method = "E5FE95308BC48D9899CFDE5A4F7DEDB6", hash_generated_method = "2AF6AA5E0AB96A06D5C8B3E02476E64B")
    @Override
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1314030447 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1314030447 = new LayoutParams(p);
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1314030447.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1314030447;
        // ---------- Original Method ----------
        //return new LayoutParams(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.572 -0400", hash_original_method = "1F2E8350C10FBDB8051DCF8E5479411B", hash_generated_method = "404D77255D8F2292CBC6F041C1F194B4")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_960668683 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_960668683;
        // ---------- Original Method ----------
        //return p instanceof LinearLayout.LayoutParams;
    }

    
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.572 -0400", hash_original_field = "7EDABF994B76A00CBC60C95AF337DB8F", hash_generated_field = "B59DE7C019472A73872C811A2811FA3D")

        @ViewDebug.ExportedProperty(category = "layout") public float weight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.572 -0400", hash_original_field = "CF0F2AF9EE62920A17A205053A2F0423", hash_generated_field = "938DDF19CF8B381A3F6119E45B2090E8")

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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.573 -0400", hash_original_method = "C424BD779148A2828DEB0ABC94DCC73C", hash_generated_method = "2998468387E71DEAE0076D266BD65F5A")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a;
            a = c.obtainStyledAttributes(attrs, com.android.internal.R.styleable.LinearLayout_Layout);
            weight = a.getFloat(com.android.internal.R.styleable.LinearLayout_Layout_layout_weight, 0);
            gravity = a.getInt(com.android.internal.R.styleable.LinearLayout_Layout_layout_gravity, -1);
            a.recycle();
            addTaint(c.getTaint());
            addTaint(attrs.getTaint());
            // ---------- Original Method ----------
            //TypedArray a =
                    //c.obtainStyledAttributes(attrs, com.android.internal.R.styleable.LinearLayout_Layout);
            //weight = a.getFloat(com.android.internal.R.styleable.LinearLayout_Layout_layout_weight, 0);
            //gravity = a.getInt(com.android.internal.R.styleable.LinearLayout_Layout_layout_gravity, -1);
            //a.recycle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.573 -0400", hash_original_method = "5675045EFCD4661F32116909A9822399", hash_generated_method = "13653ECE503E7E958B6B0343131C8A7C")
        public  LayoutParams(int width, int height) {
            super(width, height);
            weight = 0;
            addTaint(width);
            addTaint(height);
            // ---------- Original Method ----------
            //weight = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.583 -0400", hash_original_method = "4CDC4D1E7FEEFBC37A8F4BABF983F00D", hash_generated_method = "570550A708822B75490AA0A4DA8AB602")
        public  LayoutParams(int width, int height, float weight) {
            super(width, height);
            this.weight = weight;
            addTaint(width);
            addTaint(height);
            // ---------- Original Method ----------
            //this.weight = weight;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.584 -0400", hash_original_method = "DE4ED36682A1028E303BDCC28A48E06F", hash_generated_method = "66B55E9EFECAB48B3D28D153941B8308")
        public  LayoutParams(ViewGroup.LayoutParams p) {
            super(p);
            addTaint(p.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.585 -0400", hash_original_method = "CC87BD4B8C067788FA2BA37DBA116F62", hash_generated_method = "BDFD9CE52FB4D6304CCFF1CA731BA0A9")
        public  LayoutParams(MarginLayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.585 -0400", hash_original_method = "09BB09F623D63D4B2B1AF033D2D5C9B4", hash_generated_method = "154686D7DE79C9E3754C6EB7A86C27F5")
        @Override
        public String debug(String output) {
            String varB4EAC82CA7396A68D541C85D26508E83_1895933241 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1895933241 = output + "LinearLayout.LayoutParams={width=" + sizeToString(width) +
                    ", height=" + sizeToString(height) + " weight=" + weight +  "}";
            addTaint(output.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1895933241.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1895933241;
            // ---------- Original Method ----------
            //return output + "LinearLayout.LayoutParams={width=" + sizeToString(width) +
                    //", height=" + sizeToString(height) + " weight=" + weight +  "}";
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.585 -0400", hash_original_field = "10CC209974739317E961EBD041018581", hash_generated_field = "AC2205EFFDAF899686D059A4EFB7832E")

    public static final int HORIZONTAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.585 -0400", hash_original_field = "B9A581C9879D3D62C7911745C0873959", hash_generated_field = "91DAF494B5C30478B3C457C5B0180E08")

    public static final int VERTICAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.585 -0400", hash_original_field = "8E79999F9F33DFB3FEA79372A82665CC", hash_generated_field = "0C5B8E328FB66A18A43839866930E8D4")

    public static final int SHOW_DIVIDER_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.585 -0400", hash_original_field = "A32E55A167CB9B1767289058C30ADA8B", hash_generated_field = "1DD6C5FF6610D03904D40069FE620989")

    public static final int SHOW_DIVIDER_BEGINNING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.585 -0400", hash_original_field = "B89CD3C872738F0B2E6C2ED3A7D520A1", hash_generated_field = "BA257B3BA3E7775EC6015D8CAB979002")

    public static final int SHOW_DIVIDER_MIDDLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.585 -0400", hash_original_field = "6DCA5BAE6370E56F53BB44B9146BA598", hash_generated_field = "DD4A6080B5F419CDA74F877B1348BFA3")

    public static final int SHOW_DIVIDER_END = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.586 -0400", hash_original_field = "D50D1954CC86BCF359A31F9E0FA36B86", hash_generated_field = "49986CB3B444FCC0899418B085655220")

    private static int VERTICAL_GRAVITY_COUNT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.586 -0400", hash_original_field = "D29FEE3A1F7E065383FB6F36F4BE0ED7", hash_generated_field = "39505BC5109602EBE10020876D4FF942")

    private static int INDEX_CENTER_VERTICAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.586 -0400", hash_original_field = "ED03692D3867A1965A1652C9AEAD08BC", hash_generated_field = "579CBE242928668AC0578F3FC8250A6B")

    private static int INDEX_TOP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.586 -0400", hash_original_field = "BD7D4E77C2437CF6BE5DE22C27EBF700", hash_generated_field = "EE3E7F64E4D1B43D5CAE2831557009AE")

    private static int INDEX_BOTTOM = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.586 -0400", hash_original_field = "CB9D90A00CF11F5A0D279367FF293389", hash_generated_field = "CCED2E4D0843362E819365358982EB08")

    private static int INDEX_FILL = 3;
}

