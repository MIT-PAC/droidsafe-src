package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;

public class LinearLayout extends ViewGroup {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.808 -0500", hash_original_field = "FBA6C9C5213832E18F5A01E0F1543E85", hash_generated_field = "AC2205EFFDAF899686D059A4EFB7832E")

    public static final int HORIZONTAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.810 -0500", hash_original_field = "E82176956A4DF716613C200537EEC301", hash_generated_field = "91DAF494B5C30478B3C457C5B0180E08")

    public static final int VERTICAL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.812 -0500", hash_original_field = "21A2B4E635B02DE3A8DFECE4AA9F6A02", hash_generated_field = "0C5B8E328FB66A18A43839866930E8D4")

    public static final int SHOW_DIVIDER_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.814 -0500", hash_original_field = "83900B28DFF569B2150EC91C47B4702D", hash_generated_field = "1DD6C5FF6610D03904D40069FE620989")

    public static final int SHOW_DIVIDER_BEGINNING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.817 -0500", hash_original_field = "5DD8CCF0EFC92980FB5EDA457B109763", hash_generated_field = "BA257B3BA3E7775EC6015D8CAB979002")

    public static final int SHOW_DIVIDER_MIDDLE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.820 -0500", hash_original_field = "3BB0A6F5679029320550BF3D05B95F10", hash_generated_field = "DD4A6080B5F419CDA74F877B1348BFA3")

    public static final int SHOW_DIVIDER_END = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.845 -0500", hash_original_field = "1D3A9536CCBB8A5004DA5871D6521680", hash_generated_field = "2ADB96257BCF6B94BEB08B7C805F3758")

    private static final int VERTICAL_GRAVITY_COUNT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.848 -0500", hash_original_field = "42186D9F215F3CF35A6F7BAD9CED0E8C", hash_generated_field = "32CFAC2C2333762286EED0DC09E96431")

    private static final int INDEX_CENTER_VERTICAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.851 -0500", hash_original_field = "EADD05467EC02284ACFA97A8F97C2E01", hash_generated_field = "E642F731D98BFDC57447B50CB016F9AF")

    private static final int INDEX_TOP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.853 -0500", hash_original_field = "DFD89AC3B72CF3841B6DAB5015B26CD9", hash_generated_field = "FA5DBFD73C51FA836CD354A2027A09D5")

    private static final int INDEX_BOTTOM = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.855 -0500", hash_original_field = "831C8E97C1C965CEA07809F348CFD99D", hash_generated_field = "9750C44AFBABD80C054265737A88ED08")

    private static final int INDEX_FILL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.823 -0500", hash_original_field = "FFF6B45354AB6B7ECAE10807B4542EDC", hash_generated_field = "49EF932FC6F54346B0D68DBE32BC1514")

    @ViewDebug.ExportedProperty(category = "layout")
    private boolean mBaselineAligned = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.825 -0500", hash_original_field = "6FA58B2E2E26C37908C9BF95371F27AF", hash_generated_field = "9479D6BEF70B8D911DE1D3E00E354445")

    @ViewDebug.ExportedProperty(category = "layout")
    private int mBaselineAlignedChildIndex = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.827 -0500", hash_original_field = "8BA1630A982E6CA15F40A069DE8DF387", hash_generated_field = "44D10AD5ECEE597BECDD4FB40534DC17")

    @ViewDebug.ExportedProperty(category = "measurement")
    private int mBaselineChildTop = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.829 -0500", hash_original_field = "9D3FC5FADE012FDDFCCC496073866451", hash_generated_field = "3C6DDBEC00F7F6467812B81CEA371C07")

    @ViewDebug.ExportedProperty(category = "measurement")
    private int mOrientation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.832 -0500", hash_original_field = "613BFEDA63FF8A3B7212201863D19750", hash_generated_field = "EE266283EE900FDD2432D031F7395357")

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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.835 -0500", hash_original_field = "1CE256E4F5677FEB8B9F6518DC4D0035", hash_generated_field = "DE3BC85B85ECB21DC64AEE79C7BD6AB4")

    @ViewDebug.ExportedProperty(category = "measurement")
    private int mTotalLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.837 -0500", hash_original_field = "2390EDB65C3F01D3B58AA9F800427A44", hash_generated_field = "EF9873241C2DA21073158F3890B03884")

    @ViewDebug.ExportedProperty(category = "layout")
    private float mWeightSum;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.839 -0500", hash_original_field = "13D5A6E6C7DF367CD3380625883A4BF2", hash_generated_field = "295836EFFBA80C7933F8A212CF2A587C")

    @ViewDebug.ExportedProperty(category = "layout")
    private boolean mUseLargestChild;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.841 -0500", hash_original_field = "3494FB6BCB44CD742F6CD7B83845512B", hash_generated_field = "EAE955816B4A7ECE00EA7D8113667D8A")

    private int[] mMaxAscent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.843 -0500", hash_original_field = "4D438510CEC43757766598753150A792", hash_generated_field = "59DC29D31F14D9C75D4CE10DB2E42CAF")

    private int[] mMaxDescent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.857 -0500", hash_original_field = "3837E71D24376BABDBC6EE7CD182AABB", hash_generated_field = "D73292FD603C307DCBB538076F31C80F")

    private Drawable mDivider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.859 -0500", hash_original_field = "C03C0EAD5BCD2EE4D0165D18AEA12E41", hash_generated_field = "57640F4296EC1DBBA1FC773929C31009")

    private int mDividerWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.861 -0500", hash_original_field = "E9BA9D611B13DC4B2EC5075D3CBC28DA", hash_generated_field = "D39F10261E466E88A7BE2C17E757ADFE")

    private int mDividerHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.863 -0500", hash_original_field = "4942877A1F996F87A9355AD13582E61B", hash_generated_field = "1313B8BA9906A262CF63E7F9653AB503")

    private int mShowDividers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.866 -0500", hash_original_field = "A85C191D0DE66B2E0F1EF12653C3612C", hash_generated_field = "8407F81B00C5F4756EECF88D42950A05")

    private int mDividerPadding;

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.868 -0500", hash_original_method = "FE94B0C3331DC48DD922B45C9927A2E5", hash_generated_method = "8B2A5CE3E06980F8A76CE3DD33ED334F")
    
public LinearLayout(Context context) {
        super(context);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.871 -0500", hash_original_method = "90765D7AD39C5FFE28F827609E4D9AAF", hash_generated_method = "4C7DDA589A635B38E56D20DF84A9773B")
    
public LinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public LinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        /*
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.LinearLayout, defStyle, 0);
        int index = a.getInt(com.android.internal.R.styleable.LinearLayout_orientation, -1);
        if (index >= 0) {
            setOrientation(index);
        }
        index = a.getInt(com.android.internal.R.styleable.LinearLayout_gravity, -1);
        if (index >= 0) {
            setGravity(index);
        }
        boolean baselineAligned = a.getBoolean(R.styleable.LinearLayout_baselineAligned, true);
        if (!baselineAligned) {
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
        */
    }
    
    public void setShowDividers(int showDividers) {
        addTaint(showDividers);
        requestLayout();
    }
    
    @Override
    public boolean shouldDelayChildPressedState() {
        return getTaintBoolean();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getShowDividers() {
        return getTaintInt();
    }
    
    public void setDividerDrawable(Drawable divider) {
        if (divider != null) {
            mDividerWidth = divider.getIntrinsicWidth();
            mDividerHeight = divider.getIntrinsicHeight();
        } else {
            mDividerWidth = 0;
            mDividerHeight = 0;
        }
        addTaint(divider.getIntrinsicWidth());
    }
    
    public void setDividerPadding(int padding) {
        addTaint(padding);
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getDividerPadding() {
        return getTaintInt();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getDividerWidth() {
        return getTaintInt();
    }
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @Override
    
    protected void onDraw(Canvas canvas) {
        drawDividersVertical(canvas);
        drawDividersHorizontal(canvas);
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void drawDividersVertical(Canvas canvas) {
        drawHorizontalDivider(canvas, 0);
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void drawDividersHorizontal(Canvas canvas) {
        drawVerticalDivider(canvas, 0);
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void drawHorizontalDivider(Canvas canvas, int top) {
        mDivider.setBounds(getTaintInt(), top, 0, 0);
        mDivider.draw(canvas);
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void drawVerticalDivider(Canvas canvas, int left) {
        mDivider.setBounds(getTaintInt(), left, 0, 0);
        mDivider.draw(canvas);
    }

    /**
     * <p>Indicates whether widgets contained within this layout are aligned
     * on their baseline or not.</p>
     *
     * @return true when widgets are baseline-aligned, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.903 -0500", hash_original_method = "F54465AC5542CF519D3902E7BAEA3188", hash_generated_method = "95F8C73C90D3F2BADD843A10BCF4F885")
    
public boolean isBaselineAligned() {
        return mBaselineAligned;
    }

    /**
     * <p>Defines whether widgets contained in this layout are
     * baseline-aligned or not.</p>
     *
     * @param baselineAligned true to align widgets on their baseline,
     *         false otherwise
     *
     * @attr ref android.R.styleable#LinearLayout_baselineAligned
     */
    @DSComment("Layout")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.905 -0500", hash_original_method = "8643C35E200A9ECC6F4D083B3C632ADD", hash_generated_method = "2D787394E95CBC96E68EE29B0748320D")
    
@android.view.RemotableViewMethod
    public void setBaselineAligned(boolean baselineAligned) {
        mBaselineAligned = baselineAligned;
    }

    /**
     * When true, all children with a weight will be considered having
     * the minimum size of the largest child. If false, all children are
     * measured normally.
     * 
     * @return True to measure children with a weight using the minimum
     *         size of the largest child, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.907 -0500", hash_original_method = "49EB4E4C3BC63D2BEAA8F5D24053BB96", hash_generated_method = "6316FE0C28F71E43C5CEBED904127F25")
    
public boolean isMeasureWithLargestChildEnabled() {
        return mUseLargestChild;
    }

    /**
     * When set to true, all children with a weight will be considered having
     * the minimum size of the largest child. If false, all children are
     * measured normally.
     * 
     * Disabled by default.
     * 
     * @param enabled True to measure children with a weight using the
     *        minimum size of the largest child, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.909 -0500", hash_original_method = "55BFE46AC305D5ECEC6F564C443E4CAB", hash_generated_method = "94646E7D8D995048B562A3020E56C111")
    
@android.view.RemotableViewMethod
    public void setMeasureWithLargestChildEnabled(boolean enabled) {
        mUseLargestChild = enabled;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.913 -0500", hash_original_method = "8677A7AE77B37457B2CE24BC40A0B2AA", hash_generated_method = "5FF2804CC39F25A1046DE4EB2474B683")
    
@Override
    public int getBaseline() {
        if (mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }

        if (getChildCount() <= mBaselineAlignedChildIndex) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout "
                    + "set to an index that is out of bounds.");
        }

        final View child = getChildAt(mBaselineAlignedChildIndex);
        final int childBaseline = child.getBaseline();

        if (childBaseline == -1) {
            if (mBaselineAlignedChildIndex == 0) {
                // this is just the default case, safe to return -1
                return -1;
            }
            // the user picked an index that points to something that doesn't
            // know how to calculate its baseline.
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout "
                    + "points to a View that doesn't know how to get its baseline.");
        }

        // TODO: This should try to take into account the virtual offsets
        // (See getNextLocationOffset and getLocationOffset)
        // We should add to childTop:
        // sum([getNextLocationOffset(getChildAt(i)) / i < mBaselineAlignedChildIndex])
        // and also add:
        // getLocationOffset(child)
        int childTop = mBaselineChildTop;

        if (mOrientation == VERTICAL) {
            final int majorGravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
            if (majorGravity != Gravity.TOP) {
               switch (majorGravity) {
                   case Gravity.BOTTOM:
                       childTop = mBottom - mTop - mPaddingBottom - mTotalLength;
                       break;

                   case Gravity.CENTER_VERTICAL:
                       childTop += ((mBottom - mTop - mPaddingTop - mPaddingBottom) -
                               mTotalLength) / 2;
                       break;
               }
            }
        }

        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
        return childTop + lp.topMargin + childBaseline;
    }

    /**
     * @return The index of the child that will be used if this layout is
     *   part of a larger layout that is baseline aligned, or -1 if none has
     *   been set.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.915 -0500", hash_original_method = "90F550BFDC49A6587A7A8440E339A132", hash_generated_method = "60E71E80EA1054765A7B4F72AC229618")
    
public int getBaselineAlignedChildIndex() {
        return mBaselineAlignedChildIndex;
    }

    /**
     * @param i The index of the child that will be used if this layout is
     *          part of a larger layout that is baseline aligned.
     * 
     * @attr ref android.R.styleable#LinearLayout_baselineAlignedChildIndex
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.917 -0500", hash_original_method = "4CFC93DB175F8874B4EFFA335793DCB8", hash_generated_method = "2D49A718EAB11EE5DB2F636BA301ABD0")
    
@android.view.RemotableViewMethod
    public void setBaselineAlignedChildIndex(int i) {
        if ((i < 0) || (i >= getChildCount())) {
            throw new IllegalArgumentException("base aligned child index out "
                    + "of range (0, " + getChildCount() + ")");
        }
        mBaselineAlignedChildIndex = i;
    }

    /**
     * <p>Returns the view at the specified index. This method can be overriden
     * to take into account virtual children. Refer to
     * {@link android.widget.TableLayout} and {@link android.widget.TableRow}
     * for an example.</p>
     *
     * @param index the child's index
     * @return the child at the specified index
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.919 -0500", hash_original_method = "87FE8C209A68A97BDFF0666E4CF673D3", hash_generated_method = "87FE8C209A68A97BDFF0666E4CF673D3")
    
View getVirtualChildAt(int index) {
        return getChildAt(index);
    }

    /**
     * <p>Returns the virtual number of children. This number might be different
     * than the actual number of children if the layout can hold virtual
     * children. Refer to
     * {@link android.widget.TableLayout} and {@link android.widget.TableRow}
     * for an example.</p>
     *
     * @return the virtual number of children
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.921 -0500", hash_original_method = "04A766EF9FA40CCD4344368D3178C5E7", hash_generated_method = "04A766EF9FA40CCD4344368D3178C5E7")
    
int getVirtualChildCount() {
        return getChildCount();
    }

    /**
     * Returns the desired weights sum.
     *
     * @return A number greater than 0.0f if the weight sum is defined, or
     *         a number lower than or equals to 0.0f if not weight sum is
     *         to be used.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.923 -0500", hash_original_method = "131E7E20664E8B649BC33F0915A0DE0D", hash_generated_method = "D9E3D512993B2A8EFED07BD9D9494601")
    
public float getWeightSum() {
        return mWeightSum;
    }

    /**
     * Defines the desired weights sum. If unspecified the weights sum is computed
     * at layout time by adding the layout_weight of each child.
     *
     * This can be used for instance to give a single child 50% of the total
     * available space by giving it a layout_weight of 0.5 and setting the
     * weightSum to 1.0.
     *
     * @param weightSum a number greater than 0.0f, or a number lower than or equals
     *        to 0.0f if the weight sum should be computed from the children's
     *        layout_weight
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.925 -0500", hash_original_method = "47922B5280E89B2CF9B73D66705F0A8D", hash_generated_method = "5B4CD5F9CDB4653DC8C1F81264D59EB3")
    
@android.view.RemotableViewMethod
    public void setWeightSum(float weightSum) {
        mWeightSum = Math.max(0.0f, weightSum);
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.928 -0500", hash_original_method = "3F3B158F407FDE6BDDE91ED473E376D3", hash_generated_method = "3DD5D1F2240F26C7DCAFE31632C527E7")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mOrientation == VERTICAL) {
            measureVertical(widthMeasureSpec, heightMeasureSpec);
        } else {
            measureHorizontal(widthMeasureSpec, heightMeasureSpec);
        }
    }

    /**
     * Determines where to position dividers between children.
     *
     * @param childIndex Index of child to check for preceding divider
     * @return true if there should be a divider before the child at childIndex
     * @hide Pending API consideration. Currently only used internally by the system.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.931 -0500", hash_original_method = "E4A04FCA37D7E9FFFC1F15D63F30923E", hash_generated_method = "941CB903E09ACFA666CAB312718BD14B")
    
protected boolean hasDividerBeforeChildAt(int childIndex) {
        if (childIndex == 0) {
            return (mShowDividers & SHOW_DIVIDER_BEGINNING) != 0;
        } else if (childIndex == getChildCount()) {
            return (mShowDividers & SHOW_DIVIDER_END) != 0;
        } else if ((mShowDividers & SHOW_DIVIDER_MIDDLE) != 0) {
            boolean hasVisibleViewBefore = false;
            for (int i = childIndex - 1; i >= 0; i--) {
                if (getChildAt(i).getVisibility() != GONE) {
                    hasVisibleViewBefore = true;
                    break;
                }
            }
            return hasVisibleViewBefore;
        }
        return false;
    }

    /**
     * Measures the children when the orientation of this LinearLayout is set
     * to {@link #VERTICAL}.
     *
     * @param widthMeasureSpec Horizontal space requirements as imposed by the parent.
     * @param heightMeasureSpec Vertical space requirements as imposed by the parent.
     *
     * @see #getOrientation()
     * @see #setOrientation(int)
     * @see #onMeasure(int, int)
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.938 -0500", hash_original_method = "A88B972B81C9E0D927EB1FAC25F8F6D1", hash_generated_method = "361D6AE5BBEB079D7684F9677B3DC169")
    
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

        // See how tall everyone is. Also remember max width.
        for (int i = 0; i < count; ++i) {
            final View child = getVirtualChildAt(i);

            if (child == null) {
                mTotalLength += measureNullChild(i);
                continue;
            }

            if (child.getVisibility() == View.GONE) {
               i += getChildrenSkipCount(child, i);
               continue;
            }

            if (hasDividerBeforeChildAt(i)) {
                mTotalLength += mDividerHeight;
            }

            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();

            totalWeight += lp.weight;
            
            if (heightMode == MeasureSpec.EXACTLY && lp.height == 0 && lp.weight > 0) {
                // Optimization: don't bother measuring children who are going to use
                // leftover space. These views will get measured again down below if
                // there is any leftover space.
                final int totalLength = mTotalLength;
                mTotalLength = Math.max(totalLength, totalLength + lp.topMargin + lp.bottomMargin);
            } else {
                int oldHeight = Integer.MIN_VALUE;

                if (lp.height == 0 && lp.weight > 0) {
                    // heightMode is either UNSPECIFIED or AT_MOST, and this
                    // child wanted to stretch to fill available space.
                    // Translate that to WRAP_CONTENT so that it does not end up
                    // with a height of 0
                    oldHeight = 0;
                    lp.height = LayoutParams.WRAP_CONTENT;
                }

                // Determine how big this child would like to be. If this or
                // previous children have given a weight, then we allow it to
                // use all available space (and we will shrink things later
                // if needed).
                measureChildBeforeLayout(
                       child, i, widthMeasureSpec, 0, heightMeasureSpec,
                       totalWeight == 0 ? mTotalLength : 0);

                if (oldHeight != Integer.MIN_VALUE) {
                   lp.height = oldHeight;
                }

                final int childHeight = child.getMeasuredHeight();
                final int totalLength = mTotalLength;
                mTotalLength = Math.max(totalLength, totalLength + childHeight + lp.topMargin +
                       lp.bottomMargin + getNextLocationOffset(child));

                if (useLargestChild) {
                    largestChildHeight = Math.max(childHeight, largestChildHeight);
                }
            }

            /**
             * If applicable, compute the additional offset to the child's baseline
             * we'll need later when asked {@link #getBaseline}.
             */
            if ((baselineChildIndex >= 0) && (baselineChildIndex == i + 1)) {
               mBaselineChildTop = mTotalLength;
            }

            // if we are trying to use a child index for our baseline, the above
            // book keeping only works if there are no children above it with
            // weight.  fail fast to aid the developer.
            if (i < baselineChildIndex && lp.weight > 0) {
                throw new RuntimeException("A child of LinearLayout with index "
                        + "less than mBaselineAlignedChildIndex has weight > 0, which "
                        + "won't work.  Either remove the weight, or don't set "
                        + "mBaselineAlignedChildIndex.");
            }

            boolean matchWidthLocally = false;
            if (widthMode != MeasureSpec.EXACTLY && lp.width == LayoutParams.MATCH_PARENT) {
                // The width of the linear layout will scale, and at least one
                // child said it wanted to match our width. Set a flag
                // indicating that we need to remeasure at least that view when
                // we know our width.
                matchWidth = true;
                matchWidthLocally = true;
            }

            final int margin = lp.leftMargin + lp.rightMargin;
            final int measuredWidth = child.getMeasuredWidth() + margin;
            maxWidth = Math.max(maxWidth, measuredWidth);
            childState = combineMeasuredStates(childState, child.getMeasuredState());

            allFillParent = allFillParent && lp.width == LayoutParams.MATCH_PARENT;
            if (lp.weight > 0) {
                /*
                 * Widths of weighted Views are bogus if we end up
                 * remeasuring, so keep them separate.
                 */
                weightedMaxWidth = Math.max(weightedMaxWidth,
                        matchWidthLocally ? margin : measuredWidth);
            } else {
                alternativeMaxWidth = Math.max(alternativeMaxWidth,
                        matchWidthLocally ? margin : measuredWidth);
            }

            i += getChildrenSkipCount(child, i);
        }

        if (mTotalLength > 0 && hasDividerBeforeChildAt(count)) {
            mTotalLength += mDividerHeight;
        }

        if (useLargestChild &&
                (heightMode == MeasureSpec.AT_MOST || heightMode == MeasureSpec.UNSPECIFIED)) {
            mTotalLength = 0;

            for (int i = 0; i < count; ++i) {
                final View child = getVirtualChildAt(i);

                if (child == null) {
                    mTotalLength += measureNullChild(i);
                    continue;
                }

                if (child.getVisibility() == GONE) {
                    i += getChildrenSkipCount(child, i);
                    continue;
                }

                final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)
                        child.getLayoutParams();
                // Account for negative margins
                final int totalLength = mTotalLength;
                mTotalLength = Math.max(totalLength, totalLength + largestChildHeight +
                        lp.topMargin + lp.bottomMargin + getNextLocationOffset(child));
            }
        }

        // Add in our padding
        mTotalLength += mPaddingTop + mPaddingBottom;

        int heightSize = mTotalLength;

        // Check against our minimum height
        heightSize = Math.max(heightSize, getSuggestedMinimumHeight());
        
        // Reconcile our calculated size with the heightMeasureSpec
        int heightSizeAndState = resolveSizeAndState(heightSize, heightMeasureSpec, 0);
        heightSize = heightSizeAndState & MEASURED_SIZE_MASK;
        
        // Either expand children with weight to take up available space or
        // shrink them if they extend beyond our current bounds
        int delta = heightSize - mTotalLength;
        if (delta != 0 && totalWeight > 0.0f) {
            float weightSum = mWeightSum > 0.0f ? mWeightSum : totalWeight;

            mTotalLength = 0;

            for (int i = 0; i < count; ++i) {
                final View child = getVirtualChildAt(i);
                
                if (child.getVisibility() == View.GONE) {
                    continue;
                }
                
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                
                float childExtra = lp.weight;
                if (childExtra > 0) {
                    // Child said it could absorb extra space -- give him his share
                    int share = (int) (childExtra * delta / weightSum);
                    weightSum -= childExtra;
                    delta -= share;

                    final int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec,
                            mPaddingLeft + mPaddingRight +
                                    lp.leftMargin + lp.rightMargin, lp.width);

                    // TODO: Use a field like lp.isMeasured to figure out if this
                    // child has been previously measured
                    if ((lp.height != 0) || (heightMode != MeasureSpec.EXACTLY)) {
                        // child was measured once already above...
                        // base new measurement on stored values
                        int childHeight = child.getMeasuredHeight() + share;
                        if (childHeight < 0) {
                            childHeight = 0;
                        }
                        
                        child.measure(childWidthMeasureSpec,
                                MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY));
                    } else {
                        // child was skipped in the loop above.
                        // Measure for this first time here      
                        child.measure(childWidthMeasureSpec,
                                MeasureSpec.makeMeasureSpec(share > 0 ? share : 0,
                                        MeasureSpec.EXACTLY));
                    }

                    // Child may now not fit in vertical dimension.
                    childState = combineMeasuredStates(childState, child.getMeasuredState()
                            & (MEASURED_STATE_MASK>>MEASURED_HEIGHT_STATE_SHIFT));
                }

                final int margin =  lp.leftMargin + lp.rightMargin;
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

            // Add in our padding
            mTotalLength += mPaddingTop + mPaddingBottom;
            // TODO: Should we recompute the heightSpec based on the new total length?
        } else {
            alternativeMaxWidth = Math.max(alternativeMaxWidth,
                                           weightedMaxWidth);

            // We have no limit, so make all weighted views as tall as the largest child.
            // Children will have already been measured once.
            if (useLargestChild && widthMode == MeasureSpec.UNSPECIFIED) {
                for (int i = 0; i < count; i++) {
                    final View child = getVirtualChildAt(i);

                    if (child == null || child.getVisibility() == View.GONE) {
                        continue;
                    }

                    final LinearLayout.LayoutParams lp =
                            (LinearLayout.LayoutParams) child.getLayoutParams();

                    float childExtra = lp.weight;
                    if (childExtra > 0) {
                        child.measure(
                                MeasureSpec.makeMeasureSpec(child.getMeasuredWidth(),
                                        MeasureSpec.EXACTLY),
                                MeasureSpec.makeMeasureSpec(largestChildHeight,
                                        MeasureSpec.EXACTLY));
                    }
                }
            }
        }

        if (!allFillParent && widthMode != MeasureSpec.EXACTLY) {
            maxWidth = alternativeMaxWidth;
        }
        
        maxWidth += mPaddingLeft + mPaddingRight;

        // Check against our minimum width
        maxWidth = Math.max(maxWidth, getSuggestedMinimumWidth());
        
        setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, childState),
                heightSizeAndState);

        if (matchWidth) {
            forceUniformWidth(count, heightMeasureSpec);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.941 -0500", hash_original_method = "AFA9034D947EBEF26850BC0782F132F9", hash_generated_method = "5CDFBA265252E69A2E6A94802E18344C")
    
private void forceUniformWidth(int count, int heightMeasureSpec) {
        // Pretend that the linear layout has an exact size.
        int uniformMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(),
                MeasureSpec.EXACTLY);
        for (int i = 0; i< count; ++i) {
           final View child = getVirtualChildAt(i);
           if (child.getVisibility() != GONE) { 
               LinearLayout.LayoutParams lp = ((LinearLayout.LayoutParams)child.getLayoutParams());
               
               if (lp.width == LayoutParams.MATCH_PARENT) {
                   // Temporarily force children to reuse their old measured height
                   // FIXME: this may not be right for something like wrapping text?
                   int oldHeight = lp.height;
                   lp.height = child.getMeasuredHeight();
                   
                   // Remeasue with new dimensions
                   measureChildWithMargins(child, uniformMeasureSpec, 0, heightMeasureSpec, 0);
                   lp.height = oldHeight;
               }
           }
        }
    }

    /**
     * Measures the children when the orientation of this LinearLayout is set
     * to {@link #HORIZONTAL}.
     *
     * @param widthMeasureSpec Horizontal space requirements as imposed by the parent.
     * @param heightMeasureSpec Vertical space requirements as imposed by the parent.
     *
     * @see #getOrientation()
     * @see #setOrientation(int)
     * @see #onMeasure(int, int) 
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.950 -0500", hash_original_method = "22C04BEEA310D9DB4A6BB8F3656099B0", hash_generated_method = "68A3F1CAE782CD28B343A3F110136620")
    
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

        if (mMaxAscent == null || mMaxDescent == null) {
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

        // See how wide everyone is. Also remember max height.
        for (int i = 0; i < count; ++i) {
            final View child = getVirtualChildAt(i);

            if (child == null) {
                mTotalLength += measureNullChild(i);
                continue;
            }
           
            if (child.getVisibility() == GONE) {
                i += getChildrenSkipCount(child, i);
                continue;
            }

            if (hasDividerBeforeChildAt(i)) {
                mTotalLength += mDividerWidth;
            }

            final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)
                    child.getLayoutParams();

            totalWeight += lp.weight;
            
            if (widthMode == MeasureSpec.EXACTLY && lp.width == 0 && lp.weight > 0) {
                // Optimization: don't bother measuring children who are going to use
                // leftover space. These views will get measured again down below if
                // there is any leftover space.
                if (isExactly) {
                    mTotalLength += lp.leftMargin + lp.rightMargin;
                } else {
                    final int totalLength = mTotalLength;
                    mTotalLength = Math.max(totalLength, totalLength +
                            lp.leftMargin + lp.rightMargin);
                }

                // Baseline alignment requires to measure widgets to obtain the
                // baseline offset (in particular for TextViews). The following
                // defeats the optimization mentioned above. Allow the child to
                // use as much space as it wants because we can shrink things
                // later (and re-measure).
                if (baselineAligned) {
                    final int freeSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                    child.measure(freeSpec, freeSpec);
                }
            } else {
                int oldWidth = Integer.MIN_VALUE;

                if (lp.width == 0 && lp.weight > 0) {
                    // widthMode is either UNSPECIFIED or AT_MOST, and this
                    // child
                    // wanted to stretch to fill available space. Translate that to
                    // WRAP_CONTENT so that it does not end up with a width of 0
                    oldWidth = 0;
                    lp.width = LayoutParams.WRAP_CONTENT;
                }

                // Determine how big this child would like to be. If this or
                // previous children have given a weight, then we allow it to
                // use all available space (and we will shrink things later
                // if needed).
                measureChildBeforeLayout(child, i, widthMeasureSpec,
                        totalWeight == 0 ? mTotalLength : 0,
                        heightMeasureSpec, 0);

                if (oldWidth != Integer.MIN_VALUE) {
                    lp.width = oldWidth;
                }

                final int childWidth = child.getMeasuredWidth();
                if (isExactly) {
                    mTotalLength += childWidth + lp.leftMargin + lp.rightMargin +
                            getNextLocationOffset(child);
                } else {
                    final int totalLength = mTotalLength;
                    mTotalLength = Math.max(totalLength, totalLength + childWidth + lp.leftMargin +
                           lp.rightMargin + getNextLocationOffset(child));
                }

                if (useLargestChild) {
                    largestChildWidth = Math.max(childWidth, largestChildWidth);
                }
            }

            boolean matchHeightLocally = false;
            if (heightMode != MeasureSpec.EXACTLY && lp.height == LayoutParams.MATCH_PARENT) {
                // The height of the linear layout will scale, and at least one
                // child said it wanted to match our height. Set a flag indicating that
                // we need to remeasure at least that view when we know our height.
                matchHeight = true;
                matchHeightLocally = true;
            }

            final int margin = lp.topMargin + lp.bottomMargin;
            final int childHeight = child.getMeasuredHeight() + margin;
            childState = combineMeasuredStates(childState, child.getMeasuredState());

            if (baselineAligned) {
                final int childBaseline = child.getBaseline();
                if (childBaseline != -1) {
                    // Translates the child's vertical gravity into an index
                    // in the range 0..VERTICAL_GRAVITY_COUNT
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
            if (lp.weight > 0) {
                /*
                 * Heights of weighted Views are bogus if we end up
                 * remeasuring, so keep them separate.
                 */
                weightedMaxHeight = Math.max(weightedMaxHeight,
                        matchHeightLocally ? margin : childHeight);
            } else {
                alternativeMaxHeight = Math.max(alternativeMaxHeight,
                        matchHeightLocally ? margin : childHeight);
            }

            i += getChildrenSkipCount(child, i);
        }

        if (mTotalLength > 0 && hasDividerBeforeChildAt(count)) {
            mTotalLength += mDividerWidth;
        }

        // Check mMaxAscent[INDEX_TOP] first because it maps to Gravity.TOP,
        // the most common case
        if (maxAscent[INDEX_TOP] != -1 ||
                maxAscent[INDEX_CENTER_VERTICAL] != -1 ||
                maxAscent[INDEX_BOTTOM] != -1 ||
                maxAscent[INDEX_FILL] != -1) {
            final int ascent = Math.max(maxAscent[INDEX_FILL],
                    Math.max(maxAscent[INDEX_CENTER_VERTICAL],
                    Math.max(maxAscent[INDEX_TOP], maxAscent[INDEX_BOTTOM])));
            final int descent = Math.max(maxDescent[INDEX_FILL],
                    Math.max(maxDescent[INDEX_CENTER_VERTICAL],
                    Math.max(maxDescent[INDEX_TOP], maxDescent[INDEX_BOTTOM])));
            maxHeight = Math.max(maxHeight, ascent + descent);
        }

        if (useLargestChild &&
                (widthMode == MeasureSpec.AT_MOST || widthMode == MeasureSpec.UNSPECIFIED)) {
            mTotalLength = 0;

            for (int i = 0; i < count; ++i) {
                final View child = getVirtualChildAt(i);

                if (child == null) {
                    mTotalLength += measureNullChild(i);
                    continue;
                }

                if (child.getVisibility() == GONE) {
                    i += getChildrenSkipCount(child, i);
                    continue;
                }

                final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)
                        child.getLayoutParams();
                if (isExactly) {
                    mTotalLength += largestChildWidth + lp.leftMargin + lp.rightMargin +
                            getNextLocationOffset(child);
                } else {
                    final int totalLength = mTotalLength;
                    mTotalLength = Math.max(totalLength, totalLength + largestChildWidth +
                            lp.leftMargin + lp.rightMargin + getNextLocationOffset(child));
                }
            }
        }

        // Add in our padding
        mTotalLength += mPaddingLeft + mPaddingRight;
        
        int widthSize = mTotalLength;
        
        // Check against our minimum width
        widthSize = Math.max(widthSize, getSuggestedMinimumWidth());
        
        // Reconcile our calculated size with the widthMeasureSpec
        int widthSizeAndState = resolveSizeAndState(widthSize, widthMeasureSpec, 0);
        widthSize = widthSizeAndState & MEASURED_SIZE_MASK;
        
        // Either expand children with weight to take up available space or
        // shrink them if they extend beyond our current bounds
        int delta = widthSize - mTotalLength;
        if (delta != 0 && totalWeight > 0.0f) {
            float weightSum = mWeightSum > 0.0f ? mWeightSum : totalWeight;

            maxAscent[0] = maxAscent[1] = maxAscent[2] = maxAscent[3] = -1;
            maxDescent[0] = maxDescent[1] = maxDescent[2] = maxDescent[3] = -1;
            maxHeight = -1;

            mTotalLength = 0;

            for (int i = 0; i < count; ++i) {
                final View child = getVirtualChildAt(i);

                if (child == null || child.getVisibility() == View.GONE) {
                    continue;
                }
                
                final LinearLayout.LayoutParams lp =
                        (LinearLayout.LayoutParams) child.getLayoutParams();

                float childExtra = lp.weight;
                if (childExtra > 0) {
                    // Child said it could absorb extra space -- give him his share
                    int share = (int) (childExtra * delta / weightSum);
                    weightSum -= childExtra;
                    delta -= share;

                    final int childHeightMeasureSpec = getChildMeasureSpec(
                            heightMeasureSpec,
                            mPaddingTop + mPaddingBottom + lp.topMargin + lp.bottomMargin,
                            lp.height);

                    // TODO: Use a field like lp.isMeasured to figure out if this
                    // child has been previously measured
                    if ((lp.width != 0) || (widthMode != MeasureSpec.EXACTLY)) {
                        // child was measured once already above ... base new measurement
                        // on stored values
                        int childWidth = child.getMeasuredWidth() + share;
                        if (childWidth < 0) {
                            childWidth = 0;
                        }

                        child.measure(
                            MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY),
                            childHeightMeasureSpec);
                    } else {
                        // child was skipped in the loop above. Measure for this first time here
                        child.measure(MeasureSpec.makeMeasureSpec(
                                share > 0 ? share : 0, MeasureSpec.EXACTLY),
                                childHeightMeasureSpec);
                    }

                    // Child may now not fit in horizontal dimension.
                    childState = combineMeasuredStates(childState,
                            child.getMeasuredState() & MEASURED_STATE_MASK);
                }

                if (isExactly) {
                    mTotalLength += child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin +
                            getNextLocationOffset(child);
                } else {
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

                if (baselineAligned) {
                    final int childBaseline = child.getBaseline();
                    if (childBaseline != -1) {
                        // Translates the child's vertical gravity into an index in the range 0..2
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

            // Add in our padding
            mTotalLength += mPaddingLeft + mPaddingRight;
            // TODO: Should we update widthSize with the new total length?

            // Check mMaxAscent[INDEX_TOP] first because it maps to Gravity.TOP,
            // the most common case
            if (maxAscent[INDEX_TOP] != -1 ||
                    maxAscent[INDEX_CENTER_VERTICAL] != -1 ||
                    maxAscent[INDEX_BOTTOM] != -1 ||
                    maxAscent[INDEX_FILL] != -1) {
                final int ascent = Math.max(maxAscent[INDEX_FILL],
                        Math.max(maxAscent[INDEX_CENTER_VERTICAL],
                        Math.max(maxAscent[INDEX_TOP], maxAscent[INDEX_BOTTOM])));
                final int descent = Math.max(maxDescent[INDEX_FILL],
                        Math.max(maxDescent[INDEX_CENTER_VERTICAL],
                        Math.max(maxDescent[INDEX_TOP], maxDescent[INDEX_BOTTOM])));
                maxHeight = Math.max(maxHeight, ascent + descent);
            }
        } else {
            alternativeMaxHeight = Math.max(alternativeMaxHeight, weightedMaxHeight);

            // We have no limit, so make all weighted views as wide as the largest child.
            // Children will have already been measured once.
            if (useLargestChild && widthMode == MeasureSpec.UNSPECIFIED) {
                for (int i = 0; i < count; i++) {
                    final View child = getVirtualChildAt(i);

                    if (child == null || child.getVisibility() == View.GONE) {
                        continue;
                    }

                    final LinearLayout.LayoutParams lp =
                            (LinearLayout.LayoutParams) child.getLayoutParams();

                    float childExtra = lp.weight;
                    if (childExtra > 0) {
                        child.measure(
                                MeasureSpec.makeMeasureSpec(largestChildWidth, MeasureSpec.EXACTLY),
                                MeasureSpec.makeMeasureSpec(child.getMeasuredHeight(),
                                        MeasureSpec.EXACTLY));
                    }
                }
            }
        }

        if (!allFillParent && heightMode != MeasureSpec.EXACTLY) {
            maxHeight = alternativeMaxHeight;
        }
        
        maxHeight += mPaddingTop + mPaddingBottom;

        // Check against our minimum height
        maxHeight = Math.max(maxHeight, getSuggestedMinimumHeight());
        
        setMeasuredDimension(widthSizeAndState | (childState&MEASURED_STATE_MASK),
                resolveSizeAndState(maxHeight, heightMeasureSpec,
                        (childState<<MEASURED_HEIGHT_STATE_SHIFT)));

        if (matchHeight) {
            forceUniformHeight(count, widthMeasureSpec);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.953 -0500", hash_original_method = "FDF33FE6741A819E3461023969653A29", hash_generated_method = "A12A097BE241F8C39CE91EE660B9CECD")
    
private void forceUniformHeight(int count, int widthMeasureSpec) {
        // Pretend that the linear layout has an exact size. This is the measured height of
        // ourselves. The measured height should be the max height of the children, changed
        // to accomodate the heightMesureSpec from the parent
        int uniformMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(),
                MeasureSpec.EXACTLY);
        for (int i = 0; i < count; ++i) {
           final View child = getVirtualChildAt(i);
           if (child.getVisibility() != GONE) { 
               LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
               
               if (lp.height == LayoutParams.MATCH_PARENT) {
                   // Temporarily force children to reuse their old measured width
                   // FIXME: this may not be right for something like wrapping text?
                   int oldWidth = lp.width;
                   lp.width = child.getMeasuredWidth();
                   
                   // Remeasure with new dimensions
                   measureChildWithMargins(child, widthMeasureSpec, 0, uniformMeasureSpec, 0);
                   lp.width = oldWidth;
               }
           }
        }
    }

    /**
     * <p>Returns the number of children to skip after measuring/laying out
     * the specified child.</p>
     *
     * @param child the child after which we want to skip children
     * @param index the index of the child after which we want to skip children
     * @return the number of children to skip, 0 by default
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.956 -0500", hash_original_method = "64CDF538399E47C38C21DACEFC8C1E08", hash_generated_method = "64CDF538399E47C38C21DACEFC8C1E08")
    
int getChildrenSkipCount(View child, int index) {
        return 0;
    }

    /**
     * <p>Returns the size (width or height) that should be occupied by a null
     * child.</p>
     *
     * @param childIndex the index of the null child
     * @return the width or height of the child depending on the orientation
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.958 -0500", hash_original_method = "0C791DFCDA5E7DFE7963EF393BDBDA11", hash_generated_method = "0C791DFCDA5E7DFE7963EF393BDBDA11")
    
int measureNullChild(int childIndex) {
        return 0;
    }

    /**
     * <p>Measure the child according to the parent's measure specs. This
     * method should be overriden by subclasses to force the sizing of
     * children. This method is called by {@link #measureVertical(int, int)} and
     * {@link #measureHorizontal(int, int)}.</p>
     *
     * @param child the child to measure
     * @param childIndex the index of the child in this view
     * @param widthMeasureSpec horizontal space requirements as imposed by the parent
     * @param totalWidth extra space that has been used up by the parent horizontally
     * @param heightMeasureSpec vertical space requirements as imposed by the parent
     * @param totalHeight extra space that has been used up by the parent vertically
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.960 -0500", hash_original_method = "784157887C32A4B8D345E93BB13DEECA", hash_generated_method = "784157887C32A4B8D345E93BB13DEECA")
    
void measureChildBeforeLayout(View child, int childIndex,
            int widthMeasureSpec, int totalWidth, int heightMeasureSpec,
            int totalHeight) {
        measureChildWithMargins(child, widthMeasureSpec, totalWidth,
                heightMeasureSpec, totalHeight);
    }

    /**
     * <p>Return the location offset of the specified child. This can be used
     * by subclasses to change the location of a given widget.</p>
     *
     * @param child the child for which to obtain the location offset
     * @return the location offset in pixels
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.962 -0500", hash_original_method = "BA69BAE2E1D7A163D53D02D47016A6D7", hash_generated_method = "BA69BAE2E1D7A163D53D02D47016A6D7")
    
int getLocationOffset(View child) {
        return 0;
    }

    /**
     * <p>Return the size offset of the next sibling of the specified child.
     * This can be used by subclasses to change the location of the widget
     * following <code>child</code>.</p>
     *
     * @param child the child whose next sibling will be moved
     * @return the location offset of the next child in pixels
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.964 -0500", hash_original_method = "6D7A4F846C7E828D32B84605EE3B545F", hash_generated_method = "6D7A4F846C7E828D32B84605EE3B545F")
    
int getNextLocationOffset(View child) {
        return 0;
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.966 -0500", hash_original_method = "38617BD257A07AF46AAF702E88FA7138", hash_generated_method = "B8F8072E136786133A79701CF061DDA1")
    
@Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (mOrientation == VERTICAL) {
            layoutVertical();
        } else {
            layoutHorizontal();
        }
    }

    /**
     * Position the children during a layout pass if the orientation of this
     * LinearLayout is set to {@link #VERTICAL}.
     *
     * @see #getOrientation()
     * @see #setOrientation(int)
     * @see #onLayout(boolean, int, int, int, int)
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.970 -0500", hash_original_method = "30B5FEA9EA0D751AC72456573A204452", hash_generated_method = "1F3D722B7D1EF4D467D3DF1D276D23EA")
    
void layoutVertical() {
        final int paddingLeft = mPaddingLeft;

        int childTop;
        int childLeft;
        
        // Where right end of child should go
        final int width = mRight - mLeft;
        int childRight = width - mPaddingRight;
        
        // Space available for child
        int childSpace = width - paddingLeft - mPaddingRight;
        
        final int count = getVirtualChildCount();

        final int majorGravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        final int minorGravity = mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;

        switch (majorGravity) {
           case Gravity.BOTTOM:
               // mTotalLength contains the padding already
               childTop = mPaddingTop + mBottom - mTop - mTotalLength;
               break;

               // mTotalLength contains the padding already
           case Gravity.CENTER_VERTICAL:
               childTop = mPaddingTop + (mBottom - mTop - mTotalLength) / 2;
               break;

           case Gravity.TOP:
           default:
               childTop = mPaddingTop;
               break;
        }

        for (int i = 0; i < count; i++) {
            final View child = getVirtualChildAt(i);
            if (child == null) {
                childTop += measureNullChild(i);
            } else if (child.getVisibility() != GONE) {
                final int childWidth = child.getMeasuredWidth();
                final int childHeight = child.getMeasuredHeight();
                
                final LinearLayout.LayoutParams lp =
                        (LinearLayout.LayoutParams) child.getLayoutParams();
                
                int gravity = lp.gravity;
                if (gravity < 0) {
                    gravity = minorGravity;
                }
                final int layoutDirection = getResolvedLayoutDirection();
                final int absoluteGravity = Gravity.getAbsoluteGravity(gravity, layoutDirection);
                switch (absoluteGravity & Gravity.HORIZONTAL_GRAVITY_MASK) {
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
                }

                if (hasDividerBeforeChildAt(i)) {
                    childTop += mDividerHeight;
                }

                childTop += lp.topMargin;
                setChildFrame(child, childLeft, childTop + getLocationOffset(child),
                        childWidth, childHeight);
                childTop += childHeight + lp.bottomMargin + getNextLocationOffset(child);

                i += getChildrenSkipCount(child, i);
            }
        }
    }
    
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.001 -0500", hash_original_field = "ED32AE0265E055EF357B36A061633A65", hash_generated_field = "B59DE7C019472A73872C811A2811FA3D")

        @ViewDebug.ExportedProperty(category = "layout")
        public float weight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.004 -0500", hash_original_field = "017EB0E7305475871AC6C45F0E01F5D9", hash_generated_field = "938DDF19CF8B381A3F6119E45B2090E8")

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

        /**
         * {@inheritDoc}
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.007 -0500", hash_original_method = "C424BD779148A2828DEB0ABC94DCC73C", hash_generated_method = "1949DD99FD290058A73A861303B9D7FF")
        
public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a =
                    c.obtainStyledAttributes(attrs, com.android.internal.R.styleable.LinearLayout_Layout);

            weight = a.getFloat(com.android.internal.R.styleable.LinearLayout_Layout_layout_weight, 0);
            gravity = a.getInt(com.android.internal.R.styleable.LinearLayout_Layout_layout_gravity, -1);

            a.recycle();
        }

        /**
         * {@inheritDoc}
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.009 -0500", hash_original_method = "5675045EFCD4661F32116909A9822399", hash_generated_method = "D00C43B28A1B544AF669D1382210BD5F")
        
public LayoutParams(int width, int height) {
            super(width, height);
            weight = 0;
        }

        /**
         * Creates a new set of layout parameters with the specified width, height
         * and weight.
         *
         * @param width the width, either {@link #MATCH_PARENT},
         *        {@link #WRAP_CONTENT} or a fixed size in pixels
         * @param height the height, either {@link #MATCH_PARENT},
         *        {@link #WRAP_CONTENT} or a fixed size in pixels
         * @param weight the weight
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.012 -0500", hash_original_method = "4CDC4D1E7FEEFBC37A8F4BABF983F00D", hash_generated_method = "9F21D0821BE5D3698BA91397A51EBA72")
        
public LayoutParams(int width, int height, float weight) {
            super(width, height);
            this.weight = weight;
        }

        /**
         * {@inheritDoc}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.015 -0500", hash_original_method = "DE4ED36682A1028E303BDCC28A48E06F", hash_generated_method = "AA7E78F64C1B2029CADFD7AA230FA359")
        
public LayoutParams(ViewGroup.LayoutParams p) {
            super(p);
        }

        /**
         * {@inheritDoc}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.018 -0500", hash_original_method = "CC87BD4B8C067788FA2BA37DBA116F62", hash_generated_method = "A83E3EC70AE7CFFC0495D4E169E975D9")
        
public LayoutParams(MarginLayoutParams source) {
            super(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.020 -0500", hash_original_method = "09BB09F623D63D4B2B1AF033D2D5C9B4", hash_generated_method = "A3C6464049EE93DF99176B19037C8817")
        
@Override
        public String debug(String output) {
            return output + "LinearLayout.LayoutParams={width=" + sizeToString(width) +
                    ", height=" + sizeToString(height) + " weight=" + weight +  "}";
        }
        
    }

    /**
     * Position the children during a layout pass if the orientation of this
     * LinearLayout is set to {@link #HORIZONTAL}.
     *
     * @see #getOrientation()
     * @see #setOrientation(int)
     * @see #onLayout(boolean, int, int, int, int)
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.974 -0500", hash_original_method = "7E4C2E885F4FB677FEB4B548A065DB2A", hash_generated_method = "6B4697484237C8DCDADE873702A27F63")
    
void layoutHorizontal() {
        final boolean isLayoutRtl = isLayoutRtl();
        final int paddingTop = mPaddingTop;

        int childTop;
        int childLeft;
        
        // Where bottom of child should go
        final int height = mBottom - mTop;
        int childBottom = height - mPaddingBottom;
        
        // Space available for child
        int childSpace = height - paddingTop - mPaddingBottom;

        final int count = getVirtualChildCount();

        final int majorGravity = mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        final int minorGravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;

        final boolean baselineAligned = mBaselineAligned;

        final int[] maxAscent = mMaxAscent;
        final int[] maxDescent = mMaxDescent;

        final int layoutDirection = getResolvedLayoutDirection();
        switch (Gravity.getAbsoluteGravity(majorGravity, layoutDirection)) {
            case Gravity.RIGHT:
                // mTotalLength contains the padding already
                childLeft = mPaddingLeft + mRight - mLeft - mTotalLength;
                break;

            case Gravity.CENTER_HORIZONTAL:
                // mTotalLength contains the padding already
                childLeft = mPaddingLeft + (mRight - mLeft - mTotalLength) / 2;
                break;

            case Gravity.LEFT:
            default:
                childLeft = mPaddingLeft;
                break;
        }

        int start = 0;
        int dir = 1;
        //In case of RTL, start drawing from the last child.
        if (isLayoutRtl) {
            start = count - 1;
            dir = -1;
        }

        for (int i = 0; i < count; i++) {
            int childIndex = start + dir * i;
            final View child = getVirtualChildAt(childIndex);

            if (child == null) {
                childLeft += measureNullChild(childIndex);
            } else if (child.getVisibility() != GONE) {
                final int childWidth = child.getMeasuredWidth();
                final int childHeight = child.getMeasuredHeight();
                int childBaseline = -1;

                final LinearLayout.LayoutParams lp =
                        (LinearLayout.LayoutParams) child.getLayoutParams();

                if (baselineAligned && lp.height != LayoutParams.MATCH_PARENT) {
                    childBaseline = child.getBaseline();
                }
                
                int gravity = lp.gravity;
                if (gravity < 0) {
                    gravity = minorGravity;
                }
                
                switch (gravity & Gravity.VERTICAL_GRAVITY_MASK) {
                    case Gravity.TOP:
                        childTop = paddingTop + lp.topMargin;
                        if (childBaseline != -1) {
                            childTop += maxAscent[INDEX_TOP] - childBaseline;
                        }
                        break;

                    case Gravity.CENTER_VERTICAL:
                        // Removed support for baseline alignment when layout_gravity or
                        // gravity == center_vertical. See bug #1038483.
                        // Keep the code around if we need to re-enable this feature
                        // if (childBaseline != -1) {
                        //     // Align baselines vertically only if the child is smaller than us
                        //     if (childSpace - childHeight > 0) {
                        //         childTop = paddingTop + (childSpace / 2) - childBaseline;
                        //     } else {
                        //         childTop = paddingTop + (childSpace - childHeight) / 2;
                        //     }
                        // } else {
                        childTop = paddingTop + ((childSpace - childHeight) / 2)
                                + lp.topMargin - lp.bottomMargin;
                        break;

                    case Gravity.BOTTOM:
                        childTop = childBottom - childHeight - lp.bottomMargin;
                        if (childBaseline != -1) {
                            int descent = child.getMeasuredHeight() - childBaseline;
                            childTop -= (maxDescent[INDEX_BOTTOM] - descent);
                        }
                        break;
                    default:
                        childTop = paddingTop;
                        break;
                }

                if (hasDividerBeforeChildAt(childIndex)) {
                    childLeft += mDividerWidth;
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.977 -0500", hash_original_method = "74793CDC2820B7770CC6C7B645CE6A0C", hash_generated_method = "89E0F6704B6BEAB247D2061B420B0C52")
    
private void setChildFrame(View child, int left, int top, int width, int height) {        
        child.layout(left, top, left + width, top + height);
    }
    
    /**
     * Should the layout be a column or a row.
     * @param orientation Pass HORIZONTAL or VERTICAL. Default
     * value is HORIZONTAL.
     * 
     * @attr ref android.R.styleable#LinearLayout_orientation
     */
    @DSComment("Layout")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.979 -0500", hash_original_method = "708E6C59CCF6822D1254CF8F346C250A", hash_generated_method = "BFA3958A7C0BC790D178EF86B7EDBF59")
    
public void setOrientation(int orientation) {
        if (mOrientation != orientation) {
            mOrientation = orientation;
            requestLayout();
        }
    }

    /**
     * Returns the current orientation.
     * 
     * @return either {@link #HORIZONTAL} or {@link #VERTICAL}
     */
    @DSComment("Layout")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.981 -0500", hash_original_method = "6BA82D6B625174A8AC80664141F0D361", hash_generated_method = "BD403A9700920A99F22D5BAAE290999D")
    
public int getOrientation() {
        return mOrientation;
    }

    /**
     * Describes how the child views are positioned. Defaults to GRAVITY_TOP. If
     * this layout has a VERTICAL orientation, this controls where all the child
     * views are placed if there is extra vertical space. If this layout has a
     * HORIZONTAL orientation, this controls the alignment of the children.
     * 
     * @param gravity See {@link android.view.Gravity}
     * 
     * @attr ref android.R.styleable#LinearLayout_gravity
     */
    @DSComment("Layout")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.984 -0500", hash_original_method = "DC8D5E1211DE0926B9DDA2FADCED75EE", hash_generated_method = "ACC460D6D3A88CDE5F61A25B30D37A34")
    
@android.view.RemotableViewMethod
    public void setGravity(int gravity) {
        if (mGravity != gravity) {
            if ((gravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 0) {
                gravity |= Gravity.START;
            }

            if ((gravity & Gravity.VERTICAL_GRAVITY_MASK) == 0) {
                gravity |= Gravity.TOP;
            }

            mGravity = gravity;
            requestLayout();
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.986 -0500", hash_original_method = "076C59065FCBD07F7CAA4FFA6D12CC3A", hash_generated_method = "DD9C3C2378492508B428C0D28CCABAA5")
    
@android.view.RemotableViewMethod
    public void setHorizontalGravity(int horizontalGravity) {
        final int gravity = horizontalGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if ((mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) != gravity) {
            mGravity = (mGravity & ~Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) | gravity;
            requestLayout();
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.988 -0500", hash_original_method = "EE245B70888F9F1582A126D948173E64", hash_generated_method = "0591F7E10EF7E02B9451B299C8FAC684")
    
@android.view.RemotableViewMethod
    public void setVerticalGravity(int verticalGravity) {
        final int gravity = verticalGravity & Gravity.VERTICAL_GRAVITY_MASK;
        if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != gravity) {
            mGravity = (mGravity & ~Gravity.VERTICAL_GRAVITY_MASK) | gravity;
            requestLayout();
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.991 -0500", hash_original_method = "5E749CCE267F5C755BAC22F4F9345284", hash_generated_method = "CA9C1AF7081DA793BD4CF0AC667E6C23")
    
@Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LinearLayout.LayoutParams(getContext(), attrs);
    }

    /**
     * Returns a set of layout parameters with a width of
     * {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT}
     * and a height of {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT}
     * when the layout's orientation is {@link #VERTICAL}. When the orientation is
     * {@link #HORIZONTAL}, the width is set to {@link LayoutParams#WRAP_CONTENT}
     * and the height to {@link LayoutParams#WRAP_CONTENT}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.993 -0500", hash_original_method = "3D6E4608F39560A7785B268309288C51", hash_generated_method = "7A67EAB2FE0D2916307AA18036B8065F")
    
@Override
    protected LayoutParams generateDefaultLayoutParams() {
        if (mOrientation == HORIZONTAL) {
            return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        } else if (mOrientation == VERTICAL) {
            return new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.995 -0500", hash_original_method = "E5FE95308BC48D9899CFDE5A4F7DEDB6", hash_generated_method = "5EC68A52A80404D335FAABCCA3BC514C")
    
@Override
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    // Override to allow type-checking of LayoutParams.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:04.997 -0500", hash_original_method = "1F2E8350C10FBDB8051DCF8E5479411B", hash_generated_method = "28AB7436F710E069C2BB270F65908AD1")
    
@Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LinearLayout.LayoutParams;
    }
}

