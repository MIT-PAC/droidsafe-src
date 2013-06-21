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
    @ViewDebug.ExportedProperty(category = "layout") private boolean mBaselineAligned = true;
    @ViewDebug.ExportedProperty(category = "layout") private int mBaselineAlignedChildIndex = -1;
    @ViewDebug.ExportedProperty(category = "measurement") private int mBaselineChildTop = 0;
    @ViewDebug.ExportedProperty(category = "measurement") private int mOrientation;
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
    @ViewDebug.ExportedProperty(category = "measurement") private int mTotalLength;
    @ViewDebug.ExportedProperty(category = "layout") private float mWeightSum;
    @ViewDebug.ExportedProperty(category = "layout") private boolean mUseLargestChild;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private Drawable mDivider;
    private int mDividerWidth;
    private int mDividerHeight;
    private int mShowDividers;
    private int mDividerPadding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.377 -0400", hash_original_method = "FE94B0C3331DC48DD922B45C9927A2E5", hash_generated_method = "2EFF139339BDEBABDB7D83B20A8DB981")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinearLayout(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.377 -0400", hash_original_method = "90765D7AD39C5FFE28F827609E4D9AAF", hash_generated_method = "A6B950262E6B10D528D87179FB790B95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.377 -0400", hash_original_method = "CABCB619C04E154CCE92AB7E91451BB7", hash_generated_method = "6A6D06B78E136064AD6380C322014B96")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.377 -0400", hash_original_method = "DE827128F1412AED640E145E58E9E69C", hash_generated_method = "9101FEEC5639E6091C656067724999B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.378 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "B6A28B76ECD4015FD614215B915AB786")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean shouldDelayChildPressedState() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.378 -0400", hash_original_method = "81C750B99B14EF38CA21D36808CD7086", hash_generated_method = "30BA2022D37B9648FBB02C44FDDCFE9C")
    @DSModeled(DSC.SAFE)
    public int getShowDividers() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mShowDividers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.378 -0400", hash_original_method = "7357A0D71E9A27E2C8DA29FA77A144AF", hash_generated_method = "CD36ECAFB42D5407100ED3A52A91A489")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.378 -0400", hash_original_method = "E2E4F4C3D603F5F2D62C3F5CBAFDCC06", hash_generated_method = "67E0B12F6A2416C059DFF989AF822F0A")
    @DSModeled(DSC.SAFE)
    public void setDividerPadding(int padding) {
        dsTaint.addTaint(padding);
        // ---------- Original Method ----------
        //mDividerPadding = padding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.378 -0400", hash_original_method = "2F70F7AA30D3819DCD53286185A1CA49", hash_generated_method = "A0D33267B130D42500C310E1AF1E00A6")
    @DSModeled(DSC.SAFE)
    public int getDividerPadding() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDividerPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.379 -0400", hash_original_method = "4DCD95C01B6B6891D72266EBA61909DF", hash_generated_method = "B5380EFAA04F19E308F4393972EC13E4")
    @DSModeled(DSC.SAFE)
    public int getDividerWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDividerWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.379 -0400", hash_original_method = "4D234859DAD3D7D2BD3ABC15BDBCF93C", hash_generated_method = "A804F3BEB8422C8011E3AABB119AF502")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.379 -0400", hash_original_method = "6F9B50C05500D3423B595FD6EF29F0C0", hash_generated_method = "611FF608245FBFF1EAD35FDDC98237EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void drawDividersVertical(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        int count;
        count = getVirtualChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = getVirtualChildAt(i);
                {
                    boolean varAD445368CB7F7DFBCAA93AD5AAA408ED_907108943 = (child != null && child.getVisibility() != GONE);
                    {
                        {
                            boolean var5753280A391A92BDB591E4FED1D40DAB_587114088 = (hasDividerBeforeChildAt(i));
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
            boolean var48BF1E2FEB752C0437BBA766958C3F15_487929892 = (hasDividerBeforeChildAt(count));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.380 -0400", hash_original_method = "86833A485E8343AB391A7321B35B1538", hash_generated_method = "E0CAB00AE4C4D95C5788F149B61D48F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void drawDividersHorizontal(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        int count;
        count = getVirtualChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = getVirtualChildAt(i);
                {
                    boolean varAD445368CB7F7DFBCAA93AD5AAA408ED_1033354665 = (child != null && child.getVisibility() != GONE);
                    {
                        {
                            boolean var5753280A391A92BDB591E4FED1D40DAB_1863841101 = (hasDividerBeforeChildAt(i));
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
            boolean var48BF1E2FEB752C0437BBA766958C3F15_1507110554 = (hasDividerBeforeChildAt(count));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.380 -0400", hash_original_method = "B34FB2DB2BC7F90A8C4BCDC4C5D2422E", hash_generated_method = "01056BB5DDC7B79716CE489E8D51F62D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.380 -0400", hash_original_method = "230D2DD24F19D940DC30A0FCA2C380AD", hash_generated_method = "3E049991505D4C54E6DE0D8325C33C7C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.380 -0400", hash_original_method = "F54465AC5542CF519D3902E7BAEA3188", hash_generated_method = "65A8D12E7195DA7D943F7D965BFA46E8")
    @DSModeled(DSC.SAFE)
    public boolean isBaselineAligned() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mBaselineAligned;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.380 -0400", hash_original_method = "8643C35E200A9ECC6F4D083B3C632ADD", hash_generated_method = "6B0DDF1E739AD964155F0A7178881DF8")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setBaselineAligned(boolean baselineAligned) {
        dsTaint.addTaint(baselineAligned);
        // ---------- Original Method ----------
        //mBaselineAligned = baselineAligned;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.381 -0400", hash_original_method = "49EB4E4C3BC63D2BEAA8F5D24053BB96", hash_generated_method = "41B92F6A697C030F2E51A9DDFB39E6D3")
    @DSModeled(DSC.SAFE)
    public boolean isMeasureWithLargestChildEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mUseLargestChild;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.381 -0400", hash_original_method = "55BFE46AC305D5ECEC6F564C443E4CAB", hash_generated_method = "AED24C3BF5522E72F8D67F869BFCDAAD")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setMeasureWithLargestChildEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        // ---------- Original Method ----------
        //mUseLargestChild = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.381 -0400", hash_original_method = "8677A7AE77B37457B2CE24BC40A0B2AA", hash_generated_method = "9F317EC3E2128ECB5DAF85D96E67FF3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getBaseline() {
        {
            int varEC5F70FA49520212A319ACA653FC0209_486213612 = (super.getBaseline());
        } //End block
        {
            boolean var0CC14488A448130ACFEBA1F25FFBD58A_733548523 = (getChildCount() <= mBaselineAlignedChildIndex);
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.381 -0400", hash_original_method = "90F550BFDC49A6587A7A8440E339A132", hash_generated_method = "A75D66C672DA4F245AFE964516CD4041")
    @DSModeled(DSC.SAFE)
    public int getBaselineAlignedChildIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBaselineAlignedChildIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.382 -0400", hash_original_method = "4CFC93DB175F8874B4EFFA335793DCB8", hash_generated_method = "11F9DDDC2D5BEEEE504E339683C6470F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public void setBaselineAlignedChildIndex(int i) {
        dsTaint.addTaint(i);
        {
            boolean varE9CD64879C792E1B66A251BAB70D8B08_204119721 = ((i < 0) || (i >= getChildCount()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("base aligned child index out "
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.382 -0400", hash_original_method = "87FE8C209A68A97BDFF0666E4CF673D3", hash_generated_method = "7D21A766C7AF9E9B0F77E6D41AA5E649")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     View getVirtualChildAt(int index) {
        dsTaint.addTaint(index);
        View var9C71C4887E5A21CEDD637E7AB6C81610_457830019 = (getChildAt(index));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getChildAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.382 -0400", hash_original_method = "04A766EF9FA40CCD4344368D3178C5E7", hash_generated_method = "2B596BE020CF574D9D552201477A3C89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getVirtualChildCount() {
        int varF41158137001188D2F9D08127BFB39DA_1403211836 = (getChildCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getChildCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.382 -0400", hash_original_method = "131E7E20664E8B649BC33F0915A0DE0D", hash_generated_method = "377AB734462597F2878C9783875315BB")
    @DSModeled(DSC.SAFE)
    public float getWeightSum() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mWeightSum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.382 -0400", hash_original_method = "47922B5280E89B2CF9B73D66705F0A8D", hash_generated_method = "A8ABF48CDEFC7A1CD472CB2CB032B557")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public void setWeightSum(float weightSum) {
        dsTaint.addTaint(weightSum);
        mWeightSum = Math.max(0.0f, weightSum);
        // ---------- Original Method ----------
        //mWeightSum = Math.max(0.0f, weightSum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.383 -0400", hash_original_method = "3F3B158F407FDE6BDDE91ED473E376D3", hash_generated_method = "7F5F2FD2428C77A4F9B7E8850838B6B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.383 -0400", hash_original_method = "E4A04FCA37D7E9FFFC1F15D63F30923E", hash_generated_method = "A2BA7A87D163CAD797352AC311D8F9D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean hasDividerBeforeChildAt(int childIndex) {
        dsTaint.addTaint(childIndex);
        {
            boolean var042391D18CFAA58040C07325508C3E5D_827163957 = (childIndex == getChildCount());
            {
                boolean hasVisibleViewBefore;
                hasVisibleViewBefore = false;
                {
                    int i;
                    i = childIndex - 1;
                    {
                        {
                            boolean var849B37533740585CFE18F837DD2EDAAB_129403973 = (getChildAt(i).getVisibility() != GONE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.385 -0400", hash_original_method = "A88B972B81C9E0D927EB1FAC25F8F6D1", hash_generated_method = "2096BB97317ECA4C3C6CF733AA20EF9F")
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
                    boolean varAE94D5328E94C6606865B35993EDD564_855763660 = (child.getVisibility() == View.GONE);
                    {
                        i += getChildrenSkipCount(child, i);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var53CA14277C14EA37C3E2B0E1BF193AF9_715778479 = (hasDividerBeforeChildAt(i));
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
            boolean varCC0767313899D8044991C6ED676480A0_1999935726 = (mTotalLength > 0 && hasDividerBeforeChildAt(count));
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
                        boolean var24A8049355A2DBEE0F9FC0F85F3CAA64_732642892 = (child.getVisibility() == GONE);
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
                        boolean varCE5DD5D436329456ACE82D8F3349CC31_1570893709 = (child.getVisibility() == View.GONE);
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
                            boolean varE7BB3503787C529D329422F9519818AF_1440104892 = (child == null || child.getVisibility() == View.GONE);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.386 -0400", hash_original_method = "AFA9034D947EBEF26850BC0782F132F9", hash_generated_method = "483FE7A46AD88E0ADDB8EC9A1A189A4B")
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
                View child;
                child = getVirtualChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_1662180962 = (child.getVisibility() != GONE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.389 -0400", hash_original_method = "22C04BEEA310D9DB4A6BB8F3656099B0", hash_generated_method = "DE170694D9A4192401F430BB052C5EBA")
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
                    boolean varE5A6421440835A22FD9C00B75E3D1565_1179037843 = (child.getVisibility() == GONE);
                    {
                        i += getChildrenSkipCount(child, i);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var53CA14277C14EA37C3E2B0E1BF193AF9_305958382 = (hasDividerBeforeChildAt(i));
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
            boolean varCC0767313899D8044991C6ED676480A0_1008288921 = (mTotalLength > 0 && hasDividerBeforeChildAt(count));
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
                        boolean var24A8049355A2DBEE0F9FC0F85F3CAA64_1488700611 = (child.getVisibility() == GONE);
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
                        boolean varF9B20D9EE469ED1FED42E2666426C840_1184790950 = (child == null || child.getVisibility() == View.GONE);
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
                            boolean varE7BB3503787C529D329422F9519818AF_19106 = (child == null || child.getVisibility() == View.GONE);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.390 -0400", hash_original_method = "FDF33FE6741A819E3461023969653A29", hash_generated_method = "4D336CCF0AD9A0747A20538142EBEE23")
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
                View child;
                child = getVirtualChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_1318264369 = (child.getVisibility() != GONE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.390 -0400", hash_original_method = "64CDF538399E47C38C21DACEFC8C1E08", hash_generated_method = "7A7FE27E65AA233E090583C638E7D2EB")
    @DSModeled(DSC.SAFE)
     int getChildrenSkipCount(View child, int index) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(index);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.390 -0400", hash_original_method = "0C791DFCDA5E7DFE7963EF393BDBDA11", hash_generated_method = "C5492B4D78DAA87064B8183468866AB8")
    @DSModeled(DSC.SAFE)
     int measureNullChild(int childIndex) {
        dsTaint.addTaint(childIndex);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.390 -0400", hash_original_method = "784157887C32A4B8D345E93BB13DEECA", hash_generated_method = "D974491B68D382943984003B7571BCC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void measureChildBeforeLayout(View child, int childIndex,
            int widthMeasureSpec, int totalWidth, int heightMeasureSpec,
            int totalHeight) {
        dsTaint.addTaint(totalWidth);
        dsTaint.addTaint(child.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.390 -0400", hash_original_method = "BA69BAE2E1D7A163D53D02D47016A6D7", hash_generated_method = "30CB69F3298FA225702C8F1D6F834B7C")
    @DSModeled(DSC.SAFE)
     int getLocationOffset(View child) {
        dsTaint.addTaint(child.dsTaint);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.390 -0400", hash_original_method = "6D7A4F846C7E828D32B84605EE3B545F", hash_generated_method = "84E2E7CA2D1595FE1822FC921BCC9FF2")
    @DSModeled(DSC.SAFE)
     int getNextLocationOffset(View child) {
        dsTaint.addTaint(child.dsTaint);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.391 -0400", hash_original_method = "38617BD257A07AF46AAF702E88FA7138", hash_generated_method = "C0004066AF78020A6B41780E5086FF92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.391 -0400", hash_original_method = "30B5FEA9EA0D751AC72456573A204452", hash_generated_method = "E9C1FD7535EF4CCFCAD44585BA5239F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_2022104369 = (child.getVisibility() != GONE);
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
                            boolean var5753280A391A92BDB591E4FED1D40DAB_1711608568 = (hasDividerBeforeChildAt(i));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.393 -0400", hash_original_method = "7E4C2E885F4FB677FEB4B548A065DB2A", hash_generated_method = "BB216B7FE6F5F26B7BB7B05E3FC1E85E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
            Object var9AC6381C3482ABA654889035FB8C338F_341521034 = (Gravity.getAbsoluteGravity(majorGravity, layoutDirection));
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
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_570794819 = (child.getVisibility() != GONE);
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
                            boolean varD92D197B47B02ED47C53CE932422B14B_1395613978 = (hasDividerBeforeChildAt(childIndex));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.394 -0400", hash_original_method = "74793CDC2820B7770CC6C7B645CE6A0C", hash_generated_method = "1DBD13C003493D0A73CDAFF5BAFBD1B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.394 -0400", hash_original_method = "708E6C59CCF6822D1254CF8F346C250A", hash_generated_method = "CDD0048DAEB23413C9D9598C3F5F05F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.395 -0400", hash_original_method = "6BA82D6B625174A8AC80664141F0D361", hash_generated_method = "C49909E54C7E79D696E3626D4AF41FEC")
    @DSModeled(DSC.SAFE)
    public int getOrientation() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mOrientation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.395 -0400", hash_original_method = "DC8D5E1211DE0926B9DDA2FADCED75EE", hash_generated_method = "3B2A8C4E1757D09B7B72842F491C0AD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.395 -0400", hash_original_method = "076C59065FCBD07F7CAA4FFA6D12CC3A", hash_generated_method = "DA1DAD49A4678F1572A82A3E14A6B5E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public void setHorizontalGravity(int horizontalGravity) {
        dsTaint.addTaint(horizontalGravity);
        int gravity;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.396 -0400", hash_original_method = "EE245B70888F9F1582A126D948173E64", hash_generated_method = "D4A6D8CE12687BBAE3E5D7CDDBBD64F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public void setVerticalGravity(int verticalGravity) {
        dsTaint.addTaint(verticalGravity);
        int gravity;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.396 -0400", hash_original_method = "5E749CCE267F5C755BAC22F4F9345284", hash_generated_method = "821E58CE2B6D65AC7BE88015B86BF35F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        LayoutParams var0D7DFC2F1FBC376957678EDDBBF7B432_404359845 = (new LinearLayout.LayoutParams(getContext(), attrs));
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LinearLayout.LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.396 -0400", hash_original_method = "3D6E4608F39560A7785B268309288C51", hash_generated_method = "88BB23550F6181974F9D03298A0E2748")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        {
            LayoutParams var5571C6056588847CD6332DF8044710D2_1345075946 = (new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        } //End block
        {
            LayoutParams var62B2CB5FE6501A3932D136712F8BE96B_1488810119 = (new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        } //End block
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mOrientation == HORIZONTAL) {
            //return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        //} else if (mOrientation == VERTICAL) {
            //return new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.396 -0400", hash_original_method = "E5FE95308BC48D9899CFDE5A4F7DEDB6", hash_generated_method = "5F212599D919FB64111611DD29E4EFF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        LayoutParams varAE4B968C4C0301DC2CC83C8A9F56D84B_441134259 = (new LayoutParams(p));
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LayoutParams(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.396 -0400", hash_original_method = "1F2E8350C10FBDB8051DCF8E5479411B", hash_generated_method = "BF35C137BF473CCD5C4393BADF3F49A0")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return p instanceof LinearLayout.LayoutParams;
    }

    
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        @ViewDebug.ExportedProperty(category = "layout") public float weight;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.397 -0400", hash_original_method = "C424BD779148A2828DEB0ABC94DCC73C", hash_generated_method = "5A58352BC413286D4777C0947DF72AEF")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.397 -0400", hash_original_method = "5675045EFCD4661F32116909A9822399", hash_generated_method = "FBE80F174A1AB4316527078FAD9F20CB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(int width, int height) {
            super(width, height);
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            weight = 0;
            // ---------- Original Method ----------
            //weight = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.397 -0400", hash_original_method = "4CDC4D1E7FEEFBC37A8F4BABF983F00D", hash_generated_method = "54DECEDCC3F5573D46EE3DD182B2E6D9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(int width, int height, float weight) {
            super(width, height);
            dsTaint.addTaint(weight);
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            // ---------- Original Method ----------
            //this.weight = weight;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.397 -0400", hash_original_method = "DE4ED36682A1028E303BDCC28A48E06F", hash_generated_method = "DC10E054913205A00413A13382A3D9EF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(ViewGroup.LayoutParams p) {
            super(p);
            dsTaint.addTaint(p.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.397 -0400", hash_original_method = "CC87BD4B8C067788FA2BA37DBA116F62", hash_generated_method = "A78E6D8B5140BBD99570D54F80CEC641")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(MarginLayoutParams source) {
            super(source);
            dsTaint.addTaint(source.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.397 -0400", hash_original_method = "09BB09F623D63D4B2B1AF033D2D5C9B4", hash_generated_method = "F3F348BF225C3767F7A12870DC13E229")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String debug(String output) {
            dsTaint.addTaint(output);
            String var4958517EC051F1887CA919D59A6C1F3C_279412951 = (output + "LinearLayout.LayoutParams={width=" + sizeToString(width) +
                    ", height=" + sizeToString(height) + " weight=" + weight +  "}");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return output + "LinearLayout.LayoutParams={width=" + sizeToString(width) +
                    //", height=" + sizeToString(height) + " weight=" + weight +  "}";
        }

        
    }


    
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_END = 4;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_TOP = 1;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_FILL = 3;
}

