package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_END = 4;
    @ViewDebug.ExportedProperty(category = "layout")
    private boolean mBaselineAligned = true;
    @ViewDebug.ExportedProperty(category = "layout")
    private int mBaselineAlignedChildIndex = -1;
    @ViewDebug.ExportedProperty(category = "measurement")
    private int mBaselineChildTop = 0;
    @ViewDebug.ExportedProperty(category = "measurement")
    private int mOrientation;
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
        })
    private int mGravity = Gravity.START | Gravity.TOP;
    @ViewDebug.ExportedProperty(category = "measurement")
    private int mTotalLength;
    @ViewDebug.ExportedProperty(category = "layout")
    private float mWeightSum;
    @ViewDebug.ExportedProperty(category = "layout")
    private boolean mUseLargestChild;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_TOP = 1;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_FILL = 3;
    private Drawable mDivider;
    private int mDividerWidth;
    private int mDividerHeight;
    private int mShowDividers;
    private int mDividerPadding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.805 -0400", hash_original_method = "FE94B0C3331DC48DD922B45C9927A2E5", hash_generated_method = "306F2B5A6DF5159D41F9F7688ECD98DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinearLayout(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.805 -0400", hash_original_method = "90765D7AD39C5FFE28F827609E4D9AAF", hash_generated_method = "D7B987EFACB6E7A63DB8FC46D247AB4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.805 -0400", hash_original_method = "CABCB619C04E154CCE92AB7E91451BB7", hash_generated_method = "5A18BC2347D4C47CCCBD9121810E3CFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.805 -0400", hash_original_method = "DE827128F1412AED640E145E58E9E69C", hash_generated_method = "2907AC239A9C68B4C0C36125972329BF")
    @DSModeled(DSC.SAFE)
    public void setShowDividers(int showDividers) {
        dsTaint.addTaint(showDividers);
        {
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (showDividers != mShowDividers) {
            //requestLayout();
        //}
        //mShowDividers = showDividers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.805 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "1239C6C76A60BF63BE5F6B305C415611")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean shouldDelayChildPressedState() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.805 -0400", hash_original_method = "81C750B99B14EF38CA21D36808CD7086", hash_generated_method = "578F58899977D0806C6BA51759EA5CD8")
    @DSModeled(DSC.SAFE)
    public int getShowDividers() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mShowDividers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.805 -0400", hash_original_method = "7357A0D71E9A27E2C8DA29FA77A144AF", hash_generated_method = "A97357FA7C4D18BBD34D95425A769718")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDividerDrawable(Drawable divider) {
        dsTaint.addTaint(divider.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.806 -0400", hash_original_method = "E2E4F4C3D603F5F2D62C3F5CBAFDCC06", hash_generated_method = "575E59A3132001119103344928E89245")
    @DSModeled(DSC.SAFE)
    public void setDividerPadding(int padding) {
        dsTaint.addTaint(padding);
        // ---------- Original Method ----------
        //mDividerPadding = padding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.806 -0400", hash_original_method = "2F70F7AA30D3819DCD53286185A1CA49", hash_generated_method = "4A16A3F15E08759252EB17B0FAB70935")
    @DSModeled(DSC.SAFE)
    public int getDividerPadding() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDividerPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.806 -0400", hash_original_method = "4DCD95C01B6B6891D72266EBA61909DF", hash_generated_method = "73D4A896D4D373C6D3336B743E73EF5E")
    @DSModeled(DSC.SAFE)
    public int getDividerWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDividerWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.806 -0400", hash_original_method = "4D234859DAD3D7D2BD3ABC15BDBCF93C", hash_generated_method = "A2977B9AC31D41A1C8E7111C106359FB")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(canvas.dsTaint);
        {
            drawDividersVertical(canvas);
        } //End block
        {
            drawDividersHorizontal(canvas);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.806 -0400", hash_original_method = "6F9B50C05500D3423B595FD6EF29F0C0", hash_generated_method = "22BF82162201A8E74834D5286D7373C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void drawDividersVertical(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        final int count;
        count = getVirtualChildCount();
        {
            int i;
            i = 0;
            {
                final View child;
                child = getVirtualChildAt(i);
                {
                    boolean varAD445368CB7F7DFBCAA93AD5AAA408ED_1645840399 = (child != null && child.getVisibility() != GONE);
                    {
                        {
                            boolean var5753280A391A92BDB591E4FED1D40DAB_463481113 = (hasDividerBeforeChildAt(i));
                            {
                                final LayoutParams lp;
                                lp = (LayoutParams) child.getLayoutParams();
                                final int top;
                                top = child.getTop() - lp.topMargin;
                                drawHorizontalDivider(canvas, top);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var48BF1E2FEB752C0437BBA766958C3F15_1763176374 = (hasDividerBeforeChildAt(count));
            {
                final View child;
                child = getVirtualChildAt(count - 1);
                int bottom;
                bottom = 0;
                {
                    bottom = getHeight() - getPaddingBottom() - mDividerHeight;
                } //End block
                {
                    final LayoutParams lp;
                    lp = (LayoutParams) child.getLayoutParams();
                    bottom = child.getBottom() + lp.bottomMargin;
                } //End block
                drawHorizontalDivider(canvas, bottom);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.806 -0400", hash_original_method = "86833A485E8343AB391A7321B35B1538", hash_generated_method = "61B826E471D6016FFA09893AF4376B00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void drawDividersHorizontal(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        final int count;
        count = getVirtualChildCount();
        {
            int i;
            i = 0;
            {
                final View child;
                child = getVirtualChildAt(i);
                {
                    boolean varAD445368CB7F7DFBCAA93AD5AAA408ED_1290600835 = (child != null && child.getVisibility() != GONE);
                    {
                        {
                            boolean var5753280A391A92BDB591E4FED1D40DAB_380772123 = (hasDividerBeforeChildAt(i));
                            {
                                final LayoutParams lp;
                                lp = (LayoutParams) child.getLayoutParams();
                                final int left;
                                left = child.getLeft() - lp.leftMargin;
                                drawVerticalDivider(canvas, left);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var48BF1E2FEB752C0437BBA766958C3F15_675125843 = (hasDividerBeforeChildAt(count));
            {
                final View child;
                child = getVirtualChildAt(count - 1);
                int right;
                right = 0;
                {
                    right = getWidth() - getPaddingRight() - mDividerWidth;
                } //End block
                {
                    final LayoutParams lp;
                    lp = (LayoutParams) child.getLayoutParams();
                    right = child.getRight() + lp.rightMargin;
                } //End block
                drawVerticalDivider(canvas, right);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.806 -0400", hash_original_method = "B34FB2DB2BC7F90A8C4BCDC4C5D2422E", hash_generated_method = "421EB5FB8E36BA691346E09E40D81006")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void drawHorizontalDivider(Canvas canvas, int top) {
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(top);
        mDivider.setBounds(getPaddingLeft() + mDividerPadding, top,
                getWidth() - getPaddingRight() - mDividerPadding, top + mDividerHeight);
        mDivider.draw(canvas);
        // ---------- Original Method ----------
        //mDivider.setBounds(getPaddingLeft() + mDividerPadding, top,
                //getWidth() - getPaddingRight() - mDividerPadding, top + mDividerHeight);
        //mDivider.draw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.806 -0400", hash_original_method = "230D2DD24F19D940DC30A0FCA2C380AD", hash_generated_method = "5229486608815DA6CA592C8DB60D233A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void drawVerticalDivider(Canvas canvas, int left) {
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(left);
        mDivider.setBounds(left, getPaddingTop() + mDividerPadding,
                left + mDividerWidth, getHeight() - getPaddingBottom() - mDividerPadding);
        mDivider.draw(canvas);
        // ---------- Original Method ----------
        //mDivider.setBounds(left, getPaddingTop() + mDividerPadding,
                //left + mDividerWidth, getHeight() - getPaddingBottom() - mDividerPadding);
        //mDivider.draw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.807 -0400", hash_original_method = "F54465AC5542CF519D3902E7BAEA3188", hash_generated_method = "B001DC1A7FEF5EB2432BA083850FC085")
    @DSModeled(DSC.SAFE)
    public boolean isBaselineAligned() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mBaselineAligned;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.807 -0400", hash_original_method = "8643C35E200A9ECC6F4D083B3C632ADD", hash_generated_method = "3F0703584977DE4A4DE34F52F7B9BAA3")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setBaselineAligned(boolean baselineAligned) {
        dsTaint.addTaint(baselineAligned);
        // ---------- Original Method ----------
        //mBaselineAligned = baselineAligned;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.807 -0400", hash_original_method = "49EB4E4C3BC63D2BEAA8F5D24053BB96", hash_generated_method = "318DE4A500A8A24E2A2DD55A500E979C")
    @DSModeled(DSC.SAFE)
    public boolean isMeasureWithLargestChildEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mUseLargestChild;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.807 -0400", hash_original_method = "55BFE46AC305D5ECEC6F564C443E4CAB", hash_generated_method = "3BAD759B3C9555ECD9F711AE92C33AB3")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setMeasureWithLargestChildEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        // ---------- Original Method ----------
        //mUseLargestChild = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.807 -0400", hash_original_method = "8677A7AE77B37457B2CE24BC40A0B2AA", hash_generated_method = "242D4F6DC6FC0C79F1822105020BD808")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getBaseline() {
        {
            int varEC5F70FA49520212A319ACA653FC0209_1162515299 = (super.getBaseline());
        } //End block
        {
            boolean var0CC14488A448130ACFEBA1F25FFBD58A_1222436594 = (getChildCount() <= mBaselineAlignedChildIndex);
            {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout "
                    + "set to an index that is out of bounds.");
            } //End block
        } //End collapsed parenthetic
        final View child;
        child = getChildAt(mBaselineAlignedChildIndex);
        final int childBaseline;
        childBaseline = child.getBaseline();
        {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout "
                    + "points to a View that doesn't know how to get its baseline.");
        } //End block
        int childTop;
        childTop = mBaselineChildTop;
        {
            final int majorGravity;
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.807 -0400", hash_original_method = "90F550BFDC49A6587A7A8440E339A132", hash_generated_method = "FA05558066E2FB2D072807DF5E13ED0B")
    @DSModeled(DSC.SAFE)
    public int getBaselineAlignedChildIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBaselineAlignedChildIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.807 -0400", hash_original_method = "4CFC93DB175F8874B4EFFA335793DCB8", hash_generated_method = "75C2D463ED4C6A4C462B18E606B5E162")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public void setBaselineAlignedChildIndex(int i) {
        dsTaint.addTaint(i);
        {
            boolean varE9CD64879C792E1B66A251BAB70D8B08_1734360475 = ((i < 0) || (i >= getChildCount()));
            {
                throw new IllegalArgumentException("base aligned child index out "
                    + "of range (0, " + getChildCount() + ")");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if ((i < 0) || (i >= getChildCount())) {
            //throw new IllegalArgumentException("base aligned child index out "
                    //+ "of range (0, " + getChildCount() + ")");
        //}
        //mBaselineAlignedChildIndex = i;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.807 -0400", hash_original_method = "87FE8C209A68A97BDFF0666E4CF673D3", hash_generated_method = "8F76D618418C4D7AF34F15B2F6CFACAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     View getVirtualChildAt(int index) {
        dsTaint.addTaint(index);
        View var9C71C4887E5A21CEDD637E7AB6C81610_2140774151 = (getChildAt(index));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getChildAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.807 -0400", hash_original_method = "04A766EF9FA40CCD4344368D3178C5E7", hash_generated_method = "DB8EAE8A9792C987BF7AB8618D8BBA15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getVirtualChildCount() {
        int varF41158137001188D2F9D08127BFB39DA_858674391 = (getChildCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getChildCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.807 -0400", hash_original_method = "131E7E20664E8B649BC33F0915A0DE0D", hash_generated_method = "E8CB2FDEF703868F1A73C4A2BC63877E")
    @DSModeled(DSC.SAFE)
    public float getWeightSum() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mWeightSum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.807 -0400", hash_original_method = "47922B5280E89B2CF9B73D66705F0A8D", hash_generated_method = "28C4115157B52C475C52E0F8DBDAD8B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public void setWeightSum(float weightSum) {
        dsTaint.addTaint(weightSum);
        mWeightSum = Math.max(0.0f, weightSum);
        // ---------- Original Method ----------
        //mWeightSum = Math.max(0.0f, weightSum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.807 -0400", hash_original_method = "3F3B158F407FDE6BDDE91ED473E376D3", hash_generated_method = "0B1DBD7A50996553DFBEB4C63F5D22D5")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        {
            measureVertical(widthMeasureSpec, heightMeasureSpec);
        } //End block
        {
            measureHorizontal(widthMeasureSpec, heightMeasureSpec);
        } //End block
        // ---------- Original Method ----------
        //if (mOrientation == VERTICAL) {
            //measureVertical(widthMeasureSpec, heightMeasureSpec);
        //} else {
            //measureHorizontal(widthMeasureSpec, heightMeasureSpec);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.808 -0400", hash_original_method = "E4A04FCA37D7E9FFFC1F15D63F30923E", hash_generated_method = "783E04AD500D84B42922D2BD5EDF4ED2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean hasDividerBeforeChildAt(int childIndex) {
        dsTaint.addTaint(childIndex);
        {
            boolean var042391D18CFAA58040C07325508C3E5D_1585241971 = (childIndex == getChildCount());
            {
                boolean hasVisibleViewBefore;
                hasVisibleViewBefore = false;
                {
                    int i;
                    i = childIndex - 1;
                    {
                        {
                            boolean var849B37533740585CFE18F837DD2EDAAB_81550018 = (getChildAt(i).getVisibility() != GONE);
                            {
                                hasVisibleViewBefore = true;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.809 -0400", hash_original_method = "A88B972B81C9E0D927EB1FAC25F8F6D1", hash_generated_method = "EEE8D648535E8DEFBA2B20D3FDB358B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void measureVertical(int widthMeasureSpec, int heightMeasureSpec) {
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
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
        final int count;
        count = getVirtualChildCount();
        final int widthMode;
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode;
        heightMode = MeasureSpec.getMode(heightMeasureSpec);
        boolean matchWidth;
        matchWidth = false;
        final int baselineChildIndex;
        baselineChildIndex = mBaselineAlignedChildIndex;
        final boolean useLargestChild;
        useLargestChild = mUseLargestChild;
        int largestChildHeight;
        largestChildHeight = Integer.MIN_VALUE;
        {
            int i;
            i = 0;
            {
                final View child;
                child = getVirtualChildAt(i);
                {
                    mTotalLength += measureNullChild(i);
                } //End block
                {
                    boolean varAE94D5328E94C6606865B35993EDD564_893995137 = (child.getVisibility() == View.GONE);
                    {
                        i += getChildrenSkipCount(child, i);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var53CA14277C14EA37C3E2B0E1BF193AF9_1304683669 = (hasDividerBeforeChildAt(i));
                    {
                        mTotalLength += mDividerHeight;
                    } //End block
                } //End collapsed parenthetic
                LinearLayout.LayoutParams lp;
                lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                totalWeight += lp.weight;
                {
                    final int totalLength;
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
                    final int childHeight;
                    childHeight = child.getMeasuredHeight();
                    final int totalLength;
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
                    throw new RuntimeException("A child of LinearLayout with index "
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
                final int margin;
                margin = lp.leftMargin + lp.rightMargin;
                final int measuredWidth;
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
            boolean varCC0767313899D8044991C6ED676480A0_181353143 = (mTotalLength > 0 && hasDividerBeforeChildAt(count));
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
                    final View child;
                    child = getVirtualChildAt(i);
                    {
                        mTotalLength += measureNullChild(i);
                    } //End block
                    {
                        boolean var24A8049355A2DBEE0F9FC0F85F3CAA64_1379816529 = (child.getVisibility() == GONE);
                        {
                            i += getChildrenSkipCount(child, i);
                        } //End block
                    } //End collapsed parenthetic
                    final LinearLayout.LayoutParams lp;
                    lp = (LinearLayout.LayoutParams)
                        child.getLayoutParams();
                    final int totalLength;
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
                    final View child;
                    child = getVirtualChildAt(i);
                    {
                        boolean varCE5DD5D436329456ACE82D8F3349CC31_1698391668 = (child.getVisibility() == View.GONE);
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
                        final int childWidthMeasureSpec;
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
                    final int margin;
                    margin = lp.leftMargin + lp.rightMargin;
                    final int measuredWidth;
                    measuredWidth = child.getMeasuredWidth() + margin;
                    maxWidth = Math.max(maxWidth, measuredWidth);
                    boolean matchWidthLocally;
                    matchWidthLocally = widthMode != MeasureSpec.EXACTLY &&
                        lp.width == LayoutParams.MATCH_PARENT;
                    alternativeMaxWidth = Math.max(alternativeMaxWidth,
                        matchWidthLocally ? margin : measuredWidth);
                    allFillParent = allFillParent && lp.width == LayoutParams.MATCH_PARENT;
                    final int totalLength;
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
                        final View child;
                        child = getVirtualChildAt(i);
                        {
                            boolean varE7BB3503787C529D329422F9519818AF_1520833772 = (child == null || child.getVisibility() == View.GONE);
                        } //End collapsed parenthetic
                        final LinearLayout.LayoutParams lp;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.810 -0400", hash_original_method = "AFA9034D947EBEF26850BC0782F132F9", hash_generated_method = "81DF94B63473353947BAB57247108C3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void forceUniformWidth(int count, int heightMeasureSpec) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(heightMeasureSpec);
        int uniformMeasureSpec;
        uniformMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(),
                MeasureSpec.EXACTLY);
        {
            int i;
            i = 0;
            {
                final View child;
                child = getVirtualChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_928679638 = (child.getVisibility() != GONE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.812 -0400", hash_original_method = "22C04BEEA310D9DB4A6BB8F3656099B0", hash_generated_method = "0D2EA8DEA0E791C8BA45688679BB11AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void measureHorizontal(int widthMeasureSpec, int heightMeasureSpec) {
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
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
        final int count;
        count = getVirtualChildCount();
        final int widthMode;
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode;
        heightMode = MeasureSpec.getMode(heightMeasureSpec);
        boolean matchHeight;
        matchHeight = false;
        {
            mMaxAscent = new int[VERTICAL_GRAVITY_COUNT];
            mMaxDescent = new int[VERTICAL_GRAVITY_COUNT];
        } //End block
        final int[] maxAscent;
        maxAscent = mMaxAscent;
        final int[] maxDescent;
        maxDescent = mMaxDescent;
        maxAscent[0] = maxAscent[1] = maxAscent[2] = maxAscent[3] = -1;
        maxDescent[0] = maxDescent[1] = maxDescent[2] = maxDescent[3] = -1;
        final boolean baselineAligned;
        baselineAligned = mBaselineAligned;
        final boolean useLargestChild;
        useLargestChild = mUseLargestChild;
        final boolean isExactly;
        isExactly = widthMode == MeasureSpec.EXACTLY;
        int largestChildWidth;
        largestChildWidth = Integer.MIN_VALUE;
        {
            int i;
            i = 0;
            {
                final View child;
                child = getVirtualChildAt(i);
                {
                    mTotalLength += measureNullChild(i);
                } //End block
                {
                    boolean varE5A6421440835A22FD9C00B75E3D1565_1277623058 = (child.getVisibility() == GONE);
                    {
                        i += getChildrenSkipCount(child, i);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var53CA14277C14EA37C3E2B0E1BF193AF9_1841069986 = (hasDividerBeforeChildAt(i));
                    {
                        mTotalLength += mDividerWidth;
                    } //End block
                } //End collapsed parenthetic
                final LinearLayout.LayoutParams lp;
                lp = (LinearLayout.LayoutParams)
                    child.getLayoutParams();
                totalWeight += lp.weight;
                {
                    {
                        mTotalLength += lp.leftMargin + lp.rightMargin;
                    } //End block
                    {
                        final int totalLength;
                        totalLength = mTotalLength;
                        mTotalLength = Math.max(totalLength, totalLength +
                            lp.leftMargin + lp.rightMargin);
                    } //End block
                    {
                        final int freeSpec;
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
                    final int childWidth;
                    childWidth = child.getMeasuredWidth();
                    {
                        mTotalLength += childWidth + lp.leftMargin + lp.rightMargin +
                            getNextLocationOffset(child);
                    } //End block
                    {
                        final int totalLength;
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
                final int margin;
                margin = lp.topMargin + lp.bottomMargin;
                final int childHeight;
                childHeight = child.getMeasuredHeight() + margin;
                childState = combineMeasuredStates(childState, child.getMeasuredState());
                {
                    final int childBaseline;
                    childBaseline = child.getBaseline();
                    {
                        final int gravity;
                        gravity = (lp.gravity < 0 ? mGravity : lp.gravity)
                            & Gravity.VERTICAL_GRAVITY_MASK;//DSFIXME:  CODE0008: Nested ternary operator in expression
                        final int index;
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
            boolean varCC0767313899D8044991C6ED676480A0_2118248465 = (mTotalLength > 0 && hasDividerBeforeChildAt(count));
            {
                mTotalLength += mDividerWidth;
            } //End block
        } //End collapsed parenthetic
        {
            final int ascent;
            ascent = Math.max(maxAscent[INDEX_FILL],
                    Math.max(maxAscent[INDEX_CENTER_VERTICAL],
                    Math.max(maxAscent[INDEX_TOP], maxAscent[INDEX_BOTTOM])));
            final int descent;
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
                    final View child;
                    child = getVirtualChildAt(i);
                    {
                        mTotalLength += measureNullChild(i);
                    } //End block
                    {
                        boolean var24A8049355A2DBEE0F9FC0F85F3CAA64_1766583033 = (child.getVisibility() == GONE);
                        {
                            i += getChildrenSkipCount(child, i);
                        } //End block
                    } //End collapsed parenthetic
                    final LinearLayout.LayoutParams lp;
                    lp = (LinearLayout.LayoutParams)
                        child.getLayoutParams();
                    {
                        mTotalLength += largestChildWidth + lp.leftMargin + lp.rightMargin +
                            getNextLocationOffset(child);
                    } //End block
                    {
                        final int totalLength;
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
                    final View child;
                    child = getVirtualChildAt(i);
                    {
                        boolean varF9B20D9EE469ED1FED42E2666426C840_258939639 = (child == null || child.getVisibility() == View.GONE);
                    } //End collapsed parenthetic
                    final LinearLayout.LayoutParams lp;
                    lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                    float childExtra;
                    childExtra = lp.weight;
                    {
                        int share;
                        share = (int) (childExtra * delta / weightSum);
                        weightSum -= childExtra;
                        delta -= share;
                        final int childHeightMeasureSpec;
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
                        final int totalLength;
                        totalLength = mTotalLength;
                        mTotalLength = Math.max(totalLength, totalLength + child.getMeasuredWidth() +
                            lp.leftMargin + lp.rightMargin + getNextLocationOffset(child));
                    } //End block
                    boolean matchHeightLocally;
                    matchHeightLocally = heightMode != MeasureSpec.EXACTLY &&
                        lp.height == LayoutParams.MATCH_PARENT;
                    final int margin;
                    margin = lp.topMargin + lp .bottomMargin;
                    int childHeight;
                    childHeight = child.getMeasuredHeight() + margin;
                    maxHeight = Math.max(maxHeight, childHeight);
                    alternativeMaxHeight = Math.max(alternativeMaxHeight,
                        matchHeightLocally ? margin : childHeight);
                    allFillParent = allFillParent && lp.height == LayoutParams.MATCH_PARENT;
                    {
                        final int childBaseline;
                        childBaseline = child.getBaseline();
                        {
                            final int gravity;
                            gravity = (lp.gravity < 0 ? mGravity : lp.gravity)
                                & Gravity.VERTICAL_GRAVITY_MASK;//DSFIXME:  CODE0008: Nested ternary operator in expression
                            final int index;
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
                final int ascent;
                ascent = Math.max(maxAscent[INDEX_FILL],
                        Math.max(maxAscent[INDEX_CENTER_VERTICAL],
                        Math.max(maxAscent[INDEX_TOP], maxAscent[INDEX_BOTTOM])));
                final int descent;
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
                        final View child;
                        child = getVirtualChildAt(i);
                        {
                            boolean varE7BB3503787C529D329422F9519818AF_350025736 = (child == null || child.getVisibility() == View.GONE);
                        } //End collapsed parenthetic
                        final LinearLayout.LayoutParams lp;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.813 -0400", hash_original_method = "FDF33FE6741A819E3461023969653A29", hash_generated_method = "A547E292D4CB6E7A9DFAF45B23A7BD99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void forceUniformHeight(int count, int widthMeasureSpec) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(widthMeasureSpec);
        int uniformMeasureSpec;
        uniformMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(),
                MeasureSpec.EXACTLY);
        {
            int i;
            i = 0;
            {
                final View child;
                child = getVirtualChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_384025799 = (child.getVisibility() != GONE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.813 -0400", hash_original_method = "64CDF538399E47C38C21DACEFC8C1E08", hash_generated_method = "8AE40B4F77571627B192BBBEF537632D")
    @DSModeled(DSC.SAFE)
     int getChildrenSkipCount(View child, int index) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(index);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.813 -0400", hash_original_method = "0C791DFCDA5E7DFE7963EF393BDBDA11", hash_generated_method = "AF5A3116CF25336AA0B8AE9C0295E36B")
    @DSModeled(DSC.SAFE)
     int measureNullChild(int childIndex) {
        dsTaint.addTaint(childIndex);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.813 -0400", hash_original_method = "784157887C32A4B8D345E93BB13DEECA", hash_generated_method = "161D23015D6474DFC56F5282607EDFBC")
    @DSModeled(DSC.SAFE)
     void measureChildBeforeLayout(View child, int childIndex,
            int widthMeasureSpec, int totalWidth, int heightMeasureSpec,
            int totalHeight) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(totalWidth);
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        dsTaint.addTaint(childIndex);
        dsTaint.addTaint(totalHeight);
        measureChildWithMargins(child, widthMeasureSpec, totalWidth,
                heightMeasureSpec, totalHeight);
        // ---------- Original Method ----------
        //measureChildWithMargins(child, widthMeasureSpec, totalWidth,
                //heightMeasureSpec, totalHeight);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.813 -0400", hash_original_method = "BA69BAE2E1D7A163D53D02D47016A6D7", hash_generated_method = "063C8978A3AF70558227BAABFD146995")
    @DSModeled(DSC.SAFE)
     int getLocationOffset(View child) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(child.dsTaint);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.813 -0400", hash_original_method = "6D7A4F846C7E828D32B84605EE3B545F", hash_generated_method = "3AEB1DB6F71D90FAE17F91217B49378F")
    @DSModeled(DSC.SAFE)
     int getNextLocationOffset(View child) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(child.dsTaint);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.813 -0400", hash_original_method = "38617BD257A07AF46AAF702E88FA7138", hash_generated_method = "1237F9DB582D2786485A7392AC55A148")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
        dsTaint.addTaint(changed);
        {
            layoutVertical();
        } //End block
        {
            layoutHorizontal();
        } //End block
        // ---------- Original Method ----------
        //if (mOrientation == VERTICAL) {
            //layoutVertical();
        //} else {
            //layoutHorizontal();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.814 -0400", hash_original_method = "30B5FEA9EA0D751AC72456573A204452", hash_generated_method = "BA1EB86D95E881B2341FA6708834AEDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void layoutVertical() {
        final int paddingLeft;
        paddingLeft = mPaddingLeft;
        int childTop;
        int childLeft;
        final int width;
        width = mRight - mLeft;
        int childRight;
        childRight = width - mPaddingRight;
        int childSpace;
        childSpace = width - paddingLeft - mPaddingRight;
        final int count;
        count = getVirtualChildCount();
        final int majorGravity;
        majorGravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        final int minorGravity;
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
                final View child;
                child = getVirtualChildAt(i);
                {
                    childTop += measureNullChild(i);
                } //End block
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_147727549 = (child.getVisibility() != GONE);
                    {
                        final int childWidth;
                        childWidth = child.getMeasuredWidth();
                        final int childHeight;
                        childHeight = child.getMeasuredHeight();
                        final LinearLayout.LayoutParams lp;
                        lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                        int gravity;
                        gravity = lp.gravity;
                        {
                            gravity = minorGravity;
                        } //End block
                        final int layoutDirection;
                        layoutDirection = getResolvedLayoutDirection();
                        final int absoluteGravity;
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
                            boolean var5753280A391A92BDB591E4FED1D40DAB_456999738 = (hasDividerBeforeChildAt(i));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.814 -0400", hash_original_method = "7E4C2E885F4FB677FEB4B548A065DB2A", hash_generated_method = "7CA06E12B74CC31A7A5BA5303FEDAF79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void layoutHorizontal() {
        final boolean isLayoutRtl;
        isLayoutRtl = isLayoutRtl();
        final int paddingTop;
        paddingTop = mPaddingTop;
        int childTop;
        int childLeft;
        final int height;
        height = mBottom - mTop;
        int childBottom;
        childBottom = height - mPaddingBottom;
        int childSpace;
        childSpace = height - paddingTop - mPaddingBottom;
        final int count;
        count = getVirtualChildCount();
        final int majorGravity;
        majorGravity = mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        final int minorGravity;
        minorGravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        final boolean baselineAligned;
        baselineAligned = mBaselineAligned;
        final int[] maxAscent;
        maxAscent = mMaxAscent;
        final int[] maxDescent;
        maxDescent = mMaxDescent;
        final int layoutDirection;
        layoutDirection = getResolvedLayoutDirection();
        {
            Object var9AC6381C3482ABA654889035FB8C338F_424077992 = (Gravity.getAbsoluteGravity(majorGravity, layoutDirection));
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
                final View child;
                child = getVirtualChildAt(childIndex);
                {
                    childLeft += measureNullChild(childIndex);
                } //End block
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_237714001 = (child.getVisibility() != GONE);
                    {
                        final int childWidth;
                        childWidth = child.getMeasuredWidth();
                        final int childHeight;
                        childHeight = child.getMeasuredHeight();
                        int childBaseline;
                        childBaseline = -1;
                        final LinearLayout.LayoutParams lp;
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
                            boolean varD92D197B47B02ED47C53CE932422B14B_354215928 = (hasDividerBeforeChildAt(childIndex));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.815 -0400", hash_original_method = "74793CDC2820B7770CC6C7B645CE6A0C", hash_generated_method = "A681F74ABB0173BBFD2BA060F68C11F5")
    @DSModeled(DSC.SAFE)
    private void setChildFrame(View child, int left, int top, int width, int height) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(left);
        dsTaint.addTaint(top);
        child.layout(left, top, left + width, top + height);
        // ---------- Original Method ----------
        //child.layout(left, top, left + width, top + height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.815 -0400", hash_original_method = "708E6C59CCF6822D1254CF8F346C250A", hash_generated_method = "30D913AEA596382BE65EC927FA539F90")
    @DSModeled(DSC.SAFE)
    public void setOrientation(int orientation) {
        dsTaint.addTaint(orientation);
        {
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (mOrientation != orientation) {
            //mOrientation = orientation;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.815 -0400", hash_original_method = "6BA82D6B625174A8AC80664141F0D361", hash_generated_method = "C041E58387914E8EA3249CC90D4587FA")
    @DSModeled(DSC.SAFE)
    public int getOrientation() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mOrientation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.815 -0400", hash_original_method = "DC8D5E1211DE0926B9DDA2FADCED75EE", hash_generated_method = "A871BF2FAF2E7FE4C58E3D920AC7CDE6")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setGravity(int gravity) {
        dsTaint.addTaint(gravity);
        {
            {
                gravity |= Gravity.START;
            } //End block
            {
                gravity |= Gravity.TOP;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.815 -0400", hash_original_method = "076C59065FCBD07F7CAA4FFA6D12CC3A", hash_generated_method = "371BD5BBD26B679481359A9DBA014468")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setHorizontalGravity(int horizontalGravity) {
        dsTaint.addTaint(horizontalGravity);
        final int gravity;
        gravity = horizontalGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        {
            mGravity = (mGravity & ~Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) | gravity;
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //final int gravity = horizontalGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        //if ((mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) != gravity) {
            //mGravity = (mGravity & ~Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) | gravity;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.815 -0400", hash_original_method = "EE245B70888F9F1582A126D948173E64", hash_generated_method = "3880CF9AD5205BBCC981F726DE9DD692")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setVerticalGravity(int verticalGravity) {
        dsTaint.addTaint(verticalGravity);
        final int gravity;
        gravity = verticalGravity & Gravity.VERTICAL_GRAVITY_MASK;
        {
            mGravity = (mGravity & ~Gravity.VERTICAL_GRAVITY_MASK) | gravity;
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //final int gravity = verticalGravity & Gravity.VERTICAL_GRAVITY_MASK;
        //if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != gravity) {
            //mGravity = (mGravity & ~Gravity.VERTICAL_GRAVITY_MASK) | gravity;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.815 -0400", hash_original_method = "5E749CCE267F5C755BAC22F4F9345284", hash_generated_method = "BF53BD88CE62205C2BD6B88967468781")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        LayoutParams var0D7DFC2F1FBC376957678EDDBBF7B432_1338000312 = (new LinearLayout.LayoutParams(getContext(), attrs));
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LinearLayout.LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.815 -0400", hash_original_method = "3D6E4608F39560A7785B268309288C51", hash_generated_method = "8C7696FD96B659DB35AF594980C85062")
    @DSModeled(DSC.SAFE)
    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mOrientation == HORIZONTAL) {
            //return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        //} else if (mOrientation == VERTICAL) {
            //return new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.815 -0400", hash_original_method = "E5FE95308BC48D9899CFDE5A4F7DEDB6", hash_generated_method = "CFBDE2E08ED7DCD54624BC0E2BF8FB6D")
    @DSModeled(DSC.SAFE)
    @Override
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LayoutParams(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.815 -0400", hash_original_method = "1F2E8350C10FBDB8051DCF8E5479411B", hash_generated_method = "F356E0E3759AD41BFAF1A9848C428B0F")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return p instanceof LinearLayout.LayoutParams;
    }

    
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        @ViewDebug.ExportedProperty(category = "layout")
        public float weight;
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
        })
        public int gravity = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.816 -0400", hash_original_method = "C424BD779148A2828DEB0ABC94DCC73C", hash_generated_method = "109B207AC69A54A441B98576C0CA7D68")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            dsTaint.addTaint(c.dsTaint);
            dsTaint.addTaint(attrs.dsTaint);
            TypedArray a;
            a = c.obtainStyledAttributes(attrs, com.android.internal.R.styleable.LinearLayout_Layout);
            weight = a.getFloat(com.android.internal.R.styleable.LinearLayout_Layout_layout_weight, 0);
            gravity = a.getInt(com.android.internal.R.styleable.LinearLayout_Layout_layout_gravity, -1);
            a.recycle();
            // ---------- Original Method ----------
            //TypedArray a =
                    //c.obtainStyledAttributes(attrs, com.android.internal.R.styleable.LinearLayout_Layout);
            //weight = a.getFloat(com.android.internal.R.styleable.LinearLayout_Layout_layout_weight, 0);
            //gravity = a.getInt(com.android.internal.R.styleable.LinearLayout_Layout_layout_gravity, -1);
            //a.recycle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.816 -0400", hash_original_method = "5675045EFCD4661F32116909A9822399", hash_generated_method = "712C6B9630C87D1113A58788D61CE2E5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(int width, int height) {
            super(width, height);
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            weight = 0;
            // ---------- Original Method ----------
            //weight = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.816 -0400", hash_original_method = "4CDC4D1E7FEEFBC37A8F4BABF983F00D", hash_generated_method = "5E2033DF367EF8E27A3189D918951F1A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(int width, int height, float weight) {
            super(width, height);
            dsTaint.addTaint(height);
            dsTaint.addTaint(weight);
            dsTaint.addTaint(width);
            // ---------- Original Method ----------
            //this.weight = weight;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.816 -0400", hash_original_method = "DE4ED36682A1028E303BDCC28A48E06F", hash_generated_method = "19460FCD68B80BC829FE33FF0FD1FFBC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(ViewGroup.LayoutParams p) {
            super(p);
            dsTaint.addTaint(p.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.816 -0400", hash_original_method = "CC87BD4B8C067788FA2BA37DBA116F62", hash_generated_method = "53773C0AA39A9C86DEA7B8B0DEB07F7A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(MarginLayoutParams source) {
            super(source);
            dsTaint.addTaint(source.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.816 -0400", hash_original_method = "09BB09F623D63D4B2B1AF033D2D5C9B4", hash_generated_method = "B3AADBE269785D129DA5FCAF50137321")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String debug(String output) {
            dsTaint.addTaint(output);
            String var4958517EC051F1887CA919D59A6C1F3C_1370445485 = (output + "LinearLayout.LayoutParams={width=" + sizeToString(width) +
                    ", height=" + sizeToString(height) + " weight=" + weight +  "}");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return output + "LinearLayout.LayoutParams={width=" + sizeToString(width) +
                    //", height=" + sizeToString(height) + " weight=" + weight +  "}";
        }

        
    }


    
}


