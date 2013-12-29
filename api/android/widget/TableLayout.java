package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.regex.Pattern;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;

import com.android.internal.R;






public class TableLayout extends LinearLayout {

    /**
     * <p>Parses a sequence of columns ids defined in a CharSequence with the
     * following pattern (regex): \d+(\s*,\s*\d+)*</p>
     *
     * <p>Examples: "1" or "13, 7, 6" or "".</p>
     *
     * <p>The result of the parsing is stored in a sparse boolean array. The
     * parsed column ids are used as the keys of the sparse array. The values
     * are always true.</p>
     *
     * @param sequence a sequence of column ids, can be empty but not null
     * @return a sparse array of boolean mapping column indexes to the columns
     *         collapse state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.327 -0500", hash_original_method = "A6D730040E20DF7D0E0DA97862E3FE2F", hash_generated_method = "2E54471442981D41A41E36565C1066D6")
    private static SparseBooleanArray parseColumns(String sequence) {
        SparseBooleanArray columns = new SparseBooleanArray();
        Pattern pattern = Pattern.compile("\\s*,\\s*");
        String[] columnDefs = pattern.split(sequence);

        for (String columnIdentifier : columnDefs) {
            try {
                int columnIndex = Integer.parseInt(columnIdentifier);
                // only valid, i.e. positive, columns indexes are handled
                if (columnIndex >= 0) {
                    // putting true in this sparse array indicates that the
                    // column index was defined in the XML file
                    columns.put(columnIndex, true);
                }
            } catch (NumberFormatException e) {
                // we just ignore columns that don't exist
            }
        }

        return columns;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.317 -0500", hash_original_field = "0484993A67AA29C64FC5AF4F47E87A25", hash_generated_field = "2F4A0135686BA0EF51C1B28313E81C22")

    private int[] mMaxWidths;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.318 -0500", hash_original_field = "4F8B7D87CAA3E9F415E6EE3859978B46", hash_generated_field = "237BCAE2DDAA5809B4CBC18C28CE9641")

    private SparseBooleanArray mStretchableColumns;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.319 -0500", hash_original_field = "0F640720B66228A2A7B5BED53DDC8EB2", hash_generated_field = "54FA12C85C12CB357EAE91A430CC8F14")

    private SparseBooleanArray mShrinkableColumns;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.321 -0500", hash_original_field = "BF8BED71769EA3E80EA0DFDE7655656B", hash_generated_field = "983852F7982125991CFDF43A53958BB8")

    private SparseBooleanArray mCollapsedColumns;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.322 -0500", hash_original_field = "6AFCC6CA54BB3E076E4B79A329B6E876", hash_generated_field = "8EDC18A923C7B9030A0D0EA6C921EA5B")


    private boolean mShrinkAllColumns;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.322 -0500", hash_original_field = "6F731FA4CA7F757492BE86BFC5178D55", hash_generated_field = "2727CBE2D69E3A21A8D531AB6996F6A8")

    private boolean mStretchAllColumns;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.323 -0500", hash_original_field = "85E6ABD677B9EECC88649F2C8A1D4547", hash_generated_field = "CB216867A328EE0A793FB91163122291")


    private TableLayout.PassThroughHierarchyChangeListener mPassThroughListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.324 -0500", hash_original_field = "C9E05499054E8056F0A4805D1295DEC9", hash_generated_field = "11DCD11B6A2634BB183BD4F1FB332620")


    private boolean mInitialized;

    /**
     * <p>Creates a new TableLayout for the given context.</p>
     *
     * @param context the application environment
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.325 -0500", hash_original_method = "2DBA50ED74E78B2838BC7527149D5669", hash_generated_method = "DB53A452C8765AE47CA428268C2E64C8")
    public TableLayout(Context context) {
        super(context);
        initTableLayout();
    }

    /**
     * <p>Creates a new TableLayout for the given context and with the
     * specified set attributes.</p>
     *
     * @param context the application environment
     * @param attrs a collection of attributes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.326 -0500", hash_original_method = "959C37211929CCCB2D56BECF55A0682A", hash_generated_method = "2BE76C86A36FE34A2D756B4BA1850375")
    public TableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TableLayout);

        String stretchedColumns = a.getString(R.styleable.TableLayout_stretchColumns);
        if (stretchedColumns != null) {
            if (stretchedColumns.charAt(0) == '*') {
                mStretchAllColumns = true;
            } else {
                mStretchableColumns = parseColumns(stretchedColumns);
            }
        }

        String shrinkedColumns = a.getString(R.styleable.TableLayout_shrinkColumns);
        if (shrinkedColumns != null) {
            if (shrinkedColumns.charAt(0) == '*') {
                mShrinkAllColumns = true;
            } else {
                mShrinkableColumns = parseColumns(shrinkedColumns);
            }
        }

        String collapsedColumns = a.getString(R.styleable.TableLayout_collapseColumns);
        if (collapsedColumns != null) {
            mCollapsedColumns = parseColumns(collapsedColumns);
        }

        a.recycle();
        initTableLayout();
    }

    /**
     * <p>Performs initialization common to prorgrammatic use and XML use of
     * this widget.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.328 -0500", hash_original_method = "B376012DF0DA3032DA90C2CCE23CE9AB", hash_generated_method = "72AC2FEF484178E0E8B1CD63D07623DB")
    private void initTableLayout() {
        if (mCollapsedColumns == null) {
            mCollapsedColumns = new SparseBooleanArray();
        }
        if (mStretchableColumns == null) {
            mStretchableColumns = new SparseBooleanArray();
        }
        if (mShrinkableColumns == null) {
            mShrinkableColumns = new SparseBooleanArray();
        }

        mPassThroughListener = new PassThroughHierarchyChangeListener();
        // make sure to call the parent class method to avoid potential
        // infinite loops
        super.setOnHierarchyChangeListener(mPassThroughListener);

        mInitialized = true;
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.329 -0500", hash_original_method = "E023B2331F5B7D82E6BF896494CABA17", hash_generated_method = "AF74A4B1FE64A7C419FFF3963B6269E6")
    @Override
public void setOnHierarchyChangeListener(
            OnHierarchyChangeListener listener) {
        // the user listener is delegated to our pass-through listener
        mPassThroughListener.mOnHierarchyChangeListener = listener;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.330 -0500", hash_original_method = "46F66A2D3F5735AEA41A7DB58B431E82", hash_generated_method = "278AB8FF62E299874D62421E6B6C0879")
    private void requestRowsLayout() {
        if (mInitialized) {
            final int count = getChildCount();
            for (int i = 0; i < count; i++) {
                getChildAt(i).requestLayout();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.331 -0500", hash_original_method = "EAC930A18C6CF1CADFC926F8862188F3", hash_generated_method = "5E5AA0B38035666961A3AE8220EF2442")
    @Override
public void requestLayout() {
        if (mInitialized) {
            int count = getChildCount();
            for (int i = 0; i < count; i++) {
                getChildAt(i).forceLayout();
            }
        }

        super.requestLayout();
    }

    /**
     * <p>Indicates whether all columns are shrinkable or not.</p>
     *
     * @return true if all columns are shrinkable, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.331 -0500", hash_original_method = "624BF5A05D2AD2F91E52D17C6AFF6DC5", hash_generated_method = "0B5116E0C68CA388AB59C0FD4706ECB4")
    public boolean isShrinkAllColumns() {
        return mShrinkAllColumns;
    }

    /**
     * <p>Convenience method to mark all columns as shrinkable.</p>
     *
     * @param shrinkAllColumns true to mark all columns shrinkable
     *
     * @attr ref android.R.styleable#TableLayout_shrinkColumns
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.332 -0500", hash_original_method = "26E4ADFC91B374A7FF7EFE7A14E44F9B", hash_generated_method = "0DB440700F57D07C062D0061D740CEF2")
    public void setShrinkAllColumns(boolean shrinkAllColumns) {
        mShrinkAllColumns = shrinkAllColumns;
    }

    /**
     * <p>Indicates whether all columns are stretchable or not.</p>
     *
     * @return true if all columns are stretchable, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.333 -0500", hash_original_method = "C0959877EF2F1B6CBC27D41EECDAD445", hash_generated_method = "F69C736707C112164A326AFEE9F3CAD1")
    public boolean isStretchAllColumns() {
        return mStretchAllColumns;
    }

    /**
     * <p>Convenience method to mark all columns as stretchable.</p>
     *
     * @param stretchAllColumns true to mark all columns stretchable
     *
     * @attr ref android.R.styleable#TableLayout_stretchColumns
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.334 -0500", hash_original_method = "276589380DE193D6AFC8DA7EB773135F", hash_generated_method = "544969475238EE598049D5CD6FE216B6")
    public void setStretchAllColumns(boolean stretchAllColumns) {
        mStretchAllColumns = stretchAllColumns;
    }

    /**
     * <p>Collapses or restores a given column. When collapsed, a column
     * does not appear on screen and the extra space is reclaimed by the
     * other columns. A column is collapsed/restored only when it belongs to
     * a {@link android.widget.TableRow}.</p>
     *
     * <p>Calling this method requests a layout operation.</p>
     *
     * @param columnIndex the index of the column
     * @param isCollapsed true if the column must be collapsed, false otherwise
     *
     * @attr ref android.R.styleable#TableLayout_collapseColumns
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.335 -0500", hash_original_method = "829331550E99E48511938200E10E0516", hash_generated_method = "2F3AB9C077E0992471E56D80AB0CEECB")
    public void setColumnCollapsed(int columnIndex, boolean isCollapsed) {
        // update the collapse status of the column
        mCollapsedColumns.put(columnIndex, isCollapsed);

        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View view = getChildAt(i);
            if (view instanceof TableRow) {
                ((TableRow) view).setColumnCollapsed(columnIndex, isCollapsed);
            }
        }

        requestRowsLayout();
    }

    /**
     * <p>Returns the collapsed state of the specified column.</p>
     *
     * @param columnIndex the index of the column
     * @return true if the column is collapsed, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.335 -0500", hash_original_method = "19A6345BB30DA1B94EF425A139EBF7B6", hash_generated_method = "3F38B0E9396A1A008A1A74F14E81449E")
    public boolean isColumnCollapsed(int columnIndex) {
        return mCollapsedColumns.get(columnIndex);
    }

    /**
     * <p>Makes the given column stretchable or not. When stretchable, a column
     * takes up as much as available space as possible in its row.</p>
     *
     * <p>Calling this method requests a layout operation.</p>
     *
     * @param columnIndex the index of the column
     * @param isStretchable true if the column must be stretchable,
     *                      false otherwise. Default is false.
     *
     * @attr ref android.R.styleable#TableLayout_stretchColumns
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.336 -0500", hash_original_method = "62253048F5CA87D307E8714AA1DE21F0", hash_generated_method = "808CA8CC5F13F77F48F338B623EFC98D")
    public void setColumnStretchable(int columnIndex, boolean isStretchable) {
        mStretchableColumns.put(columnIndex, isStretchable);
        requestRowsLayout();
    }

    /**
     * <p>Returns whether the specified column is stretchable or not.</p>
     *
     * @param columnIndex the index of the column
     * @return true if the column is stretchable, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.337 -0500", hash_original_method = "32065C4976C924BEAD40EDE2A514E0EE", hash_generated_method = "CC87C1C88F7B8E80FD89EE1BFCFB11DF")
    public boolean isColumnStretchable(int columnIndex) {
        return mStretchAllColumns || mStretchableColumns.get(columnIndex);
    }

    /**
     * <p>Makes the given column shrinkable or not. When a row is too wide, the
     * table can reclaim extra space from shrinkable columns.</p>
     *
     * <p>Calling this method requests a layout operation.</p>
     *
     * @param columnIndex the index of the column
     * @param isShrinkable true if the column must be shrinkable,
     *                     false otherwise. Default is false.
     *
     * @attr ref android.R.styleable#TableLayout_shrinkColumns
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.338 -0500", hash_original_method = "3624AF127452F84D2332BE1546302CDA", hash_generated_method = "3204F1072D4D8DF5E9EFC18E8D7EFD71")
    public void setColumnShrinkable(int columnIndex, boolean isShrinkable) {
        mShrinkableColumns.put(columnIndex, isShrinkable);
        requestRowsLayout();
    }

    /**
     * <p>Returns whether the specified column is shrinkable or not.</p>
     *
     * @param columnIndex the index of the column
     * @return true if the column is shrinkable, false otherwise. Default is false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.339 -0500", hash_original_method = "AE299BD43225B57B8AC568426E8DCDB2", hash_generated_method = "46149A762D438DE6911774E56D251C60")
    public boolean isColumnShrinkable(int columnIndex) {
        return mShrinkAllColumns || mShrinkableColumns.get(columnIndex);
    }

    /**
     * <p>Applies the columns collapse status to a new row added to this
     * table. This method is invoked by PassThroughHierarchyChangeListener
     * upon child insertion.</p>
     *
     * <p>This method only applies to {@link android.widget.TableRow}
     * instances.</p>
     *
     * @param child the newly added child
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.340 -0500", hash_original_method = "1A7EBA0F6B48090D166288951056A8A7", hash_generated_method = "6E5D1B029CF43E91C365AE3CFD94A65C")
    private void trackCollapsedColumns(View child) {
        if (child instanceof TableRow) {
            final TableRow row = (TableRow) child;
            final SparseBooleanArray collapsedColumns = mCollapsedColumns;
            final int count = collapsedColumns.size();
            for (int i = 0; i < count; i++) {
                int columnIndex = collapsedColumns.keyAt(i);
                boolean isCollapsed = collapsedColumns.valueAt(i);
                // the collapse status is set only when the column should be
                // collapsed; otherwise, this might affect the default
                // visibility of the row's children
                if (isCollapsed) {
                    row.setColumnCollapsed(columnIndex, isCollapsed);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.341 -0500", hash_original_method = "13A96A4A6DDFEE3010E840F1100E091C", hash_generated_method = "18287C39B44E85271EE2348EA638929D")
    @Override
public void addView(View child) {
        super.addView(child);
        requestRowsLayout();
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.341 -0500", hash_original_method = "0A8A998DCFADFBF06AD3633B7F78F767", hash_generated_method = "8BFAB0735EF1E25B153AAF8F3E4D5096")
    @Override
public void addView(View child, int index) {
        super.addView(child, index);
        requestRowsLayout();
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.342 -0500", hash_original_method = "F2FDB0BFA45548A61FACB12C8E83D6F6", hash_generated_method = "16F843354B36A41608DC08F7FB8E3FA8")
    @Override
public void addView(View child, ViewGroup.LayoutParams params) {
        super.addView(child, params);
        requestRowsLayout();
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.343 -0500", hash_original_method = "205DAA16DEE6F9CF58403F7DCF1DA0C1", hash_generated_method = "5A274798A4D915F6550AA5CC45D46C6F")
    @Override
public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        requestRowsLayout();
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.344 -0500", hash_original_method = "8CCC700F8795467ABA2DD388545C44C0", hash_generated_method = "D67B8B42057F961DD7DA8C68BB140FB9")
    @Override
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // enforce vertical layout
        measureVertical(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.345 -0500", hash_original_method = "47158FF62F96A7883F43DCCED676A47B", hash_generated_method = "65D02F96FF3049E326CFFDE57E94937D")
    @Override
protected void onLayout(boolean changed, int l, int t, int r, int b) {
        // enforce vertical layout
        layoutVertical();
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.346 -0500", hash_original_method = "D260EEF009252A9802D5F41574FD2463", hash_generated_method = "BAF5DBBE259B49798F16E9BBAD32874F")
    @Override
void measureChildBeforeLayout(View child, int childIndex,
            int widthMeasureSpec, int totalWidth,
            int heightMeasureSpec, int totalHeight) {
        // when the measured child is a table row, we force the width of its
        // children with the widths computed in findLargestCells()
        if (child instanceof TableRow) {
            ((TableRow) child).setColumnsWidthConstraints(mMaxWidths);
        }

        super.measureChildBeforeLayout(child, childIndex,
                widthMeasureSpec, totalWidth, heightMeasureSpec, totalHeight);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.346 -0500", hash_original_method = "A49B05A52F9F2AD597034B1B66F4E4A9", hash_generated_method = "C777CC254EEC31443B44EAEB5431CB13")
    @Override
void measureVertical(int widthMeasureSpec, int heightMeasureSpec) {
        findLargestCells(widthMeasureSpec);
        shrinkAndStretchColumns(widthMeasureSpec);

        super.measureVertical(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * <p>Finds the largest cell in each column. For each column, the width of
     * the largest cell is applied to all the other cells.</p>
     *
     * @param widthMeasureSpec the measure constraint imposed by our parent
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.348 -0500", hash_original_method = "4DFA55B8EC4F00C998EFCF5CE369887F", hash_generated_method = "E70E92D0AB2F45BDABAA12B4873229AD")
    private void findLargestCells(int widthMeasureSpec) {
        boolean firstRow = true;

        // find the maximum width for each column
        // the total number of columns is dynamically changed if we find
        // wider rows as we go through the children
        // the array is reused for each layout operation; the array can grow
        // but never shrinks. Unused extra cells in the array are just ignored
        // this behavior avoids to unnecessary grow the array after the first
        // layout operation
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }

            if (child instanceof TableRow) {
                final TableRow row = (TableRow) child;
                // forces the row's height
                final ViewGroup.LayoutParams layoutParams = row.getLayoutParams();
                layoutParams.height = LayoutParams.WRAP_CONTENT;

                final int[] widths = row.getColumnsWidths(widthMeasureSpec);
                final int newLength = widths.length;
                // this is the first row, we just need to copy the values
                if (firstRow) {
                    if (mMaxWidths == null || mMaxWidths.length != newLength) {
                        mMaxWidths = new int[newLength];
                    }
                    System.arraycopy(widths, 0, mMaxWidths, 0, newLength);
                    firstRow = false;
                } else {
                    int length = mMaxWidths.length;
                    final int difference = newLength - length;
                    // the current row is wider than the previous rows, so
                    // we just grow the array and copy the values
                    if (difference > 0) {
                        final int[] oldMaxWidths = mMaxWidths;
                        mMaxWidths = new int[newLength];
                        System.arraycopy(oldMaxWidths, 0, mMaxWidths, 0,
                                oldMaxWidths.length);
                        System.arraycopy(widths, oldMaxWidths.length,
                                mMaxWidths, oldMaxWidths.length, difference);
                    }

                    // the row is narrower or of the same width as the previous
                    // rows, so we find the maximum width for each column
                    // if the row is narrower than the previous ones,
                    // difference will be negative
                    final int[] maxWidths = mMaxWidths;
                    length = Math.min(length, newLength);
                    for (int j = 0; j < length; j++) {
                        maxWidths[j] = Math.max(maxWidths[j], widths[j]);
                    }
                }
            }
        }
    }

    /**
     * <p>Shrinks the columns if their total width is greater than the
     * width allocated by widthMeasureSpec. When the total width is less
     * than the allocated width, this method attempts to stretch columns
     * to fill the remaining space.</p>
     *
     * @param widthMeasureSpec the width measure specification as indicated
     *                         by this widget's parent
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.349 -0500", hash_original_method = "FCBDEF350302C6CDE69DD815C0835AC5", hash_generated_method = "562958D2A357BCA14CEF45418F0B26BF")
    private void shrinkAndStretchColumns(int widthMeasureSpec) {
        // when we have no row, mMaxWidths is not initialized and the loop
        // below could cause a NPE
        if (mMaxWidths == null) {
            return;
        }

        // should we honor AT_MOST, EXACTLY and UNSPECIFIED?
        int totalWidth = 0;
        for (int width : mMaxWidths) {
            totalWidth += width;
        }

        int size = MeasureSpec.getSize(widthMeasureSpec) - mPaddingLeft - mPaddingRight;

        if ((totalWidth > size) && (mShrinkAllColumns || mShrinkableColumns.size() > 0)) {
            // oops, the largest columns are wider than the row itself
            // fairly redistribute the row's width among the columns
            mutateColumnsWidth(mShrinkableColumns, mShrinkAllColumns, size, totalWidth);
        } else if ((totalWidth < size) && (mStretchAllColumns || mStretchableColumns.size() > 0)) {
            // if we have some space left, we distribute it among the
            // expandable columns
            mutateColumnsWidth(mStretchableColumns, mStretchAllColumns, size, totalWidth);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.350 -0500", hash_original_method = "4E3F5E45ADBAE8A09C7C386A43B12806", hash_generated_method = "E8D8AEA341637FF901E4F3686D772F5E")
    private void mutateColumnsWidth(SparseBooleanArray columns,
            boolean allColumns, int size, int totalWidth) {
        int skipped = 0;
        final int[] maxWidths = mMaxWidths;
        final int length = maxWidths.length;
        final int count = allColumns ? length : columns.size();
        final int totalExtraSpace = size - totalWidth;
        int extraSpace = totalExtraSpace / count;

        // Column's widths are changed: force child table rows to re-measure.
        // (done by super.measureVertical after shrinkAndStretchColumns.)
        final int nbChildren = getChildCount();
        for (int i = 0; i < nbChildren; i++) {
            View child = getChildAt(i);
            if (child instanceof TableRow) {
                child.forceLayout();
            }
        }

        if (!allColumns) {
            for (int i = 0; i < count; i++) {
                int column = columns.keyAt(i);
                if (columns.valueAt(i)) {
                    if (column < length) {
                        maxWidths[column] += extraSpace;
                    } else {
                        skipped++;
                    }
                }
            }
        } else {
            for (int i = 0; i < count; i++) {
                maxWidths[i] += extraSpace;
            }

            // we don't skip any column so we can return right away
            return;
        }

        if (skipped > 0 && skipped < count) {
            // reclaim any extra space we left to columns that don't exist
            extraSpace = skipped * extraSpace / (count - skipped);
            for (int i = 0; i < count; i++) {
                int column = columns.keyAt(i);
                if (columns.valueAt(i) && column < length) {
                    if (extraSpace > maxWidths[column]) {
                        maxWidths[column] = 0;
                    } else {
                        maxWidths[column] += extraSpace;
                    }
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.351 -0500", hash_original_method = "626569BEEA8B021D33534C4E62C986DD", hash_generated_method = "9849A2B95D738242137824F3C3AF2A33")
    @Override
public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new TableLayout.LayoutParams(getContext(), attrs);
    }

    /**
     * Returns a set of layout parameters with a width of
     * {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT},
     * and a height of {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.352 -0500", hash_original_method = "CBDF0BDAD2221E25AE8470C9AB157031", hash_generated_method = "08C9D8D0662D9DEB6BF1823243284E1B")
    @Override
protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.353 -0500", hash_original_method = "447CAFAFE5648615FE51407189D906A6", hash_generated_method = "6381DE11009CA0E2588B3226D7B46C75")
    @Override
protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof TableLayout.LayoutParams;
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.353 -0500", hash_original_method = "BBEB2ACD1EFF73877451077ABC9022BA", hash_generated_method = "0ED876FED2AB61E7BC5645ABFCC8A3F3")
    @Override
protected LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    
    public static class LayoutParams extends LinearLayout.LayoutParams {
        /**
         * {@inheritDoc}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.355 -0500", hash_original_method = "35869249D2D5BC08819A8507F87D33FD", hash_generated_method = "72A2ECA2CF4C647C2D28F670D4DC27E1")
        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        /**
         * {@inheritDoc}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.355 -0500", hash_original_method = "AE70A42624DF2261DCFDCEED49F51EE5", hash_generated_method = "487944804F791683B1D6258C47E2D24F")
        public LayoutParams(int w, int h) {
            super(MATCH_PARENT, h);
        }

        /**
         * {@inheritDoc}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.356 -0500", hash_original_method = "A4AECF432693F8EEB49EF2243FEC276D", hash_generated_method = "FBBED945DC79E84DF55272126BE86AAF")
        public LayoutParams(int w, int h, float initWeight) {
            super(MATCH_PARENT, h, initWeight);
        }

        /**
         * <p>Sets the child width to
         * {@link android.view.ViewGroup.LayoutParams} and the child height to
         * {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT}.</p>
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.357 -0500", hash_original_method = "23F50431F0504066EA301D42AFB8DAFD", hash_generated_method = "7F742792681744F3E74094BE02839621")
        public LayoutParams() {
            super(MATCH_PARENT, WRAP_CONTENT);
        }

        /**
         * {@inheritDoc}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.358 -0500", hash_original_method = "DE4ED36682A1028E303BDCC28A48E06F", hash_generated_method = "AA7E78F64C1B2029CADFD7AA230FA359")
        public LayoutParams(ViewGroup.LayoutParams p) {
            super(p);
        }

        /**
         * {@inheritDoc}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.359 -0500", hash_original_method = "CC87BD4B8C067788FA2BA37DBA116F62", hash_generated_method = "A83E3EC70AE7CFFC0495D4E169E975D9")
        public LayoutParams(MarginLayoutParams source) {
            super(source);
        }

        /**
         * <p>Fixes the row's width to
         * {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT}; the row's
         * height is fixed to
         * {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT} if no layout
         * height is specified.</p>
         *
         * @param a the styled attributes set
         * @param widthAttr the width attribute to fetch
         * @param heightAttr the height attribute to fetch
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.360 -0500", hash_original_method = "83FF363F248E79C3B410C30F940F0D3F", hash_generated_method = "2FB701AF10D902AA5F802689F834EA01")
        @Override
protected void setBaseAttributes(TypedArray a,
                int widthAttr, int heightAttr) {
            this.width = MATCH_PARENT;
            if (a.hasValue(heightAttr)) {
                this.height = a.getLayoutDimension(heightAttr, "layout_height");
            } else {
                this.height = WRAP_CONTENT;
            }
        }

        
    }


    
    private class PassThroughHierarchyChangeListener implements OnHierarchyChangeListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.361 -0500", hash_original_field = "F8AA800937407072EB5CC33824E49D48", hash_generated_field = "2D0D33391D6527FD2B9F8D3EC852AD2F")

        private OnHierarchyChangeListener mOnHierarchyChangeListener;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.854 -0400", hash_original_method = "0DD100C097C91E6D30F06426909CA640", hash_generated_method = "0DD100C097C91E6D30F06426909CA640")
        public PassThroughHierarchyChangeListener ()
        {
            //Synthesized constructor
        }

        /**
         * {@inheritDoc}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.362 -0500", hash_original_method = "E59BBFD5FEFAEE7E1E28F40381DEB3B0", hash_generated_method = "8E318A2792AEE55A04BC5E6A298F3069")
        public void onChildViewAdded(View parent, View child) {
            trackCollapsedColumns(child);

            if (mOnHierarchyChangeListener != null) {
                mOnHierarchyChangeListener.onChildViewAdded(parent, child);
            }
        }

        /**
         * {@inheritDoc}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:59.363 -0500", hash_original_method = "5A65479CCEE8BCB10036402E9895503B", hash_generated_method = "94163AAAB196C2703C1FFC2B2FA7004C")
        public void onChildViewRemoved(View parent, View child) {
            if (mOnHierarchyChangeListener != null) {
                mOnHierarchyChangeListener.onChildViewRemoved(parent, child);
            }
        }

        
    }


    
}

