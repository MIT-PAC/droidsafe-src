package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.340 -0400", hash_original_field = "C4AC870B117F9377D557E108C2F5864C", hash_generated_field = "49EF932FC6F54346B0D68DBE32BC1514")

    @ViewDebug.ExportedProperty(category = "layout") private boolean mBaselineAligned = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.340 -0400", hash_original_field = "C4FA8C15F1496E5D4914A441B3EF4877", hash_generated_field = "9479D6BEF70B8D911DE1D3E00E354445")

    @ViewDebug.ExportedProperty(category = "layout") private int mBaselineAlignedChildIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.340 -0400", hash_original_field = "74E8B6E6B0FDC4F4D8852726B0CC3BAD", hash_generated_field = "44D10AD5ECEE597BECDD4FB40534DC17")

    @ViewDebug.ExportedProperty(category = "measurement") private int mBaselineChildTop = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.340 -0400", hash_original_field = "7EA67827B94D10D1A4B368659EA63B71", hash_generated_field = "3C6DDBEC00F7F6467812B81CEA371C07")

    @ViewDebug.ExportedProperty(category = "measurement") private int mOrientation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.340 -0400", hash_original_field = "964B8A9513C01B9AF2664D1A54E32EEA", hash_generated_field = "EE266283EE900FDD2432D031F7395357")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.340 -0400", hash_original_field = "43703A9421153843DA88A5EE2D1672A0", hash_generated_field = "DE3BC85B85ECB21DC64AEE79C7BD6AB4")

    @ViewDebug.ExportedProperty(category = "measurement") private int mTotalLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.340 -0400", hash_original_field = "0B41BD4353E911E2EC90D6CA263443B7", hash_generated_field = "EF9873241C2DA21073158F3890B03884")

    @ViewDebug.ExportedProperty(category = "layout") private float mWeightSum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.340 -0400", hash_original_field = "0C8E174FC05FB87AC9CC0DB60A352BB7", hash_generated_field = "295836EFFBA80C7933F8A212CF2A587C")

    @ViewDebug.ExportedProperty(category = "layout") private boolean mUseLargestChild;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.340 -0400", hash_original_field = "091770C374CE70054C190C0FB419201A", hash_generated_field = "EAE955816B4A7ECE00EA7D8113667D8A")

    private int[] mMaxAscent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.340 -0400", hash_original_field = "54405F87D6BC3932D04A1754A96D3A3D", hash_generated_field = "59DC29D31F14D9C75D4CE10DB2E42CAF")

    private int[] mMaxDescent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.340 -0400", hash_original_field = "F2EB92D46BFACFA75ABCA33DC6179915", hash_generated_field = "D73292FD603C307DCBB538076F31C80F")

    private Drawable mDivider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.340 -0400", hash_original_field = "2CFB9EB3B0B1B519D9DE96130629CD90", hash_generated_field = "57640F4296EC1DBBA1FC773929C31009")

    private int mDividerWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.340 -0400", hash_original_field = "FDC96C666CAD9FBF2EF59762861622A0", hash_generated_field = "D39F10261E466E88A7BE2C17E757ADFE")

    private int mDividerHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.340 -0400", hash_original_field = "570DF19833C5FFBC7225A5E90145E2AD", hash_generated_field = "1313B8BA9906A262CF63E7F9653AB503")

    private int mShowDividers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.340 -0400", hash_original_field = "009CC63A514E465A3A03D8B8E546A1D2", hash_generated_field = "8407F81B00C5F4756EECF88D42950A05")

    private int mDividerPadding;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.341 -0400", hash_original_method = "FE94B0C3331DC48DD922B45C9927A2E5", hash_generated_method = "5599C5BD2C841CC6FACAC31E386AB809")
    public  LinearLayout(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.341 -0400", hash_original_method = "90765D7AD39C5FFE28F827609E4D9AAF", hash_generated_method = "925B6A265C6D1E46B0725F25315F719B")
    public  LinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.342 -0400", hash_original_method = "CABCB619C04E154CCE92AB7E91451BB7", hash_generated_method = "6833B51B38859D4EAD613A1C0A5FAC0D")
    public  LinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.LinearLayout, defStyle, 0);
        int index = a.getInt(com.android.internal.R.styleable.LinearLayout_orientation, -1);
    if(index >= 0)        
        {
            setOrientation(index);
        } //End block
        index = a.getInt(com.android.internal.R.styleable.LinearLayout_gravity, -1);
    if(index >= 0)        
        {
            setGravity(index);
        } //End block
        boolean baselineAligned = a.getBoolean(R.styleable.LinearLayout_baselineAligned, true);
    if(!baselineAligned)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.343 -0400", hash_original_method = "DE827128F1412AED640E145E58E9E69C", hash_generated_method = "7CBA722ED125D93A9D7BB408D7EDB08D")
    public void setShowDividers(int showDividers) {
    if(showDividers != mShowDividers)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.343 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "FB39164DDD584A49B27A896FF6C75B09")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean var68934A3E9455FA72420237EB05902327_125297238 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1463825164 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1463825164;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.344 -0400", hash_original_method = "81C750B99B14EF38CA21D36808CD7086", hash_generated_method = "A427781F26005B5885C79401FB15912E")
    public int getShowDividers() {
        int var570DF19833C5FFBC7225A5E90145E2AD_1813740512 = (mShowDividers);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_508851102 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_508851102;
        // ---------- Original Method ----------
        //return mShowDividers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.344 -0400", hash_original_method = "7357A0D71E9A27E2C8DA29FA77A144AF", hash_generated_method = "82782E560D2870C7945ABF58D1F3CD80")
    public void setDividerDrawable(Drawable divider) {
    if(divider == mDivider)        
        {
            return;
        } //End block
        mDivider = divider;
    if(divider != null)        
        {
            mDividerWidth = divider.getIntrinsicWidth();
            mDividerHeight = divider.getIntrinsicHeight();
        } //End block
        else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.345 -0400", hash_original_method = "E2E4F4C3D603F5F2D62C3F5CBAFDCC06", hash_generated_method = "21B19108F063ADDE197FAB8209A2015F")
    public void setDividerPadding(int padding) {
        mDividerPadding = padding;
        // ---------- Original Method ----------
        //mDividerPadding = padding;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.345 -0400", hash_original_method = "2F70F7AA30D3819DCD53286185A1CA49", hash_generated_method = "332F230F2E6C7256EBA2225C57DE109B")
    public int getDividerPadding() {
        int var009CC63A514E465A3A03D8B8E546A1D2_743750504 = (mDividerPadding);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_770201911 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_770201911;
        // ---------- Original Method ----------
        //return mDividerPadding;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.345 -0400", hash_original_method = "4DCD95C01B6B6891D72266EBA61909DF", hash_generated_method = "72A856A5553A2C36D015D991DD1CA41C")
    public int getDividerWidth() {
        int var2CFB9EB3B0B1B519D9DE96130629CD90_246453337 = (mDividerWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656306324 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656306324;
        // ---------- Original Method ----------
        //return mDividerWidth;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.345 -0400", hash_original_method = "4D234859DAD3D7D2BD3ABC15BDBCF93C", hash_generated_method = "7D984BD009131C8D48CBEC98ADBFAC87")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
    if(mDivider == null)        
        {
            return;
        } //End block
    if(mOrientation == VERTICAL)        
        {
            drawDividersVertical(canvas);
        } //End block
        else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.346 -0400", hash_original_method = "6F9B50C05500D3423B595FD6EF29F0C0", hash_generated_method = "15F074BFC7758753A85099824D599A72")
     void drawDividersVertical(Canvas canvas) {
        addTaint(canvas.getTaint());
        final int count = getVirtualChildCount();
for(int i = 0;i < count;i++)
        {
            final View child = getVirtualChildAt(i);
    if(child != null && child.getVisibility() != GONE)            
            {
    if(hasDividerBeforeChildAt(i))                
                {
                    final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                    final int top = child.getTop() - lp.topMargin;
                    drawHorizontalDivider(canvas, top);
                } //End block
            } //End block
        } //End block
    if(hasDividerBeforeChildAt(count))        
        {
            final View child = getVirtualChildAt(count - 1);
            int bottom = 0;
    if(child == null)            
            {
                bottom = getHeight() - getPaddingBottom() - mDividerHeight;
            } //End block
            else
            {
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                bottom = child.getBottom() + lp.bottomMargin;
            } //End block
            drawHorizontalDivider(canvas, bottom);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.347 -0400", hash_original_method = "86833A485E8343AB391A7321B35B1538", hash_generated_method = "9DCC6ED1D6359D1869F6BF398DE1CC50")
     void drawDividersHorizontal(Canvas canvas) {
        addTaint(canvas.getTaint());
        final int count = getVirtualChildCount();
for(int i = 0;i < count;i++)
        {
            final View child = getVirtualChildAt(i);
    if(child != null && child.getVisibility() != GONE)            
            {
    if(hasDividerBeforeChildAt(i))                
                {
                    final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                    final int left = child.getLeft() - lp.leftMargin;
                    drawVerticalDivider(canvas, left);
                } //End block
            } //End block
        } //End block
    if(hasDividerBeforeChildAt(count))        
        {
            final View child = getVirtualChildAt(count - 1);
            int right = 0;
    if(child == null)            
            {
                right = getWidth() - getPaddingRight() - mDividerWidth;
            } //End block
            else
            {
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                right = child.getRight() + lp.rightMargin;
            } //End block
            drawVerticalDivider(canvas, right);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.347 -0400", hash_original_method = "B34FB2DB2BC7F90A8C4BCDC4C5D2422E", hash_generated_method = "997FA67DAA7C4828D6949F265C63B0D9")
     void drawHorizontalDivider(Canvas canvas, int top) {
        addTaint(top);
        addTaint(canvas.getTaint());
        mDivider.setBounds(getPaddingLeft() + mDividerPadding, top,
                getWidth() - getPaddingRight() - mDividerPadding, top + mDividerHeight);
        mDivider.draw(canvas);
        // ---------- Original Method ----------
        //mDivider.setBounds(getPaddingLeft() + mDividerPadding, top,
                //getWidth() - getPaddingRight() - mDividerPadding, top + mDividerHeight);
        //mDivider.draw(canvas);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.348 -0400", hash_original_method = "230D2DD24F19D940DC30A0FCA2C380AD", hash_generated_method = "CA65736D232DD051018F52FAFA16E8D0")
     void drawVerticalDivider(Canvas canvas, int left) {
        addTaint(left);
        addTaint(canvas.getTaint());
        mDivider.setBounds(left, getPaddingTop() + mDividerPadding,
                left + mDividerWidth, getHeight() - getPaddingBottom() - mDividerPadding);
        mDivider.draw(canvas);
        // ---------- Original Method ----------
        //mDivider.setBounds(left, getPaddingTop() + mDividerPadding,
                //left + mDividerWidth, getHeight() - getPaddingBottom() - mDividerPadding);
        //mDivider.draw(canvas);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.348 -0400", hash_original_method = "F54465AC5542CF519D3902E7BAEA3188", hash_generated_method = "038A203A7B5F4F189D6D7E232A13D0DA")
    public boolean isBaselineAligned() {
        boolean var94134467590407890F5FDF30E2B51BBA_1426432400 = (mBaselineAligned);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1474507476 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1474507476;
        // ---------- Original Method ----------
        //return mBaselineAligned;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.348 -0400", hash_original_method = "8643C35E200A9ECC6F4D083B3C632ADD", hash_generated_method = "F5B36677A19813656057576482BE895F")
    @android.view.RemotableViewMethod
    public void setBaselineAligned(boolean baselineAligned) {
        mBaselineAligned = baselineAligned;
        // ---------- Original Method ----------
        //mBaselineAligned = baselineAligned;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.349 -0400", hash_original_method = "49EB4E4C3BC63D2BEAA8F5D24053BB96", hash_generated_method = "AB4F42A202AB5D47D2E8985F77E7687A")
    public boolean isMeasureWithLargestChildEnabled() {
        boolean var0C8E174FC05FB87AC9CC0DB60A352BB7_769363621 = (mUseLargestChild);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_360344302 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_360344302;
        // ---------- Original Method ----------
        //return mUseLargestChild;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.349 -0400", hash_original_method = "55BFE46AC305D5ECEC6F564C443E4CAB", hash_generated_method = "F0D8B5D04B16B58DE2D6932713E4CAD4")
    @android.view.RemotableViewMethod
    public void setMeasureWithLargestChildEnabled(boolean enabled) {
        mUseLargestChild = enabled;
        // ---------- Original Method ----------
        //mUseLargestChild = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.349 -0400", hash_original_method = "8677A7AE77B37457B2CE24BC40A0B2AA", hash_generated_method = "C0B1C7514243651E79669842B786A00F")
    @Override
    public int getBaseline() {
    if(mBaselineAlignedChildIndex < 0)        
        {
            int var304F84E20A7DBE8F7236867526CDC85A_1355571722 = (super.getBaseline());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_351692950 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_351692950;
        } //End block
    if(getChildCount() <= mBaselineAlignedChildIndex)        
        {
            RuntimeException varFEFE770BD7BDB06C5E9392176132839F_997658502 = new RuntimeException("mBaselineAlignedChildIndex of LinearLayout "
                    + "set to an index that is out of bounds.");
            varFEFE770BD7BDB06C5E9392176132839F_997658502.addTaint(taint);
            throw varFEFE770BD7BDB06C5E9392176132839F_997658502;
        } //End block
        final View child = getChildAt(mBaselineAlignedChildIndex);
        final int childBaseline = child.getBaseline();
    if(childBaseline == -1)        
        {
    if(mBaselineAlignedChildIndex == 0)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1040435260 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1721333559 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1721333559;
            } //End block
            RuntimeException varF6D0012B58E45442C5864C67D24ACFF3_1923904996 = new RuntimeException("mBaselineAlignedChildIndex of LinearLayout "
                    + "points to a View that doesn't know how to get its baseline.");
            varF6D0012B58E45442C5864C67D24ACFF3_1923904996.addTaint(taint);
            throw varF6D0012B58E45442C5864C67D24ACFF3_1923904996;
        } //End block
        int childTop = mBaselineChildTop;
    if(mOrientation == VERTICAL)        
        {
            final int majorGravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
    if(majorGravity != Gravity.TOP)            
            {
switch(majorGravity){
                case Gravity.BOTTOM:
                childTop = mBottom - mTop - mPaddingBottom - mTotalLength;
                break;
                case Gravity.CENTER_VERTICAL:
                childTop += ((mBottom - mTop - mPaddingTop - mPaddingBottom) -
                               mTotalLength) / 2;
                break;
}
            } //End block
        } //End block
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
        int var44411C6AC081710EF5DA192FAEBC73DC_256698783 = (childTop + lp.topMargin + childBaseline);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1884501085 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1884501085;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.350 -0400", hash_original_method = "90F550BFDC49A6587A7A8440E339A132", hash_generated_method = "94F7AF81FD65DB4B9CB38787DEF5D604")
    public int getBaselineAlignedChildIndex() {
        int varBB7128E3942208616EA854B374A737D2_1368027513 = (mBaselineAlignedChildIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_390455478 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_390455478;
        // ---------- Original Method ----------
        //return mBaselineAlignedChildIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.350 -0400", hash_original_method = "4CFC93DB175F8874B4EFFA335793DCB8", hash_generated_method = "9F4B3779EA47CF1EB702B666DF8F93BC")
    @android.view.RemotableViewMethod
    public void setBaselineAlignedChildIndex(int i) {
    if((i < 0) || (i >= getChildCount()))        
        {
            IllegalArgumentException var730FFC68678AECB993C773913A813872_105958805 = new IllegalArgumentException("base aligned child index out "
                    + "of range (0, " + getChildCount() + ")");
            var730FFC68678AECB993C773913A813872_105958805.addTaint(taint);
            throw var730FFC68678AECB993C773913A813872_105958805;
        } //End block
        mBaselineAlignedChildIndex = i;
        // ---------- Original Method ----------
        //if ((i < 0) || (i >= getChildCount())) {
            //throw new IllegalArgumentException("base aligned child index out "
                    //+ "of range (0, " + getChildCount() + ")");
        //}
        //mBaselineAlignedChildIndex = i;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.351 -0400", hash_original_method = "87FE8C209A68A97BDFF0666E4CF673D3", hash_generated_method = "9F608209CE1B9731F9952B2D767EA83D")
     View getVirtualChildAt(int index) {
        addTaint(index);
View varEB5FB2D1E3F8D0183D7A20330A95FD1E_337656075 =         getChildAt(index);
        varEB5FB2D1E3F8D0183D7A20330A95FD1E_337656075.addTaint(taint);
        return varEB5FB2D1E3F8D0183D7A20330A95FD1E_337656075;
        // ---------- Original Method ----------
        //return getChildAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.351 -0400", hash_original_method = "04A766EF9FA40CCD4344368D3178C5E7", hash_generated_method = "33191338A334084CB8ED3C5528BFAED8")
     int getVirtualChildCount() {
        int var9B10B38940134F290E8A5D1B402D3360_133387294 = (getChildCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_477048992 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_477048992;
        // ---------- Original Method ----------
        //return getChildCount();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.351 -0400", hash_original_method = "131E7E20664E8B649BC33F0915A0DE0D", hash_generated_method = "14BAC3BE6453C12438624A00B2BC7F01")
    public float getWeightSum() {
        float var0B41BD4353E911E2EC90D6CA263443B7_1911961503 = (mWeightSum);
                float var546ADE640B6EDFBC8A086EF31347E768_1414285432 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1414285432;
        // ---------- Original Method ----------
        //return mWeightSum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.352 -0400", hash_original_method = "47922B5280E89B2CF9B73D66705F0A8D", hash_generated_method = "0C909C9A2C5340B2F81C58E12B1C7283")
    @android.view.RemotableViewMethod
    public void setWeightSum(float weightSum) {
        mWeightSum = Math.max(0.0f, weightSum);
        // ---------- Original Method ----------
        //mWeightSum = Math.max(0.0f, weightSum);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.352 -0400", hash_original_method = "3F3B158F407FDE6BDDE91ED473E376D3", hash_generated_method = "38D57F229EDBAF022EF059A47EA4C0DB")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
    if(mOrientation == VERTICAL)        
        {
            measureVertical(widthMeasureSpec, heightMeasureSpec);
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.353 -0400", hash_original_method = "E4A04FCA37D7E9FFFC1F15D63F30923E", hash_generated_method = "B7ECD545D9135131CE7B3C16BA7C1168")
    protected boolean hasDividerBeforeChildAt(int childIndex) {
        addTaint(childIndex);
    if(childIndex == 0)        
        {
            boolean varF41BB1477049D31D1F4DCB9684F87CAF_1474134250 = ((mShowDividers & SHOW_DIVIDER_BEGINNING) != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_644803629 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_644803629;
        } //End block
        else
    if(childIndex == getChildCount())        
        {
            boolean var4A9B9AEEC047C1383E0DB657BFBE6D55_2112659255 = ((mShowDividers & SHOW_DIVIDER_END) != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1064446102 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1064446102;
        } //End block
        else
    if((mShowDividers & SHOW_DIVIDER_MIDDLE) != 0)        
        {
            boolean hasVisibleViewBefore = false;
for(int i = childIndex - 1;i >= 0;i--)
            {
    if(getChildAt(i).getVisibility() != GONE)                
                {
                    hasVisibleViewBefore = true;
                    break;
                } //End block
            } //End block
            boolean varD7B8F5363C26224A72C670D772A5097C_1269855362 = (hasVisibleViewBefore);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_734963749 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_734963749;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1848620940 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_338300546 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_338300546;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.361 -0400", hash_original_method = "A88B972B81C9E0D927EB1FAC25F8F6D1", hash_generated_method = "68D7F3FC91E16D5F81605F1EC753DC48")
     void measureVertical(int widthMeasureSpec, int heightMeasureSpec) {
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
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
for(int i = 0;i < count;++i)
        {
            final View child = getVirtualChildAt(i);
    if(child == null)            
            {
                mTotalLength += measureNullChild(i);
                continue;
            } //End block
    if(child.getVisibility() == View.GONE)            
            {
                i += getChildrenSkipCount(child, i);
                continue;
            } //End block
    if(hasDividerBeforeChildAt(i))            
            {
                mTotalLength += mDividerHeight;
            } //End block
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
            totalWeight += lp.weight;
    if(heightMode == MeasureSpec.EXACTLY && lp.height == 0 && lp.weight > 0)            
            {
                final int totalLength = mTotalLength;
                mTotalLength = Math.max(totalLength, totalLength + lp.topMargin + lp.bottomMargin);
            } //End block
            else
            {
                int oldHeight = Integer.MIN_VALUE;
    if(lp.height == 0 && lp.weight > 0)                
                {
                    oldHeight = 0;
                    lp.height = LayoutParams.WRAP_CONTENT;
                } //End block
                measureChildBeforeLayout(
                       child, i, widthMeasureSpec, 0, heightMeasureSpec,
                       totalWeight == 0 ? mTotalLength : 0);
    if(oldHeight != Integer.MIN_VALUE)                
                {
                    lp.height = oldHeight;
                } //End block
                final int childHeight = child.getMeasuredHeight();
                final int totalLength = mTotalLength;
                mTotalLength = Math.max(totalLength, totalLength + childHeight + lp.topMargin +
                       lp.bottomMargin + getNextLocationOffset(child));
    if(useLargestChild)                
                {
                    largestChildHeight = Math.max(childHeight, largestChildHeight);
                } //End block
            } //End block
    if((baselineChildIndex >= 0) && (baselineChildIndex == i + 1))            
            {
                mBaselineChildTop = mTotalLength;
            } //End block
    if(i < baselineChildIndex && lp.weight > 0)            
            {
                RuntimeException var8793DA4BC4BCAFD95C7429C6DFCF0E29_609179905 = new RuntimeException("A child of LinearLayout with index "
                        + "less than mBaselineAlignedChildIndex has weight > 0, which "
                        + "won't work.  Either remove the weight, or don't set "
                        + "mBaselineAlignedChildIndex.");
                var8793DA4BC4BCAFD95C7429C6DFCF0E29_609179905.addTaint(taint);
                throw var8793DA4BC4BCAFD95C7429C6DFCF0E29_609179905;
            } //End block
            boolean matchWidthLocally = false;
    if(widthMode != MeasureSpec.EXACTLY && lp.width == LayoutParams.MATCH_PARENT)            
            {
                matchWidth = true;
                matchWidthLocally = true;
            } //End block
            final int margin = lp.leftMargin + lp.rightMargin;
            final int measuredWidth = child.getMeasuredWidth() + margin;
            maxWidth = Math.max(maxWidth, measuredWidth);
            childState = combineMeasuredStates(childState, child.getMeasuredState());
            allFillParent = allFillParent && lp.width == LayoutParams.MATCH_PARENT;
    if(lp.weight > 0)            
            {
                weightedMaxWidth = Math.max(weightedMaxWidth,
                        matchWidthLocally ? margin : measuredWidth);
            } //End block
            else
            {
                alternativeMaxWidth = Math.max(alternativeMaxWidth,
                        matchWidthLocally ? margin : measuredWidth);
            } //End block
            i += getChildrenSkipCount(child, i);
        } //End block
    if(mTotalLength > 0 && hasDividerBeforeChildAt(count))        
        {
            mTotalLength += mDividerHeight;
        } //End block
    if(useLargestChild &&
                (heightMode == MeasureSpec.AT_MOST || heightMode == MeasureSpec.UNSPECIFIED))        
        {
            mTotalLength = 0;
for(int i = 0;i < count;++i)
            {
                final View child = getVirtualChildAt(i);
    if(child == null)                
                {
                    mTotalLength += measureNullChild(i);
                    continue;
                } //End block
    if(child.getVisibility() == GONE)                
                {
                    i += getChildrenSkipCount(child, i);
                    continue;
                } //End block
                final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)
                        child.getLayoutParams();
                final int totalLength = mTotalLength;
                mTotalLength = Math.max(totalLength, totalLength + largestChildHeight +
                        lp.topMargin + lp.bottomMargin + getNextLocationOffset(child));
            } //End block
        } //End block
        mTotalLength += mPaddingTop + mPaddingBottom;
        int heightSize = mTotalLength;
        heightSize = Math.max(heightSize, getSuggestedMinimumHeight());
        int heightSizeAndState = resolveSizeAndState(heightSize, heightMeasureSpec, 0);
        heightSize = heightSizeAndState & MEASURED_SIZE_MASK;
        int delta = heightSize - mTotalLength;
    if(delta != 0 && totalWeight > 0.0f)        
        {
            float weightSum = mWeightSum > 0.0f ? mWeightSum : totalWeight;
            mTotalLength = 0;
for(int i = 0;i < count;++i)
            {
                final View child = getVirtualChildAt(i);
    if(child.getVisibility() == View.GONE)                
                {
                    continue;
                } //End block
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                float childExtra = lp.weight;
    if(childExtra > 0)                
                {
                    int share = (int) (childExtra * delta / weightSum);
                    weightSum -= childExtra;
                    delta -= share;
                    final int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec,
                            mPaddingLeft + mPaddingRight +
                                    lp.leftMargin + lp.rightMargin, lp.width);
    if((lp.height != 0) || (heightMode != MeasureSpec.EXACTLY))                    
                    {
                        int childHeight = child.getMeasuredHeight() + share;
    if(childHeight < 0)                        
                        {
                            childHeight = 0;
                        } //End block
                        child.measure(childWidthMeasureSpec,
                                MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY));
                    } //End block
                    else
                    {
                        child.measure(childWidthMeasureSpec,
                                MeasureSpec.makeMeasureSpec(share > 0 ? share : 0,
                                        MeasureSpec.EXACTLY));
                    } //End block
                    childState = combineMeasuredStates(childState, child.getMeasuredState()
                            & (MEASURED_STATE_MASK>>MEASURED_HEIGHT_STATE_SHIFT));
                } //End block
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
            } //End block
            mTotalLength += mPaddingTop + mPaddingBottom;
        } //End block
        else
        {
            alternativeMaxWidth = Math.max(alternativeMaxWidth,
                                           weightedMaxWidth);
    if(useLargestChild && widthMode == MeasureSpec.UNSPECIFIED)            
            {
for(int i = 0;i < count;i++)
                {
                    final View child = getVirtualChildAt(i);
    if(child == null || child.getVisibility() == View.GONE)                    
                    {
                        continue;
                    } //End block
                    final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                    float childExtra = lp.weight;
    if(childExtra > 0)                    
                    {
                        child.measure(
                                MeasureSpec.makeMeasureSpec(child.getMeasuredWidth(),
                                        MeasureSpec.EXACTLY),
                                MeasureSpec.makeMeasureSpec(largestChildHeight,
                                        MeasureSpec.EXACTLY));
                    } //End block
                } //End block
            } //End block
        } //End block
    if(!allFillParent && widthMode != MeasureSpec.EXACTLY)        
        {
            maxWidth = alternativeMaxWidth;
        } //End block
        maxWidth += mPaddingLeft + mPaddingRight;
        maxWidth = Math.max(maxWidth, getSuggestedMinimumWidth());
        setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, childState),
                heightSizeAndState);
    if(matchWidth)        
        {
            forceUniformWidth(count, heightMeasureSpec);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.369 -0400", hash_original_method = "AFA9034D947EBEF26850BC0782F132F9", hash_generated_method = "E7E562C67A39ABD2CCC09C37FA391000")
    private void forceUniformWidth(int count, int heightMeasureSpec) {
        addTaint(heightMeasureSpec);
        addTaint(count);
        int uniformMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(),
                MeasureSpec.EXACTLY);
for(int i = 0;i< count;++i)
        {
            final View child = getVirtualChildAt(i);
    if(child.getVisibility() != GONE)            
            {
                LinearLayout.LayoutParams lp = ((LinearLayout.LayoutParams)child.getLayoutParams());
    if(lp.width == LayoutParams.MATCH_PARENT)                
                {
                    int oldHeight = lp.height;
                    lp.height = child.getMeasuredHeight();
                    measureChildWithMargins(child, uniformMeasureSpec, 0, heightMeasureSpec, 0);
                    lp.height = oldHeight;
                } //End block
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.381 -0400", hash_original_method = "22C04BEEA310D9DB4A6BB8F3656099B0", hash_generated_method = "A49918177F6E967A30C03C822B6EB391")
     void measureHorizontal(int widthMeasureSpec, int heightMeasureSpec) {
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
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
    if(mMaxAscent == null || mMaxDescent == null)        
        {
            mMaxAscent = new int[VERTICAL_GRAVITY_COUNT];
            mMaxDescent = new int[VERTICAL_GRAVITY_COUNT];
        } //End block
        final int[] maxAscent = mMaxAscent;
        final int[] maxDescent = mMaxDescent;
        maxAscent[0] = maxAscent[1] = maxAscent[2] = maxAscent[3] = -1;
        maxDescent[0] = maxDescent[1] = maxDescent[2] = maxDescent[3] = -1;
        final boolean baselineAligned = mBaselineAligned;
        final boolean useLargestChild = mUseLargestChild;
        final boolean isExactly = widthMode == MeasureSpec.EXACTLY;
        int largestChildWidth = Integer.MIN_VALUE;
for(int i = 0;i < count;++i)
        {
            final View child = getVirtualChildAt(i);
    if(child == null)            
            {
                mTotalLength += measureNullChild(i);
                continue;
            } //End block
    if(child.getVisibility() == GONE)            
            {
                i += getChildrenSkipCount(child, i);
                continue;
            } //End block
    if(hasDividerBeforeChildAt(i))            
            {
                mTotalLength += mDividerWidth;
            } //End block
            final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)
                    child.getLayoutParams();
            totalWeight += lp.weight;
    if(widthMode == MeasureSpec.EXACTLY && lp.width == 0 && lp.weight > 0)            
            {
    if(isExactly)                
                {
                    mTotalLength += lp.leftMargin + lp.rightMargin;
                } //End block
                else
                {
                    final int totalLength = mTotalLength;
                    mTotalLength = Math.max(totalLength, totalLength +
                            lp.leftMargin + lp.rightMargin);
                } //End block
    if(baselineAligned)                
                {
                    final int freeSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                    child.measure(freeSpec, freeSpec);
                } //End block
            } //End block
            else
            {
                int oldWidth = Integer.MIN_VALUE;
    if(lp.width == 0 && lp.weight > 0)                
                {
                    oldWidth = 0;
                    lp.width = LayoutParams.WRAP_CONTENT;
                } //End block
                measureChildBeforeLayout(child, i, widthMeasureSpec,
                        totalWeight == 0 ? mTotalLength : 0,
                        heightMeasureSpec, 0);
    if(oldWidth != Integer.MIN_VALUE)                
                {
                    lp.width = oldWidth;
                } //End block
                final int childWidth = child.getMeasuredWidth();
    if(isExactly)                
                {
                    mTotalLength += childWidth + lp.leftMargin + lp.rightMargin +
                            getNextLocationOffset(child);
                } //End block
                else
                {
                    final int totalLength = mTotalLength;
                    mTotalLength = Math.max(totalLength, totalLength + childWidth + lp.leftMargin +
                           lp.rightMargin + getNextLocationOffset(child));
                } //End block
    if(useLargestChild)                
                {
                    largestChildWidth = Math.max(childWidth, largestChildWidth);
                } //End block
            } //End block
            boolean matchHeightLocally = false;
    if(heightMode != MeasureSpec.EXACTLY && lp.height == LayoutParams.MATCH_PARENT)            
            {
                matchHeight = true;
                matchHeightLocally = true;
            } //End block
            final int margin = lp.topMargin + lp.bottomMargin;
            final int childHeight = child.getMeasuredHeight() + margin;
            childState = combineMeasuredStates(childState, child.getMeasuredState());
    if(baselineAligned)            
            {
                final int childBaseline = child.getBaseline();
    if(childBaseline != -1)                
                {
                    final int gravity = (lp.gravity < 0 ? mGravity : lp.gravity)
                            & Gravity.VERTICAL_GRAVITY_MASK;
                    final int index = ((gravity >> Gravity.AXIS_Y_SHIFT)
                            & ~Gravity.AXIS_SPECIFIED) >> 1;
                    maxAscent[index] = Math.max(maxAscent[index], childBaseline);
                    maxDescent[index] = Math.max(maxDescent[index], childHeight - childBaseline);
                } //End block
            } //End block
            maxHeight = Math.max(maxHeight, childHeight);
            allFillParent = allFillParent && lp.height == LayoutParams.MATCH_PARENT;
    if(lp.weight > 0)            
            {
                weightedMaxHeight = Math.max(weightedMaxHeight,
                        matchHeightLocally ? margin : childHeight);
            } //End block
            else
            {
                alternativeMaxHeight = Math.max(alternativeMaxHeight,
                        matchHeightLocally ? margin : childHeight);
            } //End block
            i += getChildrenSkipCount(child, i);
        } //End block
    if(mTotalLength > 0 && hasDividerBeforeChildAt(count))        
        {
            mTotalLength += mDividerWidth;
        } //End block
    if(maxAscent[INDEX_TOP] != -1 ||
                maxAscent[INDEX_CENTER_VERTICAL] != -1 ||
                maxAscent[INDEX_BOTTOM] != -1 ||
                maxAscent[INDEX_FILL] != -1)        
        {
            final int ascent = Math.max(maxAscent[INDEX_FILL],
                    Math.max(maxAscent[INDEX_CENTER_VERTICAL],
                    Math.max(maxAscent[INDEX_TOP], maxAscent[INDEX_BOTTOM])));
            final int descent = Math.max(maxDescent[INDEX_FILL],
                    Math.max(maxDescent[INDEX_CENTER_VERTICAL],
                    Math.max(maxDescent[INDEX_TOP], maxDescent[INDEX_BOTTOM])));
            maxHeight = Math.max(maxHeight, ascent + descent);
        } //End block
    if(useLargestChild &&
                (widthMode == MeasureSpec.AT_MOST || widthMode == MeasureSpec.UNSPECIFIED))        
        {
            mTotalLength = 0;
for(int i = 0;i < count;++i)
            {
                final View child = getVirtualChildAt(i);
    if(child == null)                
                {
                    mTotalLength += measureNullChild(i);
                    continue;
                } //End block
    if(child.getVisibility() == GONE)                
                {
                    i += getChildrenSkipCount(child, i);
                    continue;
                } //End block
                final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)
                        child.getLayoutParams();
    if(isExactly)                
                {
                    mTotalLength += largestChildWidth + lp.leftMargin + lp.rightMargin +
                            getNextLocationOffset(child);
                } //End block
                else
                {
                    final int totalLength = mTotalLength;
                    mTotalLength = Math.max(totalLength, totalLength + largestChildWidth +
                            lp.leftMargin + lp.rightMargin + getNextLocationOffset(child));
                } //End block
            } //End block
        } //End block
        mTotalLength += mPaddingLeft + mPaddingRight;
        int widthSize = mTotalLength;
        widthSize = Math.max(widthSize, getSuggestedMinimumWidth());
        int widthSizeAndState = resolveSizeAndState(widthSize, widthMeasureSpec, 0);
        widthSize = widthSizeAndState & MEASURED_SIZE_MASK;
        int delta = widthSize - mTotalLength;
    if(delta != 0 && totalWeight > 0.0f)        
        {
            float weightSum = mWeightSum > 0.0f ? mWeightSum : totalWeight;
            maxAscent[0] = maxAscent[1] = maxAscent[2] = maxAscent[3] = -1;
            maxDescent[0] = maxDescent[1] = maxDescent[2] = maxDescent[3] = -1;
            maxHeight = -1;
            mTotalLength = 0;
for(int i = 0;i < count;++i)
            {
                final View child = getVirtualChildAt(i);
    if(child == null || child.getVisibility() == View.GONE)                
                {
                    continue;
                } //End block
                final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                float childExtra = lp.weight;
    if(childExtra > 0)                
                {
                    int share = (int) (childExtra * delta / weightSum);
                    weightSum -= childExtra;
                    delta -= share;
                    final int childHeightMeasureSpec = getChildMeasureSpec(
                            heightMeasureSpec,
                            mPaddingTop + mPaddingBottom + lp.topMargin + lp.bottomMargin,
                            lp.height);
    if((lp.width != 0) || (widthMode != MeasureSpec.EXACTLY))                    
                    {
                        int childWidth = child.getMeasuredWidth() + share;
    if(childWidth < 0)                        
                        {
                            childWidth = 0;
                        } //End block
                        child.measure(
                            MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY),
                            childHeightMeasureSpec);
                    } //End block
                    else
                    {
                        child.measure(MeasureSpec.makeMeasureSpec(
                                share > 0 ? share : 0, MeasureSpec.EXACTLY),
                                childHeightMeasureSpec);
                    } //End block
                    childState = combineMeasuredStates(childState,
                            child.getMeasuredState() & MEASURED_STATE_MASK);
                } //End block
    if(isExactly)                
                {
                    mTotalLength += child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin +
                            getNextLocationOffset(child);
                } //End block
                else
                {
                    final int totalLength = mTotalLength;
                    mTotalLength = Math.max(totalLength, totalLength + child.getMeasuredWidth() +
                            lp.leftMargin + lp.rightMargin + getNextLocationOffset(child));
                } //End block
                boolean matchHeightLocally = heightMode != MeasureSpec.EXACTLY &&
                        lp.height == LayoutParams.MATCH_PARENT;
                final int margin = lp.topMargin + lp .bottomMargin;
                int childHeight = child.getMeasuredHeight() + margin;
                maxHeight = Math.max(maxHeight, childHeight);
                alternativeMaxHeight = Math.max(alternativeMaxHeight,
                        matchHeightLocally ? margin : childHeight);
                allFillParent = allFillParent && lp.height == LayoutParams.MATCH_PARENT;
    if(baselineAligned)                
                {
                    final int childBaseline = child.getBaseline();
    if(childBaseline != -1)                    
                    {
                        final int gravity = (lp.gravity < 0 ? mGravity : lp.gravity)
                                & Gravity.VERTICAL_GRAVITY_MASK;
                        final int index = ((gravity >> Gravity.AXIS_Y_SHIFT)
                                & ~Gravity.AXIS_SPECIFIED) >> 1;
                        maxAscent[index] = Math.max(maxAscent[index], childBaseline);
                        maxDescent[index] = Math.max(maxDescent[index],
                                childHeight - childBaseline);
                    } //End block
                } //End block
            } //End block
            mTotalLength += mPaddingLeft + mPaddingRight;
    if(maxAscent[INDEX_TOP] != -1 ||
                    maxAscent[INDEX_CENTER_VERTICAL] != -1 ||
                    maxAscent[INDEX_BOTTOM] != -1 ||
                    maxAscent[INDEX_FILL] != -1)            
            {
                final int ascent = Math.max(maxAscent[INDEX_FILL],
                        Math.max(maxAscent[INDEX_CENTER_VERTICAL],
                        Math.max(maxAscent[INDEX_TOP], maxAscent[INDEX_BOTTOM])));
                final int descent = Math.max(maxDescent[INDEX_FILL],
                        Math.max(maxDescent[INDEX_CENTER_VERTICAL],
                        Math.max(maxDescent[INDEX_TOP], maxDescent[INDEX_BOTTOM])));
                maxHeight = Math.max(maxHeight, ascent + descent);
            } //End block
        } //End block
        else
        {
            alternativeMaxHeight = Math.max(alternativeMaxHeight, weightedMaxHeight);
    if(useLargestChild && widthMode == MeasureSpec.UNSPECIFIED)            
            {
for(int i = 0;i < count;i++)
                {
                    final View child = getVirtualChildAt(i);
    if(child == null || child.getVisibility() == View.GONE)                    
                    {
                        continue;
                    } //End block
                    final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                    float childExtra = lp.weight;
    if(childExtra > 0)                    
                    {
                        child.measure(
                                MeasureSpec.makeMeasureSpec(largestChildWidth, MeasureSpec.EXACTLY),
                                MeasureSpec.makeMeasureSpec(child.getMeasuredHeight(),
                                        MeasureSpec.EXACTLY));
                    } //End block
                } //End block
            } //End block
        } //End block
    if(!allFillParent && heightMode != MeasureSpec.EXACTLY)        
        {
            maxHeight = alternativeMaxHeight;
        } //End block
        maxHeight += mPaddingTop + mPaddingBottom;
        maxHeight = Math.max(maxHeight, getSuggestedMinimumHeight());
        setMeasuredDimension(widthSizeAndState | (childState&MEASURED_STATE_MASK),
                resolveSizeAndState(maxHeight, heightMeasureSpec,
                        (childState<<MEASURED_HEIGHT_STATE_SHIFT)));
    if(matchHeight)        
        {
            forceUniformHeight(count, widthMeasureSpec);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.384 -0400", hash_original_method = "FDF33FE6741A819E3461023969653A29", hash_generated_method = "7E92C4F3B1EA9CF6E2222AB38E470F73")
    private void forceUniformHeight(int count, int widthMeasureSpec) {
        addTaint(widthMeasureSpec);
        addTaint(count);
        int uniformMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(),
                MeasureSpec.EXACTLY);
for(int i = 0;i < count;++i)
        {
            final View child = getVirtualChildAt(i);
    if(child.getVisibility() != GONE)            
            {
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
    if(lp.height == LayoutParams.MATCH_PARENT)                
                {
                    int oldWidth = lp.width;
                    lp.width = child.getMeasuredWidth();
                    measureChildWithMargins(child, widthMeasureSpec, 0, uniformMeasureSpec, 0);
                    lp.width = oldWidth;
                } //End block
            } //End block
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.384 -0400", hash_original_method = "64CDF538399E47C38C21DACEFC8C1E08", hash_generated_method = "BACF97EC16DA963ED054E7A9CA2EBBB4")
     int getChildrenSkipCount(View child, int index) {
        addTaint(index);
        addTaint(child.getTaint());
        int varCFCD208495D565EF66E7DFF9F98764DA_1343273198 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1848799535 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1848799535;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.385 -0400", hash_original_method = "0C791DFCDA5E7DFE7963EF393BDBDA11", hash_generated_method = "71C12321D1CF6970316031567A479A56")
     int measureNullChild(int childIndex) {
        addTaint(childIndex);
        int varCFCD208495D565EF66E7DFF9F98764DA_1227080938 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_838838573 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_838838573;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.385 -0400", hash_original_method = "784157887C32A4B8D345E93BB13DEECA", hash_generated_method = "F9E8D5B999C8D7666D577677A028AF8C")
     void measureChildBeforeLayout(View child, int childIndex,
            int widthMeasureSpec, int totalWidth, int heightMeasureSpec,
            int totalHeight) {
        addTaint(totalHeight);
        addTaint(heightMeasureSpec);
        addTaint(totalWidth);
        addTaint(widthMeasureSpec);
        addTaint(childIndex);
        addTaint(child.getTaint());
        measureChildWithMargins(child, widthMeasureSpec, totalWidth,
                heightMeasureSpec, totalHeight);
        // ---------- Original Method ----------
        //measureChildWithMargins(child, widthMeasureSpec, totalWidth,
                //heightMeasureSpec, totalHeight);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.386 -0400", hash_original_method = "BA69BAE2E1D7A163D53D02D47016A6D7", hash_generated_method = "F3230835FFD89737DD373E112382A5F0")
     int getLocationOffset(View child) {
        addTaint(child.getTaint());
        int varCFCD208495D565EF66E7DFF9F98764DA_249352959 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_781792213 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_781792213;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.386 -0400", hash_original_method = "6D7A4F846C7E828D32B84605EE3B545F", hash_generated_method = "2A7CDE0E46D110C53CD74E486A9E96E5")
     int getNextLocationOffset(View child) {
        addTaint(child.getTaint());
        int varCFCD208495D565EF66E7DFF9F98764DA_1631298927 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1857372896 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1857372896;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.386 -0400", hash_original_method = "38617BD257A07AF46AAF702E88FA7138", hash_generated_method = "B3E7499C806C69C5A24D37B8FEFE1CCB")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        addTaint(changed);
    if(mOrientation == VERTICAL)        
        {
            layoutVertical();
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.390 -0400", hash_original_method = "30B5FEA9EA0D751AC72456573A204452", hash_generated_method = "4A4010AD1C8FD7EC421A6D06E6A62CA9")
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
switch(majorGravity){
        case Gravity.BOTTOM:
        childTop = mPaddingTop + mBottom - mTop - mTotalLength;
        break;
        case Gravity.CENTER_VERTICAL:
        childTop = mPaddingTop + (mBottom - mTop - mTotalLength) / 2;
        break;
        case Gravity.TOP:
        default:
        childTop = mPaddingTop;
        break;
}for(int i = 0;i < count;i++)
        {
            final View child = getVirtualChildAt(i);
    if(child == null)            
            {
                childTop += measureNullChild(i);
            } //End block
            else
    if(child.getVisibility() != GONE)            
            {
                final int childWidth = child.getMeasuredWidth();
                final int childHeight = child.getMeasuredHeight();
                final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                int gravity = lp.gravity;
    if(gravity < 0)                
                {
                    gravity = minorGravity;
                } //End block
                final int layoutDirection = getResolvedLayoutDirection();
                final int absoluteGravity = Gravity.getAbsoluteGravity(gravity, layoutDirection);
switch(absoluteGravity & Gravity.HORIZONTAL_GRAVITY_MASK){
                case Gravity.CENTER_HORIZONTAL:
                childLeft = paddingLeft + ((childSpace - childWidth) / 2)
                                + lp.leftMargin - lp.rightMargin;
                break;
                case Gravity.RIGHT:
                childLeft = childRight - childWidth - lp.rightMargin;
                break;
                case Gravity.LEFT:
                default:
                childLeft = paddingLeft + lp.leftMargin;
                break;
}    if(hasDividerBeforeChildAt(i))                
                {
                    childTop += mDividerHeight;
                } //End block
                childTop += lp.topMargin;
                setChildFrame(child, childLeft, childTop + getLocationOffset(child),
                        childWidth, childHeight);
                childTop += childHeight + lp.bottomMargin + getNextLocationOffset(child);
                i += getChildrenSkipCount(child, i);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.394 -0400", hash_original_method = "7E4C2E885F4FB677FEB4B548A065DB2A", hash_generated_method = "0C185F5ED19B3C7CA6BAF8F7DFA058DD")
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
switch(Gravity.getAbsoluteGravity(majorGravity, layoutDirection)){
        case Gravity.RIGHT:
        childLeft = mPaddingLeft + mRight - mLeft - mTotalLength;
        break;
        case Gravity.CENTER_HORIZONTAL:
        childLeft = mPaddingLeft + (mRight - mLeft - mTotalLength) / 2;
        break;
        case Gravity.LEFT:
        default:
        childLeft = mPaddingLeft;
        break;
}        int start = 0;
        int dir = 1;
    if(isLayoutRtl)        
        {
            start = count - 1;
            dir = -1;
        } //End block
for(int i = 0;i < count;i++)
        {
            int childIndex = start + dir * i;
            final View child = getVirtualChildAt(childIndex);
    if(child == null)            
            {
                childLeft += measureNullChild(childIndex);
            } //End block
            else
    if(child.getVisibility() != GONE)            
            {
                final int childWidth = child.getMeasuredWidth();
                final int childHeight = child.getMeasuredHeight();
                int childBaseline = -1;
                final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
    if(baselineAligned && lp.height != LayoutParams.MATCH_PARENT)                
                {
                    childBaseline = child.getBaseline();
                } //End block
                int gravity = lp.gravity;
    if(gravity < 0)                
                {
                    gravity = minorGravity;
                } //End block
switch(gravity & Gravity.VERTICAL_GRAVITY_MASK){
                case Gravity.TOP:
                childTop = paddingTop + lp.topMargin;
    if(childBaseline != -1)                
                {
                    childTop += maxAscent[INDEX_TOP] - childBaseline;
                } //End block
                break;
                case Gravity.CENTER_VERTICAL:
                childTop = paddingTop + ((childSpace - childHeight) / 2)
                                + lp.topMargin - lp.bottomMargin;
                break;
                case Gravity.BOTTOM:
                childTop = childBottom - childHeight - lp.bottomMargin;
    if(childBaseline != -1)                
                {
                    int descent = child.getMeasuredHeight() - childBaseline;
                    childTop -= (maxDescent[INDEX_BOTTOM] - descent);
                } //End block
                break;
                default:
                childTop = paddingTop;
                break;
}    if(hasDividerBeforeChildAt(childIndex))                
                {
                    childLeft += mDividerWidth;
                } //End block
                childLeft += lp.leftMargin;
                setChildFrame(child, childLeft + getLocationOffset(child), childTop,
                        childWidth, childHeight);
                childLeft += childWidth + lp.rightMargin +
                        getNextLocationOffset(child);
                i += getChildrenSkipCount(child, childIndex);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.395 -0400", hash_original_method = "74793CDC2820B7770CC6C7B645CE6A0C", hash_generated_method = "BD26B7AE50FED9DA7F9954C0EB3295D4")
    private void setChildFrame(View child, int left, int top, int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(top);
        addTaint(left);
        addTaint(child.getTaint());
        child.layout(left, top, left + width, top + height);
        // ---------- Original Method ----------
        //child.layout(left, top, left + width, top + height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.395 -0400", hash_original_method = "708E6C59CCF6822D1254CF8F346C250A", hash_generated_method = "DDA1EA19BFC3775D1A0E8028F2128801")
    public void setOrientation(int orientation) {
    if(mOrientation != orientation)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.395 -0400", hash_original_method = "6BA82D6B625174A8AC80664141F0D361", hash_generated_method = "34E701BA95802C9A57DFFADE19A79854")
    public int getOrientation() {
        int var7EA67827B94D10D1A4B368659EA63B71_1286509691 = (mOrientation);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_298236533 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_298236533;
        // ---------- Original Method ----------
        //return mOrientation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.396 -0400", hash_original_method = "DC8D5E1211DE0926B9DDA2FADCED75EE", hash_generated_method = "9EC9CC9B5D5ABE7E2CDC34C12B8C039E")
    @android.view.RemotableViewMethod
    public void setGravity(int gravity) {
    if(mGravity != gravity)        
        {
    if((gravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 0)            
            {
                gravity |= Gravity.START;
            } //End block
    if((gravity & Gravity.VERTICAL_GRAVITY_MASK) == 0)            
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.397 -0400", hash_original_method = "076C59065FCBD07F7CAA4FFA6D12CC3A", hash_generated_method = "A03836F2AB6748AC9B219828C5EEA77B")
    @android.view.RemotableViewMethod
    public void setHorizontalGravity(int horizontalGravity) {
        addTaint(horizontalGravity);
        final int gravity = horizontalGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
    if((mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) != gravity)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.397 -0400", hash_original_method = "EE245B70888F9F1582A126D948173E64", hash_generated_method = "E89CA8A9E7442430CE8604395B3DB0DE")
    @android.view.RemotableViewMethod
    public void setVerticalGravity(int verticalGravity) {
        addTaint(verticalGravity);
        final int gravity = verticalGravity & Gravity.VERTICAL_GRAVITY_MASK;
    if((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != gravity)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.398 -0400", hash_original_method = "5E749CCE267F5C755BAC22F4F9345284", hash_generated_method = "EB932956E1368D89FBD0341F06835069")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        addTaint(attrs.getTaint());
LayoutParams var9E4D4AC4EFBD8BC1CA35BC67B09179A3_736049850 =         new LinearLayout.LayoutParams(getContext(), attrs);
        var9E4D4AC4EFBD8BC1CA35BC67B09179A3_736049850.addTaint(taint);
        return var9E4D4AC4EFBD8BC1CA35BC67B09179A3_736049850;
        // ---------- Original Method ----------
        //return new LinearLayout.LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.398 -0400", hash_original_method = "3D6E4608F39560A7785B268309288C51", hash_generated_method = "E29913E3E0DBC4031B053FDA59F4EFAD")
    @Override
    protected LayoutParams generateDefaultLayoutParams() {
    if(mOrientation == HORIZONTAL)        
        {
LayoutParams var65BA47367D3E2EC837A3E887EEE5A3B3_2033029187 =             new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            var65BA47367D3E2EC837A3E887EEE5A3B3_2033029187.addTaint(taint);
            return var65BA47367D3E2EC837A3E887EEE5A3B3_2033029187;
        } //End block
        else
    if(mOrientation == VERTICAL)        
        {
LayoutParams var091E483F65886435822B90D76F95575E_1362023936 =             new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            var091E483F65886435822B90D76F95575E_1362023936.addTaint(taint);
            return var091E483F65886435822B90D76F95575E_1362023936;
        } //End block
LayoutParams var540C13E9E156B687226421B24F2DF178_1781687435 =         null;
        var540C13E9E156B687226421B24F2DF178_1781687435.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1781687435;
        // ---------- Original Method ----------
        //if (mOrientation == HORIZONTAL) {
            //return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        //} else if (mOrientation == VERTICAL) {
            //return new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        //}
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.399 -0400", hash_original_method = "E5FE95308BC48D9899CFDE5A4F7DEDB6", hash_generated_method = "9CC3D2600C97A34AD1AC50C0D2AAEC2C")
    @Override
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
LayoutParams varB945D213E5036F8DDF9B40811234DF64_1677272845 =         new LayoutParams(p);
        varB945D213E5036F8DDF9B40811234DF64_1677272845.addTaint(taint);
        return varB945D213E5036F8DDF9B40811234DF64_1677272845;
        // ---------- Original Method ----------
        //return new LayoutParams(p);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.399 -0400", hash_original_method = "1F2E8350C10FBDB8051DCF8E5479411B", hash_generated_method = "024CE284246F8AF30239D14FAC6BD043")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean varE8A4E84A234E624ABC8A2C80DBE89514_1301407125 = (p instanceof LinearLayout.LayoutParams);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_530788827 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_530788827;
        // ---------- Original Method ----------
        //return p instanceof LinearLayout.LayoutParams;
    }

    
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.399 -0400", hash_original_field = "7EDABF994B76A00CBC60C95AF337DB8F", hash_generated_field = "B59DE7C019472A73872C811A2811FA3D")

        @ViewDebug.ExportedProperty(category = "layout") public float weight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.399 -0400", hash_original_field = "CF0F2AF9EE62920A17A205053A2F0423", hash_generated_field = "938DDF19CF8B381A3F6119E45B2090E8")

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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.400 -0400", hash_original_method = "C424BD779148A2828DEB0ABC94DCC73C", hash_generated_method = "2CE38A2FADFFCB60211F0C23A55B47CD")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            addTaint(attrs.getTaint());
            addTaint(c.getTaint());
            TypedArray a = c.obtainStyledAttributes(attrs, com.android.internal.R.styleable.LinearLayout_Layout);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.400 -0400", hash_original_method = "5675045EFCD4661F32116909A9822399", hash_generated_method = "4067848E063BCBBEBBBF1CFEC55A56CC")
        public  LayoutParams(int width, int height) {
            super(width, height);
            addTaint(height);
            addTaint(width);
            weight = 0;
            // ---------- Original Method ----------
            //weight = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.401 -0400", hash_original_method = "4CDC4D1E7FEEFBC37A8F4BABF983F00D", hash_generated_method = "3D51475771740DD0C6CB6F04D88C1917")
        public  LayoutParams(int width, int height, float weight) {
            super(width, height);
            addTaint(height);
            addTaint(width);
            this.weight = weight;
            // ---------- Original Method ----------
            //this.weight = weight;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.401 -0400", hash_original_method = "DE4ED36682A1028E303BDCC28A48E06F", hash_generated_method = "66B55E9EFECAB48B3D28D153941B8308")
        public  LayoutParams(ViewGroup.LayoutParams p) {
            super(p);
            addTaint(p.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.401 -0400", hash_original_method = "CC87BD4B8C067788FA2BA37DBA116F62", hash_generated_method = "BDFD9CE52FB4D6304CCFF1CA731BA0A9")
        public  LayoutParams(MarginLayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.401 -0400", hash_original_method = "09BB09F623D63D4B2B1AF033D2D5C9B4", hash_generated_method = "7ADA730E9EA9F229222332AEC9283891")
        @Override
        public String debug(String output) {
            addTaint(output.getTaint());
String var0F74E9E8D3216F29D376253899D0B9EB_2083434176 =             output + "LinearLayout.LayoutParams={width=" + sizeToString(width) +
                    ", height=" + sizeToString(height) + " weight=" + weight +  "}";
            var0F74E9E8D3216F29D376253899D0B9EB_2083434176.addTaint(taint);
            return var0F74E9E8D3216F29D376253899D0B9EB_2083434176;
            // ---------- Original Method ----------
            //return output + "LinearLayout.LayoutParams={width=" + sizeToString(width) +
                    //", height=" + sizeToString(height) + " weight=" + weight +  "}";
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.401 -0400", hash_original_field = "10CC209974739317E961EBD041018581", hash_generated_field = "AC2205EFFDAF899686D059A4EFB7832E")

    public static final int HORIZONTAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.402 -0400", hash_original_field = "B9A581C9879D3D62C7911745C0873959", hash_generated_field = "91DAF494B5C30478B3C457C5B0180E08")

    public static final int VERTICAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.402 -0400", hash_original_field = "8E79999F9F33DFB3FEA79372A82665CC", hash_generated_field = "0C5B8E328FB66A18A43839866930E8D4")

    public static final int SHOW_DIVIDER_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.402 -0400", hash_original_field = "A32E55A167CB9B1767289058C30ADA8B", hash_generated_field = "1DD6C5FF6610D03904D40069FE620989")

    public static final int SHOW_DIVIDER_BEGINNING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.402 -0400", hash_original_field = "B89CD3C872738F0B2E6C2ED3A7D520A1", hash_generated_field = "BA257B3BA3E7775EC6015D8CAB979002")

    public static final int SHOW_DIVIDER_MIDDLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.402 -0400", hash_original_field = "6DCA5BAE6370E56F53BB44B9146BA598", hash_generated_field = "DD4A6080B5F419CDA74F877B1348BFA3")

    public static final int SHOW_DIVIDER_END = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.402 -0400", hash_original_field = "D50D1954CC86BCF359A31F9E0FA36B86", hash_generated_field = "2ADB96257BCF6B94BEB08B7C805F3758")

    private static final int VERTICAL_GRAVITY_COUNT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.402 -0400", hash_original_field = "D29FEE3A1F7E065383FB6F36F4BE0ED7", hash_generated_field = "32CFAC2C2333762286EED0DC09E96431")

    private static final int INDEX_CENTER_VERTICAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.402 -0400", hash_original_field = "ED03692D3867A1965A1652C9AEAD08BC", hash_generated_field = "E642F731D98BFDC57447B50CB016F9AF")

    private static final int INDEX_TOP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.402 -0400", hash_original_field = "BD7D4E77C2437CF6BE5DE22C27EBF700", hash_generated_field = "FA5DBFD73C51FA836CD354A2027A09D5")

    private static final int INDEX_BOTTOM = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.402 -0400", hash_original_field = "CB9D90A00CF11F5A0D279367FF293389", hash_generated_field = "9750C44AFBABD80C054265737A88ED08")

    private static final int INDEX_FILL = 3;
}

