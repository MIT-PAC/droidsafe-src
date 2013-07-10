package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.regex.Pattern;

public class TableLayout extends LinearLayout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.338 -0400", hash_original_field = "A8AFB75CC2C31DA9076A61554C230A06", hash_generated_field = "2F4A0135686BA0EF51C1B28313E81C22")

    private int[] mMaxWidths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.338 -0400", hash_original_field = "521DB786EE42107EF3865601DAFABD19", hash_generated_field = "237BCAE2DDAA5809B4CBC18C28CE9641")

    private SparseBooleanArray mStretchableColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.338 -0400", hash_original_field = "F49C7472F992C1A8053C750548CB9F83", hash_generated_field = "54FA12C85C12CB357EAE91A430CC8F14")

    private SparseBooleanArray mShrinkableColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.338 -0400", hash_original_field = "5B013A5EBB7986AB2674828E37B9F8F3", hash_generated_field = "983852F7982125991CFDF43A53958BB8")

    private SparseBooleanArray mCollapsedColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.338 -0400", hash_original_field = "E0A33CC4BFDD5832E9B9D799326C02FD", hash_generated_field = "8EDC18A923C7B9030A0D0EA6C921EA5B")

    private boolean mShrinkAllColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.338 -0400", hash_original_field = "005C7B7FE42AD00688D78F9B78798C32", hash_generated_field = "2727CBE2D69E3A21A8D531AB6996F6A8")

    private boolean mStretchAllColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.338 -0400", hash_original_field = "49134BEE5179245030E696FDD8403D38", hash_generated_field = "CB216867A328EE0A793FB91163122291")

    private TableLayout.PassThroughHierarchyChangeListener mPassThroughListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.338 -0400", hash_original_field = "57006E58594DC862E67D1855FDF16FEE", hash_generated_field = "11DCD11B6A2634BB183BD4F1FB332620")

    private boolean mInitialized;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.338 -0400", hash_original_method = "2DBA50ED74E78B2838BC7527149D5669", hash_generated_method = "31F0D0A5A7F756180F1F28D054712349")
    public  TableLayout(Context context) {
        super(context);
        initTableLayout();
        addTaint(context.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.339 -0400", hash_original_method = "959C37211929CCCB2D56BECF55A0682A", hash_generated_method = "5F2BA2AD4D8793B9E0A161E344F9F7F4")
    public  TableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TableLayout);
        String stretchedColumns = a.getString(R.styleable.TableLayout_stretchColumns);
        {
            {
                boolean varB176ABFFBF21920A4D8B15966301C3BE_1449939822 = (stretchedColumns.charAt(0) == '*');
                {
                    mStretchAllColumns = true;
                } 
                {
                    mStretchableColumns = parseColumns(stretchedColumns);
                } 
            } 
        } 
        String shrinkedColumns = a.getString(R.styleable.TableLayout_shrinkColumns);
        {
            {
                boolean var0E6EE1CC361D4BD2B7D9111215F4A1B3_1454900787 = (shrinkedColumns.charAt(0) == '*');
                {
                    mShrinkAllColumns = true;
                } 
                {
                    mShrinkableColumns = parseColumns(shrinkedColumns);
                } 
            } 
        } 
        String collapsedColumns = a.getString(R.styleable.TableLayout_collapseColumns);
        {
            mCollapsedColumns = parseColumns(collapsedColumns);
        } 
        a.recycle();
        initTableLayout();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.340 -0400", hash_original_method = "B376012DF0DA3032DA90C2CCE23CE9AB", hash_generated_method = "77E4ABAAD23D8691E9ACF04DF222796F")
    private void initTableLayout() {
        {
            mCollapsedColumns = new SparseBooleanArray();
        } 
        {
            mStretchableColumns = new SparseBooleanArray();
        } 
        {
            mShrinkableColumns = new SparseBooleanArray();
        } 
        mPassThroughListener = new PassThroughHierarchyChangeListener();
        super.setOnHierarchyChangeListener(mPassThroughListener);
        mInitialized = true;
        
        
            
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.340 -0400", hash_original_method = "E023B2331F5B7D82E6BF896494CABA17", hash_generated_method = "7FA4E96971EEFFA6A54848F49887181B")
    @Override
    public void setOnHierarchyChangeListener(
            OnHierarchyChangeListener listener) {
        mPassThroughListener.mOnHierarchyChangeListener = listener;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.341 -0400", hash_original_method = "46F66A2D3F5735AEA41A7DB58B431E82", hash_generated_method = "6B0A191F09596B6D8FA2A849489B1510")
    private void requestRowsLayout() {
        {
            final int count = getChildCount();
            {
                int i = 0;
                {
                    getChildAt(i).requestLayout();
                } 
            } 
        } 
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.342 -0400", hash_original_method = "EAC930A18C6CF1CADFC926F8862188F3", hash_generated_method = "6445A737E5F7567A59F28EF715D3C88A")
    @Override
    public void requestLayout() {
        {
            int count = getChildCount();
            {
                int i = 0;
                {
                    getChildAt(i).forceLayout();
                } 
            } 
        } 
        super.requestLayout();
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.342 -0400", hash_original_method = "624BF5A05D2AD2F91E52D17C6AFF6DC5", hash_generated_method = "570AC9C35E94372F0808BA0A7B5FE369")
    public boolean isShrinkAllColumns() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_883306531 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_883306531;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.342 -0400", hash_original_method = "26E4ADFC91B374A7FF7EFE7A14E44F9B", hash_generated_method = "BBE5382EC77465A31A4447AFE719DE61")
    public void setShrinkAllColumns(boolean shrinkAllColumns) {
        mShrinkAllColumns = shrinkAllColumns;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.343 -0400", hash_original_method = "C0959877EF2F1B6CBC27D41EECDAD445", hash_generated_method = "468FC8E3778731DDBC766772352FD700")
    public boolean isStretchAllColumns() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_198978969 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_198978969;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.343 -0400", hash_original_method = "276589380DE193D6AFC8DA7EB773135F", hash_generated_method = "61A303E8046B3D7315D7C10E5A2B80A2")
    public void setStretchAllColumns(boolean stretchAllColumns) {
        mStretchAllColumns = stretchAllColumns;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.343 -0400", hash_original_method = "829331550E99E48511938200E10E0516", hash_generated_method = "2C7E06082F1051A425828BD8319AEB35")
    public void setColumnCollapsed(int columnIndex, boolean isCollapsed) {
        mCollapsedColumns.put(columnIndex, isCollapsed);
        int count = getChildCount();
        {
            int i = 0;
            {
                final View view = getChildAt(i);
                {
                    ((TableRow) view).setColumnCollapsed(columnIndex, isCollapsed);
                } 
            } 
        } 
        requestRowsLayout();
        addTaint(columnIndex);
        addTaint(isCollapsed);
        
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.344 -0400", hash_original_method = "19A6345BB30DA1B94EF425A139EBF7B6", hash_generated_method = "70EB73A15A71AC4A2AC29B6B2F81DFE1")
    public boolean isColumnCollapsed(int columnIndex) {
        boolean var5B3CF7B89FB5E14EA0ABA2D9C40D647F_1505589228 = (mCollapsedColumns.get(columnIndex));
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_328621037 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_328621037;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.344 -0400", hash_original_method = "62253048F5CA87D307E8714AA1DE21F0", hash_generated_method = "BD77A67091F784EED9181F35687EE497")
    public void setColumnStretchable(int columnIndex, boolean isStretchable) {
        mStretchableColumns.put(columnIndex, isStretchable);
        requestRowsLayout();
        addTaint(columnIndex);
        addTaint(isStretchable);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.344 -0400", hash_original_method = "32065C4976C924BEAD40EDE2A514E0EE", hash_generated_method = "5E7953E21CCE3E409EB3ADCD0EA2D01B")
    public boolean isColumnStretchable(int columnIndex) {
        boolean var28D5058AE595AD2E708DC40BDF8AE839_353945752 = (mStretchAllColumns || mStretchableColumns.get(columnIndex));
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1462439985 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1462439985;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.345 -0400", hash_original_method = "3624AF127452F84D2332BE1546302CDA", hash_generated_method = "F60AA88A18324482BF3CEB90AD4B476D")
    public void setColumnShrinkable(int columnIndex, boolean isShrinkable) {
        mShrinkableColumns.put(columnIndex, isShrinkable);
        requestRowsLayout();
        addTaint(columnIndex);
        addTaint(isShrinkable);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.345 -0400", hash_original_method = "AE299BD43225B57B8AC568426E8DCDB2", hash_generated_method = "8875E214D228C760F0DF6D1BE96D230E")
    public boolean isColumnShrinkable(int columnIndex) {
        boolean var1CB94FD8CA80B427A32C9B571E46DC35_1510020953 = (mShrinkAllColumns || mShrinkableColumns.get(columnIndex));
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1409243359 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1409243359;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.345 -0400", hash_original_method = "1A7EBA0F6B48090D166288951056A8A7", hash_generated_method = "31B18BA36738064E2C029A4AEBF3FAC0")
    private void trackCollapsedColumns(View child) {
        {
            final TableRow row = (TableRow) child;
            final SparseBooleanArray collapsedColumns = mCollapsedColumns;
            final int count = collapsedColumns.size();
            {
                int i = 0;
                {
                    int columnIndex = collapsedColumns.keyAt(i);
                    boolean isCollapsed = collapsedColumns.valueAt(i);
                    {
                        row.setColumnCollapsed(columnIndex, isCollapsed);
                    } 
                } 
            } 
        } 
        addTaint(child.getTaint());
        
        
            
            
            
            
                
                
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.346 -0400", hash_original_method = "13A96A4A6DDFEE3010E840F1100E091C", hash_generated_method = "F42B9F85D301C0C77CC74F745A848E7B")
    @Override
    public void addView(View child) {
        super.addView(child);
        requestRowsLayout();
        addTaint(child.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.346 -0400", hash_original_method = "0A8A998DCFADFBF06AD3633B7F78F767", hash_generated_method = "D8AB88AAB87380BBF6914CED596E28F4")
    @Override
    public void addView(View child, int index) {
        super.addView(child, index);
        requestRowsLayout();
        addTaint(child.getTaint());
        addTaint(index);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.346 -0400", hash_original_method = "F2FDB0BFA45548A61FACB12C8E83D6F6", hash_generated_method = "1238B86F10570C87B09A6A2E90808E3B")
    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        super.addView(child, params);
        requestRowsLayout();
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.346 -0400", hash_original_method = "205DAA16DEE6F9CF58403F7DCF1DA0C1", hash_generated_method = "AEE513F37F92844E500A8C20A9744A56")
    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        requestRowsLayout();
        addTaint(child.getTaint());
        addTaint(index);
        addTaint(params.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.347 -0400", hash_original_method = "8CCC700F8795467ABA2DD388545C44C0", hash_generated_method = "8A19ADD8BC4AA0B21545C4A83D3A2EC7")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        measureVertical(widthMeasureSpec, heightMeasureSpec);
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.347 -0400", hash_original_method = "47158FF62F96A7883F43DCCED676A47B", hash_generated_method = "7ABE54E3EE6D4D723006CCE90CECE530")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        
        layoutVertical();
        addTaint(changed);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.347 -0400", hash_original_method = "D260EEF009252A9802D5F41574FD2463", hash_generated_method = "0542AA7C82668433E512CDC347308666")
    @Override
     void measureChildBeforeLayout(View child, int childIndex,
            int widthMeasureSpec, int totalWidth,
            int heightMeasureSpec, int totalHeight) {
        {
            ((TableRow) child).setColumnsWidthConstraints(mMaxWidths);
        } 
        super.measureChildBeforeLayout(child, childIndex,
                widthMeasureSpec, totalWidth, heightMeasureSpec, totalHeight);
        addTaint(child.getTaint());
        addTaint(childIndex);
        addTaint(widthMeasureSpec);
        addTaint(totalWidth);
        addTaint(heightMeasureSpec);
        addTaint(totalHeight);
        
        
            
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.347 -0400", hash_original_method = "A49B05A52F9F2AD597034B1B66F4E4A9", hash_generated_method = "93C883A795A1E34F80FB577EFD9C55C7")
    @Override
     void measureVertical(int widthMeasureSpec, int heightMeasureSpec) {
        findLargestCells(widthMeasureSpec);
        shrinkAndStretchColumns(widthMeasureSpec);
        super.measureVertical(widthMeasureSpec, heightMeasureSpec);
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.348 -0400", hash_original_method = "4DFA55B8EC4F00C998EFCF5CE369887F", hash_generated_method = "E561FF052BBFF8D0B458B7F474AF5523")
    private void findLargestCells(int widthMeasureSpec) {
        boolean firstRow = true;
        final int count = getChildCount();
        {
            int i = 0;
            {
                final View child = getChildAt(i);
                {
                    boolean varE5A6421440835A22FD9C00B75E3D1565_1309685965 = (child.getVisibility() == GONE);
                } 
                {
                    final TableRow row = (TableRow) child;
                    final ViewGroup.LayoutParams layoutParams = row.getLayoutParams();
                    layoutParams.height = LayoutParams.WRAP_CONTENT;
                    final int[] widths = row.getColumnsWidths(widthMeasureSpec);
                    final int newLength = widths.length;
                    {
                        {
                            mMaxWidths = new int[newLength];
                        } 
                        System.arraycopy(widths, 0, mMaxWidths, 0, newLength);
                        firstRow = false;
                    } 
                    {
                        int length = mMaxWidths.length;
                        final int difference = newLength - length;
                        {
                            final int[] oldMaxWidths = mMaxWidths;
                            mMaxWidths = new int[newLength];
                            System.arraycopy(oldMaxWidths, 0, mMaxWidths, 0,
                                oldMaxWidths.length);
                            System.arraycopy(widths, oldMaxWidths.length,
                                mMaxWidths, oldMaxWidths.length, difference);
                        } 
                        final int[] maxWidths = mMaxWidths;
                        length = Math.min(length, newLength);
                        {
                            int j = 0;
                            {
                                maxWidths[j] = Math.max(maxWidths[j], widths[j]);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(widthMeasureSpec);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.381 -0400", hash_original_method = "FCBDEF350302C6CDE69DD815C0835AC5", hash_generated_method = "2F39B2DDEBECF21ED08A4A2AD6821417")
    private void shrinkAndStretchColumns(int widthMeasureSpec) {
        int totalWidth = 0;
        {
            int width = mMaxWidths[0];
            {
                totalWidth += width;
            } 
        } 
        int size = MeasureSpec.getSize(widthMeasureSpec) - mPaddingLeft - mPaddingRight;
        {
            boolean var818341EE6856AF9674D6D56647293CC2_1026209090 = ((totalWidth > size) && (mShrinkAllColumns || mShrinkableColumns.size() > 0));
            {
                mutateColumnsWidth(mShrinkableColumns, mShrinkAllColumns, size, totalWidth);
            } 
            {
                boolean varA576938F9A9A720169C88FACAE35DFB7_1083781938 = ((totalWidth < size) && (mStretchAllColumns || mStretchableColumns.size() > 0));
                {
                    mutateColumnsWidth(mStretchableColumns, mStretchAllColumns, size, totalWidth);
                } 
            } 
        } 
        addTaint(widthMeasureSpec);
        
        
            
        
        
        
            
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.382 -0400", hash_original_method = "4E3F5E45ADBAE8A09C7C386A43B12806", hash_generated_method = "B017194E28841CEE60DEB38994394665")
    private void mutateColumnsWidth(SparseBooleanArray columns,
            boolean allColumns, int size, int totalWidth) {
        int skipped = 0;
        final int[] maxWidths = mMaxWidths;
        final int length = maxWidths.length;
        int count;
        count = length;
        count = columns.size();
        final int totalExtraSpace = size - totalWidth;
        int extraSpace = totalExtraSpace / count;
        final int nbChildren = getChildCount();
        {
            int i = 0;
            {
                View child = getChildAt(i);
                {
                    child.forceLayout();
                } 
            } 
        } 
        {
            {
                int i = 0;
                {
                    int column = columns.keyAt(i);
                    {
                        boolean var36D4BDFC34CE6C9BF9EBBDA47C462BF6_1406516370 = (columns.valueAt(i));
                        {
                            {
                                maxWidths[column] += extraSpace;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            {
                int i = 0;
                {
                    maxWidths[i] += extraSpace;
                } 
            } 
        } 
        {
            extraSpace = skipped * extraSpace / (count - skipped);
            {
                int i = 0;
                {
                    int column = columns.keyAt(i);
                    {
                        boolean var48D19104EF598D232CEEE99C0F20B1CA_94358942 = (columns.valueAt(i) && column < length);
                        {
                            {
                                maxWidths[column] = 0;
                            } 
                            {
                                maxWidths[column] += extraSpace;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(columns.getTaint());
        addTaint(allColumns);
        addTaint(size);
        addTaint(totalWidth);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.382 -0400", hash_original_method = "626569BEEA8B021D33534C4E62C986DD", hash_generated_method = "31E675B5B884941CFB3C6AAE4E2B4C0F")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1550679133 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1550679133 = new TableLayout.LayoutParams(getContext(), attrs);
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1550679133.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1550679133;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.383 -0400", hash_original_method = "CBDF0BDAD2221E25AE8470C9AB157031", hash_generated_method = "395BADD553637F004DB6459D0E85F6A3")
    @Override
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        LinearLayout.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1862490460 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1862490460 = new LayoutParams();
        varB4EAC82CA7396A68D541C85D26508E83_1862490460.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1862490460;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.383 -0400", hash_original_method = "447CAFAFE5648615FE51407189D906A6", hash_generated_method = "AC9F2A198852BB33E580C798DE7EFF78")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_451326298 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_451326298;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.384 -0400", hash_original_method = "BBEB2ACD1EFF73877451077ABC9022BA", hash_generated_method = "DB2D4ECDD26A5BCD21A98EB6FA7C3B72")
    @Override
    protected LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        LinearLayout.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_2003156390 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2003156390 = new LayoutParams(p);
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2003156390.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2003156390;
        
        
    }

    
    public static class LayoutParams extends LinearLayout.LayoutParams {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.384 -0400", hash_original_method = "35869249D2D5BC08819A8507F87D33FD", hash_generated_method = "0DBD7DD67030DB53521B4CBB550D5399")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            addTaint(c.getTaint());
            addTaint(attrs.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.385 -0400", hash_original_method = "AE70A42624DF2261DCFDCEED49F51EE5", hash_generated_method = "70FCE609BE73514956CEB2850B5857AD")
        public  LayoutParams(int w, int h) {
            super(MATCH_PARENT, h);
            addTaint(w);
            addTaint(h);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.385 -0400", hash_original_method = "A4AECF432693F8EEB49EF2243FEC276D", hash_generated_method = "28F35C515000A0FB2915F8133E930EAB")
        public  LayoutParams(int w, int h, float initWeight) {
            super(MATCH_PARENT, h, initWeight);
            addTaint(w);
            addTaint(h);
            addTaint(initWeight);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.385 -0400", hash_original_method = "23F50431F0504066EA301D42AFB8DAFD", hash_generated_method = "1B4F643A73E563320FA83E081A2953A2")
        public  LayoutParams() {
            super(MATCH_PARENT, WRAP_CONTENT);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.386 -0400", hash_original_method = "DE4ED36682A1028E303BDCC28A48E06F", hash_generated_method = "66B55E9EFECAB48B3D28D153941B8308")
        public  LayoutParams(ViewGroup.LayoutParams p) {
            super(p);
            addTaint(p.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.386 -0400", hash_original_method = "CC87BD4B8C067788FA2BA37DBA116F62", hash_generated_method = "BDFD9CE52FB4D6304CCFF1CA731BA0A9")
        public  LayoutParams(MarginLayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.386 -0400", hash_original_method = "83FF363F248E79C3B410C30F940F0D3F", hash_generated_method = "FA2AE0DE200642279F409103E490CADD")
        @Override
        protected void setBaseAttributes(TypedArray a,
                int widthAttr, int heightAttr) {
            this.width = MATCH_PARENT;
            {
                boolean var85D47280CE4096165FCC5973CDFD8001_1090188547 = (a.hasValue(heightAttr));
                {
                    this.height = a.getLayoutDimension(heightAttr, "layout_height");
                } 
                {
                    this.height = WRAP_CONTENT;
                } 
            } 
            addTaint(a.getTaint());
            addTaint(widthAttr);
            addTaint(heightAttr);
            
            
            
                
            
                
            
        }

        
    }


    
    private class PassThroughHierarchyChangeListener implements OnHierarchyChangeListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.386 -0400", hash_original_field = "3F7DB39F9660F69EF1A4D273C271814A", hash_generated_field = "2D0D33391D6527FD2B9F8D3EC852AD2F")

        private OnHierarchyChangeListener mOnHierarchyChangeListener;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.386 -0400", hash_original_method = "0DD100C097C91E6D30F06426909CA640", hash_generated_method = "0DD100C097C91E6D30F06426909CA640")
        public PassThroughHierarchyChangeListener ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.387 -0400", hash_original_method = "E59BBFD5FEFAEE7E1E28F40381DEB3B0", hash_generated_method = "0B741080D9B194D4C8A458535AC9DCD5")
        public void onChildViewAdded(View parent, View child) {
            
            trackCollapsedColumns(child);
            {
                mOnHierarchyChangeListener.onChildViewAdded(parent, child);
            } 
            addTaint(parent.getTaint());
            addTaint(child.getTaint());
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.387 -0400", hash_original_method = "5A65479CCEE8BCB10036402E9895503B", hash_generated_method = "FB95CD600769EE09DC34438692629F90")
        public void onChildViewRemoved(View parent, View child) {
            
            {
                mOnHierarchyChangeListener.onChildViewRemoved(parent, child);
            } 
            addTaint(parent.getTaint());
            addTaint(child.getTaint());
            
            
                
            
        }

        
    }


    
}

