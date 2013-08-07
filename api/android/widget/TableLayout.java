package android.widget;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.838 -0400", hash_original_field = "A8AFB75CC2C31DA9076A61554C230A06", hash_generated_field = "2F4A0135686BA0EF51C1B28313E81C22")

    private int[] mMaxWidths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.838 -0400", hash_original_field = "521DB786EE42107EF3865601DAFABD19", hash_generated_field = "237BCAE2DDAA5809B4CBC18C28CE9641")

    private SparseBooleanArray mStretchableColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.838 -0400", hash_original_field = "F49C7472F992C1A8053C750548CB9F83", hash_generated_field = "54FA12C85C12CB357EAE91A430CC8F14")

    private SparseBooleanArray mShrinkableColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.838 -0400", hash_original_field = "5B013A5EBB7986AB2674828E37B9F8F3", hash_generated_field = "983852F7982125991CFDF43A53958BB8")

    private SparseBooleanArray mCollapsedColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.838 -0400", hash_original_field = "E0A33CC4BFDD5832E9B9D799326C02FD", hash_generated_field = "8EDC18A923C7B9030A0D0EA6C921EA5B")

    private boolean mShrinkAllColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.838 -0400", hash_original_field = "005C7B7FE42AD00688D78F9B78798C32", hash_generated_field = "2727CBE2D69E3A21A8D531AB6996F6A8")

    private boolean mStretchAllColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.838 -0400", hash_original_field = "49134BEE5179245030E696FDD8403D38", hash_generated_field = "CB216867A328EE0A793FB91163122291")

    private TableLayout.PassThroughHierarchyChangeListener mPassThroughListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.838 -0400", hash_original_field = "57006E58594DC862E67D1855FDF16FEE", hash_generated_field = "11DCD11B6A2634BB183BD4F1FB332620")

    private boolean mInitialized;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.839 -0400", hash_original_method = "2DBA50ED74E78B2838BC7527149D5669", hash_generated_method = "D440810FC695276EF53DCF37C9A3445F")
    public  TableLayout(Context context) {
        super(context);
        addTaint(context.getTaint());
        initTableLayout();
        // ---------- Original Method ----------
        //initTableLayout();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.840 -0400", hash_original_method = "959C37211929CCCB2D56BECF55A0682A", hash_generated_method = "F29396BB1E023D4A9F662A25A3FC76E1")
    public  TableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TableLayout);
        String stretchedColumns = a.getString(R.styleable.TableLayout_stretchColumns);
        if(stretchedColumns != null)        
        {
            if(stretchedColumns.charAt(0) == '*')            
            {
                mStretchAllColumns = true;
            } //End block
            else
            {
                mStretchableColumns = parseColumns(stretchedColumns);
            } //End block
        } //End block
        String shrinkedColumns = a.getString(R.styleable.TableLayout_shrinkColumns);
        if(shrinkedColumns != null)        
        {
            if(shrinkedColumns.charAt(0) == '*')            
            {
                mShrinkAllColumns = true;
            } //End block
            else
            {
                mShrinkableColumns = parseColumns(shrinkedColumns);
            } //End block
        } //End block
        String collapsedColumns = a.getString(R.styleable.TableLayout_collapseColumns);
        if(collapsedColumns != null)        
        {
            mCollapsedColumns = parseColumns(collapsedColumns);
        } //End block
        a.recycle();
        initTableLayout();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    private static SparseBooleanArray parseColumns(String sequence) {
        SparseBooleanArray columns = new SparseBooleanArray();
        Pattern pattern = Pattern.compile("\\s*,\\s*");
        String[] columnDefs = pattern.split(sequence);
        for (String columnIdentifier : columnDefs) {
            try {
                int columnIndex = Integer.parseInt(columnIdentifier);
                if (columnIndex >= 0) {
                    columns.put(columnIndex, true);
                }
            } catch (NumberFormatException e) {
            }
        }
        return columns;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.841 -0400", hash_original_method = "B376012DF0DA3032DA90C2CCE23CE9AB", hash_generated_method = "EBDB1CA5C6DE12BE8BEEE030E8E32A2B")
    private void initTableLayout() {
        if(mCollapsedColumns == null)        
        {
            mCollapsedColumns = new SparseBooleanArray();
        } //End block
        if(mStretchableColumns == null)        
        {
            mStretchableColumns = new SparseBooleanArray();
        } //End block
        if(mShrinkableColumns == null)        
        {
            mShrinkableColumns = new SparseBooleanArray();
        } //End block
        mPassThroughListener = new PassThroughHierarchyChangeListener();
        super.setOnHierarchyChangeListener(mPassThroughListener);
        mInitialized = true;
        // ---------- Original Method ----------
        //if (mCollapsedColumns == null) {
            //mCollapsedColumns = new SparseBooleanArray();
        //}
        //if (mStretchableColumns == null) {
            //mStretchableColumns = new SparseBooleanArray();
        //}
        //if (mShrinkableColumns == null) {
            //mShrinkableColumns = new SparseBooleanArray();
        //}
        //mPassThroughListener = new PassThroughHierarchyChangeListener();
        //super.setOnHierarchyChangeListener(mPassThroughListener);
        //mInitialized = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.842 -0400", hash_original_method = "E023B2331F5B7D82E6BF896494CABA17", hash_generated_method = "7FA4E96971EEFFA6A54848F49887181B")
    @Override
    public void setOnHierarchyChangeListener(
            OnHierarchyChangeListener listener) {
        mPassThroughListener.mOnHierarchyChangeListener = listener;
        // ---------- Original Method ----------
        //mPassThroughListener.mOnHierarchyChangeListener = listener;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.843 -0400", hash_original_method = "46F66A2D3F5735AEA41A7DB58B431E82", hash_generated_method = "99F673A3DC8F3A6272D74C21613C8559")
    private void requestRowsLayout() {
        if(mInitialized)        
        {
            final int count = getChildCount();
for(int i = 0;i < count;i++)
            {
                getChildAt(i).requestLayout();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mInitialized) {
            //final int count = getChildCount();
            //for (int i = 0; i < count; i++) {
                //getChildAt(i).requestLayout();
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.843 -0400", hash_original_method = "EAC930A18C6CF1CADFC926F8862188F3", hash_generated_method = "A319AC77FDA4E07966D54945594CC473")
    @Override
    public void requestLayout() {
        if(mInitialized)        
        {
            int count = getChildCount();
for(int i = 0;i < count;i++)
            {
                getChildAt(i).forceLayout();
            } //End block
        } //End block
        super.requestLayout();
        // ---------- Original Method ----------
        //if (mInitialized) {
            //int count = getChildCount();
            //for (int i = 0; i < count; i++) {
                //getChildAt(i).forceLayout();
            //}
        //}
        //super.requestLayout();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.844 -0400", hash_original_method = "624BF5A05D2AD2F91E52D17C6AFF6DC5", hash_generated_method = "B5E6A605561717E941C3D53416E50F49")
    public boolean isShrinkAllColumns() {
        boolean varE0A33CC4BFDD5832E9B9D799326C02FD_1239979449 = (mShrinkAllColumns);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1118618424 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1118618424;
        // ---------- Original Method ----------
        //return mShrinkAllColumns;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.844 -0400", hash_original_method = "26E4ADFC91B374A7FF7EFE7A14E44F9B", hash_generated_method = "BBE5382EC77465A31A4447AFE719DE61")
    public void setShrinkAllColumns(boolean shrinkAllColumns) {
        mShrinkAllColumns = shrinkAllColumns;
        // ---------- Original Method ----------
        //mShrinkAllColumns = shrinkAllColumns;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.845 -0400", hash_original_method = "C0959877EF2F1B6CBC27D41EECDAD445", hash_generated_method = "B3339878AEA84D92ACF6FF1FC7FF66BF")
    public boolean isStretchAllColumns() {
        boolean var005C7B7FE42AD00688D78F9B78798C32_1381762454 = (mStretchAllColumns);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1148025116 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1148025116;
        // ---------- Original Method ----------
        //return mStretchAllColumns;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.845 -0400", hash_original_method = "276589380DE193D6AFC8DA7EB773135F", hash_generated_method = "61A303E8046B3D7315D7C10E5A2B80A2")
    public void setStretchAllColumns(boolean stretchAllColumns) {
        mStretchAllColumns = stretchAllColumns;
        // ---------- Original Method ----------
        //mStretchAllColumns = stretchAllColumns;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.845 -0400", hash_original_method = "829331550E99E48511938200E10E0516", hash_generated_method = "2C9C81FFE89CB65B249BDCEB562DBD80")
    public void setColumnCollapsed(int columnIndex, boolean isCollapsed) {
        addTaint(isCollapsed);
        addTaint(columnIndex);
        mCollapsedColumns.put(columnIndex, isCollapsed);
        int count = getChildCount();
for(int i = 0;i < count;i++)
        {
            final View view = getChildAt(i);
            if(view instanceof TableRow)            
            {
                ((TableRow) view).setColumnCollapsed(columnIndex, isCollapsed);
            } //End block
        } //End block
        requestRowsLayout();
        // ---------- Original Method ----------
        //mCollapsedColumns.put(columnIndex, isCollapsed);
        //int count = getChildCount();
        //for (int i = 0; i < count; i++) {
            //final View view = getChildAt(i);
            //if (view instanceof TableRow) {
                //((TableRow) view).setColumnCollapsed(columnIndex, isCollapsed);
            //}
        //}
        //requestRowsLayout();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.846 -0400", hash_original_method = "19A6345BB30DA1B94EF425A139EBF7B6", hash_generated_method = "2D1DF7ACD57F25C04E5FB11968B9B402")
    public boolean isColumnCollapsed(int columnIndex) {
        addTaint(columnIndex);
        boolean var2F6D98D24ED9687DA088E00B3FD248AB_1316170233 = (mCollapsedColumns.get(columnIndex));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1985617288 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1985617288;
        // ---------- Original Method ----------
        //return mCollapsedColumns.get(columnIndex);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.847 -0400", hash_original_method = "62253048F5CA87D307E8714AA1DE21F0", hash_generated_method = "6C856455456BCAF792219D0C869EB2DB")
    public void setColumnStretchable(int columnIndex, boolean isStretchable) {
        addTaint(isStretchable);
        addTaint(columnIndex);
        mStretchableColumns.put(columnIndex, isStretchable);
        requestRowsLayout();
        // ---------- Original Method ----------
        //mStretchableColumns.put(columnIndex, isStretchable);
        //requestRowsLayout();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.847 -0400", hash_original_method = "32065C4976C924BEAD40EDE2A514E0EE", hash_generated_method = "93985646D9D19D5CF7EA41F066F001A9")
    public boolean isColumnStretchable(int columnIndex) {
        addTaint(columnIndex);
        boolean varF02623C310B36EFD850D04594D914A80_1949601026 = (mStretchAllColumns || mStretchableColumns.get(columnIndex));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1314227302 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1314227302;
        // ---------- Original Method ----------
        //return mStretchAllColumns || mStretchableColumns.get(columnIndex);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.847 -0400", hash_original_method = "3624AF127452F84D2332BE1546302CDA", hash_generated_method = "FFD1DF201C279B5BAF8E549A95121A72")
    public void setColumnShrinkable(int columnIndex, boolean isShrinkable) {
        addTaint(isShrinkable);
        addTaint(columnIndex);
        mShrinkableColumns.put(columnIndex, isShrinkable);
        requestRowsLayout();
        // ---------- Original Method ----------
        //mShrinkableColumns.put(columnIndex, isShrinkable);
        //requestRowsLayout();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.848 -0400", hash_original_method = "AE299BD43225B57B8AC568426E8DCDB2", hash_generated_method = "F0FE15DB020C3EE45A12F36A5D961C57")
    public boolean isColumnShrinkable(int columnIndex) {
        addTaint(columnIndex);
        boolean varDF995E9C48286C6364E0C07F56DED3FE_720018816 = (mShrinkAllColumns || mShrinkableColumns.get(columnIndex));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1986985476 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1986985476;
        // ---------- Original Method ----------
        //return mShrinkAllColumns || mShrinkableColumns.get(columnIndex);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.848 -0400", hash_original_method = "1A7EBA0F6B48090D166288951056A8A7", hash_generated_method = "D147D504635AB056C72115672FDD4A4D")
    private void trackCollapsedColumns(View child) {
        addTaint(child.getTaint());
        if(child instanceof TableRow)        
        {
            final TableRow row = (TableRow) child;
            final SparseBooleanArray collapsedColumns = mCollapsedColumns;
            final int count = collapsedColumns.size();
for(int i = 0;i < count;i++)
            {
                int columnIndex = collapsedColumns.keyAt(i);
                boolean isCollapsed = collapsedColumns.valueAt(i);
                if(isCollapsed)                
                {
                    row.setColumnCollapsed(columnIndex, isCollapsed);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (child instanceof TableRow) {
            //final TableRow row = (TableRow) child;
            //final SparseBooleanArray collapsedColumns = mCollapsedColumns;
            //final int count = collapsedColumns.size();
            //for (int i = 0; i < count; i++) {
                //int columnIndex = collapsedColumns.keyAt(i);
                //boolean isCollapsed = collapsedColumns.valueAt(i);
                //if (isCollapsed) {
                    //row.setColumnCollapsed(columnIndex, isCollapsed);
                //}
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.848 -0400", hash_original_method = "13A96A4A6DDFEE3010E840F1100E091C", hash_generated_method = "CD1DB5AA0E477D1B646529117CF16098")
    @Override
    public void addView(View child) {
        addTaint(child.getTaint());
        super.addView(child);
        requestRowsLayout();
        // ---------- Original Method ----------
        //super.addView(child);
        //requestRowsLayout();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.849 -0400", hash_original_method = "0A8A998DCFADFBF06AD3633B7F78F767", hash_generated_method = "8EE259ECE46FDF93CB71F78CAE105B7C")
    @Override
    public void addView(View child, int index) {
        addTaint(index);
        addTaint(child.getTaint());
        super.addView(child, index);
        requestRowsLayout();
        // ---------- Original Method ----------
        //super.addView(child, index);
        //requestRowsLayout();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.849 -0400", hash_original_method = "F2FDB0BFA45548A61FACB12C8E83D6F6", hash_generated_method = "82C9163A0C6119934C5883984E361EF6")
    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(child.getTaint());
        super.addView(child, params);
        requestRowsLayout();
        // ---------- Original Method ----------
        //super.addView(child, params);
        //requestRowsLayout();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.849 -0400", hash_original_method = "205DAA16DEE6F9CF58403F7DCF1DA0C1", hash_generated_method = "74F7B36452711C78D1B05D802AF75B98")
    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(index);
        addTaint(child.getTaint());
        super.addView(child, index, params);
        requestRowsLayout();
        // ---------- Original Method ----------
        //super.addView(child, index, params);
        //requestRowsLayout();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.849 -0400", hash_original_method = "8CCC700F8795467ABA2DD388545C44C0", hash_generated_method = "91980B4929CFAEBBBC75B5EA9B4CFE27")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        measureVertical(widthMeasureSpec, heightMeasureSpec);
        // ---------- Original Method ----------
        //measureVertical(widthMeasureSpec, heightMeasureSpec);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.849 -0400", hash_original_method = "47158FF62F96A7883F43DCCED676A47B", hash_generated_method = "E9B7D90397E1C3282890E7FF158C379C")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        addTaint(changed);
        layoutVertical();
        // ---------- Original Method ----------
        //layoutVertical();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.850 -0400", hash_original_method = "D260EEF009252A9802D5F41574FD2463", hash_generated_method = "184813E071BE28FEA0D252CF70540CCB")
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
        if(child instanceof TableRow)        
        {
            ((TableRow) child).setColumnsWidthConstraints(mMaxWidths);
        } //End block
        super.measureChildBeforeLayout(child, childIndex,
                widthMeasureSpec, totalWidth, heightMeasureSpec, totalHeight);
        // ---------- Original Method ----------
        //if (child instanceof TableRow) {
            //((TableRow) child).setColumnsWidthConstraints(mMaxWidths);
        //}
        //super.measureChildBeforeLayout(child, childIndex,
                //widthMeasureSpec, totalWidth, heightMeasureSpec, totalHeight);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.850 -0400", hash_original_method = "A49B05A52F9F2AD597034B1B66F4E4A9", hash_generated_method = "0988FB2D8AB48F4171481BA14BB5850E")
    @Override
     void measureVertical(int widthMeasureSpec, int heightMeasureSpec) {
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        findLargestCells(widthMeasureSpec);
        shrinkAndStretchColumns(widthMeasureSpec);
        super.measureVertical(widthMeasureSpec, heightMeasureSpec);
        // ---------- Original Method ----------
        //findLargestCells(widthMeasureSpec);
        //shrinkAndStretchColumns(widthMeasureSpec);
        //super.measureVertical(widthMeasureSpec, heightMeasureSpec);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.850 -0400", hash_original_method = "4DFA55B8EC4F00C998EFCF5CE369887F", hash_generated_method = "4A2A435888046D96F86785FEF57CDE39")
    private void findLargestCells(int widthMeasureSpec) {
        addTaint(widthMeasureSpec);
        boolean firstRow = true;
        final int count = getChildCount();
for(int i = 0;i < count;i++)
        {
            final View child = getChildAt(i);
            if(child.getVisibility() == GONE)            
            {
                continue;
            } //End block
            if(child instanceof TableRow)            
            {
                final TableRow row = (TableRow) child;
                final ViewGroup.LayoutParams layoutParams = row.getLayoutParams();
                layoutParams.height = LayoutParams.WRAP_CONTENT;
                final int[] widths = row.getColumnsWidths(widthMeasureSpec);
                final int newLength = widths.length;
                if(firstRow)                
                {
                    if(mMaxWidths == null || mMaxWidths.length != newLength)                    
                    {
                        mMaxWidths = new int[newLength];
                    } //End block
                    System.arraycopy(widths, 0, mMaxWidths, 0, newLength);
                    firstRow = false;
                } //End block
                else
                {
                    int length = mMaxWidths.length;
                    final int difference = newLength - length;
                    if(difference > 0)                    
                    {
                        final int[] oldMaxWidths = mMaxWidths;
                        mMaxWidths = new int[newLength];
                        System.arraycopy(oldMaxWidths, 0, mMaxWidths, 0,
                                oldMaxWidths.length);
                        System.arraycopy(widths, oldMaxWidths.length,
                                mMaxWidths, oldMaxWidths.length, difference);
                    } //End block
                    final int[] maxWidths = mMaxWidths;
                    length = Math.min(length, newLength);
for(int j = 0;j < length;j++)
                    {
                        maxWidths[j] = Math.max(maxWidths[j], widths[j]);
                    } //End block
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.851 -0400", hash_original_method = "FCBDEF350302C6CDE69DD815C0835AC5", hash_generated_method = "B6981A5126700C763334875D583F157C")
    private void shrinkAndStretchColumns(int widthMeasureSpec) {
        addTaint(widthMeasureSpec);
        if(mMaxWidths == null)        
        {
            return;
        } //End block
        int totalWidth = 0;
for(int width : mMaxWidths)
        {
            totalWidth += width;
        } //End block
        int size = MeasureSpec.getSize(widthMeasureSpec) - mPaddingLeft - mPaddingRight;
        if((totalWidth > size) && (mShrinkAllColumns || mShrinkableColumns.size() > 0))        
        {
            mutateColumnsWidth(mShrinkableColumns, mShrinkAllColumns, size, totalWidth);
        } //End block
        else
        if((totalWidth < size) && (mStretchAllColumns || mStretchableColumns.size() > 0))        
        {
            mutateColumnsWidth(mStretchableColumns, mStretchAllColumns, size, totalWidth);
        } //End block
        // ---------- Original Method ----------
        //if (mMaxWidths == null) {
            //return;
        //}
        //int totalWidth = 0;
        //for (int width : mMaxWidths) {
            //totalWidth += width;
        //}
        //int size = MeasureSpec.getSize(widthMeasureSpec) - mPaddingLeft - mPaddingRight;
        //if ((totalWidth > size) && (mShrinkAllColumns || mShrinkableColumns.size() > 0)) {
            //mutateColumnsWidth(mShrinkableColumns, mShrinkAllColumns, size, totalWidth);
        //} else if ((totalWidth < size) && (mStretchAllColumns || mStretchableColumns.size() > 0)) {
            //mutateColumnsWidth(mStretchableColumns, mStretchAllColumns, size, totalWidth);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.852 -0400", hash_original_method = "4E3F5E45ADBAE8A09C7C386A43B12806", hash_generated_method = "A10F330EAB269D891A99AB68E033CFA7")
    private void mutateColumnsWidth(SparseBooleanArray columns,
            boolean allColumns, int size, int totalWidth) {
        addTaint(totalWidth);
        addTaint(size);
        addTaint(allColumns);
        addTaint(columns.getTaint());
        int skipped = 0;
        final int[] maxWidths = mMaxWidths;
        final int length = maxWidths.length;
        final int count = allColumns ? length : columns.size();
        final int totalExtraSpace = size - totalWidth;
        int extraSpace = totalExtraSpace / count;
        final int nbChildren = getChildCount();
for(int i = 0;i < nbChildren;i++)
        {
            View child = getChildAt(i);
            if(child instanceof TableRow)            
            {
                child.forceLayout();
            } //End block
        } //End block
        if(!allColumns)        
        {
for(int i = 0;i < count;i++)
            {
                int column = columns.keyAt(i);
                if(columns.valueAt(i))                
                {
                    if(column < length)                    
                    {
                        maxWidths[column] += extraSpace;
                    } //End block
                    else
                    {
                        skipped++;
                    } //End block
                } //End block
            } //End block
        } //End block
        else
        {
for(int i = 0;i < count;i++)
            {
                maxWidths[i] += extraSpace;
            } //End block
            return;
        } //End block
        if(skipped > 0 && skipped < count)        
        {
            extraSpace = skipped * extraSpace / (count - skipped);
for(int i = 0;i < count;i++)
            {
                int column = columns.keyAt(i);
                if(columns.valueAt(i) && column < length)                
                {
                    if(extraSpace > maxWidths[column])                    
                    {
                        maxWidths[column] = 0;
                    } //End block
                    else
                    {
                        maxWidths[column] += extraSpace;
                    } //End block
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.853 -0400", hash_original_method = "626569BEEA8B021D33534C4E62C986DD", hash_generated_method = "45E512B1367149271261EF78E92335F0")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        addTaint(attrs.getTaint());
LayoutParams var11BFA00BA92D1E10DA9B81EE0E725A3E_975292903 =         new TableLayout.LayoutParams(getContext(), attrs);
        var11BFA00BA92D1E10DA9B81EE0E725A3E_975292903.addTaint(taint);
        return var11BFA00BA92D1E10DA9B81EE0E725A3E_975292903;
        // ---------- Original Method ----------
        //return new TableLayout.LayoutParams(getContext(), attrs);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.853 -0400", hash_original_method = "CBDF0BDAD2221E25AE8470C9AB157031", hash_generated_method = "87B3E907096E77DFA46545D1C6BC8675")
    @Override
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
LinearLayout.LayoutParams varD2F9AF19F351B83E6231407281521B68_600695731 =         new LayoutParams();
        varD2F9AF19F351B83E6231407281521B68_600695731.addTaint(taint);
        return varD2F9AF19F351B83E6231407281521B68_600695731;
        // ---------- Original Method ----------
        //return new LayoutParams();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.853 -0400", hash_original_method = "447CAFAFE5648615FE51407189D906A6", hash_generated_method = "E51EBE8C4A25B81277FF7A49E8C78C10")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var6E4F3BC50018371D484A31EBAD593BDE_1627168612 = (p instanceof TableLayout.LayoutParams);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1892538018 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1892538018;
        // ---------- Original Method ----------
        //return p instanceof TableLayout.LayoutParams;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.853 -0400", hash_original_method = "BBEB2ACD1EFF73877451077ABC9022BA", hash_generated_method = "41FFB07B4457CC4F0EED74523BAC99E5")
    @Override
    protected LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
LinearLayout.LayoutParams varB945D213E5036F8DDF9B40811234DF64_1213760773 =         new LayoutParams(p);
        varB945D213E5036F8DDF9B40811234DF64_1213760773.addTaint(taint);
        return varB945D213E5036F8DDF9B40811234DF64_1213760773;
        // ---------- Original Method ----------
        //return new LayoutParams(p);
    }

    
    public static class LayoutParams extends LinearLayout.LayoutParams {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.853 -0400", hash_original_method = "35869249D2D5BC08819A8507F87D33FD", hash_generated_method = "7441F800C0B184928DB48A9DD8178D32")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            addTaint(attrs.getTaint());
            addTaint(c.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.853 -0400", hash_original_method = "AE70A42624DF2261DCFDCEED49F51EE5", hash_generated_method = "7CC49A7D389047A4C34DC930AC835F9F")
        public  LayoutParams(int w, int h) {
            super(MATCH_PARENT, h);
            addTaint(h);
            addTaint(w);
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.853 -0400", hash_original_method = "A4AECF432693F8EEB49EF2243FEC276D", hash_generated_method = "1D9490E6AF0CA3D121AAA1B288B4C19E")
        public  LayoutParams(int w, int h, float initWeight) {
            super(MATCH_PARENT, h, initWeight);
            addTaint(initWeight);
            addTaint(h);
            addTaint(w);
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.853 -0400", hash_original_method = "23F50431F0504066EA301D42AFB8DAFD", hash_generated_method = "1B4F643A73E563320FA83E081A2953A2")
        public  LayoutParams() {
            super(MATCH_PARENT, WRAP_CONTENT);
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.854 -0400", hash_original_method = "DE4ED36682A1028E303BDCC28A48E06F", hash_generated_method = "66B55E9EFECAB48B3D28D153941B8308")
        public  LayoutParams(ViewGroup.LayoutParams p) {
            super(p);
            addTaint(p.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.854 -0400", hash_original_method = "CC87BD4B8C067788FA2BA37DBA116F62", hash_generated_method = "BDFD9CE52FB4D6304CCFF1CA731BA0A9")
        public  LayoutParams(MarginLayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.854 -0400", hash_original_method = "83FF363F248E79C3B410C30F940F0D3F", hash_generated_method = "E8A6E392DAC3EB21DC0DB7CFEF890990")
        @Override
        protected void setBaseAttributes(TypedArray a,
                int widthAttr, int heightAttr) {
            addTaint(heightAttr);
            addTaint(widthAttr);
            addTaint(a.getTaint());
            this.width = MATCH_PARENT;
            if(a.hasValue(heightAttr))            
            {
                this.height = a.getLayoutDimension(heightAttr, "layout_height");
            } //End block
            else
            {
                this.height = WRAP_CONTENT;
            } //End block
            // ---------- Original Method ----------
            //this.width = MATCH_PARENT;
            //if (a.hasValue(heightAttr)) {
                //this.height = a.getLayoutDimension(heightAttr, "layout_height");
            //} else {
                //this.height = WRAP_CONTENT;
            //}
        }

        
    }


    
    private class PassThroughHierarchyChangeListener implements OnHierarchyChangeListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.854 -0400", hash_original_field = "3F7DB39F9660F69EF1A4D273C271814A", hash_generated_field = "2D0D33391D6527FD2B9F8D3EC852AD2F")

        private OnHierarchyChangeListener mOnHierarchyChangeListener;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.854 -0400", hash_original_method = "0DD100C097C91E6D30F06426909CA640", hash_generated_method = "0DD100C097C91E6D30F06426909CA640")
        public PassThroughHierarchyChangeListener ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.854 -0400", hash_original_method = "E59BBFD5FEFAEE7E1E28F40381DEB3B0", hash_generated_method = "65283C9B9534B63C59EF2DADF48263FB")
        public void onChildViewAdded(View parent, View child) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(child.getTaint());
            addTaint(parent.getTaint());
            trackCollapsedColumns(child);
            if(mOnHierarchyChangeListener != null)            
            {
                mOnHierarchyChangeListener.onChildViewAdded(parent, child);
            } //End block
            // ---------- Original Method ----------
            //trackCollapsedColumns(child);
            //if (mOnHierarchyChangeListener != null) {
                //mOnHierarchyChangeListener.onChildViewAdded(parent, child);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.854 -0400", hash_original_method = "5A65479CCEE8BCB10036402E9895503B", hash_generated_method = "CA78721C8AF9B3AF4CF2C1764E758CB7")
        public void onChildViewRemoved(View parent, View child) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(child.getTaint());
            addTaint(parent.getTaint());
            if(mOnHierarchyChangeListener != null)            
            {
                mOnHierarchyChangeListener.onChildViewRemoved(parent, child);
            } //End block
            // ---------- Original Method ----------
            //if (mOnHierarchyChangeListener != null) {
                //mOnHierarchyChangeListener.onChildViewRemoved(parent, child);
            //}
        }

        
    }


    
}

