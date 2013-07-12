package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;

public class TableRow extends LinearLayout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.343 -0400", hash_original_field = "94828D8F312B8AB3147B78D966A52731", hash_generated_field = "D9A8A35CE61AAB048FD0AED37F8CBEEB")

    private int mNumColumns = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.344 -0400", hash_original_field = "9316A0817013F43BA563EE0E12FD9D08", hash_generated_field = "15FCA76D9E6B49D35CF288E17BA4DB1D")

    private int[] mColumnWidths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.344 -0400", hash_original_field = "DF3FD1A34FB8980B312F9E011F58EFB5", hash_generated_field = "3C7C52F68E94A8B9B94FB48FC8D2BFE4")

    private int[] mConstrainedColumnWidths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.344 -0400", hash_original_field = "0930D04987F4641671E3845A4431884D", hash_generated_field = "7C85DDE3B4F4B337F894C4208AF1B531")

    private SparseIntArray mColumnToChildIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.344 -0400", hash_original_field = "65AE90ABA3B21B887FD16B92A7395024", hash_generated_field = "3A88AE8C6C11D29E8EFD9BC29F67E7FE")

    private ChildrenTracker mChildrenTracker;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.344 -0400", hash_original_method = "F9A2694D9D8F1C73F4893642416A48B8", hash_generated_method = "56E83A0AC3E18FB0002889A30674203E")
    public  TableRow(Context context) {
        super(context);
        addTaint(context.getTaint());
        initTableRow();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.344 -0400", hash_original_method = "BE346953D196911D47A80804A6B74A8F", hash_generated_method = "300220A05422A3E34C81A971B838F7C2")
    public  TableRow(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        initTableRow();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.344 -0400", hash_original_method = "B661864F11557636EAA2570C7969C441", hash_generated_method = "E395E78C0A9DF3EE12C41B6902B70F99")
    private void initTableRow() {
        OnHierarchyChangeListener oldListener = mOnHierarchyChangeListener;
        mChildrenTracker = new ChildrenTracker();
    if(oldListener != null)        
        {
            mChildrenTracker.setOnHierarchyChangeListener(oldListener);
        } 
        super.setOnHierarchyChangeListener(mChildrenTracker);
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.344 -0400", hash_original_method = "F95EB07610207091F5D59E2132ED055F", hash_generated_method = "A6C34719D5BC5EAEF3D35F33F4D66EAC")
    @Override
    public void setOnHierarchyChangeListener(OnHierarchyChangeListener listener) {
        addTaint(listener.getTaint());
        mChildrenTracker.setOnHierarchyChangeListener(listener);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.345 -0400", hash_original_method = "2321E3900029B8CC8621E7719358502D", hash_generated_method = "B21CC0B2CFDC5618A00642534AB09F2F")
     void setColumnCollapsed(int columnIndex, boolean collapsed) {
        addTaint(collapsed);
        addTaint(columnIndex);
        View child = getVirtualChildAt(columnIndex);
    if(child != null)        
        {
            child.setVisibility(collapsed ? GONE : VISIBLE);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.345 -0400", hash_original_method = "F6BA9F18146785AE4528780F68777354", hash_generated_method = "E873D5CDA21214690D9D00F575343D1B")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        measureHorizontal(widthMeasureSpec, heightMeasureSpec);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.345 -0400", hash_original_method = "614377E7AFFD7D8A3CEA03D0F029C6C2", hash_generated_method = "3D356C9BB5909431B068992549D273BE")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        addTaint(changed);
        layoutHorizontal();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.345 -0400", hash_original_method = "76BF09C7D97AC336E0857E346F87F26E", hash_generated_method = "44D6CB5C027CCD0E28F2FC0BEF7237E5")
    @Override
    public View getVirtualChildAt(int i) {
        addTaint(i);
    if(mColumnToChildIndex == null)        
        {
            mapIndexAndColumns();
        } 
        final int deflectedIndex = mColumnToChildIndex.get(i, -1);
    if(deflectedIndex != -1)        
        {
View var4169DFF32EA76A9C794E924781F6B8E4_779920261 =             getChildAt(deflectedIndex);
            var4169DFF32EA76A9C794E924781F6B8E4_779920261.addTaint(taint);
            return var4169DFF32EA76A9C794E924781F6B8E4_779920261;
        } 
View var540C13E9E156B687226421B24F2DF178_1181699752 =         null;
        var540C13E9E156B687226421B24F2DF178_1181699752.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1181699752;
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.345 -0400", hash_original_method = "C68DDC21BA155D9A2863642050B804BE", hash_generated_method = "3E958D2D352AA64E6944E93480B1E2C5")
    @Override
    public int getVirtualChildCount() {
    if(mColumnToChildIndex == null)        
        {
            mapIndexAndColumns();
        } 
        int var3C11F31A23C7905177BA6A1A74A63160_1008800948 = (mNumColumns);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814026269 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814026269;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.346 -0400", hash_original_method = "4E55577CF2059CB35F704B8E869B19CD", hash_generated_method = "DFBA4D5337AB401D5827AF7467BF4E0D")
    private void mapIndexAndColumns() {
    if(mColumnToChildIndex == null)        
        {
            int virtualCount = 0;
            final int count = getChildCount();
            mColumnToChildIndex = new SparseIntArray();
            final SparseIntArray columnToChild = mColumnToChildIndex;
for(int i = 0;i < count;i++)
            {
                final View child = getChildAt(i);
                final LayoutParams layoutParams = (LayoutParams) child.getLayoutParams();
    if(layoutParams.column >= virtualCount)                
                {
                    virtualCount = layoutParams.column;
                } 
for(int j = 0;j < layoutParams.span;j++)
                {
                    columnToChild.put(virtualCount++, i);
                } 
            } 
            mNumColumns = virtualCount;
        } 
        
        
            
            
            
            
            
                
                
                
                    
                
                
                    
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.346 -0400", hash_original_method = "6310895A2EAB860DC48C590959484D6D", hash_generated_method = "A640D73C4AADBBA3610F14312096D66C")
    @Override
     int measureNullChild(int childIndex) {
        addTaint(childIndex);
        int var27FBE0011EFE58A7C993DF93EA8AC1BF_927561555 = (mConstrainedColumnWidths[childIndex]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1465284217 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1465284217;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.346 -0400", hash_original_method = "21A01BD04BAB3B03D9551E5E2A120920", hash_generated_method = "110EA9D6EC4639B514D43A7A10FDFC0E")
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
    if(mConstrainedColumnWidths != null)        
        {
            final LayoutParams lp = (LayoutParams) child.getLayoutParams();
            int measureMode = MeasureSpec.EXACTLY;
            int columnWidth = 0;
            final int span = lp.span;
            final int[] constrainedColumnWidths = mConstrainedColumnWidths;
for(int i = 0;i < span;i++)
            {
                columnWidth += constrainedColumnWidths[childIndex + i];
            } 
            final int gravity = lp.gravity;
            final boolean isHorizontalGravity = Gravity.isHorizontal(gravity);
    if(isHorizontalGravity)            
            {
                measureMode = MeasureSpec.AT_MOST;
            } 
            int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(
                    Math.max(0, columnWidth - lp.leftMargin - lp.rightMargin), measureMode
            );
            int childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec,
                    mPaddingTop + mPaddingBottom + lp.topMargin +
                    lp .bottomMargin + totalHeight, lp.height);
            child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    if(isHorizontalGravity)            
            {
                final int childWidth = child.getMeasuredWidth();
                lp.mOffset[LayoutParams.LOCATION_NEXT] = columnWidth - childWidth;
                final int layoutDirection = getResolvedLayoutDirection();
                final int absoluteGravity = Gravity.getAbsoluteGravity(gravity, layoutDirection);
switch(absoluteGravity & Gravity.HORIZONTAL_GRAVITY_MASK){
                case Gravity.LEFT:
                break;
                case Gravity.RIGHT:
                lp.mOffset[LayoutParams.LOCATION] = lp.mOffset[LayoutParams.LOCATION_NEXT];
                break;
                case Gravity.CENTER_HORIZONTAL:
                lp.mOffset[LayoutParams.LOCATION] = lp.mOffset[LayoutParams.LOCATION_NEXT] / 2;
                break;
}
            } 
            else
            {
                lp.mOffset[LayoutParams.LOCATION] = lp.mOffset[LayoutParams.LOCATION_NEXT] = 0;
            } 
        } 
        else
        {
            super.measureChildBeforeLayout(child, childIndex, widthMeasureSpec,
                    totalWidth, heightMeasureSpec, totalHeight);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.347 -0400", hash_original_method = "B06729C46F9CA4132172A65B967C7D51", hash_generated_method = "E236757DFD41BF86224E5EC9655E19D8")
    @Override
     int getChildrenSkipCount(View child, int index) {
        addTaint(index);
        addTaint(child.getTaint());
        LayoutParams layoutParams = (LayoutParams) child.getLayoutParams();
        int varDA5A03E93ED67A67655F7085ABD4725C_707922925 = (layoutParams.span - 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620279802 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620279802;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.347 -0400", hash_original_method = "B1A714BE7A14CFDA42294606652D195E", hash_generated_method = "1C52A847D638648673CE1D5B816D28A2")
    @Override
     int getLocationOffset(View child) {
        addTaint(child.getTaint());
        int var1783968F6D1F7FD61F60505469135792_730064092 = (((TableRow.LayoutParams) child.getLayoutParams()).mOffset[LayoutParams.LOCATION]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628802623 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628802623;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.347 -0400", hash_original_method = "6629CED69C690D63986C2D59A68F69D3", hash_generated_method = "1716248069933A3F2A6BD150DD191B44")
    @Override
     int getNextLocationOffset(View child) {
        addTaint(child.getTaint());
        int var7246F5A526F0DF57613899B97498279B_466749635 = (((TableRow.LayoutParams) child.getLayoutParams()).mOffset[LayoutParams.LOCATION_NEXT]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915091744 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915091744;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.348 -0400", hash_original_method = "F97D9B3BAD7BE3BFEC03988909D08EE2", hash_generated_method = "C20DD26533D669D79168F2DEC5D5E362")
     int[] getColumnsWidths(int widthMeasureSpec) {
        addTaint(widthMeasureSpec);
        final int numColumns = getVirtualChildCount();
    if(mColumnWidths == null || numColumns != mColumnWidths.length)        
        {
            mColumnWidths = new int[numColumns];
        } 
        final int[] columnWidths = mColumnWidths;
for(int i = 0;i < numColumns;i++)
        {
            final View child = getVirtualChildAt(i);
    if(child != null && child.getVisibility() != GONE)            
            {
                final LayoutParams layoutParams = (LayoutParams) child.getLayoutParams();
    if(layoutParams.span == 1)                
                {
                    int spec;
switch(layoutParams.width){
                    case LayoutParams.WRAP_CONTENT:
                    spec = getChildMeasureSpec(widthMeasureSpec, 0, LayoutParams.WRAP_CONTENT);
                    break;
                    case LayoutParams.MATCH_PARENT:
                    spec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                    break;
                    default:
                    spec = MeasureSpec.makeMeasureSpec(layoutParams.width, MeasureSpec.EXACTLY);
}                    child.measure(spec, spec);
                    final int width = child.getMeasuredWidth() + layoutParams.leftMargin +
                            layoutParams.rightMargin;
                    columnWidths[i] = width;
                } 
                else
                {
                    columnWidths[i] = 0;
                } 
            } 
            else
            {
                columnWidths[i] = 0;
            } 
        } 
        int[] var7F829D74FAC5DE404C91BC4F3B85E14D_1274139009 = (columnWidths);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1613008776 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1613008776;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.348 -0400", hash_original_method = "00077407B55623ED0FDC934F0F688424", hash_generated_method = "4C35D2EBA2196AB6F660AF9CBEADA0D2")
     void setColumnsWidthConstraints(int[] columnWidths) {
    if(columnWidths == null || columnWidths.length < getVirtualChildCount())        
        {
            IllegalArgumentException var66DE3BC5E5691A4C62E16C87F449E46A_1176827907 = new IllegalArgumentException(
                    "columnWidths should be >= getVirtualChildCount()");
            var66DE3BC5E5691A4C62E16C87F449E46A_1176827907.addTaint(taint);
            throw var66DE3BC5E5691A4C62E16C87F449E46A_1176827907;
        } 
        mConstrainedColumnWidths = columnWidths;
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.348 -0400", hash_original_method = "52AE7360396A37641601CBCD86366395", hash_generated_method = "721C831775E54499B7C22B41DF39097B")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        addTaint(attrs.getTaint());
LayoutParams varC7625554D74072815E6357FFCA5F5213_863925541 =         new TableRow.LayoutParams(getContext(), attrs);
        varC7625554D74072815E6357FFCA5F5213_863925541.addTaint(taint);
        return varC7625554D74072815E6357FFCA5F5213_863925541;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.349 -0400", hash_original_method = "CBDF0BDAD2221E25AE8470C9AB157031", hash_generated_method = "06735128E11003C940EC02324BEE20B3")
    @Override
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
LinearLayout.LayoutParams varD2F9AF19F351B83E6231407281521B68_1667425930 =         new LayoutParams();
        varD2F9AF19F351B83E6231407281521B68_1667425930.addTaint(taint);
        return varD2F9AF19F351B83E6231407281521B68_1667425930;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.349 -0400", hash_original_method = "22EE87D9951BB7D40E63D16DD0B3F806", hash_generated_method = "F12155BA7864116F15BE5FBD44BB1FAA")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var182BC791CB407763FCD0616111E20647_1104751601 = (p instanceof TableRow.LayoutParams);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1559599566 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1559599566;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.349 -0400", hash_original_method = "BBEB2ACD1EFF73877451077ABC9022BA", hash_generated_method = "3229DA80653E00B3F89737C04D95F644")
    @Override
    protected LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
LinearLayout.LayoutParams varB945D213E5036F8DDF9B40811234DF64_1471002983 =         new LayoutParams(p);
        varB945D213E5036F8DDF9B40811234DF64_1471002983.addTaint(taint);
        return varB945D213E5036F8DDF9B40811234DF64_1471002983;
        
        
    }

    
    public static class LayoutParams extends LinearLayout.LayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.349 -0400", hash_original_field = "1AFD32818D1C9525F82AFF4C09EFD254", hash_generated_field = "880EADDB8CAD6645D1A649B4C5BDBB5F")

        @ViewDebug.ExportedProperty(category = "layout") public int column;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.349 -0400", hash_original_field = "EAC828E40705BFAFD82EF1A82E3F5AB8", hash_generated_field = "1D587A55F3FA8CB1DFEEF6D53CE06BC2")

        @ViewDebug.ExportedProperty(category = "layout") public int span;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.349 -0400", hash_original_field = "76EC118A138E169402F72BBF83D9D2B2", hash_generated_field = "3B010DF7096DEB2A022337BFA1B1C1A7")

        private int[] mOffset = new int[2];
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.349 -0400", hash_original_method = "E5D3961F929E7A203A8A944132C09ABE", hash_generated_method = "CF6C057A83F5634145A489ADB453A357")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            addTaint(attrs.getTaint());
            addTaint(c.getTaint());
            TypedArray a = c.obtainStyledAttributes(attrs,
                            com.android.internal.R.styleable.TableRow_Cell);
            column = a.getInt(com.android.internal.R.styleable.TableRow_Cell_layout_column, -1);
            span = a.getInt(com.android.internal.R.styleable.TableRow_Cell_layout_span, 1);
    if(span <= 1)            
            {
                span = 1;
            } 
            a.recycle();
            
            
                    
                            
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.349 -0400", hash_original_method = "DCEE7ED44A87D406D3E35C60D8DCDFD7", hash_generated_method = "20E69B8E97D2E3A992939C41052C5AD2")
        public  LayoutParams(int w, int h) {
            super(w, h);
            addTaint(h);
            addTaint(w);
            column = -1;
            span = 1;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.349 -0400", hash_original_method = "AC2D690BD2E1EA15E67B11BD37629B19", hash_generated_method = "DE0E4C500DE374E598A108BDABC2FE3D")
        public  LayoutParams(int w, int h, float initWeight) {
            super(w, h, initWeight);
            addTaint(initWeight);
            addTaint(h);
            addTaint(w);
            column = -1;
            span = 1;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.350 -0400", hash_original_method = "5AA50E380D57ACDFC498CDB1B1E9AFBA", hash_generated_method = "D51E0843B736F81679DA6F5102944259")
        public  LayoutParams() {
            super(MATCH_PARENT, WRAP_CONTENT);
            column = -1;
            span = 1;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.350 -0400", hash_original_method = "151219291568C02E222942C0989F524E", hash_generated_method = "652CDC09119E13725C36A1627D245320")
        public  LayoutParams(int column) {
            this();
            this.column = column;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.350 -0400", hash_original_method = "DE4ED36682A1028E303BDCC28A48E06F", hash_generated_method = "66B55E9EFECAB48B3D28D153941B8308")
        public  LayoutParams(ViewGroup.LayoutParams p) {
            super(p);
            addTaint(p.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.350 -0400", hash_original_method = "CC87BD4B8C067788FA2BA37DBA116F62", hash_generated_method = "BDFD9CE52FB4D6304CCFF1CA731BA0A9")
        public  LayoutParams(MarginLayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.350 -0400", hash_original_method = "FC68734AF1365F8395009E059E8FEC81", hash_generated_method = "9BC9AB191252B2B65D8117351FFF8CA5")
        @Override
        protected void setBaseAttributes(TypedArray a, int widthAttr, int heightAttr) {
            addTaint(heightAttr);
            addTaint(widthAttr);
            addTaint(a.getTaint());
    if(a.hasValue(widthAttr))            
            {
                width = a.getLayoutDimension(widthAttr, "layout_width");
            } 
            else
            {
                width = MATCH_PARENT;
            } 
    if(a.hasValue(heightAttr))            
            {
                height = a.getLayoutDimension(heightAttr, "layout_height");
            } 
            else
            {
                height = WRAP_CONTENT;
            } 
            
            
                
            
                
            
            
                
            
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.350 -0400", hash_original_field = "012A4B30806EF170D386E0B946E74AA1", hash_generated_field = "E13ED3209622FEE16C7BB9C191FE8F66")

        private static final int LOCATION = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.350 -0400", hash_original_field = "9CFF123ACE9604E6154FEE9F6F7E0785", hash_generated_field = "934A445C55E10BBDBE903F1BA35DFAF1")

        private static final int LOCATION_NEXT = 1;
    }


    
    private class ChildrenTracker implements OnHierarchyChangeListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.350 -0400", hash_original_field = "D0B62CF0CD270BB58374F321620931FF", hash_generated_field = "F5EA6A3A542BD0A280910BBDD59E219A")

        private OnHierarchyChangeListener listener;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.350 -0400", hash_original_method = "8BC9074DC1C8352428B8EEF8AE4154F0", hash_generated_method = "8BC9074DC1C8352428B8EEF8AE4154F0")
        public ChildrenTracker ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.350 -0400", hash_original_method = "366CDDD217CE23168243D85764F583BC", hash_generated_method = "DDC70C8E2E013ACEDF81D1F8C000792F")
        private void setOnHierarchyChangeListener(OnHierarchyChangeListener listener) {
            this.listener = listener;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.351 -0400", hash_original_method = "0A8BC7BCBC1B19A4EC6087AEE2DC9AC1", hash_generated_method = "950EA03973C380A3D9816B05572FEAAA")
        public void onChildViewAdded(View parent, View child) {
            
            addTaint(child.getTaint());
            addTaint(parent.getTaint());
            mColumnToChildIndex = null;
    if(this.listener != null)            
            {
                this.listener.onChildViewAdded(parent, child);
            } 
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:11.351 -0400", hash_original_method = "BAF37826E19FE7806EA8737E4B16ECFB", hash_generated_method = "0F397F441033F28E44686D064703D9F9")
        public void onChildViewRemoved(View parent, View child) {
            
            addTaint(child.getTaint());
            addTaint(parent.getTaint());
            mColumnToChildIndex = null;
    if(this.listener != null)            
            {
                this.listener.onChildViewRemoved(parent, child);
            } 
            
            
            
                
            
        }

        
    }


    
}

