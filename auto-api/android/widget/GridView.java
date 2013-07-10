package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.animation.GridLayoutAnimationController;
import android.widget.RemoteViews.RemoteView;

public class GridView extends AbsListView {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.317 -0400", hash_original_field = "47E234C72F8463B7C6770D658A5E41C2", hash_generated_field = "CAA46A02DF073835D5C8346AD9A9CB63")

    private int mNumColumns = AUTO_FIT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.317 -0400", hash_original_field = "984A75716F93CAE1C49F1090E6A0CB2C", hash_generated_field = "E9FAC14F36FB56A0DCAB954B62C2DF2B")

    private int mHorizontalSpacing = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.317 -0400", hash_original_field = "FE80057B725E738FDE5E09E6B3B7F8F2", hash_generated_field = "A39AD23AD5FCB84AB23C237FC706C8F3")

    private int mRequestedHorizontalSpacing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.317 -0400", hash_original_field = "04A0AE56E019E90823DFCF538F9EB200", hash_generated_field = "84EB60F5A5BD3F778480F01C86BB8AA9")

    private int mVerticalSpacing = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.317 -0400", hash_original_field = "D2D9B35C5FA16AAC3C153C6F6D51079F", hash_generated_field = "AEA63239A963A24EEC1FCFD67B3B96A7")

    private int mStretchMode = STRETCH_COLUMN_WIDTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.317 -0400", hash_original_field = "E1663A40DA302B5F0D865267D61B180B", hash_generated_field = "20F46DBB58574C7E2F33333D8FE15571")

    private int mColumnWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.317 -0400", hash_original_field = "145243760978B68BCAB5FA8129C172AE", hash_generated_field = "7063064B546DF13BA7FDA901DDEC5780")

    private int mRequestedColumnWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.318 -0400", hash_original_field = "53E8A93614B65E7EB80706CE2B65D07B", hash_generated_field = "583D48FC72E3B18BBAD06B1F4E148F28")

    private int mRequestedNumColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.318 -0400", hash_original_field = "94710AAABC607EA664B744BE97844000", hash_generated_field = "7823B4B6322E0EBEB34297B0E440B23B")

    private View mReferenceView = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.318 -0400", hash_original_field = "5238F9CB997751442CCEC167A710A933", hash_generated_field = "E909A7C80DCAC01F178BEF4C30386FF5")

    private View mReferenceViewInSelectedRow = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.318 -0400", hash_original_field = "32B080F2E8D2B31FD5606656CD48D0F9", hash_generated_field = "B1F879D1C3141C34182BB7A64318C608")

    private int mGravity = Gravity.LEFT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.318 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

    private final Rect mTempRect = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.318 -0400", hash_original_method = "6B9AD93D67DF35D03ADA1536C0A58FBF", hash_generated_method = "983C8391566F7BB71FF28D509435B241")
    public  GridView(Context context) {
        super(context);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.318 -0400", hash_original_method = "2A531A248703ACB5E0E1C6A31088A2B2", hash_generated_method = "E11680A0214921982AE47985C34842A5")
    public  GridView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.gridViewStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.319 -0400", hash_original_method = "49F6501DFACF5B2EADDBFC02F7376929", hash_generated_method = "09148E5D0B2E1333FDDA7492A8FA2E79")
    public  GridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.GridView, defStyle, 0);
        int hSpacing = a.getDimensionPixelOffset(
                com.android.internal.R.styleable.GridView_horizontalSpacing, 0);
        setHorizontalSpacing(hSpacing);
        int vSpacing = a.getDimensionPixelOffset(
                com.android.internal.R.styleable.GridView_verticalSpacing, 0);
        setVerticalSpacing(vSpacing);
        int index = a.getInt(com.android.internal.R.styleable.GridView_stretchMode, STRETCH_COLUMN_WIDTH);
        {
            setStretchMode(index);
        } 
        int columnWidth = a.getDimensionPixelOffset(com.android.internal.R.styleable.GridView_columnWidth, -1);
        {
            setColumnWidth(columnWidth);
        } 
        int numColumns = a.getInt(com.android.internal.R.styleable.GridView_numColumns, 1);
        setNumColumns(numColumns);
        index = a.getInt(com.android.internal.R.styleable.GridView_gravity, -1);
        {
            setGravity(index);
        } 
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.319 -0400", hash_original_method = "0E1A05724C497F45D7FB6AC34C501814", hash_generated_method = "59AA1769A3E3A043C96BA3F7E798640B")
    @Override
    public ListAdapter getAdapter() {
        ListAdapter varB4EAC82CA7396A68D541C85D26508E83_475869519 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_475869519 = mAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_475869519.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_475869519;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.320 -0400", hash_original_method = "8AB2C6958FD7CEC3A8A71FE59763D6A4", hash_generated_method = "D18E7401555F2345B6B780E77B86E39C")
    @android.view.RemotableViewMethod
    public void setRemoteViewsAdapter(Intent intent) {
        super.setRemoteViewsAdapter(intent);
        addTaint(intent.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.320 -0400", hash_original_method = "3B0F7EFF2AD6466D19A6F404E2E1BAAD", hash_generated_method = "014B452474A7529F55549F247915612A")
    @Override
    public void setAdapter(ListAdapter adapter) {
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        } 
        resetList();
        mRecycler.clear();
        mAdapter = adapter;
        mOldSelectedPosition = INVALID_POSITION;
        mOldSelectedRowId = INVALID_ROW_ID;
        super.setAdapter(adapter);
        {
            mOldItemCount = mItemCount;
            mItemCount = mAdapter.getCount();
            mDataChanged = true;
            checkFocus();
            mDataSetObserver = new AdapterDataSetObserver();
            mAdapter.registerDataSetObserver(mDataSetObserver);
            mRecycler.setViewTypeCount(mAdapter.getViewTypeCount());
            int position;
            {
                position = lookForSelectablePosition(mItemCount - 1, false);
            } 
            {
                position = lookForSelectablePosition(0, true);
            } 
            setSelectedPositionInt(position);
            setNextSelectedPositionInt(position);
            checkSelectionChanged();
        } 
        {
            checkFocus();
            checkSelectionChanged();
        } 
        requestLayout();
        addTaint(adapter.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.321 -0400", hash_original_method = "D52FAC74E641441314EFBB7F4E58B879", hash_generated_method = "4DA2337E43CFD6E3733BF44A236499FA")
    @Override
     int lookForSelectablePosition(int position, boolean lookDown) {
        final ListAdapter adapter = mAdapter;
        {
            boolean var35A1F64E67CC6E0C06A8BA9582F2435F_1911003147 = (adapter == null || isInTouchMode());
        } 
        addTaint(position);
        addTaint(lookDown);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1094048923 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1094048923;
        
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.322 -0400", hash_original_method = "A62E9A831AF61A8CD347891B2F9D44DF", hash_generated_method = "20C31F9DFCBB2203974A00CA3CF0AA6C")
    @Override
     void fillGap(boolean down) {
        final int numColumns = mNumColumns;
        final int verticalSpacing = mVerticalSpacing;
        final int count = getChildCount();
        {
            int paddingTop = 0;
            {
                paddingTop = getListPaddingTop();
            } 
            int startOffset;
            startOffset = getChildAt(count - 1).getBottom() + verticalSpacing;
            startOffset = paddingTop;
            int position = mFirstPosition + count;
            {
                position += numColumns - 1;
            } 
            fillDown(position, startOffset);
            correctTooHigh(numColumns, verticalSpacing, getChildCount());
        } 
        {
            int paddingBottom = 0;
            {
                paddingBottom = getListPaddingBottom();
            } 
            int startOffset;
            startOffset = getChildAt(0).getTop() - verticalSpacing;
            startOffset = getHeight() - paddingBottom;
            int position = mFirstPosition;
            {
                position -= numColumns;
            } 
            fillUp(position, startOffset);
            correctTooLow(numColumns, verticalSpacing, getChildCount());
        } 
        addTaint(down);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.323 -0400", hash_original_method = "6F9360E73E1EB4E0BD6CC48A029E26CB", hash_generated_method = "C4450D49C4EDAA8E5ECCBC62C3F57865")
    private View fillDown(int pos, int nextTop) {
        View varB4EAC82CA7396A68D541C85D26508E83_1146601314 = null; 
        View selectedView = null;
        int end = (mBottom - mTop);
        {
            end -= mListPadding.bottom;
        } 
        {
            View temp = makeRow(pos, nextTop, true);
            {
                selectedView = temp;
            } 
            nextTop = mReferenceView.getBottom() + mVerticalSpacing;
            pos += mNumColumns;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1146601314 = selectedView;
        addTaint(pos);
        addTaint(nextTop);
        varB4EAC82CA7396A68D541C85D26508E83_1146601314.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1146601314;
        
        
        
        
            
        
        
            
            
                
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.324 -0400", hash_original_method = "DFB797BE7486A81865BE6BA7ABEE8F5A", hash_generated_method = "76100A3C1C919CF673805ABF398BC662")
    private View makeRow(int startPos, int y, boolean flow) {
        View varB4EAC82CA7396A68D541C85D26508E83_28353342 = null; 
        final int columnWidth = mColumnWidth;
        final int horizontalSpacing = mHorizontalSpacing;
        int last;
        int nextLeft = mListPadding.left +
                ((mStretchMode == STRETCH_SPACING_UNIFORM) ? horizontalSpacing : 0);
        {
            last = Math.min(startPos + mNumColumns, mItemCount);
        } 
        {
            last = startPos + 1;
            startPos = Math.max(0, startPos - mNumColumns + 1);
            {
                nextLeft += (mNumColumns - (last - startPos)) * (columnWidth + horizontalSpacing);
            } 
        } 
        View selectedView = null;
        final boolean hasFocus = shouldShowSelector();
        final boolean inClick = touchModeDrawsInPressedState();
        final int selectedPosition = mSelectedPosition;
        View child = null;
        {
            int pos = startPos;
            {
                boolean selected = pos == selectedPosition;
                int where;
                where = -1;
                where = pos - startPos;
                child = makeAndAddView(pos, y, flow, nextLeft, selected, where);
                nextLeft += columnWidth;
                {
                    nextLeft += horizontalSpacing;
                } 
                {
                    selectedView = child;
                } 
            } 
        } 
        mReferenceView = child;
        {
            mReferenceViewInSelectedRow = mReferenceView;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_28353342 = selectedView;
        addTaint(startPos);
        addTaint(y);
        addTaint(flow);
        varB4EAC82CA7396A68D541C85D26508E83_28353342.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_28353342;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.325 -0400", hash_original_method = "0AADB00D4F358179B46AC864F825D76F", hash_generated_method = "2945EE34408D064F08F11D8562811ADE")
    private View fillUp(int pos, int nextBottom) {
        View varB4EAC82CA7396A68D541C85D26508E83_452524835 = null; 
        View selectedView = null;
        int end = 0;
        {
            end = mListPadding.top;
        } 
        {
            View temp = makeRow(pos, nextBottom, false);
            {
                selectedView = temp;
            } 
            nextBottom = mReferenceView.getTop() - mVerticalSpacing;
            mFirstPosition = pos;
            pos -= mNumColumns;
        } 
        {
            mFirstPosition = Math.max(0, pos + 1);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_452524835 = selectedView;
        addTaint(pos);
        addTaint(nextBottom);
        varB4EAC82CA7396A68D541C85D26508E83_452524835.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_452524835;
        
        
        
        
            
        
        
            
            
                
            
            
            
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.325 -0400", hash_original_method = "ECD7EEB642891ACE11FADF160200B8D1", hash_generated_method = "28725EBD2FE1D145D4A97F6707CF462A")
    private View fillFromTop(int nextTop) {
        View varB4EAC82CA7396A68D541C85D26508E83_891061474 = null; 
        mFirstPosition = Math.min(mFirstPosition, mSelectedPosition);
        mFirstPosition = Math.min(mFirstPosition, mItemCount - 1);
        {
            mFirstPosition = 0;
        } 
        mFirstPosition -= mFirstPosition % mNumColumns;
        varB4EAC82CA7396A68D541C85D26508E83_891061474 = fillDown(mFirstPosition, nextTop);
        addTaint(nextTop);
        varB4EAC82CA7396A68D541C85D26508E83_891061474.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_891061474;
        
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.326 -0400", hash_original_method = "0818B9EEFC7CF79A0018AB61F39070C0", hash_generated_method = "7AFAD75CABE985821ADE347B3AC62788")
    private View fillFromBottom(int lastPosition, int nextBottom) {
        View varB4EAC82CA7396A68D541C85D26508E83_1067460467 = null; 
        lastPosition = Math.max(lastPosition, mSelectedPosition);
        lastPosition = Math.min(lastPosition, mItemCount - 1);
        final int invertedPosition = mItemCount - 1 - lastPosition;
        lastPosition = mItemCount - 1 - (invertedPosition - (invertedPosition % mNumColumns));
        varB4EAC82CA7396A68D541C85D26508E83_1067460467 = fillUp(lastPosition, nextBottom);
        addTaint(lastPosition);
        addTaint(nextBottom);
        varB4EAC82CA7396A68D541C85D26508E83_1067460467.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1067460467;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.327 -0400", hash_original_method = "B869E7B5DD0E41AF8A9344426795B32C", hash_generated_method = "9ACAF10645C946A8307F2C315A19DB5E")
    private View fillSelection(int childrenTop, int childrenBottom) {
        View varB4EAC82CA7396A68D541C85D26508E83_318142310 = null; 
        final int selectedPosition = reconcileSelectedPosition();
        final int numColumns = mNumColumns;
        final int verticalSpacing = mVerticalSpacing;
        int rowStart;
        int rowEnd = -1;
        {
            rowStart = selectedPosition - (selectedPosition % numColumns);
        } 
        {
            final int invertedSelection = mItemCount - 1 - selectedPosition;
            rowEnd = mItemCount - 1 - (invertedSelection - (invertedSelection % numColumns));
            rowStart = Math.max(0, rowEnd - numColumns + 1);
        } 
        final int fadingEdgeLength = getVerticalFadingEdgeLength();
        final int topSelectionPixel = getTopSelectionPixel(childrenTop, fadingEdgeLength, rowStart);
        final View sel = makeRow(mStackFromBottom ? rowEnd : rowStart, topSelectionPixel, true);
        mFirstPosition = rowStart;
        final View referenceView = mReferenceView;
        {
            fillDown(rowStart + numColumns, referenceView.getBottom() + verticalSpacing);
            pinToBottom(childrenBottom);
            fillUp(rowStart - numColumns, referenceView.getTop() - verticalSpacing);
            adjustViewsUpOrDown();
        } 
        {
            final int bottomSelectionPixel = getBottomSelectionPixel(childrenBottom,
                    fadingEdgeLength, numColumns, rowStart);
            final int offset = bottomSelectionPixel - referenceView.getBottom();
            offsetChildrenTopAndBottom(offset);
            fillUp(rowStart - 1, referenceView.getTop() - verticalSpacing);
            pinToTop(childrenTop);
            fillDown(rowEnd + numColumns, referenceView.getBottom() + verticalSpacing);
            adjustViewsUpOrDown();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_318142310 = sel;
        addTaint(childrenTop);
        addTaint(childrenBottom);
        varB4EAC82CA7396A68D541C85D26508E83_318142310.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_318142310;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.327 -0400", hash_original_method = "535BA4E594C209A488B214DB13AE774F", hash_generated_method = "183F1CC83CF78BAA834DFE9B52393FFA")
    private void pinToTop(int childrenTop) {
        {
            final int top = getChildAt(0).getTop();
            final int offset = childrenTop - top;
            {
                offsetChildrenTopAndBottom(offset);
            } 
        } 
        addTaint(childrenTop);
        
        
            
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.327 -0400", hash_original_method = "554B5C3A9DEE69BDD0B0F70052D29046", hash_generated_method = "75833691CC9D2BD85AF9430F4F88C3F5")
    private void pinToBottom(int childrenBottom) {
        final int count = getChildCount();
        {
            final int bottom = getChildAt(count - 1).getBottom();
            final int offset = childrenBottom - bottom;
            {
                offsetChildrenTopAndBottom(offset);
            } 
        } 
        addTaint(childrenBottom);
        
        
        
            
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.328 -0400", hash_original_method = "584D06EE6653E11D28AE97D7ADF4C3E4", hash_generated_method = "97735C049FE478C9D7825ED64DCCAC7B")
    @Override
     int findMotionRow(int y) {
        final int childCount = getChildCount();
        {
            final int numColumns = mNumColumns;
            {
                {
                    int i = 0;
                    i += numColumns;
                    {
                        {
                            boolean varC0173D202327EB6C7A35540C10A8AA25_833984286 = (y <= getChildAt(i).getBottom());
                        } 
                    } 
                } 
            } 
            {
                {
                    int i = childCount - 1;
                    i -= numColumns;
                    {
                        {
                            boolean var0C308B788546DD5F7421232B1F43CEB9_460209984 = (y >= getChildAt(i).getTop());
                        } 
                    } 
                } 
            } 
        } 
        addTaint(y);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594195247 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594195247;
        
        
        
            
            
                
                    
                        
                    
                
            
                
                    
                        
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.329 -0400", hash_original_method = "2BE5C63CD6BB6072D8C1046433555060", hash_generated_method = "51E2D7F46A5164E7F91C0E159CECA252")
    private View fillSpecific(int position, int top) {
        View varB4EAC82CA7396A68D541C85D26508E83_181065247 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_584820986 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_159459474 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1537907054 = null; 
        final int numColumns = mNumColumns;
        int motionRowStart;
        int motionRowEnd = -1;
        {
            motionRowStart = position - (position % numColumns);
        } 
        {
            final int invertedSelection = mItemCount - 1 - position;
            motionRowEnd = mItemCount - 1 - (invertedSelection - (invertedSelection % numColumns));
            motionRowStart = Math.max(0, motionRowEnd - numColumns + 1);
        } 
        final View temp = makeRow(mStackFromBottom ? motionRowEnd : motionRowStart, top, true);
        mFirstPosition = motionRowStart;
        final View referenceView = mReferenceView;
        {
            varB4EAC82CA7396A68D541C85D26508E83_181065247 = null;
        } 
        final int verticalSpacing = mVerticalSpacing;
        View above;
        View below;
        {
            above = fillUp(motionRowStart - numColumns, referenceView.getTop() - verticalSpacing);
            adjustViewsUpOrDown();
            below = fillDown(motionRowStart + numColumns, referenceView.getBottom() + verticalSpacing);
            final int childCount = getChildCount();
            {
                correctTooHigh(numColumns, verticalSpacing, childCount);
            } 
        } 
        {
            below = fillDown(motionRowEnd + numColumns, referenceView.getBottom() + verticalSpacing);
            adjustViewsUpOrDown();
            above = fillUp(motionRowStart - 1, referenceView.getTop() - verticalSpacing);
            final int childCount = getChildCount();
            {
                correctTooLow(numColumns, verticalSpacing, childCount);
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_584820986 = temp;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_159459474 = above;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1537907054 = below;
        } 
        addTaint(position);
        addTaint(top);
        View varA7E53CE21691AB073D9660D615818899_1421503162; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1421503162 = varB4EAC82CA7396A68D541C85D26508E83_181065247;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1421503162 = varB4EAC82CA7396A68D541C85D26508E83_584820986;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1421503162 = varB4EAC82CA7396A68D541C85D26508E83_159459474;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1421503162 = varB4EAC82CA7396A68D541C85D26508E83_1537907054;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1421503162.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1421503162;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.330 -0400", hash_original_method = "61C0C7B3D4F01380F7804BB62430F50F", hash_generated_method = "9B129800E798013B18D5C5098F4A2D24")
    private void correctTooHigh(int numColumns, int verticalSpacing, int childCount) {
        final int lastPosition = mFirstPosition + childCount - 1;
        {
            final View lastChild = getChildAt(childCount - 1);
            final int lastBottom = lastChild.getBottom();
            final int end = (mBottom - mTop) - mListPadding.bottom;
            int bottomOffset = end - lastBottom;
            final View firstChild = getChildAt(0);
            final int firstTop = firstChild.getTop();
            {
                {
                    bottomOffset = Math.min(bottomOffset, mListPadding.top - firstTop);
                } 
                offsetChildrenTopAndBottom(bottomOffset);
                {
                    fillUp(mFirstPosition - (mStackFromBottom ? 1 : numColumns),
                            firstChild.getTop() - verticalSpacing);
                    adjustViewsUpOrDown();
                } 
            } 
        } 
        addTaint(numColumns);
        addTaint(verticalSpacing);
        addTaint(childCount);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.331 -0400", hash_original_method = "C582B4D472853F3118C6A87E3BA2D3CE", hash_generated_method = "646854DBD19FF8C854B462E639AAD06D")
    private void correctTooLow(int numColumns, int verticalSpacing, int childCount) {
        {
            final View firstChild = getChildAt(0);
            final int firstTop = firstChild.getTop();
            final int start = mListPadding.top;
            final int end = (mBottom - mTop) - mListPadding.bottom;
            int topOffset = firstTop - start;
            final View lastChild = getChildAt(childCount - 1);
            final int lastBottom = lastChild.getBottom();
            final int lastPosition = mFirstPosition + childCount - 1;
            {
                {
                    topOffset = Math.min(topOffset, lastBottom - end);
                } 
                offsetChildrenTopAndBottom(-topOffset);
                {
                    fillDown(lastPosition + (!mStackFromBottom ? 1 : numColumns),
                            lastChild.getBottom() + verticalSpacing);
                    adjustViewsUpOrDown();
                } 
            } 
        } 
        addTaint(numColumns);
        addTaint(verticalSpacing);
        addTaint(childCount);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.332 -0400", hash_original_method = "AC707126EF44BD77373D761D306CE415", hash_generated_method = "BD193A64921B31FFA8189BFAB6055974")
    private View fillFromSelection(int selectedTop, int childrenTop, int childrenBottom) {
        View varB4EAC82CA7396A68D541C85D26508E83_5200195 = null; 
        final int fadingEdgeLength = getVerticalFadingEdgeLength();
        final int selectedPosition = mSelectedPosition;
        final int numColumns = mNumColumns;
        final int verticalSpacing = mVerticalSpacing;
        int rowStart;
        int rowEnd = -1;
        {
            rowStart = selectedPosition - (selectedPosition % numColumns);
        } 
        {
            int invertedSelection = mItemCount - 1 - selectedPosition;
            rowEnd = mItemCount - 1 - (invertedSelection - (invertedSelection % numColumns));
            rowStart = Math.max(0, rowEnd - numColumns + 1);
        } 
        View sel;
        View referenceView;
        int topSelectionPixel = getTopSelectionPixel(childrenTop, fadingEdgeLength, rowStart);
        int bottomSelectionPixel = getBottomSelectionPixel(childrenBottom, fadingEdgeLength,
                numColumns, rowStart);
        sel = makeRow(mStackFromBottom ? rowEnd : rowStart, selectedTop, true);
        mFirstPosition = rowStart;
        referenceView = mReferenceView;
        adjustForTopFadingEdge(referenceView, topSelectionPixel, bottomSelectionPixel);
        adjustForBottomFadingEdge(referenceView, topSelectionPixel, bottomSelectionPixel);
        {
            fillUp(rowStart - numColumns, referenceView.getTop() - verticalSpacing);
            adjustViewsUpOrDown();
            fillDown(rowStart + numColumns, referenceView.getBottom() + verticalSpacing);
        } 
        {
            fillDown(rowEnd + numColumns, referenceView.getBottom() + verticalSpacing);
            adjustViewsUpOrDown();
            fillUp(rowStart - 1, referenceView.getTop() - verticalSpacing);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_5200195 = sel;
        addTaint(selectedTop);
        addTaint(childrenTop);
        addTaint(childrenBottom);
        varB4EAC82CA7396A68D541C85D26508E83_5200195.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_5200195;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.332 -0400", hash_original_method = "3B93521E4F8B514C6E0E966E64E45808", hash_generated_method = "71A351A25512F80A49A58098E4DBABC1")
    private int getBottomSelectionPixel(int childrenBottom, int fadingEdgeLength,
            int numColumns, int rowStart) {
        int bottomSelectionPixel = childrenBottom;
        {
            bottomSelectionPixel -= fadingEdgeLength;
        } 
        addTaint(childrenBottom);
        addTaint(fadingEdgeLength);
        addTaint(numColumns);
        addTaint(rowStart);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_998910773 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_998910773;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.333 -0400", hash_original_method = "D0A32123B024D3BD3B829FD608C467F8", hash_generated_method = "5D8E98B1B2AA91287EF4F8D4DCF3E556")
    private int getTopSelectionPixel(int childrenTop, int fadingEdgeLength, int rowStart) {
        int topSelectionPixel = childrenTop;
        {
            topSelectionPixel += fadingEdgeLength;
        } 
        addTaint(childrenTop);
        addTaint(fadingEdgeLength);
        addTaint(rowStart);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1492354476 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1492354476;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.333 -0400", hash_original_method = "683433A1D2226A93C6C052E4367B337E", hash_generated_method = "92C1EFC307029EEAFBC514844049D1B4")
    private void adjustForBottomFadingEdge(View childInSelectedRow,
            int topSelectionPixel, int bottomSelectionPixel) {
        {
            boolean var2726325E9F58F141269CF4C5709BEFD8_501645767 = (childInSelectedRow.getBottom() > bottomSelectionPixel);
            {
                int spaceAbove = childInSelectedRow.getTop() - topSelectionPixel;
                int spaceBelow = childInSelectedRow.getBottom() - bottomSelectionPixel;
                int offset = Math.min(spaceAbove, spaceBelow);
                offsetChildrenTopAndBottom(-offset);
            } 
        } 
        addTaint(childInSelectedRow.getTaint());
        addTaint(topSelectionPixel);
        addTaint(bottomSelectionPixel);
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.334 -0400", hash_original_method = "E9E54F71CD8326C8AF2C780315CD689D", hash_generated_method = "76872DB91BCBFA85C95FFB3B8DA7B527")
    private void adjustForTopFadingEdge(View childInSelectedRow,
            int topSelectionPixel, int bottomSelectionPixel) {
        {
            boolean varA6AD2992672F69243A86BE094F867981_890330042 = (childInSelectedRow.getTop() < topSelectionPixel);
            {
                int spaceAbove = topSelectionPixel - childInSelectedRow.getTop();
                int spaceBelow = bottomSelectionPixel - childInSelectedRow.getBottom();
                int offset = Math.min(spaceAbove, spaceBelow);
                offsetChildrenTopAndBottom(offset);
            } 
        } 
        addTaint(childInSelectedRow.getTaint());
        addTaint(topSelectionPixel);
        addTaint(bottomSelectionPixel);
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.335 -0400", hash_original_method = "19B54E9E42F50C19B80602093C26BC32", hash_generated_method = "7A5836635E40602F9283C444E4C38BE2")
    @android.view.RemotableViewMethod
    public void smoothScrollToPosition(int position) {
        super.smoothScrollToPosition(position);
        addTaint(position);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.335 -0400", hash_original_method = "9A2E566018459C8A4F9FE2F49DBB98B8", hash_generated_method = "DF8A45AA7313754A97BDE7860400CCDD")
    @android.view.RemotableViewMethod
    public void smoothScrollByOffset(int offset) {
        super.smoothScrollByOffset(offset);
        addTaint(offset);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.338 -0400", hash_original_method = "55F676D436FF1EC67ECC1C028E81ED27", hash_generated_method = "907F36AFEC8E15FF5E6BEDF140EEB01F")
    private View moveSelection(int delta, int childrenTop, int childrenBottom) {
        View varB4EAC82CA7396A68D541C85D26508E83_1674731948 = null; 
        final int fadingEdgeLength = getVerticalFadingEdgeLength();
        final int selectedPosition = mSelectedPosition;
        final int numColumns = mNumColumns;
        final int verticalSpacing = mVerticalSpacing;
        int oldRowStart;
        int rowStart;
        int rowEnd = -1;
        {
            oldRowStart = (selectedPosition - delta) - ((selectedPosition - delta) % numColumns);
            rowStart = selectedPosition - (selectedPosition % numColumns);
        } 
        {
            int invertedSelection = mItemCount - 1 - selectedPosition;
            rowEnd = mItemCount - 1 - (invertedSelection - (invertedSelection % numColumns));
            rowStart = Math.max(0, rowEnd - numColumns + 1);
            invertedSelection = mItemCount - 1 - (selectedPosition - delta);
            oldRowStart = mItemCount - 1 - (invertedSelection - (invertedSelection % numColumns));
            oldRowStart = Math.max(0, oldRowStart - numColumns + 1);
        } 
        final int rowDelta = rowStart - oldRowStart;
        final int topSelectionPixel = getTopSelectionPixel(childrenTop, fadingEdgeLength, rowStart);
        final int bottomSelectionPixel = getBottomSelectionPixel(childrenBottom, fadingEdgeLength,
                numColumns, rowStart);
        mFirstPosition = rowStart;
        View sel;
        View referenceView;
        {
            int oldBottom;
            oldBottom = 0;
            oldBottom = mReferenceViewInSelectedRow.getBottom();
            sel = makeRow(mStackFromBottom ? rowEnd : rowStart, oldBottom + verticalSpacing, true);
            referenceView = mReferenceView;
            adjustForBottomFadingEdge(referenceView, topSelectionPixel, bottomSelectionPixel);
        } 
        {
            int oldTop;
            oldTop = 0;
            oldTop = mReferenceViewInSelectedRow .getTop();
            sel = makeRow(mStackFromBottom ? rowEnd : rowStart, oldTop - verticalSpacing, false);
            referenceView = mReferenceView;
            adjustForTopFadingEdge(referenceView, topSelectionPixel, bottomSelectionPixel);
        } 
        {
            int oldTop;
            oldTop = 0;
            oldTop = mReferenceViewInSelectedRow .getTop();
            sel = makeRow(mStackFromBottom ? rowEnd : rowStart, oldTop, true);
            referenceView = mReferenceView;
        } 
        {
            fillUp(rowStart - numColumns, referenceView.getTop() - verticalSpacing);
            adjustViewsUpOrDown();
            fillDown(rowStart + numColumns, referenceView.getBottom() + verticalSpacing);
        } 
        {
            fillDown(rowEnd + numColumns, referenceView.getBottom() + verticalSpacing);
            adjustViewsUpOrDown();
            fillUp(rowStart - 1, referenceView.getTop() - verticalSpacing);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1674731948 = sel;
        addTaint(delta);
        addTaint(childrenTop);
        addTaint(childrenBottom);
        varB4EAC82CA7396A68D541C85D26508E83_1674731948.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1674731948;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.340 -0400", hash_original_method = "971C7C8872B1F8EEBA5FB107FC6F8364", hash_generated_method = "8101D679ADA3F1E5EFCA9E3A2E9DE7CB")
    private boolean determineColumns(int availableSpace) {
        final int requestedHorizontalSpacing = mRequestedHorizontalSpacing;
        final int stretchMode = mStretchMode;
        final int requestedColumnWidth = mRequestedColumnWidth;
        boolean didNotInitiallyFit = false;
        {
            {
                mNumColumns = (availableSpace + requestedHorizontalSpacing) /
                        (requestedColumnWidth + requestedHorizontalSpacing);
            } 
            {
                mNumColumns = 2;
            } 
        } 
        {
            mNumColumns = mRequestedNumColumns;
        } 
        {
            mNumColumns = 1;
        } 
        
        mColumnWidth = requestedColumnWidth;
        
        
        mHorizontalSpacing = requestedHorizontalSpacing;
        
        
        int spaceLeftOver = availableSpace - (mNumColumns * requestedColumnWidth) -
                    ((mNumColumns - 1) * requestedHorizontalSpacing);
        
        
        {
            didNotInitiallyFit = true;
        } 
        
        
        
        mColumnWidth = requestedColumnWidth + spaceLeftOver / mNumColumns;
        
        
        mHorizontalSpacing = requestedHorizontalSpacing;
        
        
        mColumnWidth = requestedColumnWidth;
        
        
        {
            mHorizontalSpacing = requestedHorizontalSpacing + 
                        spaceLeftOver / (mNumColumns - 1);
        } 
        {
            mHorizontalSpacing = requestedHorizontalSpacing + spaceLeftOver;
        } 
        
        
        mColumnWidth = requestedColumnWidth;
        
        
        {
            mHorizontalSpacing = requestedHorizontalSpacing + 
                        spaceLeftOver / (mNumColumns + 1);
        } 
        {
            mHorizontalSpacing = requestedHorizontalSpacing + spaceLeftOver;
        } 
        
        
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2052711870 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2052711870;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.342 -0400", hash_original_method = "DE2B2122B3B8477B4CE53B0961FAB462", hash_generated_method = "C96CAF271C800D20CF61739DE1920EAD")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        {
            {
                widthSize = mColumnWidth + mListPadding.left + mListPadding.right;
            } 
            {
                widthSize = mListPadding.left + mListPadding.right;
            } 
            widthSize += getVerticalScrollbarWidth();
        } 
        int childWidth = widthSize - mListPadding.left - mListPadding.right;
        boolean didNotInitiallyFit = determineColumns(childWidth);
        int childHeight = 0;
        int childState = 0;
        mItemCount = mAdapter == null ? 0 : mAdapter.getCount();
        final int count = mItemCount;
        {
            final View child = obtainView(0, mIsScrap);
            AbsListView.LayoutParams p = (AbsListView.LayoutParams)child.getLayoutParams();
            {
                p = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, 0);
                child.setLayoutParams(p);
            } 
            p.viewType = mAdapter.getItemViewType(0);
            p.forceAdd = true;
            int childHeightSpec = getChildMeasureSpec(
                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), 0, p.height);
            int childWidthSpec = getChildMeasureSpec(
                    MeasureSpec.makeMeasureSpec(mColumnWidth, MeasureSpec.EXACTLY), 0, p.width);
            child.measure(childWidthSpec, childHeightSpec);
            childHeight = child.getMeasuredHeight();
            childState = combineMeasuredStates(childState, child.getMeasuredState());
            {
                boolean varE2DAD11F47B1E984D553A4A012EB052E_422226342 = (mRecycler.shouldRecycleViewType(p.viewType));
                {
                    mRecycler.addScrapView(child, -1);
                } 
            } 
        } 
        {
            heightSize = mListPadding.top + mListPadding.bottom + childHeight +
                    getVerticalFadingEdgeLength() * 2;
        } 
        {
            int ourSize = mListPadding.top + mListPadding.bottom;
            final int numColumns = mNumColumns;
            {
                int i = 0;
                i += numColumns;
                {
                    ourSize += childHeight;
                    {
                        ourSize += mVerticalSpacing;
                    } 
                    {
                        ourSize = heightSize;
                    } 
                } 
            } 
            heightSize = ourSize;
        } 
        {
            int ourSize = (mRequestedNumColumns*mColumnWidth)
                    + ((mRequestedNumColumns-1)*mHorizontalSpacing)
                    + mListPadding.left + mListPadding.right;
            {
                widthSize |= MEASURED_STATE_TOO_SMALL;
            } 
        } 
        setMeasuredDimension(widthSize, heightSize);
        mWidthMeasureSpec = widthMeasureSpec;
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.342 -0400", hash_original_method = "B083102DF451B0F743637B4C2ECFBD00", hash_generated_method = "920EB3211E36AB8FF8C93E6A47BFD22F")
    @Override
    protected void attachLayoutAnimationParameters(View child,
            ViewGroup.LayoutParams params, int index, int count) {
        GridLayoutAnimationController.AnimationParameters animationParams = (GridLayoutAnimationController.AnimationParameters) params.layoutAnimationParameters;
        {
            animationParams = new GridLayoutAnimationController.AnimationParameters();
            params.layoutAnimationParameters = animationParams;
        } 
        animationParams.count = count;
        animationParams.index = index;
        animationParams.columnsCount = mNumColumns;
        animationParams.rowsCount = count / mNumColumns;
        {
            animationParams.column = index % mNumColumns;
            animationParams.row = index / mNumColumns;
        } 
        {
            final int invertedIndex = count - 1 - index;
            animationParams.column = mNumColumns - 1 - (invertedIndex % mNumColumns);
            animationParams.row = animationParams.rowsCount - 1 - invertedIndex / mNumColumns;
        } 
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        addTaint(index);
        addTaint(count);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.344 -0400", hash_original_method = "22970971C8FD1FE9524617A911939C41", hash_generated_method = "8BD4A44F740B203CEF24F8F252A4730B")
    @Override
    protected void layoutChildren() {
        final boolean blockLayoutRequests = mBlockLayoutRequests;
        {
            mBlockLayoutRequests = true;
        } 
        try 
        {
            super.layoutChildren();
            invalidate();
            {
                resetList();
                invokeOnItemScrollListener();
            } 
            final int childrenTop = mListPadding.top;
            final int childrenBottom = mBottom - mTop - mListPadding.bottom;
            int childCount = getChildCount();
            int index;
            int delta = 0;
            View sel;
            View oldSel = null;
            View oldFirst = null;
            View newSel = null;
            
            index = mNextSelectedPosition - mFirstPosition;
            
            
            {
                newSel = getChildAt(index);
            } 
            
            
            {
                delta = mNextSelectedPosition - mSelectedPosition;
            } 
            
            
            index = mSelectedPosition - mFirstPosition;
            
            
            {
                oldSel = getChildAt(index);
            } 
            
            
            oldFirst = getChildAt(0);
            
            boolean dataChanged = mDataChanged;
            {
                handleDataChanged();
            } 
            {
                resetList();
                invokeOnItemScrollListener();
            } 
            setSelectedPositionInt(mNextSelectedPosition);
            final int firstPosition = mFirstPosition;
            final RecycleBin recycleBin = mRecycler;
            {
                {
                    int i = 0;
                    {
                        recycleBin.addScrapView(getChildAt(i), firstPosition+i);
                    } 
                } 
            } 
            {
                recycleBin.fillActiveViews(childCount, firstPosition);
            } 
            detachAllViewsFromParent();
            
            {
                sel = fillFromSelection(newSel.getTop(), childrenTop, childrenBottom);
            } 
            {
                sel = fillSelection(childrenTop, childrenBottom);
            } 
            
            
            mFirstPosition = 0;
            
            
            sel = fillFromTop(childrenTop);
            
            
            adjustViewsUpOrDown();
            
            
            sel = fillUp(mItemCount - 1, childrenBottom);
            
            
            adjustViewsUpOrDown();
            
            
            sel = fillSpecific(mSelectedPosition, mSpecificTop);
            
            
            sel = fillSpecific(mSyncPosition, mSpecificTop);
            
            
            sel = moveSelection(delta, childrenTop, childrenBottom);
            
            
            {
                {
                    setSelectedPositionInt(mAdapter == null || isInTouchMode() ?
                                INVALID_POSITION : 0);
                    sel = fillFromTop(childrenTop);
                } 
                {
                    final int last = mItemCount - 1;
                    setSelectedPositionInt(mAdapter == null || isInTouchMode() ?
                                INVALID_POSITION : last);
                    sel = fillFromBottom(last, childrenBottom);
                } 
            } 
            {
                {
                    sel = fillSpecific(mSelectedPosition, oldSel == null ?
                                childrenTop : oldSel.getTop());
                } 
                {
                    sel = fillSpecific(mFirstPosition, oldFirst == null ?
                                childrenTop : oldFirst.getTop());
                } 
                {
                    sel = fillSpecific(0, childrenTop);
                } 
            } 
            
            recycleBin.scrapActiveViews();
            {
                positionSelector(INVALID_POSITION, sel);
                mSelectedTop = sel.getTop();
            } 
            {
                View child = getChildAt(mMotionPosition - mFirstPosition);
                positionSelector(mMotionPosition, child);
            } 
            {
                mSelectedTop = 0;
                mSelectorRect.setEmpty();
            } 
            mLayoutMode = LAYOUT_NORMAL;
            mDataChanged = false;
            mNeedSync = false;
            setNextSelectedPositionInt(mSelectedPosition);
            updateScrollIndicators();
            {
                checkSelectionChanged();
            } 
            invokeOnItemScrollListener();
        } 
        finally 
        {
            {
                mBlockLayoutRequests = false;
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.347 -0400", hash_original_method = "D1571833DCBC36BAA4E4DA8F2A5DB363", hash_generated_method = "F31FFC858933E0E508A25363AD10F209")
    private View makeAndAddView(int position, int y, boolean flow, int childrenLeft,
            boolean selected, int where) {
        View varB4EAC82CA7396A68D541C85D26508E83_1034863369 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_625413617 = null; 
        View child;
        {
            child = mRecycler.getActiveView(position);
            {
                setupChild(child, position, y, flow, childrenLeft, selected, true, where);
                varB4EAC82CA7396A68D541C85D26508E83_1034863369 = child;
            } 
        } 
        child = obtainView(position, mIsScrap);
        setupChild(child, position, y, flow, childrenLeft, selected, mIsScrap[0], where);
        varB4EAC82CA7396A68D541C85D26508E83_625413617 = child;
        addTaint(position);
        addTaint(y);
        addTaint(flow);
        addTaint(childrenLeft);
        addTaint(selected);
        addTaint(where);
        View varA7E53CE21691AB073D9660D615818899_1279651099; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1279651099 = varB4EAC82CA7396A68D541C85D26508E83_1034863369;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1279651099 = varB4EAC82CA7396A68D541C85D26508E83_625413617;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1279651099.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1279651099;
        
        
        
            
            
                
                
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.349 -0400", hash_original_method = "F1D84EEF4E6902A923E61B402C707D18", hash_generated_method = "1D7764A5B92F504F825F6272A68FCEF2")
    private void setupChild(View child, int position, int y, boolean flow, int childrenLeft,
            boolean selected, boolean recycled, int where) {
        boolean isSelected = selected && shouldShowSelector();
        final boolean updateChildSelected = isSelected != child.isSelected();
        final int mode = mTouchMode;
        final boolean isPressed = mode > TOUCH_MODE_DOWN && mode < TOUCH_MODE_SCROLL &&
                mMotionPosition == position;
        final boolean updateChildPressed = isPressed != child.isPressed();
        boolean needToMeasure = !recycled || updateChildSelected || child.isLayoutRequested();
        AbsListView.LayoutParams p = (AbsListView.LayoutParams)child.getLayoutParams();
        {
            p = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 0);
        } 
        p.viewType = mAdapter.getItemViewType(position);
        {
            attachViewToParent(child, where, p);
        } 
        {
            p.forceAdd = false;
            addViewInLayout(child, where, p, true);
        } 
        {
            child.setSelected(isSelected);
            {
                requestFocus();
            } 
        } 
        {
            child.setPressed(isPressed);
        } 
        {
            {
                ((Checkable) child).setChecked(mCheckStates.get(position));
            } 
            {
                boolean var6B8ECFCCB35D70022AE775423EF95EFF_476056533 = (getContext().getApplicationInfo().targetSdkVersion
                    >= android.os.Build.VERSION_CODES.HONEYCOMB);
                {
                    child.setActivated(mCheckStates.get(position));
                } 
            } 
        } 
        {
            int childHeightSpec = ViewGroup.getChildMeasureSpec(
                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), 0, p.height);
            int childWidthSpec = ViewGroup.getChildMeasureSpec(
                    MeasureSpec.makeMeasureSpec(mColumnWidth, MeasureSpec.EXACTLY), 0, p.width);
            child.measure(childWidthSpec, childHeightSpec);
        } 
        {
            cleanupLayoutState(child);
        } 
        final int w = child.getMeasuredWidth();
        final int h = child.getMeasuredHeight();
        int childLeft;
        int childTop;
        childTop = y;
        childTop = y - h;
        final int layoutDirection = getResolvedLayoutDirection();
        final int absoluteGravity = Gravity.getAbsoluteGravity(mGravity, layoutDirection);
        
        childLeft = childrenLeft;
        
        
        childLeft = childrenLeft + ((mColumnWidth - w) / 2);
        
        
        childLeft = childrenLeft + mColumnWidth - w;
        
        
        childLeft = childrenLeft;
        
        {
            final int childRight = childLeft + w;
            final int childBottom = childTop + h;
            child.layout(childLeft, childTop, childRight, childBottom);
        } 
        {
            child.offsetLeftAndRight(childLeft - child.getLeft());
            child.offsetTopAndBottom(childTop - child.getTop());
        } 
        {
            child.setDrawingCacheEnabled(true);
        } 
        {
            boolean varCA9C9DB394586E5C1281E2A995FFCD63_1326471166 = (recycled && (((AbsListView.LayoutParams)child.getLayoutParams()).scrappedFromPosition)
                != position);
            {
                child.jumpDrawablesToCurrentState();
            } 
        } 
        addTaint(child.getTaint());
        addTaint(position);
        addTaint(y);
        addTaint(flow);
        addTaint(childrenLeft);
        addTaint(selected);
        addTaint(recycled);
        addTaint(where);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.350 -0400", hash_original_method = "F036989DC17B53D064E56E9048AF8088", hash_generated_method = "C77FF5F443D41B3D73A7083A4242D5FB")
    @Override
    public void setSelection(int position) {
        {
            boolean var3DA6B9D2A4DFFBF2A8164819B7AFE9DF_1719269300 = (!isInTouchMode());
            {
                setNextSelectedPositionInt(position);
            } 
            {
                mResurrectToPosition = position;
            } 
        } 
        mLayoutMode = LAYOUT_SET_SELECTION;
        requestLayout();
        addTaint(position);
        
        
            
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.350 -0400", hash_original_method = "BFD03D39F54176AB600127B7C1132704", hash_generated_method = "6603BF60F3A4E688A27AF4FE310DE5FB")
    @Override
     void setSelectionInt(int position) {
        int previousSelectedPosition = mNextSelectedPosition;
        setNextSelectedPositionInt(position);
        layoutChildren();
        int next;
        next = mItemCount - 1  - mNextSelectedPosition;
        next = mNextSelectedPosition;
        int previous;
        previous = mItemCount - 1
                - previousSelectedPosition;
        previous = previousSelectedPosition;
        final int nextRow = next / mNumColumns;
        final int previousRow = previous / mNumColumns;
        {
            awakenScrollBars();
        } 
        addTaint(position);
        
        
        
        
        
            
        
                
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.350 -0400", hash_original_method = "82498D99AFEB0700B1F959E9E9927B59", hash_generated_method = "9184D3DE417E5B17799A24521E5D040B")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        
        boolean var7B6BE27715D36B6032CB7DA2718D4FF1_1270459517 = (commonKey(keyCode, 1, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_73796860 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_73796860;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.351 -0400", hash_original_method = "C105EC1B6481173F2A66D1C47882507B", hash_generated_method = "AD316FD544D9639BD227ECBD76E35BEE")
    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        
        boolean varACEC8A58158104BC4BBB2FE543212B03_868897399 = (commonKey(keyCode, repeatCount, event));
        addTaint(keyCode);
        addTaint(repeatCount);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1911425142 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1911425142;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.351 -0400", hash_original_method = "FFB4A1626C41573790F9B17FF23F8A09", hash_generated_method = "3F9171D71135357FE7379EDE7FF6C739")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        
        boolean var7B6BE27715D36B6032CB7DA2718D4FF1_1187586670 = (commonKey(keyCode, 1, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1049744082 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1049744082;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.353 -0400", hash_original_method = "91535B300D60431313446AA401FFCFE7", hash_generated_method = "120829C74630F6ABA1E3A3273D8BC6EE")
    private boolean commonKey(int keyCode, int count, KeyEvent event) {
        {
            layoutChildren();
        } 
        boolean handled = false;
        int action = event.getAction();
        {
            
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1133299019 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_LEFT);
                } 
            } 
            
            
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_397813388 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_RIGHT);
                } 
            } 
            
            
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_538080686 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_UP);
                } 
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_591982751 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
                    } 
                } 
            } 
            
            
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_116293319 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_DOWN);
                } 
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_764040405 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
                    } 
                } 
            } 
            
            
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1444879576 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded();
                    {
                        boolean var8C90301B2F58C5750CCB877C7F321644_1384868128 = (!handled
                                && event.getRepeatCount() == 0 && getChildCount() > 0);
                        {
                            keyPressed();
                            handled = true;
                        } 
                    } 
                } 
            } 
            
            
            {
                boolean varC5267D5BFE7A3E261BDE80A07A8ECCFA_309962291 = (mPopup == null || !mPopup.isShowing());
                {
                    {
                        boolean var3A3095F7575E47050F710FB26AF5006E_412009853 = (event.hasNoModifiers());
                        {
                            handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_DOWN);
                        } 
                        {
                            boolean varC6F58190DE4A31A0CF9704EF99A62451_1553266199 = (event.hasModifiers(KeyEvent.META_SHIFT_ON));
                            {
                                handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_UP);
                            } 
                        } 
                    } 
                } 
            } 
            
            
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_474992704 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_UP);
                } 
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_301644987 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
                    } 
                } 
            } 
            
            
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_814294103 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_DOWN);
                } 
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_283461133 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
                    } 
                } 
            } 
            
            
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1562989894 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
                } 
            } 
            
            
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_2085754326 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
                } 
            } 
            
            
            {
                {
                    boolean varC77C0C11194BD87DFEE086A32DCE5C18_749023608 = (event.hasNoModifiers());
                    {
                        handled = resurrectSelectionIfNeeded()
                                    || sequenceScroll(FOCUS_FORWARD);
                    } 
                    {
                        boolean var7B1040B2192949CFC257B6EE7F25C319_252601659 = (event.hasModifiers(KeyEvent.META_SHIFT_ON));
                        {
                            handled = resurrectSelectionIfNeeded()
                                    || sequenceScroll(FOCUS_BACKWARD);
                        } 
                    } 
                } 
            } 
            
        } 
        {
            boolean varF6449376E291BB335EF050093EE80110_135812313 = (sendToTextFilter(keyCode, count, event));
        } 
        
        boolean var8C6E6C19273FC56B5C56CC7DEF63ED7B_1885528281 = (super.onKeyDown(keyCode, event));
        
        
        boolean varEDD771EBF66425AD21882AB08CD0EE48_1341716889 = (super.onKeyUp(keyCode, event));
        
        
        boolean varC0357E39557DD275ECAF43C782C78502_1687640517 = (super.onKeyMultiple(keyCode, count, event));
        
        addTaint(keyCode);
        addTaint(count);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1712721116 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1712721116;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.354 -0400", hash_original_method = "7F69D44B4A5B870A2ADF67B34BC1B3FD", hash_generated_method = "192EDD041EBF5CE600733A494B692100")
     boolean pageScroll(int direction) {
        int nextPage = -1;
        {
            nextPage = Math.max(0, mSelectedPosition - getChildCount());
        } 
        {
            nextPage = Math.min(mItemCount - 1, mSelectedPosition + getChildCount());
        } 
        {
            setSelectionInt(nextPage);
            invokeOnItemScrollListener();
            awakenScrollBars();
        } 
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_832507532 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_832507532;
        
        
        
            
        
            
        
        
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.354 -0400", hash_original_method = "8921946161DEF2C387CE09B16F70206C", hash_generated_method = "B90D24A346D0B1F24499AE63532F4426")
     boolean fullScroll(int direction) {
        boolean moved = false;
        {
            mLayoutMode = LAYOUT_SET_SELECTION;
            setSelectionInt(0);
            invokeOnItemScrollListener();
            moved = true;
        } 
        {
            mLayoutMode = LAYOUT_SET_SELECTION;
            setSelectionInt(mItemCount - 1);
            invokeOnItemScrollListener();
            moved = true;
        } 
        {
            awakenScrollBars();
        } 
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_271276455 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_271276455;
        
        
        
            
            
            
            
        
            
            
            
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.356 -0400", hash_original_method = "8CD79681F48962D4344E68AA337F0770", hash_generated_method = "69F1F833F4DAEAB153CAA1DECD88B321")
     boolean arrowScroll(int direction) {
        final int selectedPosition = mSelectedPosition;
        final int numColumns = mNumColumns;
        int startOfRowPos;
        int endOfRowPos;
        boolean moved = false;
        {
            startOfRowPos = (selectedPosition / numColumns) * numColumns;
            endOfRowPos = Math.min(startOfRowPos + numColumns - 1, mItemCount - 1);
        } 
        {
            final int invertedSelection = mItemCount - 1 - selectedPosition;
            endOfRowPos = mItemCount - 1 - (invertedSelection / numColumns) * numColumns;
            startOfRowPos = Math.max(0, endOfRowPos - numColumns + 1);
        } 
        
        {
            mLayoutMode = LAYOUT_MOVE_SELECTION;
            setSelectionInt(Math.max(0, selectedPosition - numColumns));
            moved = true;
        } 
        
        
        {
            mLayoutMode = LAYOUT_MOVE_SELECTION;
            setSelectionInt(Math.min(selectedPosition + numColumns, mItemCount - 1));
            moved = true;
        } 
        
        
        {
            mLayoutMode = LAYOUT_MOVE_SELECTION;
            setSelectionInt(Math.max(0, selectedPosition - 1));
            moved = true;
        } 
        
        
        {
            mLayoutMode = LAYOUT_MOVE_SELECTION;
            setSelectionInt(Math.min(selectedPosition + 1, mItemCount - 1));
            moved = true;
        } 
        
        {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
            invokeOnItemScrollListener();
        } 
        {
            awakenScrollBars();
        } 
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1917682565 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1917682565;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.357 -0400", hash_original_method = "3D7E63CDF154AB38FFF5F8515CF699BF", hash_generated_method = "7055CDF430F4F7C4F4D32BC91C20ECA0")
     boolean sequenceScroll(int direction) {
        int selectedPosition = mSelectedPosition;
        int numColumns = mNumColumns;
        int count = mItemCount;
        int startOfRow;
        int endOfRow;
        {
            startOfRow = (selectedPosition / numColumns) * numColumns;
            endOfRow = Math.min(startOfRow + numColumns - 1, count - 1);
        } 
        {
            int invertedSelection = count - 1 - selectedPosition;
            endOfRow = count - 1 - (invertedSelection / numColumns) * numColumns;
            startOfRow = Math.max(0, endOfRow - numColumns + 1);
        } 
        boolean moved = false;
        boolean showScroll = false;
        
        {
            mLayoutMode = LAYOUT_MOVE_SELECTION;
            setSelectionInt(selectedPosition + 1);
            moved = true;
            showScroll = selectedPosition == endOfRow;
        } 
        
        
        {
            mLayoutMode = LAYOUT_MOVE_SELECTION;
            setSelectionInt(selectedPosition - 1);
            moved = true;
            showScroll = selectedPosition == startOfRow;
        } 
        
        {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
            invokeOnItemScrollListener();
        } 
        {
            awakenScrollBars();
        } 
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_473043265 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_473043265;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.359 -0400", hash_original_method = "0FD361D132773200063DCB66E88E964C", hash_generated_method = "FBA9B33410C21F66F137FA8AD8208110")
    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        int closestChildIndex = -1;
        {
            previouslyFocusedRect.offset(mScrollX, mScrollY);
            Rect otherRect = mTempRect;
            int minDistance = Integer.MAX_VALUE;
            final int childCount = getChildCount();
            {
                int i = 0;
                {
                    {
                        boolean var4F49F74F736BC8C7CC9FE76A9F30A707_708496096 = (!isCandidateSelection(i, direction));
                    } 
                    final View other = getChildAt(i);
                    other.getDrawingRect(otherRect);
                    offsetDescendantRectToMyCoords(other, otherRect);
                    int distance = getDistance(previouslyFocusedRect, otherRect, direction);
                    {
                        minDistance = distance;
                        closestChildIndex = i;
                    } 
                } 
            } 
        } 
        {
            setSelection(closestChildIndex + mFirstPosition);
        } 
        {
            requestLayout();
        } 
        addTaint(gainFocus);
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.360 -0400", hash_original_method = "84D213429BEB1496C8F56DF85FD23E87", hash_generated_method = "5661536A71EFC3D2A647691BBE1AA078")
    private boolean isCandidateSelection(int childIndex, int direction) {
        final int count = getChildCount();
        final int invertedIndex = count - 1 - childIndex;
        int rowStart;
        int rowEnd;
        {
            rowStart = childIndex - (childIndex % mNumColumns);
            rowEnd = Math.max(rowStart + mNumColumns - 1, count);
        } 
        {
            rowEnd = count - 1 - (invertedIndex - (invertedIndex % mNumColumns));
            rowStart = Math.max(0, rowEnd - mNumColumns + 1);
        } 
        
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("direction must be one of "
                        + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, "
                        + "FOCUS_FORWARD, FOCUS_BACKWARD}.");
        
        addTaint(childIndex);
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_492729560 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_492729560;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.361 -0400", hash_original_method = "FC2053B842AF8EFA285EBFCDE9A6D098", hash_generated_method = "BAD7C3D6E170462E620A3F127FF1B253")
    public void setGravity(int gravity) {
        {
            mGravity = gravity;
            requestLayoutIfNecessary();
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.361 -0400", hash_original_method = "F4AD294FF1286508B5C248EDCA212E5B", hash_generated_method = "0974E6853BAE84E8A34EC949A0ED119B")
    public void setHorizontalSpacing(int horizontalSpacing) {
        {
            mRequestedHorizontalSpacing = horizontalSpacing;
            requestLayoutIfNecessary();
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.362 -0400", hash_original_method = "18D0FB9D8A0D215DBABAAD70588CEE39", hash_generated_method = "D293B570439C006E3649F59931BF24AA")
    public void setVerticalSpacing(int verticalSpacing) {
        {
            mVerticalSpacing = verticalSpacing;
            requestLayoutIfNecessary();
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.362 -0400", hash_original_method = "C49A7586B9CFE9BA77F47A780C0C8544", hash_generated_method = "D39AC0879D99FD55925DCABCD912FF43")
    public void setStretchMode(int stretchMode) {
        {
            mStretchMode = stretchMode;
            requestLayoutIfNecessary();
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.362 -0400", hash_original_method = "B323AFE5AE5939BBDA58166A4DF4B096", hash_generated_method = "C20E393CB238B5AAEB390A75DB0A9483")
    public int getStretchMode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1597822350 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1597822350;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.363 -0400", hash_original_method = "2D3707A47407D7324964709BC50279C2", hash_generated_method = "BB62D2A99825B7D1702BE76188A98365")
    public void setColumnWidth(int columnWidth) {
        {
            mRequestedColumnWidth = columnWidth;
            requestLayoutIfNecessary();
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.363 -0400", hash_original_method = "EB843153C85390AE48F1C91EE0B42CDB", hash_generated_method = "FA6F80A9406D7B9F5F4E2A6711A09668")
    public void setNumColumns(int numColumns) {
        {
            mRequestedNumColumns = numColumns;
            requestLayoutIfNecessary();
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.364 -0400", hash_original_method = "B011FDCEBE38F0939F62249D6B5BC711", hash_generated_method = "0E25B2B5F1569A4F0FCDB9596849D23C")
    @ViewDebug.ExportedProperty
    public int getNumColumns() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293335790 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293335790;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.364 -0400", hash_original_method = "614329ACA245384517EF28FF3609B04B", hash_generated_method = "BBDB4F923C267C822EF2AFE19D9F06D9")
    private void adjustViewsUpOrDown() {
        final int childCount = getChildCount();
        {
            int delta;
            View child;
            {
                child = getChildAt(0);
                delta = child.getTop() - mListPadding.top;
                {
                    delta -= mVerticalSpacing;
                } 
                {
                    delta = 0;
                } 
            } 
            {
                child = getChildAt(childCount - 1);
                delta = child.getBottom() - (getHeight() - mListPadding.bottom);
                {
                    delta += mVerticalSpacing;
                } 
                {
                    delta = 0;
                } 
            } 
            {
                offsetChildrenTopAndBottom(-delta);
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.365 -0400", hash_original_method = "0FB16985DD2A598E66D7882D349B86AF", hash_generated_method = "707CCD73FFA3FEB7573AC577B31599B7")
    @Override
    protected int computeVerticalScrollExtent() {
        final int count = getChildCount();
        {
            final int numColumns = mNumColumns;
            final int rowCount = (count + numColumns - 1) / numColumns;
            int extent = rowCount * 100;
            View view = getChildAt(0);
            final int top = view.getTop();
            int height = view.getHeight();
            {
                extent += (top * 100) / height;
            } 
            view = getChildAt(count - 1);
            final int bottom = view.getBottom();
            height = view.getHeight();
            {
                extent -= ((bottom - getHeight()) * 100) / height;
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027895522 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027895522;
        
        
        
            
            
            
            
            
            
            
                
            
            
            
            
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.366 -0400", hash_original_method = "77C851014C1118924C7173C75459421E", hash_generated_method = "BA543F24D0E5E1E5F6DD950BEF9D6AA4")
    @Override
    protected int computeVerticalScrollOffset() {
        {
            boolean var55F650244283761A6D0270E03F2533A0_2131393537 = (mFirstPosition >= 0 && getChildCount() > 0);
            {
                final View view = getChildAt(0);
                final int top = view.getTop();
                int height = view.getHeight();
                {
                    final int numColumns = mNumColumns;
                    final int whichRow = mFirstPosition / numColumns;
                    final int rowCount = (mItemCount + numColumns - 1) / numColumns;
                    int varBBCDFA4A3F60B9FD9A50F6BC86F61153_993032444 = (Math.max(whichRow * 100 - (top * 100) / height +
                        (int) ((float) mScrollY / getHeight() * rowCount * 100), 0));
                } 
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067329626 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067329626;
        
        
            
            
            
            
                
                
                
                
                        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.367 -0400", hash_original_method = "2E67C9F09804D125789DA130D24F2E03", hash_generated_method = "F4EA2C2727543190578F6ED38E4DC22C")
    @Override
    protected int computeVerticalScrollRange() {
        final int numColumns = mNumColumns;
        final int rowCount = (mItemCount + numColumns - 1) / numColumns;
        int result = Math.max(rowCount * 100, 0);
        {
            result += Math.abs((int) ((float) mScrollY / getHeight() * rowCount * 100));
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1433089544 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1433089544;
        
        
        
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.368 -0400", hash_original_field = "3C6C842350FA9DF4AF7C1577C5481D7F", hash_generated_field = "9591D43DFDB00D3CA815C6412336BEEB")

    public static final int NO_STRETCH = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.368 -0400", hash_original_field = "C781279666F1CFCA96E5F3E8F379648C", hash_generated_field = "9E8C93D13663D982A634A608E98FDD9B")

    public static final int STRETCH_SPACING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.368 -0400", hash_original_field = "93F50EC30CD0856C8A19939E9B64DED3", hash_generated_field = "289B7802E2F88C85889BF1B0A565B14F")

    public static final int STRETCH_COLUMN_WIDTH = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.368 -0400", hash_original_field = "321EC49DA83893E4048EDCC856EFEFB3", hash_generated_field = "6D329753C82DAECBEDD98AD073821537")

    public static final int STRETCH_SPACING_UNIFORM = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.368 -0400", hash_original_field = "57174C1594A18EA6304DDA366FEF8B68", hash_generated_field = "4306712C3BDDA946F401316F516F19DA")

    public static final int AUTO_FIT = -1;
}

