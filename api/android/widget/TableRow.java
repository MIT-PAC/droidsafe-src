package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;

public class TableRow extends LinearLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.190 -0500", hash_original_field = "4F99705C597554B60A40432D34971E06", hash_generated_field = "D9A8A35CE61AAB048FD0AED37F8CBEEB")

    private int mNumColumns = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.193 -0500", hash_original_field = "5DF09AA3E53C9CA6F225441DDB488EF7", hash_generated_field = "15FCA76D9E6B49D35CF288E17BA4DB1D")

    private int[] mColumnWidths;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.195 -0500", hash_original_field = "326777921CAB21710CE823E9883DD714", hash_generated_field = "3C7C52F68E94A8B9B94FB48FC8D2BFE4")

    private int[] mConstrainedColumnWidths;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.197 -0500", hash_original_field = "F1D372186FF8D3830D55E04625A5809B", hash_generated_field = "7C85DDE3B4F4B337F894C4208AF1B531")

    private SparseIntArray mColumnToChildIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.199 -0500", hash_original_field = "EE323A239439596821454B5BF2429A31", hash_generated_field = "3A88AE8C6C11D29E8EFD9BC29F67E7FE")

    private ChildrenTracker mChildrenTracker;

    /**
     * <p>Creates a new TableRow for the given context.</p>
     *
     * @param context the application environment
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.201 -0500", hash_original_method = "F9A2694D9D8F1C73F4893642416A48B8", hash_generated_method = "F30432BF67CDBC71F94AD1152C117E44")
    
public TableRow(Context context) {
        super(context);
        initTableRow();
    }

    /**
     * <p>Creates a new TableRow for the given context and with the
     * specified set attributes.</p>
     *
     * @param context the application environment
     * @param attrs a collection of attributes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.203 -0500", hash_original_method = "BE346953D196911D47A80804A6B74A8F", hash_generated_method = "FA1FF0D936D9A45B6AB85F09FD7B00BB")
    
public TableRow(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTableRow();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.206 -0500", hash_original_method = "B661864F11557636EAA2570C7969C441", hash_generated_method = "797FC0E33A372CF1377E97B4E3DC0B21")
    
private void initTableRow() {
        OnHierarchyChangeListener oldListener = mOnHierarchyChangeListener;
        mChildrenTracker = new ChildrenTracker();
        if (oldListener != null) {
            mChildrenTracker.setOnHierarchyChangeListener(oldListener);
        }
        super.setOnHierarchyChangeListener(mChildrenTracker);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.208 -0500", hash_original_method = "F95EB07610207091F5D59E2132ED055F", hash_generated_method = "04FEFC8991D896A69F15ADD8BBA43B10")
    
@Override
    public void setOnHierarchyChangeListener(OnHierarchyChangeListener listener) {
        mChildrenTracker.setOnHierarchyChangeListener(listener);
    }

    /**
     * <p>Collapses or restores a given column.</p>
     *
     * @param columnIndex the index of the column
     * @param collapsed true if the column must be collapsed, false otherwise
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.210 -0500", hash_original_method = "2321E3900029B8CC8621E7719358502D", hash_generated_method = "2321E3900029B8CC8621E7719358502D")
    
void setColumnCollapsed(int columnIndex, boolean collapsed) {
        View child = getVirtualChildAt(columnIndex);
        if (child != null) {
            child.setVisibility(collapsed ? GONE : VISIBLE);
        }
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.212 -0500", hash_original_method = "F6BA9F18146785AE4528780F68777354", hash_generated_method = "563FF59DC2E31838CA4A3E5363A34682")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // enforce horizontal layout
        measureHorizontal(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.215 -0500", hash_original_method = "614377E7AFFD7D8A3CEA03D0F029C6C2", hash_generated_method = "A5E7151DE02B6130565E64A424814DB7")
    
@Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        // enforce horizontal layout
        layoutHorizontal();
    }

    /**
     * {@inheritDoc}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.218 -0500", hash_original_method = "76BF09C7D97AC336E0857E346F87F26E", hash_generated_method = "7D1CB5FC6CF166D1F0E729DAB78863A0")
    
@Override
    public View getVirtualChildAt(int i) {
        if (mColumnToChildIndex == null) {
            mapIndexAndColumns();
        }

        final int deflectedIndex = mColumnToChildIndex.get(i, -1);
        if (deflectedIndex != -1) {
            return getChildAt(deflectedIndex);
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.220 -0500", hash_original_method = "C68DDC21BA155D9A2863642050B804BE", hash_generated_method = "7F15477204B9A6B1B666EC6C6EEC217D")
    
@Override
    public int getVirtualChildCount() {
        if (mColumnToChildIndex == null) {
            mapIndexAndColumns();
        }
        return mNumColumns;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.222 -0500", hash_original_method = "4E55577CF2059CB35F704B8E869B19CD", hash_generated_method = "099ED2A0A01D09D14DE8E79510974180")
    
private void mapIndexAndColumns() {
        if (mColumnToChildIndex == null) {
            int virtualCount = 0;
            final int count = getChildCount();

            mColumnToChildIndex = new SparseIntArray();
            final SparseIntArray columnToChild = mColumnToChildIndex;

            for (int i = 0; i < count; i++) {
                final View child = getChildAt(i);
                final LayoutParams layoutParams = (LayoutParams) child.getLayoutParams();

                if (layoutParams.column >= virtualCount) {
                    virtualCount = layoutParams.column;
                }

                for (int j = 0; j < layoutParams.span; j++) {
                    columnToChild.put(virtualCount++, i);
                }
            }

            mNumColumns = virtualCount;
        }
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.224 -0500", hash_original_method = "6310895A2EAB860DC48C590959484D6D", hash_generated_method = "A3B478942050DC079EF36DF3B5AB228A")
    
@Override
    int measureNullChild(int childIndex) {
        return mConstrainedColumnWidths[childIndex];
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.227 -0500", hash_original_method = "21A01BD04BAB3B03D9551E5E2A120920", hash_generated_method = "9C564505E44A15D18CAE93EE636D1B4B")
    
@Override
    void measureChildBeforeLayout(View child, int childIndex,
            int widthMeasureSpec, int totalWidth,
            int heightMeasureSpec, int totalHeight) {
        if (mConstrainedColumnWidths != null) {
            final LayoutParams lp = (LayoutParams) child.getLayoutParams();

            int measureMode = MeasureSpec.EXACTLY;
            int columnWidth = 0;

            final int span = lp.span;
            final int[] constrainedColumnWidths = mConstrainedColumnWidths;
            for (int i = 0; i < span; i++) {
                columnWidth += constrainedColumnWidths[childIndex + i];
            }

            final int gravity = lp.gravity;
            final boolean isHorizontalGravity = Gravity.isHorizontal(gravity);

            if (isHorizontalGravity) {
                measureMode = MeasureSpec.AT_MOST;
            }

            // no need to care about padding here,
            // ViewGroup.getChildMeasureSpec() would get rid of it anyway
            // because of the EXACTLY measure spec we use
            int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(
                    Math.max(0, columnWidth - lp.leftMargin - lp.rightMargin), measureMode
            );
            int childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec,
                    mPaddingTop + mPaddingBottom + lp.topMargin +
                    lp .bottomMargin + totalHeight, lp.height);

            child.measure(childWidthMeasureSpec, childHeightMeasureSpec);

            if (isHorizontalGravity) {
                final int childWidth = child.getMeasuredWidth();
                lp.mOffset[LayoutParams.LOCATION_NEXT] = columnWidth - childWidth;

                final int layoutDirection = getResolvedLayoutDirection();
                final int absoluteGravity = Gravity.getAbsoluteGravity(gravity, layoutDirection);
                switch (absoluteGravity & Gravity.HORIZONTAL_GRAVITY_MASK) {
                    case Gravity.LEFT:
                        // don't offset on X axis
                        break;
                    case Gravity.RIGHT:
                        lp.mOffset[LayoutParams.LOCATION] = lp.mOffset[LayoutParams.LOCATION_NEXT];
                        break;
                    case Gravity.CENTER_HORIZONTAL:
                        lp.mOffset[LayoutParams.LOCATION] = lp.mOffset[LayoutParams.LOCATION_NEXT] / 2;
                        break;
                }
            } else {
                lp.mOffset[LayoutParams.LOCATION] = lp.mOffset[LayoutParams.LOCATION_NEXT] = 0;
            }
        } else {
            // fail silently when column widths are not available
            super.measureChildBeforeLayout(child, childIndex, widthMeasureSpec,
                    totalWidth, heightMeasureSpec, totalHeight);
        }
    }

    /**
     * {@inheritDoc}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.229 -0500", hash_original_method = "B06729C46F9CA4132172A65B967C7D51", hash_generated_method = "8B4B16F1A36E00DE95FD8BF455304A45")
    
@Override
    int getChildrenSkipCount(View child, int index) {
        LayoutParams layoutParams = (LayoutParams) child.getLayoutParams();

        // when the span is 1 (default), we need to skip 0 child
        return layoutParams.span - 1;
    }

    /**
     * {@inheritDoc}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.232 -0500", hash_original_method = "B1A714BE7A14CFDA42294606652D195E", hash_generated_method = "4E3221E81CD33F380ABC3106BBCBA2B1")
    
@Override
    int getLocationOffset(View child) {
        return ((TableRow.LayoutParams) child.getLayoutParams()).mOffset[LayoutParams.LOCATION];
    }

    /**
     * {@inheritDoc}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.234 -0500", hash_original_method = "6629CED69C690D63986C2D59A68F69D3", hash_generated_method = "43E0A45AA2476578E7C6D610F769282D")
    
@Override
    int getNextLocationOffset(View child) {
        return ((TableRow.LayoutParams) child.getLayoutParams()).mOffset[LayoutParams.LOCATION_NEXT];
    }

    /**
     * <p>Measures the preferred width of each child, including its margins.</p>
     *
     * @param widthMeasureSpec the width constraint imposed by our parent
     *
     * @return an array of integers corresponding to the width of each cell, or
     *         column, in this row
     * {@hide}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.237 -0500", hash_original_method = "F97D9B3BAD7BE3BFEC03988909D08EE2", hash_generated_method = "F97D9B3BAD7BE3BFEC03988909D08EE2")
    
int[] getColumnsWidths(int widthMeasureSpec) {
        final int numColumns = getVirtualChildCount();
        if (mColumnWidths == null || numColumns != mColumnWidths.length) {
            mColumnWidths = new int[numColumns];
        }

        final int[] columnWidths = mColumnWidths;

        for (int i = 0; i < numColumns; i++) {
            final View child = getVirtualChildAt(i);
            if (child != null && child.getVisibility() != GONE) {
                final LayoutParams layoutParams = (LayoutParams) child.getLayoutParams();
                if (layoutParams.span == 1) {
                    int spec;
                    switch (layoutParams.width) {
                        case LayoutParams.WRAP_CONTENT:
                            spec = getChildMeasureSpec(widthMeasureSpec, 0, LayoutParams.WRAP_CONTENT);
                            break;
                        case LayoutParams.MATCH_PARENT:
                            spec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                            break;
                        default:
                            spec = MeasureSpec.makeMeasureSpec(layoutParams.width, MeasureSpec.EXACTLY);
                    }
                    child.measure(spec, spec);

                    final int width = child.getMeasuredWidth() + layoutParams.leftMargin +
                            layoutParams.rightMargin;
                    columnWidths[i] = width;
                } else {
                    columnWidths[i] = 0;
                }
            } else {
                columnWidths[i] = 0;
            }
        }

        return columnWidths;
    }

    /**
     * <p>Sets the width of all of the columns in this row. At layout time,
     * this row sets a fixed width, as defined by <code>columnWidths</code>,
     * on each child (or cell, or column.)</p>
     *
     * @param columnWidths the fixed width of each column that this row must
     *                     honor
     * @throws IllegalArgumentException when columnWidths' length is smaller
     *         than the number of children in this row
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.239 -0500", hash_original_method = "00077407B55623ED0FDC934F0F688424", hash_generated_method = "00077407B55623ED0FDC934F0F688424")
    
void setColumnsWidthConstraints(int[] columnWidths) {
        if (columnWidths == null || columnWidths.length < getVirtualChildCount()) {
            throw new IllegalArgumentException(
                    "columnWidths should be >= getVirtualChildCount()");
        }

        mConstrainedColumnWidths = columnWidths;
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.241 -0500", hash_original_method = "52AE7360396A37641601CBCD86366395", hash_generated_method = "13D6CEC23C22359692D9B0652FBEE48C")
    
@Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new TableRow.LayoutParams(getContext(), attrs);
    }

    /**
     * Returns a set of layout parameters with a width of
     * {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT},
     * a height of {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT} and no spanning.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.244 -0500", hash_original_method = "CBDF0BDAD2221E25AE8470C9AB157031", hash_generated_method = "08C9D8D0662D9DEB6BF1823243284E1B")
    
@Override
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.246 -0500", hash_original_method = "22EE87D9951BB7D40E63D16DD0B3F806", hash_generated_method = "7E865CB2110627BE082744153CC84E9A")
    
@Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof TableRow.LayoutParams;
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.248 -0500", hash_original_method = "BBEB2ACD1EFF73877451077ABC9022BA", hash_generated_method = "0ED876FED2AB61E7BC5645ABFCC8A3F3")
    
@Override
    protected LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }
    
    public static class LayoutParams extends LinearLayout.LayoutParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.257 -0500", hash_original_field = "8BA20F97D7D5048A0CED725277D7DEE1", hash_generated_field = "E13ED3209622FEE16C7BB9C191FE8F66")

        private static final int LOCATION = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.259 -0500", hash_original_field = "79DB5C8358138861828FD4EC33AFEA6B", hash_generated_field = "934A445C55E10BBDBE903F1BA35DFAF1")

        private static final int LOCATION_NEXT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.251 -0500", hash_original_field = "90576625319AB666908247B08CE7D656", hash_generated_field = "880EADDB8CAD6645D1A649B4C5BDBB5F")

        @ViewDebug.ExportedProperty(category = "layout")
        public int column;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.254 -0500", hash_original_field = "328E1B908058359BD35319AC619A59EB", hash_generated_field = "1D587A55F3FA8CB1DFEEF6D53CE06BC2")

        @ViewDebug.ExportedProperty(category = "layout")
        public int span;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.262 -0500", hash_original_field = "3C2DEFF19A8D7D46FCA4C9F95995BF89", hash_generated_field = "3B010DF7096DEB2A022337BFA1B1C1A7")

        private int[] mOffset = new int[2];

        /**
         * {@inheritDoc}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.264 -0500", hash_original_method = "E5D3961F929E7A203A8A944132C09ABE", hash_generated_method = "3978C3C8A5F35904A685CD6D41E9089A")
        
public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);

            TypedArray a =
                    c.obtainStyledAttributes(attrs,
                            com.android.internal.R.styleable.TableRow_Cell);

            column = a.getInt(com.android.internal.R.styleable.TableRow_Cell_layout_column, -1);
            span = a.getInt(com.android.internal.R.styleable.TableRow_Cell_layout_span, 1);
            if (span <= 1) {
                span = 1;
            }

            a.recycle();
        }

        /**
         * <p>Sets the child width and the child height.</p>
         *
         * @param w the desired width
         * @param h the desired height
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.267 -0500", hash_original_method = "DCEE7ED44A87D406D3E35C60D8DCDFD7", hash_generated_method = "60BA64B4428E8556A9DF1AB1BE34DB7D")
        
public LayoutParams(int w, int h) {
            super(w, h);
            column = -1;
            span = 1;
        }

        /**
         * <p>Sets the child width, height and weight.</p>
         *
         * @param w the desired width
         * @param h the desired height
         * @param initWeight the desired weight
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.269 -0500", hash_original_method = "AC2D690BD2E1EA15E67B11BD37629B19", hash_generated_method = "BDCFB1C39D92852469B62C81C5EE92DE")
        
public LayoutParams(int w, int h, float initWeight) {
            super(w, h, initWeight);
            column = -1;
            span = 1;
        }

        /**
         * <p>Sets the child width to {@link android.view.ViewGroup.LayoutParams}
         * and the child height to
         * {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT}.</p>
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.272 -0500", hash_original_method = "5AA50E380D57ACDFC498CDB1B1E9AFBA", hash_generated_method = "0D38F5223E84FC2801E6AE6BD2189054")
        
public LayoutParams() {
            super(MATCH_PARENT, WRAP_CONTENT);
            column = -1;
            span = 1;
        }

        /**
         * <p>Puts the view in the specified column.</p>
         *
         * <p>Sets the child width to {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT}
         * and the child height to
         * {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT}.</p>
         *
         * @param column the column index for the view
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.274 -0500", hash_original_method = "151219291568C02E222942C0989F524E", hash_generated_method = "1FA6B7EF219AA2072A27C83F109863E8")
        
public LayoutParams(int column) {
            this();
            this.column = column;
        }

        /**
         * {@inheritDoc}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.277 -0500", hash_original_method = "DE4ED36682A1028E303BDCC28A48E06F", hash_generated_method = "AA7E78F64C1B2029CADFD7AA230FA359")
        
public LayoutParams(ViewGroup.LayoutParams p) {
            super(p);
        }

        /**
         * {@inheritDoc}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.280 -0500", hash_original_method = "CC87BD4B8C067788FA2BA37DBA116F62", hash_generated_method = "A83E3EC70AE7CFFC0495D4E169E975D9")
        
public LayoutParams(MarginLayoutParams source) {
            super(source);
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.283 -0500", hash_original_method = "FC68734AF1365F8395009E059E8FEC81", hash_generated_method = "80473F0F3A43FF430B3E85F14B0F118D")
        
@Override
        protected void setBaseAttributes(TypedArray a, int widthAttr, int heightAttr) {
            // We don't want to force users to specify a layout_width
            if (a.hasValue(widthAttr)) {
                width = a.getLayoutDimension(widthAttr, "layout_width");
            } else {
                width = MATCH_PARENT;
            }

            // We don't want to force users to specify a layout_height
            if (a.hasValue(heightAttr)) {
                height = a.getLayoutDimension(heightAttr, "layout_height");
            } else {
                height = WRAP_CONTENT;
            }
        }
    }
    
    private class ChildrenTracker implements OnHierarchyChangeListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.287 -0500", hash_original_field = "6ECCFF5CC14CBAE58C62A781C6A9F170", hash_generated_field = "F5EA6A3A542BD0A280910BBDD59E219A")

        private OnHierarchyChangeListener listener;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.923 -0400", hash_original_method = "8BC9074DC1C8352428B8EEF8AE4154F0", hash_generated_method = "8BC9074DC1C8352428B8EEF8AE4154F0")
        public ChildrenTracker ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.290 -0500", hash_original_method = "366CDDD217CE23168243D85764F583BC", hash_generated_method = "C583B0DEB76C1156D09329DD6B11D1A4")
        
private void setOnHierarchyChangeListener(OnHierarchyChangeListener listener) {
            this.listener = listener;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.292 -0500", hash_original_method = "0A8BC7BCBC1B19A4EC6087AEE2DC9AC1", hash_generated_method = "59703A2D65A6B4AA6895CFB386AA5C55")
        
public void onChildViewAdded(View parent, View child) {
            // dirties the index to column map
            mColumnToChildIndex = null;

            if (this.listener != null) {
                this.listener.onChildViewAdded(parent, child);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:06.295 -0500", hash_original_method = "BAF37826E19FE7806EA8737E4B16ECFB", hash_generated_method = "AC23097617EB04D5FA06D9254B1030EF")
        
public void onChildViewRemoved(View parent, View child) {
            // dirties the index to column map
            mColumnToChildIndex = null;

            if (this.listener != null) {
                this.listener.onChildViewRemoved(parent, child);
            }
        }
        
    }
    
}

